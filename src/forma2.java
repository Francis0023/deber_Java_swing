import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.*;
import java.lang.NullPointerException;

public class forma2 {
    JPanel panel2;
    private JTextArea textArea1;
    //private JScrollBar scrollBar1;
    //private JScrollPane scrollPane;

    public forma2(){

        // Agregar un evento para cargar la información al JTextArea
        cargarInformacion();
    }

    private void cargarInformacion() {
        try {
            String dburl = "jdbc:mysql://localhost:3306/valores";
            String dbusername = "root";
            String dbcontraseña = "f123456";

            Connection connection = DriverManager.getConnection(dburl, dbusername, dbcontraseña);

            String query = "SELECT * FROM info";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Limpiar el JTextArea antes de agregar nueva información
                textArea1.setText("");

                // Iterar sobre los resultados y agregar al JTextArea
                while (resultSet.next()) {
                    String bio = resultSet.getString("biografia");


                    // Agregar al JTextArea
                    textArea1.append(bio);
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos");
        }
    }

}
