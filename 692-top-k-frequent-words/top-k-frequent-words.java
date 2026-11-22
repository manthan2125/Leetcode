class Pair{
    int first;
    String second;
    Pair(int f, String s){
        first = f; 
        second = s;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();

        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words){
            if(map.containsKey(word)){
                int freq = map.get(word);
                map.put(word, freq+1);
            }
            else map.put(word, 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>( 
            (a,b) -> {
            if(a.first != b.first) return a.first - b.first;
            return b.second.compareTo(a.second);
            }
        );

        for(String word : map.keySet()){
            int first = map.get(word);
            String second = word;
            Pair curr = new Pair(first, second);
            if(pq.size() < k) pq.add(curr);

            else if(curr.first > pq.peek().first || 
                (curr.first == pq.peek().first && curr.second.compareTo(pq.peek().second) < 0)) {
                pq.poll();
                pq.add(curr);
            }
        }
        while(!pq.isEmpty()){
            res.add(pq.poll().second);
        }
        Collections.reverse(res);
        return res;
        
    }
}