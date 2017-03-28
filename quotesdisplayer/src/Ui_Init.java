/**
 * Created by emmettna on 24/3/17.
 */

import javax.swing.*;
import java.awt.*;


public class Ui_Init   {

    JLabel label;
    JLabel label2;
    JButton button;
    JButton button2;
    JPanel panel;
    JFrame visibleFrame;
    JFrame invisibleFrame;
    Color color;
    Ui_Init(){

        label = new JLabel();
        label2 = new JLabel();
        button = new JButton("Check the meaning");
        button.setOpaque(true);
        button2 = new JButton("Tap to see the next");
        button2.setOpaque(true);
        panel = new JPanel();
        visibleFrame = new JFrame();
        invisibleFrame = new JFrame();
        Font font = new Font("Savoye LET",Font.BOLD,25);

        invisibleFrame.add(panel);

        visibleFrame.setUndecorated(false);
        visibleFrame.getContentPane().setBackground(getTransparentColor(false));
        visibleFrame.setBackground(getTransparentColor(false));

        invisibleFrame.setUndecorated(true);  //In case youd like to hide the frame
        invisibleFrame.getContentPane().setBackground(getTransparentColor(true));
        invisibleFrame.setBackground(getTransparentColor(true));

        panel.setVisible(true);
        panel.setOpaque(false);
        panel.setLayout(null);

        label.setFont(font);
        label.setForeground(Color.WHITE);
        label.setBounds(10,30,400,30);
        label2.setBounds(10,70,300,30);
        button.setBounds(250,110,140,20);
        button2.setBounds(250,110,140,20);


        panel.add(label);
        panel.add(button);
        panel.add(label2);
        label2.setVisible(false);
        panel.add(button2);
        button2.setVisible(false);
    }
    private Color getTransparentColor(final boolean a){
        if(a) color = new Color(1.0f,1.0f,1.0f,0.5f);
        else color = new Color(1.0f,1.0f,1.0f,1.0f);
        return color;
    }

}
