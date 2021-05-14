package version1.gameUtil.widgets.buttons;


import version1.gameUtil.data.dataRepository.DataStore;

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
        return DataStore.getDSInstance().register(username);
    }

}
