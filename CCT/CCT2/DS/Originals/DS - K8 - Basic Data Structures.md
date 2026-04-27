---
tags:
  - "#CCT2"
  - DS
Topic: "Dynamic set | Basic data structures including: arrays, lists, stacks, queues, and linked list | Rooted Trees and heaps | Dictionary"
Semester: CCT2
Course: Diskrete strukturer
Litterature:
  - Introduction to Algorithms 4th ed.
Created: 26-04-2026
---
- - -
# Table of Contents

1. [[#Elementary Data Structures|Elementary Data Structures]]
	1. [[#Elementary Data Structures#Simple array-based data structures: arrays, matrices, stacks, queues|Simple array-based data structures: arrays, matrices, stacks, queues]]
		1. [[#Simple array-based data structures: arrays, matrices, stacks, queues#Arrays|Arrays]]
		2. [[#Simple array-based data structures: arrays, matrices, stacks, queues#Matrices|Matrices]]
			1. [[#Matrices#Single-Array Representation|Single-Array Representation]]
			2. [[#Matrices#Multiple-Array Representation|Multiple-Array Representation]]
			3. [[#Matrices#Block Representation|Block Representation]]
		3. [[#Simple array-based data structures: arrays, matrices, stacks, queues#Stacks and Queues|Stacks and Queues]]
			1. [[#Stacks and Queues#Stacks|Stacks]]
			2. [[#Stacks and Queues#Queues|Queues]]
	2. [[#Elementary Data Structures#Linked lists|Linked lists]]
			1. [[#Stacks and Queues#Searching a linked list|Searching a linked list]]
			2. [[#Stacks and Queues#Inserting into a linked list|Inserting into a linked list]]
			3. [[#Stacks and Queues#Deleting from a linked list|Deleting from a linked list]]
			4. [[#Stacks and Queues#Sentinels|Sentinels]]
	3. [[#Elementary Data Structures#Representing rooted trees|Representing rooted trees]]
		1. [[#Representing rooted trees#Binary trees|Binary trees]]
		2. [[#Representing rooted trees#Rooted trees with unbounded branching|Rooted trees with unbounded branching]]
		3. [[#Representing rooted trees#Other tree representations|Other tree representations]]

# Elementary Data Structures
## Simple array-based data structures: arrays, matrices, stacks, queues 
### Arrays

An array is stored as a *contiguous sequence of bytes* in memory. Because of this layout, any element can be accessed in *constant time*, regardless of its index — assuming all memory locations take equally long to access.

If an array starts at memory address $a$, each element occupies $b$ bytes, and indexing begins at $s$, then the $i$-th element occupies bytes:

$$a + b(i - s) \quad \text{through} \quad a + b(i - s + 1) - 1$$

This simplifies depending on the starting index:
- **1-based indexing** ($s = 1$): bytes $a + b(i-1)$ through $a + bi - 1$
- **0-based indexing** ($s = 0$): bytes $a + bi$ through $a + b(i+1) - 1$

> [!info] Breakdown of the Address Formula
> - **Equation:** $a + b(i - s)$
> - **Breakdown:**
>     - **$a$** : The base memory address — where the array begins in memory.
>     - **$b$** : The size (in bytes) of a single array element.
>     - **$i$** : The index of the element you want to access.
>     - **$s$** : The starting index of the array (e.g., $0$ or $1$).
>     - **$i - s$** : The *offset* — how many elements away from the start the target element is.

Most programming languages require every element in a given array to be the *same size*. This is what keeps $b$ constant and makes the formula valid. 

> [!warning] Variable-Size Elements
> If array elements can vary in size, $b$ is no longer constant and the formula breaks down. In this case, each array slot typically stores a *pointer* to the actual object rather than the object itself. Since pointers are a fixed size regardless of what they point to, the formula still applies — but it now gives you the address of the *pointer*, which must then be *followed* to reach the actual data.

![[Pasted image 20260427081507.png]]  
_Figure 1.1 — Four storage strategies for a 2×32×3 matrix. (a) Single array, row-major order. (b) Single array, column-major order. (c) Row-major with one array per row and a pointer array. (d) Column-major with one array per column and a pointer array._
### Matrices

A matrix (or two-dimensional array) is typically represented using one or more one-dimensional arrays. The two most common storage strategies are *row-major order* and *column-major order*.

For an $m \times n$ matrix — one with $m$ rows and $n$ columns:
- **Row-major order** stores the matrix *row by row*
- **Column-major order** stores the matrix *column by column*

For example, given the matrix:

$$\begin{pmatrix} 1 & 2 & 3 \\ 4 & 5 & 6 \end{pmatrix}$$

Row-major order stores it as: $\langle 1, 2, 3, 4, 5, 6 \rangle$
Column-major order stores it as: $\langle 1, 4, 2, 5, 3, 6 \rangle$

#### Single-Array Representation

When using a single flat array, the element $M[i, j]$ (row $i$, column $j$) is located at the following index, where $s$ is the starting index:

| Order | General ($s$) | 1-based ($s=1$) | 0-based ($s=0$) |
|---|---|---|---|
| Row-major | $s + n(i - s) + (j - s)$ | $n(i-1) + j$ | $ni + j$ |
| Column-major | $s + m(j - s) + (i - s)$ | $i + m(j-1)$ | $i + mj$ |

> [!info] Breakdown of Index Formulas
> - **$i$** : The row index of the target element.
> - **$j$** : The column index of the target element.
> - **$s$** : The starting index of the array and matrix (e.g., $0$ or $1$).
> - **$m$** : The total number of rows in the matrix.
> - **$n$** : The total number of columns in the matrix.
> - **$n(i - s)$** *(row-major)*: Skips over $(i - s)$ complete rows, each of length $n$, to reach the correct row.
> - **$m(j - s)$** *(column-major)*: Skips over $(j - s)$ complete columns, each of length $m$, to reach the correct column.

> [!example] Index Lookup for $M[2,1]$ in the $2 \times 3$ example (1-based)
> - **Row-major:** $n(i - 1) + j = 3(2-1) + 1 = 4$
> - **Column-major:** $i + m(j - 1) = 2 + 2(1-1) = 2$

#### Multiple-Array Representation

Instead of one flat array, a matrix can be stored using multiple arrays:

- **Row-major version:** Each row gets its own array of length $n$. A separate *pointer array* $A$ of length $m$ holds references to each row array. The element $M[i,j]$ is accessed as `A[i][j]`.
- **Column-major version:** Each column gets its own array of length $m$, and a pointer array of length $n$ references each column. The element $M[i,j]$ is accessed as `A[j][i]`.

Single-array representations are generally *more efficient* on modern hardware. However, multiple-array representations offer more *flexibility* — for example, they allow for *ragged arrays*, where rows (or columns) can have different lengths.

#### Block Representation

Another less common scheme is the *block representation*, where the matrix is divided into sub-blocks and each block is stored contiguously. For example, a $4 \times 4$ matrix divided into $2 \times 2$ blocks:

$$\left(\begin{array}{cc|cc} 1 & 2 & 3 & 4 \\ 5 & 6 & 7 & 8 \\ \hline 9 & 10 & 11 & 12 \\ 13 & 14 & 15 & 16 \end{array}\right)$$

Would be stored as: $\langle 1, 2, 5, 6,\ 3, 4, 7, 8,\ 9, 10, 13, 14,\ 11, 12, 15, 16 \rangle$

Each $2 \times 2$ block is laid out contiguously before moving to the next.
### Stacks and Queues

*Stacks* and *queues* are dynamic sets where the element removed by a delete operation is determined by a fixed policy — not by the caller's choice.

- A **stack** uses a *Last-In, First-Out* (**LIFO**) policy — the most recently inserted element is the first to be removed.
- A **queue** uses a *First-In, First-Out* (**FIFO**) policy — the element that has been waiting the longest is the first to be removed.

Both can be efficiently implemented using an array with a few tracking attributes.

#### Stacks

The insert operation on a stack is called **PUSH**, and the delete operation is called **POP** — named after physical stacks (like a spring-loaded stack of plates) where only the top item is accessible, meaning items come off in the reverse order they were put on.

A stack of at most $n$ elements can be implemented with an array $S[1:n]$ and two attributes:
- `S.top` — the index of the most recently inserted element
- `S.size` — the total capacity $n$ of the array

The active elements of the stack are $S[1 : S.\text{top}]$, where $S[1]$ is the *bottom* and $S[S.\text{top}]$ is the *top*.

![[Pasted image 20260427082844.png]]
*Figure 1.2 — Array implementation of a stack. (a) Stack with 4 elements, top is 9. (b) After PUSH(S, 17) and PUSH(S, 3). (c) After POP(S) returns 3; top is now 17.*

> [!warning] Overflow and Underflow
> - When `S.top = 0`, the stack is **empty**. Attempting to pop from an empty stack causes **underflow** — an error.
> - When `S.top` exceeds `S.size`, the stack is **full**. Attempting to push causes **overflow** — also an error.

All three stack operations run in $O(1)$ time:

```
STACK-EMPTY(S)
1  if S.top == 0
2      return TRUE
3  else return FALSE

PUSH(S, x)
1  if S.top == S.size
2      error "overflow"
3  else S.top = S.top + 1
4       S[S.top] = x

POP(S)
1  if STACK-EMPTY(S)
2      error "underflow"
3  else S.top = S.top - 1
4       return S[S.top + 1]   // the element just above the new top
```

#### Queues

The insert operation on a queue is called **ENQUEUE**, and the delete operation is called **DEQUEUE**. Like a line of customers waiting for service, new elements join at the *tail* and leave from the *head*.

A queue of at most $n - 1$ elements can be implemented with an array $Q[1:n]$ and three attributes:
- `Q.head` — index of the front element (the next to be removed)
- `Q.tail` — index of the next *empty* slot where a new element will be inserted
- `Q.size` — the total capacity $n$ of the array

The active elements occupy positions $Q.\text{head},\ Q.\text{head}+1,\ \ldots,\ Q.\text{tail}-1$. The array is treated as *circular* — position 1 immediately follows position $n$, allowing the queue to wrap around.

> [!info] Queue State Conditions
> - **Empty:** `Q.head = Q.tail` (initially both set to 1)
> - **Full:** `Q.head = Q.tail + 1`, or `Q.head = 1` and `Q.tail = Q.size`
> - Attempting to dequeue when empty causes **underflow**; attempting to enqueue when full causes **overflow**.

![[Pasted image 20260427082959.png]]
*Figure 1.3 — Array implementation of a queue using Q[1:12]. (a) Queue with 5 elements at Q[7:11]. (b) After ENQUEUE(Q, 17), ENQUEUE(Q, 3), ENQUEUE(Q, 5). (c) After DEQUEUE(Q) removes 15 from the head; new head is 6.*

Both queue operations run in $O(1)$ time:

```
ENQUEUE(Q, x)
1  Q[Q.tail] = x
2  if Q.tail == Q.size    // if at the last slot, wrap around
3      Q.tail = 1
4  else Q.tail = Q.tail + 1

DEQUEUE(Q)
1  x = Q[Q.head]
2  if Q.head == Q.size    // if at the last slot, wrap around
3      Q.head = 1
4  else Q.head = Q.head + 1
5  return x
```
## Linked lists

A *linked list* is a data structure where objects are arranged in a linear order — but unlike an array, this order is determined by *pointers* embedded in each object rather than by index positions. Because linked list elements often contain searchable keys, they are sometimes called *search lists*. Linked lists provide a simple and flexible representation for dynamic sets.

Each element of a *doubly linked list* $L$ is an object with a `key` attribute and two pointer attributes: `next` and `prev`. Given an element $x$:
- `x.next` points to its *successor*
- `x.prev` points to its *predecessor*
- If `x.prev = NIL`, then $x$ is the *head* (first element)
- If `x.next = NIL`, then $x$ is the *tail* (last element)

The list itself has an attribute `L.head` pointing to the first element. If `L.head = NIL`, the list is *empty*.

![[Pasted image 20260427083325.png]]
*Figure 1.4 — (a) A doubly linked list representing {1, 4, 9, 16}. (b) After LIST-PREPEND with key 25 — 25 becomes the new head. (c) After LIST-INSERT(x, y) with key 36, inserted after the element with key 9. (d) After LIST-DELETE removes the element with key 4.*

Linked lists come in several forms:
- **Singly linked** — each element has only a `next` pointer, no `prev`
- **Doubly linked** — each element has both `next` and `prev`
- **Sorted** — elements are arranged in key order; the minimum is at the head and maximum at the tail
- **Unsorted** — elements can appear in any order
- **Circular** — the `prev` of the head points to the tail, and the `next` of the tail points to the head, forming a ring

The remainder of this section assumes lists are *unsorted* and *doubly linked*.

#### Searching a linked list

`LIST-SEARCH(L, k)` finds the first element with key $k$ by walking through the list from the head, returning a pointer to the matching element, or `NIL` if not found. In the worst case — when the key is absent or at the tail — the entire list must be traversed, giving a worst-case running time of $\Theta(n)$.

```
LIST-SEARCH(L, k)
1  x = L.head
2  while x ≠ NIL and x.key ≠ k
3      x = x.next        // advance to next element
4  return x               // returns NIL if key not found
```

#### Inserting into a linked list

Given an element $x$ with its `key` already set, `LIST-PREPEND` inserts $x$ at the *front* of the list in $O(1)$ time.

```
LIST-PREPEND(L, x)
1  x.next = L.head        // x points forward to old head
2  x.prev = NIL           // x has no predecessor
3  if L.head ≠ NIL
4      L.head.prev = x    // old head points back to x
5  L.head = x             // x is now the head
```

To insert *anywhere* in the list, `LIST-INSERT` splices a new element $x$ immediately *after* a given element $y$, in $O(1)$ time. Because it never needs to reference the list object $L$ itself, $L$ is not a parameter.

```
LIST-INSERT(x, y)
1  x.next = y.next        // x points forward to y's old successor
2  x.prev = y             // x points back to y
3  if y.next ≠ NIL
4      y.next.prev = x    // y's old successor points back to x
5  y.next = x             // y now points forward to x
```

#### Deleting from a linked list

`LIST-DELETE` removes an element $x$ from list $L$ by relinking the surrounding elements around it. A pointer to $x$ must be provided — if you only know the key, a prior call to `LIST-SEARCH` is needed, making the worst-case time $\Theta(n)$. The deletion itself runs in $O(1)$.

```
LIST-DELETE(L, x)
1  if x.prev ≠ NIL
2      x.prev.next = x.next    // predecessor skips over x
3  else L.head = x.next        // x was the head; update L.head
4  if x.next ≠ NIL
5      x.next.prev = x.prev    // successor points back past x
```

> [!info] Linked Lists vs. Arrays: Insertion, Deletion, and Access
> 
> | Operation | Array | Doubly Linked List |
> |---|---|---|
> | Insert/Delete at front | $\Theta(n)$ — must shift all elements | $O(1)$ — pointer relinking only |
> | Find $k$th element | $O(1)$ — direct index access | $\Theta(k)$ — must traverse $k$ nodes |
> 
> Linked lists excel at insertion and deletion; arrays excel at random access by position.

#### Sentinels

The boundary checks in `LIST-DELETE` — handling the special cases of deleting the head or tail — add complexity. A *sentinel* eliminates these edge cases.

A sentinel is a *dummy object* `L.nil` that acts as a stand-in for `NIL` but has all the same attributes as a regular list element. Replacing all `NIL` references with `L.nil` transforms the list into a *circular, doubly linked list with a sentinel*, where `L.nil` sits between the head and tail:
- `L.nil.next` points to the head
- `L.nil.prev` points to the tail
- The `next` of the tail and `prev` of the head both point to `L.nil`

Because `L.nil.next` serves as the head reference, `L.head` is eliminated entirely. An empty list has both `L.nil.next` and `L.nil.prev` pointing to `L.nil` itself.

![[Pasted image 20260427083544.png]]
*Figure 1.5 — Circular doubly linked list with sentinel L.nil (blue). (a) Empty list — both pointers on L.nil point to itself. (b) List {9, 16, 4, 1} with sentinel. (c) After LIST-INSERT′(x, L.nil) with key 25 — 25 becomes the new head. (d) After deleting key 1 — new tail is key 4. (e) After LIST-INSERT′(x, y) with key 36, inserted after key 9.*

With a sentinel, deletion requires only two lines — no boundary checks needed:

```
LIST-DELETE′(x)
1  x.prev.next = x.next    // predecessor skips over x
2  x.next.prev = x.prev    // successor points back past x
```

> [!warning] Never Delete the Sentinel
> Do not delete `L.nil` unless you intend to destroy the entire list. It is what holds the circular structure together.

Insertion with a sentinel uses `LIST-INSERT′`, which inserts $x$ after a given object $y$. This single procedure covers all cases — prepending is done by passing `y = L.nil`, and appending by passing `y = L.nil.prev`:

```
LIST-INSERT′(x, y)
1  x.next = y.next         // x points forward to y's old successor
2  x.prev = y              // x points back to y
3  y.next.prev = x         // y's old successor points back to x
4  y.next = x              // y now points forward to x
```

Searching a sentinel list can also be made slightly faster. The standard `LIST-SEARCH` performs two checks per iteration: one to detect the end of the list, and one to compare the key. With a sentinel, you can *store the search key in `L.nil` before starting* — this guarantees the key will be found somewhere in the list, eliminating the end-of-list check:

```
LIST-SEARCH′(L, k)
1  L.nil.key = k           // plant the key in sentinel as a guaranteed stop
2  x = L.nil.next          // start at the head
3  while x.key ≠ k
4      x = x.next
5  if x == L.nil           // stopped at sentinel — key wasn't really in the list
6      return NIL
7  else return x           // stopped at a real element
```

> [!tip] When to Use Sentinels
> Sentinels can simplify code and shave small constant factors from running times, but they don't change asymptotic complexity. Use them judiciously — when many small lists are in use, the extra memory for each sentinel can add up to significant waste.
## Representing rooted trees

Linked lists represent linear relationships well, but tree structures require a different approach. Each node in a tree is represented as an object with a `key` attribute and a set of pointer attributes — the specific pointers used depend on the type of tree.

### Binary trees

In a *binary tree* $T$, each node $x$ has three pointer attributes:
- `x.p` — points to the *parent* of $x$
- `x.left` — points to the *left child* of $x$
- `x.right` — points to the *right child* of $x$

If `x.p = NIL`, then $x$ is the *root*. If a child does not exist, the corresponding pointer is `NIL`. The attribute `T.root` points to the root of the entire tree. If `T.root = NIL`, the tree is empty.

![[Pasted image 20260427083808.png]]
*Figure 1.6 — Binary tree representation. Each node x has attributes x.p (top), x.left (lower left), and x.right (lower right).*

### Rooted trees with unbounded branching

For trees where each node has at most $k$ children, the binary tree scheme extends naturally — replace `left` and `right` with `child1, child2, …, childk`. However, this breaks down when the number of children is *unbounded*, since:
- The number of pointer attributes cannot be determined in advance
- If $k$ is large but most nodes have few children, a significant amount of memory is wasted

The solution is the ***left-child, right-sibling* representation**, which can represent any rooted tree using only $O(n)$ space for an $n$-node tree. Each node $x$ has just two pointers instead of one per child:

1. `x.left-child` — points to the *leftmost child* of $x$
2. `x.right-sibling` — points to the sibling of $x$ *immediately to its right*

As before, `x.p` points to the parent and `T.root` points to the root. If $x$ has no children, `x.left-child = NIL`. If $x$ is the rightmost child of its parent, `x.right-sibling = NIL`.

![[Pasted image 20260427083836.png]]
*Figure 1.7 — Left-child, right-sibling representation. Each node x has attributes x.p (top), x.left-child (lower left), and x.right-sibling (lower right).*

### Other tree representations

Trees can be represented in many other ways depending on the needs of the application. A *heap*, for example, is a complete binary tree stored entirely in a single array with an attribute tracking the index of the last node — no pointers needed. Some tree structures only require traversal *toward the root*, so only `parent` pointers are stored with no child pointers at all. The right representation depends entirely on what operations the application needs to perform efficiently.