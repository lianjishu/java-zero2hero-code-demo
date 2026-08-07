package junit;

import io.github.lianjishu.unittest.taste.junit.TryoutJunit;
import org.junit.jupiter.api.Test;

public class TestTryoutJunit {
    @Test
    public void TestAdd() {
        new TryoutJunit().add(1, 1);
    }
}
