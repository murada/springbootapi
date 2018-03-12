package springbootapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootapi.topic.Topic;

import java.util.List;

/**
 * Created by ma_ab on 3/6/2018.
 */

@RestController
public class CourseController {


    @Autowired
    private CourseService topicService;


    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return topicService.getAllCoursesByTopic
                (id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourseById(@PathVariable String id ){
        return topicService.getCourseById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses/{id}")
    public void addCourse(@PathVariable String topicId,@RequestBody Course course){
        course.setTopic(new Topic(topicId,"",""));
        topicService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course , @PathVariable String id , @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        topicService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        topicService.deleteCourse(id);
    }
}
