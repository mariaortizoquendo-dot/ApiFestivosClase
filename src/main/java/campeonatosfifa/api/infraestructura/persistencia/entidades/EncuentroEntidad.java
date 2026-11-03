package campeonatosfifa.api.infraestructura.persistencia.entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "encuentro")
public class EncuentroEntidad {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_encuentro")
    @SequenceGenerator(
        name = "secuencia_encuentro",
        sequenceName = "secuencia_encuentro",
        allocationSize = 1
    )
    private int id;

    @ManyToOne
    @JoinColumn(name = "idpais1", referencedColumnName = "id", nullable = false)
    private SeleccionEntidad seleccion1;

    @ManyToOne
    @JoinColumn(name = "idpais2", referencedColumnName = "id", nullable = false)
    private SeleccionEntidad seleccion2;

    @ManyToOne
    @JoinColumn(name = "idfase", referencedColumnName = "id", nullable = false)
    private FaseEntidad fase;

    @ManyToOne
    @JoinColumn(name = "idcampeonato", referencedColumnName = "id", nullable = false)
    private CampeonatoEntidad campeonato;

    @ManyToOne
    @JoinColumn(name = "idestadio", referencedColumnName = "id", nullable = false)
    private EstadioEntidad estadio;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "goles1")
    private int goles1;

    @Column(name = "goles2")
    private int goles2;

    @Column(name = "penales1")
    private int penales1;

    @Column(name = "penales2")
    private int penales2;

    public EncuentroEntidad() {
    }

    public EncuentroEntidad(
            int id,
            SeleccionEntidad seleccion1,
            SeleccionEntidad seleccion2,
            FaseEntidad fase,
            CampeonatoEntidad campeonato,
            EstadioEntidad estadio,
            LocalDate fecha,
            int goles1,
            int goles2,
            int penales1,
            int penales2) {

        this.id = id;
        this.seleccion1 = seleccion1;
        this.seleccion2 = seleccion2;
        this.fase = fase;
        this.campeonato = campeonato;
        this.estadio = estadio;
        this.fecha = fecha;
        this.goles1 = goles1;
        this.goles2 = goles2;
        this.penales1 = penales1;
        this.penales2 = penales2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeleccionEntidad getSeleccion1() {
        return seleccion1;
    }

    public void setSeleccion1(SeleccionEntidad seleccion1) {
        this.seleccion1 = seleccion1;
    }

    public SeleccionEntidad getSeleccion2() {
        return seleccion2;
    }

    public void setSeleccion2(SeleccionEntidad seleccion2) {
        this.seleccion2 = seleccion2;
    }

    public FaseEntidad getFase() {
        return fase;
    }

    public void setFase(FaseEntidad fase) {
        this.fase = fase;
    }

    public CampeonatoEntidad getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(CampeonatoEntidad campeonato) {
        this.campeonato = campeonato;
    }

    public EstadioEntidad getEstadio() {
        return estadio;
    }

    public void setEstadio(EstadioEntidad estadio) {
        this.estadio = estadio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getGoles1() {
        return goles1;
    }

    public void setGoles1(int goles1) {
        this.goles1 = goles1;
    }

    public int getGoles2() {
        return goles2;
    }

    public void setGoles2(int goles2) {
        this.goles2 = goles2;
    }

    public int getPenales1() {
        return penales1;
    }

    public void setPenales1(int penales1) {
        this.penales1 = penales1;
    }

    public int getPenales2() {
        return penales2;
    }

    public void setPenales2(int penales2) {
        this.penales2 = penales2;
    }
}
