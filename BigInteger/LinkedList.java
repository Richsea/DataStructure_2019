public class LinkedList implements List{
    private Node start = new Node(-1, null);

    @Override
    public void insert(int x)
    {
        Node currentNode = start;
        Node nextNode = start.next;
        Node newNode = new Node(x, null);

        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
        }

        while(nextNode != null && nextNode.value <= x)
        {
            currentNode = nextNode;
            nextNode = currentNode.next;
        }

        currentNode.next = newNode;
        newNode.next = nextNode;
    }

    @Override
    public void delete(int x)
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
    public int get(int x)
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

    @Override
    public Boolean addFirst(int x)
    {
        Node currentNode = start.next;
        Node newNode = new Node(x, null);

        start.next = newNode;
        newNode.next = currentNode;

        return true;
    }

    @Override
    public Boolean addLast(int x)
    {
        Node currentNode = start;
        Node newNode = new Node(x, null);

        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
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
    }

    @Override
    public int size()
    {
        Node currentNode = start;
        int size = 0;

        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
            size++;
        }

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
    }

    public Boolean contains(int x)
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

    @Override
    public void changeLast(int x)
    {
        Node currentNode = start;

        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
        }

        currentNode.setData(x);

    }

    public static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        void setData(int value)
        {
            this.value = value;
        }
    }
}
