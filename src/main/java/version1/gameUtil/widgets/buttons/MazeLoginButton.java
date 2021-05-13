package version1.gameUtil.widgets.buttons;

import version1.gameUtil.data.dataRepository.DataStore;

/**
 * This is the Login button
 */
public class MazeLoginButton extends MazeButton {

    public MazeLoginButton(String label) {
        super(label);
    }

    /**
     * Tries to log a user given a username
     * @return boolean
     */
    public boolean handleLogin(String username){
       return DataStore.getDSInstance().login(username);
    }
}
