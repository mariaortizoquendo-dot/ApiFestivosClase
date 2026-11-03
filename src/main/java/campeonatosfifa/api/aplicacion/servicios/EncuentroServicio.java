package campeonatosfifa.api.aplicacion.servicios;

import java.util.List;

import campeonatosfifa.api.dominio.entidades.Encuentro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campeonatosfifa.api.core.repositorios.IEncuentroRepositorio;
import campeonatosfifa.api.core.servicios.IEncuentroServicio;
import campeonatosfifa.api.dominio.entidades.Encuentro;

@Service
public class EncuentroServicio implements IEncuentroServicio {

    @Autowired
	private IEncuentroRepositorio repositorio;

	@Override
	public List<Encuentro> listarPorCampeonato(int idCampeonato) {
		return repositorio.listarPorCampeonato(idCampeonato);
	}

	@Override
	public List<Encuentro> listarPorCampeonatoYFase(int idCampeonato, int idFase) {
		return repositorio.listarPorCampeonatoYFase(idCampeonato, idFase);
	}

	@Override
	public List<Encuentro> listarPorGrupo(int idGrupo) {
		return repositorio.listarPorGrupo(idGrupo);
	}

	@Override
	public Encuentro obtenerPorId(int id) {
		var encuentroEncontrado = repositorio.obtenerPorId(id);
		return encuentroEncontrado.isEmpty() ? null :encuentroEncontrado.get();
	}

	@Override
	public Encuentro agregar(Encuentro encuentro) {
		encuentro.setId(0);
		return repositorio.guardar(encuentro);
	}

	@Override
	public Encuentro modificar(Encuentro encuentro) {
		var encuentroEncontrada = repositorio.obtenerPorId(encuentro.getId());
		return encuentroEncontrada.isEmpty() ? null : repositorio.guardar(encuentro);
	}

	@Override
	public boolean eliminar(int id) {
		return repositorio.eliminar(id);
	}

}
