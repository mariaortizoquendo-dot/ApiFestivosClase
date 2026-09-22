package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import campeonatosfifa.api.core.repositorios.ICampeonatoRepositorio;
import campeonatosfifa.api.dominio.entidades.Campeonato;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CampeonatoEntidad;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.CampeonatoMapeador;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.ICampeonatoRepositorioJpa;

public class CampeonatoRepositorio implements ICampeonatoRepositorio {

    private ICampeonatoRepositorioJpa repositorio;

    @Override
    public List<Campeonato> listar() {
        return repositorio.findAll()
                .stream()
                .map(CampeonatoMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Campeonato> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(CampeonatoMapeador::haciaDominio);
    }

    @Override
    public List<Campeonato> buscarPorNombre(String nombre) {
        return repositorio.findByNombreContaining(nombre)
                .stream()
                .map(CampeonatoMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Campeonato guardar(Campeonato campeonato) {
        CampeonatoEntidad entidad = CampeonatoMapeador.haciaEntidad(campeonato);
        CampeonatoEntidad entidadGuardada = repositorio.save(entidad);
        return CampeonatoMapeador.haciaDominio(entidadGuardada);
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
