import java.util.Arrays;
import java.util.Comparator;

public class HashMap {
    private Node[] map;
    private int capacity;
    private int size;

    public HashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new Node[this.capacity];
    }

    private int hashFunction(int key) {
        return key % this.capacity;
    }

    // O(1)
    public void add(int key, int value) {
        int index = this.hashFunction(key);
        Node node = this.map[index];

        if (node == null) {
            this.map[index] = new Node(key, value);
            this.size += 1;
        } else {
            Node prev = null;
            while (node != null) {
                if (node.getKey() == key) {
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key, value);
            this.size += 1;
        }
    }

    // O(1)
    public int get(int key) {
        int index = this.hashFunction(key);
        Node node = this.map[index];

        while (node != null) {
            if (node.getKey() == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public int getSize() {
        return this.size;
    }
}