import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by emmettna on 24/3/17.
 */
public class FileInput {

    private List<String> list;
    FileInput() {
        try {

            list = new ArrayList<>();
            File filepath = new File("idioms");
            // Relative location needs to be set
            Scanner sc = new Scanner(filepath);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] array = line.split(":");
                String english = array[0];
                String korean = array[1];
                list.add(english);
                list.add(korean);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<String> getList(){
        return list;
    }
}

