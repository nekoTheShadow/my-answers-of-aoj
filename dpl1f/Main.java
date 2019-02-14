package dpl1f;

import java.util.Arrays;
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
        
        int sum = Arrays.stream(v).sum();
        int[][] dp = new int[N + 1][sum + 1];
        for (int i = 0; i <= N; i++) Arrays.fill(dp[i], W + 1);
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                if (j + v[i] <= sum) dp[i + 1][j + v[i]] = Math.min(dp[i + 1][j + v[i]], dp[i][j] + w[i]);
            }
            dp[i + 1][v[i]] = dp[i + 1][v[i]] == 0 ? w[i] : Math.min(dp[i + 1][v[i]], w[i]);
        }
        
        int answer = 0;
        for (int i = sum; i >= 0; i--) {
            if (dp[N][i] <= W) answer = Math.max(answer, i);
        }
        
        System.out.println(answer);
    }
}
