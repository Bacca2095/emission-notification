package org.microservices.notification_emission.application.servcice;

import jakarta.enterprise.context.ApplicationScoped;
import org.microservices.notification_emission.application.servcice.dto.SendEmissionNotificationRequest;
import org.microservices.notification_emission.application.servcice.dto.SendEmissionNotificationResponse;
import org.microservices.notification_emission.application.qualifier.ChannelAdapter;
import org.microservices.notification_emission.domain.model.Emission;
import org.microservices.notification_emission.domain.model.VehicleRegistration;
import org.microservices.notification_emission.domain.model.vo.ShippingChannel;
import org.microservices.notification_emission.domain.ports.channel.ChannelNotificationSender;
import org.microservices.notification_emission.domain.ports.repository.EmissionRepository;
import org.microservices.notification_emission.domain.ports.repository.NotificationEmissionRepository;

@ApplicationScoped
public class SendEmissionNotificationService implements SendEmissionNotificationUseCase{

    private final EmissionRepository emissionRepository;
    private final NotificationEmissionRepository notificationEmissionRepository;
    private final ChannelNotificationSender channelNotificationSender;

    public SendEmissionNotificationService(EmissionRepository emissionRepository, NotificationEmissionRepository notificationEmissionRepository,
                                           @ChannelAdapter ChannelNotificationSender channelNotificationSender) {
        this.emissionRepository = emissionRepository;
        this.notificationEmissionRepository = notificationEmissionRepository;
        this.channelNotificationSender = channelNotificationSender;
    }

    @Override
    public SendEmissionNotificationResponse execute(SendEmissionNotificationRequest request) {
        var vehicleRegistration = VehicleRegistration.create("ABC123",true,"12345");
        var emission = emissionRepository.find(request.getEmissionId().toString()).orElse(Emission.create(
                1L,2L, vehicleRegistration
        ));
        var emissionNotification = channelNotificationSender.send(emission, ShippingChannel.fromValue(request.getShippingChannel().name()));
        notificationEmissionRepository.save(emissionNotification);
        return null;
    }
}
