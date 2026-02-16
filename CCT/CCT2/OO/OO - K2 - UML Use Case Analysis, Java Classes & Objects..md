---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: "UML tools (light) | \rUse-case analysis (light) | \rRelation to object oriented design process\r | Classes and objects\r | Attributes | \rMethods\r | How to define classes | \rHow to use objects in our code"
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - w3schools - Java Classes
  - tpointtech - Use Case Diagram | UML (Unified Modeling Language)
  - medium - Modularization in Software Engineering
Created: 10/02/2026
---
- - - 
# Table of Contents

1. [[#Java OOP and Software Engineering Concepts|Java OOP and Software Engineering Concepts]]
	1. [[#Java OOP and Software Engineering Concepts#Object-Oriented Programming (OOP) Fundamentals|Object-Oriented Programming (OOP) Fundamentals]]
		1. [[#Object-Oriented Programming (OOP) Fundamentals#Classes and Objects|Classes and Objects]]
		2. [[#Object-Oriented Programming (OOP) Fundamentals#Java Classes and Attributes|Java Classes and Attributes]]
		3. [[#Object-Oriented Programming (OOP) Fundamentals#Java Methods|Java Methods]]
	2. [[#Java OOP and Software Engineering Concepts#Advanced OOP Concepts|Advanced OOP Concepts]]
		1. [[#Advanced OOP Concepts#Constructors|Constructors]]
		2. [[#Advanced OOP Concepts#The `this` Keyword|The `this` Keyword]]
		3. [[#Advanced OOP Concepts#Modifiers|Modifiers]]
			1. [[#Modifiers#Access Modifiers|Access Modifiers]]
			2. [[#Modifiers#Non-Access Modifiers|Non-Access Modifiers]]
		4. [[#Advanced OOP Concepts#Encapsulation|Encapsulation]]
	3. [[#Java OOP and Software Engineering Concepts#Software Engineering Design Principles|Software Engineering Design Principles]]
		1. [[#Software Engineering Design Principles#Use Case Diagrams (UML)|Use Case Diagrams (UML)]]
		2. [[#Software Engineering Design Principles#Modularization|Modularization]]
			1. [[#Modularization#Benefits of Modularization|Benefits of Modularization]]
			2. [[#Modularization#Coupling vs. Cohesion|Coupling vs. Cohesion]]

# Java OOP and Software Engineering Concepts

| Concept | Syntax/Keyword | Description |
| :--- | :--- | :--- |
| **Class** | `class MyClass {}` | A user-defined blueprint or prototype from which objects are created. |
| **Object** | `new MyClass()` | An instance of a class with specific values for attributes (state). |
| **Attribute** | `int x = 5;` | Variables defined inside a class (also called fields) that hold data. |
| **Method** | `public void myMethod() {}` | A block of code that performs a specific action, defined inside a class. |
| **Constructor** | `public MyClass() {}` | A special method called when an object is instantiated, used to initialize the object. |
| **this** | `this.x = x;` | Refers to the current object, used to distinguish class attributes from parameters. |
| **Encapsulation** | `private` + getters/setters | Hiding internal data and requiring interaction through public methods. |
| **Modifier (public)** | `public class` | Accessible from any other class. |
| **Modifier (private)** | `private int x` | Accessible only within the declared class. |
| **Modifier (final)** | `final int MAX = 10` | The value cannot be changed (constant). |
| **Modifier (static)** | `static void myMethod()` | Belongs to the class rather than an instance of the class. |

---

## Object-Oriented Programming (OOP) Fundamentals

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of "objects", which can contain data and code. The data is in the form of fields (often known as attributes or properties), and the code is in the form of procedures (often known as methods).

> [!abstract] **OOP vs Procedural Programming**
> In procedural programming, you write procedures or functions that perform operations on data. In OOP, you create objects that bundle both data and methods together. Think of it like a car: procedural programming is a list of instructions on *how* to drive, while OOP is giving you a car object that knows *how* to drive itself.

### Classes and Objects

Classes and objects are the two main aspects of OOP.

*   **Class:** A template or blueprint for creating objects. It defines the properties (attributes) and behaviors (methods) that the objects created from it will have.
*   **Object:** An instance of a class. When a class is defined, no memory is allocated until an object is created.

> [!example] **Class vs. Object Analogy**
> *   **Class (Blueprint):** `Fruit` / `Car`
> *   **Objects (Instances):** `Apple`, `Banana`, `Mango` / `Volvo`, `Audi`, `Toyota`

> [!tip] **The DRY Principle**
> OOP helps keep the Java code DRY ("Don't Repeat Yourself"). You should extract common code and place it in a single place (like a class or method) to be reused, rather than repeating it.

### Java Classes and Attributes

Everything in Java is associated with classes and objects. To create a class, use the keyword `class`. Variables declared inside a class are called **attributes** (or fields).

```java
public class Main {
  int x = 5;  // Attribute (or field)
  int y = 3;
}
```

You can access attributes by creating an object and using the dot syntax (`.`).

> [!example] **Creating and Using Objects**
> ```java
> public class Main {
>   int x = 5;
> 
>   public static void main(String[] args) {
>     Main myObj = new Main();  // Create an object of Main
>     System.out.println(myObj.x); // Outputs 5
>   }
> }
> ```

You can create multiple objects of one class. Modifying the attribute in one object does not affect the attribute in another.

> [!example] **Multiple Objects with Independent States**
> ```java
> public class Main {
>   int x = 5;
> 
>   public static void main(String[] args) {
>     Main myObj1 = new Main();
>     Main myObj2 = new Main();
>     myObj2.x = 25; // Change x in myObj2 only
>     System.out.println(myObj1.x); // Outputs 5
>     System.out.println(myObj2.x); // Outputs 25
>   }
> }
> ```

### Java Methods

Methods are declared within a class and perform specific actions.

> [!example] **Defining and Calling a Method**
> ```java
> public class Main {
>   // Method definition
>   public void fullThrottle() {
>     System.out.println("The car is going as fast as it can!");
>   }
> 
>   public void speed(int maxSpeed) {
>     System.out.println("Max speed is: " + maxSpeed);
>   }
> 
>   public static void main(String[] args) {
>     Main myCar = new Main();
>     myCar.fullThrottle();  // Call the method
>     myCar.speed(200);      // Call with parameter
>   }
> }
> ```

---

## Advanced OOP Concepts

### Constructors

A constructor is a special method used to initialize objects. It is called when an object of a class is created.

*   The name must match the class name exactly.
*   It has no return type (not even `void`).

> [!example] **Using a Constructor to Set Initial Values**
> ```java
> public class Main {
>   int modelYear;
>   String modelName;
> 
>   // Constructor with parameters
>   public Main(int year, String name) {
>     modelYear = year;
>     modelName = name;
>   }
> 
>   public static void main(String[] args) {
>     Main myCar = new Main(1969, "Mustang");
>     System.out.println(myCar.modelYear + " " + myCar.modelName);
>   }
> }
> // Outputs: 1969 Mustang
> ```

### The `this` Keyword

The `this` keyword refers to the current object in a method or constructor. It is primarily used to resolve ambiguity between class attributes and parameters with the same name.

> [!info] **Constructor Chaining**
> You can also use `this()` to call another constructor in the same class. This is useful for reusing code (e.g., setting default values). The call to `this()` must be the **first statement** in the constructor.

> [!example] **Using `this` to Disambiguate Variables**
> ```java
> public class Main {
>   int x;
> 
>   public Main(int x) {
>     this.x = x; // "this.x" is the class attribute, "x" is the parameter
>   }
> }
> ```

### Modifiers

Modifiers determine how classes, attributes, and methods can be accessed. They are divided into two groups:

1.  **Access Modifiers:** Control the access level.
2.  **Non-Access Modifiers:** Do not control access but provide other functionality.

#### Access Modifiers

| Modifier | Description |
| :--- | :--- |
| `public` | Accessible from anywhere (other classes, packages). |
| `private` | Accessible only within the declared class. |
| `protected` | Accessible in the same package and subclasses. |
| (default) | Accessible only in the same package (no keyword used). |

> [!warning] **Accessing Private Members**
> Attempting to access a `private` variable from another class will result in a compile-time error.
> ```java
> class Person {
>   private String name = "John"; // Private
> }
> 
> public class Main {
>   public static void main(String[] args) {
>     Person p = new Person();
>     System.out.println(p.name); // Error: name has private access
>   }
> }
> ```

#### Non-Access Modifiers

*   **`final`:** The value cannot be changed (constant). Classes cannot be inherited, methods cannot be overridden.
*   **`static`:** Belongs to the class, not the object. Can be accessed without creating an object.
*   **`abstract`:** Used for classes and methods. Abstract classes cannot be instantiated. Abstract methods have no body (must be implemented by subclasses).

### Encapsulation

Encapsulation is the practice of hiding "sensitive" data from users. To achieve this:

1.  Declare class attributes as `private`.
2.  Provide public **get** and **set** methods to access and update the value of a `private` variable.

> [!tip] **Benefits of Encapsulation**
> *   **Control:** You can validate data in the setter (e.g., prevent negative age).
> *   **Flexibility:** You can change the internal implementation without affecting the code that uses the class.
> *   **Security:** Data is protected from unauthorized access.

> [!example] **Implementing Getters and Setters**
> ```java
> public class Person {
>   private String name; // Private attribute
> 
>   // Getter
>   public String getName() {
>     return name;
>   }
> 
>   // Setter
>   public void setName(String newName) {
>     this.name = newName;
>   }
> }
> 
> public class Main {
>   public static void main(String[] args) {
>     Person myObj = new Person();
>     myObj.setName("John"); // Use setter to modify
>     System.out.println(myObj.getName()); // Use getter to read
>   }
> }
> ```

---

## Software Engineering Design Principles

### Use Case Diagrams (UML)

A **Use Case Diagram** is used to represent the dynamic behavior of a system. It captures the system's functionality by modeling the interactions between **actors** (users) and **use cases** (functions).

*   **Actor:** A person or external entity that interacts with the system.
*   **Use Case:** A specific function or service provided by the system.
*   **Relationships:**
    *   **Include:** A use case *always* includes the behavior of another.
    *   **Extend:** A use case *may* extend the behavior of another under specific conditions.

> [!example] **Step-by-Step: Drawing a Use Case Diagram**
> To create an effective Use Case diagram, follow this structured process:
> 
> 1.  **Analyze the System:** Start by analyzing the whole system to understand its scope and boundaries.
> 2.  **Identify Functionalities (Use Cases):** Find all specific functionalities or tasks the system needs to perform. Transform each of these functionalities into a distinct use case.
> 3.  **Identify Actors:** Enlist all the persons or external entities (actors) that will invoke or interact with these functionalities.
> 4.  **Establish Relationships:** Inspect and define the relationship between the actors and the use cases. Determine how many times an actor communicates with the system and connect them using the appropriate association lines.
> 5.  **Refine and Verify:** Ensure the final diagram adheres to the following rules:
>     *   **Meaningful Names:** Assign pertinent and understandable names to all actors and use cases.
>     *   **Clear Communication:** Define the interaction between the actor and use case clearly.
>     *   **Correct Notation:** Use specified UML notations accurately.
>     *   **Focus:** Represent only the most significant interactions to keep the diagram readable.

> [!example] **Online Shopping Use Case Diagram**
> In an online shopping system, a **Web Customer** (Actor) interacts with use cases like **View Items**, **Make Purchase**, and **Client Register**.
> *   **Checkout** is *included* in **Make Purchase** (you cannot checkout without making a purchase).
> *   **Search Items** *extends* **View Items** (viewing is general, searching is a specific way to view).

![[Pasted image 20260210134335.png]]

_Figure 2.1.1: High-level Use Case Diagram for an Online Shopping System._

![[Pasted image 20260210134349.png]]

_Figure 2.1.2: Detailed diagram showing the 'View Items' use case and its extensions._

![[Pasted image 20260210134359.png]]

_Figure 2.1.3: Detailed diagram showing the 'Checkout' use case including authentication and payment._

### Modularization

**Modularization** is the process of separating a program's functionality into independent, interchangeable modules. Each module contains everything necessary to execute only one aspect of the desired functionality.

![[Pasted image 20260210134442.png]]

_Figure 2.2.1: Diagram illustrating the concept of modularization, breaking a system into distinct components._

![[Pasted image 20260210134457.png]]

_Figure 2.2.2: Comparison between a Monolithic program (single file) and a Modular program (separate components)._

#### Benefits of Modularization

*   **Ease of Maintenance:** Changes in one module rarely affect others.
*   **Reusability:** Modules can be reused in different projects.
*   **Parallel Development:** Teams can work on different modules simultaneously.
*   **Abstraction:** Implementation details are hidden; only the interface matters.

![[Pasted image 20260210134510.png]]

_Figure 2.2.3: Visualizing modularization as the foundation for Microservices architecture._

#### Coupling vs. Cohesion

To design good modules, we aim for:
1.  **Low Coupling:** Minimal interdependence between modules. A change in Module A should not break Module B.
2.  **High Cohesion:** Elements within a module should be strongly related and focused on a single task.

![[Pasted image 20260210134530.png]]

_Figure 2.2.4: Conceptual diagram showing the desired state of High Cohesion and Low Coupling._

![[Pasted image 20260210134539.png]]

_Figure 2.2.5: Visualizing different types of module coupling, where (c) represents high/unwanted coupling._

> [!example] **Modularizing a Text-to-Speech Application**
> A monolithic text-to-speech app can be broken down into:
> 1.  **Text Parser Module:** Handles input text processing.
> 2.  **Voice Engine Module:** Manages available computer voices.
> 3.  **Controller Module:** Adjusts speed/pitch.
> 
> These modules can be developed independently. Furthermore, the **Voice Engine** and **Text Parser** could be reused in a completely different application, like a Voice Navigation System.

![[Pasted image 20260210134549.png]]

_Figure 2.2.6: Decomposition of a monolithic Text-to-Speech application into specific functional modules._

![[Pasted image 20260210134559.png]]

_Figure 2.2.7: Reusing the Text-to-Speech and Computer Voice modules in a new Voice Navigation application._

---

> [!summary] **Summary**
> 
> **Java OOP** allows developers to model real-world entities using **Classes** (blueprints) and **Objects** (instances). **Attributes** store data, while **Methods** define behavior. **Constructors** initialize objects, and the `this` keyword distinguishes class variables from parameters.
> 
> **Modifiers** control access and behavior: `public`/`private` dictate visibility, while `static`/`final` dictate lifecycle and mutability. **Encapsulation** protects data by making attributes `private` and accessing them via public getters/setters.
> 
> In **Software Engineering**, **Modularization** breaks complex systems into manageable, independent modules. This improves maintainability and allows for parallel development. Good design requires **Low Coupling** (minimal dependencies) and **High Cohesion** (focused functionality). **Use Case Diagrams** (UML) are used to visually model the system's functional requirements and the interactions between Actors and Use Cases.