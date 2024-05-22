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
            default:
                return 0;
        }
    }
}
