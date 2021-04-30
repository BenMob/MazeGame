package MazeGame.menuInteractions;
import javax.swing.*;

public class userDialog extends Player{
    ImageIcon icon = new ImageIcon("userlogin.jpg");
    protected String username;
    public void setUserNameDialog(){
        inputtedName(username = (String) JOptionPane.showInputDialog(null, "Enter a username",
                "User Dialog", JOptionPane.INFORMATION_MESSAGE, icon, null, ""));}
}
