import javax.swing.*;

/**
 * Created by Max on 10/06/2017.
 */
public class Heros {
    private int posX = 0;
    private int posY = 0;

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    private ImageIcon img = new ImageIcon("./Image/Heros/heros.png");

    public int getPosY() {
        return posY;
    }

    public ImageIcon getImg() {
        return img;
    }

    public int getPosX() {

        return posX;
    }
}
