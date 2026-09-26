---
tags:
  - CCT3
  - Algoritmer
Topic: analysis and design of divide-and-qonquer algorithms
Semester: CCT3
Course: Algoritmer
Litterature:
  - Introduction to Algorithms 4th ed.
Created: 26-09-2026
---
- - -
## Table of Contents

1. [[#Recurrences|Recurrences]]
	1. [[#Recurrences#Algorithmic Recurrences|Algorithmic Recurrences]]
2. [[#Recurrence Conventions|Recurrence Conventions]]
3. [[#Varieties of Divide-and-Conquer Recurrences|Varieties of Divide-and-Conquer Recurrences]]
	1. [[#Varieties of Divide-and-Conquer Recurrences#1. Equal Fractional Subproblems|1. Equal Fractional Subproblems]]
	2. [[#Varieties of Divide-and-Conquer Recurrences#2. Unequal Fractional Subproblems|2. Unequal Fractional Subproblems]]
	3. [[#Varieties of Divide-and-Conquer Recurrences#3. Subtractive (Non-Fractional) Subproblems|3. Subtractive (Non-Fractional) Subproblems]]
4. [[#Methods for Solving Recurrences|Methods for Solving Recurrences]]
5. [[#4.1 Multiplying Square Matrices|4.1 Multiplying Square Matrices]]
	1. [[#4.1 Multiplying Square Matrices#Standard Iterative Matrix Multiplication|Standard Iterative Matrix Multiplication]]
	2. [[#4.1 Multiplying Square Matrices#A Simple Divide-and-Conquer Algorithm|A Simple Divide-and-Conquer Algorithm]]
	3. [[#4.1 Multiplying Square Matrices#Partitioning Implementation Strategies|Partitioning Implementation Strategies]]
	4. [[#4.1 Multiplying Square Matrices#Recursive Matrix Multiplication Algorithm|Recursive Matrix Multiplication Algorithm]]
6. [[#4.2 Strassen’s Algorithm for Matrix Multiplication|4.2 Strassen’s Algorithm for Matrix Multiplication]]
	1. [[#4.2 Strassen’s Algorithm for Matrix Multiplication#The Fundamental Trade-Off|The Fundamental Trade-Off]]
	2. [[#4.2 Strassen’s Algorithm for Matrix Multiplication#The Four-Step Algorithm|The Four-Step Algorithm]]
	3. [[#4.2 Strassen’s Algorithm for Matrix Multiplication#Detailed Mathematical Formulations|Detailed Mathematical Formulations]]
		1. [[#Detailed Mathematical Formulations#Step 2: Intermediate Sums and Differences ($S_1$ to $S_{10}$)|Step 2: Intermediate Sums and Differences ($S_1$ to $S_{10}$)]]
		2. [[#Detailed Mathematical Formulations#Step 3: Seven Recursive Products ($P_1$ to $P_7$)|Step 3: Seven Recursive Products ($P_1$ to $P_7$)]]
		3. [[#Detailed Mathematical Formulations#Step 4: Constructing the Product Submatrices ($C_{ij}$)|Step 4: Constructing the Product Submatrices ($C_{ij}$)]]
	4. [[#4.2 Strassen’s Algorithm for Matrix Multiplication#Running Time Analysis|Running Time Analysis]]
7. [[#4.3 The Substitution Method for Solving Recurrences|4.3 The Substitution Method for Solving Recurrences]]
	1. [[#4.3 The Substitution Method for Solving Recurrences#Demonstrating the Substitution Method|Demonstrating the Substitution Method]]
	2. [[#4.3 The Substitution Method for Solving Recurrences#Heuristics for Generating Good Guesses|Heuristics for Generating Good Guesses]]
	3. [[#4.3 The Substitution Method for Solving Recurrences#Strengthening the Hypothesis: Subtracting a Lower-Order Term|Strengthening the Hypothesis: Subtracting a Lower-Order Term]]
	4. [[#4.3 The Substitution Method for Solving Recurrences#Pitfalls to Avoid|Pitfalls to Avoid]]

# Divide-and-Conquer

The **divide-and-conquer** method is an algorithmic paradigm based on multi-branched recursion. A divide-and-conquer algorithm breaks a problem down into smaller instances of the same problem, solves those instances recursively, and combines their solutions to resolve the original problem.

The execution branches into two main cases:
- **Base Case:** When the problem instance is sufficiently small, it is solved directly without further recursive calls.
- **Recursive Case:** When the problem instance is large, it undergoes three distinct operational steps:
  1. **Divide:** Partition the problem into one or more subproblems that are smaller instances of the identical problem.
  2. **Conquer:** Solve each subproblem recursively.
  3. **Combine:** Merge the subproblem solutions into the solution for the original problem.

---

## Recurrences

A **recurrence** is an equation or inequality that describes a mathematical function in terms of its value on smaller arguments. Recurrences provide the standard mathematical tool for characterizing and analyzing the running times of recursive algorithms.

A general recurrence consists of:
- **Recursive Cases:** Branches where the function is invoked recursively on smaller arguments.
- **Base Cases:** Branches where the function is evaluated directly without recursion.
- A recurrence is **well-defined** if there exists at least one mathematical function that satisfies its system of equations, and **ill-defined** otherwise.

### Algorithmic Recurrences

Recurrences that represent the running time $T(n)$ of valid divide-and-conquer algorithms exhibit specific structural properties.

>[!info] Definition: Algorithmic Recurrence
>A running-time recurrence $T(n)$ is **algorithmic** if, for every sufficiently large threshold constant $n_0 > 0$, the following two conditions hold:
>1. **Constant Base Time:** For all $n < n_0$, $T(n) = \Theta(1)$.
>2. **Finite Termination:** For all $n \ge n_0$, every recursion path terminates in a base case within a finite number of recursive steps.
>
>**Breakdown:**
>- $T(n)$ : The worst-case running-time function for an input size $n$.
>- $n$ : The problem input size parameter.
>- $n_0$ : A positive threshold constant defining the boundary between recursive subproblems and direct base-case computation.
>- $\Theta(1)$ : Bounded constant time (execution takes between $c_1$ and $c_2$ basic operations for positive constants $c_1, c_2$).

These properties reflect practical computation:
- The base execution time must be strictly positive ($T(n) \ge c_1 > 0$) because entering and exiting functions requires executing machine instructions.
- The maximum running time for small inputs ($n < n_0$) must be bounded from above ($T(n) \le c_2$) across the finite set of small inputs.
- Failure to terminate within a finite number of recursive invocations would mean the algorithm enters an infinite loop, failing to solve the problem.

---

## Recurrence Conventions

When working with divide-and-conquer recurrences, standard conventions simplify notation and analysis:

- **Implicit Base Cases:** When an algorithmic recurrence is written without an explicit base case, it is assumed that $T(n) = \Theta(1)$ for all $n < n_0$ for a sufficiently large constant $n_0$. The asymptotic solution remains invariant under any valid choice of $n_0$.
- **Omission of Floors and Ceilings:** Although odd problem sizes divide into integer subproblems involving floors and ceilings (e.g., $T(\lfloor n/2 \rfloor) + T(\lceil n/2 \rceil)$), the asymptotic solution is identical to the continuous real formulation $2T(n/2)$. Thus, floor and ceiling notations are generally omitted.
- **Inequalities and Asymptotic Bounds:** 
  - If a recurrence is defined as an upper-bound inequality (e.g., $T(n) \le 2T(n/2) + \Theta(n)$), its solution is expressed using $O$-notation.
  - If defined as a lower-bound inequality (e.g., $T(n) \ge 2T(n/2) + \Theta(n)$), its solution is expressed using $\Omega$-notation.

---

## Varieties of Divide-and-Conquer Recurrences

Divide-and-conquer algorithms partition subproblems in various configurations:

### 1. Equal Fractional Subproblems
The original problem of size $n$ is partitioned into $a$ equal subproblems of size $n/b$:

- **Standard Recursive Matrix Multiplication:** Divides matrix multiplication into 8 recursive subproblems of half size:
  $$T(n) = 8T(n/2) + \Theta(1) \implies T(n) = \Theta(n^3)$$
- **Strassen’s Matrix Multiplication Algorithm:** Reduces the computation to 7 recursive subproblems of half size:
  $$T(n) = 7T(n/2) + \Theta(n^2) \implies T(n) = \Theta(n^{\lg 7}) \approx O(n^{2.81})$$

### 2. Unequal Fractional Subproblems
Subproblems are divided into different fractional sizes:

- **Unequal Binary Partition:**
  $$T(n) = T(n/3) + T(2n/3) + \Theta(n) \implies T(n) = \Theta(n \lg n)$$
- **Asymmetric Subproblem Partition:**
  $$T(n) = T(n/5) + T(7n/10) + \Theta(n) \implies T(n) = \Theta(n)$$

### 3. Subtractive (Non-Fractional) Subproblems
A subproblem is reduced by a fixed constant size rather than a constant fraction:

- **Recursive Linear Search:** Decrements problem size by 1 per step:
  $$T(n) = T(n - 1) + \Theta(1) \implies T(n) = \Theta(n)$$

---

## Methods for Solving Recurrences

Four primary mathematical methods are used to determine asymptotic bounds ($\Theta, O, \Omega$) for recurrences:

| Method | Approach | Best Used For |
| :--- | :--- | :--- |
| **Substitution Method** | Guess the solution form and verify it using mathematical induction to solve for constants. | Robust verification of specific bounds; establishing inductive proofs once a guess is known. |
| **Recursion-Tree Method** | Model recursive calls as a tree, evaluate the sum of per-level costs, and aggregate all levels and leaves. | Visualizing cost distribution across recursive depth; generating informed guesses for substitution proofs. |
| **Master Method** | Apply a three-case theorem to recurrences of the form $T(n) = aT(n/b) + f(n)$ by comparing $f(n)$ to $n^{\log_b a}$. | Fast, `` `<cookbook>` `` asymptotic solutions for standard divide-and-conquer recurrences with equal-sized subproblems. |
| **Akra-Bazzi Method** | Apply a generalized integral-based calculus framework to solve complex divide-and-conquer recurrences. | Irregular recurrences with unequal fractional subproblems or non-polynomial driving functions. |
## 4.1 Multiplying Square Matrices

Let $A = (a_{ik})$ and $B = (b_{kj})$ be square $n \times n$ matrices. The matrix product $C = A \cdot B$ is an $n \times n$ matrix whose entries $c_{ij}$ for $i, j = 1, 2, \dots, n$ are defined by:

$$c_{ij} = \sum_{k=1}^n a_{ik} \cdot b_{kj}$$

**Breakdown:**
- $C$ : The resulting $n \times n$ product matrix with entries $c_{ij}$.
- $A$ : The left $n \times n$ factor matrix with entries $a_{ik}$ (row $i$, column $k$).
- $B$ : The right $n \times n$ factor matrix with entries $b_{kj}$ (row $k$, column $j$).
- $n$ : The matrix dimension (number of rows and columns).
- $\sum_{k=1}^n$ : The summation adding the $n$ pairwise products across row $i$ of $A$ and column $j$ of $B$.

Matrices are typically categorized based on non-zero entry density:
- **Dense Matrices:** Most of the $n^2$ entries are non-zero.
- **Sparse Matrices:** Most of the $n^2$ entries are zero, allowing compact specialized storage.

---

### Standard Iterative Matrix Multiplication

Computing the matrix $C$ requires evaluating $n^2$ individual entries, each comprising a sum of $n$ scalar multiplications. The iterative procedure computes $C = C + A \cdot B$ in place:

```text
MATRIX-MULTIPLY(A, B, C, n)
1  for i = 1 to n           // Compute entries in each of n rows
2      for j = 1 to n       // Compute n entries in row i
3          for k = 1 to n
4              c_ij = c_ij + a_ik * b_kj   // Accumulate pairwise products
```

>[!info] Running Time of Iterative Multiplication
>The procedure uses three nested loops, each executing exactly $n$ iterations:
>- The inner loop statement (line 4) runs in $\Theta(1)$ constant time.
>- Total loop operations: $n \times n \times n = n^3$.
>- Initializing $C$ to zero takes $\Theta(n^2)$ time, which is asymptotically dominated by the multiplication loops.
>
>The overall running time is **$\Theta(n^3)$**.

---

### A Simple Divide-and-Conquer Algorithm

Assuming $n$ is an exact power of 2, an $n \times n$ matrix multiplication can be structured recursively by partitioning $A$, $B$, and $C$ into four $(n/2) \times (n/2)$ submatrices:

$$A = \begin{bmatrix} A_{11} & A_{12} \\ A_{21} & A_{22} \end{bmatrix}, \quad B = \begin{bmatrix} B_{11} & B_{12} \\ B_{21} & B_{22} \end{bmatrix}, \quad C = \begin{bmatrix} C_{11} & C_{12} \\ C_{21} & C_{22} \end{bmatrix}$$

Multiplying the partitioned blocks yields:

$$\begin{bmatrix} C_{11} & C_{12} \\ C_{21} & C_{22} \end{bmatrix} = \begin{bmatrix} A_{11} & A_{12} \\ A_{21} & A_{22} \end{bmatrix} \begin{bmatrix} B_{11} & B_{12} \\ B_{21} & B_{22} \end{bmatrix} = \begin{bmatrix} A_{11}B_{11} + A_{12}B_{21} & A_{11}B_{12} + A_{12}B_{22} \\ A_{21}B_{11} + A_{22}B_{21} & A_{21}B_{12} + A_{22}B_{22} \end{bmatrix}$$

This produces four submatrix equations:

$$\begin{aligned} C_{11} &= A_{11}B_{11} + A_{12}B_{21} \\ C_{12} &= A_{11}B_{12} + A_{12}B_{22} \\ C_{21} &= A_{21}B_{11} + A_{22}B_{21} \\ C_{22} &= A_{21}B_{12} + A_{22}B_{22} \end{aligned}$$

Evaluating these four equations requires **eight multiplications** and **four additions** of $(n/2) \times (n/2)$ submatrices.

---

### Partitioning Implementation Strategies

Partitioning submatrices can be handled in two ways:

1. **Copying Elements (Explicit Submatrix Allocation):**
   - Allocate temporary memory for each $(n/2) \times (n/2)$ block and copy entries from $A$ and $B$.
   - After computing recursive products, copy results into $C$.
   - **Cost:** Requires copying $3n^2$ total entries, taking **$\Theta(n^2)$** time.

2. **Index Calculations (In-Place Referencing):**
   - Define submatrix boundaries using row and column index ranges (row/column start and end offsets) directly within the original matrix storage.
   - Operations and updates modify memory in place without data movement.
   - **Cost:** Updating boundary index metadata takes **$\Theta(1)$** time.

---

### Recursive Matrix Multiplication Algorithm

```text
MATRIX-MULTIPLY-RECURSIVE(A, B, C, n)
1  if n == 1
2      // Base case
3      c_11 = c_11 + a_11 * b_11
4      return
5  // Divide
6  partition A, B, and C into n/2 x n/2 submatrices:
       A_11, A_12, A_21, A_22;
       B_11, B_12, B_21, B_22;
       C_11, C_12, C_21, C_22
7  // Conquer
8  MATRIX-MULTIPLY-RECURSIVE(A_11, B_11, C_11, n/2)
9  MATRIX-MULTIPLY-RECURSIVE(A_11, B_12, C_12, n/2)
10 MATRIX-MULTIPLY-RECURSIVE(A_21, B_11, C_21, n/2)
11 MATRIX-MULTIPLY-RECURSIVE(A_21, B_12, C_22, n/2)
12 MATRIX-MULTIPLY-RECURSIVE(A_12, B_21, C_11, n/2)
13 MATRIX-MULTIPLY-RECURSIVE(A_12, B_22, C_12, n/2)
14 MATRIX-MULTIPLY-RECURSIVE(A_22, B_21, C_21, n/2)
15 MATRIX-MULTIPLY-RECURSIVE(A_22, B_22, C_22, n/2)
```

>[!summary] Running Time Analysis
>Let $T(n)$ be the worst-case running time of `MATRIX-MULTIPLY-RECURSIVE` on $n \times n$ matrices:
>
>- **Base Case ($n = 1$):** Performs 1 scalar multiplication and 1 addition: $T(1) = \Theta(1)$.
>- **Divide Step:** Submatrix indexing takes $\Theta(1)$ time.
>- **Conquer Step:** 8 recursive calls on subproblems of size $n/2$, contributing $8T(n/2)$ time.
>- **Combine Step:** Results are accumulated in place during the recursive calls ($\Theta(1)$ additional work).
>
>The overall recurrence is:
>
>$$T(n) = 8T(n/2) + \Theta(1)$$
>
>Applying the Master Theorem ($a = 8, b = 2, f(n) = \Theta(1)$):
>- Watershed function: $n^{\log_b a} = n^{\log_2 8} = n^3$.
>- Since $f(n) = O(n^{3 - \epsilon})$ for $\epsilon = 3$, Case 1 applies:
>
>$$T(n) = \Theta(n^3)$$

>[!note] Comparison with Merge Sort Recurrence
>Although the recursive matrix multiplication recurrence has a smaller non-recursive term ($\Theta(1)$) than merge sort's recurrence ($T(n) = 2T(n/2) + \Theta(n)$), its asymptotic running time ($\Theta(n^3)$) is significantly higher than merge sort's ($\Theta(n \lg n)$).
>
>The high branching factor ($a = 8$ versus $a = 2$) creates a much `` `<bushier>` `` recursion tree containing $8^{\log_2 n} = n^3$ base-case leaves, meaning the computational cost of the leaves completely dominates the running time.

## 4.2 Strassen’s Algorithm for Matrix Multiplication

Until 1969, it was widely assumed that multiplying two $n \times n$ matrices required $\Omega(n^3)$ operations due to the $n^3$ scalar multiplications in the standard definition. Volker Strassen introduced a recursive divide-and-conquer algorithm that broke this barrier, achieving a running time of:

$$T(n) = \Theta(n^{\lg 7}) \approx O(n^{2.81})$$

**Breakdown:**
- $\lg 7 = \log_2 7 \approx 2.807355$ : The critical exponent governing the recursion tree's leaf growth.
- $O(n^{2.81})$ : The asymptotic upper bound, which strictly outperforms the standard $\Theta(n^3)$ algorithm for large inputs.

---

### The Fundamental Trade-Off

Standard recursive matrix multiplication requires **8** submatrix multiplications and **4** submatrix additions, leading to an 8-way branching tree. 

Strassen’s algorithm reduces the number of recursive multiplications from **8 to 7** at the cost of performing **18** matrix additions and subtractions (10 to prepare intermediate terms, and 8 to combine the products). Because matrix addition takes $\Theta(n^2)$ time while multiplication grows much faster recursively, trading one multiplication for a constant number of additions yields an asymptotic speedup.

>[!abstract] Algebraic Analogy: Reducing Multiplications
>To compute $x^2 - y^2$ for two numbers $x$ and $y$:
>- **Standard Method:** Compute $x^2$ and $y^2$ (2 multiplications), then subtract ($1$ subtraction). Total = 2 multiplications, 1 subtraction.
>- **Factored Method:** Express as $(x + y)(x - y)$. Compute $x + y$ and $x - y$ (2 additions/subtractions), then multiply ($1$ multiplication). Total = 1 multiplication, 2 additions/subtractions.
>
>For large matrices where multiplication is far more computationally expensive than addition, minimizing multiplications yields significant performance benefits.

---

### The Four-Step Algorithm

Assuming $n$ is an exact power of 2, Strassen’s algorithm computes the matrix product $C = A \cdot B$ through four main stages:

1. **Divide:** If $n = 1$, perform a single scalar multiplication in $\Theta(1)$ time. Otherwise, partition $A$, $B$, and $C$ into $(n/2) \times (n/2)$ submatrices using index calculations ($\Theta(1)$ time).
2. **Create Intermediate Matrices ($S_1, \dots, S_{10}$):** Construct 10 addition/subtraction matrices of size $(n/2) \times (n/2)$ and allocate 7 product matrices $P_1, \dots, P_7$ ($\Theta(n^2)$ time).
3. **Conquer (Compute Products $P_1, \dots, P_7$):** Recursively compute 7 matrix products of size $(n/2) \times (n/2)$ using the submatrices and $S_i$ matrices ($7T(n/2)$ time).
4. **Combine (Update Result Submatrices):** Assemble the four blocks $C_{11}, C_{12}, C_{21}, C_{22}$ by adding and subtracting combinations of the $P_i$ matrices ($\Theta(n^2)$ time).

---

### Detailed Mathematical Formulations

#### Step 2: Intermediate Sums and Differences ($S_1$ to $S_{10}$)
Ten $(n/2) \times (n/2)$ matrices are computed using entrywise additions and subtractions:

$$\begin{aligned}
S_1 &= B_{12} - B_{22} & S_6 &= B_{11} + B_{22} \\
S_2 &= A_{11} + A_{12} & S_7 &= A_{12} - A_{22} \\
S_3 &= A_{21} + A_{22} & S_8 &= B_{21} + B_{22} \\
S_4 &= B_{21} - B_{11} & S_9 &= A_{11} - A_{21} \\
S_5 &= A_{11} + A_{22} & S_{10} &= B_{11} + B_{12}
\end{aligned}$$

#### Step 3: Seven Recursive Products ($P_1$ to $P_7$)
Seven recursive matrix multiplications are executed:

$$\begin{aligned}
P_1 &= A_{11} \cdot S_1 &&= A_{11}B_{12} - A_{11}B_{22} \\
P_2 &= S_2 \cdot B_{22} &&= A_{11}B_{22} + A_{12}B_{22} \\
P_3 &= S_3 \cdot B_{11} &&= A_{21}B_{11} + A_{22}B_{11} \\
P_4 &= A_{22} \cdot S_4 &&= A_{22}B_{21} - A_{22}B_{11} \\
P_5 &= S_5 \cdot S_6 &&= A_{11}B_{11} + A_{11}B_{22} + A_{22}B_{11} + A_{22}B_{22} \\
P_6 &= S_7 \cdot S_8 &&= A_{12}B_{21} + A_{12}B_{22} - A_{22}B_{21} - A_{22}B_{22} \\
P_7 &= S_9 \cdot S_{10} &&= A_{11}B_{11} + A_{11}B_{12} - A_{21}B_{11} - A_{21}B_{12}
\end{aligned}$$

#### Step 4: Constructing the Product Submatrices ($C_{ij}$)
The final four submatrices of $C$ are computed by combining the $P_i$ matrices, allowing intermediate cross-terms to cancel out:

>[!example] Algebraic Cancellations of Submatrix Results
>
>**1. Computing $C_{11} = A_{11}B_{11} + A_{12}B_{21}$:**
>$$C_{11} = P_5 + P_4 - P_2 + P_6$$
>$$\begin{aligned}
>&+ (A_{11}B_{11} + A_{11}B_{22} + A_{22}B_{11} + A_{22}B_{22}) \\
>&+ (A_{22}B_{21} - A_{22}B_{11}) \\
>&- (A_{11}B_{22} + A_{12}B_{22}) \\
>&+ (A_{12}B_{21} + A_{12}B_{22} - A_{22}B_{21} - A_{22}B_{22}) \\
>\hline
>&= A_{11}B_{11} + A_{12}B_{21}
>\end{aligned}$$
>
>**2. Computing $C_{12} = A_{11}B_{12} + A_{12}B_{22}$:**
>$$C_{12} = P_1 + P_2$$
>$$\begin{aligned}
>&+ (A_{11}B_{12} - A_{11}B_{22}) \\
>&+ (A_{11}B_{22} + A_{12}B_{22}) \\
>\hline
>&= A_{11}B_{12} + A_{12}B_{22}
>\end{aligned}$$
>
>**3. Computing $C_{21} = A_{21}B_{11} + A_{22}B_{21}$:**
>$$C_{21} = P_3 + P_4$$
>$$\begin{aligned}
>&+ (A_{21}B_{11} + A_{22}B_{11}) \\
>&+ (A_{22}B_{21} - A_{22}B_{11}) \\
>\hline
>&= A_{21}B_{11} + A_{22}B_{21}
>\end{aligned}$$
>
>**4. Computing $C_{22} = A_{21}B_{12} + A_{22}B_{22}$:**
>$$C_{22} = P_5 + P_1 - P_3 - P_7$$
>$$\begin{aligned}
>&+ (A_{11}B_{11} + A_{11}B_{22} + A_{22}B_{11} + A_{22}B_{22}) \\
>&+ (A_{11}B_{12} - A_{11}B_{22}) \\
>&- (A_{21}B_{11} + A_{22}B_{11}) \\
>&- (A_{11}B_{11} + A_{11}B_{12} - A_{21}B_{11} - A_{21}B_{12}) \\
>\hline
>&= A_{21}B_{12} + A_{22}B_{22}
>\end{aligned}$$

---

### Running Time Analysis

>[!summary] Running Time Recurrence of Strassen’s Algorithm
>The overall computational time satisfies the divide-and-conquer recurrence:
>
>$$T(n) = 7T(n/2) + \Theta(n^2)$$
>
>**Breakdown:**
>- $7$ : The number of recursive matrix products ($P_1, \dots, P_7$).
>- $n/2$ : The dimension of each recursive subproblem.
>- $\Theta(n^2)$ : The non-recursive overhead for matrix additions/subtractions across Steps 1, 2, and 4.
>
>**Master Theorem Evaluation:**
>- $a = 7, b = 2 \implies n^{\log_b a} = n^{\log_2 7} \approx n^{2.807}$.
>- Driving function: $f(n) = \Theta(n^2) = O(n^{\log_2 7 - \epsilon})$ for $\epsilon \approx 0.807$.
>- Because $f(n)$ is polynomially smaller than the watershed function $n^{\log_2 7}$, **Case 1 of the Master Theorem applies**:
>
>$$T(n) = \Theta(n^{\log_2 7}) = \Theta(n^{\lg 7}) = o(n^3)$$

By reducing the recursion tree's branching factor from 8 to 7, Strassen’s algorithm achieves sub-cubic asymptotic complexity, strictly outperforming standard iterative and naive recursive approaches.

## 4.3 The Substitution Method for Solving Recurrences

The **substitution method** is a general mathematical technique for solving divide-and-conquer recurrences. It comprises two steps:

1. **Guess the form of the solution** using symbolic constants.
2. **Use mathematical induction** to prove that the guessed solution is correct and solve for the specific constants.

The method gets its name from substituting the guessed bound into the recurrence function on smaller arguments (the inductive hypothesis). 

The substitution method can establish either an asymptotic upper bound ($O$) or an asymptotic lower bound ($\Omega$). In practice, proving upper and lower bounds separately is the standard strategy for establishing an asymptotically tight bound ($\Theta$).

---

### Demonstrating the Substitution Method

Consider the recurrence:

$$T(n) = 2T(\lfloor n/2 \rfloor) + \Theta(n)$$

**Breakdown:**
- $T(n)$ : The running-time function for an input of size $n$.
- $\lfloor n/2 \rfloor$ : The floor function, ensuring subproblem sizes remain integers.
- $\Theta(n)$ : The non-recursive overhead for dividing the problem and combining subproblem results.

>[!example] Upper-Bound Proof for $T(n) = 2T(\lfloor n/2 \rfloor) + \Theta(n)$
>
>**1. Formulate the Inductive Hypothesis:**
>Guess that $T(n) = O(n \lg n)$. Establish the inductive hypothesis using explicit constants $c > 0$ and $n_0 > 0$:
>
>$$T(n) \le cn \lg n \quad \text{for all } n \ge n_0$$
>
>**2. Inductive Step:**
>Assume the bound holds for all positive integers less than $n$ and at least $n_0$. For $n \ge 2n_0$, the subproblem size satisfies $\lfloor n/2 \rfloor \ge n_0$, allowing substitution:
>
>$$T(n) \le 2\left(c \lfloor n/2 \rfloor \lg(\lfloor n/2 \rfloor)\right) + \Theta(n)$$
>
>Using the inequality $\lfloor n/2 \rfloor \le n/2$:
>
>$$T(n) \le 2\left(c \frac{n}{2} \lg\left(\frac{n}{2}\right)\right) + \Theta(n)$$
>$$T(n) \le cn (\lg n - \lg 2) + \Theta(n)$$
>$$T(n) = cn \lg n - cn + \Theta(n)$$
>
>Because $\Theta(n)$ represents an anonymous function bounded above by $c' n$ for some constant $c' > 0$:
>
>$$cn \lg n - cn + \Theta(n) \le cn \lg n \quad \text{whenever } c \ge c'$$
>
>Choosing $c$ sufficiently large guarantees that $-cn$ dominates the positive overhead term hidden by $\Theta(n)$, yielding $T(n) \le cn \lg n$.
>
>**3. Base Cases:**
>The induction must hold for boundary values $n_0 \le n < 2n_0$. 
>- Choose $n_0 = 2$ so that $\lg n > 0$ (since $\lg 2 = 1$).
>- In algorithmic recurrences, running times for small base cases such as $T(2)$ and $T(3)$ are constants.
>- Setting $c = \max\{T(2), T(3)\}$ satisfies $T(2) \le c \le 2c \lg 2$ and $T(3) \le c \le 3c \lg 3$.
>
>With both the base cases and the inductive step verified for $n \ge 2$, the solution is $T(n) = O(n \lg n)$.

>[!note] Base Cases in Divide-and-Conquer Analyses
>In algorithmic analysis, detailed proofs for base cases are often omitted. Divide-and-conquer recurrences consistently bottom out on an interval of small inputs $[n_0, n_0']$ where the running time is bounded by a constant. Choosing a sufficiently large leading constant $c$ makes the inductive hypothesis hold across all base cases in that range.

---

### Heuristics for Generating Good Guesses

Because no algorithmic recipe exists to guess the exact solution for every arbitrary recurrence, several practical heuristics are used:

- **Analogy to Familiar Recurrences:** If a recurrence resembles a known form, try a similar bound. For example, in:
  $$T(n) = 2T(n/2 + 17) + \Theta(n)$$
  for large $n$, the constant $+17$ is negligible compared to $n/2$. Thus, guessing $T(n) = O(n \lg n)$ remains valid.
- **Shrinking the Range of Uncertainty:** Start with loose upper and lower bounds (such as a lower bound of $\Omega(n)$ and an upper bound of $O(n^2)$), then iteratively raise the lower bound and lower the upper bound until they converge on the tight bound $\Theta(n \lg n)$.
- **Recursion Trees:** Constructing a recursion tree helps visualize work distribution per level and generates an informed guess.

---

### Strengthening the Hypothesis: Subtracting a Lower-Order Term

When an inductive step fails by a lower-order term, the issue is often that the inductive assumption is too weak to absorb lower-order additions. Subtracting a lower-order term strengthens the hypothesis, providing the necessary negative terms during substitution.

>[!example] Strengthening an Inductive Hypothesis
>Consider the recurrence defined on real numbers:
>
>$$T(n) = 2T(n/2) + \Theta(1)$$
>
>**Attempt 1 (Fails):**
>Guess $T(n) \le cn$:
>$$T(n) \le 2\left(c \frac{n}{2}\right) + \Theta(1) = cn + \Theta(1)$$
>The remaining $+\Theta(1)$ term prevents proving that $T(n) \le cn$ for any constant $c$.
>
>**Attempt 2 (Strengthening the Hypothesis):**
>Subtract a lower-order constant $d \ge 0$, guessing $T(n) \le cn - d$:
>
>$$T(n) \le 2\left(c \frac{n}{2} - d\right) + \Theta(1)$$
>$$T(n) = cn - 2d + \Theta(1)$$
>$$T(n) = cn - d - (d - \Theta(1))$$
>
>Choosing $d$ large enough so that $d \ge \Theta(1)$ ensures $-(d - \Theta(1)) \le 0$, yielding:
>
>$$T(n) \le cn - d$$
>
>Choosing $c$ large enough to satisfy the base cases completes the proof that $T(n) = O(n)$.

>[!tip] Why Subtracting Lower-Order Terms Works
>When a recurrence has a branching factor greater than 1 (such as $2T(n/2)$), subtracting a term $d$ in the hypothesis causes it to be multiplied across subproblems (yielding $-2d$). The resulting extra $-d$ term directly cancels out the positive non-recursive overhead.

---

### Pitfalls to Avoid

>[!warning] Pitfall 1: Using Asymptotic Notation in Inductive Hypotheses
>Retaining asymptotic notation inside an inductive hypothesis is invalid because the hidden constants can shift between recursive levels.
>
>**Fallacious Argument:**
>$$T(n) \le 2 \cdot O(\lfloor n/2 \rfloor) + \Theta(n) = 2 \cdot O(n) + \Theta(n) = O(n) \quad \text{― WRONG!}$$
>
>Using explicit constants reveals the flaw:
>$$T(n) \le 2(c \lfloor n/2 \rfloor) + \Theta(n) \le cn + \Theta(n)$$
>Because $\Theta(n)$ is asymptotically positive, $cn + \Theta(n)$ cannot be bounded by $cn$ for the *same* constant $c$. Explicit constants must be maintained consistently throughout.

>[!warning] Pitfall 2: Confusing the End Goal with the Inductive Step
>An inductive proof requires deriving the exact mathematical expression stated in the hypothesis.
>
>If the hypothesis assumes $T(n) \le cn$, ending a derivation with:
>$$T(n) \le cn + \Theta(n) = O(n) \quad \text{― WRONG!}$$
>is invalid because it fails to recover the strict bound $T(n) \le cn$. The exact form assumed in the hypothesis must be proven.

