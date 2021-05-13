package version1.gameUtil.widgets.buttons;

import javax.swing.JButton;


public abstract class AbstractMazeButton extends JButton {
    private final String label;

    protected AbstractMazeButton(String label) {
        this.label = label;
    }

    /**
     * Enables a button
     */
    public  void enableButton(){
        this.setEnabled(true);
    }

    /**
     * Disables the button
     */
    public void disableButton(){
        this.setEnabled(false);
    }
}
