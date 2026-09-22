package campeonatosfifa.api.infraestructura.persistencia.mapeadores;

import campeonatosfifa.api.dominio.entidades.Seleccion;
import campeonatosfifa.api.infraestructura.persistencia.entidades.SeleccionEntidad;

public class SeleccionMapeador {

    public static Seleccion haciaDominio(SeleccionEntidad entidad) {
        if (entidad == null)
            return null;

        return new Seleccion(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getEntidad());
    }

    public static SeleccionEntidad haciaEntidad(Seleccion seleccion) {
        if (seleccion == null)
            return null;
        return new SeleccionEntidad(
                seleccion.getId(),
                seleccion.getNombre(),
                seleccion.getEntidad());
    }
}