public class Main {

    public static void main(String[] args)
    {
        BigInt bigInt1, bigInt2;
        bigInt1 = new BigInt(13750);
        bigInt2 = new BigInt("204108273");

        bigInt1.toString();
        bigInt2.toString();

        System.out.print("bigInt1 + bigInt2 = ");
        bigInt1.plus(bigInt2).toString();

        bigInt1 = new BigInt(13750);
        bigInt2 = new BigInt("204108273");

        System.out.print("\nbigInt1 - bigInt2 = ");
        bigInt1.minus(bigInt2).toString();

        bigInt1 = new BigInt(13750);
        bigInt2 = new BigInt("1204108273");

        System.out.println("자리수: " + bigInt1.numdigits());
        System.out.println("자리수: " + bigInt2.numdigits());

        System.out.println("bigInt1과 bigInt2가 다를 때 equal 결과 확인 : " + bigInt1.equals(bigInt2));
        bigInt1 = bigInt2;
        System.out.println("bigInt1과 bigInt2가 같을 때 equal 결과 확인 : " + bigInt1.equals(bigInt2));

        bigInt1 = new BigInt(13750);
        bigInt2 = new BigInt("102041018273");
        System.out.print("bigInt1 * bigInt2 = ");
        bigInt1.times(bigInt2).toString();

        bigInt1 = new BigInt(13750);
        bigInt2 = new BigInt("102041018273");
        System.out.println("int 최대값 보다 작은 데이터일 때 intValue 결과: " + bigInt1.intValue());
        System.out.println("int 최대값 보다 큰 데이터일 때 intValue 결과: " + bigInt2.intValue());

    }
}
