package campeonatosfifa.api.infraestructura.persistencia.repositorios;


import campeonatosfifa.api.core.repositorios.ICampeonatoPaisRepositorio;
import campeonatosfifa.api.dominio.entidades.CampeonatoPais;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CampeonatoEntidad;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CampeonatoPaisEntidad;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CampeonatoPaisId;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.CampeonatoMapeador;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.CampeonatoPaisMapeador;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.ICampeonatoPaisRepositorioJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CampeonatoPaisRepositorio implements ICampeonatoPaisRepositorio {

    @Autowired
    private ICampeonatoPaisRepositorioJpa repositorio;

    @Override
    public List<CampeonatoPais> listarPaises(int idCampeonato) {
        return repositorio.listarPaises(idCampeonato)
                .stream()
                .map(CampeonatoPaisMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CampeonatoPais> obtenerPorId(int idCampeonato, int idPais) {
        return repositorio.findById(new CampeonatoPaisId(idCampeonato, idPais))
                .map(CampeonatoPaisMapeador::haciaDominio);
    }

    @Override
    public CampeonatoPais guardar(CampeonatoPais campeonatopais) {
        CampeonatoPaisEntidad entidad = CampeonatoPaisMapeador.haciaEntidad(campeonatopais);
        CampeonatoPaisEntidad entidadGuardada = repositorio.save(entidad);
        return CampeonatoPaisMapeador.haciaDominio(entidadGuardada);
    }

    @Override
    public boolean eliminar(int idCampeonato, int idPais) {
        try {
            var id=new CampeonatoPaisId(idCampeonato, idPais);
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

}
