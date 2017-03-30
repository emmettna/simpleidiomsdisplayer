/**
 * Created by emmettna on 24/3/17.
 */

import javax.swing.*;
import java.awt.*;


public class Ui_Init {

    public JLabel label, label2, label3, buttonLabel1, buttonLabel2;
    public JButton button, button2;
    public ImagePanel panel;
    public JFrame visibleFrame, invisibleFrame;
    private Color color;
    Ui_Init(){
        label = new JLabel();
        label3 = new JLabel();
        label2 = new JLabel();
        buttonLabel1 = new JLabel("Check the meaning");
        buttonLabel2 = new JLabel("Tap to for Next");
        button = new JButton("Check the meaning");
        button2 = new JButton("Tap to see the next");
        panel = new ImagePanel();
        visibleFrame = new JFrame();
        invisibleFrame = new JFrame();
        Font font = new Font("Chalkboard",Font.PLAIN,16);

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
        label.setBounds(10,20,400,30);
        label3.setBounds(10,25,400,30);
        label3.setForeground(Color.WHITE);
        label3.setFont(font);
        label2.setBounds(10,70,300,30);
        button.setBounds(250,110,140,20);
        button2.setBounds(250,110,140,20);


        panel.add(label);
        panel.add(button);
        panel.add(label2);
        panel.add(label3);
        label2.setVisible(false);
        panel.add(button2);
        button2.setVisible(false);
    }
    public Color getTransparentColor(final boolean a){
        if(a) color = new Color(1.0f,1.0f,1.0f,0.5f);
        else color = new Color(1.0f,1.0f,1.0f,1.0f);
        return color;
    }

}
