package usecase;

import curso.input.CrearCursoInput;
import curso.modelo.CursoNivel;
import curso.output.BuscarCursoPorIdRepository;
import curso.output.CrearCursoRepository;
import curso.usecase.crearcursousecase.CrearCursoRequestModel;
import curso.usecase.crearcursousecase.CrearCursoUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoTest {
    CrearCursoInput crearCursoInput;

    private UUID cursoId = UUID.randomUUID();

    @Mock
    CrearCursoRepository crearCursoRepository;

    @Mock
    BuscarCursoPorIdRepository buscarCursoPorIdRepository;

    @BeforeEach
    void setUp() {crearCursoInput = new CrearCursoUseCase(crearCursoRepository, buscarCursoPorIdRepository);}

    @Test
    void crearCurso_cursoNoExste_crearCurso() {
        CrearCursoRequestModel curso = CrearCursoRequestModel.factory(cursoId, "Programación", LocalDate.MAX, CursoNivel.MEDIO);
        when(crearCursoRepository.buscarCurso(cursoId).thenReturn(false));
    }
}
