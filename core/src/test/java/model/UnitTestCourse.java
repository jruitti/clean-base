package model;

import curso.modelo.Course;
import curso.modelo.Level;
import curso.usecase.PersistenceCourses;
import curso.input.RegisterCourse;
import curso.usecase.Persistence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.when;

public class UnitTestCourse {
    @Mock
    private PersistenceCourses persistence;

    @Test
    public void instanceCourse_Assert() throws Exception {
        Course c = Course.Instance(null,"Matematicas", LocalDate.of(2024, 11, 10), Level.Avanzado);
        Assertions.assertNotNull(c);
    }
    @Test
    public void uploadCourse_Assert() throws Exception {
        Persistence persistence = new PersistenceCourses();
        RegisterCourse registerCourse = new RegisterCourse(persistence);

        registerCourse.createCourse(UUID.randomUUID(),"Matematicas", LocalDate.of(2024, 11, 10), Level.Avanzado);

        Assertions.assertTrue(persistence.searchCourse("Matematicas"));
    }

    @Test
    public void firstTryMock() throws Exception {
        //time to self learn :D
        Persistence persistence = new PersistenceCourses();
        RegisterCourse registerCourse = new RegisterCourse(persistence);

        registerCourse.createCourse(UUID.randomUUID(),"Matematicas", LocalDate.of(2024, 11, 10), Level.Avanzado);

        when(persistence.searchCourse("Matematicas")).thenReturn(false);
    }
}
