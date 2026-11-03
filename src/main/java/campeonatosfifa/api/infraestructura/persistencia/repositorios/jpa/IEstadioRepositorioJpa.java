package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import campeonatosfifa.api.dominio.entidades.Estadio;
import campeonatosfifa.api.infraestructura.persistencia.entidades.EstadioEntidad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadioRepositorioJpa extends JpaRepository<EstadioEntidad, Integer> {

    @Query("SELECT e FROM EstadioEntidad e WHERE e.ciudad.pais.id = :idPais ORDER BY e.nombre ASC")
    List<EstadioEntidad> listarPorPais(@Param("idPais") int idPais);

    @Query("SELECT DISTINCT e FROM EstadioEntidad e JOIN CampeonatoPaisEntidad cp ON e.ciudad.pais.id = cp.pais.id WHERE cp.campeonato.id = :idCampeonato ORDER BY e.nombre ASC")
    List<EstadioEntidad> listarPorCampeonato(@Param("idCampeonato") int idCampeonato);

    @Query("SELECT e FROM EstadioEntidad e WHERE LOWER(e.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<EstadioEntidad> findByNombreContaining(@Param("nombre") String nombre);
}
