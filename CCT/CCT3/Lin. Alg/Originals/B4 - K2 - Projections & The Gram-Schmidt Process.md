---
tags:
  - CCT3
  - Lin_Algebra
Topic: "Orthogonal Projections, A Geometric Interpretation of the Orthogonal\r

  Projection, The Gram Schmidt Process, Orthonormal Bases, QR Factorization of Matrices."
Semester: CCT3
Course: Linær Algebra
Litterature:
  - Linear Algebra and Its Applications, Global Edition, 6ed
Created: 05-11-2026
---
## Table of Contents

1. [[#6.3 Orthogonal Projections|6.3 Orthogonal Projections]]
	1. [[#6.3 Orthogonal Projections#Decomposing a Vector into Two Parts|Decomposing a Vector into Two Parts]]
	2. [[#6.3 Orthogonal Projections#The Orthogonal Decomposition Theorem|The Orthogonal Decomposition Theorem]]
	3. [[#6.3 Orthogonal Projections#Geometric Interpretation of the Orthogonal Projection|Geometric Interpretation of the Orthogonal Projection]]
2. [[#6.4 The Gram–Schmidt Process|6.4 The Gram–Schmidt Process]]
	1. [[#6.4 The Gram–Schmidt Process#The Gram–Schmidt Process (Formal Statement)|The Gram–Schmidt Process (Formal Statement)]]
	2. [[#6.4 The Gram–Schmidt Process#Orthonormal Bases|Orthonormal Bases]]
	3. [[#6.4 The Gram–Schmidt Process#QR Factorization of Matrices|QR Factorization of Matrices]]
	4. [[#6.4 The Gram–Schmidt Process#Numerical Notes|Numerical Notes]]

## 6.3 Orthogonal Projections

The orthogonal projection of a point in $\mathbb{R}^2$ onto a line through the origin generalizes naturally to $\mathbb{R}^n$. Given a vector $\mathbf{y}$ and a subspace $W$ in $\mathbb{R}^n$, there exists a vector $\hat{\mathbf{y}}$ in $W$ satisfying two key properties:

1. $\hat{\mathbf{y}}$ is the **unique** vector in $W$ for which $\mathbf{y} - \hat{\mathbf{y}}$ is orthogonal to $W$.
2. $\hat{\mathbf{y}}$ is the **unique** vector in $W$ closest to $\mathbf{y}$.

These two properties are the foundation for finding least-squares solutions of linear systems.
![[Pasted image 20261105153949.png]]
FIGURE 1
### Decomposing a Vector into Two Parts

Whenever a vector $\mathbf{y}$ is expressed as a linear combination of vectors $\mathbf{u}_1, \ldots, \mathbf{u}_n$ in $\mathbb{R}^n$, the terms can be grouped into two parts so that:

$$\mathbf{y} = \mathbf{z}_1 + \mathbf{z}_2$$

where $\mathbf{z}_1$ is a linear combination of some of the $\mathbf{u}_i$ and $\mathbf{z}_2$ is a linear combination of the rest. This grouping is especially powerful when $\{\mathbf{u}_1, \ldots, \mathbf{u}_n\}$ is an orthogonal basis. The notation $W^\perp$ denotes the set of all vectors orthogonal to a subspace $W$ (the _orthogonal complement_ of $W$).

> [!example] **Decomposition Using an Orthogonal Basis for $\mathbb{R}^5$**
> Let $\{\mathbf{u}_1, \ldots, \mathbf{u}_5\}$ be an orthogonal basis for $\mathbb{R}^5$ and let $\mathbf{y} = c_1\mathbf{u}_1 + \cdots + c_5\mathbf{u}_5$. Consider the subspace $W = \text{Span}\{\mathbf{u}_1, \mathbf{u}_2\}$. We write $\mathbf{y}$ as the sum of a vector $\mathbf{z}_1 \in W$ and a vector $\mathbf{z}_2 \in W^\perp$.
> 
> **Solution:**
> $$\mathbf{y} = \underbrace{c_1\mathbf{u}_1 + c_2\mathbf{u}_2}_{\mathbf{z}_1} + \underbrace{c_3\mathbf{u}_3 + c_4\mathbf{u}_4 + c_5\mathbf{u}_5}_{\mathbf{z}_2}$$
> 
> - $\mathbf{z}_1 = c_1\mathbf{u}_1 + c_2\mathbf{u}_2$ is in $\text{Span}\{\mathbf{u}_1, \mathbf{u}_2\} = W$.
> - $\mathbf{z}_2 = c_3\mathbf{u}_3 + c_4\mathbf{u}_4 + c_5\mathbf{u}_5$ is in $\text{Span}\{\mathbf{u}_3, \mathbf{u}_4, \mathbf{u}_5\}$.
> 
> To verify $\mathbf{z}_2 \in W^\perp$, show that $\mathbf{z}_2$ is orthogonal to each basis vector of $W$:
> $$\mathbf{z}_2 \cdot \mathbf{u}_1 = (c_3\mathbf{u}_3 + c_4\mathbf{u}_4 + c_5\mathbf{u}_5) \cdot \mathbf{u}_1 = c_3(\mathbf{u}_3 \cdot \mathbf{u}_1) + c_4(\mathbf{u}_4 \cdot \mathbf{u}_1) + c_5(\mathbf{u}_5 \cdot \mathbf{u}_1) = 0$$
> because $\mathbf{u}_1$ is orthogonal to $\mathbf{u}_3$, $\mathbf{u}_4$, and $\mathbf{u}_5$. A similar calculation shows $\mathbf{z}_2 \cdot \mathbf{u}_2 = 0$. Thus $\mathbf{z}_2 \in W^\perp$.

The key insight is that this decomposition can be computed without needing an orthogonal basis for all of $\mathbb{R}^n$ — an orthogonal basis for $W$ alone is sufficient.

### The Orthogonal Decomposition Theorem

> [!summary] **Theorem: The Orthogonal Decomposition Theorem**
> Let $W$ be a subspace of $\mathbb{R}^n$. Then each $\mathbf{y}$ in $\mathbb{R}^n$ can be written **uniquely** in the form:
> $$\mathbf{y} = \hat{\mathbf{y}} + \mathbf{z} \tag{1}$$
> where $\hat{\mathbf{y}}$ is in $W$ and $\mathbf{z}$ is in $W^\perp$. If $\{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$ is any orthogonal basis of $W$, then:
> $$\hat{\mathbf{y}} = \frac{\mathbf{y} \cdot \mathbf{u}_1}{\mathbf{u}_1 \cdot \mathbf{u}_1}\mathbf{u}_1 + \cdots + \frac{\mathbf{y} \cdot \mathbf{u}_p}{\mathbf{u}_p \cdot \mathbf{u}_p}\mathbf{u}_p \tag{2}$$
> and $\mathbf{z} = \mathbf{y} - \hat{\mathbf{y}}$.
> 
> **Breakdown:**
> - $\mathbf{y}$: The original vector in $\mathbb{R}^n$ being decomposed.
> - $\hat{\mathbf{y}}$: The _orthogonal projection_ of $\mathbf{y}$ onto $W$, also written $\text{proj}_W \mathbf{y}$. This is the component of $\mathbf{y}$ that lies within $W$.
> - $\mathbf{z}$: The component of $\mathbf{y}$ orthogonal to $W$ (i.e., $\mathbf{z} \in W^\perp$). Computed as $\mathbf{z} = \mathbf{y} - \hat{\mathbf{y}}$.
> - $W$: A subspace of $\mathbb{R}^n$ onto which we are projecting.
> - $W^\perp$: The _orthogonal complement_ of $W$ — the set of all vectors orthogonal to every vector in $W$.
> - $\{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$: Any orthogonal basis for $W$. The vectors must be mutually orthogonal but need not be unit vectors.
> - $\frac{\mathbf{y} \cdot \mathbf{u}_i}{\mathbf{u}_i \cdot \mathbf{u}_i}$: The scalar weight for each basis vector. It measures how much of $\mathbf{y}$ points in the direction of $\mathbf{u}_i$, normalized by the squared length of $\mathbf{u}_i$.
> 
> **Proof:**
> Let $\{\mathbf{u}_1, \ldots, \mathbf{u}_p\}$ be any orthogonal basis for $W$, and define $\hat{\mathbf{y}}$ by equation (2). Then $\hat{\mathbf{y}} \in W$ because it is a linear combination of the basis vectors. Let $\mathbf{z} = \mathbf{y} - \hat{\mathbf{y}}$.
> 
> Since $\mathbf{u}_1$ is orthogonal to $\mathbf{u}_2, \ldots, \mathbf{u}_p$, computing the dot product gives:
> $$\mathbf{z} \cdot \mathbf{u}_1 = (\mathbf{y} - \hat{\mathbf{y}}) \cdot \mathbf{u}_1 = \mathbf{y} \cdot \mathbf{u}_1 - \left(\frac{\mathbf{y} \cdot \mathbf{u}_1}{\mathbf{u}_1 \cdot \mathbf{u}_1}\right)(\mathbf{u}_1 \cdot \mathbf{u}_1) - 0 - \cdots - 0 = \mathbf{y} \cdot \mathbf{u}_1 - \mathbf{y} \cdot \mathbf{u}_1 = 0$$
> 
> Thus $\mathbf{z}$ is orthogonal to $\mathbf{u}_1$. By identical reasoning, $\mathbf{z}$ is orthogonal to each $\mathbf{u}_j$ in the basis for $W$, so $\mathbf{z} \in W^\perp$.
> 
> **Uniqueness:** Suppose $\mathbf{y} = \hat{\mathbf{y}}_1 + \mathbf{z}_1$ with $\hat{\mathbf{y}}_1 \in W$ and $\mathbf{z}_1 \in W^\perp$. Then $\hat{\mathbf{y}} + \mathbf{z} = \hat{\mathbf{y}}_1 + \mathbf{z}_1$, which rearranges to:
> $$\hat{\mathbf{y}} - \hat{\mathbf{y}}_1 = \mathbf{z}_1 - \mathbf{z}$$
> The left side is in $W$ and the right side is in $W^\perp$ (since $W^\perp$ is a subspace). The vector $\mathbf{v} = \hat{\mathbf{y}} - \hat{\mathbf{y}}_1$ is therefore in both $W$ and $W^\perp$, meaning $\mathbf{v} \cdot \mathbf{v} = 0$, so $\mathbf{v} = \mathbf{0}$. This proves $\hat{\mathbf{y}} = \hat{\mathbf{y}}_1$ and $\mathbf{z}_1 = \mathbf{z}$.
> 
> The uniqueness of the decomposition confirms that $\hat{\mathbf{y}}$ depends only on $W$, not on the particular orthogonal basis chosen.
> ![[Pasted image 20261105154031.png]]
> FIGURE 2 The orthogonal projection of y onto W .

> [!note]
> If $W$ is the zero subspace, then $W^\perp = \mathbb{R}^n$ and the decomposition is simply $\mathbf{y} = \mathbf{0} + \mathbf{y}$. Any nonzero subspace of $\mathbb{R}^n$ is guaranteed to have an orthogonal basis.

> [!example] **Computing an Orthogonal Decomposition**
> Let $\mathbf{u}_1 = \begin{bmatrix} 2 \\ 5 \\ 1 \end{bmatrix}$, $\mathbf{u}_2 = \begin{bmatrix} 2 \\ -1 \\ 1 \end{bmatrix}$, and $\mathbf{y} = \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix}$. The set $\{\mathbf{u}_1, \mathbf{u}_2\}$ is an orthogonal basis for $W = \text{Span}\{\mathbf{u}_1, \mathbf{u}_2\}$. Write $\mathbf{y}$ as the sum of a vector in $W$ and a vector orthogonal to $W$.
> 
> **Solution:**
> The orthogonal projection of $\mathbf{y}$ onto $W$ is:
> $$\hat{\mathbf{y}} = \frac{\mathbf{y} \cdot \mathbf{u}_1}{\mathbf{u}_1 \cdot \mathbf{u}_1}\mathbf{u}_1 + \frac{\mathbf{y} \cdot \mathbf{u}_2}{\mathbf{u}_2 \cdot \mathbf{u}_2}\mathbf{u}_2 = \frac{9}{30}\begin{bmatrix} 2 \\ 5 \\ 1 \end{bmatrix} + \frac{3}{6}\begin{bmatrix} 2 \\ -1 \\ 1 \end{bmatrix} = \frac{9}{30}\begin{bmatrix} 2 \\ 5 \\ 1 \end{bmatrix} + \frac{15}{30}\begin{bmatrix} 2 \\ -1 \\ 1 \end{bmatrix} = \begin{bmatrix} 2/5 \\ 2 \\ 1/5 \end{bmatrix}$$
> 
> The orthogonal component is:
> $$\mathbf{y} - \hat{\mathbf{y}} = \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix} - \begin{bmatrix} 2/5 \\ 2 \\ 1/5 \end{bmatrix} = \begin{bmatrix} 7/5 \\ 0 \\ 14/5 \end{bmatrix}$$
> 
> The full decomposition is:
> $$\mathbf{y} = \begin{bmatrix} 1 \\ 2 \\ 3 \end{bmatrix} = \underbrace{\begin{bmatrix} 2/5 \\ 2 \\ 1/5 \end{bmatrix}}_{\hat{\mathbf{y}} \in W} + \underbrace{\begin{bmatrix} 7/5 \\ 0 \\ 14/5 \end{bmatrix}}_{\mathbf{z} \in W^\perp}$$
> 
> As a verification step, confirm that $\mathbf{y} - \hat{\mathbf{y}}$ is orthogonal to both $\mathbf{u}_1$ and $\mathbf{u}_2$ (and hence to all of $W$).

### Geometric Interpretation of the Orthogonal Projection

When $W$ is one-dimensional, the projection formula contains just a single term. When $\dim W > 1$, each term in the formula is itself an orthogonal projection of $\mathbf{y}$ onto a one-dimensional subspace spanned by one of the basis vectors of $W$.

The orthogonal projection $\hat{\mathbf{y}}$ of $\mathbf{y}$ onto $W$ is the **sum of the projections of $\mathbf{y}$ onto mutually orthogonal one-dimensional subspaces**. For instance, if $W$ is spanned by two orthogonal vectors $\mathbf{u}_1$ and $\mathbf{u}_2$, then:

$$\hat{\mathbf{y}} = \underbrace{\frac{\mathbf{y} \cdot \mathbf{u}_1}{\mathbf{u}_1 \cdot \mathbf{u}_1}\mathbf{u}_1}_{\hat{\mathbf{y}}_1} + \underbrace{\frac{\mathbf{y} \cdot \mathbf{u}_2}{\mathbf{u}_2 \cdot \mathbf{u}_2}\mathbf{u}_2}_{\hat{\mathbf{y}}_2}$$

where $\hat{\mathbf{y}}_1$ is the projection of $\mathbf{y}$ onto the line spanned by $\mathbf{u}_1$, and $\hat{\mathbf{y}}_2$ is the projection onto the line spanned by $\mathbf{u}_2$. The full projection onto $W$ is simply their sum.
![[Pasted image 20261105154054.png]]
FIGURE 3 The orthogonal projection of y is the sum of its projections onto one-dimensional subspaces that are mutually orthogonal.
## 6.4 The Gram–Schmidt Process

The Gram–Schmidt process is an algorithm for producing an orthogonal or orthonormal basis for any nonzero subspace of $\mathbb{R}^n$. The core idea is iterative: starting from an existing (non-orthogonal) basis, each new vector is constructed by subtracting from the next original basis vector its projection onto the subspace spanned by the vectors already processed. This ensures each new vector is orthogonal to all previously constructed ones.

> [!example] **Constructing an Orthogonal Basis in $\mathbb{R}^3$ (Two Vectors)**
> Let $W = \text{Span}\{\mathbf{x}_1, \mathbf{x}_2\}$, where $\mathbf{x}_1 = \begin{bmatrix} 3 \\ 6 \\ 0 \end{bmatrix}$ and $\mathbf{x}_2 = \begin{bmatrix} 1 \\ 2 \\ 2 \end{bmatrix}$. Construct an orthogonal basis $\{\mathbf{v}_1, \mathbf{v}_2\}$ for $W$.
> 
> **Solution:**
> Set $\mathbf{v}_1 = \mathbf{x}_1$. The component of $\mathbf{x}_2$ orthogonal to $\mathbf{x}_1$ is found by subtracting the projection of $\mathbf{x}_2$ onto $\mathbf{x}_1$:
> $$\mathbf{v}_2 = \mathbf{x}_2 - \frac{\mathbf{x}_2 \cdot \mathbf{x}_1}{\mathbf{x}_1 \cdot \mathbf{x}_1}\mathbf{x}_1 = \begin{bmatrix} 1 \\ 2 \\ 2 \end{bmatrix} - \frac{15}{45}\begin{bmatrix} 3 \\ 6 \\ 0 \end{bmatrix} = \begin{bmatrix} 0 \\ 0 \\ 2 \end{bmatrix}$$
> 
> Then $\{\mathbf{v}_1, \mathbf{v}_2\}$ is an orthogonal set of nonzero vectors in $W$. Since $\dim W = 2$, this set is a basis for $W$.
> ![[Pasted image 20261105154130.png]]
> FIGURE 1 Construction of an orthogonal basis fv1; v2g.

The full process extends this idea to any number of vectors. At each step, the next vector is made orthogonal to the _entire_ subspace spanned by all previously constructed vectors, not just the most recent one.

> [!example] **Full Gram–Schmidt Process in $\mathbb{R}^4$ (Three Vectors)**
> Let $\mathbf{x}_1 = \begin{bmatrix} 1 \\ 1 \\ 1 \\ 1 \end{bmatrix}$, $\mathbf{x}_2 = \begin{bmatrix} 0 \\ 1 \\ 1 \\ 1 \end{bmatrix}$, and $\mathbf{x}_3 = \begin{bmatrix} 0 \\ 0 \\ 1 \\ 1 \end{bmatrix}$. The set $\{\mathbf{x}_1, \mathbf{x}_2, \mathbf{x}_3\}$ is linearly independent and thus a basis for a subspace $W$ of $\mathbb{R}^4$. Construct an orthogonal basis for $W$.
> 
> **Solution:**
> 
> **Step 1.** Let $\mathbf{v}_1 = \mathbf{x}_1$ and $W_1 = \text{Span}\{\mathbf{x}_1\} = \text{Span}\{\mathbf{v}_1\}$.
> 
> **Step 2.** Subtract from $\mathbf{x}_2$ its projection onto $W_1$:
> $$\mathbf{v}_2 = \mathbf{x}_2 - \text{proj}_{W_1}\mathbf{x}_2 = \mathbf{x}_2 - \frac{\mathbf{x}_2 \cdot \mathbf{v}_1}{\mathbf{v}_1 \cdot \mathbf{v}_1}\mathbf{v}_1 = \begin{bmatrix} 0 \\ 1 \\ 1 \\ 1 \end{bmatrix} - \frac{3}{4}\begin{bmatrix} 1 \\ 1 \\ 1 \\ 1 \end{bmatrix} = \begin{bmatrix} -3/4 \\ 1/4 \\ 1/4 \\ 1/4 \end{bmatrix}$$
> 
> **Step 2' (optional scaling).** To simplify later computations, scale $\mathbf{v}_2$ by a factor of 4 to clear fractions. Replace $\{\mathbf{v}_1, \mathbf{v}_2\}$ with the orthogonal basis:
> $$\mathbf{v}_1 = \begin{bmatrix} 1 \\ 1 \\ 1 \\ 1 \end{bmatrix}, \quad \mathbf{v}_2' = \begin{bmatrix} -3 \\ 1 \\ 1 \\ 1 \end{bmatrix}$$
> 
> **Step 3.** Subtract from $\mathbf{x}_3$ its projection onto $W_2 = \text{Span}\{\mathbf{v}_1, \mathbf{v}_2'\}$:
> $$\text{proj}_{W_2}\mathbf{x}_3 = \underbrace{\frac{\mathbf{x}_3 \cdot \mathbf{v}_1}{\mathbf{v}_1 \cdot \mathbf{v}_1}\mathbf{v}_1}_{\text{proj onto } \mathbf{v}_1} + \underbrace{\frac{\mathbf{x}_3 \cdot \mathbf{v}_2'}{\mathbf{v}_2' \cdot \mathbf{v}_2'}\mathbf{v}_2'}_{\text{proj onto } \mathbf{v}_2'} = \frac{2}{4}\begin{bmatrix} 1 \\ 1 \\ 1 \\ 1 \end{bmatrix} + \frac{2}{12}\begin{bmatrix} -3 \\ 1 \\ 1 \\ 1 \end{bmatrix} = \begin{bmatrix} 0 \\ 2/3 \\ 2/3 \\ 2/3 \end{bmatrix}$$
> 
> Then the orthogonal component is:
> $$\mathbf{v}_3 = \mathbf{x}_3 - \text{proj}_{W_2}\mathbf{x}_3 = \begin{bmatrix} 0 \\ 0 \\ 1 \\ 1 \end{bmatrix} - \begin{bmatrix} 0 \\ 2/3 \\ 2/3 \\ 2/3 \end{bmatrix} = \begin{bmatrix} 0 \\ -2/3 \\ 1/3 \\ 1/3 \end{bmatrix}$$
> 
> Since $\mathbf{v}_3 \in W$ (both $\mathbf{x}_3$ and $\text{proj}_{W_2}\mathbf{x}_3$ are in $W$), the set $\{\mathbf{v}_1, \mathbf{v}_2', \mathbf{v}_3\}$ is an orthogonal set of nonzero vectors in the three-dimensional space $W$, and hence an orthogonal basis for $W$.
> ![[Pasted image 20261105154201.png]]
> FIGURE 2 The construction of v3 from x3 and W2.

> [!tip]
> Scaling intermediate vectors (as in Step 2' above) is a practical convenience for hand calculations. It does not affect the validity of the process, since scaling a vector preserves its direction and all orthogonality relationships.

### The Gram–Schmidt Process (Formal Statement)

> [!summary] **Theorem: The Gram–Schmidt Process**
> Given a basis $\{\mathbf{x}_1, \ldots, \mathbf{x}_p\}$ for a nonzero subspace $W$ of $\mathbb{R}^n$, define:
> $$\mathbf{v}_1 = \mathbf{x}_1$$
> $$\mathbf{v}_2 = \mathbf{x}_2 - \frac{\mathbf{x}_2 \cdot \mathbf{v}_1}{\mathbf{v}_1 \cdot \mathbf{v}_1}\mathbf{v}_1$$
> $$\mathbf{v}_3 = \mathbf{x}_3 - \frac{\mathbf{x}_3 \cdot \mathbf{v}_1}{\mathbf{v}_1 \cdot \mathbf{v}_1}\mathbf{v}_1 - \frac{\mathbf{x}_3 \cdot \mathbf{v}_2}{\mathbf{v}_2 \cdot \mathbf{v}_2}\mathbf{v}_2$$
> $$\vdots$$
> $$\mathbf{v}_p = \mathbf{x}_p - \frac{\mathbf{x}_p \cdot \mathbf{v}_1}{\mathbf{v}_1 \cdot \mathbf{v}_1}\mathbf{v}_1 - \frac{\mathbf{x}_p \cdot \mathbf{v}_2}{\mathbf{v}_2 \cdot \mathbf{v}_2}\mathbf{v}_2 - \cdots - \frac{\mathbf{x}_p \cdot \mathbf{v}_{p-1}}{\mathbf{v}_{p-1} \cdot \mathbf{v}_{p-1}}\mathbf{v}_{p-1}$$
> Then $\{\mathbf{v}_1, \ldots, \mathbf{v}_p\}$ is an orthogonal basis for $W$. In addition:
> $$\text{Span}\{\mathbf{v}_1, \ldots, \mathbf{v}_k\} = \text{Span}\{\mathbf{x}_1, \ldots, \mathbf{x}_k\} \quad \text{for } 1 \leq k \leq p \tag{1}$$
> 
> **Breakdown:**
> - $\{\mathbf{x}_1, \ldots, \mathbf{x}_p\}$: The original (non-orthogonal) basis for $W$. These are the input vectors.
> - $\{\mathbf{v}_1, \ldots, \mathbf{v}_p\}$: The resulting orthogonal basis. Each $\mathbf{v}_k$ is constructed to be orthogonal to all preceding $\mathbf{v}_i$.
> - $\frac{\mathbf{x}_k \cdot \mathbf{v}_i}{\mathbf{v}_i \cdot \mathbf{v}_i}\mathbf{v}_i$: The projection of $\mathbf{x}_k$ onto the one-dimensional subspace spanned by $\mathbf{v}_i$. Subtracting all such projections removes every component of $\mathbf{x}_k$ that lies in the previously constructed subspace.
> - $W_k = \text{Span}\{\mathbf{x}_1, \ldots, \mathbf{x}_k\}$: The subspace spanned by the first $k$ original vectors. Property (1) guarantees that at each step, the orthogonal vectors span the same subspace as the original vectors up to that point — the process preserves the "nested" subspace structure.
> 
> **Proof:**
> For $1 \leq k \leq p$, let $W_k = \text{Span}\{\mathbf{x}_1, \ldots, \mathbf{x}_k\}$. Set $\mathbf{v}_1 = \mathbf{x}_1$, so $\text{Span}\{\mathbf{v}_1\} = \text{Span}\{\mathbf{x}_1\}$.
> 
> Suppose, for some $k < p$, we have constructed $\mathbf{v}_1, \ldots, \mathbf{v}_k$ so that $\{\mathbf{v}_1, \ldots, \mathbf{v}_k\}$ is an orthogonal basis for $W_k$. Define:
> $$\mathbf{v}_{k+1} = \mathbf{x}_{k+1} - \text{proj}_{W_k}\mathbf{x}_{k+1} \tag{2}$$
> 
> By the Orthogonal Decomposition Theorem, $\mathbf{v}_{k+1}$ is orthogonal to $W_k$. Since $\text{proj}_{W_k}\mathbf{x}_{k+1} \in W_k \subseteq W_{k+1}$ and $\mathbf{x}_{k+1} \in W_{k+1}$, it follows that $\mathbf{v}_{k+1} \in W_{k+1}$ (subspaces are closed under subtraction). Furthermore, $\mathbf{v}_{k+1} \neq \mathbf{0}$ because $\mathbf{x}_{k+1}$ is not in $W_k = \text{Span}\{\mathbf{x}_1, \ldots, \mathbf{x}_k\}$ (the original set is linearly independent).
> 
> Hence $\{\mathbf{v}_1, \ldots, \mathbf{v}_{k+1}\}$ is an orthogonal set of nonzero vectors in the $(k+1)$-dimensional space $W_{k+1}$. By the Basis Theorem (any set of $n$ linearly independent vectors in an $n$-dimensional space is a basis), this set is an orthogonal basis for $W_{k+1}$. The process terminates when $k + 1 = p$.
> 
> This theorem guarantees that every nonzero subspace of $\mathbb{R}^n$ has an orthogonal basis, since any subspace has an ordinary basis and the Gram–Schmidt process can always be applied to it.

### Orthonormal Bases

An orthonormal basis is constructed easily from an orthogonal basis $\{\mathbf{v}_1, \ldots, \mathbf{v}_p\}$ by normalizing (scaling) each vector to unit length:

$$\mathbf{u}_k = \frac{1}{\|\mathbf{v}_k\|}\mathbf{v}_k$$

> [!tip]
> When working by hand, it is easier to normalize all vectors at the end rather than normalizing each $\mathbf{v}_k$ as soon as it is found. This avoids carrying unnecessary square roots through intermediate calculations.

> [!example] **Normalizing an Orthogonal Basis**
> From the earlier two-vector example, the orthogonal basis was:
> $$\mathbf{v}_1 = \begin{bmatrix} 3 \\ 6 \\ 0 \end{bmatrix}, \quad \mathbf{v}_2 = \begin{bmatrix} 0 \\ 0 \\ 2 \end{bmatrix}$$
> 
> The corresponding orthonormal basis is:
> $$\mathbf{u}_1 = \frac{1}{\|\mathbf{v}_1\|}\mathbf{v}_1 = \frac{1}{\sqrt{45}}\begin{bmatrix} 3 \\ 6 \\ 0 \end{bmatrix} = \begin{bmatrix} 1/\sqrt{5} \\ 2/\sqrt{5} \\ 0 \end{bmatrix}, \qquad \mathbf{u}_2 = \frac{1}{\|\mathbf{v}_2\|}\mathbf{v}_2 = \frac{1}{2}\begin{bmatrix} 0 \\ 0 \\ 2 \end{bmatrix} = \begin{bmatrix} 0 \\ 0 \\ 1 \end{bmatrix}$$

### QR Factorization of Matrices

If an $m \times n$ matrix $A$ has linearly independent columns $\mathbf{x}_1, \ldots, \mathbf{x}_n$, then applying the Gram–Schmidt process (with normalization) to these columns amounts to factoring $A$ into a product $QR$. This factorization is widely used in computer algorithms for solving systems of equations and finding eigenvalues.

> [!summary] **Theorem: The QR Factorization**
> If $A$ is an $m \times n$ matrix with linearly independent columns, then $A$ can be factored as $A = QR$, where:
> - $Q$ is an $m \times n$ matrix whose columns form an orthonormal basis for $\text{Col}\, A$.
> - $R$ is an $n \times n$ upper triangular invertible matrix with positive entries on its diagonal.
> 
> **Breakdown:**
> - $A$: The original $m \times n$ matrix with linearly independent columns $\mathbf{x}_1, \ldots, \mathbf{x}_n$.
> - $Q$: An $m \times n$ matrix whose columns $\mathbf{u}_1, \ldots, \mathbf{u}_n$ are the orthonormal basis vectors obtained by applying Gram–Schmidt (with normalization) to the columns of $A$.
> - $R$: An $n \times n$ upper triangular matrix. Its entries $r_{ik}$ encode the coefficients needed to express each original column $\mathbf{x}_k$ as a linear combination of the orthonormal vectors $\mathbf{u}_1, \ldots, \mathbf{u}_k$. The diagonal entries $r_{kk}$ are positive.
> - $\text{Col}\, A$: The column space of $A$, equal to $\text{Span}\{\mathbf{x}_1, \ldots, \mathbf{x}_n\}$.
> 
> **Proof:**
> The columns of $A$ form a basis $\{\mathbf{x}_1, \ldots, \mathbf{x}_n\}$ for $\text{Col}\, A$. Construct an orthonormal basis $\{\mathbf{u}_1, \ldots, \mathbf{u}_n\}$ for $W = \text{Col}\, A$ satisfying the span-preserving property of the Gram–Schmidt process. Let $Q = \begin{bmatrix} \mathbf{u}_1 & \mathbf{u}_2 & \cdots & \mathbf{u}_n \end{bmatrix}$.
> 
> For each $k = 1, \ldots, n$, the vector $\mathbf{x}_k$ is in $\text{Span}\{\mathbf{x}_1, \ldots, \mathbf{x}_k\} = \text{Span}\{\mathbf{u}_1, \ldots, \mathbf{u}_k\}$. So there exist constants $r_{1k}, \ldots, r_{kk}$ such that:
> $$\mathbf{x}_k = r_{1k}\mathbf{u}_1 + \cdots + r_{kk}\mathbf{u}_k + 0\,\mathbf{u}_{k+1} + \cdots + 0\,\mathbf{u}_n$$
> 
> We may assume $r_{kk} \geq 0$ (if $r_{kk} < 0$, multiply both $r_{kk}$ and $\mathbf{u}_k$ by $-1$). This shows $\mathbf{x}_k = Q\mathbf{r}_k$, where $\mathbf{r}_k$ is a column vector with entries $r_{1k}, \ldots, r_{kk}, 0, \ldots, 0$. Letting $R = \begin{bmatrix} \mathbf{r}_1 & \cdots & \mathbf{r}_n \end{bmatrix}$:
> $$A = \begin{bmatrix} \mathbf{x}_1 & \cdots & \mathbf{x}_n \end{bmatrix} = \begin{bmatrix} Q\mathbf{r}_1 & \cdots & Q\mathbf{r}_n \end{bmatrix} = QR$$
> 
> $R$ is upper triangular by construction (zeros below the diagonal). Since the columns of $A$ are linearly independent, $R$ is invertible, and its nonnegative diagonal entries must be strictly positive.

> [!example] **Computing a QR Factorization**
> Find a QR factorization of $A = \begin{bmatrix} 1 & 0 & 0 \\ 1 & 1 & 0 \\ 1 & 1 & 1 \\ 1 & 1 & 1 \end{bmatrix}$.
> 
> **Solution:**
> The columns of $A$ are the vectors $\mathbf{x}_1, \mathbf{x}_2, \mathbf{x}_3$ from the earlier three-vector example. An orthogonal basis for $\text{Col}\, A$ was already found:
> $$\mathbf{v}_1 = \begin{bmatrix} 1 \\ 1 \\ 1 \\ 1 \end{bmatrix}, \quad \mathbf{v}_2' = \begin{bmatrix} -3 \\ 1 \\ 1 \\ 1 \end{bmatrix}, \quad \mathbf{v}_3 = \begin{bmatrix} 0 \\ -2/3 \\ 1/3 \\ 1/3 \end{bmatrix}$$
> 
> Scale $\mathbf{v}_3$ by 3 to simplify, then normalize all three vectors to obtain the columns of $Q$:
> $$Q = \begin{bmatrix} 1/2 & -3/\sqrt{12} & 0 \\ 1/2 & 1/\sqrt{12} & -2/\sqrt{6} \\ 1/2 & 1/\sqrt{12} & 1/\sqrt{6} \\ 1/2 & 1/\sqrt{12} & 1/\sqrt{6} \end{bmatrix}$$
> 
> Since the columns of $Q$ are orthonormal, $Q^T Q = I$. Therefore $Q^T A = Q^T(QR) = IR = R$, giving:
> $$R = Q^T A = \begin{bmatrix} 2 & 3/2 & 1 \\ 0 & 3/\sqrt{12} & 2/\sqrt{12} \\ 0 & 0 & 2/\sqrt{6} \end{bmatrix}$$

### Numerical Notes

> [!warning] **Numerical Considerations for Gram–Schmidt and QR Factorization**
> 1. **Roundoff error in Gram–Schmidt:** When the Gram–Schmidt process is run on a computer, roundoff error can accumulate as the orthonormal vectors $\mathbf{u}_k$ are calculated one by one. For large but unequal indices $j$ and $k$, the inner products $\mathbf{u}_j^T \mathbf{u}_k$ may not be sufficiently close to zero. This _loss of orthogonality_ can be reduced substantially by rearranging the order of calculations (the "modified Gram–Schmidt" method). However, a different computer-based QR factorization is usually preferred because it yields a more accurate orthonormal basis, even though it requires roughly twice as much arithmetic.
> 2. **Computer-based QR factorization:** In practice, a computer program typically left-multiplies $A$ by a sequence of orthogonal matrices until $A$ is transformed into an upper triangular matrix. This construction is analogous to left-multiplication by elementary matrices used to produce an LU factorization of $A$.