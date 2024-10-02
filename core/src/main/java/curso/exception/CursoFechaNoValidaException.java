package curso.exception;

public class CursoFechaNoValidaException extends RuntimeException {
    public CursoFechaNoValidaException(String laFechaNoEsValida) {
        super(laFechaNoEsValida);
    }
}
