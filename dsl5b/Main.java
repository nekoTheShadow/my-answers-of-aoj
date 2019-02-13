package dsl5b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        
        int[] a = new int[n]; 
        int[] b = new int[n]; 
        int[] c = new int[n]; 
        int[] d = new int[n];
        int xmax = Integer.MIN_VALUE;
        int ymax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = stdin.nextInt(); // x1
            b[i] = stdin.nextInt(); // y1
            c[i] = stdin.nextInt(); // x1
            d[i] = stdin.nextInt(); // y2
            
            xmax = Math.max(xmax, Math.max(a[i], c[i]));
            ymax = Math.max(ymax, Math.max(b[i], d[i]));
        }
        
        int[][] imos = new int[xmax + 2][ymax + 2];
        for (int i = 0; i < n; i++) {
            imos[a[i]][b[i]] += 1;
            imos[c[i]][d[i]] += 1;
            imos[a[i]][d[i]] -= 1;
            imos[c[i]][b[i]] -= 1;
        }
        
        for (int x = 0; x <= xmax; x++) {
            for (int y = 0; y <= ymax; y++) imos[x + 1][y] += imos[x][y];
        }
        
        for (int x = 0; x <= xmax; x++) {
            for (int y = 0; y <= ymax; y++) imos[x][y + 1] += imos[x][y];
        }
        
        int max = Integer.MIN_VALUE;
        for (int x = 0; x <= xmax; x++) {
            for (int y = 0; y <= ymax; y++) max = Math.max(max, imos[x][y]);
        }
        
        System.out.println(max);
    }
}
