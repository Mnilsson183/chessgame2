package chess.game.app.piece;

import chess.game.app.board.Board;
import chess.game.app.util.Location;

/**
 * Bishop
 */
public class Bishop extends Piece {

    Bishop(Location location, Board board, char side) {
        super(location, board, side);
    }

    public boolean isValidMove(int row, int column) {
        if (!checkCandidate(row, column))
            return false;
        if (!isNotBlocked(row, column))
            return false;
        int currentRow = this.location.getRow();
        int currentColumn = this.location.getColumn();
        int differenceRow = row - currentRow;
        int differenceColumn = column - currentColumn;
        return differenceRow == differenceColumn;
    }

    private boolean isNotBlocked(int row, int column) {
        int currentRow = this.location.getRow();
        int currentColumn = this.location.getColumn();
        int differenceRow = row - currentRow;
        int differenceColumn = column - currentColumn;
        int rowCoe = differenceRow > 0 ? 1 : -1;
        int columnCoe = differenceColumn > 0 ? 1 : -1;
        int column_i = currentColumn;
        for (int row_i = currentRow; row_i != row; row_i += rowCoe, column_i += columnCoe)
            if (this.board.locationIsEmpty(row_i, column_i))
                return false;
        return false;
    }
}
