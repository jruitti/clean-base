package curso.usecase;
import curso.modelo.Curso;
import curso.repositorio.InterfazCurso;
import java.util.*;

public class BuscarCursosUseCase  {
    private final InterfazCurso interfazCurso;

    public BuscarCursosUseCase(InterfazCurso interfazCurso) {
        this.interfazCurso = interfazCurso;
    }

    public List<Curso> ejecutar() {
        return interfazCurso.buscarTodos();
    }
}
