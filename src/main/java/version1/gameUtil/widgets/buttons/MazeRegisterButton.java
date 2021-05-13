package version1.gameUtil.widgets.buttons;

import version1.gameUtil.listeners.interfaces.RegisterBListenerIF;

public class MazeRegisterButton extends MazeButton{
    // TODO: Remove this if feature works
   // private RegisterBListenerIF mediator;
    public MazeRegisterButton(String label, RegisterBListenerIF listener) {
        super(label, listener);
        this.addActionListener(listener);
    }

}
