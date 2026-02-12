# emission-notification

Servicio de notificacion de emisiones de polizas. Expone un caso de uso para enviar notificaciones por diferentes canales y persiste el registro de la notificacion.

## Tecnologias
- Java 21
- Quarkus 3
- Maven
- Hibernate ORM
- Jakarta Validation
- Oracle JDBC

## Arquitectura y patrones
- Arquitectura hexagonal: separacion clara entre dominio, aplicacion e infraestructura.
- Tell, Don't Ask en el dominio: los objetos de dominio validan su propio estado.
- Abstract Factory en infraestructura: selecciona el canal de envio (webservice, email, sms) de forma desacoplada.

## Estructura del proyecto
```
src/main/java/org/microservices/notification_emission
├── application
│   ├── qualifier
│   │   └── ChannelAdapter.java
│   └── servcice
│       ├── SendEmissionNotificationService.java
│       ├── SendEmissionNotificationUseCase.java
│       └── dto
│           ├── SendEmissionNotificationRequest.java
│           ├── SendEmissionNotificationResponse.java
│           └── data
│               ├── EmissionDto.java
│               ├── ShippingChannel.java
│               └── VehicleRegistrationDto.java
├── domain
│   ├── model
│   │   ├── Emission.java
│   │   ├── EmissionNotification.java
│   │   ├── VehicleRegistration.java
│   │   └── vo
│   │       ├── Plaque.java
│   │       ├── ShippingChannel.java
│   │       └── StatusNotification.java
│   ├── ports
│   │   ├── channel
│   │   │   └── ChannelNotificationSender.java
│   │   ├── dao
│   │   └── repository
│   │       ├── EmissionRepository.java
│   │       └── NotificationEmissionRepository.java
│   └── service
│       └── NotificationEmissionDomainService.java
└── infrastructure
    ├── configuration
    ├── exeptions
    ├── input
    │   ├── rest
    │   │   └── EmissionNotificationController.java
    │   └── sqs
    └── output
        ├── channel
        │   ├── ChannelNotificationAdapter.java
        │   ├── factory
        │   │   ├── ChannelFactoryProvider.java
        │   │   ├── ChannelNotificationSenderAbstractFactory.java
        │   │   ├── EmailFactory.java
        │   │   ├── SmsFactory.java
        │   │   └── WsFactory.java
        │   └── impl
        │       ├── EmailChannelNotificationSender.java
        │       ├── SmsChannelNotificationSender.java
        │       └── WsChannelNotificationSender.java
        └── database
            └── oracle
                ├── EmissionOracleAdapter.java
                ├── NotificationEmissionOracleAdapter.java
                └── Entity
                    └── NotificationEmissionEntity.java
```

## Como correr el proyecto
Modo dev:
```bash
./mvnw quarkus:dev
```

Empaquetar:
```bash
./mvnw package
```

Ejecutar jar:
```bash
java -jar target/quarkus-app/quarkus-run.jar
```

Tests:
```bash
./mvnw test
```
