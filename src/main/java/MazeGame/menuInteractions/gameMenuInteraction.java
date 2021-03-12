package MazeGame.menuInteractions;
public class gameMenuInteraction extends gameMenuLogic{
    private String gameMode;
    void setGameMode(String gm){ this.gameMode = gm; buttonUserInteraction();}
    void buttonUserInteraction() {
        switch (gameMode) {
            case "INSTRUCTIONS" -> instructionAction();
            case "EASY" -> easyModeAction();
            case "MEDIUM" -> mediumModeAction();
            case "HARD" -> hardModeAction();
            case "VIEWSCORES" -> viewScoreAction();
            case "EXIT" -> exitGameAction();
            default -> System.out.println("No Button User Interaction");
            }
        }}


abstract class gameMenuLogic{

    void instructionAction() {new Display_Files("INSTRUCTIONS");}
    void easyModeAction() {System.out.println("**CLICKED EZ BUTTON"); new mazeMapsController();}
    void mediumModeAction() {System.out.println("**CLICKED MED BUTTON");new mazeMapsController();}
    void hardModeAction() { System.out.println("**CLICKED HRD BUTTON");new mazeMapsController();}
    void viewScoreAction() {new Display_Files("DATA");}
    void exitGameAction() {System.out.println("EXITING GAME"); System.exit(0);}
}










