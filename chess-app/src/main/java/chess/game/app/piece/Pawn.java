package chess.game.app.piece;

import chess.game.app.util.Location;
import chess.game.app.board.*;

/**
 * Pawn
 */
public class Pawn extends Piece {

    Pawn(Location location, Board board, char side) {
        this.location = location;
        this.board = board;
        this.side = side;

    }

    public boolean isValidMove(int r, int c) {

    }

}
