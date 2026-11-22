class Pair{
    int first;
    char second;
    Pair(int f, char s){
        first = f; 
        second = s;
    }
}
class Solution {
    public String reorganizeString(String s) {
        String res = "";
        int seat = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.first - a.first);

        for(char ch : map.keySet()){
            int first = map.get(ch);
            char second = ch;
            Pair curr = new Pair(first, second);
            pq.add(curr);
        }

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(seat == 0 || res.charAt(seat - 1) != p.second){
                res = res + p.second;
                seat++;
                p.first--;
                if(p.first > 0) pq.add(p);
            }
            else{
                if(pq.isEmpty()) return "";
                Pair p2 = pq.poll();
                res = res + p2.second;
                seat++;
                p2.first--;
                if(p2.first > 0) pq.add(p2);
                pq.add(p);
            }
        }
        return res;

    }
    
}