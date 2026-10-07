---
tags:
  - CCT3
  - Lin_Algebra
Topic: Diagonalisering og basisskifte.
Semester: CCT3
Course: Linær Algebra
Litterature:
  - Linear Algebra and Its Applications, Global Edition, 6ed
Created: 06-10-2026
---
- - -
## Table of Contents

1. [[#Powers of a Matrix|Powers of a Matrix]]
2. [[#Diagonalizability|Diagonalizability]]
3. [[#Step-by-Step Diagonalization Procedure|Step-by-Step Diagonalization Procedure]]
4. [[#Sufficient Condition for Diagonalizability|Sufficient Condition for Diagonalizability]]
5. [[#Matrices with Non-Distinct Eigenvalues|Matrices with Non-Distinct Eigenvalues]]
6. [[#5.4 Eigenvectors and Linear Transformations|5.4 Eigenvectors and Linear Transformations]]
7. [[#5.4 Eigenvectors and Linear Transformations#Eigenvectors of Linear Transformations|Eigenvectors of Linear Transformations]]
8. [[#5.4 Eigenvectors and Linear Transformations#The Matrix of a Linear Transformation|The Matrix of a Linear Transformation]]
9. [[#5.4 Eigenvectors and Linear Transformations#Linear Transformations on $\mathbb{R}^n$|Linear Transformations on $\mathbb{R}^n$]]
10. [[#5.4 Eigenvectors and Linear Transformations#Similarity of Matrix Representations|Similarity of Matrix Representations]]
11. [[#5.4 Eigenvectors and Linear Transformations#Numerical Notes|Numerical Notes]]

## Diagonalization

In many cases, the eigenvalue–eigenvector information contained within a square matrix $A$ can be displayed in a useful factorization of the form $A = PDP^{-1}$, where $D$ is a diagonal matrix. This factorization enables rapid computation of $A^k$ for large values of $k$, which is a fundamental tool for analyzing and decoupling dynamical systems.

### Powers of a Matrix

Computing powers of a diagonal matrix is straightforward because it only requires raising each diagonal entry to that power.

> [!example] Powers of a Diagonal Matrix
> If $D = \begin{bmatrix} 5 & 0 \\ 0 & 3 \end{bmatrix}$, then:
> $$D^2 = \begin{bmatrix} 5 & 0 \\ 0 & 3 \end{bmatrix} \begin{bmatrix} 5 & 0 \\ 0 & 3 \end{bmatrix} = \begin{bmatrix} 5^2 & 0 \\ 0 & 3^2 \end{bmatrix}$$
> 
> In general, for $k \geq 1$:
> $$D^k = \begin{bmatrix} 5^k & 0 \\ 0 & 3^k \end{bmatrix}$$

If $A = PDP^{-1}$ for some invertible $P$ and diagonal $D$, then $A^k$ is also easy to compute because the intermediate $P^{-1}P$ terms simplify to the identity matrix $I$.

> [!example] Powers of a Diagonalized Matrix
> Let $A = \begin{bmatrix} 7 & 2 \\ -4 & 1 \end{bmatrix}$. Find a formula for $A^k$, given that $A = PDP^{-1}$ where:
> $$P = \begin{bmatrix} 1 & -1 \\ -1 & 2 \end{bmatrix} \quad \text{and} \quad D = \begin{bmatrix} 5 & 0 \\ 0 & 3 \end{bmatrix}$$
> 
> **Step 1:** Compute $P^{-1}$ using the $2 \times 2$ inverse formula:
> $$P^{-1} = \frac{1}{(1)(2) - (-1)(-1)} \begin{bmatrix} 2 & 1 \\ 1 & 1 \end{bmatrix} = \begin{bmatrix} 2 & 1 \\ 1 & 1 \end{bmatrix}$$
> 
> **Step 2:** Observe the algebraic simplification for $A^2$:
> $$A^2 = (PDP^{-1})(PDP^{-1}) = PD(P^{-1}P)DP^{-1} = P(DI)DP^{-1} = PD^2P^{-1}$$
> 
> **Step 3:** Generalize to $A^k$ for $k \geq 1$:
> $$A^k = PD^kP^{-1} = \begin{bmatrix} 1 & -1 \\ -1 & 2 \end{bmatrix} \begin{bmatrix} 5^k & 0 \\ 0 & 3^k \end{bmatrix} \begin{bmatrix} 2 & 1 \\ 1 & 1 \end{bmatrix}$$
> $$= \begin{bmatrix} 1 & -1 \\ -1 & 2 \end{bmatrix} \begin{bmatrix} 2 \cdot 5^k & 5^k \\ 3^k & 3^k \end{bmatrix} = \begin{bmatrix} 2 \cdot 5^k - 3^k & 5^k - 3^k \\ -2 \cdot 5^k + 2 \cdot 3^k & -5^k + 2 \cdot 3^k \end{bmatrix}$$

---

### Diagonalizability

> [!info] Definition: Diagonalizable Matrix
> A square matrix $A$ is **[[Diagonalizable Matrix|diagonalizable]]** if it is similar to a diagonal matrix — that is, if there exists an invertible matrix $P$ and a diagonal matrix $D$ such that:
> $$A = PDP^{-1}$$

The next theorem characterizes diagonalizable matrices and provides the method for constructing their factorization.

> [!summary] Theorem 5: The Diagonalization Theorem
> An $n \times n$ matrix $A$ is diagonalizable if and only if $A$ has $n$ linearly independent eigenvectors.
> 
> In fact, $A = PDP^{-1}$, with $D$ a diagonal matrix, if and only if the columns of $P$ are $n$ linearly independent eigenvectors of $A$. In this case, the diagonal entries of $D$ are eigenvalues of $A$ that correspond, respectively, to the eigenvectors in $P$.
> 
> Consequently, $A$ is diagonalizable if and only if there are enough eigenvectors to form a basis of $\mathbb{R}^n$, called an **eigenvector basis** of $\mathbb{R}^n$.
> 
> **breakdown**:
> - **$A = PDP^{-1}$**: The diagonalization factorization.
>     - **$A$**: The $n \times n$ matrix being diagonalized.
>     - **$P = [v_1 \ v_2 \ \cdots \ v_n]$**: The $n \times n$ invertible matrix whose columns are the linearly independent eigenvectors of $A$.
>     - **$D = \text{diag}(\lambda_1, \lambda_2, \ldots, \lambda_n)$**: The diagonal matrix containing the eigenvalues of $A$ in the exact same column order as their corresponding eigenvectors in $P$.
>     - **$P^{-1}$**: The inverse of the eigenvector matrix.
> 
> **proof**:
> Let $P$ be any $n \times n$ matrix with columns $v_1, \ldots, v_n$, and let $D$ be a diagonal matrix with diagonal entries $\lambda_1, \ldots, \lambda_n$. 
> 
> Computing $AP$ by columns:
> $$AP = A[v_1 \ v_2 \ \cdots \ v_n] = [Av_1 \ Av_2 \ \cdots \ Av_n] \quad \text{--- (1)}$$
> 
> Computing $PD$ by columns:
> $$PD = P \begin{bmatrix} \lambda_1 & 0 & \cdots & 0 \\ 0 & \lambda_2 & \cdots & 0 \\ \vdots & \vdots & \ddots & \vdots \\ 0 & 0 & \cdots & \lambda_n \end{bmatrix} = [\lambda_1 v_1 \ \lambda_2 v_2 \ \cdots \ \lambda_n v_n] \quad \text{--- (2)}$$
> 
> If $A$ is diagonalizable, then $A = PDP^{-1}$. Right-multiplying by $P$ gives $AP = PD$. From equations (1) and (2), this implies:
> $$[Av_1 \ Av_2 \ \cdots \ Av_n] = [\lambda_1 v_1 \ \lambda_2 v_2 \ \cdots \ \lambda_n v_n] \quad \text{--- (3)}$$
> 
> Equating individual columns:
> $$Av_1 = \lambda_1 v_1, \quad Av_2 = \lambda_2 v_2, \quad \ldots, \quad Av_n = \lambda_n v_n \quad \text{--- (4)}$$
> 
> Since $P$ is invertible, its columns $v_1, \ldots, v_n$ are linearly independent and nonzero. Equations (4) prove that $\lambda_1, \dots, \lambda_n$ are eigenvalues of $A$ and $v_1, \dots, v_n$ are the corresponding eigenvectors.
> 
> Conversely, if we are given any $n$ eigenvectors $v_1, \ldots, v_n$, constructing $P$ and $D$ according to these definitions guarantees $AP = PD$ by equations (1)–(3). If these eigenvectors are linearly independent, then $P$ is invertible by the Invertible Matrix Theorem, allowing us to write $A = PDP^{-1}$.

---

### Step-by-Step Diagonalization Procedure

To diagonalize an $n \times n$ matrix $A$, implement the following four steps:

1. **Find the eigenvalues of $A$:** Compute the roots of the characteristic equation $\det(A - \lambda I) = 0$.
2. **Find $n$ linearly independent eigenvectors:** Find a basis for each eigenspace. If the sum of the dimensions of these eigenspaces is less than $n$, the matrix is **not diagonalizable**.
3. **Construct $P$:** Set the eigenvectors found in Step 2 as the columns of $P$. They can be ordered in any way.
4. **Construct $D$:** Place the corresponding eigenvalues on the main diagonal of $D$, ensuring their order matches the column order of the eigenvectors in $P$.

> [!example] Diagonalizing a 3×3 Matrix
> Diagonalize the matrix:
> $$A = \begin{bmatrix} 1 & 3 & 3 \\ -3 & -5 & -3 \\ 3 & 3 & 1 \end{bmatrix}$$
> 
> **Step 1: Find the eigenvalues.**
> The characteristic equation is:
> $$\det(A - \lambda I) = -\lambda^3 - 3\lambda^2 + 4 = -(\lambda - 1)(\lambda + 2)^2 = 0$$
> The eigenvalues are $\lambda_1 = 1$ and $\lambda_2 = -2$ (with multiplicity 2).
> 
> **Step 2: Find three linearly independent eigenvectors.**
> - For $\lambda_1 = 1$, row reduce $A - I$:
>   $$A - I = \begin{bmatrix} 0 & 3 & 3 \\ -3 & -6 & -3 \\ 3 & 3 & 0 \end{bmatrix} \sim \begin{bmatrix} 1 & 0 & -1 \\ 0 & 1 & 1 \\ 0 & 0 & 0 \end{bmatrix} \implies v_1 = \begin{bmatrix} 1 \\ -1 \\ 1 \end{bmatrix}$$
> 
> - For $\lambda_2 = -2$, row reduce $A + 2I$:
>   $$A + 2I = \begin{bmatrix} 3 & 3 & 3 \\ -3 & -3 & -3 \\ 3 & 3 & 3 \end{bmatrix} \sim \begin{bmatrix} 1 & 1 & 1 \\ 0 & 0 & 0 \\ 0 & 0 & 0 \end{bmatrix} \implies v_2 = \begin{bmatrix} -1 \\ 1 \\ 0 \end{bmatrix}, \quad v_3 = \begin{bmatrix} -1 \\ 0 \\ 1 \end{bmatrix}$$
> 
> Since $\{v_1, v_2, v_3\}$ is linearly independent, we have enough vectors to proceed.
> 
> **Step 3: Construct $P$.**
> $$P = [v_1 \ v_2 \ v_3] = \begin{bmatrix} 1 & -1 & -1 \\ -1 & 1 & 0 \\ 1 & 0 & 1 \end{bmatrix}$$
> 
> **Step 4: Construct $D$.**
> $$D = \begin{bmatrix} 1 & 0 & 0 \\ 0 & -2 & 0 \\ 0 & 0 & -2 \end{bmatrix}$$
> 
> *Verification check:* Confirm that $AP = PD$:
> $$AP = \begin{bmatrix} 1 & 3 & 3 \\ -3 & -5 & -3 \\ 3 & 3 & 1 \end{bmatrix} \begin{bmatrix} 1 & -1 & -1 \\ -1 & 1 & 0 \\ 1 & 0 & 1 \end{bmatrix} = \begin{bmatrix} 1 & 2 & 2 \\ -1 & -2 & 0 \\ 1 & 0 & -2 \end{bmatrix}$$
> $$PD = \begin{bmatrix} 1 & -1 & -1 \\ -1 & 1 & 0 \\ 1 & 0 & 1 \end{bmatrix} \begin{bmatrix} 1 & 0 & 0 \\ 0 & -2 & 0 \\ 0 & 0 & -2 \end{bmatrix} = \begin{bmatrix} 1 & 2 & 2 \\ -1 & -2 & 0 \\ 1 & 0 & -2 \end{bmatrix} \quad \checkmark$$

> [!example] A Non-Diagonalizable Matrix
> Attempt to diagonalize:
> $$A = \begin{bmatrix} 2 & 4 & 3 \\ -4 & -6 & -3 \\ 3 & 3 & 1 \end{bmatrix}$$
> 
> **Step 1:** The characteristic equation is identical to the previous example:
> $$\det(A - \lambda I) = -(\lambda - 1)(\lambda + 2)^2 = 0$$
> The eigenvalues are $\lambda_1 = 1$ and $\lambda_2 = -2$.
> 
> **Step 2: Find eigenvectors.**
> - For $\lambda_1 = 1$, we obtain the basis vector $v_1 = \begin{bmatrix} 1 \\ -1 \\ 1 \end{bmatrix}$.
> - For $\lambda_2 = -2$, row reduce $A + 2I$:
>   $$A + 2I = \begin{bmatrix} 4 & 4 & 3 \\ -4 & -4 & -3 \\ 3 & 3 & 3 \end{bmatrix} \sim \begin{bmatrix} 1 & 1 & 0 \\ 0 & 0 & 1 \\ 0 & 0 & 0 \end{bmatrix}$$
>   The general solution has only one free variable, yielding the eigenspace basis:
>   $$v_2 = \begin{bmatrix} -1 \\ 1 \\ 0 \end{bmatrix}$$
> 
> Because every eigenvector of $A$ is a multiple of either $v_1$ or $v_2$, we cannot construct a basis of $\mathbb{R}^3$ using eigenvectors of $A$. Thus, $A$ is **not diagonalizable**.

---

### Sufficient Condition for Diagonalizability

Having distinct eigenvalues is a sufficient, but not necessary, condition for a matrix to be diagonalizable.

> [!summary] Theorem 6: Matrices with Distinct Eigenvalues
> An $n \times n$ matrix with $n$ distinct eigenvalues is diagonalizable.
> 
> **proof**:
> Let $v_1, \ldots, v_n$ be eigenvectors corresponding to the $n$ distinct eigenvalues of $A$. Because the eigenvalues are distinct, the set of eigenvectors $\{v_1, \ldots, v_n\}$ is linearly independent. By Theorem 5, the matrix is diagonalizable.

> [!example] Diagonalizability of a Triangular Matrix with Distinct Eigenvalues
> Determine if the following matrix is diagonalizable:
> $$A = \begin{bmatrix} 5 & -8 & 1 \\ 0 & 0 & 7 \\ 0 & 0 & 2 \end{bmatrix}$$
> 
> Because $A$ is triangular, its eigenvalues are the diagonal entries: $5, 0,$ and $2$. Since $A$ is a $3 \times 3$ matrix with three distinct eigenvalues, it is diagonalizable by Theorem 6.

---

### Matrices with Non-Distinct Eigenvalues

When an $n \times n$ matrix has fewer than $n$ distinct eigenvalues, it may still be diagonalizable if the algebraic multiplicity of each eigenvalue equals the dimension of its corresponding eigenspace.

> [!summary] Theorem 7: Multiplicities and Diagonalizability
> Let $A$ be an $n \times n$ matrix whose distinct eigenvalues are $\lambda_1, \ldots, \lambda_p$.
> 
> a. For $1 \leq k \leq p$, the dimension of the eigenspace for $\lambda_k$ is less than or equal to the algebraic multiplicity of the eigenvalue $\lambda_k$.
> 
> b. The matrix $A$ is diagonalizable if and only if the sum of the dimensions of the eigenspaces equals $n$. This occurs if and only if (i) the characteristic polynomial factors completely into linear factors and (ii) the dimension of the eigenspace for each $\lambda_k$ equals the algebraic multiplicity of $\lambda_k$.
> 
> c. If $A$ is diagonalizable and $\mathcal{B}_k$ is a basis for the eigenspace corresponding to $\lambda_k$ for each $k$, then the total collection of vectors in the sets $\mathcal{B}_1, \ldots, \mathcal{B}_p$ forms an eigenvector basis for $\mathbb{R}^n$.

> [!example] Diagonalizing a 4×4 Matrix with Multiple Eigenvalues
> Diagonalize the matrix, if possible:
> $$A = \begin{bmatrix} 5 & 0 & 0 & 0 \\ 0 & 5 & 0 & 0 \\ 1 & 4 & 3 & 0 \\ -1 & -2 & 0 & 3 \end{bmatrix}$$
> 
> **Step 1: Find the eigenvalues.**
> Because $A$ is triangular, the eigenvalues are its diagonal entries: $\lambda_1 = 5$ (multiplicity 2) and $\lambda_2 = 3$ (multiplicity 2).
> 
> **Step 2: Find bases for the eigenspaces.**
> - For $\lambda_1 = 5$, row reduce $A - 5I$:
>   $$A - 5I = \begin{bmatrix} 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ 1 & 4 & -2 & 0 \\ -1 & -2 & 0 & -2 \end{bmatrix} \sim \begin{bmatrix} 1 & 0 & 2 & 4 \\ 0 & 1 & -1 & -1 \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix}$$
>   The general solution is $x_1 = -2x_3 - 4x_4$ and $x_2 = x_3 + x_4$, which yields the basis:
>   $$v_1 = \begin{bmatrix} -8 \\ 4 \\ 1 \\ 0 \end{bmatrix}, \quad v_2 = \begin{bmatrix} -16 \\ 4 \\ 0 \\ 4 \end{bmatrix}$$
>   The dimension of this eigenspace is 2, matching its algebraic multiplicity.
> 
> - For $\lambda_2 = 3$, row reduce $A - 3I$:
>   $$A - 3I = \begin{bmatrix} 2 & 0 & 0 & 0 \\ 0 & 2 & 0 & 0 \\ 1 & 4 & 0 & 0 \\ -1 & -2 & 0 & 0 \end{bmatrix} \sim \begin{bmatrix} 1 & 0 & 0 & 0 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 0 & 0 \\ 0 & 0 & 0 & 0 \end{bmatrix}$$
>   The general solution has free variables $x_3$ and $x_4$, yielding the basis:
>   $$v_3 = \begin{bmatrix} 0 \\ 0 \\ 1 \\ 0 \end{bmatrix}, \quad v_4 = \begin{bmatrix} 0 \\ 0 \\ 0 \\ 1 \end{bmatrix}$$
>   The dimension of this eigenspace is 2, matching its algebraic multiplicity.
> 
> **Step 3: Construct $P$ and $D$.**
> The total collection $\{v_1, v_2, v_3, v_4\}$ forms an eigenvector basis for $\mathbb{R}^4$.
> $$P = \begin{bmatrix} -8 & -16 & 0 & 0 \\ 4 & 4 & 0 & 0 \\ 1 & 0 & 1 & 0 \\ 0 & 4 & 0 & 1 \end{bmatrix}, \quad D = \begin{bmatrix} 5 & 0 & 0 & 0 \\ 0 & 5 & 0 & 0 \\ 0 & 0 & 3 & 0 \\ 0 & 0 & 0 & 3 \end{bmatrix}$$

---

> [!question] Practice Problems
> 1. Compute $A^8$, where $A = \begin{bmatrix} 4 & -3 \\ 2 & -1 \end{bmatrix}$.
> 2. Let $A = \begin{bmatrix} -3 & 12 \\ -2 & 7 \end{bmatrix}$, $v_1 = \begin{bmatrix} 3 \\ 1 \end{bmatrix}$, and $v_2 = \begin{bmatrix} 2 \\ 1 \end{bmatrix}$. Suppose you are told that $v_1$ and $v_2$ are eigenvectors of $A$. Use this information to diagonalize $A$.
> 3. Let $A$ be a $4 \times 4$ matrix with eigenvalues $5$, $3$, and $2$, and suppose you know that the eigenspace for $\lambda = 3$ is two-dimensional. Do you have enough information to determine if $A$ is diagonalizable?

## 5.4 Eigenvectors and Linear Transformations

The concepts of [[Eigenvalue|eigenvalues]] and [[Eigenvector|eigenvectors]] extend naturally beyond matrix multiplication to general [[Linear Transformation|linear transformations]] $T: V \to V$ acting on any vector space $V$. When $V$ is a finite-dimensional vector space and possesses a basis consisting of eigenvectors of $T$, the transformation $T$ can be represented simply as left-multiplication by a diagonal matrix.

---

### Eigenvectors of Linear Transformations

Linear transformations can act on various vector spaces, such as function spaces, spaces of polynomials $\mathbb{P}_n$, or discrete-time signal spaces $\mathbb{S}$. Eigenvalues and eigenvectors are defined for transformations mapping any vector space to itself.

> [!info] Definition: Eigenvector and Eigenvalue of a Linear Transformation
> Let $V$ be a vector space. An **eigenvector** of a linear transformation $T: V \to V$ is a nonzero vector $x \in V$ such that:
> $$T(x) = \lambda x$$
> for some scalar $\lambda$. 
> 
> A scalar $\lambda$ is called an **eigenvalue** of $T$ if there exists a nontrivial (nonzero) solution $x$ to $T(x) = \lambda x$. Such an $x$ is called an eigenvector corresponding to $\lambda$.
> 
> - **Breakdown:**
>     - **$V$**: A vector space (finite- or infinite-dimensional).
>     - **$T$**: A linear mapping from $V$ into itself ($T: V \to V$).
>     - **$x$**: A nonzero vector in $V$ whose direction is invariant under $T$.
>     - **$\lambda$**: The eigenvalue scalar that scales $x$ under the transformation.

> [!example] Sinusoidal Signal as an Eigenvector of a Shift Operator
> Consider the discrete-time sinusoidal signal $\{s_k\} = \left\{ \cos\left(\frac{k\pi}{2}\right) \right\}$, where $k$ ranges over all integers. 
> 
> Let $D$ be the *left double-shift* linear transformation defined by:
> $$D(\{x_k\}) = \{x_{k+2}\}$$
> 
> Applying $D$ to $\{s_k\}$ and setting $\{y_k\} = D(\{s_k\})$:
> $$y_k = s_{k+2} = \cos\left(\frac{(k+2)\pi}{2}\right) = \cos\left(\frac{k\pi}{2} + \pi\right)$$
> 
> Using the trigonometric identity $\cos(\theta + \pi) = -\cos(\theta)$:
> $$y_k = -\cos\left(\frac{k\pi}{2}\right) = -s_k$$
> 
> Therefore:
> $$D(\{s_k\}) = -\{s_k\} = (-1)\{s_k\}$$
> 
> This confirms that $\{s_k\}$ is an eigenvector of the double-shift transformation $D$ corresponding to the eigenvalue $\lambda = -1$. Geometrically, shifting this signal by two units negates each value, which corresponds to scalar multiplication by $-1$.

![[Pasted image 20261006211333.png]]
FIGURE 1

---

### The Matrix of a Linear Transformation

Let $V$ be an $n$-dimensional vector space, and let $T: V \to V$ be a linear transformation. Choosing an ordered basis $\mathcal{B} = \{b_1, b_2, \ldots, b_n\}$ for $V$ allows every vector $x \in V$ to be uniquely identified by its [[Coordinate Vector|coordinate vector]] $[x]_\mathcal{B} \in \mathbb{R}^n$.

If $x = r_1 b_1 + r_2 b_2 + \cdots + r_n b_n$, then:
$$[x]_\mathcal{B} = \begin{bmatrix} r_1 \\ r_2 \\ \vdots \\ r_n \end{bmatrix}$$

Because $T$ is linear:
$$T(x) = T(r_1 b_1 + \cdots + r_n b_n) = r_1 T(b_1) + \cdots + r_n T(b_n) \quad \text{--- (1)}$$

Applying the coordinate mapping to equation (1):
$$[T(x)]_\mathcal{B} = r_1 [T(b_1)]_\mathcal{B} + \cdots + r_n [T(b_n)]_\mathcal{B} \quad \text{--- (2)}$$

Since coordinate vectors exist in $\mathbb{R}^n$, equation (2) can be expressed as matrix multiplication:
$$[T(x)]_\mathcal{B} = M [x]_\mathcal{B} \quad \text{--- (3)}$$

where:
$$M = \begin{bmatrix} [T(b_1)]_\mathcal{B} & [T(b_2)]_\mathcal{B} & \cdots & [T(b_n)]_\mathcal{B} \end{bmatrix} \quad \text{--- (4)}$$

> [!info] Matrix Representation Relative to a Basis
> The matrix $M$ is the **matrix representation of $T$ relative to the basis $\mathcal{B}$**, denoted by $[T]_\mathcal{B}$.
> 
> The relationship:
> $$[T(x)]_\mathcal{B} = [T]_\mathcal{B} [x]_\mathcal{B}$$
> states that the action of $T$ on coordinate vectors is equivalent to left-multiplication by the matrix $[T]_\mathcal{B}$.
> ![[Pasted image 20261006211405.png]]
> FIGURE 2

> [!example] Finding the Matrix of a Transformation
> Let $\mathcal{B} = \{b_1, b_2\}$ be a basis for a vector space $V$. Let $T: V \to V$ be a linear transformation satisfying:
> $$T(b_1) = 3b_1 - 2b_2 \quad \text{and} \quad T(b_2) = 4b_1 + 7b_2$$
> 
> **Step 1:** Determine the $\mathcal{B}$-coordinate vectors of the transformed basis elements:
> $$[T(b_1)]_\mathcal{B} = \begin{bmatrix} 3 \\ -2 \end{bmatrix}, \qquad [T(b_2)]_\mathcal{B} = \begin{bmatrix} 4 \\ 7 \end{bmatrix}$$
> 
> **Step 2:** Form $[T]_\mathcal{B}$ by placing coordinate vectors into columns:
> $$[T]_\mathcal{B} = \begin{bmatrix} [T(b_1)]_\mathcal{B} & [T(b_2)]_\mathcal{B} \end{bmatrix} = \begin{bmatrix} 3 & 4 \\ -2 & 7 \end{bmatrix}$$
> ![[Pasted image 20261006211424.png]]

> [!example] Differentiation Operator on Polynomials
> Let $\mathbb{P}_2$ be the space of polynomials of degree at most 2, with standard basis $\mathcal{B} = \{1, t, t^2\}$. Define the differentiation transformation $T: \mathbb{P}_2 \to \mathbb{P}_2$ by:
> $$T(a_0 + a_1 t + a_2 t^2) = a_1 + 2a_2 t$$
> 
> **a. Find the matrix $[T]_\mathcal{B}$:**
> 
> 1. Compute the derivative of each basis element:
>    $$T(1) = 0, \quad T(t) = 1, \quad T(t^2) = 2t$$
> 
> 2. Convert each result into its $\mathcal{B}$-coordinate vector:
>    $$[T(1)]_\mathcal{B} = \begin{bmatrix} 0 \\ 0 \\ 0 \end{bmatrix}, \quad [T(t)]_\mathcal{B} = \begin{bmatrix} 1 \\ 0 \\ 0 \end{bmatrix}, \quad [T(t^2)]_\mathcal{B} = \begin{bmatrix} 0 \\ 2 \\ 0 \end{bmatrix}$$
>    ![[Pasted image 20261006211449.png]]
> 
> 3. Combine them into the matrix:
>    $$[T]_\mathcal{B} = \begin{bmatrix} 0 & 1 & 0 \\ 0 & 0 & 2 \\ 0 & 0 & 0 \end{bmatrix}$$
> 
> **b. Verify $[T(p)]_\mathcal{B} = [T]_\mathcal{B}[p]_\mathcal{B}$ for a general polynomial $p(t) = a_0 + a_1 t + a_2 t^2$:**
> 
> Direct evaluation:
> $$[T(p)]_\mathcal{B} = [a_1 + 2a_2 t]_\mathcal{B} = \begin{bmatrix} a_1 \\ 2a_2 \\ 0 \end{bmatrix}$$
> 
> Matrix multiplication:
> $$[T]_\mathcal{B}[p]_\mathcal{B} = \begin{bmatrix} 0 & 1 & 0 \\ 0 & 0 & 2 \\ 0 & 0 & 0 \end{bmatrix}\begin{bmatrix} a_0 \\ a_1 \\ a_2 \end{bmatrix} = \begin{bmatrix} a_1 \\ 2a_2 \\ 0 \end{bmatrix} \quad \checkmark$$
> ![[Pasted image 20261006211511.png]]
> 
> ![[Pasted image 20261006211526.png]]
> FIGURE 3 Matrix representation of a linear transformation.

---

### Linear Transformations on $\mathbb{R}^n$

When working in $\mathbb{R}^n$, a linear transformation typically appears as matrix multiplication $T(x) = Ax$. If $A$ is diagonalizable, there exists an eigenvector basis $\mathcal{B}$ for $\mathbb{R}^n$ that diagonalizes the matrix representation of $T$.

> [!summary] Theorem 8 : Diagonal Matrix Representation
> Suppose $A = PDP^{-1}$, where $D$ is a diagonal $n \times n$ matrix. If $\mathcal{B}$ is the basis for $\mathbb{R}^n$ formed from the columns of $P$, then $D$ is the $\mathcal{B}$-matrix for the transformation $x \mapsto Ax$.
> 
> **breakdown**:
> - **$A$**: The $n \times n$ standard matrix of the transformation $T(x) = Ax$.
> - **$P = [b_1 \ b_2 \ \cdots \ b_n]$**: The change-of-coordinates matrix $P_\mathcal{B}$, whose columns form the basis $\mathcal{B}$.
> - **$D$**: The diagonal matrix representing $T$ relative to the eigenvector basis $\mathcal{B}$ (i.e., $[T]_\mathcal{B} = D$).
> - **Key insight**: Diagonalizing a matrix $A$ is geometrically equivalent to finding an eigenvector basis in which the linear transformation acts simply by scaling each coordinate independently.
> 
> **proof**:
> Let the columns of $P$ be denoted by $b_1, \ldots, b_n$, so that $\mathcal{B} = \{b_1, \ldots, b_n\}$ and $P = [b_1 \ \cdots \ b_n]$. The matrix $P$ acts as the change-of-coordinates matrix:
> $$P[x]_\mathcal{B} = x \implies [x]_\mathcal{B} = P^{-1}x$$
> 
> For $T(x) = Ax$:
> $$[T]_\mathcal{B} = \begin{bmatrix} [T(b_1)]_\mathcal{B} & \cdots & [T(b_n)]_\mathcal{B} \end{bmatrix} = \begin{bmatrix} [Ab_1]_\mathcal{B} & \cdots & [Ab_n]_\mathcal{B} \end{bmatrix}$$
> 
> Applying the coordinate transformation $[v]_\mathcal{B} = P^{-1}v$:
> $$[T]_\mathcal{B} = \begin{bmatrix} P^{-1}Ab_1 & \cdots & P^{-1}Ab_n \end{bmatrix} = P^{-1}A\begin{bmatrix} b_1 & \cdots & b_n \end{bmatrix} = P^{-1}AP$$
> 
> Since $A = PDP^{-1}$, it follows that $[T]_\mathcal{B} = P^{-1}AP = D$.

> [!example] Diagonal Matrix Representation
> Define $T: \mathbb{R}^2 \to \mathbb{R}^2$ by $T(x) = Ax$, where $A = \begin{bmatrix} 7 & 2 \\ -4 & 1 \end{bmatrix}$. Find a basis $\mathcal{B}$ for $\mathbb{R}^2$ such that the $\mathcal{B}$-matrix for $T$ is diagonal.
> 
> From previous diagonalization results, $A = PDP^{-1}$ with:
> $$P = \begin{bmatrix} 1 & -1 \\ -1 & 2 \end{bmatrix}, \qquad D = \begin{bmatrix} 5 & 0 \\ 0 & 3 \end{bmatrix}$$
> 
> Setting the basis $\mathcal{B} = \{b_1, b_2\}$ to be the columns of $P$:
> $$b_1 = \begin{bmatrix} 1 \\ -1 \end{bmatrix}, \qquad b_2 = \begin{bmatrix} -1 \\ 2 \end{bmatrix}$$
> 
> By Theorem 8, the matrix for $T$ relative to $\mathcal{B}$ is precisely the diagonal matrix $D = \begin{bmatrix} 5 & 0 \\ 0 & 3 \end{bmatrix}$. The mappings $x \mapsto Ax$ and $u \mapsto Du$ describe the exact same linear transformation under different coordinate systems.

---

### Similarity of Matrix Representations

The identity $[T]_\mathcal{B} = P^{-1}AP$ holds whether or not $D$ is diagonal. More broadly, if $A = PCP^{-1}$, then $C$ is the $\mathcal{B}$-matrix for the transformation $x \mapsto Ax$, where the columns of $P$ form the basis $\mathcal{B}$.
![[Pasted image 20261006211602.png]]
FIGURE 4 Similarity of two matrix representations: A D PCP1 .

> [!info] Fundamental Link: Similar Matrices and Linear Transformations
> The set of all matrices **[[Similar Matrices|similar]]** to a matrix $A$ coincides with the set of all matrix representations of the linear transformation $x \mapsto Ax$ with respect to different choices of basis.

When a matrix is not diagonalizable (due to a shortage of linearly independent eigenvectors), it cannot be represented by a diagonal matrix. However, it can always be represented by a nearly-diagonal, upper-triangular matrix called the **[[Jordan Form|Jordan canonical form]]**.

> [!example] Non-Diagonalizable Transformation to Jordan Form
> Let $A = \begin{bmatrix} 4 & -9 \\ 4 & -8 \end{bmatrix}$, $b_1 = \begin{bmatrix} 3 \\ 2 \end{bmatrix}$, and $b_2 = \begin{bmatrix} 2 \\ 1 \end{bmatrix}$.
> 
> The characteristic polynomial of $A$ is $(\lambda + 2)^2$, but the eigenspace for $\lambda = -2$ is only one-dimensional, meaning $A$ is not diagonalizable.
> 
> Let $\mathcal{B} = \{b_1, b_2\}$ and $P = [b_1 \ b_2] = \begin{bmatrix} 3 & 2 \\ 2 & 1 \end{bmatrix}$. Compute the $\mathcal{B}$-matrix $[T]_\mathcal{B} = P^{-1}AP$:
> 
> **Step 1:** Compute $AP$:
> $$AP = \begin{bmatrix} 4 & -9 \\ 4 & -8 \end{bmatrix} \begin{bmatrix} 3 & 2 \\ 2 & 1 \end{bmatrix} = \begin{bmatrix} -6 & -1 \\ -4 & 0 \end{bmatrix}$$
> 
> **Step 2:** Compute $P^{-1}$:
> $$P^{-1} = \frac{1}{(3)(1) - (2)(2)}\begin{bmatrix} 1 & -2 \\ -2 & 3 \end{bmatrix} = \begin{bmatrix} -1 & 2 \\ 2 & -3 \end{bmatrix}$$
> 
> **Step 3:** Compute $P^{-1}AP$:
> $$P^{-1}AP = \begin{bmatrix} -1 & 2 \\ 2 & -3 \end{bmatrix}\begin{bmatrix} -6 & -1 \\ -4 & 0 \end{bmatrix} = \begin{bmatrix} -2 & 1 \\ 0 & -2 \end{bmatrix}$$
> 
> The resulting matrix is in Jordan form, displaying the eigenvalue $-2$ along the main diagonal.

---

### Numerical Notes

> [!tip] Computing $P^{-1}AP$ Efficiently
> An efficient method to compute the similarity product $P^{-1}AP$ without computing $P^{-1}$ separately is to compute the matrix product $AP$ first, then row reduce the augmented matrix:
> $$\begin{bmatrix} P & \mid & AP \end{bmatrix} \sim \begin{bmatrix} I & \mid & P^{-1}AP \end{bmatrix}$$

---

> [!question] Practice Problems
> 1. Find $T(a_0 + a_1 t + a_2 t^2)$ if $T$ is the linear transformation from $\mathbb{P}_2$ to $\mathbb{P}_2$ whose matrix relative to $\mathcal{B} = \{1, t, t^2\}$ is:
>    $$[T]_\mathcal{B} = \begin{bmatrix} 3 & 4 & 0 \\ 0 & 5 & -1 \\ 1 & -2 & 7 \end{bmatrix}$$
> 
> 2. Matrix similarity is an [[Equivalence Relation|equivalence relation]]. Verify the following properties for $n \times n$ matrices $A, B,$ and $C$:
>    - **a. Reflexivity:** $A$ is similar to $A$.
>    - **b. Transitivity:** If $A$ is similar to $B$ and $B$ is similar to $C$, then $A$ is similar to $C$.