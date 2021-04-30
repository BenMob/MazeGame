package version1.gameUtil.mazegenerator;

/**
 * This class creates an x by x maze
 */
public class Maze {
    /**
     * Size of the maze
     */
    private int size;

    /**
     * 2D array to store the map
     */
    private Grid[][] grids;

    /**
     *
     * @param size : size of the map
     */
    public Maze(int size){
        this.size = size;
    }

    /**
     *
     * @return the size of the Maze
     */
    public int getSize() {
        return size;
    }

    /**
     * Creates grids where Maze paths will be drawn
     */
    private void initializeGrids(){

    }

    /**
     * Generates the maze on top of the grids by kncking out walls
     */
    private void generateMaze(){

    }
}
