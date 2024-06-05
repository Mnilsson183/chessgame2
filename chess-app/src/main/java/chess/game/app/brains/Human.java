package chess.game.app.brains;

import chess.game.app.board.Board;
import chess.game.app.bookofmoves.*;

public class Human extends Brain{
   public Human(Board board){
       super(board);
   }
   
    public Move getMove(Book book){
         return book.getMove(0);
    }
}
