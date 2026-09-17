---
tags:
  - CCT3
  - Lin_Algebra
Topic: Lineære ligningssystemer , deres (in)konsistens og løsningsmetoder.
Semester: CCT3
Course: Linær Algebra
Litterature:
  - Linear Algebra and Its Applications, Global Edition, 6ed
Created: 14-09-2026
---
- - -
# Table of Contents

1. [[#Systems of Linear Equations|Systems of Linear Equations]]
	1. [[#Systems of Linear Equations#Matrix Notation|Matrix Notation]]
	2. [[#Systems of Linear Equations#Solving a Linear System|Solving a Linear System]]
		1. [[#Solving a Linear System#Geometric Meaning and Solution Verification|Geometric Meaning and Solution Verification]]
		2. [[#Solving a Linear System#Reversibility of Row Operations|Reversibility of Row Operations]]
	3. [[#Systems of Linear Equations#Existence and Uniqueness Questions|Existence and Uniqueness Questions]]
		1. [[#Existence and Uniqueness Questions#Reasonable Answers|Reasonable Answers]]
		2. [[#Existence and Uniqueness Questions#Numerical Notes|Numerical Notes]]
2. [[#Row Reduction and Echelon Forms|Row Reduction and Echelon Forms]]
	1. [[#Row Reduction and Echelon Forms#Uniqueness of the Reduced Echelon Form|Uniqueness of the Reduced Echelon Form]]
		1. [[#Uniqueness of the Reduced Echelon Form#Terminology and Computational Notation|Terminology and Computational Notation]]
	2. [[#Row Reduction and Echelon Forms#Pivot Positions|Pivot Positions]]
		1. [[#Pivot Positions#The Row Reduction Algorithm|The Row Reduction Algorithm]]
			1. [[#The Row Reduction Algorithm#The Five Steps of the Algorithm|The Five Steps of the Algorithm]]
	3. [[#Row Reduction and Echelon Forms#Solutions of Linear Systems|Solutions of Linear Systems]]
	4. [[#Row Reduction and Echelon Forms#Parametric Descriptions of Solution Sets|Parametric Descriptions of Solution Sets]]
	5. [[#Row Reduction and Echelon Forms#Back-Substitution|Back-Substitution]]
	6. [[#Row Reduction and Echelon Forms#Existence and Uniqueness Questions|Existence and Uniqueness Questions]]
	7. [[#Row Reduction and Echelon Forms#Reasonable Answers|Reasonable Answers]]

# Linear Equations in Linear Algebra
Due to the massive amounts of data involved in large-scale mathematical modeling, these models are typically _linear_—formulated and solved as systems of linear equations.

>[!info] **Interconnection with Computing Power**
>The practical importance of linear algebra grows in direct proportion to advances in computing power. Each improvement in hardware and software enables larger computations, creating an ongoing demand for greater capabilities. Consequently, computer science is deeply tied to linear algebra through the expansion of parallel processing and large-scale numerical computation.

The ability to compute these large-scale linear systems allows scientists and engineers to analyze problems of significantly greater complexity than was previously feasible, making linear algebra a foundational mathematical subject across diverse scientific, engineering, and business disciplines.
## Systems of Linear Equations

>[!summary] Definition: Linear Equation
>A **linear equation** in the variables $x_1, x_2, \dots, x_n$ is an equation that can be written in the form:
>$$a_1x_1 + a_2x_2 + \dots + a_nx_n = b$$
>
>**Breakdown**:
>- $x_1, x_2, \dots, x_n$ : The variables (or unknowns) of the equation.
>- $a_1, a_2, \dots, a_n$ : The _coefficients_ of the variables, which are real or complex numbers typically known in advance.
>- $b$ : The constant term, also a real or complex number typically known in advance.
>- $n$ : The number of variables, which may be any positive integer.

In standard introductory exercises, $n$ typically ranges between 2 and 5. 
In large-scale applied problems, $n$ can be 50, 5,000, or even larger.

>[!example] Identifying Linear and Non-Linear Equations
>**Linear Equations** (can be algebraically rearranged into standard form):
>- $4x_1 - 5x_2 + 2 = x_1 \implies 3x_1 - 5x_2 = -2$
>- $x_2 = 2(\sqrt{6} - x_1) + x_3 \implies 2x_1 + x_2 - x_3 = 2\sqrt{6}$
>
>**Non-Linear Equations** (cannot be expressed in standard linear form):
>- $4x_1 - 5x_2 = x_1x_2$ (contains a product of variables, $x_1x_2$)
>- $x_2 = 2\sqrt{x_1} - 6$ (contains a non-linear operation on a variable, $\sqrt{x_1}$)

An equation is linear if it can be rearranged algebraically into standard linear form ($a_1x_1 + a_2x_2 + \dots + a_nx_n = b$). The presence of products, roots, or other non-linear functions involving the variables means the equation is non-linear.

>[!example] Linear vs. Non-Linear Equations
>**Linear Equations:**
>- $4x_1 - 5x_2 + 2 = x_1$ 
>  - Rearranges to: $3x_1 - 5x_2 = -2$
>- $x_2 = 2(\sqrt{6} - x_1) + x_3$ 
>  - Rearranges to: $2x_1 + x_2 - x_3 = 2\sqrt{6}$
>
>Both equations are linear because all variables appear only to the first power and are not multiplied together or modified by non-linear functions (constants like $\sqrt{6}$ are allowed).
>
>**Non-Linear Equations:**
>- $4x_1 - 5x_2 = x_1x_2$ 
>  - Non-linear due to the cross-product term $x_1x_2$.
>- $x_2 = 2\sqrt{x_1} - 6$ 
>  - Non-linear due to the square root of a variable ($\sqrt{x_1}$).

>[!summary] Definition: System of Linear Equations and Solutions
>A **system of linear equations** (or a **linear system**) is a collection of one or more linear equations involving the same set of variables, $x_1, x_2, \dots, x_n$.
>
>A **solution** of the system is an ordered list of numbers $(s_1, s_2, \dots, s_n)$ that makes each equation in the system a true statement when substituted for $x_1, x_2, \dots, x_n$, respectively.
>
>- **Solution Set:** The set of all possible solutions to the linear system.
>- **Equivalent Systems:** Two linear systems are _equivalent_ if they share the exact same solution set; every solution of the first system satisfies the second, and vice versa.

>[!example] Verifying a Solution
>Consider the system of equations:
>$$\begin{aligned}
>2x_1 - x_2 + 1.5x_3 &= 8 \\
>x_1 - 4x_3 &= -7
>\end{aligned}$$
>
>The ordered triple $(5, 6.5, 3)$ is a solution because substituting $x_1 = 5$, $x_2 = 6.5$, and $x_3 = 3$ satisfies both equations simultaneously:
>- $2(5) - (6.5) + 1.5(3) = 10 - 6.5 + 4.5 = 8$
>- $5 - 4(3) = 5 - 12 = -7$

Finding the solution set of a system of two linear equations in two variables corresponds geometrically to determining the intersection of two straight lines in a two-dimensional coordinate plane, denoted $\ell_1$ and $\ell_2$. 

![[Pasted image 20260914185006.png]]
FIGURE 1 Exactly one solution

A coordinate pair $(x_1, x_2)$ satisfies both equations simultaneously if and only if the point $(x_1, x_2)$ lies on both lines at the same time.

>[!example] Intersection of Two Lines
>Consider the two-variable system:
>$$\begin{aligned}
>x_1 - 2x_2 &= -1 \\
>-x_1 + 3x_2 &= 3
>\end{aligned}$$
>
>Graphing these equations yields two lines that intersect at a single point. Testing the coordinate pair $(3, 2)$:
>- Line 1: $(3) - 2(2) = 3 - 4 = -1$
>- Line 2: $-(3) + 3(2) = -3 + 6 = 3$
>
>Because $(3, 2)$ satisfies both equations, it is the unique intersection point of the two lines and the sole solution to the system.

Two lines in a two-dimensional plane do not necessarily intersect at a single point. Geometrically, there are three distinct possibilities for how two lines can interact:

1. **A Single Intersection Point:** The lines cross at exactly one coordinate point, yielding a single unique solution.
2. **Parallel Lines:** The lines have the same slope and distinct intercepts, meaning they never intersect and share no common points (no solution).
3. **Coincident Lines:** The equations describe the exact same line, meaning they overlap completely and intersect at every single point along the line (infinitely many solutions).

>[!example] Geometric Possibilities of Two-Variable Systems
>**Case 1: Parallel Lines (No Solution)**
>$$\begin{aligned}
>x_1 - 2x_2 &= -1 \\
>-x_1 + 2x_2 &= 3
>\end{aligned}$$
>Adding these two equations together yields $0 = 2$, a mathematical impossibility (contradiction). Geometrically, these lines run parallel to one another and never intersect, so there is no point $(x_1, x_2)$ that satisfies both equations simultaneously.
>
>**Case 2: Coincident Lines (Infinitely Many Solutions)**
>$$\begin{aligned}
>x_1 - 2x_2 &= -1 \\
>-x_1 + 2x_2 &= 1
>\end{aligned}$$
>Multiplying the second equation by $-1$ yields $x_1 - 2x_2 = -1$, which is identical to the first equation. Geometrically, both equations represent the exact same line. Every point lying on this line is a solution, resulting in infinitely many solutions.
>
>![[Pasted image 20260914185119.png]]
>FIGURE 2 (a) No solution. (b) Infinitely many solutions.

>[!summary] Possible Solutions of a Linear System
>A system of linear equations has precisely one of three outcomes:
>1. **No solution**
>2. **Exactly one solution** (a unique solution)
>3. **Infinitely many solutions**

>[!info] Definition: Consistency of a Linear System
>- **Consistent:** A linear system is _consistent_ if it has either exactly one solution or infinitely many solutions (i.e., at least one solution exists).
>- **Inconsistent:** A linear system is _inconsistent_ if it has no solution at all.

### Matrix Notation

The essential information of a linear system can be recorded compactly in a rectangular array of numbers called a **matrix**.

>[!summary] Definition: Matrix and Matrix Size
>An **$m \times n$ matrix** (read "$m$ by $n$") is a rectangular array of numbers consisting of $m$ rows and $n$ columns, where $m$ and $n$ are positive integers. The number of rows is always listed first.
>
>- **Coefficient Matrix:** A matrix containing only the coefficients of each variable, aligned in columns corresponding to the variables.
>- **Augmented Matrix:** A matrix consisting of the coefficient matrix supplemented with an additional column containing the constant terms from the right-hand sides of the equations.

>[!example] Constructing Coefficient and Augmented Matrices
>Consider the linear system:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= 0 \\
>2x_2 - 8x_3 &= 8 \\
>5x_1 - 5x_3 &= 10
>\end{aligned}$$
>
>When a variable is absent from an equation, its coefficient is recorded as $0$ (for example, the second equation is $0x_1 + 2x_2 - 8x_3 = 8$, and the third is $5x_1 + 0x_2 - 5x_3 = 10$).
>
>- **Coefficient Matrix** ($3 \times 3$):
>  $$\begin{bmatrix}
>  1 & -2 & 1 \\
>  0 & 2 & -8 \\
>  5 & 0 & -5
>  \end{bmatrix}$$
>
>- **Augmented Matrix** ($3 \times 4$):
>  $$\begin{bmatrix}
>  1 & -2 & 1 & 0 \\
>  0 & 2 & -8 & 8 \\
>  5 & 0 & -5 & 10
>  \end{bmatrix}$$

### Solving a Linear System

The basic strategy for solving a linear system is to systematically transform the original system into an _equivalent system_ (one sharing the exact same solution set) that is simpler to solve.

The general elimination procedure works as follows:
1. Use the $x_1$ term in the first equation to eliminate the $x_1$ terms in all subsequent equations.
2. Use the $x_2$ term in the second equation to eliminate the $x_2$ terms in the remaining equations.
3. Continue this process for successive variables until arriving at a simple, triangular equivalent system where values can easily be determined.

>[!info] The Three Basic Operations
>To simplify a linear system without altering its solution set, three basic operations are used:
>1. **Replacement:** Replace one equation with the sum of itself and a multiple of another equation.
>2. **Interchange:** Swap the positions of two equations.
>3. **Scaling:** Multiply all terms in an equation by a non-zero constant.

>[!example] Step-by-Step System Elimination
>Consider the linear system and its corresponding augmented matrix:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= 0 \\
>2x_2 - 8x_3 &= 8 \\
>5x_1 - 5x_3 &= 10
>\end{aligned}
>\qquad
>\begin{bmatrix}
>1 & -2 & 1 & 0 \\
>0 & 2 & -8 & 8 \\
>5 & 0 & -5 & 10
>\end{bmatrix}$$
>
>**Step 1: Eliminate $x_1$ from the third equation**
>Add $-5$ times equation 1 to equation 3:
>$$\begin{aligned}
>-5 \cdot [\text{equation 1}]: &\quad -5x_1 + 10x_2 - 5x_3 = 0 \\
>+\quad [\text{equation 3}]: &\quad \phantom{-}5x_1 \phantom{+ 10x_2} - 5x_3 = 10 \\
>\hline
>[\text{new equation 3}]: &\quad \phantom{-0x_1 +} 10x_2 - 10x_3 = 10
>\end{aligned}$$
>
>Replacing equation 3 produces:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= 0 \\
>2x_2 - 8x_3 &= 8 \\
>10x_2 - 10x_3 &= 10
>\end{aligned}
>\qquad
>\begin{bmatrix}
>1 & -2 & 1 & 0 \\
>0 & 2 & -8 & 8 \\
>0 & 10 & -10 & 10
>\end{bmatrix}$$
>
>**Step 2: Scale equation 2**
>Multiply equation 2 by $\frac{1}{2}$ to obtain a coefficient of $1$ for $x_2$:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= 0 \\
>x_2 - 4x_3 &= 4 \\
>10x_2 - 10x_3 &= 10
>\end{aligned}
>\qquad
>\begin{bmatrix}
>1 & -2 & 1 & 0 \\
>0 & 1 & -4 & 4 \\
>0 & 10 & -10 & 10
>\end{bmatrix}$$
>
>**Step 3: Eliminate $x_2$ from the third equation**
>Add $-10$ times equation 2 to equation 3:
>$$\begin{aligned}
>-10 \cdot [\text{equation 2}]: &\quad -10x_2 + 40x_3 = -40 \\
>+\quad [\text{equation 3}]: &\quad \phantom{-}10x_2 - 10x_3 = 10 \\
>\hline
>[\text{new equation 3}]: &\quad \phantom{-00x_2 +} 30x_3 = -30
>\end{aligned}$$
>
>Replacing equation 3 produces:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= 0 \\
>x_2 - 4x_3 &= 4 \\
>30x_3 &= -30
>\end{aligned}
>\qquad
>\begin{bmatrix}
>1 & -2 & 1 & 0 \\
>0 & 1 & -4 & 4 \\
>0 & 0 & 30 & -30
>\end{bmatrix}$$
>
>**Step 4: Scale equation 3 to reach triangular form**
>Multiply equation 3 by $\frac{1}{30}$:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= 0 \\
>x_2 - 4x_3 &= 4 \\
>x_3 &= -1
>\end{aligned}
>\qquad
>\begin{bmatrix}
>1 & -2 & 1 & 0 \\
>0 & 1 & -4 & 4 \\
>0 & 0 & 1 & -1
>\end{bmatrix}$$
>
>**Step 5: Eliminate terms above $x_3$ (Upward Elimination)**
>- Add $4$ times equation 3 to equation 2:
>  $$4(-1) + 4 = 0 \implies x_2 = 0$$
>- Add $-1$ times equation 3 to equation 1:
>  $$-1(-1) + 0 = 1 \implies x_1 - 2x_2 = 1$$
>
>The system simplifies to:
>$$\begin{aligned}
>x_1 - 2x_2 &= 1 \\
>x_2 &= 0 \\
>x_3 &= -1
>\end{aligned}
>\qquad
>\begin{bmatrix}
>1 & -2 & 0 & 1 \\
>0 & 1 & 0 & 0 \\
>0 & 0 & 1 & -1
>\end{bmatrix}$$
>
>**Step 6: Eliminate terms above $x_2$**
>Add $2$ times equation 2 to equation 1:
>$$\begin{aligned}
>x_1 &= 1 \\
>x_2 &= 0 \\
>x_3 &= -1
>\end{aligned}
>\qquad
>\begin{bmatrix}
>1 & 0 & 0 & 1 \\
>0 & 1 & 0 & 0 \\
>0 & 0 & 1 & -1
>\end{bmatrix}$$
>
>The unique solution is $(1, 0, -1)$.

#### Geometric Meaning and Solution Verification

In three-dimensional space, each of the three original equations represents a flat two-dimensional plane. The solution $(1, 0, -1)$ represents the single unique point where all three planes intersect.

![[Pasted image 20260914190015.png]]
FIGURE 3

To verify that $(1, 0, -1)$ is correct, substitute $x_1 = 1$, $x_2 = 0$, and $x_3 = -1$ into the original equations:

$$\begin{aligned}
1(1) - 2(0) + 1(-1) &= 1 - 0 - 1 = 0 \\
2(0) - 8(-1) &= 0 + 8 = 8 \\
5(1) - 5(-1) &= 5 + 5 = 10
\end{aligned}$$

Because all three equations evaluate to true statements, $(1, 0, -1)$ is confirmed as the solution.

The three basic operations performed on linear equations correspond directly to operations performed on the rows of their augmented matrices.

>[!info] Elementary Row Operations
>1. **Replacement:** Replace one row by the sum of itself and a multiple of another row (commonly phrased as _"add to one row a multiple of another row"_).
>2. **Interchange:** Interchange two rows.
>3. **Scaling:** Multiply all entries in a row by a non-zero constant.

Row operations apply to any matrix, regardless of whether it originates as the augmented matrix of a linear system.

>[!summary] Definition: Row Equivalence
>Two matrices are **row equivalent** if there exists a finite sequence of elementary row operations that transforms one matrix into the other.

#### Reversibility of Row Operations

Every elementary row operation is completely reversible:
- **Interchange:** Interchanging the same two rows a second time restores them to their original positions.
- **Scaling:** If a row is multiplied by a non-zero constant $c$, multiplying that modified row by $\frac{1}{c}$ recovers the original entries.
- **Replacement:** If $c$ times row 1 is added to row 2 to produce a new row 2, adding $-c$ times row 1 to that new row 2 restores the original row 2.

>[!summary] Theorem: Row Equivalence and Solution Sets
>If the augmented matrices of two linear systems are row equivalent, then the two systems have the exact same solution set.
>
>**Breakdown**:
>- Row operations represent valid algebraic transformations that do not alter the truth value of any equation for a given set of solutions.
>- Because every elementary row operation is strictly reversible, any solution to the transformed system is necessarily a solution to the original system, and vice versa.

Row operations provide a systematic method to analyze a linear system. Beyond finding exact numeric solutions, elementary row operations can be used to analyze the structure of a system to determine whether solutions exist and whether the solution is unique, without needing to completely solve the entire system.

### Existence and Uniqueness Questions

Determining the nature of the solution set for any linear system reduces to answering two fundamental questions:

>[!question] Two Fundamental Questions About a Linear System
>1. **Existence:** Is the system _consistent_ (that is, does at least one solution exist)?
>2. **Uniqueness:** If a solution exists, is it the only one (that is, is the solution _unique_)?

Elementary row operations applied to the augmented matrix provide the primary computational tool for answering both questions.

>[!example] Example: Determining Consistency of a Unique System
>Determine whether the following linear system is consistent:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= 0 \\
>2x_2 - 8x_3 &= 8 \\
>5x_1 - 5x_3 &= 10
>\end{aligned}$$
>
>Row operations reduce this system to the triangular form:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= 0 \\
>x_2 - 4x_3 &= 4 \\
>x_3 &= -1
>\end{aligned}
>\qquad
>\begin{bmatrix}
>1 & -2 & 1 & 0 \\
>0 & 1 & -4 & 4 \\
>0 & 0 & 1 & -1
>\end{bmatrix}$$
>
>At this stage, the value of $x_3$ is explicitly known ($x_3 = -1$). Substituting $x_3$ into the second equation uniquely determines $x_2$, and substituting both into the first equation uniquely determines $x_1$. 
>
>Because a solution exists, the system is **consistent**. Furthermore, because each variable is uniquely determined, the solution is **unique**.

>[!example] Example: Determining Consistency of an Inconsistent System
>Determine whether the following linear system is consistent:
>$$\begin{aligned}
>x_2 - 4x_3 &= 8 \\
>2x_1 - 3x_2 + 2x_3 &= 1 \\
>4x_1 - 8x_2 + 12x_3 &= 1
>\end{aligned}$$
>
>**Step 1: Set up the augmented matrix**
>$$\begin{bmatrix}
>0 & 1 & -4 & 8 \\
>2 & -3 & 2 & 1 \\
>4 & -8 & 12 & 1
>\end{bmatrix}$$
>
>**Step 2: Interchange row 1 and row 2 to obtain a leading entry in column 1**
>$$\begin{bmatrix}
>2 & -3 & 2 & 1 \\
>0 & 1 & -4 & 8 \\
>4 & -8 & 12 & 1
>\end{bmatrix}$$
>
>**Step 3: Eliminate the $x_1$ term from row 3**
>Add $-2$ times row 1 to row 3:
>$$\begin{bmatrix}
>2 & -3 & 2 & 1 \\
>0 & 1 & -4 & 8 \\
>0 & -2 & 8 & -1
>\end{bmatrix}$$
>
>**Step 4: Eliminate the $x_2$ term from row 3**
>Add $2$ times row 2 to row 3:
>$$\begin{bmatrix}
>2 & -3 & 2 & 1 \\
>0 & 1 & -4 & 8 \\
>0 & 0 & 0 & 15
>\end{bmatrix}$$
>
>**Step 5: Interpret the resulting triangular system**
>$$\begin{aligned}
>2x_1 - 3x_2 + 2x_3 &= 1 \\
>x_2 - 4x_3 &= 8 \\
>0 &= 15
>\end{aligned}$$
>
>The bottom row represents the equation $0x_1 + 0x_2 + 0x_3 = 15$, which simplifies to $0 = 15$. Because $0 = 15$ is a mathematical contradiction that can never be true for any values of $x_1, x_2, x_3$, the system has no solution. Therefore, the system is **inconsistent**.

>[!warning] Characteristic of Inconsistency
>An augmented matrix in triangular form that contains a row with all zeros on the left side and a non-zero entry on the right side:
>$$\begin{bmatrix} 0 & 0 & \dots & 0 & b \end{bmatrix} \quad (\text{where } b \neq 0)$$
>indicates the equation $0 = b$, signifying that the system is **inconsistent** (has no solution).

#### Reasonable Answers

After computing a solution to a linear system, it is standard practice to check the result by substituting the computed values back into the original system of equations to ensure each equation is satisfied.

>[!example] Verifying a Solution
>Consider testing potential solutions for the system:
>$$\begin{aligned}
>x_1 - 2x_2 + x_3 &= -2 \\
>x_1 - 2x_3 &= -2 \\
>x_2 - x_3 &= 3
>\end{aligned}$$
>
>Testing an incorrect solution candidate $(2, 1, -1)$:
>- Equation 1: $2 - 2(1) + (-1) = -1 \neq -2$
>- Equation 2: $2 - 2(-1) = 4 \neq -2$
>- Equation 3: $1 - (-1) = 2 \neq 3$
>
>Because the values fail to satisfy the equations, an arithmetic error occurred in the solution process.
>
>Testing the corrected candidate $(2, 1, -2)$:
>- Equation 1: $2 - 2(1) + (-2) = -2$
>- Equation 2: $2 - 2(-2) = -2$ (satisfied)
>- Equation 3: $1 - (-2) = 3$
>
>All equations evaluate to true statements, confirming that $(2, 1, -2)$ is a valid solution.
#### Numerical Notes

In practical and industrial applications, systems of linear equations are typically solved computationally. For square coefficient matrices, numerical software almost universally implements variants of the row elimination algorithm, slightly modified to optimize numerical stability and precision.

>[!note] Floating-Point Arithmetic and Roundoff Error
>Computational linear algebra software typically represents real numbers in scientific decimal form using **floating-point arithmetic**:
>
>$$\pm .d_1 d_2 \dots d_p \times 10^r$$
>
>**Breakdown**:
>- $\pm$ : The sign of the number (positive or negative).
>- $.d_1 d_2 \dots d_p$ : The mantissa (significand), representing the precision digits stored by the computer. The number of digits $p$ typically ranges from $8$ to $16$.
>- $10$ : The decimal base.
>- $r$ : The integer exponent scaling the order of magnitude.
>
>Because computers store numbers with a finite number of digits ($p$), arithmetic operations are subject to truncation and rounding. **Roundoff error** occurs both during calculation steps and when entering numbers that cannot be represented exactly in finite decimal form (such as $1/3$).

## Row Reduction and Echelon Forms

The **row reduction algorithm** is a systematic method that refines the elimination process to analyze any system of linear equations. Applying the initial stages of this algorithm provides the means to answer the fundamental questions of existence and uniqueness.

The algorithm applies universally to any rectangular matrix, whether or not it represents an augmented matrix for a linear system.

>[!info] Definitions: Matrix Row and Column Terminology
>- **Nonzero Row or Column:** A row or column that contains at least one entry that is not zero.
>- **Leading Entry:** The leftmost nonzero entry in a nonzero row.

>[!summary] Definition: Echelon Form and Reduced Echelon Form
>A rectangular matrix is in **echelon form** (or **row echelon form**) if it satisfies the following three conditions:
>1. **Zero Rows at Bottom:** All nonzero rows are positioned above any rows consisting entirely of zeros.
>2. **Staircase Pattern of Leading Entries:** Each leading entry of a row is in a column strictly to the right of the leading entry of the row above it.
>3. **Zeros Below Leading Entries:** All entries in a column directly below a leading entry are zeros.
>
>A matrix is in **reduced echelon form** (or **reduced row echelon form**) if it is in echelon form and satisfies two additional conditions:
> 1. **Leading Entries are 1:** The leading entry in each nonzero row equals $1$.
> 2. **Leading 1 is Isolated in its Column:** Each leading $1$ is the only nonzero entry in its column (all other entries in that column, both above and below, are zero).

>[!note] Historical Context: Gaussian Elimination
>The row reduction algorithm is a variant of **Gaussian elimination**. A similar elimination method for solving linear systems was developed by Chinese mathematicians around 250 B.C. The technique remained unknown in Western mathematics until the nineteenth century, when German mathematician Carl Friedrich Gauss rediscovered it. German engineer Wilhelm Jordan later popularized the algorithm in an 1888 text on geodesy.

An **echelon matrix** (or **reduced echelon matrix**) is any matrix that is in echelon form (or reduced echelon form). 

The requirement that each successive leading entry is in a column strictly to the right of the leading entry above it creates a characteristic "steplike" (echelon) pattern that descends from left to right across the matrix. As a direct result of this pattern, all matrix entries directly below each leading entry are zero.

>[!example] Echelon Form vs. Reduced Echelon Form
>**Echelon Form:**
>$$\begin{bmatrix}
>2 & -3 & 2 & 1 \\
>0 & 1 & -4 & 8 \\
>0 & 0 & 0 & 5/2
>\end{bmatrix}$$
>This matrix is in echelon form because all leading entries step down and to the right, and entries below each leading entry are zero. It is not in *reduced* echelon form because the leading entry of the first row is $2$ (not $1$), and the column containing the leading entry for the second row has a nonzero entry above it ($-3$).
>
>**Reduced Echelon Form:**
>$$\begin{bmatrix}
>1 & 0 & 0 & 29 \\
>0 & 1 & 0 & 16 \\
>0 & 0 & 1 & 3
>\end{bmatrix}$$
>This matrix satisfies all five conditions: every leading entry is $1$, each leading $1$ is the unique nonzero entry in its entire column, and the leading entries step downwards and to the right.

>[!example] General Matrix Patterns: Echelon vs. Reduced Echelon Forms
>In the general matrix layouts below, $\blacksquare$ represents a nonzero leading entry, and $*$ represents an arbitrary entry (which may be zero or nonzero).
>
>**Echelon Form Matrices:**
>$$\begin{bmatrix}
>\blacksquare & * & * & * \\
>0 & \blacksquare & * & * \\
>0 & 0 & 0 & 0 \\
>0 & 0 & 0 & 0
>\end{bmatrix}, \qquad
>\begin{bmatrix}
>0 & \blacksquare & * & * & * & * & * & * & * & * \\
>0 & 0 & 0 & \blacksquare & * & * & * & * & * & * \\
>0 & 0 & 0 & 0 & \blacksquare & * & * & * & * & * \\
>0 & 0 & 0 & 0 & 0 & \blacksquare & * & * & * & * \\
>0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0
>\end{bmatrix}$$
>
>**Reduced Echelon Form Matrices:**
>Here, every leading entry is strictly $1$, and every column containing a leading $1$ contains zeros in all other positions above and below it:
>$$\begin{bmatrix}
>1 & 0 & * & * \\
>0 & 1 & * & * \\
>0 & 0 & 0 & 0 \\
>0 & 0 & 0 & 0
>\end{bmatrix}, \qquad
>\begin{bmatrix}
>0 & 1 & * & 0 & 0 & 0 & * & * & 0 & * \\
>0 & 0 & 0 & 1 & 0 & 0 & * & * & 0 & * \\
>0 & 0 & 0 & 0 & 1 & 0 & * & * & 0 & * \\
>0 & 0 & 0 & 0 & 0 & 1 & * & * & 0 & * \\
>0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 & *
>\end{bmatrix}$$

### Uniqueness of the Reduced Echelon Form

A given nonzero matrix can be row reduced into multiple distinct matrices in *echelon form* depending on the choice and sequence of row operations used. However, the *reduced echelon form* obtained from any matrix is completely unique.

>[!summary] Theorem: Uniqueness of the Reduced Echelon Form
>Each matrix is row equivalent to one and only one reduced echelon matrix.

>[!summary] Theorem 1: Uniqueness of the Reduced Echelon Form
>Each matrix is row equivalent to one and only one reduced echelon matrix.
>
>**Breakdown**:
>- While an initial matrix can be row reduced into multiple distinct matrices in *echelon form* depending on the sequence of elementary row operations chosen, the resulting *reduced echelon form* is completely unique for any given matrix.

#### Terminology and Computational Notation

- **Echelon Form ($U$):** If a matrix $A$ is row equivalent to an echelon matrix $U$, then $U$ is called an _echelon form_ (or _row echelon form_) of $A$.
- **Reduced Echelon Form:** If the resulting matrix $U$ is in reduced echelon form, $U$ is called the _reduced echelon form_ of $A$.

>[!info] Computational Abbreviations
>Matrix calculation software and graphing calculators typically use the following standard abbreviations:
>- **REF:** (Row) Echelon Form
>- **RREF:** Reduced (Row) Echelon Form

### Pivot Positions

When elementary row operations reduce a matrix to echelon form, the subsequent row operations used to reach reduced echelon form do not change the locations of the leading entries. Because the reduced echelon form is unique, the leading entries always occupy the exact same row and column positions in every echelon form derived from a given matrix. These locations correspond directly to the leading $1$s in the reduced echelon form.

>[!summary] Definition: Pivot Position and Pivot Column
>A **pivot position** in a matrix $A$ is a location in $A$ that corresponds to a leading $1$ in the reduced echelon form of $A$.
>
>A **pivot column** is a column of $A$ that contains a pivot position.

In generalized echelon representations, the leading nonzero entries indicate the matrix's pivot positions. Identifying pivot positions and pivot columns is essential for analyzing matrix properties, determining the consistency and uniqueness of linear systems, and characterizing vector relationships.

>[!example] Example: Row Reducing to Echelon Form and Locating Pivot Columns
>Consider row reducing the matrix $A$ to echelon form to locate its pivot positions and pivot columns:
>
>$$A = \begin{bmatrix}
>0 & 3 & -6 & 6 & 4 & -5 \\
>3 & -7 & 8 & -5 & 8 & 9 \\
>3 & -9 & 12 & -9 & 6 & 15
>\end{bmatrix}$$
>
>*(Using the $4 \times 5$ system representation:)*
>
>$$A = \begin{bmatrix}
>0 & 3 & -6 & 4 & 9 \\
>1 & -2 & -1 & 3 & 1 \\
>-2 & 3 & 0 & -3 & -1 \\
>1 & 4 & 5 & -9 & -7
>\end{bmatrix}$$
>
>**Step 1: Identify the leftmost nonzero column and place a pivot at the top**
>The leftmost nonzero column is column 1. Interchange row 1 and row 4 to place a nonzero entry (a pivot) in the top-left position:
>
>$$\begin{bmatrix}
>\mathbf{1} & 4 & 5 & -9 & -7 \\
>1 & -2 & -1 & 3 & 1 \\
>-2 & 3 & 0 & -3 & -1 \\
>0 & 3 & -6 & 4 & 9
>\end{bmatrix}$$
>![[Pasted image 20260914192449.png]]
>
>**Step 2: Create zeros below the pivot in column 1**
>Add $-1$ times row 1 to row 2, and add $2$ times row 1 to row 3:
>
>$$\begin{bmatrix}
>\mathbf{1} & 4 & 5 & -9 & -7 \\
>0 & \mathbf{-2} & 4 & -6 & -6 \\
>0 & 5 & -10 & 15 & 15 \\
>0 & 3 & -6 & 4 & 9
>\end{bmatrix}$$
>![[Pasted image 20260914192538.png]]
>
>**Step 3: Create zeros below the pivot in column 2**
>The next pivot position is row 2, column 2 (with pivot entry $-2$). Add $\frac{5}{2}$ times row 2 to row 3, and add $\frac{3}{2}$ times row 2 to row 4:
>
>$$\begin{bmatrix}
>\mathbf{1} & 4 & 5 & -9 & -7 \\
>0 & \mathbf{-2} & 4 & -6 & -6 \\
>0 & 0 & 0 & 0 & 0 \\
>0 & 0 & 0 & -5 & 0
>\end{bmatrix}$$
>![[Pasted image 20260914192616.png]]
>
>**Step 4: Shift zero rows down and align leading entries**
>Column 3 contains all zeros below the second row, so no pivot can be created in column 3 without disturbing the existing echelon structure. Moving to column 4, interchange row 3 and row 4 to place a nonzero entry in row 3, column 4:
>
>$$\begin{bmatrix}
>\mathbf{1} & 4 & 5 & -9 & -7 \\
>0 & \mathbf{-2} & 4 & -6 & -6 \\
>0 & 0 & 0 & \mathbf{-5} & 0 \\
>0 & 0 & 0 & 0 & 0
>\end{bmatrix}$$
>![[Pasted image 20260914192629.png]]
>
>The matrix is now in **echelon form**. 
>
>**Identifying Pivot Positions and Columns:**
>The leading entries (pivots) are located in **columns 1, 2, and 4**. Therefore, columns 1, 2, and 4 of the original matrix $A$ are the **pivot columns**.
>![[Pasted image 20260914192644.png]]

>[!info] Pivots vs. Original Matrix Entries
>A **pivot** is a nonzero numerical value in a pivot position that is actively used during row operations to create zeros in other entries of the same column. 
>
>The pivot values used during elimination (such as $1$, $-2$, and $-5$ in the example above) depend on the row operations performed and may differ from the numbers that originally occupied those pivot positions in matrix $A$.

#### The Row Reduction Algorithm

The **row reduction algorithm** transforms any matrix into echelon form (using the first four steps) and then into the unique reduced echelon form (using the fifth step).

>[!info] Algorithm Phases
>- **Forward Phase (Steps 1–4):** Systematically creates zeros below each pivot to produce an echelon form matrix.
>- **Backward Phase (Step 5):** Works from right to left, scaling pivots to $1$ and creating zeros above each pivot to produce the unique reduced echelon form.

##### The Five Steps of the Algorithm

1. **Step 1:** Locate the leftmost nonzero column. This is a pivot column, and the pivot position is located at the top of this column.
2. **Step 2:** Select a nonzero entry in the pivot column as the pivot. If necessary, interchange rows to move this entry into the pivot position.
3. **Step 3:** Use row replacement operations to create zeros in all positions directly below the pivot.
4. **Step 4:** Cover (ignore) the row containing the current pivot position and all rows above it. Apply Steps 1–3 to the remaining submatrix. Repeat this process until no nonzero rows remain to be modified.
5. **Step 5 (Backward Phase):** Beginning with the rightmost pivot and working upward and to the left:
   - Create zeros above each pivot using row replacement operations.
   - Scale each pivot row so that the pivot entry becomes $1$.

>[!example] Row Reducing to Echelon Form and Reduced Echelon Form
>Apply elementary row operations to row reduce the following matrix into echelon form and subsequently into reduced echelon form:
>
>$$\begin{bmatrix}
>0 & 3 & -6 & 6 & 4 & -5 \\
>3 & -7 & 8 & -5 & 8 & 9 \\
>3 & -9 & 12 & -9 & 6 & 15
>\end{bmatrix}$$
>![[Pasted image 20260914192821.png]]
>
>**Forward Phase**
>
>**Step 1 & 2: Identify pivot column and select a pivot**
>The leftmost nonzero column is column 1. Interchange row 1 and row 3 to place a nonzero entry in the top pivot position:
>$$\begin{bmatrix}
>\mathbf{3} & -9 & 12 & -9 & 6 & 15 \\
>3 & -7 & 8 & -5 & 8 & 9 \\
>0 & 3 & -6 & 6 & 4 & -5
>\end{bmatrix}$$
>![[Pasted image 20260914192833.png]]
>
>**Step 3: Create zeros below the pivot**
>Add $-1$ times row 1 to row 2:
>$$\begin{bmatrix}
>\mathbf{3} & -9 & 12 & -9 & 6 & 15 \\
>0 & \mathbf{2} & -4 & 4 & 2 & -6 \\
>0 & 3 & -6 & 6 & 4 & -5
>\end{bmatrix}$$
>![[Pasted image 20260914192841.png]]
>
>**Step 4: Repeat for the submatrix**
>Cover row 1. The next pivot column in the remaining submatrix is column 2 with pivot entry $2$ in row 2. 
>![[Pasted image 20260914192848.png]]
>
>Add $-\frac{3}{2}$ times row 2 to row 3:
>$$\begin{bmatrix}
>\mathbf{3} & -9 & 12 & -9 & 6 & 15 \\
>0 & \mathbf{2} & -4 & 4 & 2 & -6 \\
>0 & 0 & 0 & 0 & \mathbf{1} & 4
>\end{bmatrix}$$
>
>The matrix is now in **echelon form** (completing the forward phase).
>![[Pasted image 20260914192903.png]]
>
>---
>
>**Backward Phase**
>
>**Step 5: Clear entries above pivots and scale**
>- The rightmost pivot is $1$ in row 3, column 5. Create zeros above it:
>  - Add $-6$ times row 3 to row 1.
>  - Add $-2$ times row 3 to row 2.
>![[Pasted image 20260914192939.png]]
>
>$$\begin{bmatrix}
>3 & -9 & 12 & -9 & 0 & -9 \\
>0 & 2 & -4 & 4 & 0 & -14 \\
>0 & 0 & 0 & 0 & 1 & 4
>\end{bmatrix}$$
>![[Pasted image 20260914192959.png]]
>
>- Scale row 2 by multiplying by $\frac{1}{2}$:
>
>$$\begin{bmatrix}
>3 & -9 & 12 & -9 & 0 & -9 \\
>0 & \mathbf{1} & -2 & 2 & 0 & -7 \\
>0 & 0 & 0 & 0 & 1 & 4
>\end{bmatrix}$$
>![[Pasted image 20260914193012.png]]
>
>- Create a zero above the pivot in row 2, column 2 by adding $9$ times row 2 to row 1:
>
>$$\begin{bmatrix}
>3 & 0 & -6 & 9 & 0 & -72 \\
>0 & 1 & -2 & 2 & 0 & -7 \\
>0 & 0 & 0 & 0 & 1 & 4
>\end{bmatrix}$$
>![[Pasted image 20260914193023.png]]
>
>- Scale row 1 by multiplying by $\frac{1}{3}$:
>
>$$\begin{bmatrix}
>\mathbf{1} & 0 & -2 & 3 & 0 & -24 \\
>0 & \mathbf{1} & -2 & 2 & 0 & -7 \\
>0 & 0 & 0 & 0 & \mathbf{1} & 4
>\end{bmatrix}$$
>![[Pasted image 20260914193039.png]]
>
>The matrix is now in its unique **reduced echelon form**.

>[!note] Numerical Note: Partial Pivoting
>In computational software, computers select the entry in a pivot column with the largest absolute value to serve as the pivot. This technique, known as **partial pivoting**, minimizes roundoff errors during floating-point arithmetic.

### Solutions of Linear Systems

Applying the row reduction algorithm to the augmented matrix of a linear system leads directly to an explicit description of its solution set.

>[!info] Definitions: Basic and Free Variables
>- **Basic Variables:** Variables corresponding to pivot columns in the matrix.
>- **Free Variables:** Any variables corresponding to non-pivot columns (excluding the rightmost constants column).

Whenever a linear system is consistent, its solution set can be described explicitly by solving the reduced echelon equations for the basic variables in terms of any free variables. This is always possible because the reduced echelon form isolates each basic variable into exactly one equation.

>[!example] Finding the General Solution with Free Variables
>Consider a linear system with three variables whose augmented matrix has been reduced to reduced echelon form:
>
>$$\begin{bmatrix}
>1 & 0 & -5 & 1 \\
>0 & 1 & 1 & 4 \\
>0 & 0 & 0 & 0
>\end{bmatrix}$$
>
>Writing this matrix back in equation form yields:
>$$\begin{aligned}
>x_1 - 5x_3 &= 1 \\
>x_2 + x_3 &= 4 \\
>0 &= 0
>\end{aligned}$$
>
>1. **Classify the variables:** Columns 1 and 2 contain pivot positions, so $x_1$ and $x_2$ are **basic variables**. Column 3 does not contain a pivot position, so $x_3$ is a **free variable**.
>2. **Solve for basic variables:** Solve each equation for its leading basic variable in terms of the free variable $x_3$ (ignoring the equation $0 = 0$, which imposes no constraints):
>
>$$\begin{cases}
>x_1 = 1 + 5x_3 \\
>x_2 = 4 - x_3 \\
>x_3 \text{ is free}
>\end{cases}$$
>
>The designation "$x_3$ is free" means that $x_3$ can take any real number value. Every specific choice of $x_3$ produces a unique valid solution:
>- If $x_3 = 0$, the solution is $(1, 4, 0)$.
>- If $x_3 = 1$, the solution is $(6, 3, 1)$.
>
>All possible solutions in the system's solution set are determined by selecting a value for $x_3$.

>[!example] Finding the General Solution of a Linear System
>Find the general solution of the linear system whose augmented matrix has already been reduced to echelon form:
>
>$$\begin{bmatrix}
>1 & 6 & 2 & -5 & -2 & -4 \\
>0 & 0 & 2 & -8 & -1 & 3 \\
>0 & 0 & 0 & 0 & 1 & 7
>\end{bmatrix}$$
>
>**Step 1: Perform the backward phase to reach reduced echelon form**
>- Eliminate entries above the rightmost pivot in column 5 by adding $2$ times row 3 to row 1, and adding $1$ times row 3 to row 2:
>
>$$\sim \begin{bmatrix}
>1 & 6 & 2 & -5 & 0 & 10 \\
>0 & 0 & 2 & -8 & 0 & 10 \\
>0 & 0 & 0 & 0 & 1 & 7
>\end{bmatrix}$$
>
>- Scale row 2 by multiplying by $\frac{1}{2}$:
>
>$$\sim \begin{bmatrix}
>1 & 6 & 2 & -5 & 0 & 10 \\
>0 & 0 & 1 & -4 & 0 & 5 \\
>0 & 0 & 0 & 0 & 1 & 7
>\end{bmatrix}$$
>
>- Eliminate the entry above the pivot in column 3 by adding $-2$ times row 2 to row 1:
>
>$$\sim \begin{bmatrix}
>1 & 6 & 0 & 3 & 0 & 0 \\
>0 & 0 & 1 & -4 & 0 & 5 \\
>0 & 0 & 0 & 0 & 1 & 7
>\end{bmatrix}$$
>
>**Step 2: Convert back to equation notation**
>Because the augmented matrix has 6 columns, the system contains 5 variables ($x_1, x_2, x_3, x_4, x_5$):
>
>$$\begin{aligned}
>x_1 + 6x_2 + 3x4 &= 0 \\
>x_3 - 4x_4 &= 5 \\
>x_5 &= 7
>\end{aligned}$$
>
>**Step 3: Classify variables and state the general solution**
>- **Basic variables:** $x_1, x_3, x_5$ (correspond to pivot columns 1, 3, and 5).
>- **Free variables:** $x_2, x_4$ (correspond to non-pivot columns 2 and 4).
>
>Solving for each basic variable in terms of the free variables yields the **general solution**:
>
>$$\begin{cases}
>x_1 = -6x_2 - 3x_4 \\
>x_2 \text{ is free} \\
>x_3 = 5 + 4x_4 \\
>x_4 \text{ is free} \\
>x_5 = 7
>\end{cases}$$
>
>*(Note: The value of $x_5$ is fixed at $7$ and does not depend on any free variable).*

### Parametric Descriptions of Solution Sets

Descriptions of solution sets that express basic variables in terms of free variables are called **parametric descriptions**, where the free variables act as *parameters*. Solving a linear system amounts to finding a parametric description of its solution set or determining that the solution set is empty.

>[!info] Parametric Conventions and Consistency
>- **Standard Convention:** When a system has infinitely many solutions, multiple algebraic parameterizations are mathematically possible. However, the standard convention is to always choose the **free variables** as the parameters.
>- **Inconsistent Systems:** If a linear system is inconsistent, its solution set is empty ($\emptyset$). An inconsistent system possesses no parametric description, even if free variables appear during intermediate reduction steps.

---

### Back-Substitution

When an augmented matrix has been reduced to echelon form (but not reduced echelon form), the corresponding system can be solved using **back-substitution**. 

>[!example] Back-Substitution Procedure
>Consider a system whose augmented matrix is in echelon form:
>$$\begin{aligned}
>x_1 - 7x_2 + 2x_3 - 5x_4 + 8x_5 &= 10 \\
>x_2 - 3x_3 + 3x_4 + x_5 &= -5 \\
>x_4 - x_5 &= 4
>\end{aligned}$$
>
>In algebraic back-substitution:
>1. Solve the bottom equation for the basic variable $x_4$ in terms of $x_5$:
>   $$x_4 = 4 + x_5$$
>2. Substitute this expression for $x_4$ into the second equation and solve for $x_2$:
>   $$x_2 = -5 + 3x_3 - 3(4 + x_5) - x_5 = -17 + 3x_3 - 4x_5$$
>3. Substitute the expressions for both $x_2$ and $x_4$ into the first equation and solve for $x_1$.

While computational software typically implements back-substitution, carrying out the matrix backward phase directly to obtain the **reduced echelon form** requires the exact same total number of arithmetic operations and significantly reduces calculation errors during manual computation.

---

>[!note] Numerical Note: Computational Complexity and Flops
>The computational cost of row reduction algorithms is measured in **flops** (*floating-point operations*). A flop is defined as a single basic arithmetic operation ($+$, $-$, $\times$, or $/$) executed on two real floating-point numbers.
>
>For an $n \times (n+1)$ matrix:
>- **Forward Phase (Reduction to Echelon Form):**
>  $$\text{Flops} \approx \frac{2}{3}n^3 + \frac{1}{2}n^2 - \frac{7}{6}n \approx \frac{2}{3}n^3$$
>  **Breakdown:**
>  - $n$ : The number of equations (rows) and variables in the coefficient matrix.
>  - $\frac{2}{3}n^3$ : The dominant cubic term representing the operations needed to systematically eliminate entries beneath each successive pivot. For moderately large systems ($n \ge 30$), this term accounts for almost all computation time.
>- **Backward Phase (Reduction to Reduced Echelon Form):**
>  $$\text{Flops} \le n^2$$
>  **Breakdown:**
>  - $n^2$ : The quadratic upper bound on operations needed to scale pivot rows and eliminate entries above pivots.
>
>The forward phase requires substantially more computational effort than the backward phase as the size of the system scales.

### Existence and Uniqueness Questions

An echelon form of an augmented matrix provides the information needed to determine whether a linear system has solutions and whether the solution set is unique.

>[!example]+ Step-by-Step Row Reduction: Analyzing Existence and Uniqueness
>
> Determine the existence and uniqueness of the solutions to the following linear system:
>
> $$ \begin{aligned} 3x_2 - 6x_3 + 6x_4 + 4x_5 &= -5 \\ 3x_1 - 7x_2 + 8x_3 - 5x_4 + 8x_5 &= 9 \\ 3x_1 - 9x_2 + 12x_3 - 9x_4 + 6x_5 &= 15 \end{aligned} $$
>
> ---
>
> ### Phase 1: Set Up the Augmented Matrix
>
> First, we write the system as an augmented matrix. Align the coefficients of each variable $x_1, x_2, x_3, x_4, x_5$ in columns. Notice that the first equation has no $x_1$ term, so its entry in the first column is $0$:
>
> $$ \begin{bmatrix} 0 & 3 & -6 & 6 & 4 & -5 \\ 3 & -7 & 8 & -5 & 8 & 9 \\ 3 & -9 & 12 & -9 & 6 & 15 \end{bmatrix} $$
>
> ---
>
> ### Phase 2: Row Reduction to Echelon Form
>
> #### Step 1: Establish the First Pivot
> The leftmost nonzero column is column 1. The top entry is $0$, which cannot serve as a pivot. We must interchange row 1 with a lower row that has a nonzero entry in column 1.
>
> We interchange row 1 and row 3 ($R_1 \leftrightarrow R_3$):
>
> $$ \begin{bmatrix} \mathbf{3} & -9 & 12 & -9 & 6 & 15 \\ 3 & -7 & 8 & -5 & 8 & 9 \\ 0 & 3 & -6 & 6 & 4 & -5 \end{bmatrix} $$
>
> The leading entry $\mathbf{3}$ in row 1, column 1 is our first pivot.
>
> #### Step 2: Create Zeros Below the First Pivot
> We must eliminate the $3$ in row 2, column 1. To do this, we replace row 2 with the sum of itself and $-1$ times row 1 ($R_2 \leftarrow R_2 - R_1$):
>
> **In-between Calculation:**
> $$ \begin{aligned} \text{Row 2:} &\quad \phantom{-}\begin{bmatrix} 3 & -7 & 8 & -5 & 8 & 9 \end{bmatrix} \\ + \quad -1 \cdot \text{Row 1:} &\quad \begin{bmatrix} -3 & 9 & -12 & 9 & -6 & -15 \end{bmatrix} \\ \hline \text{New Row 2:} &\quad \phantom{-}\begin{bmatrix} 0 & 2 & -4 & 4 & 2 & -6 \end{bmatrix} \end{aligned} $$
>
> Updating the matrix yields:
>
> $$ \begin{bmatrix} \mathbf{3} & -9 & 12 & -9 & 6 & 15 \\ 0 & 2 & -4 & 4 & 2 & -6 \\ 0 & 3 & -6 & 6 & 4 & -5 \end{bmatrix} $$
>
> *(Note: Row 3 already has a $0$ in column 1, so no operation is needed there).*
>
> #### Step 3: Establish the Second Pivot
> Covering row 1, the leftmost nonzero column of the remaining submatrix is column 2. The top entry of this submatrix is the $2$ in row 2, column 2. This is our second pivot.
>
> #### Step 4: Create Zeros Below the Second Pivot
> We must eliminate the $3$ in row 3, column 2. To do this, we replace row 3 with the sum of itself and $-\frac{3}{2}$ times row 2 ($R_3 \leftarrow R_3 - \frac{3}{2}R_2$):
>
> **In-between Calculation:**
> $$ \begin{aligned} \text{Row 3:} &\quad \phantom{-}\begin{bmatrix} 0 & 3 & -6 & 6 & 4 & -5 \end{bmatrix} \\ + \quad -\frac{3}{2} \cdot \text{Row 2:} &\quad \begin{bmatrix} 0 & -3 & 6 & -6 & -3 & 9 \end{bmatrix} \\ \hline \text{New Row 3:} &\quad \phantom{-}\begin{bmatrix} 0 & 0 & 0 & 0 & 1 & 4 \end{bmatrix} \end{aligned} $$
>
> Updating the matrix yields:
>
> $$ \begin{bmatrix} \mathbf{3} & -9 & 12 & -9 & 6 & 15 \\ 0 & \mathbf{2} & -4 & 4 & 2 & -6 \\ 0 & 0 & 0 & 0 & \mathbf{1} & 4 \end{bmatrix} $$
>
> The matrix is now in **echelon form** because:
> 1. All nonzero rows are above any rows of all zeros.
> 2. Each leading entry of a row is in a column strictly to the right of the leading entry of the row above it.
> 3. All entries in a column below a leading entry are zeros.
>
> ---
>
> ### Phase 3: Existence and Uniqueness Analysis
>
> Using this echelon form, we can answer the two fundamental questions:
>
> 4. **Existence (Is the system consistent?):**
>    - We look at the echelon matrix to check for any row representing the contradiction $0 = b$ (where $b \neq 0$). This would appear as a row of the form $\begin{bmatrix} 0 & 0 & 0 & 0 & 0 & b \end{bmatrix}$ where the rightmost column is a pivot column.
>    - The final row is $\begin{bmatrix} 0 & 0 & 0 & 0 & 1 & 4 \end{bmatrix}$, which represents the consistent equation $x_5 = 4$.
>    - Since the rightmost column is not a pivot column, the system is **consistent** (at least one solution exists).
>
> 5. **Uniqueness (Is the solution unique?):**
>    - We identify the basic and free variables by looking at the pivot columns:
>      - **Pivot Columns:** Columns 1, 2, and 5 contain pivot positions. Thus, $x_1$, $x_2$, and $x_5$ are **basic variables**.
>      - **Non-Pivot Columns:** Columns 3 and 4 do not contain pivot positions. Thus, $x_3$ and $x_4$ are **free variables**.
>    - Because the system is consistent and contains free variables, we can assign arbitrary values to $x_3$ and $x_4$. Each distinct choice of values for these parameters produces a different, valid solution.
>    - Therefore, the system has **infinitely many solutions**.

When a system is in echelon form and contains no contradictory equation of the form $0 = b$ (with $b \neq 0$), every nonzero row contains a basic variable with a nonzero coefficient. If every column corresponding to a variable contains a pivot, there are no free variables and the solution is unique. If one or more variable columns lack a pivot, those variables are free, yielding infinitely many solutions.

>[!summary] Theorem 2: Existence and Uniqueness Theorem
>A linear system is **consistent** if and only if the rightmost column of the augmented matrix is not a pivot column—that is, if and only if an echelon form of the augmented matrix contains no row of the form:
>
>$$\begin{bmatrix} 0 & \dots & 0 & b \end{bmatrix} \quad \text{with } b \neq 0$$
>
>If a linear system is consistent, then the solution set contains either:
>1. **A unique solution**, when there are no free variables.
>2. **Infinitely many solutions**, when there is at least one free variable.
>
>**Breakdown**:
>- $\begin{bmatrix} 0 & \dots & 0 & b \end{bmatrix} \text{ where } b \neq 0$ : Represents the equation $0x_1 + 0x_2 + \dots + 0x_n = b$, which simplifies to $0 = b$. Since $b \neq 0$, this is an algebraic impossibility (contradiction), indicating the system has no solution.
>- **Free variables present** : If the system is consistent and at least one variable has no pivot in its column, that variable can take any arbitrary value, generating infinitely many distinct solutions.
>- **No free variables** : If every variable column contains a pivot, each variable is uniquely fixed, yielding exactly one solution.

---

>[!info] Procedure: Using Row Reduction to Solve a Linear System
>1. **Augmented Matrix:** Write the augmented matrix representing the linear system.
>2. **Forward Phase (Echelon Form):** Apply the row reduction algorithm to obtain an equivalent augmented matrix in echelon form. Determine whether the system is consistent:
>   - If a row of the form $\begin{bmatrix} 0 & \dots & 0 & b \end{bmatrix}$ with $b \neq 0$ appears, the system is inconsistent (no solution). **Stop**.
>   - Otherwise, proceed to Step 3.
>3. **Backward Phase (Reduced Echelon Form):** Continue row reduction to transform the matrix into its unique reduced echelon form.
>4. **Equation Formulation:** Translate the reduced echelon matrix back into a system of linear equations.
>5. **Parametric Solution:** Rewrite each nonzero equation so that each basic variable is expressed explicitly in terms of any free variables present in the system.

---

### Reasonable Answers

When a system has infinitely many solutions, the validity of the computed general solution can be verified by substituting the parametric expressions directly back into the original system of equations, treating the free variables as algebraic parameters.

>[!example] Checking a Parametric Solution
>Consider the augmented matrix:
>
>$$\begin{bmatrix}
>1 & -2 & -1 & 2 \\
>1 & -1 & 2 & 5 \\
>0 & 1 & 3 & 3
>\end{bmatrix}$$
>
>Row reducing this matrix yields the reduced echelon form:
>
>$$\begin{bmatrix}
>1 & 0 & 3 & 8 \\
>0 & 1 & 1 & 3 \\
>0 & 0 & 0 & 0
>\end{bmatrix}$$
>
>The resulting general solution is:
>
>$$\begin{cases}
>x_1 = 8 - 3x_3 \\
>x_2 = 3 - x_3 \\
>x_3 \text{ is free}
>\end{cases}$$
>
>To verify that this solution is correct, substitute the expressions for $x_1$ and $x_2$ directly into the original equations while retaining the parameter $x_3$:
>
>- **Equation 1:** 
>  $$(8 - 3x_3) - 2(3 - x_3) - (x_3) = 8 - 3x_3 - 6 + 2x_3 - x_3 = 2$$
>- **Equation 2:** 
>  $$(8 - 3x_3) - (3 - x_3) + 2(x_3) = 8 - 3x_3 - 3 + x_3 + 2x_3 = 5$$
>- **Equation 3:** 
>  $$(3 - x_3) + 3(x_3) = 3 - x_3 + 3x_3 = 3$$
>
>Each substitution simplifies to the exact right-hand side constant of the original equations for all values of $x_3$, confirming the solution set.

