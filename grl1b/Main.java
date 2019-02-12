package grl1b;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
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
          costs.computeIfAbsent(s, unused -> new HashMap<>()).put(t, d);
        }
        
        int[] distances = new int[v];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[r] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(r);
        int count = 0;
        while (!queue.isEmpty()) {
            if (v * e < count) {
              System.out.println("NEGATIVE CYCLE");
              System.exit(0);                
            }
            
            int s = queue.poll();
            for (Entry<Integer, Integer> entry : costs.getOrDefault(s, Collections.emptyMap()).entrySet()) {
                int t = entry.getKey();
                int d = entry.getValue();
                if (distances[t] == Integer.MAX_VALUE || distances[s] + d < distances[t]) {
                    distances[t] = distances[s] + d;
                    queue.add(t);
                    count++;
                }
            }
        }

        for (int distance : distances) {
            if (distance == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance);
            }
        }
    }
}
