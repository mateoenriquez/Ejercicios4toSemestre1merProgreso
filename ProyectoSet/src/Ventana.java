import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JTextField txtReceptor;
    private JSpinner spTrack;
    private JButton btnRegistrar;
    private JTextArea txtListado;
    private AgenciaEnvios agencia=new AgenciaEnvios();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idTrack=Integer.parseInt(spTrack.getValue().toString());
                String recep=txtReceptor.getText();
                Paquete p1=new Paquete(idTrack,recep,false);
                if (agencia.agregar(p1)){
                    txtListado.setText(agencia.listar());
                }else {
                    JOptionPane.showMessageDialog(null, "El objeto no es unico!!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
