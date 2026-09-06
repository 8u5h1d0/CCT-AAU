---
tags:
  - C
  - IMPR
  - CCT1
Topic: "Structure and\r Union Types"
Semester: CCT1
Course: IMPR1
Module: K10
Course Date: 19-11-25
Litterature:
  - Problem Solving and Program Design in C, Global Edition, 8th ed.
Created: 17-11-25
---
- - -
## Table of Contents
- [[#Structures in C Programming|Structures in C Programming]]
	- [[#Structures in C Programming#Comparison: Structures vs. Arrays|Comparison: Structures vs. Arrays]]
	- [[#Structures in C Programming#Introduction|Introduction]]
	- [[#Structures in C Programming#10.1 User-Defined Structure Types|10.1 User-Defined Structure Types]]
		- [[#10.1 User-Defined Structure Types#Structure Type Definition|Structure Type Definition]]
		- [[#10.1 User-Defined Structure Types#Manipulating Individual Components of a Structured Data Object|Manipulating Individual Components of a Structured Data Object]]
		- [[#10.1 User-Defined Structure Types#Review of Operator Precedence|Review of Operator Precedence]]
		- [[#10.1 User-Defined Structure Types#Manipulating Whole Structures|Manipulating Whole Structures]]
		- [[#10.1 User-Defined Structure Types#Program Style - Naming Convention for Types|Program Style - Naming Convention for Types]]
	- [[#Structures in C Programming#Memory Layout and Address Visualization|Memory Layout and Address Visualization]]
	- [[#Structures in C Programming#10.2 Structure Type Data as Input and Output Parameters|10.2 Structure Type Data as Input and Output Parameters]]
	- [[#Structures in C Programming#10.3 Functions Whose Result Values Are Structured|10.3 Functions Whose Result Values Are Structured]]
	- [[#Structures in C Programming#10.4 Problem Solving with Structure Types|10.4 Problem Solving with Structure Types]]
	- [[#Structures in C Programming#10.5 Parallel Arrays and Arrays of Structures|10.5 Parallel Arrays and Arrays of Structures]]
		- [[#10.5 Parallel Arrays and Arrays of Structures#Parallel Arrays|Parallel Arrays]]
		- [[#10.5 Parallel Arrays and Arrays of Structures#Declaring an Array of Structures|Declaring an Array of Structures]]
	- [[#Structures in C Programming#10.6 Union Types (Optional)|10.6 Union Types (Optional)]]
	- [[#Structures in C Programming#10.7 Common Programming Errors|10.7 Common Programming Errors]]
	- [[#Structures in C Programming#Additional Worked Examples|Additional Worked Examples]]
# Structures in C Programming

|Concept/Syntax|Description|
|---|---|
|`typedef struct { ... } type_t;`|Defines a new structure type with an alias|
|`struct_var.component`|Direct component selection operator|
|`struct_ptr->component`|Indirect component selection operator|
|`struct1 = struct2`|Structure assignment (member-wise copy)|
## Comparison: Structures vs. Arrays
| Feature                   | Arrays                                              | Structures                                                            |
| ------------------------- | --------------------------------------------------- | --------------------------------------------------------------------- |
| **Element Type**          | All elements must be of the same type               | Can contain elements of different types                               |
| **Memory Layout**         | Contiguous block of memory of same-size elements    | Contiguous block, but elements may have different sizes               |
| **Access**                | Using index: `array[i]`                             | Using component name: `struct_var.component`                          |
| **Passing to Functions**  | Always passed as a pointer (address)                | Can be passed by value (copy) or by reference (pointer)               |
| **Return from Functions** | Cannot return an entire array                       | Can return the entire structure                                       |
| **Equality Comparison**   | Cannot compare entire arrays with `==`              | Cannot compare entire structures with `==`                            |
| **Assignment**            | Cannot assign entire arrays with `=`                | Can assign entire structures with `=`                                 |
| **Use Case**              | Collection of similar items (e.g., list of numbers) | Representation of an object with multiple attributes (e.g., a person) |
_Table 5.1: Comparison between arrays and structures in C._
## Introduction

> [!abstract] **Structures in C**
> 
> Structures in C allow us to create custom data types that group together variables of different data types under a single name. Unlike arrays, which require all elements to be of the same type, structures can contain components of various types, making them ideal for representing real-world objects with multiple attributes.

---

## 10.1 User-Defined Structure Types
> [!info] **Database Concept**
> 
> A _database_ is a collection of information stored in a computer's memory or in a disk file. In C, structures provide a way to organize this information into records that represent specific data objects.
### Structure Type Definition
> [!warning] **Requirement**
> 
> Before a structured data object can be created or saved, the format of its components must be defined.

> [!info] **Structure Definition Syntax**
> 
> A structure type is defined using the `typedef struct` statement, which creates a template for organizing related data items:
> ```C
> typedef struct {
>   type1 id_list1;
>   type2 id_list2;
>   /* ... */
>   type_n id_list_n;
>} struct_type;
> ```

>[!example] **Complex Number Structure**
>```C
>typedef struct { /* complex number structure */
>   double real_pt,
>          imag_pt;
>} complex_t;
>```

>[!example] **Planet Structure Type**
>
>Let's look at a practical example for a database of planets in our solar system:
>
>We must specify the name of each component and the type of information stored in each component. We choose the names in the same way we choose all other identifiers: The names describe the nature of the information represented. The contents of each component determine the appropriate data type.
>
>This structure type `planet_t` has five components of different types:
>- `name`: an array of characters
>- `diameter`: a double value
>- `moons`: an integer value
>- `orbit_time`: a double value
>- `rotation_time`: a double value
>```C
>#define STRSIZ 10
>
>typedef struct {
>   char name[STRSIZ];          // planet's name
>   double diameter;            // equatorial diameter in km
>   int moons;                  // number of moons
>   double orbit_time,          // years to orbit sun once
>          rotation_time;       // hours to complete one revolution on axis
>} planet_t;
>```
>The `typedef` statement itself allocates no memory. A variable declaration is required to allocate storage space for a structured data object.
>```C
>planet_t current_planet,
>        previous_planet,
>        blank_planet = {"", 0, 0, 0, 0};
>```
> The variables `current_planet`, `previous_planet`, and `blank_planet` all have the format specified in the definition of type `planet_t`. The variable `blank_planet` is initialized with empty or zero values.
> ![[Pasted image 20251117161601.png]] 
> _Figure 1.1: The variable `blank_planet` is pictured as it appears after initialization, showing the structure with its components: name (empty string), diameter (0.0), moons (0), orbit_time (0.0), and rotation_time (0.0). Each component is shown as a separate block with its initial value._

>[!info] **Hierarchical Structures**
>
>A structure containing components that are data structures (arrays or structs) is called a _hierarchical structure_:
>```C
>typedef struct {
>   double diameter;
>   planet_t planets[9];
>   char galaxy[STRSIZ];
>} solar_sys_t;
>```
>In this, `solar_sys_t` is a structure that contains:
>- A `diameter` component of type double
>- A `planets` component that is an array of 9 `planet_t` structures
>- A `galaxy` component that is an array of characters
>```mermaid
>graph TD
>    A[solar_sys_t] --> B[diameter: double]
>    A --> C["planets: planet_t[9]"]
>    A --> D["galaxy: char[STRSIZ]"]
>    C --> E[planet_t 0]
>    C --> F[planet_t 1]
>    C --> G[planet_t 2]
>    C --> H[...]
>    E --> I["name: char[STRSIZ]"]
>    E --> J[diameter: double]
>    E --> K[moons: int]
>    E --> L[orbit_time: double]
>    E --> M[rotation_time: double]
>```
>_Figure 1.2: A Mermaid diagram visualizing the hierarchical structure of `solar_sys_t`, which contains an array of `planet_t` structures._
>
>**Interpretation of Syntax**
>- **`struct_type`**: This is the new alias (name) for the structure type you are defining. You will use this name to declare variables of this type.
>- **`id_listi`**: $id\_list_{i}$ is a list of one or more member names, separated by commas. Each name in the list identifies a component of the structure.
>- **`typei`**: $type_i$ specifies the data type for all members in the corresponding `id_listi`.
### Manipulating Individual Components of a Structured Data Object
>[!note] **Component Access**
>
>We can reference a component of a structure by using the direct component selection operator, which is a period (the `dot` operator). The period is preceded by the name of a structure type variable and is followed by the name of a component.

>[!example] **Accessing Structure Components**
>Using the `dot` operator
>```C
>printf("%s's equatorial diameter is %.1f km.\n", current_planet.name, current_planet.diameter);
>```
>![[Pasted image 20251117163555.png]] 
>_Figure 1.3: The `current_planet` variable exists in memory as a contiguous block. We can visualize its structure and the data. The table shows the components, their data types, and stored values._
>
>| Component        | Data Type  | Stored Value |
>| ---------------- | ---------- | ------------ |
>| `.name`          | `char[20]` | `"Jupiter"`  |
>| `.diameter`      | `double`   | `$142800.0$`   |
>| `.moons`         | `int`      | `$16$`         |
>| `.orbit_time`    | `double`   | `$11.9$`       |
>| `.rotation_time` | `double`   | `$9.925$`      |
>_Table 1.1: Visual representation of the `current_planet` variable, a `planet_t` structure, and its components in memory._
>```mermaid
>graph LR
>    A[current_planet] --> B["name: char[STRSIZ]"]
>    A --> C[diameter: double]
>    A --> D[moons: int]
>    A --> E[orbit_time: double]
>    A --> F[rotation_time: double]
>    
>    style A fill:#f9f,stroke:#333,stroke-width:2px
>    style B fill:#bbf,stroke:#333,stroke-width:1px
>    style C fill:#bbf,stroke:#333,stroke-width:1px
>    style D fill:#bbf,stroke:#333,stroke-width:1px
>    style E fill:#bbf,stroke:#333,stroke-width:1px
>    style F fill:#bbf,stroke:#333,stroke-width:1px
>```
>_Figure 1.4: A Mermaid diagram illustrating the memory layout of a single `planet_t` structure, showing it as a contiguous block of different-sized components._
### Review of Operator Precedence

> [!tip] **C Operator Precedence**
> 
> 1. **U**nary
> 2. **M**ultiplication/Division
> 3. **A**ddition/Subtraction
> 4. **R**elational, **E**quality
> 5. **L**ogical AND
> 6. **L**ogical OR
> 7. **C**onditional
> 8. **A**ssignment
>    
>    | Precedence | Symbols                       | Operator Names                                                                                | Associativity |
>| ---------- | ----------------------------- | --------------------------------------------------------------------------------------------- | ------------- |
>| highest    | `a[j]` `f(...)` `.`           | Subscripting, function calls, direct component selection                                      | left          |
>| I          | `++` `--`                     | Postfix increment and decrement                                                               | left          |
>| I          | `++` `--` `!` `-` `+` `&` `*` | Prefix increment and decrement, logical not, unary negation and plus, address of, indirection | right         |
>| I          | `(type name)`                 | Casts                                                                                         | right         |
>| I          | `*` `/` `%`                   | Multiplicative operators (multiplication, division, remainder)                                | left          |
>| I          | `+` `-`                       | Binary additive operators (addition and subtraction)                                          | left          |
>| I          | `<` `>` `<=` `>=`             | Relational operators                                                                          | left          |
>| I          | `==` `!=`                     | Equality / inequality operators                                                               | left          |
>| I          | `&&`                          | Logical and                                                                                   | left          |
>| V          | `\|\|`                        | Logical or                                                                                    | left          |
>| lowest     | `=` `+=` `-=` `*=` `/=` `%=`  | Assignment operators                                                                          | right         |
>_Table 10.1: Precedence and Associativity of Operators Seen So Far_
>
>Associativity determines the order in which operators of the **same precedence** are evaluated.
>- If an operator has **left associativity**, the expression is evaluated from left to right.
>    - For an expression like `operand1 op* operand2 op* operand3`, the implied order is `(operand1 op* operand2) op* operand3`.
>- If an operator has **right associativity**, the expression is evaluated from right to left.
>    - For an expression like `operand1 op* operand2 op* operand3`, the implied order is `operand1 op* (operand2 op* operand3)`.

>[!warning] **Parentheses Override Precedence**
>
>While this table defines the default order of operations, you can and should use parentheses `()` to explicitly define the order of evaluation. This improves readability and prevents bugs, especially in complex expressions.
### Manipulating Whole Structures

> [!info] **Whole Structure Operations**
> 
> When you use the name of a structure variable without the component selection operator(`.` or `->`), you are referring to the entire structure as a single entity. This allows you to manipulate the whole collection of its members at once.

> [!example] **Structure Assignment**
> Given two structure variables of the same type, 
> `current_planet` and `previous_planet`, 
> the following statement creates a complete, independent copy.
> ```C
> // Assuming both variables are of the same planet struct type
previous_planet = current_planet;
> ```
> After this line, `previous_planet` is an exact duplicate of `current_planet`. Changing a member in `current_planet` will **not** affect `previous_planet`.

> [!tip] **Implications of a Whole-Structure Copy**
> 
> This assignment performs a member-wise copy. Each member of the source structure is copied to the corresponding member of the destination structure.

> [!warning] **Caution with Structures Containing Pointers**
> 
> If a structure contains pointers, a simple member-wise copy only copies the address stored in the pointer, not the data it points to. This results in two structures having pointers to the same memory location (shallow copy).
### Program Style - Naming Convention for Types

> [!tip] **Type Naming Convention**
> 
> To help reduce confusion between type names and variable names, it's recommended to choose user-defined type names that use lowercase letters and end in the suffix `_t`.

> [!example] **Type Name Convention**
> ```C
> typedef struct {
>   int hour;
>   int minute;
>   int second;
>} Time;
>
> - - - 
> 
> typedef struct {
>    int hour;
>    int minute;
>    int second;
>} time_t;  // Instead of "Time"
> ```
> Other examples following this convention:
>
>- `student_t` instead of `Student`
>- `database_t` instead of `Database`
>- `graph_node_t` instead of `GraphNode`
## Memory Layout and Address Visualization

> [!info] **Structure Memory Organization**
> 
> Understanding how structures are stored in memory is crucial for working with pointers to structures and for optimizing memory usage. A structure is stored as a contiguous block of memory, with each component placed sequentially.

> [!note] **Memory Alignment**
> 
> Compilers often add padding bytes between structure components to ensure each component is aligned on a memory boundary that's optimal for its data type. This is called memory alignment and can affect the total size of a structure.

> [!example]- **Memory Layout of a planet_t Structure**
> 
> Let's examine how a `planet_t` structure might be laid out in memory:
> ```C
> typedef struct {
>    char name[10];     // 10 bytes
>    double diameter;    // 8 bytes (aligned to 8-byte boundary)
>    int moons;         // 4 bytes
>    double orbit_time;  // 8 bytes (aligned to 8-byte boundary)
>    double rotation_time; // 8 bytes
>} planet_t;
> ```
> Due to alignment requirements, the compiler might add padding:
> ```
> Address    Component          Size    Value
>0x1000     name[0]            1 byte   'J'
>0x1001     name[1]            1 byte   'u'
>...
>0x1008     name[8]            1 byte   'r'
>0x1009     name[9]            1 byte   '\0'
>0x100A-0x100F padding       6 bytes   (for alignment)
>0x1010     diameter           8 bytes   142800.0
>0x1018     moons              4 bytes   16
>0x101C-0x101F padding       4 bytes   (for alignment)
>0x1020     orbit_time         8 bytes   11.9
>0x1028     rotation_time      8 bytes   9.925
> ```
>Total size: 48 bytes (40 bytes for data + 8 bytes for padding)
>```mermaid
>graph TB
>    subgraph "Memory Layout of planet_t"
>        A["0x1000<br/>name[0]<br/>1 byte"] --> B["0x1001<br/>name[1]<br/>1 byte"]
>        B --> C["0x1002<br/>name[2]<br/>1 byte"]
>        C --> D["0x1003<br/>name[3]<br/>1 byte"]
>        D --> E["0x1004<br/>name[4]<br/>1 byte"]
>        E --> F["0x1005<br/>name[5]<br/>1 byte"]
>        F --> G["0x1006<br/>name[6]<br/>1 byte"]
>        G --> H["0x1007<br/>name[7]<br/>1 byte"]
>        H --> I["0x1008<br/>name[8]<br/>1 byte"]
>        I --> J["0x1009<br/>name[9]<br/>1 byte"]
>        J --> K["0x100A-0x100F<br/>padding<br/>6 bytes"]
>        K --> L["0x1010<br/>diameter<br/>8 bytes"]
>        L --> M["0x1018<br/>moons<br/>4 bytes"]
>        M --> N["0x101C-0x101F<br/>padding<br/>4 bytes"]
>        N --> O["0x1020<br/>orbit_time<br/>8 bytes"]
>        O --> P["0x1028<br/>rotation_time<br/>8 bytes"]
>    end
>    
>    style A fill:#f9f,stroke:#333,stroke-width:1px
>    style B fill:#f9f,stroke:#333,stroke-width:1px
>    style C fill:#f9f,stroke:#333,stroke-width:1px
>    style D fill:#f9f,stroke:#333,stroke-width:1px
>    style E fill:#f9f,stroke:#333,stroke-width:1px
>    style F fill:#f9f,stroke:#333,stroke-width:1px
>    style G fill:#f9f,stroke:#333,stroke-width:1px
>    style H fill:#f9f,stroke:#333,stroke-width:1px
>    style I fill:#f9f,stroke:#333,stroke-width:1px
>    style J fill:#f9f,stroke:#333,stroke-width:1px
>    style K fill:#ddd,stroke:#333,stroke-width:1px
>    style L fill:#bbf,stroke:#333,stroke-width:1px
>    style M fill:#bbf,stroke:#333,stroke-width:1px
>    style N fill:#ddd,stroke:#333,stroke-width:1px
>    style O fill:#bbf,stroke:#333,stroke-width:1px
>    style P fill:#bbf,stroke:#333,stroke-width:1px
>```
>_Figure 2.1: Memory layout of a `planet_t` structure showing hexadecimal addresses and component sizes._

>[!example]- **Pointer Operations with Structures**
>
>Understanding memory layout helps with pointer operations:
>```C
>planet_t jupiter = {"Jupiter", 142800.0, 79, 11.86, 9.93};
>planet_t *jupiter_ptr = &jupiter;
>
>printf("Address of jupiter: %p\n", (void*)&jupiter);
>printf("Address of jupiter.name: %p\n", (void*)jupiter_ptr->name);
>printf("Address of jupiter.diameter: %p\n", (void*)&jupiter_ptr->diameter);
>printf("Address of jupiter.moons: %p\n", (void*)&jupiter_ptr->moons);
>
>// Pointer arithmetic with structures
>planet_t planets[3] = {
>    {"Mercury", 4879.4, 0, 0.24, 1407.6},
>    {"Venus", 12103.7, 0, 0.62, 5832.5},
>    {"Earth", 12756.3, 1, 1.0, 23.9}
>};
>
>planet_t *planet_ptr = planets;
>
>// Move to the second planet
>planet_ptr++;  // Advances by sizeof(planet_t) bytes
>
>printf("Second planet: %s\n", planet_ptr->name);
>```
>Output might look like:
>```
>Address of jupiter: 0x7ffd1234abcd0
>Address of jupiter.name: 0x7ffd1234abcd0
>Address of jupiter.diameter: 0x7ffd1234abe0
>Address of jupiter.moons: 0x7ffd1234abe8
>Second planet: Venus
>```

>[!example]- **Sizeof Operator with Structures**
>
>The `sizeof` operator returns the total size of a structure, including any padding bytes:
>```C
>printf("Size of planet_t: %zu bytes\n", sizeof(planet_t));
>
>// Output might be: Size of planet_t: 48 bytes
>```
## 10.2 Structure Type Data as Input and Output Parameters

> [!info] **Passing Structures as Input Arguments**
> 
> When a structured variable is passed as an input argument to a function, all of its component values are copied into the components of the function's corresponding formal parameter.

> [!info] **Passing Structures as Output Arguments**
> 
> When a structured variable is used as an output argument, the `&` (address-of) operator must be applied. This is the same method used for passing output arguments of the standard types.

> [!example] **print_planet Function**
> To display the value of our structure ``current_planet``, we would use the call statement ``print_planet(current_planet);``
> ```C
> /*
>* Displays with labels all components of a planet_t structure
>*/
>void print_planet(planet_t pl) /* input - one planet structure */
>{
>    // Print the planet's name
>    printf("%s\n", pl.name);
>    
>    // Print the planet's equatorial diameter, formatted to 0 decimal places
>    printf(" Equatorial diameter: %.0f km\n", pl.diameter);
>    
>    // Print the number of moons
>    printf(" Number of moons: %d\n", pl.moons);
>    
>    // Print the time to complete one orbit of the sun, formatted to 2 decimal places
>    printf(" Time to complete one orbit of the sun: %.2f years\n", pl.orbit_time);
>    
>    // Print the time to complete one rotation on its axis, formatted to 4 decimal places
>    printf(" Time to complete one rotation on axis: %.4f hours\n", pl.rotation_time);
>}
> ```
> This function takes a `planet_t` structure as input and prints all its components with descriptive labels. The format specifiers in the `printf` statements ensure that the numerical values are displayed with appropriate precision.

>[!example] **planet_equal Function**
>**``planet_equal``** can be used to determine if two `planet_t` structured variables are identical. It takes two `planet_t` variables as input arguments and returns an integer value: `1` if all components of the two structures match, and `0` if they do not.
>```C
>#include <string.h>
>
>/*
>* Determines whether or not the components of planet_1 and planet_2 match
>*/
>int
>planet_equal(planet_t planet_1, /* input - planets to */
>planet_t planet_2) /* compare */
>{
>return (strcmp(planet_1.name, planet_2.name) == 0 &&
>planet_1.diameter == planet_2.diameter &&
>planet_1.moons == planet_2.moons &&
>planet_1.orbit_time == planet_2.orbit_time &&
>planet_1.rotation_time == planet_2.rotation_time);
>}
>```
>This function compares each corresponding component of the two `planet_t` structures. For the string component (`name`), it uses `strcmp`. For the numerical components, it uses the equality operator (`==`). The logical AND (`&&`) ensures that the function only returns `1` (true) if _all_ comparisons are true.
>
>An input function, **``scan_planet``**, can be used to populate a `planet_t` variable from data input. This function behaves similarly to `scanf` in its return values:
>- It returns `1` if its single output argument (a `planet_t` variable) is successfully filled with data.
>- It returns `0` if an error occurs during input.
>- It returns the negative value `EOF` (End Of File) if the end of the input file is encountered.

> [!note] **Required Steps for Accessing Structure Components via Pointers**
> 
> To use `scanf` to store a value in one component of a structure whose address is in a pointer variable:
> 
> 1. Follow the pointer to the structure
> 2. Select the component of interest
> 3. Get the address of the component (unless it's an array) to pass to `scanf`

> [!warning] **Operator Precedence Issue**
> 
> The reference `&*plnp.diameter` would incorrectly attempt component selection before pointer dereferencing due to C's operator precedence rules.

> [!example] **scan_planet Function with Structured Output Argument**
> We are assuming that the assignment statement of scan_planet calling scanf has just finished executing and that it has successfully obtained input values for all components of the output argument structure.
> ```C
> /*
> * Fills a type planet_t structure with input data. Integer returned as
> * function result is success/failure/EOF indicator.
> * 1 => successful input of one planet
> * 0 => error encountered
> * EOF => insufficient data before end of file
> * In case of error or EOF, the value of the type planet_t output argument is
> * undefined.
> */
>int
>scan_planet(planet_t *plnp) /* output - address of planet_t structure to fill */
>{
>    int result;
>
>    result = scanf("%s"   // name (string, no & needed)
>                   "%lf"  // diameter (double)
>                   "%d"   // moons (int)
>                   "%lf"  // orbit_time (double)
>                   "%lf", // rotation_time (double)
>                   (*plnp).name,
>                   &(*plnp).diameter,
>                   &(*plnp).moons,
>                   &(*plnp).orbit_time,
>                   &(*plnp).rotation_time);
>    if (result == 5)
>        result = 1;
>    else if (result != EOF)
>        result = 0;
>
>    return (result);
>}
> ```
>
>![[Pasted image 20251117183714.png]] 
>_Figure 2.2: A flowchart showing the data flow during the execution of `scan_planet(&current_planet)`. The main function passes the address of `current_planet` to `scan_planet`, which then uses scanf to fill the structure's components. The flowchart shows how the `&(*plnp).diameter` expression correctly accesses the address of the diameter component._

> [!info] **Indirect Component Selection Operator**
> 
> C provides the indirect component selection operator `->` (minus sign followed by greater-than symbol) that combines the functions of the indirection (`*`) and component selection (`.`) operators:
> ```C
> (*structp).component  = structp->component
> ``` 

>[!example] **Rewritten scan_planet Function Using -> Operator**
>```C
>result = scanf("%s"   // name (string, no & needed)
>               "%lf"  // diameter (double)
>               "%d"   // moons (int)
>               "%lf"  // orbit_time (double)
>               "%lf", // rotation_time (double)
>               plnp->name,
>               &plnp->diameter,
>               &plnp->moons,
>               &plnp->orbit_time,
>               &plnp->rotation_time);
>```
## 10.3 Functions Whose Result Values Are Structured

> [!info] **Functions Returning Structured Values**
> 
> In C, functions can return structured values much like they return simple data types. This is different from how arrays are handled, where functions typically require an output argument to store the result.

> [!note] **Key Difference Between Arrays and Structures**
> 
> - Arrays: Cannot return an entire array as a function result; must use output arguments
> - Structures: Can return the entire structure as a function result, similar to simple data types

> [!Summary] **Function Returning a Structure** 
> A function that computes a structured result can:
> 
> 1. Allocate a local variable of the structure type
> 2. Fill it with the desired data
> 3. Return the structure as the function result
> 
> The function returns the values of all components, not the address of the structure.

> [!example] **get_planet Function**
> 
 The `get_planet` function obtains input values for all components of a ``planet_t`` structure and returns the structure as the function result:
> ```C
> /*
>* Gets and returns a planet_t structure
>*/
>planet_t
>get_planet(void)
>{
>    planet_t planet;
>
>    scanf("%s%lf%d%lf%lf", planet.name,
>                           &planet.diameter,
>                           &planet.moons,
>                           &planet.orbit_time,
>                           &planet.rotation_time);
>    return (planet);
>}
> ```

>[!note] **Comparing get_planet and scan_planet**
>```C
>current_planet = get_planet();  // Assumes correct data entry format
>```
>has the same effect as:
>```C
>scan_planet(&current_planet);   // Can return error codes
>```

>[!example] **new_time Function**
>In computer simulations, where we need to keep track of the time of day as the experiment progresses. Normally, the time of day is updated after a certain period has elapsed. Assuming a 24-hour clock, the structure type ``time_t`` is
>```C
>typedef struct { int hour, minute, second; } time_t;
>```
>The `new_time` function returns an updated time based on the original time and elapsed seconds
>```C
>/*
> * Computes a new time represented as a time_t structure
> * and based on time of day and elapsed seconds.
> */
>time_t
>new_time(time_t time_of_day, /* input - time to be updated */
>         int elapsed_secs)   /* input - seconds since last update */
>{
>    int new_hr, new_min, new_sec;
>
>    new_sec = time_of_day.second + elapsed_secs;
>    time_of_day.second = new_sec % 60;
>    new_min = time_of_day.minute + new_sec / 60;
>    time_of_day.minute = new_min % 60;
>    new_hr = time_of_day.hour + new_min / 60;
>    time_of_day.hour = new_hr % 24;
>
>    return (time_of_day);
>}
>```
>If `time_now` were 21:58:32 and `secs` had the value 97, the call:
>```C
>new_time(time_now, secs)
>```
> would return 22:00:09.

>[!note] **Updating Variables with Function Results**
>
>Since `new_time`'s variable `time_of_day` is strictly an input parameter, the value of `time_now` will not be affected by the call. To update `time_now`, an assignment statement is used:
>```C
>time_now = new_time(time_now, secs);
>```
## 10.4 Problem Solving with Structure Types

> [!warning] **Note**
> 
> When solving problems using C's standard data types, we take for granted that C provides all the basic operations needed to manipulate our data. However, when working with more complex data objects, defining our own data types is just the first step.

To truly think about a problem on the basis of our own data types, we must also provide basic operations for manipulating these types. Without these operations, we cannot fully utilize our custom data types.
![[Pasted image 20251117190915.png]]

> [!abstract] **Abstract Data Types (ADTs)**
> 
> Combining a user-defined type with a set of basic operations that allow one to truly see the type as a unified concept creates what is called an abstract data type (ADT). This approach enables thinking about problems at a higher level of abstraction.

>[!summary]- **Case Study on Complex Numbers** 
>
>**The Problem** 
>We are working on an engineering project that uses complex numbers for modeling of electrical circuits. We need to develop a user-defined structure type and a set of operations that will make complex arithmetic virtually as straightforward as arithmetic on C's built-in numeric types.
>
>**Analysis** 
>A complex number is a number with a real part and an imaginary part. For example, the complex number $a + bi$ has a real part $a$ and an imaginary part $b$, where the symbol $i$ represents $\sqrt{-1}$. We will need to define functions for complex I/O as well as for the basic arithmetic operations (addition, subtraction, multiplication, and division) and for finding the absolute value of a complex number.
>
>**Design** 
>The two major aspects of our solution are defining the structure of the user-defined type and describing the function name, parameters, and purpose of each operation. Once the specification is complete, coworkers can begin designing algorithms that assume the availability of these operations.
>>[!example] **Specification of Type complex_t and Associated Operations**
>>**STRUCTURE:** A complex number is an object of type `complex_t` that consists of a pair of type `double` values.
>>**OPERATORS:**
>>```C
>>int scan_complex(complex_t *c); /* output - address of complex variable to fill */
>>/* 
>>* Complex output function displays value as a + bi or a - bi. 
>>* Displays only a if imaginary part is 0. 
>>* Displays only bi if real part is 0. 
>>*/
>>void print_complex(complex_t c); /* input - complex number to display */
>>
>>// Returns sum of complex values c1 and c2
>>complex_t add_complex(complex_t c1, complex_t c2); /* input */
>>
>>// Returns difference c1 - c2
>>complex_t subtract_complex(complex_t c1, complex_t c2); /* input */
>>
>>// Returns product of complex values c1 and c2
>>complex_t multiply_complex(complex_t c1, complex_t c2); /* input */
>>
>>// Returns quotient of complex values (c1 / c2)
>>complex_t divide_complex(complex_t c1, complex_t c2); /* input */
>>
>>// Returns absolute value of complex number c
>>complex_t abs_complex(complex_t c); /* input */
>>```
>
>**Implementation**
>```C
>/*
> * Operators to process complex numbers
> */
>#include <stdio.h>
>#include <math.h>
>
>/* User-defined complex number type */
>typedef struct {
>    double real, imag;
>} complex_t;
>
>int scan_complex(complex_t *c);
>void print_complex(complex_t c);
>complex_t add_complex(complex_t c1, complex_t c2);
>complex_t subtract_complex(complex_t c1, complex_t c2);
>complex_t multiply_complex(complex_t c1, complex_t c2);
>complex_t divide_complex(complex_t c1, complex_t c2);
>complex_t abs_complex(complex_t c);
>
>/* Driver */
>int main(void)
>{
>    complex_t com1, com2;
>
>    /* Gets two complex numbers */
>    printf("Enter the real and imaginary parts of a complex number\n");
>    printf("separated by a space> ");
>    scan_complex(&com1);
>    printf("Enter a second complex number> ");
>    scan_complex(&com2);
>
>    /* Forms and displays the sum */
>    printf("\n");
>    print_complex(com1);
>    printf(" + ");
>    print_complex(com2);
>    printf(" = ");
>    print_complex(add_complex(com1, com2));
>
>    /* Forms and displays the difference */
>    printf("\n\n");
>    print_complex(com1);
>    printf(" - ");
>    print_complex(com2);
>    printf(" = ");
>    print_complex(subtract_complex(com1, com2));
>
>    /* Forms and displays the absolute value of the first number */
>    printf("\n\n|");
>    print_complex(com1);
>    printf("| = ");
>    print_complex(abs_complex(com1));
>    printf("\n");
>
>    return (0);
>}
>
>/*
> * Complex number input function returns standard scanning error code
> * 1 => valid scan, 0 => error, negative EOF value => end of file
> */
>int scan_complex(complex_t *c) /* output - address of complex variable to fill */
>{
>    int status;
>
>    status = scanf("%lf%lf", &c->real, &c->imag);
>    if (status == 2)
>        status = 1;
>    else if (status != EOF)
>        status = 0;
>
>    return (status);
>}
>
>/*
> * Complex output function displays value as (a + bi) or (a - bi),
> * dropping a or b if they round to 0 unless both round to 0
> */
>void print_complex(complex_t c) /* input - complex number to display */
>{
>    double a, b;
>    char sign;
>
>    a = c.real;
>    b = c.imag;
>
>    printf("(");
>
>    if (fabs(a) < .005 && fabs(b) < .005) {
>        printf("%.2f", 0.0);
>    } else if (fabs(b) < .005) {
>        printf("%.2f", a);
>    } else if (fabs(a) < .005) {
>        printf("%.2fi", b);
>    } else {
>        if (b < 0)
>            sign = '-';
>        else
>            sign = '+';
>        printf("%.2f %c %.2fi", a, sign, fabs(b));
>    }
>
>    printf(")");
>}
>
>/*
> * Returns sum of complex values c1 and c2
> */
>complex_t add_complex(complex_t c1, complex_t c2) /* input - values to add */
>{
>    complex_t csum;
>
>    csum.real = c1.real + c2.real;
>    csum.imag = c1.imag + c2.imag;
>    return (csum);
>}
>
>/*
> * Returns difference c1 - c2
> */
>complex_t subtract_complex(complex_t c1, complex_t c2) /* input parameters */
>{
>    complex_t cdiff;
>    cdiff.real = c1.real - c2.real;
>    cdiff.imag = c1.imag - c2.imag;
>
>    return (cdiff);
>}
>
>/* ** Stub **
> * Returns product of complex values c1 and c2
> */
>complex_t multiply_complex(complex_t c1, complex_t c2) /* input parameters */
>{
>    printf("Function multiply_complex returning first argument\n");
>    return (c1);
>}
>
>/* ** Stub **
> * Returns quotient of complex values (c1 / c2)
> */
>complex_t divide_complex(complex_t c1, complex_t c2) /* input parameters */
>{
>    printf("Function divide_complex returning first argument\n");
>    return (c1);
>}
>
>/*
> * Returns absolute value of complex number c
> */
>complex_t abs_complex(complex_t c) /* input parameter */
>{
>    complex_t cabs;
>
>    cabs.real = sqrt(c.real * c.real + c.imag * c.imag);
>    cabs.imag = 0;
>
>    return (cabs);
>}
>```
>**Program Output**
>```
>Enter the real and imaginary parts of a complex number
>separated by a space> 3.5 5.2
>Enter a second complex number> 2.5 1.2
>(3.50 + 5.20i) + (2.50 + 1.20i) = (6.00 + 6.40i)
>(3.50 + 5.20i) - (2.50 + 1.20i) = (1.00 + 4.00i)
>|(3.50 + 5.20i)| = (6.27)
>```
>**Formula for Absolute Value**
>> [!note] 
>> The function `abs_complex` uses the following formula to compute the absolute value of a complex number: $|a + bi| = \sqrt{(a + bi)(a - bi)} = \sqrt{a^2 + b^2}$ This result always has an imaginary part of zero, so `print_complex` will display the result as a real number
>
## 10.5 Parallel Arrays and Arrays of Structures

> [!info] **Data Collections**
> 
> Often a data collection contains items of different types or items that represent distinct concepts.

### Parallel Arrays

> [!info] **Parallel Arrays Concept**
> 
> Data collections can be represented using parallel arrays, where data items with the same subscript pertain to the same entity.

> [!example] **Examples of Parallel Arrays**
> ```C
> int id[50];        // id numbers and
>double gpa[50];    // gpa's of up to 50 students
>
>double x[NUM_PTS], // (x,y) coordinates of
>       y[NUM_PTS]; // up to NUM_PTS points
> ```
> Arrays `id` and `gpa` are called parallel arrays because the data items with the same subscript (e.g., `i`) pertain to the same student (the ith student). Similarly, the ith elements of arrays `x` and `y` are the coordinates of one point.
### Declaring an Array of Structures

> [!info] **Array of Structures**
> 
> A more natural and convenient organization of data is to group the information pertaining to one entity in a structure.

> [!example] **Array of Structures Declaration**
> ```C
> #define MAX_STU 50
>#define NUM_PTS 10
>
>typedef struct {
>    int id;
>    double gpa;
>} student_t;
>
>typedef struct {
>    double x, y;
>} point_t;
>
>. . .
>{
>    student_t stulist[MAX_STU];
>    point_t polygon[NUM_PTS];
> ```
> The data for the first student are stored in the structure `stulist[0]`. 
The individual data items are `stulist[0].id` and `stulist[0].gpa`. 
For instance, `stulist[0].gpa` could be 2.71.

>[!example] **Working with Arrays of Structures**
>If a function `scan_student` is available for scanning a `student_t` structure, the following for statement can be used to fill the entire array `stulist` with data:
>```C
>for (i = 0; i < MAX_STU; ++i)
>    scan_student(&stulist[i]);
>```
>This ``for`` statement would display all the id numbers:
>```C
>for (i = 0; i < MAX_STU; ++i)
>    printf("%d\n", stulist[i].id);
>```
>

>[!summary]- **Case Study: Universal Measurement Conversion**
>
>In a day when our computer software spell-checks text and looks up synonyms for words, it seems primitive to use printed tables for hand conversion of feet to meters, liters to quarts, and so on.
>
>**The Problem** 
>We would like a program that takes a measurement in one unit (e.g., 4.5 quarts) and converts it to another unit (e.g., liters). For example, this conversion request: `450 km miles` would result in this program output:
>```C
>Attempting conversion of 450.0000 km to miles . . .
>450.0000km = 279.6247 miles
>```
>The program should produce an error message if a conversion between two units of different classes (e.g., liquid volume to distance) is requested. The program should take a database of conversion information from an input file before accepting conversion problems entered interactively by the user. The user should be able to specify units either by name (e.g., kilograms) or by abbreviation (e.g., kg).
>
>**Analysis** 
>This program’s basic data objects are units of measurement. We need to define a structure type that groups all relevant attributes about one unit. We can then store a database of these structures in an array and look up conversion factors as needed.
>
>To convert a measurement, the user will need to provide the measurement as a number and a string (e.g., 5 kg or 6.5 inches). The user must also enter the name or abbreviation of the desired units.
>
>The attributes of a unit include its name and abbreviation, its class (mass, distance, and so on), and a representation of the unit in terms of the chosen standard unit for its class. If we allow the actual unit name, class names, and standard units to be determined by the contents of the input file, the program will be usable for any class of measurements and for units in any language based on our character set.
>
>**Data Requirements** **Structured Data Type: ``unit_t``**
>```C
>typedef struct {
>    char name[NAME_LEN];      // character string such as "milligrams"
>    char abbrev[ABBREV_LEN];  // shorter character string such as "mg"
>    char class[CLASS_LEN];     // character string "liquid_volume", "distance", or "mass"
>    double standard;           // number of standard units equivalent to this unit
>} unit_t;
>```
>
>**Problem Constants**
>```C
>#define NAME_LEN 30      // storage allocated for a unit name
>#define ABBREV_LEN 15    // storage allocated for a unit abbreviation
>#define CLASS_LEN 20     // storage allocated for a measurement class
>#define MAX_UNITS 20     // maximum number of different units handled
>```
>
>**Problem Inputs**
>```C
>unit_t units[MAX_UNITS];     // array representing unit conversion factors database
>double quantity;             // value to convert
>char old_units[NAME_LEN];    // name or abbreviation of units to be converted
>char new_units[NAME_LEN];    // name or abbreviation of units to convert to
>```
>
>**Design**
>
>**Algorithm:**
>1. Load units of measurement database.
>2. Get value to convert and old and new unit names.
>3. Repeat until data format error encountered.
>4. Search for old units in database.
>5. Search for new units in database.
>6. If conversion is impossible, issue appropriate error message.
>7. Else, compute and display conversion.
>8. Get value to convert and old and new unit names.
>
>The refinement of step 1 follows: 
>1.1 Open database file. 
>1.2 Initialize subscripting variable `i`. 
>1.3 Scan a unit structure from the database file. 
>1.4 Repeat until EOF, data format error, or attempted overflow of units list. 
>	1.4.1 Store unit structure in units array. 
>	1.4.2 Update `i`. 
>	1.4.3 Scan next unit structure from file. 
>1.5 Close database file.
>
>We will develop separate functions for step 1 (`load_units`), 
>for step 1.3 and step 1.4.3 (`fscan_unit`), 
>for the search used in step 4 and step 5, and 
>for the conversion aspect of step 8.
>
>**Implementation**
>```C
>/*
> * Converts measurements given in one unit to any other unit of the same
> * category that is listed in the database file, units.txt.
> * Handles both names and abbreviations of units.
> */
>#include <stdio.h>
>#include <string.h>
>
>#define NAME_LEN 30      // storage allocated for a unit name
>#define ABBREV_LEN 15    // storage allocated for a unit abbreviation
>#define CLASS_LEN 20     // storage allocated for a measurement class
>#define NOT_FOUND -1     // value indicating unit not found
>#define MAX_UNITS 20     // maximum number of different units handled
>
>typedef struct { // unit of measurement type
>    char name[NAME_LEN];     // character string such as "milligrams"
>    char abbrev[ABBREV_LEN]; // shorter character string such as "mg"
>    char class[CLASS_LEN];  // character string such as "pressure", "distance", "mass"
>    double standard;         // number of standard units equivalent to this unit
>} unit_t;
>
>int fscan_unit(FILE *filep, unit_t *unitp);
>void load_units(int unit_max, unit_t units[], int *unit_sizep);
>int search(const unit_t units[], const char *target, int n);
>double convert(double quantity, double old_stand, double new_stand);
>
>int main(void)
>{
>    unit_t units[MAX_UNITS]; // units classes and conversion factors
>    int num_units;           // number of elements of units in use
>    char old_units[NAME_LEN], // units to convert (name or abbrev)
>         new_units[NAME_LEN]; // units to convert to (name or abbrev)
>    int status;               // input status
>    double quantity;          // value to convert
>    int old_index,            // index of units element where old_units found
>        new_index;            // index where new_units found
>
>    // Load units of measurement database
>    load_units(MAX_UNITS, units, &num_units);
>
>    // Convert quantities to desired units until data format error
>    printf("Enter a conversion problem or q to quit.\n");
>    printf("To convert 25 kilometers to miles, you would enter\n");
>    printf("> 25 kilometers miles\n");
>    printf(" or, alternatively,\n");
>    printf("> 25 km mi\n> ");
>
>    for (status = scanf("%lf%s%s", &quantity, old_units, new_units);
>         status == 3;
>         status = scanf("%lf%s%s", &quantity, old_units, new_units)) {
>        printf("Attempting conversion of %.4f %s to %s . . .\n",
>               quantity, old_units, new_units);
>        old_index = search(units, old_units, num_units);
>        new_index = search(units, new_units, num_units);
>        if (old_index == NOT_FOUND)
>            printf("Unit %s not in database\n", old_units);
>        else if (new_index == NOT_FOUND)
>            printf("Unit %s not in database\n", new_units);
>        else if (strcmp(units[old_index].class,
>                       units[new_index].class) != 0)
>            printf("Cannot convert %s (%s) to %s (%s)\n",
>                   old_units, units[old_index].class,
>                   new_units, units[new_index].class);
>        else
>            printf("%.4f%s = %.4f %s\n", quantity, old_units,
>                   convert(quantity, units[old_index].standard,
>                           units[new_index].standard),
>                   new_units);
>        printf("\nEnter a conversion problem or q to quit.\n> ");
>    }
>
>    return (0);
>}
>
>/*
> * Gets data from a file to fill output argument
> * Returns standard error code: 1 => successful input, 0 => error,
> * negative EOF value => end of file
> */
>int fscan_unit(FILE *filep, unit_t *unitp)
>{
>    int status;
>
>    status = fscanf(filep, "%s%s%s%lf", unitp->name,
>                    unitp->abbrev,
>                    unitp->class,
>                    &unitp->standard);
>
>    if (status == 4)
>        status = 1;
>    else if (status != EOF)
>        status = 0;
>
>    return (status);
>}
>
>/*
> * Opens database file units.txt and gets data to place in units until end
> * of file is encountered. Stops input prematurely if there are more than
> * unit_max data values in the file or if invalid data is encountered.
> */
>void load_units(int unit_max, unit_t units[], int *unit_sizep)
>{
>    FILE * inp;
>    unit_t data;
>    int i, status;
>
>    // Gets database of units from file
>    inp = fopen("units.txt", "r");
>    i = 0;
>
>    for (status = fscan_unit(inp, &data);
>         status == 1 && i < unit_max;
>         status = fscan_unit(inp, &data)) {
>        units[i++] = data;
>    }
>    fclose(inp);
>
>    // Issue error message on premature exit
>    if (status == 0) {
>        printf("\n*** Error in data format ***\n");
>        printf("*** Using first %d data values ***\n", i);
>    } else if (status != EOF) {
>        printf("\n*** Error: too much data in file ***\n");
>        printf("*** Using first %d data values ***\n", i);
>    }
>
>    // Send back size of used portion of array
>    *unit_sizep = i;
>}
>
>/*
> * Searches for target key in name and abbrev components of first n
> * elements of array units
> * Returns index of structure containing target or NOT_FOUND
> */
>int search(const unit_t units[], const char *target, int n)
>{
>    int i,
>        found = 0,  // whether or not target has been found
>        where;      // index where target found or NOT_FOUND
>
>    // Compare name and abbrev components of each element to target
>    i = 0;
>    while (!found && i < n) {
>        if (strcmp(units[i].name, target) == 0 ||
>            strcmp(units[i].abbrev, target) == 0)
>            found = 1;
>        else
>            ++i;
>    }
>    // Return index of element containing target or NOT_FOUND
>    if (found)
>        where = i;
>    else
>        where = NOT_FOUND;
>    return (where);
>}
>
>/*
> * Converts one measurement to another given the representation of both
> * in a standard unit. For example, to convert 24 feet to yards given a
> * standard unit of inches: quantity = 24, old_stand = 12 (there are 12
> * inches in a foot), new_stand = 36 (there are 36 inches in a yard),
> * result is 24 * 12 / 36 which equals 8
> */
>double convert(double quantity, double old_stand, double new_stand)
>{
>    return (quantity * old_stand / new_stand);
>}
>```
>
>**Testing**
>In addition to testing the conversion of units of liquid volume, distance, and mass using values whose conversions are easy to verify, we should also select test cases that exercise each of the error message facilities of the program.
>
>**Sample Data File (units.txt)**
>```
>miles mi distance 1609.3
>kilometers km distance 1000
>yards yd distance 0.9144
>meters m distance 1
>quarts qt liquid_volume 0.94635
>liters l liquid_volume 1
>gallons gal liquid_volume 3.7854
>milliliters ml liquid_volume 0.001
>kilograms kg mass 1
>grams g mass 0.001
>slugs slugs mass 0.14594
>pounds lb mass 0.43592
>```
>> [!note] Note 
>> All that is required by the program is that the database consistently use some standard units. It does not prescribe what units these must be.
>
>**Program Output**
>```
>Enter a conversion problem or q to quit.
>To convert 25 kilometers to miles, you would enter
>> 25 kilometers miles
>> or, alternatively,
>> 25 km mi
>> 450 km miles
>Attempting conversion of 450.0000 km to miles . . .
>450.0000km = 279.6247 miles
>Enter a conversion problem or q to quit.
>> 2.5 qt l
>Attempting conversion of 2.5000 qt to l . . .
>2.5000qt = 2.3659 l
>Enter a conversion problem or q to quit.
>> 100 meters gallons
>Attempting conversion of 100.0000 meters to gallons . . .
>Cannot convert meters (distance) to gallons (liquid_volume)
>Enter a conversion problem or q to quit.
>> 1234 mg g
>Attempting conversion of 1234.0000 mg to g . . .
>Unit mg not in database
>Enter a conversion problem or q to quit.
>> q
>```
## 10.6 Union Types (Optional)

> [!note] **Union Types**
> 
> Union types allow the same memory location to store different data types at different times. Only one member of the union can contain a value at any given time.

> [!example] **Union Type Example**
> ```C
> typedef union {
>    int i;
>    float f;
>    char str[20];
>} data_t;
>
>data_t value;
>value.i = 42;     // Store an integer
>value.f = 3.14;   // Now stores a float, previous integer is lost
>strcpy(value.str, "Hello"); // Now stores a string
> ```
## 10.7 Common Programming Errors

> [!warning] **Common Error with Structure Component Selection**
> 
> The most common error is incorrect use of a component selected for processing. Always be aware of the type of the component selected, and use the value in a manner consistent with its type.

> [!example] **Array Component Handling**
> 
> If the component selected is an array, passing it to a function as an output argument does not require the application of the address-of operator.

> [!tip] **Avoiding Operator Precedence Issues**
> 
> If a structure type output parameter is used in a function, you can avoid operator precedence problems by using the indirect component selection operator (`->`).

> [!warning] **Limitations of Structure Types**
> 
> C allows the use of structure type values in assignment statements, as function arguments, and as function results, but expressions of these types cannot be:
> 
> - Operands of equality comparators
> - Arguments of `printf` and `scanf`

> [!tip] **Working with Structure Limitations**
> 
> You can either:
> 
> - Select simple components from a structure to use in these contexts
> - Write your own type-specific equality and I/O functions

> [!warning] **Union Type Issues**
> 
> When using a union type, it's easy to reference a component that is not currently valid.

> [!tip] **Safer Union Usage**
> 
> To avoid union type issues:
> 
> - Place the union within another structure that contains a component whose value indicates which interpretation of the union is correct
> - Ensure all manipulation of the union falls within `if` or `switch` statements that reference the union component based on the value of the associated structure component
## Additional Worked Examples

> [!example]- **Student Record Management**
> 
> Let's create a program that manages student records using structures:
> ```C
> #include <stdio.h>
>#include <string.h>
>
>#define MAX_NAME_LEN 50
>#define MAX_STUDENTS 100
>
>typedef struct {
>    int id;
>    char name[MAX_NAME_LEN];
>    double gpa;
>    int year;  // 1=freshman, 2=sophomore, etc.
>} student_t;
>
>// Function prototypes
>void print_student(student_t s);
>student_t input_student(void);
>int find_student(student_t students[], int count, int id);
>
>int main() {
>    student_t students[MAX_STUDENTS];
>    int count = 0;
>    int choice, id, index;
>    
>    do {
>        printf("\nStudent Record System\n");
>        printf("1. Add a student\n");
>        printf("2. Find a student by ID\n");
>        printf("3. Display all students\n");
>        printf("4. Exit\n");
>        printf("Enter your choice: ");
>        scanf("%d", &choice);
>        
>        switch(choice) {
>            case 1:
>                if (count < MAX_STUDENTS) {
>                    students[count] = input_student();
>                    count++;
>                    printf("Student added successfully.\n");
>                } else {
>                    printf("Maximum number of students reached.\n");
>                }
>                break;
>                
>            case 2:
>                printf("Enter student ID to find: ");
>                scanf("%d", &id);
>                index = find_student(students, count, id);
>                if (index != -1) {
>                    printf("Student found:\n");
>                    print_student(students[index]);
>                } else {
>                    printf("Student with ID %d not found.\n", id);
>                }
>                break;
>                
>            case 3:
>                printf("All Students:\n");
>                for (int i = 0; i < count; i++) {
>                    print_student(students[i]);
>                    printf("--------------------\n");
>                }
>                break;
>                
>            case 4:
>                printf("Exiting program.\n");
>                break;
>                
>            default:
>                printf("Invalid choice. Please try again.\n");
>        }
>    } while (choice != 4);
>    
>    return 0;
>}
>
>void print_student(student_t s) {
>    printf("ID: %d\n", s.id);
>    printf("Name: %s\n", s.name);
>    printf("GPA: %.2f\n", s.gpa);
>    printf("Year: ");
>    switch(s.year) {
>        case 1: printf("Freshman\n"); break;
>        case 2: printf("Sophomore\n"); break;
>        case 3: printf("Junior\n"); break;
>        case 4: printf("Senior\n"); break;
>        default: printf("Unknown\n");
>    }
>}
>
>student_t input_student(void) {
>    student_t s;
>    printf("Enter student ID: ");
>    scanf("%d", &s.id);
>    printf("Enter student name: ");
>    scanf(" %[^\n]", s.name);  // Read string with spaces
>    printf("Enter GPA: ");
>    scanf("%lf", &s.gpa);
>    printf("Enter year (1-4): ");
>    scanf("%d", &s.year);
>    return s;
>}
>
>int find_student(student_t students[], int count, int id) {
>    for (int i = 0; i < count; i++) {
>        if (students[i].id == id) {
>            return i;  // Return index of found student
>        }
>    }
>    return -1;  // Not found
>}
> ```

>[!example]- **Geometric Shapes with Structures**
>
>Let's create a program that works with different geometric shapes using structures:
>```C
>#include <stdio.h>
>#include <math.h>
>
>#define PI 3.14159
>
>typedef struct {
>    double x, y;
>} point_t;
>
>typedef struct {
>    point_t center;
>    double radius;
>} circle_t;
>
>typedef struct {
>    point_t p1, p2;
>} rectangle_t;
>
>// Function prototypes
>double circle_area(circle_t c);
>double circle_perimeter(circle_t c);
>double rectangle_area(rectangle_t r);
>double rectangle_perimeter(rectangle_t r);
>int point_in_circle(point_t p, circle_t c);
>int point_in_rectangle(point_t p, rectangle_t r);
>
>int main() {
>    circle_t my_circle = {{5.0, 5.0}, 3.0};
>    rectangle_t my_rect = {{2.0, 1.0}, {7.0, 4.0}};
>    point_t test_point = {4.0, 4.0};
>    
>    printf("Circle with center (%.1f, %.1f) and radius %.1f:\n", 
>           my_circle.center.x, my_circle.center.y, my_circle.radius);
>    printf("Area: %.2f\n", circle_area(my_circle));
>    printf("Perimeter: %.2f\n", circle_perimeter(my_circle));
>    printf("Point (%.1f, %.1f) is %s the circle\n", 
>           test_point.x, test_point.y, 
>           point_in_circle(test_point, my_circle) ? "inside" : "outside");
>    
>    printf("\nRectangle with corners (%.1f, %.1f) and (%.1f, %.1f):\n", 
>           my_rect.p1.x, my_rect.p1.y, my_rect.p2.x, my_rect.p2.y);
>    printf("Area: %.2f\n", rectangle_area(my_rect));
>    printf("Perimeter: %.2f\n", rectangle_perimeter(my_rect));
>    printf("Point (%.1f, %.1f) is %s the rectangle\n", 
>           test_point.x, test_point.y, 
>           point_in_rectangle(test_point, my_rect) ? "inside" : "outside");
>    
>    return 0;
>}
>
>double circle_area(circle_t c) {
>    return PI * c.radius * c.radius;
>}
>
>double circle_perimeter(circle_t c) {
>    return 2 * PI * c.radius;
>}
>
>double rectangle_area(rectangle_t r) {
>    double width = fabs(r.p2.x - r.p1.x);
>    double height = fabs(r.p2.y - r.p1.y);
>    return width * height;
>}
>
>double rectangle_perimeter(rectangle_t r) {
>    double width = fabs(r.p2.x - r.p1.x);
>    double height = fabs(r.p2.y - r.p1.y);
>    return 2 * (width + height);
>}
>
>int point_in_circle(point_t p, circle_t c) {
>    double distance = sqrt(pow(p.x - c.center.x, 2) + pow(p.y - c.center.y, 2));
>    return distance <= c.radius;
>}
>
>int point_in_rectangle(point_t p, rectangle_t r) {
>    double min_x = fmin(r.p1.x, r.p2.x);
>    double max_x = fmax(r.p1.x, r.p2.x);
>    double min_y = fmin(r.p1.y, r.p2.y);
>    double max_y = fmax(r.p1.y, r.p2.y);
>    
>    return (p.x >= min_x && p.x <= max_x && p.y >= min_y && p.y <= max_y);
>}
>```

> [!summary] **Summary**
> 
> Structures in C provide a powerful way to organize data by grouping related variables of different types under a single name. We've learned how to define structure types using `typedef struct`, access individual components using the direct selection operator (`.`) and indirect selection operator (`->`), and manipulate entire structures through assignment. We've explored how to pass structures to functions as both input and output parameters, and how functions can return structured values. The concept of Abstract Data Types (ADTs) was introduced, showing how combining a user-defined type with a set of operations enables higher-level problem solving. We compared parallel arrays with arrays of structures, demonstrating how the latter provides a more natural organization of related data. Finally, we covered common programming errors to avoid when working with structures. Understanding structures is essential for creating well-organized, efficient C programs that model real-world data.