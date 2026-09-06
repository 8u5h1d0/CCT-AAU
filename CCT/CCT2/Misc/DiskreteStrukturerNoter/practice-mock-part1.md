# Mock exam — Part 1 (discrete mathematics, L1–4)

**Time:** 90 min · **Total:** 100 points · Closed book, but a one-page formula sheet is allowed.
Covers sets/relations/functions (L1), number theory (L2), induction & recursion (L3), counting (L4). Attempt all problems before checking solutions. Show full reasoning — partial credit follows the method.

---

## Problems

**1. Sets & functions (12 p).**
Let $U=\{1,2,\dots,12\}$, $A=\{x\in U \mid x \text{ is even}\}$, $B=\{x\in U\mid 3\mid x\}$.
(a) List $A$, $B$, $A\cap B$, $A\cup B$, $A\setminus B$.
(b) Verify the inclusion–exclusion identity for $|A\cup B|$.
(c) Is $f:U\to\mathbb{Z}$, $f(x)=x\bmod 3$, injective? surjective onto $\{0,1,2\}$? Justify.

**2. Power set & Cartesian product (10 p).**
Let $S=\{a,b,c\}$.
(a) Give $\mathcal{P}(S)$ and $|\mathcal{P}(S)|$.
(b) For $X=\{1,2\}$, $Y=\{a,b\}$, list $X\times Y$ and state $|X\times Y|$.
(c) How many relations are there from $X$ to $Y$? Explain.

**3. Number theory — Euclid & inverse (16 p).**
(a) Use the Euclidean algorithm to compute $\gcd(252,198)$, showing each step.
(b) Hence give $\operatorname{lcm}(252,198)$.
(c) Find the multiplicative inverse of $11$ modulo $26$ (extended Euclid).

**4. Number theory — CRT & Fermat (16 p).**
(a) Solve the system $x\equiv 2\pmod 5,\ x\equiv 3\pmod 7$ using the Chinese Remainder Theorem; give the unique solution modulo $35$.
(b) Use Fermat's little theorem to compute $3^{201}\bmod 11$.

**5. Induction (16 p).**
Prove by mathematical induction that for all integers $n\ge 1$,
$$\sum_{i=1}^{n} i\cdot 2^{i} = (n-1)2^{n+1}+2.$$
State the basis, the inductive hypothesis, and mark where the IH is used.

**6. Strong induction / recursion (14 p).**
(a) Give a recursive definition (base + recursive step) of the sequence $2,5,8,11,\dots$ and of $1,2,4,8,16,\dots$.
(b) Prove by strong induction that every integer $n\ge 2$ can be written as a product of primes.

**7. Counting (16 p).**
A password is a string of length 6 over the 26 lowercase letters.
(a) How many passwords are there in total?
(b) How many contain no repeated letter?
(c) How many contain at least one repeated letter?
(d) From a club of 12 people, how many ways to choose a 4-person committee, and how many ways to choose a president, vice-president and treasurer (distinct people)?

---

## Solutions

**1.**
(a) $A=\{2,4,6,8,10,12\}$, $B=\{3,6,9,12\}$, $A\cap B=\{6,12\}$, $A\cup B=\{2,3,4,6,8,9,10,12\}$, $A\setminus B=\{2,4,8,10\}$.
(b) $|A\cup B|=8$; $|A|+|B|-|A\cap B|=6+4-2=8$. ✓
(c) **Not injective**: $f(1)=f(4)=1$ (many inputs share an image). **Surjective onto $\{0,1,2\}$**: $f(3)=0,f(1)=1,f(2)=2$, so all three residues are hit. ✓

**2.**
(a) $\mathcal{P}(S)=\{\emptyset,\{a\},\{b\},\{c\},\{a,b\},\{a,c\},\{b,c\},\{a,b,c\}\}$; $|\mathcal{P}(S)|=2^3=8$.
(b) $X\times Y=\{(1,a),(1,b),(2,a),(2,b)\}$, $|X\times Y|=2\cdot2=4$.
(c) A relation is any subset of $X\times Y$, so there are $2^{|X\times Y|}=2^4=16$ relations.

**3.**
(a) $252=1\cdot198+54$; $198=3\cdot54+36$; $54=1\cdot36+18$; $36=2\cdot18+0$. Last nonzero remainder $\Rightarrow \gcd=18$.
(b) $\operatorname{lcm}=\dfrac{252\cdot198}{18}=\dfrac{49896}{18}=2772$.
(c) $\gcd(11,26)=1$ so the inverse exists. Extended Euclid: $26=2\cdot11+4$; $11=2\cdot4+3$; $4=1\cdot3+1$. Back-substitute: $1=4-1\cdot3=4-(11-2\cdot4)=3\cdot4-11=3(26-2\cdot11)-11=3\cdot26-7\cdot11$. So $-7\cdot11\equiv1\pmod{26}$ ⇒ inverse $=-7\equiv\boxed{19}$ (check $11\cdot19=209=8\cdot26+1$ ✓).

**4.**
(a) $M=35$, $M_1=7$, $M_2=5$. Inverses: $7\equiv2\pmod5$, need $2y_1\equiv1\pmod5\Rightarrow y_1=3$; $5\equiv5\pmod7$, need $5y_2\equiv1\pmod7\Rightarrow y_2=3$ (since $15\equiv1$). $x=2\cdot7\cdot3+3\cdot5\cdot3=42+45=87\equiv87-2\cdot35=\boxed{17}\pmod{35}$. (Check: $17\bmod5=2$ ✓, $17\bmod7=3$ ✓.)
(b) $p=11$, $3^{10}\equiv1$. $201=20\cdot10+1$, so $3^{201}=(3^{10})^{20}\cdot3\equiv1\cdot3=\boxed{3}\pmod{11}$.

**5.**
Let $P(n):\ \sum_{i=1}^n i\,2^i=(n-1)2^{n+1}+2$.
**Basis** $n=1$: LHS $=1\cdot2=2$; RHS $=(0)2^{2}+2=2$. ✓
**IH:** assume $\sum_{i=1}^k i\,2^i=(k-1)2^{k+1}+2$.
**Step:**
$$\sum_{i=1}^{k+1} i\,2^i=\underbrace{\sum_{i=1}^{k} i\,2^i}_{\text{IH}}+(k+1)2^{k+1}=(k-1)2^{k+1}+2+(k+1)2^{k+1}.$$
Combine the $2^{k+1}$ terms: $\big[(k-1)+(k+1)\big]2^{k+1}+2=2k\cdot2^{k+1}+2=k\cdot2^{k+2}+2=\big((k+1)-1\big)2^{(k+1)+1}+2.$
This is $P(k+1)$. By induction $P(n)$ holds for all $n\ge1$. $\blacksquare$

**6.**
(a) Arithmetic, step $+3$: $a_1=2,\ a_n=a_{n-1}+3$. Geometric, ratio $2$: $b_1=1,\ b_n=2b_{n-1}$.
(b) **Basis** $n=2$: $2$ is prime, i.e. a product of one prime. ✓
**Strong IH:** assume every integer $j$ with $2\le j\le k$ is a product of primes.
**Step:** consider $k+1$. If $k+1$ is prime, it is a product of one prime — done. Otherwise $k+1=ab$ with $2\le a,b\le k$. By the IH both $a$ and $b$ are products of primes, so their product $k+1$ is too. By strong induction the claim holds for all $n\ge2$. $\blacksquare$
*(Strong induction is needed because the factors $a,b$ are smaller than $k$, not equal to $k$.)*

**7.**
(a) $26^6 = 308\,915\,776$.
(b) No repeats = $P(26,6)=26\cdot25\cdot24\cdot23\cdot22\cdot21 = 165\,765\,600$.
(c) At least one repeat = total − no-repeat $=26^6-P(26,6)=308\,915\,776-165\,765\,600=143\,150\,176$.
(d) Committee (unordered): $\binom{12}{4}=495$. Officers (ordered, distinct roles): $P(12,3)=12\cdot11\cdot10=1320$.

---

### Self-grading
Tally your points. Below ~70: re-read the relevant note ([[L1-sets-relations-functions]], [[L2-number-theory]], [[L3-induction-recursion]], [[L4-counting]]) and redo the missed item from a blank page. Number theory and induction carry the most points — prioritise them.
