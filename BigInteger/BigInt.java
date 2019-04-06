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
        if(temp.charAt(0) != '-')
        {
            for(int i = 0; i < temp.length(); i++)
            {
                list.addLast(temp.charAt(temp.length() - (i+1)) - '0');
            }
        }
        else
        {
            for(int i = 0; i < temp.length() - 2; i++)
            {
                list.addLast(temp.charAt(temp.length() - (i+1)) - '0');
            }
            list.addLast((temp.charAt(1) - '0') * (-1));
        }

    }
    public BigInt(String n)
    {
        if(n.charAt(0) != '-')
        {
            for(int i = 0; i < n.length(); i++)
            {
                list.addLast(n.charAt(n.length() - (i+1)) - '0');
            }
        }
        else
        {
            for(int i = 0; i < n.length() - 2; i++)
            {
                list.addLast(n.charAt(n.length() - (i+1)) - '0');
            }
            list.addLast((n.charAt(1)  - '0') * (-1));
        }

    }

    public BigInt plus(BigInt y)
    {
        List newList = new LinkedList();
        BigInt bigInt, smallInt;
        int loc = 0;
        int data;
        boolean uppercase  = false;
        boolean negativeCheck = false;

        if(this.compareTo(y) == 1)
        {
            smallInt = this;
            bigInt = y;
        }
        else
        {
            smallInt = y;
            bigInt = this;
        }

        // 음수 양수 따지기
        if(bigInt.isNegative())
        {
            bigInt.list.changeLast(bigInt.list.get(bigInt.list.size() - 1) * (-1));

            if(smallInt.isNegative())
            {
                smallInt.list.changeLast(smallInt.list.get(smallInt.list.size() - 1) * (-1));
                negativeCheck = true;
            }
            else
            {
                bigInt.minus(smallInt);
                bigInt.list.changeLast(bigInt.list.get(bigInt.list.size()-1) * (-1));

                list = bigInt.list;
                return bigInt;
            }
        }
        else
        {
            if(smallInt.isNegative())
            {
                //y값 변경한 후 뺄셈연산 실행
                smallInt.list.changeLast(smallInt.list.get(smallInt.list.size() - 1) * (-1));
                bigInt.minus(smallInt);

                list = bigInt.list;
                return bigInt;
            }
        }

        // 작은 수의 최대 자리수까지 계산
        while(smallInt.list.size() > loc)
        {
            data = bigInt.list.get(loc) + smallInt.list.get(loc);

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

        while(bigInt.list.size() > loc)
        {
            data = bigInt.list.get(loc);

            if(uppercase)
            {
                data += 1;

                if(data > 9) data -= 10;
                else    uppercase = false;
            }

            newList.addLast(data);
            loc++;
        }

        if(uppercase)
        {
            newList.addLast(1);
        }

        if(negativeCheck)
        {
            newList.changeLast(newList.get(newList.size() - 1) * (-1));
        }

        list = newList;
        return this;
    }


    public BigInt minus(BigInt y)
    {
        List newList = new LinkedList();
        BigInt smallInt, bigInt;
        boolean checkChange = false;
        boolean lowerCase = false;
        boolean negativeCheck = false;
        int loc = 0;
        int data;

        if(this.compareTo(y) == 1)
        {
            smallInt = this;
            bigInt = y;
            checkChange = true;
        }
        else
        {
            smallInt = y;
            bigInt = this;
        }

        // 음수 양수 따지기
        if(bigInt.isNegative())
        {
            bigInt.list.changeLast(bigInt.list.get(bigInt.list.size() - 1) * (-1));

            if(smallInt.isNegative())
            {
                smallInt.list.changeLast(smallInt.list.get(smallInt.list.size() - 1) * (-1));
                negativeCheck = true;
            }
            else
            {
                bigInt.plus(smallInt);

                list = bigInt.list;
                return bigInt;
            }
        }
        else
        {
            if(smallInt.isNegative())
            {
                //y값 변경한 후 뺄셈연산 실행
                smallInt.list.changeLast(smallInt.list.get(smallInt.list.size() - 1) * (-1));
                bigInt.plus(smallInt);
                bigInt.list.changeLast(bigInt.list.get(bigInt.list.size()-1) * (-1));

                list = bigInt.list;
                return bigInt;
            }
        }

        // 둘 다 존재하는 경우
        while(smallInt.list.size() > loc)
        {
            data = bigInt.list.get(loc) + 10 - smallInt.list.get(loc);

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
        while(bigInt.list.size() > loc)
        {
            data = bigInt.list.get(loc);

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

        if(negativeCheck)
        {
            newList.changeLast(newList.get(newList.size() - 1) * (-1));
        }

        // B-A인지 A-B인지 확인
        if(checkChange)
        {
            int temp = newList.get(newList.size() - 1) * (-1);
            newList.changeLast(temp);
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
        boolean negativeChange = false;
        int upperNum = 0;

        // 음수 확인
        if(this.isNegative())
        {
            this.list.changeLast(this.list.get(this.list.size() - 1) * (-1));
            negativeChange = true;
        }

        if(y.isNegative())
        {
            y.list.changeLast(y.list.get(y.list.size() - 1) * (-1));

            if(negativeChange)
            {
                negativeChange = false;
            }
            else
            {
                negativeChange = true;
            }
        }

        // * 연산 실행
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

            if(upperNum != 0)
            {
                newList.addLast(upperNum);
                upperNum = 0;
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

        if(negativeChange)
        {
            this.list.changeLast(this.list.get(this.list.size() - 1) * (-1));
        }

        return resultInt;
    }

    private int compareTo(BigInt y)
    {
        if(this.list.size() < y.list.size())    // y의 크기가 더 큰경우
        {
            return 1;
        }
        else
        {
            if(this.list.size() == y.list.size())
            {
                for (int i = 0; i < list.size(); i++) {
                    int thisData = this.list.get(list.size() - (i + 1));
                    int yData = y.list.get(y.list.size() - (i+1));

                    if(thisData == yData)   continue;
                    else if(thisData < yData)
                        return 1;
                    else
                        return 0;
                }
            }
        }
        return 0;
    }

    private boolean isNegative()
    {
        int loc = 0;

        if(this.list.get(this.list.size() - 1) < 0)
        {
            return true;
        }
        return false;
    }
}
