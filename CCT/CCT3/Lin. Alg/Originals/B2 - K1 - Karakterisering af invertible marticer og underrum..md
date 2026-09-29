---
tags:
  - CCT3
  - Lin_Algebra
Topic: Karakterisering af invertible marticer og underrum.
Semester: CCT3
Course: Linær Algebra
Litterature:
  - Linear Algebra and Its Applications, Global Edition, 6ed
Created: 29-09-2026
---
- - -
## Table of Contents

1. [[#Key Implications and Properties|Key Implications and Properties]]
2. [[#Classification of Square Matrices|Classification of Square Matrices]]
3. [[#Invertible Linear Transformations|Invertible Linear Transformations]]
4. [[#Numerical Notes|Numerical Notes]]
5. [[#2.8 Subspaces of Rn|2.8 Subspaces of Rn]]
6. [[#2.8 Subspaces of Rn#Geometric Interpretations and Counterexamples|Geometric Interpretations and Counterexamples]]
7. [[#2.8 Subspaces of Rn#Special Extreme Subspaces|Special Extreme Subspaces]]
8. [[#2.8 Subspaces of Rn#Column Space and Null Space of a Matrix|Column Space and Null Space of a Matrix]]
9. [[#2.8 Subspaces of Rn#Implicit versus Explicit Descriptions of Subspaces|Implicit versus Explicit Descriptions of Subspaces]]
10. [[#2.8 Subspaces of Rn#Basis for a Subspace|Basis for a Subspace]]
11. [[#2.8 Subspaces of Rn#Finding a Basis for the Null Space ($\text{Nul } A$)|Finding a Basis for the Null Space ($\text{Nul } A$)]]
12. [[#2.8 Subspaces of Rn#Finding a Basis for the Column Space ($\text{Col } A$)|Finding a Basis for the Column Space ($\text{Col } A$)]]

## Characterizations of Invertible Matrices

For square matrices and systems of $n$ linear equations in $n$ unknowns, fundamental concepts such as matrix invertibility, linear independence, spanning, and solutions to linear systems are interconnected.

> [!summary] theorem : The Invertible Matrix Theorem
> Let $A$ be a square $n \times n$ matrix. Then the following statements are equivalent (for a given $A$, they are either all true or all false):
> 
> a. $A$ is an invertible matrix.  
> b. $A$ is row equivalent to the $n \times n$ identity matrix $I_n$.  
> c. $A$ has $n$ pivot positions.  
> d. The equation $A\mathbf{x} = \mathbf{0}$ has only the trivial solution.  
> e. The columns of $A$ form a linearly independent set.  
> f. The linear transformation $\mathbf{x} \mapsto A\mathbf{x}$ is one-to-one.  
> g. The equation $A\mathbf{x} = \mathbf{b}$ has at least one solution for each $\mathbf{b}$ in $\mathbb{R}^n$.  
> h. The columns of $A$ span $\mathbb{R}^n$.  
> i. The linear transformation $\mathbf{x} \mapsto A\mathbf{x}$ maps $\mathbb{R}^n$ onto $\mathbb{R}^n$.  
> j. There is an $n \times n$ matrix $C$ such that $CA = I$.  
> k. There is an $n \times n$ matrix $D$ such that $AD = I$.  
> l. $A^T$ is an invertible matrix.
> 
> **breakdown**:
> - $A$ : An $n \times n$ square coefficient matrix.
> - $I_n$ (or $I$) : The $n \times n$ identity matrix with ones along the main diagonal and zeros elsewhere.
> - $\mathbf{x}, \mathbf{b}$ : Vectors in $\mathbb{R}^n$.
> - $A^T$ : The transpose of matrix $A$, obtained by interchanging its rows and columns.
> - $C, D$ : Left and right inverse matrices for $A$, respectively.
> - $\mathbf{x} \mapsto A\mathbf{x}$ : The linear transformation defined by multiplying an input vector by $A$.
> - **Equivalence** : If any one of these statements is established as true for a square matrix $A$, all other statements are automatically true. If any one statement is false, all others are false.
> 
> **proof**:
> The logical equivalence is shown by establishing a circular chain of implications among core statements and linking the remaining statements to this chain:
> 
> 1. **Core Circular Chain:**
>    - $(a) \implies (j)$: If $A$ is invertible, its inverse $A^{-1}$ exists. Setting $C = A^{-1}$ yields $CA = A^{-1}A = I$.
>    - $(j) \implies (d)$: If $CA = I$ and $A\mathbf{x} = \mathbf{0}$, then multiplying both sides by $C$ gives $\mathbf{x} = I\mathbf{x} = C(A\mathbf{x}) = C\mathbf{0} = \mathbf{0}$, meaning only the trivial solution exists.
>    - $(d) \implies (c)$: If $A\mathbf{x} = \mathbf{0}$ has only the trivial solution, there are no free variables in the system, which requires a pivot position in every column (totaling $n$ pivots).
>    - $(c) \implies (b)$: An $n \times n$ matrix with $n$ pivots must have those pivots along the main diagonal, so its reduced echelon form is $I_n$.
>    - $(b) \implies (a)$: If $A$ is row equivalent to $I_n$, it can be reduced to $I_n$ by elementary row operations, proving $A$ is invertible.
> 
> 2. **Linking the Remaining Statements:**
>    - $(a) \implies (k)$: If $A$ is invertible, setting $D = A^{-1}$ satisfies $AD = I$.
>    - $(k) \implies (g)$: If $AD = I$, then for any $\mathbf{b} \in \mathbb{R}^n$, choosing $\mathbf{x} = D\mathbf{b}$ gives $A\mathbf{x} = A(D\mathbf{b}) = (AD)\mathbf{b} = I\mathbf{b} = \mathbf{b}$, guaranteeing at least one solution.
>    - $(g) \implies (a)$: If $A\mathbf{x} = \mathbf{b}$ has a solution for every $\mathbf{b}$, $A$ must have a pivot in every row ($n$ pivots), linking back to invertibility.
>    - $(g) \iff (h) \iff (i)$: For any matrix transformation, having a solution for every $\mathbf{b}$ is equivalent to the columns spanning $\mathbb{R}^n$, which is equivalent to mapping onto $\mathbb{R}^n$.
>    - $(d) \iff (e) \iff (f)$: Having only the trivial solution is equivalent to linear independence of the columns, which is equivalent to the transformation being one-to-one.
>    - $(a) \iff (l)$: A matrix $A$ is invertible if and only if its transpose $A^T$ is invertible, with $(A^T)^{-1} = (A^{-1})^T$.

### Key Implications and Properties

Because an invertible matrix has $n$ pivot positions and no free variables, statement (g) can be strengthened: the equation $A\mathbf{x} = \mathbf{b}$ has a ***unique*** solution for each $\mathbf{b}$ in $\mathbb{R}^n$.

For square matrices, establishing a one-sided inverse automatically guarantees a two-sided inverse:

> [!info] Two-Sided Invertibility of Square Products
> Let $A$ and $B$ be square $n \times n$ matrices. If $AB = I$, then both $A$ and $B$ are invertible, with:
> $$B = A^{-1} \quad \text{and} \quad A = B^{-1}$$

### Classification of Square Matrices

The Invertible Matrix Theorem divides all $n \times n$ matrices into two disjoint classes:
1. **Invertible (nonsingular) matrices:** Matrices that satisfy all equivalent conditions in the theorem.
2. **Noninvertible (singular) matrices:** Matrices that satisfy none of the conditions.

The negation of any statement describes a property of a singular matrix. For instance, an $n \times n$ singular matrix is not row equivalent to $I_n$, has fewer than $n$ pivot positions, and has linearly dependent columns.

> [!example] Determining Invertibility via Pivot Positions
> Use the Invertible Matrix Theorem to decide if $A$ is invertible:
> $$A = \begin{bmatrix} 1 & 0 & -2 \\ -3 & 1 & -2 \\ -5 & 1 & 9 \end{bmatrix}$$
> 
> **Solution:**  
> Row reduce $A$ to find its pivot positions:
> $$A \sim \begin{bmatrix} 1 & 0 & -2 \\ 0 & 1 & 4 \\ 0 & 1 & 1 \end{bmatrix} \sim \begin{bmatrix} 1 & 0 & -2 \\ 0 & 1 & 4 \\ 0 & 0 & 3 \end{bmatrix}$$
> 
> The matrix $A$ has three pivot positions (a pivot in every row and column). By statement (c) of the Invertible Matrix Theorem, $A$ is invertible.

> [!warning] Strict Restriction to Square Matrices
> The Invertible Matrix Theorem applies **strictly to square matrices** ($n \times n$). 
> 
> It cannot be used for rectangular matrices ($m \times n$ where $m \neq n$). For example, if the columns of a $4 \times 3$ matrix are linearly independent, this does not imply that $A\mathbf{x} = \mathbf{b}$ has a solution for every $\mathbf{b}$ in $\mathbb{R}^4$.
### Invertible Linear Transformations

Matrix multiplication corresponds to the composition of linear transformations. When a matrix $A$ is invertible, the relation $A^{-1}A\mathbf{x} = \mathbf{x}$ describes a transformation being undone: multiplying an input vector $\mathbf{x}$ by $A$ transforms it into $A\mathbf{x}$, and multiplying by $A^{-1}$ transforms $A\mathbf{x}$ back into $\mathbf{x}$.

A linear transformation $T: \mathbb{R}^n \to \mathbb{R}^n$ is said to be _invertible_ if there exists a function $S: \mathbb{R}^n \to \mathbb{R}^n$ such that:

$$S(T(\mathbf{x})) = \mathbf{x} \quad \text{for all } \mathbf{x} \text{ in } \mathbb{R}^n$$
$$T(S(\mathbf{x})) = \mathbf{x} \quad \text{for all } \mathbf{x} \text{ in } \mathbb{R}^n$$

If such a function $S$ exists, it is unique and is guaranteed to be a linear transformation. This unique function $S$ is called the ***inverse*** of $T$ and is denoted by $T^{-1}$.

> [!summary] theorem : Invertibility of Linear Transformations (Theorem 9)
> Let $T: \mathbb{R}^n \to \mathbb{R}^n$ be a linear transformation and let $A$ be the standard matrix for $T$. Then $T$ is invertible if and only if $A$ is an invertible matrix. In that case, the linear transformation $S$ given by $S(\mathbf{x}) = A^{-1}\mathbf{x}$ is the unique function satisfying $S(T(\mathbf{x})) = \mathbf{x}$ and $T(S(\mathbf{x})) = \mathbf{x}$ for all $\mathbf{x} \in \mathbb{R}^n$.
> 
> **breakdown**:
> - $T$ : A linear transformation mapping vectors from $\mathbb{R}^n$ to $\mathbb{R}^n$.
> - $A$ : The $n \times n$ standard matrix representing $T$, where $T(\mathbf{x}) = A\mathbf{x}$.
> - $S$ (or $T^{-1}$) : The inverse linear transformation mapping $\mathbb{R}^n$ back to $\mathbb{R}^n$.
> - $A^{-1}$ : The matrix inverse of $A$.
> - $\mathbf{x}$ : An arbitrary vector in $\mathbb{R}^n$.
> 
> **proof**:
> 1. **Forward direction ($T$ is invertible $\implies A$ is invertible):**  
>    Suppose $T$ is invertible. Then $T(S(\mathbf{x})) = \mathbf{x}$ implies that $T$ maps $\mathbb{R}^n$ onto $\mathbb{R}^n$, because for any $\mathbf{b} \in \mathbb{R}^n$, setting $\mathbf{x} = S(\mathbf{b})$ yields $T(\mathbf{x}) = T(S(\mathbf{b})) = \mathbf{b}$. Since $T$ is onto, its standard matrix $A$ is invertible by the Invertible Matrix Theorem.
> 
> 2. **Reverse direction ($A$ is invertible $\implies T$ is invertible):**  
>    Suppose $A$ is invertible, and define $S(\mathbf{x}) = A^{-1}\mathbf{x}$. Because matrix multiplication is a linear operation, $S$ is a linear transformation. Verifying the composition equations:
>    $$S(T(\mathbf{x})) = S(A\mathbf{x}) = A^{-1}(A\mathbf{x}) = (A^{-1}A)\mathbf{x} = I\mathbf{x} = \mathbf{x}$$
>    $$T(S(\mathbf{x})) = T(A^{-1}\mathbf{x}) = A(A^{-1}\mathbf{x}) = (AA^{-1})\mathbf{x} = I\mathbf{x} = \mathbf{x}$$
>    Thus, $T$ is invertible and $S = T^{-1}$.

> [!example] One-to-One Transformations on $\mathbb{R}^n$
> **Problem:** What can be deduced about a one-to-one linear transformation $T: \mathbb{R}^n \to \mathbb{R}^n$?
> 
> **Solution:**  
> If $T$ is one-to-one, the columns of its standard matrix $A$ are linearly independent. Because $A$ is a square $n \times n$ matrix, the Invertible Matrix Theorem establishes that:
> 1. $A$ is invertible.
> 2. $T$ maps $\mathbb{R}^n$ onto $\mathbb{R}^n$.
> 3. $T$ is an invertible linear transformation with $T^{-1}(\mathbf{x}) = A^{-1}\mathbf{x}$.

### Numerical Notes

In practical computation, an invertible matrix may be _nearly singular_ or ***ill-conditioned***, meaning that slight perturbations in its entries can make it singular. 

Due to roundoff error during computer arithmetic:
- Row reduction on an ill-conditioned matrix may fail to identify all $n$ pivot positions, incorrectly making an invertible matrix appear singular.
- Roundoff errors can introduce tiny nonzero values where zeros should be, making a singular matrix appear invertible.

> [!note] Matrix Condition Number
> Computational software measures the numerical stability of a square matrix using a **condition number**:
> - **Identity Matrix:** Has a condition number of $1$ (the optimal baseline).
> - **Ill-Conditioned Matrix:** Has a large condition number, signaling high sensitivity to roundoff errors and severe precision loss during computations.
> - **Singular Matrix:** Has an infinite condition number.
> 
> When the condition number is extremely large, computational software may not be able to reliably distinguish between a singular matrix and an ill-conditioned matrix.
## 2.8 Subspaces of Rn

Subspaces are specialized sets of vectors in $\mathbb{R}^n$ that are closed under the fundamental algebraic operations of vector space arithmetic. They frequently arise when analyzing coefficient matrices and solutions to linear systems of the form $A\mathbf{x} = \mathbf{b}$.

> [!summary] definition : Subspace of $\mathbb{R}^n$
> A **subspace** of $\mathbb{R}^n$ is any subset $H$ in $\mathbb{R}^n$ that satisfies three core properties:
> 1. The zero vector $\mathbf{0}$ is in $H$.
> 2. For each $\mathbf{u}$ and $\mathbf{v}$ in $H$, the sum $\mathbf{u} + \mathbf{v}$ is in $H$ (_closed under addition_).
> 3. For each $\mathbf{u}$ in $H$ and each scalar $c$, the vector $c\mathbf{u}$ is in $H$ (_closed under scalar multiplication_).
> 
> **breakdown**:
> - $H$ : A subset of vectors residing in $\mathbb{R}^n$.
> - $\mathbb{R}^n$ : The $n$-dimensional Euclidean space consisting of all $n$-tuples of real numbers.
> - $\mathbf{0}$ : The zero vector in $\mathbb{R}^n$ whose entries are all zero.
> - $\mathbf{u}, \mathbf{v}$ : Arbitrary vectors belonging to $H$.
> - $c$ : An arbitrary real scalar.
> - **Closure Property** : Applying vector addition or scalar multiplication to any element(s) of $H$ always yields a vector that remains inside $H$.

Geometrically, a subspace must always pass through the origin due to the zero-vector requirement. For example, a line or a plane in $\mathbb{R}^3$ represents a subspace if and only if it passes through the origin.

> [!example] Spans as Subspaces
> Let $\mathbf{v}_1, \mathbf{v}_2, \dots, \mathbf{v}_p$ be vectors in $\mathbb{R}^n$, and let $H = \text{Span}\{\mathbf{v}_1, \mathbf{v}_2, \dots, \mathbf{v}_p\}$. The set $H$ is a subspace of $\mathbb{R}^n$:
> 
> 1. **Zero Vector:**  
>    $$\mathbf{0} = 0\mathbf{v}_1 + 0\mathbf{v}_2 + \dots + 0\mathbf{v}_p$$
>    Since $\mathbf{0}$ can be expressed as a linear combination of the vectors, $\mathbf{0} \in H$.
> 
> 2. **Closure Under Addition:**  
>    Let $\mathbf{u} = s_1\mathbf{v}_1 + \dots + s_p\mathbf{v}_p$ and $\mathbf{v} = t_1\mathbf{v}_1 + \dots + t_p\mathbf{v}_p$ be any two vectors in $H$. Then:
>    $$\mathbf{u} + \mathbf{v} = (s_1 + t_1)\mathbf{v}_1 + \dots + (s_p + t_p)\mathbf{v}_p$$
>    Since $\mathbf{u} + \mathbf{v}$ is a linear combination of the spanning set, $\mathbf{u} + \mathbf{v} \in H$.
> 
> 3. **Closure Under Scalar Multiplication:**  
>    For any scalar $c$:
>    $$c\mathbf{u} = c(s_1\mathbf{v}_1 + \dots + s_p\mathbf{v}_p) = (cs_1)\mathbf{v}_1 + \dots + (cs_p)\mathbf{v}_p$$
>    Since $c\mathbf{u}$ is a linear combination of the spanning set, $c\mathbf{u} \in H$.
> 
> The set $\text{Span}\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ is termed the ***subspace spanned (or generated) by*** $\mathbf{v}_1, \dots, \mathbf{v}_p$.

### Geometric Interpretations and Counterexamples

- **Lines Through the Origin:** If $\mathbf{v}_1 \neq \mathbf{0}$ and $\mathbf{v}_2 = k\mathbf{v}_1$ for some scalar $k$, then $\text{Span}\{\mathbf{v}_1, \mathbf{v}_2\}$ is simply a straight line through the origin, which forms a 1-dimensional subspace.
- **Planes Through the Origin:** If $\mathbf{v}_1$ and $\mathbf{v}_2$ are non-collinear vectors, $\text{Span}\{\mathbf{v}_1, \mathbf{v}_2\}$ is a plane passing through the origin.

> [!example] Non-Subspace: Lines Not Containing the Origin
> A line $L$ that does not pass through the origin cannot be a subspace because it violates all three defining criteria:
> - It does not contain the zero vector ($\mathbf{0} \notin L$).
> - Adding two vectors $\mathbf{u}, \mathbf{v}$ whose tips lie on $L$ produces a resultant vector $\mathbf{u} + \mathbf{v}$ that points away from $L$.
> - Multiplying a vector $\mathbf{w}$ on $L$ by a scalar (such as $2$ or $0$) yields a vector ($2\mathbf{w}$ or $\mathbf{0}$) that does not lie on $L$.

### Special Extreme Subspaces

Every space $\mathbb{R}^n$ contains two boundary cases of subspaces:
1. **The Full Space ($\mathbb{R}^n$):** $\mathbb{R}^n$ is a subspace of itself, as it trivially contains $\mathbf{0}$ and is closed under all standard vector addition and scalar multiplication.
2. **The Zero Subspace ($\{\mathbf{0}\}$):** The set containing only the zero vector in $\mathbb{R}^n$ satisfies all three conditions ($\mathbf{0} + \mathbf{0} = \mathbf{0}$ and $c\mathbf{0} = \mathbf{0}$).
### Column Space and Null Space of a Matrix

Subspaces in linear algebra commonly arise from matrices in two primary ways: as the set of all linear combinations of the columns of a matrix, or as the set of all solutions to a homogeneous linear system.

> [!summary] definition : Column Space
> The **column space** of an $m \times n$ matrix $A$, denoted by $\text{Col } A$, is the set of all linear combinations of the columns of $A$. If $A = \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n \end{bmatrix}$, then:
> $$\text{Col } A = \text{Span}\{\mathbf{a}_1, \mathbf{a}_2, \dots, \mathbf{a}_n\}$$
> 
> **breakdown**:
> - $A$ : An $m \times n$ matrix with entries in $\mathbb{R}$.
> - $\mathbf{a}_1, \dots, \mathbf{a}_n$ : The $n$ column vectors of $A$, each residing in $\mathbb{R}^m$.
> - $\text{Col } A$ : The resulting subspace of $\mathbb{R}^m$.
> - $\text{Span}\{\dots\}$ : The set of all linear combinations of the column vectors.

Because each column of an $m \times n$ matrix $A$ has $m$ entries, $\text{Col } A$ is a subspace of $\mathbb{R}^m$. The column space $\text{Col } A$ equals all of $\mathbb{R}^m$ if and only if the columns of $A$ span $\mathbb{R}^m$; otherwise, it is a proper subspace of $\mathbb{R}^m$. 

In the context of the linear system $A\mathbf{x} = \mathbf{b}$, the column space $\text{Col } A$ is precisely the set of all target vectors $\mathbf{b}$ for which the system has at least one solution.

> [!example] Determining if a Vector is in the Column Space
> Let $A = \begin{bmatrix} 1 & -3 & -4 \\ -4 & 6 & -2 \\ -3 & 7 & 6 \end{bmatrix}$ and $\mathbf{b} = \begin{bmatrix} 3 \\ 3 \\ -4 \end{bmatrix}$. Determine whether $\mathbf{b}$ is in $\text{Col } A$.
> 
> **Solution:**  
> The vector $\mathbf{b}$ is in $\text{Col } A$ if and only if it can be expressed as a linear combination of the columns of $A$, which is equivalent to the matrix equation $A\mathbf{x} = \mathbf{b}$ having a solution.
> 
> Row reduce the augmented matrix $\begin{bmatrix} A & \mathbf{b} \end{bmatrix}$:
> $$\begin{bmatrix} 1 & -3 & -4 & 3 \\ -4 & 6 & -2 & 3 \\ -3 & 7 & 6 & -4 \end{bmatrix} \sim \begin{bmatrix} 1 & -3 & -4 & 3 \\ 0 & -6 & -18 & 15 \\ 0 & -2 & -6 & 5 \end{bmatrix} \sim \begin{bmatrix} 1 & -3 & -4 & 3 \\ 0 & -6 & -18 & 15 \\ 0 & 0 & 0 & 0 \end{bmatrix}$$
> 
> The system is consistent (it contains no row of the form $\begin{bmatrix} 0 & 0 & 0 & c \end{bmatrix}$ with $c \neq 0$). Therefore, $A\mathbf{x} = \mathbf{b}$ has a solution, confirming that $\mathbf{b} \in \text{Col } A$.

> [!summary] definition : Null Space
> The **null space** of an $m \times n$ matrix $A$, denoted by $\text{Nul } A$, is the set of all solutions to the homogeneous equation $A\mathbf{x} = \mathbf{0}$:
> $$\text{Nul } A = \{\mathbf{x} \in \mathbb{R}^n \mid A\mathbf{x} = \mathbf{0}\}$$
> 
> **breakdown**:
> - $A$ : An $m \times n$ coefficient matrix.
> - $\mathbf{x}$ : A solution vector in $\mathbb{R}^n$.
> - $\mathbf{0}$ : The zero vector in $\mathbb{R}^m$.
> - $\text{Nul } A$ : The solution set, forming a subset of $\mathbb{R}^n$.

> [!summary] theorem : Null Space as a Subspace (Theorem 12)
> The null space of an $m \times n$ matrix $A$ is a subspace of $\mathbb{R}^n$. Equivalently, the set of all solutions to a system $A\mathbf{x} = \mathbf{0}$ of $m$ homogeneous linear equations in $n$ unknowns is a subspace of $\mathbb{R}^n$.
> 
> **breakdown**:
> - $A$ : An $m \times n$ matrix.
> - $m$ : The number of equations (and rows).
> - $n$ : The number of unknowns/variables (and columns).
> - $\text{Nul } A$ : The subspace in $\mathbb{R}^n$ comprising all solution vectors $\mathbf{x}$.
> 
> **proof**:
> 1. **Zero Vector:** The zero vector $\mathbf{0} \in \mathbb{R}^n$ satisfies $A\mathbf{0} = \mathbf{0}$, so $\mathbf{0} \in \text{Nul } A$.
> 2. **Closure Under Addition:** Let $\mathbf{u}$ and $\mathbf{v}$ be any two vectors in $\text{Nul } A$ (so $A\mathbf{u} = \mathbf{0}$ and $A\mathbf{v} = \mathbf{0}$). Using the distributive property of matrix multiplication:
>    $$A(\mathbf{u} + \mathbf{v}) = A\mathbf{u} + A\mathbf{v} = \mathbf{0} + \mathbf{0} = \mathbf{0}$$
>    Therefore, $\mathbf{u} + \mathbf{v} \in \text{Nul } A$.
> 3. **Closure Under Scalar Multiplication:** For any vector $\mathbf{u} \in \text{Nul } A$ and any scalar $c$:
>    $$A(c\mathbf{u}) = c(A\mathbf{u}) = c(\mathbf{0}) = \mathbf{0}$$
>    Therefore, $c\mathbf{u} \in \text{Nul } A$.
> 
> Since all three properties are satisfied, $\text{Nul } A$ is a subspace of $\mathbb{R}^n$.

### Implicit versus Explicit Descriptions of Subspaces

- **Null Space ($\text{Nul } A$):** Defined ***implicitly*** via a condition that must be verified. To test if an individual vector $\mathbf{v}$ is in $\text{Nul } A$, simply evaluate the product $A\mathbf{v}$ to see whether it equals $\mathbf{0}$. To obtain an explicit parametric description, solve the homogeneous system $A\mathbf{x} = \mathbf{0}$ and express the solution in parametric vector form.
- **Column Space ($\text{Col } A$):** Defined ***explicitly*** via a generating rule. Vectors in $\text{Col } A$ are constructed directly by taking linear combinations of the column vectors of $A$. To determine whether an arbitrary vector belongs to $\text{Col } A$, solve the linear system $A\mathbf{x} = \mathbf{b}$ to verify consistency.
### Basis for a Subspace

Because a subspace typically contains an infinite number of vectors, working with a subspace is best accomplished by using a small, finite generating set. The smallest possible spanning set of a subspace is one that contains no redundant vectors—meaning it must be linearly independent.

> [!summary] definition : Basis for a Subspace
> A **basis** for a subspace $H$ of $\mathbb{R}^n$ is a linearly independent set of vectors in $H$ that spans $H$.
> 
> **breakdown**:
> - $H$ : A subspace of $\mathbb{R}^n$.
> - $\mathcal{B} = \{\mathbf{b}_1, \mathbf{b}_2, \dots, \mathbf{b}_p\}$ : An ordered set of vectors in $H$.
> - **Linearly Independent** : $c_1\mathbf{b}_1 + c_2\mathbf{b}_2 + \dots + c_p\mathbf{b}_p = \mathbf{0}$ holds only when all scalars $c_1 = c_2 = \dots = c_p = 0$.
> - **Spanning Set** : Every vector in $H$ can be written as a linear combination of $\{\mathbf{b}_1, \dots, \mathbf{b}_p\}$, so $\text{Span}\{\mathbf{b}_1, \dots, \mathbf{b}_p\} = H$.

The columns of any invertible $n \times n$ matrix form a basis for all of $\mathbb{R}^n$ because they are linearly independent and span $\mathbb{R}^n$. A primary example is the set of columns of the $n \times n$ identity matrix $I_n$, denoted by $\mathbf{e}_1, \mathbf{e}_2, \dots, \mathbf{e}_n$:

$$\mathbf{e}_1 = \begin{bmatrix} 1 \\ 0 \\ \vdots \\ 0 \end{bmatrix}, \quad \mathbf{e}_2 = \begin{bmatrix} 0 \\ 1 \\ \vdots \\ 0 \end{bmatrix}, \quad \dots, \quad \mathbf{e}_n = \begin{bmatrix} 0 \\ 0 \\ \vdots \\ 1 \end{bmatrix}$$

The set $\{\mathbf{e}_1, \mathbf{e}_2, \dots, \mathbf{e}_n\}$ is called the ***standard basis*** for $\mathbb{R}^n$.

---

### Finding a Basis for the Null Space ($\text{Nul } A$)

Writing the solution set of a homogeneous linear system $A\mathbf{x} = \mathbf{0}$ in parametric vector form systematically produces a basis for $\text{Nul } A$.

> [!example] Constructing a Basis for $\text{Nul } A$
> Find a basis for the null space of the matrix:
> $$A = \begin{bmatrix} -3 & 6 & -1 & 1 & -7 \\ 1 & -2 & 2 & 3 & -1 \\ 2 & -4 & 5 & 8 & -4 \end{bmatrix}$$
> 
> **Solution:**  
> Row reduce the augmented matrix $\begin{bmatrix} A & \mathbf{0} \end{bmatrix}$ to reduced echelon form:
> $$\begin{bmatrix} A & \mathbf{0} \end{bmatrix} \sim \begin{bmatrix} 1 & -2 & 0 & -1 & 3 & 0 \\ 0 & 0 & 1 & 2 & -2 & 0 \\ 0 & 0 & 0 & 0 & 0 & 0 \end{bmatrix}$$
> 
> Express the basic variables ($x_1, x_3$) in terms of the free variables ($x_2, x_4, x_5$):
> $$\begin{aligned} x_1 &= 2x_2 + x_4 - 3x_5 \\ x_3 &= -2x_4 + 2x_5 \end{aligned}$$
> 
> Write the general solution vector $\mathbf{x}$ in parametric vector form:
> $$\mathbf{x} = \begin{bmatrix} x_1 \\ x_2 \\ x_3 \\ x_4 \\ x_5 \end{bmatrix} = \begin{bmatrix} 2x_2 + x_4 - 3x_5 \\ x_2 \\ -2x_4 + 2x_5 \\ x_4 \\ x_5 \end{bmatrix} = x_2 \begin{bmatrix} 2 \\ 1 \\ 0 \\ 0 \\ 0 \end{bmatrix} + x_4 \begin{bmatrix} 1 \\ 0 \\ -2 \\ 1 \\ 0 \end{bmatrix} + x_5 \begin{bmatrix} -3 \\ 0 \\ 2 \\ 0 \\ 1 \end{bmatrix} = x_2 \mathbf{u} + x_4 \mathbf{v} + x_5 \mathbf{w}$$
> 
> The vectors $\mathbf{u}, \mathbf{v}, \mathbf{w}$ span $\text{Nul } A$. Furthermore, they are linearly independent because setting $x_2\mathbf{u} + x_4\mathbf{v} + x_5\mathbf{w} = \mathbf{0}$ forces $x_2 = 0$, $x_4 = 0$, and $x_5 = 0$ (observed directly in entries 2, 4, and 5). 
> 
> Therefore, $\{\mathbf{u}, \mathbf{v}, \mathbf{w}\}$ forms a basis for $\text{Nul } A$.

---

### Finding a Basis for the Column Space ($\text{Col } A$)

Linear dependence relations among the columns of a matrix $A$ are defined by solutions to $A\mathbf{x} = \mathbf{0}$. Because elementary row operations do not change the solution set of the system, row reduction preserves the exact linear dependence relations among the columns.

If matrix $A$ is row reduced to an echelon form $B$:
- Columns of $B$ that contain pivot positions are linearly independent.
- Non-pivot columns of $B$ are linear combinations of the preceding pivot columns.
- The corresponding columns in the original matrix $A$ satisfy the exact same linear combinations and linear independence relations.

> [!summary] theorem : Basis for the Column Space (Theorem 13)
> The pivot columns of a matrix $A$ form a basis for the column space $\text{Col } A$.
> 
> **breakdown**:
> - $A$ : An $m \times n$ matrix.
> - **Pivot Columns** : The specific columns in $A$ that correspond to the columns containing leading entries (pivots) in an echelon form of $A$.
> - $\text{Col } A$ : The subspace of $\mathbb{R}^m$ spanned by the columns of $A$.
> 
> **proof**:
> Let $B$ be the reduced echelon form of $A$. The pivot columns of $B$ are linearly independent because they match the standard basis columns $\mathbf{e}_1, \mathbf{e}_2, \dots$ of an identity matrix. Every non-pivot column of $B$ is a unique linear combination of these pivot columns.
> 
> Since row reduction preserves the solution set of $A\mathbf{x} = \mathbf{0}$, the columns of $A$ satisfy the exact same linear dependence relationships as the columns of $B$. Therefore:
> 1. The pivot columns of $A$ are linearly independent.
> 2. Every non-pivot column of $A$ can be written as a linear combination of its pivot columns, making non-pivot columns redundant in generating $\text{Col } A$.
> 
> Thus, the pivot columns of $A$ span $\text{Col } A$ and are linearly independent, making them a basis for $\text{Col } A$.

> [!example] Determining a Basis for $\text{Col } A$
> Find a basis for the column space of:
> $$A = \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \mathbf{a}_3 & \mathbf{a}_4 & \mathbf{a}_5 \end{bmatrix} = \begin{bmatrix} 1 & 3 & 3 & 2 & -9 \\ -2 & -2 & 2 & -8 & 2 \\ 2 & 3 & 0 & 7 & 1 \\ 3 & 4 & 1 & 11 & -8 \end{bmatrix}$$
> 
> **Solution:**  
> Row reduce $A$ to reduced echelon form $B$:
> $$B = \begin{bmatrix} \mathbf{b}_1 & \mathbf{b}_2 & \mathbf{b}_3 & \mathbf{b}_4 & \mathbf{b}_5 \end{bmatrix} = \begin{bmatrix} 1 & 0 & -3 & 5 & 0 \\ 0 & 1 & 2 & -1 & 0 \\ 0 & 0 & 0 & 0 & 1 \\ 0 & 0 & 0 & 0 & 0 \end{bmatrix}$$
> 
> 1. Identify pivot columns: In matrix $B$, pivots are located in columns 1, 2, and 5.
> 2. Observe linear dependencies: 
>    $$\mathbf{b}_3 = -3\mathbf{b}_1 + 2\mathbf{b}_2 \implies \mathbf{a}_3 = -3\mathbf{a}_1 + 2\mathbf{a}_2$$
>    $$\mathbf{b}_4 = 5\mathbf{b}_1 - \mathbf{b}_2 \implies \mathbf{a}_4 = 5\mathbf{a}_1 - \mathbf{a}_2$$
> 3. Select corresponding original columns: Columns 3 and 4 are redundant. The set of pivot columns $\{\mathbf{a}_1, \mathbf{a}_2, \mathbf{a}_5\}$ forms a basis for $\text{Col } A$:
>    $$\text{Basis for } \text{Col } A = \left\{ \begin{bmatrix} 1 \\ -2 \\ 2 \\ 3 \end{bmatrix}, \begin{bmatrix} 3 \\ -2 \\ 3 \\ 4 \end{bmatrix}, \begin{bmatrix} -9 \\ 2 \\ 1 \\ -8 \end{bmatrix} \right\}$$

> [!warning] Use Original Columns for $\text{Col } A$ Basis
> Always construct the basis for $\text{Col } A$ using the pivot columns of the **original matrix $A$**, not the columns of its echelon form $B$. 
> 
> Row operations drastically alter the column space. For instance, in the example above, the vectors in echelon form $B$ all have a bottom row of zeros, meaning they cannot span vectors in $\mathbb{R}^4$ with nonzero fourth entries and generally do not even belong to $\text{Col } A$.
