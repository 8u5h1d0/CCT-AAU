---
tags:
  - "#CCT2"
  - OO
  - Java
  - Programming
Topic: "Creating and compiling a Java program | JDK, JVM and IDE | Writing the first program in Java | Reading input for the console\r | Common errors in Java"
Semester: CCT2
Course: Objektorienteret analyse, design og implementering + Java
Litterature:
  - w3schools - Java Tutorial
  - Tutorials for Eclipse - Rasmus L. Olesen
Created: 10/02/2026
---
- - -
# Table of Contents

1. [[#Java Introduction|Java Introduction]]
	1. [[#Java Introduction#What is Java?|What is Java?]]
	2. [[#Java Introduction#Why Use Java?|Why Use Java?]]
	3. [[#Java Introduction#Java Example|Java Example]]
		1. [[#Java Example#Example|Example]]
2. [[#Java Syntax|Java Syntax]]
	1. [[#Java Syntax#Java Syntax|Java Syntax]]
		1. [[#Java Syntax#Example|Example]]
		2. [[#Java Syntax#Example explained|Example explained]]
	2. [[#Java Syntax#The main Method|The main Method]]
	3. [[#Java Syntax#System.out.println()|System.out.println()]]
		1. [[#System.out.println()#Example|Example]]
3. [[#Java Statements|Java Statements]]
	1. [[#Java Statements#Statements|Statements]]
		1. [[#Statements#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Statements#Example|Example]]
	2. [[#Java Statements#Many Statements|Many Statements]]
		1. [[#Many Statements#Example|Example]]
			1. [[#Example#Example explained|Example explained]]
4. [[#Java Output / Print|Java Output / Print]]
	1. [[#Java Output / Print#Print Text|Print Text]]
		1. [[#Print Text#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Print Text#Example|Example]]
	2. [[#Java Output / Print#Double Quotes|Double Quotes]]
		1. [[#Double Quotes#Example|Example]]
	3. [[#Java Output / Print#The Print() Method|The Print() Method]]
		1. [[#The Print() Method#Example|Example]]
5. [[#Java Output Numbers|Java Output Numbers]]
	1. [[#Java Output Numbers#Print Numbers|Print Numbers]]
		1. [[#Print Numbers#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Print Numbers#Example|Example]]
		3. [[#Print Numbers#Example|Example]]
6. [[#Java Comments|Java Comments]]
	1. [[#Java Comments#Java Comments|Java Comments]]
	2. [[#Java Comments#Single-line Comments|Single-line Comments]]
		1. [[#Single-line Comments#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Single-line Comments#Example|Example]]
	3. [[#Java Comments#Java Multi-line Comments|Java Multi-line Comments]]
		1. [[#Java Multi-line Comments#Example|Example]]
			1. [[#Example#Single or multi-line comments?|Single or multi-line comments?]]
7. [[#Java Variables|Java Variables]]
	1. [[#Java Variables#Java Variables|Java Variables]]
	2. [[#Java Variables#Declaring (Creating) Variables|Declaring (Creating) Variables]]
		1. [[#Declaring (Creating) Variables#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Declaring (Creating) Variables#Example|Example]]
		3. [[#Declaring (Creating) Variables#Example|Example]]
		4. [[#Declaring (Creating) Variables#Example|Example]]
		5. [[#Declaring (Creating) Variables#Example|Example]]
	3. [[#Java Variables#Final Variables|Final Variables]]
		1. [[#Final Variables#Example|Example]]
	4. [[#Java Variables#Other Types|Other Types]]
		1. [[#Other Types#Example|Example]]
8. [[#Java Print Variables|Java Print Variables]]
	1. [[#Java Print Variables#Display Variables|Display Variables]]
		1. [[#Display Variables#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Display Variables#Example|Example]]
		3. [[#Display Variables#Example|Example]]
	2. [[#Java Print Variables#Mixing Text and Numbers|Mixing Text and Numbers]]
		1. [[#Mixing Text and Numbers#Example|Example]]
9. [[#Java Declare Multiple Variables|Java Declare Multiple Variables]]
	1. [[#Java Declare Multiple Variables#Declare Many Variables|Declare Many Variables]]
		1. [[#Declare Many Variables#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Declare Multiple Variables#One Value to Multiple Variables|One Value to Multiple Variables]]
		1. [[#One Value to Multiple Variables#Example|Example]]
10. [[#Java Identifiers|Java Identifiers]]
	1. [[#Java Identifiers#Identifiers|Identifiers]]
		1. [[#Identifiers#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Identifiers#Invalid Identifiers|Invalid Identifiers]]
		1. [[#Invalid Identifiers#Example|Example]]
11. [[#Java Constants (final)|Java Constants (final)]]
	1. [[#Java Constants (final)#Constants (final keyword)|Constants (final keyword)]]
		1. [[#Constants (final keyword)#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Constants (final)#When to Use final?|When to Use final?]]
		1. [[#When to Use final?#Example|Example]]
12. [[#Java Variables - Examples|Java Variables - Examples]]
	1. [[#Java Variables - Examples#Real-Life Examples|Real-Life Examples]]
		1. [[#Real-Life Examples#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Variables - Examples#Calculate the Area of a Rectangle|Calculate the Area of a Rectangle]]
		1. [[#Calculate the Area of a Rectangle#Example|Example]]
13. [[#Java Data Types|Java Data Types]]
	1. [[#Java Data Types#Java Data Types|Java Data Types]]
		1. [[#Java Data Types#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Data Types#Primitive Data Types|Primitive Data Types]]
	3. [[#Java Data Types#You Cannot Change the Type|You Cannot Change the Type]]
		1. [[#You Cannot Change the Type#Example|Example]]
14. [[#Java Numbers|Java Numbers]]
	1. [[#Java Numbers#Numbers|Numbers]]
	2. [[#Java Numbers#Integer Types|Integer Types]]
		1. [[#Integer Types#Byte|Byte]]
		2. [[#Integer Types#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		3. [[#Integer Types#Short|Short]]
		4. [[#Integer Types#Example|Example]]
		5. [[#Integer Types#Int|Int]]
		6. [[#Integer Types#Example|Example]]
		7. [[#Integer Types#Long|Long]]
		8. [[#Integer Types#Example|Example]]
	3. [[#Java Numbers#Floating Point Types|Floating Point Types]]
		1. [[#Floating Point Types#Float Example|Float Example]]
		2. [[#Floating Point Types#Double Example|Double Example]]
		3. [[#Floating Point Types#Scientific Numbers|Scientific Numbers]]
		4. [[#Floating Point Types#Example|Example]]
15. [[#Java Boolean Data Types|Java Boolean Data Types]]
	1. [[#Java Boolean Data Types#Boolean Types|Boolean Types]]
		1. [[#Boolean Types#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
16. [[#Java Characters|Java Characters]]
	1. [[#Java Characters#Characters|Characters]]
		1. [[#Characters#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Characters#Example|Example]]
	2. [[#Java Characters#Strings|Strings]]
		1. [[#Strings#Example|Example]]
17. [[#Java Data Types Example|Java Data Types Example]]
	1. [[#Java Data Types Example#Real-Life Example|Real-Life Example]]
		1. [[#Real-Life Example#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
18. [[#Java Non-Primitive Data Types|Java Non-Primitive Data Types]]
	1. [[#Java Non-Primitive Data Types#Non-Primitive Data Types|Non-Primitive Data Types]]
19. [[#Java var Keyword|Java var Keyword]]
	1. [[#Java var Keyword#The var Keyword|The var Keyword]]
		1. [[#The var Keyword#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java var Keyword#Example with Different Types|Example with Different Types]]
		1. [[#Example with Different Types#Example|Example]]
	3. [[#Java var Keyword#Important Notes|Important Notes]]
	4. [[#Java var Keyword#When to Use var|When to Use var]]
		1. [[#When to Use var#Example|Example]]
20. [[#Java Data Types|Java Data Types]]
	1. [[#Java Data Types#Java Data Types|Java Data Types]]
		1. [[#Java Data Types#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Data Types#Primitive Data Types|Primitive Data Types]]
	3. [[#Java Data Types#You Cannot Change the Type|You Cannot Change the Type]]
		1. [[#You Cannot Change the Type#Example|Example]]
21. [[#Java Numbers|Java Numbers]]
	1. [[#Java Numbers#Numbers|Numbers]]
	2. [[#Java Numbers#Integer Types|Integer Types]]
		1. [[#Integer Types#Byte|Byte]]
		2. [[#Integer Types#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		3. [[#Integer Types#Short|Short]]
		4. [[#Integer Types#Example|Example]]
		5. [[#Integer Types#Int|Int]]
		6. [[#Integer Types#Example|Example]]
		7. [[#Integer Types#Long|Long]]
		8. [[#Integer Types#Example|Example]]
	3. [[#Java Numbers#Floating Point Types|Floating Point Types]]
		1. [[#Floating Point Types#Float Example|Float Example]]
		2. [[#Floating Point Types#Double Example|Double Example]]
		3. [[#Floating Point Types#Scientific Numbers|Scientific Numbers]]
		4. [[#Floating Point Types#Example|Example]]
22. [[#Java Boolean Data Types|Java Boolean Data Types]]
	1. [[#Java Boolean Data Types#Boolean Types|Boolean Types]]
		1. [[#Boolean Types#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
23. [[#Java Characters|Java Characters]]
	1. [[#Java Characters#Characters|Characters]]
		1. [[#Characters#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Characters#Example|Example]]
	2. [[#Java Characters#Strings|Strings]]
		1. [[#Strings#Example|Example]]
24. [[#Java Data Types Example|Java Data Types Example]]
	1. [[#Java Data Types Example#Real-Life Example|Real-Life Example]]
		1. [[#Real-Life Example#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
25. [[#Java Non-Primitive Data Types|Java Non-Primitive Data Types]]
	1. [[#Java Non-Primitive Data Types#Non-Primitive Data Types|Non-Primitive Data Types]]
26. [[#Java var Keyword|Java var Keyword]]
	1. [[#Java var Keyword#The var Keyword|The var Keyword]]
		1. [[#The var Keyword#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java var Keyword#Example with Different Types|Example with Different Types]]
		1. [[#Example with Different Types#Example|Example]]
	3. [[#Java var Keyword#Important Notes|Important Notes]]
	4. [[#Java var Keyword#When to Use var|When to Use var]]
		1. [[#When to Use var#Example|Example]]
27. [[#Java Type Casting|Java Type Casting]]
	1. [[#Java Type Casting#Java Type Casting|Java Type Casting]]
	2. [[#Java Type Casting#Widening Casting|Widening Casting]]
		1. [[#Widening Casting#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	3. [[#Java Type Casting#Narrowing Casting|Narrowing Casting]]
		1. [[#Narrowing Casting#Example|Example]]
	4. [[#Java Type Casting#Real-Life Example|Real-Life Example]]
		1. [[#Real-Life Example#Example|Example]]
28. [[#Java Operators|Java Operators]]
	1. [[#Java Operators#Java Operators|Java Operators]]
		1. [[#Java Operators#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Java Operators#Example|Example]]
29. [[#Java Arithmetic Operators|Java Arithmetic Operators]]
	1. [[#Java Arithmetic Operators#Arithmetic Operators|Arithmetic Operators]]
		1. [[#Arithmetic Operators#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Arithmetic Operators#Example|Example]]
	2. [[#Java Arithmetic Operators#Incrementing and Decrementing|Incrementing and Decrementing]]
		1. [[#Incrementing and Decrementing#Example|Example]]
		2. [[#Incrementing and Decrementing#Example|Example]]
		3. [[#Incrementing and Decrementing#Example|Example]]
			1. [[#Example#Real Life Example: Counting People|Real Life Example: Counting People]]
		4. [[#Incrementing and Decrementing#Example|Example]]
30. [[#Java Assignment Operators|Java Assignment Operators]]
	1. [[#Java Assignment Operators#Assignment Operators|Assignment Operators]]
		1. [[#Assignment Operators#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Assignment Operators#Example|Example]]
	2. [[#Java Assignment Operators#Real-Life Example: Tracking Savings|Real-Life Example: Tracking Savings]]
		1. [[#Real-Life Example: Tracking Savings#Example|Example]]
31. [[#Java Comparison Operators|Java Comparison Operators]]
	1. [[#Java Comparison Operators#Comparison Operators|Comparison Operators]]
		1. [[#Comparison Operators#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Comparison Operators#Real-Life Examples|Real-Life Examples]]
		1. [[#Real-Life Examples#Example|Example]]
		2. [[#Real-Life Examples#Example|Example]]
32. [[#Java Logical Operators|Java Logical Operators]]
	1. [[#Java Logical Operators#Logical Operators|Logical Operators]]
	2. [[#Java Logical Operators#Real-Life Example: Login Check|Real-Life Example: Login Check]]
		1. [[#Real-Life Example: Login Check#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
33. [[#Java Operator Precedence|Java Operator Precedence]]
	1. [[#Java Operator Precedence#Java Operator Precedence|Java Operator Precedence]]
		1. [[#Java Operator Precedence#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Java Operator Precedence#Why Does This Happen?|Why Does This Happen?]]
	2. [[#Java Operator Precedence#Order of Operations|Order of Operations]]
	3. [[#Java Operator Precedence#Another Example|Another Example]]
		1. [[#Another Example#Example|Example]]
34. [[#Java Strings|Java Strings]]
	1. [[#Java Strings#Java Strings|Java Strings]]
		1. [[#Java Strings#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Strings#String Length|String Length]]
		1. [[#String Length#Example|Example]]
	3. [[#Java Strings#More String Methods|More String Methods]]
		1. [[#More String Methods#Example|Example]]
	4. [[#Java Strings#Finding a Character in a String|Finding a Character in a String]]
		1. [[#Finding a Character in a String#Example|Example]]
		2. [[#Finding a Character in a String#Example|Example]]
	5. [[#Java Strings#Comparing Strings|Comparing Strings]]
		1. [[#Comparing Strings#Example|Example]]
	6. [[#Java Strings#Removing Whitespace|Removing Whitespace]]
		1. [[#Removing Whitespace#Example|Example]]
	7. [[#Java Strings#Complete String Reference|Complete String Reference]]
35. [[#Java String Concatenation|Java String Concatenation]]
	1. [[#Java String Concatenation#String Concatenation|String Concatenation]]
		1. [[#String Concatenation#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java String Concatenation#Concatenation in Sentences|Concatenation in Sentences]]
		1. [[#Concatenation in Sentences#Example|Example]]
	3. [[#Java String Concatenation#The concat() Method|The concat() Method]]
		1. [[#The concat() Method#Example|Example]]
		2. [[#The concat() Method#Example|Example]]
36. [[#Java Numbers and Strings|Java Numbers and Strings]]
	1. [[#Java Numbers and Strings#Adding Numbers and Strings|Adding Numbers and Strings]]
		1. [[#Adding Numbers and Strings#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Adding Numbers and Strings#Example|Example]]
		3. [[#Adding Numbers and Strings#Example|Example]]
37. [[#Java Special Characters|Java Special Characters]]
	1. [[#Java Special Characters#Strings - Special Characters|Strings - Special Characters]]
		1. [[#Strings - Special Characters#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Strings - Special Characters#Example|Example]]
		3. [[#Strings - Special Characters#Example|Example]]
38. [[#Java Math|Java Math]]
	1. [[#Java Math#Math.max(_x,y_)|Math.max(_x,y_)]]
		1. [[#Math.max(_x,y_)#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Math#Math.min(_x,y_)|Math.min(_x,y_)]]
		1. [[#Math.min(_x,y_)#Example|Example]]
	3. [[#Java Math#Math.sqrt(_x_)|Math.sqrt(_x_)]]
		1. [[#Math.sqrt(_x_)#Example|Example]]
	4. [[#Java Math#Math.abs(_x_)|Math.abs(_x_)]]
		1. [[#Math.abs(_x_)#Example|Example]]
	5. [[#Java Math#Math.pow(_x, y_)|Math.pow(_x, y_)]]
		1. [[#Math.pow(_x, y_)#Example|Example]]
	6. [[#Java Math#Rounding Methods|Rounding Methods]]
		1. [[#Rounding Methods#Example|Example]]
	7. [[#Java Math#Random Numbers|Random Numbers]]
		1. [[#Random Numbers#Example|Example]]
		2. [[#Random Numbers#Example|Example]]
	8. [[#Java Math#Complete Math Reference|Complete Math Reference]]
39. [[#Java Booleans|Java Booleans]]
	1. [[#Java Booleans#Java Booleans|Java Booleans]]
	2. [[#Java Booleans#Boolean Values|Boolean Values]]
		1. [[#Boolean Values#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	3. [[#Java Booleans#Boolean Expressions|Boolean Expressions]]
		1. [[#Boolean Expressions#Example|Example]]
		2. [[#Boolean Expressions#Example|Example]]
		3. [[#Boolean Expressions#Example|Example]]
		4. [[#Boolean Expressions#Example|Example]]
	4. [[#Java Booleans#Store the Result in a Boolean Variable|Store the Result in a Boolean Variable]]
		1. [[#Store the Result in a Boolean Variable#Example|Example]]
40. [[#Java Boolean Examples|Java Boolean Examples]]
	1. [[#Java Boolean Examples#Real Life Example|Real Life Example]]
		1. [[#Real Life Example#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Real Life Example#Example|Example]]
41. [[#Java If ... Else|Java If ... Else]]
	1. [[#Java If ... Else#Java Conditions and If Statements|Java Conditions and If Statements]]
		1. [[#Java Conditions and If Statements#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java If ... Else#The if Statement|The if Statement]]
		1. [[#The if Statement#Syntax|Syntax]]
		2. [[#The if Statement#Example|Example]]
		3. [[#The if Statement#Example|Example]]
		4. [[#The if Statement#Example explained|Example explained]]
		5. [[#The if Statement#Example|Example]]
	3. [[#Java If ... Else#Using Boolean Variables|Using Boolean Variables]]
		1. [[#Using Boolean Variables#Example|Example]]
		2. [[#Using Boolean Variables#Example|Example]]
	4. [[#Java If ... Else#If Without Braces|If Without Braces]]
		1. [[#If Without Braces#Example|Example]]
		2. [[#If Without Braces#Potential Problem|Potential Problem]]
		3. [[#If Without Braces#Example|Example]]
		4. [[#If Without Braces#The Safe Way|The Safe Way]]
		5. [[#If Without Braces#Example|Example]]
42. [[#Java Else|Java Else]]
	1. [[#Java Else#The else Statement|The else Statement]]
		1. [[#The else Statement#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#The else Statement#Example|Example]]
	2. [[#Java Else#Another Example|Another Example]]
		1. [[#Another Example#Example|Example]]
			1. [[#Example#Example explained|Example explained]]
		2. [[#Another Example#Notes|Notes]]
43. [[#Java Else If|Java Else If]]
	1. [[#Java Else If#The else if Statement|The else if Statement]]
		1. [[#The else if Statement#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Else If#Example|Example]]
		1. [[#Example#Example|Example]]
	3. [[#Java Else If#Another Example|Another Example]]
		1. [[#Another Example#Example|Example]]
			1. [[#Example#Example explained|Example explained]]
		2. [[#Another Example#Example|Example]]
44. [[#Java Short Hand If...Else (Ternary Operator)|Java Short Hand If...Else (Ternary Operator)]]
	1. [[#Java Short Hand If...Else (Ternary Operator)#Short Hand if...else|Short Hand if...else]]
		1. [[#Short Hand if...else#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Short Hand if...else#Example|Example]]
		3. [[#Short Hand if...else#Example|Example]]
	2. [[#Java Short Hand If...Else (Ternary Operator)#Nested Ternary (Optional)|Nested Ternary (Optional)]]
		1. [[#Nested Ternary (Optional)#Example|Example]]
45. [[#Java Nested If|Java Nested If]]
	1. [[#Java Nested If#Nested If|Nested If]]
		1. [[#Nested If#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Nested If#Example|Example]]
		1. [[#Example#Example|Example]]
	3. [[#Java Nested If#Real-Life Example|Real-Life Example]]
		1. [[#Real-Life Example#Example|Example]]
	4. [[#Java Nested If#Notes|Notes]]
46. [[#Java Logical Operators in Conditions|Java Logical Operators in Conditions]]
	1. [[#Java Logical Operators in Conditions#Logical Operators in Conditions|Logical Operators in Conditions]]
	2. [[#Java Logical Operators in Conditions#AND (`&&`)|AND (`&&`)]]
		1. [[#AND (`&&`)#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	3. [[#Java Logical Operators in Conditions#OR (`||`)|OR (`||`)]]
		1. [[#OR (`||`)#Example|Example]]
	4. [[#Java Logical Operators in Conditions#NOT (`!`)|NOT (`!`)]]
		1. [[#NOT (`!`)#Example|Example]]
	5. [[#Java Logical Operators in Conditions#Real-Life Example|Real-Life Example]]
		1. [[#Real-Life Example#Example|Example]]
47. [[#Java If ... Else Examples|Java If ... Else Examples]]
	1. [[#Java If ... Else Examples#Real-Life Examples|Real-Life Examples]]
		1. [[#Real-Life Examples#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Real-Life Examples#Example|Example]]
		3. [[#Real-Life Examples#Example|Example]]
		4. [[#Real-Life Examples#Example|Example]]
		5. [[#Real-Life Examples#Example|Example]]
		6. [[#Real-Life Examples#Example|Example]]
		7. [[#Real-Life Examples#Example|Example]]
48. [[#Java Switch|Java Switch]]
	1. [[#Java Switch#Java Switch Statements|Java Switch Statements]]
		1. [[#Java Switch Statements#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Java Switch Statements#Example|Example]]
	2. [[#Java Switch#The break Keyword|The break Keyword]]
	3. [[#Java Switch#The default Keyword|The default Keyword]]
		1. [[#The default Keyword#Example|Example]]
49. [[#Java While Loop|Java While Loop]]
	1. [[#Java While Loop#Loops|Loops]]
	2. [[#Java While Loop#Java While Loop|Java While Loop]]
		1. [[#Java While Loop#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Java While Loop#Example|Example]]
	3. [[#Java While Loop#Countdown Example|Countdown Example]]
		1. [[#Countdown Example#Example|Example]]
	4. [[#Java While Loop#While Loop With False Condition|While Loop With False Condition]]
		1. [[#While Loop With False Condition#Example|Example]]
50. [[#Java Do/While Loop|Java Do/While Loop]]
	1. [[#Java Do/While Loop#The Do/While Loop|The Do/While Loop]]
		1. [[#The Do/While Loop#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Do/While Loop#Do/While Example|Do/While Example]]
		1. [[#Do/While Example#Example|Example]]
	3. [[#Java Do/While Loop#Condition is False from the Start|Condition is False from the Start]]
		1. [[#Condition is False from the Start#Example|Example]]
51. [[#Java While Loop Examples|Java While Loop Examples]]
	1. [[#Java While Loop Examples#Real-Life Examples|Real-Life Examples]]
		1. [[#Real-Life Examples#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Real-Life Examples#Example|Example]]
52. [[#Java For Loop|Java For Loop]]
	1. [[#Java For Loop#Java For Loop|Java For Loop]]
		1. [[#Java For Loop#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java For Loop#Print Numbers|Print Numbers]]
		1. [[#Print Numbers#Example|Example]]
		2. [[#Print Numbers#Example explained|Example explained]]
	3. [[#Java For Loop#Print Even Numbers|Print Even Numbers]]
		1. [[#Print Even Numbers#Example|Example]]
	4. [[#Java For Loop#Sum of Numbers|Sum of Numbers]]
		1. [[#Sum of Numbers#Example|Example]]
	5. [[#Java For Loop#Countdown|Countdown]]
		1. [[#Countdown#Example|Example]]
	6. [[#Java For Loop#For Loop With False Condition|For Loop With False Condition]]
		1. [[#For Loop With False Condition#Example|Example]]
53. [[#Java Nested Loops|Java Nested Loops]]
	1. [[#Java Nested Loops#Nested Loops|Nested Loops]]
		1. [[#Nested Loops#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Nested Loops#Multiplication Table Example|Multiplication Table Example]]
		1. [[#Multiplication Table Example#Example|Example]]
54. [[#Java For Each Loop|Java For Each Loop]]
	1. [[#Java For Each Loop#The for-each Loop|The for-each Loop]]
		1. [[#The for-each Loop#Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#The for-each Loop#Example|Example]]
		3. [[#The for-each Loop#Example|Example]]
55. [[#Java For Loop Examples|Java For Loop Examples]]
	1. [[#Java For Loop Examples#Real-Life Examples|Real-Life Examples]]
		1. [[#Real-Life Examples#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Real-Life Examples#Example|Example]]
		3. [[#Real-Life Examples#Example|Example]]
		4. [[#Real-Life Examples#Example|Example]]
		5. [[#Real-Life Examples#Example|Example]]
56. [[#Java Break and Continue|Java Break and Continue]]
	1. [[#Java Break and Continue#Break|Break]]
		1. [[#Break#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	2. [[#Java Break and Continue#Continue|Continue]]
		1. [[#Continue#Example|Example]]
	3. [[#Java Break and Continue#Combining Break and Continue|Combining Break and Continue]]
		1. [[#Combining Break and Continue#Example|Example]]
	4. [[#Java Break and Continue#Break and Continue in While Loop|Break and Continue in While Loop]]
		1. [[#Break and Continue in While Loop#Break Example|Break Example]]
		2. [[#Break and Continue in While Loop#Continue Example|Continue Example]]
	5. [[#Java Break and Continue#Real-Life Example|Real-Life Example]]
		1. [[#Real-Life Example#Example|Example]]
57. [[#Java Arrays|Java Arrays]]
	1. [[#Java Arrays#Java Arrays|Java Arrays]]
	2. [[#Java Arrays#Access the Elements of an Array|Access the Elements of an Array]]
		1. [[#Access the Elements of an Array#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
	3. [[#Java Arrays#Change an Array Element|Change an Array Element]]
		1. [[#Change an Array Element#Example|Example]]
	4. [[#Java Arrays#Array Length|Array Length]]
		1. [[#Array Length#Example|Example]]
	5. [[#Java Arrays#The `new` Keyword|The `new` Keyword]]
		1. [[#The `new` Keyword#Example|Example]]
		2. [[#The `new` Keyword#Example|Example]]
58. [[#Java Arrays Loop|Java Arrays Loop]]
	1. [[#Java Arrays Loop#Loop Through an Array|Loop Through an Array]]
		1. [[#Loop Through an Array#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Loop Through an Array#Example|Example]]
	2. [[#Java Arrays Loop#Calculate the Sum of Elements|Calculate the Sum of Elements]]
		1. [[#Calculate the Sum of Elements#Example|Example]]
	3. [[#Java Arrays Loop#Loop Through an Array with For-Each|Loop Through an Array with For-Each]]
		1. [[#Loop Through an Array with For-Each#Syntax|Syntax]]
		2. [[#Loop Through an Array with For-Each#Example|Example]]
		3. [[#Loop Through an Array with For-Each#Example|Example]]
59. [[#Java Arrays - Real-Life Examples|Java Arrays - Real-Life Examples]]
	1. [[#Java Arrays - Real-Life Examples#Real-Life Example|Real-Life Example]]
		1. [[#Real-Life Example#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Real-Life Example#Example|Example]]
		3. [[#Real-Life Example#Example|Example]]
		4. [[#Real-Life Example#Example|Example]]
		5. [[#Real-Life Example#Example|Example]]
60. [[#Java Multi-Dimensional Arrays|Java Multi-Dimensional Arrays]]
	1. [[#Java Multi-Dimensional Arrays#Multidimensional Arrays|Multidimensional Arrays]]
	2. [[#Java Multi-Dimensional Arrays#Access Elements|Access Elements]]
		1. [[#Access Elements#Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")|Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")]]
		2. [[#Access Elements#Example|Example]]
	3. [[#Java Multi-Dimensional Arrays#Change Element Values|Change Element Values]]
		1. [[#Change Element Values#Example|Example]]
	4. [[#Java Multi-Dimensional Arrays#Rows and Columns (Lengths)|Rows and Columns (Lengths)]]
		1. [[#Rows and Columns (Lengths)#Example: Sizes|Example: Sizes]]
	5. [[#Java Multi-Dimensional Arrays#Loop Through a Multidimensional Array|Loop Through a Multidimensional Array]]
		1. [[#Loop Through a Multidimensional Array#Example|Example]]
		2. [[#Loop Through a Multidimensional Array#Example|Example]]

# Java Introduction
## What is Java?
Java is a popular and powerful programming language, created in 1995.
It is owned by Oracle, and more than **3 billion** devices run Java.
It is used for:
- Mobile applications (specially Android apps)
- Desktop applications
- Web applications
- Web servers and application servers
- Games
- Database connection
- And much, much more!
## Why Use Java?
- Java works on different platforms (Windows, Mac, Linux, Raspberry Pi, etc.)
- It is one of the most popular programming languages in the world
- It has a large demand in the current job market
- It is easy to learn and simple to use
- It is open-source and free
- It is secure, fast and powerful
- It has huge community support (tens of millions of developers)
- Java is an object oriented language which gives a clear structure to programs and allows code to be reused, lowering development costs
- As Java is close to [C++](https://www.w3schools.com/cpp/default.asp) and [C#](https://www.w3schools.com/cs/default.asp), it makes it easy for programmers to switch to Java or vice versa
## Java Example
Java is often used in everyday programming tasks, like saying hello to a user:
### Example

```java
public class Main {
  public static void main(String[] args) {
    String name = "John";
    System.out.println("Hello " + name);
  }
}
```
Result:
`Hello John`


# Java Syntax
## Java Syntax

In the previous chapter, we created a Java file called `Main.java`, and we used the following code to print "Hello World" to the screen:
### Example
Main.java
```java
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
```
### Example explained

Every line of code that runs in Java must be inside a `class`. The class name should always start with an uppercase first letter. In our example, we named the class **Main**.

**Note:** Java is case-sensitive. `MyClass` and `myclass` would be treated as two completely different names.

The name of the Java file **must match** the class name. So if your class is called `Main`, the file must be saved as `Main.java`. This is because Java uses the class name to find and run your code. If the names don't match, Java will give an error and the program will not run.

When saving the file, save it using the class name and add `.java` to the end of the filename. To run the example above on your computer, make sure that Java is properly installed. The output should be:

`Hello World`

---

## The main Method

The `main()` method is required in every Java program. It is where the program starts running:

```java
public static void main(String[] args)
```

Any code placed inside the `main()` method will be executed.

For now, you don't need to understand the keywords `public`, `static`, and `void`. You will learn about them later in this tutorial. Just remember: `main()` is the starting point of every Java program.

---

---

## System.out.println()

Inside the `main()` method, we can use the `println()` method to print a line of text to the screen:

### Example

```java
public static void main(String[] args) {
  System.out.println("Hello World");
}
```

**Note:** The curly braces `{}` mark the beginning and the end of a block of code.

`System.out.println()` may look long, but you can think of it as a single command that means: **"Send this text to the screen."**

Here's what each part means (you will learn the details later):

- `System` is a built-in Java class.
- `out` is a member of `System`, short for "output".
- `println()` is a method, short for "print line".

Finally, remember that each Java statement must end with a semicolon (`;`).

# Java Statements
## Statements

A **computer program** is a list of "instructions" to be "executed" by a computer.

In a programming language, these programming instructions are called **statements**.

The following statement "instructs" the compiler to print the text "Java is fun!" to the screen:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
System.out.println("Java is fun!");
```

It is important that you end the statement with a semicolon `;`.

If you forget the semicolon (`;`), an error will occur and the program will not run:

### Example

```java
System.out.println("Java is fun!")
```

Result:

`error: ';' expected`

**Tip:** You can think of a statement like a _sentence_ in English. Just as sentences end with a period `.`, Java statements end with a semicolon `;`.

---

---

## Many Statements

Most Java programs contain many statements.

The statements are executed, one by one, in the same order as they are written:

### Example

```java
System.out.println("Hello World!");
System.out.println("Have a good day!");
System.out.println("Learning Java is fun!");
```

#### Example explained

From the example above, we have three statements:

1. `System.out.println("Hello World!");`
2. `System.out.println("Have a good day!");`
3. `System.out.println("Learning Java is fun!");`

The first statement is executed first (print "Hello World!" to the screen).  
Then the second statement is executed (print "Have a good day!" to the screen).  
And at last, the third statement is executed (print "Learning Java is fun!" to the screen).

You will learn more about statements while reading this tutorial. For now, just remember to always end them with a semicolon to avoid any errors.

# Java Output / Print
## Print Text
You learned from the previous chapter that you can use the `println()` method to output values or print text in Java:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
System.out.println("Hello World!");
```

You can add as many `println()` methods as you want. Note that it will add a new line for each method:

### Example

```java
System.out.println("Hello World!");
System.out.println("I am learning Java.");
System.out.println("It is awesome!");
```

---

## Double Quotes

Text must be wrapped inside double quotations marks `""`.

If you forget the double quotes, an error occurs:

### Example

```java
System.out.println("This sentence will work!");
```

```java
System.out.println(This sentence will produce an error);
```

---

---

## The Print() Method

There is also a `print()` method, which is similar to `println()`.

The only difference is that it does not insert a new line at the end of the output:

### Example

```java
System.out.print("Hello World! ");
System.out.print("I will print on the same line.");
```

Note that we add an extra space (after "Hello World!" in the example above) for better readability.

In this tutorial, we will only use `println()` as it makes the code output easier to read.

# Java Output Numbers
## Print Numbers

You can also use the `println()` method to print numbers.

However, unlike text, we don't put numbers inside double quotes:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
System.out.println(3);
System.out.println(358);
System.out.println(50000);
```

You can also perform mathematical calculations inside the `println()` method:

### Example

```java
System.out.println(3 + 3);
```

### Example

```java
System.out.println(2 * 5);
```

# Java Comments
## Java Comments

Comments can be used to explain Java code, and to make it more readable. It can also be used to prevent execution when testing alternative code.

---

## Single-line Comments

Single-line comments start with two forward slashes (`//`).

Any text between `//` and the end of the line is ignored by Java (will not be executed).

This example uses a single-line comment before a line of code:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
// This is a comment
System.out.println("Hello World");
```

This example uses a single-line comment at the end of a line of code:

### Example

```java
System.out.println("Hello World"); // This is a comment
```

---

---

## Java Multi-line Comments

Multi-line comments start with `/*` and ends with `*/`.

Any text between `/*` and `*/` will be ignored by Java.

This example uses a multi-line comment (a comment block) to explain the code:

### Example

```java
/* The code below will print the words Hello World
to the screen, and it is amazing */
System.out.println("Hello World");
```

#### Single or multi-line comments?

It's up to you which one you use. Normally, we use `//` for short comments, and `/* */` for longer.

# Java Variables
## Java Variables

Variables are containers for storing data values.

In Java, there are different **types** of variables, for example:

- `String` - stores text, such as "Hello". String values are surrounded by double quotes
- `int` - stores integers (whole numbers), without decimals, such as 123 or -123
- `float` - stores floating point numbers, with decimals, such as 19.99 or -19.99
- `char` - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
- `boolean` - stores values with two states: true or false

---

## Declaring (Creating) Variables

To create a variable in Java, you need to:

- Choose a **type** (like `int` or `String`)
- Give the variable a **name** (like `x`, `age`, or `name`)
- Optionally assign it a **value** using `=`

Here's the basic syntax:

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
type variableName = value;
```

For example, if you want to store some text, you can use a `String`:

### Example

Create a variable called **name** of type `String` and assign it the value "**John**".  
Then we use `println()` to print the **name** variable:

```java
String name = "John";
System.out.println(name);
```

To create a variable that should store a number, you can use `int`:

### Example

Create a variable called **myNum** of type `int` and assign it the value **15**:

```java
int myNum = 15;
System.out.println(myNum);
```

You can also declare a variable without assigning the value, and assign the value later:

### Example

```java
int myNum;
myNum = 15;
System.out.println(myNum);
```

Note that if you assign a new value to an existing variable, it will overwrite the previous value:

### Example

Change the value of `myNum` from `15` to `20`:

```java
int myNum = 15;
myNum = 20;  // myNum is now 20
System.out.println(myNum);
```

---

---

## Final Variables

If you don't want others (or yourself) to overwrite existing values, use the `final` keyword (this will declare the variable as "final" or "constant", which means unchangeable and read-only):

### Example

```java
final int myNum = 15;
myNum = 20;  // will generate an error: cannot assign a value to a final variable
```

---

## Other Types

A demonstration of how to declare variables of other types:

### Example

```java
int myNum = 5;
float myFloatNum = 5.99f;
char myLetter = 'D';
boolean myBool = true;
String myText = "Hello";
```

You will learn more about [data types](https://www.w3schools.com/java/java_data_types.asp) in the next section.

# Java Print Variables
## Display Variables

The `println()` method is often used to display variables.

To combine both text and a variable, use the `+` character:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
String name = "John";
System.out.println("Hello " + name);
```

You can also use the `+` character to add a variable to another variable:

### Example

```java
String firstName = "John ";
String lastName = "Doe";
String fullName = firstName + lastName;
System.out.println(fullName);
```

In Java, the `+` symbol has two meanings:

- For text (strings), it joins them together (called **concatenation**).
- For numbers, it adds values together.

For numeric values, the `+` character works as a mathematical [operator](https://www.w3schools.com/java/java_operators.asp) (notice that we use `int` (integer) variables here):

### Example

```java
int x = 5;
int y = 6;
System.out.println(x + y); // Print the value of x + y
```

From the example above, here's what happens step by step:

- `x` stores the value 5
- `y` stores the value 6
- `println()` displays the result of `x + y`, which is **11**

---

---

## Mixing Text and Numbers

Be careful when combining text and numbers in the same line of code. Without parentheses, Java will treat the numbers as text after the first string:

### Example

```java
int x = 5;
int y = 6;

System.out.println("The sum is " + x + y);   // Prints: The sum is 56
System.out.println("The sum is " + (x + y)); // Prints: The sum is 11
```

**Explanation:**

In the first line, Java combines `"The sum is "` with `x`, creating the string `"The sum is 5"`. Then `y` is added to that string, so it becomes `"The sum is 56"`.

In the second line, the parentheses make sure `x + y` is calculated first (resulting in `11`), so the output is `"The sum is 11"`.

# Java Declare Multiple Variables
## Declare Many Variables

To declare more than one variable of the **same type**, you can use a comma-separated list:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

Instead of writing:

```java
int x = 5;
int y = 6;
int z = 50;
System.out.println(x + y + z); // 61
```

You can write:

```java
int x = 5, y = 6, z = 50;
System.out.println(x + y + z); // 61
```

**Note:** Declaring many variables in one line is shorter, but writing one variable per line can sometimes make the code easier to read.

---

## One Value to Multiple Variables

You can also assign the **same value** to multiple variables in one line:

### Example

```java
int x, y, z;
x = y = z = 50;
System.out.println(x + y + z); // 150
```

---

# Java Identifiers
## Identifiers

All Java **variables** must be **identified** with **unique names**.

These unique names are called **identifiers**.

Identifiers can be short names (like x and y) or more descriptive names (age, sum, totalVolume).

**Note:** It is recommended to use descriptive names in order to create understandable and maintainable code:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
// Good
int minutesPerHour = 60;

// OK, but not so easy to understand what m actually is
int m = 60;
```

The general rules for naming variables are:

- Names can contain letters, digits, underscores, and dollar signs
- Names must begin with a letter
- Names should start with a lowercase letter, and cannot contain whitespace
- Names can also begin with $ and _
- Names are case-sensitive ("myVar" and "myvar" are different variables)
- Reserved words (like Java keywords, such as `int` or `boolean`) cannot be used as names

---

## Invalid Identifiers

Here are some examples of **invalid** identifiers that would cause errors:

### Example

```java
// Invalid identifiers:
int 2ndNumber = 5;  // Cannot start with a digit
int my var = 10;    // Cannot contain spaces
int int = 20;       // Cannot use reserved keywords
```

# Java Constants (final)
## Constants (final keyword)

When you do not want a variable's value to change, use the `final` keyword.

A variable declared with `final` becomes a **constant**, which means unchangeable and read-only:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
final int myNum = 15;
myNum = 20;  // Error: cannot assign a value to final variable 'myNum'
```

---

## When to Use final?

You should declare variables as `final` when their values should never change. For example, the number of minutes in an hour, or your birth year:

### Example

```java
final int MINUTES_PER_HOUR = 60;
final int BIRTHYEAR = 1980;
```

**Note:** By convention, final variables in Java are usually written in upper case (e.g. `BIRTHYEAR`). It is not required, but useful for code readability and common for many programmers.

# Java Variables - Examples
## Real-Life Examples

Often in our examples, we simplify variable names to match their data type (myInt or myNum for `int` types, myChar for `char` types, and so on). This is done to avoid confusion.

However, for a practical example of using variables, we have created a program that stores different data about a college student:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
// Student data
String studentName = "John Doe";
int studentID = 15;
int studentAge = 23;
float studentFee = 75.25f;
char studentGrade = 'B';

// Print variables
System.out.println("Student name: " + studentName);
System.out.println("Student id: " + studentID);
System.out.println("Student age: " + studentAge);
System.out.println("Student fee: " + studentFee);
System.out.println("Student grade: " + studentGrade);
```

---

## Calculate the Area of a Rectangle

In this real-life example, we create a program to calculate the area of a rectangle (by multiplying the length and width):

### Example

```java
// Create integer variables
int length = 4;
int width = 6;
int area;

// Calculate the area of a rectangle
area = length * width;

// Print variables
System.out.println("Length is: " + length);
System.out.println("Width is: " + width);
System.out.println("Area of the rectangle is: " + area);
```

---

# Java Data Types
## Java Data Types

As explained in the previous chapter, a [variable](https://www.w3schools.com/java/java_variables.asp) in Java must be a specified data type:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int myNum = 5;               // Integer (whole number)
float myFloatNum = 5.99f;    // Floating point number
char myLetter = 'D';         // Character
boolean myBool = true;       // Boolean
String myText = "Hello";     // String
```

Data types are divided into two groups:

- Primitive data types - includes `byte`, `short`, `int`, `long`, `float`, `double`, `boolean` and `char`
- Non-primitive data types - such as `[String](https://www.w3schools.com/java/java_strings.asp)`, [Arrays](https://www.w3schools.com/java/java_arrays.asp) and [Classes](https://www.w3schools.com/java/java_classes.asp) (you will learn more about these in a later chapter)

---

## Primitive Data Types

A primitive data type specifies the type of a variable and the kind of values it can hold.

There are eight primitive data types in Java:

|Data Type|Description|
|---|---|
|`byte`|Stores whole numbers from -128 to 127|
|`short`|Stores whole numbers from -32,768 to 32,767|
|`int`|Stores whole numbers from -2,147,483,648 to 2,147,483,647|
|`long`|Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807|
|`float`|Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits|
|`double`|Stores fractional numbers. Sufficient for storing 15 to 16 decimal digits|
|`boolean`|Stores true or false values|
|`char`|Stores a single character/letter or ASCII values|

---

---

## You Cannot Change the Type

Once a variable is declared with a type, it cannot change to another type later in the program:

### Example

```java
int myNum = 5;       // myNum is an int
// myNum = "Hello";  // Error: cannot assign a String to an int

String myText = "Hi"; // myText is a String
// myText = 123;      // Error: cannot assign a number to a String
```

**Note:** This rule makes Java safer, because the compiler will stop you if you try to mix up types by mistake.

If you really need to change between types, you must use [type casting](https://www.w3schools.com/java/java_type_casting.asp) or conversion methods (for example, turning an `int` into a `double`).

# Java Numbers

---

## Numbers

Primitive number types are divided into two groups:

**Integer types** stores whole numbers, positive or negative (such as 123 or -456), without decimals. Valid types are `byte`, `short`, `int` and `long`. Which type you should use, depends on the numeric value.

**Floating point types** represents numbers with a fractional part, containing one or more decimals. There are two types: `float` and `double`.

Even though there are many numeric types in Java, the most used for numbers are `int` (for whole numbers) and `double` (for floating point numbers). However, we will describe them all as you continue to read.

---

## Integer Types

### Byte

The `byte` data type can store whole numbers from -128 to 127. This can be used instead of `int` or other integer types to save memory when you are certain that the value will be within -128 and 127:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
byte myNum = 100;
System.out.println(myNum);
```

### Short

The `short` data type can store whole numbers from -32768 to 32767:

### Example

```java
short myNum = 5000;
System.out.println(myNum);
```

### Int

The `int` data type can store whole numbers from -2147483648 to 2147483647. In general, and in our tutorial, the `int` data type is the preferred data type when we create variables with a numeric value.

### Example

```java
int myNum = 100000;
System.out.println(myNum);
```

### Long

The `long` data type can store whole numbers from -9223372036854775808 to 9223372036854775807. This is used when int is not large enough to store the value. Note that you should end the value with an "L":

### Example

```java
long myNum = 15000000000L;
System.out.println(myNum);
```

---

---

## Floating Point Types

You should use a floating point type whenever you need a number with a decimal, such as 9.99 or 3.14515.

The `float` and `double` data types can store fractional numbers. Note that you should end the value with an "f" for floats and "d" for doubles:

### Float Example

```java
float myNum = 5.75f;
System.out.println(myNum);
```

### Double Example

```java
double myNum = 19.99d;
System.out.println(myNum);
```

Use `float` or `double`?

The **precision** of a floating point value indicates how many digits the value can have after the decimal point. The precision of `float` is only 6-7 decimal digits, while `double` variables have a precision of about 16 digits.

Therefore it is safer to use `double` for most calculations.

### Scientific Numbers

A floating point number can also be a scientific number with an "e" to indicate the power of 10:

### Example

```java
float f1 = 35e3f;
double d1 = 12E4d;
System.out.println(f1);
System.out.println(d1);
```

# Java Boolean Data Types

---

## Boolean Types

Very often in programming, you will need a data type that can only have one of two values, like:

- YES / NO
- ON / OFF
- TRUE / FALSE

For this, Java has a `boolean` data type, which can only take the values `true` or `false`:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
boolean isJavaFun = true;
boolean isFishTasty = false;
System.out.println(isJavaFun);     // Outputs true
System.out.println(isFishTasty);   // Outputs false
```

Boolean values are mostly used for conditional testing.

You will learn much more about [booleans](https://www.w3schools.com/java/java_booleans.asp) and [conditions](https://www.w3schools.com/java/java_conditions.asp) later in this tutorial.

# Java Characters

---

## Characters

The `char` data type is used to store a **single** character. The character must be surrounded by single quotes, like 'A' or 'c':

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
char myGrade = 'B';
System.out.println(myGrade);
```

Alternatively, if you are familiar with ASCII values, you can use those to display certain characters:

### Example

```java
char myVar1 = 65, myVar2 = 66, myVar3 = 67;
System.out.println(myVar1);
System.out.println(myVar2);
System.out.println(myVar3);
```

**Tip:** A list of all ASCII values can be found in our [ASCII Table Reference](https://www.w3schools.com/charsets/ref_html_ascii.asp).

---

## Strings

The `String` data type is used to store a sequence of characters (text). String values must be surrounded by double quotes:

### Example

```java
String greeting = "Hello World";
System.out.println(greeting);
```

The String type is so much used and integrated in Java, that some call it "the special **ninth** type".

A String in Java is actually a **non-primitive** data type, because it refers to an object. The String object has methods that are used to perform certain operations on strings. **Don't worry if you don't understand the term "object" just yet**. We will learn more about strings and objects in a later chapter.

# Java Data Types Example

---

## Real-Life Example

Here's a real-life example of using different data types, to calculate and output the total cost of a number of items:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
// Create variables of different data types
int items = 50;
float costPerItem = 9.99f;
float totalCost = items * costPerItem;
char currency = '$';

// Print variables
System.out.println("Number of items: " + items);
System.out.println("Cost per item: " + costPerItem + currency);
System.out.println("Total cost = " + totalCost + currency);
```

# Java Non-Primitive Data Types

---

## Non-Primitive Data Types

Non-primitive data types are called **reference types** because they refer to objects.

The main differences between **primitive** and **non-primitive** data types are:

- Primitive types in Java are predefined and built into the language, while non-primitive types are created by the programmer (except for `String`).
- Non-primitive types can be used to call methods to perform certain operations, whereas primitive types cannot.
- Primitive types start with a lowercase letter (like `int`), while non-primitive types typically starts with an uppercase letter (like `String`).
- Primitive types always hold a value, whereas non-primitive types can be `null`.

Examples of non-primitive types are [Strings](https://www.w3schools.com/java/java_strings.asp), [Arrays](https://www.w3schools.com/java/java_arrays.asp), [Classes](https://www.w3schools.com/java/java_classes.asp) etc. You will learn more about these in a later chapter.

# Java var Keyword

---

## The var Keyword

The `var` keyword was introduced in Java 10 (released in 2018).

The `var` keyword lets the compiler automatically detect the type of a variable based on the value you assign to it.

This helps you write cleaner code and avoid repeating types, especially for long or complex types.

**For example**, instead of writing `int x = 5;`, you can write:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
var x = 5;  // x is an int
System.out.println(x);
```

When using `var`, the compiler understands that `5` is an `int`.

---

## Example with Different Types

Here are some examples showing how `var` can be used to create variables of different types, based on the values you assign:

### Example

```java
var myNum = 5;         // int
var myDouble = 9.98;   // double
var myChar = 'D';      // char
var myBoolean = true;  // boolean
var myString = "Hello"; // String
```

---

## Important Notes

1. `var` only works when you assign a value at the same time (you can't declare `var x;` without assigning a value):

var x; // Error  
var x = 5;  // OK

2. Once the type is chosen, it stays the same. See example below:

var x = 5;  // x is now an int  
x = 10;     // OK - still an int  
x = 9.99;   // Error - can't assign a double to an int

---

---

## When to Use var

For simple variables, it's usually clearer to write the type directly (`int`, `double`, `char`, etc.).

But for more complex types, such as `[ArrayList](https://www.w3schools.com/java/java_arraylist.asp)` or `[HashMap](https://www.w3schools.com/java/java_hashmap.asp)`, `var` can make the code shorter and easier to read:

### Example

```java
// Without var
ArrayList<String> cars = new ArrayList<String>();

// With var
var cars = new ArrayList<String>();
```

Don't worry if the example above looks a bit advanced - you will learn more about these complex types later. For now, just remember that `var` was introduced in Java 10, and if you work with others, you might see it in their code - so it's good to know what it means.

# Java Data Types

---

## Java Data Types

As explained in the previous chapter, a [variable](https://www.w3schools.com/java/java_variables.asp) in Java must be a specified data type:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int myNum = 5;               // Integer (whole number)
float myFloatNum = 5.99f;    // Floating point number
char myLetter = 'D';         // Character
boolean myBool = true;       // Boolean
String myText = "Hello";     // String
```

Data types are divided into two groups:

- Primitive data types - includes `byte`, `short`, `int`, `long`, `float`, `double`, `boolean` and `char`
- Non-primitive data types - such as `[String](https://www.w3schools.com/java/java_strings.asp)`, [Arrays](https://www.w3schools.com/java/java_arrays.asp) and [Classes](https://www.w3schools.com/java/java_classes.asp) (you will learn more about these in a later chapter)

---

## Primitive Data Types

A primitive data type specifies the type of a variable and the kind of values it can hold.

There are eight primitive data types in Java:

|Data Type|Description|
|---|---|
|`byte`|Stores whole numbers from -128 to 127|
|`short`|Stores whole numbers from -32,768 to 32,767|
|`int`|Stores whole numbers from -2,147,483,648 to 2,147,483,647|
|`long`|Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807|
|`float`|Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits|
|`double`|Stores fractional numbers. Sufficient for storing 15 to 16 decimal digits|
|`boolean`|Stores true or false values|
|`char`|Stores a single character/letter or ASCII values|

---

---

## You Cannot Change the Type

Once a variable is declared with a type, it cannot change to another type later in the program:

### Example

```java
int myNum = 5;       // myNum is an int
// myNum = "Hello";  // Error: cannot assign a String to an int

String myText = "Hi"; // myText is a String
// myText = 123;      // Error: cannot assign a number to a String
```

**Note:** This rule makes Java safer, because the compiler will stop you if you try to mix up types by mistake.

If you really need to change between types, you must use [type casting](https://www.w3schools.com/java/java_type_casting.asp) or conversion methods (for example, turning an `int` into a `double`).

# Java Numbers

---

## Numbers

Primitive number types are divided into two groups:

**Integer types** stores whole numbers, positive or negative (such as 123 or -456), without decimals. Valid types are `byte`, `short`, `int` and `long`. Which type you should use, depends on the numeric value.

**Floating point types** represents numbers with a fractional part, containing one or more decimals. There are two types: `float` and `double`.

Even though there are many numeric types in Java, the most used for numbers are `int` (for whole numbers) and `double` (for floating point numbers). However, we will describe them all as you continue to read.

---

## Integer Types

### Byte

The `byte` data type can store whole numbers from -128 to 127. This can be used instead of `int` or other integer types to save memory when you are certain that the value will be within -128 and 127:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
byte myNum = 100;
System.out.println(myNum);
```

### Short

The `short` data type can store whole numbers from -32768 to 32767:

### Example

```java
short myNum = 5000;
System.out.println(myNum);
```

### Int

The `int` data type can store whole numbers from -2147483648 to 2147483647. In general, and in our tutorial, the `int` data type is the preferred data type when we create variables with a numeric value.

### Example

```java
int myNum = 100000;
System.out.println(myNum);
```

### Long

The `long` data type can store whole numbers from -9223372036854775808 to 9223372036854775807. This is used when int is not large enough to store the value. Note that you should end the value with an "L":

### Example

```java
long myNum = 15000000000L;
System.out.println(myNum);
```

---

---

## Floating Point Types

You should use a floating point type whenever you need a number with a decimal, such as 9.99 or 3.14515.

The `float` and `double` data types can store fractional numbers. Note that you should end the value with an "f" for floats and "d" for doubles:

### Float Example

```java
float myNum = 5.75f;
System.out.println(myNum);
```

### Double Example

```java
double myNum = 19.99d;
System.out.println(myNum);
```

Use `float` or `double`?

The **precision** of a floating point value indicates how many digits the value can have after the decimal point. The precision of `float` is only 6-7 decimal digits, while `double` variables have a precision of about 16 digits.

Therefore it is safer to use `double` for most calculations.

### Scientific Numbers

A floating point number can also be a scientific number with an "e" to indicate the power of 10:

### Example

```java
float f1 = 35e3f;
double d1 = 12E4d;
System.out.println(f1);
System.out.println(d1);
```

# Java Boolean Data Types

---

## Boolean Types

Very often in programming, you will need a data type that can only have one of two values, like:

- YES / NO
- ON / OFF
- TRUE / FALSE

For this, Java has a `boolean` data type, which can only take the values `true` or `false`:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
boolean isJavaFun = true;
boolean isFishTasty = false;
System.out.println(isJavaFun);     // Outputs true
System.out.println(isFishTasty);   // Outputs false
```

Boolean values are mostly used for conditional testing.

You will learn much more about [booleans](https://www.w3schools.com/java/java_booleans.asp) and [conditions](https://www.w3schools.com/java/java_conditions.asp) later in this tutorial.

# Java Characters

---

## Characters

The `char` data type is used to store a **single** character. The character must be surrounded by single quotes, like 'A' or 'c':

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
char myGrade = 'B';
System.out.println(myGrade);
```

Alternatively, if you are familiar with ASCII values, you can use those to display certain characters:

### Example

```java
char myVar1 = 65, myVar2 = 66, myVar3 = 67;
System.out.println(myVar1);
System.out.println(myVar2);
System.out.println(myVar3);
```

**Tip:** A list of all ASCII values can be found in our [ASCII Table Reference](https://www.w3schools.com/charsets/ref_html_ascii.asp).

---

## Strings

The `String` data type is used to store a sequence of characters (text). String values must be surrounded by double quotes:

### Example

```java
String greeting = "Hello World";
System.out.println(greeting);
```

The String type is so much used and integrated in Java, that some call it "the special **ninth** type".

A String in Java is actually a **non-primitive** data type, because it refers to an object. The String object has methods that are used to perform certain operations on strings. **Don't worry if you don't understand the term "object" just yet**. We will learn more about strings and objects in a later chapter.

# Java Data Types Example

---

## Real-Life Example

Here's a real-life example of using different data types, to calculate and output the total cost of a number of items:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
// Create variables of different data types
int items = 50;
float costPerItem = 9.99f;
float totalCost = items * costPerItem;
char currency = '$';

// Print variables
System.out.println("Number of items: " + items);
System.out.println("Cost per item: " + costPerItem + currency);
System.out.println("Total cost = " + totalCost + currency);
```

# Java Non-Primitive Data Types

---

## Non-Primitive Data Types

Non-primitive data types are called **reference types** because they refer to objects.

The main differences between **primitive** and **non-primitive** data types are:

- Primitive types in Java are predefined and built into the language, while non-primitive types are created by the programmer (except for `String`).
- Non-primitive types can be used to call methods to perform certain operations, whereas primitive types cannot.
- Primitive types start with a lowercase letter (like `int`), while non-primitive types typically starts with an uppercase letter (like `String`).
- Primitive types always hold a value, whereas non-primitive types can be `null`.

Examples of non-primitive types are [Strings](https://www.w3schools.com/java/java_strings.asp), [Arrays](https://www.w3schools.com/java/java_arrays.asp), [Classes](https://www.w3schools.com/java/java_classes.asp) etc. You will learn more about these in a later chapter.

# Java var Keyword

---

## The var Keyword

The `var` keyword was introduced in Java 10 (released in 2018).

The `var` keyword lets the compiler automatically detect the type of a variable based on the value you assign to it.

This helps you write cleaner code and avoid repeating types, especially for long or complex types.

**For example**, instead of writing `int x = 5;`, you can write:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
var x = 5;  // x is an int
System.out.println(x);
```

When using `var`, the compiler understands that `5` is an `int`.

---

## Example with Different Types

Here are some examples showing how `var` can be used to create variables of different types, based on the values you assign:

### Example

```java
var myNum = 5;         // int
var myDouble = 9.98;   // double
var myChar = 'D';      // char
var myBoolean = true;  // boolean
var myString = "Hello"; // String
```

---

## Important Notes

1. `var` only works when you assign a value at the same time (you can't declare `var x;` without assigning a value):

var x; // Error  
var x = 5;  // OK

2. Once the type is chosen, it stays the same. See example below:

var x = 5;  // x is now an int  
x = 10;     // OK - still an int  
x = 9.99;   // Error - can't assign a double to an int

---

---

## When to Use var

For simple variables, it's usually clearer to write the type directly (`int`, `double`, `char`, etc.).

But for more complex types, such as `[ArrayList](https://www.w3schools.com/java/java_arraylist.asp)` or `[HashMap](https://www.w3schools.com/java/java_hashmap.asp)`, `var` can make the code shorter and easier to read:

### Example

```java
// Without var
ArrayList<String> cars = new ArrayList<String>();

// With var
var cars = new ArrayList<String>();
```

Don't worry if the example above looks a bit advanced - you will learn more about these complex types later. For now, just remember that `var` was introduced in Java 10, and if you work with others, you might see it in their code - so it's good to know what it means.

# Java Type Casting

---

## Java Type Casting

Type casting means converting one data type into another. For example, turning an `int` into a `double`.

In Java, there are two main types of casting:

- **Widening Casting** (automatic) - converting a smaller type to a larger type size  
    `byte` -> `short` -> `char` -> `int` -> `long` -> `float` -> `double`  
      
    
- **Narrowing Casting** (manual) - converting a larger type to a smaller type size  
    `double` -> `float` -> `long` -> `int` -> `char` -> `short` -> `byte`

---

## Widening Casting

Widening casting is done automatically when passing a smaller size type into a larger size type.

This works because there is no risk of losing information. For example, an `int` value can safely fit inside a `double`:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int myInt = 9;
double myDouble = myInt; // Automatic casting: int to double

System.out.println(myInt);    // Outputs 9
System.out.println(myDouble); // Outputs 9.0
```

---

## Narrowing Casting

Narrowing casting must be done manually by placing the type in parentheses `()` in front of the value.

This is required because narrowing may result in data loss (for example, dropping decimals when converting a `double` to an `int`):

### Example

```java
double myDouble = 9.78d;
int myInt = (int) myDouble; // Manual casting: double to int

System.out.println(myDouble); // Outputs 9.78
System.out.println(myInt);    // Outputs 9
```

---

---

## Real-Life Example

Here is a real-life example of type casting. We calculate the percentage of a user's score in relation to the maximum score in a game.

We use type casting to make sure that the result is a **floating-point** value, rather than an integer:

### Example

```java
// Set the maximum possible score in the game to 500
int maxScore = 500;

// The actual score of the user
int userScore = 423;

/* Calculate the percentage of the user's score in relation to the maximum available score.
Convert userScore to double to make sure that the division is accurate */
double percentage = (double) userScore / maxScore * 100.0d;

System.out.println("User's percentage is " + percentage);
```

# Java Operators

---

## Java Operators

Operators are used to perform operations on variables and values.

In the example below, we use the `+` **operator** to add together two values:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int x = 100 + 50;
```

Although the `+` operator is often used to add together two values, like in the example above, it can also be used to add together a variable and a value, or a variable and another variable:

### Example

```java
int sum1 = 100 + 50;        // 150 (100 + 50)
int sum2 = sum1 + 250;      // 400 (150 + 250)
int sum3 = sum2 + sum2;     // 800 (400 + 400)
```

Java divides the operators into the following groups:

- [Arithmetic operators](https://www.w3schools.com/java/java_operators_arithmetic.asp)
- [Assignment operators](https://www.w3schools.com/java/java_operators_assign.asp)
- [Comparison operators](https://www.w3schools.com/java/java_operators_comparison.asp)
- [Logical operators](https://www.w3schools.com/java/java_operators_logical.asp)
- Bitwise operators
# Java Arithmetic Operators

---

## Arithmetic Operators

Arithmetic operators are used to perform common mathematical operations.

|Operator|Name|Description|Example|Try it|
|---|---|---|---|---|
|+|Addition|Adds together two values|x + y||
|-|Subtraction|Subtracts one value from another|x - y||
|*|Multiplication|Multiplies two values|x * y||
|/|Division|Divides one value by another|x / y||
|%|Modulus|Returns the division remainder|x % y||
|++|Increment|Increases the value of a variable by 1|++x||
|--|Decrement|Decreases the value of a variable by 1|--x||

Here is an example using different arithmetic operators in one example:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int x = 10;
int y = 3;

System.out.println(x + y); // 13
System.out.println(x - y); // 7
System.out.println(x * y); // 30
System.out.println(x / y); // 3
System.out.println(x % y); // 1

int z = 5;
++z;
System.out.println(z); // 6
--z;
System.out.println(z); // 5
```

**Note:** When dividing two integers in Java, the result will also be an integer. For example, `10 / 3` gives `3`. If you want a decimal result, use `double` values, like `10.0 / 3`.

### Example

```java
int a = 10;
int b = 3;
System.out.println(a / b);   // Integer division, result is 3

double c = 10.0d;
double d = 3.0d;
System.out.println(c / d);   // Decimal division, result is 3.333...
```

---

---

## Incrementing and Decrementing

Incrementing and decrementing are very common in programming, especially when working with counters, loops, and arrays (which you will learn more about in later chapters).

The `++` operator increases a value by 1, while the `--` operator decreases a value by 1:

### Example

```java
int x = 5;

++x; // Increment x by 1
System.out.println(x); // 6
```

### Example

```java
int x = 5;

--x; // Decrement x by 1
System.out.println(x); // 4
```

Sometimes, you might both increment and decrement the same variable. Remember that if you increase a value and later decrease it, it will go up by one and then back down by one - ending up where it started:

### Example

```java
int x = 5;

++x; // Increment x by 1 (x becomes 6)
--x; // Decrement x by 1 (x becomes 5 again)

System.out.println(x); // 5
```

#### Real Life Example: Counting People

Imagine you are building a program to count how many people enter and leave a room. You can use `++` to increase the counter when someone enters, and `--` to decrease it when someone leaves:

### Example

```java
int peopleInRoom = 0;

// 3 people enter
peopleInRoom++;
peopleInRoom++;
peopleInRoom++;

System.out.println(peopleInRoom); // 3

// 1 person leaves
peopleInRoom--;

System.out.println(peopleInRoom); // 2
```

# Java Assignment Operators

---

## Assignment Operators

Assignment operators are used to assign values to variables.

In the example below, we use the **assignment** operator (`=`) to assign the value **10** to a variable called **x**:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int x = 10;
```

The **addition assignment** operator (`+=`) adds a value to a variable:

### Example

```java
int x = 10;
x += 5;
```

A list of all assignment operators:

|Operator|Example|Same As|Try it|
|---|---|---|---|
|=|x = 5|x = 5||
|+=|x += 3|x = x + 3||
|-=|x -= 3|x = x - 3||
|*=|x *= 3|x = x * 3||
|/=|x /= 3|x = x / 3||
|%=|x %= 3|x = x % 3||
|&=|x &= 3|x = x & 3||
|\|=|x \|= 3|x = x \| 3||
|^=|x ^= 3|x = x ^ 3||
|>>=|x >>= 3|x = x >> 3||
|<<=|x <<= 3|x = x << 3||

**Note:** Most assignment operators are just shorter ways of writing code. For example, `x += 5` is the same as `x = x + 5`, but shorter and often easier to read.

---

---

## Real-Life Example: Tracking Savings

Assignment operators can also be used in real-life scenarios. For example, you can use the `+=` operator to keep track of savings when you add money to an account:

### Example

```java
int savings = 100; 
savings += 50; // add 50 to savings
System.out.println("Total savings: " + savings);
```

# Java Comparison Operators

---

## Comparison Operators

Comparison operators are used to compare two values (or variables). This is important in programming, because it helps us to find answers and make decisions.

The return value of a comparison is either `true` or `false`. These values are known as _Boolean values_, and you will learn more about them in the [Booleans](https://www.w3schools.com/java/java_booleans.asp) and [If..Else](https://www.w3schools.com/java/java_conditions.asp) chapter.

In the following example, we use the **greater than** operator (`>`) to find out if 5 is greater than 3:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int x = 5;
int y = 3;
System.out.println(x > y); // returns true, because 5 is higher than 3
```

A list of all comparison operators:

|Operator|Name|Example|Try it|
|---|---|---|---|
|==|Equal to|x == y||
|!=|Not equal|x != y||
|>|Greater than|x > y||
|<|Less than|x < y||
|>=|Greater than or equal to|x >= y||
|<=|Less than or equal to|x <= y||

---

---

## Real-Life Examples

Comparison operators are often used in real-world conditions, such as checking if a person is old enough to vote:

### Example

```java
int age = 18;

System.out.println(age >= 18); // true, old enough to vote
System.out.println(age < 18);  // false
```

Another common use is checking if a password is long enough:

### Example

```java
int passwordLength = 5;

System.out.println(passwordLength >= 8); // false, too short
System.out.println(passwordLength < 8);  // true, needs more characters
```

# Java Logical Operators

---

## Logical Operators

As with [comparison operators](https://www.w3schools.com/java/java_operators_comparison.asp), you can also test for `true` or `false` values with logical operators.

Logical operators are used to determine the logic between variables or values, by combining multiple conditions::

|Operator|Name|Description|Example|Try it|
|---|---|---|---|---|
|&&|Logical and|Returns true if both statements are true|x < 5 &&  x < 10||
|\||Logical or|Returns true if one of the statements is true|x < 5 \| x < 4||
|!|Logical not|Reverse the result, returns false if the result is true|!(x < 5 && x < 10)||

---

## Real-Life Example: Login Check

The example below shows how logical operators can be used in a real situation, e.g. when checking login status and access rights:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
boolean isLoggedIn = true;
boolean isAdmin = false;

System.out.println("Regular user: " + (isLoggedIn && !isAdmin));
System.out.println("Has access: " + (isLoggedIn || isAdmin));
System.out.println("Not logged in: " + (!isLoggedIn));
```

Result:

`Is regular user: true   Has access: true   Not logged in: false`

Logical operators often become easier to understand once you start using them inside `if` statements, which you will learn about in the upcoming chapters

# Java Operator Precedence

---

## Java Operator Precedence

When a calculation contains more than one operator, Java follows **order of operations** rules to decide which part to calculate first.

For example, multiplication happens before addition:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int result1 = 2 + 3 * 4;     // 2 + 12 = 14
int result2 = (2 + 3) * 4;   // 5 * 4 = 20

System.out.println(result1);
System.out.println(result2);
```

### Why Does This Happen?

In `2 + 3 * 4`, the multiplication is done first, so the answer is `14`.

If you want the addition to happen first, you must use parentheses: `(2 + 3) * 4`, which gives `20`.

**Tip:** Always use parentheses `( )` if you want to make sure the calculation is done in the order you expect. It also makes your code easier to read.

---

## Order of Operations

Here are some common operators, from highest to lowest priority:

- `()` - Parentheses
- `*`, `/`, `%` - Multiplication, Division, Modulus
- `+`, `-` - Addition, Subtraction
- `>`, `<`, `>=`, `<=` - Comparison
- `==`, `!=` - Equality
- `&&` - Logical AND
- `||` - Logical OR
- `=` - Assignment

---

## Another Example

Subtraction and addition are done from left to right, unless you add parentheses:

### Example

```java
int result1 = 10 - 2 + 5;    // (10 - 2) + 5 = 13
int result2 = 10 - (2 + 5);  // 10 - 7 = 3

System.out.println(result1);
System.out.println(result2);
```

**Remember:** Parentheses always come first. Use them to control the order of your calculations.

# Java Strings

---

## Java Strings

Strings are used for storing text.

A `String` variable contains a collection of characters surrounded by double quotes (`""`):

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

Create a variable of type `String` and assign it a value:

```java
String greeting = "Hello";
```

---

## String Length

A String in Java is actually an object, which means it contains **methods** that can perform certain operations on strings.

For example, you can find the length of a string with the `length()` method:

### Example

```java
String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
System.out.println("The length of the txt string is: " + txt.length());
```

---

## More String Methods

There are many string methods available in Java.

For example:

- The `toUpperCase()` method converts a string to **upper case** letters.
- The `toLowerCase()` method converts a string to **lower case** letters.

### Example

```java
String txt = "Hello World";
System.out.println(txt.toUpperCase());   // Outputs "HELLO WORLD"
System.out.println(txt.toLowerCase());   // Outputs "hello world"
```

---

## Finding a Character in a String

The `indexOf()` method returns the **index** (the position) of the first occurrence of a specified text in a string (including whitespace):

### Example

```java
String txt = "Please locate where 'locate' occurs!";
System.out.println(txt.indexOf("locate")); // Outputs 7
```

Java counts positions from zero.  
0 is the first position in a string, 1 is the second, 2 is the third ...

You can use the `charAt()` method to access a character at a specific position in a string:

### Example

```java
String txt = "Hello";
System.out.println(txt.charAt(0));  // H
System.out.println(txt.charAt(4));  // o
```

---

---

## Comparing Strings

To compare two strings, you can use the `equals()` method:

### Example

```java
String txt1 = "Hello";
String txt2 = "Hello";

String txt3 = "Greetings";
String txt4 = "Great things";

System.out.println(txt1.equals(txt2));  // true
System.out.println(txt3.equals(txt4));  // false
```

---

## Removing Whitespace

The `trim()` method removes whitespace from the beginning and the end of a string:

### Example

```java
String txt = "   Hello World   ";
System.out.println("Before: [" + txt + "]");
System.out.println("After:  [" + txt.trim() + "]");
```

Result:

`Before: [   Hello World   ]   After: [Hello World]`

---

## Complete String Reference

For a complete reference of String methods, go to our [Java String Methods Reference](https://www.w3schools.com/java/java_ref_string.asp).

The reference contains descriptions and examples of all string methods.

# Java String Concatenation

---

## String Concatenation

The `+` operator can be used between strings to combine them. This is called **concatenation**:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
String firstName = "John";
String lastName = "Doe";
System.out.println(firstName + " " + lastName);
```

Note that we have added an empty text (" ") to create a space between firstName and lastName on print.

---

## Concatenation in Sentences

You can use string concatenation to build sentences with both text and variables:

### Example

```java
String name = "John";
int age = 25;
System.out.println("My name is " + name + " and I am " + age + " years old.");
```

Result:

`My name is John and I am 25 years old.`

---

## The concat() Method

You can also use the `concat()` method to concatenate strings:

### Example

```java
String firstName = "John ";
String lastName = "Doe";
System.out.println(firstName.concat(lastName));
```

You can also join more than two strings by chaining `concat()` calls:

### Example

```java
String a = "Java ";
String b = "is ";
String c = "fun!";
String result = a.concat(b).concat(c);
System.out.println(result);
```

**Note:** While you can use `concat()` to join multiple strings, most developers prefer the `+` operator because it is shorter and easier to read.

# Java Numbers and Strings

---

## Adding Numbers and Strings

WARNING!

Java uses the `+` operator for both addition and concatenation.

Numbers are added. Strings are concatenated.

If you add two numbers, the result will be a number:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int x = 10;
int y = 20;
int z = x + y;  // z will be 30 (an integer/number)
```

If you add two strings, the result will be a string concatenation:

### Example

```java
String x = "10";
String y = "20";
String z = x + y;  // z will be 1020 (a String)
```

If you add a number and a string, the result will be a string concatenation:

### Example

```java
String x = "10";
int y = 20;
String z = x + y;  // z will be 1020 (a String)
```

# Java Special Characters

---

## Strings - Special Characters

Because strings must be written within quotes, Java will misunderstand this string, and generate an error:

```java
String txt = "We are the so-called "Vikings" from the north.";
```

The solution to avoid this problem, is to use the **backslash escape character**.

The backslash (`\`) escape character turns special characters into string characters:

|Escape character|Result|Description|
|---|---|---|
|\'|'|Single quote|
|\"|"|Double quote|
|\\|\|Backslash|

The sequence `\"`  inserts a double quote in a string:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
String txt = "We are the so-called \"Vikings\" from the north.";
```

The sequence `\'`  inserts a single quote in a string:

### Example

```java
String txt = "It\'s alright.";
```

The sequence `\\`  inserts a single backslash in a string:

### Example

```java
String txt = "The character \\ is called backslash.";
```

Other common escape sequences that are valid in Java are:

|Code|Result|Try it|
|---|---|---|
|\n|New Line||
|\t|Tab||
|\b|Backspace||
|\r|Carriage Return||
|\f|Form Feed||

**Note:** Most of these escape codes are rarely used in modern programming. The most common ones are `\n` (new line), `\"` (double quote), and `\\` (backslash).

# Java Math

---

The Java Math class has many methods that allows you to perform mathematical tasks on numbers.

---

## Math.max(_x,y_)

The `Math.max(_x_,_y_)` method can be used to find the highest value of _x_ and _y_:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
Math.max(5, 10);
```

---

## Math.min(_x,y_)

The `Math.min(_x_,_y_)` method can be used to find the lowest value of _x_ and _y_:

### Example

```java
Math.min(5, 10);
```

---

## Math.sqrt(_x_)

The `Math.sqrt(_x_)` method returns the square root of _x_:

### Example

```java
Math.sqrt(64);
```

---

---

## Math.abs(_x_)

The `Math.abs(_x_)` method returns the absolute (positive) value of _x_:

### Example

```java
Math.abs(-4.7);
```

---

## Math.pow(_x, y_)

The `Math.pow(_x, y_)` method returns the value of _x_ raised to the power of _y_:

### Example

```java
Math.pow(2, 8);  // 256.0
```

**Note:** `Math.pow(2, 8)` means `2` multiplied by itself 8 times:  
2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 = 256

**Note:** The `Math.pow()` method always returns a `double`, even if the result is a whole number. For example, `Math.pow(2, 8)` returns `256.0` (not `256`).

---

## Rounding Methods

Java has several methods for rounding numbers:

- `Math.round(x)` - rounds to the nearest integer
- `Math.ceil(x)` - rounds up (returns the smallest integer greater than or equal to x)
- `Math.floor(x)` - rounds down (returns the largest integer less than or equal to x)

### Example

```java
Math.round(4.6);  // 5
Math.ceil(4.1);   // 5.0
Math.floor(4.9);  // 4.0
```

---

## Random Numbers

`Math.random()` returns a random number between 0.0 (inclusive), and 1.0 (exclusive):

### Example

```java
Math.random();
```

To get more control over the random number, for example, if you only want a random number between 0 and 100, you can use the following formula:

### Example

```java
int randomNum = (int)(Math.random() * 101);  // 0 to 100
```

**Note:** `Math.random()` returns a `double`. To get an integer, you need to [cast](https://www.w3schools.com/java/java_type_casting.asp) it with `(int)`.

---

## Complete Math Reference

For a complete reference of Math methods, go to our [Java Math Methods Reference](https://www.w3schools.com/java/java_ref_math.asp).

# Java Booleans

---

## Java Booleans

Very often in programming, you will need a data type that can only have one of two values, like:

- YES / NO
- ON / OFF
- TRUE / FALSE

For this, Java has a `boolean` data type, which can store `true` or `false` values.

The name **boolean** comes from _George Boole_, a mathematician who first defined the logic system used in computers today.

---

## Boolean Values

A boolean type is declared with the `boolean` keyword and can only take the values `true` or `false`:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
boolean isJavaFun = true;
boolean isFishTasty = false;

System.out.println(isJavaFun);    // Outputs true
System.out.println(isFishTasty);  // Outputs false
```

In practice, booleans are most often the result of expressions, and are used to test conditions in programs (see below).

---

## Boolean Expressions

A boolean expression returns a boolean value: `true` or `false`.

This is useful to build logic and make decisions in programs.

For example, you can use a [comparison operator](https://www.w3schools.com/java/java_operators.asp), such as the **greater than** (`>`) operator, to find out if an expression (or a variable) is true or false:

### Example

```java
int x = 10;
int y = 9;

System.out.println(x > y); // Outputs true, because 10 is greater than 9
```

Or even easier:

### Example

```java
System.out.println(10 > 9); // Outputs true, because 10 is greater than 9
```

In the examples below, we use the **equal to** (`==`) operator to evaluate an expression:

### Example

```java
int x = 10;

System.out.println(x == 10); // Outputs true, because the value of x is equal to 10
```

### Example

```java
System.out.println(10 == 15); // Outputs false, because 10 is not equal to 15
```

---

---

## Store the Result in a Boolean Variable

You can also store the result of a comparison in a `boolean` variable:

### Example

```java
int x = 10;
int y = 9;

boolean isGreater = x > y;

System.out.println(isGreater); // Outputs true
```

**Note:** It is up to you whether you store the result of a comparison in a boolean variable or use the comparison directly.  
Storing the result can make your code easier to read, especially if you want to reuse it.

# Java Boolean Examples

---

## Real Life Example

Let's use booleans in a real-life example where we want to find out if a person is old enough to vote.

In the example below, we use the `>=` comparison operator to find out if the age (`25`) is **greater than** OR **equal to** the voting age limit, which is set to `18`:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int myAge = 25;
int votingAge = 18;
System.out.println(myAge >= votingAge);
```

An even better approach would be to wrap the code above in an `if...else` statement, so we can perform different actions depending on the result:

### Example

Output "Old enough to vote!" if `myAge` is **greater than or equal to** `18`. Otherwise output "Not old enough to vote.":

```java
int myAge = 25;
int votingAge = 18;

if (myAge >= votingAge) {
  System.out.println("Old enough to vote!");
} else {
  System.out.println("Not old enough to vote.");
}
```

Booleans are the basis for all Java comparisons and conditions.

You will learn more about [conditions (`if...else`)](https://www.w3schools.com/java/java_conditions.asp) in the next chapter.

# Java If ... Else

---

## Java Conditions and If Statements

Conditions and if statements let you control the flow of your program - deciding which code runs, and which code is skipped.

Think of it like real life: _If it rains, take an umbrella. Otherwise, do nothing._

Every `if` statement needs a condition that results in `true` or `false`.

This means `if` statements work hand-in-hand with `[boolean](https://www.w3schools.com/java/java_booleans.asp)` values:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
boolean isRaining = true;

if (isRaining) {
  System.out.println("Bring an umbrella!");
}
```

Most often, conditions are created using comparison operators, like the ones below:

- Less than: a < b
- Less than or equal to: a <= b
- Greater than: a > b
- Greater than or equal to: a >= b
- Equal to: a == b
- Not equal to: a != b

You can use these conditions to perform different actions for different decisions.

Java has the following conditional statements:

- Use `if` to specify a block of code to be executed, if a specified condition is true
- Use [`else`](https://www.w3schools.com/java/java_conditions_else.asp) to specify a block of code to be executed, if the same condition is false
- Use [`else if`](https://www.w3schools.com/java/java_conditions_elseif.asp) to specify a new condition to test, if the first condition is false
- Use [`switch`](https://www.w3schools.com/java/java_switch.asp) to specify many alternative blocks of code to be executed

---

## The if Statement

The `if` statement specifies a block of code to be executed if a condition is `true`:

### Syntax

```java
if (condition) {
  // block of code to be executed if the condition is true
}
```

The _condition_ inside the `if` statement must result in a `boolean` value - it can be either a boolean expression (like `x > y`) or a boolean variable (like `isLightOn`).

Also note that `if` is in lowercase letters. Uppercase letters (If or IF) will generate an error.

In the example below, we test two values to find out if 20 is greater than 18. If the condition is `true`, print some text:

### Example

```java
if (20 > 18) {
  System.out.println("20 is greater than 18");
}
```

You can also compare variables:

### Example

```java
int x = 20;
int y = 18;
if (x > y) {
  System.out.println("x is greater than y");
}
```

### Example explained

In the example above we use two variables, **x** and **y**, to test whether x is greater than y (using the `>` operator). As x is 20, and y is 18, and we know that 20 is greater than 18, we print to the screen that "x is greater than y".

Comparison is also often used to check if two values are _equal_, using the `==` operator:

### Example

```java
int x = 20;
int y = 20;
if (x == y) {
  System.out.println("x is equal to y");
}
```

Here the condition `x == y` is true, because both `x` and `y` are 20, so the message "x is equal to y" is printed.

---

---

## Using Boolean Variables

You can also test boolean variables directly in an `if` statement:

### Example

```java
boolean isLightOn = true;

if (isLightOn) {
  System.out.println("The light is on.");
}
```

**Note:** Writing `if (isLightOn)` is the same as writing `if (isLightOn == true)`, but shorter and easier to read.

Here is the same example with the value `false` to see that the program continues even when the code block does not run:

### Example

```java
boolean isLightOn = false;

if (isLightOn) {
  System.out.println("The light is on.");  // This will not be printed
}

System.out.println("This line runs no matter what, because it is outside the if statement.");
```

---

## If Without Braces

If an `if` statement has only one line of code, you can write it without curly braces `{ }`:

### Example

```java
if (20 > 18)
  System.out.println("20 is greater than 18");
```

### Potential Problem

Without braces, only the **first line** after the `if` belongs to it. Any other lines will run no matter what, which can lead to unexpected results:

### Example

```java
int x = 20;
int y = 18;

if (x > y)
  System.out.println("x is greater than y");  // Belongs to if
  System.out.println("This line runs no matter what (not part of the if statement)");

// Output:
// x is greater than y
// This line runs no matter what (not part of the if statement)
```

### The Safe Way

To avoid mistakes, always use curly braces `{ }`. This makes it clear which lines belong to the `if` statement:

### Example

```java
int x = 20;
int y = 18;

if (x > y) {
  System.out.println("x is greater than y");
  System.out.println("Both lines are part of the if");
}

// Some code outside if
System.out.println("I am outside if, not part of if!");
```

**Tip:** Always using braces `{ }` makes your code clearer, easier to read, and prevents subtle bugs.

---

In the next chapters, you will also learn how to handle `else` (when the condition is false), `else if` (to test multiple conditions), and `switch` (to handle many possible values).


# Java Else

---

## The else Statement

The `else` statement lets you run a block of code when the condition in the `[if](https://www.w3schools.com/java/java_conditions.asp)` statement is `false`.

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
if (condition) {
  // block of code to be executed if the condition is true
} else {
  // block of code to be executed if the condition is false
}
```

Think of it like real life: _If it rains, bring an umbrella. **Otherwise (else)**, go outside without one_:

### Example

```java
boolean isRaining = false;

if (isRaining) {
  System.out.println("Bring an umbrella!");
} else {
  System.out.println("No rain today, no need for an umbrella!");
} 
```

Since `isRaining` is false, the condition inside the `if` statement is not met. That means the `if` block is skipped, and the `else` block runs instead, printing "No rain today, no need for an umbrella!".

---

## Another Example

This example says good day or good evening depending on the time:

### Example

```java
int time = 20;

if (time < 18) {
  System.out.println("Good day.");
} else {
  System.out.println("Good evening.");
}
// Outputs "Good evening."
 
```

#### Example explained

In the example above, time (20) is greater than 18, so the condition is `false`. Because of this, we move on to the `else` condition and print to the screen "Good evening". If the time was less than 18, the program would print "Good day".

### Notes

- `else` does not have a condition - it runs when the `if` condition is `false`.
- Do not put a semicolon right after `if (condition)`. That would end the statement early and make `else` behave unexpectedly.

# Java Else If

---

## The else if Statement

Use the `else if` statement to specify a new condition to test if the first condition is `false`.

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
if (condition1) {
  // block of code to be executed if condition1 is true
} else if (condition2) {
  // block of code to be executed if condition1 is false and condition2 is true
} else {
  // block of code to be executed if both conditions are false
}
```

Think of it like real life: _If it rains, bring an umbrella. **Else if** it is sunny, wear sunglasses. Else, just go outside normally._

---

## Example

### Example

```java
int weather = 2; // 1 = raining, 2 = sunny, 3 = cloudy

if (weather == 1) {
  System.out.println("Bring an umbrella.");
} else if (weather == 2) {
  System.out.println("Wear sunglasses.");
} else {
  System.out.println("Just go outside normally.");
}
// Outputs "Wear sunglasses."
 
```

Since `weather` is `2`, the first condition (`weather == 1`) is not met, so the `if` block is skipped. The program then checks the `else if` condition (`weather == 2`), which is `true`. That means the `else if` block runs and prints "Wear sunglasses.".

---

---

## Another Example

This example chooses between three different messages depending on the time of day:

### Example

```java
int time = 16;

if (time < 12) {
  System.out.println("Good morning.");
} else if (time < 18) {
  System.out.println("Good day.");
} else {
  System.out.println("Good evening.");
}
// Outputs "Good day."
 
```

#### Example explained

The value of `time` is 16. The first condition (`time < 12`) is false, but the second condition (`time < 18`) is true. Because of this, the `else if` block runs and prints "Good day.".

If the value of `time` was 22, none of the conditions would be true, and the program would print "Good evening." instead:

### Example

```java
int time = 22;

if (time < 12) {
  System.out.println("Good morning.");
} else if (time < 18) {
  System.out.println("Good day.");
} else {
  System.out.println("Good evening.");
}
// Outputs "Good day." 
```

# Java Short Hand If...Else (Ternary Operator)

---

## Short Hand if...else

There is also a short-hand [if else](https://www.w3schools.com/java/java_conditions_else.asp), which is known as the **ternary operator** because it consists of three operands.

It can be used to replace multiple lines of code with a single line, and is most often used to replace simple if else statements:

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

_```java
variable = (condition) ? expressionTrue :  expressionFalse;
```_

Instead of writing:

### Example

```java
int time = 20;
if (time < 18) {
  System.out.println("Good day.");
} else {
  System.out.println("Good evening.");
}
```

You can simply write:

### Example

```java
int time = 20;
String result = (time < 18) ? "Good day." : "Good evening.";
System.out.println(result);
```

You can also use the ternary operator directly inside `System.out.println()` without a temporary variable:

### Example

```java
int time = 20;
System.out.println((time < 18) ? "Good day." : "Good evening.");
```

---

---

## Nested Ternary (Optional)

You can nest ternary operators to handle more than two possible outcomes, but this can make your code harder to read:

### Example

```java
int time = 22;
String message = (time < 12) ? "Good morning."
               : (time < 18) ? "Good afternoon."
               : "Good evening.";
System.out.println(message);
```

**Tip:** Use the ternary operator for short, simple choices. For longer or more complex logic, the regular `if...else` is easier to read.

# Java Nested If

---

## Nested If

You can also place an `if` statement inside another `if`. This is called a **nested if** statement.

A nested `if` lets you check for a condition only if another condition is already `true`.

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
if (condition1) {
  // code to run if condition1 is true
  if (condition2) {
    // code to run if both condition1 and condition2 are true
  }
}
```

---

## Example

In this example, we first check if `x` is greater than 10. If it is, we then check if `y` is greater than 20:

### Example

```java
int x = 15;
int y = 25;

if (x > 10) {
  System.out.println("x is greater than 10");
  
  // Nested if 
  if (y > 20) {
    System.out.println("y is also greater than 20");
  }
}
```

Result:

`x is greater than 10   y is also greater than 20`

---

---

## Real-Life Example

Nested `if` statements are useful when you need to test multiple conditions that depend on each other. For example, checking if a person is old enough to vote, and if they are a citizen:

### Example

```java
int age = 20;
boolean isCitizen = true;

if (age >= 18) {
  System.out.println("Old enough to vote.");
  
  if (isCitizen) {
    System.out.println("And you are a citizen, so you can vote!");
  } else {
    System.out.println("But you must be a citizen to vote.");
  }
} else {
  System.out.println("Not old enough to vote.");
}
```

Result:

`Old enough to vote.   And you are a citizen, so you can vote!`

---

## Notes

- You can nest as many `if` statements as you want, but avoid making the code too deep - it can become hard to read.
- Nested `if` is often used together with `else` and `else if` for more complex decision making.

# Java Logical Operators in Conditions

---

## Logical Operators in Conditions

You can combine or reverse conditions using [logical operators](https://www.w3schools.com/java/java_operators.asp). These work together with `if`, `else`, and `else if` to build more complex decisions.

- `&&` (AND) - all conditions must be true
- `||` (OR) - at least one condition must be true
- `!` (NOT) - reverses a condition (true = false, false = true)

---

## AND (`&&`)

Use AND (`&&`) when **both** conditions must be true:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

Test if `a` is greater than `b`, **and** if `c` is greater than `a`:

```java
int a = 200;
int b = 33;
int c = 500;

if (a > b && c > a) {
  System.out.println("Both conditions are true");
}
```

---

## OR (`||`)

Use OR (`||`) when **at least one** of the conditions can be true:

### Example

Test if `a` is greater than `b`, **or** if `a` is greater than `c`:

```java
int a = 200;
int b = 33;
int c = 500;

if (a > b || a > c) {
  System.out.println("At least one condition is true");
}
```

---

---

## NOT (`!`)

Use NOT (`!`) to **reverse** a condition:

### Example

Test if `a` is **not** greater than `b`:

```java
int a = 33;
int b = 200;

if (!(a > b)) {
  System.out.println("a is NOT greater than b");
}
```

---

## Real-Life Example

In real programs, logical operators are often used for access control. For example, to get access to a system, there are specific requirements:

You must be logged in, and then you either need to be an admin, or have a high security clearance (level 1 or 2):

### Example

```java
boolean isLoggedIn = true;
boolean isAdmin = false;
int securityLevel = 3; // 1 = highest

if (isLoggedIn && (isAdmin || securityLevel <= 2)) {
  System.out.println("Access granted");
} else {
  System.out.println("Access denied");
}

// Try changing securityLevel to test different outcomes:
//
// securityLevel 1 = Access granted
// securityLevel 2 = Access granted
// securityLevel 3 = Access denied
// securityLevel 4 = Access denied
//
// If isAdmin = true, access is granted.
```

# Java If ... Else Examples

---

## Real-Life Examples

This example shows how you can use **if..else** to "open a door" if the user enters the correct code:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int doorCode = 1337;

if (doorCode == 1337) {
  System.out.println("Correct code. The door is now open.");
} else {
  System.out.println("Wrong code. The door remains closed.");
}
```

This example shows how you can use **if..else** to find out if a number is positive or negative:

### Example

```java
int myNum = 10; // Is this a positive or negative number?

if (myNum > 0) {
  System.out.println("The value is a positive number.");
} else if (myNum < 0) {
  System.out.println("The value is a negative number.");
} else {
  System.out.println("The value is 0.");
}
```

Find out if a person is old enough to vote:

### Example

```java
int myAge = 25;
int votingAge = 18;

if (myAge >= votingAge) {
  System.out.println("Old enough to vote!");
} else {
  System.out.println("Not old enough to vote.");
}
```

Find out if a person is old enough to vote, **and** if they are a citizen (using nested if statements):

### Example

```java
int age = 20;
boolean isCitizen = true;

if (age >= 18) {
  System.out.println("Old enough to vote.");
  
  if (isCitizen) {
    System.out.println("And you are a citizen, so you can vote!");
  } else {
    System.out.println("But you must be a citizen to vote.");
  }
} else {
  System.out.println("Not old enough to vote.");
}
```

Find out if a number is even or odd:

### Example

```java
int myNum = 5;

if (myNum % 2 == 0) {
  System.out.println(myNum + " is even");
} else {
  System.out.println(myNum + " is odd");
} 
```

Check temperature:

### Example

```java
int temperature = 30;

if (temperature < 0) {
  System.out.println("It's freezing!");
} else if (temperature < 20) {
  System.out.println("It's cool.");
} else {
  System.out.println("It's warm.");
} 
```

System access control example - You must be logged in, and then you either need to be an admin, or have a high security clearance (level 1 or 2) to get access:

### Example

```java
boolean isLoggedIn = true;
boolean isAdmin = false;
int securityLevel = 3; // 1 = highest

if (isLoggedIn && (isAdmin || securityLevel <= 2)) {
  System.out.println("Access granted");
} else {
  System.out.println("Access denied");
}

// Try changing securityLevel to test different outcomes:
//
// securityLevel 1 = Access granted
// securityLevel 2 = Access granted
// securityLevel 3 = Access denied
// securityLevel 4 = Access denied
//
// If isAdmin = true, access is granted.
```

---

# Java Switch

---

## Java Switch Statements

Instead of writing **many** `if..else` statements, you can use the `switch` statement.

Think of it like ordering food in a restaurant: _If you choose number 1, you get Pizza. If you choose 2, you get a Burger. If you choose 3, you get Pasta. Otherwise, you get nothing_.

The `switch` statement selects one of many code blocks to be executed:

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
switch(expression) {
  case x:
    // code block
    break;
  case y:
    // code block
    break;
  default:
    // code block
}
```

This is how it works:

- The `switch` expression is evaluated once.
- The result is compared with each `case` value.
- If there is a match, the matching block of code runs.
- The `break` statement stops the switch after the matching case has run.
- The `default` statement runs if there is no match.

The example below uses the weekday number to calculate the weekday name:

### Example

```java
int day = 4;
switch (day) {
  case 1:
    System.out.println("Monday");
    break;
  case 2:
    System.out.println("Tuesday");
    break;
  case 3:
    System.out.println("Wednesday");
    break;
  case 4:
    System.out.println("Thursday");
    break;
  case 5:
    System.out.println("Friday");
    break;
  case 6:
    System.out.println("Saturday");
    break;
  case 7:
    System.out.println("Sunday");
    break;
}
// Outputs "Thursday" (day 4)
```

---

## The break Keyword

When Java reaches a `break` keyword, it breaks out of the switch block.

This will stop the execution of more code and case testing inside the block.

When a match is found, and the job is done, it's time for a break. There is no need for more testing.

A break can save a lot of execution time because it "ignores" the execution of all the rest of the code in the switch block.

---

---

## The default Keyword

The `default` keyword specifies some code to run if there is no case match:

### Example

```java
int day = 4;
switch (day) {
  case 6:
    System.out.println("Today is Saturday");
    break;
  case 7:
    System.out.println("Today is Sunday");
    break;
  default:
    System.out.println("Looking forward to the Weekend");
}
// Outputs "Looking forward to the Weekend"
 
```

Note that if the `default` statement is used as the last statement in a switch block, it does not need a break.

# Java While Loop

---

## Loops

Loops can execute a block of code as long as a specified condition is true.

Loops are handy because they save time, reduce errors, and they make code more readable.

---

## Java While Loop

The `while` loop repeats a block of code as long as the specified condition is **true**:

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
while (condition) {
  // code block to be executed
}
```

In the example below, the code in the loop will run again and again, as long as a variable (`i`) is less than 5:

### Example

```java
int i = 0;
while (i < 5) {
  System.out.println(i);
  i++;
}
```

**Note:** Do not forget to increase the variable used in the condition (`i++`), otherwise the loop will never end!

Do you wonder why we used the letter `i` in the example above? It's a **counter** variable and a common choice in simple loops because it's short, traditional, and stands for 'index' or 'iterator'.

---

## Countdown Example

You can also use a `while` loop to count down. This example counts from 3 to 1, and then prints "Happy New Year!!" at the end:

### Example

```java
int countdown = 3;

while (countdown > 0) {
  System.out.println(countdown);
  countdown--;
}

System.out.println("Happy New Year!!");
```

---

---

## While Loop With False Condition

In the previous examples, the condition was **true** at the start, so the loop ran one or more times. But if the condition is **false** at the beginning, the code inside the loop will never run:

### Example

```java
int i = 10;

while (i < 5) {
  System.out.println("This will never be printed");
  i++;
}
```

**Note:** A `while` loop may never run if the condition is false from the start. In the next chapter, you will learn about the [`do while`](https://www.w3schools.com/java/java_while_loop_do.asp) loop, which always runs the code at least once before checking the condition.

# Java Do/While Loop

---

## The Do/While Loop

The `do/while` loop is a variant of the `while` loop. This loop will execute the code block **once**, before checking if the condition is **true**. Then it will repeat the loop as long as the condition is **true**.

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
do {
  // code block to be executed
}
while (condition);
```

**Note:** The semicolon `;` after the `while` condition is required!

---

## Do/While Example

The example below uses a `do/while` loop. The loop will always be executed at least once, even if the condition is **false**, because the code block is executed before the condition is tested:

### Example

```java
int i = 0;do {
  System.out.println(i);
  i++;
}
while (i < 5);
```

Do not forget to increase the variable used in the condition (`i++`), otherwise the loop will never end!

---

## Condition is False from the Start

In the `while` loop chapter, we saw that if the condition is **false** at the beginning, the loop never runs at all.

The `do/while` loop is different: it will always run the code block **at least once**, even if the condition is **false** from the start.

In the example below, the variable `i` starts at 10, so `i < 5` is false immediately. Still, the loop runs once before checking the condition:

### Example

```java
int i = 10;

do {
  System.out.println("i is " + i);
  i++;
} while (i < 5);
```

**Summary:** A `do/while` loop always runs at least once, even if the condition is false at the start. This is the key difference from a `while` loop, which would skip the code block completely in the same situation.

This behavior makes `do/while` useful when you want something to happen at least once, such as showing a message or asking the user for input.

---

# Java While Loop Examples

---

## Real-Life Examples

To demonstrate a practical example of the **while loop**, we have created a simple "countdown" program:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int countdown = 3;

while (countdown > 0) {
  System.out.println(countdown);
  countdown--;
}

System.out.println("Happy New Year!!");
```

To demonstrate a practical example of the **while loop** combined with an **if else statement**, let's say we play a game of Yatzy:

### Example

Print "Yatzy!" If the dice number is 6:

```java
int dice = 1;

while (dice <= 6) {
  if (dice < 6) {
    System.out.println("No Yatzy.");
  } else {
    System.out.println("Yatzy!");
  }
  dice = dice + 1;
}
```

If the loop passes the values ranging from 1 to 5, it prints "No Yatzy". Whenever it passes the value 6, it prints "Yatzy!".

# Java For Loop

---

## Java For Loop

When you know exactly how many times you want to loop through a block of code, use the `for` loop instead of a [`while`](https://www.w3schools.com/java/java_while_loop.asp) loop:

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
for (statement 1; statement 2; statement 3) {
  // code block to be executed
}
```

**Statement 1** is executed (one time) before the execution of the code block.

**Statement 2** defines the condition for executing the code block.

**Statement 3** is executed (every time) after the code block has been executed.

---

## Print Numbers

The example below will print the numbers 0 to 4:

### Example

```java
for (int i = 0; i < 5; i++) {  System.out.println(i);}
```

### Example explained

- **Statement 1** sets a variable before the loop starts: `int i = 0`
- **Statement 2** defines the condition for the loop to run: `i < 5`. If the condition is true, the loop will run again; if it is false, the loop ends.
- **Statement 3** increases a value each time the code block has run: `i++`

---

## Print Even Numbers

This example prints even values between 0 and 10:

### Example

```java
for (int i = 0; i <= 10; i = i + 2) {  System.out.println(i);}
```

---

---

## Sum of Numbers

This example calculates the sum of numbers from 1 to 5:

### Example

```java
int sum = 0;for (int i = 1; i <= 5; i++) {  sum = sum + i;}System.out.println("Sum is " + sum);
```

---

## Countdown

This example prints a countdown from 5 to 1:

### Example

```java
for (int i = 5; i > 0; i--) {  System.out.println(i);}
```

---

## For Loop With False Condition

Just like a `while` loop, a `for` loop may also never run. If the condition is `false` right from the start, the code inside the loop will be skipped entirely:

### Example

```java
for (int i = 10; i < 5; i++) {
  System.out.println("This will never be printed");
}
```

In this example, the loop starts with `i = 10`. The condition `i < 5` is already false, so the loop body is skipped, and nothing is printed.

# Java Nested Loops

---

## Nested Loops

It is also possible to place a loop inside another loop. This is called a **nested loop**.

The "inner loop" will be executed one time for each iteration of the "outer loop":

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
// Outer loop
for (int i = 1; i <= 2; i++) {
  System.out.println("Outer: " + i); // Executes 2 times
  
  // Inner loop
  for (int j = 1; j <= 3; j++) {
    System.out.println(" Inner: " + j); // Executes 6 times (2 * 3)
  }
} 
```

---

## Multiplication Table Example

This example uses nested loops to print a simple multiplication table (1 to 3):

### Example

```java
for (int i = 1; i <= 3; i++) {  for (int j = 1; j <= 3; j++) {    System.out.print(i * j + " ");  }  System.out.println();}
```

```
1 2 3
2 4 6
3 6 9
```

Nested loops are useful when working with tables, matrices, or [multi-dimensional data structures](https://www.w3schools.com/java/java_arrays_multi.asp).

# Java For Each Loop

---

## The for-each Loop

There is also a "**for-each**" loop, which is used exclusively to loop through elements in an [**array**](https://www.w3schools.com/java/java_arrays.asp) (or other [data structures](https://www.w3schools.com/java/java_data_structures.asp)):

### Syntax[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
for (type variableName : arrayName) {
  // code block to be executed
}
```

The **for-each** loop is simpler and more readable than a regular `for` loop, since you don't need a counter (like `i < array.length`).

The following example prints all elements in the **cars** array:

### Example

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

for (String car : cars) {
  System.out.println(car);
}
```

Here is a similar example with numbers. We create an array of integers and use a **for-each** loop to print each value:

### Example

```java
int[] numbers = {10, 20, 30, 40};

for (int num : numbers) {
  System.out.println(num);
}
```

**Note:** Don't worry if you don't fully understand arrays yet. You will learn more about them in the [Java Arrays chapter](https://www.w3schools.com/java/java_arrays.asp).

# Java For Loop Examples

---

## Real-Life Examples

To demonstrate a practical example of the **for loop**, let's create a program that counts to 100 by tens:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
for (int i = 0; i <= 100; i += 10) {
  System.out.println(i);
} 
```

In this example, we create a program that only print even values between 0 and 10:

### Example

```java
for (int i = 0; i <= 10; i = i + 2) {
  System.out.println(i);
}
```

And in this example, we create a program that prints the multiplication table for a specified number:

### Example

```java
int number = 2;

// Print the multiplication table for the number 2
for (int i = 1; i <= 10; i++) {
  System.out.println(number + " x " + i + " = " + (number * i));
} 
```

Here is a simple program that prints the seat numbers in a theater row:

### Example

```java
for (int seat = 1; seat <= 5; seat++) {
  System.out.println("Seat number: " + seat);
}
```

Use a loop to calculate the factorial of a given number:

### Example

```java
int n = 5;
int fact = 1;

for (int i = 1; i <= n; i++) {
  fact *= i;
}

System.out.println("Factorial of " + n + " is " + fact);
// Output: Factorial of 5 is 120
```

Factorial means multiplying a number by every number below it, down to 1. For example, the factorial of 5 is: 5 * 4 * 3 * 2 * 1 = 120

# Java Break and Continue

---

## Break

You have already seen the `break` statement used in an earlier chapter of this tutorial. It was used to "jump out" of a `switch` statement.

The `break` statement can also be used to jump out of a **loop**.

This example stops the loop when `i` is equal to 4:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
for (int i = 0; i < 10; i++) {
  if (i == 4) {
    break;
  }
  System.out.println(i);
}
 
```

---

## Continue

The `continue` statement breaks one iteration (in the loop), if a specified condition occurs, and continues with the next iteration in the loop.

This example skips the value of 4:

### Example

```java
for (int i = 0; i < 10; i++) {
  if (i == 4) {
    continue;
  }
  System.out.println(i);
}
 
```

**Good to Remember:**

- `break` = stop the loop completely.
- `continue` = skip this round, but keep looping.

---

## Combining Break and Continue

You can also combine `break` and `continue`.

This example skips printing 2 and stops the loop at 4:

### Example

```java
for (int i = 0; i < 6; i++) {
  if (i == 2) {
    continue;
  }
  if (i == 4) {
    break;
  }
  System.out.println(i);
 
 
```

---

---

## Break and Continue in While Loop

You can also use `break` and `continue` in while loops:

### Break Example

```java
int i = 0;
while (i < 10) {
  System.out.println(i);
  i++;
  if (i == 4) {
    break;
  }
}
 
```

### Continue Example

```java
int i = 0;
while (i < 10) {
  if (i == 4) {
    i++;
    continue;
  }
  System.out.println(i);
  i++;
}
 
```

---

## Real-Life Example

Imagine processing a list of numbers where you want to skip negative values, but stop completely if you find a zero:

### Example

```java
int[] numbers = {3, -1, 7, 0, 9};

for (int n : numbers) {
  if (n < 0) {
    continue; // skip negative numbers
  }
  if (n == 0) {
    break; // stop loop when zero is found
  }
  System.out.println(n);
}
```

**Note:** Don't worry if you don't fully understand the example above. It uses an [array](https://www.w3schools.com/java/java_arrays.asp) (`int[] numbers = {3, -1, 7, 0, 9};`) to store the numbers, and you will learn more about [arrays](https://www.w3schools.com/java/java_arrays.asp) in the next chapter.

# Java Arrays

---

## Java Arrays

Arrays are used to store multiple values in a single variable, instead of declaring separate variables for each value.

To declare an array, define the variable type with **square brackets** `[ ]` :

```java
String[] cars;
```

We have now declared a variable that holds an array of strings. To insert values to it, you can place the values in a comma-separated list, inside **curly braces** `{ }`:

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
```

To create an array of integers, you could write:

```java
int[] myNum = {10, 20, 30, 40};
```

---

## Access the Elements of an Array

You can access an array element by referring to the index number.

This statement accesses the value of the first element in cars:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
System.out.println(cars[0]);
// Outputs Volvo
```

**Note:** Array indexes start with 0: [0] is the first element. [1] is the second element, etc.

Think of an array as numbered boxes, where each box stores an element:

|Index|Element|
|---|---|
|0|Volvo|
|1|BMW|
|2|Ford|
|3|Mazda|

---

---

## Change an Array Element

To change the value of a specific element, refer to the index number:

```java
cars[0] = "Opel";
```

### Example

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
cars[0] = "Opel";
System.out.println(cars[0]);
// Now outputs Opel instead of Volvo
```

---

## Array Length

To find out how many elements an array has, use the `length` property:

### Example

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
System.out.println(cars.length);
// Outputs 4
```

---

## The `new` Keyword

You can also create an array by specifying its size with `new`. This makes an empty array with space for a fixed number of elements, which you can fill later:

### Example

```java
String[] cars = new String[4]; // size is 4

cars[0] = "Volvo";
cars[1] = "BMW";
cars[2] = "Ford";
cars[3] = "Mazda";

System.out.println(cars[0]); // Outputs Volvo
```

However, if you already know the values, you don't need to write `new`. Both of these create the same array:

### Example

```java
// With new
String[] cars = new String[] {"Volvo", "BMW", "Ford", "Mazda"};

// Shortcut (most common)
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
```

**Note:** You cannot write `new String[**4**] {"Volvo", "BMW", "Ford", "Mazda"}`.

In Java, when using `new`, you either:

- Use `new String[4]` to create an empty array with 4 slots, and then fill them later
- Or use `new String[] {"Volvo", "BMW", "Ford", "Mazda"}` (without specifying the number of elements) to create the array and assign values at the same time

**Tip:** The shortcut syntax is most often used when the values are known at the start. Use `new` with a size when you want to create an empty array and fill it later.

# Java Arrays Loop

---

## Loop Through an Array

You can loop through the array elements with the `for` loop, and use the `length` property to specify how many times the loop should run.

This example creates an array of strings and then uses a `for` loop to print each element, one by one:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

for (int i = 0; i < cars.length; i++) {
  System.out.println(cars[i]);
}
```

Here is a similar example with numbers. We create an array of integers and use a `for` loop to print each value:

### Example

```java
int[] numbers = {10, 20, 30, 40};

for (int i = 0; i < numbers.length; i++) {
  System.out.println(numbers[i]);
}
```

---

## Calculate the Sum of Elements

Now that you know how to work with arrays and loops, let's use them together to calculate the sum of all elements in an array:

### Example

```java
int[] numbers = {1, 5, 10, 25};
int sum = 0;

// Loop through the array and add each element to sum
for (int i = 0; i < numbers.length; i++) {
  sum += numbers[i];
}

System.out.println("The sum is: " + sum);
```

---

---

## Loop Through an Array with For-Each

There is also a "**for-each**" loop, which is used exclusively to loop through elements in an array (or other [data structures](https://www.w3schools.com/java/java_data_structures.asp)):

### Syntax

```java
for (type variable : arrayname) {
  // code block to be executed
}
```

The colon (`:`) is read as "in". So you can read the loop as: _"for each variable in array"_.

The following example uses a **for-each** loop to print all elements in the **cars** array:

### Example

```java
String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

for (String car : cars) {
  System.out.println(car);
}
```

This means: **for each** `String` in the `cars` array (here called `car`), print its value.

Compared to a regular `for` loop, the **for-each** loop is easier to write and read because it does not need a counter (like `i < cars.length`). However, it only gives you the values, not their positions (indexes) in the array.

So, if you need both the position (index) of each element and its value, a regular `for` loop is the right choice. For example, when printing seat numbers in a theater row, you need to show both the seat number (the index) and who is sitting there (the value):

### Example

```java
String[] seats = {"Jenny", "Liam", "Angie", "Bo"};

for (int i = 0; i < seats.length; i++) {
  System.out.println("Seat number " + i + " is taken by " + seats[i]);
}
```

**Note:** The **for-each** loop is great when you only need to read elements. If you want to change the elements later, or keep track of their index, use a regular `for` loop instead.

# Java Arrays - Real-Life Examples

---

## Real-Life Example

To demonstrate a practical example of using arrays, let's create a program that calculates the average of different ages:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
// An array storing different ages
int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};

float avg, sum = 0;

// Get the length of the array
int length = ages.length;

// Loop through the elements of the array
for (int age : ages) {
  sum += age;
}

// Calculate the average by dividing the sum by the length
avg = sum / length;

// Print the average
System.out.println("The average age is: " + avg);
```

And in this example, we create a program that finds the lowest age among different ages:

### Example

```java
// An array storing different ages
int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};

// Get the length of the array
int length = ages.length;

// Create a 'lowest age' variable and assign the first array element of ages to it
int lowestAge = ages[0];

// Loop through the elements of the ages array to find the lowest age
for (int age : ages) {
  // Check if the current age is smaller than the current 'lowest age'
  if (lowestAge > age) {
    // If the smaller age is found, update 'lowest age' with that element
    lowestAge = age;
  }
}

// Output the value of the lowest age
System.out.println("The lowest age in the array is: " + lowestAge);
```

Create a program with a list of numbers where you want to skip negative values, but stop completely if you find a zero:

### Example

```java
int[] numbers = {3, -1, 7, 0, 9};

for (int n : numbers) {
  if (n < 0) {
    continue; // skip negative numbers
  }
  if (n == 0) {
    break; // stop loop when zero is found
  }
  System.out.println(n);
}
```

Create a program that keeps track of the highest and lowest values in an array:

### Example

```java
int[] numbers = {45, 12, 98, 33, 27};

int max = numbers[0];
int min = numbers[0];

for (int n : numbers) {
  if (n > max) {
    max = n;
  }
  if (n < min) {
    min = n;
  }
}

System.out.println("Max: " + max);
System.out.println("Min: " + min);
```

Create a program that prints the seat numbers in a theater row, showing both the seat number (the index) and who is sitting there (the value):

### Example

```java
String[] seats = {"Jenny", "Liam", "Angie", "Bo"};

for (int i = 0; i < seats.length; i++) {
  System.out.println("Seat number " + i + " is taken by " + seats[i]);
}
```

# Java Multi-Dimensional Arrays

---

## Multidimensional Arrays

A multidimensional array is an array that contains other arrays.

You can use it to store data in a table with rows and columns.

To create a two-dimensional array, write each row inside its own **curly braces**:

```java
int[][] myNumbers = { {1, 4, 2}, {3, 6, 8} };
```

Here, **myNumbers** has two arrays (two rows):

- First row: `{1, 4, 2}`
- Second row: `{3, 6, 8}`

Think of it like this:

![](https://www.w3schools.com/c/col-row.png)

---

## Access Elements

To access an element of a two-dimensional array, you need two indexes: the first for the row, and the second for the column.

**Remember:** Array indexes start at 0. That means row `0` is the first row, and column `0` is the first column. (So row index `1` is the _second_ row, and column index `2` is the _third_ column.)

This statement accesses the element in the **second row** (index `1`) and **third column** (index `2`) of the **myNumbers** array:

### Example[Get your own Java Server](https://www.w3schools.com/java/java_server.asp "W3Schools Spaces")

```java
int[][] myNumbers = { {1, 4, 2}, {3, 6, 8} };
System.out.println(myNumbers[1][2]); // Outputs 8
```

This example prints the value at row `0`, column `1`:

### Example

```java
int[][] myNumbers = { {1, 4, 2}, {3, 6, 8} };

System.out.println(myNumbers[0][1]); // Outputs 4
```

---

---

## Change Element Values

You can overwrite an existing element using the same two-index notation (row, then column):

### Example

```java
int[][] myNumbers = { {1, 4, 2}, {3, 6, 8} };
myNumbers[1][2] = 9;
System.out.println(myNumbers[1][2]); // Outputs 9 instead of 8
```

---

## Rows and Columns (Lengths)

You can use `length` to get the number of rows, and `_myNumbers[row]_.length` for the number of columns in a given row:

### Example: Sizes

```java
int[][] myNumbers = { {1, 4, 2}, {3, 6, 8, 5, 2} };

System.out.println("Rows: " + myNumbers.length);             // 2
System.out.println("Cols in row 0: " + myNumbers[0].length); // 3
System.out.println("Cols in row 1: " + myNumbers[1].length); // 5
```

**Note:** Notice how rows can have different lengths - In this example, the second row has more elements than the first, and that's perfectly valid in Java.

---

## Loop Through a Multidimensional Array

Use a `for` loop inside another `for` loop to visit every element (row by row):

### Example

```java
int[][] myNumbers = { {1, 4, 2}, {3, 6, 8, 5, 2} };

for (int row = 0; row < myNumbers.length; row++) {
  for (int col = 0; col < myNumbers[row].length; col++) {
    System.out.println("myNumbers[" + row + "][" + col + "] = " + myNumbers[row][col]);
  }
}
```

Or use a **for-each** loop in both levels, which many find easier to read:

### Example

```java
int[][] myNumbers = { {1, 4, 2}, {3, 6, 8, 5, 2} };

for (int[] row : myNumbers) {
  for (int num : row) {
    System.out.println(num);
  }
}
```

