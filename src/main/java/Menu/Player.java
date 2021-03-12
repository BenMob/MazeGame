package Menu;

public class Player extends PlayerDetails{ //extends a movement clas only if is in on the maps and menus
    public boolean ifNAMECREATED, ifMODESELECTED, ifGAMEOVER;

    //------PLAYER CONSTRUCTOR-------
    Player(){ifNAMECREATED = false; ifMODESELECTED = false; ifGAMEOVER = false;}

    //------PLAYER SETTERS-------
    void inputtedName(String name){setPlayerName(name); ifNAMECREATED = true;}                //AFTER A NAME IS INPUTTED ON USER DIALOG; UPDATE
    void selectedGameMode(String mode){setPlayerModeSelection(mode); ifMODESELECTED = true;}   //AFTER A SELECTION IS MADE ON GAMEMENUGUI; UPDATE
    void mazeResults(double score){setPlayerScore(score); ifGAMEOVER = true;}                   //AFTER GAME ENDS; UPDATE
    void updatePlayerDetailsArray(){                                                            //CALL IF PLAYER CHOOSE DIFFERENT MODE AND GETS A DIFFERENT SCORE FOR THE MAP
        playerDetails[0] = NAME;
        playerDetails[1] = MODE_SELECTION;
        playerDetails[2] = SCORE;
    }

    //------GETTERS-------  //ONLY GET DETAILS OF PLAYER BY PLAYER CLASS LIKE DISPLAYING MENU
    public String getName(){return super.NAME;}
    public String getMode(){return super.MODE_SELECTION;}
    public String getScore(){return super.SCORE;}
/*
    public static void main(String[] args){
        Menu.Player player = new Menu.Player();
        player.inputtedName("JEDD ONG");
        player.selectedGameMode("EASY");
        player.mazeResults(69.69);
        if(player.ifGAMEOVER){
            player.updatePlayerDetailsArray();
            System.out.println("Name: " + player.getName());
            System.out.println("Mode:" + player.getMode());
            System.out.println("Score: " + player.getScore());
        }
        */
}

abstract class PlayerDetails{  //THIS CLASS IS FOR PUTTING TO A DATA BASE
    protected String NAME, MODE_SELECTION, SCORE;
    protected String[] playerDetails = new String[3];

    void setPlayerName(String name){NAME = name;}
    void setPlayerModeSelection(String mode){MODE_SELECTION = mode;}
    void setPlayerScore(double score){SCORE = Double.toString(score);}
}





