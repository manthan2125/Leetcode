
class Solution {
    public void reverse(ListNode head, int times){
        ListNode curr = head;
        ListNode prev = null;
        ListNode agla = null;
        while(times > 0){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
            times--;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int size = k;
        ListNode left = head;
        ListNode res = null;
        ListNode right;
        ListNode prevleft = null;
        while(true){
            right = left;
            for(int i = 0; i < size - 1; i++){
                if(right == null) break;
                right = right.next;
            }
            if(right != null){
                ListNode nextleft = right.next;
                reverse(left, size);
                if(prevleft != null) prevleft.next = right;
                prevleft = left;
                if(res == null) res = right;
                left = nextleft;
            }
            else{
                if(prevleft != null) prevleft.next = left;
                if(res == null) res = left;
                break;
            }
        }
        return res;
    }
}