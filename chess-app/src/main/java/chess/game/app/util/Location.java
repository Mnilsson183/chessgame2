package chess.game.app.util;

import java.awt.Point;

/**
 * Location
 */
public class Location {
    private Point location;

    Location(Point point) {
        location = point;
    }

    Location(int r, int c) {
        location = new Point(r, c);
    }

    public int getRow() {
        return (int) location.getX();
    }

    public int getColumn() {
        return (int) location.getY();
    }
}
