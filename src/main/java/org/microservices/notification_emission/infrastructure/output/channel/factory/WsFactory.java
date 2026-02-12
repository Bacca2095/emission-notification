package org.microservices.notification_emission.infrastructure.output.channel.factory;

import jakarta.enterprise.context.ApplicationScoped;
import org.microservices.notification_emission.domain.ports.channel.ChannelNotificationSender;
import org.microservices.notification_emission.infrastructure.output.channel.impl.WsChannelNotificationSender;

@ApplicationScoped
public class WsFactory implements ChannelNotificationSenderAbstractFactory{

    private final WsChannelNotificationSender webserviceSender;

    public WsFactory(WsChannelNotificationSender webserviceSender) {
        this.webserviceSender = webserviceSender;
    }

    @Override
    public ChannelNotificationSender createSender() {
        return webserviceSender;
    }
}
