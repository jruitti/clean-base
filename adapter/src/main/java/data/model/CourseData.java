package data.model;

import curso.modelo.Level;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
//Table(name="course")

public class CourseData {
    @Id
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

    public static CourseData fromDomain(CourseData coreCourse) {
        return new CourseData(coreCourse.getId(), coreCourse.getName(), coreCourse.getFecha_cierre_inscripcion(), coreCourse.getLevel());
    }

}
