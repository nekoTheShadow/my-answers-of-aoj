package dsl3c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int q = stdin.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = stdin.nextLong();

        long[] answers = new long[q];
        for (int t = 0; t < q; t++) {
            long x = stdin.nextLong();
            int l = 0;
            int r = 0;
            long y = 0;
            while (r <= n) {
                if (y <= x) {
                    answers[t] += r - l;
                    if (r < n) y += a[r];
                    r++;
                } else {
                    y -= a[l];
                    l++;
                }
            }
        }

        for (long answer : answers) System.out.println(answer);
    }
}
