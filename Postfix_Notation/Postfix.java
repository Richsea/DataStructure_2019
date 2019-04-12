import java.io.IOException;

public class Postfix {

    private LinkedStack stack;
    private String notation = "";

    Postfix(String str)
    {
        stack = new LinkedStack();

        controller(str);
    }

    private void controller(String str)
    {
        notation = changePostfix(str);

        try
        {
            if(notation.equals(null))
            {
                throw new IOException();
            }
        }
        catch(Exception e)
        {
            System.out.println("잘못된 입력입니다.");
            System.exit(0);
        }

        System.out.println("........Change to postfix notation");
        System.out.println(notation);

        this.calculateValue();
    }

    private String changePostfix(String str){
        int current = 0;
        String data = "";
        boolean isSpace = false;    // 띄어쓰기 여부 체크. 연속된 숫자 입력 오류 체크를 위함
        boolean wasNumber = false;  // 숫자 여부 체크
        int stackSize = 0;          // stackSize 체크
        int paren_count = 0;        //'(' 짝 확인

        while(current < str.length())
        {
            char currentChar = str.charAt(current);

            if(currentChar == '*' || currentChar == '/' || currentChar == '+')
            {
                if(!wasNumber)          //operator가 연속으로 나오는 오류 제거
                {
                    return null;
                }

                if(stackSize > paren_count)
                {
                    data += " " + stack.pop();
                    stackSize--;
                }

                stack.push(currentChar);
                stackSize++;
                wasNumber = false;
            }
            else if(currentChar == '-')
            {
                if(data.charAt(data.length() - 1) == '-')       // '-'가 부호나 operator 이외에 추가로 사용되는 오류 제거
                {
                    return null;
                }

                if(!wasNumber)
                {
                    data += " -";
                    wasNumber = true;
                }
                else
                {
                    if(stackSize > paren_count)
                    {
                        data += " " + stack.pop();
                        stackSize--;
                    }

                    stack.push(currentChar);
                    wasNumber = false;
                    stackSize++;
                }
            }
            else if(currentChar > 47 && currentChar < 58)
            {
                if(isSpace && wasNumber)
                {
                    return null;
                }

                if(!wasNumber)
                {
                    data += " ";
                }

                data += currentChar;
                wasNumber = true;
            }
            else if(currentChar == '(')
            {
                if(wasNumber)               // 숫자 바로 다음에 '(' 입력이 오는 오류 제거
                    return null;

                paren_count++;
            }
            else if(currentChar == ')')
            {
                paren_count--;
            }
            else if(currentChar == ' ')
            {
                isSpace = true;
                current++;
                continue;
            }

            if(stackSize == paren_count + 2)
            {
                data += " " + stack.pop();
                stackSize--;
            }

            isSpace = false;
            current++;
        }

        if(paren_count != 0)    // '(' 와 ')' 짝이 안맞는 오류 제거
        {
            return null;
        }

        data += " " + stack.pop();

        return data;
    }

    private void calculateValue()
    {
        int current = 1;
        String value = "";
        boolean isNum = false;

        System.out.println("\n\nCalculate Value: ");

        while(current < notation.length())
        {
            char notationValue = notation.charAt(current);
            if(notationValue < 58 && notationValue > 47)
            {
                value += notationValue;
                isNum = true;
            }
            else if(notationValue == '-' || notationValue == '+' || notationValue == '*' || notationValue == '/')
            {
                if(notationValue == '-' && (stack.size() == 1 || stack.size() == 0))   // '-'가 operator가 아니라 number의 기호로 사용되었을 경우 체크
                {
                    value += notationValue;
                    current++;
                    continue;
                }
                int num1 = Integer.parseInt(stack.pop().toString());
                int num2 = Integer.parseInt(stack.pop().toString());
                int result = 0;

                switch(notationValue)
                {
                    case '+':
                        result = num2+num1;
                        break;

                    case '-':
                        result = num2-num1;
                        break;

                    case '*':
                        result = num2 * num1;
                        break;

                    default:
                        result = num2 / num1;
                }

                System.out.println(notationValue + "...Pop");

                if(current != notation.length() - 1)
                {
                    System.out.println(num2 + " " + notationValue + " " + num1 + " = " + result + "...push");
                    stack.push(result);
                }
                else
                {
                    System.out.println(num2 + " " + notationValue + " " + num1 + " = " + result);
                }

            }
            else    //숫자데이터
            {
                if(isNum)
                {
                    stack.push(value);
                    System.out.println(value + "...push");
                    value = "";
                    isNum = false;
                }
            }
            current++;
        }
        System.out.println("\n\nEnd RPN Calculator");
        System.out.println("--------");
    }
}
