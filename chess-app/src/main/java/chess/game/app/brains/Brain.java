package chess.game.app.brains;

import chess.game.app.board.Board;
import chess.game.app.bookofmoves.*;

public abstract class Brain {
    private String name;
    protected char[][] internalBoard;
    protected char[][] internalBoardSides;
    private Board board;

    public Brain(Board board){
        if(board == null) throw new IllegalArgumentException("board cannot be null");

        this.board = board;
        this.internalBoard = board.getCharBoard();
        this.internalBoardSides = board.getCharBoardSides();
    }

    public void updateBoard(){
        this.internalBoard = board.getCharBoard();
        this.internalBoardSides = board.getCharBoardSides();
    }

    abstract public Move getMove(Book book);

    protected void setName(String name){
        if(name == null) throw new IllegalArgumentException("name cannot be null");
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    protected Brain getBrain(){
        return this;
    }
}
