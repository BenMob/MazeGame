package menuInteractions;

public class gameMenuInteraction extends gameMenuLogic{
    private String gameMode;
    void setGameMode(String gm){ this.gameMode = gm; buttonUserInteraction();}
    void buttonUserInteraction() {
        switch (gameMode) {
            case "INSTRUCTIONS" -> instructionAction();
            case "EASY" -> easyModeAction();
            case "MEDIUM" -> mediumModeAction();
            case "HARD" -> hardModeAction();
            case "VIEWSCORE" -> viewScoreAction();
            case "EXIT" -> exitGameAction();
        }}
    public String getGameMode() {return gameMode;}
    void run(){}
}


abstract class gameMenuLogic{

    void instructionAction() {            //when instruction button is clicked
        new Display_Files("INSTRUCTIONS");        //it displays Instruction file
    }                                           //logic found in line 28

    void easyModeAction() {
        System.out.println("**CLICKED EZ BUTTON");
        //DISPLAY EASY MAP MAZE                //will display easy mode map
    }

    void mediumModeAction() {
        //DISPLAY MEDIUM MAP MAZES              //will display
        System.out.println("**CLICKED MED BUTTON");
    }

    void hardModeAction() {
        //DISPLAY HARD MAP
        System.out.println("**CLICKED HRD BUTTON");
    }

    void viewScoreAction() {
        System.out.println("**CLICKED SCORE BUTTON");
        //new Display_Files("SCORES");
    }

    void exitGameAction() {
        System.out.println("EXITING GAME...\nGOODBYE!");
        System.exit(0);
    }
}










