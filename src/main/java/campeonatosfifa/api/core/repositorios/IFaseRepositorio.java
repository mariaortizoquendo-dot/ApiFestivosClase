package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.Fase;

public interface IFaseRepositorio {

    List<Fase> listar();

    Optional<Fase> obtenerPorId(int id);

    List<Fase> buscarPorNombre(String nombre);

    Fase guardar(Fase fase);

    boolean eliminar(int id);
    
}