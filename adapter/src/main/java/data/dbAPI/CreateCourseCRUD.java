package data.dbAPI;
import data.model.CourseData;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateCourseCRUD extends CrudRepository<CourseData, UUID> {
    boolean existsByName(String name);
    boolean saveCourse(CourseData newCourse);
}

