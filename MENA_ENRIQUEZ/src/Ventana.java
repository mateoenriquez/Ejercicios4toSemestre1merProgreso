import javax.swing.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class Ventana {

    private JPanel panelPrincipal;
    private JTextField txtCedula;
    private JTextField txtCantidad;
    private JComboBox<String> cboPeliculas;
    private JButton btnComprar;
    private JButton btnEditar;
    private JTextArea txtResumen;
    private JLabel lblMensaje;
    private ColaCompras lista = new ColaCompras();


    public Ventana() {

        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cedula = txtCedula.getText();
                    String pelicula = cboPeliculas.getSelectedItem().toString();
                    int cantidad = Integer.parseInt(txtCantidad.getText());

                    lista.encolarCompra(new Compra(cedula, pelicula, cantidad));
                    lblMensaje.setText("Compra realizada con éxito.");

                } catch (ColaCompras.CedulaDuplicadaException | ColaCompras.SalaLlenaException | ColaCompras.ExcesoEntradasException ex) {
                    lblMensaje.setText("Error: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    lblMensaje.setText("Error: cantidad inválida.");
                }

                txtResumen.setText(lista.listarCompras());
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String cedula = txtCedula.getText();
                    String pelicula = cboPeliculas.getSelectedItem().toString();
                    int cantidad = Integer.parseInt(txtCantidad.getText());

                    lista.editarCompra(cedula, pelicula, cantidad);
                    lblMensaje.setText("Compra editada exitosamente.");
                } catch (ColaCompras.SalaLlenaException | ColaCompras.ExcesoEntradasException |
                         ColaCompras.SinCambiosException ex) {
                    lblMensaje.setText("Error: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    lblMensaje.setText("Error: cantidad inválida.");
                }

                txtResumen.setText(lista.listarCompras());
            }
        });


    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Cine");

        frame.setContentPane(new Ventana().panelPrincipal);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 400);

        frame.setVisible(true);

    }

}

