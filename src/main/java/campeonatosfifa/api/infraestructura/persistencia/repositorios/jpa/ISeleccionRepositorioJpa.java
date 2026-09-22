package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import campeonatosfifa.api.infraestructura.persistencia.entidades.SeleccionEntidad;

public interface ISeleccionRepositorioJpa extends JpaRepository<SeleccionEntidad, Integer> {

    List<SeleccionEntidad> findByNombreContaining(String nombre);

}
