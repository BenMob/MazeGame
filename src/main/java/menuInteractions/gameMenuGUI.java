package menuInteractions;

import javax.swing.*;
import javax.swing.JFrame;

public class gameMenuGUI extends gameMenuInteraction{
    private JButton instructionButton, easyButton, mediumButton, hardButton, scoreButton, exitButton;           //buttons
    private JPanel gameMenuGUIPanel;
    gameMenuInteraction obj = new gameMenuInteraction();

    public gameMenuGUI() { //BUTTONS
            instructionButton.addActionListener(e -> obj.setGameMode("INSTRUCTIONS"));      //buttons with action listener
            easyButton.addActionListener(e -> obj.setGameMode("EASY"));                   //when button is pressed
            mediumButton.addActionListener(e -> obj.setGameMode("MEDIUM"));               //it passes a String value
            hardButton.addActionListener(e -> obj.setGameMode("HARD"));                   //of the Game Mode
            scoreButton.addActionListener(e -> obj.setGameMode("SCORES"));
            exitButton.addActionListener(e -> obj.setGameMode("EXIT"));
        }

        public void displaygameMenuGUI() {                                                    //frame is created
            JFrame frame = new JFrame("Game Menu");
            frame.setResizable(false);                                                     //methods associated with JFrame object
            frame.setContentPane(new menuInteractions.gameMenuGUI().gameMenuGUIPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null); //PLACES FRAME IN THE CENTER OF THE SCREEN
            frame.setVisible(true);
            frame.setSize(200, 192);
        }

        void run(){displaygameMenuGUI();}
    }


