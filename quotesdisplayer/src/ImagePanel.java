/**
 * Created by emmettna on 29/3/17.
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

    public class ImagePanel extends JPanel{

        private BufferedImage image;

        public ImagePanel() {
            try {
                image = ImageIO.read(new File("cutecloud.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

    }