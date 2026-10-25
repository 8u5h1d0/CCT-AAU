---
tags:
  - CCT3
  - indlejrede_systemer
Topic: RTOS, Kernel functions, processes, scheduling states, context
Semester: CCT3
Course: Programmering af indlejrede systemer
Litterature:
  - Mastering-the-FreeRTOS-Real-Time-Kernel.v1.1.0
  - OperatingSystemFoundations_textbook
Created: 25-10-2026
---
- - -
## Table of Contents

1. [[#1.1 Multitasking in Small Embedded Systems|1.1 Multitasking in Small Embedded Systems]]
	1. [[#1.1 Multitasking in Small Embedded Systems#1.1.1 About the FreeRTOS Kernel|1.1.1 About the FreeRTOS Kernel]]
	2. [[#1.1 Multitasking in Small Embedded Systems#1.1.2 Value Proposition|1.1.2 Value Proposition]]
	3. [[#1.1 Multitasking in Small Embedded Systems#1.1.3 A Note About Terminology|1.1.3 A Note About Terminology]]
	4. [[#1.1 Multitasking in Small Embedded Systems#1.1.4 Why Use an RTOS?|1.1.4 Why Use an RTOS?]]
	5. [[#1.1 Multitasking in Small Embedded Systems#1.1.5 FreeRTOS Kernel Features|1.1.5 FreeRTOS Kernel Features]]
	6. [[#1.1 Multitasking in Small Embedded Systems#1.1.6 Licensing and the FreeRTOS Family|1.1.6 Licensing and the FreeRTOS Family]]
2. [[#1.2 Included Source Files and Projects|1.2 Included Source Files and Projects]]
	1. [[#1.2 Included Source Files and Projects#1.2.1 Obtaining Example Code|1.2.1 Obtaining Example Code]]
3. [[#4 Task Management|4 Task Management]]
	1. [[#4 Task Management#4.1 Introduction|4.1 Introduction]]
		1. [[#4.1 Introduction#4.1.1 Scope|4.1.1 Scope]]
	2. [[#4 Task Management#4.2 Task Functions|4.2 Task Functions]]
	3. [[#4 Task Management#4.3 Top Level Task States|4.3 Top Level Task States]]
	4. [[#4 Task Management#4.4 Task Creation|4.4 Task Creation]]
		1. [[#4.4 Task Creation#4.4.1 The `xTaskCreate()` API Function|4.4.1 The `xTaskCreate()` API Function]]
	5. [[#4 Task Management#4.5 Task Priorities|4.5 Task Priorities]]
		1. [[#4.5 Task Priorities#4.5.1 Generic Scheduler|4.5.1 Generic Scheduler]]
		2. [[#4.5 Task Priorities#4.5.2 Architecture-Optimized Scheduler|4.5.2 Architecture-Optimized Scheduler]]
	6. [[#4 Task Management#4.6 Time Measurement and the Tick Interrupt|4.6 Time Measurement and the Tick Interrupt]]
	7. [[#4 Task Management#4.7 Expanding the Not Running State|4.7 Expanding the Not Running State]]
		1. [[#4.7 Expanding the Not Running State#4.7.1 The Blocked State|4.7.1 The Blocked State]]
		2. [[#4.7 Expanding the Not Running State#4.7.2 The Suspended State|4.7.2 The Suspended State]]
		3. [[#4.7 Expanding the Not Running State#4.7.3 The Ready State|4.7.3 The Ready State]]
		4. [[#4.7 Expanding the Not Running State#4.7.4 Completing the State Transition Diagram|4.7.4 Completing the State Transition Diagram]]
4. [[#4.2 The process abstraction|4.2 The process abstraction]]
	1. [[#4.2 The process abstraction#4.2.1 Discovering processes|4.2.1 Discovering processes]]
	2. [[#4.2 The process abstraction#4.2.2 Launching a new process|4.2.2 Launching a new process]]
	3. [[#4.2 The process abstraction#4.2.3 Doing something different|4.2.3 Doing something different]]
	4. [[#4.2 The process abstraction#4.2.4 Ending a process|4.2.4 Ending a process]]
5. [[#4.3 Process metadata|4.3 Process metadata]]
	1. [[#4.3 Process metadata#4.3.1 The `/proc` file system|4.3.1 The `/proc` file system]]
	2. [[#4.3 Process metadata#4.3.2 Linux kernel data structures|4.3.2 Linux kernel data structures]]
	3. [[#4.3 Process metadata#4.3.3 Process hierarchies|4.3.3 Process hierarchies]]
6. [[#4.4 Process state transitions|4.4 Process state transitions]]
7. [[#4.5 Context switch|4.5 Context switch]]
## 1.1 Multitasking in Small Embedded Systems

### 1.1.1 About the FreeRTOS Kernel

FreeRTOS is a collection of C libraries consisting of a _real-time kernel_ and a set of modular libraries that provide complementary functionality. Originally developed by Richard Barry around 2003, it was maintained by Real-Time Engineers Ltd in partnership with major chip companies until Amazon Web Services (AWS) assumed stewardship in 2016. FreeRTOS is MIT licensed open source and available for any purpose — no AWS customer relationship is required.

The kernel is designed for _deeply embedded real-time applications_ running on microcontrollers or small microprocessors. These applications typically involve a mix of both hard and soft real-time requirements.

> [!info] **Hard vs. Soft Real-Time Requirements**
> - **Soft real-time requirements** specify a time deadline, but breaching it does not render the system useless. The system degrades in quality rather than failing outright.
> - **Hard real-time requirements** specify a time deadline, and breaching it results in _absolute failure_ of the system. Missing the deadline is not acceptable under any circumstances.

> [!example]
> - **Soft real-time:** Responding to keystrokes too slowly makes a system feel unresponsive and annoying, but it remains usable.
> - **Hard real-time:** A driver's airbag must deploy within a strict time window after crash sensor input. Responding too late could cause more harm than good.

The FreeRTOS kernel (also called a _real-time scheduler_) enables applications to meet hard real-time requirements by organizing them as a collection of independent threads of execution. On a single-core processor, only one thread can execute at any given moment. The kernel decides which thread runs by examining the _priority_ assigned to each thread by the application designer.

A common starting strategy is to assign higher priorities to threads handling hard real-time requirements and lower priorities to those handling soft real-time requirements. This ensures hard real-time threads always execute ahead of soft real-time threads, though real-world priority assignment is often more nuanced.

### 1.1.2 Value Proposition

FreeRTOS's widespread adoption stems from a strong combination of qualities:

- **Professionally developed and strictly quality controlled** — robust and well-supported.
- **No intellectual property ambiguity** — truly free for commercial use with no requirement to expose proprietary source code.
- **AWS stewardship** provides global presence, expert security event response, a large development team, formal verification, penetration testing, memory safety proofs, and long-term support.
- **Neutral and open** — hardware, development tool, and cloud service agnostic. Development is transparent and community-driven on GitHub with no special tools or practices required.
- **Commercial options available** — products can be taken to market without fees or notification. Strategic partners offer low-cost commercial licenses for teams that need additional guarantees or indemnification.

### 1.1.3 A Note About Terminology

In FreeRTOS, each thread of execution is called a **task**. While there is no universal consensus in the embedded community, the term _task_ is preferred over _thread_ because "thread" carries more specific meanings in certain fields of application.

### 1.1.4 Why Use an RTOS?

Well-established techniques exist for writing embedded software without a multithreading kernel, and these may be the best fit for simple systems. A kernel becomes preferable as complexity increases, though the exact crossover point is subjective.

Beyond task prioritization for meeting deadlines, an RTOS provides several additional benefits:

**Abstracting away timing information** — The RTOS handles execution timing and exposes a time-related API to the application. This simplifies application code structure and reduces overall code size.

**Maintainability and extensibility** — Removing timing details from application logic reduces interdependencies between modules, allowing the software to evolve in a controlled, predictable way. Application performance also becomes less susceptible to changes in the underlying hardware.

**Modularity** — Each task is an independent module with a well-defined purpose.

**Team development** — Well-defined task interfaces make it easier for multiple developers to work in parallel.

**Easier testing** — Independent modules with clean interfaces can be tested in isolation.

**Code reuse** — Greater modularity and fewer interdependencies make code easier to reuse across projects.

**Improved efficiency** — Application code can be fully event-driven, eliminating wasted processing time from polling for events that haven't occurred. The trade-off is the overhead of processing the RTOS tick interrupt and performing context switches between tasks, though non-RTOS applications typically include some form of tick interrupt regardless.

**Idle time utilization** — An automatically created _Idle task_ runs when no application tasks need processing. It can measure spare processing capacity, perform background checks, or place the processor into a low-power mode.

**Power management** — Efficiency gains allow the processor to spend more time in low-power states. Each time the Idle task runs, the processor can enter a low-power mode. FreeRTOS also offers a _tick-less mode_ that enables even deeper power savings for longer durations.

**Flexible interrupt handling** — Interrupt handlers can be kept very short by deferring processing to an application-created task or the automatically created RTOS daemon task (also known as the _timer task_).

**Mixed processing requirements** — Simple design patterns can combine periodic, continuous, and event-driven processing within a single application. Hard and soft real-time requirements are met by selecting appropriate task and interrupt priorities.

### 1.1.5 FreeRTOS Kernel Features

The FreeRTOS kernel includes the following standard features:

- Pre-emptive or co-operative operation
- Optional time-slicing
- Flexible task priority assignment
- Flexible, fast, and lightweight task notification mechanisms
- Queues
- Binary semaphores
- Counting semaphores
- Mutexes and recursive mutexes
- Software timers
- Event groups
- Stream buffers and message buffers
- Co-routines (deprecated)
- Tick hook and idle hook functions
- Stack overflow checking
- Trace macros
- Task run-time statistics gathering
- Optional commercial licensing and support
- Full interrupt nesting model *(architecture-dependent)*
- Tick-less capability for extreme low-power applications *(architecture-dependent)*
- Memory Protection Unit (MPU) support for task isolation and safety *(architecture-dependent)*
- Software-managed interrupt stack where appropriate (RAM savings)
- RTOS object creation via static or dynamic memory allocation

### 1.1.6 Licensing and the FreeRTOS Family

> [!summary] **FreeRTOS MIT License Guarantees**
> - FreeRTOS can be used in commercial applications.
> - FreeRTOS itself remains freely available to everyone.
> - Users retain full ownership of their intellectual property.

The FreeRTOS family includes three variants:

| Variant | Description |
|---|---|
| **FreeRTOS** | The MIT-licensed open source kernel. |
| **OpenRTOS** | A commercially licensed version of FreeRTOS, provided under license from AWS by a third party. |
| **SafeRTOS** | Shares the same usage model as FreeRTOS but is developed in accordance with practices, procedures, and processes required for compliance with internationally recognized safety-related standards. |

## 1.2 Included Source Files and Projects

### 1.2.1 Obtaining Example Code

Example source code, pre-configured project files, and build instructions for FreeRTOS are available for download from the FreeRTOS documentation site. Note that downloadable packages may not always contain the most recent version of FreeRTOS.

A FreeRTOS Windows port exists that provides a convenient evaluation, testing, and development environment. It can be built using the free Community edition of Visual Studio. However, the Windows port does _not_ provide true real-time behavior — it is intended for development and testing convenience only.

## 4 Task Management

### 4.1 Introduction

#### 4.1.1 Scope

This chapter covers the fundamentals of how FreeRTOS manages tasks — the core building blocks of any FreeRTOS application. Specifically, it addresses how the kernel allocates processing time, selects which task executes, how task priorities influence system behavior, and the various states a task can occupy. It also covers practical aspects of task implementation: creating tasks, using task parameters, changing priorities, deleting tasks, implementing periodic processing, and understanding the idle task.

These concepts are foundational to understanding FreeRTOS application behavior.

### 4.2 Task Functions

Tasks are implemented as standard C functions that follow a specific prototype. Each task takes a `void *` parameter and returns `void`.

> [!info] **Task Function Prototype**
> ```c
> void vATaskFunction( void * pvParameters );
> ```

Each task operates as a small independent program. It has an entry point, normally runs forever inside an infinite loop, and _must never exit_. A FreeRTOS task must not contain a `return` statement and must not be allowed to execute past the end of its implementing function. If a task is no longer needed, it must be explicitly deleted using `vTaskDelete()`.

> [!warning] **Tasks Must Never Return**
> A task must never be allowed to return from its implementing function in any way. If execution somehow exits the infinite loop, the task must call `vTaskDelete( NULL )` before reaching the end of the function. Passing `NULL` to `vTaskDelete()` tells the kernel to delete the calling task itself.

A single task function definition can be used to create _any number_ of task instances. Each instance gets its own stack and therefore its own copy of any automatic (stack-allocated) variables. However, variables declared with the `static` keyword are allocated at a fixed memory location by the linker and are _shared_ across all instances.

> [!example] **Typical Task Structure**
> ```c
> void vATaskFunction( void * pvParameters )
> {
>     // Stack-allocated: each task instance gets its own copy
>     long lStackVariable = 0;
>
>     // Static: shared across ALL instances of this task function
>     static long lStaticVariable = 0;
>
>     for( ;; )
>     {
>         // Task functionality goes here
>     }
>
>     // Safety net — delete self if the loop is ever exited
>     vTaskDelete( NULL );
> }
> ```

### 4.3 Top Level Task States

On a single-core processor, only one task can execute at any given time. At the most basic level, a task exists in one of two states:

- **Running** — The processor is currently executing this task's code.
- **Not Running** — The task is paused and its context (state) has been saved so it can resume later from the exact instruction it was about to execute.

A task transitioning from Not Running to Running is said to be _switched in_ (or _swapped in_). The reverse transition is _switched out_ (or _swapped out_). Only the FreeRTOS scheduler can perform these transitions.
![[Pasted image 20261025112545.png]]
Figure 4.1 Top level task states and transitions
### 4.4 Task Creation

FreeRTOS provides six API functions for creating tasks:

| Function | Memory | Privilege | Core Affinity |
|---|---|---|---|
| `xTaskCreate()` | Dynamic | Privileged | No |
| `xTaskCreateStatic()` | Static (pre-allocated) | Privileged | No |
| `xTaskCreateRestricted()` | Dynamic | Restricted | No |
| `xTaskCreateRestrictedStatic()` | Static | Restricted | No |
| `xTaskCreateAffinitySet()` | Dynamic | Privileged | Yes (SMP) |
| `xTaskCreateStaticAffinitySet()` | Static | Privileged | Yes (SMP) |

Every task requires two blocks of RAM: one for its **Task Control Block (TCB)** and one for its **stack**. Functions with "Static" in the name use pre-allocated memory passed as parameters; those without allocate dynamically from the heap at runtime. Functions with "Restricted" create tasks that execute in unprivileged mode with limited memory access. Functions with "Affinity" are for Symmetric Multi-Processing (SMP) ports and allow pinning a task to a specific core.

#### 4.4.1 The `xTaskCreate()` API Function

`xTaskCreate()` is the simplest and most commonly used task creation function.

> [!example] **`xTaskCreate()` Prototype and Parameter Breakdown**
> ```c
> BaseType_t xTaskCreate( TaskFunction_t pvTaskCode,
>                         const char * const pcName,
>                         configSTACK_DEPTH_TYPE usStackDepth,
>                         void * pvParameters,
>                         UBaseType_t uxPriority,
>                         TaskHandle_t * pxCreatedTask );
> ```
> - **`pvTaskCode`** — Pointer to the C function implementing the task (effectively the function name). The function must never exit.
> - **`pcName`** — A human-readable descriptive name for debugging purposes only. FreeRTOS does not use it internally. Maximum length is defined by `configMAX_TASK_NAME_LEN` (including the null terminator); longer strings are truncated.
> - **`usStackDepth`** — Stack size in _words_, not bytes. For a 32-bit stack, a value of 128 allocates 512 bytes (128 × 4). The data type is controlled by `configSTACK_DEPTH_TYPE`, which defaults to `uint16_t`. Define it as `unsigned long` or `size_t` in `FreeRTOSConfig.h` if the stack depth in bytes exceeds 65,535.
> - **`pvParameters`** — The value passed into the task function via its `void *` parameter. Allows passing data into the task at creation time.
> - **`uxPriority`** — The task's initial priority. 0 is the lowest; `(configMAX_PRIORITIES - 1)` is the highest. Values exceeding the maximum are silently capped.
> - **`pxCreatedTask`** — Pointer to a `TaskHandle_t` variable where the kernel stores a handle to the new task. This handle is used in subsequent API calls (e.g., to change priority or delete the task). Set to `NULL` if the handle is not needed.
>
> **Return values:**
> - `pdPASS` — Task created successfully.
> - `pdFAIL` — Insufficient heap memory to create the task.

> [!example] **Creating Two Tasks and Starting the Scheduler**
> ```c
> // --- Task implementations ---
> void vTask1( void * pvParameters )
> {
>     volatile unsigned long ulCount;
>     for( ;; )
>     {
>         vPrintLine( "Task 1 is running" );
>         for( ulCount = 0; ulCount < mainDELAY_LOOP_COUNT; ulCount++ )
>         {
>             // Crude busy-wait delay (replaced later with vTaskDelay)
>         }
>     }
> }
>
> void vTask2( void * pvParameters )
> {
>     volatile unsigned long ulCount;
>     for( ;; )
>     {
>         vPrintLine( "Task 2 is running" );
>         for( ulCount = 0; ulCount < mainDELAY_LOOP_COUNT; ulCount++ )
>         {
>             // Crude busy-wait delay
>         }
>     }
> }
>
> // --- Main function ---
> int main( void )
> {
>     // Create both tasks at priority 1
>     xTaskCreate( vTask1, "Task 1", 1000, NULL, 1, NULL );
>     xTaskCreate( vTask2, "Task 2", 1000, NULL, 1, NULL );
>
>     // Start the scheduler — tasks begin executing
>     vTaskStartScheduler();
>
>     // Should never reach here if the scheduler started successfully.
>     // Reaching this point means there was not enough heap memory
>     // to create the idle or timer tasks.
>     for( ;; );
> }
> ```
> ![[Pasted image 20261025112802.png]]
> Figure 4.3 The actual execution pattern of the two Example

When two tasks of equal priority are both always able to run, they share the processor by rapidly alternating in and out of the Running state. Only one task is in the Running state at any instant — they are not truly executing simultaneously on a single core.

Tasks can also be created from within other tasks after the scheduler has already started, not just from `main()` before the scheduler begins.

> [!tip] **Using the Task Parameter to Eliminate Duplication**
> When multiple tasks share the same logic but differ only in data (e.g., a string to print), use a single task function and pass different data through the `pvParameters` argument. Each task instance gets its own stack, so local variables remain independent.
> ```c
> void vTaskFunction( void * pvParameters )
> {
>     // Cast the void pointer back to the expected type
>     char * pcTaskName = ( char * ) pvParameters;
>
>     for( ;; )
>     {
>         vPrintLine( pcTaskName );
>         // ... delay ...
>     }
> }
>
> // In main():
> static const char * pcTextForTask1 = "Task 1 is running";
> static const char * pcTextForTask2 = "Task 2 is running";
>
> xTaskCreate( vTaskFunction, "Task 1", 1000,
>              ( void * ) pcTextForTask1, 1, NULL );
> xTaskCreate( vTaskFunction, "Task 2", 1000,
>              ( void * ) pcTextForTask2, 1, NULL );
> ```
> Note that the strings are declared `static const` to ensure they remain valid in memory after the scheduler starts. Variables on `main()`'s stack may no longer exist once the scheduler is running.

### 4.5 Task Priorities

The FreeRTOS scheduler always selects the _highest priority task that is able to run_ to enter the Running state. Tasks of equal priority take turns entering and exiting the Running state.

- Priority is set initially via the `uxPriority` parameter at creation and can be changed later with `vTaskPrioritySet()`.
- Valid priorities range from `0` (lowest) to `(configMAX_PRIORITIES - 1)` (highest).
- Any number of tasks can share the same priority.
- Values above the maximum are silently capped.

The scheduler has two implementations for selecting the next task:

#### 4.5.1 Generic Scheduler

Written in portable C and compatible with all FreeRTOS architecture ports. It imposes no upper limit on `configMAX_PRIORITIES`. However, higher values consume more RAM and increase worst-case execution time, so it is advisable to keep this value as low as practical.

#### 4.5.2 Architecture-Optimized Scheduler

Written in architecture-specific assembly for better performance. The worst-case execution time is constant regardless of `configMAX_PRIORITIES`. The maximum value is limited to 32 on 32-bit architectures and 64 on 64-bit architectures.

Enable with `configUSE_PORT_OPTIMIZED_TASK_SELECTION` set to `1` in `FreeRTOSConfig.h` (set to `0` for the generic version). Ports that support the optimized version default to `1`; those that don't default to `0`.

### 4.6 Time Measurement and the Tick Interrupt

When multiple tasks of equal priority are always able to run, they share the processor through _time slicing_. Each task executes for one _time slice_ before the scheduler switches to the next.

A periodic interrupt called the **tick interrupt** triggers the scheduler at the end of each time slice. The frequency is set by the `configTICK_RATE_HZ` compile-time constant, which also defines the time slice duration. For example, `configTICK_RATE_HZ` set to 100 Hz yields 10 ms time slices. The interval between two tick interrupts is called the _tick period_.

> [!note] **Scheduler Invocation Is Not Limited to Tick Boundaries**
> The end of a time slice is not the only moment the scheduler can select a new task. The scheduler also runs immediately when the current task enters the Blocked state or when an interrupt moves a higher-priority task into the Ready state.

FreeRTOS API calls express time in multiples of tick periods, called _ticks_. The `pdMS_TO_TICKS()` macro converts milliseconds to ticks, ensuring that application timing remains correct even if the tick frequency changes. This macro cannot be used if `configTICK_RATE_HZ` exceeds 1000.

> [!example] **Converting Milliseconds to Ticks**
> ```c
> // Convert 200 milliseconds to the equivalent number of tick periods
> TickType_t xTimeInTicks = pdMS_TO_TICKS( 200 );
> ```

The _tick count_ is the total number of tick interrupts since the scheduler started. FreeRTOS handles tick count overflow internally, so user applications do not need to account for it when specifying delays.
![[Pasted image 20261025112856.png]]
Figure 4.4 The execution sequence expanded to show the tick interrupt executing
![[Pasted image 20261025112954.png]]
Figure 4.6 The execution pattern when one task has a higher priority than the other

> [!warning] **Task Starvation from Priority Mismanagement**
> If a higher-priority task never enters the Blocked state (e.g., it uses a busy-wait loop for delays), it will _starve_ all lower-priority tasks. The scheduler always picks the highest-priority ready task, so a continuously running high-priority task prevents any lower-priority task from ever entering the Running state.

### 4.7 Expanding the Not Running State

Tasks that always have work to do and never wait for anything can only be usefully placed at the very lowest priority. At any higher priority, they starve lower-priority tasks. To be useful at varied priorities, tasks must be _event-driven_ — they only need processing time after an event triggers them. This requires the Not Running state to be broken into sub-states.

#### 4.7.1 The Blocked State

A task waiting for an event is in the **Blocked** state, a sub-state of Not Running. Tasks can block on two types of events:

1. **Temporal (time-related) events** — A delay period expires or an absolute time is reached. For example, waiting 10 ms.
2. **Synchronization events** — An event originating from another task or interrupt, such as data arriving on a queue. FreeRTOS queues, semaphores (binary and counting), mutexes (standard and recursive), event groups, stream buffers, message buffers, and direct task notifications all generate synchronization events.

A task can block on a synchronization event _with a timeout_, effectively combining both types. For instance, a task might wait up to 10 ms for data on a queue — it unblocks when data arrives or when the timeout expires, whichever comes first.

#### 4.7.2 The Suspended State

**Suspended** is another sub-state of Not Running. Suspended tasks are completely invisible to the scheduler. Entry is only via `vTaskSuspend()`, and exit is only via `vTaskResume()` or `xTaskResumeFromISR()`. Most applications do not use the Suspended state.

#### 4.7.3 The Ready State

Tasks in the Not Running state that are neither Blocked nor Suspended are in the **Ready** state. They are able to run and are waiting for the scheduler to select them, but are not currently executing.

#### 4.7.4 Completing the State Transition Diagram

The full task state machine includes four states:

| State | Description |
|---|---|
| **Running** | Currently executing on the processor. Only one task at a time (single core). |
| **Ready** | Able to run but not currently selected by the scheduler. |
| **Blocked** | Waiting for a temporal or synchronization event. |
| **Suspended** | Explicitly removed from scheduling via `vTaskSuspend()`. |

Tasks transition between these states as follows:
- **Ready → Running** — The scheduler selects the task (switched in).
- **Running → Ready** — The scheduler preempts the task for a higher-priority task or time slice ends (switched out).
- **Running → Blocked** — The task calls a blocking API (e.g., `vTaskDelay()`, queue receive).
- **Blocked → Ready** — The event the task was waiting for occurs or the timeout expires.
- **Running/Ready/Blocked → Suspended** — `vTaskSuspend()` is called on the task.
- **Suspended → Ready** — `vTaskResume()` or `xTaskResumeFromISR()` is called.
![[Pasted image 20261025113030.png]]
Figure 4.7 Full task state machine

> [!example] **Using `vTaskDelay()` to Replace Busy-Wait Loops**
> The `vTaskDelay()` API places the calling task into the Blocked state for a specified number of ticks, freeing the processor for other tasks during the delay.
>
> ```c
> void vTaskDelay( TickType_t xTicksToDelay );
> ```
> - **`xTicksToDelay`** — Number of tick interrupts the task remains Blocked. For example, if the tick count is 10,000 and `vTaskDelay( 100 )` is called, the task unblocks when the tick count reaches 10,100.
>
> **Improved task implementation:**
> ```c
> void vTaskFunction( void * pvParameters )
> {
>     char * pcTaskName = ( char * ) pvParameters;
>     const TickType_t xDelay250ms = pdMS_TO_TICKS( 250 );
>
>     for( ;; )
>     {
>         vPrintLine( pcTaskName );
>
>         // Block for 250 ms instead of burning CPU in a null loop
>         vTaskDelay( xDelay250ms );
>     }
> }
> ```
>
> With this change, even if two instances of this task are created at _different_ priorities, both will execute. The higher-priority task enters the Blocked state during its delay, allowing the lower-priority task to run. The processor is only used when there is actual work to do, and the idle task runs during the remaining spare capacity.

> [!tip] **Efficiency Gains from Event-Driven Design**
> Replacing polling loops with blocking API calls dramatically reduces processor utilization. Instead of consuming 100% of available processing time between them, event-driven tasks use only a tiny fraction — executing briefly to perform work and then blocking for the remainder of their period. The idle task runs during the spare capacity, and its execution time serves as a measure of how much processing headroom the system has.

![[Pasted image 20261025113052.png]]
Figure 4.9 The execution sequence when the tasks use vTaskDelay() in place of the null loop
![[Pasted image 20261025113104.png]]
Figure 4.10 Bold lines indicate the state transitions performed by the tasks

## 4.2 The process abstraction

A _process_ is a program in execution. A _program_ by itself consists only of executable code and static data stored in a binary artifact (such as an ELF object or a Java class file). A process goes further by encapsulating the entire **runtime execution context**:

- **Hardware state** — program counter, stack pointer, and other register values for each thread of execution, tracking where the process is in its execution.
- **Memory management information** — how the process's address space is configured.
- **Owned resources** — open file handles, network connections, and other OS-managed resources.

A process maps onto a user application (e.g., a spreadsheet), a background utility (e.g., a file indexer), or a system service (e.g., a remote login daemon). Multiple processes can execute the same program simultaneously — these are distinct runtime instances of the same binary. Some applications explicitly prevent this; for example, the Firefox web browser uses a lock file to stop multiple instances from running with the same user profile.

### 4.2.1 Discovering processes

The `ps` command displays information about processes currently registered with the OS. A common invocation to count all running processes is:

> [!example] **Counting running processes**
> ```bash
> ps aux | wc -l
> ```
> - `a` — Include all users' processes.
> - `u` — Display user-friendly output.
> - `x` — Include processes not started from a user terminal.

Every time a new program is invoked — whether by clicking an icon or typing an executable name at a shell prompt — a new process starts.

### 4.2.2 Launching a new process

The standard Unix mechanism for creating a new process is the `fork` system call. The forking process (the **parent**) generates an exact copy (the **child**) that executes the same code. The only difference between parent and child is the return value of `fork`:

- **In the child process:** `fork` returns `0`.
- **In the parent process:** `fork` returns a positive integer — the **process identifier (PID)** of the newly created child.
- **On failure:** `fork` returns `-1`.

> [!example] **`fork()` in Python**
> ```python
> import os
>
> def child():
>     print("Child process has PID {:d}".format(os.getpid()))
>
> def parent():
>     print("Parent process has PID {:d}".format(os.getpid()))
>     child_pid = os.fork()
>     # Both parent and child execute from this point onward
>     if child_pid == 0:
>         child()       # child executes this branch
>     else:
>         print("Parent {:d} has just forked child {:d}".format(
>             os.getpid(), child_pid))  # parent executes this branch
>
> parent()
> ```
> ![[Pasted image 20261025113250.png]]
> Figure 4.4: Schematic diagram of the behavior of the fork system call.

> [!info] **Copy-on-Write (COW)**
> Although the child is a copy of the parent, it occupies an entirely separate virtual address space. Changes made to memory in one process are not visible in the other. To avoid the massive overhead of duplicating all memory immediately, Linux uses **copy-on-write**: data pages are shared between parent and child until one of them attempts to modify a page, at which point the kernel allocates a private copy for the modifying process.

### 4.2.3 Doing something different

`fork` creates a near-identical copy, but to run a _different_ program in the child process, Linux provides the `execve` system call. `execve` replaces the currently running process image with a new program binary.

> [!info] **`execve()` Parameters**
> - **First parameter** — The path to the executable file.
> - **Second parameter** — The argument vector (equivalent to `argv` in C).
> - **Third parameter** — A set of environment variables as key/value pairs.
>
> `execve` does _not_ return on success — the calling process is entirely replaced. It returns `-1` only if an error prevents execution.

> [!example] **`execve()` in Python**
> ```python
> import os
>
> # Replaces the current process with `ls -l *`
> os.execve("/bin/ls", ["ls", "-l", "*"], {})
> ```

This is exactly how an interactive shell like `bash` launches programs: first it calls `fork` to create a child process, then the child calls `execve` to load the desired program binary.

> [!note] **The `clone` System Call**
> Under the hood, Linux implements `fork` via the more general `clone` system call. `clone` lets the programmer explicitly specify which parts of the parent's context are duplicated and which are shared with the child. By sharing the virtual address space, `clone` supports threads as well as processes through a single API. This is the implementation basis of the Native POSIX Threads Library (NPTL) — for instance, `pthread_create` invokes `clone` internally.

### 4.2.4 Ending a process

A parent process can block and wait for a child to complete by calling `wait`. A child process terminates by calling `exit` with a status code (non-zero conventionally indicates an error) or by returning from its `main` routine.
![[Pasted image 20261025113320.png]]
Figure 4.5: Schematic diagram showing how to start and terminate a child process.

> [!example] **`wait()` and `exit()` in C**
> ```c
> #include <stdio.h>
> #include <stdlib.h>
> #include <sys/types.h>
> #include <sys/wait.h>
> #include <unistd.h>
>
> int main() {
>     pid_t child_pid, pid;
>     int status;
>
>     child_pid = fork();
>
>     if (child_pid == 0) {
>         // --- Child process ---
>         pid = getpid();
>         printf("I'm child process %d\n", pid);
>         printf("... sleep for 10 seconds, then exit with status 42\n");
>         sleep(10);
>         exit(42);
>     }
>     else if (child_pid > 0) {
>         // --- Parent process ---
>         pid = wait(&status);  // Block until child terminates
>         if (WIFEXITED(status)) {
>             printf("Parent discovers child exit with status: %d\n",
>                    WEXITSTATUS(status));
>         }
>     }
>     else {
>         perror("fork failed");
>         exit(1);
>     }
>     return 0;
> }
> ```

> [!warning] **Orphan Processes and Re-parenting**
> If a parent process completes before its child, the child becomes an **orphan process**. The orphan is "adopted" by a **subreaper** — one of the parent's ancestor processes. If no subreaper exists among the ancestors, the child is adopted by the `init` process (PID 1). In either case, the parent field in the child's kernel data structure is updated when the original parent exits. This mechanism is called **re-parenting**.

## 4.3 Process metadata

The OS requires a significant amount of metadata to identify, execute, and manage each process. This information is encapsulated in a data structure known as a **process control block (PCB)**.

Key categories of process metadata include:

- **Process identifier (PID)** — A unique positive integer.
- **Context switch data** — Saved register values, open file handles, memory configuration. This allows the process to resume execution after being suspended.
- **OS interaction data** — Profiling statistics, scheduling details, and other kernel bookkeeping.
![[Pasted image 20261025113349.png]]
Figure 4.6: Generic OS management metadata required for each process, stored in a per-process data structure known as the process control block.
### 4.3.1 The `/proc` file system

The Linux kernel exposes process metadata through a virtual file system mounted at `/proc`. Inside this directory, each running process has a subdirectory named by its PID. These subdirectories contain pseudo-files that represent in-memory kernel data — they are not stored on disk.

| Virtual File | Description |
|---|---|
| `cmdline` | The textual command used to start the process |
| `cwd` | Symbolic link to the process's current working directory |
| `exe` | Symbolic link to the process's executable file |
| `fd/` | Directory containing file descriptors for each open file |
| `maps` | Table showing how data is arranged in the process's memory |
| `stat` | Counters for various OS events specific to this process |

> [!example] **Exploring `/proc`**
> ```bash
> # List all process directories
> cd /proc
> ls
>
> # List the commands of all running processes
> for CMD in `find . -maxdepth 2 -name "cmdline"`; do
>     cat $CMD; echo ""
> done | sort
> ```
> Some `cmdline` entries will be blank — these correspond to kernel threads or processes without a command-line invocation.

### 4.3.2 Linux kernel data structures

The Linux kernel distributes process metadata across three key linked data structures in kernel memory:

> [!info] **`thread_info`**
> An architecture-specific structure (e.g., defined in `arch/arm/include/asm/thread_info.h` for Arm). Each thread of execution has its own `thread_info` instance, embedded at the base of the thread's dedicated 8 KB kernel stack (distinct from the user-mode stack). It stores low-level processor context such as register values and status flags, and includes a pointer to the corresponding `task_struct`. The pointer can be extracted efficiently via a bitmask operation on the stack pointer register:
> ```c
> return (struct thread_info *)
>     (current_stack_pointer & ~(THREAD_SIZE - 1));
> ```

> [!info] **`task_struct`**
> The Linux-specific instantiation of the process control block, defined in `linux/sched.h`. This is a large structure storing all context for the process. The kernel macro `current` returns a pointer to the `task_struct` of the currently executing process. On a 32-bit Arm system with kernel 4.4, `sizeof(*current)` is approximately 3,472 bytes.

> [!info] **`thread_struct`**
> A smaller architecture-specific structure (e.g., defined in `arch/arm/include/asm/processor.h` for Arm), referenced by `task_struct`. It stores processor-specific context related to fault events and debugging information.

Each thread has its own unique instances of all three structures, though references to shared metadata (e.g., memory maps or open file tables) may be shared between threads of the same process.
![[Pasted image 20261025113413.png]]
Figure 4.7: Runtime layout of Linux data structures that encapsulate process metadata, residing in kernel memory space

> [!note] **PID vs. TGID**
> When a process starts, it runs with a single thread. Its **process identifier (PID)** equals its **thread group identifier (TGID)**. If the process creates additional threads, each new thread gets its own unique PID but retains the original TGID. The Linux scheduler treats every thread as a separate schedulable entity, but user-facing tools like `top` typically merge threads sharing a TGID into a single process entry.

### 4.3.3 Process hierarchies

Every process has a parent — the process that created it. The ancestor of all processes in Linux is the `init` process (PID 1). The kernel global variable `init_task` points to its `task_struct`.

There are two ways to iterate over processes in the kernel:

1. **Circular doubly-linked list** — Each `task_struct` has `next` and `prev` pointers forming a ring through all processes. The `for_each_process` macro iterates this list.
2. **Parent chain** — Each `task_struct` has a `parent` pointer forming a linear chain that terminates at `init_task`.
![[Pasted image 20261025113433.png]]
Figure 4.8: Process hierarchy output from pstree.

> [!example] **Tracing process ancestry (kernel module)**
> ```c
> #include <linux/module.h>
> #include <linux/kernel.h>
> #include <linux/sched.h>
>
> int init_module(void)
> {
>     struct task_struct *task;
>
>     // Walk from the current process up to init
>     for (task = current; task != &init_task; task = task->parent) {
>         printk(KERN_INFO " %d (%s) -> ", task->pid, task->comm);
>     }
>     printk(KERN_INFO " %d (%s) \n", task->pid, task->comm);
>
>     return 0;
> }
> ```
> This code must run in kernel space (e.g., as a kernel module) because it directly accesses privileged OS data structures. The `printk` function outputs to the kernel log, readable via the `dmesg` utility.

> [!tip] **User-Space Alternatives**
> Kernel-level code is expensive and requires privileges. Most Linux process utilities (`ps`, `top`, `pstree`) gather metadata from the `/proc` file system instead, avoiding costly system calls. The `pstree` command displays the process hierarchy in a tree format using `/proc` pseudo-files and is part of the `psmisc` package.

## 4.4 Process state transitions

A process moves between scheduling states during its lifetime. The primary states and their standard Linux abbreviations (visible in `ps` or `top` output) are:

| State | Code | Description |
|---|---|---|
| **Running** | `R` | Currently executing or runnable (on the run queue) |
| **Sleeping** | `S` | Waiting for an event; can be interrupted by signals |
| **Disk sleep** | `D` | Waiting on I/O; not interruptible |
| **Stopped** | `T` | Paused, typically by a signal (e.g., `SIGSTOP` via `Ctrl+Z`) |
| **Zombie** | `Z` | A dead process awaiting cleanup by its parent |
![[Pasted image 20261025113448.png]]
Figure 4.9: The state transition diagram for a Linux process, states named in circles, with possible ps state codes indicated

> [!info] **Zombie Processes**
> A zombie is a completed child process that still has an entry in the process table because its parent has not yet called `wait` to collect its exit status. The zombie persists until the parent calls `wait` or the parent itself terminates (triggering re-parenting to `init`, which periodically reaps zombies).

> [!example] **Creating a zombie process in Python**
> ```python
> import os
> import time
>
> def main():
>     child_pid = os.fork()
>     if child_pid == 0:
>         # Child exits immediately, becoming a zombie
>         print("To see the zombie, run: ps u -p {:d}".format(os.getpid()))
>         exit()
>     else:
>         # Parent sleeps without calling wait()
>         time.sleep(60)
>         print("Zombie process disappears now")
>
> main()
> ```
> During the 60-second sleep, the child appears as a zombie (`Z` state) in `ps` output.

> [!tip] **Observing State Changes**
> You can watch process states change in real time:
> ```bash
> # Start a long-running process in the background
> find / -name "foo" &
>
> # Monitor process states live (Ctrl+C to exit)
> watch ps u
> ```
> You should see processes in `R` (running), `S` (sleeping), `D` (waiting on I/O), and `T` (stopped) states. Sending `Ctrl+Z` to a foreground process sends `SIGSTOP`, moving it to the `T` state — this is the basis of interactive debugging.

## 4.5 Context switch

Early computers were single-tasking, executing one program at a time. Processes are the foundation of **multi-programming**, where the OS executes multiple programs concurrently by multiplexing many processes onto a smaller number of physical processor cores.

The **context switch** is the operation that enables this multiplexing. During a context switch:

1. The runtime data for the currently executing process (registers, program counter, stack pointer, etc.) is saved into its process control block (`task_struct` in Linux).
2. The process is paused.
3. The saved context of another process is restored, and that process resumes execution.

If processes are switched rapidly enough, they appear to execute simultaneously — analogous to a juggler keeping more balls in the air than they have hands.

Context data for short-term scheduling resides in RAM (kernel memory). Processes not expected to run soon may have their memory paged out to disk. Processes can also be migrated across network links to other machines.

Three practical questions about context switching on Linux:

> [!info] **Q1: How long does a process execute before being switched out?**
> Linux uses a **scheduling quantum** — a notional time slice each process receives in a round-robin fashion before a context switch occurs. A typical default is around 10 ms. The value can be checked with:
> ```bash
> cat /proc/sys/kernel/sched_rr_timeslice_ms
> ```

> [!info] **Q2: How much data must be saved for a context switch?**
> Per thread, the `thread_info` structure captures saved register values and processor context — roughly 500 bytes on a 32-bit Arm processor with hardware floating-point support. Additional process control information in `task_struct` is mostly already resident in memory, so only minor updates are needed at each switch.

> [!info] **Q3: How long does a context switch take?**
> The **context switch overhead** is the time to suspend one process and resume another. This must be minimized on interactive systems for smooth responsiveness. The open-source `lmbench` utility can measure this:
> ```bash
> tar xvzf lmbench3.tar.gz
> cd lmbench3/src
> make results
> cd ../bin/armv7l-linux-gnu/
> ./lat_ctx -s 0 10
> ```
> On a Raspberry Pi 2 running Linux kernel 4.4, the measured overhead is approximately 12 µs.

