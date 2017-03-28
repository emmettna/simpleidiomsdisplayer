import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by emmettna on 24/3/17.
 */
public class Control {
    private Ui_Init ui = new Ui_Init();
    private FileInput fi;
    Control(){
        fi = new FileInput();
        ui.setTitle("Quotes Displayer");
        ui.setBounds(200,250,300,200);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
        generateIdioms();
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
        }
        System.out.println(rn);
        ui.label.setText(fi.list.get(rn));
        ui.label2.setText(fi.list.get(rn + 1));
        }
    private void tapNextButton(){
        ui.label.setVisible(true);
        ui.button.setVisible(true);
        ui.label2.setVisible(false);
        ui.button2.setVisible(false);
        generateIdioms();
    }

}
