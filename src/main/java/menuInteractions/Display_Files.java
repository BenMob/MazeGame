package menuInteractions;
import javax.swing.*;
import java.io.File;
import java.net.URL;

public class Display_Files{
        private final String file1 = "INSTRUCTIONS";
        private final String file2 = "SCORES";
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();

        /*------NEED TO ACCESS FILE AUTOMATICALLY WITHOUT CHANGING PATH
        --------------------------------------------------------------------------------
     //-----------------CODE SEGMENT TRIAL
        URL fileURL= Display_Files.class.getResource("INSTRUCTIONS.PNG");
        String myURL= fileURL.toString();
        --------------------------------------------------------------------------------
     //-----------------CODE SEGMENT TRIAL
        String path = System.getProperty("user.dir");
        File file = new File(path + "\\INSTRUCTIONS.PNG");

        */
        public Display_Files(){
        }                    // empty

        public Display_Files(String fileName){


            switch(fileName){
                case file1 -> {
                    frame.setTitle(file1);
                    label.setIcon(new ImageIcon("instructions.png ")); //REPLACE THESE PATHS
                    panel.add(label);
                }
                case file2 -> {
                    frame.setTitle(file2);
                    label.setIcon(new ImageIcon("C:/Users/IT/IdeaProjects/MazeGame//src//Maze/DATA.txt")); //REPLACE THESE PATHS
                    panel.add(label);
                }
            }

            frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            frame.add(panel);
            frame.setLocationRelativeTo(null);
            frame.setSize(900, 300);
            frame.setVisible(true);
        }
    }
