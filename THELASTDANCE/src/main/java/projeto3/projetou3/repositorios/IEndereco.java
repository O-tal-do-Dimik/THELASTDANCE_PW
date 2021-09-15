package projeto3.projetou3.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto3.projetou3.modelos.Endereco;

public interface IEndereco extends JpaRepository<Endereco ,Long> {
}
