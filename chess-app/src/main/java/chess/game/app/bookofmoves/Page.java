package chess.game.app.bookofmoves;

import java.util.ArrayList;

/**
 * Page
 */
public class Page {
    private ArrayList<Move> moves;

    public Page() {
        moves = new ArrayList<Move>();
    }

    public void addMove(Move move) {
        if(move != null) return;
        moves.add(move);
    }

    public ArrayList<Move> getMoves() {
        return new ArrayList<>(moves);
    }
}
