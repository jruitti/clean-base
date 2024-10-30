package curso.usecase;

import curso.input.RegistrarCourseInput;
import curso.modelo.Course;
import curso.output.RegistrarCourseOutPut;

public class RegistrarCourseUC implements RegistrarCourseInput {
    private SearchCourseUC search;
    private RegistrarCourseOutPut registrarCourseOutPut;

    public RegistrarCourseUC(RegistrarCourseOutPut registrarCourseOutPut) {
        this.registrarCourseOutPut = registrarCourseOutPut;
        this.search = search;
    }

    @Override
    public boolean existCourse(String nombre) {
        return search.searchCourse().stream().anyMatch(course -> course.getName().equals(nombre));
    }

    @Override
    public boolean createCourse(Course course) {
        if (existCourse(course.getName())) {
            throw new RuntimeException("El curso ya existe");
        }
        return registrarCourseOutPut.saveCourse(course);
    }
}

