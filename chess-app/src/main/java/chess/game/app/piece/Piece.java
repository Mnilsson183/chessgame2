package chess.game.app.piece;

import chess.game.app.util.Location;
import chess.game.app.board.*;

abstract public class Piece {
    public Location location;
    public Board board;
    public char side;
    public char pieceChar;

    public Piece(Location location, Board board, char side) {
        if(location == null) throw new IllegalArgumentException("location cannot be null");
        if(board == null) throw new IllegalArgumentException("board cannot be null");

        this.location = location;
        this.board = board;
        this.side = side;
    }

    abstract public Piece copyPiece();
    abstract public boolean isValidMove(int row, int column);

    public boolean isValidMove(Location location){
        if(location == null) return false;
        return isValidMove(location.getRow(), location.getColumn());
    }

    public boolean checkCandidate(int row, int column) {
        if (this.board.isOutOfBounds(row, column))
            return false;
        else if (!this.board.isTakeable(row, column, this.getSide()))
            return false;
        else
            return true;
    }

    public int getRow() {
        return this.location.getRow();
    }

    public int getColumn() {
        return this.location.getColumn();
    }

    public Location getLocation() {
        return new Location(this.location);
    }

    public char getSide() {
        return this.side;
    }

    public char getPieceChar() {
        return this.pieceChar;
    }
}
