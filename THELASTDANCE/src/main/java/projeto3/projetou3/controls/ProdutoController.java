package projeto3.projetou3.controls;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto3.projetou3.modelos.Produto;
import projeto3.projetou3.services.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/Produto")
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")


public class ProdutoController {


    private ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }


    @GetMapping
    public List<Produto> listAll() {

        return service.getAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Produto> getOne(@PathVariable Long id) {
        return service.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto insert(@RequestBody Produto c){
        return service.insert(c);

    }

    @PutMapping(path = { "/{id}" })
    public ResponseEntity<Produto> update(@PathVariable Long id,
                                          @RequestBody Produto client) {
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
