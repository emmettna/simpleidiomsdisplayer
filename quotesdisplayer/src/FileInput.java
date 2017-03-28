import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by emmettna on 24/3/17.
 */
public class FileInput {

    List<String> list;

    FileInput() {
        try {
            list = new ArrayList<>();
            File path = new File("/Users/emmettna/Downloads/Scala/Quotesdisplayer/out/production/quotesdisplayer/idioms");
            File filepath = new File("idioms");
            // Relative location needs to be set
           Scanner sc = new Scanner(path);
            while(sc.hasNext()) {
                String line = sc.nextLine();
                String[] array = line.split(":");
                String english = array[0];
                String korean = array[1];
                list.add(english);
                list.add(korean);
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}

