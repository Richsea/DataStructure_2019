public class PrintTree {
    private BinaryTree root;

    public PrintTree(BinaryTree root)
    {
        this.root = root;
    }
    public void levelOrderPrint()
    {
        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
        LinkedList<Object> printList = new LinkedList<Object>();
        BinaryTree subtrees;

        if(root == null) return;

        queue.addLast(root);

        while(queue.size() != 0)
        {
            subtrees = queue.poll();
            if(subtrees.getLeft() != null) queue.addLast(subtrees.getLeft());
            if(subtrees.getRight() != null) queue.addLast(subtrees.getRight());

            printList.addLast(subtrees);
        }
        printConsole(printList);
    }

    public void printConsole(LinkedList<Object> list)
    {
        if(list.size() == 0)    return;
        System.out.println(list.get(0));
        for(int i = 1; i < list.size(); i++)
        {
            System.out.println(" -> ");
            System.out.print(list.get(i));
        }
    }
}
