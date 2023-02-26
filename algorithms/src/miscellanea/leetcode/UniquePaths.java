package miscellanea.leetcode;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    grid[i][j] = 1;
                }else {
                    int above = i > 0 ? grid[i - 1][j] : 0;
                    int before = j > 0 ? grid[i][j - 1] : 0;
                    grid[i][j] = above + before;
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
