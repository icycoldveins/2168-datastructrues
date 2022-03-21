import java.util.Arrays;

// no numbers in the same collumn
// no numbers in the same row
// a sudoku is made up of a 9x9 grid
public class sudoku {


    static boolean validMove(int[][] board, int row, int col, int number) {
        for (int i = 0; i < board[0].length; i++) {
            // this means that we checked every collumn in this specific row
            if (board[row][i] == number) {
                return false;
            }
        }
        // now we have to check every row in a specific collumn
        // so now we are looking on the horizontal paths
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }
        // checking each 3x3 grid to see if they add up to 45
        // we do this so we can see which nonet it is
        // when we divide for an int value we dont get a float
        // we get the floor of the division and so if we mutliply by 2 we can
        //see which nonet it is
        //1/3=0
        //5/3=1
        // this way we can see that we either get 0,1,2
        // when we multiplu by 3 we get either 0,3,6 which are the starting indexes of
        // the nonetes
        int startrow = (row / 3) * 3;
        int startcol = (col / 3) * 3;
        for (int i = startrow; i < startrow + 3; i++) {
            for (int j = startcol; j < startcol + 3; j++) {
                if (board[i][j] == number) {
                    return false;
                }

            }

        }
        return true;
    }

    public static void main(String[] args) {
        // our sudoku board that we are going to solve
        // 1. each row must contain the numbers from 1 to 9;
        //2. each collumn must contain numbers 1 to 9 without repetitioins
        //3. digits can only occur once per block
        //4. sum of every single row, collumn and nonet must equal 45
        int[][] board = new int[][]{
                {3, 1, 0, 4, 8, 0, 9, 2, 5},
                {5, 6, 0, 0, 0, 0, 0, 0, 7},
                {2, 4, 0, 7, 3, 5, 6, 8, 0},
                {8, 0, 0, 0, 0, 0, 0, 0, 9},
                {7, 0, 2, 8, 6, 0, 0, 0, 0},
                {0, 0, 4, 0, 5, 1, 2, 0, 0},
                {0, 0, 0, 0, 7, 8, 0, 9, 4},
                {4, 0, 0, 0, 0, 0, 8, 1, 0},
                {0, 0, 5, 1, 0, 0, 0, 0, 0},
        };
        solve(board, 0, 0);
    }

    static boolean solve(int[][] board, int row, int col) {
        // this means we checked every value possible and we should have the solution
        // our row is 8 and our col is 9 meaning that we have checked everything
        if (row == board.length - 1 && col == board[0].length) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            return true;
        }
        // we reset collumn and iterate row because we checked every value in a collumn and collumn is more than
        // the valid index
        if (col == board[0].length) {
            row++;
            col = 0;

        }
        // as we are only supposed to change the values that are not 0s we can just solve for the next collumn
        if (board[row][col] != 0) {
            return solve(board, row, col + 1);
        }
        for (int numbers = 1; numbers < 10; numbers++) {
            if (validMove(board, row, col, numbers)) {
                board[row][col] = numbers;
                if (solve(board, row, col + 1)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }
}
