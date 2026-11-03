package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import campeonatosfifa.api.core.repositorios.ICiudadRepositorio;
import campeonatosfifa.api.dominio.entidades.Ciudad;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CiudadEntidad;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.CiudadMapeador;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.ICiudadRepositorioJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CiudadRepositorio implements ICiudadRepositorio {

    private ICiudadRepositorioJpa repositorio;

    @Override
    public List<Ciudad> listar() {
        return repositorio.findAll()
                .stream()
                .map(CiudadMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ciudad> listarPorPais(int idPais) {
        return repositorio.listarPorPais(idPais)
                .stream()
                .map(CiudadMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public List<Ciudad> listarPorCampeonato(int idCampeonato) {
        return repositorio.listarPorCampeonato(idCampeonato)
                .stream()
                .map(CiudadMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Ciudad> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(CiudadMapeador::haciaDominio);
    }

    @Override
    public List<Ciudad> buscarPorNombre(String nombre) {
        return repositorio.findByNombreContaining(nombre)
                .stream()
                .map(CiudadMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Ciudad guardar(Ciudad campeonato) {
        CiudadEntidad entidad = CiudadMapeador.haciaEntidad(campeonato);
        CiudadEntidad entidadGuardada = repositorio.save(entidad);
        return CiudadMapeador.haciaDominio(entidadGuardada);
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
