import javax.swing.*;


public class Main {
    static JFrame frame = new JFrame("primera pantalla");
    public static void main(String[] args) {
        frame.setContentPane(new forma1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 450);
        frame.setVisible(true);
    }
}