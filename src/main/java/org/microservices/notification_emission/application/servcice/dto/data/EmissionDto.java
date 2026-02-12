package org.microservices.notification_emission.application.servcice.dto.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class EmissionDto {

    @NotNull
    public Long id;

    @NotNull
    public Long insurance;

    @NotNull
    @Valid
    public VehicleRegistrationDto vehicleRegistration;

}
