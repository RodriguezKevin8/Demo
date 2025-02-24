package model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Exposicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String fechaInauguracion;
    private String fechaClausura;

    @OneToMany(mappedBy = "exposicion")
    private List<Obra> obras;
}