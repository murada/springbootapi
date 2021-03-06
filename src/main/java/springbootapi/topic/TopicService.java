package springbootapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ma_ab on 3/6/2018.
 */

@Service
public class TopicService {


    @Autowired
    private TopicRepository topicRepository;

/*    private List<Course> topics = new ArrayList<>(Arrays.asList(
            new Course("spring","Spring FrameWork","Spring Framework description"),
            new Course("java","Java Core","Java Core description"),
            new Course("javascript","JavaScript","JavaScript description")

    ));*/

    public List<Topic> getTopics(){
        List<Topic> listOfTopics = new ArrayList<>();
         topicRepository.findAll().forEach(listOfTopics::add);
         return listOfTopics;
    }

    public Topic getTopicById(String id) {
//        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic) {
//        topics.add(springbootapi.course);
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        /*Course oldTopic = topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        topics.set(topics.indexOf(oldTopic),springbootapi.course);*/

        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t->t.getId().equals(id));
        topicRepository.delete(id);
    }
}
