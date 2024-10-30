package service.rest;

import curso.input.RegistrarCourseInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.domain.CourseDTO;

@RestController
@RequestMapping("/course")
public class CreateCourseController {

    private final RegistrarCourseInput registrarCourseInput;

    @Autowired
    public CreateCourseController(RegistrarCourseInput registrarCourseInput) {
        this.registrarCourseInput = registrarCourseInput;
    }

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDTO) {
        try {
            boolean result = this.registrarCourseInput.createCourse(
                    CourseDTO.toDomain(courseDTO)
            );

            if (result) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

//existByName(name and Not id)