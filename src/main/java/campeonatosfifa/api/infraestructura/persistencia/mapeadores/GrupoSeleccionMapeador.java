package campeonatosfifa.api.infraestructura.persistencia.mapeadores;

import campeonatosfifa.api.dominio.entidades.GrupoSeleccion;
import campeonatosfifa.api.infraestructura.persistencia.entidades.GrupoSeleccionEntidad;

public class GrupoSeleccionMapeador {
public static GrupoSeleccion haciaDominio(GrupoSeleccionEntidad entidad) {
        if (entidad == null)
            return null;

        return new GrupoSeleccion(
                GrupoMapeador.haciaDominio(entidad.getGrupo()),
                SeleccionMapeador.haciaDominio(entidad.getSeleccion()));
    }

    public static GrupoSeleccionEntidad haciaEntidad(GrupoSeleccion grupoSeleccion) {
        if (grupoSeleccion == null)
            return null;
        return new GrupoSeleccionEntidad(
                GrupoMapeador.haciaEntidad(grupoSeleccion.getGrupo()),
                SeleccionMapeador.haciaEntidad(grupoSeleccion.getSeleccion()));
    }
}
