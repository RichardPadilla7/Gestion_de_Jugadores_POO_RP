import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Agregar {
    public JTextField textNombre;
    public JTextField textPosicion;
    public JTextField textEquipo;
    public JTextField textEdad;
    public JLabel titulo;
    public JLabel Nombre;
    public JLabel Posicion;
    public JLabel Equipo;
    public JLabel Edad;
    public JPanel AGREGAR;
    public JButton menuButton;
    public JButton agregarButton;

    public Agregar() {
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

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Conectar a la base de datos
                String url = "jdbc:mysql://localhost:3306/registros"; // URL de la base de datos
                String user = "root"; // Usuario
                String password = "123456"; // Contraseña

                // Capturar los datos ingresados por el usuario
                String nombre = textNombre.getText().trim();
                String posicion = textPosicion.getText().trim();
                String equipo = textEquipo.getText().trim();
                String edadTexto = textEdad.getText().trim();

                // Intentar convertir la edad a un entero
                int edad;
                try {
                    edad = Integer.parseInt(edadTexto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "La edad debe ser un número válido.");
                    return;
                }

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Consulta SQL para insertar un nuevo jugador
                    String query = "INSERT INTO jugadores (nombre, posicion, equipo, edad) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement BDD = conn.prepareStatement(query)) {
                        BDD.setString(1, nombre);
                        BDD.setString(2, posicion);
                        BDD.setString(3, equipo);
                        BDD.setInt(4, edad);

                        // Ejecutar la inserción
                        BDD.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Jugador agregado correctamente.");

                        // Limpiar los campos de texto
                        textNombre.setText("");
                        textPosicion.setText("");
                        textEquipo.setText("");
                        textEdad.setText("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al agregar el jugador a la base de datos.");
                }
            }
        });
    }
}
