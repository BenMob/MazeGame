import javax.swing.*;

public class Dialog {
    public static void main (String[] args)  {

        ImageIcon icon = new ImageIcon("userlogin.jpg");
        String input = (String) JOptionPane.showInputDialog(null,"Enter a username","User Dialog", JOptionPane.INFORMATION_MESSAGE,icon, null,"");
        System.out.println(input);
    } // end main
}
