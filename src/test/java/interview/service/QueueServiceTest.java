package interview.service;

import interview.AbstractApplicationTest;
import interview.model.QueueModel;
import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueServiceTest extends AbstractApplicationTest {

    public static String NOT_EMPTY_ELEMENT = "1";
    public static String EMPTY_ELEMENT = "";
    private QueueService queueService;

    @Test
    public void enqueueValid() {
        assertTrue(queueService.enqueue(NOT_EMPTY_ELEMENT));
        assertTrue(queueService.enqueue(EMPTY_ELEMENT));
    }

    @Test
    public void enqueueInvalid() {
        assertFalse(queueService.enqueue(null));
    }

    @Test
    public void dequeue() {
        assertNull(queueService.dequeue());
        queueService.enqueue(NOT_EMPTY_ELEMENT);
        assertEquals(NOT_EMPTY_ELEMENT, queueService.dequeue());
        assertNull(queueService.dequeue());
    }

    @Test
    public void getSnapshot() {
        assertEquals(0, queueService.getSnapshot().size());
        queueService.enqueue(NOT_EMPTY_ELEMENT);
        assertEquals(1, queueService.getSnapshot().size());
    }

    @Before
    public void emptyQueue() {
        queueService = new SimpleQueueService(new QueueModel("test", new PriorityQueue<>()));
    }
}
