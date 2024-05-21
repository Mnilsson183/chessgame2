package chess.game.app.piece;

import chess.game.app.board.Board;
import chess.game.app.util.Location;

/**
 * Rook
 */
public class Rook extends Piece {

    Rook(Location location, Board board, char side) {
        super(location, board, side);
    }

    public boolean isValidMove(int row, int column) {
        if (!checkCandidate(row, column))
            return false;
        int currentRow = this.location.getRow();
        int currentColumn = this.location.getColumn();
        if (isBlocked(row, column))
            return false;
        return (row == currentRow) ^ (column == currentColumn);
    }

    private boolean
}
