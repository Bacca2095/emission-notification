package org.microservices.notification_emission.domain.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum ShippingChannel {

    WEBSERVICE("WEBSERVICE"),
    EMAIL("EMAIL"),
    SMS("SMS");

    private static final Map<String, ShippingChannel> BY_VALUE = new HashMap<>();
    private final String value;

    static {
        for (ShippingChannel shippingChannel : values()) {
            BY_VALUE.put(shippingChannel.value, shippingChannel);
        }
    }

    ShippingChannel(String value) {
        this.value = value;
    }

    public static ShippingChannel fromValue(String value) {
        ShippingChannel shippingChannel = BY_VALUE.get(value.trim().toUpperCase());
        if(shippingChannel == null){
            throw new IllegalArgumentException("Tipo de canal de envio no encontrado, valor: "+value);
        }
        return shippingChannel;
    }

    public String getValue() {
        return value;
    }
}
