public class LinkedStack {
    private List list;

    public LinkedStack()
    {
        list = new LinkedList();
    }

    public Object peek()
    {
        return list.getData(list.size());
    }

    public Object pop()
    {
        Object data = this.peek();
        list.deleteLast();

        return data;
    }

    public void push(Object object)
    {
        list.addFirst(object);
    }

    public int size()
    {
        return list.size();
    }
    public String toString()
    {
        String str = "";
        for(int i = 0; i < list.size(); i++)
        {
            str += String.valueOf(list.get(list.size() - (i+1)).value);

            if(i != list.size()-1) {
                str += ", ";
            }
        }
        return str; ]
    }

    public Object peekSecond()
    {
        if(list.size() < 2)
        {
            return null;
        }
        Node secondNode = list.get(list.size() - 2);
        return secondNode.value;
    }
    public Object bottom()
    {
        return list.getFirst().value;
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
