import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Buscar {
    public JTextField textBuscarNombre;
    public JLabel Busqueda;
    public JButton bottonBuscar;
    public JLabel titulo;
    public JButton menuButton;
    public JPanel BUSCAR;

    public Buscar() {
        bottonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Conexión a la base de datos
                String url = "jdbc:mysql://localhost:3306/registros"; // URL de la base de datos
                String user = "root"; // Usuario
                String password = "123456"; // Contraseña

                // Capturar el nombre ingresado por el usuario
                String nombreBuscar = textBuscarNombre.getText();

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Consulta SQL para buscar un jugador por nombre
                    String query = "SELECT * FROM jugadores WHERE nombre = ?";
                    try (PreparedStatement BDD = conn.prepareStatement(query)) {
                        BDD.setString(1, nombreBuscar);

                        try (ResultSet resultado = BDD.executeQuery()) {
                            // Verificar si se encontró algún registro
                            if (resultado.next()) {
                                StringBuilder detalles = new StringBuilder("<html>");
                                detalles.append("ID: ").append(resultado.getInt("id_jugador")).append("<br>")
                                        .append("Nombre: ").append(resultado.getString("nombre")).append("<br>")
                                        .append("Posición: ").append(resultado.getString("posicion")).append("<br>")
                                        .append("Equipo: ").append(resultado.getString("equipo")).append("<br>")
                                        .append("Edad: ").append(resultado.getInt("edad")).append("<br>");
                                detalles.append("</html>");

                                // Mostrar los detalles en el JLabel
                                Busqueda.setText(detalles.toString());

                            } else {
                                Busqueda.setText("Jugador no encontrado.");
                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al buscar el jugador.");
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
