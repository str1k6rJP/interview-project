package interview.controller;

import interview.service.QueueService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queue")
@AllArgsConstructor
public class QueueController {

    private QueueService queueService;

    @PostMapping("/enqueue")
    public ResponseEntity<Boolean> enqueue(@RequestBody String element) {
        boolean success = queueService.enqueue(element);
        ResponseEntity<Boolean> response;
        if (success) {
            response = ResponseEntity.ok(success);
        } else {
            response = ResponseEntity.internalServerError().body(success);
        }
        return response;
    }

    @GetMapping("/dequeue")
    public ResponseEntity dequeue() {
        String element = queueService.dequeue();
        ResponseEntity response;
        if (element == null) {
            response = ResponseEntity.noContent().build();
        } else {
            response = ResponseEntity.ok(element);
        }
        return response;
    }

    @GetMapping("/snapshot")
    public ResponseEntity<List<String>> getSnapshot() {
        List<String> snapshot = queueService.getSnapshot();
        return ResponseEntity.ok(snapshot);
    }
}
