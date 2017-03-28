import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Timer;

/**
 * Created by emmettna on 24/3/17.
 */
public class Control {
    private Ui_Init ui = new Ui_Init();
    private FileInput fi;
    private Dimension dim;
    int count;
    private Timer t;

    Control() {
        count = 100;

        fi = new FileInput();
        generateIdioms();
        dim = new Dimension(400,150);
        ui.invisibleFrame.setBounds(70,80,400,100);
        ui.invisibleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.invisibleFrame.setVisible(true);

        ui.visibleFrame.setTitle("Quotes Displayer");
        ui.visibleFrame.setBounds(ui.invisibleFrame.getBounds());
        ui.visibleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.visibleFrame.setVisible(false);
        _setButtonColor(Color.WHITE,Color.BLACK,Color.GRAY);

        ui.button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ui.button.setVisible(false);
                ui.label2.setVisible(true);
                ui.button2.setVisible(true);
            }
        });
        ui.button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tapNextButton();
            }
        });
        ui.invisibleFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
//                if(count<=150){
//                t.start();}
                
                ui.visibleFrame.add(ui.panel);
                _frameInvisible(true, Color.BLACK);
                _setButtonColor(Color.WHITE, Color.BLACK, Color.GRAY);
            }});

        ui.visibleFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
//                if(count>100){
//                t.start();}

                ui.visibleFrame.setSize(400,count);
                ui.invisibleFrame.setLocation(ui.visibleFrame.getLocation());
                ui.invisibleFrame.setSize(ui.visibleFrame.getSize());
                ui.invisibleFrame.add(ui.panel);
                _frameInvisible(false,Color.WHITE);
                _setButtonColor(new Color(1.0f,1.0f,1.0f,0.23f),Color.WHITE,Color.WHITE);


            }
        });
        ui.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
//                t.start();
                ui.invisibleFrame.setLocation(ui.visibleFrame.getLocation());
                ui.invisibleFrame.add(ui.panel);
                _frameInvisible(false,Color.WHITE);
                _setButtonColor(new Color(1.0f,1.0f,1.0f,0.23f),Color.WHITE,Color.WHITE);

            }
        });
//        System.out.println(dim)
    }
    private void _setButtonColor(final Color background,final Color border,final Color foreground){

        ui.button.setBackground(background);
        ui.button.setBorder(BorderFactory.createLineBorder(border));
        ui.button.setForeground(foreground);
        ui.button2.setBackground(background);
        ui.button2.setBorder(BorderFactory.createLineBorder(border));
        ui.button2.setForeground(foreground);
    }
    private void _frameInvisible(final boolean yes,final Color labelcolor){

        ui.label.setForeground(labelcolor);
        ui.label2.setForeground(labelcolor);
        ui.invisibleFrame.setVisible(!yes);
        ui.visibleFrame.setVisible(yes);
        _setLocation(!yes);
    }

    private void _setLocation(final boolean a) {
        final int b = 22;
        if (a) {
            ui.label.setLocation(10, 30);
            ui.label2.setLocation(10, 70);
            ui.button.setLocation(250, 110);
            ui.button2.setLocation(250, 110);
        } else {
            ui.label.setLocation(10, 30 - b);
            ui.label2.setLocation(10, 70 - b);
            ui.button.setLocation(250, 110 - b);
            ui.button2.setLocation(250, 110 - b);
        }

    }
    private int randomNumber(){
        final int randomNum = ThreadLocalRandom.current().nextInt(0,fi.list.size());
        return randomNum;
    }
    //If statement kinda stinks We gonna get back to this later.
    private void generateIdioms() {
        int rn = randomNumber()%fi.list.size();
        if(rn%2!=0){
            rn -= 1;
            if(rn == rn)
                generateIdioms();
        }
        System.out.println(rn);
        ui.label.setText(fi.list.get(rn));
        ui.label2.setText(fi.list.get(rn + 1));
        }
    private void tapNextButton(){
//        generateIdioms();
        ui.label.setText(fi.list.get(244));
        ui.label2.setText(fi.list.get(245));
        ui.label.setVisible(true);
        ui.button.setVisible(true);
        ui.label2.setVisible(false);
        ui.button2.setVisible(false);
    }
}