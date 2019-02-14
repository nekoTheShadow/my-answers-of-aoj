package dpl2a;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        int v = stdin.nextInt();
        int e = stdin.nextInt();
        int[][] cost = new int[v][v];
        for (int[] row : cost) Arrays.fill(row, -1);
        int inf = 1;
        for (int i = 0; i < e; i++) {
            int s = stdin.nextInt();
            int t = stdin.nextInt();
            int d = stdin.nextInt();
            cost[s][t] = d;
            inf += d;
        }
        
        int[][] dp = new int[1 << v][v];
        for (int[] row : dp) Arrays.fill(row, inf);
        dp[0][0] = 0;
        
        for (int x = 0; x < 1 << v; x++) {
            for (int y = 0; y < v; y++) {
                for (int z = 0; z < v; z++) {
                    if (cost[y][z] == -1) continue;
                    if ((x & (1 << z)) != 0) continue;
                    dp[x | (1 << z)][z] = Math.min(dp[x | (1 << z)][z], dp[x][y] + cost[y][z]);
                }
            }
        }

        int ans = dp[(1 << v) - 1][0];
        if (ans == inf) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
