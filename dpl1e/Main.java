package dpl1e;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String s1 = stdin.nextLine();
        String s2 = stdin.nextLine();
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int j = 0; j <= len2; j++) dp[0][j] = j;
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int c = s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = IntStream.of(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + c).min().getAsInt();
            }
        }
        System.out.println(dp[len1][len2]);
    }
}
