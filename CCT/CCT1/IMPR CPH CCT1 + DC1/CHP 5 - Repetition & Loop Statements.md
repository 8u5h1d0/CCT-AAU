#IMPR #C #CCT1 
- - -
## Table of Contents

- [[#5.2 Counting Loops and  the while Statement|5.2 Counting Loops and  the while Statement]]
	- [[#5.2 Counting Loops and  the while Statement#The while Statement|The while Statement]]
- [[#5.3 Computing a Sum or a Product in a Loop|5.3 Computing a Sum or a Product in a Loop]]
	- [[#5.3 Computing a Sum or a Product in a Loop#Program Style - Writing General Loops|Program Style - Writing General Loops]]
	- [[#5.3 Computing a Sum or a Product in a Loop#Multiplying a List of Numbers|Multiplying a List of Numbers]]
	- [[#5.3 Computing a Sum or a Product in a Loop#Compound Assignment Operators|Compound Assignment Operators]]
- [[#5.4 The for Statement|5.4 The for Statement]]
	- [[#5.4 The for Statement#Program Style - formatting the for Statement|Program Style - formatting the for Statement]]
	- [[#5.4 The for Statement#Increment and Decrement Operators|Increment and Decrement Operators]]
- [[#5.5 Conditional Loops|5.5 Conditional Loops]]
	- [[#5.5 Conditional Loops#Program Style - Performing Loop Processing in a function Subprogram|Program Style - Performing Loop Processing in a function Subprogram]]
- [[#5.6 Loop Design|5.6 Loop Design]]
	- [[#5.6 Loop Design#Sentinel-Controlled Loops|Sentinel-Controlled Loops]]
	- [[#5.6 Loop Design#Endfile-Controlled Loops|Endfile-Controlled Loops]]
	- [[#5.6 Loop Design#Infinite Loops on Faulty Data|Infinite Loops on Faulty Data]]
- [[#5.7 Nested Loops|5.7 Nested Loops]]
- [[#5.8 The do-while Statement and Flag-Controlled Loops|5.8 The do-while Statement and Flag-Controlled Loops]]
	- [[#5.8 The do-while Statement and Flag-Controlled Loops#Flag-controlled Loops for Input Validation|Flag-controlled Loops for Input Validation]]
- [[#5.9 Iterative Approximations|5.9 Iterative Approximations]]
	- [[#5.9 Iterative Approximations#Function Parameters|Function Parameters]]
- [[#5.10 How to Debug and Test programs|5.10 How to Debug and Test programs]]
	- [[#5.10 How to Debug and Test programs#Using a Debugger Program|Using a Debugger Program]]
	- [[#5.10 How to Debug and Test programs#Debugging Without a Debugger|Debugging Without a Debugger]]
	- [[#5.10 How to Debug and Test programs#Off-by-One Loop Errors|Off-by-One Loop Errors]]
	- [[#5.10 How to Debug and Test programs#Testing|Testing]]
- [[#5.11 Loops in Graphic Programs (Optional)|5.11 Loops in Graphic Programs (Optional)]]
- [[#5.12 Common Programming Errors|5.12 Common Programming Errors]]

# 5.1 Repetition in Programs
The ability to make decisions is an important tool in programming, so i specifying reptation for a group of operations.
Writing out a solution to a specefic case, can be helpful in preparation fordefining the general problem solution.
After solving the sample task, as yourself 3 questions to determine whether loops are required in the general algorithm.
1. Were there repeated steps in the solution? if so which?
2. If yes, did i know in advance how many times i needed to repeat those?
3. if i didn't know, how did i know how long to keep repeating the steps?
![[Pasted image 20251009155404.png]]
![[Pasted image 20251009155415.png]]
# 5.2 Counting Loops and  the ``while`` Statement
A **counter-controlled loop** (counting loop) is a loop which's repitition is managed by a loop control variable whose value represents a count.
![[Pasted image 20251009155600.png]]
We use a counter-controlled loop when we can determine prior to loop execution exactly how many loop repetitions will be needed to solve the problem. This number should appear as the *final value* in the ``while`` condition.
## The ``while`` Statement
The `while` statement is a loop that repeats the operations of the loop body for so long as the condition is true.
For a counting loop this condition is most likely that a variable is under certain or equal to a value, with the value of that variable incrementing by 1 each repetition.
![[Pasted image 20251009161239.png]]
![[Pasted image 20251009160804.png]]
![[Pasted image 20251009160833.png]]
# 5.3 Computing a Sum or a Product in a Loop
Loops often accumulate a sum or a product by repeating an addition or multiplication operation.
The *accumulator* variable is a variable used within the loop body, to gather all the accumulated values of the loop together. For example a total payroll of a company, instead of a lot of single payrolls done within the loop.
## Program Style - Writing General Loops
It's a good idea to generalize your algorithms once you've gotten the solution to a specific test case; so that you can re-use the code for future work.
Instead of hardcoding a set count into a counting loop, one could make a *set count variable*, so that a counting algorithm can work in a different situation, where a different amount of repetitions is necessary![[Pasted image 20251009162116.png]]
## Multiplying a List of Numbers
Similarly to accumulating addition, we can also use a loop to compute the product of a list of numbers.
![[Pasted image 20251009162247.png]]
![[Pasted image 20251009164006.png]]
## Compound Assignment Operators
A very common assignment statement is of the form:
`variable = variable 'op' expression;`
	'op' is a C arithmetic operator, for example increments and decrements of loop counters
![[Pasted image 20251009164227.png]]

![[Pasted image 20251009164236.png]]
As well as accumulation of a sum or product in a loop, C also provides special assignment operators that enable a more concise notation.
![[Pasted image 20251009164359.png]]
# 5.4 The for Statement
In C, the `for` statement is another form for implementing loops.
Loops are typically set up to have three loop control components, and a loop body.
![[Pasted image 20251009164641.png]]

An important feature of the for statement, is that it supplies a desginated place for each of these components.
The effect of this is exactly the same as the execution of the comparable `while` loop.
![[Pasted image 20251009164806.png]]
for combines the three loop controls into one place, and can be used to count up or down by any interval similarly to using an *op*.

## Program Style - formatting the for Statement
For clarity, we usually place each expression of the for heading on a separate line. If all three expressions are very short, we may place them together on one line.
![[Pasted image 20251009165004.png]]
![[Pasted image 20251009165013.png]]
The body of the for loop is indented. If the loop body is a compound statement or if we are using a style in which we bracket all loop bodies, we place the opening brace at the end of the for heading and terminate the statement by placing the closing brace on a separate line. This closing brace should be aligned with the “f” of the for that it is ending.

## Increment and Decrement Operators
Alternatively to using an *op* to increment the counting variable, the increment (++) and decrement (--) operators can be used for the same effect.
These operators take a single variable as operand, with the "side effect" of incrementing this operand by exactly 1.
	Frequently, ++ is used just for this side effect, as in the following loop in which the variable counter is to run from 0 up to limit.
	![[Pasted image 20251009165431.png]]

The *value* of the expression in which ++ is used, depends on the position of the operator.
When the ++ is placed immediately in front of its operand (prefix increment), the value of the expression is the variable’s value after incrementing. When the ++ comes immediately after the operand (postfix increment), the expression’s value is the value of the variable before it is incremented.
	The decrement operator can also be used in either the prefix or postfix position.
![[Pasted image 20251009165750.png]]

You should avoid using the increment and decrement operators in complex expressions in which the variables to which they are applied appear more than once. C compilers are expected to exploit the commutativity and associativity of various operators in order to produce efficient code.
# 5.5 Conditional Loops
In many situations, you won't be able to predict or determine the *exact* number of loops required, before execution begins.
So, instead of having and counting a fixed value or the value of a set variable as our condition, we set a different conditional statement.
This loop will continue until the set condition is true, for example until the numbers given by the user in a piece of calculation software, equals a positive number. If the condition is false (the given numbers equal a negative after computation), the loop will restart and re-prompt the user.
![[Pasted image 20251009170256.png]]
## Program Style - Performing Loop Processing in a function Subprogram
Placing all loop processing in a function subprogram (outside of the `main` function) simplifies the main function.
# 5.6 Loop Design
![[Pasted image 20251012105713.png]]
## Sentinel-Controlled Loops
Many program-loops input one or more additional data items each time the loop is repeated, often we don't know how many items the loop should process; therefore we must find a way to signal the program to stop reading and processing new data.
One way to do this is to instruct the user to input a unique *sentinel value* data value; after the last data item.
The loop then test each data item for this value, and exits the loop once found.
	The sentinel value must be chosen carefully, as it ***must*** be  value that couldn't come up in normal data.
![[Pasted image 20251012105759.png]]
## Endfile-Controlled Loops
A data file is always terminated by an endfile character that can be detected by the scanf function. Therefore, you can write a batch program that processes a list of data of any length without requiring a special sentinel value at the end of the data.
To write such a program, you must set up your input loop so it notices when ``scanf`` encounters the endfile character
If ``scanf`` runs into difficulty with invalid or insufficient data (for instance, if it comes across the letter 'o' instead of a zero when trying to get a decimal integer), the function returns as its value the number of data items scanned before encountering the error or running out of data.
It's possible to design a loop similarly to the sentinal-controlled, using the status of the scanning function to control repetition rather than using the values scanned.
![[Pasted image 20251012111404.png]]
## Infinite Loops on Faulty Data
The behavior of the ``scanf`` function when it encounters faulty data can quickly make infinite loops.
![[Pasted image 20251012113452.png]]
![[Pasted image 20251012113518.png]]
# 5.7 Nested Loops
Loops may be nested just like other control structures. 
Nested loops consist of an outer loop with one or more inner loops. 
Each time the outer loop is repeated, the inner loops are reentered, their loop control expressions are reevaluated, and all required iterations are performed.
# 5.8 The do-while Statement and Flag-Controlled Loops
I both the ``for`` and ``while`` statements, the condition is evaluated before execution of the loop body.
In most cases this 'pretest' is useful and prevents the loop from executing when there's no data items to process or when the initial value of the loop control variable is outside the expected range.

There're some situations, however, generally involving interactive input from the user, when we know that a loop must execute at least one time.
![[Pasted image 20251012114000.png]]
![[Pasted image 20251012114010.png]]
![[Pasted image 20251012114023.png]]
![[Pasted image 20251012114032.png]]
## Flag-controlled Loops for Input Validation
Sometimes a loop repetition condition becomes so complex that placing the full expression in its usual spot is awkward. In many cases, the condition may be simplified by using a *flag*. 
A *flag* is a type int variable used to represent whether or not a certain event has occurred. 
A flag has one of two values: 1 (true) and 0 (false).
# 5.9 Iterative Approximations
Numerical analysis is the branch of mathematics and computer science that develops algorithms for solving computational problems. Problems from numerical analysis include finding solutions to sets of equations, performing operations on matrices, finding roots of equations, and performing mathematical integration.
![[Pasted image 20251012114253.png]]

A value *k* is a **root** of an equation ``f(x)=0``, if ``f(k)=0``.
If we graph f(x), the roots are those points where the x-axis and graph intersect.

The *bisection method* is one way of approximating a root of the equation f(x) = 0. This method repeatedly generates approximate roots until a 'true root' is discovered or until an approximation is found that differs from a true root by less than *epsilon*, where epsilon is a very small constant (for example, 0.0001). The approximation can be found if we can isolate the true root and the approximate root within the same interval whose length is less than *epsilon*.
## Function Parameters
A bisection function to find roots of one specified function, our bisection routine would be far more useful if we could call it to find a root of any function, just by specifying the name of the function in the call.
To do this, we must be able to include a function in the parameter list of another function.
Declaring a function parameter is accomplished by simply including a prototype of the function in the parameter list.
![[Pasted image 20251012114934.png]]
![[Pasted image 20251012114946.png]]
![[Pasted image 20251012115012.png]]
# 5.10 How to Debug and Test programs
Sometimes the cause of a run-time error or the source of a logic error is apparent and the error can be fixed easily. Often, however, the error is not obvious and you may spend considerable time and energy locating it. The first step in locating a hidden error is to examine the program output to determine which part of the program is generating incorrect results. Then you can focus on the statements in that section of the program to determine which are at fault.
## Using a Debugger Program
The debugger lets you execute your program one statement at a time (step-by-step execution). Through which you can trace your program's execution and observe the effects of your variables.
You can also validate loops and loop controls.
If your program is very long, you can separate your program into segments by setting *breakpoints* at selected statements. A breakpoint is like a fence between two segments of a program. You should set a breakpoint at the end of each major algorithm step. Then instruct the debugger to execute all statements from the last breakpoint up to the next breakpoint.
## Debugging Without a Debugger
If you cannot use a debugger, insert extra *diagnostic calls* to ``printf`` that display intermediate results at critical points in your program. 
For example, you should display the values of variables affected by each major algorithm step before and after the step executes. By comparing these results at the end of a run, you may be able to determine which segment of your program contains bugs.
## Off-by-One Loop Errors
A fairly common logic error in programs with loops is a loop that executes one more time or one less time than required. If a sentinel-controlled loop performs an extra repetition, it may erroneously process the sentinel value along with the regular data. If a loop performs a counting operation, make sure that the initial and final values of the loop control variable are correct and that the loop repetition condition is right
![[Pasted image 20251012115548.png]]
Often you can determine whether a loop is correct by checking the loop boundaries—that is, the initial and final values of the loop control variable.
![[Pasted image 20251012115641.png]]
## Testing
After all errors have been corrected and the program appears to execute as expected, the program should be tested thoroughly to make sure that it works. For a simple program, make enough test runs to verify that the program works properly for representative samples of all possible data combinations.

# 5.11 Loops in Graphic Programs (Optional)
# 5.12 Common Programming Errors
![[Pasted image 20251012115740.png]]

![[Pasted image 20251012115758.png]]

![[Pasted image 20251012115806.png]]

![[Pasted image 20251012115838.png]]

![[Pasted image 20251012115848.png]]

![[Pasted image 20251012115934.png]]
![[Pasted image 20251012115955.png]]

![[Pasted image 20251012120025.png]]

![[Pasted image 20251012120040.png]]