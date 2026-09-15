---
tags:
  - CCT3
  - Lin_Algebra
Topic: Linearkombinationer og spænd af vektorer samt matrix-vektorprodukter.
Semester: CCT3
Course: Linær Algebra
Litterature:
  - Linear Algebra and Its Applications, Global Edition, 6ed
Created: 14-09-2026
---
- - -
# Table of Contents

1. [[#Vectors in R2|Vectors in R2]]
	1. [[#Vectors in R2#Equality of Vectors|Equality of Vectors]]
	2. [[#Vectors in R2#Vector Addition|Vector Addition]]
	3. [[#Vectors in R2#Scalar Multiplication|Scalar Multiplication]]
	4. [[#Vectors in R2#Notation Conventions|Notation Conventions]]
2. [[#Geometric Descriptions of R2|Geometric Descriptions of R2]]
	1. [[#Geometric Descriptions of R2#Parallelogram Rule for Addition|Parallelogram Rule for Addition]]
	2. [[#Geometric Descriptions of R2#Geometric Behavior of Scalar Multiples|Geometric Behavior of Scalar Multiples]]
3. [[#Vectors in R3|Vectors in R3]]
4. [[#Vectors in Rn|Vectors in Rn]]
	1. [[#Vectors in Rn#Algebraic Properties of Rn|Algebraic Properties of Rn]]
5. [[#Linear Combinations|Linear Combinations]]
	1. [[#Linear Combinations#Connecting Linear Combinations to Systems of Equations|Connecting Linear Combinations to Systems of Equations]]
	2. [[#Linear Combinations#Span of a Set of Vectors|Span of a Set of Vectors]]
6. [[#A Geometric Description of Span{v} and Span{u, v}|A Geometric Description of Span{v} and Span{u, v}]]
7. [[#Linear Combinations in Applications|Linear Combinations in Applications]]
8. [[#The Matrix Equation Ax = b|The Matrix Equation Ax = b]]
	1. [[#Linear Combinations in Applications#Equivalence of Systems, Vector Equations, and Matrix Equations|Equivalence of Systems, Vector Equations, and Matrix Equations]]
9. [[#The Matrix Equation Ax = b#Existence of Solutions|Existence of Solutions]]
10. [[#The Matrix Equation Ax = b#Computation of Ax|Computation of Ax]]
	1. [[#Computation of Ax#Row–Vector Rule for Computing Ax|Row–Vector Rule for Computing Ax]]
11. [[#The Matrix Equation Ax = b#Properties of the Matrix–Vector Product Ax|Properties of the Matrix–Vector Product Ax]]
12. [[#The Matrix Equation Ax = b#Homogeneous Linear Systems|Homogeneous Linear Systems]]
13. [[#The Matrix Equation Ax = b#Parametric Vector Form|Parametric Vector Form]]
14. [[#The Matrix Equation Ax = b#Solutions of Nonhomogeneous Systems|Solutions of Nonhomogeneous Systems]]
	1. [[#Solutions of Nonhomogeneous Systems#Geometric Interpretation as a Translation|Geometric Interpretation as a Translation]]
	2. [[#Solutions of Nonhomogeneous Systems#Procedure: Writing a Solution Set in Parametric Vector Form|Procedure: Writing a Solution Set in Parametric Vector Form]]
	3. [[#Solutions of Nonhomogeneous Systems#Verification of Solutions|Verification of Solutions]]

# Vector Equations

Important properties of linear systems can be described with the concept and notation of _vectors_. This framework connects equations involving vectors directly to ordinary systems of equations. 

While the term vector appears in a variety of mathematical and physical contexts, in this context a **vector** is defined simply as an ordered list of numbers.

## Vectors in R2

A matrix with only one column is called a **column vector** or simply a **vector**.

>[!info] Definition: Vectors in $\mathbb{R}^2$
> The set of all vectors with two entries is denoted by $\mathbb{R}^2$ (read "_r-two_").
> - $\mathbb{R}$ stands for the real numbers that appear as entries in the vectors.
> - The exponent $2$ indicates that each vector contains exactly two entries.
>
> Examples of vectors with two entries include:
> $$\mathbf{u} = \begin{bmatrix} 3 \\ -1 \end{bmatrix}, \quad \mathbf{v} = \begin{bmatrix} 0.2 \\ 0.3 \end{bmatrix}, \quad \mathbf{w} = \begin{bmatrix} w_1 \\ w_2 \end{bmatrix}$$
>
> **Breakdown:**
> - $\mathbf{w}$ : A general column vector in $\mathbb{R}^2$.
> - $w_1$ : The first entry (any real number).
> - $w_2$ : The second entry (any real number).

>[!note]
> While vectors generally contain real entries ($\mathbb{R}$), all definitions and operations remain valid when the entries are complex numbers ($\mathbb{C}$).

### Equality of Vectors

Two vectors in $\mathbb{R}^2$ are **equal** if and only if their corresponding entries are equal. 

Because vectors in $\mathbb{R}^2$ are ordered pairs of real numbers, reversing the order results in different vectors:

$$\begin{bmatrix} 4 \\ 7 \end{bmatrix} \neq \begin{bmatrix} 7 \\ 4 \end{bmatrix}$$

### Vector Addition

Given two vectors $\mathbf{u}$ and $\mathbf{v}$ in $\mathbb{R}^2$, their sum $\mathbf{u} + \mathbf{v}$ is obtained by adding corresponding entries of $\mathbf{u}$ and $\mathbf{v}$.

>[!summary] Definition: Vector Addition
> $$\mathbf{u} + \mathbf{v} = \begin{bmatrix} u_1 \\ u_2 \end{bmatrix} + \begin{bmatrix} v_1 \\ v_2 \end{bmatrix} = \begin{bmatrix} u_1 + v_1 \\ u_2 + v_2 \end{bmatrix}$$
>
> **Breakdown:**
> - $\mathbf{u}, \mathbf{v}$ : The vectors in $\mathbb{R}^2$ being added together.
> - $\mathbf{u} + \mathbf{v}$ : The resulting sum vector in $\mathbb{R}^2$.
> - $u_1 + v_1$ : The sum of the first entries.
> - $u_2 + v_2$ : The sum of the second entries.

>[!example] Example: Vector Addition
> Given $\mathbf{u} = \begin{bmatrix} 1 \\ -2 \end{bmatrix}$ and $\mathbf{v} = \begin{bmatrix} 2 \\ 5 \end{bmatrix}$:
> 
> $$\mathbf{u} + \mathbf{v} = \begin{bmatrix} 1 \\ -2 \end{bmatrix} + \begin{bmatrix} 2 \\ 5 \end{bmatrix} = \begin{bmatrix} 1 + 2 \\ -2 + 5 \end{bmatrix} = \begin{bmatrix} 3 \\ 3 \end{bmatrix}$$

### Scalar Multiplication

Given a vector $\mathbf{u}$ and a real number $c$, the **scalar multiple** of $\mathbf{u}$ by $c$ is the vector $c\mathbf{u}$ obtained by multiplying each entry in $\mathbf{u}$ by $c$.

>[!summary] Definition: Scalar Multiplication
> $$c\mathbf{u} = c \begin{bmatrix} u_1 \\ u_2 \end{bmatrix} = \begin{bmatrix} c u_1 \\ c u_2 \end{bmatrix}$$
>
> **Breakdown:**
> - $c$ : The scalar (a real number multiplier).
> - $\mathbf{u}$ : The vector being scaled.
> - $c\mathbf{u}$ : The resulting scaled vector.
> - $c u_1, c u_2$ : Each entry of $\mathbf{u}$ scaled by $c$.

The number $c$ in $c\mathbf{u}$ is called a _scalar_; it is written in lightface type to distinguish it from the boldface vector $\mathbf{u}$.

>[!example] Example: Scalar Multiplication
> If $\mathbf{u} = \begin{bmatrix} 3 \\ -1 \end{bmatrix}$ and $c = 5$:
> 
> $$c\mathbf{u} = 5 \begin{bmatrix} 3 \\ -1 \end{bmatrix} = \begin{bmatrix} 5(3) \\ 5(-1) \end{bmatrix} = \begin{bmatrix} 15 \\ -5 \end{bmatrix}$$

The operations of scalar multiplication and vector addition can be combined to form more complex algebraic expressions.

>[!example] Example: Combined Vector Operations
> Given $\mathbf{u} = \begin{bmatrix} 1 \\ -2 \end{bmatrix}$ and $\mathbf{v} = \begin{bmatrix} 2 \\ -5 \end{bmatrix}$, find $4\mathbf{u}$, $(-3)\mathbf{v}$, and $4\mathbf{u} + (-3)\mathbf{v}$.
>
> **Solution:**
> 1. Compute scalar multiple $4\mathbf{u}$:
>    $$4\mathbf{u} = 4 \begin{bmatrix} 1 \\ -2 \end{bmatrix} = \begin{bmatrix} 4 \\ -8 \end{bmatrix}$$
>
> 2. Compute scalar multiple $(-3)\mathbf{v}$:
>    $$(-3)\mathbf{v} = -3 \begin{bmatrix} 2 \\ -5 \end{bmatrix} = \begin{bmatrix} -6 \\ 15 \end{bmatrix}$$
>
> 3. Add the two results:
>    $$4\mathbf{u} + (-3)\mathbf{v} = \begin{bmatrix} 4 \\ -8 \end{bmatrix} + \begin{bmatrix} -6 \\ 15 \end{bmatrix} = \begin{bmatrix} 4 + (-6) \\ -8 + 15 \end{bmatrix} = \begin{bmatrix} -2 \\ 7 \end{bmatrix}$$

### Notation Conventions

For convenience and compactness, a column vector such as $\begin{bmatrix} 3 \\ -1 \end{bmatrix}$ can be written in the inline form $(3, -1)$.

In this notation, the parentheses and comma distinguish the column vector $(3, -1)$ from the $1 \times 2$ row matrix $\begin{bmatrix} 3 & -1 \end{bmatrix}$, which is written with brackets and no comma.

>[!note] Distinction Between Column Vectors and Row Matrices
> $$\begin{bmatrix} 3 \\ -1 \end{bmatrix} \neq \begin{bmatrix} 3 & -1 \end{bmatrix}$$
> Although they contain the same entries in the same sequence, they are not equal because their matrix shapes (dimensions) are different.

## Geometric Descriptions of R2

Consider a rectangular coordinate system in the plane. Because each point in the plane is determined by an ordered pair of numbers, a geometric point $(a, b)$ can be identified directly with the column vector $\begin{bmatrix} a \\ b \end{bmatrix}$. Consequently, $\mathbb{R}^2$ can be regarded as the set of all points in the Cartesian plane.
![[Pasted image 20260915191904.png]]
FIGURE 1 Vectors as points.
![[Pasted image 20260915191912.png]]
FIGURE 2 Vectors with arrows.

>[!info] Geometric Visualizations of Vectors
> Vectors in $\mathbb{R}^2$ are commonly represented in two equivalent geometric forms:
> 
> 1. **As Points:** The vector $\begin{bmatrix} a \\ b \end{bmatrix}$ corresponds to the coordinate point $(a, b)$ in the plane.
> 2. **As Arrows (Directed Line Segments):** The vector $\begin{bmatrix} a \\ b \end{bmatrix}$ is visualized as an arrow directed from the origin $(0, 0)$ to the point $(a, b)$.

When a vector is drawn as an arrow from the origin $(0, 0)$ to $(a, b)$, the directed segment visualizes both magnitude and direction; the individual points along the line segment itself have no independent mathematical significance.

The sum of two vectors also possesses a direct geometric representation, which can be verified using analytic geometry.

### Parallelogram Rule for Addition

If $\mathbf{u}$ and $\mathbf{v}$ in $\mathbb{R}^2$ are represented as points in the plane, vector addition corresponds geometrically to constructing a parallelogram.

>[!summary] Rule: Parallelogram Rule for Addition
> If $\mathbf{u}$ and $\mathbf{v}$ in $\mathbb{R}^2$ are represented as points in the plane, then $\mathbf{u} + \mathbf{v}$ corresponds to the fourth vertex of the parallelogram whose other vertices are $\mathbf{u}$, $\mathbf{0}$, and $\mathbf{v}$.
>
> **breakdown**:
> - $\mathbf{u}, \mathbf{v}$ : Vectors drawn from the origin $(0, 0)$ that form two adjacent sides of the parallelogram.
> - $\mathbf{0}$ : The origin vertex $(0, 0)$.
> - $\mathbf{u} + \mathbf{v}$ : The vertex directly opposite the origin, corresponding to the endpoint of the main diagonal.
>   ![[Pasted image 20260915192129.png]]
>   FIGURE 3 The parallelogram rule.

>[!example] Example: Applying the Parallelogram Rule
> Given the vectors:
> $$\mathbf{u} = \begin{bmatrix} 2 \\ 2 \end{bmatrix}, \quad \mathbf{v} = \begin{bmatrix} -6 \\ 1 \end{bmatrix}$$
>
> Their sum is:
> $$\mathbf{u} + \mathbf{v} = \begin{bmatrix} 2 + (-6) \\ 2 + 1 \end{bmatrix} = \begin{bmatrix} -4 \\ 3 \end{bmatrix}$$
>
> In the coordinate plane, the points $(0, 0)$, $(2, 2)$, $(-6, 1)$, and $(-4, 3)$ form the four vertices of a parallelogram.
> ![[Pasted image 20260915192149.png]]
> FIGURE 4

---

### Geometric Behavior of Scalar Multiples

The set of all scalar multiples of one fixed nonzero vector forms a straight line passing through the origin $(0, 0)$.

For any scalar $c$ and vector $\mathbf{u}$:
- The length of the arrow representing $c\mathbf{u}$ is $|c|$ times the length of the arrow for $\mathbf{u}$.
- The length of a line segment from $(0, 0)$ to $(a, b)$ is calculated as:
  $$\text{Length} = \sqrt{a^2 + b^2}$$
- **Direction:**
  - If $c > 0$, the vector $c\mathbf{u}$ points in the **same direction** as $\mathbf{u}$.
  - If $c < 0$, the vector $c\mathbf{u}$ points in the **opposite direction** of $\mathbf{u}$.

>[!example] Example: Scalar Multiples of a Vector
> Let $\mathbf{u} = \begin{bmatrix} 3 \\ -1 \end{bmatrix}$. Determine the vectors $2\mathbf{u}$ and $-\frac{2}{3}\mathbf{u}$:
>
> 1. **Calculate $2\mathbf{u}$:**
>    $$2\mathbf{u} = 2 \begin{bmatrix} 3 \\ -1 \end{bmatrix} = \begin{bmatrix} 6 \\ -2 \end{bmatrix}$$
>    The arrow for $2\mathbf{u}$ is twice as long as the arrow for $\mathbf{u}$ and points in the same direction.
>
> 2. **Calculate $-\frac{2}{3}\mathbf{u}$:**
>    $$-\frac{2}{3}\mathbf{u} = -\frac{2}{3} \begin{bmatrix} 3 \\ -1 \end{bmatrix} = \begin{bmatrix} -2 \\ 2/3 \end{bmatrix}$$
>    The arrow for $-\frac{2}{3}\mathbf{u}$ is two-thirds the length of the arrow for $\mathbf{u}$ and points in the exact opposite direction.
>    ![[Pasted image 20260915192216.png]]
>    FIGURE 5

## Vectors in R3

Vectors in $\mathbb{R}^3$ are $3 \times 1$ column matrices with three real entries. Geometrically, they are represented by points in a three-dimensional coordinate space, visualized as arrows directed from the origin $(0, 0, 0)$ to the corresponding coordinate point $(x_1, x_2, x_3)$.

$$\mathbf{a} = \begin{bmatrix} a_1 \\ a_2 \\ a_3 \end{bmatrix}$$

Scalar multiples in $\mathbb{R}^3$ scale the length of the vector in three dimensions along the line passing through the origin and the point $(a_1, a_2, a_3)$.

---

## Vectors in Rn

If $n$ is a positive integer, $\mathbb{R}^n$ (read "_r-n_") denotes the collection of all ordered lists (or ordered $n$-tuples) of $n$ real numbers, written as $n \times 1$ column matrices.

>[!summary] Definition: Vector in $\mathbb{R}^n$
> An $n$-dimensional column vector $\mathbf{u} \in \mathbb{R}^n$ is written as:
> $$\mathbf{u} = \begin{bmatrix} u_1 \\ u_2 \\ \vdots \\ u_n \end{bmatrix}$$
>
> **breakdown**:
> - $\mathbb{R}^n$ : The set of all $n \times 1$ column vectors with real entries.
> - $n$ : The dimension of the vector space (number of entries).
> - $\mathbf{u}$ : The vector in $\mathbb{R}^n$.
> - $u_i$ : The $i$-th component (entry) of the vector, where $i \in \{1, 2, \dots, n\}$.

The vector whose entries are all zero is called the **zero vector** and is denoted by $\mathbf{0}$:

$$\mathbf{0} = \begin{bmatrix} 0 \\ 0 \\ \vdots \\ 0 \end{bmatrix}$$

Equality of vectors, scalar multiplication, and vector addition in $\mathbb{R}^n$ are defined entry by entry, exactly as in $\mathbb{R}^2$.
![[Pasted image 20260915192747.png]]
FIGURE 6 Scalar multiples.

---

### Algebraic Properties of Rn

Vector operations in $\mathbb{R}^n$ satisfy the standard algebraic properties inherited directly from the arithmetic of real numbers.

>[!summary] Theorem: Algebraic Properties of $\mathbb{R}^n$
> For all vectors $\mathbf{u}, \mathbf{v}, \mathbf{w} \in \mathbb{R}^n$ and all scalars $c, d \in \mathbb{R}$:
> 1. $\mathbf{u} + \mathbf{v} = \mathbf{v} + \mathbf{u}$ _(Commutativity)_
> 2. $(\mathbf{u} + \mathbf{v}) + \mathbf{w} = \mathbf{u} + (\mathbf{v} + \mathbf{w})$ _(Associativity)_
> 3. $\mathbf{u} + \mathbf{0} = \mathbf{0} + \mathbf{u} = \mathbf{u}$ _(Additive Identity)_
> 4. $\mathbf{u} + (-\mathbf{u}) = -\mathbf{u} + \mathbf{u} = \mathbf{0}$, where $-\mathbf{u} = (-1)\mathbf{u}$ _(Additive Inverse)_
> 5. $c(\mathbf{u} + \mathbf{v}) = c\mathbf{u} + c\mathbf{v}$ _(Distributivity over vector addition)_
> 6. $(c + d)\mathbf{u} = c\mathbf{u} + d\mathbf{u}$ _(Distributivity over scalar addition)_
> 7. $c(d\mathbf{u}) = (cd)\mathbf{u}$ _(Scalar Associativity)_
> 8. $1\mathbf{u} = \mathbf{u}$ _(Multiplicative Identity)_
>
> **breakdown**:
> - $\mathbf{u}, \mathbf{v}, \mathbf{w}$ : Vectors in $\mathbb{R}^n$.
> - $c, d$ : Real scalars.
> - $\mathbf{0}$ : The $n \times 1$ zero vector.
> - $-\mathbf{u}$ : The additive inverse of $\mathbf{u}$.

Vector subtraction is defined as the addition of the additive inverse:

$$\mathbf{u} - \mathbf{v} = \mathbf{u} + (-1)\mathbf{v}$$
![[Pasted image 20260915192846.png]]
FIGURE 7 Vector subtraction.

---

## Linear Combinations

>[!summary] Definition: Linear Combination
> Given vectors $\mathbf{v}_1, \mathbf{v}_2, \dots, \mathbf{v}_p$ in $\mathbb{R}^n$ and scalars $c_1, c_2, \dots, c_p$, the vector $\mathbf{y}$ defined by:
> $$\mathbf{y} = c_1\mathbf{v}_1 + c_2\mathbf{v}_2 + \dots + c_p\mathbf{v}_p$$
> is called a **linear combination** of $\mathbf{v}_1, \dots, \mathbf{v}_p$ with **weights** $c_1, \dots, c_p$.
>
> **breakdown**:
> - $\mathbf{y}$ : The resulting linear combination vector in $\mathbb{R}^n$.
> - $\mathbf{v}_1, \dots, \mathbf{v}_p$ : The collection of given vectors in $\mathbb{R}^n$.
> - $c_1, \dots, c_p$ : The scalar weights applied to each respective vector (can be any real numbers, including zero).

Examples of linear combinations using vectors $\mathbf{v}_1$ and $\mathbf{v}_2$:
- $\sqrt{3}\mathbf{v}_1 + \mathbf{v}_2$
- $\frac{1}{2}\mathbf{v}_1 = \frac{1}{2}\mathbf{v}_1 + 0\mathbf{v}_2$
- $\mathbf{0} = 0\mathbf{v}_1 + 0\mathbf{v}_2$

>[!example] Example: Geometric Interpretation of Linear Combinations
> Given $\mathbf{v}_1 = \begin{bmatrix} 1 \\ 1 \end{bmatrix}$ and $\mathbf{v}_2 = \begin{bmatrix} -2 \\ 1 \end{bmatrix}$:
> 
> A vector $\mathbf{u}$ can be expressed as a linear combination by decomposing its displacement into components parallel to $\mathbf{v}_1$ and $\mathbf{v}_2$:
> $$\mathbf{u} = 3\mathbf{v}_1 - 2\mathbf{v}_2$$
> 
> Geometrically, this represents traveling from the origin $3$ units in the direction of $\mathbf{v}_1$, and then $2$ units in the direction of $-\mathbf{v}_2$.
> 
> Similarly, a point situated intermediate to grid increments might be generated as:
> $$\mathbf{w} = \frac{5}{2}\mathbf{v}_1 - \frac{1}{2}\mathbf{v}_2$$
> ![[Pasted image 20260915192959.png]]
> FIGURE 8 Linear combinations of v1 and v2.

---

### Connecting Linear Combinations to Systems of Equations

Determining whether a given vector can be expressed as a linear combination of other vectors translates directly into solving a system of linear equations.

>[!example] Example: Solving a Vector Equation
> Let $\mathbf{a}_1 = \begin{bmatrix} 1 \\ -2 \\ -5 \end{bmatrix}$, $\mathbf{a}_2 = \begin{bmatrix} 2 \\ 5 \\ 6 \end{bmatrix}$, and $\mathbf{b} = \begin{bmatrix} 7 \\ 4 \\ -3 \end{bmatrix}$. 
> 
> Determine whether $\mathbf{b}$ can be written as a linear combination of $\mathbf{a}_1$ and $\mathbf{a}_2$ such that:
> $$x_1\mathbf{a}_1 + x_2\mathbf{a}_2 = \mathbf{b}$$
>
> **Solution:**
> 1. Expand the vector equation:
>    $$x_1 \begin{bmatrix} 1 \\ -2 \\ -5 \end{bmatrix} + x_2 \begin{bmatrix} 2 \\ 5 \\ 6 \end{bmatrix} = \begin{bmatrix} 7 \\ 4 \\ -3 \end{bmatrix} \implies \begin{bmatrix} x_1 + 2x_2 \\ -2x_1 + 5x_2 \\ -5x_1 + 6x_2 \end{bmatrix} = \begin{bmatrix} 7 \\ 4 \\ -3 \end{bmatrix}$$
>
> 2. Form the equivalent linear system:
>    $$\begin{aligned}
>    x_1 + 2x_2 &= 7 \\
>    -2x_1 + 5x_2 &= 4 \\
>    -5x_1 + 6x_2 &= -3
>    \end{aligned}$$
>
> 3. Construct and row reduce the augmented matrix:
>    $$\begin{bmatrix} 1 & 2 & 7 \\ -2 & 5 & 4 \\ -5 & 6 & -3 \end{bmatrix} \sim \begin{bmatrix} 1 & 2 & 7 \\ 0 & 9 & 18 \\ 0 & 16 & 32 \end{bmatrix} \sim \begin{bmatrix} 1 & 2 & 7 \\ 0 & 1 & 2 \\ 0 & 16 & 32 \end{bmatrix} \sim \begin{bmatrix} 1 & 0 & 3 \\ 0 & 1 & 2 \\ 0 & 0 & 0 \end{bmatrix}$$
>
> 4. Read the solution:
>    $$x_1 = 3, \quad x_2 = 2$$
>
> Thus, $\mathbf{b}$ is a linear combination of $\mathbf{a}_1$ and $\mathbf{a}_2$:
> $$3\mathbf{a}_1 + 2\mathbf{a}_2 = \mathbf{b}$$

>[!info] Equivalence of Vector Equations and Linear Systems
> A vector equation:
> $$x_1\mathbf{a}_1 + x_2\mathbf{a}_2 + \dots + x_n\mathbf{a}_n = \mathbf{b}$$
> has the exact same solution set as the linear system whose augmented matrix is:
> $$\begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n & \mathbf{b} \end{bmatrix}$$
> 
> In particular, $\mathbf{b}$ can be generated by a linear combination of $\mathbf{a}_1, \dots, \mathbf{a}_n$ if and only if there exists a solution to this linear system.

---

### Span of a Set of Vectors

>[!summary] Definition: Span
> If $\mathbf{v}_1, \dots, \mathbf{v}_p$ are in $\mathbb{R}^n$, then the set of all linear combinations of $\mathbf{v}_1, \dots, \mathbf{v}_p$ is denoted by $\text{Span}\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ and is called the **subset of $\mathbb{R}^n$ spanned (or generated) by $\mathbf{v}_1, \dots, \mathbf{v}_p$**:
> $$\text{Span}\{\mathbf{v}_1, \dots, \mathbf{v}_p\} = \{c_1\mathbf{v}_1 + c_2\mathbf{v}_2 + \dots + c_p\mathbf{v}_p \mid c_1, \dots, c_p \in \mathbb{R}\}$$
>
> **breakdown**:
> - $\text{Span}\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ : The subspace generated by the collection of vectors.
> - $c_i$ : Arbitrary real scalars.
> - $\mathbf{v}_i$ : Generating vectors.

- Asking whether a vector $\mathbf{b}$ is in $\text{Span}\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ is equivalent to asking whether the vector equation $x_1\mathbf{v}_1 + \dots + x_p\mathbf{v}_p = \mathbf{b}$ has a solution (i.e., whether the augmented matrix $[\mathbf{v}_1 \dots \mathbf{v}_p \mid \mathbf{b}]$ is consistent).
- $\text{Span}\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ always contains every individual scalar multiple of each vector, including the zero vector $\mathbf{0}$ (when all weights are set to $0$).

---

## A Geometric Description of Span{v} and Span{u, v}

Let $\mathbf{v}$ and $\mathbf{u}$ be vectors in $\mathbb{R}^3$:

1. **$\text{Span}\{\mathbf{v}\}$ (Single Nonzero Vector):**
   - Represents the set of all scalar multiples $c\mathbf{v}$.
   - Geometrically forms a **straight line** in $\mathbb{R}^3$ passing through the origin $\mathbf{0}$ and $\mathbf{v}$.
     ![[Pasted image 20260915193139.png]]
FIGURE 10 Span fvg as a line through the origin.
2. **$\text{Span}\{\mathbf{u}, \mathbf{v}\}$ (Two Nonzero, Non-Collinear Vectors):**
   - Represents all linear combinations $c_1\mathbf{u} + c_2\mathbf{v}$.
   - Geometrically forms a **plane** in $\mathbb{R}^3$ passing through the origin $\mathbf{0}$, containing the vectors $\mathbf{u}$ and $\mathbf{v}$, as well as the lines $\text{Span}\{\mathbf{u}\}$ and $\text{Span}\{\mathbf{v}\}$.
     ![[Pasted image 20260915193149.png]]
FIGURE 11 Span fu; vg as a plane through the origin.

>[!example] Example: Determining Membership in a Span
> Let $\mathbf{a}_1 = \begin{bmatrix} 1 \\ -2 \\ 3 \end{bmatrix}$, $\mathbf{a}_2 = \begin{bmatrix} 5 \\ -13 \\ -3 \end{bmatrix}$, and $\mathbf{b} = \begin{bmatrix} -3 \\ 8 \\ 1 \end{bmatrix}$. 
> 
> Determine if $\mathbf{b}$ lies in $\text{Span}\{\mathbf{a}_1, \mathbf{a}_2\}$ (the plane formed by $\mathbf{a}_1$ and $\mathbf{a}_2$).
>
> **Solution:**
> Check if $x_1\mathbf{a}_1 + x_2\mathbf{a}_2 = \mathbf{b}$ is consistent by row reducing the augmented matrix:
> $$\begin{bmatrix} 1 & 5 & -3 \\ -2 & -13 & 8 \\ 3 & -3 & 1 \end{bmatrix} \sim \begin{bmatrix} 1 & 5 & -3 \\ 0 & -3 & 2 \\ 0 & -18 & 10 \end{bmatrix} \sim \begin{bmatrix} 1 & 5 & -3 \\ 0 & -3 & 2 \\ 0 & 0 & -2 \end{bmatrix}$$
>
> The third row corresponds to the equation $0 = -2$, which is impossible. Therefore, the system is inconsistent, and $\mathbf{b}$ is **not** in $\text{Span}\{\mathbf{a}_1, \mathbf{a}_2\}$.

---

## Linear Combinations in Applications

Linear combinations provide a systematic method to account for multi-category quantities, such as allocated production costs across materials, labor, and overhead.

$$\text{Total Cost} = (\text{Number of Units}) \times (\text{Cost per Unit})$$

>[!example] Example: Multi-Category Production Costs
> A company manufactures two products, $B$ and $C$. The costs per dollar of output across materials, labor, and overhead are summarized as vectors:
> $$\mathbf{b} = \begin{bmatrix} 0.45 \\ 0.25 \\ 0.15 \end{bmatrix}, \quad \mathbf{c} = \begin{bmatrix} 0.40 \\ 0.30 \\ 0.15 \end{bmatrix}$$
>
> 1. **Economic Interpretation of $100\mathbf{b}$:**
>    $$100\mathbf{b} = 100 \begin{bmatrix} 0.45 \\ 0.25 \\ 0.15 \end{bmatrix} = \begin{bmatrix} 45 \\ 25 \\ 15 \end{bmatrix}$$
>    This vector represents the specific costs required to produce $\$100$ worth of product $B$: $\$45$ for materials, $\$25$ for labor, and $\$15$ for overhead.
>
> 2. **Total Cost for Combined Production:**
>    If the company produces $x_1$ dollars worth of product $B$ and $x_2$ dollars worth of product $C$, the overall categorized cost is given by the linear combination:
>    $$\mathbf{x}_{\text{total}} = x_1\mathbf{b} + x_2\mathbf{c}$$

# The Matrix Equation Ax = b

A fundamental concept in linear algebra is viewing a linear combination of vectors as the product of a matrix and a vector. This algebraic framework allows vector equations and systems of linear equations to be expressed compactly.

>[!summary] Definition: Product of a Matrix and a Vector
> If $A$ is an $m \times n$ matrix with columns $\mathbf{a}_1, \mathbf{a}_2, \dots, \mathbf{a}_n$, and if $\mathbf{x}$ is a vector in $\mathbb{R}^n$, then the **product of $A$ and $\mathbf{x}$**, denoted by $A\mathbf{x}$, is the linear combination of the columns of $A$ using the corresponding entries in $\mathbf{x}$ as weights:
> 
> $$A\mathbf{x} = \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \\ \vdots \\ x_n \end{bmatrix} = x_1\mathbf{a}_1 + x_2\mathbf{a}_2 + \dots + x_n\mathbf{a}_n$$
>
> **breakdown**:
> - $A$ : An $m \times n$ matrix having $m$ rows and $n$ columns.
> - $\mathbf{a}_1, \mathbf{a}_2, \dots, \mathbf{a}_n$ : The $n$ column vectors of matrix $A$, each containing $m$ entries (vectors in $\mathbb{R}^m$).
> - $\mathbf{x}$ : An $n \times 1$ column vector in $\mathbb{R}^n$.
> - $x_1, x_2, \dots, x_n$ : The scalar entries (weights) of the vector $\mathbf{x}$.
> - $A\mathbf{x}$ : The resulting vector in $\mathbb{R}^m$.

>[!warning] Dimension Compatibility Requirement
> The product $A\mathbf{x}$ is defined **only if** the number of columns in the matrix $A$ equals the number of entries (dimension) in the vector $\mathbf{x}$.

>[!example] Example: Computing Matrix-Vector Products
> **a.** Compute the product of a $2 \times 3$ matrix and a vector in $\mathbb{R}^3$:
> $$\begin{bmatrix} 1 & 2 & -1 \\ 0 & -5 & 3 \end{bmatrix} \begin{bmatrix} 4 \\ 3 \\ 7 \end{bmatrix} = 4 \begin{bmatrix} 1 \\ 0 \end{bmatrix} + 3 \begin{bmatrix} 2 \\ -5 \end{bmatrix} + 7 \begin{bmatrix} -1 \\ 3 \end{bmatrix} = \begin{bmatrix} 4 \\ 0 \end{bmatrix} + \begin{bmatrix} 6 \\ -15 \end{bmatrix} + \begin{bmatrix} -7 \\ 21 \end{bmatrix} = \begin{bmatrix} 3 \\ 6 \end{bmatrix}$$
>
> **b.** Compute the product of a $3 \times 2$ matrix and a vector in $\mathbb{R}^2$:
> $$\begin{bmatrix} 2 & -3 \\ 8 & 0 \\ -5 & 2 \end{bmatrix} \begin{bmatrix} 4 \\ 7 \end{bmatrix} = 4 \begin{bmatrix} 2 \\ 8 \\ -5 \end{bmatrix} + 7 \begin{bmatrix} -3 \\ 0 \\ 2 \end{bmatrix} = \begin{bmatrix} 8 \\ 32 \\ -20 \end{bmatrix} + \begin{bmatrix} -21 \\ 0 \\ 14 \end{bmatrix} = \begin{bmatrix} -13 \\ 32 \\ -6 \end{bmatrix}$$

>[!example] Example: Writing a Linear Combination as a Matrix-Vector Product
> For vectors $\mathbf{v}_1, \mathbf{v}_2, \mathbf{v}_3 \in \mathbb{R}^m$, express the linear combination $3\mathbf{v}_1 - 5\mathbf{v}_2 + 7\mathbf{v}_3$ as a matrix multiplied by a vector:
> 
> Place $\mathbf{v}_1, \mathbf{v}_2, \mathbf{v}_3$ into the columns of a matrix $A$ and place the scalars into a vector $\mathbf{x}$:
> $$3\mathbf{v}_1 - 5\mathbf{v}_2 + 7\mathbf{v}_3 = \begin{bmatrix} \mathbf{v}_1 & \mathbf{v}_2 & \mathbf{v}_3 \end{bmatrix} \begin{bmatrix} 3 \\ -5 \\ 7 \end{bmatrix} = A\mathbf{x}$$

---

### Equivalence of Systems, Vector Equations, and Matrix Equations

A linear system of equations can be translated directly into an equivalent vector equation, which can then be written as a compact matrix equation. For example, the system:

$$\begin{aligned}
x_1 + 2x_2 - x_3 &= 4 \\
-5x_2 + 3x_3 &= 1
\end{aligned}$$

is equivalent to the vector equation:

$$x_1 \begin{bmatrix} 1 \\ 0 \end{bmatrix} + x_2 \begin{bmatrix} 2 \\ -5 \end{bmatrix} + x_3 \begin{bmatrix} -1 \\ 3 \end{bmatrix} = \begin{bmatrix} 4 \\ 1 \end{bmatrix}$$

Using the definition of a matrix-vector product, this linear combination on the left becomes:

$$\begin{bmatrix} 1 & 2 & -1 \\ 0 & -5 & 3 \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \\ x_3 \end{bmatrix} = \begin{bmatrix} 4 \\ 1 \end{bmatrix}$$

This has the form $A\mathbf{x} = \mathbf{b}$, where the matrix $A$ is the coefficient matrix of the original linear system.

>[!summary] Theorem: Equivalence of Matrix Equations, Vector Equations, and Systems
> If $A$ is an $m \times n$ matrix with columns $\mathbf{a}_1, \dots, \mathbf{a}_n$, and if $\mathbf{b}$ is in $\mathbb{R}^m$, the matrix equation:
> $$A\mathbf{x} = \mathbf{b}$$
> has the same solution set as the vector equation:
> $$x_1\mathbf{a}_1 + x_2\mathbf{a}_2 + \dots + x_n\mathbf{a}_n = \mathbf{b}$$
> which, in turn, has the same solution set as the system of linear equations whose augmented matrix is:
> $$\begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n & \mathbf{b} \end{bmatrix}$$
>
> **breakdown**:
> - $A$ : The $m \times n$ coefficient matrix.
> - $\mathbf{a}_1, \dots, \mathbf{a}_n$ : Column vectors of $A$ in $\mathbb{R}^m$.
> - $\mathbf{x}$ : Unknown column vector with entries $x_1, \dots, x_n$ in $\mathbb{R}^n$.
> - $\mathbf{b}$ : Target vector in $\mathbb{R}^m$.
> - $\begin{bmatrix} \mathbf{a}_1 & \dots & \mathbf{a}_n & \mathbf{b} \end{bmatrix}$ : The augmented matrix corresponding to the linear system.

This equivalence provides three interchangeable ways to view and model linear problems:
1. As a **matrix equation** ($A\mathbf{x} = \mathbf{b}$).
2. As a **vector equation** (a linear combination of column vectors equal to $\mathbf{b}$).
3. As a **system of linear equations**.

All three formulations are solved uniformly by row reducing the augmented matrix $\begin{bmatrix} A & \mathbf{b} \end{bmatrix}$.

---

## Existence of Solutions

The equation $A\mathbf{x} = \mathbf{b}$ has a solution **if and only if** $\mathbf{b}$ is a linear combination of the columns of $A$ (i.e., $\mathbf{b} \in \text{Span}\{\mathbf{a}_1, \dots, \mathbf{a}_n\}$).

>[!example] Example: Determining Consistency for All Possible Vectors
> Let $A = \begin{bmatrix} 1 & 3 & 4 \\ -4 & 2 & -6 \\ -3 & -2 & -7 \end{bmatrix}$ and $\mathbf{b} = \begin{bmatrix} b_1 \\ b_2 \\ b_3 \end{bmatrix}$. Determine whether $A\mathbf{x} = \mathbf{b}$ is consistent for all possible values of $b_1, b_2, b_3$.
>
> **Solution:**
> Row reduce the augmented matrix:
> $$\begin{bmatrix} 1 & 3 & 4 & b_1 \\ -4 & 2 & -6 & b_2 \\ -3 & -2 & -7 & b_3 \end{bmatrix} \sim \begin{bmatrix} 1 & 3 & 4 & b_1 \\ 0 & 14 & 10 & b_2 + 4b_1 \\ 0 & 7 & 5 & b_3 + 3b_1 \end{bmatrix} \sim \begin{bmatrix} 1 & 3 & 4 & b_1 \\ 0 & 14 & 10 & b_2 + 4b_1 \\ 0 & 0 & 0 & b_1 - \frac{1}{2}b_2 + b_3 \end{bmatrix}$$
>
> The third row corresponds to the equation:
> $$0 = b_1 - \frac{1}{2}b_2 + b_3$$
> 
> The system is **not** consistent for every $\mathbf{b}$ because any vector whose components make $b_1 - \frac{1}{2}b_2 + b_3 \neq 0$ creates an inconsistent row of the form $\begin{bmatrix} 0 & 0 & 0 & k \end{bmatrix}$ (where $k \neq 0$). 
> 
> The equation $A\mathbf{x} = \mathbf{b}$ is consistent only for vectors $\mathbf{b}$ that satisfy $b_1 - \frac{1}{2}b_2 + b_3 = 0$, which defines a plane through the origin in $\mathbb{R}^3$.

A set of vectors $\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ in $\mathbb{R}^m$ **spans** $\mathbb{R}^m$ if every vector in $\mathbb{R}^m$ can be written as a linear combination of $\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$; that is, $\text{Span}\{\mathbf{v}_1, \dots, \mathbf{v}_p\} = \mathbb{R}^m$.

![[Pasted image 20260915194651.png]]
FIGURE 1 The columns of A D Œ a1 a2 a3  span a plane through 0.

>[!summary] Theorem: Logically Equivalent Conditions for Spanning $\mathbb{R}^m$
> Let $A$ be an $m \times n$ matrix. Then the following statements are logically equivalent:
> a. For each $\mathbf{b} \in \mathbb{R}^m$, the equation $A\mathbf{x} = \mathbf{b}$ has a solution.
> b. Each $\mathbf{b} \in \mathbb{R}^m$ is a linear combination of the columns of $A$.
> c. The columns of $A$ span $\mathbb{R}^m$.
> d. $A$ has a pivot position in every row.
>
> **breakdown**:
> - $A$ : The $m \times n$ coefficient matrix.
> - $m$ : Number of rows (dimension of target space $\mathbb{R}^m$).
> - $n$ : Number of columns (number of spanning vectors).
> - Pivot in every row: Guarantees that the echelon form has no all-zero rows, preventing inconsistent equations of the form $0 = d_i$ with $d_i \neq 0$.
>
> **proof**:
> Statements (a), (b), and (c) are equivalent by definition of matrix-vector multiplication and the definition of span. 
> 
> To show (a) and (d) are equivalent, let $U$ be an echelon form of $A$. Row reducing the augmented matrix yields:
> $$\begin{bmatrix} A & \mathbf{b} \end{bmatrix} \sim \begin{bmatrix} U & \mathbf{d} \end{bmatrix}$$
> - If statement (d) is true, each row of $U$ contains a pivot position. Therefore, no pivot position can lie in the augmented column $\mathbf{d}$, which ensures that $A\mathbf{x} = \mathbf{b}$ is consistent for every $\mathbf{b}$. Thus, (a) is true.
> - If statement (d) is false, the bottom row of $U$ contains only zeros. Choosing a vector $\mathbf{d}$ with a non-zero last entry produces an inconsistent row $\begin{bmatrix} 0 & \dots & 0 & d_m \end{bmatrix}$. Reversing the row operations yields a vector $\mathbf{b}$ for which $A\mathbf{x} = \mathbf{b}$ has no solution. Thus, (a) is false.

>[!warning] Warning: Coefficient Matrix vs. Augmented Matrix
> This spanning theorem applies exclusively to the **coefficient matrix** $A$, not the augmented matrix $\begin{bmatrix} A & \mathbf{b} \end{bmatrix}$. Having a pivot position in every row of an augmented matrix does not guarantee consistency, as the pivot could be in the rightmost augmented column.

---

## Computation of Ax

Expanding a matrix-vector product entry by entry reveals that each row calculation is a sum of products between row entries and vector entries.

>[!example] Example: Row-by-Row Evaluation
> Compute $A\mathbf{x}$ for $A = \begin{bmatrix} 2 & 3 & 4 \\ -1 & 5 & -3 \\ 6 & -2 & 8 \end{bmatrix}$ and $\mathbf{x} = \begin{bmatrix} x_1 \\ x_2 \\ x_3 \end{bmatrix}$:
> 
> $$A\mathbf{x} = x_1 \begin{bmatrix} 2 \\ -1 \\ 6 \end{bmatrix} + x_2 \begin{bmatrix} 3 \\ 5 \\ -2 \end{bmatrix} + x_3 \begin{bmatrix} 4 \\ -3 \\ 8 \end{bmatrix} = \begin{bmatrix} 2x_1 + 3x_2 + 4x_3 \\ -x_1 + 5x_2 - 3x_3 \\ 6x_1 - 2x_2 + 8x_3 \end{bmatrix}$$

### Row–Vector Rule for Computing Ax

>[!summary] Rule: Row–Vector Rule for Computing $A\mathbf{x}$
> If the product $A\mathbf{x}$ is defined, then the $i$-th entry in $A\mathbf{x}$ is the sum of the products of corresponding entries from row $i$ of $A$ and from the vector $\mathbf{x}$.

>[!example] Example: Applying the Row–Vector Rule
> **a.** 
> $$\begin{bmatrix} 1 & 2 & -1 \\ 0 & -5 & 3 \end{bmatrix} \begin{bmatrix} 4 \\ 3 \\ 7 \end{bmatrix} = \begin{bmatrix} (1)(4) + (2)(3) + (-1)(7) \\ (0)(4) + (-5)(3) + (3)(7) \end{bmatrix} = \begin{bmatrix} 3 \\ 6 \end{bmatrix}$$
>
> **b.** 
> $$\begin{bmatrix} 2 & -3 \\ 8 & 0 \\ -5 & 2 \end{bmatrix} \begin{bmatrix} 4 \\ 7 \end{bmatrix} = \begin{bmatrix} (2)(4) + (-3)(7) \\ (8)(4) + (0)(7) \\ (-5)(4) + (2)(7) \end{bmatrix} = \begin{bmatrix} -13 \\ 32 \\ -6 \end{bmatrix}$$
>
> **c.** 
> $$\begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} r \\ s \\ t \end{bmatrix} = \begin{bmatrix} 1(r) + 0(s) + 0(t) \\ 0(r) + 1(s) + 0(t) \\ 0(r) + 0(s) + 1(t) \end{bmatrix} = \begin{bmatrix} r \\ s \\ t \end{bmatrix}$$

An **identity matrix** $I$ (or $I_n$) is an $n \times n$ matrix with $1$s on the main diagonal and $0$s elsewhere. For every $\mathbf{x} \in \mathbb{R}^n$:

$$I_n\mathbf{x} = \mathbf{x}$$

---

## Properties of the Matrix–Vector Product Ax

>[!summary] Theorem: Algebraic Properties of $A\mathbf{x}$
> If $A$ is an $m \times n$ matrix, $\mathbf{u}$ and $\mathbf{v}$ are vectors in $\mathbb{R}^n$, and $c$ is a scalar, then:
> a. $A(\mathbf{u} + \mathbf{v}) = A\mathbf{u} + A\mathbf{v}$
> b. $A(c\mathbf{u}) = c(A\mathbf{u})$
>
> **breakdown**:
> - $A$ : An $m \times n$ transformation matrix.
> - $\mathbf{u}, \mathbf{v}$ : Vectors in $\mathbb{R}^n$.
> - $c$ : A real scalar.
> - Demonstrates that matrix-vector multiplication preserves vector addition (linearity) and scalar scaling.
>
> **proof**:
> Let $A = \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n \end{bmatrix}$, and let $u_i, v_i$ be the $i$-th components of $\mathbf{u}$ and $\mathbf{v}$.
> 
> For statement (a):
> $$\begin{aligned}
> A(\mathbf{u} + \mathbf{v}) &= \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n \end{bmatrix} \begin{bmatrix} u_1 + v_1 \\ \vdots \\ u_n + v_n \end{bmatrix} \\
> &= (u_1 + v_1)\mathbf{a}_1 + \dots + (u_n + v_n)\mathbf{a}_n \\
> &= (u_1\mathbf{a}_1 + \dots + u_n\mathbf{a}_n) + (v_1\mathbf{a}_1 + \dots + v_n\mathbf{a}_n) \\
> &= A\mathbf{u} + A\mathbf{v}
> \end{aligned}$$
> 
> For statement (b):
> $$\begin{aligned}
> A(c\mathbf{u}) &= \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n \end{bmatrix} \begin{bmatrix} cu_1 \\ \vdots \\ cu_n \end{bmatrix} \\
> &= (cu_1)\mathbf{a}_1 + \dots + (cu_n)\mathbf{a}_n \\
> &= c(u_1\mathbf{a}_1 + \dots + u_n\mathbf{a}_n) \\
> &= c(A\mathbf{u})
> \end{aligned}$$

>[!note] Numerical Optimization Note
> Efficient computational execution of $A\mathbf{x}$ depends on how matrix data is laid out in contiguous memory:
> - **Column-Major Languages (e.g., Fortran):** Matrix entries are stored column-by-column; algorithms compute $A\mathbf{x}$ as a linear combination of the columns of $A$.
> - **Row-Major Languages (e.g., C):** Matrix entries are stored row-by-row; algorithms compute $A\mathbf{x}$ using the row-vector dot product rule.

Solution sets of linear systems can be described explicitly and geometrically using vector notation.

---

## Homogeneous Linear Systems

A system of linear equations is said to be **homogeneous** if it can be written in the form:

$$A\mathbf{x} = \mathbf{0}$$

where $A$ is an $m \times n$ matrix and $\mathbf{0}$ is the zero vector in $\mathbb{R}^m$.

A homogeneous system $A\mathbf{x} = \mathbf{0}$ always possesses at least one solution: the zero vector $\mathbf{x} = \mathbf{0} \in \mathbb{R}^n$. This solution is called the **trivial solution**.

The primary question for a homogeneous system is whether there exists a **nontrivial solution**—that is, a nonzero vector $\mathbf{x}$ satisfying $A\mathbf{x} = \mathbf{0}$.

>[!info] Existence of Nontrivial Solutions
> The homogeneous equation $A\mathbf{x} = \mathbf{0}$ has a nontrivial solution **if and only if** the equation has at least one free variable.
> ![[Pasted image 20260915194941.png]]
> FIGURE 1

>[!example] Example: Solving a Homogeneous System
> Determine if the following homogeneous system has a nontrivial solution, and describe its solution set:
> $$\begin{aligned}
> 3x_1 + 5x_2 - 4x_3 &= 0 \\
> -3x_1 - 2x_2 + 4x_3 &= 0 \\
> 6x_1 + x_2 - 8x_3 &= 0
> \end{aligned}$$
>
> **Solution:**
> 1. Row reduce the augmented matrix $\begin{bmatrix} A & \mathbf{0} \end{bmatrix}$ to echelon form:
>    $$\begin{bmatrix} 3 & 5 & -4 & 0 \\ -3 & -2 & 4 & 0 \\ 6 & 1 & -8 & 0 \end{bmatrix} \sim \begin{bmatrix} 3 & 5 & -4 & 0 \\ 0 & 3 & 0 & 0 \\ 0 & -9 & 0 & 0 \end{bmatrix} \sim \begin{bmatrix} 3 & 5 & -4 & 0 \\ 0 & 3 & 0 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix}$$
>
> 2. Since $x_3$ has no pivot column, $x_3$ is a free variable. Thus, $A\mathbf{x} = \mathbf{0}$ has nontrivial solutions (one for each nonzero choice of $x_3$).
>
> 3. Continue row reduction to reduced echelon form:
>    $$\begin{bmatrix} 1 & 0 & -\frac{4}{3} & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix}$$
>
> 4. Solve for the basic variables in terms of the free variable $x_3$:
>    $$x_1 = \frac{4}{3}x_3, \quad x_2 = 0, \quad x_3 \text{ is free}$$
>
> 5. Express the general solution as a vector:
>    $$\mathbf{x} = \begin{bmatrix} x_1 \\ x_2 \\ x_3 \end{bmatrix} = \begin{bmatrix} \frac{4}{3}x_3 \\ 0 \\ x_3 \end{bmatrix} = x_3 \begin{bmatrix} \frac{4}{3} \\ 0 \\ 1 \end{bmatrix} = x_3 \mathbf{v}, \quad \text{where } \mathbf{v} = \begin{bmatrix} \frac{4}{3} \\ 0 \\ 1 \end{bmatrix}$$
>
> Every solution of $A\mathbf{x} = \mathbf{0}$ is a scalar multiple of $\mathbf{v}$. Geometrically, the solution set is a straight line through the origin $\mathbf{0}$ in $\mathbb{R}^3$.
> ![[Pasted image 20260915195001.png]]
> FIGURE 2

A nontrivial solution vector $\mathbf{x}$ can contain individual zero entries, as long as not all of its entries are zero.

>[!example] Example: Homogeneous Equation with Multiple Free Variables
> Describe all solutions of the single homogeneous equation:
> $$10x_1 - 3x_2 - 2x_3 = 0$$
>
> **Solution:**
> 1. Solve for the basic variable $x_1$ in terms of free variables $x_2$ and $x_3$:
>    $$x_1 = 0.3x_2 + 0.2x_3$$
>
> 2. Decompose the general solution vector $\mathbf{x}$:
>    $$\mathbf{x} = \begin{bmatrix} x_1 \\ x_2 \\ x_3 \end{bmatrix} = \begin{bmatrix} 0.3x_2 + 0.2x_3 \\ x_2 \\ x_3 \end{bmatrix} = \begin{bmatrix} 0.3x_2 \\ x_2 \\ 0 \end{bmatrix} + \begin{bmatrix} 0.2x_3 \\ 0 \\ x_3 \end{bmatrix} = x_2 \begin{bmatrix} 0.3 \\ 1 \\ 0 \end{bmatrix} + x_3 \begin{bmatrix} 0.2 \\ 0 \\ 1 \end{bmatrix} = x_2\mathbf{u} + x_3\mathbf{v}$$
>
> Every solution is a linear combination of $\mathbf{u} = \begin{bmatrix} 0.3 \\ 1 \\ 0 \end{bmatrix}$ and $\mathbf{v} = \begin{bmatrix} 0.2 \\ 0 \\ 1 \end{bmatrix}$. The solution set is $\text{Span}\{\mathbf{u}, \mathbf{v}\}$. Because $\mathbf{u}$ and $\mathbf{v}$ are not multiples of each other, this solution set geometrically forms a plane through the origin in $\mathbb{R}^3$.

The solution set of any homogeneous equation $A\mathbf{x} = \mathbf{0}$ can always be expressed explicitly as $\text{Span}\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$:
- If the only solution is the zero vector, the solution set is $\text{Span}\{\mathbf{0}\}$.
- If the system has **one free variable**, the solution set is a **line through the origin**.
- If the system has **two or more free variables**, the solution set is a **plane (or higher-dimensional subspace) through the origin**.

---

## Parametric Vector Form

An equation such as $10x_1 - 3x_2 - 2x_3 = 0$ provides an _implicit_ description of a geometric surface. Solving the system yields an _explicit_ description as a spanned set of vectors:

$$\mathbf{x} = s\mathbf{u} + t\mathbf{v} \quad (s, t \in \mathbb{R})$$

This representation is called a **parametric vector equation**, where $s$ and $t$ act as arbitrary real parameters. 

Whenever a solution set is described explicitly using decomposed vectors multiplied by free variables (or parameters), the solution is in **parametric vector form**.

---

## Solutions of Nonhomogeneous Systems

When a nonhomogeneous linear system $A\mathbf{x} = \mathbf{b}$ has infinitely many solutions, the general solution can be written in parametric vector form as a single particular solution vector plus an arbitrary linear combination of vectors that solve the corresponding homogeneous system $A\mathbf{x} = \mathbf{0}$.

>[!example] Example: Solving a Nonhomogeneous System
> Describe all solutions of $A\mathbf{x} = \mathbf{b}$, where:
> $$A = \begin{bmatrix} 3 & 5 & -4 \\ -3 & -2 & 4 \\ 6 & 1 & -8 \end{bmatrix}, \quad \mathbf{b} = \begin{bmatrix} 7 \\ -1 \\ -4 \end{bmatrix}$$
>
> **Solution:**
> 1. Row reduce the augmented matrix $\begin{bmatrix} A & \mathbf{b} \end{bmatrix}$:
>    $$\begin{bmatrix} 3 & 5 & -4 & 7 \\ -3 & -2 & 4 & -1 \\ 6 & 1 & -8 & -4 \end{bmatrix} \sim \begin{bmatrix} 1 & 0 & -\frac{4}{3} & -1 \\ 0 & 1 & 0 & 2 \\ 0 & 0 & 0 & 0 \end{bmatrix}$$
>
> 2. Express basic variables in terms of the free variable $x_3$:
>    $$x_1 = -1 + \frac{4}{3}x_3, \quad x_2 = 2, \quad x_3 \text{ is free}$$
>
> 3. Decompose the general solution into constant and variable components:
>    $$\mathbf{x} = \begin{bmatrix} x_1 \\ x_2 \\ x_3 \end{bmatrix} = \begin{bmatrix} -1 + \frac{4}{3}x_3 \\ 2 \\ x_3 \end{bmatrix} = \begin{bmatrix} -1 \\ 2 \\ 0 \end{bmatrix} + \begin{bmatrix} \frac{4}{3}x_3 \\ 0 \\ x_3 \end{bmatrix} = \begin{bmatrix} -1 \\ 2 \\ 0 \end{bmatrix} + x_3 \begin{bmatrix} \frac{4}{3} \\ 0 \\ 1 \end{bmatrix} = \mathbf{p} + t\mathbf{v}$$
>
> Here, $\mathbf{p} = \begin{bmatrix} -1 \\ 2 \\ 0 \end{bmatrix}$ is a particular solution to $A\mathbf{x} = \mathbf{b}$ (when parameter $t = 0$), and $t\mathbf{v}$ is the general solution to $A\mathbf{x} = \mathbf{0}$.

### Geometric Interpretation as a Translation

Vector addition geometrically represents a **translation**:
- Given vectors $\mathbf{v}$ and $\mathbf{p}$, adding $\mathbf{p}$ to $\mathbf{v}$ moves $\mathbf{v}$ in a direction parallel to the line through $\mathbf{p}$ and $\mathbf{0}$ to the point $\mathbf{v} + \mathbf{p}$.
- If each point on a line $L$ passing through $\mathbf{0}$ is translated by a fixed vector $\mathbf{p}$, the result is a parallel line passing through $\mathbf{p}$.

The solution set of $A\mathbf{x} = \mathbf{b}$ is the line (or plane) passing through $\mathbf{p}$ parallel to the solution set of $A\mathbf{x} = \mathbf{0}$.
![[Pasted image 20260915195046.png]]
FIGURE 3 Adding p to v translates v to v C p
![[Pasted image 20260915195119.png]]
FIGURE 5 Parallel solution sets of Ax D b and Ax D 0.
>[!summary] Theorem: Solution Set of a Consistent Nonhomogeneous System
> Suppose the equation $A\mathbf{x} = \mathbf{b}$ is consistent for some given $\mathbf{b}$, and let $\mathbf{p}$ be a particular solution. Then the solution set of $A\mathbf{x} = \mathbf{b}$ is the set of all vectors of the form:
> $$\mathbf{w} = \mathbf{p} + \mathbf{v}_h$$
> where $\mathbf{v}_h$ is any solution of the corresponding homogeneous equation $A\mathbf{x} = \mathbf{0}$.
>
> **breakdown**:
> - $\mathbf{w}$ : The general solution vector to $A\mathbf{x} = \mathbf{b}$.
> - $\mathbf{p}$ : A fixed particular solution satisfying $A\mathbf{p} = \mathbf{b}$.
> - $\mathbf{v}_h$ : Any homogeneous solution satisfying $A\mathbf{v}_h = \mathbf{0}$.
> - Matrix linearity verifies this directly: $A\mathbf{w} = A(\mathbf{p} + \mathbf{v}_h) = A\mathbf{p} + A\mathbf{v}_h = \mathbf{b} + \mathbf{0} = \mathbf{b}$.
![[Pasted image 20260915195143.png]]
FIGURE 6 Parallel solution sets of Ax D b and Ax D 0.

>[!warning] Consistency Precondition
> This theorem applies exclusively to systems $A\mathbf{x} = \mathbf{b}$ that possess at least one solution $\mathbf{p}$. If $A\mathbf{x} = \mathbf{b}$ is inconsistent, its solution set is empty.

---

### Procedure: Writing a Solution Set in Parametric Vector Form

>[!info] Algorithm: Parametric Vector Form Conversion
> 1. Row reduce the augmented matrix to **reduced echelon form**.
> 2. Express each **basic variable** in terms of any free variables appearing in the equations.
> 3. Write a typical solution $\mathbf{x}$ as a column vector whose entries depend on the free variables.
> 4. Decompose $\mathbf{x}$ into a constant vector plus a linear combination of vectors with numeric entries, using the free variables as scalar parameters.

---

### Verification of Solutions

>[!tip] Verification by Direct Matrix Multiplication
> To verify a solution decomposed into parametric vector form:
> 
> 1. **Homogeneous Systems ($A\mathbf{x} = \mathbf{0}$):**
>    Multiply the coefficient matrix $A$ by each spanning vector individually. The result of each product must equal the zero vector $\mathbf{0}$:
>    $$A(x_3\mathbf{v}_1 + x_4\mathbf{v}_2) = x_3(A\mathbf{v}_1) + x_4(A\mathbf{v}_2) = x_3\mathbf{0} + x_4\mathbf{0} = \mathbf{0}$$
> 
> 2. **Nonhomogeneous Systems ($A\mathbf{x} = \mathbf{b}$):**
>    - Multiply $A$ by the particular solution vector $\mathbf{p}$; the result must equal $\mathbf{b}$ ($A\mathbf{p} = \mathbf{b}$).
>    - Multiply $A$ by each homogeneous component vector; the result must equal $\mathbf{0}$.
>    $$A(\mathbf{p} + x_3\mathbf{v}_1 + x_4\mathbf{v}_2) = A\mathbf{p} + x_3(A\mathbf{v}_1) + x_4(A\mathbf{v}_2) = \mathbf{b} + \mathbf{0} + \mathbf{0} = \mathbf{b}$$