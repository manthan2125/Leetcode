class Solution {
    public boolean fun(HashMap<Character, Integer> need, HashMap<Character, Integer> have){
        for(char ch : need.keySet()){
            int fneed = need.get(ch);
            Integer fhave = have.get(ch);
            if(fhave == null || fneed > fhave) return false;
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int n1 = ransomNote.length(), n2 = magazine.length();

        if (ransomNote.length() > magazine.length()) return false;

        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();

        for(int i = 0; i < n2; i++){
            char ch = magazine.charAt(i);
            if(have.containsKey(ch)){
                int freq = have.get(ch);
                have.put(ch, freq + 1);
            }
            else have.put(ch,1);
        }
        for(int i = 0; i < n1; i++){
            char ch = ransomNote.charAt(i);
            if(need.containsKey(ch)){
                int freq = need.get(ch);
                need.put(ch, freq + 1);
            }
            else need.put(ch,1);
        }
        
        return fun(need, have);
    }
}