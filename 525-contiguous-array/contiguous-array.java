class Solution {
    public int findMaxLength(int[] arr) {
        int n = arr.length;
        int zero = 0, one = 0;
        HashMap<Integer, Integer>  map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0) zero++;
            else one++;

            int diff = zero - one;
            if(diff == 0){
                res = Math.max(res, i+1);
            }
            if(map.containsKey(diff)){
                int len = i - map.get(diff);
                res = Math.max(res, len);
            }
            else{
                map.put(diff, i);
            }
        }
        return res;
    }
}