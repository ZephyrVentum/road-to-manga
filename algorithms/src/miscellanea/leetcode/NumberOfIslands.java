package miscellanea.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}
//                {'1'},
//                {'1'},
//                {'0','0','0','0','0','0','0'}
//                {'1', '1', '1'},
//                {'0', '1', '0'},
//                {'1', '1', '1'}
//                {'1', '1', '0', '0', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '1', '0', '0'},
//                {'0', '0', '0', '1', '1'}
        }));
    }

    public int numIslands(char[][] grid) {
        int answer = 0;
        Set<Integer> checkedCellsIds = new HashSet<>();
        int rows = grid.length;
        int columns = grid[0].length;
        int gridSize = grid.length * grid[0].length;
        for (int i = 0; i < gridSize; i++) {
            int row = i / columns;
            int column = i % columns;
            if (dfs(grid, checkedCellsIds, row, column, rows, columns)) {
                answer++;
            }
            print(grid[row][column], i, columns);
        }
        return answer;
    }

    public boolean dfs(char[][] grid, Set<Integer> checkedCellsIds, int row, int column, int rows, int columns) {
        char currentCell = grid[row][column];
        int inlineIndex = row * columns + column;
        if (!checkedCellsIds.contains(inlineIndex) && currentCell == '1') {
            checkedCellsIds.add(inlineIndex);
            if (column - 1 >= 0) {
                dfs(grid, checkedCellsIds, row, column - 1, rows, columns);
            }
            if (row - 1 >= 0) {
                dfs(grid, checkedCellsIds, row -1, column, rows, columns);
            }
            if (row + 1 < rows) {
                dfs(grid, checkedCellsIds, row + 1, column, rows, columns);
            }
            if (column + 1 < columns) {
                dfs(grid, checkedCellsIds, row, column + 1, rows, columns);
            }
            return true;
        } else {
            checkedCellsIds.add(inlineIndex);
            return false;
        }
    }

    void print(char ch, int i, int length) {
        System.out.print(ch + " ");
        if (i % length == length - 1) {
            System.out.println();
        }
    }
}
