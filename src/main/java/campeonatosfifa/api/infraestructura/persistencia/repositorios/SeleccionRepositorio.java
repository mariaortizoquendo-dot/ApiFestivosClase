package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.core.repositorios.ISeleccionRepositorio;
import campeonatosfifa.api.dominio.entidades.GrupoSeleccion;

public class SeleccionRepositorio implements ISeleccionRepositorio{

    @Override
    public List<GrupoSeleccion> listarSelecciones(int idGrupo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarSelecciones'");
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
