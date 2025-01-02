import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MENU {
    public JButton verJugadoresButton;
    public JButton agregarJugadoresButton;
    public JButton buscarJugadoresButton;
    public JButton eliminarJugadoresButton;
    public JLabel titulo;
    public JPanel MENU;

    public MENU() {
        verJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Ver Jugadores");
                frame.setContentPane(new Ver().VER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setPreferredSize(new Dimension(300, 300));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });

        agregarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Agregar Jugadores");
                frame.setContentPane(new Agregar().AGREGAR);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setPreferredSize(new Dimension(300, 300));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });

        buscarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Buscar Jugadores");
                frame.setContentPane(new Buscar().BUSCAR);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setPreferredSize(new Dimension(300, 300));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });

        eliminarJugadoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Eliminar Jugadores");
                frame.setContentPane(new Eliminar().ELIMINAR);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500, 300);
                frame.setPreferredSize(new Dimension(300, 300));
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
