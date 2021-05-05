package version1.gameUtil.mazegenerator;

import version1.gameUtil.settings.GameMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Path2D;

/**
 * This is the JPanel that draws the Map and coordinates all the moves
 */
public class MazeMap extends JPanel implements KeyListener {

    // Map Dimensions
    private final int OFFSET = 10;
    private final int GRIDSIZE = 10;

    // Maze Object
    private final Maze maze;

    // Gameplay information
    private int pointX, pointY;
    private int score;
    private int oldX;
    private int oldY;
    private boolean gameOver = false;

    public MazeMap(GameMode mode){

        /*
         *Determinesb the map size based on the given game mode
         */
        final int EASYMAPSIZE = 25;
        final int MEDIUMMAPSIZE = 30;
        final int HARDMAPSIZE = 35;
        int map_size;
        switch (mode) {
            case EASY -> map_size = EASYMAPSIZE;
            case MEDIUM -> map_size = MEDIUMMAPSIZE;
            case HARD -> map_size = HARDMAPSIZE;
            default -> map_size = 20;
        }
        this.maze = new Maze(map_size);

        /*
         * Initialize local private attributes
         */
        this.pointX = OFFSET + GRIDSIZE / 2;
        this.pointY = OFFSET + GRIDSIZE / 2;
        this.oldX = pointX;
        this.oldY = pointY;
        this.score = 0;
        this.setPreferredSize(new Dimension(GRIDSIZE * map_size + 200, GRIDSIZE * map_size + 24));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.buildMaze(g);
    }

    private void buildMaze(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setColor(Color.WHITE);

        Dimension dimension = this.getSize();
        Insets insets = this.getInsets();

        int width = dimension.width - insets.left - insets.right;
        int height = dimension.height - insets.top - insets.right;

        graphics2D.setBackground(new Color(30, 49, 120));
        graphics2D.clearRect(0,0, width,height);

        Path2D pencil = new Path2D.Double();

        int a, b;
        Grid[][] cells = maze.getGrids();

        for(int x = 0; x < maze.getSize(); x++){

            a = x * GRIDSIZE + OFFSET;
            for(int y = 0; y < maze.getSize(); y++){
                b = y * GRIDSIZE + OFFSET;

                if(cells[x][y].getWalls()[0] == 1){
                    pencil.moveTo(a,b);
                    pencil.lineTo(a + GRIDSIZE, b);
                    graphics.drawLine(a, b,a + GRIDSIZE, b);
                }

                if(cells[x][y].getWalls()[1] == 1){
                    pencil.moveTo(a + GRIDSIZE, b);
                    pencil.lineTo(a + GRIDSIZE, b + GRIDSIZE);
                    graphics.drawLine(a + GRIDSIZE, b,a + GRIDSIZE, b + GRIDSIZE);
                }

                if(cells[x][y].getWalls()[2] == 1){
                    pencil.moveTo(a,b + GRIDSIZE);
                    pencil.lineTo(a + GRIDSIZE, b + GRIDSIZE);
                    graphics.drawLine(a, b + GRIDSIZE,a + GRIDSIZE, b + GRIDSIZE);
                }

                if(cells[x][y].getWalls()[3] == 1){
                    pencil.moveTo(a,b);
                    pencil.lineTo(a, b + GRIDSIZE);
                    graphics.drawLine(a, b, a, b + GRIDSIZE);
                }
            }
        }

        // Cliping code
        int x = (oldX - OFFSET - GRIDSIZE / 2) / GRIDSIZE;
        int y = (oldY - OFFSET - GRIDSIZE / 2) / GRIDSIZE;
        if(!gameOver) {

            // Left move
            if (x >= 0 && x < maze.getSize() && oldX > pointX && maze.getGrid(x, y).getWall(3) == 1) {
                pointX = oldX;
                pointY = oldY;

                // Right move
            } else if (x >= 0 && x < maze.getSize() && oldX < pointX && maze.getGrid(x, y).getWall(1) == 1) {
                pointX = oldX;
                pointY = oldY;

                // Up move
            } else if (y >= 0 && y < maze.getSize() && oldY > pointY && maze.getGrid(x, y).getWall(0) == 1) {
                pointX = oldX;
                pointY = oldY;

                // Down move
            } else if (y >= 0 && y < maze.getSize() && oldY < pointY && maze.getGrid(x, y).getWall(2) == 1) {
                pointX = oldX;
                pointY = oldY;
            }

            // update score
            if (pointX != oldX || pointY != oldY) {
                score++;
            }
        }

        // Display score
        graphics2D.drawString("Moves: " + score, maze.getSize() * GRIDSIZE + OFFSET + 20,20);

        // Winning
        if(y == maze.getSize() - 1 && x >= maze.getSize() - 1){
            graphics2D.drawString("Bravo!", maze.getSize() * GRIDSIZE + OFFSET + 20, 100);
            gameOver = true;
        }

        // Draw the player on their previous position
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillOval(oldX - 2, oldY - 2, 5, 5);

        //Draw the player on the current location in red
        graphics.setColor(new Color(250, 250, 250));
        graphics.fillOval(pointX - 2, pointY - 2, 5, 5);

    }


    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent key){
        System.out.println("Key Pressed");
        oldX = pointX;
        oldY = pointY;

        if(!gameOver) {

            // Mode the player depending on the key pressed
            if (key.getKeyCode() == KeyEvent.VK_DOWN) {
                pointY = pointY + GRIDSIZE;
                if (pointY > getBounds().height) {
                    pointY = getBounds().height;
                }
            }
            if (key.getKeyCode() == KeyEvent.VK_UP) {
                pointY = pointY - GRIDSIZE;
                if (pointY < 0) {
                    pointY = 0;
                }
            }
            if (key.getKeyCode() == KeyEvent.VK_LEFT) {
                pointX = pointX - GRIDSIZE;
                if (pointX <= 0) {
                    pointX = pointX + GRIDSIZE;
                }
            }
            if (key.getKeyCode() == KeyEvent.VK_RIGHT) {
                pointX = pointX + GRIDSIZE;
                if (pointX > getBounds().width) {
                    pointX = getBounds().width;
                }
            }
        }
        repaint();
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
