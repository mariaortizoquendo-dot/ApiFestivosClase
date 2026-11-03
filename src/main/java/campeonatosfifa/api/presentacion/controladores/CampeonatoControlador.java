package campeonatosfifa.api.presentacion.controladores;


import campeonatosfifa.api.core.servicios.ICampeonatoServicio;
import campeonatosfifa.api.dominio.entidades.Campeonato;
import campeonatosfifa.api.dominio.entidades.CampeonatoPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/campeonatos")
public class CampeonatoControlador {

    @Autowired
    private ICampeonatoServicio servicio;

    @GetMapping
    public ResponseEntity<List<Campeonato>> listar() {
        return ResponseEntity.ok(servicio.listar());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Campeonato> obtener(@PathVariable int id) {
        var seleccionBuscada = servicio.obtener(id);
        if (seleccionBuscada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seleccionBuscada);
    }

    @GetMapping(value = "/buscar/{nombre}")
    public ResponseEntity<List<Campeonato>> buscar(@PathVariable String nombre) {
        return ResponseEntity.ok(servicio.buscar(nombre));
    }

    @PostMapping
    public ResponseEntity<Campeonato> agregar(@RequestBody Campeonato seleccion) {
        var seleccionCreada = servicio.agregar(seleccion);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(seleccionCreada);
    }

    @PutMapping
    public ResponseEntity<Campeonato> modificar(@RequestBody Campeonato seleccion) {
        var seleccionModificada = servicio.modificar(seleccion);
        if (seleccionModificada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seleccionModificada);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        boolean respuesta = servicio.eliminar(id);
        if (!respuesta) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.noContent().build();
    }

    // ***** Paises Organizadores *****

    @GetMapping(value = "/paises/{id}")
    public ResponseEntity<List<CampeonatoPais>> listarPaises(@PathVariable int id) {
        return ResponseEntity.ok(servicio.listarPaises(id));
    }

    @GetMapping(value = "/paises/obtener/{idCampeonato}/{idPais}")
    public ResponseEntity<Optional<CampeonatoPais>> obtenerPais(@PathVariable int idCampeonato, @PathVariable int idPais) {
        var campeonatoPaisBuscado = servicio.obtenerPais(idCampeonato, idPais);
        if (campeonatoPaisBuscado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(campeonatoPaisBuscado);
    }

    @PostMapping(value = "/paises/{idCampeonato}/{idPais}")
    public ResponseEntity<Object> agregarPais(int idCampeonato, int idPais) {
        var campeonatoPaisCreado = servicio.agregarPais(idCampeonato, idPais);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(campeonatoPaisCreado);
    }

    @PutMapping(value = "/paises/{idCampeonato}/{idPaisActual}/{idPaisNueva}")
    public ResponseEntity<Object> modificarPais(@PathVariable int idCampeonato, @PathVariable int idPaisActual, @PathVariable int idPaisNueva) {
        var campeonatoPaisModificado = servicio.modificarPais(idCampeonato, idPaisActual, idPaisNueva);
        if (campeonatoPaisModificado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(campeonatoPaisModificado);
    }

    @DeleteMapping(value = "/paises/{idCampeonato}/{idPais}")
    public ResponseEntity<Void> eliminarPais(@PathVariable int idCampeonato, @PathVariable int idPais) {
        boolean respuesta = servicio.eliminarPais(idCampeonato, idPais);
        if (!respuesta) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.noContent().build();
    }
}
