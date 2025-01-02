//Richard Padilla
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Frame que me permitira visualizar la interfaz grafica del Login
        JFrame frame = new JFrame("LOGIN");
        frame.setContentPane(new LOGIN().loginsito);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}