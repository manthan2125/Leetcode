class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans  = 0;
        boolean odd = false;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int freq = map.get(ch);
                map.put(ch, freq + 1);
            }
            else map.put(ch, 1);
        }
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(freq % 2 == 0) ans += freq;
            else odd = true;
        }

        if(odd == false) return ans;

        for(char ch : map.keySet()){
            int freq = map.get(ch);
            if(freq % 2 == 1) ans += freq - 1;
        }
        return ans + 1;
    }
}