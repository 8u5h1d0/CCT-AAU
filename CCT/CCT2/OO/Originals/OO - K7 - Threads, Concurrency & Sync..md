---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: The concept of threading and their life cycle | Creating and managing threads | Design and implementation of threads | Pitfalls and how to avoid the most common ones
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - Geekforgeeks - Java Threads
  - Geekforgeeks - Sync. in Java
  - Oracle - Docs
Created:
---
  
# Java Threads
A Java thread is the smallest unit of execution within a program. It is a lightweight subprocess that runs independently but shares the same memory space as the process, allowing multiple tasks to execute concurrently.
## Create Threads in Java

There are two main approaches to creating threads in Java:

### 1. By Extending Thread Class

To create a thread by extending the Thread class:

1. Create a class that extends `Thread`
2. Override the `run()` method with the code the thread should execute
3. Create an object of your class
4. Call the `start()` method, which internally calls `run()` in a new thread

>[!example] Example: Extending Thread Class
>```java
>class MyThread extends Thread {
>    // Override run method for Thread execution
>    public void run() {
>        String str = "Thread Started Running...";
>        System.out.println(str);
>    }
>}
>
>public class Geeks {
>    public static void main(String args[]) {
>        MyThread t1 = new MyThread();
>        t1.start(); // Starts the thread
>    }
>}
>```
>
>**Output:**
>```
>Thread Started Running...
>```

### 2. Using Runnable Interface

To create a thread by implementing the Runnable interface:

1. Create a class that implements `Runnable`
2. Override the `run()` method with the code for the thread
3. Create a `Thread` object, passing your Runnable object to its constructor
4. Call `start()` on the Thread object

>[!example] Example: Implementing Runnable Interface
>```java
>class MyThread implements Runnable {
>    // Override run method to define thread behavior
>    public void run() {
>        String str = "Thread is Running Successfully";
>        System.out.println(str);
>    }
>}
>
>public class Geeks {
>    public static void main(String[] args) {
>        MyThread g1 = new MyThread();
>        // Create Thread object with Runnable
>        Thread t1 = new Thread(g1);
>        // Start the thread
>        t1.start();
>    }
>}
>```
>
>**Output:**
>```
>Thread is Running Successfully
>```

>[!tip] Choosing Between Thread and Runnable
>- Extend `Thread` when you don't need to extend any other class
>- Implement `Runnable` when your class already extends another class (preferred in most cases)

## Life Cycle of a Thread

During its thread life cycle, a Java thread transitions through several states from creation to termination:

- **New State** - Thread is created but not yet started
- **Runnable State** - Thread is ready to run or currently running
- **Blocked State** - Thread is blocked waiting for a monitor lock
- **Waiting State** - Thread is waiting indefinitely for another thread
- **Timed Waiting State** - Thread is waiting for a specified period
- **Terminated State** - Thread has completed execution

## Running Threads in Java

There are two methods used for running threads in Java:

- **`run()` Method** - Contains the code for the thread. Calling it directly behaves like a normal method call (no new thread is created)
- **`start()` Method** - Launches a new thread and internally calls `run()` concurrently

>[!example] Example: Using Thread Class and Runnable Interface
>```java
>// Thread class implementation
>class ThreadImpl extends Thread {
>    @Override
>    public void run() {
>        System.out.println("Thread Class Running");
>    }
>}
>
>// Runnable interface implementation
>class RunnableThread implements Runnable {
>    @Override
>    public void run() {
>        System.out.println("Runnable Thread Running");
>    }
>}
>
>public class Geeks {
>    public static void main(String[] args) {
>        // Create and start Thread class thread
>        ThreadImpl t1 = new ThreadImpl();
>        t1.start();
>
>        // Create and start Runnable interface thread
>        RunnableThread r = new RunnableThread();
>        Thread t2 = new Thread(r);
>        t2.start();
>
>        // Wait for both threads to complete
>        try {
>            t1.join(); // Wait for t1 to finish
>            t2.join(); // Wait for t2 to finish
>        } catch (InterruptedException e) {
>            e.printStackTrace();
>        }
>    }
>}
>```
>
>**Output:**
>```
>Thread Class Running
>Runnable Thread Running
>```

>[!important] `start()` vs `run()`
>Use `start()` to launch a new thread, which then calls the `run()` method in parallel. If you call `run()` directly, it works like a normal method call and no new thread is created.

## Java Thread Class

The Thread class is used to create and control threads in Java. Each object of this class represents a single thread of execution.

>[!info] Thread Class Definition
>```java
>public class Thread extends Object implements Runnable
>```

### Advantages of Threads

- **Improved performance** - Multiple threads can execute tasks concurrently
- **Better resource utilization** - Threads share the same memory and resources
- **Responsive applications** - UI applications remain responsive while performing background tasks

---

_A Java thread is the smallest unit of execution within a program. It is a lightweight subprocess that runs independently but shares the same memory space as the process, allowing multiple tasks to execute concurrently._

# Synchronization in Java

_Synchronization in Java is a mechanism that ensures that only one thread can access a shared resource (like a variable, object, or method) at a time. It prevents concurrent threads from interfering with each other while modifying shared data._

## Why is Synchronization Needed?

- **Prevents Data Inconsistency** - Ensures that multiple threads don't corrupt shared data when accessing it simultaneously
- **Avoids Race Conditions** - Allows only one thread to execute a critical section at a time, maintaining predictable results
- **Maintains Thread Safety** - Protects shared resources from concurrent modification by multiple threads
- **Ensures Data Integrity** - Keeps shared data accurate and consistent throughout program execution

## Ways to Achieve Synchronization

### 1. Synchronized Methods

A synchronized method ensures that only one thread can execute it at a time on the same object instance.

>[!example] Example: Synchronized Methods
>```java
>class Counter {
>    private int c = 0; // Shared variable
>
>    // Synchronized method to increment counter
>    public synchronized void inc() {
>        c++;
>    }
>
>    // Synchronized method to get counter value
>    public synchronized int get() {
>        return c;
>    }
>}
>
>public class Geeks {
>    public static void main(String[] args) {
>        Counter cnt = new Counter(); // Shared resource
>
>        Thread t1 = new Thread(() -> {
>            for (int i = 0; i < 1000; i++)
>                cnt.inc();
>        });
>
>        Thread t2 = new Thread(() -> {
>            for (int i = 0; i < 1000; i++)
>                cnt.inc();
>        });
>
>        t1.start();
>        t2.start();
>
>        try {
>            t1.join();
>            t2.join();
>        } catch (InterruptedException e) {
>            e.printStackTrace();
>        }
>
>        System.out.println("Counter: " + cnt.get());
>    }
>}
>```
>
>**Output:**
>```
>Counter: 2000
>```
>
>**Explanation:** Both threads increment the same counter concurrently. Since the `inc()` and `get()` methods are synchronized, only one thread can access them at a time, ensuring the correct final count.

### 2. Synchronized Blocks

Instead of synchronizing an entire method, Java allows synchronization on specific blocks of code. This improves performance by locking only the necessary section.

>[!example] Example: Synchronized Blocks
>```java
>class Counter {
>    private int c = 0;
>
>    public void inc() {
>        // Synchronize only this block
>        synchronized (this) {
>            c++;
>        }
>    }
>
>    public int get() {
>        return c;
>    }
>}
>
>public class Geeks {
>    public static void main(String[] args) throws InterruptedException {
>        Counter cnt = new Counter();
>
>        Thread t1 = new Thread(() -> {
>            for (int i = 0; i < 1000; i++)
>                cnt.inc();
>        });
>
>        Thread t2 = new Thread(() -> {
>            for (int i = 0; i < 1000; i++)
>                cnt.inc();
>        });
>
>        t1.start();
>        t2.start();
>        t1.join();
>        t2.join();
>
>        System.out.println("Counter: " + cnt.get());
>    }
>}
>```
>
>**Output:**
>```
>Counter: 2000
>```
>
>**Explanation:** The synchronized block ensures mutual exclusion only for the increment statement, reducing the locking overhead.

### 3. Static Synchronization

Static synchronization is used to synchronize static methods. In this case, the lock is placed on the class object rather than the instance.

>[!example] Example: Static Synchronization
>```java
>class Table {
>    synchronized static void printTable(int n) {
>        for (int i = 1; i <= 3; i++) {
>            System.out.println(n * i);
>            try {
>                // Intentionally empty catch block in original
>            } catch (Exception e) {
>                System.out.println(e);
>            }
>        }
>    }
>}
>
>class Thread1 extends Thread {
>    public void run() {
>        Table.printTable(1);
>    }
>}
>
>class Thread2 extends Thread {
>    public void run() {
>        Table.printTable(10);
>    }
>}
>
>public class GFG {
>    public static void main(String[] args) {
>        Thread1 t1 = new Thread1();
>        Thread2 t2 = new Thread2();
>        t1.start();
>        t2.start();
>    }
>}
>```
>
>**Output:**
>```
>1
>2
>3
>10
>20
>30
>```
>
>**Explanation:** Both threads t1 and t2 call the static synchronized method `printTable()`. The lock is applied to the `Table.class` object, ensuring that only one thread can access the method at a time, even if no object instance is shared.

## Types of Synchronization

There are two types of synchronizations in Java:

### 1. Process Synchronization

Process Synchronization is a technique used to coordinate the execution of multiple processes. It ensures that the shared resources are safe and in order.

>[!example] Example: Bank Account Operations
>```java
>class BankAccount {
>    private int balance = 1000; // Shared resource (bank balance)
>
>    // Synchronized method for deposit operation
>    public synchronized void deposit(int amount) {
>        balance += amount;
>        System.out.println("Deposited: " + amount + ", Balance: " + balance);
>    }
>
>    // Synchronized method for withdrawal operation
>    public synchronized void withdraw(int amount) {
>        if (balance >= amount) {
>            balance -= amount;
>            System.out.println("Withdrawn: " + amount + ", Balance: " + balance);
>        } else {
>            System.out.println("Insufficient balance to withdraw: " + amount);
>        }
>    }
>
>    public int getBalance() {
>        return balance;
>    }
>}
>
>public class Geeks {
>    public static void main(String[] args) {
>        BankAccount account = new BankAccount(); // Shared resource
>
>        // Thread 1 to deposit money into the account
>        Thread t1 = new Thread(() -> {
>            for (int i = 0; i < 3; i++) {
>                account.deposit(200);
>                try {
>                    Thread.sleep(50); // Simulate some delay
>                } catch (InterruptedException e) {
>                    e.printStackTrace();
>                }
>            }
>        });
>
>        // Thread 2 to withdraw money from the account
>        Thread t2 = new Thread(() -> {
>            for (int i = 0; i < 3; i++) {
>                account.withdraw(100);
>                try {
>                    Thread.sleep(100); // Simulate some delay
>                } catch (InterruptedException e) {
>                    e.printStackTrace();
>                }
>            }
>        });
>
>        // Start both threads
>        t1.start();
>        t2.start();
>
>        // Wait for threads to finish
>        try {
>            t1.join();
>            t2.join();
>        } catch (InterruptedException e) {
>            e.printStackTrace();
>        }
>
>        // Print final balance
>        System.out.println("Final Balance: " + account.getBalance());
>    }
>}
>```
>
>**Output:**
>```
>Deposited: 200, Balance: 1200
>Withdrawn: 100, Balance: 1100
>Deposited: 200, Balance: 1300
>Deposited: 200, Balance: 1500
>Withdrawn: 100, Balance: 1400
>Withdrawn: 100, Balance: 1300
>Final Balance: 1300
>```
>
>**Explanation:** Two threads perform deposit and withdrawal operations simultaneously. The synchronized methods prevent race conditions, ensuring consistent balance updates.

### 2. Thread Synchronization in Java

Thread Synchronization is used to coordinate and ordering of the execution of the threads in a multi-threaded program. There are two types of thread synchronization:

- **Mutual Exclusive** - Only one thread can access the shared resource at a time
- **Cooperation** - Inter-thread communication in Java

>[!example] Example: Ticket Booking System
>```java
>class TicketBooking {
>    private int availableTickets = 10; // Shared resource (available tickets)
>
>    // Synchronized method for booking tickets
>    public synchronized void bookTicket(int tickets) {
>        if (availableTickets >= tickets) {
>            availableTickets -= tickets;
>            System.out.println("Booked " + tickets + 
>                " tickets, Remaining tickets: " + availableTickets);
>        } else {
>            System.out.println("Not enough tickets available to book " + tickets);
>        }
>    }
>
>    public int getAvailableTickets() {
>        return availableTickets;
>    }
>}
>
>public class Geeks {
>    public static void main(String[] args) {
>        TicketBooking booking = new TicketBooking(); // Shared resource
>
>        // Thread 1 to book tickets
>        Thread t1 = new Thread(() -> {
>            for (int i = 0; i < 2; i++) {
>                booking.bookTicket(2); // Trying to book 2 tickets each time
>                try {
>                    Thread.sleep(50); // Simulate delay
>                } catch (InterruptedException e) {
>                    e.printStackTrace();
>                }
>            }
>        });
>
>        // Thread 2 to book tickets
>        Thread t2 = new Thread(() -> {
>            for (int i = 0; i < 2; i++) {
>                booking.bookTicket(3); // Trying to book 3 tickets each time
>                try {
>                    Thread.sleep(40); // Simulate delay
>                } catch (InterruptedException e) {
>                    e.printStackTrace();
>                }
>            }
>        });
>
>        // Start both threads
>        t1.start();
>        t2.start();
>
>        // Wait for threads to finish
>        try {
>            t1.join();
>            t2.join();
>        } catch (InterruptedException e) {
>            e.printStackTrace();
>        }
>
>        // Print final remaining tickets
>        System.out.println("Final Available Tickets: " + 
>            booking.getAvailableTickets());
>    }
>}
>```
>
>**Output:**
>```
>Booked 2 tickets, Remaining tickets: 8
>Booked 3 tickets, Remaining tickets: 5
>Booked 3 tickets, Remaining tickets: 2
>Booked 2 tickets, Remaining tickets: 0
>Final Available Tickets: 0
>```
>
>**Explanation:** The synchronized `bookTicket()` method ensures that only one thread books tickets at a time, preventing overbooking and ensuring correct availability.

## Volatile Keyword

The `volatile` keyword in Java ensures that all threads have a consistent view of a variable's value. It prevents caching of the variable's value by threads, ensuring that updates to the variable are immediately visible to other threads.

>[!info] Working of Volatile Modifier
>- It applies only to variables
>- `volatile` guarantees visibility - any write to a volatile variable is immediately visible to other threads
>- It does not guarantee atomicity, meaning operations like `count++` (read-modify-write operations) can still result in inconsistent values

>[!example] Example: Volatile Keyword
>```java
>class Counter {
>    private volatile boolean running = true;
>
>    public void stop() {
>        running = false;
>    }
>
>    public void start() {
>        new Thread(() -> {
>            while (running) {
>                System.out.println("Running...");
>                try {
>                    Thread.sleep(200);
>                } catch (InterruptedException e) {
>                    Thread.currentThread().interrupt();
>                }
>            }
>            System.out.println("Stopped.");
>        }).start();
>    }
>}
>
>public class Geeks {
>    public static void main(String[] args) throws InterruptedException {
>        Counter counter = new Counter();
>        counter.start();
>
>        Thread.sleep(600); // Let it run briefly
>        counter.stop();    // Then stop the thread
>    }
>}
>```
>
>**Output:**
>```
>Running...
>Running...
>Running...
>Stopped.
>```
>
>**Explanation:** The volatile variable `running` ensures that updates made by one thread (in `stop()`) are visible to the thread running the loop in `start()`.

## Volatile vs Synchronized

| **Features** | **Synchronized** | **Volatile** |
|---|---|---|
| **Applies to** | It applies only to blocks or methods | It applies to variables only |
| **Purpose** | It ensures mutual exclusion and visibility | It ensures visibility of changes to variables across threads |
| **Performance** | Performance is relatively low compared to volatile because of the acquisition and release of the lock | Performance is relatively high compared to synchronized keyword |
# Defining and Starting a Thread

An application that creates an instance of `Thread` must provide the code that will run in that thread. There are two ways to do this:

## Two Approaches to Creating Threads

### 1. Provide a Runnable Object

The `Runnable` interface defines a single method, `run`, meant to contain the code executed in the thread. The `Runnable` object is passed to the `Thread` constructor.

>[!example] Example: Using Runnable Interface
>```java
>public class HelloRunnable implements Runnable {
>
>    public void run() {
>        System.out.println("Hello from a thread!");
>    }
>
>    public static void main(String args[]) {
>        (new Thread(new HelloRunnable())).start();
>    }
>}
>```

### 2. Subclass Thread

The `Thread` class itself implements `Runnable`, though its `run` method does nothing. An application can subclass `Thread`, providing its own implementation of `run`.

>[!example] Example: Subclassing Thread
>```java
>public class HelloThread extends Thread {
>
>    public void run() {
>        System.out.println("Hello from a thread!");
>    }
>
>    public static void main(String args[]) {
>        (new HelloThread()).start();
>    }
>}
>```

>[!important] Starting the Thread
>Notice that both examples invoke `Thread.start()` in order to start the new thread.

## Which Approach Should You Use?

The **first idiom** (employing a `Runnable` object) is more general, because the `Runnable` object can subclass a class other than `Thread`. 

The **second idiom** is easier to use in simple applications, but is limited by the fact that your task class must be a descendant of `Thread`.

>[!tip] Recommended Approach
>The lesson focuses on the first approach (using `Runnable`), which separates the `Runnable` task from the `Thread` object that executes the task. Not only is this approach more flexible, but it is applicable to the high-level thread management APIs covered later.

## Thread Class Methods

The `Thread` class defines a number of methods useful for thread management. These include:

- **`static` methods** - Provide information about, or affect the status of, the thread invoking the method
- **Other methods** - Invoked from other threads involved in managing the thread and `Thread` object