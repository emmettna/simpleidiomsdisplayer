/**
 * Created by emmettna on 24/3/17.
 */

import javax.swing.*;
import java.awt.*;


public class Ui_Init {

    public JLabel label, label2, label3;
    public JButton button, button2;
    public ImagePanel panel;
    public JFrame visibleFrame, invisibleFrame;
    private Color color;

    Ui_Init(){
        label = new JLabel();
        label3 = new JLabel();
        label2 = new JLabel();
        button = new JButton("Check the meaning");
        button2 = new JButton("Tap to for Next");
        panel = new ImagePanel();
        visibleFrame = new JFrame();
        invisibleFrame = new JFrame();

        Font font = new Font("Chalkboard",Font.PLAIN,16);


        /* None of these work X_x */


//        invisibleFrame.setIconImage();
//        Toolkit.getDefaultToolkit().getImage(MainClass.class.getResource("cute img icon.jpg"));
//        try{
//            Image image = new ImageIcon("cute img icon.jpg").getImage();
//            invisibleFrame.setIconImage(image);
//            visibleFrame.setIconImage(image);
//        }catch(Exception e){
//            System.out.println("Appilcation icon not found");
//        }
//        java.net.URL url = ClassLoader.getSystemResource("cute img icon.jpg");


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
        label.setForeground(Color.BLACK);
        label.setBounds(10,20,400,30);
        label3.setBounds(10,25,400,30);
        label3.setForeground(Color.BLACK);
        label3.setFont(font);
        label2.setBounds(10,70,300,30);
        button.setBounds(250,110,140,20);
        button2.setBounds(250,110,140,20);

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(button);
        panel.add(button2);
        label2.setVisible(false);
        button2.setVisible(false);
        panel.repaint();
        invisibleFrame.setBounds(70, 30,400,100);
        invisibleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        invisibleFrame.setVisible(true);
        visibleFrame.setTitle("Quotes Displayer");
        visibleFrame.setBounds(70, 30,400,100);
        visibleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        visibleFrame.setVisible(false);
        _setButtonColor();
    }
    public Color getTransparentColor(final boolean a){
        if(a) color = new Color(1.0f,1.0f,1.0f,0.5f);
        else color = new Color(1.0f,1.0f,1.0f,1.0f);
        return color;
    }
    public void _setButtonColor(){
        button.setBackground(getTransparentColor(true));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button.setForeground(Color.BLACK);
        button2.setBackground(getTransparentColor(true));
        button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button2.setForeground(Color.BLACK);
    }
    public void _frameInvisible(final boolean yes,final Color labelcolor){

        label.setForeground(labelcolor);
        label2.setForeground(labelcolor);
        label3.setForeground(Color.BLACK);
        invisibleFrame.setVisible(!yes);
        visibleFrame.setVisible(yes);
        _setLocation(!yes);
    }
    public void _setLocation(final boolean a) {
        final int b = 22;
        if (a) {
            label.setLocation(10,22);
            label2.setLocation(10, 70);
            button.setLocation(25, 110);
            button2.setLocation(25, 110);
        } else {
            label.setLocation(10, 0);
            label2.setLocation(10, 70 - b);
            button.setLocation(25, 110 - b);
            button2.setLocation(25, 110 - b);
        }
    }

}
