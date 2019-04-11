import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Postfix postfix;

        System.out.println("-------------");
        System.out.println("RPN Calculator");
        System.out.println("input:");

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        postfix = new Postfix(str);

    }
}
