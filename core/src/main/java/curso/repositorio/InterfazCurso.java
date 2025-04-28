package curso.repositorio;
import curso.modelo.Curso;
import java.util.*;

public interface InterfazCurso {
    boolean existePorNombre(String nombre);
    Optional<Curso>buscarPorNombre(String nombre);
    Curso guardar (Curso curso);
    List<Curso>buscarTodos();

}
