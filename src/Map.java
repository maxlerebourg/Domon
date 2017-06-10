
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Map {
    private JPanel pane;
    ArrayList<ArrayList<Integer>> tabMove = new ArrayList<>();

    private BufferedReader bis;



    private void init(){
        pane = new JPanel();
        pane.setLayout(new GridLayout(tabMove.size(),tabMove.get(0).size()));
        Insets emptyInsets = new Insets(0,0,0,0);
        addGraphique();
    }
    private void addGraphique(){

        for (ArrayList<Integer> aTab : tabMove) {
            for (int j : aTab) {
                switch (j) {
                    case 0 :
                        pane.add(new JLabel(new ImageIcon("./Image/Map/herbe.png")));
                        break;
                    case 1 :
                        pane.add(new JLabel(new ImageIcon("./Image/Map/terre.png")));
                        break;
                }
            }
        }
    }
    public Map(String mapName){

        try {
            creerMap(mapName);
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
                    fw.write(String.valueOf((int)(Math.random()*2)));
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
}