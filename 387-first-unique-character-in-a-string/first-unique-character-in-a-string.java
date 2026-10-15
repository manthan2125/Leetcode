class Solution {
    public int firstUniqChar(String s) {
        // HashMap<Character, Integer> map = new HashMap<>();
        // for(int i = 0; i < s.length(); i++){
        //     char ch = s.charAt(i);
        //     if(map.containsKey(ch)){
        //         int freq = map.get(ch);
        //         map.put(ch, freq+1);
        //     }
        //     else map.put(ch, 1);
        // }
        // for(int i = 0; i < s.length(); i++){
        //     char ch = s.charAt(i);
        //     if(map.containsKey(ch)){
        //         int freq = map.get(ch);
        //         if(freq == 1) return i;
        //     }
        // }
        // return -1;

        int[] count = new int[26];
        for(char ch : s.toCharArray()){
            count[ch - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(count[ch - 'a'] == 1) return i;
        }
        return -1;
    }
}