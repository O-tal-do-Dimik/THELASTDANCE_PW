package projeto3.projetou3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto3.projetou3.modelos.Cliente;
import projeto3.projetou3.repositorios.ICliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ICliente repository;


    @Autowired
    public void setRepository(ICliente repository) {
        this.repository = repository;
    }


    public Cliente insert(Cliente c){
        return repository.save(c);
    }

    public Cliente update(Cliente c){
        return repository.save(c);

    }

    public void delete(Cliente c){
        repository.delete(c);
    }

    public Cliente getOne(Long id){
        return repository.getOne(id);
    }


    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    public Cliente saveAndFlush(Cliente client) {
        return repository.saveAndFlush(client);
    }

}