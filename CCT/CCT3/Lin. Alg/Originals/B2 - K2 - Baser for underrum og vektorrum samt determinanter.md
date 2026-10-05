---
tags:
  - CCT3
  - Lin_Algebra
Topic: Baser for underrum og vektorrum samt determinanter
Semester: CCT3
Course: Linær Algebra
Litterature:
  - Linear Algebra and Its Applications, Global Edition, 6ed
Created: 05-10-2026
---
- - -

## Table of Contents

1. [[#Coordinate Systems|Coordinate Systems]]
2. [[#The Dimension of a Subspace|The Dimension of a Subspace]]
3. [[#Rank and the Invertible Matrix Theorem|Rank and the Invertible Matrix Theorem]]
4. [[#Numerical Notes|Numerical Notes]]
5. [[#Practice Problems|Practice Problems]]
6. [[#3 Determinants|3 Determinants]]
	1. [[#3 Determinants#Introductory Example: Weighing Diamonds|Introductory Example: Weighing Diamonds]]
7. [[#3.1 Introduction to Determinants|3.1 Introduction to Determinants]]
	1. [[#3.1 Introduction to Determinants#Deriving the $3 \times 3$ Determinant|Deriving the $3 \times 3$ Determinant]]
	2. [[#3.1 Introduction to Determinants#Base Cases|Base Cases]]
	3. [[#3.1 Introduction to Determinants#Recursive Definition via Submatrices|Recursive Definition via Submatrices]]
	4. [[#3.1 Introduction to Determinants#Cofactors and Cofactor Expansion|Cofactors and Cofactor Expansion]]
	5. [[#3.1 Introduction to Determinants#Bounding the Determinant|Bounding the Determinant]]
8. [[#3.2 Properties of Determinants|3.2 Properties of Determinants]]
	1. [[#3.2 Properties of Determinants#Determinant from Echelon Form|Determinant from Echelon Form]]
	2. [[#3.2 Properties of Determinants#Column Operations|Column Operations]]
	3. [[#3.2 Properties of Determinants#Determinants and Matrix Products|Determinants and Matrix Products]]
	4. [[#3.2 Properties of Determinants#Linearity Property of the Determinant|Linearity Property of the Determinant]]
	5. [[#3.2 Properties of Determinants#Practice Problems|Practice Problems]]

## Coordinate Systems

The primary reason for selecting a basis for a subspace $H$, rather than merely a spanning set, is that each vector in $H$ can be written in *only one way* as a linear combination of the basis vectors. 

To see why uniqueness holds, suppose $\mathcal{B} = \{\mathbf{b}_1, \dots, \mathbf{b}_p\}$ is a basis for $H$. If a vector $\mathbf{x} \in H$ could be represented in two ways:
$$\mathbf{x} = c_1\mathbf{b}_1 + \dots + c_p\mathbf{b}_p \quad \text{and} \quad \mathbf{x} = d_1\mathbf{b}_1 + \dots + d_p\mathbf{b}_p$$

Subtracting the two equations gives:
$$\mathbf{0} = \mathbf{x} - \mathbf{x} = (c_1 - d_1)\mathbf{b}_1 + \dots + (c_p - d_p)\mathbf{b}_p$$

Because the basis set $\mathcal{B}$ is linearly independent, all weights in this combination must equal zero:
$$c_j - d_j = 0 \implies c_j = d_j \quad \text{for } 1 \le j \le p$$

This confirms that the two representations are identical.

>[!summary] Definition: Coordinates Relative to a Basis
>Suppose the set $\mathcal{B} = \{\mathbf{b}_1, \dots, \mathbf{b}_p\}$ is an ordered basis for a subspace $H$. For each $\mathbf{x} \in H$, the ***coordinates of $\mathbf{x}$ relative to the basis $\mathcal{B}$*** (or the ***$\mathcal{B}$-coordinates of $\mathbf{x}$***) are the scalars $c_1, \dots, c_p$ such that:
>$$\mathbf{x} = c_1\mathbf{b}_1 + \dots + c_p\mathbf{b}_p$$
>The vector in $\mathbb{R}^p$:
>$$[\mathbf{x}]_\mathcal{B} = \begin{bmatrix} c_1 \\ \vdots \\ c_p \end{bmatrix}$$
>is called the ***coordinate vector of $\mathbf{x}$ relative to $\mathcal{B}$*** (or the ***$\mathcal{B}$-coordinate vector of $\mathbf{x}$***).
>
>**breakdown**:
>- $\mathcal{B}$ : An ordered basis set containing $p$ linearly independent vectors that span $H$.
>- $\mathbf{x}$ : A vector belonging to the subspace $H$.
>- $c_1, \dots, c_p$ : The unique scalar weights corresponding to each basis vector.
>- $[\mathbf{x}]_\mathcal{B}$ : The coordinate vector in $\mathbb{R}^p$ whose entries are the weights $c_1, \dots, c_p$.

>[!example] Example 1: Finding the Coordinate Vector
>Let $\mathbf{v}_1 = \begin{bmatrix} 3 \\ 6 \\ 2 \end{bmatrix}$, $\mathbf{v}_2 = \begin{bmatrix} -1 \\ 0 \\ 1 \end{bmatrix}$, $\mathbf{x} = \begin{bmatrix} 3 \\ 12 \\ 7 \end{bmatrix}$, and $\mathcal{B} = \{\mathbf{v}_1, \mathbf{v}_2\}$. The set $\mathcal{B}$ forms a basis for $H = \operatorname{Span}\{\mathbf{v}_1, \mathbf{v}_2\}$ because $\mathbf{v}_1$ and $\mathbf{v}_2$ are linearly independent. Determine if $\mathbf{x} \in H$, and if so, calculate $[\mathbf{x}]_\mathcal{B}$.
>
>**Solution:**
>If $\mathbf{x}$ is in $H$, the vector equation $c_1\mathbf{v}_1 + c_2\mathbf{v}_2 = \mathbf{x}$ must be consistent:
>$$c_1 \begin{bmatrix} 3 \\ 6 \\ 2 \end{bmatrix} + c_2 \begin{bmatrix} -1 \\ 0 \\ 1 \end{bmatrix} = \begin{bmatrix} 3 \\ 12 \\ 7 \end{bmatrix}$$
>
>Set up the augmented matrix and row reduce:
>$$\begin{bmatrix} 3 & -1 & 3 \\ 6 & 0 & 12 \\ 2 & 1 & 7 \end{bmatrix} \sim \begin{bmatrix} 1 & 0 & 2 \\ 0 & 1 & 3 \\ 0 & 0 & 0 \end{bmatrix}$$
>
>The system is consistent, giving $c_1 = 2$ and $c_2 = 3$. Therefore, $\mathbf{x}$ is in $H$, and its $\mathcal{B}$-coordinate vector is:
>$$[\mathbf{x}]_\mathcal{B} = \begin{bmatrix} 2 \\ 3 \end{bmatrix}$$

![[Pasted image 20261005200107.png]]
FIGURE 1 A coordinate system on a plane H in R3
Even though vectors in $H$ reside in $\mathbb{R}^3$, they are completely determined by coordinate vectors in $\mathbb{R}^2$. The basis $\mathcal{B}$ introduces a coordinate grid on the plane $H$, making it act like $\mathbb{R}^2$. 

The correspondence $\mathbf{x} \mapsto [\mathbf{x}]_\mathcal{B}$ is a one-to-one mapping between $H$ and $\mathbb{R}^2$ that preserves linear combinations. Such a mapping is called an ***isomorphism***, and $H$ is said to be ***isomorphic*** to $\mathbb{R}^2$. In general, if a subspace $H$ has a basis of $p$ vectors, the mapping $\mathbf{x} \mapsto [\mathbf{x}]_\mathcal{B}$ makes $H$ look and behave identically to $\mathbb{R}^p$.

## The Dimension of a Subspace

If a subspace $H$ has a basis of $p$ vectors, every basis of $H$ must consist of exactly $p$ vectors.

>[!summary] Definition: Dimension
>The ***dimension*** of a nonzero subspace $H$, denoted by $\dim H$, is the number of vectors in any basis for $H$. The dimension of the zero subspace $\{\mathbf{0}\}$ is defined to be zero.
>
>**breakdown**:
>- $H$ : A subspace of $\mathbb{R}^n$.
>- $\dim H$ : A non-negative integer representing the exact count of vectors in any basis for $H$.
>- $\{\mathbf{0}\}$ : The zero subspace, which contains only the zero vector and has no basis (dimension is $0$).

The space $\mathbb{R}^n$ has dimension $n$, as every basis for $\mathbb{R}^n$ consists of $n$ vectors. In geometric terms:
- A line through $\mathbf{0}$ is one-dimensional.
- A plane through $\mathbf{0}$ is two-dimensional.

>[!example] Example 2: Dimension of a Null Space
>To find the dimension of the null space $\operatorname{Nul} A$ for a matrix $A$, solve the homogeneous equation $A\mathbf{x} = \mathbf{0}$ and express the general solution in parametric vector form. Each free variable corresponds to a basis vector in the spanning set for $\operatorname{Nul} A$. 
>
>Therefore, to find $\dim \operatorname{Nul} A$, count the number of free variables in the equation $A\mathbf{x} = \mathbf{0}$.

>[!summary] Definition: Rank
>The ***rank*** of a matrix $A$, denoted by $\operatorname{rank} A$, is the dimension of the column space of $A$.
>
>**breakdown**:
>- $A$ : An $m \times n$ matrix.
>- $\operatorname{Col} A$ : The column space of $A$ (the subspace spanned by the columns of $A$).
>- $\operatorname{rank} A$ : The dimension of $\operatorname{Col} A$, which equals the number of pivot columns in $A$.

>[!example] Example 3: Determining the Rank of a Matrix
>Determine the rank of the matrix:
>$$A = \begin{bmatrix} 2 & 5 & -3 & -4 & 8 \\ 4 & 7 & -4 & -3 & 9 \\ 6 & 9 & -5 & -2 & 4 \\ 0 & -9 & 6 & 5 & -6 \end{bmatrix}$$
>
>**Solution:**
>Row reduce $A$ to echelon form:
>$$A \sim \begin{bmatrix} 2 & 5 & -3 & -4 & 8 \\ 0 & -3 & 2 & 5 & -7 \\ 0 & -6 & 4 & 14 & -20 \\ 0 & -9 & 6 & 5 & -6 \end{bmatrix} \sim \begin{bmatrix} \mathbf{2} & 5 & -3 & -4 & 8 \\ 0 & \mathbf{-3} & 2 & 5 & -7 \\ 0 & 0 & 0 & \mathbf{4} & -6 \\ 0 & 0 & 0 & 0 & 0 \end{bmatrix}$$
>
>The matrix has 3 pivot columns (columns 1, 2, and 4). Thus:
>$$\operatorname{rank} A = 3$$

Because the nonpivot columns correspond to free variables in $A\mathbf{x} = \mathbf{0}$, and the total number of columns equals pivot columns plus nonpivot columns, the dimensions of $\operatorname{Col} A$ and $\operatorname{Nul} A$ are directly related.

>[!summary] Theorem 14: The Rank Theorem
>If a matrix $A$ has $n$ columns, then:
>$$\operatorname{rank} A + \dim \operatorname{Nul} A = n$$
>
>**breakdown**:
>- $A$ : An $m \times n$ matrix.
>- $n$ : The total number of columns in $A$.
>- $\operatorname{rank} A$ : The dimension of $\operatorname{Col} A$ (number of pivot columns).
>- $\dim \operatorname{Nul} A$ : The dimension of $\operatorname{Nul} A$ (number of nonpivot columns / free variables).
>
>**proof**:
>The rank of $A$ equals the number of pivot columns in $A$. The dimension of $\operatorname{Nul} A$ equals the number of free variables in $A\mathbf{x} = \mathbf{0}$, which matches the number of nonpivot columns. Since every column is either a pivot column or a nonpivot column, the sum of the pivot columns and nonpivot columns is the total number of columns $n$. Hence, $\operatorname{rank} A + \dim \operatorname{Nul} A = n$.

>[!summary] Theorem 15: The Basis Theorem
>Let $H$ be a $p$-dimensional subspace of $\mathbb{R}^n$.
>1. Any linearly independent set of exactly $p$ elements in $H$ is automatically a basis for $H$.
>2. Any set of $p$ elements of $H$ that spans $H$ is automatically a basis for $H$.
>
>**breakdown**:
>- $H$ : A subspace of $\mathbb{R}^n$ with $\dim H = p$.
>- $p$ : The dimension of $H$ (the exact size required for a basis).
>
>**proof**:
>Because $H$ is isomorphic to $\mathbb{R}^p$, a set of $p$ vectors in $H$ behaves like a set of $p$ vectors in $\mathbb{R}^p$. In an $n$-dimensional setting, a set of $n$ vectors is linearly independent if and only if it spans the space. Thus, for a $p$-dimensional subspace, any collection of $p$ vectors that is linearly independent must span $H$, and any collection of $p$ vectors that spans $H$ must be linearly independent. In either case, the set satisfies both criteria for a basis.

## Rank and the Invertible Matrix Theorem

The definitions of rank, dimension, null space, and column space provide additional equivalent conditions for the invertibility of square matrices.

>[!summary] Theorem: The Invertible Matrix Theorem (Continued)
>Let $A$ be an $n \times n$ matrix. The following statements are each equivalent to the statement that $A$ is an invertible matrix:
>
>- **m.** The columns of $A$ form a basis of $\mathbb{R}^n$.
>- **n.** $\operatorname{Col} A = \mathbb{R}^n$
>- **o.** $\operatorname{rank} A = n$
>- **p.** $\dim \operatorname{Nul} A = 0$
>- **q.** $\operatorname{Nul} A = \{\mathbf{0}\}$
>
>**breakdown**:
>- $A$ : An $n \times n$ square matrix.
>- $\operatorname{Col} A$ : The column space of $A$.
>- $\operatorname{Nul} A$ : The null space of $A$.
>- $\operatorname{rank} A$ : The dimension of $\operatorname{Col} A$.
>
>**proof**:
>Statement (**m**) is logically equivalent to the existing conditions that the columns of $A$ are linearly independent and span $\mathbb{R}^n$. 
>
>The remaining statements follow in a chain of implications:
>$$\text{Equation } A\mathbf{x} = \mathbf{b} \text{ is consistent for all } \mathbf{b} \implies (\text{n}) \implies (\text{o}) \implies (\text{p}) \implies (\text{q}) \implies A\mathbf{x} = \mathbf{0} \text{ has only the trivial solution}$$
>
>1. If $A\mathbf{x} = \mathbf{b}$ has a solution for every $\mathbf{b} \in \mathbb{R}^n$, then the columns span $\mathbb{R}^n$, so $\operatorname{Col} A = \mathbb{R}^n$ (**n**).
>2. If $\operatorname{Col} A = \mathbb{R}^n$, its dimension is $n$, so $\operatorname{rank} A = n$ (**o**).
>3. If $\operatorname{rank} A = n$, then by the Rank Theorem ($n + \dim \operatorname{Nul} A = n$), $\dim \operatorname{Nul} A = 0$ (**p**).
>4. If $\dim \operatorname{Nul} A = 0$, the null space contains only the zero vector, so $\operatorname{Nul} A = \{\mathbf{0}\}$ (**q**).
>5. If $\operatorname{Nul} A = \{\mathbf{0}\}$, then $A\mathbf{x} = \mathbf{0}$ has only the trivial solution, which is a known condition for invertibility.

## Numerical Notes

While reducing a matrix to echelon form is straightforward for hand computations, real-world numerical rank determination is sensitive to rounding errors. 

If exact arithmetic is not used, floating-point roundoff can alter the computed rank. For example, consider the matrix:
$$\begin{bmatrix} 5 & 7 \\ 5 & x \end{bmatrix}$$

If $x$ is theoretically $7$, but stored with a minute computational error (e.g., $7.00000001$), the algorithm may not treat $x - 7$ as zero, classifying the matrix as rank 2 instead of rank 1. In practice, the effective rank of a matrix is commonly determined via *Singular Value Decomposition* (SVD).

## Practice Problems

>[!example] Practice Problem 1
>Determine the dimension of the subspace $H$ of $\mathbb{R}^3$ spanned by the vectors:
>$$\mathbf{v}_1 = \begin{bmatrix} 2 \\ -8 \\ 6 \end{bmatrix}, \quad \mathbf{v}_2 = \begin{bmatrix} 3 \\ -7 \\ -1 \end{bmatrix}, \quad \mathbf{v}_3 = \begin{bmatrix} -1 \\ 6 \\ -7 \end{bmatrix}$$
>
>**Solution:**
>Construct matrix $A = [\mathbf{v}_1 \ \mathbf{v}_2 \ \mathbf{v}_3]$ and row reduce to find the pivot columns:
>$$\begin{bmatrix} 2 & 3 & -1 \\ -8 & -7 & 6 \\ 6 & -1 & -7 \end{bmatrix} \sim \begin{bmatrix} 2 & 3 & -1 \\ 0 & 5 & 2 \\ 0 & -10 & -4 \end{bmatrix} \sim \begin{bmatrix} \mathbf{2} & 3 & -1 \\ 0 & \mathbf{5} & 2 \\ 0 & 0 & 0 \end{bmatrix}$$
>
>There are 2 pivot columns (columns 1 and 2). Thus, $\{\mathbf{v}_1, \mathbf{v}_2\}$ is a basis for $H$, and:
>$$\dim H = 2$$

>[!example] Practice Problem 2
>Consider the basis $\mathcal{B} = \left\{ \begin{bmatrix} 1 \\ 0.2 \end{bmatrix}, \begin{bmatrix} 0.2 \\ 1 \end{bmatrix} \right\}$ for $\mathbb{R}^2$. If $[\mathbf{x}]_\mathcal{B} = \begin{bmatrix} 3 \\ 2 \end{bmatrix}$, find $\mathbf{x}$.
>
>**Solution:**
>Apply the coordinate definition $\mathbf{x} = c_1\mathbf{b}_1 + c_2\mathbf{b}_2$:
>$$\mathbf{x} = 3 \begin{bmatrix} 1 \\ 0.2 \end{bmatrix} + 2 \begin{bmatrix} 0.2 \\ 1 \end{bmatrix} = \begin{bmatrix} 3 \\ 0.6 \end{bmatrix} + \begin{bmatrix} 0.4 \\ 2 \end{bmatrix} = \begin{bmatrix} 3.4 \\ 2.6 \end{bmatrix}$$

>[!example] Practice Problem 3
>Could $\mathbb{R}^3$ contain a four-dimensional subspace? Explain.
>
>**Solution:**
>No. A four-dimensional subspace would require a basis consisting of 4 linearly independent vectors. However, any set of 4 vectors in $\mathbb{R}^3$ must be linearly dependent because the number of vectors ($p = 4$) exceeds the dimension of the ambient space ($n = 3$). Therefore, no subspace of $\mathbb{R}^3$ can have a dimension greater than 3.

## 3 Determinants

The determinant is a scalar value associated with a square matrix that encodes critical information about the matrix's properties, including invertibility and geometric scaling behavior.

### Introductory Example: Weighing Diamonds

When weighing $n$ small objects (e.g., gemstones) using a two-pan balance, objects can be weighed in groups to improve accuracy. A *design matrix* $D$ encodes the weighing strategy:

- $d_{ij} = 1$ if object $s_j$ is placed in the left pan during weighing $i$
- $d_{ij} = -1$ if object $s_j$ is placed in the right pan during weighing $i$

The matrix $D$ is $m \times n$, where $m$ is the number of weighings and $n$ is the number of objects. The accuracy of a weighing design is highest when the design matrix maximizes $\det(D^T D)$.

For example, with four objects and four weighings, the design matrix:

$$D = \begin{bmatrix} 1 & -1 & -1 & -1 \\ 1 & 1 & -1 & -1 \\ 1 & -1 & 1 & -1 \\ 1 & -1 & -1 & 1 \end{bmatrix}$$

yields $\det(D^T D) = 256$, which is superior to a design where all objects start in the same pan (yielding $\det(D^T D) = 64$).

Beyond weighing optimization, the determinant measures how a linear transformation scales area (in 2D) or volume (in 3D). When a matrix transforms a geometric figure, the absolute value of its determinant gives the factor by which area or volume changes. This concept generalizes to higher dimensions and plays a critical role in multivariable calculus through the *Jacobian*.

## 3.1 Introduction to Determinants

A $2 \times 2$ matrix is invertible if and only if its determinant is nonzero. To extend this to larger matrices, the determinant of an $n \times n$ matrix is defined recursively.

### Deriving the $3 \times 3$ Determinant

Consider an invertible $3 \times 3$ matrix $A = [a_{ij}]$ with $a_{11} \neq 0$. Row-reducing $A$ (multiplying rows 2 and 3 by $a_{11}$, then eliminating below the first pivot) produces:

$$A \sim \begin{bmatrix} a_{11} & a_{12} & a_{13} \\ 0 & a_{11}a_{22} - a_{12}a_{21} & a_{11}a_{23} - a_{13}a_{21} \\ 0 & a_{11}a_{32} - a_{12}a_{31} & a_{11}a_{33} - a_{13}a_{31} \end{bmatrix}$$

Continuing elimination (assuming the $(2,2)$-entry is nonzero) yields an upper triangular form whose $(3,3)$-entry contains the factor:

$$\Delta = a_{11}a_{22}a_{33} + a_{12}a_{23}a_{31} + a_{13}a_{21}a_{32} - a_{11}a_{23}a_{32} - a_{12}a_{21}a_{33} - a_{13}a_{22}a_{31}$$

Since $A$ is invertible, $\Delta$ must be nonzero. This expression $\Delta$ is defined as the ***determinant*** of the $3 \times 3$ matrix $A$.

### Base Cases

- **$1 \times 1$ matrix:** For $A = [a_{11}]$, define $\det A = a_{11}$.
- **$2 \times 2$ matrix:** For $A = [a_{ij}]$, define $\det A = a_{11}a_{22} - a_{12}a_{21}$.

### Recursive Definition via Submatrices

The $3 \times 3$ determinant can be rewritten by grouping terms using $2 \times 2$ determinants:

$$\Delta = a_{11} \det \begin{bmatrix} a_{22} & a_{23} \\ a_{32} & a_{33} \end{bmatrix} - a_{12} \det \begin{bmatrix} a_{21} & a_{23} \\ a_{31} & a_{33} \end{bmatrix} + a_{13} \det \begin{bmatrix} a_{21} & a_{22} \\ a_{31} & a_{32} \end{bmatrix}$$

Each $2 \times 2$ submatrix is obtained by deleting the first row and one column from $A$. This pattern generalizes: for any square matrix $A$, let $A_{ij}$ denote the ***submatrix*** formed by deleting the $i$th row and $j$th column of $A$.

>[!example] Submatrix Construction
>Given:
>$$A = \begin{bmatrix} 1 & 2 & 5 & 0 \\ 2 & 0 & 4 & 1 \\ 3 & 1 & 0 & 7 \\ 0 & 4 & 2 & 0 \end{bmatrix}$$
>
>To form $A_{32}$, delete row 3 and column 2:
>$$A_{32} = \begin{bmatrix} 1 & 5 & 0 \\ 2 & 4 & 1 \\ 0 & 2 & 0 \end{bmatrix}$$

>[!summary] Definition: Determinant of an $n \times n$ Matrix
>For $n \geq 2$, the determinant of an $n \times n$ matrix $A = [a_{ij}]$ is the sum of $n$ terms of the form $\pm a_{1j} \det A_{1j}$, with alternating signs, using entries from the first row:
>$$\det A = a_{11} \det A_{11} - a_{12} \det A_{12} + \cdots + (-1)^{1+n} a_{1n} \det A_{1n} = \sum_{j=1}^{n} (-1)^{1+j} a_{1j} \det A_{1j}$$
>
>**breakdown**:
>- $A$ : An $n \times n$ square matrix.
>- $a_{1j}$ : The entry in the first row, $j$th column of $A$.
>- $A_{1j}$ : The $(n-1) \times (n-1)$ submatrix obtained by deleting row 1 and column $j$ from $A$.
>- $(-1)^{1+j}$ : The alternating sign factor, which is $+$ when $1+j$ is even and $-$ when $1+j$ is odd.
>- $\det A_{1j}$ : The determinant of the submatrix (computed recursively using the same definition).

>[!example] Example 1: Computing a $3 \times 3$ Determinant
>Compute $\det A$ for:
>$$A = \begin{bmatrix} 1 & 5 & 0 \\ 2 & 4 & -1 \\ 0 & -2 & 0 \end{bmatrix}$$
>
>**Solution:** Expand across the first row:
>$$\det A = 1 \cdot \det \begin{bmatrix} 4 & -1 \\ -2 & 0 \end{bmatrix} - 5 \cdot \det \begin{bmatrix} 2 & -1 \\ 0 & 0 \end{bmatrix} + 0 \cdot \det \begin{bmatrix} 2 & 4 \\ 0 & -2 \end{bmatrix}$$
>$$= 1(0 - 2) - 5(0 - 0) + 0(4 - 0) = -2$$

An alternative notation replaces brackets with vertical bars: $\det A = |A|$.

### Cofactors and Cofactor Expansion

The ***$(i,j)$-cofactor*** of $A$ is the number:

$$C_{ij} = (-1)^{i+j} \det A_{ij}$$

Using cofactors, the determinant expansion across the first row becomes:

$$\det A = a_{11}C_{11} + a_{12}C_{12} + \cdots + a_{1n}C_{1n}$$

The sign factor $(-1)^{i+j}$ produces a checkerboard pattern that depends on the *position* of the entry, not its value:

$$\begin{bmatrix} + & - & + & \cdots \\ - & + & - & \cdots \\ + & - & + & \cdots \\ \vdots & \vdots & \vdots & \ddots \end{bmatrix}$$

>[!summary] Theorem 1: Cofactor Expansion Across Any Row or Column
>The determinant of an $n \times n$ matrix $A$ can be computed by a cofactor expansion across *any* row or down *any* column.
>
>Expansion across the $i$th row:
>$$\det A = a_{i1}C_{i1} + a_{i2}C_{i2} + \cdots + a_{in}C_{in}$$
>
>Expansion down the $j$th column:
>$$\det A = a_{1j}C_{1j} + a_{2j}C_{2j} + \cdots + a_{nj}C_{nj}$$
>
>**breakdown**:
>- $a_{ij}$ : The entry in row $i$, column $j$ of $A$.
>- $C_{ij}$ : The $(i,j)$-cofactor, defined as $(-1)^{i+j} \det A_{ij}$.
>- $A_{ij}$ : The submatrix formed by deleting row $i$ and column $j$.
>
>**proof**:
>Omitted (requires a lengthy inductive argument). The key insight is that the alternating sign structure and the recursive submatrix construction ensure that every row and every column yields the same scalar value.

>[!tip] Strategic Expansion
>When computing determinants by hand, choose a row or column with the most zeros. Each zero entry eliminates a cofactor term entirely, so those sub-determinants need not be calculated.

>[!example] Example 2: Expansion Across a Row with Zeros
>Compute $\det A$ by expanding across the third row:
>$$A = \begin{bmatrix} 1 & 5 & 0 \\ 2 & 4 & -1 \\ 0 & -2 & 0 \end{bmatrix}$$
>
>**Solution:**
>$$\det A = a_{31}C_{31} + a_{32}C_{32} + a_{33}C_{33}$$
>$$= 0 \cdot C_{31} + (-2)(-1)^{3+2} \det \begin{bmatrix} 1 & 0 \\ 2 & -1 \end{bmatrix} + 0 \cdot C_{33}$$
>$$= 0 + (-2)(-1)(1 \cdot (-1) - 0 \cdot 2) + 0 = 2(-1) = -2$$

>[!example] Example 3: Exploiting Zeros in a Larger Matrix
>Compute $\det A$ for:
>$$A = \begin{bmatrix} 3 & -7 & 8 & 9 & -6 \\ 0 & 2 & -5 & 7 & 3 \\ 0 & 0 & 1 & 5 & 0 \\ 0 & 0 & 2 & 4 & -1 \\ 0 & 0 & 0 & -2 & 0 \end{bmatrix}$$
>
>**Solution:** Expand down the first column (only the first entry is nonzero):
>$$\det A = 3 \cdot \det \begin{bmatrix} 2 & -5 & 7 & 3 \\ 0 & 1 & 5 & 0 \\ 0 & 2 & 4 & -1 \\ 0 & 0 & -2 & 0 \end{bmatrix}$$
>
>Expand this $4 \times 4$ determinant down its first column:
>$$= 3 \cdot 2 \cdot \det \begin{bmatrix} 1 & 5 & 0 \\ 2 & 4 & -1 \\ 0 & -2 & 0 \end{bmatrix}$$
>
>This $3 \times 3$ determinant was computed in Example 1 as $-2$. Therefore:
>$$\det A = 3 \cdot 2 \cdot (-2) = -12$$

>[!summary] Theorem 2: Determinant of a Triangular Matrix
>If $A$ is a triangular matrix (upper or lower), then $\det A$ is the product of the entries on the main diagonal of $A$.
>
>**breakdown**:
>- $A$ : An $n \times n$ upper or lower triangular matrix (all entries above or below the main diagonal are zero).
>- Main diagonal entries : $a_{11}, a_{22}, \dots, a_{nn}$.
>
>**proof**:
>Repeatedly expanding along the first column (for upper triangular) or first row (for lower triangular), each step isolates one diagonal entry multiplied by a smaller triangular determinant. The recursion terminates at a $1 \times 1$ determinant, yielding $\det A = a_{11} \cdot a_{22} \cdots a_{nn}$.

>[!warning] Zero Row or Column
>If an entire row or column of $A$ consists of zeros, then every term in the cofactor expansion along that row or column is zero, so $\det A = 0$.

### Bounding the Determinant

For an $n \times n$ matrix, the determinant is a sum of $n!$ signed terms, each a product of $n$ entries. If $p$ is the product of the $n$ largest entries in absolute value (counting repeats), then:

$$-np \leq \det A \leq np$$

For example, if $A = \begin{bmatrix} 6 & -5 \\ -7 & 9 \end{bmatrix}$, the two largest entries in absolute value are $9$ and $7$, so $p = 63$ and $np = 126$. Indeed, $\det A = 54 + 35 = 89$, which falls within $[-126, 126]$.

>[!note] Computational Complexity
>Cofactor expansion requires more than $n!$ multiplications. For a $25 \times 25$ matrix, $25! \approx 1.55 \times 10^{25}$. Even at one trillion multiplications per second, this would take roughly 500,000 years. Practical determinant computation relies on row reduction methods, which are far more efficient.

## 3.2 Properties of Determinants

The key to efficiently computing determinants lies in understanding how they respond to elementary row operations. Rather than relying solely on cofactor expansion, row reduction provides a far more practical method for larger matrices.

>[!summary] Theorem 3: Effect of Row Operations on Determinants
>Let $A$ be a square matrix.
>
>**a.** If a multiple of one row of $A$ is added to another row to produce a matrix $B$, then $\det B = \det A$.
>
>**b.** If two rows of $A$ are interchanged to produce $B$, then $\det B = -\det A$.
>
>**c.** If one row of $A$ is multiplied by a scalar $k$ to produce $B$, then $\det B = k \det A$.
>
>**breakdown**:
>- $A$ : The original $n \times n$ matrix.
>- $B$ : The matrix obtained after performing a single elementary row operation on $A$.
>- $k$ : A nonzero scalar used to scale a row.
>- Row replacement (part a) : Adding a scalar multiple of one row to a *different* row. This leaves the determinant unchanged.
>- Row interchange (part b) : Swapping two rows. This flips the sign of the determinant.
>- Row scaling (part c) : Multiplying every entry in a single row by $k$. This multiplies the determinant by $k$.
>
>**proof**:
>The proof proceeds by induction on the size $n$ of the matrix. The $2 \times 2$ case can be verified directly. Assume the theorem holds for $k \times k$ matrices with $k \geq 2$, and let $n = k + 1$. The elementary operation $E$ acts on either one or two rows of $A$. Expand $\det(EA)$ across a row $i$ that is *unchanged* by $E$. The submatrices obtained by deleting row $i$ and column $j$ from $EA$ are related to the corresponding submatrices of $A$ by the same type of elementary operation. Since these submatrices are $k \times k$, the induction hypothesis applies, giving $\det B_{ij} = \alpha \det A_{ij}$ where $\alpha \in \{1, -1, r\}$ depending on the operation. Factoring $\alpha$ out of the cofactor expansion yields $\det(EA) = \alpha \det A$. The base case $n = 1$ is trivial.

>[!tip] Factoring Scalars from Rows
>A direct consequence of Theorem 3(c) is that a common factor can be pulled out of an entire row. For example, if a row contains entries $-5k, 2k, 3k$, then:
>$$\det \begin{bmatrix} \cdots \\ -5k & 2k & 3k \\ \cdots \end{bmatrix} = k \cdot \det \begin{bmatrix} \cdots \\ -5 & 2 & 3 \\ \cdots \end{bmatrix}$$
>where the other rows remain unchanged. This is useful for simplifying arithmetic before row reduction.

>[!example] Example 1: Determinant via Row Reduction to Echelon Form
>Compute $\det A$ for:
>$$A = \begin{bmatrix} 1 & 4 & 2 \\ 2 & 8 & 9 \\ 1 & 7 & 0 \end{bmatrix}$$
>
>**Solution:** Reduce $A$ to upper triangular form, tracking how each operation affects the determinant.
>
>Step 1 — Row replacements (do not change the determinant):
>$$R_2 \leftarrow R_2 - 2R_1, \quad R_3 \leftarrow R_3 - R_1$$
>$$\det A = \det \begin{bmatrix} 1 & 4 & 2 \\ 0 & 0 & 5 \\ 0 & 3 & -2 \end{bmatrix}$$
>
>Step 2 — Row interchange (flips the sign):
>$$R_2 \leftrightarrow R_3$$
>$$\det A = -\det \begin{bmatrix} 1 & 4 & 2 \\ 0 & 3 & -2 \\ 0 & 0 & 5 \end{bmatrix}$$
>
>The matrix is now upper triangular. The determinant of a triangular matrix is the product of its diagonal entries:
>$$\det A = -(1)(3)(5) = -15$$

>[!example] Example 2: Combining Factoring and Row Reduction
>Compute $\det A$ for:
>$$A = \begin{bmatrix} 2 & -8 & 6 & 8 \\ 3 & -9 & 5 & 10 \\ -3 & 0 & 1 & -2 \\ 1 & -4 & 0 & 6 \end{bmatrix}$$
>
>**Solution:** Factor 2 from the first row to create a leading 1:
>$$\det A = 2 \det \begin{bmatrix} 1 & -4 & 3 & 4 \\ 3 & -9 & 5 & 10 \\ -3 & 0 & 1 & -2 \\ 1 & -4 & 0 & 6 \end{bmatrix}$$
>
>Eliminate below the first pivot using row replacements (no determinant change):
>$$= 2 \det \begin{bmatrix} 1 & -4 & 3 & 4 \\ 0 & 3 & -4 & -2 \\ 0 & -12 & 10 & 10 \\ 0 & 0 & -3 & 2 \end{bmatrix}$$
>
>Eliminate below the second pivot ($R_3 \leftarrow R_3 + 4R_2$):
>$$= 2 \det \begin{bmatrix} 1 & -4 & 3 & 4 \\ 0 & 3 & -4 & -2 \\ 0 & 0 & -6 & 2 \\ 0 & 0 & -3 & 2 \end{bmatrix}$$
>
>Eliminate below the third pivot ($R_4 \leftarrow R_4 - \frac{1}{2}R_3$):
>$$= 2 \det \begin{bmatrix} 1 & -4 & 3 & 4 \\ 0 & 3 & -4 & -2 \\ 0 & 0 & -6 & 2 \\ 0 & 0 & 0 & 1 \end{bmatrix}$$
>
>The matrix is upper triangular:
>$$\det A = 2(1)(3)(-6)(1) = -36$$

### Determinant from Echelon Form

If a square matrix $A$ is reduced to an echelon form $U$ using only row replacements and $r$ row interchanges, then:

$$\det A = (-1)^r \det U$$

Since $U$ is triangular, $\det U$ is the product of its diagonal entries $u_{11}, \dots, u_{nn}$. If $A$ is invertible, all diagonal entries of $U$ are pivots (nonzero). If $A$ is not invertible, at least $u_{nn} = 0$, making the product zero. This gives:

$$\det A = \begin{cases} (-1)^r \cdot (\text{product of pivots in } U) & \text{when } A \text{ is invertible} \\ 0 & \text{when } A \text{ is not invertible} \end{cases}$$

Although the echelon form $U$ and the individual pivots are not unique (since $U$ is not fully reduced), the *product* of the pivots is unique up to sign.

>[!summary] Theorem 4: Invertibility Criterion
>A square matrix $A$ is invertible if and only if $\det A \neq 0$.
>
>**breakdown**:
>- $A$ : An $n \times n$ square matrix.
>- $\det A$ : The determinant of $A$.
>- Invertible : $A$ has an inverse matrix $A^{-1}$ such that $AA^{-1} = A^{-1}A = I_n$.
>
>**proof**:
>If $A$ is invertible, row reduction produces an echelon form $U$ with all nonzero pivots, so $\det U \neq 0$. Since $\det A = (-1)^r \det U$, we have $\det A \neq 0$. Conversely, if $A$ is not invertible, the echelon form $U$ has at least one zero on the diagonal, so $\det U = 0$ and $\det A = 0$.

>[!warning] Linear Dependence and Zero Determinant
>A direct consequence of Theorem 4 is that $\det A = 0$ whenever the columns of $A$ are linearly dependent, or equivalently, when the rows of $A$ are linearly dependent. In practice, this is immediately visible when:
>- Two rows (or two columns) are identical.
>- A row (or column) consists entirely of zeros.
>- One row (or column) is a scalar multiple of another.

>[!example] Example 3: Detecting a Zero Determinant
>Compute $\det A$ for:
>$$A = \begin{bmatrix} 3 & -1 & 2 & -5 \\ 0 & 5 & -3 & -6 \\ -6 & 7 & -7 & 4 \\ 5 & -8 & 0 & 9 \end{bmatrix}$$
>
>**Solution:** Perform $R_3 \leftarrow R_3 + 2R_1$:
>$$\det A = \det \begin{bmatrix} 3 & -1 & 2 & -5 \\ 0 & 5 & -3 & -6 \\ 0 & 5 & -3 & -6 \\ 5 & -8 & 0 & 9 \end{bmatrix} = 0$$
>
>The second and third rows are now identical, indicating linear dependence among the rows. Therefore, $\det A = 0$.

>[!note] Computational Efficiency
>Computing an $n \times n$ determinant via row reduction requires approximately $\frac{2n^3}{3}$ arithmetic operations, compared to more than $n!$ operations for cofactor expansion. For a $25 \times 25$ matrix, row reduction needs roughly 10,000 operations (a fraction of a second on modern hardware), while cofactor expansion would require approximately $1.55 \times 10^{25}$ operations. Most computational software uses the row reduction approach.

>[!example] Example 4: Combining Row Operations with Cofactor Expansion
>Compute $\det A$ for:
>$$A = \begin{bmatrix} 0 & 1 & -2 & 1 \\ -2 & 5 & 7 & 3 \\ 0 & 3 & 6 & -2 \\ 2 & -5 & 4 & -2 \end{bmatrix}$$
>
>**Solution:** Use the $-2$ in column 1 as a pivot to eliminate the $2$ below it ($R_4 \leftarrow R_4 + R_2$):
>$$\det A = \det \begin{bmatrix} 0 & 1 & -2 & 1 \\ -2 & 5 & 7 & 3 \\ 0 & 3 & 6 & -2 \\ 0 & 0 & -3 & 1 \end{bmatrix}$$
>
>Expand down the first column (only one nonzero entry):
>$$= -(-2) \det \begin{bmatrix} 1 & -2 & 1 \\ 3 & 6 & -2 \\ 0 & -3 & 1 \end{bmatrix} = 2 \det \begin{bmatrix} 1 & -2 & 1 \\ 3 & 6 & -2 \\ 0 & -3 & 1 \end{bmatrix}$$
>
>Apply $R_2 \leftarrow R_2 - 3R_1$:
>$$= 2 \det \begin{bmatrix} 1 & -2 & 1 \\ 0 & 12 & -5 \\ 0 & -3 & 1 \end{bmatrix}$$
>
>Expand down the first column:
>$$= 2(1) \det \begin{bmatrix} 12 & -5 \\ -3 & 1 \end{bmatrix} = 2(12 - 15) = 2(-3) = -6$$

### Column Operations

Column operations affect the determinant in exactly the same way as the corresponding row operations. This follows from the relationship between a matrix and its transpose.

>[!summary] Theorem 5: Determinant of a Transpose
>If $A$ is an $n \times n$ matrix, then:
>$$\det A^T = \det A$$
>
>**breakdown**:
>- $A$ : An $n \times n$ square matrix.
>- $A^T$ : The transpose of $A$ (rows and columns swapped).
>
>**proof**:
>The proof uses mathematical induction on $n$. For $n = 1$, the result is trivial. Assume the theorem holds for $k \times k$ determinants, and let $n = k + 1$. The $(1,j)$-cofactor of $A$ equals the $(j,1)$-cofactor of $A^T$ because both involve $k \times k$ subdeterminants, and the induction hypothesis guarantees these subdeterminants are equal. Therefore, the cofactor expansion of $\det A$ across the first row equals the cofactor expansion of $\det A^T$ down the first column. By the principle of mathematical induction, $\det A^T = \det A$ for all $n \geq 1$.

Because $\det A^T = \det A$, every property stated for row operations in Theorem 3 applies equally to column operations:
- Adding a multiple of one column to another does not change the determinant.
- Interchanging two columns negates the determinant.
- Multiplying a column by $k$ multiplies the determinant by $k$.

### Determinants and Matrix Products

>[!summary] Theorem 6: Multiplicative Property of Determinants
>If $A$ and $B$ are $n \times n$ matrices, then:
>$$\det(AB) = (\det A)(\det B)$$
>
>**breakdown**:
>- $A, B$ : $n \times n$ square matrices.
>- $AB$ : The matrix product of $A$ and $B$.
>- $\det(AB)$ : The determinant of the product matrix.
>
>**proof**:
>If $A$ is not invertible, then $AB$ is also not invertible, so both $\det(AB)$ and $(\det A)(\det B)$ equal zero. If $A$ is invertible, it can be written as a product of elementary matrices: $A = E_p E_{p-1} \cdots E_1$. Applying the reformulated Theorem 3 ($\det(EA) = (\det E)(\det A)$) repeatedly:
>$$\det(AB) = \det(E_p \cdots E_1 B) = (\det E_p) \cdots (\det E_1)(\det B) = (\det A)(\det B)$$

>[!example] Example 5: Verifying the Multiplicative Property
>Let $A = \begin{bmatrix} 6 & -1 \\ 3 & 2 \end{bmatrix}$ and $B = \begin{bmatrix} 4 & 3 \\ 1 & -2 \end{bmatrix}$.
>
>Compute the product:
>$$AB = \begin{bmatrix} 6 & -1 \\ 3 & 2 \end{bmatrix} \begin{bmatrix} 4 & 3 \\ 1 & -2 \end{bmatrix} = \begin{bmatrix} 23 & 20 \\ 14 & 5 \end{bmatrix}$$
>
>Verify:
>$$\det(AB) = 23(5) - 20(14) = 115 - 280 = -165$$
>$$(\det A)(\det B) = (12 + 3)(-8 - 3) = (15)(-11) = -165$$
>
>Both sides agree, confirming $\det(AB) = (\det A)(\det B)$.

>[!warning] Determinants Do Not Distribute Over Addition
>A common misconception is that $\det(A + B) = \det A + \det B$. This is **false** in general. The multiplicative property has no additive analogue.

### Linearity Property of the Determinant

The determinant can be viewed as a function of the column vectors of a matrix. If all columns except the $j$th are held fixed, the determinant is a *linear function* of that single column vector.

Let $A = [\mathbf{a}_1 \ \cdots \ \mathbf{a}_{j-1} \ \mathbf{x} \ \mathbf{a}_{j+1} \ \cdots \ \mathbf{a}_n]$, and define $T(\mathbf{x}) = \det A$. Then:

1. $T(c\mathbf{x}) = c \, T(\mathbf{x})$ for all scalars $c$ and vectors $\mathbf{x} \in \mathbb{R}^n$
2. $T(\mathbf{u} + \mathbf{v}) = T(\mathbf{u}) + T(\mathbf{v})$ for all $\mathbf{u}, \mathbf{v} \in \mathbb{R}^n$

Property 1 is Theorem 3(c) applied to columns. Property 2 follows from expanding the determinant down the $j$th column. This *multilinearity* of the determinant is a foundational property with important applications in advanced linear algebra and multivariable calculus.

### Practice Problems

>[!example] Practice Problem 1
>Compute the determinant in as few steps as possible:
>$$\det \begin{bmatrix} 1 & 3 & -1 & 2 \\ 2 & 5 & 1 & -2 \\ 0 & 4 & 5 & 1 \\ 3 & -10 & 6 & 8 \end{bmatrix}$$
>
>**Solution:** Eliminate below the first pivot:
>$$R_2 \leftarrow R_2 - 2R_1, \quad R_4 \leftarrow R_4 - 3R_1$$
>$$= \det \begin{bmatrix} 1 & 3 & -1 & 2 \\ 0 & -1 & 3 & -6 \\ 0 & 4 & 5 & 1 \\ 0 & -19 & 9 & 2 \end{bmatrix}$$
>
>Expand down the first column:
>$$= 1 \cdot \det \begin{bmatrix} -1 & 3 & -6 \\ 4 & 5 & 1 \\ -19 & 9 & 2 \end{bmatrix}$$
>
>Continue with row operations or cofactor expansion on the $3 \times 3$ matrix to obtain the final value.

>[!example] Practice Problem 2
>Use a determinant to decide if $\mathbf{v}_1, \mathbf{v}_2, \mathbf{v}_3$ are linearly independent, where:
>$$\mathbf{v}_1 = \begin{bmatrix} 5 \\ -7 \\ 9 \end{bmatrix}, \quad \mathbf{v}_2 = \begin{bmatrix} -3 \\ 3 \\ -5 \end{bmatrix}, \quad \mathbf{v}_3 = \begin{bmatrix} 2 \\ -7 \\ 5 \end{bmatrix}$$
>
>**Solution:** Form the matrix $A = [\mathbf{v}_1 \ \mathbf{v}_2 \ \mathbf{v}_3]$ and compute $\det A$:
>$$\det A = \det \begin{bmatrix} 5 & -3 & 2 \\ -7 & 3 & -7 \\ 9 & -5 & 5 \end{bmatrix}$$
>
>Expanding across the first row:
>$$= 5(15 - 35) - (-3)(-35 + 63) + 2(35 - 27) = 5(-20) + 3(28) + 2(8) = -100 + 84 + 16 = 0$$
>
>Since $\det A = 0$, the columns are linearly dependent, so $\mathbf{v}_1, \mathbf{v}_2, \mathbf{v}_3$ are **not** linearly independent.

>[!example] Practice Problem 3
>Let $A$ be an $n \times n$ matrix such that $A^2 = I$. Show that $\det A = \pm 1$.
>
>**Solution:** Apply the multiplicative property (Theorem 6):
>$$\det(A^2) = \det(A \cdot A) = (\det A)(\det A) = (\det A)^2$$
>
>Since $A^2 = I$ and $\det I = 1$:
>$$(\det A)^2 = 1 \implies \det A = \pm 1$$