#IMPR #C #CCT1 
- - -
## Table of Contents

- [[#4.2 Conditions|4.2 Conditions]]
	- [[#4.2 Conditions#Relational and Equality Operators|Relational and Equality Operators]]
	- [[#4.2 Conditions#Logical Operators|Logical Operators]]
	- [[#4.2 Conditions#Operator Precedence|Operator Precedence]]
	- [[#4.2 Conditions#Short-circuit Eval|Short-circuit Eval]]
	- [[#4.2 Conditions#Writing English Conditions in C|Writing English Conditions in C]]
	- [[#4.2 Conditions#Comparing Characters|Comparing Characters]]
	- [[#4.2 Conditions#Logical Assignment|Logical Assignment]]
	- [[#4.2 Conditions#Complementing a Condition|Complementing a Condition]]
- [[#4.3 The *if* Statement|4.3 The *if* Statement]]
	- [[#4.3 The *if* Statement#if Statement with Two Alternatives|if Statement with Two Alternatives]]
	- [[#4.3 The *if* Statement#if Statement with One Alternative|if Statement with One Alternative]]
	- [[#4.3 The *if* Statement#A Comparison of One and Two Alternative if Statements|A Comparison of One and Two Alternative if Statements]]
	- [[#4.3 The *if* Statement#Program Style - Format of the if Statement|Program Style - Format of the if Statement]]
- [[#4.4 if Statements with Compound Statements|4.4 if Statements with Compound Statements]]
	- [[#4.4 if Statements with Compound Statements#Program Style - Writing if Statements with Compound True or False Statements|Program Style - Writing if Statements with Compound True or False Statements]]
	- [[#4.4 if Statements with Compound Statements#Tracing an if Statement|Tracing an if Statement]]
- [[#4.5 Decision Steps in Algorithms|4.5 Decision Steps in Algorithms]]
	- [[#4.5 Decision Steps in Algorithms#Program Style - Consistent Use of Names in Functions|Program Style - Consistent Use of Names in Functions]]
	- [[#4.5 Decision Steps in Algorithms#Program Style - Cohesive Functions|Program Style - Cohesive Functions]]
	- [[#4.5 Decision Steps in Algorithms#Program Style - Using Constant Macros to Enhance Readability and Ease Maintenance|Program Style - Using Constant Macros to Enhance Readability and Ease Maintenance]]
- [[#4.6 More Problem Solving|4.6 More Problem Solving]]
	- [[#4.6 More Problem Solving#Data Flow Information in Structure Charts|Data Flow Information in Structure Charts]]
	- [[#4.6 More Problem Solving#Modifying a Program with Function Subprograms|Modifying a Program with Function Subprograms]]
- [[#4.7 nested if Statements and Multiple-Alternative Decisions|4.7 nested if Statements and Multiple-Alternative Decisions]]
	- [[#4.7 nested if Statements and Multiple-Alternative Decisions#Comparison of Nested if and Sequence of ifs|Comparison of Nested if and Sequence of ifs]]
	- [[#4.7 nested if Statements and Multiple-Alternative Decisions#Multiple-Alternative Decision Form of Nested if Statements|Multiple-Alternative Decision Form of Nested if Statements]]
	- [[#4.7 nested if Statements and Multiple-Alternative Decisions#Order of Conditions in Multiple-Alternative Decision|Order of Conditions in Multiple-Alternative Decision]]
	- [[#4.7 nested if Statements and Multiple-Alternative Decisions#Program Style - Validating the Value of Variables|Program Style - Validating the Value of Variables]]
	- [[#4.7 nested if Statements and Multiple-Alternative Decisions#Nested if Statements with More Than One Variable|Nested if Statements with More Than One Variable]]
- [[#4.8 The switch Statement|4.8 The switch Statement]]
	- [[#4.8 The switch Statement#Comparison of Nested if, and switch Statements|Comparison of Nested if, and switch Statements]]
- [[#4.9 Common Programming Errors|4.9 Common Programming Errors]]

# 4.1 Control Structures
Control the flow of execution in a program/function.
There're 3 kinds of control structures
- sequence
- selection
- repetition
A compound statement, written as a group of statements is used to specify sequential flow.
# 4.2 Conditions
A program chooses among alternative statements, by testing the value of key variables.
	A healthy heart beats <=75 bpm, >75 indicates a potential problem.
	A program coupled to a patient's heartrate, could compare it to 75, and display a warning if it's over 75.
	![[Pasted image 20250927163953.png]]
## Relational and Equality Operators
Most conditions performing comparisons, will use:
![[Pasted image 20250927164135.png]]
![[Pasted image 20250927164148.png]]

![[Pasted image 20250927164257.png]]
## Logical Operators
There're 3 logical operators, used to form logical expressions
- && AND
- || OR
- ! NOT
![[Pasted image 20250927164638.png]]
![[Pasted image 20250927164739.png]]

![[Pasted image 20250927164859.png]]
![[Pasted image 20250927164910.png]]
![[Pasted image 20250927164919.png]]
## Operator Precedence
AKA order of evaluation.
![[Pasted image 20250927165036.png]]

![[Pasted image 20250927165154.png]]
![[Pasted image 20250927165209.png]]

## Short-circuit Eval
C evaluates only the part of an expression neccesary to determine its value.
If *a* in `a || b` is true, the expression is true and the answer to *b* doesn't get calculated. Similarly for `a && b` if *a* is false, the expression is false and *b* will be disregarded.

Short-circuit eval is used to prevent run-time errors.
![[Pasted image 20250927165739.png]]

## Writing English Conditions in C
Many algorithm steps require testing if a variable falls within a range.
![[Pasted image 20250927172028.png]]
	You cannot necessarily simplify an expression
	![[Pasted image 20250927172326.png]]
## Comparing Characters
C can also compare individual characters, using relational and equality operators.
	Ordered as expected `0<1<2<...` and `a<b<c<...`
![[Pasted image 20250927172633.png]]
The values of different letters is system dependent.
## Logical Assignment
Simplest form of logical expression is `int` variable intended to represent the value `true` (!0 )or `false` (=0).
We use assignment statements to set variables.
```
int age; /* input - a person's age */ 
int senior_citizen; /* logical - indicates senior status */

The programmer could assign the senior status:
senior_citizen = 1; /* Set senior status to true */

A more likely scenario, is to check the age variable and compareif it's elligable for senior status:
scanf("%d", &age); /* Read the person's age */ senior_citizen = (age >= 65); /* Set senior status */
```
## Complementing a Condition
Like complementing a logical expression by preceding with the NOT operator (!), this can also be done to simple conditions.
![[Pasted image 20250927174149.png]]
Usually for simple equality or relational operators, complement is a simple condition change. Swap `<` for `>`, `>=` `<=` and so on. For more complex expressions, use `!`.
![[Pasted image 20250927174402.png]]
![[Pasted image 20250927174418.png]]
# 4.3 The *if* Statement
## if Statement with Two Alternatives
![[Pasted image 20250928114822.png]]
`if` statements are the primary selection control structure.
![[Pasted image 20250928124201.png]]
![[Pasted image 20250928124304.png]]
## if Statement with One Alternative
You're not forced to bring two alternatives for an `if`, statement.
If written with only one alternative, the alternative only executes when the condition is true.
![[Pasted image 20250928124456.png]]
## A Comparison of One and Two Alternative if Statements
![[Pasted image 20250928124549.png]]
![[Pasted image 20250928124556.png]]
## Program Style - Format of the if Statement
Most `if` statements in text are of the format `statementT` and `statementF`.
The word `else` is usually typed on a separate line, without indentation, to signify the severance of the two statements.
This format, makes the `if`'s meaning apparent, and is used solely to improve readability.
# 4.4 if Statements with Compound Statements
A compound statement is a block of code that groups multiple statements together. Typically enclosed with {}.
```
if (pop_today > pop_yesterday) {
growth = pop_today - pop_yesterday;
growth_pct = 100 * growth / pop_yesterday;
printf("The growth percentage is %.2f\n", growth_pct);
}
```
The compound statement, is the `growth = pop_today - pop_yesterday`, and so on; statement. **After** the `if (pop_today > pop_yesterday)` condition; which only executes when today's population is larger than yesterday's.
## Program Style - Writing if Statements with Compound True or False Statements
We enclose a compound statement for `true` and for `false` in separate braces.
![[Pasted image 20250928130024.png]]
Some prefer to use braces around all `true` and `false` tasks, whether they're compound or not, so all `if` statements have a consistent style.
## Tracing an if Statement
A critical step in design, is to verify an algorithm or statement is correct, before spending extensive time coding or debugging it.
	Often a few minutes spent verifying will buy hours of coding and testing later.
A *hand trace* or *desk-check*, is a careful, manual, step-by-step simulation of the code, on paper.
![[Pasted image 20250928130519.png]]
# 4.5 Decision Steps in Algorithms
An algorithm step that selects from a choice of actions, is called a *decision step*.
	These are often coded as `if` statements.
## Program Style - Consistent Use of Names in Functions
Using the same name avoids the confusion that would result from using different names to reference the same information.
## Program Style - Cohesive Functions
Functions that perform a single operation are called *cohesive functions*. Writing cohesive functions is good programming style, because cohesive functions are easier to read, write, debug, and maintain, and are more likely to be reusable.
## Program Style - Using Constant Macros to Enhance Readability and Ease Maintenance
Use of constant macro names rather than actual values has two advantages. First, the original statements are easier to understand because they use the descriptive names DEMAND_CHG, PER_1000_CHG, and LATE_CHG rather than numbers, which have no intrinsic meaning. Second, a program written using constant macros is much easier to maintain than one written with constant values. 
	If we inserted constant values directly in the statements, we would need to change any statements that manipulate the constant values.
# 4.6 More Problem Solving
## Data Flow Information in Structure Charts
![[Pasted image 20250928141404.png]]
Data flow information is an important part of system documentation because it shows what program variables are processed by each step and the manner in which those variables are processed.
- If a variable is given a new value, the variable is considered *an output of the step*.
- If a variable is displayed, the variable is considered *an input of the step*.
Variables often have many roles for different sub-problems within the algorithm.
## Modifying a Program with Function Subprograms
Often, what appears to be a **"new"** problem, is a variation of one that's already been solved.
	An important skill in problem solving is the ability to recognize similar problems and the sollutions from the one's solved earlier.
	Try to adapt and reuse parts of successful programs, as much as possible.

Writing programs in a way that can easily be changed and adapted to fit other situations, is adviseable.
	This is known as modular programming.
# 4.7 nested if Statements and Multiple-Alternative Decisions
A *nested* if statement, is when an if statement is placed within another if statement, creating a chain of conditions; enabling more complex decision-making.
Nested if statements are also used to achieve multiple alternatives.
```
// Increment num_pos, num_neg or num_zero depending on value of x
if (x > 0) { // x more than 0
	num_pos = num_pos + 1;
}
else {
	if (x < 0) { // x less than 0
		num_neg = num_neg + 1;
	}
	else { // x equal to 0
		num_zero = num_zero + 1;
	}
}
```
Here're 3 alternatives, based on x.
1. x = >0
2. x = <0
3. x = 0
![[Pasted image 20250928142957.png]]
## Comparison of Nested if and Sequence of ifs
Beginners might want to use a sequence of individual if statements, instead of nesting if statements together. 
This is logically similar to nested ifs, but harder to read, and less efficient. Since all conditions are always tested for, rather than only the necessary ones.
```
if (x > 0) {
	++ num_pos;
}
if (x < 0) {
	++ num_neg;
}
if (x = 0) {
	++ num_zero;
}
```
![[Pasted image 20250928143418.png]]
## Multiple-Alternative Decision Form of Nested if Statements
If there're more than 3 alternatives and indentation is not consistent, it may be difficult to read and determine the logical structure of the if statements.
![[Pasted image 20250928143644.png]]
![[Pasted image 20250928143656.png]]
## Order of Conditions in Multiple-Alternative Decision
When more than 1 condition in a multiple-alternative is true, only the task following the first condition executes.
	The order of conditions can therefore affect the outcome of the function
Writing the decision as follow would be incorrect.
All but the loudest sounds would be miscategorized as "very annoying", since every, but the first condition are skipped in the nest.
```
/* Incorrect perception of loudness */
if (noise_db <= 110) {
	printf("%d-db noise is very annoying.\n", noise_db);
}
else if (noise_db <= 90) {
	printf("%d-db noise is annoying.\n", noise_db);
}
else if (noise_db <= 70) {
	printf("%d-db noise is intrustive.\n", noise_db)
}
else if (noise_db <= 50) {
	printf("%d-db noise is quiet.\n", noise_db")
}
else {
	printf("%d-db noise is uncomfortable.\n", noise_db)
}
```
The order of conditions makes it so any noise below or equal to 110 is categorized as being in the "annoying" bracket.
## Program Style - Validating the Value of Variables
Validating the value of a variable before utilizing it in a computation, can avoid processing invalid or meaningless data.
## Nested if Statements with More Than One Variable
If several variables are involved in the decision, we cannot always use a multiple-alternative decision.
![[Pasted image 20250928145335.png]]
# 4.8 The switch Statement
The *switch* statement can also be used in C, to select one of several alternatives.
	Especially useful when the selection is based on the value of a single variable; or a simple expression (called *the controlling expression).*
		The value of this expression can be `int` or `char`, but not `double`.

The switch statement displays a message that depends on the value of the controlling expression. 
First, this expression is evaluated; then, the list of ``case`` labels (``case 'B':, case 'b':, case 'C':, etc.``) is searched until one label that matches the value of the controlling expression is found.
Statements following the matching case label are executed until a ``break`` statement is encountered.
The ``break`` causes an exit from the switch statement, and execution continues with the statement that follows the closing brace of the switch statement body
If no case label matches the value of the switch statement’s controlling expression, the statements following the ``default`` label are executed, if there is a ``default`` label. If not, the entire switch statement body is skipped.
	Using a string such as "Cruiser" or "Frigate" as a case label is a common error. It is important to remember that type int and char values may be used as case labels, but strings and type double values cannot be used.
	Another common error is the omission of the break statement at the end of one alternative. In such a situation, execution “falls through” into the next alternative. We recommend using a blank line after each break statement to emphasize the fact that there is no “fall-through.”
	Forgetting the closing brace of the switch statement body is also easy to do. If the brace is missing and the switch has a default label, the statements following the switch statement become part of the default case.
![[Pasted image 20250928150432.png]]
![[Pasted image 20250928150451.png]]
![[Pasted image 20250928150509.png]]
![[Pasted image 20250928150519.png]]
## Comparison of Nested if, and switch Statements
Nested if statements are more general, and broadly used to implement any multiple-alternative decision.

Switch statements are more readable in many contexts, and should be preferred wherever practical.

`double` cannot be used with switch statements.

You should use the switch statement when each label set contains a reasonable number of case labels (a maximum of ten). However, if the number of values is large, use a nested if statement.

You should include a ``default`` label in switch statements wherever possible
The discipline of trying to define a default will help you to consider what will happen if the value of your switch statement’s controlling expression falls outside your set of case label values. 
# 4.9 Common Programming Errors
![[Pasted image 20250928151019.png]]
![[Pasted image 20250928151031.png]]

![[Pasted image 20250928151056.png]]


