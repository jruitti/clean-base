package curso.usecase;

import curso.exception.CursoDuplicadoException;
import curso.modelo.Curso;
import curso.modelo.Nivel;
import curso.repositorio.InterfazCurso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrearCursoUseCaseTest {

    @Mock
    private InterfazCurso interfazCurso;

    @InjectMocks
    private CrearCursoUseCase crearCursoUseCase;

    private String nombre;
    private LocalDateTime fechaCierreInscripcion;
    private Nivel nivel;

    @BeforeEach
    public void setUp() {
        nombre = "Curso de Java";
        fechaCierreInscripcion = LocalDateTime.now().plusDays(7);
        nivel = Nivel.BASICO;
    }

    @Test
    void CreaCursoExitosamente() {
        // Arrange
        when(interfazCurso.existePorNombre(nombre)).thenReturn(false);
        when(interfazCurso.buscarPorNombre(nombre)).thenReturn(java.util.Optional.empty());
        when(interfazCurso.guardar(any(Curso.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Curso cursoCreado = crearCursoUseCase.ejecutar(nombre, fechaCierreInscripcion, nivel);

        // Assert
        assertNotNull(cursoCreado);
        assertEquals(nombre, cursoCreado.getNombre());
        assertEquals(fechaCierreInscripcion, cursoCreado.getFechaCierreInscripcion());
        assertEquals(nivel, cursoCreado.getNivel());
        verify(interfazCurso).guardar(cursoCreado);
    }

    @Test
    void CursoDuplicadoException() {
        // Arrange
        when(interfazCurso.existePorNombre(nombre)).thenReturn(true);

        // Act & Assert
        CursoDuplicadoException exception = assertThrows(CursoDuplicadoException.class, () -> {
            crearCursoUseCase.ejecutar(nombre, fechaCierreInscripcion, nivel);
        });

        assertEquals("El curso ya existe", exception.getMessage());
    }

    @Test
    void NombreNulo() {
        // Arrange
        when(interfazCurso.existePorNombre(null)).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            crearCursoUseCase.ejecutar(null, fechaCierreInscripcion, nivel);
        });
    }

    @Test
    void NombreVacio() {
        // Arrange
        when(interfazCurso.existePorNombre("")).thenReturn(false);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            crearCursoUseCase.ejecutar("", fechaCierreInscripcion, nivel);
        });
    }

    @Test
    void FechaCierreInscripcionNula() {
        // Arrange
        when(interfazCurso.existePorNombre(nombre)).thenReturn(false);
        when(interfazCurso.buscarPorNombre(nombre)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            crearCursoUseCase.ejecutar(nombre, null, nivel);
        });
    }

    @Test
    void NivelNulo() {
        // Arrange
        when(interfazCurso.existePorNombre(nombre)).thenReturn(false);
        when(interfazCurso.buscarPorNombre(nombre)).thenReturn(java.util.Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            crearCursoUseCase.ejecutar(nombre, fechaCierreInscripcion, null);
        });
    }
}




