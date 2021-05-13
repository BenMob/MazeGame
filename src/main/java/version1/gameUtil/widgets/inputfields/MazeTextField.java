package version1.gameUtil.widgets.inputfields;

import version1.gameUtil.listeners.implementations.AuthenticationManager;

public class MazeTextField extends AbstractMazeTextField {
    // TODO: Remove this if feature works
    // private MazeTextFieldIF mediator;
    public MazeTextField(AuthenticationManager listener){
        super();
        this.addActionListener(listener);
    }
}
