import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardGame extends JPanel implements ActionListener {

    private final int DELAY = 25;

    private static final long serialVersionUID = 1234567890554342L;

    private Timer timer;

    private BufferedImage player;
    private int x;
    private int y;


    public BoardGame() {
        setPreferredSize(new Dimension(900,600));
        setBackground(new Color(232,232,232));

        loadPlayerImage();

        x = 100;
        y = 30;

        timer = new Timer(DELAY,this);
        timer.start();
    }

    private void loadPlayerImage() {
        try {

            player = ImageIO.read(new File("images/player.jpeg"));

        } catch(IOException exc) {
            
            System.out.println("Error opening the image:" + exc.getMessage());

        }
    }

    public void transformImage() {
        
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {

        x += 2;
        y += 2;

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(player,x,y,this);

        Toolkit.getDefaultToolkit().sync();
    }
}
