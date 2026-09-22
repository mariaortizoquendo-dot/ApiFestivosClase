package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import campeonatosfifa.api.infraestructura.persistencia.entidades.EncuentroEntidad;

public interface IEncuentroRepositorioJpa extends JpaRepository<EncuentroEntidad, Integer>{

    @Query("SELECT e FROM EncuentroEntidad e WHERE e.campeonato.id = ?1 ORDER BY e.fecha")
    List<EncuentroEntidad> listarPorCampeonato(int idCampeonato);

    @Query("SELECT e FROM EncuentroEntidad e WHERE e.campeonato.id = ?1 AND e.fase.id = ?2 ORDER BY e.fecha")
    List<EncuentroEntidad> listarPorCampeonatoYFase(int idCampeonato, int idFase);

    @Query("SELECT DISTINCT e" + 
                " FROM EncuentroEntidad e" + 
                " JOIN GrupoEntidad g ON e.campeonato.id=g.campeonato.id" + 
                " JOIN GrupoSeleccionEntidad gs ON gs.grupo.id=g.id" + 
                " AND (gs.seleccion.id = e.seleccion1.id OR gs.seleccion.id = e.seleccion2.id)" + 
                " WHERE e.fase.id = 2" + 
                " AND g.id = ?1" + 
                " ORDER BY fecha")
    List<EncuentroEntidad> listarPorGrupo(int idGrupo);

}
