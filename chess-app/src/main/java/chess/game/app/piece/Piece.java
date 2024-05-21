package chess.game.app.piece;

import chess.game.app.util.Location;
import chess.game.app.board.*;

abstract public class Piece {
    public Location location;
    public Board board;
    public char side;

    public Piece(Location location, Board board, char side) {
        this.location = location;
        this.board = board;
        this.side = side;
    }

    abstract public boolean isValidMove(int row, int column);

    abstract public boolean isBlocked(int row, int column);

    public Page generatePage() {
        Page page = new Page();
        for (int row : board.boardRows) {
            for (int column : board.boardColumns) {
                if (isValidMove(row, column))
                    page.addMove(row, column);
            }
        }
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

    public char getSide() {
        return this.side;
    }
}
