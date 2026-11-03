package campeonatosfifa.api.presentacion.controladores;


import campeonatosfifa.api.core.servicios.IGrupoServicio;
import campeonatosfifa.api.dominio.dtos.TablaPosicionesDto;
import campeonatosfifa.api.dominio.entidades.Grupo;
import campeonatosfifa.api.dominio.entidades.GrupoSeleccion;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grupos")
public class GrupoControlador {

    @Autowired
    private IGrupoServicio servicio;

    @GetMapping(value = "/campeonato/{idCampeonato}")
    public ResponseEntity<List<Grupo>> listarPorCampeonato(int idCampeonato) {
        return ResponseEntity.ok(servicio.listarPorCampeonato(idCampeonato));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Grupo>> obtener(@PathVariable int id) {
        var grupoBuscado = servicio.obtener(id);
        if (grupoBuscado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grupoBuscado);
    }

    @PostMapping
    public ResponseEntity<Grupo> agregar(@RequestBody Grupo grupo) {
        var grupoCreado = servicio.agregar(grupo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(grupoCreado);
    }

    @PutMapping
    public ResponseEntity<Grupo> modificar(@RequestBody Grupo grupo) {
        var grupoModificado = servicio.modificar(grupo);
        if (grupoModificado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grupoModificado);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        boolean respuesta = servicio.eliminar(id);
        if (!respuesta) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.noContent().build();
    }

    // ***** Selecciones del Grupo *****

    @GetMapping(value = "/selecciones/{id}")
    public ResponseEntity<List<GrupoSeleccion>> listarSelecciones(@PathVariable int id) {
        return ResponseEntity.ok(servicio.listarSelecciones(id));
    }

    @GetMapping(value = "/selecciones/obtener/{idGrupo}/{idSeleccion}")
    public ResponseEntity<Optional<GrupoSeleccion>> obtenerSeleccion(@PathVariable int idGrupo, @PathVariable int idSeleccion) {
        var grupoSeleccionBuscado = servicio.obtenerSeleccion(idGrupo, idSeleccion);
        if (grupoSeleccionBuscado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grupoSeleccionBuscado);
    }

    @PostMapping(value = "/selecciones/{idGrupo}/{idSeleccion}")
    public ResponseEntity<Object> agregarSeleccion(int idGrupo, int idSeleccion) {
        var grupoSeleccionCreado = servicio.agregarSeleccion(idGrupo, idSeleccion);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(grupoSeleccionCreado);
    }

    @PutMapping(value = "/selecciones/{idGrupo}/{idSeleccionActual}/{idSeleccionNueva}")
    public ResponseEntity<Object> modificarSeleccion(@PathVariable int idGrupo, @PathVariable int idSeleccionActual, @PathVariable int idSeleccionNueva) {
        var grupoSeleccionModificado = servicio.modificarSeleccion(idGrupo, idSeleccionActual, idSeleccionNueva);
        if (grupoSeleccionModificado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(grupoSeleccionModificado);
    }

    @DeleteMapping(value = "/paises/{idGrupo}/{idSeleccion}")
    public ResponseEntity<Void> eliminarSeleccion(@PathVariable int idGrupo, @PathVariable int idSeleccion) {
        boolean respuesta = servicio.eliminarSeleccion(idGrupo, idSeleccion);
        if (!respuesta) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.noContent().build();
    }

    // ***** Tabla de Posiciones *****

    @GetMapping(value = "/posiciones/{id}")
    public ResponseEntity<@Nullable Object> listarTablaPosiciones(@PathVariable int id) {
        return ResponseEntity.ok(servicio.listarTablaPosiciones(id));
    }
}
