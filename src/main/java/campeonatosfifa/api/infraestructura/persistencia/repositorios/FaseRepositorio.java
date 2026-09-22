package campeonatosfifa.api.infraestructura.persistencia.repositorios;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import campeonatosfifa.api.core.repositorios.IFaseRepositorio;
import campeonatosfifa.api.dominio.entidades.Fase;
import campeonatosfifa.api.infraestructura.persistencia.entidades.FaseEntidad;
import campeonatosfifa.api.infraestructura.persistencia.mapeadores.FaseMapeador;
import campeonatosfifa.api.infraestructura.persistencia.repositorios.jpa.IFaseRepositorioJpa;

@Component
public class FaseRepositorio implements IFaseRepositorio {

    private final IFaseRepositorioJpa repositorio;

    FaseRepositorio(IFaseRepositorioJpa repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Fase> listar() {
        return repositorio.findAll()
                .stream()
                .map(FaseMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Fase> obtenerPorId(int id) {
        return repositorio.findById(id)
                .map(FaseMapeador::haciaDominio);
    }

    @Override
    public List<Fase> buscarPorNombre(String nombre) {
        return repositorio.findByNombreContaining(nombre)
                .stream()
                .map(FaseMapeador::haciaDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Fase guardar(Fase fase) {
        FaseEntidad entidad = FaseMapeador.haciaEntidad(fase);
        FaseEntidad entidadGuardada = repositorio.save(entidad);
        return FaseMapeador.haciaDominio(entidadGuardada);
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

}
