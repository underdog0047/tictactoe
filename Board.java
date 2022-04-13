
public class Board {

    private String[][] board;
    private boolean gameDone;

    public Board() {
        this.gameDone = false;
        this.board = new String[3][3];
    }


    public boolean isGameDone() {
        return this.gameDone;
    }

    public String[][] getBoard() {
        return this.board;
    }

    public boolean isSpaceFree(int x, int y) {
        if (this.board[y][x] == null) {
            return true;
        } else {
            return false;
        }
    }

    public void makeMove(int x, int y, String symbol) {
        if (this.isSpaceFree(x, y)) {
            this.board[y][x] = symbol;
        }
        this.checkWin(symbol);
        this.toString();             // Makes it easier instead of printing board everytime.
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void checkWin(String symbol) {
        // Loop to check columns and rows
        for (int i = 0; i < 3; i++) {
            
            // Check if win by rows
            if (this.board[i][0] == symbol && this.board[i][1] == symbol && this.board[i][2] == symbol) {
                this.gameDone = true;
                System.out.println("The game is won by \"" + symbol + "\"");
            // Check if won by columns
            } else if (this.board[0][i] == symbol && this.board[1][i] == symbol && this.board[2][i] == symbol) {
                this.gameDone = true;
                System.out.println("The game is won by \"" + symbol + "\"");
            }
        }
        // Diaganol Spots
        // Check if win by diagnol top left to bottom right
        if (this.board[0][0] == symbol && this.board[1][1] == symbol && this.board[2][2] == symbol) {
          this.gameDone = true;
          System.out.println("The game is won by \"" + symbol + "\"");
        // Check if win by diagnol bottom left to top right
        } else if (this.board[2][0] == symbol && this.board[1][1] == symbol && this.board[0][2] == symbol) {
          this.gameDone = true;
          System.out.println("The game is won by \"" + symbol + "\"");
        }
    }



    public String toString() {
        String string = "\r\n";
        int positionCount = 0;

        for (int i = 0; i < 3; i++) {
            string += "\t";                                   // tab to space it from side of console
            for (int j = 0; j < 3; j++) {

                if (this.board[i][j] != null) {
                    string += " " + this.board[i][j] + " "; 
                    string += (j < 2 ? "|" : "");                        // don't add column to end sides
                } else {
                    string += (j < 2 ? positionCount + "  |" : " ");     // add more spaces to format correctly
                }
            }
            if (i < 2) {
                string += "\n\t---+---+---\n";
            }
        }
        string += "\n\n";
        
        return string;
    }



}