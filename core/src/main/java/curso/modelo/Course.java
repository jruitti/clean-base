package curso.modelo;

import curso.exception.ExceptionCourse;

import java.time.LocalDate;
import java.util.UUID;

public class Course {
    private UUID id;
    private String name;
    private LocalDate inscriptionDate;
    private Level level;
    private Course(UUID id, String name, LocalDate inscriptionDate, Level nivel) {
        this.id = id;
        this.name = name;
        this.inscriptionDate = inscriptionDate;
        this.level = nivel;
    }

    public static Course Instance(UUID id, String name, LocalDate inscriptionDate, Level level) throws ExceptionCourse {
      if (LocalDate.now().isAfter(inscriptionDate)) {
          throw new ExceptionCourse("La fecha es anterior al dia de hoy");
      }
      if (name == null || name.isEmpty()) {
          throw new ExceptionCourse("Error al Ingresar nombre");
      }
        return new Course(id, name, inscriptionDate, level);
    }

    public String getName() {
        return name;
    }
}
