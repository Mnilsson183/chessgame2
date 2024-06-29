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
        if(boardPiecesMap == null) throw new IllegalArgumentException("boardPiecesMap cannot be null");
        if(boardSidesMap == null) throw new IllegalArgumentException("boardSidesMap cannot be null");

        assert boardPiecesMap.length == boardSidesMap.length;
        assert boardPiecesMap[0].length == boardSidesMap[0].length;
        this.boardRows = boardPiecesMap.length;
        this.boardColumns = boardPiecesMap[0].length;
        this.board = initBoardPiecesFromCharArray(boardPiecesMap, boardSidesMap);
    }


    public Board(Board b) {
        if(b == null) throw new IllegalArgumentException("b cannot be null");

        this.boardRows = b.boardRows;
        this.boardColumns = b.boardColumns;
        this.board = b.initBoardPiecesFromCharArray(b.getCharBoard(), b.getCharBoardSides());
    }

    public boolean isGameOver(){
        return false;
    }
    
    public char[][] getCharBoard(){
        char[][] charBoard = new char[this.boardRows][this.boardColumns];
        for(int r = 0; r < this.boardRows; r++){
            for(int c = 0; c < this.boardColumns; c++){
                if(this.board[r][c] == null){
                    charBoard[r][c] = ' ';
                } else {
                    charBoard[r][c] = this.board[r][c].getPieceChar();
                }
            }
        }
        return charBoard;
    }

    public char[][] getCharBoardSides(){
        char[][] charSideBoard = new char[this.boardRows][this.boardColumns];
        for(int r = 0; r < this.boardRows; r++){
            for(int c = 0; c < this.boardColumns; c++){
                if(this.board[r][c] == null){
                    charSideBoard[r][c] = ' ';
                }else{
                    charSideBoard[r][c] = this.board[r][c].getSide();
                }
            }
        }
        return charSideBoard;
    }

    private Piece[][] initBoardPiecesFromCharArray(char[][] charBoard, char[][] charSideBoard){
        if(charBoard == null) throw new IllegalArgumentException("charBoard cannot be null");
        if(charSideBoard == null) throw new IllegalArgumentException("charSideBoard cannot be null");

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
        if(location == null) throw new IllegalArgumentException("location cannot be null");

        switch (c) {
            case 'p':
                return new Pawn(location, this, side);
            case 'k':
                return new Knight(location, this, side);
            case 'b':
                return new Bishop(location, this, side);
            case 'q':
                return new Queen(location, this, side);
            case 'r':
                return new Rook(location, this, side);
            case 'K':
                return new King(location, this, side);
            case ' ':
            default:
                return null;
        }
    }

    public boolean executeMove(Move move) {
        if(move == null) throw new IllegalArgumentException("move cannot be null");

        if(!validateMove(move)) return false;
        return movePiece(move);
    }

    private boolean movePiece(Move move){
        if(move == null) throw new IllegalArgumentException("move cannot be null");

        Piece orginPiece = this.getPiece(move.getOrginLocation());
        Location destinationLocation = move.getDestinationLocation();
        Location takenLocation = move.getTakenLocation();

        this.board[takenLocation.getRow()][takenLocation.getColumn()] = null;
        this.board[destinationLocation.getRow()][destinationLocation.getColumn()] = orginPiece;
        this.board[orginPiece.getRow()][orginPiece.getColumn()] = null;
        return true;
    }

    private boolean validateMove(Move move){
        if(move == null) throw new IllegalArgumentException("move cannot be null");

        Piece orginPiece = this.getPiece(move.getOrginLocation());
        return orginPiece.isValidMove(move.getDestinationLocation());
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
    // TODO this doesnt seem to be right these params are unused

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
        if(this.isOutOfBounds(row, column)) return false;
        if (board[row][column] == null)
            return false;
        else
            return true;
    }

    public boolean isTakeable(int row, int column, char orginSide) {
        if(isOutOfBounds(row, column)) return false;
        return orginSide == getPiece(row, column).getSide();
    }

    public boolean isOutOfBounds(int row, int column) {
        return (row >= this.boardRows || column >= this.boardColumns || row < 0 || column < 0);
    }

    private Piece getPiece(int row, int column) {
        if(this.isOutOfBounds(row, column)) return null;
        return board[row][column];
    }

    private Piece getPiece(Location location) {
        return getPiece(location.getRow(), location.getColumn());
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
