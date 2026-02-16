---
tags:
  - Guide
  - Format
  - Syntax
  - LaTex
Topic: Formatting & Syntax in LaTex
Created: 03-11-2025
---
> [!abstract]- What is LaTeX?
>  LaTeX (pronounced "Lay-tech" or "Lah-tech") is not a word processor; it is a high-quality **typesetting system**. Instead of visually formatting your text, you write plain text marked up with commands, and LaTeX compiles it into a perfectly formatted PDF. It is the standard for academic and scientific documents, especially those involving complex mathematics.

- - - 
## Table of Contents
- [[#The Essentials (Document Structure & Basic Text)|The Essentials (Document Structure & Basic Text)]]
	- [[#The Essentials (Document Structure & Basic Text)#Document Skeleton|Document Skeleton]]
	- [[#The Essentials (Document Structure & Basic Text)#Basic Text Formatting|Basic Text Formatting]]
	- [[#The Essentials (Document Structure & Basic Text)#Paragraphs and Line Breaks|Paragraphs and Line Breaks]]
- [[#Structuring Your Document|Structuring Your Document]]
	- [[#Structuring Your Document#Headings and Sections|Headings and Sections]]
	- [[#Structuring Your Document#Table of Contents and Cross-Referencing|Table of Contents and Cross-Referencing]]
- [[#Lists and Quotes|Lists and Quotes]]
	- [[#Lists and Quotes#Lists|Lists]]
	- [[#Lists and Quotes#Blockquotes|Blockquotes]]
- [[#Mathematics|Mathematics]]
	- [[#Mathematics#Math Modes|Math Modes]]
	- [[#Mathematics#Common Syntax|Common Syntax]]
	- [[#Mathematics#Aligning Multiple Equations|Aligning Multiple Equations]]
- [[#Including External Content|Including External Content]]
	- [[#Including External Content#Images|Images]]
	- [[#Including External Content#Tables|Tables]]
- [[#Advanced Formatting and Packages|Advanced Formatting and Packages]]
	- [[#Advanced Formatting and Packages#Hyperlinks|Hyperlinks]]
	- [[#Advanced Formatting and Packages#Code Listings|Code Listings]]
	- [[#Advanced Formatting and Packages#Bibliographies (BibTeX)|Bibliographies (BibTeX)]]
		- [[#Bibliographies (BibTeX)#Structure of an Entry|Structure of an Entry]]
		- [[#Bibliographies (BibTeX)#Common Entry Types and Fields|Common Entry Types and Fields]]
		- [[#Bibliographies (BibTeX)#Citing Sources in Your Document|Citing Sources in Your Document]]
			- [[#Citing Sources in Your Document#Step 1: Load the Necessary Package|Step 1: Load the Necessary Package]]
			- [[#Citing Sources in Your Document#Step 2: Choose a Bibliography Style|Step 2: Choose a Bibliography Style]]
			- [[#Citing Sources in Your Document#Step 3: Cite in Your Text|Step 3: Cite in Your Text]]
			- [[#Citing Sources in Your Document#Part 4: The Compilation Process (The "Dance")|Part 4: The Compilation Process (The "Dance")]]
	- [[#Advanced Formatting and Packages#The Modern Approach: Biblatex|The Modern Approach: Biblatex]]
		- [[#The Modern Approach: Biblatex#Why biblatex?|Why biblatex?]]
		- [[#The Modern Approach: Biblatex#Biblatex Workflow|Biblatex Workflow]]
		- [[#The Modern Approach: Biblatex#Compilation Sequence for Biblatex|Compilation Sequence for Biblatex]]
		- [[#The Modern Approach: Biblatex#Best Practices|Best Practices]]
		- [[#The Modern Approach: Biblatex#Common Problems and Solutions|Common Problems and Solutions]]
- [[#Best Practices & Tips|Best Practices & Tips]]
# The Essentials (Document Structure & Basic Text)
## Document Skeleton
> A minimal LaTeX document has two parts: the **Preamble** and the **Body**.

```Latex
\documentclass{article}

% This is the PREAMBLE.
% It's where you load packages and define settings.
% This is a comment, started with a percent sign.

\title{My First Document}
\author{A. N. Author}
\date{\today}

\begin{document}

% This is the BODY.
% This is where your actual content goes.

\maketitle % This command generates the title from the preamble info.

Hello, world! This is my first sentence.

\end{document}
```
This compiles into a PDF with a centered title ("My First Document"), author, and date, followed by the paragraph "Hello, world! This is my first sentence."
## Basic Text Formatting
> Just like in other systems, you can make text bold, italic, and more.

```LaTex
Some text is \textbf{bold}, some is \textit{italic}, and some is \underline{underlined}.

You can also combine them: \textbf{\textit{bold and italic}}.

For text that shouldn't be hyphenated, use \mbox{do not break}.
```
Some text is **bold**, some is _italic_, and some is <u>underlined</u>.

You can also combine them: _**bold and italic**_.

For text that shouldn't be hyphenated, use `do not break`.
## Paragraphs and Line Breaks
> LaTeX handles paragraph separation automatically.

- **New Paragraph:** Leave a blank line in your `.tex` file.
- **Forced Line Break:** Use `\\` (double backslash). Use this sparingly, for things like addresses or poetry.

> [!warning]- Common Mistake 
> Do not use `\\` to end a paragraph. It creates a new line but not a new paragraph, which can mess up spacing and indentation. Always use a blank line.
# Structuring Your Document
> For longer documents, you need sections, cross-references, and a table of contents.

## Headings and Sections
The available commands depend on your `\documentclass`. For `article` or `report`:
```latex
\section{Introduction}
This is the introduction.

\subsection{Background}
Here is some background information.

\subsubsection{History}
A deeper dive into the history.

\section{Methods}
This section describes our methods.
```
LaTeX will automatically number these sections (e.g., "1 Introduction", "1.1 Background") and format them with different font sizes.
## Table of Contents and Cross-Referencing
> This is a core feature of LaTeX. You let LaTeX handle the numbering.

```latex
\tableofcontents % Generates the ToC from your sections

\section{Introduction} \label{sec:intro}
This is the introduction. See Section \ref{sec:methods} for our methods.

\section{Methods} \label{sec:methods}
Our methods are described here. As we saw in Section \ref{sec:intro}...
```
- A "Table of Contents" will be generated at the top with clickable links to each section.
- The text `\ref{sec:methods}` will be automatically replaced with the correct section number (e.g., "2"). If you add a section before it, the reference will update automatically on the next compile.
# Lists and Quotes
## Lists
```latex
% Unordered List
\begin{itemize}
  \item First item
  \item Second item
  \begin{itemize}
    \item A nested item
  \end{itemize}
  \item Third item
\end{itemize}

% Ordered List
\begin{enumerate}
  \item Step one
  \item Step two
  \item Step three
\end{enumerate}

% Description List
\begin{description}
  \item[LaTeX] A typesetting system.
  \item[Markdown] A lightweight markup language.
\end{description}
```
- An unordered list with bullet points.
- An ordered list with numbers (1, 2, 3).
- A description list with bolded terms.
## Blockquotes
```latex
\begin{quote}
This is a short quotation. It will be indented on both sides.
\end{quote}

\begin{quotation}
This is a longer quotation, often used for excerpts of several paragraphs. It handles paragraph indentation within the block differently than the quote environment.
\end{quotation}
```
# Mathematics
> This is where LaTeX truly excels.

## Math Modes
- **Inline Math:** For math inside a sentence. Use `$...$`.
- **Display Math:** For math on its own line, centered. Use `\[...\]` or the `equation` environment.
```latex
The Pythagorean theorem is $a^2 + b^2 = c^2$. This is inline.

A more important equation might get its own line:
\[ E = mc^2 \]

If you want it to have a number and be referenceable, use the equation environment:
\begin{equation}
  \int_{a}^{b} f(x)\,dx = F(b) - F(a) \label{eq:ftc}
\end{equation}
Equation \ref{eq:ftc} is the Fundamental Theorem of Calculus.
```
> [!tip]- The `amsmath` Package 
> For serious math, always add `\usepackage{amsmath}` to your preamble. It provides many enhancements, including better environments for aligning multiple equations.
## Common Syntax
| Feature | Syntax | Example |
| :--- | :--- | :--- |
| Superscript | `^` | `x^2` → $x^2$ |
| Subscript | `_` | `x_i` → $x_i$ |
| Fraction | `\frac{num}{den}` | `\frac{1}{2}` → $\frac{1}{2}$ |
| Root | `\sqrt[order]{expr}` | `\sqrt{x}` → $\sqrt{x}$ |
| Greek Letter | `\lettername` | `\alpha, \beta, \lambda` → $\alpha, \beta, \lambda$ |
| Operators | `\times, \pm, \neq` | `\times` → $\times$ |
## Aligning Multiple Equations
> Use the `align` environment from `amsmath`. Use `&` to set the alignment point (usually before an equals sign) and `\\` to start a new equation.

```latex
\begin{align}
  (x+y)^2 &= x^2 + 2xy + y^2 \\
  (x-y)^2 &= x^2 - 2xy + y^2
\end{align}
```
Two equations, one above the other, both aligned at the equals sign, each with its own equation number.
# Including External Content
## Images
> [!warning] First, add `\usepackage{graphicx}` to your preamble.

```latex
\begin{figure}[h!] % [h!] is a placement suggestion: here!
  \centering % Center the image
  \includegraphics[width=0.5\textwidth]{path/to/my-image.png}
  \caption{A descriptive caption for the figure.}
  \label{fig:mylabel}
\end{figure}

As you can see in Figure \ref{fig:mylabel}, ...
```
An image is included, scaled to 50% of the text width, with a caption below it (e.g., "Figure 1: A descriptive caption...") and is referenceable.
## Tables
> Tables are built using the `tabular` environment inside a `table` environment.

```latex
\begin{table}[h!]
  \centering
  \caption{Results of the experiment.}
  \label{tab:results}
  \begin{tabular}{l|c|r} % l=left, c=center, r=right, |=vertical line
    \textbf{Item} & \textbf{Value} & \textbf{Error} \\
    \hline % Horizontal line
    Alpha & 0.42 & 0.01 \\
    Beta & 1.57 & 0.05 \\
    Gamma & 9.81 & 0.10 \\
  \end{tabular}
\end{table}
```
A formatted, centered table with a caption (e.g., "Table 1: Results of the experiment.") and is referenceable.
# Advanced Formatting and Packages
> LaTeX's functionality is extended using **packages**.

> [!warning] Note
> You load them in the preamble with `\usepackage{package_name}`.

## Hyperlinks
>[!warning] Note
>Add `\usepackage{hyperref}` (usually the last package in your preamble).

```latex
\url{https://www.latex-project.org/}
\href{https://www.latex-project.org/}{The LaTeX Project Website}
```
A clickable URL and a clickable hyperlink with custom text.
## Code Listings
>[!warning] Note
>Add `\usepackage{listings}`.

```latex
\begin{lstlisting}[language=Python]
# A simple Python function
def greet(name):
  print(f"Hello, {name}!")

greet("World")
\end{lstlisting}
```
A formatted code block with Python syntax highlighting.
## Bibliographies (BibTeX)
> Using BibTeX involves three distinct components and a multi-step compilation process.

1. Create a separate `.bib` file (e.g., `references.bib`) with your bibliography entries.
2. In your preamble, add `\usepackage{...}` and specify the bibliography style.
3. In your document, use `\cite{key}` to cite a source.
4. Use `\printbibliography` where you want the bibliography list to appear.
### Structure of an Entry
> Every entry in your `.bib` file follows this format:

```bibtex
@entrytype{citation_key,
  field1 = {value1},
  field2 = {value2},
  ...
}
```
- **`@entrytype`**: The type of publication (e.g., `@article`, `@book`, `@misc`).
- **`citation_key`**: A unique identifier you create. This is what you'll use to cite the source in your `.tex` file. Make it short and memorable (e.g., `einstein1905`, `knuth1984`).
- **`field = {value}`**: A piece of information about the source, like the author, title, or year. The value must be enclosed in curly braces `{}` or double quotes `""`.
### Common Entry Types and Fields
| Entry Type | Description | Required Fields |
| :--- | :--- | :--- |
| `@article` | An article in a journal. | `author`, `title`, `journal`, `year` |
| `@book` | A book with a publisher. | `author`/`editor`, `title`, `publisher`, `year` |
| `@inproceedings` | An article in conference proceedings. | `author`, `title`, `booktitle`, `year` |
| `@phdthesis` | A PhD thesis. | `author`, `title`, `school`, `year` |
| `@misc` | For anything that doesn't fit elsewhere. | `author`, `title`, `howpublished`, `year` |
| `@unpublished` | A document with an author and title but not formally published. | `author`, `title`, `note`, `month`, `year` |
> [!tip]- Multiple Authors 
> For multiple authors, separate their names with the keyword `and`. `author = {Smith, J. and Doe, J. and Roe, R.}`

### Citing Sources in Your Document
> use the references from our `.bib` file in our main LaTeX document.

#### Step 1: Load the Necessary Package
In your preamble, you need to load a package that handles citations. The `natbib` package is a classic and powerful choice.
```latex
\documentclass{article}
\usepackage{natbib} % The package for citations
```
#### Step 2: Choose a Bibliography Style
Also in the preamble, before `\begin{document}`, you tell BibTeX how you want the final bibliography to look.
```latex
\bibliographystyle{plain} % A simple, numbered style
% Other common styles:
% \bibliographystyle{apalike} % Author-year style, like APA
% \bibliographystyle{unsrt}   % Numbered, ordered by appearance
```
#### Step 3: Cite in Your Text
Within the body of your document, use the `\cite{}` command with the `citation_key` you defined in your `.bib` file.
```latex
\begin{document}

As Einstein showed in his 1905 paper \cite{einstein1905}, the speed of light is constant...
For more on typesetting itself, see The TeXbook \cite{knuth1984}.

If you want to mention the author in the text, you can write: Einstein \cite{einstein1905} was the first to...
You can also cite multiple sources at once \cite{einstein1905, knuth1984}.

% This is where the bibliography will be printed.
\bibliography{references} % The name of your .bib file (without the .bib extension)

\end{document}
```
>[!tip]- `natbib` Citation Commands 
>The `natbib` package provides more commands than just `\cite{}`.

| Command              | Output Example                | Description                                      |
| :------------------- | :---------------------------- | :----------------------------------------------- |
| `\cite{key}`         | [1] or (Einstein, 1905)       | Standard citation, depends on style.             |
| `\citet{key}`        | Einstein (1905)               | Textual citation, good for "Einstein showed...". |
| `\citep{key}`        | (Einstein, 1905)              | Parenthetical citation.                          |
| `\citep{key1, key2}` | (Einstein, 1905; Knuth, 1984) | Multiple parenthetical citations.                |
#### Part 4: The Compilation Process (The "Dance")
This is the most crucial and often confusing step. You must compile your files in a specific order. The classic sequence is:
1. **`pdflatex mydocument.tex`**
2. **`bibtex mydocument`** (Note: No extension!)
3. **`pdflatex mydocument.tex`**
4. **`pdflatex mydocument.tex`**
>[!tip]- Automate Compilation 
>Most LaTeX editors (like VS Code with LaTeX Workshop) have a compile button that automates this. A command-line tool called `latexmk` is even better. Just run `latexmk -pdf mydocument.tex` and it will handle everything automatically.
## The Modern Approach: Biblatex
>[!important] Recommendation for New Projects 
>For any new project, **start with `biblatex` and Biber**. It is the modern standard and offers far more power and flexibility than traditional BibTeX.
### Why biblatex?
- **Full Unicode Support:** No problems with special characters.
- **Highly Customizable:** Change formatting directly in your LaTeX preamble.
- **Better Data Model:** Supports more entry types and fields (e.g., `doi`, `url` are standard).
- **Active Development:** Continuously updated with new features.
### Biblatex Workflow
> The workflow is simpler and more integrated. It uses a backend called **Biber** instead of BibTeX.

1. **Load `biblatex` in your preamble.**
2. **Add the `\addbibresource{}` command.**
3. **Use `\printbibliography` where you want the bibliography.**
4. **Compile with `biber` instead of `bibtex`.**

Example:
```latex
\documentclass{article}

% Load biblatex with the backend=biber option
\usepackage[backend=biber, style=authoryear]{biblatex}

% Add your bibliography file (include the .bib extension)
\addbibresource{myreferences.bib}

\begin{document}

The citation commands are similar to natbib.
Textual citation: \textcite{einstein1905}.
Parenthetical citation: \parencite{knuth1984}.

% Print the bibliography
\printbibliography

\end{document}
```

### Compilation Sequence for Biblatex
1. `pdflatex mydocument.tex`
2. `biber mydocument` (Note: No extension)
3. `pdflatex mydocument.tex`
4. `pdflatex mydocument.tex`

Again, `latexmk -pdf` will handle this automatically.

### Best Practices
> [!check]
> Follow these tips for a smooth experience

- **Use a Reference Manager:** Don't create `.bib` files by hand. Use tools like **Zotero**, **Mendeley**, or **JabRef**.
- **Consistent Keys:** Develop a consistent naming scheme for your citation keys (e.g., `authorYear`).
- **Keep One `.bib` File:** For a given project, use a single, master `.bib` file.
- **Check Your Entries:** Ensure you use the correct `@ENTRY_TYPE` and that required fields are filled.
- **Back Up Your `.bib` File:** It's a valuable asset!
### Common Problems and Solutions
| Problem                                    | Cause                                                                  | Solution                                                                                                                                   |
| :----------------------------------------- | :--------------------------------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------- |
| **Citations show up as `[?]`**             | You didn't run BibTeX/Biber, or the citation key is misspelled.        | 1. Check spelling of the key in `\cite{}`. 2. Re-run the full compilation sequence.                                                        |
| **The bibliography doesn't appear**        | You didn't run BibTeX/Biber, or you forgot the bibliography command.   | 1. Ensure `\printbibliography` (`biblatex`) or `\bibliography{}` (BibTeX) is in your `.tex` file. 2. Re-run the full compilation sequence. |
| **A specific entry is missing**            | The entry has a syntax error (e.g., missing comma, mismatched braces). | Open your `.bib` file and carefully check the syntax of the missing entry. The `.log` file might contain warnings.                         |
| **Author names are formatted incorrectly** | You're not separating "First" and "Last" names correctly.              | Use `and` to separate authors: `author = {Lastname, Firstname and Otherauthor, Firstname}`.                                                |

# Best Practices & Tips
