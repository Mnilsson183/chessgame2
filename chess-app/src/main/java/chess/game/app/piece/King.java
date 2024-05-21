package chess.game.app.piece;

import chess.game.app.board.Board;
import chess.game.app.util.Location;

/**
 * King
 */
public class King extends Piece {
    King(Location location, Board board, char side) {
        super(location, board, side);
    }

    // still ne to impl moving into check
    public boolean isValidMove(int row, int column) {
        int currentRow = this.location.getRow();
        int currentColumn = this.location.getColumn();

        int rowDifference = Math.abs(row - currentRow);
        int columnDifference = Math.abs(column - currentColumn);

        if (rowDifference + columnDifference == 1)
            return true;
        else if (rowDifference + columnDifference == 2 && rowDifference == 1)
            return true;
        else
            return false;
    }
}
