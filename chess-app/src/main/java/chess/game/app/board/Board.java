package chess.game.app.board;

import chess.game.app.piece.*;
import chess.game.app.bookofmoves.*;
import chess.game.app.util.*;

/**
 * Board
 */
public class Board {
    public static int defaultBoardRows = 8;
    public static int defaultBoardColumns = 8;
    public static char[][] defaultBoard = {
            { 'r', 'k', 'b', 'q', 'K', 'b', 'k', 'r' },
            { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { 'r', 'k', 'b', 'q', 'K', 'b', 'k', 'r' },
    };

    public int boardRows;
    public int boardColumns;
    private Piece[][] board;

    Board() {
        Piece[][] newBoard = new Piece[defaultBoardRows][defaultBoardColumns];
        this.boardRows = defaultBoardRows;
        this.boardColumns = defaultBoardColumns;
        for (char[] row : defaultBoard) {
            for (char c : row) {
                switch (c) {
                    case value:
                        break;

                    default:
                        break;
                }
            }
        }
    }

    Board(Board b) {

    }


    // generate from a piece location
    private Page generatePage(int r, int c) {
        Page page = new Page();
        Piece piece = getBoardPiece(boardRows, boardColumns);
        if(piece == null) return null;
        for (int row = 0; row < this.boardRows; row++) {
            for (int column = 0; column < this.boardColumns; column++) {
                if (piece.isValidMove(row, column)) {
                    page.addMove(
                        new Move(
                            piece,
                            this.getBoardPiece(row, column),
                            new Location(row, column)));
                }
            }
        }
        return page;
    }

    public Piece[][] initBrain(){
        Piece[][] internalBoard = new Piece[this.boardRows][this.boardColumns];
        for(int r = 0; r < this.boardRows; r++){
            for(int c = 0; c < this.boardColumns; c++){
                internalBoard[r][c] = new Piece(this.board[r][c]);
            }
        }
    }

    public boolean locationIsEmpty(int row, int column) {
        if (board[row][column] == null)
            return false;
        else
            return true;
    }

    public boolean isTakeable(int row, int column, char orginSide) {
        return orginSide == getBoardPiece(row, column).getSide();
    }

    public boolean isOutOfBounds(int row, int column) {
        return (row > this.boardRows || column > this.boardColumns);
    }

    public Piece getBoardPiece(int row, int column) {
        return board[row][column];
    }
}
