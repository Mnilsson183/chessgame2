package chess.game.app.piece;

import chess.game.app.board.Board;
import chess.game.app.util.Location;

/**
 * Rook
 */
public class Rook extends Piece {

    public Rook(Location location, Board board, char side) {
        super(location, board, side);
        this.pieceChar = 'r';
    }

    public boolean isValidMove(int row, int column) {
        if (!checkCandidate(row, column))
            return false;
        if (!isNotBlocked(row, column))
            return false;
        int currentRow = this.location.getRow();
        int currentColumn = this.location.getColumn();
        return (row == currentRow) ^ (column == currentColumn);
    }

    private boolean isNotBlocked(int row, int column) {
        int currentRow = this.location.getRow();
        int currentColumn = this.location.getColumn();
        if (currentRow != row) {
            for (int i = currentRow; i != row; i += currentRow > row ? -1 : 1)
                if (!this.board.locationIsEmpty(i, column))
                    return false;
        } else if (currentColumn == column) {
            for (int i = currentColumn; i != column; i += currentColumn > column ? -1 : 1)
                if (!this.board.locationIsEmpty(row, i))
                    return false;
        }
        return true;
    }
    public Piece copyPiece(){
        return new Rook(
            this.getLocation(),
            this.board,
            this.side
        );
    }
}
