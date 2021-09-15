package projeto3.projetou3.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto3.projetou3.modelos.Produto;

public interface IProduto extends JpaRepository<Produto, Long> {


}