package interview.service;

import interview.model.QueueModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Slf4j
@Service
@AllArgsConstructor
public class SimpleQueueService implements QueueService {

    private QueueModel queueModel;

    @Override
    public boolean enqueue(String element) {
        if (element == null) {
            log.warn("An element is null!");
            return false;
        }
        boolean offered = queueModel.getQueue().offer(element);
        log.debug("Putting an element {} to queue {}; Put: {}", element, queueModel.getName(), offered);
        return offered;
    }

    @Override
    public String dequeue() {
        String element = queueModel.getQueue().poll();
        log.debug("Element retrieved from queue {} is {}", queueModel.getName(), element);
        return element;
    }

    @Override
    public List<String> getSnapshot() {
        Queue<String> queue = queueModel.getQueue();
        List<String> queueSnapshot = queue == null ? new ArrayList<>() : new ArrayList<>(queue);
        log.trace("For queue: {} , snapshot size(elements): {}", queueModel.getName(), queueSnapshot.size());
        return queueSnapshot;
    }
}
