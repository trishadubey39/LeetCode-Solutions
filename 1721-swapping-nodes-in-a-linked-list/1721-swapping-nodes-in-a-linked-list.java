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
        ListNode t1=head;
        ListNode t2=head;
        ListNode t3=head;
        ListNode t4=head;
        ListNode t5=head;
        int i=1;
        
        while(t3.next!=null){
            i++;
            if(i<=k){
                t5=t1;
                t3=t3.next;
                t1=t1.next;
            }else{
                t4=t2;
                t3=t3.next;
                t2=t2.next;
            }
        }
        
        int n=0;
        if(t1.next==null){
           n=1; 
        }
        if(n==1){
            t5.next=t2;
            t1.next=t2.next;
            t2.next=null;
            head=t1;
        }else if(k==1){
            t4.next=t1;
            t2.next=t1.next;
            t1.next=null;
            head=t2;
        }else{
            t5.next=t4.next;
            t4.next=t1;
            ListNode p=t1.next;
            t1.next=t2.next;
            t2.next=p;
        }
        
        return head;
    }
}