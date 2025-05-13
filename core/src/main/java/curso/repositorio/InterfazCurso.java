package curso.repositorio;
import curso.modelo.Curso;


public interface InterfazCurso {
    boolean existeCursoNombre(String nombre);

    Curso guardar(Curso curso);

}
