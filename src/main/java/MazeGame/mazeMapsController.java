

package MazeGame;


import javax.swing.*;
public class mazeMapsController extends JFrame{

    public mazeMapsController(){
        mazeMapGenerator maps = new mazeMapGenerator();
        maps.initializeGameArray();
        add(maps);
        setTitle("MAZE GAME");
        setVisible(true);
        setResizable(true);
        setSize(maps.jFrameWidth, maps.jFrameHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }


}


