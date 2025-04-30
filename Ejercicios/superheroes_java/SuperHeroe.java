public class SuperHeroe implements Comparable<SuperHeroe> {
    int id;
    String nombre;
    String universo;
    int nivelPoder;
    String habilidad;

    public SuperHeroe() {
        this.id = 0;
        this.nombre = "SinNombre";
        this.universo = "Marvel";
        this.nivelPoder = 10;
        this.habilidad = "Fuerza";
    }

    public SuperHeroe(int id, String nombre, String universo, int nivelPoder, String habilidad) {
        this.id = id;
        this.nombre = nombre;
        this.universo = universo;
        this.nivelPoder = nivelPoder;
        this.habilidad = habilidad;
    }

    public double poderAjustado() {
        if (universo.equalsIgnoreCase("Marvel")) {
            return nivelPoder * 1.20;
        } else if (universo.equalsIgnoreCase("DC")) {
            return nivelPoder * 1.15;
        } else {
            return nivelPoder;
        }
    }

    @Override
    public int compareTo(SuperHeroe otro) {
        return Integer.compare(otro.nivelPoder, this.nivelPoder);
    }

    @Override
    public String toString() {
        return nombre + " (" + universo + ") - Poder: " + nivelPoder + " - Habilidad: " + habilidad;
    }
}