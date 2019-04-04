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

        System.out.println(bigInt1.equals(bigInt2));
        bigInt1 = bigInt2;
        System.out.println(bigInt1.equals(bigInt2));

        bigInt1 = new BigInt(13750);
        System.out.print("bigInt1 * bigInt2 = ");
        bigInt1.times(bigInt2).toString();

        System.out.println(bigInt1.intValue());
        System.out.println(bigInt2.intValue());

        System.out.println(Integer.MAX_VALUE);

    }
}
