package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import campeonatosfifa.api.infraestructura.persistencia.entidades.GrupoEntidad;

public interface IGrupoRepositorioJpa extends JpaRepository<GrupoEntidad, Integer>{

    @Query("SELECT g FROM GrupoEntidad g WHERE g.campeonato.id = ?1 ORDER BY e.nombre")
    List<GrupoEntidad> listarPorCampeonato(int idCampeonato);

}
