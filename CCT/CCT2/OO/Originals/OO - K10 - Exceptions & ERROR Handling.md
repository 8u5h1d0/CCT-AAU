---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: Errors and faults | Handling errors using exceptions (throwing and catching exceptions) | Generating our own exceptions | Example cases
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - Geekforgeeks - Exceptions in Java
  - w3schools - Types of Exceptions
  - Tutorialspoint - Java Exceptions
  - Tutorialspoint - Java Built-in Exceptions
Created: 18-03-2026
---
# Java Exception Handling
Exception Handling in Java is a mechanism used to handle runtime errors so that the normal flow of the program can continue without crashing.

- Handles abnormal conditions that occur during program execution.
- Helps maintain program stability by preventing unexpected termination.
![[Pasted image 20260318150827.png]]
![[Pasted image 20260318150836.png]]
![[Pasted image 20260318150841.png]]
### Basic try-catch Example

- The try block contains code that might throw an exception,
- The catch block handles the exception if it occurs.

class Geeks{

    public static void main(String[] args) {

        int n = 10;

        int m = 0;

​

        try {

            int ans = n / m;

            System.out.println("Answer: " + ans);

        } catch (ArithmeticException e){

            System.out.println("Error: Division by 0!");

        } 

    }

}

  
**Output**

Error: Division by 0!

### Finally Block

The finally block executes after the try and catch blocks in most situations, whether an exception arised or not. It is typically used for closing resources such as database connections, open files, or network connections.

Finally may not execute in cases like:

- System.exit()
- JVM crash
- infinite loop before finally

class FinallyExample {

    public static void main(String[] args){

        int[] numbers = { 1, 2, 3 };

        try {

            // This will throw ArrayIndexOutOfBoundsException

            System.out.println(numbers[5]);

        }

        catch (ArrayIndexOutOfBoundsException e){

            System.out.println("Exception caught: " + e);

        }

        finally{

            System.out.println("This block always executes.");

        }

        System.out.println("Program continues...");

    }

}

  
**Output**

Exception caught: java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
This block always executes.
Program continues...

### throw and throws Keywords

****1. throw:**** Used to explicitly throw a single exception. We use `throw` when something goes wrong (or “shouldn’t happen”) and we want to stop normal flow and hand control to exception handling.

`class Demo {     static void checkAge(int age) {                  if (age < 18) {             throw new IllegalArgumentException("Age must be 18 or above");         }     }      public static void main(String[] args) {                  checkAge(15);     } }`

****Output:****

> Exception in thread "main" java.lang.IllegalArgumentException: Age must be 18 or above
> 	at Demo.checkAge(Demo.java:5)
> 	at Demo.main(Demo.java:11)

****2. throws:**** Declares exceptions that a method might throw, informing the caller to handle them. It is mainly used with checked exceptions (explained below). If a method calls another method that throws a checked exception, and it doesn’t catch it, it must declare that exception in its `throws` clause

import java.io.*;

​

class Demo {

​

    // Method declares that it may throw IOException

    static void readFile(String fileName) throws IOException {

​

        // Using try-with-resources to automatically close FileReader

        try (FileReader file = new FileReader(fileName)) {

            int data;

            while ((data = file.read()) != -1) {

                System.out.print((char) data); // Read and print file content

            }

        }

        // No need for finally block to close the resource

    }

​

    public static void main(String[] args) {

​

        try {

            readFile("test.txt"); // Attempt to read file

        } catch (IOException e) {

            System.out.println("File not found or error reading file: " + e.getMessage());

        }

​

        System.out.println("\nProgram continues after file operation.");

    }

}

  
**Output**

File not found or error reading file: test.txt (No such file or directory)

Program continues after file operation.

****Internal Working of try-catch Block:****

- JVM executes code inside the `try` block.
- If an exception occurs, remaining `try` code is skipped and JVM searches for a matching `catch` block.
- If found, the `catch` block executes.
- Control then moves to the `finally` block (if present).
- If no matching `catch` is found, the exception is handled by JVM’s default handler.
- The `finally` block always executes, whether an exception occurs or not.

> ****Note:**** When an exception occurs and is not handled, the program terminates abruptly and the code after it, will never execute.

## Java Exception Hierarchy

In Java, all exceptions and errors are subclasses of the Throwable class. It has two main branches

1. Exception.
2. Error

The below figure demonstrates the exception hierarchy in Java:
![[Pasted image 20260318150854.png]]
## Types of Java Exceptions

Java defines several types of exceptions that relate to its various class libraries. Java also allows users to define their it's exceptions.
![[Pasted image 20260318150900.png]]
### 1. Built-in Exception

Built-in Exception are pre-defined exception classes provided by Java to handle common errors during program execution. There are two type of built-in exception in java.

- ****Checked Exception:**** These exceptions are checked at compile time, forcing the programmer to handle them explicitly.
- ****Unchecked Exception:**** These exceptions are checked at runtime and do not require explicit handling at compile time.

> To know more about Checked and Unchecked Exception -> [Checked and Unchecked Exception](https://www.geeksforgeeks.org/java/java-checked-vs-unchecked-exceptions/)

### 2. User-Defined Exception

Sometimes, the built-in exceptions in Java are not able to describe a certain situation. In such cases, users can also create exceptions, which are called "user-defined Exceptions".

## Methods to Print the Exception Information

- [****printStackTrace()****](https://www.geeksforgeeks.org/java/throwable-printstacktrace-method-in-java-with-examples/)****:**** Prints the full stack trace of the exception, including the name, message and location of the error.
- [****toString()****](https://www.geeksforgeeks.org/java/throwable-tostring-method-in-java-with-examples/)****:**** Prints exception information in the format of the Name of the exception.
- [****getMessage()****](https://www.geeksforgeeks.org/java/throwable-getmessage-method-in-java-with-examples/) ****:**** Prints the description of the exception

### Nested try-catch

In Java, you can place one try-catch block inside another to handle exceptions at multiple levels.
public class NestedTryExample {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try block");
            try {
                int a = 10 / 0; // This causes ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e);
            }
            String str = null;
            System.out.println(str.length()); // This causes NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Outer catch: " + e);
        }
    }
}
**Output**
```
Outer try block
Inner catch: java.lang.ArithmeticException: / by zero
Outer catch: java.lang.NullPointerException: Cannot invoke "String.length()" because "<local1>" is null
```
### Handling Multiple Exception

We can handle multiple type of exceptions in Java by using multiple catch blocks, each catching a different type of exception.
try {
    
    // Code that may throw an exception
    
} catch (ArithmeticException e) {
    
    // Code to handle the exception
    
} catch(ArrayIndexOutOfBoundsException e){
    
    // Code to handle the another exception
    
}catch(NumberFormatException e){
    
     // Code to handle the another exception
}
## How Does JVM Handle an Exception?

When an Exception occurs, the JVM creates an exception object containing the error name, description, and program state. Throwing an exception means creating an exception object and transferring control to the nearest appropriate exception handler using the throw keyword. There might be a list of the methods that had been called to get to the method where an exception occurred. This ordered list of methods is called call stack. Now the following procedure will happen:

- The run-time system searches the call stack for an exception handler
- It starts searching from the method where the exception occurred and proceeds backward through the call stack.
- If a handler is found, the exception is passed to it.
- If no handler is found, the default exception handler terminates the program and prints the stack trace.

> Exception in thread "abc" Name of Exception : Description  
> // Call Stack

Look at the below diagram to understand the flow of the call stack:

****Illustration****:
class Geeks{

    public static void main(String args[])
    {
        // Taking an empty string
        String s = null;
      
        // Getting length of a string
        System.out.println(s.length());
    }
}
****Output:****
![[Pasted image 20260318151246.png]]
### Difference Between Exception and Error

|Feature|Exception|Error|
|---|---|---|
|Definition|An event that occurs during program execution, disrupting normal flow, which can be handled using try-catch.|A serious problem that occurs in the JVM, generally cannot be handled by the application.|
|Package|java.lang.Exception|java.lang.Error|
|Recoverable|Yes, can be caught and handled.|No, usually not recoverable.|
|Examples|IOException, SQLException, ArithmeticException|OutOfMemoryError, StackOverflowError|
# Types of Exceptions
## Introduction

Java is an object oriented programming language. The exception is object created at the time of exceptional/error condition which will be thrown from the program and halt normal execution of the program. Java exceptions object hierarchy is as below:
![[Pasted image 20260318151335.png]]
All exception types are subclasses of the built-in class Throwable. Thus, Throwable is at the top of the exception class hierarchy. Immediately below Throwable are two subclasses that partition exceptions into two distinct branches. One branch is headed by Exception. This classic used for exceptional conditions that user programs should catch. This is also the class that you will subclass to create your own custom exception types. There is an important subclass of Exception, called RuntimeException. Exceptions of this type are automatically defined for the programs that you write and include things such as division by zero and invalid array indexing.

The other branch is topped by Error, which defines exceptions that are not expected to be caught under normal circumstances by your program. Exceptions of type Error are used by the Java runtime system to indicate errors having to do with the runtime environment,itself. Stack overflow is an example of such an error. This chapter will not be dealing with exceptions of type Error, because these are typically created in response to catastrophic failures that cannot usually be handled by your program.

Java’s exceptions can be categorized into two types:

- Checked exceptions
- Unchecked exceptions

Generally, checked exceptions are subject to the catch or specify a requirement, which means they require catching or declaration. This requirement is optional for unchecked exceptions. Code that uses a checked exception will not compile if the catch or specify rule is not followed.

Unchecked exceptions come in two types:

- Errors
- Runtime exceptions

**Checked Exceptions**

Checked exceptions are the type that programmers should anticipate and from which programs should be able to recover. All Java exceptions are checked exceptions except those of the Error and RuntimeException classes and their subclasses.

A checked exception is an exception which the Java source code must deal with, either by catching it or declaring it to be thrown. Checked exceptions are generally caused by faults outside of the code itself - missing resources, networking errors, and problems with threads come to mind. These could include subclasses of FileNotFoundException, UnknownHostException, etc.

Popular Checked Exceptions:

|Name|Description|
|---|---|
|IOException|While using file input/output stream related exception|
|SQLException.|While executing queries on database related to SQL syntax|
|DataAccessException|Exception related to accessing data/database|
|ClassNotFoundException|Thrown when the JVM can’t find a class it needs, because of a command-line error, a classpath issue, or a missing .class file|
|InstantiationException|Attempt to create an object of an abstract class or interface.|

Below example program of reading, file shows how checked exception should be handled. Below image shows compile time error due to checked exception (FileNotFoundException and IO Exception) related to file operation. IDE suggests either we need to enclose our code inside try-catch block or we can use throws keyword in the method declaration.
![[Pasted image 20260318151345.png]]
We will update the method declaration with throws keyword and calling method (main method) will have to handle this exception. I will explain file reading part in detail in file I/O tutorial, here we will concentrate more on exception part. While running the program we can encounter two types of problems (1) File is missing or not present, which we are trying to read (2) User does not have read permission on file or file is locked by some other user. As we are expecting two different type of exceptions we have to catch both exceptions or we can have one catch block which is catching super-class Exception. Below code shows multiple catch block syntax.
Java Code:
import java.io.FileInputStream; import java.io.FileNotFoundException; import java.io.IOException; public class CheckedExceptionDemo { public static void main(String[] args) { //Below line calls readFile method and prints content of it String filename="test.txt"; try { String fileContent = new CheckedExceptionDemo().readFile(filename); System.out.println(fileContent); } catch (FileNotFoundException e) { System.out.println("File:"+ filename+" is missing, Please check file name"); } catch (IOException e) { System.out.println("File is not having permission to read, please check the permission"); } } public String readFile(String filename)throws FileNotFoundException, IOException{ FileInputStream fin; int i; String s=""; fin = new FileInputStream(filename); // read characters until EOF is encountered do { i = fin.read(); if(i != -1) s =s+(char) i+""; } while(i != -1); fin.close(); return s; } }
**Output: If test.txt is not found:**
![[Pasted image 20260318151415.png]]
Running the program after creating test.txt file inside project root folder
![[Pasted image 20260318151423.png]]
**Unchecked Exceptions**

Unchecked exceptions inherit from the Error class or the RuntimeException class. Many programmers feel that you should not handle these exceptions in your programs because they represent the type of errors from which programs cannot reasonably be expected to recover while the program is running.

When an unchecked exception is thrown, it is usually caused by a misuse of code - passing a null or otherwise incorrect argument.

Popular Unchecked Exceptions:

|Name|Description|
|---|---|
|NullPointerException|Thrown when attempting to access an object with a reference variable whose current value is null|
|ArrayIndexOutOfBound|Thrown when attempting to access an array with an invalid index value (either negative or beyond the length of the array)|
|IllegalArgumentException.|Thrown when a method receives an argument formatted differently than the method expects.|
|IllegalStateException|Thrown when the state of the environment doesn’t match the operation being attempted,e.g., using a Scanner that’s been closed.|
|NumberFormatException|Thrown when a method that converts a String to a number receives a String that it cannot convert.|
|ArithmaticException|Arithmetic error, such as divide-by-zero.|

We had seen sample program of runtime exception of divide by zero in last tutorial here we will see other program, which will take user age as input and grant access if age is more than 18 years. Here user input is expected in numeric form if user input is other alphabetic then our program will end in exception condition(InputMismatchException). This exception occurs at runtime. We can decide to handle it programmatically but it is not mandatory to handle. Runtime exceptions are good to handle using try-catch block and avoid error situation.

Java Code:
```java
import java.util.Scanner;
public class RunTimeExceptionDemo {
	public static void main(String[] args) {
		//Reading user input
		Scanner inputDevice = new Scanner(System.in);
		System.out.print("Please enter your age- Numeric value: ");
		int age = inputDevice.nextInt();
		if (age>18){
			System.out.println("You are authorized to view the page");
			//Other business logic
		}else {
			System.out.println("You are not authorized to view page");
			//Other code related to logout
		}
	}

}
```
Output:
![[Pasted image 20260318151441.png]]
If User enters non-numeric value, program ends in error/exceptional condition.
![[Pasted image 20260318151448.png]]
**Summary:**

- Loop condition/expression can be true always, which makes our loop infinite. This is bad programming practice as it might result in memory exception. Below statement is valid but not good to have in our program.
- In terms of Functionality Checked and Unchecked Exception are same.
- Checked Exception handling verified during compile time while Unchecked Exception is mostly programming errors
- JDK7 provides improved Exception handling code with catching multiple Exceptions in one catch block and reduce the amount of lines of code required for exception handling.

# Java - Exceptions
## What Is an Exception in Java?

An exception (or exceptional event) is a problem that arises during the execution of a program. When an **Exception** occurs the normal flow of the program is disrupted and the program/Application terminates abnormally, which is not recommended, therefore, these exceptions are to be handled.

## Why Exception Occurs?

An exception can occur for many different reasons. Following are some scenarios where an exception occurs.

- A user has entered an invalid data.
    
- A file that needs to be opened cannot be found.
    
- A network connection has been lost in the middle of communications or the JVM has run out of memory.
    

Some of these exceptions are caused by user error, others by programmer error, and others by physical resources that have failed in some manner.

## Java Exception Categories

Based on these, we have the following categories of Exceptions. You need to understand them to know how exception handling works in Java.

- Checked exceptions
- Unchecked exceptions
- Errors

### Java Checked Exceptions

A checked exception is an exception that is checked (notified) by the compiler at compilation-time, these are also called as compile time exceptions. These exceptions cannot simply be ignored, the programmer should take care of (handle) these exceptions.

#### Example: Checked Exceptions in Java

For example, if you use **FileReader** class in your program to read data from a file, if the file specified in its constructor doesn't exist, then a _FileNotFoundException_ occurs, and the compiler prompts the programmer to handle the exception.
import java.io.File; import java.io.FileReader; public class FilenotFound_Demo { public static void main(String args[]) { File file = new File("E://file.txt"); FileReader fr = new FileReader(file); } }
If you try to compile the above program, you will get the following exceptions.

**Output**
C:\>javac FilenotFound_Demo.java
FilenotFound_Demo.java:8: error: unreported exception FileNotFoundException; must be caught or declared to be thrown
      FileReader fr = new FileReader(file);
                      ^
1 error
**Note** − Since the methods **read()** and **close()** of FileReader class throws IOException, you can observe that the compiler notifies to handle IOException, along with FileNotFoundException.

### Java Unchecked Exceptions

An unchecked exception is an exception that occurs at the time of execution. These are also called as Runtime Exceptions. These include programming bugs, such as logic errors or improper use of an API. Runtime exceptions are ignored at the time of compilation.

#### Example: Unchecked Exceptions in Java

For example, if you have declared an array of size 5 in your program, and trying to call the 6th element of the array then an _ArrayIndexOutOfBoundsExceptionexception_ occurs.
public class Unchecked_Demo { public static void main(String args[]) { int num[] = {1, 2, 3, 4}; System.out.println(num[5]); } }
If you compile and execute the above program, you will get the following exception.

**Output**

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
	at Exceptions.Unchecked_Demo.main(Unchecked_Demo.java:8)

### Java Errors

These are not exceptions at all, but problems that arise beyond the control of the user or the programmer. Errors are typically ignored in your code because you can rarely do anything about an error. For example, if a stack overflow occurs, an error will arise. They are also ignored at the time of compilation.

## Java Exception Hierarchy

All exception classes are subtypes of the java.lang.Exception class. The exception class is a subclass of the [Throwable class](https://www.tutorialspoint.com/java/lang/java_lang_throwable.htm). Other than the exception class there is another subclass called Error which is derived from the Throwable class.

Errors are abnormal conditions that happen in case of severe failures, these are not handled by the Java programs. Errors are generated to indicate errors generated by the runtime environment. Example: JVM is out of memory. Normally, programs cannot recover from errors.

The Exception class has two main subclasses: IOException class and RuntimeException Class.
![[Pasted image 20260318151602.png]]
Following is a list of most common checked and unchecked [Java's Built-in Exceptions](https://www.tutorialspoint.com/java/java_builtin_exceptions.htm).

## Java Exception Class Methods

Following is the list of important methods available in the Throwable class.

|Sr.No.|Method & Description|
|---|---|
|1|**public String [getMessage()](https://www.tutorialspoint.com/java/lang/throwable_getmessage.htm)**<br><br>Returns a detailed message about the exception that has occurred. This message is initialized in the Throwable constructor.|
|2|**public Throwable [getCause()](https://www.tutorialspoint.com/java/lang/throwable_getcause.htm)**<br><br>Returns the cause of the exception as represented by a Throwable object.|
|3|**public String [toString()](https://www.tutorialspoint.com/java/lang/throwable_tostring.htm)**<br><br>Returns the name of the class concatenated with the result of getMessage().|
|4|**public void [printStackTrace()](https://www.tutorialspoint.com/java/lang/throwable_printstacktrace.htm)**<br><br>Prints the result of toString() along with the stack trace to System.err, the error output stream.|
|5|**public StackTraceElement [] [getStackTrace()](https://www.tutorialspoint.com/java/lang/throwable_getstacktrace.htm)**<br><br>Returns an array containing each element on the stack trace. The element at index 0 represents the top of the call stack, and the last element in the array represents the method at the bottom of the call stack.|
|6|**public Throwable [fillInStackTrace()](https://www.tutorialspoint.com/java/lang/throwable_fillinstacktrace.htm)**<br><br>Fills the stack trace of this Throwable object with the current stack trace, adding to any previous information in the stack trace.|

## Catching Exceptions: Exception Handling in Java

A method catches an exception using a combination of the **try** and **catch** keywords. A try/catch block is placed around the code that might generate an exception. Code within a try/catch block is referred to as protected code, and the syntax for using try/catch looks like the following −

### Syntax
try { // Protected code } catch (ExceptionName e1) { // Catch block }
The code which is prone to exceptions is placed in the try block. When an exception occurs, that exception occurred is handled by catch block associated with it. Every try block should be immediately followed either by a catch block or finally block.

A catch statement involves declaring the type of exception you are trying to catch. If an exception occurs in protected code, the catch block (or blocks) that follows the try is checked. If the type of exception that occurred is listed in a catch block, the exception is passed to the catch block much as an argument is passed into a method parameter.

### Example: Demonstrating Exception Handling

In following example, an array is declared with 2 elements. Then the code tries to access the 3rd element of the array which throws an exception.
// File Name : ExcepTest.java import java.io.*; public class ExcepTest { public static void main(String args[]) { try { int a[] = new int[2]; System.out.println("Access element three :" + a[3]); } catch (ArrayIndexOutOfBoundsException e) { System.out.println("Exception thrown :" + e); } System.out.println("Out of the block"); } }
**Output**

Exception thrown  :java.lang.ArrayIndexOutOfBoundsException: 3
Out of the block

## Multiple Catch Blocks

A try block can be followed by multiple catch blocks. The syntax for multiple catch blocks looks like the following −

### Syntax
try { // Protected code } catch (ExceptionType1 e1) { // Catch block } catch (ExceptionType2 e2) { // Catch block } catch (ExceptionType3 e3) { // Catch block }
The previous statements demonstrate three catch blocks, but you can have any number of them after a single try. If an exception occurs in the protected code, the exception is thrown to the first catch block in the list. If the data type of the exception thrown matches ExceptionType1, it gets caught there. If not, the exception passes down to the second catch statement. This continues until the exception either is caught or falls through all catches, in which case the current method stops execution and the exception is thrown down to the previous method on the call stack.

### Example

Here is code segment showing how to use multiple try/catch statements.
try { file = new FileInputStream(fileName); x = (byte) file.read(); } catch (IOException i) { i.printStackTrace(); return -1; } catch (FileNotFoundException f) // Not valid! { f.printStackTrace(); return -1; }
## Catching Multiple Type of Exceptions

Since Java 7, you can handle more than one exception using a single catch block, this feature simplifies the code. Here is how you would do it −

catch (IOException|FileNotFoundException ex) {
   logger.log(ex);
   throw ex;

## The Throws/Throw Keywords

If a method does not handle a checked exception, the method must declare it using the **throws** keyword. The throws keyword appears at the end of a method's signature.

You can throw an exception, either a newly instantiated one or an exception that you just caught, by using the **throw** keyword.

Try to understand the difference between throws and throw keywords, _throws_ is used to postpone the handling of a checked exception and _throw_ is used to invoke an exception explicitly.

The following method declares that it throws a RemoteException −

### Example
import java.io.*; public class className { public void deposit(double amount) throws RemoteException { // Method implementation throw new RemoteException(); } // Remainder of class definition }
A method can declare that it throws more than one exception, in which case the exceptions are declared in a list separated by commas. For example, the following method declares that it throws a RemoteException and an InsufficientFundsException −

### Example
import java.io.*; public class className { public void withdraw(double amount) throws RemoteException, InsufficientFundsException { // Method implementation } // Remainder of class definition }
## The Finally Block

The finally block follows a try block or a catch block. A finally block of code always executes, irrespective of occurrence of an Exception.

Using a finally block allows you to run any cleanup-type statements that you want to execute, no matter what happens in the protected code.

A finally block appears at the end of the catch blocks and has the following syntax −

### Syntax
try { // Protected code } catch (ExceptionType1 e1) { // Catch block } catch (ExceptionType2 e2) { // Catch block } catch (ExceptionType3 e3) { // Catch block }finally { // The finally block always executes. }
### Example
public class ExcepTest { public static void main(String args[]) { int a[] = new int[2]; try { System.out.println("Access element three :" + a[3]); } catch (ArrayIndexOutOfBoundsException e) { System.out.println("Exception thrown :" + e); }finally { a[0] = 6; System.out.println("First element value: " + a[0]); System.out.println("The finally statement is executed"); } } }
**Output**

Exception thrown  :java.lang.ArrayIndexOutOfBoundsException: 3
First element value: 6
The finally statement is executed

Note the following −

- A catch clause cannot exist without a try statement.
    
- It is not compulsory to have finally clauses whenever a try/catch block is present.
    
- The try block cannot be present without either catch clause or finally clause.
    
- Any code cannot be present in between the try, catch, finally blocks.
    

## The try-with-resources

Generally, when we use any resources like streams, connections, etc. we have to close them explicitly using finally block. In the following program, we are reading data from a file using **FileReader** and we are closing it using finally block.

### Example
import java.io.File; import java.io.FileReader; import java.io.IOException; public class ReadData_Demo { public static void main(String args[]) { FileReader fr = null; try { File file = new File("file.txt"); fr = new FileReader(file); char [] a = new char[50]; fr.read(a); // reads the content to the array for(char c : a) System.out.print(c); // prints the characters one by one } catch (IOException e) { e.printStackTrace(); }finally { try { fr.close(); } catch (IOException ex) { ex.printStackTrace(); } } } }
**try-with-resources**, also referred as **automatic resource management**, is a new exception handling mechanism that was introduced in Java 7, which automatically closes the resources used within the try catch block.

To use this statement, you simply need to declare the required resources within the parenthesis, and the created resource will be closed automatically at the end of the block. Following is the syntax of try-with-resources statement.

### Syntax
try(FileReader fr = new FileReader("file path")) { // use the resource } catch () { // body of catch } }
Following is the program that reads the data in a file using try-with-resources statement.
### Example
import java.io.FileReader; import java.io.IOException; public class Try_withDemo { public static void main(String args[]) { try(FileReader fr = new FileReader("E://file.txt")) { char [] a = new char[50]; fr.read(a); // reads the contentto the array for(char c : a) System.out.print(c); // prints the characters one by one } catch (IOException e) { e.printStackTrace(); } } }
Following points are to be kept in mind while working with try-with-resources statement.

- To use a class with try-with-resources statement it should implement **AutoCloseable** interface and the **close()** method of it gets invoked automatically at runtime.
    
- You can declare more than one class in try-with-resources statement.
    
- While you declare multiple classes in the try block of try-with-resources statement these classes are closed in reverse order.
    
- Except the declaration of resources within the parenthesis everything is the same as normal try/catch block of a try block.
    
- The resource declared in try gets instantiated just before the start of the try-block.
    
- The resource declared at the try block is implicitly declared as final.
    

## User-defined Exceptions in Java

You can create your own exceptions in Java. Keep the following points in mind when writing your own exception classes −

- All exceptions must be a child of Throwable.
    
- If you want to write a checked exception that is automatically enforced by the Handle or Declare Rule, you need to extend the Exception class.
    
- If you want to write a runtime exception, you need to extend the RuntimeException class.
    

### Syntax

We can define our own Exception class as below −
class MyException extends Exception { }
You just need to extend the predefined **Exception** class to create your own Exception. These are considered to be checked exceptions. The following **InsufficientFundsException** class is a user-defined exception that extends the Exception class, making it a checked exception. An exception class is like any other class, containing useful fields and methods.

### Example: Creating user-defined exception
// File Name InsufficientFundsException.java import java.io.*; public class InsufficientFundsException extends Exception { private double amount; public InsufficientFundsException(double amount) { this.amount = amount; } public double getAmount() { return amount; } }
To demonstrate using our user-defined exception, the following CheckingAccount class contains a withdraw() method that throws an InsufficientFundsException.
// File Name CheckingAccount.java import java.io.*; public class CheckingAccount { private double balance; private int number; public CheckingAccount(int number) { this.number = number; } public void deposit(double amount) { balance += amount; } public void withdraw(double amount) throws InsufficientFundsException { if(amount <= balance) { balance -= amount; }else { double needs = amount - balance; throw new InsufficientFundsException(needs); } } public double getBalance() { return balance; } public int getNumber() { return number; } }
The following BankDemo program demonstrates invoking the deposit() and withdraw() methods of CheckingAccount.
// File Name BankDemo.java public class BankDemo { public static void main(String [] args) { CheckingAccount c = new CheckingAccount(101); System.out.println("Depositing $500..."); c.deposit(500.00); try { System.out.println("\nWithdrawing $100..."); c.withdraw(100.00); System.out.println("\nWithdrawing $600..."); c.withdraw(600.00); } catch (InsufficientFundsException e) { System.out.println("Sorry, but you are short $" + e.getAmount()); e.printStackTrace(); } } }
Compile all the above three files and run BankDemo. This will produce the following result −

**Output**

Depositing $500...

Withdrawing $100...

Withdrawing $600...
Sorry, but you are short $200.0
InsufficientFundsException
         at CheckingAccount.withdraw(CheckingAccount.java:25)
         at BankDemo.main(BankDemo.java:13)

## Common Java Exceptions

In Java, it is possible to define two catergories of Exceptions and Errors.

- **JVM Exceptions** − These are exceptions/errors that are exclusively or logically thrown by the JVM. Examples: NullPointerException, ArrayIndexOutOfBoundsException, ClassCastException.
    
- **Programmatic Exceptions** − These exceptions are thrown explicitly by the application or the API programmers. Examples: IllegalArgumentException, IllegalStateException.
# Java - Built-in Exceptions
## Built-in Exceptions in Java

Java defines several [exception](https://www.tutorialspoint.com/java/java_exceptions.htm) classes inside the standard package **java.lang**.

The most general of these exceptions are subclasses of the standard type RuntimeException. Since [java.lang](https://www.tutorialspoint.com/java/lang/index.htm) is implicitly imported into all Java programs, most exceptions derived from RuntimeException are automatically available.

## Types of Java Built-in Exceptions

Built-in Exceptions in Java are categorized into two categories Checked Exceptions and Unchecked Exceptions.

- **Checked Exceptions**: The checked exceptions are handled by the programmer during writing the code, they can be handled using the [try-catch block](https://www.tutorialspoint.com/java/java_try_catch_block.htm). These exceptions are checked at compile-time.
- **Unchecked Exceptions**: The unchecked exceptions are not handled by the programmer. These exceptions are thrown on run-time. Some of the unchecked exceptions are NullPointerException, ArrayIndexOutOfBoundsException, ArithmeticException, etc.

## Common Built-in Exceptions in Java

Java defines several other types of exceptions that relate to its various class libraries. Following is the list of Java Unchecked and Checked RuntimeException.

|Sr.No.|Exception & Description|
|---|---|
|1|**ArithmeticException**<br><br>Arithmetic error, such as divide-by-zero.|
|2|**ArrayIndexOutOfBoundsException**<br><br>Array index is out-of-bounds.|
|3|**ArrayStoreException**<br><br>Assignment to an array element of an incompatible type.|
|4|**ClassCastException**<br><br>Invalid cast.|
|5|**IllegalArgumentException**<br><br>Illegal argument used to invoke a method.|
|6|**IllegalMonitorStateException**<br><br>Illegal monitor operation, such as waiting on an unlocked thread.|
|7|**IllegalStateException**<br><br>Environment or application is in incorrect state.|
|8|**IllegalThreadStateException**<br><br>Requested operation not compatible with the current thread state.|
|9|**IndexOutOfBoundsException**<br><br>Some type of index is out-of-bounds.|
|10|**NegativeArraySizeException**<br><br>Array created with a negative size.|
|11|**NullPointerException**<br><br>Invalid use of a null reference.|
|12|**NumberFormatException**<br><br>Invalid conversion of a string to a numeric format.|
|13|**SecurityException**<br><br>Attempt to violate security.|
|14|**StringIndexOutOfBounds**<br><br>Attempt to index outside the bounds of a string.|
|15|**UnsupportedOperationException**<br><br>An unsupported operation was encountered.|
|16|**ClassNotFoundException**<br><br>Class not found.|
|17|**CloneNotSupportedException**<br><br>Attempt to clone an object that does not implement the Cloneable interface.|
|18|**IllegalAccessException**<br><br>Access to a class is denied.|
|19|**InstantiationException**<br><br>Attempt to create an object of an abstract class or interface.|
|20|**InterruptedException**<br><br>One thread has been interrupted by another thread.|
|21|**NoSuchFieldException**<br><br>A requested field does not exist.|
|22|**NoSuchMethodException**<br><br>A requested method does not exist.|

## Examples of Java Built-in Exception

### Example 1: Demonstrating Arithmetic Exception Without try-catch

In this example, we're creating an error by dividing a value by 0. In this case, an unchecked exception will be raised. Being unchecked, compiler won't complain and program will compile successfully. Once program runs, the exception will be thrown and JVM will intercepts the same and terminate the program before printing the last statement.
package com.tutorialspoint; public class ExcepTest { public static void main(String args[]) { int b = 0; int c = 1/b; System.out.println("c :" + c); } }
#### Output

Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.tutorialspoint.ExcepTest.main(ExcepTest.java:8)

### Example 2: Demonstrating Arithmetic Exception With try-catch

In this example, we're handling unchecked exception. As first step, we're generating an error by dividing a value by 0. In this case, an unchecked exception will be raised. We're handling via ArithmeticException. Once program runs, the exception will be thrown and catch block will intercepts the same and print the last statement.
package com.tutorialspoint; public class ExcepTest { public static void main(String args[]) { try { int b = 0; int c = 1/b; System.out.println("c :" + c); } catch (ArithmeticException e) { System.out.println("Exception thrown :" + e); } System.out.println("Out of the block"); } }
#### Output

Exception thrown  :java.lang.ArithmeticException: / by zero
Out of the block

### Example 3: Demonstrating No Such Method Exception

In this example, we're showcasing that a checked exception is to be handled by code otherwise compiler will complain. Whenever a method throws a checked exception, it has to either handle the exception or declare throws exception statement as we're doing for getName() method. When we try to run the method, JVM complains the compilation problem as shown in output listed below:
package com.tutorialspoint; public class ExcepTest { public static void main(String args[]) { ExcepTest excepTest = new ExcepTest(); excepTest.getName(); } private String getName() throws NoSuchMethodException { throw new NoSuchMethodException(); } }
#### Output

Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
    Unhandled exception type NoSuchMethodException

    at com.tutorialspoint.ExcepTest.main(ExcepTest.java:7)