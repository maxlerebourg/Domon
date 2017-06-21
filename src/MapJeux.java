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
        pane = new JPanel();
        pane.setLayout(new GridLayout(tabMove.size(),tabMove.get(0).size()));
        pane = addGraphique(pane, heros);
        fenetre.add(pane);
        fenetre.revalidate();
        //deplacement();

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        heros.setPosX(x);
        heros.setPosY(y);
        System.out.println(x + " " + y);
        pane = addGraphique(pane, heros);
        pane.repaint();
        fenetre.revalidate();
        /*fenetre = new JFrame("Domon");
        fenetre.setSize(1000,800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
        fenetre.add(pane);*/
    }

}
