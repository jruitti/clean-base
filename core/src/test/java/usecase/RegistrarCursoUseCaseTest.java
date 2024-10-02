package usecase;

import curso.input.RegistrarCursoInput;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.output.RegistrarCursoOutput;
import curso.usecase.RegistrarCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegistrarCursoUseCaseTest {

    RegistrarCursoInput registrarCursoInput;
    @Mock
    RegistrarCursoOutput registrarCursoOutput;

    @BeforeEach
    void setup() {
        registrarCursoInput = new RegistrarCursoUseCase(registrarCursoOutput);
    }

    @Test
    public void testRegistrarCurso() {
        Curso curso = Curso.instanciaCurso(null,"matematica", LocalDate.of(2024,11,19), Nivel.MEDIO);
        when(registrarCursoOutput.existeCurso("matematica")).thenReturn(false);
        when(registrarCursoOutput.registrarCurso(curso)).thenReturn(1);
        Integer cursoRecibido = registrarCursoInput.registrarCurso(curso);
        Assertions.assertEquals(1,cursoRecibido);
    }

}
