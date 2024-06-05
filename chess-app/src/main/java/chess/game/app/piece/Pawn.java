package chess.game.app.piece;

import chess.game.app.util.Location;
import chess.game.app.board.*;

/**
 * Pawn
 */
public class Pawn extends Piece {

    public Pawn(Location location, Board board, char side) {
        super(location, board, side);
        this.pieceChar = 'p';
    }

    public boolean isValidMove(int r, int c) {
        // check if the final location is full
        if(this.board.locationIsEmpty(r, c)){
            return false;
        }

        if (this.side == 'w') {
            if (this.location.getRow() == 6) {
                if (r == this.location.getRow() - 1 || r == this.location.getRow() - 2) {
                    if (c == this.location.getColumn()) {
                        if (r == this.location.getRow() - 2) {
                            if (this.board.getPiece(this.location.getRow() - 1, this.location.getColumn()) != null) {
                                return false;
                            }
                        }
                        if (this.board.getPiece(r, c) == null) {
                            return true;
                        }
                    }
                }
            } else {
                if (r == this.location.getRow() - 1) {
                    if (c == this.location.getColumn()) {
                        if (this.board.getPiece(r, c) == null) {
                            return true;
                        }
                    }
                }
            }
            if (r == this.location.getRow() - 1) {
                if (c == this.location.getColumn() - 1 || c == this.location.getColumn() + 1) {
                    if (this.board.getPiece(r, c) != null) {
                        if (this.board.getPiece(r, c).getSide() != this.side) {
                            return true;
                        }
                    }
                }
            }
        } else {
            if (this.location.getRow() == 1) {
                if (r == this.location.getRow() + 1 || r == this.location.getRow() + 2) {
                    if (c == this.location.getColumn()) {
                        if (r == this.location.getRow() + 2) {
                            if (this.board.getPiece(this.location.getRow() + 1, this.location.getColumn()) != null) {
                                return false;
                            }
                        }
                        if (this.board.getPiece(r, c) == null) {
                            return true;
                        }
                    }
                }
            } else {
                if (r == this.location.getRow() + 1) {
                    if (c == this.location.getColumn()) {
                        if (this.board.getPiece(r, c) == null) {
                            return true;
                        }
                    }
                }
            }
            if (r == this.location.getRow() + 1) {
                if (c == this.location.getColumn() - 1 || c == this.location.getColumn() + 1) {
                    

    }

    public Piece copyPiece(){
        return new Pawn(
            this.getLocation(),
            this.board,
            this.side
        );
    }
}
