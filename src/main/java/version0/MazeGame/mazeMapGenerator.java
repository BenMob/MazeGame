package MazeGame;

import PlayMaze.MapSelector;
import Menu.endGameMenuGUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.EventListener;

public class mazeMapGenerator extends JPanel implements ActionListener, EventListener, KeyListener{
    int[][] MAP = MapSelector.selectedMAP;
    boolean gameStatus; String gameCondition;
    double x, y, velx = 0, vely = 0, pX = x, pY = y, pNX, pNY, mX, mY, mNX, mNY, fX,fY,fNX,fNY;
    protected int jFrameHeight = MAP.length * 80 + 36, jFrameWidth = MAP[0].length * 80 + 13;
    int sizeOfPATHXTARRAY;
    Timer tm = new Timer(1, this);
    Rectangle2D[][] rArray = new Rectangle2D[MAP.length][MAP[0].length];
    Rectangle2D[] PATHXYARRAY, FINISHLINE = new Rectangle2D[1], STARTLINE = new Rectangle2D[1];
    Rectangle2D rect;
    endGameMenuGUI obj = new endGameMenuGUI();
    double currentTime;
    StartTimer sT;
    JButton button;


    public mazeMapGenerator(){
        //THIS IS A CONTROLLER METHOD; SHOULD MOVE IT.
        tm.start();                                         //IMPORTANT; LISTEN TO FRAME IF THERE IS ANY KEY ACTION MADE; 1 SECOND DELAY FOR IT TO LISTEN AGAIN.
        addKeyListener(this);                            //REFERS EITHER TO THE FRAME OR POLYGON THAT IS MADE
        setFocusable(true);                                //IMPORTANT; HELPS REFRESH POSITION OF PLAYER OBJ.
        setFocusTraversalKeysEnabled(false);
    }



    public void paintComponent(Graphics g){

      checkIfPlayerTouchedFinishedLine();
        Graphics2D g1 = (Graphics2D) g, g2 = (Graphics2D) g;
        for(int row = 0; row < MAP.length; row++){
            for(int col = 0; col < MAP[0].length; col++){
                rect = new Rectangle2D.Double(80 * col, 80 * row, 80, 80);
                rArray[row][col] = rect;
                switch(MAP[row][col]){
                    case 1 -> g1.setColor(Color.BLACK);
                    case 2 -> g1.setColor(Color.GRAY);
                    case 3 -> g1.setColor(Color.RED);
                    case 0 -> g1.setColor(Color.WHITE);
                }   g1.fill(rArray[row][col]);}}
        g2.setColor(Color.BLUE);
        g2.fill(rect = new Rectangle2D.Double(pX, pY, 40, 40));
    }

    public void actionPerformed(ActionEvent e){ //METHOD IS ACCESSED WHEN A KEY IS PRESSED
        pNX = pX + 40;
        pNY = pY + 40;
        for(int counter = 0; counter < PATHXYARRAY.length; counter++){ //LOOPING THE ARRAY OF WHITE RECT. HELPS NOTE IF PLAYER IS ON TRACK; CHECKS IF PLAYER AT A VALID POINT
            mX = PATHXYARRAY[counter].getX(); mNX = mX + 80;
            mY = PATHXYARRAY[counter].getY(); mNY = mY + 80;
            if(((pX > mX) && (pX < mNX)) && ((pY > mY) && (pY < mNY))){setStartPlayerPosition();}
            if(((pNX > mX) && (pNX < mNX)) && ((pY > mY) && (pY < mNY))){setStartPlayerPosition();}
            if(((pX > mX) && (pX < mNX)) && ((pNY > mY) && (pNY < mNY))){setStartPlayerPosition();}
            if(((pNX > mX) && (pNX < mNX)) && ((pNY > mY) && (pNY < mNY))){setStartPlayerPosition();}
        }
        pX += velx;
        pY += vely;
        repaint();
    }
    public void keyPressed(KeyEvent e){ //CALLS MOVEMENT DEPENDING ON KEYEVENT E
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP, KeyEvent.VK_W      ->  {vely= -2;velx= 0;}
            case KeyEvent.VK_S, KeyEvent.VK_DOWN    ->  {vely= 2;velx= 0;}
            case KeyEvent.VK_A, KeyEvent.VK_LEFT    ->  {velx= -2;vely= 0;}
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT   ->  {velx= 2;vely= 0;}}
    }
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){velx = 0; vely = 0;} // POSITION OF PLAY REMAINS IF KEY IS RELEASED

    public void initializeGameArray(){   //HELPS INTIALIZE THE ARRAY
        for(int row = 0; row < MAP.length; row++){
            for(int col = 0; col < MAP[0].length; col++){
                rect = new Rectangle2D.Double(80 * col, 80 * row, 80, 80);
                switch(MAP[row][col]){
                    case 1 -> sizeOfPATHXTARRAY++;
                    case 3 -> FINISHLINE[0] = rect;
                    case 2 -> STARTLINE[0] = rect;
                }}} storePathCoordinates(sizeOfPATHXTARRAY);
    }
    public void storePathCoordinates(int sizeOfPATHXTARRAY){
        PATHXYARRAY = new Rectangle2D[sizeOfPATHXTARRAY];
        int counter = 0;
        for(int row = 0; row < MAP.length; row++){
            for(int col = 0; col < MAP[0].length; col++){
                switch(MAP[row][col]){
                    case 1 -> { rect = new Rectangle2D.Double(80 * col, 80 * row, 80, 80);PATHXYARRAY[counter] = rect; counter++; }
                    }}}
        setStartPlayerPosition();
    }

    public void setStartPlayerPosition(){pX = STARTLINE[0].getX() +20; pY = STARTLINE[0].getY()+20; velx = 0; vely= 0;}

    public void checkIfPlayerFinishedTheGameQuickly(){
        //if(Timer > 15 && PlayerTouchedFinishLIne){ setStatusOfGameOver(true, "FINISHEDQUICKLY")}
    }

    public void checkIfPlayerRanOutOfTime(){
        if(sT.timeRanOut){
            setStatusOfGameOver(true, "OUTOFTIME");
        }
    }

    public void checkIfPlayerTouchedFinishedLine(){
        fX = FINISHLINE[0].getX(); fNX = fX + 80;
        fY = FINISHLINE[0].getY();fNY = fY + 80;
        if(!gameStatus)
            if(((((pX > fX) && (pX < fNX)) && ((pY > fY) && (pY < fNY))) && (((pNX > fX) && (pNX < fNX)) && ((pY > fY) && (pY < fNY)))) ||
                  ((((pX > fX) && (pX < fNX)) && ((pNY > fY) && (pNY < fNY))) && (((pNX > fX) && (pNX < fNX)) && ((pNY > fY) && (pNY < fNY))))){
                setStatusOfGameOver(true,"FINISHED");
            }
    }

    public void setStatusOfGameOver(boolean value, String condition){
       this.gameStatus = value;
       this.gameCondition = condition;
       checkGameCondition();
    }
    public void checkGameCondition(){
        if(gameStatus){
            switch(gameCondition){
                case "FINISHED"-> {obj.setEndGameStatus("WINNING_SCREEN"); obj.displayEndGameGUI();}
                case "FINISHEDQUICKLY"-> {obj.setEndGameStatus("SCARE_SCREEN"); obj.displayEndGameGUI();}
                case "OUTOFTIME"-> {obj.setEndGameStatus("LOSING_SCREEN"); obj.displayEndGameGUI();}
            }}
    }


    public boolean getStatusOfGame(){return gameStatus;}
    public void startEndGameMenu(){}
    public void determineEndGameStatus(String condition){
    }


}
