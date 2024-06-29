package chess.game.app.bookofmoves;

import chess.game.app.board.Board;
import chess.game.app.piece.Pawn;
import chess.game.app.piece.Piece;
import chess.game.app.util.Location;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MoveTest {
    @Test
    public void testGetLocation() {
        Location loc1 = new Location(0, 0);
        Board board = new Board();
        Piece piece1 = new Pawn(loc1, board, 'w');

        Location loc2 = new Location(0, 0);
        Piece piece2 = new Pawn(loc2, board, 'w');

        Move move1 = new Move(piece1, piece2, loc2);
        assertTrue(move1.getOrginLocation().equals(loc1));
        assertTrue(move1.getDestinationLocation().equals(loc2));
        assertTrue(move1.getTakenLocation().equals(loc2));
    }

    @Test
    public void testEquals(){
        Location loc1 = new Location(0, 0);
        Board board = new Board();
        Piece piece1 = new Pawn(loc1, board, 'w');

        Location loc2 = new Location(0, 0);
        Piece piece2 = new Pawn(loc2, board, 'w');

        Move move1 = new Move(piece1, piece2, loc2);
        Move move2 = new Move(piece1, piece2, loc2);
        assertTrue(move1.equals(move2));
    }
}
