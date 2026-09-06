---
tags:
  - "#IMPR"
  - "#C"
  - "#CCT1"
Topic: Array & Array Pointers
Semester: CCT1
Course: IMPR1
Litterature:
  - Problem Solving and Program Design in C, Global Edition, 8th ed.
Created: 06-11-25
---
- - -
## Table of Contents

- [[#Intro|Intro]]
- [[#7.1 Declaring and Referencing *Arrays*|7.1 Declaring and Referencing *Arrays*]]
			- [[#The array ``x``|The array ``x``]]
	- [[#7.1 Declaring and Referencing *Arrays*#Array Initilization|Array Initilization]]
	- [[#7.1 Declaring and Referencing *Arrays*#Storing a String in an Array of Characters|Storing a String in an Array of Characters]]
- [[#7.2 Array Subscripts|7.2 Array Subscripts]]
- [[#7.3 Using *for* Loops for Sequential Access|7.3 Using *for* Loops for Sequential Access]]
	- [[#7.3 Using *for* Loops for Sequential Access#Statistical Computations Using Arrays|Statistical Computations Using Arrays]]
		- [[#Statistical Computations Using Arrays#The *computation* ``for`` loop|The *computation* ``for`` loop]]
	- [[#7.3 Using *for* Loops for Sequential Access#Program Style - Using Loop Control Variables as Array Subscripts|Program Style - Using Loop Control Variables as Array Subscripts]]
- [[#7.4 Using Array Elements as Function Arguments|7.4 Using Array Elements as Function Arguments]]
- [[#7.5 Array Arguments|7.5 Array Arguments]]
	- [[#7.5 Array Arguments#Formal Array Parameter|Formal Array Parameter]]
	- [[#7.5 Array Arguments#Argument Correspondence for Array Parameters|Argument Correspondence for Array Parameters]]
		- [[#Argument Correspondence for Array Parameters#Use of ``*list`` Instead of ``list[]`` in a Formal Parameter List|Use of ``*list`` Instead of ``list[]`` in a Formal Parameter List]]
	- [[#7.5 Array Arguments#Arrays as Input Arguments|Arrays as Input Arguments]]
	- [[#7.5 Array Arguments#Returning an Array Result|Returning an Array Result]]
		- [[#Returning an Array Result#Address-of Operator Not Used|Address-of Operator Not Used]]
	- [[#7.5 Array Arguments#Partially Filled Arrays|Partially Filled Arrays]]
	- [[#7.5 Array Arguments#Stacks|Stacks]]
- [[#7.6 Searching and Sorting an Array|7.6 Searching and Sorting an Array]]
	- [[#7.6 Searching and Sorting an Array#Array Search|Array Search]]
		- [[#Array Search#Linear search algorithm|Linear search algorithm]]
	- [[#7.6 Searching and Sorting an Array#Sorting an Array|Sorting an Array]]
		- [[#Sorting an Array#Selection Sort algorithm|Selection Sort algorithm]]
- [[#7.7 Parallel Arrays and Enumerated Types|7.7 Parallel Arrays and Enumerated Types]]
	- [[#7.7 Parallel Arrays and Enumerated Types#Intro|Intro]]
	- [[#7.7 Parallel Arrays and Enumerated Types#Enumerated Types|Enumerated Types]]
		- [[#Enumerated Types#Example - Fig 7.18|Example - Fig 7.18]]
		- [[#Enumerated Types#Example - Enums + Switch|Example - Enums + Switch]]
		- [[#Enumerated Types#Example - Enum Constants|Example - Enum Constants]]
	- [[#7.7 Parallel Arrays and Enumerated Types#Array with Enumerated Type Subscript|Array with Enumerated Type Subscript]]
		- [[#Array with Enumerated Type Subscript#Example|Example]]
	- [[#7.7 Parallel Arrays and Enumerated Types#Best Practices|Best Practices]]
- [[#7.8 Multi-dimensional Arrays|7.8 Multi-dimensional Arrays]]
	- [[#7.8 Multi-dimensional Arrays#Initialization of multi-dimensional Arrays|Initialization of multi-dimensional Arrays]]
	- [[#7.8 Multi-dimensional Arrays#Arrays with Several Dimensions|Arrays with Several Dimensions]]
- [[#7.9 Array Processing Illustrated|7.9 Array Processing Illustrated]]
	- [[#7.9 Array Processing Illustrated#Coding Function ``main``|Coding Function ``main``]]
	- [[#7.9 Array Processing Illustrated#Coding Function ``scan_table``|Coding Function ``scan_table``]]
	- [[#7.9 Array Processing Illustrated#Coding Functions ``sum_rows`` and ``sum_columns``|Coding Functions ``sum_rows`` and ``sum_columns``]]
	- [[#7.9 Array Processing Illustrated#Coding Function ``display_table``|Coding Function ``display_table``]]
- [[#7.10 Graphics Programs with Arrays (Optional)|7.10 Graphics Programs with Arrays (Optional)]]
- [[#7.11 Common Programming Errors|7.11 Common Programming Errors]]
# Intro
> [!info] Datastructure: Array
> Each instance of simple data type(s), use a single memory cell to store a variable.

It is more efficient to group data items together in main memory than to allocate an individual memory cell for each variable. 
C allows a programmer to group such related data items together into a single composite ***data structure***, one these structures is called an ***array***.
# 7.1 Declaring and Referencing *Arrays*
> [!Summary] Array
> An array is a collection of two or more adjacent memory cells, called array elements, that are associated with a particular symbolic name.

> [!example] Declaration
```C
// Allocate 8 adjacent memory cells with the name 'x'. Each of which may contain a single type [double] value.
double x[8];
```
C implements arrays using *pointers*.
The *value* of the `x` is the address of the *initial array elements*, and `x`'s type is a *pointer* to ``double``.
To process data stored in an array, we reference each *individual element* by specifying:
- The array name.
- Identifying the desired element.
The *subscripted variable* ``x[0]`` (``x`` *sub* ``0``), is used to reference the initial or *0th* element of the array, x, ``x[1]`` the next element, and so on.

The integer enclosed in brackets is the *array subscript*, and its *value* must be in the range from *0* (Arrays start at 0) to one less than the number of memory cells in the array.
#### The array ``x``
![[Pasted image 20251106101735.png]]
>[!summary]- Statements That Manipulate Array [[#The array ``x``|x]]
> | Statement | Description |
> |----------|----------|
> | ``printf("%.lf", x[0]);``  | Displays the value of ``x[0]``, which is $16.0$. |
> | ``x[3] = 25.0;`` | Stores the value $25.0$ in ``x[3]`` |
> | ``sum = x[0] + x[1];`` | Stores the sum of ``x[0]`` and ``x[1]``, which is $28.0$ in the variable ``sum``. |
> | ``sum += x[2];`` | Adds ``x[2]`` to ``sum``. The new ``sum`` is $34.0$. |
> | ``x[3] += 1.0;`` | Adds $1.0$ to ``x[3]``. The new ``x[3]`` is $26.0$. |
> | ``x[2] = x[0] + x[1];`` | Stores the sum of ``x[0]`` and ``x[1]`` in ``x[2]``. The new ``x[2]`` is $28.0$. |
> 
> New array ``x``
> ![[Pasted image 20251106103802.png]]
## Array Initilization
We can initialize a simple variable when we declare it.
```C
int sum = 0;
```
We can also initialize an array in its declaration.
	We can omit the size of an array that is being fully initialized since the size can be deduced from the initialization list.

> [!example]
> We initialize a 25-element array without declaring its size (``[]`` is empty), with the prime numbers less than 100.
```C
int prime_lt_100[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
```
Array element ``prime_lt_100[24]`` is 97.

> [!summary]- Array Declaration
> ![[Pasted image 20251106104335.png]]
## Storing a String in an Array of Characters
you can store individual characters in an array by writing each character in the initialization list.
> [!tip]
> If the list is long, you can do this more easily by using a string instead of an initialization list.

> [!example]
```C
char vowels[] = "This is a long string";
// In this case, vowels[0] stores the character 'T', vowels[1] 'h', and so on
```
# 7.2 Array Subscripts
> [!info]
> We use subscript to differentiate between the individual array elements and to specify which array element is to be manipulated.

We can use any expression of type ``int`` as an array subscript. 
	However, to create a valid reference, the value of this subscript must lie between 0 and one less than the declared size of the array
> [!example] Understanding the distinction between an ***array subscript*** value and an array ***element value***
> If *i* has the value $0$, the ***subscript value*** is $0$, and ``x[0]`` is referenced. The value of ``x[0]`` in this case is $16.0$. 
> If *i* has the value $2$, the ***subscript value*** is $2$, and the value of ``x[i]`` is $6.0$. 
> If *i* has the value $8$, the ***subscript value*** is $8$, and we cannot predict the value of ``x[i]`` because the subscript value is out of the allowable range.

> [!summary]- Code Fragment That Manipulates Array [[#The array ``x``|x]]
> | Statement | Description |
> |----------|----------|
> | `printf("%d %.1f\n", 4, x[4]);` | Displays $4$ and $2.5$ (value of ``x[4]``) |
> | `printf("%d %.1f\n", i, x[i]);` | Displays $5$ and $12.0$ (value of ``x[5]``) |
> | `printf("%.1f\n", x[i] + 1);` | Displays $13.0$ (value of ``x[5]`` plus 1) |
> | `printf("%.1f\n", x[i] + i);` | Displays $17.0$ (value of ``x[5]`` plus 5) |
> | `printf("%.1f\n", x[i + 1]);` | Displays $14.0$ (value of ``x[6]``) |
> | `printf("%.1f\n", x[i + i]);` | INVALID. Attempt to display ``x[10]`` |
> | `printf("%.1f\n", x[2 * i]);` | INVALID. Attempt to display ``x[10]`` |
> | `printf("%.1f\n", x[2 * i − 3]);` | Displays $−54.5$ (value of ``x[7]``) |
> | `printf("%.1f\n", x[(int)x[4]]);` | Displays $6.0$ (value of ``x[2]``) |
> | `printf("%.1f\n", x[i++]);` | Displays $12.0$ (value of ``x[5]``); then assigns $6$ to *i* |
> | `printf("%.1f \n", x[−−i]);` | Assigns $5 (6 − 1)$ to *i* and then displays $12.0$ (value of ``x[5]``) |
> | `x[i − 1] = x[i];` | Assigns $12.0$ (value of ``x[5]``) to ``x[4]`` |
> | `x[i] = x[i + 1];` | Assigns $14.0$ (value of ``x[6]``) to ``x[5]`` |
> | `x[i] − 1 = x[i];` | Illegal assignment statement |
> 
> >[!warning]
>>The two attempts to display element ``x[10]``, which is not in the array, may result in a run-time error, but they are more likely to print incorrect results

![[Pasted image 20251106120524.png]]
![[Pasted image 20251106120551.png]]
# 7.3 Using *for* Loops for Sequential Access
> [!info]
> Very often, we wish to process the elements of an array in sequence, starting with element zero.

In C, we can accomplish this processing easily using an *indexed* ``for`` loop. 
	A counting loop whose loop control variable runs from $0$ to one less than the array size. Using the loop counter as an array index (subscript) gives access to each array element in turn.

> [!example]
> The following array ``square`` will be used to store the squares of the integers 0 through 10 (e.g., square[0] is 0, square[10] is 100).
```C
// We assume that the name SIZE has been defined to be 11.
int square[SIZE], i;

// the [for] loop:
for (i = 0; i < SIZE; ++i)
	square[i] = i * i;
```
![[Pasted image 20251106121211.png]]
## Statistical Computations Using Arrays
One common use of arrays is for storage of a collection of related data values. 
Once the values are stored, we can perform some simple statistical computations.

> [!example] Program to Print a Table of Differences
```C
#include <stdio.h>
#include <math.h>

#define MAX_ITEM 8

int main(void){
	double x[MAX_ITEM], //data list
		mean, //mean (average) of the data
		st_dev, //standard deviation of the data
		sum, //sum of the data
		sum_sqr; //sum of the squares of the data
		
	int i;
	
	// Gets data
	printf("Enter %d numbers separated by blanks or s\n> ", MAX_ITEM);
	for (i = 0; i < MAX_ITEM; ++i)
		scanf("%lf", &x[i]);
		
	// Computes sum, and sum of the square of all data
	sum = 0;
	sum_sqr = 0;
	for (i = 0; i < MAX_ITEM; ++i){
		sum += x[i];
		sum_sqr += x[i] * x[i];
	}
	
	// Computes and prints the mean and standard deviation
	mean = sum / MAX_ITEM;
	st_dev = sqrt(sum_sqr / MAX_ITEM - mean * mean);
	printf("The mean is %.2f.\n", mean);
	printf("The standard deviation is %.2f.\n", st_dev);
	
	// displays tje diff between each item and mean
	printf("\nTable of differences between data values and mean\n");
	printf("Index Item Difference\n");
	for (i = 0; i < MAX_ITEM; ++i)
		printf("%3d%4c%9.2f%5c%9.2f\n", i, ' ', x[i], ' ', x[i] - mean);
	
	return 0;
}
```
![[Pasted image 20251106122917.png]]
The program uses 3 `for` loops to process the array `x`.
	The constant macro MAX_ITEM determines the size of the array. 
	The variable i is used as the loop control variable and array subscript in each loop.

1. The first ``for`` loop, stores one input value into each element of array x (the first item is placed in ``x[0]``, the next in ``x[1]``, and so on).
2. The second ``for`` loop accumulates (in sum) the sum of all values stored in the array. The loop also accumulates (in sum_sqr) the sum of the squares of all element values.
3. The last ``for`` loop displays a table. Each line of the table displays an array subscript, an array element, and the difference between that element and the mean, $x[i] − mean$.

### The *computation* ``for`` loop 
accumulates the sum of all eight elements of array ``x`` in the variable ``sum``. 
	Each time the loop body executes, the next element of array ``x`` is added to ``sum``. Then this array element value is squared, and its square is added to the sum being accumulated in ``sum_sqr``.

> [!info] The standard deviation of a set of data
> is a measure of the spread of the data values around the mean. A small standard deviation indicates that the data values are all relatively close to the average value. For MAX_ITEM data items, if we assume that x is an array whose lowest subscript is 0.

![[Pasted image 20251106124824.png]]
## Program Style - Using Loop Control Variables as Array Subscripts
The use of the loop control variable as an array subscript is common, because it allows the programmer to specify easily the sequence in which the elements of an array are to be manipulated. Each time the value of the loop control variable is increased, the next array element is automatically selected. 
> [!note] 
> Note that the same loop control variable is used in all three loops. This reuse is not necessary, but is permitted since the loop control variable is always initialized at loop entry. Thus, i is reset to 0 when each loop is entered.
# 7.4 Using Array Elements as Function Arguments
The array ``x[i]`` is used as an argument for ***functions*** ``scanf`` and ``printf``.
	The actual *array element* referenced depends on the value of *i*.

The call
```C
printf("%3d%4c%9.2f%5c%9.2f\n", i, ' ', x[i], ' ', x[i] - mean);
```
uses *array element* ``x[i]`` as an input argument to function ``printf``. 
When *i* is $3$, the value of ``x[3]``, or $8.0$, is passed to ``printf`` and displayed.

You can also pass array elements as arguments to functions that you write. 
Each array element must correspond to a formal parameter that is the same simple type as the array element
# 7.5 Array Arguments
> [!info]
> Besides passing individual array elements to functions, we can write functions that have arrays as arguments. Such functions can manipulate some, or all, of the elements corresponding to an actual array argument.
## Formal Array Parameter
When an array name with **no subscript** appears in the argument list of a function call, what is actually stored in the function’s corresponding formal parameter is the *address* of the initial array element.
In the function body, we can use subscripts with the formal parameter to access the array’s elements.
> [!warning]
> The function manipulates the original array, not its own personal copy!

> [!example]
```C
// a function that stores the same value (in_value) in all elements of the array corresponding to its formal array parameter list

void fill_array (int list[], int n, int in_value){
	int i;

	for (i = 0; i < n; ++i)
		list[i] = in-value;
}
```
In function ``fill_array``, the *array parameter* is declared as ``int list[]``.

> [!note]
> Notice that the parameter declaration does not indicate how many elements are in list. Because C does not allocate space in memory for a copy of the actual array, the compiler does not need to know the size of the array parameter
## Argument Correspondence for Array Parameters
To call function ``fill_array``, you must specify the actual array argument, the number of array elements, and the value to be stored in the array. 

> [!example]
> If *y* is an array with ten type ``int`` elements, the function call
```C
fill_array(y, 10, num);
```
stores the value of num in the ten elements of array *y*. 
> [!example]
> If *x* is a five-element array of type ``int`` values, the statement
```C
fill_array(x, 5, 1);
```
causes function ``fill_array`` to store $1$ in all elements of array *x*.
![[Pasted image 20251106132810.png]]

### Use of ``*list`` Instead of ``list[]`` in a Formal Parameter List
Both declare `list` as a pointer to an integer. This is because, as discussed in [[#7.5 Array Arguments|Array Arguments]], when you pass an array to a function, you are only passing the address of its first element. 
The function parameter is simply a variable that receives this address.

| Syntax      | Readability | Intent                                                                                         | Best For                                                                                                                       |
| ----------- | ----------- | ---------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------ |
| `int arr[]` | High        | Clearly indicates the function expects an array.                                               | General-purpose functions that operate on arrays. It's the most common and idiomatic choice.                                   |
| `int *arr`  | Medium      | Indicates the function expects a pointer. Could be an array, or a pointer to a single element. | Low-level pointer manipulation, or when the function might operate on a sub-array (e.g., `process_array(arr + 2, size - 2);`). |
> [!warning] The Size is Still Unknown! 
> Remember that **neither** `int arr[]` nor `int *arr` tells the function how many elements are in the array. You **must** always pass the size of the array as a separate parameter to avoid out-of-bounds errors.
```C
// CORRECT: Always pass the size
void fill_with_zeros(int arr[], int size);

// DANGEROUS: Function has no way of knowing the array's size
void fill_with_zeros_dangerous(int arr[]); 
```
## Arrays as Input Arguments
ANSI C provides a qualifier that we can include in the declaration of the array formal parameter in order to notify the C compiler that the array is only an input to the function and that the function does not intend to modify the array.
	The qualifier ``const`` allows the compiler to mark as an error any attempt to change an array element within the function.
![[Pasted image 20251106133449.png]]
## Returning an Array Result
> [!danger]
> In C, it is not legal for a function’s return type to be an array!

Defining a function requires use of an output parameter to send the result array back to the calling module.
![[Pasted image 20251106133624.png]]

When we use simple output parameters, the calling function must declare variables into which the function subprogram will store its results.
Similarly, a function returning an array result depends on its caller to provide an array variable into which the result can be stored.

> [!example] Function to Add Two Arrays
```C
/* Adds corresponding elements of arrays ar1 and ar2, storing the result in
arsum. Processes first n elements only.
Pre: First n elements of ar1 and ar2 are defined. arsum’s corresponding
actual argument has a declared size >= n (n >= 0) */

void add_arrys(const double ar1[], // input
	const double ar2[], // arrays being added
	double arsum[], // output - sum of corresponding elements in ar1 & ar2
	int n) // input - number of element pairs summed
{	
	int i;
	
	// add corresponding elements of arrays
	for (i = 0; i < n; ++i)
		arsum[i] = ar1[i] + ar2[i];
}
```
The formal parameter list declaration:
- ``const double ar1[]`` 
- ``const double ar2[]`` 
- ``double arsum[]`` 
- ``int n``
Indicates that formal parameters ``ar1``, ``ar2``, and ``arsum`` are pointers to actual argument arrays whose elements are of type ``double`` and that ``ar1`` and ``ar2`` are ***strictly*** input parameters, as is ``n``.

> [!example]- ``x_plus_y``
> If we assume that a calling function has declared three five-element arrays ``x``, ``y``, and ``x_plus_y`` and has filled ``x`` and ``y`` with data.
>  ```C
> add_arrays(x, y, x_plus_y, 5);
> ```
> ![[Pasted image 20251106155907.png]]
> After execution of the function, ``x_plus_y[0]`` will contain the sum of ``x[0]`` and ``y[0]``, or $3.5$; ``x_plus_y[1]`` will contain the sum of ``x[1]`` and ``y[1]``, or $6.7$; and so on.
> ![[Pasted image 20251106160248.png]]

### Address-of Operator Not Used
> [!warning]
> Note carefully that in the *call* to ``add_arrays`` there is no notational difference between the references to input argument arrays ``x`` and ``y`` and the reference to output argument array ``x_plus_y``. Specifically, the ``&`` (address-of) operator is not applied to the name of the output array argument. 
> Since the output parameter ``arsum`` is declared with no ``const`` qualifier, function ``add_arrays`` automatically has access and authority to change the corresponding actual array argument.
## Partially Filled Arrays
Frequently, a program will need to process many lists of similar data; these lists may not all be the same length. 
In order to reuse an array for processing more than one data set, the programmer often declares an array large enough to hold the largest data set anticipated. 

This array can be used for processing shorter lists as well, provided that the program keeps track of how many array elements are actually in use.

> [!example] Function Using a Sentinel-Controlled Loop to Store Input Data in an Array
```C
/*
 * Fills an array with input values until a sentinel is entered or the array is full.
 * list: the array to be filled
 * max_size: the capacity of the array
 * sentinel: the value that signals the end of input
 * Returns the number of elements actually stored in the array.
 */
int fill_to_sentinel(int list[], int max_size, int sentinel) {
    int i = 0;
    printf("Enter up to %d values (enter %d to stop):\n", max_size, sentinel);
    
    while (i < max_size && scanf("%d", &list[i]) == 1 && list[i] != sentinel) {
        i++;
    }
    
    return i; // Return the number of items stored
}
```
> [!example] Driver for Testing fill_to_sentinel
> The purpose of function ``fill_to_sentinel`` is to fill a type ``double`` array with data until the designated sentinel value is encountered in the input data.
> 
> When we use an array that may be only partially filled, we must deal with two array sizes. 
> One size is the array’s declared size, represented by the input parameter ``dbl_max``.
>  The other is the size counting only the elements in use, represented by the output parameter ``dbl_sizep``.
>  The declared size is only of interest at the point in a program where the array is being filled, for it is important not to try to store values beyond the array’s bounds. 
> 	 However, once this input step is complete, the array size relevant in the rest of the processing is the number of elements actually filled.
```C
/*
 * Gets data to place in dbl_arr until value of sentinel is encountered in input.
 * Returns number of values stored through dbl_sizep.
 * Stops input prematurely if there are more than dbl_max data values before
 * sentinel or if invalid data is encountered.
 * Pre: sentinel and dbl_max are defined and dbl_max is declared size of dbl_arr
 */
void fill_to_sentinel(int dbl_max,        /* input - declared size of dbl_arr */
                    double sentinel,       /* input - end of data value in input list */
                    double dbl_arr[],       /* output - array of data */
                    int *dbl_sizep)        /* output - number of data values stored in dbl_arr */
{
    double data;
    int i, status;
    
    /* Sentinel input loop */
    i = 0;
    status = scanf("%lf", &data);
    while (status == 1 && data != sentinel && i < dbl_max) {
        dbl_arr[i] = data;
        ++i;
        status = scanf("%lf", &data);
    }
    
    /* Issues error message on premature exit */
    if (status != 1) {
        printf("\n*** Error in data format ***\n");
        printf("*** Using first %d data values ***\n", i);
    } else if (data != sentinel) {
        printf("\n*** Error: too much data before sentinel ***\n");
        printf("*** Using first %d data values ***\n", i);
    }
    
    /* Sends back size of used portion of array */
    *dbl_sizep = i;
}

/* Driver to test fill_to_sentinel function */
#define A_SIZE 20
#define SENT -1.0

int main(void)
{
    double arr[A_SIZE];
    int in_use;  /* number of elements of arr in use */
    int i;
    
    fill_to_sentinel(A_SIZE, SENT, arr, &in_use);
    
    printf("List of data values\n");
    for (i = 0; i < in_use; ++i)
        printf("%13.3f\n", arr[i]);
    
    return (0);
}
```
## Stacks
> [!info]
> A stack is a data structure in which only the top element can be accessed.

> [!note] Illustration
> The plates stored in the spring-loaded device in a buffet line perform like a stack. A customer always takes the top plate; when a plate is removed, the plate beneath it moves to the top.
> ![[Pasted image 20251106134551.png]]
> The letter 'C', the character at the top of the stack, is the only one we can access. 
> We must remove C from the stack in order to access the symbol '+'. Removing a value from a stack is called *popping* the stack, and storing an item in a stack is called *pushing* it onto the stack.

> [!example] Functions push and pop
```C
// Define a constant to represent an empty stack
#define STACK_EMPTY '\0'

/*
 * Pushes a character onto a stack.
 * stack: The character array representing the stack.
 * item: The character to push onto the stack.
 * top: Pointer to the index of the top element of the stack.
 * max_size: The maximum capacity of the stack.
 */
void push(char stack[], char item, int *top, int max_size) {
    if (*top < max_size - 1) {
        ++(*top);
        stack[*top] = item;
    }
}

/*
 * Pops a character from a stack.
 * stack: The character array representing the stack.
 * top: Pointer to the index of the top element of the stack.
 * Returns the character popped from the stack, or STACK_EMPTY if the stack is empty.
 */
char pop(char stack[], int *top) {
    char item; // Value to be popped

    if (*top >= 0) {
        item = stack[*top];
        --(*top);
    } else {
        item = STACK_EMPTY;
    }

    return item;
}
```

# 7.6 Searching and Sorting an Array
> [!summary] Searching & Sorting
> This section discusses two common problems in processing arrays: searching an array to determine the location of a particular value and sorting an array to rearrange the array elements in numerical order.
## Array Search
In order to search an array, we need to know the *array element value* we are seeking, or the search *target*.
We can perform the search by examining in turn each array element using a loop and by testing whether the element matches the target.
	The search loop should be exited when the target value is found; this process is called a *linear search*.

### Linear search algorithm
The following algorithm for linear search sets a flag (for loop control) when the element being tested matches the target.
1. Assume the target has not been found.
2. Start with the initial array element.
3. Repeat while the target is not found and there are more array elements.
	1. If the current element matches the target
		1.  Set a flag to indicate that the target has been found.
		else
		2. Advance to the next array element.
4. If the target was found.
	1. Return the target index as the search result
	else
	2. Return −1 as the search result.
> [!example] Function That Searches for a Target Value in an Array
```C
#define NOT_FOUND -1 /* Value returned if target is not found */

/*
 * Searches for a target item in the first n elements of array arr.
 * Returns the index of the target or NOT_FOUND.
 * Pre: target and the first n elements of array arr are defined and n >= 0.
 */
int search(const int arr[], int target, int n) {
    int i, found = 0;
    int where; /* Index where target was found */

    /* Compares each element to the target */
    for (i = 0; !found && i < n; ++i) {
        if (arr[i] == target) {
            found = 1;
        }
    }

    /* Returns index of element matching target or NOT_FOUND */
    if (found) {
        where = i - 1; // i is incremented after finding the target
    } else {
        where = NOT_FOUND;
    }

    return where;
}

- - - 
  
#define NOT_FOUND -1 /* Value returned if target is not found */

/*
 * Searches for a target value in the first n elements of an integer array.
 * Returns the index of the target if found; otherwise returns NOT_FOUND.
 * Pre: The first n elements of arr are defined, and n is >= 0.
 */
int search(const int arr[], int target, int n) {
    for (int i = 0; i < n; i++) {
        if (arr[i] == target) {
            return i; // Target found, return its index immediately
        }
    }
    return NOT_FOUND; // Target not found after checking all elements
}
```
## Sorting an Array
Many programs execute more efficiently if the data they process are sorted *before* processing begins.
Other programs produce more understandable output if the information is sorted before it is displayed.

The *selection sort* is a fairly intuitive (but not very efficient) sorting algorithm.
To perform a selection sort of an array with *n* elements (subscripts 0 through n-1), we locate the smallest element in the array and then switch the smallest element with the element at subscript *0*, thereby placing the smallest element in the first position.
Then we locate the smallest element remaining in the subarray with subscripts *1* through *n-1* and switch it with the element at subscript *1*, thereby placing the second smallest element in the second position, and so on.
### Selection Sort algorithm
1. For each value of ``fill`` from *0* to *n-2*
	1. Find ``index_of_min``, the index of the smallest element in the unsorted subarray ``list[fill]`` through ``list[n-1]``.
	2. If *fill* is not the position of the smallest element (``index_of_min``)
		1. Exchange the smallest element with the one at position *fill*.
> [!example] Trace of Sort Selection
> ![[Pasted image 20251106140022.png]]
> The first array shown is the original array. Then we show each step as the next smallest element is moved to its correct position.

> [!example] Function select_sort
```C
#include <stdio.h>

/*
 * Finds the position of the smallest element in the subarray
 * list[first] through list[last].
 * Pre: first <= last and elements 0 through last of array list are defined.
 * Post: Returns the subscript k of the smallest element in the subarray;
 *       i.e., list[k] <= list[i] for all i in the subarray.
 */
int get_min_range(int list[], int first, int last);

/*
 * Sorts the data in array list in ascending order using selection sort.
 * Pre: The first n elements of list are defined and n >= 0.
 */
void select_sort(int list[], int n);

int main(void) {
    int i;
    int my_list[] = {80, 60, 70, 50, 90};
    int size = 5;

    printf("Original array:\n");
    for (i = 0; i < size; ++i) {
        printf("%d ", my_list[i]);
    }
    printf("\n\n");

    select_sort(my_list, size);

    printf("Sorted array:\n");
    for (i = 0; i < size; ++i) {
        printf("%d ", my_list[i]);
    }
    printf("\n");

    return 0;
}

/*
 * Finds the position of the smallest element in the subarray
 * list[first] through list[last].
 * Pre: first <= last and elements 0 through last of array list are defined.
 * Post: Returns the subscript k of the smallest element in the subarray;
 *       i.e., list[k] <= list[i] for all i in the subarray.
 */
int get_min_range(int list[], int first, int last) {
    int i, index_of_min = first;

    // Assume the first element is the smallest, then check the rest
    for (i = first + 1; i <= last; ++i) {
        if (list[i] < list[index_of_min]) {
            index_of_min = i;
        }
    }
    return index_of_min;
}

/*
 * Sorts the data in array list in ascending order using selection sort.
 * Pre: The first n elements of list are defined and n >= 0.
 */
void select_sort(int list[], int n) {
    int fill;           // Index of first element in unsorted subarray
    int temp;            // Temporary storage for swapping
    int index_of_min;     // Subscript of next smallest element

    for (fill = 0; fill < n - 1; ++fill) {
        // Find position of smallest element in unsorted subarray
        index_of_min = get_min_range(list, fill, n - 1);

        // Exchange elements at fill and index_of_min if needed
        if (fill != index_of_min) {
            temp = list[index_of_min];
            list[index_of_min] = list[fill];
            list[fill] = temp;
        }
    }
}
```
# 7.7 Parallel Arrays and Enumerated Types
## Intro
> [!abstract] Parallel Arrays 
> Two or more arrays with the same number of elements used for storing related information about a collection of data objects.

If there're *n* elements, the arrays contain data for *n* objects of the same kind.
All array-elements at subscript *i* contain data for the *i*-th object in the group of *n* objects.

> [!info] Advantages of Parallel Arrays
> - Simple to implement
> - Memory efficient when storing different data types
> - Easy to perform operations on entire columns of data

> [!warning] Disadvantages of Parallel Arrays
> - Easy to get arrays out of sync during sorting or modifications
> - Less intuitive than using structs
> - Harder to pass all related data to functions

| Feature           | Parallel Arrays                        | Structs                         | Enums           |
| ----------------- | -------------------------------------- | ------------------------------- | --------------- |
| Memory Efficiency | High                                   | Medium                          | High            |
| Type Safety       | Low                                    | High                            | Medium          |
| Readability       | Medium                                 | High                            | High            |
| Best Use Case     | Different data types for same entities | Related data of different types | Named constants |

> [!example]
> 
```C
#define NUM_STUDENTS 50
int id[NUM_STUDENTS];
double gpa[NUM_STUDENTS];
```
The arrays ``id`` and ``gpa`` each have 50 elements. Each element of array ``id`` can be used to store an integer value, each element of array ``gpa`` can be used to store a float of type double.
![[Pasted image 20251102155909.png]]

> [!tip] Sorting Parallel Arrays
> When sorting parallel arrays, you must apply the same operations to all arrays to maintain correspondence:
> ```c
> // When sorting by GPA, you must swap both the GPA and the corresponding ID
> for (i = 0; i < n-1; i++) {
>     for (j = 0; j < n-i-1; j++) {
>         if (gpa[j] < gpa[j+1]) {
>             // Swap GPAs
>             temp_gpa = gpa[j];
>             gpa[j] = gpa[j+1];
>             gpa[j+1] = temp_gpa;
>             
>             // Swap corresponding IDs
>             temp_id = id[j];
>             id[j] = id[j+1];
>             id[j+1] = temp_id;
>         }
>     }
> }
> ```
## Enumerated Types
> [!abstract] Enumerated Type
> A data type whose list of values is specified by the programmer in a type declaration.

Sometimes "good solutions" to many problems require new data types.
	In a budgeting program, you might distinguish among different expenses: entertainment, Rent, Utilities, Food, Clothes, Car, Insurance, Misc.
	ANSI C allows you to associate a numeric code with each category by creating an ***enumerated type*** that has its own list of meaningful values.
```C
typedef enum{
	Entertainment, Rent, Utilites, Food, Clothing, 
	Car, Insurance, Misc
}
expense_t;

- - - 

typedef enum{
    Entertainment = 100, Rent = 200, Utilities = 
    300, Food = 400, Clothing = 500, Car = 600, 
    Insurance = 700, Misc = 800
} expense_t;
```

The new type `expense_t` is used similarly to a standard type.
```C
// Declarationn of variable "expense_kind" of the custom data type "expense_t"
expense_t expense_kind;
// Same declaration but with standard types
// Notice the highlighting is the same
int expense_kind;
double expense_kind;
```

>[!info]- How Enums Work 
>Defining `expense_t` causes the ***enumeration constant*** to be represented as an integer.
>By default, the first enum value (Entertainment) gets value *0*, the next (Rent) gets *1*, and so on. 
>(You can also assign specific values.)

The variable `expense_kind` and the eight enumeration constants, can be manipulated like any other integers.
	***Enumeration constants*** must be *identifiers*; they cannot be **numeric**, **character**, or **string** literals 
		(e.g., "``entertainment``" cannot be a value for an enumerated type).
The reserved word ``typedef`` can be used to name many varieties of user-defined types.
![[Pasted image 20251102172127.png]]
![[Pasted image 20251102172137.png]]

- - -
### Example - Fig 7.18

> [!example]
> Creating a custom data type, and printing the corresponding representation, based on the "code" (enumeration constant)
> 
> Fig. 7.18
```C
// Defined Data Type(s)
typedef enum
    {entertainment, rent, utilities, food, clothing,
    automobile, insurance, misc}
expense_t;

int main(void){
    expense_t expense_kind;

    printf("Enter expense code [0 - 7]\n [0] Entertainment\n [1] Rent\n [2] Utilities\n [3] Food\n [4] Clothing\n [5] Automobile\n [6] Insurance\n [7] Misc\n");
    scanf("%d", &expense_kind);
    // printf("%d", &expense_kind);
    printf("Expense code representing: ");
    print_expense(expense_kind);
    printf(".\n");

    return 0;
}
```
### Example - Enums + Switch
> [!example] 
> Using Enums with Switch Statements
```c
 void print_expense(expense_t expense) {
     switch(expense) {
         case entertainment:
             printf("Entertainment");
             break;
         case rent:
             printf("Rent");
             break;
         // ... other cases
         default:
             printf("Unknown expense type");
     }
 }
 ```

- - -

> [!warning] Notice
> An identifier cannot appear in more than one enumerated type definition

```C
typedef enum{
monday, tuesday, wednesday, thursday, friday
}
weekday_t;
```
could not be used with the type ``day_t``.

Relational, assignment, and even arithmetic operators can be used with enumerated types, just as with other integers.
```C
sunday < monday
wednesday != friday
tuesday >= sunday
```

- - -
### Example - Enum Constants
> [!example]
> If ``today`` and ``tomorrow`` are type ``day_t`` variables, the following *if* statement assigns the value of`` tomorrow`` based on the value of ``today``:
```C
if (today == sunday)
	tomorrow = monday;
else
	tomorrow = (day_t)(today + 1);
```
Because the days of a week are cyclical, ``tomorrow`` should be set to ``monday`` when ``today`` is ``sunday``. 
The last value (saturday) in type ``day_t`` is treated separately, because adding 1 to its integer representation yields a result not associated with a valid ``day_t`` value.

- - -
## Array with Enumerated Type Subscript

- - -
### Example
> [!example]
```C
#define NUM_QUEST 10 //nr of question on daily quiz
#define NUM_CLASS_DAYS 5 //nr of days in a week of class

typedef enum{
	monday, tuesday, wednesday, thursday, friday
}
weekday_t;

- - -

char answer[NUM_QUEST]; //correct answers for 1 quiz
int score[NUM_CLASS_DAYS]; //1 student's score / day
```
Array ``answer`` is declared with ten elements; each element can store a single character. 
We can use this array to store the ten answers for a true–false quiz; answer0 is T, answer1 is F, etc.
Array ``score`` has five elements corresponding to the five class days listed in the`` weekday_t`` type declaration. Since the enumeration constants ``monday`` through ``friday`` are represented by the integers *0* through *4*, we can use them as *subscripts* on array ``score``.

```C
score[monday] = 9; 
score[tuesday] = 7; 
score[wednesday] = 5; 
score[thursday] = 3; 
score[friday] = 1;
```
Assuming that ``today`` is type ``weekday_t`` and ``ascore`` is type ``int``, the following statements have the same effect.
![[Pasted image 20251102190253.png]]
```C
ascore = 9;
for (today = monday; today <= firday, ++today){
	score[today] = ascore;
	ascore -= 2;
}
```
## Best Practices
> [!danger] Common Pitfalls
> - **Parallel Arrays**: Forgetting to update all arrays when adding/removing elements.
> - **Structs**: Unintentionally creating large structures that consume excessive memory.
> - **Enums**: Assuming enum values are limited to what's defined (they're not in C).

> [!summary] Best Practices
> - Use **parallel arrays** when you need to process columns of data independently.
> - Use **structs** when data items naturally belong together.
> - Use **enums** for improved code readability when working with a fixed set of values.
> - Always initialize arrays and structs to avoid undefined behavior.
> - Use meaningful names for enum constants to improve code self-documentation.
# 7.8 Multi-dimensional Arrays
> [!info]
> ***Multidimensional arrays*** are arrays with two or more dimensions.
> We will use *two-dimensional* arrays to represent tables of data, matrices, and other two-dimensional objects. 
> A two-dimensional object that many are familiar with is a ``tic-tac-toe`` board.

The array declaration
```C
char tictac[3][3];
```
allocates storage for a two-dimensional array (``tictac``) with three rows and three columns.
This array has nine elements, each of which must be referenced by specifying an "x-cord" or *row subscript* (0, 1, or 2) and a "y-cord" or *column subscript* (0, 1, or 2).

Like a 1-dimensinal array, each array element in a multidimensional array contains a character value.
![[Pasted image 20251106140738.png]]
> [!warning] Note
> In the declaration of a multidimensional array parameter, only the first dimension, the number of rows, can be omitted. 
> Including both dimensions is also permissible. 
> Because tic-tac-toe boards do not vary in size: 
```C
char tictac[3][3] = char tictac[][3]
```
![[Pasted image 20251106141041.png]]
> [!example] Function to Check Whether Tic-tac-toe Board Is Filled
```C
/*
 * Checks whether a tic-tac-toe board is completely filled.
 * ttt_brd: The 3x3 tic-tac-toe board.
 * Returns 1 if the board is filled, 0 otherwise.
 */
int filled(char ttt_brd[][3]) {
    int r, c;
    int ans = 1; // Assume board is filled until a blank is found

    for (r = 0; r < 3; ++r) {
        for (c = 0; c < 3; ++c) {
            if (ttt_brd[r][c] == ' ') {
                ans = 0; // Found a blank, board is not filled
            }
        }
    }

    return ans;
}

- - -
  
#include <stdbool.h> // For bool, true, false

/*
 * Checks if a 3x3 tic-tac-toe board is completely filled.
 * board: The 3x3 game board.
 * Returns true if the board has no blank spaces, otherwise false.
 */
bool tic_tac_toe_is_full(char board[][3]) {
    for (int r = 0; r < 3; ++r) {
        for (int c = 0; c < 3; ++c) {
            if (board[r][c] == ' ') {
                return false; // Found a blank space, so board is not full
            }
        }
    }
    return true; // No blank spaces found, board is full
}
```
## Initialization of multi-dimensional Arrays
> [!info]
> You can initialize multidimensional arrays in their declarations just like you initialize one-dimensional arrays.

Instead of listing all table values in one list, the values are usually grouped by rows.
>[!example] Declare a tic-tac-toe board and initialize its contents to blanks.
```C
char tictac[3][3] = { {' ', ' ', ' '}, {' ', ' ', ' '},{' ', ' ', ' '}};

- - -
  
char tictac[3][3] = { 
	{' ', ' ', ' '}, // 1st row
	{' ', ' ', ' '}, // 2nd row
	{' ', ' ', ' '} // 3rd row
};
```
## Arrays with Several Dimensions
The array enroll declared here:
```C
int enroll[MAXCRS][5][4];
```
![[Pasted image 20251106141620.png]]
is a three-dimensional array that may be used to store the enrollment data for a college.

We will assume that the college offers $100$ (``MAXCRS``), courses at five different campuses. 
In keeping with C’s practice of starting array subscripts with zero, we will number the freshman year $0$, the sophomore year $1$, and so on.
Thus, ``enroll[1][4][3]`` represents the number of *seniors* taking course $1$ at campus $4$.
	Array ``enroll`` is composed of a total of $2000$ ($100 × 5 × 4$) elements.
> [!warning]
> A potential pitfall exists when you are dealing with multidimensional arrays: 
> Memory space can be used up rapidly if several multidimensional arrays are declared in the same program.

> [!example] Program fragment that follows finds and displays the total number of students in each course

The program fragment that follows finds and displays the total number of students in each course.
```C
/*
 * Finds and displays the total number of students in each course.
 * Pre: MAXCRS is defined. The 3D array 'enroll' is defined and
 *      populated with data in the format [course][campus][class_rank].
 */

// Variable declarations
int course, campus, cls_rank;
int crs_sum; // Sum of students for a single course

// The outermost loop iterates through each course, as we want a total for each one.
for (course = 0; course < MAXCRS; ++course) {
    crs_sum = 0; // Reset sum for the new course
    
    // Inner loops iterate through all campuses and class ranks for the current course
    for (campus = 0; campus < 5; ++campus) {
        for (cls_rank = 0; cls_rank < 4; ++cls_rank) {
            crs_sum += enroll[course][campus][cls_rank];
        }
    }
    
    // Display the total for the current course
    printf("Number of students in course %d is %d\n", course, crs_sum);
}
```
Since we are displaying the number of students in each course, the loop control variable for the outermost indexed loop is the subscript that denotes the course.

The program fragment that follows displays the number of students at each campus. This time the loop control variable for the outermost indexed loop is the subscript that denotes the campus.
```C
/*
 * Finds and displays the total number of students at each campus.
 * Pre: MAXCRS is defined. The 3D array 'enroll' is defined and
 *      populated with data in the format [course][campus][class_rank].
 */

// Variable declarations
int course, campus, cls_rank;
int campus_sum; // Sum of students for a single campus

// The outermost loop iterates through each campus, as we want a total for each one.
for (campus = 0; campus < 5; ++campus) {
    campus_sum = 0; // Reset sum for the new campus
    
    // Inner loops iterate through all courses and class ranks for the current campus
    for (course = 0; course < MAXCRS; ++course) {
        for (cls_rank = 0; cls_rank < 4; ++cls_rank) {
            campus_sum += enroll[course][campus][cls_rank];
        }
    }
    
    // Display the total for the current campus
    printf("Number of students at campus %d is %d\n", campus, campus_sum);
}
```

Combining the two:
```C
#include <stdio.h>

// Define constants for array dimensions to avoid magic numbers
#define MAXCRS 100      // Maximum number of courses
#define NUM_CAMPUSES 5   // Number of campuses
#define NUM_RANKS 4     // Number of class ranks (e.g., Freshman, Sophomore, etc.)

// Declare and initialize the 3D enrollment array with sample data
int enroll[MAXCRS][NUM_CAMPUSES][NUM_RANKS] = {
    // --- Data for Course 0 ---
    { {10, 15, 20, 25},   // Campus 0
      {12, 18, 22, 28},   // Campus 1
      {8,  14, 19, 24},    // Campus 2
      {11, 16, 21, 26},   // Campus 3
      {9,  13, 17, 23} },   // Campus 4

    // --- Data for Course 1 ---
    { {30, 35, 40, 45},   // Campus 0
      {32, 38, 42, 48},   // Campus 1
      {28, 34, 39, 44},   // Campus 2
      {31, 36, 41, 46},   // Campus 3
      {29, 33, 37, 43} },  // Campus 4

    // --- Data for Course 2 ---
    { {5, 7, 9, 11},      // Campus 0
      {6, 8, 10, 12},     // Campus 1
      {4, 6, 8, 10},      // Campus 2
      {5, 7, 9, 11},      // Campus 3
      {3, 5, 7, 9} }       // Campus 4
    // ... and so on for up to MAXCRS courses
};

int main(void) {
    int course, campus, cls_rank;
    int crs_sum, campus_sum;

    // ============================================================
    // SECTION 1: Find and display students in each course
    // ============================================================
    printf("--- Student Totals Per Course ---\n");

    // The outermost loop iterates through each course.
    for (course = 0; course < 3; ++course) { // Using 3 for demo, as we only have data for 3 courses
        crs_sum = 0; // Reset sum for the new course
        
        // Sum students from all campuses and ranks for the current course
        for (campus = 0; campus < NUM_CAMPUSES; ++campus) {
            for (cls_rank = 0; cls_rank < NUM_RANKS; ++cls_rank) {
                crs_sum += enroll[course][campus][cls_rank];
            }
        }
        
        // Display the total for the current course
        printf("Number of students in course %d is %d\n", course, crs_sum);
    }

    printf("\n"); // Add a newline for spacing

    // ============================================================
    // SECTION 2: Find and display students at each campus
    // ============================================================
    printf("--- Student Totals Per Campus ---\n");

    // The outermost loop iterates through each campus.
    for (campus = 0; campus < NUM_CAMPUSES; ++campus) {
        campus_sum = 0; // Reset sum for the new campus
        
        // Sum students from all courses and ranks for the current campus
        for (course = 0; course < 3; ++course) { // Using 3 for demo
            for (cls_rank = 0; cls_rank < NUM_RANKS; ++cls_rank) {
                campus_sum += enroll[course][campus][cls_rank];
            }
        }
        
        // Display the total for the current campus
        printf("Number of students at campus %d is %d\n", campus, campus_sum);
    }

    return 0;
}
```
# 7.9 Array Processing Illustrated
Sometimes we need to manipulate many or all elements of a table in some uniform manner (for example, display them all). 
In such situations, it makes sense to process the table rows or columns in sequence (*sequential access*), starting with the first and ending with the last.

At other times, the order in which the array elements are accessed depends either on the order of the problem data or the nature of the formula that is the basis of the processing. In these situations, access to element *i+1* of an array does not necessarily occur right after access to element *i*. Thus, we are not using sequential access, but rather *random access*.
> [!question]
> ***!Check the case study!***
> Initial Algorithm of the case study
> 1. Scan revenue data, posting by unit and quarter, and returning a value to show success or failure of the data scan. 
> 2. If the data scan proceeded without error: 
> 	1. Compute unit totals (row sums). 
> 	2. Compute quarterly totals (column sums). 
> 	3. Display the revenue table along with the row and column sums.
## Coding Function ``main``
We will call functions for steps 1, 3, 4, and 5.
After introducing a program variable ``status`` to record the success or failure of the data scan, we can code function main directly from our initial algorithm pseudocode.
> [!example] Hospital Revenue Summary ``Main`` Function
```C
/*
 * Scans revenue figures for one year and stores them in a table organized
 * by unit and quarter. Displays the table and the annual totals for each
 * unit and the revenue totals for each quarter
 */

#include <stdio.h>

#define REVENUE_FILE "revenue.txt" /* name of revenue data file */
#define NUM_UNITS 5
#define NUM_QUARTERS 4

typedef enum {
    summer, fall, winter, spring
} quarter_t;

typedef enum {
    emerg, medic, oncol, ortho, psych
} unit_t;

/* Function Prototypes */
int scan_table(double revenue[][NUM_QUARTERS], int num_rows);
void sum_rows(double row_sum[], double revenue[][NUM_QUARTERS], int num_rows);
void sum_columns(double col_sum[], double revenue[][NUM_QUARTERS], int num_rows);
void display_table(double revenue[][NUM_QUARTERS], const double unit_totals[],
                   const double quarter_totals[], int num_rows);
/* Insert function prototypes for any helper functions. */

int
main(void)
{
    double revenue[NUM_UNITS][NUM_QUARTERS]; /* table of revenue */
    double unit_totals[NUM_UNITS];           /* row totals */
    double quarter_totals[NUM_QUARTERS];     /* column totals */
    int status;

    status = scan_table(revenue, NUM_UNITS);
    if (status == 1) {
        sum_rows(unit_totals, revenue, NUM_UNITS);
        sum_columns(quarter_totals, revenue, NUM_UNITS);
        display_table(revenue, unit_totals, quarter_totals,
                      NUM_UNITS);
    }

    return (0);
}
```
## Coding Function ``scan_table``
Function ``scan_table`` scans in the data from the file ``revenue.txt`` one line at a time until end of file or an error is encountered.
The unit and quarter values are input as ``int`` data, since types ``unit_t`` and ``quarter_t`` are strictly for the internal use of the program.
Within the loop body, ``scan_table`` checks the range of both the *unit* and the *quarter* of the current transaction. 
If the data are valid, the statement ``revenue[trans_unit][quarter] += trans_revenue;`` adds the current revenue amount to the total being accumulated for the unit indicated by ``trans_unit`` (row subscript) and ``quarter`` (column subscript).
Before beginning the data scan, the function must initialize all the elements of the revenue array to zero. This is the purpose of the call to ``initialize``.
> [!example] Function ``scan_table`` and Helper Function ``Initialize``
```C
/*
 * Scans the revenue data from REVENUE_FILE and computes and stores the
 * revenue results in the revenue table. Flags out-of-range data and data
 * format errors.
 * Post: Each entry of revenue represents the revenue total for a
 * particular unit and quarter.
 * Returns 1 for successful table scan, 0 for error in scan.
 * Calls: initialize to initialize table to all zeros
 */
int
scan_table(double revenue[][NUM_QUARTERS], /* output */
           int num_rows)                   /* input */
{
    double trans_amt;    /* transaction amount */
    int trans_unit;      /* unit number */
    int quarter;         /* revenue quarter */
    FILE *revenue_filep; /* file pointer to revenue file */
    int valid_table = 1; /* data valid so far */
    int status;          /* input status */
    char ch;             /* one character in bad line */

    /* Initialize table to all zeros */
    initialize(revenue, num_rows, 0.0);

    /* Scan and store the valid revenue data */
    revenue_filep = fopen(REVENUE_FILE, "r");
    for (status = fscanf(revenue_filep, "%d%d%lf", &trans_unit,
                         &quarter, &trans_amt);
         status == 3 && valid_table;
         status = fscanf(revenue_filep, "%d%d%lf", &trans_unit,
                         &quarter, &trans_amt)) {
        if (summer <= quarter && quarter <= spring &&
            trans_unit >= 0 && trans_unit < num_rows) {
            revenue[trans_unit][quarter] += trans_amt;
        } else {
            printf("Invalid unit or quarter -- \n");
            printf(" unit is ");
            display_unit(trans_unit);
            printf(", quarter is ");
            display_quarter(quarter);
            printf("\n\n");
            valid_table = 0;
        }
    }

    if (!valid_table) { /* error already processed */
        status = 0;
    } else if (status == EOF) { /* end of data without error */
        status = 1;
    } else { /* data format error */
        printf("Error in revenue data format. Revise data.\n");
        printf("ERROR HERE >>> ");
        for (status = fscanf(revenue_filep, "%c", &ch);
             status == 1 && ch != '\n';
             status = fscanf(revenue_filep, "%c", &ch))
            printf("%c", ch);
        printf(" <<<\n");
        status = 0;
    }
    return (status);
}

/*
 * Stores value in all elements of revenue.
 * Pre: value is defined and num_rows is the number of rows in
 * revenue.
 * Post: All elements of revenue have the desired value.
 */
void
initialize(double revenue[][NUM_QUARTERS], /* output */
           int num_rows,                   /* input */
           double value)                   /* input */
{
    int row;
    quarter_t quarter;

    for (row = 0; row < num_rows; ++row)
        for (quarter = summer; quarter <= spring; ++quarter)
            revenue[row][quarter] = value;
}
```
## Coding Functions ``sum_rows`` and ``sum_columns``
The design and implementation of functions sum_rows and sum_columns are left as exercieses.
## Coding Function ``display_table``
You should display the information in a two-dimensional array in the same way that humans visualize it: as a table whose rows correspond to the array’s first dimension and whose columns correspond to the array’s second dimension. To accomplish this, access and display the array elements row by row.

Function ``display_table`` displays the data in the ***revenue*** table.
Since the display represents thousands of dollars, the values must be divided by 1000 and rounded, this is the purpose of helper function ``whole_thousands``.
> [!example] Function ``display_table`` and Helper Functions ``display_quarter`` and ``whole_thousands``
```C
/*
 * Displays the revenue table data (rounded to whole thousands) in table
 * form along with the row and column sums (also rounded).
 * Pre: revenue, unit_totals, quarter_totals, and num_rows are defined.
 * Post: Values stored in the three arrays are displayed rounded to
 * whole thousands.
 */
void
display_table(double revenue[][NUM_QUARTERS], /* input */
              const double unit_totals[],      /* input */
              const double quarter_totals[],   /* input */
              int num_rows)                    /* input */
{
    unit_t unit;
    quarter_t quarter;

    /* Display heading */
    printf("%34cREVENUE SUMMARY\n%34c---------------\n\n", ' ', ' ');
    printf("%4s%11c", "Unit", ' ');
    for (quarter = summer; quarter <= spring; ++quarter) {
        display_quarter(quarter);
        printf("%8c", ' ');
    }
    printf("TOTAL*\n");
    printf("----------------------------------------");
    printf("----------------------------------------\n");

    /* Display table */
    for (unit = emerg; unit <= psych; ++unit) {
        display_unit(unit);
        printf(" ");
        for (quarter = summer; quarter <= spring; ++quarter)
            printf("%14.2f", revenue[unit][quarter]);
        printf("%13d\n", whole_thousands(unit_totals[unit]));
    }
    printf("----------------------------------------");
    printf("----------------------------------------\n");
    printf("TOTALS*");
    for (quarter = summer; quarter <= spring; ++quarter)
        printf("%14d", whole_thousands(quarter_totals[quarter]));
    printf("\n\n*in thousands of dollars\n");
}

/*
 * Display an enumeration constant of type quarter_t
 */
void
display_quarter(quarter_t quarter)
{
    switch (quarter) {
    case summer:
        printf("Summer");
        break;

    case fall:
        printf("Fall ");
        break;

    case winter:
        printf("Winter");
        break;

    case spring:
        printf("Spring");
        break;

    default:
        printf("Invalid quarter %d", quarter);
    }
}

/*
 * Return how many thousands are in number
 */
int
whole_thousands(double number)
{
    return (int)((number + 500) / 1000.0);
}
```
# 7.10 Graphics Programs with Arrays (Optional)

# 7.11 Common Programming Errors
> [!bug] The most common error in using arrays is a subscript-range error.
> An out-of-range reference occurs when the subscript value used is outside the range specified by the array declaration.
> 
> For the array celsius
> ```C
> int celxius[100];
> ```
> A *subscript-range error* occurs when ``celsius`` is used with a subscript that has a value less than $0$ or greater than $99$ ($100 - 1$).
> In many situations, however, no run-time error message will be produced—the program will simply produce incorrect results.

> [!summary] Prevention of subscript-range error
> In ANSI C, the prevention of subscript-range errors is entirely the responsibility of the programmer. Subscript-range errors are not syntax errors; consequently, they will not be detected until program execution, and often not even then. They are most often caused by an incorrect subscript expression, a loop counter error, or a nonterminating loop.
> 
> Before spending considerable time in debugging, you should check all suspect subscript calculations carefully for out-of-range errors. View the successive values of a subscripting variable in a debugger program, or insert diagnostic output statements that print subscript values that are of concern.

> [!failure] If a subscript-range error occurs inside an indexed loop
> Verify that the subscript is in range for both the initial and the final values of the loop control variable. If these values are in range, it is likely that all other subscript references in the loop are in range as well.

> [!failure] If a subscript-range error occurs in a loop controlled by a variable other than the array subscript
> check that the loop control variable is being updated as required. If it is not, the loop may be repeated more often than expected, causing the subscript-range error. This error could happen if the control variable update step was inside a condition or was inadvertently omitted.

> [!failure] Incorrect Address-of Operator Usage 
> When passing array elements to functions like `scanf`, remember that the element itself must be passed by address if it is to be changed.
> ```C
> int arr[5];
// CORRECT: Passes the address of the element arr[2]
scanf("%d", &arr[2]); 
> 
// INCORRECT: Passes the value of arr[2], leading to a crash
scanf("%d", arr[2]); 
> ```
> When passing an entire array to a function, do **not** use the `&` operator, as the array name already represents an address.

>[!failure] Confusing Array Parameter Declarations 
>Remember that `int *arr` and `int arr[]` are equivalent as function parameters. To improve code clarity and indicate that an array (not just a single integer) is expected, prefer the `int arr[]` syntax.

When using arrays as arguments to functions, be careful not to apply the *address-of* operator to the array name even if the array is an output argument.
	Do remember to use the ``&`` on an array ***element*** that is being passed as an output argument.
Be sure to use the correct forms for declaring array input and output parameters in function prototypes.
	Remember when reading C code that a pointer parameter declared as ``int *z ``could represent a *single integer* output parameter or an *integer array* parameter.
Comment your own prototypes carefully and use the alternate declaration form ``int z[]`` for array parameters to assist readers of your code.

