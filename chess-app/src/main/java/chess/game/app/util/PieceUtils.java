package chess.game.app.util;

/**
 * PieceUtils
 */
public class PieceUtils {

    public static int getPieceValue(char c) {
        switch (c) {
            case 'p':
                return 1;
            case 'r':
                return 5;
            case 'k':
                return 3;
            case 'b':
                return 3;
            case 'q':
                return 9;
            case 'K':
            default:
                return -1;
        }
    }

    public static String getPieceName(char c) {
        switch (c) {
            case 'p':
                return "Pawn";
            case 'r':
                return "Rook";
            case 'k':
                return "Knight";
            case 'b':
                return "Bishop";
            case 'q':
                return "Queen";
            case 'K':
                return "King";
            case ' ':
                return "Empty";
            default:
                return "Unknown";
        }
    }
}
