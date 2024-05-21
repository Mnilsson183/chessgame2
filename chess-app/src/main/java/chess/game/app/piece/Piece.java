package chess.game.app.piece;

import chess.game.app.util.Location;
import chess.game.app.board.*;

abstract public class Piece {
    public Location location;
    public Board board;
    public char side;

    abstract public boolean isValidMove(int row, int c);
}
