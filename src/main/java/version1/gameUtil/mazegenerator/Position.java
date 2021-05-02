package version1.gameUtil.mazegenerator;

/**
 * This class represent a position ona an X,Y coordinates plane
 */
public class Position {

    // X coordinate
    private int x;

    // Y coordiante
    private int y;

    /**
     * By default x and y are both equal to 0
     */
    public Position(){
        this.x = 0;
        this.y = 0;
    }

    /**
     * Parameterized constructor
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * x coordinate getter
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * x coordinate setter
     * @return this
     */
    public Position setX(int x) {
        this.x = x;
        return this;
    }

    /**
     * y coordinate getter
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * y coordinate setter
     * @return this
     */
    public Position setY(int y) {
        this.y = y;
        return this;
    }
}
