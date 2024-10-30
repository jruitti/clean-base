package data.repository;

import data.dbAPI.CreateCourseCRUD;
import data.model.CourseData;
import org.hibernate.validator.constraints.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CreateCourseRepository implements CreateCourseCRUD {

    private final CreateCourseCRUD createCourseCRUD;

    @Autowired
    public CreateCourseRepository(CreateCourseCRUD createCourseCRUD) {
        this.createCourseCRUD = createCourseCRUD;
    }

    public boolean existCourse(String name) {
        return createCourseCRUD.existsByName(name);
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }

    public boolean saveCourse(CourseData newCourse) {
        try {
            createCourseCRUD.saveCourse(CourseData.fromDomain(newCourse));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public <S extends CourseData> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CourseData> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CourseData> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public Iterable<CourseData> findAll() {
        return null;
    }

    @Override
    public Iterable<CourseData> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(CourseData entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends CourseData> entities) {

    }

    @Override
    public void deleteAll() {

    }
}

