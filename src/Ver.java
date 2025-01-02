import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class Ver {
    public JButton menuButton;
    public JLabel titulo;
    public JLabel Resultados;
    public JPanel VER;
    public JButton verButton;

    public Ver() {
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


        verButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/registros"; // URL de la base de datos
                String user = "root"; // Usuario
                String password = "123456"; // Contraseña

                try (Connection conn = DriverManager.getConnection(url, user, password)) {
                    String query = "SELECT * FROM jugadores";
                    try (PreparedStatement BDD = conn.prepareStatement(query);
                         ResultSet resultado = BDD.executeQuery()) {

                        // Construir un String con los resultados
                        StringBuilder resultados = new StringBuilder("<html>");
                        while (resultado.next()) {
                            resultados.append("ID: ").append(resultado.getInt("id_jugador"))
                                    .append(", Nombre: ").append(resultado.getString("nombre"))
                                    .append(", Posición: ").append(resultado.getString("posicion"))
                                    .append(", Equipo: ").append(resultado.getString("equipo"))
                                    .append(", Edad: ").append(resultado.getInt("edad"))
                                    .append("<br>");
                        }
                        resultados.append("</html>");

                        // Mostrar resultados en el JLabel
                        Resultados.setText(resultados.toString());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al recuperar los datos.");
                }
            }
        });
    }
}
