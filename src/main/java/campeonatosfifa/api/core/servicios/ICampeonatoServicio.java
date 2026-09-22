package campeonatosfifa.api.core.servicios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.Campeonato;
import campeonatosfifa.api.dominio.entidades.CampeonatoPais;

public interface ICampeonatoServicio {
    
    List<Campeonato> listar();

    Campeonato obtener(int id);

    List<Campeonato> buscar(String nombre);

    Campeonato agregar(Campeonato Campeonato);

    Campeonato modificar(Campeonato Campeonato);

    boolean eliminar(int id);

    List<CampeonatoPais> listarPaises(int idCampeonato);

    Optional<CampeonatoPais> obtenerPais(int idCampeonato, int idPais);

    CampeonatoPais agregarPais(CampeonatoPais campeonatoPais);

    CampeonatoPais modificarPais(CampeonatoPais campeonatoPais);

    boolean eliminarPais(int idCampeonato, int idPais);
}