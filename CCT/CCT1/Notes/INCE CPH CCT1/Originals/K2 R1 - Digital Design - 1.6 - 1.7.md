#CE #CCT1 
- - -
## Table of Contents

- [[#Signed Binary Numbers|Signed Binary Numbers]]
	- [[#Signed Binary Numbers#Arithmatic Addition|Arithmatic Addition]]
	- [[#Signed Binary Numbers#Arithmetic Subtraction|Arithmetic Subtraction]]
- [[#Binary Codes|Binary Codes]]
	- [[#Binary Codes#BCD|BCD]]
		- [[#BCD#BCD Addition|BCD Addition]]

### Signed Binary Numbers
In decimal, positive integers are represented with *unsigned* numbers, while negative are signed using a minus '-' as a pseudo-integer.
Because of hardware/analog limitations computers **must** represent everything with the binary number system, which doesn't have the minus negative-sign. 
It is customary to represent the sign with a bit placed in the leftmost position of the number. The convention is to make the sign bit 0 for positive and 1 for negative.
*The user determines whether the number is signed or unsigned.*

If the binary number is signed, then the leftmost bit represents the sign and the rest of the bits represent the number. If the binary number is assumed to be unsigned, then the leftmost bit is the most significant bit of the number. For example, the string of bits 01001 can be considered as 9 (unsigned binary) or as +9 (signed binary). The string of bits 11001 represents the binary equivalent of 25 when considered as an unsigned number and the binary equivalent of -9 when considered as a signed number.
Usually, there is no confusion in interpreting the bits if the type of representation for the number is known in advance.

The representation of the signed numbers is referred to as the signed‐magnitude convention.

When arithmetic operations are implemented in a computer, it is more convenient to use a different system, referred to as the *signed‐ complement system*, for representing negative numbers.
	In this system a *signed* negative is indicated by replacing the number with its complement [[INCE CPH CCT1/Originals/K1 R1 - Digital Design - 1.1-1.5]]. 
	This system can use either r-1's or r's, however r's is most commonly used

The decimal number '9' can be represented using 8 bits (2x4).
``0001 0001``
The positive integer bit '0' is signed on the left-most position to emphasize the integer is **PLUS** 9
``0 0001 0001``
Equally, the negative integer bit '1' is signed on the left-most, to empasize the *negative* integer of 9, **MINUS** 9.
``1 0001 0001``.
![[Pasted image 20250916213122.png]]

*In signed magnitude* the negative integer is obtained from the positive, by simply changing the signed-bit in the left-most position. *In signed complement* the negative is obtained by complementing all bits of the positive *includeing the sign bit*. 
![[Pasted image 20250916213433.png]]

#### Arithmatic Addition
The addition of 2 numbers in *signed magnitude* follows the same rules as ordinary arithmatic using decimal.
Taking the smaller magnitude and subtracting it from the larger, giving the diffrence the sign of the larger.
![[Pasted image 20250916213720.png]]
*The process requires comparison of signs, and magnitudes. Then performing either addition or subtraction*

In the *signed-complement*, the process requires only addition, with no comparison.
**The addition of two signed binary numbers with negative numbers represented in signed‐2’s‐complement form is obtained from the addition of the two numbers, including their sign bits. A carry out of the sign‐bit position is discarded.**
![[Pasted image 20250916214149.png]]

#### Arithmetic Subtraction
Subtraction of 2 signed, binary numbers when using *signed-complements* in r's-form is simple:
Take the r’s complement of the subtrahend (including the sign bit) and add it to the minuend (including the sign bit). A carry out of the sign‐bit position is discarded.
![[Pasted image 20250916214405.png]]

### Binary Codes
Any discrete element of information that is distinct among a group of quantities can be represented with a binary code (i.e., a pattern of 0’s and 1’s).
	An *n*-bit r=2 (binary) code, is a group of *n* bits, assuming up to 2^n combinations of 0's & 1's, with each combination representing an element of the set that is being coded.
	Each element **must** be assigned a unique binary bit-combination, and no two elements can have the same.
	The *minimum* number of bits required to code 2^n distinct quantities is *n*, but there's NO *maximum* number of bits that can be used.

Most people are more accustomed to the decimal-system, than the binary system; however the computer itself needs the binary in order to perform the arithmetic. 
	One way to resolve this issue, it to convert the human-readable decimal numbers into binary, perform the operations needed, and convert the binary answer back into decimal.
	This requires that we store the decimal numbers in the computer, so they can be converted to binary

A Binary code will have some unassigned bit combinations, if the number of elements are not a multiple power of 2.
	if you use the 10 decimal digits as an example of a set of elements, all 10 elements can be contained with 4 bits, but 6 out of the 16 total combinations possible using 4 bits (2^4) will be unassigned.

The binary code most commonly used for encoding decimal digits is *the straight binary assignment table*
![[Pasted image 20250917065417.png]]
This scheme is also called *binary-coded decimal* (BCD). This is by no means the only decimal code.

#### BCD
BCD gives 4 bits per decimal digit. Meaning a number with *k* amount of digits will require *4 x k* bits with BCD.
![[Pasted image 20250917065813.png]]
	***the binary combinations 1010 & 1111 are NOT used, and have no meaning, in BCD

##### BCD Addition
Since each individual digit cannot exceed 9, the sum cannot be great than a multiplication of 9 plus any remainders, and possible carry from a previous, less significant, pair of digits.
```
19 =/= 10 + 9 --> 9 + 9 + 1
```

In binary this range will be from 0000 (0) to 10011 (16 + 2 + 1), in BCD however; it's from 0000 (0) to 1 1001, the first (left-most) digit *1* being a carry and the next byte (4-bits) being the BCD sum.

When the binary sum is <= 1001 (without a carry), the corresponding BCD digit is correct.
When the binary sum is >= ``1010``, the result is an invalid BCD digit.
	The addition of 6 (`0110`) to the binary sum, converts it to the correct digit, and produces a carry as required.
	This is because a carry in the most significant position of fthe bit sum, and a decimal carry differ by 6
	![[Pasted image 20250917074321.png]]

![[Pasted image 20250917074354.png]]
	In the first case, the sum is = 9 and is also the correct BCD
	In the second case, the sum is an invalid BCD digit, so ``0110`` is added to produce the correct BCD and carry
	In the third case, the binary sum produces a cary. This occurs when the sum is great than or equal to 16. Though the other byte is less than 1001, the binary requires correction because of the carry. Adding ``0110`` we again get the right BCD and carry

In each case, the two BCD digits are added as if they are two binary numbers. Following the rules described earlier, if the binary sum is greater or equal to ``1010``, we add ``0110`` to obtain the correct BCD-sum and carry.

The addition of 2 *n*-digit *unsigned* BCD numbers, follows the same procedure
![[Pasted image 20250917075315.png]]
The first, least significant (right-most) pair of BCD-digits produces a BCD-digit-sum of 0000, and a carry for the next pair.
	The third pair of digits plus a carry, produces a binary sum of `0111`, and doesn't require correction.

