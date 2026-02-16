---
tags:
  - CCT1
  - CE
Topic: The LC-3 and Data Path
Semester: CCT1
Course: CE1
Module: K10
Course Date: 12-11-25
Litterature:
  - "Introduction\rto Computing\rSystems, 3rd Edition"
Created: 10-11-25
---
- - -
## Table of Contents
- [[#5.1 The ISA: Overview|5.1 The ISA: Overview]]
	- [[#5.1 The ISA: Overview#5.1.1 Memory Organization|5.1.1 Memory Organization]]
	- [[#5.1 The ISA: Overview#5.1.2 Registers|5.1.2 Registers]]
	- [[#5.1 The ISA: Overview#5.1.3 The Instruction Set|5.1.3 The Instruction Set]]
	- [[#5.1 The ISA: Overview#5.1.4 Opcodes|5.1.4 Opcodes]]
	- [[#5.1 The ISA: Overview#5.1.5 Data Types|5.1.5 Data Types]]
	- [[#5.1 The ISA: Overview#5.1.6 Addressing Modes|5.1.6 Addressing Modes]]
	- [[#5.1 The ISA: Overview#5.1.7 Condition Codes|5.1.7 Condition Codes]]
- [[#5.2 Operate Instructions|5.2 Operate Instructions]]
	- [[#5.2 Operate Instructions#5.2.1 ADD, AND, and NOT|5.2.1 ADD, AND, and NOT]]
	- [[#5.2 Operate Instructions#5.2.2 Immediates|5.2.2 Immediates]]
	- [[#5.2 Operate Instructions#5.2.3 The LEA Instruction (Although Not Really an Operate)|5.2.3 The LEA Instruction (Although Not Really an Operate)]]
- [[#5.3 Data Movement Instructions|5.3 Data Movement Instructions]]
	- [[#5.3 Data Movement Instructions#5.3.1 PC-Relative Mode (`LD`, `ST`)|5.3.1 PC-Relative Mode (`LD`, `ST`)]]
	- [[#5.3 Data Movement Instructions#Loading Data: The `LD` Instruction|Loading Data: The `LD` Instruction]]
	- [[#5.3 Data Movement Instructions#Storing Data: The `ST` Instruction|Storing Data: The `ST` Instruction]]
	- [[#5.3 Data Movement Instructions#5.3.2 Indirect Mode (`LDI`, `STI`)|5.3.2 Indirect Mode (`LDI`, `STI`)]]
	- [[#5.3 Data Movement Instructions#5.3.3 Base +offset Mode (`LDR`, `STR`)|5.3.3 Base +offset Mode (`LDR`, `STR`)]]
	- [[#5.3 Data Movement Instructions#5.3.4 An Example|5.3.4 An Example]]
- [[#5.4 Control Instructions|5.4 Control Instructions]]
		-  [[#5.3.4 An Example#The TRAP Instruction (Service Call)|The TRAP Instruction (Service Call)]]
	- [[#5.4 Control Instructions#5.4.1 Conditional Branches (`BR`)|5.4.1 Conditional Branches (`BR`)]]
	- [[#5.4 Control Instructions#5.4.2 Two Methods of Loop Control|5.4.2 Two Methods of Loop Control]]
	- [[#5.4 Control Instructions#Loop Control with a Counter|Loop Control with a Counter]]
	- [[#5.4 Control Instructions#5.4.3 The JMP Instruction|5.4.3 The JMP Instruction]]
	- [[#5.4 Control Instructions#5.4.4 The TRAP Instruction|5.4.4 The TRAP Instruction]]
- [[#5.5 Another Example: Counting Occurrences of a Character|5.5 Another Example: Counting Occurrences of a Character]]
	- [[#5.5 Another Example: Counting Occurrences of a Character#Program Initialization|Program Initialization]]
	- [[#5.5 Another Example: Counting Occurrences of a Character#Character Counting Algorithm|Character Counting Algorithm]]
		- [[#Character Counting Algorithm#Flowchart|Flowchart]]
		- [[#Character Counting Algorithm#Loop Structure|Loop Structure]]
	- [[#5.5 Another Example: Counting Occurrences of a Character#Displaying the Result|Displaying the Result]]
	- [[#5.5 Another Example: Counting Occurrences of a Character#Implementation|Implementation]]
- [[#5.6 The Data Path Revisited|5.6 The Data Path Revisited]]
	- [[#5.6 The Data Path Revisited#5.6.1 Basic Components of the Data Path|5.6.1 Basic Components of the Data Path]]
		- [[#5.6.1 Basic Components of the Data Path#5.6.1.1 The Global Bus|5.6.1.1 The Global Bus]]
		- [[#5.6.1 Basic Components of the Data Path#5.6.1.2 Memory|5.6.1.2 Memory]]
		- [[#5.6.1 Basic Components of the Data Path#5.6.1.3 The ALU and the Register File|5.6.1.3 The ALU and the Register File]]
		- [[#5.6.1 Basic Components of the Data Path#5.6.1.4 The PC and the PCMUX|5.6.1.4 The PC and the PCMUX]]
		- [[#5.6.1 Basic Components of the Data Path#5.6.1.5 The MARMUX|5.6.1.5 The MARMUX]]
	- [[#5.6 The Data Path Revisited#5.6.2 The Instruction Cycle Specific to the LC-3|5.6.2 The Instruction Cycle Specific to the LC-3]]
- [[#5.6.2 The Instruction Cycle Specific to the LC-3|5.6.2 The Instruction Cycle Specific to the LC-3]]
		- [[#5.6.2 The Instruction Cycle Specific to the LC-3#5.6.2.1 FETCH|5.6.2.1 FETCH]]
		- [[#5.6.2 The Instruction Cycle Specific to the LC-3#5.6.2.2 DECODE|5.6.2.2 DECODE]]
		- [[#5.6.2 The Instruction Cycle Specific to the LC-3#5.6.2.3 EVALUATE ADDRESS|5.6.2.3 EVALUATE ADDRESS]]
		- [[#5.6.2 The Instruction Cycle Specific to the LC-3#5.6.2.4 OPERAND FETCH|5.6.2.4 OPERAND FETCH]]
		- [[#5.6.2 The Instruction Cycle Specific to the LC-3#5.6.2.5 EXECUTE|5.6.2.5 EXECUTE]]
		- [[#5.6.2 The Instruction Cycle Specific to the LC-3#5.6.2.6 STORE RESULT|5.6.2.6 STORE RESULT]]
# Intro
The LC-3 (Little Computer 3) is a simplified computer architecture used for educational purposes to understand computer organization and assembly language programming.

In Chapter 4, we discussed the basic components of a computer—its memory, its processing unit, including the associated temporary storage (usually a set of registers), input and output devices, and the control unit that directs the activity of all the units (including itself!). We also studied the six phases of the instruction cycle—[[#The Instruction Cycle (not the clk cycle)#FETCH|FETCH]], [[#The Instruction Cycle (not the clk cycle)#DECODE|DECODE]], [[#The Instruction Cycle (not the clk cycle)#EVAL ADDRESS|ADDRESS EVAL]], [[#The Instruction Cycle (not the clk cycle)#FETCH OPERANDS|FETCH OPERANDS]], [[#The Instruction Cycle (not the clk cycle)#EXECUTE|EXECUTE]], and [[#The Instruction Cycle (not the clk cycle)#STORE RESULT|STORE RESULT]]. 
We used elements of the LC-3 to illustrate some of the concepts. In fact, we introduced five opcodes: two [[#The Instruction#Operate|Operate]] instructions (``ADD`` and ``AND``), one data movement instruction (``LD``), and two control instructions (``BR`` and ``TRAP``). 
We are now ready to study the LC-3 in much greater detail.
# 5.1 The ISA: Overview
> [!info] The ISA 
> specifies all the information about the computer that the software has to be aware of.

The ISA specifies everything in the computer that is available to a programmer, in the computer’s own machine language.
	Most people, however, do not write programs in the computer’s own machine language.

The ISA also specifies everything in the computer that is needed by someone (a compiler writer) who wishes to translate programs written in a high-level language into the machine language of the computer.

> [!summary] The ISA specifies 
> - The memory organization
> - Register set
> - Instruction set, including 
> 	- The opcodes 
> 	- Data types
> 	- Addressing modes of the instructions in the instruction set.
## 5.1.1 Memory Organization
The LC-3 [[#4.2 The LC-3: An Example von Neumann Machine#Memory|Memory]] has an address space of $2^{16}$ (i.e., $65,536$) locations, and an addressability of $16$ bits.

Since the normal unit of data that is processed in the LC-3 is $16$ bits, we refer to $16$ bits as 
one *word*, and we say the LC-3 is *word-addressable*.
## 5.1.2 Registers
Since it usually takes far more than one clock cycle to obtain data from memory, the LC-3 provides (like almost all computers) additional temporary storage locations that can be accessed in a single clock cycle.
> [!note] Why are registers so fast? 
> Registers are built directly onto the same silicon chip as the CPU. They are made of a type of memory called SRAM (Static RAM), which is very fast but also takes up a lot of space and power. Main memory (RAM) is typically DRAM (Dynamic RAM), which is slower but much denser. This trade-off is why we have a small number of super-fast registers and a large amount of slower main memory.

The most common type of temporary storage locations, and the one used in the LC-3, is a set of *registers*.
	Each register in the set is called a *general purpose register* (GPR).
Like memory locations, registers store information that can be operated on later. 
	The number of bits stored in each register is usually *one word*.

> [!example] Executing
> This instruction tells the ALU to add the contents of *R1* and *R0* and store the result in *R2*.
> 
> **Initial State of Registers**
> 
> | Register   | Reference | Bit-String       |
| ---------- | --------- | ---------------- |
| Register 0 | (R0)      | 0000000000000001 |
| Register 1 | (R1)      | 0000000000000011 |
| Register 2 | (R2)      | 0000000000000101 |
| Register 3 | (R3)      | 0000000000000111 |
| Register 4 | (R4)      | 1111111111111110 |
| Register 5 | (R5)      | 1111111111111100 |
| Register 6 | (R6)      | 1111111111111010 |
| Register 7 | (R7)      | 1111111111111000 |
> LC-3’s register file.
> 
> **The Operation**
> - The CPU reads the value from the first source register, **R1 (3)**.
> - The CPU reads the value from the second source register, **R0 (1)**.
> - The ALU (Arithmetic Logic Unit) performs the addition: **3 + 1 = 4**.
> 
> **Final State of Registers**
> The result, $4$, is written to the destination register, **R2**.
> 
> | Register   | Reference | Bit-String           |
| ---------- | --------- | -------------------- |
| Register 0 | (R0)      | 0000000000000001     |
| Register 1 | (R1)      | 0000000000000011     |
| Register 2 | (R2)      | ***0000000000000100*** |
| Register 3 | (R3)      | 0000000000000111     |
| Register 4 | (R4)      | 1111111111111110     |
| Register 5 | (R5)      | 1111111111111100     |
| Register 6 | (R6)      | 1111111111111010     |
| Register 7 | (R7)      | 1111111111111000     |
> Register file after the ADD instruction: `ADD R2, R1, R0`.	

> [!summary] How the CPU Knows What to Do: The Instruction Format 
> The assembly code `ADD R2, R1, R0` is translated into the following 16-bit machine code. The CPU decodes this binary string field by field to execute the instruction.
> 
> ![[Pasted image 20251110113208.png]]
> 
> | Binary String: | `0001` | `010` | `001` | `0` | `00000` |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Field Name** | Opcode | DR | SR1 | Mode | SR2 |
| **Bit Notation** | `[15:12]` | `[11:9]` | `[8:6]` | `[5]` | `[4:0]` |
| **What it Means** | `ADD` operation | Destination Register (**R2**) | 1st Source Register (**R1**) | `0` = Register Mode | 2nd Source Register (**R0**) |
## 5.1.3 The Instruction Set
> [!info] An instruction is made up of two things
> - Its opcode (what the instruction is asking the computer to do)
> - Its operands (who the computer is expected to do it to!).

The instruction set is defined by its set of *opcodes*, *data types*, and *addressing modes*. 
- The addressing modes determine where the operands are located. 
- The data type is the representation of the operands in 0s and 1s.

> [!example] The instruction ``ADD R2, R0, R1``.
> has an opcode ``ADD``, one addressing mode (register mode), and one data type (2’s complement integer).
> 
> | Component | Example from `ADD R2, R0, R1` | What it Tells the CPU | In Plain English |
| :--- | :--- | :--- | :--- |
| **Opcode** | `ADD` | **What** action to perform. | It's the **verb** of the instruction. The CPU prepares its calculator (the ALU) to perform addition. |
| **Addressing Mode** | **Register Mode** | **Where** to find the data (operands). | It's the **address**. The CPU knows to get the numbers directly from the specified registers, R0 and R1. |
| **Data Type** | **2’s Complement Integer** | **How** to interpret the bits. | It's the **meaning**. The CPU interprets the 16-bit patterns in the registers as signed numbers (e.g., +5, -10). |
> 
> The instruction directs the computer to perform a 2’s complement integer addition and specifies the locations (GPRs) where the computer is expected to find the operands and the location (a GPR) where the computer is to write the result.

> [!summary]- LC-3 Instruction Set Formats
> | Opcode (Binary) | Mnemonic | Assembly Format | Description | Sets Condition Codes? |
| :--- | :--- | :--- | :--- | :--- |
| | | | **Operate Instructions** | |
| `0001` | `ADD+` | `ADD DR, SR1, SR2` <br> `ADD DR, SR1, imm5` | Adds the contents of SR1 and SR2 (or an immediate value) and stores the result in DR. | **Yes** |
| `0101` | `AND+` | `AND DR, SR1, SR2` <br> `AND DR, SR1, imm5` | Performs a bitwise AND on SR1 and SR2 (or an immediate value) and stores the result in DR. | **Yes** |
| `1001` | `NOT+` | `NOT DR, SR` | Performs a bitwise NOT (complement) on SR and stores the result in DR. | **Yes** |
| | | | **Data Movement Instructions (Memory)** | |
| `0010` | `LD+` | `LD DR, LABEL` | Loads a word from memory into DR. The memory address is `PC + offset9`. | **Yes** |
| `1010` | `LDI+` | `LDI DR, LABEL` | Loads a word *indirectly*. The address is found at `PC + offset9`, then the value at *that* address is loaded into DR. | **Yes** |
| `0110` | `LDR+` | `LDR DR, BaseR, offset6` | Loads a word from memory into DR. The memory address is `BaseR + offset6`. | **Yes** |
| `1110` | `LEA+` | `LEA DR, LABEL` | Loads the *Effective Address*. The address `PC + offset9` is calculated and stored in DR. | **Yes** |
| `0011` | `ST` | `ST SR, LABEL` | Stores a word from SR into memory. The memory address is `PC + offset9`. | No |
| `1011` | `STI` | `STI SR, LABEL` | Stores a word *indirectly*. The address is found at `PC + offset9`, then SR is stored at *that* address. | No |
| `0111` | `STR` | `STR SR, BaseR, offset6` | Stores a word from SR into memory. The memory address is `BaseR + offset6`. | No |
| | | | **Control Instructions (Flow)** | |
| `0000` | `BR` | `BR[nzp] LABEL` | Branches (jumps) to `PC + offset9` if the specified condition codes (n, z, p) are set. | No |
| `1100` | `JMP` | `JMP BaseR` | Unconditional jump. Sets the PC to the contents of BaseR. `JMP R7` returns from a subroutine. | No |
| `0100` | `JSR` | `JSR LABEL` | Jump to SubRoutine. Saves `PC+1` in R7 and jumps to `PC + offset11`. | No |
| `0100` | `JSRR` | `JSRR BaseR` | Jump to SubRoutine Register. Saves `PC+1` in R7 and jumps to the address in BaseR. | No |
| `1111` | `TRAP` | `TRAP vect8` | System call. Saves `PC+1` in R7 and jumps to the memory address specified by the trap vector `vect8`. | No |
| `1000` | `RTI` | `RTI` | Return from Interrupt. Restores the PSR and PC from the stack. Used by OS. | No |
| `1101` | - | - | **Reserved for future use.** | - |
> A `+` next to the mnemonic indicates that the instruction sets the condition codes (N, Z, P).
> - **DR**: Destination Register (R0-R7)
> - **SR**: Source Register (R0-R7)
>- **BaseR**: Base Register (R0-R7)
>- **imm5**: A 5-bit immediate value (signed, range -16 to 15)
>- **offset9**: A 9-bit PC-relative offset (signed, range -256 to 255)
>- **offset6**: A 6-bit BaseR-relative offset (signed, range -32 to 31)
>- **vect8**: An 8-bit trap vector (unsigned, range 0-255)
>- **[nzp]**: One or more of the condition code flags (N=Negative, Z=Zero, P=Positive). If none are specified (e.g., `BR`), it never branches. If all are specified (e.g., `BRnzp`), it always branches.
>- **PC**: Program Counter
## 5.1.4 Opcodes
> [!info] ISAs and opcode
> Some ISAs have a very large number of opcodes, one for each of a very large number of tasks that a program may wish to carry out.
> The LC-3 ISA has $15$ instructions, each identified by its unique opcode.

The opcode is specified in bits ``[15:12]`` of the instruction. 
Since four bits are used to specify the opcode, $16$ distinct opcodes are possible.
	The LC-3 ISA specifies only $15$ opcodes. 
	The code ``1101`` has been left unspecified, reserved for some future need that we are not able to anticipate today.
There are three different types of instructions, which means three different types of opcodes: 
- [[#The Instruction#Operate|Operate]]
	process information.
- [[#The Instruction#Data Movement|Data Movement]]
	move information between memory and the registers and between registers/memory and input/output devices.
- [[#The Instruction#Control|Control]]
	change the sequence of instructions that will be executed.
## 5.1.5 Data Types
> [!info] A Data Type in the ISA
> A *data type* is a representation of information such that the ISA has opcodes that operate on that representation.

There are many ways to represent the same information in a computer.
> [!example] Diffrent *Data Types*
> - A child, when asked how old he is, might hold up three fingers, signifying that he is 3 years old. 
> - If the child is particularly precocious, he might write the decimal digit 3 to indicate his age. 
> - Or, if the child is a CS or CE major at the university, he might write 0000 0000 0000 0011, the 16-bit binary representation for 3. 
> - If he is a chemistry major, he might write 3.0 ⋅ 100. 
>   
> All four represent the same value: 3.

In addition to the representation of a single number by different bit patterns in different data types, it is also the case that the same bit pattern can correspond to different numbers, depending on the data type.

> [!warning] Note
> Every opcode will interpret the bit patterns of its operands according to the data type it is designed to support.
> 
> > [!example]
> > The opcode ``ADD`` interprets the bit patterns of its operands as 2’s complement integers, and not ASCII codes, regardless what the person creating those numbers intended.
## 5.1.6 Addressing Modes
> [!info] The Purpose of Addressing Modes
> An addressing mode is a mechanism for specifying where the operand is located.

An operand can generally be found in one of three places: 
1. In memory
2. In a register
3. As a part of the instruction

If the operand is a part of the instruction, we refer to it as a *literal* or as an *immediate* operand.
	The term *literal* comes from the fact that the bits of the instruction ***literally*** form the operand. 
	The term *immediate* comes from the fact that we can obtain the operand ***immediately*** from the instruction, that is, we don’t have to look elsewhere for it.

The LC-3 supports five addressing modes:

| Mode Name   | Category | How it Works (Where is the operand?)                                                                                     | Example Instruction | Use Case                                                                           |
| :---------- | :------- | :----------------------------------------------------------------------------------------------------------------------- | :------------------ | :--------------------------------------------------------------------------------- |
| **Register**    | Register | The operand is located in one of the general-purpose registers (R0-R7).                                                  | `ADD R2, R1, R0`    | The fastest mode. Used for data the CPU is actively working on.                    |
| **Immediate**   | Literal  | The operand is a signed constant (`imm5`) embedded directly within the instruction itself.                               | `ADD R2, R1, #5`    | When you need to use a small, known constant value without accessing memory.       |
| **PC-Relative** | Memory   | The operand's address is calculated by adding an offset from the instruction to the current Program Counter (PC).        | `LD R2, DATA_LABEL` | Accessing global variables or constants located near the current instruction.      |
| **Indirect**    | Memory   | The instruction points to a memory location that *contains the address* of the actual operand. It's a pointer mechanism. | `LDI R2, PTR_LABEL` | Implementing pointers or when the data's location is determined at runtime.        |
| **Base+offset** | Memory   | The operand's address is calculated by adding an offset from the instruction to a base register.                         | `LDR R2, R1, #0`    | Accessing elements in an array or data structure, where R1 holds the base address. |
## 5.1.7 Condition Codes
> [!info] Controlling a Register's State
> The LC-3 has three single-bit registers that are individually set: 
> - Set (set to 1)
> - Cleared (set to 0)
>   
> each time one of the eight general purpose registers is written into as a result of execution of one of the operate instructions or one of the load instructions.

Each operate instruction performs a computation and writes the result into a general purpose register. 
Each load instruction reads the contents of a memory location and writes the value found there into a general purpose register.

The three single-bit registers are called *N*, *Z*, and *P*, corresponding to their meaning: *Negative*, *Zero* and *Positive*. 
Each time a GPR is written by an operate or a load instruction, the *N*, *Z*, and *P* one-bit registers are individually set to ``0`` or ``1``, corresponding to whether the result written to the GPR is negative, zero, or positive.
	That is, if the result is *negative*, the *N* register is set (set to 1), and *Z* and *P* are cleared (set to 0) and so on if the result is zero or positive.

The set of three single-bit registers are referred to as *condition codes* because the condition of those bits are used to change the sequence of execution of the instructions in a computer program.
# 5.2 Operate Instructions
## 5.2.1 ADD, AND, and NOT
> [!info] Operate instructions
> Operate instructions process data.

Arithmetic operations (like ADD, SUB, MUL, and DIV) and logical operations (like AND, OR, NOT, XOR) are common examples of operate instructions.

The LC-3 has three operate instructions: ADD, AND, and NOT.
	The NOT (opcode = ``1001``) instruction is the only operate instruction that performs a ***unary*** operation, that is, the operation requires one source operand.

The NOT instruction bit-wise complements a 16-bit source operand and stores the result in a destination register.
	NOT uses the register addressing mode for both its source and destination.

> [!example] Executing `NOT R3, R5`
> Bits ``[8:6]`` specify the source register and bits ``[11:9]`` specify the destination register. Bits ``[5:0]`` must contain all 1s.
> 
> If R5 initially contains ``0101 0000 1111 0000``
> After executing the following instruction:
> ![[Pasted image 20251110133710.png]]
> R3 will contain ``1010 1111 0000 1111``.
> 
> | Register | Contents (Binary) | Contents (Hex) |
| :--- | :--- | :--- |
| R3 | **`1010 1110 0001 1111`** | **`AE1F`** |
| R5 | `0101 0000 1111 0000` | `50F0` | (Unchanged)
>
>
>![[Pasted image 20251110134737.png]]

> [!tip] The Operation 
 The `NOT` instruction flips every single bit in the source register.
>- Every `1` becomes a `0`.
>- Every `0` becomes a `1`.
> 
> | Binary String: | `1001` | `011` | `101` | `111111` |
| :--- | :--- | :--- | :--- | :--- |
| **Field Name** | Opcode | DR | SR | Unused |
| **Bit Notation** | `[15:12]` | `[11:9]` | `[8:6]` | `[5:0]` |
| **What it Means** | `NOT` operation | Destination Register (**R3**) | Source Register (**R5**) | Must be `111111` |


The ADD (opcode = ``0001``) and AND (opcode = ``0101``) instructions both perform binary operations.
	They require two 16-bit source operands.
The ADD instruction performs a **2’s complement addition** of its two source operands. 
The AND instruction performs a **bit-wise AND** of each pair of bits of its two 16-bit operands.
	Like the NOT, the ADD and AND use the register addressing mode for one of the source operands and for the destination operand.

> [!example] Executing `ADD/AND R3, R5`
> Bits ``[8:6]`` specify the source register, and bits ``[11:9]`` specify the destination register (where the result will be written).
> 
>| Instruction | Binary String | `Opcode` | `DR` | `SR1` | `Mode` | `Second Operand` |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| `NOT R3, R5` | `1001 011 101 111111` | `1001` | `011` (R3) | `101` (R5) | N/A | `111111` |
| `ADD R3, R5, R2` | `0001 011 101 0 010` | `0001` | `011` (R3) | `101` (R5) | `0` | `010` (R2) |
| `ADD R3, R5, #2` | `0001 011 101 1 00010` | `0001` | `011` (R3) | `101` (R5) | `1` | `00010` (#2) |
| `AND R3, R5, R2` | `0101 011 101 0 010` | `0101` | `011` (R3) | `101` (R5) | `0` | `010` (R2) |
| `AND R3, R5, #2` | `0101 011 101 1 00010` | `0101` | `011` (R3) | `101` (R5) | `1` | `00010` (#2) |
## 5.2.2 Immediates
> [!info] Register vs. Immediate
> The second source operand for both ADD and AND instructions can be specified by either register mode or as an immediate operand. Bit ``[5]`` determines which.
> If bit ``[5]`` is 0, then the second source operand uses a register, and bits ``[2:0]`` specify which register. In that case, bits ``[4:3]`` are set to 0 to complete the specification of the instruction

> [!info] Executing the `ADD` Instruction - Register Mode
> If R4 contains the value `6` and R5 contains the value `-18`, then after executing `ADD R1, R4, R5`, R1 will contain `-12`.
> 
> | Register | Contents (Decimal) | Contents (2's Complement Binary) |
| :--- | :--- | :--- |
| R4 | `6` | `0000 0000 0000 0110` |
| R5 | `-18` | `1111 1111 1110 1110` |
> 
> | Binary String: | `0001` | `001` | `100` | `0` | `010` |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Field Name** | Opcode | DR | SR1 | Mode | SR2 |
| **What it Means** | `ADD` | Destination (**R1**) | 1st Source (**R4**) | `0`=Register Mode | 2nd Source (**R5**) |

> [!info] Executing the `ADD` Instruction - Immediate Mode 
> If bit `[5]` is 1, the second source operand is a 5-bit constant (`imm5`) contained within the instruction.
> If R1 contains the value `10`, then after executing `ADD R2, R1, #-3`, R2 will contain the value `7`.
>
>**Initial State of Registers**
>
> | Register | Contents (Decimal) | Contents (2's Complement Binary) |
| :--- | :--- | :--- |
| R1 | `10` | `0000 0000 0000 1010` |
>
>**The Operation: Sign-Extension and Addition**
>1. **Get the Immediate Value:** The immediate value is `-3`. In 5-bit 2's complement, this is `11001`.
>2. **Sign-Extend to 16 bits:** The ALU operates on 16-bit numbers. To use the 5-bit value, its sign bit (`1`) is copied into the 11 leading bits.
  >
  >| 5-bit Value | Sign Bit | Resulting 16-bit Value |
| :--- | :--- | :--- |
| `11001` | `1` | `1111 1111 1111 1001` |
>
>3. **Perform the Addition:** The ALU adds the 16-bit value from R1 to the sign-extended immediate value.
>
`0000 0000 0000 1010` (contents of R1, which is 10) 
`+ 1111 1111 1111 1001` (sign-extended -3) 
`-------------------------` 
`0000 0000 0000 0111` (the result)
>
>**Final State of Registers**
>
>| Register | Contents (Decimal) | Contents (2's Complement Binary) |
| :--- | :--- | :--- |
| R2 | **`7`** | **`0000 0000 0000 0111`** |
>
>| Binary String: | `0001` | `010` | `001` | `1` | `11001` | 
>| :--- | :--- | :--- | :--- | :--- | 
>| **Field Name** | Opcode | DR | SR1 | Mode | imm5 | 
>| **What it Means** | `ADD` | Destination (**R2**) | 1st Source (**R1**) | `1`=Immediate Mode | The number **-3** |
> 
> > [!tip] Sign-Extension in this Example 
> > The 5-bit immediate value for `-3` is `11001`. 
> > Before the ALU can use it, it is sign-extended to 16 bits.
> > - The most significant bit (sign bit) is `1`, indicating a negative number.
> > - This `1` is copied into the 11 leading bits, creating the 16-bit value `1111 1111 1111 1001`.
> > - The ALU then adds this 16-bit value to the contents of R1.
> 
> > [!warning] Common Pitfall 
> > Remember that the `imm5` value is limited to the range `[-16, 15]`. If you try to assemble `ADD R1, R0, #20`, the assembler will flag it as an error because the number `20` cannot be represented in a signed 5-bit field.

> [!example] Example: Arithmetic with Immediates 
> **Goal**: Calculate `R1 = R0 * 10`. Since there is no `MUL` instruction, we can use `R1 = (R0 * 8) + (R0 * 2)`. This can be done with shifts (which are just additions) and an immediate.
> ```assembly
> ; Assume R0 holds the initial value.
AND R1, R1, #0      ; R1 = 0 (Clear the result register)
>
>ADD R1, R0, R0      ; R1 = R0 * 2
>ADD R2, R1, R1      ; R2 = (R0 * 2) * 2 = R0 * 4
>ADD R1, R1, R2      ; R1 = (R0 * 2) + (R0 * 4) = R0 * 6
>ADD R2, R2, R2      ; R2 = (R0 * 4) * 2 = R0 * 8
>ADD R1, R1, R2      ; R1 = (R0 * 6) + (R0 * 8) = R0 * 14. Oops, >miscalculation!
>
>; Let's try again: R1 = (R0 * 8) + (R0 * 2)
>ADD R1, R0, R0      ; R1 = R0 * 2
>ADD R2, R1, R1      ; R2 = R0 * 4
>ADD R2, R2, R2      ; R2 = R0 * 8
>ADD R1, R1, R2      ; R1 = (R0 * 2) + (R0 * 8) = R0 * 10. Correct!
> ```
## 5.2.3 The LEA Instruction (Although Not Really an Operate)
> [!warning] Note
> Where to put the LEA instruction is a matter for debate.

The LEA (Load Effective Address) instruction is a bit of an oddball. 
Although it loads a value into a register (like operate instructions), it's technically classified as a **data movement instruction** because its purpose is to calculate an address.

> [!info] The LEA Mechanism 
> LEA (opcode = `1110`) loads the register specified by bits `[11:9]` of the instruction with the value formed by adding the incremented program counter to the sign-extended bits `[8:0]` of the instruction.
> 
> In simpler terms, it calculates a PC-relative address and loads that _address_ (not the data at that address) into a destination register.

We saw this method of constructing an address with the LD instruction.
	In this case, the instruction does not access memory, it simply loads the computed address into a register.

The LEA instruction is useful to initialize a register with an address that is very close to the address of the instruction doing the initializing.
> [!example]
> If memory location ``M[x4018]`` contains the instruction ``LEA R5, #−3``, and the PC contains x4018
> ![[Pasted image 20251110144536.png]]
> R5 will contain x4016 after the instruction at x4018 is executed.
> 
> **Initial State**
>
>- The Program Counter (PC) contains the address `x4018`.
>- The instruction at memory location `x4018` is `LEA R5, #-3`.
> 
> **The Address Calculation** This is the most critical step. The address calculation happens during the `EVAL ADDRESS` phase of the instruction cycle.
>
>1. **PC Increment:** The PC is incremented _first_. So, the PC value used for the calculation is `x4019`.
>2. **Sign-Extend Offset:** The immediate value `-3` is sign-extended to 16 bits.
>3. **Calculate Effective Address:** `Effective Address = PC + offset` `Effective Address = x4019 + (-3) = x4016`
> 
> **Final State**
>
>- The calculated effective address, `x4016`, is loaded into register **R5**.
>- **No memory access occurs at address x4016.**
>- **Condition codes are NOT set.**
> 
> 
> 
> 
> 
> > [!question] Why will R5 not contain the address x4015? 
> > A common mistake is to add the offset to the _original_ PC value (`x4018`). `x4018 + (-3) = x4015` (Incorrect)
> >
> >The correct calculation uses the **incremented PC value** (`x4019`) because the LC-3 increments the PC _before_ it calculates the PC-relative address for instructions like `LEA`, `LD`, and `BR`. `x4019 + (-3) = x4016` (Correct)s
# 5.3 Data Movement Instructions
> [!info]
> Data movement instructions move information between the general purpose registers and memory and between the registers and the input/output devices.
> As well as from input devices to registers and from registers to output devices.

The process of moving information from memory to a register is called a load, and the process of moving information from a register to memory is called a store.

In both cases, the information in the location containing the source operand remains unchanged. The location of the destination operand is overwritten with the source operand, destroying in the process the previous value that was in the destination location.

> [!info] The format of the load and store instructions
> ![[Pasted image 20251110145534.png]]

> [!summary] The LC-3 contains six instructions that move information 
> 1. ``LD``
> 2. ``LDR``
> 3. ``LDI``
> 4. ``ST``
> 5. ``STR``
> 6. ``STI``

Data movement instructions require two operands, a *source* and a *destination*.
	The source is the data to be moved; the destination is the location where it is moved to.
One of these locations is a register, the other is a memory location or an input/output device.

 Bits ``[11:9]`` specify one of these operands, the register. 
 - If the instruction is a load, DR refers to the destination general purpose register that will contain he value after it is read from memory (at the completion of the instruction cycle). 
 - If the instruction is a store, SR refers to the register that contains the value that will be written to memory. 
 
 Bits ``[8:0]`` contain the address generation bits. 
 That is, bits ``[8:0]`` contain information that is used to compute the 16-bit address of the second operand. 
 
 In the case of the LC-3’s data movement instructions, there are three ways to interpret bits ``[8:0]``.
	 They are collectively called *addressing* modes. 
1. PC-Relative Mode (`LD`, `ST`)
2. Indirect Mode (`LDI`, `STI`)
3. Base +offset Mode (`LD`R, `STR`)

 The opcode specifies how to interpret bits ``[8:0]``. 
 That is, the LC-3’s opcode specifies which of the three addressing modes should be used to obtain the address of the operand from bits ``[8:0]`` of the instruction.
## 5.3.1 PC-Relative Mode (`LD`, `ST`)
This is the most common way to access global variables and constants. The address is calculated relative to the current instruction.
> [!info] The PC-Relative Mechanism 
> The effective address is calculated as `PC + offset9`. The offset is a signed 9-bit value, allowing access to memory locations from `-256` to `+255` bytes away from the current instruction.

> [!info]
> LD (opcode = ``0010``) and ST (opcode = ``0011``) specify the *PC-relative* addressing mode.

The memory address is computed by sign-extending bits ``[8:0]`` to 16 bits and adding the result to the incremented PC.
	The incremented PC is the contents of the program counter after the FETCH phase.

- If the instruction is LD, the computed address (PC + offset) specifies the memory location to be accessed. Its contents is loaded into the register specified by bits ``[11:9]`` of the instruction.
- If the instruction is ST, the contents of the register specified by bits ``[11:9]`` of the instruction is written into the memory location whose address is PC + offset. ...and the N, Z, and P one-bit condition codes are set depending on whether the value loaded is negative, positive, or zero
## Loading Data: The `LD` Instruction
The `LD` instruction loads a 16-bit value from memory into a register.
> [!example] Loading a Variable: `LD R2, DATA_VAR` 
> Assume the label `DATA_VAR` is located at memory address `x3010`. If the PC is at `x3005` when the `LD` instruction is executed:
> 
> **Initial State**
> 
> | Component | Value | Description | 
> | :--- | :--- | 
> | **PC** | `x3005` | The PC points to our `LD` instruction. | 
> | **Instruction** | `LD R2, DATA_VAR` | The instruction to be executed. |
> 
> **The Operation**
> 
> 1. **PC Increment:** The PC is incremented _first_. The PC value used for the calculation is `x3006`.
> 2. **Calculate Offset:** The assembler calculates the offset needed: `x3010 - x3006 = 10` (`0x000A`).
> 3. **Calculate Final Address:** `Effective Address = PC + offset = x3006 + 10 = x3010`.
> 4. **Execute:** The CPU reads the 16-bit value from memory location `x3010` and loads it into `R2`.
> 
> **Final State**
> 
> | Component | Value | Description | 
> | :--- | :--- | 
> | **PC** | `x3006` | The PC now points to the next instruction. | 
> | **Register R2** | `Value from M[x3010]` | Contains the data loaded from memory. |

> [!warning] Common Pitfall 
> A frequent mistake is forgetting that the PC used in the calculation is the **address of the NEXT instruction** (`x3006` in our example), not the address of the `LD` instruction itself (`x3005`).
## Storing Data: The `ST` Instruction
The `ST` instruction writes a 16-bit value from a register to a memory location.
> [!example] Storing a Result: `ST R2, RESULT` 
> Assume the label `RESULT` is located at memory address `x4000`. If R2 contains the value `42` and the PC is at `x3FF0`:
>
**Initial State**
>
| Component | Value | Description | 
| :--- | :--- | 
| **PC** | `x3FF0` | The PC points to our `ST` instruction. | | **Instruction** | `ST R2, RESULT` | The instruction to be executed. | 
| **Register R2** | `42` | Contains the data to be stored. |
>
**The Operation**
>
>1. **PC Increment:** The PC is incremented _first_. The PC value used for the calculation is `x3FF1`.
>2. **Calculate Offset:** The assembler calculates the offset needed: `x4000 - x3FF1 = 15` (`0x000F`).
>3. **Calculate Final Address:** `Effective Address = PC + offset = x3FF1 + 15 = x4000`.
>4. **Execute:** The CPU sends the address `x4000` to the MAR and the value `42` from `R2` to the MDR to be written to memory.
>
**Final State**
>
| Component | Value | Description | 
| :--- | :--- | 
| **PC** | `x3FF1` | The PC now points to the next instruction. | 
| **Memory M[x4000]** | `42` | Now contains the value from R2. |

> [!example] 
> If the following instruction is located at x4018, it will cause the contents of x3FC8 to be loaded into R2.
![[Pasted image 20251110152344.png]]
The three steps of the LD instruction are
>1. The incremented PC (x4019) is added to the sign-extended value contained in IR ``[8:0]`` (xFFAF), and the result (x3FC8) is loaded into the MAR.
>2. Memory is read and the contents of x3FC8 is loaded into the MDR. (Suppose the value stored in x3FC8 is 5)
>3. The value (5) is loaded into R2, and the NZP condition codes are set, completing the instruction cycle.

>[!note]
> Note that the address of the memory operand is limited to a small range of the total memory. 
> That is, the address can only be within ``+256`` or ``−255`` locations of the LD or ST instruction.
> > [!warning]
> > If a load instruction needs to access a memory location further away from the load instruction, one of the other two addressing modes must be used.

![[Pasted image 20251110153143.png]]

> [!error] Problem: Offset Out of Range 
> The instruction `LD R2, x3FC8` attempts to use a PC-relative offset of `x3FC8`. However, a 9-bit signed offset can only represent values from `-256` to `+255`. The value `x3FC8` (which is `16,384` in decimal) is far outside this range.
> 

>[!success] The Correct Approach for Distant Memory
>
To access a memory location that is far away, you must use an addressing mode with a larger range, such as **Base + Offset (`LDR`)**.
>
> >[!example] Correct Way to Access a Distant Location 
> >To load from address `x6000`, you could use `LDR R2, R4, #-128`.
> >
> >- Assume R4 holds the base address of an array (`x6000`).
> >- The offset `-128` fits easily in the 6-bit signed field of the `LDR` instruction.
> >- The effective address would be `x6000 + (-128) = x5F80`.
## 5.3.2 Indirect Mode (`LDI`, `STI`)
> [!info]
> LDI (opcode = ``1010``) and STI (opcode = ``1011``) specify the *indirect* addressing mode.

An address is first formed exactly the same way as with ``LD`` and ``ST``.
Instead of this address being *the address of the operand* to be loaded or stored, it is ***the address of the address of the operand*** to be loaded or stored.
	Hence the *indirect*.

> [!example]
> If the instruction
> ![[Pasted image 20251110154758.png]]
> is in x4A1B, and the contents of x49E8 is x2110, execution of this instruction results in the contents of x2110 being loaded into R3.
> 1. As is the case with the LD and ST instructions, the first step consists of adding the incremented PC (x4A1C) to the sign-extended value contained in IR ``[8:0]`` (xFFCC), and the result (x49E8) loaded into the MAR.
> 2. Memory is in x4A1B and x2110 is in x49E8, and execution of this instruction results in the contents of x2110 being loaded into R3.
> 3. Since x2110 is not the operand, but the address of the operand, it is loaded into the MAR.
> 4. Memory is again read, and the MDR again loaded. This time the MDR is loaded with the contents of x2110. (Suppose the value −1).
> 5. The contents of the MDR (i.e., −1) is loaded into R3 and the NZP condition codes are set, completing the instruction cycle.
## 5.3.3 Base +offset Mode (`LDR`, `STR`)
> [!info]
> LDR (opcode = ``0110``) and STR (opcode = ``0111``) specify the *Base+offset* addressing mode.

The Base+offset mode is so named because the address of the operand is obtained by adding a sign-extended six-bit offset to a base register.
	The six-bit offset is obtained from the instruction, bits ``[5:0].`` 
The base register is specified by bits ``[8:6]`` of the instruction.

> [!example]
> If R2 contains the 16-bit quantity x2345, the following instruction loads R1 with the contents of x2362.
> ![[Pasted image 20251110160528.png]]
> 
> 1. the contents of R2 (x2345) is added to the sign-extended value contained in IR [5:0] (x001D), and the result (x2362) is loaded into the MAR.
> 2. memory is read, and the contents of x2362 is loaded into the MDR. (Suppose the value stored in memory location x2362 is x0F0F)
> 3. the contents of the MDR (in this case, x0F0F) is loaded into R1 and the NZP condition codes are set, completing the execution of the LDR instruction.

![[Pasted image 20251110160745.png]]
> [!example] Example: Accessing an Array with Base+Offset 
> **Goal**: Sum the first 5 elements of an integer array. Assume `R0` holds the base address of the array, and `R1` is the loop counter (initialized to 5). `R2` will hold the sum.
> ```assembly
> AND R2, R2, #0      ; R2 = 0 (Initialize sum)
>AND R1, R1, #0      ; R1 = 0 (Initialize counter)
>
>SUM_LOOP
>    ADD R1, R1, #1  ; Increment counter
>    ADD R3, R1, #-5 ; Check if counter > 5
>    BRp END_SUM     ; If so, exit loop
>  
>    LDR R4, R0, #-1 ; Load element. Note: offset is counter-1
>    ADD R0, R0, #0  ; Reset base register R0 for next iteration
>    ADD R2, R2, R4  ; Add element to sum
>   BR SUM_LOOP
>    
>END_SUM
>    ; R2 now contains the sum
> ```
## 5.3.4 An Example
Assume the contents of memory locations x30F6 through x30FC are

| **Address** | *15* | *14* | *13* | *12* | 11  | 10  | 9   | 8   | 7   | 6   | 5     | 4   | 3   | 2   | 1   | 0   |
| ----------- | ---- | ---- | ---- | ---- | --- | --- | --- | --- | --- | --- | ----- | --- | --- | --- | --- | --- |
| **x30F6**   | *1*  | *1*  | *1*  | *0*  | 0   | 0   | 1   | 1   | 1   | 1   | 1     | 1   | 1   | 1   | 0   | 1   |
| **x30F7**   | *0*  | *0*  | *0*  | *1*  | 0   | 1   | 0   | 0   | 0   | 1   | ==1== | 0   | 1   | 1   | 1   | 0   |
| **x30F8**   | *0*  | *0*  | *1*  | *1*  | 0   | 1   | 0   | 1   | 1   | 1   | 1     | 1   | 1   | 0   | 1   | 1   |
| **x30F9**   | *0*  | *1*  | *0*  | *1*  | 0   | 1   | 0   | 0   | 1   | 0   | ==1== | 0   | 0   | 0   | 0   | 0   |
| **x30FA**   | *0*  | *0*  | *0*  | *1*  | 0   | 1   | 0   | 0   | 1   | 0   | ==1== | 0   | 0   | 1   | 0   | 1   |
| **x30FB**   | *0*  | *1*  | *1*  | *1*  | 0   | 1   | 0   | 0   | 0   | 1   | 0     | 0   | 1   | 1   | 1   | 0   |
| **x30FC**   | *1*  | *0*  | *1*  | *0*  | 0   | 1   | 1   | 1   | 1   | 1   | 1     | 1   | 0   | 1   | 1   |     |
![[Pasted image 20251110160845.png]]
and the PC contains x30F6.

The PC contains x30F6, the instruction stored in location x30F6 is executed
- Since The opcode of that instruction is ``1110``, load effective address (``LEA``).
	LEA loads the register specified by bits ``[11:9]`` with the address formed by sign-extending bits ``[8:0]`` of the instruction and adding the result to the incremented PC.
		The 16-bit value obtained by sign-extending bits ``[8:0]`` of the instruction is xFFFD.
	
	At the end of execution of the LEA instruction, R1 contains x30F4, and the PC contains x30F7.

The incremented PC is x30F7, the instruction stored in location x30F7 is executed
- Since the opcode ``0001`` specifies ``ADD`` 
	The sign-extended immediate in bits ``[4:0]`` (since bit ``[5]`` is 1) is added to the contents of the register specified in bits ``[8:6]``, and the result is written to the register specified by bits ``[11:9]``
		Since the previous instruction wrote x30F4 into R1, and the sign-extended immediate value is x000E, the sum is x3102.
	
	At the end of execution of this instruction, R2 contains x3102, and the PC contains x30F8. 
	R1 still contains x30F4.

The incremented PC is x30F8, the instruction stored in location x30F8 is executed
- The opcode ``0011`` specifies the ``ST`` instruction
	Which stores the contents of the register specified by bits ``[11:9]`` (R2) into the memory location whose address is computed using the PC-relative addressing mode.
		the address is computed by adding the incremented PC (x30F9) to the 16-bit value obtained by sign-extending bits ``[8:0]`` of the instruction (xFFFB).
	
	at the end of execution of the ``ST`` instruction, memory location x30F4 (i.e., x30F9 + xFFFB) contains the value stored in R2 (x3102) and the PC contains x30F9.
	R1 still contains x30F4.

The incremented PC is x30F9, the instruction stored in location x30F9 is executed
- The opcode ``0101`` specifies the ``AND`` instruction
	The bits ``[4:0]`` indicate a bit-wise AND operation with an immediate operand x0000.
		This will always result in a register of all 0's
	
	At the end of execution, R2 contains the value $0$, and the PC contains x30FA.

 The incremented PC is x30FA, the instruction stored in location x30FA is executed
- the opcode ``0001`` specifies the ``ADD`` instruction
	Adding the value $5$ to R2.
	
	After execution, R2 contains the value $5$, and the PC contains x30FB.

 The incremented PC is x30FB, the instruction stored in location x30FB is executed
- the opcode ``0111`` signifies the ``STR`` instruction
	STR (like LDR) uses the *Base+offset* addressing mode.
		The memory address is obtained by adding the contents of the BASE register (specified by bits ``[8:6]``) to the signextended offset contained in bits ``[5:0]``.
		In this case, bits ``[8:6]`` specify R1, which contains x30F4. 
		The 16-bit sign-extended offset is x000E. 
		Since x30F4 + x000E is x3102, the memory address is x3102. 
		The STR instruction stores into x3102 the contents of the register specified by bits ``[11:9]``, in this case R2. 
	
	Since R2 contains the value $5$, at the end of execution of this instruction, ``M[x3102]`` contains the value $5$, and the PC contains x30FC.

The incremented PC is x30FC, the instruction stored in location x30FC is executed
- The opcode 1010 specifies ``LDI``
	LDI (like STI) uses the indirect addressing mode. 
		The memory address is obtained by first forming an address as is done in the *PC-relative* addressing mode. 
		Bits ``[8:0]`` are sign-extended to 16 bits (xFFF7) and added to the incremented PC (x30FD). 
		Their sum (x30F4) is the address of the operand address. 
		Since ``M[x30F4]`` contains x3102, x3102 is the operand address. 
		The LDI instruction loads the value found at this address (in this case $5$) into the register identified by bits ``[11:9]`` of the instruction (in this case R3). 
		
	At the end of execution of this instruction, R3 contains the value $5$ and the PC contains x30FD.
# 5.4 Control Instructions
> [!info]
> Control instructions change the sequence of instructions to be executed.
> 	If there were no control instructions, the next instruction fetched after the current instruction finishes would always be the instruction located in the next sequential memory location.

> [!summary] LC-3 Control Flow Opcodes
>
>1. **Conditional branch** (`BR`)
>2. **Unconditional jump** (`JMP`)
>3. **Subroutine call** (`JSR`/`JSRR`)
>4. **TRAP** (service call)
>5. **RTI** (Return from Interrupt)
### The TRAP Instruction (Service Call)
> [!info] 
> The `TRAP` instruction, often called a **service call**, is useful because it allows a programmer to get help from the operating system to do things that the typical programmer does not fully understand how to do.
>
>>[!example] Typical examples of TRAP services:
>> 
>> - Getting information into the computer from input devices (like a keyboard).
>> - Displaying information to output devices (like a monitor).
>> - Stopping the computer.

The `TRAP` instruction breaks the sequential execution of a user program to start a sequence of instructions in the operating system. This is a mechanism to transfer control from the user program to the OS.
## 5.4.1 Conditional Branches (`BR`)
> [!info] 
> Of the five instructions which change the execution flow from the next sequential instruction to an instruction located someplace else in the program, only one of them decides each time it is executed whether to execute the next instruction in sequence or whether to execute an instruction from outside that sequence.

The instruction that makes that decision each time it is executed is the **conditional branch instruction BR** (opcode = ``0000``).

Based on the execution of previous instructions in the program, the conditional branch’s EXECUTE phase either does nothing or it loads the PC with the address of the instruction it wishes to execute next. If the conditional branch instruction does nothing during the EXECUTE phase, then the incremented PC will remain unchanged, and the next instruction executed will be the next instruction in sequence.
	That decision, whether to do nothing to the incremented PC or whether to change it, is based on previous results computed by the program, which are reflected in the condition codes.

 > [!summary] Format
 > The format of the conditional branch instruction is as follows:
 > ![[Pasted image 20251110165956.png]]
 > Bits ``[11]``, ``[10]``, and ``[9]`` are associated with the three condition codes, *N*, *Z*, and *P*.
 
 operate instructions (ADD, AND, and NOT) and the three load instructions (LD, LDI, and LDR) set the three condition codes in accordance with whether the value written is negative, zero, or positive.
 The conditional branch instruction uses that information to determine whether or not to depart from the usual sequential execution of instructions that we get as a result of incrementing the PC during the FETCH phase of each instruction.

During the EXECUTE phase of the BR instruction cycle, the processor examines the condition codes whose associated bits in the instruction, bits ``[11:9]``, are 1.
	If bit ``[11]`` is 1, condition code N is examined. 
	If bit ``[10]`` is 1, condition code Z is examined. 
	If bit ``[9]`` is 1, condition code P is examined.

If any of the condition codes that are examined are set (i.e., equal to 1), then the PC is loaded with the address obtained in the EVALUATE ADDRESS phase.
The address obtained during the EVALUATE ADDRESS phase of the instruction cycle is generated using the PC-relative addressing mode.
> [!example]
> The BR instruction in memory location x3005 shows bits ``[11:9]`` = ``101``. 
> Since bit ``[11]`` is 1, if the *N* bit is set, the result of the ADD must have been **negative**. 
> Since bit ``[9]`` is also 1, if the *P* bit is set, the result must have been **positive**. 
> Since bit ``[10]`` is 0, we do not examine the *Z* bit. 
> Thus if the previous result is positive or negative (i.e., not 0), the PC is loaded with x3003, the address calculated in the EVALUATE ADDRESS phase of the branch instruction

> [!example] Another example ``BRz x0D9``
> Suppose the following instruction is located at x4027, and the last value loaded into a general purpose register was 0.
> ![[Pasted image 20251110170926.png]]
> Each of the three AND gates corresponds to one of the three condition codes. The output of the AND gate is 1 if the corresponding condition code is 1 and if the associated bit in the instruction directs the hardware to check that condition code.
> If any of the three AND gates have an output 1, the OR gate has an output 1, indicating that the sequential instruction flow should be broken, and the PC should be loaded with the address evaluated during the EVALUATE ADDRESS phase of the instruction cycle.
> 
> In the case of the conditional branch instruction at x4027, the answer is yes, and the PC is loaded with x4101, replacing x4028, which had been loaded into the PC during the FETCH phase of the BR instruction
## 5.4.2 Two Methods of Loop Control
We saw in our multiplication program that we repeatedly executed a sequence of instructions until the value in a register was zero. We call that sequence a loop body, and each time the loop body is executed we call it one *iteration* of the loop body.

There are two common ways to control the number of iterations:
1. Loop Control with a Counter
2. Loop Control with a Sentinel
## Loop Control with a Counter

> [!example] Algorithm for adding integers using a counter
>  Suppose we know that the 12 locations x3100 to x310B contain integers, and we wish to compute the sum of these 12 integers.
>  ![[Pasted image 20251110171320.png]]
>  
>  First, as in all algorithms, we must initialize our variables.
> 	 We must set up the initial values of the variables that the computer will use in executing the program that solves the problem.
> 
## 5.4.3 The JMP Instruction
The conditional branch instruction, for all its capability, does have one limitation. 
The next instruction executed must be within the range of addresses that can be computed by adding the incremented PC to the signextended offset obtained from bits ``[8:0]`` of the instruction.

The LC-3 ISA does provide an instruction JMP (opcode = ``1100``) that can do the job.
	The JMP instruction loads the PC with the contents of the register specified by bits ``[8:6]`` of the instruction.

> [!example]
> If the following JMP instruction is located at address x4000
> ![[Pasted image 20251110181055.png]]
> R2 contains the value x6600, and the PC contains x4000, then the instruction at x4000 (the JMP instruction) will be executed, followed by the instruction located at x6600.
> Since registers contain 16 bits (the full address space of memory), the JMP instruction has no limitation on where the next instruction to be executed must reside.
## 5.4.4 The TRAP Instruction
> [!info]
> The TRAP (opcode = ``1111``) instruction changes the PC to a memory address that is part of the operating system so that the operating system will perform some task on behalf of the program that is executing.

In the language of operating system jargon, we say the TRAP instruction invokes an operating system service call. Bits ``[7:0]`` of the TRAP instruction form the trapvector, an eight-bit code that identifies the service call that the program wishes the operating system to perform on its behalf.
Once the operating system is finished performing the service call, the program counter is set to the address of the instruction following the TRAP instruction, and the program continues.
> [!summary]- Trap-vectors
> 
| Trap Vector (Hex) | Service Name (Mnemonic) | Description                                                                                                                               | Input Register(s) Before Call                                | Output Register(s) After Call    |
| :---------------- | :---------------------- | :---------------------------------------------------------------------------------------------------------------------------------------- | :----------------------------------------------------------- | :------------------------------- |
| **`x20`**         | `GETC`                  | **Get Character.** Reads a single character from the keyboard without echoing it to the screen. The character's ASCII code is returned.   | None                                                         | **R0** = ASCII code of character |
| **`x21`**         | `OUT`                   | **Output Character.** Writes a single character to the console.                                                                           | **R0** = ASCII code of character to print                    | None                             |
| **`x22`**         | `PUTS`                  | **Output String.** Writes a null-terminated string of characters to the console.                                                          | **R0** = Memory address of the first character of the string | None                             |
| **`x23`**         | `IN`                    | **Input with Prompt.** Prints a console prompt, reads a single character from the keyboard (which is echoed), and returns its ASCII code. | None                                                         | **R0** = ASCII code of character |
| **`x24`**         | `PUTSP`                 | **Output Packed String.** Writes a string of characters to the console, where two characters are packed into a single memory word.        | **R0** = Memory address of the first word of the string      | None                             |
| **`x25`**         | `HALT`                  | **Halt Execution.** Stops the program and returns control to the operating system.                                                        | None                                                         | None                             |
# 5.5 Another Example: Counting Occurrences of a Character
> [!info] The Problem 
> We want to input a character from the keyboard, count the number of occurrences of that character in a file, and display that count on the monitor.

 >[!warning] Simplification 
 >We'll assume the number of occurrences is small enough to be expressed with a single decimal digit (at most nine). This allows us to avoid complex conversion routines between binary count and ASCII display
## Program Initialization
The first step is (as always) to initialize all the variables. 
This means providing starting values (called initial values) for *R0*, *R1*, *R2*, and *R3*, the four registers the computer will use to execute the program that will solve the problem. 
- *R2* will keep track of the number of occurrences, referred to as Count. It is initialized to zero.
- *R3* will point to the next character in the file that is being examined. We refer to it as a pointer since it points to (i.e., contains the address of) the location where the next character of the file that we wish to examine resides. The pointer is initialized with the address of the first character in the file.
- *R0* will hold the character that is being counted; we will input that character from the keyboard and put it in R0. 
- *R1* will hold, in turn, each character that we get from the file being examined.
## Character Counting Algorithm
The next step is to count the number of occurrences of the input character. 
This is done by processing, in turn, each character in the file being examined, until the file is exhausted.
>[!info] Sentinel Method 
>We'll use the ASCII code for EOT (End of Transmission) (``00000100``) as the sentinel to mark the end of the file.
### Flowchart
![[Pasted image 20251110182621.png]]
### Loop Structure
In each iteration of the loop:
1. The contents of *R1* is first compared to the ASCII code for EOT.
	- If they are equal, the loop is exited, and the program moves on to displaying the count.
    - If not, there is work to do.
2. *R1* (the current character) is compared to R0 (the character input from the keyboard).
    - If they match, *R2* is incremented.
3. In either case, we move on to getting the next character:
    - The pointer *R3* is incremented
    - The next character is loaded into *R1*
    - The program returns to the test that checks for the sentinel
## Displaying the Result
When the end of the file is reached, all the characters have been examined, and the count is contained as a binary number in *R2*. 
In order to display the count on the monitor, it is first converted to an ASCII code. 
>[!tip] Binary to ASCII Conversion 
>Since we've assumed the count is less than 10, we can convert it to ASCII by putting a leading ``0011`` in front of the four-bit binary representation of the count.

Finally, the count is output to the monitor, and the program terminates.
## Implementation
![[Pasted image 20251110182639.png]]
```assembly
; Initialize registers
AND R2, R2, #0      ; R2 = 0 (count)
LEA R3, FILE_START  ; R3 points to start of file

; Get character to count from keyboard
TRAP x20            ; GETC - get character from keyboard into R0
ADD R0, R0, #0      ; Just to set condition codes (optional)

; Start of loop
LOOP_START
    LDR R1, R3, #0  ; Load next character from file into R1
    
    ; Check for end of file (EOT)
    ADD R1, R1, #-4  ; Check if R1 = EOT (ASCII 4)
    BRz DISPLAY_COUNT ; If zero, we've reached end of file
    
    ; Compare current character with target character
    NOT R1, R1
    ADD R1, R1, R0   ; R1 = R1 - R0
    BRz INCREMENT    ; If zero, characters match
    
    ; Move to next character
    ADD R3, R3, #1
    BR LOOP_START
    
INCREMENT
    ADD R2, R2, #1   ; Increment count
    ADD R3, R3, #1   ; Move to next character
    BR LOOP_START

DISPLAY_COUNT
    ; Convert binary count to ASCII
    LD R1, ASCII_ZERO
    ADD R0, R1, R2   ; R0 = ASCII '0' + count
    
    ; Display the count
    TRAP x21         ; OUT - output character in R0
    
    ; Halt the program
    TRAP x25         ; HALT

; Data
ASCII_ZERO .FILL x0030  ; ASCII code for '0'
FILE_START .FILL x4000   ; Starting address of file (example)
```

> [!summary] Key Concepts
> 
> - **Sentinel-controlled loop**: Using a special value (EOT) to mark the end of data
> - **Character comparison**: Using subtraction to check for equality
> - **Binary to ASCII conversion**: Adding ASCII '0' to a binary number to get its ASCII representation
> - **Pointer arithmetic**: Incrementing a register to move through consecutive memory locations
# 5.6 The Data Path Revisited
The data path represents the physical components through which data flows and the control signals that direct this flow. It includes:
- **Memory components**: ``MAR``, ``MDR``, and the actual memory storage
- **Processing components**: ``ALU`` and *registers*
- **Control components**: ``PC``, ``IR``, and **the finite state machine**
- **Buses and multiplexers**: That direct data flow between components

Understanding the data path is crucial for comprehending how instructions are actually executed at the hardware level, as it shows the physical pathways that data takes during each phase of the instruction cycle.

> [!info] LC-3 Data path
> ![[Pasted image 20251110184950.png]]
> > [!tip] Understanding the Arrows 
> > Note at the outset that there are two kinds of arrows in the data path:
> > - **Filled-in arrowheads**: Designate information that is processed
> >- **Unfilled-in arrowheads**: Designate control signals

>[!info] The Finite State Machine
>Control signals emanate from the block labeled "Finite State Machine." The connections from the finite state machine to most control signals have been left off Figure 5.18 to reduce unnecessary clutter in the diagram.
## 5.6.1 Basic Components of the Data Path
### 5.6.1.1 The Global Bus
> [!info] The Global Bus 
> The most prominent feature on the data path diagram is the heavy black structure with arrowheads at both ends. This represents the data path's **global bus**.
>   
> > [!warning] Single Transfer Rule 
> > Exactly one value can be transferred on the bus at one time.

The LC-3 global bus consists of **16 wires** and associated electronics. It allows one structure to transfer up to **16 bits** of information to another structure by making the necessary electronic connections on the bus.

>[!info] The Tristate Device 
>Note that each structure that supplies values to the bus has a triangle just behind its input arrow to the bus. 
>This triangle (called a _tristate device_) allows the computer's control logic to enable exactly one supplier to provide information to the bus at any one time.

> [!tip] Architectural Variations 
> Not all computers have a single global bus. The pros and cons of a single global bus is a topic that will be covered in more advanced courses.
### 5.6.1.2 Memory
> [!info] Memory's Role 
> One of the most important parts of any computer is the memory that contains both instructions and data.

Memory is accessed by loading the **memory address register (MAR)** with the address of the location to be accessed. The process differs slightly depending on whether you are reading from (loading) or writing to (storing) memory.

> [!example] The LOAD Operation 
> To perform a load (read):
> 
> 1. The address of the desired location is loaded into the **MAR**.
> 2. Control signals then read the contents of that memory location.
> 3. The result of that read is delivered by the memory to the **memory data register (MDR)**.

> [!example] The STORE Operation
> To perform a store (write):
> 
> 4. The data value to be stored is loaded into the **MDR**.
> 5. The destination address is loaded into the **MAR**.
> 6. Control signals assert a **write enable (WE)** signal in order to store the value contained in the MDR into the memory location specified by the MAR.
### 5.6.1.3 The ALU and the Register File
> [!info] The Processing Element 
> The **ALU** (Arithmetic Logic Unit) is the processing element of the LC-3. It performs the actual computations like addition, logical operations, etc.

The ALU has two primary inputs:
1. ***Source 1***: This value is always taken from one of the general-purpose registers. 
   The specific register is selected by the three-bit field `SR1` from the LC-3 operate instruction.
2. ***Source 2***: This value can come from one of two places, determined by `bit [5]` of the instruction:
    - A register, specified by the three-bit field `SR2`.
    - A sign-extended immediate value embedded within the instruction.

>[!info] The Source 2 Multiplexer (MUX) 
>Note the multiplexer (mux) that provides `source 2` to the ALU. The select line for this mux is **`bit [5]`** of the LC-3 operate instruction.
>
>- If `bit [5]` is `0`, the mux selects the value from the register specified by `SR2`.
>- If `bit [5]` is `1`, the mux selects the sign-extended immediate value.

The ALU produces two outputs:
1. **The 16-bit Result**: The result of the ALU's operation (e.g., the sum from an `ADD`) is placed onto the global bus. This value can then be loaded into one of the registers, specified by the three-bit destination register field `DR` in the instruction.
2. **The Condition Codes**: The 16-bit result from the ALU is also simultaneously sent to logic that evaluates it.
>[!summary] Setting the Condition Codes (N, Z, P) 
>The evaluation logic determines if the 16-bit result is:
>- **Negative**: The `N` (Negative) condition code is set to 1, and `Z` and `P` are cleared to 0.
>- **Zero**: The `Z` (Zero) condition code is set to 1, and `N` and `P` are cleared to 0.
>- **Positive**: The `P` (Positive) condition code is set to 1, and `N` and `Z` are cleared to 0.
### 5.6.1.4 The PC and the PCMUX
> [!info] The Program Counter (PC) and its Path 
> At the start of each instruction cycle, the **PC** supplies the address of the next instruction to the **MAR** over the global bus. 
> However, the value of the PC itself must also be updated for the _next_ instruction cycle. This new value for the PC is determined by the **PCMUX** (Program Counter Multiplexer).

The PCMUX is a three-to-one multiplexer that selects which value will be loaded into the PC. The selection is controlled by the finite state machine based on the current instruction being executed.
>[!summary] The three possible inputs to the PCMUX
>>[!example] PC + 1 (Rightmost Input)
>>During the **FETCH** phase of the instruction cycle, the PC is incremented by one. This `PC + 1` value is the default next address for sequential execution. This value is generated and provided as the rightmost input to the PCMUX.
> 
>>[!example] PC + PCoffset (Middle Input)
>>If the current instruction is a **conditional branch** (`BR`) and the branch condition is satisfied, the PC is loaded with a new, non-sequential address.
>>- This address is calculated as `PC + PCoffset`, where `PCoffset` is the 16-bit value obtained by sign-extending bits `[8:0]` of the instruction (`IR[8:0]`).
>>- **Important Note:** This addition takes place in a **special adder** dedicated to this purpose, _not_ in the main ALU.
>>- The output of this special adder is the middle input to the PCMUX.
>
>>[!example] Value from Global Bus (Leftmost Input)
>>The third input to the PCMUX is a 16-bit value taken directly from the global bus. This allows the PC to be loaded with a value that comes from a register (like in a `JMP` instruction) or from memory (like in `JSR` or `TRAP` instructions). The specific use of this input will become clearer after we discuss other control instructions in later chapters.
### 5.6.1.5 The MARMUX
>[!info] The Memory Address Multiplexer (MARMUX) 
>Memory is accessed by supplying an address to the **MAR** (Memory Address Register). The **MARMUX** (Memory Address Register Multiplexer) is a 2-to-1 multiplexer that controls which of two sources will supply the MAR with the appropriate address during the execution of a load, a store, or a TRAP instruction.

>[!example] Right Input: Calculated Address 
>The right input to the MARMUX is obtained by adding two values. The specific values used depend on the opcode being processed.
>
>1. **First Value:** Either the incremented PC or a base register. The control signal `ADDR1MUX` specifies which one to use.
>2. **Second Value:** Zero or a literal value supplied by the IR (Instruction Register). The control signal `ADDR2MUX` specifies which of four values is to be added.

>[!example] Left Input: Trap Vector Address 
>The left input to the MARMUX provides the zero-extended trapvector. This path is used exclusively for `TRAP` instructions to invoke service calls.

>[!tip] Opcode Dependency 
>The combination of values selected by `ADDR1MUX` and `ADDR2MUX` is determined by the opcode. For example, an `LD` instruction uses the PC and a literal, while an `LDR` instruction uses a base register and a literal.
## 5.6.2 The Instruction Cycle Specific to the LC-3
> [!question] Our Example Instruction 
> Suppose the content of the PC is `x3456` and the content of location `x3456` is the 16-bit value: 
> `0110 011 010 000100`
> ![[Pasted image 20251110205628.png]]
### 5.6.2.1 FETCH
The FETCH phase retrieves the instruction from memory using the address in the PC.

The FETCH phase for our `LDR` instruction proceeds in three steps:
- **Cycle 1:**
    - The contents of the PC (`x3456`) are loaded via the global bus into the **MAR**. This is done by asserting the `GatePC` and `LD.MAR` control signals.
    - Simultaneously, the PC is incremented. The `PCMUX` selects the `PC+1` input, and the `LD.PC` signal is asserted to load the new value (`x3457`) into the PC.
    - At the end of this cycle, the PC contains `x3457` and the MAR contains `x3456`.
- **Cycle 2:**
    - The control unit initiates a memory read.
    - The contents of memory location `x3456` (our `LDR` instruction) are read and loaded into the **MDR**.
- **Cycle 3:**
    - The contents of the MDR are transferred to the **Instruction Register (IR)**. This is done by asserting the `GateMDR` and `LD.IR` control signals.
    - This completes the FETCH phase. The IR now contains the instruction to be processed.
### 5.6.2.2 DECODE
The DECODE phase interprets the instruction in the **IR** resulting in the control logic providing the correct control signals (unfilled arrowheads) to control the processing of the rest of this instruction.
- **Cycle 4:**
    - The control unit examines the opcode (bits ``[15:12]``) of the **IR**, which is `0110`, identifying this as an `LDR` instruction.
    - The control unit decodes the remaining fields:
        - Bits ``[11:9]`` (`011`) identify the destination register as *R3*
        - Bits ``[8:6]`` (`010`) identify the base register as *R2*
        - Bits ``[5:0]`` (`000100`) represent the offset value of $4$
    - Based on this decoding, the control unit determines that the *Base+offset* addressing mode will be used and prepares the appropriate control signals for the EVALUATE ADDRESS phase.
    - No register values change during this phase; only the control logic is configured.
### 5.6.2.3 EVALUATE ADDRESS
The EVALUATE ADDRESS phase calculates the effective address of the operand to be fetched.
- **Cycle 5:**
    - The contents of the base register (*R2*) are read by asserting the `SR1` control signal with `010` (*R2*) as the input.
    - The offset value (bits ``[5:0]`` of the **IR**) is sign-extended to 16 bits. This is done by the `SEXT6` unit.
    - The `ADDR1MUX` selects the output of the register file (``SR1OUT``), which contains the contents of *R2*.
    - The `ADDR2MUX` selects the sign-extended offset (the second input from the right).
    - The ALU adds these two values: contents of *R2 + sign-extended offset*.
    - The result of this addition is loaded into the **MAR** by asserting the `GateMARMUX` and `LD.MAR` control signals.
    - At the end of this cycle, the **MAR** contains the effective address of the operand to be fetched.
### 5.6.2.4 OPERAND FETCH
The OPERAND FETCH phase retrieves the actual data from the calculated memory address.
- **Cycle 6:**
    - The control unit initiates a memory read operation.
    - The contents of the memory location specified by the **MAR** are read and loaded into the MDR.
    - If memory access requires more than one cycle, additional wait cycles would be inserted here.
    - At the end of this cycle, the **MDR** contains the data to be loaded into the destination register.
### 5.6.2.5 EXECUTE
The EXECUTE phase performs the actual operation specified by the instruction.
- **Cycle 7:**
    - For the `LDR` instruction, no actual execution is required in the **ALU** since the data has already been fetched from memory.
    - Therefore, this phase takes zero cycles for the `LDR` instruction.
    - The control unit simply skips to the STORE RESULT phase.
### 5.6.2.6 STORE RESULT
The STORE RESULT phase stores the fetched data into the destination register and updates the condition codes.
- **Cycle 8:**
    - The contents of the **MDR** are gated onto the bus by asserting the `GateMDR` control signal.
    - The destination register (*R3*) is selected by setting the `DR` control signal to `011`.
    - The `LD.REG` control signal is asserted to load the data from the bus into *R3*.
    - Simultaneously, the data from the bus is sent to the condition code logic.
    - The `LD.CC` control signal is asserted to update the *N*, *Z*, and *P* condition codes based on the value loaded into *R3*.
    - At the end of this cycle, *R3* contains the data from memory, and the condition codes reflect the status of this value.
This completes the full instruction cycle for the `LDR` instruction. 
The processor is now ready to begin the FETCH phase for the next instruction at address `x3457`.

```assembly
; ===================================================================
; MICRO-OPERATION TRACE FOR: LDR R3, R2, 4
; Initial State: PC = x3456, R2 = x3500 (assumed)
; Instruction at x3456 is: 0110 0 11 010 000100
; ===================================================================

; ------------------- PHASE 1: FETCH -------------------
; --- CYCLE 1 ---
; Load the Memory Address Register (MAR) with the PC's contents.
; Simultaneously, increment the Program Counter (PC).
GatePC          ; Put PC (x3456) onto the bus.
LD.MAR          ; Load MAR from the bus. MAR = x3456.
PCMUX_SEL = PC+1; Select the incremented PC value.
LD.PC           ; Load PC with the new value. PC = x3457.

; --- CYCLE 2 ---
; Initiate a memory read using the address in the MAR.
; The instruction at x3456 is placed into the Memory Data Register (MDR).
READ_MEM        ; Read from address in MAR. MDR = 0110011010000100.

; --- CYCLE 3 ---
; Transfer the instruction from the MDR to the Instruction Register (IR).
GateMDR         ; Put instruction from MDR onto the bus.
LD.IR           ; Load IR from the bus. FETCH phase complete.


; ------------------- PHASE 2: DECODE -------------------
; --- CYCLE 4 ---
; The control unit analyzes the IR to determine the required actions.
; No datapath registers are changed in this cycle.
; DECODE: Control unit analyzes IR[15:12] = 0110 (LDR instruction).
; Identifies DR=R3, BaseR=R2, offset6=4.
; Sets up internal control logic for the EVALUATE ADDRESS phase.


; ------------------- PHASE 3: EVALUATE ADDRESS -------------------
; --- CYCLE 5 ---
; Calculate the effective address by adding the base register to the offset.
SR1_SEL = R2    ; Select register R2 as the source for SR1OUT.
ADDR2MUX_SEL = SEXT6 ; Select the sign-extended offset6 from IR.
ALU_OP = ADD    ; Set the ALU to perform addition.
GateMARMUX      ; Gate the ALU result (R2 + offset) onto the bus.
LD.MAR          ; Load MAR with the calculated effective address.
; MAR = x3500 + 4 = x3504.


; ------------------- PHASE 4: OPERAND FETCH -------------------
; --- CYCLE 6 ---
; Read the data from the calculated effective address.
READ_MEM        ; Read from address in MAR (x3504).
; The data value (e.g., xABCD) is loaded into the MDR.


; ------------------- PHASE 5: EXECUTE -------------------
; --- CYCLE 7 (SKIPPED) ---
; The LDR instruction does not require an execution step in the ALU.
; The data has already been fetched from memory, so this phase is a no-op.


; ------------------- PHASE 6: STORE RESULT -------------------
; --- CYCLE 8 ---
; Store the data from the MDR into the destination register (R3).
; Also, update the condition codes (N, Z, P) based on the loaded value.
GateMDR         ; Put data from MDR (xABCD) onto the bus.
DR_SEL = R3     ; Select R3 as the destination register.
LD.REG          ; Load R3 with the data from the bus. R3 = xABCD.
LD.CC           ; Update N, Z, P condition codes based on value xABCD.

; ===================================================================
; INSTRUCTION CYCLE COMPLETE.
; Final State: PC = x3457, R3 = xABCD, NZP updated.
; ===================================================================
```
## 5.6.1.6 Tying It All Together: How Instructions Use the Data Path
Understanding the data path is about seeing how different components work together for each instruction type. Let's trace the primary data flow for the three main instruction categories.
> [!example] Operate Instruction (e.g., `ADD R2, R1, R0`)
> 
1. **FETCH**: The `ADD` instruction is loaded from memory into the **IR**.
2. **DECODE**: The control unit identifies it as an `ADD` and decodes the register fields (**DR**=*R2*, **SR1**=*R1*, **SR2**=*R0*).
3. **EXECUTE**:
    - The value from *R1* is placed on the bus as `SR1OUT`.
    - The value from *R0* is placed on the bus as `SR2OUT`.
    - The ALU receives these two values, performs the addition, and outputs the 16-bit sum.
4. **STORE RESULT**:
    - The **ALU**'s result is gated onto the global bus.
    - The `LD.REG` signal for *R2* is asserted, loading the sum into *R2*.
    - The result is also sent to the condition code logic, and `LD.CC` is asserted to update the *N*, *Z*, *P* flags. 
    **Key Components Used**: **IR**, Register File, **ALU**, Global Bus, Condition Code Logic.

> [!example] Data Movement Instruction (e.g., `LDR R3, R2, #4`)
1. **FETCH**: The `LDR` instruction is loaded into the **IR**.
2. **DECODE**: The control unit identifies it as `LDR` and decodes the fields (**DR**=*R3*, **BaseR**=*R2*, offset=$4$).
3. **EVALUATE ADDRESS**:
    - The value from *R2* is gated to the **ALU** as `SR1OUT`.
    - The sign-extended offset `#4` is selected as the second **ALU** input.
    - The **ALU** adds them, producing the effective address (`R2 + 4`).
    - This address is gated via the `GateMARMUX` and loaded into the **MAR**.
4. **OPERAND FETCH**: Memory is read using the address in the **MAR**, and the data is loaded into the **MDR**.
5. **STORE RESULT**:
    - The value from the **MDR** is gated onto the global bus.
    - The `LD.REG` signal for *R3* is asserted, loading the data into *R3*.
    - `LD.CC` is asserted to update the condition codes. 
    **Key Components Used**: **IR**, Register File, **ALU** (for address calculation), **MARMUX**, **MAR**, **MDR**, Global Bus, Condition Code Logic.

> [!example] Control Instruction (e.g., `BRzp LOOP`)
1. **FETCH**: The `BR` instruction is loaded into the **IR**.
2. **DECODE**: The control unit identifies it as `BR` and decodes the condition (`zp`) and the **PCoffset**.
3. **EVALUATE ADDRESS**: The special-purpose adder calculates `PC + PCoffset`. This value is held as a potential next PC address.
4. **EXECUTE**:
    - The control unit checks the *Z* and *P* condition codes.
    - If either is set, the `PCMUX` is set to select the `PC + PCoffset` value.
    - `LD.PC` is asserted, loading the branch target address into the PC.
    - If neither is set, nothing happens, and the PC (which was incremented during FETCH) remains unchanged. 
    **Key Components Used**: **IR**, Condition Codes, Special Adder, **PCMUX**, PC.