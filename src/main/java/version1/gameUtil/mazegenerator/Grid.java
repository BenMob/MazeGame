package version1.gameUtil.mazegenerator;

/**
 * This class represents onr grid on the maze map
 */
public class Grid {
    // Grid walls
    private byte walls[];

    // Grid borders
    private byte borders[];

    // Location of the grid
    private Position position;

    public Grid(Position position){
        this.position = position;
        this.walls = new byte[]{1,1,1,1};
        this.borders = new byte[]{0,0,0,0};
    }

    /**
     * Returns the postion of the grid
     * @return position of the grid
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Checks if all the walls around the grid are up
     * @return True if all the walls are up, otherwise False
     */
    public boolean allWallsAreUp(){
        for (byte wall: this.walls){
            if (wall == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * @return the wall byte array of 4 walls
     */
    public byte[] getWalls() {
        return walls;
    }

    /**
     *
     * @param side 0 = NORTH, 1 = EAST, 2 = SOUTH, 3 = WEST
     * @return The wall on that specific side
     */
    public int getWall(int side){
        return side >= 0 && side <= 4 ? this.getWalls()[side] : -1;
    }

    /**
     *
     * @param side 0 = NORTH, 1 = EAST, 2 = SOUTH, 3 = WEST
     * @param value int
     * @return this
     */
    public Grid  setWall(int side, byte value){
        this.walls[side] = value;
        return this;
    }

    /*
     * Sets the border
     * @param side
     * @param value
     */
    public void setBorder(int side, int value) {
        this.borders[side] = (byte)value;
    }
}
