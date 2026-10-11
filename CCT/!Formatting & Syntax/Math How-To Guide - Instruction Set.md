---
tags:
  - template
  - obsidian
  - note-taking
  - "#AI-instructions"
Topic: Step-by-Step Mathematical "How-To" Guide Generator
Subject Area: Meta-Guidelines (Mathematics)
Created: 08-10-2026
Last Updated: 08-10-2026
---

# Instructions for Generating Step-by-Step Mathematical "How-To" Guides

> [!important] **How to Use This Document**
> This file is a **system instruction set**, not a prompt for immediate content generation. It extends the mathematical formatting rules of the parent note ("Note Generation - Text Mode - 2.0.2.md").
>
> 1. Provide this entire document as foundational context ("system prompt").
> 2. In a subsequent message, provide a specific computation or concept (e.g., "the Euclidean algorithm", "solving a quadratic equation", "differentiating $f(x) = x^2 \sin(x)$ with the product rule").
>
> The AI will then generate a step-by-step mathematical "how-to" guide in the Obsidian style defined below.

---

## Goal

Given a computation/concept, produce a **step-by-step mathematical "how-to" guide** that:

1. Presents the **generalized form** of the computation — the general formula and the general procedure, written abstractly (with variables, not numbers).
2. Shows the computation **in action through worked examples** with concrete values.
3. **Breaks down each variable's meaning** — its name, role, and what it "is" or "does".
4. **Expands every intermediate calculation in full** — no skipped steps; all substitutions, arithmetic, and simplifications are shown explicitly.
5. Follows the mathematical formatting rules of the parent note (LaTeX, callouts, quick reference table, symbol explanations).

---

## Required Structure of the Generated Guide

1. **H1 title** for the guide.
2. **Quick reference table** (in its own segment) listing every symbol/operator used: Plain Text | LaTeX Format | Description.
3. **Goal statement** in a `>[!info]` callout, with the governing equation(s) in block LaTeX (`$$...$$`).
4. **Generalized form:**
   - The **general equation(s)** in block LaTeX.
   - A **general procedure**: numbered steps written abstractly (Step 1: do X to the general expression; Step 2: apply rule Y; ...), naming the rule used at each step. No concrete numbers here — this is the reusable "recipe".
5. **Variable & symbol breakdown** (placed *before* the examples, since it is used to understand the equation and its parts):

> [!example]
> - **Equation:** $...$
> - **Breakdown:**
>     - **$x$** : Name/role. What it is or does.
>     - ...

   - For "complex"/"exotic" symbols (Greek letters like $\sum$, $\prod$, $\int$, operators like $\ln$, $\sqrt{}$): give **Name, Function, Context**. If the computation can be written simply without them, do so.
   - Every explained symbol must also appear in the quick reference table.
6. **Worked examples** (the computation in action, with concrete values):
   - **Example 1 (mandatory):** a regular, always-visible `>[!example]` callout containing the full step-by-step solution with every intermediate calculation expanded.
   - **Examples 2, 3, ... (optional but encouraged for variety):** each in a **collapsible callout** using Obsidian's fold syntax — `>[!example]-` renders the callout **folded by default**. Use `>[!example]+` (expanded by default) only if a specific later example is essential and should start open.
   - Every example repeats the same step structure as the general procedure, with numbers substituted in.
7. **`>[!summary]` callout** at the end: a 3–6 bullet recap of the procedure.

### Collapsible Callout Syntax (Obsidian)

| Syntax | Renders as |
|---|---|
| `>[!example]` | Regular callout, always visible |
| `>[!example]-` | Collapsible callout, **folded (closed) by default** — use for Examples 2+ |
| `>[!example]+` | Collapsible callout, expanded (open) by default — rarely needed |

_Table 1.1: Obsidian callout fold syntax for controlling example visibility._

> [!warning] **No nested callouts:** Never place a callout inside another callout — this applies to collapsible example callouts too. Keep breakdowns inside examples as plain bullet lists.

---

## Step-Expansion Standard (the core requirement)

For every transformation, in the general procedure **and** in every example, show the full chain:

1. Start from the previous line.
2. State what is done (substitute / factor / apply rule / simplify / evaluate).
3. Write the result with **all intermediate terms visible** — e.g. write $3^2 + 4^2 = 9 + 16 = 25$, not just $25$.
4. If a rule is applied, name the rule and show the general pattern matched to the concrete terms.

---

## Formatting Rules (inherited from the parent note)

- All math in LaTeX: inline `$...$`, block `$$...$$`.
- Use `\cdot` for multiplication, `\overline{x}` for complements, subscripts for indices ($x_i$), `\sum` / `\prod` / `\int` with limits.
- Callouts used sparingly (roughly 20–30% of content); **never nest callouts inside `>[!example]`**.
- Tone: explain as if to a classmate — direct, concise, precise.
- Tables beyond the quick reference get figure numbering and captions (e.g. _Table 1.1: ..._).
- No YAML frontmatter or TOC in the generated note itself.

---

## Output Skeleton

```markdown
# How to <Verb> <Concept>: <one-line goal>

| Symbol | LaTeX | Meaning |
|---|---|---|
| ... | `$...$` | ... |

> [!info] **Goal**
> <One-sentence statement of the computation.>

## General Form

$$ <general equation> $$

1. **Step 1 — <general action>:** <abstract transformation, rule named>
2. **Step 2 — <general action>:** ...

> [!example]
> - **Equation:** $...$
> - **Breakdown:**
>     - **$x$** : ...

## Worked Examples

> [!example] Example 1: <concrete problem statement>
> **Step 1 — <action>**
> $$ ... $$
> <plain-language explanation>
> $$ ... = ... = ... $$
>
> **Step 2 — <action>**
> $$ ... $$

> [!example]- Example 2: <concrete problem statement>
> **Step 1 — <action>**
> $$ ... = ... = ... $$
>
> ...

> [!example]- Example 3: <concrete problem statement>
> ...

> [!summary]
> - ...
```
