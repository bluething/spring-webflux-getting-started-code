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

    @Test
    public void monoWithDoOn() {
        Mono.just("A")
                .log()
                .doOnSubscribe(subs -> System.out.println("Subscribed: " + subs))
                .doOnRequest(request -> System.out.println("Requested: " + request))
                .doOnSuccess(success -> System.out.println("Succeed: " + success))
                .subscribe();
    }

    @Test
    public void emptyMono() {
        Mono.empty()
                .log()
                .subscribe(s -> System.out.println(s));
    }

    @Test
    public void emptyCompleteMonoConsumer() {
        Mono.empty()
                .log()
                .subscribe(System.out::println,
                        null,
                        () -> System.out.println("Done"));
    }

    @Test
    public void errorRuntimeExceptionMono() {
        Mono.error(new RuntimeException())
                .log()
                .subscribe();
    }

    @Test
    public void errorExceptionMono() {
        Mono.error(new Exception())
                .log()
                .subscribe();
    }

    @Test
    public void errorConsumerMono() {
        Mono.error(new Exception())
                .log()
                .subscribe(System.out::println, e -> System.out.println("Error " + e));
    }

    @Test
    public void errorDoOnErrorMono() {
        Mono.error(new Exception())
                .doOnError(e -> System.out.println("Error: " + e))
                .log()
                .subscribe();
    }

    @Test
    public void errorOnErrorResumeMono() {
        Mono.error(new Exception())
                .onErrorResume(e -> {
                    System.out.println("Caught: " + e);
                    return Mono.just("B");
                })
                .log()
                .subscribe();
    }

    @Test
    public void errorOnErrorReturnMono() {
        Mono.error(new Exception())
                .onErrorReturn("B")
                .log()
                .subscribe();
    }
}
