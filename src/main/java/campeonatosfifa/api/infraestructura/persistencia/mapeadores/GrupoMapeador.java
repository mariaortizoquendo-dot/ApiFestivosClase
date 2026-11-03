package campeonatosfifa.api.infraestructura.persistencia.mapeadores;

import campeonatosfifa.api.dominio.entidades.Grupo;
import campeonatosfifa.api.infraestructura.persistencia.entidades.GrupoEntidad;

public class GrupoMapeador {
    public static Grupo haciaDominio(GrupoEntidad entidad) {
        if (entidad == null)
            return null;

        return new Grupo(entidad.getId(),
                entidad.getNombre(),
                CampeonatoMapeador.haciaDominio(entidad.getCampeonato()));

    }

    public static GrupoEntidad haciaEntidad(Grupo grupo) {
        if (grupo == null)
            return null;

        return new GrupoEntidad(
                grupo.getId(),
                grupo.getNombre(),
                CampeonatoMapeador.haciaEntidad(grupo.getCampeonato())
            );
    }
}
