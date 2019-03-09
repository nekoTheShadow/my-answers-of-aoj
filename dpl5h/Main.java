package dpl5h;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long n = stdin.nextLong(); // 区別できないボール
        long k = stdin.nextLong(); // 区別できる箱
        
        // 箱のほうが多い場合
        if (n <= k) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
