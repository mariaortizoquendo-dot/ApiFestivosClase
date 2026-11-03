package campeonatosfifa.api.aplicacion.servicios;

import java.util.List;

import campeonatosfifa.api.core.repositorios.IFaseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campeonatosfifa.api.core.servicios.*;
import campeonatosfifa.api.dominio.entidades.*;

@Service
public class FaseServicio implements IFaseServicio {

    @Autowired
    private IFaseRepositorio repositorio;

    @Override
    public List<Fase> listar() {
        return repositorio.listar();
    }

    @Override
    public Fase obtener(int id) {
        var faseEncontrada = repositorio.obtenerPorId(id);
        return faseEncontrada.isEmpty() ? null :faseEncontrada.get();
    }

    @Override
    public List<Fase> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Fase agregar(Fase fase) {
        fase.setId(0);
        return repositorio.guardar(fase);
    }

    @Override
    public Fase modificar(Fase fase) {
        var faseEncontrada = repositorio.obtenerPorId(fase.getId());
        return faseEncontrada.isEmpty() ? null : repositorio.guardar(fase);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }

}
