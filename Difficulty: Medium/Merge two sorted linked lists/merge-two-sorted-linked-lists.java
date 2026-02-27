/*
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
         ArrayList<Integer> arr = new ArrayList<>();

        // pushing the values of the first linked list
        while (head1 != null) {
            arr.add(head1.data);
            head1 = head1.next;
        }

        // pushing the values of the second linked list
        while (head2 != null) {
            arr.add(head2.data);
            head2 = head2.next;
        }

        // sorting the list
        Collections.sort(arr);

        // creating a new list with sorted values
        Node dummy = new Node(-1);
        Node curr = dummy;

        for (int i = 0; i < arr.size(); i++) {
            curr.next = new Node(arr.get(i));
            curr = curr.next;
        }

        return dummy.next;
        
    }
    void printList(Node curr) {
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}