package org.microservices.notification_emission.infrastructure.output.channel.factory;

import jakarta.enterprise.context.ApplicationScoped;
import org.microservices.notification_emission.domain.model.vo.ShippingChannel;

@ApplicationScoped
public class ChannelFactoryProvider {

    private final WsFactory wsFactory;
    private final EmailFactory emailFactory;
    private final SmsFactory smsFactory;

    public ChannelFactoryProvider(WsFactory wsFactory, EmailFactory emailFactory, SmsFactory smsFactory) {
        this.wsFactory = wsFactory;
        this.emailFactory = emailFactory;
        this.smsFactory = smsFactory;
    }

    public ChannelNotificationSenderAbstractFactory getFactory(ShippingChannel channel){
        return switch (channel){
            case WEBSERVICE -> wsFactory;
            case EMAIL -> emailFactory;
            case SMS -> smsFactory;
        };
    }
}
