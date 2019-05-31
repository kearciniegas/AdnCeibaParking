Este bloque contiene la estructura necesaria para construir un proyecto en java favoreciendo el enfoque de DDD. 

Los principales patrones y estilos de arquitectura que guían este bloque son

#### Arquitectura hexagonal
Arquitectura que fomenta  que nuestro dominio sea el núcleo de todas las capas, también conocida como puertos y adaptadores en la cual el dominio define los puertos y en las capas superiores se definen los adaptadores para desacoplar el dominio. Se divide princialmente en tres capas, **aplicación**, **dominio** e **infraestructura**
- **Infraestructura**: Capa que tiene las responsabilidades de realizar los adaptadores a los puertos definidos en el domino, exponer web services, consumir web services, realizar conexiones a bases de datos, ejecutar sentencias DML, en general todo lo que sea implementaciones de cualquier framework
- **Aplicación**: capa encargada de enrutar los eventos entrantes de la capa de infraestructura hacía la capa del dominio, generalmente se conoce como una barrera transaccional la cual agrupa toda la invocación de un caso de uso, se pueden encontrar patrones como Fabricas, Manejadores de Comandos, Bus de eventos, etc 
- **Dominio**: representa toda la lógica de negocio de la aplicación la cual es la razón de existir del negocio. Se busca evitar el anti-patron [https://martinfowler.com/bliki/AnemicDomainModel.html](https://martinfowler.com/bliki/AnemicDomainModel.html)  y favorecer el principio [https://martinfowler.com/bliki/TellDontAsk.html](https://martinfowler.com/bliki/TellDontAsk.html) en esta capa se pueden encontrar los siguientes patrones agregados, servicios de dominio, entidades, objetos de valor, repositorios (puerto), etc. 

Para obtener mas documentación sobre este tipo de arquitectura se recomienda [https://codely.tv/blog/screencasts/arquitectura-hexagonal-ddd/](https://codely.tv/blog/screencasts/arquitectura-hexagonal-ddd/)

#### Patrón CQRS:  
Patrón con el cual dividimos nuestro modelo de objetos en dos, un modelo para consulta y un modelo para comando (modificación de datos). Este patrón es recomendado cuando se va desarrollar lógica de negocio compleja porque nos ayuda a separar las responsabilidades y a mantener un modelo de negocio consistente. 

 - **Consulta**: modelo a través del cual se divide la responsabilidad para presentar datos en la interfaz de usuario, los objetos se modelan basado en lo que se va a presentar y no en la lógica de negocio, ejm: ver facturas, consultar clientes
 - **Comando**: son todas las operaciones que cambian el estado del sistema, ejm: (facturar, aplicar descuento), este modelo se construye todo el modelo de objetos basado en la lógica de negocio de la aplicación  

Para mayor documentación del patrón [https://martinfowler.com/bliki/CQRS.html](https://martinfowler.com/bliki/CQRS.html)

#### Especificaciones técnicas: 

 - Spring boot 2.1.2
 - Flayway -> administrar todos los script DDL e iniciliazadores de la bd 
 - Integración con Jenkins: Jenkins File
 - Integración con Sonar: Sonar properties
 - Acceso a la base de datos por medio de JDBC template
 - Se entregan pruebas de muestra automatizadas para cada una de las capas 
 - Pruebas de carga de ejemplo en el directorio microservicio/external-resources
 - Ejemplo de como modelar un Comando y un Query
 - Ejemplo de pruebas de integración con H2
 - Java 8
 - Se debe tener configurado el IDE con Lombok, descargar desde (https://projectlombok.org/download)

#### Estructura del proyecto: 
Se identifican dos carpetas principales, común y microservicio. Microservicio es la carpeta que contiene todo el código fuente para el primer microservicio de su proyecto, se recomienda cambiar el nombre de esta carpeta por la de su lógica de negocio y posteriormente modificar el archivo *settings.gradle*,  si necesita crear mas microservicios lo único que debe realizar es duplicar esta carpeta y realizar la modificación en el archivo *settings.gradle*. El proyecto común contiene código fuente que comparten todos los microservicios y capas, es una librería que importan los que requieran este código compartido, es importante tener en cuenta que no debe ir código de negocio en este lugar. 
Como cada microservicio se va realizar con CQRS, cada uno contiene su propia estructura de arquitectura hexagonal en la cual no se comparten los modelos.

#### Importar el proyecto:
Para importar el proyecto se recomienda usar Gradle en la versión 5.0, se debe importar desde la ruta *microservicio/build.gradle*
Después de importar el proyecto se queda viendo de la siguiente manera 

![enter image description here](https://drive.google.com/uc?id=1x2ZVpM2steX0Er-jDNoffQ_V6pRVdW0k)


*Cualquier duda o aporte con este bloque contactar a juan.botero@ceiba.com.co o juan.castano@ceiba.com.co*

# CeibaEstacionamiento
Estacionamiento

Consiste en un sistema que simula el comportamiento del vigilante de un parqueadero, las reglas de negocio son las siguientes:

El parqueadero recibe carros y motos 
El parqueadero solo puede tener 20 carros y 10 motos simultaneamente
Las placas que inician por la letra "A" solo pueden ingresar al parqueadero los días Domingo y Lunes, de lo contrario debe mostrar un mensaje de que no esta autorizado a ingresar.
La tabla de precios es la siguiente:
Valor hora carro = 1000
Valor hora moto = 500
valor día carro = 8000
valor día moto = 4000
Las motos que tengan un cilindraje mayor a 500 CC paga 2000 de mas al valor total.
Cuando sale un carro del parqueadero se cobra por horas si permaneció menos de 9 horas en el parqueadero, de lo contrario se cobra por días.
El valor del día comienza entre las 9 horas de parqueo y finaliza pasadas 24 horas de parqueo.
El parqueadero funciona 24 horas, los 7 días de la semana.
EJEMPLOS: 
*Si el carro permaneció un día y 3 horas se debe cobrar 11.000
*Si la moto permaneció un 10 horas y es de 650CC se cobra 6.000   

 

 

Metas:

primer entregable:

parte de backend construida (con arquitectura hexagonal)

pruebas unitarias al dominio (con test data builder y patron 3a)

pruebas de integracion al controlador (usando mock mvc)

jenkins y sonar (que se vea cobertura (jacoco) y deuda técnica)

 

segundo entregable:

backend construido
pruebas unitarias al dominio
pruebas de integracion
pruebas de carga
front construido
orueba funcional con protractor
clean code, arquitectura
sonar, deuda tecnica, cobertura, calidad prueba.  