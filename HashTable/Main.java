import java.sql.Time;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        HashTable hash = new HashTable();

        System.out.println("isEmpty?: " + hash.isEmpty());
        System.out.println("size: " + hash.size());
        hash.put(0, "zero");                                                                                // 정상적인 입력
        System.out.println("isEmpty?: " + hash.isEmpty());
        hash.put(1, "one");
        System.out.println("size: " + hash.size());
        hash.put(10, "ten");                                                                                // 같은 key값 다른 input
        hash.put(20, "twelve");
        System.out.println("[정상적인 get 처리]\nget(0): " + hash.get(0));
        System.out.println("[같은 hash값 다른 kery값]\nget(10): " + hash.get(10));
        hash.remove(10);
        System.out.println("[중간에 NIL이 존재할 경우]\nget(20): " + hash.get(20));
        hash.put(10, "ten");                                                                                // NIL이 중간에 있는경우 데이터 처리
        hash.put(9, "nine");
        hash.put(19, "nineteen");                                                                           // size 초과하여 자리 검색
        System.out.println("[size 초과하여 입력된 데이터 검색]\nget(19): " + hash.get(19));                   // size를 넘어간 데이터 검색
        hash.remove(10);                                                                                // 정상적인 remove 처리
        hash.put(20, "twelve_2");                                                                           // 같은 key값 다른 value & NIL이 중간에 있을때 데이터 처리
        hash.remove(20);                                                                                // 같은 hash값 다른 key값 & 중간에 NIL 데이터 존재
        hash.remove(19);                                                                                // size를 넘어간 데이터 처리

        System.out.println("[clear 실행]");
        hash.clear();                                                                                       // clear 실행

        System.out.println("[0,1,2,3,19,10,16,7,8,11 입력 -> rehash 확인]");
        hash.put(0, "zero");
        hash.put(1, "one");
        hash.put(2, "two");
        hash.put(3, "three");
        hash.put(19, "nineteen");
        hash.put(10, "ten");
        hash.put(16, "sixteen");
        hash.put(7, "seven");
        hash.put(8, "eight");

        hash.put(11, "eleven");

        hash.remove(7);
        hash.put(28, "twelve-Eight");
        hash.containsKey(0);
        hash.containsKey(28);
        hash.containsKey(7);

        hash.containsValue("twelve-Eight");

        Iterator iterator = hash.keySet().iterator();

        System.out.println("[keySet 확인]");
        while(iterator.hasNext())
        {
            Object key = iterator.next();
            System.out.println(key + " : " + hash.get(key));
        }

        System.out.println("[values 확인]");
        System.out.println(hash.values());


        HashTable hash2 = new HashTable();

        hash2.putAll(hash);
        System.out.println("[hash2 확인]");
        iterator = hash2.keySet().iterator();
        while(iterator.hasNext())
        {
            Object key = iterator.next();
            System.out.println(key + " : " + hash.get(key));
        }

        System.out.println("---------------------------------------------------------------------------------------------------");

        CloseAddressingHashTable closedHash = new CloseAddressingHashTable();
        hash.clear();

        for(int i = 0; i < 300; i++)
        {
            int randomNum = (int)(Math.random() * 100);

            hash.put(randomNum, randomNum);
        }

        for(int i = 0; i < 300; i++)
        {
            int randomNum = (int)(Math.random() * 100);

            closedHash.put(randomNum, randomNum);
        }

        long time;
        long timeEnd;

        for(int i = 0; i< 300; i += 20)
        {
            time = System.nanoTime();
            if(hash.get(i) != null)
            {
                timeEnd = System.nanoTime();
                System.out.println("hash[" + i + "] 탐색성공: " + (timeEnd-time));
            }
            else
            {
                timeEnd = System.nanoTime();
                System.out.println("hash[" + i + "] 탐색실패: " + (timeEnd-time));
            }
        }
        System.out.println("---------------------------------------------------");

        for(int i = 0; i< 300; i += 20)
        {
            time = System.nanoTime();
            if(closedHash.get(i) != null)
            {
                timeEnd = System.nanoTime();
                System.out.println("closedhash[" + i + "] 탐색성공: " + (timeEnd-time));
            }
            else
            {
                timeEnd = System.nanoTime();
                System.out.println("closedhash[" + i + "] 탐색실패: " + (timeEnd-time));
            }
        }

        

    }
}
