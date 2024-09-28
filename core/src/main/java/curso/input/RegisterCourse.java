package curso.input;

import curso.exception.ExceptionCourse;
import curso.modelo.Course;
import curso.modelo.Level;
import curso.usecase.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class RegisterCourse implements CreateCourse{
    private final Persistence persistence;

    public RegisterCourse(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public void createCourse (UUID id, String name, LocalDate date, Level lvl) throws ExceptionCourse {
        if (persistence.searchCourse(name)) {
            throw new ExceptionCourse("Ya existe curso con ese nombre!");
        }
        Course c = Course.Instance(id, name, date,lvl);
        persistence.saveCourse(c);
        }
    }
