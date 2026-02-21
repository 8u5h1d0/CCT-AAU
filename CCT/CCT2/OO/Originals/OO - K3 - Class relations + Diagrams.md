---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: UML class relations; association, inheritance, aggregation etc. | Generalization of classes | Object Oriented Programming concepts
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - w3schools - Java Inheritance
  - tpointtech - Class Diagram | UML (Unified Modeling Language)
  - tpointtech - UML Object Diagram
Created: 15-02-2026
---

# Java Inheritance
## Subclass and Superclass
In Java, it is possible to inherit attributes and methods from one class to another.
- **subclass** (child) - the class that inherits from another class
- **superclass** (parent) - the class being inherited from
To inherit from a class, use the `extends` keyword.

```java
class Vehicle {
  protected String brand = "Ford";        // Vehicle attribute
  public void honk() {                    // Vehicle method
    System.out.println("Tuut, tuut!");
  }
}

class Car extends Vehicle {
  private String modelName = "Mustang";    // Car attribute
  public static void main(String[] args) {

    // Create a myCar object
    Car myCar = new Car();

    // Call the honk() method (from the Vehicle class) on the myCar object
    myCar.honk();

    // Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
    System.out.println(myCar.brand + " " + myCar.modelName);
  }
}
```

We set the **brand** attribute in **Vehicle** to a `protected` [access modifier](https://www.w3schools.com/java/java_modifiers.asp). If it was set to `private`, the Car class would not be able to access it.

We have a lot of objects, but somehow, they also relate to each other As a person I may have a bicycle I can do stuff with that bicycle The bicycle is composed by smaller parts The bicycle interacts with the road in different weather conditions. Sharp turns in icy conditions will feel quite a bit different than when done on nice warm and dry tarmac There are other bicycles of other types We need to model this in some way.

Inheritance (or generalization) is a key feature of OO ”A is a B” relationship • A Bicycle wheel is also a Wheel, with all the characteristics of a wheel • BicycleWheel is a Wheel • A CarWheel is also a Wheel, but it is NOT a BicycleWheel • A Wheel needs to capture the common attributes and methods of both types of wheels • BicycleWheel can invoke and provide methods in Wheel

Take, as an example, the case where any one person has different bikes? Do we need to repeat code to handle this? To handle all the similar things? • No, a strong part of OO is inheritance • A parent is generalizing its children, and children inherits a lot from its parents • In practice, this means write code one place, and reuse it several places • This leads to better and often less code
![[Pasted image 20260221124005.png]]
Inheritance is a strong concept that allows us to effectively reuse pieces of our code • Inheritance relies on the keyword extends
```java
public class MountainBike extends Bicycle
```
![[Pasted image 20260221124035.png]]
In Java, we can only extend from one parent • If we need more, then we need a hierarchy, e.g. Vehicle -> Bicycle
![[Pasted image 20260221124101.png]]
Inheritance is such an important aspect of OO design that it often is seen as equivalent to OO • It is also known as generalization, since the super class is preferably a generic version of a sub class • The generic version of a racer bike is a bicycle • The generic version of a bus is a vehicle • The generic version of a train is a means of transport, which is also a vehicle
![[Pasted image 20260221124129.png]]

HOW DOES IT WORK? • In Java, it is simple - just extend the new class with the parent one • Voila, I don’t need to write all the Bicycle code for the Mountainbike. It is already there. • Then all attributes and methods from parent becomes a part of the new class • With all there is some limitations, defined by scope (privates are not inherited) • There is no boundary to how many time we can extend • At point it becomes a design problem

```java
pacakge helloworld;

public class Bicycle {
	//General methods and fields go here
}
```
```java
pacakage helloworld;

Public class Mountainbike extends Bicycle {
	// New Specific methods and fields for moutainbikes, go here
}
```

![[Pasted image 20260221124335.png]]
#### Why And When To Use "Inheritance"?

- It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.

**Tip:** Also take a look at the next chapter, [Polymorphism](https://www.w3schools.com/java/java_polymorphism.asp), which uses inherited methods to perform different tasks.

ATTRIBUTE AND METHOD VISIBILITY • For single classes we may protect or not protect attributes and methods by keywords • Public • Private • But for inherited classes, we might want to use parent methods and access parent attributes, but keep the to ourselves • Protected
![[Pasted image 20260221124451.png]]

## The final Keyword

If you don't want other classes to inherit from a class, use the `final` keyword:
```java
final class Vehicle {
  ...
}

class Car extends Vehicle {
  ...
}
```
The output will be something like this:

`Main.java:9: error: cannot inherit from final Vehicle   class Main extends Vehicle {                     ^   1 error)`'


# Class Diagram | UML (Unified Modeling Language)
The class diagram depicts a static view of an application. It represents the types of objects residing in the system and the relationships between them. 

A class consists of its objects, and also it may inherit from other classes. 

A class diagram is used to visualize, describe, document various different aspects of the system, and also construct executable software code. It shows the attributes, classes, functions, and relationships to give an overview of the software system. It constitutes class names, attributes, and functions in a separate compartment that helps in software development.

## Purpose of Class Diagrams
The main purpose of class diagrams is to build a static view of an application. It is the only diagram that is widely used for construction, and it can be mapped with object-oriented languages.

1. It analyses and designs a static view of an application.
2. It describes the major responsibilities of a system.
3. It is a base for component and deployment diagrams.
4. It incorporates forward and reverse engineering.

## Benefits of Class Diagrams
1. It can represent the object model for complex systems.
2. It reduces the maintenance time by providing an overview of how an application is structured before coding.
3. It provides a general schematic of an application for better understanding.
4. It represents a detailed chart by highlighting the desired code, which is to be programmed.
5. It is helpful for the stakeholders and the developers.

## Vital components of a Class Diagram
- **Upper Section:** The upper section encompasses the name of the class. 
  A class is a representation of similar objects that shares the same relationships, attributes, operations, and semantics.
    1. Capitalize the initial letter of the class name.
    2. Place the class name in the center of the upper section.
    3. A class name must be written in bold format.
    4. The name of the abstract class should be written in italics format.
- **Middle Section:** The middle section constitutes the attributes, which describe the quality of the class.
    1. The attributes are written along with its visibility factors, which are public (+), private (-), protected (#), and package (~).
    2. The accessibility of an attribute class is illustrated by the visibility factors.
    3. A meaningful name should be assigned to the attribute, which will explain its usage inside the class.
- **Lower Section:** The lower section contain methods or operations. The methods are represented in the form of a list, where each method is written in a single line. It demonstrates how a class interacts with data.

![[Pasted image 20260215112423.png]]

## Relationships
In UML, relationships are of three types:

- **Dependency:** A dependency is a semantic relationship between two or more classes where a change in one class cause changes in another class. It forms a weaker relationship.  
    In the following example, Student_Id is dependent on the Student_Name.
![[Pasted image 20260215112627.png]]

A special type of association, where either • changes in A also impacts B • A relies on B for some functionality • If a person age (and they do), then the bicycle would at some point also need to change • Alternatively, if a person wants to Ride() their bicycle, they need to have one in the first place • Any changes in Bicycle, has immediate effect on RacingBicycle • Without doing anything due to inheritance!! • Any changes in RacingBicycle do NOT impact Bicycle • It only works one way



- **Generalization:** A generalization is a relationship between a parent class (superclass) and a child class (subclass). In this, the child class is inherited from the parent class.  
    For example, The Current Account, Saving Account, and Credit Account are the generalized form of Bank Account.
![[Pasted image 20260215112758.png]]
A relation that points out who has the blueprint and who has the code realization of the blueprints (interface*) • Methods may be the same for acquiring and disposing properties for Persons and Corporation • But the implementation may be very different • Useful if we wish to interact with objects the same way, even though implementations are very different • E.g. share Drive() interface across bicycle, car, train, etc. *) future topic

- **Association:** It describes a static or physical connection between two or more objects. It depicts how many objects are there in the relationship.  
    For example, a department is associated with the college.
![[Pasted image 20260215112818.png]]

A knows B relation • A person might have (know) a bicycle or two, but not necessarily • Person knows Bicycle • Bicycle does not know Person • Person can invoke methods in Bicycle • Cardinality tell us how objects are connected • A person has exactly one Passport • Arrows may also be used and not just lines and here we must take note of the direction to fully understand the nature of the relation
![[Pasted image 20260221124559.png]]

or more specific associations, we can: • Add (open) arrows and crosses to • make directionality explicit or binary (one-way) • Annotate so that the intent of the association is communicated • State the exact property name and visibility
![[Pasted image 20260221124620.png]]

HOW DOES AN ASSOCIATION WORK?
Association is the most generic type of composition of objects – all it requires is a class to know another class • Association < Aggregation < Composition • Association: “These two interact somehow.”

![[Pasted image 20260221124639.png]]
![[Pasted image 20260221124650.png]]




**Multiplicity:** It defines a specific range of allowable instances of attributes. In case if a range is not specified, one is considered as a default multiplicity.

For example, multiple patients are admitted to one hospital.
![[Pasted image 20260215112847.png]]

Or multiple customers to a business

**Aggregation:** An aggregation is a subset of association, which represents has a relationship. It is more specific then association. It defines a part-whole or part-of relationship. In this kind of relationship, the child class can exist independently of its parent class.

The company encompasses a number of employees, and even if one employee resigns, the company still exists.
![[Pasted image 20260215112945.png]]
A part of B relation • One of several specific forms of association • This shows that a class has objects of another class, e.g. a gear has two sprockets • Sprocket is part of Gear • In other words, a form of ownership • Useful to determine what class relates to what class • Gear can invoke actions in Sprocket • Aggregation: “The “whole” groups the parts but does not own their lifetime.”

Aggregation is different from, and a stronger form of ”association” than, association • The difference is that this type of association does not involve owning and the lifecycle of objects are not tied to each other • Garbage collection does not necessarily happen, and objects may hang around occupying memory • Examples could be: • The bicycle and its wheels can be separated • The Robator can run without the Drone • Both cases seem a bit useless – but that is why there is an aggregation in the first place • In both cases, the lack of one does not destroy or prevent the other to exist

HOW DOES AGGREGATION WORK?
Another example could be a bank that keeps track of its employees • The Bank knows (many) Employee(s) • Despite being created in another class • Employees are a part of the bank • We can have a bank with no employees • We can also have employees without a bank • Is it realistic and does it make sense – no, but it may still be feasible • If we remove employees, we can just remove them in the main code • Would be a bad coding style though, because we allow external manipulation with an internal attribute (employees) in another class (the Bank)

![[Pasted image 20260221124751.png]]


**Composition:** The composition is a subset of aggregation. It portrays the dependency between the parent and its child, which means if one part is deleted, then the other part also gets discarded. It represents a whole-part relationship.

A contact book consists of multiple contacts, and if you delete the contact book, all the contacts will be lost.
![[Pasted image 20260215113014.png]]

A special and stronger form of aggregation with added dependency • If A is destroyed, then B is also destroyed • B cannot exist without A, since B is a part of A • The life-cycle of B is controlled by A • If I destroy the Gear, then the Sprocket is also destroyed • Well, we work with models … in real life we could probably reuse the sprocket • Composition: “The parts cannot live without the “whole”.”

• Compared to the association, then the composition is a very strong association where the objects lifecycle is tied together • If we destroy the owner, we also destroy the members • Garbage collection happens and objects are cleared from memory • As examples: • A building has rooms – If we tear down a building, its rooms go with it. • A university has faculties – if AAU were to close, so would its faculties! • Semantically the difference may be subtle compared to aggregation, but technically it is more clear

With a little change we also change the relation • A Bank has employee(s) • Now an employee cannot exist without a bank • And if we destroy the bank, then we also destroy the employees • If we want to remove employees, we would need to add some methods to the Bank class to handle this operation

![[Pasted image 20260221124836.png]]
![[Pasted image 20260221124843.png]]

## Abstract Classes
In the abstract class, no objects can be a direct entity of the abstract class. The abstract class can neither be declared nor be instantiated. It is used to find the functionalities across the classes. The notation of the abstract class is similar to that of class; the only difference is that the name of the class is written in italics. Since it does not involve any implementation for a given function, it is best to use the abstract class with multiple objects.

we have an abstract class named **displacement** with a method declared inside it, and that method will be called as a **drive ()**. Now, this abstract class method can be implemented by any object, for example, car, bike, scooter, cycle, etc.
![[Pasted image 20260215113108.png]]

## How to draw a Class Diagram?
The class diagram is used most widely to construct software applications. It not only represents a static view of the system but also all the major aspects of an application. A collection of class diagrams as a whole represents a system.
1. To describe a complete aspect of the system, it is suggested to give a meaningful name to the class diagram.
2. The objects and their relationships should be acknowledged in advance.
3. The attributes and methods (responsibilities) of each class must be known.
4. A minimum number of desired properties should be specified as more number of the unwanted property will lead to a complex diagram.
5. Notes can be used as and when required by the developer to describe the aspects of a diagram.
6. The diagrams should be redrawn and reworked as many times to make it correct before producing its final version.
   

## Class Diagram Example
A class diagram describing the sales order system
![[Pasted image 20260215113142.png]]
Example: order system
![[Pasted image 20260221125036.png]]
example: GUI
![[Pasted image 20260221125107.png]]

You might already have noticed that some examples have these <> • These are known in UML as stereotypes. They are a mechanism of UML itself to “extend the vocabulary” of UML • We’re not going to dive deep into this topic, but the core point is that this is sometimes used to convey more information than vanilla UML supports. Preferably, sparingly • Some simple examples (not rules!): • An <> is not a typical “class” • Neither is a <> • We might benefit from making our <> explicit

## Usage of Class diagrams
The class diagram is used to represent a static view of the system. It plays an essential role in the establishment of the component and deployment diagrams. It helps to construct an executable code to perform forward and backward engineering for any system, or we can say it is mainly used for construction. It represents the mapping with object-oriented languages that are C++, Java, etc.

Class diagrams can be used for the following purposes:
1. To describe the static view of a system.
2. To show the collaboration among every instance in the static view.
3. To describe the functionalities performed by the system.
4. To construct the software application using object-oriented languages.

## DESIGN PROCESS – TOWARDS A CLASS DIAGRAM

First, this is a design process and most likely you need to iterate several times to get to a satisfying result • What is a good class diagram? By intuition (and non-measurable!!)
- It is neither too small nor too big 
- It is descriptive and not too complex 
- It relates to our code and is consistent 
- It relates to the real world and is consistent

Defining a hierarchy: • For each class ask • Is there a generic version of this class? Yes: then generalize it, No: do nothing. End algorithm if generalization is just an object of some sort (this is the root anyway). • Does a method require specialized or same type of implementation? If specialized, then consider an interface instead of a parent class. • Construct the tree – e.g. on a black board (faster to work this way) Some trees may stand alone, and some classes are on their own – that is just fine • For each class ask • Is there a relation to other classes? Yes, then decide which type and draw this. No, then leave alone

"on a blackboard" Must be emphasized! It is tempting to jump straight into a diagram program, but you risk spending more time “fighting the software” then sketching your diagrams. Start simple, with generic illustrations and only once this is done, then consider making it nice.
# UML Object Diagram
Object diagrams are dependent on the class diagram as they are derived from the class diagram. It represents an instance of a class diagram. The objects help in portraying a static view of an object-oriented system at a specific instant.

Both the object and class diagram are similar to some extent; the only difference is that the class diagram provides an abstract view of a system. It helps in visualizing a particular functionality of a system.

## Notation of an Object Diagram
![[Pasted image 20260215113255.png]]
## Purpose of Object Diagram
The object diagram holds the same purpose as that of a class diagram. The class diagram provides an abstract view which comprises of classes and their relationships, whereas the object diagram represents an instance at a particular point of time.
The object diagram is actually similar to the concrete (actual) system behavior. The main purpose is to depict a static view of a system.
- It is used to perform forward and reverse engineering.
- It is used to understand object behavior and their relationships practically.
- It is used to get a static view of a system.
- It is used to represent an instance of a system.

## Example of Object Diagram
![[Pasted image 20260215113354.png]]
## How to draw an Object Diagram?

1. All the objects present in the system should be examined before start drawing the object diagram.
2. Before creating the object diagram, the relation between the objects must be acknowledged.
3. The association relationship among the entities must be cleared already.
4. To represent the functionality of an object, a proper meaningful name should be assigned.
5. The objects are to be examined to understand its functionality.
## Applications of Object diagrams
1. To build a prototype of a system.
2. To model complex data structures.
3. To perceive the system from a practical perspective.
4. Reverse engineering.

## Class vs. Object diagram

|Serial No.|Class Diagram|Object Diagram|
|---|---|---|
|1.|It depicts the static view of a system.|It portrays the real-time behavior of a system.|
|2.|Dynamic changes are not included in the class diagram.|Dynamic changes are captured in the object diagram.|
|3.|The data values and attributes of an instance are not involved here.|It incorporates data values and attributes of an entity.|
|4.|The object behavior is manipulated in the class diagram.|Objects are the instances of a class.|
