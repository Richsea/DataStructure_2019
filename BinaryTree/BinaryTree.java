public class BinaryTree{
    private Object root;
    private BinaryTree left, right;

    BinaryTree(Object root)
    {
        this.root = root;
    }

    BinaryTree(Object root, BinaryTree left, BinaryTree right)
    {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    void setLeft(BinaryTree left)
    {
        this.left = left;
    }
    void setRight(BinaryTree right)
    {
        this.right = right;
    }
    void setData(Object data)
    {
        this.root = data;
    }
    BinaryTree getLeft()
    {
        return left;
    }
    BinaryTree getRight()
    {
        return right;
    }
    Object getData()
    {
        return root;
    }

    
}
