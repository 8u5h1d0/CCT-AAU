---
tags:
  - CCT1
  - CE
Topic: Recursion
Semester: CCT1
Course: CE1
Module: K13
Course Date: 28-11-25
Litterature:
  - Digital Design, 5th ed.
Created: 26-11-25
---
- - -
# Intro
A function that calls itself is said to be *recursive*. 
A function ``f1`` is also recursive if it calls a function ``f2``, which under some circumstances calls f1, creating a cycle in the sequence of calls. The ability to invoke itself enables a recursive function to be repeated with different parameter values. You can use recursion as an alternative to iteration (looping). Generally, a recursive solution is less efficient than an iterative solution in terms of computer time due to the overhead for the extra function calls; however, in many instances, the use of recursion enables us to specify a very natural, simple solution to a problem that would otherwise be very difficult to solve. For this reason, recursion is an important and powerful tool in problem solving and programming
# 9.1 The Nature of Recursion
> [!summary]
> Problems that lend themselves to a recursive solution have the 3 characteristics: 
> - One or more simple cases of the problem have a straightforward, nonrecursive solution. 
> - The other cases can be redefined in terms of problems that are closer to the simple cases. 
> - By applying this redefinition process every time the recursive function is called, eventually the problem is reduced entirely to simple cases, which are relatively easy to solve.

```c
if this is a simple case
    solve it
else
    redefine the problem using recursion
```

This approach works by splitting a problem of size $n$ into a problem of size $1$ (which we can solve) and a problem of size $n-1$. By continuing this process $n-1$ times, we end up with $n$ problems of size $1$, all of which we can solve.

> [!example] **Multiplication Example**
> 
> Let's consider how we might solve the problem of multiplying $6$ by $3$, assuming we know our addition tables but not our multiplication tables. We know that any number multiplied by $1$ gives us the original number, so if we encounter this simple case, we'll just solve it.
> 
> The problem of multiplying $6$ by $3$ can be split into:
> 1. Multiply $6$ by $2$.
> 2. Add $6$ to the result of problem $1$.
> 
> Problem 1 can be further split into:
> 1.1 Multiply $6$ by $1$.
> 1.2 Add $6$ to the result of problem 1.1.
> 
> Problem 1.1 is a simple case (answer is $6$). Solving problem 1.2 gives us $12$. Solving problem 2 gives us the final answer ($18$).
>
> 
> ```c
> /*
>  * Performs integer multiplication using + operator.
>  * Pre: m and n are defined and n > 0
>  * Post: returns m * n
>  */
> int
> multiply(int m, int n)
> {
>     int ans;
> 
>     if (n == 1)
>         ans = m; /* simple case */
>     else
>         ans = m + multiply(m, n - 1); /* recursive step */
> 
>     return (ans);
> }
> ```
> 
> The function multiply implements the general form of a recursive algorithm. The simplest case is reached when ``n == 1``. Otherwise, the problem is split into two simpler problems: multiply $m$ by $n-1$, and add m to the result.
> 


> [!tip] **Developing Recursive Algorithms**
> 
> In order to solve a problem recursively, first we must trust our function to solve a simpler version of the problem. Then we build the solution to the whole problem on the result from the simpler version.

> [!info] **Recursion with Lists**
> 
> One group of problems for which recursive solutions seem very natural are problems involving varying-length lists. Since a *string* is a varying-length list of characters, recursive functions that process strings are common.

> [!example] **Character Counting Example**
> 
> Let's develop a function to count the number of times a particular character appears in a string. For example, `count('s', "Mississippi sassafrs")` should return the value 8.
> 
> When dealing with a list of elements as we are in this problemA recursive solution usually explicitly processes only the first list element. The problem "Count s's in Mississippi sassafras" can be redefined as "Count s's in ississippi sassafras and add one more if the first letter is an s."
> We see that the thought process shown, fits into our generic else clause. We have redefined the problem “Count s’s in Mississippi sassafras” as “Count s’s in ississippi sassafras and add one more if the first letter is an s.” Our redefinition of the general problem “Count a letter in a string” is recursive, since part of the solution is still to count a letter in a string. What has changed is that the new string is shorter.
 ![[Pasted image 20251126170403.png]]
 _figure: thought process of recuring algorithm for s's_
> 
> The simplest case is when the string has no characters at all, in which case we know immediately that there are zero occurrences of the character being counted.
>
> 
> ```c
> /*
>  * Counts the number of times ch occurs in string str.
>  * Pre: Letter ch and string str are defined.
>  */
> int
> count(char ch, const char *str)
> {
>     int ans;
> 
>     if (str[0] == '\0') /* simple case */
>         ans = 0;
>     else /* redefine problem using recursion */
>         if (ch == str[0]) /* first character must be counted */
>             ans = 1 + count(ch, &str[1]);
>         else /* first character is not counted */
>             ans = count(ch, &str[1]);
> 
>     return (ans);
> }
> ```
> 
> The implementation of function count simply calls count with ``ch`` and ``&str[1]`` as its arguments. The string processed in the next call will be the substring starting at position 1 of the string in the previous call.
> 
# 9.2 Tracing a Recursive Function

Hand tracing an algorithm's execution provides valuable insight into how that algorithm works. This is particularly useful for understanding recursive functions. We can trace the execution of both functions that return a value and recursive `void` functions.

## Tracing a Recursive Function That Returns a Value

To trace a recursive function that returns a value, we can draw an _activation frame_ for each call of the function.

> [!info] **Activation Frame**
> 
> An activation frame is a conceptual tool that shows the parameter values for each specific function call and summarizes the execution of that call. It helps visualize the flow of control and data through the recursive calls.

Let's trace the execution of a function call like `multiply(6, 3)`.

> [!example] **Tracing a Recursive Multiplication**
> 
> To trace the call `multiply(6, 3)`, we would generate a sequence of activation frames, one for each time the function is called.
> 
> 1.  **First Call:** The function is called with `m=6` and `n=3`. Since `n` is not the simple case (i.e., `n` is not 1), the function proceeds to its recursive step, calling `multiply(6, 2)`.
> 2.  **Second Call:** This new call has `m=6` and `n=2`. Again, this is not the simple case, so it makes another recursive call: `multiply(6, 1)`.
> 3.  **Third Call:** This call has `m=6` and `n=1`. This is the simple case. The function solves it directly by returning the value of `m`, which is 6.
>    ![[Pasted image 20251126195219.png]]
> 
> Now, the recursion "unwinds" as each call receives the result from the one it made:
> 
> - The second call receives the value 6. It adds its own value of `m` (6) to this result, calculates 12, and returns 12.
> - The first call receives the value 12. It adds its own value of `m` (6) to this result, calculates 18, and returns 18 as the final answer to the original call.

> [!tip] **Visualizing the Trace**
> 
> When drawing activation frames to visualize the process, you can use different colors or shading to distinguish the parts of the frame that execute before a recursive call from the parts that execute after a call returns. The deeper the recursion, the darker you can make the frame. The value returned from each call can be drawn as an arrow pointing to the operation (like `+`) that will use that returned value.
## Tracing a ``void`` Function That Is Recursive

Hand tracing a ``void`` function is somewhat simpler than tracing a function that returns a value. For both types of functions, we use activation frames to track each function call.

> [!example] **Function reverse_input_words**
> 
> ```c
> /*
>  * Take n words as input and print them in reverse order on separate lines.
>  * Pre: n > 0
>  */
> void
> reverse_input_words(int n)
> {
>     char word[WORDSIZ]; /* local variable for storing one word */
> 
>     if (n <= 1) { /* simple case: just one word to get and print */
> 
>         scanf("%s", word);
>         printf("%s\n", word);
> 
>     } else { /* get this word; get and print the rest of the words in
>     reverse order; then print this word */
> 
>         scanf("%s", word);
>         reverse_input_words(n - 1);
>         printf("%s\n", word);
>     }
> }
> ```
> When the function call statement `reverse_input_words(5)` is executed, the five words entered at the keyboard are printed in reverse order.
> 
> If the words entered are:
> 
> - the
> - course
> - of
> - human
> - events
> 
> The program output will be:
> 
> - events
> - human
> - of
> - course
> - the
>
>This function demonstrates how recursion can be used to reverse the order of input data. The function takes a parameter $n$ that specifies how many words to read from input, and then prints those words in the opposite order from which they were entered.
>
This function takes $n$ words of input and prints them in reverse order. For example, if the function call `reverse_input_words(5)` is executed, the five words entered at the keyboard are printed in reverse order.

> [!info] **Function Behavior**
> 
> If the words entered are:
> - the
> - course
> - of
> - human
> - events
> 
> The program output will be:
> - events
> - human
> - of
> - course
> - the

Like most recursive modules, the body of function `reverse_input_words` consists of an if statement that evaluates a terminating condition, `n <= 1`. When the terminating condition is true, the function is dealing with one of the problem's simple cases—printing in reverse order a list of just one word. Since reversing word order has no effect on a single-word list, for the simple case when n is less than or equal to one, we just get the word using `scanf` and print it.

If the terminating condition is false (n > 1), the recursive step (following else) is executed. This group of statements transfers the current input word into memory, gets "someone" (i.e., `reverse_input_words`) to take and reverse print the remaining n - 1 words of interest, and then prints the current word.

> [!example] **Tracing reverse_input_words(3)**
> 
> Let's trace the function call `reverse_input_words(3)` assuming that the words "bits" "and" "bytes" are entered as data.
> ![[Pasted image 20251126195844.png]]
> 
> The trace shows three separate activation frames for function `reverse_input_words`. Each activation frame begins with a list of the initial values of n and word for that frame. The value of n is passed into the function when it is called; the value of the local variable word is initially undefined.
> 
> The statements that are executed for each frame are shown next. The statements in color in the activation frames are recursive function calls and result in new activation frames. A void function's return occurs when the closing brace of the function body is encountered.
>> [!summary] **Sequence of Events for reverse_input_words(3)**
>> 
>> 1. Call `reverse_input_words` with $n$ equal to $3$.
>>    - Scan the first word ("bits") into word.
>>    - Call `reverse_input_words` with n equal to 2.
>>       - Scan the second word ("and") into word.
>>       - Call `reverse_input_words` with n equal to 1.
>>          - Scan the third word ("bytes") into word.
>>          - Display the third word ("bytes").
>>          - Return from third call.
>>       - Display the second word ("and").
>>       - Return from second call.
>>    - Display the first word ("bits").
>>    - Return from original call.

As shown, there are three calls to function `reverse_input_words`, each with a different parameter value. The function returns always occur in the reverse order of the function calls—that is, we return from the last call first, then we return from the next to last call, and so on. After we return from a particular execution of the function, we display the string that was stored in word just prior to that function call.

## Parameter and Local Variable Stacks

C uses a stack data structure to keep track of parameter values and local variables during recursive function calls. This stack operates on a Last-In-First-Out (LIFO) principle, where the last item stored is the first one to be processed.

> [!info] **Stack Operations**
> 
> When executing a call to a recursive function like `reverse_input_words`, the system performs these operations:
> - Pushes the parameter value associated with the call on top of the parameter stack
> - Pushes a new undefined cell on top of the stack maintained for local variables
> - When returning from the function, pops each stack to remove the top values

> [!example]
Let's trace through the execution of `reverse_input_words` to understand how these stacks work:
>
>When the first call to `reverse_input_words` is made, one cell is created on each stack - one for the parameter `n` and one for the local variable `word`.
>![[Pasted image 20251126200237.png]]
>
>Before the second recursive call, the first word (e.g., "bits") is stored in the `word` variable.
>![[Pasted image 20251126200255.png]]
>
>After the second call, the new parameter value (2) is pushed onto the stack for `n`, and the top of the stack for `word` becomes undefined again. The value at the top of each stack is highlighted.
>![[Pasted image 20251126200311.png]]
>
>Before the third call, the second word (e.g., "and") is scanned and stored in `word`.
>![[Pasted image 20251126200326.png]]
>
>However, `word` becomes undefined again *immediately* after the third call is made.
>![[Pasted image 20251126200345.png]]
>
>During the execution of the third call, the third word (e.g., "bytes") is scanned and stored in `word`, and since `n` is 1 (the simple case), "bytes" is immediately printed.
>![[Pasted image 20251126200408.png]]
>
>When the function returns, both stacks are popped, removing the top values.
>![[Pasted image 20251126200419.png]]
>
>Control returns to the previous call, where the value of `word` ("and") at the top of the stack is then displayed. Another return occurs, popping the stacks again.
>![[Pasted image 20251126200429.png]]
>
>Finally, control returns to the original call, where the value of `word` ("bits") at the top of the stack is displayed. The third and last return exits the original function call, so there is no longer any memory allocated for `n` and `word`.

> [!tip] **Automatic Stack Management**
> 
> While a stack is a data structure that you can implement and manipulate yourself using arrays, C automatically handles all the stack manipulation associated with function calls. This allows us to write recursive functions without needing to worry about managing the stacks ourselves.
## Implementation of Parameter Stacks in C

While our previous discussion used separate stacks for each parameter for illustrative purposes, the actual implementation in C is different.

> [!info] **Single System Stack**
> 
> The compiler maintains a single system stack rather than separate stacks for each parameter. This approach is more efficient and is how C actually handles function calls.

When a function call occurs, several things happen:

1. All parameters and local variables are pushed onto the stack
2. The memory address of the calling statement is also pushed onto the stack
3. This address serves as the return point after execution of the function

> [!note] **Memory Efficiency**
> 
> Although multiple copies of a function's parameters may be saved on the stack during recursive calls, only one copy of the function body is in memory. This is why recursion is memory-efficient despite appearing to create multiple instances of the same function.

This implementation explains how C manages recursive function calls efficiently, using a single stack to track the state of each function call while keeping only one copy of the function code in memory.
## When and How to Trace Recursive Functions

Doing a trace by hand of multiple calls to a recursive function is helpful in understanding how recursion works but less useful when trying to develop a recursive algorithm.

> [!tip] **During Algorithm Development**
> 
> When developing a recursive algorithm, it's best to trace a specific case by trusting any recursive call to return a correct value based on the function's purpose. Then check whether this value is manipulated properly to produce a correct result for the case under consideration.

However, if a recursive function's implementation is flawed, tracing its execution becomes essential for identifying the error.

> [!info] **Self-Tracing Functions**
> 
> A function can be made to trace itself by inserting debugging print statements that show entry to and exit from the function. This approach helps visualize the flow of recursive calls and returns.

> [!example] **Self-Tracing multiply Function**
> 
> ```c
> /*
>  * *** Includes calls to printf to trace execution ***
>  * Performs integer multiplication using + operator.
>  * Pre: m and n are defined and n > 0
>  * Post: returns m * n
>  */
> int
> multiply(int m, int n)
> {
>     int ans;
> 
>     printf("Entering multiply with m = %d, n = %d\n", m, n);
> 
>     if (n == 1)
>         ans = m; /* simple case */
>     else
>         ans = m + multiply(m, n - 1); /* recursive step */
>     printf("multiply(%d, %d) returning %d\n", m, n, ans);
> 
>     return (ans);
> }
> ```
>
>When calling `multiply(8, 3)`, the output would be:
>
>```
>Entering multiply with m = 8, n = 3
>Entering multiply with m = 8, n = 2
>Entering multiply with m = 8, n = 1
>multiply(8, 1) returning 8
>multiply(8, 2) returning 16
>multiply(8, 3) returning 24
>```

This output clearly shows the sequence of recursive calls and the values returned at each step, making it easier to understand the execution flow and identify any potential issues in the recursive implementation.
# 9.3 Recursive Mathematical Functions

Many mathematical functions can be defined recursively. This approach is particularly useful when a problem can be broken down into smaller instances of the same problem.

> [!info] **Factorial Function Definition**
> 
> The factorial of a number $n$ ($n!$) can be defined recursively as:
> - $0! = 1$
> - $n! = n \times (n-1)!$, for $n > 0$

> [!example] **Factorial Calculation Example**
> 
> For example, $4!$ is calculated as:
> $4! = 4 \times 3! = 4 \times 3 \times 2! = 4 \times 3 \times 2 \times 1! = 4 \times 3 \times 2 \times 1 = 24$

> [!info] **Recursive Factorial Implementation**
> 
> ```c
> /*
>  * Compute n! using a recursive definition
>  * Pre: n >= 0
>  */
> int
> factorial(int n)
> {
>     int ans;
> 
>     if (n == 0)
>         ans = 1;
>     else
>         ans = n * factorial(n - 1);
> 
>     return (ans);
> }
> ```

The recursive step `ans = n * factorial(n - 1);` implements the second line of the factorial definition. The result of the current call (argument n) is computed by multiplying n by the result of the call `factorial(n - 1)`.
![[Pasted image 20251126201239.png]]

> [!warning] **Potential Integer Overflow**
> 
> Be careful when using the factorial function, as its value increases very rapidly and could lead to an integer overflow error (e.g., $8!$ is 40,320).

> [!info] **Iterative vs. Recursive Implementation**
> 
> The factorial function can also be implemented iteratively:
> 
> ```c
> /*
>  * Computes n!
>  * Pre: n is greater than or equal to zero
>  */
> int
> factorial(int n)
> {
>     int i, /* local variables */
>     product = 1;
> 
>     /* Compute the product n x (n-1) x (n-2) x . . . x 2 x 1 */
>     for (i = n; i > 1; --i) {
>         product = product * i;
>     }
> 
>     /* Return function result */
>     return (product);
> }
> ```

The iterative version contains a loop as its major control structure, whereas the recursive version contains an if statement. In the iterative version, the variable `product` is the target of repeated assignments, each of which brings its value closer to the result value. In the recursive version, the local variable `ans` holds the answer to the subproblem that is the reason for the current call to the function.


> [!info] **Fibonacci Sequence Definition**
> 
> The Fibonacci numbers are a sequence of numbers defined as:
> - Fibonacci(1) = 1
> - Fibonacci(2) = 1
> - Fibonacci(n) = Fibonacci(n-2) + Fibonacci(n-1), for n > 2
>   
The Fibonacci sequence begins: 1, 1, 2, 3, 5, 8, 13, 21, 34, ...

> [!example] **Recursive Fibonacci Implementation**
> The Fibonacci numbers are a sequence of numbers that have many varied uses
> ```c
> /*
>  * Computes the nth Fibonacci number
>  * Pre: n > 0
>  */
> int
> fibonacci(int n)
> {
>     int ans;
> 
>     if (n == 1 || n == 2)
>         ans = 1;
>     else
>         ans = fibonacci(n - 2) + fibonacci(n - 1);
> 
>     return (ans);
> }
> ```

> [!warning] **Efficiency Concern**
> 
> Although easy to write, this recursive version of fibonacci is not very efficient because each recursive step generates two calls to function fibonacci, and these calls duplicate many computations.


> [!info] **Greatest Common Divisor (GCD) Definition**
> 
> Euclid's algorithm for finding the gcd can be defined recursively as:
> - gcd(m,n) is n if n divides m evenly
> - gcd(m,n) is gcd(n, remainder of m divided by n) otherwise

The greatest common divisor of two integers is the largest integer that divides them both evenly. This algorithm works regardless of whether m or n is the larger number.

> [!example] **Recursive GCD Implementation**
> 
> ```c
> /*
>  * Finds the greatest common divisor of m and n
>  * Pre: m and n are both > 0
>  */
> int
> gcd(int m, int n)
> {
>     int ans;
> 
>     if (m % n == 0)
>         ans = n;
>     else
>         ans = gcd(n, m % n);
> 
>     return (ans);
> }
> ```

> [!tip] **GCD Algorithm Property**
> 
> One of the elegant features of this definition is that it does not matter whether m or n is the larger number. If m is greater than n, the computation seems to proceed more directly to a solution; if it is not, the first application of the recursive step has the effect of exchanging m and n. This exchange is a result of the fact that when m is less than n, the remainder of m divided by n is m.
# 9.4 Recursive Functions with Array and String Parameters

In this section, we examine recursive functions that process arrays and strings. These problems can often be solved by working with the first element of the array/string and then recursively processing the rest.

> [!summary] ## Case Study: Finding Capital Letters in a String
> 
>
>### The Problem
>Form a string containing all the capital letters found in another string.
>
>### Analysis
>
>Recursion allows us to solve this problem by processing the string's first letter and then combining this with a recursive call that handles the rest of the string.
>
>For example, if we're processing "Franklin Delano Roosevelt", finding capital letters in "ranklin Delano Roosevelt" would give us the string "DR". We can then combine this with the capital 'F' to form the complete result.
>
>The simplest case in which to look for ***anything*** is the empty string, which serves as our terminating condition.
>
>### Data Requirements
>
>- **Problem Input**: `char *str` - a string from which to extract capital letters
>- **Problem Output**: `char *caps` - the capital letters from str
>
>### Design
>
>The algorithm follows these steps:
>
>1. If str is the empty string, store an empty string in caps
>2. If the initial letter of str is a capital letter, store this letter and the capital letters from the rest of str in caps
>3. Otherwise, store only the capital letters from the rest of str in caps
>
>### Implementation
>
>```c
>/*
> * Forms a string containing all the capital letters found in the input
> * parameter str.
> * Pre: caps has sufficient space to store all caps in str plus the null
> */
>char *
>find_caps(char *caps, /* output - string of all caps found in str */
>          const char *str) /* input - string from which to extract caps */
>{
>    char restcaps[STRSIZ]; /* caps from reststr */
>
>    if (str[0] == '\0')
>        caps[0] = '\0'; /* no letters in str => no caps in str */
>    else
>        if (isupper(str[0]))
>            sprintf(caps, "%c%s", str[0], find_caps(restcaps, &str[1]));
>        else
>            find_caps(caps, &str[1]);
>
>    return (caps);
>}
>```
>
>### Testing
>Given this ``#define`` directive and declaration, 
>```C
>#define STRSIZ 50 
>. . . 
>char caps[STRSIZ];
>```
>and the statement ``printf("Capital letters in JoJo are %s\n", find_caps(caps, "JoJo"));
>``
>When we call`find_caps(caps, "JoJo")`, five recursive calls are executed:
>
>1. First call processes "JoJo" - 'J' is capital, so it combines 'J' with result from "oJo"
>2. Second call processes "oJo" - 'o' is not capital, so it returns result from "Jo"
>3. Third call processes "Jo" - 'J' is capital, so it combines 'J' with result from "o"
>4. Fourth call processes "o" - 'o' is not capital, so it returns result from ""
>5. Fifth call processes "" (empty string) - returns empty string
>
>The recursion unwinds with:
>- Fourth call returns ""
>- Third call combines 'J' with "" to return "J"
>- Second call returns "J"
>- First call combines 'J' with "J" to return "JJ"
>
>The final output is "JJ", which are all the capital letters in "JoJo".
>![[Pasted image 20251126202805.png]]
>_figure: Trace of `find_caps`_
>![[Pasted image 20251126202827.png]]
>_figure: event seq. of trace of `find_caps`_

> [!tip] **Recursive String Processing Pattern**
> 
> This example illustrates a common pattern for recursive string processing:
> - Process the first character
> - Make a recursive call to process the rest of the string
> - Combine the results appropriately

This approach can be adapted to many other string processing problems.

> [!summary]- Case Study: Recursive Selection Sort
>
>### Problem
>
>Sort an array in ascending order 
>
>### Analysis
>
>To perform a selection sort of an array with n elements (subscripts 0..$n-1$), we:
>
>1. Locate the largest element in the array
>2. Switch the largest element with the element at subscript $n-1$
>3. Repeat this process for the remaining subarray (subscripts 0..$n-2$)
>
>![[Pasted image 20251126203446.png]]
>_figure: trace of selection sort_
>
>This approach places the largest element in its final position, then the second largest, and so on, until the entire array is sorted. At most, n-1 exchanges are required to sort an array with n elements.
>
>> [!tip] **Recursive Approach**
>> 
>> The selection sort is a good candidate for a recursive solution because it can be viewed as:
>> 1. Placing one element (the largest) in its final position
>> 2. Then sorting a subarray (the remaining elements)
>
>### Design
>
>
> 
> 1. if n is 1
>    - The array is sorted.
> 2. else
>    - Place the largest array value in last array element.
>    - Sort the subarray which excludes the last array element (array[0]..array[n-2]).
>
>### Implementation
>
> **place_largest Function**
> 
> Finds the largest value in `array[0]..array[n-1]` and exchanges it with the value at `array[n-1]`
> 
> ```c
> void
> place_largest(int array[], /* input/output - array in which to place largest */
>               int n) /* input - number of array elements to consider */
> {
>     int temp, /* temporary variable for exchange */
>         j, /* array subscript and loop control */
>         max_index; /* index of largest so far */
> 
>     /* Save subscript of largest array value in max_index */
>     max_index = n - 1; /* assume last value is largest */
>     for (j = n - 2; j >= 0; --j)
>         if (array[j] > array[max_index])
>             max_index = j;
> 
>     /* Unless largest value is already in last element, exchange
>        largest and last elements */
>     if (max_index != n - 1) {
>         temp = array[n - 1];
>         array[n - 1] = array[max_index];
>         array[max_index] = temp;
>     }
> }
> ```
>
> **select_sort Function**
> 
> Sorts n elements of an array of integers using recursive selection sort
> 
> ```c
> void
> select_sort(int array[], /* input/output - array to sort */
>             int n) /* input - number of array elements to sort */
> {
>     if (n > 1) {
>         place_largest(array, n);
>         select_sort(array, n - 1);
>     }
> }
> ```
>
>> [!note] **Implementation Details**
>> 
>> The logic of the `select_sort` function differs slightly from the original algorithm. Rather than explicitly testing for the simple case (n == 1) and having an empty true branch, the implementation negates the test so that all actions are on the true branch of the decision. If n == 1, the function returns without doing anything, which is correct since a one-element array is always sorted.
>
> [!tip] **Performance Consideration**
> 
> The recursive version of selection sort is typically simpler to understand than the iterative version because it contains a single if statement rather than a loop. However, it usually executes more slowly due to the overhead of recursive function calls.
# 9.5 Problem Solving with Recursion

Since C does not have a built-in representation of a set data structure, we can develop an implementation of a group of set operations using strings as our sets.

> [!summary] ## Case Study: Operations on Sets
>
> ### The Problem
> 
> Develop a group of functions to perform the following operations on sets of characters:
> - ∈ (is an element of)
> - ⊆ (is a subset of)
> - ∪ (union)
> 
> Additionally, develop functions to:
> - Check that a certain set is valid (contains no duplicate characters)
> - Check for the empty set
> - Print a set in standard set notation
>
>### Analysis
>
>Character strings provide a natural representation of sets of characters. Like sets, strings can be of varying sizes and can be empty. If a character array that is to hold a set is declared to have one more element than the number of characters in the universal set (to allow room for the null character), then set operations should never produce a string that will overflow the array.
>
>### Design
>
>This problem is naturally divided into subproblems, each corresponding to a single function. Since one goal is to demonstrate recursion, we'll develop algorithms that avoid looping constructs.
>
>> [!info] **Algorithm for ``is_empty(set)``**
>> 
>> 1. Is initial character '\0'?
>
>> [!info] **Algorithm for ``is_element(ele, set)``**
>> 
>> 2. if is_empty(set) /* simple case 1 */
>>    - Answer is false.
>> 3. else if initial character of set matches ele /* simple case 2 */
>>    - Answer is true.
>> 4. else
>>    - Answer depends on whether ele is in the rest of set. /* recursive step */
>
>> [!info] **Algorithm for ``is_set(set)``**
>> 
>> 5. if is_empty(set) /* simple case 1 */
>>    - Answer is true.
>> 6. else if is_element(initial set character, rest of set) /* simple case 2 */
>>    - Answer is false.
>> 7. else
>>    - Answer depends on whether rest of set is a valid set. /* recursive step */
>
>> [!info] **Algorithm for ``is_subset(sub, set)``**
>> 
>> 8. if is_empty(sub) /* simple case 1 */
>>    - Answer is true.
>> 9. else if initial character of sub is not an element of set /* simple case 2 */
>>    - Answer is false.
>> 10. else
>>    - Answer depends on whether rest of sub is a subset of set. /* recursive step */
>
>> [!info] **Algorithm for ``union`` of set1 and set2**
>> 
>> 11. if is_empty(set1) /* simple case */
>>    - Result is set2.
>> 12. else if initial character of set1 is also an element of set2 /* recursive steps */
>>    - Result is the union of the rest of set1 with set2. /* case 1 */
>> 13. else /* case 2 */
>>    - Result includes initial character of set1 and the union of the rest of set1 with set2.
>
>> [!info] **Algorithm for ``print_set(set)``**
>> 
>> 14. Output a {.
>> 15. if set is not empty, print elements separated by commas.
>> 16. Output a }.
>
>> [!info] **Algorithm for ``print_with_commas(set)``**
>> 
>> 15. if set has exactly one element
>>    - Print it.
>> 16. else
>>    - Print initial element and a comma.
>>    - print_with_commas the rest of set.
>
>### Implementation
>
>> [!note] **String Representation**
>> 
>> Every recursive function references "the rest of the set" for some set, which is all but the first letter of the set. Since this substring is passed as an input argument only, we can use `&set[1]` to reference the rest of the set.
>
>> [!warning] **Function Naming**
>> 
>> The function that forms the union of two sets is named `set_union` rather than `union` because `union` is a reserved word in C.
>
>> [!warning] **sprintf Usage**
>> 
>> In the implementation of `set_union`, we could not use the variable `result` as the output argument for both the call to `set_union` and the call to `sprintf` because `sprintf` does not guarantee correct results if there is overlap between its input and output arguments.
>
>> [!example] **Implementation of Set Operations**
>> 
>> ```c
>> /*
>>  * Determines if set is empty. If so, returns 1; if not, returns 0.
>>  */
>> int
>> is_empty(const char *set)
>> {
>>     return (set[0] == '\0');
>> }
>> 
>> /*
>>  * Determines if ele is an element of set.
>>  */
>> int
>> is_element(char ele, /* input - element to look for in set */
>>             const char *set) /* input - set in which to look for ele */
>> {
>>     int ans;
>> 
>>     if (is_empty(set))
>>         ans = FALSE;
>>     else if (set[0] == ele)
>>         ans = TRUE;
>>     else
>>         ans = is_element(ele, &set[1]);
>> 
>>     return (ans);
>> }
>> 
>> /*
>>  * Determines if string value of set represents a valid set (no duplicate
>>  * elements)
>>  */
>> int
>> is_set (const char *set)
>> {
>>     int ans;
>> 
>>     if (is_empty(set))
>>         ans = TRUE;
>>     else if (is_element(set[0], &set[1]))
>>         ans = FALSE;
>>     else
>>         ans = is_set(&set[1]);
>>     return (ans);
>> }
>> 
>> /*
>>  * Determines if value of sub is a subset of value of set.
>>  */
>> int
>> is_subset(const char *sub, const char *set)
>> {
>>     int ans;
>> 
>>     if (is_empty(sub))
>>         ans = TRUE;
>>     else if (!is_element(sub[0], set))
>>         ans = FALSE;
>>     else
>>         ans = is_subset(&sub[1], set);
>> 
>>     return (ans);
>> }
>> 
>> /*
>>  * Finds the union of set1 and set2.
>>  * Pre: size of result array is at least SETSIZ;
>>  * set1 and set2 are valid sets of characters and digits
>>  */
>> char *
>> set_union(char *result, /* output - space in which to store
>>                           string result */
>>            const char *set1, /* input - sets whose */
>>            const char *set2) /* union is being formed */
>> {
>>     char temp[SETSIZ]; /* local variable to hold result of call
>>                           to set_union embedded in sprintf call */
>> 
>>     if (is_empty(set1))
>>         strcpy(result, set2);
>>     else if (is_element(set1[0], set2))
>>         set_union(result, &set1[1], set2);
>>     else
>>         sprintf(result, "%c%s", set1[0],
>>                 set_union(temp, &set1[1], set2));
>> 
>>     return (result);
>> }
>> 
>> /*
>>  * Displays a string so that each pair of characters is separated by a
>>  * comma and a space.
>>  */
>> void
>> print_with_commas(const char *str)
>> {
>>     if (strlen(str) == 1) {
>>         putchar(str[0]);
>>     } else {
>>         printf("%c, ", str[0]);
>>         print_with_commas(&str[1]);
>>     }
>> }
>> 
>> /*
>>  * Displays a string in standard set notation.
>>  * e.g. print_set("abc") outputs {a, b, c}
>>  */
>> void
>> print_set(const char *set)
>> {
>>     putchar('{');
>>     if (!is_empty(set))
>>         print_with_commas(set);
>>     putchar('}');
>> }
>> 
>> /*
>>  * Gets a set input as a string with brackets (e.g., {abc})
>>  * and strips off the brackets.
>>  */
>> char *
>> get_set(char *set) /* output - set string without brackets {} */
>> {
>>     char inset[SETSIZ];
>> 
>>     scanf("%s", inset);
>>     strncpy(set, &inset[1], strlen(inset) - 2);
>>     set[strlen(inset) - 2] = '\0';
>>     return (set);
>> }
>> ```
>
>### Testing
>
>> [!info] **Helper Function**
>> 
>> The function `get_set` takes an input string representing a set and strips off the brackets `{}` that the driver program asks the user to place around the set entered. These brackets make it easy for the user to enter the empty set.
>
>> [!tip] **Testing Approach**
>> 
>> When testing these functions, choose data that checks boundary conditions:
>> 
>> - For `is_set`: test valid sets (including empty set) and invalid sets with duplicate letters in various parts
>> - For `is_element`: test elements at beginning, middle, and end of set, elements not in the string, and the empty set
>> - For `is_subset`: test empty sets for sub and/or set, various orderings of letters in sub, and cases where sets are equal
>> - For `set_union`: test equal sets, disjoint sets, partially overlapping sets with various orderings, and empty set as first argument, second argument, or both arguments
# 9.6 A Classic Case Study in Recursion: Towers of Hanoi

The Towers of Hanoi problem is a classic example that demonstrates the power of recursion in solving complex problems.

> [!info] **Problem Statement**
> 
> The Towers of Hanoi problem involves moving a specified number of disks that are all different sizes from one tower (or peg) to another. The goal is to move n disks from peg A to peg C using peg B as needed, with these conditions:
> 1. Only one disk at a time may be moved, and this disk must be the top disk on a peg.
> 2. A larger disk can never be placed on top of a smaller disk.

## Analysis

The problem can be solved by breaking it down into simpler subproblems. For example, to move 5 disks from peg A to peg C, we can:

1. Move four disks from peg A to peg B.
2. Move disk 5 from peg A to peg C.
3. Move four disks from peg B to peg C.

![[Pasted image 20251126210956.png]]
_figure: Towers of Hanoi

This approach splits the original problem into simpler problems involving fewer disks. By recursively applying this strategy, we eventually divide the problem into many one-disk problems, which are simple cases we can solve directly.

> [!example] **Problem Decomposition**
> 
> The key insight is that an n-disk problem can be broken down into:
> - Moving n-1 disks to the auxiliary peg B
> - Moving the largest disk to the target peg C
> - Moving the n-1 disks from the auxiliary peg to the target peg

## Design

The recursive algorithm for solving the Towers of Hanoi problem follows this structure:

> [!info] **Algorithm**
> 
> 1. if n is 1 then
>    - Move disk 1 from the from peg to the to peg
> 2. else
>    - Move n-1 disks from the from peg to the auxiliary peg using the to peg
>    - Move disk n from the from peg to the to peg
>    - Move n-1 disks from the auxiliary peg to the to peg using the from peg

![[Pasted image 20251126211027.png]]
_figure: Towers after steps 1 & 2_

Unfortunately, we still don’t know how to perform step 1 or step 3. However, both of these steps involve four disks instead of five, so they are easier than the original problem. We should be able to split each of these steps into simpler problems in the same way that we split the original problem. Step 3 involves moving four disks from peg B to peg C, so we can split this step into the following two three-disk problems and one one-disk problem: 3.1 Move three disks from peg B to peg A. 3.2 Move disk 4 from peg B to peg C. 3.3 Move three disks from peg A to peg C

![[Pasted image 20251126211114.png]]
_figure: Towers after steps 1 & 2, 3.1 & 3.2_
## Implementation

The recursive solution can be implemented as a function that takes the number of disks and the three pegs as parameters:

> [!example] **Recursive Tower Function**
> 
> ```c
> /*
>  * Displays instructions for moving n disks from from_peg to to_peg using
>  * aux_peg as an auxiliary. Disks are numbered 1 to n (smallest to
>  * largest). Instructions call for moving one disk at a time and never
>  * require placing a larger disk on top of a smaller one.
>  */
> void
> tower(char from_peg, /* input - characters naming */
>       char to_peg, /* the problem's */
>       char aux_peg, /* three pegs */
>       int n) /* input - number of disks to move */
> {
>     if (n == 1) {
>         printf("Move disk 1 from peg %c to peg %c\n", from_peg, to_peg);
>     } else {
>         tower(from_peg, aux_peg, to_peg, n - 1);
>         printf("Move disk %d from peg %c to peg %c\n", n, from_peg, to_peg);
>         tower(aux_peg, to_peg, from_peg, n - 1);
>     }
> }
> ```

To solve the problem of moving 5 disks from peg A to peg C using B as an auxiliary, we would call:
```c
tower('A', 'C', 'B', 5);
```

## Testing

To verify the function works correctly, we can test it with a smaller number of disks. For example, calling:
```c
tower('A', 'C', 'B', 3);
```

This generates a sequence of moves that solves the three-disk problem. The output shows each individual move required to transfer all three disks from peg A to peg C using peg B as an auxiliary.
![[Pasted image 20251126211219.png]]
_figure: Trace of `tower(A, C, B, 3)`_

![[Pasted image 20251126211300.png]]
_figure: Output of `tower`_

> [!warning] **Performance Considerations**
> 
> The number of moves required to solve the n-disk problem is 2^n - 1. Because each function call requires allocation and initialization of a local data area in memory, the computer time increases exponentially with the problem size. Be careful about running this program with a value of n that is larger than 10.

## Comparison of Iterative and Recursive Functions

> [!tip] **Recursion vs. Iteration**
> 
> For certain problems like the Towers of Hanoi, recursion leads naturally to solutions that are much easier to read and understand than their iterative counterparts. Although recursive solutions generally require more time and space due to the extra function calls, the benefits gained from increased clarity often outweigh these costs.
> 
> To researchers developing solutions to complex problems at the frontiers of their research areas, the clarity provided by recursive solutions is particularly valuable.

The dramatic increase in processing time for larger numbers of disks is a function of this specific problem, not a function of recursion in general. However, it's worth noting that if there are both recursive and iterative solutions to the same problem, the recursive solution will typically require more time and space because of the overhead of function calls.
# 9.7 Common Programming Errors

When working with recursive functions, several common programming errors can occur. Understanding these issues can help you write more robust recursive code.

> [!warning] **Improper Function Termination**
> 
> The most common problem with recursive functions is that they may not terminate properly. This can happen when:
> - The terminating condition is incorrect or incomplete
> - The function calls itself indefinitely or until all available memory is exhausted
> 
> A run-time error message noting "stack overflow" or "access violation" often indicates that a recursive function is not terminating.

> [!tip] **Ensuring Proper Termination**
> 
> To prevent termination issues:
> - Identify all simple cases and provide a terminating condition for each one
> - Ensure each recursive step redefines the problem using arguments that are closer to simple cases
> - Verify that repeated recursive calls will eventually lead to simple cases only

> [!warning] **Missing Return Statements**
> 
> In functions that return values, it's critical that every path through the function leads to a return statement. For example, in the `is_set` function:
> 
> ```c
> int
> is_set(const char *set)
> {
>     if (is_empty(set))
>         return (TRUE);
>     else if (is_element(set[0], &set[1]))
>         return (FALSE);
>     else
>         return (is_set(&set[1]));  // This return is just as important as the others
> }
> ```
> 
> It's easy to inadvertently omit one of these necessary return statements when using multiple return statements throughout a function.

> [!warning] **Memory Issues with Data Recopying**
> 
> Recopying large arrays or other data structures inside recursive functions can quickly consume all available memory. To avoid this:
> - Only recopy data inside a recursive function when absolutely essential for data protection
> - If only a single copy is necessary, create a nonrecursive function that:
>   - Makes the necessary copy
>   - Passes the copy and other arguments to the recursive function
>   - Returns the result computed

> [!tip] **Efficient Error Handling**
> 
> It's good practice to introduce a nonrecursive function to handle preliminaries and call the recursive function when there is error checking. This approach is more efficient because:
> - Checking for errors inside a recursive function is extremely inefficient if the error would be detected on the very first call
> - Repeated checks in recursive calls waste computer time

> [!tip] **Managing Output Display**
> 
> When observing output from self-tracing recursive functions:
> - If each recursive call generates multiple output lines and there are many recursive calls, the output may scroll too quickly to read
> - On most systems, pressing a control character sequence (e.g., Control-S) will temporarily stop output to the screen
> - Alternatively, you can pause output by printing a prompting message followed by a call to `getchar()`. The program will resume when you enter a data character.