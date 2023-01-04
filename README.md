# racoon.java

<a href="https://github.com/LouiDev/racoon.java/packages/1762840">![Latest Version](https://img.shields.io/badge/Latest%20Release-0.0.1--SNAPSHOT-yellow)</a>
<a href="https://www.guilded.gg/i/kamW6l4k">![Guilded](https://img.shields.io/badge/Guilded%20Server-Join-yellow)</a>
![Guilded](https://img.shields.io/badge/Java-17-yellow)

# Introduction
Racoon.java is a libraray which prvides
- 50 racoon images
- 20 racoon baby images
- 20 racoon facts

Facts are currently available in theese languages:
``German``
``English``

# Installation (Maven)
Add this dependency to your pom.xml:
```xml
<dependency>
  <groupId>org.racoonLib.Racoon.java</groupId>
  <artifactId>racoon.java</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```

# Documentation
In order to access the data, create a ``DataManager()`` object:
```Java
DataManager manager = new DataManager();
```
When using ``get`` methods from ``DataManager`` you will either get ``RacoonImage`` / ``RacoonImageList`` or ``RacoonFact`` / ``RacoonFactList`` objects.
All of theese objects have seperate methods to access the pure data.
You can see a list of methods for each object below.
DataManager has the following methos:
```Java
DataManager#getAllImages()            -> Returns: RacoonImageList with every image
DataManager#getAllNormalImages()      -> Returns: RacoonImageList with every normal image
DataManager#getAllBabyImages()        -> Returns: RacoonImageList with every baby image
DataManager#getRandomImage()          -> Returns: RacoonImage with a random image
DataManager#getRandomNormalImage()    -> Returns: RacoonImage with a random normal image
DataManager#getRandomBabyImage()      -> Returns: RacoonImage with a random baby image
DataManager#getAllFacts(language)     -> Returns: RacoonFactList with every fact
DataManager#getRandomFact(language)   -> Returns: RacoonFact with a random fact
```

# RacoonImage
```
RacoonImage#asString() -> Returns the containing image as a String URL
RacoonImage#asImage()  -> Returns the containing image as an Image
RacoonImage#asURI()    -> Returns the containing image as an URI
RacoonImage#asURL()    -> Returns the containing image as an URL
```
Same goes with ``RacoonImageList`` but instead of a single result, the methods return an ``ArrayList`` containing the images as a ``String`` / ``Image`` / ``URI`` / ``URL``.

# RacoonFact
```
RacoonFact#asString()  -> Returns the containing fact as a String
```
Same goes with ``RacoonFactList`` but instead of a single result, the methods return an ``ArrayList`` containing the facts as a ``String``.
