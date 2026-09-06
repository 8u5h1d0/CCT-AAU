10 modules total of ~4 hours per
mainly computer hardware and module interconnection. Basic architechture

## Digital computers and informating representation
a digital system that follows a set of instructions (program), that operate on data
	software + hardware

Hardware includes physical computational parts like the CPU, but also IO such as a mouse and keyboard for input, and speaker and screen for output
Software is the instruction set used the process the input´ed data, and generating an output

## Information representation
Signals carry information from one analogue component to another
	real-world physical signals are **analogue**, this means that they´re *continuous* and *infinite*.
Digital computer deal with discrete (digital) input-data
	for example 2 discrete values for a continuous voltage is **ON, TRUE, HIGH** (1) and **OFF, FALSE, LOW** (0)
To make an analogue signal digital, you "chop" it up into a digital set of values, like the digital ON and OFF for the continuous analogue voltage.

## Number systems
outside a digital computer a number is used the define a certain quantity
any numbering system is represented by a sequence of digits *r* with 0<=<=*r-1* with r being the base of the system
the weight factor is also called the coefficient.
check [[INCE CPH CCT1/Originals/K1 R1 - Digital Design - 1.1-1.5]]

in digital computer, we avoid working with fractal numbers.

## Number base conversion
Deci to bi, int
- divide by the base
- take the remainer either 0 or 1 as coeff
- repeat with the quotient til you get 0 as the whole integer (if not done with fractals)
```
ie. deci 13
13 / 2 = 6(.5) = 1
6 / 2 = 3 = 0
...
```

deci to bi, frac
instead of dividing, you multiply
take integer as coeff
take resultant fraction and repeat till you get fraction 0 (or up to a number of digits)
```
0.625 x 2 = 1.*25* = 1
0.25 x 2 = 0.*5* = 0
0.5 x 2 = 1.*0* = 1
```

bi to hex
can be converted directly using a 4-bit (1 byte) digit group. This works both ways.
```
11100 in bi
group 4 bits, from right to left
(000)1 1100 (0´s from the left have no meaning)
convert to hex
1 C
```

## Exercises
```
101101 to dec
- 45
26 to bi
- 011010
110010 to hex
- 3 2
111.101 to dec
- 7.625
```

## Binary arrithamtics
The arithmatics of binary addition is the same as for decimal addition

subtraction is difficult, and has to be converted to addition. this is done with the use of *complements*
to get A - B we do A + (-B). To get -B we use the complement of B, as -B = the r´s complement of B.

