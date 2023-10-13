import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HashMapTests {

    @Test
    public void success_add() {
        // Given a new hash map
        HashMap hashMap = new HashMap();
        Assertions.assertEquals(0, hashMap.getSize());

        // When an item is added
        hashMap.add(1, 1);

        // Then the item should be added correctly
        Assertions.assertEquals(1, hashMap.getSize());
    }

    @Test
    public void success_get() {
        // Given a new hash map with 1 key
        HashMap hashMap = new HashMap();
        Assertions.assertEquals(0, hashMap.getSize());
        hashMap.add(1, 99);

        // When an item is retrieved
        Integer value = hashMap.get(1);

        // Then the item should be retrieved correctly
        Assertions.assertEquals(99, value);
        Assertions.assertEquals(1, hashMap.getSize());
    }

    @Test
    public void failure_get_key_does_not_exist() {
        // Given an empty hashmap
        HashMap hashMap = new HashMap();
        Assertions.assertEquals(0, hashMap.getSize());

        // When a non-existent item is retrieved
        Integer value = hashMap.get(1);

        // Then the item should be null
        Assertions.assertNull(value);
    }

    @Test
    public void success_printAll() {
        // Given a new hash map with 20 random keys
        HashMap hashMap = new HashMap();
        Assertions.assertEquals(0, hashMap.getSize());
        Random rand = new Random();
        ArrayList<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int num = rand.nextInt(100);
            hashMap.add(i, num);
            expected.add(num);
        }
        Collections.sort(expected);

        // When print method is called
        ArrayList<Integer> result = hashMap.printAll(true);

        // Then the values should be printed in ascending order
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void success_printAll_1_000_000() {
        // Given a new hash map with 1_000_000 random keys
        HashMap hashMap = new HashMap();
        Assertions.assertEquals(0, hashMap.getSize());
        Random rand = new Random();
        ArrayList<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            int num = rand.nextInt(1_000_000);
            hashMap.add(i, num);
            expected.add(num);
        }
        Collections.sort(expected);

        // When print method is called
        ArrayList<Integer> result = hashMap.printAll(true);

        // Then the values should be printed in ascending order
        Assertions.assertEquals(expected, result);
    }
}
