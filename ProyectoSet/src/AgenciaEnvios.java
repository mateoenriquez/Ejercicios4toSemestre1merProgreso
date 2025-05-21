import java.util.LinkedHashSet;
import java.util.Set;

public class AgenciaEnvios {

    private Set<Paquete> listaPaquete;

    public AgenciaEnvios() {
        listaPaquete = new LinkedHashSet<>();
    }

    public boolean agregar(Paquete p){
        return listaPaquete.add(p);
    }

    public String listar(){
        StringBuilder sb=new StringBuilder();
        for (Paquete p:listaPaquete){
            sb.append(p.toString()+"\n");
        }
        return toString();
    }
}
