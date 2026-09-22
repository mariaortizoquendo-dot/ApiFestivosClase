package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.Estadio;

public interface IEstadioRepositorio {

    List<Estadio> listar();

    List<Estadio> listarPorPais(int idPais);

    List<Estadio> listarPorCampeonato(int idCampeonato);

    Optional<Estadio> obtenerPorId(int id);

    List<Estadio> buscarPorNombre(String nombre);

    Estadio guardar(Estadio estadio);

    boolean eliminar(int id);
}
