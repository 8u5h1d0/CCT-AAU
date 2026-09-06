# L3 — Induction & Recursion (≈2h block)

**Topic & reading**: Mathematical induction, strong induction (well-ordering), recursive definitions & structural induction — Rosen **5.1, 5.2, 5.3.2** (Lecture 3 / Module III).

Exam relevance: Part 1, a core *proof* topic. You will be asked to **write a full induction proof** — graders look for the explicit structure.

---

## Key definitions

- **Mathematical induction (matematisk induktion)** — to prove $P(n)$ for all integers $n\ge n_0$:
  1. **Basis step (basistrin)**: prove $P(n_0)$.
  2. **Inductive step (induktionstrin)**: prove $P(k)\Rightarrow P(k+1)$ for arbitrary $k\ge n_0$. The assumption $P(k)$ is the **inductive hypothesis (IH)**.
- **Strong induction (stærk induktion)** — inductive step may assume $P(n_0),\dots,P(k)$ all hold (not just $P(k)$) to prove $P(k+1)$. Logically equivalent to ordinary induction; use it when $P(k+1)$ depends on smaller cases that aren't $k$ (e.g. primes, Fibonacci).
- **Well-ordering principle**: every nonempty set of nonnegative integers has a least element — the foundation that makes induction valid.
- **Recursive definition**: define an object by a **base clause** (some objects are in the set / base value), a **recursive clause** (build new from existing), and an (implicit) **extremal clause** (nothing else is in the set).
- **Structural induction** — prove a property holds for every recursively-defined object by proving it for the base case(s) and showing each recursive construction preserves it.

## Theorems & formulas (standard summation results to prove by induction)

$$\sum_{i=1}^{n} i = \frac{n(n+1)}{2},\qquad \sum_{i=1}^{n} i^2=\frac{n(n+1)(2n+1)}{6},\qquad \sum_{i=0}^{n} r^i=\frac{r^{n+1}-1}{r-1}\ (r\neq1).$$

Recursive examples:
- **Factorial**: $0!=1$, $n!=n\cdot(n-1)!$.
- **Fibonacci**: $F_0=0,\ F_1=1,\ F_n=F_{n-1}+F_{n-2}$.
- **Sum of a sequence**: $S_0=a_0,\ S_n=S_{n-1}+a_n$ for $\sum_{k=0}^n a_k$.
- **Set $\mathbb{N}$**: base $0\in\mathbb{N}$; recursive: $x\in\mathbb{N}\Rightarrow x+1\in\mathbb{N}$; extremal: nothing else.

## Worked example (model the structure exactly)

**Claim:** $\sum_{i=1}^{n} i = \dfrac{n(n+1)}{2}$ for all $n\ge1$.

**Basis** ($n=1$): LHS $=1$, RHS $=\frac{1\cdot2}{2}=1$. ✓

**Inductive step:** assume (IH) $\sum_{i=1}^{k} i=\frac{k(k+1)}{2}$. Then
$$\sum_{i=1}^{k+1} i=\Big(\sum_{i=1}^{k} i\Big)+(k+1)\overset{IH}{=}\frac{k(k+1)}{2}+(k+1)=\frac{k(k+1)+2(k+1)}{2}=\frac{(k+1)(k+2)}{2}.$$
This is the formula with $n=k+1$. By induction it holds for all $n\ge1$. $\blacksquare$

**Strong-induction example (sketch):** every integer $n\ge2$ has a prime factor. Basis $n=2$ (prime). Step: assume true for all $2\le j\le k$. If $k+1$ is prime, done; else $k+1=ab$ with $2\le a\le k$, and by IH $a$ has a prime factor, which also divides $k+1$. $\blacksquare$ (Note: needed a *smaller* case $a$, not $k$ — hence strong induction.)

## Practice problems

1. Prove $\sum_{i=1}^n (2i-1)=n^2$ (sum of first $n$ odd numbers).
2. Prove $3 \mid (n^3-n)$ for all $n\ge0$.
3. Prove $n<2^n$ for all $n\ge1$.
4. Give a recursive definition of the sequence $3,7,11,15,\dots$ and of $3,6,12,24,\dots$.

<details><summary>Solutions</summary>

1. Basis $n=1$: $1=1^2$ ✓. Step: $\sum_{i=1}^{k+1}(2i-1)=k^2+(2(k+1)-1)=k^2+2k+1=(k+1)^2$ ✓.
2. Basis $n=0$: $0$ divisible by 3 ✓. Step: $(k+1)^3-(k+1)=k^3-k+3k^2+3k=(k^3-k)+3(k^2+k)$. First term divisible by 3 by IH, second is $3\cdot(\dots)$ ⇒ sum divisible by 3 ✓.
3. Basis $n=1$: $1<2$ ✓. Step: assume $k<2^k$. Then $k+1\le k+k=2k<2\cdot2^k=2^{k+1}$ (using $k\ge1\Rightarrow 1\le k$) ✓.
4. Arithmetic, step $+4$: $a_1=3,\ a_n=a_{n-1}+4$. Geometric, ratio $2$: $b_1=3,\ b_n=2b_{n-1}$.
</details>

## Common pitfalls / exam tips
- **Always** write the three pieces explicitly: basis, IH, inductive step — and state where the IH is used (mark it). Graders award structure.
- Don't "assume what you want to prove for $n+1$" — assume only $P(k)$ (or $P(\le k)$), derive $P(k+1)$.
- Pick the right basis $n_0$ (sometimes $0$, sometimes $1$ or $2$).
- Use **strong** induction when $P(k+1)$ rests on a case smaller than $k$ (Fibonacci, prime factorization, "every amount $\ge$ … of postage").
- Induction is the tool for proving **recursive algorithm correctness** — see [[L7-algorithm-design]].
