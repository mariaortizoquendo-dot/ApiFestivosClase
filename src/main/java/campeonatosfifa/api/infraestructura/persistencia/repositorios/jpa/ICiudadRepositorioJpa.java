package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import campeonatosfifa.api.dominio.entidades.Ciudad;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CiudadEntidad;

public interface ICiudadRepositorioJpa extends JpaRepository<CiudadEntidad, Integer> {

    @Query("SELECT c FROM CiudadEntidad c WHERE c.pais.id = :idPais ORDER BY c.nombre ASC")
    List<CiudadEntidad> listarPorPais(@Param("idPais") int idPais);

    @Query("SELECT c FROM CiudadEntidad c JOIN CampeonatoPaisEntidad cp ON c.pais.id = cp.pais.id WHERE cp.campeonato.id = :idCampeonato ORDER BY c.nombre ASC")
    List<CiudadEntidad> listarPorCampeonato(@Param("idCampeonato") int idCampeonato);

    @Query("SELECT c FROM CiudadEntidad c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<CiudadEntidad> findByNombreContaining(@Param("nombre") String nombre);
}
