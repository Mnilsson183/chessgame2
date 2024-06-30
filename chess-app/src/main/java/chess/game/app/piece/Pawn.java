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
            
        return false;
    }

    public Piece copyPiece(){
        return new Pawn(
            this.getLocation(),
            this.board,
            this.side
        );
    }
}
