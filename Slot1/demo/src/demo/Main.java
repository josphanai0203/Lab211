package demo;

class Node {

    int data;
    Node next;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

}

class List {

    Node head, tail;

    public List() {
        head = tail = null;
    }

    public void add_tail(int x) {
        add_after(new Node(x), tail);

    }

    public void add_head(int x) {
        add_after(new Node(x), null);
    }

    public void add_after(Node node, Node pred) {
        if (pred == null) {
            node.next = head;
            head = node;
        } else {
            node.next = pred.next;
            pred.next = node;

        }
        if (tail == pred) {
            tail = node;
        }
    }

    public void add_with_position(int value, int index) {
        Node current = head;
        int i = 0;
        while(i<=index && current != null){
            if(index == i){
                System.out.println("2");
                add_after(new Node(value), current);
                break;
            }else{
                i++;
                current = current.next;
            }
        }
        if(current == null){
            add_tail(value);
        }
    }
    public void search(int k){
        
    }

    @Override
    public String toString() {
        Node current = head;
        String s = "";
        while (current != null) {
            s += current.data + "  ";
            current = current.next;
        }
        return s;
    }

}

public class Main {

    public static void main(String[] args) {
        System.out.println(Double.parseDouble("-1.2"));

    }
}
