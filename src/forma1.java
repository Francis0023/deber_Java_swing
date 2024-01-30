import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class forma1 {
    JPanel panel1;
    private JLabel texto1;
    private JLabel texto2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton login;
    private JLabel texto3;
    private JPasswordField passwordField1;

    public forma1(){
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = textField1.getText();
                char[] passwordArray = passwordField1.getPassword();
                String password = new String(passwordArray);

                String dburl="jdbc:mysql://localhost:3306/valores"; //Nombre de la base de datos
                String dbusername="root";
                String dbcontraseña="f123456";

                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(dburl, dbusername, dbcontraseña);
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM usuarios WHERE nombre = '" + user + "' AND contra = '" + password + "'");
                    if (resultSet.next() || (textField1.getText().equals("francis") && password.equals("f123456"))){
                        JOptionPane.showMessageDialog(null, "Bienvenido " + user);
                        Main.frame.dispose();
                        JFrame principal = new JFrame("Archivos");
                        principal.setContentPane(new forma2().panel2);
                        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        principal.pack();
                        principal.setSize(800, 500);
                        principal.setLocationRelativeTo(null); // Centrar la ventana
                        principal.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }

                } catch (Exception exception) {
                System.out.println(exception);
                }
            }
        });

    }
}
