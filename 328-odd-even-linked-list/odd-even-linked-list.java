class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode to = odd;
        ListNode te = even;
        ListNode t = head;
        while(t != null){
            to.next = t;
            to = to.next;
            t = t.next;
            if( t == null ){
                to.next = null;
                te.next = null;
                break;
            }
            te.next = t;
            te = te.next;
            t = t.next;
        }
        to.next = even.next;
        return odd.next;
    }
}