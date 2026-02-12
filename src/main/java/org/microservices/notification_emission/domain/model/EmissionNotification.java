package org.microservices.notification_emission.domain.model;

import org.microservices.notification_emission.domain.model.vo.StatusNotification;

public class EmissionNotification {

    private final Long id;
    private final Emission emission;
    private final StatusNotification status;
    private final String message;

    private EmissionNotification(Long id, Emission emission, StatusNotification status, String message) {
        validateId(id);
        validateEmission(emission);
        validateStatus(status);
        this.id = id;
        this.emission = emission;
        this.status = status;
        this.message = message;
    }

    public static EmissionNotification create(Long id, Emission emission, StatusNotification status, String message){
        return new EmissionNotification(id, emission, status, message);
    }

    private void validateEmission(Emission emission) {
        if (emission == null) {
            throw new IllegalArgumentException("La emision de la poliza en obligatoria para notificar");
        }
    }

    private void validateId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El id de la notificacion emision es obligatorio");
        }
    }

    private void validateStatus(StatusNotification status) {
        if (status == null) {
            throw new IllegalArgumentException("El estado de la notificacion es obligatorio");
        }
    }

    public Long getId() {
        return id;
    }

    public Emission getEmission() {
        return emission;
    }

    public StatusNotification getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
