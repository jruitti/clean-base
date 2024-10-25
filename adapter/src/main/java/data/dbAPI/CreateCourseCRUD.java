package data.dbAPI;
import data.model.CourseData;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CreateCourseCRUD extends CRUDRepository<CourseData, UUID>{
    boolean existByName(String name);
}
