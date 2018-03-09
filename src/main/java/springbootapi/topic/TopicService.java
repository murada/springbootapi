package springbootapi.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ma_ab on 3/6/2018.
 */

@Service
public class TopicService {


    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring","Spring FrameWork","Spring Framework description"),
            new Topic("java","Java Core","Java Core description"),
            new Topic("javascript","JavaScript","JavaScript description")

    ));

    public List<Topic> getTopics(){
        return topics;
    }

    public Topic getTopicById(String id) {
        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        Topic oldTopic = topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        topics.set(topics.indexOf(oldTopic),topic);
    }

    public void deleteTopic(String id) {
        topics.removeIf(t->t.getId().equals(id));
    }
}
