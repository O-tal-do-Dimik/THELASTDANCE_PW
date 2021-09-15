package projeto3.projetou3.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto3.projetou3.modelos.Cliente;

public interface ICliente extends JpaRepository<Cliente,Long> {

}
