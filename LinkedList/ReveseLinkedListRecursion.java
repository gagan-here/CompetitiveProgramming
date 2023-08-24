package LinkedList;

class Node {

    int data;
    Node next;
}

class LinkedList {

    public Node insert(int key, Node node) {
        if (node == null) {
            return getNewNode(key);
        } else {
            node.next = insert(key, node.next);
        }
        return node;
    }

    public Node getNewNode(int i) {
        Node a = new Node();
        a.data = i;
        a.next = null;
        return a;
    }

    public Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node temp = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return temp;
    }

    public void printList(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printList(node.next);
    }

    public static class ReveseLinkedListRecursion {

        public static void main(String[] args) {
            Node head = null;
            LinkedList a = new LinkedList();
            head = a.insert(1, head);
            head = a.insert(2, head);
            head = a.insert(3, head);
            head = a.insert(4, head);
            head = a.insert(5, head);

            a.printList(head);
            System.out.println();

            head = a.reverse(head);
            a.printList(head);
        }
    }

}

