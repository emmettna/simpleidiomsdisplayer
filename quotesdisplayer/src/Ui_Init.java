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
        button = new JButton("Check the meaning");
        button2 = new JButton("Tap to see the next");
        panel = new JPanel();
        add(panel);


        setUndecorated(true);  //In case youd like to hide the frame
        getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
        setBackground(new Color(1.0f,1.0f,1.0f,0.5f));

//        JPanel container = new JPanel();
        panel.setVisible(true);
        panel.setOpaque(false);
        LayoutManager layout = new BoxLayout(panel, BoxLayout.PAGE_AXIS);
        panel.setLayout(null);

        label.setBounds(10,30,200,15);
        label2.setBounds(10,70,200,15);
        button.setBounds(10,130,170,20);
        button2.setBounds(10,130,170,20);

        panel.add(label);
        panel.add(button);
        panel.add(label2);
        label2.setVisible(false);
        panel.add(button2);
        button2.setVisible(false);
    }


}
