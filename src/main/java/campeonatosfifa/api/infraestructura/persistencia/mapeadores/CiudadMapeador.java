package campeonatosfifa.api.infraestructura.persistencia.mapeadores;

import campeonatosfifa.api.dominio.entidades.Ciudad;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CiudadEntidad;

public class CiudadMapeador {
    public static Ciudad haciaDominio(CiudadEntidad entidad) {
        if (entidad == null)
            return null;

        return new Ciudad(entidad.getId(),
                entidad.getNombre(),
                SeleccionMapeador.haciaDominio(entidad.getPais()));
    }

    public static CiudadEntidad haciaEntidad(Ciudad ciudad) {
        if (ciudad == null)
            return null;

        return new CiudadEntidad(
                ciudad.getId(),
                ciudad.getNombre(),
                SeleccionMapeador.haciaEntidad(ciudad.getPais())
            );
    }
}
