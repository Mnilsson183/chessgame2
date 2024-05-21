package chess.game.app.piece;

import chess.game.app.util.Location;
import chess.game.app.board.*;

/**
 * Pawn
 */
public class Pawn extends Piece {

    Pawn(Location location, Board board, char side) {
        super(location, board, side);
    }

    public boolean isValidMove(int r, int c) {
        int currentRow = this.location.getRow();
        int currentColumn = this.location.getColumn();
    }

}
