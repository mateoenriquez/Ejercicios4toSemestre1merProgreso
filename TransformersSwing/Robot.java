public class Robot {
    int codigo;
    String nombre;
    String faccion;
    int poder;
    String funcion;

    public Robot() {
        this.codigo = 100;
        this.nombre = "Optimus";
        this.faccion = "Autobot";
        this.poder = 80;
        this.funcion = "Liderazgo";
    }

    public Robot(int codigo, String nombre, String faccion, int poder, String funcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.faccion = faccion;
        this.poder = poder;
        this.funcion = funcion;
    }

    public double calcularAtaque() {
        if (faccion.equalsIgnoreCase("Autobot")) {
            return poder * 1.25;
        } else if (faccion.equalsIgnoreCase("Decepticon")) {
            return poder * 1.10;
        }
        return poder;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Facción: " + faccion +
               ", Poder: " + poder + ", Función: " + funcion;
    }
}