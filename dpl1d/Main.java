package dpl1d;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = stdin.nextInt();
        
        LinkedList<Integer> lis = new LinkedList<>();
        lis.add(a[0]);
        for (int j = 1; j < n; j++) {
            if (lis.peekLast() < a[j]) {
                lis.add(a[j]);
            } else {
                int x = Collections.binarySearch(lis, a[j]);
                if (x < 0) x = ~x;
                lis.set(x, a[j]);
            }
        }

        System.out.println(lis.size());
    }
}
