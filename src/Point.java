
public class Point {

    private int x;
    private int y;

    /**
     * Construct a point given x and y coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }

    /**
     * @return the x coordinate
     */
    public int getX() {
        return this.x;
    }

    /**
     * @return the y coordinate
     */
    public int getY() {
        return this.y;
    }

    /**
     * @return the x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
}