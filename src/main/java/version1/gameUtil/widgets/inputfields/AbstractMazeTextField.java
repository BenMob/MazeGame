package version1.gameUtil.widgets.inputfields;

import javax.swing.*;

public abstract class AbstractMazeTextField extends JTextField {

    public AbstractMazeTextField(int maxLength){
        super(maxLength);
    }

    /**
     * Reads the user input
     * @return the content of the text field
     */
    public String readInput(){
        return this.getText();
    }

    /**
     * Clears the input box
     */
    public void clear(){
        this.setText("");
    }
}
