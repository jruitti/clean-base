package data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;
import java.util.logging.Level;

@Entity(name="course")
//Table(name="course")

public class CourseData {
    @Id
    private UUID id;
    @Column(name="name")
    private String name;
    @Column(name="inscription_Deadline")
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
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
