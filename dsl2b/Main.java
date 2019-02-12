package dsl2b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int q = stdin.nextInt();
        
        int m = (int)Math.sqrt((double) n);
        int[] a = new int[n];
        int[] b = new int[n / m + 1];
        
        List<Integer> answers = new ArrayList<>();
        for (int z = 0; z < q; z++) {
            int com = stdin.nextInt();
            int x = stdin.nextInt();
            int y = stdin.nextInt();

            if (com == 0) {
                x--;
                a[x] += y;
                b[x / m] += y;
            }
            
            if (com == 1) {
                x--;
                y--;
                if (x / m == y / m) {
                    int ans = IntStream.rangeClosed(x, y).map(i -> a[i]).sum();
                    answers.add(ans);
                } else {
                    int answer = 0;
                    while (x % m != 0) answer += a[x++];
                    while (y % m != m - 1) answer += a[y--];
                    for (int i = x / m; i <= y / m; i++) answer += b[i]; 
                    answers.add(answer);
                }
            }
        }
        
        answers.forEach(System.out::println);
    }
}
