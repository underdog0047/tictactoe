public class Computer {

    private String symbol;
    private Board gameBoard;

    public Computer(String symbol, Board gameBoard) {
        this.symbol = symbol;
        this.gameBoard = gameBoard;
    }


    public void makeMove() {
        this.checkCorners();  // check corners first
        this.checkCross();
    }

    /**
     * Checks the cross section of the table to see if they are available
     */
    private void checkCross() {
        // Check top middle side
        if (this.gameBoard.isSpaceFree(1, 0)) {
            this.gameBoard.makeMove(1, 0, symbol);

        // Check middle let side
        } else if (this.gameBoard.isSpaceFree(0, 1)) {
            this.gameBoard.makeMove(0, 1, symbol);

        // Check middle right side 
        } else if (this.gameBoard.isSpaceFree(2, 1)) {
            this.gameBoard.makeMove(2, 1, symbol);

        // Check bottom middle side
        } else if (this.gameBoard.isSpaceFree(1, 2)) {
            this.gameBoard.makeMove(1, 2, symbol);

        // Check the center position
        } else if (this.gameBoard.isSpaceFree(1, 1)) {
            this.gameBoard.makeMove(1, 1, symbol);
        }

    }

    /**
     * Checks all the corner spots to see if they are available, if so
     * moves the computer to the first open corner. 
     */
    private void checkCorners() {
        int[] corners = {0, 2};

        // Check corners first
        for (int i = 0; i < corners.length; i++) {
            
            // Checks 0,0  and 2,2  ;  top left corner and bottom right corner
            if (this.gameBoard.isSpaceFree(corners[i], corners[i])) {
                this.gameBoard.makeMove(corners[i], corners[i], symbol);
                break;
            } else {

                // Checks top right corner and bottom left corner
                try {
                    if (this.gameBoard.isSpaceFree(corners[i], corners[i+1])) {
                        this.gameBoard.makeMove(corners[i], corners[i+1], symbol);
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    if (this.gameBoard.isSpaceFree(corners[i], corners[i-1])) {
                        this.gameBoard.makeMove(corners[i], corners[i-1], symbol);
                        break;
                    }
                }
            }

            //if (this.gameBoard.isSpaceFree(0, 0)) {
            //    this.gameBoard.makeMove(0, 0, this.symbol);

            //} else if (this.gameBoard.isSpaceFree(0, 2)) {
            //    this.gameBoard.makeMove(0, 2, this.symbol);

            //} else if (this.gameBoard.isSpaceFree(2, 0)) {
            //    this.gameBoard.makeMove(2, 0, this.symbol);

            //} else if (this.gameBoard.isSpaceFree(2, 2)) {
            //    this.gameBoard.makeMove(2, 2, this.symbol);
            //}
        }
    }
    
}
