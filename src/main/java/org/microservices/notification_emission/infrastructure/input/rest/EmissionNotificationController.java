package org.microservices.notification_emission.infrastructure.input.rest;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.microservices.notification_emission.application.servcice.SendEmissionNotificationUseCase;
import org.microservices.notification_emission.application.servcice.dto.SendEmissionNotificationRequest;

@Path("/notification")
@RequestScoped
public class EmissionNotificationController {

    private final SendEmissionNotificationUseCase sendEmissionNotification;

    public EmissionNotificationController(SendEmissionNotificationUseCase sendEmissionNotification) {
        this.sendEmissionNotification = sendEmissionNotification;
    }

    @POST
    @Path("/")
    public Response sendEmissionNotification(SendEmissionNotificationRequest request) {
        sendEmissionNotification.execute(request);
        return Response.ok().build();
    }
}
