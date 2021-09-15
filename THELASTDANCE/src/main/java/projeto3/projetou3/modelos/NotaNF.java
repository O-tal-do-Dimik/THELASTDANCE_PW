package projeto3.projetou3.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NotaNF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;



    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "compra",
            joinColumns = @JoinColumn(name = "NotaNF_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Produto_id")
    )
    List<Produto> produtos;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    Cliente cliente;

}
