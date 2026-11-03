package campeonatosfifa.api.aplicacion.servicios;

import java.util.List;

import campeonatosfifa.api.core.repositorios.IEstadioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campeonatosfifa.api.core.servicios.*;
import campeonatosfifa.api.dominio.entidades.*;

@Service
public class EstadioServicio implements IEstadioServicio {

    @Autowired
    private IEstadioRepositorio repositorio;

    @Override
    public List<Estadio> listar() {
        return repositorio.listar();
    }

    @Override
    public List<Estadio> listarPorPais(int idPais) {
        return repositorio.listarPorPais(idPais);
    }

    @Override
    public List<Estadio> listarPorCampeonato(int idCampeonato) {
        return repositorio.listarPorCampeonato(idCampeonato);
    }

    @Override
    public Estadio obtener(int id) {
        var estadioEncontrada = repositorio.obtenerPorId(id);
        return estadioEncontrada.isEmpty() ? null :estadioEncontrada.get();
    }

    @Override
    public List<Estadio> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Estadio agregar(Estadio estadio) {
        estadio.setId(0);
        return repositorio.guardar(estadio);
    }

    @Override
    public Estadio modificar(Estadio estadio) {
        var estadioEncontrada = repositorio.obtenerPorId(estadio.getId());
        return estadioEncontrada.isEmpty() ? null : repositorio.guardar(estadio);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }

}
