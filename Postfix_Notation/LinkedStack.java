public class LinkedStack {
    private List list;

    public LinkedStack()
    {
        list = new LinkedList();
    }

    public Object peek()
    {
        int size = list.size() - 1;
        if(size < 0)    return null;
        return list.getData(size);
    }

    public Object pop()
    {
        Object data = this.peek();
        list.deleteLast();

        return data;
    }

    public void push(Object object)
    {
        list.addLast(object);
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
            str += String.valueOf(list.getData(list.size() - (i+1)));

            if(i != list.size()-1) {
                str += ", ";
            }
        }
        return str;
    }

    public Object peekSecond()
    {
        if(list.size() < 2)
        {
            return null;
        }

        return list.getData(list.size() - 2);
    }
    public Object bottom()
    {
        return list.getData(0);
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
