package model.arena.entities;

/**
 * This class is used to localize the entities in the Arena.
 * 
 * @author josephgiovanelli
 *
 */
public class Point {

    private final int x;
    private final int y;

    /**
     * The constructor specified the final fields.
     * 
     * @param x
     *            : the horizontal coordinate.
     * @param y
     *            : the vertical coordinate.
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the horizontal coordinate.
     * 
     * @return : the horizontal coordinate.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the vertical coordinate.
     * 
     * @return : the vertical coordinate.
     */
    public int getY() {
        return this.y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

}
