---
tags:
  - "#CCT2"
  - DS
Topic: Induction | Recursion
Semester: CCT2
Course: Diskrete strukturer
Litterature:
  - Discrete Mathematics and Its Applications - 8th Ed.
Created: 22-02-2026
---
- - -

# Induction and Recursion

Many mathematical statements assert that a property is true for all positive integers. Examples of these statements include:
- $n! \le n^n$
- $n^3 - n$ is divisible by 3
- A set with $n$ elements has $2^n$ subsets
- The sum of the first $n$ positive integers is $\frac{n(n+1)}{2}$

Mathematical induction is the primary proof technique used to prove results of this kind.

Proofs using mathematical induction consist of two essential parts:
1.  Show that the statement holds for the positive integer 1.
2.  Show that if the statement holds for a positive integer, it must also hold for the next larger integer.

> [!summary] Rule of Inference - Mathematical Induction
> Mathematical induction is based on the rule of inference that states: if $P(1)$ and $\forall k(P(k) \rightarrow P(k + 1))$ are true for the domain of positive integers, then $\forall nP(n)$ is true.

Understanding how to read and construct proofs by mathematical induction is a key goal of discrete mathematics.

### Recursive Definitions

To define functions, specific initial terms are stated, and a rule is provided for finding subsequent values from values already known. Similarly, sets can be defined by listing initial elements and giving rules for constructing elements from those already known to be in the set.

> [!info] Recursive Definition
> Such definitions, called **recursive definitions**, are used throughout discrete mathematics and computer science to define:
> - **Functions:** By specifying initial terms and rules for subsequent values.
> - **Sets:** By listing elements and giving construction rules.

Once a set has been defined recursively, a proof method called **structural induction** can be used to prove results about this set.

### Program Verification

Specifying a procedure for solving a problem requires a guarantee that the procedure always solves the problem correctly. Testing a procedure with a set of input values is insufficient to prove it always works correctly. The correctness of a procedure can be guaranteed only by proving that it always yields the correct result.

> [!note] Program Verification
> This is a formal technique used to verify that procedures are correct. It serves as the basis for attempts to prove in a mechanical fashion that programs are correct.

## Mathematical Induction

### Introduction

Suppose we have an infinite ladder and want to know whether we can reach every step. We know two things:
1.  We can reach the first rung of the ladder.
2.  If we can reach a particular rung, then we can reach the next rung.

![[Pasted image 20260222133554.png]]

Can we conclude that we can reach every rung? By the first point, we can reach the first rung. By the second point, because we can reach the first rung, we can reach the second. Applying this logic again, we can reach the third rung. Continuing this process, after 100 uses of the second point, we know we can reach the 101st rung.

The answer is yes; we can conclude that we are able to reach every rung of this infinite ladder. This is verified using **mathematical induction**, which shows that the statement "we can reach the $n$th rung of the ladder" is true for all positive integers $n$.

> [!info] Mathematical Induction
> Mathematical induction is an extremely important proof technique used to prove assertions about a large variety of discrete objects. It is used extensively to prove results regarding:
> - The complexity of algorithms
> - The correctness of certain types of computer programs
> - Theorems about graphs and trees
> - A wide range of identities and inequalities

> [!warning] Limitation of Mathematical Induction
> It is extremely important to note that mathematical induction can be used only to **prove results obtained in some other way**. It is not a tool for discovering formulae or theorems.
You are correct. I missed the proper formatting and captioning for the included image link, and I did not provide a text description for the referenced "Figure 2" which was absent from the source text.
### Mathematical Induction

Mathematical induction is used to prove statements asserting that $P(n)$ is true for all positive integers $n$, where $P(n)$ is a propositional function. A proof by mathematical induction consists of two distinct parts: a *basis step* and an *inductive step*.

> [!summary] Principle of Mathematical Induction
> To prove that $P(n)$ is true for all positive integers $n$, where $P(n)$ is a propositional function, complete two steps:
> - **BASIS STEP:** Verify that $P(1)$ is true.
> - **INDUCTIVE STEP:** Show that the conditional statement $P(k) \to P(k + 1)$ is true for all positive integers $k$.

To complete the inductive step, we assume that $P(k)$ is true for an arbitrary positive integer $k$ and show that, under this assumption, $P(k + 1)$ must also be true.

> [!info] The Inductive Hypothesis
> The assumption that $P(k)$ is true for the arbitrary integer $k$ is called the **inductive hypothesis**.

Once both steps are complete, we have shown that $P(n)$ is true for all positive integers $n$ (i.e., $\forall n P(n)$ is true). In the inductive step, we effectively show that $\forall k (P(k) \to P(k + 1))$ is true.

Expressed as a rule of inference for the domain of positive integers, this technique is stated as:
$$ (P(1) \land \forall k (P(k) \to P(k + 1))) \to \forall n P(n) $$

**The Process of Proof**
1.  **Basis Step:** Show $P(1)$ is true by replacing $n$ with 1 in the statement.
2.  **Inductive Step:** Show that $P(k + 1)$ cannot be false when $P(k)$ is true. This is accomplished by assuming $P(k)$ is true and using that hypothesis to demonstrate $P(k + 1)$ is true.

> [!info] Avoiding Circular Reasoning
> In a proof by mathematical induction, it is **not** assumed that $P(k)$ is true for *all* positive integers. It is only shown that *if* it is assumed $P(k)$ is true, then $P(k + 1)$ is also true. Thus, mathematical induction is not a case of begging the question or circular reasoning.

**Why It Works**
After completing the basis and inductive steps:
- We know $P(1)$ is true (from the basis step).
- We conclude $P(2)$ is true because $P(1)$ is true and the inductive step proves $P(1) \to P(2)$.
- We conclude $P(3)$ is true because $P(2)$ is true and the inductive step proves $P(2) \to P(3)$.

Continuing this chain of implications allows us to show that $P(n)$ is true for any particular positive integer $n$.

**Ways to Remember How Mathematical Induction Works**

Thinking of the infinite ladder helps remember the process:
- **Statement (1):** We can reach the first rung (Basis Step).
- **Statement (2):** If we can reach a particular rung, we can reach the next rung (Inductive Step).
- **Conclusion:** We can reach every rung.

Another illustration involves an infinite row of dominoes labeled $1, 2, 3, \dots, n, \dots$. Let $P(n)$ be the proposition that domino $n$ is knocked over.

![[Pasted image 20260222133615.png]]
*Figure 2.2: If the first domino falls (P(1)) and each domino knocks over the next (P(k) -> P(k+1)), then all dominoes will fall.*

- If the first domino is knocked over ($P(1)$ is true).
- And if, whenever the $k$-th domino is knocked over, it knocks over the $(k+1)$-st domino ($P(k) \to P(k + 1)$ is true).
- Then all dominoes are knocked over.

### Why Mathematical Induction is Valid

The validity of mathematical induction stems from the **well-ordering property**, which serves as an axiom for the set of positive integers.

> [!info] The Well-Ordering Property
> Every nonempty subset of the set of positive integers has a least element.

**Proof of Validity**
Suppose we know that $P(1)$ is true and that the proposition $P(k) \to P(k + 1)$ is true for all positive integers $k$. To show that $P(n)$ must be true for all positive integers $n$, we use **proof by contradiction**.

1.  **Assumption:** Assume there is at least one positive integer $n$ for which $P(n)$ is false.
2.  **Define Set $S$:** Let $S$ be the set of positive integers $n$ for which $P(n)$ is false. By the assumption, $S$ is nonempty.
3.  **Apply Well-Ordering:** Since $S$ is nonempty, by the well-ordering property, $S$ has a least element, denoted by $m$.
4.  **Analyze $m$:**
    - We know that $m \neq 1$ because $P(1)$ is true.
    - Since $m$ is positive and greater than 1, $m - 1$ is a positive integer.
    - Because $m - 1$ is less than $m$, it is not in $S$. Therefore, $P(m - 1)$ must be true.
5.  **Derive Contradiction:**
    - We know the conditional statement $P(m - 1) \to P(m)$ is true (from the premise that $P(k) \to P(k + 1)$ is true for all $k$).
    - Since $P(m - 1)$ is true, it must be the case that $P(m)$ is true.
    - This contradicts the choice of $m$ as an element of $S$ (where $P(m)$ is false).

Since the assumption leads to a contradiction, $P(n)$ must be true for every positive integer $n$.

> [!note] Axioms and Equivalence
> In this text, the well-ordering property is taken as an axiom, and mathematical induction is proven valid based on it. However, the relationship could be reversed:
> - The principle of mathematical induction could be taken as the axiom.
> - The well-ordering property could then be proven as a consequence.
>
> Therefore, the well-ordering property for positive integers and the principle of mathematical induction are **equivalent**.

### Choosing the Correct Basis Step

Mathematical induction is not restricted to proving theorems solely for all positive integers ($n \ge 1$). It can also be used to prove that $P(n)$ is true for $n = b, b+1, b+2, \dots$, where $b$ is an integer other than 1. This requires adjusting the basis step.

> [!summary] Generalized Principle of Induction
> To prove that $P(n)$ is true for integers $n = b, b+1, b+2, \dots$:
> - **Basis Step:** Show that $P(b)$ is true.
> - **Inductive Step:** Show that $P(k) \to P(k+1)$ is true for all integers $k \ge b$.

The starting integer $b$ can be negative, zero, or positive.

> [!abstract] Modified Domino Analogy
> Imagine an infinite row of dominoes.
> 1.  **Basis Step:** Knock down the $b$-th domino.
> 2.  **Inductive Step:** As each domino falls, it knocks down the next one.
>
> Result: All dominoes from the $b$-th position onward will fall.

This form of induction is valid. For example, if a summation formula is valid for all nonnegative integers ($n = 0, 1, 2, \dots$), the basis step must show that $P(0)$ is true.

### Guidelines for Proofs by Mathematical Induction

Before attempting to prove a diverse collection of theorems using mathematical induction, it is helpful to follow a structured set of guidelines to ensure correctness.

> [!abstract] Template for Proofs by Mathematical Induction
> 1.  **Express the Statement:** Formulate the statement to be proved as "for all $n \ge b, P(n)$" for a fixed integer $b$.
>     - For "all positive integers," let $b = 1$.
>     - For "all nonnegative integers," let $b = 0$.
>     - For statements like inequalities, determine the appropriate $b$ by checking truth values for small values of $n$.
> 2.  **Basis Step:** Write out "Basis Step." Show that $P(b)$ is true, ensuring the correct value of $b$ is used.
> 3.  **Inductive Step:** Write out "Inductive Step." State the inductive hypothesis clearly: "Assume that $P(k)$ is true for an arbitrary fixed integer $k \ge b$."
> 4.  **State the Goal:** Write out what $P(k + 1)$ says, which is what needs to be proved under the assumption of the inductive hypothesis.
> 5.  **Prove the Goal:** Prove the statement $P(k + 1)$ making use of the assumption $P(k)$.
>     - *Note:* This is generally the most difficult part. Look ahead to see how to use the hypothesis. Ensure the proof is valid for all integers $k \ge b$, including small values like $k = b$.
> 6.  **Conclude the Step:** Clearly identify the end of the inductive step, such as "This completes the inductive step."
> 7.  **Final Conclusion:** State the conclusion: "By mathematical induction, $P(n)$ is true for all integers $n$ with $n \ge b$."

### The Good and the Bad of Mathematical Induction

An important distinction must be made regarding the utility of *mathematical induction*. The primary advantage of this method is its ability to **prove** a conjecture once it has been formulated, assuming the conjecture is true. However, a significant limitation is that it cannot be used to **find** or discover new theorems.

Proofs by mathematical induction are sometimes viewed as unsatisfying because they often fail to provide insight into *why* a theorem is true. While many theorems can be proved using induction, alternative methods are often preferred because they tend to offer a deeper understanding of the underlying truths of the theorem.
### Examples of Proofs by Mathematical Induction

Many theorems assert that a propositional function $P(n)$ is true for all positive integers $n$. Mathematical induction serves as the primary technique to prove theorems of this specific form. In logical terms, induction proves statements of the form $\forall n P(n)$, where the domain is the set of positive integers.

Mathematical assertions often include an implicit universal quantifier. For instance, the statement "if $n$ is a positive integer, then $n^3 - n$ is divisible by 3" implicitly means "for every positive integer $n$, $n^3 - n$ is divisible by 3."

> [!warning] Potential for Errors
> There are many opportunities for errors in induction proofs. To avoid mistakes, it is essential to follow the established guidelines for constructing such proofs.

#### Seeing Where the Inductive Hypothesis is Used

Understanding induction proofs requires identifying exactly where the *inductive hypothesis* is utilized.

> [!tip] Identifying the Inductive Hypothesis
> The use of the inductive hypothesis is typically indicated in three ways:
> 1.  **Explicit Mention:** The text directly states that the hypothesis is being used.
> 2.  **Acronym Notation:** The acronym **IH** is placed over an equals sign or inequality sign (e.g., $\overset{\text{IH}}{=}$).
> 3.  **Reason Specification:** In a multi-line display, the inductive hypothesis is listed as the reason for a specific step.

#### Proving Summation Formulae

Mathematical induction is particularly well-suited for proving the validity of summation formulae. However, there is a distinct trade-off:

*   **Advantage:** It can rigorously prove the validity of a formula.
*   **Disadvantage:** It cannot be used to *derive* or find the formula. The formula must already be known or conjectured before an induction proof can be attempted.

> [!example] Proving the Sum of the First $n$ Positive Integers
> **Show that if $n$ is a positive integer, then:**
> $$1 + 2 + \dots + n = \frac{n(n + 1)}{2}$$
>
> **Breakdown:**
> - **$n$**: The positive integer representing the last term in the summation.
> - **LHS**: The sum of the sequence of integers from 1 to $n$.
> - **RHS**: A closed-form formula calculating the sum directly using $n$.
>
> **Solution:**
> Let $P(n)$ be the proposition that the sum of the first $n$ positive integers equals $\frac{n(n + 1)}{2}$. To prove $P(n)$ is true for all positive integers $n$, we must establish the basis step and the inductive step.
>
> **Basis Step:**
> $P(1)$ is true because:
> $$1 = \frac{1(1 + 1)}{2}$$
> (The left-hand side is 1, and the right-hand side evaluates to $\frac{2}{2} = 1$).
>
> **Inductive Step:**
> For the *inductive hypothesis*, we assume that $P(k)$ holds for an arbitrary positive integer $k$. That is:
> $$1 + 2 + \dots + k = \frac{k(k + 1)}{2}$$
>
> Under this assumption, we must show that $P(k + 1)$ is true:
> $$1 + 2 + \dots + k + (k + 1) = \frac{(k + 1)((k + 1) + 1)}{2} = \frac{(k + 1)(k + 2)}{2}$$
>
> We observe that the summation in $P(k + 1)$ is exactly $(k + 1)$ more than the summation in $P(k)$. We add $(k + 1)$ to both sides of the equation in $P(k)$:
>
> $$1 + 2 + \dots + k + (k + 1) \overset{\text{IH}}{=} \frac{k(k + 1)}{2} + (k + 1)$$
>
> By algebraically simplifying the right-hand side:
> $$= \frac{k(k + 1) + 2(k + 1)}{2}$$
> $$= \frac{(k + 1)(k + 2)}{2}$$
>
> This final equation confirms that $P(k + 1)$ is true under the assumption that $P(k)$ is true. This completes the inductive step.
>
> **Conclusion:**
> Having completed both the basis step and the inductive step, by mathematical induction, $P(n)$ is true for all positive integers $n$.

Mathematical induction is not a tool for finding theorems about all positive integers. Rather, it is a proof method for proving such results once they are conjectured.

> [!example]- Conjecture and Proof: Sum of First $n$ Odd Integers
> **Problem:** Conjecture a formula for the sum of the first $n$ positive odd integers, then prove the conjecture using mathematical induction.
>
> **Conjecturing the Formula:**
> By examining the sums of the first $n$ positive odd integers for small values of $n$, a pattern emerges:
> - $n=1: 1 = 1$
> - $n=2: 1 + 3 = 4$
> - $n=3: 1 + 3 + 5 = 9$
> - $n=4: 1 + 3 + 5 + 7 = 16$
> - $n=5: 1 + 3 + 5 + 7 + 9 = 25$
>
> These results ($1, 4, 9, 16, 25$) are perfect squares ($1^2, 2^2, 3^2, 4^2, 5^2$). It is reasonable to conjecture that the sum of the first $n$ positive odd integers is $n^2$.
>
> **Conjectured Equation:**
> $$1 + 3 + 5 + \dots + (2n - 1) = n^2$$
>
> **Breakdown:**
> - **$n$**: The number of odd integers being summed.
> - **$2n - 1$**: The formula for the $n$-th positive odd integer. This is derived by adding $2$ a total of $n-1$ times to the first odd integer, $1$.
> - **$n^2$**: The square of the count $n$, which the conjecture posits is the total sum.
>
> **Solution:**
> Let $P(n)$ be the proposition that the sum of the first $n$ odd positive integers is $n^2$. We aim to prove $P(n)$ is true for all positive integers $n$.
>" $P(n) = n^2$"
>
> **Basis Step:**
> $P(1)$ states that the sum of the first odd positive integer is $1^2$. This is true because the sum is simply $1$, and $1^2 = 1$. The basis step is complete.
>
> **Inductive Step:**
> To complete the inductive step, we must show that the conditional statement $P(k) \to P(k + 1)$ is true for every positive integer $k$.
>
> **Inductive Hypothesis:**
> Assume $P(k)$ is true for an arbitrary positive integer $k$. That is:
> $$1 + 3 + 5 + \dots + (2k - 1) = k^2$$
>
> **Goal:**
> We must show that $P(k + 1)$ is true. That is, we must show:
> $$1 + 3 + 5 + \dots + (2k - 1) + (2k + 1) = (k + 1)^2$$
>
> **Proof:**
> We observe that the sum on the left-hand side of $P(k + 1)$ consists of the sum of the first $k$ terms plus the next odd integer, $(2k + 1)$. We use the inductive hypothesis to substitute the sum of the first $k$ terms.
>
> $$1 + 3 + 5 + \dots + (2k - 1) + (2k + 1) = [1 + 3 + \dots + (2k - 1)] + (2k + 1)$$
>
> Applying the inductive hypothesis:
>
> $$\overset{\text{IH}}{=} k^2 + (2k + 1)$$
>
> Simplifying the algebra:
>
> $$= k^2 + 2k + 1$$
> $$= (k + 1)^2$$
>
> This shows that $P(k + 1)$ follows from $P(k)$. The inductive hypothesis was used in the second equality to replace the sum of the first $k$ odd positive integers with $k^2$.
>
> **Conclusion:**
> We have completed both the basis step and the inductive step. By the principle of mathematical induction, $P(n)$ is true for all positive integers $n$. Therefore, $1 + 3 + 5 + \dots + (2n - 1) = n^2$.

> [!example]- Sum of a Finite Geometric Progression
> **Use mathematical induction to prove the formula for the sum of a finite number of terms of a geometric progression with initial term $a$ and common ratio $r$:**
>
> $$ \sum_{j=0}^{n} ar^j = a + ar + ar^2 + \dots + ar^n = \frac{ar^{n+1} - a}{r - 1} $$
>
> **Breakdown:**
> - **$a$**: The initial term of the geometric progression.
> - **$r$**: The common ratio between consecutive terms ($r \neq 1$).
> - **$n$**: A nonnegative integer representing the upper limit of the summation.
> - **$\sum_{j=0}^{n} ar^j$**: The sum of the geometric progression from the $0$-th term to the $n$-th term. Note that this sum contains $n+1$ terms.
> - **Formula**: The closed-form expression calculating the total sum.
>
> **Solution:**
> Let $P(n)$ be the statement that the sum of the first $n+1$ terms of a geometric progression is given by the formula $\frac{ar^{n+1} - a}{r - 1}$. We aim to prove $P(n)$ is true for all nonnegative integers $n$.
>
> **Basis Step:**
> $P(0)$ states that the sum of the first term ($j=0$) is correctly given by the formula.
> - The left-hand side of the sum is simply $a$.
> - The right-hand side of the formula yields:
> $$ \frac{ar^{0+1} - a}{r - 1} = \frac{ar - a}{r - 1} = \frac{a(r - 1)}{r - 1} = a $$
> Since both sides equal $a$, $P(0)$ is true.
>
> **Inductive Step:**
> The inductive hypothesis is the statement that $P(k)$ is true for an arbitrary nonnegative integer $k$. That is:
> $$ a + ar + ar^2 + \dots + ar^k = \frac{ar^{k+1} - a}{r - 1} $$
>
> **Goal:**
> We must show that $P(k + 1)$ is true. That is, we must show:
> $$ a + ar + ar^2 + \dots + ar^k + ar^{k+1} = \frac{ar^{k+2} - a}{r - 1} $$
>
> **Proof:**
> We begin with the sum stated in $P(k + 1)$. We can view this sum as the sum in $P(k)$ plus the next term, $ar^{k+1}$.
>
> $$ a + ar + \dots + ar^k + ar^{k+1} \overset{\text{IH}}{=} \frac{ar^{k+1} - a}{r - 1} + ar^{k+1} $$
>
> To combine the terms on the right-hand side, we rewrite $ar^{k+1}$ as a fraction with the denominator $r - 1$. Note that $ar^{k+1} = \frac{ar^{k+1}(r - 1)}{r - 1} = \frac{ar^{k+2} - ar^{k+1}}{r - 1}$.
>
> Substituting this back into the equation:
>
> $$ = \frac{ar^{k+1} - a}{r - 1} + \frac{ar^{k+2} - ar^{k+1}}{r - 1} $$
>
> Combining the numerators:
>
> $$ = \frac{(ar^{k+1} - a) + (ar^{k+2} - ar^{k+1})}{r - 1} $$
>
> The terms $ar^{k+1}$ cancel out:
>
> $$ = \frac{ar^{k+2} - a}{r - 1} $$
>
> This result matches the formula for $P(k + 1)$. This shows that if the inductive hypothesis $P(k)$ is true, then $P(k + 1)$ must also be true.
>
> **Conclusion:**
> We have completed the basis step and the inductive step. By mathematical induction, $P(n)$ is true for all nonnegative integers $n$. This proves that the formula for the sum of the terms of a geometric series is correct.

PROVING INEQUALITIES

> [!example]- Proving an Inequality Involving Exponents
> **Use mathematical induction to prove the inequality:**
> $$n < 2^n$$
> for all positive integers $n$.
>
> **Breakdown:**
> - **$n$**: An arbitrary positive integer.
> - **$2^n$**: 2 raised to the power of $n$ (exponential growth).
> - **Inequality**: The statement asserts that for any positive integer $n$, the value of $n$ is strictly less than $2^n$.
>
> **Solution:**
> Let $P(n)$ be the proposition that $n < 2^n$.
>
> **Basis Step:**
> $P(1)$ is true because $1 < (2^1 = 2)$. This completes the basis step.
>
> **Inductive Step:**
> We first assume the inductive hypothesis that $P(k)$ is true for an arbitrary positive integer $k$. That is, the inductive hypothesis $P(k)$ is the statement:
> $$k < 2^k$$
>
> To complete the inductive step, we need to show that if $P(k)$ is true, then $P(k + 1)$, which is the statement $k + 1 < 2^{k+1}$, is also true.
>
> **Proof:**
> We begin by adding 1 to both sides of the inequality in the inductive hypothesis. We then note that for any positive integer $k$, $1 \le 2^k$.
>
> $$k + 1 \overset{\text{IH}}{<} 2^k + 1 \le 2^k + 2^k = 2 \cdot 2^k = 2^{k+1}$$
>
> This chain of inequalities shows that $k + 1 < 2^{k+1}$. This confirms that $P(k + 1)$ is true based on the assumption that $P(k)$ is true. The inductive step is complete.
>
> **Conclusion:**
> Because we have completed both the basis step and the inductive step, by the principle of mathematical induction, we have shown that $n < 2^n$ is true for all positive integers $n$.

> [!example]- Proving Inequalities with Shifted Starting Points
> **Use mathematical induction to prove that:**
> $$2^n < n!$$
> for every integer $n$ with $n \ge 4$.
>
> **Breakdown:**
> - **$n$**: An integer variable restricted to the domain $n \ge 4$.
> - **$2^n$**: Exponential growth (base 2).
> - **$n!$**: Factorial growth ($n \cdot (n-1) \cdot \dots \cdot 1$).
> - **Inequality**: The statement asserts that factorial growth eventually overtakes and exceeds exponential growth starting at $n=4$.
>
> > [!warning] Validity for Small Integers
> > Note that this inequality is **false** for $n = 1, 2,$ and $3$.
> > - $n=1: 2^1 = 2 \not< 1 = 1!$
> > - $n=2: 2^2 = 4 \not< 2 = 2!$
> > - $n=3: 2^3 = 8 \not< 6 = 3!$
> > This highlights the importance of verifying the correct starting point for the basis step.
>
> **Solution:**
> Let $P(n)$ be the proposition that $2^n < n!$.
>
> **Basis Step:**
> Since the claim is for $n \ge 4$, the basis step must verify $P(4)$.
> - LHS: $2^4 = 16$
> - RHS: $4! = 24$
> Since $16 < 24$, $P(4)$ is true.
>
> **Inductive Step:**
> For the inductive step, we assume that $P(k)$ is true for an arbitrary integer $k$ with $k \ge 4$.
>
> **Inductive Hypothesis:**
> $$2^k < k!$$
>
> **Goal:**
> We must show that $P(k + 1)$ is true, that is:
> $$2^{k+1} < (k + 1)!$$
>
> **Proof:**
> We start with the left-hand side of the goal and manipulate it using the hypothesis.
>
> $$2^{k+1} = 2 \cdot 2^k$$
>
> Applying the inductive hypothesis (note that since $2^k < k!$, then $2 \cdot 2^k < 2 \cdot k!$):
>
> $$\overset{\text{IH}}{<} 2 \cdot k!$$
>
> We now observe that for $k \ge 4$, it is true that $2 < k + 1$. Therefore, we can substitute $k + 1$ for $2$ in the inequality:
>
> $$< (k + 1) \cdot k!$$
>
> By definition of the factorial function:
>
> $$= (k + 1)!$$
>
> This shows that $P(k + 1)$ is true when $P(k)$ is true. This completes the inductive step.
>
> **Conclusion:**
> We have completed the basis step and the inductive step. Hence, by mathematical induction, $P(n)$ is true for all integers $n$ with $n \ge 4$.

The **harmonic numbers** $H_j$, where $j = 1, 2, 3, \dots$, are defined by the sum of the reciprocals of the first $j$ positive integers.

> [!info] Definition of Harmonic Numbers
> $$H_j = 1 + \frac{1}{2} + \frac{1}{3} + \dots + \frac{1}{j}$$
>
> **Breakdown:**
> - **$H_j$**: The notation for the $j$-th harmonic number.
> - **$j$**: The index indicating the number of terms in the sum.
> - **Terms**: Each term takes the form $\frac{1}{i}$ where $i$ ranges from 1 to $j$.

For instance, the 4th harmonic number is calculated as:
$$H_4 = 1 + \frac{1}{2} + \frac{1}{3} + \frac{1}{4} = \frac{25}{12}$$

> [!example]- Proving the Harmonic Number Inequality
> **Use mathematical induction to show that:**
> $$H_{2^n} \ge 1 + \frac{n}{2}$$
> whenever $n$ is a nonnegative integer.
>
> **Breakdown:**
> - **$H_{2^n}$**: The harmonic number indexed by $2^n$. This represents the sum of reciprocals up to $1/2^n$.
> - **$n$**: A nonnegative integer acting as the exponent for the index of the harmonic number.
> - **Inequality**: The proposition claims that the harmonic number $H_{2^n}$ is bounded below by $1 + n/2$.
>
> **Solution:**
> Let $P(n)$ be the proposition that $H_{2^n} \ge 1 + \frac{n}{2}$.
>
> **Basis Step:**
> $P(0)$ is true, because $H_{2^0} = H_1 = 1$.
> $$1 \ge 1 + \frac{0}{2} = 1$$
> This completes the basis step.
>
> **Inductive Step:**
> The inductive hypothesis is the statement that $P(k)$ is true for an arbitrary nonnegative integer $k$. That is:
> $$H_{2^k} \ge 1 + \frac{k}{2}$$
>
> **Goal:**
> We must show that $P(k + 1)$ is true, which states:
> $$H_{2^{k+1}} \ge 1 + \frac{k + 1}{2}$$
>
> **Proof:**
> We start by expanding $H_{2^{k+1}}$ using the definition of harmonic numbers. Note that the sum for $H_{2^{k+1}}$ includes the terms of $H_{2^k}$ plus the subsequent terms from $2^k + 1$ to $2^{k+1}$.
>
> $$H_{2^{k+1}} = 1 + \frac{1}{2} + \dots + \frac{1}{2^k} + \frac{1}{2^k + 1} + \dots + \frac{1}{2^{k+1}}$$
>
> We can rewrite this sum by grouping the first $2^k$ terms as $H_{2^k}$:
>
> $$= H_{2^k} + \frac{1}{2^k + 1} + \dots + \frac{1}{2^{k+1}}$$
>
> Applying the inductive hypothesis to the first term:
>
> $$\overset{\text{IH}}{\ge} \left(1 + \frac{k}{2}\right) + \frac{1}{2^k + 1} + \dots + \frac{1}{2^{k+1}}$$
>
> We now examine the sum of the remaining terms. There are $2^{k+1} - 2^k = 2^k$ terms in the sequence from $2^k + 1$ to $2^{k+1}$. Each of these terms is greater than or equal to the smallest term, $\frac{1}{2^{k+1}}$. Therefore, their sum is at least $2^k \cdot \frac{1}{2^{k+1}}$.
>
> $$\ge \left(1 + \frac{k}{2}\right) + 2^k \cdot \frac{1}{2^{k+1}}$$
>
> Simplifying the second term ($2^k / 2^{k+1} = 1/2$):
>
> $$\ge \left(1 + \frac{k}{2}\right) + \frac{1}{2}$$
> $$= 1 + \frac{k + 1}{2}$$
>
> This establishes that $P(k + 1)$ is true.
>
> **Conclusion:**
> We have completed the basis step and the inductive step. Thus, by mathematical induction, $P(n)$ is true for all nonnegative integers $n$.

> [!note] The Harmonic Series Divergence
> The inequality established here, $H_{2^n} \ge 1 + \frac{n}{2}$, provides a proof that the **harmonic series**:
> $$1 + \frac{1}{2} + \frac{1}{3} + \dots + \frac{1}{n} + \dots$$
> is a **divergent infinite series**. As $n$ grows, the sum grows without bound, contradicting the intuitive notion that the terms might sum to a finite limit.

PROVING DIVISIBILITY RESULTS

> [!example]- Proving Divisibility by 3
> **Use mathematical induction to prove that $n^3 - n$ is divisible by 3 whenever $n$ is a positive integer.**
>
> **Breakdown:**
> - **$n$**: A positive integer.
> - **$n^3 - n$**: The expression being tested for divisibility. This can be factored as $n(n^2 - 1) = n(n-1)(n+1)$.
> - **Divisibility by 3**: The property that an integer can be expressed as $3k$ for some integer $k$.
>
> **Solution:**
> Let $P(n)$ be the proposition that "$n^3 - n$ is divisible by 3."
>
> **Basis Step:**
> $P(1)$ is true because $1^3 - 1 = 0$. Since $0 = 3 \cdot 0$, 0 is divisible by 3. This completes the basis step.
>
> **Inductive Step:**
> For the inductive hypothesis, we assume that $P(k)$ is true for an arbitrary positive integer $k$. That is, we assume $k^3 - k$ is divisible by 3.
>
> **Goal:**
> We must show that $P(k + 1)$ is true, meaning we must show that $(k + 1)^3 - (k + 1)$ is divisible by 3.
>
> **Proof:**
> We start by algebraically expanding the expression for $P(k + 1)$:
>
> $$(k + 1)^3 - (k + 1) = (k^3 + 3k^2 + 3k + 1) - (k + 1)$$
>
> Grouping terms allows us to utilize the inductive hypothesis:
>
> $$= (k^3 - k) + (3k^2 + 3k)$$
>
> We analyze the two resulting parts:
> 1.  **$(k^3 - k)$**: By the inductive hypothesis, this term is divisible by 3.
> 2.  **$3(k^2 + k)$**: This term is clearly divisible by 3 because it has 3 as a factor.
>
> Since the sum of two integers divisible by 3 is also divisible by 3, the entire expression $(k + 1)^3 - (k + 1)$ is divisible by 3. This completes the inductive step.
>
> **Conclusion:**
> Because we have completed both the basis step and the inductive step, by the principle of mathematical induction, $n^3 - n$ is divisible by 3 whenever $n$ is a positive integer.
> 
> > [!tip] Alternative Proof via Factorization
>> While mathematical induction is a valid method for proving this result, a simpler proof exists using factorization.
>>
>> The expression can be factored as:
>> $$n^3 - n = n(n^2 - 1) = n(n - 1)(n + 1)$$
>>
>> This product represents the product of three consecutive integers: $(n-1)$, $n$, and $(n+1)$.

> [!example]- Proving Divisibility by 57
> **Use mathematical induction to prove that $7^{n+2} + 8^{2n+1}$ is divisible by 57 for every nonnegative integer $n$.**
>
> **Breakdown:**
> - **$n$**: A nonnegative integer ($n = 0, 1, 2, \dots$).
> - **$7^{n+2}$**: An exponential term with base 7.
> - **$8^{2n+1}$**: An exponential term with base 8. Note that the exponent is linear in $n$.
> - **Divisibility by 57**: The goal is to show that the sum results in an integer multiple of 57.
>
> **Solution:**
> Let $P(n)$ be the proposition that $7^{n+2} + 8^{2n+1}$ is divisible by 57.
>
> **Basis Step:**
> We must show $P(0)$ is true.
> $$7^{0+2} + 8^{2(0)+1} = 7^2 + 8^1 = 49 + 8 = 57$$
> Since 57 is divisible by 57, $P(0)$ is true.
>
> **Inductive Step:**
> For the inductive hypothesis, we assume $P(k)$ is true for an arbitrary nonnegative integer $k$. That is, we assume $7^{k+2} + 8^{2k+1}$ is divisible by 57.
>
> **Goal:**
> We must show that $P(k + 1)$ is true, meaning $7^{(k+1)+2} + 8^{2(k+1)+1}$ is divisible by 57.
>
> **Proof:**
> We begin by expressing the statement $P(k+1)$ in terms of $k$ to see how it relates to the inductive hypothesis.
>
> $$7^{k+3} + 8^{2k+3}$$
>
> We separate the terms to reveal the components of the hypothesis. We rewrite $7^{k+3}$ as $7 \cdot 7^{k+2}$ and $8^{2k+3}$ as $8^2 \cdot 8^{2k+1}$ (since $8^2 = 64$):
>
> $$= 7 \cdot 7^{k+2} + 64 \cdot 8^{2k+1}$$
>
> To utilize the inductive hypothesis, we manipulate the coefficient 64. We rewrite 64 as $7 + 57$:
>
> $$= 7 \cdot 7^{k+2} + (7 + 57) \cdot 8^{2k+1}$$
>
> Distribute the term $8^{2k+1}$:
>
> $$= 7 \cdot 7^{k+2} + 7 \cdot 8^{2k+1} + 57 \cdot 8^{2k+1}$$
>
> Now, factor out 7 from the first two terms:
>
> $$= 7(7^{k+2} + 8^{2k+1}) + 57 \cdot 8^{2k+1}$$
>
> We now analyze the divisibility of the two parts of the sum:
> 1.  **$7(7^{k+2} + 8^{2k+1})$**: By the inductive hypothesis, the term inside the parentheses is divisible by 57. Multiplying by 7 maintains this divisibility.
> 2.  **$57 \cdot 8^{2k+1}$**: This term is clearly divisible by 57 as 57 is an explicit factor.
>
> Since the sum of two integers divisible by 57 is also divisible by 57, the expression $7^{k+3} + 8^{2k+3}$ is divisible by 57.
>
> **Conclusion:**
> We have completed both the basis step and the inductive step. By the principle of mathematical induction, $7^{n+2} + 8^{2n+1}$ is divisible by 57 for every nonnegative integer $n$.

PROVING RESULTS ABOUT SETS

> [!example]- Proving the Count of Subsets
> **Use mathematical induction to show that if $S$ is a finite set with $n$ elements, where $n$ is a nonnegative integer, then $S$ has $2^n$ subsets.**
>
> **Breakdown:**
> - **$S$**: A finite set.
> - **$n$**: The number of elements in set $S$ ($|S| = n$).
> - **$2^n$**: The total number of distinct subsets of $S$.
>
> **Solution:**
> Let $P(n)$ be the proposition that a set with $n$ elements has $2^n$ subsets.
>
> **Basis Step:**
> $P(0)$ is true. A set with zero elements is the empty set $\emptyset$. It has exactly $2^0 = 1$ subset, namely itself (the empty set).
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume that $P(k)$ is true for an arbitrary nonnegative integer $k$. That is, assume that every set with $k$ elements has $2^k$ subsets.
>
> **Goal:** We must show that $P(k + 1)$ is true. That is, we must show that every set with $k + 1$ elements has $2^{k+1}$ subsets.
>
> **Proof:**
> Let $T$ be a set with $k + 1$ elements. We can express $T$ as the union of a set $S$ and a single element $a$:
> $$T = S \cup \{a\}$$
> where $a$ is an element of $T$ and $S = T - \{a\}$ (meaning $|S| = k$).
>
> We can construct the subsets of $T$ by considering the subsets of $S$:
> 1.  **Subsets without $a$:** Every subset $X$ of $S$ is also a subset of $T$.
> 2.  **Subsets with $a$:** For every subset $X$ of $S$, we can form a new subset of $T$ by adding the element $a$, written as $X \cup \{a\}$.
>
> This creates exactly two subsets of $T$ for every single subset of $S$. These subsets are all distinct and they constitute all possible subsets of $T$.
>
> By the inductive hypothesis, $S$ has $2^k$ subsets. Therefore, the number of subsets of $T$ is:
> $$2 \cdot 2^k = 2^{k+1}$$
>
> This establishes that $P(k + 1)$ is true.
>
> **Conclusion:**
> We have completed the basis step and the inductive step. By mathematical induction, $P(n)$ is true for all nonnegative integers $n$. Thus, a set with $n$ elements has $2^n$ subsets.

> [!example]- Proving Generalized De Morgan's Law
> **Use mathematical induction to prove the following generalization of one of De Morgan’s laws:**
> $$ \overline{\bigcap_{j=1}^{n} A_j} = \bigcup_{j=1}^{n} \overline{A_j} $$
> whenever $A_1, A_2, \dots, A_n$ are subsets of a universal set $U$ and $n \ge 2$.
>
> **Breakdown:**
> - **$\overline{A}$**: The complement of set $A$ (elements in the universal set $U$ that are not in $A$).
> - **$\bigcap_{j=1}^{n} A_j$**: The intersection of $n$ sets (elements common to all sets).
> - **$\bigcup_{j=1}^{n} \overline{A_j}$**: The union of the complements of $n$ sets.
> - **The Law**: This identity states that the complement of an intersection is equal to the union of the complements.
>
>![[Pasted image 20260222145253.png]]
>
> **Solution:**
> Let $P(n)$ be the identity for $n$ sets.
>
> **Basis Step:**
> The statement $P(2)$ asserts that $\overline{A_1 \cap A_2} = \overline{A_1} \cup \overline{A_2}$. This is the standard form of De Morgan's law, which serves as the foundation for the generalization. $P(2)$ is true.
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume that $P(k)$ is true for an arbitrary integer $k \ge 2$. That is, assume:
> $$ \overline{\bigcap_{j=1}^{k} A_j} = \bigcup_{j=1}^{k} \overline{A_j} $$
>
> **Goal:**
> We need to show that $P(k + 1)$ is true. That is, we must show:
> $$ \overline{\bigcap_{j=1}^{k+1} A_j} = \bigcup_{j=1}^{k+1} \overline{A_j} $$
>
> **Proof:**
> Let $A_1, A_2, \dots, A_k, A_{k+1}$ be subsets of $U$. We start with the left-hand side of the $P(k+1)$ statement:
>
> $$ \overline{\bigcap_{j=1}^{k+1} A_j} $$
>
> We can separate the intersection into the first $k$ sets and the $(k+1)$-th set using the definition of intersection:
>
> $$ = \overline{\left( \bigcap_{j=1}^{k} A_j \right) \cap A_{k+1}} $$
>
> Now, we apply the standard De Morgan's law (for two sets) to the two terms inside the complement:
>
> $$ = \overline{\bigcap_{j=1}^{k} A_j} \cup \overline{A_{k+1}} $$
>
> Next, we apply the **inductive hypothesis** to the first term:
>
> $$ \overset{\text{IH}}{=} \left( \bigcup_{j=1}^{k} \overline{A_j} \right) \cup \overline{A_{k+1}} $$
>
> Finally, using the definition of the union of $k+1$ sets, we combine the terms:
>
> $$ = \bigcup_{j=1}^{k+1} \overline{A_j} $$
>
> This establishes that $P(k + 1)$ is true.
>
> **Conclusion:**
> We have completed both the basis step and the inductive step. By mathematical induction, $P(n)$ is true for all integers $n \ge 2$.

PROVING RESULTS ABOUT ALGORITHMS

> [!example]- Proving the Optimality of the Greedy Algorithm
> **Use mathematical induction to prove that the greedy algorithm for scheduling talks always produces an optimal schedule (schedules the most talks possible).**
>
> **Problem Setup:**
> The input is a group of $m$ proposed talks with preset starting and ending times. Talk $t_j$ begins at time $s_j$ and ends at time $e_j$. The goal is to schedule as many talks as possible in a lecture hall so that no two talks overlap. A talk can begin at the same time another ends.
>
> **The Greedy Algorithm:**
> 1.  Sort talks in order of nondecreasing ending time ($e_1 \le e_2 \le \dots \le e_m$).
> 2.  Select the talk with the earliest ending time ($t_1$).
> 3.  Iteratively select the next talk in the list that begins no sooner than when the last scheduled talk has ended.
>
> **Solution:**
> Let $P(n)$ be the proposition: *If the greedy algorithm schedules $n$ talks, then it is not possible to schedule more than $n$ talks.*
>
> **Basis Step:**
> Suppose the greedy algorithm schedules just one talk, $t_1$.
> - Since the list is sorted by ending time, $t_1$ has the earliest end time ($e_1$).
> - If it were possible to schedule more than one talk, there would have to be another talk available to schedule after $t_1$.
> - However, the algorithm stopped after $t_1$, meaning no other talk starts at or after $e_1$.
> - Therefore, all other talks must start before $e_1$ and end after $e_1$. This implies every other talk needs the hall at time $e_1$.
> - Consequently, no two talks can be scheduled simultaneously because they all conflict at time $e_1$.
>
> This shows that if the algorithm schedules 1 talk, the maximum possible is indeed 1. $P(1)$ is true.
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume $P(k)$ is true for an arbitrary positive integer $k$. That is, assume that whenever the algorithm selects $k$ talks, it is impossible to schedule more than $k$ talks.
>
> **Goal:** We must show that $P(k + 1)$ is true. That is, if the algorithm selects $k + 1$ talks, it is impossible to schedule more than $k + 1$ talks.
>
> **Proof:**
> Suppose the greedy algorithm has selected $k + 1$ talks.
>
> 1.  **Including the first talk:**
>     The first talk selected is $t_1$ (earliest end time). We argue that there exists an optimal schedule (one with the most possible talks) that includes $t_1$.
>     - Consider an optimal schedule that starts with talk $t_i$ where $i > 1$.
>     - Since $e_1 \le e_i$, talk $t_1$ ends no later than $t_i$.
>     - Therefore, we can replace $t_i$ with $t_1$ without affecting the rest of the schedule (all talks following $t_i$ can still follow $t_1$).
>     - Thus, there is an optimal schedule beginning with $t_1$.
>
> 2.  **Reducing the problem:**
>     Once $t_1$ is scheduled, the problem reduces to scheduling talks from the remaining set that begin at or after $e_1$.
>     - The greedy algorithm scheduled $k$ additional talks after $t_1$.
>     - This is equivalent to running the greedy algorithm on the subset of talks starting after $e_1$.
>
> 3.  **Applying the hypothesis:**
>     By the inductive hypothesis, the greedy algorithm schedules the most possible talks for this reduced problem. Since it found $k$ talks for the subset starting after $e_1$, it is impossible to schedule more than $k$ talks in that time slot.
>
> 4.  **Conclusion:**
>     Since we have 1 talk ($t_1$) plus an optimal schedule of $k$ talks for the remaining time, the total of $k + 1$ talks is optimal.
>
> This establishes that $P(k + 1)$ is true.
>
> **Conclusion:**
> We have completed the basis step and the inductive step. By mathematical induction, $P(n)$ is true for all positive integers $n$. The greedy algorithm is optimal.

CREATIVE USES OF MATHEMATICAL INDUCTION

An odd number of people stand in a yard at mutually distinct distances. At the same time, each person throws a pie at their nearest neighbor. We can use mathematical induction to prove that there is always at least one survivor—a person who is not hit by a pie.

> [!example]- Proving the Existence of a Survivor
>
>> [!note]
>> This result holds specifically for an **odd** number of people. It is false for an even number of people.
>
> **Let $P(n)$ be the statement that there is a survivor whenever $2n + 1$ people stand in a yard at distinct mutual distances and each throws a pie at their nearest neighbor.**
>
> **Solution:**
> We prove this for all positive integers $n$, effectively covering all odd integers greater than or equal to 3.
>
> **Basis Step:**
> When $n = 1$, there are $2(1) + 1 = 3$ people.
> - Let the closest pair among the three be $A$ and $B$, with $C$ being the third person.
> - Because distances are distinct, the distance between $A$ and $C$ and between $B$ and $C$ are both greater than the distance between $A$ and $B$.
> - Therefore, $A$ and $B$ throw pies at each other.
> - $C$ throws a pie at whichever is closer, $A$ or $B$.
> - Consequently, $C$ is not hit by a pie.
>
> This proves that at least one of the three people survives, so $P(1)$ is true.
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume $P(k)$ is true for an arbitrary positive integer $k$. That is, assume there is at least one survivor whenever $2k + 1$ people are in the yard.
>
> **Goal:** Show that $P(k + 1)$ is true. That is, show there is at least one survivor whenever $2(k + 1) + 1 = 2k + 3$ people are in the yard.
>
> **Proof:**
> Suppose we have $2k + 3$ people. Let $A$ and $B$ be the closest pair in the entire group. By definition, $A$ and $B$ throw pies at each other. We consider two cases:
>
> **Case (i): Someone else throws a pie at $A$ or $B$.**
> - We know $A$ and $B$ throw pies at each other.
> - If a third person throws a pie at either $A$ or $B$, then at least three pies are targeting the pair $\{A, B\}$.
> - The remaining number of people is $(2k + 3) - 2 = 2k + 1$.
> - The maximum number of pies these remaining people could be targeted with is the total number of pies minus those aimed at $A$ and $B$:
>   $$(2k + 3) - 3 = 2k$$
> - If every single one of the $2k + 1$ remaining people were hit, they would need to be targeted by at least $2k + 1$ pies.
> - Since only $2k$ pies are available for them, it is impossible for all of them to be hit.
> - Therefore, at least one person among them is a survivor.
>
> **Case (ii): No one else throws a pie at $A$ or $B$.**
> - Since only $A$ and $B$ target each other, and no one else targets them, the rest of the group ($2k + 1$ people) effectively participates in a separate pie fight.
> - By the **inductive hypothesis**, a group of $2k + 1$ people must have at least one survivor, let's call this survivor $S$.
> - $S$ is not hit by anyone in the subgroup.
> - Furthermore, $S$ is not hit by $A$ or $B$ because $A$ and $B$ are throwing pies at each other.
> - Therefore, $S$ is a survivor in the full group of $2k + 3$ people.
>
> In both cases, a survivor exists. This completes the inductive step.
>
> **Conclusion:**
> We have completed the basis step and the inductive step. By mathematical induction, $P(n)$ is true for all positive integers $n$. Whenever an odd number of people located in a yard at distinct mutual distances each throws a pie at their nearest neighbor, there is at least one survivor.

> [!example]- Proving Checkerboard Tiling
> **Show that every $2^n \times 2^n$ checkerboard with one square removed can be tiled using right triominoes.**
>
> **Breakdown:**
> - **$2^n \times 2^n$**: The dimensions of the checkerboard. The side length is a power of 2 (e.g., 2, 4, 8, ...).
> - **Right Triomino**: An L-shaped tile consisting of three squares.
> - **Tiling**: Covering the entire board with tiles such that tiles do not overlap and every empty square is covered.
>
> **Solution:**
> Let $P(n)$ be the proposition that every $2^n \times 2^n$ checkerboard with one square removed can be tiled using right triominoes. We use mathematical induction to prove this for all positive integers $n$.
>
> **Basis Step:**
> $P(1)$ is true. A $2^1 \times 2^1 = 2 \times 2$ checkerboard has 4 squares. If one square is removed, the remaining shape consists of exactly three squares. This shape is identical to a right triomino, so it can be tiled with a single piece.
> 
> ![[Pasted image 20260222153000.png]]
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume that $P(k)$ is true for an arbitrary positive integer $k$. That is, assume any $2^k \times 2^k$ checkerboard with one square removed can be tiled.
>
> **Goal:** We must show that $P(k + 1)$ is true. That is, we must show that any $2^{k+1} \times 2^{k+1}$ checkerboard with one square removed can be tiled.
>
> **Proof:**
> Consider a $2^{k+1} \times 2^{k+1}$ checkerboard with one square removed.
>
> 1.  **Divide:** Split this large checkerboard into four smaller checkerboards of size $2^k \times 2^k$ by drawing lines through the center of the board horizontally and vertically.
>
> 2.  **Identify the Empty Quadrant:** The removed square must lie in exactly one of these four smaller checkerboards. By the inductive hypothesis, this specific quadrant can be completely tiled since it is a $2^k \times 2^k$ board with one square missing.
>
> 3.  **Handle the Remaining Quadrants:**
>     - The remaining three quadrants are full $2^k \times 2^k$ boards (no squares removed yet).
>     - Temporarily remove the center square from each of these three quadrants. The center squares are located at the corner where the four quadrants meet.
>     - Now, each of these three quadrants is a $2^k \times 2^k$ board with one square removed. By the inductive hypothesis, each can be tiled with right triominoes.
>
> 4.  **The Center Gap:**
>     - The three squares we temporarily removed from the centers of the quadrants form an L-shape at the center of the original board.
>     - This L-shape can be covered by exactly one right triomino.
>
> By combining the tiling of the originally missing square's quadrant, the tilings of the three modified quadrants, and the central triomino, the entire $2^{k+1} \times 2^{k+1}$ checkerboard is successfully tiled.
>
>![[Pasted image 20260222153016.png]]
>
> **Conclusion:**
> We have completed the basis step and the inductive step. Therefore, by mathematical induction, $P(n)$ is true for all positive integers $n$. Every $2^n \times 2^n$ checkerboard with one square removed can be tiled using right triominoes.

### Mistaken Proofs By Mathematical Induction

Mathematical induction, similar to other proof techniques, presents numerous opportunities for errors. Many well-known—and often entertaining—mistaken proofs have been constructed using induction to "prove" statements that are clearly false.

> [!tip] Identifying Errors
> To uncover errors in proofs by mathematical induction, remember that both the **basis step** and the **inductive step** must be correctly completed.

> [!example] The Consequence of Skipping Steps
> Not completing the basis step can lead to mistaken proofs of clearly ridiculous statements.
>
> **Example:** A flawed inductive process might erroneously conclude that `$n = n + 1$` for every positive integer `$n$`.

> [!example] Find the error in this "proof" of the clearly false claim that every set of lines in the plane, no two of which are parallel, meet in a common point.
> 
> **"Proof":** Let $P(n)$ be the statement that every set of $n$ lines in the plane, no two of which are parallel, meet in a common point. We will attempt to prove that $P(n)$ is true for all positive integers $n \geq 2$.
> 
> **Basis Step:** The statement $P(2)$ is true because any two lines in the plane that are not parallel meet in a common point (by the definition of parallel lines).
> 
> **Inductive Step:** The inductive hypothesis is the statement that $P(k)$ is true for the positive integer $k$, that is, it is the assumption that every set of $k$ lines in the plane, no two of which are parallel, meet in a common point. To complete the inductive step, we must show that if $P(k)$ is true, then $P(k + 1)$ must also be true. That is, we must show that if every set of $k$ lines in the plane, no two of which are parallel, meet in a common point, then every set of $k + 1$ lines in the plane, no two of which are parallel, meet in a common point. So, consider a set of $k + 1$ distinct lines in the plane. By the inductive hypothesis, the first $k$ of these lines meet in a common point $p_1$. Moreover, by the inductive hypothesis, the last $k$ of these lines meet in a common point $p_2$. We will show that $p_1$ and $p_2$ must be the same point. If $p_1$ and $p_2$ were different points, all lines containing both of them must be the same line because two points determine a line. This contradicts our assumption that all these lines are distinct. Thus, $p_1$ and $p_2$ are the same point. We conclude that the point $p_1 = p_2$ lies on all $k + 1$ lines. We have shown that $P(k + 1)$ is true assuming that $P(k)$ is true. This completes the inductive step.
> 
> **Solution:** Examining this supposed proof by mathematical induction it appears that everything is in order. However, there is an error, as there must be. The error is rather subtle. Carefully looking at the inductive step shows that this step requires that $k \geq 3$. We cannot show that $P(2)$ implies $P(3)$. When $k = 2$, our goal is to show that every three distinct lines meet in a common point. The first two lines must meet in a common point $p_1$ and the last two lines must meet in a common point $p_2$. But in this case, $p_1$ and $p_2$ do not have to be the same, because only the second line is common to both sets of lines. Here is where the inductive step fails.

## Strong Induction and Well-Ordering

### Introduction

Strong induction is another form of mathematical induction. It is often useful when a result cannot be easily proven using standard mathematical induction.

> [!info] Comparison of Induction Methods
> **Basis Step:** identical in both methods. To prove that $P(n)$ is true for all positive integers $n$, the basis step shows that $P(1)$ is true.
>
> **Inductive Step:**
> - **Mathematical Induction:** Shows that if the inductive hypothesis $P(k)$ is true, then $P(k + 1)$ is also true.
> - **Strong Induction:** Shows that if $P(j)$ is true for all positive integers $j$ not exceeding $k$, then $P(k + 1)$ is true. In this case, the inductive hypothesis assumes that $P(j)$ is true for $j = 1, 2, \dots, k$.

The validity of both mathematical induction and strong induction follows from the **well-ordering property**.

> [!note] Equivalence of Principles
> Mathematical induction, strong induction, and well-ordering are all equivalent principles. The validity of each can be proved from the other two.
>
> Consequently, a proof using one of these principles can be rewritten as a proof using either of the other two. It is often easier to see how to prove a result using strong induction or well-ordering rather than standard mathematical induction.

### Strong Induction

> [!summary] Strong Induction
> To prove that $P(n)$ is true for all positive integers $n$, where $P(n)$ is a propositional function, complete two steps:
>
> **BASIS STEP:** Verify that the proposition $P(1)$ is true.
>
> **INDUCTIVE STEP:** Show that the conditional statement $[P(1) \land P(2) \land \dots \land P(k)] \rightarrow P(k + 1)$ is true for all positive integers $k$.
>
> **Breakdown:**
> - **$P(1) \land P(2) \land \dots \land P(k)$** : The strong inductive hypothesis. This assumes that the statement is true for *all* integers from $1$ up to $k$.
> - **$\rightarrow$** : Logical implication. If the left side is true, the right side must follow.
> - **$P(k + 1)$** : The proposition to be proven for the next integer.

**The Inductive Hypothesis:**
When using strong induction, the inductive hypothesis assumes that $P(j)$ is true for $j = 1, 2, \dots, k$. This includes all $k$ statements $P(1), P(2), \dots, P(k)$.

Because the proof can utilize all $k$ statements rather than just $P(k)$ (as in standard mathematical induction), strong induction is a more flexible proof technique. Some mathematicians prefer to always use strong induction, even when standard mathematical induction is easy to find.

**Equivalence to Mathematical Induction:**
Mathematical induction and strong induction are equivalent principles. Each can be shown to be a valid proof technique assuming the validity of the other.

- **Converting Math Induction to Strong Induction:** This is straightforward. If $P(k+1)$ follows from $P(k)$, it also follows from $P(1) \land \dots \land P(k)$, because the set of assumptions is larger.
- **Converting Strong Induction to Math Induction:** This is much more awkward to accomplish.

> [!note] Terminology
> Strong induction is sometimes called the **second principle of mathematical induction** or **complete induction**.
>
> When "complete induction" is used, standard mathematical induction is sometimes called **incomplete induction**. This is a somewhat unfortunate technical term, as standard mathematical induction is a perfectly valid proof technique.

**Strong Induction and the Infinite Ladder:**
Strong induction can be visualized using the infinite ladder analogy. It tells us we can reach all rungs if:
1. We can reach the first rung.
2. For every positive integer $k$, if we can reach all the first $k$ rungs, then we can reach the $(k + 1)$st rung.

> [!example] 
> Suppose we can reach the first and second rungs of an infinite ladder, and we know that if we can reach a rung, then we can reach two rungs higher. Can we prove that we can reach every rung?
>
> **Solution using Mathematical Induction:**
>
> **Basis Step:** We can verify we can reach the first rung.
>
> **Attempted Inductive Step:** The inductive hypothesis states we can reach the $k$th rung. We need to show we can reach the $(k+1)$st rung. However, knowing we can reach the $k$th rung does not help us, because the rule only allows us to reach two rungs higher (to $k+2$). We have no information about reaching $k+1$ from $k$. The proof fails.
>
> **Solution using Strong Induction:**
>
> **Basis Step:** We verify we can reach the first rung.
>
> **Inductive Step:** The inductive hypothesis states we can reach each of the first $k$ rungs. We need to show we can reach the $(k+1)$st rung.
>
> We know from the premise that we can reach the second rung. For $k \geq 2$, we can reach the $(k+1)$st rung from the $(k-1)$st rung because:
> 1. We can climb two rungs from any reachable rung.
> 2. Since $k-1 \leq k$, the inductive hypothesis guarantees we can reach the $(k-1)$st rung.
>
> This completes the inductive step. We have proved that if we can reach the first two rungs and can reach the $(k+1)$st rung assuming we can reach the first $k$ rungs, we can reach all rungs of the ladder.

### Examples of Proofs Using Strong Induction

When deciding between mathematical induction and strong induction, there is no strict rule, but several useful pointers can guide the choice.

> [!tip] Choosing the Right Method
> **Use Mathematical Induction when:**
> - It is straightforward to prove that $P(k) \rightarrow P(k + 1)$ is true for all positive integers $k$.
> - You can clearly see that the inductive step goes through using only the assumption of $P(k)$.
>
> **Use Strong Induction when:**
> - You cannot easily see how to prove $P(k + 1)$ follows from just $P(k)$.
> - You can see how to prove $P(k + 1)$ is true assuming $P(j)$ is true for all positive integers $j$ not exceeding $k$.

In the proofs utilizing strong induction, it is important to consider why the standard inductive step would fail or be difficult to construct compared to the strong inductive step.

**Modified Form of Strong Induction:**

Strong induction can be adapted to handle situations where the inductive step is valid only for integers greater than a particular integer.

> [!info] Alternative Form of Strong Induction
> Let $b$ be a fixed integer and $j$ be a fixed positive integer. To prove that $P(n)$ is true for all integers $n$ with $n \ge b$:
>
> **BASIS STEP:** Verify that the propositions $P(b), P(b + 1), \dots, P(b + j)$ are true.
>
> **INDUCTIVE STEP:** Show that the conditional statement $[P(b) \land P(b + 1) \land \dots \land P(k)] \rightarrow P(k + 1)$ is true for every integer $k \ge b + j$.
>
> **Breakdown:**
> - **$b$** : The starting integer (base case) for the proof.
> - **$j$** : A fixed positive integer determining how many base cases are needed to support the inductive step.
> - **$P(b) \dots P(k)$** : The strong inductive hypothesis, assuming truth for all integers from the base up to $k$.

This alternative form is equivalent to the standard form of strong induction. One of the most prominent uses of this method is proving part of the **Fundamental Theorem of Arithmetic**, which states that every positive integer can be written as the product of primes.

> [!example]- Proving Every Integer > 1 is a Product of Primes
> **Show that if $n$ is an integer greater than 1, then $n$ can be written as the product of primes.**
>
> **Breakdown:**
> - **$n$**: An integer greater than 1.
> - **$P(n)$**: The proposition that $n$ can be written as the product of primes.
> - **Strong Induction**: The proof method used, allowing the assumption that $P(j)$ is true for all integers $j$ from the base case up to $k$.
>
> **Solution:**
> Let $P(n)$ be the proposition that $n$ can be written as the product of primes.
>
> **Basis Step:**
> $P(2)$ is true. The integer 2 can be written as the product of one prime, itself. (This is the first case needed because $n > 1$).
> 
> > [!note] Remark on the Basis Step
> >Because 1 can be thought of as an empty product of primes (the product of no primes), the proof could have started with $P(1)$ as the basis step. However, the text avoids this because the concept of an "empty product" is often confusing.
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume that $P(j)$ is true for all integers $j$ with $2 \le j \le k$. That is, assume that every integer $j$ (where $2 \le j \le k$) can be written as the product of primes.
>
> **Goal:** We must show that $P(k + 1)$ is true. That is, we must show that $k + 1$ can be written as the product of primes.
>
> **Proof:**
> To show that $k + 1$ is a product of primes, we consider two cases:
>
> 1.  **$k + 1$ is Prime:** If $k + 1$ is prime, it is immediately a product of primes (itself), so $P(k + 1)$ is true.
> 2.  **$k + 1$ is Composite:** If $k + 1$ is composite, it can be written as the product of two positive integers $a$ and $b$ such that $2 \le a \le b < k + 1$.
>     *   Because both $a$ and $b$ are integers at least 2 and not exceeding $k$, we can apply the inductive hypothesis to both.
>     *   Therefore, $a$ can be written as a product of primes, and $b$ can be written as a product of primes.
>     *   Consequently, $k + 1 = a \cdot b$ can be written as the product of the primes from the factorization of $a$ and the factorization of $b$.
>
> In both cases, $k + 1$ can be written as the product of primes.
>
> **Conclusion:**
> We have completed the basis step and the inductive step. By strong induction, $P(n)$ is true for all integers $n$ greater than 1. Thus, every integer greater than 1 can be written as the product of primes.

> [!example]- Proving the Second Player Wins a Symmetric Match Game
> **Consider a game in which two players take turns removing any positive number of matches they want from one of two piles of matches. The player who removes the last match wins the game. Show that if the two piles contain the same number of matches initially, the second player can always guarantee a win.**
>
> **Breakdown:**
> - **$n$**: The number of matches in each pile at the start of the game.
> - **$P(n)$**: The proposition that the second player can win when there are initially $n$ matches in each pile.
> - **Symmetry Strategy**: The core logic where the second player mirrors the first player's moves to maintain balance.
>
> **Solution:**
> We use strong induction on $n$, the number of matches in each pile.
>
> **Basis Step:**
> $P(1)$ is true. The first player has only one choice: remove one match from one of the piles. This leaves a single pile with a single match. The second player removes that last match and wins the game.
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume that $P(j)$ is true for all integers $j$ with $1 \le j \le k$. That is, the second player can always win whenever there are $j$ matches in each of the two piles.
>
> **Goal:** We must show that $P(k + 1)$ is true. That is, the second player can win when there are initially $k + 1$ matches in each pile.
>
> **Proof:**
> Suppose there are $k + 1$ matches in each pile at the start of the game. The first player removes $r$ matches from one pile.
>
> We consider two scenarios based on the value of $r$:
>
> 1.  **The First Player Removes All Matches ($r = k + 1$):**
>     If the first player removes all $k + 1$ matches from one pile, the second player wins immediately by removing all $k + 1$ matches from the remaining pile.
>
> 2.  **The First Player Removes Partial Matches ($1 \le r \le k$):**
>     The first player leaves $k + 1 - r$ matches in that pile.
>     *   The second player uses the **symmetry strategy**: they remove the same number of matches ($r$) from the *other* pile.
>     *   This creates a situation where there are two piles, each with $k + 1 - r$ matches.
>     *   Since $1 \le r \le k$, it follows that $1 \le k + 1 - r \le k$.
>     *   Because the number of matches in each pile ($k + 1 - r$) is an integer between $1$ and $k$, the **inductive hypothesis** applies. Therefore, the second player can guarantee a win from this state.
>
> **Conclusion:**
> We have completed the basis step and the inductive step. By strong induction, $P(n)$ is true for all positive integers $n$. Thus, if the two piles contain the same number of matches initially, the second player can always guarantee a win.

> [!example]- Proving Postage Amounts with 4-cent and 5-cent Stamps
> **Prove that every amount of postage of 12 cents or more can be formed using just 4-cent and 5-cent stamps.**
>
> **Breakdown:**
> - **$n$**: The amount of postage in cents.
> - **$P(n)$**: The proposition that postage of $n$ cents can be formed using 4-cent and 5-cent stamps.
> - **Constraint**: The proof must hold for all integers $n \ge 12$.
>
> **Solution 1: Using Mathematical Induction**
>
> **Basis Step:**
> $P(12)$ is true. Postage of 12 cents can be formed using three 4-cent stamps ($4 + 4 + 4 = 12$).
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume $P(k)$ is true for some integer $k \ge 12$. That is, postage of $k$ cents can be formed.
>
> **Goal:** Show that $P(k + 1)$ is true.
>
> **Proof:**
> We consider two cases based on the stamps used to form $k$ cents:
> 1.  **At least one 4-cent stamp is used:** We can replace one 4-cent stamp with a 5-cent stamp. This increases the total value by 1 cent ($k \to k + 1$).
> 2.  **No 4-cent stamps are used (only 5-cent stamps):** Since $k \ge 12$, there must be at least three 5-cent stamps used to form $k$ cents. We can replace three 5-cent stamps (totaling 15 cents) with four 4-cent stamps (totaling 16 cents). This increases the total value by 1 cent ($k \to k + 1$).
>
> In both cases, we can form $k + 1$ cents.
>
> **Solution 2: Using Strong Induction**
>
> **Basis Step:**
> We verify that $P(12), P(13), P(14),$ and $P(15)$ are all true.
> -   **12 cents:** Three 4-cent stamps.
> -   **13 cents:** Two 4-cent stamps and one 5-cent stamp.
> -   **14 cents:** One 4-cent stamp and two 5-cent stamps.
> -   **15 cents:** Three 5-cent stamps.
>
> **Inductive Step:**
> **Inductive Hypothesis:** Assume $P(j)$ is true for all integers $j$ with $12 \le j \le k$, where $k \ge 15$.
>
> **Goal:** Show that $P(k + 1)$ is true.
>
> **Proof:**
> To form postage for $k + 1$ cents, we look at a previous value.
> Because $k \ge 15$, we know that $k - 3 \ge 12$.
> By the inductive hypothesis, we can form postage for $k - 3$ cents.
> To form postage for $k + 1$ cents, we simply add one 4-cent stamp to the stamps used for $k - 3$ cents:
> $$ (k - 3) + 4 = k + 1 $$
> Thus, $P(k + 1)$ is true.
>
> **Conclusion:**
> Both methods successfully prove that every amount of postage of 12 cents or more can be formed using just 4-cent and 5-cent stamps. (Note: Solutions not using mathematical induction also exist).

### Using Strong Induction in Computational Geometry

[[Computational geometry]] is the branch of discrete mathematics focused on computational problems involving geometric objects. It has widespread applications in computer graphics, robotics, and scientific calculations.

#### Polygons and Terminology

>[!info] Polygon Definitions
> - **Polygon**: A closed geometric figure consisting of a sequence of line segments, called **sides** ($s_1, s_2, \dots, s_n$).
> - **Vertex**: The common endpoint where two consecutive sides meet.
> - **Simple Polygon**: A polygon where no two nonconsecutive sides intersect.
> - **Convex Polygon**: A polygon where every line segment connecting two points in the interior lies entirely inside the polygon. If this condition is not met, the polygon is **nonconvex**.

Simple polygons divide the plane into two regions: the **interior** (points inside the curve) and the **exterior** (points outside). This division is a specific case of the **Jordan curve theorem**.

>[!info] Diagonals
> A **diagonal** is a line segment connecting two nonconsecutive vertices.
> 
> An **interior diagonal** lies entirely inside the polygon, except for its endpoints.

>[!example] Diagonal Identification
> In a sample nonconvex polygon, a line segment connecting vertex $a$ to vertex $f$ might be an interior diagonal. Conversely, a segment connecting $a$ to $d$ might be a diagonal that is *not* an interior diagonal because it passes outside the polygon's interior.

#### Triangulation

**Triangulation** is the process of dividing a simple polygon into triangles by adding nonintersecting diagonals. A simple polygon can have multiple valid triangulations.

![[Pasted image 20260222155011.png]]
![[Pasted image 20260222155018.png]]

>[!summary] Theorem: Triangulation of Simple Polygons
> A simple polygon with $n$ sides, where $n$ is an integer with $n \geq 3$, can be triangulated into $n - 2$ triangles.

The proof of this theorem relies on strong induction and a preliminary lemma.

>[!warning] Lemma
> Every simple polygon with at least four sides has an interior diagonal.
> 
> *Note: While this lemma appears simple, it is notoriously tricky to prove correctly.*

#### Proof of Theorem

The proof uses strong induction on the number of sides $n$.

**Basis Step:**
For $n = 3$, the polygon is already a triangle. It is triangulated into $3 - 2 = 1$ triangle. Thus, $T(3)$ is true.

**Inductive Step:**
We assume the inductive hypothesis: $T(j)$ is true for all integers $j$ with $3 \leq j \leq k$. This means we assume any polygon with $j$ sides can be triangulated into $j - 2$ triangles.

We must show $T(k+1)$ is true: every simple polygon with $k+1$ sides can be triangulated into $(k+1) - 2 = k - 1$ triangles.

1.  **Identify an Interior Diagonal**: Since $k+1 \geq 4$, Lemma 1 guarantees the existence of an interior diagonal $ab$ in polygon $P$.
2.  **Split the Polygon**: The diagonal $ab$ splits $P$ into two smaller simple polygons, $Q$ (with $s$ sides) and $R$ (with $t$ sides).
    - Both $Q$ and $R$ have fewer sides than $P$.
    - Therefore, $3 \leq s \leq k$ and $3 \leq t \leq k$.
3.  **Calculate Side Counts**:
    - The sides of $P$ are distributed between $Q$ and $R$.
    - The diagonal $ab$ counts as a side for both $Q$ and $R$ but not for $P$.
    - Therefore, the total number of sides relates as:
      $$k + 1 = s + t - 2$$

>[!example] Breakdown of Side Equation
> - **Equation**: $k + 1 = s + t - 2$
> - **Breakdown**:
>     - **$k + 1$**: The number of sides in the original polygon $P$.
>     - **$s$**: The number of sides in sub-polygon $Q$.
>     - **$t$**: The number of sides in sub-polygon $R$.
>     - **$-2$**: Adjustment because the diagonal $ab$ is counted as a side in both $Q$ and $R$, but was not a side in $P$.

4.  **Apply Inductive Hypothesis**:
    - Because $s$ and $t$ are within the range of the inductive hypothesis ($3 \leq s,t \leq k$), we can triangulate $Q$ into $s - 2$ triangles and $R$ into $t - 2$ triangles.
5.  **Combine Results**:
    - The triangulations of $Q$ and $R$ together form a triangulation of $P$.
    - Total triangles = $(s - 2) + (t - 2) = s + t - 4$.
    - Substituting $s + t = k + 3$ (derived from the side count equation $k+1 = s+t-2 \Rightarrow s+t = k+3$):
      $$ \text{Total triangles} = (k + 3) - 4 = k - 1 $$
    - This equals $(k + 1) - 2$, proving the theorem.

#### Proof of Lemma

This proof constructs an interior diagonal for a simple polygon $P$ with at least four sides.

1.  **Identify Vertex $b$**: Choose the vertex (or interior point) with the least y-coordinate among vertices with the smallest x-coordinate. $b$ must be a vertex; if it were interior, a vertex with a smaller x-coordinate would exist.
2.  **Identify Neighbors**: Let $a$ and $c$ be the vertices adjacent to $b$. The interior angle at $b$ (formed by $ab$ and $bc$) must be less than 180 degrees; otherwise, a point with a smaller x-coordinate would exist.
3.  **Examine Triangle $T$**: Consider the triangle $\triangle abc$.
    - **Case 1**: If no vertices of $P$ lie on or inside $T$, the segment $ac$ is an interior diagonal.
    - **Case 2**: If vertices of $P$ exist inside $T$, locate a specific vertex $p$ to create the diagonal $bp$.

>[!tip] Constructing the Diagonal in Case 2
> To find the interior diagonal when vertices exist inside $\triangle abc$:
> 1. Select a vertex $p$ inside $T$ such that the angle $\angle bap$ is the smallest possible.
> 2. Consider the ray starting at $a$ and passing through $p$. This ray intersects the line segment $bc$ at a point $q$.
> 3. The triangle $\triangle baq$ cannot contain any vertices of $P$ in its interior (by the minimality of the angle).
> 4. Consequently, the line segment connecting $b$ and $p$ is an interior diagonal of $P$.
### Proofs Using the Well-Ordering Property

The validity of both the principle of mathematical induction and strong induction is derived from a fundamental axiom known as the **well-ordering property**. These three concepts—mathematical induction, strong induction, and the well-ordering property—are logically equivalent; the validity of any one implies the validity of the other two.

>[!summary] The Well-Ordering Property
> Every nonempty set of nonnegative integers has a least element.

This property can be used directly to construct proofs, particularly in number theory and combinatorics.

The division algorithm states that given an integer $a$ and a positive integer $d$, there exist unique integers $q$ (quotient) and $r$ (remainder) such that $0 \leq r < d$ and $a = dq + r$.

>[!example] Proof of the Division Algorithm
>We want to prove the existence of $q$ and $r$ using the well-ordering property.
>
>**Equation:** $a = dq + r$
>
>**Breakdown:**
>- **$a$**: The dividend (the integer being divided).
>- **$d$**: The divisor (a positive integer).
>- **$q$**: The quotient.
>- **$r$**: The remainder (constrained by $0 \leq r < d$).
>
>**Proof:**
>1.  **Define the Set:** Let $S$ be the set of nonnegative integers of the form $a - dq$, where $q$ is an integer.
>    $$S = \{ a - dq \mid q \in \mathbb{Z}, a - dq \geq 0 \}$$
>2.  **Nonempty Check:** The set $S$ is nonempty. By choosing $q$ to be a negative integer with a sufficiently large absolute value, the term $-dq$ becomes large enough to make $a - dq$ nonnegative.
>3.  **Apply Well-Ordering:** Since $S$ is a nonempty set of nonnegative integers, it must have a least element by the well-ordering property. Let this least element be $r = a - dq_0$.
>4.  **Verify Constraints:**
>    - By definition of $S$, $r$ is nonnegative ($r \geq 0$).
>    - We must show $r < d$. Suppose, for the sake of contradiction, that $r \geq d$.
>    - If $r \geq d$, we can construct a new element in $S$:
>      $$a - d(q_0 + 1) = (a - dq_0) - d = r - d$$
>    - Since we assumed $r \geq d$, then $r - d \geq 0$. This means $r - d$ is a nonnegative integer in $S$.
>    - However, $r - d$ is strictly smaller than $r$. This contradicts the choice of $r$ as the *least* element of $S$.
>5.  **Conclusion:** Therefore, $r < d$, and we have found integers $q_0$ and $r$ satisfying the conditions of the division algorithm.

In a **round-robin tournament**, every player plays every other player exactly once, with no ties (one winner, one loser). A **cycle** occurs when a sequence of players $p_1, p_2, \dots, p_m$ exists such that $p_1$ beats $p_2$, $p_2$ beats $p_3$, ..., and $p_m$ beats $p_1$.

>[!example] Existence of a Cycle of Length Three
>**Claim:** If there is a cycle of length $m$ ($m \geq 3$) in a round-robin tournament, then there must be a cycle of length three.
>
>**Proof:**
>1.  **Assumption:** Assume, for the sake of contradiction, that there is no cycle of length three.
>2.  **Define the Set:** Let $S$ be the set of all positive integers $n$ for which a cycle of length $n$ exists. Since we are given that a cycle of length $m$ exists, $S$ is nonempty.
>3.  **Apply Well-Ordering:** By the well-ordering property, $S$ has a least element $k$. Based on our assumption that no cycle of length three exists, we must have $k > 3$.
>4.  **Analyze the Minimal Cycle:** Consider a cycle of length $k$: $p_1, p_2, p_3, \dots, p_k$. Because $k$ is the smallest cycle length, no shorter cycles can exist.
>5.  **Construct a Contradiction:** Examine the first three players in this cycle: $p_1, p_2, p_3$.
>    - We know $p_1$ beats $p_2$ and $p_2$ beats $p_3$.
>    - Consider the match between $p_1$ and $p_3$. There are two outcomes:
>        - **Case 1:** $p_3$ beats $p_1$.
>            - Then $p_1, p_2, p_3$ forms a cycle of length three. This contradicts the assumption that no such cycle exists.
>        - **Case 2:** $p_1$ beats $p_3$.
>            - Then we can remove $p_2$ from the original sequence to form a new cycle: $p_1, p_3, p_4, \dots, p_k$.
>            - This new cycle has length $k - 1$. Since $k - 1 < k$, this contradicts the assumption that $k$ is the length of the *shortest* cycle.
>6.  **Conclusion:** Since both possible outcomes for the match between $p_1$ and $p_3$ lead to a contradiction, our initial assumption must be false. Therefore, a cycle of length three must exist.

### Recursively Defined Functions

A recursive definition (or inductive definition) establishes a function with the set of nonnegative integers as its domain using two specific steps.

>[!info] Steps for Recursive Definition
>1.  **Basis Step:** Specify the value of the function at zero.
>2.  **Recursive Step:** Give a rule for finding the function's value at an integer from its values at smaller integers.

This approach is equivalent to defining a sequence $a_0, a_1, \dots$ using a recurrence relation. Recursively defined functions are **well defined**, meaning the value for every positive integer is determined unambiguously. This is a consequence of the principle of mathematical induction.

>[!example] Calculating Recursive Values
>Suppose $f$ is defined by $f(0) = 3$ and $f(n+1) = 2f(n) + 3$.
>
>- **$f(1)$**: $2f(0) + 3 = 2(3) + 3 = 9$
>- **$f(2)$**: $2f(1) + 3 = 2(9) + 3 = 21$
>- **$f(3)$**: $2f(2) + 3 = 2(21) + 3 = 45$
>- **$f(4)$**: $2f(3) + 3 = 2(45) + 3 = 93$

#### Defining Fundamental Operations

Recursive definitions can formalize basic mathematical operations like exponentiation and summation.

>[!example] Recursive Definition of Exponentiation
>To define $a^n$ where $a$ is a nonzero real number:
>- **Basis Step:** $a^0 = 1$
>- **Recursive Step:** $a^{n+1} = a \cdot a^n$ for $n = 0, 1, 2, \dots$

>[!example] Recursive Definition of Summation
>To define $\sum_{k=0}^{n} a_k$:
>- **Basis Step:** $\sum_{k=0}^{0} a_k = a_0$
>- **Recursive Step:** $\sum_{k=0}^{n+1} a_k = \left( \sum_{k=0}^{n} a_k \right) + a_{n+1}$
>
>**Breakdown:**
>- **$\sum$**: The Summation Operator. It indicates the addition of a sequence of terms.
>- **$k=0$**: The lower limit. The summation starts with the term index 0.
>- **$n$**: The upper limit. The summation stops when the index reaches this number.
>- **$a_k$**: The term to be added, dependent on the current index $k$.

#### Fibonacci Numbers

Some recursive definitions specify values for the first $k$ positive integers and a rule deriving larger integers from preceding values. The Fibonacci numbers are a classic example, defined by $f_0 = 0$, $f_1 = 1$, and $f_n = f_{n-1} + f_{n-2}$ for $n \geq 2$.

>[!example] Proving Fibonacci Inequalities
>Show that for $n \geq 3$, $f_n > \alpha^{n-2}$, where $\alpha = \frac{1 + \sqrt{5}}{2}$.
>
>**Equation:** $f_n > \alpha^{n-2}$
>**Breakdown:**
>- **$f_n$**: The $n$-th Fibonacci number.
>- **$\alpha$**: The Golden Ratio (approx. 1.618). It is a solution to $x^2 - x - 1 = 0$, implying $\alpha^2 = \alpha + 1$.
>- **$n$**: The index of the term, an integer $\geq 3$.
>
>**Proof using Strong Induction:**
>Let $P(n)$ be the statement $f_n > \alpha^{n-2}$.
>
>1.  **Basis Step:**
>    - For $n=3$: $\alpha \approx 1.618 < 2 = f_3$. Thus $P(3)$ is true.
>    - For $n=4$: $\alpha^2 \approx 2.618 < 3 = f_4$. Thus $P(4)$ is true.
>    *(Note: We need two base cases because the inductive step relies on the two preceding values).*
>
>2.  **Inductive Step:**
>    - Assume $P(j)$ is true for all integers $j$ with $3 \leq j \leq k$, where $k \geq 4$.
>    - We must show $P(k+1)$ is true, i.e., $f_{k+1} > \alpha^{k-1}$.
>    - We know $\alpha^2 = \alpha + 1$. Multiplying by $\alpha^{k-3}$:
>      $$ \alpha^{k-1} = \alpha^2 \cdot \alpha^{k-3} = (\alpha + 1)\alpha^{k-3} = \alpha^{k-2} + \alpha^{k-3} $$
>    - By the inductive hypothesis: $f_{k-1} > \alpha^{k-3}$ and $f_k > \alpha^{k-2}$.
>    - Combining these:
>      $$ f_{k+1} = f_k + f_{k-1} > \alpha^{k-2} + \alpha^{k-3} = \alpha^{k-1} $$
>    - Therefore, $P(k+1)$ is true.

---

### Lamé's Theorem

The Euclidean algorithm's efficiency can be analyzed using Fibonacci numbers.

>[!summary] Theorem 1: Lamé's Theorem
>Let $a$ and $b$ be positive integers with $a \geq b$. The number of divisions used by the Euclidean algorithm to find $\gcd(a, b)$ is less than or equal to five times the number of decimal digits in $b$.
>
>**Breakdown:**
>- **$a, b$**: Positive integers inputs, $a \geq b$.
>- **Divisions**: The number of steps (equations) in the Euclidean algorithm.
>- **Decimal digits**: The length of the number $b$ in base 10.

#### Proof of Lamé's Theorem

The proof relates the remainders in the Euclidean algorithm to the Fibonacci sequence.

**1. The Euclidean Algorithm Sequence:**
When finding $\gcd(a, b)$, the algorithm generates a series of equations:
$$ \begin{aligned} r_0 &= r_1 q_1 + r_2 \\ r_1 &= r_2 q_2 + r_3 \\ &\vdots \\ r_{n-2} &= r_{n-1} q_{n-1} + r_n \\ r_{n-1} &= r_n q_n \end{aligned} $$
Here, $a = r_0$, $b = r_1$, and $n$ divisions are used to find $r_n = \gcd(a, b)$.

**2. Relating to Fibonacci Numbers:**
- The quotients $q_1, \dots, q_{n-1} \geq 1$.
- The final quotient $q_n \geq 2$ (since $r_n < r_{n-1}$).
- We can establish a lower bound for the remainders using the Fibonacci sequence:
  - $r_n \geq 1 = f_2$
  - $r_{n-1} \geq 2r_n \geq 2f_2 = f_3$
  - $r_{n-2} \geq r_{n-1} + r_n \geq f_3 + f_2 = f_4$
- Continuing this logic backward, we find that $b = r_1 \geq f_{n+1}$.

**3. Applying the Fibonacci Inequality:**
From the earlier example, we know $f_{n+1} > \alpha^{n-1}$ for $n > 2$, where $\alpha = \frac{1+\sqrt{5}}{2}$.
Therefore:
$$ b > \alpha^{n-1} $$

**4. Logarithmic Bounds:**
Taking the base-10 logarithm:
$$ \log_{10} b > (n-1) \log_{10} \alpha $$
Since $\log_{10} \alpha \approx 0.208 > \frac{1}{5}$:
$$ \log_{10} b > \frac{n-1}{5} \implies n-1 < 5 \log_{10} b $$

**5. Conclusion:**
If $b$ has $k$ decimal digits, then $b < 10^k$, which implies $\log_{10} b < k$.
$$ n - 1 < 5k \implies n \leq 5k $$
Since $k$ is the number of digits in $b$, the number of divisions $n$ is at most five times the number of digits in $b$.

Because the number of digits in $b$ is $\lfloor \log_{10} b \rfloor + 1$, the number of divisions is $O(\log b)$.