package org.microservices.notification_emission.domain.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum StatusNotification {

    SUCCESSFUL(1, "SUCCESSFUL", "Exitoso"),
    PENDING(2, "PENDING", "Pendiente"),
    FAILED(3, "FAILED", "Fallido");

    private static final Map<Integer, StatusNotification> BY_ID = new HashMap<>();
    private static final Map<String, StatusNotification> BY_VALUE = new HashMap<>();
    private final Integer id;
    private final String value;
    private final String description;

    static {
        for (StatusNotification statusNotification : values()) {
            BY_ID.put(statusNotification.id, statusNotification);
            BY_VALUE.put(statusNotification.value, statusNotification);
        }
    }

    StatusNotification(Integer id, String value, String description) {
        this.id = id;
        this.value = value;
        this.description = description;
    }

    public static StatusNotification fromId(Integer id) {
        StatusNotification status = BY_ID.get(id);
        if (status == null) {
            throw new IllegalArgumentException("El Identificador [" + id + "] de notificacion es desconocido");
        }
        return status;
    }

    public static StatusNotification fromValue(String value) {
        StatusNotification status = BY_VALUE.get(value.trim().toUpperCase());
        if (status == null) {
            throw new IllegalArgumentException("El valor [" + value + "] de notificacion es desconocido");
        }
        return status;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
