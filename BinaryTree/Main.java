public class Main {
    public static void main(String args[])
    {
        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
        int data = 0;
        BinaryTree root = new BinaryTree(data);
        BinaryTree tree;
        queue.addLast(root);
        tree = queue.poll();

        while(data != 10)
        {
            data ++;

            if(data %2 == 0)
            {
                tree.setRight(new BinaryTree(data));
                queue.addLast(tree.getRight());
                tree = queue.poll();
            }
            else
            {
                tree.setLeft(new BinaryTree(data));
                queue.addLast(tree.getLeft());
            }
        }
        tree.setRight(new BinaryTree(11));
        tree.getRight().setLeft(new BinaryTree(12));
        tree.getRight().setRight(new BinaryTree(13));

        PrintTree print = new PrintTree(root);
        System.out.println("[level order print]");
        print.levelOrderPrint();
        System.out.println("\n\n[pre order print]");
        print.preOrderPrint(root);
        System.out.println("\n\n[post order print]");
        print.postOrderPrint(root);
        System.out.println("\n\n[in order print]");
        print.inOrderPrint(root);

    }
}
