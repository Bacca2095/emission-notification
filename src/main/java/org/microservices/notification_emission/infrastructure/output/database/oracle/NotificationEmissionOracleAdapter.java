package org.microservices.notification_emission.infrastructure.output.database.oracle;

import jakarta.enterprise.context.ApplicationScoped;
import org.microservices.notification_emission.domain.model.EmissionNotification;
import org.microservices.notification_emission.domain.ports.repository.NotificationEmissionRepository;

import java.util.Optional;

@ApplicationScoped
public class NotificationEmissionOracleAdapter implements NotificationEmissionRepository {


    @Override
    public void save(EmissionNotification emissionNotification) {

    }

    @Override
    public Optional<EmissionNotification> find(Long id) {
        return Optional.empty();
    }
}
