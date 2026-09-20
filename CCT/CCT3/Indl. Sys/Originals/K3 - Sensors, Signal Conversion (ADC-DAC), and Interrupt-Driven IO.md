---
tags:
  - CCT3
  - indlejrede_systemer
Topic: analog-to-digital converter (ADC), interrupts,
Semester: CCT3
Course: Programmering af indlejrede systemer
Litterature:
  - Introduction to Computer Engineering
  - ATmega328P datasheet extracts
  - "Arduino I: Getting Started"
  - "Arduino II: Systems"
Created: 20-09-2026
---
# Table of Contents

1. [[#SENSORS|SENSORS]]
	1. [[#SENSORS#Digital Sensors|Digital Sensors]]
		1. [[#Digital Sensors#1. Absolute Encoders|1. Absolute Encoders]]
		2. [[#Digital Sensors#2. Incremental Encoders|2. Incremental Encoders]]
	2. [[#SENSORS#Analog Sensors|Analog Sensors]]
2. [[#Analog to Digital Conversion (ADC)|Analog to Digital Conversion (ADC)]]
	1. [[#SENSORS#Core Objectives|Core Objectives]]
3. [[#Analog to Digital Conversion (ADC)#OVERVIEW|OVERVIEW]]
4. [[#Analog to Digital Conversion (ADC)#SAMPLING, QUANTIZATION, AND ENCODING|SAMPLING, QUANTIZATION, AND ENCODING]]
5. [[#SAMPLING, QUANTIZATION, AND ENCODING#Sampling|Sampling]]
6. [[#SAMPLING, QUANTIZATION, AND ENCODING#Quantization|Quantization]]
7. [[#SAMPLING, QUANTIZATION, AND ENCODING#Encoding|Encoding]]
8. [[#SAMPLING, QUANTIZATION, AND ENCODING#RESOLUTION AND DATA RATE|RESOLUTION AND DATA RATE]]
9. [[#SAMPLING, QUANTIZATION, AND ENCODING#Resolution|Resolution]]
10. [[#SAMPLING, QUANTIZATION, AND ENCODING#Data Rate|Data Rate]]
11. [[#SAMPLING, QUANTIZATION, AND ENCODING#Dynamic Range|Dynamic Range]]
12. [[#Analog to Digital Conversion (ADC)#ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS|ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS]]
13. [[#ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS#Transducers|Transducers]]
14. [[#ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS#TRANSDUCER INTERFACE DESIGN (TID) CIRCUIT|TRANSDUCER INTERFACE DESIGN (TID) CIRCUIT]]
15. [[#ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS#Operating Principle: Scaling and Biasing|Operating Principle: Scaling and Biasing]]
16. [[#ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS#Mathematical Model|Mathematical Model]]
17. [[#ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS#OPERATIONAL AMPLIFIERS|OPERATIONAL AMPLIFIERS]]
	1. [[#OPERATIONAL AMPLIFIERS#The Ideal Operational Amplifier|The Ideal Operational Amplifier]]
18. [[#ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS#Open-Loop Operation and Saturation|Open-Loop Operation and Saturation]]
19. [[#ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS#Standard Op-Amp Circuit Analysis|Standard Op-Amp Circuit Analysis]]
20. [[#Analog to Digital Conversion (ADC)#ADC CONVERSION TECHNOLOGIES|ADC CONVERSION TECHNOLOGIES]]
21. [[#ADC CONVERSION TECHNOLOGIES#Successive-Approximation Architecture|Successive-Approximation Architecture]]
22. [[#ADC CONVERSION TECHNOLOGIES#Step-by-Step Conversion Process|Step-by-Step Conversion Process]]
23. [[#ADC CONVERSION TECHNOLOGIES#Architectural Trade-offs|Architectural Trade-offs]]
24. [[#Analog to Digital Conversion (ADC)#THE MICROCHIP ATMEGA328 ADC SYSTEM|THE MICROCHIP ATMEGA328 ADC SYSTEM]]
25. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#Key Hardware Features|Key Hardware Features]]
26. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#Resolution and Accuracy|Resolution and Accuracy]]
27. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#Clocking and Prescaling|Clocking and Prescaling]]
28. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#Channel Multiplexing|Channel Multiplexing]]
29. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#Data Storage and Result Justification|Data Storage and Result Justification]]
30. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#Input Voltage Limits|Input Voltage Limits]]
31. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#BLOCK DIAGRAM|BLOCK DIAGRAM]]
32. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#External Pin Interfaces|External Pin Interfaces]]
33. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#Subsystem Integration|Subsystem Integration]]
34. [[#THE MICROCHIP ATMEGA328 ADC SYSTEM#ATMEGA328 ADC REGISTERS|ATMEGA328 ADC REGISTERS]]
	1. [[#ATMEGA328 ADC REGISTERS#ATmega328 ADC Multiplexer Selection Register (ADMUX)|ATmega328 ADC Multiplexer Selection Register (ADMUX)]]
	2. [[#ATMEGA328 ADC REGISTERS#Reference Voltage Selection (`REFS[1:0]`)|Reference Voltage Selection (`REFS[1:0]`)]]
	3. [[#ATMEGA328 ADC REGISTERS#ADC Left Adjust Result (`ADLAR`)|ADC Left Adjust Result (`ADLAR`)]]
	4. [[#ATMEGA328 ADC REGISTERS#Analog Channel Selection (`MUX[3:0]`)|Analog Channel Selection (`MUX[3:0]`)]]
	5. [[#ATMEGA328 ADC REGISTERS#ATmega328 ADC Control and Status Register A (ADCSRA)|ATmega328 ADC Control and Status Register A (ADCSRA)]]
	6. [[#ATMEGA328 ADC REGISTERS#Key Control and Status Bits|Key Control and Status Bits]]
	7. [[#ATMEGA328 ADC REGISTERS#ADC Clock Prescaler (`ADPS[2:0]`)|ADC Clock Prescaler (`ADPS[2:0]`)]]
	8. [[#ATMEGA328 ADC REGISTERS#ATmega328 ADC Data Registers (ADCH, ADCL)|ATmega328 ADC Data Registers (ADCH, ADCL)]]
35. [[#Analog to Digital Conversion (ADC)#PROGRAMMING THE ADC USING THE ARDUINO DEVELOPMENT ENVIRONMENT|PROGRAMMING THE ADC USING THE ARDUINO DEVELOPMENT ENVIRONMENT]]
36. [[#PROGRAMMING THE ADC USING THE ARDUINO DEVELOPMENT ENVIRONMENT#Syntax and Operation|Syntax and Operation]]
37. [[#Analog to Digital Conversion (ADC)#PROGRAMMING THE ADC IN C|PROGRAMMING THE ADC IN C]]
38. [[#PROGRAMMING THE ADC IN C#Function Descriptions|Function Descriptions]]
	1. [[#Function Descriptions#1. ADC Initialization (`InitADC`)|1. ADC Initialization (`InitADC`)]]
	2. [[#Function Descriptions#2. ADC Channel Reading (`ReadADC`)|2. ADC Channel Reading (`ReadADC`)]]
39. [[#PROGRAMMING THE ADC IN C#Source Code|Source Code]]
40. [[#Analog to Digital Conversion (ADC)#EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3|EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3]]
41. [[#EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3#Project Requirements & Interface Setup|Project Requirements & Interface Setup]]
42. [[#EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3#ADC RAIN GAGE INDICATOR USING THE ARDUINO DEVELOPMENT ENVIRONMENT|ADC RAIN GAGE INDICATOR USING THE ARDUINO DEVELOPMENT ENVIRONMENT]]
43. [[#EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3#Operational Workflow|Operational Workflow]]
44. [[#EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3#ADC RAIN GAGE INDICATOR IN C|ADC RAIN GAGE INDICATOR IN C]]
45. [[#EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3#Extended Functional Requirements|Extended Functional Requirements]]
46. [[#EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3#Complete Program Implementation|Complete Program Implementation]]
47. [[#Analog to Digital Conversion (ADC)#ONE-BIT ADC – THRESHOLD DETECTOR|ONE-BIT ADC – THRESHOLD DETECTOR]]
48. [[#ONE-BIT ADC – THRESHOLD DETECTOR#Comparator Operation|Comparator Operation]]
49. [[#ONE-BIT ADC – THRESHOLD DETECTOR#Flash Converters (Multi-Channel Detectors)|Flash Converters (Multi-Channel Detectors)]]
50. [[#Analog to Digital Conversion (ADC)#DIGITAL-TO-ANALOG CONVERSION (DAC)|DIGITAL-TO-ANALOG CONVERSION (DAC)]]
51. [[#DIGITAL-TO-ANALOG CONVERSION (DAC)#The Summation Method|The Summation Method]]
52. [[#DIGITAL-TO-ANALOG CONVERSION (DAC)#Post-Conversion Signal Conditioning|Post-Conversion Signal Conditioning]]
53. [[#DIGITAL-TO-ANALOG CONVERSION (DAC)#DAC WITH THE ARDUINO DEVELOPMENT ENVIRONMENT|DAC WITH THE ARDUINO DEVELOPMENT ENVIRONMENT]]
54. [[#DIGITAL-TO-ANALOG CONVERSION (DAC)#Syntax and Parameters|Syntax and Parameters]]
55. [[#DIGITAL-TO-ANALOG CONVERSION (DAC)#DAC WITH EXTERNAL CONVERTERS|DAC WITH EXTERNAL CONVERTERS]]
56. [[#DIGITAL-TO-ANALOG CONVERSION (DAC)#External DAC Configurations and Interfaces|External DAC Configurations and Interfaces]]
57. [[#Analog to Digital Conversion (ADC)#SUMMARY|SUMMARY]]
58. [[#Interrupt Subsystem|Interrupt Subsystem]]
	1. [[#External DAC Configurations and Interfaces#Core Objectives|Core Objectives]]
59. [[#Interrupt Subsystem#OVERVIEW|OVERVIEW]]
60. [[#OVERVIEW#Core Concepts of Interrupt Handling|Core Concepts of Interrupt Handling]]
61. [[#OVERVIEW#General Execution Flow|General Execution Flow]]
62. [[#OVERVIEW#ATMEGA328 INTERRUPT SYSTEM|ATMEGA328 INTERRUPT SYSTEM]]
63. [[#OVERVIEW#Interrupt Priority Hierarchy|Interrupt Priority Hierarchy]]
64. [[#OVERVIEW#GENERAL INTERRUPT RESPONSE|GENERAL INTERRUPT RESPONSE]]
65. [[#Interrupt Subsystem#GENERAL INTERRUPT RESPONSE|GENERAL INTERRUPT RESPONSE]]
66. [[#GENERAL INTERRUPT RESPONSE#Execution Steps|Execution Steps]]
67. [[#Interrupt Subsystem#INTERRUPT PROGRAMMING OVERVIEW|INTERRUPT PROGRAMMING OVERVIEW]]
68. [[#Interrupt Subsystem#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT|PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT]]
69. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Supported Environments and Toolchains|Supported Environments and Toolchains]]
70. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#MICROCHIP AVR VISUAL STUDIO GCC COMPILER INTERRUPT TEMPLATE|MICROCHIP AVR VISUAL STUDIO GCC COMPILER INTERRUPT TEMPLATE]]
71. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Implementation Requirements|Implementation Requirements]]
72. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Standard Code Template|Standard Code Template]]
73. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#IMAGECRAFT JUMPSTART C FOR AVR COMPILER INTERRUPT TEMPLATE|IMAGECRAFT JUMPSTART C FOR AVR COMPILER INTERRUPT TEMPLATE]]
74. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Implementation Requirements|Implementation Requirements]]
75. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Standard Code Template|Standard Code Template]]
76. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#EXTERNAL INTERRUPT PROGRAMMING-ATMEGA328|EXTERNAL INTERRUPT PROGRAMMING-ATMEGA328]]
77. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Triggering Modes|Triggering Modes]]
	1. [[#Triggering Modes#Programming External Interrupts in C-ImageCraft|Programming External Interrupts in C-ImageCraft]]
	2. [[#Triggering Modes#Programming External Interrupts in C-ImageCraft|Programming External Interrupts in C-ImageCraft]]
78. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Hardware Configuration Registers|Hardware Configuration Registers]]
79. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Interrupt Flag Reset Mechanics|Interrupt Flag Reset Mechanics]]
80. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Implementation Code|Implementation Code]]
	1. [[#Implementation Code#Programming External Interrupts Using the Arduino Development Environment Built-in Features-Atmega328|Programming External Interrupts Using the Arduino Development Environment Built-in Features-Atmega328]]
81. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Hardware Pin Mapping on the Arduino UNO R3|Hardware Pin Mapping on the Arduino UNO R3]]
82. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#`attachInterrupt()` Parameter Configuration|`attachInterrupt()` Parameter Configuration]]
83. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Code Example|Code Example]]
84. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#ATMEGA328 INTERNAL INTERRUPT PROGRAMMING|ATMEGA328 INTERNAL INTERRUPT PROGRAMMING]]
85. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Timer/Counter0 Overflow Operation|Timer/Counter0 Overflow Operation]]
	1. [[#Timer/Counter0 Overflow Operation#Programming an Internal Interrupt in C-Atmega328-ImageCraft|Programming an Internal Interrupt in C-Atmega328-ImageCraft]]
86. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Timing Calculations and Parameters|Timing Calculations and Parameters]]
87. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Hardware Configuration Registers|Hardware Configuration Registers]]
88. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Source Code|Source Code]]
	1. [[#Source Code#Programming an Internal Interrupt Using the Arduino Development Environment-Arduino UNO R3|Programming an Internal Interrupt Using the Arduino Development Environment-Arduino UNO R3]]
89. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Hardware Timing Adaptation for 16 MHz|Hardware Timing Adaptation for 16 MHz]]
90. [[#PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT#Arduino Code Implementation|Arduino Code Implementation]]
91. [[#Interrupt Subsystem#FOREGROUND AND BACKGROUND PROCESSING|FOREGROUND AND BACKGROUND PROCESSING]]
92. [[#FOREGROUND AND BACKGROUND PROCESSING#Foreground/Background Demonstration|Foreground/Background Demonstration]]
93. [[#Interrupt Subsystem#INTERRUPT EXAMPLES|INTERRUPT EXAMPLES]]
94. [[#INTERRUPT EXAMPLES#EXAMPLE: REAL TIME CLOCK IN C|EXAMPLE: REAL TIME CLOCK IN C]]
95. [[#INTERRUPT EXAMPLES#Timing Base and Cascading Architecture|Timing Base and Cascading Architecture]]
96. [[#INTERRUPT EXAMPLES#Implementation Code (ImageCraft C)|Implementation Code (ImageCraft C)]]
97. [[#INTERRUPT EXAMPLES#EXAMPLE: REAL TIME CLOCK USING THE ARDUINO DEVELOPMENT ENVIRONMENT|EXAMPLE: REAL TIME CLOCK USING THE ARDUINO DEVELOPMENT ENVIRONMENT]]
98. [[#INTERRUPT EXAMPLES#Timing Adjustments for 16 MHz Operation|Timing Adjustments for 16 MHz Operation]]
99. [[#INTERRUPT EXAMPLES#Arduino Code Implementation|Arduino Code Implementation]]
100. [[#INTERRUPT EXAMPLES#EXAMPLE: INTERRUPT DRIVEN USART IN C|EXAMPLE: INTERRUPT DRIVEN USART IN C]]
101. [[#INTERRUPT EXAMPLES#System Architecture & Operational Concept|System Architecture & Operational Concept]]
102. [[#INTERRUPT EXAMPLES#Communication Protocol and Baud Rate Configuration|Communication Protocol and Baud Rate Configuration]]
103. [[#INTERRUPT EXAMPLES#Transmitter Code: Encoder Simulator (`encode.c`)|Transmitter Code: Encoder Simulator (`encode.c`)]]
104. [[#INTERRUPT EXAMPLES#Receiver Code: Interrupt-Driven Receiver (`receive.c`)|Receiver Code: Interrupt-Driven Receiver (`receive.c`)]]
105. [[#Interrupt Subsystem#SUMMARY|SUMMARY]]
106. [[#Interrupt Subsystem#Interrupts and InterruptDriven I/O|Interrupts and InterruptDriven I/O]]
107. [[#Interrupts and InterruptDriven I/O#What Is Interrupt-Driven I/O?|What Is Interrupt-Driven I/O?]]
108. [[#Interrupts and InterruptDriven I/O#Comparison of Execution Flows|Comparison of Execution Flows]]
	1. [[#Comparison of Execution Flows#Normal Program Flow (No Interrupt)|Normal Program Flow (No Interrupt)]]
	2. [[#Comparison of Execution Flows#Interrupt-Driven Program Flow|Interrupt-Driven Program Flow]]
109. [[#Interrupts and InterruptDriven I/O#Why Have Interrupt-Driven I/O?|Why Have Interrupt-Driven I/O?]]
110. [[#Interrupts and InterruptDriven I/O#Two Parts to the Process|Two Parts to the Process]]
111. [[#Interrupts and InterruptDriven I/O#Part I: Causing the Interrupt to Occur|Part I: Causing the Interrupt to Occur]]
	1. [[#Part I: Causing the Interrupt to Occur#The Interrupt Signal from the Device|The Interrupt Signal from the Device]]
112. [[#Interrupts and InterruptDriven I/O#The Device Must Want Service|The Device Must Want Service]]
113. [[#Interrupts and InterruptDriven I/O#The Device Must Have the Right to Request Service|The Device Must Have the Right to Request Service]]
	1. [[#The Device Must Have the Right to Request Service#The Urgency of the Request|The Urgency of the Request]]
114. [[#Interrupts and InterruptDriven I/O#Preemption and Priority Arbitration|Preemption and Priority Arbitration]]
	1. [[#Preemption and Priority Arbitration#The INT Signal|The INT Signal]]
115. [[#Interrupts and InterruptDriven I/O#Signal Evaluation Stages|Signal Evaluation Stages]]
	1. [[#Signal Evaluation Stages#The Test for INT|The Test for INT]]
116. [[#Interrupts and InterruptDriven I/O#Instruction Boundary Rule|Instruction Boundary Rule]]
117. [[#Interrupts and InterruptDriven I/O#Control Logic Modification|Control Logic Modification]]
118. [[#Interrupts and InterruptDriven I/O#Part II: Handling the Interrupt Request|Part II: Handling the Interrupt Request]]
	1. [[#Part II: Handling the Interrupt Request#Initiate the Interrupt|Initiate the Interrupt]]
119. [[#Interrupts and InterruptDriven I/O#Saving the State of the Interrupted Program|Saving the State of the Interrupted Program]]
	1. [[#Saving the State of the Interrupted Program#Stack Mechanics During Context Saving|Stack Mechanics During Context Saving]]
120. [[#Interrupts and InterruptDriven I/O#Loading the State of the Interrupt Service Routine|Loading the State of the Interrupt Service Routine]]
	1. [[#Loading the State of the Interrupt Service Routine#Service the Interrupt|Service the Interrupt]]
	2. [[#Loading the State of the Interrupt Service Routine#Return from the Interrupt|Return from the Interrupt]]
121. [[#Interrupts and InterruptDriven I/O#Mechanics of the `RTI` Instruction|Mechanics of the `RTI` Instruction]]
122. [[#Interrupts and InterruptDriven I/O#An Example|An Example]]
123. [[#Interrupts and InterruptDriven I/O#Scenario Parameters|Scenario Parameters]]
124. [[#Interrupts and InterruptDriven I/O#Step-by-Step Execution Sequence|Step-by-Step Execution Sequence]]
	1. [[#Step-by-Step Execution Sequence#1. Initial Interruption of Program A by Device B|1. Initial Interruption of Program A by Device B]]
	2. [[#Step-by-Step Execution Sequence#2. Nested Interruption of Device B by Device C|2. Nested Interruption of Device B by Device C]]
	3. [[#Step-by-Step Execution Sequence#3. Completion of Device C and First Return|3. Completion of Device C and First Return]]
	4. [[#Step-by-Step Execution Sequence#4. Completion of Device B and Return to Program A|4. Completion of Device B and Return to Program A]]
125. [[#Interrupts and InterruptDriven I/O#Supervisor Stack Frame Progression|Supervisor Stack Frame Progression]]
126. [[#Interrupts and InterruptDriven I/O#Not Just I/O Devices|Not Just I/O Devices]]
127. [[#Interrupts and InterruptDriven I/O#Non-I/O Interrupt Sources|Non-I/O Interrupt Sources]]

- - -
### SENSORS
In typical embedded applications, a microcontroller functions through a core cycle of data acquisition, processing, and actuation:

1. **Data Collection:** Input _sensors_ gather data from the environment.
2. **Processing:** A host algorithm running on the microcontroller assimilates and processes the incoming data.
3. **Control Output:** The microcontroller determines a control decision based on the processed information and issues corresponding signals to output peripheral devices.

>[!info]
>Sensors used to collect input data may be either _digital_ or _analog_ in nature.
#### Digital Sensors

_Digital sensors_ encode measurement data into a continuous series of digital logic pulses (a pulse train). The data may be encoded using various signal parameters:
- _Duty cycle_
- _Frequency_
- _Period_
- _Pulse rate_

Microcontrollers configure the input stage of their internal timing systems to measure these specific parameters and decode the sensor values.

---

An _optical encoder_ is a common type of digital sensor used to monitor rotational movement. It consists of a transparent plastic disk with opaque lines etched onto its surface, placed between a stationary optical emitter and detector pair. As the disk rotates, the etched opaque lines periodically interrupt the light beam between the emitter and detector, producing a pulsed output signal that reflects the disk's rotation.

Optical encoders are primarily categorized into two types based on the required information:

##### 1. Absolute Encoders
_Absolute encoders_ retain exact position information even when system power is lost. They are equipped with multiple data tracks across the disk surface to determine the precise angular location of the encoder disk at all times.

>[!example]
>In a security gate control system, an absolute encoder is used to monitor and track the gate's position continuously, ensuring the exact location remains known even after a power outage.

##### 2. Incremental Encoders
_Incremental encoders_ are used in applications requiring velocity measurement or combined velocity and direction tracking. These are subdivided into:

- **Incremental Tachometer Encoders:** Contain a single track of etched opaque lines. They measure the velocity of a rotating device by counting the number of pulses detected within a fixed time window. Because the fixed number of pulses per disk revolution is known, the rotational velocity can be calculated directly.
- **Quadrature Encoders:** Contain two distinct tracks (Channel A and Channel B) shifted in relationship to one another by $90^\circ$ out of phase. This phase shift allows the system to determine both the rotational velocity (from pulse timing) and the direction of rotation (by determining which channel leads the other in phase).
#### Analog Sensors

_Analog sensors_ generate a continuous DC voltage that is directly proportional to the physical parameter being measured. 

Because microcontrollers operate digitally, this analog signal must be processed through an Analog-to-Digital Converter (ADC) subsystem:
1. **Signal Conditioning:** External analog circuitry often pre-processes the raw sensor voltage to scale and shift it so that it fits within the reference voltage limits of the ADC.
2. **Quantization and Conversion:** The conditioned analog DC voltage is converted into an equivalent binary representation that the microcontroller can read and process.

---

>[!example] Flex Sensor
>A _flex sensor_ varies its electrical resistance in response to mechanical bending:
>- **Flat ($0^\circ$ flex):** Nominal resistance is approximately $10\text{ k}\Omega$.
>- **Bent ($90^\circ$ flex):** Resistance increases to roughly $30\text{--}40\text{ k}\Omega$.
>
>**Interfacing:** Microcontrollers cannot read electrical resistance directly. To measure bending, the flex sensor is placed into a _voltage divider circuit_, which converts the change in resistance into a corresponding change in DC voltage (higher flex produces a higher DC voltage). This resulting voltage is then sampled via the microcontroller's ADC.
>
>**Applications:** Virtual reality data gloves, robotics, biomechanical monitoring, and biological movement tracking.

---

>[!example] Ultrasonic Sensor (Maxbotix LV-EZ3)
>An _ultrasonic sensor_ measures distance using sound waves above the range of human hearing ($20\text{ Hz}\text{ to }20\text{ kHz}$). 
>
>**Principle of Operation:**
>1. The sensor emits an acoustic wave burst at $42\text{ kHz}$.
>2. The sound wave travels through the air, reflects off a solid surface, and returns to the detector.
>3. The elapsed time-of-flight (transit time) from emission to reception is used to calculate the linear distance to the target.
>
>**Specifications and Output Formats:**
>- **Power Supply:** Operates from a $2.5\text{--}5.5\text{ VDC}$ source.
>- **Outputs:** Provides range data in three formats simultaneously:
>  - _Analog Voltage:_ Linear output with a resolution of $10\text{ mV/inch}$.
>  - _Pulse-Width Modulation (PWM):_ Pulse output with a duty cycle scaling factor of $147\ \mu\text{s/inch}$.
>  - _Serial Digital Interface:_ RS-232 compatible output transmitting at $9600\text{ bps}$.

---

>[!example] Temperature Sensors (LM34 & LM35)
>The LM34 and LM35 are precision integrated-circuit temperature transducers whose output voltage is linearly proportional to temperature:
>- **LM34 (Fahrenheit):** Calibrated directly in degrees Fahrenheit. For instance, the LM34D model operates across a range of $32^\circ\text{F}\text{ to }212^\circ\text{F}$ with a scale factor of $+10\text{ mV/}^\circ\text{F}$ and a typical accuracy of $\pm 0.5^\circ\text{F}$.
>- **LM35 (Centigrade):** Calibrated directly in degrees Celsius.
>
>**Interfacing:** The output pin of the transducer connects directly to an ADC input channel on the microcontroller for linear temperature decoding.

- - -
# Analog to Digital Conversion (ADC)

#### Core Objectives
- **Conversion Process:** Illustrate the fundamental steps involved in converting continuous analog signals to discrete digital data.
- **Conversion Quality Metrics:** Assess the performance and accuracy of an ADC using key metrics:
  - Sampling rate
  - Quantization levels
  - Bit resolution (number of bits used for encoding)
  - Dynamic range
- **Signal Conditioning:** Design and implement analog interface circuits using operational amplifiers (op-amps) to condition sensor outputs for ADC inputs.
- **`ATmega328` ADC Architecture:** Identify and configure the primary control and data registers required for conversion.
- **Execution Steps:** Describe the complete operational sequence to perform an analog-to-digital conversion on the `ATmega328`.
- **Firmware Implementation:**
  - Program the `Arduino UNO R3` to execute conversions using built-in Arduino environment functions.
  - Program the `ATmega328` directly in `C` for low-level hardware control.
- **Digital-to-Analog Conversion (DAC):** Explain the operational principles and mechanics of converting digital representations back into continuous analog signals.
## OVERVIEW

Microcontrollers operate as discrete digital processors, whereas physical phenomena in the natural world present as continuous, analog signals. Interfacing a microcontroller with the physical environment requires translation mechanisms between these continuous and discrete domains:

- **Analog-to-Digital Converter (ADC):** Converts continuous physical signals (such as voltage from a sensor) into discrete binary numerical representations that the microcontroller can process. Most modern microcontrollers, including the `ATmega328`, include an integrated, on-chip ADC subsystem.
- **Digital-to-Analog Converter (DAC):** Converts discrete digital values back into continuous analog voltages or currents to drive external actuators. While dedicated DACs typically exist as external peripheral chips, microcontrollers can also approximate continuous analog outputs using built-in Pulse-Width Modulation (`PWM`) techniques.

>[!info]
>The primary hardware architecture utilized in microcontrollers like the `ATmega328` for analog-to-digital translation is the _successive-approximation_ ADC.

Conversion subsystems are managed and configured via low-level hardware control registers in `C` or through abstracted high-level functions available in the Arduino Development Environment (`ADE`).
## SAMPLING, QUANTIZATION, AND ENCODING

The Analog-to-Digital Conversion (ADC) process transforms continuous real-world signals into discrete digital representations through three sequential steps:
1. **Sampling:** Discretizing the signal in time.
2. **Quantization:** Discretizing the signal in amplitude.
3. **Encoding:** Converting the quantized amplitude into a binary code.

![[Pasted image 20260920202635.png]]
Figure: Sampling, quantization, and encoding

---

### Sampling

_Sampling_ is the process of capturing periodic "snapshots" of a continuous analog signal at fixed, equal time intervals. 

The primary objective during sampling is resource optimization: using the minimum number of samples necessary while retaining sufficient signal information to faithfully reconstruct the original analog waveform. The required sampling rate is determined by the maximum rate of change (highest frequency component) contained within the analog signal.

>[!summary] theorem : Nyquist Sampling Theorem
>To faithfully capture and reconstruct a continuous analog signal in a digital system without distortion or information loss, the sampling rate must be at least twice as fast as the highest frequency component present in the signal.
>
>$$f_s \ge 2 f_{\text{max}}$$
>
>**breakdown**:
>- $f_s$ : The sampling frequency (samples per second or $\text{Hz}$). This represents the rate at which discrete measurements are captured.
>- $f_{\text{max}}$ : The highest frequency component contained within the analog input signal ($\text{Hz}$).
>- $2 f_{\text{max}}$ : The *Nyquist Rate*, which represents the absolute minimum theoretical sampling threshold.

>[!example] Human Voice Sampling
>Human speech contains frequency components ranging from approximately $20\text{ Hz}$ to $4\text{ kHz}$ ($f_{\text{max}} = 4\text{ kHz}$).
>- **Minimum Sampling Rate:** According to the Nyquist theorem, the signal must be sampled at:
>  $$f_s \ge 2 \times 4\text{ kHz} = 8\text{ kHz} \quad (8000\text{ samples/second})$$
>- **Anti-Aliasing Filter:** To prevent higher out-of-band frequencies from violating the Nyquist criterion and causing distortion (aliasing), a hardware _low-pass anti-aliasing filter_ with a cutoff frequency ($f_c$) of $4\text{ kHz}$ is placed directly before the sampling circuitry.

---

### Quantization

Once an analog signal is sampled at discrete time intervals, digital systems require a scheme to represent the continuous amplitude of each sample using discrete numerical levels. This process is called _quantization_.

A digital system divides the total analog input range (typically $0\text{--}5\text{ V}$, conditioned from sensor inputs) into a finite number of discrete steps:
- **Bit ($1\text{ bit}$):** Can represent $2^1 = 2$ levels ($0$ and $1$), distinguishing only high from low.
- **Nibble ($4\text{ bits}$):** Represents $2^4 = 16$ levels.
- **Byte ($8\text{ bits}$):** Represents $2^8 = 256$ levels.
- **$n$-bit Resolution:** Given $n$ bits, a system can represent $2^n$ unique quantization levels.

$$L = 2^n$$

- **$L$** : Total number of unique quantization levels available.
- **$n$** : Number of digital bits used for conversion resolution.

As the bit resolution ($n$) increases:
- The total number of available quantization levels increases exponentially.
- The step size (the voltage "distance" between adjacent levels) decreases, resulting in a finer and more accurate mapping of the analog voltage.
- _Quantization Error_—the discrepancy between the actual continuous analog voltage and the assigned discrete level—is reduced. Quantization error is inversely proportional to the number of bits ($n$) utilized.

---

### Encoding

_Encoding_ is the final stage of the conversion process, where each assigned quantization level is translated into a specific digital binary word matching the system's bit length ($n$).

>[!example]
>In an $8$-bit system ($2^8 = 256$ discrete levels, numbered $0$ to $255$):
>- A sample mapped to **Level 1** is encoded as: `0000_0001`
>- A sample mapped to **Level 198** is encoded as: `1100_0110`
>
>Through this step, continuous analog signal variations are fully transformed into a structured sequence of discrete binary numbers suitable for storage and computational processing.

### RESOLUTION AND DATA RATE

### Resolution

_Resolution_ defines the smallest change in input voltage that can be detected by an Analog-to-Digital Converter. In practical terms, it is the voltage "distance" or step size between two adjacent quantization levels. 

Increasing the number of bits ($b$) used for conversion increases the number of available quantization levels ($2^b$), which reduces the step size and minimizes the resulting _quantization error_ (or _resolution error_).

>[!summary] theorem : ADC Resolution
>The resolution (step size) of an ADC is determined by its total analog voltage range divided by the total number of quantization states:
>
>$$\text{Resolution} = \frac{\text{Voltage Span}}{2^b} = \frac{V_{\text{ref(high)}} - V_{\text{ref(low)}}}{2^b}$$
>
>**breakdown**:
>- $\text{Resolution}$ : The smallest detectable voltage increment per discrete step ($\text{V}$ or $\text{mV}$).
>- $\text{Voltage Span}$ : The full analog input voltage operating range ($V_{\text{ref(high)}} - V_{\text{ref(low)}}$).
>- $V_{\text{ref(high)}}$ : The upper reference voltage threshold.
>- $V_{\text{ref(low)}}$ : The lower reference voltage threshold.
>- $b$ : The bit resolution of the ADC (number of bits per sample).
>- $2^b$ : The total number of unique discrete quantization levels.

>[!example] Resolution Calculations
>- **1-bit System ($0\text{--}5\text{ V}$ span):**
>  $$\text{Resolution} = \frac{5\text{ V} - 0\text{ V}}{2^1} = 2.5\text{ V} \quad (50\% \text{ of full-scale range})$$
>- **4-bit System ($0\text{--}5\text{ V}$ span):**
>  $$\text{Resolution} = \frac{5\text{ V} - 0\text{ V}}{2^4} = \frac{5}{16} = 0.3125\text{ V}$$
>- **`ATmega328` 10-bit ADC ($0\text{--}5\text{ V}$ span):**
>  $$\text{Resolution} = \frac{5\text{ V} - 0\text{ V}}{2^{10}} = \frac{5\text{ V}}{1024} \approx 4.88\text{ mV}$$
>- **20-bit System ($0\text{--}5\text{ V}$ span):**
>  $$\text{Resolution} = \frac{5\text{ V} - 0\text{ V}}{2^{20}} = \frac{5\text{ V}}{1{,}048{,}576} \approx 4.77 \times 10^{-6}\text{ V} \quad (9.54 \times 10^{-5}\% \text{ of full range})$$

---

### Data Rate

_Data rate_ represents the volume of digital data generated or processed by a system per unit of time, typically expressed in bits per second ($\text{bps}$) or bytes per second.

Although higher bit depths improve signal accuracy, they dramatically increase data bandwidth, computational load, and memory storage requirements. System designers must balance required measurement resolution against these processing and hardware constraints.

>[!example] Telephone Switching System Bandwidth
>Consider a telecommunication switching center managing $100{,}000$ active customer voice channels:
>- **Sampling Frequency ($f_s$):** $8\text{ kHz}$ (sample interval $T_s = \frac{1}{f_s} = 125\ \mu\text{s}$).
>- **Encoding Resolution ($b$):** $10\text{ bits/sample}$.
>
>**Total System Data Rate:**
>$$\text{Data Rate} = 100{,}000\text{ channels} \times 8{,}000\text{ samples/s} \times 10\text{ bits/sample} = 8 \times 10^9\text{ bits/second}\ (8\text{ Gbps})$$

---

### Dynamic Range

_Dynamic range_ is a logarithmic metric that measures the signal-to-noise ratio ($\text{SNR}$) of an ADC system, quantifying the strength of the desired signal relative to quantization noise. It is expressed in Decibels ($\text{dB}$).

>[!summary] theorem : ADC Dynamic Range
>The theoretical dynamic range of an ideal $b$-bit converter is defined as:
>
>$$\text{Dynamic Range} = 20 \log_{10}(2^b) \approx 6.02 \cdot b\text{ dB}$$
>
>**breakdown**:
>- $\text{Dynamic Range}$ : The ratio of the maximum measurable signal level to the smallest quantization level, measured in Decibels ($\text{dB}$).
>- $b$ : The bit resolution of the ADC.
>- $\log_{10}$ : The base-10 logarithm.
>- $2^b$ : The total number of quantization steps.

Commercial converters typically utilize between $8$ and $12$ bits of resolution:
- **8-bit Converter:** $20 \log_{10}(2^8) \approx 48.16\text{ dB}$
- **12-bit Converter:** $20 \log_{10}(2^{12}) \approx 72.25\text{ dB}$
## ANALOG-TO-DIGITAL CONVERSION (ADC) PROCESS

The primary objective of the Analog-to-Digital Conversion (ADC) process is to translate continuous, real-world analog signals into faithful discrete digital representations. This is achieved by combining three core operations: **sampling**, **quantization**, and **encoding**.

Before conversion can occur, physical phenomena must first be converted into measurable electrical quantities via _transducers_.

---

### Transducers

>[!info]
>A **transducer** is an electrical and/or mechanical device that converts physical signals into electrical signals, or converts electrical signals into physical phenomena.

Transducers serve as the bridge between digital processing systems and the physical world and are categorized into two primary types:

1. **Input Transducers (Sensors):** Convert physical quantities (such as temperature, pressure, sound, or light) into electrical signals (voltage, current, or resistance).
   - *Examples:* Microphones, cameras, computer mice, keyboards, infrared sensors, and temperature sensors.
2. **Output Transducers (Actuators / Displays):** Convert electrical signals from a processing system into physical actions, displays, or states.
   - *Examples:* Computer screens, printers, audio speakers, and electric motors.

>[!important]
>Careful interface design between transducers and the microcontroller is critical. A poorly designed analog interface circuit can distort the signal, introduce noise, or lead to erratic embedded system operation and hardware failure.
### TRANSDUCER INTERFACE DESIGN (TID) CIRCUIT

Before an analog signal from a linear input transducer can be digitized by an Analog-to-Digital Converter, it must pass through signal conditioning circuitry known as a **Transducer Interface Design (TID)** circuit. 

The primary objective of the TID circuit is to scale and level-shift the electrical output of a sensor so that it fits within the operating voltage range of the ADC (typically $0\text{ to }5\text{ VDC}$).

![[Pasted image 20260920202953.png]]
Figure 3.2: A block diagram of the signal conditioning for an analog-to-digital converter. The
range of the sensor voltage output is mapped to the analog-to-digital converter input voltage
range. The scalar multiplier maps the magnitudes of the two ranges and the bias voltage is used
to align two limits.

---

### Operating Principle: Scaling and Biasing

The interface transformation consists of two distinct stages, typically implemented using operational amplifier (op-amp) circuits:

1. **Scaling Stage ($K$):** A scalar multiplier scales (amplifies or attenuates) the input signal's peak-to-peak voltage span to match the ADC's span.
2. **Bias Stage ($B$):** An offset stage adds or subtracts a DC reference voltage to shift the entire signal waveform into the strictly positive voltage window of the converter.

>[!example] Conceptual Scaling and Biasing
>Consider a microphone transducer with an output range of $-5\text{ VDC}$ to $+5\text{ VDC}$ ($10\text{ V}$ span) being interfaced to an ADC with a $0\text{ to }5\text{ VDC}$ range ($5\text{ V}$ span):
>1. **Scale ($K = 0.5$):** Multiplying the signal by $\frac{1}{2}$ maps the range to $-2.5\text{ VDC}\text{ to }+2.5\text{ VDC}$.
>2. **Bias ($B = +2.5\text{ VDC}$):** Adding a $+2.5\text{ VDC}$ offset shifts the range to the required $0\text{ to }5\text{ VDC}$.

---

### Mathematical Model

The scaling and biasing process for any linear transducer interface is defined by a system of two linear equations:

>[!summary] theorem : TID Mapping Equations
>$$\begin{cases}
>V_{2\text{max}} = (V_{1\text{max}} \cdot K) + B \\
>V_{2\text{min}} = (V_{1\text{min}} \cdot K) + B
>\end{cases}$$
>
>**breakdown**:
>- $V_{1\text{max}}$ : Maximum output voltage from the input transducer (produced at the maximum physical input parameter $X_{\text{max}}$).
>- $V_{1\text{min}}$ : Minimum output voltage from the input transducer (produced at the minimum physical input parameter $X_{\text{min}}$).
>- $V_{2\text{max}}$ : High reference voltage limit of the ADC subsystem (typically $+5\text{ VDC}$).
>- $V_{2\text{min}}$ : Low reference voltage limit of the ADC subsystem (typically $0\text{ VDC}$).
>- $K$ : Scalar multiplier constant (circuit gain or attenuation factor).
>- $B$ : DC offset bias voltage ($\text{VDC}$).

Because $V_{1\text{max}}$ and $V_{1\text{min}}$ are specified by the transducer's datasheet, and $V_{2\text{max}}$ and $V_{2\text{min}}$ are determined by the ADC's reference voltages, the equations form a two-variable linear system that is solved directly for the required scaling factor $K$ and bias voltage $B$.

---

>[!example] Photodiode Interface Calculation
>A photodiode connected to a transimpedance amplifier produces:
>- $V_{1\text{max}} = 0\text{ V}$ at maximum rated light intensity.
>- $V_{1\text{min}} = -2.50\text{ VDC}$ at minimum rated light intensity.
>
>Interfacing this transducer to an ADC with an operating range of $V_{2\text{min}} = 0\text{ V}$ to $V_{2\text{max}} = 5.0\text{ V}$:
>
>1. **Set up the system of equations:**
>   $$5.0\text{ V} = (0\text{ V} \cdot K) + B$$
>   $$0\text{ V} = (-2.50\text{ V} \cdot K) + B$$
>
>2. **Solve for $B$:**
>   $$B = 5.0\text{ VDC}$$
>
>3. **Solve for $K$:**
>   $$0 = (-2.50\text{ V} \cdot K) + 5.0\text{ V}$$
>   $$-2.50\text{ V} \cdot K = -5.0\text{ V}$$
>   $$K = -2$$
>
>**Result:** The required interface circuit requires an inverting gain stage with a scale factor of $K = -2$ and a DC offset bias of $B = +5\text{ VDC}$.
### OPERATIONAL AMPLIFIERS

In the Transducer Interface Design (TID) process, the design equations produce a required scaling gain factor ($K$) and a DC offset bias voltage ($B$). These mathematical operations are physically implemented in hardware using _operational amplifiers_ (op-amps).

>[!info]
>Operational amplifiers are versatile integrated circuits widely used for analog signal processing tasks, including:
>- Implementing scaling ($K$) and biasing ($B$) conditioning circuits
>- Analog active filter design (such as anti-aliasing filters)
>- Analog computing and instrumentation circuits
#### The Ideal Operational Amplifier

An _operational amplifier_ (op-amp) is an active integrated circuit powered by external supply voltages ($\pm V_{CC}$). It consists of two input terminals and a single output terminal:
- **Non-Inverting Input ($V_p$):** Positive differential terminal.
- **Inverting Input ($V_n$):** Negative differential terminal.
- **Output ($V_o$):** Amplified differential voltage output.

---

### Open-Loop Operation and Saturation

In an open-loop (unassisted) configuration, the op-amp amplifies the voltage difference between its input terminals by the open-loop gain:

$$V_o = A_{vol}(V_p - V_n)$$

- **$V_o$** : Output voltage ($\text{V}$).
- **$A_{vol}$** : Large-signal open-loop voltage gain (typically $A_{vol} \gg 50{,}000$).
- **$V_p$** : Voltage at the non-inverting input terminal ($\text{V}$).
- **$V_n$** : Voltage at the inverting input terminal ($\text{V}$).

>[!warning] Output Saturation and Clipping
>Because the open-loop gain ($A_{vol}$) is extremely large, even a microvolt-level difference between $V_p$ and $V_n$ drives the amplifier into _saturation_. In saturation, the output voltage cannot exceed the power supply limits and clips at levels slightly below the supply rails ($\pm V_{CC}$), distorting the signal.

To prevent unwanted saturation and achieve precise, predictable voltage scaling, op-amps are predominantly configured with **closed-loop negative feedback**, where a portion of the output signal is routed back to the inverting input ($V_n$).

---

### Standard Op-Amp Circuit Analysis

The behavior of any negative feedback op-amp circuit can be determined using a systematic three-step analysis method based on ideal op-amp characteristics (infinite input impedance, zero input current $I_p = I_n = 0$, and virtual short $V_p = V_n$):

1. **Formulate the Nodal Equation:** Apply Kirchhoff's Current Law (KCL) to write the node equation at the inverting terminal ($V_n$).
2. **Apply Ideal Op-Amp Characteristics:** Substitute the ideal op-amp approximations ($I_n = 0$ and $V_n = V_p$) into the nodal equation.
3. **Solve for Output Voltage ($V_o$):** Algebraically isolate and solve for $V_o$ in terms of the input voltages and feedback resistor network.

![[Pasted image 20260920203215.png]]
Figure 3.3: Ideal operational amplifier characteristics.

---

>[!example] Two-Stage Op-Amp Implementation for Transducer Interface
>Implementing a Transducer Interface Design (TID) with scaling factor $K = -2$ and bias $B = +5\text{ VDC}$ requires cascading two distinct operational amplifier stages:
>
>1. **Stage 1 (Inverting Gain Stage):**
>   - An inverting amplifier configuration provides a voltage scaling factor of $K_1 = -2$.
>   - Converts the incoming transducer signal $V_{\text{in}}$ to an intermediate voltage:
>     $$V_{\text{stage1}} = -2 \cdot V_{\text{in}}$$
>
>2. **Stage 2 (Inverting Summing Stage):**
>   - A summing amplifier stage sums the output of Stage 1 ($V_{\text{stage1}}$) with a reference bias source of $-5\text{ VDC}$.
>   - Because the summing configuration introduces a native sign inversion ($-1$), the resulting output produces the final required positive offset:
>     $$V_o = -(V_{\text{stage1}} + (-5\text{ VDC})) = -(-2 \cdot V_{\text{in}} - 5\text{ VDC}) = 2 \cdot V_{\text{in}} + 5\text{ VDC}$$
>
>This two-stage design provides the necessary signal scaling ($K = 2$) and DC offset shift ($B = +5\text{ VDC}$) to interface the transducer with an ADC.
## ADC CONVERSION TECHNOLOGIES

The `ATmega328` microcontroller incorporates a **successive-approximation** conversion architecture to translate continuous analog input samples into 10-bit digital representations.

---

### Successive-Approximation Architecture

A successive-approximation Analog-to-Digital Converter (SAR ADC) determines the digital equivalent of an analog voltage using three core functional building blocks:

1. **Successive-Approximation Controller / Register:** Sequentially tests and manages each bit from the Most Significant Bit (MSB) down to the Least Significant Bit (LSB).
2. **Internal Digital-to-Analog Converter (DAC):** Converts the controller's current binary estimate into a corresponding internal analog reference voltage.
3. **Analog Comparator:** Compares the external analog input signal against the internal analog voltage produced by the DAC.

---

### Step-by-Step Conversion Process

The conversion algorithm operates through a binary-search progression across all available resolution bits:

1. **Initialization:** The conversion sequence starts at the **MSB** (Most Significant Bit).
2. **Bit Assertion:** The controller sets the active test bit to `1` (leaving lower-order bits at `0`) and drives the DAC to generate the equivalent test voltage.
3. **Voltage Comparison:** The analog comparator checks whether the DAC test voltage is greater than or less than the incoming analog input voltage:
   - If the DAC voltage is **greater** than the input voltage, the bit is cleared back to `0`.
   - If the DAC voltage is **less than or equal to** the input voltage, the bit is retained as `1`.
4. **Iteration:** The controller moves down to the next most significant bit and repeats the process.
5. **Completion:** Once decisions have been evaluated for all bits (all 10 bits in the `ATmega328`), the final binary value stored in the register is latched as the conversion output.

---

### Architectural Trade-offs

- **Advantage:** Conversion time is strictly uniform and deterministic—the converter requires a fixed number of clock cycles per conversion regardless of the input voltage level.
- **Disadvantage:** Implementation requires relatively complex internal control logic, precision resistor networks, and high-speed analog DAC hardware.

![[Pasted image 20260920203350.png]]
Figure 3.4: Classic operational amplifier configurations. Adapted from Faulkenberry [7].

![[Pasted image 20260920203411.png]]
Figure 3.5: Operational amplifier analysis for the non-inverting amplifier. Adapted from
Faulkenberry [7].

![[Pasted image 20260920203425.png]]
Figure 3.6: Operational amplifier implementation of the transducer interface design (TID) example circuit.

![[Pasted image 20260920203437.png]]
Figure 3.7: Successive-approximation ADC.
## THE MICROCHIP ATMEGA328 ADC SYSTEM

The `ATmega328` microcontroller incorporates an integrated, hardware-based Analog-to-Digital Converter subsystem.

### Key Hardware Features

- **10-bit Resolution:** Converts input voltages into $2^{10} = 1024$ discrete digital levels.
- **$\pm 2\text{ LSB}$ Absolute Accuracy:** Total absolute error is constrained within $\pm 2$ Least Significant Bits.
- **13 ADC Clock Cycles:** Standard conversion duration requires 13 ADC clock cycles to complete.
- **6 Multiplexed Input Channels:** Six single-ended analog input channels routed to a single internal conversion core.
- **Selectable Result Justification:** Output data can be aligned to either the left or the right within the 16-bit data register pair.
- **Operating Voltage Range:** Supports analog input potentials from $0\text{ V}$ to $V_{CC}$.

---

### Resolution and Accuracy

>[!summary] theorem : ATmega328 ADC Resolution & Accuracy
>$$\text{Resolution} = \frac{V_{RH} - V_{RL}}{2^b}$$
>
>**breakdown**:
>- $\text{Resolution}$ : The smallest detectable voltage change per discrete bit level ($\text{mV}$).
>- $V_{RH}$ : ADC high reference voltage (typically $5\text{ VDC}$).
>- $V_{RL}$ : ADC low reference voltage (typically $0\text{ VDC}$).
>- $b$ : Number of resolution bits ($b = 10$).
>- $2^b$ : Total discrete quantization steps ($2^{10} = 1024$).

Using typical reference values:
- **Voltage Step (Resolution):**
  $$\text{Resolution} = \frac{5.0\text{ V} - 0.0\text{ V}}{1024} = 4.88\text{ mV/LSB}$$
- **Absolute Accuracy ($\pm 2\text{ LSB}$):**
  $$\text{Absolute Accuracy} = \pm 2 \times 4.88\text{ mV} = \pm 9.76\text{ mV}$$

---

### Clocking and Prescaling

Conversion requires 13 ADC clock cycles to resolve all 10 bits. The ADC subsystem operates from a dedicated clock signal generated by dividing the main microcontroller system clock. 

- **Prescaler Selection:** The clock prescaler is configured via the `ADPS[2:0]` (ADC Prescaler Select) bits in the `ADCSRA` (ADC Control and Status Register A).
- **Accuracy Optimization:** Operating the ADC clock at a lower frequency than the main system clock improves conversion accuracy and reduces noise when the microcontroller runs at higher clock rates.

---

### Channel Multiplexing

The `ATmega328` ADC contains a single successive-approximation converter core. Consequently, it can convert only one channel at a time:
- An internal analog multiplexer switches between the 6 single-ended input channels.
- The active conversion channel is chosen by configuring the `MUX[3:0]` bits in the `ADMUX` (ADC Multiplexer Selection Register).

---

### Data Storage and Result Justification

Because the conversion result is 10 bits wide, it is stored across a pair of 8-bit registers: **`ADCH`** (High Byte) and **`ADCL`** (Low Byte), forming a 16-bit register space.

The alignment of the 10 bits within this 16-bit space is controlled by the `ADLAR` (ADC Left Adjust Result) bit in the `ADMUX` register:
- **Right Justification (`ADLAR = 0`):** The 10-bit result is aligned to the lowest bits of `ADCL` (bits 0–7) with the upper 2 bits residing in `ADCH` (bits 0–1). This is standard for full 10-bit numerical processing.
- **Left Justification (`ADLAR = 1`):** The 8 most significant bits are placed in `ADCH` (bits 0–7), with the remaining 2 least significant bits placed in `ADCL` (bits 6–7). This configuration allows the application to read only `ADCH` if 8-bit precision is sufficient.

---

### Input Voltage Limits

>[!warning]
>The applied analog input voltage must strictly remain between $0\text{ V}$ and $V_{CC}$. Inputs extending below $0\text{ V}$ or exceeding $V_{CC}$ require external signal-conditioning circuits (such as voltage dividers, operational amplifier stages, or clamping diodes) to prevent measurement distortion and hardware damage.
### BLOCK DIAGRAM

The `ATmega328` Analog-to-Digital Converter subsystem interfaces internal conversion hardware with external physical pins to manage analog inputs and reference voltage levels.

### External Pin Interfaces

- **Analog Input Channels (`ADC[5:0]`):** Six dedicated external microcontroller pins that route analog signals from external circuits or transducers into the internal analog multiplexer.
- **Reference Voltage Pins:**
  - **`AREF`:** The external analog reference pin used to set an independent upper voltage reference limit for conversion.
  - **`AVCC`:** The dedicated power supply voltage pin for the internal ADC circuitry, typically tied to $V_{CC}$ via an external LC filter network to reduce digital power supply noise.

### Subsystem Integration

These external connection pins interface directly with the core functional elements of the ADC architecture:
- The **Analog Multiplexer** routes a chosen input channel (`ADC[5:0]`) to the converter based on the `ADMUX` selection bits.
- The **Successive-Approximation Engine** uses the reference voltages (`AREF` or `AVCC`) to compare the input signal against internal DAC thresholds.
- The resulting 10-bit conversion data is latched into the **`ADCH`** and **`ADCL`** registers, with conversion timing and execution governed by the **`ADCSRA`** control register.
### ATMEGA328 ADC REGISTERS

The `ATmega328` ADC subsystem is configured and controlled through a dedicated set of hardware registers. While the hardware architecture includes various advanced features, standard conversion operations rely on several core registers to manage reference voltage selection, channel multiplexing, result justification, conversion triggering, clock prescaling, and data retrieval.

>[!note]
>The following subsections detail the fundamental configuration registers required to initialize, control, and read baseline analog-to-digital conversions on the `ATmega328`.
#### ATmega328 ADC Multiplexer Selection Register (ADMUX)

The `ADMUX` register configures the analog reference voltage source, output data justification, and the active analog input channel.

---

#### Reference Voltage Selection (`REFS[1:0]`)
The `REFS1` and `REFS0` bits determine the reference voltage source ($V_{\text{ref}}$) used by the internal DAC during conversion:

| `REFS1` | `REFS0` | Voltage Reference Selection |
| :---: | :---: | :--- |
| `0` | `0` | **`AREF` pin:** External reference voltage applied directly to the `AREF` pin. |
| `0` | `1` | **`AVCC`:** Connected to the analog supply voltage, with an external decoupling capacitor at the `AREF` pin. |
| `1` | `0` | **Reserved** (Do not use). |
| `1` | `1` | **Internal 1.1 VDC Reference:** On-chip precision reference voltage, with an external capacitor at the `AREF` pin. |

---

#### ADC Left Adjust Result (`ADLAR`)
The `ADLAR` bit controls how the 10-bit conversion value is formatted across the 16-bit register pair (`ADCH:ADCL`):
- `ADLAR = 0`: **Right-justified** (Standard for full 10-bit resolution).
- `ADLAR = 1`: **Left-justified** (Optimized for quick 8-bit readings from `ADCH`).

---

#### Analog Channel Selection (`MUX[3:0]`)
The lower four bits (`MUX3`, `MUX2`, `MUX1`, `MUX0`) select which analog input pin is connected to the ADC conversion hardware.

>[!example] Selecting an Analog Channel in `C`
>To route analog input channel `ADC7` (binary `0111`) with `AREF` selected and right-justified data:
>
>```c
>// Select ADC channel 7 with default AREF reference and right alignment
>ADMUX = 0x07; 
>```
#### ATmega328 ADC Control and Status Register A (ADCSRA)

The `ADCSRA` register serves as the primary control register for the ADC subsystem, managing module power, conversion triggering, completion status, and clock prescaling.

---

#### Key Control and Status Bits

- **`ADEN` (ADC Enable):** The master "on/off" switch for the entire ADC subsystem.
  - Setting this bit to logic `1` powers on the ADC.
  - Clearing it to `0` disables the ADC and reduces power consumption.
- **`ADSC` (ADC Start Conversion):** Conversion trigger bit.
  - Writing a logic `1` to this bit initiates an analog-to-digital conversion.
  - The bit remains high during conversion and automatically returns to `0` upon completion.
- **`ADIF` (ADC Interrupt Flag):** Conversion completion status flag.
  - Hardware sets this bit to logic `1` when a conversion finishes and the data registers are updated.
  - **Flag Clearing:** The `ADIF` bit is reset by writing a logic `1` to it (a counterintuitive but standard AVR convention).

---

#### ADC Clock Prescaler (`ADPS[2:0]`)

The ADC requires a dedicated clock derived by dividing down the main microcontroller system clock. The `ADPS[2:0]` bits select the division factor:

| `ADPS2` | `ADPS1` | `ADPS0` | Division Factor |
| :---: | :---: | :---: | :---: |
| `0` | `0` | `0` | 2 |
| `0` | `0` | `1` | 2 |
| `0` | `1` | `0` | 4 |
| `0` | `1` | `1` | 8 |
| `1` | `0` | `0` | 16 |
| `1` | `0` | `1` | 32 |
| `1` | `1` | `0` | 64 |
| `1` | `1` | `1` | 128 |

>[!tip]
>The ADC clock frequency is calculated as:
>$$f_{\text{ADC}} = \frac{f_{\text{system clock}}}{\text{division factor}}$$
>Selecting an appropriate prescaler value balances conversion speed against accuracy—slower ADC clock rates yield more precise conversions.
#### ATmega328 ADC Data Registers (ADCH, ADCL)

The 10-bit output of the conversion process is stored across two 8-bit registers: **`ADCH`** (ADC Data Register High) and **`ADCL`** (ADC Data Register Low). 

The bit alignment within these registers is determined by the `ADLAR` (ADC Left Adjust Result) bit in the `ADMUX` register:

- **Right-Justified (`ADLAR = 0`):**
  - **`ADCL`:** Holds the 8 least significant bits (bits 0–7).
  - **`ADCH`:** Holds the 2 most significant bits (bits 8–9) in positions 0 and 1, with the upper 6 bits remaining zero.
  - *Use Case:* Standard configuration for reading the complete 10-bit resolution value ($0\text{ to }1023$).

- **Left-Justified (`ADLAR = 1`):**
  - **`ADCH`:** Holds the 8 most significant bits (bits 2–9).
  - **`ADCL`:** Holds the 2 least significant bits (bits 0–1) in positions 6 and 7, with the lower 6 bits remaining zero.
  - *Use Case:* Allows reading only the `ADCH` register when 8-bit resolution ($0\text{ to }255$) is sufficient, bypassing the need to read `ADCL`.

>[!important]
>When reading the 10-bit result in right-justified mode, `ADCL` must be read first, followed by `ADCH`. This hardware interlock prevents the ADC from updating the data registers during a read sequence, ensuring data integrity between bytes.
## PROGRAMMING THE ADC USING THE ARDUINO DEVELOPMENT ENVIRONMENT

The Arduino Development Environment (`ADE`) provides an abstracted, high-level built-in function, `analogRead()`, to execute analog-to-digital conversions without requiring manual register manipulation.

### Syntax and Operation

```c
unsigned int return_value;
return_value = analogRead(analog_pin_read);
```

- **`analog_pin_read`:** The designated analog input pin to be sampled (e.g., `A0`, `A1`, etc.).
- **`return_value`:** An unsigned integer variable storing the 10-bit conversion result.

>[!info]
>The `analogRead()` function maps the analog input voltage from $0\text{ to }5\text{ VDC}$ to an integer value ranging from $0\text{ to }1023$:
>- $0\text{ VDC} \longrightarrow 0$
>- $5\text{ VDC} \longrightarrow 1023$
>- Step size $\approx 4.88\text{ mV}$ per increment
## PROGRAMMING THE ADC IN C

Direct register-level programming of the `ATmega328` ADC subsystem in `C` provides complete control over conversion timing, reference sources, and channel selection. The low-level operational workflow is implemented using two dedicated functions: initialization and channel reading.

---

### Function Descriptions

#### 1. ADC Initialization (`InitADC`)
- Configures channel 0 as the initial input.
- Enables the ADC and sets the clock prescaler division factor to **8** (configured for a $10\text{ MHz}$ system clock to ensure measurement accuracy).
- Performs an initial "dummy" conversion to allow internal reference voltages and analog circuitry to stabilize.
- Polls the `ADIF` (ADC Interrupt Flag) bit in `ADCSRA` via a `while` loop until conversion completes.
- Clears the `ADIF` flag by writing a logic `1` to it.

#### 2. ADC Channel Reading (`ReadADC`)
- Accepts a single input argument (`unsigned char channel`) designating the target analog pin.
- Writes the channel selection to `ADMUX` and starts the conversion by asserting the `ADSC` bit in `ADCSRA`.
- Polls the `ADIF` flag until the conversion cycle completes.
- Clears the `ADIF` flag.
- **Data Assembly:** Reads the 8 lower bits from `ADCL` first, reads the 2 upper bits from `ADCH` and shifts them left by 8 positions, and combines them using a bitwise OR operation into a single 16-bit unsigned integer (`unsigned int`) representing the right-justified 10-bit result ($0\text{ to }1023$).

>[!important] Byte Read Order
>The `ADCL` data register **must** be read prior to reading `ADCH`. Reading `ADCL` activates an internal hardware lock that prevents the ADC from updating either data register until `ADCH` is subsequently read, guaranteeing data integrity across the 16-bit boundary.

---

### Source Code

```c
//*****************************************************************
// InitADC: Initialize analog-to-digital converter
//*****************************************************************
void InitADC(void)
{
    ADMUX = 0;                  // Select channel 0
    ADCSRA = 0xC3;              // Enable ADC & start 1st dummy conversion
                                // Set ADC module prescaler to 8 (critical for accuracy)
    
    while (!(ADCSRA & 0x10));   // Check if conversion is ready (poll ADIF bit)
    ADCSRA |= 0x10;             // Clear conversion ready flag by writing a logic 1
}

//****************************************************************
// ReadADC: Read analog voltage from analog-to-digital converter.
// The desired channel is passed in as an unsigned character.
// The result is returned as a right-justified, 10-bit binary result.
// Prescaler must be set to 8 to slow the ADC clock at higher
// external clock frequencies (>10 MHz) to obtain accurate results.
//****************************************************************
unsigned int ReadADC(unsigned char channel)
{
    unsigned int binary_weighted_voltage;
    unsigned int binary_weighted_voltage_low;
    unsigned int binary_weighted_voltage_high;

    ADMUX = channel;            // Select channel
    ADCSRA |= 0x43;             // Start conversion & keep prescaler at 8
    
    while (!(ADCSRA & 0x10));   // Check if conversion is ready (poll ADIF)
    ADCSRA |= 0x10;             // Clear conversion ready flag by writing a logic 1

    binary_weighted_voltage_low = ADCL;                             // Read 8 low bits first (important)
    binary_weighted_voltage_high = ((unsigned int)(ADCH << 8));      // Read 2 high bits and multiply by 256
    
    binary_weighted_voltage = binary_weighted_voltage_low | binary_weighted_voltage_high;

    return binary_weighted_voltage; // Return concatenated 10-bit value (ADCH:ADCL)
}
//****************************************************************
```
## EXAMPLE: ADC RAIN GAGE INDICATOR WITH THE ARDUINO UNO R3

This project implements a multi-level visual indicator (similar to a rain gauge or bar graph) using a panel of eight Light-Emitting Diodes (LEDs). The display can be constructed using either eight discrete LEDs or a single integrated eight-element LED bar array.

### Project Requirements & Interface Setup

- **Analog Input:** A $10\text{ k}\Omega$ trimmer potentiometer is connected to an analog input channel to supply a variable DC voltage ($0\text{ to }5\text{ VDC}$).
- **Output Display:** The microcontroller samples the analog input voltage via the ADC subsystem and progressively illuminates between zero and eight LEDs to visually represent the measured voltage level.
- **Implementations:**
  1. High-level implementation using the Arduino Development Environment (`ADE`) with the `Arduino UNO R3`.
  2. Low-level embedded implementation using direct register manipulation in `C` on the `ATmega328`.
### ADC RAIN GAGE INDICATOR USING THE ARDUINO DEVELOPMENT ENVIRONMENT

This implementation uses an `Arduino UNO R3` to read an analog voltage from a $10\text{ k}\Omega$ trimmer potentiometer and display the result on an 8-LED bar graph. 

### Operational Workflow

- **Pin Assignments:**
  - `A0`: Analog input connected to the wiper of the potentiometer.
  - Digital Pins `0` through `7`: Dedicated outputs driving LED indicators `LED0` through `LED7`.
- **Threshold Division:** The 10-bit conversion range ($0\text{ to }1023$) is divided into eight equal segments of 128 counts each ($\frac{1024}{8} = 128$).
- **Display Output:** As the input voltage increases, the `if-else if` structure sequentially illuminates additional LEDs to create a cumulative bar display, updating every $500\text{ ms}$.

![[Pasted image 20260920204024.png]]
Figure 3.10: ADC with rain gage level indicator.

```c
//****************************************************************
#define trim_pot A0     // Analog input pin

// Digital output pins for LED indicators 0 - 7
#define LED0 0          // Digital pin 0
#define LED1 1          // Digital pin 1
#define LED2 2          // Digital pin 2
#define LED3 3          // Digital pin 3
#define LED4 4          // Digital pin 4
#define LED5 5          // Digital pin 5
#define LED6 6          // Digital pin 6
#define LED7 7          // Digital pin 7

int trim_pot_reading;   // Variable to store 10-bit ADC reading (0 - 1023)

void setup()
{
    // Configure pins 0-7 as digital outputs
    pinMode(LED0, OUTPUT);
    pinMode(LED1, OUTPUT);
    pinMode(LED2, OUTPUT);
    pinMode(LED3, OUTPUT);
    pinMode(LED4, OUTPUT);
    pinMode(LED5, OUTPUT);
    pinMode(LED6, OUTPUT);
    pinMode(LED7, OUTPUT);
}

void loop()
{
    // Read analog voltage from potentiometer
    trim_pot_reading = analogRead(trim_pot);

    if (trim_pot_reading < 128)
    {
        digitalWrite(LED0, HIGH);
        digitalWrite(LED1, LOW);
        digitalWrite(LED2, LOW);
        digitalWrite(LED3, LOW);
        digitalWrite(LED4, LOW);
        digitalWrite(LED5, LOW);
        digitalWrite(LED6, LOW);
        digitalWrite(LED7, LOW);
    }
    else if (trim_pot_reading < 256)
    {
        digitalWrite(LED0, HIGH);
        digitalWrite(LED1, HIGH);
        digitalWrite(LED2, LOW);
        digitalWrite(LED3, LOW);
        digitalWrite(LED4, LOW);
        digitalWrite(LED5, LOW);
        digitalWrite(LED6, LOW);
        digitalWrite(LED7, LOW);
    }
    else if (trim_pot_reading < 384)
    {
        digitalWrite(LED0, HIGH);
        digitalWrite(LED1, HIGH);
        digitalWrite(LED2, HIGH);
        digitalWrite(LED3, LOW);
        digitalWrite(LED4, LOW);
        digitalWrite(LED5, LOW);
        digitalWrite(LED6, LOW);
        digitalWrite(LED7, LOW);
    }
    else if (trim_pot_reading < 512)
    {
        digitalWrite(LED0, HIGH);
        digitalWrite(LED1, HIGH);
        digitalWrite(LED2, HIGH);
        digitalWrite(LED3, HIGH);
        digitalWrite(LED4, LOW);
        digitalWrite(LED5, LOW);
        digitalWrite(LED6, LOW);
        digitalWrite(LED7, LOW);
    }
    else if (trim_pot_reading < 640)
    {
        digitalWrite(LED0, HIGH);
        digitalWrite(LED1, HIGH);
        digitalWrite(LED2, HIGH);
        digitalWrite(LED3, HIGH);
        digitalWrite(LED4, HIGH);
        digitalWrite(LED5, LOW);
        digitalWrite(LED6, LOW);
        digitalWrite(LED7, LOW);
    }
    else if (trim_pot_reading < 768)
    {
        digitalWrite(LED0, HIGH);
        digitalWrite(LED1, HIGH);
        digitalWrite(LED2, HIGH);
        digitalWrite(LED3, HIGH);
        digitalWrite(LED4, HIGH);
        digitalWrite(LED5, HIGH);
        digitalWrite(LED6, LOW);
        digitalWrite(LED7, LOW);
    }
    else if (trim_pot_reading < 896)
    {
        digitalWrite(LED0, HIGH);
        digitalWrite(LED1, HIGH);
        digitalWrite(LED2, HIGH);
        digitalWrite(LED3, HIGH);
        digitalWrite(LED4, HIGH);
        digitalWrite(LED5, HIGH);
        digitalWrite(LED6, HIGH);
        digitalWrite(LED7, LOW);
    }
    else
    {
        digitalWrite(LED0, HIGH);
        digitalWrite(LED1, HIGH);
        digitalWrite(LED2, HIGH);
        digitalWrite(LED3, HIGH);
        digitalWrite(LED4, HIGH);
        digitalWrite(LED5, HIGH);
        digitalWrite(LED6, HIGH);
        digitalWrite(LED7, HIGH);
    }

    delay(500); // 500 ms sample delay
}
//****************************************************************
```
### ADC RAIN GAGE INDICATOR IN C
![[Pasted image 20260920204202.png]]
Figure 3.11: ADC with rain gage level indicator.

This implementation executes the rain gauge level display using low-level `C` register control on the `ATmega328`. In this design, `PORTD` (pins 0–7) interfaces directly with the 8-LED indicator panel, and a $10\text{ k}\Omega$ trimmer potentiometer is connected to ADC channel 0 (`ADC0`).

### Extended Functional Requirements

1. **Power-On Self-Test (POST):**
   - Execute an incrementing binary count from $0\text{ to }255$ on `PORTD`.
   - Execute a decrementing binary count from $255\text{ to }0$ on `PORTD`.
2. **Continuous ADC Gauge Operation:**
   - Sample the analog voltage from the potentiometer on ADC channel 0.
   - Map the 10-bit conversion value ($0\text{ to }1023$) into 8 proportional segments.
   - Update `PORTD` with progressive bitmasks (`0x01`, `0x03`, `0x07`, `0x0F`, `0x1F`, `0x3F`, `0x7F`, `0xFF`) to illuminate the corresponding LED bar height.

>[!note] Software Delay Mechanics
>The delay function in this implementation is a software-based timing loop that executes assembly No-Operation instructions (`asm("nop")`). 
>
>This timing method provides an approximate delay intended solely for visual observation:
>- Each `NOP` consumes fixed CPU instruction clock cycles.
>- The absolute elapsed time depends on microcontroller clock frequency, oscillator stability, and compiler optimization.

---

### Complete Program Implementation

```c
//*****************************************************************
// Microchip Register Definitions for ATmega328
#include <iom328pv.h>

// Function Prototypes
void display_increment(void);             // Displays incrementing count on PORTD
void display_decrement(void);             // Displays decrementing count on PORTD
void rain_gage(void);                     // Reads ADC and updates gauge on PORTD
void InitADC(void);                       // Initializes ADC subsystem
unsigned int ReadADC(unsigned char channel); // Reads specified ADC channel
void delay(void);                         // Software execution delay

//*****************************************************************
int main(void)
{
    display_increment();  // Display incrementing binary count (0 to 255)
    delay();
    
    display_decrement();  // Display decrementing binary count (255 to 0)
    delay();
    
    InitADC();            // Initialize ADC hardware
    
    while (1)
    {
        rain_gage();      // Continuously sample ADC and update LEDs
        delay();          // Delay between display updates (~30 ms)
    }
    
    return 0;
}

//*****************************************************************
// Delay Function: Implements approximate timing via assembly NOPs
//*****************************************************************
void delay(void)
{
    int i, k;
    for (i = 0; i < 400; i++)
    {
        for (k = 0; k < 300; k++)
        {
            asm("nop");   // Assembly NOP execution
        }
    }
}

//*****************************************************************
// Displays incrementing binary count from 0 to 255 on PORTD
//*****************************************************************
void display_increment(void)
{
    int i;
    unsigned char j = 0x00;
    
    DDRD = 0xFF;          // Configure all PORTD pins as outputs
    
    for (i = 0; i < 255; i++)
    {
        j++;
        PORTD = j;        // Output binary value to PORTD LEDs
        delay();
    }
}

//*****************************************************************
// Displays decrementing binary count from 255 to 0 on PORTD
//*****************************************************************
void display_decrement(void)
{
    int i;
    unsigned char j = 0xFF;
    
    DDRD = 0xFF;          // Configure all PORTD pins as outputs
    
    for (i = 0; i < 256; i++)
    {
        j = (j - 0x01);
        PORTD = j;        // Output binary value to PORTD LEDs
        delay();
    }
}

//*****************************************************************
// Initializes the ATmega328 ADC subsystem
//*****************************************************************
void InitADC(void)
{
    ADMUX = 0;                  // Select channel 0
    ADCSRA = 0xC3;              // Enable ADC, start dummy conversion, set prescaler to 8
    
    while (!(ADCSRA & 0x10));   // Wait for conversion completion (poll ADIF)
    ADCSRA |= 0x10;             // Clear ADIF flag by writing a logic 1
}

//*****************************************************************
// ReadADC: Performs 10-bit conversion on the specified channel
//*****************************************************************
unsigned int ReadADC(unsigned char channel)
{
    unsigned int binary_weighted_voltage;
    unsigned int binary_weighted_voltage_low;
    unsigned int binary_weighted_voltage_high;

    ADMUX = channel;            // Select target channel
    ADCSRA |= 0x43;             // Start conversion with prescaler set to 8
    
    while (!(ADCSRA & 0x10));   // Poll ADIF until conversion completes
    ADCSRA |= 0x10;             // Clear ADIF flag

    binary_weighted_voltage_low = ADCL;                             // Read lower 8 bits first
    binary_weighted_voltage_high = ((unsigned int)(ADCH << 8));      // Read upper 2 bits and shift
    binary_weighted_voltage = binary_weighted_voltage_low | binary_weighted_voltage_high;

    return binary_weighted_voltage; // Return 10-bit right-justified result
}

//*****************************************************************
// Displays voltage magnitude as a proportional LED level on PORTD
//*****************************************************************
void rain_gage(void)
{
    unsigned int ADCValue;
    
    ADCValue = ReadADC(0x00);   // Read analog channel 0
    DDRD = 0xFF;                // Ensure PORTD is set to output

    if (ADCValue < 128)
    {
        PORTD = 0x01;           // Illuminate LED at PORTD[0]
    }
    else if (ADCValue < 256)
    {
        PORTD = 0x03;           // Illuminate LEDs at PORTD[1:0]
    }
    else if (ADCValue < 384)
    {
        PORTD = 0x07;           // Illuminate LEDs at PORTD[2:0]
    }
    else if (ADCValue < 512)
    {
        PORTD = 0x0F;           // Illuminate LEDs at PORTD[3:0]
    }
    else if (ADCValue < 640)
    {
        PORTD = 0x1F;           // Illuminate LEDs at PORTD[4:0]
    }
    else if (ADCValue < 768)
    {
        PORTD = 0x3F;           // Illuminate LEDs at PORTD[5:0]
    }
    else if (ADCValue < 896)
    {
        PORTD = 0x7F;           // Illuminate LEDs at PORTD[6:0]
    }
    else
    {
        PORTD = 0xFF;           // Illuminate all LEDs at PORTD[7:0]
    }
}
//*****************************************************************
```
## ONE-BIT ADC – THRESHOLD DETECTOR

A _threshold detector_ (or _analog comparator_) is constructed by operating an operational amplifier in an open-loop configuration without negative feedback. Because the open-loop gain ($A_{vol}$) is extremely large, any voltage difference between the two input terminals immediately drives the amplifier into saturation.

---

### Comparator Operation

1. **Threshold Voltage ($V_{\text{th}}$):** A fixed reference voltage is applied to one of the op-amp input terminals.
2. **Signal Comparison:** The analog input signal ($V_{\text{in}}$) is applied to the opposite terminal and continuously compared against the reference threshold.
3. **Saturation States:**
   - **$V_{\text{in}} > V_{\text{th}}$:** The output saturates at a level slightly below the positive supply rail ($+V_{CC}$).
   - **$V_{\text{in}} < V_{\text{th}}$:** The output saturates at a level slightly above the negative supply rail ($-V_{CC}$).

>[!info] 1-Bit ADC Configuration
>When powered from a single-sided supply (such as an `LM324` op-amp with its negative supply pin tied to ground), the output swings cleanly between approximately $0\text{ V}$ (logic low) and $+V_{CC}$ (logic high). This configuration functions as a hardware-level **1-bit Analog-to-Digital Converter**, converting an analog threshold crossing into a discrete binary logic level.

---

### Flash Converters (Multi-Channel Detectors)

Multiple threshold detectors can be arranged in parallel to create a multi-channel comparator bank:
- Each comparator is connected to a progressively higher reference threshold voltage (typically generated across a resistive voltage divider ladder).
- The analog input signal is fed simultaneously to all comparators.
- As the analog input voltage rises, comparators switch on sequentially, providing an instantaneous digital representation of signal amplitude.

This architecture forms the basis of a **Flash ADC**, serving as a dedicated hardware-based equivalent to a multi-level bar graph display.
## DIGITAL-TO-ANALOG CONVERSION (DAC)

A **Digital-to-Analog Converter (DAC)** performs the inverse operation of an ADC by translating discrete digital binary numbers back into continuous analog voltages or currents. 

>[!example] Digital Audio Processing Chain
>1. **Input:** An analog human voice is digitized via an ADC.
>2. **Processing:** The microcontroller or Digital Signal Processor (DSP) filters, modifies, or stores the discrete digital audio data.
>3. **Output:** A DAC converts the processed binary values back into a continuous analog voltage waveform to drive an audio speaker.

---

### The Summation Method

The most common architecture used to implement a DAC is the **binary-weighted summation method**, which converts binary bits into an analog equivalent through a three-step sequence:

1. **Logic Level Conditioning:** Each bit of the digital word (from the Most Significant Bit down to the Least Significant Bit) is evaluated to establish clean electrical voltage levels (typically $+5\text{ V}$ for logic `1` and $0\text{ V}$ for logic `0`).
2. **Binary Weighting (Scaling):** The voltage representing each bit is scaled by a multiplier proportional to its binary significance ($2^{-1}, 2^{-2}, 2^{-3}, \dots, 2^{-n}$).
3. **Summation:** The weighted voltages are summed together (typically using an operational amplifier summing configuration) to produce a composite analog output voltage.

---

### Post-Conversion Signal Conditioning

The raw output of a DAC forms a discrete, stepped approximation of the continuous waveform. Producing a clean, usable output typically requires two additional conditioning stages:

- **Reconstruction / Smoothing Filter:** An analog low-pass filter removes the high-frequency switching noise and discrete step transitions (quantization steps), restoring a smooth continuous waveform.
- **Output Transducer Interface:** Additional scaling and buffering circuitry adjusts the smoothed analog voltage and current to match the operational requirements of the output transducer (such as an actuator, motor driver, or audio amplifier).

![[Pasted image 20260920204342.png]]
Figure 3.12: One-bit ADC threshold detector.

![[Pasted image 20260920204351.png]]
Figure 3.13: A summation method to convert a digital signal into a quantized analog signal. Comparators are used to clean up incoming signals and the resulting values are multiplied by a scalar multiplier and the results are added to generate the output signal. For the final analog signal, the quantized analog signal should be connected to a low-pass filter followed by a transducer interface circuit.
### DAC WITH THE ARDUINO DEVELOPMENT ENVIRONMENT

While microcontrollers like the `ATmega328` do not feature a dedicated, on-chip hardware DAC peripheral, the Arduino Development Environment (`ADE`) approximates an analog DC output voltage ($0\text{ to }5\text{ VDC}$) using **Pulse-Width Modulation (PWM)** techniques via the `analogWrite()` function.

When the high-frequency pulsed output from a PWM pin is passed through an external analog low-pass filter, the high-frequency switching harmonics are smoothed out, leaving a stable DC voltage proportional to the duty cycle.

---

### Syntax and Parameters

```c
analogWrite(output_pin, value);
```

- **`output_pin`:** The specific PWM-capable digital output pin used to generate the waveform.
- **`value`:** An 8-bit integer duty cycle parameter ranging from $0\text{ to }255$:
  - `0` produces a continuous $0\text{ VDC}$ ($0\%$ duty cycle).
  - `255` produces a continuous $+5\text{ VDC}$ ($100\%$ duty cycle).
  - Intermediate values generate a PWM waveform whose average filtered output scales linearly:
    $$V_{\text{out}} = 5\text{ V} \times \left( \frac{\text{value}}{255} \right)$$
### DAC WITH EXTERNAL CONVERTERS

When high-precision, multi-channel, or true analog voltage outputs are required beyond what PWM filtering can deliver, a microcontroller can be interfaced to dedicated external Digital-to-Analog Converter (DAC) integrated circuits.

---

### External DAC Configurations and Interfaces

External DACs are available in various channel densities, resolutions, and communication bus architectures:

- **Parallel Bus Interface:** Offers high-speed data throughput by transferring complete digital words simultaneously across dedicated I/O port pins:
  - *Single-Channel, 8-Bit DACs:* e.g., `Motorola MC1408P8`, `Texas Instruments DAC0808`
  - *Quad-Channel (4-channel), 8-Bit DACs:* e.g., `Analog Devices AD7305`
- **Serial Peripheral Interface (SPI):** Reduces required microcontroller pin count by transmitting data serially over a synchronous bus:
  - *Quad-Channel (4-channel), 8-Bit DACs:* e.g., `Analog Devices AD7304`
  - *Octal-Channel (8-channel), 8-Bit DACs:* e.g., `Texas Instruments TLC5628`

---

>[!example] External DAC Applications
>- **Biomedical Signal Generation:** An external 8-bit DAC (such as the `DAC0808`) combined with operational amplifier buffer and scaling stages is used to generate precision analog waveforms (e.g., linear ramp signals) for biomedical test instrumentation.
>- **Industrial Automation:** External DACs are used in industrial control systems to emulate encoder signals, drive analog process actuators, and interface with variable-voltage machinery.
## SUMMARY

>[!summary] Chapter Synthesis
>Interfacing digital microcontrollers with the physical world requires bidirectional translation between continuous analog phenomena and discrete binary data:
>
>- **Analog-to-Digital Conversion (ADC):** Translates continuous signals into digital words through three sequential stages:
>  1. **Sampling:** Discretizing the signal in time at or above the Nyquist rate ($f_s \ge 2 f_{\text{max}}$) with anti-aliasing filtering.
>  2. **Quantization:** Discretizing the continuous amplitude across $2^b$ discrete levels.
>  3. **Encoding:** Mapping quantized voltage levels to binary words.
>- **Conversion Metrics:** System performance is evaluated using **resolution** (step size per LSB), **quantization error**, **dynamic range** ($\text{SNR} \approx 6.02 \cdot b\text{ dB}$), and required **data rate**.
>- **Signal Conditioning:** Linear **Transducer Interface Design (TID)** circuits implement operational amplifier networks to scale ($K$) and bias ($B$) sensor signals to fit the ADC's active input voltage range ($0\text{ to }V_{CC}$).
>- **`ATmega328` ADC Subsystem:** An integrated 10-bit **successive-approximation** ADC capable of 13-clock conversions across 6 multiplexed channels, managed via core registers:
>  - `ADMUX`: Reference voltage selection, left/right data justification (`ADLAR`), and channel routing (`MUX[3:0]`).
>  - `ADCSRA`: Master enable (`ADEN`), start conversion (`ADSC`), interrupt flag (`ADIF`), and prescaler selection (`ADPS[2:0]`).
>  - `ADCH` / `ADCL`: 16-bit register pair storing the 10-bit conversion result.
>- **Software Control:** Conversions can be executed using high-level environment functions (`analogRead()`) or direct register-level manipulation in `C`.
>- **Digital-to-Analog Conversion (DAC):** Converts binary representations back to continuous signals using binary-weighted summation:
>  - Microcontrollers can approximate continuous analog voltages using low-pass filtered **Pulse-Width Modulation (PWM)** via `analogWrite()`.
>  - High-precision, high-speed applications interface with external parallel or SPI-based DAC ICs.

- - -
# Interrupt Subsystem

#### Core Objectives
- **Interrupt Fundamentals:** Understand the operational necessity of an interrupt subsystem in microcontroller applications.
- **Interrupt Response Procedure:** Describe the universal sequence of events executed by a microcontroller when servicing an interrupt request.
- **`ATmega328` Interrupt Architecture:** Identify and describe the integrated interrupt features, vectors, and capabilities of the `ATmega328`.
- **Low-Level Configuration in C:** Properly configure, enable, and program interrupt service routines for the `ATmega328` using direct register manipulation in `C`.
- **Firmware Implementation in ADE:** Configure and attach interrupt events using built-in functions in the Arduino Development Environment (`ADE`) for the `Arduino UNO R3`.
- **Real-Time Applications:** Utilize hardware timer interrupts to implement a functional real-time clock (RTC).
- **System Integration:** Employ interrupt-driven design principles to manage external events and peripheral devices within complete embedded systems.
## OVERVIEW

Under normal operating conditions, a microcontroller executes instructions in a continuous, deterministic _fetch-decode-execute_ sequence governed by the main user program. However, embedded systems must also respond to unscheduled, asynchronous, high-priority events originating from either internal peripherals (such as timers or ADC modules) or external hardware pins. 

To process these events without continuous polling, the microcontroller utilizes an **interrupt subsystem**.

---

### Core Concepts of Interrupt Handling

- **Interrupt:** A hardware or software signal that alerts the CPU to a high-priority condition requiring immediate attention, temporarily suspending normal program execution.
- **Interrupt Service Routine (ISR):** A dedicated callback function designed to execute specific tasks that resolve the triggering interrupt event. In standard architectures, each unique interrupt source maps to its own distinct ISR.

### General Execution Flow

When an interrupt condition occurs:

1. **Current Instruction Completion:** The processor finishes executing its active machine instruction.
2. **Context Transition:** The CPU saves its return address (and system state), halting the main program flow, and branches execution to the designated ISR.
3. **ISR Execution:** The processor executes the code within the ISR to service the event.
4. **Program Resumption:** Once the ISR concludes, program control returns to the saved address, allowing the microcontroller to resume normal execution exactly where it was interrupted.

![[Pasted image 20260920204622.png]]
Figure 6.1: Microcontroller Interrupt Response.
### ATMEGA328 INTERRUPT SYSTEM

The `ATmega328` microcontroller incorporates a comprehensive interrupt system with **26 distinct interrupt sources**:

- **2 External Interrupt Sources:** Hardware interrupt pins driven by external signals:
  - `INT0` (Pin 4)
  - `INT1` (Pin 5)
- **24 Internal Interrupt Sources:** Peripheral subsystem interrupts generated by on-chip hardware (such as Timers, ADC, and serial communication modules) to ensure efficient microcontroller operation without polling.

---

### Interrupt Priority Hierarchy

Interrupt requests are structured in a fixed descending priority sequence:

1. **`RESET`:** Holds the absolute highest priority.
2. **`INT0`:** External Interrupt Request 0 (highest external priority).
3. **`INT1`:** External Interrupt Request 1.
4. **Internal Peripheral Interrupts:** Priority descends through the remaining internal subsystem interrupt vectors.

>[!info]
>When multiple interrupt flags are triggered simultaneously, the microcontroller arbitrates execution based on this fixed hardware priority ranking, servicing the highest-priority vector first.
### GENERAL INTERRUPT RESPONSE
## GENERAL INTERRUPT RESPONSE

When an interrupt condition occurs during program execution, the microcontroller hardware executes a standardized, four-step response sequence:

```
[Main Program Execution]
         │
         ▼  (Interrupt Triggered)
1. Complete Current Instruction
         │
         ▼
2. Push Next PC to Stack & Clear Global Interrupt Enable (I-bit)
         │
         ▼
3. Load ISR Address into PC ──► [Execute Interrupt Service Routine (ISR)]
                                                 │
                                                 ▼
                                     Encounter `reti` Instruction
                                                 │
                                                 ▼
4. Pop PC from Stack & Re-enable Interrupts ──► [Resume Main Program]
```

---

### Execution Steps

1. **Instruction Completion:** The CPU finishes executing the active instruction currently in the execution pipeline.
2. **Context Preservation & Masking:** 
   - The memory address of the next sequential instruction (the current Program Counter value) is pushed onto the **stack**.
   - The CPU automatically clears the global interrupt flag to disable nested interrupts, preventing another interrupt from interrupting the active handler.
3. **Branch to ISR:** The starting address of the designated Interrupt Service Routine (ISR)—mapped via the interrupt vector table—is loaded into the Program Counter (`PC`), and execution of the handler routine commences.
4. **Return from Interrupt:** The ISR executes until it reaches the return from interrupt instruction (`reti`). Upon encountering `reti`:
   - The CPU restores the return address from the stack back into the Program Counter.
   - Global interrupts are automatically re-enabled.
   - Program control seamlessly resumes in the main program where it left off.

![[Pasted image 20260920204758.png]]
Figure 6.2: Microchip AVR ATmega328 Interrupts. (Adapted from figure used with permission of Microchip, Inc.)
## INTERRUPT PROGRAMMING OVERVIEW

To configure and execute an interrupt on the `ATmega328`, the programmer must complete four mandatory configuration steps:

1. **Link the ISR to its Interrupt Vector:** Bind the user-defined Interrupt Service Routine (ISR) to the specific hardware interrupt vector address pointing to the start of the routine.
2. **Configure Peripheral Control Registers:** Set the operational mode and trigger conditions (e.g., edge-triggering, level-triggering, or timer compare modes) in the registers associated with that specific interrupt source.
3. **Locally Enable the Specific Interrupt:** Set the individual local interrupt enable bit within the peripheral’s corresponding control or mask register.
4. **Globally Enable Interrupts:** Enable the master interrupt flag in the CPU Status Register (`SREG`). In assembly language, this is accomplished using the `SEI` instruction; in `C` environments, it is typically handled via macros like `sei()`.

>[!important] Enable Hierarchy
>For any interrupt to execute, **both** its local interrupt mask bit and the global interrupt enable flag (`I`-bit in `SREG`) must be set to logic `1`. If either is disabled, the interrupt request is blocked or queued as a pending flag.
## PROGRAMMING ATMEGA328 INTERRUPTS IN C AND THE ARDUINO DEVELOPMENT ENVIRONMENT

Interrupt handling on the `ATmega328` encompasses two primary operational categories:
- **External Interrupt Events:** Triggered by hardware state changes on external pins.
- **Internal Interrupt Events:** Generated automatically by integrated microcontroller peripherals (such as timers or conversion modules).

---

### Supported Environments and Toolchains

Interrupt-driven applications can be implemented across different programming paradigms and toolchains:

1. **Low-Level Direct Register Control (`C`):**
   - **Microchip AVR / Atmel Studio (`avr-gcc`):** Standard open-source `C` compiler toolchain utilizing native interrupt vector macros (`ISR()`).
   - **ImageCraft JumpStart `C` for AVR:** Commercial embedded `C` compiler utilizing specialized pragmas or vector handlers.
2. **High-Level Abstraction (`ADE`):**
   - The Arduino Development Environment provides simplified built-in functions (such as `attachInterrupt()`) that abstract low-level register configuration and vector table management.
### MICROCHIP AVR VISUAL STUDIO GCC COMPILER INTERRUPT TEMPLATE

The Microchip AVR Visual Studio GCC (`avr-gcc`) compiler utilizes a standardized macro-based naming convention to bind an Interrupt Service Routine (ISR) directly to its corresponding hardware interrupt vector address in the vector table.

---

### Implementation Requirements

1. **Header Inclusion:**
   - `<avr/io.h>`: Provides register definitions and port mappings for the `ATmega328`.
   - `<avr/interrupt.h>`: Provides the core interrupt handling macros, function declarations, and standardized vector definitions.
2. **ISR Syntax:**
   - The ISR function definition uses the `ISR()` macro passing the standardized hardware `vector_identifier` (e.g., `INT0_vect`, `TIMER1_COMPA_vect`) as its parameter.
   - The body of the `ISR()` macro contains the user-defined, time-critical code executed when the interrupt is triggered.

---

### Standard Code Template

```c
//****************************************************************
// Microchip Register and Interrupt Definitions for ATmega328
//****************************************************************
#include <avr/io.h>
#include <avr/interrupt.h>

//****************************************************************
// Interrupt Service Routine Definition
//****************************************************************
ISR(vector_identifier)
{
    // Programmer-written, interrupt-specific actions
}
//****************************************************************
```
### IMAGECRAFT JUMPSTART C FOR AVR COMPILER INTERRUPT TEMPLATE

The ImageCraft JumpStart `C` for AVR compiler links an Interrupt Service Routine (ISR) to its hardware vector address using numeric vector indexing paired with a dedicated preprocessor `#pragma` directive.

---

### Implementation Requirements

1. **Header Inclusion:**
   - `<iom328pv.h>`: Provides the core register definitions and hardware address mappings for the `ATmega328`.
2. **Pragma Directive (`#pragma interrupt_handler`):**
   - Informs the compiler that the subsequent function is an ISR.
   - Requires the target handler function name followed by a colon and the specific hardware interrupt vector number (e.g., `#pragma interrupt_handler timer_handler:17`).
3. **Identifier Matching & Code Generation:**
   - The handler name declared in the `#pragma` directive must match the name of the function definition exactly.
   - Because the compiler identifies the function as an interrupt service routine, it automatically appends the assembly `reti` (Return from Interrupt) instruction at the end of the compiled routine rather than a standard function return (`ret`).

---

### Standard Code Template

```c
//****************************************************************
// ImageCraft JumpStart C for AVR Compiler Interrupt Configuration
//****************************************************************

// Include file containing ATmega328 register definitions
#include <iom328pv.h>

// Declare the interrupt handler routine and map it to vector number 17
#pragma interrupt_handler timer_handler:17

void timer_handler(void)
{
    // Programmer-written, interrupt-specific actions
}
//****************************************************************
```
### EXTERNAL INTERRUPT PROGRAMMING-ATMEGA328

The `ATmega328` microcontroller provides two dedicated hardware external interrupt pins:
- **`INT0` (Pin 4):** External Interrupt Request 0
- **`INT1` (Pin 5):** External Interrupt Request 1

These external interrupts detect electrical signal transitions on their respective physical pins and immediately signal the CPU to execute the corresponding Interrupt Service Routine.

---

### Triggering Modes

Each external interrupt pin can be independently configured to trigger on one of several electrical conditions:

- **Low-Level Trigger:** Generates an interrupt continuously as long as the pin is held at a logic low ($0\text{ V}$) level.
- **Logical Change Trigger:** Triggers on any voltage transition (both rising and falling edges).
- **Falling-Edge Trigger:** Triggers specifically on a high-to-low signal transition.
- **Rising-Edge Trigger:** Triggers specifically on a low-to-high signal transition.

>[!info]
>External interrupt trigger modes are selected by configuring the Interrupt Sense Control (`ISC`) bits within the microcontroller's External Interrupt Control Register, allowing the system to interface with various digital sensors, mechanical switches, and external timing signals.
#### Programming External Interrupts in C-ImageCraft
#### Programming External Interrupts in C-ImageCraft

Configuring external interrupt `INT0` using the ImageCraft JumpStart `C` compiler requires mapping the ISR to vector 2, configuring the pin direction and trigger sense control, enabling the local interrupt mask, and setting the global interrupt flag.

---

### Hardware Configuration Registers

- **Pin Direction (`DDRD` & `PORTD`):** 
  - `INT0` is physically mapped to pin `PD2`. 
  - Bit 2 of `DDRD` is cleared (`0`) to configure `PD2` as an input.
  - Bit 2 of `PORTD` is cleared (`0`) to disable the internal pull-up resistor on the pin.
- **External Interrupt Mask Register (`EIMSK`):** Bit 0 is set to `1` (`0x01`) to locally enable external interrupt request `INT0`.
- **External Interrupt Control Register A (`EICRA`):** Configured with `0x03` (`ISC01 = 1`, `ISC00 = 1`) to set the trigger sensing condition to a **positive-edge (rising-edge)** transition.
- **Global Interrupt Enable:** Executing the inline assembly instruction `SEI` enables the global interrupt mask bit in the Status Register (`SREG`).

---

### Interrupt Flag Reset Mechanics

>[!info]
>The `INT0` interrupt flag sets when the programmed edge occurs. The flag is cleared in one of two ways:
>1. **Automatic Clearing:** The hardware automatically resets the flag when the CPU branches to execute the corresponding interrupt service routine (`int0_ISR`).
>2. **Manual Clearing:** Software can clear the flag by writing a logic `1` directly to the `INTF0` bit in the External Interrupt Flag Register (`EIFR`).

---

### Implementation Code

```c
//****************************************************************
// ImageCraft Interrupt Handler Definition: INT0 mapped to vector 2
#pragma interrupt_handler int0_ISR:2

// Function Prototypes
void int0_ISR(void);
void initialize_interrupt_int0(void);

//****************************************************************
// initialize_interrupt_int0: Configures INT0 for a rising-edge trigger.
// Note: Stack pointer initialization is handled automatically by the compiler.
//****************************************************************
void initialize_interrupt_int0(void)
{
    DDRD = 0xFB;         // Configure PD2 (INT0) as an input (bit 2 = 0)
    PORTD &= ~0x04;      // Disable internal pull-up resistor on PD2
    
    EIMSK = 0x01;        // Enable external interrupt INT0
    EICRA = 0x03;        // Set trigger sense to positive (rising) edge
    
    asm("SEI");          // Set Global Interrupt Enable flag
}

//****************************************************************
// int0_ISR: Interrupt Service Routine for INT0
// Executed immediately upon detecting a rising edge on PD2
//****************************************************************
void int0_ISR(void)
{
    // Insert time-critical interrupt actions here
}
//****************************************************************
```

![[Pasted image 20260920205110.png]]
Figure 6.3: ATmega328 Interrupt INT0 and INT1 Registers.
#### Programming External Interrupts Using the Arduino Development Environment Built-in Features-Atmega328

The Arduino Development Environment (`ADE`) provides four primary built-in functions to control and configure external interrupts without requiring direct register configuration:

- **`interrupts()`:** Globally enables interrupts (equivalent to the assembly `SEI` instruction).
- **`noInterrupts()`:** Globally disables interrupts (equivalent to the assembly `CLI` instruction).
- **`attachInterrupt(interrupt, function, mode)`:** Configures trigger conditions and binds an external interrupt pin to a specific user-defined Interrupt Service Routine (ISR).
- **`detachInterrupt(interrupt)`:** Disables and detaches the specified external interrupt source.

---

### Hardware Pin Mapping on the Arduino UNO R3

On the `Arduino UNO R3`, the two hardware external interrupt channels are routed to specific digital I/O pins:
- **`INT0` (Interrupt 0):** Digital Pin `2`
- **`INT1` (Interrupt 1):** Digital Pin `3`

---

### `attachInterrupt()` Parameter Configuration

The `attachInterrupt()` function takes three required arguments:

1. **`interrupt`:** Specifies the target external interrupt channel (`0` for pin 2, or `1` for pin 3).
2. **`function`:** The name of the user-defined ISR function to be called when the interrupt condition occurs.
3. **`mode`:** Defines the electrical trigger event on the pin:
   - `LOW`: Triggers continuously whenever the pin is held at a low voltage level ($0\text{ V}$).
   - `CHANGE`: Triggers on any voltage transition (both rising and falling edges).
   - `RISING`: Triggers specifically on a low-to-high voltage transition.
   - `FALLING`: Triggers specifically on a high-to-low voltage transition.

---

### Code Example

The following sketch configures `INT0` (Digital Pin 2) to trigger an ISR on a rising edge:

```c
//****************************************************************
void setup()
{
    // Attach INT0 (pin 2) to the int0_ISR callback, triggered by a RISING edge
    attachInterrupt(0, int0_ISR, RISING);
}

void loop()
{
    // Main execution loop: processor remains available while awaiting interrupts
}

//****************************************************************
// int0_ISR: Interrupt Service Routine for INT0
//****************************************************************
void int0_ISR(void)
{
    // Insert time-critical, interrupt-specific actions here
}
//****************************************************************
```
### ATMEGA328 INTERNAL INTERRUPT PROGRAMMING

Internal interrupts are generated automatically by the `ATmega328`'s on-chip peripheral modules (such as timers, the ADC, and serial interfaces) rather than external pins. An internal timer module—such as **`Timer/Counter0`**—provides a standard mechanism for generating deterministic timing intervals and periodic background events.

---

### Timer/Counter0 Overflow Operation

- **8-Bit Resolution:** `Timer/Counter0` is an 8-bit hardware counter that increments from $0$ up to $255$ ($2^8 = 256$ total counts) based on clock pulses derived from the prescaled system clock.
- **Overflow Event (`TOV0`):** When the counter register transitions from its maximum value ($255$) back to $0$, it triggers a **Timer Overflow** flag.
- **Timer Overflow Interrupt:** When enabled, this overflow event immediately vectors the CPU to a dedicated Timer Overflow ISR.

>[!info] Applications of Timer Overflow Interrupts
>- **Deterministic Software Delays:** Creating precise, non-blocking time delays without burning CPU cycles in software `NOP` loops.
>- **Real-Time Clocks (RTC):** Accumulating overflow counts to track elapsed real time (seconds, minutes, and hours).
>- **Periodic Sampling:** Triggering sensor reads, communication polling, or display refreshes at fixed, repeatable intervals.
#### Programming an Internal Interrupt in C-Atmega328-ImageCraft

Internal hardware timers can generate deterministic, periodic interrupts to implement precise software timing routines. In this implementation, `Timer/Counter0` overflow interrupts are used to create calibrated time delays.

---

### Timing Calculations and Parameters

The timing base is derived by scaling an external clock source through the timer's internal prescaler:

1. **Oscillator Frequency ($f_{\text{osc}}$):** An external ceramic resonator operates at $10\text{ MHz}$.
2. **Prescaler Division Factor ($N$):** Setting the clock select bits `CS[2:0] = 0b100` (`0x04`) in `TCCR0B` divides the system clock by $256$.

>[!summary] theorem : Timer Overflow Interval
>$$\begin{cases}
>T_{\text{tick}} = \dfrac{N}{f_{\text{osc}}} \\
>T_{\text{overflow}} = 256 \times T_{\text{tick}}
>\end{cases}$$
>
>**breakdown**:
>- $f_{\text{osc}}$ : Main microcontroller oscillator frequency ($10\text{ MHz}$).
>- $N$ : Clock prescaler division factor ($N = 256$).
>- $T_{\text{tick}}$ : Duration of a single timer counter increment:
>  $$T_{\text{tick}} = \frac{256}{10\text{ MHz}} = 25.6\ \mu\text{s}$$
>- $T_{\text{overflow}}$ : Time elapsed for the 8-bit register ($2^8 = 256$ counts) to overflow:
>  $$T_{\text{overflow}} = 256 \times 25.6\ \mu\text{s} \approx 6.55\text{ ms}$$

>[!example] 1-Second Delay Calculation
>To generate a precise delay of $1.0\text{ second}$ ($1000\text{ ms}$):
>$$\text{Target Interrupts} = \frac{1000\text{ ms}}{6.55\text{ ms/interrupt}} \approx 153\text{ interrupts}$$
>Passing the value `153` to the delay function holds execution for approximately one second.

---

### Hardware Configuration Registers

- **`TCCR0B` (Timer/Counter Control Register B):** Set to `0x04` (`CS02 = 1, CS01 = 0, CS00 = 0`) to set the prescaler division factor to 256.
- **`TIMSK0` (Timer/Counter Interrupt Mask Register 0):** Set to `0x01` (`TOIE0 = 1`) to enable the Timer/Counter0 Overflow Interrupt.
- **`TCNT0` (Timer/Counter Register 0):** Direct 8-bit counter register; reset to `0x00` at the start of a delay sequence.
- **Interrupt Vector Mapping:** The ImageCraft `#pragma interrupt_handler` links vector `17` to the `timer0_interrupt_isr` handler.

>[!note] Automatic Flag Clearing
>The Timer/Counter0 overflow interrupt flag (`TOV0`) is cleared automatically by microcontroller hardware when the CPU vectors to the corresponding ISR.

---

### Source Code

```c
//****************************************************************
// Function Prototypes
void delay(unsigned int number_of_6_55ms_interrupts); // Delay in multiples of 6.55 ms
void init_timer0_ovf_interrupt(void);                 // Initialize Timer0 overflow

// ImageCraft Interrupt Handler Definition: Timer0 Overflow mapped to vector 17
#pragma interrupt_handler timer0_interrupt_isr:17

// Global Variables
unsigned int input_delay; // Tracks accumulated Timer/Counter0 overflow interrupts

//****************************************************************
// Main Program
//****************************************************************
void main(void)
{
    init_timer0_ovf_interrupt(); // Initialize Timer0 overflow interrupt (call once)
    
    // Application loop or tasks
    delay(153); // Execute a 1-second delay (153 * 6.55 ms = ~1002 ms)
}

//****************************************************************
// init_timer0_ovf_interrupt: Configures Timer0 prescaler to 256
// and enables the overflow interrupt.
//****************************************************************
void init_timer0_ovf_interrupt(void)
{
    TCCR0B = 0x04; // Divide timer clock by 256 (overflow every 6.55 ms at 10 MHz)
    TIMSK0 = 0x01; // Enable Timer0 Overflow Interrupt
    asm("SEI");    // Enable global interrupts
}

//****************************************************************
// timer0_interrupt_isr: ISR executed every 6.55 ms
//****************************************************************
void timer0_interrupt_isr(void)
{
    input_delay++; // Increment overflow counter
}

//****************************************************************
// delay: Generates calibrated delays using Timer0 overflow ticks.
// Note: Valid for a 10 MHz system clock. If a different clock frequency
// is used, the tick duration must be recalculated.
//****************************************************************
void delay(unsigned int number_of_6_55ms_interrupts)
{
    TCNT0 = 0x00;        // Reset Timer0 hardware counter register
    input_delay = 0;     // Reset software overflow counter
    
    while (input_delay <= number_of_6_55ms_interrupts)
    {
        // Wait until target number of interrupts have occurred
    }
}
//****************************************************************
```
#### Programming an Internal Interrupt Using the Arduino Development Environment-Arduino UNO R3

The Arduino Development Environment (`ADE`) employs the GNU toolchain and `AVR Libc` library to compile programs. Internal interrupt routines implemented in the ADE adhere to standard `avr-gcc` conventions, utilizing predefined interrupt vector names (such as `TIMER0_OVF_vect`) within the `ISR()` macro.

---

### Hardware Timing Adaptation for 16 MHz

The `Arduino UNO R3` is clocked with a $16\text{ MHz}$ quartz crystal oscillator. When configuring hardware timers, timing constants must be recalculated to account for the faster system clock:

1. **Oscillator Frequency ($f_{\text{osc}}$):** $16\text{ MHz}$
2. **Prescaler Division Factor ($N$):** Setting `CS[2:0] = 0b100` (`0x04`) in `TCCR0B` divides the system clock by $256$.

>[!summary] theorem : Timer0 Timing at 16 MHz
>$$\begin{cases}
>T_{\text{tick}} = \dfrac{N}{f_{\text{osc}}} = \dfrac{256}{16\text{ MHz}} = 16\ \mu\text{s} \\
>T_{\text{overflow}} = 256 \times T_{\text{tick}} = 256 \times 16\ \mu\text{s} = 4.096\text{ ms} \approx 4.1\text{ ms}
>\end{cases}$$
>
>**breakdown**:
>- $f_{\text{osc}}$ : Main microcontroller oscillator frequency ($16\text{ MHz}$).
>- $N$ : Clock prescaler division factor ($256$).
>- $T_{\text{tick}}$ : Duration of a single timer counter step ($16\ \mu\text{s}$).
>- $T_{\text{overflow}}$ : Time elapsed for the 8-bit counter ($256$ counts) to reach overflow ($\approx 4.1\text{ ms}$).

>[!example] 1-Second Delay Calculation at 16 MHz
>To achieve an approximate $1.0\text{ second}$ ($1000\text{ ms}$) delay:
>$$\text{Target Interrupts} = \frac{1000\text{ ms}}{4.096\text{ ms/interrupt}} \approx 244.14 \approx 244\text{ interrupts}$$
>Calling the delay function with a parameter value of `244` delays program execution for approximately one second.

---

### Arduino Code Implementation

```c
//****************************************************************
#include <avr/interrupt.h>

// Global variable to track Timer/Counter0 overflow interrupts
unsigned int input_delay;

void setup()
{
    init_timer0_ovf_interrupt(); // Initialize Timer0 overflow interrupt
}

void loop()
{
    // Application code execution
    delay_timer0(244);           // 1-second calibrated delay (244 * 4.1 ms)
}

//****************************************************************
// ISR(TIMER0_OVF_vect): Standard avr-gcc macro for Timer0 overflow.
// Increments the software counter on every 4.1 ms interrupt event.
//****************************************************************
ISR(TIMER0_OVF_vect)
{
    input_delay++; // Increment overflow counter
}

//****************************************************************
// init_timer0_ovf_interrupt: Configures Timer0 prescaler to 256
// and enables the overflow interrupt mask.
//****************************************************************
void init_timer0_ovf_interrupt(void)
{
    TCCR0B = 0x04; // Set prescaler to divide clock by 256 (overflow every 4.1 ms at 16 MHz)
    TIMSK0 = 0x01; // Enable Timer0 Overflow Interrupt (TOIE0)
    asm("SEI");    // Set Global Interrupt Enable flag
}

//****************************************************************
// delay_timer0: Generates a calibrated delay using 4.1 ms Timer0 ticks.
// Note: Valid specifically for a 16 MHz crystal oscillator.
//****************************************************************
void delay_timer0(unsigned int number_of_4_1ms_interrupts)
{
    TCNT0 = 0x00;        // Reset Timer0 hardware counter register
    input_delay = 0;     // Reset software interrupt counter
    
    while (input_delay <= number_of_4_1ms_interrupts)
    {
        // Wait until the required number of overflow interrupts occur
    }
}
//****************************************************************
```
## FOREGROUND AND BACKGROUND PROCESSING

Because a single-core microcontroller can only execute one instruction at a time through its fetch-decode-execute cycle, it achieves the appearance of simultaneous multitasking by partitioning execution into **foreground** and **background** processing:

- **Foreground Processing:** The normal, continuous baseline loop of the main application program. It handles standard scheduled tasks such as managing user interfaces, processing standard control algorithms, and routine polling.
- **Background Processing:** Time-critical, asynchronous tasks managed by the interrupt subsystem. When an interrupt condition occurs, the CPU temporarily suspends the foreground thread, "steals" clock cycles to execute the Interrupt Service Routine (ISR), and then seamlessly returns processor control back to the foreground process.

>[!example] Electronic Access Door Control
>An automated electronic security door illustrates this execution model:
>- **Foreground Tasks:** Processing routine keypad/card inputs from users and generating standard Pulse-Width Modulation (PWM) signals to drive the motor during normal opening and closing cycles.
>- **Background Tasks:** Monitoring safety-critical sensors (such as optical pinch-guards, motor stall currents, and obstruction limit switches) via hardware interrupts to immediately halt door movement if a hazard is detected.

---

### Foreground/Background Demonstration

This implementation demonstrates execution flow visually:
- **Foreground Indicator:** A green LED on pin 12 remains illuminated during standard loop processing.
- **Background Indicator:** A red LED on pin 11 flashes multiple times when an external interrupt event occurs.
- **Trigger:** A pushbutton switch connected to `INT0` (Digital Pin 2) triggers a falling-edge interrupt, shifting CPU execution immediately into the `background()` ISR.

![[Pasted image 20260920205420.png]]
Figure 6.4: Interrupt used for background processing. The microcontroller responds to user input status in the foreground while monitoring safety related status in the background using interrupts.

![[Pasted image 20260920205430.png]]
Figure 6.5: Foreground background processing. (UNO R3 illustration used with permission of the Arduino Team (CC BY-NC-SA) [www.arduino.cc].)

```c
//*****************************************************************
#define green_LED 12    // Digital output pin for foreground indicator
#define red_LED   11    // Digital output pin for background indicator
#define ext_sw    2     // External interrupt pin INT0

int switch_value;

void setup()
{
    pinMode(green_LED, OUTPUT);
    pinMode(red_LED, OUTPUT);
    pinMode(ext_sw, INPUT);

    // Attach INT0 (pin 2) to trigger background ISR on falling edge
    attachInterrupt(0, background, FALLING);
}

void loop()
{
    // Foreground Processing: Keep green LED on, red LED off
    digitalWrite(green_LED, HIGH);
    digitalWrite(red_LED, LOW);
}

//*****************************************************************
// background: Interrupt Service Routine executed upon switch press
//*****************************************************************
void background(void)
{
    unsigned int i;

    // Transition state: indicate background entry
    digitalWrite(green_LED, LOW);

    // Flash Red LED Sequence
    digitalWrite(red_LED, HIGH);
    for (i = 0; i <= 64000; i++)
    {
        asm("nop");
    }

    digitalWrite(red_LED, LOW);
    for (i = 0; i <= 64000; i++)
    {
        asm("nop");
    }

    digitalWrite(red_LED, HIGH);
    for (i = 0; i <= 64000; i++)
    {
        asm("nop");
    }

    digitalWrite(red_LED, LOW);
    for (i = 0; i <= 64000; i++)
    {
        asm("nop");
    }

    digitalWrite(red_LED, HIGH);
}
//*****************************************************************
```
## INTERRUPT EXAMPLES

This section demonstrates practical applications of both internal (peripheral-generated) and external (pin-driven) interrupts across various embedded systems implementations.
### EXAMPLE: REAL TIME CLOCK IN C

A microcontroller tracks elapsed time relative to its internal clock ticks. To convert these discrete hardware cycles into human-readable real time (seconds, minutes, hours, and days), a periodic timer interrupt serves as the fundamental "time tick" for a software-based **Real-Time Clock (RTC)**.

---

### Timing Base and Cascading Architecture

In this system, `Timer/Counter0` generates an overflow interrupt every $6.55\text{ ms}$ (derived from a $10\text{ MHz}$ oscillator divided by a prescaler of 256).

The Interrupt Service Routine (ISR) tracks time by cascading increments through nested counter thresholds:

1. **Tick / Millisecond Counter (`ms_ctr`):** Increments every $6.55\text{ ms}$. Upon reaching **154** counts ($154 \times 6.5536\text{ ms} \approx 1009\text{ ms} \approx 1\text{ second}$), it resets to $0$ and increments the seconds counter.
2. **Seconds Counter (`sec_ctr`):** Increments up to **60 seconds**, then resets to $0$ and increments the minute counter.
3. **Minutes Counter (`min_ctr`):** Increments up to **60 minutes**, then resets to $0$ and increments the hour counter.
4. **Hours Counter (`hr_ctr`):** Increments up to **24 hours**, then resets to $0$ and increments the day counter.
5. **Days Counter (`day_ctr`):** Accumulates total elapsed calendar days.

>[!info] Long-Duration Timing
>This accumulator-cascade technique allows a simple 8-bit timer to measure extended durations (days, weeks, or months) without requiring specialized external RTC hardware.

---

### Implementation Code (ImageCraft C)

```c
//*****************************************************************
// Function Prototypes
void delay(unsigned int number_of_6_55ms_interrupts);
void init_timer0_ovf_interrupt(void); // Initialize Timer0 overflow interrupt

// ImageCraft Interrupt Handler Definition: Vector 17
#pragma interrupt_handler timer0_interrupt_isr:17

// Global Real-Time Clock Variables
unsigned int day_ctr, hr_ctr, min_ctr, sec_ctr, ms_ctr;

//*****************************************************************
// Main Program
//*****************************************************************
void main(void)
{
    // Initialize RTC counters to zero
    day_ctr = 0;
    hr_ctr  = 0;
    min_ctr = 0;
    sec_ctr = 0;
    ms_ctr  = 0;

    init_timer0_ovf_interrupt(); // Initialize Timer0 overflow interrupt (call once)

    while (1)
    {
        // Background interrupts maintain time; foreground can display or process data
    }
}

//*****************************************************************
// init_timer0_ovf_interrupt: Configures Timer0 prescaler to 256.
// An 8-bit counter with a 10 MHz clock overflows every 6.55 ms.
//*****************************************************************
void init_timer0_ovf_interrupt(void)
{
    TCCR0B = 0x04; // Divide Timer0 timebase by 256 (overflow every 6.55 ms)
    TIMSK0 = 0x01; // Enable Timer0 Overflow Interrupt (TOIE0)
    asm("SEI");    // Enable global interrupts
}

//*****************************************************************
// timer0_interrupt_isr: Cascading real-time clock counter
// Executed every 6.55 ms upon Timer0 overflow
//*****************************************************************
void timer0_interrupt_isr(void)
{
    // 1. Update millisecond / tick counter
    ms_ctr = ms_ctr + 1;

    // 2. Update second counter (~1000 ms threshold reached at 154 ticks)
    if (ms_ctr == 154)
    {
        ms_ctr = 0;
        sec_ctr = sec_ctr + 1;
    }

    // 3. Update minute counter
    if (sec_ctr == 60)
    {
        sec_ctr = 0;
        min_ctr = min_ctr + 1;
    }

    // 4. Update hour counter
    if (min_ctr == 60)
    {
        min_ctr = 0;
        hr_ctr = hr_ctr + 1;
    }

    // 5. Update day counter
    if (hr_ctr == 24)
    {
        hr_ctr = 0;
        day_ctr = day_ctr + 1;
    }
}
//*****************************************************************
```
### EXAMPLE: REAL TIME CLOCK USING THE ARDUINO DEVELOPMENT ENVIRONMENT

This implementation adapts the software-based Real-Time Clock (RTC) for the `Arduino UNO R3` within the Arduino Development Environment (`ADE`), utilizing standard `avr-gcc` interrupt naming conventions.

---

### Timing Adjustments for 16 MHz Operation

Because the Arduino UNO R3 operates with a $16\text{ MHz}$ crystal oscillator (rather than a $10\text{ MHz}$ source), the timer tick duration and threshold parameters are adjusted accordingly:

- **Oscillator Frequency ($f_{\text{osc}}$):** $16\text{ MHz}$
- **Prescaler ($N$):** $256$
- **Timer0 Resolution:** 8 bits ($256$ counts)
- **Overflow Interval:**
  $$T_{\text{overflow}} = \frac{256 \times 256}{16\text{ MHz}} = 4.096\text{ ms} \approx 4.1\text{ ms}$$
- **1-Second Tick Threshold:**
  $$\text{Ticks per Second} = \frac{1000\text{ ms}}{4.096\text{ ms/overflow}} \approx 244.14 \approx 244\text{ counts}$$

The software accumulator checks for **244** overflow interrupts before incrementing the seconds counter.

---

### Arduino Code Implementation

```c
//****************************************************************
#include <avr/interrupt.h>

// Global Real-Time Clock Variables
unsigned int day_ctr, hr_ctr, min_ctr, sec_ctr, ms_ctr;

void setup()
{
    // Initialize RTC counters
    day_ctr = 0;
    hr_ctr  = 0;
    min_ctr = 0;
    sec_ctr = 0;
    ms_ctr  = 0;

    init_timer0_ovf_interrupt(); // Initialize Timer0 overflow interrupt
}

void loop()
{
    // Main application code executes here
    // Background timer interrupts maintain RTC tracking continuously
}

//****************************************************************
// ISR(TIMER0_OVF_vect): Timer0 Overflow Interrupt Service Routine.
// Automatically cleared by hardware upon vector execution.
//****************************************************************
ISR(TIMER0_OVF_vect)
{
    // 1. Update millisecond / tick counter
    ms_ctr = ms_ctr + 1;

    // 2. Update second counter (244 ticks * 4.096 ms ≈ 1000 ms)
    if (ms_ctr == 244)
    {
        ms_ctr = 0;
        sec_ctr = sec_ctr + 1;
    }

    // 3. Update minute counter
    if (sec_ctr == 60)
    {
        sec_ctr = 0;
        min_ctr = min_ctr + 1;
    }

    // 4. Update hour counter
    if (min_ctr == 60)
    {
        min_ctr = 0;
        hr_ctr = hr_ctr + 1;
    }

    // 5. Update day counter
    if (hr_ctr == 24)
    {
        hr_ctr = 0;
        day_ctr = day_ctr + 1;
    }
}

//****************************************************************
// init_timer0_ovf_interrupt: Configures Timer0 prescaler to 256
// and enables the overflow interrupt mask.
//****************************************************************
void init_timer0_ovf_interrupt(void)
{
    TCCR0B = 0x04; // Divide Timer0 timebase by 256 (overflow every 4.1 ms at 16 MHz)
    TIMSK0 = 0x01; // Enable Timer0 Overflow Interrupt (TOIE0)
    asm("SEI");    // Enable global interrupts
}
//****************************************************************
```
### EXAMPLE: INTERRUPT DRIVEN USART IN C

This application demonstrates the evaluation of a $12\text{-bit}$ positional encoder system using two `ATmega328` microcontrollers operating at an internal clock frequency of $8\text{ MHz}$ and communicating serially at $9600\text{ Baud}$.
![[Pasted image 20260920205713.png]]
Figure 6.6: Encoder data format. The position data is sent serially at 9600 Baud as two sequential bytes.

![[Pasted image 20260920205738.png]]
Figure 6.7: Encoder test configuration.

---

### System Architecture & Operational Concept

```
[Transmitter / Encoder Simulator]                     [Interrupt-Driven Receiver]
  ┌─────────────────────────┐                           ┌─────────────────────────┐
  │  PD2: Open Sw (Incr)    │                           │  USART RX Interrupt     │
  │  PD3: Close Sw (Decr)   │                           │  (Vector 19)            │
  │                         │                           │                         │
  │  12-bit Counter (0-4095)│                           │  Reconstruct 12-bit Pos │
  │    │                    │                           │    │                    │
  │    ├─► PORTB ──► DAC0808│                           │    ├─► PORTB ──► DAC0808│
  │    │   (8 MSBs Analog)  │                           │    │   (8 MSBs Analog)  │
  │    │                    │                           │    │                    │
  │    └─► TXD (Pin 3) ─────┼─── 9600 Baud Serial ─────►┼────┴─► EEPROM Storage   │
  └─────────────────────────┘    (2-Byte Framing)       └─────────────────────────┘
```

1. **Transmitter (Encoder Simulator):**
   - Simulates door movement via two active-high, RC-debounced pushbuttons on `PD2` (open/increment) and `PD3` (close/decrement).
   - Tracks positional state using a $12\text{-bit}$ variable ($0\text{ to }4095$).
   - Formats and transmits the $12\text{-bit}$ position as two sequential framing bytes over the USART transmitter.
   - Outputs the 8 Most Significant Bits (MSBs) of the position count to an external 8-bit DAC (`DAC0808`) on `PORTB` to produce an analog reference voltage.

2. **Receiver (Interrupt-Driven Data Processor):**
   - Receives serial bytes asynchronously using the **USART Receive Complete Interrupt** (`USART_RX_vect` / Vector 19).
   - Reconstructs the original $12\text{-bit}$ position value from the tagged multi-byte stream.
   - Saves the updated position state to internal non-volatile EEPROM memory.
   - Drives a second local `DAC0808` on `PORTB` with the received 8 MSBs, allowing direct oscilloscope/multimeter verification against the transmitter DAC.

---

### Communication Protocol and Baud Rate Configuration

- **Baud Rate Configuration ($8\text{ MHz}$ System Clock):**
  $$\text{UBRR} = \frac{f_{\text{osc}}}{16 \times \text{Baud}} - 1 = \frac{8{,}000{,}000}{16 \times 9600} - 1 = 52.08 - 1 \approx 51\ (0\text{x}0033)$$
  - `UBRRH = 0x00`, `UBRRL = 0x33`
- **Framing Protocol:**
  - **Most Significant Byte:** Carries upper data bits tagged with bit $0 = 1$ (`Byte ID = 1`).
  - **Least Significant Byte:** Carries lower data bits tagged with bit $0 = 0$ (`Byte ID = 0`).

---

### Transmitter Code: Encoder Simulator (`encode.c`)

```c
//***************************************************************
// Target Controller: Microchip ATmega328 (Internal 8 MHz Clock)
// File: encode.c
// Pin Assignments:
//   PD0: RXD
//   PD1: TXD
//   PD2: Active-high RC-debounced switch (Open)
//   PD3: Active-high RC-debounced switch (Close)
//   PB[7:0]: Data bus to DAC0808 inputs A8-A1
//***************************************************************

#include <iom328v.h>
#include <macros.h>

// Function Prototypes
void initialize_ports(void);
void USART_init(void);
void USART_TX(unsigned char data);
void read_new_input(void);

// Global Variables
unsigned char old_PORTD = 0x08; // Stores previous PORTD state
unsigned char new_PORTD;        // Stores sampled PORTD state
unsigned int door_position = 0; // 12-bit position value (0 - 4095)

//***************************************************************
// Main Program
//***************************************************************
void main(void)
{
    initialize_ports(); // Initialize digital I/O ports
    USART_init();       // Configure USART to 9600 Baud

    while (1)
    {
        _StackCheck();    // Verify stack integrity
        read_new_input(); // Poll inputs and process movement
    }
}

//***************************************************************
// initialize_ports: Configures DDR and initial port logic levels
//***************************************************************
void initialize_ports(void)
{
    DDRB = 0xFF;  // PORTB[7:0] as outputs (connected to DAC0808)
    PORTB = 0x00; // Initialize low

    DDRC = 0xFF;  // PORTC[7:0] as outputs
    PORTC = 0x00; // Initialize low

    DDRD = 0xF2;  // PORTD[7:4, 1] output, PD[3:2] input, PD0 input
    PORTD = 0x00; // Initialize low
}

//***************************************************************
// read_new_input: Polls switches on PD2/PD3 and processes updates
//***************************************************************
void read_new_input(void)
{
    unsigned char ms_door_position, ls_door_position, DAC_data;

    new_PORTD = (PIND & 0x0C); // Mask all pins except PD3 and PD2

    if (new_PORTD != old_PORTD)
    {
        switch (new_PORTD)
        {
            case 0x04: // Open Switch Depressed (PD2 = High)
                while (PIND == 0x04)
                {
                    // Split 12-bit word into two framed bytes
                    ms_door_position = (unsigned char)(((door_position >> 6) & 0x00FF) | 0x01); // ID bit = 1
                    ls_door_position = (unsigned char)(((door_position << 1) & 0x00FF) & 0xFE); // ID bit = 0

                    // Transmit data via USART
                    USART_TX(ms_door_position);
                    USART_TX(ls_door_position);

                    // Send 8 MSBs to DAC on PORTB
                    DAC_data = (unsigned char)((door_position >> 4) & 0x00FF);
                    PORTB = DAC_data;

                    // Increment position count (max 4095)
                    if (door_position >= 4095)
                    {
                        door_position = 4095;
                    }
                    else
                    {
                        door_position++;
                    }
                }
                break;

            case 0x08: // Close Switch Depressed (PD3 = High)
                while (PIND == 0x08)
                {
                    // Split 12-bit word into two framed bytes
                    ms_door_position = (unsigned char)(((door_position >> 6) & 0x00FF) | 0x01); // ID bit = 1
                    ls_door_position = (unsigned char)(((door_position << 1) & 0x00FF) & 0xFE); // ID bit = 0

                    // Transmit data via USART
                    USART_TX(ms_door_position);
                    USART_TX(ls_door_position);

                    // Send 8 MSBs to DAC on PORTB
                    DAC_data = (unsigned char)((door_position >> 4) & 0x00FF);
                    PORTB = DAC_data;

                    // Decrement position count (min 0)
                    if (door_position <= 0)
                    {
                        door_position = 0;
                    }
                    else
                    {
                        door_position--;
                    }
                }
                break;

            default:
                break;
        }
    }

    old_PORTD = new_PORTD; // Update tracked port status
}

//***************************************************************
// USART_init: Initializes asynchronous USART at 9600 Baud
//***************************************************************
void USART_init(void)
{
    UCSRA = 0x00; // Normal transmission speed
    UCSRB = 0x08; // Enable transmitter (TXEN = 1)
    UCSRC = 0x86; // Asynchronous mode, no parity, 1 stop bit, 8 data bits

    // Set Baud rate divisor for 8 MHz clock (9600 Baud -> UBRR = 51 / 0x0033)
    UBRRH = 0x00;
    UBRRL = 0x33;
}

//***************************************************************
// USART_TX: Transmits a single byte over USART
//***************************************************************
void USART_TX(unsigned char data)
{
    while ((UCSRA & 0x20) == 0x00); // Wait until UDRE (Data Register Empty) flag is set
    UDR = data;                    // Load byte into transmit buffer
}
```

---

### Receiver Code: Interrupt-Driven Receiver (`receive.c`)

```c
//***************************************************************
// Target Controller: Microchip ATmega328 (Internal 8 MHz Clock)
// File: receive.c
// Pin Assignments:
//   PD0: RXD
//   PB[7:0]: Data bus to DAC0808 inputs A8-A1
//***************************************************************

#include <iom328v.h>
#include <macros.h>
#include <eeprom.h> // Non-volatile EEPROM support

#pragma data: eeprom
unsigned int door_position_EEPROM; // Non-volatile storage variable
#pragma data: data

// Function Prototypes
void initialize_ports(void);
void USART_init(void);

// ImageCraft Interrupt Handler Definition: USART RX Complete mapped to Vector 19
#pragma interrupt_handler USART_RX_interrupt_isr:19

// Global Variables
unsigned int door_position = 0;

//***************************************************************
// Main Program
//***************************************************************
void main(void)
{
    initialize_ports(); // Configure I/O ports
    USART_init();       // Configure USART and enable RX complete interrupt

    while (1)
    {
        _StackCheck();  // Continuous background processing loop
    }
}

//***************************************************************
// initialize_ports: Configures PORTB, PORTC, and PORTD
//***************************************************************
void initialize_ports(void)
{
    DDRB = 0xFF;  // PORTB[7:0] output to DAC0808
    PORTB = 0x00; // Initialize low

    DDRC = 0xFF;  // PORTC[7:0] output
    PORTC = 0x00; // Initialize low

    DDRD = 0xFE;  // PD0 as RX input, remaining pins as outputs
    PORTD = 0x00; // Initialize low
}

//***************************************************************
// USART_init: Initializes USART receiver and RX Complete Interrupt
//***************************************************************
void USART_init(void)
{
    UCSRA = 0x00; // Control Register initialization
    UCSRB = 0x90; // Enable Receiver (RXEN = 1) & RX Complete Interrupt (RXCIE = 1)
    UCSRC = 0x86; // Asynchronous, no parity, 1 stop bit, 8 data bits

    // Set Baud rate divisor for 8 MHz clock (9600 Baud)
    UBRRH = 0x00;
    UBRRL = 0x33;

    asm("SEI");   // Enable global interrupts
}

//***************************************************************
// USART_RX_interrupt_isr: Executed when a byte is received
//***************************************************************
void USART_RX_interrupt_isr(void)
{
    unsigned char data_rx, DAC_data;
    unsigned int ls_position, ms_position;

    data_rx = UDR; // Read received byte from hardware buffer

    // Retrieve previous position from EEPROM
    EEPROM_READ((int)&door_position_EEPROM, door_position);

    // Decode byte based on ID bit (Bit 0)
    if ((data_rx & 0x01) == 0x01) // Byte ID = 1 (Most Significant Byte)
    {
        ms_position = data_rx;

        // Update bit 7
        if ((ms_position & 0x0020) == 0x0020)
        {
            door_position = door_position | 0x0080;
        }
        else
        {
            door_position = door_position & 0xFF7F;
        }

        // Shift and mask upper 4 bits
        ms_position = ((ms_position << 6) & 0x0F00);
        door_position = door_position & 0x00FF; // Clear MSB
        door_position = door_position | ms_position;
    }
    else // Byte ID = 0 (Least Significant Byte)
    {
        ls_position = data_rx;
        ls_position = ((ls_position >> 1) & 0x007F);

        // Preserve bit 7
        if ((door_position & 0x0080) == 0x0080)
        {
            ls_position = ls_position | 0x0080;
        }
        else
        {
            ls_position = ls_position & 0xFF7F;
        }

        door_position = door_position & 0xFF00; // Clear LSB
        door_position = door_position | ls_position;
    }

    // Persist updated position to non-volatile EEPROM
    EEPROM_WRITE((int)&door_position_EEPROM, door_position);

    // Output 8 MSBs to DAC on PORTB
    DAC_data = (unsigned char)((door_position >> 4) & 0x00FF);
    PORTB = DAC_data;
}
```
## SUMMARY

>[!summary] Chapter Synthesis
>The interrupt subsystem allows a microcontroller to respond to asynchronous, high-priority events without continuously polling hardware flags:
>
>- **Interrupt Response Flow:** When an interrupt occurs, the CPU finishes the current instruction, pushes the Program Counter onto the stack, temporarily disables global interrupts, and branches to the designated **Interrupt Service Routine (ISR)**. Execution resumes in the main program once the return from interrupt instruction (`reti`) is encountered.
>- **`ATmega328` Interrupt Architecture:** Equipped with **26 distinct interrupt vectors** prioritized by hardware hierarchy:
>  - Reset (highest priority).
>  - External interrupts (`INT0` on Pin 4 / Digital Pin 2, `INT1` on Pin 5 / Digital Pin 3).
>  - 24 internal peripheral interrupts (timers, ADC, USART, EEPROM, etc.).
>- **Configuration Requirements:**
>  1. Link the ISR to the correct vector address.
>  2. Configure peripheral-specific control registers (e.g., edge-trigger sense, prescalers).
>  3. Locally enable the individual interrupt mask bit (e.g., `EIMSK`, `TIMSK0`).
>  4. Globally enable interrupts via the `SEI` assembly instruction or `sei()` / `interrupts()` macros.
>- **Toolchain Variations:**
>  - *Microchip Studio (`avr-gcc`):* Uses the standardized `ISR(vector_name)` macro syntax.
>  - *ImageCraft JumpStart `C`:* Uses `#pragma interrupt_handler handler_name:vector_number`.
>  - *Arduino Environment (`ADE`):* Uses high-level functions (`attachInterrupt()`, `detachInterrupt()`, `interrupts()`, `noInterrupts()`).
>- **Concurrency & Real-Time Applications:**
>  - **Foreground/Background Execution:** The main loop executes routine foreground tasks while asynchronous interrupts steal clock cycles to handle background events.
>  - **Real-Time Clocks (RTC):** Internal timer overflows (such as `Timer/Counter0`) provide deterministic time ticks ($6.55\text{ ms}$ at $10\text{ MHz}$, $4.1\text{ ms}$ at $16\text{ MHz}$) to maintain cascaded millisecond, second, minute, hour, and day counters.
>  - **Interrupt-Driven USART:** Automates byte reception in the background without stalling main program loops.

- - -
## Interrupts and InterruptDriven I/O

Interaction between a processor and an I/O device is primarily governed by one of two control mechanisms:

- **Processor-Controlled (Polling):** The processor repeatedly queries the ready bit of an I/O device's status register in a loop. When the ready bit is asserted (`1`), the processor branches to the instruction that executes the input or output operation. While straightforward, polling consumes considerable CPU processing cycles during waiting intervals.
- **Device-Controlled (Interrupt-Driven):** The I/O device initiates communication directly. Rather than requiring the processor to continuously check device status, the peripheral alerts the processor only when it is ready to transfer data.
### What Is Interrupt-Driven I/O?

The core principle of **interrupt-driven I/O** is the mechanism by which an I/O device—which may have no direct connection to the program currently executing—can independently signal the CPU to service its needs.

This process operates in three distinct phases:

1. **Forced Suspension:** The I/O device forces the actively running program (Program A) to pause execution.
2. **Service Execution:** The processor branches to and executes a specialized routine (Program B / ISR) designed to handle the specific requirements of the I/O device.
3. **Transparent Resumption:** Once the service routine completes, the suspended program (Program A) resumes execution exactly where it was stopped, maintaining complete data and computational integrity.

---

### Comparison of Execution Flows

#### Normal Program Flow (No Interrupt)
In a standard sequential flow, the processor executes instructions continuously without interruption:
- Program A executes instruction $n$
- Program A executes instruction $n+1$
- Program A executes instruction $n+2$
- Program A executes instruction $n+3$
- Program A executes instruction $n+4$

#### Interrupt-Driven Program Flow
When an asynchronous interrupt occurs, execution temporarily branches to service the device before returning:

- Program A executes instruction $n$
- Program A executes instruction $n+1$
- Program A executes instruction $n+2$
- **Stage 1 (Interruption & Context Suspension):**
  - An interrupt signal from the I/O device is detected.
  - Program A is placed into suspended animation (state/context is preserved).
  - The Program Counter (`PC`) is loaded with the starting memory address of Program B.
- **Stage 2 (Servicing the I/O Device):**
  - Program B starts satisfying the I/O device’s needs.
  - Program B continues satisfying the I/O device’s needs.
  - Program B finishes satisfying the I/O device’s needs.
- **Stage 3 (Context Restoration):**
  - Program A is restored to an active state.
- Program A resumes by executing instruction $n+3$
- Program A executes instruction $n+4$

>[!info] Program Transparency
>From the perspective of Program A, the computed results and overall program behavior remain identical to an uninterrupted run. The interruption is completely transparent to the suspended program.
### Why Have Interrupt-Driven I/O?

Polling forces the CPU to consume clock cycles executing repetitive load (`LDI`) and conditional branch (`BR`) instructions while waiting for a peripheral device to set its status ready bit. 

In contrast, **interrupt-driven I/O** eliminates polling overhead entirely. The processor executes useful computational tasks continuously until the peripheral signals that it is ready for data transfer, significantly optimizing CPU utilization and overall throughput.

---

>[!example] Performance Comparison: Polling vs. Interrupt-Driven I/O
>Consider a system tasked with reading and processing $1000$ consecutive batches of $100$ keyboard characters:
>
>**System Parameters:**
>- **Typing Rate:** $80\text{ words/minute} \longrightarrow 1\text{ character every } 0.125\text{ seconds}$.
>- **Input Acquisition Time ($T_{\text{input}}$):** 
>  $$T_{\text{input}} = 100\text{ characters} \times 0.125\text{ s/character} = 12.5\text{ seconds}$$
>- **Processing Time per Batch ($T_{\text{process}}$):** $12.49999\text{ seconds}$.
>- **Interrupt Service Time per Character ($T_{\text{ISR}}$):** A 10-instruction ISR at $10\text{ ns}$ ($0.00000001\text{ s}$) per instruction requires:
>  $$T_{\text{ISR}} = 10 \times 10^{-8}\text{ s} = 10^{-7}\text{ s/character} \quad (0.0000001\text{ s})$$
>- **Total Interrupt CPU Time per Batch:**
>  $$T_{\text{batch\_ISR}} = 100 \times 10^{-7}\text{ s} = 0.00001\text{ seconds}$$
>
>---
>
>**1. Sequential Polling Model:**
>Because the CPU is blocked in a polling loop during user typing, acquisition and computation cannot overlap:
>- **Time per Batch:** 
>  $$T_{\text{batch}} = T_{\text{input}} + T_{\text{process}} = 12.5\text{ s} + 12.49999\text{ s} = 24.99999\text{ seconds}$$
>- **Total Execution Time ($1000$ batches):**
>  $$T_{\text{total}} = 1000 \times 24.99999\text{ s} \approx 25{,}000\text{ seconds} \approx 7\text{ hours}$$
>
>---
>
>**2. Interrupt-Driven Overlapped Model:**
>The CPU spends only $0.00001\text{ seconds}$ reading each 100-character sequence in the background. The remaining $12.49999\text{ seconds}$ of typing time is used to process the *previous* batch in the foreground:
>- **Time per Batch:**
>  $$T_{\text{batch}} = T_{\text{batch\_ISR}} + T_{\text{process}} = 0.00001\text{ s} + 12.49999\text{ s} = 12.5\text{ seconds}$$
>- **Total Execution Time ($1000$ batches):**
>  $$T_{\text{total}} \approx 1000 \times 12.5\text{ s} \approx 12{,}500\text{ seconds} \approx 3.5\text{ hours}$$
>
>**Result:** Interrupt-driven execution halves the total task completion time from approximately $7\text{ hours}$ to $3.5\text{ hours}$ by allowing parallel I/O acquisition and data processing.
### Two Parts to the Process

The architecture of interrupt-driven I/O is divided into two distinct functional mechanisms:

1. **The Signaling Mechanism (Interrupt Initiation):** The hardware interface and control protocol that enables an external or internal I/O device to generate an asynchronous interrupt signal and assert a request to the processor.
2. **The Servicing Mechanism (Interrupt Handling):** The processor and system routine architecture (including context saving, vector decoding, ISR execution, and context restoration) that responds to, processes, and satisfies the interrupt request.
### Part I: Causing the Interrupt to Occur

For an I/O device to successfully interrupt the currently executing program, three necessary conditions must be satisfied simultaneously:

1. **Service Requirement:** The I/O device must actively want service (e.g., new input data has arrived or an output buffer is ready for transmission).
2. **Authorization (Interrupt Enable):** The device must have the explicit permission/right to request service (i.e., its local interrupt enable mask has been granted by software).
3. **Priority / Urgency:** The urgency of the device's request must be higher than the priority level of the task the processor is currently executing.

>[!important]
>Only when all three conditions are met will the processor stop executing its active program and transition control to service the interrupting peripheral.
#### The Interrupt Signal from the Device

For an I/O device to generate an interrupt request, it must both **need service** and be **authorized** to request that service.

### The Device Must Want Service

A device indicates that it needs service by setting its **ready bit** in its status register:

- **Keyboard (`KBSR`):** The keyboard requires service once a user has typed a character and that character is available for the processor to read.
- **Monitor / Display (`DSR`):** The monitor requires service when it has completed outputting the preceding character and is ready to accept the next character.

In both cases, the device wants service when its associated ready bit is set to logic `1`.

### The Device Must Have the Right to Request Service

The processor—typically through its operating system—controls each device's authority to interrupt by setting or clearing its **Interrupt Enable (IE)** bit. For the keyboard status register (`KBSR`) and display status register (`DSR`), the IE bit is bit $[14]$.

The device's interrupt request output is the logical AND of its ready bit and its interrupt-enable bit:

$$\text{Interrupt Request} = \text{Ready Bit} \land \text{IE Bit}$$

- **Ready Bit:** Usually bit $[15]$ of the device status register; set when the device needs service.
- **IE Bit:** Bit $[14]$; set by the processor to grant the device permission to interrupt.
- **$\land$:** The logical AND operator. The request is asserted only if _both_ inputs equal `1`.

| Ready Bit | IE Bit | Device Needs Service | Interrupt Authorized | Interrupt Request |
| :---: | :---: | :---: | :---: | :---: |
| `0` | `0` | No | No | `0` |
| `0` | `1` | No | Yes | `0` |
| `1` | `0` | Yes | No | `0` |
| `1` | `1` | Yes | Yes | `1` |
![[Pasted image 20260920210454.png]]
Figure 9.18 Interrupt enable bits and their use.

>[!important]
>If the IE bit is cleared (`0`), the device cannot interrupt the processor even if its ready bit is set. The processor must instead use polling to discover that the device is ready. When the IE bit is set (`1`), the device generates an interrupt request as soon as its ready bit becomes `1`.
#### The Urgency of the Request

The third prerequisite for a device to interrupt the processor is that its request must be more urgent than the work the processor is currently doing. 

Every task and program runs at a defined level of urgency called its **Priority Level (PL)**:

- **Priority Hierarchy:** Most computer architectures define discrete priority tiers. For example, the `LC-3` architecture supports eight distinct priority levels: $\text{PL0}$ through $\text{PL7}$.
- **Numerical Significance:** Higher numerical values correspond to higher urgency ($\text{PL7}$ is the most urgent; $\text{PL0}$ is the least urgent).

---

### Preemption and Priority Arbitration

A requesting device can interrupt (preempt) an actively running program only if its assigned Priority Level strictly exceeds the current Priority Level of the processor:

$$\text{PL}_{\text{request}} > \text{PL}_{\text{current}}$$

- **$\text{PL}_{\text{request}}$** : Priority level associated with the interrupting device or event.
- **$\text{PL}_{\text{current}}$** : Current operational priority level of the executing program.

>[!example] Priority Comparison
>- **Low Urgency ($\text{PL0}$):** A batch payroll processing job scheduled to run overnight runs at $\text{PL0}$. Because it has hours to complete, any higher-priority event can freely preempt it.
>- **High Urgency ($\text{PL6}$):** A control routine mitigating a high-voltage power surge in a nuclear power plant executes at $\text{PL6}$. Routine events—such as a user pressing a keyboard key to check email—are assigned lower priority and are blocked from interrupting the power regulation task.

>[!info]
>When multiple I/O devices request service simultaneously, the processor arbitrates among them and grants access to the device holding the highest priority level, provided that level exceeds $\text{PL}_{\text{current}}$.
#### The INT Signal

To halt normal program execution and force the processor to service an incoming interrupt, the master hardware **`INT`** (Interrupt) line must be asserted.

Asserting the `INT` signal requires a multi-stage logic evaluation across all connected peripheral devices:

```
[Device Status Registers]
  (Ready Bit [15] AND Interrupt Enable Bit [14])
     │
     ├──► Device 0 Req (PL_A) ──┐
     ├──► Device 1 Req (PL_B) ──┼──► [ Priority Encoder ]
     └──► Device N Req (PL_N) ──┘            │
                                             ▼
                                   Highest Asserted PL
                                             │
                                             ▼
                                     [ Comparator ] ◄─── Current Processor PL
                                             │
                                             ▼
                                  INT Signal Asserted (if Highest PL > Current PL)
```

![[Pasted image 20260920210635.png]]
Figure 9.19 Generation of the INT signal.

### Signal Evaluation Stages

1. **Device Request Generation:** Each peripheral performs a logical AND on its Ready bit (bit $[15]$) and Interrupt Enable bit (bit $[14]$). If both bits are asserted (`1`), the device asserts its individual interrupt request line.
2. **Priority Resolution (Priority Encoder):** All active device request lines enter a combinational logic block called a **priority encoder**. The priority encoder evaluates all pending requests simultaneously and outputs the priority level of the single highest-priority requester.
3. **Threshold Comparison & `INT` Assertion:** A hardware comparator compares the highest asserted request priority ($\text{PL}_{\text{request}}$) against the priority level of the currently executing program ($\text{PL}_{\text{current}}$):
   - If $\text{PL}_{\text{request}} > \text{PL}_{\text{current}}$, the **`INT`** signal is asserted.
   - If $\text{PL}_{\text{request}} \le \text{PL}_{\text{current}}$, the **`INT`** signal remains deasserted, and the request is held pending.
#### The Test for INT

The central processor operates as a synchronous finite state machine, continuously cycling through the standard phases of the instruction cycle:
1. `FETCH`
2. `DECODE`
3. `EVALUATE ADDRESS`
4. `FETCH OPERAND`
5. `EXECUTE`
6. `STORE RESULT`

Because external interrupts are **asynchronous** physical events, an interrupt request can occur at any arbitrary point in time (for instance, during the `FETCH OPERAND` phase).

---

### Instruction Boundary Rule

Stopping the processor midway through an instruction cycle would create substantial complexity: the system would need to record which micro-operations had finished, preserve internal pipeline stages, and track how to resume a partially executed instruction.

To avoid this overhead, modern architectures adhere to the **instruction boundary rule**:

>[!important]
>The processor samples and acts upon the `INT` signal **only at instruction boundaries**—after the current instruction has fully completed its `STORE RESULT` phase and before the next instruction begins its `FETCH` phase.

At this boundary, the architectural state of the computer reflects the complete, consistent execution of the current instruction.

---

### Control Logic Modification

The finite state machine of the control unit is updated at the final clock cycle of every instruction cycle:

- **If `INT` is NOT asserted (`0`):** Normal program execution continues, and the control unit loops directly back to the `FETCH` phase to execute the next instruction.
- **If `INT` is asserted (`1`):** The control unit branches to the initial state of the interrupt-handling sequence (Part II), initiating the context switch and vector lookup.
### Part II: Handling the Interrupt Request

Once the processor detects an asserted `INT` signal at an instruction boundary, it transitions into the interrupt servicing procedure. This process consists of three sequential operational stages:

1. **Initiate the Interrupt:** Suspend the current execution context, preserve processor state, and vector the Program Counter (`PC`) to the starting address of the handler.
2. **Service the Interrupt:** Execute the dedicated Interrupt Service Routine (ISR) to satisfy the I/O device's requests.
3. **Return from the Interrupt:** Restore the saved execution context and Program Counter, returning control seamlessly to the original program.
#### Initiate the Interrupt

When the `INT` signal is asserted at an instruction boundary, the processor begins a hardware sequence to initiate the interrupt. This sequence accomplishes two primary objectives:
1. **Save the state** of the interrupted program so it can resume transparently later.
2. **Load the state** of the higher-priority interrupting service routine.

---

### Saving the State of the Interrupted Program

The *architectural state* of a program comprises the complete snapshot of its active computing resources: memory contents, general-purpose registers, the Program Counter (`PC`), and the Processor Status Register (`PSR`).

- **Processor Status Register (`PSR`):**
  - `PSR[15]`: Privilege Mode (`0` for privileged Supervisor mode, `1` for unprivileged User mode).
  - `PSR[10:8]`: Priority Level (`PL0` to `PL7`).
  - `PSR[2:0]`: Condition Codes ($N$, $Z$, $P$ flags).

To ensure transparency upon return, the hardware preserves the minimal necessary state:
- **`PC`:** Preserved so the processor knows the exact instruction to execute when the program resumes.
- **`PSR[2:0]` (Condition Codes):** Preserved because subsequent conditional branch instructions in the main program may depend on these flags.
- **`PSR[10:8]` (Priority Level):** Preserved to restore the program's relative urgency against pending system requests upon return.
- **`PSR[15]` (Privilege Level):** Preserved to restore the correct execution permissions.

>[!note] General-Purpose Registers
>The `LC-3` hardware does not automatically push general-purpose registers (`R0`–`R7`) to the stack during interrupt initiation. Instead, the convention requires the **Interrupt Service Routine (ISR)** to save any registers it modifies (callee-save) and restore them before returning.

#### Stack Mechanics During Context Saving

Context saving uses the privileged **Supervisor Stack**:

1. **Stack Pointer Swap:** If the processor is in User mode (`PSR[15] = 1`), the User Stack Pointer (`USP`) currently in `R6` is saved into an internal register (`Saved.USP`). `R6` is then loaded with the Supervisor Stack Pointer from `Saved.SSP`.
2. **Pushing Context:** The processor pushes the interrupted program's `PSR` and `PC` onto the Supervisor Stack:
   - Decrement `R6`, store `PSR`.
   - Decrement `R6`, store `PC`.

---

### Loading the State of the Interrupt Service Routine

Once context is preserved, the processor loads the execution state for the target ISR using a **vectored interrupt** mechanism:

1. **Interrupt Vector (`INTV`):** The interrupting I/O device transmits an 8-bit vector number (`INTV`) over the system bus along with its request.
2. **Vector Table Lookup:** The processor zero-extends the 8-bit vector to a 16-bit address within the **Interrupt Vector Table** (located in system memory from `x0100` to `x01FF`):
   $$\text{Vector Address} = \text{x0100} + \text{INTV}$$
3. **Loading the `PC`:** The processor reads the memory contents at the calculated vector table address and loads that value into the Program Counter (`PC`).
4. **Initializing the `PSR`:**
   - `PSR[15] = 0`: Configures the processor for **privileged (Supervisor) mode**.
   - `PSR[10:8]`: Set to the priority level ($\text{PL}$) of the interrupting device.
   - `PSR[2:0] = 010`: Arbitrarily initialized ($Z=1$, $N=0$, $P=0$) prior to executing the first instruction of the ISR.
#### Service the Interrupt

Once the Program Counter (`PC`) is loaded with the starting address obtained from the Interrupt Vector Table, the processor begins fetching and executing the instructions comprising the **Interrupt Service Routine (ISR)**.

During this stage:
- The ISR performs the specific input or output operations required by the peripheral (e.g., reading a byte from `KBDR` to clear the keyboard ready bit, or loading a byte into `DDR` to clear the display ready bit).
- If the ISR needs to use general-purpose registers (`R0`–`R7`), it must push their initial values onto the Supervisor Stack before use and restore them prior to concluding.
- Execution proceeds in privileged Supervisor mode at the device's elevated Priority Level until the final return instruction is reached.
#### Return from the Interrupt

The final instruction executed in every Interrupt Service Routine is the **`RTI`** (Return from Trap or Interrupt) instruction (opcode `1000`). Executing `RTI` concludes the interrupt-handling process and restores the processor state to what it was immediately before the interrupt occurred.

---

### Mechanics of the `RTI` Instruction

When the processor executes `RTI`, it pops the preserved state from the Supervisor Stack and restores the operational registers:

1. **Restoring the Program Counter (`PC`):**
   - The saved `PC` value is popped from the supervisor stack into the Program Counter.
   - Points the processor directly to the address of the next sequential instruction that was about to be executed before the interruption.
2. **Restoring the Processor Status Register (`PSR`):**
   - The saved `PSR` value is popped from the supervisor stack into the Processor Status Register.
   - **Condition Codes (`PSR[2:0]`):** The $N$, $Z$, and $P$ flags are restored to their pre-interrupt states, ensuring that any subsequent conditional branch (`BR`) instructions in the main program evaluate correctly.
   - **Priority Level (`PSR[10:8]`):** The processor drops from the elevated priority of the ISR back to the original Priority Level ($\text{PL}$) of the interrupted program.
   - **Privilege Level (`PSR[15]`):** The execution mode reverts back to the mode of the interrupted task (`0` for privileged Supervisor mode, `1` for unprivileged User mode).
3. **Stack Pointer Adjustment:**
   - If the restored `PSR[15]` indicates that the interrupted program was running in unprivileged User mode, the processor saves the current Supervisor Stack Pointer from `R6` into `Saved.SSP` and restores `R6` with the User Stack Pointer from `Saved.USP`.

>[!info]
>Once the `PC`, `PSR`, and stack pointers are restored to their exact pre-interrupt states, the interrupted program resumes execution transparently, as if no interruption had taken place.
### An Example

This scenario demonstrates **nested interrupt handling** where an actively running program is interrupted by an I/O device, which is subsequently interrupted by a higher-priority I/O device.

---

### Scenario Parameters

- **Program A (User Mode, Baseline Priority):**
  - Stored in memory locations `x3000` to `x3010`.
  - Currently executing the `ADD` instruction at `x3006`.
- **Device B (Intermediate Priority):**
  - Associated with Interrupt Vector `xF1`.
  - Interrupt Service Routine located at `x6200` to `x6210` (ending with `RTI` at `x6210`).
  - $\text{PL}_{\text{Device B}} > \text{PL}_{\text{Program A}}$.
- **Device C (Highest Priority):**
  - Associated with Interrupt Vector `xF2`.
  - Interrupt Service Routine located at `x6300` to `x6315` (ending with `RTI` at `x6315`).
  - $\text{PL}_{\text{Device C}} > \text{PL}_{\text{Device B}} > \text{PL}_{\text{Program A}}$.

---

### Step-by-Step Execution Sequence

#### 1. Initial Interruption of Program A by Device B
- Program A finishes executing the `ADD` instruction at `x3006`.
- Device B asserts its interrupt request along with vector `xF1`. Because $\text{PL}_{\text{Device B}} > \text{PL}_{\text{Program A}}$, the hardware asserts the `INT` signal at the `x3006` instruction boundary.
- **Switch to Supervisor Stack:**
  1. The User Stack Pointer in `R6` is saved into `Saved.USP`.
  2. `R6` is loaded with the Supervisor Stack Pointer from `Saved.SSP`.
- **Preserve Program A State:**
  1. Program A’s `PSR` (containing condition codes set by the `ADD` instruction at `x3006`, priority level, and User mode status) is pushed onto the Supervisor Stack.
  2. The return address `x3007` (the next instruction in Program A) is pushed onto the Supervisor Stack.
- **Vector to Device B ISR:**
  - The vector `xF1` expands to the 16-bit address `x01F1`.
  - The processor reads the entry at `x01F1` (`x6200`) and loads it into the `PC`.
  - `PSR` is initialized to Supervisor mode with the priority level of Device B.

![[Pasted image 20260920211105.png]]
Figure 9.20 Execution flow for interrupt-driven I/O.

---

#### 2. Nested Interruption of Device B by Device C
- The ISR for Device B executes up to the `AND` instruction at `x6202`.
- Device C asserts an interrupt request with vector `xF2`. Because $\text{PL}_{\text{Device C}} > \text{PL}_{\text{Device B}}$, the `INT` line is asserted again.
- **Preserve Device B State:**
  - The processor is already in Supervisor mode, so no stack pointer swap is needed.
  - The `PSR` of Device B’s ISR (including condition codes produced by the `AND` instruction at `x6202` and Device B's priority) is pushed onto the Supervisor Stack.
  - The return address `x6203` is pushed onto the Supervisor Stack.
- **Vector to Device C ISR:**
  - The vector `xF2` expands to `x01F2`.
  - The processor loads the entry at `x01F2` (`x6300`) into the `PC`.
  - `PSR` is updated to Supervisor mode with the elevated priority level of Device C.

---

#### 3. Completion of Device C and First Return
- Device C’s ISR executes through to completion, finishing with the `RTI` instruction at `x6315`.
- **Executing `RTI` (from Device C):**
  1. Pops the top of the Supervisor Stack (`x6203`) into the `PC`.
  2. Pops the next value from the Supervisor Stack into the `PSR`, restoring Device B's priority level and the condition codes from the `AND` instruction at `x6202`.
- Device B's ISR resumes execution at address `x6203`.

---

#### 4. Completion of Device B and Return to Program A
- Device B’s ISR completes its remaining instructions and executes the `RTI` instruction at `x6210`.
- **Executing `RTI` (from Device B):**
  1. Pops the top of the Supervisor Stack (`x3007`) into the `PC`.
  2. Pops the saved `PSR` of Program A into the `PSR`, restoring Program A's priority level, User privilege mode, and the condition codes from the `ADD` instruction at `x3006`.
  3. Because `PSR[15]` indicates a return to User mode, the processor saves `R6` into `Saved.SSP` and restores `R6` from `Saved.USP`.
- Program A resumes normal execution starting at instruction `x3007`.

![[Pasted image 20260920211146.png]]
Figure 9.21 Snapshots of the contents of the supervisor stack and the PC during interrupt-driven I/O.

---

### Supervisor Stack Frame Progression

```
[Initial Stack] ──► [After Device B Interrupt] ──► [After Device C Interrupt]
 (Empty/Base)        ┌───────────────────┐          ┌───────────────────┐
                     │   PSR (Prog A)    │          │   PSR (Prog A)    │
                     ├───────────────────┤          ├───────────────────┤
                     │    PC (x3007)     │ ◄── R6   │    PC (x3007)     │
                     └───────────────────┘          ├───────────────────┤
                                                    │   PSR (Dev B)     │
                                                    ├───────────────────┤
                                                    │    PC (x6203)     │ ◄── R6
                                                    └───────────────────┘
```
### Not Just I/O Devices

While interrupts are frequently discussed in the context of I/O peripheral servicing, the interrupt mechanism is a universal architecture utilized by many system-level events external to the running program. 

Any hardware or system event can interrupt the processor provided it fulfills the standard interrupt protocol:
1. Asserts the master **`INT`** request signal.
2. Supplies an 8-bit interrupt vector (**`INTV`**) designating its service routine.
3. Operates at a **Priority Level (PL)** higher than the currently executing program.

---

### Non-I/O Interrupt Sources

- **Timer Interrupts:** Generated periodically by hardware timers to track the passage of time, update real-time clocks, or trigger periodic operating system task switches.
- **Machine Check Interrupts:** Triggered by hardware diagnostic circuitry to alert the processor that an internal hardware component, memory bank, or bus is malfunctioning.
- **Power Failure Interrupts:** High-priority emergency signals triggered when power input drops below an operating threshold (e.g., if a power cord is unplugged). This allows the processor a few final clock cycles to save critical state data and register contents to non-volatile storage before power is completely lost.