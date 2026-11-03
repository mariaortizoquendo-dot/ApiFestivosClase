package campeonatosfifa.api.presentacion.controladores;


import campeonatosfifa.api.core.servicios.ICiudadServicio;
import campeonatosfifa.api.dominio.entidades.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadControlador {

    private ICiudadServicio servicio;

    @GetMapping
    public ResponseEntity<List<Ciudad>> listar() {
        return ResponseEntity.ok(servicio.listar());
    }

    @GetMapping(value = "/pais/{idPais}")
    public ResponseEntity<List<Ciudad>> listarPorPais(@PathVariable int idPais) {
        return ResponseEntity.ok(servicio.listarPorPais(idPais));
    }

    @GetMapping(value = "/campeonato/{idCampeonato}")
    public ResponseEntity<List<Ciudad>> listarPorCampeonato(int idCampeonato) {
        return ResponseEntity.ok(servicio.listarPorCampeonato(idCampeonato));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ciudad> obtener(@PathVariable int id) {
        var seleccionBuscada = servicio.obtener(id);
        if (seleccionBuscada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seleccionBuscada);
    }

    @GetMapping(value = "/buscar/{nombre}")
    public ResponseEntity<List<Ciudad>> buscar(@PathVariable String nombre) {
        return ResponseEntity.ok(servicio.buscar(nombre));
    }

    @PostMapping
    public ResponseEntity<Ciudad> agregar(@RequestBody Ciudad seleccion) {
        var seleccionCreada = servicio.agregar(seleccion);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(seleccionCreada);
    }

    @PutMapping
    public ResponseEntity<Ciudad> modificar(@RequestBody Ciudad seleccion) {
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

}
