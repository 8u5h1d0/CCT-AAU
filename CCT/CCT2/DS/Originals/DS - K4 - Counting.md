---
tags:
  - "#CCT2"
  - DS
Topic: "Counting | The Basics of\r Counting | Permutations\r and \rCombinations | Binomial coefficients"
Semester: CCT2
Course: Diskrete strukturer
Litterature:
  - Discrete Mathematics and Its Applications - 8th Ed.
Created: 27-02-2026
---
- - -
# Counting

**Combinatorics** is the study of arrangements of objects, tracing its origins to the seventeenth century and the study of gambling games. A central part of this field is **enumeration**, the counting of objects with certain properties.

>[!info] Applications of Counting
> Counting is used to solve many different types of problems, including:
> - Determining the complexity of algorithms.
> - Determining whether there are enough telephone numbers or Internet protocol addresses to meet demand.
> - Sequencing DNA in mathematical biology.
> - Computing the probabilities of events.

The basic rules of counting can solve a tremendous variety of problems, such as enumerating possible telephone numbers, allowable passwords on a computer system, and the different orders in which runners can finish a race.

Another essential combinatorial tool is the **pigeonhole principle**.

>[!summary] The Pigeonhole Principle
> This principle states that when objects are placed in boxes and there are more objects than boxes, then there is a box containing at least two objects.

>[!example] Application of the Pigeonhole Principle
> This principle can show that among a set of 15 or more students, at least 3 were born on the same day of the week.

Many counting problems are phrased in terms of arrangements of the objects of a set, with or without repetitions. These arrangements are categorized as **permutations** and **combinations**.

>[!info] Permutations vs. Combinations
> - **Permutations:** Ordered arrangements of objects.
> - **Combinations:** Unordered arrangements of objects.

>[!example] Banquet and Prizes
> Suppose the 100 top finishers on a competitive exam taken by 2000 students are invited to a banquet.
> - **Combinations:** Counting the possible sets of 100 students that will be invited is an unordered arrangement problem.
> - **Permutations:** Counting the ways in which the top 10 prizes can be awarded is an ordered arrangement problem.

Another problem in combinatorics involves generating all the arrangements of a specified kind, which is often important in computer simulations. This process involves devising algorithms to generate arrangements of various types.

## The Basics of Counting

### Introduction

Counting problems arise frequently throughout mathematics and computer science. To determine probabilities of discrete events, one must count both the *successful outcomes* and *all the possible outcomes* of experiments. Similarly, analyzing the *time complexity* of an algorithm requires counting the number of operations it uses.

>[!example] The Password Problem
> Consider a password on a computer system that consists of six, seven, or eight characters.
> - **Constraints:** Each character must be a digit or a letter of the alphabet.
> - **Requirement:** Each password must contain at least one digit.
> - **Goal:** Determine the total number of valid passwords.

Solving this problem and a wide variety of similar challenges requires a set of specific techniques. The basic methods introduced here serve as the foundation for nearly all other counting techniques.
### Basic Counting Principles

Two fundamental principles form the foundation of counting techniques: the **product rule** and the **sum rule**. The product rule applies to procedures made up of separate tasks, while the sum rule applies to tasks that can be done in alternative ways.

#### The Product Rule

The product rule applies when a procedure is broken down into a sequence of tasks.

>[!summary] The Product Rule
> Suppose that a procedure can be broken down into a sequence of two tasks. If there are $n_1$ ways to do the first task and for each of these ways, there are $n_2$ ways to do the second task, then there are $n_1 n_2$ ways to do the procedure.

>[!example] Assigning Offices
> A company with two employees, Sanchez and Patel, rents a floor with 12 offices.
> - **Task 1:** Assign an office to Sanchez. This can be done in 12 ways.
> - **Task 2:** Assign an office to Patel different from Sanchez. This can be done in 11 ways.
> - **Result:** By the product rule, there are $12 \cdot 11 = 132$ ways to assign the offices.

This principle extends to procedures with multiple tasks. If a procedure consists of tasks $T_1, T_2, \dots, T_m$ performed in sequence, and each task $T_i$ can be done in $n_i$ ways regardless of previous tasks, there are $n_1 \cdot n_2 \cdots n_m$ ways to carry out the procedure.

>[!info] Product Rule in Set Theory
> If $A_1, A_2, \dots, A_m$ are finite sets, then the number of elements in the Cartesian product is the product of the number of elements in each set:
> $$|A_1 \times A_2 \times \dots \times A_m| = |A_1| \cdot |A_2| \cdots |A_m|$$

**Bit Strings and License Plates**
The product rule is useful for determining the number of possible configurations.
- **Bit Strings:** To find the number of bit strings of length seven, note that each bit can be chosen in two ways (0 or 1). Therefore, there are $2^7 = 128$ different bit strings.
- **License Plates:** If a plate contains a sequence of three uppercase English letters followed by three digits, there are 26 choices for each letter and 10 choices for each digit. The total number of plates is $26^3 * 10^3 = 26 \cdot 26 \cdot 26 \cdot 10 \cdot 10 \cdot 10 = 17,576,000$.

**Counting Functions**
The product rule can determine the number of functions between sets.

>[!example] Counting Functions
> How many functions are there from a set with $m$ elements to a set with $n$ elements?
> - **Procedure:** A function corresponds to a choice of one of the $n$ elements in the codomain for each of the $m$ elements in the domain.
> - **Calculation:** By the product rule, there are $n \cdot n \cdots n = n^m$ functions.
> - **Instance:** There are $5^3 = 125$ functions from a set with three elements to a set with five elements.

>[!example] Counting One-to-One Functions
> How many one-to-one functions are there from a set with $m$ elements to a set with $n$ elements (where $m \le n$)?
> - **Logic:** The value for the first element has $n$ possibilities. The second element must be different, leaving $n-1$ possibilities, and so on.
> - **Calculation:** The total number is $n(n-1)(n-2) \cdots (n-m+1)$.
> - **Instance:** For a set with 3 elements to a set with 5 elements, there are $5 \cdot 4 \cdot 3 = 60$ one-to-one functions.

**The Telephone Numbering Plan**
The North American Numbering Plan (NANP) illustrates how counting applies to real-world constraints.

>[!example] North American Telephone Numbers
> A telephone number consists of a 3-digit area code, 3-digit office code, and 4-digit station code.
> 
> **Variable Definitions:**
> - `X`: Digit 0-9 (10 choices).
> - `N`: Digit 2-9 (8 choices).
> - `Y`: Digit 0 or 1 (2 choices).
> 
> **Old Plan vs. New Plan:**
> 1. **Old Plan (NYX-NNX-XXXX):**
>    - Area Code (NYX): $8 \cdot 2 \cdot 10 = 160$.
>    - Office Code (NNX): $8 \cdot 8 \cdot 10 = 640$.
>    - Station Code (XXXX): $10^4 = 10,000$.
>    - **Total:** $160 \cdot 640 \cdot 10,000 = 1,024,000,000$.
> 2. **New Plan (NXX-NXX-XXXX):**
>    - Area Code (NXX): $8 \cdot 10 \cdot 10 = 800$.
>    - Office Code (NXX): $800$.
>    - Station Code (XXXX): $10,000$.
>    - **Total:** $800 \cdot 800 \cdot 10,000 = 6,400,000,000$.

**Counting Subsets**
There is a one-to-one correspondence between subsets of a finite set $S$ and bit strings of length $|S|$. Since each position in the string has 2 possibilities (1 if the element is in the subset, 0 if not), the number of different subsets is $2^{|S|}$.

**DNA and Genomes**
Genetic information is encoded using DNA, consisting of two strands of nucleotides. Each nucleotide contains a base: Adenine (A), Cytosine (C), Guanine (G), or Thymine (T).

>[!info] DNA Sequences
> - **Bases:** There are 4 possibilities for each link in a DNA sequence.
> - **Amino Acids:** To encode 22 essential amino acids, sequences of at least three bases are needed. Two bases provide $4^2 = 16$ possibilities (insufficient), while three bases provide $4^3 = 64$ possibilities (sufficient).
> - **Complexity:** Simple organisms have between $10^5$ and $10^7$ links, while complex organisms have between $10^8$ and $10^{10}$ links. The number of possible sequences is vast ($4^{10^5}$ or more), explaining biological variability.

#### The Sum Rule

The sum rule applies when a task can be done in one of several different ways.

>[!summary] The Sum Rule
> If a task can be done either in one of $n_1$ ways or in one of $n_2$ ways, where none of the set of $n_1$ ways is the same as any of the set of $n_2$ ways, then there are $n_1 + n_2$ ways to do the task.

This rule can be extended to $m$ different ways. If the sets of ways are pairwise disjoint, the total number of ways is $n_1 + n_2 + \dots + n_m$.

>[!example] Choosing a Representative
> Suppose a representative is chosen from either the mathematics faculty (37 members) or mathematics majors (83 students).
> - **Condition:** No one is both a faculty member and a student (disjoint sets).
> - **Calculation:** By the sum rule, there are $37 + 83 = 120$ possible choices.

**Counting in Programming**
The sum rule applies to analyzing code with sequential loops.

>[!example] Sequential Loops
> Consider code where $k$ is incremented in sequential, non-nested loops:
> ```python
> k = 0
> for i1 in range(n1):
>     k += 1
> for i2 in range(n2):
>     k += 1
> # ... for im in range(nm)
> ```
> - **Logic:** The first loop runs $n_1$ times, the second $n_2$ times, etc.
> - **Result:** Since these loops execute separately, the final value of $k$ is $n_1 + n_2 + \dots + n_m$.

>[!info] Sum Rule in Set Theory
> If $A_1, A_2, \dots, A_m$ are pairwise disjoint finite sets, then the number of elements in the union of these sets is the sum of the number of elements in each set:
> $$|A_1 \cup A_2 \cup \dots \cup A_m| = |A_1| + |A_2| + \dots + |A_m|$$
> This applies only when the sets share no common elements ($A_i \cap A_j = \emptyset$ for all $i \neq j$). The situation becomes more complex when sets overlap.

### More Complex Counting Problems

Many counting problems require using both the sum rule and the product rule in combination. A common strategy for complex constraints is to calculate the total number of possibilities and subtract those that violate the rules.

>[!example] Naming Variables in BASIC
> A version of the BASIC language uses variable names that are one or two alphanumeric characters long, case-insensitive. A variable name must begin with a letter and cannot be one of five reserved two-character strings.
> 
> **Procedure:**
> Let $V$ be the total number of names, divided into one-character names ($V_1$) and two-character names ($V_2$).
> - **One-character names ($V_1$):** Must be a letter.
>   - $V_1 = 26$.
> - **Two-character names ($V_2$):** Must start with a letter, followed by an alphanumeric character.
>   - Total format combinations: $26 \cdot 36 = 936$.
>   - Subtract reserved strings: $936 - 5 = 931$.
> - **Total ($V$):** By the sum rule, $V = V_1 + V_2$.
>   - $V = 26 + 931 = 957$ different variable names.

>[!example] Counting Passwords with Constraints
> A computer system password is six to eight characters long, using uppercase letters and digits. It must contain at least one digit.
> 
> **Strategy:**
> Use the sum rule to add passwords of length 6, 7, and 8 ($P = P_6 + P_7 + P_8$). For each length, calculate the total possible strings and subtract those with **no digits** (all letters).
> 
> **Calculations:**
> - **Available Characters:** 26 letters + 10 digits = 36 total.
> - **Length 6 ($P_6$):**
>   - Total strings: $36^6$.
>   - All-letter strings: $26^6$.
>   - $P_6 = 36^6 - 26^6 = 1,867,866,560$.
> - **Length 7 ($P_7$):**
>   - Total strings: $36^7$.
>   - All-letter strings: $26^7$.
>   - $P_7 = 36^7 - 26^7 = 70,332,353,920$.
> - **Length 8 ($P_8$):**
>   - Total strings: $36^8$.
>   - All-letter strings: $26^8$.
>   - $P_8 = 36^8 - 26^8 = 2,612,282,842,880$.
> - **Total Passwords:**
>   - $P = P_6 + P_7 + P_8 = 2,684,483,063,360$.

>[!example] Counting Internet Addresses (IPv4)
> In IPv4, an address is a 32-bit string composed of a `netid` (network number) followed by a `hostid` (host number). Addresses are divided into classes A, B, and C.
> 
> **Address Restrictions:**
> - The `netid` `1111111` is not available for Class A.
> - `hostid`s consisting of all 0s or all 1s are not available for any network.
> 
> **Calculations by Class:**
> - **Class A (Large Networks):**
>   - Format: `0` + 7-bit `netid` + 24-bit `hostid`.
>   - Valid `netid`s: $2^7 - 1 = 127$.
>   - Valid `hostid`s per network: $2^{24} - 2 = 16,777,214$.
>   - Total Class A: $127 \cdot 16,777,214 = 2,130,706,178$.
> - **Class B (Medium Networks):**
>   - Format: `10` + 14-bit `netid` + 16-bit `hostid`.
>   - Valid `netid`s: $2^{14} = 16,384$.
>   - Valid `hostid`s per network: $2^{16} - 2 = 65,534$.
>   - Total Class B: $16,384 \cdot 65,534 = 1,073,709,056$.
> - **Class C (Small Networks):**
>   - Format: `110` + 21-bit `netid` + 8-bit `hostid`.
>   - Valid `netid`s: $2^{21} = 2,097,152$.
>   - Valid `hostid`s per network: $2^8 - 2 = 254$.
>   - Total Class C: $2,097,152 \cdot 254 = 532,676,608$.
> 
> **Total IPv4 Addresses:**
> Using the sum rule: $x = x_A + x_B + x_C = 3,737,091,842$ available addresses.

### The Subtraction Rule (Inclusion–Exclusion for Two Sets)

The sum rule assumes that sets of tasks are disjoint. When a task can be done in ways that overlap, simply adding the number of ways results in an **overcount** because the common ways are counted twice. To correct this, the number of common ways must be subtracted.

>[!summary] The Subtraction Rule (Inclusion–Exclusion)
> If a task can be done in either $n_1$ ways or $n_2$ ways, the number of ways to do the task is $n_1 + n_2$ minus the number of ways that are common to both.
>
> **Set Theory Formulation:**
> For two sets $A_1$ and $A_2$, the number of elements in their union is the sum of the sizes of each set minus the size of their intersection:
> $$|A_1 \cup A_2| = |A_1| + |A_2| - |A_1 \cap A_2|$$
>
> **Breakdown:**
> - **$|A_1 \cup A_2|$**: The total number of elements in either set (the goal).
> - **$|A_1| + |A_2|$**: The sum of elements in each set (includes duplicates).
> - **$|A_1 \cap A_2|$**: The intersection of the sets (the elements counted twice).

>[!example] Counting Bit Strings with Specific Patterns
> How many bit strings of length eight either start with a `1` or end with the two bits `00`?
>
> **Procedure:**
> 1. **Starts with 1:** The first bit is fixed (1 way), and the remaining seven bits can be 0 or 1.
>    - Count: $1 \cdot 2^7 = 128$.
> 2. **Ends with 00:** The last two bits are fixed (1 way), and the first six bits can be 0 or 1.
>    - Count: $2^6 \cdot 1 = 64$.
> 3. **Intersection (Starts with 1 AND Ends with 00):** The first bit is fixed, the last two are fixed, and the middle five vary.
>    - Count: $1 \cdot 2^5 \cdot 1 = 32$.
>
> **Calculation:**
> Applying the subtraction rule:
> $128 + 64 - 32 = 160$.
>
> There are 160 such bit strings.

>[!example] Job Applicant Majors
> A company receives 350 applications. 220 majored in computer science (CS), 147 majored in business, and 51 majored in both. How many majored in neither?
>
> **Procedure:**
> 4. **Find the Union (CS or Business):**
>    - $|CS| = 220$
>    - $|Business| = 147$
>    - $|CS \cap Business| = 51$
>    - $|CS \cup Business| = 220 + 147 - 51 = 316$.
> 5. **Find the Complement (Neither):**
>    - Subtract the union from the total applicants.
>    - $350 - 316 = 34$.
>
> **Result:**
> 34 applicants majored neither in computer science nor in business.
>
> ![[Pasted image 20260227165024.png]]
> *Figure: Venn diagram showing the overlap between CS and Business majors.*

This principle generalizes to find the number of elements in the union of $n$ sets, a topic explored further in the study of the inclusion–exclusion principle.

### The Division Rule

Alongside the product, sum, and subtraction rules, the **division rule** is a fundamental tool for enumeration, particularly useful when objects are counted multiple times in a procedure and must be normalized.

>[!summary] The Division Rule
> There are $n/d$ ways to do a task if it can be done using a procedure that can be carried out in $n$ ways, and for every way $w$, exactly $d$ of the $n$ ways correspond to way $w$.

This rule can be restated using set theory or functions to provide different perspectives on its application.

>[!info] Alternative Formulations
> **Set Theory Formulation**
> If the finite set $A$ is the union of $n$ pairwise disjoint subsets each with $d$ elements, then $n = |A|/d$.
>
> **Function Formulation**
> If $f$ is a function from $A$ to $B$ where $A$ and $B$ are finite sets, and for every value $y \in B$ there are exactly $d$ values $x \in A$ such that $f(x) = y$ (a **$d$-to-one function**), then $|B| = |A|/d$.

>[!tip] When to Use the Division Rule
> This rule is handy when a task appears to have $n$ different ways of completion, but it turns out there are $d$ equivalent ways for every distinct outcome. In these cases, there are actually $n/d$ **inequivalent** ways to do the task.

>[!example] Counting Cows by Legs
> An automated system counts 572 legs in a pasture. Assuming each cow has four legs and no other animals are present, how many cows are there?
>
> **Calculation:**
> - **Total legs ($n$):** 572.
> - **Legs per cow ($d$):** 4.
> - **Result:** By the division rule, the number of cows is $572/4 = 143$.

>[!example] Seating Arrangements at a Circular Table
> How many different ways are there to seat four people around a circular table, where two seatings are considered the same when each person has the same left neighbor and same right neighbor?
>
> **Procedure:**
> 1. **Count Linear Arrangements:** First, treat the seats as distinct (e.g., labeled 1 to 4).
>    - There are $4! = 24$ ways to arrange the four people.
> 2. **Identify Equivalence:** In a circular arrangement, rotating the table does not change the neighbors. For any specific arrangement, there are 4 rotations (one for each person sitting in "seat 1") that result in the same circular configuration.
>    - Here, $d = 4$.
> 3. **Apply Division Rule:** Divide the total linear arrangements by the number of equivalent rotations.
>    - $24 / 4 = 6$.
>
> **Result:**
> There are 6 different seating arrangements.

### Tree Diagrams

Counting problems can often be effectively solved using **tree diagrams**. A tree consists of a root, branches leaving the root, and potential additional branches leaving the endpoints of others.

>[!info] Components of a Counting Tree
> - **Root:** The starting point of the procedure.
> - **Branches:** Represent each possible choice made at a step.
> - **Leaves:** The endpoints of branches that do not start new branches. These represent the possible **outcomes**.

>[!example] Bit Strings without Consecutive 1s
> **Problem:** How many bit strings of length four do not have two consecutive 1s?
>
> **Solution:** A tree diagram displays all possibilities, branching for each bit (0 or 1). A branch is terminated if adding a '1' follows a previous '1'.
>
> ![[Pasted image 20260227165755.png]]
>
> By counting the leaves of the tree, we determine there are **8** bit strings of length four without two consecutive 1s.

>[!example] Playoff Outcomes
> **Problem:** A playoff between two teams consists of at most five games. The first team to win three games wins the playoff. In how many different ways can the playoff occur?
>
> **Solution:** A tree diagram traces the winner of each game. Branches stop once a team reaches three wins.
>
> ![[Pasted image 20260227165818.png]]
>
> Counting the leaves (final outcomes) reveals there are **20** different ways for the playoff to occur.

>[!example] Inventory Stocking
> **Problem:** A souvenir shop needs to stock T-shirts in specific sizes and colors. How many different shirts must be stocked to have at least one of every available combination?
>
> **Constraints:**
> - **Sizes S, M, L:** Come in 4 colors (White, Red, Green, Black).
> - **Size XL:** Comes in 3 colors (Red, Green, Black).
> - **Size XXL:** Comes in 2 colors (Green, Black).
>
> **Solution:**
> ![[Pasted image 20260227165831.png]]
>
> Using the sum rule on the tree branches:
> - S, M, L: $3 \text{ sizes} \times 4 \text{ colors} = 12$ shirts.
> - XL: $1 \text{ size} \times 3 \text{ colors} = 3$ shirts.
> - XXL: $1 \text{ size} \times 2 \text{ colors} = 2$ shirts.
>
> **Total:** $12 + 3 + 2 = 17$ different T-shirts.

## The Pigeonhole Principle

### Introduction

The pigeonhole principle is a fundamental concept stating that if there are more pigeons than pigeonholes, at least one pigeonhole must contain more than one pigeon. This principle applies generally to objects and containers, serving as a powerful tool for proving the existence of certain properties without explicitly constructing them.

>[!summary] Theorem 1: The Pigeonhole Principle
> If $k$ is a positive integer and $k + 1$ or more objects are placed into $k$ boxes, then there is at least one box containing two or more of the objects.
>
> **Proof:**
> The theorem is proven using a proof by contraposition.
> - **Assumption:** Suppose that none of the $k$ boxes contains more than one object.
> - **Consequence:** Then the total number of objects would be at most $k$.
> - **Contradiction:** This contradicts the premise that there are at least $k + 1$ objects. Therefore, the assumption is false, and at least one box must contain two or more objects.
>
> ![[Pasted image 20260227170126.png]]

>[!info] Corollary 1
> A function $f$ from a set with $k + 1$ or more elements to a set with $k$ elements is not one-to-one.
>
> **Proof:**
> Imagine a box corresponding to each element $y$ in the codomain. Each box contains all elements $x$ from the domain such that $f(x) = y$. Because the domain has $k + 1$ elements and there are only $k$ boxes, the pigeonhole principle dictates that one box must contain at least two elements from the domain. This implies that two distinct elements map to the same value, so $f$ is not one-to-one.

>[!example] Application: Birthdays
> Among any group of 367 people, there must be at least two with the same birthday.
> - **Reasoning:** There are only 366 possible birthdays (boxes). Placing 367 people (objects) into these boxes guarantees a collision.

>[!example] Application: First Letters
> In any group of 27 English words, there must be at least two that begin with the same letter.
> - **Reasoning:** There are 26 letters in the English alphabet (boxes). With 27 words (objects), at least two must fall into the same letter category.

>[!example] Application: Exam Scores
> How many students must be in a class to guarantee that at least two students receive the same score on a final exam graded from 0 to 100?
> - **Boxes:** The possible scores are $0, 1, \dots, 100$. There are 101 boxes.
> - **Objects:** The students.
> - **Result:** By the pigeonhole principle, among any **102** students there must be at least 2 students with the same score.

>[!example] Application: Decimal Expansions
> Show that for every integer $n$, there is a multiple of $n$ that has only 0s and 1s in its decimal expansion.
>
> **Solution:**
> 1. **Consider the list:** Let $n$ be a positive integer. Consider the $n + 1$ integers:
>    $1, 11, 111, \dots, \underbrace{11\dots1}_{n+1 \text{ ones}}$.
> 2. **Apply the Principle:** When an integer is divided by $n$, there are only $n$ possible remainders ($0$ through $n-1$). Since there are $n+1$ integers in the list, the pigeonhole principle implies that two of them must have the same remainder when divided by $n$.
> 3. **Construct the Multiple:** Let the two integers with the same remainder be $a$ and $b$ (where $a > b$). The difference $a - b$ is divisible by $n$.
> 4. **Result:** The decimal expansion of $a - b$ consists entirely of 0s and 1s (specifically, the 1s from $a$ minus the 1s from $b$ result in a string of 0s and 1s).

### The Generalized Pigeonhole Principle

The standard pigeonhole principle guarantees that at least one box contains two objects when objects exceed boxes. The **generalized pigeonhole principle** extends this: if objects exceed a multiple of boxes, at least one box must contain a specific minimum number of objects.

>[!summary] Theorem 2: The Generalized Pigeonhole Principle
> If $N$ objects are placed into $k$ boxes, then there is at least one box containing at least $\lceil N/k \rceil$ objects.
>
> **Proof (by contraposition):**
> - **Assumption:** Suppose that none of the boxes contains more than $\lceil N/k \rceil - 1$ objects.
> - **Implication:** The total number of objects is at most $k(\lceil N/k \rceil - 1)$.
> - **Inequality:** Since $\lceil N/k \rceil < (N/k) + 1$, the maximum total is less than $k((N/k) + 1 - 1) = N$.
> - **Conclusion:** The total number of objects is less than $N$, which contradicts the premise. Thus, at least one box must contain at least $\lceil N/k \rceil$ objects.

**Determining Minimum Objects for a Target Count**
A common problem involves finding the minimum number of objects ($N$) needed to guarantee that at least $r$ objects end up in one of $k$ boxes.

>[!info] Finding Minimum $N$
> The generalized principle requires $\lceil N/k \rceil \ge r$.
> - **Formula:** The smallest integer $N$ satisfying this is $N = k(r - 1) + 1$.
> - **Logic:** To avoid having $r$ objects in a box, you can place at most $r - 1$ objects in each of the $k$ boxes (totaling $k(r - 1)$). The very next object added forces a box to reach $r$.

>[!example] Birthdays
> Among 100 people, there are at least $\lceil 100/12 \rceil = 9$ people born in the same month.

>[!example] Assigning Grades
> What is the minimum number of students required to guarantee that at least six receive the same grade (A, B, C, D, or F)?
> - **Boxes ($k$):** 5 possible grades.
> - **Target ($r$):** 6 students.
> - **Calculation:** $N = 5(6 - 1) + 1 = 26$.
> - **Reasoning:** With 25 students, it is possible to have exactly 5 students per grade. The 26th student necessitates a sixth match.

>[!example] Selecting Cards from a Deck
> A standard deck has 52 cards with 4 suits (hearts, diamonds, spades, clubs).
>
> **Part A: Guaranteeing three cards of the same suit.**
> - **Boxes ($k$):** 4 suits.
> - **Target ($r$):** 3 cards.
> - **Calculation:** $N = 4(3 - 1) + 1 = 9$.
> - **Result:** Selecting 9 cards guarantees at least three are of the same suit. (With 8 cards, you could have exactly two of each suit).
>
> **Part B: Guaranteeing three hearts.**
> - **Method:** This requires "worst-case" analysis rather than the generalized formula.
> - **Worst Case:** You select all 13 clubs, 13 diamonds, and 13 spades (39 cards) before picking a single heart.
> - **Calculation:** $39 + 3 = 42$.
> - **Result:** You must select 42 cards to guarantee at least three are hearts.

>[!example] Area Codes for Phone Numbers
> What is the least number of area codes needed to guarantee distinct 10-digit numbers for 25 million phones?
> - **Capacity:** There are 8 million distinct phone numbers of the form `NXX-XXXX` available per area code.
> - **Calculation:** By the generalized pigeonhole principle, $\lceil 25,000,000 / 8,000,000 \rceil = 4$.
> - **Result:** At least four area codes are required.

>[!example] Network Connections
> A lab has 15 workstations and 10 servers. We need to guarantee that any set of 10 or fewer workstations can simultaneously access distinct servers. What is the minimum number of direct connections needed?
>
> **Solution:**
> - **Configuration:**
>   - Connect workstations $W_1$ through $W_{10}$ to servers $S_1$ through $S_{10}$ respectively (10 connections).
>   - Connect workstations $W_{11}$ through $W_{15}$ to *all* 10 servers ($5 \times 10 = 50$ connections).
>   - **Total:** 60 connections.
> - **Verification:** If a workstation $W_k$ ($k \le 10$) is used, it takes server $S_k$. If $W_k$ ($k \ge 11$) is used, it can take the server of any inactive workstation $W_j$ ($j \le 10$).
> - **Proof of Minimality:**
>   - Suppose there are fewer than 60 connections.
>   - By the generalized pigeonhole principle, if 59 connections are distributed among 10 servers, one server must be connected to at most $\lfloor 59/10 \rfloor = 5$ workstations.
>   - This leaves at least $15 - 5 = 10$ workstations that must rely on the remaining 9 servers. Since there are more workstations (10) than available servers (9), simultaneous access is impossible.
> - **Result:** 60 connections are necessary and sufficient.

### Some Elegant Applications of the Pigeonhole Principle

Many interesting applications of the pigeonhole principle require cleverly choosing the objects to be placed into boxes. These elegant applications demonstrate the principle's power in proving the existence of specific numerical or structural properties.

>[!example] Consecutive Days with a Specific Game Count
> **Problem:** During a 30-day month, a baseball team plays at least one game a day, but no more than 45 games total. Show there must be a period of consecutive days during which the team plays exactly 14 games.
>
> **Solution:**
> 1. **Define the Sequence:** Let $a_j$ be the number of games played on or before the $j$th day.
>    - The sequence $a_1, a_2, \dots, a_{30}$ is strictly increasing.
>    - Range: $1 \le a_j \le 45$.
> 2. **Create a Second Sequence:** Consider the sequence $a_1 + 14, a_2 + 14, \dots, a_{30} + 14$.
>    - This sequence is also strictly increasing.
>    - Range: $15 \le a_j + 14 \le 59$.
> 3. **Apply the Pigeonhole Principle:**
>    - We have 60 integers (the 30 $a_j$'s and the 30 $a_j+14$'s).
>    - These integers all have values between 1 and 59.
>    - Since there are 60 integers and only 59 possible values, two integers must be equal.
> 4. **Analyze the Collision:**
>    - The integers $a_j$ are distinct from each other, and the integers $a_j + 14$ are distinct from each other.
>    - Therefore, the equality must occur between the two sets: there exist indices $i$ and $j$ such that $a_i = a_j + 14$.
>    - This implies $a_i - a_j = 14$.
> 5. **Conclusion:** Exactly 14 games were played from day $j+1$ to day $i$.

>[!example] Divisibility in a Subset
> **Problem:** Show that among any $n+1$ positive integers not exceeding $2n$, there must be an integer that divides one of the other integers.
>
> **Solution:**
> 6. **Factorization Strategy:** Write each of the $n+1$ integers $a_1, a_2, \dots, a_{n+1}$ as a power of 2 times an odd integer.
>    - $a_j = 2^{k_j} q_j$, where $k_j$ is a nonnegative integer and $q_j$ is odd.
> 7. **Identify the Boxes:** The integers $q_1, q_2, \dots, q_{n+1}$ are all odd positive integers less than or equal to $2n$.
>    - There are only $n$ odd positive integers less than $2n$.
> 8. **Apply the Pigeonhole Principle:**
>    - We have $n+1$ integers ($q_j$) to place into $n$ possible odd values.
>    - By the pigeonhole principle, two of the $q_j$'s must be equal.
> 9. **Conclusion:** Let $q_i = q_j = q$. Then $a_i = 2^{k_i}q$ and $a_j = 2^{k_j}q$.
>    - If $k_i < k_j$, then $a_i$ divides $a_j$.
>    - If $k_i > k_j$, then $a_j$ divides $a_i$.

#### Subsequences

Before applying the pigeonhole principle to sequences, it is helpful to review definitions regarding subsequences.

>[!info] Subsequence Definitions
> Suppose that $a_1, a_2, \dots, a_N$ is a sequence of real numbers.
> - **Subsequence:** A sequence of the form $a_{i_1}, a_{i_2}, \dots, a_{i_m}$, where $1 \le i_1 < i_2 < \dots < i_m \le N$. This is obtained by including some terms in their original order and excluding others.
> - **Strictly Increasing:** Each term is larger than the one that precedes it.
> - **Strictly Decreasing:** Each term is smaller than the one that precedes it.

>[!summary] Theorem 3
> Every sequence of $n^2 + 1$ distinct real numbers contains a subsequence of length $n + 1$ that is either strictly increasing or strictly decreasing.
>
> **Proof:**
> - **Setup:** Let $a_1, \dots, a_{n^2+1}$ be the sequence. Associate an ordered pair $(i_k, d_k)$ with each term $a_k$.
>    - $i_k$: Length of the longest increasing subsequence starting at $a_k$.
>    - $d_k$: Length of the longest decreasing subsequence starting at $a_k$.
> - **Assumption:** Suppose there are no increasing or decreasing subsequences of length $n + 1$.
>    - Then $1 \le i_k \le n$ and $1 \le d_k \le n$ for all $k$.
>    - By the product rule, there are $n^2$ possible ordered pairs $(i_k, d_k)$.
> - **Apply Pigeonhole Principle:**
>    - There are $n^2 + 1$ terms (objects) and $n^2$ possible pairs (boxes).
>    - Two terms, $a_s$ and $a_t$ ($s < t$), must have the same pair: $(i_s, d_s) = (i_t, d_t)$.
> - **Contradiction:**
>    - Since terms are distinct, either $a_s < a_t$ or $a_s > a_t$.
>    - If $a_s < a_t$: We can place $a_s$ before an increasing subsequence starting at $a_t$. This creates an increasing subsequence of length $i_t + 1$. Thus $i_s > i_t$, which contradicts that the pairs are equal.
>    - If $a_s > a_t$: We can place $a_s$ before a decreasing subsequence starting at $a_t$. This creates a decreasing subsequence of length $d_t + 1$. Thus $d_s > d_t$, which contradicts that the pairs are equal.
> - **Result:** The assumption is false; a subsequence of length $n + 1$ must exist.

>[!example] Finding Subsequences
> The sequence $8, 11, 9, 1, 4, 6, 12, 10, 5, 7$ contains 10 terms ($3^2 + 1$).
> - **Theorem Prediction:** It must contain a monotonic subsequence of length 4 ($3+1$).
> - **Strictly Increasing Subsequences found:** $1, 4, 6, 12$ or $1, 4, 6, 7$.
> - **Strictly Decreasing Subsequence found:** $11, 9, 6, 5$.

#### Ramsey Theory

Ramsey theory, named after English mathematician F. P. Ramsey, deals with the distribution of subsets of elements within sets. The pigeonhole principle is a foundational tool in this field.

>[!example] The Party Problem (Ramsey Number $R(3,3)$)
> **Problem:** Assume that in a group of six people, each pair of individuals consists of two friends or two enemies. Show that there are either three mutual friends or three mutual enemies.
>
> **Solution:**
> 1. **Analyze One Person:** Let $A$ be one of the six people. $A$ has relationships with the other 5 people.
> 2. **Apply Generalized Pigeonhole Principle:**
>    - **Objects:** 5 people.
>    - **Boxes:** 2 types of relationships (Friend or Enemy).
>    - Calculation: $\lceil 5/2 \rceil = 3$.
>    - $A$ must have at least 3 friends or at least 3 enemies among the other five.
> 3. **Case 1 (A has 3 friends):** Suppose $B, C, D$ are friends of $A$.
>    - If any pair among $\{B, C, D\}$ are friends (e.g., $B$ and $C$), then $\{A, B, C\}$ form a group of three mutual friends.
>    - If no pair among $\{B, C, D\}$ are friends, then $B, C, D$ are all enemies of each other. They form a group of three mutual enemies.
> 4. **Case 2 (A has 3 enemies):** The logic is identical to Case 1, swapping the roles of friends and enemies.
>
> **Conclusion:** In all scenarios, there exists a group of three mutual friends or three mutual enemies.

>[!info] Ramsey Numbers
> The **Ramsey number** $R(m, n)$ denotes the minimum number of people at a party such that there are either $m$ mutual friends or $n$ mutual enemies, assuming every pair are either friends or enemies.
>
> **Properties:**
> - **Symmetry:** $R(m, n) = R(n, m)$.
> - **Base Case:** $R(2, n) = n$ for $n \ge 2$.
> - **Example 13 Result:** $R(3, 3) = 6$.
> - **Known Values:** Exact values are difficult to find. $R(4, 4) = 18$.
> - **Bounds:** For $R(5, 5)$, it is known that $43 \le R(5, 5) \le 49$.

## Permutations and Combinations

### Introduction

Many counting problems rely on distinguishing between arrangements where order is significant and selections where it is not.

>[!info] Core Distinctions in Counting
> - **Arrangements:** Finding the number of ways to arrange a specified number of distinct elements from a set, where _order matters_.
> - **Selections:** Finding the number of ways to select a particular number of elements from a set, where _order does not matter_.

>[!example] Illustrative Scenarios
> - **Arrangement:** In how many ways can we select three students from a group of five to stand in line for a picture? (Order matters).
> - **Selection:** How many different committees of three students can be formed from a group of four? (Order does not matter).

The methods developed in this section provide the tools to solve these and similar questions.

### Permutations

The first questions posed in the introduction involve finding the number of ways to arrange distinct objects where order matters.

>[!example] Arranging Students
> **Problem:** In how many ways can we select three students from a group of five to stand in line for a picture?
>
> **Solution:**
> - **First position:** 5 choices.
> - **Second position:** 4 choices (one student already chosen).
> - **Third position:** 3 choices.
> - **Total:** By the product rule, $5 \cdot 4 \cdot 3 = 60$ ways.
>
> **Extended Problem:** Arranging all five students results in $5 \cdot 4 \cdot 3 \cdot 2 \cdot 1 = 120$ ways.

This leads to specific terminology for ordered arrangements. A **permutation** of a set of distinct objects is an ordered arrangement of these objects. An **$r$-permutation** is an ordered arrangement of $r$ elements from the set.

The number of $r$-permutations of a set with $n$ elements is denoted by $P(n, r)$.

>[!summary] Theorem 1: Number of r-Permutations
> If $n$ is a positive integer and $r$ is an integer with $1 \le r \le n$, then there are $P(n, r)$ $r$-permutations of a set with $n$ distinct elements:
> $$P(n, r) = n(n - 1)(n - 2) \cdots (n - r + 1)$$
>
> **Breakdown:**
> - **$n$**: The number of ways to choose the first element.
> - **$n - 1$**: The number of ways to choose the second element.
> - **$n - r + 1$**: The number of ways to choose the $r$-th element (the stopping point of the product).
>
> **Proof:**
> The first element is chosen in $n$ ways. The second in $n-1$ ways, continuing until the $r$-th element, which has $n - (r-1)$ possibilities. The product rule gives the final formula.

>[!summary] Corollary 1
> If $n$ and $r$ are integers with $0 \le r \le n$, then:
> $$P(n, r) = \frac{n!}{(n - r)!}$$
>
> **Breakdown:**
> - **$n!$**: The product of all integers from $n$ down to 1.
> - **$(n - r)!$**: The denominator cancels out the terms $(n-r)$ down to 1, leaving the product starting at $n$ and ending at $n-r+1$.

Note that $P(n, 0) = 1$ because there is exactly one way to order zero elements (the empty list). If $n$ is a positive integer, $P(n, n) = n!$.

>[!example] Applications of Permutations
> **Prize Winners:**
> Selecting a first, second, and third prize winner from 100 people is a 3-permutation.
> $$P(100, 3) = 100 \cdot 99 \cdot 98 = 970,200$$
>
> **Race Medals:**
> Awarding gold, silver, and bronze medals to 8 runners.
> $$P(8, 3) = 8 \cdot 7 \cdot 6 = 336$$
>
> **Traveling Saleswoman:**
> A saleswoman visits 8 cities, starting in a specified city. She can visit the remaining 7 in any order.
> - This is a permutation of 7 elements.
> - Total paths: $7! = 5040$.
>
> **Letter Arrangements:**
> How many permutations of `ABCDEFGH` contain the block `ABC`?
> - Treat `ABC` as a single object.
> - The objects are: `{ABC}, D, E, F, G, H` (6 objects total).
> - Total permutations: $6! = 720$.

### Combinations

Many counting problems involve unordered selections of objects.

>[!example] Forming Committees
> **Problem:** How many different committees of three students can be formed from a group of four?
>
> **Solution:**
> - This requires finding the number of subsets with three elements.
> - Choosing three students is equivalent to choosing one student to leave out.
> - There are 4 ways to choose the student to leave out.
> - Therefore, there are 4 possible committees (order does not matter).

An **$r$-combination** of elements of a set is an unordered selection of $r$ elements from the set. Thus, an $r$-combination is simply a subset with $r$ elements.

The number of $r$-combinations of a set with $n$ distinct elements is denoted by $C(n, r)$. This is also denoted by $\binom{n}{r}$ and is called a **binomial coefficient**.

>[!summary] Theorem 2: Number of r-Combinations
> The number of $r$-combinations of a set with $n$ elements, where $n$ is a nonnegative integer and $r$ is an integer with $0 \le r \le n$, equals:
> $$C(n, r) = \frac{n!}{r!(n - r)!}$$
>
> **Breakdown:**
> - **$n!$**: The total arrangements of all $n$ elements (if we were permuting everything).
> - **$r!$**: Divides out the order of the selected $r$ elements (since order doesn't matter in a combination).
> - **$(n - r)!$**: Divides out the order of the unchosen elements.
>
> **Proof:**
> $r$-permutations can be obtained by first forming $C(n, r)$ $r$-combinations and then ordering the elements in each combination (which can be done in $P(r, r)$ ways).
> $$P(n, r) = C(n, r) \cdot P(r, r)$$
> Solving for $C(n, r)$:
> $$C(n, r) = \frac{P(n, r)}{P(r, r)} = \frac{n!/(n-r)!}{r!} = \frac{n!}{r!(n-r)!}$$

When computing $C(n, r)$ for large values, it is practical to cancel the factorials:
$$C(n, r) = \frac{n(n-1)\cdots(n-r+1)}{r!}$$

>[!example] Poker Hands
> How many 5-card hands can be dealt from a 52-card deck?
>
> **Calculation:**
> $$C(52, 5) = \frac{52 \cdot 51 \cdot 50 \cdot 49 \cdot 48}{5 \cdot 4 \cdot 3 \cdot 2 \cdot 1}$$
> Simplifying:
> - $50/5 = 10$
> - $48/4 = 12$
> - $51/3 = 17$
> - $52/2 = 26$
>
> Result: $26 \cdot 17 \cdot 10 \cdot 49 \cdot 12 = 2,598,960$.

>[!summary] Corollary 2
> Let $n$ and $r$ be nonnegative integers with $r \le n$. Then:
> $$C(n, r) = C(n, n - r)$$
>
> **Breakdown:**
> - **Logic:** Selecting $r$ elements to include in a subset is equivalent to selecting $n-r$ elements to exclude.

>[!info] Combinatorial Proofs
> A **combinatorial proof** proves an identity by showing that both sides count the same objects in different ways.
> - **Double Counting Proof:** Shows two different methods count the same set.
> - **Bijective Proof:** Shows a one-to-one correspondence between the sets of objects counted by the two sides.
>
> **Proof of Corollary 2:**
> A bijective proof maps a subset $A$ to its complement $\bar{A}$. Since every subset of size $r$ corresponds to a unique subset of size $n-r$, the counts must be equal.

>[!example] Applications of Combinations
> **Tennis Team:**
> Selecting 5 players from a 10-member team.
> $$C(10, 5) = \frac{10!}{5!5!} = 252$$
>
> **Astronaut Crew:**
> Selecting a crew of 6 from 30 people.
> $$C(30, 6) = \frac{30 \cdot 29 \cdot 28 \cdot 27 \cdot 26 \cdot 25}{6 \cdot 5 \cdot 4 \cdot 3 \cdot 2 \cdot 1} = 593,775$$
>
> **Bit Strings:**
> How many bit strings of length $n$ contain exactly $r$ ones?
> - Choose $r$ positions out of $n$ for the 1s.
> - Answer: $C(n, r)$.
>
> **Committee Formation:**
> Selecting a committee of 3 math faculty (from 9) and 4 CS faculty (from 11).
> - Math choices: $C(9, 3)$.
> - CS choices: $C(11, 4)$.
> - Total: $C(9, 3) \cdot C(11, 4) = 84 \cdot 330 = 27,720$.

## Binomial Coefficients and Identities

The number of $r$-combinations from a set with $n$ elements, denoted by $\binom{n}{r}$, is called a **binomial coefficient** because these numbers appear as coefficients in the expansion of powers of binomial expressions, such as $(a + b)^n$.

### The Binomial Theorem

The binomial theorem provides a formula for the coefficients in the expansion of powers of binomial expressions. A **binomial expression** is the sum of two terms, such as $x + y$.

>[!example] Expansion of $(x + y)^3$
> Instead of multiplying terms directly, combinatorial reasoning can determine the expansion of $(x + y)^3$.
>
> **Reasoning:**
> When expanding $(x + y)(x + y)(x + y)$, terms like $x^3, x^2y, xy^2, y^3$ arise. The coefficient of each term corresponds to the number of ways to choose $x$ or $y$ from the three factors.
> - **$x^3$**: Choose $x$ from all three factors. Ways: $\binom{3}{3} = 1$.
> - **$x^2y$**: Choose $y$ from one factor (and $x$ from the other two). Ways: $\binom{3}{1} = 3$.
> - **$xy^2$**: Choose $y$ from two factors. Ways: $\binom{3}{2} = 3$.
> - **$y^3$**: Choose $y$ from all three factors. Ways: $\binom{3}{3} = 1$.
>
> **Result:**
> $$(x + y)^3 = x^3 + 3x^2y + 3xy^2 + y^3$$

>[!summary] Theorem 1: The Binomial Theorem
> Let $x$ and $y$ be variables, and let $n$ be a nonnegative integer. Then:
> $$(x + y)^n = \sum_{j=0}^{n} \binom{n}{j} x^{n-j}y^j = \binom{n}{0}x^n + \binom{n}{1}x^{n-1}y + \dots + \binom{n}{n-1}xy^{n-1} + \binom{n}{n}y^n$$
>
> **Breakdown:**
> - **$\sum_{j=0}^{n}$**: The summation operator. It iterates through every possible power of $y$ from $0$ to $n$.
> - **$\binom{n}{j}$**: The binomial coefficient. It counts the number of ways to choose $j$ factors (for $y$) out of $n$ total factors.
> - **$x^{n-j}y^j$**: The variable terms. As the exponent of $y$ ($j$) increases, the exponent of $x$ decreases so that the sum of exponents is always $n$.
>
> **Proof:**
> The terms in the expanded product are of the form $x^{n-j}y^j$. To obtain such a term, it is necessary to choose $n-j$ factors for $x$ (and consequently $j$ factors for $y$) from the $n$ binomial factors. The number of ways to do this is $\binom{n}{n-j}$, which equals $\binom{n}{j}$.

>[!example] Expansion of $(x + y)^4$
> Using the binomial theorem:
> $$(x + y)^4 = \sum_{j=0}^{4} \binom{4}{j}x^{4-j}y^j$$
> $$= \binom{4}{0}x^4 + \binom{4}{1}x^3y + \binom{4}{2}x^2y^2 + \binom{4}{3}xy^3 + \binom{4}{4}y^4$$
> $$= x^4 + 4x^3y + 6x^2y^2 + 4xy^3 + y^4$$

>[!example] Finding Specific Coefficients
> **Standard Coefficient:**
> The coefficient of $x^{12}y^{13}$ in $(x + y)^{25}$ is found by identifying the corresponding term where $j=13$.
> $$\binom{25}{13} = \frac{25!}{13!12!} = 5,200,300$$
>
> **Coefficient with Constants:**
> The coefficient of $x^{12}y^{13}$ in $(2x - 3y)^{25}$.
> - Rewrite as $(2x + (-3y))^{25}$.
> - Apply the theorem: $\binom{25}{13}(2x)^{12}(-3y)^{13}$.
> - The coefficient is $\binom{25}{13}2^{12}(-3)^{13} = -\frac{25!}{13!12!}2^{12}3^{13}$.

#### Corollaries from the Binomial Theorem

Useful identities can be derived by substituting specific values for $x$ and $y$ in the binomial theorem.

>[!summary] Corollary 1
> Let $n$ be a nonnegative integer. Then:
> $$\sum_{k=0}^{n} \binom{n}{k} = 2^n$$
>
> **Proof:**
> Set $x = 1$ and $y = 1$ in the binomial theorem:
> $$(1 + 1)^n = \sum_{k=0}^{n} \binom{n}{k}1^k1^{n-k} \implies 2^n = \sum_{k=0}^{n} \binom{n}{k}$$
>
> **Combinatorial Proof:**
> The left side counts the total number of subsets of a set with $n$ elements. The right side sums the number of subsets with 0 elements, 1 element, ..., up to $n$ elements. Since both count the same thing, they are equal.

>[!summary] Corollary 2
> Let $n$ be a positive integer. Then:
> $$\sum_{k=0}^{n} (-1)^k \binom{n}{k} = 0$$
>
> **Proof:**
> Set $x = -1$ and $y = 1$ in the binomial theorem:
> $$((-1) + 1)^n = \sum_{k=0}^{n} \binom{n}{k}(-1)^k1^{n-k} \implies 0^n = \sum_{k=0}^{n} \binom{n}{k}(-1)^k$$
>
> **Remark:** This implies that the sum of binomial coefficients with even indices equals the sum with odd indices:
> $$\binom{n}{0} + \binom{n}{2} + \dots = \binom{n}{1} + \binom{n}{3} + \dots$$

>[!summary] Corollary 3
> Let $n$ be a nonnegative integer. Then:
> $$\sum_{k=0}^{n} 2^k \binom{n}{k} = 3^n$$
>
> **Proof:**
> Set $x = 1$ and $y = 2$ in the binomial theorem:
> $$(1 + 2)^n = \sum_{k=0}^{n} \binom{n}{k}1^{n-k}2^k \implies 3^n = \sum_{k=0}^{n} 2^k \binom{n}{k}$$

### Pascal’s Identity and Triangle

Binomial coefficients satisfy many identities. One of the most fundamental establishes a relationship between coefficients in a triangular arrangement.

>[!summary] Theorem 2: Pascal’s Identity
> Let $n$ and $k$ be positive integers with $n \ge k$. Then:
> $$\binom{n + 1}{k} = \binom{n}{k - 1} + \binom{n}{k}$$
>
> **Breakdown:**
> - **$\binom{n + 1}{k}$**: The total number of subsets of size $k$ from a set $T$ with $n+1$ elements.
> - **$\binom{n}{k - 1}$**: The number of subsets that contain a specific element $a$ (we must choose $k-1$ remaining elements from the other $n$ elements).
> - **$\binom{n}{k}$**: The number of subsets that do not contain $a$ (we must choose all $k$ elements from the remaining $n$ elements).
>
> **Proof (Combinatorial):**
> Suppose $T$ is a set with $n+1$ elements. Let $a$ be an element in $T$ and let $S = T - \{a\}$. A subset of $T$ with $k$ elements either contains $a$ or does not.
> 1. **Contains $a$:** We need $k-1$ elements from $S$. There are $\binom{n}{k-1}$ ways.
> 2. **Does not contain $a$:** We need $k$ elements from $S$. There are $\binom{n}{k}$ ways.
> By the sum rule, the total is the sum of these two possibilities.

This identity is the basis for **Pascal’s Triangle**, a geometric arrangement of binomial coefficients.

>[!info] Pascal’s Triangle Structure
> - **Rows:** The $n$th row consists of the binomial coefficients $\binom{n}{k}$ for $k = 0, 1, \dots, n$.
> - **Construction:** Pascal’s Identity shows that adding two adjacent coefficients in a row produces the coefficient in the next row directly beneath them.
> - **Recursive Definition:** Combined with initial conditions $\binom{n}{0} = \binom{n}{n} = 1$, this identity allows for recursive computation of binomial coefficients using only addition.
>
> ![[Pasted image 20260227173004.png]]
> *Figure: Pascal's Triangle visualizes the relationship where two adjacent numbers sum to the number below.*

### Other Identities Involving Binomial Coefficients

Combinatorial proofs are effective for establishing relationships among binomial coefficients.

>[!summary] Theorem 3: Vandermonde’s Identity
> Let $m, n$, and $r$ be nonnegative integers with $r$ not exceeding either $m$ or $n$. Then:
> $$\binom{m + n}{r} = \sum_{k=0}^{r} \binom{m}{r - k} \binom{n}{k}$$
>
> **Breakdown:**
> - **LHS $\binom{m + n}{r}$**: The number of ways to choose $r$ elements from the union of two disjoint sets (one with $m$ items, one with $n$ items).
> - **RHS Summation**: Splits the count based on how many items are chosen from the second set ($k$) and the first set ($r-k$).
>     - **$\binom{n}{k}$**: Ways to choose $k$ elements from the second set.
>     - **$\binom{m}{r - k}$**: Ways to choose the remaining $r-k$ elements from the first set.
>
> **Proof (Combinatorial):**
> We want to pick $r$ elements from the union of a set with $m$ items and a set with $n$ items. The left side counts this directly. Alternatively, we can iterate through the number of elements $k$ chosen from the second set (from $0$ to $r$). For each $k$, we choose $k$ from the second set and $r-k$ from the first set. Summing these products gives the total.

>[!summary] Corollary 4
> If $n$ is a nonnegative integer, then:
> $$\binom{2n}{n} = \sum_{k=0}^{n} \binom{n}{k}^2$$
>
> **Proof:**
> This follows from Vandermonde’s Identity by setting $m = r = n$.
> $$\binom{2n}{n} = \sum_{k=0}^{n} \binom{n}{n - k} \binom{n}{k}$$
> Since $\binom{n}{n-k} = \binom{n}{k}$, the term becomes $\binom{n}{k}^2$.

>[!summary] Theorem 4
> Let $n$ and $r$ be nonnegative integers with $r \le n$. Then:
> $$\binom{n + 1}{r + 1} = \sum_{j=r}^{n} \binom{j}{r}$$
>
> **Breakdown:**
> - **LHS $\binom{n + 1}{r + 1}$**: Represents the number of bit strings of length $n+1$ containing exactly $r+1$ ones.
> - **RHS Summation**: Counts the same strings by conditioning on the position of the final `1`.
>     - **$j$**: The position of the last `1` (ranges from $r+1$ to $n+1$).
>     - **$\binom{j - 1}{r}$**: If the last `1` is at position $j$, the previous $j-1$ positions must contain exactly $r$ ones.
>
> **Proof (Combinatorial):**
> The LHS counts bit strings of length $n+1$ with $r+1$ ones. To count these differently, consider the position of the final `1`. It must occur at some position $k$ (where $r+1 \le k \le n+1$). If the last `1` is at $k$, the preceding $k-1$ bits must contain exactly $r$ ones. The number of such strings is $\binom{k-1}{r}$. Summing over all possible $k$ gives the total. Using the change of variable $j = k-1$, the sum becomes $\sum_{j=r}^{n} \binom{j}{r}$.
## Generalized Permutations and Combinations

### Introduction

Previous counting methods assumed that elements could be used at most once and that all objects were distinct. Many real-world problems, however, involve elements that can be used repeatedly or are indistinguishable from one another.

>[!info] Key Scenarios for Generalized Counting
> - **Repetition Allowed:** Elements like letters on a license plate or varieties of donuts can be chosen multiple times.
> - **Indistinguishable Elements:** Objects are identical, such as the letters in the word "SUCCESS" where the S's and C's are interchangeable.
> - **Distributing Objects into Boxes:** Counting ways to place distinguishable or indistinguishable objects into distinguishable or indistinguishable containers (e.g., dealing poker hands).

### Permutations with Repetition

When repetition of elements is allowed, the counting process is straightforward using the product rule.

>[!example] Strings of Letters
> How many strings of length $r$ can be formed from the uppercase English alphabet?
> - There are 26 choices for each of the $r$ positions.
> - By the product rule, there are $26^r$ such strings.

>[!summary] Theorem 1
> The number of $r$-permutations of a set of $n$ objects with repetition allowed is $n^r$.
>
> **Proof:**
> There are $n$ ways to select an element for each of the $r$ positions because all $n$ objects are available for every choice. By the product rule, the total is $n \cdot n \cdots n = n^r$.

### Combinations with Repetition

This involves selecting $r$ elements from a set of $n$ types where order does not matter, but elements can be chosen multiple times.

>[!example] Selecting Fruit
> How many ways are there to select four pieces of fruit from a bowl containing apples, oranges, and pears (assuming at least four of each)?
> - The order of selection does not matter.
> - This is a 4-combination with repetition allowed from a 3-element set.
> - Listing all possibilities (e.g., "4 apples", "3 apples, 1 orange", etc.) yields 15 ways.

To solve more complex problems systematically, we use the "Stars and Bars" method.

>[!info] The Stars and Bars Method
> This technique models $r$-combinations with repetition as an arrangement of symbols.
> - **Stars (`*`):** Represent the selected objects ($r$ stars total).
> - **Bars (`|`):** Represent dividers separating the types of objects ($n-1$ bars total for $n$ types).
> - The number of ways to select the items corresponds to the number of distinct arrangements of these symbols.

>[!example] Selecting Bills
> How many ways are there to select five bills from a cash box with 7 types of bills ($\$1, \$2, \$5, \$10, \$20, \$50, \$100$)?
> - **Objects ($r$):** 5 bills (represented by 5 stars).
> - **Types ($n$):** 7 types (separated by 6 bars).
> - **Total Positions:** $5 \text{ stars} + 6 \text{ bars} = 11$ positions.
> - We must choose 5 positions for the stars out of 11.
> - Calculation: $C(11, 5) = 462$ ways.

>[!summary] Theorem 2
> There are $C(n + r - 1, r)$ $r$-combinations from a set with $n$ elements when repetition is allowed.
>
> **Equation:**
> $$C(n + r - 1, r) = \frac{(n + r - 1)!}{r!(n - 1)!}$$
>
> **Breakdown:**
> - **$r$**: The total number of objects to be selected.
> - **$n$**: The number of distinct types of objects available.
> - **$n + r - 1$**: The total number of positions in the Stars and Bars representation (stars + bars).
> - **$C(n + r - 1, r)$**: The number of ways to choose the positions for the $r$ stars.

>[!example] Solving Integer Equations
> How many solutions does $x_1 + x_2 + x_3 = 11$ have where $x_i$ are nonnegative integers?
> - This corresponds to selecting 11 items from 3 types.
> - Using the formula: $C(3 + 11 - 1, 11) = C(13, 11) = 78$ solutions.
>
> **With Constraints:**
> If $x_1 \ge 1, x_2 \ge 2, x_3 \ge 3$:
> - Pre-allocate the required items: 1 to type 1, 2 to type 2, 3 to type 3 (total 6 used).
> - Remaining items to select: $11 - 6 = 5$.
> - New equation: Solve for remaining sum of 5.
> - Calculation: $C(3 + 5 - 1, 5) = C(7, 5) = 21$ solutions.

**Summary of Selection Formulas**

| Type | Repetition Allowed? | Formula |
| :--- | :--- | :--- |
| $r$-permutations | No | $\frac{n!}{(n-r)!}$ |
| $r$-combinations | No | $\frac{n!}{r!(n-r)!}$ |
| $r$-permutations | Yes | $n^r$ |
| $r$-combinations | Yes | $\frac{(n+r-1)!}{r!(n-1)!}$ |

### Permutations with Indistinguishable Objects

When arranging objects where some are identical, the total number of permutations decreases because swapping identical objects does not create a new arrangement.

>[!example] Rearranging SUCCESS
> How many different strings can be made from the letters of "SUCCESS"?
> - Total letters: 7.
> - Breakdown: 3 S's, 2 C's, 1 U, 1 E.
> - **Logic:**
>   1. Place the 3 S's in the 7 available positions: $C(7, 3)$ ways.
>   2. Place the 2 C's in the remaining 4 positions: $C(4, 2)$ ways.
>   3. Place the U in the remaining 2 positions: $C(2, 1)$ ways.
>   4. Place the E in the last position: $C(1, 1)$ way.
> - **Calculation:**
>   $$C(7, 3) \cdot C(4, 2) \cdot C(2, 1) \cdot C(1, 1) = \frac{7!}{3!4!} \cdot \frac{4!}{2!2!} \cdot \frac{2!}{1!1!} \cdot 1 = \frac{7!}{3!2!1!1!} = 420$$

>[!summary] Theorem 3
> The number of different permutations of $n$ objects, where there are $n_1$ indistinguishable objects of type 1, $n_2$ of type 2, ..., and $n_k$ of type $k$, is:
> $$\frac{n!}{n_1! n_2! \cdots n_k!}$$
>
> **Breakdown:**
> - **$n!$**: The total permutations if all objects were distinguishable.
> - **$n_i!$**: Divisors that account for the overcounting of indistinguishable objects of type $i$.

### Distributing Objects into Boxes

Counting problems often involve distributing objects into boxes. The solution method depends on whether the **objects** are distinguishable (labeled) or indistinguishable (unlabeled), and whether the **boxes** are distinguishable or indistinguishable.

#### Case 1: Distinguishable Objects and Distinguishable Boxes
This scenario corresponds to permutations with indistinguishable objects (Theorem 3) if we view the positions in the boxes as the types.

>[!example] Dealing Cards
> How many ways are there to distribute hands of 5 cards to each of four players from a standard deck of 52?
> - **Objects:** 52 distinguishable cards.
> - **Boxes:** 4 players (distinguishable) + the remaining deck (a 5th box).
> - **Distribution:**
>   - Player 1: 5 cards ($n_1 = 5$)
>   - Player 2: 5 cards ($n_2 = 5$)
>   - Player 3: 5 cards ($n_3 = 5$)
>   - Player 4: 5 cards ($n_4 = 5$)
>   - Remaining: 32 cards ($n_5 = 32$)
> - **Calculation:** $\frac{52!}{5!5!5!5!32!}$.

>[!summary] Theorem 4
> The number of ways to distribute $n$ distinguishable objects into $k$ distinguishable boxes so that $n_i$ objects are placed into box $i$ is:
> $$\frac{n!}{n_1! n_2! \cdots n_k!}$$

#### Case 2: Indistinguishable Objects and Distinguishable Boxes
This problem is equivalent to counting $r$-combinations with repetition allowed.

>[!example] Balls into Bins
> How many ways are there to place 10 indistinguishable balls into 8 distinguishable bins?
> - This is the same as selecting 10 items from 8 types (bins).
> - **Formula:** $C(n + r - 1, r)$ where $n=8$ bins, $r=10$ balls.
> - **Calculation:** $C(8 + 10 - 1, 10) = C(17, 10) = 19,448$.

#### Case 3: Distinguishable Objects and Indistinguishable Boxes
This is a more complex scenario with no simple closed formula. It involves partitioning a set of $n$ elements into $k$ non-empty subsets.

>[!info] Stirling Numbers of the Second Kind
> Let $S(n, j)$ denote the number of ways to distribute $n$ distinguishable objects into $j$ indistinguishable boxes so that no box is empty.
> - **Formula:**
>   $$S(n, j) = \frac{1}{j!} \sum_{i=0}^{j-1} (-1)^i \binom{j}{i} (j-i)^n$$
> - The total number of ways to distribute $n$ distinguishable objects into $k$ indistinguishable boxes (allowing empty boxes) is $\sum_{j=1}^{k} S(n, j)$.

>[!example] Employees into Offices
> How many ways to put 4 different employees into 3 indistinguishable offices?
> - **All 4 in 1 office:** 1 way ($\{\{A,B,C,D\}\}$).
> - **3 in one, 1 in another:** 4 ways.
> - **2 in one, 2 in another:** 3 ways ($\{\{A,B\}, \{C,D\}\}$ etc.).
> - **2 in one, 1 in others:** 6 ways.
> - **Total:** $1 + 4 + 3 + 6 = 14$ ways.

#### Case 4: Indistinguishable Objects and Indistinguishable Boxes
This is equivalent to partitioning the integer $n$ into at most $k$ parts.

>[!example] Packing Books
> How many ways to pack 6 copies of the same book into 4 identical boxes?
> - We list the partitions of 6 into parts $\le 4$:
>   - 6
>   - 5, 1
>   - 4, 2
>   - 4, 1, 1
>   - 3, 3
>   - 3, 2, 1
>   - 3, 1, 1, 1
>   - 2, 2, 2
>   - 2, 2, 1, 1
> - **Total:** 9 ways.

>[!info] Integer Partitions
> If $p_k(n)$ is the number of partitions of $n$ into at most $k$ positive integers, then there are $p_k(n)$ ways to distribute $n$ indistinguishable objects into $k$ indistinguishable boxes. No simple closed formula exists for $p_k(n)$.

