# volley-manager

Volleyball Team Manager

Dieses Projekt soll es einem Volleyball-Verein ermöglichen möglichst einfach alle Daten zu verwalten. Es basiert auf Java/Spring-Boot für das Backend und Angular für das Frontend. Als Datenbank wird mysql verwendet.

Folgende Funktionalitäten sind geplant:

- Verwaltung von Mitgliederdaten (Spieler/innen, Trainer/innen, Administrator/innen)
- Verwaltung von Anlässen (Trainings, Spiele)

Das Packet basiert auf Java 17.

Ein paar Postman comands um das API zu testen:
https://www.getpostman.com/collections/d0025a19e309e78f03f1

## ToDos

Karin:
- Refactor to english
- Datumsangaben für alle Objekte in der DB (siehe BaseEntity.java;)
- Objekt Event
- Objekt Eventteilnahmen
- Objekt Eltern

Daniel:
- Testklassen

Nice to have:
- Spring Security

## Zugriff auf H2-Konsole (bei aktivem H2 Profil)

Der Inhalt der DB kann wie folgt betrachtet werden:

[http://localhost:8080/h2-console ](http://localhost:8080/h2-console)

<br>

![h2-console.png](readme/h2-console.png)

<br>

![h2-db.jpg](readme/h2-db.jpg)

<br>
