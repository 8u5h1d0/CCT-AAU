---
tags:
  - "#AgS"
  - "#CCT2"
Topic: User Scenarios | Personas | Prototyper
Semester: CCT2
Course: Agil systemudvikling
Litterature:
  - interaction-design - User Scenarios
  - interaction-design - Personas
  - interaction-design - What is a Prototype?
Created: 18-02-2026
---
# Table of Contents

1. [[#User Scenarios, Personas, and Prototypes|User Scenarios, Personas, and Prototypes]]
	1. [[#User Scenarios, Personas, and Prototypes#User Scenarios|User Scenarios]]
		1. [[#User Scenarios#Types of Scenarios|Types of Scenarios]]
		2. [[#User Scenarios#Scenarios, Personas, and Roles|Scenarios, Personas, and Roles]]
		3. [[#User Scenarios#Creating User Scenarios|Creating User Scenarios]]
	2. [[#User Scenarios, Personas, and Prototypes#Personas|Personas]]
		1. [[#Personas#Personas in Design Thinking|Personas in Design Thinking]]
		2. [[#Personas#Four Perspectives of Personas|Four Perspectives of Personas]]
		3. [[#Personas#10 Steps to Creating Engaging Personas and Scenarios|10 Steps to Creating Engaging Personas and Scenarios]]
			1. [[#10 Steps to Creating Engaging Personas and Scenarios#Example: Step 5 - Describe the Personas|Example: Step 5 - Describe the Personas]]
	3. [[#User Scenarios, Personas, and Prototypes#Prototypes|Prototypes]]
		1. [[#Prototypes#Benefits of Prototyping|Benefits of Prototyping]]
		2. [[#Prototypes#Fidelity: Low, Mid, and High|Fidelity: Low, Mid, and High]]
			1. [[#Fidelity: Low, Mid, and High#Low-Fidelity Prototypes|Low-Fidelity Prototypes]]
			2. [[#Fidelity: Low, Mid, and High#Mid-Fidelity Prototypes|Mid-Fidelity Prototypes]]
			3. [[#Fidelity: Low, Mid, and High#High-Fidelity Prototypes|High-Fidelity Prototypes]]
		3. [[#Prototypes#The Prototyping Process|The Prototyping Process]]
		4. [[#Prototypes#Showcasing Prototypes in a Portfolio|Showcasing Prototypes in a Portfolio]]
		5. [[#Prototypes#Five Common Low-Fidelity Prototyping Methods|Five Common Low-Fidelity Prototyping Methods]]

# User Scenarios, Personas, and Prototypes

| Concept | Description | Key Application/Context |
| :--- | :--- | :--- |
| **User Scenario** | A detailed, realistic description of a user's situation to explain context and motivation. | Designing solutions by understanding practical needs and behaviors. |
| **Persona** | A fictional character created from research to represent a user type. | Guiding ideation and maintaining focus on user needs. |
| **Prototype** | An early experimental model of a product used to test concepts. | Gathering feedback, mitigating risk, and refining design before development. |
| **Fidelity** | The level of detail and functionality in a prototype (Low, Mid, High). | Selecting the appropriate stage of testing, from concept exploration to validation. |
| **Prescriptive Scenario** | Describes what *should* happen, often derived from use cases (e.g., "sunny day"). | Defining system responses and specific interaction paths. |
| **Evocative Scenario** | Provides motivation and back story to explain *how* and *why* users interact. | Promoting empathy and understanding of user context. |

_Table 1.1: Overview of core UX concepts, definitions, and their primary applications in the design process._

---

## User Scenarios

> [!info] User Scenarios
> _User scenarios_ are detailed descriptions of a user—typically a _persona_—that describe realistic situations relevant to the design of a solution. They paint a "rich picture" of events, allowing teams to appreciate user interactions in context.

### Types of Scenarios

Scenarios generally range from _prescriptive_ to _evocative_.

**Prescriptive Scenarios**
These describe what should happen, often derived from use cases. They focus on system events and outcomes rather than user needs.

> [!example] Sunny Day Scenario
> A typical prescriptive scenario is the _sunny day scenario_, where everything happens exactly as it should without error.
>
> Because these scenarios describe what users _should_ do as if they were programmed, they often lead to software systems that are not inherently easy to use.

![[Pasted image 20260218170233.png]]

**Evocative Scenarios**
In contrast, _user scenarios_ are generally evocative. They provide motivation and back stories to explain the context of interactions. This promotes empathy and a user-focused approach to technological solutions.

### Scenarios, Personas, and Roles

In software development, focusing solely on "roles" (e.g., admin, user) can be counter-productive because it lacks detail about the person fulfilling that role.

> [!abstract] Persona-Role Relationship
> _User research_ uncovers the nuances of a persona's relationship to their role:
> - Do they love it or hate it?
> - Is the role well-defined or vague?
> - What are the specific pain points?

In customer-facing systems, roles like `customer` or `passenger` are often too generic to guide design. Therefore, user-centered scenarios focus on **personas**, using the concept of _role_ only when specific responsibilities or access levels are relevant.

> [!info] When Roles Are Relevant
> Roles become significant when associated with specific functionality or access needs.
> - **Travel Context:** Distinguishing between a `customer` (who pays) and a `passenger` (who travels).
> - **Hospitality Context:** Ensuring cleaning staff do not have access to accounting systems.

### Creating User Scenarios

Scenarios allow teams to explore motivations, describe expected interactions (sequences, formats, information), and identify pain points.

When writing a scenario, you must describe the context including:
1.  The **persona** involved (and their role if relevant).
2.  The **events** leading up to the scenario.
3.  The **environment** (physical, social, legal, and organizational).

The scenario should be a story rich in detail, but without extraneous information.

> [!example] Relevant Detail
> Details like clothing are only relevant if they impact the physical environment. For example, mentioning that a persona is wearing shorts is relevant only if the scenario takes place in a refrigerated storeroom.

---

## Personas

> [!info] Personas
> _Personas_ are fictional characters created based on research to represent different user types that might use a service, product, site, or brand in a similar way. They are composite characters, not descriptions of real people.

Creating personas helps designers step out of their own perspectives and recognize that different people have different needs. They make the design task less complex and guide the ideation process.

### Personas in Design Thinking

In the Design Thinking process, personas are typically created during the `Define` phase (the second phase), synthesizing research from the `Empathise` phase. They act as guides for the subsequent `Ideation` phase.

![[Pasted image 20260218173847.png]]
_Figure 2.1: The five stages of the Design Thinking process

### Four Perspectives of Personas

Lene Nielsen describes four perspectives to ensure personas add value to a design project.

**1. Goal-directed Personas**
Based on the work of Alan Cooper, this perspective focuses on what the user wants to do. It examines the process and workflow the user prefers to achieve their goals.

> [!example] Goal-directed Example
> A persona named "Efficient Eric" wants to check in for a flight as fast as possible. The design focuses on a "one-click" check-in button to satisfy his goal of minimizing time spent.

![[Pasted image 20260218172639.png]]
_Figure 2.2: Visualization of a goal-directed persona
**2. Role-Based Personas**
This perspective is massively data-driven (qualitative and quantitative). It focuses on the user's role within an organization, examining where the product will be used, business objectives, and who is impacted by the role's duties.

> [!example] Role-Based Example
> A persona is "Shift Manager Sarah." The design focuses on features that allow her to approve time sheets and view staff schedules, fulfilling the specific responsibilities of her role within the company.

**3. Engaging Personas**
> [!abstract] Engaging Perspective
> “The engaging perspective is rooted in the ability of stories to produce involvement and insight... The purpose is to move from designers seeing the user as a stereotype... to designers actively involving themselves in the lives of the personas.”
> — Lene Nielsen

Engaging personas create a 3D rendering of a user, including emotions, psychology, and background. They help designers identify with the user rather than viewing them as a stereotype.

> [!example] Engaging Example
> "Anxious Alex" is a persona who worries about making mistakes. The scenario describes him feeling sweaty and nervous when entering credit card details. This encourages designers to add reassuring messages and clear error formatting.

![[Pasted image 20260218172703.png]]
_Figure 2.3: An engaging persona profile, rich with personal details, psychology, and narrative to foster designer empathy._

**4. Fictional Personas**

> [!warning] Use with Caution
> Fictional personas do not emerge from user research but from the team's assumptions. They should not be trusted as a definitive guide. They are best used only as an initial sketch to allow early involvement in the design process.

> [!example] Fictional Example
> "Tech-savvy Teen" is a persona created because the team *assumes* all young people like apps with gamification and dark mode, without actually interviewing teenagers.

### 10 Steps to Creating Engaging Personas and Scenarios

The process for creating engaging personas is divided into four parts: Data collection/analysis, Persona descriptions, Scenarios, and Acceptance/involvement.
1.  **Collect data:** Perform high-quality user research (`Empathise` phase).
2.  **Form a hypothesis:** Use tools like `Affinity Diagrams` to form an idea of various users.
3.  **Everyone accepts the hypothesis:** Project participants confront and compare the hypothesis with existing knowledge.
4.  **Establish a number:** Decide how many personas to create; select one as the primary focus.
5.  **Describe the personas:** Create 1–2 pages per persona including education, lifestyle, interests, values, goals, and fictional personal details. Give them a name.
6.  **Prepare situations or scenarios:** Describe specific situations triggering product use to give personas life.
7.  **Obtain acceptance from the organization:** Involve team members to gain buy-in.
8.  **Disseminate knowledge:** Share descriptions and underlying data with everyone, including future employees.
9.  **Everyone prepares scenarios:** Scenarios are where personas gain real value.
10. **Make ongoing adjustments:** Revise descriptions regularly as new information arises.

![[Pasted image 20260218173208.png]]
_Figure 2.5: A diagram illustrating the 10-step process for creating engaging personas.

> [!summary] Scenario Value
> Personas have no value in themselves. Until the persona becomes part of a scenario—the story about how the persona uses a future product—it does not have real value.

#### Example: Step 5 - Describe the Personas

> [!example] Persona Description: "Christie"
> The following example illustrates how to flesh out a persona to make them a realistic character.
>
> **Hard Facts:** 23-year-old student in Toronto, single, studies ethnography, works as a waiter.
> **Interests and Values:** Loves traveling and other cultures (volunteered in Rwanda). Prefers quiet coffee shops over bars. Prioritizes values over fashion. Drinks tea, cooks healthy/organic food.
> **Tech Use:** Owns MacBook Air, iPad, iPhone. Uses internet for research and reviews. Streams music/movies; owns no TV (views it as outdated).
> **A Typical Day:**
> *   7:00 am: Wakes up/breakfast.
> *   8:15 am: Heads to university.
> *   Daytime: 15 hours classes, 20 hours self-study. Lunch with friends.
> *   3:00 pm: Heads home/studies.
> *   6:00 pm - 10:00 pm: Waitress at eco-restaurant (3 nights/week).
> **Future Goals:** Wants to combine work and travel in a third-world country to help others. Unsure about marriage/children.

---

## Prototypes

> [!info] Prototyping
> _Prototyping_ is the experimental process of making early models of a product (prototypes) to simulate design and functionality. Teams build prototypes of varying degrees of fidelity to test concepts and gather feedback.

> [!tip] Value of Prototyping
> "They slow us down to speed us up. By taking the time to prototype our ideas, we avoid costly mistakes such as becoming too complex too early and sticking with a weak idea for too long."
> — Tim Brown, CEO & President of IDEO

Prototyping is the fourth phase of Design Thinking, following Ideation and preceding Test. It acts as a strategic investment to validate ideas before full-scale development.

### Benefits of Prototyping

*   **Risk Mitigation:** Identifies flaws early, preventing costly fixes later.
*   **Enhanced Communication:** Serves as a universal language between designers, developers, and stakeholders.
*   **Cost-Effectiveness:** Modifying a prototype is cheaper than reworking a finished product.
*   **Accelerated Innovation:** Rapid experimentation allows for quick testing and refining of ideas.
*   **Stakeholder Buy-In:** Tangible models build trust and excitement.
*   **User-Centered Design:** Ensures the final product aligns with actual user needs and preferences.
*   **Reduced Time-to-Market:** Streamlining the design process leads to faster launches.

![[Pasted image 20260218173749.png]]
_Figure 3.1: A diagram illustrating the 1-10-100 Rule.

### Fidelity: Low, Mid, and High

Fidelity refers to the level of detail and functionality. Prototypes also vary in **scope**:
*   **Horizontal Prototype:** Wide view of the entire system (e.g., full site map).
*   **Vertical Prototype:** Detailed view of one feature (e.g., checkout process).

> [!info] Prototype Scope
> *   **Horizontal:** Wide view of the entire system.
> *   **Vertical:** Detailed view of just one feature.

> [!example] Horizontal vs Vertical
> **Horizontal:** A clickable mockup of every page on a banking site (Home, Accounts, Transfer, Settings) to show the full scope, even if the "Transfer" button doesn't actually move money.
> **Vertical:** A fully functional, coded "Transfer Money" feature that connects to a real database, but no other pages of the app exist yet.

#### Low-Fidelity Prototypes
*   **Characteristics:** Basic, hand-drawn, focus on core concept and flow.
*   **Examples:** Sketches, paper prototypes, wireframes.
*   **Pros:** Fast, cheap, disposable, encourage design thinking.
*   **Cons:** Lack of realism, requires imagination to use.
*   **Best for:** Early concept exploration and brainstorming.

> [!example] Low-Fidelity Concept
> A designer sketches a login screen on a napkin using a pen. The rectangles represent the username and password fields, and a circle represents the "Submit" button. It is not interactive but conveys the layout idea.

#### Mid-Fidelity Prototypes
*   **Characteristics:** Bridge the gap; more interactive with some visual elements.
*   **Examples:** Clickable wireframes, interactive mockups.
*   **Pros:** More realistic than low-fi, allows testing of basic interactions.
*   **Cons:** Can be time-consuming compared to low-fi; lacks full polish.
*   **Best for:** Testing specific features and refining flows.

> [!example] Mid-Fidelity Concept
> A grayscale digital wireframe created in Balsamiq. The boxes are aligned, and the user can click the "Submit" button to navigate to the next screen, but the buttons have no color or hover effects.

#### High-Fidelity Prototypes
*   **Characteristics:** Closely resemble the final product with detailed visuals and interactions.
*   **Examples:** Digital prototypes, realistic data, fully functional UI.
*   **Pros:** Engaging, accurate testing results, predicts market reception.
*   **Cons:** Costly to create, designers may resist changes, users may focus on superficial details.
*   **Best for:** Usability testing, evaluating the overall user experience, gathering detailed feedback on the final design, and demonstrating the product to stakeholders.

> [!example] High-Fidelity Concept
> A fully interactive prototype created in Figma. It uses the final brand colors, fonts, and animations. When the user clicks "Submit," it shows a loading spinner and then a success message, mimicking the final app exactly.

> [!warning] Prototype Bias
> Users may mistake a high-fidelity prototype for the finished product, leading to biased feedback based on the assumption that the design is final.

### The Prototyping Process

Prototyping connects with other Design Thinking stages (Empathize, Define, Ideate, Test) to form a dynamic, non-linear framework.

**The Roadmap:**
1.  **Define goals:** Articulate the purpose and questions to answer.
2.  **Choose fidelity:** Select low, mid, or high fidelity based on project stage.
3.  **Create:** Build the prototype using chosen tools.
4.  **Test & Gather Feedback:** Share with users and ask open-ended questions.
5.  **Iterate & Refine:** Make changes and repeat the cycle.
6.  **Document & Share:** Record decisions and maintain transparency.
7.  **Validate:** Conduct final user testing to ensure needs are met.
8.  **Implement:** Move to final product development.

### Showcasing Prototypes in a Portfolio

To effectively showcase prototypes:
1.  **Choose the best work:** Highlight problem-solving skills.
2.  **Provide context:** Explain the problem and goals.
3.  **Use variety:** Show sketches, wireframes, and mockups.
4.  **Interactive prototypes:** Allow viewers to click through the flow.
5.  **User testing results:** Demonstrate how feedback improved the design.
6.  **Link to live projects:** Show real-world impact.

### Five Common Low-Fidelity Prototyping Methods

1.  **Sketches:** Powerful for early, divergent decision-making. Easy to create and discard.
2.  **Paper Prototypes:** Rough "animations" using sliding paper. Inexpensive and great for testing novel solutions, though less helpful for standard UI patterns.
3.  **Lego Prototypes:** Quick physical prototypes for tangible products; good for experimenting with form.
4.  **Digital Wireframes:** Bare-bones illustrations focusing on structure and layout, not visuals.
5.  **Wizard of Oz Prototypes:** A team member manually controls responses ("the wizard") to simulate complex functionality without building it. Useful for voice interfaces or AI.

---

> [!summary] Summary
> **User Scenarios**, **Personas**, and **Prototypes** are fundamental tools in user-centered design. **User Scenarios** provide evocative stories that give context to user interactions, moving beyond prescriptive system events to foster empathy. **Personas** are research-based fictional characters that embody user needs and behaviors; they are critical during the Define phase of Design Thinking and come in various perspectives (Goal-directed, Role-based, Engaging, Fictional). **Prototypes** are experimental models ranging from low-fidelity sketches to high-fidelity digital simulations. They allow teams to test ideas, mitigate risks, and gather feedback early in the process. Together, these tools ensure that design solutions are grounded in real user needs and are iteratively refined before final development.