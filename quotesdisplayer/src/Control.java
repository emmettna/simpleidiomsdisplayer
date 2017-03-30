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
        ui.visibleFrame.setBounds(70, 30,_width,_height);
        ui.visibleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.visibleFrame.setVisible(false);
        _setButtonColor();
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
                t.stop();
                t.start();
                ui.visibleFrame.add(ui.panel);
                _frameInvisible(true, Color.BLACK);
                _setButtonColor();
            }});

        ui.visibleFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                t2.stop();
                t2.start();
                ui.invisibleFrame.setLocation(ui.visibleFrame.getLocation());
                ui.invisibleFrame.setSize(ui.visibleFrame.getSize());
                ui.invisibleFrame.add(ui.panel);
                _frameInvisible(false,Color.BLACK);
                _setButtonColor();

            }
        });
        ui.button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                t.stop();
                t.start();
                ui.visibleFrame.add(ui.panel);
                _frameInvisible(true, Color.BLACK);
                _setButtonColor();

            }
        });
        ui.button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                t.stop();
                t.start();
            }
        });

        t = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t2.isRunning())t2.stop();
                if(_height <150){
                ui.visibleFrame.setSize(_width, _height);
                ui.invisibleFrame.setSize(_width, _height);
                System.out.println("↓");
                _height += 3;
                }
                if(_height >=150){
                    ((Timer)e.getSource()).stop();
                    System.out.println("Bottom");
                }
            }
        });
        t2 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t.isRunning())t.stop();
                if(_height >100){
                    ui.visibleFrame.setSize(_width, _height);
                    ui.invisibleFrame.setSize(_width, _height);
                    System.out.println("↑");
                    _height -= 3;
                }
                if(_height <=100){
                    ((Timer)e.getSource()).stop();
                    System.out.println("Top");
                }
            }
        });
    }

    public void heightUpDown(boolean a){
        if(a)_height += 3;
        else _height -= 3;
    }
    private void _setButtonColor(){
        ui.button.setBackground( ui.getTransparentColor(true));
        ui.button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ui.button.setForeground(Color.BLACK);
        ui.button2.setBackground( ui.getTransparentColor(true));
        ui.button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ui.button2.setForeground(Color.BLACK);
    }
    private void _frameInvisible(final boolean yes,final Color labelcolor){

        ui.label.setForeground(labelcolor);
        ui.label2.setForeground(labelcolor);
        ui.label3.setForeground(Color.BLACK);
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

    //If statement kinda stinks We gonna get back to this later.
    private void generateIdioms() {
        int rn = ThreadLocalRandom.current().nextInt(0,fi.getList().size());
        System.out.println(rn +"randome number");
        if(rn%2!=0){
            rn -= 1;
            if(rn == rn)
                rn += 2;
        }
        if(fi.getList().get(rn).length()>40){
            ui.label.setText(fi.getList().get(rn).substring(0,40));
            ui.label3.setText(fi.getList().get(rn).substring(41));
            ui.label2.setText(fi.getList().get(rn + 1));
        }
        else{
            ui.label.setText(fi.getList().get(rn));
            ui.label3.setText("");
            ui.label2.setText(fi.getList().get(rn + 1));
        }
        }
    private void tapNextButton(){
        generateIdioms();
        ui.label.setVisible(true);
        ui.button.setVisible(true);
        ui.label2.setVisible(false);
        ui.button2.setVisible(false);
    }
}