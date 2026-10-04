
class Solution {
    public ListNode reverse(ListNode head){
        ListNode agla = null;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int maxSum = Integer.MIN_VALUE;
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        ListNode i = head;
        ListNode j = head2;
        while(j != null){
            int sum = i.val + j.val;
            if(sum > maxSum) maxSum = sum;
            i = i.next;
            j = j.next;
        }
        return maxSum;
    }
}