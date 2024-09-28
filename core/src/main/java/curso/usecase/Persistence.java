package curso.usecase;

import curso.modelo.Course;
import curso.modelo.Level;
import java.time.LocalDate;
import java.util.UUID;

public interface Persistence {
    void saveCourse(Course course);
    boolean searchCourse(String name);
}
