package org.microservices.notification_emission.domain.ports.channel;

import org.microservices.notification_emission.domain.model.Emission;
import org.microservices.notification_emission.domain.model.EmissionNotification;
import org.microservices.notification_emission.domain.model.vo.ShippingChannel;

public interface ChannelNotificationSender {
    EmissionNotification send(Emission emission, ShippingChannel channel);
}
