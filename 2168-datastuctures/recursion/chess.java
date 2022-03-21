import java.util.Arrays;

public class chess {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        solve(board, 0);
    }

    static boolean validMove(int[][] board, int row, int col) {
        // check if same row
        // to check a specific row we have to look at each and every collumn
        for (int i = 0; i < board[row].length; i++) {
            // this means that we checked every collumn in this specific row
            if (board[row][i] == 1) {
                return false;
            }
        }
        // now we have to check every collumn in a specific row
        // so now we are looking on the verticl paths
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // checking diagonals we either add 1 to row and col or minus to row and col or -1 to row and
        //+1 to col and vice versa
        // we set up conditions in order for our for loops to not exceed the values that we set up

        for (int i = row,j=col; i >= 0 && j>=0; i--,j--) {
            if(board[i][j]==1){
                return false;
            }

        }
        for (int i = row,j=col; i< board.length && j>=0 ; i++,j--) {
            if(board[i][j]==1){
                return false;
            }
        }
        for (int i = row, j=col; i >= 0 && j< board.length; i--,j++) {
            if(board[i][j]==1){
                return false;
            }

        }
        for (int i = row,j=col; i< board.length && j<board[row].length ; i++) {
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }


    static boolean solve(int[][] board, int row) {
        // if the row goes above the number of rows we end
        if (row >= board[0].length) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            return true;
        }
        // we iterate through each collumn in a specific row
        for (int col = 0; col < board[row].length; col++) {
            if (validMove(board, row, col)) {
                board[row][col] = 1;
                //we say row +1 to keep going through every row
                if (solve(board, row + 1)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }

            }
        }
        return false;
    }
}