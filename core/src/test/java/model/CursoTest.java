package model;

import curso.exception.ExcepcionCurso;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class CursoTest {
    @Test
    public void testCursoFactory_True() {
        Curso curso=Curso.factory(1234L,"curso", LocalDateTime.MAX , Nivel.INICIAL);
        Assertions.assertNotNull(curso);
    }

    @Test
    public void testCursoFactory_Exception() {
        Assertions.assertThrows(ExcepcionCurso.class, () -> Curso.factory(1234L,null, LocalDateTime.MAX , Nivel.INICIAL));
        Assertions.assertThrows(ExcepcionCurso.class, () -> Curso.factory(1234L,"", LocalDateTime.MAX , Nivel.INICIAL));
        Assertions.assertThrows(ExcepcionCurso.class, () -> Curso.factory(1234L,"curso", null , Nivel.INICIAL));
        Assertions.assertThrows(ExcepcionCurso.class, () -> Curso.factory(1234L,"curso", LocalDateTime.MIN , Nivel.INICIAL));
        Assertions.assertThrows(ExcepcionCurso.class, () -> Curso.factory(1234L,"Curso", LocalDateTime.MAX , null));
    }


}
