# spring-webflux-getting-started-code
My learning note when take the [Spring WebFlux: Getting Started](https://app.pluralsight.com/courses/f805fceb-814d-4316-9e13-4803f0af9d78/table-of-contents) course by [Esteban Herrera](https://github.com/eh3rrera)

### What is reactive means?

Two terms:  
1. Reactive system (architecture and design)  
2. Reactive programming (declarative event-based)

#### Reactive system

Reactive system is a set of architectural design principles for building modern systems that are well prepared to meet the increasing demands that applications face today.  
The foundation for a reactive system is message-passing.  
![reactive manifesto](https://github.com/bluething/spring-webflux-getting-started-code/blob/main/images/reactive-traits-id.svg?raw=true)

A reactive system has to be responsive, which means it has to respond quickly to all users under all conditions.  
Responsiveness is achieved through resilience (responsiveness under failure).  
The responsiveness is also achieved because the system is elastic (responsiveness under load).  
As the foundation of all these traits, we have a message driven architecture, reactive systems are driven by messages to ensure that the components of the system can be scaled independently and loosely coupled. Sometimes messages are also called events but messages and events are not the same things.

#### Reactive programming

Reactive programming, not to be confused with functional reactive programming, is a subset of asynchronous programming and a paradigm where the availability of new information drives the logic forward rather than having control flow driven by a thread-of-execution.  
It supports _decomposing_ the problem into multiple discrete steps where each can be executed in an _asynchronous_ and _non-blocking_ fashion, and then be composed to produce a workflow—possibly unbounded in its inputs or outputs.  
Reactive programming is event driven and focuses on the flow of the data.

The application program interface (API) for reactive programming libraries are generally either
1. Callback.
2. Declarative, through functional composition.

Using a reactive library or a reactive program in a style doesn't make the whole application reactive under this perspective, what makes an application or system reactive are the traits defined in the reactive manifesto.

#### Event-driven vs. message-driven

Messages have a clear (single) destination, while events are facts for others to observe.  
Messages are needed to communicate across the network and form the basis for communication in distributed systems, while events on the other hand are emitted locally.  
It is common to use messaging under the hood to bridge an event-driven system across the network by sending events inside messages.

In a message-driven system addressable recipients await the arrival of messages and react to them, otherwise lying dormant.  
In an event-driven system notification listeners are attached to the sources of events such that they are invoked when the event is emitted.

In a reactive system, especially one which uses reactive programming, both events and messages will be present—as one is a great tool for communication (messages), and another is a great way of representing facts (events).

### References

[Reactive programming vs. Reactive systems](https://www.oreilly.com/radar/reactive-programming-vs-reactive-systems/)