import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Random;

public class HashMapTests {

    @Test
    public void add() {
        // Given a new hash map
        HashMap hashMap = new HashMap(5);
        Assertions.assertEquals(0, hashMap.getSize());

        // When an item is added
        hashMap.add(1, 1);

        // Then the item should be added correctly
        Assertions.assertEquals(1, hashMap.getSize());
    }

    @Test
    public void get() {
        // Given a new hash map with 1 key
        HashMap hashMap = new HashMap(5);
        Assertions.assertEquals(0, hashMap.getSize());
        hashMap.add(1, 99);

        // When an item is retrieved
        int value = hashMap.get(1);

        // Then the item should be retrieved correctly
        Assertions.assertEquals(99, value);
        Assertions.assertEquals(1, hashMap.getSize());
    }

//    @Test
//    public void printAll() {
//        // Given a new hash map with 20 random keys
//        HashMap hashMap = new HashMap(100);
//        Assertions.assertEquals(0, hashMap.getSize());
//        Random rand = new Random();
//        int[] expected = new int[20];
//        for (int i = 0; i < 20; i++) {
//            int num = rand.nextInt(100);
//            hashMap.add(num, num);
//            expected[i] = num;
//        }
//
//        // When print method is called
//        int[] result = hashMap.printList();
//        Arrays.sort(expected);
//
//        // Then the values should be printed in ascending order
//        Assertions.assertArrayEquals(expected, result);
//    }
}
