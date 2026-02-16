---
tags:
  - C
  - IMPR
  - CCT1
Topic: Strings, Character Arrays, String Lib Fuctions
Semester: CCT1
Course: IMPR1
Module: K9
Course Date: 14-11-25
Litterature:
  - Problem Solving and Program Design in C, Global Edition, 8th ed.
Created: 13-11-25
---
- - -
## Reference Tables
### 1. String & Character Input/Output Functions (`<stdio.h>`)

| Function      | Syntax / Prototype                             | Purpose                                                   | Key Parameters & Safety Notes                                                                        | Return Value                                  |
| :------------ | :--------------------------------------------- | :-------------------------------------------------------- | :--------------------------------------------------------------------------------------------------- | --------------------------------------------- |
| **`printf`**  | `int printf(const char *format, ...);`         | Displays formatted output. Uses `%s` for strings.         | Relies on a null terminator (`\0`).                                                                  | Number of characters printed.                 |
| **`scanf`**   | `int scanf(const char *format, ...);`          | Reads formatted input. Uses `%s` for strings.             | **Unsafe.** Prone to buffer overflow if input is longer than the destination array.                  | Number of items successfully read.            |
| **`gets`**    | `char *gets(char *str);`                       | Reads a full line from `stdin`, replacing `\n` with `\0`. | **Extremely Unsafe.** Does not check buffer size and will overflow the destination array. **Avoid.** | Pointer to `str` on success, `NULL` on error. |
| **`fgets`**   | `char *fgets(char *str, int n, FILE *stream);` | Reads a line from a stream.                               | **Safe.** Reads at most `n-1` characters and always null-terminates. Use `stdin` for keyboard input. | Pointer to `str` on success, `NULL` on error. |
| **`getchar`** | `int getchar(void);`                           | Reads a single character from `stdin`.                    | Returns an `int` to properly handle all character codes and `EOF`.                                   | The character read (as an `int`), or `EOF`.   |
| **`putchar`** | `int putchar(int char);`                       | Writes a single character to `stdout`.                    | The argument is an `int` character code.                                                             | The character written, or `EOF` on error.     |
| **`getc`**    | `int getc(FILE *stream);`                      | Reads a single character from a specified file stream.    | File-safe version of `getchar`.                                                                      | The character read (as an `int`), or `EOF`.   |
| **`putc`**    | `int putc(int char, FILE *stream);`            | Writes a single character to a specified file stream.     | File-safe version of `putchar`.                                                                      | The character written, or `EOF` on error.     |
### 2. String Manipulation Functions (`<string.h>`)

| Function      | Syntax / Prototype                                       | Purpose                                                  | Key Parameters & Safety Notes                                                                                       | Return Value                                                              |
| :------------ | :------------------------------------------------------- | :------------------------------------------------------- | :------------------------------------------------------------------------------------------------------------------ | :------------------------------------------------------------------------ |
| **`strcpy`**  | `char *strcpy(char *dest, const char *src);`             | Copies the entire `src` string to `dest`.                | **Unsafe.** Does not check if `dest` is large enough, leading to buffer overflow.                                   | Pointer to `dest`.                                                        |
| **`strncpy`** | `char *strncpy(char *dest, const char *src, size_t n);`  | Copies up to `n` characters from `src` to `dest`.        | **Safer, but with quirks.** Does **not** null-terminate if `src` length is `n` or more. You must add `\0` manually. | Pointer to `dest`.                                                        |
| **`strcat`**  | `char *strcat(char *dest, const char *src);`             | Appends `src` string to the end of `dest`.               | **Unsafe.** Does not check if `dest` has enough space for the combined string.                                      | Pointer to `dest`.                                                        |
| **`strncat`** | `char *strncat(char *dest, const char *src, size_t n);`  | Appends up to `n` characters from `src` to `dest`.       | **Safer.** Always null-terminates the result, even if truncation occurs.                                            | Pointer to `dest`.                                                        |
| **`strcmp`**  | `int strcmp(const char *s1, const char *s2);`            | Compares two strings lexicographically (alphabetically). | Case-sensitive.                                                                                                     | `< 0` if `s1` < `s2`, `0` if equal, `> 0` if `s1` > `s2`.                 |
| **`strncmp`** | `int strncmp(const char *s1, const char *s2, size_t n);` | Compares the first `n` characters of two strings.        | Case-sensitive.                                                                                                     | `< 0`, `0`, or `> 0` based on the comparison of the first `n` characters. |
| **`strlen`**  | `size_t strlen(const char *str);`                        | Returns the length of a string.                          | Excludes the null terminator (`\0`).                                                                                | Number of characters in `str`.                                            |
| **`strtok`**  | `char *strtok(char *str, const char *delim);`            | Breaks a string into tokens based on delimiters.         | **Modifies the original string** by inserting `\0`. Stateful: pass `NULL` on subsequent calls.                      | Pointer to the next token, or `NULL` if no more tokens.                   |
### 3. Character Analysis & Conversion Functions (`<ctype.h>`)

| Function      | Syntax / Prototype    | Purpose                                                      | Return Value                    |
| :------------ | :-------------------- | :----------------------------------------------------------- | :------------------------------ |
| **`isalpha`** | `int isalpha(int c);` | Checks if a character is an alphabetic letter.               | Non-zero if true, `0` if false. |
| **`isdigit`** | `int isdigit(int c);` | Checks if a character is a decimal digit (0-9).              | Non-zero if true, `0` if false. |
| **`islower`** | `int islower(int c);` | Checks if a character is a lowercase letter.                 | Non-zero if true, `0` if false. |
| **`isupper`** | `int isupper(int c);` | Checks if a character is an uppercase letter.                | Non-zero if true, `0` if false. |
| **`ispunct`** | `int ispunct(int c);` | Checks if a character is a punctuation mark.                 | Non-zero if true, `0` if false. |
| **`isspace`** | `int isspace(int c);` | Checks if a character is a whitespace (space, tab, newline). | Non-zero if true, `0` if false. |
| **`tolower`** | `int tolower(int c);` | Converts an uppercase letter to its lowercase equivalent.    | Lowercase version of `c`.       |
| **`toupper`** | `int toupper(int c);` | Converts a lowercase letter to its uppercase equivalent.     | Uppercase version of `c`.       |
### 4. String/Number Conversion Functions (`stdio.h`)

| Function      | Syntax / Prototype                                      | Purpose                                                             | Key Parameters & Safety Notes                                                  | Return Value                                   |
| :------------ | :------------------------------------------------------ | :------------------------------------------------------------------ | :----------------------------------------------------------------------------- | :--------------------------------------------- |
| **`sprintf`** | `int sprintf(char *str, const char *format, ...);`      | Formats data into a string, like `printf` but to a buffer.          | **Unsafe.** Does not check if `dest` is large enough for the formatted string. | Number of characters written (excluding `\0`). |
| **`sscanf`**  | `int sscanf(const char *str, const char *format, ...);` | Reads formatted data from a string, like `scanf` but from a buffer. | Safe.                                                                          | Number of items successfully assigned.         |
## Table of Contents
- [[#Intro|Intro]]
- [[#8.1 String Basics|8.1 String Basics]]
	- [[#8.1 String Basics#Declaring and Initializing String Variables|Declaring and Initializing String Variables]]
		- [[#Declaring and Initializing String Variables#String Literals vs. Character Arrays|String Literals vs. Character Arrays]]
	- [[#8.1 String Basics#Arrays of Strings|Arrays of Strings]]
	- [[#8.1 String Basics#Input/Output with ``printf`` and ``scanf``|Input/Output with ``printf`` and ``scanf``]]
		- [[#Input/Output with ``printf`` and ``scanf``#``printf``|``printf``]]
		- [[#Input/Output with ``printf`` and ``scanf``#``scanf``|``scanf``]]
- [[#8.2 String Library Functions: Assignment and Substrings|8.2 String Library Functions: Assignment and Substrings]]
	- [[#8.2 String Library Functions: Assignment and Substrings#String Assignment|String Assignment]]
	- [[#8.2 String Library Functions: Assignment and Substrings#Substrings|Substrings]]
		- [[#Substrings#Extracting Substrings with `strncpy`|Extracting Substrings with `strncpy`]]
- [[#8.3 Longer Strings: Concatenation and Whole-Line Input|8.3 Longer Strings: Concatenation and Whole-Line Input]]
	- [[#8.3 Longer Strings: Concatenation and Whole-Line Input#Concatenation|Concatenation]]
		- [[#Concatenation#Using ``strlen`` for Safe Concatenation|Using ``strlen`` for Safe Concatenation]]
	- [[#8.3 Longer Strings: Concatenation and Whole-Line Input#Distinction Between Characters and Strings|Distinction Between Characters and Strings]]
	- [[#8.3 Longer Strings: Concatenation and Whole-Line Input#Scanning a Full Line|Scanning a Full Line]]
		- [[#Scanning a Full Line#The `gets` Function|The `gets` Function]]
		- [[#Scanning a Full Line#The `fgets` Function|The `fgets` Function]]
			- [[#The `fgets` Function#Using `fgets` for Interactive Input|Using `fgets` for Interactive Input]]
- [[#8.4 String Comparison|8.4 String Comparison]]
- [[#Defensive Programming|Defensive Programming]]
	- [[#Defensive Programming#Characteristic 1: Creating Readable Code|Characteristic 1: Creating Readable Code]]
	- [[#Defensive Programming#Characteristic 2: Ensuring Predictable Results|Characteristic 2: Ensuring Predictable Results]]
	- [[#Defensive Programming#The Cost-Benefit Trade-off|The Cost-Benefit Trade-off]]
- [[#8.5 Arrays of Pointers|8.5 Arrays of Pointers]]
	- [[#8.5 Arrays of Pointers#Declaration and Initialization|Declaration and Initialization]]
	- [[#8.5 Arrays of Pointers#Arrays of String Constants|Arrays of String Constants]]
- [[#8.6 Character Operations|8.6 Character Operations]]
	- [[#8.6 Character Operations#Character Input/Output|Character Input/Output]]
		- [[#Character Input/Output#`getchar()` for Input|`getchar()` for Input]]
		- [[#Character Input/Output#``getc()`` for Input|``getc()`` for Input]]
		- [[#Character Input/Output#`putchar()` for Output|`putchar()` for Output]]
	- [[#8.6 Character Operations#Character Analysis and Conversion|Character Analysis and Conversion]]
- [[#8.7 String-to-Number and Number-to-String Conversions|8.7 String-to-Number and Number-to-String Conversions]]
	- [[#8.7 String-to-Number and Number-to-String Conversions#Number-to-String Conversion with `sprintf`|Number-to-String Conversion with `sprintf`]]
	- [[#8.7 String-to-Number and Number-to-String Conversions#String-to-Number Conversion with `sscanf`|String-to-Number Conversion with `sscanf`]]
- [[#8.8 String Processing Illustrated|8.8 String Processing Illustrated]]
	- [[#8.8 String Processing Illustrated#The "Problem"|The "Problem"]]
	- [[#8.8 String Processing Illustrated#Core Concepts & Design|Core Concepts & Design]]
	- [[#8.8 String Processing Illustrated#Key Helper Functions|Key Helper Functions]]
		- [[#Key Helper Functions#- `int pos(const char *source, const char *to_find)`|- `int pos(const char *source, const char *to_find)`]]
		- [[#Key Helper Functions#- `char *delete(char *source, int index, int n)`|- `char *delete(char *source, int index, int n)`]]
		- [[#Key Helper Functions#- `char *insert(char *source, const char *to_insert, int index)`|- `char *insert(char *source, const char *to_insert, int index)`]]
	- [[#8.8 String Processing Illustrated#Program Flow|Program Flow]]
	- [[#8.8 String Processing Illustrated#Testing Strategy|Testing Strategy]]
- [[#8.9 Common Programming Errors|8.9 Common Programming Errors]]
	- [[#8.9 Common Programming Errors#1. Returning Pointers to Local Strings|1. Returning Pointers to Local Strings]]
	- [[#8.9 Common Programming Errors#2. Buffer Overflow|2. Buffer Overflow]]
	- [[#8.9 Common Programming Errors#3. Forgetting the Null Terminator (`\0`)|3. Forgetting the Null Terminator (`\0`)]]
	- [[#8.9 Common Programming Errors#4. Using Wrong Operators for Comparison and Assignment|4. Using Wrong Operators for Comparison and Assignment]]
		- [[#4. Using Wrong Operators for Comparison and Assignment#Comparison Error (`==`)|Comparison Error (`==`)]]
		- [[#4. Using Wrong Operators for Comparison and Assignment#Assignment Error (`=`)|Assignment Error (`=`)]]
	- [[#8.9 Common Programming Errors#5. Misuse of the Address-of Operator (`&`)|5. Misuse of the Address-of Operator (`&`)]]
# Intro
> [!info]
> Most applications that process character data deal with a grouping of characters, a data structure called a *string*.
> C implements the string data structure using arrays of type ``char``.

Strings are important in computer science because many computer applications are concerned with the manipulation of textual data rather than numerical data.
	Computer-based *word processing systems* enable a user to compose letters, term papers, newspaper articles, and even books at a computer instead of at a typewriter.

Strings play an important role in science as well.
	- The chemist works with elements and compounds whose names often combine alphabetic and numeric characters.
	- Molecular biologists identify amino acids by name and map our DNA with strings of amino acid abbreviations.
	- Many mathematicians, physicists, and engineers spend more time modeling our world with equations (strings of character and numeric data) than they do crunching number
# 8.1 String Basics
Every one of our calls to`` scanf`` or ``printf`` used a *string* constant as the first argument.

> [!example] ``printf``
> ```C
> printf("Average = %.2f", avg);
> ```
> The first argument is the string constant ``Average = %.2f``, a string of $14$ characters. 
>> [!warning] Note 
>> Notice that the blanks in the string are characters just as valid as those requiring ink!

Like other constant values, a string constant can be associated with a symbolic name using the ``#define ``directive. 
## Declaring and Initializing String Variables
declaring a string variable is the same as declaring an array of type ``char``.
> [!example]
> ```C
> char string_var[30];
> // the variable string_var will hold strings from 0 to 29 characters long.
> ```

 It is C’s handling of this varying length characteristic that distinguishes the string data structure from other arrays.
 > [!example]
 > ```C
 > char str[20] = "Initial value";
 > ```
 > 
 > Memory after this declaration with initialization:
 > ![[Pasted image 20251113105936.png]]
 >> [!note]
 >>  Notice that ``str[13]`` contains the character ``\0``, the *null character* that marks the end of a string.
 >>  All of C’s stringhandling functions simply ignore whatever is stored in the cells following the null character.
 >
 >For ``str`` in this example the longest it can represent—$19$ characters plus the null character.
### String Literals vs. Character Arrays
It's crucial to understand the difference between initializing a character array with a string literal and assigning a string literal to a character pointer. They behave very differently.

> [!example] Internal Representation: `'Q'` vs. `"Q"` 
> The character `'Q'` and the string `"Q"` are stored in memory completely differently.
> 
> | Concept | Example | Internal Representation | Key Feature |
|---|---|---|---|
| **Character** | `'Q'` | A single byte storing the ASCII value for 'Q'. | No null terminator. |
| **String** | `"Q"` | An array of two characters: `'Q'` followed by `'\0'`. | **Must** be null-terminated. |
![[Pasted image 20251113151638.png]]
>This distinction extends to how we declare variables
>```C
>// Method 1: Character Array (modifiable)
>char arr[] = "Hello";
>// Allocates 6 bytes on the stack for 'H', 'e', 'l', 'l', 'o', '\0'.
>// You can modify this array: arr[0] = 'h'; // This is valid.
>
>// Method 2: Pointer to String Literal (read-only)
>char *ptr = "Hello";
>// Allocates 6 bytes in a read-only memory segment for the literal.
>// 'ptr' is just a variable on the stack holding the address of that literal.
>// Modifying this is undefined behavior: ptr[0] = 'h'; // DANGEROUS! May crash.
>```
>**Key Takeaway:** 
>Use character arrays (`char arr[]`) when you need to modify the string. Use pointers to literals (`char *ptr`) only when you are treating the string as a constant, read-only value.

## Arrays of Strings
Because one string is an array of characters, an array of strings is a two-dimensional array of characters in which each row is one string.

> [!example]
> ```C
> #define NUM_PEOPLE 30 
> #define NAME_LEN 25 
> . . . 
> char names[NUM_PEOPLE][NAME_LEN];
> ```
> This declares an array to store up to $30$ names, each of which is less than $25$ characters long.

> [!summary] initialize an array of strings
> We can initialize an array of strings at declaration in the following manner:
> ```C
> char month[12][10] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
> ```
> This initiates the $12$ months, with names of the months up to $10$ characters
## Input/Output with ``printf`` and ``scanf``
Both ``printf`` and ``scanf`` can handle *string arguments* as long as the placeholder ``%s`` is used in the format string.
> [!example]
> ```C
> printf("Topic: %s\n", string_var);
> 
> scanf("%s", string_var);
> ```
### ``printf``
The ``printf`` function, depends on finding a null character in the character array to mark the end of the string.
> [!bug]- If ``printf`` were passed a character array that contained no ``\0``.
> Fhe function would first interpret the contents of each array element as a character and display it. 
> Then ``printf`` would continue to display as characters the contents of memory locations following the array argument until it encountered a null character or until it attempted to access a memory cell that was not assigned to the program, causing a run-time error.

The ``%s`` placeholder in a ``printf`` format string can be used with a minimum field width.
> [!example]
> ```C
> printf ("***%8s***%3s***\n", "Short", "Strings");
> ```
> The first string is displayed right-justified in a field of ***eight*** columns. 
> The second string is longer than the specified field width, so the field is expanded to accommodate it exactly with no padding.
> ```C Output
> ***   Short***Strings***
> ```

Placing a minus sign prefix on a placeholder’s field width causes left justification of the value displayed.
> [!example]
> If **president** is a string variable, repeated execution of this call to ``printf`` will produce a left-justified list.
> ```C
> printf("%-20s\n", president);
> 
> - - - 
>   
>// Loop through each row of the array
>for (int i = 0; i < num_rows; i++) {
> 	// Print the name with left-justification
>	printf("%-20s\n", president[i]);
> }
> ```

![[Pasted image 20251113113909.png]]
### ``scanf``
The ``scanf`` function can be used for input of a string.
> [!note]
> When we call ``scanf`` with a string variable as an argument, we must remember that array output arguments are *always* passed to functions by sending the ***address*** of the initial array element.
> Therefore, we do not apply the address-of operator (``&``) to a string argument passed to scanf or to any other function.

The approach ``scanf`` takes to string input is very similar to its processing of numeric input.
	Starting with the first nonwhitespace character, it copies the characters it encounters into successive memory cells of its character array argument.
	When it comes across a whitespace character, scanning stops, and places the null character at the end of the string in its array argument.

> [!example] String I/O with ``scanf`` & ``printf``
> ```C
> #include <stdio.h>
>
>#define STRING_LEN 10
>
>int main(void) {
>    char dept[STRING_LEN];
>    int course_num;
>    char days[STRING_LEN];
>    int time;
>
>    printf("Enter department code, course number, days and ");
>    printf("time like this:\n> COSC 2060 MWF 1410\n> ");
>    scanf("%s%d%s%d", dept, &course_num, days, &time);
>    printf("%s %d meets %s at %d\n", dept, course_num, days, time);
>
>    return 0;
>}
>
>Enter department code, course number, days and time like this: 
> COSC 2060 MWF 1410 
> > MATH 1270 TR 800 
> > MATH 1270 meets TR at 800
> ```

> [!tip] ``scanf``'s Flexibility with Whitespace 
> `scanf` treats any whitespace (spaces, tabs, newlines) as a separator. This allows input to be formatted in many ways and still be read correctly.
 ![[Pasted image 20251113115402.png]] ![[Pasted image 20251113115426.png]]
 
 > [!warning] ``scanf`` and Whitespace 
 > `scanf` relies on whitespace to separate values that correspond to its format specifiers. If essential whitespace is omitted, `scanf` will consume too much data into one variable and then fail when trying to process the next part of the input.
 > ```C
 > > MATH1270 TR 1800
 > > MATH,1270,TR,1800
 > ```
 > - `scanf` stores the eight-character string `"MATH1270"` in `dept` because the `%s` specifier reads all characters until it encounters whitespace.
>- It then attempts to convert the character `'T'` (from `"TR"`) into an integer for `course_num`, which is impossible. The `scanf` operation stops and fails at this point.
>![[Pasted image 20251113120927.png]]

> [!important] Buffer Overflow 
> A *buffer overflow* occurs when a program writes data past the end of an allocated buffer (like a character array). This is a very dangerous condition that is **unlikely to be flagged as an error** by the compiler or the run-time system.
> 
>>[!summary] **Guideline for `scanf` with `%s`:**
>> 
>> - **Acceptable for:** Easy input of predictable-length strings that have no internal blanks.
>> - **Avoid for:** Critical applications or environments where the proper data entry format may not be observed. In these cases, a more robust string input function should be used.
# 8.2 String Library Functions: Assignment and Substrings
In C, you **cannot** use the standard assignment operator (`=`) to copy a string into a character array that has already been declared.
> [!important] **Invalid Target of Assignment**
> ```C
> char one_str[20];
one_str = "Test string"; /* DOES NOT WORK */
> ```

The reason for this error is fundamental to how C handles arrays. An array name (like `one_str`) with no subscript is treated as a **constant pointer** to the address of its first element. Since this address is constant, you cannot change it through assignment. The code above attempts to make `one_str` point to the memory location of the string literal `"Test string"`, which is not allowed.

C provides string manipulation operations through **library functions**, much like it provides mathematical operations like `sqrt` or `abs`. The standard library `<string.h>` contains a rich set of functions for common string tasks, including:

- **Assignment** (copying strings)
- **Concatenation** (joining strings)
- **Substring** (extracting parts of strings)
- **String Length**
- **String Comparison**
These functions perform the work that the assignment operator cannot. For example, to copy a string, you would use the `strcpy` function.
> [!tip] Function Return Types 
> Many of the string-building functions in `<string.h>` return a value of type `char *`. 
> This is a pointer to the resulting string, which is consistent with how C represents arrays using pointers to their initial elements.

>[!summary]- String Library Functions (`string.h`) 
>Here is a reference table for common string manipulation functions from the `string.h` library. Pay close attention to the safety notes and when to use each function.
>
>| Function  | Purpose                                               | Prototype                                                 | Return Value                                                           | Safety & Notes                                                                                                                                                                                                                   |
| --------- | ----------------------------------------------------- | --------------------------------------------------------- | ---------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `strcpy`  | Copies the entire `source` string to `dest`.          | `char *strcpy(char *dest, const char *source)`            | Pointer to `dest`.                                                     | **Unsafe.** No buffer size check. High risk of buffer overflow. Use only when you are 100% certain `dest` is large enough.                                                                                                       |
| `strncpy` | Copies up to `n` characters from `source` to `dest`.  | `char *strncpy(char *dest, const char *source, size_t n)` | Pointer to `dest`.                                                     | **Safer, but with quirks.** <br>1. **Does not null-terminate** if `source` length is `n` or more. You must add the `\0` manually. <br>2. If `source` is *shorter* than `n`, it **pads** the rest of `dest` with `\0` characters. |
| `strcat`  | Appends the `source` string to the end of `dest`.     | `char *strcat(char *dest, const char *source)`            | Pointer to `dest`.                                                     | **Unsafe.** No buffer size check for the destination array. High risk of buffer overflow.                                                                                                                                        |
| `strncat` | Appends up to `n` characters from `source` to `dest`. | `char *strncat(char *dest, const char *source, size_t n)` | Pointer to `dest`.                                                     | **Safer.** Always null-terminates the destination string, even if truncation occurs. This makes it generally safer than `strncpy` for concatenation.                                                                             |
| `strcmp`  | Compares two strings (`s1`, `s2`) lexicographically.  | `int strcmp(const char *s1, const char *s2)`              | `< 0` if `s1` < `s2`, `0` if equal, `> 0` if `s1` > `s2`.              | Safe.                                                                                                                                                                                                                            |
| `strncmp` | Compares the first `n` characters of two strings.     | `int strncmp(const char *s1, const char *s2, size_t n)`   | `< 0`, `0`, `> 0` based on the comparison of the first `n` characters. | Safe.                                                                                                                                                                                                                            |
| `strlen`  | Returns the length of a string.                       | `size_t strlen(const char *s)`                            | Number of characters in `s` (excluding the `\0`).                      | Safe.                                                                                                                                                                                                                            |
| `strtok`  | Breaks a string into tokens using delimiters.         | `char *strtok(char *source, const char *delim)`           | Pointer to the next token, or `NULL` if no more are found.             | **Modifies the original string** by inserting null characters. Is stateful; use `NULL` for `source` on subsequent calls to continue tokenizing the same string.                                                                  |
## String Assignment
The `strcpy` function copies its second argument (the source string) into its first argument (the destination array).
> [!example]
> ```C
> char one_str[20];
strcpy(one_str, "Test String"); // Copies "Test String" into one_str
> ```
> ![[Pasted image 20251113125246.png]]
> 

>[!warning] **Buffer Overflow Danger** 
> `strcpy` does **not** check if the destination array is large enough to hold the source string. 
> Like a call to ``scanf`` with a ``%s`` placeholder, a call to ``strcpy`` can easily overflow the space allocated for the destination variable.
>> [!example]
>> ```C
>> // DANGEROUS: one_str can only hold 19 chars + '\0'
strcpy(one_str, "A very long test string"); 
>> ```
>> This will overwrite memory beyond the bounds of `one_str`, corrupting other variables and potentially crashing the program.
>> ![[Pasted image 20251113125255.png]]
>>> [!danger] Note
>>> Although this call to ``strncpy`` has prevented overflow of destination string ``one_str``, it has not stored a valid string in ``one_str`` 
>>> The array `one_str` will contain $20$ characters but no `\0`, making it an unterminated string.

There is a way to safely copy a string without risking an overflow or an unterminated string.
In general, one can assign as much as will fit of a source string (source) to a destination (dest) of length ``dest_len`` by using these two statements.
```C
// 1. Copy at most dest_len - 1 characters
strncpy(dest, source, dest_len - 1);
// 2. Explicitly null-terminate the destination string
dest[dest_len - 1] = '\0';
```
This ensures that no matter the length of the `source` string, `dest` will always contain a valid, null-terminated string that fits within its allocated space.

Both `strcpy` and `strncpy` return a pointer to the destination string. This allows the function result to be used directly in other operations, for example: `printf("%s", strcpy(dest, source));`.
The calling function actually has two ways of referencing the results: It can either use the first argument from the call or use the function result. This characteristic is typical of string-building functions in the string library.
## Substrings
We frequently need to extract a _substring_—a smaller, contiguous part of a larger string. C does not have a dedicated substring function, but we can achieve this by cleverly using the standard string library functions.
### Extracting Substrings with `strncpy`
The `strncpy` function is the primary tool for copying a specific number of characters from a source string to a destination. By manipulating the source address, we can extract any part of the string.
> [!warning] **Remember to Null-Terminate!** 
> When using `strncpy`, you are responsible for ensuring the destination string is properly null-terminated.

- Extracting the Beginning
  To copy the first `n` characters, simply use `strncpy` as intended.
```C
char result[10], s1[15] = "Jan. 30, 1996";
strncpy(result, s1, 9); // Copies "Jan. 30, "
result[9] = '\0';      // Manually null-terminate
```
![[Pasted image 20251113131134.png]]
- Extracting the Middle
  To copy a middle substring, pass the _address_ of the starting character as the source argument.
```C
// To extract "30" from s1
strncpy(result, &s1[5], 2); // Start at index 5, copy 2 chars
result[2] = '\0';           // Manually null-terminate
```
Here, `&s1[5]` provides the address of the character `'3'`, telling `strncpy` to start copying from there.
![[Pasted image 20251113131152.png]]
- Extracting Endings
To copy all characters from a certain position to the end of a string, `strcpy` is more convenient. It automatically copies until it finds the original string's null terminator.
```C
// To extract "1996" from s1
strcpy(result, &s1[9]); // Copies from index 9 to the end
```
This call copies the characters starting at `&s1[9]` (`'1'`) and continues until the `\0` is found and copied.
> [!example] Program Using ``strncpy`` and ``strcpy`` Functions to Separate Chemical Compounds into Elemental Components
> The program's purpose is to take a chemical formula like `H2SO4` and break it down into its individual elemental components (`H2`, `S`, `O4`). It identifies a new component whenever it finds a capital letter.
> ```C
> /*
> * Displays each elemental component of a compound
> */
>
>#include <stdio.h>
>#include <string.h>
>
>#define CMP_LEN 30 /* size of string to hold a compound */
>#define ELEM_LEN 10 /* size of string to hold a component */
>
>int main(void) {
>    char compound[CMP_LEN]; /* string representing a compound */
>    char elem[ELEM_LEN];    /* one elemental component */
>    int first, next;
>
>    /* Gets data string representing compound */
>    printf("Enter a compound> ");
>    scanf("%s", compound);
>
>    /* Displays each elemental component. These are identified
>       by an initial capital letter. */
>    first = 0;
>    for (next = 1; next < strlen(compound); ++next) {
>        if (compound[next] >= 'A' && compound[next] <= 'Z') {
>            strncpy(elem, &compound[first], next - first);
>            elem[next - first] = '\0';
>            printf("%s\n", elem);
>            first = next;
>        }
>    }
>
>    /* Displays the last component */
>    printf("%s\n", strcpy(elem, &compound[first]));
>
>    return (0);
>}
>
>Enter a compound> H2SO4
>H2
>S
>O4
> ```
> 
> After the user enters `H2SO4`, the `compound` array looks like this:
>
>|Index|`[0]`|`[1]`|`[2]`|`[3]`|`[4]`|`[5]`|
>|---|---|---|---|---|---|---|
>|Value|`H`|`2`|`S`|`O`|`4`|`\0`|
>
>> [!note] The `strlen(compound)` function will return `5` 
>> because there are 5 characters before the null terminator. This is the **effective size** used by the loop, not the declared size `CMP_LEN`.
>
>The program works by identifying new components whenever it finds a capital letter. 
>
>Iteration 1
>- `first = 0`. The loop starts with `next = 1`.
>- `next = 1`: `compound[1]` is `'2'`. Not a capital letter. Loop continues.
>- `next = 2`: `compound[2]` is `'S'`. **This is a capital letter!** This is the trigger. We've found the end of the first component (`H2`) and the start of the second (`S`).
>- **Extract "H2":**
>    - `strncpy(elem, &compound[first], next - first);` becomes `strncpy(elem, &compound[0], 2);`. It copies exactly 2 characters (`'H'`, `'2'`) into `elem`.
>    - `elem[next - first] = '\0';` becomes `elem[2] = '\0';`. **Crucially**, we manually add the null terminator to make `elem` a valid string.
>- `printf("%s\n", elem);` prints `H2`.
>- `first = next;` updates `first` to `2`, so we are now positioned at the start of the `'S'`.
>
>Iteration 2
>- The loop continues from `next = 3`. It finds `compound[3]` is `'O'`, another capital letter.
>- **Extract "S":**
>    - `strncpy(elem, &compound[2], 1);` copies 1 character (`'S'`) into `elem`.
>    - `elem[1] = '\0';` adds the null terminator.
>- `printf("%s\n", elem);` prints `S`.
>- `first = next;` updates `first` to `3`, pointing to `'O'`.
>
>After the Loop 
>The loop finishes because `next` reaches `5`, which is not less than `strlen(compound)`. We still need to print the last component, `O4`.
>
>- `printf("%s\n", strcpy(elem, &compound[first]));` is called with `first = 3`.
>- `strcpy(elem, &compound[3])` copies the substring starting at index 3 (`"O4"`) into `elem`. Since `"O4"` is a complete, null-terminated string, `strcpy` handles it perfectly.
>- `strcpy` returns a pointer to `elem`, which `printf` immediately uses to print the final result: `O4`.
>
>|Step|Action|Function Used|Why?|
>|---|---|---|---|
>|**Inside Loop**|Extract a middle component (`H2`, `S`)|`strncpy`|We need to copy a specific _count_ of characters from the middle of a string.|
>|**After Loop**|Extract the final component (`O4`)|`strcpy`|We are copying a "complete", null-terminated substring from its start to its end. This allows us to use the function's return value for conciseness.|
>
>> [!tip] Why Different Functions?
>> The loop uses `strncpy` because we're copying a specific number of characters from the middle of a string. For the last component, we use `strcpy` because we're copying a complete, null-terminated substring from its start to its end, which allows us to use the function's return value for conciseness.

# 8.3 Longer Strings: Concatenation and Whole-Line Input
## Concatenation
>[!info]
>String *concatenation* is the process of joining two strings to form a longer string. 
>In C, the ``<string.h>`` library provides functions that allow us to concatenate strings, but they require careful handling to avoid buffer overflow issues.

String library functions ``strcat`` and ``strncat`` modify their first string argument by adding all or part of their second string argument at the **end** of the first argument. 
> [!warning]
> Both functions assume that sufficient space is allocated, for the first argument to allow addition of the extra characters.

> [!example]
> ```C
> #define STRSIZ 15 
> char f1[STRSIZ] = "John ", f2[STRSIZ] = "Jacqueline ", last[STRSIZ] = "Kennedy"; 
> strcat(f1, last); strcat(f2, last); /* invalid overflow of f2 */
> ```
> In this example, the second call to `strcat` creates a $19$-character string (including '\0'), which overflows the $15$-character array `f2`. This could corrupt adjacent memory and lead to unpredictable behavior.
> 
> To prevent buffer overflow, you can use `strncat` with a carefully calculated limit.
> ```C
> strncat(f2, last, 3);  // Adds only "Ken" to create "Jacqueline Ken"
> ```
> In this example, only 3 characters from "Kennedy" are appended, ensuring the result fits within the allocated space. 

> [!important] Why `strncat` is Safer for Concatenation 
> The key difference that makes `strncat` safer than `strncpy` for concatenation is its handling of the null terminator.
>- `strncat(dest, src, n)` always writes a `\0` at the end of the destination string, even if it has to truncate the source string to fit. This guarantees that `dest` will always be a valid, well-formed string.
>- `strncpy(dest, src, n)` will _not_ write a `\0` if the source string's length is `n` or greater, leaving you with an unterminated string and a potential buffer overflow on the next operation.
>
>Therefore, for concatenation, `strncat` is the preferred safer choice.
### Using ``strlen`` for Safe Concatenation
When writing a string-manipulating program, one usually does not know in advance the sizes of the strings used as data.
The `strlen` function returns the length of a string (excluding the null terminator). It can be used to implement safe concatenation practices.
```C
size_t strlen(const char *str);
```
>[!example]
>```C
>#define STRSIZ 20
>char s1[STRSIZ] = "Jupiter ", s2[STRSIZ] = "Symphony";
>
>printf("%d %d\n", strlen(s1), strlen(strcat(s1, s2)));
>printf("%s\n", s1);
>```
>This example displays the numbers '8' and '16', followed by "Jupiter Symphony". 
>>[!note] Note
>>- The blank at the end of the initial value of ``s1`` is counted in its length
>>- The call to `strcat` modifies ``s1`` even when embedded in other function calls

Both ``strcat`` and ``strncat`` return as the function value the modified first argument.
>[!important]
>If ``s1`` and ``s2`` are both character strings declared to hold ``STRSIZ`` characters, the following decision statement would concatenate the full strings, if possible without overflow, and would concatenate only as much of the second string as would fit otherwise.
> ```C
> if (strlen(s1) + strlen(s2) < STRSIZ)
>    strcat(s1, s2);                    // Full concatenation if space allows
>else
>    strncat(s1, s2, STRSIZ - strlen(s1) - 1);  // Partial concatenation otherwise
> ```
>> [!question] **Why `< STRSIZ` and not `<= STRSIZ`?** 
>> The condition correctly verifies that the sum of the lengths of ``s1`` and ``s2`` is strictly less than ``STRSIZ``; if the sum equaled ``STRSIZ``, then the '*\0*' that strcat places at the end of its result would overflow ``s1`` by $1$.

> [!summary]
> > [!important]
> > You can see from our examples of the use of strcpy, strncpy, strcat, and strncat that there are two critical questions that must always be in the mind of a C programmer who is manipulating strings: 
> > - Is there enough space in the output parameter for the entire string being created? 
> > - Does the created string end in '\0'?
## Distinction Between Characters and Strings
When working with string functions like `strcat`, it's crucial to understand the difference between **a single character** and *a string*. 
A common mistake is attempting to use ***a single character*** where a string is expected.

Functions like `strcat` are designed to work with strings, which are represented as pointers to their first character (`char *`). A single character value (`char`) is a different data type and cannot be used as a valid argument for these functions.
>[!warning] **Invalid Operation** 
>The following code is invalid and will lead to a compiler error or undefined behavior.
>```C
>char my_str[10] = "Hello";
strcat(my_str, '!'); // INCORRECT: '!' is a char, not a char *
>```
>The reason this fails is due to how C represents characters versus strings internally.

> [!example] ### Internal Representation: `'Q'` vs. `"Q"`
> The character `'Q'` and the string `"Q"` are stored in memory completely differently.
> 
> | Concept | Example | Internal Representation | Key Feature |
|---|---|---|---|
| **Character** | `'Q'` | A single byte storing the ASCII value for 'Q'. | No null terminator. |
| **String** | `"Q"` | An array of two characters: `'Q'` followed by `'\0'`. | **Must** be null-terminated. |
>![[Pasted image 20251113151638.png]]
>`strcat` relies on finding the null character (`\0`) to know where the source string ends. 
>Since a single character like `'Q'` has no null terminator, `strcat` would not know where to stop reading, leading to a buffer overflow.
## Scanning a Full Line
When processing strings, treating blanks as delimiters (like the functions ``scanf`` and ``fscanf`` does) doesn't always make sense since blanks are valid characters within strings. For interactive input of complete lines of data, C provides specific functions that handle entire lines rather than tokenizing by whitespace.
### The `gets` Function
For interactive input of one complete line of data, the ``<stdio.h>`` library provides the function ``gets``.
The `gets` function reads a full line of text from the user
> [!example]
> ```C
> char line[80];
printf("Type in a line of data.\n> ");
gets(line);
> ```
> If the user enters "Here is a short sentence.", the string stored in `line` would be exactly that text without the newline character.
> ```C
> Type in a line of data.
> > Here is a short sentence.
> ```
> After the user presses Enter, the `gets` function stores the string `"Here is a short sentence."` in the `line` character array. It **does not** store the newline character (`\n`) generated by the Enter key. Instead, it replaces it with the null character (`\0`) to properly terminate the string.
> ![[Pasted image 20251113152700.png]]
>> [!warning] **Buffer Overflow Danger** 
>> Like `scanf`, `gets` can overflow its string argument if the user enters more data than the allocated space. This makes `gets` unsafe for production code.
### The `fgets` Function

The `fgets` function is a safer alternative that behaves differently from `gets`.
It takes three arguments 
- The output parameter string 
- A maximum number of characters to store (n) 
- And the file pointer to the data source.  
``fgets`` will never store more than $n − 1$ characters from the data file, and the final character stored will always be '*\0*'
```C
char *fgets(char *str, int n, FILE *stream);
```
#### Using `fgets` for Interactive Input
Many programmers prefer `fgets` even for interactive input by providing `stdin` as the file pointer.
> [!info]
> Since ``fgets`` prevents buffer overflow, some programmers use it in place of gets for interactive input, providing stdin (the standard input pointer associated with the keyboard) as the file pointer and adding extra code to replace the '*\n*' by '*\0*' if the newline character is unwanted.
```C
fgets(line, sizeof(line), stdin);
```
When using `fgets` for interactive input, you may want to remove the trailing newline.
```C
// Remove trailing newline if present
if (line[strlen(line) - 1] == '\n')
    line[strlen(line) - 1] = '\0';
```
> [!example] Demonstration of Whole-Line Input
> The following program demonstrates using `fgets` to read a file line by line and create a double-spaced, numbered version
> ```C
> /*
> * Numbers and double spaces lines of a document. Lines longer than
> * LINE_LEN - 1 characters are split on two lines.
> */
>
>#include <stdio.h>
>#include <string.h>
>
>#define LINE_LEN 80
>#define NAME_LEN 40
>
>int main(void) {
 >   char line[LINE_LEN], inname[NAME_LEN], outname[NAME_LEN];
>    FILE *inp, *outp;
>    char *status;
>    int i = 0;
>
>    printf("Name of input file> ");
>    scanf("%s", inname);
>    printf("Name of output file> ");
>    scanf("%s", outname);
>
>    inp = fopen(inname, "r");
>    outp = fopen(outname, "w");
>
>    for (status = fgets(line, LINE_LEN, inp);
>         status != 0;
>         status = fgets(line, LINE_LEN, inp)) {
>        if (line[strlen(line) - 1] == '\n')
>            line[strlen(line) - 1] = '\0';
>        fprintf(outp, "%3d>> %s\n\n", ++i, line);
>    }
>    return (0);
>}
> ```
>> [!info] How It Works:
>> 1. The program prompts for input and output filenames.
>> 2. It opens both files for reading and writing.
>> 3. It uses a `for` loop with `fgets` to read each line from the input file.
>> 4. For each line, it removes the trailing newline (if present).
>> 5. It writes the line number, the line content, and an extra newline to create double spacing.
>> 6. The loop continues until `fgets` returns 0 (NULL), indicating end-of-file 
>    
> **Input:**
> ```
> In the early 1960s, designers and implementers of operating
systems were faced with a significant dilemma. As people's
expectations of modern operating systems escalated, so did
> ```
> 
> **Output:**
> ```
> 1>> In the early 1960s, designers and implementers of operating
>
2>> systems were faced with a significant dilemma. As people's
>
3>> expectations of modern operating systems escalated, so did
> ```
# 8.4 String Comparison
In C, you cannot use standard relational or equality operators (`==`, `!=`, `<`, `>`) to compare the _content_ of strings.
> [!warning] **Why `str1 < str2` Doesn't Work** 
> When you write `str1 < str2` where `str1` and `str2` are string variables (character arrays), you are not comparing their alphabetical order. Instead, you are comparing the **memory addresses** where these strings are stored. The comparison determines if the address of `str1` comes before the address of `str2` in memory, which is almost never what you want.

The standard string library provides the `strcmp` function (string compare) to lexicographically compare two strings.
```C
int strcmp(const char *str1, const char *str2);
```
The function returns an integer value that indicates the relationship between the strings.

| Relationship                                   | Value Returned         | Example                                        |
| ---------------------------------------------- | ---------------------- | ---------------------------------------------- |
| `str1` is less than `str2` (alphabetically)    | A **negative integer** | `strcmp("marigold", "tulip")` returns negative |
| `str1` equals `str2`                           | **Zero**               | `strcmp("end", "end")` returns 0               |
| `str1` is greater than `str2` (alphabetically) | A **positive integer** | `strcmp("shrimp", "crab")` returns positive    |
> [!info] **Understanding "Less Than"** 
> The concept of "less than" for strings is defined by two rules:
> 
> 1. **Character-by-Character:** If the first `n` characters match, but the characters at position `n` differ, the string with the smaller character code at that position is "less than" the other.
>     - `str1 = "thrill"`, `str2 = "throw"`
>     - The first 3 characters match. At index 3, `'i'` (from `str1`) is less than `'o'` (from `str2`). Therefore, `"thrill"` is less than `"throw"`.
> 2. **Prefix Rule:** If one string is a shorter, exact prefix of the other, the shorter string is "less than" the longer one.
>     - `str1 = "joy"`, `str2 = "joyous"`
>     - All characters of `str1` match the beginning of `str2`. Since `str1` is shorter, `"joy"` is less than `"joyous"`.

The `strncmp` function is similar to `strcmp`, but it only compares the first `n` characters of the two strings.
```C
int strncmp(const char *str1, const char *str2, size_t n);
```
> [!example] **How `strncmp` Works** 
> Let `str1 = "joyful"` and `str2 = "joyous"`.
>
>- `strncmp(str1, str2, 3)` returns **0** (zero) because `"joy"` matches `"joy"`.
>- `strncmp(str1, str2, 4)` returns a **negative integer** because `'f'` (the 4th char of `str1`) is less than `'o'` (the 4th char of `str2`).

The `strncmp` function is similar to `strcmp`, but it only compares the first `n` characters of the two strings.
>[!example]
>```C
>int strncmp(const char *str1, const char *str2, size_t n);
>```
>Let `str1 = "joyful"` and `str2 = "joyous"`.
>
>- `strncmp(str1, str2, 3)` returns **0** (zero) because `"joy"` matches `"joy"`.
>- `strncmp(str1, str2, 4)` returns a **negative integer** because `'f'` (the 4th char of `str1`) is less than `'o'` (the 4th char of `str2`).
> ![[Pasted image 20251113160024.png]]

`strcmp` is ideal for creating loops that continue until a specific "sentinel" word is entered.
> [!example]
> ```C
> printf("Enter list of words on as many lines as you like.\n");
>printf("Separate words by at least one blank.\n");
>printf("When done, enter %s to quit.\n", SENT);
>
>for (scanf("%s", word);
>     strcmp(word, SENT) != 0;
>     scanf("%s", word)) {
>    /* process word */
>    . . .
>}
> ```
> In this loop, the condition `strcmp(word, SENT) != 0` is true as long as the user enters a word that is _not_ the sentinel value. The loop terminates only when the user enters the exact word stored in `SENT`.
> ![[Pasted image 20251113160154.png]]
# Defensive Programming
Defensive programming is a software design approach that discards the optimistic assumptions of a "standards-compliant compiler, reasonable execution conditions, and original context." Instead, it anticipates and protects against problems that can arise from invalid inputs, unexpected environments, and human error.
## Characteristic 1: Creating Readable Code
The first characteristic of defensive programming is its emphasis on creating highly readable and maintainable code. This is especially critical in large projects where multiple developers work together.
> [!info] **Readability for Collaboration** 
> Clear, consistent code allows team members to easily audit, understand, and modify each other's work, reducing the likelihood of introducing new bugs.

To achieve this, projects should establish and follow a set of style guidelines, which typically include:
- **Naming Conventions:** Consistent rules for variables, functions, and constants (e.g., `snake_case` for variables, `UPPER_CASE` for constants).
- **Indentation:** A standard format for indenting code within control structures like loops and `if` statements.
- **Braces and Parentheses:** Clear rules on when and where to use braces, even in contexts where they are optional, to avoid ambiguity.
- **Comments:** Guidelines on the quantity, positioning, and format of comments to explain _why_ code is written a certain way, not just _what_ it does.
## Characteristic 2: Ensuring Predictable Results
The second characteristic is that defensive programming insists on predictable and safe behavior, even when faced with unreasonable or malicious input.
> [!warning] **Guarding Against Invalid Input** 
> A defensively programmed function does not trust its callers. It validates its own preconditions (like input ranges or buffer sizes) before proceeding.

This philosophy leads to the prohibition of inherently unsafe functions that are prone to errors like buffer overflows. Examples of functions to avoid include:
- `gets`
- `sprintf`
These are replaced by safer alternatives or user-defined modules that explicitly prevent overflow, such as `fgets`, `strncpy`, and `snprintf`.
## The Cost-Benefit Trade-off
Adopting defensive programming techniques is not without its costs, but the benefits often outweigh them.
- **The Cost:** Having every function rigorously check its own inputs can lead to the evaluation of redundant tests, potentially adding a small amount of overhead to the program's execution time.

- **The Benefit:** This approach significantly increases the **safety and reusability** of the function. A function that validates its own input can be safely copied and used in a completely different context or project without worrying that it will fail catastrophically. This robustness is a cornerstone of creating reliable and long-lasting software.
# 8.5 Arrays of Pointers
When we sort an array of strings using a standard algorithm like selection sort, the exchange step involves physically copying entire strings from one memory location to another using `strcpy`.
```C
/* Inefficient exchange of strings */
strcpy(temp, list[index_of_min]);
strcpy(list[index_of_min], list[fill]);
strcpy(list[fill], temp);
```
![[Pasted image 20251113164020.png]]
![[Pasted image 20251113164109.png]]
This approach has two major drawbacks:

1. **Performance:** Copying entire strings is computationally expensive and slow, especially for long strings or large lists.
2. **Data Loss:** The original order of the strings is destroyed during the sorting process.

A more efficient approach is to keep the strings in their original locations and create a separate array that holds _pointers_ to these strings. We then sort the array of pointers, not the strings themselves.

When we sort pointers, the exchange step only involves copying memory addresses, which is extremely fast. The strings themselves are never moved.
![[Pasted image 20251113164146.png]]

**Memory Layout Before Sorting:**

Imagine the original array `original` is stored in memory. The pointer array `alphap` is then initialized to point to the start of each string in `original`.
```
Memory:
+-----------+      +-----------------------+
| alphap[0] | ---> | "tulip"  \0           |
+-----------+      +-----------------------+
| alphap[1] | ---> | "daisy"  \0           |
+-----------+      +-----------------------+
| alphap[2] | ---> | "rose"   \0           |
+-----------+      +-----------------------+
| alphap[3] | ---> | "marigold" \0         |
+-----------+      +-----------------------+
| alphap[4] | ---> | "petunia" \0          |
+-----------+      +-----------------------+

(The original strings themselves are stored elsewhere, contiguously in the `original` array)
```
**Memory Layout After Sorting `alphap`:**

After sorting, the `alphap` array itself is reordered. The pointers now point to the strings in alphabetical order. The `original` array remains untouched.
```
Memory:
+-----------+      +-----------------------+
| alphap[0] | ------------------------------------> | "daisy"  \0           |
+-----------+      +-----------------------+
| alphap[1] | ------------------------------------> | "marigold" \0         |
+-----------+      +-----------------------+
| alphap[2] | ------------------------------------> | "petunia" \0          |
+-----------+      +-----------------------+
| alphap[3] | ------------------------------------> | "rose"   \0           |
+-----------+      +-----------------------+
| alphap[4] | ------------------------------------> | "tulip"  \0           |
+-----------+      +-----------------------+
```
This approach is highly efficient because swapping two pointers (e.g., `alphap[0]` and `alphap[1]`) is a simple and fast operation, while swapping the entire strings `"tulip"` and `"daisy"` would be slow and would destroy the original data.
## Declaration and Initialization
```C
char *alphap[5]; // An array of 5 pointers to characters
```
Each element of `alphap` (e.g., `alphap[0]`) is designed to hold the *memory address* of a string.

To initialize it, you assign the address of each string to an element of the pointer array. Since an array name without a subscript evaluates to the address of its first element, this is straightforward.
```C
char original[5][STRSIZ] = {"tulip", "daisy", "rose", "marigold", "petunia"};
char *alphap[5];

for (int i = 0; i < 5; ++i) {
    alphap[i] = original[i]; // Copies ONLY the address of the string
}
```

> [!example] Maintaining Multiple Orderings
> A school maintains a list of kindergarten applicants in the order they applied, but staff often need to view the list alphabetically.
> 
> **Setup:**
> 
> - `applicants[MAXAPP][STRSIZ]`: A 2D array to store the names in the original application order.
> - `*alpha[MAXAPP]`: An array of pointers to access the names alphabetically.
>
> **Process:**
> 
> 1. The names are read into the `applicants` array.
> 2. The `alpha` array is initialized to point to the names in `applicants`.
> ```C
> for (i = 0; i < num_app; ++i)
>    alpha[i] = applicants[i]; // Copies ONLY the address
> ```
> 3. A selection sort is applied to the `alpha` array. The comparison uses `strcmp` on the strings the pointers reference, and the exchange step only swaps the pointers.
> ```C
> // Inside the sorting loop
>if (strcmp(alpha[i], alpha[first]) < 0)
>    first = i;
>
>// Exchange step (swapping pointers, not strings)
>temp = alpha[index_of_min];
>alpha[index_of_min] = alpha[fill];
>alpha[fill] = temp;
> ```
> **Result:** 
> The program can now display both the original order (by iterating through `applicants`) and the alphabetical order (by iterating through `alpha`), while only storing the actual name strings once.
## Arrays of String Constants
C also permits the use of an array of pointers to represent a list of string constants.
This concept is also useful for representing a fixed list of string constants, like the months of the year. 
You have two main options

| Method                 | Declaration                                          | Notes                                                                                               |
| ---------------------- | ---------------------------------------------------- | --------------------------------------------------------------------------------------------------- |
| **2D Character Array** | `char month[12][10] = {"January", "February", ...};` | All rows must be the same size (large enough for the longest string, "September"). Can waste space. |
| **Array of Pointers**  | `char *month[12] = {"January", "February", ...};`    | More memory-efficient. Each pointer points to a string literal of just the right length.            |
![[Pasted image 20251113164830.png]]
# 8.6 Character Operations
When developing programs that process strings, it's often necessary to work with the individual characters that make up those strings. 
C provides two key libraries for these tasks: `stdio.h` for character input/output and `ctype.h` for character analysis and conversion.
## Character Input/Output
The standard I/O library provides functions for handling single characters, which offer more control than the formatted `scanf` and `printf` functions.
### `getchar()` for Input
The `getchar()` function reads the next single character from the standard input (the keyboard).
```C
// Either of the following two expressions can be used to store the next available input character in ch. 
scanf("%c", &ch) | ch = getchar()

- - -

int ch;
ch = getchar(); // Reads one character and stores its integer code in ch
```
> [!warning] **`EOF` and the `int` Return Type** 
> A critical detail is that `getchar()` returns an `int`, not a `char`. This is because it needs to return all possible character codes _and_ a special, negative value called `EOF` (End Of File) to signal that no more input is available. Since a `char` might not be able to represent this negative value, you must always store the result of `getchar()` in an `int` variable.

>[!example] Implementation of scanline Function Using ``getchar``
>```C
>/*
> * Gets one line of data from standard input. Returns an empty string on
> * end of file. If data line will not fit in allotted space, stores
> * portion that does fit and discards rest of input line.
> */
>char *
>scanline(char *dest, int dest_len) {
>    int i, ch;
>
>    /* Gets next line one character at a time. */
>    i = 0;
>    for (ch = getchar();
>         ch != '\n' && ch != EOF && i < dest_len - 1;
>         ch = getchar())
>        dest[i++] = ch;
>    dest[i] = '\0';
>
>    /* Discards any characters that remain on input line */
>    while (ch != '\n' && ch != EOF)
>        ch = getchar();
>
>    return (dest);
>}
>```
>The `scanline` function is designed with robustness and safety as its primary goals.
>- `char *dest`: A pointer to the character array (the destination buffer) where the input line will be stored.
>- `int dest_len`: The total size of the destination buffer. This parameter is the key to the function's safety.
>- `char *`: The function returns a pointer to the destination string, which is a common practice for string-building functions in C.
>
>The core of the function is a `for` loop that carefully reads characters one by one.
>- **Initialization**: `ch = getchar()` reads the very first character before the loop begins.
>- **Condition**: The loop continues only as long as all three conditions are true:
>    1. `ch != '\n'`: The character is not the newline character, which signifies the end of the user's input line.
>    2. `ch != EOF`: The character is not the special `EOF` (End-Of-File) marker, which can occur if input is redirected from a file.
>    3. `i < dest_len - 1`: **This is the critical safety check.** It ensures we never write more characters than the buffer can hold. We stop at `dest_len - 1` to leave one free space for the mandatory null terminator (`\0`).
>- **Body**: `dest[i++] = ch;` stores the current character in the buffer and then increments the index `i`.
>  
>  The final `while` loop is a crucial part of the function's robustness.
>  If the user entered a line longer than the buffer's capacity, this loop "cleans up" by reading and discarding all the remaining characters on that line. This prevents the extra characters from being mistakenly read by the _next_ input operation in the program.
>
>After the loop finishes (either because the line ended, EOF was reached, or the buffer is full), this line is executed
### ``getc()`` for Input
To get a single character from a file, use the facility ``getc``.
```C
getc(inp) // comparable to a call to getchar, except that the character returned is obtained from the file accessed by file pointer inp.
```
### `putchar()` for Output
The counterpart to `getchar` is `putchar`, which writes a single character to the standard output (the screen). And for ``getc``, ``putc``.
```C
putchar('a'); // Displays the character 'a'
```
Both take as their first argument a type int character code. Because type char can always be converted to type int with no loss of information, we frequently call putchar and putc with arguments of type char
```C
putchar('a'); | putc('a', outp);
```
## Character Analysis and Conversion
The `<ctype.h>` library provides a powerful collection of functions for classifying characters (e.g., is it a letter, a digit?) and for converting between uppercase and lowercase. The following table summarizes the most commonly used functions.
> [!summary]- Character Classification and Conversion Facilities in ``<ctype.h>`` Library
| Facility | Purpose | Example(s) | Example Output(s) |
|---|---|---|---|
| `isalpha` | Checks if argument is a letter of the alphabet. | `isalpha('Q')`<br>`if (isalpha(ch)) printf("%c is a letter\n", ch);` (with `ch='Q'`) | non-zero (true)<br>`Q is a letter` |
| `isdigit` | Checks if argument is one of the ten decimal digits. | `isdigit('7')`<br>`dec_digit = isdigit(ch);` (with `ch='7'`) | non-zero (true)<br>`dec_digit` is assigned a non-zero value |
| `islower` | Checks if argument is a lowercase letter. | `islower('b')`<br>`if (islower(fst_let)) { ... }` (with `fst_let='a'`) | non-zero (true)<br>Prints an error message about capitalization |
| `isupper` | Checks if argument is an uppercase letter. | `isupper('B')` | non-zero (true) |
| `ispunct` | Checks if argument is a punctuation character. | `ispunct('!')`<br>`if (ispunct(ch)) printf("Punctuation mark: %c\n", ch);` (with `ch='!'`) | non-zero (true)<br>`Punctuation mark: !` |
| `isspace` | Checks if argument is a whitespace character. | `isspace('\n')`<br>`while (isspace(c) && c != EOF) c = getchar();` (with `c` as a space) | non-zero (true)<br>Loop advances to the next non-whitespace character |
| `tolower` | Converts an uppercase letter to its lowercase equivalent. | `tolower('F')`<br>`if (islower(ch)) printf("Capital %c = %c\n", ch, toupper(ch));` (with `ch='f'`) | `'f'` (integer code)<br>`Capital f = F` |
| `toupper` | Converts a lowercase letter to its uppercase equivalent. | `toupper('f')` | `'F'` (integer code) |
>>[!note]
>>The *classification* routines (those whose names begin with "is") return a **nonzero** value (though not necessarily 1) if the condition checked is true.

The standard `strcmp` function is case-sensitive, which can lead to incorrect alphabetical ordering. For example, in ASCII, all uppercase letters have lower codes than lowercase letters, so `"Zebra"` would come before `"apple"`.

To perform a case-insensitive comparison, we can convert both strings to the same case before comparing them.
> [!example] String Function for a Greater-Than Operator That Ignores Case
> This function returns `1` if `str1` should come after `str2` alphabetically, ignoring case.
> ```C
> #include <string.h>
>#include <ctype.h>
>#define STRSIZ 80
>
>/*
> * Converts the lowercase letters of a string to uppercase.
> */
>char *
>string_toupper(char *str) {
>    int i;
>    for (i = 0; i < strlen(str); ++i)
>        if (islower(str[i]))
>            str[i] = toupper(str[i]);
>    return (str);
>}
>
>/*
> * Compares two strings ignoring case. Returns 1 if str1 > str2.
> */
>int
>string_greater(const char *str1, const char *str2) {
>    char s1[STRSIZ], s2[STRSIZ];
>
>    /* Make copies since string_toupper modifies its argument */
>    strcpy(s1, str1);
>    strcpy(s2, str2);
>
>    /* Compare the uppercase versions */
>    return (strcmp(string_toupper(s1), string_toupper(s2)) > 0);
>}
> ```
> **Key Steps:**
>
>1. Create temporary copies (`s1`, `s2`) of the input strings because the conversion function modifies its argument.
>2. Convert both temporary strings to uppercase using `string_toupper`.
>3. Use the standard `strcmp` on the now-uniform strings.
# 8.7 String-to-Number and Number-to-String Conversions
Converting between string representations (like `"3.14159"`) and their numeric data types (like `double`) is a fundamental task in programming. While we've used `printf` and `scanf` for this, C provides more powerful functions that let you perform these conversions directly with strings in memory.
## Number-to-String Conversion with `sprintf`
The `sprintf` function formats data exactly like `printf`, but instead of sending the output to the screen, it writes the resulting string into a character array.
```C
int sprintf(char *str, const char *format, ...);
```
- **`str`**: The destination character array where the formatted string will be stored.
- **`format`**: The format string, identical to what you'd use with `printf`.

> [!example]
> ```C
> char s[100];
>int mon = 8, day = 23, year = 1914;
>
>sprintf(s, "%d/%d/%d", mon, day, year);
>// After this call, s contains the string "8/23/1914"
> ```
> ![[Pasted image 20251113174223.png]]
> ![[Pasted image 20251113174358.png]]
> This is useful for constructing strings from multiple variables for display or storage.
>> [!warning] **Buffer Overflow Risk** 
>> Just like `strcpy`, `sprintf` does **not** check the size of the destination array. If the formatted string is larger than the space allocated for `s`, it will cause a buffer overflow. Always ensure the destination is large enough or use safer alternatives like `snprintf`.
## String-to-Number Conversion with `sscanf`
The `sscanf` function reads formatted data from a string instead of from standard input. It works like `scanf` but takes the string to be scanned as its first argument.
```C
int sscanf(const char *str, const char *format, ...);
```
- **`str`**: The source string to read from.
- **`format`**: The format string, identical to what you'd use with `scanf`.
> [!example]
> ```c
> char data[] = " 85 96.2 hello";
>int num;
>double val;
>char word[10];
>
>sscanf(data, "%d%lf%s", &num, &val, word);
>// num is 85, val is 96.2, word is "hello"
> ```
>![[Pasted image 20251113174613.png]]
>![[Pasted image 20251113174620.png]] 
# 8.8 String Processing Illustrated
 Case Study: A Simple Text Editor
## The "Problem"
Design and implement a C program that performs basic editing operations on a single line of text. The editor must be able to:
- **F**ind a target substring.
- **D**elete a substring.
- **I**nsert a substring at a specified location.
- **Q**uit the program.
The program will handle source strings of less than 80 characters.
## Core Concepts & Design
The program is structured around a main loop that repeatedly prompts the user for a command and executes it. The core logic is broken down into modular helper functions, each responsible for a specific string manipulation task.
- **Main Loop**: The `main` function initializes the source string and then enters a `for` loop that continues until the user enters the 'Q' (Quit) command.
- **Command Processing**: A function `do_edit` uses a `switch` statement to call the appropriate helper function based on the command ('D', 'I', 'F').
- **Helper Functions**: The real work of string manipulation is done by `pos`, `delete`, and `insert`. These functions demonstrate practical applications of `strncpy`, `strcpy`, `strcat`, and `strlen`.
> [!warning] **Unsafe Input Function** 
> The provided program uses `gets()` for input, which is unsafe and prone to buffer overflows. In a production environment, `fgets()` should be used instead for safer input handling.
## Key Helper Functions

### - `int pos(const char *source, const char *to_find)`
- **Purpose**: Finds the starting index of the first occurrence of `to_find` within `source`. It returns `NOT_FOUND` (-1) if the substring is not present.
- **Algorithm**:
1. Get the length of `to_find`.
2. Loop through `source` from the beginning.
3. At each position `i`, extract a substring of the same length as `to_find` using `strncpy`.
4. Compare this extracted substring with `to_find` using `strcmp`.
5. If they match, return the current index `i`.
6. If the loop finishes without a match, return `NOT_FOUND`.
### - `char *delete(char *source, int index, int n)`
- **Purpose**: Deletes `n` characters from `source` starting at the given `index`.
- **Algorithm**:
1. **Check if deletion goes to the end of the string**: If `index + n` is past the end of the string, simply terminate the string at `index` by placing `source[index] = '\0'`.
2. **Otherwise, delete from the middle**: a. Copy the "rest" of the string (from `index + n` to the end) into a temporary string. b. Copy this temporary string back into `source`, starting at `index`.
> [!example]
> `delete("abcdefg", 2, 2)` results in `"abefg"`.
### - `char *insert(char *source, const char *to_insert, int index)`
- **Purpose**: Inserts the string `to_insert` into `source` at the specified `index`.
- **Algorithm**:
1. **Check if insertion is at the end**: If `index` is at or beyond the end of the string, simply append `to_insert` using `strcat`.
2. **Otherwise, insert in the middle**: a. Copy the "rest" of the string (from `index` to the end) into a temporary string. b. Copy `to_insert` into `source` at the `index`. c. Append the temporary string to the end of the modified `source`.
> [!example]
> `insert("abfg", "cd", 2)` results in `"abcdefg"`.
## Program Flow
1. The `main` function prompts the user to enter the initial source string.
2. It enters a loop that calls `get_command()` to get the user's next action (D, I, F, or Q).
3. The loop continues as long as the command is not 'Q'.
4. Inside the loop, `do_edit(source, command)` is called to perform the editing operation.
5. After each operation, the program prints the "New source" string to show the result.
6. When the user enters 'Q', the loop terminates, and the final version of the string is printed.
## Testing Strategy
When testing a program like this, it's crucial to check boundary conditions and edge cases:
- **Delete Command**:
    - Delete from the beginning, middle, and end of the string.
    - Try to delete a substring that appears multiple times (verify only the first is deleted).
    - Attempt to delete a substring that doesn't exist.
- **Insert Command**:
    - Insert at the beginning, middle, and end of the string.
    - Try inserting at a position well beyond the end of the string.
- **Find Command**:
    - Search for single characters and longer substrings.
    - Search for substrings at the beginning, middle, and end.
    - Search for a substring that does not exist.

>[!success]- Full Program Implementation
>```C
>/*
 >* Performs text editing operations on a source string
 >*/
>
>#include <stdio.h>
>#include <string.h>
>#include <ctype.h>
>
>#define MAX_LEN 100
>#define NOT_FOUND -1
>
>char *delete(char *source, int index, int n);
>char *do_edit(char *source, char command);
>char get_command(void);
>char *insert(char *source, const char *to_insert, int index);
>int pos(const char *source, const char *to_find);
>
>int
>main(void)
>{
>    char source[MAX_LEN], command;
>    printf("Enter the source string:\n> ");
>    gets(source);
>
>    for (command = get_command();
>         command != 'Q';
>         command = get_command()) {
>        do_edit(source, command);
>        printf("New source: %s\n\n", source);
>    }
>
>    printf("String after editing: %s\n", source);
>    return (0);
>}
>
>/*
> * Returns source after deleting n characters beginning with source[index].
> * If source is too short for full deletion, as many characters are
> * deleted as possible.
> */
>char *
>delete(char *source, int index, int n)
>{
>    char rest_str[MAX_LEN];
>
>    if (strlen(source) <= index + n) {
>        source[index] = '\0';
>    } else {
>        strcpy(rest_str, &source[index + n]);
>        strcpy(&source[index], rest_str);
>    }
>
>    return (source);
>}
>
>/*
> * Performs edit operation specified by command
> */
>char *
>do_edit(char *source, char command)
>{
>    char str[MAX_LEN];
>    int index;
>
>    switch (command) {
>    case 'D':
>        printf("String to delete> ");
>        gets(str);
>        index = pos(source, str);
>        if (index == NOT_FOUND)
>            printf("'%s' not found\n", str);
>        else
>            delete(source, index, strlen(str));
>        break;
>
>    case 'I':
>        printf("String to insert> ");
>        gets(str);
>        printf("Position of insertion> ");
>        scanf("%d", &index);
>        insert(source, str, index);
>        break;
>
>    case 'F':
>        printf("String to find> ");
>        gets(str);
>        index = pos(source, str);
>        if (index == NOT_FOUND)
>            printf("'%s' not found\n", str);
>        else
>            printf("'%s' found at position %d\n", str, index);
>        break;
>
>    default:
>        printf("Invalid edit command '%c'\n", command);
>    }
>
>    return (source);
>}
>
>/*
> * Prompt for and get a character representing an edit command and
> * convert it to uppercase.
> */
>char
>get_command(void)
>{
>    char command, ignore;
>
>    printf("Enter D(Delete), I(Insert), F(Find), or Q(Quit)> ");
>    scanf(" %c", &command);
>
>    do
>        ignore = getchar();
>    while (ignore != '\n');
>
>    return (toupper(command));
>}
>
>/*
> * Returns source after inserting to_insert at position index of
> * source. If source[index] doesn't exist, adds to_insert at end of
> * source.
> */
>char *
>insert(char *source, const char *to_insert, int index)
>{
>    char rest_str[MAX_LEN];
>
>    if (strlen(source) <= index) {
>        strcat(source, to_insert);
>    } else {
>        strcpy(rest_str, &source[index]);
>        strcpy(&source[index], to_insert);
>        strcat(source, rest_str);
>    }
>
>    return (source);
>}
>
>/*
> * Returns index of first occurrence of to_find in source or
> * value of NOT_FOUND if to_find is not in source.
> */
>int
>pos(const char *source, const char *to_find)
>{
>    int i = 0, find_len, found = 0, position;
>    char substring[MAX_LEN];
>
>    find_len = strlen(to_find);
>    while (!found && i <= strlen(source) - find_len) {
>        strncpy(substring, &source[i], find_len);
>        substring[find_len] = '\0';
>
>        if (strcmp(substring, to_find) == 0)
>            found = 1;
>        else
>            ++i;
>    }
>
>    if (found)
>        position = i;
>    else
>        position = NOT_FOUND;
>
>    return (position);
>}
>```
>![[Pasted image 20251113180217.png]]
# 8.9 Common Programming Errors
When working with strings in C, programmers must be extremely careful with memory management and function usage. Several common errors can lead to bugs that are difficult to trace, program crashes, or major security vulnerabilities.
## 1. Returning Pointers to Local Strings
This is one of the most ***serious*** and ***insidious*** errors in C programming. 
A function should **never** return the *address* of a local variable.
> [!danger] **The "Time-Bomb" Error** 
> A function's local variables (including arrays) are stored on the **stack**. When the function returns, this memory is automatically deallocated and can be overwritten by other function calls. Returning a pointer to this deallocated memory creates a dangling pointer, which may work by chance but will eventually lead to unpredictable behavior or a crash.

> [!example]
> ```C
> /*
> * **** Error: returns address of space that is immediately deallocated.
> */
>char *
>scanline_bad(void) {
>    char dest[100]; // Local array on the stack
>    int i, ch;
>
>    // ... (code to fill dest) ...
>
>    return (dest); // Returns pointer to deallocated memory!
>}
> ```
> ![[Pasted image 20251113184352.png]]
> 
## 2. Buffer Overflow
Many C string functions do not check the *size* of the destination buffer, making it easy to write past the end of an array.
> [!warning] **Overflow Consequences** 
> A buffer overflow can corrupt other variables, cause a program to crash, or create a serious security vulnerability.

>[!example]
>```C
>char dept[4]; // Space for only 3 characters + '\0'
>int course_num, time;
>
>// User enters: "ATH 1010 MWF 1000"
>scanf("%s%d%s%d", dept, &course_num, days, &time);
>```
>Memory Layout After Overflow
>
>| Variable     | Memory Contents | Intended | Actual |
>| ------------ | --------------- | -------- | ------ |
>| `dept[0]`    | `A`             | `A`      |        |
>| `dept[1]`    | `T`             | `T`      |        |
>| `dept[2]`    | `H`             | `H`      |        |
>| `dept[3]`    | `\0`            | `1`      |        |
>| `course_num` | `???`           | `0`      |        |
>| `...`        | `???`           | `...`    |        |
>The `scanf` function stores "ATH" and then "1" in the space meant for the null terminator. It continues writing, overwriting `dept[3]` and then corrupting the memory allocated for `course_num` and beyond.
>![[Pasted image 20251113184615.png]]
## 3. Forgetting the Null Terminator (`\0`)
Every C string must be terminated by the null character (`\0`). String functions like `printf("%s", ...)` and `strcpy` rely on this character to know where the string ends. Forgetting it leads to undefined behavior.
> [!example]
> ```C
> char word[10];
>for (int i = 0; i < 3; ++i) {
>    word[i] = 'a' + i; // word becomes "abc"
>}
>// ERROR: Forgot to add the null terminator!
>printf("%s", word); // Will print "abc" followed by garbage from memory.
> ```
## 4. Using Wrong Operators for Comparison and Assignment
C strings are arrays, and you cannot use standard operators to compare or copy them.
### Comparison Error (`==`)
The expression `str1 == str2` does **not** compare the contents of the strings; it compares the memory addresses of `str1` and `str2`.
> [!example]
> ```C
> // WRONG
>if (str1 == str2) { ... }
>
>// CORRECT
>if (strcmp(str1, str2) == 0) { ... }
> ```

### Assignment Error (`=`)
The expression `str1 = str2` is illegal if `str1` is an array. You cannot change the address of an array. It also wouldn't copy the characters even if it were legal.
>[!example]
>```C
>// WRONG (and illegal if str1 is an array)
>str1 = str2;
>
>// CORRECT
>strcpy(str1, str2);
>```

## 5. Misuse of the Address-of Operator (`&`)
Remember when to use the address-of operator.
- **Use `&` for simple variables** (like `int`, `double`, `char`) when passing them to functions that need to modify them, like `scanf`.
> [!example]
> ```C
> int num;
scanf("%d", &num); // CORRECT
> ```

- **Do NOT use `&` on an array name** when passing it to a function. An array name already represents the address of its first element.
> [!example]
> ```C
> char str[10];
scanf("%s", str); // CORRECT
scanf("%s", &str); // WRONG - &str is an address to a pointer (char**)
> ```