import javax.swing.*;
import java.awt.*;

/**
 * Created by emmettna on 28/3/17.
 */
public class getFrame{
    JFrame frame;
    public JFrame getFrame(boolean b){
        if(b) {
            frame.setUndecorated(true);  //In case youd like to hide the frame
            frame.getContentPane().setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
            frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
            return frame;
        }
        else{
            frame.removeNotify();
            frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,1f));
            frame.setBackground(new Color(1.0f,1.0f,1.0f,1f));
            return frame;
        }
    }
}
