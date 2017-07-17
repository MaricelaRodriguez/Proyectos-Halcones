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
    public Empleado findByName(@PathVariable final String idEmpleado){
//        return empleadoJpaRespository.findByName(idEmpleado);
        return null;
    }

    @PostMapping(value = "/load")
    public Empleado load(@RequestBody final Empleado empleado) {
        empleadoJpaRespository.save(empleado);
        return empleado;
    }
    
    @PutMapping(value="/{idEmpleado}")
    public Empleado updateEmpleado(@PathVariable int idEmpleado, @RequestBody Empleado empleado){
    	Empleado emp = empleadoJpaRespository.findOne(idEmpleado);
    	if(emp != null){
    		emp.setNombre(empleado.getNombre());
    		emp.setApPaterno(empleado.getApPaterno());
    		emp.setApMaterno(empleado.getApMaterno());
    		emp.setEdad(empleado.getEdad());
    		emp.setSexo(empleado.getSexo());
    		empleadoJpaRespository.save(emp);
    		return empleado;
    	}
    	else{
    		return empleado;
    	}
    }
}
