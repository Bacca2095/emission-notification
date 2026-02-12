package org.microservices.notification_emission.infrastructure.output.database.oracle;

import jakarta.enterprise.context.ApplicationScoped;
import org.microservices.notification_emission.domain.model.Emission;
import org.microservices.notification_emission.domain.ports.repository.EmissionRepository;

import java.util.Optional;

@ApplicationScoped
public class EmissionOracleAdapter implements EmissionRepository {


    @Override
    public Optional<Emission> find(String id) {
        return Optional.empty();
    }
}
