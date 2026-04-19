---
tags:
  - "#CCT2"
  - DS
Topic: Algorithm design paradigms | Sorting algorithms | Introduction to recursive algorithms and recursive definitions | Correctness of recursive algorithms using induction | Greedy algorithms
Semester: CCT2
Course: Diskrete strukturer
Litterature: Discrete Mathematics and Its Applications - 8th Ed. | Introduction to Algorithms 4th Ed.
Created: 19-04-2026
---
- - -
# Table of Contents

1. [[#Algorithms|Algorithms]]
	1. [[#Algorithms#Complexity of Algorithms|Complexity of Algorithms]]
		1. [[#Complexity of Algorithms#Introduction|Introduction]]
		2. [[#Complexity of Algorithms#Time Complexity|Time Complexity]]
			1. [[#Time Complexity#Worst-Case Complexity|Worst-Case Complexity]]
			2. [[#Time Complexity#Average-Case Complexity|Average-Case Complexity]]
			3. [[#Time Complexity#Worst-Case Complexity of Two Sorting Algorithms|Worst-Case Complexity of Two Sorting Algorithms]]
		3. [[#Complexity of Algorithms#Complexity of Matrix Multiplication|Complexity of Matrix Multiplication]]
			1. [[#Complexity of Matrix Multiplication#Matrix-Chain Multiplication|Matrix-Chain Multiplication]]
		4. [[#Complexity of Algorithms#Algorithmic Paradigms|Algorithmic Paradigms]]
			1. [[#Algorithmic Paradigms#Brute-Force Algorithms|Brute-Force Algorithms]]
		5. [[#Complexity of Algorithms#Understanding the Complexity of Algorithms|Understanding the Complexity of Algorithms]]
			1. [[#Understanding the Complexity of Algorithms#Tractability|Tractability]]
			2. [[#Understanding the Complexity of Algorithms#P versus NP|P versus NP]]
			3. [[#Understanding the Complexity of Algorithms#Practical Considerations|Practical Considerations]]
2. [[#Induction Algorithms and Recursion|Induction Algorithms and Recursion]]
	1. [[#Induction Algorithms and Recursion#Recursive Algorithms|Recursive Algorithms]]
		1. [[#Recursive Algorithms#Introduction|Introduction]]
		2. [[#Recursive Algorithms#Examples of Recursive Algorithms|Examples of Recursive Algorithms]]
		3. [[#Recursive Algorithms#Proving Recursive Algorithms Correct|Proving Recursive Algorithms Correct]]
		4. [[#Recursive Algorithms#Recursion and Iteration|Recursion and Iteration]]
			1. [[#Recursion and Iteration#Fibonacci: Recursive vs. Iterative|Fibonacci: Recursive vs. Iterative]]
		5. [[#Recursive Algorithms#The Merge Sort|The Merge Sort]]
			1. [[#The Merge Sort#Merging Two Sorted Lists|Merging Two Sorted Lists]]
			2. [[#The Merge Sort#Complexity of Merge Sort|Complexity of Merge Sort]]
	2. [[#Induction Algorithms and Recursion#Program Correctness|Program Correctness]]
		1. [[#Program Correctness#Introduction|Introduction]]
		2. [[#Program Correctness#Program Verification|Program Verification]]
		3. [[#Program Correctness#Rules of Inference|Rules of Inference]]
		4. [[#Program Correctness#Conditional Statements|Conditional Statements]]
			1. [[#Conditional Statements#`if` Without `else`|`if` Without `else`]]
			2. [[#Conditional Statements#`if`–`else`|`if`–`else`]]
		5. [[#Program Correctness#Loop Invariants|Loop Invariants]]
	3. [[#Induction Algorithms and Recursion#Insertion Sort|Insertion Sort]]
		1. [[#Insertion Sort#Introduction|Introduction]]
		2. [[#Insertion Sort#The Insertion Sort Algorithm|The Insertion Sort Algorithm]]
		3. [[#Insertion Sort#Loop Invariants and Correctness|Loop Invariants and Correctness]]
		4. [[#Insertion Sort#Pseudocode Conventions|Pseudocode Conventions]]

# Algorithms
## Complexity of Algorithms

### Introduction

A satisfactory algorithm must first always produce the correct answer, and second, be efficient. Analyzing efficiency involves two primary measures:

- **Time complexity:** The number of operations required as a function of input size.
- **Space complexity:** The amount of computer memory required as a function of input size.

Space complexity is closely tied to specific data structures, so the focus here is exclusively on **time complexity**.

### Time Complexity

Time complexity is expressed in terms of the *number of operations* performed (comparisons, additions, multiplications, etc.) rather than actual clock time. This is because different computers perform basic operations at different speeds — for example, the fastest computers can perform a bit operation in $10^{-11}$ seconds, while personal computers may take $10^{-8}$ seconds for the same operation.

>[!example] Finding the Maximum Element in a List
>To find the maximum element in a list of $n$ elements, the algorithm sets a temporary maximum to the first element, then iterates through the rest. For each of the 2nd through $n$th elements, **two comparisons** are made:
>1. Check whether the end of the list has been reached ($i \leq n$)
>2. Check whether the current element is larger than the temporary maximum ($\text{max} < a_i$)
>
>One final comparison exits the loop when $i = n + 1$, giving a total of:
>$$2(n - 1) + 1 = 2n - 1 \text{ comparisons}$$
>This count is the same regardless of the specific input, so this algorithm has time complexity $\Theta(n)$.

>[!example] Linear Search
>At each step in the loop, two comparisons are performed: one to check whether the end of the list is reached ($i \leq n$), and one to compare the target element $x$ against the current list element ($x \neq a_i$). One additional comparison is made outside the loop.
>
>- If $x = a_i$, then $2i + 1$ comparisons are used.
>- If $x$ is **not** in the list, $2n + 2$ comparisons are used (the maximum).
>
>Therefore, linear search has **worst-case time complexity $\Theta(n)$**.

#### Worst-Case Complexity

*Worst-case complexity* refers to the maximum number of operations an algorithm requires for any input of a given size. It provides a guarantee: the algorithm will always finish within this bound.

>[!example] Binary Search
>Assume a sorted list of $n = 2^k$ elements. At each stage, two comparisons are made:
>1. Check if the restricted search range still has more than one element ($i < j$)
>2. Compare the target $x$ against the middle element
>
>Each stage halves the search space. Starting from $2^k$ elements and working down to 1 element takes $k$ stages, each using 2 comparisons. The final single-element check requires 2 more comparisons (one to see no elements remain, one to check if it's $x$):
>$$\text{Total} \leq 2k + 2 = 2\log n + 2 \text{ comparisons}$$
>Binary search therefore has **worst-case time complexity $\Theta(\log n)$**, making it more efficient than linear search in the worst case.

#### Average-Case Complexity

*Average-case complexity* measures the average number of operations over all possible inputs of a given size. It is generally more difficult to compute than worst-case complexity.

>[!example] Average-Case Linear Search
>Assuming $x$ is guaranteed to be in the list, and equally likely to be at any position, finding $x$ at position $i$ requires $2i + 1$ comparisons. Averaging over all positions:
>$$\text{Average} = \frac{3 + 5 + 7 + \cdots + (2n+1)}{n} = \frac{2(1 + 2 + \cdots + n) + n}{n}$$
>Using the formula $1 + 2 + \cdots + n = \dfrac{n(n+1)}{2}$:
>$$\text{Average} = \frac{2 \cdot \frac{n(n+1)}{2}}{n} + 1 = n + 2$$
>This is $\Theta(n)$, consistent with the worst-case result.

#### Worst-Case Complexity of Two Sorting Algorithms

>[!example] Bubble Sort
>Bubble sort makes repeated passes through a list, comparing adjacent elements. During the $i$th pass, exactly $n - i$ comparisons are made. The total number of comparisons over all $n - 1$ passes is:
>$$(n-1) + (n-2) + \cdots + 2 + 1 = \frac{(n-1)n}{2}$$
>Bubble sort always performs this full count of comparisons, even if the list becomes sorted early. Therefore, its worst-case (and always-case) complexity is $\Theta(n^2)$.

>[!example] Insertion Sort
>Insertion sort places the $j$th element into its correct position among the first $j - 1$ already-sorted elements using a linear scan. In the worst case, $j$ comparisons are needed to place the $j$th element. Summing over all elements from the 2nd to the $n$th:
>$$2 + 3 + \cdots + n = \frac{n(n+1)}{2} - 1$$
>Insertion sort has **worst-case complexity $\Theta(n^2)$**, though it may use far fewer comparisons in favorable arrangements (e.g., when the list is nearly sorted).

### Complexity of Matrix Multiplication

Given an $m \times k$ matrix $A$ and a $k \times n$ matrix $B$, their product $C = AB$ is an $m \times n$ matrix. Each entry $c_{ij}$ is computed as a dot product of a row of $A$ and a column of $B$.

```pseudocode
procedure matrix multiplication(A, B: matrices)
for i := 1 to m
    for j := 1 to n
        cij := 0
        for q := 1 to k
            cij := cij + aiq * bqj  -- accumulate the dot product entry by entry
return C   -- C = [cij] is the product of A and B
```

>[!example] Multiplying Two $n \times n$ Matrices
>The product has $n^2$ entries. Computing each entry requires:
>- $n$ multiplications
>- $n - 1$ additions
>
>Total across all entries:
>- **$n^3$ multiplications**
>- **$n^2(n-1)$ additions**
>
>This gives an overall complexity of $O(n^3)$. More advanced algorithms can reduce this to $O(n^{\sqrt{7}})$ multiplications and additions.

The Boolean product $A \odot B$ of two zero-one matrices follows the same structure, but uses `OR` ($\vee$) in place of addition and `AND` ($\wedge$) in place of multiplication:

```pseudocode
procedure Boolean product of Zero–One Matrices (A, B: zero–one matrices)
for i := 1 to m
    for j := 1 to n
        cij := 0
        for q := 1 to k
            cij := cij ∨ (aiq ∧ bqj)  -- OR and AND replace + and *
return C   -- C = [cij] is the Boolean product of A and B
```

>[!example] Boolean Product of $n \times n$ Zero-One Matrices
>Each of the $n^2$ entries requires $n$ OR operations and $n$ AND operations, for $2n$ bit operations per entry. The total is:
>$$2n \times n^2 = 2n^3 \text{ bit operations}$$

#### Matrix-Chain Multiplication

When multiplying a chain of matrices $A_1 A_2 \cdots A_n$, the order in which pairs are multiplied doesn't change the final result (matrix multiplication is associative), but it can dramatically affect the total number of operations. Multiplying an $m_1 \times m_2$ matrix by an $m_2 \times m_3$ matrix requires $m_1 m_2 m_3$ integer multiplications.

>[!example] Optimal Ordering for $A_1 A_2 A_3$
>Let $A_1$ be $30 \times 20$, $A_2$ be $20 \times 40$, and $A_3$ be $40 \times 10$.
>
>**Option 1:** $A_1(A_2 A_3)$
>- $A_2 A_3$: $20 \cdot 40 \cdot 10 = 8{,}000$ multiplications → gives a $20 \times 10$ matrix
>- $A_1 (A_2 A_3)$: $30 \cdot 20 \cdot 10 = 6{,}000$ multiplications
>- **Total: $14{,}000$ multiplications**
>
>**Option 2:** $(A_1 A_2) A_3$
>- $A_1 A_2$: $30 \cdot 20 \cdot 40 = 24{,}000$ multiplications → gives a $30 \times 40$ matrix
>- $(A_1 A_2) A_3$: $30 \cdot 40 \cdot 10 = 12{,}000$ multiplications
>- **Total: $36{,}000$ multiplications**
>
>Option 1 is significantly more efficient. Choosing the right multiplication order matters.

### Algorithmic Paradigms

An *algorithmic paradigm* is a general problem-solving strategy that can be applied across a wide range of problems. Greedy algorithms are one such paradigm. The focus here is on another foundational paradigm: brute force.

#### Brute-Force Algorithms

A *brute-force algorithm* solves a problem in the most direct way possible, based on the problem's definition, without exploiting special structure or clever shortcuts. Often this means checking every possible solution.

Examples of brute-force algorithms include:
- Summing $n$ numbers by adding them one at a time
- Matrix multiplication from its definition
- Bubble sort, insertion sort, and selection sort

Although brute-force algorithms are often inefficient, they are still useful — they can handle small inputs practically, and they serve as a baseline for measuring the improvement of more sophisticated algorithms.

>[!example] Brute-Force Closest Pair of Points
>Given $n$ points $(x_1, y_1), (x_2, y_2), \ldots, (x_n, y_n)$ in the plane, the brute-force approach computes the squared distance between every pair and tracks the minimum.
>
>(Squared distance is used instead of actual distance because it avoids a square root computation while still identifying the closest pair — the pair with the smallest squared distance is the same as the pair with the smallest actual distance.)
>
>```pseudocode
>procedure closest-pair((x1,y1),(x2,y2),…,(xn,yn): pairs of real numbers)
>min := ∞
>for i := 2 to n
>    for j := 1 to i − 1
>        if (xj − xi)^2 + (yj − yi)^2 < min then
>            min := (xj − xi)^2 + (yj − yi)^2   -- update minimum squared distance
>            closest pair := ((xi, yi),(xj, yj))  -- update closest pair
>return closest pair
>```
>
>There are $\dfrac{n(n-1)}{2}$ pairs to check. Each check involves a fixed number of arithmetic operations and one comparison, so the algorithm uses $\Theta(n^2)$ operations overall.

### Understanding the Complexity of Algorithms

The table below summarizes common complexity classes and their terminology:

| Complexity | Terminology |
|---|---|
| $\Theta(1)$ | Constant complexity |
| $\Theta(\log n)$ | Logarithmic complexity |
| $\Theta(n)$ | Linear complexity |
| $\Theta(n \log n)$ | Linearithmic complexity |
| $\Theta(n^b)$ | Polynomial complexity |
| $\Theta(b^n)$, where $b > 1$ | Exponential complexity |
| $\Theta(n!)$ | Factorial complexity |

Key examples:
- **Constant:** An algorithm that always examines exactly 100 elements regardless of input size has $\Theta(1)$ complexity.
- **Logarithmic:** Binary search — $\Theta(\log n)$ worst case.
- **Linear:** Linear search — $\Theta(n)$ worst/average case.
- **Linearithmic:** Merge sort — $\Theta(n \log n)$ worst case.
- **Polynomial:** Bubble sort — $\Theta(n^2)$ worst case.
- **Exponential:** Checking all truth-value assignments to determine satisfiability of a propositional formula with $n$ variables — $\Theta(2^n)$.
- **Factorial:** Finding all possible orderings a traveling salesperson could use to visit $n$ cities — $\Theta(n!)$.

#### Tractability

>[!info] Tractable vs. Intractable Problems
>- A problem is **tractable** if it can be solved by an algorithm with polynomial (or better) worst-case complexity. The expectation is that the algorithm will finish in a reasonable time for reasonably sized inputs.
>- A problem is **intractable** if no polynomial-time algorithm is known for it. In general, intractable problems require enormous time even for small inputs in the worst case.
>
>**Important caveat:** Polynomial worst-case complexity does not guarantee fast performance in practice. If the polynomial has a very high degree or very large coefficients, the algorithm may still be very slow. In practice, however, polynomials arising in algorithm analysis tend to have small degrees and coefficients.

Intractable problems can still be managed in practice through two approaches:
- **Average-case analysis:** Some algorithms solve the vast majority of real inputs quickly, even if the worst case is slow.
- **Approximate solutions:** Instead of exact answers, fast algorithms can often find solutions that are very close to optimal.

Some problems go even further — they are *unsolvable*, meaning no algorithm exists to solve them at all. The first proof of an unsolvable problem was given by Alan Turing, who showed that the *halting problem* (determining whether an arbitrary program will eventually stop) cannot be solved by any algorithm.

#### P versus NP

>[!info] P and NP
>- **Class P:** Problems solvable in polynomial worst-case time (tractable problems).
>- **Class NP:** Problems for which a proposed solution can be *verified* in polynomial time. NP stands for *nondeterministic polynomial time*.
>
>Every problem in P is also in NP, but whether $P = NP$ is unknown.

A key example is the *satisfiability problem*: given a compound proposition, determine if there is some assignment of truth values to its variables that makes it true. Verifying a solution is fast, but finding one requires (as far as is known) exponential time — checking all $2^n$ possible assignments.

>[!info] NP-Complete Problems
>*NP-complete problems* are a special subset of NP with a remarkable property: if any NP-complete problem can be solved in polynomial time, then *every* problem in NP can be solved in polynomial time.
>
>The satisfiability problem was the first problem proven to be NP-complete — a result known as the **Cook-Levin theorem**, independently proved by Stephen Cook and Leonid Levin in the early 1970s. Over 3,000 NP-complete problems are now known.

The **P versus NP problem** — whether the class of problems verifiable in polynomial time equals the class of problems solvable in polynomial time — is one of the most famous unsolved problems in mathematics and computer science. It is one of the seven Millennium Prize Problems, with a $1,000,000 prize offered by the Clay Mathematics Institute. Most theoretical computer scientists believe $P \neq NP$, since despite extensive research, no polynomial-time algorithm has ever been found for any NP-complete problem.

#### Practical Considerations

A $\Theta(g(n))$ estimate for time complexity means there exist constants $C_1$, $C_2$, and $k$ such that:
$$C_1 g(n) \leq f(n) \leq C_2 g(n) \quad \text{for all } n > k$$

Without knowing these constants, the exact number of operations cannot be determined from the estimate alone. Similarly, the actual time depends on the computer and implementation. In practice, big-$O$ estimates (which give an upper bound only) are commonly used instead of full $\Theta$ estimates, with the understanding that $\Theta$ estimates would be more precise.

The following table shows the actual time required to execute a given number of bit operations, assuming $10^{-11}$ seconds per bit operation (a reasonable estimate for the fastest computers available in 2018). Entries marked with `*` exceed $10^{100}$ years.

| Problem Size ($n$) | $\log n$ | $n$ | $n \log n$ | $n^2$ | $2^n$ | $n!$ |
|---|---|---|---|---|---|---|
| $10$ | $3 \times 10^{-11}\,\text{s}$ | $10^{-10}\,\text{s}$ | $3 \times 10^{-10}\,\text{s}$ | $10^{-9}\,\text{s}$ | $10^{-8}\,\text{s}$ | $3 \times 10^{-7}\,\text{s}$ |
| $10^2$ | $7 \times 10^{-11}\,\text{s}$ | $10^{-9}\,\text{s}$ | $7 \times 10^{-9}\,\text{s}$ | $10^{-7}\,\text{s}$ | $4 \times 10^{11}\,\text{yr}$ | `*` |
| $10^3$ | $1.0 \times 10^{-10}\,\text{s}$ | $10^{-8}\,\text{s}$ | $1 \times 10^{-7}\,\text{s}$ | $10^{-5}\,\text{s}$ | `*` | `*` |
| $10^4$ | $1.3 \times 10^{-10}\,\text{s}$ | $10^{-7}\,\text{s}$ | $1 \times 10^{-6}\,\text{s}$ | $10^{-3}\,\text{s}$ | `*` | `*` |
| $10^5$ | $1.7 \times 10^{-10}\,\text{s}$ | $10^{-6}\,\text{s}$ | $2 \times 10^{-5}\,\text{s}$ | $0.1\,\text{s}$ | `*` | `*` |
| $10^6$ | $2 \times 10^{-10}\,\text{s}$ | $10^{-5}\,\text{s}$ | $2 \times 10^{-4}\,\text{s}$ | $0.17\,\text{min}$ | `*` | `*` |

The table makes the practical impact of complexity class very clear: polynomial algorithms scale to large inputs, while exponential and factorial algorithms become completely infeasible even for modest input sizes. This holds even as computers become faster — improvements in hardware help polynomial-time algorithms the most but offer only marginal gains against exponential or factorial complexity.
# Induction Algorithms and Recursion
## Recursive Algorithms

### Introduction

Some problems can be solved by reducing them to a simpler version of the same problem with smaller input. This reduction is applied repeatedly until the problem reaches a *base case* — a simple version with a known solution.

For example, finding $\gcd(a, b)$ where $b > a$ can be reduced using the identity:
$$\gcd(a, b) = \gcd(b \mod a, a)$$
This reduction continues until the smaller number reaches zero, at which point $\gcd(a, 0) = a$.

>[!info] Recursive Algorithm
>An algorithm is called *recursive* if it solves a problem by reducing it to an instance of the **same problem with smaller input**.

Every recursive algorithm has two essential parts:
- **Base case:** A simple input for which the answer is known directly (no further reduction needed).
- **Recursive step:** A rule that reduces the current input to a smaller input and calls the algorithm again.

---

### Examples of Recursive Algorithms

>[!example] Computing $n!$
>The factorial function is defined recursively: $n! = n \cdot (n-1)!$ for $n > 0$, with base case $0! = 1$.
>
>```pseudocode
>procedure factorial(n: nonnegative integer)
>if n = 0 then
>    return 1          -- base case
>else
>    return n · factorial(n − 1)   -- recursive step: reduce n by 1
>-- output is n!
>```
>
>**Trace for $n = 4$:**
>- $4! = 4 \cdot 3!$
>- $3! = 3 \cdot 2!$
>- $2! = 2 \cdot 1!$
>- $1! = 1 \cdot 0! = 1 \cdot 1 = 1$
>
>Working back up: $2! = 2$, $3! = 6$, $4! = 24$.

>[!example] Computing $a^n$
>Exponentiation is defined recursively: $a^n = a \cdot a^{n-1}$ for $n > 0$, with base case $a^0 = 1$.
>
>```pseudocode
>procedure power(a: nonzero real number, n: nonnegative integer)
>if n = 0 then
>    return 1              -- base case
>else
>    return a · power(a, n − 1)    -- recursive step: reduce exponent by 1
>-- output is a^n
>```

>[!example] Computing $\gcd(a, b)$
>The Euclidean algorithm is expressed recursively using the identity $\gcd(a, b) = \gcd(b \mod a, a)$, with base case $\gcd(0, b) = b$.
>
>```pseudocode
>procedure gcd(a, b: nonnegative integers with a < b)
>if a = 0 then
>    return b              -- base case
>else
>    return gcd(b mod a, a)    -- recursive step: reduce to smaller pair
>-- output is gcd(a, b)
>```
>
>**Trace for $a = 5$, $b = 8$:**
>$$\gcd(5,8) \to \gcd(3,5) \to \gcd(2,3) \to \gcd(1,2) \to \gcd(0,1) = 1$$

>[!example] Recursive Modular Exponentiation
>Computing $b^n \mod m$ directly by repeated multiplication is slow. A more efficient approach halves the exponent at each step:
>
>$$b^n \mod m = \begin{cases} (b^{n/2} \mod m)^2 \mod m & \text{if } n \text{ is even} \\ \left((b^{\lfloor n/2 \rfloor} \mod m)^2 \mod m \cdot b \mod m\right) \mod m & \text{if } n \text{ is odd} \end{cases}$$
>
>- **Breakdown:**
>    - **$b$** : The base being exponentiated.
>    - **$n$** : The exponent; halved at each recursive step, giving $O(\log n)$ depth.
>    - **$m$** : The modulus; all intermediate results are reduced mod $m$ to keep numbers small.
>    - **$\lfloor n/2 \rfloor$** : The floor function — the largest integer less than or equal to $n/2$, used to handle odd exponents.
>
>```pseudocode
>procedure mpower(b, n, m: integers with b > 0, m ≥ 2, n ≥ 0)
>if n = 0 then
>    return 1                                          -- base case: b^0 = 1
>else if n is even then
>    return mpower(b, n/2, m)^2 mod m                 -- halve exponent (even case)
>else
>    return (mpower(b, ⌊n/2⌋, m)^2 mod m · b mod m) mod m   -- halve exponent (odd case)
>-- output is b^n mod m
>```
>
>**Trace for $b = 2$, $n = 5$, $m = 3$:**
>- $\text{mpower}(2, 5, 3)$: odd → uses $\text{mpower}(2, 2, 3)$
>- $\text{mpower}(2, 2, 3)$: even → uses $\text{mpower}(2, 1, 3)$
>- $\text{mpower}(2, 1, 3)$: odd → uses $\text{mpower}(2, 0, 3)$
>- $\text{mpower}(2, 0, 3) = 1$ (base case)
>
>Working back up: $\text{mpower}(2,1,3) = (1^2 \mod 3 \cdot 2 \mod 3) \mod 3 = 2$, then $\text{mpower}(2,2,3) = 2^2 \mod 3 = 1$, then $\text{mpower}(2,5,3) = (1^2 \mod 3 \cdot 2 \mod 3) \mod 3 = 2$.

>[!example] Recursive Linear Search
>To search for the first occurrence of $x$ in the sequence $a_1, a_2, \ldots, a_n$, compare $x$ to the first element of the current search range. If it matches, return its position. If the range has been reduced to a single non-matching element, return 0 (not found). Otherwise, search the remaining elements.
>
>The procedure `search(i, j, x)` searches for $x$ in $a_i, a_{i+1}, \ldots, a_j$. It is initially called as `search(1, n, x)`.
>
>```pseudocode
>procedure search(i, j, x: integers, 1 ≤ i ≤ j ≤ n)
>if ai = x then
>    return i              -- found: return position
>else if i = j then
>    return 0              -- base case: single element, not a match
>else
>    return search(i + 1, j, x)   -- recursive step: skip first element, search the rest
>-- output is the location of x in a1, a2, …, an if found; otherwise 0
>```

>[!example] Recursive Binary Search
>To search for $x$ in a sorted sequence $a_1, a_2, \ldots, a_n$, compare $x$ to the middle element $a_m$ where $m = \lfloor(i+j)/2\rfloor$. If they match, return $m$. If $x$ is smaller and there are elements to the left of $m$, search the left half. If $x$ is larger and there are elements to the right, search the right half. If neither condition applies, $x$ is not in the sequence.
>
>The procedure `binary search(i, j, x)` searches for $x$ in $a_i, \ldots, a_j$. It is initially called as `binary search(1, n, x)`.
>
>```pseudocode
>procedure binary search(i, j, x: integers, 1 ≤ i ≤ j ≤ n)
>m := ⌊(i + j)/2⌋
>if x = am then
>    return m                              -- found: return position
>else if (x < am and i < m) then
>    return binary search(i, m − 1, x)    -- search left half
>else if (x > am and j > m) then
>    return binary search(m + 1, j, x)    -- search right half
>else
>    return 0                              -- not found
>-- output is the location of x in a1, a2, …, an if found; otherwise 0
>```
### Proving Recursive Algorithms Correct

Mathematical induction — and its variant, *strong induction* — is the standard tool for proving that a recursive algorithm is correct, meaning it produces the right output for every valid input.

The structure maps naturally onto recursion:
- The **basis step** proves correctness at the base case of the algorithm.
- The **inductive step** proves that if the algorithm works correctly for smaller inputs (the inductive hypothesis), then it works correctly for the current input as well.

>[!example] Proving the Recursive Power Algorithm Correct
>**Claim:** The recursive algorithm for computing $a^n$ correctly returns $a^n$ for all nonzero real $a$ and nonnegative integers $n$.
>
>**Proof by mathematical induction on $n$:**
>
>**Basis step ($n = 0$):** The algorithm returns $1$. Since $a^0 = 1$ for every nonzero real number $a$, this is correct.
>
>**Inductive step:** Assume the algorithm correctly computes $a^k$ for some arbitrary nonnegative integer $k$, i.e., `power(a, k)` $= a^k$. We must show the algorithm correctly computes $a^{k+1}$.
>
>Since $k + 1 > 0$, the algorithm executes the recursive branch:
>$$\text{power}(a,\, k+1) = a \cdot \text{power}(a,\, k)$$
>By the inductive hypothesis, $\text{power}(a, k) = a^k$, so:
>$$\text{power}(a,\, k+1) = a \cdot a^k = a^{k+1}$$
>This completes the inductive step. Therefore, the algorithm correctly computes $a^n$ for all nonzero $a$ and nonnegative integers $n$. $\blacksquare$

In general, strong induction is needed rather than simple induction for recursive algorithms, because the recursive step may reduce to a smaller input that is not necessarily $k - 1$ exactly (it could be any smaller value).

>[!example] Proving the Recursive Modular Exponentiation Algorithm Correct
>**Claim:** The recursive modular exponentiation algorithm correctly returns $b^n \mod m$ for all positive integers $b$, nonnegative integers $n$, and integers $m \geq 2$.
>
>**Proof by strong induction on $n$:**
>
>**Basis step ($n = 0$):** The algorithm returns $1$. Since $b^0 \mod m = 1$, this is correct.
>
>**Inductive step:** Assume `mpower(b, j, m)` $= b^j \mod m$ for all $0 \leq j < k$. We must show `mpower(b, k, m)` $= b^k \mod m$.
>
>The algorithm handles even and odd $k$ separately, so we consider each case:
>
>**Case 1 — $k$ is even:**
>$$\text{mpower}(b, k, m) = (\text{mpower}(b,\, k/2,\, m))^2 \mod m$$
>By the inductive hypothesis (since $k/2 < k$), $\text{mpower}(b, k/2, m) = b^{k/2} \mod m$, so:
>$$= (b^{k/2} \mod m)^2 \mod m = b^k \mod m$$
>
>**Case 2 — $k$ is odd:**
>$$\text{mpower}(b, k, m) = \left((\text{mpower}(b,\, \lfloor k/2 \rfloor,\, m))^2 \mod m \cdot b \mod m\right) \mod m$$
>By the inductive hypothesis (since $\lfloor k/2 \rfloor < k$), $\text{mpower}(b, \lfloor k/2 \rfloor, m) = b^{\lfloor k/2 \rfloor} \mod m$, so:
>$$= \left((b^{\lfloor k/2 \rfloor} \mod m)^2 \mod m \cdot b \mod m\right) \mod m = b^{2\lfloor k/2 \rfloor + 1} \mod m$$
>Since $k$ is odd, $\lfloor k/2 \rfloor = (k-1)/2$, so $2\lfloor k/2 \rfloor + 1 = k$. Therefore:
>$$= b^k \mod m$$
>
>In both cases, the algorithm returns the correct value. This completes the inductive step. $\blacksquare$

>[!note] Why Strong Induction?
>In the modular exponentiation proof, the recursive call uses $\lfloor k/2 \rfloor$, which is not necessarily $k - 1$. Simple induction only provides a hypothesis about $k - 1$, which would not be sufficient here. Strong induction provides the hypothesis for *all* values less than $k$, which covers any smaller input the recursive call might use.
### Recursion and Iteration

A recursive algorithm evaluates a function by repeatedly reducing the problem to smaller inputs until reaching a base case. An *iterative* approach does the opposite — it starts from the base case(s) and works *upward*, computing successive values until the desired result is reached.

Iterative algorithms are often far more computationally efficient than their recursive counterparts, though recursive implementations are sometimes preferred when they are simpler to write and understand.

#### Fibonacci: Recursive vs. Iterative

The Fibonacci sequence is defined recursively as $f_n = f_{n-1} + f_{n-2}$, with base cases $f_0 = 0$ and $f_1 = 1$. This naturally suggests a recursive algorithm:

```pseudocode
procedure fibonacci(n: nonnegative integer)
if n = 0 then
    return 0                                    -- base case
else if n = 1 then
    return 1                                    -- base case
else
    return fibonacci(n − 1) + fibonacci(n − 2)  -- recursive step: sum of two previous values
-- output is fibonacci(n)
```

The problem with this approach is that the number of recursive calls grows rapidly. Each call that isn't a base case spawns *two* more calls, meaning the number of evaluations roughly doubles at each level. Computing $f_n$ this way requires $f_{n+1} - 1$ additions — exponential growth.

The iterative approach avoids this by building up from the base cases:

```pseudocode
procedure iterative fibonacci(n: nonnegative integer)
if n = 0 then return 0
else
    x := 0      -- tracks f_{i-1}, initialized to f_0
    y := 1      -- tracks f_i, initialized to f_1
    for i := 1 to n − 1
        z := x + y   -- compute next Fibonacci number
        x := y        -- shift: x moves up one position
        y := z        -- shift: y moves up one position
    return y
-- output is the nth Fibonacci number
```

At each iteration, `x` and `y` hold two consecutive Fibonacci numbers, and the loop advances both by one position. After $n - 1$ iterations, `y` holds $f_n$. This requires only $n - 1$ additions total — a dramatic improvement over the recursive version.

>[!warning] Recursion Can Be Expensive
>For recursively defined sequences like Fibonacci, the recursive algorithm may recompute the same values many times. The iterative version avoids this entirely. Unless the hardware or runtime environment is specifically optimized for recursion, the iterative approach will be significantly faster.

---

### The Merge Sort

*Merge sort* is a recursive sorting algorithm that works by repeatedly splitting a list into two roughly equal halves, sorting each half, and then merging the two sorted halves back together.

>[!example] Merge Sort on a List
>To sort the list $8, 2, 4, 6, 9, 7, 10, 1, 5, 3$:
>
>**Splitting phase:** The list is recursively split into halves until every sublist contains a single element. A list of 10 elements becomes two lists of 5, then four sublists, and so on down to individual elements.
>
>**Merging phase:** Single-element lists are trivially sorted. Pairs of sorted sublists are merged into sorted lists of length two, then pairs of those are merged into sorted lists of length four, and so on, until the entire list is sorted.

The general recursive structure is:

```pseudocode
procedure mergesort(L = a1, …, an)
if n > 1 then
    m := ⌊n/2⌋
    L1 := a1, a2, …, am          -- left half
    L2 := am+1, am+2, …, an      -- right half
    L := merge(mergesort(L1), mergesort(L2))   -- sort each half, then merge
-- L is now sorted in nondecreasing order
```

#### Merging Two Sorted Lists

The core operation in merge sort is merging two already-sorted lists into a single sorted list. The strategy is to repeatedly compare the smallest remaining elements of each list and move the smaller one to the output, continuing until one list is exhausted, then appending the remainder of the other.

>[!example] Merging $2, 3, 5, 6$ and $1, 4$
>
>| First List | Second List | Merged List | Comparison |
>|:---|:---|:---|:---|
>| 2, 3, 5, 6 | 1, 4 | | $1 < 2$ |
>| 2, 3, 5, 6 | 4 | 1 | $2 < 4$ |
>| 3, 5, 6 | 4 | 1, 2 | $3 < 4$ |
>| 5, 6 | 4 | 1, 2, 3 | $4 < 5$ |
>| 5, 6 | | 1, 2, 3, 4 | (second list empty) |
>| | | 1, 2, 3, 4, 5, 6 | (done) |

```pseudocode
procedure merge(L1, L2: sorted lists)
L := empty list
while L1 and L2 are both nonempty
    remove the smaller of the first elements of L1 and L2 from its list
    put it at the right end of L          -- always take the current minimum
if this removal makes one list empty then
    remove all elements from the other list and append them to L   -- no more comparisons needed
return L
-- L is the merged list in increasing order
```

>[!summary] Lemma: Cost of Merging
>Two sorted lists with $m$ and $n$ elements can be merged into a single sorted list using **at most $m + n - 1$ comparisons**.
>
>**Reasoning:** Each comparison places exactly one element into the merged list. Once one list is empty, the remaining elements of the other are appended without any comparisons. The worst case occurs when the last comparison leaves one element in each list — after $m + n - 2$ comparisons, one final comparison empties one list, for a total of $m + n - 1$.

#### Complexity of Merge Sort

Assume the list has $n = 2^m$ elements (a power of 2 for simplicity; the result generalizes).

**Splitting** divides the list into successively smaller sublists. At level $k$ of the split, there are $2^k$ sublists each containing $2^{m-k}$ elements.

**Merging** works back up from $m$ levels of single-element lists. At level $k$ (merging upward), $2^{k-1}$ pairs of lists, each with $2^{m-k}$ elements, are merged into $2^{k-1}$ lists with $2^{m-k+1}$ elements. By the lemma, each such merge uses at most:
$$2^{m-k} + 2^{m-k} - 1 = 2^{m-k+1} - 1 \text{ comparisons}$$

The total comparisons going from level $k$ to level $k - 1$ is at most:
$$2^{k-1}(2^{m-k+1} - 1)$$

Summing over all $m$ levels:
$$\sum_{k=1}^{m} 2^{k-1}(2^{m-k+1} - 1) = \sum_{k=1}^{m} 2^m - \sum_{k=1}^{m} 2^{k-1} = m \cdot 2^m - (2^m - 1)$$

Substituting $n = 2^m$ and $m = \log n$:
$$= n \log n - n + 1$$

>[!summary] Theorem: Merge Sort Complexity
>The number of comparisons needed to merge sort a list of $n$ elements is $O(n \log n)$.
>
>This makes merge sort significantly more efficient than sorting algorithms like bubble sort or insertion sort, which have $\Theta(n^2)$ worst-case complexity.
## Program Correctness

### Introduction

Even after a program is syntactically correct and passes all test cases, it may still produce wrong answers for untested inputs. Testing alone is not sufficient to guarantee correctness — a *proof* is needed. **Program verification** is the formal proof that a program always produces the correct output for every valid input, using rules of inference and proof techniques including mathematical induction.

### Program Verification

>[!info] Program Correctness and Partial Correctness
>A program is **correct** if it produces the correct output for every possible input. Proving correctness has two parts:
>1. **Partial correctness:** If the program terminates, it produces the correct output.
>2. **Termination:** The program always terminates.
>
>Two propositions frame what "correct" means for a given program:
>- The **initial assertion** $p$: properties that the input values must satisfy.
>- The **final assertion** $q$: properties that the output must satisfy if the program behaved as intended.

>[!info] Hoare Triple — Partial Correctness Notation
>A program segment $S$ is **partially correct** with respect to initial assertion $p$ and final assertion $q$ if: whenever $p$ is true for the inputs and $S$ terminates, then $q$ is true for the outputs.
>
>This is written as a **Hoare triple**:
>$$p\{S\}q$$
>This notation was introduced by Tony Hoare.

>[!example] Verifying a Simple Program Segment
>**Program:**
>```
>y := 2
>z := x + y
>```
>**Initial assertion $p$:** $x = 1$
>**Final assertion $q$:** $z = 3$
>
>**Verification:** If $p$ is true, then $x = 1$ at the start. The first statement sets $y := 2$. The second sets $z := x + y = 1 + 2 = 3$. So $q$ is satisfied. Therefore $p\{S\}q$ holds.

### Rules of Inference

A program $S$ can be split into sequential subprograms $S_1$ and $S_2$, written $S = S_1;\, S_2$, to make verification more manageable. The **composition rule** states:

$$\frac{p\{S_1\}q \quad q\{S_2\}r}{p\{S_1;\, S_2\}r}$$

If $S_1$ is correct with respect to $p$ and $q$, and $S_2$ is correct with respect to $q$ and $r$, then the combined program is correct with respect to $p$ and $r$. The final assertion of one segment becomes the initial assertion of the next.

### Conditional Statements

#### `if` Without `else`

For a segment of the form:
```
if condition then
    S
```

$S$ executes only when `condition` is true; it is skipped when `condition` is false. To verify $p\{\text{if condition then } S\}q$, two things must be shown:
1. $(p \,\wedge\, \text{condition})\{S\}q$ — if the condition holds, $S$ leads to $q$.
2. $(p \,\wedge\, \neg\,\text{condition}) \to q$ — if the condition doesn't hold, $q$ is already satisfied without executing $S$.

$$\frac{(p \wedge \text{condition})\{S\}q \quad (p \wedge \neg\,\text{condition}) \to q}{p\{\text{if condition then } S\}q}$$

>[!example] Verifying an `if` Statement
>**Program:**
>```
>if x > y then
>    y := x
>```
>**Initial assertion $p$:** $T$ (always true)
>**Final assertion $q$:** $y \geq x$
>
>**Verification:**
>- If $x > y$: the assignment $y := x$ is executed, so $y = x$, meaning $y \geq x$. ✓
>- If $x \leq y$: the body is skipped, and $y \geq x$ already holds. ✓
>
>Both cases satisfy $q$, so the segment is correct with respect to $p$ and $q$.

#### `if`–`else`

For a segment of the form:
```
if condition then
    S1
else
    S2
```

To verify $p\{\text{if condition then } S_1 \text{ else } S_2\}q$:
1. $(p \,\wedge\, \text{condition})\{S_1\}q$ — if the condition holds, $S_1$ leads to $q$.
2. $(p \,\wedge\, \neg\,\text{condition})\{S_2\}q$ — if the condition doesn't hold, $S_2$ leads to $q$.

$$\frac{(p \wedge \text{condition})\{S_1\}q \quad (p \wedge \neg\,\text{condition})\{S_2\}q}{p\{\text{if condition then } S_1 \text{ else } S_2\}q}$$

>[!example] Verifying an `if`–`else` Statement
>**Program:**
>```
>if x < 0 then
>    abs := −x
>else
>    abs := x
>```
>**Initial assertion $p$:** $T$ (always true)
>**Final assertion $q$:** $\text{abs} = |x|$
>
>**Verification:**
>- If $x < 0$: the statement `abs := −x` is executed. By definition, $|x| = -x$ when $x < 0$, so $\text{abs} = |x|$. ✓
>- If $x \geq 0$: the statement `abs := x` is executed. By definition, $|x| = x$ when $x \geq 0$, so $\text{abs} = |x|$. ✓
>
>Both branches satisfy $q$, so the segment is correct with respect to $p$ and $q$.
### Loop Invariants

A **loop invariant** is an assertion that remains true every time the body of a loop is executed. Loop invariants are the key tool for proving the correctness of `while` loops.

For a loop of the form:
```
while condition
    S
```

An assertion $p$ is a loop invariant if, whenever $p$ is true and `condition` holds at the start of an execution of $S$, $p$ is still true after $S$ finishes:
$$(p \wedge \text{condition})\{S\}p$$

If $p$ is a loop invariant and $p$ is true before the loop begins, then after the loop terminates (if it does), both $p$ and $\neg\,\text{condition}$ will be true. This gives the rule of inference:

$$\frac{(p \wedge \text{condition})\{S\}p}{p\{\text{while condition } S\}(\neg\,\text{condition} \wedge p)}$$

>[!note] What Loop Invariants Establish
>A loop invariant alone only establishes *partial* correctness — it tells us what is true *if* the loop terminates. Termination must be argued separately, typically by identifying a quantity that decreases (or increases toward a bound) with each iteration.

>[!example] Verifying a Factorial Loop
>**Program:**
>```
>i := 1
>factorial := 1
>while i < n
>    i := i + 1
>    factorial := factorial · i
>```
>**Goal:** Show that when this terminates, `factorial` $= n!$ for a positive integer $n$.
>
>**Loop invariant $p$:** `factorial` $= i!$ and $i \leq n$.
>
>**Step 1 — Prove $p$ is a loop invariant:**
>Assume at the start of some iteration that $p$ holds and the loop condition $i < n$ is true, so `factorial` $= i!$ and $i < n$. After the iteration:
>$$i_\text{new} = i + 1, \qquad \text{factorial}_\text{new} = \text{factorial} \cdot (i+1) = i! \cdot (i+1) = (i+1)! = i_\text{new}!$$
>Since $i < n$, we have $i_\text{new} = i + 1 \leq n$. So $p$ holds after the iteration — $p$ is a loop invariant. ✓
>
>**Step 2 — Verify $p$ holds before the loop:**
>Before entering the loop, $i = 1 \leq n$ and `factorial` $= 1 = 1! = i!$, so $p$ is true. ✓
>
>**Step 3 — Apply the rule of inference:**
>Since $p$ is a loop invariant and $p$ holds before the loop, if the loop terminates, it terminates with $p$ true and $i < n$ false. This means $i = n$ and `factorial` $= i! = n!$. ✓
>
>**Step 4 — Verify termination:**
>$i$ starts at $1$ and increases by $1$ each iteration, so after $n - 1$ iterations $i = n$, and the loop exits. ✓

>[!example] Verifying a Multiplication Program
>**Program** $S$ computes the product of two integers $m$ and $n$, split into four segments $S = S_1;\, S_2;\, S_3;\, S_4$:
>
>```
>procedure multiply(m, n: integers)
>S1: if n < 0 then a := −n else a := n     -- set a = |n|
>S2: k := 0                                 -- initialize counter
>    x := 0                                 -- initialize accumulator
>S3: while k < a                            -- add m to x exactly a times
>        x := x + m
>        k := k + 1
>S4: if n < 0 then product := −x           -- apply sign correction
>    else product := x
>    return product
>```
>
>![[Pasted image 20260419201026.png]]
>
>**Initial assertion $p$:** $m$ and $n$ are integers.
>**Final assertion $t$:** `product` $= mn$.
>
>The composition rule is applied across all four segments, with each segment's final assertion becoming the next segment's initial assertion:
>
>- **$p\{S_1\}q$:** $S_1$ sets $a = |n|$. So $q$: $p \wedge (a = |n|)$. ✓
>- **$q\{S_2\}r$:** $S_2$ initializes $k = 0$ and $x = 0$. So $r$: $q \wedge (k = 0) \wedge (x = 0)$. ✓
>- **$r\{S_3\}s$:** The loop invariant for $S_3$ is "$x = mk$ and $k \leq a$." Before the loop, $r$ implies $x = m \cdot 0$ and $0 \leq a$, so the invariant holds initially. Each iteration adds $m$ to $x$ and increments $k$, preserving the invariant. The loop terminates after $a$ iterations with $k = a$, so $x = ma$. Final assertion $s$: $x = ma$ and $a = |n|$. ✓
>- **$s\{S_4\}t$:** $S_4$ applies the sign of $n$. If $n \geq 0$: `product` $= x = ma = m|n| = mn$. If $n < 0$: `product` $= -x = -ma = -m|n| = mn$. Final assertion $t$: `product` $= mn$. ✓
>
>By the composition rule, since $p\{S_1\}q$, $q\{S_2\}r$, $r\{S_3\}s$, and $s\{S_4\}t$ all hold, it follows that $p\{S\}t$ is true. Since each segment terminates, $S$ terminates. Therefore, $S$ is correct. $\blacksquare$
- - -
## Insertion Sort

### Introduction

The **sorting problem** takes a sequence of $n$ numbers $\langle a_1, a_2, \ldots, a_n \rangle$ as input and produces a sorted permutation of that sequence as output. The numbers being sorted are called *keys*. In practice, keys are usually associated with *satellite data* — together forming a *record* — and sorting moves the entire record with its key.

Algorithms in this context are written in *pseudocode*: a notation similar to languages like C, Python, or Java, but using whatever phrasing is clearest, including plain English where appropriate. Pseudocode omits software engineering concerns like error handling and modularity to focus on the logic of the algorithm itself.

### The Insertion Sort Algorithm

Insertion sort is efficient for sorting small numbers of elements. It works analogously to sorting a hand of playing cards: cards already in the hand are kept sorted, and each new card is inserted into its correct position by comparing it against the sorted cards from right to left.

```pseudocode
INSERTION-SORT(A, n)
1  for i = 2 to n
2      key = A[i]                          // the element currently being inserted
3      // Insert A[i] into the sorted subarray A[1 : i – 1].
4      j = i – 1
5      while j > 0 and A[j] > key
6          A[j + 1] = A[j]                 // shift larger element one position right
7          j = j – 1
8      A[j + 1] = key                      // place key in its correct position
```

The outer `for` loop iterates over each element starting from position 2 (the first element is trivially sorted on its own). For each element `A[i]`, its value is saved as `key`, and the inner `while` loop shifts all elements in the sorted portion `A[1 : i-1]` that are larger than `key` one position to the right, creating a gap where `key` is then inserted.

### Loop Invariants and Correctness

The correctness of insertion sort is established using a **loop invariant** on the outer `for` loop:

>[!info] Loop Invariant for Insertion Sort
>At the start of each iteration of the `for` loop (lines 1–8), the subarray `A[1 : i – 1]` consists of the elements *originally* in positions $1$ through $i-1$, but in *sorted order*.

Proving a loop invariant requires demonstrating three properties:

- **Initialization:** The invariant holds before the first iteration.
- **Maintenance:** If the invariant holds before an iteration, it holds before the next iteration.
- **Termination:** The loop terminates, and when it does, the invariant (combined with the termination condition) proves the algorithm's correctness.

>[!note] Loop Invariants as Induction
>A loop invariant proof mirrors mathematical induction: initialization is the base case, and maintenance is the inductive step. The key difference is that the "induction" stops when the loop terminates.

**Initialization ($i = 2$):** Before the first iteration, `A[1 : i – 1]` = `A[1 : 1]`, which contains only the single element `A[1]`. A single-element subarray is trivially sorted and contains the original element. The invariant holds. ✓

**Maintenance:** During each iteration, the `while` loop shifts elements of `A[1 : i – 1]` that are greater than `key` one position to the right, then inserts `key` at the correct position. After this, `A[1 : i]` contains the original elements of positions $1$ through $i$, now in sorted order. When $i$ is incremented, the invariant holds for the next iteration. ✓

**Termination:** The loop counter $i$ starts at $2$ and increases by $1$ each iteration until $i > n$, at which point the loop exits with $i = n + 1$.

Substituting $i = n + 1$ into the invariant: `A[1 : n]` consists of the elements originally in `A[1 : n]`, in sorted order. The entire array is sorted. $\blacksquare$

### Pseudocode Conventions

The pseudocode used throughout follows these conventions:

- **Block structure** is indicated by *indentation* (no `begin`/`end` or curly braces needed).
- **Loop constructs** (`while`, `for`, `repeat-until`) and **conditionals** (`if-else`) behave as in C, Python, Java, or JavaScript.
- **Loop counters** retain their value after a loop exits. After `for i = 2 to n`, the value of `i` is $n + 1$.
- `to` means the counter *increments* each iteration; `downto` means it *decrements*. An optional `by` keyword specifies a step size other than 1.
- `//` marks the rest of a line as a *comment*.
- **Variables** are local to their procedure unless explicitly stated otherwise.
- **Array elements** are accessed as `A[i]`. Arrays are generally *1-origin indexed* in this book (starting at index 1), though this is stated explicitly where it matters.
- **Subarrays** are denoted `A[i : j]`, meaning elements `A[i], A[i+1], …, A[j]`.
- **Objects** are composed of *attributes*, accessed with dot notation: `x.f` for attribute `f` of object `x`. Attribute access cascades: `x.f.g` means `(x.f).g`.
- The special value `NIL` indicates a pointer that refers to no object.
- **Parameters are passed by value** for simple variables. Arrays and objects are passed *by pointer*, so changes to array elements or object attributes *are* visible to the calling procedure, but reassigning the pointer itself is not.
- A **`return` statement** immediately exits the procedure, optionally returning one or more values. Multiple return values are allowed without needing to package them into an object.
- **Boolean operators `and` and `or` are short-circuit:** in `x and y`, if `x` is `FALSE`, `y` is not evaluated; in `x or y`, if `x` is `TRUE`, `y` is not evaluated. This allows safe expressions like `x ≠ NIL and x.f = y`.
- The keyword **`error`** signals that the procedure was called under invalid conditions and terminates immediately. The *calling* procedure is responsible for handling the error.