public class LinkedList implements List {
    private Node start = new Node(-1, null);
    private int size;

    @Override
    public void delete(Object x)
    {
        Node currentNode = start;
        Node prevNode = start;

        while(true)
        {
            if(currentNode.value == x)
            {
                prevNode.next = currentNode.next;
                return;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;

            if(currentNode == null) break;
        }
        return;
    }

    @Override
    public Boolean addFirst(Object x)
    {
        Node currentNode = start.next;
        Node newNode = new Node(x, null);

        start.next = newNode;
        newNode.next = currentNode;
        size++;

        return true;
    }

    @Override
    public Boolean addLast(Object x)
    {
        Node currentNode = start;
        Node newNode = new Node(x, null);

        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        size++;

        return true;
    }

    @Override
    public void deleteLast()
    {
        Node currentNode = start;
        Node prevNode = start;

        while(currentNode.next != null)
        {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        prevNode.next = null;
        size--;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public void printList()
    {
        Node currentNode = start;

        if(start.next == null) {
            System.out.println("이 리스트의 크기는 비어있습니다.");
            return;
        }

        while(true) {
            currentNode = currentNode.next;

            if(currentNode.next == null)
            {
                System.out.println(currentNode.value);
                break;
            }
            System.out.print(currentNode.value + ", ");
        }
    }

    @Override
    public void clear()
    {
        start.next = null;
        size = 0;
    }

    @Override
    public Object getData(int x)
    {
        Node currentNode = start.next;

        if(x >= this.size())
            throw new IllegalStateException("no available data: null point exception");

        for(int i = 0; i < x; i++)
        {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    public Boolean contains(Object x)
    {
        Node currentNode = start;

        while(currentNode.next != null)
        {
            if(currentNode.value == x)
            {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        Object value;
        Node next;

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        void setData(int value)
        {
            this.value = value;
        }
    }
}
