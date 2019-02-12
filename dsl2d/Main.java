package dsl2d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void lazyUpdate(int m, int[] a, int[] b, int v) {
        if (b[v] == -1) return ;
        for (int w = 0; w < m; w++) a[v * m + w] = b[v];
        b[v] = -1;
    }
    
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int q = stdin.nextInt();
        
        int m = (int)Math.sqrt((double) n);
        int[] a = new int[n];
        int[] b = new int[n];
        Arrays.fill(a, 2147483647);
        Arrays.fill(b, -1);
        
        List<Integer> answers = new ArrayList<>();
        for (int unused = 0; unused < q; unused++) {
            int c = stdin.nextInt();
            if (c == 0) {
                int s = stdin.nextInt();
                int t = stdin.nextInt();
                int x = stdin.nextInt();
                
                if (s / m == t / m) {
                    lazyUpdate(m, a, b, s / m);
                    while (s <= t) a[s++] = x;
                } else {
                    if (s % m != 0) {
                        lazyUpdate(m, a, b, s / m);
                        while (s % m != 0) a[s++] = x;
                    }
                    if (t % m != m - 1) {
                        lazyUpdate(m, a, b, t / m);
                        while (t % m != m - 1) a[t--] = x;
                    }
                    for (int v = s / m; v <= t / m; v++) {
                        b[v] = x;
                    }
                }
            }
            
            if (c == 1) {
                int i = stdin.nextInt();
                lazyUpdate(m, a, b, i / m);
                answers.add(a[i]);
            }
        }
        
        answers.forEach(System.out::println);
    }
}
