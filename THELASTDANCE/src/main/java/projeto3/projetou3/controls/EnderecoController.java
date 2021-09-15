package projeto3.projetou3.controls;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto3.projetou3.modelos.Endereco;
import projeto3.projetou3.services.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/Endereco")
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")


public class EnderecoController {

    private EnderecoService service;

    public EnderecoController(EnderecoService service){
        this.service = service;
    }


    @GetMapping
    public List<Endereco> listAll() {

        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Endereco> getOne(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Endereco insert(@RequestBody Endereco c){
        return service.insert(c);

    }

    @PutMapping(path = { "/{id}" })
    public ResponseEntity<Endereco> update(@PathVariable Long id,
                                           @RequestBody Endereco client) {
        return service.findById(id).map(record -> {
            service.saveAndFlush(client);
            return ResponseEntity.ok().body(client);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return service.findById(id).map(record -> {
            service.delete(record);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }


}
