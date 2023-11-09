package utn.tienda_libros.modelo;

import jakarta.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    Integer idLibro;
    String nombreLibro;
    String autor;
    Double precio;
    Integer existencias;
  
}
