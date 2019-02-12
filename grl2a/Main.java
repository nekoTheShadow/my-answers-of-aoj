package grl2a;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int v = stdin.nextInt();
        int e = stdin.nextInt();
        int[] s = new int[e];
        int[] t = new int[e];
        int[] d = new int[e];
        for (int i = 0; i < e; i++) {
            s[i] = stdin.nextInt();
            t[i] = stdin.nextInt();
            d[i] = stdin.nextInt();
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> d[i]));
        IntStream.range(0, e).forEach(pq::add);
        int[] parents = IntStream.range(0, v).toArray();
        int answer = 0;
        while (!pq.isEmpty()) {
            int i = pq.poll();
            if (find(parents, s[i]) != find(parents, t[i])) {
                answer += d[i];
                union(parents, s[i], t[i]);
            }
        }
        
        System.out.println(answer);
    }
    
    public static int find(int[] parents, int x) {
        if (parents[x] == x) return x;
        
        parents[x] = find(parents, parents[x]);
        return parents[x];
    }
    
    public static void union(int[] parents, int x1, int x2) {
        int y1 = find(parents, x1);
        int y2 = find(parents, x2);
        if (y1 != y2) {
            parents[y1] = y2;
        }
    }
}
