package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import campeonatosfifa.api.core.repositorios.ISeleccionRepositorio;
import campeonatosfifa.api.dominio.entidades.Seleccion;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.ISeleccionRepositorioJpa;
import campeonatosfifa.api.infraestructura.persistencia.entidades.SeleccionEntidad;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.SeleccionMapeador;

@Component
public class SeleccionRepositorio implements ISeleccionRepositorio {

    private final ISeleccionRepositorioJpa repositorio;

    SeleccionRepositorio(ISeleccionRepositorioJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Seleccion> listar() {
        return repositorio.findAll()
                .stream()
                .map(SeleccionMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Seleccion> obtenerPorId(int id) {
       return repositorio.findById(id)
                .map(SeleccionMapeador::haciaDominio);
    }

    @Override
    public List<Seleccion> buscarPorNombre(String nombre) {
        return repositorio.findByNombreContaining(nombre)
                .stream()
                .map(SeleccionMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Seleccion guardar(Seleccion seleccion) {
        SeleccionEntidad entidad = SeleccionMapeador.haciaEntidad(seleccion);
        SeleccionEntidad entidadGuardada = repositorio.save(entidad);
        return SeleccionMapeador.haciaDominio(entidadGuardada);
    }

    @Override
    public boolean eliminar(int id) {
        try {
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
