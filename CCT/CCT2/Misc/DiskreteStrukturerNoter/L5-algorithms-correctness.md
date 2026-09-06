# L5 — Algorithms: Modelling, Representation & Correctness (≈2h block)

**Topic & reading**: What an algorithm is, pseudocode, pre/postconditions, partial vs total correctness, loop invariants, linear/binary search as worked cases — Rosen **3.1–3.2** (Lecture 5 / Module VI). Start of Part 2.

Exam relevance: Part 2. Expect a "prove this loop is correct with an invariant" or "give pre/postconditions" question.

---

## Key definitions

- **Algorithm (algoritme)** — a *finite* sequence of *precise* instructions solving a *well-defined* problem. Essential properties: **input, output, correctness, definiteness** (each step precise), **finiteness** (terminates), **effectiveness** (each step doable), **generality** (works for all valid inputs).
- **Representations**: natural language, programming language, **pseudocode** (course standard, Rosen `procedure`-style).
- **Precondition (P)** — what the input is guaranteed to satisfy. **Postcondition (Q)** — what the output must satisfy.
- **Hoare triple** $\{P\}\,S\,\{Q\}$ — "if $P$ holds before running $S$, then $Q$ holds after (if $S$ halts)".
- **Partial correctness (partiel korrekthed)** — *if* $S$ halts on input satisfying $P$, the output satisfies $Q$. (Says nothing about halting.)
- **Total correctness (total korrekthed)** — partial correctness **+** $S$ always halts. $\text{total} = \text{partial} + \text{termination}$.
- **Loop invariant (løkkeinvariant)** — an assertion true before/after every iteration of a loop, used to prove the loop establishes its postcondition.

## Method: proving correctness

**Compose sections.** Split $S$ into $S_1;S_2;\dots;S_N$ and find intermediate assertions $R_i$ so that
$$\{P\}\,S_1\,\{R_1\},\ \{R_1\}\,S_2\,\{R_2\},\ \dots,\ \{R_{N-1}\}\,S_N\,\{Q\}\ \Longrightarrow\ \{P\}\,S\,\{Q\}.$$
Trivial assignments need no proof; **loops require a loop-invariant proof**.

**Loop-invariant proof has three parts** (Cormen/Rosen style):
1. **Initialization** — the invariant holds before the first iteration.
2. **Maintenance** — if it holds before an iteration, it still holds before the next.
3. **Termination** — when the loop ends, the invariant (plus the exit condition) implies the postcondition.
(For *total* correctness also argue the loop variant strictly decreases ⇒ termination.)

## Worked example — correctness of `max`

```
procedure max(a1,…,an : integers)        // P: n ≥ 1
  max := a1
  for i := 2 to n
     if max < ai then max := ai
  return max                              // Q: max = largest of a1…an
```
**Invariant:** *after processing the first $i$ elements, `max` equals the maximum of $a_1,\dots,a_i$.*
- **Initialization:** before the loop ($i=1$ conceptually) `max = a1`, the max of the first one element. ✓
- **Maintenance:** if `max` = max of $a_1..a_{i-1}$, the body sets `max := ai` exactly when $a_i$ is larger, so `max` = max of $a_1..a_i$. ✓
- **Termination:** loop ends with $i=n$; invariant gives `max` = max of $a_1..a_n$ = $Q$. ✓ The loop runs a fixed $n-1$ times ⇒ halts ⇒ **total** correctness.

## Worked example — linear search (Rosen Algorithm 2)

```
procedure linear_search(x; a1,…,an : distinct integers)
  i := 1
  while (i ≤ n and x ≠ ai)
     i := i + 1
  if i ≤ n then location := i
  else location := 0
  return location          // location = index of x, or 0 if absent
```
Invariant of the loop: *$x\notin\{a_1,\dots,a_{i-1}\}$.* Terminates because $i$ strictly increases and is bounded by $n+1$. Worst case (absent / last position): $n$ comparisons — motivates complexity analysis in [[L6-growth-asymptotics]].

## Practice problems

1. Give pre/postconditions for an algorithm that returns the **index** of the minimum of a non-empty integer array.
2. State an invariant for a loop that computes `sum := a1+…+an` and use it to prove correctness.
3. Is "if the algorithm halts, output is sorted" partial or total correctness? What extra fact gives total correctness?
4. Why must linear search use "$i\le n$ **and** $x\neq a_i$" (short-circuit) rather than "$x\neq a_i$ **and** $i\le n$"?

<details><summary>Solutions</summary>

1. P: array $A[1..n]$, $n\ge1$. Q: returns $j$ with $A[j]\le A[k]\ \forall k$ and $1\le j\le n$.
2. Invariant: after $k$ iterations `sum` $=a_1+\dots+a_k$. Init ($k=0$): sum$=0$ ✓. Maintenance: adding $a_{k+1}$ keeps it ✓. Termination $k=n$ ⇒ sum$=\sum_{i=1}^n a_i$ ✓.
3. Partial. Total correctness additionally requires proving the algorithm **always terminates**.
4. To avoid evaluating $a_i$ when $i>n$ (out-of-bounds). Order matters because `and` short-circuits left to right.
</details>

## Common pitfalls / exam tips
- Don't confuse the three invariant parts — name them (Initialization / Maintenance / Termination) explicitly.
- Partial ≠ total: always check **termination** separately for full marks.
- A correct-looking program can still fail the postcondition on edge cases — state the precondition that rules them out.
- Loop-invariant maintenance is essentially an [[L3-induction-recursion]] inductive step.
