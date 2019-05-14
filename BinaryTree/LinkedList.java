public class LinkedList<T> implements List<T> {
    private Node<T> start = new Node(null, null);

    @Override
    public void insert(T x)
    {
        /*
        Node currentNode = start;
        Node nextNode = start.next;
        Node newNode = new Node(x, null);

        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
        }

        while(nextNode != null)
        {
            currentNode = nextNode;
            nextNode = currentNode.next;
        }

        currentNode.next = newNode;
        newNode.next = nextNode;
        */
    }

    @Override
    public void delete(T x)
    {
        Node<T> currentNode = start;
        Node<T> prevNode = start;

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
    public T get(int x)
    {
        Node<T> currentNode = start.next;

        if(x >= this.size())
            throw new IllegalStateException("no availaible data: null point exception");

        for(int i = 0; i < x; i++)
        {
            currentNode = currentNode.next;
        }

        return currentNode.value;
    }

    @Override
    public Boolean addLast(T x)
    {
        Node<T> currentNode = start;
        Node<T> newNode = new Node(x, null);

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
        Node<T> currentNode = start;
        Node<T> prevNode = start;

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
        Node<T> currentNode = start;
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
        Node<T> currentNode = start;

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

    public T poll()
    {
        Node<T> currentNode = start;

        if(currentNode.next == null)
        {
            return null;
        }
        T value = currentNode.next.value;
        currentNode.next = currentNode.next.next;

        return value;
    }

    public static class Node<T>{
        T value;
        Node<T> next;

        public Node(T value, Node<T> next)
        {
            this.value = value;
            this.next = next;
        }
    }
}

