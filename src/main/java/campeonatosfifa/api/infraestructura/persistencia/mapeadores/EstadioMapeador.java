package campeonatosfifa.api.infraestructura.persistencia.mapeadores;

import campeonatosfifa.api.dominio.entidades.Estadio;
import campeonatosfifa.api.infraestructura.persistencia.entidades.EstadioEntidad;

public class EstadioMapeador {
    public static Estadio haciaDominio(EstadioEntidad entidad) {
        if (entidad == null)
            return null;

        return new Estadio(entidad.getId(),
                entidad.getNombre(),
                CiudadMapeador.haciaDominio(entidad.getCiudad()),
                entidad.getCapacidad()
            );

    }

    public static EstadioEntidad haciaEntidad(Estadio ciudad) {
        if (ciudad == null)
            return null;

        return new EstadioEntidad(
                ciudad.getId(),
                ciudad.getNombre(),
                CiudadMapeador.haciaEntidad(ciudad.getCiudad()),
                ciudad.getCapacidad()
            );
    }
}
