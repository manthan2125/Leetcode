class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            int ele = arr[i];
            if(map.containsKey(ele)){
                int freq = map.get(ele);
                map.put(ele, freq + 1);
            }
            else map.put(ele,1);
        }
        for(int key : map.keySet()){
            if(key == map.get(key)) {
                if(key > ans) ans = key;
            }
        }
        if(ans == Integer.MIN_VALUE) return -1;
        return ans;
    }
}