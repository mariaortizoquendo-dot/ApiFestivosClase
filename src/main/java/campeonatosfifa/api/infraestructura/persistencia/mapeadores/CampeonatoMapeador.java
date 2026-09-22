package campeonatosfifa.api.infraestructura.persistencia.mapeadores;

import campeonatosfifa.api.dominio.entidades.Campeonato;
import campeonatosfifa.api.infraestructura.persistencia.entidades.CampeonatoEntidad;

public class CampeonatoMapeador {

    public static Campeonato haciaDominio(CampeonatoEntidad entidad) {
        if (entidad == null)
            return null;

        return new Campeonato(
                entidad.getId(),
                entidad.getNombre(),
                entidad.getAño());
    }

    public static CampeonatoEntidad haciaEntidad(Campeonato campeonato) {
        if (campeonato == null)
            return null;

        return new CampeonatoEntidad(
            campeonato.getId(),
            campeonato.getNombre(),
            campeonato.getAño()
        );
    }

}