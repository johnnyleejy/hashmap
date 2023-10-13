public class Node {
    private int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.value = value;
        this.next = null;
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}