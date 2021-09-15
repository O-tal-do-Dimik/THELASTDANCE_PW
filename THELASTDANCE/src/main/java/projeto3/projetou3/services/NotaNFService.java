package projeto3.projetou3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto3.projetou3.modelos.NotaNF;
import projeto3.projetou3.repositorios.INotaNF;

import java.util.List;
import java.util.Optional;

@Service
public class NotaNFService {


    private INotaNF repository;


    @Autowired
    public void setRepository(INotaNF repository) {
        this.repository = repository;
    }

    public NotaNF insert(NotaNF c){
        return repository.save(c);
    }

    public NotaNF update(NotaNF c){
        return repository.save(c);

    }

    public void delete(NotaNF c){
        repository.delete(c);
    }

    public NotaNF getOne(Long id){
        return repository.getOne(id);
    }

    public List<NotaNF> getAll() {
        return repository.findAll();
    }

    public Optional<NotaNF> findById(Long id) {
        return repository.findById(id);
    }

    public NotaNF saveAndFlush(NotaNF client) {
        return repository.saveAndFlush(client);
    }

}
