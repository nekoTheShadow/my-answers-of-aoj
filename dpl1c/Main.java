package dpl1c;

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
        
        int[] dp = new int[W + 1];
        for (int i = 0; i < N; i++) {
            for (int j = w[i]; j <= W; j++) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= W; i++) max = Math.max(max, dp[i]); 
        System.out.println(max);  
    }
}
