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
        boolean wasNumber = false;  // 숫자 여부 체크
        boolean isSpace = false;    // 띄어쓰기 여부 체크
        int paren_count = 0;    //'(' 짝 확인

        while(current < str.length())
        {
            char currentChar = str.charAt(current);

            if(currentChar == '*' || currentChar == '/' || currentChar == '+')
            {
                if(!wasNumber)     // operator가 연속으로 나오는 에러 처리
                {
                    return null;
                }
                stack.push(currentChar);
                wasNumber = false;
            }
            else if(currentChar == '-')
            {
                if (data.charAt(data.length() - 1) == '-') {    // '-' 중복 사용하는 에러 처리
                    return null;
                }

                if (!wasNumber)                 // 음수로 받는 경우 처리
                {
                    data += " -";
                    wasNumber = true;
                }
                else
                {
                    stack.push(currentChar);
                    wasNumber = false;
                }
            }
            else if(currentChar > 47 && currentChar < 58)
            {
                if(isSpace && wasNumber)    // 숫자와 숫자 사이에 operator 없는 에러 처리
                {
                    return null;
                }

                if(!wasNumber)              // 숫자가 시작될 때 " " 실행
                {
                   data += " ";
                }
                data += currentChar;
                wasNumber = true;
            }
            else if(currentChar == '(')
            {
                if(wasNumber)               // 숫자 다음에 바로 '(' 입력받는 에러 처리
                {
                    return null;
                }
                paren_count++;
            }
            else if(currentChar == ')')
            {
                data += " " + stack.pop();
                paren_count--;
            }
            else if(currentChar == ' ')
            {
                isSpace = true;
                current++;
                continue;
            }

            isSpace = false;
            current++;
        }

        if(stack.size() > 2 || !wasNumber || paren_count != 0 || (data.charAt(data.length()-1) < 58 && data.charAt(data.length() - 1) > 47))    // 정확하지 않은 나머지 syntax 처리
        {
            return null;
        }

        while(stack.size() != 0)
        {
            data += " " + stack.pop();
        }

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

                    case '/':
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
