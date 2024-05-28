package chess.game.app.brains;

import chess.game.app.board.Board;
import chess.game.app.piece.Piece;
import chess.game.app.bookofmoves.*;

public abstract class Brain {
    Piece[][] internalBoard;
    Board board;

    public Brain(Board board){
        this.board = board;
        this.internalBoard = board.initBrain();
    }

    abstract public Move getMove(Book book);
}
