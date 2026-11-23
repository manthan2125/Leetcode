class Pair{
    int first;
    int second;
    Pair(int f, int s){
        first = f;
        second = s;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new Pair(capital[i], profits[i]));
        }

        Collections.sort(list, (a, b) -> {
            if(a.first != b.first) {
                return Integer.compare(a.first, b.first);
            }
            return Integer.compare(a.second, b.second);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  // max heap

        int idx = 0;
        while(k-- > 0){
            while(idx < n){
                if(list.get(idx).first > w) break;
                pq.add(list.get(idx).second);
                idx++;
            }

            if(pq.isEmpty()) return w;
            w = w + pq.peek();
            pq.poll();
        }
        return w;
    }
}