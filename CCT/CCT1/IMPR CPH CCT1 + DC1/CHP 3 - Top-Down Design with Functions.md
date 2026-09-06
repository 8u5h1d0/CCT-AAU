---
tags:
  - C
  - IMPR
  - CCT1
Topic: C programming language
Semester: CCT1
Course: IMPR1
Module: N/A
Course Date: N/A
Litterature:
  - Problem Solving and Program Design in C, Global Edition, 8th ed.
Created: 23-11-25
---
- - -
## Table of Contents

- [[#3. Modular Programming Using Functions in C|3. Modular Programming Using Functions in C]]
	- [[#3. Modular Programming Using Functions in C#Quick Reference Table|Quick Reference Table]]
	- [[#3. Modular Programming Using Functions in C#3.1 Building Programs from Existing Information|3.1 Building Programs from Existing Information]]
	- [[#3. Modular Programming Using Functions in C#3.2 Library Functions|3.2 Library Functions]]
		- [[#3.2 Library Functions#Predefined Functions and Code Reuse|Predefined Functions and Code Reuse]]
		- [[#3.2 Library Functions#C Library Functions|C Library Functions]]
	- [[#3. Modular Programming Using Functions in C#3.3 Top-Down Design and Structure Charts|3.3 Top-Down Design and Structure Charts]]
	- [[#3. Modular Programming Using Functions in C#3.4 Functions Without Arguments|3.4 Functions Without Arguments]]
		- [[#3.4 Functions Without Arguments#Function Prototypes|Function Prototypes]]
		- [[#3.4 Functions Without Arguments#Function Definitions|Function Definitions]]
		- [[#3.4 Functions Without Arguments#Placement of Functions in a Program|Placement of Functions in a Program]]
		- [[#3.4 Functions Without Arguments#Program Style - Use of Comments in a Program with Custom Functions|Program Style - Use of Comments in a Program with Custom Functions]]
		- [[#3.4 Functions Without Arguments#Order of Execution of Function Subprogram and Main Function|Order of Execution of Function Subprogram and Main Function]]
		- [[#3.4 Functions Without Arguments#Advantages of Using Function Subprograms|Advantages of Using Function Subprograms]]
			- [[#Advantages of Using Function Subprograms#Procedural Abstraction|Procedural Abstraction]]
			- [[#Advantages of Using Function Subprograms#Reuse of Function Subprograms|Reuse of Function Subprograms]]
		- [[#3.4 Functions Without Arguments#Displaying User Instructions|Displaying User Instructions]]
	- [[#3. Modular Programming Using Functions in C#3.5 Functions with Input Arguments|3.5 Functions with Input Arguments]]
		- [[#3.5 Functions with Input Arguments#void Functions with Input Arguments|void Functions with Input Arguments]]
		- [[#3.5 Functions with Input Arguments#Functions with Input Arguments and a Single Result|Functions with Input Arguments and a Single Result]]
		- [[#3.5 Functions with Input Arguments#Program Style - Function Interface Comment|Program Style - Function Interface Comment]]
		- [[#3.5 Functions with Input Arguments#Functions with Multiple Arguments|Functions with Multiple Arguments]]
			- [[#Functions with Multiple Arguments#Arguments List Correspondence|Arguments List Correspondence]]
			- [[#Functions with Multiple Arguments#Argument List Correspondence (NOT)|Argument List Correspondence (NOT)]]
		- [[#3.5 Functions with Input Arguments#The Function Data Area|The Function Data Area]]
		- [[#3.5 Functions with Input Arguments#Testing Functions Using Drivers|Testing Functions Using Drivers]]
	- [[#3. Modular Programming Using Functions in C#3.6 Introduction to Computer Graphics (Optional)|3.6 Introduction to Computer Graphics (Optional)]]
	- [[#3. Modular Programming Using Functions in C#3.7 Common Programming Errors|3.7 Common Programming Errors]]


# 3. Modular Programming Using Functions in C

## Quick Reference Table

| Concept | Syntax/Usage | Description |
|---|---|---|
| Function Prototype | `returnType functionName(parameterType parameterName);` | Declaration of a function before main() |
| Function Definition | `returnType functionName(parameterType parameterName) { ... }` | Implementation of the function |
| Library Inclusion | `#include <libraryName.h>` | Includes a standard library |
| Math Function Example | `double result = sqrt(x);` | Uses sqrt() from math.h |
| void Function | `void functionName() { ... }` | Function that doesn't return a value |
| Function Call | `functionName(arguments);` | Statement that executes a function |
| Function with Arguments | `returnType functionName(type1 param1, type2 param2)` | Function that accepts input parameters |

---

## 3.1 Building Programs from Existing Information

Programmers seldom start with a blank slate when developing a program. Following the software development method is crucial, generating important system documentation before coding begins. This documentation includes:

- A description of the problem's data requirements (developed during the Analysis phase)
- The solution algorithm (developed during the Design phase)

This documentation summarizes intentions and thought processes and serves as a starting point for coding the program.

> [!tip] Reusing Code
> Programmers often use segments of earlier programming solutions to different but similar problems as building blocks to construct new programs. This approach saves time and reduces the likelihood of errors.

---

## 3.2 Library Functions

### Predefined Functions and Code Reuse

A primary goal of software engineers is to create error-free code. *Code reuse* is when software engineers reuse program fragments that have already been written and tested whenever possible, avoiding the need to write new code that might contain errors.

C promotes code reuse by providing many predefined functions for mathematical operations. The standard math library (`<math.h>`) defines mathematical functions such as `sqrt` for computing square roots.

![A diagram showing a function as a 'black box' with input and output](Pasted%20image%2020251020175021.png)

_Figure 3.2.1: A function can be thought of as a 'black box', receiving input and generating output without the user needing to understand the internal computations._

### C Library Functions

![Table of common C library functions from math.h and stdlib.h](Pasted%20image%2020251020175220.png)

_Table 3.2.1: Common C library functions from math.h and stdlib.h libraries._

> [!warning] Library Inclusion
> These functions do not come stock with the general C coding structure or compiler. Libraries must be called with the `#include` directive in order to work.

---

## 3.3 Top-Down Design and Structure Charts

Programmers often break up problems into subproblems to develop program solutions. This process is called **top-down design**, which proceeds from the original problem at the "top-level" to various subproblems at "lower-levels".

Splitting problems in this way is analogous to the process of refining an algorithm. Each subproblem can be addressed separately, making the overall solution more manageable.

---

## 3.4 Functions Without Arguments

One way to implement top-down design is by defining custom functions. Programmers often write one "function sub-program" for each subproblem in the structure chart.

![A structure chart showing the relationship between main function and subfunctions](Pasted%20image%2020251020180924.png)

_Figure 3.4.1: A structure chart showing how a main function can call various subfunctions to solve a problem._

### Function Prototypes

Just like any other identifier in C, a function must be declared before it can be referenced. One way to declare a function is to insert a *function prototype* or *placeholder* before the main function.

A prototype tells the compiler:
- The data type of the function
- The name of the function
- Information about arguments that the function expects

![Example of a function prototype](Pasted%20image%2020251020180941.png)

_Figure 3.4.2: Example of a function prototype showing return type, function name, and parameter information._

### Function Definitions

While a prototype specifies the number of arguments a function takes and the type of its result, it doesn't specify the function operation. To do this, you must provide a definition for each function subprogram.

![Example of a function definition](Pasted%20image%2020251020180815.png)

_Figure 3.4.3: Example of a function definition showing the complete implementation._

![Example of a function definition with local variables](Pasted%20image%2020251020181024.png)

_Figure 3.4.4: Example of a function definition that includes local variables._

Each function body may contain declarations for its own variables. These variables are considered *local* to the function, meaning they can only be referenced within that function.

### Placement of Functions in a Program

The standard organization for functions in a C program is:
1. Subprogram prototypes precede the main function
2. The main function follows the prototypes
3. Subprogram definitions follow the main function

The relative order of definitions does not affect the order of execution, which is determined by the order of the function call statements.

### Program Style - Use of Comments in a Program with Custom Functions

Each function should begin with a comment that describes its purpose. For more complex function subprograms, include comments on each major algorithm step, similar to what you would do in the main function.

### Order of Execution of Function Subprogram and Main Function

When a program runs:
1. The first statement in the main function is executed first
2. When a function call statement is encountered, control transfers to the referenced function
3. Memory is allocated for variables declared in the function
4. The statements in the function body are executed
5. When the function completes, control returns to the calling statement

### Advantages of Using Function Subprograms

#### Procedural Abstraction

Function subprograms allow us to move code from the main function that provides the detailed solution to a subproblem. This enables us to write the main function as a sequence of function calls as soon as we have specified the initial algorithm, even before refining any of the steps.

![Diagram showing procedural abstraction](Pasted%20image%2020251020190059.png)

_Figure 3.4.5: Procedural abstraction allows us to delay implementation details until we're ready to write individual function subprograms._

This approach to program design, called *procedural abstraction*, allows us to defer implementation details until we're ready to write an individual function subprogram. Focusing on one function at a time is much easier than trying to write the complete program all at once.

#### Reuse of Function Subprograms

Another advantage is that functions can be executed multiple times in a program. Once you have written and tested a function, you can reuse it in other programs or functions. For example, functions that draw parts of a diagram could be reused in programs that draw other diagrams.

### Displaying User Instructions

Without the ability to pass information into or out of a function, we can use functions to display multiple lines of program output, such as:
- Instructions to a program user
- A title page
- A special message that precedes a program's results

---

## 3.5 Functions with Input Arguments

Programmers use functions like building blocks to construct large programs. Arguments of a function carry information into the subprogram from the main function or another subprogram, or return multiple results computed by the subprogram.

- Arguments that carry information *into* the subprogram are called *input arguments*
- Arguments that return results are called *output arguments*
- We can also return a single result from a function by executing a `return` statement in the function body

Arguments make function subprograms more versatile because they enable a function to manipulate different data each time it is called.

### void Functions with Input Arguments

A `void` function does not return a result. We can use a void function with an argument to "dress up" program output by having the function display its argument value in a more attractive way.

### Functions with Input Arguments and a Single Result

![Example of a function with input arguments and a return value](Pasted%20image%2020251020191142.png)

_Figure 3.5.1: Example of a function that takes input arguments and returns a single result._

![Example of calling a function with input arguments](Pasted%20image%2020251020191155.png)

_Figure 3.5.2: Example of calling a function and storing its return value._

![Example of a function with multiple input arguments](Pasted%20image%2020251020191239.png)

_Figure 3.5.3: Example of a function that takes multiple input arguments._

![Example of calling a function with multiple input arguments](Pasted%20image%2020251020191250.png)

_Figure 3.5.4: Example of calling a function with multiple input arguments._

### Program Style - Function Interface Comment

The block comment and heading that begin each function should contain all the information required to use the function. The function interface block comment should begin with a statement of what the function does.

You may also want to include a statement describing the condition that must be true after the function completes execution (postcondition). The function interface comment combined with the heading (or prototype) provides valuable documentation to other programmers who might want to reuse your functions.

### Functions with Multiple Arguments

#### Arguments List Correspondence

When using multi-argument functions, be careful to:
- Include the correct number of arguments in the function call
- Ensure the order of actual arguments in the function call corresponds to the order of formal parameters in the function prototype or heading
- Ensure each actual argument is of a data type that can be assigned to the corresponding formal parameter without loss of information

#### Argument List Correspondence (NOT)

The acronym NOT summarizes the requirements for argument list correspondence:

- **N**umber: The number of actual arguments must match the number of formal parameters
- **O**rder: The order of arguments determines correspondence (first actual argument corresponds to first formal parameter)
- **T**ype: Each actual argument must be of a data type that can be assigned to the corresponding formal parameter without unexpected loss of information

### The Function Data Area

Each time a function call is executed, an area of memory is allocated to store that function's data. This data area includes:
- Cells for its formal parameters
- Any local variables declared in the function

The function data area is always lost when the function terminates.

![Diagram showing the function data area](Pasted%20image%2020251020192823.png)

_Figure 3.5.5: Diagram showing how memory is allocated for a function's data area when it is called._

### Testing Functions Using Drivers

A function is an independent program module, meaning it can be tested separately from the program that uses it. To test a function in isolation, you can write a short *driver* function that:
- Defines the function arguments
- Calls the function
- Displays the value returned

---

## 3.6 Introduction to Computer Graphics (Optional)

This section would cover basic computer graphics concepts in C, which is marked as optional in the original material.

---

## 3.7 Common Programming Errors

When working with functions in C, be aware of these common errors:

1. **Missing Include Directives**: Remember to use a `#include` preprocessor directive for every standard library from which you are using functions.

2. **Function Placement**: Place prototypes for your own function subprograms in the source file preceding the main function; place the actual function definitions after the main function.

3. **Argument List Errors**: Syntax or run-time errors may occur when using functions. Remember the NOT requirements for argument list correspondence:
   - Provide the required number of arguments
   - Ensure the order of arguments is correct
   - Make sure each function argument is the correct type or that conversion to the correct type will lose no information

4. **Undefined Functions**: For user-defined functions, verify that each argument list is correct by comparing it to the formal parameter list in the function heading or prototype.

5. **Domain Errors**: Be careful when using functions that are undefined on some range of values. For example, if the argument for `sqrt`, `log`, or `log10` is negative, a runtime error will occur.

---

> [!summary] Summary
> This chapter covered the fundamentals of modular programming using functions in C. Key concepts include:
> - Building programs from existing information through code reuse
> - Using standard library functions to avoid reinventing the wheel
> - Implementing top-down design to break complex problems into manageable subproblems
> - Creating functions without arguments for simple tasks like displaying instructions
> - Developing functions with input arguments to create more versatile and reusable code
> - Understanding the requirements for argument list correspondence (NOT)
> - Testing functions independently using drivers
> - Avoiding common programming errors related to functions
> 
> Functions are essential building blocks in C programming that enable code reuse, modular design, and more maintainable programs.