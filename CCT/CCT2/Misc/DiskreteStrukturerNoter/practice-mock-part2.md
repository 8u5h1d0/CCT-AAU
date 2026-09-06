# Mock exam — Part 2 (algorithms & data structures, L5–8)

**Time:** 90 min · **Total:** 100 points · Closed book, one-page formula sheet allowed.
Covers algorithms & correctness (L5), growth/asymptotics (L6), sorting/recursion/greedy (L7), data structures (L8). Attempt all before checking solutions; show full reasoning.

---

## Problems

**1. Algorithm properties & specification (12 p).**
(a) List the seven essential properties an algorithm must have.
(b) Write a precondition and postcondition for an algorithm `index_of_min(A)` that returns the position of the smallest element of a non-empty integer array.
(c) State the difference between partial and total correctness in one sentence each.

**2. Loop-invariant proof (18 p).**
Consider:
```
procedure sum_to(n : positive integer)
  s := 0
  for i := 1 to n
     s := s + i
  return s
```
(a) State a loop invariant relating `s` and `i`.
(b) Prove correctness using Initialization, Maintenance, Termination — concluding the postcondition $s=\sum_{j=1}^n j$.
(c) Is this partial or total correctness? Justify.

**3. Asymptotic notation (18 p).**
(a) Using the definition with explicit witnesses $C,k$, prove $4n^2+10n+6=O(n^2)$.
(b) Show that $n^2 \neq O(n)$.
(c) Rank these by growth (slowest → fastest): $n!,\ n\log n,\ 2^n,\ \log n,\ n^2,\ n$.

**4. Complexity of code (14 p).**
Give the tight $\Theta$ time complexity of each, with a one-line justification:
```
(a) for i := 1 to n        (b) for i := 1 to n        (c) i := n
       x := x + 1                for j := i to n            while i > 1
                                    x := x + 1                 i := i / 2
```

**5. Sorting (16 p).**
(a) Trace **insertion sort** on the list $5,2,4,6,1,3$ — show the array after each element is inserted.
(b) Give the best-, average-, and worst-case complexity of bubble, insertion and merge sort.
(c) Explain in two sentences why merge sort is $\Theta(n\log n)$.

**6. Recursion & correctness (12 p).**
```
Algorithm power(a, n)         // n ≥ 0
  1. if n = 0 return 1
  2. else return a · power(a, n-1)
```
(a) What is the time complexity in terms of $n$?
(b) Prove by induction that `power(a,n)` returns $a^n$.
(c) Why is the naïve recursive Fibonacci algorithm exponential while an iterative version is $\Theta(n)$?

**7. Data structures (10 p).**
(a) Starting from an empty stack, perform `PUSH 4, PUSH 7, POP, PUSH 9, POP, POP`. State what each POP returns and the final stack.
(b) For a max-heap stored 1-indexed in an array, give the indices of the parent, left child and right child of the node at index 5.
(c) Why is search on an unsorted linked list $O(n)$ but lookup in a direct-address table $O(1)$? What is the table's cost?

---

## Solutions

**1.**
(a) Input, output, correctness, definiteness, finiteness (terminates), effectiveness (each step doable), generality.
(b) **Pre:** $A[1..n]$ is an integer array with $n\ge1$. **Post:** returns index $j$ with $1\le j\le n$ and $A[j]\le A[k]$ for all $1\le k\le n$.
(c) **Partial:** *if* the algorithm halts, its output satisfies the postcondition. **Total:** partial correctness *and* the algorithm always halts.

**2.**
(a) Invariant: *before the iteration with loop counter $i$, $s=\sum_{j=1}^{i-1} j$* (equivalently, after processing the first $i$ values, $s=\sum_{j=1}^{i} j$).
(b)
- **Initialization:** before the first iteration $i=1$ and $s=0=\sum_{j=1}^{0}j$ (empty sum). ✓
- **Maintenance:** assume $s=\sum_{j=1}^{i-1}j$ before iteration $i$. The body sets $s:=s+i=\sum_{j=1}^{i-1}j+i=\sum_{j=1}^{i}j$, which is the invariant for the next value of the counter. ✓
- **Termination:** the loop ends after $i=n$, so $s=\sum_{j=1}^{n}j$, the postcondition. ✓
(c) **Total correctness:** the `for` loop runs a fixed $n$ times and then returns, so it always halts; combined with the proof above this is total correctness.

**3.**
(a) For $n>1$: $4n^2+10n+6\le 4n^2+10n^2+6n^2=20n^2$. Witnesses $C=20,\ k=1$. Hence $O(n^2)$.
(b) Suppose $n^2\le Cn$ for all $n>k$. Dividing by $n>0$ gives $n\le C$, which fails as soon as $n>\max(C,k)$. No constants work ⇒ $n^2\neq O(n)$.
(c) $\log n \prec n \prec n\log n \prec n^2 \prec 2^n \prec n!$.

**4.**
(a) $\Theta(n)$ — single loop of $n$ constant-time iterations.
(b) $\Theta(n^2)$ — inner loop runs $n-i+1$ times; total $\sum_{i=1}^n(n-i+1)=\frac{n(n+1)}2=\Theta(n^2)$.
(c) $\Theta(\log n)$ — $i$ is halved each iteration, so about $\log_2 n$ iterations.

**5.**
(a) Insertion sort (sorted prefix grows; insert each new element):
- start $5,2,4,6,1,3$
- insert 2: $2,5,4,6,1,3$
- insert 4: $2,4,5,6,1,3$
- insert 6: $2,4,5,6,1,3$ (already in place)
- insert 1: $1,2,4,5,6,3$
- insert 3: $1,2,3,4,5,6$ ✓
(b) Bubble: best $\Theta(n)$, avg/worst $\Theta(n^2)$. Insertion: best $\Theta(n)$, avg/worst $\Theta(n^2)$. Merge: $\Theta(n\log n)$ in all cases.
(c) Merge sort splits the list in half each level, giving $\log_2 n$ levels; merging the sorted halves costs $\Theta(n)$ work per level (a merge of sizes $m,n$ uses $\le m+n-1$ comparisons). Total $\Theta(n\log n)$, from the recurrence $T(n)=2T(n/2)+\Theta(n)$.

**6.**
(a) $\Theta(n)$ — one recursive call per decrement of $n$, constant work each, $n+1$ calls.
(b) **Basis** $n=0$: lines 1–2 return $1=a^0$. ✓ **IH:** assume `power(a,k)`$=a^k$. **Step:** for $n=k+1>0$, line 2 returns $a\cdot\text{power}(a,k)\overset{IH}{=}a\cdot a^k=a^{k+1}$. By induction `power(a,n)`$=a^n$ for all $n\ge0$. $\blacksquare$
(c) Naïve recursive Fibonacci recomputes the same subproblems repeatedly — the call tree has $\Theta(\varphi^n)$ nodes (exponential). The iterative version computes each $F_i$ exactly once, keeping only the previous two values, so it does $\Theta(n)$ work.

**7.**
(a) `POP` returns **7**, then **9**, then **4**; final stack is **empty**. (Stack contents: after PUSH 4 →[4]; PUSH 7→[4,7]; POP→7, [4]; PUSH 9→[4,9]; POP→9, [4]; POP→4, [].)
(b) `PARENT(5)=⌊5/2⌋=2`, `LEFT(5)=2·5=10`, `RIGHT(5)=2·5+1=11`.
(c) An unsorted linked list has no positional index, so search follows `next` pointers and may visit all $n$ nodes ⇒ $O(n)$. A direct-address table uses the key itself as the array index ⇒ $O(1)$, but it must allocate an array as large as the entire key universe $|U|$ ⇒ large space cost.

---

### Self-grading
Tally points. Below ~70: re-read [[L5-algorithms-correctness]], [[L6-growth-asymptotics]], [[L7-algorithm-design]], [[L8-data-structures]] and redo missed items from a blank page. Loop-invariant proofs and asymptotic-bound proofs carry the most points and the most partial credit — practise writing them in full.
