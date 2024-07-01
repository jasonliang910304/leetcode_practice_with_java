class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode ans = new ListNode();
        ListNode ansHead = ans;

        while (l1 != null || l2 != null || carry != 0){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            ans.next = new ListNode(sum % 10);
            ans = ans.next;
        }
        return ansHead.next;

    }
}
