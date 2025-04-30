public class Compra {

   //Clase Compra junto a sus atributos

    private String cedula; //Cedula: Identificacion del cliente
    private String pelicula; //Pelicula: Nombre de las peliculas
    private int cantidad; //Cantidad: Numero de entradas que compro el usuario

    //Es generado el constructor tomando los atributos anteriormente aniadidos

    public Compra(String cedula, String pelicula, int cantidad) {
        this.cedula = cedula;
        this.pelicula = pelicula;
        this.cantidad = cantidad;
    }

    //Get en cedula para devolver la cedula del usuario

    public String getCedula() {
        return cedula;
    }

    //Getter and setter generado con pelicula y cantidad
    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //ToString generado para ser usado posteriormente en el TextArea de la clase Ventana
    @Override
    public String toString() {
        return "Película: " + pelicula + ", Cédula: " + cedula + ", Entradas: " + cantidad + "\n";
    }
}
