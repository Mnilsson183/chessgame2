package chess.game.app.util;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PieceUtilsTest {

    @Test
    public void getPieceValueTest(){
        assertTrue(PieceUtils.getPieceValue('p') == 1);
        assertTrue(PieceUtils.getPieceValue('r') == 5);
        assertTrue(PieceUtils.getPieceValue('k') == 3);
        assertTrue(PieceUtils.getPieceValue('b') == 3);
        assertTrue(PieceUtils.getPieceValue('q') == 9);
        assertTrue(PieceUtils.getPieceValue('K') == -1);
        assertTrue(PieceUtils.getPieceValue('l') == -1);
        assertTrue(PieceUtils.getPieceValue('t') == -1);
    }
}
