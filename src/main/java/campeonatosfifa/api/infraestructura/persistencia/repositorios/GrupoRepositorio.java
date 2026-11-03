package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import campeonatosfifa.api.core.repositorios.IGrupoRepositorio;
import campeonatosfifa.api.dominio.dtos.TablaPosicionesDto;
import campeonatosfifa.api.dominio.entidades.Grupo;
import campeonatosfifa.api.infraestructura.persistencia.entidades.GrupoEntidad;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.GrupoMapeador;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.IGrupoRepositorioJpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class GrupoRepositorio implements IGrupoRepositorio {

    @PersistenceContext
    private EntityManager em;

    private final IGrupoRepositorioJpa repositorio;

    public GrupoRepositorio(IGrupoRepositorioJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Grupo> listarPorCampeonato(int idCampeonato) {
        return repositorio.listarPorCampeonato(idCampeonato)
                .stream()
                .map(GrupoMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Grupo> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(GrupoMapeador::haciaDominio);
    }

    @Override
    public Grupo guardar(Grupo grupo) {
        GrupoEntidad entidad = GrupoMapeador.haciaEntidad(grupo);
        GrupoEntidad entidadGuardada = repositorio.save(entidad);
        return GrupoMapeador.haciaDominio(entidadGuardada);
    }

    @Override
    public boolean eliminar(int id) {
        try {
            if (repositorio.existsById(id)) {
                repositorio.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<TablaPosicionesDto> listarTablaPosiciones(int idGrupo) {
        List<Object[]> resultados = em
                .createNativeQuery("SELECT * FROM fobtenertablaposiciones(:idgrupotabla) ORDER BY Puntos DESC, GF - GC DESC")
                .setParameter("idgrupotabla", idGrupo)
                .getResultList();

        return resultados.stream().map(reg -> new TablaPosicionesDto(
                ((Number) reg[0]).intValue(),
                (String) reg[1],
                ((Number) reg[2]).intValue(),
                ((Number) reg[3]).intValue(),
                ((Number) reg[4]).intValue(),
                ((Number) reg[5]).intValue(),
                ((Number) reg[6]).intValue(),
                ((Number) reg[7]).intValue(),
                ((Number) reg[8]).intValue()
        )).collect(Collectors.toList());
    }

}
