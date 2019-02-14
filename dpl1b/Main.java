package dpl1b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int W = stdin.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = stdin.nextInt();
            w[i] = stdin.nextInt();
        }
        
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                if (dp[i][j] == 0) continue;
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
                if (j + w[i] <= W) dp[i + 1][j + w[i]] = Math.max(dp[i + 1][j + w[i]], dp[i][j] + v[i]);
            }
            dp[i + 1][w[i]] = Math.max(dp[i + 1][w[i]], v[i]);
        }
        
        int max = Integer.MIN_VALUE;
        for (int j = 0; j <= W; j++) max = Math.max(max, dp[N][j]); 
        System.out.println(max);
    }
}
