---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: Data Structures & Types
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - w3schools - Arraylist
  - w3schools - Linkedlist
  - w3schools - Hashmap
  - Geeksforgeeks - Util Vector Class
  - Geekforgeeks - Stack Class
  - Geekforgeeks - Priority Queue Class
Created: 16-02-2026
---
- - -
  # Table of Contents

1. [[#Java ArrayList|Java ArrayList]]
	1. [[#Java ArrayList#Java ArrayList|Java ArrayList]]
	2. [[#Java ArrayList#Create an ArrayList|Create an ArrayList]]
		1. [[#Create an ArrayList#Example|Example]]
	3. [[#Java ArrayList#Add Elements|Add Elements]]
		1. [[#Add Elements#Example|Example]]
		2. [[#Add Elements#Example|Example]]
	4. [[#Java ArrayList#Access an Element|Access an Element]]
		1. [[#Access an Element#Example|Example]]
	5. [[#Java ArrayList#Change an Element|Change an Element]]
		1. [[#Change an Element#Example|Example]]
	6. [[#Java ArrayList#Remove an Element|Remove an Element]]
		1. [[#Remove an Element#Example|Example]]
		2. [[#Remove an Element#Example|Example]]
	7. [[#Java ArrayList#ArrayList Size|ArrayList Size]]
		1. [[#ArrayList Size#Example|Example]]
	8. [[#Java ArrayList#Loop Through an ArrayList|Loop Through an ArrayList]]
		1. [[#Loop Through an ArrayList#Example|Example]]
		2. [[#Loop Through an ArrayList#Example|Example]]
	9. [[#Java ArrayList#Other Types|Other Types]]
		1. [[#Other Types#Example|Example]]
	10. [[#Java ArrayList#Sort an ArrayList|Sort an ArrayList]]
		1. [[#Sort an ArrayList#Example|Example]]
		2. [[#Sort an ArrayList#Example|Example]]
	11. [[#Java ArrayList#The var Keyword|The var Keyword]]
		1. [[#The var Keyword#Example|Example]]
	12. [[#Java ArrayList#The List Interface|The List Interface]]
	13. [[#Java ArrayList#Complete ArrayList Reference|Complete ArrayList Reference]]
2. [[#Java LinkedList|Java LinkedList]]
	1. [[#Java LinkedList#Java LinkedList|Java LinkedList]]
		1. [[#Java LinkedList#Example|Example]]
	2. [[#Java LinkedList#ArrayList vs. LinkedList|ArrayList vs. LinkedList]]
		1. [[#ArrayList vs. LinkedList#How the ArrayList works|How the ArrayList works]]
		2. [[#ArrayList vs. LinkedList#How the LinkedList works|How the LinkedList works]]
		3. [[#ArrayList vs. LinkedList#When To Use|When To Use]]
	3. [[#Java LinkedList#LinkedList Methods|LinkedList Methods]]
	4. [[#Java LinkedList#The var Keyword|The var Keyword]]
		1. [[#The var Keyword#Example|Example]]
	5. [[#Java LinkedList#The List Interface|The List Interface]]
	6. [[#Java LinkedList#Complete LinkedList Reference|Complete LinkedList Reference]]
3. [[#Java HashMap|Java HashMap]]
	1. [[#Java HashMap#Java HashMap|Java HashMap]]
	2. [[#Java HashMap#Create a HashMap|Create a HashMap]]
		1. [[#Create a HashMap#Example|Example]]
	3. [[#Java HashMap#Add Items|Add Items]]
		1. [[#Add Items#Example|Example]]
	4. [[#Java HashMap#Access an Item|Access an Item]]
		1. [[#Access an Item#Example|Example]]
	5. [[#Java HashMap#Remove an Item|Remove an Item]]
		1. [[#Remove an Item#Example|Example]]
		2. [[#Remove an Item#Example|Example]]
	6. [[#Java HashMap#HashMap Size|HashMap Size]]
		1. [[#HashMap Size#Example|Example]]
	7. [[#Java HashMap#Loop Through a HashMap|Loop Through a HashMap]]
		1. [[#Loop Through a HashMap#Example|Example]]
		2. [[#Loop Through a HashMap#Example|Example]]
		3. [[#Loop Through a HashMap#Example|Example]]
	8. [[#Java HashMap#Other Types|Other Types]]
		1. [[#Other Types#Example|Example]]
	9. [[#Java HashMap#When Order Matters|When Order Matters]]
	10. [[#Java HashMap#The var Keyword|The var Keyword]]
		1. [[#The var Keyword#Example|Example]]
	11. [[#Java HashMap#The Map Interface|The Map Interface]]
	12. [[#Java HashMap#Complete HashMap Reference|Complete HashMap Reference]]
4. [[#Vector Class in Java|Vector Class in Java]]
	1. [[#Vector Class in Java#Hierarchy of Vector|Hierarchy of Vector]]
	2. [[#Vector Class in Java#Constructors of Vector|Constructors of Vector]]
		1. [[#Constructors of Vector#1. Vector()|1. Vector()]]
		2. [[#Constructors of Vector#2. Vector(int initialCapacity)|2. Vector(int initialCapacity)]]
		3. [[#Constructors of Vector#3. Vector(int initialCapacity, int capacityIncrement)|3. Vector(int initialCapacity, int capacityIncrement)]]
		4. [[#Constructors of Vector#4. Vector(Collection c)|4. Vector(Collection c)]]
		5. [[#Constructors of Vector#Vector Capacity in Java|Vector Capacity in Java]]
	3. [[#Vector Class in Java#Different Operations of Vector Class|Different Operations of Vector Class]]
		1. [[#Different Operations of Vector Class#1. Adding Elements|1. Adding Elements]]
		2. [[#Different Operations of Vector Class#2. Updating Elements|2. Updating Elements]]
		3. [[#Different Operations of Vector Class#3. Removing Elements|3. Removing Elements]]
		4. [[#Different Operations of Vector Class#4. Iterating the Vector|4. Iterating the Vector]]
	4. [[#Vector Class in Java#Methods of Vector Class|Methods of Vector Class]]
5. [[#Stack Class in Java|Stack Class in Java]]
		1. [[#Methods of Vector Class#Hierarchy of Stack class|Hierarchy of Stack class]]
	1. [[#Stack Class in Java#Constructors of Stack in Java|Constructors of Stack in Java]]
		1. [[#Constructors of Stack in Java#1. Stack()|1. Stack()]]
		2. [[#Constructors of Stack in Java#2. Stack(int initialCapacity)|2. Stack(int initialCapacity)]]
	2. [[#Stack Class in Java#Performing Different Operations on Stack Class|Performing Different Operations on Stack Class]]
		1. [[#Performing Different Operations on Stack Class#1. Adding Elements|1. Adding Elements]]
		2. [[#Performing Different Operations on Stack Class#2. Accessing the Element|2. Accessing the Element]]
		3. [[#Performing Different Operations on Stack Class#3. Removing Elements|3. Removing Elements]]
		4. [[#Performing Different Operations on Stack Class#Prioritize Use of ****Deque**** over Stack|Prioritize Use of ****Deque**** over Stack]]
	3. [[#Stack Class in Java#****Methods in Stack Class****|****Methods in Stack Class****]]
	4. [[#Stack Class in Java#Methods Inherited from the Vector Class|Methods Inherited from the Vector Class]]
6. [[#PriorityQueue in Java|PriorityQueue in Java]]
		1. [[#Methods Inherited from the Vector Class#Declaration of PriorityQueue|Declaration of PriorityQueue]]
	1. [[#PriorityQueue in Java#Hierarchy of PriorityQueue|Hierarchy of PriorityQueue]]
	2. [[#PriorityQueue in Java#Constructors of PriorityQueue|Constructors of PriorityQueue]]
		1. [[#Constructors of PriorityQueue#1. PriorityQueue()|1. PriorityQueue()]]
		2. [[#Constructors of PriorityQueue#2. PriorityQueue(int initialCapacity)|2. PriorityQueue(int initialCapacity)]]
		3. [[#Constructors of PriorityQueue#3. PriorityQueue(Comparator<E> comparator)|3. PriorityQueue(Comparator<E> comparator)]]
		4. [[#Constructors of PriorityQueue#4. PriorityQueue(int initialCapacity, Comparator<E> comparator)|4. PriorityQueue(int initialCapacity, Comparator<E> comparator)]]
	3. [[#PriorityQueue in Java#Different Operations on PriorityQueue|Different Operations on PriorityQueue]]
		1. [[#Different Operations on PriorityQueue#****1. Adding Elements****|****1. Adding Elements****]]
		2. [[#Different Operations on PriorityQueue#2. Removing Elements|2. Removing Elements]]
		3. [[#Different Operations on PriorityQueue#****3. Accessing the Elements****|****3. Accessing the Elements****]]
		4. [[#Different Operations on PriorityQueue#****4. Iterating the PriorityQueue****|****4. Iterating the PriorityQueue****]]
	4. [[#PriorityQueue in Java#Methods of PriorityQueue|Methods of PriorityQueue]]
	5. [[#PriorityQueue in Java#Methods Declared in Interface java.util.Queue|Methods Declared in Interface java.util.Queue]]
	6. [[#PriorityQueue in Java#Methods Declared in Class java.util.AbstractQueue|Methods Declared in Class java.util.AbstractQueue]]
	7. [[#PriorityQueue in Java#Methods Declared in Class java.util.AbstractCollection|Methods Declared in Class java.util.AbstractCollection]]
	8. [[#PriorityQueue in Java#Methods Declared in Interface java.util.Collection|Methods Declared in Interface java.util.Collection]]
		1. [[#Methods Declared in Interface java.util.Collection#Applications of PriorityQueue|Applications of PriorityQueue]]

  wrapper classes:
  Lower case number types, such as int, double, float, byte are raw numbers expressed as integer (of some word length), IEEE 754 standard, byte (or word of length 8 bit) • Those can be handled just as raw numbers, and are exchanged by value • Capital case number types, such as Int, Double, Float, Byte, are Classes that carry the value of an integer, double, float or byte, adding some more methods, e.g. • parseInt(String S) – takes a string S and returns an int (if possible) • longValue() – returns the integer as a long • rotateLeft(int i, int distance) – rotate the bits to the left • These are called wrapper class objects and are object forms of primitives (or simple values) that adds object semantics
  
  Normally we just use basic data types as intended, such as byte, long etc. • byte a = 35; • double y =1.245; • But sometimes we need to take an input from the keyboard, using e.g. Scanner, and we then need to convert it into some special data type • Or we need to be able to handle the data type as an object
  We can use the wrapper class object instance as if they were basic data types, e.g. • Integer x = 5; Double y = 1.234; • Printing is just as easy • System.out.println(x); • System.out.println(”Y has the value ”+y); • It is also doable to access the value via proper methods • System.out.println(x.intValue()); • System.out.println(y.doubleValue());
  ut the real strength is in most other related methods e.g. toString() • Double x =1.234; String strX = x.toString(); • Or the other way around, if we have a string and need the data • double f = Double.parseFloat(strX); • In C we would have had to locate an appropriate function, but here we get the method with the wrapper data type that we wish to use • int y = Integer.parseInt(strX); • byte b = Byte.parseByte(strX); • In many cases, we even have more options than just to pass a string, which are suitable for the appropriate data type • If something fails, an exception is thrown (more about this later)
  
  Notice, double is default in Java, so if we wish to use float (lower precision), then, in Test2, we must cast 2.766 to float, e.g. • float f2 = (float) 2.766;
  
  ```java
  public class Test{
	  public static void main (String[] args){
		  Integer myInt = 5; 
		  Double myDouble = 5.99; 
		  Character myChar = 'A’; 
		  System.out.println(myInt); 
		  System.out.println(myDouble); 
		  System.out.println(myChar);
	  }
  }
  ```
  
  ```java
  public class Test2 {
	  public static void main(String[] args){
		  String str = "1.234"; 
		  double f = Double.parseDouble(str); 
		  System.out.println("Double is "+f); 
		  Double f2 = 2.766; double f3 = f+f2; System.out.println("Result is "+f3);
	  }
  }
  ```
  
  Wrapper classes example:
  ```java
  package lecture4;
  
  public class Temperature {
  
	  public Temperature(double vaulue) {
		  this.value = value;
	  }
	  public double getValue() {
		  return value;
	  }
	  public double toFahrenheit() {
		  return value * 9/5 + 32;
	  }
	  public double toKelvin() {
		  return value + 273.15;
	  }
	  
	  @Override
	  public String toStrung() {
		  return value + " Deg C";
	  }
  }
  ```
  ![[Pasted image 20260221150017.png]]
# Java ArrayList

## Java ArrayList

An `ArrayList` is like a resizable array.
The difference between a built-in array and an `ArrayList` in Java, is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one). While elements can be added and removed from an `ArrayList` whenever you want.


As in imperative languages we have a whole range of different data types here 
• Arrays 
• Double arrays 
• Strings 
• Linked lists 
• Stack 
• Queue 
• Hashtable 
• And many more

For simple data types, arrays are defined and used very simply
```java
nt[] priceOfPen= new int[5]; 
priceOfPen[3]=5;
```
![[Pasted image 20260221150920.png]]
For complex (or just our own classes) we need to initialise these manually. The array itself is initialized bot the objects inside it do not yet exist
![[Pasted image 20260221150936.png]]
![[Pasted image 20260221150931.png]]

ARRAY EXAMPLE CODE
If we just print cars then we get the object reference • Yes, even an array is an object • The array class have several attributes, e.g. length, which indicates how many elements exists • This is very useful for going through the array
```java
public class ArrayTests { 
	public static void main(String[] args){ 
		String[] cars = {"Volvo", "BMW", "Ford", "Mazda"}; 
		System.out.println(cars); for (int i=0; i<cars.length;i++){
			System.out.println("Car "+i+” "+cars[i]);
		}
	}
}
```

MULTI-DIMENSIONAL ARRAYS
Multi-dimensional arrays can be formed as simply array(s) of array(s) • This is quite useful in many situations • Matrices • Storing data as a tabular form • Data with fast access • Maps • Jagged arrays • Arrays of arrays • Each row can have a different size • Flexible (can model irregular data) • Saves (potentially) memory
![[Pasted image 20260221151221.png]]
We can also initialize the arrays if needed • Notice, that each element myNumbers[x] is also an array object • Same concept for higher dimension arrays
```java
public class ArrayTest2 { 
	public static void main(String[] args) { 
		int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} }; 
		for (int i = 0; i < myNumbers.length; ++i) { 
			for(int j = 0; j < myNumbers[i].length; ++j) { 
				System.out.println(myNumbers[i][j]); 
			} 
		} 
	} 
}
```
![[Pasted image 20260221151412.png]]

Basically, ArrayList is a resizable array with some additional features • It implements interface List, which allows us to use stuff like • Collection.sort(myList) • Collections.sort(myList, Collections.reverseOrder()); • given that myList implements a List interface, e.g. is an ArrayList • It requires importing of the feature • import java.util.ArrayList;
![[Pasted image 20260221151430.png]]

ARRAYLIST (LIST) EXAMPLE
Here is a small example on how to use ArrayList • Notice how we loop through the list • ArrayList is extremely versatile as it can be dynamically resized as needed • Methods are provided to add and remove array items, which makes this data type very flexible and easy to operate with
```java
package lecture4;

import java.util.ArrayList;

public cclass ArrayListExample {
	public static void main(Sting[] args){
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo")
		cars.add("BMW")
		cars.add("Ford")
		cars.add("Mazda")
		
		for (String i : cars) {
			system.out.println(i);
		}
	}
}
```
![[Pasted image 20260221151734.png]]
## Create an ArrayList
To use an `ArrayList`, you must first import it from `java.util`:
### Example
Create an `ArrayList` object called **cars** that will store strings:

```java
import java.util.ArrayList; // Import the ArrayList class

ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object
```

## Add Elements

To add elements to an `ArrayList`, use the `add()` method:

### Example

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
  }
}
```

You can also add an element at a specified position by referring to the index number:

### Example

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");

    cars.add(0, "Mazda"); // Insert element at the beginning of the list (0)

    System.out.println(cars);
  }
}
```

An `ArrayList` keeps elements in the same order you add them, so the first item you add will be at index 0, the next at index 1, and so on.

## Access an Element

To access an element in the `ArrayList`, use the `get()` method and refer to the index number
### Example

```java
cars.get(0);  // Get the first element
```

## Change an Element

To modify an element, use the `set()` method and refer to the index number

### Example

```java
cars.set(0, "Opel");
```

## Remove an Element

To remove an element, use the `remove()` method and refer to the index number

### Example

```java
cars.remove(0);
```

To remove all the elements in the `ArrayList`, use the `clear()` method

### Example

```java
cars.clear();
```

## ArrayList Size

To find out how many elements an `ArrayList` have, use the `size` method

### Example

```java
cars.size();
```

## Loop Through an ArrayList

Loop through the elements of an `ArrayList` with a `for` loop, and use the `size()` method to specify how many times the loop should run:

### Example

```java
public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.get(i));
    }
  }
}
```

You can also loop through an `ArrayList` with the **for-each** loop:

### Example

```java
public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    for (String i : cars) {
      System.out.println(i);
    }
  }
}
```

---

## Other Types

Elements in an `ArrayList` are actually objects. In the examples above, we created elements (objects) of type "String". Remember that a `String` in Java is an object (not a primitive type). To use other types, such as `int`, you must specify an equivalent wrapper class: `Integer`. For other primitive types, use: `Boolean` for boolean, `Character` for char, `Double` for double, etc:

### Example

Create an `ArrayList` to store numbers (add elements of type `Integer`):

```java
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    myNumbers.add(10);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(25);
    for (int i : myNumbers) {
      System.out.println(i);
    }
  }
}
```

---

## Sort an ArrayList

Another useful class in the `java.util` package is the `Collections` class, which include the `sort()` method for sorting lists alphabetically or numerically:

### Example

Sort an ArrayList of Strings:

```java
import java.util.ArrayList;
import java.util.Collections;  // Import the Collections class

public class Main {
  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    Collections.sort(cars);  // Sort cars
    for (String i : cars) {
      System.out.println(i);
    }
  }
}
```

### Example

Sort an ArrayList of Integers:

```java
import java.util.ArrayList;
import java.util.Collections;  // Import the Collections class

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> myNumbers = new ArrayList<Integer>();
    myNumbers.add(33);
    myNumbers.add(15);
    myNumbers.add(20);
    myNumbers.add(34);
    myNumbers.add(8);
    myNumbers.add(12);

    Collections.sort(myNumbers);  // Sort myNumbers

    for (int i : myNumbers) {
      System.out.println(i);
    }
  }
}
```

---

## The var Keyword

From Java 10, you can use the `var` keyword to declare an `ArrayList` variable without writing the type twice. The compiler figures out the type from the value you assign.

This makes code shorter, **but many developers still use the full type for clarity**. Since `var` is valid Java, you may see it in other code, so it's good to know that it exists:

### Example

```java
// Without var
ArrayList<String> cars = new ArrayList<String>();

// With var
var cars = new ArrayList<String>();
```

---

## The List Interface

**Note:** Sometimes you will see both `List` and `ArrayList` in Java code, like this:

```java
import java.util.List;
import java.util.ArrayList;

List<String> cars = new ArrayList<>();
```

This means the variable (cars) is declared as a `List` (the interface), but it stores an `ArrayList` object (the actual list). Since `ArrayList` implements the `List` interface, this is possible.

It works the same way, but some developers prefer this style because it gives them more flexibility to change the type later.

## Complete ArrayList Reference


# Java LinkedList
## Java LinkedList

In the previous chapter, you learned about the `ArrayList` class. The `LinkedList` class is almost identical to the `ArrayList`

Another structure is the LinkedList, where we do not need to write code to use linked lists
We still need to think complexity when using this datatype – the code behind the class is not magically efficient • Difference btw. LinkedList and ArrayList? • Efficiency between insert, delete and random-access operations • ArrayList is based on a contiguous memory approach

```java
LinkedList cars = new LinkedList(); 
cars.add("Volvo"); 
cars.add("BMW"); 
cars.add("Ford
```
![[Pasted image 20260221152014.png]]
![[Pasted image 20260221152019.png]]
### Example
```java
// Import the LinkedList class
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) {
    LinkedList<String> cars = new LinkedList<String>();
    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
  }
}
```

## ArrayList vs. LinkedList

The `LinkedList` class is a collection which can contain many objects of the same type, just like the `ArrayList`.

The `LinkedList` class has the same methods as `ArrayList` because both follow the `List` interface. This means you can add, change, remove, or clear elements in a `LinkedList` just like you would with an `ArrayList`.

However, while the `ArrayList` class and the `LinkedList` class can be used in the same way, they are built very differently.

### How the ArrayList works

The `ArrayList` class has a regular array inside it. When an element is added, it is placed into the array. If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.

### How the LinkedList works

The `LinkedList` stores its elements in "containers." The list has a link to the first container and each container has a link to the next container in the list. To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.

### When To Use

Use an `ArrayList` for storing and accessing data, and `LinkedList` to manipulate data.

---

---

## LinkedList Methods

For many cases, the `ArrayList` is more efficient as it is common to need access to random elements in the list, but the `LinkedList` provides several methods to do certain operations more efficiently:

|Method|Description|Try it|
|---|---|---|
|`addFirst()`|Adds an element to the beginning of the list||
|`addLast()`|Add an element to the end of the list||
|`removeFirst()`|Remove an element from the beginning of the list||
|`removeLast()`|Remove an element from the end of the list||
|`getFirst()`|Get the element at the beginning of the list||
|`getLast()`|Get the element at the end of the list||

---

## The var Keyword

From Java 10, you can use the `var` keyword to declare a `LinkedList` variable without writing the type twice. The compiler figures out the type from the value you assign.

This makes code shorter, **but many developers still use the full type for clarity**. Since `var` is valid Java, you may see it in other code, so it's good to know that it exists:

### Example

```java
// Without var
LinkedList<String> cars = new LinkedList<String>();

// With var
var cars = new LinkedList<String>();
```

---

## The List Interface

**Note:** Sometimes you will see both `List` and `LinkedList` in Java code, like this:

```java
import java.util.List;
import java.util.LinkedList;

List<String> cars = new LinkedList<>();
```

This means the variable (cars) is declared as a `List` (the interface), but it stores a `LinkedList` object (the actual list). Since `LinkedList` implements the `List` interface, this is possible.

It works the same way, but some developers prefer this style because it gives them more flexibility to change the type later.


## Complete LinkedList Reference


# Java HashMap
## Java HashMap

A `HashMap` stores items in **key/value pairs**, where each key maps to a specific value.

It is part of the `java.util` package and implements the `Map` interface.

Instead of accessing elements by an index (like with ArrayList, you use a **key** to retrieve its associated **value**.

A `HashMap` can store many different combinations, such as:

- `String` keys and `Integer` values
- `String` keys and `String` values
  
  Hashtables offers efficient access to data • Index is the hash value of the key • The hash can be calculated in many ways e.g. index = key mod noOfStorageElements • Other types also exists, e.g. • Hashmap • LinkedHashMap • ConcurrentHashMap • HashSet

```java
Hashtable hm = new Hashtable(); 
hm.put(1, "Geeks"); 
hm.put(12, "forGeeks"); 
hm.put(15, "A computer"); 
hm.put(3, "Portal"); 
Integer n = numbers.get(“forGeeks");
```
![[Pasted image 20260221152234.png]]

HASHMAP EXAMPEL
Printing the object prints all pairs • If we do not find an object with a key, we get a null • A very common source of errors!! • *.get(“Denmark”) returns Null

```java
import java.util.HashMap; 

public class TestHashMap { 
	public static void main(String[] args) { 
		HashMap capitalCities = new HashMap(); 
		capitalCities.put("England", "London"); 
		capitalCities.put("Germany", "Berlin"); 
		capitalCities.put("Norway", "Oslo"); 
		capitalCities.put("USA", "Washington DC"); 
		System.out.println(capitalCities); 
		System.out.println(capitalCities.get("England")); 
		System.out.println(capitalCities.get("Denmark")); 
	} 
}
```
![[Pasted image 20260221152348.png]]

*.get(“Denmark”) returns Null • The key is not present in the map → normal situation, but you need to handle it • The key is present, but the value stored is in fact null → this is allowed! • You cannot tell these two cases apart by simply checking get()
``

---

## Create a HashMap

Create a `HashMap` object called `capitalCities` that will store `String` keys and `String` values:

### Example
```java
import java.util.HashMap; // Import the HashMap class

HashMap<String, String> capitalCities = new HashMap<>();
```

Now you can use methods like `put()` to add key/value pairs, `get()` to retrieve a value by key, and `remove()` to delete an entry - all by using keys instead of index numbers.

---

## Add Items

To add items to a `HashMap`, use the `put()` method:

### Example

```java
// Import the HashMap class
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    // Create a HashMap object called capitalCities
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    // Add keys and values (Country, City)
    capitalCities.put("England", "London");
    capitalCities.put("India", "New Dehli");
    capitalCities.put("Austria", "Wien");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("Norway", "Oslo"); // Duplicate
    capitalCities.put("USA", "Washington DC");

    System.out.println(capitalCities);
  }
}
```

**Note:** In the example above, if the same key (like "Norway") is added more than once, the _latest_ value will overwrite the previous one, because keys in a `HashMap` must be unique.

---

## Access an Item

To access a value in the `HashMap`, use the `get()` method and refer to its key:

### Example

```java
capitalCities.get("England");
```

---

## Remove an Item

To remove an item, use the `remove()` method and refer to the key:

### Example

```java
capitalCities.remove("England");
```

To remove all items, use the `clear()` method:

### Example

```java
capitalCities.clear();
```

---

---

## HashMap Size

To find out how many items there are, use the `size()` method:

### Example

```java
capitalCities.size();
```

**Note:** The size only counts unique keys. If a key is added more than once, only the latest value is kept.

---

## Loop Through a HashMap

Loop through the items of a `HashMap` with a **for-each** loop.

**Note:** Use the `keySet()` method if you only want the keys, and use the `values()` method if you only want the values:

### Example

```java
// Print keys
for (String i : capitalCities.keySet()) {
  System.out.println(i);
}
```

### Example

```java
// Print values
for (String i : capitalCities.values()) {
  System.out.println(i);
}
```

### Example

```java
// Print keys and values
for (String i : capitalCities.keySet()) {
  System.out.println("key: " + i + " value: " + capitalCities.get(i));
}
```

---

## Other Types

Keys and values in a `HashMap` are actually objects. In the examples above, we used objects of type "String". Remember that a `String` in Java is an object (not a primitive type). To use other types, such as `int`, you must specify an equivalent wrapper class: `Integer`. For other primitive types, use: `Boolean` for boolean, `Character` for char, `Double` for double, etc:

### Example

Create a `HashMap` object called **people** that will store `String` **keys** and `Integer` **values**:

```java
// Import the HashMap class
import java.util.HashMap;

public class Main {
  public static void main(String[] args) {

    // Create a HashMap object called people
    HashMap<String, Integer> people = new HashMap<String, Integer>();

    // Add keys and values (Name, Age)
    people.put("John", 32);
    people.put("Steve", 30);
    people.put("Angie", 33);

    for (String i : people.keySet()) {
      System.out.println("key: " + i + " value: " + people.get(i));
    }
  }
}
```

---

## When Order Matters

In the next chapter, you will learn about `TreeMap`, which stores key/value pairs **in sorted order by key**.

---

## The var Keyword

From Java 10, you can use the `var` keyword to declare a `HashMap` variable without writing the type twice. The compiler figures out the type from the value you assign.

This makes code shorter, **but many developers still use the full type for clarity**. Since `var` is valid Java, you may see it in other code, so it's good to know that it exists:

### Example

```java
// Without var
HashMap<String, String> capitalCities = new HashMap<String, String>();

// With var
var capitalCities = new HashMap<String, String>();
```

---

## The Map Interface

**Note:** Sometimes you will see both `Map` and `HashMap` in Java code, like this:

```java
import java.util.Map;
import java.util.HashMap;

Map<String, String> capitalCities = new HashMap<>();
```

This means the variable (capitalCities) is declared as a `Map` (the interface), but it stores a `HashMap` object (the actual map). Since `HashMap` implements the `Map` interface, this is possible.

It works the same way, but some developers prefer this style because it gives them more flexibility to change the type later.

---

## Complete HashMap Reference

# Vector Class in Java
In Java, a Vector is a dynamic array that can grow or shrink in size as elements are added or removed. It is part of the java.util package and extends the AbstractList class.

- Maintains insertion order and allows duplicate and null values.
- Dynamically grows its size when capacity is exceeded.
- Implements List, RandomAccess, Cloneable, and Serializable interfaces.
- Vector is a Legacy class that was introduced in early versions of Java.
- Thread-safe: All methods are synchronized for safe multi-threaded access.
- [ArrayList](https://www.geeksforgeeks.org/java/arraylist-in-java/) is preferred over vector in general when in-built thread synchronization is not required..

import java.util.Vector;

A Vector is a flexible array, very similar to ArrayList, as both are dynamic, indexbased, resizable arrays that implement the List interface • It is a legacy class – but unlike ArrayList it is synchronized • It has some additional methods not available in ArrayList • However, is also a bit legacy

```java
Vector v = new Vector(); 
Vector v = new 
Vector(int size); 
Vector v = new 
Vector(int size, int incr); 
Vector v = new Vector(Collection c);
```
```java
Vector v = new Vector(n); 
v.add(7); 
v.add(9); 
v.add(23); 
v.ad(4); 
v.remove(1); 
System.out.println(“Vector: “+v);
```
![[Pasted image 20260221151925.png]]
​

public class GFG{

    public static void main(String[] args){

        Vector<String> v = new Vector<>();

        v.add("A");

        v.add("B");

        v.add("C");

        System.out.println(v);

    }

}

  
**Output**

[A, B, C]

## Hierarchy of Vector

It implements the [List interface](https://www.geeksforgeeks.org/java/list-interface-java-examples/), which is a sub-interface of the Collection interface.

![interface](https://media.geeksforgeeks.org/wp-content/uploads/20251024145432189362/interface.webp "Click to enlarge")

## Constructors of Vector

In order to create a Vector, we need to create an object of the Vector class. The Vector class provides various constructors to create a vector in different ways.

### 1. Vector()

Creates an empty vector with a default initial capacity of 10.

> Vector<Integer> vector = new Vector<>();

### 2. Vector(int initialCapacity)

Creates a vector with the specified initial capacity.

> Vector<Integer> vector = new Vector<>(20);

### 3. Vector(int initialCapacity, int capacityIncrement)

Creates a vector with a specified initial capacity and capacity increment (amount by which the vector grows when full).

> Vector<Integer> vector = new Vector<>(10, 5);

### 4. Vector(Collection c)

Creates a vector containing all elements of the specified collection.

> Vector<Integer> vector = new Vector<>(collection);

### Vector Capacity in Java

When a Vector is created using the default constructor, it is initialized with a default capacity of 10. This means it can hold up to 10 elements before needing to grow in size. If the number of elements exceeds the current capacity, the Vector automatically increases its capacity.

> Vector<String> vec = new Vector<>();
> 
> System.out.println("Default Capacity: " + vec.capacity()); // Output: 10

****Formula to calculate new capacity****

> newCapacity = oldCapacity * 2

import java.util.Vector;

​

public class VectorDoublingExample {

    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>(2); // initial capacity = 2

        System.out.println("Initial capacity: " + vector.capacity());

​

        // Add elements to trigger capacity increase

        vector.add(10);

        vector.add(20);

        System.out.println("Capacity after adding 2 elements: " + vector.capacity());

​

        vector.add(30); // Triggers resize (2 → 4)

        System.out.println("Capacity after adding 3rd element: " + vector.capacity());

​

        vector.add(40);

        vector.add(50); // Triggers resize again (4 → 8)

        System.out.println("Capacity after adding 5 elements: " + vector.capacity());

    }

}

  
**Output**

Initial capacity: 2
Capacity after adding 2 elements: 2
Capacity after adding 3rd element: 4
Capacity after adding 5 elements: 8

## Different Operations of Vector Class

### 1. Adding Elements

To add the elements to the Vector, we use the [add()](https://www.geeksforgeeks.org/java/vector-add-method-in-java/) method. This method is overloaded to perform multiple operations based on different parameters. They are listed below as follows:

- ****add(Object)****: This method is used to add an element at the end of the Vector.
- ****add(int index, Object):**** This method is used to add an element at a specific index in the Vector.

import java.io.*;

import java.util.*;

​

class Geeks {

    public static void main(String[] arg)

    {

        // Creating a default vector

        Vector v1 = new Vector();

​

        // Adding custom elements using add() method

        v1.add(1);

        v1.add(2);

        v1.add("geeks");

        v1.add("forGeeks");

        v1.add(3);

​

        System.out.println("Vector v1 is " + v1);

​

        // Creating generic vector

        Vector<Integer> v2 = new Vector<Integer>();

​

        // Adding custom elements using add() method

        v2.add(1);

        v2.add(2);

        v2.add(3);

        System.out.println("Vector v2 is " + v2);

    }

}

  
**Output**

Vector v1 is [1, 2, geeks, forGeeks, 3]
Vector v2 is [1, 2, 3]

### 2. Updating Elements

To update an element in a Vector, use the set() method. It takes the index and the new element to replace the existing one at that position.

import java.util.*; 

​

public class Geeks { 

    public static void main(String args[]) 

    { 

        // Creating an empty Vector 

        Vector<Integer> v = new Vector<Integer>(); 

​

        // Use add() method to add elements in the vector 

        v.add(12); 

        v.add(23); 

        v.add(22); 

        v.add(10); 

        v.add(20); 

​

        // Displaying the Vector 

        System.out.println("Vector: " + v); 

​

        // Using set() method to replace 12 with 21 

        System.out.println("The Object that is replaced is: "

                        + v.set(0, 21)); 

​

        // Using set() method to replace 20 with 50 

        System.out.println("The Object that is replaced is: "

                        + v.set(4, 50)); 

​

        System.out.println("The new Vector is:" + v); 

    } 

}

  
**Output**

Vector: [12, 23, 22, 10, 20]
The Object that is replaced is: 12
The Object that is replaced is: 20
The new Vector is:[21, 23, 22, 10, 50]

### 3. Removing Elements

To remove an element from a Vector, we can use the [remove()](https://www.geeksforgeeks.org/java/vector-remove-method-in-java/) method. This method is overloaded to perform multiple operations based on different parameters. They are:

- ****remove(Object):**** Removes the first occurrence of the specified object.
- ****remove(int index):**** Removes the element at the given index and shifts remaining elements to the left.

import java.util.*;

import java.io.*;

​

class Geeks {

    public static void main(String[] arg)

    {

        // Create default vector of capacity 10

        Vector v = new Vector();

​

        // Add elements using add() method

        v.add(1);

        v.add(2);

        v.add("Geeks");

        v.add("forGeeks");

        v.add(4);

​

        // Removing first occurrence element at 1

        v.remove(1);

​

        System.out.println("After removal: " + v);

    }

}

  
**Output**

After removal: [1, Geeks, forGeeks, 4]

### 4. Iterating the Vector

There are multiple ways to iterate through the Vector. The most famous ways are by using the basic for loop in combination with a [get()](https://www.geeksforgeeks.org/java/vector-get-method-in-java/) method to get the element at a specific index and the [advanced for a loop](https://www.geeksforgeeks.org/java/for-each-loop-in-java/).

import java.util.*;

​

public class Geeks {

​

    public static void main(String args[])

    {

        // create an instance of vector

        Vector<String> v = new Vector<>();

​

        // Add elements using add() method

        v.add("Geeks");

        v.add("Geeks");

        v.add(1, "For");

​

        // Using the Get method and the for loop

        for (int i = 0; i < v.size(); i++) {

​

            System.out.print(v.get(i) + " ");

        }

​

        System.out.println();

​

        for (String str : v)

            System.out.print(str + " ");

    }

}

  
**Output**

Geeks For Geeks 
Geeks For Geeks 

> ****Note:**** Please read to the [ArrayList vs Vector class in Java](https://www.geeksforgeeks.org/java/vector-vs-arraylist-java/) to grasp it better.

## Methods of Vector Class

|Method|Description|
|---|---|
|[add(E e)](https://www.geeksforgeeks.org/java/vector-add-method-in-java/)|Appends the specified element to the end of this Vector.|
|[add(int index, E element)](https://www.geeksforgeeks.org/java/vector-add-method-in-java/)|Inserts the specified element at the specified position in this Vector.|
|[addAll(Collection<?](https://www.geeksforgeeks.org/java/vector-addall-method-in-java/)<br><br>[extends E> c)](https://www.geeksforgeeks.org/java/vector-addall-method-in-java/)|Appends all elements from the given collection to the end of this Vector.|
|[addAll(int index,](https://www.geeksforgeeks.org/java/vector-addall-method-in-java/)<br><br>[Collection<? extends E> c)](https://www.geeksforgeeks.org/java/vector-addall-method-in-java/)|Insert all of the elements in the specified Collection into this Vector at the specified position.|
|[addElement(E obj)](https://www.geeksforgeeks.org/java/vector-addelement-method-in-java/)|Adds the specified element to the end, increasing size by one.|
|[capacity()](https://www.geeksforgeeks.org/java/vector-capacity-method-in-java/)|Returns the current capacity of this vector.|
|[clear()](https://www.geeksforgeeks.org/java/vector-clear-method-in-java/)|Removes all of the elements from this Vector.|
|[clone()](https://www.geeksforgeeks.org/java/vector-clone-method-in-java-with-examples/)|Returns a clone of this vector.|
|[contains(Object o)](https://www.geeksforgeeks.org/java/vector-contains-method-in-java/)|Returns true if this vector contains the specified element.|
|[containsAll(Collection<?> c)](https://www.geeksforgeeks.org/java/vector-containsall-method-in-java/)|Returns true if this Vector contains all of the elements in the specified Collection.|
|[copyInto(Object[] anArray)](https://www.geeksforgeeks.org/java/vector-copyinto-method-in-java/)|Copies the components of this vector into the specified array.|
|[elementAt(int index)](https://www.geeksforgeeks.org/java/vector-elementat-method-in-java/)|Returns the component at the specified index.|
|[elements()](https://www.geeksforgeeks.org/java/vector-elements-method-in-java/)|Returns an enumeration of the components of this vector.|
|[ensureCapacity(int minCapacity)](https://www.geeksforgeeks.org/java/arraylist-ensurecapacity-method-in-java-with-examples/)|Increases capacity to ensure it can hold at least the specified number of elements.|
|[equals(Object o)](https://www.geeksforgeeks.org/java/vector-equals-method-in-java/)|Compares the specified Object with this Vector for equality.|
|[firstElement()](https://www.geeksforgeeks.org/java/vector-firstelement-method-in-java/)|Returns the first component (the item at index 0) of this vector.|
|[forEach(Consumer<?](https://www.geeksforgeeks.org/java/vector-foreach-method-in-java/)<br><br>[super E> action)](https://www.geeksforgeeks.org/java/vector-foreach-method-in-java/)|Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.|
|[get(int index)](https://www.geeksforgeeks.org/java/vector-get-method-in-java/)|Returns the element at the specified position in this Vector.|
|[hashCode()](https://www.geeksforgeeks.org/java/vector-hashcode-method-in-java/)|Returns the hash code value for this Vector.|
|[indexOf(Object o)](https://www.geeksforgeeks.org/java/vector-indexof-method-in-java/#:~:text=)|Returns index of the first occurrence of the element or -1 if not found.|
|[indexOf(Object o, int index)](https://www.geeksforgeeks.org/java/vector-indexof-method-in-java/#:~:text=)|Returns index of the first occurrence starting from the given index.|
|[insertElementAt(E obj, int index)](https://www.geeksforgeeks.org/java/vector-insertelementat-method-in-java-with-examples/)|Inserts the specified object as a component in this vector at the specified index.|
|[isEmpty()](https://www.geeksforgeeks.org/java/vector-isempty-method-in-java/)|Tests if this vector has no components.|
|[iterator()](https://www.geeksforgeeks.org/java/vector-iterator-method-in-java-with-examples/)|Returns an iterator over the elements in this list in a proper sequence.|
|[lastElement()](https://www.geeksforgeeks.org/java/vector-lastelement-method-in-java/)|Returns the last component of the vector.|
|[lastIndexOf(Object o)](https://www.geeksforgeeks.org/java/vector-lastindexof-method-in-java/)|Returns the index of the last occurrence of the element or -1 if not found.|
|[lastIndexOf(Object o, int index)](https://www.geeksforgeeks.org/java/vector-lastindexof-method-in-java/)|Returns index of the last occurrence before the given index.|
|[listIterator()](https://www.geeksforgeeks.org/java/vector-listiterator-method-in-java-with-examples/)|Returns a list iterator over the elements in this list (in proper sequence).|
|[listIterator(int index)](https://www.geeksforgeeks.org/java/vector-listiterator-method-in-java-with-examples/)|Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.|
|[remove(int index)](https://www.geeksforgeeks.org/java/vector-remove-method-in-java/)|Removes the element at the specified position in this Vector.|
|[remove(Object o)](https://www.geeksforgeeks.org/java/vector-remove-method-in-java/)|Removes the first occurrence of the specified element.|
|[removeAll(Collection<?> c)](https://www.geeksforgeeks.org/java/vector-removeall-method-in-java/)|Removes from this Vector all of its elements contained in the specified Collection.|
|[removeAllElements()](https://www.geeksforgeeks.org/java/vector-removeallelements-method-in-java-with-example/)|Removes all components from this vector and sets its size to zero.|
|[removeElement(Object obj)](https://www.geeksforgeeks.org/java/vector-removeelement-method-in-java-with-example/)|Removes the first (lowest-indexed) occurrence of the argument from this vector.|
|[removeElementAt(int index)](https://www.geeksforgeeks.org/java/vector-removeelementat-method-in-java/)|Deletes the component at the specified index.|
|[removeIf(Predicate<? super E> filter)](https://www.geeksforgeeks.org/java/vector-removeif-method-in-java/)|Removes all of the elements of this collection that satisfy the given predicate.|
|[removeRange(int fromIndex,](https://www.geeksforgeeks.org/java/vector-removerange-method-in-java-with-example/)<br><br>[int toIndex)](https://www.geeksforgeeks.org/java/vector-removerange-method-in-java-with-example/)|Removes from this list all of the elements whose index is between fromIndex, inclusive and toIndex, exclusive.|
|replaceAll(UnaryOperator<E> operator)|Replaces each element of this list with the result of applying the operator to that element.|
|[retainAll(Collection<?> c)](https://www.geeksforgeeks.org/java/vector-retainall-method-in-java-with-examples/)|Retains only the elements in this Vector contained in the specified Collection.|
|[set(int index, E element)](https://www.geeksforgeeks.org/java/vector-set-method-in-java/#:~:text=set\(\)%20method%20is%20used,Vector%20class%2C%20with%20another%20element.&text=)|Replaces the element at the specified position in this Vector with the specified element.|
|[setElementAt(E obj, int index)](https://www.geeksforgeeks.org/java/vector-setelementat-method-in-java-with-example/)|Sets the component at the specified index of this vector to be the specified object.|
|[setSize(int newSize)](https://www.geeksforgeeks.org/java/vector-setsize-method-in-java-with-example/)|Sets the size of this vector.|
|[size()](https://www.geeksforgeeks.org/java/vector-size-method-in-java/)|Returns the number of components in this vector.|
|[sort(Comparator<? super E> c)](https://www.geeksforgeeks.org/java/collections-sort-java-examples/)|Sorts this list according to the order induced by the specified Comparator.|
|[spliterator()](https://www.geeksforgeeks.org/java/arraylist-spliterator-method-in-java/)|Creates a late-binding and fail-fast Spliterator over the elements in this list.|
|[subList(int fromIndex, int toIndex)](https://www.geeksforgeeks.org/java/vector-sublist-method-in-java/)|Returns a view of the portion of this List between fromIndex, inclusive and toIndex, exclusive.|
|[toArray()](https://www.geeksforgeeks.org/java/vector-toarray-method-in-java-with-examples/)|Returns an array containing all of the elements in this Vector in the correct order.|
|[toArray(T[] a)](https://www.geeksforgeeks.org/java/vector-toarray-method-in-java-with-examples/)|Returns an array containing all the elements.|
|[toString()](https://www.geeksforgeeks.org/java/vector-tostring-method-in-java-with-example/)|Returns a string representation of this Vector, containing the String representation of each element.|
|[trimToSize()](https://www.geeksforgeeks.org/java/vector-trimtosize-method-in-java-with-example/)|Trims the capacity of this vector to be the vector's current size.|




# Stack Class in Java
In Java, a Stack is a linear data structure that follows the Last In First Out (LIFO) principle and is defined in the [java.util](https://www.geeksforgeeks.org/java/java-util-package-java/) package. Internally, it extends the Vector class.

A stack is a linear and simple data structure that follows the LIFO principle • Last In, First Out (LIFO) • When to use this data type? • Whenever you have a case where you want to have a LIFO type of interaction, then you may need a stack • Shines for problems where backtracking, reversal or nesting structure handling are needed • The ctrl-z is a good example

```java
Stack stack = new Stack(); stack.push("4"); stack.push("All"); while(!stack.isEmpty()) { System.out.println(stack.pop()); }
```

![[Pasted image 20260221152057.png]]

- Stack class maintains insertion order and allows duplicates and null values.
- Grows dynamically when its capacity is exceeded.
- All the methods of Stack are synchronized. It is thread-safe.
- Stack is considered a legacy class, introduced in early versions of Java and a preferred solution to implement Stack Data Structure (especially when thread synchronization is not needed) is either to use [ArrayDeque](https://www.geeksforgeeks.org/java/arraydeque-in-java/) or [LinkedList](https://www.geeksforgeeks.org/java/linked-list-in-java/)
- Stack class implements List, RandomAccess, Cloneable, and Serializable interfaces.

import java.util.Stack;

​

public class Geeks {

    public static void main(String[] args)

    {

        // Create a new stack

        Stack<Integer> s = new Stack<>();

​

        // Push elements onto the stack

        s.push(1);

        s.push(2);

        s.push(3);

        s.push(4);

​

        // Pop elements from the stack

        while (!s.isEmpty()) {

            System.out.println(s.pop());

        }

    }

}

  
**Output**

4
3
2
1

****Explanation:****

- Elements are added to the stack using the push() method, placing each item on top.
- A loop runs while the stack is not empty, checked using the empty() method.
- Elements are removed and printed using the pop() method in LIFO order.

### Hierarchy of Stack class

The below diagram shows the hierarchy of the Stack class: 

![Stack Class in Java](https://media.geeksforgeeks.org/wp-content/uploads/Selection_028.png "Click to enlarge")

## Constructors of Stack in Java

In order to create a Stack, we need to create an object of the Stack class. The Stack class inherits constructors from the Vector class.

### 1. Stack()

This constructor is used to create an empty stack.

> Stack<Integer> stack = new Stack<>()

### 2. Stack(int initialCapacity)

This constructor is used to create a stack with a specified initial capacity.

> Stack<Integer> stack = new Stack<>(20);

## Performing Different Operations on Stack Class

### 1. Adding Elements

With the help of [push()](https://www.geeksforgeeks.org/java/stack-push-method-in-java/) method we can add element to the stack. The push() method place the element at the top of the stack.

import java.io.*;

import java.util.*;

​

class Geeks {

​

    public static void main(String[] args)

    {

        // Default initialization of Stack

        Stack stack1 = new Stack();

​

        // Initialization of Stack using Generics

        Stack<String> stack2 = new Stack<String>();

​

        // pushing the elements

        stack1.push("4");

        stack1.push("All");

        stack1.push("Geeks");

​

        stack2.push("Geeks");

        stack2.push("For");

        stack2.push("Geeks");

​

        // Printing the Stack Elements

        System.out.println(stack1);

        System.out.println(stack2);

    }

}

  
**Output**

[4, All, Geeks]
[Geeks, For, Geeks]

### 2. Accessing the Element

With the help of [peek()](https://www.geeksforgeeks.org/java/stream-peek-method-in-java-with-examples/) method we can fetch the top element of the stack. 

import java.io.*;

import java.util.*;

​

public class Geeks {

​

    public static void main(String args[])

    {

        // Creating an empty Stack

        Stack<String> stack = new Stack<String>();

​

        // Use push() to add elements into the Stack

        stack.push("Welcome");

        stack.push("To");

        stack.push("Geeks");

        stack.push("For");

        stack.push("Geeks");

​

        // Displaying the Stack

        System.out.println("Initial Stack: " + stack);

​

        // Fetching the element at the head of the Stack

        System.out.println("The element at the top of the"

                           + " stack is: " + stack.peek());

​

        System.out.println("Final Stack: " + stack);

    }

}

  
**Output**

Initial Stack: [Welcome, To, Geeks, For, Geeks]
The element at the top of the stack is: Geeks
Final Stack: [Welcome, To, Geeks, For, Geeks]

### 3. Removing Elements

With the help of [pop()](https://www.geeksforgeeks.org/java/stack-pop-method-in-java/) method we can delete and return the top element from the stack.

import java.io.*;

import java.util.*;

​

public class Geeks {

    public static void main(String args[])

    {

        // Creating an empty Stack

        Stack<Integer> stack = new Stack<Integer>();

​

        // Use add() method to add elements

        stack.push(10);

        stack.push(15);

        stack.push(30);

        stack.push(20);

        stack.push(5);

​

        System.out.println("Initial Stack: " + stack);

​

        // Removing elements using pop() method

        System.out.println("Popped element: "

                           + stack.pop());

        System.out.println("Popped element: "

                           + stack.pop());

​

        // Displaying the Stack after pop operation

        System.out.println("Stack after pop operation "

                           + stack);

​

        System.out.println("Is stack empty? "

                           + stack.empty());

        // Pop remaining elements

        stack.pop();

        stack.pop();

        stack.pop();

​

        // Check if the stack is empty

        System.out.println("Is stack empty? "

                           + stack.empty());

    }

}

  
**Output**

Initial Stack: [10, 15, 30, 20, 5]
Popped element: 5
Popped element: 20
Stack after pop operation [10, 15, 30]
Is stack empty? false
Is stack empty? true

### Prioritize Use of ****Deque**** over Stack

The Stack class in Java is inherits from [Vector in Java](https://www.geeksforgeeks.org/java/java-util-vector-class-java/). It is a thread-safe class. It is recommended to use [ArrayDeque](https://www.geeksforgeeks.org/java/arraydeque-in-java/) for stack implementation as it is more efficient in a single-threaded environment.

import java.util.*;

import java.util.stream.Collectors;

​

class Geeks {

    public static void main(String[] args)

    {

​

        Stack<Integer> stack = new Stack<>();

        Deque<Integer> deque = new ArrayDeque<>();

​

        stack.push(1);

        deque.push(1);

        stack.push(2);

        deque.push(2);

​

        List<Integer> list1

            = stack.stream().collect(Collectors.toList());

        System.out.println("Using Stack: ");

        for (int i = 0; i < list1.size(); i++) {

            System.out.print(list1.get(i) + " ");

        }

        System.out.println();

​

        List<Integer> list2

            = deque.stream().collect(Collectors.toList());

        System.out.println("Using Deque: ");

        for (int i = 0; i < list2.size(); i++) {

            System.out.print(list2.get(i) + " ");

        }

        System.out.println();

    }

}

  
**Output**

Using Stack: 
1 2 
Using Deque: 
2 1 

## ****Methods in Stack Class**** 

|Method|Description|
|---|---|
|[empty()](https://www.geeksforgeeks.org/java/stack-empty-method-in-java/)|This method returns true if nothing is on the top of the stack. Else, returns false.|
|[peek()](https://www.geeksforgeeks.org/java/stack-peek-method-in-java/)|This method returns the element on the top of the stack, but does not remove it.|
|[pop()](https://www.geeksforgeeks.org/java/stack-pop-method-in-java/)|This method removes and returns the top element of the stack.|
|[push(Object element)](https://www.geeksforgeeks.org/java/stack-push-method-in-java/)|This method pushes an element on the top of the stack.|
|[search(Object element)](https://www.geeksforgeeks.org/java/stack-search-method-in-java/)|This method is used to determine whether an object exists in the stack. If the element is found,It returns the position of the element from the top of the stack. Else, it returns -1.|

## Methods Inherited from the Vector Class

|Method|Description|
|---|---|
|[add(Object obj)](https://www.geeksforgeeks.org/java/vector-add-method-in-java/)|This method is used to appends the specified element to the end of the Vector.|
|[add(int index, Object obj)](https://www.geeksforgeeks.org/java/vector-add-method-in-java/)|This method is used to inserts the specified element at the specified position in the Vector.|
|[addAll(Collection c)](https://www.geeksforgeeks.org/java/vector-addall-method-in-java/)|This method is used to appends all of the elements in the specified Collection to the end of theVector, in the order that they are returned by the specified Collection's Iterator.|
|[addAll(int index, Collection c)](https://www.geeksforgeeks.org/java/vector-addall-method-in-java/)|This method is used to inserts all the elements in the specified Collection into this Vector at the specified position.|
|[addElement(Object o)](https://www.geeksforgeeks.org/java/vector-addelement-method-in-java/#:~:text=)|This method is used to adds the specified component to the end of the vector|
|[capacity()](https://www.geeksforgeeks.org/java/vector-capacity-method-in-java/)|This method returns the current capacity of the vector.|
|[clear()](https://www.geeksforgeeks.org/java/vector-clear-method-in-java/)|This method removes all the elements from the Vector.|
|[clone()](https://www.geeksforgeeks.org/java/vector-clone-method-in-java-with-examples/)|This method returns a clone of the vector.|
|[contains(Object o)](https://www.geeksforgeeks.org/java/vector-contains-method-in-java/)|This method returns true if this vector contains the specified element.|
|[containsAll(Collection c)](https://www.geeksforgeeks.org/java/vector-containsall-method-in-java/)|This method returns true if this Vector contains all the elements in the specified Collection.|
|[copyInto(Object []array)](https://www.geeksforgeeks.org/java/vector-copyinto-method-in-java/#:~:text=)|This method is used to copies the components of this vector into the specified array.|
|[elementAt(int index)](https://www.geeksforgeeks.org/java/vector-elementat-method-in-java/#:~:text=elementAt\(int%20pos\)%20method%20is,specific%20index%20from%20a%20Vector.&text=)|This method returns the component at the specified index.|
|[elements()](https://www.geeksforgeeks.org/java/vector-elements-method-in-java/#:~:text=elements\(\)%20method%20of%20Vector,values%20present%20in%20the%20Vector.&text=)|This method returns an enumeration of the components of the vector.|
|[ensureCapacity(int minCapacity)](https://www.geeksforgeeks.org/java/vector-ensurecapacity-method-in-java-with-example/)|This method increases the capacity of the vector, if necessary, to ensure that it can hold at least the number of components specified by the minimum capacity argument.|
|[equals()](https://www.geeksforgeeks.org/java/vector-equals-method-in-java/)|This method compares the specified Object with the Vector for equality.|
|[firstElement()](https://www.geeksforgeeks.org/java/vector-firstelement-method-in-java/)|This method returns the first component (the item at index 0) of the vector.|
|[get(int index)](https://www.geeksforgeeks.org/java/vector-get-method-in-java/)|This method returns the element at the specified position in the Vector.|
|[hashCode()](https://www.geeksforgeeks.org/java/vector-hashcode-method-in-java/#:~:text=hashCode\(\)%20method%20in%20Java%20is%20used%20to,hashcode%20value%20of%20this%20vector.&text=)|This method returns the hash code value for the Vector.|
|[indexOf(Object o)](https://www.geeksforgeeks.org/java/vector-indexof-method-in-java/#:~:text=)|This method returns the index of the first occurrence of the specified element in this vector or -1 if this vector does not contain the element.|
|[indexOf(Object o, int index)](https://www.geeksforgeeks.org/java/vector-indexof-method-in-java/#:~:text=)|This method returns the index of the first occurrence of the specified element in this vector, searching forwards from the index or returns -1 if the element is not found.|
|[insertElementAt(Object o, int index)](https://www.geeksforgeeks.org/java/vector-insertelementat-method-in-java-with-examples/#:~:text=)|This method inserts the specified object as a component in this vector at the specified index.|
|[isEmpty()](https://www.geeksforgeeks.org/java/vector-isempty-method-in-java/)|This method tests if this vector has no components.|
|[iterator()](https://www.geeksforgeeks.org/java/vector-iterator-method-in-java-with-examples/)|This method returns an iterator over the elements in this list in proper sequence.|
|[lastElement()](https://www.geeksforgeeks.org/java/vector-lastelement-method-in-java/)|This method returns the last component of the vector.|
|[lastIndexOf(Object o)](https://www.geeksforgeeks.org/java/vector-lastindexof-method-in-java/)|This method returns the index of the last occurrence of the specified element in this vector or -1 If this vector does not contain the element.|
|[lastIndexOf(Object o, int index)](https://www.geeksforgeeks.org/java/vector-lastindexof-method-in-java/)|This method returns the index of the last occurrence of the specified element in this vector, searching backward from the index or returns -1 if the element is not found.|
|[listIterator()](https://www.geeksforgeeks.org/java/vector-listiterator-method-in-java-with-examples/#:~:text=)|This method returns a list iterator over the elements in this list (in proper sequence).|
|[listIterator(int index)](https://www.geeksforgeeks.org/java/vector-listiterator-method-in-java-with-examples/#:~:text=)|This method returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.|
|[remove(int index)](https://www.geeksforgeeks.org/java/vector-remove-method-in-java/)|This method removes the element at the specified position in this Vector.|
|[remove(Object o)](https://www.geeksforgeeks.org/java/vector-remove-method-in-java/)|This method removes the first occurrence of the specified element in this Vector If the Vector does not contain the element, it is unchanged.|
|[removeAll(Collection c)](https://www.geeksforgeeks.org/java/vector-removeall-method-in-java/)|This method removes from this Vector all of its elements that are contained in the specified Collection.|
|[removeAllElements()](https://www.geeksforgeeks.org/java/vector-removeallelements-method-in-java-with-example/)|This method removes all components from this vector and sets its size to zero.|
|[removeElement(Object o)](https://www.geeksforgeeks.org/java/vector-removeelement-method-in-java-with-example/)|This method removes the first (lowest-indexed) occurrence of the argument from this vector.|
|[removeElementAt(int index)](https://www.geeksforgeeks.org/java/vector-removeelementat-method-in-java/)|This method deletes the component at the specified index.|
|[removeRange(int fromIndex, int toIndex)](https://www.geeksforgeeks.org/java/vector-removerange-method-in-java-with-example/)|This method removes from this list all the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.|
|[retainAll(Collection c)](https://www.geeksforgeeks.org/java/vector-retainall-method-in-java-with-examples/)|This method retains only the elements in this Vector that are contained in the specified Collection.|
|[set(int index, Object o)](https://www.geeksforgeeks.org/java/vector-set-method-in-java/)|This method replaces the element at the specified position in this Vector with the specified element.|
|[setElementAt(Object o, int index)](https://www.geeksforgeeks.org/java/vector-setelementat-method-in-java-with-example/)|This method sets the component at the specified index of this vector to be the specified object.|
|[setSize(int newSize)](https://www.geeksforgeeks.org/java/vector-setsize-method-in-java-with-example/)|This method sets the size of this vector.|
|[size()](https://www.geeksforgeeks.org/java/vector-size-method-in-java/#:~:text=size\(\)%20method%20in%20Java%20is%20used%20to%20get%20the,elements%20present%20in%20the%20Vector.&text=)|This method returns the number of components in this vector.|
|[subList(int fromIndex, int toIndex)](https://www.geeksforgeeks.org/java/vector-sublist-method-in-java/)|This method returns a view of the portion of this List between fromIndex, inclusive, and toIndex, exclusive.|
|[toArray()](https://www.geeksforgeeks.org/java/vector-toarray-method-in-java-with-examples/)|This method returns an array containing all of the elements in this Vector in the correct order.|
|[toArray(Object []array)](https://www.geeksforgeeks.org/java/vector-toarray-method-in-java-with-examples/)|This method returns an array containing all of the elements in this Vector in the correct order; the runtime type of the returned array is that of the specified array.|
|[toString()](https://www.geeksforgeeks.org/java/vector-tostring-method-in-java-with-example/#:~:text=)|This method returns a string representation of this Vector, containing the String representation of each element.|
|[trimToSize()](https://www.geeksforgeeks.org/java/vector-trimtosize-method-in-java-with-example/)|This method trims the capacity of this vector to be the vector's current size.|



# PriorityQueue in Java
A PriorityQueue in Java is a queue where elements are ordered based on their priority, rather than the order of insertion. By default, it uses natural ordering ([min-heap](https://www.geeksforgeeks.org/dsa/introduction-to-min-heap-data-structure/)), but a custom comparator can be used to define different priorities.

Also a simple datatype but one that uses FIFO • First In, First Out • Is actually a java interface • LinkedList • PriorityQueue • And some other • A Queue when the order of processing matters and the oldest item should be handled next • print jobs

```java
Queue queue = new PriorityQueue (); queue.add("apple"); queue.add("banana"); queue.add("cherry"); String front = queue.remove(); String peeked = queue.peek();
```
![[Pasted image 20260221152141.png]]


- Elements are processed based on priority rather than insertion order.
- Supports standard queue operations like add(), poll(), and peek().
- Automatically grows as elements are added.
- Uses a [heap data structure](https://www.geeksforgeeks.org/dsa/heap-data-structure/) internally to ensure efficient insertion and removal of the highest-priority element.

### Declaration of PriorityQueue

> public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable

where, ****E**** is the type of elements held in this queue.  

import java.util.PriorityQueue;

​

public class Geeks 

{

    public static void main(String[] args) 

    {

        // Priority Queue Min Type

        PriorityQueue<Integer> p = new PriorityQueue<>();

​

        // Add elements to the queue

        p.add(3);

        p.add(10);

        p.add(7);

        p.add(2);

​

        // Print the head of the queue

        System.out.println("Head of Queue: " + p.peek());

    }

}

  
**Output**

Head of Queue: 2

## Hierarchy of PriorityQueue

It implements the [Queue interface](https://www.geeksforgeeks.org/java/queue-interface-java/) which extends the [Collection Interface](https://www.geeksforgeeks.org/java/collection-interface-in-java-with-examples/).

![iterable](https://media.geeksforgeeks.org/wp-content/uploads/20250818125835332455/iterable.webp "Click to enlarge")

PriorityQueue Hierarchy

## Constructors of PriorityQueue

### 1. PriorityQueue()

This method creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.

> PriorityQueue<E> pq = new PriorityQueue<E>();

### 2. PriorityQueue(int initialCapacity)

This creates a PriorityQueue with the specified initial capacity that orders its elements according to their natural ordering.

> PriorityQueue<E> pq = new PriorityQueue<E>(int initialCapacity);

### 3. PriorityQueue(Comparator<E> comparator)

This creates a PriorityQueue with the default initial capacity and whose elements are ordered according to the specified comparator.

> PriorityQueue<E> pq = new PriorityQueue<E>(Comparator<E> c);

### 4. PriorityQueue(int initialCapacity, Comparator<E> comparator)

This creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.

> PriorityQueue<E> pq = new PriorityQueue<E>(int initialCapacity, Comparator<E> comparator);

## Different Operations on PriorityQueue

Let’s see how to perform a few frequently used operations on the Priority Queue class.

### ****1. Adding Elements****

To add an element in a priority queue, we can use the add() method.

import java.util.*;

public class Geeks

{  

    public static void main(String args[])

    {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<3;i++){

            pq.add(i);

            pq.add(1);

        }

        System.out.println(pq);

    }

}

  
**Output**

[0, 1, 1, 1, 2, 1]

### 2. Removing Elements

To remove an element from a priority queue, we can use the ****remove()**** method.

import java.util.*;

import java.io.*;

​

public class Geeks {

​

    public static void main(String args[])

    {

        PriorityQueue<String> pq = new PriorityQueue<>();

​

        pq.add("Geeks");

        pq.add("For");

        pq.add("Geeks");

​

        System.out.println("Initial PriorityQueue " + pq);

​

        // using the method

        pq.remove("Geeks");

​

        System.out.println("After Remove: " + pq);

​

        System.out.println("Poll Method: " + pq.poll());

​

        System.out.println("Final PriorityQueue: " + pq);

    }

}

  
**Output**

Initial PriorityQueue [For, Geeks, Geeks]
After Remove: [For, Geeks]
Poll Method: For
Final PriorityQueue: [Geeks]

### ****3. Accessing the Elements****

To access elements from a priority queue, we can use the ****peek()**** method.

import java.util.*;

​

class Geeks {

    public static void main(String[] args)

    {

​

        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Geeks");

        pq.add("For");

        pq.add("Geeks");

        System.out.println("PriorityQueue: " + pq);

​

        // Using the peek() method

        String element = pq.peek();

        System.out.println("Accessed Element: " + element);

    }

}

  
**Output**

PriorityQueue: [For, Geeks, Geeks]
Accessed Element: For

### ****4. Iterating the PriorityQueue****

There are multiple ways to iterate through the PriorityQueue. The most famous way is converting the queue to the array and traversing ****using an iterator****. Iterator does not traverse in priority order.

import java.util.*;

​

public class Geeks {

    public static void main(String args[])

    {

        PriorityQueue<String> pq = new PriorityQueue<>();

​

        pq.add("Geeks");

        pq.add("For");

        pq.add("Geeks");

​

        Iterator iterator = pq.iterator();

​

        while (iterator.hasNext()) {

            System.out.print(iterator.next() + " ");

        }

    }

}

  
**Output**

For Geeks Geeks 

## Methods of PriorityQueue

|Method|Description|
|---|---|
|[add(E e)](https://www.geeksforgeeks.org/java/priorityqueue-add-method-in-java/)|Inserts the specified element into this priority queue.|
|[clear()](https://www.geeksforgeeks.org/java/priorityqueue-clear-method-in-java/#:~:text=clear\(\)%20method%20is%20used,only%20empty%20an%20existing%20PriorityQueue.)|Removes all of the elements from this priority queue.|
|[comparator()](https://www.geeksforgeeks.org/java/priorityqueue-comparator-method-in-java/)|Returns the comparator used to order the elements in this queue or null if this queue is sorted according to the natural ordering of its elements.|
|[contains?(Object o)](https://www.geeksforgeeks.org/java/priorityqueue-contains-method-in-java/#:~:text=PriorityQueue.,any%20particular%20element%20or%20not.&text=Return%20Value%3A%20The%20method%20returns,queue%20otherwise%20it%20returns%20False.)|Returns true if this queue contains the specified element.|
|[forEach?(Consumer<? super E> action)](https://www.geeksforgeeks.org/java/arraylist-foreach-method-in-java/)|Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.|
|[iterator()](https://www.geeksforgeeks.org/java/priorityqueue-iterator-method-in-java/)|Returns an iterator over the elements in this queue.|
|[offer?(E e)](https://www.geeksforgeeks.org/java/priorityqueue-offer-method-in-java/)|Inserts the specified element into this priority queue.|
|[remove?(Object o)](https://www.geeksforgeeks.org/java/priorityqueue-remove-method-in-java/)|Removes a single instance of the specified element from this queue, if it is present.|
|[removeAll?(Collection<?> c)](https://www.geeksforgeeks.org/java/arraylist-removeall-method-in-java-with-examples/)|Removes all of this collection's elements that are also contained in the specified collection (optional operation).|
|[removeIf?(Predicate<? super E> filter)](https://www.geeksforgeeks.org/java/arraylist-removeif-method-in-java/)|Removes all of the elements of this collection that satisfy the given predicate.|
|[retainAll?(Collection<?> c)](https://www.geeksforgeeks.org/java/arraylist-retainall-method-in-java/)|Retains only the elements in this collection that are contained in the specified collection (optional operation).|
|[spliterator()](https://www.geeksforgeeks.org/java/priorityqueue-spliterator-method-in-java/)|Creates a late-binding and fail-fast Spliterator over the elements in this queue.|
|[toArray()](https://www.geeksforgeeks.org/java/priorityqueue-toarray-method-in-java/#:~:text=toArray\(arr%5B%5D\)%20method%20in,the%20previous%20method%20without%20parameters.)|Returns an array containing all of the elements in this queue.|
|[toArray?(T[] a)](https://www.geeksforgeeks.org/java/priorityqueue-toarray-method-in-java/#:~:text=toArray\(arr%5B%5D\)%20method%20in,the%20previous%20method%20without%20parameters.)|Returns an array containing all of the elements in this queue; the runtime type of the returned array is that of the specified array.|

## Methods Declared in Interface java.util.Queue

|Method|Description|
|---|---|
|[peek()](https://www.geeksforgeeks.org/java/queue-peek-method-in-java/)|Retrieves, but does not remove, the head of this queue or returns null if this queue is empty.|
|[poll()](https://www.geeksforgeeks.org/java/queue-poll-method-in-java/)|Retrieves and removes the head of this queue or returns null if this queue is empty.|

## Methods Declared in Class java.util.AbstractQueue

|Method|Description|
|---|---|
|[addAll(Collection<? extends E> c)](https://www.geeksforgeeks.org/java/abstractqueue-addall-method-in-java-with-examples/)|Adds all of the elements in the specified collection to this queue.|
|[element()](https://www.geeksforgeeks.org/java/abstractqueue-element-method-in-java-with-examples/)|Retrieves, but does not remove, the head of this queue.|
|[remove()](https://www.geeksforgeeks.org/java/abstractqueue-remove-method-in-java-with-examples/#:~:text=The%20remove\(\)%20method%20of,the%20head%20of%20this%20queue.&text=Parameters%3A%20This%20method%20does%20not,if%20the%20queue%20is%20empty.)|Retrieves and removes the head of this queue.|

## Methods Declared in Class java.util.AbstractCollection

|Method|Description|
|---|---|
|[containsAll(Collection<?> c)](https://www.geeksforgeeks.org/java/abstractcollection-containsall-method-in-java-with-examples/)|Returns true if this collection contains all of the elements in the specified collection.|
|[isEmpty()](https://www.geeksforgeeks.org/java/abstractcollection-isempty-method-in-java-with-examples/)|Returns true if this collection contains no elements.|
|[toString()](https://www.geeksforgeeks.org/java/abstractcollection-tostring-method-in-java-with-examples/)|Returns a string representation of this collection.|

## Methods Declared in Interface java.util.Collection

|Method|Description|
|---|---|
|[containsAll(Collection<?> c)](https://www.geeksforgeeks.org/java/list-containsall-method-in-java-with-examples/)|Returns true if this collection contains all of the elements in the specified collection.|
|[equals(Object o)](https://www.geeksforgeeks.org/java/map-equals-method-in-java-with-examples/)|Compares the specified object with this collection for equality.|
|[hashCode()](https://www.geeksforgeeks.org/java/method-class-hashcode-method-in-java/)|Returns the hash code value for this collection.|
|[isEmpty()](https://www.geeksforgeeks.org/java/java-string-isempty-method-example/)|Returns true if this collection contains no elements.|
|[size()](https://www.geeksforgeeks.org/java/list-size-method-in-java-with-examples/)|Returns the number of elements in this collection.|

### Applications of PriorityQueue

- Implementing [Dijkstra's](https://www.geeksforgeeks.org/dsa/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/) and [Prim's](https://www.geeksforgeeks.org/dsa/prims-algorithm-using-priority_queue-stl/) algorithms.
- [Maximize array sum after K negation](https://www.geeksforgeeks.org/dsa/maximize-array-sum-after-k-negations-using-priority-queue/)

TREE STRUCTURES
Problem: we wish to search for a specific location • Linear search through a list of Locations • Define a datatype Area which holds • Information about (sub)Areas, e.g. what types exists beneath this • Methods to check if a location is in this range • Then we may create an n-ary tree of areas and locations at the bottom • Yields more efficient searches like • What tourist attractions are nearby me • Where is the nearest railway station
![[Pasted image 20260221152631.png]]

What can we do with data tree structures? • Insert, add, remove, … • Search, update, … • Checks e.g. isLocationInRange() • So, we add and implement these methods • Keeping all household data internal • Counters, pointers, objects, hashtables, whatever we use … • Additionally, we may need nice prints • If we just print our tree, we get something like MyTree@5ccd43c2 -> what does this mean? • This is an object reference – Most useful to check our object is not null • So, we may wish to add a printNice() method or similar that prints the information we want shown

he base is a model of a node, which • Has some data • Has children (for binary, left and right children) • Constructor we set the data • Maybe we also wish a nodeID and some other metadata • Tree code is centred around the TLNode class
```java
public class BinaryTree{ static void preorder(TLNode r) { if(r==null) return; System.out.print(r.data+" "); preorder(r.left); preorder(r.right); } static void inorder(TLNode r){ if(r==null) return; inorder(r.left); System.out.print(r.data+" "); inorder(r.right); } static void postorder(TLNode r) { if(r==null) return; postorder(r.left); postorder(r.right); System.out.print(r.data+" "); } }
```
```java
class TLNode { int data; TLNode left,right; TLNode(int d){ data=d; } }
```
Useful for e.g. • Applications with priorities • Scheduling algorithms • Caching • Code implements a complete max-heap data structure using an array and demonstrates fundamental heap operations • Min heap and max heap • O(1) for min or max elements
```java
class Heap{ int heapSize; void build_max_heap(int[] a) { heapSize=a.length; for(int i=(heapSize/2);i>=0;i--) max_heapify(a,i); } void max_heapify(int[] a,int i) { int l=2*i+1; int r=2*i+2; int largest=i; if(la[largest]) largest=l; if(ra[largest]) largest=r; if(largest!=i){ int t=a[i]; a[i]=a[largest]; a[largest]=t; max_heapify(a,largest); } } }
```
```java
int extract_max(int[] a){ if(heapSize<0) System.out.println("underflow"); int max=a[0]; a[0]=a[heapSize-1]; heapSize--; max_heapify(a,0); return max; } void increase_key(int[] a,int i,int key){ if(key=0 && a[(i-1)/2]
```
As mentioned, Heap-structures excel at managing priority queues • A max-heap ensures that “important” tasks are always first to be processed • CPU task scheduling • Print job prioritization • Event handling in GUIs • Network packet scheduling • Other examples relate to constantly receiving a data stream and wanting to keep, for instance, a list of the top-10 largest values thus far • Top-10 high score in online game • Most popular hashtags today • Highest speed-trap measurements during a Formula One race


CUSTOM DATATYPE STRUCTURES
Data types are not physical objects, but we treat (or can at least) them as if they are in OO • Example: what characterizes a Location? • Coordinates or or something else • A description for humans to relate (and machines) • A set of references to objects on this location • A marker how to show this graphically on a map • … and probably more/other • Maybe we have a special Location • Tourist attraction, which is located at a location • Transport point (e.g. railway station) • And ton of other options …
![[Pasted image 20260221152458.png]]
Using inheritance, we may treat all tourist attractions as locations, as well as other location types • Imagine a list of locations that I need to visit for various reasons • My job is on that location (work location) • I want to see the location (tourist attraction) • I need to meet someone there (a bar) • Etc. etc. • I need now to create an algorithm that gives me the optimal (least time, least fuel, etc.) order of visits • Consequently, it is useful to treat all objects as Locations and not as specialized types • When I go to the location, it is useful to treat the object as specialized location
![[Pasted image 20260221152509.png]]
There is a ton of different things you can do with custom datatype structure • But if we start to reuse (copy/paste) code elsewhere, then be aware • Ideally, we have specialized code in one, and only one, place • Associations may also be a type of relations, e.g. • A car has a Location (as it is a physical object)
![[Pasted image 20260221152520.png]]

THE IMPORTANT STUFF
Primitive vs wrapper types • Understand memory (primitives -> stack, objects -> heap), behaviour, and when wrappers are needed • Know your data structures • Each has specific strengths for specific access patterns • OO principles drive Java’s type system • Encapsulation, abstraction, and interfaces matter • Data structures are behaviour + rules, not just storage • Designing your own structure requires defining behaviour, choosing representation, and enforcing invariants