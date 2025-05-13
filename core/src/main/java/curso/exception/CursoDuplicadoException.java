package curso.exception;

public class CursoDuplicadoException extends RuntimeException {
  public CursoDuplicadoException(String message) {
    super(message);
  }
}
