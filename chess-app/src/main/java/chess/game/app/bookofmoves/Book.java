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
        moves.addAll(page.getMoves());
    }

    public Move getMove(int i) {
        return this.moves.get(i);
    }

    public ArrayList<Move> getMoves() {
        return new ArrayList<Move>(this.moves);
    }
}
