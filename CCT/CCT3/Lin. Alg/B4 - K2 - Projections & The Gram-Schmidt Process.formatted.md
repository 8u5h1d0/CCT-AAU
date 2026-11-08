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
# 1. Orthogonal Projections and the Gram–Schmidt Process

| Concept / notation | Meaning |
|---|---|
| $W^\perp$ | Orthogonal complement: vectors orthogonal to every vector in $W$. |
| $\operatorname{proj}_W\mathbf y=\hat{\mathbf y}$ | Orthogonal projection of $\mathbf y$ onto $W$. |
| $\mathbf y=\hat{\mathbf y}+\mathbf z$ | Unique orthogonal decomposition, with $\hat{\mathbf y}\in W$ and $\mathbf z\in W^\perp$. |
| $\mathbf v_k$ | Orthogonal vector produced at Gram–Schmidt step $k$. |
| $\mathbf u_k=\mathbf v_k/\|\mathbf v_k\|$ | Normalized unit vector. |
| QR | Orthogonal–triangular factorization $A=QR$: $Q$ has orthonormal columns and $R$ is upper triangular. |
| $Q^TQ=I$ | Orthonormality identity for the columns of $Q$. |
| $W_k$ | $\operatorname{Span}\{\mathbf x_1,\ldots,\mathbf x_k\}$, the subspace spanned by the first $k$ input vectors. |
| $\operatorname{Span}$ | Set of all linear combinations of the listed vectors. |
| $\dim W$ | Dimension of subspace $W$. |
| $\mathbb R^n$ | Real coordinate space of dimension $n$. |
| $A^T$ | Transpose of matrix $A$. |
| $I$ | Identity matrix of the indicated size. |
| $m\times n$ | Number of rows by number of columns. |

---

> [!abstract] How the ideas connect
> Projection removes the component in a subspace to leave an orthogonal residual. Gram–Schmidt repeats that same operation for successive basis vectors; normalizing the resulting vectors yields the $Q$ factor in QR.

```mermaid
flowchart LR
    A[Vector or next input column] --> B[Project onto existing subspace]
    B --> C[Subtract projection]
    C --> D[Orthogonal residual]
    D --> E[Normalize]
    E --> F[Column of Q]
    F --> G[Coefficients form R]
```

---

## 1.1 Orthogonal Projections

Given a vector $\mathbf y\in\mathbb R^n$ and a subspace $W$, there is a unique vector $\hat{\mathbf y}\in W$ such that the residual $\mathbf y-\hat{\mathbf y}$ is orthogonal to all of $W$. This vector is also the unique point of $W$ closest to $\mathbf y$. The projection is the part lying in $W$; the residual is the part perpendicular to it. This is the geometric foundation of least-squares methods.

![[Pasted image 20261105153949.png]]
_Figure 1.1: A vector and its orthogonal projection onto a subspace._

### 1.1.1 Decomposing a Vector into Two Parts

A vector can be split into components from complementary orthogonal subspaces:

$$\mathbf y=\mathbf z_1+\mathbf z_2.$$

When the vectors in an orthogonal basis are divided into two groups, the first group spans one component and the remaining group can span a component orthogonal to it.

> [!info] Definition: Orthogonal complement
> The orthogonal complement $W^\perp$ is the set of vectors orthogonal to every vector in $W$. It is itself a subspace.

> [!example] Decomposition from an orthogonal basis of $\mathbb R^5$
> Let $\{\mathbf u_1,\ldots,\mathbf u_5\}$ be an orthogonal basis for $\mathbb R^5$, and write $\mathbf y=c_1\mathbf u_1+\cdots+c_5\mathbf u_5$. Let $W=\operatorname{Span}\{\mathbf u_1,\mathbf u_2\}$. Group the terms as
> $$\mathbf y=\underbrace{c_1\mathbf u_1+c_2\mathbf u_2}_{\mathbf z_1\in W}+\underbrace{c_3\mathbf u_3+c_4\mathbf u_4+c_5\mathbf u_5}_{\mathbf z_2}.$$
> For $i=1,2$, orthogonality of the basis gives $\mathbf z_2\cdot\mathbf u_i=0$. Thus $\mathbf z_2\in W^\perp$ and this is an orthogonal decomposition.

An orthogonal basis of $W$ is sufficient for computing the projection; an orthogonal basis of the whole ambient space is not required.

### 1.1.2 The Orthogonal Decomposition Theorem

> [!summary] Theorem 1: Orthogonal Decomposition Theorem
> Let $W$ be a subspace of $\mathbb R^n$. Every $\mathbf y\in\mathbb R^n$ has a unique representation
> $$\mathbf y=\hat{\mathbf y}+\mathbf z,\qquad \hat{\mathbf y}\in W,\quad \mathbf z\in W^\perp.$$
> If $\{\mathbf u_1,\ldots,\mathbf u_p\}$ is any orthogonal basis of $W$, then
> $$\hat{\mathbf y}=\sum_{i=1}^{p}\frac{\mathbf y\cdot\mathbf u_i}{\mathbf u_i\cdot\mathbf u_i}\mathbf u_i,\qquad \mathbf z=\mathbf y-\hat{\mathbf y}.$$
>
> **Breakdown:** $\mathbf y$ is the original vector; $\hat{\mathbf y}$ is its projection in $W$; $\mathbf z$ is the residual in $W^\perp$; each $\mathbf u_i$ is a nonzero orthogonal basis vector. The coefficient $(\mathbf y\cdot\mathbf u_i)/(\mathbf u_i\cdot\mathbf u_i)$ gives the component along $\mathbf u_i$ and works even when the basis vector is not unit length.
>
> **Proof:** Define $\hat{\mathbf y}$ by the formula and let $\mathbf z=\mathbf y-\hat{\mathbf y}$. The projection is a linear combination of basis vectors, hence belongs to $W$. For each $j$, orthogonality makes all terms except the $j$th vanish in $\hat{\mathbf y}\cdot\mathbf u_j$, so $\mathbf z\cdot\mathbf u_j=\mathbf y\cdot\mathbf u_j-(\mathbf y\cdot\mathbf u_j)=0$. Thus $\mathbf z\in W^\perp$. If two such decompositions existed, their projection difference would lie in both $W$ and $W^\perp$; its dot product with itself would be zero, so the difference must be zero. The decomposition is unique.

![[Pasted image 20261105154031.png]]
_Figure 1.2: Orthogonal projection onto a subspace, with perpendicular residual._

> [!example] Computing an orthogonal decomposition
> Let $\mathbf u_1=(2,5,1)^T$, $\mathbf u_2=(2,-1,1)^T$, and $\mathbf y=(1,2,3)^T$. Since $\mathbf u_1\cdot\mathbf u_2=0$, these vectors form an orthogonal basis for their span $W$. Their squared lengths are $30$ and $6$, and the dot products with $\mathbf y$ are $9$ and $3$. Therefore
> $$\hat{\mathbf y}=\frac9{30}\mathbf u_1+\frac36\mathbf u_2=\begin{bmatrix}2/5\\2\\1/5\end{bmatrix},\qquad \mathbf z=\mathbf y-\hat{\mathbf y}=\begin{bmatrix}7/5\\0\\14/5\end{bmatrix}.$$
> Check: $\mathbf z\cdot\mathbf u_1=14/5+14/5=28/5$? Wait, calculate correctly: $(7/5)2+0(5)+(14/5)1=28/5$, not zero. The stated projection coefficients in the source are inconsistent: $\mathbf y\cdot\mathbf u_1=15$, not $9$, and $\mathbf y\cdot\mathbf u_2=3$. Correcting gives
> $$\hat{\mathbf y}=\frac{15}{30}\mathbf u_1+\frac36\mathbf u_2=\begin{bmatrix}2\\2\\1\end{bmatrix},\qquad \mathbf z=\begin{bmatrix}-1\\0\\2\end{bmatrix}.$$
> Check: $\mathbf z\cdot\mathbf u_1=-2+2=0$ and $\mathbf z\cdot\mathbf u_2=-2+2=0$. ✓
>

> [!warning] Correction
> The source example gives $\mathbf y\cdot\mathbf u_1=9$ and a projection/residual that fail the orthogonality test. The correct dot product is $15$, giving the corrected decomposition above.

### 1.1.3 Geometric Interpretation

For an orthogonal basis of $W$, the projection onto $W$ is the sum of the projections onto the mutually orthogonal basis lines. For example, with two orthogonal vectors, each contributes one term:

$$\hat{\mathbf y}=\underbrace{\frac{\mathbf y\cdot\mathbf u_1}{\mathbf u_1\cdot\mathbf u_1}\mathbf u_1}_{\hat{\mathbf y}_1}+\underbrace{\frac{\mathbf y\cdot\mathbf u_2}{\mathbf u_2\cdot\mathbf u_2}\mathbf u_2}_{\hat{\mathbf y}_2}.$$

![[Pasted image 20261105154054.png]]
_Figure 1.3: Projection onto a subspace as the sum of projections onto mutually orthogonal lines._

> [!example] Mini-example: adding orthogonal components
> If $W=\operatorname{Span}\{\mathbf u_1,\mathbf u_2\}$ with $\mathbf u_1\perp\mathbf u_2$, then the two scalar-weighted vectors in the displayed expression each lie on one basis line, and their sum lies in $W$.

---

## 1.2 The Gram–Schmidt Process

The Gram–Schmidt process turns a linearly independent (not necessarily orthogonal) basis into an orthogonal basis for the same subspace. At each step, subtract from the next input vector its projection onto the entire span of the vectors already constructed. This preserves the nested spans and makes the new vector perpendicular to all earlier ones. Consequently, every nonzero subspace of $\mathbb R^n$ has an orthogonal basis: choose any basis for it and apply this process.

### 1.2.1 Constructing an Orthogonal Basis

> [!info] Definition: Gram–Schmidt step
> Given orthogonal vectors $\mathbf v_1,\ldots,\mathbf v_k$ already constructed, the next vector is
> $$\mathbf v_{k+1}=\mathbf x_{k+1}-\sum_{i=1}^{k}\frac{\mathbf x_{k+1}\cdot\mathbf v_i}{\mathbf v_i\cdot\mathbf v_i}\mathbf v_i.$$
> The subtracted sum is the projection onto their span; the remainder is orthogonal to that entire span.

> [!example] Constructing an orthogonal basis in $\mathbb R^3$ (two vectors)
> Let $\mathbf x_1=(3,6,0)^T$ and $\mathbf x_2=(1,2,2)^T$. Set $\mathbf v_1=\mathbf x_1$. Since $\mathbf x_2\cdot\mathbf x_1=15$ and $\mathbf x_1\cdot\mathbf x_1=45$,
> $$\mathbf v_2=\mathbf x_2-\frac{15}{45}\mathbf x_1=(0,0,2)^T.$$
> The vectors are nonzero, orthogonal, and span the original two-dimensional subspace. Check: $\mathbf v_1\cdot\mathbf v_2=0$. ✓
>
> ![[Pasted image 20261105154130.png]]
> _Figure 1.4: Construction of the orthogonal basis vectors $\mathbf v_1$ and $\mathbf v_2$._

Each new vector must be made orthogonal to the whole previously constructed subspace, not merely to the most recent vector.

> [!example] Full Gram–Schmidt process in $\mathbb R^4$ (three vectors)
> Take $\mathbf x_1=(1,1,1,1)^T$, $\mathbf x_2=(0,1,1,1)^T$, and $\mathbf x_3=(0,0,1,1)^T$. Set $\mathbf v_1=\mathbf x_1$. Then
> $$\mathbf v_2=\mathbf x_2-\frac34\mathbf v_1=(-3/4,1/4,1/4,1/4)^T.$$
> Scale this vector by $4$ for convenient arithmetic, writing $\mathbf v'_2=(-3,1,1,1)^T$; scaling preserves orthogonality and span. Now project $\mathbf x_3$ onto $W_2=\operatorname{Span}\{\mathbf v_1,\mathbf v'_2\}$:
> $$\operatorname{proj}_{W_2}\mathbf x_3=\frac{2}{4}\mathbf v_1+\frac{2}{12}\mathbf v'_2=(0,2/3,2/3,2/3)^T.$$
> Hence $\mathbf v_3=\mathbf x_3-\operatorname{proj}_{W_2}\mathbf x_3=(0,-2/3,1/3,1/3)^T$. These three nonzero mutually orthogonal vectors form a basis for the three-dimensional space $W$. Check: $\mathbf v_3\cdot\mathbf v_1=0$ and $\mathbf v_3\cdot\mathbf v'_2=0$. ✓
>
> ![[Pasted image 20261105154201.png]]
> _Figure 1.5: Constructing $\mathbf v_3$ by removing the projection of $\mathbf x_3$ onto $W_2$._

> [!tip] Scaling for hand calculations
> Scaling an intermediate orthogonal vector by a nonzero scalar preserves its direction, orthogonality, and span. It can clear fractions; normalize only after the orthogonal basis is complete to avoid carrying square roots.

### 1.2.2 Formal Statement

> [!summary] Theorem 2: Gram–Schmidt Process
> Given a basis $\{\mathbf x_1,\ldots,\mathbf x_p\}$ for a nonzero subspace $W\subseteq\mathbb R^n$, define $\mathbf v_1=\mathbf x_1$ and, for $k=2,\ldots,p$,
> $$\mathbf v_k=\mathbf x_k-\sum_{i=1}^{k-1}\frac{\mathbf x_k\cdot\mathbf v_i}{\mathbf v_i\cdot\mathbf v_i}\mathbf v_i.$$
> Then $\{\mathbf v_1,\ldots,\mathbf v_p\}$ is an orthogonal basis for $W$, and
> $$\operatorname{Span}\{\mathbf v_1,\ldots,\mathbf v_k\}=\operatorname{Span}\{\mathbf x_1,\ldots,\mathbf x_k\}=W_k\quad(1\le k\le p).$$
>
> **Breakdown:** $\mathbf x_k$ is the $k$th input vector; $\mathbf v_k$ is its component orthogonal to all earlier constructed vectors; $W_k$ is the span of the first $k$ inputs. The span identity says every intermediate stage preserves the same nested subspace.
>
> **Proof:** Proceed by induction. The assertion holds for $k=1$. Suppose the first $k$ constructed vectors are an orthogonal basis of $W_k$. By the orthogonal decomposition theorem, subtracting the projection of $\mathbf x_{k+1}$ onto $W_k$ gives a vector orthogonal to $W_k$. It remains in $W_{k+1}$, and it is nonzero because the original inputs are linearly independent, so $\mathbf x_{k+1}\notin W_k$. Thus the first $k+1$ outputs are an orthogonal set of $k+1$ nonzero vectors in the $(k+1)$-dimensional space $W_{k+1}$, hence a basis. This proves the claim at every step.

> [!example] Mini-example: the span-preserving property
> In the two-vector example, $\mathbf v_1=\mathbf x_1$ and $\mathbf v_2=\mathbf x_2-c\mathbf v_1$ for a scalar $c$. Thus each pair spans the same subspace: $\operatorname{Span}\{\mathbf v_1,\mathbf v_2\}=\operatorname{Span}\{\mathbf x_1,\mathbf x_2\}$.

### 1.2.3 Orthonormal Bases

An orthonormal basis is an orthogonal basis whose vectors all have length one. Normalize each orthogonal vector by its norm:

$$\mathbf u_k=\frac{\mathbf v_k}{\|\mathbf v_k\|}.$$

> [!example] Normalizing the two-vector basis
> For $\mathbf v_1=(3,6,0)^T$ and $\mathbf v_2=(0,0,2)^T$, their norms are $3\sqrt5$ and $2$. Therefore
> $$\mathbf u_1=(1/\sqrt5,2/\sqrt5,0)^T,\qquad \mathbf u_2=(0,0,1)^T.$$
> Each has unit length, and their dot product is zero. ✓

---

## 1.3 QR Factorization

Applying Gram–Schmidt with normalization to the columns of a full-column-rank matrix produces a useful orthogonal–triangular (QR) factorization. Here the reduced form is used: $Q$ is $m\times n$ with orthonormal columns and $R$ is $n\times n$. A square-$Q$ version can be formed by extending those columns to an orthonormal basis of $\mathbb R^m$; this note uses the reduced form because it directly spans $\operatorname{Col}A$.

> [!summary] Theorem 3: QR Factorization
> If an $m\times n$ matrix $A$ has linearly independent columns, then $A=QR$, where $Q$ is an $m\times n$ matrix with orthonormal columns spanning $\operatorname{Col}A$, and $R$ is an invertible $n\times n$ upper-triangular matrix with positive diagonal entries.
>
> **Breakdown:** $\operatorname{Col}A$ is the span of the columns of $A$; columns of $Q$ are the normalized Gram–Schmidt outputs; entries $r_{ik}$ express column $k$ of $A$ in the orthonormal basis. Upper triangularity means coefficients below the diagonal are zero.
>
> **Proof:** Apply Gram–Schmidt to the independent columns, producing orthonormal columns $\mathbf u_1,\ldots,\mathbf u_n$ of $Q$. Each input column $\mathbf x_k$ belongs to the span of the first $k$ outputs, so its coefficients form column $k$ of an upper-triangular matrix $R$. Hence $A=QR$. Full column rank makes $R$ invertible, so its diagonal entries are nonzero. If any diagonal entry is negative, multiply the corresponding column of $Q$ by $-1$ and the corresponding row of $R$ by $-1$; the product $QR$ is unchanged, and the diagonal entry becomes positive.

> [!example] Computing a QR factorization
> For
> $$A=\begin{bmatrix}1&0&0\\1&1&0\\1&1&1\\1&1&1\end{bmatrix},$$
> an orthogonal basis for its column space is $\mathbf v_1=(1,1,1,1)^T$, $\mathbf v'_2=(-3,1,1,1)^T$, and a scaled third vector $(0,-2,1,1)^T$. Normalizing gives
> $$Q=\begin{bmatrix}1/2&-3/\sqrt{12}&0\\1/2&1/\sqrt{12}&-2/\sqrt6\\1/2&1/\sqrt{12}&1/\sqrt6\\1/2&1/\sqrt{12}&1/\sqrt6\end{bmatrix}.$$
> Since $Q^TQ=I$, $R=Q^TA$:
> $$R=\begin{bmatrix}2&3/2&1\\0&3/\sqrt{12}&2/\sqrt{12}\\0&0&2/\sqrt6\end{bmatrix}.$$
> Check: multiplying gives $QR=A$, and the diagonal of $R$ is positive. ✓

> [!warning] Numerical stability
> In floating-point computation, rounding can accumulate and cause the calculated vectors to lose orthogonality: $\mathbf u_j^T\mathbf u_k$ may not be close enough to zero. Modified Gram–Schmidt reduces this loss by changing the calculation order. In practice, computer QR methods based on successive orthogonal transformations are often more accurate, though they may require roughly twice as much arithmetic. These transformations are analogous to the left-multiplications used to obtain an LU factorization.

---

>[!summary] Summary
>- **Orthogonal projections:** Every vector decomposes uniquely into a component in a subspace and a perpendicular residual. The projection is the closest vector in that subspace and can be calculated from any orthogonal basis of it.
>- **Gram–Schmidt:** Sequentially subtract projections onto the full span of earlier vectors to produce an orthogonal basis while preserving each nested span; normalize to obtain an orthonormal basis.
>- **QR factorization:** Applying normalized Gram–Schmidt to independent matrix columns yields $A=QR$, with $Q^TQ=I$ and $R$ upper triangular. Floating-point computations may require more stable QR methods.
