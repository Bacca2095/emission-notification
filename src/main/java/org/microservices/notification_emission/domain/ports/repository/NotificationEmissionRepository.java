package org.microservices.notification_emission.domain.ports.repository;

import org.microservices.notification_emission.domain.model.EmissionNotification;

import java.util.Optional;

public interface NotificationEmissionRepository {
    void save(EmissionNotification emissionNotification);
    Optional<EmissionNotification> find(Long id);
}
