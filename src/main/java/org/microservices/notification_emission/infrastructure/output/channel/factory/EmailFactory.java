package org.microservices.notification_emission.infrastructure.output.channel.factory;

import jakarta.enterprise.context.ApplicationScoped;
import org.microservices.notification_emission.domain.ports.channel.ChannelNotificationSender;
import org.microservices.notification_emission.infrastructure.output.channel.impl.email.MailpitChannelNotificationSender;

@ApplicationScoped
public class EmailFactory implements ChannelNotificationSenderAbstractFactory{

    private final MailpitChannelNotificationSender emailSender;

    public EmailFactory(MailpitChannelNotificationSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public ChannelNotificationSender createSender() {
        return emailSender;
    }
}
