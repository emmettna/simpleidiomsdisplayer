/**
 * Created by emmettna on 24/3/17.
 */

import javax.swing.*;
import java.awt.*;


public class Ui_Init extends JFrame  {
    JButton button;
    JLabel label;
    JLabel label2;
    JButton button2;
    JPanel panel;


    
    Ui_Init(){
//        Color c =new Color();

        label = new JLabel();
        label2 = new JLabel();
        button = new JButton();
        button2 = new JButton();
        panel = new JPanel();
        add(panel);


        setUndecorated(true);  //In case youd like to hide the frame
        getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
//        JPanel container = new JPanel();
        panel.setVisible(true);
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));


        panel.add(label);
        panel.add(button);
        panel.add(label2);
        label2.setVisible(false);
        panel.add(button2);
        button2.setVisible(false);

    }

}
