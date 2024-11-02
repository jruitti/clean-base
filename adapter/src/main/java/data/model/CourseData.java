package data.model;

import curso.modelo.Level;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class CourseData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="inscription_deadline")
    private LocalDate fecha_cierre_inscripcion;
    @Column(name="level")
    private Level level;

    public CourseData() {
    }

    public CourseData(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level level) {
        this.id = id;
        this.name = name;
        this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
        this.level = level;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public LocalDate getFecha_cierre_inscripcion() {
        return fecha_cierre_inscripcion;
    }
    public Level getLevel() {
        return level;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFecha_cierre_inscripcion(LocalDate fecha_cierre_inscripcion) {
        this.fecha_cierre_inscripcion = fecha_cierre_inscripcion;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public static CourseData fromDomain(CourseData coreCourse) {
        return new CourseData(coreCourse.getId(), coreCourse.getName(), coreCourse.getFecha_cierre_inscripcion(), coreCourse.getLevel());
    }

}
