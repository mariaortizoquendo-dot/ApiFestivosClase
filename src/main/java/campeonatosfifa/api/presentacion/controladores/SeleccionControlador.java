package campeonatosfifa.api.presentacion.controladores;

import java.util.List;

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

import campeonatosfifa.api.core.servicios.ISeleccionServicio;
import campeonatosfifa.api.dominio.entidades.Seleccion;

@RestController
@RequestMapping("/api/selecciones")
public class SeleccionControlador {

  @Autowired
  private ISeleccionServicio servicio;

  @GetMapping
  public ResponseEntity<List<Seleccion>> listar() {
    return ResponseEntity.ok(servicio.listar());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Seleccion> obtener(@PathVariable int id) {
    var seleccionBuscada = servicio.obtener(id);
    if (seleccionBuscada == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(seleccionBuscada);
  }

  @GetMapping(value = "/buscar/{nombre}")
  public ResponseEntity<List<Seleccion>> buscar(@PathVariable String nombre) {
    return ResponseEntity.ok(servicio.buscar(nombre));
  }

  @PostMapping
  public ResponseEntity<Seleccion> agregar(@RequestBody Seleccion seleccion) {
    var seleccionCreada = servicio.agregar(seleccion);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(seleccionCreada);
  }

  @PutMapping
  public ResponseEntity<Seleccion> modificar(@RequestBody Seleccion seleccion) {
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
