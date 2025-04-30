import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ColaSuperHeroe cola = new ColaSuperHeroe();

        cola.agregarHeroe(new SuperHeroe(1, "Iron Man", "Marvel", 90, "Vuelo"));
        cola.agregarHeroe(new SuperHeroe(2, "Superman", "DC", 100, "Vuelo"));
        cola.agregarHeroe(new SuperHeroe(3, "Flash", "DC", 85, "Velocidad"));

        JLabel label = new JLabel();
        double sumaPoder = cola.sumarPoderPorHabilidad("Vuelo");
        label.setText("Suma de nivel de poder (Vuelo): " + sumaPoder);

        JOptionPane.showMessageDialog(null, label);
    }
}