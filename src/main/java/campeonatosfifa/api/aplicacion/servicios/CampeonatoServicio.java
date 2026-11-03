package campeonatosfifa.api.aplicacion.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import campeonatosfifa.api.core.repositorios.ICampeonatoPaisRepositorio;
import campeonatosfifa.api.core.repositorios.ICampeonatoRepositorio;
import campeonatosfifa.api.core.repositorios.ISeleccionRepositorio;
import campeonatosfifa.api.core.servicios.ICampeonatoServicio;
import campeonatosfifa.api.dominio.entidades.Campeonato;
import campeonatosfifa.api.dominio.entidades.CampeonatoPais;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoServicio implements ICampeonatoServicio {

    private final ICampeonatoRepositorio repositorio;
    private final ICampeonatoPaisRepositorio repositorioCampeonatoPais;
    private final ISeleccionRepositorio repositorioPais;

    public CampeonatoServicio(ICampeonatoRepositorio repositorio,
                               ICampeonatoPaisRepositorio repositorioCampeonatoPais,
                               ISeleccionRepositorio repositorioPais) {
        this.repositorio = repositorio;
        this.repositorioCampeonatoPais = repositorioCampeonatoPais;
        this.repositorioPais = repositorioPais;
    }

    @Override
    public List<Campeonato> listar() {
        return repositorio.listar();
    }

    @Override
    public Campeonato obtener(int id) {
        var campeonatoEncontrado = repositorio.obtenerPorId(id);
        return campeonatoEncontrado.orElse(null);
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

    // ***** Países del Campeonato *****

    @Override
    public List<CampeonatoPais> listarPaises(int idCampeonato) {
        return repositorioCampeonatoPais.listarPaises(idCampeonato);
    }

    @Override
    public Optional<CampeonatoPais> obtenerPais(int idCampeonato, int idPais) {
        return repositorioCampeonatoPais.obtenerPorId(idCampeonato, idPais);
    }

    @Override
    public CampeonatoPais agregarPais(CampeonatoPais campeonatoPais) {
        if (campeonatoPais == null || campeonatoPais.getCampeonato() == null || campeonatoPais.getPais() == null) {
            return null;
        }
        var existente = repositorioCampeonatoPais.obtenerPorId(
                campeonatoPais.getCampeonato().getId(), 
                campeonatoPais.getPais().getId()
        );
        return existente.isEmpty() ? repositorioCampeonatoPais.guardar(campeonatoPais) : null;
    }

    @Override
    public CampeonatoPais modificarPais(CampeonatoPais campeonatoPais) {
        if (campeonatoPais == null || campeonatoPais.getCampeonato() == null || campeonatoPais.getPais() == null) {
            return null;
        }
        return repositorioCampeonatoPais.guardar(campeonatoPais);
    }

    @Override
    public boolean eliminarPais(int idCampeonato, int idPais) {
        return repositorioCampeonatoPais.eliminar(idCampeonato, idPais);
    }

    @Override
    public Object agregarPais(int idCampeonato, int idPais) {
        var campeonato = repositorio.obtenerPorId(idCampeonato);
        var pais = repositorioPais.obtenerPorId(idPais);

        if (campeonato.isEmpty() || pais.isEmpty()) {
            return null;
        }
        var campeonatoPais = repositorioCampeonatoPais.obtenerPorId(idCampeonato, idPais);
        return campeonatoPais.isEmpty() 
                ? repositorioCampeonatoPais.guardar(new CampeonatoPais(campeonato.get(), pais.get())) 
                : null;
    }

    @Override
    public Object modificarPais(int idCampeonato, int idPaisActual, int idPaisNueva) {
        var campeonato = repositorio.obtenerPorId(idCampeonato);
        var nuevoPais = repositorioPais.obtenerPorId(idPaisNueva);

        if (campeonato.isEmpty() || nuevoPais.isEmpty()) {
            return null;
        }

        var campeonatoPaisExistente = repositorioCampeonatoPais.obtenerPorId(idCampeonato, idPaisActual);
        if (campeonatoPaisExistente.isEmpty()) {
            return null;
        }

        repositorioCampeonatoPais.eliminar(idCampeonato, idPaisActual);
        return repositorioCampeonatoPais.guardar(new CampeonatoPais(campeonato.get(), nuevoPais.get()));
    }

}
