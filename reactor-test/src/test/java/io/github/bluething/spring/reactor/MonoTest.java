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
        Mono.just("A").log().subscribe(s -> System.out.println(s));
    }

    public void monoWithDoOn() {
        Mono.just("A")
                .log()
                .doOnSubscribe(subs -> System.out.println("Subscribed: " + subs))
                .doOnRequest(request -> System.out.println("Requested: " + request))
                .doOnSuccess(success -> System.out.println("Succeed: " + success))
                .subscribe();
    }
}
