package curso.exception;

public class ExisteCursoException extends RuntimeException {
    public ExisteCursoException(String elCursoYaExiste) {
        super(elCursoYaExiste);
    }
}
