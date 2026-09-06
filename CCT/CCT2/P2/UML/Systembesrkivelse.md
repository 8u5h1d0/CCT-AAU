

# Systembeskrivelse: B2B Bærbar Computer Sammenligningsplatform

---

## Systembeskrivelse

### 1. Formål

Systemet skal understøtte virksomheders beslutningstagere (IT-chefer, indkøbere, procurement-managers og teknisk personale) i at træffe informerede indkøbsbeslutninger om bærbare computere til erhvervsbrug.

Systemet skal fungere som en centraliseret, community-driven sammenligningsplatform, der aggregerer offentligt tilgængelige produktspecifikationer med strukturerede erfaringsdata fra andre virksomheder, og præsenterer dem i en kontekstuel, behovsbaseret visning.

---

### 2. Problemstilling

Baseret på interviews med beslutningstagere i henholdsvis en softwareudviklingsvirksomhed og en almen kontorvirksomhed, er følgende kerneproblemer identificeret:

- **Fragmenteret informationslandskab:** Specifikationer, priser, garanti- og supportvilkår er spredt på tværs af mange leverandørhjemmesider uden ensartet struktur, hvilket tvinger beslutningstageren til at navigere mellem 10–15 kilder for at opnå et sammenligningsgrundlag.

- **Informationsasymmetri:** Garantivilkår og supportaftaler er ofte uklare eller vildledende. Eksempelvis kan en bærbar have 3 års garanti, men batteriet er kun dækket i 1 år – en information der sjældent er tydelig ved køb.

- **Kontekstblindhed:** Den samme computer vurderes vidt forskelligt afhængigt af brugskonteksten. En SQL-udvikler, en sælger på farten og en almindelig kontormedarbejder har fundamentalt forskellige behov, men eksisterende værktøjer præsenterer alle computere identisk.

- **Manglende peer-indsigt:** Virksomheder har ingen adgang til strukturerede erfaringer fra lignende virksomheder om support-kvalitet, real-world performance, konfigurabilitet eller holdbarhed.

- **Usynlige trade-offs:** Beslutningstagere mangler indsigt i, hvad de reelt får for en merpris, og hvilke konsekvenser et tilvalg har for andre parametre (f.eks. touchskærm → højere strømforbrug → kortere batterilevetid).

- **Leverandørbias:** Virksomheder køber fra "dem de kender" – også når konkurrenter objektivt leverer et bedre produkt – fordi der mangler et værktøj, der gør alternativer synlige og sammenlignelige.

- **Rollebaseret beslutningskompleksitet:** Flere roller (IT-chef, support-personale, indkøber, slutbrugere) har forskellige prioriteter, men der findes intet fælles beslutningsgrundlag.

---

### 3. Kernefunktionalitet

#### 3.1 Intelligent multi-lag sammenligning

Systemet skal præsentere computermodeller på flere detaljeringsniveauer, som brugeren kan ekspandere eller kollapse efter behov:

- **Simpelt lag** (batteri, vægt, pris, skærmstørrelse) – rettet mod almindelige kontormedarbejdere og sælgere.
- **Avanceret lag** (supportaftaler, garantidækning, refurbishment-muligheder, materialekvalitet) – rettet mod IT-chefer og procurement-ansvarlige.
- **Ekspert-lag** (CPU-arkitektur, RAM-konfigurabilitet, performance-tiers, termisk design, opgraderbarhed) – rettet mod udviklingsvirksomheder og teknisk support.
- **Organisatorisk lag** (total cost of ownership, leverandørrabatter, image-management-integration, administrativ overhead, leasingvilkår) – rettet mod procurement-managers og finansiel ledelse.

Alle lag skal altid være tilgængelige, men systemet skal som standard vise det detaljeringsniveau, der passer til brugerens valgte profil.

#### 3.2 Behovsbaseret søgning

Systemet skal muliggøre søgning baseret på **hvad computeren skal bruges til** snarere end individuelle specifikationer:

- **Softwarebaseret søgning:** Brugeren angiver, hvilken software computeren skal køre (f.eks. "Office 365 og Adobe Illustrator"), og systemet matcher mod en database af kendt software og deres minimumskrav.
- **Arbejdsmiljøbaseret søgning:** Brugeren angiver arbejdskontekst (f.eks. "rejser dagligt", "stationær kontorplads", "ude hos kunder"), og systemet prioriterer relevante parametre (batteri, vægt, design, holdbarhed).
- **Specialiseret søgning:** Brugeren angiver niche-behov (f.eks. "SQL-udvikling på ældre systemer"), og systemet viser modeller, som community-data peger på som egnede – herunder ældre generationer, hvis disse er bedre til opgaven.
- **Custom søgning:** Brugeren kan selv definere minimumskrav (CPU-kraft, RAM, GPU, batteritimer, vægt) og filtrere manuelt.

Systemet skal vedligeholde en database af kendt software med tilhørende minimumskrav, som brugere også selv kan bidrage til.

#### 3.3 Konfigurationsklarhed

Systemet skal håndtere, at "samme model" kan dække over væsentligt forskellige konfigurationer:

- Samme modelnavn med forskellige RAM-typer (loddet vs. udskifteligt).
- Samme model med forskellige CPU-generationer.
- Samme model med forskellige skærmtyper (touch vs. non-touch, mat vs. blank).
- Performance-tiers inden for samme chassis.

Hver unik konfiguration skal tildeles sit eget "fingerprint", så brugeren aldrig utilsigtet sammenligner to konfigurationer, der reelt er forskellige produkter. Systemet skal også vise, hvilke konfigurationer andre virksomheder har bestilt, baseret på community-data.

#### 3.4 Support- og garantiklarhed

Systemet skal eksplicit og struktureret vise:

- Hvad der er dækket af garanti, med opdeling pr. komponent (f.eks. CPU/motherboard = 3 år, batteri = 1 år, skærm = 2 år).
- Hvad der er dækket af eventuelle serviceaftaler (responstid, on-site support, delsudskiftning).
- Hvad der **ikke** er dækket.
- Asymmetrier mellem leverandører (f.eks. "Leverandør A dækker batteri i 3 år, Leverandør B kun i 1 år").
- Community-baserede ratings af supportkvalitet pr. leverandør.
- Refurbishment- og trade-in-muligheder.

#### 3.5 Trade-off-visualisering

Når to eller flere computere sammenlignes, skal systemet eksplicit vise de trade-offs, der følger af et valg:

- Hvad brugeren får og mister ved en merpris (f.eks. "1.200 kr. mere giver bedre skærm, men 2 timer kortere batteritid").
- Cost-benefit-kontekst (f.eks. "Denne feature koster 300 kr. ekstra på en computer med en stykpris på 30.000 kr.").
- Grafisk visualisering af parameterbalancer (batteri vs. GPU-kraft, vægt vs. skærmstørrelse, osv.).

#### 3.6 Leverandørindsigt og alternativopdagelse

Systemet skal aktivt hjælpe brugeren med at opdage alternativer:

- Vise "ækvivalente modeller" fra andre leverandører (f.eks. "Lenovo T14 er sammenligneligt med HP EliteBook 840").
- Vise community-ratings af leverandørers supportkvalitet.
- Vise, hvis brugerens virksomhed historisk har købt fra én leverandør, og præsentere alternativer med sammenlignelige eller bedre ratings.

#### 3.7 Kontekstbaserede brugerprofiler

Systemet skal understøtte rollebaserede profiler, der automatisk justerer, hvilke parametre der vægtes højest:

- **Almindelig kontormedarbejder:** Batteri, vægt, design, pris.
- **Sælger/rejsende:** Batteri, design, vægt, holdbarhed.
- **Udvikler:** CPU-arkitektur, RAM-konfigurabilitet, performance-tier, GPU.
- **IT-chef (udviklingsvirksomhed):** Supportaftaler, garantidækning, konfigurabilitet, image-management.
- **IT-chef (kontorvirksomhed):** Pris, supportaftaler, designholdbarhed, administrativ overhead.
- **Procurement-manager:** Total cost of ownership, leverandørrabatter, leasingvilkår.

Systemet skal foreslå profil baseret på brugerens input, men brugeren skal altid kunne justere eller selv definere prioriteter.

---

### 4. Datakilder

#### 4.1 Offentlige specifikationer (primær datakilde ved lancering)
- Produktspecifikationer fra leverandørhjemmesider (CPU, GPU, RAM, SSD, batteri, vægt, skærm, pris).
- Offentlige garanti- og supportdokumenter (PDF'er fra leverandørers supportsider).
- Officielle performance-benchmarks og datablade.

#### 4.2 Community-erfaringsdata (sekundær datakilde, voksende over tid)
- Supportkvalitetsreviews (rating + kommentar + brugerens rolle).
- Konfigurationsnotater ("vi bestilte denne config, her er vores erfaring").
- Trade-off-indsigt ("vi valgte X, det betød Y").
- Softwarekompatibilitetsnotater ("denne model har problemer med Z").

#### 4.3 Softwarekravsdatabase
- Kendt software med minimumskrav (Office 365, Adobe Creative Suite, AutoCAD, SQL Server m.fl.).
- Community-bidrag til softwarekrav (brugere kan tilføje software og krav).

---

### 5. Afgrænsninger og begrænsninger

- Systemet er **ikke** en indkøbsportal – det faciliterer ikke selve købet, men understøtter beslutningsprocessen.
- Systemet har **ikke** adgang til leverandørers interne API'er, rabatstrukturer eller individuelle tilbudsdata. Al data er enten offentligt tilgængeligt eller community-genereret.
- Systemet garanterer **ikke** nøjagtigheden af community-data, men skal implementere modereringsmekanismer for at sikre datakvalitet (spamfiltrering, verifikation, konfliktvisning).
- Systemet dækker i sin initiale version et udvalg af populære B2B-modeller (Lenovo ThinkPad, HP EliteBook, Dell Latitude) og kan udvides over tid.

---

### 6. Designprincipper

1. **Detaljer skal være tilgængelige, men ikke påtvungne.** Systemet viser som standard det detaljeringsniveau, der passer brugerens profil. Avancerede data er altid tilgængelige ét klik væk.
2. **Sammenligning skal være kontekstuel.** Når to modeller sammenlignes, skal systemet fremhæve de forskelle, der er relevante for brugerens profil og behov.
3. **Supportaftaler skal være eksplicitte.** Ikke "3 års garanti", men "3 års garanti på CPU og motherboard; 1 år på batteri; ingen dækning af fysisk skade."
4. **Trade-offs skal være synlige.** Brugeren skal aldrig forlade en sammenligning uden at forstå, hvad de vinder og taber ved et valg.
5. **Alternativer skal være synlige.** Systemet skal aktivt modvirke leverandørbias ved at vise ækvivalente produkter fra andre leverandører.
