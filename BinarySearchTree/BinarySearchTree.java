public class BinarySearchTree {
    Node root;

    public Boolean isEmpty()
    {
        if(this.root == null)
            return true;
        return false;
    }

    public boolean contains(int value)
    {
        Node newRoot = root;

        if(this.search(value) == null)
        {
            return false;
        }
        return true;
    }

    public boolean insert(int value)
    {
        if(root == null)
        {
            root = new Node(value, null, null);
            return true;
        }

        Node newRoot = root;

        while(value != newRoot.getKey())
        {
            if(value < newRoot.getKey())
            {
                if(newRoot.getLeft() != null) { newRoot = newRoot.getLeft(); }
                else
                {
                    newRoot.setLeft( new Node(value, null, null) );
                    return true;
                }
            }
            else
            {
                if(newRoot.getRight() != null) { newRoot = newRoot.getRight(); }
                else
                {
                    newRoot.setRight( new Node(value, null, null) );
                    return true;
                }
            }
        }

        return false;
    }

    public boolean delete(int value)
    {
        Node newRoot = root;
        Node parent = newRoot;
        boolean isLeft = false;

        if(root == null) return false;

        // root가 delete 될 경우
        if(newRoot.getKey() == value)
        {
            if(newRoot.getRight() == null)
            {
                if(newRoot.getLeft() == null)
                    root = null;
                else
                    root = root.getLeft();
            }
            else if(newRoot.getLeft() == null)
            {
                root = root.getRight();
            }
            else
            {
                root.setKey(this.getSuccessor(newRoot).getKey());
            }
            return  true;
        }

        while(newRoot.getKey() != value)
        {
            if(value < newRoot.getKey())
            {
                if(newRoot.getLeft() == null) return false;
                parent = newRoot;
                newRoot = newRoot.getLeft();
                isLeft = true;
            }
            else
            {
                if(newRoot.getRight() == null) return false;
                parent = newRoot;
                newRoot = newRoot.getRight();
                isLeft = false;
            }
        }

        if(newRoot.getRight() == null)
        {
            if(newRoot.getLeft() == null)   // newRoot의 child가 둘 다 null일 경우
                newRoot = null;
            else                            // newRoot의 leftChild만 null이 아닌 경우
                newRoot = newRoot.getLeft();
        }
        else if(newRoot.getLeft() == null)
        {
            newRoot = newRoot.getRight();
        }
        else
        {
            newRoot = new Node(this.getSuccessor(newRoot).getKey(), newRoot.getLeft(), newRoot.getRight());
        }

        if(isLeft)
            parent.setLeft(newRoot);
        else
            parent.setRight(newRoot);


        return true;
    }

    private Node search(int value)
    {
        Node newRoot = root;

        if(root == null) return null;

        while(newRoot.getKey() != value)
        {
            if (value < newRoot.getKey())
            {
                if (newRoot.getLeft() != null) { newRoot = newRoot.getLeft(); }
                else {  return null;   }
            }
            else
            {
                if(newRoot.getRight() != null) { newRoot = newRoot.getRight(); }
                else { return null; }
            }
        }
        return newRoot;
    }

    private Node getSuccessor(Node root)
    {
        Node newRoot = root;
        Node result;

        if(newRoot.getRight().getLeft() == null)
        {
            //result = new Node(newRoot.getRight().getKey(), newRoot.getLeft(), newRoot.getRight());
            result = newRoot.getRight();

            if(newRoot.getRight().getRight() == null)
                newRoot.setRight(null);
            else
                newRoot.setRight(newRoot.getRight().getRight());
        }
        else
        {
            newRoot = newRoot.getRight();

            while(newRoot.getLeft().getLeft() != null)
            {
                newRoot = newRoot.getLeft();
            }

            result = newRoot.getLeft();

            // successor의 child가 둘 다 존재하지 않을 경우
            if(newRoot.getLeft().getRight() == null)
            {
                newRoot.setLeft(null);
            }
            else    // successor의 right child가 존재하는 경우
            {
                newRoot.setLeft(newRoot.getLeft().getRight());
            }
        }

        return result;
    }

    public class Node
    {
        int key;
        Node left;
        Node right;

        public Node(int key, Node left, Node right)
        {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public int getKey(){ return key; }
        public void setKey(int key) { this.key = key; }
        public Node getLeft(){ return left; }
        public void setLeft(Node left) { this.left = left;}
        public Node getRight(){ return right; }
        public void setRight(Node right) { this.right = right;}
    }
}