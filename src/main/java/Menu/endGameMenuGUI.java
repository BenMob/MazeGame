package Menu;

import MazeGame.Audio;
import MazeGame.StartTimer;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class endGameMenuGUI extends StartTimer{
    final ImageIcon scaryMonsterBackground = new ImageIcon("uglymonster.jpg"),
          regularBackground = new ImageIcon("bitwallpaper.png"),
          regWinningTitle = new ImageIcon("regularwinningtitle.png"),
          losingTitle = new ImageIcon("losingtitle.png"),
          scaryTitle = new ImageIcon("scarytitle.png");

    JFrame frame = new JFrame("ENDGAME MENU");
    JButton playAgainButton, exitGameButton;
    Audio monster = new Audio();
    String endGameStatus;
    JPanel panel;
    JLabel displayBackground, displayTitle;
    boolean ifGAME_ENDED = false;
    boolean timeIsUp = false;

    public void setEndGameStatus(String endGameStatus){ this.endGameStatus = endGameStatus;}
    public void displayEndGameGUI(){
        switch(this.endGameStatus){
            case "SCARE_SCREEN" -> { ifGAME_ENDED = true; displayScarePopUp();}              //PASS THIS VALUE TO THE DATA CLASS SO THAT IT KNOWS TO WRITE INTO THE DATA
            case "WINNING_SCREEN" -> { ifGAME_ENDED = true; displayRegularWinnerTitle();}
            case "LOSING_SCREEN" -> { ifGAME_ENDED = true; displayLosingTitle(); }}
    }


    void displayScarePopUp(){
        displayBackground = new JLabel(scaryMonsterBackground);
        displayTitle = new JLabel();
        callFrame();
        monster.playPopUpAudio();
        frame.remove(displayBackground);                        //REMOVES CURRENT BACKGROUND
        displayAfterScarePopUp();
    }

    void displayAfterScarePopUp(){
        displayBackground = new JLabel(regularBackground);
        displayTitle = new JLabel(scaryTitle);
        setButtons();
        callFrame();

    }

    void displayRegularWinnerTitle(){
     new StartTimer(3, "ENDGAMEGUI");
        displayBackground = new JLabel(regularBackground);
        displayTitle = new JLabel(regWinningTitle);
        setButtons();
        callFrame();
        fillFrame();

    }

    void displayLosingTitle(){
        displayBackground = new JLabel(regularBackground);
        displayTitle = new JLabel(losingTitle);
        setButtons();
        callFrame();
    }

    void setButtons(){
        playAgainButton.setBounds(190, 310, 150, 25);
        exitGameButton.setBounds(360, 310, 150, 25);
        displayBackground.add(playAgainButton);
        displayBackground.add(exitGameButton);
        playAgainButton.addActionListener(e -> { });
        exitGameButton.addActionListener(e -> System.exit(0));
    }

   public void updateInClassTimer(){
       if(getInputtedSeconds() == 0){
           System.out.println("NO SELECTION MADE");
           timeIsUp = true;
           frame.removeAll();
           frame.setVisible(false);
       }
    }
    void fillFrame(){
        frame.setResizable(false);
        frame.add(displayBackground);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();                                                                            //only after pack will get you the true width and height
        frame.setVisible(!timeIsUp);
        frame.setLocationRelativeTo(null);
        frame.setSize(displayBackground.getWidth(), displayBackground.getHeight());
    }
    void callFrame(){
        displayTitle.setBounds(-60, -150, 800, 500);
        displayBackground.add(displayTitle);
           //resize image for each png for it to equal
    }

}


