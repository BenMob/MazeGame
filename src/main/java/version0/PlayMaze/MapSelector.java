package PlayMaze;

//FUNCTION OF CLASS
//STORES VALUE WHEN USER SELECTS A MAZE MODE
//THIS CLASS CAN BE USED TO GET THE NEXT MAP
public class MapSelector implements MazeMaps{
    public static int[][] selectedMAP;
    int counter = 0;
    String SelectedMap;
    public void setMAP(String level){
        SelectedMap = level;
        if(counter == 3){counter = 0;}
        if(counter < 3){
            switch(level){
                case "EASY":
                    switch(counter){
                        case 0 -> selectedMAP = MazeMaps.E0;
                        case 1 -> selectedMAP = MazeMaps.E1;
                        case 2 -> selectedMAP = MazeMaps.E2;}break;
                case "MEDIUM":
                    switch(counter){
                        case 0 -> selectedMAP = MazeMaps.M0;
                        case 1 -> selectedMAP = MazeMaps.M1;
                        case 2 -> selectedMAP = MazeMaps.M2;}break;
                case "HARD":
                    switch(counter){
                        case 0 -> selectedMAP = MazeMaps.H0;
                        case 1 -> selectedMAP = MazeMaps.H1;
                        case 2 -> selectedMAP = MazeMaps.H2;}break;}}counter++;}
}