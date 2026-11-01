
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Handle empty list or single node
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and last node
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Reduce unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Step 3: Connect tail to head (make circular list)
        tail.next = head;

        // Step 4: Find new tail
        int steps = length - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
