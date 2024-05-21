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
}
