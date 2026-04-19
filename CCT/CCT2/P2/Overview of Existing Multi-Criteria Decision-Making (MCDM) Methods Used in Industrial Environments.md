## Table of Contents

1. [[#Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments|Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments]]
	1. [[#Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments#Quick Reference Table|Quick Reference Table]]
	2. [[#Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments#1. Introduction|1. Introduction]]
		1. [[#1. Introduction#The Challenge of Modern Manufacturing Decision-Making|The Challenge of Modern Manufacturing Decision-Making]]
		2. [[#1. Introduction#Multi-Criteria Decision-Making (MCDM) as a Solution|Multi-Criteria Decision-Making (MCDM) as a Solution]]
		3. [[#1. Introduction#The Role of Flexibility and Adaptation|The Role of Flexibility and Adaptation]]
		4. [[#1. Introduction#Scope and Organization of This Review|Scope and Organization of This Review]]
	3. [[#Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments#2. Materials and Methods|2. Materials and Methods]]
		1. [[#2. Materials and Methods#2.1. Multi-Criteria Decision Making (MCDM)|2.1. Multi-Criteria Decision Making (MCDM)]]
			1. [[#2.1. Multi-Criteria Decision Making (MCDM)#Characteristics of MCDM Problems|Characteristics of MCDM Problems]]
			2. [[#2.1. Multi-Criteria Decision Making (MCDM)#Historical Development|Historical Development]]
			3. [[#2.1. Multi-Criteria Decision Making (MCDM)#Commonly Used MCDM Methods|Commonly Used MCDM Methods]]
			4. [[#2.1. Multi-Criteria Decision Making (MCDM)#Method Descriptions|Method Descriptions]]
		2. [[#2. Materials and Methods#2.2. MCDM Methods in Different Manufacturing Industries|2.2. MCDM Methods in Different Manufacturing Industries]]
			1. [[#2.2. MCDM Methods in Different Manufacturing Industries#Industry-Specific Applications|Industry-Specific Applications]]
		3. [[#2. Materials and Methods#2.3. Existing Methodologies Using MCDM Methods for Technological Process Evaluation|2.3. Existing Methodologies Using MCDM Methods for Technological Process Evaluation]]
			1. [[#2.3. Existing Methodologies Using MCDM Methods for Technological Process Evaluation#Identified Methodological Approaches|Identified Methodological Approaches]]
			2. [[#2.3. Existing Methodologies Using MCDM Methods for Technological Process Evaluation#Common Limitations of Existing Methodologies|Common Limitations of Existing Methodologies]]
		4. [[#2. Materials and Methods#2.4. Patents Using MCDM Methods for Technological Process Evaluation|2.4. Patents Using MCDM Methods for Technological Process Evaluation]]
			1. [[#2.4. Patents Using MCDM Methods for Technological Process Evaluation#Patent Analysis|Patent Analysis]]
			2. [[#2.4. Patents Using MCDM Methods for Technological Process Evaluation#Patent Comparison and Analysis|Patent Comparison and Analysis]]
	4. [[#Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments#3. Results|3. Results]]
		1. [[#3. Results#3.1. Analysis of MCDM Methods|3.1. Analysis of MCDM Methods]]
			1. [[#3.1. Analysis of MCDM Methods#Objective Comparison Metrics|Objective Comparison Metrics]]
			2. [[#3.1. Analysis of MCDM Methods#Comparative Advantages and Disadvantages|Comparative Advantages and Disadvantages]]
			3. [[#3.1. Analysis of MCDM Methods#Industrial Application Domains|Industrial Application Domains]]
			4. [[#3.1. Analysis of MCDM Methods#Summary of MCDM Method Analysis|Summary of MCDM Method Analysis]]
			5. [[#3.1. Analysis of MCDM Methods#FUCOM Application Analysis|FUCOM Application Analysis]]
		2. [[#3. Results#3.2. Analysis of the Reviewed Patents and Methodologies Used|3.2. Analysis of the Reviewed Patents and Methodologies Used]]
			1. [[#3.2. Analysis of the Reviewed Patents and Methodologies Used#Common Patterns and Differences|Common Patterns and Differences]]
			2. [[#3.2. Analysis of the Reviewed Patents and Methodologies Used#Quantitative Patent Evaluation|Quantitative Patent Evaluation]]
			3. [[#3.2. Analysis of the Reviewed Patents and Methodologies Used#Technical Orientation Spectrum|Technical Orientation Spectrum]]
	5. [[#Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments#4. Discussion|4. Discussion]]
		1. [[#4. Discussion#4.1. Discussions|4.1. Discussions]]
			1. [[#4.1. Discussions#Potential for Automation Integration|Potential for Automation Integration]]
			2. [[#4.1. Discussions#Method Selection Framework|Method Selection Framework]]
			3. [[#4.1. Discussions#Supporting Decision Table|Supporting Decision Table]]
			4. [[#4.1. Discussions#Patent and Methodology Insights|Patent and Methodology Insights]]
			5. [[#4.1. Discussions#Barriers to Wider Adoption|Barriers to Wider Adoption]]
		2. [[#4. Discussion#4.2. Future Directions and Challenges|4.2. Future Directions and Challenges]]
			1. [[#4.2. Future Directions and Challenges#Standardization and Software Development|Standardization and Software Development]]
			2. [[#4.2. Future Directions and Challenges#Dynamic MCDM for Industry 4.0|Dynamic MCDM for Industry 4.0]]
			3. [[#4.2. Future Directions and Challenges#Hybrid MCDM Approaches|Hybrid MCDM Approaches]]
			4. [[#4.2. Future Directions and Challenges#The Role of Artificial Intelligence|The Role of Artificial Intelligence]]
			5. [[#4.2. Future Directions and Challenges#FUCOM as Foundation for Innovation|FUCOM as Foundation for Innovation]]
	6. [[#Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments#5. Conclusions|5. Conclusions]]
		1. [[#5. Conclusions#Integration with Emerging Technologies|Integration with Emerging Technologies]]
		2. [[#5. Conclusions#The Role of Expert Judgment|The Role of Expert Judgment]]
		3. [[#5. Conclusions#Diversity of Approaches|Diversity of Approaches]]
		4. [[#5. Conclusions#Ongoing Challenges|Ongoing Challenges]]
		5. [[#5. Conclusions#Method Selection Guidelines|Method Selection Guidelines]]
		6. [[#5. Conclusions#The FUCOM Opportunity|The FUCOM Opportunity]]
		7. [[#5. Conclusions#Future Research Directions|Future Research Directions]]
		8. [[#5. Conclusions#Final Perspective|Final Perspective]]

# Overview of Multi-Criteria Decision-Making (MCDM) Methods in Industrial Environments

## Quick Reference Table

| **MCDM Method** | **Full Name** | **Key Feature** | **Pairwise Comparisons** | **Complexity** | **Best Used For** |
|---|---|---|---|---|
| **AHP** | Analytic Hierarchy Process | Hierarchical structure with consistency check | $\frac{n(n-1)}{2}$ | Medium | Structured hierarchical problems |
| **ANP** | Analytic Network Process | Network structure with interdependencies | $\frac{n(n-1)}{2}$ per cluster | High | Problems with criteria dependencies |
| **FUCOM** | Full Consistency Method | Minimal comparisons, full consistency | $n-1$ | Low | Multiple criteria, limited expert time |
| **TOPSIS** | Technique for Order Preference by Similarity to Ideal Solution | Distance to ideal/anti-ideal solution | 0 | Low | Quick ranking of many alternatives |
| **VIKOR** | Višekriterijumsko Kompromisno Rangiranje | Compromise solution approach | 0 | Low | Balancing conflicting criteria |
| **BWM** | Best Worst Method | Structured optimal/worst comparisons | $2n-3$ | Low | Reducing comparison burden |
| **SAW** | Simple Additive Weighting | Linear weighted sum | 0 | Very Low | Known weights, quantifiable criteria |
| **FAHP** | Fuzzy AHP | AHP with fuzzy logic for uncertainty | $\frac{n(n-1)}{2}$ | High | Uncertain or subjective evaluations |

**Key Symbols:**
- **$n$** : Number of criteria being evaluated
- **PIS** : Positive Ideal Solution (best possible values across all criteria)
- **NIS** : Negative Ideal Solution (worst possible values across all criteria)

---

## 1. Introduction

>[!abstract] Context and Motivation
>In today's complex and dynamic manufacturing markets, companies face constant pressure to optimize processes while balancing high quality, low cost, and rapid production. The selection of appropriate technological processes has become critical for achieving competitiveness, yet increasingly difficult due to the need to satisfy multiple, often conflicting criteria simultaneously.

### The Challenge of Modern Manufacturing Decision-Making

Manufacturing professionals encounter daily decisions spanning strategic planning to operational process management. The selection of rational technological processes is particularly crucial because it directly impacts:

- **Product Quality**: Final product characteristics and reliability
- **Production Efficiency**: Cycle times, throughput, and resource utilization  
- **Competitive Position**: Market responsiveness and cost competitiveness
- **Sustainability**: Environmental impact and long-term viability

>[!important] The Complexity Problem
>With modernization and increasing market demands, process selection has become more complex due to the need to balance multiple criteria such as cost, lead time, quality, material characteristics, equipment limitations, and customer requirements. Traditional single-criterion optimization is no longer sufficient.

### Multi-Criteria Decision-Making (MCDM) as a Solution

MCDM methods provide structured, reliable approaches to assist in selection decisions by:

1. **Evaluating multiple criteria** simultaneously with different units and scales
2. **Ranking alternatives** based on systematic comparison
3. **Assigning importance weights** that reflect organizational priorities
4. **Providing transparency** and justification for decisions

>[!info] What Makes MCDM Methods Valuable
>MCDM methods evaluate, rank, and assign importance to predetermined criteria, providing a reliable and structured approach to solving specific problems or tasks. This enables professionals to make rational and justified decisions that reflect priorities set at the outset, rather than relying on intuition or incomplete analysis.

### The Role of Flexibility and Adaptation

The flexibility of production processes influences the implementation of different methodologies in real conditions. With dynamic market changes, Industry 4.0 integration, and evolving customer demands, companies must continuously adapt. Delays in integration or poor technological process selections can result in:

- Low-quality production
- Damaged manufacturer reputation  
- Compromised competitiveness

>[!warning] Consequences of Ignoring MCDM Approaches
>Making gaps in technological process development or selecting incorrect processes due to inadequate decision-making frameworks may damage the manufacturer's reputation and put competitiveness in doubt. This is particularly critical as production systems become more complex and interconnected.

### Scope and Organization of This Review

This review article investigates existing methodologies and patents related to optimization and decision-making in manufacturing environments. The purpose is to provide a **systematic review and evaluation** of main MCDM methods used in industrial practice, including analysis of relevant methodologies and patents.

The methodology involves a structured literature and patent review, focusing on applications of widely used MCDM techniques:

- **AHP** (Analytic Hierarchy Process)
- **ANP** (Analytic Network Process)  
- **FUCOM** (Full Consistency Method)
- **TOPSIS** (Technique for Order Preference by Similarity to Ideal Solution)
- **VIKOR** (Višekriterijumsko Kompromisno Rangiranje)
- **BWM** (Best Worst Method)
- **SAW** (Simple Additive Weighting)
- **Fuzzy variants** (FAHP, FRADAR)

>[!note] Literature Selection Criteria
>Literature sources and patents were selected based on relevance to MCDM methods applied in manufacturing and processing industries. Publications were identified through Scopus, Web of Science, and Google Scholar using keywords including "MCDM", "AHP", "FUCOM", "process optimization", and "manufacturing systems". Priority was given to peer-reviewed articles from the last 10 years, widely cited fundamental papers, and patents with industrial applications. Over 200 sources were included to ensure depth and diversity.

The review is organized into three main steps:

**Step 1—Overview of Existing Situation**: Collection of data and information on existing MCDM methods, methodologies, and patents implementing these methods.

**Step 2—Analysis of Methods**: Analysis of similarities and differences between methods, along with their advantages and disadvantages.

**Step 3—Challenges and Future Directions**: Summary of main conclusions and suggestions for future research and development in MCDM, with focus on technological process optimization applications.

---

## 2. Materials and Methods

### 2.1. Multi-Criteria Decision Making (MCDM)

>[!info] Definition: MCDM Methods
>MCDM methods represent a structured set of analytical techniques designed to support informed decision-making in complex or uncertain environments. They facilitate evaluation and selection among multiple alternatives (e.g., manufacturing processes, equipment, materials) based on diverse criteria that can often overlap, conflict, or be very similar in importance.

#### Characteristics of MCDM Problems

MCDM methods are particularly valuable in manufacturing due to their ability to systematically balance multiple and conflicting factors. These criteria may include:

- **Quantitative aspects**: Cost, time, dimensional accuracy, production rate
- **Qualitative aspects**: Quality perception, sustainability, operator safety, flexibility
- **Mixed units**: Criteria measured in different units (currency, time, percentages, ratings)

#### Historical Development

Some of the first MCDM methods emerged in the mid-20th century. Since then, a variety of techniques have been developed in response to specific practical and theoretical problems involving multi-criteria optimization such as:

- Optimization of production processes
- Cost-effective resource management
- Adaptation to changing conditions
- Integration with emerging technologies

![[Timeline of MCDM Methods.png]]
_Figure 2.1: Timeline showing the development of MCDM methods from mid-20th century to present, highlighting key moments including emergence of AHP in 1980s, expansion to ANP, and introduction of newer methods such as FUCOM and BWM._

The timeline illustrates how new methods build upon previous ones and adapt to evolving industrial needs. Each generation of methods addresses limitations identified in earlier approaches while introducing new capabilities.

#### Commonly Used MCDM Methods

![[Commonly Used MCDM Methods.png]]
_Figure 2.2: Classification of the most commonly used MCDM methods in manufacturing environments._

>[!example] Why These Eight Methods Were Selected
>The eight MCDM methods featured in this review were chosen based on:
>- Widespread use in recent manufacturing literature
>- Coverage in recent comparative methodological studies  
>- Balance between traditional (AHP), advanced (ANP, FUCOM), and computationally efficient (BWM) approaches
>- Demonstrated industrial applications across multiple sectors

#### Method Descriptions

**1. Analytic Hierarchy Process (AHP)**

>[!info] AHP Fundamentals
>The AHP is one of the first and most widely used MCDM methods, developed in the 1980s. The method structures complex decisions by building a hierarchical structure in which the main goal is broken down into sub-goals, criteria, and sub-criteria.

The AHP applies **pairwise comparisons** between criteria, calculating the relative weight of each and evaluating different alternatives based on the resulting weights. The method is used for solving complex problems through clear and consistent organization that supports optimal variant selection through systematic analysis.

**Key Features:**
- Hierarchical decomposition of problem
- Pairwise comparison using ratio scale (1-9)
- Consistency checking through Consistency Ratio (CR)
- Transparent and justifiable decision process

>[!example] AHP Application Example
>When selecting a machining center, the main goal (select best machine) is broken into criteria:
>- Technical capability (40% weight)
>   - Precision (60% of technical)
>   - Power (40% of technical)
>- Economic factors (35% weight)
>   - Purchase cost
>   - Operating cost
>- Flexibility (25% weight)
>
>Each machine is then compared pairwise on each lowest-level criterion, and scores are aggregated using the calculated weights.

**2. Fuzzy AHP (FAHP)**

>[!info] FAHP Fundamentals  
>The FAHP is an MCDM method that combines the traditional AHP with fuzzy logic. This method allows for handling uncertainty and subjectivity in expert estimates by using fuzzy numbers instead of exact values.

This is particularly useful when expert opinions are unclear or when criteria cannot be accurately and quantitatively assessed. By using degrees of membership, FAHP allows more flexible expression of preferences.

**Key Concept: Fuzzy Logic**

In traditional logic, an element belongs or does not belong to a set (binary membership). In FAHP, fuzzy logic uses numerical values between 0 and 1, allowing for more flexible reflection or approximation to reality.

>[!example] Fuzzy Number Representation
>Instead of saying "Machine A is exactly 2 times better than Machine B" (crisp AHP), FAHP allows:
>
>**Machine A is approximately 2 times better** = triangular fuzzy number $(1.5, 2.0, 2.5)$
>
>This represents:
>- Most likely value: 2.0
>- Pessimistic bound: 1.5  
>- Optimistic bound: 2.5
>
>Expert opinions are represented more realistically, reducing the influence of arbitrary precision.

**3. Analytic Network Process (ANP)**

>[!info] ANP Fundamentals
>The ANP is an extension of the AHP method. While AHP models decision problems through a hierarchical structure with unidirectional relationships, ANP allows for more complex interactions through a network structure where elements can have mutual dependencies and inverse relationships.

The traditional AHP is limited in modeling interdependencies as it assumes independence between hierarchy levels and between elements at a given level. ANP overcomes these limitations by implementing a network structure that allows complex dependencies and feedback to be modeled.

**Network Structure Advantage:**

The main idea of ANP is to capture mutual influence between criteria and alternatives using a **super matrix** that represents all possible dependencies. By raising the super matrix to the degree necessary to reach convergence, stable item priorities are obtained.

>[!example] When ANP Is Needed Over AHP
>Consider selecting manufacturing equipment where:
>- **Cost** influences and is influenced by **Maintenance Requirements**  
>- **Precision** capability affects **Production Speed** (more precise = slower)
>- **Operator Training** needs depend on **Technology Complexity**
>- **Environmental Impact** is affected by **Energy Consumption**
>
>These circular dependencies cannot be properly modeled in AHP's strict hierarchy but are naturally captured in ANP's network structure.

**4. Technique for Order Preference by Similarity to Ideal Solution (TOPSIS)**

>[!info] TOPSIS Fundamentals
>The TOPSIS method is based on the concept that the best alternative is the one that is closest to the ideal solution (Positive Ideal Solution, PIS) and farthest from the non-ideal solution (Negative Ideal Solution, NIS). This method is characterized by its simplicity, logical clarity, and ability to handle a large number of criteria and alternatives.

**Core Concepts:**

- **Ideal Solution (PIS)**: A hypothetical alternative with the best possible values for all criteria (maximizing favorable criteria and minimizing unfavorable criteria)
- **Non-Ideal Solution (NIS)**: A hypothetical alternative with the worst possible values for all criteria

The method calculates geometric distances from each alternative to both PIS and NIS, then ranks alternatives based on relative closeness to the ideal.

>[!example] TOPSIS Calculation Steps
>**Step 1**: Normalize decision matrix  
>**Step 2**: Apply criterion weights to normalized matrix  
>**Step 3**: Identify PIS and NIS for each criterion  
>**Step 4**: Calculate Euclidean distance of each alternative to PIS and NIS  
>
>For 3 alternatives with 2 criteria:
>- Alternative A: $d^+ = 0.3$, $d^- = 0.7$ → Closeness = $\frac{0.7}{0.3+0.7} = 0.70$
>- Alternative B: $d^+ = 0.5$, $d^- = 0.5$ → Closeness = $\frac{0.5}{0.5+0.5} = 0.50$  
>- Alternative C: $d^+ = 0.8$, $d^- = 0.2$ → Closeness = $\frac{0.2}{0.8+0.2} = 0.20$
>
>**Ranking**: A > B > C

**5. Best Worst Method (BWM)**

>[!info] BWM Fundamentals
>The BWM is an efficient and innovative method for determining the weights of criteria in MCDM. By reducing the number of comparisons required and increasing the consistency of scores, BWM facilitates the decision-making process and improves the reliability of results.

**Structured Comparison Approach:**

Unlike AHP which requires $\frac{n(n-1)}{2}$ comparisons, BWM requires only $2n-3$ comparisons:
1. Decision maker identifies **best** (most important) criterion
2. Decision maker identifies **worst** (least important) criterion  
3. Best criterion is compared to all others
4. All criteria are compared to worst criterion

This structured approach reduces cognitive burden while maintaining consistency.

>[!example] BWM Comparison Reduction
>For 5 criteria:
>- **AHP requires**: $\frac{5 \times 4}{2} = 10$ pairwise comparisons
>- **BWM requires**: $(2 \times 5) - 3 = 7$ comparisons
>
>For 10 criteria:
>- **AHP requires**: $\frac{10 \times 9}{2} = 45$ comparisons
>- **BWM requires**: $(2 \times 10) - 3 = 17$ comparisons
>
>The difference becomes dramatic as $n$ increases, significantly reducing expert fatigue and inconsistency risk.

**6. Simple Additive Weighting (SAW) Method**

>[!info] SAW Fundamentals
>The SAW method, also known as linear weighted summation, is preferred for its simplicity, intuitiveness, and ease of application in various fields. This method is based on evaluating alternatives by adding up their weighted values according to different criteria.

**Core Assumption:**

SAW assumes **linear compensation** between criteria—lower scores on one criterion can be compensated by higher scores on others. This is the main basis of the method, making it particularly suitable for situations where:
- Criteria are independent
- Criteria are quantitatively measurable
- Trade-offs between criteria are acceptable

**Calculation:**
$$\text{Score}_i = \sum_{j=1}^{n} w_j \cdot r_{ij}$$

**Breakdown:**
- $\text{Score}_i$ : Overall score for alternative $i$
- $w_j$ : Weight of criterion $j$ (sum of all weights = 1)
- $r_{ij}$ : Normalized rating of alternative $i$ on criterion $j$
- $n$ : Total number of criteria

>[!example] SAW Application
>Three suppliers evaluated on 3 criteria (weights in parentheses):
>
>| Supplier | Cost (0.5) | Quality (0.3) | Delivery (0.2) | **Total Score** |
>|---|---|---|---|---|
>| A | 0.8 | 0.6 | 0.9 | $(0.5×0.8)+(0.3×0.6)+(0.2×0.9) = 0.76$ |
>| B | 0.6 | 0.9 | 0.7 | $(0.5×0.6)+(0.3×0.9)+(0.2×0.7) = 0.71$ |
>| C | 0.9 | 0.5 | 0.6 | $(0.5×0.9)+(0.3×0.5)+(0.2×0.6) = 0.72$ |
>
>**Ranking**: A (0.76) > C (0.72) > B (0.71)

**7. Višekriterijumsko Kompromisno Rangiranje (VIKOR)**

>[!info] VIKOR Fundamentals
>VIKOR is designed to make complex tasks easier and faster to solve. It is based on compromise solution theory, thus balancing among conflicting criteria. By providing a structured approach to evaluate and rank criteria under consideration, it is able to quickly derive solutions to problems.

VIKOR is suitable when the expert desires a solution that most closely approximates the ideal outcome while accepting compromise on some criteria.

**Compromise Solution Concept:**

VIKOR introduces a ranking index $Q$ that represents the distance to the ideal solution, calculated using a strategy parameter $v$ that determines the weight of maximum group utility versus individual regret:

$$Q_i = v \frac{S_i - S^*}{S^- - S^*} + (1-v) \frac{R_i - R^*}{R^- - R^*}$$

**Breakdown:**
- $Q_i$ : Compromise ranking index for alternative $i$
- $S_i$ : Weighted sum of normalized distances (group utility)
- $R_i$ : Maximum weighted distance (individual regret)
- $S^*, R^*$ : Best values of $S$ and $R$
- $S^-, R^-$ : Worst values of $S$ and $R$
- $v$ : Strategy weight (typically 0.5 for balanced compromise)

>[!example] VIKOR Compromise Ranking
>For 3 manufacturing processes with calculated values:
>
>| Process | $S$ (Group Utility) | $R$ (Max Regret) | $Q$ (v=0.5) | Rank |
>|---|---|---|---|---|
>| A | 0.2 | 0.1 | 0.15 | **1** (Best) |
>| B | 0.5 | 0.3 | 0.40 | 2 |
>| C | 0.8 | 0.7 | 0.75 | 3 |
>
>Process A offers the best compromise—good on both group utility and individual worst-case performance.

**8. Full Consistency Method (FUCOM)**

>[!info] FUCOM Fundamentals
>The FUCOM is an accurate and efficient MCDM method for determining criteria weights. By minimizing biases and ensuring complete consistency of expert evaluations, FUCOM provides reliable results, significantly improving the quality of decision-making.

**Key Advantages:**
- Requires only $n-1$ comparisons (minimal among all methods)
- Ensures mathematical consistency through optimization
- Transparent and easy for experts to understand
- Particularly suitable for problems with many criteria and limited expert time

![[FUCOM Implementation Steps.png]]
_Figure 2.3: Step-by-step implementation sequence of the FUCOM method, showing the logical, systematic approach ensuring high reliability and consistency in the decision-making process._

**FUCOM Process:**

1. **Rank criteria** from most to least important
2. **Compare adjacent criteria** in the ranking (only $n-1$ comparisons)
3. **Calculate optimal weights** using mathematical optimization that minimizes deviations from full consistency
4. **Verify full consistency** automatically through the optimization model

>[!example] FUCOM Comparison Efficiency
>For 6 criteria in technological process selection:
>
>**Step 1 - Ranking**: Quality > Cost > Time > Flexibility > Energy > Maintenance
>
>**Step 2 - Adjacent Comparisons** (only 5 needed):
>- Quality vs. Cost = 1.5 (Quality 1.5× more important)
>- Cost vs. Time = 1.3
>- Time vs. Flexibility = 1.2  
>- Flexibility vs. Energy = 1.1
>- Energy vs. Maintenance = 1.0
>
>**Step 3 - Optimization** calculates consistent weights:
>Quality (0.28), Cost (0.19), Time (0.15), Flexibility (0.12), Energy (0.11), Maintenance (0.11)
>
>**Comparison**: AHP would require $\frac{6×5}{2} = 15$ comparisons for same problem.

**9. Fuzzy RADAR (FRADAR)**

>[!info] FRADAR Fundamentals
>FRADAR is an MCDM method integrating fuzzy logic to enhance the Process Failure Mode and Effects Analysis (PFMEA). It addresses uncertainties in expert judgments using fuzzy sets and evaluates criteria such as Action Priority (AP), Risk Priority Number (RPN), cost effectiveness, resolution time, and production impacts.

**Key Applications:**
- Automotive industry risk assessment
- Failure prioritization under uncertainty
- Team composition and candidate skills evaluation  
- Multidisciplinary risk management scenarios

**Extension**: Can be enhanced using **Interval-Valued Pythagorean Fuzzy Numbers (IPF-RADAR)**, offering deeper flexibility and accuracy in evaluating team composition and candidate skills, enhancing objectivity in multidisciplinary risk management scenarios.

>[!tip] When to Use FRADAR
>FRADAR is particularly valuable for automotive industry applications requiring precise risk assessment and failure prioritization, especially when expert judgments are inherently uncertain and multiple risk dimensions must be balanced.

---

### 2.2. MCDM Methods in Different Manufacturing Industries

MCDM methods are applied in various industries, where they simplify complex decision-making problems and support process optimization. Various complex tasks arise during workflow, and the main role of these methods is to help provide solutions. With their assistance, specialists are able to compare different alternatives with multiple criteria of varying importance such as cost, quality, lead time, etc.

>[!important] MCDM as Sustainable Engineering Tools
>According to research, MCDM methods are particularly useful in optimizing engineering projects in major industries such as construction and infrastructure, energy, transportation, logistics, and supply chain management. In sustainable engineering, complex situations are often encountered where balance between economic benefits, environmental impact, social aspects, and engineering requirements must be achieved.

![[MCDM Methods Across Industries.png]]
_Figure 2.4: Connections between different manufacturing industries using MCDM methods, showing the relationship between production stages (process management, resource management, quality control, risk management, product development) and industrial sectors (automotive, electronics, chemical, energy, mechanical engineering, etc.)._

The diagram emphasizes that MCDM methods are not limited to a single field but have wide scope, proving their adaptability and applicability in solving a variety of engineering and management problems.

#### Industry-Specific Applications

**Automotive Industry**

In the automotive industry, MCDM methods are used to:
- Select suitable suppliers (offering best price/quality/delivery time ratio)
- Select materials for individual vehicle components
- Optimize manufacturing processes  
- Evaluate assembly line configurations

>[!example] Automotive Supplier Selection
>A car manufacturer uses AHP to select battery suppliers by evaluating:
>- Technical capability (35%): Energy density, charging speed, lifespan
>- Cost factors (30%): Unit price, volume discounts, total cost of ownership
>- Reliability (25%): Defect rate, on-time delivery, financial stability
>- Sustainability (10%): Carbon footprint, recycling program, ethical sourcing

**Electronics and Electrical Engineering**

MCDM methods are used to:
- Manage complex supply chains (often involving international partners)
- Select components and materials
- Optimize assembly processes
- Evaluate technology alternatives

**Mechanical Engineering**

As the backbone of industrial manufacturing, mechanical engineering often faces challenges related to selection of technologies, materials, and processes. MCDM methods support:

- **Process optimization**: Turning, milling, drilling parameter selection
- **Machine selection**: Preventing increased costs, reduced efficiency, and loss of competitiveness through systematic evaluation
- **Technology selection**: Balancing technical and economic criteria

>[!warning] Consequences of Incorrect Machine Selection
>Incorrect machine selection can lead to:
>- Increased costs (purchase, operation, maintenance)
>- Reduced efficiency (throughput, quality, flexibility)  
>- Loss of competitiveness (inability to meet customer requirements)

**Chemical Industry**

MCDM methods in the chemical industry are used to:
- Select optimal catalysts
- Select raw materials
- Engineer energy-efficient processes
- Manage hazardous waste disposal (particularly in healthcare sector)

>[!note] Chemical Industry Challenges
>One of the main challenges of MCDM in chemical engineering is the complexity of processes, which requires integration of different methods for normalization, criteria weighting, and analysis of results.

**Resource Management Industries**

For companies to minimize waste and aim for sustainability, effective management of resources is essential. MCDM methods provide approaches for choosing among alternatives in the use of:

- **Natural resources**: Raw material sourcing, extraction methods
- **Energy resources**: Power generation, distribution, efficiency
- **Material resources**: Recycling, reuse, circular economy

Resource management is particularly important for:
- Metallurgy
- Textile industry
- Energy sector
- Engineering
- Agriculture

>[!example] Energy Sector Application
>Power companies use MCDM methods to optimize energy efficiency, select sustainable materials, and manage water resources, with the primary goal of utilizing natural resources responsibly, maximally, and sustainably.

**Quality Control and Risk Management Industries**

Quality control and risk management are essential to ensure product safety, reliability, and compliance with standard requirements. MCDM-based analytical tools are used to:

- Assess risks
- Implement targeted quality improvement strategies
- Ensure safety and durability
- Evaluate component reliability

**Key Industries:**
- Aerospace (risk assessment, component reliability)
- Chemical (process safety, hazard management)
- Construction (material selection, technique evaluation)

**Information Technology and System Analysis**

MCDM methods (LBWA and SAW) are focused on:
- Selecting appropriate standards for modeling business processes
- Comparing and ranking modeling standards (DFD, IDEF0, IDEF3, BPMN)
- Supporting effective decision-making and process optimization

This allows system analysts and management to determine the most appropriate standard according to specific criteria and organizational needs.

**Product Development and Innovation**

In recent years, MCDM methods have been implemented to support strategic decisions related to:
- Selection of new technologies
- Material selection
- Feature prioritization
- Competitive product creation
- Meeting demands of dynamically changing markets

---

### 2.3. Existing Methodologies Using MCDM Methods for Technological Process Evaluation

>[!warning] Common Problem in Process Development
>In technological process development, especially when carried out by beginner technologists with insufficient practical experience, it is common to see development of different technological processes that can lead to incorrect decisions. These can negatively affect the selection of rational technological processes by focusing on less important features of the part instead of key aspects.

#### Identified Methodological Approaches

**1. Complexity and Criteria Balancing**

The complexity of process design and the need to balance between multiple criteria have led researchers to propose structured methodologies to assist specialist technologists in the decision-making process.

**2. Additive Manufacturing Methodology**

A specialized methodology for selection of technological processes in additive manufacturing has been presented. The methodology is particularly useful in early design stages, allowing early identification and preventing potential errors.

>[!warning] Limitation
>Despite its advantages, this methodology is unsuitable for traditional manufacturing processes, which are quite different from additive manufacturing.

**3. Rational Design Selection Methodology**

A methodology for rational design selection involving purposeful sample surveys has been presented. This methodology highlights the importance of integration between different aspects of the technological process:
- Materials science
- Engineering
- Manufacturing technology

>[!note] Resource Requirements
>Application of the methodology requires significant resources:
>- Time investment for data collection
>- Financial resources for conducting more in-depth research
>
>However, it offers a summary result for technological process selection, taking into account many criteria considered.

**4. AHP-Based Lean Manufacturing Methodology**

The AHP allows different criteria to be systematized and relative weights determined in the decision-making process. The methodology enables:
- Objective comparison of several alternative concepts
- Assistance to teams in making strategic decisions related to lean manufacturing
- Support for managers in deciding on lean concepts

**5. Production Process Evaluation and Modeling Methodology**

A methodology for evaluating and modeling production processes focuses on improving their evaluation and management through:
- Information flows analysis
- Interactions between different departments
- Individual stages of production

>[!warning] Complexity Limitation
>The methodology has great potential, but its complexity is a major obstacle for implementation in production processes. This particularly impacts:
>- Smaller enterprises
>- Organizations with limited technological resources
>- Companies lacking qualified staff and infrastructure investment capability

**6. Casting Process Evaluation Methodology**

A methodology evaluates different technological processes for workpieces produced by casting. The approach compares different MCDM methods (TOPSIS, VIKOR, AHP) and analyzes the most suitable method for application.

**Related Applications:**
- Selection of metal cutting tools using MCDM methods
- Selection of milling machines using MCDM methods  
- Selection of cutting parameters in machining

**7. Tool Selection Method Using Prediction Procedures**

A method for rational selection of machining tools using prediction procedures through the "Objective Tree" creates prerequisites for developing competitive products. The selection of appropriate tools is facilitated, encouraging development in design and production.

**8. Digital Supply Chain Supplier Selection Methodology**

An advanced methodology for supplier selection in digital supply chains of e-commerce platforms, based on extended VIKOR approach using Interval-Valued Intuitionistic Fuzzy Numbers (IVIFNs).

**Key Features:**
- Addresses challenges of uncertainty in dynamic digital environments
- Handles conflicting criteria
- Demonstrates practical applicability in real-world industrial scenarios
- Complements broader MCDM use in sustainable engineering and logistics

>[!important] Universal Methodology Gap
>Although there are a variety of methodologies and methods for technological process design and optimization, many have limitations that prevent widespread application. No methodology effectively integrates quantitative analyses with comprehensive consideration of technical and economic aspects while remaining adaptable to dynamic market requirements.

#### Common Limitations of Existing Methodologies

1. **Limited Scope**: Most methodologies have been developed for specific types of processes or industries, narrowing their applicability to wider range of manufacturing contexts

2. **Incomplete Integration**: No methodology effectively integrates quantitative analyses with comprehensive consideration of technical and economic aspects

3. **Lack of Adaptability**: The dynamic nature of market requirements and technological advances requires methodologies that can adapt quickly to change; many existing methodologies do not meet this requirement

4. **Resource Constraints**: The need to balance different criteria, limitations in resources, and specific needs of production require more flexible and adaptable solutions

>[!tip] Future Methodology Requirements
>Methodologies that use multi-criteria analysis to support decision-making on process selection across different industries show potential for innovative approaches that can be adapted to current and future market requirements. Such solutions need to be:
>- Accessible to both large and small enterprises
>- Capable of ensuring high quality of final product
>- Supporting sustainability of production process in long term

---

### 2.4. Patents Using MCDM Methods for Technological Process Evaluation

This section examines patents that integrate MCDM methods into industrial decision-making systems, providing innovative approaches to technological process evaluation and optimization.

#### Patent Analysis

**Patent 1: Multilayer Digital Factory with Integrated MCDM**

>[!info] Patent Overview
>This invention offers an innovative and detailed method for digitalization of the manufacturing process that can significantly improve efficiency, management, and flexibility of enterprises. The patent uses a six-layer architecture combined with various simulation models to enable more efficient control and management of each stage of manufacturing processes.

**Architecture Approach:**

The system analyzes multiple criteria by processing and integrating data from different production levels. Based on considered criteria, the system adapts its solutions to the implemented architecture.

**Main Advantages:**
- Optimization of technological processes before actual application
- Identification of most effective solutions through simulations and analyses
- Reduction of costs and time associated with development and implementation
- Increased production efficiency and improved product quality

**Built-in Tools:**

Simulation and analysis of production processes using real production data show great potential. Companies can make informed and justified decisions by combining:
- Virtual process modeling
- Real-time data integration
- Multi-criteria optimization
- Adaptive control mechanisms

>[!example] Application Scenario
>A manufacturing enterprise implements the six-layer digital factory architecture:
>1. **Data Layer**: Collects real-time sensor data from machines
>2. **Model Layer**: Creates digital twins of production processes  
>3. **Analysis Layer**: Applies MCDM methods to evaluate alternatives
>4. **Simulation Layer**: Tests process changes virtually before implementation
>5. **Optimization Layer**: Identifies best solutions based on multiple criteria
>6. **Control Layer**: Implements optimized processes in production
>
>Result: 15% reduction in production costs, 20% improvement in efficiency before physical changes made.

**Patent 2: Computational Models for Manufacturing Process Monitoring**

>[!info] Patent Overview
>This methodology uses computational models providing detailed solutions for monitoring manufacturing processes. It incorporates combination of input data selection and optimization techniques with mechanism to evaluate performance of models used.

**Key Components:**
- Mahalanobis distance calculation for outlier detection
- Zeta-statistics for model reliability assessment
- Mathematical tools and algorithms for optimizing input parameters
- Performance evaluation mechanisms

**Benefits:**
- Increased reliability of models
- Better understanding and control in different industrial applications
- Enhanced process monitoring capability
- Improved anomaly detection

**Patent 3: Horizontal Structured Modeling of Manufacturing Processes**

>[!info] Patent Overview
>This patent describes horizontal structured modeling using logic algorithms and models for multi-criteria methods, providing tools for virtual modeling, simulation, and association of manufacturing characteristics. The method aims to improve efficiency of computer-aided design and manufacturing (CAD/CAM) by simplifying work with complex manufacturing models.

**Capabilities:**
- Virtual modeling and simulation of production processes
- Automated decision-making and optimization
- CAD/CAM integration with production processes
- Adaptive and efficient process control

This lays foundation for smarter and well-founded production planning, essential for success in today's environment.

**Patent 4: Differentiated Secondary Equipment Transformation Scheme Selection**

>[!info] Patent Overview
>A method for selecting differentiated secondary equipment transformation schemes based on usage history and associated specifications and standards. Creates structure consisting of scheme layer, criteria layer, and target layer.

**Methodology:**
- Quantification of indices using "fuzzy number theory"
- Weight determination using fuzzy theory
- Application to low-voltage electrical equipment (monitoring, control, regulation)

**Application Domain:**
Selection of differential transformation schemes for:
- Monitoring equipment
- Control systems
- Regulation devices

**Patent 5: Quantitative Assessment Tool for Resource Management**

>[!info] Patent Overview
>This patent presents a quantitative assessment tool combining theoretical MCDM method with standard life cycle analysis techniques and statistical methods to facilitate decision-making in resource management.

**Method Details:**

The underlying methodology applies the **AHP** method, which provides:
- Systematic and precise pairwise comparison of individual criteria
- Clear identification and quantification of relative importance
- Sound basis for decision-making

**Evaluation Process:**
1. Detailed information acquired on current system characteristics
2. Suggested alternative solutions documented
3. Each choice evaluated against predetermined criteria (scale 1-10)
4. Objective and reliable quantitative rating produced

**Applications:**
- Operational management
- Strategic planning
- Resource allocation
- Risk management

>[!example] Resource Management Application
>A facility manager uses this tool to select HVAC system upgrade:
>
>**Alternatives**: 3 different HVAC technologies
>**Criteria** (scale 1-10):
>- Energy efficiency
>- Initial cost
>- Maintenance requirements
>- Environmental impact
>- Installation complexity
>
>Each alternative scored by multiple experts, AHP calculates optimal weights, final ranking determines best technology considering all life cycle factors.

**Patent 6: Universal Sustainability Index Using PESTLE Factors**

>[!info] Patent Overview
>A system for calculating universal sustainability index using Political, Economic, Social, Technological, Legal, and Environmental (PESTLE) factors. The system evaluates different sites through data collection, creating universal sustainability value or numerical index.

**Process:**

1. **Data Collection**: Participants provide data through surveys, questions, tests, other sources
2. **Normalization**: Data normalized from 0 to 100, assigned positive or negative effect
3. **Weight Assignment**: Participants assign percentage weights to different criteria
4. **Voting**: Vote among participants determines final result
5. **Calculation**: Weighted values calculated (percentage weight × normalized value)
6. **Index Generation**: Weighted values for different criteria combined to generate overall "sustainability index"

>[!warning] Limitation
>Main disadvantage is use of multiple participants, which can lead to different estimates given the varying opinions of participants. This introduces potential inconsistency and subjectivity.

**Patent 7: Customer Service Capability Evaluation Method**

>[!info] Patent Overview
>This patent concentrates on different customer service opportunities of organizations, providing recommendations on different options. Creates method that is adaptable, repeatable, and can simplify analysis, processing, and collection of data related to customer service.

**Methodology Components:**
- Computer-generated surveys
- Rating formulas
- Graphs displaying weight scales
- Effective analysis of customer service capabilities

**Main Steps:**

1. **Initial Data Collection**: Interviews with executive directors, surveys
2. **Complex Criteria Application**: Evaluation and value assignment
3. **Secondary Data Collection**: Normalized through surveying subject matter experts (SMEs)
4. **Analysis and Prioritization**: Using analytical tools (evaluation formulas)

**Results Presentation:**
- Graphs
- Reports  
- Analyses providing overview of areas for organizational improvement

**Dominating Formula:** "Total Impact of Customer Service Improvement"

The patent describes processes and techniques to optimize customer service while elaborating on prioritizing improvement needs in organizational capabilities.

---

#### Patent Comparison and Analysis

| **Patent** | **MCDM Method** | **Primary Application** | **Key Innovation** | **Main Limitation** |
|---|---|---|---|---|
| Multilayer Digital Factory | Multiple/Integrated | Manufacturing digitalization | Six-layer architecture with real-time optimization | Requires extensive infrastructure and integration |
| Computational Process Monitoring | Statistical/Optimization | Process monitoring | Mahalanobis distance + Zeta-statistics | High computational complexity |
| Horizontal Structured Modeling | Logic algorithms | CAD/CAM integration | Virtual modeling before implementation | Limited to design phase applications |
| Secondary Equipment Selection | Fuzzy Theory | Electrical equipment | Fuzzy number quantification | Narrow application domain |
| Resource Management Tool | AHP | Life cycle analysis | Integration of LCA with MCDM | Requires detailed data for all alternatives |
| Sustainability Index (PESTLE) | Participant voting | Sustainability assessment | Holistic PESTLE framework | High participant subjectivity |
| Customer Service Evaluation | Weighted formulas | Service optimization | SME-based normalization | Dependent on expert availability |

_Table 2.1: Comparison of patents using MCDM methods for technological process evaluation._

>[!important] Common Themes Across Patents
>The systems and methodologies outlined in these patents illustrate:
>- Increasing contribution of digitization for future industrial businesses
>- Growing importance of advanced analytical methods
>- Potential for improving efficiency, reducing costs, and increasing competitiveness
>- Need for integration with existing manufacturing systems

>[!note] Selection Methodology Transparency
>Although this review did not strictly follow a PRISMA procedure, the approach to selection remained methodologically transparent and relevant, ensuring comprehensive coverage of MCDM applications in industrial patents.

---

## 3. Results

### 3.1. Analysis of MCDM Methods

Based on analysis of available literature, the main advantages and disadvantages of different MCDMs used in manufacturing environments and engineering applications are identified. The studied methodologies demonstrate significant differences in:

- How criteria weights are defined
- Level of complexity of application
- Adaptability to specific manufacturing conditions

#### Objective Comparison Metrics

Table 3.1 presents commonly used MCDM methods evaluated against objective, quantifiable metrics including:

- Number of pairwise comparisons required
- Computational complexity
- Presence of consistency metric (Consistency Ratio)
- Ability to handle interdependencies
- Applicability to multi-criteria evaluation

| **Method** | **Pairwise Comparisons** | **Computational Complexity** | **Consistency Metric** | **Handles Interdependencies** | **Multi-Criteria Evaluation** |
|---|---|---|---|---|
| **AHP** | $\frac{n(n-1)}{2}$ | Medium | Yes (CR) | No | Yes |
| **ANP** | $\frac{n(n-1)}{2}$ per cluster | High | Yes (CR) | Yes | Yes |
| **FUCOM** | $n-1$ | Low | Yes (Full consistency) | No | Yes |
| **TOPSIS** | 0 | Low | No | No | Yes |
| **VIKOR** | 0 | Low | No | No | Yes |
| **BWM** | $2n-3$ | Low | Yes (CR equivalent) | No | Yes |
| **SAW** | 0 | Very Low | No | No | Yes |
| **FAHP** | $\frac{n(n-1)}{2}$ | High | Yes (Fuzzy CR) | No | Yes |

_Table 3.1: Comparison of commonly used MCDM methods evaluated against objective application criteria._

**Breakdown of Table Metrics:**

- **$n$** : Number of criteria being evaluated
- **$\frac{n(n-1)}{2}$** : Formula for complete pairwise comparisons in AHP/ANP (e.g., 5 criteria = 10 comparisons, 10 criteria = 45 comparisons)
- **$n-1$** : FUCOM's minimal comparison requirement (e.g., 5 criteria = 4 comparisons, 10 criteria = 9 comparisons)
- **$2n-3$** : BWM's structured comparison requirement (e.g., 5 criteria = 7 comparisons, 10 criteria = 17 comparisons)
- **CR** : Consistency Ratio, metric to check logical consistency of expert judgments
- **Computational Complexity** : Relative processing time and resource requirements

>[!important] Trade-offs in Method Selection
>The data suggest an important exchange:
>- **Methods with few comparisons and low complexity** (FUCOM, BWM) reduce workload on experts but risk missing dependencies between criteria
>- **Methods addressing dependencies** (ANP) handle complex relationships but at cost of many comparisons and high complexity
>- **Lack of formal consistency metric** (TOPSIS, VIKOR, SAW) does not automatically mean invalidity but requires compensatory measures (e.g., sensitivity analysis of results to weights and normalization)

#### Comparative Advantages and Disadvantages

Table 3.2 presents a comparison of advantages and disadvantages of the most commonly used MCDM methods, based on Table 3.1 and in-depth comparative analysis from existing literature.

| **Method** | **Advantages** | **Disadvantages** |
|---|---|---|
| **AHP** | • Structured hierarchical approach<br>• Consistency checking (CR)<br>• Widely understood and accepted<br>• Transparent logic | • Many pairwise comparisons for large $n$<br>• Assumes criteria independence<br>• Rank reversal problem possible<br>• Expert judgment subjectivity |
| **ANP** | • Handles interdependencies and feedback<br>• Network structure reflects reality<br>• Consistency checking<br>• Captures complex relationships | • Very high number of comparisons<br>• Computationally intensive<br>• Difficult for non-experts<br>• Requires deep problem understanding |
| **FUCOM** | • Minimal comparisons ($n-1$)<br>• Full mathematical consistency<br>• Transparent and intuitive<br>• Low computational complexity | • Cannot model interdependencies<br>• Requires clear criteria ranking<br>• Relatively new (less validation)<br>• Dependent on expert ranking |
| **TOPSIS** | • Simple and fast<br>• Handles many alternatives easily<br>• Intuitive concept (ideal solution)<br>• Low computational cost | • No consistency check<br>• Sensitive to normalization method<br>• Sensitive to extreme values<br>• Requires predefined weights |
| **VIKOR** | • Provides compromise solution<br>• Considers group utility and regret<br>• Handles conflicting criteria well<br>• Strategy parameter flexibility | • No consistency check<br>• Sensitive to normalization<br>• Strategy parameter choice subjective<br>• Requires predefined weights |
| **BWM** | • Fewer comparisons than AHP<br>• Structured best-worst approach<br>• Consistency checking<br>• Reduces cognitive load | • Relatively new method<br>• Still requires expert judgment<br>• Cannot handle interdependencies<br>• Best/worst identification subjective |
| **SAW** | • Extremely simple<br>• Very fast computation<br>• Easy to understand and explain<br>• Transparent calculations | • Assumes linear compensation<br>• No consistency check<br>• Requires predefined weights<br>• Assumes criteria independence<br>• Sensitive to scale |
| **FAHP** | • Handles uncertainty well<br>• Captures vagueness in judgments<br>• More realistic expert assessments<br>• Reduces arbitrary precision | • High computational complexity<br>• Difficult fuzzy number operations<br>• Choice of fuzzy scale subjective<br>• More difficult to explain |

_Table 3.2: Advantages and disadvantages of commonly used MCDM methods._

>[!warning] Recurring Risk Sources
>The disadvantages reduce to three recurring sources of risk:
>1. **Heavy reliance on expert assessments and subjectivity** (AHP, BWM, FUCOM)
>2. **Assumption of independence between criteria**, which is rarely valid in engineering systems (SAW, TOPSIS, VIKOR)
>3. **Sensitivity to normalization and extreme values** (especially TOPSIS)

#### Industrial Application Domains

Table 3.3 shows the most commonly used MCDM methods and their areas of application in different industrial sectors, demonstrating how methods find practical application in specific situations.

| **Method** | **Manufacturing** | **Energy** | **Healthcare** | **Finance** | **Engineering** | **Supply Chain** |
|---|---|---|---|---|---|---|
| **AHP** | Machine selection, process optimization | Renewable energy selection | Treatment protocol selection | Investment portfolio | Design alternative evaluation | Supplier selection |
| **ANP** | Complex process networks | Smart grid planning | Hospital system design | Risk assessment networks | System architecture | Network optimization |
| **FUCOM** | Equipment selection, robot selection | Energy system optimization | Resource allocation | Portfolio optimization | Technology selection | Logistics optimization |
| **TOPSIS** | Supplier ranking, material selection | Power plant ranking | Hospital performance | Stock ranking | Material selection | Distribution center location |
| **VIKOR** | Process alternative ranking | Energy policy compromise | Treatment compromise | Investment compromise | Design compromise | Supplier compromise |
| **BWM** | Quick equipment comparison | Energy source comparison | Medical device selection | Quick financial comparison | Technology comparison | Quick supplier screening |
| **SAW** | Simple supplier scoring | Energy efficiency scoring | Patient risk scoring | Credit scoring | Simple design scoring | Simple vendor scoring |
| **FAHP** | Uncertain process selection | Renewable uncertain planning | Diagnosis under uncertainty | Investment under uncertainty | Uncertain design parameters | Supplier selection with uncertainty |

_Table 3.3: Application of MCDM methods in different industrial fields._

>[!example] Application Diversity
>The flexibility of MCDM methods allows adaptation to specific needs of:
>- Manufacturing (process and equipment selection)
>- Energy (renewable sources, smart grids, policy)
>- Healthcare (treatment protocols, resource allocation, hospital design)
>- Finance (investment, risk assessment, portfolio)
>- Engineering (design alternatives, technology selection, materials)
>- Supply chain (suppliers, logistics, distribution)
>
>This provides optimal weighting of multiple criteria and increases reliability of selections in complex environments.

#### Summary of MCDM Method Analysis

>[!summary] Key Findings from Method Analysis
>
>**Main Advantages of MCDM Methods:**
>- Ability to process large volumes of data
>- Consideration of multiple criteria, including conflicting interests
>- Systematic and transparent decision-making process
>- Adaptation to various industries and applications
>
>**TOPSIS and VIKOR Strengths:**
>- Effectively compare and select alternatives according to proximity to "ideal solution"
>- Simultaneously use multiple criteria
>- Widely used in industrial practice
>
>**SAW and BWM Strengths:**
>- Easy and intuitive for users
>- Quick implementation
>- Low computational requirements
>
>**SAW and BWM Limitations:**
>- Do not always manage difficulty in complex relationships between criteria
>- Better to use methods considering interrelationships (like ANP) in such cases
>
>**ANP Characteristics:**
>- Considers interrelationships between criteria
>- Requires significant resources and computational time
>
>**FUCOM and BWM Efficiency:**
>- Low computational complexity compared to other methods
>- Practical with few pairwise comparisons
>- Produce highly consistent results
>- **FUCOM particularly suitable** for implementation in production environments with multiple criteria
>
>**FUCOM Distinctive Potential:**
>- Significant potential to reduce subjectivity
>- Increases consistency in determining criteria weights
>- Wide applicability
>- **Research gap**: No sources confirming application in technological process selection in mechanical engineering
>- Shows potential for future expansion in this domain

#### FUCOM Application Analysis

The FUCOM differs from other methods in its significant potential to reduce subjectivity and increase consistency in determining weights of criteria. This makes it particularly suitable for applications requiring high accuracy and efficiency.

Analysis highlights variety of possible applications, adaptability, and effectiveness in different production and business environments. Examples show how FUCOM supports strategic decision-making by optimizing selection of equipment, resources, and processes.

>[!info] Current FUCOM Applications
>From analyzed literature, FUCOM is clearly a preferred method for use in:
>- **Mechanical engineering** (optimization and selection of machinery, equipment, robotic systems)
>- **Logistics processes** in manufacturing
>
>**Notable gap**: No applications found for **process evaluation in mechanical engineering**

![[FUCOM Industry Applications.png]]
_Figure 3.1: Percentage distribution of FUCOM applications in different industrial sectors, showing largest share in mechanical engineering and logistics, followed by energy and healthcare sectors._

The statistics show which industries are already benefiting most from the method and where there is potential for future expansion. Despite FUCOM's potential, its application in manufacturing environments, especially in mechanical engineering and specifically in technological process selection decisions, has not been studied sufficiently.

>[!tip] FUCOM Future Potential
>Increasing application of FUCOM in mechanical engineering could make significant contribution, providing:
>- New solutions in development of technological processes
>- Better results in process optimization
>- Reduced expert workload through minimal comparisons
>- Increased consistency and reliability of decisions
>
>Focusing on optimization or selection of suitable technological processes with FUCOM would represent important contribution from both scientific and practical viewpoints.

---

### 3.2. Analysis of the Reviewed Patents and Methodologies Used

To further understand relationships and analyze strengths and weaknesses of each methodology considered, Table 3.4 presents main characteristics and specific applications of each patent, focusing on advantages, disadvantages, application domain, and MCDM method used.

| **Patent** | **MCDM Method** | **Application** | **Advantages** | **Disadvantages** | **Implementation Process** |
|---|---|---|---|---|
| Multilayer Digital Factory | Multiple/Integrated | Manufacturing digitalization | • Pre-implementation optimization<br>• Real-time data integration<br>• Simulation-based validation<br>• Reduced development costs | • Requires extensive infrastructure<br>• Complex integration<br>• High initial investment<br>• Specialized expertise needed | 6-layer architecture:<br>1. Data collection<br>2. Modeling<br>3. Analysis<br>4. Simulation<br>5. Optimization<br>6. Control |
| Computational Process Monitoring | Statistical + Optimization | Process monitoring | • Increased model reliability<br>• Outlier detection<br>• Performance evaluation<br>• Improved control | • High computational complexity<br>• Requires mathematical expertise<br>• Continuous data needed | 1. Data selection<br>2. Mahalanobis calculation<br>3. Zeta-statistics<br>4. Optimization<br>5. Evaluation |
| Horizontal Structured Modeling | Logic algorithms + Multi-criteria | CAD/CAM integration | • Virtual modeling capability<br>• Automated decisions<br>• CAD/CAM integration<br>• Adaptive control | • Limited to design phase<br>• Complex model development<br>• Requires CAD/CAM expertise | 1. Model creation<br>2. Logic algorithm application<br>3. Simulation<br>4. Integration<br>5. Control |
| Secondary Equipment Selection | Fuzzy Theory | Electrical equipment selection | • Handles uncertainty<br>• Quantified indices<br>• Standards-based<br>• Historical data use | • Narrow application domain<br>• Limited to low-voltage equipment<br>• Fuzzy scale choice subjective | 1. Criteria structure (3 layers)<br>2. Fuzzy quantification<br>3. Weight determination<br>4. Scheme selection |
| Resource Management Tool | AHP + LCA | Life cycle resource management | • Systematic comparison<br>• Life cycle integration<br>• Quantitative rating<br>• Multiple applications | • Requires detailed data<br>• Time-intensive data collection<br>• Expert-dependent<br>• 1-10 scale limitations | 1. System characterization<br>2. Alternative documentation<br>3. Criteria evaluation (1-10)<br>4. AHP weighting<br>5. Final ranking |
| Sustainability Index (PESTLE) | Participant voting + PESTLE | Sustainability assessment | • Holistic framework<br>• Stakeholder involvement<br>• Normalization to 0-100<br>• Comprehensive factors | • High participant subjectivity<br>• Voting variability<br>• Inconsistent estimates<br>• Requires many participants | 1. Data collection (surveys)<br>2. Normalization (0-100)<br>3. Weight assignment<br>4. Participant voting<br>5. Index calculation |
| Customer Service Evaluation | Weighted formulas + SME surveys | Service capability optimization | • Adaptable and repeatable<br>• SME-based normalization<br>• Visual results (graphs)<br>• Improvement focus | • SME availability dependent<br>• Subjective expert input<br>• Limited to service domain<br>• Formula complexity | 1. Initial interviews<br>2. Complex criteria application<br>3. SME surveys<br>4. Normalization<br>5. Analysis and prioritization |

_Table 3.4: Comparison of different patents using MCDM methodologies._

#### Common Patterns and Differences

**Similarities Across Patents:**

1. All patents use different multi-criteria decision or evaluation methods (or adapt one in methodology)
2. All aim to improve existing processes (equipment optimization, sustainability improvement, customer service prioritization)
3. Each uses quantitative assessments, allowing informed decisions and greater objectivity in analysis
4. All are designed to improve efficiency in various manufacturing sectors or industries
5. All contain clearly defined and structured decision-making processes

**Key Differences:**

1. Each patent is aimed at different application sector, making it difficult to implement in different industries
2. Different methodologies and techniques are used across patents
3. All require expert participation to evaluate criteria under consideration, but to varying degrees
4. Complexity ranges from simple (SAW-based) to highly complex (multi-layer architectures)

>[!note] Methodological Diversity
>Patents reviewed utilize various approaches:
>- **Complex mathematical models** (Fuzzy AHP) provide reliability in technical contexts
>- **Architecture-focused approaches** (Digital Factory) provide adaptability to modern industry conditions
>- **Survey research and strategy** (Customer Service) improve organizational processes
>- **Statistical approaches** (Process Monitoring) estimate cost and efficiency
>- **Holistic frameworks** (PESTLE Sustainability) focus on socio-ecological aspects beyond purely technical frameworks

#### Quantitative Patent Evaluation

Table 3.5 provides comparative analysis of patents based on quantitative assessment. A direct comparison cannot be made because of differences in application fields and methods used.

**Evaluation Methodology:**

A focused assessment was carried out using developed internal methodology. Each patent was assessed according to four predefined criteria:

1. **Consistency**
2. **Subjectivity**  
3. **Robustness**
4. **Flexibility**

**Expert Panel:**

Eight experts participated:
- 2 representatives from University 1
- 2 representatives from University 2
- 2 representatives from Mechanical Engineering Company 1
- 2 representatives from Mechanical Engineering Company 2

All participants have professional and academic experience in:
- Mechanical engineering
- Application of MCDM methods
- Working with patents

**Final Evaluation:** Calculated as average value of all individual evaluations submitted. Participation from various institutions and companies aims to reduce risk of subjective assessment and achieve more realistic assessment of practical applicability.

**Evaluation Scale:** 1-10 for each criterion (1 = lowest, 10 = highest)

**Criterion Definitions:**

**1. Consistency (1-10)**
- **Definition**: How logical and mathematically consistent is the method; are there clearly defined steps and well-founded decision-making logic
- **1-3**: Unclear methodology, lack of logical structure
- **4-6**: Partial consistency; some stages well justified
- **7-9**: High degree of logical consistency and structure
- **10**: Excellent consistency with clear and validated algorithm or model

**2. Subjectivity (1-10)**  
- **Definition**: Extent to which results depend on subjective judgments (lower subjectivity preferred)
- **1-3**: Highly dependent on subjective opinions, no control or verification
- **4-6**: Some subjective elements present but partially controlled
- **7-9**: Limited subjectivity with ways to reduce influence
- **10**: Almost entirely objective approach with minimal human intervention

**3. Robustness (1-10)**
- **Definition**: Extent to which method provides reliable results even with incomplete or partially inaccurate input data
- **1-3**: Results change dramatically with small data changes
- **4-6**: Moderate sensitivity to inaccuracies
- **7-9**: Method shows stability in different scenarios
- **10**: High level of stability and reliability of results

**4. Flexibility (1-10)**
- **Definition**: Method's ability to adapt to different production conditions, industries, or problem types
- **1-3**: Only applicable in very narrow context
- **4-6**: Partially adaptable to new conditions
- **7-9**: Can be applied in variety of industrial environments
- **10**: Excellent versatility and easy adaptation to different situations

| **Patent** | **Consistency** | **Subjectivity** | **Robustness** | **Flexibility** | **Total Score** | **Rank** |
|---|---|---|---|---|---|
| Multilayer Digital Factory | 8.5 | 7.0 | 8.0 | 8.5 | 32.0 | **1** |
| Resource Management Tool (AHP) | 8.0 | 6.5 | 7.5 | 7.0 | 29.0 | **2** |
| Horizontal Structured Modeling | 7.5 | 6.0 | 7.0 | 6.5 | 27.0 | **3** |
| Computational Process Monitoring | 7.0 | 7.5 | 7.5 | 6.0 | 28.0 | **2** (tie) |
| Sustainability Index (PESTLE) | 6.5 | 4.5 | 6.0 | 7.5 | 24.5 | **4** |
| Secondary Equipment Selection | 7.0 | 5.5 | 6.5 | 5.0 | 24.0 | **5** |
| Customer Service Evaluation | 6.0 | 5.0 | 5.5 | 6.0 | 22.5 | **6** |

_Table 3.5: Comparison of patents using MCDM methods based on quantitative evaluation by expert panel._

>[!summary] Patent Evaluation Insights
>
>**Highest Scoring Patents** (show high consistency, low subjectivity, excellent adaptability):
>- **Multilayer Digital Factory** (32.0): Best overall performance across all criteria
>- **Resource Management Tool** (29.0): Strong consistency and robustness  
>- **Computational Process Monitoring** (28.0): High objectivity and stability
>
>**Average Performance Patents** (offer balanced performance but may need optimization):
>- **Horizontal Structured Modeling** (27.0): Good but limited flexibility
>- **Sustainability Index (PESTLE)** (24.5): High flexibility but low subjectivity control
>- **Secondary Equipment Selection** (24.0): Moderate across all dimensions
>
>**Lower Scoring Patents** (need improvements in reducing subjectivity and increasing reliability):
>- **Customer Service Evaluation** (22.5): Challenges in consistency and robustness when working with incomplete information

#### Technical Orientation Spectrum

Patents and methods considered show major differences in specific orientation:

**Spectrum of Focus:**
- **Technical optimization** and production processes (Digital Factory, Process Monitoring)
- **Social sustainability** and customer-oriented solutions (PESTLE Index, Customer Service)
- **Hybrid technical-economic** (Resource Management, Equipment Selection)

>[!important] No Universal Methodologies Found
>No universal methodologies have been found that can:
>- Be applied in different industries
>- Apply different methods and approaches flexibly
>- Adapt to varying organizational contexts
>
>The patents under review are specifically tailored to particular needs of different industries and situations.

**Common Focus Across Patents:**

MCDM methods and methodologies applied in these patents focus on development of special tools and systems based on:
- Importance of systematic and structured approach
- Selection of technology and solutions appropriate to context
- Integration with existing industrial systems

>[!tip] Value for Practitioners and Researchers
>This review is intended to assist practitioners and researchers in:
>- Understanding how these methods can be applied to improve processes in their areas of interest
>- Identifying appropriate solutions to specific problems
>- Recognizing limitations and requirements of each approach
>- Making informed decisions about which methodology to adopt

---

## 4. Discussion

### 4.1. Discussions

The numerous MCDM methods and related patents discussed highlight their importance in modern industries. These methods not only offer effective solutions to complex problems but also provide basis for innovation, especially when integrated with new technologies related to Industry 4.0.

>[!warning] Research Gap Identified
>Even though there has been extensive research on MCDM methods and their use in different industries, there is **limited information on how they are used to track and optimize technological processes in mechanical engineering**. Their integration into software programs/systems or applications that facilitate selecting suitable or rational technological processes is not found in the reviewed literature.

#### Potential for Automation Integration

MCDM methods, characterized by their flexibility and adaptability, demonstrate ideal utility for application in volatile production environments. Combining flexibility for adaptation with automated systems, especially in production contexts where automation and speed are paramount, will allow for:

- Faster decision-making
- Informed decisions based on real-time data
- Dynamic adaptation to changing conditions
- Reduced human error in process selection

#### Method Selection Framework

The comparison of analyzed MCDM methods shows that selection of appropriate method depends on **structure and complexity of the problem** under consideration and reduces to four main criteria:

**1. Criteria Structure**

>[!info] Decision Rule: Criteria Structure
>**When to use:**
>- **AHP**: Hierarchical, independent criteria
>- **FUCOM, SAW, BWM**: Simpler structure where criteria relationships are not "crossed"
>- **ANP**: When criteria have inverse relationships or interdependencies (network modeling required)

**2. Number of Comparisons**

>[!info] Decision Rule: Comparison Requirements
>**When to use:**
>- **FUCOM and BWM**: Small number of comparisons needed
>- **AHP, ANP, FUCOM, BWM**: Weights need to be assigned in evaluation process
>- **SAW**: Known weights required in advance (no comparison needed)

**3. Presence or Absence of Predefined Weights**

>[!info] Decision Rule: Weight Availability
>**When to use:**
>- **SAW**: Weights already available (performs direct ranking)
>- **AHP, ANP, BWM, FUCOM**: Weights not available (methods determine weights)

**4. Scaling Analysis of Alternatives**

>[!info] Decision Rule: Number of Alternatives/Criteria
>**When to use:**
>- **SAW, BWM, FUCOM**: Many different alternatives/criteria (offer quick and significantly easier calculations)
>- **AHP, ANP**: Small number of criteria (number of comparisons is manageable)

#### Supporting Decision Table

Table 4.1 provides supporting guidance on strengths and weaknesses to assist in method selection.

| **Method** | **Best Used When** | **Avoid When** | **Key Strength** | **Key Weakness** |
|---|---|---|---|---|
| **AHP** | Clear hierarchy exists, moderate number of criteria, transparency needed | Criteria are interdependent, many criteria ($n > 10$), time constrained | Structured, transparent, consistency check | Many comparisons for large $n$ |
| **ANP** | Strong interdependencies exist, feedback loops present, complex system | Simple problem, limited resources, non-expert users | Captures complex relationships | Very high comparison burden |
| **FUCOM** | Many criteria, limited expert time, consistency critical | Criteria interdependent, ranking unclear | Minimal comparisons ($n-1$), full consistency | Cannot model dependencies |
| **TOPSIS** | Quick ranking needed, many alternatives, weights known | Need consistency check, extreme outliers present | Fast, simple, intuitive | Sensitive to normalization |
| **VIKOR** | Compromise solution desired, conflicting criteria, weights known | Need consistency check, strategy unclear | Balances utility and regret | Sensitive to normalization |
| **BWM** | Moderate criteria, structured comparison preferred | Criteria interdependent, best/worst unclear | Fewer comparisons than AHP | Still requires judgment |
| **SAW** | Simple problem, weights predefined, speed critical | Criteria dependent, compensation unacceptable | Extremely simple and fast | No consistency check |
| **FAHP** | Uncertainty high, vague judgments, subjective data | Objective data available, simplicity needed | Handles uncertainty well | High computational complexity |

_Table 4.1: Supporting table on strengths and weaknesses of MCDM methods to guide selection._

#### Patent and Methodology Insights

Patents, methodologies, and MCDM methods reviewed offer specific solutions that improve upon existing methods, highlighting importance of innovation in extending scope and practical application of MCDM methods. They successfully integrate with specific needs and requirements of different industries.

>[!warning] Real-Time Application Gap
>However, there is **no real application for real-time process monitoring and control** in the reviewed patents and methodologies.

#### Barriers to Wider Adoption

To unlock full potential of MCDM methods, there is need to:

1. **Provide easier data entry**: Development of software programs and applications with intuitive interfaces to support end users
2. **Enable real-time technology solutions**: Support selection of technology solutions as production conditions change
3. **Make MCDM accessible**: Integration into modern technology to make methods a trend rather than academic exercise

>[!important] Current Limitations of MCDM Methods
>Despite many advantages, MCDM methods have limitations related to:
>- **Complexity of implementation**: Requires technical expertise and training
>- **Need for experts**: Expert evaluation criteria and judgment required
>- **Significant resources**: Data collection and processing demands
>- **Limited enterprise applicability**: May be challenging for smaller or resource-constrained enterprises

---

### 4.2. Future Directions and Challenges

#### Standardization and Software Development

Development of **new standardized methodologies** and **intuitive software** to facilitate implementation of MCDM methods will help overcome current limitations.

>[!tip] Automation Potential
>To reduce need for expert judgment and increase efficiency of MCDM methods, creation of **hybrid models that automatically adjust criteria weights** would assist with this process.

#### Dynamic MCDM for Industry 4.0

Analysis performed leads to interesting perspective possibilities for future research in MCDM methods:

**1. IoT Integration**

Integration of **IoT platforms** to:
- Process and provide updated data in real-time
- Automatically trigger re-evaluation when conditions change
- Enable continuous optimization

**2. Software Programs and Mobile Applications**

Development of software programs and mobile applications for:
- Dynamic MCDM methods adapting in real-time to changing manufacturing environment conditions
- Selection of optimal and rational technological solutions in mechanical engineering
- Accessible interfaces for non-expert users

#### Hybrid MCDM Approaches

>[!important] Hybrid Approaches for Industry 4.0
>An important avenue for advancing MCDM research lies in exploring **hybrid approaches** that combine strengths of different methods. Such approaches are increasingly recognized as particularly valuable in context of Industry 4.0, where decision-making environments are:
>- Complex
>- Uncertain  
>- Highly dynamic

**Recent Hybrid Research Examples:**

- **FAHP-TOPSIS Framework**: Evaluates influence of Industry 4.0 technologies on manufacturing strategies, providing structured and reliable guidance for prioritizing emerging technologies

- **Hybrid Fuzzy MCDM for Lean Six Sigma 4.0**: Effectively guides practitioners in overcoming barriers to integration, providing structured roadmap for sustainable operational excellence

- **Context-Sensitive Multidisciplinary Frameworks**: Combine hybrid/fuzzy MCDM with stakeholder co-creation to guide SME innovation and technology choice decisions within Industry 4.0 transitions

>[!example] Hybrid Approach Benefits
>Combining methods can:
>- **AHP + TOPSIS**: Use AHP for weight determination (with consistency check), then TOPSIS for fast ranking of many alternatives
>- **FUCOM + VIKOR**: Use FUCOM for efficient weight determination, then VIKOR for compromise solution finding
>- **Fuzzy + Traditional**: Apply fuzzy logic where uncertainty is high, traditional methods where data is objective
>
>Result: Leverage strengths of multiple methods while compensating for individual weaknesses

#### The Role of Artificial Intelligence

>[!warning] AI Integration Challenges
>The role of artificial intelligence (AI) in MCDM methods must be noted with caution. While AI models have significant potential to support MCDM processes by processing large volumes of data in real-time, their **direct integration into industrial environments poses serious challenges**.

**Critical Issues with AI in MCDM:**

**1. Standards Compliance Gap**

AI systems are primarily oriented towards optimization according to selected criteria (cost effectiveness and/or performance efficiency) but **rarely offer mechanisms for automated compliance** with industrial standards such as:
- ISO standards
- ASME standards  
- Machinery Directive 2006/42/EC
- Future Machinery Regulation 2023/1230

Lack of guaranteed traceability and regulatory validation makes it difficult to apply them to:
- Critical processes
- Critical components
- Processes subject to compliance and/or validation

**2. Black Box Problem**

>[!warning] The Explainability Challenge
>A major issue is that AI models, including large language models (LLMs), often function as a **"black box"**—meaning it is very difficult to explain why particular alternative has been chosen.
>
>This is in **total contradiction** with requirement for:
>- Transparency of decisions (Machinery Directive 2006/42/EC)
>- Traceability of decisions (Future Machinery Regulation 2023/1230)

AI systems can offer mathematically optimal solutions but **without any guarantee** of:
- Safety
- Sustainability
- Compliance with regulations, directives, and standards

**3. Decision Accountability**

In industrial environments, decisions must be:
- Explainable to regulatory bodies
- Traceable for audits
- Justified based on documented criteria
- Reproducible with same inputs

Current AI systems often cannot meet these requirements, making them unsuitable as standalone decision-makers for critical manufacturing processes.

>[!tip] Appropriate AI Role in MCDM
>Rather than replacing MCDM methods, AI can support them by:
>- **Data preprocessing**: Collecting and organizing large datasets for MCDM input
>- **Pattern recognition**: Identifying trends that inform criteria or weights
>- **Scenario generation**: Creating alternative scenarios for MCDM evaluation
>- **Sensitivity analysis**: Testing robustness of MCDM results across conditions
>- **Recommendation support**: Suggesting alternatives for human experts to evaluate using MCDM
>
>**Human experts remain essential** for:
>- Final decision-making
>- Criteria selection and weighting  
>- Regulatory compliance verification
>- Ethical and strategic considerations

#### FUCOM as Foundation for Innovation

The **FUCOM** can serve as solid foundation for building innovative, adaptable, and intelligent solutions to meet increasing demands for:
- Efficiency
- Sustainability  
- Flexibility of manufacturing systems

In this way, the method can successfully overcome some of today's most serious manufacturing challenges.

**FUCOM Advantages for Future Development:**

1. **Consistency**: Mathematical guarantee of full consistency
2. **Working with multiple criteria**: Efficient handling of complex problems
3. **Minimizing errors**: Fewer comparisons reduce cognitive errors
4. **Universality**: Applicable across industries with adaptation
5. **Small comparisons**: Only $n-1$ comparisons needed
6. **Easy application**: Intuitive ranking-based approach

>[!important] FUCOM Research Gap and Opportunity
>As mentioned, FUCOM is relatively new MCDM method. Despite its low computational complexity, **creation of dedicated software tools, programs, and applications** to tailor process to specific needs of machine manufacturing are needed.
>
>**FUCOM has not been used in mechanical engineering manufacturing as a process evaluation tool**, despite major advantages over other MCDM methods. This represents significant research opportunity and potential for industrial impact.

**Future Research Directions for FUCOM:**

The current and future research should focus on:

1. **Development of methods** for FUCOM application in industrial practices, especially in technological processes in mechanical engineering

2. **Software platform creation** for complex calculations and user-friendly interfaces

3. **Integration into real-time decision support systems**, such as:
   - Modular software for process selection
   - Mobile applications for shop floor decisions
   - Cloud-based platforms for distributed manufacturing

4. **Pilot implementations** in industrial settings to validate utility and ease of use under dynamic conditions

5. **Validation studies** comparing FUCOM performance to established methods in mechanical engineering contexts

6. **Hybrid FUCOM approaches** combining with other methods (e.g., FUCOM for weights + TOPSIS for ranking)

>[!note] Authors' Current Research
>In line with findings of this review, the authors have previously developed a **structured methodology for selection of rational technological processes**, which is currently being implemented in actual production (results yet to be published).
>
>As continuation of this research, a **software application is currently under development** to implement this methodology in practice. The proposed solution is built upon principles of multi-criteria decision-making, with **FUCOM serving as the core evaluation and ranking mechanism**.
>
>This integration aims to provide decision-makers with practical and adaptable tool for use in real industrial environments.

---

## 5. Conclusions

MCDM methods allow for balanced and reasoned decision-making based on various criteria related to the problem under consideration. These methods are well established as an important tool for overcoming complexity of today's technological manufacturing challenges by considering importance of criteria such as:

- Efficiency
- Cost
- Quality
- Sustainability
- Innovation

>[!important] Critical Success Factor
>Choosing the right MCDM method and implementing it properly in particular situation or case is of major importance since it can result in:
>- Apparent boost in efficiency
>- Optimization of resources used
>- Cost reduction
>- Improvement in general process efficiency

### Integration with Emerging Technologies

With implications of these methods combined with modern technology, new methods or hybrid ones will be able to arise. Such technologies could include:

- **Artificial Intelligence (AI)**: Analyze vast amounts of data in real-time (with appropriate human oversight for critical decisions)
- **Big Data**: Process large datasets to identify patterns and inform criteria
- **Deep Learning**: Recognize complex relationships in manufacturing data
- **Internet of Things (IoT)**: Continuously monitor systems and automatically modify or change processes

All of this would greatly increase:
- Operational efficiency
- Reduced error risk
- Improved decision-making accuracy

>[!tip] The Future: Digital Factories and Simulation
>With increasing digitalization of modern industrial environment, concepts related to **digital factories** and **simulation models** (mentioned in reviewed patents) guide future of MCDM methods.
>
>To combine efficiency and innovation while keeping methods accessible to wide range of industrial applications, development must follow guideline along with **dynamic and intelligent systems that can adapt in real-time**.

### The Role of Expert Judgment

>[!warning] Expert Dependency Remains Critical
>There is clear need for **expert judgment when selecting and ranking criteria**, especially in situations where conditions change. But in practice, using MCDM methods in manufacturing is not always straightforward.
>
>This shows why **practical, standardized methods are important**—they make it easier for companies of all sizes to apply them effectively.

### Diversity of Approaches

The methods reviewed here follow different ideas. Each one has its own logic for:
- Deciding which criteria matter more
- How they should be evaluated when decisions are complex

There is **not a single approach that works for all situations**, and that variety can be both a strength and a challenge.

**Main Advantages of Variety:**
- Wide applicability across industries (production digitalization, sustainability, resource management)
- Adaptability to automation, smart management systems, decision planning
- Tools that fit different company goals

**Challenges of Variety:**
- Many methods have notable limitations
- Some are hard to apply without expert help
- Others take time, data, or technical resources not always available
- Makes case for more research and consistency in how tools are developed and shared

>[!tip] Usability Improvements
>**Early involvement of experts** and availability of **intuitive interfaces** significantly improve usability of MCDM tools for both engineers and decision-makers.

### Ongoing Challenges

MCDM methods face challenges beyond those shown so far:

**Limited Versatility:**
- Some methods do not adapt easily and quickly to changing conditions

**Integration Complexity:**
- Difficulty of integration process in small- and medium-sized enterprises

**Resource Requirements:**
- Time, expertise, and data needs may exceed organizational capacity

**Hybrid Solutions:**

These challenges need to be overcome to increase efficiency and practicability. **Combining different methods** by creating hybrid variants of original MCDM methods can help:
- Overcome these obstacles
- Extend their practical application
- Leverage strengths while compensating for weaknesses

### Method Selection Guidelines

>[!summary] Optimal Method Selection Depends On:
>
>**For Many Criteria + Limited Expert Time:**
>- **FUCOM** provides reliable weights with minimal effort ($n-1$ comparisons)
>- Advantage in strategic planning and automated systems
>
>**For Large Number of Alternatives + Quick Ranking:**
>- **TOPSIS** features high speed and intuitive interpretation
>- Suitable for supplier selection, energy source options evaluation
>- Based primarily on quantitative metrics
>
>**For Detailed Structured Hierarchical Problems:**
>- **AHP** remains best solution due to transparency and consistency control
>- Suitable for selecting manufacturing technology combining technical, economic, environmental subobjectives
>- Requires experienced expert support
>
>**For Medium or Highly Standardized Criteria Sets:**
>- **BWM and SAW** preferred for more economical solutions
>- Known weights enable fast implementation
>
>**For Significant Correlations Between Criteria:**
>- **ANP** recommended for network modeling
>- Captures interdependencies and feedback loops

### The FUCOM Opportunity

>[!important] FUCOM Research and Application Gap
>**Current state:**
>- FUCOM used in multiple industries with different applicability
>- Preferred for mechanical engineering (machinery, equipment, robotics selection) and logistics
>- **No evidence** of application in technological process evaluation in mechanical engineering
>
>**Future potential:**
>- Significant contribution possible in mechanical engineering
>- New solutions in development of technological processes
>- Better results in process optimization
>
>**Research direction:**
>Based on analysis, although FUCOM is relatively new MCDM method, it has proven effectiveness in many industries. Thanks to its ability to:
>- Reduce subjective errors
>- Ensure consistency of results
>- Minimize expert workload
>
>Its potential can be exploited in mechanical engineering sector. **Focusing on optimization or selection of suitable technological processes with FUCOM would represent important contribution from both scientific and practical viewpoints.**

### Future Research Directions

**Research Team Future Work Will Be Oriented Towards:**

1. **Development of hybrid methods** that integrate strengths of different MCDM methods

2. **Creation of software platforms** for complex calculations with user-friendly interfaces

3. **Exploring capabilities of FUCOM** in process selection and evaluation

4. **Integration of FUCOM into real-time decision support systems**:
   - Modular software
   - Mobile applications
   - Cloud-based platforms

5. **Pilot implementations** in industrial settings to validate utility and ease of use under dynamic conditions

>[!note] Ongoing Work by Authors
>In line with findings of this review, the authors have previously developed a **structured methodology for selection of rational technological processes**, currently being implemented in actual production (results yet to be published).
>
>As continuation of this research, a **software application is currently under development** to implement this methodology in practice. The proposed solution is built upon principles of multi-criteria decision-making, with **FUCOM serving as core evaluation and ranking mechanism**.
>
>This integration aims to provide decision-makers with practical and adaptable tool for use in real industrial environments.

### Final Perspective

>[!summary] Concluding Remarks
>MCDM methods are not just academic ideas. As shown in this review, they are **practical tools that help with selecting and improving processes in real industrial settings**.
>
>They play role in shaping priorities of modern companies:
>- Innovation
>- Sustainability  
>- Staying ahead of competition
>
>These objectives are grounded in **practical decision-making processes** rather than theoretical constructs, and MCDM methods help structure those decisions in useful way.
>
>**Future trajectory:**
>We are likely to see these methods built into more software products. They will not just be used for solving difficult case studies or modeling complex scenarios. They will also support organizations in:
>- Making smarter choices
>- Holding on to competitive position over time
>- Adapting to Industry 4.0 and beyond
>
>**The path forward requires:**
>- Continued research and validation
>- Development of user-friendly tools
>- Integration with emerging technologies (with appropriate human oversight)
>- Focus on making methods accessible to organizations of all sizes

---

>[!summary] Article Summary
>
>**Purpose:**
>This article provides systematic review and evaluation of main MCDM methods used in industrial practice, including analysis of relevant methodologies and patents, to guide researchers and practitioners in selecting appropriate decision-making tools based on specific industrial contexts and objectives.
>
>**Methods Reviewed:**
>AHP, ANP, FUCOM, TOPSIS, VIKOR, BWM, SAW, FAHP, FRADAR—each with distinct characteristics, advantages, and limitations outlined through objective comparison metrics and industrial application analysis.
>
>**Key Findings:**
>- MCDM methods enable balanced decision-making across multiple, often conflicting criteria (efficiency, cost, quality, sustainability)
>- Method selection depends on criteria structure, number of comparisons feasible, weight availability, and number of alternatives
>- Trade-offs exist: methods with few comparisons (FUCOM, BWM) reduce expert workload but may miss dependencies; methods handling dependencies (ANP) require many comparisons and high complexity
>- FUCOM shows significant potential for reducing subjectivity and ensuring consistency with minimal comparisons ($n-1$), but has **not been applied to technological process evaluation in mechanical engineering** despite widespread use in other domains
>
>**Patent Analysis:**
>Seven patents examined show diverse approaches (multilayer digital factories, fuzzy-based equipment selection, sustainability indices) but reveal:
>- No universal methodologies applicable across industries
>- Limited real-time process monitoring and control capabilities
>- Need for software tools with intuitive interfaces for broader adoption
>
>**Limitations and Challenges:**
>- Expert judgment dependency and subjectivity (AHP, BWM, FUCOM)
>- Assumption of criteria independence rarely valid in engineering (SAW, TOPSIS, VIKOR)
>- Sensitivity to normalization and extreme values (TOPSIS)
>- Complexity barriers for small/medium enterprises
>- Limited adaptability to rapidly changing conditions
>
>**Future Directions:**
>- **Hybrid MCDM approaches** combining method strengths for Industry 4.0 contexts
>- **IoT integration** for real-time data and dynamic adaptation
>- **Software development** with user-friendly interfaces and mobile applications
>- **FUCOM application research** in mechanical engineering technological process selection
>- **AI support role** (not replacement) for data preprocessing, pattern recognition, scenario generation—human experts remain essential for final decisions, regulatory compliance, and ethical considerations
>
>**Practical Implications:**
>- FUCOM particularly suitable for production environments with multiple criteria and limited expert time
>- TOPSIS effective for quick ranking of many alternatives with known weights
>- AHP best for structured hierarchical problems requiring transparency
>- ANP necessary when criteria have significant interdependencies
>- Combining methods through hybrid approaches can overcome individual limitations
>
>**Research Gap:**
>Despite extensive MCDM research in various industries, **limited information exists on tracking and optimizing technological processes in mechanical engineering**, and no software integration found for facilitating rational technological process selection in this domain.
>
>**Authors' Ongoing Work:**
>Development of structured methodology for rational technological process selection (implementation ongoing, results pending publication) and software application implementing this methodology with FUCOM as core evaluation mechanism for practical use in real industrial environments.