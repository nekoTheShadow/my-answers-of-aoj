package dsl3a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int s = stdin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = stdin.nextInt();
        
        int p = 0;
        int q = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        
        while (q <= n) {
            if (sum < s) {
                if (q < n) sum += a[q];
                q++;
            } else {
                ans = Math.min(ans, q - p);
                sum -= a[p];
                p++;
            }            
        }
        
        if (ans == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
        
    }
}
