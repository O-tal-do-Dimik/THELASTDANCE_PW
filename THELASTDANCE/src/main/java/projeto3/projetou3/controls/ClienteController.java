package projeto3.projetou3.controls;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto3.projetou3.modelos.Cliente;
import projeto3.projetou3.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/Cliente")
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")
public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService service){
        this.service = service;
    }


    @GetMapping
    public List<Cliente> listAll() {

        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Cliente> getOne(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente insert(@RequestBody Cliente c){
        return service.insert(c);

    }

    @PutMapping(path = { "/{id}" })
    public ResponseEntity<Cliente> update(@PathVariable Long id,
                                          @RequestBody Cliente client) {
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
