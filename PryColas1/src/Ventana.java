import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JComboBox cboModelo;
    private JTextField txtAnio;
    private JButton btnAgregar;
    private JButton btnDesencolar;
    private JTextArea txtListarAutos;
    private JLabel lblMensaje;
    private ColaAutos listaAutos=new ColaAutos();

    public Ventana() {
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelo=cboModelo.getSelectedItem().toString();
                int anio=Integer.parseInt(txtAnio.getText());
                listaAutos.encolar(new Auto(modelo,anio));
                txtListarAutos.setText(listaAutos.listarAutos());
            }
        });
        btnDesencolar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   Auto autox= listaAutos.desencolar();
                   txtListarAutos.setText(listaAutos.listarAutos());
                   lblMensaje.setText("Auto atendido "+autox+" debe pagar $50");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setSize(600,400);
        frame.setVisible(true);
    }
}
