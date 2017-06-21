
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MapCreator extends Map{
    private JPanel adder = new JPanel();
    private JPanel mapet;

    private JButton zero = new JButton("Disable");
    private JButton un = new JButton("Enable");
    private JButton save = new JButton("Save");

    private boolean enable = false;

    private void creerMap(String mapName){
        File f = new File("./Map/"+mapName+".txt");

        try {
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i <30; i++) {
                for (int j = 0; j <30; j++) {
                    switch (tabMove.get(i).get(j)){
                        case 0 :
                            fw.write(String.valueOf(0));
                            break;
                        case 1 :
                            fw.write(String.valueOf(1));
                            break;
                    }
                }
                fw.write("\n");
            }

            fw.close();
        } catch (IOException exception) {
            System.out.println("Erreur lors de la lecture : " + exception.getMessage());
        }
    }
    public MapCreator(){
        super();

        zero.addActionListener(e -> {
            enable = false;
            System.out.println("enable = false");
        });
        un.addActionListener(e -> {
            enable = true;
            System.out.println("enable = true");
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(null,
                        "Name of map",
                        "Save",
                        JOptionPane.WARNING_MESSAGE);
                creerMap(name);
            }
        });
        adder.add(zero);
        adder.add(un);
        adder.add(save);
        mapet = addGraphique();
        pane = new JPanel(new BorderLayout());
        pane.add(mapet, BorderLayout.CENTER);
        pane.add(adder, BorderLayout.SOUTH);
        fenetre.setContentPane(pane);
        fenetre.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (enable) tabMove.get(y).set(x,1);
        else tabMove.get(y).set(x,0);
        mapet = addGraphique();
        pane.removeAll();
        pane.add(mapet, BorderLayout.CENTER);
        pane.add(adder, BorderLayout.SOUTH);
        fenetre.revalidate();
    }
}
