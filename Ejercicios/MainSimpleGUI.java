import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> crearVentana());
    }

    public static void crearVentana() {
        JFrame frame = new JFrame("Superhéroes GUI Simple");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2));
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField universoField = new JTextField();
        JTextField poderField = new JTextField();
        JTextField habilidadField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("Universo:"));
        panel.add(universoField);
        panel.add(new JLabel("Nivel de Poder:"));
        panel.add(poderField);
        panel.add(new JLabel("Habilidad:"));
        panel.add(habilidadField);

        JButton agregarBtn = new JButton("Agregar");
        JTextArea resultado = new JTextArea();
        resultado.setEditable(false);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(agregarBtn, BorderLayout.CENTER);
        frame.add(new JScrollPane(resultado), BorderLayout.SOUTH);

        agregarBtn.addActionListener(e -> {
            String datos = "ID: " + idField.getText() + ", Nombre: " + nombreField.getText() +
                           ", Universo: " + universoField.getText() + ", Poder: " + poderField.getText() +
                           ", Habilidad: " + habilidadField.getText();
            resultado.setText("Superhéroe ingresado:
" + datos);
        });

        frame.setVisible(true);
    }
}