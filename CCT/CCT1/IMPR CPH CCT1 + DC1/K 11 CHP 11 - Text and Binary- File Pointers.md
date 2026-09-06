---
tags:
  - C
  - IMPR
  - CCT1
Topic: File Pointers
Semester: CCT1
Course: IMPR1
Module: K11
Course Date: 21-11-25
Litterature:
  - Problem Solving and Program Design in C, Global Edition, 8th ed.
Created: 21-11-25
---


# Input/Output Files in C

## Quick Reference

| Concept | Syntax/Function | Purpose |
|---|---|---|
| Text File | `FILE *filep = fopen("filename.txt", "r");` | Open a text file for reading |
| Binary File | `FILE *filep = fopen("filename.bin", "rb");` | Open a binary file for reading |
| Write to Text File | `fprintf(filep, "%d", value);` | Write formatted data to a text file |
| Write to Binary File | `fwrite(&value, sizeof(int), 1, filep);` | Write binary data directly to a file |
| Read from Text File | `fscanf(filep, "%d", &value);` | Read formatted data from a text file |
| Read from Binary File | `fread(&value, sizeof(int), 1, filep);` | Read binary data directly from a file |
| Close File | `fclose(filep);` | Close an open file |
| EOF Check | `while (fscanf(filep, "%d", &value) != EOF)` | Process until end of file |

---

C can process two kinds of files:
- *text files*
- *binary files*.

A *text* file is a named collection of characters saved in secondary storage (e.g., on a disk); it has no fixed size. To mark the end of a text file, the computer places a special end-of-file character, which we will denote `<eof>`, after the last character in the file. As you create a text file using an editor program, pressing the `<return>` or `<enter>` key causes the newline character (represented in C as `'\n'`) to be placed in the file.

> [!example]
> ```
> This is a text file!<newline>
> It has two lines.<newline><eof>
> ```
> Each line ends with the newline character, and the eof character follows the last newline in the file.

> [!note]
> Because all textual input and output data are actually a continuous stream of character codes, we sometimes refer to a data source or destination as an input stream or an output stream. These general terms can be applied to files, to the terminal keyboard and screen, and to any other sources of input data or destinations of output data.

## The Keyboard and Screen as Text Streams

> [!info] **Keyboard and Screen as Text Streams**
> 
> In interactive programming, C associates system names with the terminal keyboard and screen.
> 
> - The name `stdin` represents the keyboard's input stream.
> - The "normal" output stream `stdout` and the "error" output stream `stderr` are associated with the screen.
> 
> All three streams can be treated like text files because their individual components are characters.

Normally at the keyboard, you enter one line of data at a time, pressing `<return>` or `<enter>` to indicate the end of a data line. Pressing one of these keys inserts the **newline character** into the system stream `stdin`. In interactive programming, a **sentinel value** is typically used to indicate the end of data, rather than attempting to place the **eof character** in `stdin`.

> [!example] **Generating the EOF Character**
> 
> No single key represents the `eof` character. Most systems use a combination of the control key followed by a letter. For example, on computers running the UNIX operating system, the keystrokes `<control-d>` would be used.

> [!info] **Writing to the Screen**
> 
> Writing characters to the `stdout` and `stderr` streams causes a display on the screen in an interactive program. The `printf` function is used to write characters to the screen. Using a `'\n'` in the `printf` format string causes the output of a newline character, which moves the cursor to the start of the next line on the screen.

## Newline and EOF

C handles the special **newline** character differently than the **eof** character, even though they have similar purposes. The **`<newline>`** marks the end of a line of text, while the **`<eof>`** marks the end of the entire file. The **`<newline>`** can be processed like any other character: it can be input using `scanf` with the `%c` specifier, it can be compared to `'\n'` for equality, and it can be output using `printf`.

However, the input of the special **`<eof>`** character is regarded as a failed operation. The input function responsible returns as its value the negative integer associated with the identifier `EOF`. This special return value gives the calling function an indication that no more data are in the input file.

> [!example] **Input Loop Based on EOF**
>
> The following is an example of an input loop that bases its exit condition on the appearance of the `EOF` return value.
>
> ```c
> // Loop to read numbers until the end of the file is reached
> for (status = scanf("%d", &num); // Initialization: get the first number
>      status != EOF;             // Test: check if we reached the end-of-file
>      status = scanf("%d", &num)) // Update: get the next number
> {
>     process(num); // Process the number that was successfully read
> }
> ```

## Escape Sequences

The character `'\n'` is one of several **escape sequences** defined by C to represent special characters. Other commonly used escape sequences include `'\t'` (tab), `'\f'` (form feed), and `'\r'` (return). Because all escape sequences begin with a backslash (`\`), representing the actual backslash character itself requires a special sequence.

| Escape Sequence | Meaning                                             |
| :-------------- | :-------------------------------------------------- |
| `'\n'`          | new line                                            |
| `'\t'`          | tab                                                 |
| `'\f'`          | form feed (new page)                                |
| `'\r'`          | return (go back to column 1 of current output line) |
| `'\b'`          | backspace                                           |

_Table 1: Common Escape Sequences and their corresponding meanings._

> [!info] Defining Escape Sequences
> An **escape sequence** is a character combination beginning with a backslash (`\`) that is interpreted by the C compiler as having a special meaning, such as representing a newline or a tab.

> [!important] Representing a Literal Backslash
> To represent the actual backslash character (`\`) in a C program, you must use the escape sequence `\\`.

The `'\r'` (return) sequence differs from the newline (`'\n'`) in that it moves the cursor to the beginning of the _current_ line of output, not to the beginning of the next line.

> [!warning] Newline vs. Return
> - `'\n'` (newline): Moves the cursor to the beginning of the next line.
> - `'\r'` (return): Moves the cursor to the beginning of the current line.

## Formatting Output with `printf`

The `printf` function uses *placeholders* within its format string to display various types of data, such as integers, characters, floating-point numbers, and strings.

| Placeholder | Used for Output of | Example Output |
| :--- | :--- | :--- |
| `%c` | a single character | ```c<br>printf("%c%c%c\n", 'a', '\n', 'b');<br>```<br>a<br>b |
| `%s` | a string | ```c<br>printf("%s%s\n", "Hi, how ", "are you?");<br>```<br>Hi, how are you? |
| `%d` | an integer (in base 10) | ```c<br>printf("%d\n", 43);<br>```<br>43 |
| `%o` | an integer (in base 8) | ```c<br>printf("%o\n", 43);<br>```<br>53 |
| `%x` | an integer (in base 16) | ```c<br>printf("%x\n", 43);<br>```<br>2b |
| `%f` | a floating-point number | ```c<br>printf("%f\n", 81.97);<br>```<br>81.970000 |
| `%e` | a floating-point number in scientific notation | ```c<br>printf("%e\n", 81.97);<br>```<br>8.197000e+01 |
| `%E` | a floating-point number in scientific notation | ```c<br>printf("%E\n", 81.97);<br>```<br>8.197000E+01 |
| `%%` | a single % sign | ```c<br>printf("%d%%\n", 10);<br>```<br>10% |

_Table 1.1: Placeholders for `printf` Format Strings_

> [!info] **Formatting with Field Width and Precision**
> 
> Each placeholder can be combined with a numeric *field width* to prescribe the minimum number of columns for the displayed value.
> 
> - A **positive** field width number results in the value being *right-justified* in the field, with any blank padding in front of the value.
> - A **negative** field width number results in the value being *left-justified* in the field, with any blank padding following the value.
> - If the field width is too small, `printf` uses the minimum-sized field needed to accommodate the value.

## File Pointer Variables

To use a nonstandard text file for input or output, you must declare a *file pointer variable* and initialize it to access the desired file. The system must prepare the file for access, which is done using the `stdio` library function `fopen`.

> [!info] **Declaring and Initializing File Pointers**
> 
> The data type for a file pointer variable is `FILE*`. C is case sensitive, so you must use all capital letters for `FILE`. The `fopen` function is used to open a file and assign its pointer to the variable.
> 
> ```c
> // Declare and initialize file pointers
> FILE *infilep;
> FILE *outfilep;
> 
> infilep = fopen("data.txt", "r");  // Opens for reading
> outfilep = fopen("results.txt", "w"); // Opens for writing
> 
> // Multiple pointers can be declared in one statement
> FILE *infilep, *outfilep;
> ```

> [!warning] **Handling File Open Errors and Null Pointers**
> 
> If `fopen` cannot open the file, it returns the value `NULL`. Your program should always check for this condition to prevent errors.
> 
> ```c
> if (infilep == NULL)
>     printf("Cannot open data.txt for input\n");
> ```

> [!warning] **Risk of Data Loss with "w" Mode**
> 
> Using `fopen` with mode `"w"` to open a file that already exists will usually cause the contents of the existing file to be erased.

## Functions That Take File Pointer Arguments

C provides functions for file input and output that are analogous to the standard I/O functions. These file-based functions behave similarly to their standard counterparts but require an additional argument: a file pointer to specify the input source or output destination.

> [!info] **Comparison of Standard I/O and File I/O Functions**
> 
> The standard I/O functions have direct file-based equivalents:
> 
> -   `fscanf` is used for input from a file, much like `scanf` is used for input from the keyboard.
> -   `fprintf` is used for output to a file, just as `printf` is used for output to the screen.
> -   `getc` and `putc` are the file-based equivalents of `getchar` and `putchar` for handling single-character input and output.

| Line | Functions That Access stdin and stdout | Functions That Can Access Any Text File |
| :--- | :--- | :--- |
| 1 | `scanf("%d", &num);` | `fscanf(infilep, "%d", &num);` |
| 2 | ```c<br>printf("Number = %d\n", num);<br>``` | ```c<br>fprintf(outfilep, "Number = %d\n", num);<br>``` |
| 3 | `ch = getchar();` | `ch = getc(infilep);` |
| 4 | `putchar(ch);` | `putc(ch, outfilep);` |

_Table 1.3: Comparison of I/O with Standard Files and I/O with User-Defined File Pointers_

## Closing a File

When a program has finished using a file, it should close the file by calling the library function `fclose` with the appropriate file pointer. For example, `fclose(infilep);` closes the file accessed through `infilep`.

> [!example] **Program to Make a Backup Copy of a Text File**
> 
> This program creates a backup copy of a text file. It interactively prompts the user for both the name of the original file to copy and the name for the new backup file.
> 
> ```c
> /*
>  * Makes a backup file. Repeatedly prompts for the name of a file to
>  * back up until a name is provided that corresponds to an available
>  * file. Then it prompts for the name of the backup file and creates
>  * the file copy.
>  */
> 
> #include <stdio.h>
> #define STRSIZ 80
> 
> int
> main(void)
> {
>     char in_name[STRSIZ], /* strings giving names */
>          out_name[STRSIZ]; /* of input and backup files */
>     FILE *inp,            /* file pointers for input and */
>          *outp;            /* backup files */
>     char ch;              /* one character of input file */
> 
>     /* Get the name of the file to back up and open the file for input */
>     printf("Enter name of file you want to back up> ");
>     for (scanf("%s", in_name);
>          (inp = fopen(in_name, "r")) == NULL;
>          scanf("%s", in_name)) {
>         printf("Cannot open %s for input\n", in_name);
>         printf("Re-enter file name> ");
>     }
> 
>     /* Get name to use for backup file and open file for output */
>     printf("Enter name for backup copy> ");
>     for (scanf("%s", out_name);
>          (outp = fopen(out_name, "w")) == NULL;
>          scanf("%s", out_name)) {
>         printf("Cannot open %s for output\n", out_name);
>         printf("Re-enter file name> ");
>     }
> 
>     /* Make backup copy one character at a time */
>     for (ch = getc(inp); ch != EOF; ch = getc(inp))
>         putc(ch, outp);
> 
>     /* Close files and notify user of backup completion */
>     fclose(inp);
>     fclose(outp);
>     printf("Copied %s to %s.\n", in_name, out_name);
> 
>     return(0);
> }
> ```
> ![[Pasted image 20251121132042.png]]
> _Figure 1.4: The input and output streams used by the file backup program_

---

## Binary Files

When using text files for data storage, a program must expend significant effort converting the stream of characters from the input file into the internal binary representation of the data. This conversion is performed by functions like `scanf`. When writing to a text file, the program must again convert the internal binary format back into a stream of characters using functions like `printf`.

If a file is only meant to be read by another program and not by a human, this conversion process is a waste of computer time. We can avoid this unnecessary translation by using a *binary file*.

A *binary file* is created by storing directly in the file the computer’s internal representation of each data component.

> [!info] **Creating a Binary File with `fwrite`**
> 
> The process for creating a binary file is similar to a text file, with a few key differences:
> 
> - The file is opened with `fopen` using the mode `"wb"` (write binary).
> - Data is written using the `fwrite` function, which takes four arguments:
>     1.  **Address:** The memory address of the data to be written (e.g., `&my_variable`).
>     2.  **Size:** The size of one data element in bytes, determined using the `sizeof` operator (e.g., `sizeof(int)`).
>     3.  **Count:** The number of elements to write.
>     4.  **File Pointer:** The pointer to the binary file opened for writing.

> [!example] **Creating a Binary File of Even Integers**
> 
> This code fragment creates a binary file named `"nums.bin"` and writes the even integers from 2 to 500 into it.
> 
> ```c
> FILE *binaryp;
> int i;
> 
> // Open the file for writing in binary mode
> binaryp = fopen("nums.bin", "wb");
> 
> // Loop through even numbers and write each to the file
> for (i = 2; i <= 500; i += 2) {
>     // Write the integer 'i' to the binary file
>     fwrite(&i, sizeof(int), 1, binaryp);
> }
> 
> // Close the file
> fclose(binaryp);
> ```

> [!warning] **Disadvantages of Binary Files**
> 
> - **Portability:** A binary file created on one type of computer is rarely readable on another.
> - **Human Readability:** A binary file cannot be read or proofread by a human.
> - **Testability:** A program that expects binary input cannot be tested until the program that produces the binary file is complete.

> [!info] **Reading from a Binary File with `fread`**
> 
> To read data from a binary file, you use the `fread` function, which is the counterpart to `fwrite`. It also requires four arguments:
> 
> 1.  **Address:** The memory address where the read data should be stored.
> 2.  **Size:** The size of one data element to be read (e.g., `sizeof(double)`).
> 3.  **Count:** The maximum number of elements to read from the file.
> 4.  **File Pointer:** The pointer to the binary file opened for reading.

> [!important] **Do Not Mix File Types**
> 
> It is critical to use the correct I/O functions for the file type. A binary file created with `fwrite` **must** be read using `fread`. A text file created with `fprintf` **must** be read using a text input function like `fscanf`.

| Example | Text File I/O | Binary File I/O | Purpose |
| :--- | :--- | :--- | :--- |
| 1 | ```c<br>plan_txt_inp = fopen("planets.txt", "r");<br>doub_txt_inp = fopen("nums.txt", "r");<br>``` | ```c<br>plan_bin_inp = fopen("planets.bin", "rb");<br>doub_bin_inp = fopen("nums.bin", "rb");<br>``` | Open for input a file of planets and a file of numbers, saving file pointers for use in calls to input functions. |
| 2 | ```c<br>plan_txt_outp = fopen("pl_out.txt", "w");<br>doub_txt_outp = fopen("nm_out.txt", "w");<br>``` | ```c<br>plan_bin_outp = fopen("pl_out.bin", "wb");<br>doub_bin_outp = fopen("nm_out.bin", "wb");<br>``` | Open for output a file of planets and a file of numbers, saving file pointers for use in calls to output functions. |
| 3 | ```c<br>fscanf(plan_txt_inp,<br>       "%s%lf%d%lf%lf",<br>       a_planet.name,<br>       &a_planet.diameter,<br>       &a_planet.moons,<br>       &a_planet.orbit_time,<br>       &a_planet.rotation_time);<br>``` | ```c<br>fread(&a_planet,<br>      sizeof(planet_t),<br>      1,<br>      plan_bin_inp);<br>``` | Copy one planet structure into memory from the data file. |
| 4 | ```c<br>fprintf(plan_txt_outp,<br>        "%s %e %d %e %e",<br>        a_planet.name,<br>        a_planet.diameter,<br>        a_planet.moons,<br>        a_planet.orbit_time,<br>        a_planet.rotation_time);<br>``` | ```c<br>fwrite(&a_planet,<br>       sizeof(planet_t),<br>       1,<br>       plan_bin_outp);<br>``` | Write one planet structure to the output file. |
| 5 | ```c<br>// Fill array nums from text file<br>for (i = 0; i < MAX; ++i) {<br>    fscanf(doub_txt_inp, "%lf", &nums[i]);<br>}<br>``` | ```c<br>// Fill array nums from binary file in one call<br>fread(nums, sizeof(double), MAX, doub_bin_inp);<br>``` | Fill array `nums` with type `double` values from input file. |
| 6 | ```c<br>// Write array nums to text file<br>for (i = 0; i < MAX; ++i) {<br>    fprintf(doub_txt_outp, "%e\n", nums[i]);<br>}<br>``` | ```c<br>// Write array nums to binary file in one call<br>fwrite(nums, sizeof(double), MAX, doub_bin_outp);<br>``` | Write contents of array `nums` to output file. |
| 7 | ```c<br>// Fill nums until EOF, set n to count<br>n = 0;<br>while ((status = fscanf(doub_txt_inp, "%lf", &data)) != EOF && n < MAX) {<br>    nums[n++] = data;<br>}<br>``` | ```c<br>// Fill nums until EOF, fread returns count<br>n = fread(nums, sizeof(double), MAX, doub_bin_inp);<br>``` | Fill `nums` with data until EOF encountered, setting `n` to the number of values stored. |
| 8 | ```c<br>fclose(plan_txt_inp);<br>fclose(plan_txt_outp);<br>fclose(doub_txt_inp);<br>fclose(doub_txt_outp);<br>``` | ```c<br>fclose(plan_bin_inp);<br>fclose(plan_bin_outp);<br>fclose(doub_bin_inp);<br>fclose(doub_bin_outp);<br>``` | Close all input and output files. |

_Table 2.1: Data I/O Using Text and Binary Files_

---

## Searching a Database

Computerized matching of data against a file of records is a common practice.

> [!info] Database
> These large files of data are called _databases_.

> [!example] Database Applications
> Many real estate companies maintain a large file of property listings, which a realtor can process to locate desirable properties for a client. Similarly, mail-order firms purchase large files of information on potential customers.

> [!summary]- **Case Study on Database Inquiry**
>
>**The Problem**
>Periphs Plus is a mail-order computer supply company that maintains its inventory as a computer file to facilitate answering questions regarding that database. The company needs a program that can search their database to answer questions like:
>- What printer stands that cost less than $100 are available?
>- What product has the code 5241?
>- What types of data cartridges are available?
>
>**Analysis**
>A database inquiry program has two phases: setting the search parameters and searching for records that satisfy the parameters. In our program, we assume that all structure components can be involved in the search. The program user must enter low and high bounds for each field of interest.
>
>For example, to answer the question "What modems that cost less than $200 are available?", we would set the search parameters by:
>1. Setting the low bound for category to "modem"
>2. Setting the high bound for category to "modem"
>3. Setting the high bound for price to $199.99
>4. Leaving other parameters at their default values
>
>![[Pasted image 20251123164533.png]]
>_Figure 3.1: Structure Chart for Database Inquiry Problem_
>
>**Design**
>The initial algorithm consists of three main steps:
>1. Open inventory file
>2. Get search parameters
>3. Display all products that satisfy the search parameters
>
>>[!example] **Specification of Data Structures and Functions**
>>**STRUCTURES:**
>>```C
>>/* Product structure type */
>>typedef struct {
>>    int stock_num;         /* stock number */
>>    char category[STR_SIZ];
>>    char tech_descript[STR_SIZ];
>>    double price;
>>} product_t;
>>
>>/* Search parameter bounds type */
>>typedef struct {
>>    int low_stock, high_stock;
>>    char low_category[STR_SIZ], high_category[STR_SIZ];
>>    char low_tech_descript[STR_SIZ], high_tech_descript[STR_SIZ];
>>    double low_price, high_price;
>>} search_params_t;
>>```
>>**FUNCTIONS:**
>>```C
>>/* Gets search parameters from user */
>>search_params_t get_params(void);
>>
>>/* Displays records of all products that satisfy search parameters */
>>void display_match(FILE *databasep, search_params_t params);
>>
>>/* Displays menu of search parameters and gets user selection */
>>char menu_choose(search_params_t params);
>>
>>/* Determines if a product matches the search parameters */
>>int match(product_t prod, search_params_t params);
>>
>>/* Displays a product record */
>>void show(product_t prod);
>>```
>
>**Implementation**
>```C
>/*
> * Displays all products in the database that satisfy the search
> * parameters specified by the program user.
> */
>#include <stdio.h>
>#include <string.h>
>
>#define MIN_STOCK 1111      /* minimum stock number */
>#define MAX_STOCK 9999      /* maximum stock number */
>#define MAX_PRICE 1000.00   /* maximum product price */
>#define STR_SIZ 80          /* number of characters in a string */
>
>/* User-defined product type */
>typedef struct {
>    int stock_num;          /* stock number */
>    char category[STR_SIZ];
>    char tech_descript[STR_SIZ];
>    double price;
>} product_t;
>
>/* User-defined search parameters type */
>typedef struct {
>    int low_stock, high_stock;
>    char low_category[STR_SIZ], high_category[STR_SIZ];
>    char low_tech_descript[STR_SIZ], high_tech_descript[STR_SIZ];
>    double low_price, high_price;
>} search_params_t;
>
>/* Function prototypes */
>search_params_t get_params(void);
>void display_match(FILE *databasep, search_params_t params);
>char menu_choose(search_params_t params);
>int match(product_t prod, search_params_t params);
>void show(product_t prod);
>
>/* Main driver function */
>int main(void)
>{
>    char inv_filename[STR_SIZ]; /* name of inventory file */
>    FILE *inventoryp;           /* inventory file pointer */
>    search_params_t params;     /* search parameter bounds */
>
>    /* Get name of inventory file and open it */
>    printf("Enter name of inventory file> ");
>    scanf("%s", inv_filename);
>    inventoryp = fopen(inv_filename, "rb");
>
>    /* Get the search parameters */
>    params = get_params();
>
>    /* Display all products that satisfy the search parameters */
>    display_match(inventoryp, params);
>
>    fclose(inventoryp); /* Close the file after use */
>
>    return(0);
>}
>
>/*
> * Prompts the user to enter the search parameters
> */
>search_params_t
>get_params(void)
>{
>    search_params_t params; /* structure whose components must be defined */
>    char choice;            /* user's response to menu */
>
>    /* 1. Initialize params to permit widest possible search */
>    params.low_stock = MIN_STOCK;
>    params.high_stock = MAX_STOCK;
>    strcpy(params.low_category, "aaaa");
>    strcpy(params.high_category, "zzzz");
>    strcpy(params.low_tech_descript, "aaaa");
>    strcpy(params.high_tech_descript, "zzzz");
>    params.low_price = 0.0;
>    params.high_price = MAX_PRICE;
>
>    /* 2. Display menu and get response to store in choice */
>    choice = menu_choose(params);
>
>    /* 3. Repeat while choice is not 'q' */
>    while (choice != 'q') {
>        /* 4. Select appropriate prompt and get new parameter value */
>        switch (choice) {
>            case 'a':
>                printf("New low bound for stock number> ");
>                scanf("%d", &params.low_stock);
>                break;
>            case 'b':
>                printf("New high bound for stock number> ");
>                scanf("%d", &params.high_stock);
>                break;
>            case 'c':
>                printf("New low bound for category> ");
>                scanf("%s", params.low_category);
>                break;
>            case 'd':
>                printf("New high bound for category> ");
>                scanf("%s", params.high_category);
>                break;
>            case 'e':
>                printf("New low bound for technical description> ");
>                scanf("%s", params.low_tech_descript);
>                break;
>            case 'f':
>                printf("New high bound for technical description> ");
>                scanf("%s", params.high_tech_descript);
>                break;
>            case 'g':
>                printf("New low bound for price> ");
>                scanf("%lf", &params.low_price);
>                break;
>            case 'h':
>                printf("New high bound for price> ");
>                scanf("%lf", &params.high_price);
>                break;
>            default:
>                printf("Invalid choice. Please try again.\n");
>        }
>
>        /* 5. Display menu and get response to store in choice */
>        choice = menu_choose(params);
>    }
>
>    /* 6. Return search parameters */
>    return (params);
>}
>
>/*
> * Displays a lettered menu with the current values of search parameters.
> * Returns the letter the user enters.
> */
>char
>menu_choose(search_params_t params)
>{
>    char choice;
>
>    printf("Select by letter a search parameter to set or enter");
>    printf("q to\naccept parameters shown.\n\n");
>    printf("  Search parameter      Current value\n\n");
>    printf("[a] Low bound for stock number      %4d\n", params.low_stock);
>    printf("[b] High bound for stock number     %4d\n", params.high_stock);
>    printf("[c] Low bound for category          %s\n", params.low_category);
>    printf("[d] High bound for category         %s\n", params.high_category);
>    printf("[e] Low bound for technical description %s\n", params.low_tech_descript);
>    printf("[f] High bound for technical description %s\n", params.high_tech_descript);
>    printf("[g] Low bound for price           $%7.2f\n", params.low_price);
>    printf("[h] High bound for price          $%7.2f\n\n", params.high_price);
>
>    printf("Selection> ");
>    scanf(" %c", &choice);
>
>    return (choice);
>}
>
>/*
> * Determines whether record prod satisfies all search parameters
> */
>int
>match(product_t prod, search_params_t params)
>{
>    return (strcmp(params.low_category, prod.category) <= 0 &&
>            strcmp(prod.category, params.high_category) <= 0 &&
>            strcmp(params.low_tech_descript, prod.tech_descript) <= 0 &&
>            strcmp(prod.tech_descript, params.high_tech_descript) <= 0 &&
>            params.low_price <= prod.price &&
>            prod.price <= params.high_price);
>}
>
>/*
> * *** STUB ***
> * Displays each field of prod. Leaves a blank line after the product display.
> */
>void
>show(product_t prod)
>{
>    printf("Function show entered with product number %d\n", prod.stock_num);
>}
>
>/*
> * Displays records of all products in the inventory that satisfy search
> * parameters.
> */
>void
>display_match(FILE *databasep, search_params_t params)
>{
>    product_t next_prod;    /* current product from database */
>    int no_matches = 1;     /* flag indicating if no matches have been found */
>    int status;             /* input file status */
>
>    /* Advances to first record with a stock number greater than or
>       equal to lower bound. */
>    for (status = fread(&next_prod, sizeof (product_t), 1, databasep);
>         status == 1 && params.low_stock > next_prod.stock_num;
>         status = fread(&next_prod, sizeof (product_t), 1, databasep)) {}
>
>    /* Displays a list of the products that satisfy the search
>       parameters */
>    printf("\nProducts satisfying the search parameters:\n");
>    while (next_prod.stock_num <= params.high_stock && status == 1) {
>        if (match(next_prod, params)) {
>            no_matches = 0;
>            show(next_prod);
>        }
>        status = fread(&next_prod, sizeof (product_t), 1, databasep);
>    }
>
>    /* Displays a message if no products found */
>    if (no_matches)
>        printf("Sorry, no products available\n");
>}
>```
>
>**Key Algorithms**
>>[!note] Algorithm for `get_params`
>>The `get_params` function initializes a `search_params_t` structure to allow the widest possible search. It then enters a loop, repeatedly displaying a menu of parameters via the `menu_choose` function. The user selects a parameter to change, and a `switch` statement prompts for a new value for that specific field. The loop continues until the user enters 'q' to accept the parameters, at which point the fully defined `search_params_t` structure is returned.
>>![[Pasted image 20251123164628.png]]
>>_Figure 3.2: Structure Chart for get_params_
>
>>[!note] Algorithm for `display_match`
>>The `display_match` function first uses a `for` loop to skip through the binary database file until it finds a record whose stock number is greater than or equal to the low stock bound. Then, it enters a `while` loop that continues as long as the current record's stock number is within the high stock bound and the end of the file has not been reached. Inside this loop, it calls the `match` function to see if the current product record satisfies all search criteria. If it does, `show` is called to display the record. Finally, if no records were found, a message is printed.
>>![[Pasted image 20251123164656.png]]
>>_Figure 3.3: Structure Chart for display_match_

---

## Common Programming Errors

C file processing has several common pitfalls that can lead to errors.

> [!tip] **File Pointer Naming Convention**
> Because C makes no type distinction between file pointers accessing text files and those accessing binary files, it is easy to use the wrong library function. To avoid this, choose names for your file pointers that remind you of the file type. For example, you could use names containing `_txt_` for text file pointers and names containing `_bin_` for binary file pointers.

> [!warning] **Using the Wrong I/O Function**
> It is critical to use the correct library functions for the type of file you are working with.
> - For ***text I/O only***, use: `fscanf`, `fprintf`, `getc`, `putc`.
> - For ***binary files exclusively***, use: `fread`, `fwrite`.
> 
> The order of arguments for these functions can be confusing:
> - `fprintf`, `fscanf`, and `getc` take the file pointer as their _first_ argument.
> - `putc`, `fread`, and `fwrite` take it as their _last_ argument.

> [!warning] **Accidentally Overwriting Files**
> When you allow a user to enter a filename, remember that you will have two variables: one for the name (a character string) and one for the file access pointer. The file name is _only_ used in the call to `fopen`.
> 
> Be very careful when opening a file for output. Calling `fopen` with a second argument of `"w"` or `"wb"` will typically result in the loss of any existing file with that name, as it creates a new, empty file.

> [!info] **Understanding Binary Files**
> Remember that binary files cannot be created, viewed, or modified using a standard text editor or word processor. They must be created and interpreted by a program that reads values into or writes values from variables of the _same type_ as the binary file's elements.

---

> [!summary] **Summary**
> 
> C provides two types of file processing: text files and binary files. Text files store data as character sequences, while binary files store data in the computer's internal representation format.
> 
> For text file operations, C provides functions like `fscanf`, `fprintf`, `getc`, and `putc`, which handle the conversion between character representations and internal data formats.
> 
> For binary file operations, C provides `fread` and `fwrite` functions, which directly transfer data between memory and file storage without conversion.
> 
> File operations require declaring a file pointer of type `FILE*`, opening the file with `fopen`, performing I/O operations, and closing the file with `fclose`.
> 
> The keyboard and screen are treated as special text files with predefined file pointers `stdin`, `stdout`, and `stderr`.
> 
> Common programming errors include using the wrong I/O function for the file type, incorrect argument order, and accidentally overwriting files when opening them in write mode.

