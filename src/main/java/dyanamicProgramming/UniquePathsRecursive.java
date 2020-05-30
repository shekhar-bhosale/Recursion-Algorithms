package dyanamicProgramming;

public class UniquePathsRecursive {
    public static void main(String[] args) {
        UniquePathsRecursive obj = new UniquePathsRecursive();
        int m = 4;
        int n = 4;
        int result = obj.uniquePaths(m - 1, n - 1, new int[m][n]);
        System.out.println("Unique paths:" + result);
    }

    private int uniquePaths(int m, int n, int dp[][]) {
        if (m == 0 || n == 0) {
            return 1;
        }

        if (m < 0 || n < 0) {
            return 0;
        }

        if (dp[m][n] == 0) {
            int waysTop = uniquePaths(m - 1, n, dp);
            int waysLeft = uniquePaths(m, n - 1, dp);
            dp[m][n] = waysTop + waysLeft;
        }
        return dp[m][n];
    }
}
