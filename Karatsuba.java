import java.math.BigInteger;
//import java.util.Random;

public class Karatsuba {
   // private final static BigInteger ZERO = new BigInteger("0");

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);

        // N is half the length; (N % 2) is for when the number has a odd number of digits
        N = (N / 2) + (N % 2);

        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2 * N));
    }

    public static void main (String[] args) {
        // BigInteger bb = new BigInteger("38");
        // System.out.println(bb.bitLength()); == 3
        // System.out.println(bb.shiftRight(1)); == 19
        //long start, stop, elapsed;
        // Random random = new Random();
        // //int N = Integer.parseInt(args[0]);
        // int N = 6000;
        // BigInteger a = new BigInteger(N, random);
        // BigInteger b = new BigInteger(N, random);

        // start = System.currentTimeMillis();
        // BigInteger c = karatsuba(a, b);
        // stop = System.currentTimeMillis();
        // System.out.println(stop - start);

        // start = System.currentTimeMillis();
        // BigInteger d = a.multiply(b);
        // stop = System.currentTimeMillis();
        // System.out.println(stop - start);

        //System.out.println((c.equals(d)));
       BigInteger f = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
       BigInteger g = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
       BigInteger e = karatsuba(f, g);
       System.out.println(e);
    }

}