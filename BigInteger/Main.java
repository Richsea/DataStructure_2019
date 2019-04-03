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
    }
}
