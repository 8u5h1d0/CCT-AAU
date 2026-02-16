---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
  - UML
  - Use_Case
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

1. [[#Java - What is OOP?|Java - What is OOP?]]
2. [[#Java - What are Classes and Objects?|Java - What are Classes and Objects?]]
3. [[#class|class]]
4. [[#objects|objects]]
5. [[#class|class]]
6. [[#objects|objects]]
7. [[#Java Classes and Objects|Java Classes and Objects]]
8. [[#Java Classes and Objects#Java Classes/Objects|Java Classes/Objects]]
9. [[#Java Classes and Objects#Create a Class|Create a Class]]
10. [[#Java Classes and Objects#Create an Object|Create an Object]]
	1. [[#Create an Object#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
11. [[#Java Classes and Objects#Multiple Objects|Multiple Objects]]
	1. [[#Multiple Objects#Example|Example]]
12. [[#Java Classes and Objects#Using Multiple Classes|Using Multiple Classes]]
13. [[#Java Class Attributes|Java Class Attributes]]
14. [[#Java Class Attributes#Java Class Attributes|Java Class Attributes]]
15. [[#Java Class Attributes#Accessing Attributes|Accessing Attributes]]
	1. [[#Accessing Attributes#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
16. [[#Java Class Attributes#Modify Attributes|Modify Attributes]]
	1. [[#Modify Attributes#Example|Example]]
	2. [[#Modify Attributes#Example|Example]]
	3. [[#Modify Attributes#Example|Example]]
17. [[#Java Class Attributes#Multiple Objects|Multiple Objects]]
	1. [[#Multiple Objects#Example|Example]]
18. [[#Java Class Attributes#Multiple Attributes|Multiple Attributes]]
	1. [[#Multiple Attributes#Example|Example]]
19. [[#Java Class Methods|Java Class Methods]]
20. [[#Java Class Methods#Java Class Methods|Java Class Methods]]
	1. [[#Java Class Methods#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
21. [[#Java Class Methods#Access Methods With an Object|Access Methods With an Object]]
	1. [[#Access Methods With an Object#Example|Example]]
	2. [[#Access Methods With an Object#Example explained|Example explained]]
	3. [[#Access Methods With an Object#Remember that..|Remember that..]]
22. [[#Java Class Methods#Using Multiple Classes|Using Multiple Classes]]
23. [[#Java Constructors|Java Constructors]]
24. [[#Java Constructors#Java Constructors|Java Constructors]]
	1. [[#Java Constructors#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
25. [[#Java Constructors#Constructor Parameters|Constructor Parameters]]
	1. [[#Constructor Parameters#Example|Example]]
	2. [[#Constructor Parameters#Example|Example]]
26. [[#Java this|Java this]]
27. [[#Java this#Java this Keyword|Java this Keyword]]
28. [[#Java this#Accessing Class Attributes|Accessing Class Attributes]]
	1. [[#Accessing Class Attributes#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
29. [[#Java this#Calling a Constructor from Another Constructor|Calling a Constructor from Another Constructor]]
	1. [[#Calling a Constructor from Another Constructor#Example|Example]]
30. [[#Java this#When to use this?|When to use this?]]
31. [[#Java Modifiers|Java Modifiers]]
32. [[#Java Modifiers#Modifiers|Modifiers]]
33. [[#Java Modifiers#Access Modifiers|Access Modifiers]]
34. [[#Java Modifiers#Public vs. Private Example|Public vs. Private Example]]
	1. [[#Public vs. Private Example#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Public vs. Private Example#Example explained|Example explained]]
35. [[#Java Non-Access Modifiers|Java Non-Access Modifiers]]
36. [[#Java Non-Access Modifiers#Non-Access Modifiers|Non-Access Modifiers]]
37. [[#Java Non-Access Modifiers#Final|Final]]
	1. [[#Final#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
38. [[#Java Non-Access Modifiers#Static|Static]]
	1. [[#Static#Example|Example]]
39. [[#Java Non-Access Modifiers#Abstract|Abstract]]
40. [[#Java Non-Access Modifiers#Non-Access Modifiers List|Non-Access Modifiers List]]
41. [[#Java Encapsulation|Java Encapsulation]]
42. [[#Java Encapsulation#Encapsulation|Encapsulation]]
43. [[#Java Encapsulation#Get and Set|Get and Set]]
	1. [[#Get and Set#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		1. [[#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")#Example explained|Example explained]]
	2. [[#Get and Set#Example|Example]]
	3. [[#Get and Set#Example|Example]]
44. [[#Java Encapsulation#Why Encapsulation?|Why Encapsulation?]]
45. [[#Use Case Diagram | UML (Unified Modeling Language)|Use Case Diagram | UML (Unified Modeling Language)]]
46. [[#Use Case Diagram | UML (Unified Modeling Language)#Purpose of Use Case Diagrams|Purpose of Use Case Diagrams]]
47. [[#Use Case Diagram | UML (Unified Modeling Language)#How to draw a Use Case diagram?|How to draw a Use Case diagram?]]
48. [[#Use Case Diagram | UML (Unified Modeling Language)#Example of a Use Case Diagram|Example of a Use Case Diagram]]
49. [[#Use Case Diagram | UML (Unified Modeling Language)#Important tips for drawing a Use Case diagram|Important tips for drawing a Use Case diagram]]
50. [[#Modularization in Software Engineering|Modularization in Software Engineering]]
51. [[#Modularization in Software Engineering#What is modularization?|What is modularization?]]
52. [[#Modularization in Software Engineering#Benefits of modularization|Benefits of modularization]]
53. [[#Modularization in Software Engineering#How should we decompose modules?|How should we decompose modules?]]
54. [[#Modularization in Software Engineering#Example: Modularization on a text-to-speech application|Example: Modularization on a text-to-speech application]]
55. [[#Modularization in Software Engineering#Get Caitlin Jee’s stories in your inbox|Get Caitlin Jee’s stories in your inbox]]
56. [[#Modularization in Software Engineering#Conclusion|Conclusion]]

## Java - What is OOP?

OOP stands for **Object-Oriented Programming**.

Procedural programming is about writing procedures or methods that perform operations on the data, while object-oriented programming is about creating objects that contain both data and methods.

Object-oriented programming has several advantages over procedural programming:

- OOP is faster and easier to execute
- OOP provides a clear structure for the programs
- OOP helps to keep the Java code DRY "Don't Repeat Yourself", and makes the code easier to maintain, modify and debug
- OOP makes it possible to create full reusable applications with less code and shorter development time

**Tip:** The "Don't Repeat Yourself" (DRY) principle is about reducing the repetition of code. You should extract out the codes that are common for the application, and place them at a single place and reuse them instead of repeating it.

---

## Java - What are Classes and Objects?

Classes and objects are the two main aspects of object-oriented programming.

Look at the following illustration to see the difference between class and objects:

## class

Fruit

## objects

Apple

Banana

Mango

Another example:

## class

Car

## objects

Volvo

Audi

Toyota

So, a class is a template for objects, and an object is an instance of a class.

When the individual objects are created, they inherit all the variables and methods from the class.

You will learn much more about [classes and objects](https://www.w3schools.com/java/java_classes.asp) in the next chapter.

# Java Classes and Objects

---

## Java Classes/Objects

Java is an object-oriented programming language.

Everything in Java is associated with classes and objects, along with its attributes and methods. For example: in real life, a car is an object. The car has **attributes**, such as weight and color, and **methods**, such as drive and brake.

A Class is like an object constructor, or a "blueprint" for creating objects.

---

## Create a Class

To create a class, use the keyword `class`.

In this example, we create a class named "`Main`" with a variable `x`:

Main.java

```java
public class Main {
  int x = 5;
}
```

Remember from the [Java Syntax chapter](https://www.w3schools.com/java/java_syntax.asp) that a class should always start with an uppercase first letter, and that the name of the java file should match the class name.

---

## Create an Object

In Java, an object is created from a class. We have already created the class named `Main`, so now we can use this to create objects.

To create an object of `Main`, specify the class name, followed by the object name, and use the keyword `new`:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

Create an object called "`myObj`" and print the value of x:

```java
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj.x);
  }
}
 
```

---

---

## Multiple Objects

You can create multiple objects of one class:

### Example

Create two objects of `Main`:

```java
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj1 = new Main();  // Object 1
    Main myObj2 = new Main();  // Object 2
    System.out.println(myObj1.x);
    System.out.println(myObj2.x);
  }
}
 
 
```

---

## Using Multiple Classes

You can also create an object of a class and access it in another class. This is often used for better organization of classes (one class has all the attributes and methods, while the other class holds the `main()` method (code to be executed)).

Remember that the name of the java file should match the class name. In this example, we have created two files in the same directory/folder:

- Main.java
- Second.java

Main.java

```java
public class Main {
  int x = 5;
}
```

Second.java

```java
class Second {
  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj.x);
  }
}
```

When both files have been compiled:

C:\Users\_Your Name_>javac Main.java  
C:\Users\_Your Name_>javac Second.java

Run the Second.java file:

C:\Users\_Your Name_>java Second

And the output will be:

`5`

You will learn much more about classes and objects in the next chapters.

# Java Class Attributes

---

## Java Class Attributes

In the previous chapter, we used the term "**variable**" for `x` in the example (as shown below).

In Java, variables declared inside a class are called "**attributes**".

You can also say that attributes are variables that belong to a class:

Create a class called "`Main`" with two attributes: `x` and `y`:

```java
public class Main {
  int x = 5;
  int y = 3;
}
```

Another name for attributes is **fields**.

---

## Accessing Attributes

You can access attributes by creating an object of the class, and by using the dot syntax (`.`):

The following example will create an object of the `Main` class, with the name `myObj`. We use the `x` attribute on the object to print its value:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

Create an object called "`myObj`" and print the value of `x`:

```java
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println(myObj.x);
  }
}
 
 
```

---

## Modify Attributes

You can also modify attribute values:

### Example

Set the value of `x` to 40:

```java
public class Main {
  int x;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 40;
    System.out.println(myObj.x);
  }
}
 
```

Or override existing values:

### Example

Change the value of `x` to 25:

```java
public class Main {
  int x = 10;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 25; // x is now 25
    System.out.println(myObj.x);
  }
}
 
```

If you don't want the ability to override existing values, declare the attribute as `final`:

### Example

```java
public class Main {
  final int x = 10;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 25; // will generate an error: cannot assign a value to a final variable
    System.out.println(myObj.x);
  }
}
 
```

The `final` keyword is useful when you want a variable to always store the same value, like PI (3.14159...).

The `final` keyword is called a "modifier". You will learn more about these in the [Java Modifiers Chapter](https://www.w3schools.com/java/java_modifiers.asp).

---

---

## Multiple Objects

If you create multiple objects of one class, you can change the attribute values in one object, without affecting the attribute values in the other:

### Example

Change the value of `x` to 25 in `myObj2`, and leave `x` in `myObj1` unchanged:

```java
public class Main {
  int x = 5;

  public static void main(String[] args) {
    Main myObj1 = new Main();  // Object 1
    Main myObj2 = new Main();  // Object 2
    myObj2.x = 25;
    System.out.println(myObj1.x);  // Outputs 5
    System.out.println(myObj2.x);  // Outputs 25
  }
}
```

---

## Multiple Attributes

You can specify as many attributes as you want:

### Example

```java
public class Main {
  String fname = "John";
  String lname = "Doe";
  int age = 24;

  public static void main(String[] args) {
    Main myObj = new Main();
    System.out.println("Name: " + myObj.fname + " " + myObj.lname);
    System.out.println("Age: " + myObj.age);
  }
}
```

The next chapter will teach you how to create class methods and how to access them with objects.

# Java Class Methods

---

## Java Class Methods

You learned from the [Java Methods](https://www.w3schools.com/java/java_methods.asp) chapter that methods are declared within a class, and that they are used to perform certain actions:

Create a method named `myMethod()` in Main:

```java
public class Main {
  static void myMethod() {
    System.out.println("Hello World!");
  }
}
 
```

`myMethod()` prints a text (the action), when it is **called**. To call a method, write the method's name followed by two parentheses **()** and a semicolon**;**

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

Inside `main`, call `myMethod()`:

```java
public class Main {
  static void myMethod() {
    System.out.println("Hello World!");
  }

  public static void main(String[] args) {
    myMethod();
  }
}

// Outputs "Hello World!"
 
```

---

## Access Methods With an Object

### Example

Create a Car object named `myCar`. Call the `fullThrottle()` and `speed()` methods on the `myCar` object, and run the program:

```java
// Create a Main class
public class Main {
 
  // Create a fullThrottle() method
  public void fullThrottle() {
    System.out.println("The car is going as fast as it can!");
  }

  // Create a speed() method and add a parameter
  public void speed(int maxSpeed) {
    System.out.println("Max speed is: " + maxSpeed);
  }

  // Inside main, call the methods on the myCar object
  public static void main(String[] args) {
    Main myCar = new Main();   // Create a myCar object
    myCar.fullThrottle();      // Call the fullThrottle() method
    myCar.speed(200);          // Call the speed() method
  }
}

// The car is going as fast as it can!
// Max speed is: 200
```

### Example explained

1) We created a custom `Main` class with the `class` keyword.

2) We created the `fullThrottle()` and `speed()` methods in the `Main` class.

3) The `fullThrottle()` method and the `speed()` method will print out some text, when they are called.

4) The `speed()` method accepts an `int` parameter called `maxSpeed` - we will use this in **8)**.

5) In order to use the `Main` class and its methods, we need to create an **object** of the `Main` Class.

6) Then, go to the `main()` method, which you know by now is a built-in Java method that runs your program (any code inside main is executed).

7) By using the `new` keyword we created an object with the name `myCar`.

8) Then, we call the `fullThrottle()` and `speed()` methods on the `myCar` object, and run the program using the name of the object (`myCar`), followed by a dot (`.`), followed by the name of the method (`fullThrottle();` and `speed(200);`). Notice that we add an `int` parameter of **200** inside the `speed()` method.

### Remember that..

The dot (`.`) is used to access the object's attributes and methods.

To call a method in Java, write the method name followed by a set of parentheses **()**, followed by a semicolon (`;`).

A class must have a matching filename (`Main` and **Main.java**).

---

---

## Using Multiple Classes

Like we specified in the [Classes chapter](https://www.w3schools.com/java/java_classes.asp), it is a good practice to create an object of a class and access it in another class.

Remember that the name of the java file should match the class name. In this example, we have created two files in the same directory:

- Main.java
- Second.java

Main.java

Second.java

```java
public class Main {
  public void fullThrottle() {
    System.out.println("The car is going as fast as it can!");
  }

  public void speed(int maxSpeed) {
    System.out.println("Max speed is: " + maxSpeed);
  }
}
```

When both files have been compiled:

C:\Users\_Your Name_>javac Main.java  
C:\Users\_Your Name_>javac Second.java

Run the Second.java file:

C:\Users\_Your Name_>java Second

And the output will be:

`The car is going as fast as it can!   Max speed is: 200`

# Java Constructors

---

## Java Constructors

A constructor in Java is a **special method** that is used to initialize objects.

The constructor is called when an object of a class is created.

It can be used to set initial values for object attributes:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

Create a constructor:

```java
// Create a Main class
public class Main {
  int x;  // Create a class attribute

  // Create a class constructor for the Main class
  public Main() {
    x = 5;  // Set the initial value for the class attribute x
  }

  public static void main(String[] args) {
    Main myObj = new Main(); // Create an object of class Main (This will call the constructor)
    System.out.println(myObj.x); // Print the value of x
  }
}

// Outputs 5
 
```

Note that the constructor name must **match the class name**, and it cannot have a **return type** (like `void`).

Also note that the constructor is called when the object is created.

All classes have constructors by default: if you do not create a class constructor yourself, Java creates one for you. However, then you are not able to set initial values for object attributes.

---

---

## Constructor Parameters

Constructors can also take parameters, which is used to initialize attributes.

The following example adds an `int y` parameter to the constructor. Inside the constructor we set x to y (x=y). When we call the constructor, we pass a parameter to the constructor (5), which will set the value of x to 5:

### Example

```java
public class Main {
  int x;

  public Main(int y) {
    x = y;
  }

  public static void main(String[] args) {
    Main myObj = new Main(5);
    System.out.println(myObj.x);
  }
}

// Outputs 5
 
```

You can have as many parameters as you want:

### Example

```java
public class Main {
  int modelYear;
  String modelName;

  public Main(int year, String name) {
    modelYear = year;
    modelName = name;
  }

  public static void main(String[] args) {
    Main myCar = new Main(1969, "Mustang");
    System.out.println(myCar.modelYear + " " + myCar.modelName);
  }
}

// Outputs 1969 Mustang
 
```

# Java this

---

## Java this Keyword

The `this` keyword in Java refers to the current object in a method or constructor.

The `this` keyword is often used to avoid confusion when class attributes have the same name as method or constructor parameters.

---

## Accessing Class Attributes

Sometimes a constructor or method has a parameter with the same name as a class variable. When this happens, the parameter temporarily **hides** the class variable inside that method or constructor.

To refer to the class variable and not the parameter, you can use the `this` keyword:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
public class Main {
  int x;  // Class variable x

  // Constructor with one parameter x
  public Main(int x) {
    this.x = x; // refers to the class variable x
  
```

Output:

`Value of x = 5`

**Tip:** Think of `this.x = x;` as: "`this.x` (the class variable) gets the value of `x` (the parameter)."

Without `this`, the code above `x = x;` would set the parameter `x` equal to itself, and the class variable would stay uninitialized (`0`).

---

## Calling a Constructor from Another Constructor

You can also use `this()` to call another constructor in the same class.

This is useful when you want to provide default values or reuse initialization code instead of repeating it.

### Example

```java
public class Main {
  int modelYear;
  String modelName;

  // Constructor with one parameter
  public Main(String modelName) {
    // Call the two-parameter constructor to reuse code and set a default year    
    this(2020, modelName);
  }

  // Constructor with two parameters
  public Main(int modelYear, String modelName) {
    // Use 'this' to assign values to the class variables
    this.modelYear = modelYear;
    this.modelName = modelName;
  }

  // Method to print car information
  public void printInfo() {
    System.out.println(modelYear + " " + modelName);
  }

  public static void main(String[] args) {
    // Create a car with only model name (uses default year)
    Main car1 = new Main("Corvette");

    // Create a car with both model year and name
    Main car2 = new Main(1969, "Mustang");

    car1.printInfo();
    car2.printInfo();
  }
}
```

Output:

`2020 Corvette   1969 Mustang`

**Note:** The call to `this()` must be the **first statement** inside the constructor.

---

---

## When to use this?

- When a constructor or method has a parameter with the same name as a class variable, use `this` to update the class variable correctly.
- To call another constructor in the same class and reuse code.

# Java Modifiers

---

## Modifiers

By now, you are quite familiar with the `public` keyword that appears in almost all of our examples:

```java
public class Main
```

The `public` keyword is an **access modifier**, meaning that it is used to set the access level for classes, attributes, methods and constructors.

We divide modifiers into two groups:

- **Access Modifiers** - controls the access level
- **[Non-Access Modifiers](https://www.w3schools.com/java/java_non_modifiers.asp)** - do not control access level, but provides other functionality

---

## Access Modifiers

For **classes**, you can use either `public` or _default_:

|Modifier|Description|Try it|
|---|---|---|
|`public`|The class is accessible by any other class||
|_default_|The class is only accessible by classes in the same package. This is used when you don't specify a modifier. You will learn more about packages in the [Packages chapter](https://www.w3schools.com/java/java_packages.asp)||

For **attributes, methods and constructors**, you can use the one of the following:

|Modifier|Description|Try it|
|---|---|---|
|`public`|The code is accessible for all classes||
|`private`|The code is only accessible within the declared class||
|_default_|The code is only accessible in the same package. This is used when you don't specify a modifier. You will learn more about packages in the [Packages chapter](https://www.w3schools.com/java/java_packages.asp)||
|`protected`|The code is accessible in the same package and **subclasses**. You will learn more about subclasses and superclasses in the [Inheritance chapter](https://www.w3schools.com/java/java_inheritance.asp)||

---

---

## Public vs. Private Example

In the example below, the class has one `public` attribute and one `private` attribute.

Think of it like real life:

- `public` - a public park, everyone can enter
- `private` - your house key, only you can use it

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
class Person {
  public String name = "John";   // Public - accessible everywhere
  private int age = 30;          // Private - only accessible inside this class
}

public class Main {
  public static void main(String[] args) {
    Person p = new Person();
    System.out.println(p.name);   // Works fine
    System.out.println(p.age);    // Error: age has private access in Person
  }
}
```

### Example explained

Here, `name` is declared as `public`, so it can be accessed from outside the `Person` class. But `age` is declared as `private`, so it can only be used inside the `Person` class.

# Java Non-Access Modifiers

---

## Non-Access Modifiers

Non-access modifiers do not control visibility (like `public` or `private`), but instead add **other features** to classes, methods, and attributes.

The most commonly used non-access modifiers are `final`, `static`, and `abstract`.

---

## Final

If you don't want the ability to override existing attribute values, declare attributes as `final`:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
public class Main {
  final int x = 10;
  final double PI = 3.14;

  public static void main(String[] args) {
    Main myObj = new Main();
    myObj.x = 50; // will generate an error: cannot assign a value to a final variable
    myObj.PI = 25; // will generate an error: cannot assign a value to a final variable
    System.out.println(myObj.x);
  }
}
 
 
```

---

## Static

A `static` method belongs to the class, not to any specific object. This means you can call it without creating an object of the class.

### Example

A simple example showing how to call a `static` method directly:

```java
public class Main {
  // Static method
  static void myStaticMethod() {
    System.out.println("Static methods can be called without creating objects");
  }

  // Main method
  public static void main(String[] args) {
    myStaticMethod();         // Call the static method
    Main.myStaticMethod();    // Or call it using the class name
  }
}
 
 
 
```

**Note:** A `static` method belongs to the class itself. You can call it without creating an object, but it cannot use variables or methods that belong to an object.

---

---

## Abstract

An `abstract` method belongs to an `abstract` class, and it does not have a body. The body is provided by the subclass:

Main.java

Second.java

```java
// abstract classabstract class Main {
  public String fname = "John";
  public int age = 24;
  public abstract void study(); // abstract method
}

// Subclass (inherit from Main)
class Student extends Main {
  public int graduationYear = 2018;
  public void study() { // the body of the abstract method is provided here
    System.out.println("Studying all day long");
  }
}
 
 
 
```

---

## Non-Access Modifiers List

For **classes**, you can use either `final` or `abstract`:

|Modifier|Description|Try it|
|---|---|---|
|`final`|The class cannot be inherited by other classes (You will learn more about inheritance in the [Inheritance chapter](https://www.w3schools.com/java/java_inheritance.asp))||
|`abstract`|The class cannot be used to create objects (To access an abstract class, it must be inherited from another class. You will learn more about inheritance and abstraction in the [Inheritance](https://www.w3schools.com/java/java_inheritance.asp) and [Abstraction](https://www.w3schools.com/java/java_abstract.asp) chapters)||

For **attributes and methods**, you can use the one of the following:

|Modifier|Description|
|---|---|
|`final`|Attributes and methods cannot be overridden/modified|
|`static`|Attributes and methods belong to the class, not to objects. This means all objects share the same `static` attribute, and `static` methods can be called without creating objects.|
|`abstract`|Can only be used in an abstract class, and can only be used on methods. The method does not have a body, for example `abstract void run();`. The body is provided by the subclass (inherited from). You will learn more about inheritance and abstraction in the [Inheritance](https://www.w3schools.com/java/java_inheritance.asp) and [Abstraction](https://www.w3schools.com/java/java_abstract.asp) chapters|
|`transient`|Attributes and methods are skipped when serializing the object containing them|
|`synchronized`|Methods can only be accessed by one thread at a time|
|`volatile`|The value of an attribute is not cached thread-locally, and is always read from the "main memory"|

# Java Encapsulation

---

## Encapsulation

The meaning of **Encapsulation**, is to make sure that "sensitive" data is hidden from users. To achieve this, you must:

- declare class variables/attributes as `private`
- provide public **get** and **set** methods to access and update the value of a `private` variable

---

## Get and Set

You learned from the previous chapter that `private` variables can only be accessed within the same class (an outside class has no access to it). However, it is possible to access them if we provide public **get** and **set** methods.

The `get` method returns the variable value, and the `set` method sets the value.

Syntax for both is that they start with either `get` or `set`, followed by the name of the variable, with the first letter in upper case:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
public class Person {
  private String name; // private = restricted access

  // Getter
  public String getName() {
    return name;
  }

  // Setter
  public void setName(String newName) {
    this.name = newName;
  }
}
 
 
```

#### Example explained

The `get` method returns the value of the variable `name`.

The `set` method takes a parameter (`newName`) and assigns it to the `name` variable. The `this` keyword is used to refer to the current object.

However, as the `name` variable is declared as `private`, we **cannot** access it from outside this class:

### Example

```java
public class Main {
  public static void main(String[] args) {
    Person myObj = new Person();
    myObj.name = "John";  // error
    System.out.println(myObj.name); // error 
  }
}
```

If the variable was declared as `public`, we would expect the following output:

`John`

However, as we try to access a `private` variable, we get an error:

`MyClass.java:4: error: name has private access in Person       myObj.name = "John";            ^   MyClass.java:5: error: name has private access in Person       System.out.println(myObj.name);                     ^   2 errors`

Instead, we use the `getName()` and `setName()` methods to access and update the variable:

### Example

```java
public class Main {
  public static void main(String[] args) {
    Person myObj = new Person();
    myObj.setName("John"); // Set the value of the name variable to "John"
    System.out.println(myObj.getName());
  }
}

// Outputs "John"
 
 
```

---

---

## Why Encapsulation?

- Better control of class attributes and methods
- Class attributes can be made **read-only** (if you only use the `get` method), or **write-only** (if you only use the `set` method)
- Flexible: the programmer can change one part of the code without affecting other parts
- Increased security of data

# Use Case Diagram | UML (Unified Modeling Language)

Last Updated : 17 Mar 2025

A use case diagram is used to represent the dynamic behavior of a system. It encapsulates the system's functionality by incorporating use cases, actors, and their relationships. It models the tasks, services, and functions required by a system/subsystem of an application. It depicts the high-level functionality of a system and also tells how the user handles a system.

## Purpose of Use Case Diagrams

The main purpose of a use case diagram is to portray the dynamic aspect of a system. It accumulates the system's requirement, which includes both internal as well as external influences. It invokes persons, use cases, and several things that invoke the actors and elements accountable for the implementation of use case diagrams. It represents how an entity from the external environment can interact with a part of the system.

Following are the purposes of a use case diagram given below:

1. It gathers the system's needs.
2. It depicts the external view of the system.
3. It recognizes the internal as well as external factors that influence the system.
4. It represents the interaction between the actors.

## How to draw a Use Case diagram?

It is essential to analyze the whole system before starting with drawing a use case diagram, and then the system's functionalities are found. And once every single functionality is identified, they are then transformed into the use cases to be used in the use case diagram.

After that, we will enlist the actors that will interact with the system. The actors are the person or a thing that invokes the functionality of a system. It may be a system or a private entity, such that it requires an entity to be pertinent to the functionalities of the system to which it is going to interact.

Once both the actors and use cases are enlisted, the relation between the actor and use case/ system is inspected. It identifies the no of times an actor communicates with the system. Basically, an actor can interact multiple times with a use case or system at a particular instance of time.

Following are some rules that must be followed while drawing a use case diagram:

1. A pertinent and meaningful name should be assigned to the actor or a use case of a system.
2. The communication of an actor with a use case must be defined in an understandable way.
3. Specified notations to be used as and when required.
4. The most significant interactions should be represented among the multiple no of interactions between the use case and actors.

## Example of a Use Case Diagram

A use case diagram depicting the Online Shopping website is given below.

Here the Web Customer actor makes use of any online shopping website to purchase online. The top-level uses are as follows; View Items, Make Purchase, Checkout, Client Register. The **View Items** use case is utilized by the customer who searches and view products. The **Client Register** use case allows the customer to register itself with the website for availing gift vouchers, coupons, or getting a private sale invitation. It is to be noted that the **Checkout** is an included use case, which is part of **Making Purchase,** and it is not available by itself.

![[Pasted image 20260210134335.png]]

The **View Items** is further extended by several use cases such as; Search Items, Browse Items, View Recommended Items, Add to Shopping Cart, Add to Wish list. All of these extended use cases provide some functions to customers, which allows them to search for an item. The View Items is further extended by several use cases such as; Search Items, Browse Items, View Recommended Items, Add to Shopping Cart, Add to Wish list. All of these extended use cases provide some functions to customers, which allows them to search for an item.

Both **View Recommended Item** and **Add to Wish List** include the Customer Authentication use case, as they necessitate authenticated customers, and simultaneously item can be added to the shopping cart without any user authentication.

![[Pasted image 20260210134349.png]]

Similarly, the **Checkout** use case also includes the following use cases, as shown below. It requires an authenticated Web Customer, which can be done by login page, user authentication cookie ("Remember me"), or Single Sign-On (SSO). SSO needs an external identity provider's participation, while Web site authentication service is utilized in all these use cases.

The Checkout use case involves Payment use case that can be done either by the credit card and external credit payment services or with PayPal.

![[Pasted image 20260210134359.png]]

## Important tips for drawing a Use Case diagram

Following are some important tips that are to be kept in mind while drawing a use case diagram:

1. A simple and complete use case diagram should be articulated.
2. A use case diagram should represent the most significant interaction among the multiple interactions.
3. At least one module of a system should be represented by the use case diagram.
4. If the use case diagram is large and more complex, then it should be drawn more generalized.

# Modularization in Software Engineering

[

![Caitlin Jee](https://miro.medium.com/v2/da:true/resize:fill:32:32/0*9cRzyRKzD2-5OtHU)





](https://medium.com/@caitlinjeespn?source=post_page---byline--1af52807ceed---------------------------------------)

[Caitlin Jee](https://medium.com/@caitlinjeespn?source=post_page---byline--1af52807ceed---------------------------------------)

Follow

5 min read

·

Oct 10, 2021

66

6

[](https://medium.com/m/signin?actionUrl=https%3A%2F%2Fmedium.com%2F_%2Fbookmark%2Fp%2F1af52807ceed&operation=register&redirect=https%3A%2F%2Fmedium.com%2F%40caitlinjeespn%2Fmodularization-in-software-engineering-1af52807ceed&source=---header_actions--1af52807ceed---------------------bookmark_footer------------------)

[

](https://medium.com/m/signin?actionUrl=https%3A%2F%2Fmedium.com%2Fplans%3Fdimension%3Dpost_audio_button%26postId%3D1af52807ceed&operation=register&redirect=https%3A%2F%2Fmedium.com%2F%40caitlinjeespn%2Fmodularization-in-software-engineering-1af52807ceed&source=---header_actions--1af52807ceed---------------------post_audio_button------------------)

Press enter or click to view image in full size

![](https://miro.medium.com/v2/resize:fit:700/0*xVBQsJ5BGwUEVLTg)

Photo by [Markus Spiske](https://unsplash.com/@markusspiske?utm_source=medium&utm_medium=referral) on [Unsplash](https://unsplash.com/?utm_source=medium&utm_medium=referral)

One year ago, when a friend and I were working on one of our first software engineering projects, we wrote the whole program in one singular file. There was no separation, no modularization, only one file with 2000+ lines of code. That inevitably led to countless merge conflicts, and changing one part of the code would almost always affect another part. We would often be changing a lot of old code just to add a new function.

In short, working on it was a headache.

## What is modularization?

Press enter or click to view image in full size

![[Pasted image 20260210134442.png]]

Modularization diagram, from [infanion](https://www.infanion.com/news-blogs/modular-programming-increased-value-our-customers)

In this current age of software, you would be hard-pressed to find a program that isn't continuously growing and evolving. Designing a program all at once, with all required functions, would be difficult due to its size, complexity and constant changes. This is where modularization comes in.

> Modularization is the process of separating the functionality of a program into independent, interchangeable modules, such that each contains everything necessary to execute only one aspect of the desired functionality.

Press enter or click to view image in full size

![[Pasted image 20260210134457.png]]

Monolith vs modular program, from [janeve](https://www.janeve.me/software-programming/modular-programming-in-java)

With modularization, we can easily work on adding separate and smaller modules to a program without being hindered by the complexity of its other functions. In short, it’s about being flexible and fast in adding more software functions to a program. In a software engineering team, we could easily work independently on each module without affecting others’ work.

It is the backbone of the microservice architecture, whose basic idea is also the simplicity of developing applications that are easier to extend and maintain when disassembled into small and independent parts. On the other hand, in monolithic architecture, there’s always the risk of bringing down the whole program with a simple update.

![[Pasted image 20260210134510.png]]

Microservices and modularity, from [thecustomizedwindows](https://thecustomizewindows.com/2020/12/what-is-modular-programming/)

Without modularization, this will lead to an increase in development time, the number of bugs and the duration it takes to test and release a program.

Press enter or click to view image in full size

![[Pasted image 20260210134517.png]]

Monolithic vs modular software, from [modularmanagement](https://www.modularmanagement.com/blog/software-modularity)

## Benefits of modularization

Why should we be decomposing our projects into modules? As shown in my experience with a single-file program, programs without proper modularization would be a nightmare to maintain and extend.

In modularization, the modules have minimal dependency on other modules. So, we can easily make changes in a module without affecting other parts of the program.

The following are just the gist of how modularization would improve the development process for a program.

- Easier to add and maintain smaller components
- Easier to understand each module and their purpose
- Easier to reuse and refactor modules
- Better abstraction between modules
- Saves time needed to develop, debug, test and deploy a program

## How should we decompose modules?

A module should have only a single responsibility, that is the [Single Responsibility Principle](https://en.wikipedia.org/wiki/Single-responsibility_principle). Thus, it should depend minimally on other modules. The independence of a module can be measured using coupling and cohesion.

> Coupling: Coupling is the measure of the degree of interdependence between the modules. A good software will have low coupling.
> 
> Cohesion: Cohesion is a measure of the degree to which the elements of the module are functionally related. It is the degree to which all elements directed towards performing a single task are contained in the component. Basically, cohesion is the internal glue that keeps the module together. A good software design will have high cohesion.

![[Pasted image 20260210134530.png]]

Cohesion and coupling, from [geeksforgeeks](https://www.geeksforgeeks.org/effective-modular-design-in-software-engineering/)

![[Pasted image 20260210134539.png]]

Module coupling, with (c) being what we want to avoid, from [javatpoint](https://www.javatpoint.com/software-engineering-coupling-and-cohesion)

Each module should have a clear and focused purpose, such that its developers have a clear idea of the requirement for each function. Its interface should be easy to understand and use, even without understanding its implementation details. Thus, leading into our next point, is that its implementation details, while not only correct, should be encapsulated and private, and that it should be changeable without affecting another module. Furthermore, the dependency between modules should be minimised.

## Example: Modularization on a text-to-speech application

Consider a text-to-speech application that will translate a user’s input text into speech and read it out loud. It should be able to:

- Parse a user’s input text
- Use a selected computer’s voice to read out the text
- Have a controllers that can speed up or slow down the computer’s speech if the user chooses

We can apply modularization to this application and decompose it to the following modules:

- Text-to-speech: Parses the user’s text to be read out loud
- Computer voice: Stores and provides computer voices that the user can choose
- Text speech controller: Controls that speed of the speech that the user chooses

Press enter or click to view image in full size

![[Pasted image 20260210134549.png]]

How we can decompose the monolithic text-to-speech application into separate modules

Rather than designing the application as one giant monolith, it can instead be broken down into modules, each specific for one software function. Thus, the developers can develop each module in parallel, saving development time.

## Get Caitlin Jee’s stories in your inbox

Join Medium for free to get updates from this writer.

Subscribe

Additionally, the text-to-speech and computer voice modules can be used for other applications, for example a voice navigation application.

Press enter or click to view image in full size

![[Pasted image 20260210134559.png]]

How we can reuse the text-to-speech and computer voice modules for a voice navigation application

Therefore, the benefits of designing the text-to-speech application using modularization is that each module is responsible for its own independant function, which makes it easier to develop, test and maintain. Plus, they can be reused in other applications.

## Conclusion

To sum it up, modularization is essential while working in a software engineering team, maximizing developer productivity. The complexity of a program can easily scale exponentially as it grows, which is the crux of developer productivity.

Modularization helps us break down large, complex systems into small and manageable components. Without it, it would be difficult to handle any but the smallest programs.

The power of modularization lies in its ability in allowing code to remain flexible when facing ever-changing requirements. Thus, we should always decompose our programs into modules so that we can fully enjoy the benefits of modularization.