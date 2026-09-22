package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.CampeonatoPais;

public interface ICampeonatoPaisRepositorio {

    List<CampeonatoPais> listarPaises(int idCampeonato);

    Optional<CampeonatoPais> obtenerPorId(int idCampeonato, int idPais);

    CampeonatoPais guardar(CampeonatoPais campeonatoPais);

    boolean eliminar(int idCampeonato, int idPais);
    
}