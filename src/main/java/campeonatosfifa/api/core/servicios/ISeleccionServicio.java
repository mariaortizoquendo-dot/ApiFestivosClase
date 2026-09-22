package campeonatosfifa.api.core.servicios;

import java.util.List;

import campeonatosfifa.api.dominio.entidades.Seleccion;

public interface ISeleccionServicio {

    List<Seleccion> listar();

    Seleccion obtener(int id);

    List<Seleccion> buscar(String nombre);

    Seleccion agregar(Seleccion seleccion);

    Seleccion modificar(Seleccion seleccion);

    boolean eliminar(int id);

}
