package contrllers;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Created by joebuntu on 3/24/17.
 */
public class ImagePanel extends JPanel {
        private Image img;

        public ImagePanel(String img) {
            this(new ImageIcon(img).getImage());
        }



        public ImagePanel(Image fee) {
            this.img = fee;
            fee.getScaledInstance(ImagePanel.WIDTH,ImagePanel.HEIGHT,Image.SCALE_SMOOTH);
            setLayout(null);
        }
// originalImage.getScaledInstance(jPanel.getWidth(),jPanel.getHeight(),Image.SCALE_SMOOTH);
        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, null);
        }



    }

