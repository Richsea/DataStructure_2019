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
        Node newRoot;

        if(this.contains(value))
        {
            newRoot = root;
            Node successor;

            newRoot = search(value);

             if(newRoot.getRight() != null)
            {
                successor = newRoot.getRight();

                if(successor.getLeft() == null)
                {
                    newRoot.setKey(successor.getKey());
                    newRoot.setRight(successor.getRight());

                    return true;
                }

                while(successor.getLeft().getLeft() != null)
                {
                    successor = successor.getLeft();
                }
                //데이터 설정
                newRoot.setKey(successor.getLeft().getKey());
                if(successor.getLeft().getRight() != null)
                    successor.setLeft(successor.getLeft().getRight());
                else
                    successor.setLeft(null);
            }
            else if(newRoot.getLeft() != null)
            {
                successor = newRoot.getLeft();

                if(successor.getRight() == null)
                {
                    newRoot.setKey(successor.getKey());
                    newRoot.setLeft(successor.getLeft());

                    return true;
                }

                while(successor.getRight().getRight() != null)
                {
                    successor = successor.getRight();
                }

                newRoot.setKey(successor.getRight().getKey());
                if(successor.getRight().getLeft() != null)
                    successor.setRight(successor.getRight().getLeft());
                else
                    successor.setRight(null);

            }
            else
            {
                Node temp = root;
                while(true)
                {
                    if(temp.getKey() < newRoot.getKey())
                    {
                        temp.getLeft().getLeft() != null
                    }
                }

                newRoot = null;
            }
            return true;
        }

        /*
        rightNode 존재 -> rightNode의 leftNode의 LeftNode의 ....
        rightNode 존재x && leftNode 존재 -> leftNode의 rightNode의 rightNode의 rightNode ...
        leftNode & rightNode 둘다 존재 x -> 끝
         */
        return false;
    }

    private Node search(int value)
    {
        Node newRoot = root;

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
    private Node searchParent(int value)
    {
        Node newRoot = root;

        if(newRoot == null)
            return newRoot;

        while(true)
        {
            if(value < newRoot.getKey())
            {
                if(newRoot.getLeft().getKey() == value)
                {

                }
                if(newRoot.getRight().getKey() == value)
                {

                }
                if(newRoot.getLeft().getLeft() != null && newRoot.getLeft().getRight() != null)
                {

                }
            }
            else if(value > newRoot.getKey())
            {

            }
            if(newRoot.getLeft() != null)
            {

            }
            if(value < newRoot.getKey())
            {
                if(newRoot.getLeft() != null)
            }
            if(newRoot.getLeft() != null)
            {

            }
        }
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