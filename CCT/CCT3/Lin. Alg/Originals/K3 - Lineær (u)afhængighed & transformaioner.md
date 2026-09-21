---
tags:
  - CCT3
  - Lin_Algebra
Topic:
Semester: CCT3
Course: Linær Algebra
Litterature:
Created:
---
# Table of Contents

1. [[#Linear Independence|Linear Independence]]
	1. [[#Linear Independence#Linear Independence of Matrix Columns|Linear Independence of Matrix Columns]]
	2. [[#Linear Independence#Sets of One or Two Vectors|Sets of One or Two Vectors]]
		1. [[#Sets of One or Two Vectors#Inspection and Geometric Interpretation|Inspection and Geometric Interpretation]]
	3. [[#Linear Independence#Sets of Two or More Vectors|Sets of Two or More Vectors]]
		1. [[#Sets of Two or More Vectors#Special Criteria for Linear Dependence|Special Criteria for Linear Dependence]]
2. [[#Introduction to Linear Transformations|Introduction to Linear Transformations]]
		1. [[#Sets of Two or More Vectors#Definitions: Transformations, Domain, Codomain, and Range|Definitions: Transformations, Domain, Codomain, and Range]]
	1. [[#Introduction to Linear Transformations#Matrix Transformations|Matrix Transformations]]
		1. [[#Matrix Transformations#Existence and Uniqueness in Matrix Transformations|Existence and Uniqueness in Matrix Transformations]]
		2. [[#Matrix Transformations#Geometric Examples of Matrix Transformations|Geometric Examples of Matrix Transformations]]
	2. [[#Introduction to Linear Transformations#Linear Transformations|Linear Transformations]]
		1. [[#Linear Transformations#Core Properties and the Superposition Principle|Core Properties and the Superposition Principle]]
3. [[#The Matrix of a Linear Transformation|The Matrix of a Linear Transformation]]
		1. [[#Linear Transformations#The Standard Matrix|The Standard Matrix]]
		2. [[#Linear Transformations#Examples of Standard Matrices|Examples of Standard Matrices]]
	1. [[#The Matrix of a Linear Transformation#Geometric Linear Transformations of $\mathbb{R}^2$|Geometric Linear Transformations of $\mathbb{R}^2$]]
		1. [[#Geometric Linear Transformations of $\mathbb{R}^2$#Composition of Transformations|Composition of Transformations]]
	2. [[#The Matrix of a Linear Transformation#Existence and Uniqueness Questions|Existence and Uniqueness Questions]]
		1. [[#Existence and Uniqueness Questions#Geometric Linear Transformations of $\mathbb{R}^2$ Reference|Geometric Linear Transformations of $\mathbb{R}^2$ Reference]]
			1. [[#Geometric Linear Transformations of $\mathbb{R}^2$ Reference#Reflections|Reflections]]
			2. [[#Geometric Linear Transformations of $\mathbb{R}^2$ Reference#Contractions and Expansions|Contractions and Expansions]]
			3. [[#Geometric Linear Transformations of $\mathbb{R}^2$ Reference#Shears|Shears]]
			4. [[#Geometric Linear Transformations of $\mathbb{R}^2$ Reference#Projections|Projections]]
		2. [[#Existence and Uniqueness Questions#Theorems on Onto and One-to-One Transformations|Theorems on Onto and One-to-One Transformations]]

- - -
# Linear Independence

Homogeneous linear systems can be studied by expressing them as vector equations. This shifts the focus from finding the unknown solution set of $A\mathbf{x} = \mathbf{0}$ to analyzing the structural relationships among the column vectors themselves.

For example, consider the homogeneous vector equation:

$$x_1 \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix} + x_2 \begin{bmatrix} 4 \\ 5 \\ 6 \end{bmatrix} + x_3 \begin{bmatrix} 2 \\ 1 \\ 0 \end{bmatrix} = \begin{bmatrix} 0 \\ 0 \\ 0 \end{bmatrix}$$

This equation always has the ***trivial solution*** where $x_1 = x_2 = x_3 = 0$. The central question is whether the trivial solution is the *only* solution, or if nontrivial solutions exist.

> [!summary] Definition: Linear Independence and Dependence
> An indexed set of vectors $\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ in $\mathbb{R}^n$ is said to be ***linearly independent*** if the vector equation
> $$x_1\mathbf{v}_1 + x_2\mathbf{v}_2 + \dots + x_p\mathbf{v}_p = \mathbf{0}$$
> has **only** the trivial solution.
> 
> The set $\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ is said to be ***linearly dependent*** if there exist weights $c_1, \dots, c_p$, *not all zero*, such that
> $$c_1\mathbf{v}_1 + c_2\mathbf{v}_2 + \dots + c_p\mathbf{v}_p = \mathbf{0}$$
> 
> **breakdown**:
> - $\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ : An indexed collection of $p$ vectors in $\mathbb{R}^n$.
> - $x_1, \dots, x_p$ : Scalar unknowns (weights) in the vector equation.
> - $c_1, \dots, c_p$ : Specific scalar weights where at least one $c_j \neq 0$.
> - $\mathbf{0}$ : The zero vector in $\mathbb{R}^n$.

An equation of the form $c_1\mathbf{v}_1 + c_2\mathbf{v}_2 + \dots + c_p\mathbf{v}_p = \mathbf{0}$ (with at least one nonzero weight) is called a ***linear dependence relation*** among $\mathbf{v}_1, \dots, \mathbf{v}_p$. 

An indexed set is linearly dependent if and only if it is not linearly independent. By convention, stating that the vectors $\mathbf{v}_1, \dots, \mathbf{v}_p$ are linearly independent means that the set $\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ is a linearly independent set.

> [!example] Example: Determining Linear Independence
> Let $\mathbf{v}_1 = \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix}$, $\mathbf{v}_2 = \begin{bmatrix} 4 \\ 5 \\ 6 \end{bmatrix}$, and $\mathbf{v}_3 = \begin{bmatrix} 2 \\ 1 \\ 0 \end{bmatrix}$.
> 
> **a.** Determine if the set $\{\mathbf{v}_1, \mathbf{v}_2, \mathbf{v}_3\}$ is linearly independent.  
> **b.** If possible, find a linear dependence relation among $\mathbf{v}_1$, $\mathbf{v}_2$, and $\mathbf{v}_3$.
> 
> **Solution:**
> 
> **Part a:**  
> Determine if there is a nontrivial solution to $x_1\mathbf{v}_1 + x_2\mathbf{v}_2 + x_3\mathbf{v}_3 = \mathbf{0}$. Set up the augmented matrix and apply row operations:
> 
> $$\begin{bmatrix} 1 & 4 & 2 & 0 \\ 2 & 5 & 1 & 0 \\ 3 & 6 & 0 & 0 \end{bmatrix} \sim \begin{bmatrix} 1 & 4 & 2 & 0 \\ 0 & -3 & -3 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix}$$
> 
> The variables $x_1$ and $x_2$ correspond to pivot columns (basic variables), while $x_3$ is a free variable. Each nonzero choice for $x_3$ determines a nontrivial solution. Hence, the vectors $\mathbf{v}_1, \mathbf{v}_2, \mathbf{v}_3$ are ***linearly dependent***.
> 
> **Part b:**  
> Row reduce the augmented matrix to reduced echelon form:
> 
> $$\begin{bmatrix} 1 & 0 & -2 & 0 \\ 0 & 1 & 1 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix}$$
> 
> This yields the linear system:
> $$\begin{aligned} x_1 - 2x_3 &= 0 \\ x_2 + x_3 &= 0 \\ 0 &= 0 \end{aligned}$$
> 
> Express basic variables in terms of the free variable $x_3$:
> $$x_1 = 2x_3, \quad x_2 = -x_3, \quad x_3 \text{ is free}$$
> 
> Choose any nonzero value for $x_3$. Selecting $x_3 = 5$ gives $x_1 = 10$ and $x_2 = -5$. Substituting these weights into the vector equation produces:
> 
> $$10\mathbf{v}_1 - 5\mathbf{v}_2 + 5\mathbf{v}_3 = \mathbf{0}$$
> 
> This represents one of infinitely many valid linear dependence relations among $\mathbf{v}_1$, $\mathbf{v}_2$, and $\mathbf{v}_3$.
## Linear Independence of Matrix Columns

When working with a matrix $A = \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n \end{bmatrix}$ rather than an explicit set of vectors, the matrix equation $A\mathbf{x} = \mathbf{0}$ can be written in vector form as:

$$x_1\mathbf{a}_1 + x_2\mathbf{a}_2 + \dots + x_n\mathbf{a}_n = \mathbf{0}$$

Each linear dependence relation among the columns of $A$ corresponds directly to a nontrivial solution of the homogeneous system $A\mathbf{x} = \mathbf{0}$.

> [!summary] Characterization: Linear Independence of Matrix Columns
> The columns of a matrix $A$ are ***linearly independent*** if and only if the homogeneous equation 
> $$A\mathbf{x} = \mathbf{0}$$ 
> has **only** the trivial solution.
> 
> **breakdown**:
> - $A = \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \dots & \mathbf{a}_n \end{bmatrix}$ : An $m \times n$ matrix whose columns are the vectors $\mathbf{a}_1, \dots, \mathbf{a}_n \in \mathbb{R}^m$.
> - $\mathbf{x} = \begin{bmatrix} x_1 \\ \vdots \\ x_n \end{bmatrix}$ : A vector of scalar unknowns (weights) in $\mathbb{R}^n$.
> - $\mathbf{0}$ : The zero vector in $\mathbb{R}^m$.

> [!example] Example: Testing Matrix Columns for Independence
> Determine if the columns of the matrix $A$ are linearly independent:
> 
> $$A = \begin{bmatrix} 0 & 1 & 4 \\ 1 & 2 & -1 \\ 5 & 8 & 0 \end{bmatrix}$$
> 
> **Solution:**
> 
> To test the equation $A\mathbf{x} = \mathbf{0}$, set up the augmented matrix and row reduce:
> 
> $$\begin{bmatrix} 0 & 1 & 4 & 0 \\ 1 & 2 & -1 & 0 \\ 5 & 8 & 0 & 0 \end{bmatrix} \sim \begin{bmatrix} 1 & 2 & -1 & 0 \\ 0 & 1 & 4 & 0 \\ 0 & -2 & 5 & 0 \end{bmatrix} \sim \begin{bmatrix} 1 & 2 & -1 & 0 \\ 0 & 1 & 4 & 0 \\ 0 & 0 & 13 & 0 \end{bmatrix}$$
> 
> There is a pivot in every column corresponding to the variables $x_1, x_2, x_3$. Because there are three basic variables and no free variables, the equation $A\mathbf{x} = \mathbf{0}$ has only the trivial solution ($\mathbf{x} = \mathbf{0}$). 
> 
> Therefore, the columns of matrix $A$ are ***linearly independent***.
## Sets of One or Two Vectors

A set containing only a single vector, $\{\mathbf{v}\}$, is ***linearly independent*** if and only if $\mathbf{v}$ is not the zero vector ($\mathbf{v} \neq \mathbf{0}$). When $\mathbf{v} \neq \mathbf{0}$, the vector equation $x_1\mathbf{v} = \mathbf{0}$ has only the trivial solution $x_1 = 0$. 

Conversely, the set containing only the zero vector, $\{\mathbf{0}\}$, is ***linearly dependent*** because the equation $x_1\mathbf{0} = \mathbf{0}$ has infinitely many nontrivial solutions (any nonzero scalar $x_1$).

> [!summary] Characterization: Linear Independence of Two Vectors
> A set of two vectors $\{\mathbf{v}_1, \mathbf{v}_2\}$ is ***linearly dependent*** if at least one of the vectors is a scalar multiple of the other.
> 
> The set is ***linearly independent*** if and only if neither of the vectors is a scalar multiple of the other.
> 
> **breakdown**:
> - $\{\mathbf{v}_1, \mathbf{v}_2\}$ : An indexed set containing exactly two vectors in $\mathbb{R}^n$.
> - Scalar multiple : An equation of the form $\mathbf{v}_1 = c\mathbf{v}_2$ or $\mathbf{v}_2 = c\mathbf{v}_1$ for some scalar $c$.

> [!example] Example: Determining Linear Independence of Two Vectors
> Determine if the following sets of vectors are linearly independent:
> 
> **a.** $\mathbf{v}_1 = \begin{bmatrix} 3 \\ 1 \end{bmatrix}, \mathbf{v}_2 = \begin{bmatrix} 6 \\ 2 \end{bmatrix}$  
> **b.** $\mathbf{v}_1 = \begin{bmatrix} 3 \\ 2 \end{bmatrix}, \mathbf{v}_2 = \begin{bmatrix} 6 \\ 2 \end{bmatrix}$
> 
> **Solution:**
> 
> **Part a:**  
> Vector $\mathbf{v}_2$ is a scalar multiple of $\mathbf{v}_1$, namely $\mathbf{v}_2 = 2\mathbf{v}_1$. This can be rewritten as a linear dependence relation:
> $$-2\mathbf{v}_1 + \mathbf{v}_2 = \mathbf{0}$$
> Since there exist weights not all zero ($c_1 = -2, c_2 = 1$), the set $\{\mathbf{v}_1, \mathbf{v}_2\}$ is ***linearly dependent***.
> 
> **Part b:**  
> The vectors $\mathbf{v}_1$ and $\mathbf{v}_2$ are not multiples of one another. To verify this algebraically, consider the equation:
> $$c\mathbf{v}_1 + d\mathbf{v}_2 = \mathbf{0}$$
> If $c \neq 0$, then solving for $\mathbf{v}_1$ yields $\mathbf{v}_1 = -\left(\frac{d}{c}\right)\mathbf{v}_2$, which would imply $\mathbf{v}_1$ is a multiple of $\mathbf{v}_2$. Since $\mathbf{v}_1$ is not a multiple of $\mathbf{v}_2$, $c$ must be zero. By the same reasoning, $d$ must also be zero. 
> 
> Because only the trivial solution $c = 0, d = 0$ exists, the set $\{\mathbf{v}_1, \mathbf{v}_2\}$ is ***linearly independent***.

### Inspection and Geometric Interpretation

For any set consisting of exactly two vectors, linear independence can always be determined by inspection without performing row reduction: simply check whether one vector is a scalar multiple of the other. *(Note: This test applies only to sets containing exactly two vectors.)*

In geometric terms:
- Two vectors are ***linearly dependent*** if and only if they lie on the exact same straight line passing through the origin (i.e., they are collinear).
- Two vectors are ***linearly independent*** if they define two distinct directional lines through the origin.

![[Pasted image 20260921195909.png]]
FIGURE 1 Geometric Linearly independent
## Sets of Two or More Vectors

> [!summary] Theorem: Characterization of Linearly Dependent Sets
> An indexed set $S = \{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ of two or more vectors is ***linearly dependent*** if and only if at least one of the vectors in $S$ is a linear combination of the others. 
> 
> In fact, if $S$ is linearly dependent and $\mathbf{v}_1 \neq \mathbf{0}$, then some $\mathbf{v}_j$ (with $j > 1$) is a linear combination of the preceding vectors, $\mathbf{v}_1, \dots, \mathbf{v}_{j-1}$.
> 
> **breakdown**:
> - $S = \{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ : An indexed set containing $p \ge 2$ vectors in $\mathbb{R}^n$.
> - $\mathbf{v}_1 \neq \mathbf{0}$ : The condition that the first vector in the set is not the zero vector.
> - $\mathbf{v}_j$ : A specific vector in the set with index $j > 1$.
> - $\mathbf{v}_1, \dots, \mathbf{v}_{j-1}$ : The sequence of all vectors that precede $\mathbf{v}_j$ in the indexed set.
> 
> **proof**:
> If some $\mathbf{v}_j \in S$ is a linear combination of the other vectors, subtracting $\mathbf{v}_j$ from both sides yields a linear dependence relation with a nonzero weight ($-1$) on $\mathbf{v}_j$. For example, if $\mathbf{v}_1 = c_2\mathbf{v}_2 + c_3\mathbf{v}_3$, then:
> $$(-1)\mathbf{v}_1 + c_2\mathbf{v}_2 + c_3\mathbf{v}_3 + 0\mathbf{v}_4 + \dots + 0\mathbf{v}_p = \mathbf{0}$$
> Thus, $S$ is linearly dependent.
> 
> Conversely, assume $S$ is linearly dependent. If $\mathbf{v}_1 = \mathbf{0}$, it is already a linear combination of the other vectors ($0\mathbf{v}_2 + \dots + 0\mathbf{v}_p$). If $\mathbf{v}_1 \neq \mathbf{0}$, there exist weights $c_1, \dots, c_p$, not all zero, such that:
> $$c_1\mathbf{v}_1 + c_2\mathbf{v}_2 + \dots + c_p\mathbf{v}_p = \mathbf{0}$$
> Let $j$ be the largest index for which $c_j \neq 0$. If $j = 1$, then $c_1\mathbf{v}_1 = \mathbf{0}$, which is impossible since $\mathbf{v}_1 \neq \mathbf{0}$ and $c_1 \neq 0$. Therefore, $j > 1$, and:
> $$c_1\mathbf{v}_1 + \dots + c_j\mathbf{v}_j + 0\mathbf{v}_{j+1} + \dots + 0\mathbf{v}_p = \mathbf{0}$$
> $$c_j\mathbf{v}_j = -c_1\mathbf{v}_1 - \dots - c_{j-1}\mathbf{v}_{j-1}$$
> Dividing by $c_j$ yields:
> $$\mathbf{v}_j = \left(-\frac{c_1}{c_j}\right)\mathbf{v}_1 + \dots + \left(-\frac{c_{j-1}}{c_j}\right)\mathbf{v}_{j-1}$$
> Hence, $\mathbf{v}_j$ is a linear combination of the preceding vectors.

> [!warning] Critical Distinction
> This theorem does **not** state that *every* vector in a linearly dependent set is a linear combination of the other vectors. A vector in a linearly dependent set may fail to be a linear combination of the other vectors, but at least *one* vector in the set must be.

> [!example] Example: Geometric Interpretation of Linear Dependence in $\mathbb{R}^3$
> Let $\mathbf{u} = \begin{bmatrix} 3 \\ 1 \\ 0 \end{bmatrix}$ and $\mathbf{v} = \begin{bmatrix} 1 \\ 6 \\ 0 \end{bmatrix}$. Describe the set spanned by $\mathbf{u}$ and $\mathbf{v}$, and explain why a vector $\mathbf{w}$ is in $\operatorname{Span}\{\mathbf{u}, \mathbf{v}\}$ if and only if $\{\mathbf{u}, \mathbf{v}, \mathbf{w}\}$ is linearly dependent.
> 
> **Solution:**
> 1. Because neither $\mathbf{u}$ nor $\mathbf{v}$ is a scalar multiple of the other, $\{\mathbf{u}, \mathbf{v}\}$ is linearly independent. Their span, $\operatorname{Span}\{\mathbf{u}, \mathbf{v}\}$, forms a plane in $\mathbb{R}^3$ (specifically, the $x_1x_2$-plane where $x_3 = 0$).
> 2. If $\mathbf{w}$ is in $\operatorname{Span}\{\mathbf{u}, \mathbf{v}\}$, then $\mathbf{w}$ is a linear combination of $\mathbf{u}$ and $\mathbf{v}$, which makes the set $\{\mathbf{u}, \mathbf{v}, \mathbf{w}\}$ linearly dependent.
> 3. Conversely, if $\{\mathbf{u}, \mathbf{v}, \mathbf{w}\}$ is linearly dependent, some vector must be a linear combination of the preceding vectors. Since $\mathbf{u} \neq \mathbf{0}$ and $\mathbf{v}$ is not a multiple of $\mathbf{u}$, that vector must be $\mathbf{w}$. Therefore, $\mathbf{w}$ is in $\operatorname{Span}\{\mathbf{u}, \mathbf{v}\}$.
> 
> **Generalization:** For any linearly independent pair $\{\mathbf{u}, \mathbf{v}\}$ in $\mathbb{R}^3$, the set $\{\mathbf{u}, \mathbf{v}, \mathbf{w}\}$ is linearly dependent if and only if $\mathbf{w}$ lies in the plane spanned by $\mathbf{u}$ and $\mathbf{v}$.
> 
> ![[Pasted image 20260921201651.png]]
> FIGURE 2 Linear dependence in R3 .

---

### Special Criteria for Linear Dependence

> [!summary] Theorem: Sets with More Vectors Than Entries
> If a set contains more vectors than there are entries in each vector, then the set is ***linearly dependent***. That is, any set $\{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ in $\mathbb{R}^n$ is linearly dependent if $p > n$.
> 
> **breakdown**:
> - $p$ : The total number of vectors in the indexed set.
> - $n$ : The number of entries in each vector (the dimension of $\mathbb{R}^n$).
> - $A = \begin{bmatrix} \mathbf{v}_1 & \dots & \mathbf{v}_p \end{bmatrix}$ : The $n \times p$ matrix formed with the given vectors as columns.
> 
> **proof**:
> Let $A = \begin{bmatrix} \mathbf{v}_1 & \dots & \mathbf{v}_p \end{bmatrix}$. The matrix $A$ has dimensions $n \times p$. The equation $A\mathbf{x} = \mathbf{0}$ represents a homogeneous system of $n$ equations with $p$ unknowns. If $p > n$, there are more variables than equations, which guarantees the existence of at least one free variable. Consequently, $A\mathbf{x} = \mathbf{0}$ has nontrivial solutions, and the columns of $A$ are linearly dependent.
> 
> ![[Pasted image 20260921201811.png]]
> FIGURE 3 If p > n, the columns are linearly dependent

> [!warning] Limitation of the Vector Count Test
> This theorem applies *only* when $p > n$. It provides no information about linear dependence when $p \le n$.

> [!example] Example: Applying the Vector Count Theorem
> The set of vectors:
> $$\left\{ \begin{bmatrix} 2 \\ 1 \end{bmatrix}, \begin{bmatrix} 4 \\ -1 \end{bmatrix}, \begin{bmatrix} -2 \\ 2 \end{bmatrix} \right\}$$
> is linearly dependent because the set contains $p = 3$ vectors, but each vector has only $n = 2$ entries ($p > n$). Notice that linear dependence holds even though no individual vector is a scalar multiple of another.
> ![[Pasted image 20260921201837.png]]
> FIGURE 4 A linearly dependent set in R2 .

> [!summary] Theorem: Sets Containing the Zero Vector
> If a set $S = \{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ in $\mathbb{R}^n$ contains the zero vector, then the set is ***linearly dependent***.
> 
> **breakdown**:
> - $S = \{\mathbf{v}_1, \dots, \mathbf{v}_p\}$ : An indexed set of vectors in $\mathbb{R}^n$.
> - $\mathbf{0}$ : The zero vector, satisfying $\mathbf{0} \in S$.
> 
> **proof**:
> By reordering the vectors, let $\mathbf{v}_1 = \mathbf{0}$. We can then write the linear combination:
> $$1\mathbf{v}_1 + 0\mathbf{v}_2 + \dots + 0\mathbf{v}_p = 1(\mathbf{0}) + \mathbf{0} + \dots + \mathbf{0} = \mathbf{0}$$
> Since there exists at least one nonzero weight ($c_1 = 1$), the set $S$ is linearly dependent.

---

> [!example] Example: Determining Linear Independence by Inspection
> Determine by inspection if each given set is linearly dependent:
> 
> **a.** $\left\{ \begin{bmatrix} 1 \\ 7 \\ 6 \end{bmatrix}, \begin{bmatrix} 2 \\ 0 \\ 9 \end{bmatrix}, \begin{bmatrix} 3 \\ 1 \\ 5 \end{bmatrix}, \begin{bmatrix} 4 \\ 1 \\ 8 \end{bmatrix} \right\}$  
> **b.** $\left\{ \begin{bmatrix} 2 \\ 3 \\ 5 \end{bmatrix}, \begin{bmatrix} 0 \\ 0 \\ 0 \end{bmatrix}, \begin{bmatrix} 1 \\ 1 \\ 8 \end{bmatrix} \right\}$  
> **c.** $\left\{ \begin{bmatrix} 2 \\ 4 \\ 6 \\ 10 \end{bmatrix}, \begin{bmatrix} 3 \\ 6 \\ 9 \\ 15 \end{bmatrix} \right\}$
> 
> **Solution:**
> 
> **Part a:**  
> The set contains $p = 4$ vectors in $\mathbb{R}^3$ ($n = 3$). Because $p > n$, the set is ***linearly dependent*** by the vector count theorem.
> 
> **Part b:**  
> The set contains $p = 3$ vectors in $\mathbb{R}^3$, so the count theorem does not apply. However, because the set contains the zero vector $\mathbf{0}$, it is ***linearly dependent***.
> 
> **Part c:**  
> Compare corresponding entries of the two vectors:
> $$\frac{3}{2} \begin{bmatrix} 2 \\ 4 \\ 6 \\ 10 \end{bmatrix} = \begin{bmatrix} 3 \\ 6 \\ 9 \\ 15 \end{bmatrix}$$
> Because the second vector is an exact scalar multiple ($c = 3/2$) of the first vector, the set is ***linearly dependent***. (If the scalar relationship had failed for any entry, the two vectors would be linearly independent).

# Introduction to Linear Transformations

The difference between a matrix equation $A\mathbf{x} = \mathbf{b}$ and the associated vector equation $x_1\mathbf{a}_1 + \dots + x_n\mathbf{a}_n = \mathbf{b}$ is fundamentally a matter of notation. However, a matrix equation $A\mathbf{x} = \mathbf{b}$ can also be viewed from a dynamic perspective where the matrix $A$ acts as an active operator on a vector $\mathbf{x}$ by multiplication to produce a new vector $A\mathbf{x}$.

Under this perspective, solving $A\mathbf{x} = \mathbf{b}$ amounts to finding all input vectors $\mathbf{x}$ in $\mathbb{R}^n$ that are mapped or transformed into the target vector $\mathbf{b}$ in $\mathbb{R}^m$ under the action of multiplication by $A$.

> [!example] Example: Matrix Multiplication as an Action
> Consider the $2 \times 4$ matrix $A$:
> $$A = \begin{bmatrix} 4 & -3 & 1 & 3 \\ 2 & 0 & 5 & 1 \end{bmatrix}$$
> 
> Multiplying $A$ by different vectors transforms them from $\mathbb{R}^4$ into $\mathbb{R}^2$:
> 
> 1. **Transforming into a nonzero vector $\mathbf{b}$:**
>    $$A\mathbf{x} = \begin{bmatrix} 4 & -3 & 1 & 3 \\ 2 & 0 & 5 & 1 \end{bmatrix} \begin{bmatrix} 1 \\ 1 \\ 1 \\ 1 \end{bmatrix} = \begin{bmatrix} 5 \\ 8 \end{bmatrix} = \mathbf{b}$$
> 
> 2. **Transforming into the zero vector $\mathbf{0}$:**
>    $$A\mathbf{u} = \begin{bmatrix} 4 & -3 & 1 & 3 \\ 2 & 0 & 5 & 1 \end{bmatrix} \begin{bmatrix} 1 \\ 4 \\ -1 \\ 3 \end{bmatrix} = \begin{bmatrix} 0 \\ 0 \end{bmatrix} = \mathbf{0}$$
> 
> Multiplication by $A$ transforms the vector $\mathbf{x}$ into $\mathbf{b}$ and transforms $\mathbf{u}$ into the zero vector.
> 
> ![[Pasted image 20260921202038.png]]

---

### Definitions: Transformations, Domain, Codomain, and Range

The correspondence from an input vector $\mathbf{x}$ to the output vector $A\mathbf{x}$ is a function from one vector space to another. This generalizes the standard concept of a scalar function $f(x)$ to vector inputs and outputs.

> [!summary] Definition: Transformation (Function or Mapping)
> A ***transformation*** (or ***function***, or ***mapping***) $T$ from $\mathbb{R}^n$ to $\mathbb{R}^m$ is a rule that assigns to each vector $\mathbf{x} \in \mathbb{R}^n$ a unique vector $T(\mathbf{x}) \in \mathbb{R}^m$.
> 
> Notation:
> $$T: \mathbb{R}^n \to \mathbb{R}^m$$
> 
> **breakdown**:
> - $T$ : The name of the transformation or mapping function.
> - $\mathbb{R}^n$ : The ***domain*** of $T$ (the set of all valid input vectors).
> - $\mathbb{R}^m$ : The ***codomain*** of $T$ (the space containing all potential output vectors).
> - $\mathbf{x}$ : An input vector belonging to the domain ($\mathbf{x} \in \mathbb{R}^n$).
> - $T(\mathbf{x})$ : The ***image*** of $\mathbf{x}$ under the action of $T$, located in the codomain ($T(\mathbf{x}) \in \mathbb{R}^m$).
> - $\text{Range of } T$ : The set of all images $T(\mathbf{x})$ generated across all possible inputs $\mathbf{x} \in \mathbb{R}^n$ (the actual collection of outputs within the codomain).

Adopting this dynamic view of matrix–vector multiplication is essential for conceptual understanding in linear algebra and serves as the mathematical foundation for modeling dynamical systems that evolve over time.

![[Pasted image 20260921202119.png]]
FIGURE 1 Transforming vectors via matrix multiplication.

![[Pasted image 20260921202129.png]]
FIGURE 2 Domain, codomain, and range of T W Rn ! Rm.
## Matrix Transformations

A ***matrix transformation*** is a mapping where the output is computed via matrix multiplication:

$$\mathbf{x} \mapsto A\mathbf{x}$$

For an $m \times n$ matrix $A$:
- The **domain** is $\mathbb{R}^n$ because $A$ has $n$ columns (requiring $\mathbf{x}$ to have $n$ entries).
- The **codomain** is $\mathbb{R}^m$ because each column of $A$ has $m$ entries (producing an output in $\mathbb{R}^m$).
- The **range** is the set of all linear combinations of the columns of $A$, since every image $T(\mathbf{x})$ is of the form $A\mathbf{x}$.

> [!summary] Definition: Matrix Transformation
> A matrix transformation $T: \mathbb{R}^n \to \mathbb{R}^m$ assigns to each vector $\mathbf{x} \in \mathbb{R}^n$ the vector $A\mathbf{x} \in \mathbb{R}^m$:
> $$T(\mathbf{x}) = A\mathbf{x}$$
> 
> **breakdown**:
> - $T$ : The transformation function mapping $\mathbb{R}^n$ to $\mathbb{R}^m$.
> - $A$ : An $m \times n$ matrix defining the mapping rule.
> - $\mathbf{x}$ : An input vector in the domain $\mathbb{R}^n$.
> - $A\mathbf{x}$ : The image of $\mathbf{x}$ in the codomain $\mathbb{R}^m$.

---

> [!example] Example: Computing Images and Preimages
> Let $A = \begin{bmatrix} 1 & -3 \\ 3 & 5 \\ -1 & 7 \end{bmatrix}$, $\mathbf{u} = \begin{bmatrix} 2 \\ -1 \end{bmatrix}$, $\mathbf{b} = \begin{bmatrix} 3 \\ 2 \\ -5 \end{bmatrix}$, and $\mathbf{c} = \begin{bmatrix} 3 \\ 2 \\ 5 \end{bmatrix}$.  
> Define $T: \mathbb{R}^2 \to \mathbb{R}^3$ by $T(\mathbf{x}) = A\mathbf{x}$:
> 
> $$T(\mathbf{x}) = \begin{bmatrix} 1 & -3 \\ 3 & 5 \\ -1 & 7 \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \end{bmatrix} = \begin{bmatrix} x_1 - 3x_2 \\ 3x_1 + 5x_2 \\ -x_1 + 7x_2 \end{bmatrix}$$
> 
> **a. Find $T(\mathbf{u})$, the image of $\mathbf{u}$ under $T$.**  
> Compute the product $A\mathbf{u}$:
> $$T(\mathbf{u}) = A\mathbf{u} = \begin{bmatrix} 1 & -3 \\ 3 & 5 \\ -1 & 7 \end{bmatrix} \begin{bmatrix} 2 \\ -1 \end{bmatrix} = \begin{bmatrix} 1(2) - 3(-1) \\ 3(2) + 5(-1) \\ -1(2) + 7(-1) \end{bmatrix} = \begin{bmatrix} 5 \\ 1 \\ -9 \end{bmatrix}$$
> 
> ![[Pasted image 20260921202732.png]]
> u -> T(u)
> 
> **b. Find a vector $\mathbf{x} \in \mathbb{R}^2$ whose image under $T$ is $\mathbf{b}$.**  
> Solve the equation $A\mathbf{x} = \mathbf{b}$ by row reducing the augmented matrix:
> $$\begin{bmatrix} 1 & -3 & 3 \\ 3 & 5 & 2 \\ -1 & 7 & -5 \end{bmatrix} \sim \begin{bmatrix} 1 & -3 & 3 \\ 0 & 14 & -7 \\ 0 & 4 & -2 \end{bmatrix} \sim \begin{bmatrix} 1 & -3 & 3 \\ 0 & 1 & -0.5 \\ 0 & 0 & 0 \end{bmatrix} \sim \begin{bmatrix} 1 & 0 & 1.5 \\ 0 & 1 & -0.5 \\ 0 & 0 & 0 \end{bmatrix}$$
> 
> This yields $x_1 = 1.5$ and $x_2 = -0.5$. Thus, $\mathbf{x} = \begin{bmatrix} 1.5 \\ -0.5 \end{bmatrix}$.
> 
> **c. Is there more than one $\mathbf{x}$ whose image under $T$ is $\mathbf{b}$?**  
> The row-reduced matrix shows that both $x_1$ and $x_2$ are basic variables with no free variables. Therefore, the system has a unique solution, meaning there is exactly one input vector $\mathbf{x}$ whose image is $\mathbf{b}$.
> 
> **d. Determine if $\mathbf{c}$ is in the range of the transformation $T$.**  
> The vector $\mathbf{c}$ belongs to the range of $T$ if and only if $A\mathbf{x} = \mathbf{c}$ is consistent. Row reduce the corresponding augmented matrix:
> $$\begin{bmatrix} 1 & -3 & 3 \\ 3 & 5 & 2 \\ -1 & 7 & 5 \end{bmatrix} \sim \begin{bmatrix} 1 & -3 & 3 \\ 0 & 14 & -7 \\ 0 & 4 & 8 \end{bmatrix} \sim \begin{bmatrix} 1 & -3 & 3 \\ 0 & 1 & 2 \\ 0 & 14 & -7 \end{bmatrix} \sim \begin{bmatrix} 1 & -3 & 3 \\ 0 & 1 & 2 \\ 0 & 0 & -35 \end{bmatrix}$$
> 
> The final row corresponds to the equation $0 = -35$, which is impossible. The system is inconsistent; therefore, $\mathbf{c}$ is ***not*** in the range of $T$.

### Existence and Uniqueness in Matrix Transformations

Matrix transformation questions translate standard linear system concepts into the language of mappings:
- **Uniqueness Problem:** *"Is $\mathbf{b}$ the image of a unique $\mathbf{x}$?"* corresponds to asking whether $A\mathbf{x} = \mathbf{b}$ has at most one solution (no free variables).
- **Existence Problem:** *"Does there exist an $\mathbf{x}$ whose image is $\mathbf{c}$ (is $\mathbf{c}$ in the range)?"* corresponds to asking whether $A\mathbf{x} = \mathbf{c}$ is consistent (no row of the form $\begin{bmatrix} 0 & \dots & 0 & d \end{bmatrix}$ with $d \neq 0$).

---

### Geometric Examples of Matrix Transformations

> [!example] Example: Projection Transformation
> Let $A = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 0 \end{bmatrix}$. The transformation $\mathbf{x} \mapsto A\mathbf{x}$ projects points in $\mathbb{R}^3$ orthogonally onto the $x_1x_2$-plane:
> 
> $$\begin{bmatrix} x_1 \\ x_2 \\ x_3 \end{bmatrix} \mapsto \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 0 \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \\ x_3 \end{bmatrix} = \begin{bmatrix} x_1 \\ x_2 \\ 0 \end{bmatrix}$$
> 
> ![[Pasted image 20260921203135.png]]
> FIGURE 3 A projection transformation.

> [!example] Example: Shear Transformation
> Let $A = \begin{bmatrix} 1 & 2 \\ 0 & 1 \end{bmatrix}$. The transformation $T: \mathbb{R}^2 \to \mathbb{R}^2$ defined by $T(\mathbf{x}) = A\mathbf{x}$ is called a ***shear transformation***.
> 
> Acting on the vertices of a square:
> - The point $\mathbf{u} = \begin{bmatrix} 0 \\ 2 \end{bmatrix}$ maps to $T(\mathbf{u}) = \begin{bmatrix} 1 & 2 \\ 0 & 1 \end{bmatrix} \begin{bmatrix} 0 \\ 2 \end{bmatrix} = \begin{bmatrix} 4 \\ 2 \end{bmatrix}$.
> - The point $\begin{bmatrix} 2 \\ 2 \end{bmatrix}$ maps to $\begin{bmatrix} 1 & 2 \\ 0 & 1 \end{bmatrix} \begin{bmatrix} 2 \\ 2 \end{bmatrix} = \begin{bmatrix} 6 \\ 2 \end{bmatrix}$.
> - The points on the base along the $x_1$-axis (where $x_2 = 0$) remain unchanged.
> 
> The transformation deforms a square into a parallelogram by shifting points horizontally in proportion to their height ($x_2$), while holding the base fixed.
> ![[Pasted image 20260921203206.png]]
> FIGURE 4 A shear transformation.

## Linear Transformations

For any $m \times n$ matrix $A$, matrix multiplication naturally satisfies the distributive and scalar multiplication properties:

$$A(\mathbf{u} + \mathbf{v}) = A\mathbf{u} + A\mathbf{v} \quad \text{and} \quad A(c\mathbf{u}) = c(A\mathbf{u})$$

for all vectors $\mathbf{u}, \mathbf{v} \in \mathbb{R}^n$ and all scalars $c$. These fundamental algebraic properties define the class of ***linear transformations***.

> [!summary] Definition: Linear Transformation
> A transformation (or mapping) $T$ is ***linear*** if:
> 1. $T(\mathbf{u} + \mathbf{v}) = T(\mathbf{u}) + T(\mathbf{v})$ for all $\mathbf{u}, \mathbf{v}$ in the domain of $T$;
> 2. $T(c\mathbf{u}) = cT(\mathbf{u})$ for all scalars $c$ and all $\mathbf{u}$ in the domain of $T$.
> 
> **breakdown**:
> - $T$ : A mapping or function from a domain vector space to a codomain vector space ($T: \mathbb{R}^n \to \mathbb{R}^m$).
> - $\mathbf{u}, \mathbf{v}$ : Arbitrary vectors in the domain of $T$.
> - $c$ : An arbitrary scalar.
> - Condition (1) : Preserves vector addition (applying $T$ to a sum equals the sum of the individual transformations).
> - Condition (2) : Preserves scalar multiplication (applying $T$ to a scaled vector equals scaling the transformed vector).

Every matrix transformation $\mathbf{x} \mapsto A\mathbf{x}$ is a linear transformation.

---

### Core Properties and the Superposition Principle

Linear transformations preserve the operations of vector addition and scalar multiplication. From the two foundational rules, several direct consequences follow:

1. **Mapping the Zero Vector:**
   $$T(\mathbf{0}) = \mathbf{0}$$
   *(Since $T(\mathbf{0}) = T(0\mathbf{u}) = 0T(\mathbf{u}) = \mathbf{0}$.)*

2. **Preservation of Linear Combinations of Two Vectors:**
   $$T(c\mathbf{u} + d\mathbf{v}) = cT(\mathbf{u}) + dT(\mathbf{v})$$
   for all vectors $\mathbf{u}, \mathbf{v}$ in the domain and all scalars $c, d$.

3. **General Linear Combination (Superposition Principle):**
   Repeated application of linearity leads to the generalized form:
   $$T(c_1\mathbf{v}_1 + c_2\mathbf{v}_2 + \dots + c_p\mathbf{v}_p) = c_1T(\mathbf{v}_1) + c_2T(\mathbf{v}_2) + \dots + c_pT(\mathbf{v}_p)$$

In engineering and physics, this generalized relation is known as the ***superposition principle***. If input signals $\mathbf{v}_1, \dots, \mathbf{v}_p$ generate corresponding system responses $T(\mathbf{v}_1), \dots, T(\mathbf{v}_p)$, then a composite input composed of a linear combination of those signals produces a response that is the exact same linear combination of the individual responses.

---

> [!example] Example: Contraction and Dilation Transformations
> For a given scalar $r$, define $T: \mathbb{R}^2 \to \mathbb{R}^2$ by $T(\mathbf{x}) = r\mathbf{x}$. 
> - $T$ is called a ***contraction*** when $0 \le r \le 1$.
> - $T$ is called a ***dilation*** when $r > 1$.
> 
> **Proof of Linearity (for $r = 3$):**  
> Let $\mathbf{u}, \mathbf{v} \in \mathbb{R}^2$ and let $c, d$ be scalars:
> $$\begin{aligned} T(c\mathbf{u} + d\mathbf{v}) &= 3(c\mathbf{u} + d\mathbf{v}) && \text{(Definition of } T \text{)} \\ &= 3c\mathbf{u} + 3d\mathbf{v} && \text{(Vector arithmetic)} \\ &= c(3\mathbf{u}) + d(3\mathbf{v}) && \text{(Scalar commutativity)} \\ &= cT(\mathbf{u}) + dT(\mathbf{v}) && \text{(Definition of } T \text{)} \end{aligned}$$
> Because $T(c\mathbf{u} + d\mathbf{v}) = cT(\mathbf{u}) + dT(\mathbf{v})$, $T$ is a linear transformation.
> ![[Pasted image 20260921203829.png]]
> FIGURE 5 A dilation transformation.

> [!example] Example: Geometric Rotation Transformation
> Define the linear transformation $T: \mathbb{R}^2 \to \mathbb{R}^2$ by:
> 
> $$T(\mathbf{x}) = \begin{bmatrix} 0 & -1 \\ 1 & 0 \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \end{bmatrix} = \begin{bmatrix} -x_2 \\ x_1 \end{bmatrix}$$
> 
> Find the images under $T$ of $\mathbf{u} = \begin{bmatrix} 4 \\ 1 \end{bmatrix}$, $\mathbf{v} = \begin{bmatrix} 2 \\ 3 \end{bmatrix}$, and their sum $\mathbf{u} + \mathbf{v} = \begin{bmatrix} 6 \\ 4 \end{bmatrix}$.
> 
> **Solution:**
> - $T(\mathbf{u}) = \begin{bmatrix} 0 & -1 \\ 1 & 0 \end{bmatrix} \begin{bmatrix} 4 \\ 1 \end{bmatrix} = \begin{bmatrix} -1 \\ 4 \end{bmatrix}$
> - $T(\mathbf{v}) = \begin{bmatrix} 0 & -1 \\ 1 & 0 \end{bmatrix} \begin{bmatrix} 2 \\ 3 \end{bmatrix} = \begin{bmatrix} -3 \\ 2 \end{bmatrix}$
> - $T(\mathbf{u} + \mathbf{v}) = \begin{bmatrix} 0 & -1 \\ 1 & 0 \end{bmatrix} \begin{bmatrix} 6 \\ 4 \end{bmatrix} = \begin{bmatrix} -4 \\ 6 \end{bmatrix}$
> 
> Note that $T(\mathbf{u} + \mathbf{v}) = T(\mathbf{u}) + T(\mathbf{v}) = \begin{bmatrix} -1 \\ 4 \end{bmatrix} + \begin{bmatrix} -3 \\ 2 \end{bmatrix} = \begin{bmatrix} -4 \\ 6 \end{bmatrix}$. 
> 
> Geometrically, this transformation rotates every vector counterclockwise about the origin by $90^\circ$, transforming the entire parallelogram determined by $\mathbf{u}$ and $\mathbf{v}$ into a corresponding rotated parallelogram determined by $T(\mathbf{u})$ and $T(\mathbf{v})$.
> ![[Pasted image 20260921203848.png]]
> FIGURE 6 A rotation transformation.

> [!example] Example: Applied Linear Transformation in Production Costing
> A manufacturing company produces two products, $B$ and $C$. The unit costs per dollar of output are arranged into a matrix $U$:
> 
> $$U = \begin{bmatrix} \mathbf{b} & \mathbf{c} \end{bmatrix} = \begin{bmatrix} 0.45 & 0.40 \\ 0.25 & 0.30 \\ 0.15 & 0.15 \end{bmatrix} \begin{matrix} \text{Materials} \\ \text{Labor} \\ \text{Overhead} \end{matrix}$$
> 
> Let $\mathbf{x} = \begin{bmatrix} x_1 \\ x_2 \end{bmatrix}$ be a production vector representing $x_1$ dollars of product $B$ and $x_2$ dollars of product $C$. Define $T: \mathbb{R}^2 \to \mathbb{R}^3$ by:
> 
> $$T(\mathbf{x}) = U\mathbf{x} = x_1 \begin{bmatrix} 0.45 \\ 0.25 \\ 0.15 \end{bmatrix} + x_2 \begin{bmatrix} 0.40 \\ 0.30 \\ 0.15 \end{bmatrix} = \begin{bmatrix} \text{Total cost of materials} \\ \text{Total cost of labor} \\ \text{Total cost of overhead} \end{bmatrix}$$
> 
> The transformation $T$ maps a list of production values directly to total component costs. The linearity of $T$ reflects two practical properties:
> 1. **Scalar Scaling:** Scaling production by a factor $k$ (e.g., $4\mathbf{x}$) multiplies all resulting costs by the same factor ($4T(\mathbf{x})$).
> 2. **Additivity:** The total cost vector for a combined output $\mathbf{x} + \mathbf{y}$ is precisely the sum of the individual cost vectors $T(\mathbf{x}) + T(\mathbf{y})$.
# The Matrix of a Linear Transformation

Whenever a linear transformation $T$ is described geometrically or verbally, it is often useful to find an explicit computational formula for $T(\mathbf{x})$. Every linear transformation from $\mathbb{R}^n$ to $\mathbb{R}^m$ is fundamentally a matrix transformation $\mathbf{x} \mapsto A\mathbf{x}$. 

The key to finding the matrix $A$ is that $T$ is completely determined by what it does to the columns of the $n \times n$ identity matrix $I_n$.

> [!example] Example: Determining a Transformation Formula from Basis Images
> The columns of the $2 \times 2$ identity matrix $I_2 = \begin{bmatrix} 1 & 0 \\ 0 & 1 \end{bmatrix}$ are:
> $$\mathbf{e}_1 = \begin{bmatrix} 1 \\ 0 \end{bmatrix} \quad \text{and} \quad \mathbf{e}_2 = \begin{bmatrix} 0 \\ 1 \end{bmatrix}$$
> 
> ![[Pasted image 20260921204515.png]]
> 
> Suppose $T: \mathbb{R}^2 \to \mathbb{R}^3$ is a linear transformation such that:
> $$T(\mathbf{e}_1) = \begin{bmatrix} 5 \\ -7 \\ 2 \end{bmatrix} \quad \text{and} \quad T(\mathbf{e}_2) = \begin{bmatrix} -3 \\ 8 \\ 0 \end{bmatrix}$$
> 
> Find a formula for the image of an arbitrary vector $\mathbf{x} = \begin{bmatrix} x_1 \\ x_2 \end{bmatrix}$ in $\mathbb{R}^2$.
> 
> **Solution:**
> 
> Any vector $\mathbf{x} \in \mathbb{R}^2$ can be expressed as a linear combination of $\mathbf{e}_1$ and $\mathbf{e}_2$:
> $$\mathbf{x} = \begin{bmatrix} x_1 \\ x_2 \end{bmatrix} = x_1 \begin{bmatrix} 1 \\ 0 \end{bmatrix} + x_2 \begin{bmatrix} 0 \\ 1 \end{bmatrix} = x_1\mathbf{e}_1 + x_2\mathbf{e}_2$$
> 
> Applying the linearity of $T$:
> $$\begin{aligned} T(\mathbf{x}) &= x_1T(\mathbf{e}_1) + x_2T(\mathbf{e}_2) \\ &= x_1 \begin{bmatrix} 5 \\ -7 \\ 2 \end{bmatrix} + x_2 \begin{bmatrix} -3 \\ 8 \\ 0 \end{bmatrix} \\ &= \begin{bmatrix} 5x_1 - 3x_2 \\ -7x_1 + 8x_2 \\ 2x_1 + 0 \end{bmatrix} \end{aligned}$$

Because $T(\mathbf{x})$ can be written as a linear combination of vectors, it can be factored into matrix form:

$$T(\mathbf{x}) = \begin{bmatrix} T(\mathbf{e}_1) & T(\mathbf{e}_2) \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \end{bmatrix} = A\mathbf{x}$$

---

### The Standard Matrix

> [!summary] Theorem: The Standard Matrix for a Linear Transformation
> Let $T: \mathbb{R}^n \to \mathbb{R}^m$ be a linear transformation. Then there exists a unique matrix $A$ such that
> $$T(\mathbf{x}) = A\mathbf{x} \quad \text{for all } \mathbf{x} \in \mathbb{R}^n$$
> 
> The matrix $A$ is the $m \times n$ matrix whose $j\text{th}$ column is the vector $T(\mathbf{e}_j)$, where $\mathbf{e}_j$ is the $j\text{th}$ column of the identity matrix in $\mathbb{R}^n$:
> $$A = \begin{bmatrix} T(\mathbf{e}_1) & \dots & T(\mathbf{e}_n) \end{bmatrix}$$
> 
> **breakdown**:
> - $T$ : A linear transformation mapping $\mathbb{R}^n \to \mathbb{R}^m$.
> - $\mathbf{e}_j$ : The $j\text{th}$ standard basis vector in $\mathbb{R}^n$ (column $j$ of the $n \times n$ identity matrix $I_n$).
> - $T(\mathbf{e}_j)$ : The image of $\mathbf{e}_j$ under $T$, forming the $j\text{th}$ column of $A$.
> - $A$ : The $m \times n$ ***standard matrix*** for the linear transformation $T$.
> - $\mathbf{x}$ : An arbitrary input vector in $\mathbb{R}^n$, where $\mathbf{x} = x_1\mathbf{e}_1 + \dots + x_n\mathbf{e}_n$.
> 
> **proof**:
> Express $\mathbf{x} \in \mathbb{R}^n$ in terms of the identity matrix columns:
> $$\mathbf{x} = I_n\mathbf{x} = \begin{bmatrix} \mathbf{e}_1 & \dots & \mathbf{e}_n \end{bmatrix} \mathbf{x} = x_1\mathbf{e}_1 + \dots + x_n\mathbf{e}_n$$
> Using the linearity of $T$:
> $$\begin{aligned} T(\mathbf{x}) &= T(x_1\mathbf{e}_1 + \dots + x_n\mathbf{e}_n) \\ &= x_1T(\mathbf{e}_1) + \dots + x_nT(\mathbf{e}_n) \\ &= \begin{bmatrix} T(\mathbf{e}_1) & \dots & T(\mathbf{e}_n) \end{bmatrix} \begin{bmatrix} x_1 \\ \vdots \\ x_n \end{bmatrix} \\ &= A\mathbf{x} \end{aligned}$$
> The uniqueness of $A$ is established because the columns of $A$ are uniquely fixed by the values $T(\mathbf{e}_1), \dots, T(\mathbf{e}_n)$.

The matrix $A = \begin{bmatrix} T(\mathbf{e}_1) & \dots & T(\mathbf{e}_n) \end{bmatrix}$ is called the ***standard matrix for the linear transformation $T$***. 

While the term *linear transformation* emphasizes the operational properties of a mapping (preserving addition and scaling), the term *matrix transformation* describes how the mapping is explicitly implemented via computation.

---

### Examples of Standard Matrices

> [!example] Example: Standard Matrix of a Dilation
> Find the standard matrix $A$ for the dilation transformation $T: \mathbb{R}^2 \to \mathbb{R}^2$ defined by $T(\mathbf{x}) = 3\mathbf{x}$.
> 
> **Solution:**
> 
> Evaluate $T$ on the standard basis vectors of $\mathbb{R}^2$:
> $$T(\mathbf{e}_1) = 3\mathbf{e}_1 = 3\begin{bmatrix} 1 \\ 0 \end{bmatrix} = \begin{bmatrix} 3 \\ 0 \end{bmatrix}$$
> $$T(\mathbf{e}_2) = 3\mathbf{e}_2 = 3\begin{bmatrix} 0 \\ 1 \end{bmatrix} = \begin{bmatrix} 0 \\ 3 \end{bmatrix}$$
> 
> Place these vectors into the columns of the standard matrix $A$:
> $$A = \begin{bmatrix} T(\mathbf{e}_1) & T(\mathbf{e}_2) \end{bmatrix} = \begin{bmatrix} 3 & 0 \\ 0 & 3 \end{bmatrix}$$
> ![[Pasted image 20260921204538.png]]

> [!example] Example: Standard Matrix of a Counterclockwise Rotation
> Let $T: \mathbb{R}^2 \to \mathbb{R}^2$ be the transformation that rotates each point in $\mathbb{R}^2$ counterclockwise about the origin through an angle $\varphi$. Find the standard matrix $A$ of this linear transformation.
> 
> **Solution:**
> 
> Apply the rotation to the standard unit basis vectors:
> - The vector $\mathbf{e}_1 = \begin{bmatrix} 1 \\ 0 \end{bmatrix}$ lies on the positive $x_1$-axis and rotates to $\begin{bmatrix} \cos\varphi \\ \sin\varphi \end{bmatrix}$.
> - The vector $\mathbf{e}_2 = \begin{bmatrix} 0 \\ 1 \end{bmatrix}$ lies on the positive $x_2$-axis and rotates to $\begin{bmatrix} -\sin\varphi \\ \cos\varphi \end{bmatrix}$.
> 
> Construct the standard matrix from these image columns:
> $$A = \begin{bmatrix} T(\mathbf{e}_1) & T(\mathbf{e}_2) \end{bmatrix} = \begin{bmatrix} \cos\varphi & -\sin\varphi \\ \sin\varphi & \cos\varphi \end{bmatrix}$$
> ![[Pasted image 20260921204553.png]]
> FIGURE 1 A rotation transformation.
## Geometric Linear Transformations of $\mathbb{R}^2$

Linear transformations in the plane ($\mathbb{R}^2$) can be understood geometrically by observing their action on the standard basis vectors $\mathbf{e}_1 = \begin{bmatrix} 1 \\ 0 \end{bmatrix}$ and $\mathbf{e}_2 = \begin{bmatrix} 0 \\ 1 \end{bmatrix}$ of the $2 \times 2$ identity matrix $I_2$. 
![[Pasted image 20260921204620.png]]
FIGURE 2 The unit square.
Because a linear mapping is completely determined by the image vectors $T(\mathbf{e}_1)$ and $T(\mathbf{e}_2)$, the overall geometric behavior of the transformation (such as reflections, rotations, shears, dilations, contractions, and projections) is clearly visualized by tracking how the unit square—defined by vertices at $(0,0)$, $(1,0)$, $(0,1)$, and $(1,1)$—is transformed into a new parallelogram.

---

### Composition of Transformations

More complex geometric operations can be constructed by applying a sequence of elementary transformations one after another. For example, a planar region may first undergo a horizontal shear and subsequently be reflected across the $x_2$-axis.

> [!info] Linearity of Composite Transformations
> Applying one linear transformation after another forms a ***composition*** of mappings. The composition of two or more linear transformations is itself a linear transformation, and its combined action can be represented by a single standard matrix.
## Existence and Uniqueness Questions

The concept of a linear transformation provides a dynamic framework for reinterpreting the foundational existence and uniqueness questions of linear systems:
- **Existence:** Does an input exist for every possible output in the codomain?
- **Uniqueness:** If an output exists, is it generated by at most one unique input?

> [!summary] Definition: Onto Mapping (Surjective)
> A mapping $T: \mathbb{R}^n \to \mathbb{R}^m$ is said to be ***onto*** $\mathbb{R}^m$ if each $\mathbf{b} \in \mathbb{R}^m$ is the image of at least one $\mathbf{x} \in \mathbb{R}^n$.
> 
> **breakdown**:
> - $T$ : A transformation mapping the domain $\mathbb{R}^n$ to the codomain $\mathbb{R}^m$.
> - $\mathbf{b}$ : An arbitrary target vector in the codomain $\mathbb{R}^m$.
> - $\mathbf{x}$ : An input vector in the domain $\mathbb{R}^n$ such that $T(\mathbf{x}) = \mathbf{b}$.
> - $\text{Range of } T$ : The set of all actual outputs. $T$ is onto if and only if its range equals the entire codomain $\mathbb{R}^m$.

The question *"Does $T$ map $\mathbb{R}^n$ onto $\mathbb{R}^m$?"* is an **existence question**: for every possible $\mathbf{b} \in \mathbb{R}^m$, does the equation $T(\mathbf{x}) = \mathbf{b}$ have at least one solution? If there is even one vector $\mathbf{b} \in \mathbb{R}^m$ with no pre-image $\mathbf{x}$, then $T$ is not onto.
![[Pasted image 20260921204709.png]]
FIGURE 3 Is the range of T all of Rm?

> [!summary] Definition: One-to-One Mapping (Injective)
> A mapping $T: \mathbb{R}^n \to \mathbb{R}^m$ is said to be ***one-to-one*** if each $\mathbf{b} \in \mathbb{R}^m$ is the image of *at most one* $\mathbf{x} \in \mathbb{R}^n$.
> 
> **breakdown**:
> - $T$ : A transformation mapping $\mathbb{R}^n$ to $\mathbb{R}^m$.
> - $\mathbf{b}$ : A target vector in the codomain $\mathbb{R}^m$.
> - $T(\mathbf{x}) = \mathbf{b}$ : The equation has either a unique solution $\mathbf{x}$ or no solution at all.

The question *"Is $T$ one-to-one?"* is a **uniqueness question**: does every output vector come from at most a single unique input vector? $T$ fails to be one-to-one if there is some $\mathbf{b} \in \mathbb{R}^m$ that is produced by two or more distinct input vectors.

---

### Geometric Linear Transformations of $\mathbb{R}^2$ Reference

Common geometric transformations of $\mathbb{R}^2$ can be characterized by their standard matrices and their mapping properties:

#### Reflections

| Transformation | Effect on Basis Vectors | Standard Matrix |
| :--- | :--- | :--- |
| **Reflection through the $x_1$-axis** | $\mathbf{e}_1 \mapsto \begin{bmatrix} 1 \\ 0 \end{bmatrix}, \; \mathbf{e}_2 \mapsto \begin{bmatrix} 0 \\ -1 \end{bmatrix}$ | $\begin{bmatrix} 1 & 0 \\ 0 & -1 \end{bmatrix}$ |
| **Reflection through the $x_2$-axis** | $\mathbf{e}_1 \mapsto \begin{bmatrix} -1 \\ 0 \end{bmatrix}, \; \mathbf{e}_2 \mapsto \begin{bmatrix} 0 \\ 1 \end{bmatrix}$ | $\begin{bmatrix} -1 & 0 \\ 0 & 1 \end{bmatrix}$ |
| **Reflection through the line $x_2 = x_1$** | $\mathbf{e}_1 \mapsto \begin{bmatrix} 0 \\ 1 \end{bmatrix}, \; \mathbf{e}_2 \mapsto \begin{bmatrix} 1 \\ 0 \end{bmatrix}$ | $\begin{bmatrix} 0 & 1 \\ 1 & 0 \end{bmatrix}$ |
| **Reflection through the line $x_2 = -x_1$** | $\mathbf{e}_1 \mapsto \begin{bmatrix} 0 \\ -1 \end{bmatrix}, \; \mathbf{e}_2 \mapsto \begin{bmatrix} -1 \\ 0 \end{bmatrix}$ | $\begin{bmatrix} 0 & -1 \\ -1 & 0 \end{bmatrix}$ |
| **Reflection through the origin** | $\mathbf{e}_1 \mapsto \begin{bmatrix} -1 \\ 0 \end{bmatrix}, \; \mathbf{e}_2 \mapsto \begin{bmatrix} 0 \\ -1 \end{bmatrix}$ | $\begin{bmatrix} -1 & 0 \\ 0 & -1 \end{bmatrix}$ |

*(All reflection transformations are both one-to-one and onto $\mathbb{R}^2$.)*
![[Pasted image 20260921204730.png]]
#### Contractions and Expansions

| Transformation | Condition | Standard Matrix |
| :--- | :--- | :--- |
| **Horizontal Contraction / Expansion** | $0 < k < 1$ (contraction), $k > 1$ (expansion) | $\begin{bmatrix} k & 0 \\ 0 & 1 \end{bmatrix}$ |
| **Vertical Contraction / Expansion** | $0 < k < 1$ (contraction), $k > 1$ (expansion) | $\begin{bmatrix} 1 & 0 \\ 0 & k \end{bmatrix}$ |

*(Contraction and expansion transformations with $k > 0$ are both one-to-one and onto $\mathbb{R}^2$.)*
![[Pasted image 20260921204742.png]]
#### Shears

| Transformation | Effect | Standard Matrix |
| :--- | :--- | :--- |
| **Horizontal Shear** | Shifts horizontally proportional to $x_2$ | $\begin{bmatrix} 1 & k \\ 0 & 1 \end{bmatrix}$ |
| **Vertical Shear** | Shifts vertically proportional to $x_1$ | $\begin{bmatrix} 1 & 0 \\ k & 1 \end{bmatrix}$ |

*(Shear transformations are both one-to-one and onto $\mathbb{R}^2$.)*
![[Pasted image 20260921204747.png]]
#### Projections

| Transformation | Effect | Standard Matrix |
| :--- | :--- | :--- |
| **Projection onto the $x_1$-axis** | Maps $\begin{bmatrix} x_1 \\ x_2 \end{bmatrix} \mapsto \begin{bmatrix} x_1 \\ 0 \end{bmatrix}$ | $\begin{bmatrix} 1 & 0 \\ 0 & 0 \end{bmatrix}$ |
| **Projection onto the $x_2$-axis** | Maps $\begin{bmatrix} x_1 \\ x_2 \end{bmatrix} \mapsto \begin{bmatrix} 0 \\ x_2 \end{bmatrix}$ | $\begin{bmatrix} 0 & 0 \\ 0 & 1 \end{bmatrix}$ |

*(Projection transformations are **neither** one-to-one nor onto $\mathbb{R}^2$.)*
![[Pasted image 20260921204753.png]]

---

> [!example] Example: Determining Onto and One-to-One Properties from a Matrix
> Let $T: \mathbb{R}^4 \to \mathbb{R}^3$ be the linear transformation whose standard matrix is:
> 
> $$A = \begin{bmatrix} 1 & -4 & 8 & 1 \\ 0 & 2 & -1 & 3 \\ 0 & 0 & 0 & 5 \end{bmatrix}$$
> 
> Does $T$ map $\mathbb{R}^4$ onto $\mathbb{R}^3$? Is $T$ a one-to-one mapping?
> 
> **Solution:**
> 
> The matrix $A$ is in echelon form and contains three pivot positions (one in each of its three rows):
> 1. **Onto Analysis:** Because there is a pivot in every row, the equation $A\mathbf{x} = \mathbf{b}$ is consistent for every vector $\mathbf{b} \in \mathbb{R}^3$. Therefore, $T$ maps $\mathbb{R}^4$ ***onto*** $\mathbb{R}^3$.
> 2. **One-to-One Analysis:** The system $A\mathbf{x} = \mathbf{b}$ has 4 variables and only 3 basic variables (pivot columns 1, 2, and 4), meaning column 3 corresponds to a free variable ($x_3$). The presence of a free variable ensures that any consistent system has infinitely many solutions. Thus, each image $\mathbf{b}$ is produced by more than one input vector $\mathbf{x}$, meaning $T$ is ***not one-to-one***.

---

### Theorems on Onto and One-to-One Transformations

> [!summary] Theorem: Characterization of One-to-One Linear Transformations
> Let $T: \mathbb{R}^n \to \mathbb{R}^m$ be a linear transformation. Then $T$ is ***one-to-one*** if and only if the equation 
> $$T(\mathbf{x}) = \mathbf{0}$$ 
> has **only** the trivial solution ($\mathbf{x} = \mathbf{0}$).
> 
> **breakdown**:
> - $T$ : A linear transformation from $\mathbb{R}^n$ to $\mathbb{R}^m$.
> - $T(\mathbf{x}) = \mathbf{0}$ : The homogeneous equation for the transformation.
> - $\mathbf{0}$ : The zero vector in the codomain $\mathbb{R}^m$.
> 
> **proof**:
> Since $T$ is linear, $T(\mathbf{0}) = \mathbf{0}$. 
> 
> 1. If $T$ is one-to-one, the zero vector $\mathbf{0} \in \mathbb{R}^m$ can have at most one pre-image. Since $\mathbf{x} = \mathbf{0}$ is already a solution, it must be the only solution.
> 2. Conversely, suppose $T$ is not one-to-one. Then there exist at least two distinct vectors $\mathbf{u} \neq \mathbf{v}$ such that $T(\mathbf{u}) = \mathbf{b}$ and $T(\mathbf{v}) = \mathbf{b}$. By the linearity of $T$:
>    $$T(\mathbf{u} - \mathbf{v}) = T(\mathbf{u}) - T(\mathbf{v}) = \mathbf{b} - \mathbf{b} = \mathbf{0}$$
>    Because $\mathbf{u} \neq \mathbf{v}$, the difference vector $\mathbf{u} - \mathbf{v} \neq \mathbf{0}$. This produces a nontrivial solution to $T(\mathbf{x}) = \mathbf{0}$. 
> 
> Therefore, $T$ is one-to-one if and only if $T(\mathbf{x}) = \mathbf{0}$ has only the trivial solution.
> ![[Pasted image 20260921204835.png]]
> FIGURE 4 Is every b the image of at most one vector?

---

> [!summary] Theorem: Standard Matrix Criteria for Onto and One-to-One Mappings
> Let $T: \mathbb{R}^n \to \mathbb{R}^m$ be a linear transformation, and let $A$ be the standard matrix for $T$. Then:
> 1. $T$ maps $\mathbb{R}^n$ ***onto*** $\mathbb{R}^m$ if and only if the columns of $A$ span $\mathbb{R}^m$.
> 2. $T$ is ***one-to-one*** if and only if the columns of $A$ are linearly independent.
> 
> **breakdown**:
> - $T$ : A linear transformation mapping $\mathbb{R}^n \to \mathbb{R}^m$.
> - $A$ : The $m \times n$ standard matrix whose $j\text{th}$ column is $T(\mathbf{e}_j)$.
> - $\operatorname{Span}\{\mathbf{a}_1, \dots, \mathbf{a}_n\} = \mathbb{R}^m$ : The condition that every vector in $\mathbb{R}^m$ can be written as a linear combination of the columns of $A$ (equivalent to having a pivot in every row).
> - Linear Independence of columns : The condition that $A\mathbf{x} = \mathbf{0}$ has only the trivial solution (equivalent to having a pivot in every column).
> 
> **proof**:
> 
> **Part a:**  
> The columns of $A$ span $\mathbb{R}^m$ if and only if the equation $A\mathbf{x} = \mathbf{b}$ is consistent for every $\mathbf{b} \in \mathbb{R}^m$. By definition, this means that for every $\mathbf{b}$, the equation $T(\mathbf{x}) = \mathbf{b}$ has at least one solution $\mathbf{x}$, which is the precise definition of $T$ mapping onto $\mathbb{R}^m$.
> 
> **Part b:**  
> The equation $T(\mathbf{x}) = \mathbf{0}$ is identical to $A\mathbf{x} = \mathbf{0}$. The mapping $T$ is one-to-one if and only if $T(\mathbf{x}) = \mathbf{0}$ has only the trivial solution. By definition of linear independence, $A\mathbf{x} = \mathbf{0}$ has only the trivial solution if and only if the columns of $A$ are linearly independent.

---

> [!example] Example: Testing Onto and One-to-One from an Algebraic Formula
> Let $T: \mathbb{R}^2 \to \mathbb{R}^3$ be defined by:
> $$T(x_1, x_2) = (3x_1 + x_2, \; 5x_1 + 7x_2, \; x_1 + 3x_2)$$
> 
> Show that $T$ is a one-to-one linear transformation, and determine whether $T$ maps $\mathbb{R}^2$ onto $\mathbb{R}^3$.
> 
> **Solution:**
> 
> Express the vector output as a matrix-vector product to identify the standard matrix $A$:
> 
> $$T(\mathbf{x}) = \begin{bmatrix} 3x_1 + x_2 \\ 5x_1 + 7x_2 \\ x_1 + 3x_2 \end{bmatrix} = \begin{bmatrix} 3 & 1 \\ 5 & 7 \\ 1 & 3 \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \end{bmatrix}$$
> 
> Thus, $A = \begin{bmatrix} 3 & 1 \\ 5 & 7 \\ 1 & 3 \end{bmatrix}$.
> 
> 1. **Testing One-to-One:**  
>    The two columns of $A$, $\begin{bmatrix} 3 \\ 5 \\ 1 \end{bmatrix}$ and $\begin{bmatrix} 1 \\ 7 \\ 3 \end{bmatrix}$, are not scalar multiples of each other. Because the columns are linearly independent, $T$ is ***one-to-one***.
> 
> 2. **Testing Onto:**  
>    The matrix $A$ is $3 \times 2$. To span $\mathbb{R}^3$, $A$ must have a pivot in every one of its 3 rows. However, since $A$ has only 2 columns, it can have at most 2 pivots. Thus, the columns cannot span $\mathbb{R}^3$, and $T$ is ***not onto*** $\mathbb{R}^3$.
>    ![[Pasted image 20260921204910.png]]
>    Figur: The transformation T is not onto R3


