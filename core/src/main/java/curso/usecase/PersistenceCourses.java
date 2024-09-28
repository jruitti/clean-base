package curso.usecase;

import curso.modelo.Course;
import curso.modelo.Level;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class PersistenceCourses implements Persistence{
    private static ArrayList<Course> courses = new ArrayList<>();
    @Override
    public void saveCourse(Course course) {
        courses.add(course);
    }

    @Override
    public boolean searchCourse(String name){
        return courses.stream().anyMatch(course -> course.getName().equals(name));
    }

}
