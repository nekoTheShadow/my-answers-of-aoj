package dpl1a;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int m = stdin.nextInt();
        int[] c = new int[m];
        for (int i = 0; i < m; i++) c[i] = stdin.nextInt();
        
       
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - n);
        dp[0] = 0;
        Arrays.sort(c);
        for (int i = 0; i < m; i++) {
            for (int j = c[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - c[i]] + 1);
            }
        }
        
        System.out.println(dp[n]);
    }
}
