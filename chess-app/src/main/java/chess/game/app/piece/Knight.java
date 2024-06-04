package chess.game.app.piece;

import chess.game.app.board.Board;
import chess.game.app.util.Location;

/**
 * Knight
 */
public class Knight extends Piece {

    public Knight(Location location, Board board, char side) {
        super(location, board, side);
        this.pieceChar = 'k';
    }

    public boolean isValidMove(int r, int c){
        int rowDiff = this.location.getRow() - r;
        int colDiff = this.location.getColumn() - c;

        if (Math.abs(rowDiff) == 2 && Math.abs(colDiff) == 1) {
            return true;
        } else if (Math.abs(rowDiff) == 1 && Math.abs(colDiff) == 2) {
            return true;
        } else {
            return false;
        }
    }


    public Piece copyPiece(){
        return new Knight(
            this.getLocation(),
            this.board,
            this.side
        );
    }
}
