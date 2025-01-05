import java.util.*;

public class Solution {
    public int dijkstra(Map<Integer, List<int[]>> graph, int start, int n) {
        int ans = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start}); // {비용, 현재 노드}
        Set<Integer> visit = new HashSet<>();

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0], curV = cur[1];
            
            visit.add(curV);
            
            if(visit.size() == n) {
                ans = curCost;
                break;
            }
            for (int[] next : graph.getOrDefault(curV, new ArrayList<>())) {
                int nextCost = curCost + next[0];
                int nextV = next[1];
                if(visit.contains(nextV)) continue;
                pq.offer(new int[]{nextCost, nextV});
            }
        }

        return ans;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int a = time[0], b = time[1], c = time[2];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(new int[]{c, b});
        }

        int ans = -1;
        ans = dijkstra(graph, k, n);
        if (ans == 0) {
            ans = -1;
        }

        return ans;
    }
}
