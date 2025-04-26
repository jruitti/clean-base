package curso.modelo;
import curso.repositorio.InterfazCurso;

import curso.exception.CursoDuplicadoException;
import java.time.LocalDateTime;
import java.util.Objects;

public class Curso {
    private Long id;
    private String nombre;
    private LocalDateTime fechaCierreInscripcion;
    private Nivel nivel;


    private Curso(Long id, String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel)
    {

        this.id = id;
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;

    }
    public static Curso crearCurso(Long id,String nombre, LocalDateTime fechaCierreInscripcion, Nivel nivel, InterfazCurso interfazCurso) {
        if (interfazCurso.buscarPorNombre(nombre).isPresent()) {
            throw new CursoDuplicadoException("El curso ya existe");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (fechaCierreInscripcion == null) {
            throw new IllegalArgumentException("La fecha de cierre de inscripción es obligatoria");
        }
        if (nivel == null) {
            throw new IllegalArgumentException("El nivel es obligatorio");
        }

        return new Curso(id, nombre, fechaCierreInscripcion, nivel);
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Curso curso = (Curso) obj;
        return Objects.equals(nombre,curso.nombre);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaCierreInscripcion=" + fechaCierreInscripcion +
                ", nivel=" + nivel +
                '}';
    }
}