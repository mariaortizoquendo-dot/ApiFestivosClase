package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import campeonatosfifa.api.dominio.entidades.Estadio;
import campeonatosfifa.api.infraestructura.persistencia.entidades.EstadioEntidad;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadioRepositorioJpa extends JpaRepository<EstadioEntidad, Integer> {

    @Query("SELECT e FROM EstadioEntidad e " +
            " JOIN CiudadEntidad c ON c.id = e.ciudad.id" +
            " WHERE c.pais.id=:idPais ORDER BY e.nombre")
    List<Estadio> listarPorPais(int idPais);

    @Query("SELECT e FROM EstadioEntidad e " +
            " JOIN CiudadEntidad c ON c.id = e.ciudad.id" +
            " JOIN CampeonatoPaisEntidad cp ON c.pais.id = cp.pais.id" +
            " WHERE cp.campeonato.id=:idCampeonato ORDER BY e.nombre")
    List<Estadio> listarPorCampeonato(int idCampeonato);
}
