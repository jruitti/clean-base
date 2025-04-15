package curso.modelo;
import curso.repositorio.InterfazCurso;

import curso.exception.CursoDuplicadoException;
import java.time.LocalDateTime;

public class Curso {
    private Long id;
    private String nombre;
    private LocalDateTime fechaCierreInscripcion;
    private Nivel nivel;


    private Curso(Long id, String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel, InterfazCurso repository)
            throws IllegalArgumentException, CursoDuplicadoException{
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (fechaCierreInscripcion == null) {
            throw new IllegalArgumentException("La fecha de cierre de inscripción no puede ser nula");
        }
        if (nivel == null) {
            throw new IllegalArgumentException("El nivel es obligatorio");
        }
        if (repository != null && repository.existeCurso(nombre)) {
            throw new CursoDuplicadoException("El curso con nombre " + nombre + " ya existe");
        }
        this.id = id;
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;

    }

    public static Curso crear(Long id, String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel, InterfazCurso repository)
            throws IllegalArgumentException, CursoDuplicadoException {
        return new Curso(id, nombre, fechaCierreInscripcion, nivel, repository);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDateTime getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public Nivel getNivel() {
        return nivel;
    }
}