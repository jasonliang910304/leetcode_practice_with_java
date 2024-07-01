import java.util.*;

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
    public ListNode doubleIt(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();

        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int sum, carry = 0;
        ListNode newHead = null;
        while (stack.isEmpty() == false || carry != 0){
            sum = stack.isEmpty()? carry : stack.peek() * 2 + carry;
            newHead = new ListNode(sum % 10, newHead);
            carry = sum / 10;
            if(stack.isEmpty()){
                break;
            }
            else{
                stack.pop();
            }
        }
        return newHead;
    }
}
