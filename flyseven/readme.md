Para levantar el servicio:

Opcion 1:

1- Abrirlo con intellijIDEA, y automaticamente se va a crear una configuracion con Spring Boot

2- Darle al boton de run 

Opcion 2:

1- Tener maven y java instalado (Con sus respectivos paths setteados)

2- Abrir un cmd y tipear (Esto va a instalar las dependencias necesarias del proyecto)

    mvn clean install
    
3- Luego tipear (Con esto va a correr una instancia de la aplicacion)

    mvn spring-boot:run
    
La aplicacion se va a levantar en el puerto 8080

    localhost:8080
    
Se pueden ver los endpoints disponibles entrando a

    http://localhost:8080/swagger-ui