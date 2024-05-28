package chess.game.app.piece;

import chess.game.app.board.Board;
import chess.game.app.util.Location;

/**
 * Queen
 */
public class Queen extends Piece {
    Queen(Location location, Board board, char side) {
        super(location, board, side);
        this.pieceChar = 'q';
    }

    public boolean isValidMove(int row, int column) {
        if (!checkCandidate(row, column))
            return false;
        if (!isNotBlocked(row, column))
            return false;

    }
    public Piece copyPiece(){
        return new Queen(
            this.getLocation(),
            this.board,
            this.side
        );
    }
}
