package grl1c;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int v = stdin.nextInt();
        int e = stdin.nextInt();
        
        int[][] dp = new int[v][v];
        for (int i = 0; i < v; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        for (int i = 0; i < e; i++) {
            int s = stdin.nextInt();
            int t = stdin.nextInt();
            int d = stdin.nextInt();
            dp[s][t] = d;
        }
        
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue;
                    if (dp[i][j] == Integer.MAX_VALUE || dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        
        for (int i = 0; i < v; i++) {
            if (dp[i][i] < 0) {
                System.out.println("NEGATIVE CYCLE");
                System.exit(0);
            }
        }
        
        for (int[] row : dp) {
          String answer = Arrays.stream(row)
                                .mapToObj(distance -> distance == Integer.MAX_VALUE ? "INF" : String.valueOf(distance))
                                .collect(Collectors.joining(" "));
          System.out.println(answer);
        }
   }
}
