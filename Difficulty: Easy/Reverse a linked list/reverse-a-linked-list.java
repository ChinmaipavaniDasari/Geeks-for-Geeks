/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {

    Node reverseList(Node head) {

        if(head == null || head.next == null){
            return head;
        }

        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    void printList(Node node){
        while(node != null){
            System.out.print(node.data);
            if(node.next != null){
                System.out.print(" -> ");
            }
            node = node.next;
        }
    }
}