class Solution {
    int convert(String s){
        int[] dates = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = Integer.parseInt(s.substring(0,2));
        int day = Integer.parseInt(s.substring(3,5));

        int total = day;

        for(int i = 0; i < month - 1; i++){
            total += dates[i];
        }
        return total;

    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aA =  convert(arriveAlice);
        int lA = convert(leaveAlice);
        int aB = convert(arriveBob);
        int lB = convert(leaveBob);
        int start = Math.max(aA, aB);
        int end = Math.min(lA, lB);

        return Math.max(0, end - start + 1);
    }
}