import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class BoardGame extends JPanel implements ActionListener, KeyListener {

    private final int DELAY = 25;

    private static final long serialVersionUID = 1234567890554342L;

    private Timer timer;

    private static final int targetWidth = 50;
    private static final int targetHeight = 50;


    private BufferedImage player;
    private int x;
    private int y;


    public BoardGame() {
        setPreferredSize(new Dimension(900,600));
        setBackground(Color.white);

        loadPlayerImage();

        x = 100;
        y = 50;

        timer = new Timer(DELAY,this);
        timer.start();
    }



    private void loadPlayerImage() {
        try {
            player = ImageIO.read(new File("images/player.jpeg"));
            player = resizeImage(player);

        } catch(IOException exc) {
            
            System.out.println("Error opening the image:" + exc.getMessage());

        }
    }

   public BufferedImage resizeImage(BufferedImage originalImage) throws IOException {

        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);

        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);

        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        return outputImage;
    }

  
    public void keyPressed(KeyEvent e){
        

    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override

    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit.getDefaultToolkit().sync();
        int tempX = 0;
        paintCheckerboard(g,tempX);
        g.drawImage(player,x,y,this);
    }

    public void paintCheckerboard(Graphics g, int tempX) {
        // if(tempX > 850) {
        //     return;
        // }
        // paintCheckerboard(g,tempX+=50);
        g.setColor(Color.GRAY);
        int tempY = -1;
        int toggle = 2;
        
        while(tempX < 900) {
            if(toggle == 1) {
                tempY = 50;
                toggle = 2;
            } else if(toggle == 2) {
                tempY = 0;
                toggle = 1;
            }
            while (tempY <= 600) {
                g.fillRect(tempX,tempY,50,50);
                tempY+=100;
            }
            tempX+=50;
        }
    }
    
}
