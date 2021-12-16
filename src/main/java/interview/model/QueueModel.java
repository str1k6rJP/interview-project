package interview.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Queue;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueueModel {

    private String name;
    private Queue<String> queue;
}
