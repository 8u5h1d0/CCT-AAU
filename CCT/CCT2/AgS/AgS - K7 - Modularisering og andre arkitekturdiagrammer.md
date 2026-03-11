---
tags:
  - "#AgS"
  - "#CCT2"
Topic: Software-Arkitekturdiagrammer
Semester: CCT2
Course: Agil systemudvikling
Litterature:
  - SSU kompendie
Created: 11-03-2026
---
# Table of Contents

1. [[#System Breakdown and Reference Architecture|System Breakdown and Reference Architecture]]
	1. [[#System Breakdown and Reference Architecture#Quick Reference Table|Quick Reference Table]]
	2. [[#System Breakdown and Reference Architecture#System Breakdown|System Breakdown]]
		1. [[#System Breakdown#The Challenge of System Division|The Challenge of System Division]]
		2. [[#System Breakdown#Importance of Careful Planning|Importance of Careful Planning]]
	3. [[#System Breakdown and Reference Architecture#From System Requirements to Reference Architecture|From System Requirements to Reference Architecture]]
		1. [[#From System Requirements to Reference Architecture#What is a Module?|What is a Module?]]
			1. [[#What is a Module?#Implementation Flexibility|Implementation Flexibility]]
			2. [[#What is a Module?#Encapsulation Benefits|Encapsulation Benefits]]
		2. [[#From System Requirements to Reference Architecture#Creating a Reference Architecture|Creating a Reference Architecture]]
		3. [[#From System Requirements to Reference Architecture#Visualizing Reference Architecture|Visualizing Reference Architecture]]
			1. [[#Visualizing Reference Architecture#Core Elements|Core Elements]]
	4. [[#System Breakdown and Reference Architecture#Using Requirements to Derive Modules|Using Requirements to Derive Modules]]
		1. [[#Using Requirements to Derive Modules#The Importance of Proper Naming|The Importance of Proper Naming]]
		2. [[#Using Requirements to Derive Modules#Why Naming Matters|Why Naming Matters]]
		3. [[#Using Requirements to Derive Modules#Method for Developing Module Names|Method for Developing Module Names]]
		4. [[#Using Requirements to Derive Modules#Verification Through Use Cases|Verification Through Use Cases]]
		5. [[#Using Requirements to Derive Modules#Example Case: Temperature and Humidity Monitor|Example Case: Temperature and Humidity Monitor]]
			1. [[#Example Case: Temperature and Humidity Monitor#System Requirements|System Requirements]]
			2. [[#Example Case: Temperature and Humidity Monitor#Deriving Modules from Requirements|Deriving Modules from Requirements]]
			3. [[#Example Case: Temperature and Humidity Monitor#Requirements-to-Module Mapping|Requirements-to-Module Mapping]]
			4. [[#Example Case: Temperature and Humidity Monitor#Next Steps|Next Steps]]
	5. [[#System Breakdown and Reference Architecture#Data Flow Analysis|Data Flow Analysis]]
		1. [[#Data Flow Analysis#Flow Graph Elements|Flow Graph Elements]]
		2. [[#Data Flow Analysis#Creating a Flow Graph|Creating a Flow Graph]]
		3. [[#Data Flow Analysis#Splitting Processes into Components|Splitting Processes into Components]]
		4. [[#Data Flow Analysis#Defining the Modules|Defining the Modules]]
		5. [[#Data Flow Analysis#Example Case: Temperature and Humidity Monitor Flow Analysis|Example Case: Temperature and Humidity Monitor Flow Analysis]]
			1. [[#Example Case: Temperature and Humidity Monitor Flow Analysis#Modules Spanning Multiple Components|Modules Spanning Multiple Components]]
		6. [[#Data Flow Analysis#Improved Module Definition|Improved Module Definition]]
	6. [[#System Breakdown and Reference Architecture#Defining the Modules|Defining the Modules]]
		1. [[#Defining the Modules#Functionality Density|Functionality Density]]
		2. [[#Defining the Modules#Creating Sub-Modules|Creating Sub-Modules]]
		3. [[#Defining the Modules#Balanced vs. Unbalanced Module Trees|Balanced vs. Unbalanced Module Trees]]
		4. [[#Defining the Modules#Reaching the Component Level|Reaching the Component Level]]
	7. [[#System Breakdown and Reference Architecture#Interfaces|Interfaces]]
		1. [[#Interfaces#Specifications of Interfaces|Specifications of Interfaces]]
		2. [[#Interfaces#Interface Adaptation Blocks|Interface Adaptation Blocks]]
		3. [[#Interfaces#Practical Considerations|Practical Considerations]]
	8. [[#System Breakdown and Reference Architecture#Common Pitfalls|Common Pitfalls]]

# System Breakdown and Reference Architecture

## Quick Reference Table

| Term | Definition |
|------|------------|
| **Module** | A logical entity that allows interaction by other modules and encapsulates implementation-specific decisions |
| **Reference Architecture** | The collection of modules and their interactions that form the agreed-upon system structure |
| **Divide et Impera** | "Divide and conquer" - the principle of breaking systems into smaller, manageable pieces |
| **Functionality Density** | The relationship between a set of functions; high density means closely related functions, low density means unrelated functions |
| **Flow Graph** | A graphical tool showing data/signal flow and processes using boxes, circles, arrows, and storage symbols |
| **Interface** | The defined connection point between modules, specifying inputs, outputs, and interaction methods |
| **Encapsulation** | The principle of hiding implementation details within a module while exposing only necessary interfaces |
| **Balanced Tree** | A module hierarchy where submodules are evenly distributed across branches, preferred for maintainability |
| **Unbalanced Tree** | A module hierarchy with uneven depth across branches, often harder to debug and validate |
| **Interface Adaptation Block** | A submodule that converts between external interface formats and internal data/signal types |
| **Component Level** | The lowest level of the module hierarchy where elements are used as-is without further subdivision |
| **Technology-Agnostic Naming** | Naming modules by function rather than implementation to preserve flexibility |
| **SOAP** | Simple Object Access Protocol - a messaging protocol for exchanging structured information in web services |
| **JTAG** | Joint Test Action Group - a standard interface for testing and debugging circuit boards |
| **TCP** | Transmission Control Protocol - a connection-oriented protocol ensuring reliable data delivery |
| **UDP** | User Datagram Protocol - a connectionless protocol for fast, lightweight data transmission |

---

## System Breakdown

The process of breaking down a system into manageable modules and components is essential for team-based development. This approach follows the principle of ***divide et impera*** (divide and conquer) - dividing the system into smaller, achievable pieces to successfully accomplish the overall goal.

### The Challenge of System Division

System division is frequently a major point of discussion and disagreement among stakeholders. Different perspectives on how to divide the system can lead to frustration and problems during development. The modules created through this division collectively form a ***reference architecture*** that all parties must agree upon before implementation begins.

>[!warning] Consequences of Disagreement
>If team members disagree, misunderstand, or hold differing viewpoints about the system breakdown, problems will emerge later in the development process. These issues require expensive mitigation efforts, often involving costly implementation iterations. Such problems must be avoided through careful initial planning.

### Importance of Careful Planning

The breakdown of a system into modules must be performed carefully and deliberately. Sufficient time should be allocated to ensure that all stakeholders reach agreement on the reference architecture. This upfront investment in planning prevents expensive corrections and rework during later stages of development.

>[!important] Foundation of Shared Understanding
>The reference architecture serves as a fundamental agreement among all involved parties about how the system will be structured. Without this shared understanding, the development process faces significant risks of miscommunication, incompatible components, and project delays.

---

## From System Requirements to Reference Architecture

The process of transforming requirements into a system design requires identifying core functionality and mapping it to appropriately named modules with proper interfaces. An experienced engineer can extract the essential functions from requirements and translate them into a modular system structure.

### What is a Module?

>[!info] Definition: Module
>A module is a logical entity that allows interaction by other modules and encapsulates and protects any implementation-specific decisions.
>
>For software, it's a coding "block" that can be put together with other such "blocks" to create an overall, coherent structure (similar to LEGO blocks creating a physical structure).

This definition establishes a module as a functional unit that performs specific tasks without requiring external knowledge of its internal workings. The module accepts inputs and provides outputs according to its defined functionality.

#### Implementation Flexibility

A module's internal implementation can take many forms - it could be:
- Complex and futuristic technology
- A single line of code
- 10,000 transistors
- A distributed subsystem
- Any other implementation approach

>[!important] The Implementation-Independence Principle
>The critical requirement is that the module performs the desired and expected functionality while accepting specified inputs and providing expected outputs. The actual implementation method is irrelevant to external users of the module.

>[!example] WiFi Module Encapsulation
>When working with a WiFi module, developers don't need to understand its internal workings - they only need to understand:
>- How to use the interface
>- What functionality it provides
>
>The internal complexity (antenna design, MAC protocols, encryption algorithms) remains hidden within the module's encapsulation.

#### Encapsulation Benefits

Encapsulating implementation-specific decisions allows developers to focus on design at different levels. This separation of concerns enables parallel development and reduces cognitive load on individual team members.

### Creating a Reference Architecture

Defining a set of modules provides a useful and comprehensive overview of the system under development. This modular approach enables:
- Clear assignment of development responsibilities
- Distribution of workload among team members
- Integration of individual modules into a complete system

>[!info] Reference Architecture
>Once a system has been broken down into a workable set of modules, the collection of these modules and their interactions forms the ***reference architecture*** of the system.

### Visualizing Reference Architecture

Reference architectures can be portrayed in many different ways. The most important aspect is ensuring that all involved parties clearly understand what the reference architecture represents and how to interpret it.

#### Core Elements

A reference architecture generally consists of two major elements:

**Boxes**: Visual representations of modules with names that capture their overall functionality. Ideally, each module has well-defined, focused functionality.

**Lines**: Visual representations of interactions between modules. These lines should each have a single, identifiable, and well-defined characteristic, as they define the interfaces to and from the modules.

>[!note] Design Process Flow
>The design process begins with defining the modules (boxes) and then proceeds to defining the interfaces (lines) between them. This sequence ensures that functional units are established before their interactions are specified.

---

## Using Requirements to Derive Modules

Abstracting expected functionality into boxes represents the first step in shielding implementation decisions within closed environments that enable parallel development. This abstraction is accomplished most simply by assigning proper names to modules that will later host the functionality specified in requirements.

### The Importance of Proper Naming

>[!example] Naming Example: Position Finding
>Consider a requirement stating: _"The system must be able to find its position (latitude, longitude)."_
>
>**Tempting but Problematic Approach:**
>It may be tempting to specify a GPS module, which has pre-defined interfaces and clear functional descriptions. A GPS module would satisfy all requirements - so why not use this name?
>
>**The Problem:**
>If the system later needs to switch to Galileo or GLONASS (Global Navigation Satellite System - Russia's positioning system), the team becomes stuck with GPS-specific interfaces. All components interfacing with the GPS module would require modification, at least to the degree where interfaces are not exactly similar.
>
>**Better Approach:**
>Use a name like "Position Module" that conveys the module's purpose without hinting at its specific implementation. This name indicates what the module does without revealing internal dependencies. The module can be implemented using GPS, Galileo, or any other positioning system without requiring a name change.

### Why Naming Matters

>[!important] Shared Understanding Through Consistent Terminology
>The entire purpose of a reference architecture is ensuring all development team members share the same concept and understanding of what is being developed. This requires using identical names and terminology across the team.

If one team member refers to a "Location Module" while another calls it a "Position Module," they may interpret the module's function and interfaces very differently:

- A _location_ might refer to a forest or a city, suggesting outputs that classify whether the location is urban or rural
- A _position_ is characterized by coordinates relative to a reference point

>[!example] Impact of Naming Confusion
>While "location" and "position" seem similar, these interpretations differ enough to create potential misunderstandings among team members:
>
>**Location Module Interpretation:**
>- Input: Coordinates
>- Output: Classification (urban/rural/forest/ocean)
>- Interface: `getLocationType()`
>
>**Position Module Interpretation:**
>- Input: Satellite signals
>- Output: Latitude and longitude coordinates
>- Interface: `getCoordinates()`
>
>Such confusion leads to incorrect assumptions about functionality and interfaces, causing problems during integration and reducing team efficiency in product development.

>[!warning] Cost of Naming Inconsistencies
>If naming-related faults aren't detected before acceptance testing, significant time can be lost simply due to unclear wording in a block diagram. Worse yet, incompatible interfaces may require complete module rewrites.

### Method for Developing Module Names

>[!tip] Method: Developing Module Names
>For each requirement, execute the following process:
>
>1. **Identify** the functional part of the requirement
>2. **Ask:** Can this function be included in an existing module?
>3. **If no**, create a new box and give it a useful name
>4. **Add** the function to the related box
>
>After executing this method, the result should be a set of modules containing all necessary functionality as described in the requirement specifications.

### Verification Through Use Cases

>[!question] Completeness Check
>How can we verify that no requirements were missed?

A useful cross-check involves testing each use case against the defined modules by asking:

_"With the defined modules, can we execute on paper each use case that we have developed?"_

>[!tip] Verification Best Practices
>This verification is best performed using pen and paper (or a blackboard), as the process may require redrawing and adjusting the module structure. The manual approach encourages iteration and collaborative discussion.

### Example Case: Temperature and Humidity Monitor

Consider a small system for measuring temperature and humidity with the ability to display historical data. This can be formulated as a user story:

>[!example] User Story
>As a user, I wish to be able to see temperature and humidity so that I can be sure my home working environment is acceptable.

![[Pasted image 20260311142905.png]]

_Figure 5.1: Use case diagram for temperature and humidity monitoring system._

The system is expected to be small, as only a few use cases are considered.

>[!note] Wireless Network Interaction
>The use case "Show historical data" involves transmission of data over a wireless link, requiring interaction with a wireless router. This wireless network actor could be realized as:
>- Software and a wireless interface on the same device that performs measurements
>- An external WiFi modem
>- Another solution
>
>The specific implementation doesn't matter as long as it fulfills the necessary role of transporting data packets in a wireless network.

#### System Requirements

The following requirements can be derived for this system (many more could be added, but these key requirements keep the example concise):

1. System must be able to measure temperature and humidity, with accuracy TBD and time interval TBD
2. System must be able to display current temperature and humidity
3. System must be able to store measurements for historical analysis later
4. System must be able to show graphically on a second device plots of temperature and humidity against time
5. System must be movable and therefore rely on wireless networks
6. System must be able to accept and validate user input

#### Deriving Modules from Requirements

With these requirements in mind, the functional components can be identified:

- Part of the system must measure temperature and humidity → encapsulated in a ***Measurement Module***
- The system needs to show graphical time series plots on a screen → requires a ***GUI Module***
- Movability and easy setup require wireless communication → implemented in a ***Communication Module***

>[!note] Technology-Agnostic Naming
>Notice that the communication module is not called "WiFi," "Bluetooth," or any similar technology-specific name. This avoids dragging in technology decisions at this architectural stage. The module name describes function (communication) rather than implementation (WiFi).

![[Pasted image 20260311142935.png]]

_Figure 5.2: Initial module identification for the temperature and humidity system._

#### Requirements-to-Module Mapping

Blocks can now be mapped back to the requirements to obtain an overview of where requirements will be implemented. This mapping serves as a cross-check for completeness:

| Requirement | 1 | 2 | 3 | 4 | 5 | 6 |
|-------------|---|---|---|---|---|---|
| Measurement | x |   |   |   |   |   |
| User I/O |   | x |   |   |   |   |
| Network and Comm |   |   |   |   | x |   |
| Database |   |   | x |   |   |   |
| Command input |   |   |   |   |   | x |
| GUI |   |   |   | x |   |   |

_Table 5.1.1: Requirements-to-module mapping for completeness verification._

>[!tip] Using the Mapping for Validation
>This mapping can identify potential gaps:
>- **Empty column (module with no requirements):** If a module exists but has no requirements assigned, something may have been forgotten in the requirement specifications, or the module is unnecessary
>- **Empty row (requirement with no module):** If requirements exist without assigned modules, something may be missing in the architecture
>
>This cross-check serves as a guideline rather than an absolute rule - there may be valid cases where the mapping doesn't apply perfectly.

#### Next Steps

The final missing element is defining the interfaces between the newly created modules. At this stage, these interfaces may be vague and high-level, requiring further analysis in subsequent design phases.

---

## Data Flow Analysis

Creating an overview of data or signal flow and the processes involved in various cases helps identify potential modules. A ***flow graph*** is a graphical tool that assists this process, constructed using simple graphic elements.

![[Pasted image 20260311151546.png]]

_Figure 5.3: Standard elements used in flow graphs for system analysis._

### Flow Graph Elements

The elements in a flow diagram reflect different parts of an information or data signal flow:

- **Rectangular boxes**: Data starting or ending points, such as measurement points (starting) or graphical user interfaces (end points)
- **Circles**: Transformations where data undergoes some process from one type to another, such as calculating averages, data formatting, signal processing, or similar operations
- **Arrows**: Flow of information between processes
- **Double lines**: Databases or storage, where data is stored (temporarily or long-term)

### Creating a Flow Graph

>[!tip] Method: Creating a Flow Graph
>Using the flow graph elements, follow this process:
>
>1. **Identify** the starting points (data sources) and ending points (data sinks)
>2. **Draw** rectangular boxes for these sources and sinks
>3. **Determine** the transformations/processes needed between them
>4. **Add** circles for each transformation process
>5. **Connect** elements with arrows showing information flow direction
>6. **Include** storage elements (double lines) where data persistence is needed
>7. **Iterate** and refine with input from other engineers

>[!tip] Iterative Development
>This process requires iteration and benefits from discussion with other engineers, as the necessary processes are not always immediately clear, particularly for less experienced developers.

Even a high-level view of processes proves useful. Processes can always be broken down into smaller subprocesses later through an iterative process or by isolating a process and then detailing it.

>[!example] Process Granularity Examples
>A process might be broadly defined as:
>- "Read data" - which could later be subdivided into: validate sensor → sample ADC → convert to engineering units → buffer result
>- "Store data" - which could involve: format data → check storage capacity → write to memory → verify write operation
>
>Both involve transformation of data but can start at a high level and be refined as needed.

Once processes have been identified, information flows must be assigned. The more detail provided about what information flows between processes, the clearer the system becomes.

>[!warning] Unclear Information Flows
>In cases where information flows are unclear, these must be resolved as soon as possible, as they typically lead to blockages in the development process. Unresolved data flows represent gaps in understanding that will cause integration problems later.

Arrows indicate the direction of information flows. Examples of information flow include user profiles, temperature data, or subscription information.

Storage elements are added whenever there is a need for more than some internal, temporal local variable. This can include internal memory buffers, databases, files, or cloud storage.

### Splitting Processes into Components

Software cannot run without hardware at some point. Physical components are often seen as main system components for good reason - these building blocks are easily identifiable with their wire interfaces, buttons, displays, and other tangible elements, rather than abstract pieces of software with invisible interfaces.

Most processes are naturally divided when executed in different places. Therefore, it is often a good and natural approach to divide system processes into groups depending on which hardware they execute on. However, as later examples show, there are cases where different approaches might be appropriate.

### Defining the Modules

Once the components are identified, the flow graph can be used to identify modules. The flow graph reveals what processes should be expected inside the modules.

>[!tip] Guidelines for Defining Modules
>When in doubt, the following criteria can be considered:
>
>- **Time-dependent criteria**: Processes related to the same event in a system are often useful to combine in the same module
>- **Sequential criteria**: Processes that follow other processes sequentially are often advantageous to combine in the same module
>- **Priority criteria**: Processes that require different priorities should not be combined in the same module

While the first two criteria seem straightforward, the priority criterion requires additional insight.

>[!example] Priority Criterion Explained
>If two processes have different priorities but are placed in the same module:
>- **On a PC:** Executing would require the module to somehow have different priorities - which is impossible for the operating system to manage (a single process/thread has a single priority)
>- **For electrical signals:** This simply doesn't work in practice (a circuit path has a single signal propagation characteristic)

>[!warning] Violating Priority Criteria
>Even if a practical example could be found where different priorities within a module might be doable, it remains a poor design choice because it would violate the timing and sequential criteria. Mixing priorities creates unpredictable behavior and makes debugging extremely difficult.

### Example Case: Temperature and Humidity Monitor Flow Analysis

Following the steps of writing explicit use cases and deriving requirements, the processes from data sources to data sinks are drawn in a flow graph.

![[Pasted image 20260311152330.png]]

_Figure 5.4: Flow graph showing data paths in the temperature and humidity monitoring system._

The diagram shows the different paths that data can take from its origination via sensor interfaces through a read data process, after which data is stored in internal RAM. Data can be accessed via the format data output process that converts internal buffers to averages, max and min values, and converts these into signals for the seven-segment displays.

>[!note] User Interaction Flow
>What is taken from memory and how it is converted depends on the button input and a state variable, allowing a user to cycle through different types of values (max, min, average, etc.). The button and state are handled by the read button process.

On the PC side, there is a GUI (Graphical User Interface), a database for long-term storage, and a terminal for user interaction. To handle input/output with the user and the Arduino, there is a command parser process to accept and manage commands given through the command prompt, and a communication process to enable interaction. This requires a protocol parser process on the Arduino side to ensure the protocol can be properly managed. When receiving historical data on the PC side, data must be injected into the database via a specific database interface. This is handled by a data insert process, and to retrieve data there is an access data process that ensures data is correctly fetched and provided to the GUI.

>[!important] Process Completeness
>All these processes are necessary to perform the required use cases of this setup. Each process identified in the flow graph corresponds to a functional requirement that must be implemented.

![[Pasted image 20260311152356.png]]

_Figure 5.5: Main physical components identified in the system - Arduino and PC._

The above figure shows the main physical components that exist: the Arduino and the PC. No further major components are identified.

>[!note] External Actor: Wireless Network
>Notice that the communication process is alone and not inside a component. This is because the design relies on the external actor "wireless network" - there is no need to develop antennas, MAC (Media Access Control) protocols, security associations, and a complete IP (Internet Protocol) communication stack. These technologies have been developed and refined over decades, so there is no reason to reinvent them.

![[Pasted image 20260311152408.png]]

_Figure 5.6: Final module division showing modules and their relationships._

The above figure shows the main modules and their division. Functionality regarding memory on the Arduino is isolated to a single module, User I/O into another (as they must be read in a coordinated manner), and network communication in its own module.

#### Modules Spanning Multiple Components

Notice how the network module actually spans across the two major physical components. This example demonstrates that modules may not be restricted to a single physical entity but may span several.

>[!important] Benefits of Cross-Component Modules
>The advantage of defining a module this way is that interfaces toward the external actor (the wireless network) can be kept internal to other modules. Developers on both sides can focus on everything else besides the communication setup and related concerns. All design decisions related to the network are isolated from design choices regarding other modules.

>[!example] Database Module Encapsulation
>Similarly with the database - internal changes to tables should not interfere with other submodules, as each has its own process of interacting with the database. This enables a large degree of freedom for designing and updating database tables.
>
>For instance:
>- Database schema can be modified without affecting the GUI module
>- New indexes can be added for performance without changing the data insert process interface
>- The database could even be replaced (MySQL → PostgreSQL) without affecting other modules

### Improved Module Definition

The same modules are achieved through flow analysis as through requirement derivation, but with greater attention to internal processes. This provides a much clearer understanding of how each module should work and what interfaces they will have.

The interfaces are defined by the lines that cross the module boxes. Lines that are internal to a module are not required to be shared with others.

>[!example] Interface Isolation Benefits
>For the network module, only those working with that module need to consider:
>- IP addresses
>- Discovery protocols
>- Configuration issues
>
>The developer for the measurement module doesn't need to consider these at all. This simplifies the later implementation and testing process.

---

## Defining the Modules

Modules are designed to encapsulate design decisions and provide interfaces toward other modules with common functionalities. It is critical to achieve ***high functionality density*** as opposed to low functionality density.

### Functionality Density

Functionality density is a term that describes the relationship between a set of functions.

>[!example] High Functionality Density
>For file operations (implemented in a file system module):
>- `read`
>- `write`
>- `append`
>
>These three functions are closely related and compose high density functionality. They all operate on the same type of entity (files) and share common concepts (file handles, positions, buffers).

>[!example] Low Functionality Density
>Functions like:
>- `send via email`
>- `publish on web`
>- `encrypt file`
>
>While potentially relevant for files, these are not closely tied together and require highly specialized sub-functionalities:
>- Email connections (SMTP protocols, authentication)
>- FTP (File Transfer Protocol) connections (network protocols, directory management)
>- Encryption libraries (key management, algorithms)
>
>This would mean the file module must include numerous extra internal sub-functionalities and interfaces, resulting in low functionality density.

>[!tip] Module Naming as an Indicator
>Module names often reflect functionality density. Consider the following:
>
>**Poor Module Name:** "Diverse Module"
>- This name conveys nothing meaningful about its purpose, functionality, or interface
>- What can be expected from a module where one finds unrelated functionalities pulled out like rabbits from a magician's hat?
>
>**Good Module Name:** "Temperature Sensor Module"
>- Clearly indicates functionality related to reading temperature
>- There may be many temperature-related functions (`readTemperature()`, `calibrateTemperatureSensor()`, `getTemperatureRange()`), but they all relate to temperature
>- Not to light, sound level, or other unrelated measurements

### Creating Sub-Modules

The procedure for designing modules follows the same principle as splitting them into sub-modules, though the starting point differs slightly. At this stage, there is a set of functionalities assigned to the particular module that needs to be executed.

A module can often be split into submodules and possibly subdivided further to create a tree-like structure of a system. This is beneficial in cases where:
- A set of functionalities in a module becomes larger than a simple implementation can offer
- The module is distributed across multiple components

![[Pasted image 20260311152723.png]]

_Figure 5.7: Conceptual breakdown of a module into submodules showing input processing, core functionality, and output processing._

The concept is illustrated in the above figure, showing how modules may be broken down into sub-functionalities. Often there is a need to rework input from an interface to some internal module-specific signal or data type, followed by the process itself, and then output manipulation to fit another interface.

Ideally, the input and output processing is minimal, but in some cases this may be quite complex.

>[!example] Complex Input/Output Processing
>Examples of complex interface adaptation include:
>
>**Input Processing:**
>- Parsing XML-formatted input from a web function call (the interface) before the module can process it
>  - Parse XML → Validate schema → Extract data → Convert to internal objects
>
>**Output Processing:**
>- Formatting data into SQL (Structured Query Language) for output to an SQL database
>  - Validate data types → Escape special characters → Format query → Execute transaction

These input/output parts may be broken into submodules, and a complete tree of modules may arise depending on complexity. In this way, a complete tree of modules and functionalities may be drawn if done carefully, as shown conceptually in the following figure.

![[Pasted image 20260311152738.png]]

_Figure 5.8: Comparison of balanced (left) and unbalanced (right) module tree structures._

### Balanced vs. Unbalanced Module Trees

Ideally, when creating a module hierarchy, the result would be a balanced tree like the left side of Figure 5.8. However, this is not always possible. It should be avoided as much as possible to end up in situations like the right side, showing a highly unbalanced tree.

>[!warning] Risks of Unbalanced Module Trees
>The unbalanced approach often leads to:
>- Unexpected complexities in deeply nested paths
>- Difficult debugging (problems can be hidden deep in the hierarchy)
>- Challenging validation (testing all paths becomes complicated)
>
>This is particularly problematic because it is often caused by use of external actors (like the wireless network) over which developers have no control.

>[!note] Practical Reality of Unbalanced Trees
>However, in the case of the wireless network, it is hard to see alternative options. Additionally, protocol stacks used are expected to have been properly tested - after all, most modern ICT (Information and Communication Technology) today depends on these working fairly well. Sometimes unbalanced trees are unavoidable when interfacing with complex external systems.

### Reaching the Component Level

At some point in the system engineering process, a level is reached where there is no knowledge, skills, or resources (time, money, or both) to subdivide further. This could occur when using:
- A GPS unit purchased from a vendor
- A communication network protocol stack (TCP or UDP)
- A commercial temperature sensor with built-in calibration
- A graphics processing library

There is no intention to rebuild the internals of those modules and functions - the goal is simply to use them. At that level of the module hierarchy, the ***lowest level*** has been reached - where each element being used is actually a component used to construct the smallest module.

>[!important] Building Upward
>Subsequently, higher-level modules are constructed from these lowest-level components until a system-level module composition is reached. This bottom-up assembly ensures that each layer builds upon verified, functional components.

---

## Interfaces

Interfaces between defined modules are determined by the precise functionality of the module.

>[!example] Database Module Interfaces
>Consider a database module responsible for reading and writing data into databases. The following interfaces seem natural:
>- `initialize`
>- `readData`
>- `writeData`
>- `updateData`
>
>But considering that faults could happen, it may be worthwhile to add:
>- `getErrorDetails`
>
>For testing purposes, test interfaces might be adopted:
>- `testWrite` - Behind these interfaces, the database module relies on the same functionality as the proper interfaces but redirects data input/output to a test database
>- `testRead` - These can be executed at any time without disturbing a running production system while still allowing tests

>[!warning] Security Trade-offs
>Test interfaces are classical pathways for security holes that may be exploited. Trade-offs must be made between:
>- **Security:** Limiting access points to reduce attack surface
>- **Convenience:** Easy testing and debugging capabilities
>- **Testing needs:** Comprehensive validation of functionality
>
>Consider implementing test interfaces only in development builds or protecting them with authentication.

### Specifications of Interfaces

Hardware interfaces work similarly to software interfaces, though the parameters differ. Instead of discussing function calls and data types, hardware specifications may include:

- **Plug standards:** RJ45, DIN 41524, DB-25, USB-C, etc.
- **Voltage levels:** 10V, 12V, 230V AC, 3.3V logic, etc.
- **Current constraints:** max 1A, 500mA nominal, etc.
- **Frequency ranges:** 10kHz, 1MHz, DC to 20kHz, etc.
- **Impedance:** 1kΩ, 1MΩ, 50Ω, 75Ω, etc.

In both cases, modules must be describable with clear specifications, for example as shown in the following table:

| Interface name | Input | Output |
|----------------|-------|--------|
| readData | sensor selector [number] | value [float] |
| initialize | sample interval [ms] | N/A |
| signalIn | line signal [-10mV → 10mV] [1-20kHz] [10kΩ] [3 pin DIN 41524] | N/A |

_Table 5.2.1: Example module interface specification showing both software and hardware interfaces._

The example in the above table shows a case for a module that covers both hardware and software. With this specification, developers can be trusted to create the needed software and hardware. Other developers can focus on simply calling the `readData` function in their own modules and expect that only a cable connection from the sensor via a 3-pin DIN 41524 plug is needed.

>[!example] Consequences of Misalignment
>If the developer misunderstood and used a 5-pin version instead of 3-pin:
>- Problems arise (though they are fixable)
>- May require rewiring or adapter cables
>- Could delay integration testing
>
>If the function for `readData` does not expect a selector parameter:
>- Confusion occurs about how to read sensor number 3, for example
>- May require API (Application Programming Interface) changes across multiple modules
>- Could break existing code that calls the function

### Interface Adaptation Blocks

In cases where interfaces to the outside of the module are not aligned to the internal data or signal type, interface adaptation blocks must be added.

>[!example] Server with SOAP Interface
>**Scenario:** A server (one of the modules in a given system) whose external interface is SOAP (Simple Object Access Protocol) performs several functions, such as statistics.
>
>**Solution:** One submodule can be a SOAP Handler that converts external SOAP messages to internal data objects.
>
>**Benefit:** Libraries typically exist for such conversion, making this submodule very convenient for faster development. The rest of the server works with clean internal objects, not XML parsing.

>[!example] Power Amplifier
>**Scenario:** A power amplifier for a HiFi system broken into several minor submodules, such as:
>- Current amplifier
>- Voltage mirror
>- Impedance matching stage
>- And so forth
>
>**Interface Characteristics:** Each has its own:
>- Input/output voltage ranges
>- Current ranges
>- Frequency response
>- Dedicated function
>
>**Design Approach:** Each may be designed individually before finally forming a power output module. Interface adaptation ensures the output of one stage matches the input requirements of the next.

### Practical Considerations

>[!important] Key Aspects for Defining Interfaces and Modules
>Consider the following aspects while defining interfaces and modules:

**High Functionality Density**
Keep functionality density high and interfaces closely related. This avoids confusion and misunderstanding and eases reusability later on.

>[!example] High Density Example
>**Good:** File module with `open()`, `read()`, `write()`, `close()`, `seek()`
>- All operations relate to file manipulation
>- Developers immediately understand the module's purpose
>
>**Bad:** File module with `open()`, `sendEmail()`, `compressImage()`, `calculateTax()`
>- Unrelated functionalities confuse the module's purpose
>- Difficult to understand, test, and reuse

**Reusability**
Design modules to be reusable for other projects. Consider generalization of interfaces beyond the particular project.

>[!tip] Designing for Reusability
>Instead of creating a "Temperature Monitor for Home Office" module, create a generic "Temperature Sensor Interface" module that:
>- Accepts any temperature sensor type
>- Provides standardized output format
>- Handles common error conditions
>- Can be reused in industrial, automotive, or medical applications

**Maintainability**
Modules need maintenance later on (even prototypes easily require updates). If modules are hard to replace - either because they are physically impractical to change or because software updates require modifying numerous libraries each time - consider more practical design aspects from the start.

>[!example] Maintainability Considerations
>**Poor Maintainability:**
>- Sensor soldered directly to main board
>- 15 different files must be modified to update a single interface
>- Proprietary communication protocol with no documentation
>
>**Good Maintainability:**
>- Sensor on removable connector
>- Single header file defines interface; all modules include it
>- Standard protocol (I2C, SPI) with clear documentation

**Intermediate Deliveries**
Referring back to the W model in planning, define intermediate versions that have proper interfaces but not strictly working functionality. This allows other module developers to test against your interface, which eases the integration process of modules later on.

>[!example] Interface Stub Implementation
>Create a "stub" version of a complex database module that:
>- Implements all interface functions
>- Returns dummy data or success codes
>- Logs all function calls for verification
>- Allows other modules to be developed and tested in parallel
>
>Later, the internal implementation can be completed without changing the interface.

**Test Interfaces**
Testing is critical, but if it is extremely hard to test, huge amounts of time can be spent setting up tests.

>[!example] Hardware Testing Considerations
>For example, measuring voltages or currents on a printed circuit board (PCB) can be extremely difficult if not considered from the start:
>- Internal nodes may be inaccessible once board is assembled
>- High-frequency signals may be disturbed by probe connections
>- Power consumption measurements require breaking circuit paths
>
>This is why JTAG (Joint Test Action Group) interfaces are often implemented on printed circuits - they provide test access without physical probing.

**Fault and Error Conditions**
Faults and errors _will_ occur according to Murphy's law. If these are not considered, the system is left open to unpredictable behavior and security risks.

>[!warning] Importance of Error Handling
>Trade-offs must be made between:
>- **Level of robustness:** How many error conditions to handle
>- **Time investment:** Development time for error handling code
>- **Money investment:** Testing and validation costs
>
>However, completely ignoring error conditions is never acceptable in production systems.

>[!example] Error Condition Examples
>Consider these potential faults:
>- **Sensor failure:** Module returns `ERROR_SENSOR_DISCONNECTED` instead of invalid data
>- **Network timeout:** Module implements retry logic with exponential backoff
>- **Invalid input:** Module validates parameters and returns `ERROR_INVALID_PARAMETER`
>- **Resource exhaustion:** Module checks memory availability before allocation
>
>Each of these requires interface design that supports error reporting and handling.

---

## Common Pitfalls

>[!warning] Common Pitfalls to Avoid
>The following mistakes frequently occur during system breakdown and module design. Being aware of these pitfalls can save significant time and resources:
>
>**Architecture & Planning:**
>- **Insufficient stakeholder agreement:** Proceeding with implementation before all parties agree on the reference architecture leads to expensive rework
>- **Rushing the breakdown process:** Not allocating sufficient time for careful module definition causes integration problems later
>
>**Naming & Communication:**
>- **Technology-specific naming:** Using names like "GPS Module" or "WiFi Module" instead of function-based names locks in implementation decisions prematurely
>- **Inconsistent terminology:** Team members using different names for the same module causes misunderstandings and incompatible interfaces
>- **Vague module names:** Names like "Diverse Module" or "Utility Module" indicate low functionality density and poor design
>
>**Module Design:**
>- **Low functionality density:** Combining unrelated functions in a single module creates maintenance nightmares and reduces reusability
>- **Mixing priorities:** Placing processes with different priority requirements in the same module leads to unpredictable behavior
>- **Deeply unbalanced trees:** Excessive nesting in module hierarchies makes debugging and validation extremely difficult
>
>**Interface Design:**
>- **Unclear information flows:** Leaving data flows undefined blocks development progress and causes integration failures
>- **Ignoring error conditions:** Failing to design interfaces that support error reporting leaves systems vulnerable to unpredictable behavior
>- **Misaligned interface specifications:** Misunderstandings about connector types, data formats, or parameters cause integration delays
>
>**Testing & Security:**
>- **Unprotected test interfaces:** Leaving test interfaces in production code creates security vulnerabilities
>- **Inaccessible test points:** Not planning for hardware testing access makes validation extremely time-consuming
>- **No intermediate deliveries:** Failing to create interface stubs prevents parallel development and delays integration

---

>[!summary] Summary
>
>**System Breakdown Principles:**
>- Systems must be divided into manageable modules following the ***divide et impera*** principle
>- A ***reference architecture*** defines the agreed-upon module structure and must be established before implementation
>- Disagreement on system breakdown leads to expensive problems during development
>
>**Modules and Encapsulation:**
>- A ***module*** is a logical entity that encapsulates implementation decisions and provides well-defined interfaces
>- Internal implementation can vary widely (simple code to complex subsystems) as long as the interface contract is met
>- Encapsulation allows developers to focus on different levels of design without understanding all internal details
>
>**Creating Reference Architectures:**
>- Reference architectures consist of boxes (modules) and lines (interfaces)
>- Design process: Define modules first, then define interfaces between them
>- Proper naming is critical - names should describe function, not implementation
>- Modules can span multiple physical components when appropriate
>
>**Deriving Modules from Requirements:**
>- Process: Identify functional parts → Check if existing module fits → Create new module if needed → Assign function
>- Verify completeness by testing use cases against defined modules
>- Create requirements-to-module mapping tables to identify gaps
>- Use technology-agnostic names to preserve implementation flexibility
>
>**Data Flow Analysis:**
>- ***Flow graphs*** visualize data movement through the system using standard elements:
>  - Rectangles: Data sources/sinks
>  - Circles: Transformation processes
>  - Arrows: Information flows
>  - Double lines: Storage
>- Processes are naturally divided based on hardware execution location
>- Module definition criteria: time-dependent, sequential, and priority considerations
>- Processes with different priorities should not be combined in the same module
>
>**Module Organization:**
>- Achieve ***high functionality density*** by grouping closely related functions
>- Low functionality density (unrelated functions) creates confusion and maintenance problems
>- Module names should reflect purpose and indicate functionality density
>- Modules can be hierarchically subdivided into submodules as needed
>- Balanced module trees are preferable to deeply unbalanced structures
>- Stop subdivision at the component level (purchased parts, external libraries)
>
>**Interface Design:**
>- Interfaces must precisely specify inputs, outputs, and interaction methods
>- Software interfaces: function calls, data types, return values, error codes
>- Hardware interfaces: connectors, voltage levels, current limits, frequency ranges, impedance
>- Interface adaptation blocks handle mismatches between external and internal formats
>- Consider test interfaces for validation, but balance security risks
>
>**Critical Design Considerations:**
>1. **High Functionality Density:** Related functions grouped together
>2. **Reusability:** Design for use beyond current project
>3. **Maintainability:** Enable updates without extensive modifications
>4. **Intermediate Deliveries:** Create interface stubs for parallel development
>5. **Test Interfaces:** Plan for validation from the start
>6. **Error Handling:** Design interfaces to support fault conditions and error reporting
>
>**Key Takeaway:**
>The reference architecture serves as a contract among all stakeholders. Careful upfront planning of modules and interfaces prevents expensive rework and enables efficient parallel development, integration, and testing.