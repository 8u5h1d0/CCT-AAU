Here is the comprehensive exam question list, organized by topic and covering all cases and variations from your notes and the sample questions.

---

# Comprehensive Exam Question List

## PART 1 — DISCRETE MATHEMATICS

---

### 1. Sets — Basics, Notation, and Operations

1. Define a set. What is the difference between roster notation and set-builder notation? Give an example of each.
2. Express the set of all positive even integers less than 20 in both roster notation and set-builder notation.
3. What is the empty set? Is $\emptyset$ the same as $\{\emptyset\}$? Justify your answer.
4. Define what it means for $A$ to be a subset of $B$. How do you prove $A \subseteq B$? How do you prove $A \not\subseteq B$?
5. Prove that the empty set is a subset of every set.
6. Prove that every set is a subset of itself.
7. How do you prove that two sets $A$ and $B$ are equal? Show that $A = \{x \mid x \text{ is a subset of } \{a,b\}\}$ equals $\{\emptyset, \{a\}, \{b\}, \{a,b\}\}$.
8. Given $U = \{1,2,3,4,5,6,7,8,9,10\}$ and $A = \{2,4,6,8,10\}$, find $\overline{A}$.
9. Given $A = \{1,2,3,4\}$ and $B = \{3,4,5,6\}$, find $A \cup B$, $A \cap B$, $A - B$, and $B - A$.
10. Are two disjoint sets the same as sets whose difference is empty? Explain and give examples.
11. State and prove De Morgan's law for sets: $\overline{A \cap B} = \overline{A} \cup \overline{B}$.
12. State and prove De Morgan's law for sets: $\overline{A \cup B} = \overline{A} \cap \overline{B}$.
13. State and prove the distributive law: $A \cap (B \cup C) = (A \cap B) \cup (A \cap C)$.
14. State and prove the absorption law $A \cup (A \cap B) = A$.
15. State and prove the complement law $A \cup \overline{A} = U$.
16. Using set identities, simplify $\overline{(\overline{A} \cup B)} \cup (A \cap B)$.
17. Let $U = \{1,\ldots,10\}$, $A = \{1,3,5,7,9\}$, $B = \{1,2,3\}$. Find $\overline{A \cap B}$ and verify it equals $\overline{A} \cup \overline{B}$.
18. What is the principle of inclusion–exclusion for two sets? A survey of 100 students finds 60 study maths, 45 study CS, and 30 study both. How many study at least one subject? How many study neither?
19. Represent the set $\{1,3,5,7,9\}$ as a bit string given $U = \{1,2,\ldots,10\}$ in increasing order. Then find the bit string for its complement.
20. Given the bit strings `1110000000` and `1010101010` (with $U = \{1,\ldots,10\}$ in order), find the union and intersection as both bit strings and sets.
21. Given multisets $P = \{3 \cdot a, 1 \cdot b, 2 \cdot c\}$ and $Q = \{1 \cdot a, 4 \cdot b, 2 \cdot d\}$, find $P \cup Q$, $P \cap Q$, $P - Q$, and $P + Q$.

---

### 2. Power Sets and Cartesian Products

22. What is the power set of a set? What is its cardinality if $|S| = n$? Prove this formula.
23. Find $\mathcal{P}(\{0,1,2\})$. List all its elements.
24. Find $\mathcal{P}(\emptyset)$ and $\mathcal{P}(\{\emptyset\})$. How many elements does each have?
25. A set $S$ has $\mathcal{P}(S)$ with 32 elements. How many elements does $S$ have?
26. What is the Cartesian product? Illustrate it for $A = \{1,2,3\}$ and $B = \{x,y\}$.
27. Is $A \times B = B \times A$ in general? Give a counterexample.
28. Given $A = \{0,1\}$, $B = \{1,2\}$, $C = \{0,1,2\}$, compute $A \times B \times C$.
29. What is $A^2$ for $A = \{1,2\}$? List all elements.
30. What is the cardinality of $A \times B$ if $|A| = m$ and $|B| = n$?
31. What is a relation from $A$ to $B$? Give an example using a subset of $A \times B$ where $A = \{0,1,2,3\}$ and the relation is "less than or equal to."

---

### 3. Functions

32. What is the defining property of a function? Define domain, codomain, range, image, and preimage with examples.
33. Let $f: \mathbb{Z} \to \mathbb{Z}$ be defined by $f(x) = x^2$. What is the domain? The codomain? The range? Is the range equal to the codomain?
34. Define an injective (one-to-one) function. How do you prove a function is injective? How do you disprove it?
35. Define a surjective (onto) function. How do you prove a function is surjective? How do you disprove it?
36. Define a bijection. What additional property does a bijection have that neither an injection nor a surjection alone has?
37. Provide an example of a bijection between two finite sets. Verify it is both injective and surjective.
38. Provide an example of an injection that is not a surjection.
39. Provide an example of a surjection that is not an injection.
40. Provide an example of a function that is neither injective nor surjective.
41. Is $f(x) = x + 1$ from $\mathbb{Z}$ to $\mathbb{Z}$ injective? Surjective? Bijective? Justify fully.
42. Is $f(x) = x^2$ from $\mathbb{Z}$ to $\mathbb{Z}$ injective? Surjective? Justify fully.
43. Is $f(x) = 2x + 3$ from $\mathbb{R}$ to $\mathbb{R}$ injective? Surjective? Find its inverse if it is bijective.
44. Let $f(x) = 2x + 3$ and $g(x) = 3x + 2$ from $\mathbb{Z}$ to $\mathbb{Z}$. Compute $f \circ g$ and $g \circ f$. Are they equal?
45. When does an inverse function $f^{-1}$ exist? Find $f^{-1}$ for $f(x) = x + 1$ from $\mathbb{Z}$ to $\mathbb{Z}$.
46. How many functions are there from a set with $m$ elements to a set with $n$ elements? How many of these are one-to-one (assuming $m \leq n$)?
47. Let $A = \{a,b,c,d,e\}$ and $B = \{1,2,3,4\}$ with $f(a)=2, f(b)=1, f(c)=4, f(d)=1, f(e)=1$. Find $f(\{b,c,d\})$. Is $f$ injective? Surjective?

---

### 4. Floor and Ceiling Functions

48. What are the floor and ceiling functions? What is $\lfloor 3.14 \rfloor$? $\lceil 3.14 \rceil$? $\lfloor 7 \rfloor$? $\lceil 7 \rceil$?
49. What is $\lfloor -1/2 \rfloor$? $\lceil -1/2 \rceil$? $\lfloor -2.7 \rfloor$? $\lceil -2.7 \rceil$?
50. Prove the translation property: $\lfloor x + n \rfloor = \lfloor x \rfloor + n$ for integer $n$.
51. Prove or disprove: $\lceil x + y \rceil = \lceil x \rceil + \lceil y \rceil$ for all real $x, y$.
52. Prove that $\lfloor 2x \rfloor = \lfloor x \rfloor + \lfloor x + \frac{1}{2} \rfloor$ for all real $x$.
53. A file is 100 bits long. Each byte holds 8 bits. How many bytes are needed? Use the ceiling function.
54. State property (3a): $\lfloor -x \rfloor = -\lceil x \rceil$. Verify it for $x = 2.3$ and $x = -2.3$.

---

### 5. Cardinality and Countability

55. When is a set countable? When is it uncountable?
56. Can an infinite set be countable? Show that the set of odd positive integers is countable by exhibiting a bijection with $\mathbb{Z}^+$.
57. Show that the set of all integers $\mathbb{Z}$ is countable.
58. Show (or sketch the argument) that the set of rational numbers $\mathbb{Q}$ is countable.
59. Show that the set of real numbers $\mathbb{R}$ is uncountable. (Cantor's diagonal argument.)
60. State the Schröder–Bernstein theorem. Use it to show $|(0,1)| = |(0,1]|$.
61. What is $\aleph_0$? What sets have cardinality $\aleph_0$?
62. State the Continuum Hypothesis. What is its status under standard axioms?
63. Why are most functions from $\mathbb{Z}^+$ to $\mathbb{Z}^+$ uncomputable?
64. Prove that the union of two countable sets is countable.

---

### 6. Divisibility and Modular Arithmetic

65. Define divisibility. What does $a \mid b$ mean? Express it using a quantifier.
66. Determine whether $3 \mid 12$ and $3 \mid 7$. Justify.
67. How many positive integers not exceeding $n$ are divisible by $d$?
68. State and prove the three properties of divisibility (sum, product, transitivity).
69. State the Division Algorithm. What are the quotient and remainder when $101$ is divided by $11$? When $-11$ is divided by $3$?
70. Define congruence modulo $m$. What is the difference between "$a \equiv b \pmod{m}$" and "$a \bmod m$"?
71. Are $7$ and $11$ congruent modulo $3$? Justify. Are $17$ and $5$ congruent modulo $6$? Are $24$ and $14$ congruent modulo $6$?
72. State and prove: $a \equiv b \pmod{m}$ if and only if there exists an integer $k$ such that $a = b + km$.
73. What is a congruence class? Give the congruence class of $2$ modulo $5$.
74. State and prove: if $a \equiv b \pmod{m}$ and $c \equiv d \pmod{m}$, then $a+c \equiv b+d \pmod{m}$ and $ac \equiv bd \pmod{m}$.
75. Compute $7 +_{11} 9$ and $7 \cdot_{11} 9$.
76. Add $8$ and $11$ modulo $9$. What is the additive inverse of $3$ modulo $7$?
77. Why does cancellation in modular arithmetic require $\gcd(c,m)=1$? Give a counterexample where it fails without this condition.
78. Give an example of the use of modular arithmetic in a real-world application (e.g., check digits, hashing, cryptography).

---

### 7. Primes and GCD/LCM

79. Define a prime number and a composite number. Is $1$ prime? Justify.
80. State the Fundamental Theorem of Arithmetic. Find the prime factorizations of $7007$, $100$, $999$.
81. Show that $101$ is prime using trial division.
82. Describe the Sieve of Eratosthenes. List all primes less than $30$.
83. Prove there are infinitely many primes.
84. What are Mersenne primes? Give three examples and one non-example.
85. State the Prime Number Theorem. What does $\pi(x) \approx x/\ln x$ mean?
86. Are $9$ and $37$ relatively prime? Are $5$ and $12$ relatively prime? Justify using GCD.
87. Define relatively prime. Define pairwise relatively prime. Are $10$, $17$, and $21$ pairwise relatively prime?
88. Find $\gcd(14, 104)$ using the Euclidean algorithm. Show all steps.
89. Find $\gcd(414, 662)$ using the Euclidean algorithm.
90. State and prove the GCD Reduction Lemma: $\gcd(a,b) = \gcd(b, a \bmod b)$.
91. Find the GCD of $24$ and $36$ by listing common divisors.
92. What is the LCM of $12$ and $18$? Find it using prime factorizations.
93. Compute $\gcd(120, 500)$ and $\text{lcm}(120, 500)$ using prime factorizations.
94. State and prove the product relationship: $ab = \gcd(a,b) \cdot \text{lcm}(a,b)$.
95. State Bézout's Theorem. Express $\gcd(252, 198) = 18$ as a linear combination of $252$ and $198$ using back-substitution.
96. Express $\gcd(318, 96)$ as a linear combination of $318$ and $96$.
97. State and prove: if $\gcd(a,b)=1$ and $a \mid bc$, then $a \mid c$.
98. State and prove the Prime Divisibility Lemma: if $p$ is prime and $p \mid a_1 a_2 \cdots a_n$, then $p \mid a_i$ for some $i$.
99. Prove the uniqueness of prime factorization.

---

### 8. Modular Inverses and Linear Congruences

100. Define the modular inverse of $a$ modulo $m$. When does it exist?
101. Find the inverse of $3$ modulo $7$ by inspection. Verify your answer.
102. Find the inverse of $3$ modulo $7$ using the Extended Euclidean Algorithm.
103. Does $2$ have an inverse modulo $6$? Why not? Check all values.
104. Find the inverse of $101$ modulo $4620$ using the Extended Euclidean Algorithm.
105. Find the inverse of $3$ modulo $11$ using Fermat's Little Theorem. Verify.
106. Does the linear congruence $5x \equiv 6 \pmod{10}$ have a solution? Does it have a unique solution? Justify.
107. Does the linear congruence $5x \equiv 4 \pmod{6}$ have a unique solution? Find all solutions.
108. Solve the linear congruence $3x \equiv 4 \pmod{7}$. Find all solutions.
109. Solve $3x \equiv 4 \pmod{7}$ by multiplying both sides by the inverse of $3$ modulo $7$. Verify.
110. For which values of $a$ and $m$ does $ax \equiv b \pmod{m}$ have no solution? One solution? Multiple solutions?

---

### 9. Chinese Remainder Theorem

111. State the Chinese Remainder Theorem. What condition on the moduli guarantees a unique solution?
112. Does the system $x \equiv 1 \pmod{3}$, $x \equiv 2 \pmod{8}$, $x \equiv 8 \pmod{17}$ have a unique solution modulo $408$? Why? Find the solution.
113. Does the system $x \equiv 1 \pmod{3}$, $x \equiv 2 \pmod{9}$, $x \equiv 8 \pmod{17}$ have a unique solution modulo $459$? Why?
114. Solve the system $x \equiv 2 \pmod{3}$, $x \equiv 3 \pmod{5}$, $x \equiv 2 \pmod{7}$ using the direct CRT formula. (Sun-Tsu's puzzle.)
115. Solve the system $x \equiv 1 \pmod{5}$, $x \equiv 2 \pmod{6}$, $x \equiv 3 \pmod{7}$ using back substitution.
116. Solve the system $x \equiv 2 \pmod{3}$, $x \equiv 1 \pmod{4}$, $x \equiv 3 \pmod{5}$ using back substitution.
117. Solve the system $x \equiv 4 \pmod{5}$, $x \equiv 2 \pmod{6}$, $x \equiv 3 \pmod{7}$ using the direct CRT formula.
118. Explain why the CRT fails when moduli are not pairwise coprime. Give a concrete example of a system with no solution.
119. How does the CRT enable computer arithmetic with large integers? Illustrate with a small example.
120. Represent all nonnegative integers less than $12$ as pairs $(a \bmod 3, a \bmod 4)$. Why are all pairs distinct?

---

### 10. Fermat's Little Theorem, Pseudoprimes, and Primitive Roots

121. State Fermat's Little Theorem. What are the two forms of the statement?
122. Find $7^{222} \bmod 11$ using Fermat's Little Theorem. Show all steps.
123. Find $9^{100} \bmod 13$ using Fermat's Little Theorem.
124. What is a pseudoprime to base $b$? Is $341$ a pseudoprime to base $2$? Verify.
125. What is a Carmichael number? Show that $561$ is a Carmichael number.
126. What is a primitive root modulo a prime $p$? Is $2$ a primitive root modulo $11$? Is $3$? Verify by computing all powers.
127. Define the discrete logarithm. Find $\log_2 3$ and $\log_2 5$ modulo $11$ (using the table of powers of $2$ mod $11$).
128. Why is the discrete logarithm problem important in cryptography?

---

### 11. Mathematical Induction — Standard

129. Explain the principle of mathematical induction. What are the basis step and inductive step?
130. Why is mathematical induction valid? (Connect to the well-ordering property.)
131. Prove by induction: $1 + 2 + 3 + \cdots + n = \frac{n(n+1)}{2}$.
132. Prove by induction: $1 + 3 + 5 + \cdots + (2n-1) = n^2$.
133. Prove by induction: $\sum_{j=0}^{n} ar^j = \frac{ar^{n+1}-a}{r-1}$ for $r \neq 1$.
134. Prove by induction: $n < 2^n$ for all positive integers $n$.
135. Prove by induction: $2^n < n!$ for all integers $n \geq 4$.
136. Prove by induction: $n^3 - n$ is divisible by $3$ for all positive integers $n$.
137. Prove by induction: $7^{n+2} + 8^{2n+1}$ is divisible by $57$ for all nonneg. integers $n$.
138. Prove by induction: if $S$ is a finite set with $n$ elements, then $S$ has $2^n$ subsets.
139. Prove by induction: $\overline{\bigcap_{j=1}^{n} A_j} = \bigcup_{j=1}^{n} \overline{A_j}$ for $n \geq 2$ (generalized De Morgan's law).
140. Prove by induction: $H_{2^n} \geq 1 + \frac{n}{2}$ for all nonneg. integers $n$, where $H_j$ is the $j$-th harmonic number. What does this imply about the harmonic series?
141. What is the correct basis step for a proof of $2^n < n!$? Why is $b = 1$ wrong here?
142. Find and explain the error: "Proof that all horses are the same color."

---

### 12. Mathematical Induction — Strong Induction

143. State strong induction. How does its inductive hypothesis differ from standard induction?
144. Are standard induction, strong induction, and well-ordering equivalent? Explain.
145. When should you use strong induction instead of standard induction? Give a criterion.
146. Prove by strong induction: every integer $n > 1$ can be written as a product of primes.
147. Prove by strong induction: every amount of postage of $12$ cents or more can be formed using $4$-cent and $5$-cent stamps (show both the standard induction and strong induction approaches).
148. Prove by strong induction: every simple polygon with $n \geq 3$ sides can be triangulated into $n-2$ triangles.
149. Use the well-ordering property to prove the Division Algorithm (existence of $q$ and $r$).

---

### 13. Recursive Definitions

150. Give a recursive definition of $n \cdot a$ where $a$ is a nonzero number and $n$ is a nonneg. integer.
151. Give a recursive definition of $a^n$ for nonzero real $a$ and nonneg. integer $n$.
152. Give a recursive definition of $\sum_{k=0}^{n} a_k$.
153. Give a recursive definition of $n!$. What is $7!$? What is $0!$?
154. Define the Fibonacci sequence recursively. Compute $F_0$ through $F_8$.
155. Prove by strong induction: $F_n > \alpha^{n-2}$ for $n \geq 3$, where $\alpha = \frac{1+\sqrt{5}}{2}$.
156. State Lamé's Theorem. How does it connect the Fibonacci sequence to the Euclidean algorithm's efficiency?
157. Give a recursive definition for the sequence $5, 9, 13, 17, 21, \ldots$
158. Give a recursive definition for the sequence $6, 12, 24, 48, \ldots$
159. Give a recursive definition for the sequence $18, 15, 12, 9, 6, \ldots$
160. Give a recursive definition for the set $S = \{1, 4, 9, 16, \ldots\}$.

---

### 14. Counting — Basic Principles

161. State the Product Rule. When does it apply?
162. State the Sum Rule. When does it apply? What condition must hold for the alternatives?
163. State the Subtraction Rule (Inclusion–Exclusion for two sets). When is it needed?
164. State the Division Rule. When does it apply, and what must be true about the overcounting?
165. A license plate consists of a sequence of 1, 2, or 3 letters (from the English alphabet) followed by exactly 6 digits. How many unique license plates can be made?
166. How many bit strings of length 7 are there? How many subsets does a set with 7 elements have?
167. A password is 6 to 8 characters long, using uppercase letters and digits, with at least one digit. How many valid passwords are there?
168. How many functions are there from a set of 3 elements to a set of 5 elements? How many are one-to-one?
169. How many bit strings of length 8 either start with `1` or end with `00`? Use the subtraction rule.
170. A company has 350 applicants: 220 majored in CS, 147 in business, 51 in both. How many majored in neither?
171. How many ways can 4 people be seated around a circular table, where two seatings are the same if each person has the same neighbours? Use the division rule.
172. An automated sensor counts 572 legs in a field. Assuming all animals are cows (4 legs each), how many cows are there?

---

### 15. The Pigeonhole Principle

173. State the Pigeonhole Principle. Prove it by contraposition.
174. If there are 11 entrances to a museum and 309 visitors, what can we conclude about how many visitors used at least one entrance?
175. In a group of 367 people, must at least two share a birthday? Justify.
176. In a class of 175 people, what is the minimum number guaranteed to share a birth month?
177. State the Generalized Pigeonhole Principle. What is the minimum $N$ to guarantee at least $r$ objects in some box, given $k$ boxes?
178. What is the minimum number of students to guarantee at least 6 receive the same grade (A, B, C, D, or F)?
179. What is the minimum number of cards to draw from a standard deck to guarantee 3 cards of the same suit? To guarantee 3 hearts specifically?
180. State Theorem 3 about monotonic subsequences: every sequence of $n^2+1$ distinct reals contains a monotonic subsequence of length $n+1$. Find such a subsequence in $8, 11, 9, 1, 4, 6, 12, 10, 5, 7$.
181. State the Ramsey number $R(3,3)$ and prove it equals 6 (the party problem).
182. Show that for every positive integer $n$, there is a multiple of $n$ whose decimal expansion contains only 0s and 1s.

---

### 16. Permutations and Combinations

183. Define an $r$-permutation. State and prove the formula $P(n,r) = \frac{n!}{(n-r)!}$.
184. Define an $r$-combination. State and prove the formula $C(n,r) = \frac{n!}{r!(n-r)!}$.
185. What is the key difference between a permutation and a combination? How do you decide which to use?
186. In how many ways can a goalkeeper be chosen from 17 team members?
187. In how many ways can a director and a vice-director be chosen from 25 employees?
188. In how many ways can a director and two vice-directors be chosen from 25 employees?
189. In how many ways can the letters of ABCDEF be permuted?
190. How many permutations of the digits in $9111346$ contain the sequence $111$ (treated as a block)?
191. In how many ways can a football team of 11 be chosen from a group of 20 people?
192. Find $\binom{11}{4}$. What is $\binom{11}{7}$, and why does this follow immediately?
193. Prove the symmetry property $C(n,r) = C(n, n-r)$ algebraically and combinatorially.
194. How many 5-card poker hands can be dealt from a standard 52-card deck?
195. How many bit strings of length 10 have exactly 4 ones?
196. How many ways can a committee of 3 math faculty (from 9) and 4 CS faculty (from 11) be selected?
197. In how many ways can $P(8,3)$ be computed? What does it count? (Gold, silver, bronze from 8 runners.)

---

### 17. Binomial Coefficients and Identities

198. State the Binomial Theorem. Prove it by induction.
199. Expand $(x+y)^4$ and $(x-y)^5$ using the Binomial Theorem.
200. What is the coefficient of $x^7 y^{13}$ in the expansion of $(x+y)^{20}$?
201. What is the coefficient of $x^{12}y^{13}$ in the expansion of $(2x-3y)^{25}$?
202. Prove Corollary 1: $\sum_{k=0}^{n} \binom{n}{k} = 2^n$. Give both an algebraic and a combinatorial proof.
203. Prove Corollary 2: $\sum_{k=0}^{n} (-1)^k \binom{n}{k} = 0$. What does this imply about even- and odd-indexed binomial coefficients?
204. State Pascal's Identity. Prove it combinatorially.
205. Use Pascal's Identity to compute $\binom{6}{3}$ from smaller values.
206. State Vandermonde's Identity. Prove it combinatorially.
207. State and prove: $\binom{n+1}{r+1} = \sum_{j=r}^{n} \binom{j}{r}$.

---

### 18. Generalized Permutations and Combinations

208. How many strings of length $r$ can be formed from 26 uppercase letters (repetition allowed)?
209. State the formula for $r$-combinations with repetition. Explain the Stars and Bars method.
210. In how many ways can 4 pieces of fruit be chosen from apples, oranges, and pears (at least 4 of each available)?
211. In how many ways can 5 bills be chosen from 7 denominations (repetition allowed)?
212. How many nonneg. integer solutions does $x_1 + x_2 + x_3 = 11$ have?
213. How many solutions does $x_1 + x_2 + x_3 = 11$ have with $x_1 \geq 1$, $x_2 \geq 2$, $x_3 \geq 3$?
214. How many distinct arrangements are there of the letters in SUCCESS?
215. How many distinct arrangements are there of the letters in MISSISSIPPI?
216. State the four cases for distributing objects into boxes. For each case, state the formula or method.
217. How many ways can 52 cards be dealt to 4 players (13 each)?
218. How many ways can 10 identical balls be placed into 8 distinct bins?
219. How many ways can 4 employees be distributed into 3 indistinguishable offices?
220. How many ways can 6 identical books be packed into 4 identical boxes?
221. When should you use Stars and Bars? What condition on the objects is required?

---

## PART 2 — ALGORITHMS AND ALGORITHMIC ANALYSIS

---

### 19. Properties and Description of Algorithms

222. Define an algorithm. What are the seven standard properties? Give an example illustrating each.
223. Explain the **definiteness** property. Why is ambiguity a problem?
224. Explain the **correctness** property. How does it differ from just "running without crashing"?
225. Explain the **effectiveness** property. What does it mean for each step to be executable in finite time?
226. Explain the **generality** property. Why must an algorithm solve all instances, not just one specific input?
227. Explain the **finiteness** property. How does it relate to the halting problem?
228. What is pseudocode, and why is it preferred over natural language or actual code for describing algorithms?
229. Write pseudocode to find the maximum element in a list. Trace it on the input $8, 4, 11, 3, 10$.

---

### 20. Searching Algorithms

230. Describe the linear search algorithm in pseudocode. Trace it on $A = [1,2,4,5,6,8,9,11]$ searching for $v = 9$.
231. Describe the binary search algorithm in pseudocode. Trace it on $A = [1,2,4,5,6,8,9,11]$ searching for $v = 9$.
232. Can binary search be applied to $A = [8,3,5,6,8,1,0,13]$? Justify your answer.
233. State the time complexity of linear search in the best case, average case, and worst case. Derive the worst-case count.
234. State the time complexity of binary search in the worst case. Derive the comparison count for a list of $2^k$ elements.
235. Compare linear search and binary search: when is each preferred?
236. What happens if the target element appears multiple times in linear search? In binary search?
237. What happens if the target element is not in the list for each algorithm?

---

### 21. Sorting Algorithms

238. Describe Bubble Sort. Trace it on $[6,2,3,1,5,4]$. Show each pass.
239. Describe Insertion Sort. Trace it on $[6,2,3,1,5,4]$. Show each insertion step.
240. Describe Merge Sort. Trace it on $[4,3,8,1,0,7]$. Show the split and merge phases.
241. Compare Bubble Sort and Insertion Sort: which tends to be faster in practice and why?
242. What is the worst-case time complexity of Bubble Sort? Derive it by counting comparisons.
243. What is the worst-case time complexity of Insertion Sort? Derive it. What is its best-case complexity and when does it occur?
244. State the design paradigm used by Merge Sort. Briefly explain how divide-and-conquer works.
245. Prove that merging two sorted lists of sizes $m$ and $n$ requires at most $m+n-1$ comparisons.
246. Derive the time complexity of Merge Sort using the merge cost per level. Show it is $O(n \log n)$.
247. Why is Merge Sort preferred over Bubble Sort or Insertion Sort for large inputs?
248. What is the loop invariant for Insertion Sort? State initialization, maintenance, and termination.

---

### 22. String Matching

249. Describe the Naive String Matcher algorithm in pseudocode. What does "shift" mean in this context?
250. Trace the Naive String Matcher on text $T = \mathtt{11001011}$ and pattern $P = \mathtt{101}$. Find all valid shifts.
251. What is the worst-case time complexity of the Naive String Matcher? Give a worst-case example.
252. Name two more efficient string matching algorithms and briefly describe their improvement over the naive approach.

---

### 23. Greedy Algorithms

253. What is a greedy algorithm? Does a greedy algorithm always produce an optimal solution? Explain.
254. Describe the Cashier's Algorithm. Make change for $67$ cents using quarters, dimes, nickels, and pennies.
255. State and prove the Lemma about constraints on optimal change for standard US coins.
256. Prove the Cashier's Algorithm is optimal for standard US coins (quarters, dimes, nickels, pennies).
257. Give a set of denominations for which the Cashier's Algorithm fails to find the optimal solution. Show a specific counterexample.
258. State the three greedy criteria for the talk scheduling problem. Which is optimal? Provide counterexamples for the other two.
259. Trace the optimal greedy scheduling algorithm on a specific set of talks. Which talks are selected?
260. State the difference between a brute-force algorithm and a greedy algorithm.
261. State the difference between a brute-force algorithm and a divide-and-conquer algorithm.
262. Give one example problem for each paradigm: brute-force, greedy, and divide-and-conquer.

---

### 24. The Halting Problem

263. State the Halting Problem. Why can't we just run the program and wait?
264. Prove that the Halting Problem is unsolvable. (Turing's proof by contradiction and self-reference.)
265. What is the key intuition behind the proof? How does it relate to the Liar's Paradox and Cantor's diagonalization?
266. What does the Halting Problem tell us about the limits of computation?

---

### 25. Big-O Notation

267. Give the formal definition of $f(x) = O(g(x))$. What are witnesses $C$ and $k$?
268. Define what a witness is in asymptotic notation. Why is a witness pair not unique?
269. Show that $f(n) = 8n + 5$ is $O(n)$. Give suitable witnesses.
270. Show that $f(n) = x^2 + 2x + 1$ is $O(x^2)$. Give two different witness pairs.
271. Show that $7x^2$ is $O(x^3)$. Is it also $O(x^2)$? Which is the tighter bound?
272. Show that $n^2$ is NOT $O(n)$.
273. Show that $n^3 - 100n^2 \neq O(n^2)$.
274. Show that $4n^2 + 100n + 500 = O(n^2)$ and find at least two valid witness pairs $(n_0, c)$.
275. State the theorem that every polynomial of degree $d$ is $O(x^d)$. Prove it.
276. Arrange the following functions in increasing order of growth: $8\sqrt{n}$, $(\log n)^2$, $2n\log n$, $n!$, $(1.1)^n$, $n^2$.
277. State the standard growth hierarchy: $1, \log n, n, n\log n, n^2, 2^n, n!$.
278. State the Big-O of a sum theorem. Show that $O(n^3) + O(n^2) = O(n^3)$.
279. State the Big-O of a product theorem. Compute the Big-O of $f(n) = 3n\log(n!) + (n^2+3)\log n$.
280. Find the Big-O for $f(n) = (x+1)\log(x^2+1) + 3x^2$.
281. Compare $O(n)$ and $O(n^2)$ growth using a concrete numerical example for large $n$.

---

### 26. Big-Omega and Big-Theta Notation

282. Give the formal definition of $f(x) = \Omega(g(x))$. How does it differ from $O$?
283. Find the Big-$\Omega$ for $f(n) = 5\log_2 n + 10n$. Give witnesses.
284. Show that $8x^3 + 5x^2 + 7$ is $\Omega(x^3)$.
285. Show that $4n^2 + 100n + 500 = \Omega(n^2)$ and give witnesses.
286. Show that $\frac{n^2}{100} - 100n - 500 = \Omega(n^2)$.
287. Give the formal definition of $f(x) = \Theta(g(x))$.
288. State and prove: $f(n) = \Theta(g(n))$ if and only if $f(n) = O(g(n))$ and $f(n) = \Omega(g(n))$.
289. Express $f(n) = n^2 + 100$ in $\Theta$-notation. Justify.
290. Show that $1 + 2 + \cdots + n$ is $\Theta(n^2)$ by proving both bounds.
291. Show that $3x^2 + 8x\log x$ is $\Theta(x^2)$.
292. What is the order of a polynomial of degree $d$ with positive leading coefficient? State and prove.
293. State the five asymptotic notations ($O, \Omega, \Theta, o, \omega$) and give their analogies to $\leq, \geq, =, <, >$.
294. Explain transitivity, reflexivity, and symmetry of asymptotic notation.
295. State and explain Little-$o$ notation. How does it differ from Big-$O$? Is $2n = o(n^2)$? Is $2n^2 = o(n^2)$?
296. State and explain Little-$\omega$ notation. Is $\frac{n^2}{2} = \omega(n)$? Is $\frac{n^2}{2} = \omega(n^2)$?
297. Why does trichotomy not hold for asymptotic comparisons? Give a counterexample.

---

### 27. Complexity of Algorithms and Complexity Classes

298. What is the difference between time complexity and space complexity? Why do we focus on time complexity?
299. What is the worst-case complexity of an algorithm? What guarantee does it provide?
300. What is the average-case complexity? Why is it generally harder to compute than worst-case?
301. Derive the worst-case comparison count for finding the maximum element in a list of $n$ elements.
302. Derive the average-case comparison count for linear search (assuming the element is present and uniformly distributed).
303. Derive the worst-case comparison count for Bubble Sort. Show it is $\Theta(n^2)$.
304. Derive the worst-case comparison count for Insertion Sort. Show it is $\Theta(n^2)$. What is the best case?
305. Derive the complexity of multiplying two $n \times n$ matrices. What is the operation count?
306. What is the Boolean product of two zero-one matrices? Derive its complexity.
307. For multiplying $A_1 A_2 A_3$ where $A_1$ is $30\times20$, $A_2$ is $20\times40$, $A_3$ is $40\times10$: compute the cost of both orderings and identify the optimal one.
308. What is a brute-force algorithm? Give the closest-pair algorithm as an example and derive its complexity.
309. Describe the complexity classes: constant, logarithmic, linear, linearithmic, polynomial, exponential, factorial.
310. Define tractable and intractable problems. Give one example of each.
311. Define Class P and Class NP. What is the relationship between them?
312. What is an NP-complete problem? State the Cook–Levin Theorem.
313. What is the P vs. NP problem? Why do most researchers believe $P \neq NP$?
314. A linear-time algorithm takes 4 minutes when $n=2$. Estimate the running time when $n=16$.
315. A quadratic-time algorithm takes 4 minutes when $n=2$. Estimate the running time when $n=16$.
316. A constant-time algorithm takes 5 minutes when $n=4$. What is the running time when the input size is halved?
317. A logarithmic-time algorithm takes 2 minutes when $n=1$. Estimate the running time when the input size is doubled.

---

### 28. Recursive Algorithms — Design and Correctness

318. What is a recursive algorithm? What two components must every recursive algorithm have?
319. State the difference between iterative and recursive algorithms.
320. Write a recursive algorithm for computing $n!$. Trace it for $n=4$.
321. Write a recursive algorithm for computing $a^n$. Prove its correctness by induction.
322. Write a recursive algorithm for $\gcd(a,b)$. Trace it for $a=5, b=8$.
323. Write a recursive algorithm for modular exponentiation $b^n \bmod m$. Trace it for $b=2, n=5, m=3$.
324. Prove the correctness of the modular exponentiation algorithm using strong induction. Why is strong induction required rather than standard induction?
325. Write a recursive linear search algorithm. Trace it on a specific input.
326. Write a recursive binary search algorithm. How does this compare to the iterative version?
327. How do you prove the correctness of a recursive algorithm? State the general approach.
328. How do you prove the correctness of an iterative algorithm? (Loop invariants.)
329. Give a recursive definition for the sequence $5, 9, 13, 17, 21, \ldots$ Write a recursive algorithm to compute the $n$-th term.
330. Give a recursive definition for the sequence $6, 12, 24, 48, \ldots$ Write a recursive algorithm to compute the $n$-th term.
331. Give a recursive definition for the sequence $18, 15, 12, 9, 6, \ldots$ Write a recursive algorithm to compute the $n$-th term.
332. Compare naive recursive Fibonacci (exponential) with iterative Fibonacci (linear). Why is the recursive version so slow?

---

### 29. Program Correctness and Hoare Logic

333. Define partial correctness. Define full correctness. How do they differ?
334. What is a Hoare triple $p\{S\}q$? What do $p$ and $q$ represent?
335. State the composition rule for Hoare triples. How do you read an inference rule?
336. Verify the segment $y := 2; z := x + y$ with precondition $x = 1$ and postcondition $z = 3$.
337. State the rule of inference for an `if` statement (without `else`). Verify correctness of: `if x > y then y := x` with $p = T$ and $q: y \geq x$.
338. State the rule of inference for an `if-else` statement. Verify correctness of the absolute value program.
339. What is a loop invariant? State the rule of inference for a `while` loop.
340. Explain the three-step loop invariant proof method: initialization, maintenance, termination.
341. How is a loop invariant proof analogous to mathematical induction?
342. Verify the factorial loop using a loop invariant. Identify the invariant, prove it holds, and derive the postcondition.
343. Verify the multiply procedure using the composition rule and a loop invariant for the inner loop.
344. Prove the correctness of Insertion Sort using its loop invariant. State initialization, maintenance, and termination.

---

### 30. Data Structures

345. State the main difference between a stack and a queue.
346. Describe the LIFO property of a stack. Give the pseudocode for PUSH, POP, and STACK-EMPTY.
347. Describe the FIFO property of a queue. Give the pseudocode for ENQUEUE and DEQUEUE.
348. What is stack underflow? Stack overflow? How are they detected?
349. Why does a queue implemented with a circular array of size $n$ hold at most $n-1$ elements? What goes wrong if you fill all $n$ slots?
350. Trace PUSH(S,10), PUSH(S,20), PUSH(S,30), POP(S), POP(S) on an initially empty stack.
351. Trace ENQUEUE(Q,'A'), ENQUEUE(Q,'B'), ENQUEUE(Q,'C'), DEQUEUE(Q), DEQUEUE(Q) on an initially empty queue.
352. State the time complexity of insert, delete, and search for: array, linked list, stack, queue.
353. Describe a doubly linked list. What pointers does each node have?
354. Give the pseudocode for LIST-SEARCH, LIST-PREPEND, LIST-INSERT, LIST-DELETE for a doubly linked list.
355. Trace LIST-PREPEND on $\langle 1 \leftrightarrow 4 \leftrightarrow 9 \leftrightarrow 16 \rangle$ with key $25$.
356. Trace LIST-INSERT after node $9$ on $\langle 1 \leftrightarrow 4 \leftrightarrow 9 \leftrightarrow 16 \rangle$ with key $36$.
357. Trace LIST-DELETE on the node with key $4$ in $\langle 1 \leftrightarrow 4 \leftrightarrow 9 \leftrightarrow 16 \rangle$. Then trace deleting the head node.
358. What is a sentinel node? How does it simplify deletion in a doubly linked list?
359. Give the pseudocode for LIST-DELETE' and LIST-INSERT' using a sentinel. Compare with the non-sentinel versions.
360. Compare arrays and doubly linked lists: access, insert at front, delete given pointer.
361. How is a matrix stored in row-major order? In column-major order? Give the index formula for $M[i,j]$ in each case (1-based).
362. Given the $2\times3$ matrix $\begin{pmatrix}1&2&3\\4&5&6\end{pmatrix}$, write out the flat arrays for row-major and column-major storage. Verify the formula locates $M[2,1]$ correctly in each.
363. What is a ragged array? When is the multiple-array matrix representation preferred?
364. Describe the binary tree representation of a rooted tree. What pointers does each node have?
365. Sketch the binary tree for the array $[23,17,14,6,13,10,1,5,7,12]$ interpreted as a heap. Is it a max-heap or min-heap? Verify the heap property.
366. Does the array $[29,18,10,15,20,9,5,13,2,4,14]$ satisfy the max-heap property? Justify by checking all parent-child pairs.
367. Construct a min-heap from the array $[29,18,10,15,20,9,5,13,2,4,14]$.
368. Describe the left-child, right-sibling representation for trees with unbounded branching. Why does it use only $O(n)$ space?
369. Given a node with three children $A, B, C$ (left to right) in a left-child, right-sibling tree, describe how to visit all children of that node.
370. Compare three tree representations: binary-tree pointer scheme, left-child/right-sibling, and heap-style array. When is each preferred?

---

### 31. Standard Mathematical Functions (Algorithm Context)

371. Define the iterated logarithm $\lg^* n$. Compute $\lg^* 16$ and $\lg^* 65536$.
372. What is the difference between $\lg^k n$ (polylogarithm) and $\lg^{(k)} n$ (iterated application)?
373. State the closed-form expression for the $n$-th Fibonacci number in terms of $\phi$ and $\hat\phi$. Verify for $n=5$.
374. State Stirling's Approximation for $n!$. What does it imply about the asymptotic bounds on $n!$?
375. State the key facts: $n! = o(n^n)$, $n! = \omega(2^n)$, $\lg(n!) = \Theta(n\lg n)$.
376. Why does changing the base of a logarithm not affect its asymptotic class?
377. Why do exponentials dominate polynomials asymptotically? (State the limit $\lim_{n\to\infty} n^b/a^n = 0$ for $a > 1$.)
378. Why do polynomials dominate polylogarithms? (State $\lg^b n = o(n^a)$ for $a > 0$.)