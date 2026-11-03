package campeonatosfifa.api.aplicacion.servicios;

import java.util.List;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import campeonatosfifa.api.core.repositorios.IGrupoRepositorio;
import campeonatosfifa.api.core.repositorios.ISeleccionRepositorio;
import campeonatosfifa.api.core.servicios.IGrupoServicio;
import campeonatosfifa.api.dominio.entidades.Grupo;
import campeonatosfifa.api.dominio.entidades.GrupoSeleccion;

@Service
public class GrupoServicio implements IGrupoServicio {

    private final IGrupoRepositorio repositorio;
    private final ISeleccionRepositorio repositorioSeleccion;

    public GrupoServicio(IGrupoRepositorio repositorio, ISeleccionRepositorio repositorioSeleccion) {
        this.repositorio = repositorio;
        this.repositorioSeleccion = repositorioSeleccion;
    }

    @Override
    public List<Grupo> listarPorCampeonato(int idCampeonato) {
        return repositorio.listarPorCampeonato(idCampeonato);
    }

    @Override
    public Optional<Grupo> obtener(int id) {
        return repositorio.obtenerPorId(id);
    }

    @Override
    public Grupo agregar(Grupo grupo) {
        grupo.setId(0);
        return repositorio.guardar(grupo);
    }

    @Override
    public Grupo modificar(Grupo grupo) {
        var existente = repositorio.obtenerPorId(grupo.getId());
        return existente.isEmpty() ? null : repositorio.guardar(grupo);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }

    // ***** Selecciones del Grupo *****

    @Override
    public List<GrupoSeleccion> listarSelecciones(int idGrupo) {
        // Implementar llamado al repositorio de GrupoSeleccion si aplica
        return List.of();
    }

    @Override
    public Optional<GrupoSeleccion> obtenerSeleccion(int idGrupo, int idSeleccion) {
        // Implementar llamado al repositorio de GrupoSeleccion si aplica
        return Optional.empty();
    }

    @Override
    public GrupoSeleccion agregarSeleccion(GrupoSeleccion grupoSeleccion) {
        return null;
    }

    @Override
    public GrupoSeleccion modificarSeleccion(GrupoSeleccion grupoSeleccion) {
        return null;
    }

    @Override
    public boolean eliminarSeleccion(int idGrupo, int idSeleccion) {
        return false;
    }

    @Override
    public Object modificarSeleccion(int idGrupo, int idSeleccionActual, int idSeleccionNueva) {
        return null;
    }

    @Override
    public @Nullable Object listarTablaPosiciones(int id) {
        return repositorio.listarTablaPosiciones(id);
    }

    @Override
    public Object agregarSeleccion(int idGrupo, int idSeleccion) {
        return null;
    }

}
