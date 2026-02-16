---
tags:
  - CCT1
  - CE
  - C
Topic: The von Neumann Model
Semester: CCT1
Course: CE1
Module: K9
Course Date: 05-11-25
Litterature:
  - "Introduction\rto Computing\rSystems, 3rd Edition"
Created: 03-11-25
---
- - -
## Table of Contents

- [[#4.1 Basic Components|4.1 Basic Components]]
	- [[#4.1 Basic Components#Memory|Memory]]
	- [[#4.1 Basic Components#Processing Unit|Processing Unit]]
	- [[#4.1 Basic Components#I/O|I/O]]
	- [[#4.1 Basic Components#Control Unit|Control Unit]]
- [[#4.2 The LC-3: An Example von Neumann Machine|4.2 The LC-3: An Example von Neumann Machine]]
	- [[#4.2 The LC-3: An Example von Neumann Machine#Memory|Memory]]
	- [[#4.2 The LC-3: An Example von Neumann Machine#I/O|I/O]]
	- [[#4.2 The LC-3: An Example von Neumann Machine#The Processing Unit|The Processing Unit]]
	- [[#4.2 The LC-3: An Example von Neumann Machine#The Control Unit|The Control Unit]]
- [[#4.3 Instruction Processing|4.3 Instruction Processing]]
	- [[#4.3 Instruction Processing#The Instruction|The Instruction]]
		- [[#The Instruction#Operate|Operate]]
		- [[#The Instruction#Data Movement|Data Movement]]
		- [[#The Instruction#Control|Control]]
	- [[#4.3 Instruction Processing#The Instruction Cycle (not the clk cycle)|The Instruction Cycle (not the clk cycle)]]
		- [[#The Instruction Cycle (not the clk cycle)#FETCH|FETCH]]
		- [[#The Instruction Cycle (not the clk cycle)#DECODE|DECODE]]
		- [[#The Instruction Cycle (not the clk cycle)#EVAL ADDRESS|EVAL ADDRESS]]
		- [[#The Instruction Cycle (not the clk cycle)#FETCH OPERANDS|FETCH OPERANDS]]
		- [[#The Instruction Cycle (not the clk cycle)#EXECUTE|EXECUTE]]
		- [[#The Instruction Cycle (not the clk cycle)#STORE RESULT|STORE RESULT]]
	- [[#4.3 Instruction Processing#Changing the Seq. of Execution|Changing the Seq. of Execution]]
		- [[#Changing the Seq. of Execution#How Control Instructions Work: The Program Counter (PC)|How Control Instructions Work: The Program Counter (PC)]]
	- [[#4.3 Instruction Processing#Control of the Instruction Cycle|Control of the Instruction Cycle]]
		- [[#Control of the Instruction Cycle#Skipping Sequential instruction|Skipping Sequential instruction]]
	- [[#4.3 Instruction Processing#Halting the Computer (the TRAP Instruction)|Halting the Computer (the TRAP Instruction)]]
- [[#4.4 Our First Program: A Multiplication Algorithm|4.4 Our First Program: A Multiplication Algorithm]]
	- [[#4.4 Our First Program: A Multiplication Algorithm#The Algorithm|The Algorithm]]
		- [[#The Algorithm#Outside the Algo|Outside the Algo]]
		- [[#The Algorithm#The Plan|The Plan]]
		- [[#The Algorithm#Execution|Execution]]

# 4.1 Basic Components
>[!info] 
>John von Neumann proposed a fundamental model of a computer for processing computer programs in 1946.

A computer program consists of a set of instructions, each specifying a welldefined piece of work for the computer to carry out. 
The *instruction* is the smallest piece of work specified in a computer program. That is, the computer either carries out the work specified by an instruction or it does not. The computer does not have the luxury of carrying out only *a piece* of an instruction.

The von Neumann model consists of five parts: 
1. [[#Memory]]
2. [[#Processing Unit]]
3. [[#I/O|Input]]
4. [[#I/O|Output]]
5. [[#Control Unit]]
![[Pasted image 20251103091355.png]]
## Memory
One of today’s computer systems is $2^{34}$ by 8 bits. B
That is, a typical memory in today’s world of computers consists of $2^{34}$ distinct memory locations, each of which is capable of storing eight bits of information. 

We say that such a memory has an address space of $2^{34}$ uniquely identifiable locations, and an addressability of eight bits. 
We refer to such a memory as a 16-gigabyte memory (abbreviated, 16 GB). 
	The “16 giga” refers to the $2^{34}$ locations, and the “byte” refers to the eight bits stored in each location. 

> [!info] 
> The term is 16 *giga* because 16 is $2^4$ and *giga* is the term we use to represent $2^{30}$, which is approximately one billion; $2^4$ times $2^{30}$ = $2^{34}$. 
> A *byte* is the word we use to describe eight bits, much the way we use the word *gallon* to describe four quarts.

To read the contents of a memory cell/location, we first place the address of that location in the memory’s address register (MAR).
The information stored in the location having that address will be placed in the memory’s data register (MDR).
![[Pasted image 20251103093249.png]]
To write (or store) a value in a memory location, we first write the address of the memory location in the MAR, and the value to be stored in the MDR.
The information contained in the MDR will be written into the memory location whose address is in the MAR.
![[Pasted image 20251105135807.png]]
![[Pasted image 20251105135824.png]]
![[Pasted image 20251105135841.png]]
>[!warning] Note
>The value stored ***in*** a location can be changed, but the location’s ***memory address*** remains unchanged.
## Processing Unit
> [!info] The processing unit
> The actual processing of information in the computer is carried out by the processing unit.

The processing unit in a modern computer can consist of many sophisticated complex functional units, each performing one particular operation (divide, square root, etc.). 

The simplest processing unit, and the one normally thought of when discussing the basic von Neumann model, is the **ALU**.
	*ALU* is the abbreviation for *Arithmetic and Logic Unit*, so called because it is usually capable of performing basic arithmetic functions (like ADD and SUBTRACT | [[C - Formatting and Syntax#Arithmetic Operators]]) and basic logic operations (like bitwise AND, OR, and NOT | [[C - Formatting and Syntax#Bitwise Operators]]).

The ALU normally processes data elements of a fixed size referred to as *the word length* of the computer. 
These data elements are called *words*. 
> [!example]
> To perform ADD, the ALU receives two words as inputs and produces a single word (the sum) as output. 
> Each ISA has its own word length, depending on the intended use of the computer

> [!info] Micro- & Central-Processing-Units (CPUs) today
> Most microprocessors and CPUs today, used in Personal Computers (PCs) and cell phones, have a *word length* of 64 bits.
In the LC-3, the ALUs word length is 16 bits.

It is almost always the case that a computer provides some small amount of storage very close to the ALU to allow results to be temporarily stored if they will be needed to produce additional results in the near future.
>[!example]
>If a computer is to calculate $(A+B)⋅C$, it could store the result of $A+B$ in memory, and then subsequently read it in order to multiply that result by $C$. 
>However, the time it takes to access memory is long compared to the time it takes to perform the ADD or MULTIPLY. Therefore, we have temporary storage for storing the result of $A + B$ in order to avoid the much longer access time that would be necessary when it came time to multiply.

The most common form of temporary storage is a set of registers. Typically, the size of each register is identical to the size of values processed by the ALU; that is, they each contain one word. The LC-3 has eight registers (R0, R1, … R7), each containing 1 word length of 16 bits.
Current microprocessors typically contain 32 registers, each consisting of 32 or 64 bits, depending on the architecture. These serve the same purpose as the eight 16-bit registers in the LC-3.
## I/O
> [!info] I is for *Input*
> In order for a computer to process information, the information must get into the computer. 

> [!info] O is for *Output* 
> In order to use the results of that processing, those results must be displayed in some fashion outside the computer.

Many devices exist for the purposes of input and output. 
They are generically referred to as *peripherals* because they are in some sense "accessories" to the processing function.

- *In the LC-3*, 
it uses the two most basic input and output devices. 
For input, we will use the keyboard; for output, we will use the monitor.
## Control Unit
> [!info]
> The control unit is like the conductor of an orchestra; it is in charge of making all the other parts of the computer play together.

When we describe the step-by-step process of executing a computer program, it is the control unit that keeps track of both where we are within the process of executing the program and where we are in the process of executing each instruction.
	To keep track of which instruction is to be processed next, the control unit has a register that contains the next instruction’s address.
# 4.2 The LC-3: An Example von Neumann Machine
>[!info]
>The Little Computer 3 (LC-3) is a simplified, educational computer architecture. 
>It's ***not*** a physical machine you can buy, but rather a conceptual model and a software simulator used to teach the fundamentals of computer organization and architecture.

![[Pasted image 20251103104602.png]]
## Memory
consists of the storage elements, along with the Memory Address Register (MAR) for addressing individual locations and the Memory Data Register (MDR) for holding the contents of a memory location on its way to/from the storage. 
![[Pasted image 20251105135929.png]]
## I/O
consists of a keyboard and a monitor.
- The simplest keyboard requires two registers: a keyboard data register (KBDR) for holding the ASCII codes of keys struck and a keyboard status register (KBSR) for maintaining status information about the keys struck.
- The simplest monitor also requires two registers: a display data register (DDR) for holding the ASCII code of something to be displayed on the screen and a display status register (DSR) for maintaining associated status information.
![[Pasted image 20251105135942.png]] ![[Pasted image 20251105135954.png]]
## The Processing Unit
consists of a functional unit (ALU) that performs arithmetic and logic operations and eight registers (R0, … R7) for storing temporary values that will be needed in the near future as operands for subsequent instructions.
![[Pasted image 20251105140013.png]]
## The Control Unit
consists of all the structures needed to manage the processing that is carried out by the computer.
![[Pasted image 20251105140033.png]]

# 4.3 Instruction Processing
> [!info]
> The central idea in the von Neumann model of computer processing is that the program and data are both stored as sequences of bits in the computer’s memory, and the program is executed one instruction at a time under the direction of the control unit.
## The Instruction
The most basic unit of computer processing is the *instruction*.
It is made up of two parts: 
1. The *opcode*
	- The part of an instruction that specifies the operation (e.g., `ADD`, `LD`).
2. The *operands*
	- The data or location of data that an instruction operates on.
![[Pasted image 20251105140322.png]]
> [!info]- LC-3 Opcodes
> |Instruction|Binary Opcode|Hex Opcode|
|---|---|---|
|BR|`0000`|`0x0`|
|ADD|`0001`|`0x1`|
|LD|`0010`|`0x2`|
|ST|`0011`|`0x3`|
|JSR/JSRR|`0100`|`0x4`|
|AND|`0101`|`0x5`|
|LDR|`0110`|`0x6`|
|STR|`0111`|`0x7`|
|RTI|`1000`|`0x8`|
|NOT|`1001`|`0x9`|
|LDI|`1010`|`0xA`|
|STI|`1011`|`0xB`|
|JMP|`1100`|`0xC`|
|Reserved|`1101`|`0xD`|
|LEA|`1110`|`0xE`|
|TRAP|`1111`|`0xF`|
> - The **Reserved** opcode (`1101`) is not used in the standard LC-3 instruction set.
> - The **TRAP** instruction uses the lower 8 bits to specify a trap vector (e.g., `x25` for `HALT`).

There are fundamentally three kinds of instructions: 
1. [[#Operate]]
2. [[#Data Movement]]
3. [[#Control]]
### Operate
instructions operate on data.

LC-3 has 3 ``operate`` instructions:
1 arithmetic
- ADD
![[Pasted image 20251103110649.png]]
![[Pasted image 20251103110713.png]]
2 logical
- AND
![[Pasted image 20251103110728.png]]
- NOT

>[!summary]- LC-3 Operate Instructions
>- **ADD** – Add two values
>- **AND** – Bitwise AND
> - **NOT** – Bitwise NOT (inverts bits)
### Data Movement
instructions move information from the processing unit to and from memory and to and from input/output devices.

The LC-3 has six data movement instructions.
One of which is the LD (LoaD) instruction.
![[Pasted image 20251103113035.png]]
> [!summary]- LC-3 Data Movement Instructions
> - **LD** – Load from memory using PC-relative offset
> - **LDI** – Load indirectly (address points to another address)
> - **LDR** – Load using base register and offset
> - **LEA** – Load effective address (address itself, not contents)
> - **ST** – Store to memory using PC-relative offset
> - **STI** – Store indirectly
> - **STR** – Store using base register and offset
### Control
instructions are necessary for altering the sequential processing of instructions.

>[!info]
>If a program consists of instructions 1,2,3,4...10 located in memory locations A, A+1, A+2, ...A+9, normally the instructions would be executed in the sequence 1,2,3...10.

An LC-3 instruction consists of 16 bits (one word), numbered from left to right, bit ``15`` to bit ``0``. Bits ``15:12`` contain the *opcode*.
	This means there are at most $2^4$ distinct *opcodes*. Of which One is reserved for some future use.
Bits ``11:0`` are used to figure out where the operands are.
> [!summary]- LC-3 Control Instructions
> - **BR** – Conditional branch (based on condition codes: N, Z, P)
> - **JSR/JSRR** – Jump to subroutine (JSR uses PC-relative, JSRR uses register)
> - **JMP** – Unconditional jump
> - **RTI** – Return from interrupt
> - **TRAP** – System call (used for I/O and other OS-level functions)
## The Instruction Cycle (not the clk cycle)
Instructions are processed under the direction of the control unit in a very systematic, step-by-step manner.
The entire sequence of steps needed to process an instruction is called the *instruction cycle*.

The instruction cycle consists of six sequential *phases*, each phase requiring "zero or more" steps.
	Not all instructions require all six phases.
1. [[#FETCH]]
2. [[#DECODE]]
3. [[#EVAL ADDRESS]]
4. [[#FETCH OPERANDS]]
5. [[#EXECUTE]]
6. [[#STORE RESULT]]
### FETCH
The FETCH phase obtains the next instruction from memory and loads it into the instruction register (IR) of the control unit.

The FETCH phase takes the following steps: 
- Step 1: Load the MAR with the contents of the PC, and simultaneously increment the PC.
- Step 2: Interrogate memory, resulting in the instruction being placed in the MDR. 
- Step 3: Load the IR with the contents of the MDR.

Each of these steps is under the direction of the [[#Control Unit]]
### DECODE
The DECODE phase examines the instruction in order to figure out what the microarchitecture is being asked to do.

This involves:
- Identifying the instruction type ([[#Operate]], [[#Data Movement]], or [[#Control]])
- Determining which specific operation within that type is required
- Identifying the addressing mode and operands

>[!info] In the LC-3
>A 4-to-16 decoder identifies which of the 16 opcodes is to be processed.
>The output line asserted is the one corresponding to the opcode at the input.
### EVAL ADDRESS
The EVAL ADDRESS phase computes the *address* of the *memory location* that is needed to process the instruction.

Such as:
- For immediate addressing, the operand is already in the instruction
- For PC-relative addressing, the offset is added to the PC
- For indirect addressing, the memory location specified in the instruction contains the address of the actual operand
### FETCH OPERANDS
The FETCH OPERANDS phase obtains the "source operands" needed to process the instruction.

The actual data values are retrieved:
- From registers (if register addressing mode)
- From memory (if memory addressing mode)
- From the instruction itself (if immediate addressing mode)

> [!example] In LD
> this phase took two steps: loading MAR with the address calculated in the EVALUATE ADDRESS phase and reading memory that resulted in the source operand being placed in MDR

> [!example] In ADD
> This phase consisted of obtaining the source operands from R2 and R6. 
> 	In most current microprocessors, this phase (for the ADD instruction) can be done at the same time the instruction is being executed (the fifth phase of the instruction cycle)
### EXECUTE
This phase carries out the execution of the instruction. 
> [!example] In ADD 
> This phase consisted of the step of performing the addition in the ALU.
### STORE RESULT
The (possibly) final phase of an instruction’s execution.
The result is written to its designated destination.

In the LC-3, an ADD instruction can fetch its source operands, perform the ADD in the ALU, and store the result in the destination register all in a single clock cycle. 
	A separate STORE RESULT phase is not needed.
## Changing the Seq. of Execution
> [!info] Up to this point 
> It's assumed that a computer program is executed **in sequence**. That is, the first instruction is executed, then the second, followed by the third, and so on.
### How Control Instructions Work: The Program Counter (PC)
As we know, each instruction cycle starts with loading the MAR with the contents of the Program Counter (PC). Therefore, if we wish to change the sequence of instructions to be executed, **we must change the contents of the PC**.
> [!warning] Note 
> The change to the PC must happen _after_ it is incremented during the [[#FETCH]] phase of the current instruction, but _before_ the `FETCH` phase of the next instruction cycle begins.
Control instructions perform this function by loading a new value into the PC during the `[[#EXECUTE]]` phase. This action **overwrites the incremented PC** that was automatically loaded during the `FETCH` phase.

The result is that at the start of the next instruction cycle, when the computer accesses the PC to get the address of the next instruction, it will get the address loaded during the previous instruction's [[#EXECUTE]] phase, rather than the address of the next sequential instruction.
## Control of the Instruction Cycle
The instruction cycle is controlled by a synchronous finite state machine.
> [!question] Why do we care about the Finite State Machine? 
> The FSM is the "brain" of the control unit. It's the physical implementation that ensures every step of every instruction happens in the correct order. Understanding it is the difference between knowing _what_ the computer does and knowing _how_ it does it.

1. Processing starts with State *1*.
The FETCH phase takes three clock cycles, corresponding to the three steps [[#FETCH|described]] earlier. 

For the contents of the PC to be loaded into the MAR, the finite state machine must assert ``GatePC`` and ``LD.MAR``.
	 - ``GatePC`` connects the PC to the processor bus.
	- ``LD.MAR`` is the write enable signal of the MAR register, loads the contents of the bus into the MAR at the end of the current clock cycle. (Registers are loaded at the end of the clock cycle if the corresponding control signal is asserted.)

In order for the PC to be incremented, the finite state machine must assert the ``PCMUX`` select lines to choose the output of the box labeled +1 and must also assert the ``LD.PC`` signal to load the output of the PCMUX into the PC at the end of the current cycle.
	- ``PCMUX`` is the multiplexer that selects the _source_ of the next value for the Program Counter (PC).
	- ``LD.PC`` is a simple, 1-bit control signal, that _enables_ the value selected by `PCMUX` to actually be loaded _into_ the Program Counter register.

2. The finite state machine then goes to State *2*.
Here, the MDR is loaded with the instruction, which is read from memory.

3. In State *3*, the instruction is transferred from the MDR to the instruction register (IR).
This requires the finite state machine to assert ``GateMDR`` and ``LD.IR``, which causes the IR to be loaded at the end of the clock cycle, concluding the FETCH phase of the instruction cycle

The DECODE phase takes a single clock cycle.
4. In State 4, using the external input IR, and in particular the opcode bits of the instruction, the finite state machine can go to the appropriate next state for processing instructions depending on the particular opcode in IR 15:12.

Processing continues *clock cycle by clock cycle* until the instruction completes execution, and the next state logic returns the finite state machine to [[#Control of the Instruction Cycle|State 1]].

### Skipping Sequential instruction
> [!info]
> It is sometimes necessary not to execute the next sequential instruction but rather to access another location to find the next instruction to execute.
> Instructions that change the flow of instruction processing in this way are called *control instructions*.

In the case of the conditional branch instruction (BR), at the end of its instruction cycle, the PC contains one of two addresses: either the incremented PC that was loaded in State 1 or the new address computed from sign-extending bits 8:0 of the BR instruction and adding it to the PC, which was loaded in State 63.
![[Pasted image 20251103125953.png]]
![[Pasted image 20251103125922.png]]
![[Pasted image 20251103125931.png]]
> [!info] Condition Codes (N, Z, P): 
> Single-bit flags set by the ALU after most operations to indicate if the result was Negative, Zero, or Positive.
## Halting the Computer (the TRAP Instruction)
It appears that the computer will continue processing instructions, carrying out the instruction cycle again and again, ad nauseum.

Usually, user programs execute under the control of an operating system. Operating systems are just computer programs themselves. As far as the computer is concerned, the instruction cycle continues whether a user program is being processed or the operating system is being processed. 
	This is fine as far as user programs are concerned since each user program terminates with a control instruction that changes the PC to again start processing the operating system—often to initiate the execution of another user program.

When the `TRAP` instruction executes, the PC is loaded with the contents of the memory location specified by the *trap vector*. For a command like `TRAP x25`, the control unit loads the PC with the contents of memory location `x0025`.
	Memory locations `x0000` to `x00FF` are ***reserved*** for the operating system. The OS places the starting addresses of its service routines (like `HALT`, `GETC`, `OUT`) in these locations. This table is called the **trap vector table**.

What if we actually want to stop this potentially infinite sequence of instruction cycles?
Stopping the instruction sequencing requires stopping the control unit. Here the next clock cycle corresponds to the next state of the instruction cycle, which is either the next state of the current phase of the instruction cycle or the first state of the next phase of the instruction cycle. Stopping the instruction cycle requires stopping the clock.

> [!summary]
> The *clock generator* is a crystal oscillator, a piezoelectric device. 
> Together with an AND gate, where TRAP is used to control this gate, controlling when to "start" and "stop" the clock. (In modern computers, it's a command for when to terminate the program and return to the OS).

The crystal oscillator is a **black box** that produces the oscillating voltage.
![[Pasted image 20251103130748.png]]

- If the RUN latch is in the 1 state, the output of the clock circuit is the same as the output of the clock generator.
- If the RUN latch is in the 0 state, the output of the clock circuit is 0.
Stopping the instruction cycle requires only clearing the RUN latch.
	Every computer has some mechanism for doing that. In some older machines, it is done by executing a ``HALT`` instruction. 
	In the LC-3, as in many other machines, it is done under control of the operating system.

If a user program requires help from the operating system, it requests that help with the ``TRAP`` instruction (opcode = 1111) and an eight-bit code called a *trap vector*, which identifies the help that the user program needs. 
The eight-bit code x25 tells the operating system that the program has finished executing and the computer can stop processing instructions.
> [!summary]  
> The instruction cycle is a six-phase process managed by a finite state machine. Control instructions like `BR` alter the normal flow by overwriting the PC during the EXECUTE phase, while `TRAP` instructions provide a way to call operating system services.
# 4.4 Our First Program: A Multiplication Algorithm
> [!info] We have all the tools needed to write our first program: 
> data movement (`LD`), operate (`ADD`, `AND`), control (`BR`), and system calls (`TRAP`).

Suppose the computer does not know how to multiply two positive integers.
> [!Summary] Ol' School
> Old computers had ADD instructions, but they did not have multiply instructions.

> [!question] The Problem: Multiplication without a `MUL` Instruction
> How can we perform multiplication if we only have an `ADD` instruction?

> [!example] 
> To multiply 5 times 4, we can use the principle of **repeated addition**. We know that `5 * 4` is the same as `5 + 5 + 5 + 5`. We can write a program to automate this process.
## The Algorithm
### Outside the Algo
In a step "outside" this algorithm the values *5* and *4* have been allocated to 2 memory locations:
```assembly
; Clear the register (R0) to make it = 0
AND R0, R0, #0 
; Add 5 to the "current value" of *0* in R0. R0 = 5
ADD R0, R0, #5

; Store the value from the register R0 into memory M[x3007] labeled "VAL1"
ST R0, VAL1 ; (M[x3007])

; Again clear the register (R0) to make it = 0
AND R0, R0, #0 
; Add 4 to the "current value" of *0* in R0. R0 = 4
ADD R0, R0, #4

; Store the value from the register into memory M[x3008] labeled "VAL2"
ST R0, VAL2 ; (M[x3008])

; The memory locations [Mx3007] & [Mx3008] are now set
; *** Memory Map Reference ***
; VAL1 → M[x3007]
; VAL2 → M[x3008]
```
### The Plan
- Memory location `M[x3007]` contains the value **5**.
- Memory location `M[x3008]` contains the value **4**.
The plan is to:
1. Copy the values from memory back into registers.
2. Initialize a "result" register to equal **0**.
3. Create a loop that:
    - Adds the value **5** of the first register to the result register.
    - Subtracts **1** from the second, counter register.
4. Continue looping until the counter register reaches **0**.
5. The result register will then hold the result register, giving the answer (20).
### Execution
Start by copying the two values from memory to the two registers ``R1`` and ``R2``.
```assembly
[x3000] ; Address of LD instruction
	; Load value from memory (M[x3007]) -> Register 
	(R1)
	LD R1, 6 ; (corresponding to M[x3007] from our current location in M[x3000]) 
	; Increment PC -> x3001
[x3001]
	; Load value from memory (M[x3008]) -> Register 
	(R2)
	LD R2, 6 ; (corresponding to M[x3008] from out current location in M[x3001])
	; Increment PC -> x3002
[x3002]
	; Initialize the "sum" register (R3) to 0, 
	using bitwise ADD
	AND R3, R3, #0
	; increment PC -> x3003
[x3003] [LOOP_ADD]
	; Add the contents of R1 (5) to R3 (the running 
	total / sum)
	ADD R3, R3, R1
	; increment PC -> x3004
[x3004]
	; Decrement out counter (R2) by "adding" a 
	negative value
	ADD R2, R2, #-1
	; increment -> x3005
[x3005]
	; The control instruction that creates our loop
	; Check the result of [x3004]
		; if R2 != 0, BR loads the PC with the 
		address [x3003], causing the program to 
		repeat [x3003] & [x3004]
		; if R2 = 0, BR ends and does nothing, and 
		the PC proceeds to [x3006]
	; Branch "back" to the position of the 
	[LOOP_ADD] flag. BR calculates the required 
	offset by itself (in this canse -3).
	BRnp LOOP_ADD  
	; increment PC -> [x3006]
[x3006]
	; HALTs and ends the program
	TRAP [x25]
	; The PC does not increment.
	
	; At this point [R3] contain the value 20, 
	which is the answer.
```
> [!tip]
> A common trick is to initialize a register to 0, by using a bitwise AND operation with 0 resulting in a 0 no matter the current value of the register. (x AND 0 = 0)

![[Pasted image 20251103154606.png]]
![[Pasted image 20251103154644.png]]
