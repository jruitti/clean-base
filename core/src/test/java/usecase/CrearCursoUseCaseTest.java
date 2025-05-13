package usecase;

import curso.exception.CursoDuplicadoException;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.repositorio.InterfazCurso;
import curso.usecase.CrearCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CrearCursoUseCaseTest {

    @Mock
    private InterfazCurso interfazCurso;
    private CrearCursoUseCase crearCursoUseCase;

    @BeforeEach
    public void setUp() {
        crearCursoUseCase= new CrearCursoUseCase(interfazCurso);
    }

    void CreaCursoExitosamente() {
        Curso curso=Curso.factory(1234L,"curso", LocalDateTime.MAX, Nivel.INICIAL);

        when(interfazCurso.existeCursoNombre(curso.getNombre())).thenReturn(false);
        when(interfazCurso.guardar(curso)).thenReturn(curso);


        Curso cursoActual = crearCursoUseCase.crearCurso(curso.getId(),curso.getNombre(),curso.getFechaCierreInscripcion(),curso.getNivel());

        Assertions.assertNotNull(cursoActual);
        Assertions.assertEquals(curso.getNombre(), cursoActual.getNombre());
        Assertions.assertEquals(curso.getFechaCierreInscripcion(), cursoActual.getFechaCierreInscripcion());
        Assertions.assertEquals(curso.getNivel(), cursoActual.getNivel());
    }


    void CursoDuplicadoException() {
        Curso curso=Curso.factory(1234L,"curso",LocalDateTime.MAX,Nivel.INICIAL);

        when(interfazCurso.existeCursoNombre(curso.getNombre())).thenReturn(true);
        Assertions.assertThrows(CursoDuplicadoException.class,()->crearCursoUseCase.crearCurso(curso.getId(), curso.getNombre(), curso.getFechaCierreInscripcion(),curso.getNivel()));
    }
}
