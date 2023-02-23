package miscellanea.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
//                {1, 1, 1},
//                {1, 1, 0},
//                {1, 0, 1}
        };
        new FloodFill().floodFill(image, 1, 1, 2);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Cell {
        public Cell(int x, int y) {
            this.row = x;
            this.column = y;
        }

        int row;
        int column;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(sr, sc));
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            int currentColor = image[cell.row][cell.column];
            //left
            if (cell.column > 0 && image[cell.row][cell.column - 1] == currentColor && image[cell.row][cell.column - 1] != color) {
                queue.add(new Cell(cell.row, cell.column - 1));
            }
            //right
            if (cell.column < image[cell.row].length - 1 && image[cell.row][cell.column + 1] == currentColor && image[cell.row][cell.column + 1] != color) {
                queue.add(new Cell(cell.row, cell.column + 1));
            }
            //top
            if (cell.row > 0 && image[cell.row - 1][cell.column] == currentColor && image[cell.row - 1][cell.column] != color) {
                queue.add(new Cell(cell.row - 1, cell.column));
            }
            //bottom
            if (cell.row < image.length - 1 && image[cell.row + 1][cell.column] == currentColor && image[cell.row + 1][cell.column] != color) {
                queue.add(new Cell(cell.row + 1, cell.column));
            }
            image[cell.row][cell.column] = color;
        }
        return image;
    }
}
