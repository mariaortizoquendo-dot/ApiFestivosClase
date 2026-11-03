package campeonatosfifa.api.aplicacion.servicios;

import campeonatosfifa.api.core.repositorios.ICampeonatoRepositorio;
import campeonatosfifa.api.core.servicios.ICampeonatoServicio;
import campeonatosfifa.api.dominio.entidades.Campeonato;
import campeonatosfifa.api.dominio.entidades.CampeonatoPais;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoServicio implements ICampeonatoServicio {

    private ICampeonatoRepositorio repositorio;

    public CampeonatoServicio(ICampeonatoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Campeonato> listar() {
        return repositorio.listar();
    }

    @Override
    public Campeonato obtener(int id) {
        var campeonatoEncontrado = repositorio.obtenerPorId(id);
        return campeonatoEncontrado.isEmpty() ? null : campeonatoEncontrado.get();
    }

    @Override
    public List<Campeonato> buscar(String nombre) {
        return repositorio.buscarPorNombre(nombre);
    }

    @Override
    public Campeonato agregar(Campeonato campeonato) {
        campeonato.setId(0);
        return repositorio.guardar(campeonato);
    }

    @Override
    public Campeonato modificar(Campeonato campeonato) {
        var campeonatoEncontrado = repositorio.obtenerPorId(campeonato.getId());
        return campeonatoEncontrado.isEmpty() ? null : repositorio.guardar(campeonato);
    }

    @Override
    public boolean eliminar(int id) {
        return repositorio.eliminar(id);
    }

    @Override
    public List<CampeonatoPais> listarPaises(int idCampeonato) {
        return List.of(); }

    @Override
    public Optional<CampeonatoPais> obtenerPais(int idCampeonato, int idPais) {
        return Optional.empty(); }

    @Override
    public CampeonatoPais agregarPais(CampeonatoPais campeonatoPais) {
        return null; }

    @Override
    public CampeonatoPais modificarPais(CampeonatoPais campeonatoPais) {
        return null; }

    @Override
    public boolean eliminarPais(int idCampeonato, int idPais) {
        return false; }
}
