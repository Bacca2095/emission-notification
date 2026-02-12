package org.microservices.notification_emission.infrastructure.output.channel.factory;

import jakarta.enterprise.context.ApplicationScoped;
import org.microservices.notification_emission.domain.ports.channel.ChannelNotificationSender;
import org.microservices.notification_emission.infrastructure.output.channel.impl.EmailChannelNotificationSender;

@ApplicationScoped
public class EmailFactory implements ChannelNotificationSenderAbstractFactory{

    private final EmailChannelNotificationSender emailSender;

    public EmailFactory(EmailChannelNotificationSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public ChannelNotificationSender createSender() {
        return emailSender;
    }
}
