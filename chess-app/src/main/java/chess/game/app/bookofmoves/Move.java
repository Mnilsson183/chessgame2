package chess.game.app.bookofmoves;

import chess.game.app.piece.Piece;
import chess.game.app.util.Location;
import chess.game.app.util.*;

/**
 * Move
 */
public class Move {
    private Piece orginPiece;
    // may be null
    private Piece takenPiece;
    private Location destinationLocation;

    public Move(Piece orginPiece, Piece takenPiece, Location destinationLocation) {
        if(orginPiece == null)
            throw new IllegalArgumentException("orginPiece cannot be null");
        if(destinationLocation == null)
            throw new IllegalArgumentException("destinationLocation cannot be null");

        this.orginPiece = orginPiece;
        this.takenPiece = takenPiece;
        this.destinationLocation = destinationLocation;
    }

    public Move(Move move) {
        if(move == null)
            throw new IllegalArgumentException("move cannot be null");

        this.orginPiece = move.orginPiece.copyPiece();
        this.takenPiece = move.takenPiece.copyPiece();
        this.destinationLocation = new Location(move.destinationLocation);
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

    public boolean equals(Move move) {
        if(move == null)
            return false;
            
        return this.getOrginLocation().equals(move.getOrginLocation())
                && this.getDestinationLocation().equals(move.getDestinationLocation())
                && this.getTakenLocation().equals(move.getTakenLocation());
    }

    public String toString(){
        if(this.takenPiece == null)
            return "Orgin: " + this.orginPiece.toString() + " Destination: " + this.destinationLocation.toString();
        else
            return "Orgin: " + this.orginPiece.toString() + " Destination: " + this.takenPiece.toString() + " Taken: " + this.getTakenLocation();
    }
}
