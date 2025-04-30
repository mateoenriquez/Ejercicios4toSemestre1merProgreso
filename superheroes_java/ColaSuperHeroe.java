import java.util.PriorityQueue;

public class ColaSuperHeroe {
    PriorityQueue<SuperHeroe> cola;

    public ColaSuperHeroe() {
        cola = new PriorityQueue<>();
    }

    public void agregarHeroe(SuperHeroe h) {
        cola.offer(h);
    }

    public double sumarPoderPorHabilidad(String habilidadFiltro) {
        double suma = 0;
        for (SuperHeroe h : cola) {
            if (h.habilidad.equalsIgnoreCase(habilidadFiltro)) {
                suma += h.nivelPoder;
            }
        }
        return suma;
    }

    public String mostrarCola() {
        StringBuilder sb = new StringBuilder();
        for (SuperHeroe h : cola) {
            sb.append(h.toString()).append("\n");
        }
        return sb.toString();
    }
}