package miscellanea.leetcode;

public class KWeakestRowsInMatrix {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 0, 0},
                {1, 0, 0},
                {0, 0, 0},
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 1},
                {1, 1, 0}
        };
        int[] result = kWeakestRows(mat, 7);
        for (int res : result) {
            System.out.println(res);
        }
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] empty = new int[0];
        int columns =  mat[0].length;
        int[] result = new int[k];
        int weakCounter = 0;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (mat[i].length != 0 && mat[i][j] == 0) {
                    result[weakCounter++] = i;
                    mat[i] = empty;
                }
                if (weakCounter == k) {
                    return result;
                }
            }
        }
        for (int i = 0; weakCounter < k; i++) {
            if (mat[i].length != 0) {
                result[weakCounter++] = i;
            }
        }
        return result;
    }
}
