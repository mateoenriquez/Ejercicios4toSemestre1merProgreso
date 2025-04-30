import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Clinica {

    private PriorityQueue<Paciente> listaPacientes;
    public Clinica(){
        listaPacientes=new PriorityQueue<>();
    }

    public void encolar(Paciente dato){
        listaPacientes.add(dato);
    }

    public Paciente atender() throws Exception{
        if(listaPacientes.isEmpty())
            throw new Exception("Ya no hay elementos");
        return listaPacientes.poll();
    }

    public List<Paciente> listarPacientes(){
        return listaPacientes.stream().collect(Collectors.toList());
    }
}
