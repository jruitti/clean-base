package curso.input;

import curso.modelo.Curso;
import curso.modelo.Nivel;

import java.time.LocalDateTime;

public interface InterfazCrearCurso{
    Curso crearCurso(long id, String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel);
}
