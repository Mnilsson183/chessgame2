package chess.game.app.util;

import java.awt.Point;

/**
 * Location
 */
public class Location {
    private Point location;

    public Location(Point point) {
        this.location = point;
    }

    public Location(int r, int c) {
        this.location = new Point(r, c);
    }

    public Location(Location location) {
        this.location = new Point(location.getRow(), location.getColumn());
    }

    public int getRow() {
        return (int) location.getX();
    }

    public int getColumn() {
        return (int) location.getY();
    }
}
