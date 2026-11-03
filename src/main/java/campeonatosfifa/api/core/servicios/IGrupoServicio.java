package campeonatosfifa.api.core.servicios;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;

import campeonatosfifa.api.dominio.entidades.Grupo;
import campeonatosfifa.api.dominio.entidades.GrupoSeleccion;

public interface IGrupoServicio {

    List<Grupo> listarPorCampeonato(int idCampeonato);

    Optional<Grupo> obtener(int id);

    Grupo agregar(Grupo grupo);

    Grupo modificar(Grupo grupo);

    boolean eliminar(int id);

    // ***** Selecciones del Grupo *****

    List<GrupoSeleccion> listarSelecciones(int idGrupo);

    Optional<GrupoSeleccion> obtenerSeleccion(int idGrupo, int idSeleccion);

    GrupoSeleccion agregarSeleccion(GrupoSeleccion grupoSeleccion);

    GrupoSeleccion modificarSeleccion(GrupoSeleccion grupoSeleccion);

    boolean eliminarSeleccion(int idGrupo, int idSeleccion);

    Object modificarSeleccion(int idGrupo, int idSeleccionActual, int idSeleccionNueva);

    @Nullable
    Object listarTablaPosiciones(int id);

    Object agregarSeleccion(int idGrupo, int idSeleccion);

}
