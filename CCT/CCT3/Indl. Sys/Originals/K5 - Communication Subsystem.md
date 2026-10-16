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

1. [[#Parallel vs. Serial|Parallel vs. Serial]]
2. [[#Asynchronous Serial|Asynchronous Serial]]
3. [[#Rules of Serial|Rules of Serial]]
4. [[#Baud Rate|Baud Rate]]
5. [[#Framing the Data|Framing the Data]]
	1. [[#Framing the Data#Data Chunk|Data Chunk]]
	2. [[#Framing the Data#Synchronization Bits|Synchronization Bits]]
	3. [[#Framing the Data#Parity Bits|Parity Bits]]
6. [[#9600 8N1 (an example)|9600 8N1 (an example)]]
7. [[#Wiring and Hardware|Wiring and Hardware]]
8. [[#Hardware Implementation|Hardware Implementation]]
9. [[#UARTs|UARTs]]
10. [[#Software UARTs|Software UARTs]]
11. [[#Common Pitfalls|Common Pitfalls]]
	1. [[#Common Pitfalls#RX-to-TX, TX-to-RX|RX-to-TX, TX-to-RX]]
	2. [[#Common Pitfalls#Baud Rate Mismatch|Baud Rate Mismatch]]
	3. [[#Common Pitfalls#Bus Contention|Bus Contention]]
12. [[#Serial Peripheral Interface (SPI)|Serial Peripheral Interface (SPI)]]
	1. [[#Serial Peripheral Interface (SPI)#Introduction|Introduction]]
	2. [[#Serial Peripheral Interface (SPI)#What's Wrong with Serial Ports?|What's Wrong with Serial Ports?]]
	3. [[#Serial Peripheral Interface (SPI)#A Synchronous Solution|A Synchronous Solution]]
	4. [[#Serial Peripheral Interface (SPI)#Receiving Data|Receiving Data]]
	5. [[#Serial Peripheral Interface (SPI)#Chip Select (CS)|Chip Select (CS)]]
	6. [[#Serial Peripheral Interface (SPI)#Multiple Peripherals|Multiple Peripherals]]
	7. [[#Serial Peripheral Interface (SPI)#Programming for SPI|Programming for SPI]]
	8. [[#Serial Peripheral Interface (SPI)#Configuration Options|Configuration Options]]
	9. [[#Serial Peripheral Interface (SPI)#Pin Requirements|Pin Requirements]]
13. [[#I2C|I2C]]
	1. [[#I2C#Introduction|Introduction]]
	2. [[#I2C#Why Use I2C?|Why Use I2C?]]
14. [[#I2C at the Hardware Level|I2C at the Hardware Level]]
	1. [[#I2C at the Hardware Level#Signals|Signals]]
	2. [[#I2C at the Hardware Level#Signal Logic Levels|Signal Logic Levels]]
15. [[#Protocol|Protocol]]
	1. [[#Protocol#Basics|Basics]]
	2. [[#Protocol#Start Condition|Start Condition]]
	3. [[#Protocol#Address Frame|Address Frame]]
	4. [[#Protocol#Data Frames|Data Frames]]
	5. [[#Protocol#Stop Condition|Stop Condition]]
16. [[#5.1 Overview|5.1 Overview]]
17. [[#5.2 Serial Communications|5.2 Serial Communications]]
18. [[#5.3 Serial Communication Terminology|5.3 Serial Communication Terminology]]
19. [[#5.4 Serial USART|5.4 Serial USART]]
	1. [[#5.4 Serial USART#5.4.1 System Overview|5.4.1 System Overview]]
		1. [[#5.4.1 System Overview#5.4.1.1 USART Clock Generator|5.4.1.1 USART Clock Generator]]
		2. [[#5.4.1 System Overview#5.4.1.2 USART Transmitter|5.4.1.2 USART Transmitter]]
		3. [[#5.4.1 System Overview#5.4.1.3 USART Receiver|5.4.1.3 USART Receiver]]
		4. [[#5.4.1 System Overview#5.4.1.4 USART Registers|5.4.1.4 USART Registers]]
20. [[#5.5.3 Serial Peripheral Interface (SPI)|5.5.3 Serial Peripheral Interface (SPI)]]
	1. [[#5.5.3 Serial Peripheral Interface (SPI)#5.5.3.1 SPI Operation|5.5.3.1 SPI Operation]]
	2. [[#5.5.3 Serial Peripheral Interface (SPI)#5.5.3.2 Registers|5.5.3.2 Registers]]
21. [[#5.8 Two-Wire Serial Interface|5.8 Two-Wire Serial Interface]]
	1. [[#5.8 Two-Wire Serial Interface#System Architecture|System Architecture]]
	2. [[#5.8 Two-Wire Serial Interface#TWI Registers|TWI Registers]]
	3. [[#5.8 Two-Wire Serial Interface#Handshaking Protocol|Handshaking Protocol]]

## Introduction

_Embedded electronics_ is all about interlinking circuits — processors or other _integrated circuits_ — to create a symbiotic system. For these individual circuits to exchange information, they must share a common _communication protocol_. Hundreds of protocols have been defined for this purpose, and they generally fall into one of two categories: **parallel** or **serial**.

## Parallel vs. Serial

_Parallel interfaces_ transfer multiple bits simultaneously, typically requiring data buses of eight, sixteen, or more wires. Data moves in large, concurrent bursts of 1's and 0's.
![[Pasted image 20261015144816.png]]
_An 8-bit data bus, controlled by a clock, transmitting a byte every clock pulse. 9 wires are used._

_Serial interfaces_ stream data one single bit at a time. These can operate on as few as one wire and usually no more than four.
![[Pasted image 20261015144824.png]]
_Example of a serial interface, transmitting one bit every clock pulse. Just 2 wires required!_

> [!abstract] **Highway Analogy**
> Think of the two interfaces as a stream of cars: a parallel interface is like an 8+ lane mega-highway, while a serial interface is more like a two-lane rural country road. Over a set amount of time, the mega-highway can move more traffic to its destination, but the two-lane road serves its purpose at a fraction of the cost to build.

Parallel communication is fast, straightforward, and relatively easy to implement — but it demands many more _input/output (I/O)_ lines. Since I/O pins on a microprocessor are often a limited and precious resource, serial communication is frequently preferred, trading potential speed for _pin real estate_.

## Asynchronous Serial

Dozens of serial protocols have been developed to meet the particular needs of embedded systems. Well-known computing examples include _USB_ (Universal Serial Bus) and _Ethernet_, while other common interfaces include _SPI_, _I2C_, and the widely used asynchronous serial standard. All serial interfaces fall into one of two groups: **synchronous** or **asynchronous**.

> [!info] **Synchronous vs. Asynchronous Serial**
> - **Synchronous** serial interfaces pair their data line(s) with a _clock signal_, meaning all devices on the bus share a common clock. This enables more straightforward and often faster transfers, but requires at least one extra wire between communicating devices. Examples: SPI, I2C.
> - **Asynchronous** serial interfaces transfer data _without_ an external clock signal. This minimizes the number of required wires and I/O pins, but demands additional mechanisms to ensure reliable data transfer and reception.

The most common form of asynchronous serial communication is so ubiquitous that the term "serial" on its own typically refers to this specific protocol. It is widely used in embedded electronics for interfacing with external devices such as _GPS modules_, _Bluetooth modules_, _XBee radios_, and _serial LCDs_.

## Rules of Serial

The asynchronous serial protocol includes several built-in mechanisms that ensure robust and error-free data transfers — the trade-off for not using an external clock signal. These mechanisms are:

- _Data bits_
- _Synchronization bits_
- _Parity bits_
- _Baud rate_

The protocol is highly configurable through these mechanisms, meaning there is no single way to send data serially. The critical requirement is that **both devices on a serial bus must be configured to use the exact same settings**.

## Baud Rate

The _baud rate_ specifies how fast data is sent over a serial line, expressed in units of _bits-per-second_ (bps). Inverting the baud rate gives the duration of a single bit, which determines how long the transmitter holds a line high or low, and at what period the receiving device samples its line.

> [!summary] **Baud Rate and Bit Duration**
> $$t_{bit} = \frac{1}{\text{baud rate}}$$
> 
> **Breakdown:**
> - $t_{bit}$ : The bit duration — the time spent transmitting a single bit, in seconds.
> - $\text{baud rate}$ : The transmission speed in bits-per-second (bps).

Both communicating devices must operate at the same baud rate. Common standard rates include 1200, 2400, 4800, **9600**, 19200, 38400, 57600, and 115200 bps. The 9600 bps rate is especially common for simple applications where speed is not critical.

Higher baud rates enable faster data transfer, but there are practical limits. Speeds above 115200 bps are uncommon for most microcontrollers, as excessively high rates introduce errors on the receiving end when clocks and sampling periods can no longer keep up.

## Framing the Data

Each block of data (usually a byte) is transmitted as a _packet_ or _frame_ of bits, created by appending synchronization and parity bits around the actual data.
![[Pasted image 20261015152005.png]]
_A serial frame. Some symbols in the frame have configurable bit sizes._
### Data Chunk

The core of every serial packet is the _data chunk_. Its size is configurable from 5 to 9 bits. The standard is an 8-bit byte, though other sizes have practical uses — for instance, a 7-bit chunk is more efficient when transferring 7-bit _ASCII_ characters.

Both devices must also agree on the _endianness_ of the data: whether bits are sent most-significant bit (MSB) first or least-significant bit (LSB) first. If not otherwise specified, data is typically transferred **LSB first**.

### Synchronization Bits

_Synchronization bits_ are two or three special bits transferred with each data chunk: the _start bit_ and the _stop bit(s)_. They mark the beginning and end of each packet.

- There is always exactly **one start bit**, indicated by the idle data line transitioning from 1 to 0.
- The number of **stop bits** is configurable to either one or two (commonly left at one). The stop bit(s) return the line to the idle state by holding it at 1.

### Parity Bits

_Parity_ is a simple, low-level form of error checking that comes in two flavors: **odd** or **even**. To compute the parity bit, all data bits in the chunk are summed, and the evenness of the total determines whether the parity bit is set.

> [!example] **Parity Calculation**
> Given a data byte of `0b01011101` (which contains five 1's — an odd count):
> - With **even** parity: the parity bit is set to `1` to make the total number of 1's even (6).
> - With **odd** parity: the parity bit is set to `0` to keep the total number of 1's odd (5).

Parity is optional and not widely used. It can help when transmitting across noisy mediums, but it slightly slows data transfer and requires both sender and receiver to implement error-handling (typically re-sending data that fails the parity check).

## 9600 8N1 (an example)

_9600 8N1_ — 9600 baud, 8 data bits, no parity, 1 stop bit — is one of the most commonly used serial configurations.

> [!example] **Transmitting "OK" in 9600 8N1**
> A device sending the ASCII characters `O` and `K` creates two separate packets:
> 
> - `O` → ASCII 79 → binary `01001111` → sent LSB first: `1 1 1 1 0 0 1 0`
> - `K` → ASCII 75 → binary `01001011` → sent LSB first: `1 1 0 1 0 0 1 0`
> 
> Each packet is framed with a start bit (`0`) and a stop bit (`1`), giving 10 bits per byte:
> 
> | Bit Position | Start | D0 | D1 | D2 | D3 | D4 | D5 | D6 | D7 | Stop |
> |---|---|---|---|---|---|---|---|---|---|---|
> | `O` | 0 | 1 | 1 | 1 | 1 | 0 | 0 | 1 | 0 | 1 |
> | `K` | 0 | 1 | 1 | 0 | 1 | 0 | 0 | 1 | 0 | 1 |
> 
> ![[Pasted image 20261015152430.png]]
> 
> At 9600 bps, each bit is held for $t_{bit} = \frac{1}{9600} \approx 104\;\mu\text{s}$.
> 
> Since each byte requires 10 bits on the wire (1 start + 8 data + 1 stop), the effective throughput is:
> $$\frac{9600 \;\text{bps}}{10 \;\text{bits/byte}} = 960 \;\text{bytes/second}$$

## Wiring and Hardware

A serial bus consists of just two wires — one for sending data and one for receiving. Serial devices therefore have two serial pins: the _receiver_ (RX) and the _transmitter_ (TX).
![[Pasted image 20261015152452.png]]

> [!warning] **RX and TX Are Relative to the Device**
> The RX and TX labels refer to the device itself, not the bus. This means the RX pin of one device must connect to the TX pin of the other, and vice-versa. Unlike power or ground lines that connect like-to-like (VCC to VCC, GND to GND), serial data lines are always crossed: the transmitter talks to the receiver, not to another transmitter.

A serial interface where both devices may send and receive data operates in one of two modes:

- **Full-duplex:** Both devices can send and receive simultaneously.
- **Half-duplex:** Devices must take turns sending and receiving.

In some cases, only a single connection is needed. This is known as _simplex_ serial communication, where one device only transmits and the other only listens. An example is a serial-enabled LCD that receives display data but has nothing to send back — only a single wire from the master's TX to the listener's RX is required.

## Hardware Implementation

At the signal level, serial communication can be implemented in a variety of ways. Two of the most popular hardware standards are _TTL_ (transistor-transistor logic) and _RS-232_.

> [!info] **TTL vs. RS-232 Signaling**
> | Feature | TTL Serial | RS-232 |
> |---|---|---|
> | **Voltage range** | 0V to VCC (typically 3.3V or 5V) | Typically −13V to +13V (spec allows ±3V to ±25V) |
> | **Idle / Logic 1 / Stop bit** | High (VCC level) | Low (negative voltage) |
> | **Start bit / Logic 0** | Low (0V / GND) | High (positive voltage) |
> | **Typical use** | Microcontrollers, low-level ICs | Older computers and peripherals |
> | **Long-range suitability** | Poor — low voltages are susceptible to signal loss | Good — higher voltages tolerate longer lines |

_TTL serial_ is the standard used when microcontrollers and other low-level integrated circuits communicate. Signals swing between 0V and the device's supply voltage (3.3V or 5V). It is straightforward to implement in embedded circuits but vulnerable to signal degradation over long transmission lines.
![[Pasted image 20261015152548.png]]

_RS-232_ inverts the TTL logic convention: a negative voltage represents the idle state and a logic 1, while a positive voltage represents a start bit or logic 0. Its higher voltage levels make it better suited for long-range serial transmissions, along with more complex standards like _RS-485_.
![[Pasted image 20261015152600.png]]

> [!important] **Signal Voltage Matching**
> When connecting two serial devices, their signal voltage standards **must** match. A TTL-level device cannot be directly connected to an RS-232 bus — a _level shifter_ is required to translate between the two voltage domains.

## UARTs

The final piece of the serial communication puzzle is the hardware responsible for creating serial packets and controlling the physical data lines: the _UART_.
![[Pasted image 20261015152844.png]]
_Super-simplified UART interface. Parallel on one end, serial on the other._

A _universal asynchronous receiver/transmitter_ (UART) is a block of circuitry that implements serial communication. It acts as an intermediary between parallel and serial interfaces — on one side it connects to a parallel bus of roughly eight data lines (plus control pins), and on the other it connects to the two serial wires, RX and TX.

UARTs exist as stand-alone integrated circuits, but they are more commonly built directly into microcontrollers. The number of UARTs varies by chip: some have none, some have one, and some have many. For example, the ATmega328 (used in the Arduino Uno) has a single UART, while the ATmega2560 (used in the Arduino Mega) has four.
![[Pasted image 20261015153043.png]]
_Internal UART block diagram (courtesy of the Exar ST16C550 datasheet)_

> [!info] **UART Transmit and Receive Roles**
> - **Transmit side:** The UART assembles the data packet by appending synchronization and parity bits, then sends the packet out the TX line with precise timing dictated by the configured baud rate.
> - **Receive side:** The UART samples the RX line at the expected baud rate, identifies the sync bits, and extracts the data payload.

More advanced UARTs include a _buffer_ for received data, holding it until the microcontroller is ready to read it. Buffered data is typically released on a _first-in-first-out_ (FIFO) basis. Buffer sizes can range from a few bits to thousands of bytes.

## Software UARTs

If a microcontroller lacks a hardware UART (or doesn't have enough), the serial interface can be _bit-banged_ — meaning the processor directly controls the timing and state of the data lines in software. This is the approach used by libraries such as _SoftwareSerial_ on Arduino.

> [!tip] **Bit-Banging Trade-offs**
> Bit-banging works in a pinch but is processor-intensive and generally less precise than a dedicated hardware UART. It is best suited for low-speed or occasional serial communication when hardware UARTs are unavailable.

## Common Pitfalls

Even experienced engineers can fall into a few recurring mistakes when working with serial communication.

### RX-to-TX, TX-to-RX

As straightforward as it sounds, forgetting to cross the RX and TX lines between devices is a surprisingly common error. Despite the temptation to match labels directly, **always** connect RX to TX and TX to RX between serial devices.

### Baud Rate Mismatch

Baud rates function like the shared language of serial communication. If two devices are not configured to the same speed, data will be misinterpreted or missed entirely. If the receiving device is seeing garbage on its receive line, a baud rate mismatch is one of the first things to check.
![[Pasted image 20261015153236.png]]
_Data transmitted at 9600 bps, but received at 19200 bps. Baud mismatch = garbage._

### Bus Contention

Serial communication is designed for **two devices** on a single bus. If more than one device attempts to transmit on the same serial line simultaneously, _bus contention_ occurs.

> [!warning] **Bus Contention Risks**
> When two devices drive the same transmit line at the same time, the best-case outcome is that neither device's data gets through. In the worst case, the conflicting signals can damage the transmit circuitry of one or both devices — though this is rare and usually protected against.

A practical example: when connecting a GPS module to a microcontroller, the GPS module's TX line connects to the microcontroller's RX line. However, that same RX pin may already be wired to the TX pin of a USB-to-serial converter (used for programming and serial monitoring). This creates a situation where both the GPS module and the USB converter could try to drive the same line simultaneously.
![[Pasted image 20261015153251.png]]![[Pasted image 20261015153321.png]]
_Two transmitters sending to a single receiver sets up the possibility for bus contention._

> [!tip] **Multiple Receivers on a Single Transmitter**
> It is generally safe to connect multiple _receiving_ devices to a single _transmitting_ device, since only one device controls the line. For example, a serial LCD's RX line can share the microcontroller's TX line alongside a USB programmer's RX line. However, this approach has a firmware-level risk: every device on the line hears every transmission, which could cause unintended behavior if a device receives data not meant for it.

---

## Serial Peripheral Interface (SPI)

### Introduction

_Serial Peripheral Interface_ (SPI) is an interface bus commonly used to send data between microcontrollers and small peripherals such as _shift registers_, _sensors_, and _SD cards_. Unlike asynchronous serial, SPI uses separate _clock_ and _data_ lines, along with a _select line_ to choose which device to communicate with.

### What's Wrong with Serial Ports?

A standard serial port with TX and RX lines is _asynchronous_ — there is no shared control over when data is sent, and no guarantee that both sides are running at precisely the same rate. Since digital systems rely on synchronization to a single clock (typically a main crystal oscillator), communication between two systems with slightly different clocks can be problematic.
![[Pasted image 20261015153540.png]]

To work around this, asynchronous serial connections add extra _start_ and _stop_ bits to each byte, helping the receiver re-synchronize as data arrives. Both sides must also agree on a transmission speed (e.g., 9600 bps) in advance. Slight differences in clock rate are tolerable because the receiver re-syncs at the start of every byte.

> [!note] **LSB-First Bit Ordering**
> Serial protocols often transmit the _least significant bit_ (LSB) first, meaning the smallest bit appears earliest in the transmission. For example, the byte `0x53` (binary `01010011`) would be sent over the wire as `11001010` — the bit order is reversed from the conventional written representation. The lower nybble (`0011` = `0x3`) is sent first, followed by the upper nybble (`0101` = `0x5`).

While asynchronous serial works well, it carries significant overhead:

- **Bit overhead:** Extra start and stop bits are appended to every byte.
- **Hardware complexity:** More complex circuitry is required to reliably send and receive data without a shared clock.
- **Timing sensitivity:** The receiver samples bits at very specific moments. If the two sides are not set to the same baud rate, the receiver samples at the wrong times and the data comes through as garbage.

### A Synchronous Solution

SPI operates as a _synchronous_ data bus, using separate lines for data and a _clock_ signal that keeps both communicating sides in perfect synchronization. The clock is an oscillating signal that tells the receiver exactly when to sample bits on the data line. Sampling occurs on either the _rising edge_ (low to high) or the _falling edge_ (high to low) of the clock signal — the specific edge to use is defined in the device's datasheet. When the receiver detects the designated edge, it immediately reads the current state of the data line to capture the next bit.
![[Pasted image 20261015153633.png]]

Because the clock signal travels alongside the data, there is no need to pre-agree on a transmission speed the way asynchronous serial requires. However, every device does have a maximum clock speed at which it can reliably operate.

> [!info] **Why SPI Hardware Is Simpler**
> A key reason for SPI's popularity is that the receiving hardware can be as simple as a _shift register_. This is significantly simpler and cheaper than the full _UART_ (Universal Asynchronous Receiver/Transmitter) required for asynchronous serial communication.

### Receiving Data

> [!info] **SPI Terminology Update**
> The embedded community has moved away from the terms "Master" and "Slave" in favor of "Controller" and "Peripheral." The updated signal names are:
> 
> | Obsolete Name | Replacement Name |
> |---|---|
> | Master | Controller |
> | Slave | Peripheral |
> | MISO | POCI (Peripheral Out / Controller In) |
> | MOSI | PICO (Peripheral In / Controller Out) |
> | SS | CS (Chip Select) |
> 
> Naming conventions may still vary by manufacturer, programming language, or organization.

In SPI, only one side generates the clock signal, typically labeled _CLK_ or _SCK_ (Serial ClocK). The device that generates the clock is the **controller** (almost always the microcontroller), and the other side is the **peripheral**. There is always exactly one controller, but there can be multiple peripherals on the same bus.

Data flows between controller and peripheral on two dedicated lines:

- **PICO** (_Peripheral In / Controller Out_): Carries data from the controller to the peripheral.
- **POCI** (_Peripheral Out / Controller In_): Carries data from the peripheral back to the controller.

When the controller needs to receive data from a peripheral, it continues generating a _prearranged_ number of clock cycles, during which the peripheral places its response onto the POCI line. Because the controller is the sole clock generator, it must know in advance when a peripheral will return data and how much. This is a fundamental difference from asynchronous serial, where arbitrary amounts of data can be sent in either direction at any time.
![[Pasted image 20261015153751.png]]

> [!tip] **Handling Variable-Length Responses**
> In practice, the prearranged data requirement is rarely a problem because SPI peripherals (such as sensors) typically follow a specific command structure. For example, a "read data" command might always return exactly two bytes. If a variable amount of data is needed, the peripheral can first return one or two bytes specifying the data length, and the controller can then clock out the full amount.

SPI is a _full-duplex_ protocol — it has separate send and receive lines — which means that in certain situations data can be transmitted and received simultaneously. For instance, a controller could request a new sensor reading while retrieving the result of the previous one. Whether this is supported depends on the specific device and its datasheet.

### Chip Select (CS)

The _CS_ (Chip Select) line tells a peripheral that it should wake up and begin receiving or sending data. It is also used to select a specific peripheral when multiple devices share the same SPI bus.

The CS line is normally held **high**, which disconnects the peripheral from the bus. This is known as _active low_ logic — a convention also commonly used for enable and reset lines. Just before data is sent, the CS line is brought **low** to activate the peripheral. When communication is complete, the line is returned high. In a shift register, this corresponds to the "latch" input, which transfers the received data to the output lines.

### Multiple Peripherals

There are two common ways to connect multiple peripherals to a single SPI bus.

**Individual CS Lines**
![[Pasted image 20261015155025.png]]
Each peripheral gets its own dedicated CS line. To communicate with a specific device, the controller pulls that device's CS line low while keeping all others high. Activating two peripherals at the same time must be avoided, as both may attempt to drive the POCI line simultaneously, resulting in garbled data.

> [!tip] **Running Low on CS Pins?**
> If you have many peripherals and are running out of output pins, _binary decoder chips_ can be used to multiply the number of available CS lines from a smaller set of controller outputs.

**Daisy-Chaining**
![[Pasted image 20261015155030.png]]
Some devices are designed to be _daisy-chained_: the POCI output of one peripheral connects to the PICO input of the next, forming a chain. A single shared CS line connects to all peripherals in the chain. Data overflows from one device to the next, and when the CS line is raised, all chips latch their data simultaneously. This approach is commonly used with daisy-chained shift registers and addressable LED drivers.

> [!warning] **Daisy-Chain Considerations**
> - To send data to any peripheral in the chain, you must transmit enough data to fill _all_ peripherals in the chain.
> - The first piece of data transmitted ends up in the _last_ peripheral in the chain.
> - This layout is typically used in **output-only** situations (e.g., driving LEDs), where the controller's POCI line can be left disconnected.
> - If return data is needed, the daisy-chain loop can be closed by connecting the last peripheral's POCI back to the controller. However, the return data from the first peripheral must pass through all subsequent peripherals before reaching the controller, so enough clock cycles must be generated to shift the full response back.

### Programming for SPI

Many microcontrollers include built-in SPI hardware peripherals that handle the details of sending and receiving data at very high speeds. However, the SPI protocol is also simple enough that you can write your own _bit-banging_ routines to manually manipulate I/O lines in the correct sequence.

On Arduino, there are two main approaches to SPI communication:

- **`shiftIn()` and `shiftOut()`**: Software-based commands that work on any group of pins but are relatively slow.
- **SPI Library**: Leverages the microcontroller's built-in SPI hardware for vastly faster transfers, but only works on specific designated pins.

### Configuration Options

When setting up an SPI interface, several options must be configured to match the requirements of the peripheral device (check the device's datasheet):

> [!info] **SPI Configuration Parameters**
> - **Bit Order:** Data can be sent _most-significant bit_ (MSB) first or _least-significant bit_ (LSB) first. In the Arduino SPI library, this is set with `setBitOrder()`.
> - **Data Mode:** Determines which clock edge the peripheral reads data on (rising or falling) and whether the clock is considered idle when high or low. In the Arduino SPI library, both settings are controlled by `setDataMode()`.
> - **Clock Speed:** SPI can operate at extremely high speeds (millions of bytes per second), which may exceed what some peripherals can handle. The data rate can be reduced using `setClockDivider()`, which divides the controller's system clock (16 MHz on most Arduinos) down to a range between 8 MHz (÷2) and 125 kHz (÷128).

### Pin Requirements

When using the hardware SPI library, you must use the designated _SCK_, _PICO_, and _POCI_ pins, as the SPI hardware is physically hardwired to those pins. A dedicated CS pin is also available and must at minimum be configured as an output for the SPI hardware to function, though any other available output pin can be used as a CS line for additional peripherals.

> [!tip] **CS Pin Handling**
> On older Arduino boards, CS pins must be controlled manually in software — pulled low before a transfer and high afterward. Newer boards such as the Arduino Due can manage CS pins automatically as part of the data transfer.

## I2C

### Introduction

The _Inter-Integrated Circuit_ (I2C) protocol allows multiple "peripheral" digital integrated circuits to communicate with one or more "controller" chips. Like SPI, it is intended for short-distance communication within a single device. Like asynchronous serial (UART, RS-232), it requires only **two signal wires** to exchange information.

> [!info] **Terminology Update**
> The terms "master" and "slave" are considered obsolete and have been replaced with **controller** and **peripheral**, respectively. Naming conventions may vary by manufacturer or organization (e.g., main/secondary, initiator/responder, source/replica).

### Why Use I2C?

Understanding I2C's advantages requires comparing it to the alternatives.

**Drawbacks of Asynchronous Serial (UART):**
- Devices must pre-agree on a data rate and maintain closely matched clocks; excessive clock drift causes garbled data.
- Hardware overhead is significant — UARTs are relatively complex and difficult to implement in software.
- Each 8-bit data byte requires at least 10 bits of transmission time (start + 8 data + stop), reducing effective throughput.
- Inherently limited to **two-device** communication; connecting more devices risks bus contention and potential hardware damage.
- Most UART devices cap out around 230,400 bps.

**Drawbacks of SPI:**
- Requires **four lines** for a single controller-peripheral pair, plus one additional chip select pin per extra peripheral. Pin count grows rapidly.
- Only supports a **single controller** on the bus.
- Large connection counts complicate PCB routing in tight layouts.
- On the positive side, SPI excels at high data rates (10+ MHz) and full-duplex communication, with simple shift-register hardware.

> [!summary] **I2C: The Best of Both Worlds**
> | Feature | Asynchronous Serial | SPI | I2C |
> |---|---|---|---|
> | **Wires required** | 2 (TX, RX) | 4+ (SCK, PICO, POCI, CS) | 2 (SDA, SCL) |
> | **Max peripherals** | 1 (point-to-point) | Many (limited by CS pins) | Up to 1008 |
> | **Multi-controller** | No | No | Yes |
> | **Typical data rate** | Up to ~230 kbps | Up to 10+ Mbps | 100 kHz or 400 kHz |
> | **Hardware complexity** | High (UART) | Low (shift register) | Moderate |
> | **Duplex** | Full | Full | Half |
> 
> I2C combines the two-wire simplicity of asynchronous serial with the multi-device and multi-controller support that SPI lacks. The trade-off is a moderate data rate and a small overhead of one ACK/NACK bit per 8-bit data frame.

## I2C at the Hardware Level

### Signals

Each I2C bus consists of two signals:

- **SDA** (Serial Data): The bidirectional data line.
- **SCL** (Serial Clock): The clock signal, always generated by the current bus controller.

Peripheral devices may occasionally hold SCL low to delay the controller — a mechanism called _clock stretching_ — giving the peripheral more time to prepare or process data.

> [!info] **Open-Drain Drivers**
> Unlike UART or SPI, I2C bus drivers are _open-drain_: they can pull a signal line **low** but cannot actively drive it **high**. Each signal line uses a _pull-up resistor_ to restore the line to a high state when no device is asserting it low. This eliminates bus contention entirely — no device can fight another by driving high while another pulls low — preventing driver damage and excessive power dissipation.

A good starting value for pull-up resistors is **4.7 kΩ**, adjusted downward for long wire runs or systems with many devices. I2C is fairly robust over short distances (2–3 meters). When many I2C devices share the same bus, the combined pull-up resistance may become too low, requiring some devices' built-in pull-up resistors to be disconnected.
![[Pasted image 20261015160722.png]]
_Notice the two pull-up resistors on the two communication lines._
### Signal Logic Levels

Because I2C devices don't actively drive signals high, the protocol offers flexibility when connecting devices with different I/O voltages. In some cases, a 5V device and a 3.3V device can share an I2C bus without level-shifting hardware by connecting the pull-up resistors to the **lower** of the two voltages. This works when the lower voltage still exceeds the high-level input threshold of the higher-voltage device.

> [!warning] **Voltage Mismatch Caution**
> If the voltage difference is too large (e.g., 5V and 2.5V), a dedicated _I2C level shifter_ (such as a PCA9306-based breakout) is recommended. Some level shifters also include an enable line, which can be used to selectively disable communication to specific devices — useful when multiple peripherals share the same I2C address.

## Protocol

I2C communication follows a strict protocol so that all devices on the bus can recognize valid transmissions. Most peripherals handle the low-level details automatically.

### Basics

I2C messages consist of two frame types:

1. **Address frame:** The controller specifies which peripheral the message is intended for.
2. **Data frame(s):** One or more 8-bit data messages passed between controller and peripheral.

Data is placed on the SDA line after SCL goes low and is sampled after SCL goes high. The exact timing between clock edges and data transitions varies by device.
![[Pasted image 20261015160903.png]]

### Start Condition

> [!info] **Start Condition**
> To initiate communication, the controller leaves SCL **high** and pulls SDA from **high to low**. This signals all peripherals that a transmission is about to begin. If two controllers attempt to start simultaneously, the one that pulls SDA low first wins control of the bus. _Repeated start_ conditions allow a controller to begin a new sequence without releasing the bus.

### Address Frame

The address frame is always the first frame in any new communication sequence. For a standard 7-bit address, the address is clocked out **MSB first**, followed by a single **R/W bit** indicating the operation:

- `1` = **Read** (controller will receive data from the peripheral)
- `0` = **Write** (controller will send data to the peripheral)

> [!info] **ACK/NACK Bit**
> The 9th bit of every frame (address and data alike) is the _ACK/NACK_ bit. After the first 8 bits are sent, the receiving device takes control of SDA. If it pulls SDA **low** before the 9th clock pulse, it sends an **ACK** (acknowledge). If SDA remains **high**, it is a **NACK** (not acknowledged), indicating the data was not received or not understood. On a NACK, the exchange halts and the controller must decide how to proceed.

### Data Frames

After the address frame, the controller continues generating clock pulses and data is placed on SDA by either the controller or the peripheral, depending on the R/W bit. The number of data frames is arbitrary. Most peripherals _auto-increment_ their internal register pointer, so consecutive reads or writes automatically advance to the next register.

### Stop Condition

> [!info] **Stop Condition**
> The controller generates a stop condition to end the transmission: a **low-to-high** transition on SDA while SCL is **high** (specifically, after SCL has already transitioned high). During normal data transfer, SDA must **not** change while SCL is high, as this would be misinterpreted as a false stop condition.

## 5.1 Overview

Serial communication techniques provide a vital link between a microcontroller and input devices, output devices, and other microcontrollers. The ATmega328 microcontroller includes three serial communication subsystems: the _Universal Synchronous and Asynchronous Serial Receiver and Transmitter_ (USART), the _Serial Peripheral Interface_ (SPI), and the _Two Wire Interface_ (TWI). All three share the common principle of serial data transmission.

## 5.2 Serial Communications

Microcontrollers exchange data with other microcontrollers or peripheral devices using either parallel or serial techniques.

- **Parallel:** An entire byte is sent simultaneously, requiring eight separate data lines. Fast but pin-intensive.
- **Serial:** A byte is sent one bit at a time and reconstructed at the receiver. Slower but requires only one or two lines.

## 5.3 Serial Communication Terminology

> [!info] **Asynchronous vs. Synchronous Transmission**
> - **Asynchronous:** Framing bits (start and stop) are used at the beginning and end of each data byte to alert the receiver. The data rate is typically slower, but only a single wire is needed between transmitter and receiver. The ATmega328 USART operates primarily in this mode.
> - **Synchronous:** A common clock signal is shared between transmitter and receiver. Data bits are sent and received on clock edges, enabling higher data rates but requiring two lines (data and clock).

> [!info] **Key Terminology**
> - **Baud rate:** The data transmission rate expressed in bits per second (bps). For example, 9600 Baud = 9600 bits per second.
> - **Full duplex:** The system has separate hardware for transmission and reception, allowing simultaneous two-way communication. A _single duplex_ (half-duplex) system shares hardware and must switch between transmit and receive modes.
> - **Non-Return to Zero (NRZ) coding:** The coding standard used by the ATmega328. A logic one is represented by a logic high for the entire bit time slot, and a logic zero by a logic low for the entire bit time slot. The signal does not "return to zero" between bits.

> [!info] **RS-232 Communication Protocol**
> Over long distances, standard logic levels degrade and become susceptible to noise. The _RS-232_ standard (EIA-232) addresses this by using higher voltage levels: a logic one is represented by −12 VDC and a logic zero by +12 VDC. Level-converter chips (e.g., _MAX232_) translate between the 0 V / 5 V TTL levels of a microcontroller and the RS-232 voltage levels.

> [!info] **Parity**
> Parity is an additional bit transmitted with the data byte for error detection. The ATmega328 uses a single parity bit, which can detect a single-bit error within a byte.
> - **Even parity:** The parity bit is set so that the total number of 1's in the data byte (including the parity bit) is even.
> - **Odd parity:** The parity bit is set so that the total number of 1's is odd.
> 
> The receiver counts the 1's in the received byte (including parity) to verify that parity has not changed during transmission.

> [!info] **ASCII**
> The _American Standard Code for Information Interchange_ (ASCII) is a standardized 7-bit encoding for alphanumeric data. For example, the capital letter "G" is encoded as `0x47` in hexadecimal. _Unicode_ is the international 16-bit counterpart that encompasses the world's written languages; ASCII is a subset of Unicode.

![[Pasted image 20261015161231.png]]
Figure 5.1: ASCII Code. The ASCII code is used to encode alphanumeric characters. The “0x” indicates hexadecimal notation in the C programming language.
## 5.4 Serial USART

The _USART_ provides full-duplex (two-way) communication through independent transmitter and receiver hardware. The ATmega328 is equipped with a single USART channel. While the USART supports both asynchronous and synchronous modes, it is most commonly used in **asynchronous** mode, where start and stop framing bits maintain synchronization in the absence of a shared clock.

The ATmega USART is highly configurable:

- Variable baud rates
- Data widths of 5–9 bits
- One or two stop bits
- Hardware-generated parity (even or odd) with parity checking at the receiver

### 5.4.1 System Overview

The USART hardware consists of four main components: a _clock generator_, _transmitter hardware_, _receiver hardware_, and three _control registers_ (UCSRA, UCSRB, UCSRC).
![[Pasted image 20261015161250.png]]
Figure 5.2: Microchip AVR ATmega USART block diagram. (Figure used with permission of Microchip, Inc., [www.microchop.com].)

#### 5.4.1.1 USART Clock Generator

The clock generator derives the USART baud rate from the microcontroller's system clock. The system clock is divided by the contents of the _USART Baud Rate Registers_ (`UBRRH` and `UBRRL`, collectively referred to as `UBRR`) and additional internal dividers.

> [!summary] **USART Baud Rate Formulas (Asynchronous Normal Mode)**
> $$\text{Baud Rate} = \frac{f_{\text{sys}}}{16 \times (\text{UBRR} + 1)}$$
> 
> Solving for UBRR:
> $$\text{UBRR} = \frac{f_{\text{sys}}}{16 \times \text{Baud Rate}} - 1$$
> 
> **Breakdown:**
> - $f_{\text{sys}}$ : The system clock frequency of the microcontroller (e.g., 16 MHz).
> - $\text{UBRR}$ : The 12-bit value (0–4095) stored across the `UBRRH` and `UBRRL` registers. This is the divisor that sets the baud rate.
> - $16$ : A fixed internal prescaler used in asynchronous normal mode (when the `U2X` bit is 0).
> - $\text{Baud Rate}$ : The resulting data transmission rate in bits per second.

#### 5.4.1.2 USART Transmitter

The transmitter centers on a _Transmit Shift Register_. Data is loaded into this register via the _USART I/O Data Register_ (`UDR`). The hardware automatically appends start and stop framing bits and calculates and appends the parity bit. Data is then shifted out through the `TxD` pin, one bit at a time, at the configured baud rate.

Two status flags monitor the transmitter:

- **UDRE** (USART Data Register Empty): Set when the transmit buffer is empty and ready for new data. Cleared by writing to `UDR`. Should be written to zero when writing to `UCSRA`.
- **TXC** (Transmit Complete): Set when the entire frame has been shifted out of the Transmit Shift Register and no new data is in the transmit buffer. Cleared by writing a logic one to it.

#### 5.4.1.3 USART Receiver

The receiver mirrors the transmitter with reversed data flow. Data arrives one bit at a time via the `RxD` pin at the configured baud rate. The receiver includes:

- **RXC** (Receive Complete): Set to logic one when unread data exists in the receive buffer.

#### 5.4.1.4 USART Registers

> [!warning] **Shared Memory Address: UCSRC and UBRRH**
> The `UCSRC` register and the `UBRRH` register occupy the **same I/O memory location**. The `URSEL` bit (bit 7) determines which register is being accessed:
> - `URSEL = 1` → Writing to `UCSRC`
> - `URSEL = 0` → Writing to `UBRRH`

**UCSRA — USART Control and Status Register A**
Contains the `RXC`, `TXC`, and `UDRE` status flag bits described above.

**UCSRB — USART Control and Status Register B**
- **RXEN** (Receiver Enable): On/off switch for the receiver.
- **TXEN** (Transmitter Enable): On/off switch for the transmitter.
- **UCSZ2**: Combined with `UCSZ[1:0]` in `UCSRC`, sets the data character size.

**UCSRC — USART Control and Status Register C**
Customizes the data frame format. Both transmitter and receiver must be configured with identical settings.

| Bit Field                      | Options                                                              |     |
| ------------------------------ | -------------------------------------------------------------------- | --- |
| **UMSEL** (Mode Select)        | `0`: Asynchronous, `1`: Synchronous                                  |     |
| **UPM[1:0]** (Parity Mode)     | `00`: None, `10`: Even, `11`: Odd                                    |     |
| **USBS** (Stop Bit Select)     | `0`: 1 stop bit, `1`: 2 stop bits                                    |     |
| **UCSZ[2:0]** (Character Size) | `000`: 5-bit, `001`: 6-bit, `010`: 7-bit, `011`: 8-bit, `111`: 9-bit |     |
![[Pasted image 20261015161319.png]]
Figure 5.4: USART Activities.

## 5.5.3 Serial Peripheral Interface (SPI)

The ATmega SPI system provides two-way _synchronous_ serial communication between a transmitter and a receiver. Both devices share a common clock source, which requires an additional clock line compared to the USART but enables higher data transmission rates. SPI is used for fast, efficient data exchange between microcontrollers and peripheral devices such as LCDs and DACs.
![[Pasted image 20261015161440.png]]
Figure 5.8: SPI Overview.

> [!note] **Terminology**
> This section follows the source text's use of "master" (controller) and "slave" (peripheral), as well as "MOSI" (PICO) and "MISO" (POCI). See the earlier SPI notes for the updated naming conventions.

### 5.5.3.1 SPI Operation

The SPI system can be conceptualized as a synchronous 16-bit shift register split into two 8-bit halves — one in the transmitter (master) and one in the receiver (slave). The master provides the synchronizing clock. A slave is selected for communication by pulling its _Slave Select_ (SS) line low, which enables the slave's shifting capability.

**Transmission sequence:**

1. A data byte is loaded into the master's _SPI Data Register_ (`SPDR`), initiating transmission.
2. The SPI clock generator provides clock pulses to both master and slave via the `SCK` pin.
3. On each `SCK` pulse, one bit shifts out of the master's shift register through the `MOSI` (Master Out Slave In) pin and into the slave's `MOSI` pin.
4. **Simultaneously**, one bit shifts out of the slave's `MISO` (Master In Slave Out) pin and into the master's `MISO` pin.
5. After eight `SCK` clock pulses, a full byte has been **exchanged** between master and slave.
6. Completion is signaled by the _SPI Interrupt Flag_ (`SPIF`) in the _SPI Status Register_ (`SPSR`) of both devices, at which point another byte may be transmitted.

> [!info] **Simultaneous Exchange**
> Because data shifts in both directions at the same time, SPI is inherently a byte-exchange protocol. Every transmission from the master to the slave simultaneously receives a byte from the slave, and vice versa.

### 5.5.3.2 Registers

**SPI Control Register (`SPCR`)**

The `SPCR` is the main configuration register for the SPI system. Both master and slave must be configured with compatible data formats.
![[Pasted image 20261015161458.png]]
Figure 5.9: SPI Registers [www.microchip.com]

| Bit | Name | Function |
|---|---|---|
| **SPE** | SPI Enable | `1` = SPI on, `0` = SPI off |
| **DORD** | Data Order | `1` = LSB transmitted first, `0` = MSB transmitted first |
| **MSTR** | Master/Slave Select | `1` = master, `0` = slave |
| **CPOL** | Clock Polarity | `1` = SCK idles high, `0` = SCK idles low |
| **CPHA** | Clock Phase | `0` = data sampled on leading edge of SCK, `1` = data sampled on trailing edge |
| **SPR[1:0]** | Clock Rate Select | Combined with `SPI2X` to set the SCK division factor (see below) |

> [!summary] **SPI Clock Division Factors**
> The SPI clock (`SCK`) is derived from the microcontroller's system clock, divided down by a factor set by the `SPI2X` bit (in `SPSR`) and the `SPR[1:0]` bits (in `SPCR`):
> 
> | SPI2X | SPR1 | SPR0 | Division Factor |
> |---|---|---|---|
> | 0 | 0 | 0 | $f_{\text{sys}} / 4$ |
> | 0 | 0 | 1 | $f_{\text{sys}} / 16$ |
> | 0 | 1 | 0 | $f_{\text{sys}} / 64$ |
> | 0 | 1 | 1 | $f_{\text{sys}} / 128$ |
> | 1 | 0 | 0 | $f_{\text{sys}} / 2$ |
> | 1 | 0 | 1 | $f_{\text{sys}} / 8$ |
> | 1 | 1 | 0 | $f_{\text{sys}} / 32$ |
> | 1 | 1 | 1 | $f_{\text{sys}} / 64$ |
> 
> **Breakdown:**
> - $f_{\text{sys}}$ : The microcontroller's system clock frequency.
> - $\text{SPI2X}$ : The Double SPI Speed bit in `SPSR`. When set, it doubles the SPI clock rate by halving the division factor.
> - $\text{SPR[1:0]}$ : The Clock Rate Select bits in `SPCR`.

**SPI Status Register (`SPSR`)**

- **SPIF** (SPI Interrupt Flag): Set when eight data bits have been transferred. Cleared by first reading `SPSR` (after `SPIF` is set) and then reading `SPDR`.
- **SPI2X** (Double SPI Speed): Used in combination with `SPR[1:0]` to set the `SCK` frequency as shown in the table above.

**SPI Data Register (`SPDR`)**

Writing a data byte to `SPDR` initiates an SPI transmission. Reading `SPDR` retrieves the byte received during the last exchange.

## 5.8 Two-Wire Serial Interface

The _Two-Wire Serial Interface_ (TWI) subsystem allows multiple TWI-compatible devices — microcontrollers, transducers, displays, memory storage, and others — to be connected into a small area network using just two interconnecting wires. The TWI protocol is also known as the _Inter-Integrated Circuit_ (I2C) protocol.

> [!info] **TWI Key Specifications**
> - **Maximum devices:** 128 on a single bus
> - **Addressing:** Each device has a unique 7-bit address
> - **Bus frequency:** Up to 400 kHz
> - **Communication:** Full two-way (transmit and receive) between any devices on the bus
> - **Wires:** Two shared lines — _SDA_ (data) and _SCL_ (clock)

Devices on the TWI bus are connected to the shared SDA and SCL lines, and _pull-up resistors_ are required on each line. The TWI hardware uses _open-drain_ drivers, so devices can only pull lines low; the pull-up resistors restore the lines to a high state when no device is asserting them.

### System Architecture

The Microchip TWI system is implemented as a _state machine_ that controls the handshaking protocol between the master device(s) and the multiple slave devices on the bus.
![[Pasted image 20261015161641.png]]
Figure 5.11: TWI system overview [Microchip [5]].

> [!note] **Terminology**
> This section follows the source text's use of "master" (controller) and "slave" (peripheral). The updated naming conventions use "controller" and "peripheral" respectively.

Key architectural features include:

- **Arbitration:** If the system contains more than one master, built-in arbitration detection and resolution protocols prevent bus contention.
- **Addressing:** Each slave has a unique 7-bit address. An _Address Match Unit_ and address comparator enable one-to-one communication between a master and a specific slave.
- **Signal conditioning:** The TWI hardware includes slew rate and spike control on the SCL and SDA pins to improve signal integrity.

The bus frequency is derived from the microcontroller's system clock using a _Bit Rate Generator_ with prescaler hardware. The bus frequency must not exceed 400 kHz.

### TWI Registers

The TWI system is configured and controlled through the following registers:

| Register | Name | Purpose |
|---|---|---|
| `TWBR` | TWI Bit Rate Register | Sets the SCL clock frequency |
| `TWCR` | TWI Control Register | Controls TWI operation and enables/disables the system |
| `TWSR` | TWI Status Register | Reports the current status of the TWI bus and prescaler settings |
| `TWDR` | TWI Data Register | Holds data to be transmitted or the most recently received data |
| `TWAR` | TWI Address Register | Stores the device's own 7-bit slave address |
| `TWAMR` | TWI Slave Address Mask Register | Masks specific bits of the slave address for flexible address matching |
![[Pasted image 20261015161701.png]]
Figure 5.12: TWI operations [www.microchip.com].

> [!tip] **Further Details**
> Specific bit-level configuration for each register is documented in the Microchip ATmega328 datasheet. The register settings must be carefully matched to the desired bus speed, addressing mode, and communication role (master or slave).

### Handshaking Protocol

Data exchange on the TWI bus follows a carefully orchestrated _handshaking protocol_. At each step of the exchange, the application program on the master device initiates an action, and the slave hardware provides a corresponding response. If the expected response is not received at any step, an error condition is triggered. This protocol ensures reliable communication even with multiple devices sharing the same two bus lines.