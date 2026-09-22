package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.Seleccion;

public interface ISeleccionRepositorio {

    List<Seleccion> listar();

    Optional<Seleccion> obtenerPorId(int id);

    List<Seleccion> buscarPorNombre(String nombre);

    Seleccion guardar(Seleccion seleccion);

    boolean eliminar(int id);

}
