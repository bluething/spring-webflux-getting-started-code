package io.github.bluething.spring.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {
    @Test
    public void firstMono() {
        Mono.just("A");
    }
    @Test
    public void monoWithConsumer() {
        Mono.just("A").log();
    }
}
