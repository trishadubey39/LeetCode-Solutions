/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1) return head;
        //1. count group
        int group_count = 0;
        ListNode temp_head = head;
        while(temp_head != null){
            group_count++;
            temp_head = temp_head.next;
        }
        group_count /= k;

        //2. Reverse each group
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while(group_count-- > 0){
            ListNode temp_tail = head;
            int i = k;
            ListNode prev = null, curr = head, next = head.next;
            // reverse
            while(i-- > 0){
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next != null) next = next.next;
            }
            tail.next = prev;
            tail = temp_tail;
            head = curr;
        }
        if(head != null) tail.next = head;
        return result.next;
        
    }
}