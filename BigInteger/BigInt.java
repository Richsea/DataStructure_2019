public class BigInt {
    // ������ ���� ���� ���߿� ó��
    List list = new LinkedList();

    public String toString()
    {
        int i = 0;
        while(true)
        {
            if(i > list.size()) break;


        }
        return null;
    }
    public BigInt(int n)
    {
        String temp = Integer.toString(n);
        for(int i = 0; i < temp.length(); i++)
        {
            int newTemp = temp.length();
            newTemp = temp.charAt(temp.length() - (i + 1)) - '0';
            list.addLast(temp.charAt(temp.length() - (i + 1)) - '0');
        }
    }
    public BigInt(String n)
    {
        for(int i = 0; i < n.length(); i++)
        {
            list.addLast(n.charAt(n.length() - (i+1)) - '0');
        }

    }

    public BigInt plus(BigInt y)
    {
        List newList = new LinkedList();
        int loc = 0;
        int data;
        boolean uppercase  = false;

        // bigint�� ���� ���ڰ� �������� ������� Ȯ��
        /*
        if(this.list.get(list.size()-1) < 0 || y.list.get(y.list.size()-1) < 0)
        {
            if(this.list.get(list.size()-1) < 0 && y.list.get(y.list.size()-1) < 0)
            {

            }
        }
        */

        // this.bigInt�� y.bigInt�� �� �� �ڸ����� ���� �� ��
        while(this.list.size() > loc && y.list.size() > loc)
        {
        	data = this.list.get(loc) + y.list.get(loc);

            if(uppercase)   // �ڸ��� �ø� �ִ��� Ȯ��(�������)
            {
                data ++;
                uppercase = false;
            }

            if(data > 9)    // ���� ����� 10 �̻��ϰ��
            {
                data -= 10;
                uppercase = true;
            }

            newList.addLast(data);
            loc++;
        }


        while(this.list.size() > loc)
        {
        	data = this.list.get(loc);
        	
            if(uppercase)
            {
            	data += 1;
            	
            	if(data > 9) data -= 10;
            	else	uppercase = false;
            }
            newList.addLast(data);
            loc++;
        }

        while(y.list.size() > loc)
        {
        	data = y.list.get(loc);
        	
            if(uppercase)
            {
            	data += 1;
            	
            	if(data > 9) data -= 10;
            	else	uppercase = false;
            }
            newList.addLast(data);
            loc++;
        }

        list = newList;
        return this;
        //addFirst�� �̿��ؼ� ���������� ���ʷ� ���
    }


    //public BigInt minus(BigInt y);
    /*
    Boolean equals(BigInt y)
    {
        while
    }
    int intValue();
    int numdigits();
    BigInt times(int n);
    */
}
