import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static JButton cMap= new JButton("Créateur de Map");


    public static void main(String[] args){
        Map map = new Map("plaine");
        JFrame fenetre = new JFrame("Domon");
        fenetre.setSize(1000,800);
        fenetre.add(map.getPane());
        JPanel pane = new JPanel();
        pane.add(cMap);
        fenetre.setVisible(true);
    }

}
