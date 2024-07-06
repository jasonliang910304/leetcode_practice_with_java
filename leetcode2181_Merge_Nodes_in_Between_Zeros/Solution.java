public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeNodes(ListNode head){
        ListNode mod = head.next;
        ListNode current = mod;
        int sum = 0;

        while (current != null) {
            if (current.val != 0) {
                sum += current.val;
                current = current.next;
            }
            else{
                mod.val = sum;
                sum = 0;
                mod.next = current.next;
                mod = mod.next;
                current = current.next;
            }
        }
        return head.next;
    }
}
