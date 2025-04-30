import javax.swing.*;
import java.awt.*;

public class AppSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ColaRobot cola = new ColaRobot();

            JFrame frame = new JFrame("Transformers - Evaluación P1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

            JScrollPane scrollPane = new JScrollPane(textArea);
            frame.add(scrollPane);

            StringBuilder output = new StringBuilder();
            output.append(cola.encolarRobots()).append("\n");
            output.append(cola.mostrarValorAtaque()).append("\n");
            output.append(cola.copiarPorFuncion("Volar"));

            textArea.setText(output.toString());
            frame.setVisible(true);
        });
    }
}