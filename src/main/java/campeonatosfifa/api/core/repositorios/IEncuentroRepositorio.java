package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.Encuentro;

public interface IEncuentroRepositorio {

    List<Encuentro> listarPorCampeonato(int idCampeonato);
    
    List<Encuentro> listarPorCampeonatoYFase(int idCampeonato, int idFase);

    List<Encuentro> listarPorGrupo(int idGrupo);

    Optional<Encuentro> obtenerPorId(int id);

    Encuentro guardar(Encuentro encuentro);

    boolean eliminar(int id);
}
