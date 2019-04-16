import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Sequential seq = new Sequential();

        System.out.println("sequential에 1 입력: " + seq.add(1));
        System.out.println("sequential에 2 입력: " + seq.add(2));
        System.out.println("sequential에 3 입력: " + seq.add(3));
        System.out.println("size: " + seq.size());

        System.out.println("<<ListIterator 시작>>");
        ListIterator list = seq.listIterator();

        System.out.println("next: " + list.next());
        System.out.println("next: " + list.next());
        System.out.println("next: " + list.next());
        System.out.println("list의 마지막 데이터의 next: " + list.next());

        System.out.println("prev: " + list.previous());
        System.out.println("prev: " + list.previous());
        System.out.println("list의 처음 데이터의 prev: " + list.previous());

        System.out.println("next: " + list.next());
        System.out.println("next 데이터의 index: " + list.nextIndex());
        System.out.println("prev 데이터의 index: " + list.previousIndex());

        System.out.println("현재 데이터 10으로 변경");
        list.set(10);

        System.out.println("현재 위치에 데이터 20인 Node 추가");
        list.add(20);

        System.out.println("\n데이터 처음부터 출력");
        ListIterator list2 = seq.listIterator();

        while(list2.hasNext())
        {
            System.out.println(list2.next());
        }

        System.out.println("첫 데이터 삭제 확인: ");
        list.remove();

        list2 = seq.listIterator();

        while(list2.hasNext())
        {
            System.out.println(list2.next());
        }

        System.out.println("중간 데이터 삭제 확인: ");
        list.next();
        list.remove();

        list2 = seq.listIterator();

        while(list2.hasNext())
        {
            System.out.println(list2.next());
        }

        System.out.println("마지막 데이터 삭제 확인: " );
        list.remove();

        list2 = seq.listIterator();

        while(list2.hasNext())
        {
            System.out.println(list2.next());
        }
    }
}
