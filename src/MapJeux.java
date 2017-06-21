import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Max on 10/06/2017.
 */
public class MapJeux extends Map{
    private Heros heros;
    public MapJeux(){
        super("Coco");
        heros = new Heros();
        pane = addGraphique(heros);
        fenetre = new JFrame("Domon");
        fenetre.setSize(1000,800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.add(pane);
        fenetre.setVisible(true);
        //deplacement();

    }
    public void mouseClicked(MouseEvent e) {
        heros.setPosX(x);
        heros.setPosY(y);
        pane = addGraphique(heros);
        fenetre = new JFrame("Domon");
        fenetre.setSize(1000,800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.add(pane);
        fenetre.setVisible(true);
    }

}
