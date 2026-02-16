---
tags:
  - "#CCT2"
  - DS
Topic: What "discrete" numbers are; Sets; Relations between sets, Functions & Inter-set Functions
Semester: CCT2
Course: Diskrete strukturer
Litterature: Discrete Mathematics and Its Applications - 8th Ed.
Created: 05/202026
---
- - - 
# Table of Contents

1. [[#Basic Structures|Basic Structures]]
	1. [[#Basic Structures#Sets|Sets]]
		1. [[#Sets#Intro|Intro]]
			1. [[#Intro#Roster Notation|Roster Notation]]
			2. [[#Intro#Set Builder Notation|Set Builder Notation]]
				1. [[#Set Builder Notation#Summary Hierarchy|Summary Hierarchy]]
		2. [[#Sets#Venn Diagrams|Venn Diagrams]]
		3. [[#Sets#Subsets|Subsets]]
		4. [[#Sets#Size|Size]]
		5. [[#Sets#Power Sets|Power Sets]]
		6. [[#Sets#Cartesian Products|Cartesian Products]]
		7. [[#Sets#Set Notation w. Quantifiers|Set Notation w. Quantifiers]]
		8. [[#Sets#Truth Sets and Quantifiers|Truth Sets and Quantifiers]]
	2. [[#Basic Structures#Operations|Operations]]
		1. [[#Operations#Intro|Intro]]
		2. [[#Operations#Set Identities|Set Identities]]
		3. [[#Operations#Generalized Unions & Intersections|Generalized Unions & Intersections]]
		4. [[#Operations#Computer Representation of Sets|Computer Representation of Sets]]
		5. [[#Operations#Multi-sets|Multi-sets]]
	3. [[#Basic Structures#Functions|Functions]]
		1. [[#Functions#Intro|Intro]]
		2. [[#Functions#1-to-1 and "Onto" Functions|1-to-1 and "Onto" Functions]]
		3. [[#Functions#Inverse Functions and Compositions of Functions|Inverse Functions and Compositions of Functions]]
		4. [[#Functions#Graphs of Functions|Graphs of Functions]]
	4. [[#Basic Structures#Important Functions|Important Functions]]
		1. [[#Important Functions#The Floor Function & Ceiling Function|The Floor Function & Ceiling Function]]
		2. [[#Important Functions#Partial Functions|Partial Functions]]
	5. [[#Basic Structures#Cardinality|Cardinality]]
		1. [[#Cardinality#Intro|Intro]]
		2. [[#Cardinality#Countable Sets|Countable Sets]]
		3. [[#Cardinality#Uncountable Sets|Uncountable Sets]]
			1. [[#Uncountable Sets#Uncountable Functions|Uncountable Functions]]

# Basic Structures
## Sets
### Intro
Sets are used to group objects together. Often, but not always, the objects in a set have similar properties. For instance, all the students who are currently enrolled in your school make up a set. Likewise, all the students currently taking a course in discrete mathematics at any school make up a set.

The language of sets is a means to study such collections in an organized fashion. We now provide a definition of a set. This definition is an intuitive definition, which is not part of a formal theory of sets

> [!summary] Definition - Set
> A set is an unordered collection of distinct objects, called elements or members of the set. A set is said to contain its elements. We write a ∈ A to denote that a is an element of the set A. The notation a ∉ A denotes that a is not an element of the set A.

It is common for sets to be denoted using uppercase letters. Lowercase letters are usually used to denote elements of sets.

#### Roster Notation
There are several ways to describe a set. 
One way is to list all the members of a set.
We use a notation where all members of the set are listed between braces. For example, the notation {a, b, c, d} represents the set with the four elements a, b, c, and d. This way of describing a set is known as the ***roster method***.

>[!example]
The set 'V' of all vowels in the English alphabet can be written as V = {a, e, i, o, u}.  

>[!example]
The set 'O' of odd positive integers less than 10 can be expressed by O = {1, 3, 5, 7, 9}. 
Although sets are usually used to group together elements with common properties, there is nothing that prevents a set from having seemingly unrelated elements. 

>[!example]
For instance, {a, 2, Fred, New Jersey} is the set containing the four elements "a", "2", "Fred", and "New Jersey".

>[!example]
 Sometimes the roster method is used to describe a set without listing all its members.
The set of positive integers less than 100 can be denoted by {1, 2, 3, … , 99}. Where "..." ellipses are used when the general pattern of the elements is obvious.

#### Set Builder Notation
Another way to describe a set is to use ***set builder*** notation.
We characterize all elements in the set by stating the property or properties they must have to be members, and possibly a different source set these elements stem from.
We often use this type of notation to describe sets when it is impossible to list all the elements of the set.

The general form of this notation is {x ∣ x has property P} and is read “the set of all x (*in/from set S*) such that x has property P.”

>[!example]
 The set O of all odd positive integers less than 10.
O = {x ∣ x is an odd positive integer less than 10} or O = {x ∈ Z+ ∣ x is odd and x < 10}.

>[!example]
The set Q+ of all positive rational numbers
Q+ = {x ∈ R ∣ x = p q , for some positive integers p and q}.

These sets, each denoted using a boldface letter, play an important role in discrete mathematics:
- **N** = {0, 1, 2, 3, …}, the set of all natural numbers
	- These are the numbers you use for counting discrete objects (like "how many apples are there?"). They are the foundation of arithmetic.
- **Z** = {… ,−2,−1, 0, 1, 2, …}, the set of all integers
	- This set includes all natural numbers but also introduces their negatives. It expands counting to include "debt" or "values below zero." 
	- The symbol "Z" comes from the German word _Zahlen_, which means "numbers."
- **Z+** = {1, 2, 3, …}, the set of all positive integers
	- This set is essentially the Natural Numbers without the zero. These are strictly greater than zero. In many contexts, this is called the "Counting Numbers."
- **Q** = {p∕q ∣ p ∈ Z, q ∈ Z, and q ≠ 0}, the set of all rational numbers R, the set of all real numbers
	- These are numbers that can be written as a fraction (ratio) of two integers. 
	- The symbol Q comes from the Italian word _Quoziente_ (quotient). 
	- Since this includes all integers (e.g., 2 can be written as 2/1), the set of Integers is inside this set.
- **R**, The set of real numbers (used in the definition of Q)
	- This represents the entire number line. It includes every possible point that can be measured in physical space or represented as a magnitude.
		- **Rationals (Q):** Fractions and integers.
		- **Irrationals:** Numbers that _cannot_ be fractions. Their decimal expansions go on forever without repeating.
- **R+**, the set of all positive real numbers
	- This is every single number on the number line that is **strictly** greater than zero. It includes positive fractions, positive integers, and positive irrational numbers.
- **C**, the set of all complex numbers.
	- This is the broadest standard set of numbers. It includes all Real numbers plus "Imaginary" numbers. Real numbers miss solutions to certain equations (like x2=−1, because no real number squared equals a negative). To fix this, we invent the unit i (the imaginary unit), where i=−1​.

##### Summary Hierarchy
N ⊂ Z ⊂ Q ⊂ R ⊂ C
1. Z includes N (adds negatives).
2. Q includes Z (adds fractions/decimals).
3. R includes Q (adds irrational numbers like π).
4. C includes R (adds imaginary numbers like i).
### Venn Diagrams
Sets can be represented graphically using Venn diagrams.
In Venn diagrams the universal set U, which contains all the objects under consideration, is represented by a rectangle. (Note that the universal set varies depending on which objects are of interest.)

Inside this rectangle, circles or other geometrical figures are used to represent sets. Sometimes points are used to represent the particular elements of the set. 
Venn diagrams are often used to indicate the relationships between sets.

EXAMPLE A Venn diagram that represents V, the set of vowels in the English alphabet.
We draw a rectangle to indicate the universal set U, which is the set of the 26 letters of the English alphabet. Inside this rectangle we draw a circle to represent V. Inside this circle we indicate the elements of V with points.
![[Pasted image 20260205164227.png]]
### Subsets
It is common to encounter situations where the elements of one set are also the elements of a second set.
> [!summary] Definition - Subset
> The set A is a subset of B, and B is a superset of A, if and only if every element of A is also an element of B. We use the notation A ⊆ B to indicate that A is a subset of the set B. If, instead, we want to stress that B is a superset of A, we use the equivalent notation B ⊇ A. (So, A ⊆ B and B ⊇ A are equivalent statements.)

We see that A ⊆ B if and only if the quantification ∀x(x ∈ A → x ∈ B) is true.

To show that A is not a subset of B we need only find one element x ∈ A with x ∉ B. Such an x is a counterexample to the claim

> [!summary]
> - *Showing that A is a Subset of B* To show that A ⊆ B, show that if x belongs to A then x also belongs to B. 
> - *Showing that A is **Not** a Subset of B* To show that A ⊈ B, find a single x ∈ A such that x ∉ B.

>[!example]
The set of all odd positive integers less than 10 is a subset of the set of all positive integers less than 10. 

>[!example]
The set of rational numbers is a subset of the set of real numbers.

>[!example]
The set of all computer science majors at your school is a subset of the set of all students at your school.

> [!summary] Trivial Subsets Theorem
For every set S; (i) ∅ ⊆ S and (ii) S ⊆ S
>
>- **The Empty Set (∅⊆S):** By definition, the empty set has no elements. Therefore, it is impossible to find an element in the empty set that is _not_ in S. Thus, it is a subset of every set.
>- **Reflexivity (S⊆S):** Every set is a subset of itself. Every element in S is, by definition, inside S.
  >
>> [!summary]- Proof
>> **Statement:** For every set $S$, (i) $\emptyset \subseteq S$ and (ii) $S \subseteq S$.
>> ### Proof of (i): The Empty Set as a Subset of any Set
>> Let $S$ be a set. To show that $\emptyset \subseteq S$, we must show that $\forall x(x \in \emptyset \to x \in S)$ is true. Because the empty set contains no elements, it follows that $x \in \emptyset$ is always false. It follows that the conditional statement $x \in \emptyset \to x \in S$ is always true, because its hypothesis is always false and a conditional statement with a false hypothesis is true. Therefore, $\forall x(x \in \emptyset \to x \in S)$ is true. This completes the proof of (i). Note that this is an example of a vacuous proof. □
>>
>> ### Proof of (ii): Reflexivity
>> Let $S$ be a set. To show that $S \subseteq S$, we must show that $\forall x(x \in S \to x \in S)$ is true.
>> The statement $x \in S \to x \in S$ is of the form $P \to P$, which is a tautology (always true) regardless of whether $x$ is actually in $S$. Consequently, $\forall x(x \in S \to x \in S)$ is true. This completes the proof of (ii). □
>>

Venn diagrams can be used to illustrate that a set A is a subset of a set B. We draw the universal set U as a rectangle. Within this rectangle we draw a circle for B. Because A is a subset of B, we draw the circle for A within the circle for B.
![[Pasted image 20260205170720.png]]

A useful way to show that two sets have the same elements is to show that each set is a subset of the other. 
In other words, we can show that if A and B are sets with A ⊆ B and B ⊆ A, then A = B. 
That is, A = B if and only if ∀x(x ∈ A → x ∈ B) and ∀x(x ∈ B → x ∈ A) or equivalently if and only if ∀x(x ∈ A ↔ x ∈ B), which is what it means for the A and B to be equal.

> [!summary]
> *Showing Two Sets are Equal* To show that two sets A and B are equal, show that A ⊆ B and B ⊆ A.

>[!example]
Sets may have other sets as members/elements.
A = {∅, {a}, {b}, {a, b}} and B = {x ∣ x is a subset of the set {a, b}}
> Note that these two sets are equal, that is, A = B. Also note that {a} ∈ A, but a ∉ A.
### Size
> [!summary] Definition - Size of a Set
> Let S be a set. If there are exactly n distinct elements in S where n is a nonnegative integer, we say that S is a finite set and that n is the cardinality of S. The cardinality of S is denoted by |S|.
> 
> ***Remark***: The term cardinality comes from the common usage of the term cardinal number as the size of a finite set.

>[!example]
>Let A be the set of odd positive integers less than 10. Then |A| = 5.
>- Roster Notation
> 	A={1,3,5,7,9}
>- Set Builder Notation
> 	 A={x∈Z+∣ x is odd and x<10}

>[!example]
>Let S be the set of letters in the English alphabet. Then |S| = 26
>
>- Roster Notation
>	S={A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z}
>- Set Builder Notation
>	S={x ∣ x is a letter in the English alphabet}

>[!example]
>Because the null set has no elements, it follows that |∅| = 0.
>
>- Roster Notation
>	∅={}
>- Set Builder Notation
>	∅={x∈Z∣x=x}

>[!summary] Definition - Infinite
>A set is said to be infinite if it is not finite.
>	Finite being with a beginning and end.

>[!example]
>The set of positive integers Z+ is infinite. There will always be a bigger number x+1 than any arbitrary chosen number x.
### Power Sets
Many problems involve testing all combinations of elements of a set to see if they satisfy some property. To consider all such combinations of elements of a set S, we build a new set that has as its members all the subsets of S

>[!summary] Definition - Power Set
>Given a set S, the power set of S is the set of all subsets of the set S. The power set of S is denoted by (S).

>[!example]
>The power set ({0, 1, 2}) is the set of all subsets of {0, 1, 2}.
> Hence, Examples ({0, 1, 2}) = {∅, {0}, {1}, {2}, {0, 1}, {0, 2}, {1, 2}, {0, 1, 2}}.
> Note that the empty set and the set itself are members of this set of subsets.

>[!example]
>The empty set has exactly one subset, namely, itself. Consequently, (∅) = {∅}.
>The set {∅} has exactly two subsets, namely, ∅ and the set {∅} itself. Therefore, ({∅}) = {∅, {∅}}.

> [!summary] Power Set Theorem
> If a set $S$ has $n$ elements, then its power set $\mathcal{P}(S)$ has $2^n$ elements.
>
>> [!summary]+ **Proof:**
>> Let $S$ be a finite set with $|S| = n$. We can list the elements of $S$ as $S = \{s_1, s_2, \dots, s_n\}$.
>>
>> To form a subset $A \subseteq S$, we must make a binary decision (include or exclude) for each element $s_i$ in $S$:
>>
>> 1.  For $s_1$, there are $2$ possibilities: $s_1 \in A$ or $s_1 \notin A$.
>> 2.  For $s_2$, there are $2$ possibilities: $s_2 \in A$ or $s_2 \notin A$.
>> $\vdots$
>> n. For $s_n$, there are $2$ possibilities: $s_n \in A$ or $s_n \notin A$.
>>
>> By the Rule of Product (Fundamental Counting Principle), the total number of distinct subsets is the product of the number of choices for each element:
>>
>> $$
>> \underbrace{2 \times 2 \times \cdots \times 2}_{n \text{ times}} = 2^n
>> $$
>>
>> Since the power set $\mathcal{P}(S)$ is the set of all subsets of $S$, the number of elements in $\mathcal{P}(S)$ is $2^n$. Thus, $|\mathcal{P}(S)| = 2^n$. ∎
>
### Cartesian Products
The order of elements in a collection is often important. Because sets are unordered, a different structure is needed to represent ordered collections. 
This is provided by ordered n-tuples.

>[!summary] Definition - Ordered n-tuple
>The ordered n-tuple (a1, a2, … , an) is the ordered collection that has a1 as its first element, a2 as its second element, … , and an as its nth element.

We say that two ordered n-tuples are equal if and only if each corresponding pair of their elements is equal.
(a1, a2, … , an) = (b1, b2, … , bn) if and only if ai = bi , for i = 1, 2, … , n. In particular, ordered 2-tuples are called ordered pairs. The ordered pairs (a, b) and (c, d) are equal if and only if a = c and b = d. 
Note that (a, b) and (b, a) are not equal unless a = b.

>[!summary] Definition - Cartesian Product
>Let A and B be sets. The Cartesian product of A and B, denoted by A × B, is the set of all ordered pairs (a, b), where a ∈ A and b ∈ B. 
>Hence, A × B = {(a, b) ∣ a ∈ A ∧ b ∈ B}.

>[!example]
>Let A represent the set of all students at a university, and let B represent the set of all courses offered at the university.
>The Cartesian product A × B consists of all the ordered pairs of the form (a, b), where a is a student at the university and b is a course offered at the university.
>
>Observe that each subset of A × B represents one possible total enrollment configuration, and (A × B) represents all possible enrollment configurations.

>[!example]
>What is the Cartesian product of A = {1, 2} and B = {a, b, c}
>A × B = {(1, a), (1, b), (1, c), (2, a), (2, b), (2, c)}.
>Note that the Cartesian products A × B and B × A are not equal unless A = ∅ or B = ∅ (so that A × B = ∅) or A = B

>[!example]
>Show that the Cartesian product B × A is not equal to the Cartesian product A × B.
>B × A = {(a, 1), (a, 2), (b, 1), (b, 2), (c, 1), (c, 2)}.
>This is not equal to A × B.
>A × B = {(1, a), (1, b), (1, c), (2, a), (2, b), (2, c)}.

The Cartesian product of more than two sets can also be defined.
>[!summary] Definition - Cartesian Products of n Sets
>The Cartesian product of the sets A1, A2, … , An, denoted by A1 × A2 × ⋯ × An, is the set of ordered n-tuples (a1, a2, … , an), where ai belongs to Ai for i = 1, 2, … , n. 
>In other words, A1 × A2 × ⋯ × An = {(a1, a2, … , an) ∣ ai ∈ Ai for i = 1, 2, … , n}.

>[!example]
>What is the Cartesian product A × B × C, where A = {0, 1}, B = {1, 2}, and C = {0, 1, 2}?
>The Cartesian product A × B × C consists of all ordered triples (a, b, c), where a ∈ A, b ∈ B, and c ∈ C. 
>Hence, A × B × C = {(0, 1, 0), (0, 1, 1), (0, 1, 2), (0, 2, 0), (0, 2, 1), (0, 2, 2), (1, 1, 0), (1, 1, 1), (1, 1, 2), (1, 2, 0), (1, 2, 1), (1, 2, 2)}.
>Note that when A, B, and C are sets, (A × B) × C is not the same as A × B × C

We use the notation A2 to denote A × A, the Cartesian product of the set A with itself. Similarly, A3 = A × A × A, A4 = A × A × A × A, and so on. More generally, An = {(a1, a2, … , an) ∣ ai ∈ A for i = 1, 2, … , n}.

>[!example]
>Suppose that A = {1, 2}. It follows that A2 = {(1, 1), (1, 2), (2, 1), (2, 2)} and A3 = {(1, 1, 1), (1, 1, 2), (1, 2, 1), (1, 2, 2), (2, 1, 1), (2, 1, 2), (2, 2, 1), (2, 2, 2)}.
>A subset R of the Cartesian product A × B is called a relation from the set A to the set B. The elements of R are ordered pairs, where the first element belongs to A and the second to B. For example, R = {(a, 0), (a, 1), (a, 3), (b, 1), (b, 2), (c, 0), (c, 3)} is a relation from the set {a, b, c} to the set {0, 1, 2, 3}, and it is also a relation from the set {a, b, c, d, e} to the set {0, 1, 3, 4). (This illustrates that a relation need not contain a pair (x, y) for every element x of A.) A relation from a set A to itself is called a relation on A.

>[!example]
>What are the ordered pairs in the less than or equal to relation, which contains (a, b) if a ≤ b, on the set {0, 1, 2, 3}?
>The ordered pair (a, b) belongs to R if and only if both a and b belong to {0, 1, 2, 3} and a ≤ b. Consequently, R = {(0, 0), (0, 1), (0, 2), (0, 3), (1, 1), (1, 2), (1, 3), (2, 2), (2, 3), (3, 3)}.
### Set Notation w. Quantifiers
Sometimes we restrict the domain of a quantified statement explicitly by making use of a particular notation.

For example, ∀x ∈ S(P(x)) denotes the universal quantification of P(x) over all elements in the set S. In other words, ∀x ∈ S(P(x)) is shorthand for ∀x(x ∈ S → P(x)). 

Similarly, ∃x ∈ S(P(x)) denotes the existential quantification of P(x) over all elements in S. 
That is, ∃x ∈ S(P(x)) is shorthand for ∃x(x ∈ S ∧ P(x)).

>[!example]
> What do the statements ∀x ∈ R (x2 ≥ 0) and ∃x ∈ Z (x2 = 1) mean?
> The statement ∀x ∈ R(x2 ≥ 0) states that for every real number x, x2 ≥ 0. This statement can be expressed as “The square of every real number is nonnegative.” This is a true statement. The statement ∃x ∈ Z(x2 = 1) states that there exists an integer x such that x2 = 1. This statement can be expressed as “There is an integer whose square is 1.” This is also a true statement because x = 1 is such an integer (as is −1).

### Truth Sets and Quantifiers
>[!summary] Definition - Truth Set
Given a predicate P, and a domain D, we define the truth set of P to be the set of elements x in D for which P(x) is true. 
The truth set of P(x) is denoted by {x ∈ D ∣ P(x)}.

>[!example]
>What are the truth sets of the predicates P(x), Q(x), and R(x), where the domain is the set of integers and P(x) is “|x| = 1,” Q(x) is “x2 = 2,” and R(x) is “|x| = x.”
>The truth set of P, {x ∈ Z ∣ |x| = 1}, is the set of integers for which |x| = 1. Because |x| = 1 when x = 1 or x = −1, and for no other integers x, we see that the truth set of P is the set {−1, 1}. The truth set of Q, {x ∈ Z ∣ x2 = 2}, is the set of integers for which x2 = 2. This is the empty set because there are no integers x for which x2 = 2. The truth set of R, {x ∈ Z ∣ |x| = x}, is the set of integers for which |x| = x. Because |x| = x if and only if x ≥ 0, it follows that the truth set of R is N, the set of nonnegative integers.
>
>Note that ∀xP(x) is true over the domain U if and only if the truth set of P is the set U. Likewise, ∃xP(x) is true over the domain U if and only if the truth set of P is nonempty.
## Operations
### Intro
Two, or more, sets can be combined in many different ways.
Starting with the set of mathematics majors at your school and the set of computer science majors at your school, we can form the set of students who are mathematics majors or computer science majors, the set of students who are joint majors in mathematics and computer science, the set of all students not majoring in mathematics, and so on.

>[!summary] Definition - Union
>Let A and B be sets. The union of the sets A and B, denoted by A ∪ B, is the set that contains those elements that are either in A or in B, or in both.

An element x belongs to the union of the sets A and B if and only if x belongs to A or x belongs to B. This tells us that A ∪ B = {x ∣ x ∈ A ∨ x ∈ B}.

>[!example]
>The union of the sets {1, 3, 5} and {1, 2, 3} is the set {1, 2, 3, 5}; that is, {1, 3, 5}∪{1, 2, 3}={1, 2, 3, 5}.
> Note that each element in a set has to be unique, meaning ...

>[!example]
>The union of the set of all computer science majors at your school and the set of all mathematics majors at your school is the set of students at your school who are majoring either in mathematics or in computer science (or in both).

>[!summary] Definition - Intersection
>Let A and B be sets. The intersection of the sets A and B, denoted by A ∩ B, is the set containing those elements in both A and B.

An element x belongs to the intersection of the sets A and B if and only if x belongs to A and x belongs to B. This tells us that A ∩ B = {x ∣ x ∈ A ∧ x ∈ B}.

![[Pasted image 20260205175515.png]]

>[!example]
>The intersection of the sets {1, 3, 5} and {1, 2, 3} is the set {1, 3}; that is, {1, 3, 5}∩{1, 2, 3}={1, 3}.

>[!example]
>The intersection of the set of all computer science majors at your school and the set of all mathematics majors is the set of all students who are joint majors in mathematics and computer science

>[!summary] Definition - Disjointment
>Two sets are called disjoint if their intersection is the empty set.

>[!example]
>Let A = {1, 3, 5, 7, 9} and B = {2, 4, 6, 8, 10}. Because A ∩ B = ∅, A and B are disjoint.

We are often interested in finding the cardinality of a union of two finite sets A and B. Note that |A| + |B| counts each element that is in A but not in B or in B but not in A exactly once, and each element that is in both A and B exactly twice. Thus, if the number of elements that are in both A and B is subtracted from |A| + |B|, elements in A ∩ B will be counted only once. 
Hence, |A ∪ B| = |A| + |B| − |A ∩ B|.

The generalization of this result to unions of an arbitrary number of sets is called the principle of inclusion–exclusion. The principle of inclusion–exclusion is an important technique used in enumeration.

>[!summary] Definition - Diffrence
>Let A and B be sets. The difference of A and B, denoted by A − B, is the set containing those elements that are in A but not in B. The difference of A and B is also called the complement of B with respect to A.
>***Remark***: The difference of sets A and B is sometimes denoted by A∖B.

An element x belongs to the difference of A and B if and only if x ∈ A and x ∉ B. This tells us that A − B = {x ∣ x ∈ A ∧ x ∉ B}.

>[!example]
>The difference of {1, 3, 5} and {1, 2, 3} is the set {5}; that is, {1, 3, 5}−{1, 2, 3}={5}. This is different from the difference of {1, 2, 3} and {1, 3, 5}, which is the set {2}.

>[!example]
>The difference of the set of computer science majors at your school and the set of mathematics majors at your school is the set of all computer science majors at your school who are not also mathematics majors.

Once the universal set U has been specified, the complement of a set can be defined.
>[!summary] Definition - Complement
>Let U be the universal set. The complement of the set A, denoted by A, is the complement of A with respect to U. Therefore, the complement of the set A is U − A.
>***Remark***: The definition of the complement of A depends on a particular universal set U. This definition makes sense for any superset U of A. If we want to identify the universal set U, we would write “the complement of A with respect to the set U.”

An element belongs to A if and only if x ∉ A. This tells us that A = {x ∈ U ∣ x ∉ A}.

>[!example]
>Let A = {a, e, i, o, u} (where the universal set is the set of letters of the English alphabet). Then A = {b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z}.

>[!example]
>Let A be the set of positive integers greater than 10 (with universal set the set of all positive integers). Then A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}.

> [!abstract] Theorem: Set Difference as Intersection
> For any sets $A$ and $B$ (with a universal set $U$), the set difference $A - B$ is equal to the intersection of $A$ and the complement of $B$.
> $$ A - B = A \cap B^c $$
>
> > [!summary]- Proof
> > To prove that two sets are equal, we show that each is a subset of the other.
> >
> > **Part 1:** Show $A - B \subseteq A \cap B^c$.
> > Let $x \in A - B$.
> > By the definition of set difference, this means $x \in A$ and $x \notin B$.
> > Since $x \notin B$, by the definition of complement, $x \in B^c$.
> > Therefore, we have $x \in A$ and $x \in B^c$, which means $x \in A \cap B^c$.
> >
> > **Part 2:** Show $A \cap B^c \subseteq A - B$.
> > Let $x \in A \cap B^c$.
> > By the definition of intersection, this means $x \in A$ and $x \in B^c$.
> > Since $x \in B^c$, by the definition of complement, $x \notin B$.
> > Therefore, we have $x \in A$ and $x \notin B$, which means $x \in A - B$.
> >
> > **Conclusion:**
> > Since we have shown that $A - B \subseteq A \cap B^c$ and $A \cap B^c \subseteq A - B$, it follows that $A - B = A \cap B^c$. ∎

![[Pasted image 20260205180110.png]]
### Set Identities
| Identity Name | Identity |
| :--- | :--- |
| **Identity laws** | $A \cap U = A$ <br> $A \cup \emptyset = A$ |
| **Domination laws** | $A \cup U = U$ <br> $A \cap \emptyset = \emptyset$ |
| **Idempotent laws** | $A \cup A = A$ <br> $A \cap A = A$ |
| **Complementation law** | $\overline{(\overline{A})} = A$ |
| **Commutative laws** | $A \cup B = B \cup A$ <br> $A \cap B = B \cap A$ |
| **Associative laws** | $A \cup (B \cup C) = (A \cup B) \cup C$ <br> $A \cap (B \cap C) = (A \cap B) \cap C$ |
| **Distributive laws** | $A \cup (B \cap C) = (A \cup B) \cap (A \cup C)$ <br> $A \cap (B \cup C) = (A \cap B) \cup (A \cap C)$ |
| **De Morgan’s laws** | $\overline{A \cap B} = \overline{A} \cup \overline{B}$ <br> $\overline{A \cup B} = \overline{A} \cap \overline{B}$ |
| **Absorption laws** | $A \cup (A \cap B) = A$ <br> $A \cap (A \cup B) = A$ |
| **Complement laws** | $A \cup \overline{A} = U$ <br> $A \cap \overline{A} = \emptyset$ |

One way to show that two sets are equal is to show that each is a subset of the other
We generally use a direct proof to do this. We illustrate this type of proof by establishing the first of De Morgan’s laws.

> [!abstract] Theorem: De Morgan's Law for Sets
> For any sets $A$ and $B$, the complement of the intersection of $A$ and $B$ is equal to the union of the complement of $A$ and the complement of $B$.
> $$ \overline{A \cap B} = \overline{A} \cup \overline{B} $$
>
> > [!summary]- Proof
> > We will prove that the two sets $\overline{A \cap B}$ and $\overline{A} \cup \overline{B}$ are equal by showing that each set is a subset of the other.
> >
> > **Part 1:** Show that $\overline{A \cap B} \subseteq \overline{A} \cup \overline{B}$.
> > We do this by showing that if $x$ is in $\overline{A \cap B}$, then it must also be in $\overline{A} \cup \overline{B}$.
> > Now suppose that $x \in \overline{A \cap B}$. By the definition of complement, $x \notin A \cap B$. Using the definition of intersection, we see that the proposition $\neg((x \in A) \land (x \in B))$ is true. By applying De Morgan’s law for propositions, we see that $\neg(x \in A) \lor \neg(x \in B)$. Using the definition of negation of propositions, we have $x \notin A$ or $x \notin B$. Using the definition of the complement of a set, we see that this implies that $x \in \overline{A}$ or $x \in \overline{B}$. Consequently, by the definition of union, we see that $x \in \overline{A} \cup \overline{B}$. We have now shown that $\overline{A \cap B} \subseteq \overline{A} \cup \overline{B}$.
> >
> > **Part 2:** Show that $\overline{A} \cup \overline{B} \subseteq \overline{A \cap B}$.
> > We do this by showing that if $x$ is in $\overline{A} \cup \overline{B}$, then it must also be in $\overline{A \cap B}$.
> > Now suppose that $x \in \overline{A} \cup \overline{B}$. By the definition of union, we know that $x \in \overline{A}$ or $x \in \overline{B}$. Using the definition of complement, we see that $x \notin A$ or $x \notin B$. Consequently, the proposition $\neg(x \in A) \lor \neg(x \in B)$ is true.
> > By De Morgan’s law for propositions, we conclude that $\neg((x \in A) \land (x \in B))$ is true. By the definition of intersection, it follows that $\neg(x \in A \cap B)$. We now use the definition of complement to conclude that $x \in \overline{A \cap B}$. This shows that $\overline{A} \cup \overline{B} \subseteq \overline{A \cap B}$.
> >
> > **Conclusion:**
> > Because we have shown that each set is a subset of the other, the two sets are equal, and the identity is proved. ∎

> [!abstract] Theorem: First De Morgan Law (Algebraic Proof)
> Prove that $\overline{A \cap B} = \overline{A} \cup \overline{B}$ using set builder notation and logical equivalences.
>
> > [!summary]- Proof
> > We can prove this identity with the following steps:
> >
> > $$
> > \begin{aligned}
> > \overline{A \cap B} & = \{ x \mid x \notin A \cap B \} & \text{(by definition of complement)} \\
> > & = \{ x \mid \neg(x \in (A \cap B)) \} & \text{(by definition of does not belong symbol)} \\
> > & = \{ x \mid \neg(x \in A \land x \in B) \} & \text{(by definition of intersection)} \\
> > & = \{ x \mid \neg(x \in A) \lor \neg(x \in B) \} & \text{(by the first De Morgan law for logical equivalences)} \\
> > & = \{ x \mid x \notin A \lor x \notin B \} & \text{(by definition of does not belong symbol)} \\
> > & = \{ x \mid x \in \overline{A} \lor x \in \overline{B} \} & \text{(by definition of complement)} \\
> > & = \{ x \mid x \in \overline{A} \cup \overline{B} \} & \text{(by definition of union)} \\
> > & = \overline{A} \cup \overline{B} & \text{(by meaning of set builder notation)}
> > \end{aligned}
> > $$
> >
> > Thus, $\overline{A \cap B} = \overline{A} \cup \overline{B}$. ∎

> [!abstract] Theorem: Second Distributive Law for Sets
> For all sets $A$, $B$, and $C$, the intersection of $A$ with the union of $B$ and $C$ is equal to the union of the intersection of $A$ and $B$ and the intersection of $A$ and $C$.
> $$ A \cap (B \cup C) = (A \cap B) \cup (A \cap C) $$
>
> > [!summary]- Proof
> > We will prove this identity by showing that each side is a subset of the other side.
> >
> > **Part 1:** Show that $A \cap (B \cup C) \subseteq (A \cap B) \cup (A \cap C)$.
> > Suppose that $x \in A \cap (B \cup C)$. Then $x \in A$ and $x \in B \cup C$. By the definition of union, it follows that $x \in A$, and $x \in B$ or $x \in C$ (or both). In other words, we know that the compound proposition $(x \in A) \land ((x \in B) \lor (x \in C))$ is true. By the distributive law for conjunction over disjunction, it follows that $((x \in A) \land (x \in B)) \lor ((x \in A) \land (x \in C))$. We conclude that either $x \in A$ and $x \in B$, or $x \in A$ and $x \in C$. By the definition of intersection, it follows that $x \in A \cap B$ or $x \in A \cap C$. Using the definition of union, we conclude that $x \in (A \cap B) \cup (A \cap C)$. We conclude that $A \cap (B \cup C) \subseteq (A \cap B) \cup (A \cap C)$.
> >
> > **Part 2:** Show that $(A \cap B) \cup (A \cap C) \subseteq A \cap (B \cup C)$.
> > Now suppose that $x \in (A \cap B) \cup (A \cap C)$. Then, by the definition of union, $x \in A \cap B$ or $x \in A \cap C$. By the definition of intersection, it follows that $x \in A$ and $x \in B$ or that $x \in A$ and $x \in C$. From this we see that $x \in A$, and $x \in B$ or $x \in C$. Consequently, by the definition of union we see that $x \in A$ and $x \in B \cup C$. Furthermore, by the definition of intersection, it follows that $x \in A \cap (B \cup C)$. We conclude that $(A \cap B) \cup (A \cap C) \subseteq A \cap (B \cup C)$.
> >
> > **Conclusion:**
> > Since we have shown that each set is a subset of the other, the identity is proved. ∎

Here are the proofs formatted for Obsidian Markdown. You can copy and paste the entire block below directly into a note.


> [!abstract] Theorem: Identity Laws
> **Statement:** For any set $A$ and universal set $U$:
> 1. $A \cap U = A$
> 2. $A \cup \emptyset = A$
>
> > [!summary]- Proof
> > **1. Proof that $A \cap U = A$**:
> > We show that $A \cap U \subseteq A$ and $A \subseteq A \cap U$.
> > *   ($\subseteq$): If $x \in A \cap U$, then $x \in A$ and $x \in U$. Specifically, $x \in A$. Thus, $A \cap U \subseteq A$.
> > *   ($\supseteq$): If $x \in A$, then since $U$ contains all elements, $x \in U$ as well. Thus, $x \in A$ and $x \in U$, so $x \in A \cap U$. Hence, $A \subseteq A \cap U$.
> >
> > **2. Proof that $A \cup \emptyset = A$**:
> > We show that $A \cup \emptyset \subseteq A$ and $A \subseteq A \cup \emptyset$.
> > *   ($\subseteq$): If $x \in A \cup \emptyset$, then $x \in A$ or $x \in \emptyset$. Since $\emptyset$ has no elements, it must be that $x \in A$. Thus, $A \cup \emptyset \subseteq A$.
> > *   ($\supseteq$): If $x \in A$, then $x \in A$ or $x \in \emptyset$ is true (disjunction introduction). Thus, $x \in A \cup \emptyset$. Hence, $A \subseteq A \cup \emptyset$. ∎

> [!abstract] Theorem: Domination Laws
> **Statement:** For any set $A$ and universal set $U$:
> 1. $A \cup U = U$
> 2. $A \cap \emptyset = \emptyset$
>
> > [!summary]- Proof
> > **1. Proof that $A \cup U = U$**:
> > *   ($\subseteq$): If $x \in A \cup U$, then $x \in A$ or $x \in U$. Since $U$ is the universal set, if $x \in A$, then $x \in U$ automatically. In both cases, $x \in U$. Thus, $A \cup U \subseteq U$.
> > *   ($\supseteq$): If $x \in U$, then $x \in U$ or $x \in A$ is true. Thus, $x \in A \cup U$. Hence, $U \subseteq A \cup U$.
> >
> > **2. Proof that $A \cap \emptyset = \emptyset$**:
> > We prove this by showing that no element $x$ can belong to $A \cap \emptyset$.
> > Suppose, for contradiction, that there exists an $x \in A \cap \emptyset$. By definition of intersection, $x \in A$ and $x \in \emptyset$. However, $\emptyset$ has no elements, so $x \in \emptyset$ is impossible. Thus, no such $x$ exists, and $A \cap \emptyset$ must be empty. Therefore, $A \cap \emptyset = \emptyset$. ∎

> [!abstract] Theorem: Idempotent Laws
> **Statement:** For any set $A$:
> 1. $A \cup A = A$
> 2. $A \cap A = A$
>
> > [!summary]- Proof
> > **1. Proof that $A \cup A = A$**:
> > *   ($\subseteq$): If $x \in A \cup A$, then $x \in A$ or $x \in A$. This simplifies to $x \in A$. Thus, $A \cup A \subseteq A$.
> > *   ($\supseteq$): If $x \in A$, then $x \in A$ or $x \in A$. Thus, $x \in A \cup A$. Hence, $A \subseteq A \cup A$.
> >
> > **2. Proof that $A \cap A = A$**:
> > *   ($\subseteq$): If $x \in A \cap A$, then $x \in A$ and $x \in A$. This simplifies to $x \in A$. Thus, $A \cap A \subseteq A$.
> > *   ($\supseteq$): If $x \in A$, then $x \in A$ and $x \in A$. Thus, $x \in A \cap A$. Hence, $A \subseteq A \cap A$. ∎

> [!abstract] Theorem: Complementation Law
> **Statement:** For any set $A$:
> $$ \overline{\overline{A}} = A $$
>
> > [!summary]- Proof
> > We show that $\overline{\overline{A}} \subseteq A$ and $A \subseteq \overline{\overline{A}}$.
> > *   ($\subseteq$): Let $x \in \overline{\overline{A}}$. By definition of complement, $x \notin \overline{A}$. Since $\overline{A}$ is the set of elements not in $A$, the fact that $x$ is *not* in the set of elements "not in $A$" implies that $x$ must be in $A$. Thus, $\overline{\overline{A}} \subseteq A$.
> > *   ($\supseteq$): Let $x \in A$. Then $x \notin \overline{A}$. By definition of complement, since $x$ is not in $\overline{A}$, $x$ must be in the complement of $\overline{A}$, which is $\overline{\overline{A}}$. Thus, $A \subseteq \overline{\overline{A}}$. ∎

> [!abstract] Theorem: Absorption Laws
> **Statement:** For any sets $A$ and $B$:
> 1. $A \cup (A \cap B) = A$
> 2. $A \cap (A \cup B) = A$
>
> > [!summary]- Proof
> > **1. Proof that $A \cup (A \cap B) = A$**:
> > *   ($\subseteq$): If $x \in A \cup (A \cap B)$, then $x \in A$ or $x \in (A \cap B)$. If $x \in A$, we are done. If $x \in A \cap B$, then $x \in A$. In either case, $x \in A$. Thus, $A \cup (A \cap B) \subseteq A$.
> > *   ($\supseteq$): If $x \in A$, then $x \in A$ or $x \in (A \cap B)$ is true (since the first disjunct is true). Thus, $x \in A \cup (A \cap B)$. Hence, $A \subseteq A \cup (A \cap B)$.
> >
> > **2. Proof that $A \cap (A \cup B) = A$**:
> > *   ($\subseteq$): If $x \in A \cap (A \cup B)$, then $x \in A$ and $x \in A \cup B$. Specifically, $x \in A$. Thus, $A \cap (A \cup B) \subseteq A$.
> > *   ($\supseteq$): If $x \in A$, then $x \in A$ and ($x \in A$ or $x \in B$) is true. By the definition of union, $x \in A \cup B$. Thus, $x \in A$ and $x \in A \cup B$, so $x \in A \cap (A \cup B)$. Hence, $A \subseteq A \cap (A \cup B)$. ∎

> [!abstract] Theorem: Complement Laws
> **Statement:** For any set $A$ and universal set $U$:
> 1. $A \cup \overline{A} = U$
> 2. $A \cap \overline{A} = \emptyset$
>
> > [!summary]- Proof
> > **1. Proof that $A \cup \overline{A} = U$**:
> > *   ($\subseteq$): If $x \in A \cup \overline{A}$, then $x \in A$ or $x \in \overline{A}$. Since $\overline{A} \subseteq U$ and $A \subseteq U$, in either case $x \in U$. Thus, $A \cup \overline{A} \subseteq U$.
> > *   ($\supseteq$): Let $x \in U$. By the law of excluded middle, either $x \in A$ or $x \notin A$. If $x \notin A$, then $x \in \overline{A}$. Thus, $x \in A$ or $x \in \overline{A}$, which means $x \in A \cup \overline{A}$. Hence, $U \subseteq A \cup \overline{A}$.
> >
> > **2. Proof that $A \cap \overline{A} = \emptyset$**:
> > Suppose for contradiction that there exists an element $x \in A \cap \overline{A}$.
> > By definition of intersection, $x \in A$ and $x \in \overline{A}$.
> > By definition of complement, $x \in \overline{A}$ implies $x \notin A$.
> > This leads to the contradiction $x \in A$ and $x \notin A$.
> > Therefore, no such $x$ exists, and $A \cap \overline{A} = \emptyset$. ∎
### Generalized Unions & Intersections
Because unions and intersections of sets satisfy associative laws, the sets A ∪ B ∪ C and A ∩ B ∩ C are well defined; that is, the meaning of this notation is unambiguous when A, B, and C are sets. That is, we do not have to use parentheses to indicate which operation comes first because A ∪ (B ∪ C) = (A ∪ B) ∪ C and A ∩ (B ∩ C) = (A ∩ B) ∩ C. 
Note that A ∪ B ∪ C contains those elements that are in at least one of the sets A, B, and C, and that A ∩ B ∩ C contains those elements that are in all of A, B, and C.

>[!example]
>Let A = {0, 2, 4, 6, 8}, B = {0, 1, 2, 3, 4}, and C = {0, 3, 6, 9}. What are A ∪ B ∪ C and A ∩ B ∩ C?
>The set A ∪ B ∪ C contains those elements in at least one of A, B, and C. Hence, A ∪ B ∪ C = {0, 1, 2, 3, 4, 6, 8, 9}. The set A ∩ B ∩ C contains those elements in all three of A, B, and C. Thus, A ∩ B ∩ C = {0}.

We can also consider unions and intersections of an arbitrary number of sets.
>[!summary] Definition - Union on n sets
>The union of a collection of sets is the set that contains those elements that are members of at least one set in the collection.

We use the notation A1 ∪ A2 ∪ ⋯ ∪ An = ⋃n i=1 Ai to denote the union of the sets A1, A2, … , An

>[!summary] Definition - Intersection on n sets
>The intersection of a collection of sets is the set that contains those elements that are members of all the sets in the collection.

![[Pasted image 20260205191246.png]]

We use the notation A1 ∩ A2 ∩ ⋯ ∩ An = ⋂n i=1 Ai to denote the intersection of the sets A1, A2, … , An.

>[!example]
>For i = 1, 2, …, let Ai = {i, i + 1, i + 2, … }. Then, ⋃n i=1 Ai = ⋃n i=1 {i, i + 1, i + 2, …}={1, 2, 3, … }, and ⋂n i=1 Ai = ⋂n i=1 {i, i + 1, i + 2, …}={n, n + 1, n + 2, …}= An.

We can extend the notation we have introduced for unions and intersections to other families of sets. In particular, to denote the union of the infinite family of sets A1, A2, … , An, …, we use the notation A1 ∪ A2 ∪ ⋯ ∪ An ∪ ⋯ = ⋃∞ i=1 Ai . Similarly, the intersection of these sets is denoted by A1 ∩ A2 ∩ ⋯ ∩ An ∩ ⋯ = ⋂∞ i=1 Ai . More generally, when I is a set, the notations ⋂ i∈I Ai and ⋃ i∈I Ai are used to denote the intersection and union of the sets Ai for i ∈ I, respectively. Note that we have ⋂ i∈I Ai = {x ∣ ∀i ∈ I (x ∈ Ai )} and ⋃ i∈I Ai = {x ∣ ∃i ∈ I (x ∈ Ai )}.

>[!example]
>Suppose that Ai = {1, 2, 3, … , i} for i = 1, 2, 3, … . Then, ⋃∞ i=1 Ai = ⋃∞ i=1 {1, 2, 3, … , i}={1, 2, 3, …} = Z+ and ⋂∞ i=1 Ai = ⋂∞ i=1 {1, 2, 3, … , i}={1}. 
>To see that the union of these sets is the set of positive integers, note that every positive integer n is in at least one of the sets, because it belongs to An = {1, 2, … , n}, and every element of the sets in the union is a positive integer. 
>To see that the intersection of these sets is the set {1}, note that the only element that belongs to all the sets A1, A2, … is 1. To see this note that A1 = {1} and 1 ∈ Ai for i = 1, 2, … .
### Computer Representation of Sets
There are various ways to represent sets using a computer. One method is to store the elements of the set in an unordered fashion. However, if this is done, the operations of computing the union, intersection, or difference of two sets would be time consuming, because each of these operations would require a large amount of searching for elements

Assume that the universal set U is finite (and of reasonable size so that the number of elements of U is not larger than the memory size of the computer being used). First, specify an arbitrary ordering of the elements of U, for instance a1, a2, … , an. Represent a subset A of U with the bit string of length n, where the ith bit in this string is 1 if ai belongs to A and is 0 if ai does not belong to A.

>[!example]
>Let U = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, and the ordering of elements of U has the elements in increasing order; that is, ai = i. What bit strings represent the subset of all odd integers in U, the subset of all even integers in U, and the subset of integers not exceeding 5 in U?
>The bit string that represents the set of odd integers in U, namely, {1, 3, 5, 7, 9}, has a one bit in the first, third, fifth, seventh, and ninth positions, and a zero elsewhere. It is 10 1010 1010. (We have split this bit string of length ten into blocks of length four for easy reading.) Similarly, we represent the subset of all even integers in U, namely, {2, 4, 6, 8, 10}, by the string 01 0101 0101. The set of all integers in U that do not exceed 5, namely, {1, 2, 3, 4, 5}, is represented by the string 11 1110 0000.
>Using bit strings to represent sets, it is easy to find complements of sets and unions, intersections, and differences of sets. To find the bit string for the complement of a set from the bit string for that set, we simply change each 1 to a 0 and each 0 to 1, because x ∈ A if and only if x ∉ A. Note that this operation corresponds to taking the negation of each bit when we associate a bit with a truth value—with 1 representing true and 0 representing false.

>[!example]
>We have seen that the bit string for the set {1, 3, 5, 7, 9} (with universal set {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}) is 10 1010 1010. What is the bit string for the complement of this set?
>The bit string for the complement of this set is obtained by replacing 0s with 1s and vice versa. This yields the string 01 0101 0101, which corresponds to the set {2, 4, 6, 8, 10}. ◂ To obtain the bit string for the union and intersection of two sets we perform bitwise Boolean operations on the bit strings representing the two sets. The bit in the ith position of the bit string of the union is 1 if either of the bits in the ith position in the two strings is 1 (or both are 1), and is 0 when both bits are 0. Hence, the bit string for the union is the bitwise OR of the bit strings for the two sets. The bit in the ith position of the bit string of the intersection is 1 when the bits in the corresponding position in the two strings are both 1, and is 0 when either of the two bits is 0 (or both are). Hence, the bit string for the intersection is the bitwise AND of the bit strings for the two sets.

>[!example]
>The bit strings for the sets {1, 2, 3, 4, 5} and {1, 3, 5, 7, 9} are 11 1110 0000 and 10 1010 1010, respectively. Use bit strings to find the union and intersection of these sets.
>The bit string for the union of these sets is 11 1110 0000 ∨ 10 1010 1010 = 11 1110 1010, which corresponds to the set {1, 2, 3, 4, 5, 7, 9}. The bit string for the intersection of these sets is 11 1110 0000 ∧ 10 1010 1010 = 10 1010 0000, which corresponds to the set {1, 3, 5}.
### Multi-sets
>[!summary] Definition - Multiset
>A multiset (short for multiple-membership set) is an unordered collection of elements where an element can occur as a member more than once

Sometimes the number of times that an element occurs in an unordered collection matters.
We can use the same notation for a multiset as we do for a set, but each element is listed the number of times it occurs. So, the multiset denoted by {a, a, a, b, b} is the multiset that contains the element a thrice and the element b twice. When we use this notation, it must be clear that we are working with multisets and not ordinary sets. We can avoid this ambiguity by using an alternate notation for multisets. The notation {m1 ⋅ a1, m2 ⋅ a2, … , mr ⋅ ar} denotes the multiset with element a1 occurring m1 times, element a2 occurring m2 times, and so on. The numbers mi , i = 1, 2, … , r, are called the multiplicities of the elements ai , i = 1, 2, … , r.
The cardinality of a multiset is defined to be the sum of the multiplicities of its elements.

Let P and Q be multisets. The union of the multisets P and Q is the multiset in which the multiplicity of an element is the maximum of its multiplicities in P and Q. The intersection of P and Q is the multiset in which the multiplicity of an element is the minimum of its multiplicities in P and Q. The difference of P and Q is the multiset in which the multiplicity of an element is the multiplicity of the element in P less its multiplicity in Q unless this difference is negative, in which case the multiplicity is 0. The sum of P and Q is the multiset in which the multiplicity of an element is the sum of multiplicities in P and Q. The union, intersection, and difference of P and Q are denoted by P ∪ Q, P ∩ Q, and P − Q, respectively (where these operations should not be confused with the analogous operations for sets). The sum of P and Q is denoted by P + Q.

>[!example]
>Suppose that P and Q are the multisets {4 ⋅ a, 1 ⋅ b, 3 ⋅ c} and {3 ⋅ a, 4 ⋅ b, 2 ⋅ d}, respectively. Find P ∪ Q, P ∩ Q, P − Q, and P + Q.
>We have P ∪ Q = {max(4, 3) ⋅ a, max(1, 4) ⋅ b, max(3, 0) ⋅ c, max(0, 2) ⋅ d} = {4 ⋅ a, 4 ⋅ b, 3 ⋅ c, 2 ⋅ d}, P ∩ Q = {min(4, 3) ⋅ a, min(1, 4) ⋅ b, min(3, 0) ⋅ c, min(0, 2) ⋅ d} = {3 ⋅ a, 1 ⋅ b, 0 ⋅ c, 0 ⋅ d}={3 ⋅ a, 1 ⋅ b}, P − Q = {max(4 − 3, 0) ⋅ a, max(1 − 4, 0) ⋅ b, max(3 − 0, 0) ⋅ c, max(0 − 2, 0) ⋅ d} = {1 ⋅ a, 0 ⋅ b, 3 ⋅ c, 0 ⋅ d}={1 ⋅ a, 3 ⋅ c}, and P + Q = {(4 + 3) ⋅ a, (1 + 4) ⋅ b, (3 + 0) ⋅ c, (0 + 2) ⋅ d} = {7 ⋅ a, 5 ⋅ b, 3 ⋅ c, 2 ⋅ d}.
## Functions
### Intro
In many instances we assign to each element of a set a particular element of a second set (which may be the same as the first). For example, suppose that each student in a discrete mathematics class is assigned a letter grade from the set {A, B, C, D, F}. And suppose that the grades are A for Adams, C for Chou, B for Goodfriend, A for Rodriguez, and F for Stevens.

The concept of a function is extremely important in mathematics and computer science. 
For example, in discrete mathematics functions are used in the definition of such discrete structures as sequences and strings. 
Functions are also used to represent how long it takes a computer to solve problems of a given size. Many computer programs and subroutines are designed to calculate values of functions. Recursive functions, which are functions defined in terms of themselves, are used throughout computer science.

>[!summary] Definition - Function f
>Let A and B be nonempty sets. A function f from A to B is an assignment of exactly one element of B to each element of A. We write f(a) = b if b is the unique element of B assigned by the function f to the element a of A. If f is a function from A to B, we write f : A → B
>Remark: Functions (in sets) are sometimes also called mappings or transformations.

Functions are specified in many different ways. Sometimes we explicitly state the assignments.
Often we give a formula, such as f(x) = x + 1, to define a function. 
Other times we use a computer program to specify a function.

A function f : A → B can also be defined in terms of a relation from A to B. A relation from A to B is just a subset of A × B. A relation from A to B that contains one, and only one, ordered pair (a, b) for every element a ∈ A, defines a function f from A to B. This function is defined by the assignment f(a) = b, where (a, b) is the unique ordered pair in the relation that has a as its first element.

![[Pasted image 20260205191850.png]]

![[Pasted image 20260205191905.png]]

![[Pasted image 20260205193143.png]]

>[!summary] Definition - Image, Domain, Co-Domain
>If f is a function from A to B, we say that A is the domain of f and B is the codomain of f. If f(a) = b, we say that b is the image of a and a is a preimage of b. The range, or image, of f is the set of all images of elements of A. Also, if f is a function from A to B, we say that f maps A to B.
>Remark: Note that the codomain of a function from A to B is the set of all possible values of such a function (that is, all elements of B), and the range is the set of all values of f(a) for a ∈ A, and is always a subset of the codomain. That is, the codomain is the set of possible values of the function and the range is the set of all elements of the codomain that are achieved as the value of f for at least one element of the domain.

>[!example]
>What are the domain, codomain, and range of the function that assigns grades to students described.
>Let G be the function that assigns a grade to a student in our discrete mathematics class. Note that G(Adams) = A, for instance. The domain of G is the set {Adams, Chou, Goodfriend, Rodriguez, Stevens}, and the codomain is the set {A, B, C, D, F}. The range of G is the set {A, B, C, F}, because each grade except D is assigned to some student.

>[!example]
>Let R be the relation with ordered pairs (Abdul, 22), (Brenda, 24), (Carla, 21), (Desire, 22), (Eddie, 24), and (Felicia, 22). Here each pair consists of a graduate student and this student’s age. Specify a function determined by this relation
>If f is a function specified by R, then f(Abdul ) = 22, f(Brenda) = 24, f(Carla) = 21, f(Desire) = 22, f(Eddie) = 24, and f(Felicia) = 22. (Here, f(x) is the age of x, where x is a student.) For the domain, we take the set {Abdul, Brenda, Carla, Desire, Eddie, Felicia}. We also need to specify a codomain, which needs to contain all possible ages of students. Because it is highly likely that all students are less than 100 years old, we can take the set of positive integers less than 100 as the codomain. 
>(Note that we could choose a different codomain, such as the set of all positive integers or the set of positive integers between 10 and 90, but that would change the function. Using this codomain will also allow us to extend the function by adding the names and ages of more students later.) The range of the function we have specified is the set of different ages of these students, which is the set {21, 22, 24}.

>[!example]
>Let f be the function that assigns the last two bits of a bit string of length 2 or greater to that string. For example, f(11010) = 10. Then, the domain of f is the set of all bit strings of length 2 or greater, and both the codomain and range are the set {00, 01, 10, 11}.
>

>[!example]
>Let f : Z → Z assign the square of an integer to this integer. Then, f(x) = x2, where the domain of f is the set of all integers, the codomain of f is the set of all integers, and the range of f is the set of all integers that are perfect squares, namely, {0, 1, 4, 9, … }.

>[!example]
>The domain and codomain of functions are often specified in programming languages. For instance, the Java statement int floor(float real){…} and the C++ function statement int function (float x){…} both tell us that the domain of the floor function is the set of real numbers (represented by floating point numbers) and its codomain is the set of integers

A function is called real-valued if its codomain is the set of real numbers, and it is called integer-valued if its codomain is the set of integers. Two real-valued functions or two integervalued functions with the same domain can be added, as well as multiplied.

>[!summary] Definition
>Let f1 and f2 be functions from A to R. Then f1 + f2 and f1 f2 are also functions from A to R defined for all x ∈ A by ( f1 + f2)(x) = f1(x) + f2(x), ( f1f2)(x) = f1(x)f2(x).
>Note that the functions f1 + f2 and f1 f2 have been defined by specifying their values at x in terms of the values of f1 and f2 at x.

>[!example]
>Let f1 and f2 be functions from R to R such that f1(x) = x2 and f2(x) = x − x2. What are the functions f1 + f2 and f1 f2?
>From the definition of the sum and product of functions, it follows that ( f1 + f2)(x) = f1(x) + f2(x) = x2 + (x − x2 ) = x and ( f1 f2)(x) = x2 (x − x2 ) = x3 − x4.

When f is a function from A to B, the image of a subset of A can also be defined.

>[!summary] Definition - 
>Let f be a function from A to B and let S be a subset of A. The image of S under the function f is the subset of B that consists of the images of the elements of S. We denote the image of S by f(S), so f(S) = {t ∣ ∃s∈S (t = f(s))}. 
>We also use the shorthand {f(s) ∣ s ∈ S} to denote this set.
>Remark: The notation f(S) for the image of the set S under the function f is potentially ambiguous. Here, f(S) denotes a set, and not the value of the function f for the set S.

>[!example]
>Let A = {a, b, c, d, e} and B = {1, 2, 3, 4} with f(a) = 2, f(b) = 1, f(c) = 4, f(d) = 1, and f(e) = 1. The image of the subset S = {b, c, d} is the set f(S) = {1, 4}.
### 1-to-1 and "Onto" Functions
Some functions never assign the same value to two different domain elements. These functions are said to be one-to-one.

>[!summary] Definition - Injection
>A function f is said to be one-to-one, or an injection, if and only if f(a) = f(b) implies that a = b for all a and b in the domain of f. A function is said to be injective if it is one-to-one.
>Note that a function f is one-to-one if and only if f(a) ≠ f(b) whenever a ≠ b. This way of expressing that f is one-to-one is obtained by taking the contrapositive of the implication in the definition. 
>Remark: We can express that f is one-to-one using quantifiers as ∀a∀b( f(a) = f(b) → a = b) or equivalently ∀a∀b(a ≠ b → f(a) ≠ f(b)), where the universe of discourse is the domain of the function.

![[Pasted image 20260205192646.png]]

>[!example]
>Determine whether the function f from {a, b, c, d} to {1, 2, 3, 4, 5} with f(a) = 4, f(b) = 5, f(c) = 1, and f(d) = 3 is one-to-one.
>The function f is one-to-one because f takes on different values at the four elements of its domain.

>[!example]
>Determine whether the function f(x) = x2 from the set of integers to the set of integers is oneto-one
>The function f(x) = x2 is not one-to-one because, for instance, f(1) = f(−1) = 1, but 1 ≠ −1.
>Remark: The function f(x) = x2 with domain Z+ is one-to-one. (See the explanation in Example 12 to see why.) This is a different function from the function in Example 9 because of the difference in their domains.

>[!example]
>Determine whether the function f(x) = x + 1 from the set of real numbers to itself is one-to-one.
>Suppose that x and y are real numbers with f(x) = f(y), so that x + 1 = y + 1. This means that x = y. Hence, f(x) = x + 1 is a one-to-one function from R to R.

>[!example]
>Suppose that each worker in a group of employees is assigned a job from a set of possible jobs, each to be done by a single worker. In this situation, the function f that assigns a job to each worker is one-to-one. To see this, note that if x and y are two different workers, then f(x) ≠ f(y) because the two workers x and y must be assigned different jobs.

>[!summary] Definition -
>A function f whose domain and codomain are subsets of the set of real numbers is called increasing if f(x) ≤ f(y), and strictly increasing if f(x) < f(y), whenever x < y and x and y are in the domain of f. Similarly, f is called decreasing if f(x) ≥ f(y), and strictly decreasing if f(x) > f(y), whenever x < y and x and y are in the domain of f. (The word strictly in this definition indicates a strict inequality.)
>Remark: A function f is increasing if ∀x∀y(x < y → f(x) ≤ f(y)), strictly increasing if ∀x∀y(x < y → f(x) < f(y)), decreasing if ∀x∀y(x < y → f(x) ≥ f(y)), and strictly decreasing if ∀x∀y(x < y → f(x) > f(y)), where the universe of discourse is the domain of f

>[!example]
>The function f(x) = x2 from R+ to R+ is strictly increasing. To see this, suppose that x and y are positive real numbers with x < y. Multiplying both sides of this inequality by x gives x2 < xy. Similarly, multiplying both sides by y gives xy < y2. Hence, f(x) = x2 < xy < y2 = f(y). However, the function f(x) = x2 from R to the set of nonnegative real numbers is not strictly increasing because −1 < 0, but f(−1) = (−1)2 = 1 is not less than f(0) = 02 = 0.

For some functions the range and the codomain are equal. That is, every member of the codomain is the image of some element of the domain. Functions with this property are called onto functions.

>[!summary] Definition - Surjection
>A function f from A to B is called onto, or a surjection, if and only if for every element b ∈ B there is an element a ∈ A with f(a) = b. A function f is called surjective if it is onto. 
>Remark: A function f is onto if ∀y∃x( f(x) = y), where the domain for x is the domain of the function and the domain for y is the codomain of the function.

![[Pasted image 20260205192907.png]]

>[!example]
>Let f be the function from {a, b, c, d} to {1, 2, 3} defined by f(a) = 3, f(b) = 2, f(c) = 1, and f(d) = 3. Is f an onto function?
>Because all three elements of the codomain are images of elements in the domain, we see that f is onto

>[!example]
>Is the function f(x) = x2 from the set of integers to the set of integers onto?
>The function f is not onto because there is no integer x with x2 = −1, for instance

>[!example]
>Is the function f(x) = x + 1 from the set of integers to the set of integers onto?
>This function is onto, because for every integer y there is an integer x such that f(x) = y. To see this, note that f(x) = y if and only if x + 1 = y, which holds if and only if x = y − 1. (Note that y − 1 is also an integer, and so, is in the domain of f .)

>[!example]
>Consider the function f in Example 11 that assigns jobs to workers. The function f is onto if for every job there is a worker assigned this job. The function f is not onto when there is at least one job that has no worker assigned it.

>[!summary] Definition - Bijection
>The function f is a one-to-one correspondence, or a bijection, if it is both one-to-one and onto. We also say that such a function is bijective.

>[!example]
>Let f be the function from {a, b, c, d} to {1, 2, 3, 4} with f(a) = 4, f(b) = 2, f(c) = 1, and f(d) = 3. Is f a bijection?
>The function f is one-to-one and onto. It is one-to-one because no two values in the domain are assigned the same function value. It is onto because all four elements of the codomain are images of elements in the domain. Hence, f is a bijection.

>[!example]
>Let A be a set. The identity function on A is the function 𝜄 A : A → A, where 𝜄 A(x) = x for all x ∈ A. In other words, the identity function 𝜄 A is the function that assigns each element to itself. The function 𝜄A is one-to-one and onto, so it is a bijection. (Note that 𝜄 is the Greek letter iota.)

>[!summary]
>Suppose that f : A → B. 
>*To show that f is injective* Show that if f(x) = f(y) for arbitrary x, y ∈ A, then x = y. 
>*To show that f is not injective* Find particular elements x, y ∈ A such that x ≠ y and f(x) = f(y). 
>*To show that f is surjective* Consider an arbitrary element y ∈ B and find an element x ∈ A such that f(x) = y. 
>*To show that f is not surjective* Find a particular y ∈ B such that f(x) ≠ y for all x ∈ A.
### Inverse Functions and Compositions of Functions
Consider a one-to-one correspondence f from the set A to the set B. Because f is an onto function, every element of B is the image of some element in A. Furthermore, because f is also a one-to-one function, every element of B is the image of a unique element of A. Consequently, we can define a new function from B to A that reverses the correspondence given by f .

>[!summary] Definition - Inverse Function
>Let f be a one-to-one correspondence from the set A to the set B. The inverse function of f is the function that assigns to an element b belonging to B the unique element a in A such that f(a) = b. The inverse function of f is denoted by f −1. Hence, f −1(b) = a when f(a) = b.
>Remark: Be sure not to confuse the function f −1 with the function 1∕f , which is the function that assigns to each x in the domain the value 1∕f(x). Notice that the latter makes sense only when f(x) is a nonzero real number.

![[Pasted image 20260205193951.png]]

A one-to-one correspondence is called ***invertible*** because we can define an inverse of this function. A function is not invertible if it is not a one-to-one correspondence, because the inverse of such a function does not exist.

>[!example]
>Let f be the function from {a, b, c} to {1, 2, 3} such that f(a) = 2, f(b) = 3, and f(c) = 1. Is f invertible, and if it is, what is its inverse?
>The function f is invertible because it is a one-to-one correspondence. The inverse function f −1 reverses the correspondence given by f , so f −1(1) = c, f −1(2) = a, and f −1 (3) = b.

>[!example]
>Let f : Z → Z be such that f(x) = x + 1. Is f invertible, and if it is, what is its inverse?
>The function f has an inverse because it is a one-to-one correspondence, as follows from Examples 10 and 15. To reverse the correspondence, suppose that y is the image of x, so that y = x + 1. Then x = y − 1. This means that y − 1 is the unique element of Z that is sent to y by f . Consequently, f −1(y) = y − 1.

>[!example]
>Let f be the function from R to R with f(x) = x2. Is f invertible?
>Because f(−2) = f(2) = 4, f is not one-to-one. If an inverse function were defined, it would have to assign two elements to 4. Hence, f is not invertible. 
>(Note we can also show that f is not invertible because it is not onto.)

>[!example]
>Show that if we restrict the function f(x) = x2 in Example 21 to a function from the set of all nonnegative real numbers to the set of all nonnegative real numbers, then f is invertible.
>The function f(x) = x2 from the set of nonnegative real numbers to the set of nonnegative real numbers is one-to-one. To see this, note that if f(x) = f(y), then x2 = y2, so x2 − y2 = (x + y)(x − y) = 0. This means that x + y = 0 or x − y = 0, so x = −y or x = y. Because both x and y are nonnegative, we must have x = y. So, this function is one-to-one. Furthermore, f(x) = x2 is onto when the codomain is the set of all nonnegative real numbers, because each nonnegative real number has a square root. That is, if y is a nonnegative real number, there exists a nonnegative real number x such that x = √y, which means that x2 = y. Because the function f(x) = x2 from the set of nonnegative real numbers to the set of nonnegative real numbers is one-to-one and onto, it is invertible. Its inverse is given by the rule f −1(y) = √y.

>[!summary] Definition - Composition
>Let g be a function from the set A to the set B and let f be a function from the set B to the set C. The composition of the functions f and g, denoted for all a ∈ A by f ◦g, is the function from A to C defined by ( f ◦g)(a) = f(g(a)).
>
>f ◦g is the function that assigns to the element a of A the element assigned by f to g(a). The domain of f ◦g is the domain of g. The range of f ◦g is the image of the range of g with respect to the function f . That is, to find ( f ◦g)(a) we first apply the function g to a to obtain g(a) and then we apply the function f to the result g(a) to obtain ( f ◦g)(a) = f(g(a)).

![[Pasted image 20260205194412.png]]

>[!example]
>Let g be the function from the set {a, b, c} to itself such that g(a) = b, g(b) = c, and g(c) = a. Let f be the function from the set {a, b, c} to the set {1, 2, 3} such that f(a) = 3, f(b) = 2, and f(c) = 1. What is the composition of f and g, and what is the composition of g and f ?
>The composition f ◦g is defined by (f ◦g)(a) = f(g(a)) = f(b) = 2, ( f ◦g) (b) = f(g(b)) = f(c) = 1, and ( f ◦g)(c) = f(g(c)) = f(a) = 3. 
>Note that g◦f is not defined, because the range of f is not a subset of the domain of g.

>[!example]
>Let f and g be the functions from the set of integers to the set of integers defined by f(x) = 2x + 3 and g(x) = 3x + 2. What is the composition of f and g? What is the composition of g and f ?
>Both the compositions f ◦g and g◦f are defined. Moreover, ( f ◦g)(x) = f(g(x)) = f(3x + 2) = 2(3x + 2) + 3 = 6x + 7 and (g◦f)(x) = g( f(x)) = g(2x + 3) = 3(2x + 3) + 2 = 6x + 11.
>Remark: Note that even though f ◦g and g◦f are defined for the functionsf and g in Example 24, f ◦g and g◦f are not equal. In other words, the commutative law does not hold for the composition of functions.

>[!example]
>Let f and g be the functions defined by f : R → R+ ∪ {0} with f(x) = x2 and g : R+ ∪ {0} → R with g(x) = √x (where √x is the nonnegative square root of x). What is the function ( f ◦g)(x)?
>The domain of ( f ◦g)(x) = f(g(x)) is the domain of g, which is R+ ∪ {0}, the set of nonnegative real numbers. If x is a nonnegative real number, we have ( f ◦g)(x) = f(g(x)) = f( √x) = (√x )2 = x. The range of f ◦g is the image of the range of g with respect to the function f . This is the set R+ ∪ {0}, the set of nonnegative real numbers. Summarizing, f : R+ ∪ {0} → R+ ∪ {0} and f(g(x)) = x for all x
### Graphs of Functions
We can associate a set of pairs in A × B to each function from A to B. This set of pairs is called the ***graph*** of the function and is often displayed pictorially to aid in understanding the behavior of the function.

>[!summary] Definition - Graph of Function f
>Let f be a function from the set A to the set B. The graph of the function f is the set of ordered pairs {(a, b) ∣ a ∈ A and f(a) = b}.

>[!example]
>Display the graph of the function f(n) = 2n + 1 from the set of integers to the set of integers.
>The graph of f is the set of ordered pairs of the form (n, 2n + 1), where n is an integer.
>![[Pasted image 20260205194646.png]]

>[!example]
>Display the graph of the function f(x) = x2 from the set of integers to the set of integers.
>The graph of f is the set of ordered pairs of the form (x, f(x)) = (x, x2), where x is an integer.
>![[Pasted image 20260205194736.png]]
## Important Functions
### The Floor Function & Ceiling Function
Let x be a real number. The floor function rounds x down to the closest integer less than or equal to x, and the ceiling function rounds x up to the closest integer greater than or equal to x. These functions are often used when objects are counted.
>[!summary] Definition - Floor
>The floor function assigns to the real number x the largest integer that is less than or equal to x. The value of the floor function at x is denoted by ⌊x⌋. 
>Remark: The floor function is often also called the greatest integer function. It is often denoted by [x].

>[!summary] Definition - Ceiling
>The ceiling function assigns to the real number x the smallest integer that is greater than or equal to x. The value of the ceiling function at x is denoted by ⌈x⌉.

![[Pasted image 20260205195124.png]]

>[!example]
>These are some values of the floor and ceiling functions: 
>⌊ 1 2 ⌋ = 0, ⌈ 1 2 ⌉ = 1, ⌊−1 2 ⌋ = −1, ⌈−1 2 ⌉ = 0, ⌊3.1⌋ = 3, ⌈3.1⌉ = 4, ⌊7⌋ = 7, ⌈7⌉ = 7.

>[!example]
>Data stored on a computer disk or transmitted over a data network are usually represented as a string of bytes. Each byte is made up of 8 bits. How many bytes are required to encode 100 bits of data?
>To determine the number of bytes needed, we determine the smallest integer that is at least as large as the quotient when 100 is divided by 8, the number of bits in a byte. Consequently, ⌈100∕8⌉ = ⌈12.5⌉ = 13 bytes are required.

>[!example]
>In asynchronous transfer mode (ATM) (a communications protocol used on backbone networks), data are organized into cells of 53 bytes. How many ATM cells can be transmitted in 1 minute over a connection that transmits data at the rate of 500 kilobits per second?
>In 1 minute, this connection can transmit 500,000 ⋅ 60 = 30,000,000 bits. Each ATM cell is 53 bytes long, which means that it is 53 ⋅ 8 = 424 bits long. To determine the number of cells that can be transmitted in 1 minute, we determine the largest integer not exceeding the quotient when 30,000,000 is divided by 424. Consequently, ⌊30,000,000∕424⌋ = 70,754 ATM cells can be transmitted in 1 minute over a 500 kilobit per second connection.

| ID | Property |
| :--- | :--- |
| (1a) | $\lfloor x \rfloor = n \iff n \le x < n + 1$ |
| (1b) | $\lceil x \rceil = n \iff n - 1 < x \le n$ |
| (1c) | $\lfloor x \rfloor = n \iff x - 1 < n \le x$ |
| (1d) | $\lceil x \rceil = n \iff x \le n < x + 1$ |
| (2) | $x - 1 < \lfloor x \rfloor \le x \le \lceil x \rceil < x + 1$ |
| (3a) | $\lfloor -x \rfloor = -\lceil x \rceil$ |
| (3b) | $\lceil -x \rceil = -\lfloor x \rfloor$ |
| (4a) | $\lfloor x + n \rfloor = \lfloor x \rfloor + n$ |
| (4b) | $\lceil x + n \rceil = \lceil x \rceil + n$ |
> [!abstract] Theorem: Characterization of the Floor Function
> **Statement:** Let $n$ be an integer and $x$ be a real number.
> $$ \lfloor x \rfloor = n \iff n \le x < n + 1 $$
>
> > [!summary]- Proof
> > The property states that $\lfloor x \rfloor = n$ if and only if the integer $n$ is less than or equal to $x$ and $n + 1$ is larger than $x$. This is precisely what it means for $n$ to be the greatest integer not exceeding $x$, which is the definition of $\lfloor x \rfloor = n$. ∎

> [!abstract] Theorem: Translation Property of the Floor Function
> **Statement:** Let $n$ be an integer and $x$ be a real number.
> $$ \lfloor x + n \rfloor = \lfloor x \rfloor + n $$
>
> > [!summary]- Proof
> > We proceed with a direct proof.
> > Suppose that $\lfloor x \rfloor = m$, where $m$ is an integer (specifically the integer part of $x$). By property (1a), it follows that:
> > $$ m \le x < m + 1 $$
> > Adding $n$ to all three quantities in this chain of inequalities shows that:
> > $$ m + n \le x + n < m + n + 1 $$
> > Using property (1a) again, we see that the floor of $x + n$ is exactly $m + n$:
> > $$ \lfloor x + n \rfloor = m + n $$
> > Substituting $\lfloor x \rfloor$ back for $m$, we get:
> > $$ \lfloor x + n \rfloor = \lfloor x \rfloor + n $$
> > This completes the proof. ∎

> [!abstract] Theorem: Characterization of the Ceiling Function
> **Statement:** Let $n$ be an integer and $x$ be a real number.
> $$ \lceil x \rceil = n \iff n - 1 < x \le n $$
>
> > [!summary]- Proof
> > This property follows directly from the definition of the ceiling function. It states that $\lceil x \rceil = n$ if and only if the integer $n$ is greater than or equal to $x$ and $n - 1$ is smaller than $x$. This describes $n$ as the least integer greater than or equal to $x$, which is the definition of $\lceil x \rceil = n$. ∎

> [!example]
> Prove that if $x$ is a real number, then:
> $$ \lfloor 2x \rfloor = \lfloor x \rfloor + \left\lfloor x + \frac{1}{2} \right\rfloor $$
>
>
> To prove this statement, we let $x = n + \epsilon$, where $n$ is an integer ($\lfloor x \rfloor$) and $0 \le \epsilon < 1$ (the fractional part of $x$). We consider two cases based on the value of $\epsilon$.
>
> **Case 1:** $0 \le \epsilon < \frac{1}{2}$.
> *   **LHS:** We have $2x = 2n + 2\epsilon$. Since $0 \le 2\epsilon < 1$, it follows that $\lfloor 2x \rfloor = 2n$.
> *   **RHS:** We have $x + \frac{1}{2} = n + \left(\frac{1}{2} + \epsilon\right)$. Since $0 < \frac{1}{2} + \epsilon < 1$, it follows that $\left\lfloor x + \frac{1}{2} \right\rfloor = n$.
> *   Therefore, $\lfloor x \rfloor + \left\lfloor x + \frac{1}{2} \right\rfloor = n + n = 2n$.
> *   The two sides are equal: $2n = 2n$.
>
> **Case 2:** $\frac{1}{2} \le \epsilon < 1$.
> *   **LHS:** We have $2x = 2n + 2\epsilon$. We can rewrite this as $(2n + 1) + (2\epsilon - 1)$. Since $\epsilon \ge \frac{1}{2}$, we know $2\epsilon \ge 1$, so $0 \le 2\epsilon - 1 < 1$. Thus, $\lfloor 2x \rfloor = 2n + 1$.
> *   **RHS:** We examine $\left\lfloor x + \frac{1}{2} \right\rfloor = \left\lfloor n + \left(\frac{1}{2} + \epsilon\right)\right\rfloor$. Since $\frac{1}{2} + \epsilon \ge 1$, we can write this as $\lfloor n + 1 + (\epsilon - \frac{1}{2}) \rfloor$. Because $0 \le \epsilon - \frac{1}{2} < \frac{1}{2} < 1$, the floor is $n + 1$.
> *   Therefore, $\lfloor x \rfloor + \left\lfloor x + \frac{1}{2} \right\rfloor = n + (n + 1) = 2n + 1$.
> *   The two sides are equal: $2n + 1 = 2n + 1$.
>
> Since the equality holds in all possible cases, the identity is proved. ∎

> [!example]
> Prove or disprove that $\lceil x + y \rceil = \lceil x \rceil + \lceil y \rceil$ for all real numbers $x$ and $y$.
>
> Although this statement may appear reasonable, it is **false**. We can disprove it by providing a specific counterexample where the statement fails.
>
> Let $x = \frac{1}{2}$ and $y = \frac{1}{2}$.
>
> *   **Left Hand Side:** 
> $$ \lceil x + y \rceil = \left\lceil \frac{1}{2} + \frac{1}{2} \right\rceil = \lceil 1 \rceil = 1 $$
>
> *   **Right Hand Side:**
> $$ \lceil x \rceil + \lceil y \rceil = \left\lceil \frac{1}{2} \right\rceil + \left\lceil \frac{1}{2} \right\rceil = 1 + 1 = 2 $$
>
> Since $1 \neq 2$, the equality does not hold for these values. Therefore, the statement is false. ∎
### Partial Functions
A program designed to evaluate a function may not produce the correct value of the function for all elements in the domain of this function. 
For example, a program may not produce a correct value because evaluating the function may lead to an infinite loop or an overflow. 
Similarly, in abstract mathematics, we often want to discuss functions that are defined only for a subset of the real numbers, such as 1∕x, √x, and arcsin (x).

>[!summary] Definition - Partial Function
>A partial function f from a set A to a set B is an assignment to each element a in a subset of A, called the domain of definition of f , of a unique element b in B. The sets A and B are called the domain and codomain of f , respectively. We say that f is undefined for elements in A that are not in the domain of definition of f . When the domain of definition of f equals A, we say that f is a total function.
>Remark: We write f : A → B to denote that f is a partial function from A to B. Note that this is the same notation as is used for functions. The context in which the notation is used determines whether f is a partial function or a total function.

>[!example]
>The function f : Z → R where f(n) = √n is a partial function from Z to R where the domain of definition is the set of nonnegative integers. 
>Note that f is undefined for negative integers.
## Cardinality
### Intro
We use the cardinalities of finite sets to tell us when they have the same size, or when one is bigger than the other.

>[!summary] Definition - Cardinality
>The sets A and B have the same cardinality if and only if there is a one-to-one correspondence from A to B. When A and B have the same cardinality, we write |A| = |B|.

For infinite sets the definition of cardinality provides a relative measure of the sizes of two sets, rather than a measure of the size of one particular set. We can also define what it means for one set to have a smaller cardinality than another set.

>[!summary] Definition - Relational Cardinality
>If there is a one-to-one function from A to B, the cardinality of A is less than or the same as the cardinality of B and we write |A| ≤ |B|. Moreover, when |A| ≤ |B| and A and B have different cardinality, we say that the cardinality of A is less than the cardinality of B and we write |A| < |B|.

### Countable Sets
We can split infinite sets into two groups, those with the same cardinality as the set of natural numbers and those with a different cardinality.

>[!summary] Definition - Countable
>A set that is either finite or has the same cardinality as the set of positive integers is called countable. A set that is not countable is called uncountable. When an infinite set S is countable, we denote the cardinality of S by ℵ0 (where ℵ is aleph, the first letter of the Hebrew alphabet). We write |S| = ℵ0 and say that S has cardinality “aleph null.”

>[!example]
>Show that the set of odd positive integers is a countable set.
>To show that the set of odd positive integers is countable, we will exhibit a one-to-one correspondence between this set and the set of positive integers. Consider the function f(n) = 2n − 1 from Z+ to the set of odd positive integers. We show that f is a one-to-one correspondence by showing that it is both one-to-one and onto. To see that it is one-to-one, suppose that f(n) = f(m). Then 2n − 1 = 2m − 1, so n = m. To see that it is onto, suppose that t is an odd positive integer. Then t is 1 less than an even integer 2k, where k is a natural number. Hence t = 2k − 1 = f(k).
>![[Pasted image 20260205205017.png]]

An infinite set is countable if and only if it is possible to list the elements of the set in a sequence (indexed by the positive integers). The reason for this is that a one-to-one correspondence f from the set of positive integers to a set S can be expressed in terms of a sequence a1, a2, … , an, … , where a1 = f(1), a2 = f(2), … , an = f(n), … .

>[!example]
>Show that the set of all integers is countable.
>We can list all integers in a sequence by starting with 0 and alternating between positive and negative integers: 0, 1,−1, 2,−2, …. Alternatively, we could find a one-to-one correspondence between the set of positive integers and the set of all integers. We leave it to the reader to show that the function f(n) = n∕2 when n is even and f(n) = −(n − 1)∕2 when n is odd is such a function. Consequently, the set of all integers is countable.

>[!example]
>Show that the set of positive rational numbers is countable.
>It may seem surprising that the set of positive rational numbers is countable, but we will show how we can list the positive rational numbers as a sequence r1, r2, … , rn, … . First, note that every positive rational number is the quotient p∕q of two positive integers. We can arrange the positive rational numbers by listing those with denominator q = 1 in the first row, those with denominator q = 2 in the second row, and so on.
>
The key to listing the rational numbers in a sequence is to first list the positive rational numbers p∕q with p + q = 2, followed by those with p + q = 3, followed by those with p + q = 4, and so on.
For example, when we come to 2∕2 = 1 we do not list it because we have already listed 1∕1 = 1. The initial terms in the list of positive rational numbers we have constructed are 1, 1∕2, 2, 3, 1∕3, 1∕4, 2∕3, 3∕2, 4, 5, and so on. These numbers are shown circled; the uncircled numbers in the list are those we leave out because they are lready listed. Because all positive rational numbers are listed once, as the reader can verify, we have shown that the set of positive rational numbers is countable.
>![[Pasted image 20260205205228.png]]
### Uncountable Sets
The Cantor diagonalization argument, to prove that the set of real numbers is not countable. This proof method is used extensively in mathematical logic and in the theory of computation.

>[!example]
>Show that the set of real numbers is an uncountable set.
>To show that the set of real numbers is uncountable, we suppose that the set of real Examples numbers is countable and arrive at a contradiction. Then, the subset of all real numbers that fall between 0 and 1 would also be countable (because any subset of a countable set is also countable). Under this assumption, the real numbers between 0 and 1 can be listed in some order, say, r1, r2, r3, … . Let the decimal representation of these real numbers be r1 = 0.d11d12d13d14 … r2 = 0.d21d22d23d24 … r3 = 0.d31d32d33d34 … r4 = 0.d41d42d43d44 … ⋮ where dij ∈ {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}. (For example, if r1 = 0.23794102 … , we have d11 = 2, d12 = 3, d13 = 7, and so on.) Then, form a new real number with decimal expansion r = 0.d1d2d3d4 … , where the decimal digits are determined by the following rule: di = {4 if dii ≠ 4 5 if dii = 4. (As an example, suppose that r1 = 0.23794102 … , r2 = 0.44590138 … , r3 = 0.09118764 … , r4 = 0.80553900 … , and so on. Then we have r = 0.d1d2d3d4 … = 0.4544 … , where d1 = 4 because d11 ≠ 4, d2 = 5 because d22 = 4, d3 = 4 because d33 ≠ 4, d4 = 4 because d44 ≠ 4, and so on.) Every real number has a unique decimal expansion (when the possibility that the expansion has a tail end that consists entirely of the digit 9 is excluded). Therefore, the real number r is not equal to any of r1, r2, … because the decimal expansion of r differs from the decimal expansion of ri in the ith place to the right of the decimal point, for each i. Because there is a real numberr between 0 and 1 that is not in the list, the assumption that all the real numbers between 0 and 1 could be listed must be false. Therefore, all the real numbers between 0 and 1 cannot be listed, so the set of real numbers between 0 and 1 is uncountable. Any set with an uncountable subset is uncountable. Hence, the set of real numbers is uncountable.

> [!abstract] Theorem: Union of Countable Sets
> **Statement:** If $A$ and $B$ are countable sets, then $A \cup B$ is also countable.
>
> > [!summary]- Proof
> > Suppose that $A$ and $B$ are both countable sets. Without loss of generality, we can assume that $A$ and $B$ are disjoint. (If they are not, we can replace $B$ by $B - A$, because $A \cap (B - A) = \emptyset$ and $A \cup (B - A) = A \cup B$.) Furthermore, without loss of generality, if one of the two sets is countably infinite and the other finite, we can assume that $B$ is the one that is finite.
> >
> > There are three cases to consider: (i) $A$ and $B$ are both finite, (ii) $A$ is infinite and $B$ is finite, and (iii) $A$ and $B$ are both countably infinite.
> >
> > **Case (i):** Note that when $A$ and $B$ are finite, $A \cup B$ is also finite, and therefore, countable.
> >
> > **Case (ii):** Because $A$ is countably infinite, its elements can be listed in an infinite sequence $a_1, a_2, a_3, \dots, a_n, \dots$ and because $B$ is finite, its terms can be listed as $b_1, b_2, \dots, b_m$ for some positive integer $m$. We can list the elements of $A \cup B$ as $b_1, b_2, \dots, b_m, a_1, a_2, a_3, \dots, a_n, \dots$. This means that $A \cup B$ is countably infinite.
> >
> > **Case (iii):** Because both $A$ and $B$ are countably infinite, we can list their elements as $a_1, a_2, a_3, \dots, a_n, \dots$ and $b_1, b_2, b_3, \dots, b_n, \dots$, respectively. By alternating terms of these two sequences we can list the elements of $A \cup B$ in the infinite sequence $a_1, b_1, a_2, b_2, a_3, b_3, \dots, a_n, b_n, \dots$. This means $A \cup B$ must be countably infinite.
> >
> > **Conclusion:**
> > We have completed the proof, as we have shown that $A \cup B$ is countable in all three cases. ∎

> [!abstract] Theorem 2: Schröder-Bernstein Theorem
> **Statement:** If $A$ and $B$ are sets with $|A| \le |B|$ and $|B| \le |A|$, then $|A| = |B|$. In other words, if there are one-to-one functions $f$ from $A$ to $B$ and $g$ from $B$ to $A$, then there is a one-to-one correspondence between $A$ and $B$.
>
> > [!info]- Note on the Proof
> > This theorem seems straightforward, but it lacks an easy proof. When you have an injection from $A$ to $B$ that may not be onto, and another injection from $B$ to $A$ that also may not be onto, there is no obvious way to construct a bijection from $A$ to $B$. All known proofs are subtle and have twists and turns.

>[!example]
>Show that the |(0, 1)| = |(0, 1]|.
>It is not at all obvious how to find a one-to-one correspondence between (0, 1) and (0, 1] to show that |(0, 1)| = |(0, 1]|. Fortunately, we can use the Schroder-Bernstein theorem ¨ instead. Finding a one-to-one function from (0, 1) to (0, 1] is simple. Because (0, 1) ⊂ (0, 1], f(x) = x is a one-to-one function from (0, 1) to (0, 1]. Finding a one-to-one function from (0, 1] to (0, 1) is also not difficult. The function g(x) = x∕2 is clearly one-to-one and maps (0, 1] to (0, 1∕2] ⊂ (0, 1). As we have found one-to-one functions from (0, 1) to (0, 1] and from (0, 1] to (0, 1), the Schroder-Bernstein theorem tells us that ¨ |(0, 1)| = |(0, 1]|.

#### Uncountable Functions
>[!summary] Definition - Computable
>We say that a function is computable if there is a computer program in some programming language that finds the values of this function. If a function is not computable we say it is uncomputable.

To show that there are uncomputable functions, we need to establish two results. First, we need to show that the set of all computer programs in any particular programming language is countable. This can be proved by noting that a computer program in a particular language can be thought of as a string of characters from a finite alphabet.
Next, we show that there are uncountably many different functions from a particular countably infinite set to itself.

> [!abstract] The Continuum Hypothesis
> **Statement:** There is no cardinal number $X$ strictly between $\aleph_0$ (the cardinality of the set of positive integers) and $\mathfrak{c}$ (the cardinality of the set of real numbers).
> $$ \aleph_0 < |A| < \mathfrak{c} \text{ has no solution} $$
>
> > [!summary]- Historical Context & Status
> > **Background:**
> > It can be shown that $|\mathcal{P}(\mathbb{Z}^+)| = |\mathbb{R}| = \mathfrak{c}$. An important theorem of Cantor states that $|\mathbb{Z}^+| < |\mathcal{P}(\mathbb{Z}^+)|$, which can be rewritten using the notation $2^{|S|}$ for the cardinality of a power set as:
> > $$ \aleph_0 < 2^{\aleph_0} = \mathfrak{c} $$
> > The continuum hypothesis asserts that there is no set $A$ such that $\aleph_0 < |A| < \mathfrak{c}$. If true, it would imply that $\mathfrak{c} = \aleph_1$, the next cardinal number after $\aleph_0$.
> >
> > **History:**
> > The hypothesis was stated by Georg Cantor in 1877. He labored unsuccessfully to prove it. By 1900, it was considered one of the most important unsolved problems in mathematics and was the first problem posed by David Hilbert in his famous list of open problems.
> >
> > **Current Status:**
> > The continuum hypothesis remains an area of active research, but a definitive resolution was established in the 20th century. It has been shown that the hypothesis can be **neither proved nor disproved** under the standard axioms of modern mathematics (the Zermelo-Fraenkel axioms). These axioms were formulated to avoid paradoxes like Russell's paradox, though debate continues regarding whether they should be replaced by other axioms for set theory.