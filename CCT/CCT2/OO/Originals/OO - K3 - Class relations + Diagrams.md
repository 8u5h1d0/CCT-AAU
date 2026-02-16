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
- - -
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

#### Why And When To Use "Inheritance"?

- It is useful for code reusability: reuse attributes and methods of an existing class when you create a new class.

**Tip:** Also take a look at the next chapter, [Polymorphism](https://www.w3schools.com/java/java_polymorphism.asp), which uses inherited methods to perform different tasks.

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
- **Generalization:** A generalization is a relationship between a parent class (superclass) and a child class (subclass). In this, the child class is inherited from the parent class.  
    For example, The Current Account, Saving Account, and Credit Account are the generalized form of Bank Account.
![[Pasted image 20260215112758.png]]
- **Association:** It describes a static or physical connection between two or more objects. It depicts how many objects are there in the relationship.  
    For example, a department is associated with the college.
![[Pasted image 20260215112818.png]]
**Multiplicity:** It defines a specific range of allowable instances of attributes. In case if a range is not specified, one is considered as a default multiplicity.

For example, multiple patients are admitted to one hospital.
![[Pasted image 20260215112847.png]]

Or multiple customers to a business

**Aggregation:** An aggregation is a subset of association, which represents has a relationship. It is more specific then association. It defines a part-whole or part-of relationship. In this kind of relationship, the child class can exist independently of its parent class.

The company encompasses a number of employees, and even if one employee resigns, the company still exists.
![[Pasted image 20260215112945.png]]
**Composition:** The composition is a subset of aggregation. It portrays the dependency between the parent and its child, which means if one part is deleted, then the other part also gets discarded. It represents a whole-part relationship.

A contact book consists of multiple contacts, and if you delete the contact book, all the contacts will be lost.
![[Pasted image 20260215113014.png]]

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
## Usage of Class diagrams
The class diagram is used to represent a static view of the system. It plays an essential role in the establishment of the component and deployment diagrams. It helps to construct an executable code to perform forward and backward engineering for any system, or we can say it is mainly used for construction. It represents the mapping with object-oriented languages that are C++, Java, etc.

Class diagrams can be used for the following purposes:
1. To describe the static view of a system.
2. To show the collaboration among every instance in the static view.
3. To describe the functionalities performed by the system.
4. To construct the software application using object-oriented languages.


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
