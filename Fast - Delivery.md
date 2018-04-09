# Fast - Delivery

## Info
Es wird eine MySQL - Datenbank verwendet:

``` 
<jta-data-source>java:/mysql</jta-data-source> 
```

Die Website ist unter localhost:8080/mini/ zu erreichen!

## Aufgabe

Es sollen Kunden, Waren- & Aufträge verwaltet werden können. 

Die Website ist in 3 Komponenten eingeteilt:
 - Warenverwaltung mit sortieren und globaler suche
 - Kundenverwaltung mit sortieren und globeler suche
 - Auftragserstellung

Alle 3 Komponenten können über ein Panel auf und zugeklappt werden

 ![](overview.png)

## Warenverwaltung:

![](ware.png)
Es können Waren angelegt werden mit einem Name, einer Beschreibung und einem Gewicht.

## Kundenverwaltung:

![](kunden.png)


## Auftragsverwaltung:

Bei der Auftragserstellung kann ein Kunde ausgewählt, dann die Ware die befördert werden soll hinzugefügt und dann noch das Ziel der Lieferung eingegeben werden.


## Auftragsansicht

Es wird eine neue Seite geben die eine Liste aller Aufträge anzeigt und bei Auswählen einen Mark in einer Google Maps anzeigt! (NOCH NICHT IMPLEMENTIERT)