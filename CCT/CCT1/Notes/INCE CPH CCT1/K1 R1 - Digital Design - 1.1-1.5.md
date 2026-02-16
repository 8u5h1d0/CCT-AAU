---
tags:
  - CCT1
  - CE
Topic: " Digital Design Fundamentals"
Semester: CCT1
Course: CE1
Module: K1
Course Date: N/A
Litterature:
  - Digital Design, 5th ed.
Created: 16-11-25
---
- - -
## Table of Contents

- [[#Digital Systems and Binary Numbers|Digital Systems and Binary Numbers]]
	- [[#Digital Systems and Binary Numbers#Quick Reference|Quick Reference]]
	- [[#Digital Systems and Binary Numbers#Digital Systems|Digital Systems]]
	- [[#Digital Systems and Binary Numbers#Binary Numbers|Binary Numbers]]
	- [[#Digital Systems and Binary Numbers#Number-Base Conversions|Number-Base Conversions]]
		- [[#Number-Base Conversions#Decimal to Binary Conversion|Decimal to Binary Conversion]]
		- [[#Number-Base Conversions#Decimal to Octal (base-8) Conversion|Decimal to Octal (base-8) Conversion]]
		- [[#Number-Base Conversions#Octal and Hexadecimal Numbers|Octal and Hexadecimal Numbers]]
	- [[#Digital Systems and Binary Numbers#Complements of Numbers|Complements of Numbers]]
		- [[#Complements of Numbers#Diminished Radix Complement (r-1)´s|Diminished Radix Complement (r-1)´s]]
		- [[#Complements of Numbers#Radix Complement, r´s Complement ("2's Complement")|Radix Complement, r´s Complement ("2's Complement")]]
		- [[#Complements of Numbers#Subtraction using complements|Subtraction using complements]]

# Digital Systems and Binary Numbers

## Quick Reference

| Concept / Term | Description | Method / Formula | Example |
|---|---|---|---|
| **Bit** | The fundamental unit of information in a binary system. | N/A | `1` or `0` |
| **Binary Number** | A number expressed in the base-2 numeral system. | $d_n \times 2^n + ... + d_1 \times 2^1 + d_0 \times 2^0$ | `11010.11` |
| **Decimal to Binary** | Converting a base-10 number to base-2. | Repeatedly divide by 2, record remainders. Read remainders from bottom to top. | `13` -> `1101` |
| **Binary to Octal** | Converting a base-2 number to base-8. | Group binary bits into sets of 3 (from the radix point). | `110110110` -> `666` |
| **Binary to Hexadecimal** | Converting a base-2 number to base-16. | Group binary bits into sets of 4 (from the radix point). | `110110110` -> `1B6` |
| **1's Complement** | The diminished radix complement for binary numbers. Used in subtraction. | Invert all bits (change 0s to 1s and 1s to 0s). | `1011001` -> `0100110` |
| **2's Complement** | The radix complement for binary numbers. The standard for representing negative numbers. | Add 1 to the 1's complement. | `10010` -> `01110` |
| **Subtraction (2's Comp.)** | Performing subtraction using addition. | `M - N = M + (2's complement of N)`. Discard any end carry. | `10101 - 10011` -> `0010` |

---

## Digital Systems

Digital systems represent and manipulate discrete elements of information. Any set involving a finite number of elements contains discrete information, such as the 10 digits in the decimal system or the 52 cards in a deck.

In digital computers, the discrete elements are digits represented by physical quantities called _signals_. Modern computers typically use electrical signals like changes in voltage or current. Today's electronic signal systems employ just two discrete signals and are therefore called _binary_ systems.

A binary digit is called a **bit**, which can have one of two values: 1 or 0. Discrete elements are represented with groups of bits called _binary codes_. How a pattern of bits is interpreted depends on the code-system in which it resides.

A **digital-system** is an interconnection of _digital modules_. Understanding these modules requires knowledge of the digital circuits within them and their logical function.

> [!important] 
> It is important to become familiar with HDL-based design methodology, as it is the industry standard for digital circuit design.

## Binary Numbers

A decimal number such as 2000 represents a quantity equal to 2×1000 + 0×100 + 0×10 + 0×1. These are all powers of 10, with the power corresponding to a specific digit being implied by its position. The number 2000 is therefore a shorthand notation for $2 \times 10^3 + 0 \times 10^2 + 0 \times 10^1 + 0 \times 10^0$.

Any number system has a _base_, also known as a _radix_. For the decimal system, the radix is 10, as it uses 10 digits (0 through 9), and the coefficients are multiplied by powers of 10.

The _**binary**_ system is also a positional number system. The coefficients of binary numbers can only have two values: 1 or 0. Each coefficient is multiplied by the radix (2 raised to a power), and the results are added to obtain the decimal-number-equivalent.

The radix point distinguishes positive powers of the base from negative powers.

> [!example]
> The binary number **$11010.11$** is equivalent to the decimal number **$26.75$**.
> $1 1 0 1 0 . 1 1$
> $= 1 \times 2^4 + 1 \times 2^3 + 0 \times 2^2 + 1 \times 2^1 + 0 \times 2^0 + 1 \times 2^{-1} + 1 \times 2^{-2}$
> $= 16 + 8 + 0 + 2 + 0 + 0.5 + 0.25$
> $= 26.75$

In general, a base-_r_ system has coefficients multiplied by powers of _r_. The coefficients range from $0$ to $r-1$.

The general formula for a number in base _r_ is:
$$d_n \times r^n + d_{n-1} \times r^{n-1} + ... + d_1 \times r^1 + d_0 \times r^0 + d_{-1} \times r^{-1} ...$$

> [!example] Applying the Formula 
> Applying this formula to the decimal number **234.5** (where base _r_ = 10):
> 
> - The digits are $d_2=2$, $d_1=3$, $d_0=4$, $d_{-1}=5$.
> - The calculation is:
>     
>     $2 \times 10^2 + 3 \times 10^1 + 4 \times 10^0 + 5 \times 10^{-1}$
>     
>     $= 2 \times 100 + 3 \times 10 + 4 \times 1 + 5 \times 0.1$
>     
>     $= 200 + 30 + 4 + 0.5 = 234.5$
>     
>      This confirms the formula works for our familiar decimal system.

## Number-Base Conversions

Representations of numbers in different radixes are said to be equivalent if they have the same decimal representation. For example, (0011) in base-8 (octal) and (1001) in binary are equal, as they both have a decimal value of 9.
$$0 \times 8^3 + 0 \times 8^2 + 1 \times 8^1 + 1 \times 8^0 = 0 + 0 + 8 + 1 = 9$$
$$1 \times 2^3 + 0 \times 2^2 + 0 \times 2^1 + 1 \times 2^0 = 8 + 0 + 0 + 1 = 9$$

If the number includes a radix point, it is necessary to split the number into an integer part and a fraction part. Each part must be converted differently.

Conversion from **decimal** to base-_r_ is done by dividing the number and all successive quotients by _r_ and accumulating the remainders.

### Decimal to Binary Conversion

To convert a decimal number to binary:
1. Divide the decimal number by 2
2. Record the remainder (0 or 1)
3. Use the quotient as the new number to divide
4. Repeat until the quotient is 0
5. The binary equivalent is the remainders read from bottom to top

### Decimal to Octal (base-8) Conversion

To convert a decimal number to octal:
1. Divide the decimal number by 8
2. Record the remainder (0-7)
3. Use the quotient as the new number to divide
4. Repeat until the quotient is 0
5. The octal equivalent is the remainders read from bottom to top

For decimal fractions, the conversion is done by multiplying by the base and recording the integer parts.

### Octal and Hexadecimal Numbers

The conversion of binary to octal is done by grouping binary bits into 3-digit groups, starting from the radix point and proceeding to the left and right. The corresponding octal digit is then assigned to each binary digit group.

> [!example] Binary to Octal Conversion
> Binary number: 110110110
> Grouped in threes: 110 110 110
> Octal equivalent: 666

Conversion from binary to hexadecimal is similar, but the binary digit group is made up of 4 digits instead of 3.

> [!example] Binary to Hexadecimal Conversion
> Binary number: 110110110
> Grouped in fours (with padding): 1 1011 0110
> Hexadecimal equivalent: 1B6

Octal and hexadecimal provide easy conversions to and from binary, making the binary system easier to work with, as they require 3 and 4 times fewer digits, respectively, to convey the same information.

> [!tip] **Practical Application** 
> Most technical manuals use either octal or hexadecimal numbers to specify binary quantities.

## Complements of Numbers

_Complements_ are used by digital computers to simplify the **subtraction operation** and for logical manipulation.

There are two types of complements for each base-_r_ system: the _radix complement_ and the _diminished radix complement_. These are also known as the _r_'s complement and _(r-1)_'s complement. When the value of the base _r_ is substituted in the name (e.g., 2 for binary, 10 for decimal), the two types are referred to as the 2's complement and 1's complement for binary numbers, and the 10's complement and 9's complement for decimal numbers.

### Diminished Radix Complement (r-1)´s

Given a number _N_ in base _r_ with _n_ digits, the (r-1)´s complement of _N_ is generally defined as $(r^n - 1) - N$.

- **For decimal (r=10)**: This is the 9's complement. Since $10^n$ is a 1 followed by _n_ zeros, $10^n - 1$ is a number with _n_ nines (e.g., 9999 for n=4). It follows that the 9's complement of a decimal number is found by subtracting each digit from 9.

> [!example] 9's Complement
> $546700 \rightarrow 999999 - 546700 = 453299$
> $012398 \rightarrow 999999 - 012398 = 987601$

- **For a binary system (r=2)**: This is the 1's complement. A simple way to find the 1's complement is by changing all 1's to 0's and all 0's to 1's.

> [!example] 1's Complement
> Binary number: 1011001
> 1's complement: 0100110

### Radix Complement, r´s Complement ("2's Complement")

The r's complement of an _n_-digit number _N_ in base _r_ is generally defined as $r^n - N$ when _N ≠ 0_, and 0 when _N = 0_.

> [!note] **Relationship** 
> The r's complement is obtained by adding 1 to the (r-1)´s complement, since $r^n - N = ((r^n - 1) - N) + 1$. The complement of the complement gives the original value, similar to how $--x$ gives $+x$.

- **For decimal (r=10)**: This is the 10's complement. It is found by adding 1 to the 9's complement. For example, the 10's complement of 2389 is $7610 + 1 = 7611$. Since decimal doesn't have issues with subtraction, it's rarely necessary to use complements.

- **For binary (r=2)**: This is the 2's complement. A simple way to convert a binary value to its 2's complement is to read from right to left until you reach the first 1. Leave that 1 and all bits to its right unchanged. Then, change all remaining 1's to 0's and 0's to 1's.

> [!example] **Finding the 2's Complement** 
> For the binary number `10010`:
> - Read from right to left. The first 1 is the second from the right.
> - Leave `10` unchanged.
> - Flip the remaining bits `100` to `011`.
> - The 2's complement is `01110`.

- **For Octal and Hex**: The (r-1)´s complement is obtained similarly to decimals, by subtracting each digit from the maximum value (7 for octal, F for hexadecimal).

- **For Octal and Hex**: It's the same as for decimal; add 1 to the (r-1)´s complement.

### Subtraction using complements

While direct subtraction of decimal numbers uses the borrow concept and the "-" operator, subtraction implemented with digital hardware is more complex, as we cannot directly generate a negative value using only 0s and 1s.

In general, the subtraction of two _n_-digit unsigned numbers _M_ and _N_ (M - N) in base _r_ follows these rules:

1. Add M to the r's complement of N
2. If an end carry is produced, discard it
3. The result is M - N

This can be applied to any base system, but it is most notably used in the binary system for digital computers.

The same operation can also be done using (r-1)´s complements:

1. Add M to the (r-1)'s complement of N
2. If an end carry is produced, add it to the result (this is called an end-around carry)
3. The result is M - N

> [!example] Subtraction using 2's Complement
> To calculate 10101 - 10011:
> 
> 1. Find the 2's complement of 10011:
>    - 1's complement: 01100
>    - Add 1: 01101
> 
> 2. Add 10101 + 01101:
>    ```
>      10101
>    + 01101
>    -------
>     100010
>    ```
> 
> 3. Discard the end carry (leftmost 1), leaving 0010 (2 in decimal)

> [!example] Subtraction using 1's Complement
> To calculate 10101 - 10011:
> 
> 4. Find the 1's complement of 10011: 01100
> 
> 5. Add 10101 + 01100:
>    ```
>      10101
>    + 01100
>    -------
>     100001
>    ```
> 
> 6. Add the end carry to the result:
>    ```
>      00001
>    +     1
>    -------
>      00010
>    ```
> 
> 7. The result is 0010 (2 in decimal)

> [!summary]
> Digital systems manipulate discrete information using binary digits (bits) that have values of 0 or 1. Binary numbers follow a positional system where each bit is multiplied by a power of 2. Converting between number systems involves different techniques: decimal to binary uses division by 2, while binary to octal/hexadecimal uses grouping of bits. Complements (1's and 2's for binary) are essential for simplifying subtraction operations in digital computers, allowing subtraction to be performed as addition operations. The 2's complement method is particularly important in digital systems as it provides an efficient way to handle negative numbers and perform arithmetic operations.