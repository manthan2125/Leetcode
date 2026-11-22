class Pair{
    int first;
    int second;
    Pair(int f, int s){
        first = f; 
        second = s;
    }
}

class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele : arr){
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele, freq+1);
            }
            else map.put(ele, 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>( 
            (a,b) -> {
            if(a.first != b.first) return a.first - b.first;
            return a.second - b.second;
            }
        );

        for(int ele : map.keySet()){
            int first = map.get(ele);
            int second = ele;
            Pair curr = new Pair(first, second);
            if(pq.size() < k) pq.add(curr);

            else if(curr.first > pq.peek().first) {
                pq.poll();
                pq.add(curr);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll().second);
        }
        int[] ans = res.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}