package campeonatosfifa.api.presentacion.controladores;


import campeonatosfifa.api.core.servicios.IEstadioServicio;
import campeonatosfifa.api.dominio.entidades.Ciudad;
import campeonatosfifa.api.dominio.entidades.Estadio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadios")
public class EstadioControlador {

    private IEstadioServicio servicio;

    @GetMapping
    public ResponseEntity<List<Estadio>> listar() {
        return ResponseEntity.ok(servicio.listar());
    }

    @GetMapping(value = "/pais/{idPais}")
    public ResponseEntity<List<Estadio>> listarPorPais(@PathVariable int idPais) {
        return ResponseEntity.ok(servicio.listarPorPais(idPais));
    }

    @GetMapping(value = "/campeonato/{idCampeonato}")
    public ResponseEntity<List<Estadio>> listarPorCampeonato(int idCampeonato) {
        return ResponseEntity.ok(servicio.listarPorCampeonato(idCampeonato));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estadio> obtener(@PathVariable int id) {
        var seleccionBuscada = servicio.obtener(id);
        if (seleccionBuscada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seleccionBuscada);
    }

    @GetMapping(value = "/buscar/{nombre}")
    public ResponseEntity<List<Estadio>> buscar(@PathVariable String nombre) {
        return ResponseEntity.ok(servicio.buscar(nombre));
    }

    @PostMapping
    public ResponseEntity<Estadio> agregar(@RequestBody Estadio seleccion) {
        var seleccionCreada = servicio.agregar(seleccion);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(seleccionCreada);
    }

    @PutMapping
    public ResponseEntity<Estadio> modificar(@RequestBody Estadio seleccion) {
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
