package campeonatosfifa.api.presentacion.controladores;

import campeonatosfifa.api.core.servicios.IFaseServicio;
import campeonatosfifa.api.dominio.entidades.Fase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fases")
public class FaseControlador {

    private IFaseServicio servicio;

    @GetMapping
    public ResponseEntity<List<Fase>> listar() {
        return ResponseEntity.ok(servicio.listar());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Fase> obtener(@PathVariable int id) {
        var faseBuscada = servicio.obtener(id);
        if (faseBuscada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faseBuscada);
    }

    @GetMapping(value = "/buscar/{nombre}")
    public ResponseEntity<List<Fase>> buscar(@PathVariable String nombre) {
        return ResponseEntity.ok(servicio.buscar(nombre));
    }

    @PostMapping
    public ResponseEntity<Fase> agregar(@RequestBody Fase fase) {
        var faseCreada = servicio.agregar(fase);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(faseCreada);
    }

    @PutMapping
    public ResponseEntity<Fase> modificar(@RequestBody Fase fase) {
        var faseModificada = servicio.modificar(fase);
        if (faseModificada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faseModificada);
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
