package campeonatosfifa.api.dominio.entidades;

public class CampeonatoPais {

    private Campeonato campeonato;

    private Seleccion pais;

    public CampeonatoPais() {
    }

    public CampeonatoPais(Campeonato campeonato, Seleccion pais) {
        this.campeonato = campeonato;
        this.pais = pais;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Seleccion getPais() {
        return pais;
    }

    public void setPais(Seleccion pais) {
        this.pais = pais;
    }

}