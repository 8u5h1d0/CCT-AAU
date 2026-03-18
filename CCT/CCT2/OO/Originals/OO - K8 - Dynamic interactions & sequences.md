---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: UML message sequence diagrams and how to use as prevalidation of concepts | Synchronous and asynchronous interactions | Design and pitfalls using sequence diagrams for design | Implications on dynamic design on classes, objects and code
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - Creately - Sequence diagrams
  - Guru99 - Interaction-Collaboration Sequence diagrams
  - Creately  - Common mistakes in Sequence diagrams
Created: 18-03-2026
---
- - -
# Table of Contents

1. [[#Sequence Diagrams - Complete Guide|Sequence Diagrams - Complete Guide]]
	1. [[#Sequence Diagrams - Complete Guide#What is a Sequence Diagram?|What is a Sequence Diagram?]]
	2. [[#Sequence Diagrams - Complete Guide#When to Use Sequence Diagrams?|When to Use Sequence Diagrams?]]
	3. [[#Sequence Diagrams - Complete Guide#UML Sequence Diagram Symbols and Notation|UML Sequence Diagram Symbols and Notation]]
		1. [[#UML Sequence Diagram Symbols and Notation#Objects and Lifelines|Objects and Lifelines]]
		2. [[#UML Sequence Diagram Symbols and Notation#Activation Bars|Activation Bars]]
		3. [[#UML Sequence Diagram Symbols and Notation#Message Arrows|Message Arrows]]
			1. [[#Message Arrows#Synchronous Message|Synchronous Message]]
			2. [[#Message Arrows#Asynchronous Message|Asynchronous Message]]
			3. [[#Message Arrows#Return Message|Return Message]]
			4. [[#Message Arrows#Participant Creation Message|Participant Creation Message]]
			5. [[#Message Arrows#Participant Destruction Message|Participant Destruction Message]]
			6. [[#Message Arrows#Reflexive Message|Reflexive Message]]
			7. [[#Message Arrows#Comment|Comment]]
	4. [[#Sequence Diagrams - Complete Guide#How to Draw a Sequence Diagram|How to Draw a Sequence Diagram]]
		1. [[#How to Draw a Sequence Diagram#Step 1: Identify the Use Case|Step 1: Identify the Use Case]]
		2. [[#How to Draw a Sequence Diagram#Step 2: Identify the Objects and Actors|Step 2: Identify the Objects and Actors]]
		3. [[#How to Draw a Sequence Diagram#Step 3: Describe the Use Case in Detail|Step 3: Describe the Use Case in Detail]]
		4. [[#How to Draw a Sequence Diagram#Step 4: Identify Sequence of Interactions|Step 4: Identify Sequence of Interactions]]
		5. [[#How to Draw a Sequence Diagram#Step 5: Open a Sequence Diagram Template|Step 5: Open a Sequence Diagram Template]]
		6. [[#How to Draw a Sequence Diagram#Step 6: Arrange Actors and Lifelines|Step 6: Arrange Actors and Lifelines]]
		7. [[#How to Draw a Sequence Diagram#Step 7: Add Messages and Interaction Details|Step 7: Add Messages and Interaction Details]]
		8. [[#How to Draw a Sequence Diagram#Step 8: Review and Refine Diagram|Step 8: Review and Refine Diagram]]
	5. [[#Sequence Diagrams - Complete Guide#UML Sequence Diagram Best Practices|UML Sequence Diagram Best Practices]]
		1. [[#UML Sequence Diagram Best Practices#Draw smaller sequence diagrams|Draw smaller sequence diagrams]]
		2. [[#UML Sequence Diagram Best Practices#Avoid unnecessary or repetitive diagrams|Avoid unnecessary or repetitive diagrams]]
		3. [[#UML Sequence Diagram Best Practices#Use clear and consistent naming conventions|Use clear and consistent naming conventions]]
		4. [[#UML Sequence Diagram Best Practices#Maintain logical ordering and alignment|Maintain logical ordering and alignment]]
		5. [[#UML Sequence Diagram Best Practices#Limit the number of objects per diagram|Limit the number of objects per diagram]]
		6. [[#UML Sequence Diagram Best Practices#Highlight alternative or conditional flows with fragments|Highlight alternative or conditional flows with fragments]]
		7. [[#UML Sequence Diagram Best Practices#Keep diagrams synchronized with system behavior|Keep diagrams synchronized with system behavior]]
	6. [[#Sequence Diagrams - Complete Guide#Managing Complex Interactions with Sequence Fragments|Managing Complex Interactions with Sequence Fragments]]
		1. [[#Managing Complex Interactions with Sequence Fragments#Alternative Fragment|Alternative Fragment]]
		2. [[#Managing Complex Interactions with Sequence Fragments#Option Fragment|Option Fragment]]
		3. [[#Managing Complex Interactions with Sequence Fragments#Loop Fragment|Loop Fragment]]
		4. [[#Managing Complex Interactions with Sequence Fragments#Reference Fragment|Reference Fragment]]
	7. [[#Sequence Diagrams - Complete Guide#Sequence Diagram Common Mistakes|Sequence Diagram Common Mistakes]]
2. [[#Interaction, Collaboration & Sequence Diagrams|Interaction, Collaboration & Sequence Diagrams]]
	1. [[#Interaction, Collaboration & Sequence Diagrams#What is Interaction Diagram?|What is Interaction Diagram?]]
	2. [[#Interaction, Collaboration & Sequence Diagrams#Purpose of an Interaction Diagram|Purpose of an Interaction Diagram]]
	3. [[#Interaction, Collaboration & Sequence Diagrams#Important terminology|Important terminology]]
		1. [[#Important terminology#Lifeline|Lifeline]]
		2. [[#Important terminology#Messages|Messages]]
		3. [[#Important terminology#State invariants and constraints|State invariants and constraints]]
		4. [[#Important terminology#Operator|Operator]]
		5. [[#Important terminology#Iteration|Iteration]]
		6. [[#Important terminology#Branching|Branching]]
	4. [[#Interaction, Collaboration & Sequence Diagrams#Types of Interaction diagram and Notations|Types of Interaction diagram and Notations]]
	5. [[#Interaction, Collaboration & Sequence Diagrams#What is a Sequence Diagram?|What is a Sequence Diagram?]]
		1. [[#What is a Sequence Diagram?#Sequence diagram example|Sequence diagram example]]
		2. [[#What is a Sequence Diagram?#Benefits of a Sequence Diagram|Benefits of a Sequence Diagram]]
		3. [[#What is a Sequence Diagram?#Drawbacks of a sequence diagram|Drawbacks of a sequence diagram]]
	6. [[#Interaction, Collaboration & Sequence Diagrams#What is the Collaboration Diagram?|What is the Collaboration Diagram?]]
		1. [[#What is the Collaboration Diagram?#Benefits of Collaboration Diagram|Benefits of Collaboration Diagram]]
		2. [[#What is the Collaboration Diagram?#Drawbacks of a Collaboration Diagram|Drawbacks of a Collaboration Diagram]]
		3. [[#What is the Collaboration Diagram?#Collaboration diagram Example|Collaboration diagram Example]]
	7. [[#Interaction, Collaboration & Sequence Diagrams#What is Timing Diagram?|What is Timing Diagram?]]
		1. [[#What is Timing Diagram?#Timing diagram Example|Timing diagram Example]]
		2. [[#What is Timing Diagram?#Benefits of a Timing Diagram|Benefits of a Timing Diagram]]
		3. [[#What is Timing Diagram?#Drawbacks of a Timing Diagram|Drawbacks of a Timing Diagram]]
	8. [[#Interaction, Collaboration & Sequence Diagrams#How to draw a Interaction diagram?|How to draw a Interaction diagram?]]
	9. [[#Interaction, Collaboration & Sequence Diagrams#Use of an interaction diagram|Use of an interaction diagram]]
	10. [[#Interaction, Collaboration & Sequence Diagrams#Summary|Summary]]
3. [[#10 common mistakes to avoid in sequence diagrams|10 common mistakes to avoid in sequence diagrams]]
		1. [[#Summary#1. Get rid of unnecessary detail|1. Get rid of unnecessary detail]]
		2. [[#Summary#2. Messages should (more often than not) run from left to right|2. Messages should (more often than not) run from left to right]]
		3. [[#Summary#3. Sequence diagrams that are obsolete and out of date|3. Sequence diagrams that are obsolete and out of date]]
		4. [[#Summary#4. Avoid sequence diagrams if you are dealing with simple logic|4. Avoid sequence diagrams if you are dealing with simple logic]]
		5. [[#Summary#5. Provide a visual trace between the use case text and the message arrows|5. Provide a visual trace between the use case text and the message arrows]]
		6. [[#Summary#6. Keep your sequence diagrams abstract without the need for plumbing|6. Keep your sequence diagrams abstract without the need for plumbing]]
		7. [[#Summary#7.  Consider behavior allocation, seriously|7.  Consider behavior allocation, seriously]]
		8. [[#Summary#8. Include the use case text on the sequence diagram|8. Include the use case text on the sequence diagram]]
		9. [[#Summary#9. Follow the basics when it comes to allocating behavior by using message arrows|9. Follow the basics when it comes to allocating behavior by using message arrows]]
		10. [[#Summary#10. Consider the origins of the message arrows carefully|10. Consider the origins of the message arrows carefully]]

# Sequence Diagrams - Complete Guide
What is a sequence diagram? It is a UML interaction model that shows how participants exchange messages over time to complete a scenario. This guide explains sequence diagram notation and examples so teams can model system behavior, clarify integrations, and improve software design communication.
![[Pasted image 20260318121742.png]]
## What is a Sequence Diagram?
Sequence diagrams, commonly used by developers, model the interactions between objects in a single use case. They illustrate how the different parts of a system interact with each other to carry out a function, and the order in which the interactions occur when a particular use case is executed. In simpler words, a sequence diagram shows how different parts of a system work in a ‘sequence’ to get something done.

Sequence diagrams are widely used in software development to visualize system behavior and help developers design, analyze, and understand complex interactions.
## When to Use Sequence Diagrams?
- **Model a specific use case or scenario:** Use sequence diagrams to illustrate how a system behaves during a single use case, showing the step-by-step flow of messages between objects.
    
- **Design or refine system architecture:** Visualize how components such as the UI, business logic, and database interact, helping architects plan or improve system structure.
    
- **Clarify complex processes:** Break down complicated workflows or logic into clear, time-ordered interactions, making it easier to understand and communicate system behavior.
    
- **Validate logic before implementation:** Confirm that all necessary interactions and message flows are defined correctly before coding begins, reducing design errors.
    
- **Explain system behavior to stakeholders:** Use sequence diagrams to present technical interactions in a way that both developers and non-technical team members can understand.
    
- **Design or analyze integrations and APIs:** Map out how services or systems exchange requests and responses to ensure smooth communication in distributed or microservice environments.
## UML Sequence Diagram Symbols and Notation

A sequence diagram is structured in such a way that it represents a timeline that begins at the top and descends gradually to mark the sequence of interactions. Each object has a column and the messages exchanged between them are represented by arrows.
### Objects and Lifelines
![[Pasted image 20260318123540.png]]
A sequence diagram is made up of several of these lifeline notations that should be arranged horizontally across the top of the diagram. No two lifeline notations should overlap each other. They represent the different objects or parts that interact with each other in the system during the sequence. Each object has a lifeline (the dash line starting at the bottom center of the object box) that indicates its existence or life span throughout the sequence of events.

A lifeline notation with an actor element symbol is used when the particular sequence diagram is owned by a use case.
![[Pasted image 20260318123547.png]]
A lifeline with an entity element represents system data. For example, in a customer service application, the Customer entity would manage all data related to a customer.
![[Pasted image 20260318123554.png]]
A lifeline with a boundary element indicates a system boundary/ software element in a system; for example, user interface screens, database gateways or menus that users interact with, are boundaries.
![[Pasted image 20260318123613.png]]
And a lifeline with a control element indicates a controlling entity or manager. It organizes and schedules the interactions between the boundaries and entities and serves as the mediator between them.
![[Pasted image 20260318123621.png]]
### Activation Bars
The activation bar is the box placed on the lifeline.  It is used to indicate that an object is active (or instantiated) during an interaction between two objects. The length of the rectangle indicates the duration of the objects staying active.

In a sequence diagram, an interaction between two objects occurs when one object sends a message to another. The use of the activation bar on the lifelines of the Message Caller (the object that sends the message) and the Message Receiver (the object that receives the message) indicates that both are active are instantiated during the exchange of the message; the Message Caller stays active by sending the message and the Message Receiver gets activated after receiving the message
![[Pasted image 20260318123636.png]]
### Message Arrows

An arrow from the Message Caller to the Message Receiver specifies a message in a sequence diagram.   A message can flow in any direction; from left to right, right to left, or back to the Message Caller itself. While you can describe the message being sent from one object to the other on the arrow, with different arrowheads you can indicate the type of message being sent or received.

The message arrow comes with a description, which is known as a message signature, on it. The format for this message signature is below.

_attribute = message_name (arguments): return_type_  

#### Synchronous Message

As shown in the activation bars example, a synchronous message is used when the sender waits for the receiver to process the message and return before carrying on with another message.  The arrowhead used to indicate this type of message is a solid one, like the one below.
![[Pasted image 20260318123645.png]]
#### Asynchronous Message

An asynchronous message is used when the message caller does not wait for the receiver to process the message and return before sending other messages to other objects within the system. The arrowhead used to show this type of message is a line arrow as shown in the example below.
![[Pasted image 20260318123651.png]]
#### Return Message

A return message is used to indicate that the message receiver is done processing the message and is returning control over to the message caller. Return messages are optional notation pieces, for an activation bar that is triggered by a synchronous message always implies a return message.
![[Pasted image 20260318123658.png]]
Tip: You can avoid cluttering up your diagrams by minimizing the use of return messages since the return value can be specified in the initial message arrow itself.

#### Participant Creation Message

Objects do not necessarily live for the entire duration of the sequence of events. Objects or participants can be created according to the message that is being sent.

The dropped participant box notation can be used when you need to show that the particular participant did not exist until the create call was sent.  If the created participant does something immediately after its creation, you should add an activation box right below the participant box.
![[Pasted image 20260318123705.png]]
#### Participant Destruction Message

Likewise, participants when no longer needed can also be deleted from a sequence diagram. This is done by adding an ‘X’ at the end of the lifeline of the said participant.
![[Pasted image 20260318123717.png]]
#### Reflexive Message

When an object sends a message to itself, it is called a reflexive message. It is indicated with a message arrow that starts and ends at the same lifeline as shown in the example below.
![[Pasted image 20260318123726.png]]
#### Comment

UML diagrams generally permit the annotation of comments in all UML diagram types. The comment object is a rectangle with a folded-over corner as shown below. The comment can be linked to the related object with a dashed line.
![[Pasted image 20260318123733.png]]
Note: View Sequence Diagram Best Practices to learn about sequence fragments.

## How to Draw a Sequence Diagram

The message flow of the sequence diagram is based on the narrative of the particular use case. Before you start drawing the sequence diagram or decide what interactions should be included, you need to draw the use case diagram and ready a comprehensive description of what the particular use case does.

### Step 1: Identify the Use Case

Start by defining the specific use case scenario you want to model. This sets the foundation for your sequence diagram by outlining the system’s goal and key interactions.
![[Pasted image 20260318123818.png]]
From the above use case diagram example of ‘Create New Online Library Account’, we will focus on the use case named ‘Create New User Account’ to draw our sequence diagram example.

### Step 2: Identify the Objects and Actors

Before drawing the sequence diagram, it’s necessary to identify the objects or actors that would be involved in creating a new user account. These would be;

- Librarian
- Online Library Management system
- User credentials database
- Email system

### Step 3: Describe the Use Case in Detail

Once you identify the objects, it is then important to write a detailed description of what the use case does. From this description, you can easily figure out the interactions (that should go in the sequence diagram) that would occur between the objects above, once the use case is executed.

### Step 4: Identify Sequence of Interactions

Here are the steps that occur in the use case named ‘Create New Library User Account’.

- The librarian requests the system to create a new online library account.
- The librarian then selects the library user account type.
- The librarian enters the user’s details.
- The user’s details are checked using the user Credentials Database.
- The new library user account is created.
- A summary of the new account’s details are then emailed to the user.

From each of these steps you can easily specify what messages should be exchanged between the objects in the sequence diagram.

### Step 5: Open a Sequence Diagram Template
The sequence diagram below shows how the objects in the online library management system interact with each other to perform the function ‘Create New Library User Account’.
![[Pasted image 20260318123905.png]]
### Step 6: Arrange Actors and Lifelines

Start by placing all identified actors and objects across the top of your canvas in the order they participate in the interaction. Draw lifelines as dashed vertical lines extending downward from each actor or object. Add activation bars (thin rectangles) along the lifelines to indicate when an object is active or performing an operation.

### Step 7: Add Messages and Interaction Details

Once the structure is ready, begin illustrating how the objects communicate. Use arrows to represent messages or interactions:

- Solid arrows for synchronous messages (calls).
- Open arrows for asynchronous messages.
- Dotted arrows for return messages or responses.

Label each arrow clearly with the message name or method being called. Use fragments such as alt, opt, or loop if your scenario includes conditions, alternatives, or iterations.

### Step 8: Review and Refine Diagram

Finally, check for clarity, correct sequencing, and alignment with the use case. Ensure all actors and system components are properly represented, and message labels remain concise and descriptive. Invite your team to collaborate directly in Creately, add comments, and refine the diagram together for accuracy and completeness.
## UML Sequence Diagram Best Practices

### Draw smaller sequence diagrams

Instead of cluttering your sequence diagram with several objects and groups of messages that will confuse the reader, draw a few smaller sequence diagrams that aptly explain what your system does. Make sure that the diagram fits on a single page and leaves space for explanatory notes too.

### Avoid unnecessary or repetitive diagrams

Also instead of drawing dozens of sequence diagrams, find out what is common about the scenarios and focus on that. And if the code is expressive and can stand on its own, there’s no need to draw a sequence diagram in the first place.

### Use clear and consistent naming conventions

Name objects, lifelines, and messages clearly and consistently to avoid ambiguity. A good naming convention helps readers quickly understand which part of the system each element represents.

### Maintain logical ordering and alignment

Keep lifelines evenly spaced and align messages in a consistent left-to-right flow. Straight, parallel lines and uniform spacing make the diagram easier to read and analyze.

### Limit the number of objects per diagram

Avoid adding too many lifelines (objects or actors) to a single diagram. If you need to show complex scenarios, consider splitting them into multiple diagrams or grouping related interactions.

### Highlight alternative or conditional flows with fragments

Use sequence fragments (such as alt, opt, or loop) to represent alternative paths, conditional logic, and repeated actions. This keeps the diagram structured and prevents confusion.

### Keep diagrams synchronized with system behavior

Update the sequence diagram whenever the underlying logic or code changes. Outdated diagrams can cause miscommunication during reviews or development.

## Managing Complex Interactions with Sequence Fragments

A sequence fragment is represented as a box that frames a section of interactions between objects (as shown in the examples below) in a sequence diagram. It is used to show complex interactions such as alternative flows and loops in a more structured way. On the top left corner of the fragment sits an operator. This fragment operator specifies what sort of a fragment it is.

### Alternative Fragment

The alternative combination fragment is used when a choice needs to be made between two or more message sequences. It models the “if then else” logic. The alternative fragment is represented with a large rectangle or a frame; it is specified by mentioning ‘alt’ inside the frame’s name box (a.k.a. fragment operator). To show two or more alternatives, the larger rectangle is then divided into what are called ‘interaction operands’ using a dashed line, like shown in the sequence diagram example above. Each operand has a guard to test against and it is placed at the top left corner of the operand.
![[Pasted image 20260318123930.png]]
### Option Fragment

The option combination fragment is used to indicate a sequence that will only occur under a certain condition, otherwise, the sequence won’t occur. It models the “if then” statement. Similar to the alternative fragment, the option fragment is also represented with a rectangular frame where ‘opt’ is placed inside the name box. Unlike the alternative fragment, an option fragment is not divided into two or more operands. Option’s guard is placed at the top left corner.

### Loop Fragment

The loop fragment is used to represent a repetitive sequence. Place the words ‘loop’ in the name box and the guard condition near the top left corner of the frame. In addition to the Boolean test, the guard in a loop fragment can have two other special conditions tested against. These are minimum iterations (written as _minint = [the number]_) and maximum iterations (written as maxint = [the number]). If it is a minimum iterations guard, the loop must execute not less than the number mentioned, and if it is a maximum iterations guard, the loop mustn’t execute more than the number indicated.

### Reference Fragment

You can use the ref fragment to manage the size of large sequence diagrams. It allows you to reuse part of one sequence diagram in another, or in other words, you can reference part of a diagram in another diagram using the ref fragment. To specify the reference fragment, you have to mention ‘ref’ in the name box of the frame and the name of the sequence diagram that is being referred to inside the frame.
![[Pasted image 20260318123948.png]]
## Sequence Diagram Common Mistakes
When drawing sequence diagrams, designers tend to make these common mistakes By avoiding these mistakes you can ensure the quality of your diagram.

- Adding too much detail. This clutters up the diagram and makes it difficult to read.
- Obsolete and out-of-date sequence diagrams that are irrelevant when compared to the interfaces, actual architectures, etc. of the system. Don’t forget to replace them or modify them.
- Leaving no blank space between the use case text and the message arrow; this makes it difficult for anyone to read the diagram.
- Not considering the origins of message arrows carefully.

# Interaction, Collaboration & Sequence Diagrams
## What is Interaction Diagram?

**Interaction Diagram** are used in UML to establish communication between objects. It does not manipulate the data associated with the particular communication path. Interaction diagrams mostly focus on message passing and how these messages make up one functionality of a system. Interaction diagrams are designed to display how the objects will realize the particular requirements of a system. The critical component in an interaction diagram is lifeline and messages.

Various UML elements typically own interaction diagrams. The details of interaction can be shown using several notations such as sequence diagram, timing diagram, communication/collaboration diagram. Interaction diagrams capture the dynamic behavior of any system.
![[Pasted image 20260318124304.png]]

Following are the different types of interaction diagrams defined in UML:

- Sequence diagram
- Collaboration diagram
- Timing diagram

The purpose of a sequence diagram is to visualize the sequence of a message flow in the system. The Sequence Diagram in Software Engineering shows the interaction between two lifelines as a time-ordered sequence of events.

The Collaboration Diagram in UML is also called a communication diagram. The purpose of a collaboration diagram is to emphasize structural aspects of a system, i.e., how various lifelines in the system connects.

Timing diagrams focus on the instance at which a message is sent from one object to another object.

## Purpose of an Interaction Diagram

Interaction diagrams help you to visualize the interactive behavior of a system. Interaction diagrams are used to represent how one or more objects in the system connect and communicate with each other.

Interaction diagrams focus on the dynamic behavior of a system. An interaction diagram provides us the context of an interaction between one or more lifelines in the system.
In UML, the interaction diagrams are used for the following purposes:

- Interaction diagrams are used to observe the dynamic behavior of a system.
- Interaction diagram visualizes the communication and sequence of message passing in the system.
- Interaction Modelling diagram represents the structural aspects of various objects in the system.
- Interaction diagram represents the ordered sequence of interactions within a system.
- Interaction diagram provides the means of visualizing the real time data via UML.
- UML Interaction Diagrams can be used to explain the architecture of an object-oriented or a distributed system.

## Important terminology
An interaction diagram contains lifelines, messages, operators, state invariants and constraints.

### Lifeline

A lifeline represents a single participant in an interaction. It describes how an instance of a specific classifier participates in the interaction.

A lifeline represents a role that an instance of the classifier may play in the interaction. Following are various attributes of a lifeline,

1. **Name**
    1. It is used to refer the lifeline within a specific interaction.
    2. A name of a lifeline is optional.
2. **Type**
    1. It is the name of a classifier of which the lifeline represents an instance.
3. **Selector**
    1. It is a Boolean condition which is used to select a particular instance that satisfies the requirement.
    2. Selector attribute is also optional.

The notation of lifeline is explained in the notation section.

### Messages

A message is a specific type of communication between two lifelines in an interaction. A message involves following activities,

1. A call message which is used to call an operation.
2. A message to create an instance.
3. A message to destroy an instance.
4. For sending a signal.

When a lifeline receives a call message, it acts as a request to invoke an operation that has a similar signature as specified in the message. When a lifeline is executing a message, it has a focus of control. As the interaction progresses over time, the focus of control moves between various lifelines. This movement is called a flow of control.

**Following are the messages used in a System Interaction Diagram:**

|Message Name|Meaning|
|---|---|
|**Synchronous message**|The sender of a message keeps waiting for the receiver to return control from the message execution.|
|**Asynchronous message**|The sender does not wait for a return from the receiver; instead, it continues the execution of a next message.|
|**Return message**|The receiver of an earlier message returns the focus of control to the sender.|
|**Object creation**|The sender creates an instance of a classifier.|
|**Object destruction**|The sender destroys the created instance.|
|**Found message**|The sender of the message is outside the scope of interaction.|
|**Lost message**|The message never reaches the destination, and it is lost in the interaction.|

### State invariants and constraints

When an instance or a lifeline receives a message, it can cause it to change the state. A state is a condition or a situation during a lifetime of an object at which it satisfies some constraint, performs some operations, and waits for some event.

In interaction diagram, not all messages cause to change the state of an instance. Some messages do not have the values of some attributes. It has no side effects on the state of an object.

### Operator

An operator specifies an operation on how the operands are going to be executed. The operators in UML supports operations on data in the form of branching as well as an iteration. Various operators can be used to ensure the use of iteration and branching in the UML model. The opt and alt operators are used for branching operations. The loop operator is used to ensure the iteration operations in which a condition is executed repeatedly until the satisfying result is produced. Break operator is used inside the loop or iteration operations. It ensures that the loop is terminated whenever a break operator is encountered. If a break condition is not specified, then the loop executes the infinite number of times, which results in crashing the program.

Following are the operators used in an interaction diagram:

|Operator|Name|Meaning|
|---|---|---|
|**Opt**|Option|An operand is executed if the condition is true.  <br>e.g., If else|
|**Alt**|Alternative|The operand, whose condition is true, is executed.  <br>e.g., switch|
|**Loop**|Loop|It is used to loop an instruction for a specified period.|
|**Break**|Break|It breaks the loop if a condition is true or false, and the next instruction is executed.|
|**Ref**|Reference|It is used to refer to another interaction.|
|**Par**|Parallel|All operands are executed in parallel.|

### Iteration

In an interaction diagram, we can also show iteration using an iteration expression. An iteration expression consists of an iteration specifier and an optional iteration clause. There is no pre-specified syntax for UML iteration.

In iteration to show that messages are being sent in parallel, parallel iteration specifier is used. A parallel iteration specifier is denoted by *//. Iteration in UML is achieved by using the loop operator.

### Branching

In an interaction diagram, we can represent branching by adding guard conditions to the messages. Guard conditions are used to check if a message can be sent forward or not. A message is sent forward only when its guard condition is true. A message can have multiple guard conditions, or multiple messages can have the same guard condition. Branching in UML is achieved with the help of alt and opt, operators.

These are some of the **most important** terminologies used in UML interaction diagram.

## Types of Interaction diagram and Notations

Following are the different types of interaction diagrams defined in UML:

- Sequence diagram
- Collaboration diagram
- Timing diagram

The basic notation of interaction is a rectangle with a pentagon in the upper left corner of a rectangular box.

## What is a Sequence Diagram?

A **Sequence Diagram** simply depicts interaction between objects in a sequential order. The purpose of a sequence diagram in UML is to visualize the sequence of a message flow in the system. The sequence diagram shows the interaction between two lifelines as a time-ordered sequence of events.

- A sequence diagram shows an implementation of a scenario in the system. Lifelines in the system take part during the execution of a system.
- In a sequence diagram, a lifeline is represented by a vertical bar.
- A message flow between two or more objects is represented using a vertical dotted line which extends across the bottom of the page.
- In a sequence diagram, different types of messages and operators are used which are described above.
- In a sequence diagram, iteration and branching are also used.
![[Pasted image 20260318124516.png]]
The above sequence diagram contains lifeline notations and notation of various messages used in a sequence diagram such as a create, reply, asynchronous message, etc.
### Sequence diagram example

The following sequence diagram example represents McDonald’s ordering system:
![[Pasted image 20260318124529.png]]
**The ordered sequence of events in a given sequence diagram is as follows:**

1. Place an order.
2. Pay money to the cash counter.
3. Order Confirmation.
4. Order preparation.
5. Order serving.

If one changes the order of the operations, then it may result in crashing the program. It can also lead to generating incorrect or buggy results. Each sequence in the above-given sequence diagram is denoted using a different type of message. One cannot use the same type of message to denote all the interactions in the diagram because it creates complications in the system.

You must be careful while selecting the notation of a message for any particular interaction. The notation must match with the particular sequence inside the diagram.

### Benefits of a Sequence Diagram

- Sequence diagrams are used to explore any real application or a system.
- Sequence diagrams are used to represent message flow from one object to another object.
- Sequence diagrams are easier to maintain.
- Sequence diagrams are easier to generate.
- Sequence diagrams can be easily updated according to the changes within a system.
- Sequence diagram allows reverse as well as forward engineering.

### Drawbacks of a sequence diagram

- Sequence diagrams can become complex when too many lifelines are involved in the system.
- If the order of message sequence is changed, then incorrect results are produced.
- Each sequence needs to be represented using different message notation, which can be a little complex.
- The type of message decides the type of sequence inside the diagram.

## What is the Collaboration Diagram?

**Collaboration Diagram** depicts the relationships and interactions among software objects. They are used to understand the object architecture within a system rather than the flow of a message as in a sequence diagram. They are also known as “Communication Diagrams.”

As per Object-Oriented Programming (OOPs), an object entity has various attributes associated with it. Usually, there are multiple objects present inside an object-oriented system where each object can be associated with any other object inside the system. Collaboration Diagrams are used to explore the architecture of objects inside the system. The message flow between the objects can be represented using a collaboration diagram.

### Benefits of Collaboration Diagram

- It is also called as a communication diagram.
- It emphasizes the structural aspects of an interaction diagram – how lifeline connects.
- Its syntax is similar to that of sequence diagram except that lifeline don’t have tails.
- Messages passed over sequencing is indicated by numbering each message hierarchically.
- Compared to the sequence diagram communication diagram is semantically weak.
- Object diagrams are special case of communication diagram.
- It allows you to focus on the elements rather than focusing on the message flow as described in the sequence diagram.
- Sequence diagrams can be easily converted into a collaboration diagram as collaboration diagrams are not very expressive.
- While modeling collaboration diagrams w.r.t sequence diagrams, some information may be lost.
![[Pasted image 20260318124541.png]]
The above collaboration diagram notation contains lifelines along with connectors, self-loops, forward, and reverse messages used in a collaboration diagram.

### Drawbacks of a Collaboration Diagram

- Collaboration diagrams can become complex when too many objects are present within the system.
- It is hard to explore each object inside the system.
- Collaboration diagrams are time consuming.
- The object is destroyed after the termination of a program.
- The state of an object changes momentarily, which makes it difficult to keep track of every single change the occurs within an object of a system.

### Collaboration diagram Example

Following diagram represents the sequencing over student management system:
![[Pasted image 20260318124549.png]]
The above collaboration diagram represents a student information management system. The flow of communication in the above diagram is given by,

1. A student requests a login through the login system.
2. An authentication mechanism of software checks the request.
3. If a student entry exists in the database, then the access is allowed; otherwise, an error is returned.

## What is Timing Diagram?

**Timing Diagram** is a waveform or a graph that is used to describe the state of a lifeline at any instance of time. It is used to denote the transformation of an object from one form into another form. Timing diagram does not contain notations as required in the sequence and collaboration diagram. The flow between the software program at various instances of time is represented using a waveform.

- It is a proper representation of interactions that focuses upon the specific timings of messages sent between various objects.
- Timing diagrams are used to explain the detailed time processing of a particular object.
- Timing diagrams are used to explain how an object changes within its lifetime.
- Timing diagrams are mostly used with distributed and embedded systems.
- In UML, timing diagrams are read from left to right according to the name of a lifeline specified at the left edge.
- Timing diagrams are used to represent various changes that occur within a lifeline from time to time.
- Timing diagrams are used to display a graphical representation of various states of a lifeline per unit time.
- UML provides various notations to simplify the transition state between two lifelines per unit time.

### Timing diagram Example
The timing diagram given below represents a few phases of a software development life cycle.
![[Pasted image 20260318124624.png]]
In the above diagram, first, the software passes through the requirements phase then the design and later the development phase. The output of the previous phase at that given instance of time is given to the second phase as an input. Thus, the timing diagram can be used to describe SDLC (Software Development Life Cycle) in UML.

### Benefits of a Timing Diagram

- Timing diagrams are used to represent the state of an object at a particular instance of time.
- Timing diagram allows reverse as well as forward engineering.
- Timing diagram can be used to keep track of every change inside the system.

### Drawbacks of a Timing Diagram

- Timing diagrams are difficult to understand.
- Timing diagrams are difficult to maintain.

## How to draw a Interaction diagram?

Interaction diagrams are used to represent the interactive behavior of a system. Interaction diagrams focus on the dynamic behavior of a system. An interaction diagram provides us the context of an interaction between one or more lifelines in the system.

To draw an interaction diagram, you have first to determine the scenario for which you have to draw an interaction diagram. After deciding the situation, identify various lifelines that are going to be involved in the interaction. Categorize all the lifeline elements and explore them to identify possible connections and how the lifelines are related to one another. To draw an interaction diagram, the following things are required:

1. The total number of lifelines that are going to be part of an interaction
2. is a sequence of message flow within various objects of a system.
3. Various operators to ease the functionality of an interaction diagram.
4. Various types of messages to display the interaction more clearly and in a precise manner.
5. The ordered sequence of messages.
6. Organization and a structure of an object.
7. Various time constructs of an object.

## Use of an interaction diagram

Interaction diagrams consist of a sequence diagram, collaboration diagram, and timing diagrams. Following is the specific purpose of an interaction diagram:

- Sequence diagrams are used to explore any real application or a system.
- Interaction diagrams are used to explore and compare the use of sequence, collaborations, and timing diagrams.
- Interaction diagrams are used to capture the behavior of a system. It displays the dynamic structure of a system.
- Sequence diagrams are used to represent message flow from one object to another object.
- Collaboration diagrams are used to understand the object architecture of a system rather than message flow.
- Interaction diagrams are used to model a system as a time-ordered sequence of events.
- Interaction diagrams are used in reverse as well as forward engineering.
- Interaction diagrams are used to organize the structure of interactive elements.

## Summary

- The interactions are simply units of the behavior of a classifier.
- The critical elements in an interaction diagram are lifeline and messages.
- Interaction diagrams mostly focus on message passing.
- Interaction diagrams capture the dynamic behavior of any system.
- Interaction diagram contains sequence diagram, timing diagram, communication/collaboration diagram.
- The sequence UML diagram is to visualize the sequence of a message flow in the system.
- The purpose of a collaboration diagram is to emphasize structural aspects.
- Timing diagrams focus on the instance at which a message is sent from one object to another object.
# 10 common mistakes to avoid in sequence diagrams

Updated on: 7 November 2024   

When talking about UML diagrams and, in fact, sequence diagrams you will realize that attention-to-detail is mandatory. We’ve tapped the knowledge present in house to identify 10 of the most common mistakes that designers make when it comes to constructing sequence diagrams. We hope this knowledge helps you when it comes to making quality sequence diagrams. Have a run through and let us know what you think.

### 1. Get rid of unnecessary detail

A typical mistake that software diagrammers usually make is adding too much detail when creating sequence diagrams. Say your code has quite a few branches in a particular method; this does not mean that you should include each one within the same diagram using block or scenario elements. The issue is that adding too much detail ends up with too much clutter thereby making the diagrams more difficult to read and comprehend. The same could be said when it comes to sequence diagrams at the system level. Main thing is to keep all  your diagrams clutter-free, as shown below.
![[Pasted image 20260318124736.png]]
### 2. Messages should (more often than not) run from left to right

When it comes to sequence diagrams, the message flow should start from the top left corner. Since it’s a practice in western culture to read from the left to the right, all classifiers such as actors, classes, objects and use cases, should follow this route. However, there are certain exceptions when it comes to this logical flow, for example, when objects pairs invoke operations on each other.
![[Pasted image 20260318124758.png]]
### 3. Sequence diagrams that are obsolete and out of date

Outdated sequence diagrams that are not relevant when compared to the interfaces, actual architecture or behavior of the system, become a pain since they stop offering any documentation value. This is another reason why high-level sequence diagrams work much better than low-level diagrams. The former tends to remain appropriate even as the application details are changed. They may even need only a few modifications over time in order to remain current.
![[Pasted image 20260318124807.png]]
### 4. Avoid sequence diagrams if you are dealing with simple logic

One of the most common mistakes that most of us do is waste precious time doing too many sequence diagrams for every single use case, one for the basic course of action and one for each alternate course.  It is best to design a sequence diagram only when you have complex logic that you have to deal with. If the logic is simple and easy to assimilate, having a sequence diagram would not really add any value.
![[Pasted image 20260318124819.png]]
### 5. Provide a visual trace between the use case text and the message arrows

Each sentence within the use case text ideally should have some blank space around it. Each sentence should also be in visual harmony with the message that is in agreement with the particular behavior. This will enable people reading the diagram to easily see how the system will accomplish what the use case showcases.
![[Pasted image 20260318124825.png]]
### 6. Keep your sequence diagrams abstract without the need for plumbing

When it comes to robustness diagrams, there really is no need to show plumbing, since these diagrams reflect a design view that is preliminary. Having said that it is pertinent to highlight the real design in detail since sequence diagrams are the last stop before coding.
![[Pasted image 20260318124832.png]]
### 7.  Consider behavior allocation, seriously

As most diagrammers are aware, the sequence diagram is the main vehicle when it comes to making behavior allocation decisions. You use them to assign operations to your classes as you go. Behavior allocation especially when it comes to deciding what operations belong to what classes is very important in the ICONIX approach.
![[Pasted image 20260318124844.png]]
### 8. Include the use case text on the sequence diagram

Writing the text for the use case in the margin of the sequence diagram provides a trace from the design back to your requirements. In short, the diagram should match the narrative flow of the associated use case.
![[Pasted image 20260318124852.png]]
### 9. Follow the basics when it comes to allocating behavior by using message arrows

An object ideally should only possess a single personality. What this means is that a class should ideally focus on a set of behaviors that are strongly related. In other words, state objects need to be cohesive and coupled loosely. Other aspects that you need to concentrate on include things like reusability. What this means is that when you have objects and classes that are general, you could reuse then for other projects. Also remember that methods are assigned to objects, make sure you make it a habit to ask whether there is a decent fit between the method and object.
![[Pasted image 20260318124859.png]]
### 10. Consider the origins of the message arrows carefully

This is a no brainer. You do have to see which object is in control at whatever time so that it is easy to see the flow of control. While the arrows are certainly important when it comes to robustness diagrams, they are more important when it comes to sequence diagrams. Remember that the messages that are present between objects determines the operations on the associated classes.
![[Pasted image 20260318124913.png]]