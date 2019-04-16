import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Sequential seq = new Sequential();

        seq.add(1);
        seq.add(2);
        seq.add(3);
        System.out.println("size: " + seq.size());

        ListIterator list = seq.listIterator();

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("Iterator 작업 입력\n 1: next, 2: previous, 3: nextIndex, 4: previousIndex, 5: remove, 6: set, 7: add, 0: end");
            int num = scanner.nextInt();

            switch(num)
            {
                case 1:
                    System.out.println(list.next());
                    break;
                case 2:
                    System.out.println(list.previous());
                    break;
                case 3:
                    System.out.println(list.nextIndex());
                    break;
                case 4:
                    System.out.println(list.previousIndex());
                    break;
                case 5:
                    list.remove();
                    break;
                case 6:
                    list.set("set");
                    break;
                case 7:
                    list.add("add");
                    break;
            }
            if(num == 0)
            {
                break;
            }
        }

        while(list.hasNext())
        {
            System.out.println(list.next());
        }

        while(list.hasPrevious())
        {
            System.out.println(list.previous());
        }


        Sequential seq1 = new Sequential();

        seq1.add(1);
        seq1.add(2);
        seq1.add(3);
        ListIterator list2 = seq1.listIterator();

        list2.next();
        list2.next();
        list2.next();


        System.out.println("set설정: ");
        list2.set("set");
        System.out.println("hasPrevious" + list2.hasPrevious());
        System.out.println("previous Data: " + list2.previous());
        System.out.println("set설정: ");
        list2.set("set");
        System.out.println("hasPrevious" + list2.hasPrevious());
        System.out.println("previous Data: " + list2.previous());
        System.out.println("set설정: ");
        list2.set("set");
        System.out.println("hasPrevious" + list2.hasPrevious());
        System.out.println("previous Data: " + list2.previous());
    }
}
