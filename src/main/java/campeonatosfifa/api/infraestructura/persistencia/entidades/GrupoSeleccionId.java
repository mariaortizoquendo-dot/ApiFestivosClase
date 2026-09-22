package campeonatosfifa.api.infraestructura.persistencia.entidades;

public class GrupoSeleccionId {

    private int grupo;
    private int seleccion;

    public GrupoSeleccionId() {
    }

    public GrupoSeleccionId(int grupo, int seleccion) {
        this.grupo = grupo;
        this.seleccion = seleccion;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(int seleccion) {
        this.seleccion = seleccion;
    }

}
