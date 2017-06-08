
import java.io.FileReader;
import java.io.IOException;

public class Map {
    private int map[][];

    private Map(String mapName){
        int i=0;
        char c;
        FileReader fr = null;
        try {
            fr = new FileReader(".\\Map\\"+mapName+".txt");
            while( i != -1 ) {
                i=fr.read(); // on lit le caractère et on note son code dans i
                c=(char) i;
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }
}