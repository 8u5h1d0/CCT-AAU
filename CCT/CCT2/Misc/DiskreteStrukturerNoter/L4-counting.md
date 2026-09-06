# L4 — Counting (≈2h block)

**Topic & reading**: Basics of counting, pigeonhole principle, permutations & combinations, binomial coefficients/theorem, combinations with repetition — Rosen **6.1–6.5** (Lecture 4 / Module IV).

Exam relevance: Part 1. Largely computational — pick the right rule and justify it.

---

## Key definitions & rules

- **Product rule (produktreglen)** — a procedure done in $k$ successive steps with $n_i$ choices at step $i$ has $\prod_i n_i$ outcomes.
- **Sum rule (sumreglen)** — a task done in one of $k$ *disjoint* ways ($n_i$ each) has $\sum_i n_i$ outcomes.
- **Subtraction rule / inclusion–exclusion** — $|A\cup B|=|A|+|B|-|A\cap B|$.
- **Permutation (permutation)** — ordered arrangement. $r$-permutations of $n$ objects:
  $$P(n,r)=\frac{n!}{(n-r)!}=n(n-1)\cdots(n-r+1).$$
- **Combination (kombination)** — unordered selection. $r$-combinations:
  $$C(n,r)=\binom{n}{r}=\frac{n!}{r!\,(n-r)!}.$$
- **Pigeonhole principle (Dirichlets skuffeprincip)** — $n$ objects in $k$ boxes, $n>k$ ⇒ some box has $\ge2$. **Generalized**: some box has $\ge\lceil n/k\rceil$.

## Theorems & formulas

- **Symmetry**: $\binom{n}{r}=\binom{n}{n-r}$.
- **Pascal's identity**: $\binom{n+1}{r}=\binom{n}{r-1}+\binom{n}{r}$ (Pascal's triangle).
- **Binomial theorem**: $(x+y)^n=\sum_{k=0}^{n}\binom{n}{k}x^{n-k}y^k$. Consequences: $\sum_{k}\binom{n}{k}=2^n$, $\sum_k(-1)^k\binom{n}{k}=0$.
- **With repetition**:
  - sequences of length $r$ from $n$ symbols: $n^r$.
  - $r$-combinations with repetition from $n$ types: $\binom{n+r-1}{r}$ ("stars and bars").
  - permutations of a multiset with counts $n_1,\dots,n_k$ ($\sum n_i=n$): $\dfrac{n!}{n_1!\cdots n_k!}$.

| Selection | Order matters | Order doesn't |
|---|---|---|
| No repetition | $P(n,r)=\frac{n!}{(n-r)!}$ | $\binom{n}{r}$ |
| Repetition allowed | $n^r$ | $\binom{n+r-1}{r}$ |

## Worked examples

**Permutation vs combination:** From 10 people, how many ways to (a) choose a committee of 3, (b) elect president/VP/secretary?
(a) unordered: $\binom{10}{3}=120$. (b) ordered: $P(10,3)=10\cdot9\cdot8=720$.

**Pigeonhole:** Among any 13 people, at least two share a birth **month**. 13 objects, 12 boxes ⇒ some month has $\lceil13/12\rceil=2$. With 25 people: $\lceil25/12\rceil=3$ share a month.

**Binomial:** coefficient of $x^2y^3$ in $(x+y)^5$ is $\binom{5}{3}=10$.

**Stars and bars:** number of ways to pick 5 cookies from 3 flavours (repetition, unordered) $=\binom{3+5-1}{5}=\binom{7}{5}=21$.

## Practice problems

1. How many bit strings of length 8 start with $1$ **or** end with $00$?
2. How many anagrams of the word `SUCCESS`?
3. A drawer has 10 red and 10 blue socks (dark room). How many must you draw to guarantee a matching pair? a red pair?
4. Expand $(2x-1)^4$ using the binomial theorem.

<details><summary>Solutions</summary>

1. Start with 1: $2^7=128$. End with 00: $2^6=64$. Both: $2^5=32$. By incl–excl $128+64-32=160$.
2. `SUCCESS` = S×3, C×2, U×1, E×1 → $\frac{7!}{3!\,2!}=\frac{5040}{12}=420$.
3. Matching pair: 2 colours ⇒ 3 socks guarantee a pair (pigeonhole). Red pair: worst case all 10 blue first, then 2 red ⇒ 12.
4. $\sum_{k=0}^4\binom{4}{k}(2x)^{4-k}(-1)^k = 16x^4-32x^3+24x^2-8x+1$.
</details>

## Common pitfalls / exam tips
- Decide **ordered vs unordered** first → permutation vs combination. "Arrangement/sequence/ranking" = ordered; "selection/subset/committee" = unordered.
- Sum rule needs the cases to be **disjoint**; otherwise subtract the overlap.
- Pigeonhole answers a *guarantee* — think about the **worst case** before the forced repeat.
- $\binom{n}{r}$ and $P(n,r)$ build directly on factorials/$|A\times B|$ from [[L1-sets-relations-functions]]; growth of these counts motivates [[L6-growth-asymptotics]].
