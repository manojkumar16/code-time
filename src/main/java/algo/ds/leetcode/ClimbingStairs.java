package algo.ds.leetcode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
 * 
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsUsingRecursion(5));
        System.out.println(climbStairsUsingDP(5));
        System.out.println(climbStairsUsingFibonacci(5));
    }

    private static int climbStairsUsingFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    // Dynamic Programming
    private static int climbStairsUsingDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Recursion with Memoization
    public static int climbStairsUsingRecursion(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }

    public static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
