# L2 — Number Theory (≈2h block)

**Topic & reading**: Divisibility, division theorem, congruences & modular arithmetic, primes & factorization, GCD/LCM, Euclid's algorithm, CRT, Fermat's little theorem — Rosen **4.1, 4.3, 4.4** (Lecture 2 / Module II).

Exam relevance: Part 1, one of the harder topics — expect computation (Euclid, mod arithmetic, CRT) **and** short proofs.

---

## Key definitions

- **Divides (går op i / dividerer)** — for $a\neq 0$, $a\mid b$ iff $\exists c\in\mathbb{Z}$ with $b=ac$. Then $a$ is a *factor/divisor*, $b$ a *multiple*.
- **Prime (primtal)** — integer $p>1$ whose only positive divisors are $1$ and $p$; otherwise **composite (sammensat)**.
- **GCD (største fælles divisor)** — $\gcd(a,b)$ = largest $d$ with $d\mid a$ and $d\mid b$. **Relatively prime (indbyrdes primiske)**: $\gcd(a,b)=1$.
- **LCM (mindste fælles multiplum)** — $\operatorname{lcm}(a,b)$ = smallest positive integer divisible by both.
- **Congruence (kongruens)** — $a\equiv b \pmod m$ iff $m\mid(a-b)$, i.e. iff $a\bmod m=b\bmod m$. **Congruence class** $[a]_m=\{i\in\mathbb{Z}\mid i\equiv a\pmod m\}$.
- $\mathbb{Z}_m=\{0,1,\dots,m-1\}$, with $a+_m b=(a+b)\bmod m$ and $a\cdot_m b=(a\cdot b)\bmod m$.

## Theorems & formulas

**Divisibility (4.1)**: if $a\mid b$ and $a\mid c$ then $a\mid(b+c)$; $a\mid b \Rightarrow a\mid bc$; transitive ($a\mid b, b\mid c\Rightarrow a\mid c$). Linear combination: $a\mid b, a\mid c \Rightarrow a\mid(mb+nc)$ for all $m,n\in\mathbb{Z}$.

**Division theorem (divisionsalgoritmen)**: for integer $a$, positive $d$, there exist **unique** $q,r$ with $0\le r<d$ and
$$a=dq+r,\qquad q=a\;\mathbf{div}\;d=\lfloor a/d\rfloor,\quad r=a\;\mathbf{mod}\;d.$$
The remainder is **never negative**: e.g. $-11=3\cdot(-4)+1$, so $-11\bmod 3=1$ (not $-2$).

**Congruence arithmetic**: $a\equiv b\pmod m$ iff $a=b+km$ for some $k$. If $a\equiv b$ and $c\equiv d \pmod m$ then
$$a+c\equiv b+d \pmod m,\qquad ac\equiv bd \pmod m.$$
$\mathbb{Z}_m$ is closed, associative, commutative, has identities $0,1$, additive inverse of $a$ is $m-a$, and distributes.

**Fundamental theorem of arithmetic (aritmetikkens fundamentalsætning)**: every integer $>1$ is a prime or a unique product of primes in nondecreasing order. Useful fact: if $n$ is composite it has a prime divisor $\le \sqrt n$ (so to test primality, trial-divide by primes up to $\sqrt n$).

**GCD/LCM via factorization**: if $a=\prod p_i^{a_i}$, $b=\prod p_i^{b_i}$ then
$$\gcd(a,b)=\prod p_i^{\min(a_i,b_i)},\qquad \operatorname{lcm}(a,b)=\prod p_i^{\max(a_i,b_i)},\qquad \boxed{a\cdot b=\gcd(a,b)\cdot\operatorname{lcm}(a,b)}.$$

**Euclid's algorithm** — based on: if $a=bq+r$ then $\gcd(a,b)=\gcd(b,r)$. Iterate $\gcd(a,b)=\gcd(b,\,a\bmod b)$ until the second argument is $0$; $\gcd(a,0)=a$. Far faster than factoring.

**Bézout**: $\gcd(a,b)=sa+tb$ for some integers $s,t$ (extended Euclid). This gives the **modular inverse**: if $\gcd(a,m)=1$ then $\bar a$ with $a\bar a\equiv 1\pmod m$ exists and equals $s$ from $sa+tm=1$.

**Chinese Remainder Theorem (CRT)**: if $m_1,\dots,m_k$ are pairwise relatively prime, the system $x\equiv a_i\pmod{m_i}$ has a unique solution mod $M=\prod m_i$:
$$x=\sum_i a_i M_i y_i \bmod M,\quad M_i=M/m_i,\quad y_i = M_i^{-1}\bmod m_i.$$

**Fermat's little theorem**: if $p$ is prime and $p\nmid a$, then $a^{p-1}\equiv 1\pmod p$; equivalently $a^p\equiv a\pmod p$ for all $a$.

## Worked examples

**Euclid — $\gcd(414,662)$:**
$662=1\cdot414+248$ → $414=1\cdot248+166$ → $248=1\cdot166+82$ → $166=2\cdot82+2$ → $82=41\cdot2+0$. Last nonzero remainder $=\boxed{2}$.

**Fermat (fast exponentiation):** compute $7^{222}\bmod 11$. By Fermat $7^{10}\equiv1$. $222=22\cdot10+2$, so $7^{222}=(7^{10})^{22}\cdot7^2\equiv 1\cdot49\equiv 49\bmod11\equiv \boxed{5}$.

**CRT:** solve $x\equiv2\pmod3,\ x\equiv3\pmod5,\ x\equiv2\pmod7$. $M=105$; $M_1=35,M_2=21,M_3=15$. Inverses: $35\equiv2\pmod3\Rightarrow y_1=2$; $21\equiv1\pmod5\Rightarrow y_2=1$; $15\equiv1\pmod7\Rightarrow y_3=1$. $x=2\cdot35\cdot2+3\cdot21\cdot1+2\cdot15\cdot1=140+63+30=233\equiv\boxed{23}\pmod{105}$.

## Practice problems

1. Find $q,r$ for $a=-17$, $d=5$ with $0\le r<5$.
2. Use Euclid for $\gcd(1071,462)$, then give $\operatorname{lcm}$.
3. Solve $x\equiv1\pmod4,\ x\equiv2\pmod9$ with CRT.
4. Compute $3^{302}\bmod 7$ using Fermat.
5. Find the inverse of $5$ modulo $26$.

<details><summary>Solutions</summary>

1. $-17=5\cdot(-4)+3$, so $q=-4,\ r=3$.
2. $1071=2\cdot462+147$; $462=3\cdot147+21$; $147=7\cdot21+0$ ⇒ $\gcd=21$. $\operatorname{lcm}=1071\cdot462/21=23562$.
3. $m_1=4,m_2=9$, $M=36$, $M_1=9,M_2=4$. $9\equiv1\pmod4⇒y_1=1$; $4y_2\equiv1\pmod9⇒y_2=7$ (since $28\equiv1$). $x=1\cdot9\cdot1+2\cdot4\cdot7=9+56=65\equiv29\pmod{36}$.
4. $3^6\equiv1\pmod7$; $302=6\cdot50+2$ ⇒ $3^{302}\equiv3^2=9\equiv2\pmod7$.
5. Extended Euclid on $5,26$: $26=5\cdot5+1$ ⇒ $1=26-5\cdot5$ ⇒ $-5\cdot5\equiv1\pmod{26}$ ⇒ inverse $=-5\equiv21$.
</details>

## Common pitfalls / exam tips
- **Negative mod**: $r$ must be in $[0,d)$. $-11\bmod3=1$, not $-2$.
- Euclid: stop at remainder $0$; answer is the **last nonzero** remainder.
- CRT needs **pairwise** coprime moduli; modular inverse needs $\gcd(a,m)=1$.
- For large powers, reduce the exponent with Fermat first, then multiply — never expand fully.
- Reuses divisibility/linear-combination proofs that recur in [[L3-induction-recursion]].
