package springbootapi.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ma_ab on 3/9/2018.
 */
public interface CourseRepository extends CrudRepository<Course,String>{


    public List<Course> findCourseByName(String name);
    public List<Course> findCourseByDescription(String description);
    public List<Course> findAllByTopicId(String topicId);
}
