package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class Controller {
    private String charList = "AZERTYUIOPQSDFGHJKLMWXCVBN0123456789";
    private String KeyWithBenefits = "";

    @FXML
    Label keyid;

    public void generate(){

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            key.append(charList.charAt((int) (Math.random() * 35)));
        }
        System.out.println(key);
        KeyWithBenefits = key.substring(0,4).concat(" - ").concat(key.substring(4,8)).concat(" - ").concat(key.substring(8,12)).concat(" - ").concat(key.substring(12,16));
        keyid.setText(KeyWithBenefits);
    }

    public void copy(){
        StringSelection selection = new StringSelection(KeyWithBenefits);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}
