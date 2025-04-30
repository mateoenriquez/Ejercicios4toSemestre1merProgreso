import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class Ventana {
    private JPanel principal;
    private JComboBox cboPrioridad;
    private JTextField txtNombre;
    private JTextField txtSintomas;
    private JButton btnRegistro;
    private JList lstPacientes;
    private JButton btnAtender;
private Clinica clinica=new Clinica();

public void llenarJList(){
    DefaultListModel dlm=new DefaultListModel();
    List<Paciente> ordenada=clinica.listarPacientes();
   // Collections.sort(ordenada);
    for(Paciente p:ordenada){
        dlm.addElement(p.toString());
    }
    lstPacientes.setModel(dlm);
}

    public Ventana() {
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int p=Integer.parseInt(cboPrioridad.getSelectedItem().toString());
                String nombre=txtNombre.getText();
                String sintomas=txtSintomas.getText();
                clinica.encolar(new Paciente(p,nombre,sintomas));
                llenarJList();

            }
        });
        btnAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Paciente p=clinica.atender();
                    JOptionPane.showMessageDialog(null,
                            "Se atendio: "+p.toString());
                    llenarJList();

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
        frame.pack();
        frame.setVisible(true);
    }
}
