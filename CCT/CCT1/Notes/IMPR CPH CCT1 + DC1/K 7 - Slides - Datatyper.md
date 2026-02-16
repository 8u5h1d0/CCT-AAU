---
tags:
  - C
  - IMPR
  - CCT1
Topic: Datatyper i C
Semester: CCT1
Course: IMPR1
Litterature:
  - https://people.cs.aau.dk/%7Enormark/impr-c/types.html
Created: 02-11-2025
---
- - -
## Table of Contents
- [[#Typer|Typer]]
- [[#Typer i C|Typer i C]]
- [[#Forskellige typer|Forskellige typer]]
	- [[#Forskellige typer#Datatyper - Tabel|Datatyper - Tabel]]
	- [[#Forskellige typer#Implicit type-konvertering|Implicit type-konvertering]]
	- [[#Forskellige typer#Eksplicit type-konvertering|Eksplicit type-konvertering]]
- [[#Abstrakte Datatyper|Abstrakte Datatyper]]
# Typer
> [!abstract] Type
> En _type_ er en mængde af værdier med fælles egenskaber.
> 
> - Forbedre læsbarhed & forståelighed
> - Generere bedre og mere effektiv kode
> - Gør det muligt at opdage fejl
# Typer i C
ANSI C har en relativ løs skelnen mellem værdier i forskellige typer.

- Boolean er indlejret i numeriske typer
	- 0 er ``false``, alt andet er ``true``
- ``char`` er et heltalsinterval
- Enumeration er heltalstyper

- De fleste numeriske typer kan implicit konverteres til hinanden

- - -
> [!example] Boolean gennem ``int``
```C
#include <stdio.h>

int is_even(int i){
    return i % 2 == 0;
}

int main(void){
    int n;
    
    printf("Enter an integer:\n");
    scanf("%d", &n);
    
    if (is_even(n))
        printf("%d er lige\n", n);
    else
        printf("%d er ulige\n", n);
        
	return 0;
}
```
i ``is_even`` retuneres et Boolean (``true``/``false``) svar/værdi alt efter det indtastede tal er lige eller ulige.
	selve funktionen kigger kun på om tallet er lige.

> [!example] ``char`` er en heltalstype
```C
#include <stdio.h>

int main(void){
	int i = 65;
	char ch = 'a';
	
	printf("i = %d, i = %c\n", i, i);
	printf("ch = %d, ch = %c\n", ch, ch);
	
	return 0;
}
```
når ``i`` og ``ch`` udskkrives som både et tal ``%d`` og en tegn ``%c``, ses det at værdien '65' kan ses som båden en talværdi = 65 *og* en ASCII for tegnet 'A' = 65. Det samme gør sig gældende for tegnet 'a', der kan printes som talværdien af sin ASCII værdi = 97, eller tegnet selv 'a'.
```C
i = 65, i = A
ch = 97, ch = a
```
Disse ASCII værdier kan manipuleres præcist på samme fod som almindelig ``int``.

> [!example] Enum konstanter er heltal
```C
#include <stdio.h>

enum color {
    red,    // 0
    green,  // 1
    blue    // 2
};

int main(void){
	enum color c = red;
	
	printf("c = %d\n", c);
	printf("c+1 = %d\n", c+1);
	printf("c+2 = %d\n", c+2);
	
	return 0;
}
```
``c`` er en variable er typen ``enum color``, sat til samme værdi som ``red``.
``c`` can udskrives- og manipuleres som, et heltal (``%d``).

> [!example] En type kan implicit konverteres til en anden
```C
#include <stdio.h>

enum color {
    red,    // 0
    green,  // 1
    blue    // 2
};

int main(void){
	enum color c1 = green, c2;
	int i1 = 10, i2;
	double d1 = 123.456, d2;

	c2 = d1;
	i2 = d1;
	d2 = c1;

	printf("c2 = %d\n", c2);
	printf("i2 = %d\n", i2);
	printf("d2 = %d\n", d2);

	return 0;
}
```
``double`` tallet *d1* kan konverteres til ``enum color`` "farven" *'123'* i *c2* variablen.
``double`` tallet *d1* kan konverteres til ``int`` tallet *123* i *I2* variablen.
``enum color`` "farven" *green = 1*, kan konverteres til ``double`` tallet 1.000... i *d2* variablen.

- - -
# Forskellige typer
- void
- Skalar typer
	- numeriske typer
		- Heltal
			- ``short int``, ``int``, ``long int``, ``char``
			- Enum typer
		- Reelle tal (float typer)
			- ``float``, ``double``, ``long double``
		- pointer typer
- Sammensatte typer
	- Array typer
		- tekststrenger
	- record typer (``struct``)
> [!summary]- Hurtig guide til valg af datatype
>- **For heltal:** Start med `int`. 
>Brug `unsigned int`, hvis værdien ikke kan være negativ. 
>Brug `long long`, hvis du skal håndtere meget store tal.
>- **For tal med decimaler:** Start med `double`. 
>Brug kun `float`, hvis hukommelse er en kritisk begrænsning.
>- **For enkelte tegn:** Brug `char`.
>- **Til gruppering af relateret data:** Brug en `struct`.
>- **Til lister af samme data:** Brug et `array`.
>- **Til et fast sæt af navngivne muligheder:** Brug en `enum`.
## Datatyper - Tabel

| Kategori            | Datatype Navn                       | Typisk Størrelse (bytes) | Værdi-række / "Værdi"                                                                                                                         | Almindelige Anvendelsesområder                                                                                                           | `printf` / `scanf` Syntaks                                                        |
| :------------------ | :---------------------------------- | :----------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------- | :-------------------------------------------------------------------------------- |
| **Heltal**          | `char`<br>`unsigned char`           | 1                        | **signed:** -128 til 127<br>**unsigned:** 0 til 255<br>*(Note: Om en almindelig `char` er `signed` eller `unsigned` afhænger af compileren.)* | **signed:** Små heltal.<br>**unsigned:** Rå byte-data, små positive tal, pixel-værdier.                                                  | `%c` (tegn)<br>`%hhd` (signed)<br>`%hhu` (unsigned)                               |
|                     | `short`<br>`unsigned short`         | 2                        | **signed:** -32.768 til 32.767<br>**unsigned:** 0 til 65.535                                                                                  | **signed:** At spare hukommelse på små tal.<br>**unsigned:** Tællere, der aldrig kan være negative.                                      | `%hd` (signed)<br>`%hu` (unsigned)                                                |
|                     | `int`<br>`unsigned int`             | 4                        | **signed:** -2.147.483.648 til 2.147.483.647<br>**unsigned:** 0 til 4.294.967.295                                                             | **signed:** **Standardvalget** for heltal, når negative tal er en mulighed.<br>**unsigned:** ID-numre, array-størrelser, tællere, alder. | `%d` (signed)<br>`%u` (unsigned)                                                  |
|                     | `long`<br>`unsigned long`           | 4 eller 8                | **signed:** (Varierer, typisk samme som `int` eller `long long`)<br>**unsigned:** (Varierer)                                                  | **signed:** Når du har brug for en større rækkevidde end `int`.<br>**unsigned:** Store tællere, hukommelsesadresser (når de udskrives).  | `%ld` (signed)<br>`%lu` (unsigned)                                                |
|                     | `long long`<br>`unsigned long long` | 8                        | **signed:** (Meget stor, ≈ -9 x 10¹⁸ til 9 x 10¹⁸)<br>**unsigned:** (Meget stor, ≈ 0 til 1.8 x 10¹⁹)                                          | **signed:** Ekstremt store heltalsberegninger (f.eks. i videnskab).<br>**unsigned:** 64-bit flags, meget store filstørrelser.            | `%lld` (signed)<br>`%llu` (unsigned)                                              |
| **Flydende-komma**  | `float`                             | 4                        | ~6-7 decimalers præcision.                                                                                                                    | Når hukommelse er en bekymring, men brøktal er nødvendige.                                                                               | `%f`                                                                              |
|                     | `double`                            | 8                        | ~15-16 decimalers præcision.                                                                                                                  | **Standardvalget** for tal med decimalpunkter.                                                                                           | `%f` (for `printf`), `%lf` (for `scanf`)                                          |
|                     | `long double`                       | 10, 12 eller 16          | Endnu højere præcision end `double`.                                                                                                          | Specialiserede videnskabelige applikationer.                                                                                             | `%Lf`                                                                             |
| **Afledt**          | `array`                             | `N * sizeof(type)`       | En sekvens af elementer af samme type.                                                                                                        | Opbevaring af lister af data.                                                                                                            | Bruger elementets syntaks (f.eks. `%d` for `int[]`). `%s` for `char[]` (strenge). |
|                     | `pointer`                           | 4 eller 8                | Gemmer en hukommelsesadresse.                                                                                                                 | Dynamisk hukommelse, datastrukturer.                                                                                                     | `%p`                                                                              |
|                     | `struct`                            | Summen af dens medlemmer | Grupperer variable af forskellige typer.                                                                                                      | Repræsentation af virkelighedsobjekter.                                                                                                  | Hvert medlem udskrives/indlæses individuelt med sin egen syntaks.                 |
| **Special**         | `void`                              | N/A                      | "Ingen type" eller "tom".                                                                                                                     | Funktions-returtype, generiske pointere.                                                                                                 | N/A (har ingen direkte syntaks)                                                   |
| **Brugerdefineret** | `enum`                              | `int` (normalt 4)        | Et sæt af navngivne heltalskonstanter.                                                                                                        | Gør kode mere læsbar.                                                                                                                    | Syntaksen for den underliggende type (oftest `%d`).                               |

> [!Warning] Mht. ``typedef``
> `typedef` opretter ikke en ny datatype; det opretter et **alias** (et nyt navn) for en eksisterende. Dette bruges til at gøre kode mere læsbar og portabel.

>[!warning] Vigtig forskel for `double` 
>Der er en klassisk fælde i C:
>- Med **`printf`** skal du bruge `%f` til både `float` og `double`.
>- Med **`scanf`** skal du bruge `%f` til `float` og `%lf` til `double`.
>
>>**Hvorfor?**
> `printf` promoterer automatisk `float` til `double`, så `%f` virker for begge. `scanf` skal derimod gemme en værdi i en variabel, så den har brug for at vide den præcise størrelse. `lf` fortæller den, at den skal skrive til en `double` (8 bytes), mens `f` fortæller den at skrive til en `float` (4 bytes).
## Implicit type-konvertering
- Integral promotion
	- ``short`` eller ``char`` værdier konverteres til ``int``:
		hvis *x* og *y* er ``short``værdier, så er *x + y* en ``int`` værdi.
- Widening
	- Konvertering af en mindre præcis værdi, til en tilsvarende mere præcis, så begge operander får samme type
	- der mistes ikke information
- Narrowing
	- kovertering af mere præcis værrdi til en mindre præcis
	- der mistes information
## Eksplicit type-konvertering
> Typecast/Cast

```C
//Typecast syntax
(typeName)expression
```
'typeName' = '()' med typenavn i, dette er selve "typeCast'et"
'expression' = det der bliver konverteret er værdien af det efterfølgende udtryk

værdien af 'expression' bliver konverteret til at tilhøre typeCast'et

- - -

> [!example] Eksempel
```C
#include <stdio.h>

int main(void){
	long int y;
	float x;
	double z;
	char c = 'A';
	
	y = (long) (c);
	x = (float) ((int) y + 1);
	z = (double) (x);
	
	printf("y: %li, x: %f, z: %f", y, x, z);
	
	return 0;
}
```
I ``y`` bliver typen af *c* (``char``) konverteret til typen ``long``.
I ``x`` bliver typen af *y* (``long int``) konverteret først til typen ``int`` (en 'narrowing' af y) hvor der så bliver foretaget en additions operation, og efterfølgende til typen ``float``.
I ``z`` bliver typen af *x* (``float``) koverteret til ``double`` (en 'widening' af x).

- - -
# Abstrakte Datatyper
En _abstrakt datatype_ er en mængde af værdier og en tilhørende mængde af operationer på disse værdier. 
	Abstrakte er oftest brugt i objekt-orienteret programmering.

