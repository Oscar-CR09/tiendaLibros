package cervantes.tiendaLibros.repositorio;

import cervantes.tiendaLibros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository <Libro,Integer>{


}
