---
tags:
  - Prompt
  - Template
  - AI-Interaction
type: prompt-template
model: GLM-4.6
version: 1.0
author: Z.ai
created: 27-05-24
updated: 27-05-24
---
- - -
# GLM-4.6 Advanced Prompt Template

> [!abstract] **Primary Goal**
> Provide a concise, one-sentence summary of the ultimate objective of this prompt. What is the most important outcome you want to achieve?
> - **Example:** "To generate a comprehensive, yet accessible, overview of ***Your Specific Topic Here*** for a university-level student."

> [!info] **Persona & Role**
> Define the AI's persona. This sets the tone, perspective, and expertise level of the response.
> - **You are an expert...** (e.g., "a theoretical physicist specializing in quantum mechanics," "a senior software engineer with 20 years of experience in distributed systems," "a professional historian specializing in the late Roman Republic").
> - **Your audience is...** (e.g., "a complete beginner," "an educated layperson," "a domain expert").
> - **Your communication style is...** (e.g., "formal and academic," "conversational and witty," "highly technical and precise").

> [!note] **Context & Background**
> Provide all necessary background information, source material, or context the AI needs to understand the task fully. This is the "briefing" section.
> - **Key Concepts:** Define any specific terms or frameworks that are central to the topic.
> - **Source Material:** "Base your response on the following text/data: [[Paste source or link here]]."
> - **Situation:** "I am preparing for a presentation on..." or "I am trying to understand the core arguments between..."

> [!todo] **Core Task & Instructions**
> Provide a clear, step-by-step list of what the AI must do. Use numbered lists for sequential tasks and bullet points for non-sequential requirements.
> 1.  **Analyze:** First, break down the core components of [[Your Specific Topic Here]].
> 2.  **Explain:** Define each component clearly, using analogies where helpful.
> 3.  **Synthesize:** Explain how these components interact or relate to one another.
> 4.  **Provide Examples:** Give at least two concrete, real-world examples to illustrate the concepts.
> 5.  **Structure:** Organize the output according to the format specified below.

> [!warning] **Constraints & Negative Constraints**
> Clearly define the rules, boundaries, and what the AI should explicitly avoid. This is critical for controlling the output.
> - **Scope:** "Do not discuss [[Topic to Avoid]]."
> - **Tone:** "Avoid overly technical jargon. Define any necessary terms."
> - **Factual Accuracy:** "Do not hallucinate facts. If information is not available, state that explicitly."
> - **Formatting:** "Strictly adhere to the output format below. Do not add any introductory or concluding remarks outside of the specified structure."
> - **Bias:** "Present a balanced view, acknowledging multiple perspectives where applicable."

> [!example] **Output Format Specification**
> Define the exact structure of the desired output using Markdown and placeholders. This is the most critical part for ensuring the AI's output matches your needs.
> ```markdown
> # [[Main Title of Your Topic]]
>
> ## 1. Core Concepts
> <!-- A brief, one-paragraph overview. -->
>
> ### [[Concept 1 Title]]
> - **Definition:** ...
> - **Key Characteristics:** ...
>
> ### [[Concept 2 Title]]
> - **Definition:** ...
>
> ## 2. Interactions and Relationships
> <!-- Explain how the concepts above connect. -->
> - **Relationship A to B:** ...
>
> ## 3. Practical Examples
> <!-- Provide the requested real-world examples. -->
> 1.  **Example 1:** [[Description of Example 1]]
> 2.  **Example 2:** [[Description of Example 2]]
>
> ## 4. Summary
> <!-- A final, concise summary of the key takeaways. -->
> ```

> [!tip] **Iteration & Refinement**
> Provide guidance for follow-up questions or how to guide the AI to improve the output.
> - **If the output is too general, ask:** "Can you elaborate on [[Specific Point]] with more technical detail?"
> - **If the output is too complex, ask:** "Can you simplify the explanation of [[Specific Point]] for a beginner?"
> - **To explore a side topic, ask:** "How does this relate to [[Related Topic]]?"