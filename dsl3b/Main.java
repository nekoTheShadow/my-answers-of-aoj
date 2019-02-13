package dsl3b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int k = stdin.nextInt();
        int[] a = new int[n];
        int amax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = stdin.nextInt();
            amax = Math.max(a[i], amax);
        }
        
        int p = 0;
        int q = 0;
        int[] b = new int[amax + 1];
        int c = 0;
        int ans = Integer.MAX_VALUE;
        while (q <= n) {
            if (c == k) {
                ans = Math.min(ans, q - p);
                if (1 <= a[p] && a[p] <= k && b[a[p]] == 1) c--;
                b[a[p]]--;
                p++;
            } else {
                if (q < n) {
                    if (1 <= a[q] && a[q] <= k && b[a[q]] == 0) c++;
                    b[a[q]]++;
                }
                q++;
            }    
        }
        
        int t = ans == Integer.MAX_VALUE ? 0 : ans;
        System.out.println(t);   
    }
}
