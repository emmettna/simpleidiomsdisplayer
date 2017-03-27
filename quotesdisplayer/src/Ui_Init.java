/**
 * Created by emmettna on 24/3/17.
 */

import javax.swing.*;
import java.awt.*;

public class Ui_Init extends JFrame {
    JButton button;
    JLabel label;
    JLabel label2;
    JButton button2;
    
    Ui_Init(){
        label = new JLabel("Patience makes perfect"/*getQuotes()*/);
        label2 = new JLabel("인내하는자만이 성공 할 수 있다");
        button = new JButton("Tap to see the meaning");
        button2 = new JButton("Next Quotes");


        Container container = getContentPane();
        SpringLayout layout = new SpringLayout();
        container.setLayout(layout);

        layout.putConstraint(SpringLayout.WEST,label,50,SpringLayout.WEST,container);
        layout.putConstraint(SpringLayout.NORTH,label,50,SpringLayout.NORTH,container);
        container.add(label);
        layout.putConstraint(SpringLayout.WEST,button,50,SpringLayout.WEST,container);
        layout.putConstraint(SpringLayout.NORTH,button,100,SpringLayout.NORTH,container);
        container.add(button);
        layout.putConstraint(SpringLayout.WEST,label2,50,SpringLayout.WEST,container);
        layout.putConstraint(SpringLayout.NORTH,label2,100,SpringLayout.NORTH,container);
        container.add(label2);
        label2.setVisible(false);
        layout.putConstraint(SpringLayout.WEST,button2,50,SpringLayout.WEST,container);
        layout.putConstraint(SpringLayout.NORTH,button2,120,SpringLayout.NORTH,container);
        container.add(button2);
        button2.setVisible(false);

    }

}
