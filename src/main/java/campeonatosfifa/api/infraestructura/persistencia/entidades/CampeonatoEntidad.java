package campeonatosfifa.api.infraestructura.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "campeonato")
public class CampeonatoEntidad {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_campeonato")
    @SequenceGenerator(
        name = "secuencia_campeonato",
        sequenceName = "secuencia_campeonato",
        allocationSize = 1
    )
    private int id;

    @Column(name = "campeonato", length = 50, unique = true, nullable = false)
    private String nombre;

    @Column(name = "año", nullable = false)
    private int año;


    public CampeonatoEntidad() {
    }

    public CampeonatoEntidad(int id, String nombre, int año) {
        this.id = id;
        this.nombre = nombre;
        this.año = año;
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

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

}