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
# Java Inheritance and UML Class Diagrams

| Concept | Syntax/Notation | Description |
|---------|----------------|-------------|
| **Inheritance** | `class Child extends Parent` | Child class inherits attributes and methods from Parent class |
| **Access Modifiers** | `public`, `private`, `protected`, `package (~)` | Control visibility of attributes and methods |
| **Final Class** | `final class ClassName` | Prevents inheritance from this class |
| **Association** | Line connecting classes | "Knows" relationship between classes |
| **Aggregation** | Line with empty diamond | "Has-a" relationship; parts can exist independently |
| **Composition** | Line with filled diamond | "Owns" relationship; parts cannot exist independently |
| **Generalization** | Line with empty triangle arrow | Inheritance relationship pointing to parent |
| **Dependency** | Dashed line with arrow | One class depends on another |
| **Multiplicity** | `0..1`, `1`, `*`, `1..*` | Number of instances in relationships |
| **Abstract Class** | Class name in _italics_ | Cannot be instantiated; defines common interface |
| **Stereotype** | `<<interface>>`, `<<abstract>>` | UML extension for additional semantic information |

_Table 1.1: Quick reference for Java inheritance concepts and UML notations._

---

## Subclass and Superclass

>[!info] **Inheritance Definition**
>Inheritance is the mechanism in Java that allows one class (subclass/child) to inherit attributes and methods from another class (superclass/parent). This creates an "is-a" relationship between classes.

**Key Terminology:**
- **Subclass (child):** The class that inherits from another class
- **Superclass (parent):** The class being inherited from
- **Keyword:** Use `extends` to establish inheritance

>[!example] **Basic Inheritance Syntax**
>```java
>class Vehicle {
>  protected String brand = "Ford";        // Vehicle attribute
>  public void honk() {                    // Vehicle method
>    System.out.println("Tuut, tuut!");
>  }
>}
>
>class Car extends Vehicle {
>  private String modelName = "Mustang";    // Car attribute
>  public static void main(String[] args) {
>    Car myCar = new Car();
>    myCar.honk();  // Inherited method from Vehicle
>    System.out.println(myCar.brand + " " + myCar.modelName);
>    // Output: Ford Mustang
>  }
>}
>```

### Why Use [[#Subclass and Superclass|Inheritance]]?

>[!tip] **Code Reusability**
>Inheritance allows you to reuse attributes and methods of an existing class when creating a new class. This leads to:
>- Less code duplication
>- Better code organization
>- Easier maintenance
>- Clearer relationships between concepts

>[!example] **Inheritance Hierarchy**
>A practical hierarchy demonstrates how inheritance reduces code duplication:
>
>```
>Vehicle (parent)
>  └── Bicycle (child of Vehicle)
>      ├── MountainBike (child of Bicycle)
>      └── RacingBike (child of Bicycle)
>```
>
>- `MountainBike` inherits all attributes/methods from both `Bicycle` and `Vehicle`
>- You only write bicycle-specific code once in the `Bicycle` class
>- Mountain bike-specific code goes only in `MountainBike`

![[Pasted image 20260221124005.png]]

_Figure 1.1: Inheritance hierarchy showing Vehicle as the parent class with Bicycle and Bus as child classes, and MountainBike and RacingBike as children of Bicycle._

### How Inheritance Works in Java

>[!info] **Single Inheritance Rule**
>In Java, a class can only extend from **one** parent class. If you need to inherit characteristics from multiple sources, you must create a hierarchy chain.

```java
package helloworld;

public class Bicycle {
    // General methods and fields for all bicycles
}
```

```java
package helloworld;

public class MountainBike extends Bicycle {
    // Specific methods and fields for mountain bikes only
}
```

![[Pasted image 20260221124035.png]]

_Figure 1.2: Simple inheritance diagram showing MountainBike extending Bicycle class._

>[!example] **Multi-Level Inheritance Chain**
>When you need characteristics from multiple sources, create a chain:
>
>```java
>// Level 1: Most general
>class Vehicle { }
>
>// Level 2: More specific
>class Bicycle extends Vehicle { }
>
>// Level 3: Most specific
>class MountainBike extends Bicycle { }
>```
>
>`MountainBike` now has access to methods and attributes from both `Bicycle` and `Vehicle`.

![[Pasted image 20260221124101.png]]

_Figure 1.3: Multi-level inheritance showing the chain from Vehicle to Bicycle to MountainBike._

### [[#Generalization|Generalization]] Concept

>[!abstract] **Generalization Analogy**
>Inheritance is also called **generalization** because the superclass represents a generic (general) version of its subclasses:
>
>- A `Bicycle` is the generic version of a `RacingBike`
>- A `Vehicle` is the generic version of a `Bus`
>- A `MeansOfTransport` is the generic version of a `Vehicle`
>
>Think of it as zooming out to see the bigger category that contains the specific item.

![[Pasted image 20260221124129.png]]

_Figure 1.4: Conceptual diagram showing generalization from specific (RacingBike) to general (MeansOfTransport)._

---

## Attribute and Method Visibility

>[!info] **Access Modifiers for Inheritance**
>When working with inheritance, you need to control which attributes and methods are accessible to child classes. Java provides four access levels:

| Modifier | Same Class | Same Package | Subclass | Other Packages |
|----------|-----------|--------------|----------|----------------|
| `public` | ✓ | ✓ | ✓ | ✓ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| _default_ (package) | ✓ | ✓ | ✗ | ✗ |
| `private` | ✓ | ✗ | ✗ | ✗ |

_Table 1.2: Access modifier visibility levels in Java inheritance._

>[!warning] **Private Members Are Not Inherited**
>If an attribute in the superclass is declared as `private`, the subclass **cannot** access it directly. You must use `protected` or provide public getter/setter methods.

>[!example] **Why Protected Matters**
>```java
>class Vehicle {
>  private String brand = "Ford";    // NOT accessible to Car
>  protected String type = "Motor";  // Accessible to Car
>}
>
>class Car extends Vehicle {
>  public void printInfo() {
>    // System.out.println(brand);  // ERROR: brand is private
>    System.out.println(type);       // OK: type is protected
>  }
>}
>```

![[Pasted image 20260221124451.png]]

_Figure 1.5: Visual representation of access modifier visibility across class boundaries._

>[!tip] **Best Practice for Inheritance**
>Use `protected` for attributes and methods that:
>- Should be accessible to subclasses
>- Should remain hidden from unrelated classes
>- Are part of the internal implementation that child classes need

---

## The `final` Keyword

>[!info] **Preventing Inheritance**
>The `final` keyword, when applied to a class, prevents any other class from extending it. This is useful when you want to lock down the implementation for security or design reasons.

>[!example] **Final Class Declaration**
>```java
>final class Vehicle {
>  public void honk() {
>    System.out.println("Tuut!");
>  }
>}
>
>class Car extends Vehicle {  // Compilation ERROR
>  // Cannot inherit from final Vehicle
>}
>```
>
>**Compiler Error:**
>```
>Main.java:9: error: cannot inherit from final Vehicle
>  class Car extends Vehicle {
>                    ^
>1 error
>```

>[!warning] **When to Use `final`**
>Use `final` for classes when:
>- The class represents a fundamental, unchangeable concept
>- Inheritance could break the class's intended behavior
>- Security requires preventing subclass manipulation (e.g., `String` class in Java is `final`)

---

## UML Class Diagrams

>[!info] **Class Diagram Purpose**
>A UML Class Diagram provides a **static view** of an application by showing:
>- The types of objects in the system
>- The attributes and methods of each class
>- The relationships between classes
>
>It is the most widely used UML diagram for software construction and can be directly mapped to object-oriented code.

### Benefits of Class Diagrams

>[!tip] **Why Create Class Diagrams?**
>1. **Visualize object models** for complex systems
>2. **Reduce maintenance time** by understanding structure before coding
>3. **Provide a general schematic** for better team understanding
>4. **Highlight desired code** with detailed charts
>5. **Aid communication** between stakeholders and developers
>6. **Support forward and reverse engineering**

### Vital Components of a Class Diagram

>[!info] **Three-Section Class Structure**
>Each class in a UML diagram is represented by a rectangle divided into three sections:

![[Pasted image 20260215112423.png]]

_Figure 2.1: UML class structure showing the three sections: name, attributes, and methods._

**1. Upper Section - Class Name:**
- Capitalize the initial letter
- Place in the center of the section
- Write in **bold** format
- Write _abstract class names_ in **_bold italics_**

**2. Middle Section - Attributes:**
- List the properties/fields of the class
- Include visibility modifier symbols:
  - `+` public
  - `-` private
  - `#` protected
  - `~` package (default)
- Format: `visibility name : type`

**3. Lower Section - Methods:**
- List the operations/functions
- Include visibility modifiers
- Format: `visibility methodName(parameters) : returnType`

>[!example] **Complete Class Representation**
>```
>┌─────────────────────┐
>│   BankAccount       │ ← Class Name (bold)
>├─────────────────────┤
>│ - accountNumber: int│ ← Attributes with visibility
>│ - balance: double   │
>│ # owner: String     │
>├─────────────────────┤
>│ + deposit(amount)   │ ← Methods with visibility
>│ + withdraw(amount)  │
>│ + getBalance()      │
>└─────────────────────┘
>```

---

## Relationships in UML

### [[#Relationships|Dependency]]

>[!info] **Dependency Relationship**
>A dependency is a **semantic relationship** where changes in one class may affect another class. It represents the weakest form of relationship between classes. One class "uses" another temporarily.
>
>**Notation:** Dashed line with an open arrow pointing to the class being depended upon.

![[Pasted image 20260215112627.png]]

_Figure 2.2: Dependency relationship showing Student_Id depends on Student_Name._

>[!example] **Dependency Scenarios**
>- Changes in Class A impact Class B
>- Class A relies on Class B for some functionality
>- A `Person` needs a `Bicycle` to execute `Ride()` method
>- Changes in `Bicycle` immediately affect `RacingBicycle` through inheritance
>
>**Key characteristic:** Dependency is **one-way**. Changes in `RacingBicycle` do NOT impact `Bicycle`.

### [[#Relationships|Generalization]]

>[!info] **Generalization (Inheritance) Relationship**
>Generalization represents the inheritance relationship between a parent class (superclass) and a child class (subclass). The child inherits attributes and methods from the parent.
>
>**Notation:** Solid line with an empty triangle arrow pointing to the parent class.

![[Pasted image 20260215112758.png]]

_Figure 2.3: Generalization showing BankAccount as parent with CurrentAccount, SavingAccount, and CreditAccount as children._

>[!example] **Generalization Use Case**
>Methods may be the same across different classes (e.g., acquiring and disposing properties for `Person` and `Corporation`), but the **implementation** differs significantly.
>
>This is useful when you want to interact with different objects the same way:
>- Share a `Drive()` interface across `Bicycle`, `Car`, `Train`
>- Each implements `Drive()` differently
>- You can call `Drive()` on any vehicle type without knowing the specific implementation

>[!abstract] **Realization Relationship**
>A special form of generalization that shows a class implements an interface. The class provides the code realization of the interface's blueprint.
>
>**Notation:** Dashed line with an empty triangle arrow pointing to the interface.

### [[#Relationships|Association]]

>[!info] **Association Relationship**
>Association describes a **static or physical connection** between two or more objects. It shows "knows about" relationships and specifies how many objects participate in the relationship.
>
>**Notation:** Solid line connecting classes, optionally with arrows to show directionality.

![[Pasted image 20260215112818.png]]

_Figure 2.4: Association between Department and College classes._

>[!example] **Association Characteristics**
>- A `Person` might have (know) a `Bicycle` or two, but not necessarily
>- `Person` knows `Bicycle`
>- `Bicycle` does not know `Person`
>- `Person` can invoke methods in `Bicycle`
>
>**Directionality:**
>- Arrows indicate one-way knowledge
>- Lines without arrows suggest bidirectional awareness
>- Crosses can indicate "cannot navigate this way"

![[Pasted image 20260221124559.png]]

_Figure 2.5: Association with cardinality showing Person can have 0 to many Bicycles, and must have exactly 1 Passport._

**Cardinality (Multiplicity) Examples:**

| Notation | Meaning |
|----------|---------|
| `1` | Exactly one |
| `0..1` | Zero or one |
| `*` or `0..*` | Zero or more |
| `1..*` | One or more |
| `3..5` | Between 3 and 5 |

_Table 2.1: Common multiplicity notations in UML associations._

>[!tip] **Enhanced Association Notation**
>For more specific associations, you can:
>- Add **open arrows** to make directionality explicit or binary (one-way)
>- **Annotate** the association line to communicate intent
>- State the exact **property name and visibility**

![[Pasted image 20260221124620.png]]

_Figure 2.6: Annotated association showing role names and navigation direction._

>[!abstract] **How Association Works**
>Association is the most generic type of composition between objects. All it requires is for one class to know another class exists.
>
>**Relationship strength:** Association < Aggregation < Composition
>
>Association simply means: "These two interact somehow."

![[Pasted image 20260221124639.png]]

_Figure 2.7: Simple association example between two classes._

![[Pasted image 20260221124650.png]]

_Figure 2.8: Association with multiplicity showing one-to-many relationship._

### Multiplicity in Detail

>[!info] **Multiplicity Definition**
>Multiplicity defines a **specific range of allowable instances** of attributes in a relationship. If no range is specified, `1` (exactly one) is considered the default.

>[!example] **Multiplicity Examples**
>- **Multiple patients to one hospital:** `Hospital 1 ---- 0..* Patient`
>- **Multiple customers to one business:** `Business 1 ---- * Customer`
>- **One person to one passport:** `Person 1 ---- 1 Passport`

![[Pasted image 20260215112847.png]]

_Figure 2.9: Multiplicity example showing multiple patients admitted to one hospital._

---

### [[#Relationships|Aggregation]]

>[!info] **Aggregation Relationship**
>Aggregation is a **specialized form of association** representing a "has-a" or "part-of" relationship. The key characteristic is that the **child class can exist independently** of the parent class.
>
>**Notation:** Solid line with an **empty diamond** on the "whole" side.

![[Pasted image 20260215112945.png]]

_Figure 2.10: Aggregation showing Company has multiple Employees, but employees can exist independently._

>[!example] **Aggregation Characteristics**
>A `Company` has many `Employee` objects. Even if one employee resigns, the company still exists. Similarly, if the company closes, employees continue to exist as independent entities.
>
>**Key distinction:** "The 'whole' groups the parts but does not own their lifetime."

>[!abstract] **Aggregation vs. Association**
>Aggregation is **stronger than association** but **weaker than composition**:
>
>**Association:** Classes simply know each other
>**Aggregation:** One class contains objects of another, but lifecycles are independent
>
>Examples:
>- A `Bicycle` and its `Wheels` can be separated
>- A `Robator` can run without the `Drone`
>- The lack of one part does not destroy the other

>[!example] **Aggregation Implementation**
>```java
>class Bank {
>  private ArrayList<Employee> employees;  // Aggregation
>  
>  public void addEmployee(Employee emp) {
>    employees.add(emp);
>  }
>  
>  public void removeEmployee(Employee emp) {
>    employees.remove(emp);  // Employee still exists after removal
>  }
>}
>```
>
>In this example:
>- `Bank` knows (many) `Employee` objects
>- Employees are **part of** the bank
>- You can have a bank with no employees (empty list)
>- You can have employees without a bank (they exist independently)
>- Removing an employee from the bank doesn't destroy the `Employee` object

![[Pasted image 20260221124751.png]]

_Figure 2.11: Aggregation example showing Bank aggregates Employee objects._

>[!warning] **Garbage Collection Consideration**
>With aggregation, objects are **not automatically garbage collected** when the "whole" is destroyed. Objects may hang around in memory if not explicitly managed. This can lead to memory leaks if you're not careful.

---

### [[#Relationships|Composition]]

>[!info] **Composition Relationship**
>Composition is the **strongest form of aggregation** with added dependency. If the "whole" is destroyed, all its "parts" are also destroyed. The parts **cannot exist independently** of the whole.
>
>**Notation:** Solid line with a **filled diamond** on the "whole" side.

![[Pasted image 20260215113014.png]]

_Figure 2.12: Composition showing ContactBook owns multiple Contacts; deleting the book deletes all contacts._

>[!example] **Composition Characteristics**
>A `ContactBook` consists of multiple `Contact` objects. If you delete the contact book, **all the contacts are lost** because they cannot exist without the contact book.
>
>**Key distinction:** "The parts cannot live without the 'whole'."

>[!abstract] **Composition Lifecycle Control**
>- If `A` is destroyed, then `B` is also destroyed
>- `B` cannot exist without `A` because `B` is a part of `A`
>- The lifecycle of `B` is **controlled by** `A`
>
>Example: If you destroy a `Gear`, the `Sprocket` is also destroyed. (In a real-world physical sense, you might reuse a sprocket, but in the software model, it's destroyed.)

>[!example] **Composition vs. Aggregation Examples**
>
>**Composition (strong ownership):**
>- A `Building` has `Rooms` – If we tear down a building, its rooms go with it
>- A `University` has `Faculties` – If AAU closes, so would its faculties
>- A `Gear` has `Sprockets` – Destroying the gear destroys the sprockets
>
>**Aggregation (weak ownership):**
>- A `Library` has `Books` – The library can close, but books still exist
>- A `Playlist` has `Songs` – Deleting a playlist doesn't delete the songs

>[!example] **Composition Implementation**
>```java
>class Bank {
>  private ArrayList<Employee> employees = new ArrayList<>();
>  
>  public Bank() {
>    // Employees are created by the Bank
>    employees.add(new Employee("John"));
>    employees.add(new Employee("Jane"));
>  }
>  
>  // No public method to remove individual employees
>  // When Bank is destroyed, employees are automatically garbage collected
>}
>```
>
>In this composition example:
>- `Bank` **owns** `Employee` objects
>- An employee **cannot exist** without a bank
>- If we destroy the bank, we also destroy the employees
>- Garbage collection happens automatically when the `Bank` object is removed

![[Pasted image 20260221124836.png]]

_Figure 2.13: Composition example showing Bank owns Employee objects._

![[Pasted image 20260221124843.png]]

_Figure 2.14: Detailed composition diagram with multiplicity and ownership indicators._

>[!warning] **Semantic vs. Technical Differences**
>The semantic difference between aggregation and composition can be **subtle** (both involve containment), but the **technical difference is clear**:
>
>- **Aggregation:** Objects can be externally manipulated; lifecycle is independent
>- **Composition:** Objects are internally controlled; lifecycle is dependent

---

## Abstract Classes

>[!info] **Abstract Class Definition**
>An abstract class **cannot be instantiated** directly. It serves as a blueprint for other classes, defining common functionalities that subclasses must implement or inherit.
>
>**Notation in UML:** Class name written in _italics_.

>[!example] **Abstract Class Use Case**
>Consider an abstract class named `Displacement` with an abstract method `drive()`. This method can be implemented by any concrete object:
>- `Car` implements `drive()` one way
>- `Bike` implements `drive()` another way
>- `Scooter` implements `drive()` yet another way
>- `Cycle` implements `drive()` in its own way
>
>Each concrete class provides its own implementation, but they all share the common interface defined by `Displacement`.

![[Pasted image 20260215113108.png]]

_Figure 2.15: Abstract class Displacement with concrete implementations Car, Bike, Scooter, and Cycle._

>[!abstract] **When to Use Abstract Classes**
>Use abstract classes when:
>- You want to define a common interface for multiple related classes
>- You have some implementation code that should be shared, but some methods must be implemented by subclasses
>- You want to prevent direct instantiation of the base class

---

## How to Draw a Class Diagram

>[!tip] **Class Diagram Best Practices**
>The class diagram is the most widely used UML diagram for software construction. It represents both a static view of the system and all major aspects of an application.

**Step-by-Step Process:**

1. **Name the diagram meaningfully** – Give it a title that describes the complete aspect of the system
2. **Identify objects and relationships in advance** – Understand what entities exist and how they relate
3. **Define attributes and methods** – Know the responsibilities of each class before drawing
4. **Specify minimum properties** – Too many properties lead to complex, unreadable diagrams
5. **Use notes when needed** – Add annotations to describe aspects that aren't obvious from the diagram itself
6. **Iterate multiple times** – Redraw and rework the diagram until it correctly represents the system

>[!warning] **Common Pitfalls**
>- **Too many details:** Including every getter/setter makes the diagram cluttered
>- **Unclear relationships:** Not specifying directionality or multiplicity causes confusion
>- **Inconsistent naming:** Using different names for the same concept across the diagram
>- **Skipping iteration:** The first draft is rarely correct; expect to revise

---

## Design Process: Towards a Class Diagram

>[!important] **Iterative Design Process**
>Creating a class diagram is a **design process** that requires multiple iterations to reach a satisfying result. There is no single "correct" answer, but you can evaluate quality intuitively.

**What Makes a Good Class Diagram?**
- ✓ Neither too small nor too big
- ✓ Descriptive but not too complex
- ✓ Relates to your code and is consistent
- ✓ Relates to the real world and is consistent

### Defining a Hierarchy

>[!example] **Hierarchy Definition Algorithm**
>For each class, ask these questions:
>
>**1. Is there a generic version of this class?**
>- **Yes:** Generalize it (create a parent class)
>- **No:** Leave it as is
>- **Stop** if generalization becomes just "Object" (this is the root anyway)
>
>**2. Does a method require specialized or same implementation?**
>- **Specialized:** Consider an **interface** instead of a parent class
>- **Same:** A parent class with the shared implementation is appropriate
>
>**3. Construct the tree:**
>- Start on a blackboard or paper (faster to work this way)
>- Some trees may stand alone
>- Some classes may be independent – that's fine

### Defining Relationships

>[!example] **Relationship Definition Process**
>For each class, ask:
>
>**Is there a relation to other classes?**
>- **Yes:** Decide which type of relationship (association, aggregation, composition, dependency, generalization) and draw it
>- **No:** Leave the class alone (no forced relationships)

>[!tip] **Start on a Blackboard!**
>It's tempting to jump straight into a diagram tool, but you risk spending more time "fighting the software" than sketching your design. Start simple with generic illustrations, and only once the design is solid should you consider making it "nice" in a digital tool.

---

## Class Diagram Examples

>[!example] **Sales Order System**
>This diagram shows a typical e-commerce order system with customers, orders, line items, and products.

![[Pasted image 20260215113142.png]]

_Figure 2.16: Class diagram for a sales order system showing relationships between Customer, Order, LineItem, and Product._

>[!example] **Order System with Details**
>A more detailed version showing attributes, methods, and cardinalities.

![[Pasted image 20260221125036.png]]

_Figure 2.17: Detailed order system class diagram with full attribute and method specifications._

>[!example] **GUI System**
>A graphical user interface system showing component hierarchy and event handling.

![[Pasted image 20260221125107.png]]

_Figure 2.18: GUI class diagram showing window, button, and event handler relationships._

---

## UML Stereotypes

>[!note] **Stereotypes in UML**
>You may notice notation like `<<interface>>` or `<<abstract>>` in some diagrams. These are called **stereotypes** in UML – a mechanism to "extend the vocabulary" of UML itself.
>
>Stereotypes provide **more information than vanilla UML supports**, but should be used **sparingly**.

**Common Stereotype Examples:**

| Stereotype | Meaning |
|------------|---------|
| `<<interface>>` | Not a typical "class"; defines a contract |
| `<<abstract>>` | Abstract class that cannot be instantiated |
| `<<enumeration>>` | A fixed set of named values |
| `<<utility>>` | A class containing only static methods |

_Table 2.2: Common UML stereotypes and their meanings._

>[!tip] **When to Use Stereotypes**
>Use stereotypes to make explicit important characteristics that aren't obvious from standard UML notation:
>- An `<<interface>>` is fundamentally different from a regular class
>- An `<<abstract>>` class has special instantiation rules
>- An `<<entity>>` in a database context has persistence implications

---

## Usage of Class Diagrams

>[!info] **Primary Applications**
>Class diagrams serve multiple purposes in software development:

1. **Represent a static view of a system** – Show structure, not behavior
2. **Show collaboration among instances** – Reveal how objects work together
3. **Describe system functionalities** – Document what the system can do
4. **Construct software with object-oriented languages** – Direct mapping to Java, C++, etc.
5. **Forward engineering** – Generate code from diagrams
6. **Reverse engineering** – Generate diagrams from existing code

>[!example] **Practical Use Cases**
>- **Before coding:** Design the system architecture and relationships
>- **During development:** Maintain a visual reference for the codebase
>- **Documentation:** Communicate design to stakeholders and new team members
>- **Refactoring:** Understand the current structure before making changes
>- **Code reviews:** Discuss design decisions at a high level

---

## UML Object Diagrams

>[!info] **Object Diagram Definition**
>An object diagram represents a **snapshot of objects at a specific instant in time**. It shows the actual instances of classes and their relationships, rather than the class definitions themselves.
>
>Object diagrams are **derived from class diagrams** and provide a concrete view of how the abstract class structure manifests in a running system.

**Key Differences from Class Diagrams:**

| Aspect | Class Diagram | Object Diagram |
|--------|---------------|----------------|
| **View** | Abstract, static view of types | Concrete, instance view at a specific time |
| **Focus** | Classes and their relationships | Objects (instances) and their links |
| **Attributes** | Attribute names and types | Actual attribute values |
| **Changes** | Does not show dynamic changes | Captures dynamic state at one moment |
| **Behavior** | Defines possible behaviors | Shows actual object configurations |

_Table 3.1: Comparison between class diagrams and object diagrams._

### Purpose of Object Diagrams

>[!tip] **When to Use Object Diagrams**
>Object diagrams serve the same general purpose as class diagrams but from a different perspective:
>
>1. **Perform forward and reverse engineering** – Understand how classes instantiate
>2. **Understand object behavior practically** – See real-world examples of class relationships
>3. **Get a static snapshot** – Capture the system state at a particular moment
>4. **Represent an instance of a system** – Show concrete examples, not abstractions

### Notation of an Object Diagram

>[!info] **Object Notation**
>Objects are represented similarly to classes but with key differences:
>- **Name format:** `objectName : ClassName` (underlined)
>- **Attributes:** Show actual values, not just types
>- **No methods:** Object diagrams don't typically show methods

![[Pasted image 20260215113255.png]]

_Figure 3.1: UML object diagram notation showing object name, class, and attribute values._

>[!example] **Object Diagram vs. Class Diagram**
>
>**Class Diagram:**
>```
>┌─────────────────────┐
>│   BankAccount       │
>├─────────────────────┤
>│ - accountNumber: int│
>│ - balance: double   │
>└─────────────────────┘
>```
>
>**Object Diagram:**
>```
>┌──────────────────────────┐
>│ myAccount : BankAccount  │  ← Underlined name
>├──────────────────────────┤
>│ accountNumber = 12345    │  ← Actual values
>│ balance = 1500.50        │
>└──────────────────────────┘
>```

### Example of Object Diagram

![[Pasted image 20260215113354.png]]

_Figure 3.2: Complete object diagram example showing multiple objects and their relationships with actual values._

### How to Draw an Object Diagram

>[!example] **Step-by-Step Process**
>1. **Examine all objects** in the system before starting
>2. **Understand relationships** between objects beforehand
>3. **Ensure association relationships** among entities are clear
>4. **Assign meaningful names** to represent the functionality of each object
>5. **Examine objects** to understand their functionality and state
>6. **Show actual attribute values** for the specific snapshot in time

### Applications of Object Diagrams

>[!tip] **When Object Diagrams Are Most Useful**
>1. **Build a prototype of a system** – Show example configurations before full implementation
>2. **Model complex data structures** – Illustrate specific instances of complicated relationships
>3. **Perceive the system from a practical perspective** – Move from abstract to concrete
>4. **Reverse engineering** – Document the state of a running system
>5. **Testing and validation** – Verify that class relationships work as intended with real data

>[!example] **Practical Use Case: Testing Object Relationships**
>Suppose you have a class diagram with `Customer`, `Order`, and `Product` classes. An object diagram can show:
>- `customer1 : Customer` with `name = "Alice"`
>- `order1 : Order` with `orderDate = "2025-02-21"`
>- `product1 : Product` with `name = "Laptop"` and `price = 999.99`
>- Links showing `customer1` placed `order1` containing `product1`
>
>This concrete example helps verify that your class relationships support real-world scenarios.

---

>[!summary] **Java Inheritance and UML Summary**
>
>**Inheritance in Java:**
>- Inheritance allows code reuse through the `extends` keyword
>- A subclass inherits attributes and methods from its superclass
>- Java supports **single inheritance** only (one parent per class)
>- Use `protected` access modifier to share members with subclasses while hiding them from unrelated classes
>- Use `final` keyword to prevent a class from being inherited
>- Inheritance creates "is-a" relationships and enables generalization hierarchies
>
>**UML Class Diagrams:**
>- Class diagrams show the **static structure** of a system with classes, attributes, methods, and relationships
>- **Three-section class notation:** name (top), attributes (middle), methods (bottom)
>- **Five main relationship types:**
>  - **Dependency:** Weakest; one class uses another temporarily (dashed arrow)
>  - **Association:** "Knows" relationship; can include multiplicity (solid line)
>  - **Aggregation:** "Has-a" with independent lifecycle (empty diamond)
>  - **Composition:** "Owns" with dependent lifecycle (filled diamond)
>  - **Generalization:** Inheritance relationship (empty triangle arrow)
>- **Abstract classes** (shown in _italics_) cannot be instantiated and define common interfaces
>- **Stereotypes** (`<<interface>>`, `<<abstract>>`) extend UML vocabulary for additional semantics
>
>**UML Object Diagrams:**
>- Object diagrams show **concrete instances** at a specific point in time
>- Display actual attribute values, not just types
>- Useful for prototyping, testing, and understanding real-world system states
>- Complement class diagrams by providing practical examples of abstract structures
>
>**Design Best Practices:**
>- Start with rough sketches (blackboard, paper) before using digital tools
>- Iterate multiple times to refine the design
>- Keep diagrams **simple and focused** – avoid unnecessary complexity
>- Ensure diagrams are **consistent** with both code and real-world concepts
>- Use the **instruction hierarchy** when resolving conflicts: Core Goals → Subject-Specific → Content → Formatting