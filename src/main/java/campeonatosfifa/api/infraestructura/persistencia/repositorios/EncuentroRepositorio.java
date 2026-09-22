package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import campeonatosfifa.api.core.repositorios.IEncuentroRepositorio;
import campeonatosfifa.api.dominio.entidades.Encuentro;
import campeonatosfifa.api.infraestructura.persistencia.entidades.EncuentroEntidad;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.EncuentroMapeador;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.IEncuentroRepositorioJpa;

public class EncuentroRepositorio implements IEncuentroRepositorio {

    private final IEncuentroRepositorioJpa repositorio;

    EncuentroRepositorio(IEncuentroRepositorioJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Encuentro> listarPorCampeonato(int idCampeonato) {
        return repositorio.listarPorCampeonato(idCampeonato)
                .stream()
                .map(EncuentroMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public List<Encuentro> listarPorCampeonatoYFase(int idCampeonato, int idFase) {
        return repositorio.listarPorCampeonatoYFase(idCampeonato, idFase)
                .stream()
                .map(EncuentroMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public List<Encuentro> listarPorGrupo(int idGrupo) {
        return repositorio.listarPorGrupo(idGrupo)
                .stream()
                .map(EncuentroMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Encuentro> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(EncuentroMapeador::haciaDominio);
    }

    @Override
    public Encuentro guardar(Encuentro encuentro) {
        EncuentroEntidad entidad = EncuentroMapeador.haciaEntidad(encuentro);
        EncuentroEntidad entidadGuardada = repositorio.save(entidad);
        return EncuentroMapeador.haciaDominio(entidadGuardada);

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
