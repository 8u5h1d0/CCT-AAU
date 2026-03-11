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
- - -
## System Breakdown

The process of breaking down a system into manageable modules and components is essential for team-based development. This approach follows the principle of ***divide et impera*** (divide and conquer) - dividing the system into smaller, achievable pieces to successfully accomplish the overall goal.

**The Challenge of System Division**
System division is frequently a major point of discussion and disagreement among stakeholders. Different perspectives on how to divide the system can lead to frustration and problems during development. The modules created through this division collectively form a ***reference architecture*** that all parties must agree upon before implementation begins.

>[!warning] Consequences of Disagreement
>If team members disagree, misunderstand, or hold differing viewpoints about the system breakdown, problems will emerge later in the development process. These issues require expensive mitigation efforts, often involving costly implementation iterations. Such problems must be avoided through careful initial planning.

**Importance of Careful Planning**
The breakdown of a system into modules must be performed carefully and deliberately. Sufficient time should be allocated to ensure that all stakeholders reach agreement on the reference architecture. This upfront investment in planning prevents expensive corrections and rework during later stages of development.

The reference architecture serves as a fundamental agreement among all involved parties about how the system will be structured. Without this shared understanding, the development process faces significant risks of miscommunication, incompatible components, and project delays.
## From System Requirements to Reference Architecture

The process of transforming requirements into a system design requires identifying core functionality and mapping it to appropriately named modules with proper interfaces. An experienced engineer can extract the essential functions from requirements and translate them into a modular system structure.

### What is a Module?

>[!summary] Definition: Module
>A module is a logical entity that allows interaction by other modules and encapsulates and protects any implementation-specific decisions.
>
>For software, It's a coding "block" that can be put together with other such "blocks"  to create an overall, coherent structure. (kinda like LEGO-blocks to make a physical structure.)

This definition establishes a module as a functional unit that performs specific tasks without requiring external knowledge of its internal workings. The module accepts inputs and provides outputs according to its defined functionality.

#### Implementation Flexibility

A module's internal implementation can take many forms - it could be:
- Complex and futuristic technology
- A single line of code
- 10,000 transistors
- A distributed subsystem
- Any other implementation approach

The critical requirement is that the module performs the desired and expected functionality while accepting specified inputs and providing expected outputs. The actual implementation method is irrelevant to external users of the module.

#### Encapsulation Benefits

Encapsulating implementation-specific decisions allows developers to focus on design at different levels. For example, when working with a WiFi module, developers don't need to understand its internal workings - they only need to understand how to use the interface and what functionality it provides.

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

The design process begins with defining the modules (boxes) and then proceeds to defining the interfaces (lines) between them.
## Using Requirements to Derive Modules

Abstracting expected functionality into boxes represents the first step in shielding implementation decisions within closed environments that enable parallel development. This abstraction is accomplished most simply by assigning proper names to modules that will later host the functionality specified in requirements.

### The Importance of Proper Naming

>[!example] Naming Example: Position Finding
>Consider a requirement stating: _"The system must be able to find its position (latitude, longitude)."_
>
>It may be tempting to specify a GPS module, which has pre-defined interfaces and clear functional descriptions. A GPS module would satisfy all requirements - so why not use this name?
>
>**The Problem**: If the system later needs to switch to Galileo or GLONASS (Russian location system), the team becomes stuck with GPS-specific interfaces. All components interfacing with the GPS module would require modification, at least to the degree where interfaces are not exactly similar.
>
>**Better Approach**: Use a name like "Position Module" that conveys the module's purpose without hinting at its specific implementation. This name indicates what the module does without revealing internal dependencies. The module can be implemented using GPS, Galileo, or any other positioning system without requiring a name change.

### Why Naming Matters

>[!important] Shared Understanding Through Consistent Terminology
>The entire purpose of a reference architecture is ensuring all development team members share the same concept and understanding of what is being developed. This requires using identical names and terminology across the team.

If one team member refers to a "Location Module" while another calls it a "Position Module," they may interpret the module's function and interfaces very differently:

- A _location_ might refer to a forest or a city, suggesting outputs that classify whether the location is urban or rural
- A _position_ is characterized by coordinates relative to a reference point

While similar, these interpretations differ enough to create potential misunderstandings among team members. Such confusion leads to incorrect assumptions about functionality and interfaces, causing problems during integration and reducing team efficiency in product development.

>[!warning] Cost of Naming Inconsistencies
>Worse yet, if naming-related faults aren't detected before acceptance testing, significant time can be lost simply due to unclear wording in a block diagram.

### Method for Developing Module Names

For each requirement, execute the following process:

1. Identify the functional part of the requirement
2. Ask: Can this function be included in an existing module?
3. If no, create a new box and give it a useful name
4. Add the function to the related box

After executing this method, the result should be a set of modules containing all necessary functionality as described in the requirement specifications.

### Verification Through Use Cases

>[!question] Completeness Check
>How can we verify that no requirements were missed?

A useful cross-check involves testing each use case against the defined modules by asking:

_"With the defined modules, can we execute on paper each use case that we have developed?"_

This verification is best performed using pen and paper (or a blackboard), as the process may require redrawing and adjusting the module structure.
### Example Case

Consider a small system for measuring temperature and humidity with the ability to display historical data. This can be formulated as a user story:

>[!example] User Story
>As a user, I wish to be able to see temperature and humidity so that I can be sure my home working environment is acceptable.

![[Pasted image 20260311142905.png]]

The system is expected to be small, as only a few use cases are considered. 

>[!note] Wireless Network Interaction
>The use case "Show historical data" involves transmission of data over a wireless link, requiring interaction with a wireless router. This wireless network actor could be realized as software and a wireless interface on the same device that performs measurements, or it could be an external WiFi modem or another solution. The specific implementation doesn't matter as long as it fulfills the necessary role of transporting data packets in a wireless network.

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
>Notice that the communication module is not called "WiFi," "Bluetooth," or any similar technology-specific name. This avoids dragging in technology decisions at this architectural stage.

![[Pasted image 20260311142935.png]]

#### Requirements-to-Module Mapping

Blocks can now be mapped back to the requirements to obtain an overview of where requirements will be implemented. This mapping serves as a cross-check for completeness:

**Requirements-to-Module Mapping**

| Requirement      | 1   | 2   | 3   | 4   | 5   | 6   |
| ---------------- | --- | --- | --- | --- | --- | --- |
| Measurement      | x   |     |     |     |     |     |
| User I/O         |     | x   |     |     |     |     |
| Network and Comm |     |     |     |     | x   |     |
| Database         |     |     | x   |     |     |     |
| Command input    |     |     |     |     |     | x   |
| GUI              |     |     |     | x   |     |     |

>[!tip] Using the Mapping for Validation
>This mapping can identify potential gaps:
>- If a module exists but has no requirements assigned, something may have been forgotten in the requirement specifications
>- If requirements exist without assigned modules, something may be missing in the architecture

This cross-check serves as a guideline rather than an absolute rule - there may be valid cases where the mapping doesn't apply perfectly.

#### Next Steps

The final missing element is defining the interfaces between the newly created modules. At this stage, these interfaces may be vague and high-level, requiring further analysis in subsequent design phases.
## Data Flow Analysis

Creating an overview of data or signal flow and the processes involved in various cases helps identify potential modules. A ***flow graph*** is a graphical tool that assists this process, constructed using simple graphic elements.

![[Pasted image 20260311151546.png]]

### Flow Graph Elements

The elements in a flow diagram reflect different parts of an information or data signal flow:

- **Rectangular boxes**: Data starting or ending points, such as measurement points (starting) or graphical user interfaces (end points)
- **Circles**: Transformations where data undergoes some process from one type to another, such as calculating averages, data formatting, signal processing, or similar operations
- **Arrows**: Flow of information between processes
- **Double lines**: Databases or storage, where data is stored (temporarily or long-term)

### Creating a Flow Graph

Using these elements, create a drawing that captures the starting and ending points of data and the various subprocesses identifiable between them. This process requires iteration and benefits from discussion with other engineers, as the necessary processes are not always immediately clear, particularly for less experienced developers.

Even a high-level view of processes proves useful. Processes can always be broken down into smaller subprocesses later through an iterative process or by isolating a process and then detailing it. For example, a process might be "read data" or "store data," both involving transformation of data.

Once processes have been identified, information flows must be assigned. The more detail provided about what information flows between processes, the clearer the system becomes. In cases where information flows are unclear, these must be resolved as soon as possible, as they typically lead to blockages in the development process.

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

While the first two criteria seem straightforward, the priority criterion requires additional insight. If two processes have different priorities but are placed in the same module, executing on a PC would require the module to somehow have different priorities - which is impossible for the operating system to manage. For electrical signals, this simply doesn't work in practice.

>[!warning] Violating Priority Criteria
>Even if a practical example could be found where different priorities within a module might be doable, it remains a poor design choice because it would violate the timing and sequential criteria.

### Example Case

Following the steps of writing explicit use cases and deriving requirements, the processes from data sources to data sinks are drawn in a flow graph.

![[Pasted image 20260311152330.png]]

The diagram shows the different paths that data can take from its origination via sensor interfaces through a read data process, after which data is stored in internal RAM. Data can be accessed via the format data output process that converts internal buffers to averages, max and min values, and converts these into signals for the seven-segment displays. What is taken from memory and how it is converted depends on the button input and a state variable, allowing a user to cycle through different types of values (max, min, average, etc.). The button and state are handled by the read button process.

On the PC side, there is a GUI, a database for long-term storage, and a terminal for user interaction. To handle input/output with the user and the Arduino, there is a command parser process to accept and manage commands given through the command prompt, and a communication process to enable interaction. This requires a protocol parser process on the Arduino side to ensure the protocol can be properly managed. When receiving historical data on the PC side, data must be injected into the database via a specific database interface. This is handled by a data insert process, and to retrieve data there is an access data process that ensures data is correctly fetched and provided to the GUI.

![[Pasted image 20260311152356.png]]

All these processes are necessary to perform the required use cases of this setup. Figure 5.5 shows the main physical components that exist: the Arduino and the PC. No further major components are identified.

>[!note] External Actor: Wireless Network
>Notice that the communication process is alone and not inside a component. This is because the design relies on the external actor "wireless network" - there is no need to develop antennas, MAC protocols, security associations, and a complete IP communication stack. These technologies have been developed and refined over decades, so there is no reason to reinvent them.

![[Pasted image 20260311152408.png]]

Figure 5.6 shows the main modules and their division. Functionality regarding memory on the Arduino is isolated to a single module, User I/O into another (as they must be read in a coordinated manner), and network communication in its own module.

#### Modules Spanning Multiple Components

Notice how the network module actually spans across the two major physical components. This example demonstrates that modules may not be restricted to a single physical entity but may span several.

The advantage of defining a module this way is that interfaces toward the external actor (the wireless network) can be kept internal to other modules. Developers on both sides can focus on everything else besides the communication setup and related concerns. All design decisions related to the network are isolated from design choices regarding other modules.

Similarly with the database - internal changes to tables should not interfere with other submodules, as each has its own process of interacting with the database. This enables a large degree of freedom for designing and updating database tables.

### Improved Module Definition

The same modules identified in Section 5.2 are achieved here, but with greater attention to internal processes. This provides a much clearer understanding of how each module should work and what interfaces they will have.

The interfaces are defined by the lines that cross the module boxes. Lines that are internal to a module are not required to be shared with others. For example, for the network module, only those working with that module need to consider IP addresses, discovery, and other configuration issues - the developer for the measurement module doesn't need to consider these at all. This simplifies the later implementation and testing process.
## Defining the Modules

Modules are designed to encapsulate design decisions and provide interfaces toward other modules with common functionalities. It is critical to achieve ***high functionality density*** as opposed to low functionality density.

### Functionality Density

Functionality density is a term that describes the relationship between a set of functions. For example, `read`, `write`, and `append` are closely related functions for file operations (implemented in a file system module). These three functions together compose high density functionality.

In contrast, functions like `send via email`, `publish on web`, and `encrypt file` - while potentially relevant for files - are not closely tied together and require highly specialized sub-functionalities (email connections, FTP connections, encryption libraries). This would mean the file module must include numerous extra internal sub-functionalities and interfaces, resulting in low functionality density.

>[!tip] Module Naming as an Indicator
>Module names often reflect functionality density. If a module must be named "diverse," this name conveys nothing meaningful about its purpose, functionality, or interface. What can be expected from a module where one finds unrelated functionalities pulled out like rabbits from a magician's hat?
>
>Much better is a module named "temperature sensor" because it clearly indicates functionality related to reading temperature. There may be many temperature-related functions, but they all relate to temperature - not to light or sound level, for example.

### Creating Sub-Modules

The procedure for designing modules follows the same principle as splitting them into sub-modules, though the starting point differs slightly. At this stage, there is a set of functionalities assigned to the particular module that needs to be executed.

A module can often be split into submodules and possibly subdivided further to create a tree-like structure of a system. This is beneficial in cases where:
- A set of functionalities in a module becomes larger than a simple implementation can offer
- The module is distributed across multiple components

![[Pasted image 20260311152723.png]]

The concept is illustrated in Figure 5.7, showing how modules may be broken down into sub-functionalities. Often there is a need to rework input from an interface to some internal module-specific signal or data type, followed by the process itself, and then output manipulation to fit another interface.

Ideally, the input and output processing is minimal, but in some cases this may be quite complex. Examples include:
- Parsing XML-formatted input from a web function call (the interface) before the module can process it
- Formatting data into SQL for output to an SQL database

These input/output parts may be broken into submodules, and a complete tree of modules may arise depending on complexity. In this way, a complete tree of modules and functionalities may be drawn if done carefully, as shown conceptually in Figure 5.8.

![[Pasted image 20260311152738.png]]

### Balanced vs. Unbalanced Module Trees

Ideally, when creating a module hierarchy, the result would be a balanced tree like the left side of Figure 5.8. However, this is not always possible. It should be avoided as much as possible to end up in situations like the right side, showing a highly unbalanced tree.

>[!warning] Risks of Unbalanced Module Trees
>The unbalanced approach often leads to unexpected complexities and makes debugging and validation more difficult later on. This is particularly problematic because it is often caused by use of external actors (like the wireless network) over which developers have no control.

However, in the case of the wireless network, it is hard to see alternative options. Additionally, protocol stacks used are expected to have been properly tested - after all, most modern ICT today depends on these working fairly well.

### Reaching the Component Level

At some point in the system engineering process, a level is reached where there is no knowledge, skills, or resources (time, money, or both) to subdivide further. This could occur when using:
- A GPS unit purchased from a vendor
- A communication network protocol stack (TCP or UDP)

There is no intention to rebuild the internals of those modules and functions - the goal is simply to use them. At that level of the module hierarchy, the ***lowest level*** has been reached - where each element being used is actually a component used to construct the smallest module.

Subsequently, higher-level modules are constructed until a system-level module composition is reached.
## Interfaces

Interfaces between defined modules are determined by the precise functionality of the module. Consider a database module responsible for reading and writing data into databases. The interfaces `initialize`, `readData`, `writeData`, and `updateData` seem natural, but considering that faults could happen, it may be worthwhile to add `getErrorDetails`.

For testing purposes, test interfaces such as `testWrite` and `testRead` might be adopted. Behind these interfaces, the database module relies on the same functionality as the proper interfaces but redirects data input/output to a test database. These can be executed at any time without disturbing a running production system while still allowing tests.

>[!warning] Security Trade-offs
>Test interfaces are classical pathways for security holes that may be exploited. Trade-offs must be made between security, convenience, and testing needs.

### Specifications of Interfaces

Hardware interfaces work similarly to software interfaces, though the parameters differ. Instead of discussing function calls and data types, hardware specifications may include:

- Plug standards (RJ45, DIN 41524, DB-25, etc.)
- Voltage levels (10V, 12V, 230V AC)
- Current constraints (max 1A)
- Frequency ranges (10kHz, 1MHz)
- Impedance (1kΩ, 1MΩ)

In both cases, modules must be describable with clear specifications, for example as shown in Table 5.1:

**Table 5.1: Example Module Interface Specification**

| Interface name | Input | Output |
|----------------|-------|--------|
| readData | sensor selector [number] | value [float] |
| initialize | sample interval [ms] | N/A |
| signalIn | line signal [-10mV -> 10mV] [1-20kHz] [10kΩ] [3 pin DIN 41524] | N/A |

The example in Table 5.1 shows a case for a module that covers both hardware and software. With this specification, developers can be trusted to create the needed software and hardware. Other developers can focus on simply calling the `readData` function in their own modules and expect that only a cable connection from the sensor via a 3-pin DIN 41524 plug is needed.

>[!example] Consequences of Misalignment
>If the developer misunderstood and used a 5-pin version instead of 3-pin, problems arise (though they are fixable). If the function for `readData` does not expect a selector parameter, confusion occurs about how to read sensor number 3, for example.

### Interface Adaptation Blocks

In cases where interfaces to the outside of the module are not aligned to the internal data or signal type, interface adaptation blocks must be added. Consider two cases:

1. **Server with SOAP Interface**: A server (one of the modules in a given system) whose external interface is SOAP (Simple Object Access Protocol) performs several functions, such as statistics. One submodule can be a SOAP Handler that converts external SOAP messages to internal data objects. Libraries typically exist for such conversion, making this submodule very convenient for faster development.

2. **Power Amplifier**: A power amplifier for a HiFi system broken into several minor submodules, such as current amplifier, voltage mirror, and so forth. Each has its own input/output voltage and current ranges, frequency response, and dedicated function. Each may be designed individually before finally forming a power output module.

### Practical Considerations

>[!important] Key Aspects for Defining Interfaces and Modules
>Consider the following aspects while defining interfaces and modules:

- **High Functionality Density**: Keep functionality density high and interfaces closely related. This avoids confusion and misunderstanding and eases reusability later on.

- **Reusability**: Design modules to be reusable for other projects. Consider generalization of interfaces beyond the particular project.

- **Maintainability**: Modules need maintenance later on (even prototypes easily require updates). If modules are hard to replace - either because they are physically impractical to change or because software updates require modifying numerous libraries each time - consider more practical design aspects from the start.

- **Intermediate Deliveries**: Referring back to the W model in planning, define intermediate versions that have proper interfaces but not strictly working functionality. This allows other module developers to test against your interface, which eases the integration process of modules later on.

- **Test Interfaces**: Testing is critical, but if it is extremely hard to test, huge amounts of time can be spent setting up tests. For example, measuring voltages or currents on a printed circuit board can be extremely difficult if not considered from the start. (This is why JTAG interfaces are often implemented on printed circuits.)

- **Fault and Error Conditions**: Faults and errors _will_ occur according to Murphy's law. If these are not considered, the system is left open to unpredictable behavior and security risks. Trade-offs must be made between the level of robustness and the amount of time and money spent on design for these conditions.