import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class ColaCompras {

    //Queue para manejar el orden de llegada de las compras
    //Arraylist para la edicion de la lista de compras
    private Queue<Compra> compras;
    private ArrayList<Compra> listaCompras;

    //Es inicializado los atributos desde cero, como contadores

    private int entradasXmen = 0;
    private int entradasMario = 0;
    private int entradasBatman = 0;

    //Arranca la cola y las listas vacias

    public ColaCompras() {
        compras = new ArrayDeque<>();
        listaCompras = new ArrayList<>();
    }

    //Metodo para agregar una compra a la cola y a la lista

    public void encolarCompra(Compra compra) throws CedulaDuplicadaException, SalaLlenaException, ExcesoEntradasException {
        if (cedulaYaExiste(compra.getCedula())) {
            throw new CedulaDuplicadaException("La cédula ya tiene una compra registrada.");
        }
        if (compra.getCantidad() > 3 || compra.getCantidad() < 1) {
            throw new ExcesoEntradasException("Numero de entradas invalido, solo de 1 a 3 entradas");
        }
        if (!validarCantidad(compra.getPelicula(), compra.getCantidad())) {
            throw new SalaLlenaException("No hay suficientes entradas disponibles para esa película.");
        }

        compras.add(compra);
        listaCompras.add(compra);
        aumentarContador(compra.getPelicula(), compra.getCantidad());
    }


    public void editarCompra(String cedula, String nuevaPelicula, int nuevaCantidad) throws SalaLlenaException, ExcesoEntradasException, SinCambiosException {
        for (Compra compra : listaCompras) {
            if (compra.getCedula().equals(cedula)) {
                if (compra.getPelicula().equals(nuevaPelicula) && compra.getCantidad() == nuevaCantidad) {
                    throw new SinCambiosException("No hubo cambios en la compra.");
                }

                disminuirContador(compra.getPelicula(), compra.getCantidad());

                if (nuevaCantidad > 3 || nuevaCantidad < 1) {
                    aumentarContador(compra.getPelicula(), compra.getCantidad());
                    throw new ExcesoEntradasException("Numero de entradas invalido, solo de 1 a 3 entradas.");
                }

                if (!validarCantidad(nuevaPelicula, nuevaCantidad)) {
                    aumentarContador(compra.getPelicula(), compra.getCantidad());
                    throw new SalaLlenaException("No hay suficientes entradas disponibles.");
                }

                compra.setPelicula(nuevaPelicula);
                compra.setCantidad(nuevaCantidad);
                aumentarContador(nuevaPelicula, nuevaCantidad);
                return;
            }
        }

        throw new SinCambiosException("No se encontró una compra con esa cédula.");
    }


    private boolean cedulaYaExiste(String cedula) {
        for (Compra c : listaCompras) {
            if (c.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    private boolean validarCantidad(String pelicula, int cantidad) {
        if (cantidad < 1 || cantidad > 3) return false;
        int total = 0;
        if (pelicula.equals("XMEN")) total = entradasXmen;
        if (pelicula.equals("MARIO")) total = entradasMario;
        if (pelicula.equals("BATMAN")) total = entradasBatman;
        return total + cantidad <= 20;
    }

    private void aumentarContador(String pelicula, int cantidad) {
        if (pelicula.equals("XMEN")) entradasXmen += cantidad;
        if (pelicula.equals("MARIO")) entradasMario += cantidad;
        if (pelicula.equals("BATMAN")) entradasBatman += cantidad;
    }

    private void disminuirContador(String pelicula, int cantidad) {
        if (pelicula.equals("XMEN")) entradasXmen -= cantidad;
        if (pelicula.equals("MARIO")) entradasMario -= cantidad;
        if (pelicula.equals("BATMAN")) entradasBatman -= cantidad;
    }

    public String listarCompras() {
        StringBuilder sb = new StringBuilder();
        for (Compra compra : listaCompras) {
            sb.append(compra.toString());
        }
        return sb.toString();
    }

    public class ExcesoEntradasException extends Exception {
        public ExcesoEntradasException(String mensaje) {
            super(mensaje);
        }
    }

    public class CedulaDuplicadaException extends Exception {
        public CedulaDuplicadaException(String mensaje) {
            super(mensaje);
        }
    }

    public class SalaLlenaException extends Exception {
        public SalaLlenaException(String mensaje) {
            super(mensaje);
        }
    }

    public class SinCambiosException extends Exception {
        public SinCambiosException(String mensaje) {
            super(mensaje);
        }
    }

}
