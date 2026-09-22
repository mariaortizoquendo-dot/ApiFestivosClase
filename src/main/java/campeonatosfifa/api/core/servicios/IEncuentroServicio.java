package campeonatosfifa.api.core.servicios;

import java.util.List;
import campeonatosfifa.api.dominio.entidades.Encuentro;

public interface IEncuentroServicio {

    List<Encuentro> listarPorCampeonato(int idCampeonato);
    
    List<Encuentro> listarPorCampeonatoYFase(int idCampeonato, int idFase);

    List<Encuentro> listarPorGrupo(int idGrupo);

    Encuentro obtenerPorId(int id);

    Encuentro agregar(Encuentro encuentro);

    Encuentro modificar(Encuentro encuentro);

    boolean eliminar(int id);
}