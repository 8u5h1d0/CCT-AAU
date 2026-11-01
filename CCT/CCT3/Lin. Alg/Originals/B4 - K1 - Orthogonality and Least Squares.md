---
tags:
  - CCT3
  - Lin_Algebra
Topic: Inner Product, Length, Orthogonality, Least Squares, Orthogonal Sets
Semester: CCT3
Course: Linær Algebra
Litterature:
  - Linear Algebra and Its Applications, Global Edition, 6ed
Created: 01-11-2026
---

## Table of Contents

1. [[#6 Orthogonality and Least Squares|6 Orthogonality and Least Squares]]
	1. [[#6 Orthogonality and Least Squares#Introductory Example: Artificial Intelligence and Machine Learning|Introductory Example: Artificial Intelligence and Machine Learning]]
	2. [[#6 Orthogonality and Least Squares#6.1 Inner Product, Length, and Orthogonality|6.1 Inner Product, Length, and Orthogonality]]
		1. [[#6.1 Inner Product, Length, and Orthogonality#The Inner Product|The Inner Product]]
		2. [[#6.1 Inner Product, Length, and Orthogonality#The Length of a Vector|The Length of a Vector]]
		3. [[#6.1 Inner Product, Length, and Orthogonality#Distance in $\mathbb{R}^n$|Distance in $\mathbb{R}^n$]]
		4. [[#6.1 Inner Product, Length, and Orthogonality#Orthogonal Vectors|Orthogonal Vectors]]
		5. [[#6.1 Inner Product, Length, and Orthogonality#Orthogonal Complements|Orthogonal Complements]]
		6. [[#6.1 Inner Product, Length, and Orthogonality#Angles in $\mathbb{R}^2$ and $\mathbb{R}^3$ (Optional)|Angles in $\mathbb{R}^2$ and $\mathbb{R}^3$ (Optional)]]
	3. [[#6 Orthogonality and Least Squares#6.2 Orthogonal Sets|6.2 Orthogonal Sets]]
		1. [[#6.2 Orthogonal Sets#Orthogonal Bases|Orthogonal Bases]]
		2. [[#6.2 Orthogonal Sets#Orthogonal Projection|Orthogonal Projection]]
		3. [[#6.2 Orthogonal Sets#Geometric Interpretation|Geometric Interpretation]]
		4. [[#6.2 Orthogonal Sets#Orthonormal Sets|Orthonormal Sets]]
		5. [[#6.2 Orthogonal Sets#Matrices with Orthonormal Columns|Matrices with Orthonormal Columns]]
		6. [[#6.2 Orthogonal Sets#Orthogonal Matrices|Orthogonal Matrices]]

# 6 Orthogonality and Least Squares

## Introductory Example: Artificial Intelligence and Machine Learning

Distinguishing a puppy from a kitten is trivial for the human eye but represents a significant challenge for machines. Advances in artificial intelligence (AI) and machine learning have rapidly improved computers' ability to interpret visual data — identifying patterns in pixels the way humans do naturally.

AI and machine learning are used across many industries:
- **Mail sorting:** Post office scanners read barcodes and handwriting on envelopes with precision and speed.
- **Retail:** Machine learning interprets color and shape patterns to design, display, and recommend clothing ensembles.
- **Customer service:** AI assistants handle service calls, answer simple questions, and even book appointments on a user's behalf.

At its core, AI and machine learning involve developing systems that interpret external data correctly, learn from it, and use that learning to achieve specific goals through flexibility and adaptation. The driving engine behind many of these techniques is *linear algebra* — particularly the concepts of orthogonality and least-squares approximation developed in this chapter.

This chapter introduces the concepts of *distance* and *orthogonality* in a vector space, then shows how orthogonality can identify the point within a subspace $W$ that is nearest to a point $\mathbf{y}$ lying outside of $W$. By taking $W$ to be the column space of a matrix, a method for producing approximate ("least-squares") solutions for inconsistent linear systems is developed — a technique central to machine learning. Orthogonal projections are also used to create matrix factorizations widely used in numerical linear algebra, and least-squares problems are explored in vector spaces more general than $\mathbb{R}^n$.

---

## 6.1 Inner Product, Length, and Orthogonality

Geometric concepts of length, distance, and perpendicularity — well known for $\mathbb{R}^2$ and $\mathbb{R}^3$ — are generalized here to $\mathbb{R}^n$. These concepts provide powerful geometric tools for solving many applied problems, including least-squares problems. All three notions are defined in terms of the *inner product* of two vectors.

### The Inner Product

If $\mathbf{u}$ and $\mathbf{v}$ are vectors in $\mathbb{R}^n$, they can be regarded as $n \times 1$ matrices. The transpose $\mathbf{u}^T$ is a $1 \times n$ matrix, and the matrix product $\mathbf{u}^T \mathbf{v}$ is a $1 \times 1$ matrix, which is written as a single real number (a scalar) without brackets.

> [!info] **Inner Product (Dot Product)**
> The *inner product* of $\mathbf{u}$ and $\mathbf{v}$ in $\mathbb{R}^n$ is the scalar $\mathbf{u}^T \mathbf{v}$, often written as $\mathbf{u} \cdot \mathbf{v}$.
> 
> If $\mathbf{u} = \begin{bmatrix} u_1 \\ u_2 \\ \vdots \\ u_n \end{bmatrix}$ and $\mathbf{v} = \begin{bmatrix} v_1 \\ v_2 \\ \vdots \\ v_n \end{bmatrix}$, then:
> 
> $$\mathbf{u} \cdot \mathbf{v} = u_1 v_1 + u_2 v_2 + \cdots + u_n v_n$$
> ![[Pasted image 20261101154745.png]]

> [!example] **Computing the Inner Product**
> Let $\mathbf{u} = \begin{bmatrix} 2 \\ -5 \\ 1 \end{bmatrix}$ and $\mathbf{v} = \begin{bmatrix} 3 \\ 2 \\ -3 \end{bmatrix}$.
> 
> $$\mathbf{u} \cdot \mathbf{v} = (2)(3) + (-5)(2) + (1)(-3) = 6 - 10 - 3 = -7$$
> 
> $$\mathbf{v} \cdot \mathbf{u} = (3)(2) + (2)(-5) + (-3)(1) = 6 - 10 - 3 = -7$$
> 
> This confirms that $\mathbf{u} \cdot \mathbf{v} = \mathbf{v} \cdot \mathbf{u}$ (commutativity).

> [!summary] **Theorem 1: Properties of the Inner Product**
> Let $\mathbf{u}$, $\mathbf{v}$, and $\mathbf{w}$ be vectors in $\mathbb{R}^n$, and let $c$ be a scalar. Then:
> 
> a. $\mathbf{u} \cdot \mathbf{v} = \mathbf{v} \cdot \mathbf{u}$
> b. $(\mathbf{u} + \mathbf{v}) \cdot \mathbf{w} = \mathbf{u} \cdot \mathbf{w} + \mathbf{v} \cdot \mathbf{w}$
> c. $(c\mathbf{u}) \cdot \mathbf{v} = c(\mathbf{u} \cdot \mathbf{v}) = \mathbf{u} \cdot (c\mathbf{v})$
> d. $\mathbf{u} \cdot \mathbf{u} \geq 0$, and $\mathbf{u} \cdot \mathbf{u} = 0$ if and only if $\mathbf{u} = \mathbf{0}$
> 
> **Breakdown:**
> - **Property (a):** *Commutativity* — the order of the dot product does not matter.
> - **Property (b):** *Distributivity* — the inner product distributes over vector addition.
> - **Property (c):** *Scalar associativity* — a scalar can be factored out from either vector.
> - **Property (d):** *Positive definiteness* — a vector dotted with itself is always non-negative, and is zero only for the zero vector.

Properties (b) and (c) can be combined to produce the useful rule:

$$(c_1 \mathbf{u}_1 + \cdots + c_p \mathbf{u}_p) \cdot \mathbf{w} = c_1(\mathbf{u}_1 \cdot \mathbf{w}) + \cdots + c_p(\mathbf{u}_p \cdot \mathbf{w})$$

### The Length of a Vector

Since $\mathbf{v} \cdot \mathbf{v} \geq 0$ for any $\mathbf{v}$ in $\mathbb{R}^n$, the square root of $\mathbf{v} \cdot \mathbf{v}$ is always well-defined.

> [!info] **Length (Norm) of a Vector**
> The *length* (or *norm*) of $\mathbf{v}$ is the nonnegative scalar $\|\mathbf{v}\|$ defined by:
> 
> $$\|\mathbf{v}\| = \sqrt{\mathbf{v} \cdot \mathbf{v}} = \sqrt{v_1^2 + v_2^2 + \cdots + v_n^2}$$
> 
> and $\|\mathbf{v}\|^2 = \mathbf{v} \cdot \mathbf{v}$.

In $\mathbb{R}^2$, if $\mathbf{v} = \begin{bmatrix} a \\ b \end{bmatrix}$, then $\|\mathbf{v}\| = \sqrt{a^2 + b^2}$, which coincides with the standard geometric length of the line segment from the origin to the point $(a, b)$ by the Pythagorean Theorem. The same holds in $\mathbb{R}^3$ using the diagonal of a rectangular box.
![[Pasted image 20261101154812.png]]
FIGURE 1 Interpretation of kvk as length.

**Scalar multiplication and length:** For any scalar $c$,

$$\|c\mathbf{v}\| = |c| \|\mathbf{v}\|$$

This follows from $\|c\mathbf{v}\|^2 = (c\mathbf{v}) \cdot (c\mathbf{v}) = c^2 (\mathbf{v} \cdot \mathbf{v}) = c^2 \|\mathbf{v}\|^2$, then taking square roots.

**Unit vectors and normalizing:** A vector whose length is 1 is called a *unit vector*. Dividing a nonzero vector $\mathbf{v}$ by its length produces a unit vector $\mathbf{u}$ in the same direction:

$$\mathbf{u} = \frac{1}{\|\mathbf{v}\|} \mathbf{v}$$

This process is called *normalizing* $\mathbf{v}$.
![[Pasted image 20261101154841.png]]
FIGURE 2 Normalizing a vector to produce a unit vector.

> [!example] **Normalizing a Vector**
> Let $\mathbf{v} = (1, -2, 2, 0)$. Find a unit vector $\mathbf{u}$ in the same direction.
> 
> **Step 1:** Compute the length.
> $$\|\mathbf{v}\|^2 = (1)^2 + (-2)^2 + (2)^2 + (0)^2 = 1 + 4 + 4 + 0 = 9$$
> $$\|\mathbf{v}\| = \sqrt{9} = 3$$
> 
> **Step 2:** Multiply by $1/\|\mathbf{v}\|$.
> $$\mathbf{u} = \frac{1}{3} \begin{bmatrix} 1 \\ -2 \\ 2 \\ 0 \end{bmatrix} = \begin{bmatrix} 1/3 \\ -2/3 \\ 2/3 \\ 0 \end{bmatrix}$$
> 
> **Verification:** $\|\mathbf{u}\|^2 = (1/3)^2 + (-2/3)^2 + (2/3)^2 + 0 = \frac{1}{9} + \frac{4}{9} + \frac{4}{9} = 1$. ✓

> [!example] **Normalizing to Find a Basis Unit Vector**
> Let $W$ be the subspace of $\mathbb{R}^2$ spanned by $\mathbf{x} = (-2/3, 1)$. Find a unit vector $\mathbf{z}$ that is a basis for $W$.
> 
> $W$ consists of all multiples of $\mathbf{x}$. To simplify, scale $\mathbf{x}$ by 3 to eliminate fractions: $\mathbf{y} = (-2, 3)$.
> 
> $$\|\mathbf{y}\|^2 = (-2)^2 + 3^2 = 4 + 9 = 13, \quad \|\mathbf{y}\| = \sqrt{13}$$
> 
> Normalize:
> $$\mathbf{z} = \frac{1}{\sqrt{13}} \begin{bmatrix} -2 \\ 3 \end{bmatrix} = \begin{bmatrix} -2/\sqrt{13} \\ 3/\sqrt{13} \end{bmatrix}$$
> 
> Another valid unit vector in $W$ is $(2/\sqrt{13}, -3/\sqrt{13})$ (the opposite direction).

### Distance in $\mathbb{R}^n$

Recall that for real numbers $a$ and $b$, the distance on the number line is $|a - b|$. This generalizes directly to $\mathbb{R}^n$.

> [!info] **Distance Between Vectors**
> For $\mathbf{u}$ and $\mathbf{v}$ in $\mathbb{R}^n$, the *distance* between $\mathbf{u}$ and $\mathbf{v}$ is:
> 
> $$\text{dist}(\mathbf{u}, \mathbf{v}) = \|\mathbf{u} - \mathbf{v}\|$$

In $\mathbb{R}^2$ and $\mathbb{R}^3$, this coincides with the standard Euclidean distance formula. Geometrically, the distance from $\mathbf{u}$ to $\mathbf{v}$ is the same as the distance from $\mathbf{u} - \mathbf{v}$ to the origin $\mathbf{0}$.
![[Pasted image 20261101154901.png]]
FIGURE 3 Distances in R.

> [!example] **Computing Distance**
> Let $\mathbf{u} = (7, 1)$ and $\mathbf{v} = (3, 2)$.
> 
> $$\mathbf{u} - \mathbf{v} = \begin{bmatrix} 7 \\ 1 \end{bmatrix} - \begin{bmatrix} 3 \\ 2 \end{bmatrix} = \begin{bmatrix} 4 \\ -1 \end{bmatrix}$$
> 
> $$\text{dist}(\mathbf{u}, \mathbf{v}) = \|\mathbf{u} - \mathbf{v}\| = \sqrt{4^2 + (-1)^2} = \sqrt{17}$$

In $\mathbb{R}^3$, for $\mathbf{u} = (u_1, u_2, u_3)$ and $\mathbf{v} = (v_1, v_2, v_3)$:

$$\text{dist}(\mathbf{u}, \mathbf{v}) = \sqrt{(u_1 - v_1)^2 + (u_2 - v_2)^2 + (u_3 - v_3)^2}$$
![[Pasted image 20261101154926.png]]
FIGURE 4 The distance between u and v is the length of u v.
### Orthogonal Vectors

The concept of perpendicular lines in Euclidean geometry generalizes to $\mathbb{R}^n$ through the inner product. The key insight is that two lines through the origin determined by vectors $\mathbf{u}$ and $\mathbf{v}$ are perpendicular if and only if the distance from $\mathbf{u}$ to $\mathbf{v}$ equals the distance from $\mathbf{u}$ to $-\mathbf{v}$.
![[Pasted image 20261101154940.png]]
FIGURE 5

Expanding the squared distances:

$$[\text{dist}(\mathbf{u}, -\mathbf{v})]^2 = \|\mathbf{u} + \mathbf{v}\|^2 = \|\mathbf{u}\|^2 + \|\mathbf{v}\|^2 + 2\mathbf{u} \cdot \mathbf{v}$$

$$[\text{dist}(\mathbf{u}, \mathbf{v})]^2 = \|\mathbf{u} - \mathbf{v}\|^2 = \|\mathbf{u}\|^2 + \|\mathbf{v}\|^2 - 2\mathbf{u} \cdot \mathbf{v}$$

These are equal if and only if $2\mathbf{u} \cdot \mathbf{v} = -2\mathbf{u} \cdot \mathbf{v}$, which happens if and only if $\mathbf{u} \cdot \mathbf{v} = 0$.

> [!info] **Orthogonal Vectors**
> Two vectors $\mathbf{u}$ and $\mathbf{v}$ in $\mathbb{R}^n$ are *orthogonal* (to each other) if $\mathbf{u} \cdot \mathbf{v} = 0$.

The zero vector is orthogonal to every vector in $\mathbb{R}^n$ because $\mathbf{0}^T \mathbf{v} = 0$ for all $\mathbf{v}$.

> [!summary] **Theorem 2: The Pythagorean Theorem**
> Two vectors $\mathbf{u}$ and $\mathbf{v}$ are orthogonal if and only if:
> 
> $$\|\mathbf{u} + \mathbf{v}\|^2 = \|\mathbf{u}\|^2 + \|\mathbf{v}\|^2$$
> 
> **Breakdown:**
> - **$\|\mathbf{u} + \mathbf{v}\|^2$:** The squared length of the sum vector (the "hypotenuse" when $\mathbf{u}$ and $\mathbf{v}$ are placed tail-to-tail at right angles).
> - **$\|\mathbf{u}\|^2$:** The squared length of $\mathbf{u}$ (one "leg").
> - **$\|\mathbf{v}\|^2$:** The squared length of $\mathbf{v}$ (the other "leg").
> 
> This is the direct generalization of the classical Pythagorean Theorem ($a^2 + b^2 = c^2$) to $\mathbb{R}^n$. The proof follows immediately from expanding $\|\mathbf{u} + \mathbf{v}\|^2 = (\mathbf{u} + \mathbf{v}) \cdot (\mathbf{u} + \mathbf{v})$ and applying the condition $\mathbf{u} \cdot \mathbf{v} = 0$.
> ![[Pasted image 20261101155000.png]]
FIGURE 6

### Orthogonal Complements

If a vector $\mathbf{z}$ is orthogonal to *every* vector in a subspace $W$ of $\mathbb{R}^n$, then $\mathbf{z}$ is said to be *orthogonal to $W$*.

> [!info] **Orthogonal Complement**
> The *orthogonal complement* of a subspace $W$, denoted $W^\perp$ (read "W perp"), is the set of all vectors $\mathbf{z}$ that are orthogonal to every vector in $W$.

For example, if $W$ is a plane through the origin in $\mathbb{R}^3$ and $L$ is the line through the origin perpendicular to $W$, then every vector on $L$ is orthogonal to every vector in $W$. In this case, $L = W^\perp$ and $W = L^\perp$.
![[Pasted image 20261101155041.png]]
FIGURE 7 A plane and line through 0 as orthogonal complements.

Two key facts about $W^\perp$:

1. A vector $\mathbf{x}$ is in $W^\perp$ if and only if $\mathbf{x}$ is orthogonal to every vector in a set that *spans* $W$. (You only need to check orthogonality against a spanning set, not every vector in $W$.)
2. $W^\perp$ is a subspace of $\mathbb{R}^n$.

> [!summary] **Theorem 3: Orthogonal Complements of Fundamental Subspaces**
> Let $A$ be an $m \times n$ matrix. Then:
> 
> $$(\text{Row } A)^\perp = \text{Nul } A \qquad \text{and} \qquad (\text{Col } A)^\perp = \text{Nul } A^T$$
> 
> **Breakdown:**
> - **$\text{Row } A$:** The row space of $A$ — the subspace spanned by the rows of $A$ (vectors in $\mathbb{R}^n$).
> - **$\text{Nul } A$:** The null space of $A$ — the set of all $\mathbf{x}$ such that $A\mathbf{x} = \mathbf{0}$.
> - **$\text{Col } A$:** The column space of $A$ — the subspace spanned by the columns of $A$.
> - **$\text{Nul } A^T$:** The null space of $A^T$ — the set of all $\mathbf{y}$ such that $A^T \mathbf{y} = \mathbf{0}$.
> - **$(\cdot)^\perp$:** The orthogonal complement operator.
> 
> **Proof:**
> The row–column rule for computing $A\mathbf{x}$ shows that if $\mathbf{x}$ is in $\text{Nul } A$, then $\mathbf{x}$ is orthogonal to each row of $A$ (treating rows as vectors in $\mathbb{R}^n$). Since the rows of $A$ span the row space, $\mathbf{x}$ is orthogonal to $\text{Row } A$. Conversely, if $\mathbf{x}$ is orthogonal to $\text{Row } A$, then $\mathbf{x}$ is orthogonal to each row of $A$, and hence $A\mathbf{x} = \mathbf{0}$. This proves $(\text{Row } A)^\perp = \text{Nul } A$.
> 
> Since this statement holds for *any* matrix, it holds for $A^T$. That is, $(\text{Row } A^T)^\perp = \text{Nul } A^T$. Because $\text{Row } A^T = \text{Col } A$, this gives $(\text{Col } A)^\perp = \text{Nul } A^T$.
> ![[Pasted image 20261101155114.png]]
> FIGURE 8 The fundamental subspaces determined by an m n matrix A.

> [!tip] **Proving Set Equality**
> A common technique for proving two sets $S$ and $T$ are equal is to show $S \subseteq T$ and $T \subseteq S$ separately. In Theorem 3, this means showing an arbitrary element of $\text{Nul } A$ is in $(\text{Row } A)^\perp$, and vice versa.

### Angles in $\mathbb{R}^2$ and $\mathbb{R}^3$ (Optional)

For nonzero vectors $\mathbf{u}$ and $\mathbf{v}$ in $\mathbb{R}^2$ or $\mathbb{R}^3$, there is a direct connection between the inner product and the angle $\theta$ between the two line segments from the origin to the points identified with $\mathbf{u}$ and $\mathbf{v}$:

$$\mathbf{u} \cdot \mathbf{v} = \|\mathbf{u}\| \|\mathbf{v}\| \cos \theta$$

> [!info] **Angle Formula Breakdown**
> - **$\mathbf{u} \cdot \mathbf{v}$:** The inner (dot) product of the two vectors.
> - **$\|\mathbf{u}\|$, $\|\mathbf{v}\|$:** The lengths (norms) of $\mathbf{u}$ and $\mathbf{v}$.
> - **$\cos \theta$:** The cosine of the angle $\theta$ between the vectors.
> - **$\theta$:** The angle between the two vectors, measured at the origin.

This formula can be verified in $\mathbb{R}^2$ using the law of cosines on the triangle with sides $\|\mathbf{u}\|$, $\|\mathbf{v}\|$, and $\|\mathbf{u} - \mathbf{v}\|$:

$$\|\mathbf{u} - \mathbf{v}\|^2 = \|\mathbf{u}\|^2 + \|\mathbf{v}\|^2 - 2\|\mathbf{u}\|\|\mathbf{v}\|\cos\theta$$

Rearranging and expanding yields $\|\mathbf{u}\|\|\mathbf{v}\|\cos\theta = u_1 v_1 + u_2 v_2 = \mathbf{u} \cdot \mathbf{v}$.
![[Pasted image 20261101155133.png]]
FIGURE 9 The angle between two vectors.

When $n > 3$, this formula can be used to *define* the angle between two vectors in $\mathbb{R}^n$. In statistics, the value of $\cos \theta$ defined by this formula for suitable vectors is known as the *correlation coefficient*.

## 6.2 Orthogonal Sets

A set of vectors $\{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$ in $\mathbb{R}^n$ is said to be an *orthogonal set* if each pair of distinct vectors from the set is orthogonal — that is, $\mathbf{u}_i \cdot \mathbf{u}_j = 0$ whenever $i \neq j$.
![[Pasted image 20261101155201.png]]
FIGURE 1

> [!example] **Verifying an Orthogonal Set**
> Show that $\{\mathbf{u}_1, \mathbf{u}_2, \mathbf{u}_3\}$ is an orthogonal set, where:
> $$\mathbf{u}_1 = \begin{bmatrix} 3 \\ 1 \\ 1 \end{bmatrix}, \quad \mathbf{u}_2 = \begin{bmatrix} -1 \\ 2 \\ 1 \end{bmatrix}, \quad \mathbf{u}_3 = \begin{bmatrix} -1/2 \\ -2 \\ 7/2 \end{bmatrix}$$
> 
> Check all three pairs of distinct vectors:
> - $\mathbf{u}_1 \cdot \mathbf{u}_2 = (3)(-1) + (1)(2) + (1)(1) = -3 + 2 + 1 = 0$ ✓
> - $\mathbf{u}_1 \cdot \mathbf{u}_3 = (3)(-1/2) + (1)(-2) + (1)(7/2) = -3/2 - 2 + 7/2 = 0$ ✓
> - $\mathbf{u}_2 \cdot \mathbf{u}_3 = (-1)(-1/2) + (2)(-2) + (1)(7/2) = 1/2 - 4 + 7/2 = 0$ ✓
> 
> Each pair is orthogonal, so the set is an orthogonal set. The three vectors are mutually perpendicular.

> [!summary] **Theorem 4: Orthogonal Sets Are Linearly Independent**
> If $S = \{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$ is an orthogonal set of *nonzero* vectors in $\mathbb{R}^n$, then $S$ is linearly independent and hence is a basis for the subspace spanned by $S$.
> 
> **Breakdown:**
> - **Orthogonal set:** Every pair of distinct vectors has a dot product of zero.
> - **Nonzero vectors:** Each $\mathbf{u}_i \neq \mathbf{0}$, which guarantees $\mathbf{u}_i \cdot \mathbf{u}_i \neq 0$.
> - **Linearly independent:** No vector in the set can be written as a linear combination of the others.
> - **Basis for span:** Because the set is linearly independent, it automatically forms a basis for whatever subspace it spans.
> 
> **Proof:**
> Suppose $\mathbf{0} = c_1 \mathbf{u}_1 + \cdots + c_p \mathbf{u}_p$ for some scalars $c_1, \ldots, c_p$. Then:
> 
> $$0 = \mathbf{0} \cdot \mathbf{u}_1 = (c_1 \mathbf{u}_1 + c_2 \mathbf{u}_2 + \cdots + c_p \mathbf{u}_p) \cdot \mathbf{u}_1$$
> 
> By distributivity and the orthogonality condition ($\mathbf{u}_j \cdot \mathbf{u}_1 = 0$ for $j \neq 1$):
> 
> $$= c_1(\mathbf{u}_1 \cdot \mathbf{u}_1) + c_2(\mathbf{u}_2 \cdot \mathbf{u}_1) + \cdots + c_p(\mathbf{u}_p \cdot \mathbf{u}_1) = c_1(\mathbf{u}_1 \cdot \mathbf{u}_1)$$
> 
> Since $\mathbf{u}_1$ is nonzero, $\mathbf{u}_1 \cdot \mathbf{u}_1 \neq 0$, so $c_1 = 0$. The same argument applied to each $\mathbf{u}_j$ shows $c_2 = \cdots = c_p = 0$. Thus $S$ is linearly independent.

### Orthogonal Bases

> [!info] **Orthogonal Basis**
> An *orthogonal basis* for a subspace $W$ of $\mathbb{R}^n$ is a basis for $W$ that is also an orthogonal set.

The key advantage of an orthogonal basis over an arbitrary basis is that the weights in a linear combination can be computed directly — no system of equations needs to be solved.

> [!summary] **Theorem 5: Computing Weights with an Orthogonal Basis**
> Let $\{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$ be an orthogonal basis for a subspace $W$ of $\mathbb{R}^n$. For each $\mathbf{y}$ in $W$, the weights in the linear combination $\mathbf{y} = c_1 \mathbf{u}_1 + \cdots + c_p \mathbf{u}_p$ are given by:
> 
> $$c_j = \frac{\mathbf{y} \cdot \mathbf{u}_j}{\mathbf{u}_j \cdot \mathbf{u}_j} \quad (j = 1, \ldots, p)$$
> 
> **Breakdown:**
> - **$\mathbf{y}$:** The vector in $W$ being expressed as a linear combination of the basis vectors.
> - **$\mathbf{u}_j$:** The $j$-th basis vector in the orthogonal basis.
> - **$\mathbf{y} \cdot \mathbf{u}_j$:** The inner product of $\mathbf{y}$ with the $j$-th basis vector — this "extracts" the component of $\mathbf{y}$ in the direction of $\mathbf{u}_j$.
> - **$\mathbf{u}_j \cdot \mathbf{u}_j$:** The squared length of $\mathbf{u}_j$ — this normalizes the projection.
> - **$c_j$:** The weight (scalar coefficient) for $\mathbf{u}_j$ in the linear combination.
> 
> **Proof:**
> Take the dot product of both sides of $\mathbf{y} = c_1 \mathbf{u}_1 + \cdots + c_p \mathbf{u}_p$ with $\mathbf{u}_1$:
> 
> $$\mathbf{y} \cdot \mathbf{u}_1 = (c_1 \mathbf{u}_1 + c_2 \mathbf{u}_2 + \cdots + c_p \mathbf{u}_p) \cdot \mathbf{u}_1 = c_1(\mathbf{u}_1 \cdot \mathbf{u}_1)$$
> 
> All cross terms vanish due to orthogonality. Since $\mathbf{u}_1 \cdot \mathbf{u}_1 \neq 0$, solve for $c_1$. Repeat with $\mathbf{u}_j$ for each $j$.

> [!example] **Expressing a Vector Using an Orthogonal Basis**
> The set $S = \{\mathbf{u}_1, \mathbf{u}_2, \mathbf{u}_3\}$ from the earlier example is an orthogonal basis for $\mathbb{R}^3$. Express $\mathbf{y} = \begin{bmatrix} 6 \\ 1 \\ -8 \end{bmatrix}$ as a linear combination of the vectors in $S$.
> 
> **Step 1:** Compute the needed inner products.
> - $\mathbf{y} \cdot \mathbf{u}_1 = 11$, $\quad \mathbf{u}_1 \cdot \mathbf{u}_1 = 11$
> - $\mathbf{y} \cdot \mathbf{u}_2 = 12$, $\quad \mathbf{u}_2 \cdot \mathbf{u}_2 = 6$
> - $\mathbf{y} \cdot \mathbf{u}_3 = 33$, $\quad \mathbf{u}_3 \cdot \mathbf{u}_3 = 33/2$
> 
> **Step 2:** Apply the weight formula.
> $$\mathbf{y} = \frac{11}{11}\mathbf{u}_1 + \frac{12}{6}\mathbf{u}_2 + \frac{33}{33/2}\mathbf{u}_3 = 1\mathbf{u}_1 + 2\mathbf{u}_2 + 2\mathbf{u}_3$$
> 
> If the basis were *not* orthogonal, finding these weights would require solving a full system of linear equations.

### Orthogonal Projection

Given a nonzero vector $\mathbf{u}$ in $\mathbb{R}^n$, any vector $\mathbf{y}$ in $\mathbb{R}^n$ can be decomposed into the sum of two vectors: one that is a multiple of $\mathbf{u}$, and one that is orthogonal to $\mathbf{u}$. That is, we want to write:

$$\mathbf{y} = \hat{\mathbf{y}} + \mathbf{z}$$

where $\hat{\mathbf{y}} = \alpha \mathbf{u}$ for some scalar $\alpha$, and $\mathbf{z}$ is orthogonal to $\mathbf{u}$.
![[Pasted image 20261101155230.png]]
FIGURE 2 Finding ˛ to make y yO orthogonal to u.

Setting $\mathbf{z} = \mathbf{y} - \alpha \mathbf{u}$ and requiring $\mathbf{z} \cdot \mathbf{u} = 0$:

$$0 = (\mathbf{y} - \alpha \mathbf{u}) \cdot \mathbf{u} = \mathbf{y} \cdot \mathbf{u} - \alpha(\mathbf{u} \cdot \mathbf{u})$$

Solving gives $\alpha = \frac{\mathbf{y} \cdot \mathbf{u}}{\mathbf{u} \cdot \mathbf{u}}$.

> [!info] **Orthogonal Projection**
> The *orthogonal projection* of $\mathbf{y}$ onto $\mathbf{u}$ (or onto the line $L = \text{Span}\{\mathbf{u}\}$) is:
> 
> $$\hat{\mathbf{y}} = \text{proj}_L \mathbf{y} = \frac{\mathbf{y} \cdot \mathbf{u}}{\mathbf{u} \cdot \mathbf{u}} \mathbf{u}$$
> 
> The *component of $\mathbf{y}$ orthogonal to $\mathbf{u}$* is $\mathbf{z} = \mathbf{y} - \hat{\mathbf{y}}$.
> 
> **Breakdown:**
> - **$\hat{\mathbf{y}}$:** The projection vector — the part of $\mathbf{y}$ that lies along the direction of $\mathbf{u}$.
> - **$\mathbf{z}$:** The orthogonal component — the part of $\mathbf{y}$ that is perpendicular to $\mathbf{u}$.
> - **$\frac{\mathbf{y} \cdot \mathbf{u}}{\mathbf{u} \cdot \mathbf{u}}$:** The scalar that determines how far along $\mathbf{u}$ the projection reaches.
> - **$L = \text{Span}\{\mathbf{u}\}$:** The one-dimensional subspace (line through the origin) determined by $\mathbf{u}$. The projection depends only on this subspace, not on the specific choice of $\mathbf{u}$ — replacing $\mathbf{u}$ with $c\mathbf{u}$ (for any nonzero scalar $c$) gives the same projection.

> [!example] **Computing an Orthogonal Projection**
> Let $\mathbf{y} = \begin{bmatrix} 7 \\ 6 \end{bmatrix}$ and $\mathbf{u} = \begin{bmatrix} 4 \\ 2 \end{bmatrix}$. Find the orthogonal projection of $\mathbf{y}$ onto $\mathbf{u}$, then decompose $\mathbf{y}$.
> 
> **Step 1:** Compute inner products.
> $$\mathbf{y} \cdot \mathbf{u} = (7)(4) + (6)(2) = 28 + 12 = 40$$
> $$\mathbf{u} \cdot \mathbf{u} = (4)(4) + (2)(2) = 16 + 4 = 20$$
> 
> **Step 2:** Compute the projection.
> $$\hat{\mathbf{y}} = \frac{40}{20} \mathbf{u} = 2 \begin{bmatrix} 4 \\ 2 \end{bmatrix} = \begin{bmatrix} 8 \\ 4 \end{bmatrix}$$
> 
> **Step 3:** Compute the orthogonal component.
> $$\mathbf{z} = \mathbf{y} - \hat{\mathbf{y}} = \begin{bmatrix} 7 \\ 6 \end{bmatrix} - \begin{bmatrix} 8 \\ 4 \end{bmatrix} = \begin{bmatrix} -1 \\ 2 \end{bmatrix}$$
> 
> **Verification:** $\hat{\mathbf{y}} \cdot \mathbf{z} = (8)(-1) + (4)(2) = -8 + 8 = 0$ ✓ — the two components are indeed orthogonal.
> 
> **Decomposition:** $\mathbf{y} = \begin{bmatrix} 8 \\ 4 \end{bmatrix} + \begin{bmatrix} -1 \\ 2 \end{bmatrix}$, where the first vector is in $\text{Span}\{\mathbf{u}\}$ and the second is orthogonal to $\mathbf{u}$.

The point identified with $\hat{\mathbf{y}}$ is the *closest point* on the line $L$ to $\mathbf{y}$, because the line segment between $\mathbf{y}$ and $\hat{\mathbf{y}}$ is perpendicular to $L$ by construction. The distance from $\mathbf{y}$ to $L$ is therefore $\|\mathbf{y} - \hat{\mathbf{y}}\|$. In the example above, this distance is $\sqrt{(-1)^2 + 2^2} = \sqrt{5}$.
![[Pasted image 20261101155250.png]]
FIGURE 3 The orthogonal projection of y onto a line L through the origin.

### Geometric Interpretation

The formula for each weight $c_j = \frac{\mathbf{y} \cdot \mathbf{u}_j}{\mathbf{u}_j \cdot \mathbf{u}_j}$ in Theorem 5 has the same form as the scalar in the orthogonal projection formula. This means Theorem 5 decomposes a vector $\mathbf{y}$ into a *sum of orthogonal projections* onto one-dimensional subspaces.

For instance, if $W = \mathbb{R}^2 = \text{Span}\{\mathbf{u}_1, \mathbf{u}_2\}$ with $\mathbf{u}_1$ and $\mathbf{u}_2$ orthogonal, then any $\mathbf{y}$ in $\mathbb{R}^2$ can be written as:

$$\mathbf{y} = \frac{\mathbf{y} \cdot \mathbf{u}_1}{\mathbf{u}_1 \cdot \mathbf{u}_1} \mathbf{u}_1 + \frac{\mathbf{y} \cdot \mathbf{u}_2}{\mathbf{u}_2 \cdot \mathbf{u}_2} \mathbf{u}_2$$

The first term is the projection of $\mathbf{y}$ onto the line through $\mathbf{u}_1$, and the second is the projection onto the line through $\mathbf{u}_2$. This expresses $\mathbf{y}$ as the sum of its projections onto the orthogonal axes determined by $\mathbf{u}_1$ and $\mathbf{u}_2$. In general, Theorem 5 decomposes each $\mathbf{y}$ in $\text{Span}\{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$ into the sum of $p$ projections onto mutually orthogonal one-dimensional subspaces.
![[Pasted image 20261101155319.png]]
FIGURE 4 A vector decomposed into the sum of two projections.

This decomposition arises naturally in physics when a force vector $\mathbf{y}$ is broken into a component along a direction of interest $\mathbf{u}$ (e.g., the direction of motion) and a component orthogonal to $\mathbf{u}$.

### Orthonormal Sets

> [!info] **Orthonormal Set and Orthonormal Basis**
> A set $\{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$ is an *orthonormal set* if it is an orthogonal set of *unit vectors* (each vector has length 1). If $W$ is the subspace spanned by such a set, then $\{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$ is an *orthonormal basis* for $W$, since the set is automatically linearly independent by Theorem 4.

The simplest example of an orthonormal set is the standard basis $\{\mathbf{e}_1, \ldots, \mathbf{e}_n\}$ for $\mathbb{R}^n$. Any nonempty subset of the standard basis is also orthonormal.

When the vectors in an orthogonal set of nonzero vectors are *normalized* (divided by their lengths to produce unit vectors), the resulting vectors remain orthogonal, so the new set is orthonormal.

> [!example] **Verifying an Orthonormal Basis**
> Show that $\{\mathbf{v}_1, \mathbf{v}_2, \mathbf{v}_3\}$ is an orthonormal basis of $\mathbb{R}^3$, where:
> $$\mathbf{v}_1 = \begin{bmatrix} 3/\sqrt{11} \\ 1/\sqrt{11} \\ 1/\sqrt{11} \end{bmatrix}, \quad \mathbf{v}_2 = \begin{bmatrix} -1/\sqrt{6} \\ 2/\sqrt{6} \\ 1/\sqrt{6} \end{bmatrix}, \quad \mathbf{v}_3 = \begin{bmatrix} -1/\sqrt{66} \\ -4/\sqrt{66} \\ 7/\sqrt{66} \end{bmatrix}$$
> 
> **Orthogonality check:**
> - $\mathbf{v}_1 \cdot \mathbf{v}_2 = -3/\sqrt{66} + 2/\sqrt{66} + 1/\sqrt{66} = 0$ ✓
> - $\mathbf{v}_1 \cdot \mathbf{v}_3 = -3/\sqrt{726} - 4/\sqrt{726} + 7/\sqrt{726} = 0$ ✓
> - $\mathbf{v}_2 \cdot \mathbf{v}_3 = 1/\sqrt{396} - 8/\sqrt{396} + 7/\sqrt{396} = 0$ ✓
> 
> **Unit length check:**
> - $\mathbf{v}_1 \cdot \mathbf{v}_1 = 9/11 + 1/11 + 1/11 = 1$ ✓
> - $\mathbf{v}_2 \cdot \mathbf{v}_2 = 1/6 + 4/6 + 1/6 = 1$ ✓
> - $\mathbf{v}_3 \cdot \mathbf{v}_3 = 1/66 + 16/66 + 49/66 = 1$ ✓
> 
> The set is orthonormal and linearly independent, so it forms an orthonormal basis for $\mathbb{R}^3$.
> ![[Pasted image 20261101155348.png]]
> FIGURE 6

### Matrices with Orthonormal Columns

Matrices whose columns form an orthonormal set are important in applications and in computer algorithms for matrix computations.

> [!summary] **Theorem 6: Characterization of Orthonormal Columns**
> An $m \times n$ matrix $U$ has orthonormal columns if and only if $U^T U = I$.
> 
> **Breakdown:**
> - **$U$:** An $m \times n$ matrix whose columns are vectors $\mathbf{u}_1, \ldots, \mathbf{u}_n$ in $\mathbb{R}^m$.
> - **$U^T$:** The transpose of $U$, an $n \times m$ matrix whose rows are $\mathbf{u}_1^T, \ldots, \mathbf{u}_n^T$.
> - **$U^T U$:** An $n \times n$ matrix whose $(i, j)$-entry is $\mathbf{u}_i^T \mathbf{u}_j = \mathbf{u}_i \cdot \mathbf{u}_j$.
> - **$I$:** The $n \times n$ identity matrix (1s on the diagonal, 0s elsewhere).
> 
> **Proof:**
> Writing $U = [\mathbf{u}_1 \;\; \mathbf{u}_2 \;\; \mathbf{u}_3]$ (three columns for simplicity), the product $U^T U$ yields a matrix whose entries are all pairwise inner products:
> 
> $$U^T U = \begin{bmatrix} \mathbf{u}_1^T \mathbf{u}_1 & \mathbf{u}_1^T \mathbf{u}_2 & \mathbf{u}_1^T \mathbf{u}_3 \\ \mathbf{u}_2^T \mathbf{u}_1 & \mathbf{u}_2^T \mathbf{u}_2 & \mathbf{u}_2^T \mathbf{u}_3 \\ \mathbf{u}_3^T \mathbf{u}_1 & \mathbf{u}_3^T \mathbf{u}_2 & \mathbf{u}_3^T \mathbf{u}_3 \end{bmatrix}$$
> 
> The columns are orthogonal if and only if all off-diagonal entries are zero ($\mathbf{u}_i^T \mathbf{u}_j = 0$ for $i \neq j$). The columns have unit length if and only if all diagonal entries are one ($\mathbf{u}_i^T \mathbf{u}_i = 1$). Together, these conditions are equivalent to $U^T U = I$.

> [!summary] **Theorem 7: Preservation of Lengths and Orthogonality**
> Let $U$ be an $m \times n$ matrix with orthonormal columns, and let $\mathbf{x}$ and $\mathbf{y}$ be in $\mathbb{R}^n$. Then:
> 
> a. $\|U\mathbf{x}\| = \|\mathbf{x}\|$
> b. $(U\mathbf{x}) \cdot (U\mathbf{y}) = \mathbf{x} \cdot \mathbf{y}$
> c. $(U\mathbf{x}) \cdot (U\mathbf{y}) = 0$ if and only if $\mathbf{x} \cdot \mathbf{y} = 0$
> 
> **Breakdown:**
> - **Property (a):** *Length preservation* — multiplying by $U$ does not change the length of a vector.
> - **Property (b):** *Inner product preservation* — the dot product of two vectors is unchanged after multiplication by $U$.
> - **Property (c):** *Orthogonality preservation* — two vectors are orthogonal before the transformation if and only if they are orthogonal after.
> 
> Properties (a) and (c) together mean the linear mapping $\mathbf{x} \mapsto U\mathbf{x}$ preserves the geometric structure (lengths and angles) of vectors. These properties are crucial for many computer algorithms.

> [!example] **Verifying Length Preservation**
> Let $U = \begin{bmatrix} 1/\sqrt{2} & -2/3 \\ 1/\sqrt{2} & 2/3 \\ 0 & 1/3 \end{bmatrix}$ and $\mathbf{x} = \begin{bmatrix} \sqrt{2} \\ 3 \end{bmatrix}$.
> 
> The columns of $U$ are orthonormal, and $U^T U = \begin{bmatrix} 1 & 0 \\ 0 & 1 \end{bmatrix} = I$.
> 
> Compute $U\mathbf{x}$:
> $$U\mathbf{x} = \begin{bmatrix} 1/\sqrt{2} & -2/3 \\ 1/\sqrt{2} & 2/3 \\ 0 & 1/3 \end{bmatrix} \begin{bmatrix} \sqrt{2} \\ 3 \end{bmatrix} = \begin{bmatrix} 1 - 2 \\ 1 + 2 \\ 0 + 1 \end{bmatrix} = \begin{bmatrix} -1 \\ 3 \\ 1 \end{bmatrix}$$
> 
> Verify lengths:
> $$\|U\mathbf{x}\| = \sqrt{(-1)^2 + 3^2 + 1^2} = \sqrt{11}$$
> $$\|\mathbf{x}\| = \sqrt{(\sqrt{2})^2 + 3^2} = \sqrt{2 + 9} = \sqrt{11}$$
> 
> The lengths are equal, confirming $\|U\mathbf{x}\| = \|\mathbf{x}\|$. ✓

### Orthogonal Matrices

An *orthogonal matrix* is a square invertible matrix $U$ such that $U^{-1} = U^T$. By Theorem 6, such a matrix has orthonormal columns. Conversely, any square matrix with orthonormal columns is an orthogonal matrix. A perhaps surprising consequence is that an orthogonal matrix must also have orthonormal *rows*.

> [!example] **An Orthogonal Matrix**
> The matrix
> $$U = \begin{bmatrix} 3/\sqrt{11} & -1/\sqrt{6} & -1/\sqrt{66} \\ 1/\sqrt{11} & 2/\sqrt{6} & -4/\sqrt{66} \\ 1/\sqrt{11} & 1/\sqrt{6} & 7/\sqrt{66} \end{bmatrix}$$
> is an orthogonal matrix because it is square and its columns are orthonormal. Its rows are orthonormal as well.