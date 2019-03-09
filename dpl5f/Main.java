package dpl5f;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long n = stdin.nextLong(); // 区別できないボール
        long k = stdin.nextLong(); // 区別できる箱
        
        // 箱のほうが多い場合
        if (n < k) {
            System.out.println(0);
            System.exit(0);
        }
       
        long x = c(n - 1, k - 1);
        System.out.println(x);
    }
    
    private static long m = 1_000_000_007L;
    private static Map<Long, Map<Long, Long>> memo = new HashMap<>();
    
    private static long c(long n, long r) {
        if (!memo.computeIfAbsent(n, k -> new HashMap<>()).containsKey(r)) {
            long x = (r == 0 || n == r) ? 1 : (c(n - 1, r -1) + c(n - 1, r)) % m;
            memo.get(n).put(r, x);
        }
        return memo.get(n).get(r);
    }
}
