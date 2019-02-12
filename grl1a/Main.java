package grl1a;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int v = stdin.nextInt();
        int e = stdin.nextInt();
        int r = stdin.nextInt();
        
        Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
        for (int i = 0; i < e; i++) {
          int s = stdin.nextInt();
          int t = stdin.nextInt();
          int d = stdin.nextInt();
          costs.computeIfAbsent(s, k -> new HashMap<>()).put(t, d);
        }
        
        int[] distanecs = new int[v];
        Arrays.fill(distanecs, Integer.MAX_VALUE);
        distanecs[r] = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> distanecs[i]));
        pq.add(r);
        while (!pq.isEmpty()) {
            int s = pq.poll();
            for (Entry<Integer, Integer> entry : costs.getOrDefault(s, Collections.emptyMap()).entrySet()) {
                int t = entry.getKey();
                int d = entry.getValue();
                if (distanecs[t] == Integer.MAX_VALUE || distanecs[s] + d < distanecs[t]) {
                    distanecs[t] = distanecs[s] + d;
                    pq.add(t);
                }
            }
        }
        
        for (int distance : distanecs) {
            if (distance == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance);
            }
        }
    }
}
