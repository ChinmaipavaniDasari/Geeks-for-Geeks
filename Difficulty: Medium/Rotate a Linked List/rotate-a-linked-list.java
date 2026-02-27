/*
class Node {
    int data;
    Node next;

    Node(int d){
        data=d;
        next=null;
   }
}
*/

class Solution {
    public Node rotate(Node head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        // Step 1: Find length and last node
        Node curr = head;
        int length = 1;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: Connect last node to head (make circular)
        curr.next = head;

        // Step 3: Reduce k if k > length
        k = k % length;

        // If k becomes 0
        if (k == 0) {
            curr.next = null;
            return head;
        }

        // Step 4: Move to new tail (k steps)
        Node newTail = head;
        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }

        // Step 5: New head
        Node newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }
}