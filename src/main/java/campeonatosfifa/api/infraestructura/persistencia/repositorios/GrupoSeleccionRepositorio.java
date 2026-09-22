package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import campeonatosfifa.api.core.repositorios.IGrupoSeleccionRepositorio;
import campeonatosfifa.api.dominio.entidades.GrupoSeleccion;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.GrupoSeleccionMapeador;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.IGrupoSeleccionRepositorioJpa;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerPorId'");
    }

    @Override
    public GrupoSeleccion guardar(GrupoSeleccion gruposeleccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public boolean eliminar(int idGrupo, int idSeleccion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
