package campeonatosfifa.api.dominio.entidades;


public class Ciudad {


    private int id;

    private String nombre;


    private Seleccion pais;

    public Ciudad() {
    }

    public Ciudad(int id, String nombre, Seleccion pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
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

    public Seleccion getPais() {
        return pais;
    }

    public void setPais(Seleccion pais) {
        this.pais = pais;
    }

} 