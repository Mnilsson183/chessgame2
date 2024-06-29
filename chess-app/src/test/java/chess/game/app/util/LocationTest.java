package chess.game.app.util;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.awt.Point;

public class LocationTest {
    @Test
    public void testLocation() {
        Location loc = new Location(1, 2);
        assertTrue(loc.getRow() == 1);
        assertTrue(loc.getColumn() == 2);

        Location loc2 = new Location(loc);
        assertTrue(loc2.getRow() == 1);
        assertTrue(loc2.getColumn() == 2);

        Location loc3 = new Location(new Point(2,3));
        assertTrue(loc3.getRow() == 2);
        assertTrue(loc3.getColumn() == 3);

        Location loc4 = null;
        Location loc5 = null;
        try {
            loc5 = new Location(loc4);
            assertTrue(loc5.getRow() == 0);
            assertTrue(loc5.getColumn() == 0);
        } catch (IllegalArgumentException e) {
            assertTrue(loc4 == null);
            assertTrue(loc5 == null);
        }

        Point point = null;
        Location loc6 = null;
        try{
            loc6 = new Location(point);
        } catch(IllegalArgumentException e) {
            assertTrue(point == null);
            assertTrue(loc6 == null);
        }

    }

    @Test
    public void testEquals() {
        Location loc = new Location(1, 2);
        Location loc2 = new Location(1, 2);
        assertTrue(loc.equals(loc2));

        Location loc3 = new Location(2, 3);
        assertTrue(!loc.equals(loc3));
    }    
}
