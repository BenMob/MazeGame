package version1.gameUtil.widgets.buttons;

import version1.gameUtil.listeners.interfaces.RegisterBListenerIF;

import java.awt.event.ActionListener;

public class MazeRegisterButton extends MazeButton{
    private RegisterBListenerIF mediator;
    public MazeRegisterButton(String label, ActionListener listener) {
        super(label, listener);
    }

}
