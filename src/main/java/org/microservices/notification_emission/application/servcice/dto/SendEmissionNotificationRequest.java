package org.microservices.notification_emission.application.servcice.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.microservices.notification_emission.application.servcice.dto.data.ShippingChannel;
import org.microservices.notification_emission.application.servcice.dto.data.VehicleRegistrationDto;

@Getter
public class SendEmissionNotificationRequest {

    @NotNull(message = "El identificador de la emision es obligatorio")
    Long emissionId;

    @NotNull(message = "El tipo de canal de envio es obligatorio. ejemplo: WEBSERVICE")
    ShippingChannel shippingChannel;

    @NotNull(message = "Los datos de la matricula del vehiculo son obligatorios")
    @Valid
    VehicleRegistrationDto vehicleRegistration;


}
