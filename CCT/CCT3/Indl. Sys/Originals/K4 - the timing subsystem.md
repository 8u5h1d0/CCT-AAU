---
tags:
  - CCT3
  - indlejrede_systemer
Topic: the timing subsystem, Timer Prescaler & TOUT Relationship, Interrupt Service Routines
Semester: CCT3
Course: Programmering af indlejrede systemer
Litterature:
  - "Arduino II: Systems"
  - Secrets of Arduino PWM 
  - The Arduino reference, two short passages
  - "\rArduino Timer Interrupts Tutorial & Examples"
Created: 11-10-2026
---
- - -
## Table of Contents

1. [[#4.2 TIMING-RELATED TERMINOLOGY|4.2 TIMING-RELATED TERMINOLOGY]]
	1. [[#4.2 TIMING-RELATED TERMINOLOGY#4.2.1 FREQUENCY|4.2.1 FREQUENCY]]
	2. [[#4.2 TIMING-RELATED TERMINOLOGY#4.2.2 PERIOD|4.2.2 PERIOD]]
	3. [[#4.2 TIMING-RELATED TERMINOLOGY#4.2.3 DUTY CYCLE|4.2.3 DUTY CYCLE]]
2. [[#4.3 TIMING SYSTEM OVERVIEW|4.3 TIMING SYSTEM OVERVIEW]]
	1. [[#4.3 TIMING SYSTEM OVERVIEW#The Free-Running Counter|The Free-Running Counter]]
	2. [[#4.3 TIMING SYSTEM OVERVIEW#ATmega328 Clock Sources|ATmega328 Clock Sources]]
	3. [[#4.3 TIMING SYSTEM OVERVIEW#Input and Output Timing Operations|Input and Output Timing Operations]]
		1. [[#Input and Output Timing Operations#Input Timer Functions (Event Capture)|Input Timer Functions (Event Capture)]]
		2. [[#Input and Output Timing Operations#Output Timer Functions (Waveform Generation)|Output Timer Functions (Waveform Generation)]]
	4. [[#4.3 TIMING SYSTEM OVERVIEW#Calculating Absolute Time from Counter Values|Calculating Absolute Time from Counter Values]]
	5. [[#4.3 TIMING SYSTEM OVERVIEW#Handling Counter Rollovers (Overflows)|Handling Counter Rollovers (Overflows)]]
3. [[#4.4 TIMER SYSTEM APPLICATIONS|4.4 TIMER SYSTEM APPLICATIONS]]
	1. [[#4.4 TIMER SYSTEM APPLICATIONS#4.4.1 INPUT CAPTURE – MEASURING EXTERNAL TIMING EVENT|4.4.1 INPUT CAPTURE – MEASURING EXTERNAL TIMING EVENT]]
		1. [[#4.4.1 INPUT CAPTURE – MEASURING EXTERNAL TIMING EVENT#Configuration Steps|Configuration Steps]]
		2. [[#4.4.1 INPUT CAPTURE – MEASURING EXTERNAL TIMING EVENT#Detection Methods|Detection Methods]]
	2. [[#4.4 TIMER SYSTEM APPLICATIONS#4.4.2 COUNTING EVENTS|4.4.2 COUNTING EVENTS]]
	3. [[#4.4 TIMER SYSTEM APPLICATIONS#4.4.3 OUTPUT COMPARE – GENERATING TIMING SIGNALS TO INTERFACE EXTERNAL DEVICES|4.4.3 OUTPUT COMPARE – GENERATING TIMING SIGNALS TO INTERFACE EXTERNAL DEVICES]]
		1. [[#4.4.3 OUTPUT COMPARE – GENERATING TIMING SIGNALS TO INTERFACE EXTERNAL DEVICES#Operational Sequence|Operational Sequence]]
	4. [[#4.4 TIMER SYSTEM APPLICATIONS#4.4.4 INDUSTRIAL IMPLEMENTATION CASE STUDY (PWM)|4.4.4 INDUSTRIAL IMPLEMENTATION CASE STUDY (PWM)]]
		1. [[#4.4.4 INDUSTRIAL IMPLEMENTATION CASE STUDY (PWM)#Generating PWM via Free-Running Counter and Compare Registers|Generating PWM via Free-Running Counter and Compare Registers]]
4. [[#4.5 OVERVIEW OF THE MICROCHIP ATMEGA328 TIMER SYSTEM|4.5 OVERVIEW OF THE MICROCHIP ATMEGA328 TIMER SYSTEM]]
	1. [[#4.5 OVERVIEW OF THE MICROCHIP ATMEGA328 TIMER SYSTEM#Timer Channel Specifications|Timer Channel Specifications]]
	2. [[#4.5 OVERVIEW OF THE MICROCHIP ATMEGA328 TIMER SYSTEM#Core Capabilities|Core Capabilities]]
	3. [[#4.5 OVERVIEW OF THE MICROCHIP ATMEGA328 TIMER SYSTEM#Operating Modes|Operating Modes]]
5. [[#4.6 TIMER 0 SYSTEM|4.6 TIMER 0 SYSTEM]]
	1. [[#4.6 TIMER 0 SYSTEM#Architecture and Clock Selection|Architecture and Clock Selection]]
	2. [[#4.6 TIMER 0 SYSTEM#Counter Comparison and Waveform Generation|Counter Comparison and Waveform Generation]]
	3. [[#4.6 TIMER 0 SYSTEM#4.6.1 MODES OF OPERATION|4.6.1 MODES OF OPERATION]]
		1. [[#4.6.1 MODES OF OPERATION#4.6.1.1 Normal Mode|4.6.1.1 Normal Mode]]
		2. [[#4.6.1 MODES OF OPERATION#4.6.1.2 Clear Timer on Compare Match (CTC)|4.6.1.2 Clear Timer on Compare Match (CTC)]]
		3. [[#4.6.1 MODES OF OPERATION#4.6.1.3 Phase Correct PWM Mode|4.6.1.3 Phase Correct PWM Mode]]
		4. [[#4.6.1 MODES OF OPERATION#4.6.1.4 Fast PWM|4.6.1.4 Fast PWM]]
	4. [[#4.6 TIMER 0 SYSTEM#4.6.2 TIMER 0 REGISTERS|4.6.2 TIMER 0 REGISTERS]]
		1. [[#4.6.2 TIMER 0 REGISTERS#4.6.2.1 Timer/Counter Control Registers A and B (TCCR0A and TCCR0B)|4.6.2.1 Timer/Counter Control Registers A and B (TCCR0A and TCCR0B)]]
		2. [[#4.6.2 TIMER 0 REGISTERS#4.6.2.2 Timer/Counter Register (TCNT0)|4.6.2.2 Timer/Counter Register (TCNT0)]]
		3. [[#4.6.2 TIMER 0 REGISTERS#4.6.2.3 Output Compare Registers A and B (OCR0A and OCR0B)|4.6.2.3 Output Compare Registers A and B (OCR0A and OCR0B)]]
		4. [[#4.6.2 TIMER 0 REGISTERS#4.6.2.4 Timer/Counter Interrupt Mask Register (TIMSK0)|4.6.2.4 Timer/Counter Interrupt Mask Register (TIMSK0)]]
		5. [[#4.6.2 TIMER 0 REGISTERS#4.6.2.5 Timer/Counter Interrupt Flag Register 0 (TIFR0)|4.6.2.5 Timer/Counter Interrupt Flag Register 0 (TIFR0)]]
6. [[#4.9 PROGRAMMING THE ARDUINO UNO R3 USING THE BUILT-IN ARDUINO DEVELOPMENT ENVIRONMENT TIMING FEATURES|4.9 PROGRAMMING THE ARDUINO UNO R3 USING THE BUILT-IN ARDUINO DEVELOPMENT ENVIRONMENT TIMING FEATURES]]
	1. [[#4.9 PROGRAMMING THE ARDUINO UNO R3 USING THE BUILT-IN ARDUINO DEVELOPMENT ENVIRONMENT TIMING FEATURES#Built-In Timing Functions|Built-In Timing Functions]]
7. [[#Arduino Timers|Arduino Timers]]
	1. [[#Arduino Timers#1. Arduino Hardware Timers|1. Arduino Hardware Timers]]
	2. [[#Arduino Timers#2. Arduino Timer Prescaler|2. Arduino Timer Prescaler]]
		1. [[#2. Arduino Timer Prescaler#Functional Purpose of the Prescaler|Functional Purpose of the Prescaler]]
	3. [[#Arduino Timers#3. Arduino Timer Interrupts|3. Arduino Timer Interrupts]]
	4. [[#Arduino Timers#4. Arduino Timers Comparison|4. Arduino Timers Comparison]]
	5. [[#Arduino Timers#5. Arduino Timers Control Registers|5. Arduino Timers Control Registers]]
8. [[#Arduino Timer Interrupts|Arduino Timer Interrupts]]
	1. [[#Arduino Timer Interrupts#Arduino Timer Equations|Arduino Timer Equations]]
9. [[#![[Pasted image 20261011185538.png]]|![[Pasted image 20261011185538.png]]]]
	1. [[#![[Pasted image 20261011185538.png]]#Arduino Timer Calculations|Arduino Timer Calculations]]
10. [[#![[Pasted image 20261011185552.png]]|![[Pasted image 20261011185552.png]]]]
	1. [[#![[Pasted image 20261011185552.png]]#Arduino Timer Interrupt Code Methods|Arduino Timer Interrupt Code Methods]]
		1. [[#Arduino Timer Interrupt Code Methods#1. Timer Preloading (Overflow Method)|1. Timer Preloading (Overflow Method)]]
		2. [[#Arduino Timer Interrupt Code Methods#2. Timer Compare Match (Preferred Method)|2. Timer Compare Match (Preferred Method)]]
	2. [[#![[Pasted image 20261011185552.png]]#Timer Prescaler & $T_{\text{OUT}}$ Relationship|Timer Prescaler & $T_{\text{OUT}}$ Relationship]]
	3. [[#![[Pasted image 20261011185552.png]]#Code Implementations|Code Implementations]]
		1. [[#Code Implementations#Overflow Interrupt with Timer Preloading|Overflow Interrupt with Timer Preloading]]
		2. [[#Code Implementations#Compare Match Interrupt (Single Channel: COMPA)|Compare Match Interrupt (Single Channel: COMPA)]]
		3. [[#Code Implementations#Dual Compare Match Interrupt (Independent Channels: COMPA & COMPB)|Dual Compare Match Interrupt (Independent Channels: COMPA & COMPB)]]
11. [[#Pulse Width Modulation|Pulse Width Modulation]]
	1. [[#Pulse Width Modulation#PWM Examples|PWM Examples]]
12. [[#Simple Pulse Width Modulation with analogWrite|Simple Pulse Width Modulation with analogWrite]]
13. [[#Bit-Banging Pulse Width Modulation|Bit-Banging Pulse Width Modulation]]
14. [[#Using the ATmega PWM Registers Directly|Using the ATmega PWM Registers Directly]]
	1. [[#Using the ATmega PWM Registers Directly#The ATmega 168/328 Timers|The ATmega 168/328 Timers]]
	2. [[#Using the ATmega PWM Registers Directly#Timer Registers|Timer Registers]]
	3. [[#Using the ATmega PWM Registers Directly#Fast PWM|Fast PWM]]
	4. [[#Using the ATmega PWM Registers Directly#Phase-Correct PWM|Phase-Correct PWM]]
	5. [[#Using the ATmega PWM Registers Directly#Varying the timer top limit: fast PWM|Varying the timer top limit: fast PWM]]
	6. [[#Using the ATmega PWM Registers Directly#Varying the timer top limit: phase-correct PWM|Varying the timer top limit: phase-correct PWM]]
	7. [[#Using the ATmega PWM Registers Directly#Off-by-one|Off-by-one]]
		1. [[#Off-by-one#Cycle Divisors|Cycle Divisors]]
		2. [[#Off-by-one#Minimum and Maximum Duty Cycle Behavior|Minimum and Maximum Duty Cycle Behavior]]
	8. [[#Using the ATmega PWM Registers Directly#Timers and the Arduino|Timers and the Arduino]]
		1. [[#Timers and the Arduino#Pin and Port Mapping|Pin and Port Mapping]]
		2. [[#Timers and the Arduino#Default Core Configurations|Default Core Configurations]]
		3. [[#Timers and the Arduino#Architecture Differences Across Boards|Architecture Differences Across Boards]]
15. [[#Troubleshoot|Troubleshoot]]

## 4.1 OVERVIEW

A primary reason for using microcontrollers is their capability to execute _time-related tasks_. These operations range widely in complexity based on application needs:

> [!example] Applications of Microcontroller Timing
> - **Simple Applications:** Programming a microcontroller to turn an external device on or off at a specific time.
> - **Complex Applications:** Generating complex digital waveforms with varying pulse widths, such as for controlling the speed of a DC motor.

Understanding the time-related functionality of the Microchip ***ATmega328*** microcontroller requires exploring several key areas:

- **Timing-Related Terminology:** Core terms and definitions governing temporal operations.
- **General Timing System Operation:** The foundational principles of how timing systems function.
- **ATmega328 Timing Features:** The specific onboard hardware timing capabilities of the microcontroller.
- **Timing Channels and Modes:** The individual timing channels available and their distinct modes of operation.
- **Built-In ADE Timing Functions:** The standard timing functions provided within the development environment.
## 4.2 TIMING-RELATED TERMINOLOGY

Timing operations in microcontroller systems rely on foundational concepts including _frequency_, _period_, and _duty cycle_.

### 4.2.1 FREQUENCY

A signal is considered _periodic_ if it repeats its pattern at regular intervals over time. 

> [!summary] Definition: Periodic Signal
> A signal $x(t)$ is periodic with period $T$ if it satisfies:
> $$x(t) = x(t + T)$$
> 
> **breakdown**:
> - $x(t)$ : The amplitude or value of the signal at time $t$.
> - $t$ : Continuous time variable.
> - $T$ : The period, representing the exact duration of one complete cycle.

To measure the _frequency_ of a periodic signal, count the number of times a particular event repeats within a 1-second interval. 

- **Unit of Frequency:** Measured in ***Hertz*** ($\text{Hz}$) or cycles per second.

> [!example] Sinusoidal Wave Frequency
> A sinusoidal signal with a $60\text{ Hz}$ frequency indicates that a full cycle repeats 60 times each second, which corresponds to one cycle every $16.67\text{ ms}$.

---

### 4.2.2 PERIOD

The _period_ of a waveform is the mathematical reciprocal of its frequency. If an event occurs at a rate of $1\text{ Hz}$, the period of that event is $1\text{ s}$. 

> [!summary] Definition: Frequency and Period Relationship
> The inverse relationship between frequency ($f$) and period ($T$) is defined as:
> $$f = \frac{1}{T} \quad \iff \quad T = \frac{1}{f}$$
> 
> **breakdown**:
> - $f$ : Frequency of the signal in Hertz ($\text{Hz}$).
> - $T$ : Period of the signal in seconds ($\text{s}$).

Both period and frequency are used to specify timing constraints in microcontroller-based systems.

> [!example] Real-Time System Timing Constraints
> An anti-slippage control unit in a vehicle may be designed to react within a $20\text{ ms}$ window. To satisfy this requirement, the monitoring system must check for slippage at a frequency of:
> $$f = \frac{1}{0.020\text{ s}} = 50\text{ Hz}$$

---

### 4.2.3 DUTY CYCLE

Periodic digital pulses are frequently employed as control signals, such as when controlling the speed and direction of a servo motor by varying the pulse width over time.

> [!info] Definition: Duty Cycle
> The ***duty cycle*** is defined as the percentage of the total signal period ($T$) during which the signal is active, *on*, or at a *logic high* level:
> 
> - **50% Duty Cycle:** A pulse that is logic high for 50% of the period and logic low (off) for the remaining 50%.
> - **25% Duty Cycle:** A pulse that is logic high for 25% of the period and logic low for 75% of the period.
>   
>   ![[Pasted image 20261011181729.png]]
>   Figure 4.1: Two signals with the same period but different duty cycles. The top figure (a) shows a periodic signal with a 50% duty cycle and the lower figure (b) displays a periodic signal with a 25% duty cycle.

## 4.3 TIMING SYSTEM OVERVIEW

The foundation of any microcontroller timing system is the ***time base***, which generates a baseline clock signal used to drive internal timing operations.

### The Free-Running Counter

The baseline clock updates the contents of a dedicated hardware register called the ***free-running counter (FRC)***. 

- **Operation:** The free-running counter increments (counts up) on each clock edge (either rising or falling).
- **Function:** All time-related input and output activities reference the counter's current value to measure time intervals, capture external event timestamps, and generate output waveforms.

---

### ATmega328 Clock Sources

The ATmega328 can be driven by either internal or external clock sources:

- **Internal Clock Source:** An internal user-selectable RC time base configured via programmable fuse bits. Available fixed base frequencies include $1\text{ MHz}$, $2\text{ MHz}$, $4\text{ MHz}$, or $8\text{ MHz}$, which can be further divided using internal prescalers.
- **External Clock Sources:** Selected when higher precision and stability are required. In order of increasing accuracy and stability:
  1. External RC network
  2. Ceramic resonator
  3. Crystal oscillator

> [!info] Clock Frequency Specifications
> - **Maximum Operating Frequency:** $20\text{ MHz}$ for the ATmega328P with a $5\text{ VDC}$ supply voltage.
> - **Arduino UNO R3:** Uses an onboard $16\text{ MHz}$ crystal oscillator as its primary time base.

---

### Input and Output Timing Operations

#### Input Timer Functions (Event Capture)
Input hardware detects logic state transitions (rising or falling edges) on designated input pins and captures the current value of the free-running counter when an event occurs.

- **Applications:** Measuring signal periods, determining pulse widths of periodic signals, and calculating the duration of aperiodic pulses.
- **Principle:** If the rising edge of a pulse is captured at $t_1 = 1.5\text{ s}$ and the falling edge at $t_2 = 1.6\text{ s}$, the pulse width is calculated directly as:
  $$\Delta t = t_2 - t_1 = 1.6\text{ s} - 1.5\text{ s} = 0.1\text{ s}$$

#### Output Timer Functions (Waveform Generation)
Output timer systems use a hardware _comparator_, the free-running counter, logic switches, and special-purpose registers to produce timed signals on output pins:

1. A programmer writes a target count value to a dedicated compare register.
2. The comparator checks the free-running counter against this register on each clock cycle.
3. When a match occurs, the hardware automatically triggers a predefined logic change (set, clear, or toggle) on a specific output pin.
4. **Applications:** Generating precise time delays, single pulses of defined duration, or continuous _Pulse Width Modulated (PWM)_ waveforms for DC and servo motor control.

---

### Calculating Absolute Time from Counter Values

Microcontrollers track time in discrete count values (clock ticks) rather than standard engineering units. Converting count values to physical time requires knowing the clock period ($T_{\text{clk}}$).

> [!example] Pulse Width Calculation from Hexadecimal Counts
> Consider a $16\text{-bit}$ free-running counter running at a clock frequency of $f = 2\text{ MHz}$:
> 
> 1. **Clock Period:**
>    $$T_{\text{clk}} = \frac{1}{2\text{ MHz}} = 0.5\text{ }\mu\text{s}$$
> 
> 2. **Full Counter Range:** A $16\text{-bit}$ counter counts from $0$ to $2^{16}-1$ ($65,535$). The total rollover time is:
>    $$65,536 \times 0.5\text{ }\mu\text{s} \approx 32.78\text{ ms}$$
> 
> 3. **Interval Calculation:**
>    - Rising edge captured at count: $\$0010_{16} = 16_{10}$
>    - Falling edge captured at count: $\$0114_{16} = 276_{10}$
>    - Total elapsed counts: $276 - 16 = 260\text{ counts}$
>    - Pulse width:
>      $$\text{Pulse Width} = 260 \times 0.5\text{ }\mu\text{s} = 130\text{ }\mu\text{s}$$

---

### Handling Counter Rollovers (Overflows)

When the counter increments past its maximum value ($2^b - 1$), it rolls over to zero and sets a hardware ***Timer Overflow Flag (TOF)***. For intervals spanning multiple rollovers, the total elapsed time incorporates the number of overflow events.

> [!summary] Equation: Total Elapsed Time with Rollovers
> $$\text{elapsed clock ticks} = \left(n \times 2^b\right) + (\text{stop count} - \text{start count})$$
> $$\text{elapsed time} = (\text{elapsed clock ticks}) \times (\text{FRC clock period})$$
> 
> **breakdown**:
> - $n$ : The number of Timer Overflow Flag ($\text{TOF}$) events occurring between start and stop.
> - $b$ : The bit resolution of the timer counter (e.g., $8\text{ bits}$ or $16\text{ bits}$).
> - $2^b$ : The total count capacity per complete overflow cycle (e.g., $256$ for an $8\text{-bit}$ timer, $65,536$ for a $16\text{-bit}$ timer).
> - $\text{start count}$ : Counter value recorded at the beginning of the timed event.
> - $\text{stop count}$ : Counter value recorded at the end of the timed event.
> - $\text{FRC clock period}$ : The duration of a single tick of the free-running counter clock ($T_{\text{clk}} = \frac{1}{f_{\text{clk}}}$).

## 4.4 TIMER SYSTEM APPLICATIONS

Microcontroller timing systems serve four primary operational functions:

1. **Input Capture:** Measuring the time intervals, pulse widths, or frequencies of external input signals.
2. **Event Counting:** Tracking the number of occurrences of external logic state changes.
3. **Output Compare:** Generating deterministic time delays, individual pulses, or periodic waveforms.
4. **Pulse Width Modulation (PWM):** Generating variable duty-cycle signals for power and motor control.

---

### 4.4.1 INPUT CAPTURE – MEASURING EXTERNAL TIMING EVENT

Input capture determines the period, frequency, or pulse width of an external signal by recording the free-running counter (FRC) value at the exact instant an electrical transition occurs.

#### Configuration Steps
1. **Enable the Timer Module:** Timers are typically disabled after a system reset to conserve power and must be explicitly enabled.
2. **Select Clock Prescaler:** Configure the timer clock rate that drives the free-running counter.
3. **Configure the Input Port:** Designate the physical pin as a timer input using port configuration registers.
4. **Define the Capture Event:** Program the input capture unit to trigger on rising edges, falling edges, or both.

#### Detection Methods

- **Polling:** The CPU continuously monitors a hardware capture flag. When the flag sets:
  1. The program reads and stores the captured counter value from the capture register.
  2. The flag is cleared in software.
  3. The program waits for the subsequent capture event and records the second value.
  - *Limitation:* Polling consumes CPU processing cycles, preventing execution of other tasks.
- **Interrupts:** The capture event automatically triggers an ***Interrupt Service Routine (ISR)***. The ISR clears the flag and saves the captured count value, freeing the CPU to execute primary code between transitions.

![[Pasted image 20261011182549.png]]
Figure 4.2: Use of the timer input and output systems of a microcontroller. The signal on top is fed into a timer input port. The captured signal is subsequently used to compute the input signal frequency. The signal on the bottom is generated using the timer output system. The signal is used to control an external device.

> [!example] Frequency Measurement via Input Capture
> Consider two consecutive rising edges captured by a timer running at a clock frequency of $f_{\text{clk}} = 10\text{ MHz}$:
> 
> - **First Captured Count ($t_1$):** $\$1000_{16} = 4,096_{10}$
> - **Second Captured Count ($t_2$):** $\$5000_{16} = 20,480_{10}$
> - **Clock Period ($T_{\text{clk}}$):**
>   $$T_{\text{clk}} = \frac{1}{10\text{ MHz}} = 0.1\text{ }\mu\text{s}$$
> - **Elapsed Count Difference ($\Delta\text{count}$):**
>   $$\Delta\text{count} = \$5000_{16} - \$1000_{16} = \$4000_{16} = 16,384\text{ counts}$$
> - **Signal Period ($T$):**
>   $$T = 16,384 \times 0.1\text{ }\mu\text{s} = 1.6384\text{ ms}$$
> - **Signal Frequency ($f$):**
>   $$f = \frac{1}{T} = \frac{1}{1.6384\text{ ms}} \approx 610.35\text{ Hz}$$

---

### 4.4.2 COUNTING EVENTS

The input capture subsystem can be repurposed to count occurrences of external events over a specified duration.

- **Configuration:** The timer is enabled and the input pin is configured to detect logic state changes (e.g., any transition, rising edges, or falling edges).
- **Execution via Polling:** The microcontroller repeatedly checks the event flag, clears it upon detection, and increments a software counter variable.
- **Execution via Interrupts:** Each state transition generates an interrupt request, prompting an ISR to clear the flag and increment the event count.

---

### 4.4.3 OUTPUT COMPARE – GENERATING TIMING SIGNALS TO INTERFACE EXTERNAL DEVICES

The ***Output Compare*** system produces timed output transitions and pulses by comparing the free-running counter against a user-defined threshold value stored in an output compare register.

#### Operational Sequence
1. Enable the timer module and configure the target physical pin as a timer output.
2. Initialize the pin to a known state (e.g., logic low).
3. Write a target count value to the output compare register corresponding to the desired time of the next edge.
4. On each clock tick, the hardware comparator checks if $\text{FRC} = \text{Output Compare Register}$.
5. Upon a match, the hardware automatically drives the pin to the programmed state (set high, clear low, or toggle) and can trigger an interrupt.
6. To generate a pulse, reconfigure the compare register with a new count value and set the hardware to trigger the opposite transition (e.g., logic low).

![[Pasted image 20261011183358.png]]
Figure 4.3: The figure shows the speed profile of a DC motor over time when a pulse-widthmodulated signal is applied to the motor.

> [!example] Generating a Precise Output Pulse
> To generate a $2\text{ ms}$ active-high pulse using a $16\text{-bit}$ timer clocked at $2\text{ MHz}$:
> 
> - **Clock Period:** $T_{\text{clk}} = \frac{1}{2\text{ MHz}} = 0.5\text{ }\mu\text{s}$
> - **Required Counts:**
>   $$\text{Counts} = \frac{2\text{ ms}}{0.5\text{ }\mu\text{s}} = 4000\text{ counts} = \$0\text{FA0}_{16}$$
> - **Procedure:**
>   1. Initialize output pin to low.
>   2. Set the compare register to $\$0000_{16}$ and configure the action to drive the pin *high* upon match.
>   3. Once the rising edge occurs, load $\$0\text{FA0}_{16}$ ($4000_{10}$) into the compare register and configure the action to drive the pin *low* upon match.

---

### 4.4.4 INDUSTRIAL IMPLEMENTATION CASE STUDY (PWM)

***Pulse Width Modulation (PWM)*** controls average power delivery to analog loads, such as Direct Current (DC) motors. 

When a DC motor receives rapid on-off voltage pulses, the mechanical inertia and inductance of the motor smooth out the switching, causing it to operate at a speed proportional to the average applied voltage (governed by the signal's duty cycle).

> [!info] Motor Acceleration Profiling
> Real-world motion systems (such as elevator controllers) do not switch instantaneously between zero and full speed. Instead, they gradually ramp the duty cycle up during acceleration, maintain a constant duty cycle at target speed, and ramp the duty cycle down during deceleration.

#### Generating PWM via Free-Running Counter and Compare Registers

Using a $16\text{-bit}$ timer where one full cycle spans from count $\$0000_{16}$ to $\$FFFF_{16}$ ($65,536$ counts):

1. The output pin is set high at count $\$0000_{16}$.
2. The pin is cleared low when the counter matches the output compare register.
3. The signal period is the full rollover duration ($0 \to 65,535$).
4. A $25\%$ duty cycle requires a compare threshold of:
   $$0.25 \times 65,536 = 16,384\text{ counts} = \$4000_{16}$$

> [!example] Dynamic Duty Cycle Ramping
> To linearly ramp a motor from a $25\%$ duty cycle ($\$4000_{16}$) to a $50\%$ duty cycle ($\$8000_{16}$) over $1\text{ s}$ with a $2\text{ MHz}$ timer clock:
> 
> - **Rollover Period ($T_{\text{PWM}}$):**
>   $$T_{\text{PWM}} = 65,536 \times 0.5\text{ }\mu\text{s} = 32.768\text{ ms}$$
> - **Total Cycles in $1\text{ Second}$:**
>   $$\text{Cycles} = \frac{1\text{ s}}{0.032768\text{ s}} \approx 30.51\text{ cycles}$$
> - **Total Count Increase:**
>   $$\Delta\text{Count} = \$8000_{16} - \$4000_{16} = 32,768 - 16,384 = 16,384\text{ counts}$$
> - **Count Adjustment per Cycle:**
>   $$\text{Increment per Cycle} = \frac{16,384\text{ counts}}{30\text{ cycles}} \approx 546\text{ counts/cycle}$$
> 
> Adding approximately $546$ counts to the compare register on each counter rollover smoothly transitions the motor speed over the $1\text{-second}$ window.

## 4.5 OVERVIEW OF THE MICROCHIP ATMEGA328 TIMER SYSTEM

The Microchip ATmega328 features a flexible, multi-channel hardware timing system consisting of three independent timer channels: ***Timer 0***, ***Timer 1***, and ***Timer 2***.

### Timer Channel Specifications

- **Timer 0:** $8\text{-bit}$ timer/counter.
- **Timer 1:** $16\text{-bit}$ timer/counter (includes dedicated _Input Capture_ capabilities).
- **Timer 2:** $8\text{-bit}$ timer/counter.

Each channel is equipped with an independent ***prescaler***, which divides the main microcontroller I/O clock frequency ($f_{\text{clk\_I/O}}$) down to a lower timer clock frequency ($\text{clk}_{Tn}$) to provide longer timing intervals.

![[Pasted image 20261011183506.png]]
Figure 4.4: Microchip timer system overview [www.microchip.com].

---

### Core Capabilities

All three timer channels support the following standard operations:

- Generating _Pulse Width Modulated (PWM)_ signals.
- Producing periodic signals at precise frequencies.
- Counting external signal events.
- Generating deterministic output timing signals using hardware _output compare_ channels.
- **Timer 1 Specific:** Capturing external input timestamps via its built-in _Input Capture_ unit.

---

### Operating Modes

> [!info] Timer Operational Modes
> All ATmega328 timing channels can be configured to run in one of four primary modes:
> 
> 1. **Normal Mode:** The counter increments continuously until it reaches its maximum value, overflows back to zero, and sets an overflow flag.
> 2. **Clear Timer on Compare Match (CTC) Mode:** The counter clears to zero automatically when its count matches a predefined value in an output compare register, allowing precise frequency generation.
> 3. **Fast PWM Mode:** High-frequency, single-slope pulse width modulation suitable for power regulation, DACs, and rapid switching applications.
> 4. **Phase Correct PWM Mode:** Dual-slope (up-and-down counting) pulse width modulation providing symmetric waveforms with reduced harmonic distortion, commonly used in motor control.

## 4.6 TIMER 0 SYSTEM

Timer 0 is an $8\text{-bit}$ timer/counter module within the ATmega328. The architectural concepts, registers, and operational modes of Timer 0 serve as the baseline template for the other timer channels aboard the microcontroller.

### Architecture and Clock Selection

Timer 0 can receive its clock signal from two primary sources:
- **External Clock Source:** Sourced through the microcontroller's physical `T0` pin.
- **Internal Clock Source:** Derived from the main microcontroller I/O clock ($f_{\text{clk\_I/O}}$).

Because the main system clock is often too fast for standard timing requirements, an internal prescaler subdivides $f_{\text{clk\_I/O}}$ down to the timer operating frequency ($\text{clk}_{T0}$). Clock source and prescaler division ratios are configured using the Clock Select bits (`CS0[2:0]`) in the Timer/Counter Control Register B (`TCCR0B`).

The resulting clock ($\text{clk}_{T0}$) drives the $8\text{-bit}$ Timer/Counter Register (`TCNT0`), which increments or decrements on each clock pulse.

```
                  +---------------------------+
                  |  Clock Source Selection   |
                  | (Internal / Prescaled /   |
                  |     External Pin T0)      |
                  +-------------+-------------+
                                | clk_T0
                                v
                  +---------------------------+
                  |    8-bit Counter (TCNT0)  |
                  +-------------+-------------+
                                |
             +------------------+------------------+
             |                                     |
             v                                     v
+------------------------+             +------------------------+
| 8-bit Comparator A     |             | 8-bit Comparator B     |
| (Compares TCNT0 &      |             | (Compares TCNT0 &      |
|  OCR0A)                |             |  OCR0B)                |
+-----------+------------+             +-----------+------------+
            |                                      |
            v                                      v
+------------------------+             +------------------------+
|  Waveform Generator A  |             |  Waveform Generator B  |
|  (Output Pin OC0A)     |             |  (Output Pin OC0B)     |
+------------------------+             +------------------------+
```

![[Pasted image 20261011183918.png]]
Figure 4.5: Timer 0 block diagram. (Figure used with permission Microchip, Inc. [www. microchip.com].)
### Counter Comparison and Waveform Generation

Timer 0 includes two independent $8\text{-bit}$ comparators that continuously match the value of `TCNT0` against two compare registers:
- **Output Compare Register A (`OCR0A`)**
- **Output Compare Register B (`OCR0B`)**

The compare signals feed into waveform generators to drive state changes on external output pins (`OC0A` and `OC0B`). The internal control logic responds to three key boundary signals:
- **`BOTTOM`:** Asserted when the counter register `TCNT0` reaches `0x00`.
- **`MAX`:** Asserted when the counter register `TCNT0` reaches `0xFF` (all bits set to $1$).
- **`TOP`:** The upper limit of the counter cycle. Depending on the configured mode of operation, `TOP` is defined as either the fixed value `0xFF` (`MAX`) or the dynamically assigned threshold stored in `OCR0A` or `OCR0B`.

---

### 4.6.1 MODES OF OPERATION

Timer 0 can operate in four distinct modes, configured via the Waveform Generation Mode bits (`WGM0[2:0]`) split across `TCCR0A` and `TCCR0B`.

![[Pasted image 20261011184104.png]]
Figure 4.6: Timer 0 modes of operation [www.microchip.com]
#### 4.6.1.1 Normal Mode
In Normal Mode, the timer counts continuously upward from `0x00` (`BOTTOM`) to `0xFF` (`TOP` / `MAX`):
- Upon rolling over from `0xFF` back to `0x00`, the hardware sets the Timer/Counter Overflow Flag (`TOV0`).
- The counter repeats this sequence indefinitely.
- **Primary Use:** Generating periodic system ticks, measuring elapsed real time, and constructing software delay loops.

#### 4.6.1.2 Clear Timer on Compare Match (CTC)
In CTC Mode, the counter register `TCNT0` resets to `0x00` automatically as soon as it matches the value stored in `OCR0A` (or `OCR0B`):
- A match sets the Output Compare Flag (`OCF0A` or `OCF0B`).
- If the corresponding Output Compare Match Interrupt Enable bit (`OCIE0A` / `OCIE0B`) is enabled in `TIMSK0` and the global interrupt flag ($I\text{-bit}$ in `SREG`) is set, an interrupt is triggered.
- **Primary Use:** Generating precision digital waveforms, custom-frequency square waves, or single pulses without requiring software to manually reset the counter.

#### 4.6.1.3 Phase Correct PWM Mode
In Phase Correct PWM Mode, the counter uses dual-slope operation by counting continuously up from `0x00` to `0xFF`, and then counting back down from `0xFF` to `0x00`:
- When `TCNT0` matches `OCR0A` or `OCR0B` during either the up-counting or down-counting phase, the corresponding flag (`OCF0A` / `OCF0B`) is set, triggering an output state change on the compare pin.
- **Primary Use:** Motor control and power switching requiring symmetric, low-noise waveforms.

#### 4.6.1.4 Fast PWM
In Fast PWM Mode, the counter operates using single-slope counting, incrementing from `0x00` up to `TOP` (`0xFF` or `OCR0A`):
- When `TCNT0` matches the compare register, the output pin changes state according to the programmed compare output mode.
- When `TCNT0` reaches `TOP`, it resets to `0x00` and sets the `TOV0` flag.
- **Comparison to Phase Correct PWM:** Because it counts in a single direction before resetting, Fast PWM operates at twice the maximum frequency of Phase Correct PWM.

---

### 4.6.2 TIMER 0 REGISTERS
![[Pasted image 20261011184247.png]]
Figure 4.7: Timer 0 registers [www.microchip.com].

#### 4.6.2.1 Timer/Counter Control Registers A and B (TCCR0A and TCCR0B)
These control registers configure the core operational parameters of Timer 0:
- **`WGM0[2:0]` (Waveform Generation Mode):** Bits `WGM0[1:0]` in `TCCR0A` and `WGM0[2]` in `TCCR0B` determine the operating mode (Normal, CTC, Fast PWM, or Phase Correct PWM).
- **`COM0A[1:0]` and `COM0B[1:0]` (Compare Match Output Mode):** Located in `TCCR0A`, these bits determine whether the output compare pins (`OC0A` / `OC0B`) clear, set, or toggle when a compare match occurs.
- **`CS0[2:0]` (Clock Select):** Located in `TCCR0B`, these three bits select the clock source (internal prescaler factor or external clocking via pin `T0`).

#### 4.6.2.2 Timer/Counter Register (TCNT0)
The $8\text{-bit}$ read/write register storing the current value of the Timer 0 counter.

#### 4.6.2.3 Output Compare Registers A and B (OCR0A and OCR0B)
Two independent $8\text{-bit}$ read/write registers that store target threshold values. Their contents are continuously compared against `TCNT0` by the hardware comparators.

#### 4.6.2.4 Timer/Counter Interrupt Mask Register (TIMSK0)
Controls the local interrupt enable settings for Timer 0:
- **`OCIE0A` / `OCIE0B`:** Timer/Counter 0 Output Compare Match Interrupt Enable for channels A and B. When set to $1$ alongside the global interrupt flag ($I\text{-bit}$), compare match interrupts are enabled.
- **`TOIE0`:** Timer/Counter 0 Overflow Interrupt Enable. When set to $1$ alongside the $I\text{-bit}$, counter overflow interrupts are enabled.

#### 4.6.2.5 Timer/Counter Interrupt Flag Register 0 (TIFR0)
Contains status flags that are set by hardware when specific timer events occur:
- **`OCF0A` / `OCF0B`:** Output Compare Flags set when `TCNT0` matches `OCR0A` or `OCR0B`.
- **`TOV0`:** Timer/Counter 0 Overflow Flag set when `TCNT0` overflows from its `TOP` value.

## 4.9 PROGRAMMING THE ARDUINO UNO R3 USING THE BUILT-IN ARDUINO DEVELOPMENT ENVIRONMENT TIMING FEATURES

The Arduino Development Environment (ADE) provides high-level built-in software functions to manage timing operations, pulse measurement, and waveform generation without requiring direct register configuration:

### Built-In Timing Functions

- **`delay(unsigned long)`**
  Pauses program execution for a specified duration in _milliseconds_.
  
- **`delayMicroseconds(unsigned int)`**
  Pauses program execution for a specified duration in _microseconds_.

- **`pulseIn(pin, value)`**
  Measures the duration of an incoming digital pulse on a specified input pin.
  - **Operation:** When `value` is set to `HIGH`, the function waits until the specified `pin` transitions to logic high, begins timing, and stops timing once the pin transitions back to logic low.
  - **Return Value:** Returns the total elapsed pulse duration in _microseconds_ as an `unsigned long`.

- **`analogWrite(pin, value)`**
  Outputs a hardware _Pulse Width Modulated (PWM)_ signal on the specified pin.
  - **PWM Frequency:** Approximately $490\text{ Hz}$.
  - **Duty Cycle Range:** Accepts integer values from $0$ to $255$, where $0$ corresponds to a $0\%$ duty cycle (fully off) and $255$ corresponds to a $100\%$ duty cycle (fully on).

---

> [!example] PWM LED Brightness Control
> The `analogWrite(pin, value)` function can be used to control the perceived brightness of an LED connected to a PWM pin. By incrementally adjusting the duty cycle value between $0$ and $255$ with short delays between updates, the microcontroller smoothly ramps the LED intensity up and down to create a fading effect.

## Arduino Timers

Timer modules provide precise hardware-level timing capabilities. They allow microcontrollers to perform time-critical operations independently of CPU software execution, including:

- Generating accurate delays
- Triggering periodic events and interrupts
- Measuring external time intervals and pulse widths
- Satisfying real-time application constraints

Each microcontroller architecture contains a distinct set of dedicated hardware timers with specific register configurations and bit resolutions.

---

### 1. Arduino Hardware Timers

The Arduino UNO (powered by the ***ATmega328P*** microcontroller) contains three hardware timers:

- **Timer 0:** $8\text{-bit}$ timer/counter (used internally by the core for timing functions such as `delay()`, `millis()`, and `micros()`, as well as PWM generation).
- **Timer 1:** $16\text{-bit}$ timer/counter (supports high-resolution timing, PWM, and dedicated input capture).
- **Timer 2:** $8\text{-bit}$ timer/counter (supports PWM and asynchronous operation).

At the core of each timer module is a digital counter register that increments sequentially with each incoming clock pulse:

> [!info] Operational Distinction: Timer vs. Counter
> - **Timer Mode:** The clock input is sourced from a stable, fixed-frequency internal oscillator ($f_{\text{clk\_I/O}}$). The counter increments at a predictable rate to measure elapsed time.
> - **Counter Mode:** The clock input is driven by an external pin or asynchronous signal source. The counter tracks the number of external pulses or transitions.

---

### 2. Arduino Timer Prescaler

A ***prescaler*** is an internal digital clock-divider circuit placed between the primary microcontroller clock source and the timer counter. It divides the system clock frequency by a fixed integer factor ($N$), producing a slower timer clock rate ($\text{clk}_T$):

$$\text{clk}_T = \frac{f_{\text{clk\_I/O}}}{N}$$

#### Functional Purpose of the Prescaler
- **Extends Timing Range:** By slowing the rate at which the counter increments, the timer takes longer to reach its maximum count limit before overflowing.
- **Controls PWM Frequency:** Changing the clock division ratio directly scales the base frequency of generated PWM signals.
- **Reduces CPU Overhead:** Operating a timer at full system clock frequency maximizes measurement resolution, but causes rapid counter overflows that generate frequent interrupts. Prescaling avoids unnecessary interrupt handling overhead when high resolution is not required.
![[Pasted image 20261011184607.png]]

Timer prescaler divider ratios vary across the different timer modules (`Timer0`, `Timer1`, and `Timer2`) and are configured via their respective control registers.

### 3. Arduino Timer Interrupts

Arduino hardware timers generate dedicated interrupt signals in response to specific hardware conditions. Each timer channel supports multiple interrupt sources that can be enabled or disabled independently:

- **Timer Overflow Interrupt:** 
  Triggered when the timer counter register reaches its maximum capacity ($255$ for $8\text{-bit}$ timers, $65,535$ for $16\text{-bit}$ timers), rolls over to `0`, and resumes counting up.
  
- **Output Compare Match Interrupts (`COMPA` and `COMPB`):** 
  Each timer contains two independent compare registers. When the current counter value matches the value stored in the compare register:
  - The hardware can automatically change the logic level of the corresponding output pin (`OCnA` or `OCnB`) to `HIGH`, `LOW`, or toggle its state.
  - A dedicated compare match interrupt flag is set, firing an interrupt if enabled.

![[Pasted image 20261011185457.png]]

> [!info] Interrupt Vectors and Masking
> Each timer interrupt source (Overflow, Compare Match A, and Compare Match B) possesses its own unique interrupt vector address in memory and can be enabled or masked individually through timer interrupt mask registers.



### 4. Arduino Timers Comparison

The ATmega328P microcontroller on the Arduino UNO features three hardware timers with distinct resolutions, supported pins, and internal responsibilities.

| Feature | Timer 0 | Timer 1 | Timer 2 |
| :--- | :--- | :--- | :--- |
| **Resolution** | $8\text{-bit}$ ($0\text{--}255$) | $16\text{-bit}$ ($0\text{--}65,535$) | $8\text{-bit}$ ($0\text{--}255$) |
| **PWM Output Pins** | Pins `5`, `6` | Pins `9`, `10` | Pins `11`, `3` |
| **Core Functions** | `delay()`, `millis()`, `micros()` | Servo operations | `tone()` |
| **Timer Mode** | Supported | Supported | Supported |
| **Counter Mode** | Supported | Supported | Supported |
| **Output Compare (PWM)**| Supported | Supported | Supported |
| **Input Capture Unit** | Not Available | Supported | Not Available |
| **Interrupt Vectors** | `TIMER0_OVF_vect`<br>`TIMER0_COMPA_vect`<br>`TIMER0_COMPB_vect` | `TIMER1_OVF_vect`<br>`TIMER1_COMPA_vect`<br>`TIMER1_COMPB_vect`<br>`TIMER1_CAPT_vect` | `TIMER2_OVF_vect`<br>`TIMER2_COMPA_vect`<br>`TIMER2_COMPB_vect` |
| **Prescaler Factors** | $1, 8, 64, 256, 1024$ | $1, 8, 64, 256, 1024$ | $1, 8, 32, 64, 128, 256, 1024$ |

> [!warning] Hardware Timer Side Effects
> Altering the register configurations of any timer disrupts its associated PWM output channels. Crucially, modifying ***Timer 0*** corrupts Arduino's built-in timekeeping functions (`delay()`, `millis()`, and `micros()`). For general-purpose custom timing applications, ***Timer 1*** is usually the safest and most flexible candidate.

---

### 5. Arduino Timers Control Registers

Timer modules and their associated interrupts are initialized and managed through direct access to configuration registers:

- **`TCCRxA` (Timer/Counter Control Register A):** Configures waveform generation modes (`WGM`) and compare output modes (`COM`).
- **`TCCRxB` (Timer/Counter Control Register B):** Configures additional mode bits and sets the clock prescaler selection (`CS`).
- **`TCNTx` (Timer/Counter Register):** Direct read/write register storing the instantaneous count value.
- **`OCRxA` / `OCRxB` (Output Compare Registers A & B):** Stores the target threshold values continuously compared against `TCNTx`.
- **`TIMSKx` (Timer Interrupt Mask Register):** Local interrupt enable/disable register for overflow and compare match events.
- **`TIFRx` (Timer Interrupt Flag Register):** Contains hardware interrupt status flags that indicate pending events.

*(where `x` represents timer index `0`, `1`, or `2`)*

---

## Arduino Timer Interrupts

In timer mode, a timer module uses the internal system clock combined with a selected prescaler to trigger time-dependent interrupts at precise intervals.

```
                      f_clk (16 MHz)
                            │
                            ▼
                  ┌───────────────────┐
                  │ Prescaler (1 / N) │
                  └─────────┬─────────┘
                            │ clk_T
                            ▼
                  ┌───────────────────┐
                  │   Counter TCNTx   │
                  └─────────┬─────────┘
                            │
             ┌──────────────┴──────────────┐
             │                             │
             ▼ (TCNTx == TOP)              ▼ (TCNTx == OCRxA/B)
    ┌─────────────────┐           ┌──────────────────┐
    │  Overflow (OVF) │           │  Compare Match   │
    │    Interrupt    │           │ (COMPA / COMPB)  │
    └─────────────────┘           └──────────────────┘
```

---

### Arduino Timer Equations

The time duration between timer events ($T_{\text{OUT}}$) is a function of the total count ticks, the clock frequency, and the prescaler division ratio.

> [!summary] Formula: Timer Output Period & Tick Calculation
> $$T_{\text{OUT}} = \frac{\text{TicksCount} \times N}{f_{\text{clk}}}$$
> $$\text{TicksCount} = \frac{T_{\text{OUT}} \times f_{\text{clk}}}{N}$$
> 
> **breakdown**:
> - $T_{\text{OUT}}$ : The desired output time interval or interrupt period (in seconds).
> - $\text{TicksCount}$ : The number of clock cycles/counts required to elapse before the interrupt occurs.
> - $N$ : The clock prescaler division factor ($1, 8, 32, 64, 128, 256,$ or $1024$).
> - $f_{\text{clk}}$ : The main system oscillator frequency ($16\text{ MHz} = 16 \times 10^6\text{ Hz}$ on standard Arduino boards).
![[Pasted image 20261011185538.png]]
---

### Arduino Timer Calculations

To configure a periodic interrupt, follow a structured three-step design process:

> [!example] Step-by-Step Calculation for a 100 ms Interval on Timer 1
> **Target Requirement:** Generate a periodic interrupt every $T_{\text{OUT}} = 100\text{ ms} = 0.1\text{ s}$ using Timer 1 ($16\text{-bit}$, $f_{\text{clk}} = 16\text{ MHz}$).
> 
> 1. **Select a Suitable Prescaler ($N$):**
>    The maximum achievable period before counter overflow must exceed $100\text{ ms}$:
>    $$T_{\text{OUT(MAX)}} = \frac{65,536 \times N}{16\times 10^6}$$
>    - For $N = 64$:
>      $$T_{\text{OUT(MAX)}} = \frac{65,536 \times 64}{16 \times 10^6} \approx 0.262\text{ s} = 262\text{ ms}$$
>    - Since $262\text{ ms} > 100\text{ ms}$, the $1:64$ prescaler is suitable.
> 
> 2. **Calculate the Required Tick Count:**
>    $$\text{TicksCount} = \frac{0.1\text{ s} \times 16 \times 10^6\text{ Hz}}{64} = 25,000\text{ ticks}$$
> 
> 3. **Implement in Configuration:**
>    Use this value to configure either timer preloading or output compare registers.
![[Pasted image 20261011185552.png]]
---

### Arduino Timer Interrupt Code Methods

Achieving a specific interrupt period can be implemented using two software patterns:

#### 1. Timer Preloading (Overflow Method)
The counter register (`TCNTx`) is pre-loaded with an offset value so that it overflows precisely after $\text{TicksCount}$ cycles.

$$\text{Preload Value} = \text{Counter Max} - \text{TicksCount} = 65,535 - 25,000 = 40,535$$

- The preload register must be re-initialized at the very beginning of the overflow Interrupt Service Routine (`ISR`).

#### 2. Timer Compare Match (Preferred Method)
The counter register runs freely, and an interrupt is triggered whenever `TCNT1` matches the value loaded into `OCR1A`.

- Inside the ISR, the compare register is advanced by adding the target count interval:
  $$\text{OCR1A} \leftarrow \text{OCR1A} + 25,000$$
- This method supports multiple independent interrupt periods (using channels `COMPA` and `COMPB`) from a single hardware timer without disrupting continuous counting.

---

### Timer Prescaler & $T_{\text{OUT}}$ Relationship

The selectable prescaler determines the minimum resolution (single tick) and maximum overflow period ($T_{\text{OUT(MAX)}}$) for a $16\text{ MHz}$ system clock:

| Prescaler ($N$) | Timer 0 & 2 Min $T_{\text{OUT}}$ | Timer 0 & 2 Max $T_{\text{OUT}}$ | Timer 1 Min $T_{\text{OUT}}$ | Timer 1 Max $T_{\text{OUT}}$ |
| :--- | :--- | :--- | :--- | :--- |
| **1** | $62.5\text{ ns}$ | $16\text{ }\mu\text{s}$ | $62.5\text{ ns}$ | $4.1\text{ ms}$ |
| **8** | $0.5\text{ }\mu\text{s}$ | $128\text{ }\mu\text{s}$ | $0.5\text{ }\mu\text{s}$ | $32.8\text{ ms}$ |
| **32** *(Timer 2 only)* | $2\text{ }\mu\text{s}$ | $512\text{ }\mu\text{s}$ | — | — |
| **64** | $4\text{ }\mu\text{s}$ | $1.024\text{ ms}$ | $4\text{ }\mu\text{s}$ | $262\text{ ms}$ |
| **128** *(Timer 2 only)* | $8\text{ }\mu\text{s}$ | $2.05\text{ ms}$ | — | — |
| **256** | $16\text{ }\mu\text{s}$ | $4.1\text{ ms}$ | $16\text{ }\mu\text{s}$ | $1.05\text{ s}$ |
| **1024** | $64\text{ }\mu\text{s}$ | $16.4\text{ ms}$ | $64\text{ }\mu\text{s}$ | $4.2\text{ s}$ |

---

### Code Implementations

#### Overflow Interrupt with Timer Preloading

```cpp
// 100 ms Periodic Interrupt using Timer 1 Overflow
ISR(TIMER1_OVF_vect)
{
  TCNT1 = 40535; // Reload precalculated value to maintain timing interval
  digitalWrite(LED_BUILTIN, !digitalRead(LED_BUILTIN));
}

void setup()
{
  TCCR1A = 0;           // Set normal mode
  TCCR1B = 0;           // Clear control bits
  TCCR1B |= B00000011;  // Set CS11:CS10 for 1:64 prescaler
  TCNT1 = 40535;        // Preload initial count
  TIMSK1 |= B00000001;  // Enable Timer 1 Overflow Interrupt (TOIE1)
  pinMode(LED_BUILTIN, OUTPUT);
}

void loop()
{
  // Primary application loop runs uninterrupted
}
```

---

#### Compare Match Interrupt (Single Channel: COMPA)

```cpp
// 100 ms Periodic Interrupt using Timer 1 Compare Match A
ISR(TIMER1_COMPA_vect)
{
  OCR1A += 25000; // Advance compare register by interval count
  digitalWrite(LED_BUILTIN, !digitalRead(LED_BUILTIN));
}

void setup()
{
  TCCR1A = 0;           // Set normal mode
  TCCR1B = 0;           // Clear control bits
  TCCR1B |= B00000011;  // Set CS11:CS10 for 1:64 prescaler
  OCR1A = 25000;        // Set initial compare match threshold
  TIMSK1 |= B00000010;  // Enable Output Compare A Match Interrupt (OCIE1A)
  pinMode(LED_BUILTIN, OUTPUT);
}

void loop()
{
  // Primary application loop runs uninterrupted
}
```

---

#### Dual Compare Match Interrupt (Independent Channels: COMPA & COMPB)

```cpp
// Dual Independent Timers: Channel A (80 ms) & Channel B (35 ms)
#define LED_A_PIN 13
#define LED_B_PIN 8

ISR(TIMER1_COMPA_vect)
{
  OCR1A += 20000; // Advance Channel A by 20,000 ticks (80 ms)
  digitalWrite(LED_A_PIN, !digitalRead(LED_A_PIN));
}

ISR(TIMER1_COMPB_vect)
{
  OCR1B += 8750;  // Advance Channel B by 8,750 ticks (35 ms)
  digitalWrite(LED_B_PIN, !digitalRead(LED_B_PIN));
}

void setup()
{
  TCCR1A = 0;           // Set normal mode
  TCCR1B = 0;           // Clear control bits
  TCCR1B |= B00000011;  // Set CS11:CS10 for 1:64 prescaler
  
  OCR1A = 20000;        // Initial compare threshold for 80 ms
  OCR1B = 8750;         // Initial compare threshold for 35 ms
  
  TIMSK1 |= B00000110;  // Enable COMPA (bit 1) and COMPB (bit 2) interrupts
  
  pinMode(LED_A_PIN, OUTPUT);
  pinMode(LED_B_PIN, OUTPUT);
}

void loop()
{
  // Primary application loop runs uninterrupted
}
```

## Pulse Width Modulation

***Pulse Width Modulation (PWM)*** is a technique used to generate simulated analog output voltages using digital outputs. By rapidly switching a digital pin between `HIGH` ($V_{CC}$, typically $5\text{ V}$ or $3.3\text{ V}$) and `LOW` ($0\text{ V}$), the average voltage delivered to a load can be continuously controlled.

- **Pulse Width:** The duration of time the digital signal remains in an *on* (`HIGH`) state during a single cycle.
- **Modulation:** Varying the on-time relative to the total period changes the effective average voltage:
  $$V_{\text{avg}} = V_{CC} \times \text{Duty Cycle}$$
![[Pasted image 20261011185733.png]]
### PWM Examples
- **LED Dimming:** Rapid switching controls perceived brightness without changing the LED's forward voltage.
- **Analog Voltage Generation:** Filtering the digital square wave through a low-pass RC filter produces a smooth analog voltage between $0\text{ V}$ and $V_{CC}$.
- **Audio Signal Generation:** Driving speakers with modulated frequencies and pulse widths to produce sound tones.
- **Motor Speed Control:** Modulating the average voltage delivered to DC motors to control rotational speed efficiently without excessive power dissipation.
- **Communication Signals:** Modulating high-frequency carrier pulses (e.g., $38\text{ kHz}$) to drive infrared LEDs for remote controls.

---

## Simple Pulse Width Modulation with analogWrite

The built-in Arduino function `analogWrite(pin, dutyCycle)` provides a high-level software interface for generating hardware PWM:

- **`pin`:** Must be a hardware-capable PWM pin (Pins `3`, `5`, `6`, `9`, `10`, or `11` on the ATmega328P).
- **`dutyCycle`:** An integer from `0` ($0\%$ duty cycle, permanently off) to `255` ($100\%$ duty cycle, permanently on).

> [!info] Limitations of `analogWrite()`
> While `analogWrite()` is simple to implement, it provides no built-in mechanism to modify the base switching frequency of the PWM output. Direct manipulation of hardware registers is required for frequency customization.

---

## Bit-Banging Pulse Width Modulation

PWM can be manually generated on any standard general-purpose I/O (GPIO) pin using software timing loops:

```cpp
void setup()
{
  pinMode(13, OUTPUT);
}

void loop()
{
  // Generate ~10% duty cycle at approximately 1 kHz (Period = 1000 µs)
  digitalWrite(13, HIGH);
  delayMicroseconds(100);       // On-time = 100 µs
  
  digitalWrite(13, LOW);
  delayMicroseconds(1000 - 100); // Off-time = 900 µs
}
```

> [!warning] Trade-offs of Bit-Banging PWM
> - **Advantages:** Operates on any digital pin; allows direct software specification of period and duty cycle.
> - **Disadvantages:**
>   - **Interrupt Jitter:** Any CPU interrupt temporarily pauses the delay loop, introducing substantial timing jitter.
>   - **CPU Blocking:** The CPU cannot execute other background tasks while managing delay loops.
>   - **Calibration Difficulty:** Exact timing requires cycle counting with an oscilloscope to compensate for function call overhead.

---

## Using the ATmega PWM Registers Directly

Direct manipulation of the ATmega328P internal timer registers provides full control over PWM operating modes, prescaler clock dividers, output polarities, and switching frequencies.

### The ATmega 168/328 Timers

The ATmega328P includes three hardware timers driving six PWM output channels:
- **Timer 0 ($8\text{-bit}$):** Controls outputs `OC0A` and `OC0B`.
- **Timer 1 ($16\text{-bit}$):** Controls outputs `OC1A` and `OC1B`.
- **Timer 2 ($8\text{-bit}$):** Controls outputs `OC2A` and `OC2B`.

Each timer includes two independent Output Compare Registers (`OCRnA` and `OCRnB`). While both outputs share the same base timer frequency, each output can be configured with an independent duty cycle.

---

### Timer Registers

Each timer is governed by a dedicated set of hardware registers:
- **`TCCRnA` & `TCCRnB` (Timer/Counter Control Registers A & B):**
  - `WGM` (Waveform Generation Mode): Configures timer counting mode (Normal, CTC, Fast PWM, Phase-Correct PWM).
  - `CS` (Clock Select): Configures the input clock prescaler ($N = 1, 8, 32, 64, 128, 256, 1024$).
  - `COMnA` / `COMnB` (Compare Match Output Mode): Configures pin behavior upon compare match (non-inverting, inverting, or toggling).
- **`OCRnA` & `OCRnB` (Output Compare Registers):** Define the threshold values compared against the timer count register.

---

### Fast PWM

In standard **Fast PWM Mode**, the timer operates in a single-slope manner, counting continuously from `0` up to a fixed maximum of `255` (`0xFF`), then resetting to `0`.

- **Non-Inverting Mode (`COMnx = 2`):** The output pin is driven `HIGH` when the timer resets to `0`, and driven `LOW` when the timer matches the value in `OCRnx`.

```
Timer Count
  255 ┌               /|              /|
      │              / |             / |
OCRnx ├ - - - - - - / -|- - - - - - / -|- - - - -
      │            /   |           /   |
    0 └───────────/────┴──────────/────┴─────────> Time
Pin   ┌───────────┐    ┌──────────┐
Output│           │    │          │
      └───────────┴────┴──────────┴──────────────>
      |<-- Ton -->|
      |<------- T_period ------->|
```
![[Pasted image 20261011185759.png]]
> [!summary] Formula: Fast PWM (Fixed TOP = 255)
> $$f_{\text{PWM}} = \frac{f_{\text{clk}}}{N \times 256}$$
> $$\text{Duty Cycle} = \frac{\text{OCRnx} + 1}{256} \times 100\%$$
> 
> **breakdown**:
> - $f_{\text{PWM}}$ : Resulting output PWM frequency in Hertz ($\text{Hz}$).
> - $f_{\text{clk}}$ : Base microcontroller oscillator frequency ($16\text{ MHz}$).
> - $N$ : Clock prescaler division factor.
> - $\text{OCRnx}$ : Value loaded into Output Compare Register ($0\text{--}255$).

```cpp
// Fast PWM on Pins 3 (OC2B) and 11 (OC2A) using Timer 2
pinMode(3, OUTPUT);
pinMode(11, OUTPUT);

// WGM2[1:0] = 11 (Fast PWM), COM2A[1:0] = 10, COM2B[1:0] = 10 (Non-inverting)
TCCR2A = _BV(COM2A1) | _BV(COM2B1) | _BV(WGM21) | _BV(WGM20);

// CS2[2:0] = 100 (Prescaler = 64)
TCCR2B = _BV(CS22);

OCR2A = 180; // Output A duty cycle
OCR2B = 50;  // Output B duty cycle
```

> [!example] Fast PWM Calculations (Prescaler = 64)
> - **Frequency (Outputs A & B):**
>   $$f = \frac{16\text{ MHz}}{64 \times 256} = 976.5625\text{ Hz}$$
> - **Output A Duty Cycle (`OCR2A = 180`):**
>   $$\text{Duty Cycle}_A = \frac{180 + 1}{256} = \frac{181}{256} \approx 70.7\%$$
> - **Output B Duty Cycle (`OCR2B = 50`):**
>   $$\text{Duty Cycle}_B = \frac{50 + 1}{256} = \frac{51}{256} \approx 19.9\%$$

---

### Phase-Correct PWM

In **Phase-Correct PWM Mode**, the counter operates with dual-slope counting: it increments from `0` to `255`, and then decrements back down to `0`.

- **Non-Inverting Mode:** Output turns `LOW` when matching `OCRnx` while counting up, and turns `HIGH` when matching `OCRnx` while counting down.
- **Symmetry:** Waveforms remain centered relative to the period, reducing mechanical vibration and harmonic noise in motor control systems.

> [!summary] Formula: Phase-Correct PWM (Fixed TOP = 255)
> $$f_{\text{PWM}} = \frac{f_{\text{clk}}}{N \times 255 \times 2} = \frac{f_{\text{clk}}}{N \times 510}$$
> $$\text{Duty Cycle} = \frac{\text{OCRnx}}{255} \times 100\%$$
> 
> **breakdown**:
> - $f_{\text{PWM}}$ : Resulting output PWM frequency in Hertz ($\text{Hz}$).
> - $f_{\text{clk}}$ : Base microcontroller oscillator frequency ($16\text{ MHz}$).
> - $N$ : Clock prescaler division factor.
> - $\text{OCRnx}$ : Value loaded into Output Compare Register ($0\text{--}255$).

![[Pasted image 20261011185813.png]]
```cpp
// Phase-Correct PWM on Pins 3 (OC2B) and 11 (OC2A) using Timer 2
pinMode(3, OUTPUT);
pinMode(11, OUTPUT);

// WGM2[2:0] = 001 (Phase-Correct PWM 8-bit), COM2A[1:0] = 10, COM2B[1:0] = 10
TCCR2A = _BV(COM2A1) | _BV(COM2B1) | _BV(WGM20);
TCCR2B = _BV(CS22); // Prescaler = 64

OCR2A = 180;
OCR2B = 50;
```

> [!example] Phase-Correct PWM Calculations (Prescaler = 64)
> - **Frequency (Outputs A & B):**
>   $$f = \frac{16\text{ MHz}}{64 \times 255 \times 2} = \frac{16\text{ MHz}}{32,640} \approx 490.196\text{ Hz}$$
> - **Output A Duty Cycle (`OCR2A = 180`):**
>   $$\text{Duty Cycle}_A = \frac{180}{255} \approx 70.6\%$$
> - **Output B Duty Cycle (`OCR2B = 50`):**
>   $$\text{Duty Cycle}_B = \frac{50}{255} \approx 19.6\%$$

---

### Varying the timer top limit: fast PWM

To achieve precise output frequencies, the upper limit (`TOP`) of the counter can be defined by the register `OCRnA` rather than the fixed maximum value `255`.

> [!important] Channel Allocation with `OCRnA` as `TOP`
> When `OCRnA` defines the timer's `TOP` limit:
> - **Output B (`OCnB`):** Generates variable duty cycle PWM bounded by `OCRnB`.
> - **Output A (`OCnA`):** Cannot modulate duty cycle independently; it is typically configured to toggle state on every compare match (`COMnA = 01`), generating a fixed $50\%$ duty cycle square wave at half the frequency of Output B.

> [!summary] Formula: Fast PWM with Variable `TOP` (`OCRnA`)
> $$f_{\text{Output B}} = \frac{f_{\text{clk}}}{N \times (\text{OCRnA} + 1)}$$
> $$f_{\text{Output A}} = \frac{f_{\text{Output B}}}{2} = \frac{f_{\text{clk}}}{2 \times N \times (\text{OCRnA} + 1)}$$
> $$\text{Duty Cycle}_B = \frac{\text{OCRnB} + 1}{\text{OCRnA} + 1} \times 100\%$$
> 
> **breakdown**:
> - $\text{OCRnA}$ : Defines the custom `TOP` counter limit ($0\text{--}255$).
> - $\text{OCRnB}$ : Output compare threshold for channel B ($0 \le \text{OCRnB} \le \text{OCRnA}$).
> - $N$ : Prescaler division factor.

![[Pasted image 20261011185837.png]]

```cpp
// Fast PWM with OCR2A as TOP on Pins 3 and 11
pinMode(3, OUTPUT);
pinMode(11, OUTPUT);

// WGM2[2:0] = 111 (Fast PWM with TOP = OCR2A)
// COM2A[1:0] = 01 (Toggle OC2A on Match), COM2B[1:0] = 10 (Non-inverting OC2B)
TCCR2A = _BV(COM2A0) | _BV(COM2B1) | _BV(WGM21) | _BV(WGM20);
TCCR2B = _BV(WGM22) | _BV(CS22); // Prescaler = 64

OCR2A = 180; // Sets TOP limit (Period = 181 counts)
OCR2B = 50;  // Sets Output B threshold
```

> [!example] Calculated Parameters for Fast PWM with `OCR2A = 180`
> - **Output B Frequency:**
>   $$f_B = \frac{16\text{ MHz}}{64 \times (180 + 1)} = \frac{16\text{ MHz}}{11,584} \approx 1381.2\text{ Hz}$$
> - **Output B Duty Cycle:**
>   $$\text{Duty Cycle}_B = \frac{50 + 1}{180 + 1} = \frac{51}{181} \approx 28.2\%$$
> - **Output A Frequency:**
>   $$f_A = \frac{1381.2\text{ Hz}}{2} \approx 690.6\text{ Hz} \quad (\text{Duty Cycle} = 50\%)$$

---

### Varying the timer top limit: phase-correct PWM

Similarly, Phase-Correct PWM can use `OCRnA` as its `TOP` boundary, counting up from `0` to `OCRnA` and back down to `0`.

> [!summary] Formula: Phase-Correct PWM with Variable `TOP` (`OCRnA`)
> $$f_{\text{Output B}} = \frac{f_{\text{clk}}}{2 \times N \times \text{OCRnA}}$$
> $$f_{\text{Output A}} = \frac{f_{\text{Output B}}}{2} = \frac{f_{\text{clk}}}{4 \times N \times \text{OCRnA}}$$
> $$\text{Duty Cycle}_B = \frac{\text{OCRnB}}{\text{OCRnA}} \times 100\%$$
> 
> **breakdown**:
> - $\text{OCRnA}$ : Defines the custom peak counter limit ($0\text{--}255$).
> - $\text{OCRnB}$ : Output compare match threshold for channel B ($0 \le \text{OCRnB} \le \text{OCRnA}$).
> - $N$ : Prescaler division factor.

![[Pasted image 20261011185846.png]]

```cpp
// Phase-Correct PWM with OCR2A as TOP on Pins 3 and 11
pinMode(3, OUTPUT);
pinMode(11, OUTPUT);

// WGM2[2:0] = 101 (Phase-Correct PWM with TOP = OCR2A)
// COM2A[1:0] = 01 (Toggle OC2A), COM2B[1:0] = 10 (Non-inverting OC2B)
TCCR2A = _BV(COM2A0) | _BV(COM2B1) | _BV(WGM20);
TCCR2B = _BV(WGM22) | _BV(CS22); // Prescaler = 64

OCR2A = 180; // Sets TOP limit (Total cycle = 360 counts)
OCR2B = 50;
```

> [!example] Calculated Parameters for Phase-Correct PWM with `OCR2A = 180`
> - **Output B Frequency:**
>   $$f_B = \frac{16\text{ MHz}}{2 \times 64 \times 180} = \frac{16\text{ MHz}}{23,040} \approx 694.4\text{ Hz}$$
> - **Output B Duty Cycle:**
>   $$\text{Duty Cycle}_B = \frac{50}{180} \approx 27.8\%$$
> - **Output A Frequency:**
>   $$f_A = \frac{694.4\text{ Hz}}{2} \approx 347.2\text{ Hz} \quad (\text{Duty Cycle} = 50\%)$$

---

### Off-by-one

The mathematical differences between Fast PWM and Phase-Correct PWM stem from how each counter completes a cycle:

#### Cycle Divisors
- **Fast PWM:** Counts through $0, 1, 2, \dots, \text{TOP}, 0$. For a $\text{TOP}$ value of $N$, the cycle encompasses $N + 1$ discrete clock ticks. When counting to $255$, there are $256$ states, dividing frequency by $256$.
- **Phase-Correct PWM:** Counts up and down through $0, 1, \dots, N, \dots, 1, 0$. A full cycle spans $2N$ clock ticks. For $N = 255$, the cycle takes $510$ ticks, dividing frequency by $2 \times 255$.

#### Minimum and Maximum Duty Cycle Behavior
- **Fast PWM:** The output stays high for $\text{OCRnx} + 1$ cycles. An `OCRnx` value of $255$ produces a $100\%$ duty cycle ($256/256$), whereas an `OCRnx` value of $0$ produces a duty cycle of $1/256$ ($0.39\%$), never reaching true $0\%$ off.
- **Phase-Correct PWM:** An `OCRnx` value of $255$ results in $100\%$ duty cycle ($255/255$), while an `OCRnx` value of $0$ results in a true $0\%$ duty cycle ($0/255$).

---

### Timers and the Arduino

#### Pin and Port Mapping

| Timer Output | Arduino Pin | Microcontroller Pin | Port / Bit Name |
| :--- | :--- | :--- | :--- |
| **`OC0A`** | `6` | Pin 12 | `PD6` |
| **`OC0B`** | `5` | Pin 11 | `PD5` |
| **`OC1A`** | `9` | Pin 15 | `PB1` |
| **`OC1B`** | `10` | Pin 16 | `PB2` |
| **`OC2A`** | `11` | Pin 17 | `PB3` |
| **`OC2B`** | `3` | Pin 5 | `PD3` |

#### Default Core Configurations
During standard boot initialization:
- All three timer prescalers are configured to divide the clock by $64$.
- **Timer 0** is configured in **Fast PWM Mode** (used for `millis()`, `micros()`, and `delay()`).
- **Timer 1** and **Timer 2** are configured in **Phase-Correct PWM Mode**.

> [!note] How `analogWrite(5, 0)` Achieves 0% Duty Cycle
> Because Fast PWM on Timer 0 cannot natively produce a true $0\%$ duty cycle (minimum hardware output is $1/256$), the underlying `analogWrite()` implementation includes special-case code that explicitly turns off the output pin via digital write when a duty cycle value of `0` is supplied.

#### Architecture Differences Across Boards
- **ATmega1280 / ATmega2560 (Arduino Mega):** Features four $16\text{-bit}$ timers with 3 output channels each and two $8\text{-bit}$ timers with 2 outputs each (supporting 14 library PWM pins).
- **ATmega8 (Legacy Arduino):** Features three timers with only 3 total PWM outputs (Timer 0 has no PWM, Timer 1 provides two outputs, and Timer 2 provides one output).

---

## Troubleshoot

When configuring hardware PWM registers directly, ensure the following conditions are met:

- **Pin Direction Setup:** Both the physical pin direction must be enabled via `pinMode(pin, OUTPUT)` and the timer compare output mode (`COMnx` bits) must be explicitly enabled.
- **Bit Mapping Differences:** Control registers and prescaler configurations vary across timers; verify the specific bit assignments for the targeted timer module.
- **Reserved Bit Configurations:** Certain mode combinations are unsupported by hardware (e.g., *Toggle OCnx on Compare Match* is invalid for Fast PWM with a fixed `TOP` of $255$, and is unavailable on Output B channels).
- **Verify Bitwise Operations:** Debug register configurations by printing register values using the binary formatter: `Serial.println(TCCR2A, BIN)`.
- **Output Stability:** Place decoupling capacitors near power rails to suppress switching noise and voltage spikes.