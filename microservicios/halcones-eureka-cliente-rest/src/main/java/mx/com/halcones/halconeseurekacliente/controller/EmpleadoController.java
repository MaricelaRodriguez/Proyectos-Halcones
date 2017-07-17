package mx.com.halcones.halconeseurekacliente.controller;

import mx.com.halcones.halconeseurekacliente.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import mx.com.halcones.halconeseurekacliente.repository.EmpleadoJpaRespository;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoJpaRespository empleadoJpaRespository;

    @GetMapping(value = "/all")
    public List<Empleado> findAll() {
        return empleadoJpaRespository.findAll();
    }

    @GetMapping(value = "/{idEmpleado}")
    public Empleado getOne(@PathVariable final Integer idEmpleado){
        return empleadoJpaRespository.getOne(idEmpleado);
    }

    @PostMapping(value = "/load")
    public Empleado load(@RequestBody final Empleado empleado) {
        empleadoJpaRespository.save(empleado);
        return empleado;
    }
}
