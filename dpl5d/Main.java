package dpl5d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        long n = stdin.nextLong(); 
        long k = stdin.nextLong(); 
        
        // 重複組み合わせ cf. https://mathtrain.jp/tyohukuc
        long x = c(n + k - 1, n);
        System.out.println(x);
    }
    
    private static long m = 1_000_000_007L;
    private static Map<Long, Map<Long, Long>> memo = new HashMap<>();
    
    private static long c(long n, long r) {
        if (!memo.getOrDefault(n, Collections.emptyMap()).containsKey(r)) {
            long x = (r == 0 || n == r) ? 1 : (c(n - 1, r -1) + c(n - 1, r)) % m;
            memo.computeIfAbsent(n, k -> new HashMap<>()).put(r, x);
        }
        return memo.get(n).get(r);
    }
}
