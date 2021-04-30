package MazeGame.menuInteractions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.util.EventListener;

public class mazeMapsController extends JFrame{

      public mazeMapsController(){
          mazeMapGenerator maps = new mazeMapGenerator();
          add(maps);
          setTitle("MazeGame.menuInteractions.version0.Player Control Illustration inside a JPanel");
          setVisible(true);
          setResizable(false);
          setSize(maps.jframeWidth, maps.jframeHeight);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
}

class mazeMapGenerator extends JPanel implements ActionListener, EventListener, KeyListener, Maps{
    final Color RED = Color.RED, BLACK = Color.BLACK, WHITE = Color.WHITE, GRAY = Color.GRAY;
    int[][] MAP = Maps.E1;                                       //HARD INTIALIZATION; WILL REMOVE FOR IT TO BE ADAPTABLE TO ANY MAP
    double x = 100, y =100, velx = 0, vely = 0;
    protected int jframeHeight = MAP.length * 80, jframeWidth = MAP[0].length * 80;
    Timer tm = new Timer(1, this);
    Graphics2D g2;

    public mazeMapGenerator(){ //THIS IS A CONTROLLER METHOD; SHOULD MOVE IT.
        tm.start();             //IMPORTANT; LISTEN TO FRAME IF THERE IS ANY KEY ACTION MADE; 1 SECOND DELAY FOR IT TO LISTEN AGAIN.
        addKeyListener(this); //REFERS EITHER TO THE FRAME OR POLYGON THAT IS MADE
        setFocusable(true);     //IMPORTANT; HELPS REFRESH POSITION OF PLAYER OBJ.
        setFocusTraversalKeysEnabled(false); //IMPORTANT
    }
    public void paintComponent(Graphics g){             //CREATING MAPS AND PLAYER OBJ (ECLIPPSE)
            for(int row = 0; row < MAP.length; row++){
                for(int col = 0; col < MAP[0].length; col++){
                    switch(MAP[row][col]){
                        case 1 -> g.setColor(BLACK);
                        case 2 -> g.setColor(GRAY);
                        case 3 -> g.setColor(RED);
                        case 0 -> g.setColor(WHITE);
                    }g.fillRect(80 * col, 80 * row, 80, 80);}}
        g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        g2.fill(new Ellipse2D.Double(x, y, 40, 40));
    }
    public void actionPerformed(ActionEvent e){ //METHOD IS ACCESSED WHEN A KEY IS PRESSED
        if(x < 0){ velx = 0; x = 0;}
        else if(x > jframeWidth-50){  velx = 0; x = jframeWidth - 50;}
        else if(y < 0){ vely = 0; y = 0;}
        else if(y > jframeHeight - 55){ vely = 0; y = jframeHeight-55;}
            x +=velx;
            y += vely;
            repaint();
        }
        public void keyPressed(KeyEvent e){ //CALLS MOVEMENT DEPENDING ON KEYEVENT E
            switch(e.getKeyCode()){
                case KeyEvent.VK_UP -> up();
                case KeyEvent.VK_W -> up();
                case KeyEvent.VK_S -> down();
                case KeyEvent.VK_DOWN -> down();
                case KeyEvent.VK_A -> left();
                case KeyEvent.VK_LEFT -> left();
                case KeyEvent.VK_D -> right();
                case KeyEvent.VK_RIGHT -> right();
            }}
    public void keyTyped (KeyEvent e){}
    public void keyReleased (KeyEvent e){ velx = 0; vely = 0;} // POSITION OF PLAY REMAINS IF KEY IS RELEASED

    private void up(){ vely = -10;velx = 0;}
    private void down(){ vely = 10;velx = 0;}
    private void left(){ velx = -10; vely = 0;}
    private void right(){ velx = 10; vely = 0;}
}

interface Maps{
    //Map implementation
    //E = EASY M = MEDIUM H = HARD
    //1 represents blocked wall
    //0 = open position to move
    //2 = start position
    //3 = winning pos
    //---------------------------------------EASY MAPS
    int E1[][] = {
          {1, 1, 1, 1, 1, 1, 1},
          {1, 0, 1, 0, 1, 3, 1},
          {1, 0, 1, 0, 1, 0, 1},
          {1, 0, 0, 0, 0, 0, 1},
          {1, 0, 1, 0, 1, 0, 1},
          {1, 2, 1, 0, 1, 0, 1},
          {1, 1, 1, 1, 1, 1, 1}
    };
    //int E2[][] = {};
    //int E3[][] = {};
    //-----------------------------------------------------MEDIUM MAPS
    int M1[][] = {
          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
          {1, 2, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
          {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
          {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1},
          {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
          {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
          {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
          {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
          {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 3, 1},
          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    //int M2[][] = {};
    //int M3[][] = {};
    //--------------------------------HARD MAPS
    int H1[][] = {
          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
          {1, 2, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
          {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
          {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1},
          {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
          {1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1},
          {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1},
          {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
          {1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
          {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
          {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 3, 1},
          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    //int H2[][] = {};
    //int H3[][] = {};
}





