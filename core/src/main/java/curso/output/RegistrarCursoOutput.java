package curso.output;

import curso.modelo.Curso;

public interface RegistrarCursoOutput {
    Integer registrarCurso(Curso curso);
    boolean existeCurso(String nombre);
}
