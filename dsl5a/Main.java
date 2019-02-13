package dsl5a;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int t = stdin.nextInt();
        int[] imos = new int[t + 2];
        for (int unused = 0; unused < n; unused++) {
            int l = stdin.nextInt();
            int r = stdin.nextInt();
            imos[l] += 1;
            imos[r] -= 1;
        }
        
        for (int i = 0; i <= t; i++) imos[i + 1] += imos[i];
        int max = Arrays.stream(imos).max().getAsInt();
        System.out.println(max);
    }
}
