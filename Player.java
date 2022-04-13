import java.util.Scanner;

public class Player {

    public String symbol;
    public Board gameBoard;

    public Player(String symbol, Board board) {
        this.symbol = symbol;
        this.gameBoard = board;
    }

    /**
     * Checks if the space is free, then moves the player on the board.
     * @param x - the x position value
     * @param y - the y position value
     */
    public void makeMove(int x, int y) {
        if (this.gameBoard.isSpaceFree(x, y)) {
            this.gameBoard.makeMove(x, y, symbol);
        } else {
            System.out.println("That spot is taken already.");
        }
    }

    public void makeMove(int[] space) {
        this.makeMove(space[0], space[1]);
    }

    public void makeMove(Position position) {
        this.makeMove(position.getX(), position.getY());
    }

    public void getUserMove(Scanner scan) {
        System.out.print("Enter a spot to move to\n>>  ");
        int position = scan.nextInt();
    }

    private void getBoardIndexFromPosition(int position) {

        for (int i = 0; i < position; i++) {
            
        }
    }

    
}
