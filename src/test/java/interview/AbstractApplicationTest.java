package interview;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Profile("test")
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public abstract class AbstractApplicationTest {

}
