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
    public static char[][] defaultBoardPiecesMap = {
            { 'r', 'k', 'b', 'q', 'K', 'b', 'k', 'r' },
            { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { 'r', 'k', 'b', 'q', 'K', 'b', 'k', 'r' },
    };
    public static char[][] defaultBoardSidesMap = {
            { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w' },
            { 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' },
            { 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' },
    };

    public int boardRows;
    public int boardColumns;
    private Piece[][] board;

    public Board() {
        this.boardRows = defaultBoardRows;
        this.boardColumns = defaultBoardColumns;
        this.board = initBoardPiecesFromCharArray(defaultBoardPiecesMap, defaultBoardSidesMap);
    }

    public Board(char[][] boardPiecesMap, char[][] boardSidesMap) {
        assert boardPiecesMap.length == boardSidesMap.length;
        assert boardPiecesMap[0].length == boardSidesMap[0].length;
        this.boardRows = boardPiecesMap.length;
        this.boardColumns = boardPiecesMap[0].length;
        this.board = initBoardPiecesFromCharArray(boardPiecesMap, boardSidesMap);
    }


    public Board(Board b) {
        this.boardRows = b.boardRows;
        this.boardColumns = b.boardColumns;
        this.board = b.initBoardPiecesFromCharArray(b.getCharBoard(), b.getCharBoardSides());
    }
    
    public char[][] getCharBoard(){
        char[][] charBoard = new char[this.boardRows][this.boardColumns];
        for(int r = 0; r < this.boardRows; r++){
            for(int c = 0; c < this.boardColumns; c++){
                charBoard[r][c] = this.board[r][c].getPieceChar();
            }
        }
        return charBoard;
    }

    public char[][] getCharBoardSides(){
        char[][] charSideBoard = new char[this.boardRows][this.boardColumns];
        for(int r = 0; r < this.boardRows; r++){
            for(int c = 0; c < this.boardColumns; c++){
                charSideBoard[r][c] = this.board[r][c].getSide();
            }
        }
        return charSideBoard;
    }

    private Piece[][] initBoardPiecesFromCharArray(char[][] charBoard, char[][] charSideBoard){
        if (charBoard.length != this.boardRows || charBoard[0].length != this.boardColumns) {
            return null;
        } else if(charSideBoard.length != this.boardRows || charSideBoard[0].length != this.boardColumns){
            return null;
        }

        Piece[][] newBoard = new Piece[this.boardRows][this.boardColumns];
        for (int r = 0; r < this.boardRows; r++) {
            for (int c = 0; c < this.boardColumns; c++) {
                newBoard[r][c] = initBoardPiecesFromCharPiecesHelper(charBoard[r][c], new Location(r, c), charSideBoard[r][c]);
            }
        }
        return newBoard;
    }

    private Piece initBoardPiecesFromCharPiecesHelper(char c, Location location, char side){
        switch (c) {
            case 'p':
                return new Pawn(location, this, side);
            case 'k':
                return new Knight(location, this, side);
            case 'b':
                return new Bishop(location, this, side);
            case 'q':
                return new Queen(location, this, side);
            case ' ':
            default:
                return null;
        }
    }

    public Book generateBook() {
        Book book = new Book();
        for (int r = 0; r < this.boardRows; r++) {
            for (int c = 0; c < this.boardColumns; c++) {
                if (this.board[r][c] != null) {
                    book.addPage(generatePage(r, c));
                }
            }
        }
        return book;
    }

    // generate from a piece location
    private Page generatePage(int r, int c) {
        Page page = new Page();
        Piece piece = getPiece(boardRows, boardColumns);
        if(piece == null) return null;
        for (int row = 0; row < this.boardRows; row++) {
            for (int column = 0; column < this.boardColumns; column++) {
                if (piece.isValidMove(row, column)) {
                    page.addMove(
                        new Move(
                            piece,
                            this.getPiece(row, column),
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
                internalBoard[r][c] = this.board[r][c].copyPiece();
            }
        }
        return internalBoard;
    }

    public boolean locationIsEmpty(int row, int column) {
        if (board[row][column] == null)
            return false;
        else
            return true;
    }

    public boolean isTakeable(int row, int column, char orginSide) {
        return orginSide == getPiece(row, column).getSide();
    }

    public boolean isOutOfBounds(int row, int column) {
        return (row > this.boardRows || column > this.boardColumns);
    }

    public Piece getPiece(int row, int column) {
        return board[row][column];
    }

    public String toString() {
        String boardString = "";
        for (int r = 0; r < this.boardRows; r++) {
            for (int c = 0; c < this.boardColumns; c++) {
                if (this.board[r][c] == null) {
                    boardString += " ";
                } else {
                    boardString += this.board[r][c].getPieceChar();
                }
            }
            boardString += "\n";
        }
        return boardString;
    }
}
