package chess.game.app.piece;

import chess.game.app.board.Board;
import chess.game.app.util.Location;

/**
 * Knight
 */
public class Knight extends Piece {

    Knight(Location location, Board board, char side) {
        super(location, board, side);
        this.pieceChar = 'k';
    }

    public boolean isValidMove(int r, int c){

    }


    public Piece copyPiece(){
        return new Knight(
            this.getLocation(),
            this.board,
            this.side
        );
    }
}
