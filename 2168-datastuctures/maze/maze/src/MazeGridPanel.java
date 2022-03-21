import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JPanel;

public class MazeGridPanel extends JPanel {
    private int rows;
    private int cols;
    private Cell[][] maze;


    // extra credit
    public void genDFSMaze() {
        boolean[][] visited;
        Stack<Cell> stack = new Stack<Cell>();
        Cell start = maze[0][0];
        stack.push(start);
    }

    //homework
    public void solveMaze() {
        Stack<Cell> stack = new Stack<Cell>();
        Cell start = maze[0][0];
        start.setBackground(Color.GREEN);
        Cell finish = maze[rows - 1][cols - 1];
        finish.setBackground(Color.RED);
        //start of stack
        stack.push(start);
        //while cell is not at end of maze andn we peek to see where we are
        while (stack.peek().getBackground() != Color.red && !stack.empty()) {
            //peek again to get the current position
            Cell current = stack.peek();
            //now check if there is no wall and if we have visited that location and if we havent
            // we go that way and mark the location that we moved from and repeated for east and west and south
            //row controls up and down and col controls left to right
            if (!current.southWall && !visited(current.row + 1, current.col)) {
                stack.push((maze[current.row+1][current.col]));
                current.setBackground(Color.ORANGE);

            }
            else if (!current.northWall && !visited(current.row - 1, current.col)) {
                stack.push((maze[current.row-1][current.col ]));
                current.setBackground(Color.ORANGE);
            }
            else if (!current.eastWall && !visited(current.row, current.col+1)) {
                stack.push((maze[current.row][current.col + 1]));
                current.setBackground(Color.ORANGE);

            }
            else if (!current.westWall && !visited(current.row, current.col-1)) {
                stack.push((maze[current.row][current.col - 1]));
                current.setBackground(Color.ORANGE);
            }
            else{
                //setting it to blue means that this place is deadend
                current.setBackground(Color.BLUE);
                stack.pop();
                //pop to backtrack if we cant go any direction
                }
            }
        //since we marked our current location, the start will be overwritten to orange
        //but setting it to green will counteract that
        maze[0][0].setBackground(Color.GREEN);
        }


    public boolean visited(int row, int col) {
        Cell c = maze[row][col];
        Color status = c.getBackground();
        if (status.equals(Color.WHITE) || status.equals(Color.RED)) {
            return false;
        }


        return true;


    }


    public void genNWMaze() {

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (row == 0 && col == 0) {
                    continue;
                } else if (row == 0) {
                    maze[row][col].westWall = false;
                    maze[row][col - 1].eastWall = false;
                } else if (col == 0) {
                    maze[row][col].northWall = false;
                    maze[row - 1][col].southWall = false;
                } else {
                    boolean north = Math.random() < 0.5;
                    if (north) {
                        maze[row][col].northWall = false;
                        maze[row - 1][col].southWall = false;
                    } else {  // remove west
                        maze[row][col].westWall = false;
                        maze[row][col - 1].eastWall = false;
                    }
                    maze[row][col].repaint();
                }
            }
        }
        this.repaint();

    }

    public MazeGridPanel(int rows, int cols) {
        this.setPreferredSize(new Dimension(800, 800));
        this.rows = rows;
        this.cols = cols;
        this.setLayout(new GridLayout(rows, cols));
        this.maze = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                maze[row][col] = new Cell(row, col);

                this.add(maze[row][col]);
            }

        }


        this.genNWMaze();
        this.solveMaze();

    }


}
