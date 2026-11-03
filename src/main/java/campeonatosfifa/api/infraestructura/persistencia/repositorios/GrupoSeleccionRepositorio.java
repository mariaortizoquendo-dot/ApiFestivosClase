package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import campeonatosfifa.api.core.repositorios.IGrupoSeleccionRepositorio;
import campeonatosfifa.api.dominio.entidades.GrupoSeleccion;
import campeonatosfifa.api.infraestructura.persistencia.entidades.GrupoSeleccionEntidad;
import campeonatosfifa.api.infraestructura.persistencia.entidades.GrupoSeleccionId;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.GrupoSeleccionMapeador;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.IGrupoSeleccionRepositorioJpa;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


@Component
public class GrupoSeleccionRepositorio implements IGrupoSeleccionRepositorio {

    private final IGrupoSeleccionRepositorioJpa repositorio;

    GrupoSeleccionRepositorio(IGrupoSeleccionRepositorioJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<GrupoSeleccion> listarSelecciones(int idGrupo) {
        return repositorio.findAll()
                .stream()
                .map(GrupoSeleccionMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<GrupoSeleccion> obtenerPorId(int idGrupo, int idSeleccion) {
        return repositorio.findById(new GrupoSeleccionId(idGrupo, idSeleccion))
                .map(GrupoSeleccionMapeador::haciaDominio);
    }

    @Override
    public GrupoSeleccion guardar(GrupoSeleccion grupoSeleccion) {
        GrupoSeleccionEntidad entidad = GrupoSeleccionMapeador.haciaEntidad(grupoSeleccion);
        GrupoSeleccionEntidad entidadGuardada = repositorio.save(entidad);
        return GrupoSeleccionMapeador.haciaDominio(entidadGuardada);
    }

    @Override
    public boolean eliminar(int idGrupo, int idSeleccion) {
        try {
            var id=new GrupoSeleccionId(idGrupo, idSeleccion);
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

}
