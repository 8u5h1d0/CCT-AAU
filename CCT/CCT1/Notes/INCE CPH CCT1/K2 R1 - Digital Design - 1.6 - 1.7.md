---
tags:
  - CCT1
  - CE
Topic: Signed Binary Numbers and Binary Codes
Semester: CCT1
Course: CE1
Module: K2
Course Date: N/A
Litterature:
  - Digital Design, 5th ed.
Created: 16-11-25
---
- - -
## Table of Contents

- [[#Signed Binary Numbers and Binary Codes|Signed Binary Numbers and Binary Codes]]
	- [[#Signed Binary Numbers and Binary Codes#Quick Reference|Quick Reference]]
	- [[#Signed Binary Numbers and Binary Codes#Signed Binary Numbers|Signed Binary Numbers]]
		- [[#Signed Binary Numbers#Representation Methods|Representation Methods]]
		- [[#Signed Binary Numbers#Comparison of Representation Methods|Comparison of Representation Methods]]
	- [[#Signed Binary Numbers and Binary Codes#Arithmetic Operations|Arithmetic Operations]]
		- [[#Arithmetic Operations#Arithmetic Addition|Arithmetic Addition]]
			- [[#Arithmetic Addition#Sign-Magnitude Addition|Sign-Magnitude Addition]]
			- [[#Arithmetic Addition#Signed-Complement Addition|Signed-Complement Addition]]
		- [[#Arithmetic Operations#Arithmetic Subtraction|Arithmetic Subtraction]]
	- [[#Signed Binary Numbers and Binary Codes#Binary Codes|Binary Codes]]
		- [[#Binary Codes#Code Properties|Code Properties]]
		- [[#Binary Codes#Binary-Coded Decimal (BCD)|Binary-Coded Decimal (BCD)]]
	- [[#Signed Binary Numbers and Binary Codes#BCD Arithmetic|BCD Arithmetic]]
		- [[#BCD Arithmetic#BCD Addition|BCD Addition]]
			- [[#BCD Addition#BCD Addition Rules|BCD Addition Rules]]
			- [[#BCD Addition#Multi-Digit BCD Addition|Multi-Digit BCD Addition]]

# Signed Binary Numbers and Binary Codes

## Quick Reference

| Concept / System | Representation Method | Key Characteristics & Range | Primary Use Case / Advantage | Example |
|---|---|---|---|---|
| **Unsigned Binary** | Pure binary magnitude, all bits represent the value. | Range for n bits: $0$ to $2^n - 1$. | Representing only non-negative quantities (e.g., counters, memory addresses). | `1010` = 10 in decimal. |
| **Sign-Magnitude** | Leftmost bit is sign (0=+, 1=-), remaining bits are magnitude. | Two representations for zero (+0 and -0). Range for n bits: $-(2^{n-1} - 1)$ to $+(2^{n-1} - 1)$. | Simple for human interpretation. Not common for internal arithmetic. | `11001` (5-bit) = -9. `01001` (5-bit) = +9. |
| **Signed-Complement (2's)** | Positive numbers are same as unsigned. Negative numbers are the 2's complement of their absolute value. | One representation for zero. Range for n bits: $-2^{n-1}$ to $+(2^{n-1} - 1)$. | **Standard for integer arithmetic** in computers, as it simplifies addition/subtraction hardware. | For -9 in a 5-bit system: 2's complement of `01001` is `10111`. |
| **BCD** | Each decimal digit (0-9) is encoded with a separate 4-bit binary code. | Inefficient storage (6 codes, 1010-1111, are unused per digit). Easy conversion to/from decimal for I/O. | Digital displays, financial calculations where exact decimal representation is required. | Decimal `493` -> BCD `0100 1001 0011`. |
| **BCD Addition Process** | Add BCD digits as binary, then correct if necessary. | If a digit sum > 9 or generates a carry, add 6 (`0110`) to that digit to get the correct BCD digit and propagate the carry. | Performing arithmetic directly on numbers stored in BCD format. | `5 + 8` -> `0101 + 1000` = `1101`. Since `1101` > 9, add `0110`: `1101 + 0110` = `1 0011`. Result is `0001 0011` (13). |

---

## Signed Binary Numbers

### Representation Methods

> [!info] Sign-Magnitude Representation 
> In binary systems, the sign of a number is represented by a bit placed in the leftmost position. The convention is to make the sign bit 0 for positive and 1 for negative.
> 
>> [!example] 
>> - `01001` represents +9 in signed binary
>> - `11001` represents -9 in signed binary (but would be 25 if considered as an unsigned number)

> [!info] Signed-Complement System 
> For arithmetic operations in computers, the _signed-complement system_ is more convenient for representing negative numbers. In this system, a negative number is represented by its complement. While both r-1's and r's complement can be used, r's complement is most commonly used.

### Comparison of Representation Methods

_Table 1.1: Comparison of Signed Binary Number Representation Methods_

|Method|Positive Representation|Negative Representation|Advantages|
|---|---|---|---|
|Sign-Magnitude|Sign bit 0 followed by magnitude|Sign bit 1 followed by magnitude|Simple to understand|
|Signed-Complement|Sign bit 0 followed by magnitude|Complement of all bits including sign bit|Simplifies arithmetic operations|

> [!question] 
> Why is signed-complement representation preferred over sign-magnitude in computer systems?

## Arithmetic Operations

### Arithmetic Addition

#### Sign-Magnitude Addition

The addition of two numbers in _signed magnitude_ follows these rules:
1. Compare the signs of the numbers
2. If signs are the same, add the magnitudes and keep the common sign
3. If signs are different, subtract the smaller magnitude from the larger magnitude
4. Give the result the sign of the number with the larger magnitude

> [!warning] Limitation 
> This process requires comparison of signs and magnitudes, then performing either addition or subtraction, making it computationally more complex.

> [!example] Sign-Magnitude Addition
> To add +14 and -9 in sign-magnitude:
> 
> 1. Represent the numbers:
>    - +14 = `01110`
>    - -9 = `11001`
> 
> 2. Signs are different, so subtract the smaller magnitude (9) from the larger (14):
>    ```
>      1110 (14)
>    - 1001 (9)
>    -------
>      0101 (5)
>    ```
> 
> 3. The result gets the sign of the number with the larger magnitude (+14), so:
>    - Result = `00101` (+5)

#### Signed-Complement Addition

In the _signed-complement_ system, the process requires only addition, with no comparison:
> The addition of two signed binary numbers with negative numbers represented in signed-2's-complement form is obtained from the addition of the two numbers, including their sign bits. A carry out of the sign-bit position is discarded.

> [!example] Signed-Complement Addition
> To add +14 and -9 using signed-2's-complement:
> 
> 1. Represent the numbers:
>    - +14 = `01110`
>    - -9 = 2's complement of `01001` = `10111`
> 
> 2. Add the numbers including sign bits:
>    ```
>      01110 (+14)
>    + 10111 (-9)
>    --------
>     100101
>    ```
> 
> 3. Discard the carry out of the sign-bit position:
>    - Result = `00101` (+5)

### Arithmetic Subtraction

Subtraction of two signed binary numbers when using _signed-complements_ in r's-form follows these steps:
1. Take the r's complement of the subtrahend (including the sign bit)
2. Add it to the minuend (including the sign bit)
3. Discard any carry out of the sign-bit position

> [!example] Signed-Complement Subtraction
> To subtract +9 from +14 using signed-2's-complement:
> 
> 1. Represent the numbers:
>    - +14 = `01110` (minuend)
>    - +9 = `01001` (subtrahend)
> 
> 2. Take the 2's complement of the subtrahend (+9):
>    - 2's complement of `01001` = `10111` (-9)
> 
> 3. Add the minuend and the complemented subtrahend:
>    ```
>      01110 (+14)
>    + 10111 (-9)
>    --------
>     100101
>    ```
> 
> 4. Discard the carry out of the sign-bit position:
>    - Result = `00101` (+5)

## Binary Codes

> [!info] Basic Concept 
> Any discrete element of information that is distinct among a group of quantities can be represented with a binary code (a pattern of 0's and 1's).
> 
> An _n_-bit binary code is a group of _n_ bits that can represent up to 2^n combinations of 0's and 1's, with each combination representing an element of the set being coded.

### Code Properties

- Each element **must** be assigned a unique binary bit combination
- No two elements can have the same code
- The _minimum_ number of bits required to code 2^n distinct quantities is _n_
- There is no _maximum_ number of bits that can be used for coding

> [!note] Code Efficiency 
> A binary code will have some unassigned bit combinations if the number of elements is not a multiple power of 2.
> 
>> [!example]
>> If you use the 10 decimal digits as a set of elements, all 10 elements can be contained with 4 bits, but 6 out of the 16 total combinations possible using 4 bits (2^4) will be unassigned.

### Binary-Coded Decimal (BCD)

The binary code most commonly used for encoding decimal digits is the _straight binary assignment table_, also called _binary-coded decimal_ (BCD).

> [!important] BCD Properties
> 
> - BCD gives 4 bits per decimal digit
> - A number with _k_ digits will require _4 × k_ bits with BCD
> - The binary combinations 1010 to 1111 are NOT used and have no meaning in BCD

> [!example] BCD Representation
> The decimal number 493 would be represented in BCD as:
> 
> - 4 = `0100`
> - 9 = `1001`
> - 3 = `0011`
> 
> So, 493 in BCD = `0100 1001 0011`

## BCD Arithmetic

### BCD Addition

Since each individual BCD digit cannot exceed 9, the sum cannot be greater than 9 plus any remainders and possible carry from a previous, less significant pair of digits.

#### BCD Addition Rules

1. Add the two BCD digits as if they are binary numbers
2. If the binary sum is ≤ 1001 (9) without a carry, the corresponding BCD digit is correct
3. If the binary sum is ≥ 1010 (10), the result is an invalid BCD digit
    - Add 6 (0110) to the binary sum to convert it to the correct digit
    - This produces a carry as required
4. If the binary sum produces a carry (when sum ≥ 16), add 6 (0110) to obtain the correct BCD sum and carry

> [!example] BCD Addition Examples
> 
> - In the first case, the sum is = 9 and is also the correct BCD
> - In the second case, the sum is an invalid BCD digit, so `0110` is added to produce the correct BCD and carry
> - In the third case, the binary sum produces a carry. This occurs when the sum is greater than or equal to 16. Though the other byte is less than 1001, the binary requires correction because of the carry. Adding `0110` we again get the right BCD and carry

#### Multi-Digit BCD Addition

The addition of two _n_-digit _unsigned_ BCD numbers follows the same procedure, with carries being propagated between digit positions as needed.

> [!example] Multi-Digit BCD Addition
> To add 485 and 378 in BCD:
> 
> 1. Convert to BCD:
>    - 485 = `0100 1000 0101`
>    - 378 = `0011 0111 1000`
> 
> 2. Add the BCD numbers digit by digit:
>    ```
>      0100 1000 0101  (485)
>    + 0011 0111 1000  (378)
>    ------------------
>      0111 1111 1101  (Binary sum)
>    ```
> 
> 3. Check each digit and correct if necessary:
>    - Rightmost digit: `1101` (13) is invalid, add 6: `1101 + 0110 = 1 0011` (3 with carry)
>    - Middle digit: `1111 + 1 (carry) = 1 0000` (16) has a carry, add 6: `0000 + 0110 = 0110` (6 with carry)
>    - Leftmost digit: `0111 + 1 (carry) = 1000` (8) is valid
> 
> 4. Final result: `1000 0110 0011` = 863 in decimal

> [!summary] Key Points
> 
> - Signed binary numbers can be represented using either sign-magnitude or signed-complement methods
> - Signed-complement representation simplifies arithmetic operations in computers
> - BCD is a common binary code for representing decimal digits
> - BCD arithmetic requires special handling when results exceed valid BCD digits
> - Adding 6 (0110) to invalid BCD results corrects the value and generates appropriate carries