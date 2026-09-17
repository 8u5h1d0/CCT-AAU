---
tags:
  - CCT3
  - Algoritmer
Topic: complexity analysis, proof of correctness, design
Semester: CCT3
Course: Algoritmer
Litterature:
  - Introduction to Algorithms, 4th ed.
Created: 17-09-2026
---
# Table of Contents

1. [[#1 The Role of Algorithms in Computing|1 The Role of Algorithms in Computing]]
	1. [[#1 The Role of Algorithms in Computing#1.1 Algorithms|1.1 Algorithms]]
		1. [[#1.1 Algorithms#The Sorting Problem — A Formal Example|The Sorting Problem — A Formal Example]]
		2. [[#1.1 Algorithms#Correctness of Algorithms|Correctness of Algorithms]]
		3. [[#1.1 Algorithms#Kinds of Problems Solved by Algorithms|Kinds of Problems Solved by Algorithms]]
		4. [[#1.1 Algorithms#Data Structures|Data Structures]]
		5. [[#1.1 Algorithms#Technique|Technique]]
		6. [[#1.1 Algorithms#Hard Problems and NP-Completeness|Hard Problems and NP-Completeness]]
		7. [[#1.1 Algorithms#Alternative Computing Models|Alternative Computing Models]]
	2. [[#1 The Role of Algorithms in Computing#1.2 Algorithms as a technology|1.2 Algorithms as a technology]]
		1. [[#1.2 Algorithms as a technology#Efficiency|Efficiency]]
		2. [[#1.2 Algorithms as a technology#Algorithms and other technologies|Algorithms and other technologies]]
	3. [[#1 The Role of Algorithms in Computing#2 Getting Started|2 Getting Started]]
	4. [[#1 The Role of Algorithms in Computing#2.1 Insertion sort|2.1 Insertion sort]]
		1. [[#2.1 Insertion sort#Pseudocode for Insertion Sort|Pseudocode for Insertion Sort]]
		2. [[#2.1 Insertion sort#Loop Invariants and Correctness|Loop Invariants and Correctness]]
		3. [[#2.1 Insertion sort#Pseudocode Conventions|Pseudocode Conventions]]
	5. [[#1 The Role of Algorithms in Computing#2.2 Analyzing algorithms|2.2 Analyzing algorithms]]
		1. [[#2.2 Analyzing algorithms#The RAM Model of Computation|The RAM Model of Computation]]
		2. [[#2.2 Analyzing algorithms#Analysis of Insertion Sort|Analysis of Insertion Sort]]
		3. [[#2.2 Analyzing algorithms#Worst-Case and Average-Case Analysis|Worst-Case and Average-Case Analysis]]
		4. [[#2.2 Analyzing algorithms#Order of Growth|Order of Growth]]

- - -
# 1 The Role of Algorithms in Computing

## 1.1 Algorithms

An _algorithm_ is a well-defined computational procedure that takes some value or set of values as **input** and produces some value or set of values as **output** in a finite amount of time. It is a sequence of computational steps that transform the input into the output.

> [!info] Algorithm as a Problem-Solving Tool
> An algorithm can be viewed as a tool for solving a well-specified _computational problem_. The problem statement defines the desired input/output relationship in general terms (for instances of arbitrarily large size), and the algorithm provides a specific computational procedure to achieve that relationship for _all_ problem instances.

### The Sorting Problem — A Formal Example

Sorting a sequence of numbers into monotonically increasing order is a fundamental operation in computer science and a common intermediate step in many programs.

> [!example] Formal Definition of the Sorting Problem
> - **Input:** A sequence of $n$ numbers $\langle a_1, a_2, \ldots, a_n \rangle$.
> - **Output:** A permutation (reordering) $\langle a'_1, a'_2, \ldots, a'_n \rangle$ of the input sequence such that $a'_1 \leq a'_2 \leq \cdots \leq a'_n$.
> - **Concrete instance:** Given the input $\langle 31, 41, 59, 26, 41, 58 \rangle$, a correct sorting algorithm returns $\langle 26, 31, 41, 41, 58, 59 \rangle$.

An _instance_ of a problem consists of the specific input (satisfying the problem's constraints) needed to compute a solution.

The best sorting algorithm for a given application depends on several factors:
- The number of items to be sorted
- The extent to which items are already partially sorted
- Restrictions on item values
- The computer architecture
- The kind of storage devices used (main memory, disks, tapes)

### Correctness of Algorithms

An algorithm is **correct** if, for every problem instance provided as input, it:
1. **Halts** — finishes computing in finite time
2. **Outputs the correct solution** to the problem instance

An _incorrect_ algorithm might not halt on some inputs, or might halt with an incorrect answer. Interestingly, incorrect algorithms can sometimes be useful if their error rate is controllable (e.g., algorithms for finding large prime numbers). In most contexts, however, only correct algorithms are of interest.

An algorithm can be specified in natural language, as a computer program, or even as a hardware design — the only requirement is a **precise description** of the computational procedure.

### Kinds of Problems Solved by Algorithms

Algorithms address a vast range of practical problems. Some major application areas include:

- **Genomics:** Identifying genes in DNA, determining sequences of billions of chemical base pairs, storing genomic data, and developing analysis tools. Techniques like _dynamic programming_ are essential for determining similarity between DNA sequences, saving both time and money.

- **Internet and Information Retrieval:** Managing and manipulating large volumes of data, finding efficient routes for data travel through networks, and enabling search engines to quickly locate relevant pages.

- **Electronic Commerce:** Securing transactions through _public-key cryptography_ and _digital signatures_, which rely on numerical algorithms and number theory to protect credit card numbers, passwords, and bank statements.

- **Resource Allocation:** Optimizing the use of scarce resources — placing oil wells to maximize profit, allocating campaign advertising budgets, assigning airline crews to flights cost-effectively, or positioning network resources for better service. These are often modeled as _linear programs_.

Specific algorithmic problems that illustrate common challenges include:

- **Shortest Path:** Given a road map with distances between adjacent intersections, find the shortest route between two points. The map is modeled as a _graph_, and the goal is to find the shortest path between two vertices. The number of possible routes can be enormous.

- **Topological Sorting:** Given a mechanical design with $n$ parts (where parts may contain sub-parts), list the parts so each appears before any part that uses it. There are $n!$ possible orderings, and since the factorial function grows faster than any exponential, brute-force enumeration is infeasible for all but the smallest designs.

- **Clustering:** Determining whether a medical image represents a cancerous or benign tumor by comparing it to known examples. A _clustering algorithm_ groups similar items together to identify the most likely classification.

- **Data Compression:** Reducing file sizes using techniques like `LZW compression` (which finds repeating character sequences) or `Huffman coding` (which encodes frequent characters with shorter bit sequences).

- **Signal Processing:** The _discrete Fourier transform_ converts time-domain signal samples to the frequency domain, approximating the signal as a weighted sum of sinusoids. The _fast Fourier transform_ (FFT) provides an efficient algorithm for this computation, with applications in data compression and multiplying large polynomials and integers.

> [!note] Common Characteristics of Interesting Algorithmic Problems
> 1. **Many candidate solutions:** The overwhelming majority do not solve the problem. Finding one that does — or the "best" one — without examining every possibility is the central challenge.
> 2. **Practical applications:** These problems arise in real-world settings with tangible financial or operational impact (e.g., transportation firms minimizing fuel costs, internet routing nodes minimizing latency, navigation apps providing driving directions).

### Data Structures

A _data structure_ is a way to store and organize data to facilitate access and modifications. Choosing the appropriate data structure is a critical part of algorithm design. No single data structure works well for all purposes, so understanding the strengths and limitations of several is important.

### Technique

Beyond serving as a reference for known algorithms, the study of algorithms teaches **design and analysis techniques** that enable you to:
- Develop new algorithms for novel problems
- Prove that algorithms produce correct answers
- Analyze algorithmic efficiency

Key techniques include _divide-and-conquer_, _dynamic programming_, and _amortized analysis_, among others.

### Hard Problems and NP-Completeness

Most algorithmic study focuses on _efficient_ algorithms, where efficiency is typically measured by **speed** (how long the algorithm takes to produce its result). However, some problems have no known algorithm that runs in a reasonable amount of time. A particularly important subset of these are the **NP-complete** problems.

> [!summary] Why NP-Complete Problems Are Remarkable
> 1. **Unknown status:** No efficient algorithm has ever been found for any NP-complete problem, yet no one has proven that one cannot exist.
> 2. **Interconnectedness:** If an efficient algorithm exists for _any one_ NP-complete problem, then efficient algorithms exist for _all_ of them.
> 3. **Sensitivity:** Many NP-complete problems are nearly identical to problems with known efficient solutions — a small change in the problem statement can dramatically alter the efficiency of the best known algorithm.

> [!tip] Practical Advice on NP-Complete Problems
> NP-complete problems arise surprisingly often in real applications. If you are asked to produce an efficient algorithm for one, you risk a fruitless search. Instead, if you can show the problem is NP-complete, you can redirect effort toward developing an **approximation algorithm** — one that produces a good (though not necessarily optimal) solution efficiently.

> [!example] The Traveling-Salesperson Problem
> A delivery company with a central depot wants to determine the order of delivery stops that minimizes the total distance traveled by each truck (which must return to the depot at the end of the day). This is the well-known _traveling-salesperson problem_, which is NP-complete and has no known efficient algorithm. However, under certain assumptions, efficient approximation algorithms can compute routes with total distances close to the minimum possible.

### Alternative Computing Models

**Parallel Computing:** Physical limitations (power density increases superlinearly with clock speed, risking chip meltdown) have ended the era of steadily increasing processor clock speeds. Modern chips instead contain multiple processing _cores_, effectively creating parallel computers on a single chip. Designing algorithms with _parallelism_ in mind — such as _task-parallel_ algorithms — is essential for exploiting multicore architectures.

**Online Algorithms:** Many real-world scenarios involve input that arrives over time rather than being fully available at the start. The algorithm must make decisions without knowing future data. Examples include:
- Scheduling jobs in a data center as they arrive and depart
- Routing internet traffic based on current network state
- Making triage decisions in hospital emergency rooms

Algorithms that handle such streaming input are called _online algorithms_.

## 1.2 Algorithms as a technology

Even if computers were infinitely fast and computer memory were free, the study of algorithms would remain essential to ensure that a chosen solution method terminates and produces the correct result. 

In reality, computing time and memory are bounded, precious resources. While money can be regained after it is spent, computational time cannot. Algorithms must therefore be chosen to use the resources of time and space efficiently.

### Efficiency

Different algorithms designed to solve the exact same problem often differ dramatically in their efficiency. These algorithmic differences are frequently far more significant than variations in hardware or software implementations.

Consider two sorting algorithms:
- **[[Insertion Sort]]:** Takes time roughly proportional to $c_1 n^2$, where $c_1$ is a constant independent of the input size $n$.
- **[[Merge Sort]]:** Takes time roughly proportional to $c_2 n \lg n$, where $\lg n = \log_2 n$ and $c_2$ is another constant independent of $n$.

While insertion sort typically has a smaller constant factor ($c_1 < c_2$), constant factors have much less impact on running time than the algorithm's dependence on the input size $n$:
- Insertion sort scales with $n \cdot n$.
- Merge sort scales with $n \cdot \lg n$.

Because $\lg n$ grows far more slowly than $n$ (for example, when $n = 1{,}000$, $\lg n \approx 10$; when $n = 1{,}000{,}000$, $\lg n \approx 20$), there is always a **crossover point** beyond which merge sort is faster, regardless of how small $c_1$ is compared to $c_2$.

> [!example] Hardware Power vs. Algorithmic Efficiency
> Pitting a fast computer running an asymptotically slower algorithm against a slow computer running an asymptotically faster algorithm demonstrates the supremacy of algorithmic efficiency over raw computing power:
> 
> - **Computer A (Fast):** Executes $10^{10}$ instructions/second. Runs an expertly coded implementation of insertion sort requiring $2n^2$ instructions.
> - **Computer B (Slow):** Executes $10^7$ instructions/second ($1{,}000\times$ slower). Runs an implementation of merge sort compiled with an inefficient compiler, requiring $50 n \lg n$ instructions.
> 
> **Sorting $n = 10^7$ (10 million) numbers:**
> 
> - **Execution Time on Computer A:**
>   $$\text{Time}_A = \frac{2 \cdot (10^7)^2 \text{ instructions}}{10^{10} \text{ instructions/second}} = 20{,}000 \text{ seconds} \approx 5.5 \text{ hours}$$
> 
> - **Execution Time on Computer B:**
>   $$\text{Time}_B = \frac{50 \cdot 10^7 \lg(10^7) \text{ instructions}}{10^7 \text{ instructions/second}} \approx 1{,}163 \text{ seconds} < 20 \text{ minutes}$$
> 
> **Breakdown of calculation terms:**
> - $n$ : The problem instance size ($10^7$ items).
> - $\lg(10^7)$ : Base-2 logarithm of the input size ($\approx 23.25$).
> - $\text{Time}_A, \text{Time}_B$ : Total running time in seconds.
> 
> Despite being $1{,}000$ times slower in raw processing speed and using a poorer compiler, Computer B completes the task over **$17$ times faster** than Computer A. 
> 
> When sorting $100$ million ($10^8$) numbers, the difference is even greater: insertion sort takes more than $23$ days, while merge sort finishes in under $4$ hours.

### Algorithms and other technologies

Algorithms should be viewed as a foundational **technology**, just like computer hardware. Total system performance depends as heavily on selecting efficient algorithms as it does on choosing fast hardware.

Even when advanced computing technologies are present—such as modern hardware architectures, graphical user interfaces (GUIs), object-oriented programming, fast networking, and mobile platforms—algorithms remain critical:

1. **Direct Application Requirements:** Many applications explicitly require algorithmic solutions at the user level (e.g., routing services requiring shortest-path algorithms, map rendering, and address interpolation).
2. **Underlying Infrastructure:** Technologies that support applications rely fundamentally on algorithms:
   - Hardware fabrication and design use algorithms.
   - GUI engines rely on graphics algorithms.
   - Network routing relies on graph and distribution algorithms.
   - Compilers, assemblers, and interpreters that process code are built on parsing and optimization algorithms.

> [!info] Algorithms and Emerging Fields
> - **[[Machine Learning]]:** Rather than replacing traditional algorithms, machine learning is itself a collection of algorithms designed to infer patterns from data. It excels at tasks where the optimal explicit algorithm is not yet understood by humans (such as computer vision or automatic translation). For well-understood computational problems, specialized algorithms designed for the specific task remain significantly more efficient and reliable.
> - **[[Data Science]]:** An interdisciplinary field combining statistics, computer science, and optimization to extract knowledge from data. Its core techniques rely heavily on the design and analysis of efficient algorithms.

As computer capacities continue to expand, systems are tasked with solving increasingly massive problem instances—the exact regime where differences in algorithmic efficiency are most critical.

## 2 Getting Started

This section establishes the framework for thinking about algorithm design and analysis. It introduces pseudocode as a specification language, examines the insertion sort algorithm in detail, and demonstrates how to prove algorithm correctness using loop invariants.

## 2.1 Insertion sort

The sorting problem takes as input a sequence of $n$ numbers $\langle a_1, a_2, \ldots, a_n \rangle$ and produces a permutation $\langle a'_1, a'_2, \ldots, a'_n \rangle$ such that $a'_1 \leq a'_2 \leq \cdots \leq a'_n$. The numbers being sorted are called _keys_.

> [!info] Keys and Satellite Data
> Although sorting is conceptually about ordering a sequence of numbers, the input typically arrives as an array of $n$ elements. The values being sorted are the _keys_, but each key is usually associated with additional data called _satellite data_. Together, a key and its satellite data form a _record_. For example, in a student spreadsheet the sorting key might be grade-point average, but the associated satellite data includes the student's name, age, and course count. When the sort rearranges keys, it moves the entire record along with them.

Insertion sort is an efficient algorithm for sorting a small number of elements. It works analogously to sorting a hand of playing cards: starting with an empty hand, you pick up cards one at a time from a pile and insert each card into its correct position among the cards already in your hand. To find the correct position, you compare the new card with each card in your hand from right to left, inserting it just to the right of the first card whose value is less than or equal to the new card. At all times, the cards held in your hand remain sorted.

### Pseudocode for Insertion Sort

Algorithms are described using _pseudocode_ — a specification language similar to C, C++, Java, Python, or JavaScript that prioritizes clarity and conciseness over software engineering concerns like data abstraction, modularity, and error handling. English phrases may be embedded where they improve readability.

```
INSERTION-SORT(A, n)
    // A is an array of n elements, indexed A[1] through A[n].
    // After execution, A[1..n] contains the original values in sorted order.

    for i = 2 to n
        key = A[i]                    // The "current card" to be inserted
        // Insert A[i] into the sorted subarray A[1..i-1]
        j = i - 1
        while j > 0 and A[j] > key
            A[j + 1] = A[j]          // Shift element one position to the right
            j = j - 1
        A[j + 1] = key               // Place key in its correct position
```

![[Pasted image 20260917084511.png]]
Figure 2.1 Sorting a hand of cards using insertion sort

The procedure takes an array `A` and its length `n`. The values occupy positions `A[1]` through `A[n]`, denoted `A[1..n]`. The outer `for` loop iterates from $i = 2$ to $n$; in each iteration the element `A[i]` (the _key_) is inserted into the already-sorted subarray `A[1..i-1]`.

### Loop Invariants and Correctness

A _loop invariant_ is a property that holds true at the beginning of each iteration of a loop. Loop invariants are the primary tool for reasoning about why an algorithm is correct.

> [!summary] Loop Invariant for Insertion Sort
> At the start of each iteration of the `for` loop (indexed by $i$), the subarray `A[1..i-1]` consists of the elements originally in positions $1$ through $i-1$, but in sorted order.

To prove that an algorithm is correct using a loop invariant, three properties must be demonstrated:

> [!info] The Three Properties of a Loop Invariant Proof
> 1. **Initialization:** The invariant is true prior to the first iteration of the loop.
> 2. **Maintenance:** If the invariant is true before an iteration, it remains true before the next iteration.
> 3. **Termination:** The loop terminates, and upon termination the invariant — combined with the reason the loop ended — yields a useful property that demonstrates the algorithm's correctness.

This structure mirrors _mathematical induction_: initialization corresponds to the base case, maintenance to the inductive step, and termination is where the "induction" stops (unlike pure mathematical induction, which continues infinitely).

> [!example] Correctness Proof for Insertion Sort
> **Initialization:** Before the first iteration, $i = 2$. The subarray `A[1..i-1]` is `A[1..1]`, which contains only the single original element `A[1]`. A single-element subarray is trivially sorted, so the invariant holds.
> 
> **Maintenance:** The body of the `for` loop shifts elements `A[i-1]`, `A[i-2]`, `A[i-3]`, ... one position to the right until the proper position for the key `A[i]` is found, at which point the key is inserted. After this, `A[1..i]` contains the original elements from positions $1$ through $i$ in sorted order. Incrementing $i$ for the next iteration preserves the invariant.
> 
> **Termination:** The loop variable $i$ starts at $2$ and increments by $1$ each iteration. The loop terminates when $i = n + 1$. Substituting $n + 1$ for $i$ in the loop invariant: the subarray `A[1..n]` consists of the original elements in sorted order. Therefore, the algorithm is correct.

![[Pasted image 20260917084609.png]]
Figure 2.2 The operation of I NSERTION-SORT.A; n/, where A initially contains the sequence h5; 2; 4; 6; 1; 3i and n D 6. Array indices appear above the rectangles, and values stored in the array positions appear within the rectangles. (a)–(e) The iterations of the for loop of lines 138. In each iteration, the blue rectangle holds the key taken from AŒi�, which is compared with the values in tan rectangles to its left in the test of line 5. Orange arrows show array values moved one position to the right in line 6, and blue arrows indicate where the key moves to in line 8. (f) The ûnal sorted array.
### Pseudocode Conventions

The pseudocode used throughout follows these conventions:

- **Indentation** indicates block structure (for loop bodies, while loop bodies, if-else blocks). No explicit `begin`/`end` keywords or curly braces are used.

- **Loop constructs** (`while`, `for`, `repeat-until`) and **conditionals** (`if-else`) behave as in most mainstream languages. The `for` loop counter retains its value after the loop exits — its value is the first value that exceeded the loop bound. The keyword `to` indicates incrementing, `downto` indicates decrementing, and the optional keyword `by` specifies a step size greater than $1$.

- **Comments** begin with `//` and extend to the end of the line.

- **Variables** are local to their procedure unless explicitly stated otherwise.

- **Array access** uses square brackets: `A[i]` denotes the $i$-th element. Indexing is typically 1-origin (arrays start at index $1$), and bounds are stated explicitly. The notation `A[i..j]` denotes the subarray consisting of elements `A[i]`, `A[i+1]`, ..., `A[j]`.

- **Objects and attributes:** Compound data is organized into objects with attributes accessed via dot notation (e.g., `x.f`). Variables representing arrays or objects act as _pointers_ (references) to the underlying data. Assigning `y = x` makes `y` and `x` point to the same object, so modifying `x.f` also changes `y.f`. Attribute access cascades: `x.f.g` is implicitly parenthesized as `(x.f).g`. A pointer that refers to no object has the special value `NIL`.

- **Parameter passing** is by value: the called procedure receives a copy of each parameter. However, for objects and arrays the _pointer_ is copied (not the entire data structure), so modifications to object attributes or array elements _are_ visible to the caller. Reassigning the parameter variable itself (e.g., `x = y`) is _not_ visible to the caller.

- **Return statements** transfer control back to the caller and may return multiple values without requiring them to be packaged into an object.

- **Boolean operators** `and` and `or` are _short-circuiting_: in `x and y`, the expression `y` is evaluated only if `x` is `TRUE`; in `x or y`, `y` is evaluated only if `x` is `FALSE`. This allows safe expressions like `x ≠ NIL and x.f = y` without risking a null-pointer access.

- The keyword `error` indicates that the procedure was called under invalid conditions and terminates immediately. The calling procedure is responsible for handling the error.

## 2.2 Analyzing algorithms

Analyzing an algorithm means predicting the resources it requires — most commonly computational time, but potentially also memory, communication bandwidth, or energy consumption. By analyzing several candidate algorithms for the same problem, you can identify the most efficient one and rule out inferior alternatives.

### The RAM Model of Computation

Before analyzing an algorithm, you need a model of the technology it runs on. The standard model is the **random-access machine (RAM)**: a generic one-processor computer in which instructions execute sequentially (no concurrent operations).

> [!info] Key Assumptions of the RAM Model
> - Each instruction takes a **constant** amount of time, regardless of which instruction it is.
> - Each data access (reading or writing a variable, including array indexing) also takes a **constant** amount of time.
> - **Instructions** include: arithmetic (add, subtract, multiply, divide, remainder, floor, ceiling), data movement (load, store, copy), and control (conditional/unconditional branch, subroutine call/return).
> - **Data types:** integer, floating-point, and character. Boolean values are typically represented as integers (0 for `FALSE`, nonzero for `TRUE`).
> - **Word size:** Each word holds at most $c \lg n$ bits for some constant $c \geq 1$, where $n$ is the input size. The requirement $c \geq 1$ ensures a word can hold the value $n$ (needed for indexing), and the restriction to a constant $c$ prevents the unrealistic scenario of storing arbitrarily large data in a single word.

> [!warning] Limitations and Gray Areas of the RAM Model
> - The RAM model does **not** account for the memory hierarchy (caches, virtual memory). While memory-hierarchy effects can be significant in practice, RAM-model analyses are usually excellent predictors of real-world performance and are far simpler to work with.
> - Some operations are ambiguous. For example, general exponentiation $x^n$ takes time logarithmic in $n$, not constant time. However, computing $2^n$ via a bit-shift is a constant-time operation as long as the result fits in a single word. The guiding principle is to stay consistent with what real computers can actually do in constant time.

### Analysis of Insertion Sort

Running an algorithm on a specific machine and timing it yields results that depend on the hardware, compiler, libraries, background processes, and the particular input used — making it nearly impossible to generalize. Instead, we analyze the algorithm itself by counting how many times each line of pseudocode executes and how long each line takes.

**Input size** is the primary factor affecting running time. The best measure depends on the problem:
- For sorting: the number of items $n$.
- For integer multiplication: the total number of bits in the binary representation.
- For graph algorithms: both the number of vertices and the number of edges.

**Running time** is the total number of instructions and data accesses executed, expressed as a function $T(n)$ of the input size $n$.

Under the RAM model, each execution of line $k$ of the pseudocode takes a constant amount of time $c_k$. The total running time is the sum over all lines of (cost per execution) $\times$ (number of executions).

> [!example] Cost Analysis of Insertion Sort
> Let $t_i$ denote the number of times the `while` loop test (line 5) is executed for a given value of $i$. When a loop exits normally (test evaluates to `FALSE`), the test runs one more time than the loop body.
> 
> | Line | Pseudocode | Cost | Times |
> |------|-----------|------|-------|
> | 1 | `for i = 2 to n` | $c_1$ | $n$ |
> | 2 | `key = A[i]` | $c_2$ | $n - 1$ |
> | 3 | `// comment` | $0$ | $n - 1$ |
> | 4 | `j = i - 1` | $c_4$ | $n - 1$ |
> | 5 | `while j > 0 and A[j] > key` | $c_5$ | $\sum_{i=2}^{n} t_i$ |
> | 6 | `A[j + 1] = A[j]` | $c_6$ | $\sum_{i=2}^{n} (t_i - 1)$ |
> | 7 | `j = j - 1` | $c_7$ | $\sum_{i=2}^{n} (t_i - 1)$ |
> | 8 | `A[j + 1] = key` | $c_8$ | $n - 1$ |
> 
> - **Breakdown of summation terms:**
>     - $\sum_{i=2}^{n}$ : The summation operator. Adds up a quantity for each value of the outer loop variable $i$ from $2$ to $n$.
>     - $t_i$ : The number of times the `while` condition is checked during the $i$-th iteration of the outer `for` loop. This value depends on the input.
>     - $(t_i - 1)$ : The number of times the `while` loop *body* executes (one fewer than the number of condition checks, since the final check fails).

Summing the products of the cost and times columns gives the total running time:

$$T(n) = c_1 n + c_2(n-1) + c_4(n-1) + c_5 \sum_{i=2}^{n} t_i + c_6 \sum_{i=2}^{n}(t_i - 1) + c_7 \sum_{i=2}^{n}(t_i - 1) + c_8(n-1)$$

The value of $t_i$ — and therefore $T(n)$ — depends on the specific input, even for a fixed input size $n$.

**Best case (array already sorted):** Each `while` test fails immediately, so $t_i = 1$ for all $i$. The running time simplifies to:

$$T(n) = (c_1 + c_2 + c_4 + c_5 + c_8)\,n - (c_2 + c_4 + c_5 + c_8)$$

This is a **linear** function of $n$, expressible as $an + b$ for constants $a$ and $b$.

**Worst case (array in reverse sorted order):** Each element `A[i]` must be compared with every element in the sorted subarray `A[1..i-1]`, so $t_i = i$. Using the summation identities:

$$\sum_{i=2}^{n} i = \frac{n(n+1)}{2} - 1 \qquad \text{and} \qquad \sum_{i=2}^{n}(i-1) = \frac{n(n-1)}{2}$$

the worst-case running time becomes:

$$T(n) = \left(\frac{c_5}{2} + \frac{c_6}{2} + \frac{c_7}{2}\right)n^2 + \left(c_1 + c_2 + c_4 + \frac{c_5}{2} - \frac{c_6}{2} - \frac{c_7}{2} + c_8\right)n - (c_2 + c_4 + c_5 + c_8)$$

This is a **quadratic** function of $n$, expressible as $an^2 + bn + c$ for constants $a$, $b$, and $c$.

### Worst-Case and Average-Case Analysis

Although both best-case and worst-case running times are informative, the focus is usually on the **worst-case running time** — the longest running time for any input of size $n$. Three reasons justify this choice:

1. **Guaranteed upper bound:** The worst-case running time is an absolute ceiling. The algorithm will _never_ take longer, which is critical for real-time systems with strict deadlines.
2. **Frequency:** The worst case often occurs in practice. For example, a database search for an item that is not present typically triggers the worst case, and such searches may be common.
3. **Average case is often similar:** For insertion sort on $n$ randomly chosen numbers, the element `A[i]` is on average compared with half of the sorted subarray `A[1..i-1]`, giving $t_i \approx i/2$. The resulting average-case running time is still a quadratic function of $n$ — just as bad as the worst case.

> [!note] Average-Case and Randomized Algorithms
> Average-case analysis is sometimes useful but has limited scope because it is often unclear what constitutes an "average" input. A common assumption is that all inputs of a given size are equally likely. When this assumption is unrealistic, _randomized algorithms_ — which make internal random choices — can enable probabilistic analysis and yield a meaningful expected running time.

### Order of Growth

The exact running-time formulas derived above are overly detailed for comparing algorithms. The constants $c_k$ depend on the specific machine and implementation, and the lower-order terms become negligible for large inputs. The key simplification is to focus on the **order of growth** (or _rate of growth_):

- **Keep only the leading term** of the formula (e.g., $an^2$), since lower-order terms are relatively insignificant for large $n$.
- **Ignore the constant coefficient** of the leading term, since constant factors are less significant than the rate of growth for large inputs.

For insertion sort's worst case, stripping away lower-order terms and the constant coefficient leaves $n^2$. For the best case, the result is $n$.

> [!summary] Θ-Notation (Theta Notation)
> The Greek letter $\Theta$ (theta) captures the order of growth concisely. Informally, $\Theta(f(n))$ means "roughly proportional to $f(n)$ when $n$ is large."
> 
> - Insertion sort **best case:** $\Theta(n)$ — linear growth.
> - Insertion sort **worst case:** $\Theta(n^2)$ — quadratic growth.
> 
> An algorithm is considered **more efficient** than another if its worst-case running time has a _lower_ order of growth. For example, a $\Theta(n^2)$ algorithm will always outperform a $\Theta(n^3)$ algorithm on sufficiently large inputs, regardless of the hidden constant factors. There always exists some threshold input size $n_0$ beyond which the lower-order-growth algorithm is faster in the worst case.