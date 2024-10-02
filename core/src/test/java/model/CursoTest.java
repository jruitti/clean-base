package model;

import curso.exception.CursoFechaNoValidaException;
import curso.exception.CursoNivelNoValidaException;
import curso.exception.CursoNombreNuloException;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CursoTest {

   @Test
    public void test01() {

        Curso miCurso = Curso.instanciaCurso(1,"nombre",LocalDate.of(2024,11,30),Nivel.MEDIO);
        Assertions.assertNotNull(miCurso);

    }

    @Test
    public void test02() {

        RuntimeException excepcion = Assertions.assertThrows(CursoNombreNuloException.class, ()->Curso.instanciaCurso(1,"",LocalDate.of(2024,11,30),Nivel.MEDIO));
        Assertions.assertEquals("El nombre es invalido", excepcion.getMessage());
    }

    @Test
    public void test03() {

        RuntimeException excepcion = Assertions.assertThrows(CursoNombreNuloException.class, ()->Curso.instanciaCurso(1,null,LocalDate.of(2024,11,30),Nivel.MEDIO));
        Assertions.assertEquals("El nombre es invalido", excepcion.getMessage());
    }

    @Test
    public void test04() {

        RuntimeException excepcion = Assertions.assertThrows(CursoFechaNoValidaException.class, ()->Curso.instanciaCurso(1,"Carlos",LocalDate.of(2023,11,30),Nivel.MEDIO));
        Assertions.assertEquals("La fecha no es valida", excepcion.getMessage());
    }

    @Test
    public void test05() {

        RuntimeException excepcion = Assertions.assertThrows(CursoNivelNoValidaException.class, ()->Curso.instanciaCurso(1,"Carlos",LocalDate.of(2024,11,30),null));
        Assertions.assertEquals("El nivel es invalido", excepcion.getMessage());
    }
}
