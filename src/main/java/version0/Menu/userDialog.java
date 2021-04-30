package Menu;
import javax.swing.*;

public class userDialog extends Player {
    final ImageIcon icon = new ImageIcon("amongus.png");
    protected String username;
    public boolean ifUSERINPUTTEDNAME = false;
    JOptionPane jp = new JOptionPane();
    JDialog jd = new JDialog();

    public void setUserNameDialog(){
      inputtedName(username = (String) jp.showInputDialog(null, "ENTER A USERNAME",
              "WELCOME HUMAN!", JOptionPane.INFORMATION_MESSAGE, icon, null, ""));}

    public void checkStatus(){
        if(this.username.equals(null) || username.equals("")){System.out.println("DETECTED NO USER INPUT; A NAME IS REQUIRED!");System.exit(0);}
        else{ifUSERINPUTTEDNAME = true;jd.setContentPane(jp);jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);}}
}




//COOL FEATURES
/*
    ADD DIFFERENT AMONG US CHARACTERS.
    RESIZE EACH PNG
    CAN GO THROUGH A RANDOM GENERATOR TO PICK WHICH CHARACTER TO CHOOSE
    MAKE SURE IF CANCEL OR EXIT WINDOW WILL CLOSE THE GAME

 */