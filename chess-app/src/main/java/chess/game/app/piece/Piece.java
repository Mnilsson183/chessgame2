package chess.game.app.piece;

import chess.game.app.util.Location;
import chess.game.app.board.*;
import chess.game.app.bookofmoves.Move;
import chess.game.app.bookofmoves.Page;

abstract public class Piece {
    private Location location;
    private Board board;
    private char side;
    private char pieceChar;

    public Piece(Location location, Board board, char side) {
        this.location = location;
        this.board = board;
        this.side = side;
    }

    abstract public boolean isValidMove(int row, int column);

    public Page generatePage() {
        Page page = new Page();
        for (int row = 0; row < board.boardRows; row++) {
            for (int column = 0; column < board.boardColumns; column++) {
                if (isValidMove(row, column)) {
                    page.addMove(
                            new Move(
                                    this,
                                    this.board.getBoardPiece(row, column),
                                    new Location(row, column)));
                }
            }
        }
        return page;
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
