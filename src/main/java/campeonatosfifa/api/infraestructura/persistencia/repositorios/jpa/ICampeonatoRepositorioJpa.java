package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import campeonatosfifa.api.infraestructura.persistencia.entidades.CampeonatoEntidad;

public interface ICampeonatoRepositorioJpa extends JpaRepository<CampeonatoEntidad, Integer>{

    List<CampeonatoEntidad> findByNombreContaining(String nombre);

}
