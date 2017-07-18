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
    public Empleado findOne(@PathVariable final Integer idEmpleado){
        return empleadoJpaRespository.findOne(idEmpleado);
    }


    @PostMapping(value = "/load")
    public Empleado load(@RequestBody final Empleado empleado) {
        empleadoJpaRespository.save(empleado);
        return empleado;
    }
    
    @PutMapping(value="/update")
    public Empleado updateEmpleado(@RequestBody Empleado empleado){
    	Empleado emp = empleadoJpaRespository.findOne(empleado.getIdEmpleado());
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
    
    @DeleteMapping(value="/{idEmpleado}")
    public String deleteEmpleado(@PathVariable int idEmpleado){
    	Empleado emp = empleadoJpaRespository.findOne(idEmpleado);
    	if(emp != null){
    		empleadoJpaRespository.delete(idEmpleado);
    		return "Empleado eliminado";
    	}else{
    		return "No se pudo eliminar el empleado";
    	}
    }
}
