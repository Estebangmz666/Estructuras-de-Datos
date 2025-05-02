package estebangmz666.preparcial_2.ej2;

import estebangmz666.preparcial_2.ej2.LinkedList.Node;

public class ListProcessor {

    public static Node insertAfterSum(Node head) {
        computeAndInsert(head);
        return head;
    }

    private static int computeAndInsert(Node node) {
        if (node == null) return 0;
        int sumFromHere = node.value + computeAndInsert(node.next);
        if (node.value == sumFromHere) {
            Node newNode = new Node(2);
            newNode.next = node.next;
            node.next = newNode;
        }
        return sumFromHere;
    }
}