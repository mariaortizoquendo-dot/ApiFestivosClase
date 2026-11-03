package campeonatosfifa.api.presentacion.controladores;

import java.util.List;

import campeonatosfifa.api.dominio.entidades.Encuentro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import campeonatosfifa.api.core.servicios.IEncuentroServicio;
import campeonatosfifa.api.dominio.entidades.Encuentro;

@RestController
@RequestMapping("/api/encuentros")
public class EncuentroControlador {

    @Autowired
    private IEncuentroServicio servicio;

    @GetMapping(value = "/campeonato/{idCampeonato}")
    public ResponseEntity<List<Encuentro>> listarPorCampeonato(@PathVariable int idCampeonato) {
        var lista = servicio.listarPorCampeonato(idCampeonato);
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/campeonatofase/{idCampeonato}/{idEncuentro}")
    public ResponseEntity<List<Encuentro>> listarPorCampeonatoYEncuentro(@PathVariable int idCampeonato,
            @PathVariable int idEncuentro) {
        var lista = servicio.listarPorCampeonatoYFase(idCampeonato, idEncuentro);
        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/grupo/{idGrupo}")
    public ResponseEntity<List<Encuentro>> listarPorGrupo(@PathVariable int idGrupo) {
        var lista = servicio.listarPorGrupo(idGrupo);
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Encuentro> agregar(@RequestBody Encuentro encuentro) {
        var encuentroCreado = servicio.agregar(encuentro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(encuentroCreado);
    }

    @PutMapping
    public ResponseEntity<Encuentro> modificar(@RequestBody Encuentro encuentro) {
        var encuentroModificado = servicio.modificar(encuentro);
        if (encuentroModificado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(encuentroModificado);
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
