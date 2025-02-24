package model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String estilo;
    private Double precioSalida;
    private String imagenUrl;

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Usuario artista;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Usuario propietario;

    @ManyToOne
    @JoinColumn(name = "exposicion_id")
    private Exposicion exposicion;

    @OneToMany(mappedBy = "obra")
    private List<Oferta> ofertas;
}