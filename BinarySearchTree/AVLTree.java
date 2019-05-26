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
            newNode.height = this.decideHeight(newNode.left, newNode.right);
        }
        else
        {
            newNode.right = insert(x, newNode.right);
            newNode.height = this.decideHeight(newNode.left, newNode.right);
        }

        balanceRoot = newNode;
        this.rebalance();
        balanceRoot = parent;

        return newNode;
    }

    private void rotateLeft()
    {
        AVLNode newLeft = new AVLNode(balanceRoot.key);
        if(balanceRoot.left == null)
            newLeft.left = null;
        else
            newLeft.left = balanceRoot.left;

        if(balanceRoot.right.left == null)
            newLeft.right = null;
        else
            newLeft.right = balanceRoot.right.left;     // left rotate시 기존 right.left의 위치에 있던 Node들은 right에 옮기는 것이 가장 합당함.

        balanceRoot.left = newLeft;
        balanceRoot.key = balanceRoot.right.key;
        balanceRoot.right = balanceRoot.right.right;

        newLeft.height = this.decideHeight(newLeft.left, newLeft.right);
        balanceRoot.height = this.decideHeight(balanceRoot.left, balanceRoot.right);
        balanceRoot.right.height = this.decideHeight(balanceRoot.right.left, balanceRoot.right.right);

    }

    // rotate binary tree node with right child
    private void rotateRight()
    {
        AVLNode newRight = new AVLNode(balanceRoot.key);
        if(balanceRoot.left == null)
            newRight.left = null;
        else
            newRight.left = balanceRoot.left.right;         // right rotate시 기존 left.right의 위치에 있던 Node들은 left에 옮기는 것이 가장 합당함

        if(balanceRoot.right == null)
            newRight.right = null;
        else
            newRight.right = balanceRoot.right;

        balanceRoot.right = newRight;
        balanceRoot.key = balanceRoot.left.key;
        balanceRoot.left = balanceRoot.left.left;

        newRight.height = this.decideHeight(newRight.left, newRight.right);
        balanceRoot.height = this.decideHeight(balanceRoot.left, balanceRoot.right);
        balanceRoot.right.height = this.decideHeight(balanceRoot.left.left, balanceRoot.left.right);
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
        AVLNode temp;
        /*
        둘 다  null일 수는 없다
        둘 중 하나라도 null이라는 소리는 leafNode의 parent라는 의미
         */
        if(balanceRoot.left == null)
        {
            if(balanceRoot.right.height > 0)
                this.rotateLeft();

            return;
        }
        else if(balanceRoot.right == null)
        {
            if(balanceRoot.left.height > 0)
                this.rotateRight();

            return;
        }

        if (balanceRoot.right.height > balanceRoot.left.height + 1)
        {
            if (balanceRoot.right.left.height > balanceRoot.right.right.height)
            {
                temp = balanceRoot;
                balanceRoot = balanceRoot.right;
                this.rotateRight();
                balanceRoot = temp;
            }
            this.rotateLeft();
        }
        else if (balanceRoot.left.height > balanceRoot.right.height + 1)
        {
            if (balanceRoot.left.right.height > balanceRoot.left.left.height)
            {
                temp = balanceRoot;
                balanceRoot = balanceRoot.left;
                this.rotateLeft();
                balanceRoot = temp;
            }
            this.rotateRight();
        }
    }

    private int decideHeight(AVLNode left, AVLNode right)
    {
        if(left == null && right == null)
        {
            return 0;
        }

        if(right == null)
        {
            return left.height + 1;
        }
        if(left == null)
        {
            return right.height + 1;
        }

        return 1 + Math.max(left.height, right.height);

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
