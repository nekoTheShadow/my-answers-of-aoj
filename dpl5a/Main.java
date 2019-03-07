package dpl5a;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        BigInteger n = stdin.nextBigInteger();
        BigInteger k = stdin.nextBigInteger();
        
        BigInteger m = new BigInteger("10").pow(9).add(new BigInteger("7"));
        BigInteger x = k.modPow(n, m);
        System.out.println(x);
    }
}
