package dyanamicProgramming;

public class UniquePathsObstacles {
    public static void main(String[] args) {
        UniquePathsObstacles obj = new UniquePathsObstacles();
        int m = 4;
        int n = 3;
        int[][] obstacles = {{0, 1, 0},
                            {0, 0, 0},
                            {0, 1, 0},
                            {0, 0, 0}};

        int result = obj.uniquePaths(m, n, obstacles);
        System.out.println("Number of unique ways:" + result);
    }

    private int uniquePaths(int m, int n, int[][] obstacles) {
        int dp[][] = new int[m][n];
        if (obstacles[0][0] == 1) {
            dp[0][0] = 0;
        } else {
            dp[0][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            if (obstacles[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < n; i++) {
            if (obstacles[0][i] == 1) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacles[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
