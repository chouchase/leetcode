package leetcode.no86;

import datastruct.listnode.ListNode;

import java.util.List;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lt = new ListNode(0);
        ListNode ge = new ListNode(0);
        ListNode ltTail = lt;
        ListNode geTail = ge;
        while(head != null){
            if(head.val < x){
                ltTail.next = head;
                ltTail = ltTail.next;
            }else{
                geTail.next = head;
                geTail = geTail.next;
            }
            ListNode t = head;
            head = head.next;
            t.next = null;
        }
        if(ltTail != lt){
            ltTail.next = ge.next;
            return lt.next;
        }
        return ge.next;
    }
}
