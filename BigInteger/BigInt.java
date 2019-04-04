public class BigInt {
    // 음수가 들어올 경우는 나중에 처리
    List list = new LinkedList();

    public String toString()
    {
        int i = 0;
        while(true)
        {
            if(i >= list.size()) break;
            i++;
            System.out.print(this.list.get(list.size() - i));
        }
        System.out.println();
        return null;
    }
    public BigInt(int n)
    {
        String temp = Integer.toString(n);
        for(int i = 0; i < temp.length(); i++)
        {
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
        List bigInt, smallInt;
        int loc = 0;
        int data;
        boolean uppercase  = false;

        if(this.compareTo(y) == 1)
        {
            smallInt = this.list;
            bigInt = y.list;
        }
        else
        {
            smallInt = y.list;
            bigInt = this.list;
        }

        // 작은 수의 최대 자리수까지 계산
        while(smallInt.size() > loc)
        {
            data = bigInt.get(loc) + smallInt.get(loc);

            if(uppercase)   data ++;

            if(data > 9){
                data -= 10;
                uppercase = true;
            }
            else
            {
                uppercase = false;
            }

            newList.addLast(data);
            loc++;
        }

        while(bigInt.size() > loc)
        {
            data = bigInt.get(loc);

            if(uppercase)
            {
                data += 1;

                if(data > 9) data -= 10;
                else    uppercase = false;
            }

            newList.addLast(data);
            loc++;
        }

        list = newList;
        return this;
        //addFirst를 이용해서 끝에서부터 차례로 계산
    }


    public BigInt minus(BigInt y)
    {
        List newList = new LinkedList();
        List smallInt, bigInt;
        boolean checkChange = false;
        boolean lowerCase = false;
        int loc = 0;
        int data;

        if(this.compareTo(y) == 1)
        {
            smallInt = this.list;
            bigInt = y.list;
        }
        else
        {
            smallInt = y.list;
            bigInt = this.list;
        }


        // 둘 다 존재하는 경우
        while(smallInt.size() > loc)
        {
            data = bigInt.get(loc) + 10 - smallInt.get(loc);

            if(lowerCase)   data--;

            if(data > 9)
            {
                data -= 10;
                lowerCase = false;
            }else
            {
                lowerCase = true;
            }
            newList.addLast(data);
            loc++;
        }

        // this만 남아있을 경우
        while(bigInt.size() > loc)
        {
            data = bigInt.get(loc);

            if(lowerCase)
            {
                if(data != 0)
                {
                    lowerCase = false;
                    data--;
                }
                else    data = 9;
            }
            newList.addLast(data);
            loc++;
        }

        if(newList.get(newList.size() -1) == 0)
        {
            newList.deleteLast();
        }

        // B-A인지 A-B인지 확인
        if(checkChange)
        {
            int temp = newList.get(newList.size() - 1);
            newList.deleteLast();
            newList.addLast(-temp);
        }

        list = newList;

        return this;
    }

    // 두개의 int가 완전히 동일할 경우 true
    Boolean equals(BigInt y)
    {
        int loc = 0;

        if(this.list.size() != y.list.size())
        {
            return false;
        }

        while(this.list.size() > loc)
        {
            if(this.list.get(loc) != y.list.get(loc))
                return false;
            loc++;
        }

        return true;
    }

    // 값이 int 타입에서 받을 수 있는 최대값으로 제한
    int intValue()
    {
        String max = Integer.toString(Integer.MAX_VALUE);
        List newList = new LinkedList();
        double data = 0;

        if(this.list.size() <= max.length())
        {
            for(int i = 0; i < this.list.size(); i++)
            {
                data *= 10;
                data += this.list.get(this.list.size()-(i+1));
            }

            if(data < Integer.MAX_VALUE)
            {
                return (int)data;
            }
        }

        BigInt temp = new BigInt(Integer.MAX_VALUE);
        this.list = temp.list;

        return Integer.MAX_VALUE;
    }

    //자리수를 반환
    int numdigits()
    {
        return this.list.size();
    }

    // 두 bigInt를 곱하는 함수
    BigInt times(BigInt y)
    {
        List newList;
        BigInt newInt = new BigInt(0);
        BigInt resultInt = new BigInt(0);
        int upperNum = 0;

        for(int i = 0; i < y.list.size(); i++)
        {
            newList = new LinkedList();
            for (int j = 0; j < this.list.size(); j++)
            {
                int data = this.list.get(j) * y.list.get(i) + upperNum;

                if (data > 9)
                {
                    upperNum = (data / 10);
                    data %= 10;
                }
                else
                    upperNum = 0;

                newList.addLast(data);
            }

            if (i == 0) {
                resultInt.list = newList;
            }
            else
            {
                for (int k = 0; k < i; k++)
                {
                    newList.addFirst(0);
                }
                newInt.list = newList;
                resultInt.plus(newInt);
            }
        }
        this.list = resultInt.list;

        return resultInt;
    }

    private int compareTo(BigInt y)
    {
        if(this.list.size() < y.list.size())    // y의 크기가 더 큰경우
        {
            return 1;
        }
        else{
            for(int i=0; i < list.size(); i++)
            {
                if(this.list.get(list.size()-(i+1)) < y.list.get(list.size()-(i+1)))
                {
                    return 1;
                }
            }
        }
        return 0;
    }
}
