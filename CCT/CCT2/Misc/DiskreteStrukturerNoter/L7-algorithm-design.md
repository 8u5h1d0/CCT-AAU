# L7 — Algorithm Design: Sorting, Recursion & Greedy (≈2h block)

**Topic & reading**: Design paradigms, sorting (bubble/insertion/merge), recursive functions & sets, recursive algorithms & their correctness by induction, recursion vs iteration, greedy methods — Rosen **Ch. 3, 5.4, 5.5**; **Cormen 2.1** (Lecture 7).

Exam relevance: Part 2. Expect: trace a sort, write/analyse a recursive algorithm, prove a recursive algorithm correct by induction, give a greedy solution.

---

## Design paradigms

- **Brute-force** — straightforward from the problem statement, ignores structure (e.g. find max by scanning).
- **Greedy (grådig)** — at each step take the apparent local optimum, ignoring global look-ahead. Fast; optimal **only** for problems with the greedy-choice property (e.g. some change-making, scheduling).
- **Divide-and-conquer** — divide → conquer (recurse) → combine (e.g. merge sort, binary search).
- **Dynamic programming** — like D&C but **reuses** overlapping subresults (e.g. iterative Fibonacci).

## Sorting algorithms

**Bubble sort** — repeatedly swap adjacent out-of-order pairs; largest "bubbles" to the end each pass.
```
procedure bubblesort(a1,…,an)         // n ≥ 2
  for i := 1 to n-1
     for j := 1 to n-i
        if aj > aj+1 then swap aj, aj+1
```
Worst/average $\Theta(n^2)$, best $\Theta(n)$ (if optimised to stop when no swaps).

**Insertion sort** — grow a sorted prefix; insert each new element into its place.
Worst/average $\Theta(n^2)$, best $\Theta(n)$ (already sorted). Good on small/nearly-sorted inputs.

**Merge sort** — divide-and-conquer:
```
procedure mergesort(L = a1,…,an)
  if n > 1
     m := ⌊n/2⌋
     L1 := a1,…,am ;  L2 := am+1,…,an
     L := merge(mergesort(L1), mergesort(L2))
  return L
```
`merge` of sorted lists of sizes $m,n$ uses **≤ $m+n-1$ comparisons** (Lemma). Overall $\Theta(n\log n)$ — the recurrence $T(n)=2T(n/2)+\Theta(n)$.

| Sort | Best | Average | Worst | Paradigm |
|---|---|---|---|---|
| Bubble | $\Theta(n)$ | $\Theta(n^2)$ | $\Theta(n^2)$ | brute-force |
| Insertion | $\Theta(n)$ | $\Theta(n^2)$ | $\Theta(n^2)$ | incremental |
| Merge | $\Theta(n\log n)$ | $\Theta(n\log n)$ | $\Theta(n\log n)$ | divide-and-conquer |

## Recursion

- **Recursive function** — base step (value at 0) + recursive step (value from smaller). E.g. $n!$: $0!=1,\ n!=n\cdot(n-1)!$.
- **Recursive set** — base clause + recursive clause + extremal clause (see [[L3-induction-recursion]]).
- **Recursive algorithm** — solves a problem by reducing to a smaller instance of the same problem.

```
Algorithm factorial(n)         Algorithm power(a, n)        Algorithm fibonacci(n)
  if n = 0 return 1              if n = 0 return 1            if n = 0 return 0
  else return n·factorial(n-1)   else return a·power(a,n-1)   else if n = 1 return 1
                                                              else return fib(n-1)+fib(n-2)
```
**Binary search (recursive)** — needs a **sorted** list; halves the range each call ⇒ $O(\log n)$:
```
Algorithm bsearch(i, j, x):
  m := ⌊(i+j)/2⌋
  if x = am          return m
  else if x < am and i < m   return bsearch(i, m-1, x)
  else if x > am and j > m   return bsearch(m+1, j, x)
  else                       return 0
```

**Recursion vs iteration** — naïve recursive Fibonacci recomputes subproblems ⇒ exponential $\Theta(\varphi^n)$; the iterative version is $\Theta(n)$. Recursion is clearer; iteration is usually faster/less memory.

## Correctness of recursive algorithms (by induction)

Use (strong) **induction** on the size parameter.

**Claim:** `power(a,n)` returns $a^n$ for $n\ge0$, $a>0$.
- **Basis** $n=0$: returns $1=a^0$. ✓
- **Inductive step:** assume `power(a,k)`$=a^k$. Then `power(a,k+1)`$=a\cdot\text{power}(a,k)=a\cdot a^k=a^{k+1}$. ✓ $\blacksquare$

## Practice problems

1. Trace bubble sort on $3,2,4,1,5$ — list the array after each pass.
2. Trace merge of the sorted lists $2,3,5,6$ and $1,4$; count comparisons.
3. Write a recursive algorithm for $\sum_{i=1}^n i$ and prove it correct by induction.
4. Coins $\{1,5,10,25\}$: give the greedy change for 63. Does greedy always give the fewest coins for arbitrary coin sets? 
5. Why is recursive Fibonacci exponential but iterative linear?

<details><summary>Solutions</summary>

1. Pass1: $2,3,1,4,5$. Pass2: $2,1,3,4,5$. Pass3: $1,2,3,4,5$. Pass4: $1,2,3,4,5$ (sorted).
2. Compare 1<2 (take 1), 2<4 (2), 3<4 (3), 4<5 (4), then 5,6 appended → $1,2,3,4,5,6$; 4 comparisons ($\le m+n-1=5$).
3. `sum(n): if n=0 return 0 else return n+sum(n-1)`. Basis $n=0$: 0 ✓. Step: `sum(k+1)=(k+1)+sum(k)=(k+1)+\frac{k(k+1)}2=\frac{(k+1)(k+2)}2$ ✓.
4. $25+25+10+1+1+1$ = 6 coins. Not always optimal: for coins $\{1,3,4\}$ and amount 6, greedy gives $4+1+1$ (3) but $3+3$ (2) is better.
5. Recursive recomputes shared subcalls (a binary tree of size $\Theta(\varphi^n)$); iterative computes each $F_i$ once, storing the last two ⇒ $n$ steps.
</details>

## Common pitfalls / exam tips
- Binary search **requires a sorted list** — state it as a precondition (ties to [[L5-algorithms-correctness]]).
- Greedy is not always optimal — be ready to give a counterexample.
- Prove recursive correctness with **induction on the input size**, mirroring the recursion's base/recursive split.
- Know the three sort complexities cold (see [[L6-growth-asymptotics]]); merge sort's $n\log n$ comes from the $T(n)=2T(n/2)+n$ recurrence.
