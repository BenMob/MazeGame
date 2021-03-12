package MazeGame;

import java.util.Timer;
import java.util.TimerTask;
import MazeGame.mazeMapGenerator;
import Menu.endGameMenuGUI;

public class StartTimer{

    Timer timer = new Timer();
    double currentTime = 0;
    boolean timeRanOut = false;
    public int inputtedSeconds, nS;
    boolean gameCondition = false;

    public int getInputtedSeconds(){
        return inputtedSeconds;
    }
    public StartTimer(){
    }

    public StartTimer(int seconds, String location){
        this.inputtedSeconds = seconds;

        switch(location){
            case "GAME" -> {
                System.out.println("YOU HAVE 60 SECONDS TO FINISH");
                timer.schedule(new MAZEGAMETIMER(), 0, 1 * 1000);
            }
            case "ENDGAMEGUI" -> {
                System.out.println("GAME WILL EXIT IF A SELECTION HAS NOT BEEN IN 30 SECONDS...");
                timer.schedule(new ENDGAMEGUITIMER(), 0, 1 * 1000);
            }
        }
    }

    class MAZEGAMETIMER extends TimerTask{
        public void run(){
            if(inputtedSeconds > 0){ //CAN UPDATE A CONDITION
                inputtedSeconds--;
            }else{
                cancel();
                System.out.println("TIME IS UP");

            }
        }
    }

    class ENDGAMEGUITIMER extends TimerTask{
        public void run(){
            if(inputtedSeconds >= 0){
                System.out.println("Time: "+ inputtedSeconds);
                inputtedSeconds--;
            }else{
                System.out.println("Canceling()");cancel();
            }
        }
    }
}
