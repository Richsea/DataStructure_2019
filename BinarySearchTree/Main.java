public class Main {
    public static void main(String[] args)
    {
        /*
        BinarySearchTree test
         */
        BinarySearchTree bTree = new BinarySearchTree();

        bTree.insert(55);
        bTree.insert(22);
        bTree.insert(77);
        bTree.insert(18);
        bTree.insert(44);
        bTree.insert(70);
        bTree.insert(88);
        bTree.insert(30);
        bTree.insert(27);
        bTree.insert(33);
        bTree.insert(60);
        bTree.insert(74);
        bTree.insert(80);
        bTree.insert(94);
        bTree.insert(66);
        bTree.insert(63);
        bTree.insert(69);

        // delete no subtree case
        bTree.delete(94);
        bTree.delete(88);
        bTree.insert(88);
        bTree.delete(80);

        bTree.insert(90);
        bTree.insert(80);

        bTree.delete(77);
        // 여기까진 정상
        bTree.delete(80);   //.right.left가 존재 x + .right.right존재
        bTree.delete(88);   //.right.left가 존재 x + .right.right도 존재 x

        /*
        AVLTree Test
         */
        AVLTree avlTree = new AVLTree();
        avlTree.insert(0);
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);

        avlTree.inOrder();
        avlTree.preOrder();
    }
}
