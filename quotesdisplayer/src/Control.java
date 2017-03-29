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
public class Control extends Thread {
    private Ui_Init ui = new Ui_Init();
    private FileInput fi;
    private int _height, _width;
    private Timer t, t2;

    Control() {
        _width = 400;
        _height = 100;
        fi = new FileInput();
        ui.panel.repaint();
        generateIdioms();
        ui.invisibleFrame.setBounds(70, 30,_width,_height);
        ui.invisibleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.invisibleFrame.setVisible(true);

        ui.visibleFrame.setTitle("Quotes Displayer");
        ui.visibleFrame.setBounds(ui.invisibleFrame.getBounds());
        ui.visibleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.visibleFrame.setVisible(false);
        _setButtonColor(ui.getTransparentColor(true),Color.BLACK,Color.GRAY);

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
                if(t2.isRunning())t2.stop();
                t.start();
                ui.visibleFrame.add(ui.panel);
                _frameInvisible(true, Color.BLACK);
                _setButtonColor(ui.getTransparentColor(true), Color.BLACK, Color.BLACK);
            }});
        ui.visibleFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if(t.isRunning())t.stop();
                t2.start();
                ui.invisibleFrame.setLocation(ui.visibleFrame.getLocation());
                ui.invisibleFrame.setSize(ui.visibleFrame.getSize());
                ui.invisibleFrame.add(ui.panel);
                _frameInvisible(false,Color.BLACK);
                _setButtonColor(ui.getTransparentColor(true),Color.BLACK,Color.BLACK);

            }
        });
        ui.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if(t2.isRunning())t2.stop();
                t.start();
                ui.visibleFrame.add(ui.panel);
                _frameInvisible(true, Color.BLACK);
                _setButtonColor(ui.getTransparentColor(true), Color.BLACK, Color.BLACK);

            }
        });
        ui.button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                if(t2.isRunning())t2.stop();
                t.start();
            }
        });
        t = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(_height <150){
                ui.visibleFrame.setSize(_width, _height);
                ui.invisibleFrame.setSize(_width, _height);
                System.out.println("getting bigger");
                _height += 3;}
                if(_height >=150){
                    ((Timer)e.getSource()).stop();
                    System.out.println(_height);
                    _height =150;

                }
            }
        });
        t2 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(_height >100){
                    ui.visibleFrame.setSize(_width, _height);
                    ui.invisibleFrame.setSize(_width, _height);
                    System.out.println("getting smaller");
                    _height -= 3;}
                if(_height <=100){
                    ((Timer)e.getSource()).stop();
                    System.out.println(_height);
                    _height =100;

                }
            }
        });

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
        ui.label3.setForeground(Color.BLACK);
        ui.label3.setBackground(new Color(0,0,0,0));
        ui.invisibleFrame.setVisible(!yes);
        ui.visibleFrame.setVisible(yes);
        _setLocation(!yes);
    }

    private void _setLocation(final boolean a) {
        final int b = 22;
        if (a) {
            ui.label.setLocation(10,22);
            ui.label2.setLocation(10, 70);
            ui.button.setLocation(250, 110);
            ui.button2.setLocation(250, 110);
        } else {
            ui.label.setLocation(10, 0);
            ui.label2.setLocation(10, 70 - b);
            ui.button.setLocation(250, 110 - b);
            ui.button2.setLocation(250, 110 - b);
        }

    }
    private int randomNumber(){
        final int randomNum = ThreadLocalRandom.current().nextInt(0,fi.getList().size());
        return randomNum;
    }
    //If statement kinda stinks We gonna get back to this later.
    private void generateIdioms() {
        int rn = randomNumber()%fi.getList().size();
        if(rn%2!=0){
            rn -= 1;
            if(rn == rn)
                generateIdioms();
        }
        System.out.println(rn);
        System.out.println(fi.getList().get(rn).toString());// When the line is too long, it needs to down under
        ui.label.setText(fi.getList().get(rn));
//        ui.label3.setText();
        ui.label2.setText(fi.getList().get(rn + 1));
        }
    private void tapNextButton(){
        generateIdioms();
//        ui.label.setText(fi.getList().get(244));
//        ui.label2.setText(fi.getList().get(245));
//        ui.label3.setText(fi.getList().get(244));
        ui.label.setVisible(true);
        ui.button.setVisible(true);
        ui.label2.setVisible(false);
        ui.button2.setVisible(false);
    }
}