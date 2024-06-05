package chess.game.app;

import chess.game.app.board.Board;
import chess.game.app.board.Controller;
import chess.game.app.brains.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Board board = new Board();
        Controller controller = new Controller(new Human(board), new Human(board), board);
        controller.startGame();
    }
}
