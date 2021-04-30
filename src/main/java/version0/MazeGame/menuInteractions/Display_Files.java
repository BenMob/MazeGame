package MazeGame.menuInteractions;
import javax.swing.*;

public class Display_Files extends JFrame{
        private final String instructionsFile = "instructions.png", scoresFile= "data.txt";
        protected JPanel panel = new JPanel();
        protected JLabel label = new JLabel();

        public Display_Files(String fileName){
            switch(fileName){
                case "INSTRUCTIONS" -> {
                    setTitle("INSTRUCTIONS");
                    label.setIcon(new ImageIcon(instructionsFile)); //REPLACE THESE PATHS
                    panel.add(label);
                }
                case "SCORES" -> {
                    setTitle("SCORES TABLE");
                    label.setIcon(new ImageIcon(scoresFile)); //REPLACE THESE PATHS
                    panel.add(label);
                }}
            setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            add(panel);
            setLocationRelativeTo(null);
            setSize(900, 300);
            setVisible(true);
        }}
