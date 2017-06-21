
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;

public class Map implements MouseListener{
    protected JPanel pane = new JPanel();
    protected JFrame fenetre;
    protected ArrayList<ArrayList<Integer>> tabMove = new ArrayList<>();
    protected int i,j,x,y;


    private BufferedReader bis;


    private JButton cas(String img, JPanel panel){
        JButton button = new JButton(new ImageIcon("./Image/Map/"+img+".png"));
        button.addMouseListener(this);
        button.setFocusPainted( false );
        button.setBorderPainted(false);
        button.setOpaque( false );
        button.setContentAreaFilled(false);
        button.addActionListener(e -> {
            JButton p = (JButton) e.getSource();
            x = (int)p.getX()/(panel.getWidth()/tabMove.get(0).size());
            y = (int)p.getY()/(panel.getHeight()/tabMove.size());
            System.out.println(x+"/"+y);
        });
        return button;
    }
    protected JPanel addGraphique(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(tabMove.size(),tabMove.get(0).size()));
        for (i = 0 ; i < tabMove.size(); i++) {
            for (j = 0; j < tabMove.get(i).size(); j++) {
                switch (tabMove.get(i).get(j)) {
                    case 0 :
                        JButton but = cas("terre", panel);
                        panel.add(but);
                        break;
                    case 1 :
                        JButton bot = cas("herbe",panel);
                        panel.add(bot);
                        break;
                    default :
                        JButton bit = cas("herbe",panel);
                        panel.add(bit);
                        break;
                }
            }
        }
        return panel;
    }
    protected JPanel addGraphique(Heros heros){
        JPanel panel = addGraphique();
        int index = heros.getPosX()* tabMove.get(0).size() + heros.getPosY();
        panel.remove(index);
        panel.add(new JButton(heros.getImg()), heros.getPosX(), heros.getPosY());
        return panel;
    }
    public Map(){
        fenetre = new JFrame("Domon");
        fenetre.setSize(1000,800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            bis = new BufferedReader(new FileReader(new File("./Map/default.txt")));
            String line;
            while ((line = bis.readLine()) != null){
                ArrayList<Integer> tabLine = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    switch (line.substring(i, i + 1)) {
                        case "0":
                            tabLine.add(0);
                            break;
                        case "1":
                            tabLine.add(1);
                            break;
                    }
                }
                tabMove.add(tabLine);
            }
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(){
        fenetre = new JFrame("Domon");
        fenetre.setSize(1000,800);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = addGraphique();
        fenetre.setContentPane(pane);
        fenetre.setVisible(true);
    }
    public Map(String mapName){
        try {

            bis = new BufferedReader(new FileReader(new File("./Map/"+mapName+".txt")));
            String line;
            while ((line = bis.readLine()) != null){
                ArrayList<Integer> tabLine = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    switch (line.substring(i, i + 1)) {
                        case "0":
                            tabLine.add(0);
                            break;
                        case "1":
                            tabLine.add(1);
                            break;
                    }
                }
                tabMove.add(tabLine);
            }
            bis.close();
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void creerMap(String mapName) {
        File f = new File("./Map/"+mapName+".txt");

        try {
            FileWriter fw = new FileWriter(f);

            for (int i = 0; i <30; i++) {
                for (int j = 0; j <30; j++) {
                    if (mapName.equals("default"))fw.write(String.valueOf(1));
                    else fw.write(String.valueOf((int)(Math.random()*2)));
                }
                fw.write("\n");
            }

            fw.close();
        } catch (IOException exception) {
            System.out.println("Erreur lors de la lecture : " + exception.getMessage());
        }
    }
    public JPanel getPane(){
        return pane;
    }
    protected void deplacement(){
        pane.repaint();
        fenetre.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}