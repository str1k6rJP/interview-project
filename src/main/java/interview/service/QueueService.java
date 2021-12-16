package interview.service;

import java.util.List;

public interface QueueService {

    /**
     * Puts an item to the back of queue.
     * If element is null, returns false.
     *
     * @param element
     * @return true if element put to queue; false otherwise
     */
    boolean enqueue(String element);

    /**
     * Returns the item from the front of queue. Removes it from queue.
     *
     * @return front item from the queue
     */
    String dequeue();

    /**
     * Returns all the items from the queue. Does not modify the queue.
     * Returns an empty list if queue is null or no values are present.
     *
     * @return all the elements from the queue
     */
    List<String> getSnapshot();
}
