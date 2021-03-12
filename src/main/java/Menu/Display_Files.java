package Menu;
import javax.swing.*;
public class Display_Files extends JFrame{
    private final String instructionsFile = "instructions.png", scoresFile= "data.txt";
    protected JPanel panel = new JPanel();
    protected JLabel label = new JLabel();
    public Display_Files(String fileName){
        switch(fileName){
                case "INSTRUCTIONS" ->{
                    setTitle("LEARN THE CONTROLS HUMAN");
                    label.setIcon(new ImageIcon(instructionsFile)); //REPLACE THESE PATHS
                    panel.add(label);}
                case "SCORES" -> {
                    setTitle("SCORES TABLE");
                    label.setIcon(new ImageIcon(scoresFile)); //REPLACE THESE PATHS
                    panel.add(label);}}
                    setBounds(325,325,500,600);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(panel);
        setSize(900, 300);
        setVisible(true);}}
