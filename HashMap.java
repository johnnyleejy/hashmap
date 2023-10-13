import java.util.ArrayList;
import java.util.Collections;

public class HashMap {
    private Node[] map;
    private int capacity;
    private int size;

    public HashMap() {
        // Default capacity to 16
        this.capacity = 16;
        this.size = 0;
        this.map = new Node[this.capacity];
    }

    private int hashFunction(int key) {
        return key % this.capacity;
    }

    // O(1). Worst case is O(n) when hashmap resizes.
    public void add(int key, int value) {
        int index = this.hashFunction(key);
        Node node = this.map[index];

        if (node == null) {
            this.map[index] = new Node(key, value);
            this.size += 1;
        } else {
            Node prev = null;
            // Handle key collisions
            while (node != null) {
                // If key already exists, return the corresponding value
                if (node.getKey() == key) {
                    node.setValue(value);
                    return;
                }
                prev = node;
                node = node.getNext();
            }
            // Create new node to store key and value
            prev.setNext(new Node(key, value));
            this.size += 1;
        }
        // Resize hashmap if current size reaches 70% of current capacity
        if ((double) this.size / this.capacity >= 0.7) {
            this.resize();
        }
    }

    // O(1)
    public Integer get(int key) {
        int index = this.hashFunction(key);
        Node node = this.map[index];

        while (node != null) {
            if (node.getKey() == key) {
                return node.getValue();
            }
            node = node.getNext();
        }
        return null;
    }

    public int getSize() {
        return this.size;
    }

    public void resize() {
        // Double current capacity
        int newCapacity = this.capacity * 2;
        Node[] newMap = new Node[newCapacity];

        // Transfer existing keys and values over to newMap with new capacity
        for (Node node : this.map) {
            while (node != null) {
                int index = node.getKey() % newCapacity;
                if (newMap[index] == null) {
                    newMap[index] = new Node(node.getKey(), node.getValue());
                } else {
                    Node newNode = newMap[index];
                    while (newNode.getNext() != null) {
                        newNode = newNode.getNext();
                    }
                    newNode.setNext(new Node(node.getKey(), node.getValue()));
                }
                node = node.getNext();
            }
        }
        this.capacity = newCapacity;
        this.map = newMap;
    }

    // O(n) where n is capacity of hashmap
    public ArrayList<Integer> printAll(boolean testMode) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < this.capacity; i++) {
            if (this.map[i] != null) {
                Node node = this.map[i];
                while (node != null) {
                    result.add(node.getValue());
                    node = node.getNext();
                }
            }
        }
        Collections.sort(result);
        // This flag is just to save time from printing the values
        if (!testMode) {
            for (int value: result) {
                System.out.println("Value: " + value);
            }
        }
        return result;
    }
}