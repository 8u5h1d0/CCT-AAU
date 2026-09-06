# L1 — Sets, Relations, Functions (≈2h block)

**Topic & reading**: Sets, set operations & cardinality, Cartesian product, relations, functions — Rosen **2.1, 2.2, 2.3, 2.5** (Lecture 1 / Module I).

Exam relevance: Part 1. Foundational — every later topic (number theory, counting, algorithm modelling) reuses this notation.

---

## Key definitions

- **Set (mængde)** — an *unordered* collection of *distinct* objects (elements/members). $a \in A$ / $a \notin A$. Distinct ⇒ no repetitions; unordered ⇒ $\{1,2\}=\{2,1\}$.
- **Roster vs. set-builder notation (opbyggende notation)** — list elements $\{0,1\}$, or by property $A=\{x \mid P(x)\}$.
- Standard sets: $\mathbb{N}=\{0,1,2,\dots\}$, $\mathbb{Z}$, $\mathbb{Z}^+$, $\mathbb{Q}=\{p/q \mid p,q\in\mathbb{Z}, q\neq 0\}$, $\mathbb{R}$, $\mathbb{R}^+$, $\mathbb{C}$.
- **Empty set (tomme mængde)** — $\emptyset$ or $\{\}$. Note $\emptyset \neq \{\emptyset\}$.
- **Subset (delmængde)** — $A\subseteq B$ iff every element of $A$ is in $B$. **Proper subset (ægte delmængde)** $A\subset B$ ⇒ $A\subseteq B$ and $A\neq B$.
- **Cardinality (kardinalitet)** — $|S|$ = number of distinct elements (finite set). A set is **infinite (uendelig)** if not finite; infinite sets can be *countable* or *uncountable*.
- **Power set (potensmængde)** — $\mathcal{P}(S)$ = set of all subsets of $S$.
- **Ordered $n$-tuple** — $(a_1,\dots,a_n)$, order matters. Ordered pair: $(a,b)=(c,d)$ iff $a=c \wedge b=d$.
- **Cartesian product (kartesisk produkt)** — $A\times B=\{(a,b)\mid a\in A \wedge b\in B\}$.
- **Relation (relation)** — any subset $R\subseteq A\times B$.
- **Function (funktion)** $f:A\to B$ — assigns to each $a\in A$ **exactly one** $f(a)\in B$. $A$ = domain (definitionsmængde), $B$ = codomain. **Range (værdimængde)** = $\{f(a)\mid a\in A\}\subseteq B$.

## Theorems & formulas

- $\emptyset \subseteq S$ and $S\subseteq S$ for every set $S$.
- **Set equality**: $A=B$ iff $A\subseteq B$ and $B\subseteq A$.
- **Cardinality of power set**: $|S|=n \Rightarrow |\mathcal{P}(S)|=2^n$.
- **Size of Cartesian product**: $|A\times B|=|A|\cdot|B|$; in general $|A_1\times\cdots\times A_k|=\prod_i |A_i|$. Note $A\times B \neq B\times A$ in general.
- Set operations (Rosen 2.2):
  - Union $A\cup B=\{x\mid x\in A \vee x\in B\}$, intersection $A\cap B=\{x\mid x\in A \wedge x\in B\}$.
  - Difference $A\setminus B=\{x\mid x\in A\wedge x\notin B\}$, complement $\bar A = U\setminus A$.
  - **Inclusion–exclusion (2 sets)**: $|A\cup B|=|A|+|B|-|A\cap B|$.
  - **De Morgan**: $\overline{A\cup B}=\bar A\cap\bar B$, $\overline{A\cap B}=\bar A\cup\bar B$.
- **Function types (2.3)**:
  - **Injective / one-to-one (injektiv)**: $f(a)=f(b)\Rightarrow a=b$.
  - **Surjective / onto (surjektiv)**: range = codomain.
  - **Bijective (bijektiv)**: injective + surjective ⇒ has inverse $f^{-1}$.
- Two finite sets have the same cardinality iff there is a bijection between them (basis for "countable").

## Worked example

**Q:** $A=\{-1,0,1\}$, $B=\{0,1\}$. Give $A\times B$ and one relation $R$ on it.

$A\times B=\{(-1,0),(-1,1),(0,0),(0,1),(1,0),(1,1)\}$ — six pairs since $|A\times B|=3\cdot 2=6$.

A relation is any subset, e.g. $R=\{(-1,1),(0,0),(1,1)\}$. (Here $R$ encodes "$b=|a|$" — relations can capture rules.)

**Q:** $|\mathcal{P}(\{a,b,c\})|$? = $2^3=8$: $\emptyset,\{a\},\{b\},\{c\},\{a,b\},\{a,c\},\{b,c\},\{a,b,c\}$.

## Practice problems

1. Let $U=\{1,\dots,10\}$, $A=\{1,2,3,4,5\}$, $B=\{4,5,6,7\}$. Find $A\cup B$, $A\cap B$, $A\setminus B$, $\bar A$, and verify inclusion–exclusion for $|A\cup B|$.
2. Is $f:\mathbb{Z}\to\mathbb{Z}$, $f(x)=2x$ injective? surjective? bijective?
3. Give $\mathcal{P}(\{1,2\})$ and its cardinality.
4. Prove $\overline{A\cap B}=\bar A\cup\bar B$ by showing mutual subset inclusion.

<details><summary>Solutions</summary>

1. $A\cup B=\{1,2,3,4,5,6,7\}$, $A\cap B=\{4,5\}$, $A\setminus B=\{1,2,3\}$, $\bar A=\{6,7,8,9,10\}$. Check: $|A\cup B|=7$, $|A|+|B|-|A\cap B|=5+4-2=7$. ✓
2. Injective: $2x=2y\Rightarrow x=y$ ✓. Surjective: no — odd numbers are never $2x$, so range $=$ even integers $\subsetneq \mathbb{Z}$. Not bijective.
3. $\{\emptyset,\{1\},\{2\},\{1,2\}\}$, cardinality $2^2=4$.
4. ($\subseteq$) $x\in\overline{A\cap B}\Rightarrow x\notin A\cap B\Rightarrow x\notin A$ or $x\notin B\Rightarrow x\in\bar A\cup\bar B$. ($\supseteq$) reverse each step (all iff). Hence equal.
</details>

## Common pitfalls / exam tips
- $\subseteq$ vs $\in$: $\{1\}\subseteq\{1,2\}$ but $\{1\}\notin\{1,2\}$; however $\{1\}\in\mathcal{P}(\{1,2\})$.
- To **disprove** $A\subseteq B$, exhibit one $x\in A$ with $x\notin B$ (counterexample suffices).
- A relation need not be a function; a function is a *special* relation (each input → exactly one output). Used in [[L5-algorithms-correctness]] to model problems.
- Cartesian product is **not** commutative: $(a,b)\neq(b,a)$.
