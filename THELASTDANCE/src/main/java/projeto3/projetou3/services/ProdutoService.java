package projeto3.projetou3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto3.projetou3.modelos.Produto;
import projeto3.projetou3.repositorios.IProduto;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private IProduto repository;


    @Autowired
    public void setRepository(IProduto repository) {
        this.repository = repository;
    }


    public Produto insert(Produto c){
        return repository.save(c);
    }

    public Produto update(Produto c){
        return repository.save(c);

    }

    public void delete(Produto c){
        repository.delete(c);
    }

    public Produto getOne(Long id){
        return repository.getOne(id);
    }


    public List<Produto> getAll() {
        return repository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return repository.findById(id);
    }


    public Produto saveAndFlush(Produto client) {
        return repository.saveAndFlush(client);
    }

}