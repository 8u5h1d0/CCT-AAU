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
# Java ArrayList

## Java ArrayList

An `ArrayList` is like a resizable array.
The difference between a built-in array and an `ArrayList` in Java, is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one). While elements can be added and removed from an `ArrayList` whenever you want.

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


