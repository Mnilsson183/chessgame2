package chess.game.app.board;

import chess.game.app.brains.Brain;
import chess.game.app.bookofmoves.Move;

public class Controller {
   
    private Brain brain1;
    private Brain brain2;
    private Board board;

    public Controller(Brain brain1, Brain brain2, Board board) {
        this.brain1 = brain1;
        this.brain2 = brain2;
        this.board = board;
    }

    public void startGame() {
        while (board.isGameOver() == false){
            Move move;
            brain1.updateBoard();
            do {
                System.out.println("Player 1's turn: ");
                move = brain1.getMove(board.generateBook());
            } while (board.executeMove(move) == false);
            brain2.updateBoard();
            do {
                System.out.println("Player 2's turn: ");
                move = brain2.getMove(board.generateBook());
            } while (board.executeMove(move) == false);
        }
    }
}
