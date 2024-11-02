package data.repository;

import data.dbAPI.CreateCourseCRUD;
import data.model.CourseData;
import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Service
public class CreateCourseRepository {
    @Autowired
    private CreateCourseCRUD createCourseCRUD;

    public List<CourseData> getAllCourses() {
        return createCourseCRUD.findAll();
    }

    public CourseData saveCourse(CourseData course) {
        return createCourseCRUD.save(course);
    }

//    @Autowired
//    public CreateCourseRepository(CreateCourseCRUD createCourseCRUD) {
//        this.createCourseCRUD = createCourseCRUD;
//    }

//    public boolean existCourse(String name) {
//        return createCourseCRUD.existsByName(name);
//    }
//
//    @Override
//    public boolean existsByName(String name) {
//        return false;
//    }
//
//    public boolean saveCourse(CourseData newCourse) {
//        try {
//            createCourseCRUD.saveCourse(CourseData.fromDomain(newCourse));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

}

