package data.repository;

import data.dbAPI.CreateCourseCRUD;
import data.model.CourseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreateCourseRepository implements CreateCourseGateWay{
    private CreateCourseCRUD createCourseCRUD;

    @Autowired
    public CreateCourseRepository(CreateCourseCRUD createCourseCRUD) {
        this.createCourseCRUD = createCourseCRUD;
    }
    @Override
    public boolean existCourse(String name) {
        return createCourseCRUD.existByName(name);
    }

    @Override
    public boolean saveCourse(CourseData newCourse) {
        try {
            createCourseCRUD.save(CourseData.fromDomain(newCourse));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
