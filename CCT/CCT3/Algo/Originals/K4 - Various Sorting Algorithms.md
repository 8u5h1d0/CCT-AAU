---
tags:
  - CCT3
  - Algoritmer
Topic: Heap Sort, Quick Sort, Counting Sort, Bucket Sort
Semester: CCT3
Course: Algoritmer
Litterature:
  - Introduction to Algorithms 4th ed.
Created: 26-09-2026
---
- - -
# Heapsort

**Heapsort** is an efficient, comparison-based sorting algorithm that combines the key strengths of other classical sorting approaches:
- **Asymptotic Efficiency:** Heapsort runs in $O(n \lg n)$ time, matching the asymptotic efficiency of merge sort.
- **In-Place Sorting:** Like insertion sort, heapsort sorts *in place*, requiring only a constant amount of auxiliary memory ($O(1)$ space) outside the input array at any time.

Heapsort relies on a specialized data structure called a `` `<heap>` `` to organize and manipulate data. Beyond its role in sorting, the heap data structure provides an efficient foundation for implementing *priority queues*.

>[!warning] Terminology Disambiguation: Heap Data Structure vs. Heap Memory
>The term `` `<heap>` `` was originally coined in the context of the heapsort algorithm. In general computer science and programming languages (such as Java and Python), the term is also used to describe `` `<garbage-collected storage>` `` (dynamic memory allocation). 
>
>In algorithmic contexts, the term **heap** refers strictly to the tree-based **data structure**, not to system memory allocation or garbage collection pools.

## 6.1 Heaps

The **(binary) heap** data structure is an array object that can be visualized as a nearly complete binary tree. Each node of the tree corresponds to an element stored within the array. The tree is completely filled on all levels except possibly the lowest, which is filled sequentially from left to right.

An array $A[1 : n]$ representing a heap contains an attribute $A.\text{heap-size}$, which specifies the number of active heap elements stored within $A$. Although the physical array $A[1 : n]$ may contain additional data, only elements in the range $A[1 : A.\text{heap-size}]$ (where $0 \le A.\text{heap-size} \le n$) constitute valid heap elements:
- If $A.\text{heap-size} = 0$, the heap is empty.
- The root of the tree is stored at index $A[1]$.

---

### Navigating the Heap Tree Structure

Given the index $i$ of any node in the heap, the indices of its parent, left child, and right child can be computed using simple integer arithmetic:

```text
PARENT(i)
1  return ⌊i / 2⌋

LEFT(i)
1  return 2i

RIGHT(i)
1  return 2i + 1
```

![[Pasted image 20260926150721.png]]
Figure 6.1 A max-heap viewed as (a) a binary tree and (b) an array. The number within the circle at each node in the tree is the value stored at that node. The number above a node is the corresponding index in the array. Above and below the array are lines showing parent-child relationships, with parents always to the left of their children. The tree has height 3, and the node at index 4 (with value 8) has height 1.

>[!tip] Fast Bitwise Implementations
>On most computer architectures, these navigation operations can be computed via single-cycle bit-shift instructions:
>- `LEFT(i)`: Compute $2i$ by shifting the binary representation of $i$ left by 1 bit position.
>- `RIGHT(i)`: Compute $2i + 1$ by shifting $i$ left by 1 bit and adding 1.
>- `PARENT(i)`: Compute $\lfloor i/2 \rfloor$ by shifting $i$ right by 1 bit position.
>
>High-performance implementations often define these procedures as macros or inline functions.

---

### Heap Types and Properties

Binary heaps are categorized into two primary variants based on the ordering relationship between parents and children:

>[!summary] Definition: Max-Heap and Min-Heap Properties
>
>**1. The Max-Heap Property:**
>For every node $i$ other than the root ($i > 1$):
>
>$$A[\text{PARENT}(i)] \ge A[i]$$
>
>- The value of any node is at most the value of its parent.
>- The largest element in a max-heap is always stored at the root ($A[1]$).
>- The subtree rooted at any node contains values no larger than the value stored at the node itself.
>- **Primary Application:** Used in the heapsort algorithm.
>
>**2. The Min-Heap Property:**
>For every node $i$ other than the root ($i > 1$):
>
>$$A[\text{PARENT}(i)] \le A[i]$$
>
>- The value of any node is at least the value of its parent.
>- The smallest element in a min-heap is always stored at the root ($A[1]$).
>- **Primary Application:** Used to implement priority queues.
>
>**Breakdown:**
>- $A$ : The array holding the heap elements.
>- $i$ : The array index of a given node in the heap ($1 \le i \le A.\text{heap-size}$).
>- $\text{PARENT}(i)$ : The index $\lfloor i/2 \rfloor$ of the parent node.
>- $A[\text{PARENT}(i)]$ : The key value stored at the parent node.
>- $A[i]$ : The key value stored at node $i$.

---

### Heap Height and Operational Complexity

- **Height of a Node:** The number of edges on the longest simple downward path from that node to a leaf.
- **Height of the Heap:** The height of the root node.

Because an $n$-element heap is structured as a nearly complete binary tree, the height of a heap containing $n$ elements is tightly bounded by:

$$\text{Height} = \Theta(\lg n)$$

Because the primary operations on a heap traverse paths along the tree's height, their running times are proportional to $O(\lg n)$.

---

### Overview of Core Heap Procedures

The standard procedures for manipulating binary heaps include:

- `MAX-HEAPIFY`: Runs in $O(\lg n)$ time; restores and maintains the max-heap property when a subtree violates it.
- `BUILD-MAX-HEAP`: Runs in linear time ($O(n)$); converts an arbitrary, unordered input array into a valid max-heap.
- `HEAPSORT`: Runs in $O(n \lg n)$ time; sorts an array in place using max-heap operations.
- **Priority Queue Operations:** The procedures `MAX-HEAP-INSERT`, `MAX-HEAP-EXTRACT-MAX`, `MAX-HEAP-INCREASE-KEY`, and `MAX-HEAP-MAXIMUM` run in $O(\lg n)$ time (plus index-mapping overhead) to support dynamic priority-queue functionality.

## 6.2 Maintaining the Heap Property

The `MAX-HEAPIFY` procedure restores and maintains the max-heap property for a subtree. 

>[!info] Precondition and Purpose of `MAX-HEAPIFY`
>- **Inputs:** An array $A$ (with attribute $A.\text{heap-size}$) and an index $i$.
>- **Precondition:** The binary subtrees rooted at $\text{LEFT}(i)$ and $\text{RIGHT}(i)$ are valid max-heaps, but the value at $A[i]$ might be smaller than its children, violating the max-heap property.
>- **Action:** The procedure allows the value at $A[i]$ to `` `<float down>` `` through the subtree until the entire subtree rooted at index $i$ obeys the max-heap property.

---

### The `MAX-HEAPIFY` Algorithm

```text
MAX-HEAPIFY(A, i)
1  l = LEFT(i)
2  r = RIGHT(i)
3  if l <= A.heap-size and A[l] > A[i]
4      largest = l
5  else largest = i
6  if r <= A.heap-size and A[r] > A[largest]
7      largest = r
8  if largest != i
9      exchange A[i] with A[largest]
10     MAX-HEAPIFY(A, largest)
```
![[Pasted image 20260926150854.png]]
Figure 6.2 The action of MAX-HEAPIFY.A; 2/, where A:heap-size D 10. The node that potentially violates the max-heap property is shown in blue. (a) The initial conûguration, with AŒ2� at node i D 2 violating the max-heap property since it is not larger than both children. The max-heap property is restored for node 2 in (b) by exchanging AŒ2� with AŒ4�, which destroys the max-heap property for node 4. The recursive call MAX-HEAPIFY.A; 4/ now has i D 4. After AŒ4� and AŒ9� are swapped, as shown in (c), node 4 is ûxed up, and the recursive call MAX-HEAPIFY.A; 9/ yields no further change to the data structure.
### Operational Mechanics

1. **Compare Parent and Children (Lines 1–7):** Determine the maximum value among the current node $A[i]$, its left child $A[\text{LEFT}(i)]$, and its right child $A[\text{RIGHT}(i)]$, saving the index of the largest element in `largest`.
2. **Evaluate Heap Property (Line 8):**
   - If $A[i]$ is already the largest element, the subtree rooted at $i$ satisfies the max-heap property and the procedure terminates.
3. **Swap and Recurse (Lines 9–10):**
   - If a child contains the largest element, exchange $A[i]$ with $A[\text{largest}]$.
   - Because this swap decreases the value stored at index `largest`, the subtree rooted at `largest` may now violate the max-heap property.
   - `MAX-HEAPIFY` is invoked recursively on the subtree rooted at `largest`.

---

### Running Time Analysis

At each step, comparing the node with its two children and performing the potential swap requires $\Theta(1)$ time. In the worst-case scenario (such as when the bottom level of the binary tree is exactly half full), the subtree passed to the recursive call contains at most $2n/3$ of the nodes in the original subtree of size $n$.

>[!summary] Recurrence for `MAX-HEAPIFY`
>The worst-case running time $T(n)$ of `MAX-HEAPIFY` on a subtree of size $n$ satisfies:
>
>$$T(n) \le T(2n/3) + \Theta(1)$$
>
>**Breakdown:**
>- $T(n)$ : The running time on a subtree containing $n$ total nodes.
>- $T(2n/3)$ : The time to recursively process the larger of the two child subtrees.
>- $\Theta(1)$ : The constant time required to compare keys and perform the array element swap.
>
>**Solution via Master Theorem:**
>- $a = 1, b = 3/2 \implies n^{\log_b a} = n^{\log_{3/2} 1} = n^0 = 1$.
>- Driving function: $f(n) = \Theta(1) = \Theta(n^{\log_b a} \lg^0 n)$.
>- **Case 2 applies ($k=0$):**
>  $$T(n) = O(\lg n)$$

Alternatively, the running time of `MAX-HEAPIFY` on a node of height $h$ can be characterized directly by the path distance traversed from that node to a leaf:

$$T(n) = O(h)$$

Since the maximum height of an $n$-element heap is $\lfloor \lg n \rfloor$, the overall running time is bounded by $O(\lg n)$.

## 6.3 Building a Heap

The `BUILD-MAX-HEAP` procedure converts an arbitrary, unordered array $A[1 : n]$ into a max-heap by invoking `MAX-HEAPIFY` in a bottom-up manner.

Because the array elements in the subarray $A[\lfloor n/2 \rfloor + 1 : n]$ represent the leaves of the binary tree, each leaf is already a trivial one-element max-heap. The procedure processes the remaining internal nodes in reverse order, running `MAX-HEAPIFY` on each from index $\lfloor n/2 \rfloor$ down to $1$.

```text
BUILD-MAX-HEAP(A, n)
1  A.heap-size = n
2  for i = ⌊n/2⌋ downto 1
3      MAX-HEAPIFY(A, i)
```
![[Pasted image 20260926151029.png]]
Figure 6.3 The operation of BUILD-MAX-HEAP, showing the data structure before the call to MAX-HEAPIFY in line 3 of BUILD-MAX-HEAP. The node indexed by i in each iteration is shown in blue. (a) A 10-element input array A and the binary tree it represents. The loop index i refers to node 5 before the call MAX-HEAPIFY.A; i/. (b) The data structure that results. The loop index i for the next iteration refers to node 4. (c)–(e) Subsequent iterations of the for loop in BUILD-MAX-HEAP. Observe that whenever MAX-HEAPIFY is called on a node, the two subtrees of that node are both max-heaps. (f) The max-heap after BUILD-MAX-HEAP ûnishes.

---

### Correctness: Loop Invariant Analysis

>[!summary] Loop Invariant for `BUILD-MAX-HEAP`
>**Invariant:** At the start of each iteration of the `for` loop (lines 2–3), each node $i + 1, i + 2, \dots, n$ is the root of a valid max-heap.
>
>- **Initialization:** Prior to the first iteration, $i = \lfloor n/2 \rfloor$. The nodes $\lfloor n/2 \rfloor + 1, \lfloor n/2 \rfloor + 2, \dots, n$ are leaves, each trivially constituting a valid max-heap.
>- **Maintenance:** Node $i$'s children ($\text{LEFT}(i) = 2i$ and $\text{RIGHT}(i) = 2i + 1$) have indices strictly greater than $i$. By the loop invariant, both children are already roots of valid max-heaps. Calling `MAX-HEAPIFY(A, i)` makes node $i$ the root of a valid max-heap while preserving the max-heap status of all nodes indexed greater than $i$. Decrementing $i$ maintains the invariant for the next iteration.
>- **Termination:** The loop terminates when $i = 0$. By the invariant, every node $1, 2, \dots, n$ is the root of a max-heap. In particular, node $1$ (the root of the entire tree) is a valid max-heap.

---

### Running Time Analysis

#### 1. Loose Upper Bound: $O(n \lg n)$
Each call to `MAX-HEAPIFY` takes $O(\lg n)$ time, and `BUILD-MAX-HEAP` makes $O(n)$ calls (specifically $\lfloor n/2 \rfloor$ calls). This provides a straightforward upper bound of $O(n \lg n)$.

#### 2. Tight Linear Bound: $O(n)$
A tighter bound accounts for the fact that the running time of `MAX-HEAPIFY` at a node of height $h$ is $O(h)$, and most nodes in a heap reside at small heights:
- An $n$-element heap has height $\lfloor \lg n \rfloor$.
- There are at most $\lceil n/2^{h+1} \rceil \le n/2^h$ nodes of any height $h$.

>[!info] Derivation of the Linear Time Bound
>The total time required to build the heap is bounded by summing the work performed at each height level $h$:
>
>$$\sum_{h=0}^{\lfloor \lg n \rfloor} \left\lceil \frac{n}{2^{h+1}} \right\rceil c h \le c n \sum_{h=0}^{\lfloor \lg n \rfloor} \frac{h}{2^h} < c n \sum_{h=0}^{\infty} \frac{h}{2^h}$$
>
>Using the infinite series identity $\sum_{h=0}^{\infty} h x^h = \frac{x}{(1 - x)^2}$ evaluated at $x = \frac{1}{2}$:
>
>$$\sum_{h=0}^{\infty} \frac{h}{2^h} = \frac{1/2}{(1 - 1/2)^2} = \frac{1/2}{1/4} = 2$$
>
>Substituting this back into the inequality yields:
>
>$$c n \sum_{h=0}^{\infty} \frac{h}{2^h} = c n (2) = O(n)$$
>
>**Breakdown:**
>- $h$ : Height of a node in the heap tree ($0 \le h \le \lfloor \lg n \rfloor$).
>- $\lceil n/2^{h+1} \rceil$ : The maximum number of nodes at height $h$.
>- $ch$ : The $O(h)$ computational cost of running `MAX-HEAPIFY` at height $h$.
>- $x = \frac{1}{2}$ : Common ratio in the geometric series expansion.
>- $O(n)$ : The resulting linear time complexity.

Thus, a max-heap can be built from an unordered array in **linear time $\Theta(n)$**.

---

### Building a Min-Heap

To construct a min-heap from an unordered array, the procedure `BUILD-MIN-HEAP` follows the identical structure as `BUILD-MAX-HEAP`, replacing the call to `MAX-HEAPIFY` with `MIN-HEAPIFY`. It similarly constructs a min-heap in **linear time $\Theta(n)$**.

## 6.4 The Heapsort Algorithm

The `HEAPSORT` procedure sorts an array $A[1 : n]$ in place by leveraging the max-heap data structure.

### How Heapsort Works

1. **Build Initial Heap:** The algorithm begins by calling `BUILD-MAX-HEAP(A, n)` to transform the input array into a valid max-heap in $O(n)$ time.
2. **Extract Maximum and Swap:** Because the largest element in the heap is at the root ($A[1]$), swapping $A[1]$ with $A[n]$ places the maximum element in its correct final position at the end of the array.
3. **Shrink Active Heap:** Decrementing $A.\text{heap-size}$ removes the placed maximum element from active heap operations without discarding it from the array.
4. **Restore Heap Property:** The new root element at $A[1]$ may violate the max-heap property, but its child subtrees remain valid max-heaps. Calling `MAX-HEAPIFY(A, 1)` restores the max-heap property over the remaining active subarray $A[1 : n - 1]$.
5. **Iterate:** The process repeats iteratively for the active heap from size $n$ down to size $2$. Each iteration places the next largest element into its correct descending index.

---

### The `HEAPSORT` Algorithm

```text
HEAPSORT(A, n)
1  BUILD-MAX-HEAP(A, n)
2  for i = n downto 2
3      exchange A[1] with A[i]
4      A.heap-size = A.heap-size - 1
5      MAX-HEAPIFY(A, 1)
```
![[Pasted image 20260926151119.png]]
Figure 6.4 The operation of HEAPSORT. (a) The max-heap data structure just after BUILD-MAXHEAP has built it in line 1. (b)–(j) The max-heap just after each call of MAX-HEAPIFY in line 5, showing the value of i at that time. Only blue nodes remain in the heap. Tan nodes contain the largest values in the array, in sorted order. (k) The resulting sorted array A.

---

### Running Time Analysis

>[!summary] Complexity Analysis of Heapsort
>The total running time of `HEAPSORT` is **$O(n \lg n)$**.
>
>**Breakdown:**
>- `BUILD-MAX-HEAP(A, n)` : Executes once at the beginning, taking $O(n)$ time.
>- `for` Loop (Lines 2–5) : Executes $n - 1$ iterations.
>- Array Element Swap and Size Decrement (Lines 3–4) : Take $\Theta(1)$ constant time per iteration.
>- `MAX-HEAPIFY(A, 1)` (Line 5) : Takes $O(\lg n)$ time on a heap of size $i$.
>
>**Total Time Formulation:**
>$$T(n) = O(n) + \sum_{i=2}^{n} O(\lg i) = O(n) + (n - 1) \cdot O(\lg n) = O(n \lg n)$$

Because heapsort operates directly within the array by swapping elements, it sorts **in place** with $O(1)$ auxiliary memory while maintaining an optimal upper bound of $O(n \lg n)$.

# Quicksort

**Quicksort** is a widely used comparison-based sorting algorithm based on the divide-and-conquer paradigm. While it exhibits a worst-case running time of $\Theta(n^2)$, it is frequently the most practical choice for sorting large datasets due to its average-case performance.

### Key Characteristics

- **Average-Case Efficiency:** When elements are distinct, quicksort has an expected running time of $\Theta(n \lg n)$ with very small hidden constant factors.
- **In-Place Sorting:** Quicksort sorts *in place*, requiring only a small auxiliary stack space for recursion rather than allocating duplicate arrays.
- **Cache and Virtual-Memory Performance:** Its memory access patterns operate efficiently within modern hierarchical memory architectures and virtual-memory systems.

>[!info] Algorithmic Performance Overview
>- **Worst-Case Running Time:** $\Theta(n^2)$ (occurs when partitions are maximally unbalanced).
>- **Expected / Average-Case Running Time:** $\Theta(n \lg n)$ (when input elements are distinct).
>- **Space Complexity:** $O(1)$ auxiliary data storage (in-place partitioning), with $O(\lg n)$ expected stack depth for recursive calls.

---

### Core Components of Quicksort

The algorithmic structure of quicksort relies on three foundational components:

1. **Partitioning:** Rearranging a subarray in place around a chosen *pivot* element such that elements smaller than the pivot appear to its left and elements larger appear to its right.
2. **Recursive Decomposition:** Recursively sorting the independent subarrays on either side of the pivot.
3. **Randomization:** Employing a randomized pivot selection strategy to ensure that no specific input ordering can consistently trigger the $\Theta(n^2)$ worst-case behavior, guaranteeing expected $O(n \lg n)$ running time across all input permutations.
## 7.1 Description of Quicksort

Quicksort applies the divide-and-conquer paradigm to sort a subarray $A[p : r]$ in place. The process consists of three core steps:

1. **Divide:** Partition (rearrange) the subarray $A[p : r]$ into two (possibly empty) subarrays:
   - The **low side:** $A[p : q - 1]$
   - The **high side:** $A[q + 1 : r]$
   such that every element in $A[p : q - 1]$ is less than or equal to the pivot element $A[q]$, and $A[q]$ is less than or equal to every element in $A[q + 1 : r]$. The index $q$ of the pivot is computed as part of this partitioning process.
2. **Conquer:** Recursively sort the two subarrays $A[p : q - 1]$ and $A[q + 1 : r]$ by invoking quicksort.
3. **Combine:** No computational work is required for the combine step. Because the subarrays are partitioned around $A[q]$ and sorted in place, the entire subarray $A[p : r]$ is completely sorted once the recursive calls complete.

To sort an entire $n$-element array $A[1 : n]$, the initial call is `QUICKSORT(A, 1, n)`.

```text
QUICKSORT(A, p, r)
1  if p < r
2      // Partition the subarray around the pivot, which ends up in A[q].
3      q = PARTITION(A, p, r)
4      QUICKSORT(A, p, q - 1)  // Recursively sort the low side
5      QUICKSORT(A, q + 1, r)  // Recursively sort the high side
```

---

### Partitioning the Array

The core operation of the algorithm is the `PARTITION` procedure, which rearranges the subarray $A[p : r]$ in place and returns the final index of the pivot element.

```text
PARTITION(A, p, r)
1  x = A[r]             // The pivot
2  i = p - 1            // Highest index of the low side
3  for j = p to r - 1   // Process each element except the pivot
4      if A[j] <= x     // Does this element belong on the low side?
5          i = i + 1    // Increment index of the low side
6          exchange A[i] with A[j]
7  exchange A[i + 1] with A[r]  // Place pivot between the two partitions
8  return i + 1                 // Return the new pivot index
```
![[Pasted image 20260926151509.png]]
Figure 7.2 The four regions maintained by the procedure PARTITION on a subarray AŒp W r�. The tan values in AŒp W i� are all less than or equal to x, the blue values in AŒi C 1 W j  1� are all greater than x, the white values in AŒj W r  1� have unknown relationships to x, and AŒr� D x.
### Partition Subarray Structure

As `PARTITION` executes, the subarray $A[p : r]$ is divided into four distinct regions:
1. **Low Side ($A[p : i]$):** Elements known to be less than or equal to the pivot ($A[k] \le x$).
2. **High Side ($A[i + 1 : j - 1]$):** Elements known to be strictly greater than the pivot ($A[k] > x$).
3. **Unexamined Elements ($A[j : r - 1]$):** Elements yet to be compared against the pivot.
4. **Pivot ($A[r]$):** The fixed pivot value $x$.

![[Pasted image 20260926151522.png]]
Figure 7.3 The two cases for one iteration of procedure PARTITION. (a) If AŒj�>x , the only action is to increment j , which maintains the loop invariant. (b) If AŒj� හ x, index i is incremented, AŒi� and AŒj� are swapped, and then j is incremented. Again, the loop invariant is maintained.

---

### Correctness: Loop Invariant Analysis

>[!summary] Loop Invariant for `PARTITION`
>**Invariant:** At the beginning of each iteration of the `for` loop (lines 3–6), for any array index $k$:
>1. If $p \le k \le i$, then $A[k] \le x$.
>2. If $i + 1 \le k \le j - 1$, then $A[k] > x$.
>3. If $k = r$, then $A[k] = x$.
>
>**Breakdown:**
>- $x$ : The pivot value $A[r]$.
>- $i$ : The boundary marker for the upper end of the low side partition ($A[k] \le x$).
>- $j$ : The current scanning index processing unexamined elements.
>
>**Proof:**
>- **Initialization:** Prior to the first iteration, $i = p - 1$ and $j = p$. The index ranges $p \le k \le i$ and $i + 1 \le k \le j - 1$ contain no elements, trivially satisfying conditions 1 and 2. Line 1 sets $x = A[r]$, satisfying condition 3.
>- **Maintenance:** Two cases arise depending on the comparison $A[j] \le x$:
>  - **Case 1 ($A[j] > x$):** Only $j$ is incremented. Condition 2 is maintained because the element placed into $A[j - 1]$ is greater than $x$, while conditions 1 and 3 remain unchanged.
>  - **Case 2 ($A[j] \le x$):** The index $i$ is incremented, $A[i]$ is swapped with $A[j]$, and $j$ is incremented. The element swapped into $A[i]$ is $\le x$ (satisfying condition 1), and the element swapped into $A[j - 1]$ is $> x$ (satisfying condition 2).
>- **Termination:** The loop runs for $r - p$ iterations and terminates when $j = r$. The unexamined region $A[j : r - 1]$ is empty, leaving every element in one of the three partitioned sets: $A[p : i] \le x$, $A[i + 1 : r - 1] > x$, and $A[r] = x$.
>
>Lines 7–8 swap the pivot $A[r]$ with $A[i + 1]$ and return $i + 1$. The pivot now resides precisely between the low and high sides, ensuring that $A[q] \le A[k]$ for all elements in the high side $A[q + 1 : r]$.

![[Pasted image 20260926151413.png]]
Figure 7.1 The operation of PARTITION on a sample array. Array entry AŒr� becomes the pivot element x. Tan array elements all belong to the low side of the partition, with values at most x. Blue elements belong to the high side, with values greater than x. White elements have not yet been put into either side of the partition, and the yellow element is the pivot x. (a) The initial array and variable settings. None of the elements have been placed into either side of the partition. (b) The value 2 is

---

### Running Time of Partition

For a subarray $A[p : r]$ containing $n = r - p + 1$ elements:
- Lines 1–2 take $\Theta(1)$ time.
- The `for` loop iterates exactly $n - 1$ times, with each iteration performing constant-time comparisons and swaps ($\Theta(1)$ work).
- Lines 7–8 take $\Theta(1)$ time.

Therefore, the running time of `PARTITION` on a subarray of size $n$ is **$\Theta(n)$**.

## 7.2 Performance of Quicksort

The running time of quicksort is governed by the balance of each partitioning step, which depends directly on the choice of pivot elements:
- **Balanced Partitions:** If the subarrays are roughly equal in size, quicksort runs asymptotically at $\Theta(n \lg n)$, matching the efficiency of merge sort.
- **Unbalanced Partitions:** If the subarrays are highly asymmetric, the running time can degrade to $\Theta(n^2)$, matching the worst-case behavior of insertion sort.

### Space Complexity and the Runtime Stack

Although quicksort sorts in place within the input array, it requires auxiliary memory on the call stack to maintain recursive state:
- Each recursive call consumes constant space $O(1)$ on the stack.
- The overall auxiliary space complexity is proportional to the maximum recursion depth.
- In the worst case, recursion depth can reach $\Theta(n)$ stack frames.
- In balanced cases, recursion depth is bounded by $O(\lg n)$ stack frames.

---

### Worst-Case Partitioning

The worst-case behavior occurs when `PARTITION` produces one subproblem containing $n - 1$ elements and one empty subproblem containing $0$ elements at every recursive level.

>[!summary] Recurrence for Worst-Case Partitioning
>Assuming maximum imbalance at every level, the running time satisfies:
>
>$$T(n) = T(n - 1) + T(0) + \Theta(n) = T(n - 1) + \Theta(n)$$
>
>**Breakdown:**
>- $T(n)$ : Worst-case execution time on an array of size $n$.
>- $T(n - 1)$ : The recursive time required to sort the unbalanced $(n-1)$-element partition.
>- $T(0) = \Theta(1)$ : The base-case cost of an empty partition.
>- $\Theta(n)$ : The linear time required to partition the current array.
>
>**Evaluation via Arithmetic Series:**
>Expanding the recurrence across all levels yields an arithmetic summation:
>
>$$T(n) = \sum_{k=1}^n \Theta(k) = \Theta\left(\sum_{k=1}^n k\right) = \Theta\left(\frac{n(n + 1)}{2}\right) = \Theta(n^2)$$

This $\Theta(n^2)$ worst-case occurs when the input array is already completely sorted (or reverse-sorted) and the last element is chosen as the pivot, forcing every element into the low partition.

---

### Best-Case Partitioning

In the most evenly balanced scenario, `PARTITION` divides the input into two subproblems of size at most $n/2$ (specifically $\lfloor (n - 1)/2 \rfloor$ and $\lceil (n - 1)/2 \rceil - 1$).

>[!summary] Recurrence for Best-Case Partitioning
>When the partition splits evenly down the middle at every stage:
>
>$$T(n) = 2T(n/2) + \Theta(n)$$
>
>**Breakdown:**
>- $2T(n/2)$ : Two recursive calls on subproblems of half size.
>- $\Theta(n)$ : Linear partitioning cost at the current level.
>
>**Solution via Master Theorem:**
>- $a = 2, b = 2 \implies n^{\log_2 2} = n^1$.
>- Driving function: $f(n) = \Theta(n) = \Theta(n^{\log_b a} \lg^0 n)$.
>- By Case 2 ($k = 0$), the recurrence evaluates to:
>
>$$T(n) = \Theta(n \lg n)$$

---

### Balanced Partitioning (Constant Proportional Splits)

Quicksort's average-case performance remains asymptotically close to the best case even when partitions appear substantially unbalanced, provided the split retains a constant proportional ratio.

>[!example] Analysis of a 9-to-1 Proportional Split
>Suppose the partitioning algorithm consistently produces a $9$-to-$1$ ratio (one subproblem of size $9n/10$ and one of size $n/10$):
>
>$$T(n) = T(9n/10) + T(n/10) + \Theta(n)$$
>
>**Recursion Tree Characteristics:**
>- **Cost Per Level:** At depth $0$, the cost is $cn$. At depth $1$, the cost is $c(n/10) + c(9n/10) = cn$. Every complete level of the recursion tree sums to at most $cn$.
>- **Shortest Path:** Follows the left branch ($n \to n/10 \to n/100 \dots$), bottoming out at depth $\log_{10} n = \Theta(\lg n)$.
>- **Longest Path:** Follows the right branch ($n \to 9n/10 \to 81n/100 \dots$), terminating at depth $\log_{10/9} n = \Theta(\lg n)$.
>
>**Total Cost:**
>$$T(n) \le (\text{Level Cost}) \times (\text{Maximum Depth}) = O(n) \times O(\lg n) = O(n \lg n)$$

Any split of constant proportionality $\alpha : (1 - \alpha)$ (for any constant $0 < \alpha < 1$, such as $99$-to-$1$) generates a recursion tree of logarithmic depth $\Theta(\lg n)$ where each level costs $O(n)$. The split ratio affects only the constant factors hidden within the asymptotic notation, preserving the overall $O(n \lg n)$ running time.
![[Pasted image 20260926151728.png]]
Figure 7.4 A recursion tree for QUICKSORT in which PARTITION always produces a 9-to-1 split, yielding a running time of O.n lg n/. Nodes show subproblem sizes, with per-level costs on the right.

---

### Intuition for the Average Case

In practical executions on random inputs, partitioning does not produce identical splits at every level; rather, it generates a mixture of balanced (`` `<good>` ``) and unbalanced (`` `<bad>` ``) splits distributed across the recursion tree.

>[!info] Absorption of Unbalanced Splits
>Suppose `` `<good>` `` (balanced $1$-to-$1$) and `` `<bad>` `` (worst-case $(n-1)$-to-$0$) splits alternate strictly from level to level:
>
>1. **Level 0 (Bad Split):** Partitioning an array of size $n$ incurs cost $\Theta(n)$ and produces subproblems of size $n - 1$ and $0$.
>2. **Level 1 (Good Split):** The $(n-1)$-sized subproblem is partitioned into two equal subproblems of size $(n-1)/2$, incurring an additional cost of $\Theta(n - 1)$.
>
>The combined two-step sequence produces subproblems of sizes $0$, $(n-1)/2$, and $(n-1)/2$ at a total partitioning cost of:
>
>$$\Theta(n) + \Theta(n - 1) = \Theta(n)$$
>
>Because this combined cost is asymptotically identical to a single balanced partition of size $n$, the non-recursive overhead of the `` `<bad>` `` split is absorbed into the `` `<good>` `` split. 

Consequently, the overall recursion tree height remains $O(\lg n)$, and the expected running time for quicksort across random permutations of distinct elements remains bounded by **$O(n \lg n)$**.
![[Pasted image 20260926151742.png]]
Figure 7.5 (a) Two levels of a recursion tree for quicksort. The partitioning at the root costs n
and produces a <bad= split: two subarrays of sizes 0 and n  1. The partitioning of the subarray of
size n  1 costs n  1 and produces a <good= split: subarrays of size .n  1/=2  1 and .n  1/=2.
(b) A single level of a recursion tree that is well balanced. In both parts, the partitioning cost for the
subproblems shown with blue shading is ‚.n/. Yet the subproblems remaining to be solved in (a),
shown with tan shading, are no larger than the corresponding subproblems remaining to be solved
in (b). 

## 8.2 Counting Sort

**Counting sort** is a linear-time sorting algorithm that operates under the assumption that each of the $n$ input elements is an integer in the range $0$ to $k$, for some integer $k$.

Unlike comparison-based algorithms, counting sort does not compare elements against one another. Instead, it uses the actual values of the elements as array indices to count frequencies and calculate exact output positions, allowing it to bypass the $\Omega(n \lg n)$ lower bound for comparison sorting.

---

### The `COUNTING-SORT` Algorithm

The procedure takes an input array $A[1 : n]$, the number of elements $n$, and the maximum integer value $k$. It writes the sorted output to an array $B[1 : n]$ and utilizes an auxiliary array $C[0 : k]$ for temporary working storage.

```text
COUNTING-SORT(A, n, k)
1  let B[1 : n] and C[0 : k] be new arrays
2  for i = 0 to k
3      C[i] = 0
4  for j = 1 to n
5      C[A[j]] = C[A[j]] + 1
6  // C[i] now contains the number of elements equal to i.
7  for i = 1 to k
8      C[i] = C[i] + C[i - 1]
9  // C[i] now contains the number of elements less than or equal to i.
10 // Copy A to B, starting from the end of A.
11 for j = n downto 1
12     B[C[A[j]]] = A[j]
13     C[A[j]] = C[A[j]] - 1  // Handle duplicate values
14 return B
```
![[Pasted image 20260926151951.png]]
Figure 8.2 The operation of COUNTING-SORT on an input array AŒ1 W 8�, where each element of A is a nonnegative integer no larger than k D 5. (a) The array A and the auxiliary array C after line 5. (b) The array C after line 8. (c)–(e) The output array B and the auxiliary array C after one, two, and three iterations of the loop in lines 11313, respectively. Only the tan elements of array B have been ûlled in. (f) The ûnal sorted output array B.

---

### Step-by-Step Operation

1. **Initialize Working Storage (Lines 2–3):** Initialize every entry of $C[0 : k]$ to $0$ in $\Theta(k)$ time.
2. **Count Element Frequencies (Lines 4–5):** Iterate through input array $A[1 : n]$. For each element $A[j]$, increment $C[A[j]]$. After this pass, $C[i]$ holds the exact count of input elements equal to $i$ (taking $\Theta(n)$ time).
3. **Compute Prefix Sums (Lines 7–8):** Accumulate the values in $C$ by computing running sums. After this step, each entry $C[i]$ contains the total number of input elements that are *less than or equal to* $i$ (taking $\Theta(k)$ time).
4. **Populate the Output Array (Lines 11–13):** Iterate through $A$ in reverse order from index $n$ down to $1$:
   - The value $C[A[j]]$ gives the correct final index for $A[j]$ in the output array $B$.
   - Place $A[j]$ into $B[C[A[j]]]$.
   - Decrement $C[A[j]]$ by $1$. If another element with the same value appears earlier in $A$, it will be placed in the position immediately preceding this one.

---

### Running Time and Complexity

>[!summary] Complexity of Counting Sort
>The total running time of `COUNTING-SORT` is:
>
>$$T(n) = \Theta(n + k)$$
>
>**Breakdown:**
>- $n$ : The number of elements in the input array $A[1 : n]$.
>- $k$ : The range limit of the input values ($0 \le A[j] \le k$).
>- $\Theta(k)$ : Time to initialize $C$ (lines 2–3) and compute running prefix sums (lines 7–8).
>- $\Theta(n)$ : Time to count input frequencies (lines 4–5) and populate the output array $B$ (lines 11–13).
>
>**Linear Time Condition:**
>When the range of input values is linearly proportional to the number of elements ($k = O(n)$), the running time simplifies to **$\Theta(n)$**.

---

### Stability in Counting Sort

>[!info] Definition: Stable Sorting
>A sorting algorithm is **stable** if elements with identical key values appear in the output array in the exact same relative order as they appeared in the input array.

Counting sort achieves stability by iterating through the input array in reverse order (from $j = n$ downto $1$) in line 11:
- The rightmost instance of duplicate keys in $A$ is processed first and placed at index $C[A[j]]$.
- Decrementing $C[A[j]]$ ensures that the preceding duplicate key in $A$ is placed at index $C[A[j]] - 1$, preserving their original relative sequence.

Stability is essential when sorting records that contain *satellite data* associated with each key, and it is a required property when counting sort is employed as an intermediate subroutine in **radix sort**.

## 8.3 Radix Sort

**Radix sort** is a non-comparison sorting algorithm historically developed for mechanical card-sorting machines. A card sorter could be mechanically `` `<programmed>` `` to inspect a single column at a time and distribute cards into one of 12 distinct bins. 

When sorting numbers with $d$ digits, two general strategies exist:
- **Most Significant Digit (MSD) First:** Sorting on the leftmost (most significant) digit first requires partitioning elements into separate bins and recursively sorting each bin independently. This generates numerous intermediate sub-piles that must be tracked and maintained separately.
- **Least Significant Digit (LSD) First:** Sorting on the rightmost (least significant) digit first allows the entire dataset to be gathered into a single collection after each pass. By repeating the process from digit $1$ up to digit $d$, the entire array becomes completely sorted in exactly $d$ passes without creating intermediate sub-piles.

---

### The `RADIX-SORT` Algorithm

The procedure assumes that every element in array $A[1 : n]$ consists of $d$ digits, where digit $1$ is the lowest-order (least significant) digit and digit $d$ is the highest-order (most significant) digit.

```text
RADIX-SORT(A, n, d)
1  for i = 1 to d
2      use a stable sort to sort array A[1 : n] on digit i
```
![[Pasted image 20260926152056.png]]
Figure 8.3 The operation of radix sort on seven 3-digit numbers. The leftmost column is the input. The remaining columns show the numbers after successive sorts on increasingly signiûcant digit positions. Tan shading indicates the digit position sorted on to produce each list from the previous one

>[!important] The Necessity of Stability
>In order for radix sort to operate correctly, the intermediate sorting algorithm used on each digit pass **must be stable**. 
>
>When sorting on digit $i$, a stable sort preserves the relative order established by the previous passes on digits $1, 2, \dots, i - 1$. If two elements share the same value in digit $i$, stability guarantees that the element with the smaller value in the lower-order digits remains first in the array.

---

### Sorting Records with Multi-Field Keys

Radix sort applies directly to records categorized by multiple hierarchical fields:

>[!example] Multi-Key Date Sorting
>To sort calendar dates defined by three keys—**Year**, **Month**, and **Day**:
>
>- **Approach 1 (Composite Comparison):** Compare years first; break ties by comparing months; break remaining ties by comparing days.
>- **Approach 2 (Radix Sort with Stable Passes):** Execute three successive passes using a stable sort from least significant to most significant field:
>  1. **Pass 1:** Sort all dates stably by **Day** (least significant component).
>  2. **Pass 2:** Sort all dates stably by **Month**.
>  3. **Pass 3:** Sort all dates stably by **Year** (most significant component).
>
>After Pass 3, the dataset is completely ordered by Year, then Month, then Day.

---

### Practical Implementation Considerations

- **Choice of Subroutine:** In practice, `COUNTING-SORT` is most commonly employed as the stable digit-sorting subroutine because the range of values for a single digit (e.g., $0$ to $9$ for decimal numbers) is small and fixed.
- **Memory Optimization:** Rather than allocating and deallocating working storage during each of the $d$ passes, the auxiliary output array can be preallocated once. The algorithm then alternates (toggles) the roles of the input and output arrays across successive iterations of the loop.

### Running Time Analysis of Radix Sort

The computational complexity of radix sort depends directly on the number of passes $d$ and the efficiency of the underlying stable sorting subroutine.

>[!summary] Lemma 8.3: Running Time of General Radix Sort
>Given $n$ $d$-digit numbers in which each digit can take on up to $k$ possible values, `RADIX-SORT` correctly sorts these numbers in $\Theta(d(n + k))$ time if the intermediate stable sort runs in $\Theta(n + k)$ time.
>
>**Breakdown:**
>- $n$ : The number of items to sort.
>- $d$ : The number of digits in each key.
>- $k$ : The number of possible values each digit can assume (the radix/base).
>- $\Theta(n + k)$ : The running time of a single pass of counting sort.
>- $\Theta(d(n + k))$ : The total running time across all $d$ stable passes.
>
>**Proof:**
>Correctness is established by mathematical induction on the digit index being sorted. For running time, when each digit lies in the range $0$ to $k - 1$, counting sort executes in $\Theta(n + k)$ time per pass. Performing $d$ sequential passes yields an overall running time of:
>
>$$T(n) = d \cdot \Theta(n + k) = \Theta(d(n + k))$$

When $d$ is a constant and the range of digit values satisfies $k = O(n)$, radix sort executes in **linear time $\Theta(n)$**.

---

### Bit-Level Key Decomposition

When keys are represented as fixed-width binary words on a computer, each key can be segmented into multi-bit chunks to balance the number of passes against the work per pass.

>[!summary] Lemma 8.4: Radix Sort on Binary Words
>Given $n$ $b$-bit numbers and any positive integer $r \le b$, `RADIX-SORT` correctly sorts these numbers in $\Theta\left(\frac{b}{r}(n + 2^r)\right)$ time when using an intermediate stable sort that runs in $\Theta(n + k)$ time for keys in the range $0$ to $k$.
>
>**Breakdown:**
>- $b$ : Total number of bits in each binary word.
>- $r$ : The number of bits allocated to each digit chunk ($r \le b$).
>- $d = \lceil b/r \rceil$ : The total number of passes (digit chunks).
>- $2^r$ : The number of distinct values an $r$-bit chunk can assume ($k = 2^r - 1$).
>- $\Theta\left(\frac{b}{r}(n + 2^r)\right)$ : The composite running time.
>
>**Proof:**
>Break each $b$-bit key into $d = \lceil b/r \rceil$ digits of $r$ bits each. Each $r$-bit digit represents an integer in the range $0$ to $2^r - 1$. 
>
>Using counting sort with $k = 2^r - 1$, each pass takes $\Theta(n + 2^r)$ time. Multiplying by the $d = \lceil b/r \rceil$ passes yields:
>
>$$T(n) = \Theta\left(\left\lceil \frac{b}{r} \right\rceil (n + 2^r)\right) = \Theta\left(\frac{b}{r}(n + 2^r)\right)$$

---

### Choosing the Optimal Chunk Size ($r$)

To minimize the running time $\Theta\left(\frac{b}{r}(n + 2^r)\right)$ for given values of $n$ and $b$:
- Decreasing $r$ reduces the digit range $2^r$ but increases the number of passes $b/r$.
- Increasing $r$ decreases the number of passes $b/r$ but exponentially increases the digit range $2^r$.

The optimal choice of $r$ depends on the magnitude of $b$ relative to $\lfloor \lg n \rfloor$:

1. **Short Keys ($b < \lfloor \lg n \rfloor$):**
   - Setting $r = b$ requires only $d = 1$ pass.
   - Since $2^b \le n$, the term $n + 2^b = \Theta(n)$.
   - The running time simplifies to $\Theta(n)$, which is asymptotically optimal.

2. **Long Keys ($b \ge \lfloor \lg n \rfloor$):**
   - Choosing $r = \lfloor \lg n \rfloor$ yields the optimal running time:
     $$T(n) = \Theta\left(\frac{b n}{\lg n}\right)$$
   - If $r$ is chosen significantly larger than $\lfloor \lg n \rfloor$, the $2^r$ term grows exponentially faster than the denominator $r$, driving the runtime to $\Omega\left(\frac{b n}{\lg n}\right)$.
   - If $r$ is chosen significantly smaller than $\lfloor \lg n \rfloor$, the pass count $b/r$ increases while the per-pass cost remains $\Theta(n)$.

---

### Radix Sort vs. Comparison-Based Sorts (Quicksort)

When sorting $n$ words of length $b = O(\lg n)$ bits, setting $r \approx \lg n$ allows radix sort to achieve a linear asymptotic running time of $\Theta(n)$, seemingly outperforming quicksort's expected $\Theta(n \lg n)$ time. 

However, several practical considerations influence which algorithm is preferred:

- **Constant Factors:** Although radix sort performs fewer total passes over the keys than quicksort, each pass of counting sort requires multiple array traversals, prefix-sum computations, and indirect memory writes, making individual passes computationally heavier.
- **Hardware Cache Utilization:** Quicksort accesses sequential blocks of memory during its partitioning step, leveraging hardware cache hierarchies effectively. Counting sort performs scattered writes based on computed indices, resulting in higher cache-miss rates.
- **Memory Overhead:** Counting-sort-based radix sort requires an auxiliary array of size $\Theta(n)$ and temporary counter storage of size $\Theta(2^r)$, meaning it does not sort in place. When primary memory is constrained, in-place comparison algorithms like quicksort or heapsort are often preferred.

## 8.4 Bucket Sort

**Bucket sort** is a distribution-based sorting algorithm that runs in **linear expected time $\Theta(n)$** when its input is drawn from a uniform and independent random distribution.

Unlike counting sort, which assumes elements are integers spanning a restricted range, bucket sort assumes that input values are real numbers uniformly distributed across the half-open interval $[0, 1)$.

---

### Core Concept and Algorithmic Strategy

1. **Interval Partitioning:** The continuous interval $[0, 1)$ is partitioned into $n$ equal-sized subintervals, or **buckets**, each spanning a width of $1/n$:
   $$[0, 1/n), [1/n, 2/n), \dots, [(n-1)/n, 1)$$
2. **Scatter Phase:** The $n$ input numbers are distributed into their corresponding buckets using a floor calculation: an element $A[i]$ maps to bucket index $\lfloor n \cdot A[i] \rfloor$.
3. **Sort Phase:** Because values are distributed uniformly and independently, each individual bucket contains relatively few elements. Each bucket is sorted individually using insertion sort.
4. **Gather Phase:** The sorted contents of the buckets are concatenated sequentially from bucket $0$ through bucket $n - 1$ to form the final sorted output.

---

### The `BUCKET-SORT` Algorithm

The procedure assumes an input array $A[1 : n]$ where each entry satisfies $0 \le A[i] < 1$. It utilizes an auxiliary array $B[0 : n - 1]$ of linked lists to represent the individual buckets.

```text
BUCKET-SORT(A, n)
1  let B[0 : n - 1] be a new array
2  for i = 0 to n - 1
3      make B[i] an empty list
4  for i = 1 to n
5      insert A[i] into list B[⌊n * A[i]⌋]
6  for i = 0 to n - 1
7      sort list B[i] with insertion sort
8  concatenate the lists B[0], B[1], ..., B[n - 1] together in order
9  return the concatenated lists
```
![[Pasted image 20260926152355.png]]
Figure 8.4 The operation of BUCKET-SORT for n D 10. (a) The input array AŒ1 W 10�. (b) The array BŒ0 W 9� of sorted lists (buckets) after line 7 of the algorithm, with slashes indicating the end of each bucket. Bucket i holds values in the half-open interval Œi=10; .i C 1/=10/. The sorted output consists of a concatenation of the lists BŒ0�; BŒ1�; : : : ; BŒ9� in order.

---

### Correctness

Consider any two elements $A[i]$ and $A[j]$, and assume without loss of generality that $A[i] \le A[j]$:
- Computing bucket indices yields $\lfloor n \cdot A[i] \rfloor \le \lfloor n \cdot A[j] \rfloor$.
- **Same Bucket ($\lfloor n \cdot A[i] \rfloor = \lfloor n \cdot A[j] \rfloor$):** Both elements are placed into the same linked list $B[k]$. The subsequent insertion sort pass (lines 6–7) orders them correctly.
- **Different Buckets ($\lfloor n \cdot A[i] \rfloor < \lfloor n \cdot A[j] \rfloor$):** Element $A[i]$ is placed into a bucket with a strictly smaller index than the bucket containing $A[j]$. Because concatenation (line 8) preserves bucket ordering from $B[0]$ to $B[n-1]$, $A[i]$ precedes $A[j]$ in the final concatenated output.

Thus, all elements are placed in globally sorted order.

---

### Running Time and Probabilistic Analysis

All operations outside the bucket-sorting loop (lines 1–5 and line 8) require $\Theta(n)$ time in total. The overall running time is therefore dominated by the $n$ calls to insertion sort on the individual buckets.

Let $n_i$ be the random variable denoting the number of elements placed into bucket $B[i]$. Because insertion sort runs in quadratic time with respect to the bucket size, the total running time $T(n)$ satisfies:

$$T(n) = \Theta(n) + \sum_{i=0}^{n-1} O(n_i^2)$$

**Breakdown:**
- $T(n)$ : Total running time of bucket sort.
- $n$ : Total number of elements in the input array.
- $n_i$ : The random variable representing the number of items that fall into bucket $B[i]$.
- $O(n_i^2)$ : The quadratic running time required by insertion sort to sort bucket $B[i]$.
- $\sum_{i=0}^{n-1}$ : Summation over all $n$ buckets ($i = 0, 1, \dots, n-1$).

Taking the mathematical expectation of both sides and applying the linearity of expectation:

$$E[T(n)] = \Theta(n) + \sum_{i=0}^{n-1} O(E[n_i^2])$$

---

### Derivation of the Expected Bucket Cost $E[n_i^2]$

>[!summary] Lemma: Second Moment of Bucket Occupancy
>For an array of $n$ elements distributed independently and uniformly across $n$ buckets:
>
>$$E[n_i^2] = 2 - \frac{1}{n}$$
>
>**Breakdown:**
>- $n_i$ : The number of elements assigned to bucket $B[i]$.
>- $E[n_i^2]$ : The expected value of the square of the number of elements in bucket $B[i]$.
>- $\text{Var}(n_i)$ : The variance of the random variable $n_i$.
>- $E[n_i]$ : The expected number of elements in bucket $B[i]$.
>- $p = 1/n$ : The probability that any single element lands in bucket $B[i]$.
>
>**Proof:**
>Each element placement can be modeled as a Bernoulli trial where `` `<success>` `` corresponds to an element falling into bucket $B[i]$. 
>
>Because the input is uniformly distributed across $[0, 1)$, each element has probability $p = 1/n$ of landing in bucket $B[i]$ and probability $q = 1 - 1/n$ of landing elsewhere. The total count $n_i$ follows a Binomial distribution $\text{Binomial}(n, p)$:
>
>$$E[n_i] = n \cdot p = n\left(\frac{1}{n}\right) = 1$$
>$$\text{Var}(n_i) = n \cdot p \cdot q = n\left(\frac{1}{n}\right)\left(1 - \frac{1}{n}\right) = 1 - \frac{1}{n}$$
>
>Using the variance identity $E[n_i^2] = \text{Var}(n_i) + (E[n_i])^2$:
>
>$$E[n_i^2] = \left(1 - \frac{1}{n}\right) + (1)^2 = 2 - \frac{1}{n}$$

---

### Total Expected Running Time

Substituting $E[n_i^2] = 2 - 1/n$ back into the expected running time equation:

$$E[T(n)] = \Theta(n) + \sum_{i=0}^{n-1} O\left(2 - \frac{1}{n}\right) = \Theta(n) + n \cdot O(1) = \Theta(n)$$

Thus, the average-case running time of bucket sort is **$\Theta(n)$**.

>[!note] Generalization to Non-Uniform Inputs
>Bucket sort does not strictly require a uniform distribution to achieve linear performance. As long as the input distribution guarantees that the sum of the squares of bucket sizes scales linearly with the input size ($\sum_{i=0}^{n-1} E[n_i^2] = O(n)$), bucket sort will execute in **linear time $O(n)$**.