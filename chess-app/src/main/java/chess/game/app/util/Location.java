package chess.game.app.util;

import java.awt.Point;

/**
 * Location
 */
public class Location {
    private Point location;

    public Location(Point point) {
        if (point == null) throw new IllegalArgumentException("point cannot be null");
        if(point.getX() < 0 || point.getY() < 0) throw new IllegalArgumentException("point cannot have negative values");
        this.location = point;
    }

    public Location(int r, int c) {
        if(r < 0 || c < 0) throw new IllegalArgumentException("r and c cannot have negative values");
        this.location = new Point(r, c);
    }

    public Location(Location location) {
        if(location == null) throw new IllegalArgumentException("location cannot be null");
        if(location.getRow() < 0 || location.getColumn() < 0) throw new IllegalArgumentException("location cannot have negative values");
        this.location = new Point(location.getRow(), location.getColumn());
    }

    public int getRow() {
        return (int) location.getX();
    }

    public int getColumn() {
        return (int) location.getY();
    }

    public boolean equals(Location otherLocation) {
        if(otherLocation == null) return false;
        return this.getRow() == otherLocation.getRow() && this.getColumn() == otherLocation.getColumn();
    }
}
