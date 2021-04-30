package version0;

import Menu.gameMenuGUI;
import Menu.userDialog;

public class gameLauncher{
    public static void main(String[] args){
        userDialog uD = new userDialog();
        uD.setUserNameDialog(); uD.checkStatus();
        if(uD.ifUSERINPUTTEDNAME){gameMenuGUI gMGUI = new gameMenuGUI();gMGUI.displaygameMenuGUI();}
        else{System.exit(0);}

    }}
