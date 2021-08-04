package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 
 */
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(getRow(4));

    }

    /**
     * Memory-efficient Dynamic Programming
     * 
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1); // to the end
        }
        return row;
    }

    /**
     * Brute Force Recursion
     * 
     * We can use memoization cache to improve the time complexity
     * 
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> ls = new ArrayList<>();
        for (int j = 0; j <= rowIndex; j++) {
            int num = getNum(rowIndex, j);
            ls.add(num);
        }
        return ls;
    }

    public static int getNum(int i, int j) {
        if (i == 0 || j == 0 || i == j) {
            return 1;
        }

        int computeValue = getNum(i - 1, j - 1) + getNum(i - 1, j);
        return computeValue;
    }
}
