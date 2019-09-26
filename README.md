# ISA


Projekat: Aviokompanija

Biblioteke koje su koriš?ene:
Kompletan spisak u  pom.xml  fajlu
1. Spring Boot 2.0.4.RELEASE
2. Spring Boot Starter Security
3. MySQL Connector Java
4. JSON Web Token
5. Project Lombok
6. Spring Boot Test
7. JUnit
8. JUnit Jupiter
9. JSON Library(javax.json)
10. FasterXML Jackson Datatype
11. Spring Boot Starter Data
12. Spring Boot Starter Data JPA
13. Mockito

Osobine:
Servisi u ovom projektu mogu  da izvrše:
1. Koriš?enje CRUD operacija
2. Komunikacija sa Angular aplikacijom(front endom) posredstvo REST tj. JSON servisa i kontrolera
3. Registracija korisnika
4. Logovanje korisnika
5. Izmene podataka na profilu korisnika 
6.  Dodavanje i brisanje prijatelja(drugih korisnika)
7. Potvrda ili odbijanje prijateljstva
8. Izmene na podacima aviokompanija
9. Dodavanje i izmene podataka letova(izmena osnovih tekstualnih podataka i izmene na mapi sedišta)
10. Brisanje letova
11. Rezervacija sedišta na letovima od strane korisnika
12. Brza rezervacija sedišta
13. Logovanje u svojstvu administratora
14. Pretraga letova po više parametara
Podešavanje i pokretanje projekta:

Potrebni alati:
  1.Eclipse JavaEE IDE
  2.Visual Studio Code
  3.MySQL Workbench

Nakon instaliranja alata, sledi podešavanje:
* U Eclipse alatu, potrebno je importovati projekat u workspace.  To se ?ini klikom na opciju File u toolbaru i nakon toga na opciju Import u slide meniju, nakon toga prona?ete Maven folder u spisku i izaberete opciju Existing Maven Project i u File Browseru selektujete airplane-isa folder. Stisnite na finish  tj.  File >> Import>>Maven>>Existing Maven Project >>airplane-isa
* Sada imate projekat importovan u Eclipse workspace-u. Naredni korak je instalacija Lombok biblioteke koja se nalazi na slede?em linku. Instalacija je jednostavna.
* Otvorite Visual Studio Code i u toolbaru izaberite opciju  File i u slide meniju Open Folder koja ?e otvoriti File Browser u kojem trebate u folder u kojem vam se nalazi projekat da selektujete airplane-fe folder.
* U toolbaru izaberite opciju Terminal i u slide bar-u opciju New Terminal. Otvori?e se terminalu u panelu sa desne strane File Explorer-a. U terminalu ukucajte npm install da bi se potrebne Angular zavisnosti instalirale. Nakon instalacije ukucajte u terminal ng serve za pokretanje Angular aplikacije
* Podešavanje MySql WorkBench-a: U glavnom prozoru, izabere ikonicu  +  pored MySqlConnections labele tj. start new connection. U dijalogu ukucajte ime svoje konekcije i podesite sifru. Izaberite opciju Test Connection u donjem delu prozora da biste potvrdili da je konekcija mogu?a. Pošto je konekcija podešena, ona se nalazi u glavnom prozoru pod imenom koje ste jos zadali. Izaberite svoju konekciju i u dijalogu ukucajte šifru koju ste izabrali.

* Pravljenje šeme i sql skripte:  U novootvorenom prozoru, u toolbaru sa ikonicama, ispod toolbara sa File i ostalim teksutalnim opcijama, prona?i opciju Create a new Schema on connected Server i u dijalogu joj dati ime aiplane_isa.



Pokretanje aplikacije:
* U Eclipse IDE, u projektu airplane-isa,  u src/main/java paketu prona?i com.ftn.isa paket i u njemu App.java fajl. Desnim klikom na App.java se otvara meni u kome izaberite opciju Run as>>Java Application. Sa?ekajte da se aplikacija pokrene u konzoli.
* U MySql WorkBench, u prozoru u kojem smo napravili šemu u toolbaru izaberite opciju FIle>>Run SQL script i u folderu projekta izaberite skripta sql. Ovaj postupak ce popuniti tablice osnovnim podacima

* U adress bar-u svog browser-a, ukucajte localhost:4200 i time ?ete pokrenuti celokupnu aplikaciju.




Autor: Radojčić Slaviša(slavisaa.radojcic@gmail.com)




