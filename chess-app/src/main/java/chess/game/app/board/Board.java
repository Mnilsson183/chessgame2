package chess.game.app.board;

import chess.game.app.piece.*;

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
