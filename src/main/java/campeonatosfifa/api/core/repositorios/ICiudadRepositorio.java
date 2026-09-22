package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.Ciudad;

public interface ICiudadRepositorio {

    List<Ciudad> listar();

    List<Ciudad> listarPorPais(int idPais);

    List<Ciudad> listarPorCampeonato(int idCampeonato);

    Optional<Ciudad> obtenerPorId(int id);

    List<Ciudad> buscarPorNombre(String nombre);

    Ciudad guardar(Ciudad ciudad);

    boolean eliminar(int id);

}
