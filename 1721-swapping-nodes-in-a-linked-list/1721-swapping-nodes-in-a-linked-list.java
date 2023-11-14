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
    public ListNode swapNodes(ListNode head, int k) {

        if(head == null){
            return head;
        }

        ListNode temp=head;

        int size=0;

        while(temp != null){
            size++;
            temp=temp.next;
        }
        temp=head;

        for(int i=1;i<k;i++){
            temp=temp.next;
        }

         int val1=temp.val;

         int k2=size-k;
         
         temp=head;
         for(int i=0;i<k2;i++){
             temp=temp.next;
         }

         int val2=temp.val;
        
         temp=head;
           for(int i=1;i<k;i++){
            temp=temp.next;
        }
        temp.val=val2;

        temp=head;
         for(int i=0;i<k2;i++){
             temp=temp.next;
         }
         temp.val=val1;

        return head;
    }
}