package curso.usecase;

import curso.input.RegistrarCourseInput;
import curso.modelo.Course;
import curso.output.RegistrarCourseOutPut;
import curso.output.SearchCourseOutPut;

public class RegistrarCourseUC implements RegistrarCourseInput {
    private SearchCourseOutPut searchCourseOutPut;
    private RegistrarCourseOutPut registrarCourseOutPut;

    public RegistrarCourseUC(RegistrarCourseOutPut registrarCourseOutPut, SearchCourseOutPut searchCourseOutPut) {
        this.registrarCourseOutPut = registrarCourseOutPut;
        this.searchCourseOutPut = searchCourseOutPut;
    }

    @Override
    public boolean existCourse(String nombre) {
//        return search.searchCourse().stream().anyMatch(course -> course.getName().equals(nombre));
        return searchCourseOutPut.searchCourse().stream().anyMatch(course -> course.getName().equals(nombre));
    }

    @Override
    public boolean createCourse(Course course) {
        if (existCourse(course.getName())) {
            throw new RuntimeException("El curso ya existe");
        }
        return registrarCourseOutPut.saveCourse(course);
    }
}

