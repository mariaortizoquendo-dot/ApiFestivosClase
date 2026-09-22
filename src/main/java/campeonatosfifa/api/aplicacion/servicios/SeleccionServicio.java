package campeonatosfifa.api.aplicacion.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import campeonatosfifa.api.core.repositorios.ISeleccionRepositorio;
import campeonatosfifa.api.core.servicios.ISeleccionServicio;
import campeonatosfifa.api.dominio.entidades.Seleccion;

@Service
public class SeleccionServicio implements ISeleccionServicio {

	private final ISeleccionRepositorio repositorio;

	SeleccionServicio(ISeleccionRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<Seleccion> listar() {
		return repositorio.listar();
	}

	@Override
	public Seleccion obtener(int id) {
		var seleccionEncontrada = repositorio.obtenerPorId(id);
		return seleccionEncontrada.isEmpty() ? null :seleccionEncontrada.get();
	}

	@Override
	public List<Seleccion> buscar(String nombre) {
		return repositorio.buscarPorNombre(nombre);
	}

	@Override
	public Seleccion agregar(Seleccion seleccion) {
		seleccion.setId(0);
		return repositorio.guardar(seleccion);
	}

	@Override
	public Seleccion modificar(Seleccion seleccion) {
		var seleccionEncontrada = repositorio.obtenerPorId(seleccion.getId());
		return seleccionEncontrada.isEmpty() ? null : repositorio.guardar(seleccion);
	}

	@Override
	public boolean eliminar(int id) {
		return repositorio.eliminar(id);
	}

}
