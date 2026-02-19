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
- - -
# What are User Scenarios?
## Intro

> [!info] User Scenarios
> _User scenarios_ are detailed descriptions of a user—typically a _persona_—that describe realistic situations relevant to the design of a solution.

By painting a "rich picture" of a set of events, teams can appreciate user interactions in context, helping them to understand the practical needs and behaviors of users.

## Multiple Uses of Scenarios

The term and general concept of scenarios has many uses, ranging from _prescriptive_ to _evocative_.

> [!info] Prescriptive Scenarios
> _Prescriptive scenarios_ describe what should happen but do not necessarily reflect consideration for user needs and behaviors. They are often derived from use cases, which describe how a system responds to events and all possible outcomes (now often supplanted by user stories). In this context, a "scenario" describes just one path—one set of outcomes—through the use case.

> [!example] Sunny Day Scenario
> A typical example of a prescriptive scenario is the _sunny day scenario_, where everything happens as it should.
>
> Because prescriptive scenarios describe what users _should_ do as if they were programmed system components, they are a reason why many software systems are not inherently easy to use.

![[Pasted image 20260218170233.png]]

_User scenarios_, however, are generally _evocative_, meaning that they provide _motivation_ and back stories to explain the context of how and why users need to interact with solutions, rather than simply dictating system events. This approach is intended to promote _empathy_ and understanding, as well as a user focus in technological solutions.

## Scenarios, Personas and Roles

In software development, scenarios are typically focused on actors who assume one or more roles within the system. This approach is counter-productive from a _user-centered design_ perspective because it lacks a detailed understanding of the roles themselves or how the activities described in prescriptive scenarios are actually performed.

While _personas_ can take on one or more roles within a system, _user research_ provides a wealth of information about that persona's specific relationship to the role.

> [!abstract] Persona-Role Relationship
> Research helps uncover the nuances of this relationship, answering questions such as:
> - Do they love it or hate it?
> - Is the role well-defined or vague?
> - What are the pain points?

Particularly in customer-facing systems, roles themselves are often not very meaningful. For example, in e-commerce the role is `customer`, in travel it is `passenger` or `customer`, and in general solutions it may simply be `user`. These generic roles tell us almost nothing about how to design the solution.

Therefore, the focus in user-centered scenarios is on _personas_, with the concept of _role_ being used only when relevant.

> [!info] When Roles Are Relevant
> Roles become significant when they are associated with specific responsibilities, functionality, or access needs, though these relationships are not always hierarchical.
> - **Travel Context:** It is important to distinguish if the user is the `customer`, the `passenger`, or both.
> - **Hospitality Context:** Cleaning and maintenance roles would not have access to accounting information (and vice versa).

## Creating User Scenarios

User scenarios have a number of benefits and applications in user-centered and user experience design. They allow teams to:

> [!info] Benefits and Applications
> - Explore and explain _motivations_ for certain user needs and behaviors.
> - Explicitly describe how our persona expects interactions to proceed, including expectations about the sequence of events, the formats of input and output, and details of the information required.
> - Draw attention to _pain points_ in an existing process or anticipated complexity in new processes.

For each scenario, it is necessary to describe not only the persona’s goal, but also the context in terms of the following elements:

> [!info] Context Components
> - The _persona_ involved and their role (if relevant).
> - The events leading up to the scenario, particularly those that created the need for this scenario to be realized.
> - The _environment_ in which the scenario is performed. Note that this includes not only the physical environment, but also the social, legal, and organizational environments.

When writing the scenario, it should be crafted as a story that is rich in detail. However, it is important to be careful not to include extraneous information.

> [!example] Relevant Detail
> Details such as what the persona is wearing should only be included if they are relevant to an issue with the physical environment. For instance, wearing shorts would be a relevant detail to mention if the scenario takes place in a refrigerated storeroom.

# Personas
## Intro
> [!info] Personas
> _Personas_ are fictional characters created based on research to represent different user types that might use a service, product, site, or brand in a similar way.

Creating personas helps to understand users’ needs, experiences, behaviors, and goals. This process allows designers to step out of their own perspectives, recognize that different people have different needs and expectations, and identify with the specific user they are designing for. Personas make the design task less complex, guide ideation processes, and help achieve the goal of creating a good user experience for the target user group.

Within human-centered design disciplines, it has become standard practice to collate research and personify specific trends and patterns in the data as personas, rather than designing products based on the preferences of the design team. Therefore, personas do not describe real people; they are _composite characters_ composed based on actual data collected from multiple individuals. Personas add a human touch to what would otherwise remain cold facts. Creating profiles of typical or atypical (extreme) users helps to understand patterns in research and synthesizes the types of people being designed for. Personas are also known as _model characters_.

> [!tip] Assessing Design with Personas
> Personas provide meaningful archetypes to assess design development against. Constructing personas helps in asking the right questions that align with the users, such as:
> - "How would Peter, Joe, and Jessica experience, react, and behave in relation to feature X or change Y within the given context?"
> - "What do Peter, Joe, and Jessica think, feel, do, and say?"
> - "What are their underlying needs we are trying to fulfill?"
## Personas in Design Thinking
In the design thinking process, designers typically begin creating personas during the second phase, the `Define` phase. In this phase, Design Thinkers synthesize the research and findings gathered from the first phase, the `Empathise` phase. Using personas is a method that helps designers move forward to the third phase, the `Ideation` phase.

![[Pasted image 20260218173847.png]]

> [!info] Guiding Ideation Sessions
> Personas function as guides for various ideation sessions. Specific sessions that rely on these personas include Brainstorm, Worst Possible Idea, and SCAMPER.
Lene Nielsen describes four perspectives that personas can take to ensure they add the most value to a design project. These perspectives help structure the creation and application of personas in different contexts.

### 1. Goal-directed Personas

This perspective cuts straight to the core of the user's needs by focusing on what the typical user wants to do with the product. The objective is to examine the process and workflow that the user would prefer to utilize to achieve their goals when interacting with the product or service. This approach assumes that sufficient user research has already been conducted to recognize that the product has value to the user. By examining these goals, designers can bring specific requirements to life. This perspective is based on the work of Alan Cooper.

![[Pasted image 20260218172639.png]]

### 2. Role-Based Personas

The role-based perspective is also goal-directed and focuses on behavior, but it is distinct in that it is massively data-driven, incorporating data from both qualitative and quantitative sources. This perspective specifically focuses on the user's role within an organization. Designing with this perspective involves examining
 the roles users play in their real lives to inform better product design decisions. Key considerations include where the product will be used, the role's purpose, the business objectives required of the role, who else is impacted by the role's duties, and what functions the role serves.

### 3. Engaging Personas

> [!abstract] Engaging Perspective
> “The engaging perspective is rooted in the ability of stories to produce involvement and insight. Through an understanding of characters and stories, it is possible to create a vivid and realistic description of fictitious people. The purpose of the engaging perspective is to move from designers seeing the user as a stereotype with whom they are unable to identify and whose life they cannot envision, to designers actively involving themselves in the lives of the personas. The other persona perspectives are criticized for causing a risk of stereotypical descriptions by not looking at the whole person, but instead focusing only on behavior.”  
> – Lene Nielsen

Engaging personas can incorporate both goal-directed and role-directed personas, as well as traditional rounded personas. They are designed to help designers become more engaged with the subject. The idea is to create a 3D rendering of a user, examining their emotions, psychology, and backgrounds, and making them relevant to the task at hand. The perspective emphasizes how stories can engage and bring personas to life. A significant challenge in the persona method is getting participants to use it effectively; Nielsen addresses this with a 10-step process for creating engaging personas.

![[Pasted image 20260218172703.png]]

### 4. Fictional Personas

> [!warning] Use with Caution
> Fictional personas should not be trusted as a definitive guide for the development of products or services.

Unlike the other types, the fictional persona does not emerge from user research. Instead, it emerges from the experience of the UX design team. It requires the team to make assumptions based on past interactions with the user base and products to deliver a picture of what typical users might look like. While these personas can be deeply flawed, they may be used as an initial sketch of user needs to allow for early involvement in the UX design process.

## 10 steps to Creating Your Engaging Personas and Scenarios
Engaging personas emphasize how stories can engage and bring personas to life. This 10-step process covers the entire workflow from preliminary data collection through active use to continued development. The process is divided into four main parts:

*   **Data collection** and **analysis of data** (steps 1, 2)
*   Persona **descriptions** (steps 4, 5)
*   **Scenarios** for problem analysis and idea development (steps 6, 9)
*   **Acceptance** from the organization and **involvement** of the design team (steps 3, 7, 8, 10)

The following 10 steps outline the process for creating engaging personas and scenarios.

1.  **Collect data.** Collect as much knowledge about the users as possible. Perform high-quality user research of actual users in your target user group. In Design Thinking, this research corresponds to the first phase, known as the `Empathise` phase.

2.  **Form a hypothesis.** Based on initial research, form a general idea of the various users within the project's focus area, including how they differ from one another. Tools such as `Affinity Diagrams` and `Empathy Maps` can be useful here.

3.  **Everyone accepts the hypothesis.** The goal is to support or reject the initial hypothesis about the differences between users. This is done by confronting project participants with the hypothesis and comparing it to existing knowledge.

4.  **Establish a number.** Decide on the final number of personas that makes sense to create. While you typically want to create more than one persona for each product or service, you should always choose just one persona as your primary focus.

5.  **Describe the personas.** The purpose of working with personas is to develop solutions, products, and services based on the needs and goals of your users. Ensure descriptions express enough understanding and empathy.
    *   Include details about the user’s education, lifestyle, interests, values, goals, needs, limitations, desires, attitudes, and patterns of behavior.
    *   Add a few **fictional personal details** to make the persona a realistic character.
    *   Give each persona a **name**.
    *   Create 1–2 pages of descriptions for each persona.

6.  **Prepare situations or scenarios for your personas.** This method is directed at creating scenarios that describe solutions. Describe specific situations that could trigger the use of the product or service you are designing. Situations are the basis of a scenario; you can give personas life by creating scenarios that feature them as users. Scenarios typically start by placing the persona in a specific context with a problem they want to or have to solve.

7.  **Obtain acceptance from the organization.** Involving project participants is a consistent goal throughout the process. As many team members as possible should participate in the development of the personas. To obtain acceptance and recognition, you can either ask participants for their opinions or let them participate actively in the process.

8.  **Disseminate knowledge.** To ensure the method is used, persona descriptions should be disseminated to everyone. Decide early on how to share this knowledge with those who did not participate directly, future new employees, and possible external partners. Dissemination also includes providing access to the underlying data.

9.  **Everyone prepares scenarios.**
> [!summary] Scenario Value
   > Personas have no value in themselves. Until the persona becomes part of a scenario – the story about how the persona uses a future product – it does not have real value.

10. **Make ongoing adjustments.** The final step concerns the future life of the persona descriptions. Revise the descriptions regularly. New information and aspects may affect the descriptions, requiring you to rewrite existing personas, add new ones, or eliminate outdated ones.

![[Pasted image 20260218173208.png]]

This section provides a concrete example of how to execute **Step 5: Describe the personas** within the 10-step process. It details the necessary components to create a realistic and engaging character.

> [!example] Persona Description: "Christie"
> The following description illustrates Step 5 by detailing the hard facts, interests, behaviors, and goals of a fictional character.
>
> ### Hard Facts
> Christie is a 23-year-old student living in a small apartment in Toronto, Canada. She is single, studies ethnography, and works as a waiter during her free time.
>
> ### Interests and Values
> Christie loves traveling and experiencing other cultures, recently spending a summer volunteering in Rwanda. She prefers reading books at home or visiting quiet coffee shops with a small group of friends over going out to bars. She prioritizes values and motivations over fashion and looks. On an average day, she drinks many cups of tea and cooks her own healthy dishes, preferring organic food when she can afford it.
>
> ### Computer, Internet and TV Use
> Christie owns a MacBook Air, an iPad, and an iPhone. She uses the internet for the majority of her preliminary research and studies user reviews to decide which books to buy. She streams all her music and movies online, choosing not to own a TV. She views televisions as outdated and prefers to select her own content rather than watching pre-selected shows, entertainment, documentaries, or news.
>
> ### A Typical Day
> *   **7:00 am:** Wakes up and eats breakfast.
> *   **8:15 am:** Leaves for university.
> *   **Daytime:** Studies alone or attends classes (15 hours of Master's level classes per week) and spends 20 hours on self-study. Eats lunch with a study friend or small group.
> *   **3:00 pm:** Leaves for home; sometimes continues studying for 2-3 hours.
> *   **6:00 pm - 10:00 pm:** Works as a waitress at a small eco-restaurant three nights a week.
>
> ### Future Goals
> Christie dreams of combining work and travel in the future. She wants to work in a third-world country to help others who have not had the same advantages of being born into a wealthy society. She is currently unsure about having children or a husband, as it is not on her radar.

> [!summary] The Take Away
> Personas are fictional characters created based on research to help understand users’ needs, experiences, behaviors, and goals. They assist designers in identifying with the user they are designing for, making the design task less complex. Personas guide ideation processes and help achieve a good user experience for the target user group. Engaging personas specifically emphasize using stories to bring these characters to life, supported by a comprehensive 10-step process that covers data collection, description, scenario creation, and ongoing development.

# Prototypes
## What are Prototypes?
Prototypes are early models of a product that simulate its design and functionality. They are created to test concepts, gather feedback, and iterate on the design before the final product is developed.

> [!info] Prototyping
> Prototyping is the experimental process of making prototypes. Teams build prototypes of varying degrees of fidelity, ranging from low-fidelity paper prototypes to high-fidelity digital models that closely resemble the final product.

> [!tip] Value of Prototyping
> "They slow us down to speed us up. By taking the time to prototype our ideas, we avoid costly mistakes such as becoming too complex too early and sticking with a weak idea for too long."
> — Tim Brown, CEO & President of IDEO

Prototyping is the fourth phase of both design thinking and design sprints. It serves as an essential part of user experience (UX) design that typically follows the ideation phase, where a design team has created and selected ideas to solve user needs. In this phase, designers craft a simple experimental model of their proposed product. This allows them to assess how well the product aligns with user needs and expectations through valuable user feedback. Designers should incorporate prototyping into their process from the early stages, even using paper prototyping when appropriate, as this early feedback can be instrumental in guiding the product's development.

> [!abstract] Prototyping as Strategic Investment
> Prototyping is more than just a step in the design process; it acts as a strategic investment that yields substantial returns. It provides a tangible way to validate ideas before full-scale development begins.

### Risk Mitigation and Enhanced Communication

Prototypes act as safety nets, allowing designers to identify and address potential flaws or usability issues early in the design process. By visualizing and interacting with a prototype, designers can uncover problems that might not be apparent in abstract designs or specifications. This early detection prevents these issues from escalating into costly problems during development or after product launch.

Furthermore, prototypes enhance communication by serving as a universal language that facilitates effective interaction among designers, developers, stakeholders, and users. A prototype can bridge the gap between abstract concepts and concrete implementations, ensuring everyone has a clear understanding of the product's direction and functionality.

### Cost-Effectiveness and Accelerated Innovation

Prototyping offers significant cost savings by enabling the early detection of errors, allowing designers to rectify them in an efficient and cost-effective manner. Modifying a prototype is far less costly than reworking a fully developed product, as changes become increasingly expensive as the project progresses.

Additionally, the iterative nature of prototyping accelerates innovation. Designers can rapidly experiment and explore multiple ideas, quickly testing and refining them based on user feedback. This iterative process fosters creativity and leads to more innovative and effective solutions.

![[Pasted image 20260218173749.png]]
## Stakeholder Buy-In

Prototypes provide a solid foundation for ideation and further improvements, giving all stakeholders a clear picture of the potential benefits, risks, and costs associated with the product's development. This transparency builds trust and fosters collaboration among team members.

### User-Centered Design

User-centered design is at the heart of prototyping. By gathering invaluable feedback from real users throughout the design process, prototypes ensure that the final product aligns with user needs, preferences, and expectations.

> [!tip] Fostering Ownership
> This user-centric approach not only leads to a more satisfying product but also fosters a sense of ownership among stakeholders. This generates excitement and enthusiasm that can help secure support and resources.

### Explore User Needs

Prototypes are valuable tools for experimenting with various aspects of user needs and problems. This experimentation can lead to insights into less obvious areas of the user's world, such as unexpected usage patterns or unforeseen accessibility issues. By addressing these issues early on, designers avoid costly oversights and create a more inclusive and user-friendly product.

### Reduce Time-to-Market

> [!tip] Strategic Advantage
> Prototyping can significantly reduce time-to-market. By minimizing the number of errors that need correction before product release and adapting changes early in the process, the design and development process is streamlined, resulting in a faster launch.
> 

This allows companies to gain a competitive advantage and respond more quickly to market demands.

## How to Understand Fidelity: Low-Fidelity vs Mid-Fidelity vs High-Fidelity Prototyping

Fidelity refers to the level of detail and functionality of a prototype. Usually, this will depend on the product’s development stage. A prototype can provide a wide view of the entire system or subsystem (called a `horizontal prototype` – e.g., an entire website) or one that gives a detailed view of just one feature (a `vertical prototype` – e.g., a checkout process). The level of fidelity of a prototype should be appropriate for presenting to users in user testing so they can give focused feedback.

> [!info] Prototype Scope
> - **Horizontal Prototype:** Provides a wide view of the entire system or subsystem.
> - **Vertical Prototype:** Provides a detailed view of just one feature.

### Low-Fidelity Prototypes

-   **Characteristics:** Basic, often hand-drawn representations of a product's interface or flow, focusing on the core concept and user journey rather than visual details.
-   **Examples:** Paper prototypes, sketches, wireframes.
-   **Pros:** Fast and cheap to create; disposable; easy to make changes and test new iterations; provide a quick overview of the product; anyone can produce them; encourage design thinking as they are visibly not finalized.
-   **Cons:** Lack of realism can make it difficult for users to provide feedback; results from early versions may be hard to apply to the final product; lack of interactivity deprives users of direct control, requiring them to imagine how they would use the product; can oversimplify complex issues.
-   **Best for:** Early-stage concept exploration, brainstorming, and gathering initial user feedback on basic functionality and flow.

### Mid-Fidelity Prototypes

-   **Characteristics:** Bridge the gap between low and high fidelity, offering a more interactive and detailed representation. They typically include some visual design elements and basic interactions.
-   **Examples:** Clickable wireframes, interactive mockups, basic animations.
-   **Pros:** Provide a more realistic user experience than low-fidelity prototypes; allow for testing of basic interactions; relatively quick to create compared to high-fidelity versions.
-   **Cons:** May still lack visual polish and some advanced interactions; can be time-consuming to create compared to low-fidelity prototypes.
-   **Best for:** Testing specific features or interactions, refining user flows, and evaluating design concepts with a higher degree of realism.

### High-Fidelity Prototypes

-   **Characteristics:** Closely resemble the final product, with detailed visuals, interactions, and animations. They aim to simulate the actual user experience as closely as possible.
-   **Examples:** Digital prototypes created on software, interactive prototypes with realistic data, fully functional UI elements, microinteractions.
-   **Pros:** Engaging—stakeholders experience the vision firsthand and can judge its alignment with user needs; testing yields more accurate, applicable results; versions closest to the final product enable prediction of user reception in the marketplace.
-   **Cons:** Longer and costlier to create; users may focus on superficial details rather than content; designers may resist changes due to the investment of time and effort; users may mistake the prototype for the finished product and form biases.
-   **Best for:** Usability testing, evaluating the overall user experience, gathering detailed feedback on the final design, and demonstrating the product to stakeholders.

> [!warning] Prototype Bias
> High-fidelity prototypes carry the risk that users may mistake them for the finished product, leading to biased feedback based on the assumption that the design is final.

> [!note] Relativity of Fidelity
> Fidelity is _relative_—a static mockup of a landing page, for example, is of higher fidelity than sketched cut-outs users can move.
## Prototyping in Action: How to Bring Ideas to Life

Prototyping is the fourth stage in the Design Thinking process, following empathize, define, and ideate. It is the crucial point where abstract ideas and user insights are transformed into tangible representations. While many associate prototyping with building a physical or digital model, fundamentally it is about experimentation and learning.

Prototyping connects with the other stages of design thinking in the following ways:

*   **Step 1, Empathize:** In this initial stage, designers immerse themselves in the user’s world to gain a deep understanding of their needs, pain points, and aspirations. The insights gathered here inform the prototyping process to ensure the prototype addresses real user problems.
*   **Step 2, Define:** This stage synthesizes research findings into a clear problem statement. This statement acts as a guiding light for the prototyping process, ensuring efforts are focused on solving the right problem.
*   **Step 3, Ideate:** During ideation, designers brainstorm a wide range of potential solutions. These ideas serve as the foundation for prototyping, allowing designers to test and evaluate them in a tangible form.
*   **Step 5, Test:** The final stage involves putting the prototype in front of users to gather feedback. This feedback loop allows designers to refine and iterate on their design, ensuring the final product meets user needs and expectations.

> [!tip] Dynamic Framework
> The design thinking process is not linear; it is a dynamic framework where designers can move between stages, revisiting previous phases as they gather new insights, challenge assumptions, and refine their solutions.
>
![[Pasted image 20260218173911.png]]

### The Prototyping Process: A Roadmap for Effective Design

The prototyping process guides designers from an initial concept to a refined design. The following is a general outline of this process:

1.  **Define goals and objectives:** Designers clearly articulate the purpose of the prototype, drawing on insights from the empathize and define stages. They determine what questions they are trying to answer, what aspects of the design they want to test, and what user needs they are addressing.
2.  **Choose the right fidelity:** Designers select the appropriate fidelity level (low, mid, or high) based on project goals, development stage, resources, and target audience. They consider whether a simple paper prototype or a high-fidelity simulation best suits their current needs.
3.  **Create the prototype:** Designers build the prototype using chosen tools and techniques, incorporating the most promising ideas from the ideate stage. They focus on core user flows and interactions, prioritizing the most critical aspects of the user experience.
4.  **Test and gather feedback:** Designers share the prototype with stakeholders and potential users to gather feedback. They encourage constructive criticism and ask open-ended questions to gain insights into user experiences and expectations.
5.  **Iterate and refine:** Based on the feedback received, designers iterate on the prototype. This involves making necessary changes, refining interactions, and testing new ideas. This cycle is repeated multiple times to continuously improve the design.
6.  **Document and share:** Designers document the prototyping process, including iterations, feedback, and decisions made. Sharing this with the team and stakeholders maintains transparency and provides a valuable reference for future development.
7.  **Test and validate:** Designers conduct user testing with the final prototype to validate design decisions and identify any remaining issues. This may involve usability testing or other research methods and is essential to ensure the final product meets user needs.
8.  **Implement and launch:** Once the prototype has been thoroughly tested and refined, the design is incorporated into final product development. Designers continue to monitor user feedback after launch to iterate and improve the user experience.
## How to Showcase Prototypes in a Design Portfolio

A well-crafted design portfolio is essential for designers to showcase their skills and experience to potential employers or clients. Including prototypes in a portfolio can elevate the work and demonstrate the ability to translate ideas into tangible experiences. Designers can effectively integrate prototypes into their case studies by following these strategies:

1.  **Choose the best work:** Select case studies, projects, and prototypes that best represent skills and highlight problem-solving abilities.
2.  **Provide context:** Clearly explain how the prototype fits into the overall project narrative. Describe the problem being addressed, the specific goals the prototype aimed to achieve, and how it contributed to the final solution.
3.  **Use a variety of formats:** Showcase different types of prototypes within a case study, such as initial sketches, wireframes, and interactive mockups. This illustrates the evolution of the design and the iterative process undertaken.
4.  **Interactive prototypes:** If feasible, include interactive prototypes that allow viewers to click through and experience the user flow firsthand. This approach brings the case study to life and showcases the interactive aspects of the design.

> [!tip] Video Demonstrations
> Consider creating short video demonstrations of interactive prototypes as part of the case study presentation. This is particularly effective for showcasing complex interactions or animations that might be difficult to convey through static images.

5.  **User testing results:** If available, incorporate summaries of user testing results or feedback received on prototypes directly into the case study. This demonstrates a commitment to user-centered design and the ability to gather and apply feedback to improve the design.
6.  **Link to live projects:** If any of the prototypes have been developed into live products or websites, include links to them within the case study. This allows viewers to see the real-world impact of the design work and understand how the prototype translated into a final product.
## Five Common Low-Fidelity Prototyping Methods

1.  **Sketches**
    Although not technically prototypes, sketches serve as powerful tools for making decisions. They are incredibly easy to create and discard, making them accessible to both designers and non-designers. Use sketches in the early, divergent stages of the design process to explore ideas, communicate concepts with teammates, and visualize user journeys.

2.  **Paper Prototypes**
    These tangible prototypes involve creating rough "animations" by sliding pieces of paper to simulate user interactions. They are inexpensive, easy to modify, and allow designers to focus on the core concept rather than visual details. Paper prototypes are best suited for testing novel solutions and user flows, but are less helpful for evaluating standard `UI patterns`.

3.  **Lego Prototypes**
    Lego bricks offer a unique way to quickly create physical prototypes, especially for tangible products. Their versatility and ease of modification make them ideal for experimenting with form and function. Use Lego prototypes for empathizing with users, recreating user journeys, or visualizing complex systems.

4.  **Digital Wireframes**
    Wireframes are simple, bare-bones illustrations of an app or website's layout and functionality. They allow designers to focus on content structure and user flows, ignoring visual aspects. Wireframes are best used after the initial ideation phase, when the focus shifts to information architecture, layout, and space allocation.

5.  **Wizard of Oz Prototypes**
    These prototypes simulate complex interactions or functionality that may be difficult to implement early in development. A team member acts as the "wizard," manually controlling responses or actions behind the scenes. Wizard of Oz prototypes are useful for testing complex systems, future technologies, or voice interfaces, providing realistic user feedback without building a fully functional prototype.