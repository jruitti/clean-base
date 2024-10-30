package service.boostrap;

import curso.output.RegistrarCourseOutPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UCConfig {
    @Bean
    public RegistrarCourseOutPut registrarCourseOutPut(RegistrarCourseOutPut registrarCourseOutPut) {
        return registrarCourseOutPut;
    }
}
