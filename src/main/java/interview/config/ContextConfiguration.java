package interview.config;

import interview.model.QueueModel;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.PriorityQueue;
import java.util.Queue;

@SpringBootConfiguration
public class ContextConfiguration {

    @Bean
    QueueModel queueModel() {
        return new QueueModel("default", queue());
    }

    @Bean
    public Queue<String> queue() {
        return new PriorityQueue<>();
    }
}
