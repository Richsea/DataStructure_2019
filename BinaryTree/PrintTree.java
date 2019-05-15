public class PrintTree {
    private BinaryTree root;
    LinkedList<Object> printList;

    public PrintTree(BinaryTree root)
    {
        this.root = root;
    }

    public void levelOrderPrint()
    {
        LinkedList<BinaryTree> queue = new LinkedList<BinaryTree>();
        StringBuffer sb = new StringBuffer();
        BinaryTree subtrees;

        if(root == null) return;

        queue.addLast(root);

        while(queue.size() != 0)
        {
            subtrees = queue.poll();
            if(subtrees.getLeft() != null) queue.addLast(subtrees.getLeft());
            if(subtrees.getRight() != null) queue.addLast(subtrees.getRight());

            sb.append(subtrees.getData() + " -> ");
            //printList.addLast(subtrees.getData());
        }
        sb.delete(sb.length()-3, sb.length());
        System.out.print(sb);
    }

    /*
    전위 순서 순회
     */
    public void preOrderPrint(BinaryTree root)
    {
        if(root == null) return;
        System.out.print(root.getData());
        if(root.getLeft() != null)
        {

            System.out.print(" -> ");
            preOrderPrint(root.getLeft());
        }
        if(root.getRight() != null)
        {
            System.out.print(" -> ");
            preOrderPrint(root.getRight());
        }
    }

    /*
    후위 순서 순회
     */
    public void postOrderPrint(BinaryTree root)
    {
        if(root == null) return;
        if(root.getLeft() != null)
        {
            postOrderPrint(root.getLeft());
            System.out.print(" -> ");
        }
        if(root.getRight() != null)
        {
            postOrderPrint(root.getRight());
            System.out.print(" -> ");
        }
        System.out.print(root.getData());
    }

    /*
    중위 순서 순회
     */
    public void inOrderPrint(BinaryTree root)
    {
        if(root == null) return;
        if(root.getLeft() != null)
        {
            inOrderPrint(root.getLeft());
            System.out.print(" -> ");
        }
        System.out.print(root.getData());
        if(root.getRight() != null)
        {
            System.out.print(" -> ");
            inOrderPrint(root.getRight());
        }
    }
}
