public class AVLTree {

    private AVLNode root;

    public void insert(int data)
    {
        // 노드 삽입을 위한 공개함수
    }

    private AVLNode insert(int x, AVLNode t)
    {
        // 실제 삽입을 처리하는 내부 함수
        return null;
    }

    private void rotateLeft()
    {
        // 왼쪽으로 회전
    }

    // rotate binary tree node with right child
    private void rotateRight()
    {
        // 오른쪽으로 회전
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
