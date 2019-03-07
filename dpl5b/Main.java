package dpl5b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long n = stdin.nextLong();
        long k = stdin.nextLong();
        
        // 箱よりボールの数が多い場合
        if (k < n) {
            System.out.println(0);
            System.exit(0);
        }
        
        long x = 1;
        long m = 1000000000 + 7;
        for (long i = k; i > k - n; i--) {
            x = (x * i) % m;
        }
        System.out.println(x);
    }
}
