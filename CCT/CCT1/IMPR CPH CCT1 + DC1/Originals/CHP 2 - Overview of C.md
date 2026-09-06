#IMPR #C #CCT1 
- - -
## Table of Contents

- [[#Preprocessor Directives|Preprocessor Directives]]
- [[#Syntax Displays for Preprocessor Directives|Syntax Displays for Preprocessor Directives]]
- [[#Reserved Words|Reserved Words]]
- [[#Standard Identifiers|Standard Identifiers]]
- [[#User-Defined Identifiers|User-Defined Identifiers]]
	- [[#User-Defined Identifiers#Valid Identifier names|Valid Identifier names]]
	- [[#User-Defined Identifiers#Invalid Identifier names|Invalid Identifier names]]
- [[#Uppercase & Lowercase|Uppercase & Lowercase]]
- [[#2.2 Variable Declarations and Data Types|2.2 Variable Declarations and Data Types]]
- [[#2.2 Variable Declarations and Data Types#Variable Declarations|Variable Declarations]]
- [[#2.2 Variable Declarations and Data Types#Data Types|Data Types]]
	- [[#Data Types#Data Type - Int|Data Type - Int]]
	- [[#Data Types#Data Type - Double|Data Type - Double]]
- [[#2.2 Variable Declarations and Data Types#Differences Between Numeric Types|Differences Between Numeric Types]]
	- [[#Differences Between Numeric Types#Data Type - Char|Data Type - Char]]
- [[#2.2 Variable Declarations and Data Types#The ASCII Code|The ASCII Code]]
- [[#2.3 Executable Statements|2.3 Executable Statements]]
- [[#2.3 Executable Statements#Programs in Memory|Programs in Memory]]
- [[#2.3 Executable Statements#Assignment Statements|Assignment Statements]]
- [[#2.3 Executable Statements#I/O Operations and Functions|I/O Operations and Functions]]
- [[#2.3 Executable Statements#The printf Function|The printf Function]]
	- [[#The printf Function#Multiple Placeholders|Multiple Placeholders]]
	- [[#The printf Function#About 
|About 
]]
	- [[#The printf Function#Displaying Prompts|Displaying Prompts]]
- [[#2.3 Executable Statements#The scanf function|The scanf function]]
- [[#2.3 Executable Statements#The return Statement|The return Statement]]
- [[#2.4 General Form of a C Program|2.4 General Form of a C Program]]
- [[#2.4 General Form of a C Program#Program Style - Spaces in Programs|Program Style - Spaces in Programs]]
- [[#2.4 General Form of a C Program#Comments in Programs|Comments in Programs]]
- [[#2.4 General Form of a C Program#Program Style - Using Comments|Program Style - Using Comments]]
- [[#2.5 Arithmetic Expressions|2.5 Arithmetic Expressions]]
- [[#2.5 Arithmetic Expressions#/ and % Operators|/ and % Operators]]
	- [[#/ and % Operators#/ operator|/ operator]]
	- [[#/ and % Operators#% operator|% operator]]
- [[#2.5 Arithmetic Expressions#Data Type of an Expression|Data Type of an Expression]]
- [[#2.5 Arithmetic Expressions#Mixed-Type Assignment Statements|Mixed-Type Assignment Statements]]
- [[#2.5 Arithmetic Expressions#Type Conversion Through Casts|Type Conversion Through Casts]]
- [[#2.5 Arithmetic Expressions#Characters as Integers|Characters as Integers]]
- [[#2.5 Arithmetic Expressions#Expressions with Multiple Operators|Expressions with Multiple Operators]]
	- [[#Expressions with Multiple Operators#Rules for Expression Evaluation|Rules for Expression Evaluation]]
- [[#2.5 Arithmetic Expressions#Writing Mathematical Formulas in C|Writing Mathematical Formulas in C]]
- [[#2.5 Arithmetic Expressions#Numerical Inaccuracies|Numerical Inaccuracies]]
- [[#2.6 Formatting Numbers in Program Output|2.6 Formatting Numbers in Program Output]]
- [[#2.6 Formatting Numbers in Program Output#Formatting Values of Type int|Formatting Values of Type int]]
- [[#2.6 Formatting Numbers in Program Output#Formatting Values of Type double|Formatting Values of Type double]]
- [[#2.6 Formatting Numbers in Program Output#Program Style - Elimination leading Blanks|Program Style - Elimination leading Blanks]]
- [[#2.7 Interactive Mode, Batch Mode, and Data Files|2.7 Interactive Mode, Batch Mode, and Data Files]]
- [[#2.7 Interactive Mode, Batch Mode, and Data Files#Input Redirection|Input Redirection]]
- [[#2.7 Interactive Mode, Batch Mode, and Data Files#Program Style - Echo Prints vs. Prompts|Program Style - Echo Prints vs. Prompts]]
- [[#2.7 Interactive Mode, Batch Mode, and Data Files#Output Redirection|Output Redirection]]
- [[#2.8 Common Programming Errors|2.8 Common Programming Errors]]
- [[#2.8 Common Programming Errors#Syntax Errors|Syntax Errors]]
- [[#2.8 Common Programming Errors#Run-Time Errors|Run-Time Errors]]
- [[#2.8 Common Programming Errors#Undetected Errors|Undetected Errors]]
- [[#2.8 Common Programming Errors#Logic Errors|Logic Errors]]

# 2.1 C Lang. Elements
C lets you write code that resemble everyday english.

## Preprocessor Directives
a C program has 2 parts
	1. preprocessor directives.
	Commands that give instructions to the C preprocessor, which modifies the text of a C program *before* complilation.
	Begins with the '#' symbol
	Most common are `#include` and `#define`
	Many actions neccesary in a computer program are not defined directly by C. Instead these functions are refered by a **library**, which is a collection of these useful function and even special signage
		The `#include` directive, gives a program access to a library.
		This directive causes the preprocessor to insert definitions from a header file, before complilation.
		The `#define` directive, associates the ***constant macro*** (in the book *KMS_PER_MILE*) with the meaning (in the book set as *1.609*)
		This directive causes the preprocessor to replace all occurrences of *KMS_PER_MILE* in the text of the program, with the set value *1.609* before compilation.
	2. main function.
	This is the body of the program, containing the algorithm / instructions, which gets compiled into machine-understandable format.
		The two-line head
		```
		int
		main(void)
		```
		mark the begning of the main function. With the remaining lines functioning as the *body* of the function which is enclosed in braces ('{}').
		![[Pasted image 20250917192631.png]]
		![[Pasted image 20250917192707.png]]
## Syntax Displays for Preprocessor Directives
![[Pasted image 20250917192152.png]]
![[Pasted image 20250917192209.png]]
## Reserved Words
In C there're certain words reserved to function as instructions for the compiler to orientate the program correctly. 
There're other blocked words (blocked meaning they either cannot or should not be over written by the user; or have their meaning/function changed in any way), that're not reserved words, like identifiers from a library or names for memory cells.
All reserved words appear in lowercase; and have special meaning in C.
![[Pasted image 20250917193125.png]]
## Standard Identifiers
Standard identifiers, like reserved words, are blocked words with special meaning in C.
	`printf` & `scanf` are names of operations defined in the standard I/O library.
	Unlike reserved words, standard identifiers *can* be overwritten/redefined by the user, this is however not recommended.
		If you redefine a standard identifier, C will no longer be able to use it for the original purpose.
![[Pasted image 20250917194332.png]]
## User-Defined Identifiers
User-defined identifiers are use to name various aspects of our code like memory cells that hold data and program results; and operations that we define.
	*KMS_PER_MILE*, is the user-defined name of a constant macro.
You have some freedom when choosing a user-defined indentifier's name, but there are some syntax rules
![[Pasted image 20250917194029.png]]
![[Pasted image 20250917194235.png]]
![[Pasted image 20250917194347.png]]
### Valid Identifier names
*Although the syntax rules for identifiers do not place a limit on length, some ANSI C compilers do not consider two names to be different unless there is a variation within the first 31 characters.*
### Invalid Identifier names
![[Pasted image 20250917194214.png]]

## Uppercase & Lowercase
The C programming language considers the difference of lower and uppercase significant. Meaning that `x`, `X`, `xx`, `xX` and `XX` would not be considered the same variable.
	One style that has been widely adopted in industry uses all uppercase letters in the names of constant macros; and lowercase for other identifiers

# 2.2 Variable Declarations and Data Types
## Variable Declarations
The memory cells used for storing a program's input data, and its computational results are called **variables**.
The *variable declarations* in a C-program, till the compiler the names of all variables used in the program complied.
They also tell the compiler the type of information stored in each, and how that information will be represented in memory.

The `double` declaration communicates that we're storing an integer within the named variables `miles` and `kms`.'
![[Pasted image 20250917195250.png]]
![[Pasted image 20250917195347.png]]

## Data Types
A *data type* is a set of values and operations on those values.
Knowledge of the data type of an item (variable or value) enables the compiler to correctly specify operations on that item.

A standard data type in C is one that's predefined, such as: `char`, `double` or `int`.
`double` & `int` are used as abstractions for real numbers and integer.

### Data Type - Int
![[Pasted image 20250917202116.png]]
In math, integers are whole numbers.
`int` in C represents integers in C.
	Because of limited memory space in a cell, not all integers can be represented with `int`, the standard range is -32767 to 32767.
You can perform common arithmetic operations, and compare 2 `int` integers
### Data Type - Double
![[Pasted image 20250917202128.png]]
A real number in math, has an integral part and a fraction part, seperated by a decimal point.
In C, `double` is used to represent real numbers (both integral and fraction together). You can perform common arithmetic and compare them, similarly to `int`.
	We use scientific notation to represent real numbers.
	`double` is and abstraction for real numbers, because it doesn't all real numbers. Some are simply too large or small; and some cannot be represented accurately.
![[Pasted image 20250917202100.png]]

## Differences Between Numeric Types
One of the main differences between the two numeric types represented by `int` and `double`, is that operations involving integers are faster than real numbers; less storage is needed to store integers; and operations with integers are always precise, where there can be some accuracy loss or *round-off error* when using real numbers.
	These differences result from the way the numbers are represented in the computer's memory.
		All data is represented in memory as strings of binary.
		The string stored for the type `int` value 13, and the type `double` value 13.0 are not the same
![[Pasted image 20250917202759.png]]

### Data Type - Char
`char` represents an individual character value; a letter, a digit or a symbol.
	each `char` value is enclose in apostrophes
	![[Pasted image 20250917203027.png]]
![[Pasted image 20250917203040.png]]

## The ASCII Code
A character is represented in memory as an integer, the value stored is determined by the code used by the compiler; with the ASCII code being the most common.
	American Standard Code for Information Interchange
Where each character is given a unique numerical value, regardless of if it's a symbol, letter, digit or other types.
![[Pasted image 20250917203658.png]]
![[Pasted image 20250917203710.png]]
	In ASCII the *printable* characters are from code 32 to 126. There're also ASCII codes for *non-printable* control characters. Sending these control characters to an output-device causes it it perform a special operation.
# 2.3 Executable Statements
The executable statements follow the declarations in a function.
These statements are used in C, to write/code the algorithm and its refinements; with the compiler translating these statements into machine language.

## Programs in Memory
An overview of the memory, before (*a*) and after (*b*) execution:
![[Pasted image 20250918065146.png]]

## Assignment Statements
An *assignment statement* stores a value or computatnioal result in a variable, and is used to perform most arithmetic operations.
`kms = KMS_PER_MILE x miles;` is an assignment statement, that assigns a value to the variable `kms`.
	The value is the computational result of the multiplication of the constant macro `KMS_PER_MILE`, which is replaced with value 1.609 by the preprocessor, and the variable `miles`. 
	```
	KMS_PER_MILE = 1.609
	miles = 1
	kms = KMS_PER_MILE x miles 
	= 1.609 x 1 
	= 1.609
	```
In C the '=' symbol is the assignment operator.
![[Pasted image 20250918070026.png]]
In C, you can also assign in the form of result_sum = sum + item
![[Pasted image 20250918070139.png]]

## I/O Operations and Functions
Data can be stored from 2 diffrent ways:
- Assignment to variable
- copying input-data to variable, using a function like `scanf`
Data transfer from the outside into memory is called an *input operation*.
The results of a program can be displayed to the user by an *output operation*.
All I/O operations in C, are performed by special units called *Input/Output functions*. The common of which are supplied with C, as part of the input/output library `<stdio.h>`.

`printf` is an output function displaying an output on the screen.
`scanf` is an input function, assigning a variable with the input-data.
## The printf Function
To display the results of a program execution, we must specify what variable values should be displayed. This is the function, of the function `printf`.
![[Pasted image 20250918161720.png]]
The arguments for `printf` consists of a *format string* (in quotes) and a *print list* (list of variables, in this case  the variable `kms`)
![[Pasted image 20250918161909.png]]
the '%f' is called a placeholder, which is replaced by variables from the print list.
![[Pasted image 20250918162333.png]]
### Multiple Placeholders
![[Pasted image 20250918162027.png]]
Format strings can have multiple placeholders.
if the print list of a `printf` function has several variable calls, the format string should contain the same number of placeholders.
![[Pasted image 20250918162230.png]]
### About \n
The *cursor* is a moving, place-marker that indicates the next position on the screen information will be displayed.
	When executing a `printf` function, the cursor will move to the start of the next line if the `\n` escape-sequence is encountered in the format string
	![[Pasted image 20250918175105.png]]
![[Pasted image 20250918175155.png]]

### Displaying Prompts
In an interactive program, use `printf` to display a prompt, that tells the user what data to enter
![[Pasted image 20250918175347.png]]

## The scanf function
`scanf` copies data given from the standard input device, into a named variable.
	In most cases the standard input device is the keyboard
![[Pasted image 20250918175605.png]]
The format string '%lf' consists of a single placeholder, telling `scanf` what kind of data to copy to the variable `miles`.
	Note each variable in `scanf` is preceeded by and ampersand (&). The & in C is the *address-of* operator.
	![[Pasted image 20250918183624.png]]
When `scanf` executes, the program breaks (pauses) until the required data is entered and the `return` or `enter` key is pressed.
![[Pasted image 20250918183657.png]]

The number of input characters consumed by `scanf`, depends on the current format placeholder, which should reflect the type of variable in which the data is stored.
- %c - `char` variable
- %lf or %d - `double` or `int`
![[Pasted image 20250918183950.png]]

## The return Statement
`return` transfers control from the program back to the OS.
	The value `0` put in parentheses after `return` (`return (0)`), is considered the "result" of function `main`'s execution, and indicates your program executed without error.
![[Pasted image 20250918184231.png]]

# 2.4 General Form of a C Program
There're certain rules for combining the individual statements that can appear, into a functioning algorithm/program.

- The order of directives is as follows:
![[Pasted image 20250918184446.png]]
- You can write more than one statement on a line:
![[Pasted image 20250918184528.png]]

## Program Style - Spaces in Programs
- The consistent and careful use of blank spaces can improve the style of a program.
- A blank space is required between consecutive words in a program line.
- The compiler ignores extra blanks between words and symbols.
- You should always leave a blank space after a comma and before and after operators such as asterisk , minus, and equals.
- You should indent the body of the main function and insert blank lines between sections of the program

## Comments in Programs
Comments can make a program much easier to understand, describing the purpose of parts of the program like diffrent identifiers and the purpose of each program step.
	Comments are a part of the *program documentation*
![[Pasted image 20250918185016.png]]

## Program Style - Using Comments
Each program should begin with a header section that consists of a series of comments specifying
- Author of the program
- Date of the current version
- Description of the programs purpose
![[Pasted image 20250918185139.png]]
![[Pasted image 20250918185200.png]]
	If you're writing a program for a class-assignment, you should also list the class'/course's name and your instructor's name
![[Pasted image 20250918185305.png]]

When implementing each step in the algorithm, you should try to write a comment summarizing the purpose the that step.
![[Pasted image 20250918185453.png]]

# 2.5 Arithmetic Expressions
Most programming problems are solved with *arithmetic expressions* that manipulate `int` and/or `double` data.
![[Pasted image 20250918185650.png]]

## / and % Operators
### / operator
The *divison* operator.
When applied to 2 positive integers, computes the integral part of the result the result of dividing the first operand, with the second
```
double(X) = 7.0
double(Y) = 2
	Normally X / Y = 3.5
	But the '/' operator only returns the integral of the result, in this case 3
X / Y = 3

double(X) = 299.0
double(Y) = 100
X / Y = 2
```
If '/' is used on a negative and a positive integer, the result may vary from one C implementation to another.
	The result is ***undefined*** when the divisor (second operand) is = 0
![[Pasted image 20250918190336.png]]

### % operator
The *integer remainder* operator.
Returns the remainder of the result of a division between the first and second operand.
```
double(X) = 7
double(Y) = 2
X % Y = 1
```
![[Pasted image 20250918190548.png]]
![[Pasted image 20250918190751.png]]
![[Pasted image 20250918190819.png]]
## Data Type of an Expression
The data type of each variable must be specified in its declaration
	The type of an expression depends on the type(s) of its operands.
An expression involving two variables is `int` if both, and ONLY if **both** the variables are `int`; otherwise it's `double`.

## Mixed-Type Assignment Statements
When executed:
1. the expression is evaluated
2. the result is assigned to the variable listed on the left of the = operator
Either `double` or `int` may be assigned to a `double` variable.
![[Pasted image 20250918192913.png]]
![[Pasted image 20250918192930.png]]

In a mixed assignment such as
```
y = m / n;
```
the expression has a different data type from the variable `y`.
	A common mistake is assuming, since `y` is `double`, the expression is evaluated as if `m` and `n` are also `double` instead of `int`.
	The expression is evaluated *before* the assignment is made, and the type of the variable being assigned has not effect on the expression.
		The expression `m / n` evaluates to the integer 1.
	This value is converted to `double` (1.0), before being stored in `y`.
Assignment of a `double` expression to a `int` variable, will cause the fractional of the expression to be lost.
![[Pasted image 20250918195000.png]]
## Type Conversion Through Casts
C allows conversion of the type of an expression, by placing the desired type in parentheses before the expression.
This is an operation called a *type cast*.
![[Pasted image 20250918195147.png]]
	Two common usages of a cast are: 
	- To avoid integer division when computing an average
	- Rounding a `double` value by adding 0.5 and converting to `int`
![[Pasted image 20250918195358.png]]

## Characters as Integers
Since individual characters are represented by integer codes (often ASCII)m C allows conversion between `char` and `int`.
![[Pasted image 20250918195527.png]]
this also means you can perform arithmetic operations on characters' (ASCII) codes.
```
'a' + 1 = 'b'
```

## Expressions with Multiple Operators
Expressions with multiple operators are common in C.
Expressions can include both unary (1 operand) and binary (2 operands) operators.
The expression `x / y * z` is evaluated as `(x / y) * z`
### Rules for Expression Evaluation
![[Pasted image 20250918200038.png]]
these rules helps too understand how C evaluates expressions
![[Pasted image 20250918200229.png]]
![[Pasted image 20250918200252.png]]
![[Pasted image 20250918200321.png]]
![[Pasted image 20250918200349.png]]

![[Pasted image 20250918200405.png]]
![[Pasted image 20250918200420.png]]

## Writing Mathematical Formulas in C
You may encounter 2 problems with mathematical formulae in C.
1. multiplication is often implied in a written formula by writing the two items next to each other (ab = a x b). In C you must always use the asterisk operator between each item.
2. division. Normally we write the numerator and the denominator on separate lines
	![[Pasted image 20250918200821.png]]
	in C, the numerator and denominator are placed on the same line.
	Parentheses are often needed to separate the numerator and denominator, and to indicate clearly the order of evaluation of the operators in the expression
![[Pasted image 20250918201039.png]]
![[Pasted image 20250918201054.png]]
![[Pasted image 20250918201116.png]]

## Numerical Inaccuracies
One of the issues processing `double` is that an error can occur in representing real numbers.
This is usually with "irrational" or "infinite" fractions (1/3 = 0.333...).
This representational error (also called *round-off error*) will depend on the number of bits used in the mantissa; the more bits, the more digits, the smaller error.
Errors may also occur when manipulating very large and/or very small real numbers.
When you add a large number and a small number, the larger number may “cancel out” the smaller number, resulting in a *cancellation error*
	If *x* is much larger than *y*, then *x* + *y* may give the same value as *x*.
	If two very small numbers are multiplied, the result may be too small and misrepresented as 0. This is called *arithmetic underflow*.
	Similarly if two large numbers are multiplied the result may simply be too large to represent. This is called *arithmetic overflow*.
# 2.6 Formatting Numbers in Program Output
C displays all numbers in its default notation unless you instruct it to do otherwise.
## Formatting Values of Type int
Specifying the format of an integer value is fairly easy.
	You simply add a number between `%` and `d` of the placeholder `%d` in the `printf` format string.
		This number specifies the *field width* (the number of colums to use for the display)
![[Pasted image 20250918205412.png]]
## Formatting Values of Type double
We must indicate both the total *field width* needed, and the number of *decimal places* desired.
	The total width should be large enough to accommodate all digits before and after the decimal point.
		There will always be at least one digit before the decimal point, since 0 is printed as the integral part part of fractions that're less than 1.0 and greater than -1.0.
	![[Pasted image 20250918205841.png]]
We should also include a display column for the decimal point itself and potentially a negative sign, if the number can become a negative.
	The form of the format string placeholder is `%n.m`
		*n* is a number representing the total field width
		*m* is the desired number of decimal places
	![[Pasted image 20250918210139.png]]
	![[Pasted image 20250918210156.png]]
## Program Style - Elimination leading Blanks
A value whose whole-number part requires fewer display columns than are specified by the format field width is displayed with leading blanks.
To eliminate extra leading blanks, omit the field width from the format string placeholder
	The simple placeholder `%d` will cause an integer value to be displayed with no leading blanks
	A placeholder of the form ``% .mf`` has the same effect for values of type double, and this placeholder still allows you to choose the number of decimal places you wish
# 2.7 Interactive Mode, Batch Mode, and Data Files
There are two basic modes of computer operation: *batch mode* and *interactive mode*.

- In *interactive mode*, the program user interacts with the program and types in data while it is running. We include prompts so the program user knows when to enter each data item.
- In *batch mode*, the program scans its data from a data file prepared beforehand instead of interacting with its user.
## Input Redirection
In most systems, this association can be accomplished relatively easily through *input/output redirection* using operating system commands or by changing settings in your development environment.

## Program Style - Echo Prints vs. Prompts
In a batch mode program, `scanf` gets a value for the constant macro from a line of the data file.
Because the input comes from a file, a user prompt isn't needed; instead it's replaced with an *echo print* (a `printf` following the `scanf`) to display the value just stored, and provide a record of the data manipulated by the program.
Without it, we would not easily be able to know the value `scanf` obtained from the macro.
	As a rule of thumb, you should replace all prompt in an interactive mode program, with echo prints for a batch mode program
## Output Redirection
Program outputs can also be redirected to a disc file instead of to the screen (displayed).
From the disk you can send the output file to the printer output device, to obtain a hard copy of the program output
If an output is written to an already existing file that file's contents will be overwritten with the new output.
# 2.8 Common Programming Errors
As you begin to program, soon you will discover that a program rarely runs correctly the first time it executes.
When the compiler detects an error, the computer displays an *error message*, which indicates that you have made a mistake and what the likely cause of the error might be.
There're 3 main kinds of errors
1. Syntax errors
2. Run-time errors
3. Logic errors
## Syntax Errors
A *syntax error* is when your code violates one or more grammar rules of C, and are detected by your compiler, since it cannot translate the errored code, and your program will not be executed
![[Pasted image 20250918212737.png]]
## Run-Time Errors
Run-time errors, may be detected and displayed by the computer as it executes the program.
It occurs when the program directs the computer to do an illegal/impossible operation; such as dividing by 0.
This stops the computer from executing and will display a diagnostic message, describing the error.
![[Pasted image 20250918212750.png]]
## Undetected Errors
Many errors will no prevent the program from running to completion, but may simple lead to an incorrect result.
it's therefore important that your predict the results of the program **should** produce and verify the output is correct.
	A very common source of incorrect results in C programs is the input of a mixture of character and numeric data.
![[Pasted image 20250918213013.png]]
## Logic Errors
*Logic errors* occur when a program follows a faulty algorithm.
Because logic errors usually do not cause run-time errors and do not display error messages, they are very difficult to detect
	The only sign of a logic error may be incorrect program output
![[Pasted image 20250918213231.png]]
