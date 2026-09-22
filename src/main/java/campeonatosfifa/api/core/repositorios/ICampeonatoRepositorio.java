package campeonatosfifa.api.core.repositorios;

import java.util.List;
import java.util.Optional;

import campeonatosfifa.api.dominio.entidades.Campeonato;

public interface ICampeonatoRepositorio {

    List<Campeonato> listar();

    Optional<Campeonato> obtenerPorId(int id);

    List<Campeonato> buscarPorNombre(String nombre);

    Campeonato guardar(Campeonato campeonato);

    boolean eliminar(int id);

}
