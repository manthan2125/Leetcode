class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(have.containsKey(ch)){
                int freq = have.get(ch);
                have.put(ch, freq  + 1);
            } 
            else have.put(ch, 1);
        }
        
        need.put('b',1);
        need.put('a',1);
        need.put('l',2);
        need.put('o',2);
        need.put('n',1);

        for(char ch : need.keySet()){
            int fneed = need.get(ch);
            int fhave = have.getOrDefault(ch, 0);
            int times = fhave / fneed;
            res = Math.min(res, times);
        }
        return res;
    }
}