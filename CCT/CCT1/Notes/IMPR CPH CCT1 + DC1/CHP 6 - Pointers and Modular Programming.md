#IMPR #C #CCT1
- - - 
## Table of Contents

- [[#6.1 Pointers and the Indirection Operator|6.1 Pointers and the Indirection Operator]]
	- [[#6.1 Pointers and the Indirection Operator#Indirect Reference|Indirect Reference]]
	- [[#6.1 Pointers and the Indirection Operator#Pointer to Files|Pointer to Files]]
- [[#6.2 Functions with Output Parameters|6.2 Functions with Output Parameters]]
	- [[#6.2 Functions with Output Parameters#Meanings of Asterisk Sym|Meanings of Asterisk Sym]]
- [[#6.3 Multiple Calls to a Function with Input/Output Parameters|6.3 Multiple Calls to a Function with Input/Output Parameters]]
	- [[#6.3 Multiple Calls to a Function with Input/Output Parameters#Program Style - Preferred Kinds of Functions|Program Style - Preferred Kinds of Functions]]
- [[#6.4 Scope of Names|6.4 Scope of Names]]
- [[#6.5 Formal Output Parameters as Actual Arguments|6.5 Formal Output Parameters as Actual Arguments]]
- [[#6.6 Problem Solving Illustrated|6.6 Problem Solving Illustrated]]
- [[#6.7 Debugging and Testing a Program System|6.7 Debugging and Testing a Program System]]
	- [[#6.7 Debugging and Testing a Program System#Testing Tips for Program-Systems|Testing Tips for Program-Systems]]
- [[#6.8 Common Programming Errors|6.8 Common Programming Errors]]

# 6.1 Pointers and the Indirection Operator
The declaration `float *p;` identifies the *pointer variable* *p*, of type "pointer to `float`"
	This means we can store the *memory address* of a type `float` variable **inside** *p*.
![[Pasted image 20251028192928.png]]

![[Pasted image 20251028192948.png]]
![[Pasted image 20251028193000.png]]
![[Pasted image 20251028193011.png]]

This function applies the unary 'address-of'-operator `&` to the variable *m* to get its address, which is then stored in `itemp`.
	This is the same ``&`` operator that we have applied to variables in the input list of a ``scanf`` statement.
## Indirect Reference
we can use `*itemp` to reference the cell selected by pointer `itemp`. When the unary indirection operator `*` is applied to a pointer variable, it follows the pointer referenced by its operand.
This provides an **indirect reference** to the cell that is selected by the pointer variable.
![[Pasted image 20251028193922.png]]

![[Pasted image 20251028193937.png]]
## Pointer to Files
Alternatively to I/O redirection, C allows the program to explicitly name a file, from which the program will take input or write output.
To use files in this way, we declare pointer variables of type `FILE *`.
![[Pasted image 20251028210741.png]]

The OS must prepare a file for I/O before permitting access.
This preparation is the purpose of the function `fopen`.
![[Pasted image 20251028210858.png]]

`inp = fopen("distance.txt", "r");` *opens* (prepares for access) the file `distance.exe` an a source of program *input*, and stores the necessary access value(s) **in** the file pointer variable `inp`, with `"r"` indicating that we wish to *read* (scan) data from the opened file.
`outp = fopen("distout.txt", "w");` is similarly prepared, but instead of reading the file `"w"` indicates our desire to *write* into the `distout.txt` file, with `outp` as an output pointer.

There're file equivalent functions of the classic `scanf` and `printf`, called `fscanf` & `fprintf`.
![[Pasted image 20251028211742.png]]
The function `fscanf` must first be given an input file pointer (`inp`), the remainder of the function-call is identical to `scanf`: includes a format string, input list.
The function `fprintf` is also identical to `printf` with the additional requirement of an output file pointer (`outp`).

![[Pasted image 20251028212152.png]]
# 6.2 Functions with Output Parameters
Argument lists provide a link between the main function and subprograms.
Arguments make functions more versatile, because they enable a function to manipulate different data each time it's called.
Programmers use output parameters to return multiple results from the same function.

The computer allocates memory space in the function data area, for each formal parameter.
The value of each **actual** parameter is stored in the memory cell allocated to the corresponding **formal** parameter.
	Or, we can use the address-of operator `&` to store the **actual** parameter's address; a pointer to the actual instead of its value.
	![[Pasted image 20251029085731.png]]

Functions can use pointers and the indirection operator `*` to return results to the function that calls it.
![[Pasted image 20251029083554.png]]
![[Pasted image 20251029083514.png]]
Function main in our example declares three variables to receive these results—a type char variable ``sn``, a type int variable ``whl``, and a type double variable ``fr``. 
	Notice that no values are placed in these variables prior to the call to function separate, for it is the job of separate to define their values.
![[Pasted image 20251029084831.png]]
This statement causes the number stored in the actual argument value to be copied into the input parameter num and the addresses of the arguments ``sn``, ``whl``, and ``fr`` to be stored in the corresponding output parameters ``signp``, ``wholep``, and ``fracp``.
![[Pasted image 20251029085003.png]]
	Note that the use of the address-of operator & on the actual arguments ``sn``, ``whl``, and ``fr`` is essential. If the operator & were omitted, we would be passing to separate the values of ``sn``, ``whl``, and ``fr``, information that is worthless from the perspective of ``separate``.
The only way ``separate`` can store values in ``sn``, ``whl``, and ``fr`` is if it knows where to find them in memory.

In addition to the fact that the *values* of the actual output arguments in the call to ``separate`` are useless, these values are also of data types that do not match the types of the corresponding formal parameters.
![[Pasted image 20251030121700.png]]

The statements in function separate that cause the return of results follow:
![[Pasted image 20251030121749.png]]
In each case, the formal parameter is preceded by the indirection operator `*`.

- `*signp = '+';` follows the pointer in `signp` to the cell `main` calls `sn`, and stores the character '+'.
- `*wholep = floor(magnitude);` follows the pointer `wholep` to the cell `main` calls ``whl`` and stores the 'floor' (largest integer value, less than or equal to the given float (rounded down); in this case 35 from 35.817)
- `*fracp = magnitude - *wholep;` uses 2 (indirect) references. One accesses the value in `main`'s local variable `whl` through the pointer `wholep`, the other accesses `fr` through the pointer `fracp`, to give the final output 0.817; this being the value of `magnitude`'s fractorial-part.
## Meanings of Asterisk Sym
The `*` symbol has multiple meanings in C, it's used as a binary multiplication operator, as well as pointers.
	The ``*``’s in the declarations of the function’s formal parameters are part of the names of the parameters’ data types. These *’s should be read as “pointer to.”

`char *signp;` tells the compiler, the type of parameter `signp` is "pointer to `char`."
`*` has a completely diffrent meaning when used as the unary "indirection operator" in the function body.
Here it means "follow the pointer"; when used in a reference like `*signp` it means "follow pointer `*signp`"
> [!note]
> Notice that the data type of the reference ``*signp`` is ``char``, the data type of ``*wholep`` is ``int``, and the data type of ``*fracp`` is ``double``.

# 6.3 Multiple Calls to a Function with Input/Output Parameters
Previously information was passed into a function through *input parameters* and results through *output parameters*
This next example demonstrates the use of a single parameter to both bring a data value *into* a function and carry a result value *out*.
	This also demonstrates how a function may be called more than once in a given program, and process different data each time.

>[!abstract] Sort Three Numbers
>`main` gets three data values, ``num1``, ``num2``, and ``num3``, and rearranges the data so that they are in increasing sequence with the smallest value in ``num1``. 
>The three calls to function ``order`` perform this sorting operation.

![[Pasted image 20251030155718.png]]
Each time function order executes, the smaller of its two argument values is stored in its first actual argument and the larger is stored in its second actual argument.

```C
order(&num1, &num2);
```
Stores the smaller of `num1` and `num2` in `num1`. In the sample run, `num1` = 7,5 & `num2` = 9,6, so these **values** are not changed by the execution of the function.
However, 
```C
order(&num1, &num3);
```
switches the values of `num1` (7,5) and `num3` (5,5), 
since `num1` > `num3`.
![[Pasted image 20251030160203.png]]

The function heading
```C
void
order(double *smp, double *lgp) //I/O
```
identifies `smp` & `lgp` as *I/O Parameters* because the function uses the current *actual argument values* as inputs and may return new values.

During the execution of 
```C
order(&num1, &num3);
```
the *formal* parameter `smp` contains the *address* of the *actual* argument `num1`, and `lgp` the address of `num3`.

Testing the condition:
```C
(*smp > *lgp)
```
causes both pointers to be followed, resulting in
```C
(7.5 > 5.5)
```
which evaluates as ``true``.

![[Pasted image 20251030161023.png]]

![[Pasted image 20251030161039.png]]
## Program Style - Preferred Kinds of Functions
>[!warning] Reccomendation

Although all the kinds of functions are useful, it's recommend that you use the first kind whenever it is possible to do so.
	Functions that return a single value are the easiest functions for a program reader to deal with.
# 6.4 Scope of Names
*Scope of Names* refers to the region of a program where a particular meaning of a name is visible or can be referenced.

The names ``MAX`` and ``LIMIT`` are defined as constant macros and their scope begins at their definition and continues to the end of the source file.
	This means that all functions can access ``MAX`` and ``LIMIT``.

The scope of the function subprogram name ``fun_two`` begins with its ***prototype*** and continues to the end of the source file. This means that function ``fun_two`` can be called by functions ``one``, ``main``, and *itself*. 
The situation is different for function ``one`` because ``one`` is used as a *formal parameter* name in function ``fun_two``.
	Therefore, function ``one`` can be called by the ``main`` function and itself but ***not*** by function ``fun_two``.
![[Pasted image 20251030161948.png]]
# 6.5 Formal Output Parameters as Actual Arguments
Sometimes a function needs to pass its own output parameter as an argument when it calls another function.

Function ``scan_fraction`` has two output parameters, ``nump`` and ``denomp``, through which it returns the *numerator* and *denominator* of the fraction scanned.
The function needs to pass its *output* parameter(s) to the library function `scanf`, which gets the needed numerator and denumerator values.
	In other calls to `scanf`, the address-of operator `&` was applied the each variable to be filled.
	Because `nump` and `denomp` are *pointers* and already store addresses, we can use them **directly** in the call
```C
status = scanf("%d %c%d", nump, &slash, denomp);
```
![[Pasted image 20251030171221.png]]
The statement stores the first number scanned in the variable whose address is in ``nump``, the *slash* character (possibly preceded by blanks) in local variable ``slash``, and the second number scanned in the variable whose address is in ``denomp``.
The if statement validates the fraction, setting the flag error to 1 (true) if the data entry was unsuccessful

![[Pasted image 20251030171410.png]]
# 6.6 Problem Solving Illustrated 
In this section, we examine two programming problems that illustrate many of the concepts discussed in this chapter. 
The top-down design process will be demonstrated in solving each programming problem. 
Each program will be implemented in a stepwise manner, starting with a list of major algorithm steps and continuing to add detail through refinement until the program and its function subprogram can be written. 

- The first problem uses files and file pointers. 
- The second problem implements a set of functions for manipulating fractions.

![[Problem Solving and Program Design in C, Global Edition, 8th ed..pdf#page=362]]
# 6.7 Debugging and Testing a Program System
Testing is the process of exercising a program or part of a program under controlled conditions and verifying that the results are as expected.
No amount of testing can guarantee the absence of defects in sufficiently complex programs.
Version or iteration *n* typically corrects the errors that were discovered in version *n - 1*.

Testing is generally done at the following levels:
- Unit Testing
Testing the smalles pieces of the software, often a single function.
To perform a unit test, we write a short driver function to call the function tested.
- Integration Testing
Testing the interactions among functions.
In a large system, testing functions that are dependent on other functions whose unit tests may not yet be complete requires an ability to have a temporary function take the place of the function still being tested.
	The replacement for a function that has not yet been implemented or unit tested is called a stub
- System Testing
Testing of the whole program in the context in which it will be used.
A program is generally part of a collection of other programs and hardware, called a system. Sometimes a program will work correctly until some other software is loaded onto the system, and then it will fail for no apparent reason.
- Acceptance Testing
Testing designed to show that the program meets its functional requirements (specs).
It typically involves use of the system in the real environment or in a close approximation to the real environment.
## Testing Tips for Program-Systems
> A list of suggestions for removing defects from a program system follows.

1. Carefully document each function parameter and local variable using comments as you write the code. Also, describe the function’s purpose using comments.
2. Create a trace of execution by displaying the function name as you enter it.
3. . Trace or display the values of all input and input/output parameters upon entry to a function. Check that these values make sense. 
4. Trace or display the values of all function outputs after returning from a function. Verify that these values are correct by hand computation. Make sure you declare all input/output and output parameters as pointer types. 
5. Make sure that a function stub assigns a value to the variable pointed to by each output parameter and returns a value if the function type is not void.

>[!abstract] Tips
>If you are using a debugger, you may be able to specify whether you want to execute a function as if it were a single statement or whether you want to step through the individual statements of a function.
>If the function results are incorrect, step through its individual statements
>If you are not using a debugger, you should plan for debugging as you write each function rather than waiting until after you finish the whole program.
>When you are satisfied that the function works correctly, remove the debugging statements.
# 6.8 Common Programming Errors
>[!warning]
>Many opportunities for error arise when you use functions with parameter lists, so be extremely careful.

- One obvious pitfall is not ensuring that the actual argument list has the same number of items as the formal parameter list. 
	Each actual input argument must be of a type that can be assigned to its corresponding formal parameter. 
	An actual output argument must be of the same pointer data type as the corresponding formal parameter.
- If an output parameter is not of a pointer type or if the calling function neglects to send a correct variable address, the function results will be incorrect.
- If an identifier is referenced outside its scope, an ``undeclared symbol`` syntax error will result.