package chess.game.app.piece;

import chess.game.app.board.Board;
import chess.game.app.util.Location;

/**
 * Queen
 */
public class Queen extends Piece {
    public Queen(Location location, Board board, char side) {
        super(location, board, side);
        this.pieceChar = 'q';
    }

    public boolean isValidMove(int row, int column) {
        if (!checkCandidate(row, column))
            return false;
        if (!isNotBlocked(row, column))
            return false;
        if (this.location.getRow() == row ^ this.location.getColumn() == column) {
            return true;
        } else if (Math.abs(this.location.getRow() - row) == Math.abs(this.location.getColumn() - column)) {
            return true;
        } else {
            return false;
        }

    }

    private boolean isNotBlocked(int row, int column){
        int rowDiff = this.location.getRow() - row;
        int colDiff = this.location.getColumn() - column;

        if (this.location.getRow() == row) {
            int start = Math.min(this.location.getColumn(), column);
            int end = Math.max(this.location.getColumn(), column);
            for (int i = start + 1; i < end; i++) {
                if (board.locationIsEmpty(i, column)) {
                    return false;
                }
            }
        } else if (this.location.getColumn() == column) {
            int start = Math.min(this.location.getRow(), row);
            int end = Math.max(this.location.getRow(), row);
            for (int i = start + 1; i < end; i++) {
                if (board.locationIsEmpty(i, column)) {
                    return false;
                }
            }
        } else if (Math.abs(rowDiff) == Math.abs(colDiff)) {
            int startRow = Math.min(this.location.getRow(), row);
            int startCol = Math.min(this.location.getColumn(), column);
            int endRow = Math.max(this.location.getRow(), row);
            int r = startRow;
            int c = startCol;
            while (r < endRow) {
                r++;
                c++;
                if (board.locationIsEmpty(r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Piece copyPiece(){
        return new Queen(
            this.getLocation(),
            this.board,
            this.side
        );
    }
}
