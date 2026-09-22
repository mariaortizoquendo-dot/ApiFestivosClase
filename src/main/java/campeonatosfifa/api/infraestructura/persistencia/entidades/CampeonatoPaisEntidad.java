package campeonatosfifa.api.infraestructura.persistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CampeonatoPaisEntidad")
public class CampeonatoPaisEntidad {

    @Id
    @JoinColumn(name = "idcampeonato", referencedColumnName = "id")
    @ManyToOne
    private CampeonatoEntidad campeonato;

    @Id
    @JoinColumn(name = "idpais", referencedColumnName = "id")
    @ManyToOne
    private SeleccionEntidad pais;

    public CampeonatoPaisEntidad() {
    }

    public CampeonatoPaisEntidad(CampeonatoEntidad campeonato, SeleccionEntidad pais) {
        this.campeonato = campeonato;
        this.pais = pais;
    }

    public CampeonatoEntidad getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(CampeonatoEntidad campeonato) {
        this.campeonato = campeonato;
    }

    public SeleccionEntidad getPais() {
        return pais;
    }

    public void setPais(SeleccionEntidad pais) {
        this.pais = pais;
    }

}