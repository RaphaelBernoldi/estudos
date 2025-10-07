package leetcode.problems;

import br.com.estudos.leetcode.problems.Solution;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    @Test
    public void testTwoSum() {
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(ints, new int[]{0, 1});
        ints = solution.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(ints, new int[]{1, 2});
        ints = solution.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(ints, new int[]{0, 1});
    }
}
