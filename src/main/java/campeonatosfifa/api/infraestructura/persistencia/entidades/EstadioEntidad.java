package campeonatosfifa.api.infraestructura.persistencia.entidades;

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
@Table(name = "estadio")
public class EstadioEntidad {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_estadio")
    @SequenceGenerator(
        name = "secuencia_estadio",
        sequenceName = "secuencia_estadio",
        allocationSize = 1
    )
    private int id;

    @Column(name = "estadio", length = 50, nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idciudad", referencedColumnName = "id", nullable = false)
    private CiudadEntidad ciudad;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    public EstadioEntidad() {
    }

    public EstadioEntidad(int id, String nombre, CiudadEntidad ciudad, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CiudadEntidad getCiudadEntidad() {
        return ciudad;
    }

    public void setCiudadEntidad(CiudadEntidad ciudad) {
        this.ciudad = ciudad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}