import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Timer;

/**
 * Created by emmettna on 24/3/17.
 */
public class Control extends Thread {
    private Ui_Init ui = new Ui_Init();
    private FileInput fi;
    private Timer t, t2, t3;
    private ArrayList queue;
    Control() {
        queue = new ArrayList();
        fi = new FileInput();
        generateIdioms();
        setIntervalTime(300000);
        ui.meaningButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ui.meaningButton.setVisible(false);
                ui.label2.setVisible(true);
                ui.nextButton.setVisible(true);
            }
        });
        ui.nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                tapNextButton();
            }
        });
        ui.previousButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int rn = (int) queue.get(0);
                    System.out.println(rn);
                    if(fi.getList().get(rn).length()>40){
                        ui.label.setText(fi.getList().get(rn).substring(0,40));
                        ui.label3.setText(fi.getList().get(rn).substring(41));
                        ui.label2.setText(fi.getList().get(rn + 1));
                        pop();
                    }
                    else{
                        ui.label.setText(fi.getList().get(rn));
                        ui.label3.setText("");
                        ui.label2.setText(fi.getList().get(rn + 1));
                        pop();
                    }
                }catch (IndexOutOfBoundsException i){
                    ui.label.setText("#404 Page Not Found");
                    ui.label2.setText("20개 까지만 지원 됩니다");
                    ui.label2.setVisible(true);
                }


            }
        });
        ui.alwaysOnTopButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(ui.alwaysOnTopButton.isSelected()){
                    _setAlwaysOnTop(true);
                }
                else{
                    _setAlwaysOnTop(false);
                    System.out.println("clicked");
                }
            }
        });
        ui.invisibleFrame.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                super.mouseExited(e);

                if ((e.getX() >= -10 && e.getX() <= ui.visibleFrame.getBounds().width + 10) && (e.getY() >= -10 && e.getY() <= ui.visibleFrame.getBounds().height + 10)) {
                    t.stop();
                    t.start();
                    ui.visibleFrame.add(ui.panel);
                    ui._frameInvisible(true, Color.BLACK);
                    ui._setButtonColor();
                }
            }
        });
        ui.visibleFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if ((e.getX() < 0 || e.getX() > ui.invisibleFrame.getBounds().width - 10) || (e.getY() < 0 || e.getY() > ui.invisibleFrame.getBounds().height - 10)) {
                    t2.stop();
                    t2.start();
                    ui.invisibleFrame.setLocation(ui.visibleFrame.getLocation());
                    ui.invisibleFrame.setSize(ui.visibleFrame.getSize());
                    ui.invisibleFrame.add(ui.panel);
                    ui._frameInvisible(false, Color.BLACK);
                    ui._setButtonColor();
                }
            }
        });
        t = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t2.isRunning()) t2.stop();
                if (ui.visibleFrame.getBounds().height < 150) {
                    ui.visibleFrame.setSize(ui.visibleFrame.getBounds().width, ui.visibleFrame.getBounds().height);
                    ui.invisibleFrame.setSize(ui.visibleFrame.getBounds().width, ui.visibleFrame.getBounds().height);
                    System.out.println("↓");
                    ui.visibleFrame.setSize(ui.visibleFrame.getBounds().width, ui.visibleFrame.getBounds().height + 3);
                }
                if (ui.visibleFrame.getBounds().height >= 150) {
                    ((Timer) e.getSource()).stop();
                    System.out.println("Bottom");
                }
            }
        });
        t2 = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t.isRunning()) t.stop();
                if (ui.invisibleFrame.getBounds().height > 100) {
                    ui.invisibleFrame.setSize(ui.invisibleFrame.getBounds().width, ui.invisibleFrame.getBounds().height);
                    ui.visibleFrame.setSize(ui.invisibleFrame.getBounds().width, ui.invisibleFrame.getBounds().height);
                    System.out.println("↑");
                    ui.invisibleFrame.setSize(ui.invisibleFrame.getBounds().width, ui.invisibleFrame.getBounds().height - 3);
                }
                if (ui.invisibleFrame.getBounds().height <= 100) {
                    ((Timer) e.getSource()).stop();
                    System.out.println("Top");
                }
            }
        });
    }

    //If statement kinda stinks We gonna get back to this later.
    private void generateIdioms() {
        int rn = ThreadLocalRandom.current().nextInt(0,fi.getList().size());
        if(rn%2!=0){
            rn -= 1 ;
            if(rn == rn)rn += 2;
         }
        if(fi.getList().get(rn).length()>40){
            ui.label.setText(fi.getList().get(rn).substring(0,40));
            ui.label3.setText(fi.getList().get(rn).substring(41));
            push(rn);
            ui.label2.setText(fi.getList().get(rn + 1));

        }
        else{
            ui.label.setText(fi.getList().get(rn));
            ui.label3.setText("");
            push(rn);
            ui.label2.setText(fi.getList().get(rn + 1));
        }
    }
    private void tapNextButton(){
        generateIdioms();
        ui.label.setVisible(true);
        ui.meaningButton.setVisible(true);
        ui.label2.setVisible(false);
        ui.nextButton.setVisible(false);
    }
    private void push(int y){
        if(queue.size()>20) queue.remove(0); queue.add(y);
    }
    private void pop(){
        if(queue.size()>0) {queue.remove(0); System.out.println("here");}
        else if(queue.size()<=0){
            ui.label.setText("404 Page Not Found");
            ui.label3.setText("20개 까지만 지원 됩니다");
        }
    }
    /* setTime button will be added soon */
    private void setIntervalTime(final int a){
        System.out.println("got setintervaltime");

            t3 = new Timer(a, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("got here");
                tapNextButton();
            }

        });
            if(!t3.isRunning())t3.start();

    }
    private void _setAlwaysOnTop(boolean a){
        if (a){
            ui.visibleFrame.setAlwaysOnTop(a);
            ui.invisibleFrame.setAlwaysOnTop(a);
        }
        else{
            ui.visibleFrame.setAlwaysOnTop(a);
            ui.invisibleFrame.setAlwaysOnTop(a);
        }

    }
}