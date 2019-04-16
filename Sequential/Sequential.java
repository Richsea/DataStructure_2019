import java.util.AbstractSequentialList;
import java.util.ListIterator;

public class Sequential extends AbstractSequentialList
{
    Node start = new Node(null, null);

    @Override
    public boolean add(Object e)
    {
        Node newNode;
        Node currentNode = start;

        while(currentNode.next != null)
        {
            currentNode = currentNode.next;
        }
        newNode = new Node(currentNode, e);
        currentNode.next = newNode;

        return true;
    }

    @Override
    public ListIterator listIterator(int index) {
        return new ListIterator() {
            Node current = start;

            @Override
            public boolean hasNext() {
                if(current.next != null)
                {
                    return true;
                }

                return false;
            }

            @Override
            public Object next() {
                if(this.hasNext())
                {
                    current = current.next;
                    return current.data;
                }
                return null;
            }

            @Override
            public boolean hasPrevious() {
                if(current.prev != null)
                {
                    return true;
                }
                return false;
            }

            @Override
            public Object previous() {
                if(this.hasPrevious())
                {
                    current = current.prev;
                    return current.data;
                }
                return null;
            }

            @Override
            public int nextIndex() {
                Node tempNode = start;
                int num = 0;

                while(tempNode != current.next)
                {
                    tempNode = tempNode.next;
                    num++;
                }

                return num;
            }

            @Override
            public int previousIndex() {
                Node tempNode = start;
                int num = 0;

                while(tempNode != current.prev)
                {
                    tempNode = tempNode.next;
                    num++;
                }

                return num;
            }

            @Override
            public void remove() {
                if(current == start)
                {
                    return;
                }

                Node prevNode = current.prev;
                Node nextNode = current.next;

                if(current.next != null)
                {
                    nextNode.prev = prevNode;
                }
                prevNode.next = nextNode;
                current = prevNode;
            }

            @Override
            public void set(Object o)
            {
                if(current == start)
                {
                    return;
                }

                Node prevNode = current.prev;
                Node nextNode = current.next;

                if(current.next != null)
                {
                    Node newNode = new Node(prevNode, nextNode, o);
                    prevNode.next = newNode;
                    nextNode.prev = newNode;
                }
                else
                {
                    Node newNode = new Node(prevNode, nextNode, o);
                    prevNode.next = newNode;
                }
                current = prevNode.next;
                //현재위치의 데이터 변경
            }

            @Override
            public void add(Object o) {
                Node newNode = new Node(current.prev, current.next, o);

                current.next = newNode;
                newNode.prev = current;
                // 현재 위치에 삽입
            }
        };
    }

    @Override
    public int size() {
        Node current = start;
        int size = 0;

        while(current.next != null)
        {
            current = current.next;
            size++;
        }

        return size;
    }

    class Node
    {
        Node next;
        Node prev;
        Object data;


        Node(Node prev, Node next, Object data)
        {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

        Node(Node prev, Object data)
        {
            this.next = null;
            this.prev = prev;
            this.data = data;
        }
    }
}