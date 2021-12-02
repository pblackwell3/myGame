import java.awt.Component;

import javax.swing.*;

class app {

    private static void initWindow() {
        JFrame window = new JFrame("This is my first time doing this");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Component board = new BoardGame();

        window.add(board);

        window.setResizable(false);

        window.pack();

        window.setLocationRelativeTo(null);

        window.setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initWindow();
            }
        });
    }
  
}
