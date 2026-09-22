package campeonatosfifa.api.infraestructura.persistencia.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class SeleccionEntidad {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="secuencia_pais")
    @SequenceGenerator(name = "secuencia_pais", sequenceName = "secuencia_pais", allocationSize = 1)
    private int id;

    @Column(name="pais", length = 50, unique = true, nullable = false)
    private String nombre;

    @Column(name = "entidad", length = 100, nullable = false)
    private String entidad;

    public SeleccionEntidad() {
    }

    public SeleccionEntidad(int id, String nombre, String entidad) {
        this.id = id;
        this.nombre = nombre;
        this.entidad = entidad;
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

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }


}