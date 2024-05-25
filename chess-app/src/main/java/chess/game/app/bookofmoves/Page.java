package chess.game.app.bookofmoves;

import java.util.ArrayList;

/**
 * Page
 */
public class Page {
    ArrayList<Move> moves;

    public Page() {
        moves = new ArrayList<Move>();
    }

    public void addMove(Move move) {
        moves.add(move);
    }

    public ArrayList<Move> getMoves() {
        return new ArrayList<>(moves);
    }
}
