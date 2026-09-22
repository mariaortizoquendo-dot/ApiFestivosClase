package campeonatosfifa.api.core.servicios;

import java.util.List;
import campeonatosfifa.api.dominio.entidades.Estadio;

public interface IEstadioServicio {

    List<Estadio> listar();

    List<Estadio> listarPorPais(int idPais);

    List<Estadio> listarPorCampeonato(int idCampeonato);

    Estadio obtener(int id);

    List<Estadio> buscar(String nombre);

    Estadio agregar(Estadio ciudad);

    Estadio modificar(Estadio ciudad);

    boolean eliminar(int id);
    
}
