
import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        TreeSet<Integer> available = new TreeSet<>();
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] count = new int[k];

        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        for (int i = 0; i < arrival.length; i++) {

            int currentTime = arrival[i];

            // Release servers whose tasks have finished
            while (!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                int[] server = busy.poll();
                available.add(server[1]);
            }

            // If no server is available, drop the request
            if (available.isEmpty()) {
                continue;
            }

            // Find the next available server
            int serverId = i % k;

            Integer selected = available.ceiling(serverId);

            if (selected == null) {
                selected = available.first();
            }

            // Assign request to server
            available.remove(selected);

            count[selected]++;

            // Add server to busy queue
            busy.offer(new int[]{
                currentTime + load[i],
                selected
            });
        }

        // Find maximum number of requests handled
        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }

        return result;
    }
}
