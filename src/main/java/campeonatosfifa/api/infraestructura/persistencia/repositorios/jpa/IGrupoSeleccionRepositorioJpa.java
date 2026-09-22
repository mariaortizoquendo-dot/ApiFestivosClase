package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import campeonatosfifa.api.infraestructura.persistencia.entidades.GrupoSeleccionEntidad;
import campeonatosfifa.api.infraestructura.persistencia.entidades.GrupoSeleccionId;

public interface IGrupoSeleccionRepositorioJpa extends JpaRepository<GrupoSeleccionEntidad, GrupoSeleccionId> {

}
