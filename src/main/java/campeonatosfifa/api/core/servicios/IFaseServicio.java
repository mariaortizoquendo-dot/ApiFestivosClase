package campeonatosfifa.api.core.servicios;

import java.util.List;

import campeonatosfifa.api.dominio.entidades.Fase;

public interface IFaseServicio {

    List<Fase> listar();

    Fase obtener(int id);

    List<Fase> buscar(String nombre);

    Fase agregar(Fase seleccion);

    Fase modificar(Fase fase);

    boolean eliminar(int id);
    
}
