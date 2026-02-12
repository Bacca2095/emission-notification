package org.microservices.notification_emission.application.servcice;

import org.microservices.notification_emission.application.servcice.dto.SendEmissionNotificationRequest;
import org.microservices.notification_emission.application.servcice.dto.SendEmissionNotificationResponse;

public interface SendEmissionNotificationUseCase {

    SendEmissionNotificationResponse execute(SendEmissionNotificationRequest request);
}
