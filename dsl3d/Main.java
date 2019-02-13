package dsl3d;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        int l = stdin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = stdin.nextInt();
        
        List<Integer> mins = new ArrayList<>();
        
        SortedMap<Integer, Integer> counter = new TreeMap<>();
        
        for (int i = 0; i < l; i++) counter.put(a[i], counter.getOrDefault(a[i], 0) + 1);
        mins.add(counter.firstKey());

        for (int p = 0, q = l; q < n; p++, q++) {
            counter.put(a[p], counter.get(a[p]) - 1);
            if (counter.get(a[p]) == 0) counter.remove(a[p]); 
            
            counter.put(a[q], counter.getOrDefault(a[q], 0) + 1);
            
            mins.add(counter.firstKey());    
        }
        
        String answer = mins.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(answer);
    }
}
