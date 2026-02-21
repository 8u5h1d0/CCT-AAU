---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: Lists & List-Interface | Iterators + Practical use  | Operators - Euality, Larger, Smaller, etc. | Operations, like sorting a list.
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - Geekforgeeks - List Interface in Java
  - Geekforgeeks - Iterator in Java
  - Geekforgeeks - Overriding equals method in Java
  - Geekforgeeks - Sorting in Java
Created: 21-02-2026
---
- - -
# List Interface in Java
The `List` interface in Java extends the `Collection` interface and is part of the `java.util` package. It is used to store ordered collections where duplicates are allowed and elements can be accessed by their index.

> [!info] Characteristics of List
> *   **Order:** Maintains insertion order.
> *   **Duplicates:** Allows duplicate elements.
> *   **Null:** Supports null elements (though this is implementation-dependent).
> *   **Traversal:** Supports bidirectional traversal using `ListIterator`.

> [!example] Basic List Implementation
> This program demonstrates how to create a List using `ArrayList`, add elements to it, and iterate through the list to print each element.
> 
> ```java
> import java.util.*;
> 
> class Geeks {
>     public static void main(String[] args) {
>         // Creating a List of Strings using ArrayList
>         List<String> li = new ArrayList<>();
> 
>         // Adding elements in List
>         li.add("Java");
>         li.add("Python");
>         li.add("DSA");
>         li.add("C++");
> 
>         System.out.println("Elements of List are:");
> 
>         // Iterating through the list
>         for (String s : li) {
>             System.out.println(s);
>         }
>     }
> }
> ```

### Declaration and Hierarchy

To use a `List`, you must instantiate a class that implements it. The interface declaration is:

```java
public interface List<E> extends Collection<E> { }
```

Common classes that implement `List` include `ArrayList`, `LinkedList`, `Vector`, and `Stack`. The `List` interface extends the `Collection` interface, which in turn extends `Iterable`.

> [!info] Common Implementation Classes
> *   **ArrayList:** Implemented using a resizable array. It offers fast random access but slower insert/delete operations.
> *   **LinkedList:** Implemented using a doubly-linked list. It is efficient for frequent insertions and deletions.
> *   **Vector:** A legacy implementation using a synchronized dynamic array. It is thread-safe but slower than `ArrayList`.
> *   **Stack:** A subclass of `Vector` that implements a LIFO (Last-In-First-Out) structure for stack operations.

### Java List Operations

Since `List` is an interface, it can only be used with a class that implements it. Below are common operations performed on a `List`.

#### 1. Adding Elements

The `add()` method is used to add elements. It is overloaded to add elements at the end or at a specific index.

*   `add(Object o)`: Adds an element at the end of the `List`.
*   `add(int index, Object o)`: Adds an element at a specific index.

> [!warning] Index Constraints
> If you try to add an element at index `1` before adding an element at index `0`, it will throw an error. It is recommended to add elements at a particular index only when the size is defined or to add them sequentially.

```java
import java.util.*;

class Geeks {
    public static void main(String args[]) {
        List<String> al = new ArrayList<>();

        // Adding elements
        al.add("Geeks");
        al.add("Geeks");
        al.add(1, "For");

        System.out.println(al);
    }
}
// Output: [Geeks, For, Geeks]
```

#### 2. Updating Elements

The `set()` method is used to update (replace) an element at a specific index with a new value.

```java
import java.util.*;

class Geeks {
    public static void main(String args[]) {
        List<String> al = new ArrayList<>();

        al.add("Geeks");
        al.add("Geeks");
        al.add(1, "Geeks");

        System.out.println("Initial ArrayList " + al);

        // Updating element at 1st index
        al.set(1, "For");

        System.out.println("Updated ArrayList " + al);
    }
}
// Output:
// Initial ArrayList [Geeks, Geeks, Geeks]
// Updated ArrayList [Geeks, For, Geeks]
```

#### 3. Searching Elements

Searching can be performed using `indexOf()` and `lastIndexOf()`.

*   `indexOf(Object o)`: Returns the index of the first occurrence of the specified element, or `-1` if not found.
*   `lastIndexOf(Object o)`: Returns the index of the last occurrence of the specified element, or `-1` if not found.

```java
import java.util.*;

class Geeks {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();

        al.add(1);
        al.add(2);
        al.add(3);
        al.add(2);

        int i = al.indexOf(2);
        System.out.println("First Occurrence of 2 is at Index: " + i);

        int l = al.lastIndexOf(2);
        System.out.println("Last Occurrence of 2 is at Index: " + l);
    }
}
// Output:
// First Occurrence of 2 is at Index: 1
// Last Occurrence of 2 is at Index: 3
```

#### 4. Removing Elements

The `remove()` method is overloaded to remove elements by object or by index.

*   `remove(Object o)`: Removes the first occurrence of the specified object.
*   `remove(int index)`: Removes the element at the specified index and shifts subsequent elements to the left.

```java
import java.util.ArrayList;
import java.util.List;

class Geeks {
    public static void main(String args[]) {
        List<String> al = new ArrayList<>();

        al.add("Geeks");
        al.add("Geeks");
        al.add(1, "For");

        System.out.println("Initial ArrayList " + al);

        // Remove element at 1st index
        al.remove(1);
        System.out.println("After the Index Removal " + al);

        // Remove the object "Geeks"
        al.remove("Geeks");
        System.out.println("After the Object Removal " + al);
    }
}
// Output:
// Initial ArrayList [Geeks, For, Geeks]
// After the Index Removal [Geeks, Geeks]
// After the Object Removal [Geeks]
```

#### 5. Accessing Elements

The `get(int index)` method returns the element at the specified position.

```java
import java.util.*;

class Geeks {
    public static void main(String args[]) {
        List<String> al = new ArrayList<>();

        al.add("Geeks");
        al.add("For");
        al.add("Geeks");

        String first = al.get(0);
        String second = al.get(1);
        String third = al.get(2);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
// Output:
// Geeks
// For
// Geeks
```

#### 6. Checking for Elements

The `contains(Object o)` method returns `true` if the specified element is present in the list, otherwise `false`.

```java
import
 java.util.*;

class Geeks {
    public static void main(String args[]) {
        List<String> al = new ArrayList<>();

        al.add("Geeks");
        al.add("For");
        al.add("Geeks");

        boolean isPresent = al.contains("Geeks");
        System.out.println("Is Geeks present in the list? " + isPresent);
    }
}
// Output: Is Geeks present in the list? true
```

### Iterating over a List

For larger datasets, lists can be iterated using:
1.  Basic `for` loop with `get(index)`.
2.  Enhanced `for-each` loop.

```java
import java.util.*;

public class Geeks {
    public static void main(String args[]) {
        List<String> al = new ArrayList<>();

        al.add("Geeks");
        al.add("Geeks");
        al.add(1, "For");

        // Using for loop
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }

        System.out.println();

        // Using for-each loop
        for (String str : al)
            System.out.print(str + " ");
    }
}
// Output:
// Geeks For Geeks 
// Geeks For Geeks 
```

### Complexity of List Interface

The performance of `List` operations varies based on the implementation, but general time complexities are as follows:

**Table 1: Complexity of List Interface Operations**

| Operation | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| Adding Element | $O(1)$ | $O(1)$ |
| Remove Element | $O(N)$ | $O(1)$ |
| Replace Element | $O(1)$ | $O(1)$ |
| Traversing | $O(N)$ | $O(1)$ |

### Common Methods of the List Interface

**Table 2: Common Methods of the List Interface**

| Method | Description |
| :--- | :--- |
| `add(int index, element)` | Adds an element at a particular index. |
| `addAll(int index, Collection collection)` | Adds all elements from a collection to the list. |
| `size()` | Returns the size of the list. |
| `clear()` | Removes all elements; the list reference is retained. |
| `remove(int index)` | Removes an element at the specified index. |
| `remove(element)` | Removes the first occurrence of the specified element. |
| `get(int index)` | Returns the element at the specified index. |
| `set(int index, element)` | Replaces the element at the given index; returns the replaced element. |
| `indexOf(element)` | Returns the first occurrence index of the element, or `-1`. |
| `lastIndexOf(element)` | Returns the last occurrence index of the element, or `-1`. |
| `equals(element)` | Compares the equality of the given element with list elements. |
| `hashCode()` | Returns the hashcode value of the list. |
| `isEmpty()` | Checks if the list is empty; returns `true` or `false`. |
| `contains(element)` | Checks if the list contains the given element. |
| `containsAll(Collection collection)` | Checks if the list contains all elements of the collection. |
| `sort(Comparator comp)` | Sorts the list based on the given comparator. |

### List vs Set

Both `List` and `Set` inherit from the `Collection` interface but have distinct differences.

**Table 3: Comparison between List and Set**

| Feature | List | Set |
| :--- | :--- | :--- |
| **Order** | Ordered sequence (maintains insertion order). | Unordered sequence. |
| **Duplicates** | Allows duplicate elements. | Does not allow duplicate elements. |
| **Access** | Elements can be accessed by their position (index). | Position access is not allowed. |
| **Null Elements** | Multiple null elements can be stored. | The null element can be stored only once. |
| **Implementations** | `ArrayList`, `LinkedList`, `Vector`, `Stack`. | `HashSet`, `LinkedHashSet`, `TreeSet`. |
# Iterator in Java
An **Iterator** in Java is a cursor used to traverse or iterate through the elements of a collection one by one. It is part of the `java.util` package and is one of the most commonly used cursors in the Java Collections Framework.

> [!info] Characteristics of Iterator
> *   **Direction:** Used to traverse elements in the forward direction only (unidirectional).
> *   **Safety:** Allows elements to be removed safely during traversal using the `remove()` method.
> *   **Universality:** It is a universal cursor that applies to all collection types, including `List`, `Set`, and `Queue`.

### Declaration and Creation

The `Iterator` interface is declared as follows:

```java
public interface Iterator<E>
```

Here, `E` represents the type of elements to be iterated over.

An `Iterator` object is created by calling the `iterator()` method on a collection object.

```java
Collection<String> names = new ArrayList<>();
Iterator<String> itr = names.iterator();
```

> [!example] Basic Iteration Example
> This example demonstrates creating an `Iterator` for an `ArrayList` and using it to traverse and print elements.
> 
> ```java
> import java.util.ArrayList;
> import java.util.Iterator;
> 
> public class Geeks {
>     public static void main(String[] args) {
>         // Create an ArrayList and add some elements
>         ArrayList<String> al = new ArrayList<>();
>         al.add("A");
>         al.add("B");
>         al.add("C");
> 
>         // Obtain an iterator for the ArrayList
>         Iterator<String> it = al.iterator();
> 
>         // Iterate through the elements and print each one
>         while (it.hasNext()) {
>             // Get the next element
>             String n = it.next(); 
>             System.out.println(n);      
>         }
>     }
> }
> ```
> **Output:**
> ```text
> A
> B
> C
> ```

### Hierarchy of Iterator

The `Iterator` interface is implemented by all collection classes. A notable subinterface is `ListIterator`, which extends `Iterator` to provide bidirectional traversal capabilities.

### Methods of Iterator Interface

The `Iterator` interface defines three primary methods:

*   **`hasNext()`:** Returns `true` if the iteration has more elements.
*   **`next()`:** Returns the next element in the iteration. It throws `NoSuchElementException` if no more elements are present.
*   **`remove()`:** Removes the last element returned by `next()`. This method can be called only once per call to `next()`.

> [!warning] Using the `remove()` Method
> The `remove()` method can throw exceptions if misused (e.g., calling it without a prior call to `next()` or calling it multiple times for the same element).

### Internal Working

The internal functionality of an `Iterator` relies on a cursor that points to positions within the collection.

1.  **Initial State:** When an iterator is created, the cursor points **before** the first element of the list.
2.  **Traversal:** When `next()` is called, the cursor jumps to the next element and returns that element.
3.  **Progress:** Repeated calls to `hasNext()` (to check availability) and `next()` move the cursor sequentially through the list.
4.  **End State:** Once the cursor passes the last element, `hasNext()` returns `false`.

Because the cursor only moves forward, `Iterator` is known as a unidirectional cursor. In contrast, `ListIterator` is bi-directional.

### Example: Removing Elements During Iteration

A key advantage of the `Iterator` is the ability to safely remove elements from a collection while traversing it.

> [!example] Removing Odd Elements
> This example creates an `ArrayList` of integers, iterates through it, and removes all odd numbers using the iterator's `remove()` method.
> 
> ```java
> import java.util.ArrayList;
> import java.util.Iterator;
> 
> public class Geeks {
>     public static void main(String[] args) {
>         // Creating an ArrayList of Integer type
>         ArrayList<Integer> al = new ArrayList<>();
> 
>         // Adding elements to the ArrayList
>         for (int i = 0; i < 10; i++) {
>             al.add(i);
>         }
> 
>         // Printing the original list
>         System.out.println("Original List: " + al);
> 
>         // Creating an Iterator for the ArrayList
>         Iterator<Integer> itr = al.iterator();
> 
>         // Iterating through the list and removing odd elements
>         while (itr.hasNext()) {
>             // Getting the next element
>             int i = itr.next();  
>             
>             System.out.print(i + " ");  
> 
>             // Removing odd elements
>             if (i % 2 != 0) {
>                 itr.remove();
>             }
>         }
> 
>         System.out.println();
> 
>         // Printing the modified list after removal of odd elements
>         System.out.println("Modified List: " + al);
>     }
> }
> ```
> **Output:**
> ```text
> Original List: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
> 0 1 2 3 4 5 6 7 8 9 
> Modified List: [0, 2, 4, 6, 8]
> ```

# Overriding equals method in Java
In Java, comparing objects requires understanding the difference between comparing references and comparing the actual data contained within those objects.

### The `==` Operator vs `equals()` Method

When comparing objects using the `==` operator, Java checks if the reference variables point to the exact same object in memory. It does **not** check if the contents of the objects are identical.

> [!example] Reference Comparison
> Consider two `Complex` objects initialized with the same values:
> ```java
> Complex c1 = new Complex(10, 15);
> Complex c2 = new Complex(10, 15);
> if (c1 == c2) {
>     System.out.println("Equal ");
> } else {
>     System.out.println("Not Equal ");
> }
> ```
> **Output:**
> ```text
> Not Equal
> ```
> Even though `c1` and `c2` hold the same data, they are distinct objects in memory. The `==` operator returns `false`. If we were to assign `c1` to a new variable `c3` (i.e., `Complex c3 = c1;`), then `c1 == c3` would be `true` because they both reference the exact same object.

### Overriding the `equals()` Method

All classes in Java inherit from the `Object` class, which provides an `equals()` method. By default, this method behaves identically to the `==` operator (checking reference equality). To compare the **values** or data inside the objects, we must override the `equals()` method in our custom class.

A proper implementation of `equals()` should follow these steps:
1.  Check if the object is compared with itself (`o == this`).
2.  Check if the object is an instance of the specific class (also handles `null` checks).
3.  Typecast the object to the current class type.
4.  Compare the specific data members (fields) of the two objects.

> [!example] Overriding `equals()` for a Complex Class
> The following example demonstrates how to override `equals()` to compare the real and imaginary parts of two complex numbers.
> 
> ```java
> class Complex {
>     private double re, im;
> 
>     public Complex(double re, double im) {
>         this.re = re;
>         this.im = im;
>     }
> 
>     // Overriding equals() to compare two Complex objects
>     @Override
>     public boolean equals(Object o) {
> 
>         // If the object is compared with itself then return true  
>         if (o == this) {
>             return true;
>         }
> 
>         /* Check if o is an instance of Complex or not
>           "null instanceof [type]" also returns false */
>         if (!(o instanceof Complex)) {
>             return false;
>         }
>         
>         // typecast o to Complex so that we can compare data members 
>         Complex c = (Complex) o;
>         
>         // Compare the data members and return accordingly 
>         return Double.compare(re, c.re) == 0
>                 && Double.compare(im, c.im) == 0;
>     }
> }
> 
> // Driver class to test the Complex class
> public class Main {
>     public static void main(String[] args) {
>         Complex c1 = new Complex(10, 15);
>         Complex c2 = new Complex(10, 15);
>         if (c1.equals(c2)) {
>             System.out.println("Equal ");
>         } else {
>             System.out.println("Not Equal ");
>         }
>     }
> }
> ```
> **Output:**
> ```text
> Equal
> ```

### Contract with `hashCode()`

> [!warning] Override `hashCode()` when Overriding `equals()`
> It is strongly recommended to override the `hashCode()` method whenever you override `equals()`.
> 
> If two objects are equal according to the `equals()` method, they **must** return the same integer hash code. If this contract is violated, hash-based collections such as `HashMap`, `HashSet`, and `Hashtable` will not function correctly.


# Sorting in Java
In Java, sorting can be accomplished through various methods, ranging from manual implementation using loops to utilizing built-in methods provided by the language. There are four primary ways to sort data in Java: using loops, using the `sort()` method of the `Arrays` class, using the `sort()` method of the `Collections` class, and sorting a specific subarray.

### Way 1: Using Loops

Sorting can be performed manually by implementing logic with loops, typically involving nested loops to compare and swap elements. This approach is often referred to as a brute force method.

> [!example] Sorting using Nested Loops
> The following code demonstrates a basic sort using a nested loop structure to arrange an array of integers in ascending order.
> 
> ```java
> class GFG {
>     // Main driver method
>     public static void main(String[] args) {
>         // Custom input array
>         int arr[] = { 4, 3, 2, 1 };
> 
>         // Outer loop
>         for (int i = 0; i < arr.length; i++) {
> 
>             // Inner nested loop pointing 1 index ahead
>             for (int j = i + 1; j < arr.length; j++) {
> 
>                 // Checking elements
>                 int temp = 0;
>                 if (arr[j] < arr[i]) {
> 
>                     // Swapping
>                     temp = arr[i];
>                     arr[i] = arr[j];
>                     arr[j] = temp;
>                 }
>             }
> 
>             // Printing sorted array elements
>             System.out.print(arr[i] + " ");
>         }
>     }
> }
> ```
> **Output:**
> `1 2 3 4`

### Way 2: Using `sort()` method of Arrays class

The `Arrays.sort()` method is used to sort arrays, including those containing primitive data types. By default, this method sorts the elements in ascending order.

> [!example] Sorting an Array in Ascending Order
> 
> ```java
> import java.util.Arrays;
> 
> public class GFG {
>     public static void main(String[] args) {
>         // Custom input array
>         int[] arr = { 13, 7, 6, 45, 21, 9, 101, 102 };
> 
>         // Calling the sort() method present inside Arrays class
>         Arrays.sort(arr);
> 
>         // Printing and display sorted array
>         System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
>     }
> }
> ```
> **Output:**
> `Modified arr[] : [6, 7, 9, 13, 21, 45, 101, 102]`

To sort an array in descending order, you must use an array of wrapper classes (e.g., `Integer` instead of `int`) because `Collections.reverseOrder()` does not work with primitive types.

> [!example] Sorting an Array in Descending Order
> 
> ```java
> import java.util.Arrays;
> import java.util.Collections;
> 
> public class GFG {
>     public static void main(String[] args) {
>         // Note that we have Integer here instead of int[]
>         Integer[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
> 
>         // Sorts arr[] in descending order
>         Arrays.sort(arr, Collections.reverseOrder());
> 
>         System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
>     }
> }
> ```
> **Output:**
> `Modified arr[] : [100, 45, 21, 13, 9, 7, 6, 2]`

### Way 3: Using `sort()` method of Collections class

The `Collections.sort()` method is designed to sort objects in collections such as `ArrayList` and `LinkedList`.

> [!example] Sorting a List in Ascending Order
> 
> ```java
> import java.util.*;
> 
> public class GFG {
>     public static void main(String[] args) {
>         // Create a list of strings
>         ArrayList<String> al = new ArrayList<String>();
>         al.add("Geeks For Geeks");
>         al.add("Friends");
>         al.add("Dear");
>         al.add("Is");
>         al.add("Superb");
> 
>         /* Collections.sort method is sorting the
>         elements of ArrayList in ascending order. */
>         Collections.sort(al);
> 
>         // Let us print the sorted list
>         System.out.println("List after the use of" + " Collection.sort() :\n" + al);
>     }
> }
> ```
> **Output:**
> `List after the use of Collection.sort() :`
> `[Dear, Friends, Geeks For Geeks, Is, Superb]`

> [!example] Sorting a List in Descending Order
> 
> ```java
> import java.util.*;
> 
> public class GFG {
>     public static void main(String[] args) {
>         // Create a list of strings
>         ArrayList<String> al = new ArrayList<String>();
>         al.add("Geeks For Geeks");
>         al.add("Friends");
>         al.add("Dear");
>         al.add("Is");
>         al.add("Superb");
> 
>         /* Collections.sort method is sorting the
>         elements of ArrayList in descending order. */
>         Collections.sort(al, Collections.reverseOrder());
> 
>         // Let us print the sorted list
>         System.out.println("List after the use of" + " Collection.sort() :\n" + al);
>     }
> }
> ```
> **Output:**
> `List after the use of Collection.sort() :`
> `[Superb, Is, Geeks For Geeks, Friends, Dear]`

### Way 4: Sorting only a subarray

You can sort a specific portion of an array using the `Arrays.sort()` method by specifying the start and end indices.

> [!example] Sorting a Subarray
> This example sorts the elements from index `1` to `4` (exclusive of the end index), leaving other elements untouched.
> 
> ```java
> import java.util.Arrays;
> 
> public class GFG {
>     public static void main(String[] args) {
>         // Custom input array
>         int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };
> 
>         // Sort subarray from index 1 to 4, i.e.,
>         // only sort subarray {7, 6, 45, 21} and
>         // keep other elements as it is.
>         Arrays.sort(arr, 1, 5);
> 
>         // Printing sorted array
>         System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
>     }
> }
> ```
> **Output:**
> `Modified arr[] : [13, 6, 7, 21, 45, 9, 2, 100]`

### Important Notes on Sorting in Java

> [!tip] Sorting Algorithms and Order
> *   **Algorithm:** In the latest versions of Java, both `Arrays.sort()` and `Collections.sort()` use **Timsort**. (Previously, `Arrays.sort` used Quicksort for primitives and Merge sort for objects).
> *   **Default Order:** Sorting is done in **ascending order** by default.
> *   **Descending Order:** To sort in descending order, use `Collections.reverseOrder()`.
> *   **Custom Sort:** To implement your own sorting logic (e.g., Quick Sort, Merge Sort), specific algorithm implementations must be written manually.