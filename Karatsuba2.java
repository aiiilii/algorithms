// 2nd practive with karatsuba
import java.math.BigInteger;

public class Karatsuba2 {

   // private final static BigInteger ZERO = new BigInteger("0");

    public static BigInteger karatsuba2(BigInteger x, BigInteger y) {
    int N = Math.max(x.bitLength(), y.bitLength());
    if (N <= 2000) return x.multiply(y);

    N = (N / 2) + (N % 2);

    BigInteger a = x.shiftRight(N);
    BigInteger b = x.subtract(a.shiftLeft(N));
    BigInteger c = y.shiftRight(N);
    BigInteger d = y.subtract(c.shiftLeft(N));

    BigInteger ac = karatsuba2(a, c);
    BigInteger bd = karatsuba2(b, d);
    BigInteger abcd = karatsuba2(a.add(b), c.add(d));

    return bd.add(ac.shiftLeft(2 * N)).add(abcd.subtract(ac).subtract(bd).shiftLeft(N));
    }
    public static void main(String[] args) {
        BigInteger f = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
        BigInteger g = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
        BigInteger e = karatsuba2(f, g);
        System.out.println(e);
    
    }
}