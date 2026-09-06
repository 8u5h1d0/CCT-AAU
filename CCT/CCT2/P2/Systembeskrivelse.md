

# Systembeskrivelse: B2B Bærbar Computer Sammenligningsplatform

---

## Systembeskrivelse

### 1. Formål

Systemet skal understøtte virksomheders beslutningstagere (IT-chefer, indkøbere, procurement-managers og teknisk personale) i at træffe informerede indkøbsbeslutninger om bærbare computere til erhvervsbrug.

Systemet skal fungere som en centraliseret, sammenligningsplatform, der aggregerer offentligt tilgængelige produktspecifikationer med strukturerede erfaringsdata fra andre virksomheder, og præsenterer dem i en kontekstuel, behovsbaseret visning.

---

### 2. Problemstilling

Baseret på interviews med beslutningstagere i henholdsvis en softwareudviklingsvirksomhed og en almen kontorvirksomhed, er følgende kerneproblemer identificeret:

- **Fragmenteret informationslandskab:** Specifikationer, priser, garanti- og supportvilkår er spredt på tværs af mange leverandørhjemmesider uden ensartet struktur, hvilket tvinger beslutningstageren til at navigere mellem 10–15 kilder for at opnå et sammenligningsgrundlag.

- **Informationsasymmetri:** Garantivilkår og supportaftaler er ofte uklare eller vildledende. Eksempelvis kan en bærbar have 3 års garanti, men batteriet er kun dækket i 1 år – en information der sjældent er tydelig ved køb.

- **Kontekstblindhed:** Den samme computer vurderes vidt forskelligt afhængigt af brugskonteksten. En SQL-udvikler, en sælger på farten og en almindelig kontormedarbejder har fundamentalt forskellige behov, men eksisterende værktøjer præsenterer alle computere identisk.

- **Usynlige trade-offs:** Beslutningstagere mangler indsigt i, hvad de reelt får for en merpris, og hvilke konsekvenser et tilvalg har for andre parametre (f.eks. touchskærm → højere strømforbrug → kortere batterilevetid).

- **Leverandørbias:** Virksomheder køber fra "dem de kender" – også når konkurrenter objektivt leverer et bedre produkt – fordi der mangler et værktøj, der gør alternativer synlige og sammenlignelige.

- **Rollebaseret beslutningskompleksitet:** Flere roller (IT-chef, support-personale, indkøber, slutbrugere) har forskellige prioriteter, men der findes intet fælles beslutningsgrundlag.

---

### 3. Kernefunktionalitet

#### 3.1 Intelligent multi-lag sammenligning

Systemet skal præsentere computermodeller på flere detaljeringsniveauer, som brugeren kan ekspandere eller kollapse efter behov:

- **Simpelt lag** (batteri, vægt, pris, skærmstørrelse) – rettet mod almindelige kontormedarbejdere og sælgere.
- **Avanceret lag** (supportaftaler, garantidækning, refurbishment-muligheder, materialekvalitet) – rettet mod IT-chefer og procurement-ansvarlige.
- **Ekspert-lag** (CPU-arkitektur, RAM-konfigurabilitet, opgraderbarhed) – rettet mod udviklingsvirksomheder og teknisk support.

Alle lag skal altid være tilgængelige, men systemet skal som standard vise det detaljeringsniveau, der passer til brugerens valgte profil.

#### 3.2 Behovsbaseret søgning

Systemet skal muliggøre søgning baseret på **hvad computeren skal bruges til** snarere end individuelle specifikationer:

- **Softwarebaseret søgning:** Brugeren angiver, hvilken software-type computeren skal køre (f.eks. "Office 365 eller lignende kontor applikationer" og "Adobe Illustrator, Autodesk eller andre grafiske applikationer"), og systemet matcher mod en database af kendt software-arketyper og deres minimumskrav.
- **Arbejdsmiljøbaseret søgning:** Brugeren angiver arbejdskontekst for den brugertype (f.eks. en "sælger" = "rejser dagligt" og/eller "ude hos kunder", "Almen" = "stationær kontorplads"), og systemet prioriterer relevante parametre (batteri, vægt, design, holdbarhed) baseret på det mest overordnede behov for den slags slutbruger.
- **Custom søgning:** Brugeren kan selv definere minimumskrav (CPU-kraft, RAM, GPU, batteritimer, vægt) og filtrere manuelt.

Systemet skal vedligeholde en database af kendt software med tilhørende minimumskrav, som brugere også selv kan bidrage til.
Forskellige søgetyper f.eks. software baseret og custom, skal arbejde sammen og filtrere i tandem. f.eks. hvis en bruger søger efter en computer den kan trække Office 365, der samtidig har en vægt på 1Kg eller mindre.

#### 3.3 Konfigurationsklarhed

Systemet skal håndtere, at "samme model" kan dække over væsentligt forskellige konfigurationer:

- Samme modelnavn med forskellige RAM-typer (loddet vs. udskifteligt).
- Samme model med forskellige CPU-generationer.
- Samme model med forskellige skærmtyper (touch vs. non-touch, mat vs. blank).

Hver unik konfiguration skal tildeles sit eget "fingerprint", så brugeren aldrig utilsigtet sammenligner to konfigurationer, der reelt er forskellige produkter. 

#### 3.4 Support- og garantiklarhed

Systemet skal eksplicit og struktureret vise:

- Hvad der er dækket af garanti, med opdeling pr. komponent (f.eks. CPU/motherboard = 3 år, batteri = 1 år, skærm = 2 år).
- Hvad der er dækket af eventuelle serviceaftaler (responstid, on-site support, delsudskiftning).
- Hvad der **ikke** er dækket.
- Asymmetrier mellem leverandører (f.eks. "Leverandør A dækker batteri i 3 år, Leverandør B kun i 1 år").
- Refurbishment- og trade-in-muligheder.

#### 3.5 Trade-off-visualisering

Når to eller flere computere sammenlignes, skal systemet eksplicit vise de trade-offs, der følger af et valg:

- Hvad brugeren får og mister ved en merpris (f.eks. "1.200 kr. mere giver bedre skærm, men 2 timer kortere batteritid").
- Cost-benefit-kontekst (f.eks. "Denne feature koster 300 kr. ekstra på en computer med en stykpris på 30.000 kr.").

#### 3.6 Leverandørindsigt og alternativopdagelse

Systemet skal aktivt hjælpe brugeren med at opdage alternativer:

- Vise "ækvivalente modeller" fra andre leverandører (f.eks. "Lenovo T14 er sammenligneligt med HP EliteBook 840").

#### 3.7 Kontekstbaserede brugerprofiler

Systemet skal understøtte rollebaserede profiler, der automatisk justerer, hvilke parametre der vægtes højest:

- **Almindelig kontormedarbejder:** Batteri, vægt, design, pris.
- **Sælger/rejsende:** Batteri, design, vægt, holdbarhed.
- **Udvikler:** CPU-arkitektur, RAM-konfigurabilitet, GPU.
- **IT-chef (udviklingsvirksomhed):** Supportaftaler, garantidækning, konfigurabilitet, image-management.
- **IT-chef (kontorvirksomhed):** Pris, supportaftaler, designholdbarhed, administrativ overhead.

Systemet skal foreslå profil baseret på brugerens input, men brugeren skal altid kunne justere eller selv definere prioriteter.

#### 3.8 Log-in og Bookmarking af modeller
Systemet skal understøtte at brugeren kan benytte siden uden at looge ind, ønsker brugeren at benytte nogle af de features der er tilegnet login, kan brugeren registrere sig og oprette et login, og/eller logge ind med et allerede eksisterende login brugernavn og password.

når en bruger er oprettet og logget ind skal vedkommende kunne "bookmark'e" unikke konfigurationer af maskiner baseret på deres "fingerprint"; disse skal kunne vises på en "bookmark"-side hvor brugerens gemte konfigurationer vil være.

---

### 4. Datakilder

#### 4.1 Offentlige specifikationer (primær datakilde ved lancering)
- Produktspecifikationer fra leverandørhjemmesider (CPU, GPU, RAM, SSD, batteri, vægt, skærm, pris).
- Offentlige garanti- og supportdokumenter (PDF'er fra leverandørers supportsider).

#### 4.2 Softwarekravsdatabase
- Kendt software med minimumskrav (Office 365, Adobe Creative Suite, AutoCAD, SQL Server m.fl.).

---

### 5. Afgrænsninger og begrænsninger

- Systemet er **ikke** en indkøbsportal – det faciliterer ikke selve købet, men understøtter beslutningsprocessen.
- Systemet har **ikke** adgang til leverandørers interne API'er, rabatstrukturer eller individuelle tilbudsdata. Al data er enten offentligt tilgængeligt.
- Systemet dækker i sin initiale version et udvalg af populære B2B-modeller (Lenovo ThinkPad, HP EliteBook, Dell Latitude) og kan udvides over tid.

---

### 6. Designprincipper

1. **Detaljer skal være tilgængelige, men ikke påtvungne.** Systemet viser som standard det detaljeringsniveau, der passer brugerens profil. Avancerede data er altid tilgængelige ét klik væk.
2. **Sammenligning skal være kontekstuel.** Når to modeller sammenlignes, skal systemet fremhæve de forskelle, der er relevante for brugerens profil og behov.
3. **Supportaftaler skal være eksplicitte.** Ikke "3 års garanti", men "3 års garanti på CPU og motherboard; 1 år på batteri; ingen dækning af fysisk skade."
4. **Trade-offs skal være synlige.** Brugeren skal aldrig forlade en sammenligning uden at forstå, hvad de vinder og taber ved et valg.
5. **Alternativer skal være synlige.** Systemet skal aktivt modvirke leverandørbias ved at vise ækvivalente produkter fra andre leverandører.
