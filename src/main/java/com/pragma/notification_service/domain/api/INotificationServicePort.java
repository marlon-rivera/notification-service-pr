package com.pragma.notification_service.domain.api;

public interface INotificationServicePort {

    void sendConfirmationCode(Long idOrder, String phoneNumber);

}
