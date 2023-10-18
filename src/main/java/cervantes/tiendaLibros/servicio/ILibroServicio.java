package cervantes.tiendaLibros.servicio;

import cervantes.tiendaLibros.modelo.Libro;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ILibroServicio {
    public List<Libro>listarLibros();

    public Libro buscarLibroId(Integer idLibro);

    public void guardarLibro(Libro libro);

    public void eliminarLibro(Libro libro);
}
