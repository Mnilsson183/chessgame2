package chess.game.app.bookofmoves;

import chess.game.app.piece.Piece;
import chess.game.app.util.Location;
import chess.game.app.util.*;

/**
 * Move
 */
public class Move {
    Piece destinationPiece;
    Piece orginPiece;

    public Location getOrgin() {
        return new Location(orginPiece.getRow(), orginPiece.getColumn());
    }

    public Location getDestination() {
        return new Location(destinationPiece.getRow(), destinationPiece.getColumn());
    }

    public char getOrginType() {
        return this.orginPiece.getPieceChar();
    }

    public char getDestinationType() {
        return this.destinationPiece.getPieceChar();
    }

    public int getOrginPieceValue() {
        return PieceUtils.getPieceValue(this.getOrginType());
    }

    public int getDestinationPieceValue() {
        return PieceUtils.getPieceValue(this.getDestinationType());
    }
}
