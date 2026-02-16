---
tags:
  - C
  - Format
  - Syntax
  - Guide
Topic: Formatting & Syntax in the programming lang. C
Created: 02-11-2025
---
>[!abstract]- What is C? 
>C is a general-purpose, **procedural programming language**. Unlike higher-level languages that manage memory for you, C provides **low-level access to memory** and system resources through pointers. This gives the programmer fine-grained control, which, while powerful, requires great care. The result is that C is incredibly **efficient and fast**, making it the foundational language for operating systems (like Linux), embedded systems (in your car or microwave), game engines, and virtually any software where performance is critical.

- - -
## Table of Contents

- [[#Basic Program Structure|Basic Program Structure]]
- [[#Comments|Comments]]
- [[#Keywords and Identifiers|Keywords and Identifiers]]
	- [[#Keywords and Identifiers#Keywords|Keywords]]
	- [[#Keywords and Identifiers#Identifiers|Identifiers]]
- [[#Data Types & Variables|Data Types & Variables]]
	- [[#Data Types & Variables#Syntax|Syntax]]
- [[#Operators|Operators]]
	- [[#Operators#Arithmetic Operators|Arithmetic Operators]]
	- [[#Operators#Relational & Comparison Operators|Relational & Comparison Operators]]
	- [[#Operators#Logical Operators|Logical Operators]]
	- [[#Operators#Assignment Operators|Assignment Operators]]
	- [[#Operators#Bitwise Operators|Bitwise Operators]]
		- [[#Bitwise Operators#Bitwise Operations in Practice|Bitwise Operations in Practice]]
	- [[#Operators#Special Operators|Special Operators]]
- [[#Control Flow Statements|Control Flow Statements]]
	- [[#Control Flow Statements#``if-else`` Statement|``if-else`` Statement]]
	- [[#Control Flow Statements#``switch`` Statement|``switch`` Statement]]
- [[#Loops|Loops]]
	- [[#Loops#Loop Control|Loop Control]]
- [[#I/O Formatting (`printf` & `scanf`)|I/O Formatting (`printf` & `scanf`)]]
	- [[#I/O Formatting (`printf` & `scanf`)#`printf` (Print Formatted Data)|`printf` (Print Formatted Data)]]
	- [[#I/O Formatting (`printf` & `scanf`)#`scanf` (Scan Formatted Data)|`scanf` (Scan Formatted Data)]]
- [[#File I/O (Input/Output)|File I/O (Input/Output)]]
- [[#Functions|Functions]]
	- [[#Functions#Declaration (Prototype)|Declaration (Prototype)]]
	- [[#Functions#Function Definition|Function Definition]]
	- [[#Functions#Funtion Signature|Funtion Signature]]
	- [[#Functions#Pass-by-Value|Pass-by-Value]]
	- [[#Functions#Simulating Pass-by-Reference with Pointers|Simulating Pass-by-Reference with Pointers]]
	- [[#Functions#Returning Multiple Values|Returning Multiple Values]]
	- [[#Functions#Recursion|Recursion]]
- [[#Arrays & Strings|Arrays & Strings]]
	- [[#Arrays & Strings#Arrays|Arrays]]
		- [[#Arrays#Declaration and Initialization:|Declaration and Initialization:]]
		- [[#Arrays#Accessing Elements:|Accessing Elements:]]
	- [[#Arrays & Strings#Strings|Strings]]
		- [[#Strings#Declaration and Initialization:|Declaration and Initialization:]]
- [[#Pointers|Pointers]]
	- [[#Pointers#Declaration Syntax:|Declaration Syntax:]]
	- [[#Pointers#Pointer Arithmetic|Pointer Arithmetic]]
	- [[#Pointers#Pointers to Pointers|Pointers to Pointers]]
	- [[#Pointers#`void` Pointers|`void` Pointers]]
	- [[#Pointers#Dynamic Memory Allocation|Dynamic Memory Allocation]]
- [[#Storage Classes|Storage Classes]]
- [[#PreProcessor|PreProcessor]]
	- [[#PreProcessor#``#include``|``#include``]]
	- [[#PreProcessor#``#define``|``#define``]]
- [[#Conditional Compilation|Conditional Compilation]]
- [[#Structs|Structs]]
	- [[#Structs#Defining and Declaring Structs|Defining and Declaring Structs]]
		- [[#Defining and Declaring Structs#1. Defining a Struct Type (with `typedef`)|1. Defining a Struct Type (with `typedef`)]]
		- [[#Defining and Declaring Structs#2. Declaring Struct Variables|2. Declaring Struct Variables]]
	- [[#Structs#Accessing Struct Members|Accessing Struct Members]]
		- [[#Accessing Struct Members#1. The Dot Operator (`.`) - Direct Access'|1. The Dot Operator (`.`) - Direct Access']]
		- [[#Accessing Struct Members#2. The Arrow Operator (`->`) - Pointer Access|2. The Arrow Operator (`->`) - Pointer Access]]
	- [[#Structs#Structs and Function|Structs and Function]]
		- [[#Structs and Function#Passing Structs to Functions|Passing Structs to Functions]]
			- [[#Passing Structs to Functions#1. Pass-by-Value (The Whole Struct is Copied)|1. Pass-by-Value (The Whole Struct is Copied)]]
			- [[#Passing Structs to Functions#2. Pass-by-Reference (Using Pointers)|2. Pass-by-Reference (Using Pointers)]]
		- [[#Structs and Function#Returning a Struct from a Function|Returning a Struct from a Function]]
	- [[#Structs#Nested Structs|Nested Structs]]
	- [[#Structs#Comparison: Structs vs. Parallel Arrays|Comparison: Structs vs. Parallel Arrays]]
- [[#Command-Line Arguments|Command-Line Arguments]]
- [[#Unions|Unions]]
- [[#Type Casting|Type Casting]]
- [[#Style|Style]]
- [[#Common Syntax Errors|Common Syntax Errors]]

# Basic Program Structure
  > Every C program follows a basic structure.
  
  ```C
  // 1. Include the standard input/output library
#include <stdio.h>

// 2. The main function - the entry point of every C program
int main(void) {
    // 3. The function body - code goes inside the curly braces
    printf("Hello, World!\n"); // Print a string to the console

    // 4. Return 0 to indicate successful execution
    return 0;
}
  ```

|Part|Description|
|---|---|
|`#include <stdio.h>`|A **preprocessor directive** that includes the Standard Input/Output library, which contains functions like `printf`.|
|`int main(void)`|The **main function**. Program execution begins here. `int` means it will return an integer, and `(void)` means it takes no arguments.|
|`{ ... }`|**Curly braces** define the beginning and end of a code block (like the body of a function).|
|`printf(...)`|A **function call** that prints formatted text to the console.|
|`return 0;`|Exits the `main` function and returns the value `0` to the operating system, signaling that the program ran successfully.|
|`// ...` or `/* ... */`|**Comments**. They are ignored by the compiler and are used to explain the code.|
# Comments
> Comments are crucial for explaining your code. C supports two types.

>[!abstract]- Best Practice 
>Comment the _why_, not the _what_. Good code often explains _what_ it does. Comments should explain _why_ it's doing it, especially if the logic is complex.

|Type|Syntax|Example|
|---|---|---|
|**Single-line**|`// Your comment here`|`int age = 25; // Initialize the user's age`|
|**Multi-line**|`/* Your comment here */`|`/* This is a comment that spans multiple lines. It's useful for longer explanations. */`|
# Keywords and Identifiers
## Keywords
> Reserved words that have a special meaning to the C compiler (e.g., `int`, `return`, `if`, `for`). You cannot use them as variable names.

> [!info]- List of C Keywords
>  `auto`, `break`, `case`, `char`, `const`, `continue`, `default`, `do`, `double`, `else`, `enum`, `extern`, `float`, `for`, `goto`, `if`, `int`, `long`, `register`, `return`, `short`, `signed`, `sizeof`, `static`, `struct`, `switch`, `typedef`, `union`, `unsigned`, `void`, `volatile`, `while`
## Identifiers
> The names *you* give to variables, functions, etc.

- Can contain letters (a-z, A-Z), digits (0-9), and underscores (`_`).
- Must begin with a letter or an underscore.
- Case-sensitive (`myVar` is different from `myvar`).
# Data Types & Variables
> See the detailed reference table in [[K 7 - Slides - Datatyper#Datatyper - Tabel]]
## Syntax
```C
// Declaration
data_type variable_name;

// Initialization (giving it a value)
data_type variable_name = value;

// Multiple declarations
data_type var1, var2, var3;
```
> [!example]
```C
int student_count = 30;
double average_gpa = 3.75;
char grade = 'A';
```
# Operators
> Operators are symbols that perform operations on variables and values.
## Arithmetic Operators
| Operator | Name | Example |
| :--- | :--- | :--- |
| `+` | Addition | `5 + 2` // Result: 7 |
| `-` | Subtraction | `5 - 2` // Result: 3 |
| `*` | Multiplication | `5 * 2` // Result: 10 |
| `/` | Division | `5 / 2` // Result: 2 (integer division) |
| `%` | Modulo (Remainder) | `5 % 2` // Result: 1 |
## Relational & Comparison Operators
| Operator | Name                     | Example                       |
| -------- | ------------------------ | ----------------------------- |
| ==       | Equal to                 | `5 == 2` // Result: 0 (false) |
| `!=`     | Not equal to             | `5 != 2` // Result: 1 (true)  |
| `>`      | Greater than             | `5 > 2` // Result: 1 (true)   |
| `<`      | Less than                | `5 < 2` // Result: 0 (false)  |
| `>=`     | Greater than or equal to | `5 >= 5` // Result: 1 (true)  |
| `<=`     | Less than or equal to    | `5 <= 2` // Result: 0 (false) |
## Logical Operators
| Operator | Name        | Example                                   |
| -------- | ----------- | ----------------------------------------- |
| `&&`     | Logical AND | `(5 > 2) && (2 < 10)` // Result: 1 (true) |
| `!`      | Logical NOT | `!(5 > 2)` // Result: 0 (false)           |
## Assignment Operators
|Operator|Example|Equivalent To|
|---|---|---|
|`=`|`x = 5`|`x = 5`|
|`+=`|`x += 5`|`x = x + 5`|
|`-=`|`x -= 5`|`x = x - 5`|
|`*=`|`x *= 5`|`x = x * 5`|
|`/=`|`x /= 5`|`x = x / 5`
## Bitwise Operators
> Operate directly on the binary representation of numbers.

| Operator | Name        | Example                                          |
| :------- | :---------- | :----------------------------------------------- |
| `&`      | Bitwise AND | `5 & 3` // (0101 & 0011) -> 0001 (1)             |
| `        | Bitwise OR  | ``5 ' 3`` // (0101 ' 0011)  -> 0111 (7)          |
| `^`      | Bitwise XOR | `5 ^ 3` // (0101 ^ 0011) -> 0110 (6)             |
| `~`      | Bitwise NOT | `~5` // (~0101) -> 1010 (-6 in two's complement) |
| `<<`     | Left Shift  | `5 << 1` // (0101 << 1) -> 1010 (10)             |
| `>>`     | Right Shift | `5 >> 1` // (0101 >> 1) -> 0010 (2)              |
### Bitwise Operations in Practice
> Practical examples of how to use Bitwise to manipulate individual bits, a common and important technique in C. This is essential for low-level programming, embedded systems, working with hardware registers, or creating compact flag systems.

| Operation | Purpose | Code Example |
| :--- | :--- | :--- |
| **Set a bit** | Turn a specific bit to 1. | `number |= (1 << bit_position);` |
| **Clear a bit** | Turn a specific bit to 0. | `number &= ~(1 << bit_position);` |
| **Toggle a bit** | Flip a specific bit (0 to 1, or 1 to 0). | `number ^= (1 << bit_position);` |
| **Check a bit** | Test if a specific bit is 1. | `if (number & (1 << bit_position))` |
```C
#include <stdio.h>

int main() {
    // Define bit positions for flags
    const int FLAG_LOGGED_IN = 0; // Bit 0
    const int FLAG_IS_ADMIN = 1;  // Bit 1

    unsigned char user_status = 0; // 00000000 in binary

    // Set the LOGGED_IN flag
    user_status |= (1 << FLAG_LOGGED_IN); // user_status is now 00000001
    printf("Status after login: %d\n", user_status);

    // Check if the user is logged in
    if (user_status & (1 << FLAG_LOGGED_IN)) {
        printf("User is logged in.\n");
    }

    // Set the ADMIN flag
    user_status |= (1 << FLAG_IS_ADMIN); // user_status is now 00000011
    printf("Status after admin: %d\n", user_status);

    return 0;
}
```
## Special Operators
| Operator | Name                 | Example                              |
| :------- | :------------------- | :----------------------------------- |
| `sizeof` | Size of operator     | `sizeof(int)` // Returns 4 (usually) |
| `?:`     | Ternary conditional  | `int max = (a > b) ? a : b;`         |
| `&`      | Address of operator  | `int *ptr = &my_var;`                |
| `*`      | Dereference operator | `int value = *ptr;`                  |
# Control Flow Statements
## ``if-else`` Statement
> Executes a block of code if a condition is true.

```C
if (condition) {
    // Code to run if condition is true
} else if (another_condition) {
    // Code to run if the first condition is false and this one is true
} else {
    // Code to run if all conditions are false
}
```
## ``switch`` Statement
> A cleaner way to compare a variable against multiple constant values.

>[!tip] Don't forget the `break`! 
>Without a `break` at the end of each `case`, execution will "fall through" to the next case.

```C
switch (variable) {
    case constant1:
        // Code for case 1
        break;
    case constant2:
        // Code for case 2
        break;
    default:
        // Code if no cases match
        break;
}
```
# Loops
| Type | Syntax | Use Case |
| :--- | :--- | :--- |
| **`for`** | `for (init; condition; increment) { ... }` | When you know how many times you want to loop. |
| **`while`** | `while (condition) { ... }` | Loop as long as a condition is true. Check before the first iteration. |
| **`do-while`** | `do { ... } while (condition);` | Loop at least once, then continue as long as a condition is true. |
## Loop Control
- `break;`: Exits the innermost loop immediately.
- `continue;`: Skips the rest of the current iteration and proceeds to the next one.
- `goto label;`: Jumps to a labeled statement in the same function. **Use sparingly!**
# I/O Formatting (`printf` & `scanf`)
## `printf` (Print Formatted Data)
> Used to print output to the console.

| Specifier | Data Type | Example Output |
| :--- | :--- | :--- |
| `%d` / `%i` | `int` | `42` |
| `%u` | `unsigned int` | `42` |
| `%f` | `double` / `float` | `3.141500` |
| `%c` | `char` | `A` |
| `%s` | `char[]` (string) | `Hello` |
| `%p` | `pointer` | `0x7ffc1234abcd` |
| `%x` | `int` (hexadecimal) | `2a` |
> [!example]
```C
int age = 25;
printf("I am %d years old.\n", age);
```
## `scanf` (Scan Formatted Data)
> Used to read input from the user.

> [!warning] The `&` Operator 
> When using `scanf` to store a value in a variable, you must pass the **memory address** of the variable using the `&` operator (except for strings/arrays). `scanf("...", &variable);`

| Specifier | Data Type | Note |
| :--- | :--- | :--- |
| `%d` / `%i` | `int` | |
| `%u` | `unsigned int` | |
| `%f` | `float` | |
| `%lf` | `double` | **Use `%lf` for `double` with `scanf`!** |
| `%c` | `char` | Reads a single character. |
| `%s` | `char[]` (string) | Reads a sequence of characters (no spaces). |
> [!example]
```C
int age;
printf("Enter your age: ");
scanf("%d", &age); // Note the '&'!
printf("Next year you will be %d.\n", age + 1);
```
# File I/O (Input/Output)
> Almost every useful program needs to read from or write to files. This allows your data to persist even after the program has closed, making it possible to save user settings, store data, or process configuration files.
> 
> The core of file I/O in C is the `FILE` pointer, which is a reference to an open file.

| Function                         | Purpose                                    | Common Modes                                |
| :------------------------------- | :----------------------------------------- | :------------------------------------------ |
| `fopen(filename, mode)`          | Opens a file and returns a `FILE` pointer. | `"r"` (read), `"w"` (write), `"a"` (append) |
| `fclose(file)`                   | Closes an open file and flushes buffers.   |                                             |
| `fprintf(file, ...)`             | Writes formatted data to a file.           |                                             |
| `fscanf(file, ...)`              | Reads formatted data from a file.          |                                             |
| `fgets(str, size, file)`         | Reads a line from a file into a string.    |                                             |
| `fread(ptr, size, count, file)`  | Reads binary data from a file.             |                                             |
| `fwrite(ptr, size, count, file)` | Writes binary data to a file.              |                                             |
```C
#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file;
    char text[100];

    // --- Writing to a file ---
    file = fopen("example.txt", "w");
    if (file == NULL) {
        printf("Error opening file for writing!\n");
        return 1;
    }
    fprintf(file, "Hello, file!\nThis is a test.");
    fclose(file);

    // --- Reading from a file ---
    file = fopen("example.txt", "r");
    if (file == NULL) {
        printf("Error opening file for reading!\n");
        return 1;
    }
    printf("File content:\n");
    while (fgets(text, sizeof(text), file) != NULL) {
        printf("%s", text);
    }
    fclose(file);

    return 0;
}
```
# Functions
> Functions are reusable blocks of code that perform a specific task.
## Declaration (Prototype)
> Tells the compiler about a function's name, return type, and parameters. 
> Usually placed at the top of the file or in a header file (`.h`).
```C
return_type function_name(data_type param1, data_type param2);
```
## Function Definition
> The actual code that executes when the function is called.
```C
return_type function_name(data_type param1, data_type param2) {
    // Function body
    // ...
    return value; // Must match return_type
}
```

>[!example]
```C
#include <stdio.h>

// Function Declaration
int add(int a, int b);

int main(void) {
    int sum = add(5, 3); // Function Call
    printf("Sum: %d\n", sum);
    return 0;
}

// Function Definition
int add(int a, int b) {
    return a + b;
}
```
## Funtion Signature
> A function's signature consists of its return type, name, and parameters.
```C
return_type function_name(data_type param1, data_type param2);
```
## Pass-by-Value
> In C, arguments are passed to functions **by value**. This means the function receives a _copy_ of the arguments, not the original variables.
```C
void try_to_change(int x) {
    x = 100; // This only changes the local copy of x
}

int main(void) {
    int num = 10;
    try_to_change(num);
    printf("num is still %d\n", num); // Output: num is still 10
    return 0;
}
```
## Simulating Pass-by-Reference with Pointers
> To modify a variable in the calling function, you must pass its _address_ using a pointer.
```C
void actually_change(int *x_ptr) {
    *x_ptr = 100; // Dereference the pointer to change the original value
}

int main(void) {
    int num = 10;
    actually_change(&num); // Pass the address of num
    printf("num is now %d\n", num); // Output: num is now 100
    return 0;
}
```
## Returning Multiple Values
> A function can only return one value directly. To return multiple values, you can:
1. Use pointer parameters.
2. Return a `struct`.
```C
// Using pointers
void get_min_max(int arr[], int size, int *min, int *max) {
    *min = arr[0];
    *max = arr[0];
    for (int i = 1; i < size; i++) {
        if (arr[i] < *min) *min = arr[i];
        if (arr[i] > *max) *max = arr[i];
    }
}
```
## Recursion
> A function that calls itself. Must have a **base case** to stop the recursion.
```C
int factorial(int n) {
    // Base case
    if (n <= 1) {
        return 1;
    }
    // Recursive step
    return n * factorial(n - 1);
}
```
# Arrays & Strings
## Arrays
> A collection of elements of the same data type.
### Declaration and Initialization:
```C
// Declaration
int scores[5];

// Initialization
int scores[5] = {90, 85, 78, 92, 88};

// Partial initialization (rest are 0)
int scores[5] = {90, 85};

// Let compiler determine size
int scores[] = {90, 85, 78, 92, 88};
```
### Accessing Elements:
> Arrays are 0-indexed. `scores[0]` is the first element.
```C
scores[0] = 95; // Change the first element
```
## Strings
> In C, a string is a null-terminated array of characters. The null character `\0` marks the end of the string.
### Declaration and Initialization:
```C
// As a character array
char greeting[6] = {'H', 'e', 'l', 'l', 'o', '\0'};

// As a string literal (compiler adds \0)
char greeting[] = "Hello";
```
> [!danger] Buffer Overflow 
> C does not check array bounds. Writing past the end of an array leads to undefined behavior and security vulnerabilities.
# Pointers
> A pointer is a variable that stores the memory address of another variable.
## Declaration Syntax:
> `data_type *pointer_name;`
```C
int number = 10;
int *ptr; // Declare a pointer to an integer

// Assign the address of 'number' to the pointer
ptr = &number;

// Access the value at the address stored in the pointer (dereferencing)
int value = *ptr; // value is now 10

printf("Address of number: %p\n", (void*)&number);
printf("Address stored in ptr: %p\n", (void*)ptr);
printf("Value pointed to by ptr: %d\n", *ptr);

- - - 
  
int var = 10;
int *ptr;      // Declare a pointer to an integer
ptr = &var;    // Assign the address of 'var' to ptr

printf("Value of var: %d\n", var);       // 10
printf("Address of var: %p\n", &var);    // e.g., 0x7ffc1234abcd
printf("Value of ptr: %p\n", ptr);       // e.g., 0x7ffc1234abcd
printf("Value at address ptr: %d\n", *ptr); // 10 (Dereferencing)
```
## Pointer Arithmetic
> You can perform arithmetic operations on pointers. The operations are scaled by the size of the data type the pointer points to.
```C
int arr[] = {10, 20, 30, 40};
int *ptr = arr; // Points to arr[0]

printf("%d\n", *ptr);     // 10
printf("%d\n", *(ptr+1)); // 20
ptr++; // Now points to arr[1]
printf("%d\n", *ptr);     // 20
```
## Pointers to Pointers
> A pointer that stores the address of another pointer.
```C
int var = 10;
int *ptr = &var;
int **pptr = &ptr;

printf("%d\n", **pptr); // Prints 10
```
## `void` Pointers
> A generic pointer that can point to any data type. It cannot be dereferenced directly; it must be cast to another pointer type first.
```C
int i = 10;
void *vptr = &i;

printf("%d\n", *vptr); // ERROR: Cannot dereference a void pointer
printf("%d\n", *(int *)vptr); // OK: Cast to int pointer first
```
## Dynamic Memory Allocation
> Memory in C can be allocated in two main places: the **stack** (for local variables, managed automatically) and the **heap** (for dynamic allocation, managed manually by you).

| Function | Purpose | Important Note |
| :--- | :--- | :--- |
| `malloc(size)` | Allocates a block of `size` bytes. Memory is not initialized. | Returns `NULL` if allocation fails. |
| `calloc(num, size)` | Allocates an array of `num` elements of `size` bytes each. Memory is zero-initialized. | Safer than `malloc` for arrays. |
| `realloc(ptr, size)` | Resizes the memory block pointed to by `ptr` to `size` bytes. | Can be used to grow or shrink memory. |
| `free(ptr)` | Releases the memory block pointed to by `ptr`. | **Must** be called for every `malloc`/`calloc`. |
```C
#include <stdio.h>
#include <stdlib.h> // Required for malloc and free

int main() {
    int *numbers;
    int n = 5;

    // Allocate memory for 5 integers on the heap
    numbers = (int*)malloc(n * sizeof(int));
    if (numbers == NULL) {
        printf("Memory allocation failed!\n");
        return 1; // Exit if allocation fails
    }

    // Use the allocated memory like a normal array
    for (int i = 0; i < n; i++) {
        numbers[i] = i * 10;
        printf("numbers[%d] = %d\n", i, numbers[i]);
    }

    // Don't forget to free the memory when you're done!
    free(numbers);
    numbers = NULL; // Good practice to null the pointer after freeing

    return 0;
}
```
# Storage Classes
> Storage classes define the scope (visibility) and lifetime (duration) of a variable or function.

| Specifier  | Storage      | Scope                 | Lifetime | Default Value |
| :--------- | :----------- | :-------------------- | :------- | :------------ |
| `auto`     | Stack        | Local (within block)  | Block    | Garbage       |
| `register` | CPU Register | Local (within block)  | Block    | Garbage       |
| `static`   | Data Segment | Local (within block)  | Program  | Zero          |
| `extern`   | Data Segment | Global (across files) | Program  | Zero          |
# PreProcessor
> The preprocessor processes directives before the code is compiled.

## ``#include``
> Includes the contents of a file.
- `#include <stdio.h>`: Searches system directories.
- `#include "myheader.h"`: Searches the current directory first
## ``#define``
Creates macros or symbolic constants.
```C
// Symbolic Constant
#define PI 3.14159

// Function-like Macro
#define SQUARE(x) ((x) * (x)) // Parentheses are important!
```
# Conditional Compilation
> Includes or excludes parts of code based on conditions.
```C
#define DEBUG 1

#if DEBUG
    printf("Debug mode is ON.\n");
#endif
```
# Structs
> A `struct` (structure) is a user-defined data type in C that groups together variables of different data types under a single name. It is the fundamental building block for creating complex data models and is a powerful alternative to parallel arrays.
## Defining and Declaring Structs
### 1. Defining a Struct Type (with `typedef`)
> The most common and convenient way is to use `typedef` to create a new type name.
```C
// Define a new type named 'Student_t'
typedef struct {
    int id;
    char name[50];
    double gpa;
} Student_t;
```
Now, `Student_t` is a valid data type, just like `int` or `double`.
### 2. Declaring Struct Variables
> Once the type is defined, you can declare variables of that type.
```C
Student_t student1;          // A single student variable
Student_t class_list[30];    // An array of 30 students
Student_t *student_ptr;      // A pointer to a student
```
## Accessing Struct Members
> There are two operators for accessing the members of a struct.
### 1. The Dot Operator (`.`) - Direct Access'
> Used when you have a struct variable directly.
```C
Student_t student1;

// Assign values using the dot operator
student1.id = 1010;
strcpy(student1.name, "Alice"); // Use strcpy for strings
student1.gpa = 3.8;

// Access values
printf("Student: %s, GPA: %.2f\n", student1.name, student1.gpa);
```
### 2. The Arrow Operator (`->`) - Pointer Access
> Used when you have a **pointer** to a struct. It's a shortcut for dereferencing the pointer and then using the dot operator.
```C
Student_t student1 = {1010, "Alice", 3.8};
Student_t *student_ptr = &student1; // Pointer points to student1

// Access members using the arrow operator
printf("Student ID: %d\n", student_ptr->id); // Same as (*student_ptr).id

// Modify members
student_ptr->gpa = 3.9;
```

>[!tip] Remember the Difference
>- Use `.` when you have the actual struct object: `my_struct.member`
>- Use `->` when you have a pointer to the struct: `my_struct_ptr->member`
## Structs and Function
### Passing Structs to Functions
>You can pass structs to functions in two main ways.
#### 1. Pass-by-Value (The Whole Struct is Copied)
> This is simple but can be inefficient for large structs, as it involves copying every member.
```C
void print_student(Student_t s) { // 's' is a copy
    printf("ID: %d, Name: %s, GPA: %.2f\n", s.id, s.name, s.gpa);
}

// Usage
Student_t student1 = {1010, "Alice", 3.8};
print_student(student1);
```
#### 2. Pass-by-Reference (Using Pointers)
> This is much more efficient, especially for large structs, because only a memory address is passed. It also allows the function to modify the original struct.
```C
void update_gpa(Student_t *s_ptr, double new_gpa) {
    s_ptr->gpa = new_gpa; // Modify the original struct
}

// Usage
Student_t student1 = {1010, "Alice", 3.8};
update_gpa(&student1, 3.9); // Pass the address
```
### Returning a Struct from a Function
> A function can return a `struct`. The compiler handles the copying of the return value.
```C
Student_t create_student(int id, const char *name, double gpa) {
    Student_t new_student;
    new_student.id = id;
    strncpy(new_student.name, name, sizeof(new_student.name) - 1);
    new_student.name[sizeof(new_student.name) - 1] = '\0'; // Ensure null-termination
    new_student.gpa = gpa;
    return new_student;
}

// Usage
Student_t student2 = create_student(1011, "Bob", 3.5);
```
## Nested Structs
> A struct can contain another struct as a member. This is useful for modeling hierarchical data.
```C
typedef struct {
    int day;
    int month;
    int year;
} Date_t;

typedef struct {
    char name[50];
    Date_t birthdate; // Nested struct
} Person_t;

// Accessing nested members
Person_t p1;
strcpy(p1.name, "Charlie");
p1.birthdate.day = 15;
p1.birthdate.month = 6;
p1.birthdate.year = 1995;

printf("%s was born on %d/%d/%d\n", p1.name, p1.birthdate.day, p1.birthdate.month, p1.birthdate.year);
```
## Comparison: Structs vs. Parallel Arrays
| Feature            | Structs                                       | Parallel Arrays                                                  |
| :----------------- | :-------------------------------------------- | :--------------------------------------------------------------- |
| **Organization**   | High. Data is logically grouped.              | Low. Data is scattered across multiple arrays.                   |
| **Data Integrity** | High. Data for one object is always together. | Low. Easy to get arrays out of sync during sorting/modification. |
| **Function Calls** | Easy. Pass one pointer to access all data.    | Clunky. Must pass multiple arrays or pointers.                   |
| **Memory Usage**   | Potentially higher due to padding.            | Can be more memory-efficient.                                    |
| **Readability**    | High. Code is more self-documenting.          | Low. Requires tracking indices across arrays.                    |
# Command-Line Arguments
> Command-line arguments allow you to pass information to your program when you run it from the terminal.

To use command-line arguments, you must define the `main` function with two special parameters: `argc` and `argv`.

- `int argc`: **Argument Count**. The number of arguments passed to the program. It includes the program name itself.
- `char *argv[]`: **Argument Vector**. An array of strings (character pointers) containing the arguments. `argv[0]` is always the name of the program, `argv[1]` is the first argument, and so on.
```C
#include <stdio.h>

int main(int argc, char *argv[]) {
    printf("Program name: %s\n", argv[0]);
    printf("Number of arguments: %d\n", argc - 1);

    if (argc > 1) {
        printf("Arguments are:\n");
        for (int i = 1; i < argc; i++) {
            printf("  %d: %s\n", i, argv[i]);
        }
    } else {
        printf("No arguments were provided.\n");
    }

    return 0;
}
```
# Unions
> A `union` is a data structure that allows you to store different data types in the _same memory location_.

Unlike a `struct`, where each member has its own memory space, all members of a `union` share the same memory space. The size of the union is the size of its largest member.
> [!warning] One Member at a Time 
> Because all members of a union share the same memory, you should only use the member that was most recently assigned. Accessing a different member after an assignment will result in an undefined or reinterpreted value.

```C
#include <stdio.h>
#include <string.h>

// Define a union to hold different kinds of data
union Data {
    int i;
    float f;
    char str[20];
};

int main() {
    union Data data;

    data.i = 10;
    printf("data.i: %d\n", data.i);

    data.f = 220.5;
    printf("data.f: %.1f\n", data.f);

    // Note: The last assignment overwrites the previous ones
    // because they all share the same memory location.
    // The value of data.i is now meaningless.

    strcpy(data.str, "Hello C!");
    printf("data.str: %s\n", data.str);

    return 0;
}
```
# Type Casting
> Type casting is the process of converting a value from one data type to another.
> See [[K 7 - Slides - Datatyper#Eksplicit type-konvertering]]
> See [[K 7 - Slides - Datatyper#Datatyper - Tabel]]

A very common use case is to force floating-point division instead of integer division.
```C
#include <stdio.h>

int main() {
    int a = 5, b = 2;
    float result;

    // Without casting, this is integer division: 5 / 2 = 2
    result = a / b;
    printf("Integer division result: %.2f\n", result); // Output: 2.00

    // By casting 'a' to a float, we force floating-point division
    result = (float)a / b;
    printf("Float division result: %.2f\n", result);   // Output: 2.50

    return 0;
}
```
>[!tip] Casting Pointers 
>Casting is also used with pointers, especially with `void*`. A `void*` pointer can point to any data type, but you must cast it back to the correct pointer type before you can dereference it. See the `void` Pointers section for an example.
# Style
> Consistent formatting makes your code much easier to read.

- **Indentation:** Use tabs or spaces (be consistent!) to indent code inside blocks (`{ ... }`). A common standard is 4 spaces.
- **Spacing:** Use spaces around operators (`x = y + 5;`) and after commas (`printf("%d, %d", a, b);`).
- **Braces:** Place the opening brace `{` on the same line as the statement or on the next line. Be consistent!
- **Naming:** Use descriptive names for variables and functions (e.g., `student_count` instead of `sc`).
# Common Syntax Errors
> [!warning] Frequent Mistakes to Watch For
> - **Missing Semicolon:** Forgetting `;` at the end of a statement.
>- **Mismatched Braces:** Forgetting a `{` or `}`.
>- **Array Index Out of Bounds:** Accessing `my_array[5]` when the array only has 5 elements (valid indices are 0-4).
>- **Forgetting `&` in `scanf`:** `scanf("%d", my_var);` should be `scanf("%d", &my_var);`.
>- **Not `#include`-ing headers:** Forgetting to `#include <stdio.h>` for `printf` or `#include <math.h>` for `sqrt`.
>- **Undeclared Variables:** Using a variable before it has been declared.

