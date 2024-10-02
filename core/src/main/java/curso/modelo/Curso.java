package curso.modelo;

import curso.exception.CursoFechaNoValidaException;
import curso.exception.CursoNivelNoValidaException;
import curso.exception.CursoNombreNuloException;

import java.time.LocalDate;

public class Curso {

    private Integer id;
    private String nombre;
    private LocalDate fecha;
    private Nivel nivel;

    private Curso(Integer id, String nombre, LocalDate fecha, Nivel nivel) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.nivel = nivel;
    }

    public static Curso instanciaCurso(Integer id, String nombre, LocalDate fecha, Nivel nivel) {
        if(nombre == null || nombre.isBlank())
            throw new CursoNombreNuloException("El nombre es invalido");
        if(fecha == null || fecha.isBefore(LocalDate.now()))
            throw new CursoFechaNoValidaException("La fecha no es valida");
        if(nivel == null)
            throw new CursoNivelNoValidaException("El nivel es invalido");
        return new Curso(id, nombre, fecha, nivel);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Nivel getNivel() {
        return nivel;
    }
}
