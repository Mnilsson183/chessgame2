package chess.game.app.bookofmoves;

import java.util.ArrayList;

/**
 * Book
 */
public class Book {
    private ArrayList<Move> moves;

    public Book() {
        this.moves = new ArrayList<Move>();
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }

    public void addPage(Page page) {
        if(page == null) return;
        moves.addAll(page.getMoves());
    }

    public Move getMove(int i) {
        if(i >= this.moves.size()) return null;
        return this.moves.get(i);
    }

    public ArrayList<Move> getMoves() {
        return new ArrayList<Move>(this.moves);
    }
}
