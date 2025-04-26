package curso.repositorio;
import curso.modelo.Curso;
import java.util.*;

public interface InterfazCurso {
    Curso gurdar (Curso curso);
    List<Curso>buscarTodos();
    Optional<Curso>buscarPorNombre(String nombre);

}
