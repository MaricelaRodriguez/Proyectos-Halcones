package mx.com.halcones.halconeseurekacliente.repository;

import mx.com.halcones.halconeseurekacliente.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmpleadoJpaRespository extends JpaRepository<Empleado, Integer>{


}
