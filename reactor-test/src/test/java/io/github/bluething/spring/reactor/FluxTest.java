package io.github.bluething.spring.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class FluxTest {
    @Test
    public void firstFlux() {
        Flux.just("A", "B", "C")
                .log()
                .subscribe();
    }
}
