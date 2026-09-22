package campeonatosfifa.api.core.servicios;

import java.util.List;

import campeonatosfifa.api.dominio.entidades.Ciudad;

public interface ICiudadServicio {

    List<Ciudad> listar();

    List<Ciudad> listarPorPais(int idPais);

    List<Ciudad> listarPorCampeonato(int idCampeonato);

    Ciudad obtener(int id);

    List<Ciudad> buscar(String nombre);

    Ciudad agregar(Ciudad ciudad);

    Ciudad modificar(Ciudad ciudad);

    boolean eliminar(int id);
}