/**
 * Created by emmettna on 24/3/17.
 */

import javax.swing.*;
import java.awt.*;
import com.apple.eawt.Application;

public class Ui_Init {

    public JLabel label, label2, label3;
    public JButton meaningButton, nextButton, previousButton;
    public ImagePanel panel;
    public JFrame visibleFrame, invisibleFrame;
    private Color color;

    Ui_Init(){
        label = new JLabel();
        label3 = new JLabel();
        label2 = new JLabel();
        meaningButton = new JButton("Check the meaning");
        nextButton = new JButton("Tap to for Next");
        previousButton = new JButton("Back to Previous");
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
        label.setForeground(Color.BLACK);
        label.setBounds(10,20,400,30);
        label3.setBounds(10,47,400,30);
        label3.setForeground(Color.BLACK);
        label3.setFont(font);
        label2.setBounds(10,70,300,30);
        meaningButton.setBounds(250,110,140,20);
        nextButton.setBounds(250,110,140,20);
        previousButton.setBounds(24,110,140,20);

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        panel.add(meaningButton);
        panel.add(nextButton);
        panel.add(previousButton);
        label2.setVisible(false);
        nextButton.setVisible(false);
        previousButton.setVisible(true);
        panel.repaint();
        invisibleFrame.setTitle("Quotes Displayer");
        invisibleFrame.setBounds(70, 30,400,100);
        Application.getApplication().setDockIconImage(new ImageIcon(getClass().getResource("iconimage.png")).getImage());
        invisibleFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconimage.png")));
        invisibleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        invisibleFrame.setVisible(true);
        visibleFrame.setTitle("Quotes Displayer");
        visibleFrame.setBounds(70, 30,400,100);
        visibleFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("iconimage.png")));
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
        meaningButton.setBackground(getTransparentColor(true));
        meaningButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        meaningButton.setForeground(Color.BLACK);
        nextButton.setBackground(getTransparentColor(true));
        nextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nextButton.setForeground(Color.BLACK);
        previousButton.setBackground(getTransparentColor(true));
        previousButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        previousButton.setForeground(Color.BLACK);
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
            label3.setLocation(10,44);
            meaningButton.setLocation(250, 110);
            nextButton.setLocation(250, 110);
            previousButton.setLocation(25,110);
        } else {
            label.setLocation(10, 0);
            label2.setLocation(10, 70 - b);
            label3.setLocation(10,44-b);
            meaningButton.setLocation(250, 110 - b);
            nextButton.setLocation(250, 110 - b);
            previousButton.setLocation(25,110-b);
        }
    }

}
