package chess.game.app.bookofmoves;

import chess.game.app.piece.Piece;
import chess.game.app.util.Location;
import chess.game.app.util.*;

/**
 * Move
 */
public class Move {
    Piece orginPiece;
    Piece takenPiece;
    Location destinationLocation;

    public Move(Piece orginPiece, Piece takenPiece, Location destinationLocation) {
        this.orginPiece = orginPiece;
        this.takenPiece = takenPiece;
        this.destinationLocation = destinationLocation;
    }

    public Location getOrgin() {
        return new Location(orginPiece.getRow(), orginPiece.getColumn());
    }

    public Location getDestination() {
        return new Location(destinationLocation);
    }

    public char getOrginType() {
        return this.orginPiece.getPieceChar();
    }

    public char getDestinationType() {
        if (destinationLocation.equals(takenPiece.getLocation())) {
            return takenPiece.getPieceChar();
        } else
            return '0';
    }

    public char getTakenPieceType() {
        return this.takenPiece.getPieceChar();
    }

    public int getTakenPieceValue() {
        return PieceUtils.getPieceValue(takenPiece.getPieceChar());
    }

    public int getOrginPieceValue() {
        return PieceUtils.getPieceValue(this.getOrginType());
    }

    public int getDestinationPieceValue() {
        return PieceUtils.getPieceValue(this.getDestinationType());
    }
}
