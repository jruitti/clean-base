package curso.usecase;

import curso.exception.ExisteCursoException;

import curso.input.RegistrarCursoInput;
import curso.modelo.Curso;
import curso.output.RegistrarCursoOutput;


public class RegistrarCursoUseCase implements RegistrarCursoInput {

    RegistrarCursoOutput registrarCursoOutput;

    public RegistrarCursoUseCase(RegistrarCursoOutput registrarCursoOutput) {
        this.registrarCursoOutput = registrarCursoOutput;
    }

    @Override
    public Integer registrarCurso(Curso curso) {
        if(registrarCursoOutput.existeCurso(curso.getNombre()))
            throw new ExisteCursoException("El curso ya existe");
        return registrarCursoOutput.registrarCurso(curso);
    }

}
