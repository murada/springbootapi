package springbootapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ma_ab on 3/6/2018.
 */

@Service
public class CourseService {


    @Autowired
    private CourseRepository courseRepository;

/*    private List<Course> topics = new ArrayList<>(Arrays.asList(
            new Course("spring","Spring FrameWork","Spring Framework description"),
            new Course("java","Java Core","Java Core description"),
            new Course("javascript","JavaScript","JavaScript description")

    ));*/

    public List<Course> getAllCourses(){
        List<Course> listOfCourses = new ArrayList<>();
        courseRepository.findAll().forEach(listOfCourses::add);
         return listOfCourses;
    }

    public Course getCourseById(String id) {
//        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return courseRepository.findOne(id);
    }

    public void addCourse(Course course) {
//        topics.add(springbootapi.course);
        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
        /*Course oldTopic = topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        topics.set(topics.indexOf(oldTopic),springbootapi.course);*/

        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        courseRepository.delete(id);
    }

    public List<Course> getAllCoursesByTopic(String id) {
        return courseRepository.findAllByTopicId(id);
    }
}
