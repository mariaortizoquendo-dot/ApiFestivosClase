package campeonatosfifa.api.infraestructura.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fase")
public class FaseEntidad {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_fase")
    @SequenceGenerator(
        name = "secuencia_fase",
        sequenceName = "secuencia_fase",
        allocationSize = 1
    )
    private int id;

    @Column(name = "fase", length = 50, unique = true, nullable = false)
    private String nombre;

    public FaseEntidad() {
    }

    public FaseEntidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
