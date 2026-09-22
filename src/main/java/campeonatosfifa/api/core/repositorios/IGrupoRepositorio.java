package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.Grupo;

public interface IGrupoRepositorio {

    List<Grupo> listarPorCampeonato(int idCampeonato);

    Optional<Grupo> obtenerPorId(int id);

    Grupo guardar(Grupo grupo);

    boolean eliminar(int id);
}
