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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode returnnode=new ListNode(Integer.MIN_VALUE);
        ListNode headnode=returnnode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                returnnode.next=list1;
                list1=list1.next;
            }
            else{
                returnnode.next=list2;
                list2=list2.next;
            }
            returnnode=returnnode.next;
        }
        if(list1!=null){
            returnnode.next=list1;
            list1=list1.next;
        }else if(list2!=null){
            returnnode.next=list2;
            list2=list2.next;
        }
        return headnode.next;
    }
}