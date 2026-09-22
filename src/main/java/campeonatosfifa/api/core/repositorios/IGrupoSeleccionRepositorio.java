package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.GrupoSeleccion;

public interface IGrupoSeleccionRepositorio {

    List<GrupoSeleccion> listarSelecciones(int idGrupo);

    Optional<GrupoSeleccion> obtenerPorId(int idGrupo, int idSeleccion);

    GrupoSeleccion guardar(GrupoSeleccion gruposeleccion);

    boolean eliminar(int idGrupo, int idSeleccion);
}
