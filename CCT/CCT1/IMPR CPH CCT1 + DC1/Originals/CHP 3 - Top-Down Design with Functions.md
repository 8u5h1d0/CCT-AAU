#IMPR #C #CCT1 
- - -
Programmers using software-dev methods to solve problems, seldom tackle each new program as a new and unique event.
Information acquired from the various planning stages helps plan and complete the finished product/program.
Using segments of earlier programing solutions to different but similar problems as building blocks to construct new programs.

A top-down design methodology starts with the broadest statement of the problem solution and works its way down to more and more detailed sub-problems.
## Table of Contents

- [[#3.1 Building Programs from Existing information|3.1 Building Programs from Existing information]]
- [[#3.2 Library Functions|3.2 Library Functions]]
	- [[#3.2 Library Functions#Predefined Functions and Code Reuse|Predefined Functions and Code Reuse]]
	- [[#3.2 Library Functions#C Lib. Functions|C Lib. Functions]]
- [[#3.3 Top-Down Design and Structure Charts|3.3 Top-Down Design and Structure Charts]]
- [[#3.4 Functions Without Arguments|3.4 Functions Without Arguments]]
	- [[#3.4 Functions Without Arguments#Function Prototypes|Function Prototypes]]
	- [[#3.4 Functions Without Arguments#Function Definitions|Function Definitions]]
	- [[#3.4 Functions Without Arguments#Placement of Functions in a Program|Placement of Functions in a Program]]
	- [[#3.4 Functions Without Arguments#Program Style - Use of Comments in a Program with Custom Functions|Program Style - Use of Comments in a Program with Custom Functions]]
	- [[#3.4 Functions Without Arguments#Order of Execution of Function Subprogram and Main Function|Order of Execution of Function Subprogram and Main Function]]
	- [[#3.4 Functions Without Arguments#Advantages of Using Function Subprograms|Advantages of Using Function Subprograms]]
			- [[#Procedural Abstraction|Procedural Abstraction]]
			- [[#Reuse of Function Subprograms|Reuse of Function Subprograms]]
	- [[#3.4 Functions Without Arguments#Displaying User Instructions|Displaying User Instructions]]
- [[#3.5 Functions with input Arguments|3.5 Functions with input Arguments]]
	- [[#3.5 Functions with input Arguments#void Functions with Input Arguments|void Functions with Input Arguments]]
	- [[#3.5 Functions with input Arguments#Functions with Input Arguments and a Single Result|Functions with Input Arguments and a Single Result]]
	- [[#3.5 Functions with input Arguments#Program Style - Function Interface Comment|Program Style - Function Interface Comment]]
	- [[#3.5 Functions with input Arguments#Functions with Multiple Arguments|Functions with Multiple Arguments]]
		- [[#Functions with Multiple Arguments#Arguments List Correspondence|Arguments List Correspondence]]
			- [[#Arguments List Correspondence#Argument List Correspondence (N O T)|Argument List Correspondence (N O T)]]
	- [[#3.5 Functions with input Arguments#The Function Data Area|The Function Data Area]]
	- [[#3.5 Functions with input Arguments#Testing Functions Using Drivers|Testing Functions Using Drivers]]
- [[#3.6 Introduction to Computer Grapichs (Optional)|3.6 Introduction to Computer Grapichs (Optional)]]
- [[#3.7 Common Programming Errors|3.7 Common Programming Errors]]

# 3.1 Building Programs from Existing information
Programmers seldom start off with a blank slate (or empty screen) when they develop a program.
it's a good idea to carefully follow the software development method, generating important system documentation before you even begin to code a program.
This system documentation, consisting of 
- a description of a problem’s data requirements (developed during the Analysis phase) and 
- its solution algorithm (developed during the Design phase), 
- summarizes your intentions and thought processes.
You can use this documentation as a starting point in coding your program.
# 3.2 Library Functions
## Predefined Functions and Code Reuse
A primary goal of a software engineer, as with any craftsman, is to create an error-free product; in this case, code.
*Code reuse* is when a software engineer reuses program fragments that have already been written and tested, where ever possible; to avoid writing errored new code. (Why re-invent the wheel?)

C promotes reuse, providing many predefined functions that can be used to perform mathematical arithmetic.
C's standard math library (<math.h>) defines mathematical functions and arithmetical operations, such as `sqrt`, that performs the root computation.
![[Pasted image 20251020174842.png]]
	`y = the root of x`

A function can be thought of as a 'black box', receiving input and generating output, without the user or even the programmer necessarily knowing or understanding the computations in-between.
![[Pasted image 20251020175021.png]]
## C Lib. Functions
![[Pasted image 20251020175220.png]]
These are some of the most common <math.h> and <stdlib.h> libraries in C, these do NOT come stock with the general C coding structure (no library does) or compiler.
Libraries must be called with the `#include` function in order to work.
# 3.3 Top-Down Design and Structure Charts
Often the programmer must break up the problem into subproblems, to develop the program solution.
This process is called **top-down design**,
and proceeds from the original problem at the "top-level" to the various subproblems, and parts of the various subproblems at each "lower-level".
Splitting the problem up in this way is analogous to the process of refining an algorithm.
# 3.4 Functions Without Arguments
One way to implement top-down design is by defining your own functions.
	Often a programmer will write one "function sub-program" for each subproblem in the structure chart.
![[Pasted image 20251020180924.png]]
## Function Prototypes
Just like any other identifier in C, a function must be declared, before it can be referenced.
One way to declare a function is to insert a *function prototype* or *placeholder* before the main function.
A prototype tells the compiler:
- The data type of the function
- The name of the function
- Information about arguments that the function expects.
	The data type of a function is determined by the type of value returned by the function.
![[Pasted image 20251020180941.png]]
## Function Definitions
Although the prototype specifies the number of arguments a function takes and the type of its result, it does not specify the function operation.
To do this, you must provide a definition for each function subprogram, similar to the definition of the main function.
![[Pasted image 20251020180815.png]]
![[Pasted image 20251020181024.png]]
Each function body may contain declarations for its own variables. These variables are considered local to the function; in other words, they can be referenced only within the function.
## Placement of Functions in a Program
The subprogram prototypes precede the main function, and the subprogram definitions follow the main function.
The relative order of definitions does not affect the order of execution; determined by the order of the function call statements.
## Program Style - Use of Comments in a Program with Custom Functions
Each function begins with a comment that describes its purpose. If the function subprograms were more complex, we would include comments on each major algorithm step just as we do in function main.
## Order of Execution of Function Subprogram and Main Function
Because the prototypes for the function subprograms appear before the main function, the compiler processes the function prototypes before it translates the main function.
The information in each prototype enables the compiler to correctly translate a call to that function. 
The compiler translates a function call statement as a transfer of control to the function.

After compiling the main function, the compiler translates each function subprogram. During translation, when the compiler reaches the end of a function body, it inserts a machine language statement that causes a transfer of control back from the function to the calling statement.

When we run the program, the first statement in the main function is the first statement executed.

When the computer executes a function call statement, it transfers control to the function that is referenced.

The computer allocates any memory that may be needed for variables declared in the function and then performs the statements in the function body.
## Advantages of Using Function Subprograms
Subprograms brings many advantages.
Their availability changes the way an individual coder organizes the solution to a problem.
For a team, working together on a larger program, subprograms make it easier to apportion programming tasks; each individual is responsible for a particular point of the problem, and set of functions to solve it.
They also simplify programming tasks, making them easier for newer programmers, not to get overwhelmed.

#### Procedural Abstraction
Subprog.s allow us to move code from the main function the code the provided the detailed solution to the subproblem.
![[Pasted image 20251020190059.png]]
Because these details are not in the main function, we can write the main function as a sequence of function calls, as soon as we have specified the initial algorithm, ad before we refine any of the steps.

	Delay writing the function for an algorithm step, untill that step has been refined

With this approach to program design, called *procedural abstraction*, we defer implementation details until we are ready to write an individual function subprogram. Focusing on one function at a time is much easier than trying to write the complete program all at once.

#### Reuse of Function Subprograms
Another advantage of using function subprograms is that functions can be executed more than once in a program.

Once you have written and tested a function, you can use it in other programs or functions. For example, the functions in the stick figure program could easily be reused in programs that draw other diagrams.
## Displaying User Instructions
Without the ability to pass information into or out of a function, we can use functions only to display multiple lines of program output, such as instructions to a program user or a title page or a special message that precedes a program’s results.
# 3.5 Functions with input Arguments
Programmers use functions like building blocks to construct large programs.
Functions are more like Lego® blocks than the smooth-sided wooden blocks.

Arguments of a function are used the carry information into the subprogram, from the main function or from another subprogram. Or to return multiple results computed by the subprogram.
- Arguments that carry info *into* the subprogram care called *input arguents*
- Arguments that return results are called *output arguments*
	We can also return a single result from a function by executing a ``return`` statement in the function body

Arguments make function subprograms more versatile because they enable a function to manipulate different data each time it is called.
## void Functions with Input Arguments
A ``void`` function does not return a result. 
We can use a void function with an argument to “dress up” our program output by having the function display its argument value in a more attractive way.
## Functions with Input Arguments and a Single Result
![[Pasted image 20251020191142.png]]
![[Pasted image 20251020191155.png]]

![[Pasted image 20251020191239.png]]
![[Pasted image 20251020191250.png]]
## Program Style - Function Interface Comment
The block comment and heading that begin each function contain all the information required in order to use the function. The function interface block comment begins with a statement of what the function does.
You will also want to include a statement describing the condition that must be true after the function completes execution, if some details of this postcondition are not included in the initial statement of the function’s purpose. We recommend that you begin all function definitions in this way. The function interface comment combined with the heading (or prototype) provides valuable documentation to other programmers who might want to reuse your functions in a new program without reading the function code.
## Functions with Multiple Arguments
### Arguments List Correspondence
- When using multi-argument functions, be careful to include the correct number of arguments in the function call.
- The order of the actual arguments and the function call must also correspond to the order of the formal parameters listed in the function prototype or heading.
- If you want the function to return meaningful resulsts, assignment of each actual argument to the corresponding formal parameter, must not cause any loss of information.
		Usually, you should use an actual argument of the same data type as the corresponding formal parameter, although this is not always essential.
If you pass an actual argument of type double to a formal parameter of type int, loss of the fractional part of the actual argument would likely lead to an unexpected function result.

#### Argument List Correspondence (N O T)
- The *N*umber of actual arguments used, must be the same as the number of formal parameters listed in the prototype.
- The *O*rder of arguments determines correspondence
	- The first actual argument corresponding to the first formal parameter
- Each actual argument must be of a data *T*ype, that can be assigned to the corresponding formal parameter, with no unexpected loss of information.
## The Function Data Area
Each time a function call is executed, an area of memory is allocated to store that function's data.
Included in the data area are cells for its formal parameters, and any local variables that may be declared in the function.
	The function data area is always lost when the function terminates.
![[Pasted image 20251020192823.png]]
## Testing Functions Using Drivers
A function is an independent program-module, meaning it can be tested separate from the the program that uses it.
To test like this, you should write a short *driver* function that defines the function arguments, calls the function and displays the value returned.
# 3.6 Introduction to Computer Grapichs (Optional)
# 3.7 Common Programming Errors
- Remember to use a ``#include`` preprocessor directive for every standard library from which you are using functions
- Place prototypes for your own function subprograms in the source file preceding the main function; place the actual function definitions after the main function
- Syntax or run-time errors may occur when you use functions. The acronym not summarizes the requirements for argument list correspondence. Provide the required number of arguments and make sure the order of arguments is correct. Make sure that each function argument is the correct type or that conversion to the correct type will lose no information.
- For user-defined functions, verify that each argument list is correct by comparing it to the formal parameter list in the function heading or prototype'
- Be careful in using functions that are undefined on some range of values. For example, if the argument for function sqrt, log, or log10 is negative, a runtime error will occur.