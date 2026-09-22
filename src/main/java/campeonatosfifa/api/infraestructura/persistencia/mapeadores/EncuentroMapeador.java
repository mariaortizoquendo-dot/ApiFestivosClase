package campeonatosfifa.api.infraestructura.persistencia.mapeadores;

import campeonatosfifa.api.dominio.entidades.Encuentro;
import campeonatosfifa.api.infraestructura.persistencia.entidades.EncuentroEntidad;

public class EncuentroMapeador {
    public static Encuentro haciaDominio(EncuentroEntidad entidad) {
        if (entidad == null)
            return null;

        return new Encuentro(
                entidad.getId(),
                SeleccionMapeador.haciaDominio(entidad.getSeleccion1()),
                SeleccionMapeador.haciaDominio(entidad.getSeleccion2()),
                FaseMapeador.haciaDominio(entidad.getFase()),
                CampeonatoMapeador.haciaDominio(entidad.getCampeonato()),
                EstadioMapeador.haciaDominio(entidad.getEstadio()),
                entidad.getFecha(),
                entidad.getGoles1(),
                entidad.getGoles2(),
                entidad.getPenales1(),
                entidad.getPenales2()
            );

    }

    public static EncuentroEntidad haciaEntidad(Encuentro encuentro) {
        if (encuentro == null)
            return null;

        return new EncuentroEntidad(
                encuentro.getId(),
                SeleccionMapeador.haciaEntidad(encuentro.getSeleccion1()),
                SeleccionMapeador.haciaEntidad(encuentro.getSeleccion2()),
                FaseMapeador.haciaEntidad(encuentro.getFase()),
                CampeonatoMapeador.haciaEntidad(encuentro.getCampeonato()),
                EstadioMapeador.haciaEntidad(encuentro.getEstadio()),
                encuentro.getFecha(),
                encuentro.getGoles1(),
                encuentro.getGoles2(),
                encuentro.getPenales1(),
                encuentro.getPenales2()
        );
    }
}
