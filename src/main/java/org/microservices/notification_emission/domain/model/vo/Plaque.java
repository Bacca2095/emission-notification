package org.microservices.notification_emission.domain.model.vo;

import java.util.regex.Pattern;

public record Plaque(String value) {

    private static final Pattern PLAQUE_CAR = Pattern.compile("^[A-Z]{3}\\d{3}$");  // Debe contener 3 letras comenzando y 3 numeros finalizando
    private static final Pattern PLAQUE_MOTO = Pattern.compile("^[A-Z]{3}\\d{2}[A-Z]$"); // Debe contener 3 letras 2 numeros y una letra finalizando

    public Plaque {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("La placa del vehiculo no puede ser null o vacía");
        }

        value = value.trim().toUpperCase();
        if (!PLAQUE_CAR.matcher(value).matches() && !PLAQUE_MOTO.matcher(value).matches()) {
            throw new IllegalArgumentException("La placa '" + value + "' no tiene un formato válido en Colombia");
        }
    }
}
