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
        if(move == null) return;
        moves.add(move);
    }

    public ArrayList<Move> getMoves() {
        return new ArrayList<>(moves);
    }

    public String toString(){
        if(moves.size() == 0) return "No moves in page";
        StringBuilder sb = new StringBuilder();
        sb.append("Page:\n");
        for (Move move : moves) {
            sb.append(move.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
