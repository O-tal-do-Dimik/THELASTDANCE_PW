package projeto3.projetou3.controls;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto3.projetou3.modelos.NotaNF;
import projeto3.projetou3.services.NotaNFService;

import java.util.List;

@RestController
@RequestMapping("/NotaNF")
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")

public class NotaNFController {

    private NotaNFService service;

    public NotaNFController(NotaNFService service){
        this.service = service;
    }


    @GetMapping
    public List<NotaNF> listAll() {

        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<NotaNF> getOne(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NotaNF insert(@RequestBody NotaNF c){
        return service.insert(c);

    }

    @PutMapping(path = { "/{id}" })
    public ResponseEntity<NotaNF> update(@PathVariable Long id,
                                         @RequestBody NotaNF client) {
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
