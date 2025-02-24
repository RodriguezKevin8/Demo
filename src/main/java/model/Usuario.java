package model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String password;

    @OneToMany(mappedBy = "artista")
    private List<Obra> obrasCreadas;

    @OneToMany(mappedBy = "propietario")
    private List<Obra> obrasPropiedad;

    @OneToMany(mappedBy = "usuario")
    private List<Oferta> ofertas;

    @OneToMany(mappedBy = "usuario")
    private List<Pago> pagos;
}
