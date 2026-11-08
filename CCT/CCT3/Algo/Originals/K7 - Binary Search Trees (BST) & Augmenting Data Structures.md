---
tags:
  - CCT3
  - Algoritmer
Topic: BST, Augmenting Data Structures, Dynamic order statistics, Interval trees
Semester: CCT3
Course: Algoritmer
Litterature:
  - Introduction to Algorithms 4th ed.
Created: 08-11-2026
---
## Table of Contents

1. [[#12 Binary Search Trees|12 Binary Search Trees]]
2. [[#12.1 What is a binary search tree?|12.1 What is a binary search tree?]]
	1. [[#12.1 What is a binary search tree?#Inorder Tree Walk|Inorder Tree Walk]]
3. [[#12.2 Querying a binary search tree|12.2 Querying a binary search tree]]
	1. [[#12.2 Querying a binary search tree#Searching|Searching]]
	2. [[#12.2 Querying a binary search tree#Minimum and maximum|Minimum and maximum]]
	3. [[#12.2 Querying a binary search tree#Successor and predecessor|Successor and predecessor]]
4. [[#12.3 Insertion and deletion|12.3 Insertion and deletion]]
	1. [[#12.3 Insertion and deletion#Insertion|Insertion]]
	2. [[#12.3 Insertion and deletion#Deletion|Deletion]]
		1. [[#Deletion#The TRANSPLANT Subroutine|The TRANSPLANT Subroutine]]
		2. [[#Deletion#The TREE-DELETE Procedure|The TREE-DELETE Procedure]]
5. [[#17 Augmenting Data Structures|17 Augmenting Data Structures]]
6. [[#17.1 Dynamic order statistics|17.1 Dynamic order statistics]]
	1. [[#17.1 Dynamic order statistics#Retrieving the element with a given rank|Retrieving the element with a given rank]]
	2. [[#17.1 Dynamic order statistics#Determining the rank of an element|Determining the rank of an element]]
	3. [[#17.1 Dynamic order statistics#Maintaining subtree sizes|Maintaining subtree sizes]]
7. [[#17.2 How to augment a data structure|17.2 How to augment a data structure]]
	1. [[#17.2 How to augment a data structure#Applying the four steps: order-statistic trees|Applying the four steps: order-statistic trees]]
	2. [[#17.2 How to augment a data structure#Augmenting red-black trees|Augmenting red-black trees]]
8. [[#17.3 Interval trees|17.3 Interval trees]]
	1. [[#17.3 Interval trees#Step 1: Underlying data structure|Step 1: Underlying data structure]]
	2. [[#17.3 Interval trees#Step 2: Additional information|Step 2: Additional information]]
	3. [[#17.3 Interval trees#Step 3: Maintaining the information|Step 3: Maintaining the information]]
	4. [[#17.3 Interval trees#Step 4: Developing new operations|Step 4: Developing new operations]]
	5. [[#17.3 Interval trees#Correctness of INTERVAL-SEARCH|Correctness of INTERVAL-SEARCH]]

- - -
## 12 Binary Search Trees

A binary search tree is a data structure that supports the core *dynamic-set operations*: `SEARCH`, `MINIMUM`, `MAXIMUM`, `PREDECESSOR`, `SUCCESSOR`, `INSERT`, and `DELETE`. Because of this versatility, a binary search tree can serve as both a *dictionary* and a *priority queue*.

> [!info] Time Complexity and Tree Height
> The running time of basic operations on a binary search tree is proportional to the **height** of the tree, meaning the shape of the tree directly determines performance:
> - **Complete binary tree** with $n$ nodes: operations run in $\Theta(\lg n)$ worst-case time.
> - **Linear chain** of $n$ nodes (degenerate case): operations degrade to $\Theta(n)$ worst-case time.
>
> A variation called *red-black trees* guarantees a height of $O(\lg n)$, ensuring efficient operations regardless of insertion order. Additionally, even a standard binary search tree built on a *random* set of $n$ keys will have an expected height of $O(\lg n)$ without any explicit balancing.

The fundamental operations on binary search trees include:

- **Tree traversal** — walking the tree to produce values in sorted order.
- **Searching** — finding a specific value within the tree.
- **Finding extremes** — locating the minimum or maximum element.
- **Finding neighbors** — determining the predecessor or successor of a given element.
- **Modification** — inserting new elements and deleting existing ones.
## 12.1 What is a binary search tree?

A binary search tree (BST) is organized as a binary tree and can be represented using a linked data structure. Each node contains a `key`, satellite data, and three pointer attributes:

- `left` — points to the node's left child.
- `right` — points to the node's right child.
- `p` — points to the node's parent.

If a child or parent is missing, the corresponding attribute is set to `NIL`. The tree itself has a `root` attribute pointing to the root node (or `NIL` if the tree is empty). The root is the only node in the tree whose parent is `NIL`.
![[Pasted image 20261108204336.png]]
Figure 12.1 Binary search trees. For any node x, the keys in the left subtree of x are at most x:key, and the keys in the right subtree of x are at least x:key. Different binary search trees can represent the same set of values. The worst-case running time for most search-tree operations is proportional to the height of the tree. (a) A binary search tree on 6 nodes with height 2. The top ûgure shows how to view the tree conceptually, and the bottom ûgure shows the left, right, and p attributes in each node, in the style of Figure 10.6 on page 266. (b) A less efûcient binary search tree, with height 4, that contains the same keys.

> [!info] The Binary-Search-Tree Property
> The keys in a BST are always stored to satisfy the following invariant:
> 
> Let $x$ be any node in the tree.
> - If $y$ is a node in the **left subtree** of $x$, then $y.\text{key} \leq x.\text{key}$.
> - If $y$ is a node in the **right subtree** of $x$, then $y.\text{key} \geq x.\text{key}$.
> 
> This property holds recursively for *every* node in the tree. For example, if a tree's root has key $6$, then all keys in its left subtree (e.g., $2, 5, 5$) are $\leq 6$, and all keys in its right subtree (e.g., $7, 8$) are $\geq 6$. The same logic applies to every subtree within the tree.

### Inorder Tree Walk

Because of the binary-search-tree property, all keys can be printed in sorted order using a simple recursive algorithm called an *inorder tree walk*. It is named "inorder" because it prints the root of a subtree **between** visiting its left and right subtrees. (By contrast, a *preorder* walk prints the root **before** its subtrees, and a *postorder* walk prints the root **after** its subtrees.)

```
INORDER-TREE-WALK(x)
    if x ≠ NIL
        INORDER-TREE-WALK(x.left)    // visit left subtree first
        print x.key                   // then print the current node
        INORDER-TREE-WALK(x.right)   // then visit right subtree
```

To print all elements in a tree $T$, call `INORDER-TREE-WALK(T.root)`. For a tree containing the keys $\{2, 5, 5, 6, 7, 8\}$, the inorder walk outputs them in sorted order: $2, 5, 5, 6, 7, 8$.

Walking an $n$-node binary search tree takes $\Theta(n)$ time, because after the initial call the procedure recurses exactly twice per node — once for the left child and once for the right child.

> [!summary] Theorem 12.1: Inorder Tree Walk Time Complexity
> If $x$ is the root of an $n$-node subtree, then the call `INORDER-TREE-WALK(x)` takes $\Theta(n)$ time.
> 
> **Breakdown:**
> - $T(n)$: The time taken by `INORDER-TREE-WALK` when called on the root of an $n$-node subtree.
> - $n$: The total number of nodes in the subtree.
> - $k$: The number of nodes in the left subtree of the current node.
> - $n - k - 1$: The number of nodes in the right subtree (total minus left subtree minus the root itself).
> - $c$: A constant representing the time for the base case (the `NIL` check on an empty subtree), where $c > 0$.
> - $d$: A constant representing the upper bound on the time to execute the body of the procedure (the comparison and print), exclusive of recursive calls, where $d > 0$.
> 
> **Proof:**
> Let $T(n)$ denote the running time on an $n$-node subtree.
> 
> *Lower bound:* Since the procedure visits all $n$ nodes, $T(n) = \Omega(n)$.
> 
> *Upper bound:* We show $T(n) = O(n)$ using the **substitution method**, proving that $T(n) \leq (c + d)n + c$.
> 
> **Base case** ($n = 0$): The procedure performs only the `NIL` check, so $T(0) = c$. Our bound gives $(c + d) \cdot 0 + c = c = T(0)$. ✓
> 
> **Inductive step** ($n > 0$): Suppose the current node $x$ has a left subtree of $k$ nodes and a right subtree of $n - k - 1$ nodes. Then:
> 
> $$T(n) \leq T(k) + T(n - k - 1) + d$$
> 
> Applying the inductive hypothesis to both recursive calls:
> 
> $$T(n) \leq \bigl((c+d)k + c\bigr) + \bigl((c+d)(n-k-1) + c\bigr) + d$$
> 
> Expanding and simplifying:
> 
> $$= (c+d)n + c - (c+d) + c + d$$
> 
> $$= (c+d)n + c$$
> 
> This completes the proof that $T(n) = O(n)$. Combined with the lower bound, $T(n) = \Theta(n)$. $\blacksquare$

## 12.2 Querying a binary search tree

Binary search trees support the query operations `SEARCH`, `MINIMUM`, `MAXIMUM`, `SUCCESSOR`, and `PREDECESSOR`. Each of these operations can be performed in $O(h)$ time on any binary search tree of height $h$.

> [!info] Query Time Complexity
> All five dynamic-set query operations — `SEARCH`, `MINIMUM`, `MAXIMUM`, `SUCCESSOR`, and `PREDECESSOR` — run in $O(h)$ time, where $h$ is the height of the tree. This is because each operation traces a simple path either downward or upward through the tree, visiting at most $h$ nodes.

### Searching

To search for a node with a given key, the `TREE-SEARCH` procedure takes a pointer $x$ to the root of a subtree and a key $k$. It returns a pointer to a node with key $k$ if one exists, or `NIL` otherwise. To search the entire tree $T$, call `TREE-SEARCH(T.root, k)`.

```
TREE-SEARCH(x, k)
    if x == NIL or k == x.key       // base case: found it or hit a dead end
        return x
    if k < x.key
        return TREE-SEARCH(x.left, k)   // key must be in left subtree
    else
        return TREE-SEARCH(x.right, k)  // key must be in right subtree
```

The procedure starts at the root and traces a simple path downward. At each node $x$, it compares $k$ with `x.key`. If they are equal, the search terminates. If $k$ is smaller, the search continues in the left subtree (the binary-search-tree property guarantees $k$ cannot be in the right subtree). If $k$ is larger, the search continues in the right subtree. The running time is $O(h)$ because the nodes visited form a simple downward path from the root.
![[Pasted image 20261108204850.png]]
Figure 12.2(a) A search for the key 13 in the tree follows the path 15 ! 6 ! 7 ! 13 from the root

Since `TREE-SEARCH` recurses on only one subtree at each step (not both), the recursion can be unrolled into a `while` loop. The iterative version is typically more efficient on most computers:

```
ITERATIVE-TREE-SEARCH(x, k)
    while x ≠ NIL and k ≠ x.key     // loop until found or dead end
        if k < x.key
            x = x.left               // move to left child
        else
            x = x.right              // move to right child
    return x
```

### Minimum and maximum

Finding the minimum key in a subtree is straightforward: follow left child pointers from the root of the subtree until reaching `NIL`. The correctness follows from the binary-search-tree property — if a node $x$ has no left subtree, then `x.key` is the minimum since every key in the right subtree is at least as large. If $x$ does have a left subtree, the minimum must reside there because all keys in the left subtree are no larger than `x.key`, and no key in the right subtree is smaller.

```
TREE-MINIMUM(x)
    while x.left ≠ NIL       // keep going left
        x = x.left
    return x                  // leftmost node is the minimum
```

The `TREE-MAXIMUM` procedure is symmetric, following right child pointers instead:

```
TREE-MAXIMUM(x)
    while x.right ≠ NIL      // keep going right
        x = x.right
    return x                  // rightmost node is the maximum
```

Both procedures run in $O(h)$ time since the sequence of nodes encountered forms a simple downward path from the root.
![[Pasted image 20261108204938.png]]
Figure 12.2(b) The minimum key in the tree is 2, which is found by following left pointers from the root. The maximum key 20 is found by following right pointers from the root.

### Successor and predecessor

The *successor* of a node $x$ is defined as the next node that would be visited in an inorder tree walk. If all keys are distinct, this is the node with the smallest key greater than `x.key`. The structure of the BST allows the successor to be determined *without comparing keys*. The `TREE-SUCCESSOR` procedure returns the successor of $x$ if it exists, or `NIL` if $x$ is the last node in an inorder walk.

The algorithm handles two cases:

1. **Right subtree is nonempty:** The successor is the leftmost node in $x$'s right subtree (i.e., the minimum of the right subtree). For example, if a node has key $15$ and its right subtree contains keys $17$ and $19$, the successor is $17$.
![[Pasted image 20261108205042.png]]
Figure 12.2(c) The successor of the node with key 15 is the node with key 17, since it is the minimum key in the right subtree of 15.

2. **Right subtree is empty:** The successor is the *lowest ancestor* of $x$ whose left child is also an ancestor of $x$. To find it, walk up the tree from $x$ until you encounter a node that is the left child of its parent (or reach the root). For example, if a node with key $13$ has no right subtree, you walk upward until you find an ancestor where the path came from the left — that ancestor is the successor.
![[Pasted image 20261108205059.png]]
Figure 12.2(d) The node with key 13 has no right subtree, and thus its successor is its lowest ancestor whose left child is also an ancestor. In this case, the node with key 15 is its successor.

```
TREE-SUCCESSOR(x)
    if x.right ≠ NIL
        return TREE-MINIMUM(x.right)    // Case 1: leftmost in right subtree
    else                                // Case 2: go up to find lowest ancestor
        y = x.p                         //   whose left child is an ancestor of x
        while y ≠ NIL and x == y.right  //   keep going up while x is a right child
            x = y
            y = y.p
        return y
```

The running time is $O(h)$ because the procedure either follows a simple path down the tree (Case 1) or a simple path up the tree (Case 2). The `TREE-PREDECESSOR` procedure is symmetric to `TREE-SUCCESSOR` and also runs in $O(h)$ time.

> [!summary] Theorem 12.2: Query Operations Time Bound
> The dynamic-set operations `SEARCH`, `MINIMUM`, `MAXIMUM`, `SUCCESSOR`, and `PREDECESSOR` can each be implemented to run in $O(h)$ time on a binary search tree of height $h$.
> 
> **Breakdown:**
> - $h$: The height of the binary search tree. This determines the maximum length of any root-to-leaf path.
> - $O(h)$: Each query operation traces at most one simple path (upward or downward) through the tree, visiting no more than $h$ nodes.
> 
> **Proof:**
> Each of the five operations follows a simple path in the tree — either downward from the root (`SEARCH`, `MINIMUM`, `MAXIMUM`) or along a single upward/downward traversal (`SUCCESSOR`, `PREDECESSOR`). Since a simple path in a tree of height $h$ contains at most $h$ nodes, and each node requires $O(1)$ work, every operation completes in $O(h)$ time. $\blacksquare$

## 12.3 Insertion and deletion

The operations of insertion and deletion cause the dynamic set represented by a binary search tree to change. The data structure must be modified to reflect this change while preserving the binary-search-tree property. Inserting a new element is relatively straightforward, but deleting a node is more complicated.

### Insertion

The `TREE-INSERT` procedure inserts a new node into a binary search tree. It takes a tree $T$ and a node $z$ whose `key` has already been set, with `z.left = NIL` and `z.right = NIL`. It modifies $T$ and some attributes of $z$ to place $z$ in the correct position.

```
TREE-INSERT(T, z)
    x = T.root          // x traces the path down the tree
    y = NIL             // y will become z's parent
    while x ≠ NIL       // descend until reaching a leaf position
        y = x           // y trails behind x
        if z.key < x.key
            x = x.left  // go left
        else
            x = x.right // go right
    z.p = y             // found the location — insert z with parent y
    if y == NIL
        T.root = z      // tree T was empty
    else if z.key < y.key
        y.left = z      // z becomes y's left child
    else
        y.right = z     // z becomes y's right child
```

The procedure begins at the root and traces a simple path downward, searching for the `NIL` position to replace with the input node $z$. A trailing pointer $y$ maintains the parent of $x$ throughout the descent. The `while` loop moves both pointers down the tree, going left or right based on comparing `z.key` with `x.key`, until $x$ becomes `NIL`. This `NIL` marks the position where $z$ belongs — it is either a left or right attribute of the node that will become $z$'s parent, or it is `T.root` if the tree is currently empty. The trailing pointer $y$ is necessary because by the time the correct `NIL` is found, the search has already moved one step past the node that needs to be modified.
![[Pasted image 20261108213713.png]]
Figure 12.3 Inserting a node with key 13 into a binary search tree. The simple path from the root down to the position where the node is inserted is shown in blue. The new node and the link to its parent are highlighted in orange.

Like other primitive BST operations, `TREE-INSERT` runs in $O(h)$ time on a tree of height $h$.

### Deletion

The overall strategy for deleting a node $z$ from a binary search tree has three conceptual cases:

1. **$z$ has no children:** Simply remove $z$ by modifying its parent to replace $z$ with `NIL`.
2. **$z$ has one child:** Elevate that child to take $z$'s position by modifying $z$'s parent to replace $z$ with $z$'s child.
3. **$z$ has two children:** Find $z$'s successor $y$, which must be in $z$'s right subtree and has no left child. Move $y$ to take $z$'s position. The rest of $z$'s right subtree becomes $y$'s new right subtree, and $z$'s left subtree becomes $y$'s new left subtree. Since $y$ is $z$'s successor, it cannot have a left child, and $y$'s original right child moves into $y$'s original position with the rest of $y$'s original right subtree following automatically. This case is the trickiest because the implementation differs depending on whether $y$ is $z$'s right child.

The actual `TREE-DELETE` procedure reorganizes these into four implementation cases:

- **$z$ has no left child:** Replace $z$ by its right child (which may or may not be `NIL`). When the right child is `NIL`, this handles the no-children case. When it is non-`NIL`, this handles the single-right-child case.
- **$z$ has a left child but no right child:** Replace $z$ by its left child.
- **$z$ has two children, and its successor $y$ is $z$'s right child:** Replace $z$ by $y$, leaving $y$'s right child alone.
- **$z$ has two children, and its successor $y$ is not $z$'s right child:** First replace $y$ by its own right child, then replace $z$ by $y$.

![[Pasted image 20261108213743.png]]
Figure 12.4 Deleting a node ´, in blue, from a binary search tree. Node ´ may be the root, a left child of node q, or a right child of q. The node that will replace node ´ in its position in the tree is colored orange. (a) Node ´ has no left child. Replace ´ by its right child r, which may or may not be NIL. (b) Node ´ has a left child l but no right child. Replace ´ by l. (c) Node ´ has two children. Its left child is node l, its right child is its successor y (which has no left child), and y’s right child is node x. Replace ´ by y, updating y’s left child to become l, but leaving x as y’s right child. (d) Node ´ has two children (left child l and right child r), and its successor y ¤ r lies within the subtree rooted at r. First replace y by its own right child x, and set y to be r’s parent. Then set y to be q’s child and the parent of l.
#### The TRANSPLANT Subroutine

As part of deletion, subtrees need to move around within the tree. The `TRANSPLANT` subroutine replaces one subtree as a child of its parent with another subtree. When `TRANSPLANT` replaces the subtree rooted at node $u$ with the subtree rooted at node $v$, node $u$'s parent becomes node $v$'s parent, and $u$'s parent ends up having $v$ as the appropriate child. The argument $v$ is allowed to be `NIL`.

```
TRANSPLANT(T, u, v)
    if u.p == NIL
        T.root = v          // u was the root; v becomes the new root
    else if u == u.p.left
        u.p.left = v        // u is a left child; replace it with v
    else
        u.p.right = v       // u is a right child; replace it with v
    if v ≠ NIL
        v.p = u.p           // update v's parent pointer
```

The first two lines handle the case where $u$ is the root of $T$. Otherwise, $u$ is either a left or right child of its parent, and the appropriate pointer is updated. Because $v$ may be `NIL`, the parent pointer of $v$ is only updated when $v$ is non-`NIL`. Importantly, `TRANSPLANT` does *not* update `v.left` or `v.right` — that responsibility belongs to the caller.

#### The TREE-DELETE Procedure

```
TREE-DELETE(T, z)
    if z.left == NIL
        TRANSPLANT(T, z, z.right)       // Case 1: replace z by its right child
    else if z.right == NIL
        TRANSPLANT(T, z, z.left)        // Case 2: replace z by its left child
    else
        y = TREE-MINIMUM(z.right)       // y is z's successor (in right subtree)
        if y ≠ z.right                  // Case 4: y is deeper in the right subtree
            TRANSPLANT(T, y, y.right)   //   splice y out: replace y by its right child
            y.right = z.right           //   z's right child becomes y's right child
            y.right.p = y
        TRANSPLANT(T, z, y)             // Case 3 or 4: replace z by successor y
        y.left = z.left                 //   give z's left child to y
        y.left.p = y                    //   (y had no left child, being the successor)
```

The procedure executes the four cases as follows. The first two lines handle $z$ having no left child. The next two lines handle $z$ having a left child but no right child. The remaining lines deal with $z$ having two children: the successor $y$ is found via `TREE-MINIMUM(z.right)`. If $y$ is not $z$'s right child, $y$ is first spliced out of its current position by replacing it with its own right child, and then $z$'s right child is reassigned to $y$. Finally, $z$ is replaced by $y$, and $z$'s left child is given to $y$.

Each line of `TREE-DELETE`, including the calls to `TRANSPLANT`, takes constant time, except for the call to `TREE-MINIMUM`. Thus, `TREE-DELETE` runs in $O(h)$ time on a tree of height $h$.

> [!summary] Theorem 12.3: Insertion and Deletion Time Bound
> The dynamic-set operations `INSERT` and `DELETE` can each be implemented to run in $O(h)$ time on a binary search tree of height $h$.
> 
> **Breakdown:**
> - $h$: The height of the binary search tree, representing the maximum length of any root-to-leaf path.
> - $O(h)$: Both operations trace simple paths through the tree. `TREE-INSERT` descends from the root to a leaf position. `TREE-DELETE` performs at most one call to `TREE-MINIMUM` (which descends a path of length at most $h$) plus a constant number of `TRANSPLANT` operations (each $O(1)$).
> 
> **Proof:**
> `TREE-INSERT` follows a single downward path from the root to a `NIL` position, performing $O(1)$ work at each node, yielding $O(h)$ total time. `TREE-DELETE` executes a constant number of `TRANSPLANT` calls (each taking $O(1)$ time) and at most one `TREE-MINIMUM` call (which takes $O(h)$ time), so its total running time is also $O(h)$. $\blacksquare$

## 17 Augmenting Data Structures

Some algorithmic problems can be solved with standard data structures — such as doubly linked lists, hash tables, or binary search trees — but many others require a bit more creativity. Rather than inventing an entirely new data structure from scratch, a more practical approach is to *augment* an existing one by storing additional information within it. New operations can then be programmed on top of the augmented structure to support specific application needs.

> [!warning] The Challenge of Augmentation
> Augmenting a data structure is not always straightforward. The additional information stored in the structure must be **updated and maintained** by all of the ordinary operations (insertion, deletion, rotation, etc.) on the underlying data structure. If any operation fails to keep the extra information consistent, the augmented structure will produce incorrect results.

The general process of augmentation involves:

1. Choosing an underlying data structure (e.g., a red-black tree).
2. Determining what additional information to store in each node.
3. Verifying that the additional information can be maintained efficiently during all standard modifying operations.
4. Designing new operations that leverage the augmented information.

> [!abstract] Two Key Applications of Augmented Red-Black Trees
> This topic explores two concrete examples of augmenting red-black trees with extra information:
> 
> - **Order-statistic trees:** A red-black tree augmented to support *order-statistic operations* on a dynamic set — specifically, quickly finding the $i$th smallest element or determining the *rank* of a given element (its position in sorted order).
> - **Interval trees:** A red-black tree augmented to maintain a dynamic set of *intervals* (such as time intervals), enabling fast queries to find any interval that overlaps a given query interval.
> 
> Between these two examples, a general methodology for augmenting data structures is formalized, including a theorem that provides a systematic way to verify whether a proposed augmentation of a red-black tree can be maintained efficiently.

## 17.1 Dynamic order statistics

The $i$th *order statistic* of a set of $n$ elements, where $i \in \{1, 2, \ldots, n\}$, is the element with the $i$th smallest key. While it is possible to determine any order statistic in $O(n)$ time from an unordered set, an *order-statistic tree* allows both order-statistic queries and rank computations on a dynamic set in $O(\lg n)$ time.

> [!info] Order-Statistic Tree Structure
> An order-statistic tree is a red-black tree augmented with one additional attribute per node: `x.size`. Each node $x$ contains the standard red-black tree attributes (`x.key`, `x.color`, `x.p`, `x.left`, `x.right`) plus:
> - `x.size`: The number of internal nodes in the subtree rooted at $x$, **including** $x$ itself but **excluding** sentinels.
> 
> This gives the identity:
> 
> $$x.\text{size} = x.\text{left}.\text{size} + x.\text{right}.\text{size} + 1$$
> 
> where the sentinel's size is defined as $0$ (i.e., $T.\text{nil}.\text{size} = 0$).

Keys in an order-statistic tree need not be distinct. When equal keys are present, the *rank* of an element is defined as the position at which it would be printed during an inorder tree walk. For example, if two nodes both have key $14$, the one appearing earlier in the inorder walk has a lower rank than the other.
![[Pasted image 20261108215915.png]]
Figure 17.1 An order-statistic tree, which is an augmented red-black tree. In addition to its usual attributes, each node x has an attribute x:size, which is the number of nodes, other than the sentinel, in the subtree rooted at x.
### Retrieving the element with a given rank

The `OS-SELECT` procedure returns a pointer to the node containing the $i$th smallest key in the subtree rooted at $x$. To find the $i$th smallest element in the entire tree $T$, call `OS-SELECT(T.root, i)`.

```
OS-SELECT(x, i)
    r = x.left.size + 1          // rank of x within its own subtree
    if i == r
        return x                 // x is the ith smallest
    else if i < r
        return OS-SELECT(x.left, i)       // ith smallest is in left subtree
    else
        return OS-SELECT(x.right, i - r)  // adjust rank for right subtree
```

The logic works as follows. The value `x.left.size + 1` gives the rank of $x$ within the subtree rooted at $x$, because `x.left.size` counts the nodes that precede $x$ in an inorder walk of that subtree. Three cases arise:

- If $i = r$, then $x$ itself is the $i$th smallest element.
- If $i < r$, the $i$th smallest element must be in $x$'s left subtree, so the procedure recurses left with the same $i$.
- If $i > r$, the $i$th smallest element is in $x$'s right subtree. Since $r$ elements in the subtree rooted at $x$ come before the right subtree in an inorder walk, the target is the $(i - r)$th smallest element in the right subtree.

> [!example] OS-SELECT Walkthrough
> Suppose we search for the 17th smallest element in a tree whose root has key $26$ with a left subtree of size $12$.
> 
> 1. **Root (key 26):** $r = 12 + 1 = 13$. Since $17 > 13$, recurse right with $i = 17 - 13 = 4$.
> 2. **Node (key 41):** $r = 5 + 1 = 6$. Since $4 < 6$, recurse left with $i = 4$.
> 3. **Node (key 30):** $r = 1 + 1 = 2$. Since $4 > 2$, recurse right with $i = 4 - 2 = 2$.
> 4. **Node (key 38):** $r = 1 + 1 = 2$. Since $i = r = 2$, return this node.
> 
> The 17th smallest element has key $38$.

Because each recursive call descends one level in the tree, the running time is proportional to the height. Since the underlying structure is a red-black tree, `OS-SELECT` runs in $O(\lg n)$ time.

### Determining the rank of an element

Given a pointer to a node $x$ in an order-statistic tree $T$, the `OS-RANK` procedure returns the position of $x$ in the linear order determined by an inorder tree walk of $T$.

```
OS-RANK(T, x)
    r = x.left.size + 1    // rank of x within its own subtree
    y = x                  // y tracks the current subtree root being examined
    while y ≠ T.root
        if y == y.p.right  // if y is a right child...
            r = r + y.p.left.size + 1  // ...add parent's left subtree + parent itself
        y = y.p            // move y toward the root
    return r
```

The idea is that a node's rank equals the number of nodes preceding it in an inorder walk, plus $1$ for itself. The procedure walks upward from $x$ to the root, accumulating the sizes of left subtrees of ancestors whenever the path comes from the right.

> [!summary] Correctness of OS-RANK via Loop Invariant
> **Loop invariant:** At the start of each iteration of the `while` loop, $r$ is the rank of `x.key` in the subtree rooted at node $y$.
> 
> **Breakdown:**
> - $r$: The running rank accumulator, initialized to `x.left.size + 1`.
> - $y$: The current ancestor being examined, initialized to $x$ and moving upward toward the root each iteration.
> - $y.\text{p}.\text{left}.\text{size} + 1$: When $y$ is a right child, this counts all nodes in the parent's left subtree plus the parent itself — all of which precede $x$ in the inorder walk.
> 
> **Proof:**
> - *Initialization:* Before the first iteration, $r = x.\text{left}.\text{size} + 1$, which is the rank of `x.key` within the subtree rooted at $x$. Setting $y = x$ makes the invariant true.
> - *Maintenance:* At the end of each iteration, $y$ is set to $y.\text{p}$. If $y$ was a left child, neither $y.\text{p}$ nor any node in $y.\text{p}$'s right subtree precedes $x$, so $r$ is unchanged and remains correct for the larger subtree. If $y$ was a right child, all nodes in $y.\text{p}$'s left subtree and $y.\text{p}$ itself precede $x$ in the inorder walk, so $r$ is increased by $y.\text{p}.\text{left}.\text{size} + 1$, correctly reflecting the rank within the subtree rooted at $y.\text{p}$.
> - *Termination:* The loop terminates when $y = T.\text{root}$, at which point the subtree rooted at $y$ is the entire tree, so $r$ is the rank of `x.key` in the full tree. $\blacksquare$

Each iteration takes $O(1)$ time and moves $y$ one level up the tree, so `OS-RANK` runs in $O(\lg n)$ time on an $n$-node order-statistic tree.

### Maintaining subtree sizes

The `size` attribute must be efficiently maintained during insertion and deletion to preserve the $O(\lg n)$ query times. Fortunately, this can be done without affecting the asymptotic running time of either operation.

**Insertion** into a red-black tree consists of two phases:

1. **Downward phase:** The new node is inserted as a child of an existing leaf. To maintain sizes, increment `x.size` for every node $x$ on the simple path traversed from the root to the insertion point. The new node receives a size of $1$. Since this path has $O(\lg n)$ nodes, the additional cost is $O(\lg n)$.

2. **Upward phase:** Colors are changed and at most two rotations are performed to restore red-black properties. A rotation is a local operation that invalidates the `size` attributes of only the two nodes incident on the rotation link. The fix is to add two lines to the rotation procedure. For a left rotation on node $x$ producing node $y$ as the new subtree root:

```
// After the standard rotation pointer updates:
y.size = x.size                            // y inherits x's old subtree size
x.size = x.left.size + x.right.size + 1    // recompute x's size from its new children
```

The right rotation update is symmetric. Since at most two rotations occur, the second phase adds only $O(1)$ time. Total insertion time remains $O(\lg n)$.
![[Pasted image 20261108220918.png]]
Figure 17.2 Updating subtree sizes during rotations. The updates are local, requiring only the size information stored in x, y, and the roots of the subtrees shown as triangles.

**Deletion** from a red-black tree also has two phases:

1. **Structural phase:** One node is removed and at most two other nodes may be repositioned within the tree. To update sizes, traverse a simple path from the lowest moved node (starting from its original position) up to the root, decrementing the `size` attribute of each node on the path. This path has length $O(\lg n)$, so the additional cost is $O(\lg n)$.

2. **Rotation phase:** At most three rotations are performed, handled identically to the insertion case — each rotation requires $O(1)$ time to update the two affected `size` attributes.

> [!summary] Theorem: Order-Statistic Tree Operation Times
> On an order-statistic tree with $n$ nodes, all dynamic-set operations — including `OS-SELECT`, `OS-RANK`, `INSERT`, and `DELETE` — run in $O(\lg n)$ time.
> 
> **Breakdown:**
> - $n$: The number of nodes in the order-statistic tree.
> - $O(\lg n)$: The height of the underlying red-black tree, which bounds the length of any root-to-leaf or leaf-to-root path.
> - `OS-SELECT`: Descends one level per recursive call → $O(\lg n)$.
> - `OS-RANK`: Ascends one level per loop iteration → $O(\lg n)$.
> - `INSERT`: Downward path update $O(\lg n)$ + at most 2 rotations $O(1)$ → $O(\lg n)$.
> - `DELETE`: Upward path update $O(\lg n)$ + at most 3 rotations $O(1)$ → $O(\lg n)$.

## 17.2 How to augment a data structure

The process of augmenting a basic data structure to support additional functionality is a common technique in algorithm design. It can be broken down into four steps:

1. **Choose an underlying data structure.**
2. **Determine additional information** to maintain in the underlying data structure.
3. **Verify** that the additional information can be maintained by the basic modifying operations (insertion, deletion, etc.) on the underlying data structure.
4. **Develop new operations** that leverage the augmented information.

In practice, these steps are rarely followed in strict order. Design work involves trial and error, and progress on all steps usually proceeds in parallel. For instance, there is no point in choosing additional information and designing new operations (steps 2 and 4) if that information cannot be maintained efficiently during modifications. Nevertheless, the four-step framework provides useful focus and a good structure for documenting an augmented data structure.

> [!tip] Practical Guidance on Choosing Additional Information
> The additional information should make new operations more efficient, but it must also be *cheap to maintain*. Ideally, a modification to the data structure should update the augmented information in only a small number of nodes. For example, storing each node's rank directly in the tree would make rank queries fast, but inserting a new minimum element could require updating the rank of *every* node — an $O(n)$ cost. A better choice is to store subtree sizes, which change in only $O(\lg n)$ nodes per insertion.

### Applying the four steps: order-statistic trees

The order-statistic tree from the previous section serves as a concrete illustration of the methodology:

- **Step 1:** Red-black trees were chosen as the underlying structure because they already support dynamic-set operations on a total order (`MINIMUM`, `MAXIMUM`, `SUCCESSOR`, `PREDECESSOR`) in $O(\lg n)$ time.
- **Step 2:** A `size` attribute was added to each node $x$, storing the number of internal nodes in the subtree rooted at $x$. This enables $O(\lg n)$ order-statistic queries that would otherwise require $O(n)$ time using keys alone.
- **Step 3:** It was verified that insertion and deletion can maintain the `size` attributes while still running in $O(\lg n)$ time. Insertion changes `size` along a single root-to-leaf path ($O(\lg n)$ nodes) plus at most two rotations ($O(1)$ nodes each). Deletion similarly affects $O(\lg n)$ nodes plus at most three rotations.
- **Step 4:** The new operations `OS-SELECT` and `OS-RANK` were developed to exploit the `size` attribute.

### Augmenting red-black trees

When a red-black tree is the underlying data structure, a general theorem simplifies step 3 by guaranteeing that certain kinds of augmented attributes can always be maintained efficiently.

> [!summary] Theorem 17.1: Augmenting a Red-Black Tree
> Let $f$ be an attribute that augments a red-black tree $T$ of $n$ nodes. Suppose that the value of $f$ for each node $x$ depends only on information in $x$, $x.\text{left}$, and $x.\text{right}$ (possibly including $x.\text{left}.f$ and $x.\text{right}.f$), and that $x.f$ can be computed from this information in $O(1)$ time. Then, insertion and deletion can maintain the values of $f$ in all nodes of $T$ without asymptotically affecting the $O(\lg n)$ running times of these operations.
> 
> **Breakdown:**
> - $f$: The augmenting attribute stored at each node (e.g., `size` in an order-statistic tree). It represents any additional information you wish to maintain.
> - $T$: The red-black tree being augmented, containing $n$ nodes.
> - $n$: The total number of nodes in the tree.
> - $x$: An arbitrary node in the tree.
> - $x.\text{left}$, $x.\text{right}$: The left and right children of $x$. The theorem requires that $x.f$ depends *only* on local information at $x$ and its immediate children.
> - $x.f$: The value of the augmenting attribute at node $x$. It must be computable in $O(1)$ time from $x$'s own data and its children's $f$ values.
> - $O(\lg n)$: The height bound of a red-black tree, which limits the length of any propagation path from a changed node to the root.
> 
> **Proof:**
> The key insight is that a change to $x.f$ propagates only *upward* to ancestors of $x$. Changing $x.f$ may require updating $x.\text{p}.f$, which may require updating $x.\text{p}.\text{p}.f$, and so on up to the root. Once the root's $f$ value is updated, no other node depends on the new value, so propagation terminates. Since the height of a red-black tree is $O(\lg n)$, updating all dependent nodes after a single change costs $O(\lg n)$ time.
> 
> *Insertion* has two phases. In the first phase, the new node $x$ is inserted as a child of an existing node (or becomes the root if the tree was empty). Since $x$'s children are both sentinels, $x.f$ can be computed in $O(1)$ time. The change then propagates up the tree in $O(\lg n)$ time. In the second phase, at most two rotations occur to restore red-black properties. Each rotation changes only two nodes locally, but the resulting $f$-value changes may propagate to the root, costing $O(\lg n)$ per rotation. With at most two rotations, the total insertion time remains $O(\lg n)$.
> 
> *Deletion* also has two phases. In the first phase, one node is removed and at most two others may be repositioned. Propagating the resulting $f$-updates along the path from the lowest changed node to the root costs $O(\lg n)$. In the second phase, at most three rotations occur, each requiring at most $O(\lg n)$ time for $f$-propagation. Total deletion time is therefore $O(\lg n)$. $\blacksquare$

> [!note] Rotation Update Costs in Practice
> In many practical cases — such as maintaining subtree sizes — the cost of updating the augmented attribute after a single rotation is actually $O(1)$ rather than the $O(\lg n)$ worst case derived in the theorem's proof. This is because the new $f$ value at the rotated node can be recomputed from its children without any upward propagation. However, when an update *does* require traversal all the way to the root, it is critical that red-black trees perform only a *constant* number of rotations per insertion or deletion. Other balanced-tree schemes that may require $\Theta(\lg n)$ rotations per operation could degrade to $\Theta(\lg^2 n)$ time per operation if each rotation triggers a full rootward propagation.

## 17.3 Interval trees

Interval trees augment red-black trees to support operations on dynamic sets of intervals. Intervals are convenient for representing events that each occupy a continuous period of time — for example, querying a database of time intervals to find which events occurred during a given period. Throughout this discussion, intervals are assumed to be *closed* (including both endpoints), though the results extend conceptually to open and half-open intervals.

> [!info] Interval Representation and Overlap
> An interval $[t_1, t_2]$ is represented as an object $i$ with two attributes:
> - $i.\text{low} = t_1$: The low (left) endpoint.
> - $i.\text{high} = t_2$: The high (right) endpoint.
> 
> Two intervals $i$ and $i'$ **overlap** if $i \cap i' \neq \emptyset$, which occurs when both $i.\text{low} \leq i'.\text{high}$ and $i'.\text{low} \leq i.\text{high}$.

> [!info] The Interval Trichotomy
> For any two intervals $i$ and $i'$, exactly one of the following three properties holds:
> 1. $i$ and $i'$ **overlap**.
> 2. $i$ is **to the left** of $i'$ (i.e., $i.\text{high} < i'.\text{low}$).
> 3. $i$ is **to the right** of $i'$ (i.e., $i'.\text{high} < i.\text{low}$).
> 
> This trichotomy is fundamental to the correctness of interval tree search operations.

![[Pasted image 20261108231431.png]]
Figure 17.3 The interval trichotomy for two closed intervals i and i 0 . (a) If i and i 0 overlap, there are four situations, and in each, i:low හ i 0 :high and i 0 :low හ i:high. (b) The intervals do not overlap, and i:high < i0 :low. (c) The intervals do not overlap, and i 0 :high < i:low.

An interval tree maintains a dynamic set of elements, each containing an interval `x.int`, and supports three operations:

- `INTERVAL-INSERT(T, x)`: Adds element $x$ (whose `int` attribute contains an interval) to the interval tree $T$.
- `INTERVAL-DELETE(T, x)`: Removes element $x$ from the interval tree $T$.
- `INTERVAL-SEARCH(T, i)`: Returns a pointer to an element $x$ in $T$ such that `x.int` overlaps interval $i$, or the sentinel `T.nil` if no such element exists.

### Step 1: Underlying data structure

A red-black tree serves as the underlying structure. Each node $x$ contains an interval `x.int`, and the **key** of $x$ is the low endpoint `x.int.low`. An inorder tree walk therefore lists the intervals in sorted order by low endpoint.
![[Pasted image 20261108231445.png]]
Figure 17.4 An interval tree. (a) A set of 10 intervals, shown sorted bottom to top by left endpoint. (b) The interval tree that represents them. Each node x contains an interval, shown above the dashed line, and the maximum value of any interval endpoint in the subtree rooted at x, shown below the dashed line. An inorder tree walk of the tree lists the nodes in sorted order by left endpoint.
### Step 2: Additional information

In addition to the intervals themselves, each node $x$ stores an augmented attribute `x.max`, which is the **maximum value of any interval endpoint** stored in the subtree rooted at $x$.

### Step 3: Maintaining the information

The `max` attribute can be computed in $O(1)$ time from a node's interval and its children's `max` values:

$$x.\text{max} = \max\{x.\text{int}.\text{high},\; x.\text{left}.\text{max},\; x.\text{right}.\text{max}\}$$

Since $x.\text{max}$ depends only on information in $x$, $x.\text{left}$, and $x.\text{right}$, and can be computed in $O(1)$ time, Theorem 17.1 guarantees that insertion and deletion can maintain the `max` attributes without affecting the $O(\lg n)$ running time. In fact, the `max` attributes affected by a rotation can be updated in just $O(1)$ time.

### Step 4: Developing new operations

The key new operation is `INTERVAL-SEARCH`, which finds a node whose interval overlaps a given query interval $i$.

```
INTERVAL-SEARCH(T, i)
    x = T.root
    while x ≠ T.nil and i does not overlap x.int
        if x.left ≠ T.nil and x.left.max ≥ i.low
            x = x.left      // overlap may exist in left subtree
        else
            x = x.right     // no overlap possible in left subtree
    return x
```

The search starts at the root and proceeds downward, terminating when it either finds an overlapping interval or reaches the sentinel. Each loop iteration takes $O(1)$ time, and the tree height is $O(\lg n)$, so `INTERVAL-SEARCH` runs in $O(\lg n)$ time.

> [!example] INTERVAL-SEARCH Walkthrough
> **Successful search:** Suppose we search for an interval overlapping $i = [22, 25]$.
> 1. **Root** contains $[16, 21]$, which does not overlap $i$. Since `x.left.max = 23 ≥ 22 = i.low`, go left.
> 2. **Left child** contains $[8, 9]$, which does not overlap $i$. Since `x.left.max = 10 < 22 = i.low`, go right.
> 3. **Right child** contains $[15, 23]$, which overlaps $[22, 25]$. Return this node.
> 
> **Unsuccessful search:** Suppose we search for an interval overlapping $i = [11, 14]$.
> 4. **Root** contains $[16, 21]$, no overlap. `x.left.max = 23 ≥ 11`, go left.
> 5. **Left child** contains $[8, 9]$, no overlap. `x.left.max = 10 < 11`, go right.
> 6. **Right child** contains $[15, 23]$, no overlap. Left child is `T.nil`, go right.
> 7. Reach `T.nil`. Return `T.nil` — no overlapping interval exists.

### Correctness of INTERVAL-SEARCH

The reason it suffices to examine only a single path from the root is that at every node $x$, if `x.int` does not overlap $i$, the search always proceeds in a *safe* direction — one that is guaranteed to find an overlapping interval if one exists anywhere in the tree.

> [!summary] Theorem 17.2: Correctness of INTERVAL-SEARCH
> Any execution of `INTERVAL-SEARCH(T, i)` either returns a node whose interval overlaps $i$, or it returns `T.nil` and the tree $T$ contains no node whose interval overlaps $i$.
> 
> **Breakdown:**
> - $T$: The interval tree (a red-black tree augmented with `max` attributes).
> - $i$: The query interval being searched for.
> - $x$: The current node being examined during the search.
> - $x.\text{left}.\text{max}$: The maximum endpoint value in $x$'s left subtree. This is the key augmented attribute that guides the search direction.
> - $i.\text{low}$: The low endpoint of the query interval, compared against `x.left.max` to decide which subtree to explore.
> - $i'$: An arbitrary interval in $x$'s left subtree (used in the proof).
> - $i''$: An arbitrary interval in $x$'s right subtree (used in the proof).
> 
> **Proof:**
> The `while` loop terminates when either $x = T.\text{nil}$ or $i$ overlaps `x.int`. In the latter case, returning $x$ is clearly correct. The interesting case is when the loop terminates because $x = T.\text{nil}$, meaning no overlap was found. We must show that no overlapping interval was missed.
> 
> The proof establishes two claims about the search direction at any node $x$ where `x.int` does not overlap $i$:
> 
> **Claim 1: If the search goes right** (line 5), then $x$'s left subtree contains no interval overlapping $i$.
> 
> The search goes right when either $x.\text{left} = T.\text{nil}$ or $x.\text{left}.\text{max} < i.\text{low}$. If the left subtree is empty, it trivially contains no overlapping interval. Otherwise, $x.\text{left}.\text{max} < i.\text{low}$. For any interval $i'$ in $x$'s left subtree, $i'.\text{high} \leq x.\text{left}.\text{max} < i.\text{low}$. By the interval trichotomy, $i'.\text{high} < i.\text{low}$ means $i'$ is to the left of $i$, so they do not overlap. Therefore, no interval in the left subtree overlaps $i$, and going right is safe.
> 
> **Claim 2: If the search goes left** (line 4), then either the left subtree contains an overlapping interval, or the right subtree contains no overlapping interval.
> 
> The search goes left when $x.\text{left} \neq T.\text{nil}$ and $x.\text{left}.\text{max} \geq i.\text{low}$. Assume (for the sake of proving safety) that no interval in the left subtree overlaps $i$. By the definition of `max`, the left subtree contains some interval $i'$ such that $i'.\text{high} = x.\text{left}.\text{max} \geq i.\text{low}$. Since $i'$ is in the left subtree and does not overlap $i$ (by assumption), and since $i'.\text{high} \geq i.\text{low}$, the interval trichotomy tells us it must be that $i.\text{high} < i'.\text{low}$.
> 
> Now, because the tree is keyed on low endpoints and $i'$ is in $x$'s left subtree, $i'.\text{low} \leq x.\text{int}.\text{low}$. For any interval $i''$ in $x$'s right subtree, $x.\text{int}.\text{low} \leq i''.\text{low}$. Chaining these inequalities:
> 
> $$i.\text{high} < i'.\text{low} \leq x.\text{int}.\text{low} \leq i''.\text{low}$$
> 
> Since $i.\text{high} < i''.\text{low}$, the interval trichotomy tells us that $i$ and $i''$ do not overlap. Since $i''$ was arbitrary, no interval in $x$'s right subtree overlaps $i$. Therefore, going left does not miss any overlap in the right subtree.
> 
> Together, Claims 1 and 2 show that the search never overlooks an overlapping interval, completing the proof. $\blacksquare$

![[Pasted image 20261108231508.png]]'
Figure 17.5 Intervals in the proof of Theorem 17.2. The value of x:left:max is shown in each case as a dashed line. (a) The search goes right. No interval i 0 in x’s left subtree can overlap i. (b) The search goes left. The left subtree of x contains an interval that overlaps i (situation not shown), or x’s left subtree contains an interval i 0 such that i 0 :high D x:left:max. Since i does not overlap i 0 , neither does it overlap any interval i 00 in x’s right subtree, since i 0 :low හ i 00 :low.