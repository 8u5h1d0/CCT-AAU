---
tags:
  - CCT3
  - indlejrede_systemer
Topic: Microcontroller OS, FreeRTOS, scheduling algorithms, OS queues, Data protection, crit sections, mutexes.
Semester: CCT3
Course: Programmering af indlejrede systemer
Litterature:
  - Mastering-the-FreeRTOS-Real-Time-Kernel.v1.1.0
  - OperatingSystemFoundations_textbook
Created: 25-10-2026
---
- - -
## Table of Contents

1. [[#4.7.5 The `vTaskDelayUntil()` API Function|4.7.5 The `vTaskDelayUntil()` API Function]]
	1. [[#4.7.5 The `vTaskDelayUntil()` API Function#Example 4.6: Combining Blocking and Non-Blocking Tasks|Example 4.6: Combining Blocking and Non-Blocking Tasks]]
2. [[#4.8 The Idle Task and the Idle Task Hook|4.8 The Idle Task and the Idle Task Hook]]
	1. [[#4.8 The Idle Task and the Idle Task Hook#4.8.1 Idle Task Hook Functions|4.8.1 Idle Task Hook Functions]]
	2. [[#4.8 The Idle Task and the Idle Task Hook#4.8.2 Limitations on Idle Task Hook Functions|4.8.2 Limitations on Idle Task Hook Functions]]
3. [[#4.12 Scheduling Algorithms|4.12 Scheduling Algorithms]]
4. [[#4.12 Scheduling Algorithms#4.12.1 A Recap of Task States and Events|4.12.1 A Recap of Task States and Events]]
5. [[#4.12 Scheduling Algorithms#4.12.2 Selecting the Scheduling Algorithm|4.12.2 Selecting the Scheduling Algorithm]]
6. [[#4.12 Scheduling Algorithms#4.12.3 Prioritized Preemptive Scheduling with Time Slicing|4.12.3 Prioritized Preemptive Scheduling with Time Slicing]]
7. [[#4.12 Scheduling Algorithms#4.12.4 Prioritized Preemptive Scheduling without Time Slicing|4.12.4 Prioritized Preemptive Scheduling without Time Slicing]]
8. [[#4.12 Scheduling Algorithms#4.12.5 Cooperative Scheduling|4.12.5 Cooperative Scheduling]]
9. [[#5 Queue Management|5 Queue Management]]
10. [[#5 Queue Management#5.1 Introduction|5.1 Introduction]]
	1. [[#5.1 Introduction#5.1.1 Scope|5.1.1 Scope]]
11. [[#5 Queue Management#5.2 Characteristics of a Queue|5.2 Characteristics of a Queue]]
	1. [[#5.2 Characteristics of a Queue#5.2.1 Data Storage|5.2.1 Data Storage]]
	2. [[#5.2 Characteristics of a Queue#5.2.2 Access by Multiple Tasks|5.2.2 Access by Multiple Tasks]]
	3. [[#5.2 Characteristics of a Queue#5.2.3 Blocking on Queue Reads|5.2.3 Blocking on Queue Reads]]
	4. [[#5.2 Characteristics of a Queue#5.2.4 Blocking on Queue Writes|5.2.4 Blocking on Queue Writes]]
	5. [[#5.2 Characteristics of a Queue#5.2.5 Blocking on Multiple Queues|5.2.5 Blocking on Multiple Queues]]
	6. [[#5.2 Characteristics of a Queue#5.2.6 Creating Queues: Static and Dynamic Allocation|5.2.6 Creating Queues: Static and Dynamic Allocation]]
12. [[#5 Queue Management#5.3 Using a Queue|5.3 Using a Queue]]
	1. [[#5.3 Using a Queue#5.3.1 The `xQueueCreate()` API Function|5.3.1 The `xQueueCreate()` API Function]]
	2. [[#5.3 Using a Queue#5.3.2 The `xQueueSendToBack()` and `xQueueSendToFront()` API Functions|5.3.2 The `xQueueSendToBack()` and `xQueueSendToFront()` API Functions]]
	3. [[#5.3 Using a Queue#5.3.3 The `xQueueReceive()` API Function|5.3.3 The `xQueueReceive()` API Function]]
	4. [[#5.3 Using a Queue#5.3.4 The `uxQueueMessagesWaiting()` API Function|5.3.4 The `uxQueueMessagesWaiting()` API Function]]
	5. [[#5.3 Using a Queue#Example 5.1: Blocking When Receiving from a Queue|Example 5.1: Blocking When Receiving from a Queue]]
13. [[#8 Resource Management|8 Resource Management]]
14. [[#8 Resource Management#8.1 Chapter Introduction and Scope|8.1 Chapter Introduction and Scope]]
	1. [[#8.1 Chapter Introduction and Scope#8.1.1 Mutual Exclusion|8.1.1 Mutual Exclusion]]
	2. [[#8.1 Chapter Introduction and Scope#8.1.2 Scope|8.1.2 Scope]]
15. [[#8 Resource Management#8.2 Critical Sections and Suspending the Scheduler|8.2 Critical Sections and Suspending the Scheduler]]
	1. [[#8.2 Critical Sections and Suspending the Scheduler#8.2.1 Basic Critical Sections|8.2.1 Basic Critical Sections]]
	2. [[#8.2 Critical Sections and Suspending the Scheduler#8.2.2 Suspending (Locking) the Scheduler|8.2.2 Suspending (Locking) the Scheduler]]
	3. [[#8.2 Critical Sections and Suspending the Scheduler#8.2.3 The `vTaskSuspendAll()` API Function|8.2.3 The `vTaskSuspendAll()` API Function]]
	4. [[#8.2 Critical Sections and Suspending the Scheduler#8.2.4 The `xTaskResumeAll()` API Function|8.2.4 The `xTaskResumeAll()` API Function]]
16. [[#8 Resource Management#8.3 Mutexes (and Binary Semaphores)|8.3 Mutexes (and Binary Semaphores)]]
	1. [[#8.3 Mutexes (and Binary Semaphores)#8.3.1 The `xSemaphoreCreateMutex()` API Function|8.3.1 The `xSemaphoreCreateMutex()` API Function]]
	2. [[#8.3 Mutexes (and Binary Semaphores)#8.3.2 Priority Inversion|8.3.2 Priority Inversion]]
	3. [[#8.3 Mutexes (and Binary Semaphores)#8.3.3 Priority Inheritance|8.3.3 Priority Inheritance]]
	4. [[#8.3 Mutexes (and Binary Semaphores)#8.3.4 Deadlock (Deadly Embrace)|8.3.4 Deadlock (Deadly Embrace)]]
17. [[#5.5 Scheduling principles|5.5 Scheduling principles]]
18. [[#5.5 Scheduling principles#5.5.1 Preemptive versus non-preemptive scheduling|5.5.1 Preemptive versus non-preemptive scheduling]]
19. [[#5.5 Scheduling principles#5.5.2 Scheduling policies|5.5.2 Scheduling policies]]
20. [[#5.5 Scheduling principles#5.5.3 Task attributes|5.5.3 Task attributes]]
21. [[#5.6 Scheduling criteria|5.6 Scheduling criteria]]
22. [[#5.7 Scheduling policies|5.7 Scheduling policies]]
23. [[#5.7 Scheduling policies#5.7.1 First-come, first-served (FCFS)|5.7.1 First-come, first-served (FCFS)]]
24. [[#5.7 Scheduling policies#5.7.2 Round-robin (RR)|5.7.2 Round-robin (RR)]]
25. [[#5.7 Scheduling policies#5.7.3 Priority-driven scheduling|5.7.3 Priority-driven scheduling]]
26. [[#5.7 Scheduling policies#5.7.4 Shortest job first (SJF) and shortest remaining time first (SRTF)|5.7.4 Shortest job first (SJF) and shortest remaining time first (SRTF)]]
27. [[#5.7 Scheduling policies#5.7.5 Shortest elapsed time first (SETF)|5.7.5 Shortest elapsed time first (SETF)]]
28. [[#5.7 Scheduling policies#5.7.6 Priority scheduling|5.7.6 Priority scheduling]]
29. [[#5.7 Scheduling policies#5.7.7 Real-time scheduling|5.7.7 Real-time scheduling]]
30. [[#5.7 Scheduling policies#5.7.8 Earliest deadline first (EDF)|5.7.8 Earliest deadline first (EDF)]]

### 4.7.5 The `vTaskDelayUntil()` API Function

`vTaskDelayUntil()` is similar to `vTaskDelay()` but serves a fundamentally different purpose. The key distinction lies in how the unblock time is calculated:

- **`vTaskDelay()`** specifies a _relative_ delay — the task remains Blocked for a fixed number of ticks starting from the moment `vTaskDelay()` is called. The actual wake-up time drifts depending on how long the task's processing takes between iterations.
- **`vTaskDelayUntil()`** specifies an _absolute_ wake-up time — the exact tick count at which the task should transition from Blocked to Ready. This makes it the correct choice when a **fixed execution period** is required, ensuring the task runs at a precise, consistent frequency regardless of how long its processing takes.

> [!example] **`vTaskDelayUntil()` Prototype and Parameter Breakdown**
> ```c
> void vTaskDelayUntil( TickType_t * pxPreviousWakeTime,
>                       TickType_t xTimeIncrement );
> ```
> - **`pxPreviousWakeTime`** — Pointer to a variable holding the tick count at which the task _last_ left the Blocked state (i.e., was last "woken"). This serves as the reference point for calculating the next wake time. The variable is **automatically updated** inside `vTaskDelayUntil()` and should not be modified by application code after initialization. It must be initialized to the current tick count before first use via `xTaskGetTickCount()`.
> - **`xTimeIncrement`** — The desired period between executions, specified in ticks. Use `pdMS_TO_TICKS()` to convert from milliseconds.

> [!example] **Implementing a Fixed-Frequency Periodic Task**
> ```c
> void vTaskFunction( void * pvParameters )
> {
>     char * pcTaskName = ( char * ) pvParameters;
>     TickType_t xLastWakeTime;
>
>     // Initialize the wake time reference to the current tick count.
>     // This is the ONLY explicit write to xLastWakeTime.
>     xLastWakeTime = xTaskGetTickCount();
>
>     for( ;; )
>     {
>         vPrintLine( pcTaskName );
>
>         // Unblock exactly 250 ms after the previous wake time,
>         // regardless of how long vPrintLine() or other processing took.
>         vTaskDelayUntil( &xLastWakeTime, pdMS_TO_TICKS( 250 ) );
>     }
> }
> ```
> Because the wake time is absolute, the task maintains a consistent 250 ms period even if the processing time within the loop varies slightly from iteration to iteration.

> [!info] **`vTaskDelay()` vs. `vTaskDelayUntil()` Summary**
> | Aspect | `vTaskDelay()` | `vTaskDelayUntil()` |
> |---|---|---|
> | Delay type | Relative to call time | Absolute tick count |
> | Use case | Simple delays | Fixed-frequency periodic tasks |
> | Frequency drift | Possible (processing time adds to period) | None (period is constant) |
> | Parameter | Ticks to delay | Pointer to last wake time + increment |

#### Example 4.6: Combining Blocking and Non-Blocking Tasks

This example demonstrates system behavior when continuous processing tasks and a periodic blocking task coexist at different priorities.

The setup consists of three tasks:

1. **Two continuous processing tasks at priority 1** — These tasks print a string in an infinite loop without ever calling any blocking API. They are always in either the Ready or Running state and never voluntarily yield the processor.

2. **One periodic task at priority 2** — This task prints a string periodically using `vTaskDelayUntil()` to place itself into the Blocked state between iterations.

> [!example] **Continuous Processing Task (Priority 1)**
> ```c
> void vContinuousProcessingTask( void * pvParameters )
> {
>     char * pcTaskName = ( char * ) pvParameters;
>
>     for( ;; )
>     {
>         // Prints repeatedly without ever blocking or delaying
>         vPrintLine( pcTaskName );
>     }
> }
> ```

> [!example] **Periodic Task (Priority 2)**
> ```c
> void vPeriodicTask( void * pvParameters )
> {
>     TickType_t xLastWakeTime;
>     const TickType_t xDelay3ms = pdMS_TO_TICKS( 3 );
>
>     xLastWakeTime = xTaskGetTickCount();
>
>     for( ;; )
>     {
>         vPrintLine( "Periodic task is running" );
>
>         // Block until exactly 3 ms after the last wake time
>         vTaskDelayUntil( &xLastWakeTime, xDelay3ms );
>     }
> }
> ```

The resulting execution behavior follows a predictable pattern:

- The periodic task has the highest priority (2). When it is in the Ready state, the scheduler always selects it to run, preempting the lower-priority continuous tasks.
- After printing its string, the periodic task calls `vTaskDelayUntil()` and enters the **Blocked** state for approximately 3 ms.
- While the periodic task is Blocked, the scheduler selects from the two priority-1 continuous tasks. Since they are at equal priority, they share the processor in turn via time slicing.
- When the periodic task's delay expires, it transitions back to the Ready state. Because its priority (2) is higher than the continuous tasks (1), the scheduler immediately preempts whichever continuous task is currently running and switches in the periodic task.
- The cycle repeats: the periodic task prints, blocks, and the continuous tasks share the processor during the blocking interval.
![[Pasted image 20261025101847.png]]
Figure 4.12 The execution pattern

> [!tip] **Key Takeaway: Blocking Enables Priority Coexistence**
> This example reinforces a critical principle: higher-priority tasks do _not_ starve lower-priority tasks as long as the higher-priority tasks periodically enter the Blocked state. The continuous processing tasks would be completely starved if the periodic task never blocked (as demonstrated in the earlier busy-wait example). By using `vTaskDelayUntil()`, the periodic task yields the processor during its delay intervals, allowing lower-priority tasks to execute. The continuous tasks still consume all available processing time during those intervals, but they are no longer permanently locked out.

> [!warning] **Continuous Processing Tasks Are Priority-Sensitive**
> Continuous processing tasks (tasks that never block) can only safely be placed at the _lowest_ priority in the system. At any higher priority, they will starve all tasks below them because they never voluntarily leave the Running state. If a continuous processing task must exist at a non-minimal priority, it should be redesigned to be event-driven using blocking API calls.

### 4.8 The Idle Task and the Idle Task Hook

When application tasks spend most of their time in the Blocked state, there are periods where none of them are able to run. However, the scheduler requires that there is **always at least one task available to enter the Running state**. To guarantee this, the scheduler automatically creates an **Idle task** when `vTaskStartScheduler()` is called.

The Idle task runs a simple infinite loop and is therefore always able to execute. It is assigned the **lowest possible priority (priority 0)**, ensuring it never prevents a higher-priority application task from running. As soon as any higher-priority task transitions into the Ready state, the Idle task is immediately preempted — swapped out of the Running state — to make way for the higher-priority task. This preemption happens automatically and transparently; the Idle task has no awareness that it has been preempted.

> [!info] **Idle Task Priority and `configIDLE_SHOULD_YIELD`**
> Application tasks _can_ be created at priority 0, sharing the Idle task's priority level. When this happens, the compile-time configuration constant `configIDLE_SHOULD_YIELD` in `FreeRTOSConfig.h` controls whether the Idle task yields processing time to these equal-priority application tasks. Setting it appropriately prevents the Idle task from consuming cycles that would be better used by application work.

> [!warning] **Idle Task and `vTaskDelete()` Cleanup**
> If any task uses `vTaskDelete()` to delete itself, it is **essential** that the Idle task is not starved of processing time. The Idle task is responsible for freeing the kernel resources (stack memory, TCB, etc.) that were allocated to tasks that deleted themselves. If the Idle task never gets a chance to run, these resources are never reclaimed, leading to memory leaks.

#### 4.8.1 Idle Task Hook Functions

Application-specific functionality can be injected directly into the Idle task's loop through an **idle hook** (or **idle callback**) function. This function is called automatically by the Idle task once per iteration of its loop.

Common uses for the idle hook include:

- **Background processing** — Executing low-priority, continuous background work without the RAM overhead of creating a dedicated application task.
- **Measuring spare processing capacity** — Since the Idle task only runs when all higher-priority tasks are blocked or suspended, measuring how much time the Idle task (and its hook) consumes provides a direct indication of how much spare CPU capacity the system has.
- **Low-power mode entry** — Placing the processor into a low-power state whenever there is no application work to do, providing automatic power savings.

#### 4.8.2 Limitations on Idle Task Hook Functions

Idle hook functions must follow strict rules to avoid breaking the scheduler:

> [!warning] **Idle Hook Constraints**
> 1. **Must never block or suspend.** Blocking the Idle task could create a situation where no tasks at all are available to enter the Running state, causing the system to deadlock.
> 2. **Must return within a reasonable time** if any application task uses `vTaskDelete()` to delete itself. Since the Idle task performs cleanup of deleted tasks after the hook returns, a hook that never returns prevents resource reclamation.
> 3. **Must use the exact name and prototype:**
>    ```c
>    void vApplicationIdleHook( void );
>    ```

The configuration constant `configUSE_IDLE_HOOK` must be set to `1` in `FreeRTOSConfig.h` for the hook function to be called.

> [!example] **Implementing an Idle Hook to Measure Spare Capacity**
> A simple idle hook that counts how many times it executes, providing a rough measure of spare processing time:
> ```c
> // Global counter incremented by the idle hook
> volatile unsigned long ulIdleCycleCount = 0UL;
>
> void vApplicationIdleHook( void )
> {
>     ulIdleCycleCount++;
> }
> ```
> The corresponding application task can then print this counter alongside its own output:
> ```c
> void vTaskFunction( void * pvParameters )
> {
>     char * pcTaskName = ( char * ) pvParameters;
>     const TickType_t xDelay250ms = pdMS_TO_TICKS( 250 );
>
>     for( ;; )
>     {
>         // Print task name and the current idle cycle count
>         vPrintLineAndNumber( pcTaskName, ulIdleCycleCount );
>         vTaskDelay( xDelay250ms );
>     }
> }
> ```
> When two such tasks block for 250 ms each iteration, the idle hook executes millions of times between application task iterations (the exact count depends on hardware speed). The large and growing `ulIdleCycleCount` value demonstrates that the system has significant spare processing capacity — the processor is spending most of its time in the Idle task because the application tasks are Blocked for the vast majority of each period.

## 4.12 Scheduling Algorithms

### 4.12.1 A Recap of Task States and Events

On a single-core processor, only one task can be in the **Running** state at any given time. Tasks that are not Running, not Blocked, and not Suspended are in the **Ready** state and are available for the scheduler to select. The scheduler always chooses the highest-priority Ready task to enter the Running state.

Tasks in the **Blocked** state are waiting for an event and are automatically moved back to the Ready state when that event occurs. There are two categories of events:

- **Temporal events** — Occur at a specific time, such as when a delay period expires. Used to implement periodic behavior and timeouts.
- **Synchronization events** — Occur when a task or interrupt service routine sends information via a task notification, queue, event group, message buffer, stream buffer, or semaphore. Used to signal asynchronous activity such as data arriving at a peripheral.

### 4.12.2 Selecting the Scheduling Algorithm

The scheduling algorithm is the software routine that decides which Ready task to transition into the Running state. FreeRTOS provides three scheduling configurations controlled by two compile-time constants in `FreeRTOSConfig.h`:

> [!summary] **Scheduling Algorithm Configuration**
> | Scheduling Algorithm | `configUSE_PREEMPTION` | `configUSE_TIME_SLICING` |
> |---|---|---|
> | Preemptive with Time Slicing | `1` | `1` |
> | Preemptive without Time Slicing | `1` | `0` |
> | Co-Operative | `0` | Any |

A third constant, `configUSE_TICKLESS_IDLE`, also affects scheduling by potentially turning off the tick interrupt for extended periods to minimize power consumption. The descriptions below assume `configUSE_TICKLESS_IDLE` is set to `0` (the default).

In all single-core configurations, the FreeRTOS scheduler shares processing time between equal-priority tasks using a "take it in turn" policy known as **Round Robin Scheduling**. This does not guarantee equal time sharing — only that Ready tasks of equal priority enter the Running state in turn.

### 4.12.3 Prioritized Preemptive Scheduling with Time Slicing

This is the default and most commonly used scheduling algorithm in small RTOS applications. Its name encodes three distinct properties:

> [!info] **Fixed Priority**
> The scheduler itself does not change task priorities. However, tasks are free to change their own priority or that of other tasks via API calls.

> [!info] **Preemptive**
> The scheduler immediately preempts the currently Running task if a higher-priority task enters the Ready state. Preemption means the Running task is involuntarily moved to the Ready state (without explicitly yielding or blocking) to make way for the higher-priority task. Preemption can occur at any time, not just during the tick interrupt.

> [!info] **Time Slicing**
> Processing time is shared between tasks of equal priority even when those tasks do not explicitly yield or block. At the end of each time slice (the interval between two tick interrupts), the scheduler selects a new task to run if other Ready tasks share the same priority as the current Running task.

![[Pasted image 20261025102518.png]]
Figure 4.18 Execution pattern highlighting task prioritization and preemption in a hypothetical application in which each task has been assigned a unique priority

![[Pasted image 20261025102545.png]]
Figure 4.19 Execution pattern highlighting task prioritization and time slicing in a hypothetical application in which two tasks run at the same priority

![[Pasted image 20261025102605.png]]
Figure 4.20 The execution pattern for the same scenario as shown in Figure 4.19, but this time with configIDLE_SHOULD_YIELD set to 1

**Execution behavior with unique priorities:** When every task has a distinct priority, the scheduler always selects the highest-priority Ready task. The Idle task runs only when no application task can run and is preempted the instant any higher-priority task becomes Ready. Higher-priority event-driven tasks preempt lower-priority tasks immediately when their events occur, and the lower-priority tasks resume only after all higher-priority tasks have re-entered the Blocked state.

**Execution behavior with shared priorities:** When two or more tasks share a priority, the scheduler rotates between them at each tick interrupt boundary. A higher-priority task can still preempt any of them mid-slice. When the higher-priority task blocks again, the equal-priority tasks resume sharing time via time slicing.



> [!note] **`configIDLE_SHOULD_YIELD` Behavior**
> When application tasks exist at priority 0 (the same priority as the Idle task), the `configIDLE_SHOULD_YIELD` constant controls how the Idle task shares time with them:
> - **Set to `0`:** The Idle task remains in the Running state for the entirety of its time slice unless preempted by a higher-priority task. This can waste processing time if the Idle task has no useful work but application tasks at priority 0 do.
> - **Set to `1`:** The Idle task yields (voluntarily gives up the remainder of its time slice) on each iteration of its loop if other priority-0 tasks are Ready. The task that receives the yielded time executes only for the remainder of the current slice, not a full new slice.

### 4.12.4 Prioritized Preemptive Scheduling without Time Slicing

This configuration (`configUSE_PREEMPTION = 1`, `configUSE_TIME_SLICING = 0`) maintains the same preemption behavior — higher-priority tasks still immediately preempt lower-priority ones — but does _not_ rotate between equal-priority tasks at tick boundaries.

Without time slicing, the scheduler only selects a new Running task when:

1. A higher-priority task enters the Ready state, or
2. The currently Running task enters the Blocked or Suspended state.

![[Pasted image 20261025102732.png]]
Figure 4.21 Execution pattern that demonstrates how tasks of equal priority can receive hugely different amounts of processing time when time slicing is not used

> [!tip] **Trade-offs of Disabling Time Slicing**
> - **Advantage:** Fewer context switches, which reduces scheduler processing overhead.
> - **Disadvantage:** Equal-priority tasks can receive vastly different amounts of processing time depending on when higher-priority preemptions happen to occur. One task might run for many tick periods while another at the same priority runs for less than one tick period before being interrupted.

> [!warning] **Advanced Technique**
> Running without time slicing can lead to significant processing time imbalances between equal-priority tasks. This is considered an advanced configuration that should only be used by experienced users who understand the implications for their specific application.

### 4.12.5 Cooperative Scheduling

When `configUSE_PREEMPTION` is set to `0`, FreeRTOS uses a **cooperative scheduler**. In this mode, tasks are _never_ preempted. A context switch occurs only when:

1. The Running task enters the Blocked state, or
2. The Running task explicitly yields by calling `taskYIELD()`.

Time slicing cannot be used because the scheduler has no mechanism to force a task out of the Running state.

![[Pasted image 20261025102802.png]]
Figure 4.22 Execution pattern demonstrating the behavior of the cooperative scheduler

> [!info] **Cooperative vs. Preemptive Responsiveness**
> - **Preemptive:** The scheduler starts running a task _immediately_ when it becomes the highest-priority Ready task. This is essential in real-time systems that must respond to high-priority events within a defined time window.
> - **Cooperative:** A newly Ready high-priority task must _wait_ until the currently Running task voluntarily yields or blocks. This makes the system less responsive, as the delay depends entirely on the behavior of the Running task.

**Resource sharing advantage of cooperative scheduling:** In a preemptive system, the Running task can be preempted at any moment, including while it holds a shared resource in an inconsistent state. This can lead to data corruption.

> [!example] **UART Corruption from Preemption**
> Consider two tasks writing to a shared UART (serial port). Task 1 writes `"abcdefghijklmnop"` and Task 2 writes `"123456789"`:
> 1. Task 1 is Running and writes `"abcdefg"`, then gets preempted.
> 2. Task 2 runs and writes `"123456789"`.
> 3. Task 1 resumes and writes `"hijklmnop"`.
>
> The UART output becomes `"abcdefg123456789hijklmnop"` — Task 1's string is corrupted by Task 2's output appearing in the middle of it.
>
> With a **cooperative scheduler**, Task 1 would not be preempted mid-write. It would complete its entire string before yielding, producing the correct output `"abcdefghijklmnop123456789"`. The application writer controls exactly when task switches occur and can ensure they never happen while a shared resource is in an inconsistent state.

> [!warning] **Cooperative Scheduling Limitation**
> While cooperative scheduling simplifies resource sharing, the application writer bears full responsibility for ensuring tasks yield frequently enough to maintain system responsiveness. A single task that fails to yield or block can stall the entire system. Methods for safely sharing resources under preemptive scheduling (such as mutexes and critical sections) are the preferred approach in most real-time applications.

## 5 Queue Management

### 5.1 Introduction

Queues provide a task-to-task, task-to-interrupt, and interrupt-to-task communication mechanism in FreeRTOS.

#### 5.1.1 Scope

This section covers creating queues, how queues manage data, sending and receiving data, blocking behavior on queues (including blocking on multiple queues), overwriting and clearing queues, and the effect of task priorities on queue operations. Task-to-interrupt and interrupt-to-task communication via queues is an advanced topic not covered here.

### 5.2 Characteristics of a Queue

#### 5.2.1 Data Storage

A queue holds a finite number of fixed-size data items. The maximum number of items is called the queue's **length**. Both the length and the item size are set at creation time.

Queues are normally used as **First In First Out (FIFO)** buffers — data is written to the tail (back) and removed from the head (front). It is also possible to write to the front of a queue or overwrite data already at the front.

![[Pasted image 20261025103228.png]]
Figure 5.1 An example sequence of writes to, and reads from a queue

There are two conceptual approaches to queue implementation:

1. **Queue by copy** — Data sent to the queue is copied byte-for-byte into the queue's internal storage.
2. **Queue by reference** — The queue holds only pointers to the data, not the data itself.

> [!info] **FreeRTOS Uses Queue by Copy**
> FreeRTOS implements queues by copy because it is both more powerful and simpler to use. Key advantages:
> - Queue by copy does not prevent queueing by reference — if data is too large to copy, a pointer to the data can be copied into the queue instead.
> - Stack-allocated variables can be sent directly, even though they will not exist after the declaring function returns.
> - No need to pre-allocate a separate buffer before sending data.
> - The sending task can immediately re-use the variable or buffer after the send call returns.
> - Sending and receiving tasks are completely de-coupled — no ownership or cleanup concerns.
> - The RTOS manages all memory allocation for queue storage.
> - Data can pass across memory protection boundaries, which is not always possible with reference-based queueing.

#### 5.2.2 Access by Multiple Tasks

Queues are standalone objects accessible by any task or interrupt service routine (ISR) that holds their handle. Any number of tasks can write to the same queue, and any number of tasks can read from it. In practice, multiple writers are common, but multiple readers on a single queue are less typical.

#### 5.2.3 Blocking on Queue Reads

When a task reads from a queue, it can optionally specify a **block time** — the maximum duration the task remains in the Blocked state waiting for data if the queue is empty. The task is automatically moved to the Ready state when:

- Data is placed into the queue by another task or ISR, or
- The block time expires without data becoming available.

When multiple tasks are blocked on the same empty queue, only one is unblocked when data arrives. The unblocked task is always the **highest-priority** waiting task. If multiple blocked tasks share the same priority, the one that has been waiting the longest is unblocked first.

#### 5.2.4 Blocking on Queue Writes

Similarly, a task writing to a full queue can specify a block time — the maximum duration it remains Blocked waiting for space. The task unblocks when space becomes available or the timeout expires.

When multiple tasks are blocked on the same full queue, only one is unblocked when space becomes available, following the same priority-then-wait-time rules as queue reads.

#### 5.2.5 Blocking on Multiple Queues

Queues can be grouped into **queue sets**, allowing a single task to block and wait for data on _any_ queue within the set. This is useful when a task needs to respond to events from multiple sources.

#### 5.2.6 Creating Queues: Static and Dynamic Allocation

Queues are referenced by handles of type `QueueHandle_t` and must be explicitly created before use. Two API functions are available:

- `xQueueCreate()` — Allocates the queue's data structure and storage area dynamically from the heap.
- `xQueueCreateStatic()` — Uses pre-allocated RAM passed in as parameters.

Each queue requires two blocks of RAM: one for its internal data structure and one for the queued data items.

### 5.3 Using a Queue

#### 5.3.1 The `xQueueCreate()` API Function

> [!example] **`xQueueCreate()` Prototype and Breakdown**
> ```c
> QueueHandle_t xQueueCreate( UBaseType_t uxQueueLength,
>                             UBaseType_t uxItemSize );
> ```
> - **`uxQueueLength`** — The maximum number of items the queue can hold at any one time.
> - **`uxItemSize`** — The size in bytes of each data item the queue will store.
>
> **Return value:**
> - A non-`NULL` `QueueHandle_t` on success — this handle is used in all subsequent queue operations.
> - `NULL` if there is insufficient heap memory to allocate the queue structures and storage.

The `xQueueReset()` API function can restore a previously created queue to its original empty state.

#### 5.3.2 The `xQueueSendToBack()` and `xQueueSendToFront()` API Functions

`xQueueSendToBack()` appends data to the tail of the queue (standard FIFO behavior). `xQueueSendToFront()` inserts data at the head, allowing it to be the next item read. `xQueueSend()` is an alias for `xQueueSendToBack()`.

> [!warning] **ISR Safety**
> Never call `xQueueSendToFront()` or `xQueueSendToBack()` from an interrupt service routine. Use the interrupt-safe variants `xQueueSendToFrontFromISR()` and `xQueueSendToBackFromISR()` instead.

> [!example] **Send Function Prototypes and Breakdown**
> ```c
> BaseType_t xQueueSendToFront( QueueHandle_t xQueue,
>                               const void * pvItemToQueue,
>                               TickType_t xTicksToWait );
>
> BaseType_t xQueueSendToBack( QueueHandle_t xQueue,
>                              const void * pvItemToQueue,
>                              TickType_t xTicksToWait );
> ```
> - **`xQueue`** — Handle of the target queue, as returned by `xQueueCreate()` or `xQueueCreateStatic()`.
> - **`pvItemToQueue`** — Pointer to the data to be copied into the queue. The number of bytes copied equals the item size specified at queue creation.
> - **`xTicksToWait`** — Maximum block time (in tick periods) to wait for space if the queue is full. Use `pdMS_TO_TICKS()` to convert from milliseconds. A value of `0` causes an immediate return if the queue is full. A value of `portMAX_DELAY` causes an indefinite wait (requires `INCLUDE_vTaskSuspend` set to `1`).
>
> **Return values:**
> - `pdPASS` — Data was successfully written to the queue. If a block time was specified, the task may have been Blocked temporarily while waiting for space.
> - `errQUEUE_FULL` (same as `pdFAIL`) — Data could not be written because the queue was full and the block time expired before space became available.

#### 5.3.3 The `xQueueReceive()` API Function

`xQueueReceive()` reads and removes an item from the front of the queue.

> [!warning] **ISR Safety**
> Never call `xQueueReceive()` from an ISR. Use `xQueueReceiveFromISR()` instead.

> [!example] **`xQueueReceive()` Prototype and Breakdown**
> ```c
> BaseType_t xQueueReceive( QueueHandle_t xQueue,
>                           void * const pvBuffer,
>                           TickType_t xTicksToWait );
> ```
> - **`xQueue`** — Handle of the queue to read from.
> - **`pvBuffer`** — Pointer to a buffer large enough to hold one queue item (at least `uxItemSize` bytes, as set at creation). The received data is copied into this buffer.
> - **`xTicksToWait`** — Maximum block time (in ticks) to wait for data if the queue is empty. `0` returns immediately if empty. `portMAX_DELAY` waits indefinitely (requires `INCLUDE_vTaskSuspend = 1`). Use `pdMS_TO_TICKS()` for millisecond conversion.
>
> **Return values:**
> - `pdPASS` — Data was successfully read from the queue.
> - `errQUEUE_EMPTY` (same as `pdFAIL`) — The queue was empty and the block time expired before data arrived.

#### 5.3.4 The `uxQueueMessagesWaiting()` API Function

> [!example] **`uxQueueMessagesWaiting()` Prototype**
> ```c
> UBaseType_t uxQueueMessagesWaiting( QueueHandle_t xQueue );
> ```
> - **`xQueue`** — Handle of the queue to query.
> - **Returns** the number of items currently in the queue. A return value of `0` means the queue is empty.
>
> The interrupt-safe variant is `uxQueueMessagesWaitingFromISR()`.

#### Example 5.1: Blocking When Receiving from a Queue

This example demonstrates a complete queue workflow: creating a queue, sending data from multiple tasks, and receiving data with a block time. The key design point is the relationship between sender and receiver priorities.

The queue is created to hold `int32_t` values. Two sender tasks (priority 1) continuously write values to the queue with no block time. One receiver task (priority 2) reads from the queue with a 100 ms block time. Because the receiver has higher priority, it preempts the senders as soon as data arrives, meaning the queue should never hold more than one item at a time.

> [!example] **Sender Task**
> ```c
> static void vSenderTask( void * pvParameters )
> {
>     // The value to send is passed via the task parameter
>     int32_t lValueToSend = ( int32_t ) pvParameters;
>     BaseType_t xStatus;
>
>     for( ;; )
>     {
>         // Send to back of queue with no block time (queue should never be full)
>         xStatus = xQueueSendToBack( xQueue, &lValueToSend, 0 );
>
>         if( xStatus != pdPASS )
>         {
>             vPrintString( "Could not send to the queue.\r\n" );
>         }
>     }
> }
> ```

> [!example] **Receiver Task**
> ```c
> static void vReceiverTask( void * pvParameters )
> {
>     int32_t lReceivedValue;
>     BaseType_t xStatus;
>     const TickType_t xTicksToWait = pdMS_TO_TICKS( 100 );
>
>     for( ;; )
>     {
>         // Sanity check: queue should be empty since this task
>         // immediately removes any data written by the senders
>         if( uxQueueMessagesWaiting( xQueue ) != 0 )
>         {
>             vPrintString( "Queue should have been empty!\r\n" );
>         }
>
>         // Block for up to 100 ms waiting for data
>         xStatus = xQueueReceive( xQueue, &lReceivedValue, xTicksToWait );
>
>         if( xStatus == pdPASS )
>         {
>             vPrintStringAndNumber( "Received = ", lReceivedValue );
>         }
>         else
>         {
>             // Timeout — should not happen since senders are continuous
>             vPrintString( "Could not receive from the queue.\r\n" );
>         }
>     }
> }
> ```

> [!example] **`main()` — Queue and Task Creation**
> ```c
> QueueHandle_t xQueue;
>
> int main( void )
> {
>     // Create a queue that can hold up to 5 int32_t values
>     xQueue = xQueueCreate( 5, sizeof( int32_t ) );
>
>     if( xQueue != NULL )
>     {
>         // Two sender tasks at priority 1, each sending a different value
>         xTaskCreate( vSenderTask, "Sender1", 1000,
>                      ( void * ) 100, 1, NULL );
>         xTaskCreate( vSenderTask, "Sender2", 1000,
>                      ( void * ) 200, 1, NULL );
>
>         // Receiver task at priority 2 (higher than senders)
>         xTaskCreate( vReceiverTask, "Receiver", 1000,
>                      NULL, 2, NULL );
>
>         vTaskStartScheduler();
>     }
>
>     // Should never reach here
>     for( ;; );
> }
> ```

The execution sequence follows a predictable pattern driven by priority:

1. The receiver task (priority 2) starts first and calls `xQueueReceive()`. The queue is empty, so it enters the Blocked state for up to 100 ms.
2. A sender task (priority 1) runs and writes a value to the queue. This immediately unblocks the receiver.
3. The receiver preempts the sender (higher priority), reads the value from the queue, prints it, and calls `xQueueReceive()` again.
4. The queue is empty again, so the receiver blocks, and the cycle repeats.

Because the receiver always drains the queue immediately, the queue never accumulates items despite having a capacity of five. The 100 ms timeout never expires because the senders are continuously writing. The output alternates between the two sent values (100 and 200) as the two sender tasks take turns running during the brief windows when the receiver is blocked.

![[Pasted image 20261025103325.png]]
Figure 5.3 The sequence of execution produced by Example

## 8 Resource Management

### 8.1 Chapter Introduction and Scope

In a multitasking system, errors can occur when a task begins accessing a resource but is preempted before completing its access. If the resource is left in an inconsistent state, any other task or interrupt that accesses the same resource may corrupt data or cause other failures.

Common scenarios that expose this risk include:

**Accessing peripherals** — If Task A begins writing `"Hello world"` to an LCD and is preempted after outputting `"Hello w"`, Task B might write `"Abort, Retry, Fail?"` before Task A resumes and finishes with `"orld"`. The LCD displays the corrupted string `"Hello wAbort, Retry, Fail?orld"`.

**Read-modify-write operations** — A C statement like `PORTA |= 0x01;` typically compiles to multiple assembly instructions: load the register value, modify it, and store it back. If a task is preempted between the read and the write, another task may update the register in the interim. When the first task resumes and writes back its stale copy, it overwrites the second task's modification.

> [!example] **Read-Modify-Write in Assembly**
> ```c
> /* C code */
> PORTA |= 0x01;
> ```
> ```asm
> ; Equivalent assembly — non-atomic, can be interrupted between any step
> LOAD  R1, [#PORTA]   ; Read PORTA into R1
> MOVE  R2, #0x01      ; Load constant 1 into R2
> OR    R1, R2         ; Bitwise OR
> STORE R1, [#PORTA]   ; Write modified value back to PORTA
> ```

**Non-atomic variable access** — Updating multiple members of a structure, or updating a variable larger than the architecture's natural word size (e.g., a 32-bit variable on a 16-bit machine), requires multiple instructions and can be corrupted if interrupted.

**Function reentrancy** — A function is **reentrant** (or **thread-safe**) if it is safe to call from multiple tasks or from both tasks and interrupts simultaneously. A function that only uses stack-allocated variables and processor registers is inherently reentrant because each caller has its own stack and register set. Functions that access global or `static` variables are _not_ reentrant because all callers share the same copy of those variables.

> [!example] **Reentrant vs. Non-Reentrant Functions**
> ```c
> // REENTRANT: All data is on the stack or in registers.
> // Each caller gets its own copy of lVar1 and lVar2.
> long lAddOneHundred( long lVar1 )
> {
>     long lVar2;
>     lVar2 = lVar1 + 100;
>     return lVar2;
> }
> ```
> ```c
> // NOT REENTRANT: lVar1 is global and lState is static.
> // All callers share the same copies — concurrent access causes corruption.
> long lVar1;
> long lNonsenseFunction( void )
> {
>     static long lState = 0;
>     long lReturn;
>     switch( lState )
>     {
>         case 0: lReturn = lVar1 + 10; lState = 1; break;
>         case 1: lReturn = lVar1 + 20; lState = 0; break;
>     }
> }
> ```

> [!tip] **C Library Thread Local Storage (TLS)**
> If the application uses a C library that requires per-task Thread Local Storage, the appropriate configuration constant must be set in `FreeRTOSConfig.h`:
> - **newlib:** Set `configUSE_NEWLIB_REENTRANT` to `1`.
> - **picolibc:** Set `configUSE_PICOLIBC_TLS` to `1`.
> - **Other libraries:** Set `configUSE_C_RUNTIME_TLS_SUPPORT` to `1` and implement the macros `configTLS_BLOCK_TYPE`, `configINIT_TLS_BLOCK`, `configSET_TLS_BLOCK`, and `configDEINIT_TLS_BLOCK`.

#### 8.1.1 Mutual Exclusion

To maintain data consistency, access to any shared resource that is not reentrant and not thread-safe must be managed using a **mutual exclusion** technique. The goal is to ensure that once a task begins accessing a shared resource, it retains exclusive access until the resource is returned to a consistent state.

> [!tip] **Best Mutual Exclusion Strategy**
> The most effective mutual exclusion method is to design the application so that resources are _not shared_ — each resource is accessed from only a single task. When this is not practical, FreeRTOS provides several mechanisms described below.

#### 8.1.2 Scope

This section covers when and why resource management is necessary, critical sections, mutual exclusion, scheduler suspension, mutexes, gatekeeper tasks, priority inversion, and priority inheritance.

### 8.2 Critical Sections and Suspending the Scheduler

#### 8.2.1 Basic Critical Sections

A **critical section** (or **critical region**) is a block of code protected by the macros `taskENTER_CRITICAL()` and `taskEXIT_CRITICAL()`. These macros take no parameters and return no value.

> [!example] **Protecting a Register Access with a Critical Section**
> ```c
> taskENTER_CRITICAL();
> {
>     // No context switch can occur here. Interrupts are disabled
>     // (or masked up to configMAX_SYSCALL_INTERRUPT_PRIORITY).
>     PORTA |= 0x01;
> }
> taskEXIT_CRITICAL();
> ```

Critical sections work by **disabling interrupts** — either completely or up to the priority level defined by `configMAX_SYSCALL_INTERRUPT_PRIORITY`, depending on the FreeRTOS port. Since preemptive context switches can only occur from within an interrupt, the calling task is guaranteed to remain in the Running state for the duration of the critical section.

> [!warning] **Critical Section Constraints**
> - **Keep them very short.** Disabling interrupts degrades interrupt response times. Long operations (such as writing to a terminal) should not be protected this way.
> - **Always pair entry and exit.** Every `taskENTER_CRITICAL()` must have a matching `taskEXIT_CRITICAL()`.
> - **Nesting is safe.** The kernel tracks nesting depth; the critical section only truly exits when the depth returns to zero.
> - **Do not alter interrupt state by other means.** Manually changing the processor's interrupt enable state will corrupt the kernel's nesting count.

**ISR-safe variants** exist for ports that support interrupt nesting:

> [!example] **Critical Section Inside an ISR**
> ```c
> void vAnInterruptServiceRoutine( void )
> {
>     UBaseType_t uxSavedInterruptStatus;
>
>     // Unprotected code — can be interrupted by any higher-priority ISR
>
>     uxSavedInterruptStatus = taskENTER_CRITICAL_FROM_ISR();
>     {
>         // Protected code — only ISRs above
>         // configMAX_SYSCALL_INTERRUPT_PRIORITY can interrupt
>     }
>     taskEXIT_CRITICAL_FROM_ISR( uxSavedInterruptStatus );
>
>     // Unprotected code again
> }
> ```
> The ISR-safe `taskENTER_CRITICAL_FROM_ISR()` returns a value that _must_ be passed to the matching `taskEXIT_CRITICAL_FROM_ISR()`.

Basic critical sections are very fast to enter and exit, and their execution time is always deterministic, making them ideal for protecting very short code regions.

#### 8.2.2 Suspending (Locking) the Scheduler

An alternative to disabling interrupts is to **suspend the scheduler** (also called **locking** the scheduler). This prevents context switches between tasks but leaves interrupts fully enabled.

| Aspect | Basic Critical Section | Scheduler Suspension |
|---|---|---|
| Blocks other tasks | Yes | Yes |
| Blocks interrupts | Yes (fully or partially) | No |
| Suitable for long operations | No | Potentially, but with caveats |
| Interrupt activity during hold | N/A | Can make resumption slow |

A critical section too long for interrupt disabling can use scheduler suspension instead. However, if many interrupts fire while the scheduler is suspended, the pending context switches that accumulate can make the resumption operation relatively lengthy.

#### 8.2.3 The `vTaskSuspendAll()` API Function

> [!example] **`vTaskSuspendAll()` Prototype**
> ```c
> void vTaskSuspendAll( void );
> ```
> Suspends the scheduler, preventing context switches. Interrupts remain enabled. If an interrupt requests a context switch while the scheduler is suspended, the request is held pending and performed when the scheduler resumes.
>
> **Important:** FreeRTOS API functions must _not_ be called while the scheduler is suspended.

#### 8.2.4 The `xTaskResumeAll()` API Function

> [!example] **`xTaskResumeAll()` Prototype and Breakdown**
> ```c
> BaseType_t xTaskResumeAll( void );
> ```
> Resumes (un-suspends) the scheduler. Any pending context switch requests accumulated during the suspension are processed as the scheduler resumes.
>
> **Return value:**
> - `pdTRUE` — A pending context switch was performed before the function returned.
> - `pdFALSE` — No pending context switch was performed.
>
> Nesting is safe: the kernel tracks depth, and the scheduler only truly resumes when the nesting count returns to zero.

> [!example] **Protecting Terminal Output by Suspending the Scheduler**
> ```c
> void vPrintString( const char * pcString )
> {
>     vTaskSuspendAll();
>     {
>         printf( "%s", pcString );
>         fflush( stdout );
>     }
>     xTaskResumeAll();
> }
> ```
> This approach is preferable to a basic critical section for terminal output because the operation may take a relatively long time, and keeping interrupts disabled that long would harm system responsiveness.

### 8.3 Mutexes (and Binary Semaphores)

A **mutex** (from **MUT**ual **EX**clusion) is a special type of binary semaphore used to control access to a shared resource. It can be thought of as a **token** associated with the resource:

1. A task must successfully **take** the token before accessing the resource.
2. When finished, the task must **give** the token back.
3. Only the token holder may access the resource. Other tasks must wait.

![[Pasted image 20261025110357.png]]
Figure 8.1 Mutual exclusion implemented using a mutex

> [!info] **Mutex vs. Binary Semaphore for Synchronization**
> Although mutexes and binary semaphores share many characteristics, their usage patterns differ fundamentally:
> - A **mutex** (mutual exclusion) must always be returned after being taken. The same task that takes it must give it back.
> - A **binary semaphore** (synchronization) is normally taken by one context and given by a different context (e.g., an ISR gives, a task takes). The taken semaphore is typically not returned.

Mutexes require `configUSE_MUTEXES` set to `1` in `FreeRTOSConfig.h`. The enforcement is through application discipline — the hardware does not prevent a task from accessing the resource without holding the mutex.

#### 8.3.1 The `xSemaphoreCreateMutex()` API Function

> [!example] **`xSemaphoreCreateMutex()` Prototype and Breakdown**
> ```c
> SemaphoreHandle_t xSemaphoreCreateMutex( void );
> ```
> - **Returns** a `SemaphoreHandle_t` on success, or `NULL` if there is insufficient heap memory.
> - A static allocation variant, `xSemaphoreCreateMutexStatic()`, is also available for compile-time memory allocation.

> [!example] **Using a Mutex to Protect Shared Terminal Output**
> ```c
> // The mutex handle, created before the scheduler starts
> SemaphoreHandle_t xMutex;
>
> static void prvNewPrintString( const char * pcString )
> {
>     // Block indefinitely until the mutex is obtained.
>     // With portMAX_DELAY, xSemaphoreTake() only returns on success,
>     // so no return-value check is needed.
>     xSemaphoreTake( xMutex, portMAX_DELAY );
>     {
>         // Only one task can be here at a time
>         printf( "%s", pcString );
>         fflush( stdout );
>     }
>     // The mutex MUST be given back
>     xSemaphoreGive( xMutex );
> }
> ```
> ```c
> static void prvPrintTask( void * pvParameters )
> {
>     char * pcStringToPrint = ( char * ) pvParameters;
>     const TickType_t xMaxBlockTimeTicks = 0x20;
>
>     for( ;; )
>     {
>         prvNewPrintString( pcStringToPrint );
>         vTaskDelay( ( rand() % xMaxBlockTimeTicks ) );
>     }
> }
> ```
> ```c
> int main( void )
> {
>     xMutex = xSemaphoreCreateMutex();
>
>     if( xMutex != NULL )
>     {
>         // Two tasks at different priorities to force preemption
>         xTaskCreate( prvPrintTask, "Print1", 1000,
>                      "Task 1 ***************************************\r\n",
>                      1, NULL );
>         xTaskCreate( prvPrintTask, "Print2", 1000,
>                      "Task 2 ---------------------------------------\r\n",
>                      2, NULL );
>
>         vTaskStartScheduler();
>     }
>
>     for( ;; );
> }
> ```
> Even though the higher-priority task preempts the lower-priority task, the mutex ensures that each string is printed completely and without corruption. The output order may vary due to the random delays, but no string will be interleaved with another.

![[Pasted image 20261025110420.png]]
Figure 8.3 A possible sequence of execution for Example

#### 8.3.2 Priority Inversion

**Priority inversion** occurs when a higher-priority task is forced to wait for a lower-priority task that holds a mutex the higher-priority task needs. This is undesirable because it inverts the intended priority ordering.

The problem becomes significantly worse when a **medium-priority** task enters the picture. While the high-priority task waits for the mutex held by the low-priority task, the medium-priority task can preempt the low-priority task, preventing it from running and releasing the mutex. The result is that the high-priority task is effectively blocked by the medium-priority task — which doesn't even use the contested resource. This worst case is called **unbounded priority inversion** because the delay has no defined upper limit.

> [!tip] **Avoiding Priority Inversion**
> In small embedded systems, priority inversion can often be avoided at design time by carefully considering how resources are accessed and which tasks share them.

![[Pasted image 20261025110522.png]]
Figure 8.4 A worst case priority inversion scenario
#### 8.3.3 Priority Inheritance

FreeRTOS mutexes include a basic **priority inheritance** mechanism (binary semaphores do not). Priority inheritance minimizes the effects of priority inversion by temporarily raising the priority of the mutex holder to match the priority of the highest-priority task waiting for that mutex.

The mechanism works as follows:
1. A low-priority task holds a mutex.
2. A high-priority task attempts to take the same mutex and blocks.
3. The low-priority task **inherits** the high-priority task's priority, allowing it to run without being preempted by medium-priority tasks.
4. When the mutex holder gives back the mutex, its priority is automatically reset to its original value.
5. The high-priority task can now take the mutex and proceed.

![[Pasted image 20261025110555.png]]
Figure 8.5 Priority inheritance minimizing the effect of priority inversion

> [!warning] **Priority Inheritance Limitations**
> - Priority inheritance **lessens** the impact of priority inversion but does not eliminate it. The inversion is made time-bounded rather than unbounded.
> - It complicates system timing analysis and should not be relied upon for correct system operation.
> - Because it modifies task priorities, **mutexes must not be used from ISRs**.
> - FreeRTOS implements a _basic_ priority inheritance optimized for space and speed. A full implementation would require significantly more overhead, especially when a task holds multiple mutexes.

Specific behaviors of the FreeRTOS priority inheritance mechanism:
- A task's inherited priority can be raised further if it takes additional mutexes without releasing those it already holds.
- A task remains at its highest inherited priority until it has released _all_ mutexes it holds, regardless of the order in which they are released.
- A task retains its highest inherited priority even if tasks waiting on some of its held mutexes time out.

#### 8.3.4 Deadlock (Deadly Embrace)

**Deadlock** occurs when two or more tasks are each waiting for a resource held by the other, creating a circular dependency where neither can proceed.

> [!example] **Classic Deadlock Scenario**
> Task A and Task B both need mutex X and mutex Y:
> 1. Task A takes mutex X.
> 2. Task B preempts Task A and takes mutex Y.
> 3. Task B tries to take mutex X — blocked (held by A).
> 4. Task A resumes and tries to take mutex Y — blocked (held by B).
>
> Neither task can proceed. Both are permanently Blocked.

> [!tip] **Avoiding Deadlock**
> - The best approach is to design the system so that deadlock cannot occur (e.g., always acquire multiple mutexes in a consistent global order).
> - Avoid waiting indefinitely for a mutex. Use a timeout slightly longer than the expected maximum wait. If the timeout expires, it signals a design error that may be a deadlock.
> - In small embedded systems, deadlock is usually manageable because the designer can understand the entire application and identify potential deadlock scenarios at design time.

## 5.5 Scheduling principles

With an understanding of the process lifecycle and system calls, we can examine the principles of OS scheduling and the criteria an operating system uses to make scheduling decisions.

At any given time, a number of tasks are active in the system. Each task spends a portion of its lifetime running on the CPU and another portion waiting (e.g., for I/O). A task may also be ready to run but unable to do so because the CPU is occupied by another task. The scheduler's job is to decide which ready task gets the CPU next and for how long.

### 5.5.1 Preemptive versus non-preemptive scheduling

The first major design decision is whether the scheduler can forcibly interrupt a running task — for example, to run a task it considers more important (higher priority).

- **Preemptive scheduling** allows the scheduler to interrupt running tasks at any time. Linux uses preemptive scheduling exclusively.
- **Non-preemptive (cooperative) scheduling** relies on tasks voluntarily yielding the CPU to other tasks. This approach, known as cooperative multitasking, is rarely used in modern operating systems.

> [!note] **Preemption vs. Waiting**
> Moving a task to the waiting state (e.g., because it issued a blocking system call) is _not_ considered preemption from a scheduling perspective. The task chose to stop running. From the scheduler's point of view, the remainder of the task's execution can be treated as a new scheduling unit belonging to the same process or thread.

### 5.5.2 Scheduling policies

The **scheduling policy** is the overall approach the scheduler takes. Conceptually, the scheduler maintains an ordered list of tasks that are ready to run (the **run queue**). The task at the head of the list runs next. The two core decisions that define a scheduling policy are:

1. **Placement** — Where in the run queue to insert a newly ready task.
2. **Duration** — How long a task may run before being preempted or yielding.

The practical implementation of a policy is a **scheduling algorithm**. Linux supports several scheduling policies, and each task (process or thread) can be assigned to one of them individually.

### 5.5.3 Task attributes

The scheduler decides which task is "more important" based on **task attributes**. These attributes influence whether a task runs sooner, longer, or both. Common attributes include:

- **Arrival time** — When the task was placed in the run queue.
- **Position in the queue** — Its current ordering.
- **Execution time** — How long the task is expected to run (or has already run).
- **Accumulated CPU time** — How much CPU time the task has already consumed.
- **Explicit priority** — A small integer value assigned to the task that the kernel uses to assess importance.

The Linux kernel uses several of these attributes depending on the active scheduling policy. All threads in Linux have a priority attribute.

## 5.6 Scheduling criteria

Different scheduling policies optimize for different goals. The most commonly used criteria are:

| Criterion | Definition | Goal |
|---|---|---|
| **CPU utilization** | The percentage of time the CPU is busy. | Maximize (ideally 100%) |
| **Throughput** | The number of processes completed per unit time. | Maximize |
| **Turnaround time** | The wall-clock time from a task's creation to its completion. | Minimize |
| **Waiting time** | The time a task spends in the ready queue waiting for the CPU. | Minimize |
| **Response time** | The time between submitting a request and receiving the first response. | Minimize |
| **Load average** | The average number of processes in the ready queue. | Context-dependent |

> [!tip] **Optimization Goals**
> In general, the aim is to maximize CPU utilization and throughput while minimizing turnaround time, waiting time, and response time. It is also desirable to minimize the _variance_ of these metrics — users prefer a consistently predictable system over one that performs better on average but is erratic.

## 5.7 Scheduling policies

The following sections describe common scheduling policies. These foundational algorithms help explain the design choices and implementation details of the Linux kernel scheduler.
![[Pasted image 20261025111645.png]]
Table 5.3: Example task configuration.
### 5.7.1 First-come, first-served (FCFS)

FCFS is the simplest scheduling policy. The only attribute that determines priority is the task's arrival time in the run queue, which is a FIFO (First In, First Out) structure. The scheduler takes the task at the head of the queue and runs it until it either finishes or blocks on a system call. When the task finishes waiting, it is re-added to the tail of the run queue.
![[Pasted image 20261025111701.png]]
Figure 5.2: Schedule for the example task configuration with non-preemptive FCFS.
![[Pasted image 20261025111711.png]]
Figure 5.3: Schedule for the example task configuration with preemptive FCFS.

FCFS can be either preemptive or non-preemptive:

- **Non-preemptive FCFS:** A running task continues until it finishes or blocks, even if a new task arrives.
- **Preemptive FCFS:** A newly arriving task can preempt the current task (though this is less common with FCFS since priority is based solely on arrival order).

> [!warning] **FCFS Limitations**
> FCFS can suffer from the **convoy effect**: a single long-running CPU-bound task at the head of the queue can cause many short tasks to wait excessively, degrading average turnaround and waiting times significantly.

### 5.7.2 Round-robin (RR)

Round-robin scheduling runs every task for a fixed amount of time called the **time slice** or **scheduling quantum**. When a task's time slice expires, it is preempted and placed at the tail of the run queue, and the next task in line gets a turn.

> [!info] **Choosing the Quantum**
> The quantum is a critical parameter:
> - **Too long:** The system becomes unresponsive, behaving more like FCFS.
> - **Too short:** Context switching overhead dominates, wasting CPU cycles.
>
> On Linux, the default round-robin quantum can be checked with:
> ```bash
> cat /proc/sys/kernel/sched_rr_timeslice_ms
> ```
> A typical value is 10 ms.

Round-robin is widely used because of its simplicity and fairness — every ready task gets an equal share of the CPU over time.
![[Pasted image 20261025111732.png]]
Figure 5.4: Schedule for the example task configuration with Round-Robin scheduling.

### 5.7.3 Priority-driven scheduling

In priority-driven scheduling, the run queue is ordered by task priority, forming a **priority queue**. The scheduler always selects the highest-priority ready task to run next.

Key characteristics of priority-driven schedulers:

- They are **on-line schedulers** — they make decisions dynamically as tasks arrive and complete, without precomputing a full schedule.
- Priorities are assigned when tasks are released and placed in the ready queue in priority order.
- When preemption is allowed, a scheduling decision is made whenever a task is released or completes.
- At each decision point, the scheduler updates the ready queue and runs the task at the head.

Priority-driven algorithms can be further classified:

- **Fixed-priority:** All jobs belonging to the same task receive the same priority.
- **Dynamic-priority:** Individual jobs within a task may receive different priorities.

### 5.7.4 Shortest job first (SJF) and shortest remaining time first (SRTF)

**Shortest Job First (SJF)** reorders the run queue so that the task with the shortest expected execution time is at the head. The priority is effectively the inverse of the predicted remaining CPU time.

> [!info] **SJF Optimality**
> SJF is provably optimal in the sense that, for a given set of tasks with known execution times, it produces the **minimum average waiting time** across all processes.

However, SJF is impractical in most real systems because the scheduler generally cannot know in advance how long a task will take to complete. It is considered a **clairvoyant algorithm** — one that requires information not available at scheduling time.
![[Pasted image 20261025111749.png]]
Figure 5.5: Schedule for the example task configuration with Shortest Job First scheduling

**Shortest Remaining Time First (SRTF)** is the preemptive version of SJF. A newly arriving task preempts the currently running task if the newcomer has a shorter remaining run time. SRTF has been proven to be the optimal preemptive scheduling policy.
![[Pasted image 20261025111800.png]]
Figure 5.6: Schedule for the example task configuration with Shortest Remaining Time First scheduling

> [!warning] **Starvation in SJF/SRTF**
> Both SJF and SRTF can cause **starvation**: a long-running task may never execute because shorter tasks keep arriving and taking precedence. The long task's remaining time is always greater than that of the newer arrivals.

### 5.7.5 Shortest elapsed time first (SETF)

Since SJF and SRTF require knowledge of future execution times (clairvoyance), a more practical alternative is **Shortest Elapsed Time First (SETF)**, which uses the _elapsed_ run time of a process — a value the OS can easily measure.
![[Pasted image 20261025111816.png]]
Figure 5.7: Schedule for the example task configuration with Shortest Elapsed Time First scheduling

SETF has been shown to achieve good average-case response times and, importantly, does **not** starve any job. This makes it a practical improvement over SJF/SRTF while retaining many of their benefits.

### 5.7.6 Priority scheduling

**Priority scheduling** uses an explicit priority attribute that is entirely separate from other task characteristics (unlike SJF, where priority is derived from execution time). The priority can be set independently and changed as needed.
![[Pasted image 20261025111838.png]]
Figure 5.8: Schedule for the example task configuration with non-preemptive Priority scheduling
![[Pasted image 20261025111846.png]]
Figure 5.9: Schedule for the example task configuration with preemptive Priority scheduling.

> [!warning] **Starvation and Aging**
> Any priority-based policy risks starving low-priority processes if higher-priority processes are always present. To prevent this, the scheduler can use **aging** — gradually increasing a task's priority the longer it waits in the ready queue. This ensures that even low-priority tasks eventually accumulate enough priority to execute.

### 5.7.7 Real-time scheduling

Real-time applications must process data within well-defined time constraints. From a scheduling perspective, correctness depends not just on the result but on delivering the result _within a deadline_. Missing a deadline constitutes incorrect behavior.

Two categories of real-time systems exist:

> [!info] **Soft Real-Time Systems**
> Provide no absolute guarantee about when a critical process will be scheduled, but ensure that critical processes receive higher priority. Missing a deadline degrades quality but is not fatal. Typical examples include video and audio streaming — a missed frame causes a glitch but not a system failure.

> [!info] **Hard Real-Time Systems**
> Require that every task be serviced by its deadline. The scheduler must be able to _guarantee_ this. Missing a deadline can cause catastrophic failure. Examples include airplane flight controls and other safety-critical systems.

Linux supports both types: soft real-time scheduling uses Round-Robin or FIFO policies, while hard real-time scheduling uses the Earliest Deadline First algorithm.

### 5.7.8 Earliest deadline first (EDF)

**Earliest Deadline First (EDF)** is a dynamic priority-driven scheduling algorithm designed for **periodic tasks** — tasks that generate work (called **jobs**) at regular intervals. The period and deadline for each task's jobs must be known in advance.

The job queue is ordered by deadline: the job with the earliest deadline is scheduled first. To compute deadlines, the scheduler must know each task's period, the phase differences between periods, and the execution time and deadline for each job. Typically, the deadline equals the period — each job must finish within one period.

Each periodic task can be described by a tuple:

$$(\text{phase},\ \text{period},\ \text{execution time})$$

> [!example] **EDF Schedule for Two Periodic Tasks**
> Consider two tasks, both starting at time $t = 0$ (phase = 0):
> - $T_1 = (0,\ 2,\ 1)$ — period of 2, execution time of 1
> - $T_2 = (0,\ 5,\ 2.5)$ — period of 5, execution time of 2.5
>
> Both tasks are active 50% of the time, so together they use 100% of the CPU. Since the tasks are periodic, it suffices to compute a schedule for the least common multiple of the periods: $\text{lcm}(2, 5) = 10$.
>
> | Time | Ready Jobs (with deadlines) | Scheduled |
> |---|---|---|
> | 0 | $J_{1,1}[2],\ J_{2,1}[5]$ | $J_{1,1}$ |
> | 1 | $J_{2,1}[5]$ | $J_{2,1}$ |
> | 2 | $J_{1,2}[4],\ J_{2,1}[5]$ | $J_{1,2}$ |
> | 3 | $J_{2,1}[5]$ | $J_{2,1}$ |
> | 4 | $J_{2,1}[5],\ J_{1,3}[6]$ | $J_{2,1}$ |
> | 4.5 | $J_{1,3}[6]$ | $J_{1,3}$ |
> | 5 | $J_{1,3}[6],\ J_{2,2}[10]$ | $J_{1,3}$ |
> | 5.5 | $J_{2,2}[10]$ | $J_{2,2}$ |
> | 6 | $J_{1,4}[8],\ J_{2,2}[10]$ | $J_{1,4}$ |
> | 7 | $J_{2,2}[10]$ | $J_{2,2}$ |
> | 8 | $J_{1,5}[10],\ J_{2,2}[10]$ | $J_{1,5}$ |
> | 9 | $J_{2,2}[10]$ | $J_{2,2}$ |
>
> **Breakdown of notation:**
> - **$J_{i,j}$** — The $j$-th job of task $T_i$. For example, $J_{1,2}$ is the second job of task $T_1$.
> - **$[d]$** — The absolute deadline of that job. For example, $J_{1,1}[2]$ means the first job of $T_1$ must complete by time 2.
> - **Phase** — The time offset at which the task first becomes active (0 for both tasks here).
> - **Period** — The interval between successive job releases.
> - **Execution time** — The CPU time required to complete one job.

> [!summary] **EDF Optimality Guarantee**
> EDF guarantees that all deadlines are met **provided that the total CPU utilization does not exceed 100%**. In other words, if the sum of each task's utilization ($\frac{\text{execution time}}{\text{period}}$) is $\leq 1$, a valid schedule always exists. For the example above: $\frac{1}{2} + \frac{2.5}{5} = 0.5 + 0.5 = 1.0$ (exactly 100%), and all deadlines are met.