package chess.game.app.brains;

import chess.game.app.board.Board;
import chess.game.app.bookofmoves.*;

public class Human extends Brain{
   public Human(Board board){
    super(board);
    this.setName("Human");
   }
   
    public Move getMove(Book book){
        if(book == null) throw new IllegalArgumentException("book cannot be null");

        System.out.println(this.getBrain());
        return book.getMove(0);
    }
}
