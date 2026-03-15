---
tags:
  - "#CCT2"
  - DS
Topic: "General introduction to algorithms and problem‑solving | Modeling problems using sets, functions, relations | Representation of algorithms (natural language, pseudocode, code) | Fundamental properties of algorithms: input, output, finiteness, correctness | Proofs of correctness: pre/postconditions, loop invariants | Illustrative algorithms: maximum search, linear search"
Semester: CCT2
Course: Diskrete strukturer
Litterature:
  - Discrete Mathematics and Its Applications - 8th Ed.
Created: 15-03-2026
---
- - -
# Table of Contents

1. [[#Algorithms|Algorithms]]
	1. [[#Algorithms#Algorithms|Algorithms]]
		1. [[#Algorithms#Introduction|Introduction]]
		2. [[#Algorithms#Properties of Algorithms|Properties of Algorithms]]
		3. [[#Algorithms#Searching Algorithms|Searching Algorithms]]
			1. [[#Searching Algorithms#The Linear Search|The Linear Search]]
			2. [[#Searching Algorithms#The Binary Search|The Binary Search]]
		4. [[#Algorithms#Sorting|Sorting]]
			1. [[#Sorting#The Bubble Sort|The Bubble Sort]]
			2. [[#Sorting#The Insertion Sort|The Insertion Sort]]
		5. [[#Algorithms#String Matching|String Matching]]
			1. [[#String Matching#The Naive String Matcher|The Naive String Matcher]]
		6. [[#Algorithms#Greedy Algorithms|Greedy Algorithms]]
			1. [[#Greedy Algorithms#The Cashier's Algorithm|The Cashier's Algorithm]]
			2. [[#Greedy Algorithms#Proving Optimality for Standard U.S. Coins|Proving Optimality for Standard U.S. Coins]]
			3. [[#Greedy Algorithms#Greedy Algorithm for Scheduling Talks|Greedy Algorithm for Scheduling Talks]]
		7. [[#Algorithms#The Halting Problem|The Halting Problem]]
			1. [[#The Halting Problem#Proof That the Halting Problem Is Unsolvable|Proof That the Halting Problem Is Unsolvable]]
	2. [[#Algorithms#The Growth of Functions|The Growth of Functions]]
		1. [[#The Growth of Functions#Introduction|Introduction]]
		2. [[#The Growth of Functions#Big-O Notation|Big-O Notation]]
			1. [[#Big-O Notation#Working with the Definition of Big-O Notation|Working with the Definition of Big-O Notation]]
		3. [[#The Growth of Functions#Big-O Estimates for Some Important Functions|Big-O Estimates for Some Important Functions]]
			1. [[#Big-O Estimates for Some Important Functions#Useful Big-O Estimates Involving Logarithms, Powers, and Exponential Functions|Useful Big-O Estimates Involving Logarithms, Powers, and Exponential Functions]]
		4. [[#The Growth of Functions#The Growth of Combinations of Functions|The Growth of Combinations of Functions]]
		5. [[#The Growth of Functions#Big-Omega and Big-Theta Notation|Big-Omega and Big-Theta Notation]]

# Algorithms
## Algorithms

### Introduction

Many problems can be solved by considering them as special cases of general problems.

There are many general classes of problems that arise in discrete mathematics. For instance: given a sequence of integers, find the largest one; given a set, list all its subsets; given a set of integers, put them in increasing order; given a network, find the shortest path between two vertices. When presented with such a problem, the first step is to construct a model that translates the problem into a mathematical context. Discrete structures used in such models include sets, sequences, functions, permutations, relations, graphs, trees, networks, and finite state machines.

Setting up the appropriate mathematical model is only part of the solution. To complete it, a method is needed that will solve the general problem using the model. Ideally, what is required is a procedure that follows a sequence of steps leading to the desired answer. Such a sequence of steps is called an *algorithm*.

>[!info] **Definition: Algorithm**
> An *algorithm* is a finite sequence of precise instructions for performing a computation or for solving a problem.

The term *algorithm* is a corruption of the name *al-Khowarizmi*, a mathematician of the ninth century, whose book on Hindu numerals is the basis of modern decimal notation. With the growing interest in computing machines, the concept of an algorithm was given a more general meaning, to include all definite procedures for solving problems, not just procedures for performing arithmetic.

>[!example] **Finding the Maximum Value in a Finite Sequence of Integers**
> Even though the problem of finding the maximum element in a sequence is relatively trivial, it provides a good illustration of the concept of an algorithm. There are also many practical instances where finding the largest integer in a finite sequence is required — for example, a university finding the highest score on a competitive exam, or a sports organization identifying the member with the highest rating each month.
>
> The goal is to develop an algorithm that can be used whenever this problem arises. One method is to describe the sequence of steps in plain English:
>
> 1. Set the *temporary maximum* equal to the first integer in the sequence. (The temporary maximum will be the largest integer examined at any stage of the procedure.)
> 2. Compare the next integer in the sequence to the temporary maximum, and if it is larger than the temporary maximum, set the temporary maximum equal to this integer.
> 3. Repeat the previous step if there are more integers in the sequence.
> 4. Stop when there are no integers left in the sequence. The temporary maximum at this point is the largest integer in the sequence.

An algorithm can also be described using a computer language. However, doing so restricts the description to only those instructions permitted in that language, which often makes the algorithm complicated and difficult to understand. Furthermore, because many programming languages are in common use, it would be undesirable to choose one particular language.

Instead, a form of *pseudocode* can be used. Pseudocode provides an intermediate step between an English language description of an algorithm and an implementation in a programming language. The steps of the algorithm are specified using instructions resembling those used in programming languages, but pseudocode can include any well-defined operations or statements. A computer program can then be produced in any language using the pseudocode description as a starting point.

The key difference between pseudocode and code in a programming language is that pseudocode allows any well-defined instruction, even if implementing that instruction would require many lines of actual code.

>[!info] **Algorithm: Finding the Maximum Element in a Finite Sequence**
> ```
> procedure max(a1, a2, ..., an : integers)
>     max := a1                      // Start by assuming the first element is the largest
>     for i := 2 to n                // Loop through remaining elements
>         if max < ai then max := ai // Update max if a larger element is found
>     return max                     // max is the largest element
> ```
> This algorithm first assigns the initial term of the sequence, $a_1$, to the variable `max`. The `for` loop successively examines each term. If a term is greater than the current value of `max`, it is assigned as the new value of `max`. The algorithm terminates after all terms have been examined, and the final value of `max` is the maximum element in the sequence.

To gain insight into how an algorithm works, it is useful to construct a *trace* that shows its steps when given specific input. For instance, a trace of the above algorithm with input **8, 4, 11, 3, 10** proceeds as follows:

1. `max` is set to **8** (the first term).
2. Compare **4** (second term) with **8**. Since $4 \leq 8$, `max` is unchanged.
3. Compare **11** (third term) with **8**. Since $8 < 11$, `max` is updated to **11**.
4. Compare **3** (fourth term) with **11**. Since $3 \leq 11$, `max` is unchanged.
5. Compare **10** (fifth term) with **11**. Since $10 \leq 11$, `max` is unchanged.

Since there are five terms ($n = 5$), after examining the last term the algorithm terminates with `max = 11`, reporting that **11** is the largest term in the sequence.

### Properties of Algorithms

There are several properties that algorithms generally share. They are useful to keep in mind when algorithms are described:

- **Input.** An algorithm has input values from a specified set.
- **Output.** From each set of input values, an algorithm produces output values from a specified set. The output values are the solution to the problem.
- **Definiteness.** The steps of an algorithm must be defined precisely.
- **Correctness.** An algorithm should produce the correct output values for each set of input values.
- **Finiteness.** An algorithm should produce the desired output after a finite (but perhaps large) number of steps for any input in the set.
- **Effectiveness.** It must be possible to perform each step of an algorithm exactly and in a finite amount of time.
- **Generality.** The procedure should be applicable for all problems of the desired form, not just for a particular set of input values.

>[!example] **Verifying That the Max Algorithm Satisfies All Properties**
> We can verify that the algorithm for finding the maximum element has all seven properties:
>
> - **Input:** The input is a sequence of integers.
> - **Output:** The output is the largest integer in the sequence.
> - **Definiteness:** Each step is precisely defined — only assignments, a finite loop, and conditional statements are used.
> - **Correctness:** The initial value of `max` is the first term. As successive terms are examined, `max` is updated whenever a term exceeds the maximum of the terms previously examined. When all terms have been examined, `max` equals the value of the largest term. (A rigorous proof of this requires mathematical induction.)
> - **Finiteness:** The algorithm terminates after all integers in the sequence have been examined, which is a finite number of steps.
> - **Effectiveness:** Each step is either a comparison or an assignment, both of which can be carried out exactly and in a finite amount of time.
> - **Generality:** The algorithm can be used to find the maximum of *any* finite sequence of integers.
### Searching Algorithms

The problem of locating an element in an ordered list occurs in many contexts. For instance, a program that checks the spelling of words searches for them in a dictionary, which is just an ordered list of words. Problems of this kind are called *searching problems*.

The general searching problem can be described as follows: Locate an element $x$ in a list of distinct elements $a_1, a_2, \ldots, a_n$, or determine that it is not in the list. The solution to this search problem is the location of the term in the list that equals $x$ (that is, $i$ is the solution if $x = a_i$) and is $0$ if $x$ is not in the list.

#### The Linear Search

The first algorithm is called the *linear search* (or *sequential search*) algorithm. It works by comparing $x$ with each element of the list one by one, starting from the beginning:

1. Compare $x$ with $a_1$. If $x = a_1$, the solution is location 1.
2. If $x \neq a_1$, compare $x$ with $a_2$. If $x = a_2$, the solution is location 2.
3. Continue this process, comparing $x$ successively with each term of the list until a match is found, in which case the solution is the location of that term.
4. If the entire list has been searched without locating $x$, the solution is 0.

>[!info] **Algorithm: The Linear Search**
> ```
> procedure linear_search(x: integer, a1, a2, ..., an: distinct integers)
>     i := 1
>     while (i ≤ n and x ≠ ai)       // Step through the list one element at a time
>         i := i + 1
>     if i ≤ n then location := i     // Match found at position i
>     else location := 0              // x is not in the list
>     return location
> ```
> `location` is the subscript of the term that equals $x$, or is $0$ if $x$ is not found.

#### The Binary Search

The *binary search* algorithm can be used when the list has terms occurring in order of increasing size (e.g., numbers listed from smallest to largest, or words in alphabetical order). It proceeds by comparing the element to be located to the middle term of the list. The list is then split into two smaller sublists of roughly equal size, and the search continues by restricting to the appropriate sublist based on the comparison. This process repeats until a list with one term is obtained, at which point a final comparison determines whether that term is $x$.

>[!example] **Searching for 19 Using Binary Search**
> Given the sorted list: **1 2 3 5 6 7 8 10 12 13 15 16 18 19 20 22** (16 terms):
>
> 1. Split into two halves of 8 terms each: **{1 2 3 5 6 7 8 10}** and **{12 13 15 16 18 19 20 22}**. The largest term of the first half is 10. Since $10 < 19$, restrict the search to the second half (terms 9–16).
> 2. Split **{12 13 15 16 18 19 20 22}** into two halves of 4: **{12 13 15 16}** and **{18 19 20 22}**. The largest term of the first half is 16. Since $16 < 19$, restrict to the second half (terms 13–16).
> 3. Split **{18 19 20 22}** into two halves of 2: **{18 19}** and **{20 22}**. The largest term of the first half is 19. Since $19$ is not greater than 19, restrict to the first half (terms 13–14).
> 4. Split **{18 19}** into two lists of 1: **{18}** and **{19}**. Since $18 < 19$, restrict to the second list (term 14).
> 5. The search has narrowed to one term. A comparison confirms that the 14th term is 19. **Result: location = 14.**

To describe the steps more precisely: to search for $x$ in the list $a_1, a_2, \ldots, a_n$ where $a_1 < a_2 < \cdots < a_n$, begin by comparing $x$ with the middle term $a_m$, where $m = \lfloor(n + 1)/2\rfloor$. (Recall that $\lfloor x \rfloor$ is the *floor function* — the greatest integer not exceeding $x$.)

- If $x > a_m$, restrict the search to the second half of the list: $a_{m+1}, a_{m+2}, \ldots, a_n$.
- If $x$ is not greater than $a_m$, restrict the search to the first half: $a_1, a_2, \ldots, a_m$.

The search has now been restricted to a list with no more than $\lceil n/2 \rceil$ elements. (Recall that $\lceil x \rceil$ is the *ceiling function* — the smallest integer greater than or equal to $x$.) This procedure repeats — comparing $x$ to the middle term of the restricted list and halving again — until a list with one term is obtained. Then a final check determines whether this term equals $x$.

>[!info] **Algorithm: The Binary Search**
> ```
> procedure binary_search(x: integer, a1, a2, ..., an: increasing integers)
>     i := 1                          // i is the left endpoint of the search interval
>     j := n                          // j is the right endpoint of the search interval
>     while i < j
>         m := ⌊(i + j) / 2⌋         // Find the middle index
>         if x > am then i := m + 1   // Search the upper half
>         else j := m                 // Search the lower half
>     if x = ai then location := i    // Check if the remaining element matches x
>     else location := 0              // x is not in the list
>     return location
> ```
> `location` is the subscript $i$ of the term $a_i$ equal to $x$, or $0$ if $x$ is not found.

The algorithm works by successively narrowing down the part of the sequence being searched. At any given stage, only the terms from $a_i$ to $a_j$ are under consideration — $i$ and $j$ are the smallest and largest subscripts of the remaining terms, respectively. The algorithm continues narrowing the search interval until only one term remains, at which point a comparison determines whether that term equals $x$.
### Sorting

Ordering the elements of a list is a problem that occurs in many contexts. For example, producing a telephone directory requires alphabetizing subscriber names, creating a dictionary requires words to be in alphabetical order, and generating a parts list requires ordering by increasing part number. Checking for duplicates in an e-mail mailing list can also be aided by first putting addresses in order.

>[!info] **Definition: Sorting**
> *Sorting* is putting the elements of a list into increasing order. For instance, sorting the list **7, 2, 1, 4, 5, 9** produces **1, 2, 4, 5, 7, 9**. Sorting the list **d, h, c, a, f** (alphabetically) produces **a, c, d, f, h**.

An amazingly large percentage of computing resources is devoted to sorting. Hence, much effort has been devoted to developing sorting algorithms — more than 100 have been devised using distinct strategies, with new ones introduced regularly. 

There are many reasons sorting algorithms interest computer scientists and mathematicians: some algorithms are easier to implement, some are more efficient (either in general or for inputs with certain characteristics, such as lists that are slightly out of order), some take advantage of particular computer architectures, and some are particularly clever.

#### The Bubble Sort

The *bubble sort* is one of the simplest sorting algorithms, but not one of the most efficient. It puts a list into increasing order by successively comparing adjacent elements and interchanging them if they are in the wrong order. The basic operation — interchanging a larger element with a smaller one that follows it — is performed starting at the beginning of the list for a full pass. This procedure is iterated until the sort is complete. The name comes from the idea that smaller elements "bubble" to the top as they are interchanged with larger elements.

>[!example] **Bubble Sort: Sorting 3, 2, 4, 1, 5**
> **First pass:**
> - Compare 3 and 2: $3 > 2$, so interchange → **2, 3, 4, 1, 5**
> - Compare 3 and 4: $3 < 4$, no interchange
> - Compare 4 and 1: $4 > 1$, so interchange → **2, 3, 1, 4, 5**
> - Compare 4 and 5: $4 < 5$, no interchange
> - *Result: the largest element (5) is now in its correct position.*
>
> **Second pass:**
> - Compare 2 and 3: $2 < 3$, no interchange
> - Compare 3 and 1: $3 > 1$, so interchange → **2, 1, 3, 4, 5**
> - Compare 3 and 4: $3 < 4$, no interchange (no need to compare further since 5 is already placed)
> - *Result: the two largest elements (4 and 5) are in their correct positions.*
>
> **Third pass:**
> - Compare 2 and 1: $2 > 1$, so interchange → **1, 2, 3, 4, 5**
> - Compare 2 and 3: $2 < 3$, no interchange
> - *Result: the three largest elements (3, 4, and 5) are in their correct positions.*
>
> **Fourth pass:**
> - Compare 1 and 2: $1 < 2$, no interchange
> - *Result: the sort is complete.* → **1, 2, 3, 4, 5**
>
>![[Pasted image 20260315182110.png]]

>[!info] **Algorithm: The Bubble Sort**
> ```
> procedure bubblesort(a1, ..., an : real numbers with n ≥ 2)
>     for i := 1 to n − 1                   // Perform n−1 passes
>         for j := 1 to n − i               // Compare adjacent pairs (fewer each pass)
>             if aj > aj+1 then
>                 interchange aj and aj+1    // Swap if out of order
> // a1, ..., an is now in increasing order
> ```
> Each pass $i$ guarantees that the $i$-th largest element is placed in its correct final position. The inner loop runs from 1 to $n - i$ because the last $i$ elements are already sorted after pass $i$.

#### The Insertion Sort

The *insertion sort* is another simple sorting algorithm. It works by building up a sorted portion of the list one element at a time. To sort a list with $n$ elements, it begins with the second element:

1. Compare the second element with the first element and insert it into the correct position among the first two elements.
2. Take the third element and insert it into the correct position among the first three elements.
3. In general, at the $j$-th step, insert the $j$-th element into the correct position among the previously sorted $j - 1$ elements. To find the correct position, a linear search is used — the $j$-th element is successively compared with the already sorted elements until the first element that is not less than it is found, or until it has been compared with all $j - 1$ elements.
4. Continue until the last element is placed in the correct position relative to the already sorted first $n - 1$ elements.

>[!example] **Insertion Sort: Sorting 3, 2, 4, 1, 5**
> Starting list: **3, 2, 4, 1, 5** (the sorted portion is marked in each step)
>
> **Step 1 — Insert 2:**
> - Compare 2 and 3: $2 < 3$, so place 2 before 3
> - List: **==2, 3==, 4, 1, 5**
>
> **Step 2 — Insert 4:**
> - Compare 4 with 2: $4 > 2$; compare 4 with 3: $4 > 3$; 4 stays in the third position
> - List: **==2, 3, 4==, 1, 5**
>
> **Step 3 — Insert 1:**
> - Compare 1 with 2: $1 < 2$, so place 1 before 2
> - List: **==1, 2, 3, 4==, 5**
>
> **Step 4 — Insert 5:**
> - Compare 5 with 1, 2, 3, 4: $5 > 4$, so 5 stays at the end
> - List: **==1, 2, 3, 4, 5==** — sort complete.

>[!info] **Algorithm: The Insertion Sort**
> ```
> procedure insertion_sort(a1, a2, ..., an : real numbers with n ≥ 2)
>     for j := 2 to n                    // Start from the 2nd element
>         i := 1
>         while aj > ai                  // Find the correct position for aj
>             i := i + 1
>         m := aj                        // Store the element to be inserted
>         for k := 0 to j − i − 1        // Shift elements to make room
>             aj−k := aj−k−1
>         ai := m                        // Place the element in its correct position
> // a1, ..., an is now in increasing order
> ```
> At each step $j$, the algorithm finds where the $j$-th element belongs among the first $j - 1$ already-sorted elements (using a linear search), shifts the elements that come after the insertion point one position to the right, and then places the element in its correct position.
### String Matching

In computer science, beyond searching and sorting, another frequently encountered problem is *string matching*. This problem asks: where does a particular string of characters $P$, called the _pattern_, occur within another string $T$, called the _text_?

For instance, we can ask whether the pattern `101` can be found within the string `11001011`. The pattern `101` occurs within the text at a _shift_ of four characters, because `101` is the string formed by the fifth, sixth, and seventh characters of the text. On the other hand, the pattern `111` does not occur within the text `110110001101`.

String matching plays an essential role in a wide variety of applications, including:

- Text editing (finding and replacing all occurrences of a string)
- Spam filters
- Network intrusion detection systems
- Search engines (matching keywords with words on web pages)
- Plagiarism detection
- Bioinformatics

In bioinformatics, many problems involve the study of DNA molecules, which are made up of four bases: thymine (T), adenine (A), cytosine (C), and guanine (G). DNA sequencing determines the order of these four bases, which leads to string matching problems on strings made up of the letters T, A, C, and G. For example, the pattern `CAG` occurs in the text `CATCACAGAGA` with a shift of five characters. Efficient string matching algorithms are especially critical here, since a string representing a human genome is about $3 \times 10^9$ characters long.

#### The Naive String Matcher

The _naive string matcher_ is a brute-force algorithm for string matching. Its inputs are a pattern $P = p_1 p_2 \ldots p_m$ and a text $T = t_1 t_2 \ldots t_n$. When the pattern begins at position $s + 1$ in the text, we say that $P$ occurs with _shift_ $s$ in $T$ — meaning $t_{s+1} = p_1,\; t_{s+2} = p_2,\; \ldots,\; t_{s+m} = p_m$.

To find all valid shifts, the algorithm checks every possible shift $s$ from $s = 0$ to $s = n - m$.

>[!example] Naive String Matcher — Pseudocode
> ```
> procedure string_match(n, m: positive integers, m ≤ n,
>                        t1, t2, ..., tn, p1, p2, ..., pm: characters)
>
> for s := 0 to n − m
>     j := 1
>     while (j ≤ m and t[s+j] = p[j])    // compare characters one by one
>         j := j + 1
>     if j > m then                        // all m characters matched
>         print "s is a valid shift"
> ```
> 
> - **Breakdown:**
>     - $n$ : The length of the text $T$.
>     - $m$ : The length of the pattern $P$.
>     - $s$ : The current shift being tested. It represents how many positions into the text the pattern alignment starts. The pattern is compared starting at position $s + 1$.
>     - $j$ : An index that iterates through the characters of the pattern $P$ during each comparison.
>     - The outer `for` loop tries every possible starting position by iterating $s$ from $0$ to $n - m$.
>     - The inner `while` loop compares the pattern character-by-character against the text at the current shift. If all $m$ characters match (i.e., $j > m$ after the loop), the shift $s$ is valid.

![[Pasted image 20260315184125.png]]

Many other string matching algorithms have been developed beyond the naive string matcher. These algorithms use a surprisingly wide variety of approaches to improve efficiency compared to the brute-force method.
### Greedy Algorithms

Many algorithms are designed to solve _optimization problems_ — problems where the goal is to find a solution that either minimizes or maximizes the value of some parameter. Examples of optimization problems include finding a route between two cities with the least total mileage, encoding messages using the fewest bits possible, and connecting network nodes using the least amount of fiber.

One of the simplest approaches to solving optimization problems is to select the best choice at each step, instead of considering all possible sequences of steps that may lead to an optimal solution. Algorithms that make what seems to be the "best" choice at each step are called _greedy algorithms_.

>[!important] Greedy Algorithms and Optimality
> Once we know that a greedy algorithm finds a _feasible_ solution, we still need to determine whether it has found an _optimal_ solution. The term "greedy" applies to the algorithm regardless of whether it actually finds an optimal solution. To verify optimality, we must either **prove** that the solution is always optimal, or **show a counterexample** where the algorithm yields a nonoptimal solution.

---

#### The Cashier's Algorithm

To make these concepts concrete, consider the _cashier's algorithm_ — a greedy algorithm for making change using coins. This algorithm is named after the approach cashiers traditionally used when making change by hand.

>[!example] Making Change for 67 Cents
> Consider the problem of making $n$ cents in change with quarters, dimes, nickels, and pennies, using the fewest total number of coins. The greedy strategy is: at each step, choose the coin of the largest denomination possible without exceeding $n$ cents.
>
> For 67 cents:
> 1. Select a quarter → 67 − 25 = 42 cents remaining
> 2. Select a quarter → 42 − 25 = 17 cents remaining
> 3. Select a dime → 17 − 10 = 7 cents remaining
> 4. Select a nickel → 7 − 5 = 2 cents remaining
> 5. Select a penny → 2 − 1 = 1 cent remaining
> 6. Select a penny → 1 − 1 = 0 cents remaining
>
> **Result:** 2 quarters, 1 dime, 1 nickel, 2 pennies = 6 coins total.

>[!example] Cashier's Algorithm — Pseudocode
> ```
> procedure change(c1, c2, ..., cr: values of denominations of coins,
>                  where c1 > c2 > ... > cr;
>                  n: a positive integer)
>
> for i := 1 to r
>     d_i := 0                    // d_i counts the coins of denomination c_i used
>     while n ≥ c_i
>         d_i := d_i + 1          // add a coin of denomination c_i
>         n := n − c_i
> // d_i is the number of coins of denomination c_i in the change, for i = 1, 2, ..., r
> ```
>
> - **Breakdown:**
>     - $c_1, c_2, \ldots, c_r$ : The denominations of available coins, sorted in decreasing order (e.g., $c_1 = 25, c_2 = 10, c_3 = 5, c_4 = 1$).
>     - $r$ : The number of different denominations.
>     - $n$ : The amount of change (in cents) to be made.
>     - $d_i$ : A counter tracking how many coins of denomination $c_i$ are used.
>     - The outer `for` loop iterates through each denomination from largest to smallest.
>     - The inner `while` loop repeatedly selects coins of the current denomination until doing so would exceed the remaining amount.

This algorithm works for any finite set of coin denominations. In the particular case of quarters (25), dimes (10), nickels (5), and pennies (1), this algorithm produces an optimal solution — it uses the fewest coins possible. However, the cashier's algorithm does **not** always produce optimal results for arbitrary denomination sets.

>[!warning] The Cashier's Algorithm Can Fail for Other Denomination Sets
> If we have only quarters, dimes, and pennies (no nickels), the cashier's algorithm makes change for 30 cents using **six coins** — one quarter and five pennies. However, three dimes would also make 30 cents using only **three coins**. The greedy approach fails here because it cannot "look ahead" to find the better combination.

---

#### Proving Optimality for Standard U.S. Coins

To prove that the cashier's algorithm is optimal for quarters, dimes, nickels, and pennies, we first establish a supporting lemma.

>[!summary] Lemma: Constraints on Optimal Change
> If $n$ is a positive integer, then $n$ cents in change using quarters, dimes, nickels, and pennies with the **fewest coins possible** has:
> - At most **two** dimes
> - At most **one** nickel
> - At most **four** pennies
> - **Cannot** have two dimes and a nickel simultaneously
>
> Consequently, the amount of change in dimes, nickels, and pennies cannot exceed **24 cents**.
>
> **Proof:**
> We use proof by contradiction. If we had more than the specified number of coins of each type, we could replace them with fewer coins of equal value:
> - Three dimes → replaced by a quarter and a nickel (3 coins → 2 coins)
> - Two nickels → replaced by a dime (2 coins → 1 coin)
> - Five pennies → replaced by a nickel (5 coins → 1 coin)
> - Two dimes and a nickel → replaced by a quarter (3 coins → 1 coin)
>
> Since we can have at most two dimes, one nickel, and four pennies — but not two dimes and a nickel together — the maximum value from dimes, nickels, and pennies is $20 + 0 + 4 = 24$ cents.

>[!summary] Theorem: Optimality of the Cashier's Algorithm (for Standard U.S. Coins)
> The cashier's algorithm always makes change using the fewest coins possible when change is made from quarters, dimes, nickels, and pennies.
>
> **Proof:**
> We use proof by contradiction. Suppose there exists a positive integer $n$ for which some other way of making change uses fewer coins than the greedy algorithm.
>
> Let $q'$ be the number of quarters used in this supposedly optimal alternative, and $q$ be the number used by the greedy algorithm.
>
> - Since the greedy algorithm uses the most quarters possible, $q' \leq q$.
> - But $q' < q$ is impossible: if it were, we would need to make up at least 25 cents from dimes, nickels, and pennies alone, which contradicts the Lemma (at most 24 cents from those coins).
> - Therefore $q' = q$, meaning both methods use the same number of quarters.
>
> With the same number of quarters, the remaining value from dimes, nickels, and pennies must be equal in both methods (and worth at most 24 cents). By the same reasoning:
> - The number of **dimes** must be the same (the greedy algorithm uses the most dimes possible, and the Lemma limits nickels and pennies).
> - The number of **nickels** must be the same.
> - The number of **pennies** must be the same.
>
> This contradicts the assumption that the alternative uses fewer coins. Therefore, the greedy algorithm is optimal. $\blacksquare$

---

#### Greedy Algorithm for Scheduling Talks

>[!example] The Talk Scheduling Problem
> Suppose we have a group of proposed talks with preset start and end times. We want to schedule as many talks as possible in a single lecture hall, with the constraints that:
> - Once a talk starts, it continues until it ends.
> - No two talks can proceed at the same time.
> - A talk can begin at the same time another one ends.
>
> Each talk $j$ has a start time $s_j$ and an end time $e_j$.

To devise a greedy algorithm, we need to decide _which criterion_ to use when selecting the next talk. Several natural criteria turn out to fail:

**Criterion 1 — Earliest start time:** Select the talk that starts earliest among compatible talks. This does not always work.
- _Counterexample:_ Talk 1 (8:00–12:00), Talk 2 (9:00–10:00), Talk 3 (11:00–12:00). The algorithm selects Talk 1 first, blocking both Talk 2 and Talk 3. But scheduling Talk 2 and Talk 3 together gives two talks instead of one.

**Criterion 2 — Shortest duration:** Select the shortest talk among compatible talks. This also does not always work.
- _Counterexample:_ Talk 1 (8:00–9:15), Talk 2 (9:00–10:00), Talk 3 (9:45–11:00). The algorithm selects Talk 2 (1 hour, shortest), blocking both Talk 1 and Talk 3. But scheduling Talk 1 and Talk 3 together gives two talks instead of one.

**Criterion 3 — Earliest finish time:** Select the talk with the earliest ending time among compatible talks. This criterion _does_ produce an optimal schedule (maximizing the number of talks). The talks are first sorted by increasing finish time, then relabeled so that $e_1 \leq e_2 \leq \cdots \leq e_n$.

>[!example] Greedy Algorithm for Scheduling Talks — Pseudocode
> ```
> procedure schedule(s1, s2, ..., sn: start times of talks,
>                    e1, e2, ..., en: ending times of talks)
>
> sort talks by finish time and reorder so that e1 ≤ e2 ≤ ... ≤ en
> S := ∅                              // S is the set of scheduled talks
> for j := 1 to n
>     if talk j is compatible with S then   // no overlap with any talk in S
>         S := S ∪ {talk j}                 // add talk j to the schedule
> return S
> ```
>
> - **Breakdown:**
>     - $s_j$ : The start time of talk $j$.
>     - $e_j$ : The end time of talk $j$.
>     - $n$ : The total number of proposed talks.
>     - $S$ : The set of talks selected for the schedule. Starts empty and grows as compatible talks are added.
>     - $\cup$ : The set union operator — it adds an element to the set $S$.
>     - A talk $j$ is _compatible_ with $S$ if it does not overlap with any talk already in $S$ (i.e., talk $j$ starts at or after the end time of the last scheduled talk).
>     - The algorithm iterates through talks in order of earliest finish time and greedily adds each talk that fits.
### The Halting Problem

One of the most famous results in computer science is that there exist _unsolvable problems_ — problems that cannot be solved by any procedure whatsoever. The *halting problem* is the classic example. It asks:

>[!info] The Halting Problem
> Given a computer program and an input to that program, is there a procedure that can determine whether the program will eventually stop (halt) when run with that input?

Having such a procedure would be extremely convenient — it would let us test whether a program has entered an infinite loop, which would be invaluable for writing and debugging programs.

However, we cannot simply run a program and observe what it does. If the program halts, we have our answer. But if it is still running after any fixed length of time, we cannot know whether it will _never_ halt or whether we simply have not waited long enough. It is not hard to design a program that will stop only after more than a billion years have elapsed.

![[Pasted image 20260315184855.png]]

---

#### Proof That the Halting Problem Is Unsolvable

This proof, due to Alan Turing, uses _proof by contradiction_.

>[!summary] Theorem: The Halting Problem Is Unsolvable
> There is no procedure that can determine, for every program $P$ and input $I$, whether $P$ halts when run with input $I$.
>
> **Proof:**
>
> **Step 1 — Assume a solution exists.**
> Assume there exists a procedure $H(P, I)$ that takes two inputs: a program $P$ and an input $I$ to that program. It produces:
> - The string `"halt"` if $P$ stops when given $I$ as input.
> - The string `"loops forever"` if $P$ runs forever when given $I$ as input.
>
> **Step 2 — A program can be its own input.**
> When a procedure is coded, it is expressed as a string of characters, which can be interpreted as a sequence of bits. This means a program itself can be used as data — a program can be given as input to another program, or even to itself. Therefore, $H(P, P)$ is a valid call: it asks whether program $P$ halts when given a copy of _itself_ as input.
>
> **Step 3 — Construct a contradictory procedure $K$.**
> Define a new procedure $K(P)$ that uses the output of $H(P, P)$ but does the _opposite_:
> - If $H(P, P)$ outputs `"loops forever"` (meaning $P$ loops forever on itself), then $K(P)$ **halts**.
> - If $H(P, P)$ outputs `"halt"` (meaning $P$ halts on itself), then $K(P)$ **loops forever**.
>
> **Step 4 — Feed $K$ to itself.**
> Now consider what happens when we provide $K$ as input to $K$ — that is, we evaluate $K(K)$:
>
> - **Case 1:** Suppose $H(K, K)$ outputs `"loops forever"`. Then by the definition of $K$, $K(K)$ halts. But if $K(K)$ halts, then by the definition of $H$, $H(K, K)$ should output `"halt"` — a **contradiction**.
>
> - **Case 2:** Suppose $H(K, K)$ outputs `"halt"`. Then by the definition of $K$, $K(K)$ loops forever. But if $K(K)$ loops forever, then by the definition of $H$, $H(K, K)$ should output `"loops forever"` — also a **contradiction**.
>
> **Conclusion:**
> In both cases we reach a contradiction. Therefore, $H$ cannot always give the correct answer. No procedure exists that solves the halting problem. $\blacksquare$

>[!tip] Intuition Behind the Proof
> The key insight is _self-reference_. Procedure $K$ is specifically designed to contradict whatever $H$ predicts about it. No matter what $H$ says $K$ will do when given itself as input, $K$ does the opposite — making it impossible for $H$ to be correct. This is structurally similar to the classic liar's paradox ("This statement is false") and to Cantor's diagonal argument in set theory.
## The Growth of Functions
### Introduction

The study of algorithms often focuses on counting the number of operations they use — for example, the number of comparisons a search or sorting algorithm needs to process a sequence of $n$ elements.

The actual *time* required to solve a problem depends on more than just the operation count; it also depends on the hardware and software running the algorithm. However, changing the platform only affects the time by a *constant multiplier* — a supercomputer might be a million times faster than a PC, but that factor doesn't change based on $n$. This is a crucial insight: the **growth rate** of operations as $n$ increases is what truly matters, not the constant factors.

This is where *big-O notation* becomes essential. It provides a way to estimate the growth of a function while ignoring constant multipliers and smaller-order terms. This has several practical advantages:

- **Hardware/software independence:** Since constant factors are ignored, analysis doesn't depend on the specific platform.
- **Simplified analysis:** We can assume all basic operations take the same amount of time.
- **Algorithm comparison:** We can determine which algorithm is more efficient as input size grows.

>[!example]
> Consider two algorithms for the same problem:
> - Algorithm A uses $100n^2 + 17n + 4$ operations.
> - Algorithm B uses $n^3$ operations.
>
> For small inputs like $n = 10$, Algorithm B actually uses fewer operations. But as $n$ grows large, Algorithm A becomes *far* more efficient because $n^2$ grows much more slowly than $n^3$ — the constant factor of 100 and the lower-order terms become insignificant.

Beyond big-O notation, there are two related notations — *big-Omega* and *big-Theta* — that together give a complete picture of how functions grow. These tools are fundamental for constructing growth estimates of important functions used in algorithm analysis.
### Big-O Notation

The growth of functions is often described using a special notation.

>[!summary] Definition: Big-O Notation
> Let $f$ and $g$ be functions from the set of integers or the set of real numbers to the set of real numbers. We say that $f(x)$ is $O(g(x))$ if there are constants $C$ and $k$ such that:
> $$|f(x)| \leq C|g(x)| \quad \text{whenever } x > k$$
> This is read as "$f(x)$ is big-oh of $g(x)$."
>
> **Breakdown:**
> - **$f(x)$** : The function whose growth we want to analyze.
> - **$g(x)$** : The reference function we are comparing $f(x)$ against.
> - **$C$** : A positive constant multiplier. It "scales up" $g(x)$ to create an upper bound.
> - **$k$** : A threshold value. The inequality only needs to hold for all $x$ beyond this point.
> - **$|\ |$** : Absolute value, ensuring we compare magnitudes.

>[!tip]
> Intuitively, saying $f(x)$ is $O(g(x))$ means that $f(x)$ grows no faster than some fixed multiple of $g(x)$ as $x$ grows without bound.

The constants $C$ and $k$ in the definition are called ***witnesses*** to the relationship $f(x)$ is $O(g(x))$. To establish the relationship, we need to find only **one** pair of witnesses. However, once one pair exists, there are *infinitely many* pairs. If $C$ and $k$ are witnesses, then any pair $C'$ and $k'$ where $C' > C$ and $k' > k$ is also a valid pair, because:

$$|f(x)| \leq C|g(x)| \leq C'|g(x)| \quad \text{whenever } x > k' > k$$

#### Working with the Definition of Big-O Notation

A useful approach for finding witnesses is to first select a value of $k$ for which the size of $|f(x)|$ can be readily estimated when $x > k$, and then see whether that estimate can be used to find a value of $C$ such that $|f(x)| \leq C|g(x)|$ for $x > k$.

>[!example] Show that $f(x) = x^2 + 2x + 1$ is $O(x^2)$
> **Approach 1:** Estimate $f(x)$ when $x > 1$. Since $x < x^2$ and $1 < x^2$ when $x > 1$:
> $$0 \leq x^2 + 2x + 1 \leq x^2 + 2x^2 + x^2 = 4x^2$$
> So we can take $C = 4$ and $k = 1$ as witnesses.
>
> **Approach 2:** Estimate $f(x)$ when $x > 2$. Since $2x \leq x^2$ and $1 \leq x^2$ when $x > 2$:
> $$0 \leq x^2 + 2x + 1 \leq x^2 + x^2 + x^2 = 3x^2$$
> So $C = 3$ and $k = 2$ are also valid witnesses.

Note that in the relationship "$f(x)$ is $O(x^2)$," the $x^2$ can be replaced by any function with larger values for sufficiently large $x$. For example, $f(x)$ is $O(x^3)$, $f(x)$ is $O(x^2 + x + 7)$, and so on. It is also true that $x^2$ is $O(x^2 + 2x + 1)$, since $x^2 \leq x^2 + 2x + 1$ whenever $x > 1$ (using $C = 1$ and $k = 1$ as witnesses).

When two functions $f(x)$ and $g(x)$ satisfy both $f(x)$ is $O(g(x))$ *and* $g(x)$ is $O(f(x))$, they are said to be of ***the same order***.

>[!note]
> The notation $f(x) = O(g(x))$ is sometimes used, but the equals sign here does **not** represent a genuine equality. It expresses that an inequality holds for sufficiently large values of $x$. The more precise notation is $f(x) \in O(g(x))$, since $O(g(x))$ represents the *set* of all functions that are $O(g(x))$.

When $f(x)$ is $O(g(x))$, and $h(x)$ is a function with larger absolute values than $g(x)$ for sufficiently large $x$, then $f(x)$ is also $O(h(x))$. This follows directly: if $|f(x)| \leq C|g(x)|$ and $|g(x)| \leq |h(x)|$ for $x > k$, then $|f(x)| \leq C|h(x)|$.

Because of this, when using big-O notation, $g(x)$ is typically chosen to be the function with the **smallest growth rate** from a set of common reference functions (such as $x^n$ for positive $n$). In practice, we almost always deal with functions that take only positive values, so absolute values can be dropped.

>[!example] Show that $7x^2$ is $O(x^3)$
> When $x > 7$, we have $7x^2 < x^3$ (obtained by multiplying both sides of $x > 7$ by $x^2$). So $C = 1$ and $k = 7$ are witnesses.
>
> Alternatively, when $x > 1$, we have $7x^2 < 7x^3$, giving witnesses $C = 7$ and $k = 1$.
>
> Note: $7x^2$ is also $O(x^2)$, and $x^2$ would be the *smallest* suitable power of $x$ for the reference function. Using $x^3$ is valid but not the tightest estimate.

>[!example] Show that $n^2$ is **not** $O(n)$
> We use proof by contradiction. Suppose there exist constants $C$ and $k$ such that $n^2 \leq Cn$ whenever $n > k$. For $n > 0$, dividing both sides by $n$ gives $n \leq C$. But no matter what $C$ and $k$ are, the inequality $n \leq C$ cannot hold for *all* $n > k$ — once $n$ exceeds both $k$ and $C$, the inequality fails. This contradiction shows $n^2$ is not $O(n)$.

>[!example] Is $x^3$ equal to $O(7x^2)$?
> We use proof by contradiction. If witnesses $C$ and $k$ existed such that $x^3 \leq C(7x^2)$ for all $x > k$, dividing both sides by $x^2$ gives $x \leq 7C$. But $x$ can be made arbitrarily large, so no fixed value of $7C$ can bound $x$ for all $x > k$. Therefore, $x^3$ is **not** $O(7x^2)$.
### Big-O Estimates for Some Important Functions

Polynomials can often be used to estimate the growth of functions. Rather than analyzing the growth of polynomials each time they appear, we want a general result. The key insight is that the *leading term* of a polynomial dominates its growth — a polynomial of degree $n$ or less is $O(x^n)$.

>[!summary] Theorem: Polynomial Growth
> Let $f(x) = a_n x^n + a_{n-1} x^{n-1} + \cdots + a_1 x + a_0$, where $a_0, a_1, \ldots, a_n$ are real numbers. Then $f(x)$ is $O(x^n)$.
>
> **Breakdown:**
> - $a_n, a_{n-1}, \ldots, a_0$ : The real-valued coefficients of the polynomial.
> - $x^n$ : The highest-degree (leading) term, which dominates growth for large $x$.
> - $C$ : The witness constant, equal to $|a_n| + |a_{n-1}| + \cdots + |a_0|$ (the sum of the absolute values of all coefficients).
> - $k$ : The witness threshold, equal to $1$.
>
> **Proof:**
> Using the triangle inequality, if $x > 1$ we have:
> $$|f(x)| = |a_n x^n + a_{n-1} x^{n-1} + \cdots + a_1 x + a_0|$$
> $$\leq |a_n|x^n + |a_{n-1}|x^{n-1} + \cdots + |a_1|x + |a_0|$$
> We can factor out $x^n$:
> $$= x^n \left( |a_n| + \frac{|a_{n-1}|}{x} + \cdots + \frac{|a_1|}{x^{n-1}} + \frac{|a_0|}{x^{n}} \right)$$
> Since $x > 1$, each fraction $\frac{|a_i|}{x^j} \leq |a_i|$, so:
> $$\leq x^n \left( |a_n| + |a_{n-1}| + \cdots + |a_1| + |a_0| \right)$$
> This shows $|f(x)| \leq C x^n$ where $C = |a_n| + |a_{n-1}| + \cdots + |a_0|$ whenever $x > 1$. Hence the witnesses $C$ and $k = 1$ confirm that $f(x)$ is $O(x^n)$.

>[!example] Estimating the Sum of the First $n$ Positive Integers
> **Question:** How can big-O notation estimate $1 + 2 + \cdots + n$?
>
> **Solution:** Because each integer in the sum does not exceed $n$:
> $$1 + 2 + \cdots + n \leq n + n + \cdots + n = n^2$$
> From this inequality, $1 + 2 + 3 + \cdots + n$ is $O(n^2)$, taking $C = 1$ and $k = 1$ as witnesses. (The domain here is the set of positive integers.)

>[!example] Big-O Estimates for the Factorial Function and Its Logarithm
> The *factorial function* $f(n) = n!$ is defined by:
> $$n! = 1 \cdot 2 \cdot 3 \cdots n$$
> for any positive integer $n$, with $0! = 1$. This function grows extremely rapidly (e.g., $20! = 2{,}432{,}902{,}008{,}176{,}640{,}000$).
>
> **Big-O estimate for $n!$:** Each term in the product does not exceed $n$, so:
> $$n! = 1 \cdot 2 \cdot 3 \cdots n \leq n \cdot n \cdot n \cdots n = n^n$$
> This shows $n!$ is $O(n^n)$, with $C = 1$ and $k = 1$ as witnesses.
>
> **Big-O estimate for $\log n!$:** Taking logarithms of both sides:
> $$\log n! \leq \log n^n = n \log n$$
> This shows $\log n!$ is $O(n \log n)$, again with $C = 1$ and $k = 1$ as witnesses.

>[!example] Showing $n$ is $O(2^n)$ and $\log n$ is $O(n)$
> Using the inequality $n < 2^n$, we conclude $n$ is $O(2^n)$ by taking $k = C = 1$ as witnesses.
>
> Since the logarithm function is increasing, taking base-2 logarithms of both sides gives $\log n < n$, so $\log n$ is $O(n)$ (with $C = k = 1$).
>
> For logarithms to a different base $b$ (where $b \neq 2$), we still have $\log_b n$ is $O(n)$ because:
> $$\log_b n = \frac{\log n}{\log b} < \frac{n}{\log b}$$
> We take $C = \frac{1}{\log b}$ and $k = 1$ as witnesses.

---

Big-O notation is used to estimate the number of operations needed to solve a problem using a specified procedure or algorithm. The functions commonly used in these estimates, listed from slowest to fastest growing, are:

$$1, \quad \log n, \quad n, \quad n \log n, \quad n^2, \quad 2^n, \quad n!$$

Each function in this list is smaller than the succeeding function, in the sense that the ratio of a function to its successor tends to zero as $n$ grows without bound.

![[Pasted image 20260315185647.png]]
*The graphs of the common functions used in big-O estimates, plotted on a logarithmic vertical scale (each successive marking doubles in value).*

---

#### Useful Big-O Estimates Involving Logarithms, Powers, and Exponential Functions

Several important facts help determine big-O relationships between pairs of functions when each is a power of a logarithm, a power of $n$, or an exponential function $b^n$ (where $b > 1$):

- **Powers of $n$:** If $d > c > 1$, then $n^c$ is $O(n^d)$, but $n^d$ is *not* $O(n^c)$. This follows directly from the polynomial growth theorem — higher powers of $n$ grow strictly faster than lower powers.

- **Logarithms vs. Powers of $n$:** Whenever $b > 1$ and $c, d$ are positive:
$$(\log_b n)^c \text{ is } O(n^d), \quad \text{but } n^d \text{ is not } O((\log_b n)^c)$$
Every positive power of the logarithm grows slower than every positive power of $n$, and this relationship never reverses.

- **Powers of $n$ vs. Exponentials:** Whenever $d$ is positive and $b > 1$:
$$n^d \text{ is } O(b^n), \quad \text{but } b^n \text{ is not } O(n^d)$$
Every power of $n$ grows slower than every exponential function with base greater than one, and this never reverses.

- **Exponentials with different bases:** When $c > b > 1$:
$$b^n \text{ is } O(c^n), \quad \text{but } c^n \text{ is not } O(b^n)$$
Among exponential functions with bases greater than one, the one with the smaller base is big-O of the one with the larger base, but not the other way around.

- **Exponentials vs. Factorials:** When $c > 1$:
$$c^n \text{ is } O(n!), \quad \text{but } n! \text{ is not } O(c^n)$$
The factorial function grows faster than any exponential function.

>[!example] Ordering Functions by Growth Rate
> **Question:** Arrange these functions so that each is big-O of the next:
> - $f_1(n) = 8\sqrt{n}$
> - $f_2(n) = (\log n)^2$
> - $f_3(n) = 2n \log n$
> - $f_4(n) = n!$
> - $f_5(n) = (1.1)^n$
> - $f_6(n) = n^2$
>
> **Solution:** Applying the big-O relationships above:
> 1. $f_2(n) = (\log n)^2$ — slowest growing, because any power of $\log n$ grows slower than any positive power of $n$.
> 2. $f_1(n) = 8\sqrt{n} = 8n^{1/2}$ — a power of $n$ with exponent $1/2$.
> 3. $f_3(n) = 2n \log n$ — grows faster than $n$ but slower than $n^c$ for every $c > 1$.
> 4. $f_6(n) = n^2$ — a power of $n$ with exponent $2$.
> 5. $f_5(n) = (1.1)^n$ — an exponential function (base $1.1 > 1$), which grows faster than any power of $n$.
> 6. $f_4(n) = n!$ — the fastest growing, since factorials grow faster than any exponential function.
>
> **Final ordering:** $(\log n)^2, \; 8\sqrt{n}, \; 2n\log n, \; n^2, \; (1.1)^n, \; n!$


### The Growth of Combinations of Functions

Many algorithms are composed of two or more separate subprocedures. The total number of steps to solve a problem is the *sum* of the steps used by each subprocedure. To get a big-O estimate for the whole algorithm, we need to find big-O estimates for each subprocedure and then *combine* them. This requires rules for how big-O estimates behave under addition and multiplication of functions.

Suppose $f_1(x)$ is $O(g_1(x))$ and $f_2(x)$ is $O(g_2(x))$. By definition, there exist constants $C_1, C_2, k_1, k_2$ such that:

$$|f_1(x)| \leq C_1|g_1(x)| \text{ when } x > k_1$$
$$|f_2(x)| \leq C_2|g_2(x)| \text{ when } x > k_2$$

**For the sum** $f_1(x) + f_2(x)$, using the triangle inequality $|a + b| \leq |a| + |b|$:

$$|(f_1 + f_2)(x)| \leq |f_1(x)| + |f_2(x)|$$

When $x$ is greater than both $k_1$ and $k_2$:

$$|f_1(x)| + |f_2(x)| \leq C_1|g_1(x)| + C_2|g_2(x)| \leq C_1|g(x)| + C_2|g(x)| = (C_1 + C_2)|g(x)|$$

where $g(x) = \max(|g_1(x)|, |g_2(x)|)$. This shows $|(f_1 + f_2)(x)| \leq C|g(x)|$ whenever $x > k$, with $C = C_1 + C_2$ and $k = \max(k_1, k_2)$.

>[!summary] Theorem: Big-O of a Sum
> Suppose $f_1(x)$ is $O(g_1(x))$ and $f_2(x)$ is $O(g_2(x))$. Then $(f_1 + f_2)(x)$ is $O(g(x))$, where $g(x) = \max(|g_1(x)|, |g_2(x)|)$ for all $x$.
>
> **Breakdown:**
> - $f_1, f_2$ : The two functions being added.
> - $g_1, g_2$ : Their respective big-O bounding functions.
> - $g(x) = \max(|g_1(x)|, |g_2(x)|)$ : The combined bound — whichever bounding function is larger dominates the sum.
> - $C = C_1 + C_2$ : The witness constant for the sum.
> - $k = \max(k_1, k_2)$ : The witness threshold — the inequality holds once $x$ exceeds both individual thresholds.

>[!summary] Corollary: Sum with a Common Bound
> Suppose $f_1(x)$ and $f_2(x)$ are both $O(g(x))$. Then $(f_1 + f_2)(x)$ is $O(g(x))$.
>
> This follows directly because $\max(g(x), g(x)) = g(x)$.

**For the product** $f_1(x) \cdot f_2(x)$, when $x > \max(k_1, k_2)$:

$$|(f_1 f_2)(x)| = |f_1(x)| \cdot |f_2(x)| \leq C_1|g_1(x)| \cdot C_2|g_2(x)| = C_1 C_2 |g_1(x) g_2(x)|$$

>[!summary] Theorem: Big-O of a Product
> Suppose $f_1(x)$ is $O(g_1(x))$ and $f_2(x)$ is $O(g_2(x))$. Then $(f_1 f_2)(x)$ is $O(g_1(x) g_2(x))$.
>
> **Breakdown:**
> - The bounding function for a product is simply the *product* of the individual bounding functions.
> - $C = C_1 C_2$ : The witness constant for the product.
> - $k = \max(k_1, k_2)$ : The witness threshold.

The goal when using big-O notation is to choose a function $g(x)$ that is as *simple* as possible while still growing relatively slowly. The sum and product theorems are the main tools for building up big-O estimates for complex expressions from simpler ones.

>[!example] Estimating $f(n) = 3n\log(n!) + (n^2 + 3)\log n$
> **First term — $3n\log(n!)$:**
> - We know $\log(n!)$ is $O(n\log n)$ (from the factorial estimate established earlier).
> - $3n$ is $O(n)$.
> - By the product theorem: $3n\log(n!)$ is $O(n \cdot n\log n) = O(n^2 \log n)$.
>
> **Second term — $(n^2 + 3)\log n$:**
> - Since $n^2 + 3 < 2n^2$ when $n > 2$, we have $n^2 + 3$ is $O(n^2)$.
> - By the product theorem: $(n^2 + 3)\log n$ is $O(n^2 \log n)$.
>
> **Combining via the sum theorem:**
> Both terms are $O(n^2 \log n)$, so by the corollary:
> $$f(n) = 3n\log(n!) + (n^2 + 3)\log n \text{ is } O(n^2 \log n)$$

>[!example] Estimating $f(x) = (x + 1)\log(x^2 + 1) + 3x^2$
> **First term — $(x+1)\log(x^2+1)$:**
> - $(x+1)$ is $O(x)$.
> - For $\log(x^2+1)$: since $x^2 + 1 \leq 2x^2$ when $x > 1$:
>     $$\log(x^2+1) \leq \log(2x^2) = \log 2 + 2\log x \leq 3\log x \quad (x > 2)$$
>     So $\log(x^2+1)$ is $O(\log x)$.
> - By the product theorem: $(x+1)\log(x^2+1)$ is $O(x\log x)$.
>
> **Second term — $3x^2$:**
> - $3x^2$ is $O(x^2)$.
>
> **Combining via the sum theorem:**
> $f(x)$ is $O(\max(x\log x, \, x^2))$. Since $x\log x \leq x^2$ for $x > 1$, the maximum is $x^2$, so:
> $$f(x) \text{ is } O(x^2)$$

---

### Big-Omega and Big-Theta Notation

Big-O notation provides an *upper bound* on the size of $f(x)$ for large values of $x$, but it does not provide a *lower bound*. To address this limitation, Donald Knuth introduced two additional notations in the 1970s:

- **Big-Omega ($\Omega$)** notation — for lower bounds.
- **Big-Theta ($\Theta$)** notation — for when both an upper *and* a lower bound are needed (i.e., a "tight" bound).

His motivation was the common *misuse* of big-O notation in situations where both bounds are actually required.

>[!info] Definition: Big-Omega Notation
> Let $f$ and $g$ be functions from the set of integers or real numbers to the set of real numbers. We say $f(x)$ is $\Omega(g(x))$ if there are constants $C$ and $k$ with $C$ positive such that:
> $$|f(x)| \geq C|g(x)| \quad \text{whenever } x > k$$
>
> **Breakdown:**
> - $C$ : A positive witness constant establishing the lower bound.
> - $k$ : The witness threshold beyond which the inequality holds.
> - The key difference from big-O: the inequality is $\geq$ instead of $\leq$ — meaning $f(x)$ grows *at least as fast* as $g(x)$.

There is a strong connection between the two notations: $f(x)$ is $\Omega(g(x))$ *if and only if* $g(x)$ is $O(f(x))$. In other words, big-Omega is the "reverse" of big-O.

>[!example] Showing $8x^3 + 5x^2 + 7$ is $\Omega(x^3)$
> Let $f(x) = 8x^3 + 5x^2 + 7$ and $g(x) = x^3$.
>
> Since $f(x) = 8x^3 + 5x^2 + 7 \geq 8x^3$ for all positive real numbers $x$, we have $|f(x)| \geq 8|g(x)|$.
>
> So $f(x)$ is $\Omega(x^3)$ with $C = 8$ and $k = 0$. This is equivalent to saying $x^3$ is $O(8x^3 + 5x^2 + 7)$.

---

Knowing the *order of growth* of a function requires both an upper bound and a lower bound. Given a function $f(x)$, we want a reference function $g(x)$ such that $f(x)$ is simultaneously $O(g(x))$ and $\Omega(g(x))$. Big-Theta notation captures exactly this.

>[!info] Definition: Big-Theta Notation
> Let $f$ and $g$ be functions from the set of integers or real numbers to the set of real numbers. We say $f(x)$ is $\Theta(g(x))$ if $f(x)$ is $O(g(x))$ *and* $f(x)$ is $\Omega(g(x))$.
>
> When $f(x)$ is $\Theta(g(x))$, we say that:
> - $f$ is *big-Theta of* $g(x)$
> - $f(x)$ is *of order* $g(x)$
> - $f(x)$ and $g(x)$ are *of the same order*

Key properties of big-Theta:

- **Symmetry:** $f(x)$ is $\Theta(g(x))$ if and only if $g(x)$ is $\Theta(f(x))$.
- **Equivalent formulation:** $f(x)$ is $\Theta(g(x))$ if and only if $f(x)$ is $O(g(x))$ and $g(x)$ is $O(f(x))$.
- **Direct characterization:** $f(x)$ is $\Theta(g(x))$ if and only if there exist positive real numbers $C_1$, $C_2$, and $k$ such that:

$$C_1|g(x)| \leq |f(x)| \leq C_2|g(x)| \quad \text{whenever } x > k$$

The function $g(x)$ in $\Theta(g(x))$ is typically a simple reference function like $x^n$, $c^x$, $\log x$, etc., while $f(x)$ can be relatively complicated.

>[!example] Showing $1 + 2 + \cdots + n$ is $\Theta(n^2)$
> Let $f(n) = 1 + 2 + 3 + \cdots + n$.
>
> **Upper bound (already established):** $f(n)$ is $O(n^2)$ because each term $\leq n$, giving $f(n) \leq n^2$.
>
> **Lower bound:** To show $f(n)$ is $\Omega(n^2)$, ignore the first half of the terms and sum only the terms greater than $\lceil n/2 \rceil$:
> $$1 + 2 + \cdots + n \geq \lceil n/2 \rceil + (\lceil n/2 \rceil + 1) + \cdots + n$$
> Each of these remaining terms is at least $\lceil n/2 \rceil$, and there are $(n - \lceil n/2 \rceil + 1)$ of them:
> $$\geq (n - \lceil n/2 \rceil + 1) \cdot \lceil n/2 \rceil \geq \frac{n}{2} \cdot \frac{n}{2} = \frac{n^2}{4}$$
>
> This shows $f(n) \geq \frac{1}{4} n^2$, so $f(n)$ is $\Omega(n^2)$ with $C = 1/4$.
>
> **Conclusion:** Since $f(n)$ is both $O(n^2)$ and $\Omega(n^2)$, we have $f(n)$ is $\Theta(n^2)$.

>[!example] Showing $3x^2 + 8x\log x$ is $\Theta(x^2)$
> **Upper bound:** Since $0 \leq 8x\log x \leq 8x^2$ for $x > 1$:
> $$3x^2 + 8x\log x \leq 3x^2 + 8x^2 = 11x^2$$
> So $3x^2 + 8x\log x$ is $O(x^2)$.
>
> **Lower bound:** Clearly $3x^2 + 8x\log x \geq 3x^2 \geq x^2$ for positive $x$, so $x^2$ is $O(3x^2 + 8x\log x)$.
>
> **Conclusion:** $3x^2 + 8x\log x$ is $\Theta(x^2)$.

One useful fact is that the *leading term* of a polynomial determines its order.

>[!summary] Theorem: Order of a Polynomial
> Let $f(x) = a_n x^n + a_{n-1} x^{n-1} + \cdots + a_1 x + a_0$, where $a_0, a_1, \ldots, a_n$ are real numbers with $a_n \neq 0$. Then $f(x)$ is of order $x^n$, i.e., $f(x)$ is $\Theta(x^n)$.
>
> **Breakdown:**
> - The condition $a_n \neq 0$ is critical — the leading coefficient must be nonzero for $x^n$ to truly be the leading term.
> - This combines the earlier theorem (polynomial is $O(x^n)$) with the fact that $|a_n| x^n$ provides a lower bound for large $x$.

>[!example] Orders of Specific Polynomials
> - $3x^8 + 10x^7 + 221x^2 + 1444$ is of order $x^8$
> - $x^{19} - 18x^4 - 10{,}112$ is of order $x^{19}$
> - $-x^{99} + 40{,}001x^{98} + 100{,}003x$ is of order $x^{99}$

>[!warning] Common Misuse of Big-O
> As Knuth observed, big-O notation is often carelessly used as if it has the same meaning as big-Theta notation. Big-O only gives an *upper bound*, while big-Theta provides *both* an upper and lower bound. The recent trend has been to use big-Theta notation whenever both bounds on the size of a function are needed.