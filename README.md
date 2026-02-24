# PoolObject

[![Java CI build](https://github.com/RuAQuin/poolobject/actions/workflows/Java17CImaven.yml/badge.svg)](https://github.com/RuAQuin/poolobject/actions/workflows/Java17CImaven.yml) 
[![codecov](https://codecov.io/gh/RuAQuin/poolobject/graph/badge.svg)](https://app.codecov.io/gh/RuAQuin/poolobject)


## - Autores
* **Carlos Lopez Nozal** (Autor original)
* **Jesus Alonso Abad** (Autor original)
* **Sandra Romero Núñez** (srn1002@alu.ubu.es)
* **Rodrigo Pascual Arnaiz** (rpa1004@alu.ubu.es)
* **Maksim Pitinov** (mpx1019@alu.ubu.es)
* **Rubén Alonso Quintana** (raq1002@alu.ubu.es)

## - Enlaces
* **Repositorio GitHub:** [https://github.com/RuAQuin/poolobject.git](https://github.com/RuAQuin/poolobject.git)
* **Métricas en Codecov:** [https://app.codecov.io/gh/RuAQuin/poolobject](https://app.codecov.io/gh/RuAQuin/poolobject)

---

## - Enunciado
En la práctica se va a simular un pequeño desarrollo de un producto software para realizar mediciones sobre él. 
El objetivo es establecer un caso de estudio *dummy* que sirva para caracterizar y evaluar tanto el producto desarrollado como el proceso colaborativo seguido. 
En concreto, el producto software es un código de test y el proceso es el análisis de la cobertura de pruebas en el tiempo.

## - Objetivos
* Comprender, aplicar y analizar técnicas de medición sobre entidades de productos software relacionados con conjuntos de pruebas de software e integración continua.
* Comprender, aplicar y analizar medidas relacionadas sobre entidades de proceso y recursos de prueba del software e integración continua.

---

## - Cuestiones

**1. ¿Se ha realizado trabajo en equipo?** 

Sí, los 4 participantes del grupo han ido realizando commits en función de cómo se ha considerado que se podía mejorar la calidad del código con el objetivo de alcanzar un coverage alto en Codecov. Además, aunque no sea visible en el repositorio, también se han llevado a cabo varias conversaciones por un grupo de WhatsApp para acordar el desarrollo de los casos de prueba y la división del trabajo.


**2. ¿Tiene calidad el conjunto de pruebas disponibles?** 

Sí, la calidad del conjunto ha alcanzado una cobertura del **100%**.
La cobertura detallada se puede ver en el siguiente enlace: [Codecov - poolobject](https://app.codecov.io/gh/RuAQuin/poolobject).
Queremos destacar que los *commits* se han realizado poco a poco para ver cómo ha ido mejorando la cobertura del código *commit* a *commit*.


**3. ¿Cuál es el esfuerzo invertido en realizar la actividad?** 

Se ha invertido un tiempo aproximado de 2 horas en aprender los conceptos que aparecen en los tutoriales, 30 minutos en configurar GitHub, entre 1 y 2 horas por alumno en desarrollar los casos de prueba, y otros 30 minutos en redactar el informe de la práctica.

**4. ¿Cuál es el número de fallos encontrados en el código original?** 

*releaseReusable()* esta función tiene un pequeño error esta comprueba que no introduzcas el mismo objeto dos veces, pero no comprueba si el pool ya está lleno así que si ya estaba lleno y le pasamos un nuevo objeto el vector pasara a ser de 3.

**5. ¿El proceso de integración continua realizado ha sido de calidad?**  
Si. Hemos establecido un *pipeline* de Integración Continua (CI) en GitHub Actions. Cada vez que un integrante realizaba un commit o push al repositorio, se disparaban automáticamente los workflows configurados (compilación, ejecución de tests automatizados y coverage). Esto nos ha proporcionado una retroalimentación inmediata sobre la salud del código. Gracias a la monitorización de Codecov en este mismo pipeline, hemos asegurado que todo nuevo código integrado mantenía o mejoraba los estándares de cobertura exigidos por el proyecto. Todos los workflows tras los commits han dado resultados positivos y, en caso de que hubiera habido alguno negativo, habríamos tratado de corregir el error antes de desarrollar el siguiente caso de prueba.