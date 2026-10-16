---
tags:
  - CCT3
  - indlejrede_systemer
Topic: Serial Communication, Serial Peripheral Interface (SPI), I2C, Serial Communication Subsystem, DHT11, DHT22 and AM2302 Sensors.
Semester: CCT3
Course: Programmering af indlejrede systemer
Litterature:
  - https://learn.sparkfun.com/tutorials/serial-communication/all
  - https://learn.sparkfun.com/tutorials/serial-peripheral-interface-spi/all
  - https://learn.sparkfun.com/tutorials/i2c/all
  - https://learn.adafruit.com/dht
  - "Arduino II: Systems"
Created: 15-10-2026
---
## Table of Contents

1. [[#5.1 Introduction|5.1 Introduction]]
2. [[#5.2 Parallel vs. Serial|5.2 Parallel vs. Serial]]
3. [[#5.3 Asynchronous Serial|5.3 Asynchronous Serial]]
4. [[#5.4 Rules of Serial|5.4 Rules of Serial]]
5. [[#5.5 Baud Rate|5.5 Baud Rate]]
6. [[#5.6 Framing the Data|5.6 Framing the Data]]
	1. [[#5.6 Framing the Data#Data Chunk|Data Chunk]]
	2. [[#5.6 Framing the Data#Synchronization Bits|Synchronization Bits]]
	3. [[#5.6 Framing the Data#Parity Bits|Parity Bits]]
7. [[#5.7 Worked UART Transfer: 9600 8N1|5.7 Worked UART Transfer: 9600 8N1]]
8. [[#5.8 Wiring and Hardware|5.8 Wiring and Hardware]]
9. [[#5.9 Hardware Implementation|5.9 Hardware Implementation]]
10. [[#5.10 UART Hardware|5.10 UART Hardware]]
11. [[#5.11 Software UARTs|5.11 Software UARTs]]
12. [[#5.12 Common Pitfalls|5.12 Common Pitfalls]]
	1. [[#5.12 Common Pitfalls#RX-to-TX, TX-to-RX|RX-to-TX, TX-to-RX]]
	2. [[#5.12 Common Pitfalls#Baud Rate Mismatch|Baud Rate Mismatch]]
	3. [[#5.12 Common Pitfalls#Bus Contention|Bus Contention]]
13. [[#5.13 Serial Peripheral Interface (SPI)|5.13 Serial Peripheral Interface (SPI)]]
	1. [[#5.13 Serial Peripheral Interface (SPI)#Introduction|Introduction]]
	2. [[#5.13 Serial Peripheral Interface (SPI)#What's Wrong with Serial Ports?|What's Wrong with Serial Ports?]]
	3. [[#5.13 Serial Peripheral Interface (SPI)#A Synchronous Solution|A Synchronous Solution]]
	4. [[#5.13 Serial Peripheral Interface (SPI)#Receiving Data|Receiving Data]]
	5. [[#5.13 Serial Peripheral Interface (SPI)#Chip Select (CS)|Chip Select (CS)]]
	6. [[#5.13 Serial Peripheral Interface (SPI)#Multiple Peripherals|Multiple Peripherals]]
	7. [[#5.13 Serial Peripheral Interface (SPI)#Programming for SPI|Programming for SPI]]
	8. [[#5.13 Serial Peripheral Interface (SPI)#Configuration Options|Configuration Options]]
	9. [[#5.13 Serial Peripheral Interface (SPI)#Pin Requirements|Pin Requirements]]
14. [[#5.14 I2C|5.14 I2C]]
	1. [[#5.14 I2C#Introduction|Introduction]]
	2. [[#5.14 I2C#Why Use I2C?|Why Use I2C?]]
15. [[#5.15 I2C at the Hardware Level|5.15 I2C at the Hardware Level]]
	1. [[#5.15 I2C at the Hardware Level#Signals|Signals]]
	2. [[#5.15 I2C at the Hardware Level#Signal Logic Levels|Signal Logic Levels]]
16. [[#5.16 Protocol|5.16 Protocol]]
	1. [[#5.16 Protocol#Basics|Basics]]
	2. [[#5.16 Protocol#Start Condition|Start Condition]]
	3. [[#5.16 Protocol#Address Frame|Address Frame]]
	4. [[#5.16 Protocol#Data Frames|Data Frames]]
	5. [[#5.16 Protocol#Stop Condition|Stop Condition]]
	6. [[#5.16 Protocol#Combined write-read transaction|Combined write-read transaction]]
17. [[#5.17 Character Encoding and Signal Coding|5.17 Character Encoding and Signal Coding]]
18. [[#5.18 Serial USART|5.18 Serial USART]]
	1. [[#5.18 Serial USART#System Overview|System Overview]]
		1. [[#System Overview#USART Clock Generator|USART Clock Generator]]
		2. [[#System Overview#USART Transmitter|USART Transmitter]]
		3. [[#System Overview#USART Receiver|USART Receiver]]
		4. [[#System Overview#USART Registers|USART Registers]]
19. [[#5.19 ATmega SPI Operation and Registers|5.19 ATmega SPI Operation and Registers]]
	1. [[#5.19 ATmega SPI Operation and Registers#SPI Operation|SPI Operation]]
	2. [[#5.19 ATmega SPI Operation and Registers#Registers|Registers]]
20. [[#5.20 Two-Wire Serial Interface|5.20 Two-Wire Serial Interface]]
	1. [[#5.20 Two-Wire Serial Interface#System Architecture|System Architecture]]
	2. [[#5.20 Two-Wire Serial Interface#TWI Registers|TWI Registers]]
	3. [[#5.20 Two-Wire Serial Interface#Setting the TWI clock|Setting the TWI clock]]
	4. [[#5.20 Two-Wire Serial Interface#Handshaking Protocol|Handshaking Protocol]]

# 5. Communication Subsystem

| Concept or syntax | Meaning / use |
|---|---|
| Integrated circuit (IC); input/output (I/O) | A chip; its external signal connections. |
| Universal asynchronous receiver/transmitter (UART) | Hardware that frames asynchronous serial characters. |
| Universal synchronous and asynchronous receiver and transmitter (USART) | UART functions plus synchronous operating modes. |
| Serial Peripheral Interface (SPI) | Controller-clocked, selected-peripheral serial exchange. |
| Inter-Integrated Circuit (I2C); Two-Wire Interface (TWI) | Addressed two-signal bus; TWI is the AVR implementation name. |
| Receive (RX, RxD); transmit (TX, TxD) | UART input and output; cross TX to RX for direct peer wiring. |
| Ground (GND); supply rail (`VCC`) | Signal reference; supply-voltage label, not permission to join power outputs. |
| Serial clock (SCK, CLK); serial clock line (SCL); serial data line (SDA) | SPI clock names; I2C clock and data. |
| Peripheral In / Controller Out (PICO); Master Out / Slave In (MOSI) | Equivalent SPI signal direction, controller to peripheral. |
| Peripheral Out / Controller In (POCI); Master In / Slave Out (MISO) | Equivalent SPI signal direction, peripheral to controller. |
| Chip select (CS); slave select (SS) | Peripheral-select signal; often active low. |
| Most-significant bit (MSB); least-significant bit (LSB) | Largest- and smallest-weight bit in a word. |
| Acknowledge (ACK); not acknowledge (NACK); read/write (R/W) | I2C response bit and transfer-direction bit. |
| Transistor-transistor logic (TTL) | Legacy label often used loosely for logic-level UART; check actual thresholds. |
| Recommended Standard $232$ (RS-232); Electronic Industries Association $232$ (EIA-232) | Bipolar, inverted serial electrical interface; not a packet protocol. |
| Recommended Standard $485$ (RS-485) | Differential electrical interface suitable for controlled multidrop links. |
| American Standard Code for Information Interchange (ASCII) | $7$-bit character encoding, included in Unicode. |
| Unicode Transformation Format (UTF-8, UTF-16) | Unicode encodings using $8$-bit or $16$-bit code units. |
| Non-Return-to-Zero (NRZ) | Each bit holds its level for a complete bit time. |
| First-in-first-out (FIFO) | Buffer order: oldest item is read first. |
| Universal Serial Bus (USB); Global Positioning System (GPS) | Common host interface; satellite-positioning system. |
| Liquid-crystal display (LCD); light-emitting diode (LED) | Display technology; indicator/emitter technology. |
| Secure Digital (SD); printed circuit board (PCB); digital-to-analog converter (DAC) | Storage-card family; circuit board; analog-output converter. |
| Bits per second (bps); kilobits per second (kbps); megabits per second (Mbps) | Bit-rate units; baud is symbols per second. |
| $t_{\text{bit}}$; $f_{\text{sys}}$; $\mathrm{UBRR}$ | Bit interval; system-clock frequency; integer USART baud divisor. |
| $t_{\text{bit}}=1/\text{baud rate}$ | Valid here because a binary UART symbol carries one bit. |
| $\text{Baud Rate}=f_{\text{sys}}/[16(\mathrm{UBRR}+1)]$ | Asynchronous normal USART mode, `U2X0 = 0`. |
| $\mathrm{UBRR}=f_{\text{sys}}/(16\cdot\text{Baud Rate})-1$ | Select an integer divisor, then check actual baud error. |
| $\cdot$, $\times$, $\div$, $\approx$, $\%$ | Multiplication; multiplication; division; approximation; percent. |
| $\mu\mathrm{s}$, $\mathrm{ms}$, $\mathrm{Hz}$, $\mathrm{MHz}$, $\Omega$, $\mathrm{k\Omega}$ | Microseconds, milliseconds, hertz, megahertz, ohms, kilo-ohms. |
| `0x`; `0b`; `8N1` | Hexadecimal prefix; binary prefix; $8$ data bits, no parity, $1$ stop bit. |
| USART Control and Status Registers (`UCSR0A/B/C`) | Status flags, enables, and frame configuration for USART channel zero. |
| USART Baud Rate Registers (`UBRR0H/L`); USART Data Register (`UDR0`) | High/low divisor bytes; transmit and receive data access. |
| USART Data Register Empty (`UDRE0`); Transmit Complete (`TXC0`); Receive Complete (`RXC0`) | Buffer can accept data; frame fully sent; unread received data. |
| Receiver Enable (`RXEN0`); Transmitter Enable (`TXEN0`); double-speed USART (`U2X0`) | Enable receive/transmit; select double-speed asynchronous clock division. |
| USART Mode Select (`UMSEL0`); Parity Mode (`UPM`); Stop Bit Select (`USBS`); Character Size (`UCSZ`) | Register fields controlling mode and frame format; suffixes vary by AVR family. |
| USART Register Select (`URSEL`) | Older-AVR register-write selector; absent on ATmega328/P. |
| SPI Control Register (`SPCR`); SPI Status Register (`SPSR`); SPI Data Register (`SPDR`) | SPI configuration, status, and byte exchange. |
| SPI Enable (`SPE`); Data Order (`DORD`); Master/Slave Select (`MSTR`) | Enable SPI, select bit order, and select controller/peripheral role. |
| Clock Polarity (`CPOL`); Clock Phase (`CPHA`) | Clock idle level; sampling on leading or trailing edge. |
| SPI Clock Rate Select (`SPR`); Double SPI Speed (`SPI2X`); SPI Interrupt Flag (`SPIF`) | Clock-divider controls; transfer-complete flag. |
| TWI Bit Rate Register (`TWBR`); TWI Control Register (`TWCR`) | Bus clock configuration; operation control. |
| TWI Status Register (`TWSR`); TWI Data Register (`TWDR`) | Transfer state and prescaler; transferred byte. |
| TWI Address Register (`TWAR`); TWI Address Mask Register (`TWAMR`) | Own peripheral address and address-mask matching. |
| Binary decoder; address mask; auto-increment | One-of-many output selection; ignored address bits during comparison; automatic advancement of a register pointer. |
| Setup time; hold time | Required stable-data interval before and after a sampling edge. |
| $f_{\mathrm{SCL}}$; $P$; $\mathrm{TWPS}$; $\mathrm{TWBR}$ | TWI clock frequency; prescaler factor; numeric prescaler-field value; numeric bit-rate-register value. |
| TWI Prescaler Select (`TWPS1`, `TWPS0`) | Bits in `TWSR`; together select prescaler factors $1,4,16,64$. |
| $f_{\mathrm{SCL}}=f_{\text{sys}}/(16+2\cdot\mathrm{TWBR}\cdot P)$; $P=4^{\mathrm{TWPS}}$ | ATmega328/P controller-mode nominal TWI clock relationship. |
| $\mathrm{ns}$; $\mathrm{kHz}$; $\mathrm{V}$; $\mathrm{mA}$ | Nanoseconds; kilohertz; volts; milliamperes. |
_Table 5.1: Quick reference for communication concepts, abbreviations, symbols, and register fields._

## 5.1 Introduction

_Embedded electronics_ is all about interlinking circuits — processors or other _integrated circuits_ — to create a symbiotic system. For these individual circuits to exchange information, they must share a common _communication protocol_. Hundreds of protocols have been defined for this purpose, and they generally fall into one of two categories: **parallel** or **serial**.

## 5.2 Parallel vs. Serial

_Parallel interfaces_ transfer multiple bits simultaneously, typically requiring data buses of eight, sixteen, or more wires. Data moves in large, concurrent bursts of $1$'s and $0$'s.
![[Pasted image 20261015144816.png]]
_Figure 5.1: Clocked $8$-bit parallel bus: eight data signals plus a clock. Image unavailable in the supplied files; description is based on source context._

_Serial interfaces_ stream data one single bit at a time. These can operate on as few as one wire and usually no more than four.
![[Pasted image 20261015144824.png]]
_Figure 5.2: Clocked serial transfer: one data signal plus a clock. Image unavailable in the supplied files; description is based on source context._

> [!example] Highway Analogy
> Think of the two interfaces as a stream of cars: a parallel interface is like an $8$+ lane mega-highway, while a serial interface is more like a two-lane rural country road. Over a set amount of time, the mega-highway can move more traffic to its destination, but the two-lane road serves its purpose at a fraction of the cost to build.

Parallel communication transfers more bits per clock at the same clock rate, but demands many more input/output (I/O) lines. Serial communication conserves pins; actual throughput depends on signaling rate, framing overhead, wiring, and implementation.

> [!warning] Correction: Parallel is not inherently faster than serial. The highway analogy compares lane count at comparable signaling speeds, not the maximum speed of all interfaces.

## 5.3 Asynchronous Serial

Dozens of serial protocols have been developed to meet the particular needs of embedded systems. Well-known computing examples include _USB_ (Universal Serial Bus) and _Ethernet_, while other common interfaces include _SPI_, _I2C_, and the widely used asynchronous serial standard. For the embedded links studied here, the important distinction is **synchronous** versus **asynchronous** timing. Other serial systems can recover clock timing from the data rather than use a separate clock wire.

> [!info] Definition: Synchronous vs. Asynchronous Serial
> - **Synchronous** serial interfaces pair their data line(s) with a _clock signal_, meaning all devices on the bus share a common clock. This enables straightforward receiver timing, but requires an extra clock signal for the interfaces discussed here.
> - **Asynchronous** serial interfaces transfer data _without_ an external clock signal. This minimizes the number of required wires and I/O pins, but demands additional mechanisms to ensure reliable data transfer and reception.

> [!example] Shared clock versus independent clocks
> An SPI sensor receives a clock from its controller. A UART-connected Global Positioning System (GPS) module and microcontroller instead use independently generated timing and agree on baud rate and frame format. Universal Serial Bus (USB), Bluetooth modules, XBee radios, and serial liquid-crystal displays (LCDs) are other communication contexts mentioned in the source; their electrical interfaces must be checked individually.

The most common form of asynchronous serial communication is so ubiquitous that the term "serial" on its own typically refers to this specific protocol. It is widely used in embedded electronics for interfacing with external devices such as _GPS modules_, _Bluetooth modules_, _XBee radios_, and _serial LCDs_.

> [!example] Independent-clock framing
> A receiver detects a falling start edge, samples the next data bits at its configured bit intervals, and checks that the stop interval is high. It resynchronizes at the next start edge; a large baud mismatch defeats this process.

## 5.4 Rules of Serial

Asynchronous serial framing supports synchronization and optional error detection, but cannot guarantee error-free delivery. Its configurable mechanisms are:

> [!warning] Correction: Start/stop framing and parity do not guarantee error-free communication or provide automatic retransmission.

- _Data bits_
- _Synchronization bits_
- _Parity bits_
- _Baud rate_

The protocol is highly configurable through these mechanisms, meaning there is no single way to send data serially. The critical requirement is that **both devices on a serial bus must be configured to use the exact same settings**.

> [!example] Agreement before a transfer
> Configure both endpoints as `9600 8N1`. If one expects even parity while the other sends none, the endpoints disagree about where the frame ends even when the baud rates match.

## 5.5 Baud Rate

> [!info] Definition: Baud rate
> Baud rate counts symbols per second. With the binary UART signaling used here, each symbol carries one bit, so baud and bits per second are numerically equal. Inverting that rate gives the bit interval.

> [!example] Binary symbols and bit rate
> At $9600$ baud with one bit per symbol, the wire carries $9600$ bits each second, including framing bits. ✓ Check: $9600\cdot1=9600$. The receiver uses its own clock to sample near each bit center.

> [!warning] Correction: Baud means symbols per second, not universally bits per second; their equality here depends on binary signaling.

> [!note] Baud Rate and Bit Duration
> $$t_{\text{bit}} = \frac{1}{\text{baud rate}}$$
>
> **Breakdown:**
> - $t_{\text{bit}}$ : The bit duration — the time spent transmitting a single bit, in seconds.
> - $\text{baud rate}$ : The symbol rate in baud; numerically equal to bits per second only for the binary signaling considered here.

Both communicating devices must operate at the same baud rate. Common standard rates include 1200, 2400, 4800, **9600**, 19200, 38400, 57600, and $115200\,\mathrm{bps}$. The $9600\,\mathrm{bps}$ rate is especially common for simple applications where speed is not critical.

> [!example] Bit duration
> At $9600$ baud with one bit per symbol, $t_{\text{bit}}=1/9600\,\mathrm{s}\approx104.167\,\mu\mathrm{s}$. Here $t_{\text{bit}}$ is one bit interval. ✓ Substitution: $9600\cdot(1/9600)=1$.

Higher rates shorten transfer time, but the usable rate depends on peripheral clock divisors, clock error, receiver timing, software buffering, and signal integrity. Many microcontrollers support rates well above $115200$ bps.

> [!warning] Correction: There is no general microcontroller limit at $115200\,\mathrm{bps}$; consult the specific device and system timing limits.

## 5.6 Framing the Data

Each block of data (usually a byte) is transmitted as a _packet_ or _frame_ of bits, created by appending synchronization and parity bits around the actual data.
![[Pasted image 20261015152005.png]]
_Figure 5.3: UART frame layout with configurable data, parity, and stop fields. Image unavailable in the supplied files; description is based on source context._
### Data Chunk

> [!example] Choosing a seven-bit ASCII payload
> The core of every serial packet is the _data chunk_. Its size is configurable from $5$ to $9$ bits. The standard is an $8$-bit byte, though other sizes have practical uses — for instance, a $7$-bit chunk is more efficient when transferring $7$-bit _ASCII_ characters.

Both devices must agree on _bit order_: most-significant bit (MSB) first or least-significant bit (LSB) first. Conventional UARTs, including the ATmega328 USART, transmit data **LSB first**. Byte order within multi-byte values is a separate application-level choice.

> [!warning] Correction: Bit order within a character is not the same as byte endianness in a multi-byte value.

### Synchronization Bits

_Synchronization bits_ are two or three special bits transferred with each data chunk: the _start bit_ and the _stop bit(s)_. They mark the beginning and end of each packet.

- There is always exactly **one start bit**, indicated by the idle data line transitioning from $1$ to 0.
- The number of **stop bits** is configurable to either one or two (commonly left at one). The stop bit(s) return the line to the idle state by holding it at 1.

> [!example] A framed zero byte
> An `8N1` zero byte begins with a low start bit, holds low for all eight data bits, then returns high for one stop bit. ✓ Check: $1+8+1=10$ bit intervals; transitions alone cannot identify the eight data bits.

### Parity Bits

> [!info] Definition: Parity
> _Parity_ is a simple, low-level form of error checking that comes in two flavors: **odd** or **even**. To compute the parity bit, all data bits in the chunk are summed, and the evenness of the total determines whether the parity bit is set.

> [!example] **Parity Calculation**
> Given a data byte of `0b01011101` (which contains five $1$'s — an odd count):
> - With **even** parity: the parity bit is set to `1` to make the total number of $1$'s even ($6$).
> - With **odd** parity: the parity bit is set to `0` to keep the total number of $1$'s odd ($5$).
>
> ✓ Check: $1+0+1+1+1+0+1+0=5$; appending one gives $6$ ones, appending zero leaves $5$.

Parity is optional and not widely used. It can help when transmitting across noisy mediums, but it slightly slows data transfer and requires both sender and receiver to implement error-handling (typically re-sending data that fails the parity check).

Parity detects every odd number of flipped bits in the protected data-plus-parity field, but can miss an even number. A UART normally reports a parity error; acknowledgements and retransmission must be implemented above the UART if needed.

> [!example] Undetected even-bit error
> With even parity, flipping one zero to one and one one to zero leaves the number of ones unchanged. The parity test passes despite corrupted data.

## 5.7 Worked UART Transfer: 9600 8N1

_9600 8N1_ — $9600$ baud, $8$ data bits, no parity, $1$ stop bit — is one of the most commonly used serial configurations.

> [!example] **Transmitting "OK" in $9600$ 8N1**
> A device sending the ASCII characters `O` and `K` creates two separate packets:
> 
> - `O` → ASCII $79$ → binary `01001111` → sent LSB first: `1 1 1 1 0 0 1 0`
> - `K` → ASCII $75$ → binary `01001011` → sent LSB first: `1 1 0 1 0 0 1 0`
> 
> Each packet is framed with a start bit (`0`) and a stop bit (`1`), giving $10$ bits per byte:
> 
> | Bit Position | Start | D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | Stop |
> |---|---|---|---|---|---|---|---|---|---|---|
> | `O` | $0$ | $1$ | $1$ | $1$ | $1$ | $0$ | $0$ | $1$ | $0$ | $1$ |
> | `K` | $0$ | $1$ | $1$ | $0$ | $1$ | $0$ | $0$ | $1$ | $0$ | $1$ |
> _Table 5.2: UART bit order and framing for O and K at $9600$ 8N1._
> 
> ![[Pasted image 20261015152430.png]]
> _Figure 5.4: Two UART frames carrying O and K at $9600$ 8N1. Image unavailable in the supplied files; description is based on source context._
> 
> At $9600\,\mathrm{bps}$, each bit is held for $t_{\text{bit}} = \frac{1}{9600}\,\mathrm{s} \approx 104\,\mu\mathrm{s}$.
> 
> Since each byte requires $10$ bits on the wire ($1+8+1=10$: start, data, and stop), the effective throughput is:
> $$\frac{9600 \;\text{bps}}{10 \;\text{bits/byte}} = 960 \;\text{bytes/second}$$
>
> **Breakdown:** $9600$ is the wire bit rate; $10$ is the total framed bits per $8$-bit character; $960$ is the maximum payload bytes per second with no gaps.
> ✓ Check: $960\cdot10=9600$. The two frames require $20/9600\,\mathrm{s}\approx2.083\,\mathrm{ms}$; $2\cdot10=20$ transmitted bits.

The throughput calculation depends on the start/data/stop structure in [[#5.6 Framing the Data]], not just the nominal baud rate.

## 5.8 Wiring and Hardware

A conventional full-duplex logic-level UART link uses receive (RX) and transmit (TX) signal pins, plus a common ground (GND) reference unless an isolated interface supplies the required reference arrangement. Wire counts in this note count signals, not power or ground.

> [!warning] Correction: Two UART signals are not the whole electrical connection. A common reference is normally required; one-direction links still need that reference.
![[Pasted image 20261015152452.png]]
_Figure 5.5: Cross-connected UART transmit and receive signals. Image unavailable in the supplied files; description is based on source context._

**RX and TX Are Relative to the Device**
The RX and TX labels refer to the device itself: connect one device's TX to the other's RX and vice versa for a direct logic-level UART link. Connect compatible grounds. Do not connect supply rails merely because both are labeled `VCC`; check power architecture and voltage compatibility.

> [!warning] Correction: The source's VCC-to-VCC analogy is not a safe general wiring rule; separately powered supply outputs must not be joined indiscriminately.

> [!info] Definition: Duplex and simplex
> Full duplex allows simultaneous traffic in both directions. Half duplex allows both directions but requires turns. Simplex permits only one direction.

> [!example] Duplex modes
> Two UARTs with separate TX and RX paths can transmit simultaneously: full duplex. A shared direction-controlled RS-485 pair usually alternates direction: half duplex. A serial display that only receives is simplex. Signal-ground requirements remain applicable.

> [!warning] Correction: The source uses “single duplex” as a synonym for half-duplex. Use half-duplex for alternating two-way traffic, and simplex for one-way-only traffic.

> [!example] One-way UART display connection
> In some cases, only a single connection is needed. This is known as _simplex_ serial communication, where one device only transmits and the other only listens. An example is a serial-enabled LCD that receives display data but has nothing to send back — only a single wire from the master's TX to the listener's RX is required.


## 5.9 Hardware Implementation

At the signal level, serial communication can be implemented in a variety of ways. Two of the most popular hardware standards are _TTL_ (transistor-transistor logic) and _RS-232_.

> [!warning] Correction: The source mixes nominal RS-232 levels with receiver thresholds and treats all logic-level UARTs as TTL. RS-232 uses bipolar levels with inversion; $\pm 12\,\mathrm{V}$ or $\pm 13\,\mathrm{V}$ are examples, not mandatory fixed voltages. Modern $3.3\,\mathrm{V}$ logic may use different thresholds from TTL, so check datasheets.

**TTL vs. RS-232 Signaling**
| Feature | TTL Serial | RS-232 |
|---|---|---|
| **Voltage range** | $0\,\mathrm{V}$ to VCC (typically $3.3\,\mathrm{V}$ or $5\,\mathrm{V}$) | Bipolar signaling; receiver logic thresholds below $-3\,\mathrm{V}$ and above $+3\,\mathrm{V}$; driver levels depend on load and transceiver |
| **Idle / Logic $1$ / Stop bit** | High (VCC level) | Low (negative voltage) |
| **Start bit / Logic 0** | Low ($0\,\mathrm{V}$ / GND) | High (positive voltage) |
| **Typical use** | Microcontrollers, low-level ICs | Older computers and peripherals |
| **Long-range suitability** | Poor — low voltages are susceptible to signal loss | Good — higher voltages tolerate longer lines |
_Table 5.3: Logic-level UART versus RS-232 electrical signaling._

_Logic-level UART_ commonly connects nearby microcontrollers and integrated circuits. The loose label “TTL serial” does not specify the actual output levels or input thresholds of every device. Signals are typically near ground and the supply rail; voltage compatibility must be checked. These direct connections are simple but vulnerable to degradation over long lines.
![[Pasted image 20261015152548.png]]
_Figure 5.6: Logic-level UART signaling. Image unavailable in the supplied files; description is based on source context._

_RS-232_ inverts the TTL logic convention: a negative voltage represents the idle state and a logic 1, while a positive voltage represents a start bit or logic 0. It is generally more suitable for cables than raw logic-level UART signals, but allowable distance depends on rate and loading. Recommended Standard 485 (RS-485) uses differential signaling and is often preferable for longer or noisy links. A MAX232 transceiver is a common translator between $5\,\mathrm{V}$ logic and bipolar RS-232 signaling.
![[Pasted image 20261015152600.png]]
_Figure 5.7: Bipolar and inverted RS-232 signaling. Image unavailable in the supplied files; description is based on source context._

> [!important] **Signal Voltage Matching**
> When connecting two serial devices, their signal voltage standards **must** match. A logic-level device cannot be directly connected to RS-232: use an RS-232 transceiver that handles both voltage conversion and inversion. A generic logic-level shifter is not sufficient.

> [!example] Electrical translation
> To attach a $5\,\mathrm{V}$ microcontroller UART to an RS-232 port, route signals through a compatible MAX232-type transceiver. A microcontroller-high idle level becomes a negative RS-232 idle voltage; connecting the raw pins directly is unsafe.

## 5.10 UART Hardware

The final piece of the serial communication puzzle is the hardware responsible for creating serial packets and controlling the physical data lines: the _UART_.
![[Pasted image 20261015152844.png]]
_Figure 5.8: UART conversion between parallel data and serial signals. Image unavailable in the supplied files; description is based on source context._

> [!info] Definition: UART
> A UART converts parallel characters into timed serial frames and reconstructs received serial frames as parallel characters. Its processor-side interface carries data and control information; its serial side uses TX and RX signals.

> [!example] UART availability on Uno and Mega
> UARTs exist as stand-alone integrated circuits, but they are more commonly built directly into microcontrollers. The number of UARTs varies by chip: some have none, some have one, and some have many. For example, the ATmega328P (used in the classic Arduino Uno R3) has a single UART, while the ATmega2560 (used in the Arduino Mega) has four.
> ![[Pasted image 20261015153043.png]]
> _Figure 5.9: Internal UART block diagram attributed in the source to the Exar ST16C550 datasheet. Image unavailable in the supplied files; description is based on source context._

**UART Transmit and Receive Roles**
- **Transmit side:** The UART assembles the data packet by appending synchronization bits and, when enabled, parity bits, then sends the packet out the TX line with precise timing dictated by the configured baud rate.
- **Receive side:** The UART samples the RX line at the expected baud rate, identifies the sync bits, and extracts the data payload.

More advanced UARTs buffer received data until the microcontroller reads it; storage capacity varies widely by implementation.

> [!info] Definition: Receive buffer and FIFO
> A receive buffer temporarily holds incoming data. A first-in-first-out (FIFO) buffer releases characters in arrival order; it delays data loss only until its finite capacity is exhausted.

> [!example] Receive buffering
> If bytes `A`, `B`, and `C` arrive while the processor is busy, a FIFO preserves that arrival order. Reading returns `A` first; if software waits longer than the available buffer capacity permits, later bytes can be lost.

## 5.11 Software UARTs

> [!info] Definition: Bit-banging
> Bit-banging implements a communication interface by controlling signal states and timing in software rather than delegating bit transfer to dedicated peripheral hardware.

> [!example] SoftwareSerial as a software UART
> When hardware UARTs are unavailable or already occupied, Arduino's `SoftwareSerial` can implement another serial link by timing signal changes in software. Its timing and simultaneous-transmission limitations depend on the implementation.

**Bit-Banging Trade-offs**
Bit-banging works in a pinch but is processor-intensive and generally less precise than a dedicated hardware UART. It is best suited for low-speed or occasional serial communication when hardware UARTs are unavailable.

> [!example] Software timing cost
> A bit-banged transmitter must hold each bit for the chosen bit interval. An interrupt that delays an edge can stretch a bit and corrupt reception. Dedicated UART hardware maintains bit timing independently of ordinary instruction scheduling.

## 5.12 Common Pitfalls

Even experienced engineers can fall into a few recurring mistakes when working with serial communication.

### RX-to-TX, TX-to-RX

As straightforward as it sounds, forgetting to cross the RX and TX lines between devices is a surprisingly common error. Despite the temptation to match labels directly, **always** connect RX to TX and TX to RX between serial devices.

### Baud Rate Mismatch

Baud rates function like the shared language of serial communication. If two devices are not configured to the same speed, data will be misinterpreted or missed entirely. If the receiving device is seeing garbage on its receive line, a baud rate mismatch is one of the first things to check.
![[Pasted image 20261015153236.png]]
_Figure 5.10: Baud mismatch: 9600-bps transmission sampled at $19200\,\mathrm{bps}$. Image unavailable in the supplied files; description is based on source context._

### Bus Contention

A basic push-pull UART connection is normally point-to-point. Multiple transmitters must not directly drive the same signal without a suitable electrical interface and access-control scheme; otherwise _bus contention_ occurs.

> [!warning] Correction: The two-device restriction belongs to the basic UART wiring arrangement, not all serial protocols. Addressed multidrop systems can use suitable transceivers, including RS-485.

> [!warning] **Bus Contention Risks**
> When two devices drive the same transmit line at the same time, the best-case outcome is that neither device's data gets through. In the worst case, the conflicting signals can damage the transmit circuitry of one or both devices — so never rely on undocumented output protection.

> [!example] GPS and USB converter output conflict
> A practical example: when connecting a GPS module to a microcontroller, the GPS module's TX line connects to the microcontroller's RX line. However, that same RX pin may already be wired to the TX pin of a USB-to-serial converter (used for programming and serial monitoring). This creates a situation where both the GPS module and the USB converter could try to drive the same line simultaneously.
> ![[Pasted image 20261015153251.png]]
> _Figure 5.11: Potential bus contention involving multiple UART transmitters. Image unavailable in the supplied files; description is based on source context._
![[Pasted image 20261015153321.png]]
_Figure 5.12: Second wiring illustration associated with the multiple-transmitter contention discussion. Image unavailable in the supplied files; description is based on source context._

> [!example] Multiple Receivers on a Single Transmitter
> It is generally safe to connect multiple _receiving_ devices to a single _transmitting_ device, since only one device controls the line. For example, a serial LCD's RX line can share the microcontroller's TX line alongside a USB programmer's RX line. However, this approach has a firmware-level risk: every device on the line hears every transmission, which could cause unintended behavior if a device receives data not meant for it.

---

## 5.13 Serial Peripheral Interface (SPI)

### Introduction

_Serial Peripheral Interface_ (SPI) is an interface bus commonly used to send data between microcontrollers and small peripherals such as _shift registers_, _sensors_, and _SD cards_. Unlike asynchronous serial, SPI uses separate _clock_ and _data_ lines, along with a _select line_ to choose which device to communicate with.

### What's Wrong with Serial Ports?

A standard serial port with TX and RX lines is _asynchronous_ — there is no shared control over when data is sent, and no guarantee that both sides are running at precisely the same rate. Since digital systems rely on synchronization to a single clock (typically a main crystal oscillator), communication between two systems with slightly different clocks can be problematic.
![[Pasted image 20261015153540.png]]
_Figure 5.13: Asynchronous transmission and independent clock timing. Image unavailable in the supplied files; description is based on source context._

To work around this, asynchronous serial connections add extra _start_ and _stop_ bits to each byte, helping the receiver re-synchronize as data arrives. Both sides must also agree on a transmission speed (e.g., $9600\,\mathrm{bps}$) in advance. Slight differences in clock rate are tolerable because the receiver re-syncs at the start of every byte.

> [!example] LSB-First Bit Ordering
> Conventional UARTs transmit the _least significant bit_ (LSB) first, meaning the smallest bit appears earliest in the transmission. For example, the byte `0x53` (binary `01010011`) would be sent over the wire as `11001010` — the bit order is reversed from the conventional written representation. The lower nibble (`0011` = `0x3`) is sent first as `1100`, followed by the upper nibble (`0101` = `0x5`) as `1010`.
> ✓ Check: reversing `01010011` gives `11001010`; the transmitted order does not change the byte value.

While asynchronous serial works well, it carries significant overhead:

- **Bit overhead:** Extra start and stop bits are appended to every byte.
- **Hardware complexity:** More complex circuitry is required to reliably send and receive data without a shared clock.
- **Timing sensitivity:** The receiver samples bits at very specific moments. If the two sides are not set to the same baud rate, the receiver samples at the wrong times and the data comes through as garbage.

### A Synchronous Solution

SPI operates as a _synchronous_ data bus, using separate lines for data and a _clock_ signal that keeps the receiver synchronized to the transmitted clock within the device's setup, hold, and propagation-delay limits. The clock is an oscillating signal that tells the receiver exactly when to sample bits on the data line. Sampling occurs on either the _rising edge_ (low to high) or the _falling edge_ (high to low) of the clock signal — the specific edge to use is defined in the device's datasheet. When the receiver detects the designated edge, it immediately reads the current state of the data line to capture the next bit.
![[Pasted image 20261015153633.png]]
_Figure 5.14: Synchronous SPI clock and data timing. Image unavailable in the supplied files; description is based on source context._

Because the clock signal travels alongside the data, there is no need to pre-agree on a transmission speed the way asynchronous serial requires. However, every device does have a maximum clock speed at which it can reliably operate.

> [!info] Definition: Setup and hold time
> Setup time is the minimum interval for which data must be stable before its sampling edge. Hold time is the minimum stable interval after that edge.

> [!example] Stable data around the sampling edge
> Suppose a hypothetical peripheral requires $10\,\mathrm{ns}$ setup and $5\,\mathrm{ns}$ hold. For a sampling edge at $100\,\mathrm{ns}$, data must be stable from $90$ through $105\,\mathrm{ns}$. Changing it at $98\,\mathrm{ns}$ violates setup time even if SCK has the correct frequency. ✓ Check: $100-10=90$ and $100+5=105$.

**Why SPI Hardware Is Simpler**
A key reason for SPI's popularity is that the receiving hardware can be as simple as a _shift register_. This is significantly simpler and cheaper than the full _UART_ (Universal Asynchronous Receiver/Transmitter) required for asynchronous serial communication.

### Receiving Data

**SPI Terminology Update**
The embedded community has moved away from the terms "Master" and "Slave" in favor of "Controller" and "Peripheral" (or "Target"). The updated signal names are:

| Legacy name | Replacement Name |
|---|---|
| Master | Controller |
| Slave | Peripheral |
| MISO | POCI (Peripheral Out / Controller In) |
| MOSI | PICO (Peripheral In / Controller Out) |
| SS | CS (Chip Select) |
_Table 5.4: Legacy and alternative SPI naming conventions._

Naming conventions may still vary by manufacturer, programming language, or organization.

In SPI, only one side generates the clock signal, typically labeled _CLK_ or _SCK_ (Serial ClocK). The device that generates the clock is the **controller** (almost always the microcontroller), and the other side is the **peripheral**. The ordinary SPI arrangement has one active controller and potentially multiple peripherals; multi-controller operation requires additional coordination not supplied by a general SPI arbitration protocol.

Data flows between controller and peripheral on two dedicated lines:

- **PICO** (_Peripheral In / Controller Out_): Carries data from the controller to the peripheral.
- **POCI** (_Peripheral Out / Controller In_): Carries data from the peripheral back to the controller.

When the controller needs to receive data from a peripheral, it continues generating a _prearranged_ number of clock cycles, during which the peripheral places its response onto the POCI line. Because the controller is the sole clock generator, it must know in advance when a peripheral will return data and how much. This is a fundamental difference from asynchronous serial, where arbitrary amounts of data can be sent in either direction at any time.
![[Pasted image 20261015153751.png]]
_Figure 5.15: SPI response data clocked by the controller. Image unavailable in the supplied files; description is based on source context._

> [!example] Handling Variable-Length Responses
> In practice, the prearranged data requirement is rarely a problem because SPI peripherals (such as sensors) typically follow a specific command structure. For example, a "read data" command might always return exactly two bytes. If a variable amount of data is needed, the peripheral can first return one or two bytes specifying the data length, and the controller can then clock out the full amount.

> [!example] Simultaneous SPI request and previous result
> SPI is a _full-duplex_ protocol — it has separate send and receive lines — which means that in certain situations data can be transmitted and received simultaneously. For instance, a controller could request a new sensor reading while retrieving the result of the previous one. Whether this is supported depends on the specific device and its datasheet.

> [!example] Clocking a response
> For a sensor whose read command returns two bytes, the controller sends the command, then supplies $16$ further clock pulses to receive the two $8$-bit bytes. Dummy outgoing bytes generate those pulses; their values follow the datasheet. ✓ Check: $2\cdot8=16$.

### Chip Select (CS)

> [!info] Definition: Chip select
> Chip select (CS) selects which SPI peripheral participates in a transaction. For a conventional active-low CS, low means selected and high means deselected; selection does not inherently mean waking from a low-power state.

> [!example] Select one peripheral
> To access sensor A on a bus also containing sensor B, hold B's CS high, drive A's CS low, transfer the specified command and response, then drive A's CS high. Follow each device's select setup/hold times.

A conventional active-low chip select (CS) is held high when the peripheral is not selected, and low during its transaction. A compatible deselected peripheral releases its POCI output so another peripheral can respond. Selection does not necessarily wake a device from a power-saving mode. Some shift-register designs use a separate latch input to transfer shifted bits to output pins.

> [!warning] Correction: CS is not universally a shift-register latch. Latch and select behavior is device-specific; consult the timing diagram rather than treating these pins as interchangeable.


### Multiple Peripherals

There are two common ways to connect multiple peripherals to a single SPI bus.

**Individual CS Lines**
![[Pasted image 20261015155025.png]]
_Figure 5.16: SPI peripherals with individual chip-select signals. Image unavailable in the supplied files; description is based on source context._
Each peripheral gets its own dedicated CS line. To communicate with a specific device, the controller pulls that device's CS line low while keeping all others high. Activating two peripherals at the same time must be avoided, as both may attempt to drive the POCI line simultaneously, resulting in garbled data.

**Running Low on CS Pins?**
If you have many peripherals and are running out of output pins, _binary decoder chips_ can be used to multiply the number of available CS lines from a smaller set of controller outputs.

> [!info] Definition: Binary decoder selection
> A binary decoder maps a binary input code to one selected output. With suitable output polarity and enable control, it can provide separate active-low CS signals using fewer controller address pins.

> [!example] Selecting one of eight SPI peripherals
> A three-input decoder has $2^3=8$ possible selections. With active-low outputs, input `101` selects output five while the others remain high. Disable the decoder while changing the selection inputs to avoid unintended selects, then enable it for the transfer. ✓ Check: $1\cdot4+0\cdot2+1=5$.

**Daisy-Chaining**
![[Pasted image 20261015155030.png]]
_Figure 5.17: Daisy-chained SPI peripherals with shared selection or latch control. Image unavailable in the supplied files; description is based on source context._
Some devices are designed to be _daisy-chained_: the POCI output of one peripheral connects to the PICO input of the next, forming a chain. A single shared CS line connects to all peripherals in the chain. Data shifts from one device to the next. Devices documented to latch on the rising edge of a shared CS or latch input update their outputs together at that edge; this behavior is not universal. This approach is commonly used with daisy-chained shift registers and addressable LED drivers.

**Daisy-Chain Considerations**
- To send data to any peripheral in the chain, you must transmit enough data to fill _all_ peripherals in the chain.
- The first piece of data transmitted ends up in the _last_ peripheral in the chain.
- This layout is often output-only; the controller's POCI input can then remain disconnected.
- If return data is needed, the daisy-chain loop can be closed by connecting the last peripheral's POCI back to the controller. However, the return data from the first peripheral must pass through all subsequent peripherals before reaching the controller, so enough clock cycles must be generated to shift the full response back.

> [!example] Two-device daisy chain
> For two $8$-bit output registers driving LEDs, send the far device's byte first and the near device's byte second, then latch. After $16$ clock pulses the first byte is in the far register. ✓ Check: $2\cdot8=16$ bits fill both registers.

The hardware byte exchange and completion flags are developed in [[#5.19 ATmega SPI Operation and Registers]].

### Programming for SPI

Many microcontrollers include built-in SPI hardware peripherals that handle the details of sending and receiving data at very high speeds. However, the SPI protocol is also simple enough that you can write your own _bit-banging_ routines to manually manipulate I/O lines in the correct sequence.

On Arduino, there are two main approaches to SPI communication:

- **`shiftIn()` and `shiftOut()`**: Software-based commands that work on any group of pins but are relatively slow.
- **SPI Library**: Leverages the microcontroller's built-in SPI hardware for vastly faster transfers, but only works on specific designated pins.

### Configuration Options

When setting up an SPI interface, several options must be configured to match the requirements of the peripheral device (check the device's datasheet):

**SPI Configuration Parameters**
- **Bit Order:** Data can be sent _most-significant bit_ (MSB) first or _least-significant bit_ (LSB) first. In the Arduino SPI library, this is set with `setBitOrder()`.
- **Data Mode:** Determines which clock edge the peripheral reads data on (rising or falling) and whether the clock is considered idle when high or low. In the Arduino SPI library, both settings are controlled by `setDataMode()`.
- **Clock Speed:** SPI can operate at extremely high speeds (millions of bytes per second), which may exceed what some peripherals can handle. The data rate can be reduced using `setClockDivider()`, which divides the controller's system clock ($16\,\mathrm{MHz}$ on the classic Uno R3 and Mega 2560) down to a range between $8\,\mathrm{MHz}$ ($\div2$) and $125\,\mathrm{kHz}$ ($\div128$).

> [!example] Classic Uno SPI configuration
> At a $16\,\mathrm{MHz}$ system clock, divide by $8$ to obtain $2\,\mathrm{MHz}$ SCK for a peripheral that permits that rate. Select the required bit order and clock mode too. ✓ Check: $2\,\mathrm{MHz}\cdot8=16\,\mathrm{MHz}$. Modern Arduino code typically uses `SPI.beginTransaction(SPISettings(2000000, MSBFIRST, SPI_MODE0))` and `SPI.endTransaction()`; the legacy setters in the source remain useful for understanding each setting.

The sampling-edge requirements are explained under [[#A Synchronous Solution]]; the hardware `CPOL` and `CPHA` controls appear in [[#5.19 ATmega SPI Operation and Registers]].

### Pin Requirements

On the classic ATmega328/P, hardware SPI uses its designated SCK, MOSI/PICO, and MISO/POCI pins. In controller mode, configuring the hardware SS pin as an output prevents an externally low SS input from forcing peripheral mode. Other output pins may select additional peripherals. Other microcontrollers can have different pin-multiplexing and SS behavior.

> [!warning] Correction: The source states the SS-output requirement as universal. It is an AVR controller-mode precaution: on the ATmega328/P an input SS pin driven low clears MSTR; other implementations differ.

**CS Pin Handling**
With the classic Arduino SPI interface, software normally pulls CS low before a transaction and high afterward. Some board-specific interfaces, including supported Arduino Due configurations, offer hardware-assisted CS; this depends on the peripheral and library interface, not simply the board's age.

## 5.14 I2C

### Introduction

The _Inter-Integrated Circuit_ (I2C) protocol allows multiple "peripheral" digital integrated circuits to communicate with one or more "controller" chips. Like SPI, it is intended for short-distance communication within a single device. Like asynchronous serial (UART, RS-232), it requires only **two signal wires** to exchange information.

**Terminology Update**
The terms "master" and "slave" are considered obsolete and have been replaced with **controller** and **peripheral**, respectively. Naming conventions may vary by manufacturer or organization (e.g., main/secondary, initiator/responder, source/replica).

### Why Use I2C?

Understanding I2C's advantages requires comparing it to the alternatives.

**Drawbacks of Asynchronous Serial (UART):**
- Devices must pre-agree on a data rate and maintain closely matched clocks; excessive clock drift causes garbled data.
- Hardware overhead is significant — UARTs are relatively complex and difficult to implement in software.
- Each $8$-bit data byte requires at least $10$ bits of transmission time (start + $8$ data + stop), reducing effective throughput.
- Direct push-pull UART wiring is normally point-to-point; uncontrolled multiple transmitters risk contention. Suitable transceivers and an access protocol can support multidrop links (see Section 5.12).
- Maximum UART rates vary by hardware and clock configuration; do not assume a universal ceiling.

> [!warning] Correction: The source's $230400\,\mathrm{bps}$ ceiling is not a general UART limit.

**Drawbacks of SPI:**
- Requires **four lines** for a single controller-peripheral pair, plus one additional chip select pin per extra peripheral. Pin count grows rapidly.
- Normally uses a **single active controller**; unlike I2C, ordinary SPI provides no standard multi-controller arbitration.
- Large connection counts complicate PCB routing in tight layouts.
- On the positive side, SPI excels at high data rates ($10\,\mathrm{MHz}$ and above) and full-duplex communication, with simple shift-register hardware.

**I2C: The Best of Both Worlds**
| Feature | Asynchronous Serial | SPI | I2C |
|---|---|---|---|
| **Wires required** | $2$ (TX, RX) | $4$+ (SCK, PICO, POCI, CS) | $2$ (SDA, SCL) |
| **Peripheral capacity** | Normally one peer for a direct UART link | Many; select pins and loading constrain count | Normally $112$ usable $7$-bit addresses; $10$-bit addressing expands the address space |
| **Multi-controller** | No | No | Yes |
| **Rate context** | Device-specific bit rate | Device-specific clock; $10\,\mathrm{MHz}$ and above is possible | Common clock rates: $100\,\mathrm{kHz}$ or $400\,\mathrm{kHz}$ |
| **Hardware complexity** | High (UART) | Low (shift register) | Moderate |
| **Duplex** | Full | Full | Half |
_Table 5.5: Comparison of ordinary UART, SPI, and I2C arrangements._

> [!warning] Correction: The original $1008$-peripheral figure is not a general I2C capacity. Ten-bit addressing provides $1024$ address values, while actual device count depends on address support and electrical loading.


I2C combines the two-wire simplicity of asynchronous serial with the multi-device and multi-controller support that SPI lacks. The trade-off is a moderate data rate and a small overhead of one ACK/NACK bit per $8$-bit data frame.

## 5.15 I2C at the Hardware Level

### Signals

Each I2C bus consists of two signals:

- **SDA** (Serial Data): The bidirectional data line.
- **SCL** (Serial Clock): The clock signal, always generated by the current bus controller.

Peripheral devices may occasionally hold SCL low to delay the controller — a mechanism called _clock stretching_ — giving the peripheral more time to prepare or process data.

> [!info] Definition: Open-Drain Drivers
> Unlike UART or SPI, I2C bus drivers are _open-drain_: they can pull a signal line **low** but cannot actively drive it **high**. Each signal line uses a _pull-up resistor_ to restore the line to a high state when no device is asserting it low. This avoids opposing high-versus-low output drive among compliant open-drain devices. Logical collisions still require arbitration, and a device holding a line low can stall the bus.

> [!example] Wired-low behavior
> When device A pulls SDA low and device B releases it, the bus remains low. Once both release it, the pull-up raises SDA. A peripheral stretching SCL similarly keeps the clock low until it is ready.

> [!warning] Correction: Open-drain signaling prevents push-pull electrical conflict, not all logical contention, stuck-bus faults, or wiring damage.

A common starting pull-up value is $4.7\,\mathrm{k\Omega}$, but select the final resistance from bus capacitance, rise-time limits, supply voltage, and device low-level sink-current limits. Parallel pull-ups reduce the equivalent resistance and may overload drivers. Longer wiring increases capacitance and noise exposure; lower resistance helps rise time only within sink-current limits.

> [!warning] Correction: I2C does not guarantee reliable operation over $2$–$3$ metres. Cable length, capacitance, speed, and buffering must be evaluated together; do not simply lower pull-up resistance without checking current.
![[Pasted image 20261015160722.png]]
_Figure 5.18: I2C wiring with separate SDA and SCL pull-up resistors. Image unavailable in the supplied files; description is based on source context._
> [!example] Parallel pull-up resistors
> Two $4.7\,\mathrm{k\Omega}$ pull-ups on the same line act as $2.35\,\mathrm{k\Omega}$. At $3.3\,\mathrm{V}$ and an ideal zero-volt low, they draw about $1.40\,\mathrm{mA}$. ✓ Check: $4700/2=2350\,\Omega$ and $(3.3/2350)\cdot2350=3.3\,\mathrm{V}$. Check actual low-level voltage and sink-current ratings.

For the arbitration rules that handle logical collisions, see [[#5.16 Protocol]].

### Signal Logic Levels

I2C voltage compatibility depends on each device's input thresholds, pin-voltage limits, and pull-up supply. Open-drain outputs alone do not make every voltage combination compatible.

> [!example] Mixed-voltage bus
> A $5\,\mathrm{V}$ device and a $3.3\,\mathrm{V}$ device may share pull-ups to $3.3\,\mathrm{V}$ if that voltage satisfies both devices' high-level thresholds and pin ratings. If a $5\,\mathrm{V}$ and $2.5\,\mathrm{V}$ combination fails those checks, use an appropriate bidirectional I2C level translator, such as a compatible PCA9306 circuit.

> [!warning] **Voltage Mismatch Caution**
> Use level translation when thresholds or pin ratings require it. Some translators have an enable input that isolates a bus segment; separate controllable segments can help access peripherals with identical addresses. Check that disabled segments are actually isolated and correctly pulled up.

## 5.16 Protocol

I2C communication follows a strict protocol so that all devices on the bus can recognize valid transmissions. Most peripherals handle the low-level details automatically.

### Basics

I2C messages consist of two frame types:

1. **Address frame:** The controller specifies which peripheral the message is intended for.
2. **Data frame(s):** One or more $8$-bit data messages passed between controller and peripheral.

Data is placed on the SDA line after SCL goes low and is sampled after SCL goes high. Data must meet the selected I2C mode's setup and hold times, as well as the devices' requirements.
![[Pasted image 20261015160903.png]]
_Figure 5.19: I2C address and data transaction timing. Image unavailable in the supplied files; description is based on source context._

### Start Condition

> [!info] Definition: Start Condition
> To initiate communication, the controller leaves SCL **high** and pulls SDA from **high to low**. This signals all peripherals that a transmission is about to begin. If controllers begin together, arbitration continues bit by bit while SCL is high. A controller that releases SDA to send a one but observes a zero loses arbitration and stops driving the transfer.

> [!example] START and arbitration
> Controllers attempting address bytes `0xA0` and `0xA2` send the same first six bits. At the next differing bit, the `0xA2` sender releases SDA for a one but sees the other controller's zero, so it loses arbitration. ✓ Check: `0xA0 = 10100000`, `0xA2 = 10100010`; the first differing position is bit 1.

> [!warning] Correction: I2C arbitration is not decided simply by which controller produces START first; the transmitted address/data bits determine arbitration when transfers overlap.

_Repeated START_ allows a controller to begin another addressed transfer without releasing the bus; see [[#Combined write-read transaction]].

### Address Frame

The address frame is always the first frame in any new communication sequence. For a standard $7$-bit address, the address is clocked out **MSB first**, followed by a single **R/W bit** indicating the operation:

- `1` = **Read** (controller will receive data from the peripheral)
- `0` = **Write** (controller will send data to the peripheral)

> [!info] Definition: ACK/NACK Bit
> The 9th bit of every frame (address and data alike) is the _ACK/NACK_ bit. After the first $8$ bits are sent, the receiving device takes control of SDA. If it pulls SDA **low** before the 9th clock pulse, it sends an **ACK** (acknowledge). If SDA remains **high**, it is a **NACK** (not acknowledge). Its meaning depends on context: an address NACK can mean no responding peripheral, whereas the controller normally NACKs the final byte of a read to request no more data. The controller then issues STOP or a repeated START as appropriate.

> [!example] Address byte and final read acknowledgement
> For a hypothetical peripheral at $7$-bit address `0x48`, the write address byte is `0x90` and the read address byte is `0x91`. For a two-byte read, the controller ACKs the first data byte, NACKs the second, and issues STOP. ✓ Check: $72\cdot2=144$ (hexadecimal `0x90`); setting the low read bit yields `0x91`.

> [!warning] Correction: A NACK is not always an error and does not by itself generate STOP. The final read byte is normally NACKed intentionally.

### Data Frames

After the address frame, the controller continues generating clock pulses and data is placed on SDA by either the controller or the peripheral, depending on the R/W bit. The number of data frames is arbitrary. Device-specific register behavior determines where successive bytes are read or written.

> [!info] Definition: Register auto-increment
> Auto-increment advances a peripheral's internal register pointer after a transferred data byte. It is a peripheral feature, not a universal I2C requirement.

> [!example] Reading consecutive registers
> For a peripheral that increments by one byte and starts at `0x10`, a three-byte read returns registers `0x10`, `0x11`, and `0x12` in that order. Check wrapping and side effects in its datasheet. ✓ Check: the register offsets are $0,1,2$; $16+2=18$, which is `0x12`.

### Stop Condition

> [!info] Definition: Stop Condition
> The controller generates a stop condition to end the transmission: a **low-to-high** transition on SDA while SCL is **high** (specifically, after SCL has already transitioned high). During normal data transfer, SDA must remain stable while SCL is high during ordinary data bits; a transition would instead signal START or STOP depending on its direction.

> [!example] STOP versus repeated START
> After writing a register-pointer byte, issue repeated START and address the same device for reading without releasing the bus. After the final read byte, NACK and issue STOP: SDA rises while SCL is high.

### Combined write-read transaction

The direction change at repeated START changes which device sends data, but the controller continues to supply SCL (subject to peripheral clock stretching). This sequence makes SDA ownership explicit; an ACK means the receiver pulls SDA low, while a NACK means it leaves SDA released.

> [!example] Read two bytes from a selected register
> Assume a peripheral at `0x48` accepts a register pointer `0x10` and supports auto-increment. The controller writes the pointer, issues repeated START, then reads two bytes without releasing the bus between the write and read phases.
>
> ```mermaid
> sequenceDiagram
>     participant C as Controller
>     participant P as Peripheral 0x48
>     Note over C,P: Controller supplies SCL and SDA ownership changes below
>     C->>P: START - controller pulls SDA low while SCL is high
>     C->>P: Address 0x90 (write) - controller sends SDA bits
>     P-->>C: ACK - peripheral pulls SDA low on ninth clock
>     C->>P: Register pointer 0x10 - controller sends SDA bits
>     P-->>C: ACK - peripheral pulls SDA low on ninth clock
>     C->>P: Repeated START - controller owns SDA transition
>     C->>P: Address 0x91 (read) - controller sends SDA bits
>     P-->>C: ACK - peripheral pulls SDA low on ninth clock
>     P->>C: First data byte - peripheral sends SDA bits
>     C-->>P: ACK - controller pulls SDA low on ninth clock
>     P->>C: Second data byte - peripheral sends SDA bits
>     C-->>P: NACK - controller leaves SDA released on ninth clock
>     C->>P: STOP - controller releases SDA high while SCL is high
> ```
> _Figure 5.20: Combined I2C register-pointer write and two-byte read, showing SDA ownership and the controller's final NACK. Arrows indicate logical direction on one shared open-drain data line, not separate physical wires._
>
> Both devices release SDA when not responsible for a bit; a transmitted high is a released line, not an actively driven high. START and STOP have no ACK clock of their own. ✓ Check: $72\cdot2=144$ gives `0x90`; adding the read bit gives $145$, or `0x91`. Five transferred bytes (two addresses, one pointer, two data bytes) each use nine clocks: $5\cdot9=45$, excluding bus-condition timing and any clock stretching.

See [[#5.15 I2C at the Hardware Level]] for open-drain signaling and [[#5.20 Two-Wire Serial Interface]] for the corresponding hardware controls.


## 5.17 Character Encoding and Signal Coding

The ATmega328 family includes three serial subsystems: the Universal Synchronous and Asynchronous Receiver and Transmitter (USART), SPI, and the Two-Wire Interface (TWI). Their common feature is serial bit transfer; timing, wiring, addressing, and electrical behavior differ.

> [!info] Definition: Non-Return-to-Zero coding
> Non-Return-to-Zero (NRZ) coding holds each bit's logic level for its whole bit interval; it does not insert a return to zero between equal consecutive bits. At the microcontroller pin, a one is high and a zero is low.

> [!example] Consecutive equal bits
> Sending `1110` with NRZ holds the line high for three bit intervals, then low for one. A receiver therefore needs timing information even when no transition occurs. ✓ Check: $3+1=4$ bit intervals.

> [!info] Definition: Character encoding
> American Standard Code for Information Interchange (ASCII) maps characters to $7$-bit values. Unicode defines a much larger character repertoire; its encodings include UTF-8 (Unicode Transformation Format, $8$-bit units) and UTF-16 ($16$-bit units).

> [!example] ASCII and Unicode
> Capital `G` has ASCII value `0x47`; the `0x` prefix denotes hexadecimal in C. Its Unicode code point is `U+0047`. UTF-8 represents ASCII characters with the same single-byte values. ✓ Check: $4\cdot16+7=71$, the decimal ASCII value of `G`.

> [!warning] Correction: Unicode is not a fixed $16$-bit counterpart of ASCII. Its code space extends beyond $16$ bits; UTF-16 uses one or two $16$-bit code units for a character's code point. ASCII is a subset of Unicode.

![[Pasted image 20261015161231.png]]
_Figure 5.21: ASCII code chart; 0x denotes hexadecimal in C. Image unavailable in the supplied files; description is based on source context._

## 5.18 Serial USART

The _USART_ provides full-duplex (two-way) communication through independent transmitter and receiver hardware. The ATmega328 is equipped with a single USART channel. While the USART supports both asynchronous and synchronous modes, it is most commonly used in **asynchronous** mode, where start and stop framing bits maintain synchronization in the absence of a shared clock.

The ATmega USART is highly configurable:

- Variable baud rates
- Data widths of $5$–$9$ bits
- One or two stop bits
- Hardware-generated parity (even or odd) with parity checking at the receiver

### System Overview

The USART hardware consists of four main components: a _clock generator_, _transmitter hardware_, _receiver hardware_, and three control/status registers (`UCSR0A`, `UCSR0B`, `UCSR0C`).
![[Pasted image 20261015161250.png]]
_Figure 5.22: AVR USART block diagram attributed to Microchip in the source. Image unavailable in the supplied files; description is based on source context._

#### USART Clock Generator

The clock generator derives the USART baud rate from the microcontroller's system clock. The system clock is divided by the contents of the _USART Baud Rate Registers_ (`UBRR0H` and `UBRR0L`, collectively referred to as `UBRR`) and additional internal dividers.

> [!example] USART baud divisor: formula and worked calculation
> $$\text{Baud Rate} = \frac{f_{\text{sys}}}{16 \times (\text{UBRR} + 1)}$$
>
> Solving for $\mathrm{UBRR}$:
> $$\text{UBRR} = \frac{f_{\text{sys}}}{16 \times \text{Baud Rate}} - 1$$
>
> **Breakdown:**
> - $f_{\text{sys}}$ : The system clock frequency of the microcontroller (e.g., $16\,\mathrm{MHz}$).
> - $\text{UBRR}$ : The $12$-bit value ($0$–$4095$) stored across the `UBRR0H` and `UBRR0L` registers. This is the divisor that sets the baud rate.
> - $16$ : A fixed internal prescaler used in asynchronous normal mode (when the `U2X0` bit is $0$).
> - $\text{Baud Rate}$ : The resulting data transmission rate in bits per second.
>
> **Worked calculation:**
> In asynchronous normal mode, target $9600$ baud using $\mathrm{UBRR}=16{,}000{,}000/(16\cdot9600)-1\approx103.167$. Choose integer $103$. The actual baud rate is $16{,}000{,}000/(16\cdot104)\approx9615.385$, about $+0.1603\%$ error. ✓ Check: $9615.384615\cdot16\cdot104\approx16{,}000{,}000$. Store zero in `UBRR0H` and `103` in `UBRR0L`; this result assumes `U2X0 = 0`.

#### USART Transmitter

The transmitter centers on a _Transmit Shift Register_. Data is loaded into this register via the _USART I/O Data Register_ (`UDR0`). In asynchronous mode, the hardware appends start/stop bits and adds a parity bit only if parity is enabled. Data is then shifted out through the `TxD` pin, one bit at a time, at the configured baud rate.

Two status flags monitor the transmitter:

- **UDRE0** (USART Data Register Empty): Read-only status; set when the transmit buffer can accept a new character. Loading `UDR0` clears it until the buffer becomes available again.

> [!warning] Correction: UDRE0 is a read-only status flag; software does not clear it by writing zero to UCSR0A. Preserve configuration bits and handle write-one-to-clear flags separately.
- **TXC0** (Transmit Complete): Set when the entire frame has been shifted out of the Transmit Shift Register and no new data is in the transmit buffer. Cleared by writing a logic one to it.

> [!example] Buffer empty versus wire idle
> When `UDRE0` becomes set, software can queue another byte even if the previous one is still shifting out. To know the entire final frame has left the pin, use `TXC0`, clearing any stale completion flag appropriately before the transfer.

#### USART Receiver

The receiver mirrors the transmitter with reversed data flow. Data arrives one bit at a time via the `RxD` pin at the configured baud rate. The receiver includes:

- **RXC0** (Receive Complete): Set to logic one when unread data exists in the receive buffer.

> [!example] Receiving a character
> Poll `RXC0` or use a receive interrupt, examine status as required for error reporting, then read `UDR0`. Leaving received characters unread risks buffer overrun; the status and data belong to the received frame.

#### USART Registers

On the ATmega328/P, `UCSR0C` and `UBRR0H` have separate addresses. The USART register names include channel index `0`: `UCSR0A`, `UCSR0B`, `UCSR0C`, `UBRR0H`, `UBRR0L`, and `UDR0`.

> [!warning] Correction: The shared UCSRC/UBRRH address and URSEL selection belong to some older AVR devices, not the ATmega328/P. On those older devices URSEL selects UCSRC versus UBRRH for writes; do not port that sequence to the ATmega328/P.

Device reference: [Microchip ATmega48A/PA/88A/PA/168A/PA/328/P Data Sheet, DS40002061B](https://ww1.microchip.com/downloads/aemDocuments/documents/MCU08/ProductDocuments/DataSheets/ATmega48A-PA-88A-PA-168A-PA-328-P-DS-DS40002061B.pdf), USART register descriptions. This is the device family used for the channel-zero names and mode-field corrections above.

**UCSR0A — USART Control and Status Register A**
Contains the `RXC0`, `TXC0`, and `UDRE0` status flag bits described above.

**UCSR0B — USART Control and Status Register B**
- **RXEN0** (Receiver Enable): On/off switch for the receiver.
- **TXEN0** (Transmitter Enable): On/off switch for the transmitter.
- **UCSZ02**: Combined with `UCSZ01:0` in `UCSR0C`, sets the data character size.

**UCSR0C — USART Control and Status Register C**
Customizes the data frame format. Both transmitter and receiver must be configured with identical settings.

The field notation in this note describes groups of bits; it is not a C expression. Consult the device header for individual bit identifiers and use masks or shifts to manipulate them.

> [!example] Descriptive fields versus header identifiers
> `UMSEL0[1:0]` denotes the pair of bits named `UMSEL01` and `UMSEL00` in the ATmega328/P header. The combined character-size field uses `UCSZ02`, `UCSZ01`, and `UCSZ00`. Do not paste a bracketed field label into C as though it were an array access.

| Bit Field                      | Options                                                              |
|---|---|
| **UMSEL0[$1$:$0$]** (Mode Select) | `00`: Asynchronous; `01`: Synchronous; `11`: USART in SPI mode; `10`: reserved |
| **UPM0[$1$:$0$]** (Parity Mode)     | `00`: None, `10`: Even, `11`: Odd                                    |
| **USBS0** (Stop Bit Select)     | `0`: $1$ stop bit, `1`: $2$ stop bits                                    |
| **UCSZ02:$0$** (Character Size) | `000`: $5$-bit, `001`: $6$-bit, `010`: $7$-bit, `011`: $8$-bit, `111`: $9$-bit |
_Table 5.6: ATmega328/P USART frame configuration fields._

> [!warning] Correction: ATmega328/P mode selection is a two-bit UMSEL0 field, not the older single UMSEL bit. The separate SPI subsystem is distinct from USART SPI mode.

> [!example] Selecting an 8N1 USART frame
> For asynchronous `8N1`, select `UMSEL0[1:0] = 00`, `UPM0[1:0] = 00`, `USBS0 = 0`, and combined character-size bits `UCSZ02:0 = 011`. The high character-size bit is in `UCSR0B`; the lower two are in `UCSR0C`.

![[Pasted image 20261015161319.png]]
_Figure 5.23: USART transmit and receive activities. Image unavailable in the supplied files; description is based on source context._

## 5.19 ATmega SPI Operation and Registers

The ATmega SPI system provides two-way _synchronous_ serial communication between a transmitter and a receiver. Both devices share a common clock source, which requires a clock line compared to an asynchronous USART connection but enables higher data transmission rates. SPI is used for fast, efficient data exchange between microcontrollers and peripheral devices such as LCDs and DACs.
![[Pasted image 20261015161440.png]]
_Figure 5.24: AVR SPI subsystem overview. Image unavailable in the supplied files; description is based on source context._

**Terminology**
This section follows the source text's use of "master" (controller) and "slave" (peripheral), as well as "MOSI" (PICO) and "MISO" (POCI). See [[#5.13 Serial Peripheral Interface (SPI)]] for the signal-name mapping.

### SPI Operation

The SPI system can be conceptualized as a synchronous $16$-bit shift register split into two $8$-bit halves — one in the transmitter (master) and one in the receiver (slave). The master provides the synchronizing clock. A slave is selected for communication by pulling its _Slave Select_ (SS) line low, which enables the slave's shifting capability.

**Transmission sequence:**

1. A data byte is loaded into the master's _SPI Data Register_ (`SPDR`), initiating transmission.
2. The SPI clock generator provides clock pulses to both master and slave via the `SCK` pin.
3. On each `SCK` pulse, one bit shifts out of the master's shift register through the `MOSI` (Master Out Slave In) pin and into the slave's `MOSI` pin.
4. **Simultaneously**, one bit shifts out of the slave's `MISO` (Master In Slave Out) pin and into the master's `MISO` pin.
5. After eight `SCK` clock pulses, a full byte has been **exchanged** between master and slave.
6. Completion is signaled by the _SPI Interrupt Flag_ (`SPIF`) in the _SPI Status Register_ (`SPSR`) of both devices, at which point another byte may be transmitted.

**Simultaneous Exchange**
Because data shifts in both directions at the same time, SPI is inherently a byte-exchange protocol. Every transmission from the master to the slave simultaneously receives a byte from the slave, and vice versa.

> [!example] Simultaneous SPI byte exchange
> Preload the peripheral with `0x3C` and write `0xA5` to the controller's `SPDR`. After eight clock pulses, the controller has received `0x3C` and the peripheral has received `0xA5`; each observes completion through `SPIF`. ✓ Check: eight pulses move eight bits in each direction.

### Registers

**SPI Control Register (`SPCR`)**

The `SPCR` is the main configuration register for the SPI system. Both master and slave must be configured with compatible data formats.
![[Pasted image 20261015161458.png]]
_Figure 5.25: AVR SPI registers attributed to Microchip in the source. Image unavailable in the supplied files; description is based on source context._

| Bit | Name | Function |
|---|---|---|
| **SPE** | SPI Enable | `1` = SPI on, `0` = SPI off |
| **DORD** | Data Order | `1` = LSB transmitted first, `0` = MSB transmitted first |
| **MSTR** | Master/Slave Select | `1` = master, `0` = slave |
| **CPOL** | Clock Polarity | `1` = SCK idles high, `0` = SCK idles low |
| **CPHA** | Clock Phase | `0` = data sampled on leading edge of SCK, `1` = data sampled on trailing edge |
| **SPR[$1$:$0$]** | Clock Rate Select | Combined with `SPI2X` to set the SCK division factor (see below) |
_Table 5.7: SPI control-register bit functions._

> [!example] Clock polarity and phase
> With `CPOL = 0`, the leading edge rises. With `CPHA = 0`, sample on that leading edge: SPI mode 0. With `CPOL = 1`, the leading edge falls; `CPHA = 1` then samples on the trailing rising edge: mode 3. Match both fields, not merely a rising-edge description.

**SPI Clock Division Factors**
The SPI clock (`SCK`) is derived from the microcontroller's system clock, divided down by a factor set by the `SPI2X` bit (in `SPSR`) and the `SPR[1:0]` bits (in `SPCR`):

| `SPI2X` | `SPR1` | `SPR0` | Resulting SCK frequency |
|---|---|---|---|
| $0$ | $0$ | $0$ | $f_{\text{sys}} / 4$ |
| $0$ | $0$ | $1$ | $f_{\text{sys}} / 16$ |
| $0$ | $1$ | $0$ | $f_{\text{sys}} / 64$ |
| $0$ | $1$ | $1$ | $f_{\text{sys}} / 128$ |
| $1$ | $0$ | $0$ | $f_{\text{sys}} / 2$ |
| $1$ | $0$ | $1$ | $f_{\text{sys}} / 8$ |
| $1$ | $1$ | $0$ | $f_{\text{sys}} / 32$ |
| $1$ | $1$ | $1$ | $f_{\text{sys}} / 64$ |
_Table 5.8: SPI clock frequencies selected by SPI2X and SPR bits._

**Breakdown:**
- $f_{\text{sys}}$ : The microcontroller's system clock frequency.
- `SPI2X` : The Double SPI Speed bit in `SPSR`. When set, it doubles the SPI clock rate by halving the division factor.
- `SPR[1:0]` : The Clock Rate Select bits in `SPCR`.

> [!warning] Correction: Entries such as $f_{\text{sys}}/4$ are clock frequencies, not dimensionless division factors. Table 5.8 is labeled accordingly.

**SPI Status Register (`SPSR`)**

- **SPIF** (SPI Interrupt Flag): Set when eight data bits have been transferred. Cleared by first reading `SPSR` (after `SPIF` is set) and then reading `SPDR`.
- **SPI2X** (Double SPI Speed): Used in combination with `SPR[1:0]` to set the `SCK` frequency as shown in the table above.

**SPI Data Register (`SPDR`)**

In controller mode, writing `SPDR` starts an SPI exchange. In peripheral mode, writing `SPDR` prepares outgoing data, but transfer starts only when the external controller selects the peripheral and supplies clock pulses. Reading `SPDR` retrieves the received byte.

> [!warning] Correction: Writing SPDR does not generate a clock in peripheral mode; only the controller clocks the exchange.

> [!example] SPI divider and completion
> With $f_{\text{sys}}=16\,\mathrm{MHz}$, `SPI2X = 1` and `SPR[1:0] = 01` select division by $8$, yielding $2\,\mathrm{MHz}$. Read `SPSR` with `SPIF` set, then access `SPDR` to clear the completion flag by this polling sequence. ✓ Check: $16/8=2$.

## 5.20 Two-Wire Serial Interface

The _Two-Wire Serial Interface_ (TWI) subsystem allows multiple TWI-compatible devices — microcontrollers, transducers, displays, memory storage, and others — to be connected into a small area network using just two interconnecting wires. The TWI protocol is also known as the _Inter-Integrated Circuit_ (I2C) protocol.

**TWI Key Specifications**
- **Address space:** $2^7=128$ seven-bit codes, of which $112$ are ordinarily available for device addressing; reserved codes and practical electrical limits reduce usable configurations.

- **Addressing:** Each device has a unique $7$-bit address
- **Bus frequency:** Up to $400\,\mathrm{kHz}$
- **Communication:** Bidirectional, half-duplex transfers scheduled by a controller; not simultaneous two-way traffic
- **Wires:** Two shared lines — _SDA_ (data) and _SCL_ (clock)

> [!warning] Correction: $128$ address codes do not mean $128$ ordinary seven-bit peripherals. Reserved addresses, duplicate fixed addresses, and bus capacitance constrain a real bus.

Devices on the TWI bus are connected to the shared SDA and SCL lines, and _pull-up resistors_ are required on each line. The TWI hardware uses _open-drain_ drivers, so devices can only pull lines low; the pull-up resistors restore the lines to a high state when no device is asserting them.

### System Architecture

The Microchip TWI system is implemented as a _state machine_ that controls the handshaking protocol between the master device(s) and the multiple slave devices on the bus.
![[Pasted image 20261015161641.png]]
_Figure 5.26: AVR TWI subsystem overview attributed to Microchip in the source. Image unavailable in the supplied files; description is based on source context._

**Terminology**
This section follows the source text's use of "master" (controller) and "slave" (peripheral). The updated naming conventions use "controller" and "peripheral" respectively.

Key architectural features include:

- **Arbitration:** If the system contains more than one master, built-in arbitration detection and resolution protocols prevent bus contention.
- **Addressing:** Each slave has a unique $7$-bit address. An _Address Match Unit_ and address comparator enable one-to-one communication between a master and a specific slave.
- **Signal conditioning:** The TWI hardware includes slew rate and spike control on the SCL and SDA pins to improve signal integrity.

The bus frequency is derived from the microcontroller's system clock using a _Bit Rate Generator_ with prescaler hardware. The bus frequency must not exceed $400\,\mathrm{kHz}$.

> [!example] Address match and controller role
> A peripheral configured with its own address in `TWAR` responds when the bus address matches and the hardware is enabled appropriately. A controller addressing another device instead writes that destination address and R/W bit into `TWDR`; its own `TWAR` value is not the destination.

### TWI Registers

The TWI system is configured and controlled through the following registers:

| Register | Name | Purpose |
|---|---|---|
| `TWBR` | TWI Bit Rate Register | Sets the SCL clock frequency |
| `TWCR` | TWI Control Register | Controls TWI operation and enables/disables the system |
| `TWSR` | TWI Status Register | Reports the current status of the TWI bus and prescaler settings |
| `TWDR` | TWI Data Register | Holds data to be transmitted or the most recently received data |
| `TWAR` | TWI Address Register | Stores the device's own $7$-bit slave address |
| `TWAMR` | TWI Slave Address Mask Register | Masks specific bits of the slave address for flexible address matching |
_Table 5.9: TWI registers and their roles._
![[Pasted image 20261015161701.png]]
_Figure 5.27: TWI operations attributed to Microchip in the source. Image unavailable in the supplied files; description is based on source context._

> [!info] Definition: Address masking
> In the ATmega328/P TWI peripheral address matcher, a set mask bit makes the corresponding address bit irrelevant to matching. `TWAMR` bits $7$ through $1$ mask the seven address bits; bit $0$ is not an address-mask bit.

> [!example] Matching two adjacent addresses
> With own address `0x48` and general-call recognition disabled, use `TWAR = 0x90`. To ignore the least-significant address bit, set `TWAMR = 0x02`: addresses `0x48` and `0x49` match, but `0x4A` does not. Ensure no other peripheral responds to those addresses. ✓ Check: $72\cdot2=144$ (`0x90`); masking address bit zero accepts $72$ and $73$, not $74$.

**Further Details**
Device reference: [Microchip ATmega48A/PA/88A/PA/168A/PA/328/P Data Sheet, DS40002061B](https://ww1.microchip.com/downloads/aemDocuments/documents/MCU08/ProductDocuments/DataSheets/ATmega48A-PA-88A-PA-168A-PA-328-P-DS-DS40002061B.pdf), “2-wire Serial Interface,” Section 22: the bit-rate generator (22.5.2), `TWBR` (22.9.1), `TWSR` (22.9.3), `TWAR` (22.9.5), and `TWAMR` (22.9.6). The register settings must be carefully matched to the desired bus speed, addressing mode, and communication role (master or slave).

### Setting the TWI clock

For the ATmega328/P acting as controller, the bit-rate generator uses `TWBR` and the `TWPS1:0` prescaler field in `TWSR`. This configures nominal SCL timing; pull-up rise time and any peripheral clock stretching also affect a real transaction.

> [!example] TWI clock: equation and 100 kHz configuration
> $$f_{\mathrm{SCL}}=\frac{f_{\text{sys}}}{16+2\cdot\mathrm{TWBR}\cdot P},\qquad P=4^{\mathrm{TWPS}}$$
> $$\mathrm{TWBR}=\frac{f_{\text{sys}}/f_{\mathrm{SCL}}-16}{2P}$$
> **Breakdown:** $f_{\mathrm{SCL}}$ is the requested/resulting serial-clock frequency; $f_{\text{sys}}$ is the peripheral's system clock; $\mathrm{TWBR}$ is the integer bit-rate register value; $\mathrm{TWPS}$ is the two-bit prescaler-field value; $P$ is its division factor. Prescaler field values $0,1,2,3$ select factors $1,4,16,64$. Use an integer register value and verify the resulting rate rather than assuming the target is exact.
>
> **Configure $100\,\mathrm{kHz}$ from a $16\,\mathrm{MHz}$ system clock:**
> 1. Choose prescaler field `TWPS1:0 = 00`, so $P=4^0=1$.
> 2. Calculate $\mathrm{TWBR}=(16{,}000{,}000/100{,}000-16)/(2\cdot1)=72$.
> 3. Configure the prescaler bits in `TWSR` accordingly and store `72` in `TWBR`. Enable and control transfers separately through `TWCR`; these clock settings alone do not start a transfer.
> 4. Check the board clock, pull-ups, and peripheral timing limits. The value $72$ fits the eight-bit register; the resulting nominal rate is within this device's specified TWI range.
> ✓ Substitution: $16{,}000{,}000/(16+2\cdot72\cdot1)=100{,}000\,\mathrm{Hz}=100\,\mathrm{kHz}$.

This is the TWI counterpart of [[#USART Clock Generator]] and the divider configuration in [[#5.19 ATmega SPI Operation and Registers]].


### Handshaking Protocol

The controller application requests TWI operations and inspects hardware state to decide the next action. The receiver acknowledges each address or data byte: the peripheral acknowledges an addressed write, while the controller acknowledges bytes during a read and NACKs its final byte. START and STOP are bus conditions, not separately acknowledged bytes. Unexpected status requires application-level handling; status transitions alone do not guarantee delivery.

> [!warning] Correction: Not every controller action receives a peripheral acknowledgement. During reads the controller generates data ACK/NACK; START and STOP have no separate ACK bit.

> [!example] Reading and checking a TWI transaction
> A controller writes a sensor register pointer, checks the address and data acknowledgement, issues repeated START, then reads two bytes. It ACKs the first, NACKs the second, and issues STOP. The application must inspect status after each requested hardware action and handle address NACK, arbitration loss, and timeouts rather than assuming success.

The TWI hardware state machine reports transfer outcomes; application software chooses the next action. A peripheral cannot arbitrarily send to any other device without a controller initiating the addressed transfer. The $400\,\mathrm{kHz}$ limit here applies to the ATmega328/P implementation, not every I2C implementation.

> [!warning] Correction: Acknowledgement handshaking does not guarantee reliable delivery or automatically implement recovery. The application must inspect hardware status and decide whether to retry, abort, or recover the bus.

**Reference and implementation notes**

The tutorials listed in the preserved source frontmatter provide the source context. For normative I2C timing, address reservations, arbitration, and acknowledgement behavior, consult [NXP UM10204: I2C-bus specification and user manual](https://www.nxp.com/docs/en/user-guide/UM10204.pdf). For executable register-level code, use the exact ATmega328/P datasheet and device header rather than older AVR register names. The source's register discussion mixes AVR generations; this note identifies that mismatch and uses channel-zero USART names for the ATmega328/P.

> [!summary] Summary
> The communication subsystem connects embedded devices through agreed timing, framing, signaling, and wiring. Parallel buses move several bits per clock but consume pins; serial links trade wire count against rate and protocol overhead. UART uses independent clocks and start/stop framing, with optional parity but no guaranteed delivery. SPI uses controller-supplied clocks and peripheral selection, with simultaneous bit exchange on separate data lines. I2C/TWI shares open-drain data and clock lines, uses addressing and acknowledgements, and requires arbitration and electrical limits to be respected. On the ATmega328/P, USART, SPI, and TWI registers configure these mechanisms; accurate device-specific names, clock divisors, completion flags, and error handling are essential.
