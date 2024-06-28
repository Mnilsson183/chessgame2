package chess.game.app.brains;

import chess.game.app.board.Board;
import chess.game.app.bookofmoves.*;

public class Human extends Brain{
   public Human(Board board){
       super(board);
       this.name = "Human";
   }
   
    public Move getMove(Book book){
        System.out.println(this.board);
        return book.getMove(0);
    }
}
