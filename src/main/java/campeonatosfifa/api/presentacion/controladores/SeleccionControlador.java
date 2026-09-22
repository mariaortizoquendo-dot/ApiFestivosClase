package campeonatosfifa.api.presentacion.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

  private final ISeleccionServicio servicio;

  SeleccionControlador(ISeleccionServicio servicio) {
    this.servicio = servicio;
  }

  @GetMapping(value = "/")
  public List<Seleccion> listar() {
    return servicio.listar();
  }

  @GetMapping(value = "/{id}")
  public Seleccion obtener(@PathVariable int id) {
    return servicio.obtener(id);
  }

  @GetMapping(value = "/buscar/{nombre}")
  public List<Seleccion> buscar(@PathVariable String nombre) {
    return servicio.buscar(nombre);
  }

  @PostMapping(value = "/")
  public Seleccion agregar(@RequestBody Seleccion seleccion) {
    return servicio.agregar(seleccion);
  }

  @PutMapping(value = "/")
  public Seleccion modificar(@RequestBody Seleccion seleccion) {
    return servicio.modificar(seleccion);
  }

  @DeleteMapping(value = "/{id}")
  public boolean eliminar(@PathVariable int id) {
    return servicio.eliminar(id);
  }

}
