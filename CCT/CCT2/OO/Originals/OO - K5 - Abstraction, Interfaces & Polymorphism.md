---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: "SOLID | \rAbstract classes and their purpose and use\r | Interfaces, what are they and how are they used\r | Polymorphism - what is it and how do we use it effectively | \rStatic and dynamic bindings"
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - "SOLID - Design Principles and\rDesign Patterns"
  - w3schools - Abstraction
  - w3schools - Interface
  - w3schools - Polymorphism
  - PrepBytes - Static Binding and Dynamic Binding In Java
Created:
---
- - -
# SOLID - Design Principles and Design Patterns
## Intro
Software architecture is a multitiered concept that encompasses different levels of structure and design.

> [!abstract] Hierarchy of Software Architecture
> The structure of software architecture can be broken down into three distinct levels:
> 1.  **Architecture Patterns:** The highest level, which defines the overall shape and structure of software applications.
> 2.  **Purpose-Related Architecture:** The middle level, which is specifically related to the purpose of the software application.
> 3.  **Module and Interconnection Architecture:** The lowest level, residing within the modules and their interconnections. This is the domain of design patterns, packages, components, and classes.

This chapter focuses specifically on the lowest level: the architecture of modules and their interconnections. It is important to note that the scope of this chapter is limited, as there is much more to be said about the principles and patterns exposed here beyond what is covered.

## Architecture and Dependencies
Software design often begins as a clean, elegant, and compelling vision in the minds of designers. However, as time passes, the software begins to rot. This process starts slowly with minor hacks and clumsy workarounds but eventually accumulates until the design is dominated by "festering sores." The application becomes increasingly difficult to maintain, and the effort required to make simple changes becomes unmanageable. Requests for redesign projects often fail because the old system continues to evolve, causing the new design to accumulate the same problems before it is even released.

### Symptoms of Rotting Design

There are four primary symptoms that indicate a design is rotting. While they are not orthogonal and are related to one another, they serve as clear warning signs: rigidity, fragility, immobility, and viscosity.

> [!info] Rigidity
> Rigidity is the tendency for software to be difficult to change, even in simple ways. Every change causes a cascade of subsequent changes in dependent modules. A simple two-day change can grow into a multi-week marathon of changes across the application. This unpredictability makes managers reluctant to authorize changes, leading to "official rigidity" where the design deficiency turns into adverse management policy.

> [!info] Fragility
> Fragility is the tendency of the software to break in many places every time it is changed. These breakages often occur in areas that have no conceptual relationship with the area that was changed. As fragility worsens, the probability of breakage approaches 1, making the software impossible to maintain because every fix introduces more problems than it solves.

> [!info] Immobility
> Immobility is the inability to reuse software from other projects or from parts of the same project. An engineer might discover a needed module that another engineer wrote, but the module often carries too much "baggage" in the form of dependencies. The work and risk required to separate the desirable parts from the dependencies are often too high, resulting in the software being rewritten instead of reused.

> [!info] Viscosity
> Viscosity comes in two forms: viscosity of the design and viscosity of the environment.
> - **Viscosity of Design:** When the methods that preserve the design are harder to employ than "hacks" (methods that do not preserve the design). It becomes easy to do the wrong thing and hard to do the right thing.
> - **Viscosity of Environment:** When the development environment is slow and inefficient (e.g., long compile times or slow source code control). Engineers are tempted to make changes that avoid large recompiles or check-ins, even if those changes are not optimal from a design perspective.

### Changing Requirements

The immediate cause of design degradation is changing requirements that the initial design did not anticipate. These changes are often made quickly by engineers unfamiliar with the original design philosophy, leading to violations of the original design. However, requirements are inherently volatile, and it is the responsibility of the software engineer to create designs that are resilient to these changes. If a design fails due to changing requirements, the design itself is at fault.

### Dependency Management

The design rots because changes introduce new, unplanned dependencies. Each of the four symptoms of rotting design is caused, directly or indirectly, by improper dependencies between modules. The dependency architecture degrades along with the maintainability of the software.

To prevent this, dependencies between modules must be managed by creating "dependency firewalls" that stop dependencies from propagating. Object Oriented Design provides principles and techniques for building these firewalls and managing module dependencies, which are the focus of the rest of this discussion.
## Principles of Object Oriented Class Design
### The Open Closed Principle (OCP)

The Open Closed Principle is considered the most important principle of object-oriented design. It states that modules should be written so that they can be extended without requiring modification. In other words, the behavior of a module should be changeable without altering its source code.

> [!info] Abstraction is Key
> The OCP is achieved through abstraction. By using techniques based on abstraction, we can create modules that accommodate new behaviors via the addition of new code, rather than the modification of existing code.

#### Dynamic Polymorphism

Consider the case where a `LogOn` function must handle different types of modems. If a `switch` or `if/else` chain is used to determine modem type (as seen in poor designs), the function must be modified every time a new modem type is added. Furthermore, every dependent module must be recompiled. This leads to a system littered with selection statements that are difficult to maintain and prone to error.

By applying the OCP using dynamic polymorphism, the `LogOn` function can depend solely on a `Modem` interface (abstract class). New modems can be added by implementing this interface, without requiring any changes to the `LogOn` function.

```cpp
// LogOn has been closed for modification
class Modem {
public:
    virtual void Dial(const string& pno) = 0;
    virtual void Send(char) = 0;
    virtual char Recv() = 0;
    virtual void Hangup() = 0;
};

void LogOn(Modem& m, string& pno, string& user, string& pw) {
    m.Dial(pno);
    // you get the idea.
}
```

![[Pasted image 20260221164009.png]]

#### Static Polymorphism

Another technique for conforming to the OCP is through the use of templates or generics. This allows the `LogOn` function to operate on any type that possesses the necessary interface (concept), again without requiring modification when new types are introduced.

```cpp
// Logon is closed for modification through static polymorphism
template <class MODEM>
void LogOn(MODEM& m, string& pno, string& user, string& pw) {
    m.Dial(pno);
    // you get the idea.
}
```

#### Architectural Goals of the OCP

The primary goal is to create modules that are extensible without being changed. With proper forethought, new features can be added by adding new code, leaving existing working code untouched. This is an ideal that is difficult to achieve fully, but even partial compliance can significantly improve an application's structure. If existing code does not have to be changed, it is less likely to break.

### The Liskov Substitution Principle (LSP)

Coined by Barbara Liskov and derived from Design by Contract, the Liskov Substitution Principle states that derived classes should be substitutable for their base classes. A user of a base class should continue to function properly if an instance of a derived class is passed to it.

![[Pasted image 20260221164108.png]]

> [!info] The Circle/Ellipse Dilemma
> A common violation of LSP is the relationship between a `Circle` and an `Ellipse`. Mathematically, a circle is a type of ellipse (coincident foci). However, implementing this using inheritance creates problems.
> - An `Ellipse` has two foci and a major axis.
> - A `Circle` only needs a center and a radius.
> If `Circle` inherits from `Ellipse`, it inherits unnecessary data. More critically, `Circle` must override methods like `SetFoci` to ensure the foci remain coincident (essentially ignoring the second focus).

![[Pasted image 20260221164135.png]]
![[Pasted image 20260221164146.png]]

#### Clients and Design by Contract

The violation becomes apparent when client code interacts with these classes. Clients of an `Ellipse` expect a specific contract: if they set the foci to specific points, they expect to retrieve those exact points later. A `Circle` violates this implied contract because it ignores one of the set points to maintain its circle properties.

> [!summary] LSP in Terms of Contracts
> To be substitutable, the derived class must honor the contract of the base class. This means:
> 1. **Preconditions:** The derived class's preconditions must be no stronger than the base class's.
> 2. **Postconditions:** The derived class's postconditions must be no weaker than the base class's.
>
> In short, derived methods should expect no more and provide no less.

#### Repercussions of LSP Violation

LSP violations are often latent, discovered only when a client uses the base class interface in a way the derived class cannot support. The typical fix is to introduce type-checking logic (e.g., `if/else` chains checking `typeid`) in the client to handle the specific derived type differently. This "ugly fix" is actually a violation of the Open Closed Principle, as the client must now be modified every time a new derivative is added.

### The Dependency Inversion Principle (DIP)

If the OCP is the goal of object-oriented architecture, the Dependency Inversion Principle is the primary mechanism to achieve it. DIP dictates that we should depend upon interfaces or abstract classes, rather than upon concrete classes.

In procedural design, high-level modules depend on lower-level modules. In an object-oriented architecture following DIP, dependencies point toward abstractions. High-level policy modules should not depend on low-level implementation details; rather, both should depend on abstractions.

![[Pasted image 20260221164319.png]]
![[Pasted image 20260221164324.png]]

> [!tip] Depending upon Abstractions
> Every dependency in the design should target an interface or abstract class. No dependency should target a concrete class, if possible. Concrete implementations change frequently (volatility), whereas abstractions are stable "hinge points" where the design can extend without modification.

#### Mitigating Forces and Object Creation

The DIP assumes concrete classes are volatile. While often true, there are exceptions (e.g., standard libraries like `string.h`). Depending on stable, concrete modules is acceptable, though caution is warranted if requirements might change later (e.g., switching to Unicode).

A significant challenge for DIP is object creation, as one cannot create an instance of an abstract class. Depending on a concrete class to create an object violates DIP. This is solved using design patterns like the **Abstract Factory**, which encapsulates the creation of objects.

### The Interface Segregation Principle (ISP)

The Interface Segregation Principle supports component technologies by stating that clients should not be forced to depend on interfaces they do not use. Instead of a single large interface, specific interfaces should be created for each type of client.

![[Pasted image 20260221164417.png]]

If a class has many clients sharing one interface, a change required by one client can force the recompilation and redeployment of all other clients, even if they don't use the changed method. A better technique is to segregate the interface. Methods needed by specific client types are grouped into dedicated interfaces. The service class then implements these multiple interfaces.

![[Pasted image 20260221164453.png]]

#### Changing Interfaces

To minimize the impact of changing interfaces, new interfaces should be added to objects rather than modifying existing ones. Clients that need the new functionality can query the object for the new interface (e.g., using `dynamic_cast`). This prevents forcing existing clients to recompile just because a new feature was added for a different client.

> [!example] Querying for a New Interface
> ```cpp
> void Client(Service* s) {
>     if (NewService* ns = dynamic_cast<NewService*>(s)) {
>         // use the new service interface
>     }
> }
> ```

Care must be taken not to overdo this principle; having hundreds of interfaces ( segregated by client and version) can become unmanageable.
## Principles of Package Architecture
## Principles of Package Architecture

While classes are necessary for organizing a design, they are often insufficient. A larger granularity of organization—packages—is required to bring order to a system. There are specific principles to guide the software architect in determining which classes belong in which packages, categorized into Package Cohesion Principles and Package Coupling Principles.

### Package Cohesion Principles

These principles assist in determining which classes belong together in a package.

> [!info] Release Reuse Equivalency Principle (REP)
> The granule of reuse is the granule of release. Effective reuse requires a release system that tracks version numbers and maintains old versions. Users will be unwilling to reuse an element if they are forced to upgrade every time the author changes it.
> 
> Therefore, classes that are reusable should be grouped together into packages, as packages are the unit of release and consequently the unit of reuse.

> [!info] Common Closure Principle (CCP)
> The goal of the CCP is to minimize the number of packages that change in any given release cycle. In large projects, the work required to rebuild, test, and deploy increases with the number of changing packages.
> 
> To achieve this, classes that are likely to change for the same reasons should be grouped into the same packages. This requires predicting the types of changes that are likely to occur, ensuring that package impact is minimized from release to release.

> [!info] Common Reuse Principle (CRP)
> A dependency upon a package implies a dependency upon everything within that package. When a package changes and its release number is bumped, all clients must verify compatibility, even if the specific classes they use did not change.
> 
> To avoid this unnecessary revalidation effort, classes that are not used together should not be grouped together. Grouping classes that are used together prevents changes to unused classes from forcing an upgrade on the client.

#### Tension between the Principles

The three principles of Package Cohesion are mutually exclusive because they benefit different groups.
*   **REP and CRP** make life easy for **reusers** (tending to make packages smaller).
*   **CCP** makes life easier for **maintainers** (tending to make packages larger).

Packages are not fixed in stone. During development, the package structure shifts and "jitters." Early in a project, the architecture might prioritize CCP to aid development and maintenance. Later, as the architecture stabilizes, it may be refactored to maximize REP and CRP for external reusers.

### Package Coupling Principles

These principles govern the relationships between packages, which form a large network in most applications.

> [!info] Acyclic Dependencies Principle (ADP)
> The dependencies between packages must form no cycles. Packages are the granule of release and focus manpower. When releasing a package, engineers must build and test it against all the packages it depends upon.
> 
> If a dependency cycle exists, a change to one package requires releasing and validating all packages in the cycle, drastically increasing the workload. To prevent this, the dependency structure must be monitored and cycles broken immediately.

#### Breaking a Cycle

Cycles can be broken using two primary techniques:
1.  **Creating a New Package:** Classes that cause the cross-dependency are moved into a new package, and both original packages depend on this new package.
2.  **Applying DIP and ISP:** The dependency is inverted by creating an interface. This interface is placed in the package that uses it, breaking the cycle by reversing the direction of the dependency.

> [!info] Stable Dependencies Principle (SDP)
> Depend in the direction of stability. Stability is not about the frequency of change, but the amount of work required to make a change.
> *   A package with many **incoming dependencies** is stable because it requires significant effort to reconcile changes with all dependents (it is "responsible").
> *   A package with many **outgoing dependencies** is unstable because it is influenced by external changes (it is "dependent").

> [!summary] Stability Metrics
> Stability can be calculated using specific metrics:
> 
> *   **Ca (Afferent Coupling):** Number of classes outside the package that depend on classes inside the package (incoming dependencies).
> *   **Ce (Efferent Coupling):** Number of classes outside the package that classes inside depend upon (outgoing dependencies).
> *   **I (Instability):** $I = \frac{Ce}{Ce + Ca}$.
>     *   Range: `[0,1]`.
>     *   `I = 0`: Completely stable (no outgoing dependencies).
>     *   `I = 1`: Completely unstable (no incoming dependencies).
> 
> The SDP dictates: "Depend upon packages whose `I` metric is lower than yours."

> [!note] Rationale for SDP
> Not all software should be stable; we desire flexible, easy-to-change (unstable) modules for evolving requirements. However, if a stable package depends on an unstable package, the unstable package loses its flexibility because it cannot be changed without affecting the stable one.

> [!info] Stable Abstractions Principle (SAP)
> Packages that are maximally stable (max `I`) should also be maximally abstract (max `A`). Highly stable packages are difficult to change, but if they are also highly abstract, they can be extended without modification (following the Open Closed Principle).
> 
> This allows an application to be composed of unstable, flexible packages at the top, and stable, extensible packages at the bottom.

> [!summary] Abstractness Metrics
> Abstractness can be measured to evaluate SAP compliance:
> 
> *   **Nc:** Number of classes in the package.
> *   **Na:** Number of abstract classes in the package.
> *   **A (Abstractness):** $A = \frac{Na}{Nc}$.
>     *   Range: `[0,1]`.
>     *   `A = 0`: Completely concrete.
>     *   `A = 1`: Completely abstract.

#### The A vs I Graph and Main Sequence

The relationship between Abstractness (A) and Instability (I) can be plotted.
*   **Ideal positions:** Completely abstract and stable (upper left), or completely concrete and unstable (lower right).
*   **Zone of Uselessness:** Upper right (High A, High I). Packages are abstract but have no dependents.
*   **Zone of Pain:** Lower left (Low A, Low I). Packages are concrete but have many dependents, making changes painful.
*   **Main Sequence:** The line connecting the ideal zones (A vs I). We want packages to sit on this line, meaning they are abstract in proportion to their stability.

> [!summary] Distance Metric
> To measure how far a package is from the Main Sequence:
> 
> *   **D (Distance):** $D = \frac{|A + I - 1|}{\sqrt{2}}$. Range: `[0, ~0.707]`.
> *   **D' (Normalized Distance):** $D' = |A + I - 1|$. Range: `[0,1]`.
> 
> `D' = 0` indicates the package is on the Main Sequence. `D' = 1` indicates it is as far away as possible. These metrics help measure the dependency structure of an application.

## Principles of Package Architecture

Classes are necessary but often insufficient for organizing a design; the larger granularity of packages is needed to bring order. The following principles guide the software architect in determining which classes belong in which packages.

### Package Cohesion Principles

These principles help determine which classes belong together in a package.

> [!info] Release Reuse Equivalency Principle (REP)
> The granule of reuse is the granule of release. A reusable element cannot be effectively reused unless it is managed by a release system that tracks version numbers and maintains older versions.
> 
> Users will refuse to reuse an element if they are forced to upgrade every time the author changes it. Therefore, since packages are the unit of release, they are also the unit of reuse. Architects should group reusable classes together into packages.

> [!info] Common Closure Principle (CCP)
> The goal is to minimize the number of packages that change in any given release cycle. In large projects, the work to rebuild, test, and deploy increases with the number of changing packages.
> 
> To achieve this, classes that are likely to change for the same reasons should be grouped into the same packages. This requires predicting the types of changes that are likely to occur. By grouping classes that change together, the package impact from release to release is minimized.

> [!info] Common Reuse Principle (CRP)
> A dependency upon a package implies a dependency upon everything within that package. When a package changes and its release number is bumped, all clients must verify compatibility, even if the specific classes they use did not change.
> 
> To avoid unnecessary revalidation effort, classes that are not used together should not be grouped together. If classes are grouped that are not used together, a change to a class a client does not care about will force that client to upgrade and revalidate.

#### Tension between the Package Cohesion Principles

The three principles are mutually exclusive because they benefit different groups.
*   **REP and CRP** make life easy for **reusers** (tending to make packages smaller).
*   **CCP** makes life easier for **maintainers** (tending to make packages larger).

Packages are not fixed in stone; they shift and "jitter" during development. Early in a project, the structure might prioritize CCP to aid development and maintenance. Later, as the architecture stabilizes, it may be refactored to maximize REP and CRP for external reusers.

### Package Coupling Principles

These principles govern the interrelationships between packages, which often form large networks in applications.

> [!info] Acyclic Dependencies Principle (ADP)
> The dependencies between packages must form no cycles. Packages are the granule of release and focus manpower. When releasing a package, engineers must build and test it against all the packages it depends upon.
> 
> If a dependency cycle exists, a change to one package requires releasing and validating all packages in the cycle, drastically increasing the workload. The dependency structure must be monitored and cycles broken immediately to prevent every module from depending on every other module.

#### Breaking a Cycle

Cycles can be broken using two primary techniques:
1.  **Creating a New Package:** Classes causing the cross-dependency are moved into a new package, and both original packages depend on this new package (e.g., creating a `MessageManager`).
2.  **Applying DIP and ISP:** The dependency is inverted by creating an interface. This interface is placed in the package that uses it, breaking the cycle by reversing the direction of the dependency.

> [!info] Stable Dependencies Principle (SDP)
> Depend in the direction of stability. Stability is not about the frequency of change, but the amount of work required to make a change.
> *   A package with many **incoming dependencies** is stable because it requires significant effort to reconcile changes with all dependents (it is "responsible").
> *   A package with many **outgoing dependencies** is unstable because it is influenced by external changes (it is "dependent").

> [!summary] Stability Metrics
> Stability can be calculated using specific metrics:
> 
> *   **Ca (Afferent Coupling):** The number of classes outside the package that depend on classes inside the package (incoming dependencies).
> *   **Ce (Efferent Coupling):** The number of classes outside the package that classes inside depend upon (outgoing dependencies).
> *   **I (Instability):** $I = \frac{Ce}{Ce + Ca}$.
>     *   Range: `[0,1]`.
>     *   `I = 0`: Completely stable (no outgoing dependencies).
>     *   `I = 1`: Completely unstable (no incoming dependencies).
> 
> The SDP dictates: "Depend upon packages whose `I` metric is lower than yours."

> [!note] Rationale for SDP
> We desire flexible, easy-to-change (unstable) modules for evolving requirements. However, if a stable package depends on an unstable package, the unstable package loses its flexibility because it cannot be changed without affecting the stable one.

> [!info] Stable Abstractions Principle (SAP)
> Packages that are maximally stable (max `I`) should also be maximally abstract (max `A`). Highly stable packages are difficult to change, but if they are also highly abstract, they can be extended without modification (following the Open Closed Principle).
> 
> This allows an application to be composed of unstable, flexible packages at the top, and stable, extensible packages at the bottom.

> [!summary] Abstractness Metrics
> Abstractness can be measured to evaluate SAP compliance:
> 
> *   **Nc:** Number of classes in the package.
> *   **Na:** Number of abstract classes in the package.
> *   **A (Abstractness):** $A = \frac{Na}{Nc}$.
>     *   Range: `[0,1]`.
>     *   `A = 0`: Completely concrete.
>     *   `A = 1`: Completely abstract.

#### The A vs I Graph and Main Sequence

The relationship between Abstractness (`A`) and Instability (`I`) can be plotted.
*   **Ideal positions:** Completely abstract and stable (upper left), or completely concrete and unstable (lower right).
*   **Zone of Uselessness:** Upper right (High `A`, High `I`). Packages are abstract but have no dependents.
*   **Zone of Pain:** Lower left (Low `A`, Low `I`). Packages are concrete but have many dependents, making changes painful.
*   **Main Sequence:** The line connecting the ideal zones (`A` vs `I`). We want packages to sit on this line, meaning they are abstract in proportion to their stability.

> [!summary] Distance Metric
> To measure how far a package is from the Main Sequence:
> 
> *   **D (Distance):** $D = \frac{|A + I - 1|}{\sqrt{2}}$. Range: `[0, ~0.707]`.
> *   **D' (Normalized Distance):** $D' = |A + I - 1|$. Range: `[0,1]`.
> 
> `D' = 0` indicates the package is on the Main Sequence. `D' = 1` indicates it is as far away as possible. These metrics help measure the dependency structure of an application.

## Patterns of Object Oriented Architecture

When creating object-oriented architectures based on the principles described previously, one often encounters repeating structures of design and architecture known as design patterns. A design pattern is essentially a well-worn and known good solution to a common problem. These are not new inventions but rather old techniques that have proven their usefulness over many years. Below are common design patterns that appear in case studies, though the topic is broad enough to warrant further reading beyond this overview.

> [!abstract] Definition - Design Pattern
> A design pattern is a well-worn and known good solution to a common problem. It represents a repeating structure of design and architecture.

### Abstract Server

When a client depends directly on a server, the Dependency Inversion Principle (DIP) is violated. This direct dependency means changes to the server will propagate to the client, and the client cannot easily use similar servers with different implementations. This can be rectified by inserting an abstract interface between the client and the server.

![[Pasted image 20260221170740.png]]

> [!tip] The "Hinge Point"
> The abstract interface acts as a "hinge point" allowing the design to flex. Different implementations of the server can be bound to the client without the client knowing or caring.

### Adapter

Sometimes inserting an abstract interface directly into a server is infeasible, such as when the server is third-party software or is so heavily depended upon that it cannot be changed easily. In these cases, an **ADAPTER** can be used to bind the abstract interface to the server.

![[Pasted image 20260221170756.png]]

The adapter is an object that implements the abstract interface and delegates to the actual server. Every method in the adapter simply translates the call (if necessary) and delegates it to the corresponding method in the server.

### Observer

There are often situations where one element of a design needs to take action when another element discovers an event, but we do not want the detector to know about the actor.

> [!example] Sensor and Meter
> Consider a meter that displays the status of a sensor. Every time the sensor changes its reading, the meter should display the new value. However, we do not want the sensor to know anything about the specific meter implementation.

The **OBSERVER** pattern addresses this. The `Sensor` derives from a `Subject` class, and the `Meter` derives from an `Observer` interface. The `Subject` contains a list of `Observers`. The `Meter` registers with the `Subject` base class of the `Sensor` to receive notifications.

![[Pasted image 20260221170815.png]]

**Dynamics:**
1.  The `Sensor` detects a change in reading.
2.  The `Sensor` calls `Notify` on its `Subject` base class.
3.  The `Subject` iterates through all registered `Observers` and calls `Update` on each.
4.  The `Meter` receives the `Update` call, reads the new value from the `Sensor`, and displays it.

![[Pasted image 20260221170826.png]]

### Bridge

A problem with implementing an abstract class with inheritance is that the derived class becomes tightly coupled to the base class. This creates issues when clients want to use functions of the derived class without dragging along the baggage of the base hierarchy.

> [!example] Music Synthesizer
> A base `MusicSynthesizer` class translates MIDI input into `EmitVoice` calls implemented by a derived class. The `EmitVoice` function might be useful on its own, but it is inextricably bound to the `MusicSynthesizer` class. Furthermore, there is no way to create different implementations of `PlayMidi` that use the same `EmitVoice` function; the hierarchy is too coupled.

![[Pasted image 20260221170845.png]]

The **BRIDGE** pattern solves this by creating a strong separation between the interface and the implementation.

![[Pasted image 20260221170856.png]]

In the solution:
*   The `MusicSynthesizer` class contains an abstract `PlayMidi` function.
*   It delegates to a `VoiceEmitter` interface.
*   The `VoiceEmitter` interface is implemented by `VoiceEmitter_I`.

This allows `EmitVoice` and `PlayMidi` to be implemented separately. `EmitVoice` can be used without the `MusicSynthesizer` baggage, and `PlayMidi` can be varied in different ways while still using the same `EmitVoice` implementation.

### Abstract Factory

The Dependency Inversion Principle (DIP) recommends that modules not depend upon concrete classes. However, to create an instance of a class, one must depend upon the concrete class. The **ABSTRACTFACTORY** pattern allows the dependency upon the concrete class to exist in one, and only one, place.

![[Pasted image 20260221170926.png]]

Using a `Modem` example:
*   Users who wish to create modems use a `ModemFactory` interface.
*   A global variable holds a pointer to this factory (`GtheFactory`).
*   Users call a `Make` function (passing a string identifying the desired type) which returns a pointer to the `Modem` interface.
*   The `ModemFactory` interface is implemented by `ModemFactory_I`.
*   `ModemFactory_I` is created in `main`, and its pointer is loaded into the global variable.

Consequently, no module in the system knows about the concrete modem classes except for `ModemFactory_I`, and no module knows about `ModemFactory_I` except for `main`.

## Conclusion

This chapter has introduced object-oriented architecture as the structure of classes and packages that maintains a software application's flexibility, robustness, reusability, and developability. The principles and patterns presented here support these architectural goals.

It is important to recognize that this has been merely an overview. There is significantly more to be said about OO architecture than can be covered in a few pages. Relying solely on this summary can be risky ("a little knowledge is a dangerous thing"). It is strongly encouraged to seek out the books and papers cited in the chapter to learn more.

# Java Abstraction
## Abstract Classes and Methods
Data abstraction is the process of hiding certain details and showing only essential information to the user. In Java, this can be achieved using either abstract classes or interfaces.

> [!info] The `abstract` Keyword
> The `abstract` keyword is a non-access modifier used for classes and methods. It indicates that the class or method is incomplete and relies on a subclass to provide full functionality.

### Abstract Classes

An abstract class is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class). It serves as a base for other classes. An abstract class can contain both abstract methods (without a body) and regular methods (with a body).

> [!warning] Instantiation Restriction
> It is not possible to create an object of an abstract class directly. Attempting to do so will generate an error.
> 
> ```java
> Animal myObj = new Animal(); // This will generate an error
> ```

### Abstract Methods

An abstract method can only be used within an abstract class. It does not have a body (the code inside the curly braces is missing). The body of the abstract method is provided by the subclass (the class that inherits from the abstract class).

> [!example] Abstract Class and Method Implementation
> The following example demonstrates an abstract class `Animal` with an abstract method `animalSound` and a regular method `sleep`. The subclass `Pig` provides the implementation for the abstract method.
>
> ```java
> // Abstract class
> abstract class Animal {
>   // Abstract method (does not have a body)
>   public abstract void animalSound();
> 
>   // Regular method
>   public void sleep() {
>     System.out.println("Zzz");
>   }
> }
> 
> // Subclass (inherit from Animal)
> class Pig extends Animal {
>   public void animalSound() {
>     // The body of animalSound() is provided here
>     System.out.println("The pig says: wee wee");
>   }
> }
> 
> class Main {
>   public static void main(String[] args) {
>     Pig myPig = new Pig(); // Create a Pig object
>     myPig.animalSound();
>     myPig.sleep();
>   }
> }
> ```

> [!tip] Why And When To Use Abstract Classes and Methods?
> *   **To achieve security:** Hide certain details and only show the important details of an object.
> *   **To enforce a contract:** Ensure that subclasses provide specific implementations for critical methods.

# Java Interface
## Interfaces
Another way to achieve abstraction in Java is by using interfaces. An interface is a completely "abstract" class that is used to group related methods with empty bodies.

> [!info] Interface Syntax
> To access the methods of an interface, it must be "implemented" by another class using the `implements` keyword (similar to inheritance, but specifically for interfaces). The class that implements the interface provides the body for the methods defined in the interface.

> [!example] Implementing an Interface
> The following example defines an `Animal` interface and a `Pig` class that implements it. The `Pig` class provides the specific implementation for the methods.
> 
> ```java
> // Interface
> interface Animal {
>   public void animalSound(); // interface method (does not have a body)
>   public void sleep(); // interface method (does not have a body)
> }
> 
> // Pig "implements" the Animal interface
> class Pig implements Animal {
>   public void animalSound() {
>     // The body of animalSound() is provided here
>     System.out.println("The pig says: wee wee");
>   }
>   public void sleep() {
>     // The body of sleep() is provided here
>     System.out.println("Zzz");
>   }
> }
> 
> class Main {
>   public static void main(String[] args) {
>     Pig myPig = new Pig();  // Create a Pig object
>     myPig.animalSound();
>     myPig.sleep();
>   }
> }
> ```

### Notes on Interfaces

There are several important rules and characteristics to remember when working with interfaces:

*   **No Object Creation:** Like abstract classes, interfaces cannot be used to create objects.
*   **Method Bodies:** Interface methods do not have a body; the body must be provided by the implementing class.
*   **Overriding:** On implementation of an interface, you must override all of its methods.
*   **Default Modifiers:** Interface methods are by default `abstract` and `public`.
*   **Attributes:** Interface attributes are by default `public`, `static`, and `final`.
*   **Constructors:** An interface cannot contain a constructor because it cannot be used to create objects.

> [!tip] Why And When To Use Interfaces?
> 
> 1.  **To achieve security:** Hide certain details and only show the important details of an object.
> 2.  **To achieve multiple inheritance:** Java does not support "multiple inheritance" for classes (a class can only inherit from one superclass). However, a class can implement multiple interfaces.

### Multiple Interfaces

To implement multiple interfaces, separate the interface names with a comma.

> [!example] Implementing Multiple Interfaces
> This example shows a class implementing two different interfaces simultaneously.
> 
> ```java
> interface FirstInterface {
>   public void myMethod(); // interface method
> }
> 
> interface SecondInterface {
>   public void myOtherMethod(); // interface method
> }
> 
> class DemoClass implements FirstInterface, SecondInterface {
>   public void myMethod() {
>     System.out.println("Some text..");
>   }
>   public void myOtherMethod() {
>     System.out.println("Some other text...");
>   }
> }
> 
> class Main {
>   public static void main(String[] args) {
>     DemoClass myObj = new DemoClass();
>     myObj.myMethod();
>     myObj.myOtherMethod();
>   }
> }
> ```

# Java Polymorphism

## Java Polymorphism
Polymorphism means "many forms," and it occurs when we have many classes that are related to each other by inheritance. While inheritance allows us to inherit attributes and methods from another class, polymorphism uses those methods to perform different tasks. This allows us to perform a single action in different ways.

For example, consider a superclass called `Animal` that has a method called `animalSound()`. Subclasses of Animals, such as `Pigs`, `Cats`, or `Dogs`, can provide their own specific implementation of that method (the pig oinks, and the dog barks).

> [!example] Implementing Polymorphism
> The following example demonstrates how subclasses can provide their own versions of a method defined in a superclass.
>
> ```java
> class Animal {
>   public void animalSound() {
>     System.out.println("The animal makes a sound");
>   }
> }
>
> class Pig extends Animal {
>   public void animalSound() {
>     System.out.println("The pig says: wee wee");
>   }
> }
>
> class Dog extends Animal {
>   public void animalSound() {
>     System.out.println("The dog says: bow wow");
>   }
> }
>
> class Main {
>   public static void main(String[] args) {
>     Animal myAnimal = new Animal();  // Create a Animal object
>     Animal myPig = new Pig();  // Create a Pig object
>     Animal myDog = new Dog();  // Create a Dog object
> 
>     myAnimal.animalSound();
>     myPig.animalSound();
>     myDog.animalSound();
>   }
> }
> ```

> [!tip] Why And When To Use Inheritance and Polymorphism?
> *   **Code Reusability:** It allows you to reuse attributes and methods of an existing class when you create a new class.

# Static Binding and Dynamic Binding In Java
Binding in Java refers to the process of connecting a method call to its corresponding method implementation. It determines which specific code is executed when a method is invoked. This process can occur either at compile time or during runtime and is closely related to polymorphism, inheritance, and method overriding.

### Types of Binding in Java

There are two main types of binding mechanisms used to resolve method calls:

1.  **Static Binding:** Occurs at compile time.
2.  **Dynamic Binding:** Occurs at runtime.

> [!info] Static Binding (Early Binding)
> Static binding is a mechanism where the method call is resolved at the time of compilation. The method to be executed is determined based on the type of the reference variable, rather than the actual object it refers to.
> 
> This type of binding is typically used when a method is defined in a class and is not overridden in a subclass (or when dealing with static, final, or private methods).

#### Example of Static Binding

The following example demonstrates a scenario where binding concepts are applied. The text illustrates how reference types and object types interact, though it is important to note that in Java, instance methods use dynamic dispatch by default.

```java
class Shape {
  void draw() {
      System.out.println("Drawing Shape");
  }
}

class Rectangle extends Shape {
  void draw() {
      System.out.println("Drawing Rectangle");
  }
  void print() {
      System.out.println("Printing Rectangle");
  }
}

class Test {
  public static void main(String[] args) {
      Shape s1 = new Shape();
      Shape s2 = new Rectangle();
      Rectangle r = new Rectangle();
      
      s1.draw();
      s2.draw();
      r.print();
  }
}
```

**Output:**
```text
Drawing Shape
Drawing Rectangle
Printing Rectangle
```

**Explanation:**
In the example above, `Shape` is the parent class and `Rectangle` is the child class. Both have a `draw()` method. In the `main` method, objects are created with specific reference types. When `s1.draw()` is called, the type is `Shape`, so it prints "Drawing Shape". When `s2.draw()` is called, the reference type is `Shape`, but the object is `Rectangle`. The text describes that the reference variable's class determines the method invoked, though in Java implementation, this specific output behavior for instance methods is actually due to dynamic binding overriding the static reference type logic.

> [!tip] Advantages of Static Binding
> *   **Performance:** Since resolution happens at compile time, it is faster.
> *   **Error Checking:** The compiler checks for errors during compilation, making it less prone to runtime errors.

> [!warning] Disadvantages of Static Binding
> *   **Flexibility:** It is less flexible because it cannot be changed at runtime.
> *   **Behavior:** It can lead to unexpected behavior if the reference type does not match the object type.

> [!info] Dynamic Binding (Late Binding)
> Dynamic binding is also known as late binding or runtime polymorphism. In this mechanism, the method call is resolved during the program's execution (runtime). The specific method to be executed is determined based on the actual type of the object the reference variable refers to, rather than the type of the reference variable itself.
> 
> This binding is primarily used when a method is overridden in a subclass.

#### Example of Dynamic Binding

This example demonstrates dynamic binding using a polymorphic method call.

```java
class Shape {
  void draw() {
      System.out.println("Drawing Shape");
  }
}

class Rectangle extends Shape {
  void draw() {
      System.out.println("Drawing Rectangle");
  }
  void print() {
      System.out.println("Printing Rectangle");
  }
}

public class Test {
  // Polymorphic method accepting a Shape reference
  static void printDrawing(Shape s) {
      s.draw();
  }
  
  public static void main(String[] args) {
      Shape s1 = new Shape();
      Shape s2 = new Rectangle();
      Rectangle r = new Rectangle();
      
      printDrawing(s1);
      printDrawing(s2);
      r.print();
  }
}
```

**Output:**
```text
Drawing Shape
Drawing Rectangle
Printing Rectangle
```

**Explanation:**
A static method `printDrawing` accepts an argument of type `Shape`. Inside this method, `s.draw()` is called. When `printDrawing` is passed `s1` (a `Shape` object), it prints "Drawing Shape". When passed `s2` (a `Rectangle` object assigned to a `Shape` reference), it prints "Drawing Rectangle". This occurs because dynamic binding resolves the method call based on the actual object type (`Rectangle`) at runtime, allowing the correct overridden implementation to execute.

> [!tip] Advantages of Dynamic Binding
> *   **Flexibility:** It allows the program to change the object at runtime.
> *   **Polymorphism:** It enables polymorphism, meaning the same method can behave differently depending on the object type.

> [!warning] Disadvantages of Dynamic Binding
> *   **Performance:** It is slower than static binding because resolution happens at runtime.
> *   **Error Prone:** Since the compiler does not check for errors related to specific runtime implementations, it can be more error-prone.

### Difference between Static Binding and Dynamic Binding

The following table summarizes the key differences between the two binding mechanisms:

| Parameter | Static Binding | Dynamic Binding |
| :--- | :--- | :--- |
| **Time of Binding** | Occurs at compile time. | Occurs at runtime. |
| **Method Resolution** | Method executed is based on the type of reference variable. | Method executed is based on the actual type of object the reference points to. |
| **Usage** | Used for method overloading. | Used for method overriding. |
| **Flexibility** | Less flexible. | More flexible. |
| **Performance** | Faster. | Slower. |

### Frequently Asked Questions

**Is polymorphism an example of static binding or dynamic binding?**
Polymorphism is an example of dynamic binding because the method implementation is determined at runtime based on the actual object type.

**What is a virtual method in Java?**
A virtual method is a method that is resolved at runtime based on the actual object type (essentially any non-static instance method in Java).

**How does Static Binding contribute to performance optimization?**
Static binding allows the compiler to optimize method calls during compilation. Since the target method is known early, the compiler can perform optimizations that lead to faster execution, at the cost of flexibility.

**What advantages does Dynamic Binding offer in Java?**
Dynamic binding enhances code flexibility and supports polymorphism. It allows systems to be more adaptable and extensible by determining method implementations dynamically, which is crucial when the exact method to be called is only known during execution.

**How can a developer achieve Dynamic Binding in Java?**
Dynamic binding is achieved through method overriding. When a subclass provides a specific implementation for a method already defined in its superclass, dynamic binding ensures that the version of the method corresponding to the actual object type is called.