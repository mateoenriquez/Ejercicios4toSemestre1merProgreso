public class Paquete {
    private int track;
    private String receptor;
    private boolean estado;

    public Paquete(int track, String receptor, boolean estado) {
        this.track = track;
        this.receptor = receptor;
        this.estado = estado;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Paquete" +
                "track=" + track +
                ", receptor='" + receptor + '\'' +
                ", estado=" + estado;
    }

    @Override
    public int hashCode() {
        int resultado=receptor.toLowerCase().hashCode();
        resultado=resultado*101+track;
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj==null || getClass()!=obj.getClass())
            return false;
        return track==((Paquete)obj).track && receptor.toLowerCase().equals((((Paquete)obj).receptor.toLowerCase()));

    }
}
