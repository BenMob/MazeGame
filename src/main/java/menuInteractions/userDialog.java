package menuInteractions;

import javax.swing.*;

public class userDialog {
    ImageIcon icon = new ImageIcon("userlogin.jpg");
    protected String username;

    public void setUserNameDialog(){
        username = (String) JOptionPane.showInputDialog(null, "Enter a username",
                "User Dialog", JOptionPane.INFORMATION_MESSAGE, icon, null, "");
    }
    public void run() {

    }
}
