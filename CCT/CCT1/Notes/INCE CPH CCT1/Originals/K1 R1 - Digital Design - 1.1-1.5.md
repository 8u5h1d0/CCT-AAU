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
Created: 10-11-25
---
- - -

### Digital Systems
Digital systems represent and manipulate discrete elements of information.
Any set involving a finite set of numbers, contains discrete information. For example, the 10 digits in the decimal system, or the 52 cards in a deck.

In the case of *digital* computers, the discrete elements are digits.
These elements are represented with physical quantities that we call *signals*, in a modern computer these are electrical signals such as a change in voltage or current.
Electronic signals systems used today use just 2 disceret signals, and is therefore called a *binary* system.

a binary digit is called a *bit*.
a bt can have one of two vaues,: 1, or 0.
discrete elements are represented with groups of bits *binary codes*.

How a pattern of bits in interpreted depends on the code-system in which it resides.

A **digital-system** is an interconnection of *digital modules*, and **to understand the operation of each of these modules, it is neccesary to have at least a basic understanding of the digital circuits within, and their logical function**

A major trend in digital design, is the us of a HDL (hardware description language) to describe, and simulate, the function of a digital circuit before building it.
A HDL resembles a programming language, and is used to textually describe digital circuits.
It is also used to simulate a digital system, to verify operation.
**it is important, students become familiar with HDL-based design methodology**


### Binary Numbers
A decimal number such as 2000 represents a quantity equal 2x1000 0x100 0x10 0x1 ...
These are all powers of 10, with the power to the specific digit being implied by its position.
So the number 2000, is shorthand notation of 
`2x10^3 + 0x10^2 + 0x10^1 + 0x10^...`
The convention is to write on the numeric coefficient(s), and from their position deduce the neccesary power of the numerator (in thes example the power of 10), increaseing from right to left.
![[Pasted image 20250910082229.png]]

Any number system has a *base* also known as a *radix*, in the case of the decimal system the radix is 10, as it uses 10 digits 0 through 9, and the coefficients are multiplied by powers of 10.

The ***binary*** system is also a numeric system.
The coefficients of binary only has 2 values: 1, 0.
The coefficient is multiplied by the radix (2^x), and the result(s) are added to obtain the decimal-number-equivalent.

The radix point distinguishes positive  powers of 10 from negative.
For example **binary** 11010 . 11 is equivalent to **decimal** 26.75.
```
1 1 0 1 0 . 1 1
1x2^4 + 1*2^3 + 0x2^2 + 1x2^1 + 0x2^0 + 1x2^-1 + 1x2^-2
```
I general a base-*r*-system has coefficients multiplied by the power of *r*.
The coefficients range from 0 to *r*-1

![[Pasted image 20250910093847.png]]
![[Pasted image 20250910093858.png]]

### Number-Base Conversions
Representations of numbers in diffrent radix are said to be equivalent, if they have the same decimal representation.
For example (0011) in r=8 and (1001) in binary are equal as they both have decimal value 9.
```
0x8^3 + 0x8^2 + 1x8^1 + 1x8^0 = 0 + 0 + 8 + 1 = 8 + 1 = 9
1x2^3 + 0x2^2 + 0x2^1 + 1x2^0 = 8 + 0 + 0 + 1 = 8 + 1 = 9
```
If the number included a radix-point, it is neccesary to spit the number into a an integer part, and a fraction part.

Each part must be converted diffrently.
Conversion from **decimal** to base-*r*, is done by dividing the number and all successive quotients by *r* and accumulating the remains.

#### Conversion from decimal to binary
![[Pasted image 20250910100515.png]]
![[Pasted image 20250910100726.png]]

#### Decimal to octal (base-8)
![[Pasted image 20250910102651.png]]

As stated under the decimal to octal conversion. A *fraction* is converted similarly to an *integer*, with an inverse opperator (multiplication, instead of division). 

![[Pasted image 20250910112607.png]]
![[Pasted image 20250910112649.png]]

### Octal and Hexadecimal Numbers
![[Pasted image 20250910112817.png]]
The conversion of binary to octal is done by grouping binary bits into 3 digit groups, starting from the radix-point and proceeding to the left and right. The corresponding octal digit is then assigned to each binary digit group.
![[Pasted image 20250910113347.png]]
Conversion from binary to hex is similar, but the binary digit group is made up of 4 digits instead of 3.
![[Pasted image 20250910113524.png]]

Octal and hex provide easy conversions to and from binary, making the two-digit system easier to work with as they require 3 and 4 times less digits to convey the same information.

It can be neccesary for the human operator to interact with the machine directly through the binary numbers it operates from. These easy conversion can be used to more effectively communicate between people, about theese binary numbers.

**most manuals use either octal or hex numbers to specify binary quantities**

### Complements of Numbers
*Complements* are used by digital computers to simplify the **subtractions operation**, and for logical manipulation.

2 types of complements for each base-*r* system,:
*radix*-complement, and *dimished-radix*-complement. Also known as *r*´s complement and *r-1*´s complement.
When the value of the base r is substituted in the name, for example with 2 for base-2 and 10 for decimal, the two types are referred to as the 2’s complement and 1’s complement for binary numbers and the 10’s complement and 9’s complement for decimal numbers.

#### Diminished Radix Complement (r-1)´s
Given that the number *N* in base *r* has *n* digits, the r-1´s complement of N is generally defined as (r^n-1)-N.
For decimal 
	*r*=10, r-1=9. So 9´s complement of N is (10^n -1)-1
	where 10^n represents a number consistent of a 1 followed by *n* 0´s.
		For n=4 this would be 10^4 = 10000 and 10^4 - 1 = 10000-1 = 9999
	It follows that 9´s complement of a decimal number is found by subtracting each digit from 9
	```
	546700 = 999999 - 546700 = 453299
	012398 = 999999 - 012398 = 987601
	```
For a binary system
	a simple way to find 1´s complement, is by changing 1´s to 0´s an 0´s to 1´s
	![[Pasted image 20250910154502.png]]
For Octal and Hex
	(r-1)´s complement is obtained similarly to decimals, by subtracting each digit from the maximum value (7 or F)

#### Radix Complement (r)´s
The complement of an *n*-digit number (N) in base *r*, is generally defined as r^n - N when N =/= 0 and 0 when N = 0.
*Note: Compared to (r-1)´s (r)´s is obtained by adding 1 to (r-1)´s, as r^n-N = ((r^n-1)-N)+1*
The complement of the complement give the original value, similarly to -- givnng +
For decimal
	10´s complement of decimal value 2389 is 7610(+1) = 7611, as 9´s value is 7610
	as decimal doesn´t have any issues using subtraction operators, t´s never really neccesary to use complements
For binary
	a simple way to convert a binary value to 2´s is to from right to left, read utill you reach the first 1, and from there change 1´s and 0´s like in (r-1)´s
	`10010 becomes 01110`
	![[Pasted image 20250910161813.png]]
For Octal and Hex
	it´s the same as for decimal

#### Subtraction using components
While direct subtraction of decimal numbers is taught in primary school, and uses the borrow concept and "-" operator.
Subtraction implemented with digital hardware however, is more complicated. as we cannot get or generate a directly negative value; only 0 and 1.
In general subtraction of two *n*-digit unsigned numbers *M* and *N* (M - N), in base *r* follows 3 rules:
![[Pasted image 20250910162323.png]]

this can be applied to any base system, but is most ontably used in the binary system for digital computers
![[Pasted image 20250910162443.png]]

the same operation can also be done using (r-1)´s
![[Pasted image 20250910162600.png]]

