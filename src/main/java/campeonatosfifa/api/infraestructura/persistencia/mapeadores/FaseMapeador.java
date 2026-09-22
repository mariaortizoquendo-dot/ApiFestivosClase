package campeonatosfifa.api.infraestructura.persistencia.mapeadores;

import campeonatosfifa.api.dominio.entidades.Fase;
import campeonatosfifa.api.infraestructura.persistencia.entidades.FaseEntidad;

public class FaseMapeador {

    public static Fase haciaDominio(FaseEntidad entidad) {
        if (entidad == null)
            return null;

        return new Fase(entidad.getId(),
                entidad.getNombre());

    }

    public static FaseEntidad haciaEntidad(Fase fase) {
        if (fase == null)
            return null;

        return new FaseEntidad(
                fase.getId(),
                fase.getNombre());
    }

}