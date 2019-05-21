public class Main {
    public static void main(String[] args)
    {
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
        bTree.delete(80);

        bTree.insert(80);

        // root has right & successor has right
        // root has right & successor don't have right
        // root has right but don't hae right.left

        // root has left & successor has left
        // root has left & successor don't have left
        // root has left but don't have left.right




    }
}
