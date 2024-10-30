package service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import curso.modelo.Course;
import curso.modelo.Level;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.UUID;

@Table
public class CourseDTO {

    @Id
    private UUID id;
    @Column(name = "name")
    private String name; // Cambié `nombre` a `name`
    @Column(name = "inscription_deadline")
    private LocalDate fecha_cierre_inscripcion;
    @Column(name = "level")
    private Level level;

    public CourseDTO(UUID id, String name, LocalDate fecha_cierre_inscripcion, Level level) {
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

    public static Course toDomain(CourseDTO courseDTO) {
        return Course.InstanciaCurso(courseDTO.getId(), courseDTO.getName(), courseDTO.getFecha_cierre_inscripcion(), courseDTO.getLevel());
    }

}

