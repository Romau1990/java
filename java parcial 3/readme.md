## Proyecto de juego de supervivencia
##### Rodrigo Alvarez  

### Planteamiento general

Pasaré a explicar como funciona mi codigo 

La idea fue tomada de varios juegos de supervivencia que hay actualmente en el mercado, como por ejemplo, days gone, Project Zomboid y 7 days to die entre otros. El concepto es simple, sobrevivir la mayor cantidad de días (turnos) utilizando recursos que uno mismo puede ir crafteando u obteniendo de diferentes sitios. En mi juego, dichos sitios estan basados en diferentes areas explorables del juego que podemos revisar a través de un mapa [comando mapa]. En el viaje el personaje podrá hacer uso de todos los items en su mochila, sin embargo, debe tener ciertas consideraciones. Los items son limitados, tienen peso y algunos requieren de ciertos pasos previos para poder ser utilizados, como por ejemplo la carne cruda, la cual debe ser previamente cocinada para ser consumida. Por otra parte, el jugador se expondra a diferentes riesgos tales como, enemigos, problemas de estado de salud, por ello, el jugador debe estar siempre atento a su estado de salud, hidratación, hambre, energía, etc. 
El jugador también contará con un sistema de perks, los cuales permitiran mejorar al personaje permitiendole acceder a mejoras que facilitarán el viaje y su capacidad de resistir a las adversidades del juego.  
Dado a que gran parte del juego funciona a través de la consola bajo el uso de comandos Scanner, he decidido que la mejor opción sería agregar colores llamativos que permitieran mejorar la legibilidad de los comandos y rompieran con la monotonía cromática. Ejemplo de esto es el menú, el cual se encuentra siempre presente en color cyan. 

La forma que consideré pertinente para diseñar mi juego fue a través del uso de clases estáticas con la finalidad de simplificar el código pero a su vez mantenerlo lo más organizado posible. El juego aún se encuentra en desarrollo y con mucho camino por recorrer. 

### planteamiento técnico ###

El main de mi juego es el:

```
Juego.java
```
Este es el encargado de unificar todas las clases y ejecutar la lógica de las mismas. La idea de trabajar clases fue simplificar lo más posible la construcción del main para que fuera lo más acotado y claro posible. 

Por otra parte contamos con una clase 

```
Jugador.java
```
Esta busca establecer los comandos básicos que el jugador podrá usar a través de la aventura tales como: esconderse, verMochila, curarse, etc.

```
ListadoItems.java
```
Básicamente busca almacenar todos los items del juego, a través de tres ArrayList. El primero *ArrayList Armas<>* almacena todos los items considerados como armas, esto se debe a que los itemes categorizados como armas poseen propiedades propias tales como daño minimo y daño máximo, así como también durabilidad.  
Otro *ArrayList Items<>* esta enfocado en todos los items consumibles que no son usados para el combate sino como apoyo en el mismo o fuera de el. 

Finalmente el tercer y ultima clase la cual es abstracta y servirá de plantilla padre tanto para Item como para Armas, esta tiene el nombre de ObjItem.


 **Herramientas usadas**
 
 - git
 - gitHub
 - Java
 - chatGpt