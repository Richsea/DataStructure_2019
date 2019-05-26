public class AVLTree {

    private AVLNode root;

    public void insert(int data)
    {
        this.insert(data, root);
    }

    private AVLNode insert(int x, AVLNode t)
    {
        AVLNode newNode = t;

        if(t == null)
        {
            return new AVLNode(x);
        }

        if(x < t.key)
        {
            AVLNode addNode = this.insert(x, newNode.left);
            newNode.left = addNode;

        }
        else
        {
            this.insert(x, newNode.right);
        }

        // rotate 사용 this.rotateLeft();
        return null;
    }

    //현재 3개인 경우만 생각해서 작성함
    private void rotateLeft()
    {
        AVLNode newNode = root;

        // height를 따져야 하지 않을까...? + 3개가 아니라 .right.left가 존재하는 경우도 있지 않을까...?
        // 1자로 되어있는 조건에대해서 좀 더 주의해서 생각해보자.
        if(newNode.right.left == null)  // 일자로 되어 있는 경우
        {
            AVLNode newRoot = newNode.right;
            newRoot.left = newNode;
            newNode.right = null;
            root = newRoot;

            return;
        }

        this.rotateRight();
        newNode = root;
        this.rotateLeft();
    }

    // rotate binary tree node with right child
    private void rotateRight()
    {
        AVLNode newNode = root;

        if(newNode.left.right == null)
        {
            AVLNode newRoot = newNode.left;
            newRoot.right = newNode;
            newNode.right = null;
            root = newRoot;

            return;
        }

        this.rotateLeft();
        newNode = root;
        this.rotateRight();
    }

    public boolean search(int val)
    {
        // 해당하는 데이터 유무를 찾는 함수
        return false;
    }

    // 탐색 알고리즘
    public void inOrder(){}
    public void preOrder(){}
    public void postOrder(){}

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
