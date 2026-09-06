# L6 — Growth of Functions & Asymptotic Notation (≈2h block)

**Topic & reading**: Big-O, Big-Ω, Big-Θ, growth comparisons, complexity of algorithms — Rosen **3.2** and **Cormen Ch. 3** (Lecture 6). One of the harder Part-2 topics.

Exam relevance: Part 2. Expect "give a Big-O / prove a bound with witnesses $C,k$" and "find time complexity of this loop".

---

## Key definitions (with witnesses)

For functions $f,g:\mathbb{Z}^+\to\mathbb{R}$:

- **Big-O (øvre grænse)** — $f(n)=O(g(n))$ iff $\exists\,C>0,\ k$ such that $|f(n)|\le C\,|g(n)|$ for all $n>k$. ("$g$ is an upper bound up to a constant.") The pair $(C,k)$ are the **witnesses**.
- **Big-Ω (nedre grænse)** — $f(n)=\Omega(g(n))$ iff $\exists\,C>0,\ k$ with $|f(n)|\ge C\,|g(n)|$ for $n>k$.
- **Big-Θ (skarp grænse)** — $f(n)=\Theta(g(n))$ iff $f=O(g)$ **and** $f=\Omega(g)$; $f$ and $g$ grow at the same rate.

## Theorems & formulas

- **Polynomials**: if $f(n)=a_d n^d+\dots+a_0$ with $a_d\neq0$, then $f(n)=\Theta(n^d)$. (Drop lower terms and constant factors.)
- **Sum rule**: $O(f)+O(g)=O(\max(f,g))$. **Product rule**: $O(f)\cdot O(g)=O(fg)$.
- $\log_a n=\Theta(\log_b n)$ — log base is irrelevant inside $O$.
- $\sum_{i=1}^n i=\Theta(n^2)$; $n!=O(n^n)$; $\log(n!)=\Theta(n\log n)$.
- **Growth hierarchy** (slowest → fastest growing):
$$1 \prec \log n \prec n \prec n\log n \prec n^2 \prec n^3 \prec 2^n \prec n!.$$

| Complexity | Name | Example |
|---|---|---|
| $O(1)$ | constant | array index, stack push/pop |
| $O(\log n)$ | logarithmic | binary search |
| $O(n)$ | linear | linear search, max of list |
| $O(n\log n)$ | linearithmic | merge sort |
| $O(n^2)$ | quadratic | bubble/insertion sort (worst) |
| $O(2^n)$ | exponential | naïve recursive Fibonacci, subsets |
| $O(n!)$ | factorial | brute-force permutations / TSP |

- **Time vs space complexity**: $T(n)=O(f(n))$ counts operations; $S(n)=O(g(n))$ counts memory.
- **Best / worst / average case** — e.g. linear search is $\Theta(1)$ best, $\Theta(n)$ worst.

## Worked examples

**Prove $7n^2+3n+5=O(n^2)$:** for $n>1$, $7n^2+3n+5\le 7n^2+3n^2+5n^2=15n^2$. Witnesses $C=15,\ k=1$. (Also $=\Omega(n^2)$ since $\ge 7n^2$ ⇒ $\Theta(n^2)$.)

**Nested loop complexity:**
```
for i := 1 to n
   for j := 1 to n
      x := x + 1          // O(1)
```
Inner runs $n$ times, outer $n$ times ⇒ $n\cdot n\cdot O(1)=\Theta(n^2)$.

**Triangular loop** (`for j := i to n`): total work $\sum_{i=1}^n (n-i+1)=\frac{n(n+1)}{2}=\Theta(n^2)$ — still quadratic even though "half" the iterations.

**Bubble sort:** outer $n-1$ passes, inner up to $n-i$ comparisons ⇒ $\sum(n-i)=\Theta(n^2)$.

## Practice problems

1. Prove $n^2+2n=O(n^2)$ giving explicit $C,k$.
2. Is $2^{n+1}=O(2^n)$? Justify.
3. Rank by growth: $n\log n,\ 2^n,\ n^2,\ \sqrt n,\ n!$.
4. What is the time complexity of binary search, and why?
5. Show $3n=O(n^2)$ but $n^2\neq O(n)$.

<details><summary>Solutions</summary>

1. For $n>1$: $n^2+2n\le n^2+2n^2=3n^2$. $C=3,k=1$.
2. Yes: $2^{n+1}=2\cdot2^n\le 2\cdot2^n$, so $C=2,k=0$. (Constant factor 2 is absorbed.)
3. $\sqrt n \prec n\log n \prec n^2 \prec 2^n \prec n!$.
4. $O(\log n)$: each step halves the search interval, so $\le \log_2 n + 1$ comparisons.
5. $3n\le 3n^2$ for $n\ge1$ ⇒ $O(n^2)$. But for any $C,k$, $n^2>Cn$ once $n>C$, so $n^2\neq O(n)$.
</details>

## Common pitfalls / exam tips
- **Always supply witnesses** $C$ and $k$ when proving Big-O — a graph or "clearly" is not a proof.
- Drop constant factors and lower-order terms — but only inside the asymptotic notation.
- $O$ is an *upper* bound (may be loose); use $\Theta$ to claim a *tight* rate.
- Count the **dominant** operation; nested loops usually multiply, sequential blocks take the max.
- These bounds rate the algorithms designed in [[L7-algorithm-design]] and the data-structure operations in [[L8-data-structures]].
