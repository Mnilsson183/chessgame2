package chess.game.app.board;

import chess.game.app.brains.Brain;

public class Controller {
   
    Brain brain1;
    Brain brain2;
    Board board;

    public Controller(Brain brain1, Brain brain2, Board board) {
        this.brain1 = brain1;
        this.brain2 = brain2;
        this.board = board;
    }

    public void startGame() {
        while (true) {
            brain1.updateBoard();
            brain1.getMove(board.generateBook());
            brain2.updateBoard();
            brain2.getMove(board.generateBook());
        }
    }
}
