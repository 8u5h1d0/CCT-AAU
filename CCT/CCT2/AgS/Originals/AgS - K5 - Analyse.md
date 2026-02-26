---
tags:
  - "#AgS"
  - "#CCT2"
  - UML
Topic: Use Cases | Context Diagrammer | UML | Analyse fasen
Semester: CCT2
Course: Agil systemudvikling
Litterature:
  - SSU kompendie
Created: 26-02-2026
---
- - -
# Table of Contents

1. [[#Analysis and system definition|Analysis and system definition]]
		1. [[#Use Case Example: Changing Credit Card Information|Use Case Example: Changing Credit Card Information]]
		2. [[#Issues Illustrated by the Example|Issues Illustrated by the Example]]
	1. [[#Analysis and system definition#User stories|User stories]]
	2. [[#Analysis and system definition#Use case diagrams|Use case diagrams]]
		1. [[#Use case diagrams#Key Elements|Key Elements]]
		2. [[#Use case diagrams#Advanced Relations|Advanced Relations]]
		3. [[#Use case diagrams#Component Overview|Component Overview]]
		4. [[#Use case diagrams#Defining the System boundary and use cases|Defining the System boundary and use cases]]
	3. [[#Analysis and system definition#Making the use cases explicit|Making the use cases explicit]]
		1. [[#Making the use cases explicit#Identifying Missing Use Cases|Identifying Missing Use Cases]]
		2. [[#Making the use cases explicit#Handling Deviations and Exceptions|Handling Deviations and Exceptions]]
		3. [[#Making the use cases explicit#Completion Criteria|Completion Criteria]]
	4. [[#Analysis and system definition#Elements in use case descriptions|Elements in use case descriptions]]
		1. [[#Elements in use case descriptions#Use case Name|Use case Name]]
		2. [[#Elements in use case descriptions#Description|Description]]
		3. [[#Elements in use case descriptions#Actors|Actors]]
		4. [[#Elements in use case descriptions#Assumptions|Assumptions]]
		5. [[#Elements in use case descriptions#Steps|Steps]]
		6. [[#Elements in use case descriptions#Variations|Variations]]
		7. [[#Elements in use case descriptions#Non-functional requirements|Non-functional requirements]]
		8. [[#Elements in use case descriptions#Issues|Issues]]
	5. [[#Analysis and system definition#Examples of use cases|Examples of use cases]]
		1. [[#Examples of use cases#Example one - interdependent actions|Example one - interdependent actions]]
		2. [[#Examples of use cases#Example two - generic use case names|Example two - generic use case names]]
		3. [[#Examples of use cases#Example three - components as use case names|Example three - components as use case names]]
		4. [[#Examples of use cases#Example four - flow chart like use case diagram|Example four - flow chart like use case diagram]]
	6. [[#Analysis and system definition#Link between use cases and development process|Link between use cases and development process]]
		1. [[#Link between use cases and development process#Breaking Down Use Cases|Breaking Down Use Cases]]
		2. [[#Link between use cases and development process#Traceability Matrix|Traceability Matrix]]

# Analysis and system definition

The analysis phase of a project focuses on defining the system requirements and ensuring a unified vision among all stakeholders.

A critical outcome of this phase is establishing a **common understanding** of the end objective regarding the product or system.
- **External Users:** Must have a clear understanding of how to interact with the system in all situations.
- **Developers:** Must have a precise understanding of the scope—specifically what needs to be done and what does not.

> [!tip] Scope Clarity
> Defining what *not* to do is essential. Time is costly, and development effort is easily wasted on unnecessary features if the boundaries are not clearly defined.

The primary methodology for analyzing the system and its requirements is [[Use Case Analysis]]. This approach integrates requirements analysis into the broader context of system design.

### Use Case Example: Changing Credit Card Information

The following example illustrates a use case derived from instructions for a travel card system (Rejsekortet). It details the steps a customer must take to change the credit card linked to an automatic refill agreement.

> [!example] Procedure: Updating Auto-Refill Credit Card
> 1. Log in to the website using a user name and password.
> 2. Select "Tank-op-aftale" (Refill agreement) and choose to stop this option.
> 3. Wait at least 24 hours (but no more than 7 days). Go to a station to perform a check-in followed immediately by a check-out. This action registers the termination of the "Tank-op-aftale."
> 4. Wait at least 24 hours.
> 5. Return to the website and create a new "Tank-op-aftale" with the new credit card information.
> 6. Wait at least 24 hours (but no more than 7 days). Go to a station to perform a check-in followed immediately by a check-out. This action registers the activation of the new "Tank-op-aftale."

### Issues Illustrated by the Example

The example serves as a cautionary tale, highlighting three major issues regarding system analysis and design.

**1. Definition of a Use Case**
> [!info] Use Case
> A **use case** is a series of steps that one or more actors must perform to interact with the system.

**2. Implementation Before Analysis**
The procedure demonstrates the consequences of implementing a system before thoroughly analyzing how actors will use it. In this scenario, the system imposes strict conditions on the user (e.g., waiting periods, physical station visits).

Ideally, the system should adapt to the user's needs. This awkward procedure suggests that developers may have realized the need to change credit card information only *after* the system was built, forcing a complex workaround rather than a redesign.

**3. Lack of Actor Iteration**
> [!warning] Consequence of Skipping Review
> If this use case had been presented to the public as a proposal before implementation, it likely would have been rejected as unacceptable. It clearly demonstrates the risk of failing to iterate use cases with the actual actors who must interact with the system.

## User stories

Understanding requirements fundamentally relies on understanding the value a system creates for the user or customer within their specific context and role.

This value can be formulated using a generalized sentence structure.

![[Pasted image 20260226140507.png]]

> [!info] User Story Template
> The standard format for a user story is:
> **"As a `<role>` I want to `<feature>` so that `<benefit>`."**
> - **`<role>`**: The person or entity interacting with the system.
> - **`<feature>`**: The action or capability desired.
> - **`<benefit>`**: The value or outcome achieved.

> [!example] User Story Examples
> - **Privacy:** As a *Facebook user* I want to *protect my data* so that I can *preserve my privacy*.
> - **Inventory:** As a *janitor* I want to *be able to see my inventory list online* so that I can *always locate my stuff*.

This simple structure clarifies the specific value the system provides to a specific customer type.

> [!warning] Importance of Shared Values
> While defining values may seem trivial, disagreeing on the values created by a system leads to significant project risks. If the value proposition is not clearly set, subsequent analysis will likely diverge, resulting in conflicting requirements and integration problems later in the development process.

## Use case diagrams

The primary purpose of use case diagrams is to create a simple and efficient overview of the system. The goal is to minimize the risk of misunderstanding by leaving as little room for interpretation as possible. These diagrams serve as a communication tool between all involved actors.

A use case diagram portrays:
- Which actors interact with the system.
- What the system can and cannot do.
- The overall interfaces that exist.

### Key Elements

There are four fundamental elements in a use case diagram:

1.  **Use Case:** Represented as a bubble, it indicates that the system is able to perform a specific action. Quantity does not equal quality; the focus should be on relevant actions.
2.  **System Boundary:** A square that encapsulates the Use Case bubbles. It explicitly defines the scope of the system—what is inside the box is what the system *can* do; what is outside is what it *cannot* do.
3.  **Actors:** Entities external to the system boundary that interact with it. Actors can be individuals, groups, devices, or institutions. They are defined by the **role** they play relative to the system, not by their specific identity.
4.  **Associations:** Lines that link Actors to Use Cases. The point where these lines cross the System Boundary represents the system's interface to the external world.

### Advanced Relations

Three additional elements allow for more detailed or abstract relationships between actors and use cases:

- **Generalization:** A relationship between a generalized use case and a specialized version of it.
- **Extension:** A relationship where one use case extends the behavior of a base use case (labeled `<<extend>>`).
- **Inclusion:** A relationship where one use case includes the behavior of another (labeled `<<include>>`).

### Component Overview

| Component | Description | Representation |
| :--- | :--- | :--- |
| **Use case** | A sequence of actions in which a set of actors interacts with the system and vice versa | Use case |
| **Actor** | A role that an entity takes in relation to the system itself | Actor |
| **System boundary** | Representation of the boundary between a system and its outside world | |
| **Association** | An interaction between an actor and the system | |
| **Generalization** | Relation between a generalized use case and a specialized use case | |
| **Extension** | Relation between a base use case and an extension to a use case | `<<extend>>` |
| **Inclusion** | Relation between a use case and one included in the other | `<<include>>` |

![[Pasted image 20260226170232.png]]

### Defining the System boundary and use cases

The first step in the design process is to identify the specific problem to be addressed and define the system's boundaries.

Consider the goal of designing a custom car because existing options lack desired features. The process begins by specifying the system boundaries:
1.  Draw a square to represent the system.
2.  Give the system a name (e.g., "my ultimate car").

Once the boundary is established, the next step is to determine the system's capabilities. A guiding question is: *"What can I do with this system?"*

- **Adding Use Cases:** The answers are written inside the system boundary as "bubbles."
    - *Example:* If the system needs to move, add a bubble for "Accelerate car." If it needs to stop, add "Brake car."
- **Identifying Actors:** After populating the system with use cases, the next step is to identify who or what will interact with it.

> [!example] Scenario: Designing a Car Computer
> Imagine you are tasked with designing an on-board computer for a car to manage the engine and critical mechanical parts.
> 
> 1.  **Define the Boundary:** Draw an empty box. This represents a system that currently does nothing. Name it "Car computer."
> 2.  **Add Functionalities:** Insert use cases for essential actions: "Start engine," "Stop engine," "Brake car," "Speed car," and "Change gear."
> 3.  **Identify Actors:** Determine who interacts with the system.
>     - **Avoid generic terms:** Do not use "user," as this could refer to a driver, a passenger using the radio, or a mechanic.
>     - **Use specific roles:** Define actors by their specific interaction, such as "Driver," "RadioListener," or "Mechanics."
> 4.  **Identify External Interfaces:** The computer does not work in isolation. Add external actors for the hardware it must control: "Engine," "Brakes," and "Transmission box."
> 5.  **Scope Verification:** If asked if the computer controls the radio, the diagram provides an immediate answer: No, that functionality is not inside the system boundary.

![[Pasted image 20260226171353.png]]

The resulting diagram serves to make the functionality of the computer explicit while clarifying the external interfaces.

The key purposes of these diagrams can be summarized as:
- Defining **system boundaries**.
- Visualizing **overall system functionality**.
- Identifying **external interfaces**.
- Providing **clarification** of scope.

> [!warning] Limitations of Diagrams
> Although useful for clarification, use case diagrams are not perfect. It is still possible to make bad assumptions about what is included or excluded. Care must be taken to ensure the diagram accurately reflects the necessary interactions.

## Making the use cases explicit

Once the use cases, actors, and system boundaries are established, the next step is to explicitly define the interactions. This involves writing down the precise sequence of actions between the actors and the system.

> [!example] Use Case: Starting the Engine via Fingerprint
> 1. The driver places a finger on the touch panel for fingerprint identification.
> 2. The system detects that a finger is present on the pad.
> 3. The system scans the finger.
> 4. The system checks the driver's internal authority level.
> 5. The system accepts the identification and starts the engine.
> 6. The driver removes their finger.

The primary purpose of this explicit detailing is to prevent misunderstandings, incorrect assumptions, and functional misinterpretations. It also serves as a direct method for identifying functional requirements.

For instance, the step where the system scans a finger implies a specific requirement: "Given an authorized driver, the system must be able to correctly scan and identify the driver."

### Identifying Missing Use Cases

Detailing a use case often reveals implicit requirements that highlight missing functionality.

> [!info] Implicit Requirements
> If a system must validate a driver, it implicitly requires a database of authorized users. This immediately raises the question: *How does the data get into that database?*

If a "register new authorized driver" use case is missing from the diagram, it should be added. This creates an iteration in the design process.

> [!tip] Cost of Iteration
> Iterating on the design while it is still on paper is virtually costless. Discovering missing logic after implementation has begun—such as realizing a system cannot update credit card information—leads to significant trouble and expense.

### Handling Deviations and Exceptions

Use cases must account for deviations from the standard "happy path." It is insufficient to only describe the scenario where everything works correctly; the system's behavior during failure must also be defined.

> [!warning] Exception Handling
> If a user is **not** authorized, the system must have a defined response. This could include:
> - A visual "Not allowed" notification.
> - An audible alarm.
> - Security measures such as auto-locking the door.
> These requirements may need clarification with the client to ensure they align with the broader product design.

![[Pasted image 20260226172922.png]]

### Completion Criteria

At the conclusion of a successfully executed use case, the actor(s) must have accomplished the specific objective stated in the use case name.
- **"Turn on engine":** The engine must be running.
- **"Brake car":** The speed of the car must have decreased measurably or the car must have stopped completely.

## Elements in use case descriptions

While UML does not explicitly mandate text descriptions for use cases, creating them is highly beneficial during design. A textual description ensures that all stakeholders can understand the interactions.

| Field | Description |
| :--- | :--- |
| **Use case Name** | Identifier and/or reference to other use cases. |
| **Description** | Goal/objective to be achieved by the use case. |
| **Actors** | List of actors in the use case (and short description/definition). |
| **Assumptions** | Conditions that must be true for the use case to correctly start and end. |
| **Steps** | Interactions between actors and system needed to achieve the objective. |
| **Variations** (optional) | Any variations in the use case. |
| **Non-functional** (optional) | Any non-functional requirements needed for correct execution. |
| **Issues** | Any issues related to the use case. |

### Use case Name
This field links the description to the use case diagram. The title must match the text inside the bubble on the diagram. If the use case is triggered by another, references to those related use cases should be included here.

### Description
This field defines the objective or goal. It states clearly what the expected outcome and achievements are for the actor(s) involved.

### Actors
This section lists all actors involved in the use case.
- **Consistency:** Actors must be defined clearly and referenced by consistent names throughout the documentation.
- **Roles:** It is critical that readers understand the actor's role relative to the system—what can be assumed and what cannot.
- **Types:** Actors can be divided into:
    - **Primary actors:** Those who achieve an objective from the use case.
    - **Secondary actors:** Those whom the use case utilizes during execution (e.g., an external database).

### Assumptions
This field lists conditions formulated as declarative statements that must be true (or false) for the use case to proceed.

> [!tip] Robustness and Assumptions
> The fewer assumptions a use case relies on, the more robust it is against an unknown or changing environment. These assumptions also serve as the foundation for use case extensions that handle scenarios where initial assumptions fail.

### Steps
This field details the series of interactions required to achieve the objective.

A step is generally characterized by the format: `<Sequence Number>` : `<Interaction>`.

Complex logic can be represented using programming-like constructs:
- **Conditional Logic:** `IF` / `THEN` / `ELSE` clauses can branch the flow.
- **Loops:** `REPEAT` / `UNTIL` can handle repetitive operations.
- **Parallelism:** `IN PARALLEL` and the `||` operator denote simultaneous actions.

> [!example] Logic Constructs in Use Case Steps
> **Conditional:**
> `1. IF a THEN`
> `   1.1 Interaction a`
> `   1.2 Interaction b`
> `   ELSE`
> `   1.3 Interaction c`
>
> **Repetitive:**
> `1. REPEAT`
> `   1.1 Interaction a`
> `   1.2 Interaction b`
> `   UNTIL no more`
>
> **Parallel:**
> `1. IN PARALLEL interaction a || interaction b || interaction c`
> `2. Action d`

### Variations
Variations describe deviations from the normal flow of steps. They are formatted as:
`<Step Reference>` : `<List of variations separated with an *or*>`

> [!example] Car Computer Authority Check Variation
> In a standard flow, step 4 might be: *The system checks internally the level of authority to this driver.*
>
> A variation might handle a failure:
> **Step Reference:** #1
> **Variation:** Car does not start *or* (Car computer connects to remote database, and request a check for fingerprint followed by the next step)
>
> **Sub-steps for variation:**
> `#1.1 IF success THEN proceed with turn on car, #5`
> `    ELSE Send alarm to police AND start car alarm AND lock doors`

### Non-functional requirements
These requirements describe criteria other than functionality, such as performance or reliability. They are formatted as:
`<Keyword>` : `<Requirement>`

### Issues
This field highlights special concerns related to the use case, such as implementation challenges or dependencies on other actors.

> [!warning] Issues as Potential Show Stoppers
> Issues can become "show stoppers" for implementation. For example, a variation involving a remote database check introduces issues regarding the storage of private, sensitive data, potentially requiring specialized government systems. These must be taken seriously.

## Examples of use cases

When learning to create use cases and diagrams, several common mistakes often occur. The following examples highlight misunderstandings and issues typically encountered by students.

### Example one - interdependent actions

One diagram illustrating a car computer shows three distinct use cases: "Cranking," "Start up," and "Idle." These phases describe the engine's operation: using the battery to turn the axle (cranking), warming up (start up), and waiting for acceleration (idle).

![[Pasted image 20260226174233.png]]

> [!warning] Issue: Unrealistic Time Dependencies
> The diagram implies the user must manually execute "Cranking" and "Start up" in sequence. Since cranking takes only seconds, this requires impossibly fast user interaction. Furthermore, the diagram contains ambiguous arrows and isolated use cases ("Idle") that do not reflect realistic system operation.

The most important lesson is to avoid time dependencies that cannot be realistically executed by the actor.

> [!tip] Solution: Encapsulation
> Low-level operations like cranking and start-up should be encapsulated into higher-level use cases like "Start Engine" and "Stop Engine." This leaves the complex timing details to the Car Computer system, while the Driver simply interacts with the high-level objective.

![[Pasted image 20260226174301.png]]

### Example two - generic use case names

A common problem is using vague or generic names for use cases, such as "Engine Control" or "ON mode 1." These names fail to explain what the system actually does.

![[Pasted image 20260226174325.png]]

> [!warning] Issue: Ambiguity and Visual Distraction
> Generic names like "Engine Control" have many meanings. Additionally, using complex icons (like a bus) instead of a standard stick figure confuses the definition of the actor. A stick figure has a clear definition: a role.

A better approach uses specific action verbs.

![[Pasted image 20260226174345.png]]

> [!tip] Solution: Specific Naming
> Replace "Engine Control" with **"Accelerate car."** This clearly defines the action. Specific drive modes (Gasolin, Electric, Flywheel) can be included as extensions or included cases, clarifying that they are part of the acceleration process managed by the system, not necessarily independent driver actions.

### Example three - components as use case names

Another frequent mistake is listing system components (e.g., "Engine," "Gasoline tank") as use cases inside the system boundary.

![[Pasted image 20260226174415.png]]

> [!warning] Issue: Confusing Structure with Function
> Naming use cases after components describes the physical structure rather than the system's functionality. In the context of designing a Car Computer, it makes little sense to say the computer "does" an engine or a gas tank.

The correct approach focuses on *what* the system does with those components.

![[Pasted image 20260226174444.png]]

> [!tip] Solution: Actions and External Actors
> Transform component names into actions. Instead of "Engine," use **"Accelerate car."** Instead of "Gasoline tank," use **"Show fuel status."** Furthermore, physical components should be moved outside the system boundary as **external actors** that the system interacts with.

### Example four - flow chart like use case diagram

Diagrams should not be used as flow charts. A diagram showing states like "State 1" or "State 2" with flow arrows is incorrect use of a use case diagram.

![[Pasted image 20260226174532.png]]

> [!warning] Issue: Incorrect Diagram Type
> Use case diagrams define *capabilities*, not the flow of events or system states. In a flow-chart style diagram, actors often become disconnected from the use cases, rendering the diagram useless for defining interactions.

The correction involves renaming bubbles to actions and linking the actor to the relevant capabilities.

![[Pasted image 20260226174546.png]]

> [!abstract] The Goal of Correct Diagrams
> There is no single "correct" answer for a use case diagram. The goal is to create a diagram that makes sense to all involved, particularly the customer. The primary objective is to agree on what the system shall be able to do to avoid building a product the customer does not need.

## Link between use cases and development process

Mapping use cases to development activities helps maintain focus, especially when time is limited. It provides a structured approach to prioritizing work effort.

### Breaking Down Use Cases

Consider the use case "Brake Car." Analysis reveals the need for specific hardware and software components:
- **Actuators:** Physical components to brake the wheels.
- **Sensors:** To feed back current velocity.
- **Lighting System:** To indicate braking.
- **Engine Controller Software:** To adjust (stop) fuel injection during braking.

![[Pasted image 20260226174613.png]]

This breakdown creates a development plan involving analysis, design, implementation, and testing for each component.

> [!info] Integration Testing with Stubs
> During the testing phase, some subsystems (like the lighting system or engine controller) may not be finalized. To test the "Brake Car" functionality, developers can use **stubs**—simulated modules that mimic the functionality of missing components. This requires interfaces to be clearly defined early in the process.

### Traceability Matrix

A structured matrix can summarize the relationship between use cases and the modules required to implement them.

| Use Case | Module 1 (Brakes) | Module 2 (Sensors) | Module 3 (Lights) | Module 4 (Engine Controller) |
| :--- | :--- | :--- | :--- | :--- |
| **Brake Car** | X | X | X | X |
| **Accelerate Car** | | X | | X |
| **Turn on Lights** | | | X | |

![[Pasted image 20260226174637.png]]

> [!tip] Project Management Benefits
> This matrix allows for:
> - **Progress Tracking:** Easily seeing which use cases are executable based on completed modules.
> - **Prioritization:** Delegating priority to specific modules based on the need for proof-of-concept use cases.
> - **Focused Work:** Structuring work effort based on functional needs rather than just what is "fun" or easy to do.