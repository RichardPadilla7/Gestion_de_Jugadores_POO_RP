import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*; // Nos ayuda a trabajar con bases de datos en Java utilizando JDBC


public class Eliminar {
    public JTextField textField1;
    public JButton eliminarButton;
    public JButton menuButton;
    public JLabel titulo;
    public JPanel ELIMINAR;

    public Eliminar() {
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Conexión a la base de datos
                String url = "jdbc:mysql://localhost:3306/registros"; // URL de la base de datos
                String user = "root"; // Usuario
                String password = "123456"; // Contraseña

                // Obtener el ID del jugador desde el campo de texto
                String idJugador = textField1.getText();

                // Validar que el campo no esté vacío
                if (idJugador.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa el ID del jugador.");
                    return;
                }

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Consulta SQL para eliminar un jugador
                    String query = "DELETE FROM jugadores WHERE id_jugador = ?";
                    try (PreparedStatement BDD = conn.prepareStatement(query)) {
                        BDD.setInt(1, Integer.parseInt(idJugador)); // Establecer el ID

                        // Ejecutar la consulta
                        int rowsAffected = BDD.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Jugador eliminado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró un jugador con ese ID.");
                        }

                        // Limpiar el campo de texto
                        textField1.setText("");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al eliminar el jugador.");
                }
            }
        });

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Menu");
                frame.setContentPane(new MENU().MENU);
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
