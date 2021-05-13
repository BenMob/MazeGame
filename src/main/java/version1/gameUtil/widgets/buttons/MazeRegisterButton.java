package version1.gameUtil.widgets.buttons;


/**
 * The registration Button
 */
public class MazeRegisterButton extends MazeButton{
    public MazeRegisterButton(String label) {
        super(label);
    }

    /**
     * Tries to register a user given a username
     * @return boolean
     */
    public boolean handleRegister(String username){
        return true;
    }

}
