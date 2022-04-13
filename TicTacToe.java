public class TicTacToe {

    public static void main(String[] args) {

        Board board = new Board();
        Player player = new Player("X", board);
        Computer cpu = new Computer("O", board);

        System.out.println(board);
        player.makeMove(new int[] {0, 2});
        player.makeMove(0, 0);
        player.makeMove(2, 2);

        System.out.println(board);

        cpu.makeMove();

        System.out.println(board);
    }

}
 