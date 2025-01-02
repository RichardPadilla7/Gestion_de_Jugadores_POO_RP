//Richard Padilla
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LOGIN {
    public JPanel loginsito;
    public JTextField textField1;
    public JPasswordField passwordField1;
    public JButton iniciarSesionButton;


    public LOGIN() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Conectar a la base de

                String url = "jdbc:mysql://localhost:3306/registros"; // colocamos el nombre de la base de datos en este caso: registros
               // Aqui ingrersamos las credenciales a la cual queremos ingresar y en donde esta creada nuestra base de datos
                String user = "root"; // usuario para ingresar a la BDD
                String password = "123456"; // contraseña para ingresar a la BDD


                // Variables donde alamacenan las credenciales ingresadas en la GUI
                String correo = textField1.getText();
                String contrasenia = new String(passwordField1.getPassword());

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Aqui se busca en la base de datos si el usuario y contraseña existen
                    String query = "SELECT * FROM Usuarios WHERE usuario = ? AND contrasenia = ?";
                    try (PreparedStatement BDD = conn.prepareStatement(query)) {
                        BDD.setString(1, correo);
                        BDD.setString(2, contrasenia);

                        //Condiciones de contraseña y ususario de la base de datos
                        try (ResultSet busquedaMySQL = BDD.executeQuery()) {
                            if (busquedaMySQL.next()) {
                                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");

                                JFrame frame = new JFrame("Menu");
                                frame.setContentPane(new MENU().MENU);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.setSize(500, 300);
                                frame.setPreferredSize(new Dimension(300, 300));
                                frame.setLocationRelativeTo(null);
                                frame.pack();
                                frame.setVisible(true);

                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos!");
                            }
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en la base de datos.");
                }
            }
        });
    }
}
