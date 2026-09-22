package campeonatosfifa.api.infraestructura.persistencia.entidades;

import campeonatosfifa.api.dominio.entidades.Seleccion;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "grupopais")
public class GrupoSeleccionEntidad {

    @Id
    @JoinColumn(name = "idpais", referencedColumnName = "id")
    @ManyToOne
    private Seleccion seleccion;

    @Id
    @JoinColumn(name = "idgrupo", referencedColumnName = "id")
    @ManyToOne
    private GrupoEntidad grupo;

    public GrupoSeleccionEntidad() {
    }

    public GrupoSeleccionEntidad(Seleccion seleccion, GrupoEntidad grupo) {
        this.seleccion = seleccion;
        this.grupo = grupo;
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }

    public GrupoEntidad getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoEntidad grupo) {
        this.grupo = grupo;
    }

}