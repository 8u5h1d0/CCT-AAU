---
tags:
  - "#CCT2"
  - DS
Topic: Divisibility | Primes | GCD | LCM | Euclid's Algo. | Congruences | Arithm. Modulo - Inverses, linear congruences, chinese remainder theorem | Solving a system of linear congruences | The small Fermat's theorem
Semester: CCT2
Course: Diskrete strukturer
Litterature:
  - Discrete Mathematics and Its Applications - 8th Ed.
Created: 17-02-2026
---
- - -
  # Table of Contents

1. [[#Number Theory and Cryptography|Number Theory and Cryptography]]
	1. [[#Number Theory and Cryptography#Divisibility and Modular Arithmetic|Divisibility and Modular Arithmetic]]
		1. [[#Divisibility and Modular Arithmetic#Introduction|Introduction]]
		2. [[#Divisibility and Modular Arithmetic#Division|Division]]
		3. [[#Divisibility and Modular Arithmetic#The Division Algorithm|The Division Algorithm]]
		4. [[#Divisibility and Modular Arithmetic#Modular Arithmetic|Modular Arithmetic]]
		5. [[#Divisibility and Modular Arithmetic#Arithmetic Modulo $m$|Arithmetic Modulo $m$]]
	2. [[#Number Theory and Cryptography#Primes and Greatest Common Divisors|Primes and Greatest Common Divisors]]
		1. [[#Primes and Greatest Common Divisors#Introduction|Introduction]]
		2. [[#Primes and Greatest Common Divisors#Primes|Primes]]
		3. [[#Primes and Greatest Common Divisors#Trial Division|Trial Division]]
		4. [[#Primes and Greatest Common Divisors#The Sieve of Eratosthenes|The Sieve of Eratosthenes]]
		5. [[#Primes and Greatest Common Divisors#The Infinitude of Primes|The Infinitude of Primes]]
		6. [[#Primes and Greatest Common Divisors#The Distribution of Primes|The Distribution of Primes]]
		7. [[#Primes and Greatest Common Divisors#Primes and Arithmetic Progressions|Primes and Arithmetic Progressions]]
		8. [[#Primes and Greatest Common Divisors#Conjectures and Open Problems About Primes|Conjectures and Open Problems About Primes]]
		9. [[#Primes and Greatest Common Divisors#Greatest Common Divisors and Least Common Multiples|Greatest Common Divisors and Least Common Multiples]]
		10. [[#Primes and Greatest Common Divisors#The Euclidean Algorithm|The Euclidean Algorithm]]
		11. [[#Primes and Greatest Common Divisors#GCDs as Linear Combinations|GCDs as Linear Combinations]]
	3. [[#Number Theory and Cryptography#Solving Congruences|Solving Congruences]]
		1. [[#Solving Congruences#Introduction|Introduction]]
		2. [[#Solving Congruences#Linear Congruences|Linear Congruences]]
		3. [[#Solving Congruences#The Chinese Remainder Theorem|The Chinese Remainder Theorem]]
		4. [[#Solving Congruences#Computer Arithmetic with Large Integers|Computer Arithmetic with Large Integers]]
		5. [[#Solving Congruences#Fermat’s Little Theorem|Fermat’s Little Theorem]]
		6. [[#Solving Congruences#Pseudoprimes|Pseudoprimes]]
		7. [[#Solving Congruences#Primitive Roots and Discrete Logarithms|Primitive Roots and Discrete Logarithms]]

# Number Theory and Cryptography
## Divisibility and Modular Arithmetic
### Introduction
Dividing an integer by a positive integer results in a quotient and a remainder. The process of working with these remainders leads to modular arithmetic, which is a crucial concept in both mathematics and computer science.

> [!info] Applications of Modular Arithmetic
> Modular arithmetic is utilized for several important practical applications, including:
> - Generating pseudorandom numbers
> - Assigning computer memory locations to files
> - Constructing check digits
> - Encrypting messages

### Division
When one integer is divided by a second nonzero integer, the quotient may or may not be an integer. For instance, $12/3 = 4$ is an integer, whereas $11/4 = 2.75$ is not.

> [!summary] Definition - "Division"
> If $a$ and $b$ are integers with $a \neq 0$, we say that $a$ divides $b$ if there is an integer $c$ such that $b = ac$ (or equivalently, if $b/a$ is an integer).
> - When $a$ divides $b$, we say that $a$ is a _factor_ or _divisor_ of $b$, and that $b$ is a _multiple_ of $a$.
> - The notation $a \mid b$ denotes that $a$ divides $b$.
> - We write $a \nmid b$ when $a$ does not divide $b$.
> - **Remark:** We can express $a \mid b$ using quantifiers as $\exists c(ac = b)$, where the universe of discourse is the set of integers.

> [!example] Divisibility Check
> **Problem:** Determine whether $3 \mid 7$ and whether $3 \mid 12$.
> 
> **Solution:**
> - $3 \nmid 7$, because $7/3$ is not an integer.
> - $3 \mid 12$, because $12/3 = 4$.

> [!example] Counting Multiples
> **Problem:** Let $n$ and $d$ be positive integers. How many positive integers not exceeding $n$ are divisible by $d$?
> 
> **Solution:** The positive integers divisible by $d$ are all the integers of the form $dk$, where $k$ is a positive integer. To find the number of such integers not exceeding $n$, we must count the integers $k$ with $0 < dk \le n$. Dividing the inequality by $d$, this is equivalent to $0 < k \le n/d$. Therefore, there are $\lfloor n/d \rfloor$ positive integers not exceeding $n$ that are divisible by $d$.

> [!summary] Theorem - "Properties of Divisibility"
> Let $a$, $b$, and $c$ be integers, where $a \neq 0$.
> 1. If $a \mid b$ and $a \mid c$, then $a \mid (b + c)$.
> 2. If $a \mid b$, then $a \mid bc$ for all integers $c$.
> 3. If $a \mid b$ and $b \mid c$, then $a \mid c$.
> 
> ![[Pasted image 20260217161359.png]]
> 
> Proof:
> **(i)** Suppose that $a \mid b$ and $a \mid c$. Then, from the definition of divisibility, it follows that there are integers $s$ and $t$ with $b = as$ and $c = at$. Hence, $b + c = as + at = a(s + t)$. Therefore, $a$ divides $b + c$.
> 
> **(ii)** Suppose that $a \mid b$. Then, by definition, there is an integer $s$ such that $b = as$. Multiplying both sides of this equation by $c$ gives $bc = (as)c = a(sc)$. Since $sc$ is an integer, it follows that $a \mid bc$.
> 
> **(iii)** Suppose that $a \mid b$ and $b \mid c$. Then, by definition, there are integers $s$ and $t$ such that $b = as$ and $c = bt$. Substituting $as$ for $b$ in the equation $c = bt$, we obtain $c = (as)t = a(st)$. Since $st$ is an integer, it follows that $a \mid c$.

> [!summary] Corollary - "Divisibility of Integer Combinations"
> If $a$, $b$, and $c$ are integers, where $a \neq 0$, such that $a \mid b$ and $a \mid c$, then $a \mid mb + nc$ whenever $m$ and $n$ are integers.
> 
> Proof:
> We will give a direct proof. By part (ii) of Theorem "Properties of Divisibility" we see that $a \mid mb$ and $a \mid nc$ whenever $m$ and $n$ are integers. By part (i) of Theorem "Properties of Divisibility" it follows that $a \mid mb + nc$.

### The Division Algorithm
When an integer is divided by a positive integer, there is a quotient and a remainder, as the division algorithm shows.

> [!summary] Theorem - "The Division Algorithm"
> Let $a$ be an integer and $d$ a positive integer. Then there are unique integers $q$ and $r$, with $0 \le r < d$, such that $a = dq + r$.

> [!summary] Definition - "Divisor, Dividend, Quotient, Remainder"
> In the equality given in the division algorithm:
> - $d$ is called the **divisor**.
> - $a$ is called the **dividend**.
> - $q$ is called the **quotient**.
> - $r$ is called the **remainder**.
> 
> This notation is used to express the quotient and remainder: $q = a \text{ div } d$, $r = a \text{ mod } d$.
> 
> **Note:** Both $a \text{ div } d$ and $a \text{ mod } d$ for a fixed $d$ are functions on the set of integers. Furthermore, when $a$ is an integer and $d$ is a positive integer, we have $a \text{ div } d = \lfloor a/d \rfloor$ and $a \text{ mod } d = a - d \lfloor a/d \rfloor$.

> [!example]
> **Problem:** What are the quotient and remainder when 101 is divided by 11?
> 
> **Solution:** We have $101 = 11 \cdot 9 + 2$.
> - Here, $a = 101$, $d = 11$, $q = 9$, and $r = 2$.
> - Hence, the quotient is $9 = 101 \text{ div } 11$.
> - The remainder is $2 = 101 \text{ mod } 11$.

> [!example]
> **Problem:** What are the quotient and remainder when $-11$ is divided by $3$?
> 
> **Solution:** We have $-11 = 3 \cdot (-4) + 1$.
> - Hence, the quotient is $-4 = -11 \text{ div } 3$.
> - The remainder is $1 = -11 \text{ mod } 3$.
> 
> **Note:** The remainder cannot be negative. Consequently, the remainder is not $-2$, even though $-11 = 3(-3) - 2$, because $r = -2$ does not satisfy the condition $0 \le r < d$ (in this case, $0 \le r < 3$).

The integer $a$ is divisible by the integer $d$ if and only if the remainder is zero when $a$ is divided by $d$.
### Modular Arithmetic
In some situations we care only about the remainder of an integer when it is divided by some specified positive integer. For instance, when we ask what time it will be (on a 24-hour clock) 50 hours from now, we care only about the remainder when 50 plus the current hour is divided by 24.

Because we are often interested only in remainders, we have special notations for them. We use the notation `a mod m` to represent the remainder when an integer $a$ is divided by the positive integer $m$. A different, but related, notation is ***congruence***, which indicates that two integers have the same remainder when they are divided by the positive integer $m$.

> [!summary] Definition - "Congruence Modulo m"
> If $a$ and $b$ are integers and $m$ is a positive integer, then $a$ is congruent to $b$ modulo $m$ if $m$ divides $a - b$. We use the notation $a \equiv b \pmod m$ to indicate that $a$ is congruent to $b$ modulo $m$. We say that $a \equiv b \pmod m$ is a congruence and that $m$ is its modulus (plural moduli). If $a$ and $b$ are not congruent modulo $m$, we write $a \not\equiv b \pmod m$.

Although both notations $a \equiv b \pmod m$ and $a \bmod m = b$ include "mod," they represent fundamentally different concepts. The first represents a relation on the set of integers, whereas the second represents a function. However, the relation $a \equiv b \pmod m$ and the `mod m` function are closely related.

> [!summary] Theorem - "Equivalence of Congruence and Mod Function"
> Let $a$ and $b$ be integers, and let $m$ be a positive integer. Then $a \equiv b \pmod m$ if and only if $a \bmod m = b \bmod m$.

> [!example]
> **Problem:** Determine whether $17$ is congruent to $5$ modulo $6$ 
> and whether $24$ and $14$ are congruent modulo $6$.
> 
> **Solution:**
> - Because $6$ divides $12 = 17 - 5$, we see that $17 \equiv 5 \pmod 6$.
> - However, because $10 = 24 - 14$ is not divisible by $6$, we see that $24 \not\equiv 14 \pmod 6$.

> [!summary] Theorem - "Alternative Characterization of Congruence"
> Let $m$ be a positive integer. The integers $a$ and $b$ are congruent modulo $m$ if and only if there is an integer $k$ such that $a = b + km$.
> 
> Proof:
> If $a \equiv b \pmod m$, by the definition of congruence, we know that $m \mid (a - b)$.
> This means that there is an integer $k$ such that $a - b = km$, so that $a = b + km$. 
> Conversely, if there is an integer $k$ such that $a = b + km$, then $km = a - b$. Hence, $m$ divides $a - b$, so that $a \equiv b \pmod m$.

> [!summary] Definition - "Congruence Class"
> The set of all integers congruent to an integer $a$ modulo $m$ is called the **congruence class** of $a$ modulo $m$.
> ![[Pasted image 20260218091342.png]]

> [!summary] Theorem - "Addition and Multiplication in Modular Arithmetic"
> Let $m$ be a positive integer. If $a \equiv b \pmod m$ and $c \equiv d \pmod m$, then $a + c \equiv b + d \pmod m$ and $ac \equiv bd \pmod m$.
> 
> Proof:
> Because $a \equiv b \pmod m$ and $c \equiv d \pmod m$, there are integers $s$ and $t$ with $b = a + sm$ and $d = c + tm$. Hence:
> $b + d = (a + sm) + (c + tm) = (a + c) + m(s + t)$
> and
> $bd = (a + sm)(c + tm) = ac + m(at + cs + stm)$.
> Hence, $a + c \equiv b + d \pmod m$ and $ac \equiv bd \pmod m$.

> [!example]
> Because $7 \equiv 2 \pmod 5$ and $11 \equiv 1 \pmod 5$, it follows that:
> - $18 = 7 + 11 \equiv 2 + 1 = 3 \pmod 5$
> - $77 = 7 \cdot 11 \equiv 2 \cdot 1 = 2 \pmod 5$

We must be careful working with congruences. Some properties we may expect to be true are not valid. For example, if $ac \equiv bc \pmod m$, the congruence $a \equiv b \pmod m$ may be false. Similarly, if $a \equiv b \pmod m$ and $c \equiv d \pmod m$, the congruence $ac \equiv bd \pmod m$ may be false. 

> [!summary] Corollary - "Modular Reduction of Sums and Products"
> Let $m$ be a positive integer and let $a$ and $b$ be integers. Then:
> $(a + b) \bmod m = ((a \bmod m) + (b \bmod m)) \bmod m$
> and
> $ab \bmod m = ((a \bmod m)(b \bmod m)) \bmod m$.
> 
> Proof:
> By the definitions of `mod m` and of congruence modulo $m$, we know that $a \equiv (a \bmod m) \pmod m$ and $b \equiv (b \bmod m) \pmod m$. Hence, the theorem "Addition and Multiplication in Modular Arithmetic" tells us that $a + b \equiv (a \bmod m) + (b \bmod m) \pmod m$ and $ab \equiv (a \bmod m)(b \bmod m) \pmod m$.

> [!example]
> **Problem:** Find the value of $(19^3 \bmod 31)^4 \bmod 23$.
> 
> **Solution:** To compute $(19^3 \bmod 31)^4 \bmod 23$, we will first evaluate $19^3 \bmod 31$.
> - Because $19^3 = 6859$ and $6859 = 221 \cdot 31 + 8$, we have $19^3 \bmod 31 = 6859 \bmod 31 = 8$.
> - So, $(19^3 \bmod 31)^4 \bmod 23 = 8^4 \bmod 23$.
> - Next, note that $8^4 = 4096$.
> - Because $4096 = 178 \cdot 23 + 2$, we have $4096 \bmod 23 = 2$.
> - Hence, $(19^3 \bmod 31)^4 \bmod 23 = 2$.
### Arithmetic Modulo $m$
We can define arithmetic operations on $\mathbb{Z}_m$, the set of nonnegative integers less than $m$, that is, the set $\{0, 1, \dots, m - 1\}$.

> [!summary] Definition - "Addition and Multiplication Modulo m"
> For integers $a$ and $b$ in $\mathbb{Z}_m$:
> - **Addition modulo $m$**, denoted by $+_m$, is defined by $a +_m b = (a + b) \bmod m$.
> - **Multiplication modulo $m$**, denoted by $\cdot_m$, is defined by $a \cdot_m b = (a \cdot b) \bmod m$.
> 
> In these definitions, the addition and multiplication on the right-hand side are ordinary integer operations. When using these operations, we are said to be doing arithmetic modulo $m$.

> [!example] Arithmetic in $\mathbb{Z}_{11}$
> **Problem:** Use the definition of addition and multiplication in $\mathbb{Z}_{11}$ to find $7 +_{11} 9$ and $7 \cdot_{11} 9$.
> 
> **Solution:**
> - **Addition:** $7 +_{11} 9 = (7 + 9) \bmod 11 = 16 \bmod 11 = 5$.
> - **Multiplication:** $7 \cdot_{11} 9 = (7 \cdot 9) \bmod 11 = 63 \bmod 11 = 8$.
> 
> Hence, $7 +_{11} 9 = 5$ and $7 \cdot_{11} 9 = 8$.

The operations $+_m$ and $\cdot_m$ satisfy many of the same properties of ordinary addition and multiplication of integers.

> [!summary] **Properties of Modular Arithmetic Operations**
>
> **Closure:** Adding or multiplying any two numbers in this set will always produce a result that is also in the set.
> $a +_m b$ and $a \cdot_m b$ belong to $\mathbb{Z}_m$
>
> **Associativity:** When combining three or more numbers, the way you group them does not change the result.
> $(a +_m b) +_m c = a +_m (b +_m c)$
> $(a \cdot_m b) \cdot_m c = a \cdot_m (b \cdot_m c)$
>
> **Commutativity:** The order in which you add or multiply two numbers does not change the final result.
> $a +_m b = b +_m a$
> $a \cdot_m b = b \cdot_m a$
>
> **Identity Elements:** Adding zero leaves a number unchanged, and multiplying a number by one leaves it unchanged.
> $a +_m 0 = 0 +_m a = a$
> $a \cdot_m 1 = 1 \cdot_m a = a$
>
> **Additive Inverses:** Every number has a specific counterpart that can be added to it to result in zero.
> If $a \neq 0$, then $m - a$ is an additive inverse of $a$ modulo $m$ ($a +_m (m - a) = 0$).
> $0$ is its own additive inverse ($0 +_m 0 = 0$).
>
> **Distributivity:** Multiplying a number by a sum is the same as multiplying the number by each part of the sum individually and then adding the results.
> $a \cdot_m (b +_m c) = (a \cdot_m b) +_m (a \cdot_m c)$
> $(a +_m b) \cdot_m c = (a \cdot_m c) +_m (b \cdot_m c)$

These properties follow from the properties of congruences, remainders, and integers.

> [!note] Multiplicative Inverses
> Note that every element of $\mathbb{Z}_m$ has an additive inverse, but no analogous property for multiplicative inverses has been included. This is because multiplicative inverses do not always exist modulo $m$. For instance, there is no multiplicative inverse of 2 modulo 6. The question of when an integer has a multiplicative inverse modulo $m$ will be addressed later.

> [!abstract] Algebraic Structures
> Because $\mathbb{Z}_m$ with the operations of addition and multiplication modulo $m$ satisfies the properties listed:
> - $\mathbb{Z}_m$ with modular addition is said to be a **commutative group**.
> - $\mathbb{Z}_m$ with both operations is said to be a **commutative ring**.
> 
> (Note: Groups and rings are studied in courses covering abstract algebra).

> [!note] Notation
> In later sections, the notations $+$ and $\cdot$ are often used for $+_m$ and $\cdot_m$ without the subscript $m$ on the operator symbol whenever it is clear that we are working with $\mathbb{Z}_m$.
## Primes and Greatest Common Divisors
### Introduction
One important concept based on divisibility is that of a prime number. The study of prime numbers goes back to ancient times. Thousands of years ago it was known that there are infinitely many primes; the proof of this fact, found in the works of Euclid, is famous for its elegance and beauty.

> [!summary] Definition - "Prime Number"
> A prime is an integer greater than 1 that is divisible by no positive integers other than 1 and itself.

We will introduce an important theorem, the fundamental theorem of arithmetic.

> [!summary] Theorem - "The Fundamental Theorem of Arithmetic"
> Every positive integer can be written uniquely as the product of primes in nondecreasing order.

This theorem has many interesting consequences. Primes have become essential in modern cryptographic systems.

> [!info] Cryptography and Primes
> - Finding large primes is essential in modern cryptography.
> - The length of time required to factor large integers into their prime factors is the basis for the strength of some important modern cryptographic systems.

We will develop an important algorithm for computing greatest common divisors, called the Euclidean algorithm.
### Primes
Every integer greater than 1 is divisible by at least two integers, because a positive integer is divisible by 1 and by itself. Positive integers that have exactly two different positive integer factors are called primes.

> [!summary] Definition - "Prime and Composite Numbers"
> An integer $p$ greater than 1 is called prime if the only positive factors of $p$ are 1 and $p$. A positive integer that is greater than 1 and is not prime is called composite.
> 
> **Remark:** The integer 1 is not prime, because it has only one positive factor. Note also that an integer $n$ is composite if and only if there exists an integer $a$ such that $a \mid n$ and $1 < a < n$.

> [!example]
> The integer 7 is prime because its only positive factors are 1 and 7, whereas the integer 9 is composite because it is divisible by 3 as well as 9 and 1.

> [!summary] Theorem - "Fundamental Theorem of Arithmetic"
> Every integer greater than 1 can be written uniquely as a prime or as the product of two or more primes, where the prime factors are written in order of nondecreasing size.
> 
> **Prime Factorization:** Every integer greater than 1 can be expressed as a product of prime numbers.
> $n = p_1 \cdot p_2 \cdots p_k$
>
> **Uniqueness:** This product of primes is unique for each integer, meaning there is only one distinct set of prime factors (ignoring order).
> $n = p_1^{e_1} p_2^{e_2} \cdots p_k^{e_k}$
>
> **Exponents:** When a prime factor appears multiple times, it is written using an exponent to condense the expression.
> $p \cdot p \cdots p = p^k$

> [!example]
> The prime factorizations of 100, 641, 999, and 1024 are given by:
> - $100 = 2 \cdot 2 \cdot 5 \cdot 5 = 2^2 5^2$
> - $641 = 641$
> - $999 = 3 \cdot 3 \cdot 3 \cdot 37 = 3^3 \cdot 37$
> - $1024 = 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 = 2^{10}$
### Trial Division
It is often important to show that a given integer is prime. For instance, in cryptology, large primes are used in some methods for making messages secret. One procedure for showing that an integer is prime is based on the observation that composite integers must have small prime factors.

> [!summary] Theorem - "Composite Numbers Have Small Prime Divisors"
> If $n$ is a composite integer, then $n$ has a prime divisor less than or equal to $\sqrt{n}$.
> 
> Proof:
> If $n$ is composite, by the definition of a composite integer, we know that it has a factor $a$ with $1 < a < n$. Hence, by the definition of a factor of a positive integer, we have $n = ab$, where $b$ is a positive integer greater than 1.
> 
> We will show that $a \le \sqrt{n}$ or $b \le \sqrt{n}$. If $a > \sqrt{n}$ and $b > \sqrt{n}$, then $ab > \sqrt{n} \cdot \sqrt{n} = n$, which is a contradiction. Consequently, $a \le \sqrt{n}$ or $b \le \sqrt{n}$. Because both $a$ and $b$ are divisors of $n$, we see that $n$ has a positive divisor not exceeding $\sqrt{n}$. This divisor is either prime or, by the fundamental theorem of arithmetic, has a prime divisor less than itself. In either case, $n$ has a prime divisor less than or equal to $\sqrt{n}$.

This theorem implies that an integer is prime if it is not divisible by any prime less than or equal to its square root. This leads to the brute-force algorithm known as **trial division**. To use trial division, we divide $n$ by all primes not exceeding $\sqrt{n}$ and conclude that $n$ is prime if it is not divisible by any of these primes.

> [!example] Proving Primality via Trial Division
> **Problem:** Show that 101 is prime.
> 
> **Solution:**
> The only primes not exceeding $\sqrt{101}$ are 2, 3, 5, and 7. Because 101 is not divisible by 2, 3, 5, or 7 (the quotient of 101 and each of these integers is not an integer), it follows that 101 is prime.

Because every integer has a prime factorization, it is useful to have a procedure for finding this prime factorization. Consider the problem of finding the prime factorization of $n$. Begin by dividing $n$ by successive primes, starting with the smallest prime, 2. If $n$ has a prime factor, then a prime factor $p$ not exceeding $\sqrt{n}$ will be found. 
So, if no prime factor not exceeding $\sqrt{n}$ is found, then $n$ is prime. Otherwise, if a prime factor $p$ is found, continue by factoring $n/p$. Note that $n/p$ has no prime factors less than $p$. Again, if $n/p$ has no prime factor greater than or equal to $p$ and not exceeding its square root, then it is prime. Otherwise, if it has a prime factor $q$, continue by factoring $n/(pq)$. This procedure is continued until the factorization has been reduced to a prime.

> [!example] Finding Prime Factorization
> **Problem:** Find the prime factorization of 7007.
> 
> **Solution:**
> To find the prime factorization of 7007, first perform divisions of 7007 by successive primes, beginning with 2.
> - None of the primes 2, 3, and 5 divides 7007.
> - However, 7 divides 7007, with $7007/7 = 1001$.
> 
> Next, divide 1001 by successive primes, beginning with 7.
> - 7 also divides 1001, because $1001/7 = 143$.
> 
> Continue by dividing 143 by successive primes, beginning with 7.
> - Although 7 does not divide 143, 11 does divide 143, and $143/11 = 13$.
> 
> Because 13 is prime, the procedure is completed. It follows that $7007 = 7 \cdot 1001 = 7 \cdot 7 \cdot 143 = 7 \cdot 7 \cdot 11 \cdot 13$.
> 
> Consequently, the prime factorization of 7007 is $7 \cdot 7 \cdot 11 \cdot 13 = 7^2 \cdot 11 \cdot 13$.
### The Sieve of Eratosthenes
_Note that **composite** integers not exceeding 100 must have a prime factor not exceeding 10._ 
Because the only primes less than 10 are 2, 3, 5, and 7, the primes not exceeding 100 are these four primes and those positive integers greater than 1 and not exceeding 100 that are divisible by none of 2, 3, 5, or 7.

The sieve of Eratosthenes is used to find all primes not exceeding a specified positive integer. For instance, the following procedure is used to find the primes not exceeding 100. We begin with the list of all integers between 1 and 100. To begin the sieving process, the integers that are divisible by 2, other than 2, are deleted. Because 3 is the first integer greater than 2 that is left, all those integers divisible by 3, other than 3, are deleted. Because 5 is the next integer left after 3, those integers divisible by 5, other than 5, are deleted. The next integer left is 7, so those integers divisible by 7, other than 7, are deleted. Because all ***composite*** integers not exceeding 100 are divisible by 2, 3, 5, or 7, all remaining integers except 1 are prime.

![[Pasted image 20260217201422.png]]

We conclude that the primes less than 100 are 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, and 97.

### The Infinitude of Primes
It has long been known that there are infinitely many primes. This means that whenever $p_1, p_2, \dots, p_n$ are the $n$ smallest primes, we know there is a larger prime not listed.

> [!summary] Theorem - "Infinitude of Primes"
> There are infinitely many primes.
> 
> Proof:
> We will prove this theorem using a proof by contradiction. 
> We assume that there are only finitely many primes, $p_1, p_2, \dots, p_n$. 
> Let $Q = p_1p_2 \cdots p_n + 1$. By the fundamental theorem of arithmetic, $Q$ is prime or else it can be written as the product of two or more primes. However, none of the primes $p_j$ divides $Q$, for if $p_j \mid Q$, then $p_j$ divides $Q - p_1p_2 \cdots p_n = 1$. 
> Hence, there is a prime not in the list $p_1, p_2, \dots, p_n$. 
> This prime is either $Q$, if it is prime, or a prime factor of $Q$. This is a contradiction because we assumed that we have listed all the primes. Consequently, there are infinitely many primes.

> [!note] Note on Constructiveness
> Note that in this proof we do not state that $Q$ is prime! Furthermore, in this proof, we have given a nonconstructive existence proof that given any $n$ primes, there is a prime not in this list. For this proof to be constructive, we would have had to explicitly give a prime not in our original list of $n$ primes.

Because there are infinitely many primes, given any positive integer there are primes greater than this integer. There is an ongoing quest to discover larger and larger prime numbers; for almost all the last 300 years, the largest prime known has been an integer of the special form $2^p - 1$, where $p$ is also prime. (Note that $2^n - 1$ cannot be prime when $n$ is not prime). Such primes are called Mersenne primes. The reason that the largest known prime has usually been a Mersenne prime is that there is an extremely efficient test, known as the Lucas–Lehmer test, for determining whether $2^p - 1$ is prime. Furthermore, it is not currently possible to test numbers not of this or certain other special forms anywhere near as quickly to determine whether they are prime.

> [!example]
> The numbers $2^2 - 1 = 3$, $2^3 - 1 = 7$, $2^5 - 1 = 31$, and $2^7 - 1 = 127$ are Mersenne primes, while $2^{11} - 1 = 2047$ is not a Mersenne prime because $2047 = 23 \cdot 89$.

### The Distribution of Primes
There are infinitely many primes. However, how many primes are less than a positive number $x$?

> [!summary] Theorem - "The Prime Number Theorem"
> The ratio of $\pi(x)$, the number of primes not exceeding $x$, and $x / \ln x$ approaches 1 as $x$ grows without bound. (Here $\ln x$ is the natural logarithm of $x$).

![[Pasted image 20260217202103.png]]

### Primes and Arithmetic Progressions
Every odd integer is in one of the two arithmetic progressions $4k + 1$ or $4k + 3$, $k = 1, 2, \dots$. Because we know that there are infinitely many primes, we can ask whether there are infinitely many primes in both of these arithmetic progressions. The primes 5, 13, 17, 29, 37, 41, ... are in the arithmetic progression $4k + 1$; the primes 3, 7, 11, 19, 23, 31, 43, ... are in the arithmetic progression $4k + 3$.


### Conjectures and Open Problems About Primes

### Greatest Common Divisors and Least Common Multiples
The largest integer that divides both of two integers is called the greatest common divisor of these integers.

> [!summary] Definition - "Greatest Common Divisor"
> Let $a$ and $b$ be integers, not both zero. The largest integer $d$ such that $d \mid a$ and $d \mid b$ is called the greatest common divisor of $a$ and $b$. The greatest common divisor of $a$ and $b$ is denoted by $\gcd(a, b)$.

The greatest common divisor of two integers, not both zero, exists because the set of common divisors of these integers is nonempty and finite. One way to find the greatest common divisor of two integers is to find all the positive common divisors of both integers and then take the largest divisor.

> [!example]
> **Problem:** What is the greatest common divisor of 24 and 36?
> 
> **Solution:** The positive common divisors of 24 and 36 are 1, 2, 3, 4, 6, and 12. Hence, $\gcd(24, 36) = 12$.

> [!example]
> **Problem:** What is the greatest common divisor of 17 and 22?
> 
> **Solution:** The integers 17 and 22 have no positive common divisors other than 1, so that $\gcd(17, 22) = 1$.

> [!summary] Definition - "Relatively Prime"
> The integers $a$ and $b$ are relatively prime if their greatest common divisor is 1.
> 
> **Remark:** Because it is often important to specify that two integers have no common positive divisor other than 1, we have this definition.

> [!example]
> The integers 17 and 22 are relatively prime, because $\gcd(17, 22) = 1$.

> [!summary] Definition - "Pairwise Relatively Prime"
> The integers $a_1, a_2, \dots, a_n$ are pairwise relatively prime if $\gcd(a_i, a_j) = 1$ whenever $1 \le i < j \le n$.
> 
> **Remark:** Because we often need to specify that no two integers in a set of integers have a common positive divisor greater than 1, we have this definition.

> [!example]
> **Problem:** Determine whether the integers 10, 17, and 21 are pairwise relatively prime and whether the integers 10, 19, and 24 are pairwise relatively prime.
> 
> **Solution:**
> - Because $\gcd(10, 17) = 1$, $\gcd(10, 21) = 1$, and $\gcd(17, 21) = 1$, we conclude that 10, 17, and 21 are pairwise relatively prime.
> - Because $\gcd(10, 24) = 2 > 1$, we see that 10, 19, and 24 are not pairwise relatively prime.

Another way to find the greatest common divisor of two positive integers is to use the prime factorizations of these integers.

> [!summary] Theorem - "GCD via Prime Factorization"
> Suppose that the prime factorizations of the positive integers $a$ and $b$ are $a = p_1^{a_1} p_2^{a_2} \cdots p_n^{a_n}$ and $b = p_1^{b_1} p_2^{b_2} \cdots p_n^{b_n}$, where each exponent is a nonnegative integer, and where all primes occurring in the prime factorization of either $a$ or $b$ are included in both factorizations, with zero exponents if necessary.
> 
> Then $\gcd(a, b)$ is given by:
> $$\gcd(a, b) = p_1^{\min(a_1, b_1)} p_2^{\min(a_2, b_2)} \cdots p_n^{\min(a_n, b_n)}$$
> where $\min(x, y)$ represents the minimum of the two numbers $x$ and $y$.
> 
> Proof:
> To show that this formula for $\gcd(a, b)$ is valid, we must show that the integer on the right-hand side divides both $a$ and $b$, and that no larger integer also does.
> - This integer does divide both $a$ and $b$, because the power of each prime in the factorization does not exceed the power of this prime in either the factorization of $a$ or that of $b$.
> - Further, no larger integer can divide both $a$ and $b$, because the exponents of the primes in this factorization cannot be increased, and no other primes can be included.

> [!example]
> Because the prime factorizations of 120 and 500 are $120 = 2^3 \cdot 3 \cdot 5$ and $500 = 2^2 \cdot 5^3$, the greatest common divisor is:
> $$\gcd(120, 500) = 2^{\min(3, 2)} 3^{\min(1, 0)} 5^{\min(1, 3)} = 2^2 3^0 5^1 = 20$$

Prime factorizations can also be used to find the least common multiple of two integers.

> [!summary] Definition - "Least Common Multiple"
> The least common multiple of the positive integers $a$ and $b$ is the smallest positive integer that is divisible by both $a$ and $b$. The least common multiple of $a$ and $b$ is denoted by $\operatorname{lcm}(a, b)$.

The least common multiple exists because the set of integers divisible by both $a$ and $b$ is nonempty (because $ab$ belongs to this set, for instance), and every nonempty set of positive integers has a least element (by the well-ordering property).

> [!summary] Theorem - "LCM via Prime Factorization"
> Suppose that the prime factorizations of $a$ and $b$ are as before. Then the least common multiple of $a$ and $b$ is given by:
> $$\operatorname{lcm}(a, b) = p_1^{\max(a_1, b_1)} p_2^{\max(a_2, b_2)} \cdots p_n^{\max(a_n, b_n)}$$
> where $\max(x, y)$ denotes the maximum of the two numbers $x$ and $y$.
> 
> Proof:
> - A common multiple of $a$ and $b$ has at least $\max(a_i, b_i)$ factors of $p_i$ in its prime factorization.
> - The least common multiple has no other prime factors besides those in $a$ and $b$.

> [!example]
> **Problem:** What is the least common multiple of $2^3 3^5 7^2$ and $2^4 3^3$?
> 
> **Solution:** We have:
> $$\operatorname{lcm}(2^3 3^5 7^2, 2^4 3^3) = 2^{\max(3, 4)} 3^{\max(5, 3)} 7^{\max(2, 0)} = 2^4 3^5 7^2 = 190512$$

There is a useful relationship between the greatest common divisor and least common multiple of two integers. It can be proved using the formulae we have derived for these quantities.

> [!summary] Theorem - "Product of GCD and LCM"
> Let $a$ and $b$ be positive integers. Then:
> $$ab = \gcd(a, b) \cdot \operatorname{lcm}(a, b)$$
### The Euclidean Algorithm
Computing the greatest common divisor directly from the prime factorizations of these integers is inefficient because finding prime factorizations is time-consuming. We will give a more efficient method of finding the greatest common divisor, called the Euclidean algorithm. This algorithm has been known since ancient times.

> [!example] Finding $\gcd(91, 287)$
> To demonstrate how the Euclidean algorithm works, let us find $\gcd(91, 287)$.
> 
> - First, divide 287 by 91: $287 = 91 \cdot 3 + 14$. Any divisor of 91 and 287 must also divide $287 - 91 \cdot 3 = 14$. Thus, $\gcd(91, 287) = \gcd(91, 14)$.
> - Next, divide 91 by this divisor 14: $91 = 14 \cdot 6 + 7$. Any divisor of 91 and 14 must divide $91 - 14 \cdot 6 = 7$. Thus, $\gcd(91, 14) = \gcd(14, 7)$.
> - Continue by dividing 14 by 7: $14 = 7 \cdot 2$. Since 7 divides 14, $\gcd(14, 7) = 7$.
> 
> By chaining these results together, $\gcd(287, 91) = \gcd(91, 14) = \gcd(14, 7) = 7$.

> [!summary] Lemma - "GCD Reduction Lemma"
> Let $a = bq + r$, where $a, b, q$, and $r$ are integers. Then $\gcd(a, b) = \gcd(b, r)$.
> 
> Proof:
> We will show that the common divisors of $a$ and $b$ are the same as the common divisors of $b$ and $r$, which implies their greatest common divisors are equal.
> - Suppose $d$ divides both $a$ and $b$. Then $d$ also divides $a - bq = r$ (from properties of divisibility). Hence, any common divisor of $a$ and $b$ is also a common divisor of $b$ and $r$.
> - Likewise, suppose $d$ divides both $b$ and $r$. Then $d$ also divides $bq + r = a$. Hence, any common divisor of $b$ and $r$ is also a common divisor of $a$ and $b$.
> 
> Because the sets of common divisors are identical, $\gcd(a, b) = \gcd(b, r)$.

> [!summary] Theorem - "The Euclidean Algorithm"
> Let $a$ and $b$ be positive integers with $a \ge b$. Let $r_0 = a$ and $r_1 = b$. If we successively apply the division algorithm, we obtain the sequence of equations:
> 
> $r_0 = r_1q_1 + r_2 \quad (0 \le r_2 < r_1)$
> $r_1 = r_2q_2 + r_3 \quad (0 \le r_3 < r_2)$
> $\vdots$
> $r_{n-2} = r_{n-1}q_{n-1} + r_n \quad (0 \le r_n < r_{n-1})$
> $r_{n-1} = r_nq_n$
> 
> Eventually a remainder of zero occurs because the sequence of remainders $a = r_0 > r_1 > r_2 > \dots \ge 0$ cannot contain more than $a$ terms. The greatest common divisor of $a$ and $b$ is the last nonzero remainder $r_n$.
> 
> **Proof:**
> By the GCD Reduction Lemma, $\gcd(a, b) = \gcd(r_0, r_1) = \gcd(r_1, r_2) = \dots = \gcd(r_{n-1}, r_n) = \gcd(r_n, 0) = r_n$.

> [!example] Finding $\gcd(414, 662)$
> **Problem:** Find the greatest common divisor of 414 and 662 using the Euclidean algorithm.
> 
> **Solution:** Successive uses of the division algorithm give:
> - $662 = 414 \cdot 1 + 248$
> - $414 = 248 \cdot 1 + 166$
> - $248 = 166 \cdot 1 + 82$
> - $166 = 82 \cdot 2 + 2$
> - $82 = 2 \cdot 41$
> 
> Hence, $\gcd(414, 662) = 2$, because 2 is the last nonzero remainder.
> 
> ![[Pasted image 20260217203307.png]]

The Euclidean algorithm can be expressed in pseudocode.

![[Pasted image 20260217203323.png]]

In this procedure, the initial values of $x$ and $y$ are $a$ and $b$, respectively. At each stage of the procedure, $x$ is replaced by $y$, and $y$ is replaced by $x \bmod y$, which is the remainder when $x$ is divided by $y$. This process is repeated as long as $y \neq 0$. The algorithm terminates when $y = 0$, and the value of $x$ at that point (the last nonzero remainder) is the greatest common divisor of $a$ and $b$. The number of divisions required to find the greatest common divisor of $a$ and $b$, where $a \ge b$, is $O(\log b)$.
### GCDs as Linear Combinations
An important result is that the greatest common divisor of two integers $a$ and $b$ can be expressed in the form $sa + tb$, where $s$ and $t$ are integers. In other words, $\gcd(a, b)$ can be expressed as a linear combination with integer coefficients of $a$ and $b$. For example, $\gcd(6, 14) = 2$, and $2 = (-2) \cdot 6 + 1 \cdot 14$.

> [!summary] Theorem - "Bézout's Theorem"
> If $a$ and $b$ are positive integers, then there exist integers $s$ and $t$ such that $\gcd(a, b) = sa + tb$.

> [!example]
> **Finding the GCD and Linear Combination for 318 and 96**
>
> **Step 1: Apply the Euclidean Algorithm**
> Divide the larger number by the smaller number and repeat with the remainder until the remainder is 0.
> 
> $318 = 96 \cdot 3 + 30$
> $96 = 30 \cdot 3 + 6$
> $30 = 6 \cdot 5 + 0$
>
> The last non-zero remainder is the GCD.
> $\text{gcd}(318, 96) = 6$
>
> **Step 2: Extended Euclidean Algorithm**
> Work backwards to express the GCD as a linear combination $318s + 96t = 6$.
>
> Start with the equation containing the GCD:
> $6 = 96 - 30 \cdot 3$
>
> Substitute the previous remainder $30 = 318 - 96 \cdot 3$:
> $6 = 96 - (318 - 96 \cdot 3) \cdot 3$
> $6 = 96 - 3 \cdot 318 + 9 \cdot 96$
> $6 = 10 \cdot 96 - 3 \cdot 318$
>
> **Result:**
> $6 = (-3) \cdot 318 + (10) \cdot 96$
> Therefore, $\text{gcd}(318, 96) = 6$ with $s = -3$ and $t = 10$.
>![[Pasted image 20260218102117.png]]

> [!summary] Definition - "Bézout Coefficients and Identity"
> If $a$ and $b$ are positive integers, then integers $s$ and $t$ such that $\gcd(a, b) = sa + tb$ are called Bézout coefficients of $a$ and $b$. Also, the equation $\gcd(a, b) = sa + tb$ is called Bézout’s identity.

There are two methods to find Bézout coefficients. The first method proceeds by working backward through the divisions of the Euclidean algorithm. The main advantage of the second method, known as the extended Euclidean algorithm, is that it uses one pass through the steps of the Euclidean algorithm to find Bézout coefficients of $a$ and $b$.

> [!example] Finding GCD as a Linear Combination (Backward Pass)
> **Problem:** Express $\gcd(252, 198) = 18$ as a linear combination of 252 and 198 by working backwards through the steps of the Euclidean algorithm.
> 
> **Solution:** The Euclidean algorithm uses these divisions:
> - $252 = 198 \cdot 1 + 54$
> - $198 = 54 \cdot 3 + 36$
> - $54 = 36 \cdot 1 + 18$
> - $36 = 18 \cdot 2 + 0$
> 
> ![[Pasted image 20260217203629.png]]
> 
> We work backwards from the next-to-last division:
> 1. From the third division: $18 = 54 - 1 \cdot 36$.
> 2. From the second division: $36 = 198 - 3 \cdot 54$. Substitute this into the previous equation:
> $18 = 54 - 1 \cdot (198 - 3 \cdot 54) = 4 \cdot 54 - 1 \cdot 198$.
> 3. From the first division: $54 = 252 - 1 \cdot 198$. Substitute this into the previous equation:
> $18 = 4 \cdot (252 - 1 \cdot 198) - 1 \cdot 198 = 4 \cdot 252 - 5 \cdot 198$.

> [!example] Finding GCD as a Linear Combination (Extended Euclidean Algorithm)
> **Problem:** Express $\gcd(252, 198) = 18$ as a linear combination of 252 and 198 using the extended Euclidean algorithm.
> 
> **Solution:** The quotients from the Euclidean algorithm are $q_1 = 1, q_2 = 3, q_3 = 1, q_4 = 2$.
> We set initial values $s_0 = 1, s_1 = 0, t_0 = 0, t_1 = 1$.
> We calculate subsequent values using $s_j = s_{j-2} - q_{j-1}s_{j-1}$ and $t_j = t_{j-2} - q_{j-1}t_{j-1}$ for $j = 2, 3, 4$.
> - $s_2 = 1 - 0 \cdot 1 = 1, \quad t_2 = 0 - 1 \cdot 1 = -1$
> - $s_3 = 0 - 1 \cdot 3 = -3, \quad t_3 = 1 - (-1)3 = 4$
> - $s_4 = 1 - (-3) \cdot 1 = 4, \quad t_4 = -1 - 4 \cdot 1 = -5$
> 
> Because $s_4 = 4$ and $t_4 = -5$, we see that $18 = \gcd(252, 198) = 4 \cdot 252 - 5 \cdot 198$.
> 
> ![[Pasted image 20260217203742.png]]

> [!summary] Lemma - "Divisibility of a Product Coprime to a Factor"
> If $a$, $b$, and $c$ are positive integers such that $\gcd(a, b) = 1$ and $a \mid bc$, then $a \mid c$.
> 
> Proof:
> Because $\gcd(a, b) = 1$, by Bézout’s theorem there are integers $s$ and $t$ such that $sa + tb = 1$. Multiplying both sides of this equation by $c$, we obtain $sac + tbc = c$.
> We can now use properties of divisibility to show that $a \mid c$.
> - By part (ii) of the properties theorem, $a \mid tbc$ (since $a \mid bc$).
> - Because $a \mid sac$ and $a \mid tbc$, by part (i) of that theorem, we conclude that $a$ divides $sac + tbc$.
> - Because $sac + tbc = c$, we conclude that $a \mid c$.

> [!summary] Lemma - "Prime Divisibility of a Product"
> If $p$ is a prime and $p \mid a_1a_2 \cdots a_n$, where each $a_i$ is an integer, then $p \mid a_i$ for some $i$.

We can now show that a factorization of an integer into primes is unique. This is part of the fundamental theorem of arithmetic.

> [!summary] Theorem - "Uniqueness of Prime Factorization"
> The prime factorization of a positive integer is unique. That is, every integer can be written as the product of primes in nondecreasing order in at most one way.
> 
> Proof (of the uniqueness of the prime factorization of a positive integer):
> We will use a proof by contradiction. Suppose that the positive integer $n$ can be written as the product of primes in two different ways, say, $n = p_1p_2 \cdots p_s$ and $n = q_1q_2 \cdots q_t$, where each $p_i$ and $q_j$ is prime such that $p_1 \le p_2 \le \cdots \le p_s$ and $q_1 \le q_2 \le \cdots \le q_t$.
> 
> When we remove all common primes from the two factorizations, we have $p_{i_1} p_{i_2} \cdots p_{i_u} = q_{j_1} q_{j_2} \cdots q_{j_v}$, where no prime occurs on both sides of this equation and $u$ and $v$ are positive integers. By Lemma "Prime Divisibility of a Product", it follows that $p_{i_1}$ divides $q_{j_k}$ for some $k$. Because no prime divides another prime, this is impossible. Consequently, there can be at most one factorization of $n$ into primes in nondecreasing order.

> [!example] Invalid Cancellation in Congruences
> The congruence $14 \equiv 8 \pmod 6$ holds, but both sides of this congruence cannot be divided by 2 to produce a valid congruence because $14/2 = 7$ and $8/2 = 4$, but $7 \not\equiv 4 \pmod 6$.

Although we cannot divide both sides of a congruence by any integer to produce a valid congruence, we can if this integer is relatively prime to the modulus.

> [!summary] Theorem - "Cancellation in Modular Arithmetic"
> Let $m$ be a positive integer and let $a$, $b$, and $c$ be integers. If $ac \equiv bc \pmod m$ and $\gcd(c, m) = 1$, then $a \equiv b \pmod m$.
> 
> Proof:
> Because $ac \equiv bc \pmod m$, $m \mid ac - bc = c(a - b)$. By Lemma "Divisibility of a Product Coprime to a Factor", because $\gcd(c, m) = 1$, it follows that $m \mid a - b$. We conclude that $a \equiv b \pmod m$.
## Solving Congruences
### Introduction
Solving linear congruences, which have the form $ax \equiv b \pmod m$, is an essential task in the study of number theory and its applications. To solve linear congruences, we employ inverses modulo $m$. We explain how to work backwards through the steps of the Euclidean algorithm to find inverses modulo $m$. Once we have found an inverse of $a$ modulo $m$, we solve the congruence $ax \equiv b \pmod m$ by multiplying both sides of the congruence by this inverse.

Simultaneous systems of linear congruences have been studied since ancient times. We will show how to solve systems of linear congruences modulo pairwise relatively prime moduli. The result used for this is called the Chinese remainder theorem, and our proof will give a method to find all solutions of such systems. We will also show how to use the Chinese remainder theorem as a basis for performing arithmetic with large integers.

> [!summary] Theorem - "Fermat's Little Theorem"
> If $p$ is prime and $p$ does not divide $a$, then $a^{p-1} \equiv 1 \pmod p$.

We will examine the converse of this statement, which will lead us to the concept of a pseudoprime.

> [!summary] Definition - "Pseudoprime to the Base a"
> A pseudoprime $m$ to the base $a$ is a composite integer $m$ that masquerades as a prime by satisfying the congruence $a^{m-1} \equiv 1 \pmod m$.

> [!summary] Definition - "Carmichael Number"
> A Carmichael number is a composite integer that is a pseudoprime to all bases $a$ relatively prime to it.

We also introduce the notion of discrete logarithms, which are analogous to ordinary logarithms. To define discrete logarithms we must first define primitive roots.

> [!summary] Definition - "Primitive Root"
> A primitive root of a prime $p$ is an integer $r$ such that every integer not divisible by $p$ is congruent to a power of $r$ modulo $p$.

> [!summary] Definition - "Discrete Logarithm"
> If $r$ is a primitive root of $p$ and $r^e \equiv a \pmod p$, then $e$ is the discrete logarithm of $a$ modulo $p$ to the base $r$.

Finding discrete logarithms turns out to be an extremely difficult problem in general. The difficulty of this problem is the basis for the security of many cryptographic systems.
### Linear Congruences
A congruence of the form $ax \equiv b \pmod m$, where $m$ is a positive integer, $a$ and $b$ are integers, and $x$ is a variable, is called a linear congruence. To solve the linear congruence $ax \equiv b \pmod m$, we use an integer $\bar{a}$ such that $\bar{a}a \equiv 1 \pmod m$, if such an integer exists. Such an integer $\bar{a}$ is said to be an inverse of $a$ modulo $m$.

> [!summary] Theorem - "Existence and Uniqueness of Modular Inverses"
> If $a$ and $m$ are relatively prime integers and $m > 1$, then an inverse of $a$ modulo $m$ exists. Furthermore, this inverse is unique modulo $m$. (That is, there is a unique positive integer $\bar{a}$ less than $m$ that is an inverse of $a$ modulo $m$ and every other inverse of $a$ modulo $m$ is congruent to $\bar{a}$ modulo $m$.)
> 
> Proof:
> By Bézout's theorem, because $\gcd(a, m) = 1$, there are integers $s$ and $t$ such that $sa + tm = 1$. This implies that $sa + tm \equiv 1 \pmod m$. Because $tm \equiv 0 \pmod m$, it follows that $sa \equiv 1 \pmod m$. Consequently, $s$ is an inverse of $a$ modulo $m$. (The proof of uniqueness is left as an exercise).

Using inspection to find an inverse of $a$ modulo $m$ is easy when $m$ is small. We can design a more efficient algorithm than brute force to find an inverse of $a$ modulo $m$ when $\gcd(a, m) = 1$ using the steps of the Euclidean algorithm. By reversing these steps, we can find a linear combination $sa + tm = 1$, where $s$ and $t$ are integers. Reducing both sides of this equation modulo $m$ tells us that $s$ is an inverse of $a$ modulo $m$.

![[Pasted image 20260218104626.png]]
![[Pasted image 20260218105349.png]]


> [!example] Finding an Inverse via Small Inspection
> **Problem:** Find an inverse of 3 modulo 7 by first finding Bézout coefficients of 3 and 7.
> 
> **Solution:** Because $\gcd(3, 7) = 1$, an inverse exists. The Euclidean algorithm step is $7 = 2 \cdot 3 + 1$.
> From this equation, we see that $-2 \cdot 3 + 1 \cdot 7 = 1$. This shows that $-2$ and $1$ are Bézout coefficients of 3 and 7.
> We see that $-2$ is an inverse of 3 modulo 7. Note that every integer congruent to $-2$ modulo 7 is also an inverse of 3, such as 5, $-9$, 12, and so on.

> [!example] Finding an Inverse via the Extended Euclidean Algorithm
> **Problem:** Find an inverse of 101 modulo 4620.
> 
> **Solution:** First, use the Euclidean algorithm to show that $\gcd(101, 4620) = 1$.
> - $4620 = 45 \cdot 101 + 75$
> - $101 = 1 \cdot 75 + 26$
> - $75 = 2 \cdot 26 + 23$
> - $26 = 1 \cdot 23 + 3$
> - $23 = 7 \cdot 3 + 2$
> - $3 = 1 \cdot 2 + 1$
> - $2 = 2 \cdot 1$
> 
> The last nonzero remainder is 1, so $\gcd(101, 4620) = 1$. We now work backwards to find Bézout coefficients.
> 
> $1 = 3 - 1 \cdot 2$
> $= 3 - 1 \cdot (23 - 7 \cdot 3) = -1 \cdot 23 + 8 \cdot 3$
> $= -1 \cdot 23 + 8 \cdot (26 - 1 \cdot 23) = 8 \cdot 26 - 9 \cdot 23$
> $= 8 \cdot 26 - 9 \cdot (75 - 2 \cdot 26) = -9 \cdot 75 + 26 \cdot 26$
> $= -9 \cdot 75 + 26 \cdot (101 - 1 \cdot 75) = 26 \cdot 101 - 35 \cdot 75$
> $= 26 \cdot 101 - 35 \cdot (4620 - 45 \cdot 101) = -35 \cdot 4620 + 1601 \cdot 101$
> 
> The equation $-35 \cdot 4620 + 1601 \cdot 101 = 1$ tells us that 1601 is an inverse of 101 modulo 4620.

Once we have an inverse $\bar{a}$ of $a$ modulo $m$, we can solve the congruence $ax \equiv b \pmod m$ by multiplying both sides of the linear congruence by $\bar{a}$.

> [!example] Solving a Linear Congruence
> **Problem:** What are the solutions of the linear congruence $3x \equiv 4 \pmod 7$?
> 
> **Solution:** By the previous example, we know that $-2$ is an inverse of 3 modulo 7.
> Multiplying both sides of the congruence by $-2$:
> $-2 \cdot 3x \equiv -2 \cdot 4 \pmod 7$
> $1x \equiv -8 \pmod 7$
> $x \equiv 6 \pmod 7$
> 
> We verify that every $x$ with $x \equiv 6 \pmod 7$ is a solution. If $x \equiv 6 \pmod 7$, then $3x \equiv 3 \cdot 6 = 18 \equiv 4 \pmod 7$.
> We conclude that the solutions are the integers $x$ such that $x \equiv 6 \pmod 7$, namely, $6, 13, 20, \dots$ and $-1, -8, -15, \dots$.
### The Chinese Remainder Theorem
Systems of linear congruences arise in many contexts. For example, as we will see later, they are the basis for a method that can be used to perform arithmetic with large integers. Such systems can even be found as word puzzles in the writings of ancient Chinese and Hindu mathematicians.

> [!example] Sun-Tsu's Ancient Puzzle
> In the first century, the Chinese mathematician Sun-Tsu asked: "There are certain things whose number is unknown. When divided by 3, the remainder is 2; when divided by 5, the remainder is 3; and when divided by 7, the remainder is 2. What will be the number of things?"
> 
> This puzzle can be translated into the following question: What are the solutions of the systems of congruences
> $x \equiv 2 \pmod 3$
> $x \equiv 3 \pmod 5$
> $x \equiv 2 \pmod 7$?
> 
> We will solve this system later in this section.

The Chinese remainder theorem, named after the Chinese heritage of problems involving systems of linear congruences, states that when the moduli of a system of linear congruences are pairwise relatively prime, there is a unique solution of the system modulo the product of the moduli.

> [!summary] Theorem - "The Chinese Remainder Theorem"
> Let $m_1, m_2, \dots, m_n$ be pairwise relatively prime positive integers greater than one and $a_1, a_2, \dots, a_n$ arbitrary integers. Then the system
> $x \equiv a_1 \pmod{m_1}$
> $x \equiv a_2 \pmod{m_2}$
> $\vdots$
> $x \equiv a_n \pmod{m_n}$
> has a unique solution modulo $m = m_1 m_2 \cdots m_n$. (That is, there is a solution $x$ with $0 \le x < m$, and all other solutions are congruent modulo $m$ to this solution.)
> 
> Proof:
> To establish this theorem, we need to show that a solution exists and that it is unique modulo $m$. We will show that a solution exists by describing a way to construct this solution.
> 
> To construct a simultaneous solution, first let $M_k = m / m_k$ for $k = 1, 2, \dots, n$. That is, $M_k$ is the product of the moduli except for $m_k$.
> 
> Because $m_i$ and $m_k$ have no common factors greater than 1 when $i \neq k$, it follows that $\gcd(m_k, M_k) = 1$. Consequently, by the theorem on the existence of modular inverses, we know that there is an integer $y_k$, an inverse of $M_k$ modulo $m_k$, such that $M_k y_k \equiv 1 \pmod{m_k}$.
> 
> To construct a simultaneous solution, form the sum:
> $$x = a_1 M_1 y_1 + a_2 M_2 y_2 + \cdots + a_n M_n y_n$$
> 
> We will now show that $x$ is a simultaneous solution.
> - First, note that because $M_j \equiv 0 \pmod{m_k}$ whenever $j \neq k$, all terms except the $k$th term in this sum are congruent to 0 modulo $m_k$.
> - Because $M_k y_k \equiv 1 \pmod{m_k}$, we see that $x \equiv a_k M_k y_k \equiv a_k \pmod{m_k}$, for $k = 1, 2, \dots, n$.
> 
> We have shown that $x$ is a simultaneous solution to the $n$ congruences.

> [!example] Solving Sun-Tsu's Puzzle
> **Problem:** To solve the system of congruences in Example 4 (Sun-Tsu's puzzle).
> 
> **Solution:** First let $m = 3 \cdot 5 \cdot 7 = 105$.
> - $M_1 = m/3 = 35$. We see that 2 is an inverse of $M_1 = 35$ modulo 3, because $35 \cdot 2 \equiv 2 \cdot 2 \equiv 1 \pmod 3$.
> - $M_2 = m/5 = 21$. 1 is an inverse of $M_2 = 21$ modulo 5, because $21 \equiv 1 \pmod 5$.
> - $M_3 = m/7 = 15$. 1 is an inverse of $M_3 = 15$ (mod 7), because $15 \equiv 1 \pmod 7$.
> 
> The solutions to this system are those $x$ such that:
> $x \equiv a_1 M_1 y_1 + a_2 M_2 y_2 + a_3 M_3 y_3 \pmod{105}$
> $x \equiv 2 \cdot 35 \cdot 2 + 3 \cdot 21 \cdot 1 + 2 \cdot 15 \cdot 1$
> $x \equiv 140 + 63 + 30 = 233 \equiv 23 \pmod{105}$
> 
> It follows that 23 is the smallest positive integer that is a simultaneous solution. We conclude that 23 is the smallest positive integer that leaves a remainder of 2 when divided by 3, a remainder of 3 when divided by 5, and a remainder of 2 when divided by 7.

Although the construction in the Chinese Remainder Theorem provides a general method for solving systems of linear congruences with pairwise relatively prime moduli, it can be easier to solve a system using a different method, such as back substitution.

> [!example] Solving Congruences via Back Substitution
> **Problem:** Use the method of back substitution to find all integers $x$ such that $x \equiv 1 \pmod 5$, $x \equiv 2 \pmod 6$, and $x \equiv 3 \pmod 7$.
> 
> **Solution:**
> - By the definition of congruence, the first congruence can be rewritten as an equality: $x = 5t + 1$, where $t$ is an integer.
> - Substituting this expression for $x$ into the second congruence: $5t + 1 \equiv 2 \pmod 6$.
>   Solving this shows that $t \equiv 5 \pmod 6$. Thus, $t = 6u + 5$ for some integer $u$.
> - Substituting this expression for $t$ back into $x = 5t + 1$: $x = 5(6u + 5) + 1 = 30u + 26$.
> - Insert this into the third congruence: $30u + 26 \equiv 3 \pmod 7$.
>   Solving this congruence tells us that $u \equiv 6 \pmod 7$. Hence, $u = 7v + 6$, where $v$ is an integer.
> - Substituting this expression for $u$ into the equation $x = 30u + 26$:
>   $x = 30(7v + 6) + 26 = 210v + 206$.
> - Translating this back into a congruence, we find the solution to the simultaneous congruences is $x \equiv 206 \pmod{210}$.
### Computer Arithmetic with Large Integers
Suppose that $m_1, m_2, \dots, m_n$ are pairwise relatively prime moduli and let $m$ be their product. By the Chinese remainder theorem, an integer $a$ with $0 \le a < m$ can be uniquely represented by the $n$-tuple consisting of its remainders upon division by $m_i$, for $i = 1, 2, \dots, n$. That is, we can uniquely represent $a$ by $(a \bmod m_1, a \bmod m_2, \dots, a \bmod m_n)$.

> [!example] Representation Modulo 12
> **Problem:** What are the pairs used to represent the nonnegative integers less than 12 when they are represented by the ordered pair where the first component is the remainder of the integer upon division by 3 and the second component is the remainder of the integer upon division by 4?
> 
> **Solution:** We compute the remainders of each integer $0$ through $11$ when divided by 3 and 4:
> - $0 = (0, 0)$
> - $1 = (1, 1)$
> - $2 = (2, 2)$
> - $3 = (0, 3)$
> - $4 = (1, 0)$
> - $5 = (2, 1)$
> - $6 = (0, 2)$
> - $7 = (1, 3)$
> - $8 = (2, 0)$
> - $9 = (0, 1)$
> - $10 = (1, 2)$
> - $11 = (2, 3)$

To perform arithmetic with large integers, we select moduli $m_1, m_2, \dots, m_n$, where each $m_i$ is an integer greater than 2, $\gcd(m_i, m_j) = 1$ whenever $i \neq j$, and $m = m_1 m_2 \cdots m_n$ is greater than the results of the arithmetic operations we want to carry out.

Once we have selected our moduli, we carry out arithmetic operations with large integers by performing componentwise operations on the $n$-tuples representing these integers using their remainders upon division by $m_i$. Once we have computed the value of each component in the result, we recover its value by solving a system of $n$ congruences modulo $m_i$.

This method has several valuable features:
1. It allows arithmetic with integers larger than can ordinarily be carried out on a computer.
2. Computations with respect to the different moduli can be done in parallel, speeding up the arithmetic.

> [!example] Arithmetic Using Moduli 99, 98, 97, 95
> **Problem:** Suppose that performing arithmetic with integers less than 100 is much quicker than doing arithmetic with larger integers. We can represent integers using their remainders modulo pairwise relatively prime integers less than 100, such as 99, 98, 97, and 95.
> 
> Every nonnegative integer less than $99 \cdot 98 \cdot 97 \cdot 95 = 89,403,930$ can be represented uniquely by its remainders when divided by these four moduli.
> 
> Represent the integers 123,684 and 413,456 and find their sum.
> 
> **Solution:**
> - **Represent 123,684:**
>   - $123,684 \bmod 99 = 33$
>   - $123,684 \bmod 98 = 8$
>   - $123,684 \bmod 97 = 9$
>   - $123,684 \bmod 95 = 89$
>   - Representation: $(33, 8, 9, 89)$
> 
> - **Represent 413,456:**
>   - $413,456 \bmod 99 = 32$
>   - $413,456 \bmod 98 = 92$
>   - $413,456 \bmod 97 = 42$
>   - $413,456 \bmod 95 = 16$
>   - Representation: $(32, 92, 42, 16)$
> 
> - **Add the 4-tuples componentwise:**
>   $(33, 8, 9, 89) + (32, 92, 42, 16) = (65, 100, 51, 105)$
> 
> - **Reduce each component modulo the respective modulus:**
>   - $65 \bmod 99 = 65$
>   - $100 \bmod 98 = 2$
>   - $51 \bmod 97 = 51$
>   - $105 \bmod 95 = 10$
>   - Result Representation: $(65, 2, 51, 10)$
> 
> - **Recover the integer:** To find the sum, we solve the system of congruences:
>   $x \equiv 65 \pmod{99}$
>   $x \equiv 2 \pmod{98}$
>   $x \equiv 51 \pmod{97}$
>   $x \equiv 10 \pmod{95}$
> 
>   The unique nonnegative solution less than $89,403,930$ is $537,140$. Consequently, $537,140$ is the sum.

Particularly good choices for moduli for arithmetic with large integers are sets of integers of the form $2^k - 1$, where $k$ is a positive integer. This is because:
1. It is easy to do binary arithmetic modulo such integers.
2. It is easy to find sets of such integers that are pairwise relatively prime. (Since $\gcd(2^a - 1, 2^b - 1) = 2^{\gcd(a, b)} - 1$).

For instance, suppose we can easily do arithmetic with integers less than $2^{35}$. We can use pairwise relatively prime moduli less than $2^{35}$ to perform arithmetic with integers as large as their product. The integers $2^{35} - 1$, $2^{34} - 1$, $2^{33} - 1$, $2^{31} - 1$, $2^{29} - 1$, and $2^{23} - 1$ are pairwise relatively prime. Because the product of these six moduli exceeds $2^{184}$, we can perform arithmetic with integers as large as $2^{184}$ by doing arithmetic modulo each of these six moduli.
### Fermat’s Little Theorem
The French mathematician Pierre de Fermat, one of the leading mathematicians of the first half of the 17th century, made many important discoveries in number theory. One of the most useful of these states that $p$ divides $a^{p-1} - 1$ whenever $p$ is prime and $a$ is an integer not divisible by $p$. Fermat announced this result in a letter but did not include a proof. The first published proof is credited to Leonhard Euler. We now state this theorem in terms of congruences.

> [!summary] Theorem - "Fermat's Little Theorem"
> If $p$ is prime and $a$ is an integer not divisible by $p$, then $a^{p-1} \equiv 1 \pmod p$. Furthermore, for every integer $a$ we have $a^p \equiv a \pmod p$.
> 
> **Remark:** This theorem tells us that if $a \in \mathbb{Z}_p$, then $a^{p-1} = 1$ in $\mathbb{Z}_p$.

Fermat’s little theorem is extremely useful in computing the remainders modulo $p$ of large powers of integers.

> [!example]
> **Problem:** Find $7^{222} \bmod 11$.
> 
> **Solution:** We can use Fermat’s little theorem to evaluate $7^{222} \bmod 11$ rather than using the fast modular exponentiation algorithm.
> - By Fermat’s little theorem we know that $7^{10} \equiv 1 \pmod{11}$.
> - Consequently, $(7^{10})^k \equiv 1 \pmod{11}$ for every positive integer $k$.
> - To take advantage of this, we divide the exponent 222 by 10, finding that $222 = 22 \cdot 10 + 2$.
> - We now see that:
> $$7^{222} = 7^{22 \cdot 10 + 2} = (7^{10})^{22} \cdot 7^2 \equiv (1)^{22} \cdot 49 \equiv 5 \pmod{11}$$
> - It follows that $7^{222} \bmod 11 = 5$.

The previous example illustrates how we can use Fermat’s little theorem to compute $a^n \bmod p$, where $p$ is prime and $p \nmid a$:
1. Use the division algorithm to find the quotient $q$ and remainder $r$ when $n$ is divided by $p - 1$, so that $n = q(p - 1) + r$, where $0 \le r < p - 1$.
2. It follows that $a^n = a^{q(p-1)+r} = (a^{p-1})^q a^r \equiv 1^q a^r \equiv a^r \pmod p$.

Hence, to find $a^n \bmod p$, we only need to compute $a^r \bmod p$. This simplification is used frequently in number theory.
### Pseudoprimes
In Section 4.2, we learned that an integer $n$ is prime when it is not divisible by any prime $p$ with $p \le \sqrt{n}$. Unfortunately, using this criterion to show that a given integer is prime is inefficient. It requires finding all primes not exceeding $\sqrt{n}$ and carrying out trial division by each.

Are there more efficient ways to determine whether an integer is prime? Ancient Chinese mathematicians believed that $n$ was an odd prime if and only if $2^{n-1} \equiv 1 \pmod n$.

**Why did they believe this?**
1.  **Correct Observation:** They observed that the congruence holds whenever $n$ is an odd prime. For example, 5 is prime and $2^{5-1} = 16 \equiv 1 \pmod 5$. By Fermat’s little theorem, we know this observation is correct: $2^{n-1} \equiv 1 \pmod n$ whenever $n$ is an odd prime.
2.  **Lack of Counterexamples:** They never found a composite integer $n$ for which the congruence holds.

However, the ancient Chinese were only partially correct. They were correct that the congruence holds if $n$ is prime, but incorrect in concluding that $n$ is necessarily prime if the congruence holds. There are composite integers $n$ such that $2^{n-1} \equiv 1 \pmod n$.

> [!example]
> The integer 341 is a pseudoprime to the base 2 because it is composite ($341 = 11 \cdot 31$) and $2^{340} \equiv 1 \pmod{341}$.

> [!summary] Definition - "Pseudoprime to the Base b"
> Let $b$ be a positive integer. If $n$ is a composite positive integer, and $b^{n-1} \equiv 1 \pmod n$, then $n$ is called a pseudoprime to the base $b$.

Given a positive integer $n$, determining whether $2^{n-1} \equiv 1 \pmod n$ is a useful test that provides some evidence concerning whether $n$ is prime.
- If $n$ satisfies this congruence, it is either prime or a pseudoprime to the base 2.
- If $n$ does not satisfy this congruence, it is composite.

We can perform similar tests using bases $b$ other than 2. If $n$ passes all such tests, it is either prime or a pseudoprime to all the bases $b$ we have chosen. Compared to primes, there are relatively few pseudoprimes to a base $b$. For instance, among the positive integers less than $10^{10}$ there are 455,052,512 primes, but only 14,884 pseudoprimes to the base 2.

Unfortunately, we cannot distinguish between primes and pseudoprimes just by choosing sufficiently many bases, because there are composite integers $n$ that pass all tests with bases $b$ such that $\gcd(b, n) = 1$.

> [!summary] Definition - "Carmichael Number"
> A composite integer $n$ that satisfies the congruence $b^{n-1} \equiv 1 \pmod n$ for all positive integers $b$ with $\gcd(b, n) = 1$ is called a Carmichael number. (These numbers are named after Robert Carmichael, who studied them in the early twentieth century.)

> [!example]
> **Problem:** Show that the integer 561 is a Carmichael number.
> 
> **Solution:**
> First, note that 561 is composite because $561 = 3 \cdot 11 \cdot 17$.
> Next, note that if $\gcd(b, 561) = 1$, then $\gcd(b, 3) = \gcd(b, 11) = \gcd(b, 17) = 1$.
> 
> Using Fermat’s little theorem, we find:
> - $b^2 \equiv 1 \pmod 3 \implies b^{560} = (b^2)^{280} \equiv 1 \pmod 3$
> - $b^{10} \equiv 1 \pmod{11} \implies b^{560} = (b^{10})^{56} \equiv 1 \pmod{11}$
> - $b^{16} \equiv 1 \pmod{17} \implies b^{560} = (b^{16})^{35} \equiv 1 \pmod{17}$
> 
> Since $b^{560} \equiv 1 \pmod 3$, $\pmod{11}$, and $\pmod{17}$, it follows that $b^{560} \equiv 1 \pmod{561}$ for all positive integers $b$ with $\gcd(b, 561) = 1$. Hence, 561 is a Carmichael number.

Although there are infinitely many Carmichael numbers, more delicate tests can be devised that can be used as the basis for efficient probabilistic primality tests. Such tests can be used to quickly show that it is almost certainly the case that a given integer is prime. More precisely, if an integer is not prime, the probability that it passes a series of tests is close to 0. These probabilistic primality tests are used to find large primes extremely rapidly on computers.
### Primitive Roots and Discrete Logarithms
In the set of positive real numbers, if $b > 1$ and $x = b^y$, we say that $y$ is the logarithm of $x$ to the base $b$. We can also define the concept of logarithms modulo $p$ of positive integers, where $p$ is a prime. Before doing so, we need a definition.

> [!summary] Definition - "Primitive Root"
> A primitive root modulo a prime $p$ is an integer $r$ in $\mathbb{Z}_p$ such that every nonzero element of $\mathbb{Z}_p$ is a power of $r$.

> [!example]
> **Problem:** Determine whether 2 and 3 are primitive roots modulo 11.
> 
> **Solution:**
> - Compute the powers of 2 in $\mathbb{Z}_{11}$:
>   $2^1 = 2$
>   $2^2 = 4$
>   $2^3 = 8$
>   $2^4 = 5$
>   $2^5 = 10$
>   $2^6 = 9$
>   $2^7 = 7$
>   $2^8 = 3$
>   $2^9 = 6$
>   $2^{10} = 1$
>   Because every nonzero element of $\mathbb{Z}_{11}$ is a power of 2, 2 is a primitive root of 11.
> 
> - Compute the powers of 3 in $\mathbb{Z}_{11}$:
>   $3^1 = 3$
>   $3^2 = 9$
>   $3^3 = 5$
>   $3^4 = 4$
>   $3^5 = 1$
>   This pattern repeats for higher powers. Because not all nonzero elements of $\mathbb{Z}_{11}$ are powers of 3, 3 is not a primitive root of 11.

An important fact in number theory is that there is a primitive root modulo $p$ for every prime $p$. Suppose that $p$ is prime and $r$ is a primitive root modulo $p$. If $a$ is an integer between 1 and $p - 1$, then there is a unique exponent $e$ such that $r^e \equiv a \pmod p$.

> [!summary] Definition - "Discrete Logarithm"
> Suppose that $p$ is a prime, $r$ is a primitive root modulo $p$, and $a$ is an integer between 1 and $p - 1$ inclusive. If $r^e \bmod p = a$ and $0 \le e \le p - 1$, we say that $e$ is the discrete logarithm of $a$ modulo $p$ to the base $r$ and we write $\log_r a = e$ (where the prime $p$ is understood).

> [!example]
> **Problem:** Find the discrete logarithms of 3 and 5 modulo 11 to the base 2.
> 
> **Solution:** When we computed the powers of 2 modulo 11 in the previous example, we found that:
> - $2^8 = 3$ in $\mathbb{Z}_{11}$. Hence, $\log_2 3 = 8$.
> - $2^4 = 5$ in $\mathbb{Z}_{11}$. Hence, $\log_2 5 = 4$.

> [!info] The Discrete Logarithm Problem
> The discrete logarithm problem takes as input a prime $p$, a primitive root $r$ modulo $p$, and a positive integer $a \in \mathbb{Z}_p$; its output is the discrete logarithm of $a$ modulo $p$ to the base $r$.
> 
> Although this problem might seem not to be that difficult, it turns out that no polynomial time algorithm is known for solving it. The difficulty of this problem plays an important role in cryptography.