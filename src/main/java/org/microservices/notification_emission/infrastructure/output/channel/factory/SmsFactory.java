package org.microservices.notification_emission.infrastructure.output.channel.factory;

import jakarta.enterprise.context.ApplicationScoped;
import org.microservices.notification_emission.domain.ports.channel.ChannelNotificationSender;
import org.microservices.notification_emission.infrastructure.output.channel.impl.SmsChannelNotificationSender;

@ApplicationScoped
public class SmsFactory implements ChannelNotificationSenderAbstractFactory{

    private final SmsChannelNotificationSender smsSender;

    public SmsFactory(SmsChannelNotificationSender smsSender) {
        this.smsSender = smsSender;
    }

    @Override
    public ChannelNotificationSender createSender() {
        return smsSender;
    }
}
