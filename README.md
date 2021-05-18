## Backend Prospect 
Proyecto creado para el proceso de seleccion de Addi, el cual consta de un sistema de prospectos CRM. 

## Java Version
La version de java que se va a utilizar es la 11.0.5 basada en el OpenJDK.

## decisions, assumptions or improvements

## 1. assumptions:
 tuve una dificultad al momento de definir las entradas del ProspectRatingClient.getProspectQualification ya que no era claro para mí que información se debería enviar para que el sistema de calificación pueda entregarnos un resultado.

## 1. decisions
En este caso decidí basarme en el documento que me enviaron, donde se especifica enviar los resultados de la ejecución de los sistemas anteriores.

## 2. assumptions
Tuve alguna dificultad al momento de definir las excepciones, debido a que no era claro si quien calculaba la calificación era el encargado de armar y evaluar cada uno de los casos anteriores.

## 2. decisions
Tome la decision que en cada capa ya sea repository o rest se encargara de manejar su exception, ya que era el que conocía la existencia del objeto que se iba a devolver.


## 3. assumptions
Según lo entendido, no debemos hacer ni consumos de servicios, ni conexión a base de datos y tampoco exposición de servicios rest.

## 3. decisions
Tome la decision de no agregar ninguna librería de base de datos, tampoco de spring boot para exposición de servicios, sino que desde el main de la aplicación se haga la demostración de la app.


## 4. assumptions
Decision de respuesta del objeto Prospect donde nos muestra el resultado de la calificación


## 4. decisions
Tome la decision de devolver todos los resultados de la calificación ya sea true o false y el resultado del valor numérico, esto para que se permitiera evaluar los prospectos que no cumplieran con los requerimientos mínimos y se pudiera evidenciar su calificación final.


## Quality Project
![alt text](docs/sonar-prospect-addi.jpeg)


