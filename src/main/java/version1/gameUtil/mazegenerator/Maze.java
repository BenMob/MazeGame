package version1.gameUtil.mazegenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * This class creates an x by x maze
 */
public class Maze {
    /**
     * Size of the maze
     */
    private final int size;

    /**
     * 2D array to store the map
     */
    private final Grid[][] grids;

    /**
     *
     * @param size : size of the map
     */
    public Maze(int size){
        this.size = size;
        this.grids = new Grid[this.size][this.size];
        this.initializeGrids();
        this.generateMaze();
    }

    /**
     * Getter of the 2D array of grids
     * @return grids
     */
    public Grid[][] getGrids() {
        return grids;
    }

    /**
     *
     * @return the size of the Maze
     */
    public int getSize() {
        return size;
    }

    /*
     *  Gets Specific Grid located a position x,y
     * @param x
     * @param y
     * @return grids[x][y]
     */
    public Grid getGrid(int x, int y){
        return this.grids[x][y];
    }

    /**
     * Creates grids where Maze paths will be drawn
     */
    private void initializeGrids(){
        for(int x = 0; x < this.size; x++){
            for(int y = 0; y < this.size; y++){
                this.grids[x][y] = new Grid(new Position(x,y));
                if(x == 0){
                    this.grids[x][y].setBorder(0,1);
                }

                if(y == 0){
                    this.grids[x][y].setBorder(3,1);
                }

                if(x == size - 1){
                    this.grids[x][y].setBorder(2, 1);
                }

                if(y == size - 1){
                    this.grids[x][y].setBorder(1,1);
                }
            }
        }
    }

    /**
     * Generates the maze on top of the grids by kncking out walls
     */
    private void generateMaze(){

        /*
         * NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3
         * RANDOMIZED FIRST SEARCH ALGORITHM
         *
         * 1. Choose the initial cell, mark it as visited and push it to the stack
         * 2. While the stack is not empty
         *      1. Pop a cell from the stack and make it a current cell
         *      2. If the current cell has any neighbours which have not been visited
         *              1.Push the current cell to the stack
         *              2.Choose one of the unvisited neighbours
         *              3.Remove the wall between the current cell and the chosen cell
         *              4.Mark the chosen cell as visited and push it to the stack
         *
         * Source: https://en.wikipedia.org/wiki/Maze_generation_algorithm#Randomized_depth-first_search
         */

        // Random number generator
        Random random = new Random();

        // Random starting point
        int x = random.nextInt(this.size);                          // Random x value
        int y = random.nextInt(this.size);                          // Random y value
        Grid currentGrid = this.grids[x][y];                        // Holds the current cell (Start at a random cell)
        Stack<Grid> gridStack = new Stack<>();                      // Stack to store grids that need to be checked
        int totalNumberOfGrids = (int)Math.pow(this.size, 2);       // Total number of grids
        int numberOfVisitedGrids = 1;                               // Only the initial grid is marked as visited at the beginning

        Vertex temporaryVertex;
        List<Vertex> neighbors = new ArrayList<>();                   // List holding neighboring Grids's info

        while(numberOfVisitedGrids < totalNumberOfGrids){
            neighbors.clear();                                        // Clear neighboring cells

            temporaryVertex = new Vertex();
            if(y-1 >= 0 && grids[x][y-1].allWallsAreUp()){
                temporaryVertex.setX1(x);
                temporaryVertex.setY1(y);
                temporaryVertex.setX2(x);
                temporaryVertex.setY2(y - 1);
                temporaryVertex.setWall1(0);
                temporaryVertex.setWall2(2);
                neighbors.add(temporaryVertex);
            }

            temporaryVertex = new Vertex();
            if(y+1 < size && grids[x][y+1].allWallsAreUp()){
                temporaryVertex.setX1(x);
                temporaryVertex.setY1(y);
                temporaryVertex.setX2(x);
                temporaryVertex.setY2(y + 1);
                temporaryVertex.setWall1(2);
                temporaryVertex.setWall2(0);
                neighbors.add(temporaryVertex);
            }

            temporaryVertex = new Vertex();
            if(x - 1 >= 0 && grids[x-1][y].allWallsAreUp()){
                temporaryVertex.setX1(x);
                temporaryVertex.setY1(y);
                temporaryVertex.setX2(x - 1);
                temporaryVertex.setY2(y);
                temporaryVertex.setWall1(3);
                temporaryVertex.setWall2(1);
                neighbors.add(temporaryVertex);
            }

            temporaryVertex = new Vertex();
            if(x + 1 < size && grids[x+1][y].allWallsAreUp()){
                temporaryVertex.setX1(x);
                temporaryVertex.setY1(y);
                temporaryVertex.setX2(x + 1);
                temporaryVertex.setY2(y);
                temporaryVertex.setWall1(1);
                temporaryVertex.setWall2(3);
                neighbors.add(temporaryVertex);
            }

            // If an unvisisted grid was found
            if(neighbors.size() >= 1){
                // Randomly choose a neightbor from neighbors
                temporaryVertex = neighbors.get(random.nextInt(neighbors.size()));
                grids[temporaryVertex.getX1()][temporaryVertex.getY1()].setWall(temporaryVertex.getWall1(),(byte)0);
                grids[temporaryVertex.getX2()][temporaryVertex.getY2()].setWall(temporaryVertex.getWall2(),(byte)0);

                // Push the current grid to the stack so that it can be visited later
                gridStack.push(currentGrid);

                // Make the nre grid the current grid
                currentGrid = grids[temporaryVertex.getX2()][temporaryVertex.getY2()];

                // Update x and y
                x = currentGrid.getPosition().getX();
                y = currentGrid.getPosition().getY();

                // Increment the visited ground cells
                numberOfVisitedGrids++;
            }else{                      // else, take the last grid from the stack and use that as the current grid
                currentGrid = gridStack.pop();
                x = currentGrid.getPosition().getX();
                y = currentGrid.getPosition().getY();
            }
        }

        grids[0][0].setWall(3,(byte)0);
        grids[size - 1][size - 1].setWall(1, (byte)0);
    }
}
