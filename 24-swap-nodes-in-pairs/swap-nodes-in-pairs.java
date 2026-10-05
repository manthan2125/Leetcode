class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode t1 = d1;
        ListNode t2 = d2;
        ListNode t = head;
        while(t != null){
            t1.next = t;
            t1 = t1.next;
            t = t.next;
            if(t == null) t2.next = null;
            else{
                t2.next = t;
                t2 = t2.next;
                t = t.next;
            }
        }
        t1.next = null;
        t2.next = null;
        t1 = d1.next;
        t2 = d2.next;
        ListNode d = new ListNode(0);
        t = d;
        while(t1 != null && t2 != null){
            t.next = t2;
            t2 = t2.next;
            t = t.next;

            t.next = t1;
            t1 = t1.next;
            t = t.next;
        }
        return d.next;
        
    }
}