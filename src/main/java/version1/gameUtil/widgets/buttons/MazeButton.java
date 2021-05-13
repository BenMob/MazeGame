package version1.gameUtil.widgets.buttons;

import java.awt.event.ActionListener;

public class MazeButton extends AbstractMazeButton{
    public MazeButton(String label, ActionListener listener) {
        super(label);
        this.setText(label);
        this.addActionListener(listener);
    }

    public MazeButton(String label){
        super(label);
        this.setText(label);
    }
}

