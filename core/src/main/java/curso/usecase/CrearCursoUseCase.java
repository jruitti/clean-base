package curso.usecase;
import curso.input.InterfazCrearCurso;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.exception.CursoDuplicadoException;
import curso.repositorio.InterfazCurso;
import java.time.LocalDateTime;


public class CrearCursoUseCase implements InterfazCrearCurso {
    private final InterfazCurso interfazCurso;

    public CrearCursoUseCase(InterfazCurso interfazCurso) {
        this.interfazCurso = interfazCurso;
    }

    @Override
    public Curso crearCurso(long id, String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel) throws CursoDuplicadoException {
        if (interfazCurso.existeCursoNombre(nombre)) {
            throw new CursoDuplicadoException("El curso ya existe");
        }
        Curso curso = Curso.factory(id,nombre,fechaCierreInscripcion,nivel);
        return interfazCurso.guardar(curso);
    }
}
