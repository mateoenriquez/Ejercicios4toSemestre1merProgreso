import java.util.*;

public class ColaRobot {
    Queue<Robot> cola = new LinkedList<>();
    Set<Integer> codigosUnicos = new HashSet<>();

    public String encolarRobots() {
        StringBuilder salida = new StringBuilder("=== COLA DE ROBOTS ===\n");

        Robot r1 = new Robot();
        cola.offer(r1);
        codigosUnicos.add(r1.codigo);

        Robot[] robots = {
            new Robot(101, "Bumblebee", "Autobot", 70, "Velocidad"),
            new Robot(102, "Megatron", "Decepticon", 90, "Evolución"),
            new Robot(103, "Starscream", "Decepticon", 75, "Volar"),
            new Robot(104, "Ratchet", "Autobot", 65, "Medicina")
        };

        for (Robot r : robots) {
            if (codigosUnicos.add(r.codigo)) {
                cola.offer(r);
            }
        }

        for (Robot r : cola) {
            salida.append(r).append("\n");
        }
        return salida.toString();
    }

    public String mostrarValorAtaque() {
        StringBuilder salida = new StringBuilder("=== VALORES DE ATAQUE ===\n");

        for (Robot r : cola) {
            salida.append(r).append("\n");
            salida.append("Valor de ataque: ").append(r.calcularAtaque()).append("\n\n");
        }

        return salida.toString();
    }

    public String copiarPorFuncion(String funcionEspecifica) {
        Queue<Robot> nuevaCola = new LinkedList<>();
        StringBuilder salida = new StringBuilder("=== NUEVA COLA (Función: " + funcionEspecifica + ") ===\n");

        for (Robot r : cola) {
            if (r.funcion.equalsIgnoreCase(funcionEspecifica)) {
                nuevaCola.offer(r);
            }
        }

        if (nuevaCola.isEmpty()) {
            salida.append("No se encontraron robots con esa función.\n");
        } else {
            for (Robot r : nuevaCola) {
                salida.append(r).append("\n");
            }
        }

        return salida.toString();
    }
}