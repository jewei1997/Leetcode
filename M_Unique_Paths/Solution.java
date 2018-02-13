import java.util.*;
public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[m-1][n-1] = 1;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) continue;
                int paths = 0;
                if (i < m-1) {
                    paths += memo[i+1][j];
                }
                if (j < n-1) {
                    paths += memo[i][j+1];
                }
                memo[i][j] = paths;
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {

        Solution S = new Solution();

        System.out.println (S.uniquePaths (5,6)); // 126
        System.out.println (S.uniquePaths (10,10)); // 48620

    }
}
