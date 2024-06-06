package chess.game.app.brains;

import chess.game.app.board.Board;
import chess.game.app.bookofmoves.*;

public abstract class Brain {
    String name;
    char[][] internalBoard;
    char[][] internalBoardSides;
    Board board;

    public Brain(Board board){
        this.board = board;
        this.internalBoard = board.getCharBoard();
        this.internalBoardSides = board.getCharBoardSides();
    }

    public void updateBoard(){
        this.internalBoard = board.getCharBoard();
        this.internalBoardSides = board.getCharBoardSides();
    }

    abstract public Move getMove(Book book);
}
