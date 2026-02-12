package org.microservices.notification_emission.infrastructure.output.channel.factory;

import org.microservices.notification_emission.domain.ports.channel.ChannelNotificationSender;

public interface ChannelNotificationSenderAbstractFactory {

    ChannelNotificationSender createSender();

}
