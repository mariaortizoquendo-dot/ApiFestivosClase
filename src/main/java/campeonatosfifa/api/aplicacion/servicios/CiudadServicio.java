package campeonatosfifa.api.aplicacion.servicios;

import java.util.List;

import campeonatosfifa.api.core.repositorios.ICiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campeonatosfifa.api.core.servicios.*;
import campeonatosfifa.api.dominio.entidades.*;

@Service
public class CiudadServicio implements ICiudadServicio {

    @Autowired
    private ICiudadRepositorio repositorio;

    @Override
    public List<Ciudad> listar() {
        return repositorio.listar();
    }

    @Override
    public List<Ciudad> listarPorPais(int idPais) {
        return repositorio.listarPorPais(idPais);
    }

    @Override
    public List<Ciudad> listarPorCampeonato(int idCampeonato) {
        return repositorio.listarPorCampeonato(idCampeonato);
    }

    @Override
    public Ciudad obtener(int id) {
        var ciudadEncontrada = repositorio.obtenerPorId(id);
        return ciudadEncontrada.isEmpty() ? null :ciudadEncontrada.get();
    }

    @Override
    public List<Ciudad> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Ciudad agregar(Ciudad ciudad) {
        ciudad.setId(0);
        return repositorio.guardar(ciudad);
    }

    @Override
    public Ciudad modificar(Ciudad ciudad) {
        var ciudadEncontrada = repositorio.obtenerPorId(ciudad.getId());
        return ciudadEncontrada.isEmpty() ? null : repositorio.guardar(ciudad);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }

}
