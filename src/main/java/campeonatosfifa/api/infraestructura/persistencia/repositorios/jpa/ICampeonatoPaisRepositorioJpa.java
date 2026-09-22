package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import campeonatosfifa.api.infraestructura.persistencia.entidades.CampeonatoPaisEntidad;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CampeonatoPaisId;

public interface ICampeonatoPaisRepositorioJpa extends JpaRepository<CampeonatoPaisEntidad, CampeonatoPaisId> {

}
