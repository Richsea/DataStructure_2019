public class AVLTree {

    private AVLNode root;
    private AVLNode balanceRoot;

    public void insert(int data)
    {
        balanceRoot = root;
        root = this.insert(data, root);
    }

    private AVLNode insert(int x, AVLNode t)
    {
        AVLNode parent = balanceRoot;
        AVLNode newNode = t;

        if(t == null)
            return new AVLNode(x);

        if(root.key == x)
            return root;

        if(x < t.key)
        {
            newNode.left = insert(x, newNode.left);
        }
        else
        {
            newNode.right = insert(x, newNode.right);
        }

        balanceRoot = newNode;
        this.rebalance();
        balanceRoot = parent;

        return newNode;
    }

    private void rotateLeft()
    {
        AVLNode newLeft = new AVLNode(balanceRoot.key);
        newLeft.left = balanceRoot.left;
        newLeft.right = balanceRoot.right.left;         // left rotate시 기존 right.left의 위치에 있던 Node들은 right에 옮기는 것이 가장 합당함.
        newLeft.height = 1 + Math.max(balanceRoot.left.height, balanceRoot.right.height);
        balanceRoot.left = newLeft;
        balanceRoot.key = balanceRoot.right.key;
        balanceRoot.right = balanceRoot.right.right;
    }

    // rotate binary tree node with right child
    private void rotateRight()
    {
        AVLNode newRight = new AVLNode(balanceRoot.key);
        newRight.left = balanceRoot.left.right;             // right rotate시 기존 left.right의 위치에 있던 Node들은 left에 옮기는 것이 가장 합당함
        newRight.right = balanceRoot.right;
        newRight.height = 1 + Math.max(balanceRoot.left.height, balanceRoot.right.height);
        balanceRoot.key = balanceRoot.left.key;
        balanceRoot.left = balanceRoot.left.left;
    }

    public boolean search(int val)
    {
        AVLNode newNode = root;

        while(newNode.key != val)
        {
            if(val < newNode.key)
            {
                if(newNode.left == null) return false;
                newNode = newNode.left;
            }
            else
            {
                if(newNode.right == null) return false;
                newNode = newNode.right;
            }
        }
        return true;
    }

    private void rebalance()
    {
        //banaceRoot.right와 left가 존재하는지 따져야됨
        if(balanceRoot.right.height > balanceRoot.left.height + 1)
        {
            if(balanceRoot.right.left.height > balanceRoot.right.right.height)
            {
                AVLNode temp = balanceRoot;
                balanceRoot = balanceRoot.right;
                this.rotateRight();
                balanceRoot = temp;
            }
            this.rotateLeft();
        }
        else if(balanceRoot.left.height > balanceRoot.right.height + 1)
        {
            if(balanceRoot.left.right.height > balanceRoot.left.left.height)
            {
                AVLNode temp = balanceRoot;
                balanceRoot = balanceRoot.left;
                this.rotateLeft();
                balanceRoot = temp;
            }
            this.rotateRight();
        }
    }

    // 탐색 알고리즘
    public void inOrder()
    {
        this.inOrderPrint(root);
    }

    public void preOrder()
    {
        this.preOrderPrint(root);
    }

    public void postOrder()
    {
        this.postOrderPrint(root);
    }

    private void postOrderPrint(AVLNode root)
    {
        if(root == null) return;
        if(root.left != null)
        {
            postOrderPrint(root.left);
            System.out.print(" -> ");
        }
        if(root.right != null)
        {
            postOrderPrint(root.right);
            System.out.print(" -> ");
        }
        System.out.print(root.key);
    }

    private void inOrderPrint(AVLNode root)
    {
        if(root == null) return;
        if(root.left != null)
        {
            inOrderPrint(root.left);
            System.out.print(" -> ");
        }
        System.out.print(root.key);
        if(root.right != null)
        {
            System.out.print(" -> ");
            inOrderPrint(root.right);
        }
    }

    private void preOrderPrint(AVLNode root)
    {
        if(root == null) return;
        System.out.print(root.key);
        if(root.left != null)
        {
            System.out.print(" -> ");
            preOrderPrint(root.left);
        }
        if(root.right != null)
        {
            System.out.print(" -> ");
            preOrderPrint(root.right);
        }
    }

    class AVLNode
    {
        AVLNode left, right;
        int key;
        int height;

        public AVLNode()
        {
            left = null;
            right = null;
            key = 0;
            height = 0;
        }

        public AVLNode(int n)
        {
            left = null;
            right = null;
            key = n;
            height = 0;
        }
    }
}
