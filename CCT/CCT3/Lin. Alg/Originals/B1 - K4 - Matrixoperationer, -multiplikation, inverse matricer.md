---
tags:
  - CCT3
  - Lin_Algebra
Topic: Marix-operationer, Matrix-multiplikation, Inverse matricer
Semester: CCT3
Course: Linær Algebra
Litterature:
  - Linear Algebra and Its Applications, Global Edition, 6ed
Created: 06-09-2026
---
- - -
## Table of Contents

1. [[#Matrix Algebra|Matrix Algebra]]
	1. [[#Matrix Algebra#Introductory Example|Introductory Example]]
		1. [[#Introductory Example#COMPUTER MODELS IN AIRCRAFT DESIGN|COMPUTER MODELS IN AIRCRAFT DESIGN]]
	2. [[#Matrix Algebra#Matrix Operations|Matrix Operations]]
		1. [[#Matrix Operations#Sums and Scalar Multiples|Sums and Scalar Multiples]]
		2. [[#Matrix Operations#Matrix Multiplication|Matrix Multiplication]]
			1. [[#Matrix Multiplication#Matrix Size Requirements for Multiplication|Matrix Size Requirements for Multiplication]]
			2. [[#Matrix Multiplication#The Row–Column Rule for Computing $AB$|The Row–Column Rule for Computing $AB$]]
			3. [[#Matrix Multiplication#Computing Individual Rows of a Product|Computing Individual Rows of a Product]]
		3. [[#Matrix Operations#Properties of Matrix Multiplication|Properties of Matrix Multiplication]]
			1. [[#Properties of Matrix Multiplication#Matrix Grouping and Commutativity|Matrix Grouping and Commutativity]]
		4. [[#Matrix Operations#Powers of a Matrix|Powers of a Matrix]]
		5. [[#Matrix Operations#The Transpose of a Matrix|The Transpose of a Matrix]]
			1. [[#The Transpose of a Matrix#Applications to Pattern Recognition and Data Processing|Applications to Pattern Recognition and Data Processing]]
		6. [[#Matrix Operations#The Inverse of a Matrix|The Inverse of a Matrix]]
			1. [[#The Inverse of a Matrix#Inverting $2 \times 2$ Matrices|Inverting $2 \times 2$ Matrices]]
			2. [[#The Inverse of a Matrix#Solving Linear Systems Using Matrix Inverses|Solving Linear Systems Using Matrix Inverses]]
			3. [[#The Inverse of a Matrix#Physical Application: Flexibility and Stiffness Matrices|Physical Application: Flexibility and Stiffness Matrices]]
			4. [[#The Inverse of a Matrix#Algebraic Properties of Invertible Matrices|Algebraic Properties of Invertible Matrices]]
		7. [[#Matrix Operations#Elementary Matrices|Elementary Matrices]]
			1. [[#Elementary Matrices#Invertibility of Elementary Matrices|Invertibility of Elementary Matrices]]
			2. [[#Elementary Matrices#Row Equivalence and Matrix Inversion|Row Equivalence and Matrix Inversion]]
		8. [[#Matrix Operations#An Algorithm for Finding $A^{-1}$|An Algorithm for Finding $A^{-1}$]]
		9. [[#Matrix Operations#Another View of Matrix Inversion|Another View of Matrix Inversion]]

# Matrix Algebra

## Introductory Example

### COMPUTER MODELS IN AIRCRAFT DESIGN

To design modern commercial and military aircraft, engineers utilize 3D modeling and _computational fluid dynamics_ (CFD). By analyzing the airflow around a virtual aircraft, design questions can be resolved prior to constructing physical prototypes. This approach significantly lowers both cycle times and manufacturing costs, with linear algebra serving as a fundamental component of the process.

A virtual aircraft originates as a mathematical _wire-frame model_ stored in computer memory and rendered on graphics terminals. This model organizes and guides each stage of design and manufacturing for both the interior and exterior of the plane, with CFD analysis focusing specifically on the exterior surfaces.

Although an airplane's skin appears smooth, its geometry is highly complex, consisting of the fuselage, wings, nacelles, stabilizers, slats, flaps, and ailerons. The airflow around these interconnected structures dictates aerodynamic performance. The governing airflow equations are intricate, accounting for engine intake, exhaust, and wing wake turbulence, which demands an exceptionally refined description of the surface.

To construct this surface model, a computer superimposes a three-dimensional grid of boxes onto the wire-frame model:
- Boxes are identified as lying completely inside the aircraft, completely outside, or intersecting the surface.
- The computer isolates intersecting boxes and subdivides them iteratively, retaining only the smaller sub-boxes that continue to intersect the surface.
- This process continues until a dense grid—often exceeding 400,000 boxes—is formed.

>[!info] Airflow Linear System
>Determining airflow across the grid requires repeatedly solving large-scale systems of linear equations:
>
>$$Ax = b$$
>
>**Breakdown:**
>- $A$ : The coefficient matrix (typically a massive, sparse matrix representing the physical relationships between grid points).
>- $x$ : The vector of unknown airflow variables to be determined.
>- $b$ : The vector of known values, updated iteratively based on grid boundary data and solutions from preceding iterations.

These systems can involve up to 2 million equations and variables. Setting up and computing a single airflow solution can take from several hours to multiple days on high-performance computers. Because thousands of CFD runs may be needed as minor geometry adjustments are tested, efficient linear algebra techniques are essential.

Two primary matrix concepts make solving these large systems computationally feasible:

- **Partitioned Matrices:** CFD systems feature _sparse_ coefficient matrices containing mostly zero entries. Systematically grouping variables produces partitioned (block) matrices with large blocks of zeros, simplifying storage and manipulation.
- **Matrix Factorizations:** To accelerate computation, CFD software relies on matrix decompositions, such as the $LU$ _factorization_ of the coefficient matrix, to solve the systems without computing explicit inverses.

Linear algebra also serves as the foundation for computer graphics used to visualize airflow. The wire-frame geometry of the aircraft is stored across multiple matrices. By executing specific matrix multiplications, visualization software performs geometric transformations on the rendered image:
- **Scaling:** Modifying the overall dimensions of the view.
- **Zooming:** Magnifying localized regions of the surface.
- **Rotation:** Reorienting the aircraft model in 3D space to inspect obstructed components.

Performing algebraic operations on matrices provides the foundational tools necessary for analyzing complex systems across engineering, computer graphics, economics, and theoretical subspace analysis.

## Matrix Operations

If $A$ is an $m \times n$ matrix—a matrix containing $m$ rows and $n$ columns—the scalar entry located in the $i\text{th}$ row and $j\text{th}$ column is denoted by $a_{ij}$ and is called the _$(i, j)$-entry_ of $A$. For instance, the $(3, 2)$-entry is the scalar $a_{32}$ located in the third row and second column.

Each column of $A$ consists of a list of $m$ real numbers, which identifies a vector in $\mathbb{R}^m$. When these column vectors are denoted by $\mathbf{a}_1, \mathbf{a}_2, \dots, \mathbf{a}_n$, the matrix $A$ can be written in partitioned column form:

$$A = \begin{bmatrix} \mathbf{a}_1 & \mathbf{a}_2 & \cdots & \mathbf{a}_n \end{bmatrix}$$

**Breakdown:**
- $A$ : The $m \times n$ matrix.
- $\mathbf{a}_j$ : The $j\text{th}$ column vector in $\mathbb{R}^m$.
- $a_{ij}$ : The $i\text{th}$ scalar entry (from the top) of the column vector $\mathbf{a}_j$.

The entries $a_{11}, a_{22}, a_{33}, \dots$ of an $m \times n$ matrix $A = [a_{ij}]$ form the _main diagonal_ of $A$.

![[Pasted image 20260926125731.png]]
FIGURE 1 Matrix notation.

>[!info] Special Matrix Types
>- **Diagonal Matrix:** A square $n \times n$ matrix whose nondiagonal entries are all zero ($a_{ij} = 0$ for $i \neq j$).
>- **Identity Matrix ($I_n$):** An $n \times n$ diagonal matrix with $1$s on the main diagonal and $0$s elsewhere.
>- **Zero Matrix ($0$):** An $m \times n$ matrix in which every entry is zero. The dimensions of a zero matrix are typically determined by context.
### Sums and Scalar Multiples

Two matrices are defined as _equal_ if they have the same size (identical number of rows and columns) and their corresponding entries are equal. 

If $A$ and $B$ are both $m \times n$ matrices, the sum $A + B$ is the $m \times n$ matrix whose columns are the sums of the corresponding columns in $A$ and $B$. Because column addition is performed entrywise, each entry in $A + B$ is the sum of the corresponding entries at that position in $A$ and $B$. 

>[!warning] Dimension Requirement for Addition
>The sum $A + B$ is defined **only** when $A$ and $B$ have the exact same dimensions ($m \times n$). If their dimensions differ, the sum is undefined.

>[!example] Matrix Addition
>Consider the matrices:
>
>$$A = \begin{bmatrix} 4 & 0 & 5 \\ 1 & 3 & 2 \end{bmatrix}, \quad B = \begin{bmatrix} 1 & 1 & 1 \\ 3 & 5 & 7 \end{bmatrix}, \quad C = \begin{bmatrix} 2 & 3 \\ 0 & 1 \end{bmatrix}$$
>
>The sum $A + B$ is computed entrywise:
>
>$$A + B = \begin{bmatrix} 4+1 & 0+1 & 5+1 \\ 1+3 & 3+5 & 2+7 \end{bmatrix} = \begin{bmatrix} 5 & 1 & 6 \\ 4 & 8 & 9 \end{bmatrix}$$
>
>The expression $A + C$ is **undefined** because $A$ is a $2 \times 3$ matrix while $C$ is a $2 \times 2$ matrix.

If $r$ is a scalar and $A$ is an $m \times n$ matrix, the scalar multiple $rA$ is the matrix whose columns (and individual entries) are $r$ times the corresponding columns (and entries) in $A$. 

Matrix subtraction is defined using scalar multiplication:
$$-A = (-1)A \quad \text{and} \quad A - B = A + (-1)B$$

>[!example] Scalar Multiplication and Subtraction
>Using the matrices $A$ and $B$ from the previous example:
>
>$$2B = 2 \begin{bmatrix} 1 & 1 & 1 \\ 3 & 5 & 7 \end{bmatrix} = \begin{bmatrix} 2 & 2 & 2 \\ 6 & 10 & 14 \end{bmatrix}$$
>
>$$A - 2B = \begin{bmatrix} 4 & 0 & 5 \\ 1 & 3 & 2 \end{bmatrix} - \begin{bmatrix} 2 & 2 & 2 \\ 6 & 10 & 14 \end{bmatrix} = \begin{bmatrix} 2 & -2 & 3 \\ -5 & -7 & -12 \end{bmatrix}$$

>[!summary] Theorem 1: Algebraic Properties of Matrix Addition and Scalar Multiplication
>Let $A$, $B$, and $C$ be matrices of the same size ($m \times n$), and let $r$ and $s$ be scalars.
>
>a. $A + B = B + A$
>b. $(A + B) + C = A + (B + C)$
>c. $A + 0 = A$
>d. $r(A + B) = rA + rB$
>e. $(r + s)A = rA + sA$
>f. $r(sA) = (rs)A$
>
>**Breakdown**:
>- $A, B, C$ : Arbitrary matrices of identical dimension $m \times n$.
>- $0$ : The $m \times n$ zero matrix.
>- $r, s$ : Scalars (real numbers).
>- **Property (a) (Commutativity)** : Matrix addition order does not alter the resulting matrix.
>- **Property (b) (Associativity)** : Grouping of additions does not change the result, permitting the notation $A + B + C$ without ambiguity.
>- **Property (c) (Additive Identity)** : Adding the zero matrix preserves the original matrix.
>- **Properties (d, e, f) (Distributive and Associative Scaling)** : Scalar multiplication distributes over matrix addition and scalar addition, and associates with scalar multiplication.
>
>**Proof**:
>Each property is verified by confirming that the left and right sides have the same dimensions and that their corresponding column vectors are identical.
>
>Because $A, B,$ and $C$ share the same dimensions, size consistency is satisfied. The equality of columns follows directly from vector arithmetic in $\mathbb{R}^m$. 
>
>For example, if the $j\text{th}$ columns of $A$, $B$, and $C$ are denoted by $\mathbf{a}_j$, $\mathbf{b}_j$, and $\mathbf{c}_j$, the $j\text{th}$ columns of $(A + B) + C$ and $A + (B + C)$ are:
>
>$$(\mathbf{a}_j + \mathbf{b}_j) + \mathbf{c}_j \quad \text{and} \quad \mathbf{a}_j + (\mathbf{b}_j + \mathbf{c}_j)$$
>
>Since vector addition in $\mathbb{R}^m$ is associative, these two column vectors are equal for every column index $j$, proving property (b). The remaining properties follow analogously from vector space properties.
### Matrix Multiplication

When a matrix $B$ multiplies a vector $\mathbf{x}$, it transforms $\mathbf{x}$ into the vector $B\mathbf{x}$. If this vector is subsequently multiplied by a matrix $A$, the resulting vector is $A(B\mathbf{x})$. This process represents a composite mapping of two linear transformations. 

![[Pasted image 20260926131100.png]]
FIGURE 2 Multiplication by B and then A.

Matrix multiplication is defined so that this composite mapping is represented by multiplication by a single standard matrix, denoted by $AB$:

$$A(B\mathbf{x}) = (AB)\mathbf{x}$$
![[Pasted image 20260926131122.png]]
FIGURE 3 Multiplication by AB.

To determine the structure of $AB$, let $A$ be an $m \times n$ matrix, $B$ an $n \times p$ matrix with columns $\mathbf{b}_1, \dots, \mathbf{b}_p$, and $\mathbf{x}$ a vector in $\mathbb{R}^p$ with entries $x_1, \dots, x_p$:

$$B\mathbf{x} = x_1\mathbf{b}_1 + \cdots + x_p\mathbf{b}_p$$

By the linearity of matrix-vector multiplication:

$$A(B\mathbf{x}) = A(x_1\mathbf{b}_1 + \cdots + x_p\mathbf{b}_p) = x_1(A\mathbf{b}_1) + \cdots + x_p(A\mathbf{b}_p)$$

This linear combination can be expressed in matrix form as:

$$A(B\mathbf{x}) = \begin{bmatrix} A\mathbf{b}_1 & A\mathbf{b}_2 & \cdots & A\mathbf{b}_p \end{bmatrix} \mathbf{x}$$

>[!summary] Definition: Matrix Multiplication
>If $A$ is an $m \times n$ matrix, and $B$ is an $n \times p$ matrix with columns $\mathbf{b}_1, \dots, \mathbf{b}_p$, then the product $AB$ is the $m \times p$ matrix whose columns are $A\mathbf{b}_1, \dots, A\mathbf{b}_p$:
>
>$$AB = A \begin{bmatrix} \mathbf{b}_1 & \mathbf{b}_2 & \cdots & \mathbf{b}_p \end{bmatrix} = \begin{bmatrix} A\mathbf{b}_1 & A\mathbf{b}_2 & \cdots & A\mathbf{b}_p \end{bmatrix}$$
>
>**Breakdown:**
>- $A$ : The left factor matrix of size $m \times n$.
>- $B$ : The right factor matrix of size $n \times p$.
>- $\mathbf{b}_j$ : The $j\text{th}$ column vector of $B$ ($j = 1, 2, \dots, p$).
>- $A\mathbf{b}_j$ : The $j\text{th}$ column vector of the product $AB$, formed by the matrix-vector product of $A$ and $\mathbf{b}_j$.
>- $AB$ : The resulting product matrix of size $m \times p$.

Each column of $AB$ is a linear combination of the columns of $A$ using the weights from the corresponding column of $B$.

>[!example] Computing $AB$ Column by Column
>Given:
>$$A = \begin{bmatrix} 2 & 3 \\ 1 & -5 \end{bmatrix}, \quad B = \begin{bmatrix} 4 & 3 & 6 \\ 1 & -2 & 3 \end{bmatrix}$$
>
>Partition $B$ into its columns $\mathbf{b}_1, \mathbf{b}_2, \mathbf{b}_3$ and compute each column of $AB$:
>
>$$A\mathbf{b}_1 = \begin{bmatrix} 2 & 3 \\ 1 & -5 \end{bmatrix} \begin{bmatrix} 4 \\ 1 \end{bmatrix} = \begin{bmatrix} 2(4) + 3(1) \\ 1(4) - 5(1) \end{bmatrix} = \begin{bmatrix} 11 \\ -1 \end{bmatrix}$$
>
>$$A\mathbf{b}_2 = \begin{bmatrix} 2 & 3 \\ 1 & -5 \end{bmatrix} \begin{bmatrix} 3 \\ -2 \end{bmatrix} = \begin{bmatrix} 2(3) + 3(-2) \\ 1(3) - 5(-2) \end{bmatrix} = \begin{bmatrix} 0 \\ 13 \end{bmatrix}$$
>
>$$A\mathbf{b}_3 = \begin{bmatrix} 2 & 3 \\ 1 & -5 \end{bmatrix} \begin{bmatrix} 6 \\ 3 \end{bmatrix} = \begin{bmatrix} 2(6) + 3(3) \\ 1(6) - 5(3) \end{bmatrix} = \begin{bmatrix} 21 \\ -9 \end{bmatrix}$$
>
>Combining these columns yields:
>$$AB = \begin{bmatrix} A\mathbf{b}_1 & A\mathbf{b}_2 & A\mathbf{b}_3 \end{bmatrix} = \begin{bmatrix} 11 & 0 & 21 \\ -1 & 13 & -9 \end{bmatrix}$$
>
>![[Pasted image 20260926131202.png]]
>Figure: showing Ab1 Ab2 Ab3

#### Matrix Size Requirements for Multiplication

For the matrix product $AB$ to exist, the number of columns in $A$ must equal the number of rows in $B$. If $A$ is $m \times n$ and $B$ is $n \times p$, the resulting matrix $AB$ has dimension $m \times p$:

$$\begin{matrix} A & B & = & AB \\ (m \times n) & (n \times p) & & (m \times p) \\ & \uparrow \ \ \ \ \ \ \uparrow & & \\ & \text{Match} & & \end{matrix}$$

>[!example] Compatibility of Matrix Dimensions
>Let $A$ be a $3 \times 5$ matrix and $B$ be a $5 \times 2$ matrix:
>- **Product $AB$:** $A$ has 5 columns and $B$ has 5 rows (inner dimensions match). Thus, $AB$ is defined and has dimension $3 \times 2$.
>- **Product $BA$:** $B$ has 2 columns while $A$ has 3 rows (inner dimensions do not match). Therefore, $BA$ is **undefined**.
#### The Row–Column Rule for Computing $AB$

The row–column rule provides an entry-by-entry method for evaluating matrix products.

>[!info] Row–Column Rule
>If the product $AB$ is defined, the entry in row $i$ and column $j$ of $AB$, denoted by $(AB)_{ij}$, is the sum of the products of corresponding entries from row $i$ of $A$ and column $j$ of $B$:
>
>$$(AB)_{ij} = a_{i1}b_{1j} + a_{i2}b_{2j} + \cdots + a_{in}b_{nj} = \sum_{k=1}^{n} a_{ik}b_{kj}$$
>
>**Breakdown:**
>- $(AB)_{ij}$ : The scalar entry located in row $i$, column $j$ of the product matrix $AB$.
>- $a_{ik}$ : The $k\text{th}$ entry of row $i$ in matrix $A$.
>- $b_{kj}$ : The $k\text{th}$ entry of column $j$ in matrix $B$.
>- $n$ : The number of columns of $A$ (which equals the number of rows of $B$).
>- $\sum$ : Summation operator iterating from $k = 1$ to $n$.

![[Pasted image 20260926131243.png]]
Figure: Row–Column Rule for A and B into AB

>[!example] Applying the Row–Column Rule
>Using $A = \begin{bmatrix} 2 & 3 \\ 1 & -5 \end{bmatrix}$ and $B = \begin{bmatrix} 4 & 3 & 6 \\ 1 & -2 & 3 \end{bmatrix}$:
>
>- Entry $(AB)_{13}$ (Row 1 of $A$, Column 3 of $B$):
>  $$(AB)_{13} = 2(6) + 3(3) = 12 + 9 = 21$$
>
>- Entry $(AB)_{22}$ (Row 2 of $A$, Column 2 of $B$):
>  $$(AB)_{22} = 1(3) + (-5)(-2) = 3 + 10 = 13$$

#### Computing Individual Rows of a Product

The $i\text{th}$ row of a product matrix $AB$ depends exclusively on the $i\text{th}$ row of $A$ and the entire matrix $B$:

$$\text{row}_i(AB) = \text{row}_i(A) \cdot B$$

>[!example] Isolating a Specific Row of $AB$
>To find only the second row of $AB$ for:
>
>$$A = \begin{bmatrix} 2 & -5 & 0 \\ -1 & 3 & -4 \\ 6 & -8 & -7 \\ -3 & 0 & 9 \end{bmatrix}, \quad B = \begin{bmatrix} 4 & -6 \\ 7 & 1 \\ 3 & 2 \end{bmatrix}$$
>
>Multiply the second row of $A$ by $B$:
>
>$$\text{row}_2(AB) = \begin{bmatrix} -1 & 3 & -4 \end{bmatrix} \begin{bmatrix} 4 & -6 \\ 7 & 1 \\ 3 & 2 \end{bmatrix}$$
>
>$$\text{row}_2(AB) = \begin{bmatrix} (-1)(4) + 3(7) + (-4)(3) & (-1)(-6) + 3(1) + (-4)(2) \end{bmatrix}$$
>$$\text{row}_2(AB) = \begin{bmatrix} -4 + 21 - 12 & 6 + 3 - 8 \end{bmatrix} = \begin{bmatrix} 5 & 1 \end{bmatrix}$$
>
>![[Pasted image 20260926131444.png]]
> Figure: Solution example from the textbook
### Properties of Matrix Multiplication

Matrix multiplication satisfies several algebraic laws analogous to the arithmetic of real numbers. Recall that $I_m$ denotes the $m \times m$ identity matrix, where $I_m \mathbf{x} = \mathbf{x}$ for all $\mathbf{x} \in \mathbb{R}^m$.

>[!summary] Theorem 2: Properties of Matrix Multiplication
>Let $A$ be an $m \times n$ matrix, and let $B$ and $C$ be matrices with dimensions such that the indicated sums and products are defined. Let $r$ be a scalar.
>
>a. $A(BC) = (AB)C$ *(Associative Law of Multiplication)*
>b. $A(B + C) = AB + AC$ *(Left Distributive Law)*
>c. $(B + C)A = BA + CA$ *(Right Distributive Law)*
>d. $r(AB) = (rA)B = A(rB)$
>e. $I_m A = A = A I_n$ *(Identity for Matrix Multiplication)*
>
>**Breakdown**:
>- $A$ : An $m \times n$ matrix.
>- $B, C$ : Matrices of compatible sizes (for instance, $B, C$ of size $n \times p$ for distributivity, or $B$ of size $n \times p$ and $C$ of size $p \times q$ for associativity).
>- $r$ : A real scalar.
>- $I_m, I_n$ : The $m \times m$ and $n \times n$ identity matrices, serving as left and right multiplicative identities respectively.
>- **Associative Law (a)** : Regrouping product operations does not alter the resulting matrix, provided the left-to-right sequence of factors remains fixed.
>- **Distributive Laws (b, c)** : Matrix multiplication distributes across matrix addition from both the left and right.
>- **Scalar Scaling (d)** : Scalars associate freely across matrix factors in a product.
>
>**Proof**:
>Property (a) follows directly from the column definition of matrix multiplication. 
>
>Let $C = \begin{bmatrix} \mathbf{c}_1 & \mathbf{c}_2 & \cdots & \mathbf{c}_p \end{bmatrix}$. Then:
>$$BC = \begin{bmatrix} B\mathbf{c}_1 & B\mathbf{c}_2 & \cdots & B\mathbf{c}_p \end{bmatrix}$$
>
>Multiplying by $A$ on the left gives:
>$$A(BC) = \begin{bmatrix} A(B\mathbf{c}_1) & A(B\mathbf{c}_2) & \cdots & A(B\mathbf{c}_p) \end{bmatrix}$$
>
>Because the composite linear transformation satisfies $A(B\mathbf{x}) = (AB)\mathbf{x}$ for any vector $\mathbf{x}$:
>$$A(BC) = \begin{bmatrix} (AB)\mathbf{c}_1 & (AB)\mathbf{c}_2 & \cdots & (AB)\mathbf{c}_p \end{bmatrix} = (AB)C$$
>
>This verifies property (a).

#### Matrix Grouping and Commutativity

The associative and distributive laws indicate that parentheses can be inserted or removed in matrix expressions without changing the outcome. For instance, the product of three matrices can simply be written as $ABC$ and evaluated as either $A(BC)$ or $(AB)C$. Similarly, a product of four matrices $ABCD$ can be computed as $A(BCD)$, $(ABC)D$, or $A(BC)D$. 

The grouping does not affect the outcome **as long as the strict left-to-right order of the matrices is maintained**.

The order of factors is essential because, in general, $AB \neq BA$:
- The columns of $AB$ are linear combinations of the columns of $A$.
- The columns of $BA$ are linear combinations of the columns of $B$.

To distinguish the factor positions in $AB$:
- $A$ is **right-multiplied** by $B$.
- $B$ is **left-multiplied** by $A$.

If two square matrices satisfy $AB = BA$, they are said to _commute_.

>[!example] Non-Commutativity of Matrix Multiplication
>Let:
>$$A = \begin{bmatrix} 5 & 1 \\ 3 & -2 \end{bmatrix}, \quad B = \begin{bmatrix} 2 & 0 \\ 4 & 3 \end{bmatrix}$$
>
>Compute the products in both orders:
>
>$$AB = \begin{bmatrix} 5 & 1 \\ 3 & -2 \end{bmatrix} \begin{bmatrix} 2 & 0 \\ 4 & 3 \end{bmatrix} = \begin{bmatrix} 5(2) + 1(4) & 5(0) + 1(3) \\ 3(2) + (-2)(4) & 3(0) + (-2)(3) \end{bmatrix} = \begin{bmatrix} 14 & 3 \\ -2 & -6 \end{bmatrix}$$
>
>$$BA = \begin{bmatrix} 2 & 0 \\ 4 & 3 \end{bmatrix} \begin{bmatrix} 5 & 1 \\ 3 & -2 \end{bmatrix} = \begin{bmatrix} 2(5) + 0(3) & 2(1) + 0(-2) \\ 4(5) + 3(3) & 4(1) + 3(-2) \end{bmatrix} = \begin{bmatrix} 10 & 2 \\ 29 & -2 \end{bmatrix}$$
>
>Because $AB \neq BA$, the matrices $A$ and $B$ do not commute.

>[!warning] Fundamental Differences Between Matrix and Real Number Algebra
>1. **Lack of General Commutativity:** In general, $AB \neq BA$.
>2. **No General Cancellation Law:** If $AB = AC$, it does **not** generally follow that $B = C$.
>3. **Failure of the Zero-Product Property:** If $AB = 0$, it does **not** follow that either $A = 0$ or $B = 0$. The product of two non-zero matrices can yield a zero matrix.
### Powers of a Matrix

If $A$ is an $n \times n$ square matrix and $k$ is a positive integer, then $A^k$ denotes the product of $k$ copies of $A$:

$$A^k = \underbrace{A \cdot A \cdots A}_{k \text{ factors}}$$

>[!info] Definition: Matrix Powers
>For an $n \times n$ matrix $A$ and a vector $\mathbf{x} \in \mathbb{R}^n$:
>- **Positive Powers ($k \ge 1$):** The expression $A^k \mathbf{x}$ represents the result of left-multiplying $\mathbf{x}$ repeatedly by $A$ a total of $k$ times:
>  $$A^k \mathbf{x} = A(A(\cdots(A\mathbf{x})\cdots))$$
>- **Zero Power ($k = 0$):** The operation $A^0 \mathbf{x}$ leaves the vector $\mathbf{x}$ unchanged ($A^0 \mathbf{x} = \mathbf{x}$). Therefore, $A^0$ is defined as the $n \times n$ identity matrix:
>  $$A^0 = I_n$$
>
>**Breakdown:**
>- $A$ : An $n \times n$ square matrix (matrix powers are defined only for square matrices).
>- $k$ : A non-negative integer exponent.
>- $\mathbf{x}$ : A vector in $\mathbb{R}^n$.
>- $I_n$ : The $n \times n$ identity matrix.

Matrix powers provide essential algebraic tools for modeling iterative processes, dynamic systems, and linear recurrence relations.
### The Transpose of a Matrix

Given an $m \times n$ matrix $A$, the _transpose_ of $A$ is the $n \times m$ matrix, denoted by $A^T$, whose columns are formed from the corresponding rows of $A$. Equivalently, the $(i, j)$-entry of $A^T$ is the $(j, i)$-entry of $A$.

>[!example] Transposing Matrices
>Consider the following matrices:
>
>$$A = \begin{bmatrix} a & b \\ c & d \end{bmatrix}, \quad B = \begin{bmatrix} -5 & 2 \\ 1 & -3 \\ 0 & 4 \end{bmatrix}, \quad C = \begin{bmatrix} 1 & 1 & 1 & 1 \\ -3 & 5 & -2 & 7 \end{bmatrix}$$
>
>Their transposes are obtained by interchanging rows and columns:
>
>$$A^T = \begin{bmatrix} a & c \\ b & d \end{bmatrix}, \quad B^T = \begin{bmatrix} -5 & 1 & 0 \\ 2 & -3 & 4 \end{bmatrix}, \quad C^T = \begin{bmatrix} 1 & -3 \\ 1 & 5 \\ 1 & -2 \\ 1 & 7 \end{bmatrix}$$

>[!summary] Theorem 3: Properties of the Transpose
>Let $A$ and $B$ denote matrices whose sizes are appropriate for the indicated sums and products, and let $r$ be a scalar.
>
>a. $(A^T)^T = A$
>b. $(A + B)^T = A^T + B^T$
>c. $(rA)^T = rA^T$
>d. $(AB)^T = B^T A^T$
>
>**Breakdown**:
>- $A^T$ : The transpose of matrix $A$ (rows and columns reversed).
>- $(A^T)^T$ : The double transpose, which restores the original matrix dimensions and entry positions.
>- $(A + B)^T$ : The transpose of a matrix sum, showing transposition distributes over addition.
>- $r$ : A real scalar; factoring scalars is unaffected by transposition.
>- $(AB)^T = B^T A^T$ : **The Reverse Order Law for Transposition**. Transposing a product reverses the order of the multiplied matrices.
>
>**Proof**:
>Properties (a)–(c) follow directly from the definition by comparing corresponding entries. 
>
>For property (d), let $A$ be an $m \times n$ matrix and $B$ an $n \times p$ matrix. The entry in row $i$ and column $j$ of $(AB)^T$ is the entry in row $j$ and column $i$ of $AB$:
>
>$$((AB)^T)_{ij} = (AB)_{ji} = \sum_{k=1}^n a_{jk}b_{ki}$$
>
>The entry in row $i$ and column $j$ of $B^T A^T$ is the product of row $i$ of $B^T$ (which is column $i$ of $B$) and column $j$ of $A^T$ (which is row $j$ of $A$):
>
>$$(B^T A^T)_{ij} = \sum_{k=1}^n (B^T)_{ik} (A^T)_{kj} = \sum_{k=1}^n b_{ki} a_{jk} = \sum_{k=1}^n a_{jk} b_{ki}$$
>
>Because $((AB)^T)_{ij} = (B^T A^T)_{ij}$ for all indices $i$ and $j$, $(AB)^T = B^T A^T$.

>[!warning] Non-Commutativity of the Transpose Product
>In general, $(AB)^T \neq A^T B^T$. The order of factors **must** be reversed:
>$$(AB)^T = B^T A^T$$
>
>For a product of several matrices, this extends inductively:
>$$(A_1 A_2 \cdots A_k)^T = A_k^T \cdots A_2^T A_1^T$$

---

#### Applications to Pattern Recognition and Data Processing

Matrix transposition and multiplication serve as core components in computational algorithms and data pipelines.
![[Pasted image 20260926131538.png]]
FIGURE 4

>[!example] Pattern Recognition via Quadratic Forms
>A $2 \times 2$ pixel block can be digitized into a $4 \times 1$ vector $\mathbf{x}$ by setting blue pixels to $1$ and white pixels to $0$, stacking the grid column by column.
>
>To detect a specific diagonal checkerboard pattern represented by $\mathbf{v} = \begin{bmatrix} 1 \\ 0 \\ 0 \\ 1 \end{bmatrix}$, consider the matrix:
>
>$$M = \begin{bmatrix} 1 & 0 & 0 & -1 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ -1 & 0 & 0 & 1 \end{bmatrix}$$
>
>Evaluating the product $\mathbf{x}^T M \mathbf{x}$:
>- For the exact target pattern $\mathbf{v}$:
>  $$\mathbf{v}^T M \mathbf{v} = \begin{bmatrix} 1 & 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} 1 & 0 & 0 & -1 \\ 0 & 1 & 0 & 0 \\ 0 & 0 & 1 & 0 \\ -1 & 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} 1 \\ 0 \\ 0 \\ 1 \end{bmatrix} = 0$$
>- For an all-white pattern $\mathbf{w} = \begin{bmatrix} 0 & 0 & 0 & 0 \end{bmatrix}^T$, the product $\mathbf{w}^T M \mathbf{w} = 0$ also.
>- For any non-matching pattern $\mathbf{x}$, the value of $\mathbf{x}^T M \mathbf{x}$ is non-zero.
>
>To isolate the target pattern $\mathbf{v}$ from the trivial blank pattern $\mathbf{w}$, the inner product $\mathbf{x}^T \mathbf{x}$ is checked:
>- $\mathbf{x}^T \mathbf{x} = 0$ if and only if $\mathbf{x} = \mathbf{w}$ (the zero vector).
>
>Therefore, a pattern $\mathbf{x}$ matches the checkerboard pattern if and only if:
>$$\mathbf{x}^T M \mathbf{x} = 0 \quad \text{and} \quad \mathbf{x}^T \mathbf{x} \neq 0$$

![[Pasted image 20260926131604.png]]
FIGURE 5

>[!example] Data Scrubbing via Transformation Matrices
>Two data sets tracking airport incident dates may store information in incompatible row orders:
>
>- Matrix $T$ (Day in Row 1, Month in Row 2):
>  $$T = \begin{bmatrix} 1 & 12 & 14 & 15 & 21 & 22 & 23 & 1 & 2 & 3 & 12 & 15 & 17 & 19 & 26 \\ 1 & 1 & 1 & 1 & 1 & 1 & 1 & 2 & 2 & 2 & 2 & 2 & 2 & 2 & 2 \end{bmatrix}$$
>- Matrix $C$ (Month in Row 1, Day in Row 2):
>  $$C = \begin{bmatrix} 1 & 1 & 1 & 1 & 1 & 2 & 2 & 2 & 2 & 2 \\ 1 & 11 & 22 & 23 & 24 & 1 & 2 & 5 & 20 & 21 \end{bmatrix}$$
>
>To align the data structure of $T$ with $C$, the rows of $T$ must be swapped. Left-multiplying $T$ by the permutation matrix $P = \begin{bmatrix} 0 & 1 \\ 1 & 0 \end{bmatrix}$ swaps row 1 and row 2:
>
>$$PT = \begin{bmatrix} 0 & 1 \\ 1 & 0 \end{bmatrix} \begin{bmatrix} 1 & 12 & 14 & \cdots \\ 1 & 1 & 1 & \cdots \end{bmatrix} = \begin{bmatrix} 1 & 1 & 1 & 1 & 1 & 1 & 1 & 2 & 2 & 2 & 2 & 2 & 2 & 2 & 2 \\ 1 & 12 & 14 & 15 & 21 & 22 & 23 & 1 & 2 & 3 & 12 & 15 & 17 & 19 & 26 \end{bmatrix}$$
>
>The transformed matrix $PT$ now shares the uniform (Month, Day) format of matrix $C$.
### The Inverse of a Matrix

In real number arithmetic, any non-zero scalar $x$ has a multiplicative inverse (reciprocal) $x^{-1} = \frac{1}{x}$ satisfying $x^{-1}x = 1$ and $xx^{-1} = 1$. In matrix algebra, the concept of a multiplicative inverse applies strictly to square matrices, with division replaced by explicit inverse multiplication due to the non-commutative nature of matrix products.

>[!info] Definition: Invertible and Singular Matrices
>An $n \times n$ matrix $A$ is said to be **invertible** (or **nonsingular**) if there exists an $n \times n$ matrix $C$ such that:
>
>$$CA = I_n \quad \text{and} \quad AC = I_n$$
>
>Where $I_n$ is the $n \times n$ identity matrix. 
>
>If such a matrix $C$ exists, it is **uniquely determined** by $A$. If $B$ were another matrix satisfying these conditions:
>
>$$B = B I_n = B(AC) = (BA)C = I_n C = C$$
>
>This unique matrix is called the **inverse** of $A$ and is denoted by $A^{-1}$:
>
>$$A^{-1}A = I_n \quad \text{and} \quad AA^{-1} = I_n$$
>
>A matrix that is not invertible is called a **singular matrix**.

>[!example] Verifying an Inverse Matrix Pair
>Let:
>
>$$A = \begin{bmatrix} 2 & 5 \\ -3 & -7 \end{bmatrix} \quad \text{and} \quad C = \begin{bmatrix} -7 & -5 \\ 3 & 2 \end{bmatrix}$$
>
>Multiplying the matrices confirms they are inverses:
>
>$$AC = \begin{bmatrix} 2 & 5 \\ -3 & -7 \end{bmatrix} \begin{bmatrix} -7 & -5 \\ 3 & 2 \end{bmatrix} = \begin{bmatrix} 2(-7) + 5(3) & 2(-5) + 5(2) \\ -3(-7) - 7(3) & -3(-5) - 7(2) \end{bmatrix} = \begin{bmatrix} 1 & 0 \\ 0 & 1 \end{bmatrix}$$
>
>$$CA = \begin{bmatrix} -7 & -5 \\ 3 & 2 \end{bmatrix} \begin{bmatrix} 2 & 5 \\ -3 & -7 \end{bmatrix} = \begin{bmatrix} -7(2) - 5(-3) & -7(5) - 5(-7) \\ 3(2) + 2(-3) & 3(5) + 2(-7) \end{bmatrix} = \begin{bmatrix} 1 & 0 \\ 0 & 1 \end{bmatrix}$$
>
>Since $AC = I_2$ and $CA = I_2$, $C = A^{-1}$.

---

#### Inverting $2 \times 2$ Matrices

For a $2 \times 2$ matrix, invertibility depends entirely on a scalar quantity called the _determinant_.

>[!summary] Theorem 4: Inverse of a $2 \times 2$ Matrix
>Let $A = \begin{bmatrix} a & b \\ c & d \end{bmatrix}$. 
>
>If $ad - bc \neq 0$, then $A$ is invertible and its inverse is:
>
>$$A^{-1} = \frac{1}{ad - bc} \begin{bmatrix} d & -b \\ -c & a \end{bmatrix}$$
>
>If $ad - bc = 0$, then $A$ is not invertible (singular).
>
>The quantity $ad - bc$ is called the **determinant** of $A$, denoted:
>
>$$\det A = ad - bc$$
>
>**Breakdown:**
>- $A$ : A $2 \times 2$ matrix with entries $a, b, c, d$.
>- $\det A$ : The determinant ($ad - bc$); $A$ is invertible if and only if $\det A \neq 0$.
>- $\begin{bmatrix} d & -b \\ -c & a \end{bmatrix}$ : The adjugate matrix formed by swapping the main diagonal entries ($a$ and $d$) and negating the off-diagonal entries ($b$ and $c$).
>- $\frac{1}{ad - bc}$ : The scalar reciprocal of the determinant.
>
>**Proof**:
>Direct multiplication confirms the formula:
>
>$$A \left( \frac{1}{ad - bc} \begin{bmatrix} d & -b \\ -c & a \end{bmatrix} \right) = \frac{1}{ad - bc} \begin{bmatrix} a & b \\ c & d \end{bmatrix} \begin{bmatrix} d & -b \\ -c & a \end{bmatrix} = \frac{1}{ad - bc} \begin{bmatrix} ad - bc & -ab + ba \\ cd - dc & -cb + da \end{bmatrix}$$
>
>$$= \frac{1}{ad - bc} \begin{bmatrix} ad - bc & 0 \\ 0 & ad - bc \end{bmatrix} = \begin{bmatrix} 1 & 0 \\ 0 & 1 \end{bmatrix} = I_2$$
>
>The same result holds for multiplication on the left. If $ad - bc = 0$, the scalar factor is undefined and no inverse exists.

>[!example] Calculating a $2 \times 2$ Inverse
>Find the inverse of $A = \begin{bmatrix} 3 & 4 \\ 5 & 6 \end{bmatrix}$:
>
>1. Compute the determinant:
>   $$\det A = (3)(6) - (4)(5) = 18 - 20 = -2$$
>2. Since $\det A \neq 0$, apply the inverse formula:
>   $$A^{-1} = \frac{1}{-2} \begin{bmatrix} 6 & -4 \\ -5 & 3 \end{bmatrix} = \begin{bmatrix} -3 & 2 \\ \frac{5}{2} & -\frac{3}{2} \end{bmatrix}$$

---

#### Solving Linear Systems Using Matrix Inverses

When a square coefficient matrix $A$ is invertible, it provides a direct formula for solving the system $A\mathbf{x} = \mathbf{b}$.

>[!summary] Theorem 5: Unique Solution to Linear Systems via Matrix Inverses
>If $A$ is an invertible $n \times n$ matrix, then for each vector $\mathbf{b} \in \mathbb{R}^n$, the system of linear equations $A\mathbf{x} = \mathbf{b}$ has the unique solution:
>
>$$\mathbf{x} = A^{-1}\mathbf{b}$$
>
>**Breakdown:**
>- $A$ : An $n \times n$ invertible coefficient matrix.
>- $\mathbf{b}$ : A known target vector in $\mathbb{R}^n$.
>- $\mathbf{x}$ : The vector of unknowns in $\mathbb{R}^n$.
>- $A^{-1}\mathbf{b}$ : The exact, unique solution vector obtained by left-multiplying $\mathbf{b}$ by $A^{-1}$.
>
>**Proof:**
>1. **Existence:** Substitute $\mathbf{x} = A^{-1}\mathbf{b}$ into the equation $A\mathbf{x}$:
>   $$A(A^{-1}\mathbf{b}) = (A A^{-1})\mathbf{b} = I_n \mathbf{b} = \mathbf{b}$$
>   Thus, $A^{-1}\mathbf{b}$ is a valid solution.
>2. **Uniqueness:** Assume $\mathbf{u}$ is any solution such that $A\mathbf{u} = \mathbf{b}$. Left-multiplying both sides by $A^{-1}$ gives:
>   $$A^{-1}(A\mathbf{u}) = A^{-1}\mathbf{b}$$
>   $$(A^{-1}A)\mathbf{u} = A^{-1}\mathbf{b}$$
>   $$I_n \mathbf{u} = A^{-1}\mathbf{b} \implies \mathbf{u} = A^{-1}\mathbf{b}$$
>   Therefore, $\mathbf{u}$ must equal $A^{-1}\mathbf{b}$, proving uniqueness.

>[!example] Solving a $2 \times 2$ System with an Inverse
>Solve the linear system:
>
>$$\begin{aligned} 3x_1 + 4x_2 &= 3 \\ 5x_1 + 6x_2 &= 7 \end{aligned}$$
>
>In matrix form $A\mathbf{x} = \mathbf{b}$:
>
>$$\begin{bmatrix} 3 & 4 \\ 5 & 6 \end{bmatrix} \begin{bmatrix} x_1 \\ x_2 \end{bmatrix} = \begin{bmatrix} 3 \\ 7 \end{bmatrix}$$
>
>Using $A^{-1} = \begin{bmatrix} -3 & 2 \\ \frac{5}{2} & -\frac{3}{2} \end{bmatrix}$:
>
>$$\mathbf{x} = A^{-1}\mathbf{b} = \begin{bmatrix} -3 & 2 \\ \frac{5}{2} & -\frac{3}{2} \end{bmatrix} \begin{bmatrix} 3 \\ 7 \end{bmatrix} = \begin{bmatrix} (-3)(3) + 2(7) \\ \left(\frac{5}{2}\right)(3) + \left(-\frac{3}{2}\right)(7) \end{bmatrix} = \begin{bmatrix} 5 \\ -3 \end{bmatrix}$$

>[!note] Computational Efficiency
>Calculating $\mathbf{x} = A^{-1}\mathbf{b}$ by explicitly finding $A^{-1}$ is rarely used for large numerical systems because Gaussian row reduction of the augmented matrix $\begin{bmatrix} A & \mathbf{b} \end{bmatrix}$ is faster and less susceptible to round-off error. Explicit inverses are primarily used in theoretical derivations and small ($2 \times 2$) systems.

---

#### Physical Application: Flexibility and Stiffness Matrices

Matrix inverses often represent complementary physical properties in engineering systems.

>[!example] Elastic Beam Deflection (Flexibility vs. Stiffness)
>Consider a horizontal elastic beam supported at each end, subject to external forces applied downward at three specific points.
>
>- Let $\mathbf{f} \in \mathbb{R}^3$ represent the forces applied at points 1, 2, and 3.
>- Let $\mathbf{y} \in \mathbb{R}^3$ represent the resulting downward deflections at these three points.
>
>By Hooke’s Law, the deflection is linearly related to the applied forces by a **flexibility matrix** $D$:
>
>$$\mathbf{y} = D\mathbf{f}$$
>
>Writing $I_3 = \begin{bmatrix} \mathbf{e}_1 & \mathbf{e}_2 & \mathbf{e}_3 \end{bmatrix}$, the columns of $D$ satisfy:
>
>$$D = D I_3 = \begin{bmatrix} D\mathbf{e}_1 & D\mathbf{e}_2 & D\mathbf{e}_3 \end{bmatrix}$$
>
>- **Column $j$ of $D$ ($D\mathbf{e}_j$):** Represents the vector of deflections at all three points caused by applying a single unit downward force at point $j$ (with zero force applied at other points). Measured in units such as inches of deflection per pound of force.
>
>Conversely, the **stiffness matrix** $D^{-1}$ relates deflections back to required forces:
>
>$$\mathbf{f} = D^{-1}\mathbf{y}$$
>
>$$D^{-1} = D^{-1}I_3 = \begin{bmatrix} D^{-1}\mathbf{e}_1 & D^{-1}\mathbf{e}_2 & D^{-1}\mathbf{e}_3 \end{bmatrix}$$
>
>- **Column $j$ of $D^{-1}$ ($D^{-1}\mathbf{e}_j$):** Represents the precise forces that must be applied at all three points to create a unit deflection exclusively at point $j$, while maintaining zero deflection at the other points. Measured in units of pounds of force per inch of deflection.
>  
>  ![[Pasted image 20260926131710.png]]
>  FIGURE 1 Deflection of an elastic beam.

---

#### Algebraic Properties of Invertible Matrices

>[!summary] Theorem 6: Properties of Invertible Matrices
>Let $A$ and $B$ be invertible $n \times n$ matrices.
>
>a. $(A^{-1})^{-1} = A$
>b. $(AB)^{-1} = B^{-1}A^{-1}$ *(The Reverse Order Law for Inverses)*
>c. $(A^T)^{-1} = (A^{-1})^T$
>
>**Breakdown:**
>- $(A^{-1})^{-1}$ : The inverse of an inverse returns the original matrix $A$.
>- $(AB)^{-1} = B^{-1}A^{-1}$ : The inverse of a product is the product of their inverses in **reverse order**.
>- $(A^T)^{-1} = (A^{-1})^T$ : The operations of matrix inversion and matrix transposition commute.
>
>**Proof:**
>- **Proof of (a):** The inverse of $A^{-1}$ must satisfy $A^{-1}C = I$ and $C A^{-1} = I$. Substituting $A$ for $C$ yields $A^{-1}A = I$ and $A A^{-1} = I$. Thus, $(A^{-1})^{-1} = A$.
>- **Proof of (b):** Multiply $(AB)$ by $(B^{-1}A^{-1})$:
>  $$(AB)(B^{-1}A^{-1}) = A(B B^{-1})A^{-1} = A(I_n)A^{-1} = A A^{-1} = I_n$$
>  Similarly:
>  $$(B^{-1}A^{-1})(AB) = B^{-1}(A^{-1}A)B = B^{-1}(I_n)B = B^{-1}B = I_n$$
>  Since $B^{-1}A^{-1}$ acts as the two-sided multiplicative inverse to $AB$, $(AB)^{-1} = B^{-1}A^{-1}$.
>- **Proof of (c):** Using the product property of transposes $((XY)^T = Y^T X^T)$:
>  $$(A^{-1})^T A^T = (A A^{-1})^T = I_n^T = I_n$$
>  $$A^T (A^{-1})^T = (A^{-1}A)^T = I_n^T = I_n$$
>  Therefore, $(A^T)^{-1} = (A^{-1})^T$.

>[!warning] Generalization: Reverse Order Inversion
>The reverse order law extends to any finite product of invertible matrices:
>
>$$(A_1 A_2 \cdots A_k)^{-1} = A_k^{-1} \cdots A_2^{-1} A_1^{-1}$$
>
>The inverse of a sequence of operations undoes each operation in reverse order.
### Elementary Matrices

>[!info] Definition: Elementary Matrix
>An **elementary matrix** is a square matrix obtained by performing a single elementary row operation on an identity matrix $I$.
>
>The three types of elementary row operations correspond to three types of elementary matrices:
>1. **Row Replacement:** Adding a scalar multiple of one row to another row.
>2. **Row Interchange:** Swapping the positions of two rows.
>3. **Row Scaling:** Multiplying all entries in a row by a non-zero scalar.

>[!example] Elementary Matrices and Row Operations
>Consider the following elementary matrices derived from the $3 \times 3$ identity matrix $I_3$, and an arbitrary $3 \times 3$ matrix $A$:
>
>$$E_1 = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ -4 & 0 & 1 \end{bmatrix}, \quad E_2 = \begin{bmatrix} 0 & 1 & 0 \\ 1 & 0 & 0 \\ 0 & 0 & 1 \end{bmatrix}, \quad E_3 = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 5 \end{bmatrix}, \quad A = \begin{bmatrix} a & b & c \\ d & e & f \\ g & h & i \end{bmatrix}$$
>
>Left-multiplying $A$ by each elementary matrix performs the corresponding row operation on $A$:
>
>- **Row Replacement ($E_1 A$):** Adds $-4$ times row 1 to row 3:
>  $$E_1 A = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ -4 & 0 & 1 \end{bmatrix} \begin{bmatrix} a & b & c \\ d & e & f \\ g & h & i \end{bmatrix} = \begin{bmatrix} a & b & c \\ d & e & f \\ g - 4a & h - 4b & i - 4c \end{bmatrix}$$
>
>- **Row Interchange ($E_2 A$):** Swaps row 1 and row 2:
>  $$E_2 A = \begin{bmatrix} 0 & 1 & 0 \\ 1 & 0 & 0 \\ 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} a & b & c \\ d & e & f \\ g & h & i \end{bmatrix} = \begin{bmatrix} d & e & f \\ a & b & c \\ g & h & i \end{bmatrix}$$
>
>- **Row Scaling ($E_3 A$):** Multiplies row 3 by $5$:
>  $$E_3 A = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 5 \end{bmatrix} \begin{bmatrix} a & b & c \\ d & e & f \\ g & h & i \end{bmatrix} = \begin{bmatrix} a & b & c \\ d & e & f \\ 5g & 5h & 5i \end{bmatrix}$$

Left-multiplying any $m \times n$ matrix $A$ by an $m \times m$ elementary matrix $E$ executes that specific row operation on $A$. Since $E \cdot I_m = E$, the matrix $E$ itself is generated by applying the identical row operation to the identity matrix $I_m$.

$$\text{Row Operation on } A = E A$$

---

#### Invertibility of Elementary Matrices

Because every elementary row operation is reversible, every elementary matrix $E$ is invertible. 

If an operation transforms $I$ into $E$, there exists a reverse operation of the same type that transforms $E$ back into $I$. The elementary matrix $F$ corresponding to this reverse operation satisfies:

$$F E = I \quad \text{and} \quad E F = I$$

Thus, the inverse of an elementary matrix $E^{-1}$ is the elementary matrix of the same type that reverses the row operation.

>[!example] Inverting an Elementary Matrix
>To invert the row replacement matrix:
>
>$$E_1 = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ -4 & 0 & 1 \end{bmatrix}$$
>
>The operation used to create $E_1$ was adding $-4$ times row 1 to row 3. The reverse operation adds $+4$ times row 1 to row 3. 
>
>Applying this reverse operation to $I_3$ yields the inverse:
>
>$$E_1^{-1} = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 4 & 0 & 1 \end{bmatrix}$$

---

#### Row Equivalence and Matrix Inversion

>[!summary] Theorem 7: Characterization of Invertible Matrices via Row Reduction
>An $n \times n$ matrix $A$ is invertible if and only if $A$ is row equivalent to $I_n$ ($A \sim I_n$).
>
>In this case, any sequence of elementary row operations that reduces $A$ to $I_n$ also transforms $I_n$ into $A^{-1}$.
>
>**Breakdown**:
>- $A$ : An $n \times n$ square matrix.
>- $I_n$ : The $n \times n$ identity matrix.
>- $A \sim I_n$ : Denotes that $A$ is row equivalent to $I_n$, meaning $A$ can be transformed into $I_n$ through a finite sequence of elementary row operations.
>- $E_1, E_2, \dots, E_p$ : The sequence of elementary matrices corresponding to the row operations that reduce $A$ to $I_n$.
>- $A^{-1} = E_p \cdots E_2 E_1$ : The inverse matrix resulting from applying the exact same sequence of row operations to $I_n$.
>
>**Proof**:
>1. **Forward Direction ($\implies$):** Suppose $A$ is invertible. For every vector $\mathbf{b} \in \mathbb{R}^n$, the linear system $A\mathbf{x} = \mathbf{b}$ has a unique solution $\mathbf{x} = A^{-1}\mathbf{b}$. This requires $A$ to have a pivot position in every row and column. Because $A$ is an $n \times n$ square matrix, all $n$ pivots must lie on the main diagonal. Therefore, the reduced echelon form of $A$ is $I_n$, which proves $A \sim I_n$.
>
>2. **Converse Direction ($\impliedby$):** Suppose $A \sim I_n$. Each step in the row reduction of $A$ corresponds to left-multiplication by an elementary matrix. Thus, there exist elementary matrices $E_1, E_2, \dots, E_p$ such that:
>   $$E_p \cdots E_2 E_1 A = I_n$$
>
>   Let $M = E_p \cdots E_2 E_1$. Since the product of invertible matrices is invertible, $M$ is invertible. Multiplying both sides on the left by $M^{-1}$:
>   $$M^{-1}(M A) = M^{-1} I_n$$
>   $$A = M^{-1}$$
>
>   Since $A$ is the inverse of an invertible matrix ($M$), $A$ is itself invertible, and:
>   $$A^{-1} = (M^{-1})^{-1} = M = E_p \cdots E_2 E_1$$
>
>   Writing this in terms of the identity matrix:
>   $$A^{-1} = E_p \cdots E_2 E_1 I_n$$
>
>   This shows that the same sequence of elementary row operations ($E_1, \dots, E_p$) that reduces $A$ to $I_n$ simultaneously transforms $I_n$ into $A^{-1}$.
### An Algorithm for Finding $A^{-1}$

Placing an $n \times n$ matrix $A$ and the $n \times n$ identity matrix $I_n$ side by side forms the augmented matrix $\begin{bmatrix} A & I_n \end{bmatrix}$. Applying elementary row operations to this augmented matrix executes the operations simultaneously on $A$ and on $I_n$. 

Because row reducing $A$ to $I_n$ corresponds to left-multiplying by a sequence of elementary matrices $E_p \cdots E_1$, applying the exact same sequence to $I_n$ yields $A^{-1}$.

>[!info] Matrix Inversion Algorithm
>To find the inverse of an $n \times n$ matrix $A$:
>1. Construct the augmented matrix $\begin{bmatrix} A & I_n \end{bmatrix}$.
>2. Row reduce $\begin{bmatrix} A & I_n \end{bmatrix}$ to reduced row echelon form.
>3. If $A$ is row equivalent to $I_n$, then:
>   $$\begin{bmatrix} A & I_n \end{bmatrix} \sim \begin{bmatrix} I_n & A^{-1} \end{bmatrix}$$
>   The matrix in the right partition is $A^{-1}$.
>4. If $A$ cannot be reduced to $I_n$ (meaning $A$ has fewer than $n$ pivot positions), then $A$ is **singular** and has no inverse.

>[!example] Inverting a $3 \times 3$ Matrix via Row Reduction
>Find the inverse of the matrix $A$, if it exists:
>
>$$A = \begin{bmatrix} 0 & 1 & 2 \\ 1 & 0 & 3 \\ 4 & -3 & 8 \end{bmatrix}$$
>
>**Step 1: Set up the augmented matrix $\begin{bmatrix} A & I_3 \end{bmatrix}$:**
>
>$$\begin{bmatrix} A & I_3 \end{bmatrix} = \begin{bmatrix} 0 & 1 & 2 & 1 & 0 & 0 \\ 1 & 0 & 3 & 0 & 1 & 0 \\ 4 & -3 & 8 & 0 & 0 & 1 \end{bmatrix}$$
>
>**Step 2: Swap Row 1 and Row 2 to place a pivot in the top-left entry ($R_1 \leftrightarrow R_2$):**
>
>$$\sim \begin{bmatrix} 1 & 0 & 3 & 0 & 1 & 0 \\ 0 & 1 & 2 & 1 & 0 & 0 \\ 4 & -3 & 8 & 0 & 0 & 1 \end{bmatrix}$$
>
>**Step 3: Eliminate the first entry of Row 3 ($R_3 - 4R_1 \to R_3$):**
>
>$$\sim \begin{bmatrix} 1 & 0 & 3 & 0 & 1 & 0 \\ 0 & 1 & 2 & 1 & 0 & 0 \\ 0 & -3 & -4 & 0 & -4 & 1 \end{bmatrix}$$
>
>**Step 4: Eliminate the second entry of Row 3 ($R_3 + 3R_2 \to R_3$):**
>
>$$\sim \begin{bmatrix} 1 & 0 & 3 & 0 & 1 & 0 \\ 0 & 1 & 2 & 1 & 0 & 0 \\ 0 & 0 & 2 & 3 & -4 & 1 \end{bmatrix}$$
>
>**Step 5: Scale Row 3 to create a leading 1 ($\frac{1}{2}R_3 \to R_3$):**
>
>$$\sim \begin{bmatrix} 1 & 0 & 3 & 0 & 1 & 0 \\ 0 & 1 & 2 & 1 & 0 & 0 \\ 0 & 0 & 1 & \frac{3}{2} & -2 & \frac{1}{2} \end{bmatrix}$$
>
>**Step 6: Clear entries above the third pivot ($R_1 - 3R_3 \to R_1$ and $R_2 - 2R_3 \to R_2$):**
>
>$$\sim \begin{bmatrix} 1 & 0 & 0 & -\frac{9}{2} & 7 & -\frac{3}{2} \\ 0 & 1 & 0 & -2 & 4 & -1 \\ 0 & 0 & 1 & \frac{3}{2} & -2 & \frac{1}{2} \end{bmatrix}$$
>
>Because $A \sim I_3$, the matrix $A$ is invertible and its inverse is:
>
>$$A^{-1} = \begin{bmatrix} -\frac{9}{2} & 7 & -\frac{3}{2} \\ -2 & 4 & -1 \\ \frac{3}{2} & -2 & \frac{1}{2} \end{bmatrix}$$

>[!tip] Verifying an Computed Inverse
>To confirm that an inverse calculation is correct, compute the product $AA^{-1}$:
>
>$$AA^{-1} = \begin{bmatrix} 0 & 1 & 2 \\ 1 & 0 & 3 \\ 4 & -3 & 8 \end{bmatrix} \begin{bmatrix} -\frac{9}{2} & 7 & -\frac{3}{2} \\ -2 & 4 & -1 \\ \frac{3}{2} & -2 & \frac{1}{2} \end{bmatrix} = \begin{bmatrix} 1 & 0 & 0 \\ 0 & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix} = I_3$$
>
>For square matrices, verifying that $AA^{-1} = I$ automatically guarantees that $A^{-1}A = I$ as well.
### Another View of Matrix Inversion

Let the columns of the $n \times n$ identity matrix $I_n$ be denoted by the standard basis vectors $\mathbf{e}_1, \mathbf{e}_2, \dots, \mathbf{e}_n$. The augmented matrix used in the matrix inversion algorithm can be expressed in terms of these individual columns:

$$\begin{bmatrix} A & I_n \end{bmatrix} = \begin{bmatrix} A & \mathbf{e}_1 & \mathbf{e}_2 & \cdots & \mathbf{e}_n \end{bmatrix}$$

Row reducing $\begin{bmatrix} A & I_n \end{bmatrix}$ to $\begin{bmatrix} I_n & A^{-1} \end{bmatrix}$ is equivalent to simultaneously solving $n$ distinct linear systems:

$$A\mathbf{x} = \mathbf{e}_1, \quad A\mathbf{x} = \mathbf{e}_2, \quad \dots, \quad A\mathbf{x} = \mathbf{e}_n$$

By the definition of matrix multiplication, if $A^{-1}$ is partitioned into its columns $\begin{bmatrix} \mathbf{x}_1 & \mathbf{x}_2 & \cdots & \mathbf{x}_n \end{bmatrix}$, the relation $A A^{-1} = I_n$ becomes:

$$A \begin{bmatrix} \mathbf{x}_1 & \mathbf{x}_2 & \cdots & \mathbf{x}_n \end{bmatrix} = \begin{bmatrix} A\mathbf{x}_1 & A\mathbf{x}_2 & \cdots & A\mathbf{x}_n \end{bmatrix} = \begin{bmatrix} \mathbf{e}_1 & \mathbf{e}_2 & \cdots & \mathbf{e}_n \end{bmatrix}$$

**Breakdown:**
- $A$ : The $n \times n$ invertible coefficient matrix.
- $\mathbf{e}_j$ : The $j\text{th}$ column of the identity matrix $I_n$ (a unit vector with a $1$ in the $j\text{th}$ position and $0$ elsewhere).
- $\mathbf{x}_j$ : The $j\text{th}$ column vector of $A^{-1}$, which satisfies the equation $A\mathbf{x}_j = \mathbf{e}_j$.

>[!tip] Computing Individual Columns of an Inverse
>When an application requires only one or two columns of $A^{-1}$ rather than the entire matrix, it is not necessary to invert $A$ completely. Instead, solve only the specific linear systems $A\mathbf{x} = \mathbf{e}_j$ corresponding to the required column indices $j$.

>[!note] Computational Efficiency and Numerical Inversion
>In practical computing, explicit matrix inverses are rarely calculated unless the actual entries of $A^{-1}$ are strictly needed. 
>
>Solving a linear system $A\mathbf{x} = \mathbf{b}$ by first computing $A^{-1}$ and then evaluating the product $A^{-1}\mathbf{b}$ requires approximately **three times as many arithmetic operations** as solving the system directly via Gaussian row reduction (or matrix factorizations), while also being more susceptible to round-off errors.
