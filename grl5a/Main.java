package grl5a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;
 
public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        
        
        Map<Integer, List<Integer>> nxts = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> dist = new HashMap<>();
        for (int time = 0; time < n - 1; time++) {
            int s = stdin.nextInt();
            int t = stdin.nextInt();
            int d = stdin.nextInt();
            
            dist.computeIfAbsent(s, i -> new HashMap<>()).put(t, d);
            dist.computeIfAbsent(t, i -> new HashMap<>()).put(s, d);
            nxts.computeIfAbsent(s, i -> new ArrayList<>()).add(t);
            nxts.computeIfAbsent(t, i -> new ArrayList<>()).add(s);
        }
        
        Map<Integer, Integer> cost1 = bfs(nxts, dist, 0);
        int v1 = cost1.entrySet().stream().collect(Collectors.maxBy(Comparator.comparing(Entry::getValue))).get().getKey();
        Map<Integer, Integer> cost2 = bfs(nxts, dist, v1);
        int ans = cost2.values().stream().max(Comparator.naturalOrder()).get();
        System.out.println(ans);
    }

    public static Map<Integer, Integer> bfs(Map<Integer, List<Integer>> nxts, Map<Integer, Map<Integer, Integer>> dist, int start) {
        Map<Integer, Integer> cost = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        
        queue.addLast(start);
        cost.put(start, 0);
        while (!queue.isEmpty()) {
            int current = queue.pollFirst();
            for (int nxt : nxts.getOrDefault(current, Collections.emptyList())) {
                if (cost.containsKey(nxt)) continue; // visited;
                cost.put(nxt, cost.get(current) + dist.get(current).get(nxt));
                queue.add(nxt);
            }
        }
        
        return cost;
    }
}