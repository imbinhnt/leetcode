import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {
    @Test
    void example1() {
        assertArrayEquals(new int[] { 0, 1 },
                new TwoSum().twoSum(new int[] { 2, 7, 11, 15 }, 9));
    }
}