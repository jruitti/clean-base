package curso.modelo;

import curso.exception.ExcepcionCurso;

import java.time.LocalDateTime;
import java.util.Objects;

public class Curso {
    private Long id;
    private String nombre;
    private LocalDateTime fechaCierreInscripcion;
    private Nivel nivel;

    private Curso(Long id, String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
    }

    public static Curso factory(Long id, String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel) throws ExcepcionCurso {
        if (nombre == null || nombre.isEmpty()) {
            throw new ExcepcionCurso("El nombre es obligatorio");
        }
        if (fechaCierreInscripcion == null || fechaCierreInscripcion.isBefore(LocalDateTime.now())) {
            throw new ExcepcionCurso("La fecha de cierre de inscripción es obligatoria");
        }
        if (nivel == null) {
            throw new ExcepcionCurso("El nivel es obligatorio");
        }

        return new Curso(id, nombre, fechaCierreInscripcion, nivel);
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