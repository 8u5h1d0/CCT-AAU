---
tags:
  - "#AgS"
  - "#CCT2"
Topic: Kravspecifikation
Semester: CCT2
Course: Agil systemudvikling
Litterature:
  - SSU kompendie
Created: 10/02/2026
---
- - -
# Requirements and accept specifications
Requirements are important as they form the basic contract between the developers and the customers.

If a product does not live up to the expected functionality and performance, then we as developers are in trouble. On the other hand, if we can show, that our product fully lives up to the set requirements, then we are in a good position to get our money from the customer, even if they believe the product is not what they wanted.

Several cases has been seen in the public in Denmark on cases, where requirements plays a huge role in reducing cost of a product ordered, law suits and so forth.
## The purpose of a good requirement specification
A set of requirements are derived from analysis of the users needs for the communication, e.g. A teacher must be able to make files available to students.

This seems like a fair and simple requirement to implement, but consider then, the solution fails to address another requirement of scalability, that is, when all students tries to access the files, the system fails to deliver service and students sits with a non-responsive server. Who failed here? The company for not delivering (while the requirements stated that files must be shared, but not by how many at one time) or the school who failed to realize this additional requirement?

Good requirements are hard to write, and takes a long time, because often there are more behind requirements than the eye can see initially. 
Writing requirements is also a process which involves more than one person. It requires potentially very different knowledge from various domains to ensure completeness
## Characterization of a good requirement specification
The key challenges when writing the specifications are summarized here:
1. Correctness
2. Ambiguity
3. Completeness
4. Consistency
5. Priority (and structure)
6. Verifications
7. Changeability
8. Tractability
### Correctness
Correctness is roughly defined as the quality or state of being free from error and in accordance to the truth. 
For requirements this values is extremely important.
If a requirement does not capture what we truly need, then the requirement is not worth anything.

How do we ensure a requirement is correct?
Since a requirement is based in something we want or need, we can always back track a requirement to a source.

#### Example
1. Sensor needs to sample current with 10Hz
2. Sensor needs to sample current and voltage with 20 Hz

Clearly the two requirements, are measurable and implementable, but how do we know if it is correct. Why not 50 Hz or 1 Hz sample frequency? To determine this, we would need to go to our use case and perform an analysis to see what frequencies we would potentially need to capture in our samples and then rely on Nyquist sampling theorem, that sampling frequency needs to be at least two times larger than the highest frequency we want to measure. So in this particular case, the question of correctness, can be tracked back to what maximum frequency do we want to sample, and that can be lead back to what is it we want to measure?

To the extreme, we end up back in the use cases, asking ourselves, what do we want for the system to do.
### Ambiguity
Ambiguity is roughly defined as the quality of being open to more than one interpretation.
This is clearly dangerous for requirements, as two sides has to agree on what a system shall do and do not do.

How do we avoid requirements to be ambiguous?
If both parties can agree on the high level use case, a given requirement can be tracked back to, then there is a good chance that the ambiguity can be cleared out.

#### Example
1. Sensor needs to sample current fast
2. Sensor needs to sample current and voltage highly accurate

oth cases are open for interpretation. What does fast sampling of current mean? What does high accuracy mean? To answer these questions, we one more time have to go back to the use cases. The words fast and highly accurate, are used in a context not known from the two requirements. Fast could under some circumstances as example previous subsection be 10 Hz or 20 Hz, but is that fast? It depends on who works with the requirements. So let us agree, that using these kinds of words is a bad idea. If at time of writing we simply do not know the values of requirement, then we can always write TBD (or perhaps order of magnitude so and so). But marking these TBD’s as to be followed up as it is unacceptable that these remains TBD’s.
### Completeness
A requirement list must be complete in order to be sure that we capture all the important characteristics of the system we wish to include.

But how do we ensure that we have all requirements? How can we be sure that we did not miss an important requirement? After all, requirements are just text and it is easy to miss out something.

This is where use cases comes in.

They may to some degree work as a "cheat sheet" in some way. The way it works is that due to its simplicity, we may assume that there are no fault in the use case description we work with. Maybe some details are not present, but at least use cases should be complete.
With that assumption in mind, we may ask ourselves if each step in the use case can be executed by a system that implements the requirements we have defined.

It is much cheaper in terms of resources (time and/or salary) to go through systematically some text and fix changes than it is later to change code and/or hardware to fit a missing requirement as changes may force changes and updates to other modules and subsystems.

| Use case | Requirement | Note |
| :--- | :--- | :--- |
| Start engine | §1, §2, §3 | Not done yet |
| Stop engine | §1, §2, §4 | §4 done, rest to be done |
| Brake car | §4, §5 | Done, not tested |
| Speed car | §1, §6 | Done, not tested |
| Change gear | §7 | Done and tested |
*Table 4.1:*

It is harder if e.g. we forget requirements coming from e.g. existing legislation or physical environment, but this just another argument why requirements should not be developed by the engineers alone. Requirements should be developed in collaboration with other relevant actors. Such table does not necessarily need to go into a report, but may be useful in the working process of the development team to track progress.
## Challenges in deriving requirements
Requirements has to undergo a certain level of quality checks and iterations in order to be fully understandable for both parties.

This process flow also illustrates why it is often needed to iterate on requirements even after implementation process has started: One simple learns a lot during implementation that was not visible before starting the implementation. This is quite often the case, and is quite natural.

![[Pasted image 20260211145510.png]]
Figure 4.1: Overview of the various traps one can end up in when deriving requirements

A specifically written requirement can take its start in either of the shown states, and in initially, typically it is incomplete. The reason is that when we start with a development proces, we simply don’t know too much on what we really need.

Trying to remedy this situation, we may try to add explanations and text, but that often leads requirements to become not understandable. That we would try to remedy by elaboration and adding more explanations, leading us to possibility for redundant requirements. Having redundant requirements is bad, because we may not follow up on all, and that would eventually lead to lawyers being happy for suing us as developers because we missed this and that, or even worse, some redundant requirements counter each other leading to impossible requirements. We may then try to reduce requirements, but that could potentially lead us back to incomplete requirements or we could try to condense the requirements. The latter can easily bring us to ambiguous requirements. Trying to expand ambiguous requirements may also just lead to trouble as we either end up again with redundant requirements or inconsistent requirements. The latter is really bad, as it will confuse both developers and customers. A formalization of requirements could help, but can also easily make the requirement not understandable, which is bad too. All in all, this process may repeat itself many times, and does require certain level of experience. An e↵ective way to break this process loop, is to work and express the tests needed to be carried out for each requirements as they are written. The reason why this works, is that it forces developers to consider how they in practice would ensure a requirement is fulfilled. Doing that, forces as well to consider the use case of that requirement, in essence.
## Documenting requirements
There are no strict way to format requirements in a report, simply because there are so many di↵erent way to work and document. Each entity have their own way, but still there are some general aspects and approaches that may be adapted to the given context.

Some examples are better than other, but reflects some di↵erent approaches.
#### Listing requirements
Consider the use case which details the steps for a car computer.

This case will be the reference from the following requirements, in a real report these should ideally be pointing to places in the report where target numbers are discussed, argued for, calculated or in other way derived from, e.g. standards.
A good idea is to also give a requirement a short saying name.

§1 Finger pressed detection: The system must be able to determine that the finger has actually been pressed for activation.
§1.1 The system shall reject fingers that touches the screen in t < 50ms, see discussion in a relevant section. 
§1.2 The system shall reject if more than one finger is detected on the touch screen, see discussion in a relevant section.

§2 Read finger prints: The system must be able to read finger prints from a single user.
§2.1 The system must obtain a digital version of the finger print within 1 ms in 95% of all observed cases and less than 3s for 100% of all cases. Reference to discussion of target numbers in a relevant section. 
§2.2 The system shall give an acoustic and visual alarm if §1.2 is not met.

§3 User authentication: The system must be able to determine if a user (via fingerprints) is allowed to start the engine or not
§3.1 The system shall be able to determine if a user has right to start the engine within 1 second in 99% of observed cases, and less than 5 second in 100% of cases. 
§3.2 The system shall give an acoustic and visual warning if user is not recognized, see details in a relevant section.

Tables may also be used to express the requirements.

The use of § is of course also not strictly needed, but is here used to emphasize the importance of requirements, as these should be considered as the rules of engagement in context of the project development process.
#### Scope of requirements at this level
It is important to realize the scope of the requirements at this level is focused on the use of the system and not for example performance of individual elements that we may easily identify as components or modules even before we start the design. This is a very classical trap to fall into and should be avoided as we may in principle trap ourselves. For example, the resolution of finger print image is not included here in the requirements. This is because we, at this stage, should be independent of the higher level requirements. If we can meet these set requirements with a 100x100 pixel resolution, then this is better than having to use a 1000x1000 pixels, assuming the latter one is more expensive. That is, the resolution is not directly related to the use of the system, but is more related to a design choice for some module that we will work with later on. Of course, the higher resolution version could also be selected due to future considerations, but here the point is that we are free from the requirements. 73 Notice that listing the requirements in this way, we may easily refer back to requirements, such that a decision in a design chapter may be referred directly back to e.g. to §1.1 or others. From there we may further redirect to the actual source of the requirements which ensures trackability. This is important as decisions at even code or hardware level usual goes back through a chain of requirements to a case that typically will reveal the underlying need and freedom to select components or parameters
#### Grouping of requirements
The list of requirements may also be divided into di↵erent types of requirements (in the above they are listed in one larger group). But one may group in subsections according to requirement type

- Functional requirements: §1, §2, .. 
- Performance requirements: §1.1, §2.1, .. 
- Legal requirements 
- Environmental requirements 
- ...

depending on style and context of the project.

Other ways to group requirements is according to needs, e.g. the Must-haves, Should-have, Could-have and Will-not-have (MosCoW) scale (sometimes the W is replaced by Wish-to-have). Groupings of requirements can then be divided into the following subsections

- Must-haves: §1, §2, §3 ...
- Should-haves: ... 
- Could-have: ... 
- Will-not-have/wish-to-have: ...
### 4.4.1 Acceptance test
Discussions around where to put acceptance tests can always show di↵erent opinions, but according to the V-model, this type of test it makes sense to have acceptance test specification close to the requirements e.g. in a subsequent section. 
Some, however, prefer to have this part towards the end of the report to closely follow the development process where these tests are carried out at the end of the project period.

If we put it near the requirements, it is typically useful to keep descriptions short, and keep the actual test specifications and results in appendices for readability.

| ID | Requirement | Test description (short) | Success criteria | Reference |
| :--- | :--- | :--- | :--- | :--- |
| §1 | Finger pressed detection | User presses finger on the touch screen | System accepts finger press | A1.S1 |
| §1.1 | Finger pressed detection | Finger stub is mechanically moved on/off the touch screen at various speeds | Timings req. met | A1.S2 |
| §1.2 | Finger pressed detection | Two or more fingers are put on the touch screen | System rejects press | A1.S3 |
| §2 | Read finger prints | Finger is pressed on the touch screen | System indicates success of reading finger print | A2.S1 |
| §2.1 | Read finger prints | Fingers are repeatedly pressed on the touch pad. | System indicates successful read according to req. statistics | A2.S2 |
| §2.2 | Read finger prints | A glove is used instead of a finger, or a fault is forced to the system | Visual and audio alarm is observed | A2.S3 |
| §3 | User authentication | An authorized and unauthorized person is touching the touch screen | The system correctly authorizes the authorized person, and warns if not authorized | A3.S1 |
| §3.1 | User authentication | Authorized person tries to start the engine | Engine start successfully | A3.S2 |
| §3.2 | User authentication | Unauthorized person tries to start the engine | Visual and acoustic alarms are activated | A3.S3 |

*Table 4.2: Example of short overview table for requirements and acceptance tests.*

A table gives a good overview of how requirements will be tested and where to find details about the test. It should be noticed that each test will require a significant reporting.
therefore it is better to provide overview a this moment in time and save details for later. Otherwise the reader will quickly drown in details not needed at this stage.

As a minimum one should at least consider the key parameters that are being measured and by what defines the success criteria.