---
tags:
  - "#CCT2"
  - DS
Topic: "Comparing algorithmic growth rates | Combining complexities for multi-step procedures | Graphing functions and interpreting trends | Examples: sorting algorithms, polynomial vs exponential growth"
Semester: CCT2
Course: Diskrete strukturer
Litterature:
  - Introduction to Algorithms 4th ed.
Created: 20-03-2026
---
- - -

## Characterizing Running Times

The *order of growth* of the running time of an algorithm gives a simple way to characterize its efficiency. It also allows us to compare the algorithm with alternative approaches. Once the input size $n$ becomes large enough, an algorithm with a lower order of growth will outperform one with a higher order of growth. For example, merge sort, with its $\Theta(n \lg n)$ worst-case running time, beats insertion sort, whose worst-case running time is $\Theta(n^2)$, for sufficiently large inputs.

Although we can sometimes determine the *exact* running time of an algorithm, the extra precision is rarely worth the effort of computing it. For large enough inputs, the multiplicative constants and lower-order terms of an exact running time are _dominated_ by the effects of the input size itself.

> [!info] **Asymptotic Efficiency**
> When we look at input sizes large enough to make relevant only the order of growth of the running time, we are studying the ***asymptotic*** efficiency of algorithms. This means we are concerned with how the running time of an algorithm increases with the size of the input _in the limit_, as the size of the input increases without bound.

Usually, an algorithm that is asymptotically more efficient is the best choice for all but very small inputs.

Informally, the three most commonly used types of *asymptotic notation* are:

- **Big O-notation** ($O$)
- **Omega-notation** ($\Omega$)
- **Theta-notation** ($\Theta$)

These notations provide a formal framework for describing the growth of running times, and are examined more rigorously alongside several notational conventions used throughout the study of algorithms.


## O-notation, Omega-notation & Theta-notation

To analyze the worst-case running time of insertion sort, we started with a complicated expression:

$$\left(\frac{c_5}{2} + \frac{c_6}{2} + \frac{c_7}{2}\right) n^2 + \left(c_1 + c_2 + c_4 + \frac{c_5}{2} + \frac{c_6}{2} + \frac{c_7}{2} + c_8\right) n - (c_2 + c_4 + c_5 + c_8)$$

To simplify, we:

1. **Discard the lower-order terms** — the linear term and the constant term.
2. **Discard the coefficient** of the leading term ($\frac{c_5}{2} + \frac{c_6}{2} + \frac{c_7}{2}$), leaving only $n^2$.
3. **Use a notation** that focuses on the _rate of growth_ of the running time.

This leaves us with $\Theta(n^2)$. This style — stripping away constants and lower-order terms to focus on order of growth — is how we characterize running times of algorithms using *asymptotic notation*.

> [!note]
> Asymptotic notations are designed to characterize functions ***in general***. While we are most interested in functions that denote running times, asymptotic notation can apply to functions describing other aspects of algorithms (such as the amount of space they use), or even to functions that have nothing to do with algorithms at all.

---

### $O$-notation ("Big-O")

> [!summary] Definition - "$O$-notation (Big-O)"
> $O$-notation characterizes an **upper bound** on the asymptotic behavior of a function. It states that a function grows _no faster_ than a certain rate, based on the highest-order term.

Consider the function $7n^3 + 100n^2 - 20n + 6$. Its highest-order term is $7n^3$, so the function's rate of growth is $n^3$. Because it grows no faster than $n^3$, we write that it is $O(n^3)$.

Perhaps surprisingly, we can _also_ write that $7n^3 + 100n^2 - 20n + 6$ is $O(n^4)$. This is because the function grows _more slowly_ than $n^4$, so it is correct to say it grows no faster. By the same logic, the function is also $O(n^5)$, $O(n^6)$, and so on. More generally, it is $O(n^c)$ for any constant $c \geq 3$.

---

### $\Omega$-notation (Capital Omega)

> [!summary] Definition - "$\Omega$-notation (Omega)"
> $\Omega$-notation characterizes a **lower bound** on the asymptotic behavior of a function. It states that a function grows _at least as fast_ as a certain rate, based on the highest-order term.

Because the highest-order term in $7n^3 + 100n^2 - 20n + 6$ grows at least as fast as $n^3$, this function is $\Omega(n^3)$. It is also $\Omega(n^2)$ and $\Omega(n)$. More generally, it is $\Omega(n^c)$ for any constant $c \leq 3$.

---

### $\Theta$-notation (Capital Theta)

> [!summary] Definition - "$\Theta$-notation (Theta)"
> $\Theta$-notation characterizes a **tight bound** on the asymptotic behavior of a function. It states that a function grows _precisely_ at a certain rate, based on the highest-order term. Put another way, $\Theta$-notation characterizes the rate of growth of the function to within a constant factor from above _and_ to within a constant factor from below. These two constant factors need not be equal.

> [!important]
> If you can show that a function is both $O(f(n))$ and $\Omega(f(n))$ for some function $f(n)$, then you have shown that the function is $\Theta(f(n))$.

Since the function $7n^3 + 100n^2 - 20n + 6$ is both $O(n^3)$ and $\Omega(n^3)$, it is also $\Theta(n^3)$.

---

### Example: Insertion Sort Algorithm

The `INSERTION-SORT` procedure in pseudocode:

```pseudocode
INSERTION-SORT(A, n)
1  for i = 2 to n
2      key = A[i]
3      // Insert A[i] into the sorted subarray A[1 : i – 1].
4      j = i – 1
5      while j > 0 and A[j] > key
6          A[j + 1] = A[j]
7          j = j – 1
8      A[j + 1] = key
```

The procedure has _nested loops_. The **outer loop** is a `for` loop that runs $n - 1$ times, regardless of the values being sorted. The **inner loop** is a `while` loop whose number of iterations _depends_ on the values being sorted. The loop variable $j$ starts at $i - 1$ and decreases by 1 each iteration until either it reaches 0 or $A[j] \leq$ `key`. For a given value of $i$, the `while` loop might iterate 0 times, $i - 1$ times, or anywhere in between. The body of the `while` loop (lines 6–7) takes _constant time_ per iteration.
![[Pasted image 20260321091023.png]]

> [!summary]- Breakdown and Deduction
> - **Outer loop:** runs from $i = 2$ to $n$, so it executes $n - 1$ times (this is fixed)
> - **Inner loop** (while loop): for each iteration of the outer loop, it might run $0$ times, or up to $i - 1$ times (this varies)
> - **Loop body** (lines 6–7): takes constant time, let's call it $c$
> 
> **1. Count the worst-case iterations of the inner loop**
> 
> When does the inner loop run the most? The `while` loop runs as long as $j > 0$ and $A[j] >$ `key`. In the worst case, this condition stays true for as many iterations as possible.
> 
> The maximum number of times the `while` loop can run for a given $i$ is $i - 1$ times.
> 
> Why? Because $j$ starts at $i - 1$ and decreases by 1 each iteration. If the condition is always true, $j$ goes: $(i - 1) \to (i - 2) \to (i - 3) \to \dots \to 1 \to 0$, which is $i - 1$ steps.
> 
> **2. Count/Set total work for all iterations**
> 
> Count the total number of times the `while` loop body executes across all iterations of the outer loop:
> 
> - When $i = 2$: while loop runs at most 1 time
> - When $i = 3$: while loop runs at most 2 times
> - When $i = 4$: while loop runs at most 3 times
> - $\dots$
> - When $i = n$: while loop runs at most $n - 1$ times
> 
> Total iterations of the while loop body $= 1 + 2 + 3 + \dots + (n - 1)$
> 
> **3. Find the sum**
> 
> $$1 + 2 + 3 + \dots + (n-1) = \sum_{i=1}^{n-1} i  = \frac{(n-1)n}{2}$$
> 
> Expanding the right-side of the expression:
> 
> $$\frac{(n-1)n}{2} = \frac{n^2 - n}{2}$$
> 
> **4. Apply asymptotic notation**
> 
> We want to express this using Big-O notation, which gives us an upper bound that ignores constant factors and lower-order terms.
> 
> $$\frac{n^2 - n}{2}$$
> 
> Drop the constant factor ($\frac{x}{2}$):
> 
> $$\frac{n^2 - n}{2} \approx n^2 - n$$
> 
> Drop the lower-order term (the $-n$):
> 
> $$n^2 - n \approx n^2$$
> 
> For large $n$, the $n^2$ term dominates everything else. The $-n$ becomes negligible.
> 
> Therefore: $O(n^2)$
#### Showing the Upper Bound: $O(n^2)$

The running time is dominated by the inner loop. Because each of the $n - 1$ iterations of the outer loop causes the inner loop to iterate _at most_ $i - 1$ times, and because $i$ is at most $n$, the total number of inner loop iterations is at most:

$$(n - 1)(n - 1) < n^2$$

Since each inner loop iteration takes constant time, the total time spent is at most a constant times $n^2$. This gives us an $O(n^2)$ running time for _any_ case of `INSERTION-SORT` — a blanket statement covering all inputs.

#### Showing the Worst-Case Lower Bound: $\Omega(n^2)$

Saying the worst-case running time is $\Omega(n^2)$ means that for every input size $n$ above a certain threshold, there is _at least one_ input of size $n$ for which the algorithm takes at least $cn^2$ time, for some positive constant $c$. It does _not_ necessarily mean the algorithm takes at least $cn^2$ time for _all_ inputs.

To see why the worst case is $\Omega(n^2)$: for a value to end up to the right of where it started, it must have been moved in line 6. For a value to end up $k$ positions to the right, line 6 must have executed $k$ times. Assume $n$ is a multiple of 3, dividing array $A$ into groups of $n/3$ positions. Suppose the $n/3$ largest values occupy the _first_ $n/3$ positions initially. After sorting, each of these $n/3$ values ends up somewhere in the _last_ $n/3$ positions. To get there, each must pass through each of the _middle_ $n/3$ positions, one at a time, requiring at least $n/3$ executions of line 6 per value. Since at least $n/3$ values pass through at least $n/3$ positions, the time taken is at least proportional to:

$$\frac{n}{3} \cdot \frac{n}{3} = \frac{n^2}{9} = \Omega(n^2)$$

#### Concluding $\Theta(n^2)$ for the Worst Case

> [!info] Worst-Case Running Time of Insertion Sort
> Because `INSERTION-SORT` runs in $O(n^2)$ time in _all_ cases, and there exists an input that makes it take $\Omega(n^2)$ time, we conclude that the **worst-case** running time of `INSERTION-SORT` is $\Theta(n^2)$. It does not matter that the constant factors for the upper and lower bounds differ — what matters is that we have characterized the worst-case running time _to within constant factors_, discounting lower-order terms.

> [!warning]
> This argument does **not** show that `INSERTION-SORT` runs in $\Theta(n^2)$ time in _all_ cases. The **best-case** running time is $\Theta(n)$, which occurs when the input is already sorted.

## Asymptotic Notation — Formal Definitions

The notations used to describe the *asymptotic running time* of an algorithm are defined in terms of functions whose domains are typically the set $\mathbb{N}$ of natural numbers or the set $\mathbb{R}$ of real numbers. These notations provide a convenient way to describe a running-time function $T(n)$.
![[Pasted image 20260321101818.png]]

---

### $O$-notation (Big-Oh)

> [!summary] Definition — "Big-O Notation"
> For a given function $g(n)$, we denote by $O(g(n))$ (pronounced "big-oh of $g$ of $n$") the **set of functions**:
> $$O(g(n)) = \{f(n) : \text{there exist positive constants } c \text{ and } n_0 \text{ such that } 0 \leq f(n) \leq cg(n) \text{ for all } n \geq n_0\}$$
> A function $f(n)$ belongs to the set $O(g(n))$ if there exists a positive constant $c$ such that $f(n) \leq cg(n)$ for sufficiently large $n$. In other words, for all values of $n$ at and beyond $n_0$, the value of $f(n)$ is on or below $cg(n)$.

The definition of $O(g(n))$ requires that every function $f(n)$ in the set be _asymptotically nonnegative_: $f(n)$ must be nonnegative whenever $n$ is sufficiently large. (An _asymptotically positive_ function is one that is positive for all sufficiently large $n$.) Consequently, the function $g(n)$ itself must be asymptotically nonnegative, or else the set $O(g(n))$ is empty. This assumption of asymptotic nonnegativity holds for all asymptotic notations.

> [!note] Notation Convention: Equality as Set Membership
> Although $O$-notation is defined in terms of sets, by convention we write $f(n) = O(g(n))$ instead of $f(n) \in O(g(n))$. We say "$f(n)$ is big-oh of $g(n)$." While this is technically an abuse of the equality sign, it has practical advantages that become clearer when asymptotic notation is used within equations and inequalities.

> [!example] Showing $4n^2 + 100n + 500 = O(n^2)$
> We need to find positive constants $c$ and $n_0$ such that:
> $$4n^2 + 100n + 500 \leq cn^2 \quad \text{for all } n \geq n_0$$
> Dividing both sides by $n^2$ gives:
> $$4 + \frac{100}{n} + \frac{500}{n^2} \leq c$$
> This inequality is satisfied for many choices of $c$ and $n_0$. For example:
> - $n_0 = 1 \Rightarrow c = 604$
> - $n_0 = 10 \Rightarrow c = 19$
> - $n_0 = 100 \Rightarrow c = 5.05$
>
> This demonstrates how we can justify discarding lower-order terms and ignoring the constant coefficient of the highest-order term.

> [!example] Showing $n^3 - 100n^2 \neq O(n^2)$
> If we had $n^3 - 100n^2 = O(n^2)$, then there would be positive constants $c$ and $n_0$ such that:
> $$n^3 - 100n^2 \leq cn^2 \quad \text{for all } n \geq n_0$$
> Dividing both sides by $n^2$ gives:
> $$n - 100 \leq c$$
> Regardless of what value we choose for $c$, this inequality fails for any $n > c + 100$. Therefore $n^3 - 100n^2 \notin O(n^2)$.

---

### $\Omega$-notation (Big-Omega)

> [!summary] Definition — "Big-Omega Notation"
> For a given function $g(n)$, we denote by $\Omega(g(n))$ (pronounced "big-omega of $g$ of $n$") the set of functions:
> $$\Omega(g(n)) = \{f(n) : \text{there exist positive constants } c \text{ and } n_0 \text{ such that } 0 \leq cg(n) \leq f(n) \text{ for all } n \geq n_0\}$$

Where $O$-notation provides an asymptotic *upper* bound, $\Omega$-notation provides an asymptotic *lower* bound.

> [!example] Showing $4n^2 + 100n + 500 = \Omega(n^2)$
> We need positive constants $c$ and $n_0$ such that:
> $$4n^2 + 100n + 500 \geq cn^2 \quad \text{for all } n \geq n_0$$
> Dividing by $n^2$:
> $$4 + \frac{100}{n} + \frac{500}{n^2} \geq c$$
> This holds when $n_0$ is any positive integer and $c = 4$.

> [!example] Showing $\frac{n^2}{100} - 100n - 500 = \Omega(n^2)$
> Even with a small leading coefficient and subtracted lower-order terms, the function is still $\Omega(n^2)$. Dividing by $n^2$:
> $$\frac{1}{100} - \frac{100}{n} - \frac{500}{n^2} \geq c$$
> We can choose any $n_0 \geq 10{,}005$ and find a positive $c$. For example:
> - $n_0 = 10{,}005 \Rightarrow c = 2.49 \times 10^{-9}$ (tiny, but positive)
> - $n_0 = 100{,}000 \Rightarrow c = 0.0089$
>
> The higher the value of $n_0$, the closer to the coefficient $\frac{1}{100}$ we can choose $c$.

---

### $\Theta$-notation (Theta)

> [!summary] Definition — "Theta Notation"
> For a given function $g(n)$, we denote by $\Theta(g(n))$ ("theta of $g$ of $n$") the set of functions:
> $$\Theta(g(n)) = \{f(n) : \text{there exist positive constants } c_1, c_2, \text{ and } n_0 \text{ such that } 0 \leq c_1 g(n) \leq f(n) \leq c_2 g(n) \text{ for all } n \geq n_0\}$$
> For all $n \geq n_0$, the function $f(n)$ lies between $c_1 g(n)$ and $c_2 g(n)$. In other words, $f(n)$ is equal to $g(n)$ to within constant factors. $\Theta$-notation provides an _asymptotically tight bound_.

The definitions of $O$-, $\Omega$-, and $\Theta$-notations lead directly to the following theorem:

> [!summary] Theorem — "Tight Bound Equivalence"
> For any two functions $f(n)$ and $g(n)$, we have:
> $$f(n) = \Theta(g(n)) \quad \text{if and only if} \quad f(n) = O(g(n)) \text{ and } f(n) = \Omega(g(n))$$
>
> **Proof:**
>
> **($\Rightarrow$) Forward direction:** Assume $f(n) = \Theta(g(n))$. By definition, there exist positive constants $c_1$, $c_2$, and $n_0$ such that:
> $$0 \leq c_1 g(n) \leq f(n) \leq c_2 g(n) \quad \text{for all } n \geq n_0$$
> The right portion of this compound inequality gives $0 \leq f(n) \leq c_2 g(n)$ for all $n \geq n_0$, which by definition means $f(n) = O(g(n))$ (with $c = c_2$). The left portion gives $0 \leq c_1 g(n) \leq f(n)$ for all $n \geq n_0$, which by definition means $f(n) = \Omega(g(n))$ (with $c = c_1$).
>
> **($\Leftarrow$) Reverse direction:** Assume $f(n) = O(g(n))$ and $f(n) = \Omega(g(n))$.
> - Since $f(n) = O(g(n))$, there exist positive constants $c_2$ and $n_1$ such that $0 \leq f(n) \leq c_2 g(n)$ for all $n \geq n_1$.
> - Since $f(n) = \Omega(g(n))$, there exist positive constants $c_1$ and $n_2$ such that $0 \leq c_1 g(n) \leq f(n)$ for all $n \geq n_2$.
>
> Let $n_0 = \max(n_1, n_2)$. Then for all $n \geq n_0$, both inequalities hold simultaneously, giving:
> $$0 \leq c_1 g(n) \leq f(n) \leq c_2 g(n) \quad \text{for all } n \geq n_0$$
> which is exactly the definition of $f(n) = \Theta(g(n))$. $\blacksquare$
> #### Step-by-Step Breakdown
> 
> The theorem says that $\Theta$ is equivalent to having *both* $O$ and $\Omega$ at the same time. The proof needs to show this works in both directions: that $\Theta$ *gives you* both, and that having both *gives you* $\Theta$.
> 
>**Forward direction — "If $f(n) = \Theta(g(n))$, then $f(n) = O(g(n))$ and $f(n) = \Omega(g(n))$":**
>
>1. We start by assuming $f(n) = \Theta(g(n))$ is true. By definition, this means $f(n)$ is *sandwiched* between $c_1 g(n)$ from below and $c_2 g(n)$ from above (for large enough $n$).
>2. A sandwich has two halves. The *upper* half of the sandwich ($f(n) \leq c_2 g(n)$) is exactly the definition of $O$-notation — an upper bound. So $f(n) = O(g(n))$.
>3. The *lower* half of the sandwich ($c_1 g(n) \leq f(n)$) is exactly the definition of $\Omega$-notation — a lower bound. So $f(n) = \Omega(g(n))$.
>4. That's it. A tight bound is just an upper bound and a lower bound packaged together, so it naturally contains both.
>
>**Reverse direction — "If $f(n) = O(g(n))$ and $f(n) = \Omega(g(n))$, then $f(n) = \Theta(g(n))$":**
>
>1. We now assume we have *both* pieces separately: an upper bound (from $O$) and a lower bound (from $\Omega$).
>2. The catch is that each bound might "kick in" at a different starting point. The upper bound holds for all $n \geq n_1$, and the lower bound holds for all $n \geq n_2$. These two starting points might not be the same.
>3. The fix is simple: pick whichever starting point is *larger* — $n_0 = \max(n_1, n_2)$. Beyond this point, *both* bounds are active at the same time.
>4. With both bounds active simultaneously, $f(n)$ is sandwiched between $c_1 g(n)$ and $c_2 g(n)$ — which is exactly the definition of $\Theta(g(n))$.

- - - 
### Asymptotic Notation and Running Times

When using asymptotic notation to characterize an algorithm's running time, the notation should be **as precise as possible** without overstating which running time it applies to.

> [!important] Precision and Correct Usage
> Consider _insertion sort_:
> - Its **worst-case** running time is $O(n^2)$, $\Omega(n^2)$, and $\Theta(n^2)$. The $\Theta(n^2)$ bound is the most precise and therefore most preferred.
> - Its **best-case** running time is $O(n)$, $\Omega(n)$, and $\Theta(n)$, with $\Theta(n)$ again being preferred.
> - We **cannot** correctly say that insertion sort's running time is $\Theta(n^2)$ (without qualifying "worst-case"), because that would be a blanket statement covering all cases — and it runs in $\Theta(n)$ time in the best case.
> - We **can** correctly say its running time is $O(n^2)$, because in *all* cases its running time grows no faster than $n^2$.
> - Likewise, we **cannot** say its running time is $\Theta(n)$, but we **can** say it is $\Omega(n)$.

For an algorithm like _merge sort_, which runs in $\Theta(n \lg n)$ time in *all* cases, we can simply say its running time is $\Theta(n \lg n)$ without specifying a particular case.

> [!warning] Common Mistake: Conflating $O$ with $\Theta$
> People sometimes misuse $O$-notation to indicate a tight bound. Saying "an $O(n \lg n)$-time algorithm runs faster than an $O(n^2)$-time algorithm" is not necessarily true — the so-called $O(n^2)$-time algorithm might actually run in $\Theta(n)$ time. If you want to indicate an asymptotically tight bound, use $\Theta$-notation.

We typically use asymptotic notation to provide the **simplest and most precise** bounds possible. For example, if an algorithm has a running time of $3n^2 + 20n$ in all cases, we write that its running time is $\Theta(n^2)$. Technically, writing $O(n^3)$ or $\Theta(3n^2 + 20n)$ would also be correct, but neither is as useful: $O(n^3)$ is less precise, and $\Theta(3n^2 + 20n)$ introduces complexity that obscures the order of growth. By writing the simplest, most precise bound, we can more easily categorize and compare algorithms.

---

### Asymptotic Notation in Equations and Inequalities

Although asymptotic notation is formally defined in terms of sets, the equal sign ($=$) is used instead of the set membership sign ($\in$) within formulas.

**When asymptotic notation stands alone on the right-hand side** of an equation, the equal sign means set membership:

$$4n^2 + 100n + 500 = O(n^2) \quad \text{means} \quad 4n^2 + 100n + 500 \in O(n^2)$$

**When asymptotic notation appears within a larger formula**, it stands for some _anonymous function_ that we do not care to name. For example:

$$2n^2 + 3n + 1 = 2n^2 + \Theta(n)$$

means that $2n^2 + 3n + 1 = 2n^2 + f(n)$, where $f(n) \in \Theta(n)$. Here, $f(n) = 3n + 1$, which indeed belongs to $\Theta(n)$. This usage helps eliminate inessential detail and clutter in equations. For instance, the worst-case running time of merge sort can be expressed as the recurrence $T(n) = 2T(n/2) + \Theta(n)$, where the $\Theta(n)$ term subsumes all the lower-order details.

The number of anonymous functions in an expression equals the number of times asymptotic notation appears.

**When asymptotic notation appears on the left-hand side** of an equation, as in:

$$2n^2 + \Theta(n) = \Theta(n^2)$$

the interpretation is: _no matter how_ the anonymous functions are chosen on the left, _there is a way_ to choose the anonymous functions on the right to make the equation valid. This means the right-hand side provides a coarser level of detail than the left-hand side.

We can chain such relationships together:

$$2n^2 + 3n + 1 = 2n^2 + \Theta(n) = \Theta(n^2)$$

Each equation is interpreted separately:
1. There is some $f(n) \in \Theta(n)$ such that $2n^2 + 3n + 1 = 2n^2 + f(n)$ for all $n$.
2. For any $g(n) \in \Theta(n)$ (including the $f(n)$ above), there is some $h(n) \in \Theta(n^2)$ such that $2n^2 + g(n) = h(n)$ for all $n$.

Together, this implies $2n^2 + 3n + 1 = \Theta(n^2)$.

---

### Proper Abuses of Asymptotic Notation

Beyond using equality for set membership, there are several other conventional "abuses" of asymptotic notation that are widely accepted:

**Inferring the variable from context:** When we write $O(g(n))$, we assume $n$ is the variable tending toward $\infty$. Writing $O(g(m))$ means $m$ is the variable of interest. The _free variable_ in the expression indicates which variable is growing.

**The expression $O(1)$:** When the function inside asymptotic notation is a constant, as in $f(n) = O(1)$, no variable appears inside the notation, so the context must disambiguate. Here, it's clear the variable of interest is $n$, and $f(n) = O(1)$ means $f(n)$ is bounded from above by a constant as $n \to \infty$.

**Bounded ranges:** Statements like $T(n) = O(1)$ for $n < 3$ are technically meaningless by the formal definition (which only guarantees bounds for $n \geq n_0$). Conventionally, this means there exists a positive constant $c$ such that $T(n) \leq c$ for $n < 3$. This saves us from naming the bounding constant explicitly. Similarly, $T(n) = \Theta(1)$ for $n < 3$ means $T(n)$ is bounded above *and* below by positive constants when $n < 3$.

**Partially defined functions:** When an algorithm's running time isn't defined for all input sizes (e.g., it assumes the input size is an exact power of 2), asymptotic notation still applies — the constraints simply hold only where the function is defined.

> [!tip] Abusing vs. Misusing Notation
> In mathematics, it is acceptable — and often desirable — to *abuse* a notation, as long as we don't *misuse* it. If we understand precisely what is meant and don't draw incorrect conclusions, the abuse can simplify mathematical language, contribute to higher-level understanding, and help us focus on what really matters.

---

### $o$-notation (Little-oh)

The asymptotic upper bound provided by $O$-notation may or may not be _asymptotically tight_. For instance, $2n^2 = O(n^2)$ is tight, but $2n = O(n^2)$ is not. We use $o$-notation to denote an upper bound that is **not** asymptotically tight.

> [!summary] Definition — "Little-o Notation"
> We formally define $o(g(n))$ ("little-oh of $g$ of $n$") as the set:
> $$o(g(n)) = \{f(n) : \text{for any positive constant } c > 0, \text{ there exists a constant } n_0 > 0 \text{ such that } 0 \leq f(n) < cg(n) \text{ for all } n \geq n_0\}$$

For example, $2n = o(n^2)$, but $2n^2 \neq o(n^2)$.

The key difference between $O$-notation and $o$-notation:
- In $f(n) = O(g(n))$: the bound $0 \leq f(n) \leq cg(n)$ holds for **some** constant $c > 0$.
- In $f(n) = o(g(n))$: the bound $0 \leq f(n) < cg(n)$ holds for **all** constants $c > 0$.

Intuitively, in $o$-notation, $f(n)$ becomes *insignificant* relative to $g(n)$ as $n$ gets large:

$$\lim_{n \to \infty} \frac{f(n)}{g(n)} = 0$$

Some authors use this limit as the definition of $o$-notation, but the formal set-based definition additionally restricts the anonymous functions to be asymptotically nonnegative.

---

### $\omega$-notation (Little-omega)

By analogy, $\omega$-notation is to $\Omega$-notation as $o$-notation is to $O$-notation. We use $\omega$-notation to denote a lower bound that is **not** asymptotically tight.

> [!summary] Definition — "Little-omega Notation"
> We define $\omega(g(n))$ ("little-omega of $g$ of $n$") as the set:
> $$\omega(g(n)) = \{f(n) : \text{for any positive constant } c > 0, \text{ there exists a constant } n_0 > 0 \text{ such that } 0 \leq cg(n) < f(n) \text{ for all } n \geq n_0\}$$

One equivalent characterization: $f(n) \in \omega(g(n))$ if and only if $g(n) \in o(f(n))$.

For example, $\frac{n^2}{2} = \omega(n)$, but $\frac{n^2}{2} \neq \omega(n^2)$.

The relation $f(n) = \omega(g(n))$ implies (if the limit exists):

$$\lim_{n \to \infty} \frac{f(n)}{g(n)} = \infty$$

That is, $f(n)$ becomes *arbitrarily large* relative to $g(n)$ as $n$ gets large.

---

### Comparing Functions

Many relational properties of real numbers carry over to asymptotic comparisons. For the following, assume $f(n)$ and $g(n)$ are asymptotically positive.

**Transitivity** (holds for all five notations):
- $f(n) = \Theta(g(n))$ and $g(n) = \Theta(h(n))$ imply $f(n) = \Theta(h(n))$
- $f(n) = O(g(n))$ and $g(n) = O(h(n))$ imply $f(n) = O(h(n))$
- $f(n) = \Omega(g(n))$ and $g(n) = \Omega(h(n))$ imply $f(n) = \Omega(h(n))$
- $f(n) = o(g(n))$ and $g(n) = o(h(n))$ imply $f(n) = o(h(n))$
- $f(n) = \omega(g(n))$ and $g(n) = \omega(h(n))$ imply $f(n) = \omega(h(n))$

**Reflexivity:**
- $f(n) = \Theta(f(n))$, $\quad f(n) = O(f(n))$, $\quad f(n) = \Omega(f(n))$

**Symmetry:**
- $f(n) = \Theta(g(n))$ if and only if $g(n) = \Theta(f(n))$

**Transpose Symmetry:**
- $f(n) = O(g(n))$ if and only if $g(n) = \Omega(f(n))$
- $f(n) = o(g(n))$ if and only if $g(n) = \omega(f(n))$

> [!abstract] Analogy — Asymptotic Comparison as Number Comparison
> Because these properties hold, we can draw an analogy between comparing two functions $f$ and $g$ asymptotically and comparing two real numbers $a$ and $b$:
> 
> | Asymptotic Comparison | Real Number Analogy |
> |---|---|
> | $f(n) = O(g(n))$ | $a \leq b$ |
> | $f(n) = \Omega(g(n))$ | $a \geq b$ |
> | $f(n) = \Theta(g(n))$ | $a = b$ |
> | $f(n) = o(g(n))$ | $a < b$ |
> | $f(n) = \omega(g(n))$ | $a > b$ |
> 
> We say $f(n)$ is _asymptotically smaller_ than $g(n)$ if $f(n) = o(g(n))$, and _asymptotically larger_ if $f(n) = \omega(g(n))$.

> [!warning] Trichotomy Does Not Hold
> One property of real numbers does **not** carry over: _trichotomy_. For any two real numbers $a$ and $b$, exactly one of $a < b$, $a = b$, or $a > b$ must hold. However, not all functions are asymptotically comparable. For two functions $f(n)$ and $g(n)$, it may be the case that **neither** $f(n) = O(g(n))$ nor $f(n) = \Omega(g(n))$ holds. For example, $n$ and $n^{1+\sin n}$ cannot be compared using asymptotic notation, since the exponent in $n^{1+\sin n}$ oscillates between 0 and 2, taking on all values in between.


## Standard Notation and Common Functions

### Monotonicity

> [!info] Monotonicity Definitions
> - A function $f(n)$ is _monotonically increasing_ if $m \leq n$ implies $f(m) \leq f(n)$.
> - A function $f(n)$ is _monotonically decreasing_ if $m \leq n$ implies $f(m) \geq f(n)$.
> - A function $f(n)$ is _strictly increasing_ if $m < n$ implies $f(m) < f(n)$.
> - A function $f(n)$ is _strictly decreasing_ if $m < n$ implies $f(m) > f(n)$.

The difference between "monotonically" and "strictly" is subtle but important: monotonic allows equal values at different inputs (the function can be flat), while strict does not.

---

### Floors and Ceilings

For any real number $x$:
- $\lfloor x \rfloor$ ("the floor of $x$") is the _greatest integer less than or equal to_ $x$.
- $\lceil x \rceil$ ("the ceiling of $x$") is the _least integer greater than or equal to_ $x$.

Both the floor and ceiling functions are monotonically increasing.

> [!info] Core Properties of Floors and Ceilings
> For any integer $n$:
> $$\lfloor n \rfloor = n = \lceil n \rceil$$
>
> For all real $x$:
> $$x - 1 < \lfloor x \rfloor \leq x \leq \lceil x \rceil < x + 1$$
>
> Negation:
> $$-\lceil x \rceil = \lfloor -x \rfloor$$
>
> For any integer $n$ and real number $x$:
> $$\lfloor n + x \rfloor = n + \lfloor x \rfloor$$
> $$\lceil n + x \rceil = n + \lceil x \rceil$$

> [!info] Nested Floor/Ceiling and Division Properties
> For any real number $x \geq 0$ and integers $a, b > 0$:
> $$\left\lceil \frac{\left\lceil \frac{x}{a} \right\rceil}{b} \right\rceil = \left\lceil \frac{x}{ab} \right\rceil$$
> $$\left\lfloor \frac{\left\lfloor \frac{x}{a} \right\rfloor}{b} \right\rfloor = \left\lfloor \frac{x}{ab} \right\rfloor$$
> $$\left\lceil \frac{a}{b} \right\rceil \leq \frac{a + (b-1)}{b}$$
> $$\left\lfloor \frac{a}{b} \right\rfloor \geq \frac{a - (b-1)}{b}$$

---

### Modular Arithmetic

For any integer $a$ and any positive integer $n$, the value $a \bmod n$ is the _remainder_ (or _residue_) of the quotient $a/n$:

$$a \bmod n = a - n\left\lfloor \frac{a}{n} \right\rfloor$$

It follows that:

$$0 \leq a \bmod n < n$$

even when $a$ is negative.

> [!info] Equivalence Modulo $n$
> If $(a \bmod n) = (b \bmod n)$, we write $a \equiv b \pmod{n}$ and say that $a$ is _equivalent to_ $b$, _modulo_ $n$. In other words, $a \equiv b \pmod{n}$ if $a$ and $b$ have the same remainder when divided by $n$.
>
> Equivalently, $a \equiv b \pmod{n}$ if and only if $n$ is a divisor of $b - a$.
>
> We write $a \not\equiv b \pmod{n}$ if $a$ is not equivalent to $b$, modulo $n$.

---

### Polynomials

Given a nonnegative integer $d$, a _polynomial in $n$ of degree $d$_ is a function $p(n)$ of the form:

$$p(n) = \sum_{i=0}^{d} a_i n^i$$

where the constants $a_0, a_1, \ldots, a_d$ are the _coefficients_ of the polynomial and $a_d \neq 0$.

A polynomial is _asymptotically positive_ if and only if $a_d > 0$.

> [!info] Key Facts About Polynomials
> - For an asymptotically positive polynomial $p(n)$ of degree $d$: $p(n) = \Theta(n^d)$.
> - For any real constant $a \geq 0$, the function $n^a$ is monotonically increasing.
> - For any real constant $a \leq 0$, the function $n^a$ is monotonically decreasing.
> - A function $f(n)$ is _polynomially bounded_ if $f(n) = O(n^k)$ for some constant $k$.

---

### Exponentials

For all real $a > 0$, $m$, and $n$, we have the following identities:

| Identity | Identity |
|---|---|
| $a^0 = 1$ | $(a^m)^n = a^{mn}$ |
| $a^1 = a$ | $(a^m)^n = (a^n)^m$ |
| $a^{-1} = 1/a$ | $a^m a^n = a^{m+n}$ |

For all $n$ and $a \geq 1$, the function $a^n$ is monotonically increasing in $n$. When convenient, we assume that $0^0 = 1$.

> [!important] Exponentials Grow Faster Than Polynomials
> For all real constants $a > 1$ and $b$:
> $$\lim_{n \to \infty} \frac{n^b}{a^n} = 0$$
> from which we conclude:
> $$n^b = o(a^n)$$
> Any exponential function with a base strictly greater than 1 grows faster than any polynomial function.

Using $e$ to denote $2.71828\ldots$, the base of the natural logarithm, we have for all real $x$:

$$e^x = 1 + x + \frac{x^2}{2!} + \frac{x^3}{3!} + \cdots = \sum_{i=0}^{\infty} \frac{x^i}{i!}$$

> [!info] Approximations of $e^x$
> For all real $x$:
> $$1 + x \leq e^x$$
> where equality holds only when $x = 0$.
>
> When $|x| \leq 1$:
> $$1 + x \leq e^x \leq 1 + x + x^2$$
>
> When $x \to 0$, the approximation $e^x = 1 + x + \Theta(x^2)$ is quite good. (Here, the asymptotic notation describes limiting behavior as $x \to 0$ rather than $x \to \infty$.)
>
> For all $x$:
> $$\lim_{n \to \infty} \left(1 + \frac{x}{n}\right)^n = e^x$$

---

### Logarithms

The following shorthand notations are standard:

| Notation | Meaning |
|---|---|
| $\lg n$ | $\log_2 n$ (binary logarithm) |
| $\ln n$ | $\log_e n$ (natural logarithm) |
| $\lg^k n$ | $(\lg n)^k$ (exponentiation) |
| $\lg \lg n$ | $\lg(\lg n)$ (composition) |

> [!note] Notational Convention
> In the absence of parentheses, a logarithm function applies only to the next term in the formula. So $\lg n + 1$ means $(\lg n) + 1$, **not** $\lg(n + 1)$.

For any constant $b > 1$, the function $\log_b n$ is:
- Undefined if $n \leq 0$
- Strictly increasing if $n > 0$
- Negative if $0 < n < 1$
- Positive if $n > 1$
- Zero if $n = 1$

> [!info] Logarithm Identities
> For all real $a > 0$, $b > 0$, $c > 0$, and $n$ (with logarithm bases not equal to 1):
> $$a = b^{\log_b a}$$
> $$\log_c(ab) = \log_c a + \log_c b$$
> $$\log_b a^n = n \log_b a$$
> $$\log_b a = \frac{\log_c a}{\log_c b}$$
> $$\log_b\left(\frac{1}{a}\right) = -\log_b a$$
> $$\log_b a = \frac{1}{\log_a b}$$
> $$a^{\log_b c} = c^{\log_b a}$$

An important consequence of the identity $\log_b a = \frac{\log_c a}{\log_c b}$ is that changing the base of a logarithm from one constant to another changes the value by only a _constant factor_. This is why we often use the notation "$\lg n$" when we don't care about constant factors, such as in $O$-notation. Computer scientists find 2 to be the most natural base because so many algorithms and data structures involve splitting a problem into two parts.

> [!info] Series Expansion and Bounds for $\ln(1+x)$
> For $|x| < 1$:
> $$\ln(1 + x) = x - \frac{x^2}{2} + \frac{x^3}{3} - \frac{x^4}{4} + \frac{x^5}{5} - \cdots$$
>
> For $x > -1$:
> $$\frac{x}{1 + x} \leq \ln(1 + x) \leq x$$
> where equality holds only for $x = 0$.

> [!important] Polynomials Grow Faster Than Polylogarithms
> A function $f(n)$ is _polylogarithmically bounded_ if $f(n) = O(\lg^k n)$ for some constant $k$.
>
> For all real constants $a > 0$ and $b$:
> $$\lg^b n = o(n^a)$$
> Any positive polynomial function grows faster than any polylogarithmic function.

---

### Factorials

The notation $n!$ ("$n$ factorial") is defined for integers $n \geq 0$ as:

$$n! = \begin{cases} 1 & \text{if } n = 0, \\ n \cdot (n-1)! & \text{if } n > 0. \end{cases}$$

Thus, $n! = 1 \cdot 2 \cdot 3 \cdots n$.

A weak upper bound is $n! \leq n^n$, since each of the $n$ terms in the factorial product is at most $n$.

> [!info] Stirling's Approximation
> $$n! = \sqrt{2\pi n}\left(\frac{n}{e}\right)^n\left(1 + \Theta\left(\frac{1}{n}\right)\right)$$
> This gives both a tighter upper bound and a lower bound. The following also holds for all $n \geq 1$:
> $$n! = \sqrt{2\pi n}\left(\frac{n}{e}\right)^n e^{\alpha_n}$$
> where
> $$\frac{1}{12n+1} < \alpha_n < \frac{1}{12n}$$

> [!info] Asymptotic Bounds on Factorials
> $$n! = o(n^n)$$
> $$n! = \omega(2^n)$$
> $$\lg(n!) = \Theta(n \lg n)$$

---

### Functional Iteration

The notation $f^{(i)}(n)$ denotes the function $f(n)$ iteratively applied $i$ times to an initial value of $n$. Formally, for nonnegative integers $i$:

$$f^{(i)}(n) = \begin{cases} n & \text{if } i = 0, \\ f(f^{(i-1)}(n)) & \text{if } i > 0. \end{cases}$$

> [!example] Functional Iteration with $f(n) = 2n$
> If $f(n) = 2n$, then:
> - $f^{(0)}(n) = n$
> - $f^{(1)}(n) = 2n$
> - $f^{(2)}(n) = 2(2n) = 4n$
> - $f^{(i)}(n) = 2^i n$

---

### The Iterated Logarithm Function

The notation $\lg^* n$ ("log star of $n$") denotes the _iterated logarithm_. Let $\lg^{(i)} n$ be the logarithm function applied $i$ times in succession (using the functional iteration definition above with $f(n) = \lg n$). Note that $\lg^{(i)} n$ is only defined if $\lg^{(i-1)} n > 0$.

> [!warning] Notation Distinction
> Be careful to distinguish $\lg^{(i)} n$ (the logarithm applied $i$ times in succession, starting with argument $n$) from $\lg^i n$ (the logarithm of $n$ raised to the $i$th power, i.e., $(\lg n)^i$).

> [!summary] Definition — "Iterated Logarithm"
> $$\lg^* n = \min\{i \geq 0 : \lg^{(i)} n \leq 1\}$$

The iterated logarithm is a _very_ slowly growing function:

| $n$ | $\lg^* n$ |
|---|---|
| $2$ | $1$ |
| $4$ | $2$ |
| $16$ | $3$ |
| $65536$ | $4$ |
| $2^{65536}$ | $5$ |

Since the number of atoms in the observable universe is estimated to be about $10^{80}$, which is much less than $2^{65536} \approx 10^{19{,}728}$, we rarely encounter an input size $n$ for which $\lg^* n > 5$.

---

### Fibonacci Numbers

The _Fibonacci numbers_ $F_i$, for $i \geq 0$, are defined as:

$$F_i = \begin{cases} 0 & \text{if } i = 0, \\ 1 & \text{if } i = 1, \\ F_{i-1} + F_{i-2} & \text{if } i \geq 2. \end{cases}$$

After the first two, each Fibonacci number is the sum of the two previous ones, yielding the sequence $0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, \ldots$

Fibonacci numbers are related to the _golden ratio_ $\phi$ and its _conjugate_ $\hat{\phi}$, which are the two roots of the equation $x^2 = x + 1$.

> [!summary] Definition — "Golden Ratio and Conjugate"
> $$\phi = \frac{1 + \sqrt{5}}{2} = 1.61803\ldots$$
> $$\hat{\phi} = \frac{1 - \sqrt{5}}{2} = -0.61803\ldots$$
>
> Proof (that these are roots of $x^2 = x + 1$):
>
> The equation $x^2 = x + 1$ can be rewritten as $x^2 - x - 1 = 0$. Applying the quadratic formula:
> $$x = \frac{1 \pm \sqrt{1 + 4}}{2} = \frac{1 \pm \sqrt{5}}{2}$$
> giving the two roots $\phi = \frac{1+\sqrt{5}}{2}$ and $\hat{\phi} = \frac{1-\sqrt{5}}{2}$. $\blacksquare$

> [!info] Closed-Form Expression for Fibonacci Numbers
> $$F_i = \frac{\phi^i - \hat{\phi}^i}{\sqrt{5}}$$
>
> Since $|\hat{\phi}| < 1$, we have:
> $$\frac{|\hat{\phi}^i|}{\sqrt{5}} < \frac{1}{\sqrt{5}} < \frac{1}{2}$$
>
> which implies:
> $$F_i = \left\lfloor \frac{\phi^i}{\sqrt{5}} + \frac{1}{2} \right\rfloor$$
>
> This means the $i$th Fibonacci number $F_i$ is equal to $\frac{\phi^i}{\sqrt{5}}$ rounded to the nearest integer. Thus, Fibonacci numbers grow exponentially.