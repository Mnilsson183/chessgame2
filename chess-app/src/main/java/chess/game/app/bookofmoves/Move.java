package chess.game.app.bookofmoves;

import chess.game.app.piece.Piece;
import chess.game.app.util.Location;
import chess.game.app.util.*;

/**
 * Move
 */
public class Move {
    private Piece orginPiece;
    private Piece takenPiece;
    private Location destinationLocation;

    public Move(Piece orginPiece, Piece takenPiece, Location destinationLocation) {
        this.orginPiece = orginPiece;
        this.takenPiece = takenPiece;
        this.destinationLocation = destinationLocation;
    }

    public Location getOrginLocation() {
        return new Location(orginPiece.getRow(), orginPiece.getColumn());
    }

    public Location getDestinationLocation() {
        return new Location(destinationLocation);
    }

    public Location getTakenLocation() {
        return new Location(takenPiece.getRow(), takenPiece.getColumn());
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
