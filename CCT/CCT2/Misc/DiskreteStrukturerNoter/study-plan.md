# Study plan — Diskrete strukturer (1 week, full-time)

**Exam date:** assumed imminent (≤ ~1 week out) · **Budget:** 1 week × 42 h = **42 h** (7 days × three ~2 h blocks/day)
**Confidence:** weak = L2 number theory, L3 induction, L6 asymptotics, L7 sorting/recursion (extra time allocated); solid = L1, L4, L5, L8.

> Each block ≈ 2 h and maps to one note in `notes/`. Hard topics come first while focus is freshest; Part 1 (L1–4) runs Days 1–3, Part 2 (L5–8) Days 4–6, mocks on Days 3/6/7. Take a real break between blocks.

## Hour budget
```
Lec  Topic                                    Reading                        Wt  Hours
--------------------------------------------------------------------------------------
L1   Sets, relations, functions               Rosen 2.1-2.3, 2.5            1.0    1.5
L2   Number theory (mod, GCD, CRT, Fermat)    Rosen 4.1, 4.3, 4.4           4.5    7.0  <- weak
L3   Induction & recursion                    Rosen 5.1, 5.2, 5.3.2         4.5    6.0  <- weak
L4   Counting & pigeonhole                    Rosen 6.1-6.5                 2.0    2.5
L5   Algorithms & correctness                 Rosen 3.1-3.2                 2.0    2.5
L6   Growth & asymptotic complexity           Rosen 3.2, Cormen Ch.3        4.5    6.0  <- weak
L7   Sorting, recursion, greedy               Rosen 3, 5.4-5.5; Cormen 2.1  4.0    5.5  <- weak
L8   Basic data structures                    Cormen 10.1, 10.2, 10.4       2.0    2.5
--------------------------------------------------------------------------------------
     Mock exams / mixed review                both exam parts                      8.5
     TOTAL                                                                        42.0
```

## Exam structure reminder
- **Part 1 (lectures 1–4):** sets/relations/functions, number theory, induction & recursion, counting.
- **Part 2 (lectures 5–8):** algorithms & correctness, asymptotic complexity, sorting/recursion/greedy, data structures.
- Moodle has example questions for each part — use them as the end-of-part checkpoints.

## Week-by-week

### Day 1 — Part 1: sets + number theory (foundations)
- **Block 1 · L1 sets/relations/functions + start L2** — Read Rosen 2.1–2.3, 2.5; skim `notes/L1`. Practice: 4 problems (set ops + inclusion–exclusion, power set, injective/surjective check). Checkpoint: state subset/power-set/Cartesian-product definitions from memory.
- **Block 2 · L2 divisibility & modular arithmetic** — Read Rosen 4.1; `notes/L2`. Practice: 5 div-theorem/`mod` problems incl. a negative dividend; congruence-class questions. Checkpoint: compute $-17\bmod 5$ correctly and explain why $r\ge0$.
- **Block 3 · L2 GCD, LCM, Euclid** — Read Rosen 4.3. Practice: 4 Euclid GCDs + `lcm` via $ab=\gcd\cdot\operatorname{lcm}$. Checkpoint: run Euclid on a 3-digit pair without notes; last-nonzero-remainder rule.

### Day 2 — Part 1: number theory finish + induction
- **Block 4 · L2 CRT & Fermat** — Read Rosen 4.4. Practice: 2 CRT systems + 2 Fermat fast-exponentiation problems + 1 modular inverse (extended Euclid). Use `/practice number theory`. Checkpoint: solve a 2-congruence CRT system end-to-end.
- **Block 5 · L3 induction (ordinary)** — Read Rosen 5.1; `notes/L3`. Practice: 3 full summation/divisibility induction proofs, writing basis + IH + step explicitly. Checkpoint: prove $\sum i=n(n+1)/2$ from a blank page.
- **Block 6 · L3 strong induction & recursive definitions** — Read Rosen 5.2, 5.3.2. Practice: prime-factor existence (strong); write recursive defs of given sequences/sets. Checkpoint: explain when strong induction is needed vs ordinary.

### Day 3 — Part 1: counting + Part 1 mock
- **Block 7 · L3 recursion drill + L4 counting** — `/practice induction`, then read Rosen 6.1–6.3; `notes/L4`. Practice: 4 permutation/combination + 2 pigeonhole problems. Checkpoint: pick ordered-vs-unordered correctly on each.
- **Block 8 · L4 binomial + repetition** — Read Rosen 6.4–6.5. Practice: binomial expansion, Pascal's identity, stars-and-bars, multiset permutations. Checkpoint: coefficient of a term in $(x+y)^n$; $\binom{n+r-1}{r}$ word problem.
- **Block 9 · PART 1 MOCK (timed)** — Do the Moodle Part 1 example questions under exam time. Checkpoint: grade yourself; list every missed concept and re-read that note. `/practice <weak topic>` to patch gaps.

### Day 4 — Part 2: algorithms, correctness, asymptotics start
- **Block 10 · L5 algorithms & correctness** — Read Rosen 3.1; `notes/L5`. Practice: write pre/postconditions for 2 algorithms; do a full loop-invariant proof (Init/Maintenance/Termination) for `max`. Checkpoint: distinguish partial vs total correctness in one sentence each.
- **Block 11 · L6 Big-O/Ω/Θ definitions** — Read Rosen 3.2; `notes/L6`. Practice: 3 Big-O proofs giving explicit witnesses $C,k$. Checkpoint: prove $7n^2+3n+5=O(n^2)$ with witnesses.
- **Block 12 · L6 growth hierarchy & loop analysis** — Read Cormen Ch.3. Practice: rank functions by growth; find complexity of 3 nested/triangular loops. Checkpoint: reproduce the $1\prec\log n\prec n\prec n\log n\prec n^2\prec 2^n\prec n!$ hierarchy.

### Day 5 — Part 2: asymptotics finish + algorithm design
- **Block 13 · L6 practice** — `/practice asymptotic complexity`. Mixed bound proofs + best/worst/average case. Checkpoint: give worst- and best-case Θ for linear search and bubble sort with reasons.
- **Block 14 · L7 sorting** — Read Rosen 3, Cormen 2.1; `notes/L7`. Practice: trace bubble, insertion, and merge sort on $3,2,4,1,5$; fill the complexity table. Checkpoint: state each sort's best/avg/worst and merge sort's $n\log n$ origin.
- **Block 15 · L7 recursion & recursive correctness** — Read Rosen 5.4–5.5. Practice: write factorial/power/binary-search recursively; prove `power` correct by induction. Checkpoint: an induction-on-input-size correctness proof from scratch.

### Day 6 — Part 2: greedy + data structures + Part 2 mock
- **Block 16 · L7 greedy + recursion vs iteration** — Practice: greedy change-making + a counterexample where greedy fails; explain why recursive Fibonacci is exponential. `/practice algorithm design`. Checkpoint: give the greedy counterexample unprompted.
- **Block 17 · L8 data structures** — Read Cormen 10.1, 10.2, 10.4; `notes/L8`. Practice: trace stack vs queue on a sequence; heap array index arithmetic; fill the operation-complexity table. Checkpoint: LIFO/FIFO output orders + `PARENT/LEFT/RIGHT` formulas.
- **Block 18 · PART 2 MOCK (timed)** — Moodle Part 2 example questions under time. Checkpoint: grade, log misses, re-read the relevant note.

### Day 7 — Mixed mock + targeted review (lighter)
- **Block 19 · FULL MIXED MOCK (timed)** — Combine Part 1 + Part 2 example questions in one sitting to rehearse switching contexts. Checkpoint: total score + per-topic breakdown.
- **Block 20 · Error review** — Redo every problem missed across the three mocks, from scratch this time. Checkpoint: each previously-missed problem now solved unaided.
- **Block 21 · Anki + formula sheet (light)** — Run the full Anki deck (`notes/anki-cards.txt`); write a one-page formula sheet (Euclid, CRT, Fermat, induction template, $O$ witnesses, sort complexities, heap indices). Checkpoint: recall the whole sheet once, then rest before the exam.

## How to use the helper skills
- `/study-notes <lecture|topic>` — regenerate or expand any note before a block.
- `/practice <topic>` — drill problems with worked solutions at each checkpoint.

*Adjust if your real window differs:* with more than a week, insert a second pass over the weak topics (L2, L3, L6, L7) and add a third mock; with less, keep Days 1–2 (number theory + induction) and Days 4–5 (asymptotics + design) and compress the lighter topics (L1, L4, L5, L8) into single half-blocks.
