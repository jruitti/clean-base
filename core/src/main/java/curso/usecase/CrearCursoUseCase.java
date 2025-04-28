package curso.usecase;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.exception.CursoDuplicadoException;
import curso.repositorio.InterfazCurso;
import java.time.LocalDateTime;


public class CrearCursoUseCase {
    private final InterfazCurso interfazCurso;
    public CrearCursoUseCase(InterfazCurso interfazCurso) {
        this.interfazCurso = interfazCurso;
    }
    public Curso ejecutar(String nombre,LocalDateTime fechaCierreInscripcion,Nivel nivel ) {
        if (interfazCurso.existePorNombre(nombre)) {
            throw new CursoDuplicadoException("El curso ya existe");
        }
        Curso nuevoCurso = Curso.crearCurso(null, nombre, fechaCierreInscripcion, nivel, interfazCurso);
        return interfazCurso.guardar(nuevoCurso);

    }



}
