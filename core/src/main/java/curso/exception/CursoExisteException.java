package curso.exception;

public class CursoExisteException extends RuntimeException {
    public CursoExisteException(String message) {
        super(message);
    }
}
