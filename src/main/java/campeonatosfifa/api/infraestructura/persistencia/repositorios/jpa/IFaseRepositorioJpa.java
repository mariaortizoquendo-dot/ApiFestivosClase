package campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import campeonatosfifa.api.infraestructura.persistencia.entidades.FaseEntidad;

public interface IFaseRepositorioJpa extends JpaRepository<FaseEntidad, Integer>{

    List<FaseEntidad> findByNombreContaining(String nombre);

}
